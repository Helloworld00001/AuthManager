package cleancode.sitemanager.greatwall.web.operation;

import cleancode.sitemanager.greatwall.operation.CommonOperations;
import cleancode.sitemanager.greatwall.operation.Operation;

/**
 * WebOperations
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class WebOperations extends CommonOperations
{
    public static Operation GET = ( ) -> "Get";

    public static Operation POST = ( ) -> "Post";

    private WebOperations()
    {
    }
}
