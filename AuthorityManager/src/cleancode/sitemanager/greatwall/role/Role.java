/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月5日/grelin                            
 */
package cleancode.sitemanager.greatwall.role;

import java.util.List;

import cleancode.sitemanager.greatwall.operation.Operation;

/**
 * Role
 * 
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 */
public interface Role
{
    public List<Operation> getOperations();

    public boolean addOperation( Operation operation );

    public boolean removeOperation( Operation operation );

}
