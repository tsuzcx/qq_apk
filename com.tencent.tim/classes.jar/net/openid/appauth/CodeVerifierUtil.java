package net.openid.appauth;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeVerifierUtil
{
  public static final int DEFAULT_CODE_VERIFIER_ENTROPY = 64;
  public static final int MAX_CODE_VERIFIER_ENTROPY = 96;
  public static final int MAX_CODE_VERIFIER_LENGTH = 128;
  public static final int MIN_CODE_VERIFIER_ENTROPY = 32;
  public static final int MIN_CODE_VERIFIER_LENGTH = 43;
  private static final int PKCE_BASE64_ENCODE_SETTINGS = 11;
  private static final Pattern REGEX_CODE_VERIFIER = Pattern.compile("^[0-9a-zA-Z\\-\\.\\_\\~]{43,128}$");
  
  public static void checkCodeVerifier(String paramString)
  {
    boolean bool2 = true;
    if (43 <= paramString.length())
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "codeVerifier length is shorter than allowed by the PKCE specification");
      if (paramString.length() > 128) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "codeVerifier length is longer than allowed by the PKCE specification");
      Preconditions.checkArgument(REGEX_CODE_VERIFIER.matcher(paramString).matches(), "codeVerifier string contains illegal characters");
      return;
      bool1 = false;
      break;
    }
  }
  
  public static String deriveCodeVerifierChallenge(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("SHA-256");
      ((MessageDigest)localObject).update(paramString.getBytes("ISO_8859_1"));
      localObject = Base64.encodeToString(((MessageDigest)localObject).digest(), 11);
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Logger.warn("SHA-256 is not supported on this device! Using plain challenge", new Object[] { localNoSuchAlgorithmException });
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      Logger.error("ISO-8859-1 encoding not supported on this device!", new Object[] { paramString });
      throw new IllegalStateException("ISO-8859-1 encoding not supported", paramString);
    }
  }
  
  public static String generateRandomCodeVerifier()
  {
    return generateRandomCodeVerifier(new SecureRandom(), 64);
  }
  
  public static String generateRandomCodeVerifier(SecureRandom paramSecureRandom, int paramInt)
  {
    boolean bool2 = true;
    Preconditions.checkNotNull(paramSecureRandom, "entropySource cannot be null");
    if (32 <= paramInt)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "entropyBytes is less than the minimum permitted");
      if (paramInt > 96) {
        break label61;
      }
    }
    label61:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "entropyBytes is greater than the maximum permitted");
      byte[] arrayOfByte = new byte[paramInt];
      paramSecureRandom.nextBytes(arrayOfByte);
      return Base64.encodeToString(arrayOfByte, 11);
      bool1 = false;
      break;
    }
  }
  
  public static String getCodeVerifierChallengeMethod()
  {
    try
    {
      MessageDigest.getInstance("SHA-256");
      return "S256";
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return "plain";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.openid.appauth.CodeVerifierUtil
 * JD-Core Version:    0.7.0.1
 */