package BotMain;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;


public class Comandos extends ListenerAdapter {
    //Lista de comandos disponibles.
    private final String[] _Comandos = {"!estado","!info","!hola","!mona","!hack","!lista"};
    //Descripción de los comandos.
    private final String[] _Descripcion = {"<- Muestra el estado del Bot.",
                                           "<- Información general del Bot.",
                                           "<- Saludo.",
                                           "<- Muestra lo que pienso sobre la mona de la clase. ¯\\_(ツ)_/¯",
                                           "<- Te hackeo la cuenta.",
                                           "<- Muestra la lista de comandos."};


    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent evento) {

        //Para evitar un bucle de mensajes de bot. Comprobamos que sea un usuario el que ha enviado el mensaje.
        if (evento.getMessage().getAuthor().isBot()) return;

        //Llamamos a la función principal después de comprobar que el mensaje no haya sido escrito por un bot.
        funciPrincipal(evento);
    }

    //Inicio función principal

    private void funciPrincipal(GuildMessageReceivedEvent evento){
        //Comprobar si el mensaje empieza con el siguiente prefijo, en este caso uno de los elementos del arreglo.
        if(evento.getMessage().getContentRaw().startsWith(_Comandos[0])) estado(evento);
        if(evento.getMessage().getContentRaw().startsWith(_Comandos[1])) information(evento);
        if(evento.getMessage().getContentRaw().startsWith(_Comandos[2])) saludo(evento);
        if(evento.getMessage().getContentRaw().startsWith(_Comandos[3])) mona(evento);
        if(evento.getMessage().getContentRaw().startsWith(_Comandos[4])) hack(evento);
        if(evento.getMessage().getContentRaw().startsWith(_Comandos[5])) listaComandos(evento);
    }

    //Final funcion principal


    //Inicio funciones con comandos.

    private void estado(GuildMessageReceivedEvent evento){
        //Gesto de escribiendo...
        evento.getChannel().sendTyping().queue();
        //Mensaje enviado.
        evento.getChannel().sendMessage("¡Estoy vivo, pana!").queue();
    }

    private void information(GuildMessageReceivedEvent evento){
        evento.getChannel().sendTyping().queue();
        EmbedBuilder info = new EmbedBuilder(); //Creamos un objeto EmbedBuilder para escribir en un recuardro la info.

        //Lo identificamos con un titulo.
        info.setTitle("Informacion");

        //Le damos una descripcion
        info.setDescription("Bot hecho para pasar el rato, parce.\tSi quiere ver la lista de comandos, escribe !lista");

        //Le damos un pie de página.
        info.setFooter("Creado por: Zor3n", evento.getMessage().getAuthor().getAvatarUrl());

        //Le asignamos un color.
        info.setColor(0xA7EFD);

        evento.getChannel().sendTyping().queue();

        //Mandamos el Embed, literalmente, construyendolo.
        evento.getChannel().sendMessage(info.build()).queue();
        info.clear(); //Lo limpiamos.
    }

    private void saludo(GuildMessageReceivedEvent evento){
        evento.getChannel().sendTyping().queue();

        //Enviamos un saludo personalizado, obteniendo el autor del mensaje y atravez de este, su nombre.
        evento.getChannel().sendMessage("¡Saludos, "+evento.getMessage().getAuthor().getName()+"!").queue();
    }

    private void mona(GuildMessageReceivedEvent evento){
        evento.getChannel().sendTyping().queue();
        evento.getChannel().sendMessage("¡Qué bonita es! ( ͡° ͜ʖ ͡°) ").queue();
    }

    private void hack(GuildMessageReceivedEvent evento){
        evento.getChannel().sendTyping().queue();

        evento.getChannel().sendMessage("¡Ahora mismo, "+evento.getMessage().getAuthor().getName()+", te estoy" +
                " hackiando la cuenta! >:v").queue();
    }

    private void listaComandos(GuildMessageReceivedEvent evento){
        evento.getChannel().sendTyping().queue();

        //Construimos un Embed.
        EmbedBuilder info = new EmbedBuilder();

        //Asignamos un titulo.
        info.setTitle("Lista de comando: ");

        //Con un bucle, recorremos los dos vectores;
        // lo mostramos con appendDescription para poder hacerlo en varias lineas.
        for (int i = 0; i < _Comandos.length; i++) {
            info.appendDescription(_Comandos[i]+""+_Descripcion[i]+"\n");
        }

        //Le damos un pie de pagina.
        info.setFooter("¡Aquí tienes!", evento.getMessage().getAuthor().getAvatarUrl());

        //Le asignamos un color.
        info.setColor(0x0080FF);

        //Enviamos el Embed.
        evento.getChannel().sendMessage(info.build()).queue();
        info.clear();
    }

    //Final funciones con comandos.

}
