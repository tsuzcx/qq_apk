package com.tencent.qqmail.view.fingerprint;

public abstract interface BaseFingerprintManager
{
  public abstract boolean isAvailable();
  
  public abstract boolean isEnrolled();
  
  public abstract boolean isHarewareDetected();
  
  public abstract boolean isSettingOn();
  
  public abstract void setCallback(Callback paramCallback);
  
  public abstract void startListening();
  
  public abstract void stopListening();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.BaseFingerprintManager
 * JD-Core Version:    0.7.0.1
 */