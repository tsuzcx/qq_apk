package com.tencent.TMG.sdk;

import android.util.Log;
import com.tencent.TMG.channel.AVAppChannel;
import com.tencent.TMG.channel.AVAppChannel.CsCmdCallback;
import com.tencent.TMG.channel.AVAppChannel.IdToIdCallback;
import com.tencent.TMG.channel.AVChannelManager;
import com.tencent.TMG.utils.QLog;

public class IMChannel
{
  public static final int ERR_FAILED = 1;
  public static final int ERR_OK = 0;
  public static String LOGTAG = "IMChannel";
  public int mNativeEntity;
  
  public IMChannel(int paramInt)
  {
    this.mNativeEntity = paramInt;
  }
  
  public static int getServerEnvType()
  {
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      return localAVAppChannel.getServerEnvType();
    }
    return -1;
  }
  
  public long getSelfTinyId()
  {
    long l = 0L;
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      l = localAVAppChannel.getTinyId();
    }
    Log.d(LOGTAG, "GetSelfTinyId selfTinyId: " + l);
    return l;
  }
  
  public void identifierToTinyId(ToTinyIdParam paramToTinyIdParam, int paramInt)
  {
    QLog.d(LOGTAG, 0, "java IMChannel identifierToTinyId");
    IdToIdCallbackImpl localIdToIdCallbackImpl = new IdToIdCallbackImpl(paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.identifierToTinyId(paramToTinyIdParam.accountType, paramToTinyIdParam.appIdAt3rd, paramToTinyIdParam.identifierList, localIdToIdCallbackImpl);
    }
  }
  
  public void multiVideoAppRequest(byte[] paramArrayOfByte, int paramInt)
  {
    CsCmdCallbackImpl localCsCmdCallbackImpl = new CsCmdCallbackImpl(paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestAppCmd(paramArrayOfByte, localCsCmdCallbackImpl);
    }
  }
  
  public void multiVideoAppRequest(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    CsCmdCallbackImpl localCsCmdCallbackImpl = new CsCmdCallbackImpl(paramInt2);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestAppCmd(paramArrayOfByte, paramInt1, localCsCmdCallbackImpl);
    }
  }
  
  public void multiVideoConfigRequest(byte[] paramArrayOfByte, int paramInt)
  {
    QLog.i(LOGTAG, 0, "multiVideoConfigRequest length:" + paramArrayOfByte.length);
    CsCmdCallbackImpl localCsCmdCallbackImpl = new CsCmdCallbackImpl(paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestCmd("VideoCCSvc.opensdk", paramArrayOfByte, localCsCmdCallbackImpl);
    }
  }
  
  public void multiVideoInfoRequest(byte[] paramArrayOfByte, int paramInt)
  {
    CsCmdCallbackImpl localCsCmdCallbackImpl = new CsCmdCallbackImpl(paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestInfoCmd(paramArrayOfByte, localCsCmdCallbackImpl);
    }
  }
  
  public native void nativeIdToIdCallback(int paramInt, IdToIdResult paramIdToIdResult);
  
  public native void nativeMultiVideoCallback(int paramInt, MultiVideoResult paramMultiVideoResult);
  
  public native void nativeQualityReportCallback(int paramInt, QualityReportResult paramQualityReportResult);
  
  public void qualityReportRequest(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    QualityReportCallback localQualityReportCallback = new QualityReportCallback(paramInt2);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.requestReportCmd(paramInt1, paramArrayOfByte, localQualityReportCallback);
    }
  }
  
  public void tinyIdToIdentifier(long[] paramArrayOfLong, int paramInt)
  {
    IdToIdCallbackImpl localIdToIdCallbackImpl = new IdToIdCallbackImpl(paramInt);
    AVAppChannel localAVAppChannel = AVChannelManager.getAppChannel();
    if (localAVAppChannel != null) {
      localAVAppChannel.tinyIdToIdentifier(paramArrayOfLong, localIdToIdCallbackImpl);
    }
  }
  
  public class CsCmdCallbackImpl
    implements AVAppChannel.CsCmdCallback
  {
    private int mNativeCallback;
    
    public CsCmdCallbackImpl(int paramInt)
    {
      this.mNativeCallback = paramInt;
    }
    
    public void onError(int paramInt, String paramString)
    {
      IMChannel.MultiVideoResult localMultiVideoResult = new IMChannel.MultiVideoResult(IMChannel.this);
      localMultiVideoResult.result = paramInt;
      localMultiVideoResult.errorInfo = paramString;
      IMChannel.this.nativeMultiVideoCallback(this.mNativeCallback, localMultiVideoResult);
      this.mNativeCallback = 0;
    }
    
    public void onSuccess(byte[] paramArrayOfByte)
    {
      IMChannel.MultiVideoResult localMultiVideoResult = new IMChannel.MultiVideoResult(IMChannel.this);
      localMultiVideoResult.result = 0;
      localMultiVideoResult.response = paramArrayOfByte;
      IMChannel.this.nativeMultiVideoCallback(this.mNativeCallback, localMultiVideoResult);
      this.mNativeCallback = 0;
    }
  }
  
  public class IdToIdCallbackImpl
    implements AVAppChannel.IdToIdCallback
  {
    private int mNativeCallback;
    
    public IdToIdCallbackImpl(int paramInt)
    {
      this.mNativeCallback = paramInt;
    }
    
    public void onError(int paramInt, String paramString)
    {
      IMChannel.IdToIdResult localIdToIdResult = new IMChannel.IdToIdResult(IMChannel.this);
      localIdToIdResult.result = paramInt;
      localIdToIdResult.errorInfo = paramString;
      IMChannel.this.nativeIdToIdCallback(this.mNativeCallback, localIdToIdResult);
      this.mNativeCallback = 0;
    }
    
    public void onSuccess(String[] paramArrayOfString, long[] paramArrayOfLong)
    {
      IMChannel.IdToIdResult localIdToIdResult = new IMChannel.IdToIdResult(IMChannel.this);
      localIdToIdResult.result = 0;
      localIdToIdResult.identifierList = paramArrayOfString;
      localIdToIdResult.tinyIdList = paramArrayOfLong;
      IMChannel.this.nativeIdToIdCallback(this.mNativeCallback, localIdToIdResult);
      this.mNativeCallback = 0;
    }
  }
  
  public class IdToIdResult
  {
    public String errorInfo;
    public String[] identifierList;
    public int result = 1;
    public long[] tinyIdList;
    
    public IdToIdResult() {}
  }
  
  public class MultiVideoResult
  {
    public String errorInfo;
    public byte[] response;
    public int result = 1;
    
    public MultiVideoResult() {}
  }
  
  public class QualityReportCallback
    implements AVAppChannel.CsCmdCallback
  {
    private int mNativeCallback;
    
    public QualityReportCallback(int paramInt)
    {
      this.mNativeCallback = paramInt;
    }
    
    public void onError(int paramInt, String paramString)
    {
      QLog.e(IMChannel.LOGTAG, 0, "QualityReport failed: " + paramInt + " info: " + paramString);
      IMChannel.QualityReportResult localQualityReportResult = new IMChannel.QualityReportResult(IMChannel.this);
      localQualityReportResult.result = paramInt;
      localQualityReportResult.errorInfo = paramString;
      IMChannel.this.nativeQualityReportCallback(this.mNativeCallback, localQualityReportResult);
      this.mNativeCallback = 0;
    }
    
    public void onSuccess(byte[] paramArrayOfByte)
    {
      QLog.d(IMChannel.LOGTAG, 0, "QualityReport succ");
      paramArrayOfByte = new IMChannel.QualityReportResult(IMChannel.this);
      paramArrayOfByte.result = 0;
      IMChannel.this.nativeQualityReportCallback(this.mNativeCallback, paramArrayOfByte);
      this.mNativeCallback = 0;
    }
  }
  
  public class QualityReportResult
  {
    public String errorInfo;
    public int result = 1;
    
    public QualityReportResult() {}
  }
  
  public static class ToTinyIdParam
  {
    public String accountType;
    public String appIdAt3rd;
    public String[] identifierList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.IMChannel
 * JD-Core Version:    0.7.0.1
 */