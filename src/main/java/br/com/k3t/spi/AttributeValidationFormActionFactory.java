package br.com.k3t.spi;

import java.util.ArrayList;
import java.util.List;

import org.keycloak.Config.Scope;
import org.keycloak.authentication.FormAction;
import org.keycloak.authentication.FormActionFactory;
import org.keycloak.models.AuthenticationExecutionModel.Requirement;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

public class AttributeValidationFormActionFactory implements FormActionFactory {

    private static final String PROVIDER_ID = "test-form-action-with-mlt";
    private static final FormAction INSTANCE = new AttributeValidationFormAction();
    
    @Override
    public FormAction create(KeycloakSession session) {
        return INSTANCE;
    }

    @Override
    public void init(Scope config) {
        // Not necessary.
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // Not necessary.
    }

    @Override
    public void close() {
        // Not necessary.
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getDisplayType() {
        return "Test Form Action With Multvalued List Type";
    }

    @Override
    public String getReferenceCategory() {
        return "test-form-action-with-mlt";
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Override
    public Requirement[] getRequirementChoices() {
        return new Requirement[] {Requirement.REQUIRED, Requirement.DISABLED};
    }

    @Override
    public boolean isUserSetupAllowed() {
        return false;
    }

    @Override
    public String getHelpText() {
        return "Tests a Multivalued List Type Bug";
    }

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = new ArrayList<>();
    
    public static final String BUILT_IN_VALIDATORS = "test.validators";
    
    static {
        ProviderConfigProperty config;
        
        config = new ProviderConfigProperty();
        config.setLabel("Test Built-in Validators");
        config.setName(BUILT_IN_VALIDATORS);
        config.setHelpText("Built-in validators that apply specific rules when the expected attribute(s) for the validator is found.");
        config.setType(ProviderConfigProperty.MULTIVALUED_LIST_TYPE);
        List<String> options = new ArrayList<>();
        options.add("Validator 1");
        options.add("Validator 2");
        config.setOptions(options);
        CONFIG_PROPERTIES.add(config);
        
    }
    
    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return CONFIG_PROPERTIES;
    }

}
