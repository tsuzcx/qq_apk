package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationResponse
{
  private static final Set<String> BUILT_IN_PARAMS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "token_type", "state", "code", "access_token", "expires_in", "id_token", "scope" })));
  public static final String EXTRA_RESPONSE = "net.openid.appauth.AuthorizationResponse";
  @VisibleForTesting
  static final String KEY_ACCESS_TOKEN = "access_token";
  @VisibleForTesting
  static final String KEY_ADDITIONAL_PARAMETERS = "additional_parameters";
  @VisibleForTesting
  static final String KEY_AUTHORIZATION_CODE = "code";
  @VisibleForTesting
  static final String KEY_EXPIRES_AT = "expires_at";
  @VisibleForTesting
  static final String KEY_EXPIRES_IN = "expires_in";
  @VisibleForTesting
  static final String KEY_ID_TOKEN = "id_token";
  @VisibleForTesting
  static final String KEY_REQUEST = "request";
  @VisibleForTesting
  static final String KEY_SCOPE = "scope";
  @VisibleForTesting
  static final String KEY_STATE = "state";
  @VisibleForTesting
  static final String KEY_TOKEN_TYPE = "token_type";
  public static final String TOKEN_TYPE_BEARER = "bearer";
  @Nullable
  public final String accessToken;
  @Nullable
  public final Long accessTokenExpirationTime;
  @NonNull
  public final Map<String, String> additionalParameters;
  @Nullable
  public final String authorizationCode;
  @Nullable
  public final String idToken;
  @NonNull
  public final AuthorizationRequest request;
  @Nullable
  public final String scope;
  @Nullable
  public final String state;
  @Nullable
  public final String tokenType;
  
  private AuthorizationResponse(@NonNull AuthorizationRequest paramAuthorizationRequest, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable Long paramLong, @Nullable String paramString5, @Nullable String paramString6, @NonNull Map<String, String> paramMap)
  {
    this.request = paramAuthorizationRequest;
    this.state = paramString1;
    this.tokenType = paramString2;
    this.authorizationCode = paramString3;
    this.accessToken = paramString4;
    this.accessTokenExpirationTime = paramLong;
    this.idToken = paramString5;
    this.scope = paramString6;
    this.additionalParameters = paramMap;
  }
  
  @Nullable
  public static AuthorizationResponse fromIntent(@NonNull Intent paramIntent)
  {
    Preconditions.checkNotNull(paramIntent, "dataIntent must not be null");
    if (!paramIntent.hasExtra("net.openid.appauth.AuthorizationResponse")) {
      return null;
    }
    try
    {
      paramIntent = jsonDeserialize(paramIntent.getStringExtra("net.openid.appauth.AuthorizationResponse"));
      return paramIntent;
    }
    catch (JSONException paramIntent)
    {
      throw new IllegalArgumentException("Intent contains malformed auth response", paramIntent);
    }
  }
  
  @NonNull
  public static AuthorizationResponse jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  @NonNull
  public static AuthorizationResponse jsonDeserialize(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.has("request")) {
      throw new IllegalArgumentException("authorization request not provided and not found in JSON");
    }
    return new Builder(AuthorizationRequest.jsonDeserialize(paramJSONObject.getJSONObject("request"))).setTokenType(JsonUtil.getStringIfDefined(paramJSONObject, "token_type")).setAccessToken(JsonUtil.getStringIfDefined(paramJSONObject, "access_token")).setAuthorizationCode(JsonUtil.getStringIfDefined(paramJSONObject, "code")).setIdToken(JsonUtil.getStringIfDefined(paramJSONObject, "id_token")).setScope(JsonUtil.getStringIfDefined(paramJSONObject, "scope")).setState(JsonUtil.getStringIfDefined(paramJSONObject, "state")).setAccessTokenExpirationTime(JsonUtil.getLongIfDefined(paramJSONObject, "expires_at")).setAdditionalParameters(JsonUtil.getStringMap(paramJSONObject, "additional_parameters")).build();
  }
  
  @NonNull
  public TokenRequest createTokenExchangeRequest()
  {
    return createTokenExchangeRequest(Collections.emptyMap());
  }
  
  @NonNull
  public TokenRequest createTokenExchangeRequest(@NonNull Map<String, String> paramMap)
  {
    Preconditions.checkNotNull(paramMap, "additionalExchangeParameters cannot be null");
    if (this.authorizationCode == null) {
      throw new IllegalStateException("authorizationCode not available for exchange request");
    }
    return new TokenRequest.Builder(this.request.configuration, this.request.clientId).setGrantType("authorization_code").setRedirectUri(this.request.redirectUri).setScope(this.request.scope).setCodeVerifier(this.request.codeVerifier).setAuthorizationCode(this.authorizationCode).setAdditionalParameters(paramMap).build();
  }
  
  @Nullable
  public Set<String> getScopeSet()
  {
    return AsciiStringListUtil.stringToSet(this.scope);
  }
  
  public boolean hasAccessTokenExpired()
  {
    return hasAccessTokenExpired(SystemClock.INSTANCE);
  }
  
  @VisibleForTesting
  boolean hasAccessTokenExpired(@NonNull Clock paramClock)
  {
    return (this.accessTokenExpirationTime != null) && (((Clock)Preconditions.checkNotNull(paramClock)).getCurrentTimeMillis() > this.accessTokenExpirationTime.longValue());
  }
  
  @NonNull
  public JSONObject jsonSerialize()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "request", this.request.jsonSerialize());
    JsonUtil.putIfNotNull(localJSONObject, "state", this.state);
    JsonUtil.putIfNotNull(localJSONObject, "token_type", this.tokenType);
    JsonUtil.putIfNotNull(localJSONObject, "code", this.authorizationCode);
    JsonUtil.putIfNotNull(localJSONObject, "access_token", this.accessToken);
    JsonUtil.putIfNotNull(localJSONObject, "expires_at", this.accessTokenExpirationTime);
    JsonUtil.putIfNotNull(localJSONObject, "id_token", this.idToken);
    JsonUtil.putIfNotNull(localJSONObject, "scope", this.scope);
    JsonUtil.put(localJSONObject, "additional_parameters", JsonUtil.mapToJsonObject(this.additionalParameters));
    return localJSONObject;
  }
  
  @NonNull
  public String jsonSerializeString()
  {
    return jsonSerialize().toString();
  }
  
  @NonNull
  public Intent toIntent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("net.openid.appauth.AuthorizationResponse", jsonSerializeString());
    return localIntent;
  }
  
  public static final class Builder
  {
    @Nullable
    private String mAccessToken;
    @Nullable
    private Long mAccessTokenExpirationTime;
    @NonNull
    private Map<String, String> mAdditionalParameters;
    @Nullable
    private String mAuthorizationCode;
    @Nullable
    private String mIdToken;
    @NonNull
    private AuthorizationRequest mRequest;
    @Nullable
    private String mScope;
    @Nullable
    private String mState;
    @Nullable
    private String mTokenType;
    
    public Builder(@NonNull AuthorizationRequest paramAuthorizationRequest)
    {
      this.mRequest = ((AuthorizationRequest)Preconditions.checkNotNull(paramAuthorizationRequest, "authorization request cannot be null"));
      this.mAdditionalParameters = new LinkedHashMap();
    }
    
    @NonNull
    public AuthorizationResponse build()
    {
      return new AuthorizationResponse(this.mRequest, this.mState, this.mTokenType, this.mAuthorizationCode, this.mAccessToken, this.mAccessTokenExpirationTime, this.mIdToken, this.mScope, Collections.unmodifiableMap(this.mAdditionalParameters), null);
    }
    
    @NonNull
    public Builder fromUri(@NonNull Uri paramUri)
    {
      return fromUri(paramUri, SystemClock.INSTANCE);
    }
    
    @NonNull
    @VisibleForTesting
    Builder fromUri(@NonNull Uri paramUri, @NonNull Clock paramClock)
    {
      setState(paramUri.getQueryParameter("state"));
      setTokenType(paramUri.getQueryParameter("token_type"));
      setAuthorizationCode(paramUri.getQueryParameter("code"));
      setAccessToken(paramUri.getQueryParameter("access_token"));
      setAccessTokenExpiresIn(UriUtil.getLongQueryParameter(paramUri, "expires_in"), paramClock);
      setIdToken(paramUri.getQueryParameter("id_token"));
      setScope(paramUri.getQueryParameter("scope"));
      setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(paramUri, AuthorizationResponse.BUILT_IN_PARAMS));
      return this;
    }
    
    @NonNull
    public Builder setAccessToken(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "accessToken must not be empty");
      this.mAccessToken = paramString;
      return this;
    }
    
    @NonNull
    public Builder setAccessTokenExpirationTime(@Nullable Long paramLong)
    {
      this.mAccessTokenExpirationTime = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setAccessTokenExpiresIn(@Nullable Long paramLong)
    {
      return setAccessTokenExpiresIn(paramLong, SystemClock.INSTANCE);
    }
    
    @NonNull
    @VisibleForTesting
    public Builder setAccessTokenExpiresIn(@Nullable Long paramLong, @NonNull Clock paramClock)
    {
      if (paramLong == null)
      {
        this.mAccessTokenExpirationTime = null;
        return this;
      }
      this.mAccessTokenExpirationTime = Long.valueOf(paramClock.getCurrentTimeMillis() + TimeUnit.SECONDS.toMillis(paramLong.longValue()));
      return this;
    }
    
    @NonNull
    public Builder setAdditionalParameters(@Nullable Map<String, String> paramMap)
    {
      this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(paramMap, AuthorizationResponse.BUILT_IN_PARAMS);
      return this;
    }
    
    @NonNull
    public Builder setAuthorizationCode(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "authorizationCode must not be empty");
      this.mAuthorizationCode = paramString;
      return this;
    }
    
    @NonNull
    public Builder setIdToken(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "idToken cannot be empty");
      this.mIdToken = paramString;
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
      if (paramVarArgs == null)
      {
        this.mScope = null;
        return this;
      }
      setScopes(Arrays.asList(paramVarArgs));
      return this;
    }
    
    @NonNull
    public Builder setState(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "state must not be empty");
      this.mState = paramString;
      return this;
    }
    
    @NonNull
    public Builder setTokenType(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "tokenType must not be empty");
      this.mTokenType = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationResponse
 * JD-Core Version:    0.7.0.1
 */