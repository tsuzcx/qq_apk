package com.tencent.qqmail.view.fingerprint;

class EmptyFingerprintManager
  implements BaseFingerprintManager
{
  public static final String TAG = "EmptyFingerprintManager";
  
  public boolean isAvailable()
  {
    return false;
  }
  
  public boolean isEnrolled()
  {
    return false;
  }
  
  public boolean isHarewareDetected()
  {
    return false;
  }
  
  public boolean isSettingOn()
  {
    return false;
  }
  
  public void setCallback(Callback paramCallback) {}
  
  public void startListening() {}
  
  public void stopListening() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.EmptyFingerprintManager
 * JD-Core Version:    0.7.0.1
 */