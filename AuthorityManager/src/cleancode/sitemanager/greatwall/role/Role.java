package cleancode.sitemanager.greatwall.role;

import java.util.List;

import cleancode.sitemanager.greatwall.operation.Operation;

/**
 * Role
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public interface Role
{
    public List<Operation> getOperations();

    public boolean addOperation( Operation operation );

    public boolean removeOperation( Operation operation );

}
