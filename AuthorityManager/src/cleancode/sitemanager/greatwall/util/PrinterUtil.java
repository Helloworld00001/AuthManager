/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月5日/grelin                            
 */
package cleancode.sitemanager.greatwall.util;

import java.util.List;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.user.AbstractUser;

/**
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 */
public class PrinterUtil
{
    public static String getOperationListString( List<Operation> operationList )
    {
        if( operationList.isEmpty() )
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append( "[" );
        for( Operation operation : operationList )
        {
            sb.append( operation.operate() ).append( ", " );
        }
        sb.delete( sb.length() - 2, sb.length() );
        sb.append( "]" );
        return sb.toString().trim();
    }

    public static void printAllUsersInformation( List<AbstractUser> usersList )
    {
        System.out.println( "Now all the users' information as below" );
        for( AbstractUser abstractUser : usersList )
        {
            String roles = "Roles:" + abstractUser.getRoles().toString();
            String operations = "Operations:" + getOperationListString( abstractUser.getOperations() );
            System.out.println( abstractUser + ":{" + roles + ", " + operations + "}" );
        }
        printSeperateLine();

    }

    public static void printSeperateLine()
    {
        System.out.println( "====================================================" );
    }

    public static void printCommandString( String command )
    {
        System.out.println( ">>>" + command );
    }

    public static void printCanUserExecuteOperation(AbstractUser user, Operation operation)
    {
        System.out.println( "Does '" + user + "' has the permission to do '" + operation.operate() + "' ? Answer is: " +
            ( user.getOperations().contains( operation ) ? "Yes" : "No" ) );
    }

    public static void printUserExistInFramework(AbstractUser user, boolean isExist)
    {
        System.out.println( "Does '" + user + "' exists? Answer is: " + ( isExist ? "Yes" : "No" ) );
    }

}
