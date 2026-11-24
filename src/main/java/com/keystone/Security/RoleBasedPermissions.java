
package com.keystone.Security;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.keystone.Enum.Permissions;
import com.keystone.Enum.Role;

public class RoleBasedPermissions {

    public static Map<Role, Set<Permissions>> getRoleBasedPermissions() {

        Map<Role, Set<Permissions>> permission = new HashMap<>();

        // MANAGER
        permission.put(Role.MANAGER, new HashSet<>(Arrays.asList(
                Permissions.CREATE_USER,
                Permissions.UPDATE_USER,
                Permissions.VIEW_USER,
                Permissions.DELETE_USER,

                Permissions.CREATE_CUSTOMER,
                Permissions.UPDATE_CUSTOMER,
                Permissions.VIEW_CUSTOMER,
                Permissions.DELETE_CUSTOMER,

                Permissions.CREATE_SITE,
                Permissions.UPDATE_SITE,
                Permissions.VIEW_SITE,
                Permissions.DELETE_SITE,

                Permissions.CREATE_WO,
                Permissions.UPDATTE_WO,
                Permissions.VIEW_WO,
                Permissions.ASSIGN_WO,
                Permissions.CANCEL_WO,
                Permissions.CLOSE_WO,
                Permissions.DELETE_WO,

                Permissions.ADD_PARTS,
                Permissions.UPDATE_PARTS,
                Permissions.VIEW_PARTS,
                Permissions.USER_PARTS,
                Permissions.DELETE_PARTS,

                Permissions.ADD_TIME_LOGS,
                Permissions.VIEW_TIME_LOGS,

                Permissions.VIEW_DASHBOARD,
                Permissions.VIEW_RECORD,

                Permissions.SEND_NOTIFICATION
        )));

        // DISPATCHER
        permission.put(Role.DISPATCHER, new HashSet<>(Arrays.asList(
                Permissions.CREATE_CUSTOMER,
                Permissions.UPDATE_CUSTOMER,
                Permissions.VIEW_CUSTOMER,

                Permissions.CREATE_SITE,
                Permissions.UPDATE_SITE,
                Permissions.VIEW_SITE,

                Permissions.CREATE_WO,
                Permissions.UPDATTE_WO,
                Permissions.VIEW_WO,
                Permissions.ASSIGN_WO,

                Permissions.VIEW_DASHBOARD
        )));

        // TECHNICIAN
        permission.put(Role.TECHNICIAN, new HashSet<>(Arrays.asList(
                Permissions.LOGIN,
                Permissions.LOGOUT,
                Permissions.VIEW_WO,
                Permissions.VIEW_SITE,
                Permissions.START_WORK,
                Permissions.HOLD_WORK,
                Permissions.RESUME_WORK,
                Permissions.COMPLETE_WORK,
                Permissions.VIEW_PARTS,
                Permissions.USER_PARTS,
                Permissions.ADD_TIME_LOGS,
                Permissions.VIEW_TIME_LOGS
        )));

        // CUSTOMER
        permission.put(Role.CUSTOMER, new HashSet<>(Arrays.asList(
                Permissions.LOGIN,
                Permissions.LOGOUT,
                Permissions.RAISE_REQUEST,
                Permissions.VIEW_OWN_REQUEST
        )));

        return permission;
    }
}