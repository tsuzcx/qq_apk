package com.tencent.device.qfind;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.ble.JNIEngineLite;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import syo;
import syw;
import taf;
import tai;
import taj;
import tak;
import tencent.im.oidb.qfind.QFind.DeviceInfo;
import tencent.im.oidb.qfind.QFind.DeviceLoc;
import tencent.im.oidb.qfind.QFind.HistoryData;
import tencent.im.oidb.qfind.QFind.HistoryDetail;
import tencent.im.oidb.qfind.QFind.ReqReportDevs;
import tencent.im.oidb.qfind.QFind.RspReportDevs;

@TargetApi(18)
public class QFindBLEScanMgr
{
  private static String aIy = "Q_Find_Scan_Intent";
  private static String aIz = "com.tencent.mobileqq.msf.wakeup";
  private static boolean aOl;
  long DQ;
  long DR;
  private long DS;
  public BluetoothAdapter.LeScanCallback a;
  public BluetoothAdapter a;
  private NotifyReceiver jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver;
  private a jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$a;
  public boolean aOk;
  public QQAppInterface app;
  int bAB;
  int bAC;
  int bAD;
  int bAE;
  int bAF;
  int bAG;
  int bAH;
  public int bAI;
  public int bAJ;
  private Context context;
  public HashMap<String, taf> gp;
  public HashMap<String, Long> gq;
  public HashMap<String, QFind.DeviceInfo> gr;
  public MqqHandler m;
  private PowerManager.WakeLock mWakeLock;
  private HandlerThread newHT;
  public ArrayList<String> oy;
  public ArrayList<Long> oz;
  public volatile boolean qn;
  
  static
  {
    try
    {
      aOl = BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static boolean NB()
  {
    return aOl;
  }
  
  private void a(taf paramtaf, SosoInterface.SosoLbsInfo paramSosoLbsInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        l1 = NetConnInfoCenter.getServerTimeMillis();
        if (this.DR > 0L)
        {
          long l2 = this.DR;
          if (l1 - l2 <= 600000L) {
            continue;
          }
        }
      }
      catch (Throwable paramtaf)
      {
        long l1;
        paramtaf.printStackTrace();
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.i("QFindBLE", 2, "SendReqReportAroundDevs  report exception :   " + paramtaf.toString());
        return;
        QLog.i("QFindBLE", 1, "report lost dev sn=" + paramtaf.nY() + ", pid=" + paramtaf.pid + " has loc(" + paramSosoLbsInfo.a.cd + "," + paramSosoLbsInfo.a.ce + ", " + paramSosoLbsInfo.a.accuracy + "), ble_id = " + paramtaf.bAs + ", lastreportcount=" + this.bAH + ", run = " + paramtaf.bAw + " , walk = " + paramtaf.bAv);
        continue;
      }
      try
      {
        bCi();
        if (paramSosoLbsInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QFindBLE", 2, "start to report dev sn=" + paramtaf.nY() + ", pid=" + paramtaf.pid + ", ble_id = " + paramtaf.bAs + ", lastreportcount=" + this.bAH + ", run = " + paramtaf.bAw + " , walk = " + paramtaf.bAv);
          }
          QFind.ReqReportDevs localReqReportDevs = new QFind.ReqReportDevs();
          ArrayList localArrayList1 = new ArrayList();
          QFind.DeviceInfo localDeviceInfo = new QFind.DeviceInfo();
          localDeviceInfo.pid.set(paramtaf.pid);
          localDeviceInfo.service_uuid.set(2L);
          localDeviceInfo.sn.set(ByteStringMicro.copyFromUtf8(paramtaf.nY()));
          if (paramBoolean) {
            localDeviceInfo.bytes_sig.set(ByteStringMicro.copyFrom(paramtaf.sig));
          }
          localDeviceInfo.timestamp.set((int)(l1 / 1000L));
          ArrayList localArrayList2 = new ArrayList();
          QFind.HistoryDetail localHistoryDetail = new QFind.HistoryDetail();
          localHistoryDetail.run.set(paramtaf.bAw);
          localHistoryDetail.walk.set(paramtaf.bAv);
          localArrayList2.add(localHistoryDetail);
          paramtaf = new QFind.HistoryData();
          paramtaf.details.set(localArrayList2);
          localDeviceInfo.msg_walking_history.set(paramtaf);
          localArrayList1.add(localDeviceInfo);
          localReqReportDevs.dev_infos.set(localArrayList1);
          if (paramSosoLbsInfo != null)
          {
            paramtaf = new QFind.DeviceLoc();
            paramtaf.lat.set(Double.valueOf(paramSosoLbsInfo.a.cd * 1000000.0D).intValue());
            paramtaf.lon.set(Double.valueOf(paramSosoLbsInfo.a.ce * 1000000.0D).intValue());
            paramtaf.gps_type.set(1);
            paramtaf.uint32_precision.set((int)paramSosoLbsInfo.a.accuracy);
            localReqReportDevs.dev_loc.set(paramtaf);
          }
          paramSosoLbsInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          paramtaf = (syw)paramSosoLbsInfo.getBusinessHandler(51);
          paramSosoLbsInfo = new ToServiceMsg("mobileqq.service", paramSosoLbsInfo.getCurrentAccountUin(), "QFindSvc.ReqReportDevs");
          paramSosoLbsInfo.putWupBuffer(localReqReportDevs.toByteArray());
          paramtaf.sendPbReq(paramSosoLbsInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private boolean a(taf paramtaf)
  {
    paramtaf = "" + paramtaf.pid + "|" + paramtaf.nY();
    return this.gq.containsKey(paramtaf);
  }
  
  private boolean a(taf paramtaf, boolean paramBoolean)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if ((this.DQ <= 0L) || (l - this.DQ > this.bAD))
    {
      this.DQ = NetConnInfoCenter.getServerTimeMillis();
      this.bAH = 0;
    }
    if ((this.bAH > this.bAE) && (!paramBoolean)) {
      return false;
    }
    Object localObject = "" + paramtaf.pid + "|" + paramtaf.nY();
    if (this.gp.containsKey(localObject))
    {
      taf localtaf = (taf)this.gp.get(localObject);
      localtaf.bAw = paramtaf.bAw;
      localtaf.bAv = paramtaf.bAv;
      if ((!paramBoolean) && (l - localtaf.DN < this.bAB)) {
        return false;
      }
      if ((paramBoolean) && (l - localtaf.DO < this.bAF)) {
        return false;
      }
      if ((paramBoolean) && (this.gq.containsKey(localObject)) && (l - ((Long)this.gq.get(localObject)).longValue() > this.bAG) && (l - localtaf.DO < this.bAB))
      {
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "report lost dev reach the period: " + this.bAG);
        }
        return false;
      }
      localtaf.DN = l;
      if (paramBoolean) {
        localtaf.DO = l;
      }
    }
    for (;;)
    {
      localObject = (taf)this.gp.get(localObject);
      if (!((taf)localObject).connected)
      {
        ((taf)localObject).bAs = paramtaf.bAs;
        ((taf)localObject).reported = false;
      }
      this.bAH += 1;
      return true;
      paramtaf.DN = l;
      if (paramBoolean) {
        paramtaf.DO = l;
      }
      this.gp.put(localObject, paramtaf);
    }
  }
  
  private void aW(int paramInt, String paramString)
  {
    paramString = "" + paramInt + "|" + paramString;
    if (this.gp.containsKey(paramString)) {
      SosoInterface.a(new taj(this, 0, true, true, 0L, false, false, "smartdevice:lightapp", paramString));
    }
  }
  
  private void acquireWakeLock()
  {
    if (this.mWakeLock == null)
    {
      this.mWakeLock = ((PowerManager)this.context.getSystemService("power")).newWakeLock(536870913, "QFindBLE");
      if (this.mWakeLock != null) {
        this.mWakeLock.acquire();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr acquireWakeLock");
      }
    }
  }
  
  private boolean ad(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.qn) {}
    }
    for (;;)
    {
      return true;
      this.oy.clear();
      try
      {
        if ((this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null) && (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.isEnabled()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.startLeScan with cb=" + this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.qn);
          }
          this.qn = this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.startLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
          if (this.m != null) {
            this.m.postDelayed(new QFindBLEScanMgr.2(this), this.bAJ);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          this.qn = false;
        }
      }
      if (this.qn) {}
      return this.qn;
      bCj();
      if (this.qn)
      {
        this.qn = false;
        try
        {
          if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QFindBLE", 2, "call native mBluetoothAdapter.stopLeScan with cb=" + this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback + ", mScanning=" + this.qn);
            }
            this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
            return true;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return true;
  }
  
  private void bCi()
  {
    this.DR = NetConnInfoCenter.getServerTimeMillis();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).edit();
    String str = this.app.getCurrentAccountUin();
    if ((str == null) || ("".equals(str))) {
      return;
    }
    localEditor.putInt("QFIND_SETTING_REPORT_SAME_DEVICE_INTERVAL" + str, this.bAB);
    localEditor.putInt("QFIND_SETTING_REPORT_ANY_DEVICE_INTERVAL" + str, this.bAC);
    localEditor.putInt("QFIND_SETTING_REPORT_OFTEN_FREQUENCE" + str, this.bAE);
    localEditor.putInt("QFIND_SETTING_REPORT_OFTEN_PERIOD" + str, this.bAD);
    localEditor.putLong("QFIND_SETTING_LAST_REPORT_PERIOD_START" + str, this.DQ);
    localEditor.putInt("QFIND_SETTING_LAST_REPORT_COUNT" + str, this.bAH);
    localEditor.putInt("QFIND_SETTING_REPORT_SAME_LOST_DEVS_INTERVAL" + str, this.bAF);
    localEditor.putInt("QFIND_SETTING_REPORT_FORCE_REPORT_LBS_PERIOD" + str, this.bAG);
    localEditor.commit();
  }
  
  private void bCj()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr cancelReceiver");
    }
    zg(2);
    if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$a != null) {}
    try
    {
      this.context.unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$a);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void bCk()
  {
    try
    {
      this.newHT = ThreadManager.newFreeHandlerThread("ble_scan_task", 0);
      this.newHT.start();
      this.m = new MqqHandler(this.newHT.getLooper());
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = new tak(this);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  private void zg(int paramInt)
  {
    if (this.mWakeLock != null)
    {
      this.mWakeLock.release();
      this.mWakeLock = null;
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr releaseWakeLock:" + paramInt);
      }
    }
  }
  
  public tai a(taf paramtaf)
  {
    tai localtai = new tai();
    localtai.bAA = paramtaf.bAs;
    localtai.name = paramtaf.name;
    localtai.address = paramtaf.address;
    localtai.bT = paramtaf.bT;
    localtai.pN = paramtaf.pN;
    localtai.pid = paramtaf.pid;
    return localtai;
  }
  
  public void aV(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1;
    try
    {
      localObject1 = new QFind.ReqReportDevs();
      ((QFind.ReqReportDevs)localObject1).mergeFrom(paramToServiceMsg.getWupBuffer(), 4, paramToServiceMsg.getWupBuffer().length - 4);
      paramObject = new QFind.RspReportDevs();
      paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      int i = paramToServiceMsg.getAppSeq();
      paramToServiceMsg = this.gp.values().iterator();
      while ((paramToServiceMsg.hasNext()) && (i != ((taf)paramToServiceMsg.next()).seq)) {}
      if (paramObject.result.get() != 0) {
        break label704;
      }
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = new ArrayList();
      Iterator localIterator = ((QFind.ReqReportDevs)localObject1).dev_infos.get().iterator();
      Object localObject2;
      while (localIterator.hasNext())
      {
        localObject2 = (QFind.DeviceInfo)localIterator.next();
        localObject2 = "" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8();
        paramFromServiceMsg.add(localObject2);
        this.gr.remove(localObject2);
      }
      String str;
      paramFromServiceMsg = paramFromServiceMsg.iterator();
    }
    catch (Throwable paramToServiceMsg)
    {
      paramToServiceMsg.printStackTrace();
      return;
      localIterator = paramObject.lost_devs.get().iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (QFind.DeviceInfo)localIterator.next();
        str = "" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8();
        if (this.gr.containsKey(str)) {
          this.gr.remove(str);
        }
        this.gr.put(str, localObject2);
        paramToServiceMsg.add("" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        paramFromServiceMsg.remove("" + ((QFind.DeviceInfo)localObject2).pid.get() + "|" + ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        if (!((QFind.ReqReportDevs)localObject1).dev_loc.has()) {
          aW(((QFind.DeviceInfo)localObject2).pid.get(), ((QFind.DeviceInfo)localObject2).sn.get().toStringUtf8());
        }
      }
    }
    finally
    {
      zg(3);
    }
    while (paramFromServiceMsg.hasNext())
    {
      localObject1 = (String)paramFromServiceMsg.next();
      this.gq.remove(localObject1);
    }
    paramToServiceMsg = paramToServiceMsg.iterator();
    while (paramToServiceMsg.hasNext())
    {
      paramFromServiceMsg = (String)paramToServiceMsg.next();
      if (!this.gq.containsKey(paramFromServiceMsg)) {
        this.gq.put(paramFromServiceMsg, Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
      }
    }
    this.bAB = Math.max(paramObject.report_same_dev_interval.get() * 1000, 300000);
    this.bAC = Math.max(paramObject.report_any_devs_interval.get() * 1000, 300000);
    this.bAD = Math.max(paramObject.report_often_period.get() * 1000, 3600000);
    this.bAE = Math.max(paramObject.report_often_frequence.get(), 10);
    this.bAG = Math.max(paramObject.force_report_lbs_period.get(), 3600000);
    this.bAF = Math.max(paramObject.report_same_lost_devs_interval.get(), 300000);
    label704:
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuffer();
      paramToServiceMsg.append(", result=" + paramObject.result.get());
      paramToServiceMsg.append(", report_same_dev_interval=" + paramObject.report_same_dev_interval.get());
      paramToServiceMsg.append(", report_any_devs_interval=" + paramObject.report_any_devs_interval.get());
      paramToServiceMsg.append(", report_often_period=" + paramObject.report_often_period.get());
      paramToServiceMsg.append(", report_often_frequence=" + paramObject.report_often_frequence.get());
      paramToServiceMsg.append(", freq_limit_report_any_devs_interval=" + paramObject.freq_limit_report_any_devs_interval.get());
      paramToServiceMsg.append(", force_report_lbs=" + paramObject.force_report_lbs.get());
      paramToServiceMsg.append(", force_report_lbs_period=" + paramObject.force_report_lbs_period.get());
      paramToServiceMsg.append(", report_same_lost_devs_interval=" + paramObject.report_same_lost_devs_interval.get());
      paramToServiceMsg.append(", report_max_dev_num=" + paramObject.report_max_dev_num.get());
      paramToServiceMsg.append(", lost_devs=[");
      paramFromServiceMsg = paramObject.lost_devs.get().iterator();
      while (paramFromServiceMsg.hasNext())
      {
        paramObject = (QFind.DeviceInfo)paramFromServiceMsg.next();
        paramToServiceMsg.append(paramObject.pid.get() + "|" + paramObject.sn.get().toStringUtf8() + "|" + paramObject.timestamp.get() + ",");
      }
      paramToServiceMsg.append("]");
      QLog.w("QFindBLE", 2, "get report dev result " + paramToServiceMsg);
    }
    zg(3);
  }
  
  public void destroy()
  {
    stopScan();
    if (this.m != null)
    {
      this.m.removeCallbacksAndMessages(null);
      this.m.getLooper().quit();
    }
    if (this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver != null)
    {
      this.context.unregisterReceiver(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver);
      this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$NotifyReceiver = null;
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
    {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter = null;
    }
    if (this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback != null) {
      this.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback = null;
    }
    if (this.newHT != null)
    {
      this.newHT.quitSafely();
      this.newHT = null;
    }
    if (this.app != null) {
      this.app = null;
    }
    syo.destroy();
  }
  
  public void stopScan()
  {
    if (!NB()) {
      return;
    }
    ad(false);
    this.aOk = false;
  }
  
  public class NotifyReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Object localObject = null;
      paramContext = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr NotifyReceiver onReceive action=" + paramContext);
      }
      int i;
      if ("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED".equals(paramContext))
      {
        i = paramIntent.getExtras().getInt("com.tencent.device.ble.EXTRA_BLEID");
        paramIntent = this.this$0.gp.values().iterator();
        do
        {
          if (!paramIntent.hasNext()) {
            break;
          }
          paramContext = (taf)paramIntent.next();
        } while (paramContext.bAs != i);
      }
      for (;;)
      {
        if (paramContext == null) {
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr GATT_SERVICES_DISCOVERED bleId " + i + " is not in mReportedDevice");
          }
        }
        label542:
        do
        {
          do
          {
            do
            {
              return;
              paramContext = JNIEngineLite.packVerifyReq((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
              syo.a().i(i, paramContext);
            } while (!QLog.isColorLevel());
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr GATT_SERVICES_DISCOVERED bleId " + i);
            return;
            if (!"onDeviceVerifyRsp".equals(paramContext)) {
              break label542;
            }
            paramContext = paramIntent.getExtras();
            i = paramContext.getInt("bleId");
            paramIntent = paramContext.getByteArray("buffer");
            Iterator localIterator = this.this$0.gp.values().iterator();
            do
            {
              paramContext = localObject;
              if (!localIterator.hasNext()) {
                break;
              }
              paramContext = (taf)localIterator.next();
            } while (paramContext.bAs != i);
            if (paramContext != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp bleId " + i + " is not in mReportedDevice");
          return;
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp bleId " + i + ": data " + paramIntent.length);
          }
          if (!paramContext.reported)
          {
            paramContext.sig = paramIntent;
            QFindBLEScanMgr.a(this.this$0, paramContext, paramContext.d, true);
            paramIntent = "" + paramContext.pid + "|" + paramContext.nY();
            paramContext.reported = true;
            paramContext.connected = false;
            paramIntent = (taf)this.this$0.gp.put(paramIntent, paramContext);
            if (QLog.isColorLevel()) {
              QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp old bleId " + paramIntent.bAs + " ; reported = " + paramIntent.reported);
            }
          }
          for (;;)
          {
            syo.a().tZ(paramContext.nY());
            return;
            if (QLog.isColorLevel()) {
              QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp report already bleId " + i + " ; reported = " + paramContext.reported);
            }
          }
        } while (!"QFIND_BLE_CONNECT_ERROR".equals(paramContext));
        i = paramIntent.getExtras().getInt("bleId");
        paramIntent = this.this$0.gp.values().iterator();
        do
        {
          if (!paramIntent.hasNext()) {
            break;
          }
          paramContext = (taf)paramIntent.next();
        } while (paramContext.bAs != i);
        for (;;)
        {
          if (paramContext == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR bleId " + i + " is not in mReportedDevice");
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR bleId " + i + " ; reported = " + paramContext.reported);
          }
          if (!paramContext.reported)
          {
            QFindBLEScanMgr.a(this.this$0, paramContext, paramContext.d, false);
            paramIntent = "" + paramContext.pid + "|" + paramContext.nY();
            paramContext.reported = true;
            paramContext.connected = false;
            paramContext = (taf)this.this$0.gp.put(paramIntent, paramContext);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR old bleId " + paramContext.bAs + " ; reported = " + paramContext.reported);
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR report already bleId " + i + " ; reported = " + paramContext.reported);
          return;
          paramContext = null;
        }
        paramContext = null;
      }
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr alarm is coming " + paramIntent.getAction());
      }
      if ((this.this$0.m == null) || (System.currentTimeMillis() - QFindBLEScanMgr.a(this.this$0) < this.this$0.bAI)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr startScan");
      }
      this.this$0.m.post(new QFindBLEScanMgr.ScanReceiver.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr
 * JD-Core Version:    0.7.0.1
 */