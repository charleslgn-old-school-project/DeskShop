package com.deskshop.common.link;

import com.deskshop.common.metier.Magasin;
import com.deskshop.common.metier.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServerInterface extends Remote {
    void addObserver(ClientInterface o) throws RemoteException;
    void credit(double sum) throws RemoteException;
    int login(String mail, String psw) throws RemoteException;
    int createUser(Person user) throws RemoteException;

    List<Magasin> findAllMagasin()  throws RemoteException;
    List<Magasin> findMagasinByUser(int UserId)  throws RemoteException;
}
