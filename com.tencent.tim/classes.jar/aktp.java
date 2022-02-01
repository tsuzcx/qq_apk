import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager.3;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.onlinestatus.BusinessInfo.LocationPoiInfo;

public class aktp
  implements acek.a, akuk.a, Handler.Callback, Manager
{
  private akue a;
  private long aeo = 300L;
  private boolean cuz;
  private ConcurrentHashMap<String, akuf> gt = new ConcurrentHashMap(10);
  Runnable hj = new OnlineStatusManager.2(this);
  Runnable hk = new OnlineStatusManager.3(this);
  private QQAppInterface mApp;
  
  public aktp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    acek.a().a(this);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, TextView paramTextView, @NonNull Friends paramFriends, int paramInt)
  {
    paramQQAppInterface = "";
    if (!b(paramFriends)) {
      return "";
    }
    if (paramFriends.poiUpdateTime > 0L)
    {
      String str = j(NetConnInfoCenter.getServerTime(), paramFriends.poiUpdateTime);
      paramQQAppInterface = str;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusManager", 2, new Object[] { "getLocationDisplayInfo passTimeTip=", str });
        paramQQAppInterface = str;
      }
    }
    paramFriends = "我在" + paramFriends.poiName;
    if (paramTextView == null) {
      return paramFriends + paramQQAppInterface;
    }
    float f1 = 350.0F;
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "getLocationDisplayInfo fromAIO");
      }
      f1 = 200.0F;
    }
    float f2 = f1;
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      f2 = f1 - paramTextView.getPaint().measureText(paramQQAppInterface);
    }
    paramTextView = aeeu.a(paramTextView.getPaint(), paramFriends, aqnm.dip2px(f2));
    return paramTextView + paramQQAppInterface;
  }
  
  public static void a(Friends paramFriends, byte[] paramArrayOfByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "parseFriendPoiInfo from ", paramString, ", uin:", paramFriends.uin });
    }
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length > 0)
        {
          BusinessInfo.LocationPoiInfo localLocationPoiInfo = new BusinessInfo.LocationPoiInfo();
          localLocationPoiInfo.mergeFrom(paramArrayOfByte);
          long l = localLocationPoiInfo.update_time.get();
          paramArrayOfByte = localLocationPoiInfo.poi_name.get().toStringUtf8();
          double d1 = localLocationPoiInfo.longitude.get();
          double d2 = localLocationPoiInfo.latitude.get();
          int i = localLocationPoiInfo.flag.get();
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusManager", 2, new Object[] { "update parseFriendPoiInfo from ", paramString, ", uin:", paramFriends.uin, " , server updateTime:", Long.valueOf(l), ", poiName:", paramArrayOfByte, ", local poiUpdateTime:", Long.valueOf(paramFriends.poiUpdateTime), " longitude:", Double.valueOf(d1), " latitude:", Double.valueOf(d2), " floag:", Integer.valueOf(i) });
          }
          if ((l > paramFriends.poiUpdateTime) && (i == 0))
          {
            paramFriends.poiName = paramArrayOfByte;
            paramFriends.poiUpdateTime = l;
            paramFriends.latitude = d2;
            paramFriends.longitude = d1;
            paramFriends.poiFlag = 0;
            return;
          }
          if (l <= paramFriends.poiUpdateTime) {
            return;
          }
          g(paramFriends);
          return;
        }
      }
      catch (Exception paramFriends)
      {
        QLog.d("OnlineStatusManager", 1, "parseFriendPoiInfo fail", paramFriends);
        return;
      }
    } else {
      g(paramFriends);
    }
  }
  
  private boolean asK()
  {
    if ((this.mApp == null) || (!this.mApp.isRunning()))
    {
      if (QLog.isColorLevel()) {
        if (this.mApp != null) {
          break label56;
        }
      }
      label56:
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.mApp.isRunning()))
      {
        QLog.d("OnlineStatusManager", 2, new Object[] { "checkAppValid app.isRunning=", localObject });
        return false;
      }
    }
    return true;
  }
  
  public static boolean b(Friends paramFriends)
  {
    if (paramFriends == null) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "friend is null");
      }
    }
    do
    {
      do
      {
        return false;
        if (!TextUtils.isEmpty(paramFriends.poiName)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusManager", 2, "showLocationOnLineStatus no poiName");
      return false;
      if (paramFriends.poiFlag == 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, new Object[] { "showLocationOnLineStatus poiFlag:", Integer.valueOf(paramFriends.poiFlag) });
    return false;
    return true;
  }
  
  public static void g(Friends paramFriends)
  {
    paramFriends.poiName = "";
    paramFriends.poiUpdateTime = 0L;
    paramFriends.longitude = 0.0D;
    paramFriends.latitude = 0.0D;
    paramFriends.poiFlag = 0;
  }
  
  public static String j(long paramLong1, long paramLong2)
  {
    paramLong1 -= paramLong2;
    if (paramLong1 <= 600L) {
      return "";
    }
    if (paramLong1 < 3600L)
    {
      paramLong1 /= 60L;
      return " " + paramLong1 + "分钟前";
    }
    if (paramLong1 < 86400L)
    {
      paramLong1 /= 3600L;
      return " " + paramLong1 + "小时前";
    }
    if (paramLong1 < 2592000L)
    {
      paramLong1 /= 86400L;
      return " " + paramLong1 + "天前";
    }
    if (paramLong1 < 31104000L)
    {
      paramLong1 /= 2592000L;
      return " " + paramLong1 + "月前";
    }
    return "";
  }
  
  public void Sm(int paramInt)
  {
    SosoInterface.a(new akuk(paramInt, new Intent(), this));
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendLocationInfo type:", Integer.valueOf(paramInt) });
    }
  }
  
  public akue a()
  {
    return this.a;
  }
  
  public akuf a(String paramString)
  {
    akuf localakuf2 = (akuf)this.gt.get(paramString);
    akuf localakuf1 = localakuf2;
    if (localakuf2 == null)
    {
      localakuf1 = new akuf(paramString);
      this.gt.put(paramString, localakuf1);
    }
    return localakuf1;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      if (paramJSONObject != null) {
        break label53;
      }
    }
    label53:
    for (Object localObject1 = "";; localObject1 = paramJSONObject.toString())
    {
      QLog.d("OnlineStatusManager", 2, new Object[] { "retCode：", Integer.valueOf(paramInt1), " result:", localObject1 });
      if (paramJSONObject != null) {
        break;
      }
      return;
    }
    label382:
    for (;;)
    {
      Object localObject2;
      try
      {
        if (paramJSONObject.getInt("status") != 0) {
          break;
        }
        localObject1 = new StringBuilder(10);
        paramJSONObject = paramJSONObject.optJSONObject("result");
        if (paramJSONObject != null)
        {
          localObject2 = paramJSONObject.optJSONObject("address_component");
          if (localObject2 != null) {
            ((StringBuilder)localObject1).append(((JSONObject)localObject2).optString("district"));
          }
          paramJSONObject = paramJSONObject.optJSONObject("address_reference");
          if (paramJSONObject != null)
          {
            paramJSONObject = paramJSONObject.optJSONObject("landmark_l2");
            if (paramJSONObject != null) {
              ((StringBuilder)localObject1).append(paramJSONObject.optString("title"));
            }
          }
        }
        paramJSONObject = this.a;
        if (!akue.a(this.a, paramDouble1, paramDouble2)) {
          break label382;
        }
        paramJSONObject = new akue(paramDouble1, paramDouble2, ((StringBuilder)localObject1).toString());
        if (paramJSONObject == null) {
          break;
        }
        this.a = paramJSONObject;
        localObject2 = (akun)this.mApp.getBusinessHandler(174);
        localObject1 = akti.a().a(paramJSONObject);
        byte[] arrayOfByte = ((Bundle)localObject1).getByteArray("LocationInfo");
        a(((acff)this.mApp.getManager(51)).d(this.mApp.getCurrentUin()), arrayOfByte, "report(self)");
        if (3 == paramInt2)
        {
          ((akun)localObject2).J(2, (Bundle)localObject1);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("OnlineStatusManager", 2, paramJSONObject.toString());
        return;
      }
      if (2 == paramInt2)
      {
        ((akun)localObject2).a(2, akti.a().a(paramJSONObject, true), null);
        return;
      }
      if (4 == paramInt2)
      {
        localObject1 = null;
        if (paramIntent.hasExtra("online_status_permission_item")) {
          localObject1 = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
        }
        ((akun)localObject2).a(2, akti.a().a(paramJSONObject, false), (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject1);
        return;
      }
      if (5 != paramInt2) {
        break;
      }
      ((akun)localObject2).notifyUI(6, true, null);
      return;
    }
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(paramBoolean) });
    }
    long l;
    if ((paramBoolean) && (paramStatus == AppRuntime.Status.online))
    {
      l = this.mApp.getExtOnlineStatus();
      paramStatus = (akun)this.mApp.getBusinessHandler(174);
      if (l != 1000L) {
        break label92;
      }
      paramStatus.a(1, akti.a().a(this.mApp, true), null);
    }
    for (;;)
    {
      dDr();
      return;
      label92:
      if (l == -1L) {
        Sm(2);
      }
    }
  }
  
  public void dDr()
  {
    Object localObject;
    if ((this.mApp == null) || (!this.mApp.isRunning())) {
      if (QLog.isColorLevel())
      {
        if (this.mApp != null) {
          break label55;
        }
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask app.isRunning=", localObject });
      }
    }
    label55:
    long l;
    label176:
    do
    {
      do
      {
        return;
        localObject = Boolean.valueOf(this.mApp.isRunning());
        break;
        localObject = this.mApp.getOnlineStatusNonSync();
        l = this.mApp.getExtOnlineStatus();
        if ((localObject != AppRuntime.Status.online) || ((l != 1000L) && (l != -1L))) {
          break label176;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.hj);
        ThreadManager.getSubThreadHandler().postDelayed(this.hj, this.aeo * 1000L);
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask schedule msgTimer after ", Long.valueOf(this.aeo), " seconds" });
      return;
      dDs();
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask cancel status", localObject, " extStatus:", Long.valueOf(l) });
  }
  
  public void dDs()
  {
    Object localObject;
    if ((this.mApp == null) || (!this.mApp.isRunning())) {
      if (QLog.isColorLevel())
      {
        if (this.mApp != null) {
          break label55;
        }
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "cancelTimedMsgTask app.isRunning=", localObject });
      }
    }
    label55:
    do
    {
      return;
      localObject = Boolean.valueOf(this.mApp.isRunning());
      break;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hj);
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, "cancelTimedMsgTask");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void kv(long paramLong)
  {
    this.aeo = paramLong;
  }
  
  public void onAppBackground()
  {
    if (!asK()) {}
    do
    {
      AppRuntime.Status localStatus;
      long l;
      do
      {
        return;
        localStatus = this.mApp.getOnlineStatusNonSync();
        l = this.mApp.getExtOnlineStatus();
      } while ((localStatus != AppRuntime.Status.online) || (l != -1L) || (!this.mApp.isBackground_Stop));
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hk);
      ThreadManager.getSubThreadHandler().postDelayed(this.hk, 60000L);
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, "onRunningBackground");
  }
  
  public void onAppForeground()
  {
    if (!asK()) {}
    do
    {
      AppRuntime.Status localStatus;
      long l;
      do
      {
        return;
        localStatus = this.mApp.getOnlineStatusNonSync();
        l = this.mApp.getExtOnlineStatus();
      } while ((localStatus != AppRuntime.Status.online) || (l != -1L));
      ThreadManager.getSubThreadHandler().removeCallbacks(this.hk);
      this.cuz = false;
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, "onRunningForground");
  }
  
  public void onDestroy()
  {
    dDs();
    acek.a().b(this);
  }
  
  public void x(BaseActivity paramBaseActivity)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramBaseActivity.requestPermissions(new aktq(this, paramBaseActivity), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      return;
    }
    Sm(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aktp
 * JD-Core Version:    0.7.0.1
 */