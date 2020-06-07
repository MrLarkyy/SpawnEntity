package me.mrlarkyy.entityspawning;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("spawnentity")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                if (args.length == 2){
                    if (args[0].equalsIgnoreCase("spawn")){

                        EntityType et = null;

                        try{
                            et = EntityType.valueOf(args[1].toUpperCase());

                        }
                        catch(IllegalArgumentException ex){
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c[!] Neplatny typ entity! &7(Napis /spawnentity list)"));

                            return false;
                        }
                        if (et != null && et.isSpawnable() && et != EntityType.ARROW && et != EntityType.PAINTING && et != EntityType.ITEM_FRAME){
                            Entity en = null;

                            try{
                                p.getWorld().spawnEntity(p.getLocation(), et);
                            }
                            catch (IllegalArgumentException ex){
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c[!] Neplatny typ entity! &7(Napis /spawnentity list)"));

                                return false;

                            }

                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fEntita &e%entity%&f byla spawnuta".replace("%entity%", en.toString())));

                        }
                        else {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c[!] Neplatny typ entity! &7(Napis /spawnentity list)"));
                        }

                    }
                    else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&6[!] &fPouziti: &e/spawnentity spawn <entity>"));
                    }


                }
                else if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("list")){

                        EntityType[] et = EntityType.values();
                        String listentit = "";

                        for (int i = 0; i <= et.length; i++ ){

                            if (et[i].isSpawnable() && et[i] != EntityType.PAINTING && et[i] != EntityType.ITEM_FRAME && et[i] != EntityType. ARROW){
                                listentit += et[i] + ", ";

                            }

                        }
                        p.sendMessage("Seznam Entit: " + listentit);

                    }
                    else {
                        p.sendMessage("Neplatny prikaz!");
                    }


                }

            }

        }


        return false;
    }
}
