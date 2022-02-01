package com.tencent.qqmail.view.fingerprint;

import android.annotation.SuppressLint;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.os.CancellationSignal;
import androidx.core.app.ActivityCompat;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

@SuppressLint({"NewApi"})
class QMFingerprintManager
  extends FingerprintManager.AuthenticationCallback
  implements BaseFingerprintManager
{
  public static final String TAG = "QMFingerprintManager";
  private Callback callback;
  private CancellationSignal cancellationSignal;
  private FingerprintManager fingerprintManager = (FingerprintManager)QMApplicationContext.sharedInstance().getSystemService("fingerprint");
  
  public boolean isAvailable()
  {
    return (isSettingOn()) && (isEnrolled()) && (isHarewareDetected());
  }
  
  public boolean isEnrolled()
  {
    if (!isHarewareDetected()) {}
    while ((!VersionUtils.hasMarshmallow()) || (ActivityCompat.checkSelfPermission(QMApplicationContext.sharedInstance(), "android.permission.USE_FINGERPRINT") != 0)) {
      return false;
    }
    return this.fingerprintManager.hasEnrolledFingerprints();
  }
  
  public boolean isHarewareDetected()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (VersionUtils.hasMarshmallow())
    {
      bool1 = bool2;
      if (ActivityCompat.checkSelfPermission(QMApplicationContext.sharedInstance(), "android.permission.USE_FINGERPRINT") == 0) {
        bool1 = this.fingerprintManager.isHardwareDetected();
      }
    }
    return bool1;
  }
  
  public boolean isSettingOn()
  {
    return SharedPreferenceUtil.isFingerprintOpen();
  }
  
  public void onAuthenticationError(int paramInt, CharSequence paramCharSequence)
  {
    super.onAuthenticationError(paramInt, paramCharSequence);
    QMLog.log(4, "QMFingerprintManager", "onAuthenticationError errorCode = " + paramInt + " errString = " + paramCharSequence);
    if ((paramInt == 7) && (this.callback != null)) {
      this.callback.onError();
    }
  }
  
  public void onAuthenticationFailed()
  {
    super.onAuthenticationFailed();
    QMLog.log(4, "QMFingerprintManager", "onAuthenticationFailed");
    if (this.callback != null) {
      this.callback.onFail();
    }
  }
  
  public void onAuthenticationHelp(int paramInt, CharSequence paramCharSequence)
  {
    super.onAuthenticationHelp(paramInt, paramCharSequence);
    QMLog.log(4, "QMFingerprintManager", "onAuthenticationHelp helpCode = " + paramInt + " helpString = " + paramCharSequence);
  }
  
  public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult paramAuthenticationResult)
  {
    super.onAuthenticationSucceeded(paramAuthenticationResult);
    QMLog.log(4, "QMFingerprintManager", "onAuthenticationSucceeded");
    if (this.callback != null) {
      this.callback.onAuthenticated();
    }
  }
  
  public void setCallback(Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  public void startListening()
  {
    QMLog.log(4, "QMFingerprintManager", "startListening");
    if (ActivityCompat.checkSelfPermission(QMApplicationContext.sharedInstance(), "android.permission.USE_FINGERPRINT") == 0)
    {
      this.cancellationSignal = new CancellationSignal();
      this.fingerprintManager.authenticate(null, this.cancellationSignal, 0, this, null);
    }
  }
  
  public void stopListening()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("stopListening ");
    if (this.cancellationSignal != null) {}
    for (boolean bool = true;; bool = false)
    {
      QMLog.log(4, "QMFingerprintManager", bool);
      if (this.cancellationSignal != null)
      {
        this.cancellationSignal.cancel();
        this.cancellationSignal = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.QMFingerprintManager
 * JD-Core Version:    0.7.0.1
 */