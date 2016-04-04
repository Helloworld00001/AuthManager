package cleancode.sitemanager.greatwall.util;

import java.util.List;
import java.util.stream.Collectors;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.user.AbstractUser;

/**
 * This is utility for printing information in framework
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class PrinterUtil
{
    public static String getOperationListString( List<Operation> operationList )
    {
        if( operationList == null || operationList.isEmpty() )
        {
            return "[]";
        }

        return "[" +
            operationList.stream().map( operation -> operation.operate() ).collect( Collectors.joining( ", " ) ) + "]";
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
