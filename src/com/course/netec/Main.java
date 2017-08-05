package com.course.netec;


import DataBase.ConnectDB;
import View.FormsView;

import javax.swing.*;
import java.sql.Connection;

public class Main {

    public static Connection connection;

    public static void main(String[] args) {


        init();

    }


    public static void init(){
        JFrame rootFrame = new JFrame("Agregar Credito");
        rootFrame.setSize(600,600);
        rootFrame.setContentPane(new FormsView().panel1);
        rootFrame.setVisible(true);
    }

}
