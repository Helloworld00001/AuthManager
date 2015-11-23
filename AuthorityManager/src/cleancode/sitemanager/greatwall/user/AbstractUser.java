package cleancode.sitemanager.greatwall.user;

import java.util.List;

import cleancode.sitemanager.greatwall.operation.Operation;
import cleancode.sitemanager.greatwall.role.Role;

/**
 * AbstractUser defines the framework general user
 * 
 * @author <a HREF="mailto:lincc2008520@163.com">Greatwall</a>
 */
public abstract class AbstractUser
{
    private String myName;

    public AbstractUser( String name )
    {
        myName = name;
    }

    public String getName()
    {
        return myName;
    }

    public void setName( String name )
    {
        myName = name;
    }

    public abstract boolean setRole( Role role );

    public abstract boolean revokeRole( Role role );

    public abstract List<Role> getRoles();

    public abstract List<Operation> getOperations();

    public abstract boolean canOperate( Operation operation );

    @Override
    public boolean equals( Object obj )
    {
        if( obj == this )
        {
            return true;
        }
        if( obj instanceof AbstractUser )
        {
            AbstractUser abstractUser = ( AbstractUser ) obj;
            return abstractUser.getName().equals( this.getName() );
        }
        return false;

    }

    @Override
    public int hashCode()
    {
        return getName().hashCode();
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
