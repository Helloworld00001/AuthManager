/*
 *  Copyright (c) 2015 Nokia. All rights reserved.
 *
 *  Revision History:
 *
 *  DATE/AUTHOR          COMMENT
 *  ---------------------------------------------------------------------
 *  2015年11月5日/grelin                            
 */
package cleancode.sitemanager.greatwall.web.role;

import cleancode.sitemanager.greatwall.role.AbstractRole;

/**
 * TODO:Write class description
 * @author <a HREF="mailto:yourMail@nsn.com">Your Name</a>
 *
 */
public class Member extends AbstractRole
{
    private static final String ROLE_NAME = "Member";

    public Member()
    {
        super( ROLE_NAME );
    }

}
