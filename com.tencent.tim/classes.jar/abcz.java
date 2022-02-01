import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.jungle.weather.proto.WeatherReportInfo.Area;
import com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsReq;
import com.tencent.jungle.weather.proto.WeatherReportInfo.GetWeatherByLbsRsp;
import com.tencent.jungle.weather.proto.WeatherReportInfo.PbRspMsgHead;
import com.tencent.mobileqq.activity.weather.WeatherServlet.PermissionCallback.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.AppActivity;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.app.QQPermissionCallback;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class abcz
  extends MSFServlet
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, AppActivity paramAppActivity)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), abcz.class);
    localNewIntent.putExtra("req_type", 8888);
    localNewIntent.putExtra("latitide", paramInt1);
    localNewIntent.putExtra("longtitude", paramInt2);
    a(paramQQAppInterface, localNewIntent, paramAppActivity);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AppActivity paramAppActivity)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), abcz.class);
    localNewIntent.putExtra("req_type", 6666);
    localNewIntent.putExtra("uin", Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    a(paramQQAppInterface, localNewIntent, paramAppActivity);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, NewIntent paramNewIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "startLocation onLocationStart");
    }
    aczc.a(new abda("qq_weather", false, paramNewIntent, paramQQAppInterface));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, NewIntent paramNewIntent, AppActivity paramAppActivity)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramAppActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("public_account_weather", 0);
        long l1 = localSharedPreferences.getLong("drawer_last_location_auth_dialog_time", 0L);
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > 86400000L)
        {
          localSharedPreferences.edit().putLong("drawer_last_location_auth_dialog_time", l2).apply();
          paramAppActivity.requestPermissions(new abcz.a(paramQQAppInterface, paramNewIntent, paramAppActivity, null), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 1, "without 24 hour from last location auth dialog");
        }
        paramNewIntent.putExtra("adcode", 0);
        paramQQAppInterface.startServlet(paramNewIntent);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 1, "location permitted above android M");
      }
      a(paramQQAppInterface, paramNewIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 1, "direct locate in system below android M");
    }
    a(paramQQAppInterface, paramNewIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (!"QQWeatherReport.getWeatherByLbs".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    boolean bool2 = paramFromServiceMsg.isSuccess();
    int i = paramIntent.getIntExtra("req_type", 0);
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramIntent.getExtras());
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "WeatherServlet onReceive isSucess1:" + bool2);
    }
    bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new WeatherReportInfo.GetWeatherByLbsRsp();
        ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).mergeFrom(paramFromServiceMsg);
        if (((WeatherReportInfo.GetWeatherByLbsRsp)localObject).pbRspMsgHead.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "WeatherServlet onReceive isSucess2:" + bool1);
        }
        if (!bool1) {
          continue;
        }
        localBundle.putString("KEY_TEMPER", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).temper.get());
        localBundle.putString("o_wea_code", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).o_wea_code.get());
        localBundle.putString("area_info", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).area.city.get() + "-" + ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).area.area_name.get());
        localBundle.putInt("adcode", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).area.area_id.get());
        localBundle.putInt("show_flag", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).show_flag.get());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        Object localObject;
        paramFromServiceMsg.printStackTrace();
        bool1 = false;
        continue;
      }
      notifyObserver(paramIntent, i, bool1, localBundle, abcy.class);
      return;
      bool1 = false;
      continue;
      localBundle.putInt("uint32_result", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).pbRspMsgHead.uint32_result.get());
      localBundle.putString("string_err_msg", ((WeatherReportInfo.GetWeatherByLbsRsp)localObject).pbRspMsgHead.string_err_msg.get());
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("req_type", 0);
    int j = paramIntent.getIntExtra("adcode", 0);
    Object localObject;
    switch (i)
    {
    default: 
      throw new RuntimeException("Weatherservlet unknow req_type: " + i);
    case 6666: 
      localObject = new WeatherReportInfo.GetWeatherByLbsReq();
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).uin.set(paramIntent.getLongExtra("uin", 0L));
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).adcode_from_mapsdk.set(j);
    }
    for (paramIntent = ((WeatherReportInfo.GetWeatherByLbsReq)localObject).toByteArray();; paramIntent = ((WeatherReportInfo.GetWeatherByLbsReq)localObject).toByteArray())
    {
      localObject = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject).putInt(paramIntent.length + 4).put(paramIntent);
      paramPacket.setSSOCommand("QQWeatherReport.getWeatherByLbs");
      paramPacket.putSendData(((ByteBuffer)localObject).array());
      return;
      localObject = new WeatherReportInfo.GetWeatherByLbsReq();
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).lat.set(paramIntent.getIntExtra("latitide", 0));
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).lng.set(paramIntent.getIntExtra("longtitude", 0));
      ((WeatherReportInfo.GetWeatherByLbsReq)localObject).adcode_from_mapsdk.set(j);
    }
  }
  
  public static final class a
    implements QQPermissionCallback
  {
    private WeakReference<QQAppInterface> K;
    private WeakReference<NewIntent> aj;
    private WeakReference<AppActivity> q;
    
    private a(QQAppInterface paramQQAppInterface, NewIntent paramNewIntent, AppActivity paramAppActivity)
    {
      this.K = new WeakReference(paramQQAppInterface);
      this.aj = new WeakReference(paramNewIntent);
      this.q = new WeakReference(paramAppActivity);
    }
    
    public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 1, "User requestPermissions denied...");
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)this.K.get();
      NewIntent localNewIntent = (NewIntent)this.aj.get();
      AppActivity localAppActivity = (AppActivity)this.q.get();
      if ((localQQAppInterface != null) && (localNewIntent != null) && (localAppActivity != null))
      {
        ThreadManager.getSubThreadHandler().post(new WeatherServlet.PermissionCallback.1(this, localNewIntent, localQQAppInterface));
        aqha.a(localAppActivity, paramArrayOfString, paramArrayOfInt);
      }
    }
    
    public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("weatherManager", 1, "User requestPermissions grant...");
      }
      paramArrayOfString = (QQAppInterface)this.K.get();
      paramArrayOfInt = (NewIntent)this.aj.get();
      if ((paramArrayOfString != null) && (paramArrayOfInt != null)) {
        abcz.b(paramArrayOfString, paramArrayOfInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abcz
 * JD-Core Version:    0.7.0.1
 */