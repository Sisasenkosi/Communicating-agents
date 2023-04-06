import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Scanner;


public class Communicate extends Agent
{

    class ClientBehaviour extends CyclicBehaviour
    {
        @Override
        public void action()
        {
            //Ask the user to insert a number
            System.out.println("Enter a number...");

            Scanner scanner = new Scanner(System.in);

            String number = scanner.nextLine();

            //create a message



            //receiving the response

            ACLMessage response = blockingReceive();
            String content = response.getContent();
            System.out.println("The answer is " + content);

        }
    }
    public void setup()
    {
        addBehaviour(new ClientBehaviour());


        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        String number = "5";

        msg.setContent(number);
        msg.addReceiver(new AID("Receiver", AID.ISLOCALNAME));
        send(msg);

    }



}
