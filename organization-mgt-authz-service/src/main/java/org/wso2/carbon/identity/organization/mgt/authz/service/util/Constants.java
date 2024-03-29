/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.organization.mgt.authz.service.util;

/**
 * Constants related to organization mgt authorization service and manager.
 */
public class Constants {

    public enum ErrorMessage {
        ERROR_NOT_AUTHORIZED("ORGUAUTH_00001", "Error occurred while retrieving the organization id."),
        ERROR_BAD_REQUEST("ORGUAUTH_00002","Error occurred due to bad request"),
        ERROR_FORBIDDEN_REQUEST("ORGUAUTH_00003","Error occured due to forbidden request.");

        private final String code;
        private final String message;

        ErrorMessage(String code, String message) {

            this.code = code;
            this.message = message;
        }

        public String getMessage() {

            return this.message;
        }

        public String getCode() {

            return this.code;
        }
    }

    // SQL Constants.
    public static final String GET_IS_USER_ALLOWED = "SELECT COUNT(1) FROM ORG_AUTHZ_VIEW\n" +
            "WHERE ORG_ID = ? AND UM_USER_ID = ? AND UM_TENANT_ID = ? AND \n" +
            "UM_DOMAIN_ID = (SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_DOMAIN_NAME = 'INTERNAL')";
    public static final String GET_IS_USER_ALLOWED_AT_LEAST_FOR_ONE_ORG = "SELECT COUNT(1) FROM ORG_AUTHZ_VIEW\n" +
            "WHERE UM_USER_ID = ? AND UM_TENANT_ID = ? AND \n" +
            "UM_DOMAIN_ID = (SELECT UM_DOMAIN_ID FROM UM_DOMAIN WHERE UM_DOMAIN_NAME = 'INTERNAL')";
    public static final String GET_ROOT_ORG_ID =   "SELECT\n" +
            "    DISTINCT ID\n" +
            "FROM\n" +
            "    UM_ORG\n" +
            "WHERE\n" +
            "    NAME = ? AND TENANT_ID = ?";

    public static final String AND = " AND ";
    public static final String OR = " OR ";
    public static final String PERMISSION_REQUIRED = "UM_RESOURCE_ID = ?";
    public static final String COUNT_COLUMN_NAME = "COUNT(1)";
    public static final String VIEW_ID = "ID";

    public static final String PERMISSION_SPLITTER = "/";
    public static final String URI_SPLITTER = "/";
    public static final String ORGANIZATION_RESOURCE = "organizations";
    public static final String SCIM_USERS_RESOURCE = "Users";
    public static final String REGEX_FOR_GET_ORG_BY_ORG_ID =
            "^(.)*(/api/identity/organization-mgt/v1.0/organizations/)[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}$";
    public static final String REGEX_FOR_URLS_WITH_ORG_ID =
            "^(.)*(/api/identity/organization-mgt/v1.0/organizations/)[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}(.)*$";
    public static final String REGEX_FOR_ADMIN_ROLE_ASSIGNMENT_REVOKE_AND_UPDATE =
            "^(.)*(/api/identity/organization-mgt/v1.0/organizations/)[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}(/roles)(.)*$";
    public static final String REGEX_FOR_ADMIN_ROLE_MEMBERS_GET =
            "^(.)*(/api/identity/organization-mgt/v1.0/organizations/)[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}(/roles/)(.)*(/users)(.)*$";
    public static final String REGEX_FOR_ORG_SEARCH = "^(.)*(/api/identity/organization-mgt/v1.0/organizations)(.)*$";
    public static final String ORG_ID_REGEX = "[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}";
    public static final String REGEX_FOR_SCIM_USER_REQUESTS =
            "^(.)*(/scim2/Users/)[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}(.)*$";
    public static final String ORGANIZATION_ID_DEFAULT_CLAIM_URI = "http://wso2.org/claims/organizationId";
    public static final String REGEX_FOR_SCIM_GROUPS_GET = "(.*)/scim2/Groups";
    public static final String REGEX_FOR_SCIM_GROUPS_GET_BY_ID =
            "^(.*)(/scim2/Groups/)[a-z0-9]{8}(-[a-z0-9]{4}){3}-[a-z0-9]{12}(.)*$";
    public static final String REGEX_FOR_SCIM_USERS_GET = "(.*)/scim2/Users(.*)";
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";
    public static final String HTTP_DELETE = "DELETE";
    public static final String HTTP_PATCH = "PATCH";
    public static final String ANY_ORG = "ANY";
    public static final String QUERY_STRING_SEPARATOR = "&";
    public static final String FILTER_START = "filter=";
    public static final String ORGANIZATION_ID_URI =
            "urn:ietf:params:scim:schemas:extension:enterprise:2.0:User.organization.id";
    public static final String ORGANIZATION_NAME_URI =
            "urn:ietf:params:scim:schemas:extension:enterprise:2.0:User.organization.name";
    public static final String EQ = "eq";
    public static final String CONDITION_SEPARATOR = "\\+";
    public static final String REGEX_SCIM_USERS_FILTER_WITH_ORG =
            "^(.)*(filter=)(.)*(" + ORGANIZATION_ID_URI + "|" + ORGANIZATION_NAME_URI + ")(.)*$";

    public static final String ERROR_RETRIEVING_ROOT_ID = "Error while retrieving the root organization id.";

    public static final String ORGANIZATION_MGT_ADMIN_PERMISSION = "/permission/admin/manage/identity/organizationmgt/admin";
}
