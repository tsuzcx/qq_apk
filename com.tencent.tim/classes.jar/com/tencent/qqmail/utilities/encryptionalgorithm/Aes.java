package com.tencent.qqmail.utilities.encryptionalgorithm;

import com.tencent.qqmail.utilities.deviceid.DeviceId;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;

public final class Aes
{
  private static String IMEI = "";
  private static final String TAG = "Aes";
  
  static
  {
    System.loadLibrary("stlport_shared");
    System.loadLibrary("Aes");
  }
  
  private static native String aesDecode(String paramString1, String paramString2);
  
  private static native String aesEncode(String paramString1, String paramString2);
  
  public static native byte[] aesRawDecode(byte[] paramArrayOfByte, String paramString);
  
  public static native byte[] aesRawEncode(byte[] paramArrayOfByte, String paramString);
  
  public static String decode(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return paramString1;
    }
    return aesDecode(paramString1, paramString2);
  }
  
  public static String encode(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return paramString1;
    }
    return aesEncode(paramString1, paramString2);
  }
  
  public static String getEncodeDeviceToken()
  {
    return RsaEncryption.encrypt(getPureDeviceToken());
  }
  
  public static String getIMEIKey()
  {
    if (IMEI.equals("")) {
      IMEI = DeviceId.getDeviceId4();
    }
    if ((IMEI == null) || (IMEI.length() == 0)) {
      throw new IllegalStateException("IMEI error");
    }
    return IMEI;
  }
  
  public static String getPureDeviceToken()
  {
    if (QMSharedPreferenceManager.getInstance().getDeviceId().equals(""))
    {
      DeviceInfo localDeviceInfo = DeviceUtil.getDeviceInfos();
      logDeviceIdGenerateData(new String[] { localDeviceInfo.DEVICE_ID, localDeviceInfo.BOARD, localDeviceInfo.BRAND, localDeviceInfo.CPU_ABI, localDeviceInfo.DEVICE, localDeviceInfo.DISPLAY, localDeviceInfo.HOST, localDeviceInfo.ID, localDeviceInfo.MANUFACTURER, localDeviceInfo.MODEL, localDeviceInfo.PRODUCT, localDeviceInfo.TYPE, localDeviceInfo.USER, localDeviceInfo.TAGS });
      QMSharedPreferenceManager.getInstance().setDeviceId(getPureDeviceToken(localDeviceInfo.DEVICE_ID, localDeviceInfo.BOARD, localDeviceInfo.BRAND, localDeviceInfo.CPU_ABI, localDeviceInfo.DEVICE, localDeviceInfo.DISPLAY, localDeviceInfo.HOST, localDeviceInfo.ID, localDeviceInfo.MANUFACTURER, localDeviceInfo.MODEL, localDeviceInfo.PRODUCT, localDeviceInfo.TYPE, localDeviceInfo.USER, localDeviceInfo.TAGS));
    }
    return QMSharedPreferenceManager.getInstance().getDeviceId();
  }
  
  private static native String getPureDeviceToken(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14);
  
  public static String getServerKey()
  {
    return "";
  }
  
  private static void logDeviceIdGenerateData(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("logDeviceIdGenerateData. ");
      int i = 0;
      while (i < paramVarArgs.length)
      {
        localStringBuilder.append(paramVarArgs[i]).append("#");
        i += 1;
      }
      QMLog.log(4, "AES", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.encryptionalgorithm.Aes
 * JD-Core Version:    0.7.0.1
 */