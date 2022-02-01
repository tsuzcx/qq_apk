package net.openid.appauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthState
{
  public static final int EXPIRY_TIME_TOLERANCE_MS = 60000;
  private static final String KEY_AUTHORIZATION_EXCEPTION = "mAuthorizationException";
  private static final String KEY_LAST_AUTHORIZATION_RESPONSE = "lastAuthorizationResponse";
  private static final String KEY_LAST_REGISTRATION_RESPONSE = "lastRegistrationResponse";
  private static final String KEY_LAST_TOKEN_RESPONSE = "mLastTokenResponse";
  private static final String KEY_REFRESH_TOKEN = "refreshToken";
  private static final String KEY_SCOPE = "scope";
  @Nullable
  private AuthorizationException mAuthorizationException;
  @Nullable
  private AuthorizationResponse mLastAuthorizationResponse;
  @Nullable
  private RegistrationResponse mLastRegistrationResponse;
  @Nullable
  private TokenResponse mLastTokenResponse;
  private boolean mNeedsTokenRefreshOverride;
  @Nullable
  private String mRefreshToken;
  @Nullable
  private String mScope;
  
  public AuthState() {}
  
  public AuthState(@Nullable AuthorizationResponse paramAuthorizationResponse, @Nullable AuthorizationException paramAuthorizationException)
  {
    int i;
    if (paramAuthorizationResponse != null)
    {
      i = 1;
      if (paramAuthorizationException == null) {
        break label38;
      }
    }
    for (;;)
    {
      Preconditions.checkArgument(j ^ i, "exactly one of authResponse or authError should be non-null");
      update(paramAuthorizationResponse, paramAuthorizationException);
      return;
      i = 0;
      break;
      label38:
      j = 0;
    }
  }
  
  public AuthState(@NonNull AuthorizationResponse paramAuthorizationResponse, @Nullable TokenResponse paramTokenResponse, @Nullable AuthorizationException paramAuthorizationException)
  {
    this(paramAuthorizationResponse, null);
    update(paramTokenResponse, paramAuthorizationException);
  }
  
  public AuthState(@NonNull RegistrationResponse paramRegistrationResponse)
  {
    update(paramRegistrationResponse);
  }
  
  public static AuthState jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotEmpty(paramString, "jsonStr cannot be null or empty");
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  public static AuthState jsonDeserialize(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json cannot be null");
    AuthState localAuthState = new AuthState();
    localAuthState.mRefreshToken = JsonUtil.getStringIfDefined(paramJSONObject, "refreshToken");
    localAuthState.mScope = JsonUtil.getStringIfDefined(paramJSONObject, "scope");
    if (paramJSONObject.has("mAuthorizationException")) {
      localAuthState.mAuthorizationException = AuthorizationException.fromJson(paramJSONObject.getJSONObject("mAuthorizationException"));
    }
    if (paramJSONObject.has("lastAuthorizationResponse")) {
      localAuthState.mLastAuthorizationResponse = AuthorizationResponse.jsonDeserialize(paramJSONObject.getJSONObject("lastAuthorizationResponse"));
    }
    if (paramJSONObject.has("mLastTokenResponse")) {
      localAuthState.mLastTokenResponse = TokenResponse.jsonDeserialize(paramJSONObject.getJSONObject("mLastTokenResponse"));
    }
    if (paramJSONObject.has("lastRegistrationResponse")) {
      localAuthState.mLastRegistrationResponse = RegistrationResponse.jsonDeserialize(paramJSONObject.getJSONObject("lastRegistrationResponse"));
    }
    return localAuthState;
  }
  
  public TokenRequest createTokenRefreshRequest()
  {
    return createTokenRefreshRequest(Collections.emptyMap());
  }
  
  public TokenRequest createTokenRefreshRequest(@NonNull Map<String, String> paramMap)
  {
    if (this.mRefreshToken == null) {
      throw new IllegalStateException("No refresh token available for refresh request");
    }
    if (this.mLastAuthorizationResponse == null) {
      throw new IllegalStateException("No authorization configuration available for refresh request");
    }
    return new TokenRequest.Builder(this.mLastAuthorizationResponse.request.configuration, this.mLastAuthorizationResponse.request.clientId).setGrantType("refresh_token").setScope(this.mLastAuthorizationResponse.request.scope).setRefreshToken(this.mRefreshToken).setAdditionalParameters(paramMap).build();
  }
  
  @Nullable
  public String getAccessToken()
  {
    if (this.mAuthorizationException != null) {}
    do
    {
      return null;
      if ((this.mLastTokenResponse != null) && (this.mLastTokenResponse.accessToken != null)) {
        return this.mLastTokenResponse.accessToken;
      }
    } while (this.mLastAuthorizationResponse == null);
    return this.mLastAuthorizationResponse.accessToken;
  }
  
  @Nullable
  public Long getAccessTokenExpirationTime()
  {
    if (this.mAuthorizationException != null) {}
    do
    {
      return null;
      if ((this.mLastTokenResponse != null) && (this.mLastTokenResponse.accessToken != null)) {
        return this.mLastTokenResponse.accessTokenExpirationTime;
      }
    } while ((this.mLastAuthorizationResponse == null) || (this.mLastAuthorizationResponse.accessToken == null));
    return this.mLastAuthorizationResponse.accessTokenExpirationTime;
  }
  
  @Nullable
  public AuthorizationException getAuthorizationException()
  {
    return this.mAuthorizationException;
  }
  
  @Nullable
  public AuthorizationServiceConfiguration getAuthorizationServiceConfiguration()
  {
    if (this.mLastAuthorizationResponse != null) {
      return this.mLastAuthorizationResponse.request.configuration;
    }
    return null;
  }
  
  public ClientAuthentication getClientAuthentication()
    throws ClientAuthentication.UnsupportedAuthenticationMethod
  {
    if (getClientSecret() == null) {
      return NoClientAuthentication.INSTANCE;
    }
    if (this.mLastRegistrationResponse.tokenEndpointAuthMethod == null) {
      return new ClientSecretBasic(getClientSecret());
    }
    String str = this.mLastRegistrationResponse.tokenEndpointAuthMethod;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new ClientAuthentication.UnsupportedAuthenticationMethod(this.mLastRegistrationResponse.tokenEndpointAuthMethod);
        if (str.equals("client_secret_basic"))
        {
          i = 0;
          continue;
          if (str.equals("client_secret_post"))
          {
            i = 1;
            continue;
            if (str.equals("none")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return new ClientSecretBasic(getClientSecret());
    return new ClientSecretPost(getClientSecret());
    return NoClientAuthentication.INSTANCE;
  }
  
  public String getClientSecret()
  {
    if (this.mLastRegistrationResponse != null) {
      return this.mLastRegistrationResponse.clientSecret;
    }
    return null;
  }
  
  @Nullable
  public Long getClientSecretExpirationTime()
  {
    if (this.mLastRegistrationResponse != null) {
      return this.mLastRegistrationResponse.clientSecretExpiresAt;
    }
    return null;
  }
  
  @Nullable
  public String getIdToken()
  {
    if (this.mAuthorizationException != null) {}
    do
    {
      return null;
      if ((this.mLastTokenResponse != null) && (this.mLastTokenResponse.idToken != null)) {
        return this.mLastTokenResponse.idToken;
      }
    } while (this.mLastAuthorizationResponse == null);
    return this.mLastAuthorizationResponse.idToken;
  }
  
  @Nullable
  public AuthorizationResponse getLastAuthorizationResponse()
  {
    return this.mLastAuthorizationResponse;
  }
  
  @Nullable
  public RegistrationResponse getLastRegistrationResponse()
  {
    return this.mLastRegistrationResponse;
  }
  
  @Nullable
  public TokenResponse getLastTokenResponse()
  {
    return this.mLastTokenResponse;
  }
  
  public boolean getNeedsTokenRefresh()
  {
    return getNeedsTokenRefresh(SystemClock.INSTANCE);
  }
  
  @VisibleForTesting
  boolean getNeedsTokenRefresh(Clock paramClock)
  {
    if (this.mNeedsTokenRefreshOverride) {}
    do
    {
      do
      {
        return true;
        if (getAccessTokenExpirationTime() != null) {
          break;
        }
      } while (getAccessToken() == null);
      return false;
    } while (getAccessTokenExpirationTime().longValue() <= paramClock.getCurrentTimeMillis() + 60000L);
    return false;
  }
  
  @Nullable
  public String getRefreshToken()
  {
    return this.mRefreshToken;
  }
  
  @Nullable
  public String getScope()
  {
    return this.mScope;
  }
  
  @Nullable
  public Set<String> getScopeSet()
  {
    return AsciiStringListUtil.stringToSet(this.mScope);
  }
  
  public boolean hasClientSecretExpired()
  {
    return hasClientSecretExpired(SystemClock.INSTANCE);
  }
  
  @VisibleForTesting
  boolean hasClientSecretExpired(Clock paramClock)
  {
    if ((getClientSecretExpirationTime() == null) || (getClientSecretExpirationTime().longValue() == 0L)) {}
    while (getClientSecretExpirationTime().longValue() > paramClock.getCurrentTimeMillis()) {
      return false;
    }
    return true;
  }
  
  public boolean isAuthorized()
  {
    return (this.mAuthorizationException == null) && ((getAccessToken() != null) || (getIdToken() != null));
  }
  
  public JSONObject jsonSerialize()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.putIfNotNull(localJSONObject, "refreshToken", this.mRefreshToken);
    JsonUtil.putIfNotNull(localJSONObject, "scope", this.mScope);
    if (this.mAuthorizationException != null) {
      JsonUtil.put(localJSONObject, "mAuthorizationException", this.mAuthorizationException.toJson());
    }
    if (this.mLastAuthorizationResponse != null) {
      JsonUtil.put(localJSONObject, "lastAuthorizationResponse", this.mLastAuthorizationResponse.jsonSerialize());
    }
    if (this.mLastTokenResponse != null) {
      JsonUtil.put(localJSONObject, "mLastTokenResponse", this.mLastTokenResponse.jsonSerialize());
    }
    if (this.mLastRegistrationResponse != null) {
      JsonUtil.put(localJSONObject, "lastRegistrationResponse", this.mLastRegistrationResponse.jsonSerialize());
    }
    return localJSONObject;
  }
  
  public String jsonSerializeString()
  {
    return jsonSerialize().toString();
  }
  
  public void performActionWithFreshTokens(@NonNull AuthorizationService paramAuthorizationService, @NonNull Map<String, String> paramMap, @NonNull AuthStateAction paramAuthStateAction)
  {
    performActionWithFreshTokens(paramAuthorizationService, paramMap, SystemClock.INSTANCE, paramAuthStateAction);
  }
  
  @VisibleForTesting
  void performActionWithFreshTokens(@NonNull AuthorizationService paramAuthorizationService, @NonNull Map<String, String> paramMap, @NonNull Clock paramClock, @NonNull AuthStateAction paramAuthStateAction)
  {
    Preconditions.checkNotNull(paramAuthorizationService, "service cannot be null");
    Preconditions.checkNotNull(paramMap, "additional params cannot be null");
    Preconditions.checkNotNull(paramClock, "clock cannot be null");
    Preconditions.checkNotNull(paramAuthStateAction, "action cannot be null");
    if (!getNeedsTokenRefresh(paramClock))
    {
      paramAuthStateAction.execute(getAccessToken(), getIdToken(), null);
      return;
    }
    if (this.mRefreshToken == null)
    {
      paramAuthStateAction.execute(null, null, AuthorizationException.fromTemplate(AuthorizationException.AuthorizationRequestErrors.CLIENT_ERROR, new IllegalStateException("No refresh token available and token have expired")));
      return;
    }
    paramAuthorizationService.performTokenRequest(createTokenRefreshRequest(paramMap), new AuthState.1(this, paramAuthStateAction));
  }
  
  public void performActionWithFreshTokens(@NonNull AuthorizationService paramAuthorizationService, @NonNull AuthStateAction paramAuthStateAction)
  {
    performActionWithFreshTokens(paramAuthorizationService, Collections.emptyMap(), paramAuthStateAction);
  }
  
  public void setNeedsTokenRefresh(boolean paramBoolean)
  {
    this.mNeedsTokenRefreshOverride = paramBoolean;
  }
  
  public void update(@Nullable AuthorizationResponse paramAuthorizationResponse, @Nullable AuthorizationException paramAuthorizationException)
  {
    int j = 0;
    if (paramAuthorizationResponse != null) {}
    for (int i = 1;; i = 0)
    {
      if (paramAuthorizationException != null) {
        j = 1;
      }
      Preconditions.checkArgument(j ^ i, "exactly one of authResponse or authException should be non-null");
      if (paramAuthorizationException == null) {
        break;
      }
      if (paramAuthorizationException.type == 1) {
        this.mAuthorizationException = paramAuthorizationException;
      }
      return;
    }
    this.mLastAuthorizationResponse = paramAuthorizationResponse;
    this.mLastTokenResponse = null;
    this.mRefreshToken = null;
    this.mAuthorizationException = null;
    if (paramAuthorizationResponse.scope != null) {}
    for (paramAuthorizationResponse = paramAuthorizationResponse.scope;; paramAuthorizationResponse = paramAuthorizationResponse.request.scope)
    {
      this.mScope = paramAuthorizationResponse;
      return;
    }
  }
  
  public void update(@Nullable RegistrationResponse paramRegistrationResponse)
  {
    this.mLastRegistrationResponse = paramRegistrationResponse;
    this.mRefreshToken = null;
    this.mScope = null;
    this.mLastAuthorizationResponse = null;
    this.mLastTokenResponse = null;
    this.mAuthorizationException = null;
  }
  
  public void update(@Nullable TokenResponse paramTokenResponse, @Nullable AuthorizationException paramAuthorizationException)
  {
    int i;
    int j;
    if (paramTokenResponse != null)
    {
      i = 1;
      if (paramAuthorizationException == null) {
        break label75;
      }
      j = 1;
      label13:
      Preconditions.checkArgument(j ^ i, "exactly one of tokenResponse or authException should be non-null");
      if (this.mAuthorizationException != null)
      {
        Logger.warn("AuthState.update should not be called in an error state (%s), call updatewith the result of the fresh authorization response first", new Object[] { this.mAuthorizationException });
        this.mAuthorizationException = null;
      }
      if (paramAuthorizationException == null) {
        break label81;
      }
      if (paramAuthorizationException.type == 2) {
        this.mAuthorizationException = paramAuthorizationException;
      }
    }
    label75:
    label81:
    do
    {
      return;
      i = 0;
      break;
      j = 0;
      break label13;
      this.mLastTokenResponse = paramTokenResponse;
      if (paramTokenResponse.scope != null) {
        this.mScope = paramTokenResponse.scope;
      }
    } while (paramTokenResponse.refreshToken == null);
    this.mRefreshToken = paramTokenResponse.refreshToken;
  }
  
  public static abstract interface AuthStateAction
  {
    public abstract void execute(@Nullable String paramString1, @Nullable String paramString2, @Nullable AuthorizationException paramAuthorizationException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthState
 * JD-Core Version:    0.7.0.1
 */