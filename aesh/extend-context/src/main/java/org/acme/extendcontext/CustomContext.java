package org.acme.extendcontext;

import java.util.logging.Logger;

public class CustomContext {

    //here we put in all the methods we expose in our CustomContext
    public Logger logger() {
        return null;
    }

    public String getAccessToMoreCustomStuff() {
        return null;
    }

    public String name() {
        return "Special Command Context";
    }
}
