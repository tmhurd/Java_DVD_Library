/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary;

import com.sg.dvdlibrary.controller.DvdLibraryController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Terri
 */
public class App {
    public static void main(String[] args) {
    // UserIO myIO = new UserIoConsoleImpl();
    // DvdLibraryView myView = new DvdLibraryView(myIO);
    // DvdLibraryAuditDao myAuditDao = new DvdLibraryAuditDaoFileImpl();
    // DvdLibraryDao myDao = new DvdLibraryDaoFileImpl(myAuditDao);
    // DvdLibraryController controller = new DvdLibraryController(myDao, myView);
    // controller.run();
    
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    DvdLibraryController controller = ctx.getBean("controller", DvdLibraryController.class);
    controller.run();
    
    }
}
