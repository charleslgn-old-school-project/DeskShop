package com.deskshop.front.start;

import com.deskshop.common.link.ServerInterface;
import com.deskshop.front.util.ControllerUtils;
import com.sun.security.ntlm.Server;

import java.rmi.Naming;

public class Main {
    public static void main(String[] args) {
        try {

            ServerInterface remoteService = (ServerInterface) Naming.lookup("//localhost:4000/serverInterface");
            //remoteService.createShop("Rue du commerce !!", 2);
        } catch (Exception ex) {
            ControllerUtils.loadAlert("Erreur générale", ex.toString());
        }
    }
}
