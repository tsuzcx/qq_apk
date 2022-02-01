package com.tencent.mobileqq.mini.network.http;

import NS_QWEB_PROTOCAL.PROTOCAL.StAuthInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.util.Log;
import avpp;
import avpq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class HttpProtoBufRequest
{
  public static final String KEY_ERROR_MSG = "errMsg";
  public static final String KEY_RETURN_CODE = "retCode";
  public static final String TAG = "HttpProtoBufRequest";
  private static volatile AtomicInteger sSeq = new AtomicInteger(0);
  public int seqNo;
  
  public static byte[] decode(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d("HttpProtoBufRequest", 1, "decode exception: " + Log.getStackTraceString(paramArrayOfByte));
    }
    return null;
  }
  
  private String getTraceId()
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    str = localStringBuilder.toString();
    QLog.d("miniapp-cmd", 1, "[https]. send request cmd=" + getCmdName() + " traceId=" + str);
    return str;
  }
  
  public byte[] encode()
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    this.seqNo = sSeq.incrementAndGet();
    localStQWebReq.Seq.set(this.seqNo);
    localStQWebReq.qua.set(avpq.getQUA3());
    localStQWebReq.deviceInfo.set(avpp.a().getDeviceInfor());
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
    localStQWebReq.traceid.set(getTraceId());
    localStQWebReq.Module.set(getModule());
    localStQWebReq.Cmdname.set(getCmdName());
    PROTOCAL.StAuthInfo localStAuthInfo = new PROTOCAL.StAuthInfo();
    localStAuthInfo.uin.set(MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()));
    localStQWebReq.loginSig.set(localStAuthInfo);
    return localStQWebReq.toByteArray();
  }
  
  protected abstract byte[] getBusiBuf();
  
  protected abstract String getCmdName();
  
  protected abstract String getModule();
  
  protected abstract JSONObject onResponse(int paramInt, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.network.http.HttpProtoBufRequest
 * JD-Core Version:    0.7.0.1
 */