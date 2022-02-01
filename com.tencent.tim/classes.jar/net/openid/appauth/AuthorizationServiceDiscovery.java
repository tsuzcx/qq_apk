package net.openid.appauth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationServiceDiscovery
{
  @VisibleForTesting
  static final JsonUtil.StringListField ACR_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.UriField AUTHORIZATION_ENDPOINT;
  @VisibleForTesting
  static final JsonUtil.StringListField CLAIMS_LOCALES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.BooleanField CLAIMS_PARAMETER_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField CLAIMS_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField CLAIM_TYPES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField DISPLAY_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField GRANT_TYPES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringField ISSUER = str("issuer");
  @VisibleForTesting
  static final JsonUtil.UriField JWKS_URI;
  private static final List<String> MANDATORY_METADATA = Arrays.asList(new String[] { ISSUER.key, AUTHORIZATION_ENDPOINT.key, JWKS_URI.key, RESPONSE_TYPES_SUPPORTED.key, SUBJECT_TYPES_SUPPORTED.key, ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED.key });
  @VisibleForTesting
  static final JsonUtil.UriField OP_POLICY_URI;
  @VisibleForTesting
  static final JsonUtil.UriField OP_TOS_URI;
  @VisibleForTesting
  static final JsonUtil.UriField REGISTRATION_ENDPOINT;
  @VisibleForTesting
  static final JsonUtil.StringListField REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.BooleanField REQUEST_PARAMETER_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.BooleanField REQUEST_URI_PARAMETER_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.BooleanField REQUIRE_REQUEST_URI_REGISTRATION;
  @VisibleForTesting
  static final JsonUtil.StringListField RESPONSE_MODES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField RESPONSE_TYPES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField SCOPES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.UriField SERVICE_DOCUMENTATION;
  @VisibleForTesting
  static final JsonUtil.StringListField SUBJECT_TYPES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.UriField TOKEN_ENDPOINT;
  @VisibleForTesting
  static final JsonUtil.StringListField TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField UI_LOCALES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.StringListField USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED;
  @VisibleForTesting
  static final JsonUtil.UriField USERINFO_ENDPOINT;
  @VisibleForTesting
  static final JsonUtil.StringListField USERINFO_SIGNING_ALG_VALUES_SUPPORTED;
  @NonNull
  public final JSONObject docJson;
  
  static
  {
    AUTHORIZATION_ENDPOINT = uri("authorization_endpoint");
    TOKEN_ENDPOINT = uri("token_endpoint");
    USERINFO_ENDPOINT = uri("userinfo_endpoint");
    JWKS_URI = uri("jwks_uri");
    REGISTRATION_ENDPOINT = uri("registration_endpoint");
    SCOPES_SUPPORTED = strList("scopes_supported");
    RESPONSE_TYPES_SUPPORTED = strList("response_types_supported");
    RESPONSE_MODES_SUPPORTED = strList("response_modes_supported");
    GRANT_TYPES_SUPPORTED = strList("grant_types_supported", Arrays.asList(new String[] { "authorization_code", "implicit" }));
    ACR_VALUES_SUPPORTED = strList("acr_values_supported");
    SUBJECT_TYPES_SUPPORTED = strList("subject_types_supported");
    ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED = strList("id_token_signing_alg_values_supported");
    ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED = strList("id_token_encryption_enc_values_supported");
    ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED = strList("id_token_encryption_enc_values_supported");
    USERINFO_SIGNING_ALG_VALUES_SUPPORTED = strList("userinfo_signing_alg_values_supported");
    USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED = strList("userinfo_encryption_alg_values_supported");
    USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED = strList("userinfo_encryption_enc_values_supported");
    REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED = strList("request_object_signing_alg_values_supported");
    REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED = strList("request_object_encryption_alg_values_supported");
    REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED = strList("request_object_encryption_enc_values_supported");
    TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED = strList("token_endpoint_auth_methods_supported", Collections.singletonList("client_secret_basic"));
    TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED = strList("token_endpoint_auth_signing_alg_values_supported");
    DISPLAY_VALUES_SUPPORTED = strList("display_values_supported");
    CLAIM_TYPES_SUPPORTED = strList("claim_types_supported", Collections.singletonList("normal"));
    CLAIMS_SUPPORTED = strList("claims_supported");
    SERVICE_DOCUMENTATION = uri("service_documentation");
    CLAIMS_LOCALES_SUPPORTED = strList("claims_locales_supported");
    UI_LOCALES_SUPPORTED = strList("ui_locales_supported");
    CLAIMS_PARAMETER_SUPPORTED = bool("claims_parameter_supported", false);
    REQUEST_PARAMETER_SUPPORTED = bool("request_parameter_supported", false);
    REQUEST_URI_PARAMETER_SUPPORTED = bool("request_uri_parameter_supported", true);
    REQUIRE_REQUEST_URI_REGISTRATION = bool("require_request_uri_registration", false);
    OP_POLICY_URI = uri("op_policy_uri");
    OP_TOS_URI = uri("op_tos_uri");
  }
  
  public AuthorizationServiceDiscovery(@NonNull JSONObject paramJSONObject)
    throws JSONException, AuthorizationServiceDiscovery.MissingArgumentException
  {
    this.docJson = ((JSONObject)Preconditions.checkNotNull(paramJSONObject));
    paramJSONObject = MANDATORY_METADATA.iterator();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if ((!this.docJson.has(str)) || (this.docJson.get(str) == null)) {
        throw new MissingArgumentException(str);
      }
    }
  }
  
  private static JsonUtil.BooleanField bool(String paramString, boolean paramBoolean)
  {
    return new JsonUtil.BooleanField(paramString, paramBoolean);
  }
  
  private <T> T get(JsonUtil.Field<T> paramField)
  {
    return JsonUtil.get(this.docJson, paramField);
  }
  
  private <T> List<T> get(JsonUtil.ListField<T> paramListField)
  {
    return JsonUtil.get(this.docJson, paramListField);
  }
  
  private static JsonUtil.StringField str(String paramString)
  {
    return new JsonUtil.StringField(paramString);
  }
  
  private static JsonUtil.StringListField strList(String paramString)
  {
    return new JsonUtil.StringListField(paramString);
  }
  
  private static JsonUtil.StringListField strList(String paramString, List<String> paramList)
  {
    return new JsonUtil.StringListField(paramString, paramList);
  }
  
  private static JsonUtil.UriField uri(String paramString)
  {
    return new JsonUtil.UriField(paramString);
  }
  
  public List<String> getAcrValuesSupported()
  {
    return get(ACR_VALUES_SUPPORTED);
  }
  
  @NonNull
  public Uri getAuthorizationEndpoint()
  {
    return (Uri)get(AUTHORIZATION_ENDPOINT);
  }
  
  public List<String> getClaimTypesSupported()
  {
    return get(CLAIM_TYPES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getClaimsLocalesSupported()
  {
    return get(CLAIMS_LOCALES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getClaimsSupported()
  {
    return get(CLAIMS_SUPPORTED);
  }
  
  @Nullable
  public List<String> getDisplayValuesSupported()
  {
    return get(DISPLAY_VALUES_SUPPORTED);
  }
  
  @NonNull
  public List<String> getGrantTypesSupported()
  {
    return get(GRANT_TYPES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getIdTokenEncryptionAlgorithmValuesSupported()
  {
    return get(ID_TOKEN_ENCRYPTION_ALG_VALUES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getIdTokenEncryptionEncodingValuesSupported()
  {
    return get(ID_TOKEN_ENCRYPTION_ENC_VALUES_SUPPORTED);
  }
  
  @NonNull
  public List<String> getIdTokenSigningAlgorithmValuesSupported()
  {
    return get(ID_TOKEN_SIGNING_ALG_VALUES_SUPPORTED);
  }
  
  @NonNull
  public String getIssuer()
  {
    return (String)get(ISSUER);
  }
  
  @NonNull
  public Uri getJwksUri()
  {
    return (Uri)get(JWKS_URI);
  }
  
  @Nullable
  public Uri getOpPolicyUri()
  {
    return (Uri)get(OP_POLICY_URI);
  }
  
  @Nullable
  public Uri getOpTosUri()
  {
    return (Uri)get(OP_TOS_URI);
  }
  
  @Nullable
  public Uri getRegistrationEndpoint()
  {
    return (Uri)get(REGISTRATION_ENDPOINT);
  }
  
  @Nullable
  public List<String> getRequestObjectEncryptionAlgorithmValuesSupported()
  {
    return get(REQUEST_OBJECT_ENCRYPTION_ALG_VALUES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getRequestObjectEncryptionEncodingValuesSupported()
  {
    return get(REQUEST_OBJECT_ENCRYPTION_ENC_VALUES_SUPPORTED);
  }
  
  public List<String> getRequestObjectSigningAlgorithmValuesSupported()
  {
    return get(REQUEST_OBJECT_SIGNING_ALG_VALUES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getResponseModesSupported()
  {
    return get(RESPONSE_MODES_SUPPORTED);
  }
  
  @NonNull
  public List<String> getResponseTypesSupported()
  {
    return get(RESPONSE_TYPES_SUPPORTED);
  }
  
  public List<String> getScopesSupported()
  {
    return get(SCOPES_SUPPORTED);
  }
  
  @Nullable
  public Uri getServiceDocumentation()
  {
    return (Uri)get(SERVICE_DOCUMENTATION);
  }
  
  @NonNull
  public List<String> getSubjectTypesSupported()
  {
    return get(SUBJECT_TYPES_SUPPORTED);
  }
  
  @Nullable
  public Uri getTokenEndpoint()
  {
    return (Uri)get(TOKEN_ENDPOINT);
  }
  
  @NonNull
  public List<String> getTokenEndpointAuthMethodsSupported()
  {
    return get(TOKEN_ENDPOINT_AUTH_METHODS_SUPPORTED);
  }
  
  @Nullable
  public List<String> getTokenEndpointAuthSigningAlgorithmValuesSupported()
  {
    return get(TOKEN_ENDPOINT_AUTH_SIGNING_ALG_VALUES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getUiLocalesSupported()
  {
    return get(UI_LOCALES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getUserinfoEncryptionAlgorithmValuesSupported()
  {
    return get(USERINFO_ENCRYPTION_ALG_VALUES_SUPPORTED);
  }
  
  @Nullable
  public List<String> getUserinfoEncryptionEncodingValuesSupported()
  {
    return get(USERINFO_ENCRYPTION_ENC_VALUES_SUPPORTED);
  }
  
  @Nullable
  public Uri getUserinfoEndpoint()
  {
    return (Uri)get(USERINFO_ENDPOINT);
  }
  
  @Nullable
  public List<String> getUserinfoSigningAlgorithmValuesSupported()
  {
    return get(USERINFO_SIGNING_ALG_VALUES_SUPPORTED);
  }
  
  public boolean isClaimsParameterSupported()
  {
    return ((Boolean)get(CLAIMS_PARAMETER_SUPPORTED)).booleanValue();
  }
  
  public boolean isRequestParameterSupported()
  {
    return ((Boolean)get(REQUEST_PARAMETER_SUPPORTED)).booleanValue();
  }
  
  public boolean isRequestUriParameterSupported()
  {
    return ((Boolean)get(REQUEST_URI_PARAMETER_SUPPORTED)).booleanValue();
  }
  
  public boolean requireRequestUriRegistration()
  {
    return ((Boolean)get(REQUIRE_REQUEST_URI_REGISTRATION)).booleanValue();
  }
  
  public static class MissingArgumentException
    extends Exception
  {
    private String mMissingField;
    
    public MissingArgumentException(String paramString)
    {
      super();
      this.mMissingField = paramString;
    }
    
    public String getMissingField()
    {
      return this.mMissingField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationServiceDiscovery
 * JD-Core Version:    0.7.0.1
 */