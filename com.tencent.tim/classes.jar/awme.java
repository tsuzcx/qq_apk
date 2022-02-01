import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.adv_report.MobileAdvReportReq;
import cooperation.vip.pb.adv_report.SubscribeInfo;
import cooperation.vip.pb.vac_adv_get.QzoneBusiMsg;
import cooperation.vip.pb.vac_adv_get.VacAdvReq;
import cooperation.vip.pb.vac_adv_get.VacAdvRsp;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class awme
  extends MSFServlet
{
  public static void a(long paramLong, int paramInt1, String paramString, int paramInt2, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    try
    {
      paramString = BaseApplicationImpl.getApplication().getRuntime();
      vac_adv_get.VacAdvReq localVacAdvReq = new vac_adv_get.VacAdvReq();
      localVacAdvReq.adv_pos.set(paramInt1);
      localVacAdvReq.qq.set(paramLong);
      localVacAdvReq.qzone_busi_info.set(new vac_adv_get.QzoneBusiMsg());
      if (paramDeviceInfo != null) {
        localVacAdvReq.device_info.set(paramDeviceInfo);
      }
      paramDeviceInfo = new NewIntent(paramString.getApplication(), awme.class);
      paramDeviceInfo.putExtra("data", aqnv.I(localVacAdvReq.toByteArray()));
      paramDeviceInfo.putExtra("cmd", "MobileAdv.AdvGet");
      paramDeviceInfo.putExtra("gdt_adv_business_type", paramInt2);
      paramString.startServlet(paramDeviceInfo);
      return;
    }
    catch (Exception paramString)
    {
      QZLog.e("GdtGeneralServlet", "onGdtADVGetRsp error" + paramString.toString());
    }
  }
  
  public static void a(awlr paramawlr, qq_ad_get.QQAdGet.DeviceInfo paramDeviceInfo)
  {
    if (paramawlr == null) {
      return;
    }
    for (;;)
    {
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        adv_report.MobileAdvReportReq localMobileAdvReportReq = new adv_report.MobileAdvReportReq();
        PBStringField localPBStringField = localMobileAdvReportReq.recomm_cookie;
        if (paramawlr.cRj == null)
        {
          str = "";
          localPBStringField.set(str);
          localMobileAdvReportReq.adv_pos.set(paramawlr.EP);
          localMobileAdvReportReq.action_type.set(paramawlr.mType);
          localMobileAdvReportReq.action_value.set(paramawlr.eBB);
          localMobileAdvReportReq.feed_index.set(paramawlr.eBA);
          if (paramDeviceInfo != null) {
            localMobileAdvReportReq.device_info.set(paramDeviceInfo);
          }
          localMobileAdvReportReq.qq.set(paramawlr.mUin);
          if (!TextUtils.isEmpty(paramawlr.cRk))
          {
            paramDeviceInfo = new adv_report.SubscribeInfo();
            paramDeviceInfo.id.set(paramawlr.cRk);
            localMobileAdvReportReq.subscribe_info.set(paramDeviceInfo);
          }
          paramDeviceInfo = new NewIntent(localAppRuntime.getApplication(), awme.class);
          paramDeviceInfo.putExtra("data", aqnv.I(localMobileAdvReportReq.toByteArray()));
          paramDeviceInfo.putExtra("cmd", "MobileAdv.AdvReport");
          if (QZLog.isColorLevel()) {
            QZLog.i("GdtGeneralServlet", " @getGdtInfo sendGdtADVReportReq " + paramawlr.toString());
          }
          localAppRuntime.startServlet(paramDeviceInfo);
          return;
        }
      }
      catch (Exception paramawlr)
      {
        QZLog.e("GdtGeneralServlet", "sendGdtADVReportReq error" + paramawlr.toString());
        return;
      }
      String str = paramawlr.cRj;
    }
  }
  
  public void T(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = -1;
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        int j = paramFromServiceMsg.getWupBuffer().length - 4;
        byte[] arrayOfByte = new byte[j];
        aqoj.copyData(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, j);
        paramFromServiceMsg = new vac_adv_get.VacAdvRsp();
        paramFromServiceMsg.mergeFrom(arrayOfByte);
        if (paramIntent != null) {
          i = paramIntent.getIntExtra("gdt_adv_business_type", -1);
        }
        if (paramFromServiceMsg.err_code.get() == 0)
        {
          awmc.a().a(i, paramFromServiceMsg);
          return;
        }
        QZLog.e("GdtGeneralServlet", "onGdtADVGetRsp err_code =" + paramFromServiceMsg.err_code.get() + "erro_msg =" + paramFromServiceMsg.err_msg.get());
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QZLog.e("GdtGeneralServlet", "onGdtADVGetRsp error" + paramIntent.toString());
    }
  }
  
  public void U(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        int i = paramFromServiceMsg.getWupBuffer().length - 4;
        aqoj.copyData(new byte[i], 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QZLog.e("GdtGeneralServlet", "onGdtADVReportRsp error" + paramIntent.toString());
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtGeneralServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    String str2;
    label154:
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
          break label154;
        }
      }
      for (String str1 = "";; str1 = "not")
      {
        QLog.d("GdtGeneralServlet", 2, str1 + " success");
        if (!str2.equals("MobileAdv.AdvGet")) {
          break;
        }
        T(paramIntent, paramFromServiceMsg);
        return;
      }
    } while (!str2.equals("MobileAdv.AdvReport"));
    U(paramIntent, paramFromServiceMsg);
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
      QLog.d("GdtGeneralServlet", 2, "onSend exit cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awme
 * JD-Core Version:    0.7.0.1
 */