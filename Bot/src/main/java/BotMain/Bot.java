package BotMain;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Bot {

    private Bot() throws Exception{
        JDABuilder jda = (JDABuilder) JDABuilder.createDefault("[Token]");
        jda.setStatus(OnlineStatus.ONLINE);
        jda.setActivity(Activity.watching("Atravez de los universos."));
        jda.addEventListeners(new Comandos());
        jda.build();
    }

    public static void main(String[] args) throws Exception{
        new Bot();
    }
}
