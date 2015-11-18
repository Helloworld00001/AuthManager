/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月5日/grelin                            
 */
package cleancode.sitemanager.greatwall.operation;


/**
 * CommonOperations
 * 
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 */
public class CommonOperations
{
    protected CommonOperations()
    {
    }

    public static Operation VIEW = new View();

    public static Operation ADD = new Add();

    public static Operation DELETE = new Delete();

    public static Operation UPDATE = new Update();

    private static class View implements Operation
    {

        @Override
        public String operate()
        {
            return "View";
        }

    }

    private static class Add implements Operation
    {

        @Override
        public String operate()
        {
            return "Add";
        }

    }

    private static class Delete implements Operation
    {

        @Override
        public String operate()
        {
            return "Delete";
        }

    }

    private static class Update implements Operation
    {

        @Override
        public String operate()
        {
            return "Update";
        }

    }
}
