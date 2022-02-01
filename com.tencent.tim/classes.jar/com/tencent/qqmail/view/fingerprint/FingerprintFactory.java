package com.tencent.qqmail.view.fingerprint;

import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.VersionUtils;

public class FingerprintFactory
{
  public static final String TAG = "FingerprintFactory";
  
  public static BaseFingerprintManager createInstance()
  {
    if (VersionUtils.hasMarshmallow()) {
      return new QMFingerprintManager();
    }
    if ((VersionUtils.hasLolipop()) && (BrandUtil.isMeizu())) {
      return new MeizuFingerprintManager();
    }
    return new EmptyFingerprintManager();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.FingerprintFactory
 * JD-Core Version:    0.7.0.1
 */