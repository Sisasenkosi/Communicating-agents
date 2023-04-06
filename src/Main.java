import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class Main

{
    public static void main(String[] args) {
        Runtime runtime = Runtime.instance();
        Profile p = new ProfileImpl();
        p.setParameter(Profile.MAIN_HOST, "localhost");
        p.setParameter(Profile.GUI, "true");
        p.setParameter(Profile.CONTAINER_NAME, "MainContainer");

        ContainerController container = runtime.createMainContainer(p);


        AgentController ac1;
        AgentController ac2;
        try
        {
            ac1 = container.createNewAgent("Sender", "Communicate", null);
                    ac1.start();
            ac2 = container.createNewAgent("Receiver", "Square", null);
                    ac2.start();
        }
        catch (StaleProxyException e)
        {
            e.printStackTrace();
        }
    }


}
