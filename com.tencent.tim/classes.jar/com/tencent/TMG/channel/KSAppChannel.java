package com.tencent.TMG.channel;

import android.util.Log;
import com.tencent.TMG.sdk.AVContext.StartParam;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;

public class KSAppChannel
  extends AVAppChannel
{
  public static String TAG = "KSAppChannel";
  public AVContext.StartParam startParam_;
  
  public long getTinyId()
  {
    try
    {
      long l = Long.valueOf(this.startParam_.identifier).longValue();
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public boolean identifierToTinyId(String paramString1, String paramString2, String[] paramArrayOfString, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    paramString1 = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramString1.add(paramArrayOfString[i]);
      i += 1;
    }
    identifierToTinyIdIntern(paramArrayOfString, new IdToIdCallbackImpl(paramIdToIdCallback));
    return true;
  }
  
  public void identifierToTinyIdIntern(String[] paramArrayOfString, IdToIdCallbackImpl paramIdToIdCallbackImpl)
  {
    long[] arrayOfLong = new long[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfString[i]).longValue();
      i += 1;
    }
    paramIdToIdCallbackImpl.onSuccess(paramArrayOfString, arrayOfLong);
  }
  
  public boolean loginWithParam(AVContext.StartParam paramStartParam)
  {
    this.startParam_ = paramStartParam;
    return true;
  }
  
  public native byte[] nativeConvertToIMReportData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3);
  
  public native void nativeRequestVideoAppCmd(byte[] paramArrayOfByte, int paramInt, AVContext.StartParam paramStartParam, AVAppChannel.CsCmdCallback paramCsCmdCallback);
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, int paramInt, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return true;
  }
  
  public boolean requestAppCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("0", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestCmd(String paramString, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    String str = paramString;
    if (paramString.equals("VideoCCSvc.opensdk")) {
      str = "2";
    }
    try
    {
      nativeRequestVideoAppCmd(paramArrayOfByte, Integer.parseInt(str), this.startParam_, new CsCmdCallbackImpl(paramCsCmdCallback));
      return true;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean requestInfoCmd(byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    return requestCmd("1", paramArrayOfByte, paramCsCmdCallback);
  }
  
  public boolean requestReportCmd(int paramInt, byte[] paramArrayOfByte, AVAppChannel.CsCmdCallback paramCsCmdCallback)
  {
    if (paramArrayOfByte.length >= 0) {
      return requestCmd("3", nativeConvertToIMReportData(paramArrayOfByte, paramInt, this.startParam_.sdkAppId, getTinyId(), (int)System.currentTimeMillis() / 1000), paramCsCmdCallback);
    }
    QLog.e(TAG, 0, "requestReportCmd reportData == NULL");
    return false;
  }
  
  public boolean tinyIdToIdentifier(long[] paramArrayOfLong, AVAppChannel.IdToIdCallback paramIdToIdCallback)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    tinyIdToIdentifierIntern(paramArrayOfLong, new IdToIdCallbackImpl(paramIdToIdCallback));
    return true;
  }
  
  public void tinyIdToIdentifierIntern(long[] paramArrayOfLong, IdToIdCallbackImpl paramIdToIdCallbackImpl)
  {
    String[] arrayOfString = new String[paramArrayOfLong.length];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      arrayOfString[i] = Long.toString(paramArrayOfLong[i]);
      i += 1;
    }
    paramIdToIdCallbackImpl.onSuccess(arrayOfString, paramArrayOfLong);
  }
  
  public class CsCmdCallbackImpl
    implements AVAppChannel.CsCmdCallback
  {
    private AVAppChannel.CsCmdCallback mCallback;
    
    public CsCmdCallbackImpl(AVAppChannel.CsCmdCallback paramCsCmdCallback)
    {
      this.mCallback = paramCsCmdCallback;
    }
    
    public void onError(int paramInt, String paramString)
    {
      Log.e("shixu", "code :" + paramInt + " info: " + paramString);
      if (this.mCallback != null)
      {
        this.mCallback.onError(paramInt, paramString);
        this.mCallback = null;
      }
    }
    
    public void onSuccess(byte[] paramArrayOfByte)
    {
      Log.e("shixu", "success");
      if (this.mCallback != null)
      {
        this.mCallback.onSuccess(paramArrayOfByte);
        this.mCallback = null;
      }
    }
  }
  
  public class IdToIdCallbackImpl
    implements AVAppChannel.IdToIdCallback
  {
    private AVAppChannel.IdToIdCallback mCallback;
    
    public IdToIdCallbackImpl(AVAppChannel.IdToIdCallback paramIdToIdCallback)
    {
      this.mCallback = paramIdToIdCallback;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onError(paramInt, paramString);
        this.mCallback = null;
      }
    }
    
    public void onSuccess(String[] paramArrayOfString, long[] paramArrayOfLong)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onSuccess(paramArrayOfString, paramArrayOfLong);
        this.mCallback = null;
      }
    }
  }
  
  public class ReportCallbackImpl
    implements AVAppChannel.CsCmdCallback
  {
    private AVAppChannel.CsCmdCallback mCallback;
    
    public ReportCallbackImpl(AVAppChannel.CsCmdCallback paramCsCmdCallback)
    {
      this.mCallback = paramCsCmdCallback;
    }
    
    public void onError(int paramInt, String paramString)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onError(paramInt, paramString);
        this.mCallback = null;
      }
    }
    
    public void onSuccess(byte[] paramArrayOfByte)
    {
      if (this.mCallback != null)
      {
        this.mCallback.onSuccess(paramArrayOfByte);
        this.mCallback = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.channel.KSAppChannel
 * JD-Core Version:    0.7.0.1
 */