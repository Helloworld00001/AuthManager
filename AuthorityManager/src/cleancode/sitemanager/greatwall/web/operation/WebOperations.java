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
