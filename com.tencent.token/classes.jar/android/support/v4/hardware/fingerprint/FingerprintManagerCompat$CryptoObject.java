package android.support.v4.hardware.fingerprint;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class FingerprintManagerCompat$CryptoObject
{
  private final Cipher mCipher;
  private final Mac mMac;
  private final Signature mSignature;
  
  public FingerprintManagerCompat$CryptoObject(@NonNull Signature paramSignature)
  {
    this.mSignature = paramSignature;
    this.mCipher = null;
    this.mMac = null;
  }
  
  public FingerprintManagerCompat$CryptoObject(@NonNull Cipher paramCipher)
  {
    this.mCipher = paramCipher;
    this.mSignature = null;
    this.mMac = null;
  }
  
  public FingerprintManagerCompat$CryptoObject(@NonNull Mac paramMac)
  {
    this.mMac = paramMac;
    this.mCipher = null;
    this.mSignature = null;
  }
  
  @Nullable
  public Cipher getCipher()
  {
    return this.mCipher;
  }
  
  @Nullable
  public Mac getMac()
  {
    return this.mMac;
  }
  
  @Nullable
  public Signature getSignature()
  {
    return this.mSignature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompat.CryptoObject
 * JD-Core Version:    0.7.0.1
 */