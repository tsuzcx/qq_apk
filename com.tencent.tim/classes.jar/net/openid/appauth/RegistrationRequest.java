package net.openid.appauth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationRequest
{
  public static final String APPLICATION_TYPE_NATIVE = "native";
  private static final Set<String> BUILT_IN_PARAMS = AdditionalParamsProcessor.builtInParams(new String[] { "redirect_uris", "response_types", "grant_types", "application_type", "subject_type", "token_endpoint_auth_method" });
  static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
  static final String KEY_CONFIGURATION = "configuration";
  static final String PARAM_APPLICATION_TYPE = "application_type";
  static final String PARAM_GRANT_TYPES = "grant_types";
  static final String PARAM_REDIRECT_URIS = "redirect_uris";
  static final String PARAM_RESPONSE_TYPES = "response_types";
  static final String PARAM_SUBJECT_TYPE = "subject_type";
  static final String PARAM_TOKEN_ENDPOINT_AUTHENTICATION_METHOD = "token_endpoint_auth_method";
  public static final String SUBJECT_TYPE_PAIRWISE = "pairwise";
  public static final String SUBJECT_TYPE_PUBLIC = "public";
  @NonNull
  public final Map<String, String> additionalParameters;
  @NonNull
  public final String applicationType;
  @NonNull
  public final AuthorizationServiceConfiguration configuration;
  @Nullable
  public final List<String> grantTypes;
  @NonNull
  public final List<Uri> redirectUris;
  @Nullable
  public final List<String> responseTypes;
  @Nullable
  public final String subjectType;
  @Nullable
  public final String tokenEndpointAuthenticationMethod;
  
  private RegistrationRequest(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @NonNull List<Uri> paramList, @Nullable List<String> paramList1, @Nullable List<String> paramList2, @Nullable String paramString1, @Nullable String paramString2, @NonNull Map<String, String> paramMap)
  {
    this.configuration = paramAuthorizationServiceConfiguration;
    this.redirectUris = paramList;
    this.responseTypes = paramList1;
    this.grantTypes = paramList2;
    this.subjectType = paramString1;
    this.tokenEndpointAuthenticationMethod = paramString2;
    this.additionalParameters = paramMap;
    this.applicationType = "native";
  }
  
  public static RegistrationRequest jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotEmpty(paramString, "jsonStr must not be empty or null");
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  public static RegistrationRequest jsonDeserialize(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json must not be null");
    List localList = JsonUtil.getUriList(paramJSONObject, "redirect_uris");
    return new Builder(AuthorizationServiceConfiguration.fromJson(paramJSONObject.getJSONObject("configuration")), localList).setSubjectType(JsonUtil.getStringIfDefined(paramJSONObject, "subject_type")).setResponseTypeValues(JsonUtil.getStringListIfDefined(paramJSONObject, "response_types")).setGrantTypeValues(JsonUtil.getStringListIfDefined(paramJSONObject, "grant_types")).setAdditionalParameters(JsonUtil.getStringMap(paramJSONObject, "additionalParameters")).build();
  }
  
  private JSONObject jsonSerializeParams()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "redirect_uris", JsonUtil.toJsonArray(this.redirectUris));
    JsonUtil.put(localJSONObject, "application_type", this.applicationType);
    if (this.responseTypes != null) {
      JsonUtil.put(localJSONObject, "response_types", JsonUtil.toJsonArray(this.responseTypes));
    }
    if (this.grantTypes != null) {
      JsonUtil.put(localJSONObject, "grant_types", JsonUtil.toJsonArray(this.grantTypes));
    }
    JsonUtil.putIfNotNull(localJSONObject, "subject_type", this.subjectType);
    JsonUtil.putIfNotNull(localJSONObject, "token_endpoint_auth_method", this.tokenEndpointAuthenticationMethod);
    return localJSONObject;
  }
  
  @NonNull
  public JSONObject jsonSerialize()
  {
    JSONObject localJSONObject = jsonSerializeParams();
    JsonUtil.put(localJSONObject, "configuration", this.configuration.toJson());
    JsonUtil.put(localJSONObject, "additionalParameters", JsonUtil.mapToJsonObject(this.additionalParameters));
    return localJSONObject;
  }
  
  @NonNull
  public String jsonSerializeString()
  {
    return jsonSerialize().toString();
  }
  
  @NonNull
  public String toJsonString()
  {
    JSONObject localJSONObject = jsonSerializeParams();
    Iterator localIterator = this.additionalParameters.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      JsonUtil.put(localJSONObject, (String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localJSONObject.toString();
  }
  
  public static final class Builder
  {
    @NonNull
    private Map<String, String> mAdditionalParameters = Collections.emptyMap();
    @NonNull
    private AuthorizationServiceConfiguration mConfiguration;
    @Nullable
    private List<String> mGrantTypes;
    @NonNull
    private List<Uri> mRedirectUris = new ArrayList();
    @Nullable
    private List<String> mResponseTypes;
    @Nullable
    private String mSubjectType;
    @Nullable
    private String mTokenEndpointAuthenticationMethod;
    
    public Builder(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @NonNull List<Uri> paramList)
    {
      setConfiguration(paramAuthorizationServiceConfiguration);
      setRedirectUriValues(paramList);
    }
    
    @NonNull
    public RegistrationRequest build()
    {
      AuthorizationServiceConfiguration localAuthorizationServiceConfiguration = this.mConfiguration;
      List localList3 = Collections.unmodifiableList(this.mRedirectUris);
      List localList1;
      if (this.mResponseTypes == null)
      {
        localList1 = this.mResponseTypes;
        if (this.mGrantTypes != null) {
          break label78;
        }
      }
      label78:
      for (List localList2 = this.mGrantTypes;; localList2 = Collections.unmodifiableList(this.mGrantTypes))
      {
        return new RegistrationRequest(localAuthorizationServiceConfiguration, localList3, localList1, localList2, this.mSubjectType, this.mTokenEndpointAuthenticationMethod, Collections.unmodifiableMap(this.mAdditionalParameters), null);
        localList1 = Collections.unmodifiableList(this.mResponseTypes);
        break;
      }
    }
    
    @NonNull
    public Builder setAdditionalParameters(@Nullable Map<String, String> paramMap)
    {
      this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(paramMap, RegistrationRequest.BUILT_IN_PARAMS);
      return this;
    }
    
    @NonNull
    public Builder setConfiguration(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration)
    {
      this.mConfiguration = ((AuthorizationServiceConfiguration)Preconditions.checkNotNull(paramAuthorizationServiceConfiguration));
      return this;
    }
    
    @NonNull
    public Builder setGrantTypeValues(@Nullable List<String> paramList)
    {
      this.mGrantTypes = paramList;
      return this;
    }
    
    @NonNull
    public Builder setGrantTypeValues(@Nullable String... paramVarArgs)
    {
      return setGrantTypeValues(Arrays.asList(paramVarArgs));
    }
    
    @NonNull
    public Builder setRedirectUriValues(@NonNull List<Uri> paramList)
    {
      Preconditions.checkCollectionNotEmpty(paramList, "redirectUriValues cannot be null");
      this.mRedirectUris = paramList;
      return this;
    }
    
    @NonNull
    public Builder setRedirectUriValues(@NonNull Uri... paramVarArgs)
    {
      return setRedirectUriValues(Arrays.asList(paramVarArgs));
    }
    
    @NonNull
    public Builder setResponseTypeValues(@Nullable List<String> paramList)
    {
      this.mResponseTypes = paramList;
      return this;
    }
    
    @NonNull
    public Builder setResponseTypeValues(@Nullable String... paramVarArgs)
    {
      return setResponseTypeValues(Arrays.asList(paramVarArgs));
    }
    
    @NonNull
    public Builder setSubjectType(@Nullable String paramString)
    {
      this.mSubjectType = paramString;
      return this;
    }
    
    @NonNull
    public Builder setTokenEndpointAuthenticationMethod(@Nullable String paramString)
    {
      this.mTokenEndpointAuthenticationMethod = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.RegistrationRequest
 * JD-Core Version:    0.7.0.1
 */