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
    private Long myUserId;

    private String myName;

    public AbstractUser( String name, Long id )
    {
        myName = name;
        myUserId = id;
    }

    /**
     * It is better to init instance by AbstractUser(name, id), because the default userid is the user name's hashCode.
     * Different name can be same hashCode as userId, result to incorrect index in Collection framework
     * 
     * @param name
     */
    public AbstractUser( String name )
    {
        this( name, Long.valueOf( name.hashCode() ) );
    }

    public String getName()
    {
        return myName;
    }

    public void setName( String name )
    {
        myName = name;
    }

    public Long getUseId()
    {
        return myUserId;
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
            return abstractUser.getUseId().equals( this.getUseId() );
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return getUseId().hashCode();
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
