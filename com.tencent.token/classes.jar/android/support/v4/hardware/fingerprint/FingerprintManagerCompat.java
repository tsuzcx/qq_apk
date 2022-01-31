package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RequiresPermission;

public final class FingerprintManagerCompat
{
  private final Context mContext;
  
  private FingerprintManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  @NonNull
  public static FingerprintManagerCompat from(@NonNull Context paramContext)
  {
    return new FingerprintManagerCompat(paramContext);
  }
  
  @Nullable
  @RequiresApi(23)
  private static FingerprintManager getFingerprintManagerOrNull(@NonNull Context paramContext)
  {
    if (paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
      return (FingerprintManager)paramContext.getSystemService(FingerprintManager.class);
    }
    return null;
  }
  
  @RequiresApi(23)
  private static FingerprintManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FingerprintManagerCompat.CryptoObject(paramCryptoObject.getMac());
  }
  
  @RequiresApi(23)
  private static FingerprintManager.AuthenticationCallback wrapCallback(FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback)
  {
    return new FingerprintManagerCompat.1(paramAuthenticationCallback);
  }
  
  @RequiresApi(23)
  private static FingerprintManager.CryptoObject wrapCryptoObject(FingerprintManagerCompat.CryptoObject paramCryptoObject)
  {
    if (paramCryptoObject == null) {}
    do
    {
      return null;
      if (paramCryptoObject.getCipher() != null) {
        return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher());
      }
      if (paramCryptoObject.getSignature() != null) {
        return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature());
      }
    } while (paramCryptoObject.getMac() == null);
    return new FingerprintManager.CryptoObject(paramCryptoObject.getMac());
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public void authenticate(@Nullable FingerprintManagerCompat.CryptoObject paramCryptoObject, int paramInt, @Nullable android.support.v4.os.CancellationSignal paramCancellationSignal, @NonNull FingerprintManagerCompat.AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler)
  {
    FingerprintManager localFingerprintManager;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      if (localFingerprintManager != null) {
        if (paramCancellationSignal == null) {
          break label53;
        }
      }
    }
    label53:
    for (paramCancellationSignal = (android.os.CancellationSignal)paramCancellationSignal.getCancellationSignalObject();; paramCancellationSignal = null)
    {
      localFingerprintManager.authenticate(wrapCryptoObject(paramCryptoObject), paramCancellationSignal, paramInt, wrapCallback(paramAuthenticationCallback), paramHandler);
      return;
    }
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean hasEnrolledFingerprints()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      bool1 = bool2;
      if (localFingerprintManager != null)
      {
        bool1 = bool2;
        if (localFingerprintManager.hasEnrolledFingerprints()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @RequiresPermission("android.permission.USE_FINGERPRINT")
  public boolean isHardwareDetected()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      FingerprintManager localFingerprintManager = getFingerprintManagerOrNull(this.mContext);
      bool1 = bool2;
      if (localFingerprintManager != null)
      {
        bool1 = bool2;
        if (localFingerprintManager.isHardwareDetected()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.hardware.fingerprint.FingerprintManagerCompat
 * JD-Core Version:    0.7.0.1
 */