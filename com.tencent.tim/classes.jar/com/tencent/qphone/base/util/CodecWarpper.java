package com.tencent.qphone.base.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.atomic.AtomicBoolean;
import oicq.wlogin_sdk.tools.util;

public abstract class CodecWarpper
{
  public static final int CODE_FAIL = -1;
  public static final int CODE_FAIL_DECRYPT_BODY = -10;
  public static final int CODE_FAIL_DECRYPT_BY_SERVER = -11;
  public static final int CODE_FAIL_DECRYPT_DATA_LEN_ERROR = -5;
  public static final int CODE_FAIL_DECRYPT_EMPTY = -4;
  public static final int CODE_FAIL_DECRYPT_HEAD = -9;
  public static final int CODE_FAIL_DECRYPT_ONCE = -2;
  public static final int CODE_FAIL_DECRYPT_TWICE = -3;
  public static final int CODE_FAIL_PBUNPACK = -8;
  public static final int CODE_FAIL_ZLIB_DATA_LEN_SHORT = -6;
  public static final int CODE_FAIL_ZLIB_UNCOMPRESS_ERROR = -7;
  public static final int CODE_SUCC_DECRYPT_ONCE = 1;
  public static final int CODE_SUCC_DECRYPT_TWICE = 2;
  private static final String KEY_IS_CRYPT_LOG_OPEN = "is_crypt_log_open";
  private static final String KEY_IS_DECRYPT_FAIL = "is_decrypt_fail";
  private static final String KEY_LAST_UPDATE_TIME = "last_update_time";
  private static final String KEY_MANAGER_ENABLE_CRYPT = "manager_enable_crypt";
  private static final String SP_CRYPT = "sp_crypt";
  private static final long TWENTY_FOUR_HOUR = 86400000L;
  private static int appid;
  private static int checkedSOVersion;
  public static boolean isLoaded;
  private static AtomicBoolean sIsCryptLogOpen;
  public static int soLoadResultCode;
  public static String tag = "MSF.C.CodecWarpper";
  
  static
  {
    checkedSOVersion = 0;
    appid = 0;
    isLoaded = false;
    soLoadResultCode = 0;
    sIsCryptLogOpen = null;
    long l = SystemClock.elapsedRealtime();
    soLoadResultCode = StringUtils.msfLoadSo(tag, "codecwrapperV2");
    isLoaded = StringUtils.getLoadResult(soLoadResultCode);
    QLog.e(tag, 1, "loadso codecwrapperV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - l));
    if (!isLoaded) {}
    try
    {
      isLoaded = StringUtils.loadLibrary(tag, "codecwrapperV2", BaseApplication.getContext());
      MsfCore.sCore.bLoadUseTxlib = isLoaded;
      QLog.e(tag, 1, "loadso again codecwrapperV2 " + isLoaded + " by txlib. cost=" + (SystemClock.elapsedRealtime() - l));
      checkSOVersion();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        isLoaded = false;
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static void checkSOVersion()
  {
    try
    {
      appid = getAppid();
      QLog.i(tag, 1, "checkSO so_appid=" + appid);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      for (;;)
      {
        try
        {
          checkedSOVersion = getSOVersion();
          QLog.d(tag, 1, "checkSO version=" + checkedSOVersion);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
        {
          int i;
          try
          {
            i = getVersionCode();
            if ((i == 8) || (i == 9))
            {
              checkedSOVersion = 591;
              QLog.d(tag, 1, "set so version to " + checkedSOVersion + " with error ", localUnsatisfiedLinkError2);
              k.a("codecwrapperV2", isLoaded, soLoadResultCode, localUnsatisfiedLinkError2.getMessage());
              return;
            }
          }
          catch (Throwable localThrowable3)
          {
            checkedSOVersion = 591;
            QLog.d(tag, 1, "set so version to 591 with deep error ", localUnsatisfiedLinkError2);
            return;
          }
          if ((i != 10) && (i != 11)) {
            continue;
          }
          checkedSOVersion = 595;
          continue;
        }
        catch (Throwable localThrowable2)
        {
          QLog.d(tag, 1, "set so version failed ", localThrowable2);
        }
        localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
        QLog.w(tag, 1, "getAppid UnsatisfiedLinkError. ", localUnsatisfiedLinkError1);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.w(tag, 1, "getAppid error. ", localThrowable1);
      }
    }
  }
  
  private static native void closeReceData();
  
  private static synchronized native byte[] decodePingRequest(byte[] paramArrayOfByte);
  
  private static synchronized native byte[] encodePingRequest(byte[] paramArrayOfByte);
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean);
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, boolean paramBoolean);
  
  private static synchronized native byte[] encodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean);
  
  public static native int getAppid();
  
  public static native byte[] getFileStoreKey();
  
  public static native int getMaxPackageSize();
  
  public static native long getPacketLossLength(int paramInt);
  
  public static native int getSOVersion();
  
  public static int getSharedObjectVersion()
  {
    return checkedSOVersion;
  }
  
  public static native int getVersionCode();
  
  public static boolean isCryptLogOpen()
  {
    boolean bool1 = false;
    if (sIsCryptLogOpen == null)
    {
      boolean bool2 = BaseApplication.getContext().getSharedPreferences("sp_crypt", 4).getBoolean("is_crypt_log_open", false);
      QLog.d(tag, 1, "isCryptLogOpen = " + bool2 + ", isPublic = " + true);
      if (bool2) {
        break label83;
      }
    }
    for (;;)
    {
      sIsCryptLogOpen = new AtomicBoolean(bool1);
      return sIsCryptLogOpen.get();
      label83:
      bool1 = true;
    }
  }
  
  public static boolean isDecryptFail()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("sp_crypt", 4);
    boolean bool3 = localSharedPreferences.getBoolean("manager_enable_crypt", false);
    boolean bool1 = localSharedPreferences.getBoolean("is_decrypt_fail", false);
    long l = localSharedPreferences.getLong("last_update_time", 0L);
    if (System.currentTimeMillis() - l >= 86400000L) {
      bool1 = false;
    }
    QLog.d(tag, 1, "isDecryptFail, isPublicVersion = true, managerEnable = " + bool3 + ", isDecryptFail = " + bool1);
    if (bool1) {
      bool1 = true;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (bool3);
    return true;
  }
  
  private static native boolean isNeedEncryptWithHardKey();
  
  public static boolean isNeedEncryptWithHardKeyN()
  {
    try
    {
      boolean bool = isNeedEncryptWithHardKey();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(tag, 1, "isNeedEncryptWithHardKeyN throw e", localThrowable);
    }
    return true;
  }
  
  public static byte[] nativeDecodePingRequest(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = decodePingRequest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e(tag, 1, "nativeDecodePingRequest throw e", paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] nativeEncodePingRequest(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = encodePingRequest(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      QLog.e(tag, 1, "nativeEncodePingRequest throw e", paramArrayOfByte);
    }
    return null;
  }
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      paramString1 = encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramByte3, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramBoolean);
      return paramString1;
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString1 = localObject;
      } while (!QLog.isColorLevel());
      QLog.i(tag, 2, "nativeEncodeRequest 1 exception", paramString2);
    }
    return null;
  }
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      paramString1 = encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramArrayOfByte2, paramBoolean);
      return paramString1;
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString1 = localObject;
      } while (!QLog.isColorLevel());
      QLog.i(tag, 2, "nativeEncodeRequest 3 exception", paramString2);
    }
    return null;
  }
  
  public static byte[] nativeEncodeRequest(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, String paramString6, byte paramByte1, byte paramByte2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      paramString1 = encodeRequest(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramArrayOfByte1, paramInt2, paramInt3, paramString6, paramByte1, paramByte2, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramBoolean);
      return paramString1;
    }
    catch (Exception paramString2)
    {
      do
      {
        paramString1 = localObject;
      } while (!QLog.isColorLevel());
      QLog.i(tag, 2, "nativeEncodeRequest 2 exception", paramString2);
    }
    return null;
  }
  
  public static void nativeOnConnClose() {}
  
  public static void nativeRemoveAccountKey(String paramString)
  {
    removeAccountKey(paramString);
  }
  
  public static void nativeSetAccountKey(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("nativeSetAccountKey ");
    localStringBuilder.append(",uin=").append(MsfSdkUtils.getShortUin(paramString1));
    printBytes(",A1=", paramArrayOfByte1, localStringBuilder);
    printBytes(",A2=", paramArrayOfByte2, localStringBuilder);
    printBytes(",A3=", paramArrayOfByte3, localStringBuilder);
    printBytes(",D1=", paramArrayOfByte4, localStringBuilder);
    printBytes(",D2=", paramArrayOfByte5, localStringBuilder);
    printBytes(",S2=", paramArrayOfByte6, localStringBuilder);
    printBytes(",key=", paramArrayOfByte7, localStringBuilder);
    printBytes(",cookie=", paramArrayOfByte8, localStringBuilder);
    QLog.d(tag, 1, localStringBuilder.toString());
    setAccountKey(paramString1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfByte6, paramArrayOfByte7, paramArrayOfByte8, paramString2);
  }
  
  public static void nativeSetKsid(byte[] paramArrayOfByte)
  {
    setKsid(paramArrayOfByte);
  }
  
  public static void nativeSetUseSimpleHead(String paramString, boolean paramBoolean)
  {
    setUseSimpleHead(paramString, paramBoolean);
  }
  
  private static synchronized native void onConnClose();
  
  private native void onReceData(byte[] paramArrayOfByte, int paramInt);
  
  private native FromServiceMsg parseData(byte[] paramArrayOfByte);
  
  public static void printBytes(String paramString, byte[] paramArrayOfByte, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramString);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      paramStringBuilder.append("null");
      return;
    }
    paramStringBuilder.append(paramArrayOfByte.length).append("|").append(util.buf_to_string(paramArrayOfByte, 1));
  }
  
  private static synchronized native void removeAccountKey(String paramString);
  
  public static void saveDecryptFail(boolean paramBoolean, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("sp_crypt", 4).edit();
    localEditor.putBoolean("is_decrypt_fail", paramBoolean);
    localEditor.putLong("last_update_time", System.currentTimeMillis());
    localEditor.apply();
    if (QLog.isColorLevel()) {
      QLog.d(tag, 2, "saveDecryptFail, val = " + paramBoolean + ", from = " + paramInt);
    }
  }
  
  private static synchronized native void setAccountKey(String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, String paramString2);
  
  private static native void setDecryptFail(boolean paramBoolean, int paramInt);
  
  public static void setDecryptFailN(boolean paramBoolean, int paramInt)
  {
    try
    {
      setDecryptFail(paramBoolean, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(tag, 1, "setDecryptFailN throw e", localThrowable);
    }
  }
  
  private static native void setIsNeedEncryptWithHardKeyFromSer(boolean paramBoolean);
  
  public static void setIsNeedEncryptWithHardKeyFromSerN(boolean paramBoolean)
  {
    try
    {
      setIsNeedEncryptWithHardKeyFromSer(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(tag, 1, "setIsNeedEncryptWithHardKeyFromSerN throw e", localThrowable);
    }
  }
  
  private static synchronized native void setKsid(byte[] paramArrayOfByte);
  
  public static native void setMaxPackageSize(int paramInt);
  
  private static synchronized native void setUseSimpleHead(String paramString, boolean paramBoolean);
  
  public native void init(Context paramContext, boolean paramBoolean);
  
  public void nativeClearReceData()
  {
    if (QLog.isColorLevel()) {
      QLog.i(tag, 2, "nativeClearReceData");
    }
    try
    {
      closeReceData();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      k.a("codecwrapperV2", isLoaded, soLoadResultCode, localUnsatisfiedLinkError.getMessage());
    }
  }
  
  public void nativeOnReceData(byte[] paramArrayOfByte, int paramInt)
  {
    if ((QLog.isDevelopLevel()) || (isCryptLogOpen())) {
      QLog.d(tag, 1, "nativeOnReceData tcp, size = " + paramArrayOfByte.length + ", s = " + StringUtils.bytes2Str(paramArrayOfByte));
    }
    for (;;)
    {
      onReceData(paramArrayOfByte, paramInt);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(tag, 2, "nativeOnReceData tcp, size = " + paramArrayOfByte.length + ", bytes = " + StringUtils.bytes2ShortStr(paramArrayOfByte));
      }
    }
  }
  
  public FromServiceMsg nativeParseData(byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e(tag, 2, "nativeOnReceData http, size = " + paramArrayOfByte.length);
    }
    return parseData(paramArrayOfByte);
  }
  
  public abstract void onInvalidData(int paramInt1, int paramInt2);
  
  public void onInvalidDataNative(int paramInt)
  {
    onInvalidData(-5, paramInt);
  }
  
  public abstract void onInvalidSign();
  
  public abstract void onResponse(int paramInt1, Object paramObject, int paramInt2);
  
  public abstract void onResponse(int paramInt1, Object paramObject, int paramInt2, byte[] paramArrayOfByte);
  
  public abstract int onSSOPingResponse(byte[] paramArrayOfByte, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.CodecWarpper
 * JD-Core Version:    0.7.0.1
 */