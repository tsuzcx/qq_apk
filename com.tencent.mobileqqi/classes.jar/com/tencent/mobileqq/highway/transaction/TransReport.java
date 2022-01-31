package com.tencent.mobileqq.highway.transaction;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public class TransReport
{
  public static final String rep_BDH_Reason = "param_BDH_Reason";
  public static final String rep_Ip_ConnCost = "param_Ip_ConnCost";
  public static final String rep_Ip_Index = "param_ip_index";
  public static final String rep_Net_Detect = "NetDetect";
  public static final String rep_bdhTrans = "rep_bdhTrans";
  public static final String rep_confMaxConn = "param_conf_connNum";
  public static final String rep_confSegNum = "param_conf_segNum";
  public static final String rep_confSegSize = "param_conf_segSize";
  public static final String rep_connNUm = "connNum:";
  public static final String rep_dwFlow_Xg = "dwFlow_Xg";
  public static final String rep_dwFlow_wifi = "dwFlow_WiFi";
  public static final String rep_finLost = "param_fin_lost";
  public static final String rep_has_net = "hasNet";
  public static final String rep_heart_resp = "param_heart_resp";
  public static final String rep_ip = "ip";
  public static final String rep_isPreConnExist = "PreConn:";
  public static final String rep_net_type = "net:";
  public static final String rep_port = "port";
  public static final String rep_progress = "progress";
  public static final String rep_proto = "proto";
  public static final String rep_retry_code = "param_retry_code";
  public static final String rep_retry_max = "param_max_retry_times";
  public static final String rep_retry_seg_count = "param_retry_seg_count";
  public static final String rep_retry_total = "param_total_retry_times";
  public static final String rep_segsPerConn = "segspercnt";
  public static final String rep_slice_num = "sn:";
  public static final String rep_time_cache = "tc_p:";
  public static final String rep_time_ht = "tc_h:";
  public static final String rep_time_send = "tc_s:";
  public static final String rep_upFlow_Xg = "upFlow_Xg";
  public static final String rep_upFlow_wifi = "upFlow_WiFi";
  public boolean bFINLost = false;
  public boolean bHasNet = false;
  public long confConnNum;
  public long confSegNum;
  public long confSegSize;
  public int connErrCode;
  public int connNum;
  public long[] dataFlow;
  public String detectResult;
  public String failReason;
  public String ipAddr = "";
  public long ipConnCost = 0L;
  public int ipIndex = -1;
  public boolean isConnected = false;
  public HashMap<Integer, AtomicInteger> mDataFlowOfChannel = new HashMap();
  public boolean mIsPreConnExist = false;
  public int mRetryCode;
  public int mRetryTimes_SegsMax = 0;
  public int mRetryTimes_SegsNum = 0;
  public int mRetryTimes_SegsTotal = 0;
  public int mTransferedSize = -1;
  public int netType;
  public String port = "";
  public String protoType;
  public int sliceNum = 0;
  public int timeCost_Cache = 0;
  public int timeCost_Ht = 0;
  public int timeCost_Send = 0;
  
  public HashMap<String, String> getReportInfo()
  {
    HashMap localHashMap = new HashMap();
    String str = "UnKnow";
    switch (this.netType)
    {
    }
    StringBuilder localStringBuilder;
    for (;;)
    {
      localStringBuilder = new StringBuilder("");
      localObject1 = this.mDataFlowOfChannel.values().iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AtomicInteger)((Iterator)localObject1).next();
        if (i >= 5) {
          break;
        }
        if (i > 0) {
          localStringBuilder.append("_");
        }
        localStringBuilder.append(((AtomicInteger)localObject2).get());
        i += 1;
      }
      str = "WiFi";
      continue;
      str = "3G";
      continue;
      str = "2G";
      continue;
      str = "4G";
      continue;
      str = "CABLE";
    }
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("sn:").append(this.sliceNum).append(";");
    ((StringBuilder)localObject1).append("tc_s:").append(this.timeCost_Send).append(";");
    ((StringBuilder)localObject1).append("tc_h:").append(this.timeCost_Ht).append(";");
    ((StringBuilder)localObject1).append("tc_p:").append(this.timeCost_Cache).append(";");
    ((StringBuilder)localObject1).append("net:").append(str).append(";");
    ((StringBuilder)localObject1).append("ip").append(":").append(this.ipAddr).append(";");
    ((StringBuilder)localObject1).append("port").append(":").append(this.port).append(";");
    ((StringBuilder)localObject1).append("connNum:").append(this.connNum).append(";");
    Object localObject2 = ((StringBuilder)localObject1).append("PreConn:");
    if (this.mIsPreConnExist)
    {
      str = "1";
      ((StringBuilder)localObject2).append(str).append(";");
      ((StringBuilder)localObject1).append("param_conf_segSize").append(":").append(this.confSegSize).append(";");
      ((StringBuilder)localObject1).append("param_conf_segNum").append(":").append(this.confSegNum).append(";");
      ((StringBuilder)localObject1).append("param_conf_connNum").append(":").append(this.confConnNum).append(";");
      ((StringBuilder)localObject1).append("proto").append(":").append(this.protoType).append(";");
      localObject2 = ((StringBuilder)localObject1).append("hasNet").append(":");
      if (!this.bHasNet) {
        break label834;
      }
      str = "true";
      label495:
      ((StringBuilder)localObject2).append(str).append(";");
      ((StringBuilder)localObject1).append("progress").append(":").append(this.mTransferedSize).append(";");
      ((StringBuilder)localObject1).append("param_BDH_Reason").append(this.failReason).append(";");
      localHashMap.put("upFlow_WiFi", String.valueOf(this.dataFlow[0]));
      localHashMap.put("dwFlow_WiFi", String.valueOf(this.dataFlow[1]));
      localHashMap.put("upFlow_Xg", String.valueOf(this.dataFlow[2]));
      localHashMap.put("dwFlow_Xg", String.valueOf(this.dataFlow[3]));
      localHashMap.put("tc_p:", String.valueOf(this.timeCost_Cache));
      localHashMap.put("rep_bdhTrans", ((StringBuilder)localObject1).toString());
      localHashMap.put("param_conf_segSize", String.valueOf(this.confSegSize));
      localHashMap.put("param_conf_segNum", String.valueOf(this.confSegNum));
      localHashMap.put("param_conf_connNum", String.valueOf(this.confConnNum));
      localHashMap.put("segspercnt", localStringBuilder.toString());
      if (!this.bFINLost) {
        break label841;
      }
    }
    label834:
    label841:
    for (str = String.valueOf(true);; str = String.valueOf(false))
    {
      localHashMap.put("param_fin_lost", str);
      localHashMap.put("param_retry_seg_count", String.valueOf(this.mRetryTimes_SegsNum));
      localHashMap.put("param_total_retry_times", String.valueOf(this.mRetryTimes_SegsTotal));
      localHashMap.put("param_max_retry_times", String.valueOf(this.mRetryTimes_SegsMax));
      localHashMap.put("param_retry_code", String.valueOf(this.mRetryCode));
      localHashMap.put("param_ip_index", String.valueOf(this.ipIndex));
      localHashMap.put("param_Ip_ConnCost", String.valueOf(this.ipConnCost));
      localHashMap.put("ip", String.valueOf(this.ipAddr));
      localHashMap.put("port", this.port);
      return localHashMap;
      str = "0";
      break;
      str = "false";
      break label495;
    }
  }
  
  public void setFailReason(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("BDH");
    localStringBuilder.append("_E_").append(paramInt);
    localStringBuilder.append("_N_").append(this.connErrCode);
    localStringBuilder.append("_D_").append(paramString);
    this.failReason = localStringBuilder.toString();
  }
  
  public void updateRetryInfo(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt > this.mRetryTimes_SegsMax) {
      this.mRetryTimes_SegsMax = paramInt;
    }
    this.mRetryTimes_SegsNum += 1;
    this.mRetryTimes_SegsTotal += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.transaction.TransReport
 * JD-Core Version:    0.7.0.1
 */