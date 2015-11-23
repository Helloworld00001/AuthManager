package cleancode.sitemanager.greatwall.operation;


/**
 * CommonOperations
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
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
