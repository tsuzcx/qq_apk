import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.pb.mobile_monitor_report.ExceptionReport;
import cooperation.vip.pb.mobile_monitor_report.PkgExceptionReq;
import cooperation.vip.pb.mobile_monitor_report.PkgRsp;
import cooperation.vip.pb.mobile_monitor_report.PkgTraceReq;
import cooperation.vip.pb.mobile_monitor_report.TraceReport;
import cooperation.vip.pb.mobile_monitor_report.UserCommReport;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.new_year_2014.Unisso.UniSsoServerReq;
import tencent.im.new_year_2014.Unisso.UniSsoServerReqComm;
import tencent.im.new_year_2014.Unisso.UniSsoServerRsp;

public class awmk
  extends MSFServlet
{
  private void V(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = null;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    mobile_monitor_report.PkgRsp localPkgRsp = new mobile_monitor_report.PkgRsp();
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000) {
      try
      {
        paramFromServiceMsg = new Unisso.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(arrayOfByte);
        long l = paramFromServiceMsg.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("MonitorServlet", 1, new Object[] { " unissoResult=", Long.valueOf(l) });
        }
        localPkgRsp.mergeFrom(paramFromServiceMsg.rspdata.get().toByteArray());
        i = localPkgRsp.ret.get();
        if (i == 0)
        {
          MonitorManager.a().lo(localPkgRsp.mult_cnt.get(), localPkgRsp.mult_delay.get());
          if (QLog.isColorLevel()) {
            QLog.d("MonitorServlet", 2, "onReceive ret " + i);
          }
          notifyObserver(paramIntent, 1000, true, new Bundle(), awmj.class);
          return;
        }
        QLog.d("MonitorServlet", 2, "onReceive ret " + i);
        notifyObserver(paramIntent, 1000, false, new Bundle(), awmj.class);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("MonitorServlet", 2, "onReceive exception " + paramFromServiceMsg);
        notifyObserver(paramIntent, 1000, false, new Bundle(), awmj.class);
        return;
      }
    }
    QLog.e("MonitorServlet", 2, "onReceive result fail with result " + i);
    notifyObserver(paramIntent, 1000, false, new Bundle(), awmj.class);
  }
  
  private void W(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = null;
    if (paramFromServiceMsg.isSuccess())
    {
      i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      aqoj.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    mobile_monitor_report.PkgRsp localPkgRsp = new mobile_monitor_report.PkgRsp();
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000) {
      try
      {
        paramFromServiceMsg = new Unisso.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(arrayOfByte);
        long l = paramFromServiceMsg.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d("MonitorServlet", 1, new Object[] { " unissoResult=", Long.valueOf(l) });
        }
        localPkgRsp.mergeFrom(paramFromServiceMsg.rspdata.get().toByteArray());
        i = localPkgRsp.ret.get();
        if (i == 0)
        {
          MonitorManager.a().lo(localPkgRsp.mult_cnt.get(), localPkgRsp.mult_delay.get());
          if (QLog.isColorLevel()) {
            QLog.d("MonitorServlet", 2, "onReceive ret " + i);
          }
          notifyObserver(paramIntent, 1000, true, new Bundle(), awmj.class);
          return;
        }
        QLog.d("MonitorServlet", 2, "onReceive ret " + i);
        notifyObserver(paramIntent, 1000, false, new Bundle(), awmj.class);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("MonitorServlet", 2, "onReceive exception " + paramFromServiceMsg);
        notifyObserver(paramIntent, 1000, false, new Bundle(), awmj.class);
        return;
      }
    }
    QLog.e("MonitorServlet", 2, "onReceive result fail with result " + i);
    notifyObserver(paramIntent, 1000, false, new Bundle(), awmj.class);
  }
  
  private static mobile_monitor_report.UserCommReport a()
  {
    mobile_monitor_report.UserCommReport localUserCommReport = new mobile_monitor_report.UserCommReport();
    localUserCommReport.qua.set(String.valueOf(avpq.getQUA3()));
    localUserCommReport.imei.set(String.valueOf(arxr.getImei()));
    String str = aczc.getCityCode();
    localUserCommReport.city_code.set(str);
    localUserCommReport.mobile_type.set(Build.MODEL);
    localUserCommReport.net_type.set(getNetWorkType());
    localUserCommReport.from_id.set(2);
    return localUserCommReport;
  }
  
  private static int getNetWorkType()
  {
    switch (aqiw.getNetworkType(BaseApplicationImpl.getContext()))
    {
    default: 
      return 1;
    case 1: 
      return 3;
    case 4: 
      return 4;
    case 3: 
      return 5;
    }
    return 6;
  }
  
  public static void ox(List<mobile_monitor_report.ExceptionReport> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    mobile_monitor_report.PkgExceptionReq localPkgExceptionReq = new mobile_monitor_report.PkgExceptionReq();
    localPkgExceptionReq.exception_report.set(paramList);
    paramList = a();
    localPkgExceptionReq.user_comm_report.set(paramList);
    paramList = new NewIntent(localAppRuntime.getApplication(), awmk.class);
    Unisso.UniSsoServerReq localUniSsoServerReq = new Unisso.UniSsoServerReq();
    Unisso.UniSsoServerReqComm localUniSsoServerReqComm = new Unisso.UniSsoServerReqComm();
    localUniSsoServerReqComm.platform.set(109L);
    localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
    localUniSsoServerReqComm.mqqver.set("3.4.4");
    localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
    localUniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(localPkgExceptionReq.toByteArray()));
    paramList.putExtra("data", aqnv.I(localUniSsoServerReq.toByteArray()));
    paramList.putExtra("cmd", "MobileReport.ExceptionReport");
    localAppRuntime.startServlet(paramList);
  }
  
  public static void oy(List<mobile_monitor_report.TraceReport> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    mobile_monitor_report.PkgTraceReq localPkgTraceReq = new mobile_monitor_report.PkgTraceReq();
    localPkgTraceReq.trace_report.set(paramList);
    paramList = a();
    localPkgTraceReq.user_comm_report.set(paramList);
    paramList = new NewIntent(localAppRuntime.getApplication(), awmk.class);
    Unisso.UniSsoServerReq localUniSsoServerReq = new Unisso.UniSsoServerReq();
    Unisso.UniSsoServerReqComm localUniSsoServerReqComm = new Unisso.UniSsoServerReqComm();
    localUniSsoServerReqComm.platform.set(109L);
    localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
    localUniSsoServerReqComm.mqqver.set("3.4.4");
    localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
    localUniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(localPkgTraceReq.toByteArray()));
    paramList.putExtra("data", aqnv.I(localUniSsoServerReq.toByteArray()));
    paramList.putExtra("cmd", "MobileReport.TraceReport");
    localAppRuntime.startServlet(paramList);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MonitorServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    String str2;
    label157:
    do
    {
      do
      {
        return;
        str2 = paramFromServiceMsg.getServiceCmd();
      } while (str2 == null);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        boolean bool = paramFromServiceMsg.isSuccess();
        localStringBuilder = new StringBuilder().append("resp:").append(str2).append(" is ");
        if (!bool) {
          break label157;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("MonitorServlet", 2, str1 + " success");
        if (!str2.equals("MobileReport.ExceptionReport")) {
          break;
        }
        V(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("MobileReport.TraceReport"));
    W(paramIntent, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    String str = paramIntent.getStringExtra("cmd");
    long l = paramIntent.getLongExtra("timeout", 10000L);
    paramPacket.setSSOCommand(str);
    paramPacket.setTimeout(l);
    paramPacket.putSendData(arrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("MonitorServlet", 2, "onSend exit cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awmk
 * JD-Core Version:    0.7.0.1
 */