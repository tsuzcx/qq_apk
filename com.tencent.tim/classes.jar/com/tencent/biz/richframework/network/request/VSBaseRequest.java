package com.tencent.biz.richframework.network.request;

import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import avpp;
import avpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import rwy;
import rwz;

public abstract class VSBaseRequest
  implements Serializable
{
  public static final String TAG = "VSBaseRequest";
  public static final AtomicInteger atomicInteger = new AtomicInteger(0);
  private static final long serialVersionUID = -1L;
  private boolean isEnableCache;
  private int mContextHashCode = -1;
  private String mRequestKey;
  private int mSeq;
  protected String mTraceId;
  
  public static String concactRetCodeAndMsg(long paramLong, String paramString)
  {
    return ", retcode:" + paramLong + " | errMsg:" + paramString;
  }
  
  public static boolean isCacheExist(VSBaseRequest paramVSBaseRequest)
  {
    if ((paramVSBaseRequest == null) || (paramVSBaseRequest.getRequestByteData() == null)) {
      return false;
    }
    return rwz.a().fR(paramVSBaseRequest.getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + avpq.getQUA3() + new String(paramVSBaseRequest.getRequestByteKey()));
  }
  
  private String nl()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public static void reMoveCache(VSBaseRequest paramVSBaseRequest)
  {
    if ((paramVSBaseRequest == null) || (paramVSBaseRequest.getRequestByteData() == null)) {
      return;
    }
    rwz.a().remove(paramVSBaseRequest.getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + avpq.getQUA3() + new String(paramVSBaseRequest.getRequestByteKey()));
  }
  
  public abstract MessageMicro decode(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException;
  
  public byte[] encode()
  {
    byte[] arrayOfByte = getRequestByteData();
    if (isEnableCache()) {
      this.mRequestKey = (getCmdName() + BaseApplicationImpl.sApplication.getRuntime().getAccount() + avpq.getQUA3() + new String(getRequestByteKey()));
    }
    return getRequestWrapper(ByteStringMicro.copyFrom(arrayOfByte)).toByteArray();
  }
  
  public abstract String getCmdName();
  
  public int getContextHashCode()
  {
    return this.mContextHashCode;
  }
  
  public int getCurrentSeq()
  {
    return this.mSeq;
  }
  
  @Deprecated
  public int getNewSeq()
  {
    this.mSeq = atomicInteger.getAndIncrement();
    this.mTraceId = nl();
    return this.mSeq;
  }
  
  protected abstract byte[] getRequestByteData();
  
  public byte[] getRequestByteKey()
  {
    return getRequestByteData();
  }
  
  public String getRequestKey()
  {
    return this.mRequestKey;
  }
  
  @NotNull
  protected MessageMicro getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    localStQWebReq.Seq.set(getCurrentSeq());
    localStQWebReq.qua.set(avpq.getQUA3());
    localStQWebReq.deviceInfo.set(avpp.a().getDeviceInfor());
    localStQWebReq.busiBuff.set(paramByteStringMicro);
    localStQWebReq.traceid.set(this.mTraceId);
    return localStQWebReq;
  }
  
  public String getTraceId()
  {
    return this.mTraceId;
  }
  
  public boolean isAsyncCallBack()
  {
    return true;
  }
  
  public boolean isEnableCache()
  {
    return this.isEnableCache;
  }
  
  public Object[] parseResponseWrapper(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    localStQWebRsp.mergeFrom(paramArrayOfByte);
    return new Object[] { Long.valueOf(localStQWebRsp.retCode.get()), localStQWebRsp.errMsg.get().toStringUtf8(), localStQWebRsp.busiBuff.get() };
  }
  
  public void setContextHashCode(int paramInt)
  {
    this.mContextHashCode = paramInt;
  }
  
  public void setEnableCache(boolean paramBoolean)
  {
    this.isEnableCache = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.request.VSBaseRequest
 * JD-Core Version:    0.7.0.1
 */