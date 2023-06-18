package io.github.romvoid95.scg;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import io.github.romvoid95.scg.bot.SCGBot;
import io.github.romvoid95.scg.server.EventServer;
import io.github.romvoid95.scg.util.Env;
import lombok.Getter;

public final class SCGPlatform
{
    public static class Arguments
    {
        @Parameter(names = {"-t", "--token"}, description = "Your Discord authentication token")
        private String DISCORD_TOKEN;
        @Parameter(names = {"-h", "--hostname"}, description = "Hostname or IPv4 of the RethinkDB server")
        private String HOSTNAME;
        @Parameter(names = {"-d", "--database"}, description = "RethinkDb Database name")
        private String DATABASE;
        @Parameter(names = {"-u", "--user"}, description = "Username for the RethinkDB connection")
        private String USER;
        @Parameter(names = {"-p", "--pass"}, description = "Password for the RethinkDB user")
        private String PASSWORD;

        Map<String, String> getUsedArguments()
        {
            Map<String, String> arguments = new HashMap<>();
            for (Field f : Arguments.class.getDeclaredFields())
                try
                {
                    String name = f.getName();
                    String value = (String) f.get(null);
                    if (!value.isEmpty() || !(value == null))
                        arguments.put(name, value);
                } catch (IllegalArgumentException | IllegalAccessException e)
                {
                    e.printStackTrace();
                }
            return arguments;
        }
    }

    private static SCGPlatform _platform;
    
    public static SCGPlatform instance()
    {
        return _platform;
    }
    
    @Getter
    private final EventServer eventServer;
    @Getter
    private final SCGBot scgBot;
    
    SCGPlatform()
    {
        _platform = this;
        this.eventServer = new EventServer();
        this.scgBot = new SCGBot();
    }
    
    public static void main(String[] argv)
    {
        Arguments args = new Arguments();
        JCommander.newBuilder().addObject(args).build().parse(argv);
        new Env(args.getUsedArguments());
    }
}
