import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;


public class Square extends Agent
{

    //defining the behaviour
    class SquareBehaviour extends CyclicBehaviour
    {
        @Override
        public void action()
        {
                ACLMessage request = blockingReceive();
                String msg_content = request.getContent();


                double num = Double.parseDouble(msg_content);
                double square = Math.pow(num, 2);


                ACLMessage reply = request.createReply();
                reply.setContent(Double.toString(square));
                send(reply);
        }
    }

    public void setup()
    {
        addBehaviour(new SquareBehaviour());
    }

}
