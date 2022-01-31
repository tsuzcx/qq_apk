package com.pay.googlewalletsdk.util;

import android.text.TextUtils;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class Security
{
  private static final String KEY_FACTORY_ALGORITHM = "RSA";
  private static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
  private static final String TAG = "IABUtil/Security";
  
  public static PublicKey generatePublicKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString);
      paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (InvalidKeySpecException paramString)
    {
      Log.e("IABUtil/Security", "Invalid key specification.");
      throw new IllegalArgumentException(paramString);
    }
    catch (Base64DecoderException paramString)
    {
      Log.e("IABUtil/Security", "Base64 decoding failed.");
      throw new IllegalArgumentException(paramString);
    }
  }
  
  public static boolean verify(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    try
    {
      Signature localSignature = Signature.getInstance("SHA1withRSA");
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramString1.getBytes());
      if (!localSignature.verify(Base64.decode(paramString2)))
      {
        Log.e("IABUtil/Security", "Signature verification failed.");
        return false;
      }
      return true;
    }
    catch (NoSuchAlgorithmException paramPublicKey)
    {
      Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
      return false;
    }
    catch (InvalidKeyException paramPublicKey)
    {
      Log.e("IABUtil/Security", "Invalid key specification.");
      return false;
    }
    catch (SignatureException paramPublicKey)
    {
      Log.e("IABUtil/Security", "Signature exception.");
      return false;
    }
    catch (Base64DecoderException paramPublicKey)
    {
      Log.e("IABUtil/Security", "Base64 decoding failed.");
    }
    return false;
  }
  
  public static boolean verifyPurchase(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 == null)
    {
      Log.e("IABUtil/Security", "data is null");
      return false;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!verify(generatePublicKey(paramString1), paramString2, paramString3)))
    {
      Log.w("IABUtil/Security", "signature does not match data.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.pay.googlewalletsdk.util.Security
 * JD-Core Version:    0.7.0.1
 */