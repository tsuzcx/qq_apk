package com.tencent.av.video.call;

import android.content.Context;
import android.os.SystemClock;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.report.AVReport;
import com.tencent.av.report.AVReport.ReceiverNodeStage;
import com.tencent.av.report.AVReport.SenderNodeStage;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientLogReport
{
  private static final int LogSendRet_FAIL = 0;
  private static final int LogSendRet_OK = 1;
  private static final int LogSendRet_PENDING = 2;
  private static final String ServerDataKey = "Data";
  private static final String ServerFilterKey = "video_log";
  private static final int SharpLogServerFilterKey = 607;
  private static final int SharpReportServerFilterKey = 617;
  private static final String UdpCheckResultServerFilterKey = "video_udpcheck_log";
  private static ClientLogReport instance = null;
  private static final String serviceCmd = "CliLogSvc.UploadReq";
  private int appid = 0;
  private UniPacket client = null;
  private boolean init = false;
  private Map jceMap = null;
  private strupbuff logJce = null;
  private MsfServiceSdk msfSub;
  
  static
  {
    cacheMethodIds();
  }
  
  private ClientLogReport()
  {
    init();
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  public static ClientLogReport instance()
  {
    if (instance == null) {
      instance = new ClientLogReport();
    }
    return instance;
  }
  
  public int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    if (!this.init) {
      return 0;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return 0;
    }
    Object localObject = String.valueOf(paramInt);
    if (paramInt == 0) {
      localObject = "video_log";
    }
    while ((this.jceMap == null) || (this.msfSub == null))
    {
      return 0;
      if (paramInt == 1) {
        localObject = "video_udpcheck_log";
      }
    }
    try
    {
      this.jceMap.clear();
      this.jceMap.put(localObject, new ArrayList());
      ((ArrayList)this.jceMap.get(localObject)).add(paramArrayOfByte);
      this.client.put("Data", this.logJce);
      paramArrayOfByte = this.client.encode();
      localObject = new ToServiceMsg(this.msfSub.getMsfServiceName(), String.valueOf(paramLong), "CliLogSvc.UploadReq");
      ((ToServiceMsg)localObject).setNeedCallback(false);
      ((ToServiceMsg)localObject).putWupBuffer(paramArrayOfByte);
      paramInt = this.msfSub.sendMsg((ToServiceMsg)localObject);
      if (paramInt >= 0) {
        return 1;
      }
      return 0;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return 0;
  }
  
  public void init(Context paramContext, int paramInt)
  {
    this.client = new UniPacket(true);
    this.jceMap = new ConcurrentHashMap();
    this.logJce = new strupbuff(this.jceMap);
    this.msfSub = MsfServiceSdk.get();
    this.appid = paramInt;
    this.init = true;
  }
  
  public void processNode(int paramInt, long paramLong1, long paramLong2)
  {
    long l = SystemClock.elapsedRealtime();
    AVReport localAVReport = AVReport.a();
    if (localAVReport == null) {
      return;
    }
    if (paramLong2 != 0L) {
      localAVReport.S = paramLong2;
    }
    if (paramLong1 != 0L) {
      localAVReport.R = paramLong1;
    }
    switch (paramInt)
    {
    case 105: 
    case 108: 
    case 115: 
    case 121: 
    default: 
      return;
    case 100: 
      AVReport.a().jdField_f_of_type_Long = l;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.SendRequestReq;
      return;
    case 118: 
      AVReport.a().jdField_b_of_type_Long = l;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.SendAVRoomReq;
      localAVReport.jdField_b_of_type_Boolean = false;
      return;
    case 119: 
      AVReport.a().jdField_e_of_type_Long = l;
      AVReport.a().jdField_a_of_type_ComTencentAvReportAVReport$SenderNodeStage = AVReport.SenderNodeStage.RecvAVRoomReqACK;
      return;
    case 122: 
      AVReport.a().l = l;
      return;
    case 123: 
      AVReport.a().jdField_m_of_type_Long = l;
      return;
    case 104: 
      localAVReport.g = true;
      localAVReport.J = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      localAVReport.b();
      return;
    case 109: 
      localAVReport.h = true;
      localAVReport.K = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      localAVReport.b();
      return;
    case 110: 
      localAVReport.i = true;
      localAVReport.L = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      localAVReport.b();
      return;
    case 102: 
      localAVReport.j = true;
      localAVReport.M = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      localAVReport.b();
      return;
    case 103: 
      localAVReport.j = true;
      localAVReport.M = l;
      localAVReport.jdField_p_of_type_Boolean = true;
      localAVReport.b();
      return;
    case 111: 
      if (localAVReport.jdField_a_of_type_Boolean) {
        localAVReport.jdField_n_of_type_Long = l;
      }
      for (;;)
      {
        localAVReport.jdField_p_of_type_Boolean = true;
        return;
        localAVReport.C = l;
      }
    case 106: 
      if (localAVReport.jdField_a_of_type_Boolean) {
        localAVReport.o = l;
      }
      for (;;)
      {
        localAVReport.jdField_p_of_type_Boolean = true;
        localAVReport.jdField_m_of_type_Boolean = true;
        localAVReport.P = l;
        localAVReport.b();
        return;
        localAVReport.D = l;
      }
    case 112: 
      if (localAVReport.jdField_a_of_type_Boolean) {
        localAVReport.jdField_p_of_type_Long = l;
      }
      for (;;)
      {
        localAVReport.jdField_p_of_type_Boolean = true;
        localAVReport.jdField_n_of_type_Boolean = true;
        localAVReport.Q = l;
        localAVReport.b();
        return;
        localAVReport.E = l;
      }
    case 117: 
      localAVReport.jdField_b_of_type_Boolean = true;
      return;
    case 120: 
      localAVReport.c = true;
      return;
    case 101: 
      localAVReport.F = l;
      return;
    case 107: 
      localAVReport.r = l;
      localAVReport.jdField_a_of_type_ComTencentAvReportAVReport$ReceiverNodeStage = AVReport.ReceiverNodeStage.other;
      return;
    case 124: 
      localAVReport.A = l;
      return;
    case 125: 
      localAVReport.B = l;
      return;
    case 116: 
      localAVReport.d = true;
      localAVReport.G = l;
      return;
    case 113: 
      localAVReport.jdField_e_of_type_Boolean = true;
      localAVReport.H = l;
      return;
    }
    localAVReport.jdField_f_of_type_Boolean = true;
    localAVReport.I = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.video.call.ClientLogReport
 * JD-Core Version:    0.7.0.1
 */