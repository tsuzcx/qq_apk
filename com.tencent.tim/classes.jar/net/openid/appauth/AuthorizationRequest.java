package net.openid.appauth;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class AuthorizationRequest
{
  private static final Set<String> BUILT_IN_PARAMS = AdditionalParamsProcessor.builtInParams(new String[] { "client_id", "code_challenge", "code_challenge_method", "display", "login_hint", "prompt", "redirect_uri", "response_mode", "response_type", "scope", "state" });
  public static final String CODE_CHALLENGE_METHOD_PLAIN = "plain";
  public static final String CODE_CHALLENGE_METHOD_S256 = "S256";
  private static final String KEY_ADDITIONAL_PARAMETERS = "additionalParameters";
  private static final String KEY_CLIENT_ID = "clientId";
  private static final String KEY_CODE_VERIFIER = "codeVerifier";
  private static final String KEY_CODE_VERIFIER_CHALLENGE = "codeVerifierChallenge";
  private static final String KEY_CODE_VERIFIER_CHALLENGE_METHOD = "codeVerifierChallengeMethod";
  private static final String KEY_CONFIGURATION = "configuration";
  private static final String KEY_DISPLAY = "display";
  private static final String KEY_LOGIN_HINT = "login_hint";
  private static final String KEY_PROMPT = "prompt";
  private static final String KEY_REDIRECT_URI = "redirectUri";
  private static final String KEY_RESPONSE_MODE = "responseMode";
  private static final String KEY_RESPONSE_TYPE = "responseType";
  private static final String KEY_SCOPE = "scope";
  private static final String KEY_STATE = "state";
  @VisibleForTesting
  static final String PARAM_CLIENT_ID = "client_id";
  @VisibleForTesting
  static final String PARAM_CODE_CHALLENGE = "code_challenge";
  @VisibleForTesting
  static final String PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
  @VisibleForTesting
  static final String PARAM_DISPLAY = "display";
  @VisibleForTesting
  static final String PARAM_LOGIN_HINT = "login_hint";
  @VisibleForTesting
  static final String PARAM_PROMPT = "prompt";
  @VisibleForTesting
  static final String PARAM_REDIRECT_URI = "redirect_uri";
  @VisibleForTesting
  static final String PARAM_RESPONSE_MODE = "response_mode";
  @VisibleForTesting
  static final String PARAM_RESPONSE_TYPE = "response_type";
  @VisibleForTesting
  static final String PARAM_SCOPE = "scope";
  @VisibleForTesting
  static final String PARAM_STATE = "state";
  private static final int STATE_LENGTH = 16;
  @NonNull
  public final Map<String, String> additionalParameters;
  @NonNull
  public final String clientId;
  @Nullable
  public final String codeVerifier;
  @Nullable
  public final String codeVerifierChallenge;
  @Nullable
  public final String codeVerifierChallengeMethod;
  @NonNull
  public final AuthorizationServiceConfiguration configuration;
  @Nullable
  public final String display;
  @Nullable
  public final String loginHint;
  @Nullable
  public final String prompt;
  @NonNull
  public final Uri redirectUri;
  @Nullable
  public final String responseMode;
  @NonNull
  public final String responseType;
  @Nullable
  public final String scope;
  @Nullable
  public final String state;
  
  private AuthorizationRequest(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @NonNull String paramString1, @NonNull String paramString2, @NonNull Uri paramUri, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable String paramString7, @Nullable String paramString8, @Nullable String paramString9, @Nullable String paramString10, @Nullable String paramString11, @NonNull Map<String, String> paramMap)
  {
    this.configuration = paramAuthorizationServiceConfiguration;
    this.clientId = paramString1;
    this.responseType = paramString2;
    this.redirectUri = paramUri;
    this.additionalParameters = paramMap;
    this.display = paramString3;
    this.loginHint = paramString4;
    this.prompt = paramString5;
    this.scope = paramString6;
    this.state = paramString7;
    this.codeVerifier = paramString8;
    this.codeVerifierChallenge = paramString9;
    this.codeVerifierChallengeMethod = paramString10;
    this.responseMode = paramString11;
  }
  
  private static String generateRandomState()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return Base64.encodeToString(arrayOfByte, 11);
  }
  
  @NonNull
  public static AuthorizationRequest jsonDeserialize(@NonNull String paramString)
    throws JSONException
  {
    Preconditions.checkNotNull(paramString, "json string cannot be null");
    return jsonDeserialize(new JSONObject(paramString));
  }
  
  @NonNull
  public static AuthorizationRequest jsonDeserialize(@NonNull JSONObject paramJSONObject)
    throws JSONException
  {
    Preconditions.checkNotNull(paramJSONObject, "json cannot be null");
    Builder localBuilder = new Builder(AuthorizationServiceConfiguration.fromJson(paramJSONObject.getJSONObject("configuration")), JsonUtil.getString(paramJSONObject, "clientId"), JsonUtil.getString(paramJSONObject, "responseType"), JsonUtil.getUri(paramJSONObject, "redirectUri")).setDisplay(JsonUtil.getStringIfDefined(paramJSONObject, "display")).setLoginHint(JsonUtil.getStringIfDefined(paramJSONObject, "login_hint")).setPrompt(JsonUtil.getStringIfDefined(paramJSONObject, "prompt")).setState(JsonUtil.getStringIfDefined(paramJSONObject, "state")).setCodeVerifier(JsonUtil.getStringIfDefined(paramJSONObject, "codeVerifier"), JsonUtil.getStringIfDefined(paramJSONObject, "codeVerifierChallenge"), JsonUtil.getStringIfDefined(paramJSONObject, "codeVerifierChallengeMethod")).setResponseMode(JsonUtil.getStringIfDefined(paramJSONObject, "responseMode")).setAdditionalParameters(JsonUtil.getStringMap(paramJSONObject, "additionalParameters"));
    if (paramJSONObject.has("scope")) {
      localBuilder.setScopes(AsciiStringListUtil.stringToSet(JsonUtil.getString(paramJSONObject, "scope")));
    }
    return localBuilder.build();
  }
  
  public Set<String> getPromptValues()
  {
    return AsciiStringListUtil.stringToSet(this.prompt);
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
    JsonUtil.put(localJSONObject, "responseType", this.responseType);
    JsonUtil.put(localJSONObject, "redirectUri", this.redirectUri.toString());
    JsonUtil.putIfNotNull(localJSONObject, "display", this.display);
    JsonUtil.putIfNotNull(localJSONObject, "login_hint", this.loginHint);
    JsonUtil.putIfNotNull(localJSONObject, "scope", this.scope);
    JsonUtil.putIfNotNull(localJSONObject, "prompt", this.prompt);
    JsonUtil.putIfNotNull(localJSONObject, "state", this.state);
    JsonUtil.putIfNotNull(localJSONObject, "codeVerifier", this.codeVerifier);
    JsonUtil.putIfNotNull(localJSONObject, "codeVerifierChallenge", this.codeVerifierChallenge);
    JsonUtil.putIfNotNull(localJSONObject, "codeVerifierChallengeMethod", this.codeVerifierChallengeMethod);
    JsonUtil.putIfNotNull(localJSONObject, "responseMode", this.responseMode);
    JsonUtil.put(localJSONObject, "additionalParameters", JsonUtil.mapToJsonObject(this.additionalParameters));
    return localJSONObject;
  }
  
  public String jsonSerializeString()
  {
    return jsonSerialize().toString();
  }
  
  @NonNull
  public Uri toUri()
  {
    Uri.Builder localBuilder = this.configuration.authorizationEndpoint.buildUpon().appendQueryParameter("redirect_uri", this.redirectUri.toString()).appendQueryParameter("client_id", this.clientId).appendQueryParameter("response_type", this.responseType);
    UriUtil.appendQueryParameterIfNotNull(localBuilder, "display", this.display);
    UriUtil.appendQueryParameterIfNotNull(localBuilder, "login_hint", this.loginHint);
    UriUtil.appendQueryParameterIfNotNull(localBuilder, "prompt", this.prompt);
    UriUtil.appendQueryParameterIfNotNull(localBuilder, "state", this.state);
    UriUtil.appendQueryParameterIfNotNull(localBuilder, "scope", this.scope);
    UriUtil.appendQueryParameterIfNotNull(localBuilder, "response_mode", this.responseMode);
    if (this.codeVerifier != null) {
      localBuilder.appendQueryParameter("code_challenge", this.codeVerifierChallenge).appendQueryParameter("code_challenge_method", this.codeVerifierChallengeMethod);
    }
    Iterator localIterator = this.additionalParameters.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBuilder.appendQueryParameter((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    return localBuilder.build();
  }
  
  public static final class Builder
  {
    @NonNull
    private Map<String, String> mAdditionalParameters = new HashMap();
    @NonNull
    private String mClientId;
    @Nullable
    private String mCodeVerifier;
    @Nullable
    private String mCodeVerifierChallenge;
    @Nullable
    private String mCodeVerifierChallengeMethod;
    @NonNull
    private AuthorizationServiceConfiguration mConfiguration;
    @Nullable
    private String mDisplay;
    @Nullable
    private String mLoginHint;
    @Nullable
    private String mPrompt;
    @NonNull
    private Uri mRedirectUri;
    @Nullable
    private String mResponseMode;
    @NonNull
    private String mResponseType;
    @Nullable
    private String mScope;
    @Nullable
    private String mState;
    
    public Builder(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration, @NonNull String paramString1, @NonNull String paramString2, @NonNull Uri paramUri)
    {
      setAuthorizationServiceConfiguration(paramAuthorizationServiceConfiguration);
      setClientId(paramString1);
      setResponseType(paramString2);
      setRedirectUri(paramUri);
      setState(AuthorizationRequest.access$000());
      setCodeVerifier(CodeVerifierUtil.generateRandomCodeVerifier());
    }
    
    @NonNull
    public AuthorizationRequest build()
    {
      return new AuthorizationRequest(this.mConfiguration, this.mClientId, this.mResponseType, this.mRedirectUri, this.mDisplay, this.mLoginHint, this.mPrompt, this.mScope, this.mState, this.mCodeVerifier, this.mCodeVerifierChallenge, this.mCodeVerifierChallengeMethod, this.mResponseMode, Collections.unmodifiableMap(new HashMap(this.mAdditionalParameters)), null);
    }
    
    @NonNull
    public Builder setAdditionalParameters(@Nullable Map<String, String> paramMap)
    {
      this.mAdditionalParameters = AdditionalParamsProcessor.checkAdditionalParams(paramMap, AuthorizationRequest.BUILT_IN_PARAMS);
      return this;
    }
    
    public Builder setAuthorizationServiceConfiguration(@NonNull AuthorizationServiceConfiguration paramAuthorizationServiceConfiguration)
    {
      this.mConfiguration = ((AuthorizationServiceConfiguration)Preconditions.checkNotNull(paramAuthorizationServiceConfiguration, "configuration cannot be null"));
      return this;
    }
    
    @NonNull
    public Builder setClientId(@NonNull String paramString)
    {
      this.mClientId = Preconditions.checkNotEmpty(paramString, "client ID cannot be null or empty");
      return this;
    }
    
    @NonNull
    public Builder setCodeVerifier(@Nullable String paramString)
    {
      if (paramString != null)
      {
        CodeVerifierUtil.checkCodeVerifier(paramString);
        this.mCodeVerifier = paramString;
        this.mCodeVerifierChallenge = CodeVerifierUtil.deriveCodeVerifierChallenge(paramString);
        this.mCodeVerifierChallengeMethod = CodeVerifierUtil.getCodeVerifierChallengeMethod();
        return this;
      }
      this.mCodeVerifier = null;
      this.mCodeVerifierChallenge = null;
      this.mCodeVerifierChallengeMethod = null;
      return this;
    }
    
    @NonNull
    public Builder setCodeVerifier(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3)
    {
      boolean bool2 = true;
      if (paramString1 != null)
      {
        CodeVerifierUtil.checkCodeVerifier(paramString1);
        Preconditions.checkNotEmpty(paramString2, "code verifier challenge cannot be null or empty if verifier is set");
        Preconditions.checkNotEmpty(paramString3, "code verifier challenge method cannot be null or empty if verifier is set");
        this.mCodeVerifier = paramString1;
        this.mCodeVerifierChallenge = paramString2;
        this.mCodeVerifierChallengeMethod = paramString3;
        return this;
      }
      if (paramString2 == null)
      {
        bool1 = true;
        label49:
        Preconditions.checkArgument(bool1, "code verifier challenge must be null if verifier is null");
        if (paramString3 != null) {
          break label80;
        }
      }
      label80:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        Preconditions.checkArgument(bool1, "code verifier challenge method must be null if verifier is null");
        break;
        bool1 = false;
        break label49;
      }
    }
    
    public Builder setDisplay(@Nullable String paramString)
    {
      this.mDisplay = Preconditions.checkNullOrNotEmpty(paramString, "display must be null or not empty");
      return this;
    }
    
    public Builder setLoginHint(@Nullable String paramString)
    {
      this.mLoginHint = Preconditions.checkNullOrNotEmpty(paramString, "login hint must be null or not empty");
      return this;
    }
    
    @NonNull
    public Builder setPrompt(@Nullable String paramString)
    {
      this.mPrompt = Preconditions.checkNullOrNotEmpty(paramString, "prompt must be null or non-empty");
      return this;
    }
    
    @NonNull
    public Builder setPromptValues(@Nullable Iterable<String> paramIterable)
    {
      this.mPrompt = AsciiStringListUtil.iterableToString(paramIterable);
      return this;
    }
    
    @NonNull
    public Builder setPromptValues(@Nullable String... paramVarArgs)
    {
      if (paramVarArgs == null)
      {
        this.mPrompt = null;
        return this;
      }
      return setPromptValues(Arrays.asList(paramVarArgs));
    }
    
    @NonNull
    public Builder setRedirectUri(@NonNull Uri paramUri)
    {
      this.mRedirectUri = ((Uri)Preconditions.checkNotNull(paramUri, "redirect URI cannot be null or empty"));
      return this;
    }
    
    @NonNull
    public Builder setResponseMode(@Nullable String paramString)
    {
      Preconditions.checkNullOrNotEmpty(paramString, "responseMode must not be empty");
      this.mResponseMode = paramString;
      return this;
    }
    
    @NonNull
    public Builder setResponseType(@NonNull String paramString)
    {
      this.mResponseType = Preconditions.checkNotEmpty(paramString, "expected response type cannot be null or empty");
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
    public Builder setState(@Nullable String paramString)
    {
      this.mState = Preconditions.checkNullOrNotEmpty(paramString, "state cannot be empty if defined");
      return this;
    }
  }
  
  public static final class Display
  {
    public static final String PAGE = "page";
    public static final String POPUP = "popup";
    public static final String TOUCH = "touch";
    public static final String WAP = "wap";
  }
  
  public static final class Prompt
  {
    public static final String CONSENT = "consent";
    public static final String LOGIN = "login";
    public static final String NONE = "none";
    public static final String SELECT_ACCOUNT = "select_account";
  }
  
  public static final class ResponseMode
  {
    public static final String FRAGMENT = "fragment";
    public static final String QUERY = "query";
  }
  
  public static final class Scope
  {
    public static final String ADDRESS = "address";
    public static final String EMAIL = "email";
    public static final String OFFLINE_ACCESS = "offline_access";
    public static final String OPENID = "openid";
    public static final String PHONE = "phone";
    public static final String PROFILE = "profile";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.AuthorizationRequest
 * JD-Core Version:    0.7.0.1
 */