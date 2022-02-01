package net.openid.appauth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenRequest
{
  private static final Set<String> BUILT_IN_PARAMS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "client_id", "code", "code_verifier", "grant_type", "redirect_uri", "refresh_token", "scope" })));
  public static final String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
  public static final String GRANT_TYPE_PASSWORD = "password";
  @VisibleForTesting
  static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
  @VisibleForTesting
  static final String KEY_AUTHORIZATION_CODE = "authorizationCode";
  @VisibleForTesting
  static final String KEY_CLIENT_ID = "clientId";
  @VisibleForTesting
  static final String KEY_CONFIGURATION = "configuration";
  @VisibleForTesting
  static final String KEY_GRANT_TYPE = "grantType";
  @VisibleForTesting
  static final String KEY_REDIRECT_URI = "redirectUri";
  @VisibleForTesting
  static final String KEY_REFRESH_TOKEN = "refreshToken";
  @VisibleForTesting
  static final String KEY_SCOPE = "scope";
  @VisibleForTesting
  static final String PARAM_CLIENT_ID = "client_id";
  @VisibleForTesting
  static final String PARAM_CODE = "code";
  @VisibleForTesting
  static final String PARAM_CODE_VERIFIER = "code_verifier";
  @VisibleForTesting
  static final String PARAM_GRANT_TYPE = "grant_type";
  @VisibleForTesting
  static final String PARAM_REDIRECT_URI = "redirect_uri";
  @VisibleForTesting
  static final String PARAM_REFRESH_TOKEN = "refresh_token";
  @VisibleForTesting
  static final String PARAM_SCOPE = "scope";
  @NonNull
  public final Map<String, String> additionalParameters;
  @Nullable
  public final String authorizationCode;
  @NonNull
  public final String clientId;
  @Nullable
  public final String codeVerifier;
  @NonNull
  public final AuthorizationServiceConfiguration configuration;
  @NonNull
  public final String grantType;
  @Nullable
  public final Uri redirectUri;
  @Nullable
  public final String refreshToken;
  @Nullable
  public final String scope;
  
  private TokenRequest(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @NonNull String paramString1, @NonNull String paramString2, @Nullable Uri paramUri, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @NonNull Map<String, String> paramMap)
  {
    this.configuration = paramAuthorizationServiceConfiguration;
    this.clientId = paramString1;
    this.grantType = paramString2;
    this.redirectUri = paramUri;
    this.scope = paramString3;
    this.authorizationCode = paramString4;
    this.refreshToken = paramString5;
    this.codeVerifier = paramString6;
    this.additionalParameters = paramMap;
  }
  
  @NonNull
  public static TokenRequest jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramString, "json string cannot be null");
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  @NonNull
  public static TokenRequest jsonDeserialize(JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json object cannot be null");
    Builder localBuilder = new Builder(AuthorizationServiceConfiguration.fromJson(paramJSONObject.getJSONObject("configuration")), JsonUtil.getString(paramJSONObject, "clientId")).setRedirectUri(JsonUtil.getUriIfDefined(paramJSONObject, "redirectUri")).setGrantType(JsonUtil.getString(paramJSONObject, "grantType")).setRefreshToken(JsonUtil.getStringIfDefined(paramJSONObject, "refreshToken")).setAuthorizationCode(JsonUtil.getStringIfDefined(paramJSONObject, "authorizationCode")).setAdditionalParameters(JsonUtil.getStringMap(paramJSONObject, "additionalParameters"));
    if (paramJSONObject.has("scope")) {
      localBuilder.setScopes(AsciiStringListUtil.stringToSet(JsonUtil.getString(paramJSONObject, "scope")));
    }
    return localBuilder.build();
  }
  
  private void putIfNotNull(Map<String, String> paramMap, String paramString, Object paramObject)
  {
    if (paramObject != null) {
      paramMap.put(paramString, paramObject.toString());
    }
  }
  
  @NonNull
  public Map<String, String> getRequestParameters()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("grant_type", this.grantType);
    localHashMap.put("client_id", this.clientId);
    putIfNotNull(localHashMap, "redirect_uri", this.redirectUri);
    putIfNotNull(localHashMap, "code", this.authorizationCode);
    putIfNotNull(localHashMap, "refresh_token", this.refreshToken);
    putIfNotNull(localHashMap, "code_verifier", this.codeVerifier);
    putIfNotNull(localHashMap, "scope", this.scope);
    Iterator localIterator = this.additionalParameters.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return localHashMap;
  }
  
  @Nullable
  public Set<String> getScopeSet()
  {
    return AsciiStringListUtil.stringToSet(this.scope);
  }
  
  @NonNull
  public JSONObject jsonSerialize()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "configuration", this.configuration.toJson());
    JsonUtil.put(localJSONObject, "clientId", this.clientId);
    JsonUtil.put(localJSONObject, "grantType", this.grantType);
    JsonUtil.putIfNotNull(localJSONObject, "redirectUri", this.redirectUri);
    JsonUtil.putIfNotNull(localJSONObject, "scope", this.scope);
    JsonUtil.putIfNotNull(localJSONObject, "authorizationCode", this.authorizationCode);
    JsonUtil.putIfNotNull(localJSONObject, "refreshToken", this.refreshToken);
    JsonUtil.put(localJSONObject, "additionalParameters", JsonUtil.mapToJsonObject(this.additionalParameters));
    return localJSONObject;
  }
  
  @NonNull
  public String jsonSerializeString()
  {
    return jsonSerialize().toString();
  }
  
  public static final class Builder
  {
    @NonNull
    private Map<String, String> mAdditionalParameters;
    @Nullable
    private String mAuthorizationCode;
    @NonNull
    private String mClientId;
    @Nullable
    private String mCodeVerifier;
    @NonNull
    private AuthorizationServiceConfiguration mConfiguration;
    @Nullable
    private String mGrantType;
    @Nullable
    private Uri mRedirectUri;
    @Nullable
    private String mRefreshToken;
    @Nullable
    private String mScope;
    
    public Builder(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @NonNull String paramString)
    {
      setConfiguration(paramAuthorizationServiceConfiguration);
      setClientId(paramString);
      this.mAdditionalParameters = new LinkedHashMap();
    }
    
    private String inferGrantType()
    {
      if (this.mGrantType != null) {
        return this.mGrantType;
      }
      if (this.mAuthorizationCode != null) {
        return "authorization_code";
      }
      if (this.mRefreshToken != null) {
        return "refresh_token";
      }
      throw new IllegalStateException("grant type not specified and cannot be inferred");
    }
    
    @NonNull
    public TokenRequest build()
    {
      String str = inferGrantType();
      if ("authorization_code".equals(str)) {
        Preconditions.checkNotNull(this.mAuthorizationCode, "authorization code must be specified for grant_type = authorization_code");
      }
      if ("refresh_token".equals(str)) {
        Preconditions.checkNotNull(this.mRefreshToken, "refresh token must be specified for grant_type = refresh_token");
      }
      if ((str.equals("authorization_code")) && (this.mRedirectUri == null)) {
        throw new IllegalStateException("no redirect URI specified on token request for code exchange");
      }
      return new TokenRequest(this.mConfiguration, this.mClientId, str, this.mRedirectUri, this.mScope, this.mAuthorizationCode, this.mRefreshToken, this.mCodeVerifier, Collections.unmodifiableMap(this.mAdditionalParameters), null);
    }
    
    @NonNull
    public Builder setAdditionalParameters(@Nullable Map<String, String> paramMap)
    {
      this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(paramMap, TokenRequest.BUILT_IN_PARAMS);
      return this;
    }
    
    @NonNull
    public Builder setAuthorizationCode(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "authorization code must not be empty");
      this.mAuthorizationCode = paramString;
      return this;
    }
    
    @NonNull
    public Builder setClientId(@NonNull String paramString)
    {
      this.mClientId = Preconditions.checkNotEmpty(paramString, "clientId cannot be null or empty");
      return this;
    }
    
    public Builder setCodeVerifier(@Nullable String paramString)
    {
      if (paramString != null) {
        CodeVerifierUtil.checkCodeVerifier(paramString);
      }
      this.mCodeVerifier = paramString;
      return this;
    }
    
    @NonNull
    public Builder setConfiguration(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration)
    {
      this.mConfiguration = ((AuthorizationServiceConfiguration)Preconditions.checkNotNull(paramAuthorizationServiceConfiguration));
      return this;
    }
    
    @NonNull
    public Builder setGrantType(@NonNull String paramString)
    {
      this.mGrantType = Preconditions.checkNotEmpty(paramString, "grantType cannot be null or empty");
      return this;
    }
    
    @NonNull
    public Builder setRedirectUri(@Nullable Uri paramUri)
    {
      if (paramUri != null) {
        Preconditions.checkNotNull(paramUri.getScheme(), "redirectUri must have a scheme");
      }
      this.mRedirectUri = paramUri;
      return this;
    }
    
    @NonNull
    public Builder setRefreshToken(@Nullable String paramString)
    {
      if (paramString != null) {
        Preconditions.checkNotEmpty(paramString, "refresh token cannot be empty if defined");
      }
      this.mRefreshToken = paramString;
      return this;
    }
    
    @NonNull
    public Builder setScope(@Nullable String paramString)
    {
      if (TextUtils.isEmpty(paramString))
      {
        this.mScope = null;
        return this;
      }
      setScopes(paramString.split(" +"));
      return this;
    }
    
    @NonNull
    public Builder setScopes(@Nullable Iterable<String> paramIterable)
    {
      this.mScope = AsciiStringListUtil.iterableToString(paramIterable);
      return this;
    }
    
    @NonNull
    public Builder setScopes(String... paramVarArgs)
    {
      String[] arrayOfString = paramVarArgs;
      if (paramVarArgs == null) {
        arrayOfString = new String[0];
      }
      setScopes(Arrays.asList(arrayOfString));
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.TokenRequest
 * JD-Core Version:    0.7.0.1
 */