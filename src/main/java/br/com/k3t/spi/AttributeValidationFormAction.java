package br.com.k3t.spi;

import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormContext;
import org.keycloak.authentication.ValidationContext;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AttributeValidationFormAction implements FormAction {

    ObjectMapper mapper = new ObjectMapper();
    
    public static final String INVALID_ATTRIBUTE_MESSAGE_KEY_SUFFIX = ".error";
    
    @Override
    public void close() {
        // Not necessary.
    }

    @Override
    public void buildPage(FormContext context, LoginFormsProvider form) {
        // Not necessary.
    }

    @Override
    public void validate(ValidationContext context) {
        context.success();
    }
    
    @Override
    public void success(FormContext context) {
        // Not necessary.
    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        return false;
    }

    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        // Not necessary.
    }

}
