package cleancode.sitemanager.greatwall.web.role;

import cleancode.sitemanager.greatwall.role.AbstractRole;

/**
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public class SuperAdmin extends AbstractRole
{
    private static final String ROLE_NAME = "Super Admin";

    public SuperAdmin()
    {
        super( ROLE_NAME );
    }

}
