package com.tencent.qqmail.view.fingerprint;

import android.util.Log;
import com.fingerprints.service.FingerprintManager;
import com.fingerprints.service.FingerprintManager.IdentifyCallback;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

class MeizuFingerprintManager
  implements FingerprintManager.IdentifyCallback, BaseFingerprintManager
{
  public static final String TAG = "MeizuFingerprintManager";
  private Callback callback;
  private FingerprintManager fingerprintManager;
  
  private void releasefingerprintManager()
  {
    Log.i("MeizuFingerprintManager", "releasefingerprintManager " + this.fingerprintManager);
    if (this.fingerprintManager != null) {}
    try
    {
      this.fingerprintManager.release();
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "MeizuFingerprintManager", "releasefingerprintManager exception");
    }
  }
  
  private void updateFingerprintManager()
  {
    Log.i("MeizuFingerprintManager", "updateFingerprintManager " + this.fingerprintManager);
    this.fingerprintManager = FingerprintManager.open();
  }
  
  public boolean isAvailable()
  {
    return (isSettingOn()) && (isEnrolled()) && (isHarewareDetected());
  }
  
  public boolean isEnrolled()
  {
    Log.i("MeizuFingerprintManager", "isEnrolled");
    updateFingerprintManager();
    int[] arrayOfInt = this.fingerprintManager.getIds();
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      releasefingerprintManager();
      return bool;
    }
  }
  
  public boolean isHarewareDetected()
  {
    boolean bool2 = false;
    Log.i("MeizuFingerprintManager", "isHarewareDetected");
    updateFingerprintManager();
    boolean bool1 = bool2;
    if (VersionUtils.hasLolipop())
    {
      bool1 = bool2;
      if (this.fingerprintManager != null)
      {
        bool1 = bool2;
        if (this.fingerprintManager.isSurpport()) {
          bool1 = true;
        }
      }
    }
    releasefingerprintManager();
    return bool1;
  }
  
  public boolean isSettingOn()
  {
    Log.i("MeizuFingerprintManager", "isSettingOn");
    return SharedPreferenceUtil.isFingerprintOpen();
  }
  
  public void onIdentified(int paramInt, boolean paramBoolean)
  {
    Log.i("MeizuFingerprintManager", "onIdentified");
    if (this.callback != null) {
      this.callback.onAuthenticated();
    }
  }
  
  public void onNoMatch()
  {
    Log.i("MeizuFingerprintManager", "onNoMatch");
    if ((this.callback != null) && (this.callback.onFail()))
    {
      releasefingerprintManager();
      startListening();
    }
  }
  
  public void setCallback(Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  public void startListening()
  {
    Log.i("MeizuFingerprintManager", "startListening " + this.fingerprintManager);
    updateFingerprintManager();
    if (this.fingerprintManager != null) {
      this.fingerprintManager.startIdentify(this, this.fingerprintManager.getIds());
    }
  }
  
  public void stopListening()
  {
    Log.i("MeizuFingerprintManager", "stopListening" + this.fingerprintManager);
    releasefingerprintManager();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.MeizuFingerprintManager
 * JD-Core Version:    0.7.0.1
 */