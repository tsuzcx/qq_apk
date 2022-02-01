package net.openid.appauth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationResponse
{
  private static final Set<String> BUILT_IN_PARAMS = new HashSet(Arrays.asList(new String[] { "client_id", "client_secret", "client_secret_expires_at", "registration_access_token", "registration_client_uri", "client_id_issued_at", "token_endpoint_auth_method" }));
  static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
  static final String KEY_REQUEST = "request";
  static final String PARAM_CLIENT_ID = "client_id";
  static final String PARAM_CLIENT_ID_ISSUED_AT = "client_id_issued_at";
  static final String PARAM_CLIENT_SECRET = "client_secret";
  static final String PARAM_CLIENT_SECRET_EXPIRES_AT = "client_secret_expires_at";
  static final String PARAM_REGISTRATION_ACCESS_TOKEN = "registration_access_token";
  static final String PARAM_REGISTRATION_CLIENT_URI = "registration_client_uri";
  static final String PARAM_TOKEN_ENDPOINT_AUTH_METHOD = "token_endpoint_auth_method";
  @NonNull
  public final Map<String, String> additionalParameters;
  @NonNull
  public final String clientId;
  @Nullable
  public final Long clientIdIssuedAt;
  @Nullable
  public final String clientSecret;
  @Nullable
  public final Long clientSecretExpiresAt;
  @Nullable
  public final String registrationAccessToken;
  @Nullable
  public final Uri registrationClientUri;
  @NonNull
  public final RegistrationRequest request;
  @Nullable
  public final String tokenEndpointAuthMethod;
  
  private RegistrationResponse(@NonNull RegistrationRequest paramRegistrationRequest, @NonNull String paramString1, @Nullable Long paramLong1, @Nullable String paramString2, @Nullable Long paramLong2, @Nullable String paramString3, @Nullable Uri paramUri, @Nullable String paramString4, @NonNull Map<String, String> paramMap)
  {
    this.request = paramRegistrationRequest;
    this.clientId = paramString1;
    this.clientIdIssuedAt = paramLong1;
    this.clientSecret = paramString2;
    this.clientSecretExpiresAt = paramLong2;
    this.registrationAccessToken = paramString3;
    this.registrationClientUri = paramUri;
    this.tokenEndpointAuthMethod = paramString4;
    this.additionalParameters = paramMap;
  }
  
  @NonNull
  public static RegistrationResponse fromJson(@NonNull RegistrationRequest paramRegistrationRequest, @NonNull String paramString)
    throws JSONException, RegistrationResponse.MissingArgumentException
  {
    Preconditions.checkNotEmpty(paramString, "jsonStr cannot be null or empty");
    return fromJson(paramRegistrationRequest, new JSONObject(paramString));
  }
  
  @NonNull
  public static RegistrationResponse fromJson(@NonNull RegistrationRequest paramRegistrationRequest, @NonNull JSONObject paramJSONObject)
    throws JSONException, RegistrationResponse.MissingArgumentException
  {
    Preconditions.checkNotNull(paramRegistrationRequest, "registration request cannot be null");
    return new Builder(paramRegistrationRequest).fromResponseJson(paramJSONObject).build();
  }
  
  @NonNull
  public static RegistrationResponse jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotEmpty(paramString, "jsonStr cannot be null or empty");
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  public static RegistrationResponse jsonDeserialize(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json cannot be null");
    if (!paramJSONObject.has("request")) {
      throw new IllegalArgumentException("registration request not found in JSON");
    }
    try
    {
      paramJSONObject = new Builder(RegistrationRequest.jsonDeserialize(paramJSONObject.getJSONObject("request"))).fromResponseJson(paramJSONObject).build();
      return paramJSONObject;
    }
    catch (MissingArgumentException paramJSONObject)
    {
      throw new JSONException("missing required field: " + paramJSONObject.getMissingField());
    }
  }
  
  public boolean hasClientSecretExpired()
  {
    return hasClientSecretExpired(SystemClock.INSTANCE);
  }
  
  @VisibleForTesting
  boolean hasClientSecretExpired(@NonNull Clock paramClock)
  {
    long l = TimeUnit.MILLISECONDS.toSeconds(((Clock)Preconditions.checkNotNull(paramClock)).getCurrentTimeMillis());
    return (this.clientSecretExpiresAt != null) && (Long.valueOf(l).longValue() > this.clientSecretExpiresAt.longValue());
  }
  
  @NonNull
  public JSONObject jsonSerialize()
  {
    JSONObject localJSONObject = new JSONObject();
    JsonUtil.put(localJSONObject, "request", this.request.jsonSerialize());
    JsonUtil.put(localJSONObject, "client_id", this.clientId);
    JsonUtil.putIfNotNull(localJSONObject, "client_id_issued_at", this.clientIdIssuedAt);
    JsonUtil.putIfNotNull(localJSONObject, "client_secret", this.clientSecret);
    JsonUtil.putIfNotNull(localJSONObject, "client_secret_expires_at", this.clientSecretExpiresAt);
    JsonUtil.putIfNotNull(localJSONObject, "registration_access_token", this.registrationAccessToken);
    JsonUtil.putIfNotNull(localJSONObject, "registration_client_uri", this.registrationClientUri);
    JsonUtil.putIfNotNull(localJSONObject, "token_endpoint_auth_method", this.tokenEndpointAuthMethod);
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
    private Map<String, String> mAdditionalParameters = Collections.emptyMap();
    @NonNull
    private String mClientId;
    @Nullable
    private Long mClientIdIssuedAt;
    @Nullable
    private String mClientSecret;
    @Nullable
    private Long mClientSecretExpiresAt;
    @Nullable
    private String mRegistrationAccessToken;
    @Nullable
    private Uri mRegistrationClientUri;
    @NonNull
    private RegistrationRequest mRequest;
    @Nullable
    private String mTokenEndpointAuthMethod;
    
    public Builder(@NonNull RegistrationRequest paramRegistrationRequest)
    {
      setRequest(paramRegistrationRequest);
    }
    
    public RegistrationResponse build()
    {
      return new RegistrationResponse(this.mRequest, this.mClientId, this.mClientIdIssuedAt, this.mClientSecret, this.mClientSecretExpiresAt, this.mRegistrationAccessToken, this.mRegistrationClientUri, this.mTokenEndpointAuthMethod, this.mAdditionalParameters, null);
    }
    
    @NonNull
    public Builder fromResponseJson(@NonNull JSONObject paramJSONObject)
      throws JSONException, RegistrationResponse.MissingArgumentException
    {
      setClientId(JsonUtil.getString(paramJSONObject, "client_id"));
      setClientIdIssuedAt(JsonUtil.getLongIfDefined(paramJSONObject, "client_id_issued_at"));
      if (paramJSONObject.has("client_secret"))
      {
        if (!paramJSONObject.has("client_secret_expires_at")) {
          throw new RegistrationResponse.MissingArgumentException("client_secret_expires_at");
        }
        setClientSecret(paramJSONObject.getString("client_secret"));
        setClientSecretExpiresAt(Long.valueOf(paramJSONObject.getLong("client_secret_expires_at")));
      }
      if (paramJSONObject.has("registration_access_token") != paramJSONObject.has("registration_client_uri"))
      {
        if (paramJSONObject.has("registration_access_token")) {}
        for (paramJSONObject = "registration_client_uri";; paramJSONObject = "registration_access_token") {
          throw new RegistrationResponse.MissingArgumentException(paramJSONObject);
        }
      }
      setRegistrationAccessToken(JsonUtil.getStringIfDefined(paramJSONObject, "registration_access_token"));
      setRegistrationClientUri(JsonUtil.getUriIfDefined(paramJSONObject, "registration_client_uri"));
      setTokenEndpointAuthMethod(JsonUtil.getStringIfDefined(paramJSONObject, "token_endpoint_auth_method"));
      setAdditionalParameters(AdditionalParamsProcessor.extractAdditionalParams(paramJSONObject, RegistrationResponse.BUILT_IN_PARAMS));
      return this;
    }
    
    @NonNull
    public Builder fromResponseJsonString(@NonNull String paramString)
      throws JSONException, RegistrationResponse.MissingArgumentException
    {
      Preconditions.checkNotEmpty(paramString, "json cannot be null or empty");
      return fromResponseJson(new JSONObject(paramString));
    }
    
    public Builder setAdditionalParameters(Map<String, String> paramMap)
    {
      this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(paramMap, RegistrationResponse.BUILT_IN_PARAMS);
      return this;
    }
    
    public Builder setClientId(@NonNull String paramString)
    {
      Preconditions.checkNotEmpty(paramString, "client ID cannot be null or empty");
      this.mClientId = paramString;
      return this;
    }
    
    public Builder setClientIdIssuedAt(@Nullable Long paramLong)
    {
      this.mClientIdIssuedAt = paramLong;
      return this;
    }
    
    public Builder setClientSecret(@Nullable String paramString)
    {
      this.mClientSecret = paramString;
      return this;
    }
    
    public Builder setClientSecretExpiresAt(@Nullable Long paramLong)
    {
      this.mClientSecretExpiresAt = paramLong;
      return this;
    }
    
    public Builder setRegistrationAccessToken(@Nullable String paramString)
    {
      this.mRegistrationAccessToken = paramString;
      return this;
    }
    
    public Builder setRegistrationClientUri(@Nullable Uri paramUri)
    {
      this.mRegistrationClientUri = paramUri;
      return this;
    }
    
    @NonNull
    public Builder setRequest(@NonNull RegistrationRequest paramRegistrationRequest)
    {
      this.mRequest = ((RegistrationRequest)Preconditions.checkNotNull(paramRegistrationRequest, "request cannot be null"));
      return this;
    }
    
    public Builder setTokenEndpointAuthMethod(@Nullable String paramString)
    {
      this.mTokenEndpointAuthMethod = paramString;
      return this;
    }
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
 * Qualified Name:     net.openid.appauth.RegistrationResponse
 * JD-Core Version:    0.7.0.1
 */