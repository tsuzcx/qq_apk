package net.openid.appauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class TokenResponse
{
  private static final Set<String> BUILT_IN_PARAMS = new HashSet(Arrays.asList(new String[] { "token_type", "access_token", "expires_in", "refresh_token", "id_token", "scope" }));
  @VisibleForTesting
  static final String KEY_ACCESS_TOKEN = "access_token";
  @VisibleForTesting
  static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
  @VisibleForTesting
  static final String KEY_EXPIRES_AT = "expires_at";
  @VisibleForTesting
  static final String KEY_EXPIRES_IN = "expires_in";
  @VisibleForTesting
  static final String KEY_ID_TOKEN = "id_token";
  @VisibleForTesting
  static final String KEY_REFRESH_TOKEN = "refresh_token";
  @VisibleForTesting
  static final String KEY_REQUEST = "request";
  @VisibleForTesting
  static final String KEY_SCOPE = "scope";
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
  public final String idToken;
  @Nullable
  public final String refreshToken;
  @NonNull
  public final TokenRequest request;
  @Nullable
  public final String scope;
  @Nullable
  public final String tokenType;
  
  TokenResponse(@NonNull TokenRequest paramTokenRequest, @Nullable String paramString1, @Nullable String paramString2, @Nullable Long paramLong, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @NonNull Map<String, String> paramMap)
  {
    this.request = paramTokenRequest;
    this.tokenType = paramString1;
    this.accessToken = paramString2;
    this.accessTokenExpirationTime = paramLong;
    this.idToken = paramString3;
    this.refreshToken = paramString4;
    this.scope = paramString5;
    this.additionalParameters = paramMap;
  }
  
  @NonNull
  public static TokenResponse jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotEmpty(paramString, "jsonStr cannot be null or empty");
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  @NonNull
  public static TokenResponse jsonDeserialize(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    if (!paramJSONObject.has("request")) {
      throw new IllegalArgumentException("token request not provided and not found in JSON");
    }
    return new Builder(TokenRequest.jsonDeserialize(paramJSONObject.getJSONObject("request"))).fromResponseJson(paramJSONObject).build();
  }
  
  @Nullable
  public Set<String> getScopeSet()
  {
    return AsciiStringListUtil.stringToSet(this.scope);
  }
  
  public JSONObject jsonSerialize()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "request", this.request.jsonSerialize());
    JsonUtil.putIfNotNull(localJSONObject, "token_type", this.tokenType);
    JsonUtil.putIfNotNull(localJSONObject, "access_token", this.accessToken);
    JsonUtil.putIfNotNull(localJSONObject, "expires_at", this.accessTokenExpirationTime);
    JsonUtil.putIfNotNull(localJSONObject, "id_token", this.idToken);
    JsonUtil.putIfNotNull(localJSONObject, "refresh_token", this.refreshToken);
    JsonUtil.putIfNotNull(localJSONObject, "scope", this.scope);
    JsonUtil.put(localJSONObject, "additionalParameters", JsonUtil.mapToJsonObject(this.additionalParameters));
    return localJSONObject;
  }
  
  public String jsonSerializeString()
  {
    return jsonSerialize().toString();
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
    private String mIdToken;
    @Nullable
    private String mRefreshToken;
    @NonNull
    private TokenRequest mRequest;
    @Nullable
    private String mScope;
    @Nullable
    private String mTokenType;
    
    public Builder(@NonNull TokenRequest paramTokenRequest)
    {
      setRequest(paramTokenRequest);
      this.mAdditionalParameters = Collections.emptyMap();
    }
    
    public TokenResponse build()
    {
      return new TokenResponse(this.mRequest, this.mTokenType, this.mAccessToken, this.mAccessTokenExpirationTime, this.mIdToken, this.mRefreshToken, this.mScope, this.mAdditionalParameters);
    }
    
    @NonNull
    public Builder fromResponseJson(@NonNull JSONObject paramJSONObject)
      throws JSONException
    {
      try
      {
        setTokenType(JsonUtil.getString(paramJSONObject, "token_type"));
        setAccessToken(JsonUtil.getStringIfDefined(paramJSONObject, "access_token"));
        if (paramJSONObject.has("expires_at")) {
          setAccessTokenExpirationTime(Long.valueOf(paramJSONObject.getLong("expires_at")));
        }
        if (paramJSONObject.has("expires_in")) {
          setAccessTokenExpiresIn(Long.valueOf(paramJSONObject.getLong("expires_in")));
        }
        setRefreshToken(JsonUtil.getStringIfDefined(paramJSONObject, "refresh_token"));
        setIdToken(JsonUtil.getStringIfDefined(paramJSONObject, "id_token"));
        setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(paramJSONObject, TokenResponse.BUILT_IN_PARAMS));
        return this;
      }
      catch (JSONException paramJSONObject)
      {
        throw new IllegalStateException("JSONException thrown in violation of contract", paramJSONObject);
      }
    }
    
    @NonNull
    public Builder fromResponseJsonString(@NonNull String paramString)
      throws JSONException
    {
      Preconditions.checkNotEmpty(paramString, "json cannot be null or empty");
      return fromResponseJson(new JSONObject(paramString));
    }
    
    @NonNull
    public Builder setAccessToken(@Nullable String paramString)
    {
      this.mAccessToken = Preconditions.checkNullOrNotEmpty(paramString, "access token cannot be empty if specified");
      return this;
    }
    
    @NonNull
    public Builder setAccessTokenExpirationTime(@Nullable Long paramLong)
    {
      this.mAccessTokenExpirationTime = paramLong;
      return this;
    }
    
    @NonNull
    public Builder setAccessTokenExpiresIn(@NonNull Long paramLong)
    {
      return setAccessTokenExpiresIn(paramLong, SystemClock.INSTANCE);
    }
    
    @NonNull
    @VisibleForTesting
    Builder setAccessTokenExpiresIn(@Nullable Long paramLong, @NonNull Clock paramClock)
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
      this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(paramMap, TokenResponse.BUILT_IN_PARAMS);
      return this;
    }
    
    public Builder setIdToken(@Nullable String paramString)
    {
      this.mIdToken = Preconditions.checkNullOrNotEmpty(paramString, "id token must not be empty if defined");
      return this;
    }
    
    public Builder setRefreshToken(@Nullable String paramString)
    {
      this.mRefreshToken = Preconditions.checkNullOrNotEmpty(paramString, "refresh token must not be empty if defined");
      return this;
    }
    
    @NonNull
    public Builder setRequest(@NonNull TokenRequest paramTokenRequest)
    {
      this.mRequest = ((TokenRequest)Preconditions.checkNotNull(paramTokenRequest, "request cannot be null"));
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
    
    @NonNull
    public Builder setTokenType(@Nullable String paramString)
    {
      this.mTokenType = Preconditions.checkNullOrNotEmpty(paramString, "token type must not be empty if defined");
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.TokenResponse
 * JD-Core Version:    0.7.0.1
 */