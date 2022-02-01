package com.tencent.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class MsgAutoMonitorUtil
{
  public static final String ADD_MSG_NUM_KEY = "MSG_AddMsgNum";
  public static final String ADD_MSG_TIME_KEY = "MSG_AddMsgTime";
  public static final String DB_IO_NUM_KEY = "MSG_DbIoNum";
  public static final String DB_IO_TIME_KEY = "MSG_DbIoTime";
  public static final String DB_IO_TRANSACTION_KEY = "MSG_DbIoTransaction";
  public static final String DB_TABLE_NUM_KEY = "MSG_DbTableNum";
  public static final String MSG_DECODE_C2C_NUM_KEY = "MSG_DecodeC2CMsgNum";
  public static final String MSG_DECODE_C2C_TIME_KEY = "MSG_DecodeC2CMsgTime";
  public static final String MSG_DECODE_GRPDIS_NUM_KEY = "MSG_DecodeGrpDisMsgNum";
  public static final String MSG_DECODE_GRPDIS_TIME_KEY = "MSG_DecodeGrpDisMsgTime";
  public static final String MSG_FILTER_NUM_KEY = "MSG_MsgFilterNum";
  public static final String MSG_FILTER_TIME_KEY = "MSG_MsgFilterTime";
  public static final String MSG_INIT_MSG_NUM = "MSG_InitMsgNum";
  public static final String MSG_INIT_TAG = "AutoMonitor";
  public static final String MSG_INIT_TIME_KEY = "MSG_InitCostTime";
  public static final String MSG_NOTIFY_FIN_C2C = "MSG_NOTIFY_FIN_C2C";
  public static final String MSG_NOTIFY_FIN_DIS = "MSG_NOTIFY_FIN_DIS";
  public static final String MSG_NOTIFY_FIN_GRP = "MSG_NOTIFY_FIN_GRP";
  public static final String MSG_OBSERVER_NOTIFY_NUM = "MSG_ObserverNotifyNum";
  public static final String MSG_OBSERVER_TIME_KEY = "MSG_ObserverTime";
  public static final String MSG_PROXY_INIT_TIME_KEY = "MSG_ProxyInitTime";
  public static final String MSG_PROXY_SEQ_DIS = "MSG_PROXY_SEQ_DIS_T";
  public static final String MSG_PROXY_SEQ_GRP = "MSG_PROXY_SEQ_GRP_T";
  public static final String MSG_PROXY_THREAD_NUM_BEGIN = "MSG_PROXY_THREAD_NUM_BEGIN";
  public static final String MSG_PROXY_THREAD_NUM_END = "MSG_PROXY_THREAD_NUM_END";
  public static final String MSG_TABLE_NUM_KEY = "MSG_TableNum";
  private static MsgAutoMonitorUtil util;
  private long addMsgNum;
  private long addMsgTime;
  private long dbIoNum;
  private long dbIoTime;
  private long dbIoTransaction;
  private long decodeC2CNum;
  private long decodeC2CTime;
  private long decodeGrpDisNum;
  private long decodeGrpDisTime;
  private long msgFilterNum;
  private long msgFilterTime;
  private int msgObserverNotifyNum;
  private long msgObserverTime;
  private long msgProxyThreadNumBegin;
  private long msgProxyThreadNumEnd;
  private long notifyMsgFinishTime_C2C;
  private long notifyMsgFinishTime_C2C_S;
  private long notifyMsgFinishTime_Grp;
  private long notifyMsgFinishTime_Grp_S;
  private long notufyMsgFinishTime_Dis;
  private long notufyMsgFinishTime_Dis_S;
  private long proxySeqTime_Dis;
  private long proxySeqTime_Grp;
  
  public static MsgAutoMonitorUtil getInstance()
  {
    if (util == null) {
      util = new MsgAutoMonitorUtil();
    }
    return util;
  }
  
  public void addAddMsgTime(long paramLong1, long paramLong2)
  {
    this.addMsgTime += paramLong1;
    this.addMsgNum += paramLong2;
  }
  
  public void addDbIoTime(long paramLong)
  {
    this.dbIoTime += paramLong;
    this.dbIoNum += 1L;
  }
  
  public void addDbIoTransaction(long paramLong)
  {
    this.dbIoTransaction += paramLong;
  }
  
  public void addDecodeC2CMsgTime(long paramLong)
  {
    this.decodeC2CTime += paramLong;
    this.decodeC2CNum += 1L;
  }
  
  public void addDecodeGrpDisMsgTime(long paramLong)
  {
    this.decodeGrpDisTime += paramLong;
    this.decodeGrpDisNum += 1L;
  }
  
  public void addMsgFilterTime(long paramLong)
  {
    this.msgFilterTime += paramLong;
    this.msgFilterNum += 1L;
  }
  
  public void addMsgObserverNotifyNum()
  {
    this.msgObserverNotifyNum += 1;
  }
  
  public void addMsgObserverTime(long paramLong)
  {
    this.msgObserverTime += paramLong;
  }
  
  public void addProxySeqTime_Dis(long paramLong)
  {
    this.proxySeqTime_Dis += paramLong;
  }
  
  public void addProxySeqTime_Grp(long paramLong)
  {
    this.proxySeqTime_Grp += paramLong;
  }
  
  public void markC2CFinishCost()
  {
    this.notifyMsgFinishTime_C2C = (System.currentTimeMillis() - this.notifyMsgFinishTime_C2C_S);
  }
  
  public void markC2CFinishTime()
  {
    this.notifyMsgFinishTime_C2C_S = System.currentTimeMillis();
  }
  
  public void markDisFinishCost()
  {
    this.notufyMsgFinishTime_Dis = (System.currentTimeMillis() - this.notufyMsgFinishTime_Dis_S);
  }
  
  public void markDisFinishTime()
  {
    this.notufyMsgFinishTime_Dis_S = System.currentTimeMillis();
  }
  
  public void markGrpFinishCost()
  {
    this.notifyMsgFinishTime_Grp = (System.currentTimeMillis() - this.notifyMsgFinishTime_Grp_S);
  }
  
  public void markGrpFinishTime()
  {
    this.notifyMsgFinishTime_Grp_S = System.currentTimeMillis();
  }
  
  public void markMsgProxyThreadNumBegin(int paramInt)
  {
    this.msgProxyThreadNumBegin = paramInt;
  }
  
  public void markMsgProxyThreadNumEnd(int paramInt)
  {
    this.msgProxyThreadNumEnd = paramInt;
  }
  
  public void printDbAutoMonitorValue()
  {
    printKeyAndValue("MSG_DbIoTime", this.dbIoTime + "");
    this.dbIoTime = 0L;
    printKeyAndValue("MSG_DbIoNum", this.dbIoNum + "");
    this.dbIoNum = 0L;
    printKeyAndValue("MSG_DbIoTransaction", this.dbIoTransaction + "");
    this.dbIoTransaction = 0L;
  }
  
  public void printKeyAndValue(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AutoMonitor", 2, paramString1 + ", cost=" + paramString2);
      return;
    }
    Log.i("AutoMonitor", paramString1 + ", cost=" + paramString2);
  }
  
  public void printMsgInfo()
  {
    printKeyAndValue("MSG_DecodeC2CMsgNum", String.valueOf(this.decodeC2CNum));
    printKeyAndValue("MSG_DecodeC2CMsgTime", String.valueOf(this.decodeC2CTime));
    printKeyAndValue("MSG_DecodeGrpDisMsgNum", String.valueOf(this.decodeGrpDisNum));
    printKeyAndValue("MSG_DecodeGrpDisMsgTime", String.valueOf(this.decodeGrpDisTime));
    printKeyAndValue("MSG_AddMsgNum", String.valueOf(this.addMsgNum));
    printKeyAndValue("MSG_AddMsgTime", String.valueOf(this.addMsgTime));
    printKeyAndValue("MSG_MsgFilterNum", String.valueOf(this.msgFilterNum));
    printKeyAndValue("MSG_MsgFilterTime", String.valueOf(this.msgFilterTime));
    printKeyAndValue("MSG_PROXY_SEQ_DIS_T", String.valueOf(this.proxySeqTime_Dis));
    printKeyAndValue("MSG_PROXY_SEQ_GRP_T", String.valueOf(this.proxySeqTime_Grp));
    printDbAutoMonitorValue();
    printMsgObserverAutoMonitorValue();
    printKeyAndValue("MSG_NOTIFY_FIN_C2C", String.valueOf(this.notifyMsgFinishTime_C2C));
    printKeyAndValue("MSG_NOTIFY_FIN_GRP", String.valueOf(this.notifyMsgFinishTime_Grp));
    printKeyAndValue("MSG_NOTIFY_FIN_DIS", String.valueOf(this.notufyMsgFinishTime_Dis));
    printKeyAndValue("MSG_PROXY_THREAD_NUM_BEGIN", String.valueOf(this.msgProxyThreadNumBegin));
    printKeyAndValue("MSG_PROXY_THREAD_NUM_END", String.valueOf(this.msgProxyThreadNumEnd));
  }
  
  public void printMsgObserverAutoMonitorValue()
  {
    printKeyAndValue("MSG_ObserverTime", this.msgObserverTime + "");
    printKeyAndValue("MSG_ObserverNotifyNum", this.msgObserverNotifyNum + "");
    this.msgObserverTime = 0L;
    this.msgObserverNotifyNum = 0;
  }
  
  public void release()
  {
    util = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.util.MsgAutoMonitorUtil
 * JD-Core Version:    0.7.0.1
 */