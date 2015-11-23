package cleancode.sitemanager.greatwall.web.role;

import cleancode.sitemanager.greatwall.role.AbstractRole;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class Admin extends AbstractRole
{
    private static final String ROLE_NAME = "Admin";

    public Admin()
    {
        super( ROLE_NAME );
    }

}
