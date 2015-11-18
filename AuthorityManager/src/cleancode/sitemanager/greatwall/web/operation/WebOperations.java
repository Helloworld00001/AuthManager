/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月5日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.operation;

import cleancode.sitemanager.greatwall.operation.CommonOperations;
import cleancode.sitemanager.greatwall.operation.Operation;

/**
 * WebOperations
 * 
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 */
public class WebOperations extends CommonOperations
{
    public static Operation GET = new Get();

    public static Operation POST = new Post();

    private WebOperations()
    {

    }

    private static class Get implements Operation
    {
        @Override
        public String operate()
        {
            return "Get";
        }

    }

    private static class Post implements Operation
    {

        @Override
        public String operate()
        {
            return "Post";
        }

    }
}
