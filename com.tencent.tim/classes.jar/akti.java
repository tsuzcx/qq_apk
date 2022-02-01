import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.location.OnlineStatusLocationFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime.Status;
import tencent.im.onlinestatus.BusinessInfo.LocationPoiInfo;

public class akti
{
  private int OE;
  private auun a = new auun();
  private int dpa;
  
  public static int Hc()
  {
    int j;
    if (Build.VERSION.SDK_INT >= 21)
    {
      j = ((BatteryManager)BaseApplication.getContext().getSystemService("batterymanager")).getIntProperty(4);
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager ", Integer.valueOf(j) });
      }
    }
    for (int i = j;; i = 0)
    {
      j = i;
      if (i <= 0) {
        j = aqmj.bs(BaseApplicationImpl.sApplication.getApplicationContext());
      }
      return j;
    }
  }
  
  public static int Hd()
  {
    int i = aqmj.bt(BaseApplicationImpl.sApplication.getApplicationContext());
    int j = i;
    BatteryManager localBatteryManager;
    if (i == -1)
    {
      j = i;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localBatteryManager = (BatteryManager)BaseApplication.getContext().getSystemService("batterymanager");
        if (Build.VERSION.SDK_INT < 23) {
          break label129;
        }
      }
    }
    label129:
    for (boolean bool = localBatteryManager.isCharging();; bool = false)
    {
      int k = localBatteryManager.getIntProperty(6);
      if ((k == 2) || (k == 5) || (bool)) {}
      for (i = 1;; i = 0)
      {
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("OnLineStatusHelper", 2, new Object[] { "BatterManager isCharging:", Boolean.valueOf(bool), " chargeStatus:", Integer.valueOf(k) });
          j = i;
        }
        return j;
      }
    }
  }
  
  public static akti a()
  {
    return akti.a.b();
  }
  
  private Drawable a(akto paramakto, Friends paramFriends, int paramInt)
  {
    Object localObject2 = null;
    if (this.OE == 0)
    {
      this.OE = wja.dp2px(12.0F, BaseApplicationImpl.getContext().getResources());
      this.dpa = wja.dp2px(4.0F, BaseApplicationImpl.getContext().getResources());
    }
    Object localObject1 = localObject2;
    if (paramakto != null)
    {
      if (paramakto.itemType != 2) {
        break label68;
      }
      localObject1 = aktk.a(paramakto.f);
    }
    label68:
    do
    {
      return localObject1;
      if (!a(paramakto)) {
        break;
      }
      if (b(paramFriends) > 0) {
        return this.a.i(b(paramFriends), paramInt);
      }
      localObject1 = localObject2;
    } while (paramFriends != null);
    paramakto = URLDrawable.getDrawable(paramakto.iconUrl, URLDrawable.URLDrawableOptions.obtain());
    paramakto.setBounds(0, 0, this.OE, this.OE);
    return paramakto;
    paramakto = URLDrawable.getDrawable(paramakto.iconUrl, URLDrawable.URLDrawableOptions.obtain());
    paramakto.setBounds(0, 0, this.OE, this.OE);
    return paramakto;
  }
  
  private String b(Friends paramFriends)
  {
    if ((paramFriends != null) && (!TextUtils.isEmpty(paramFriends.strTermDesc)) && (paramFriends.strTermDesc.contains("在线")))
    {
      paramFriends = paramFriends.strTermDesc.substring(0, paramFriends.strTermDesc.length() - 2);
      if (!TextUtils.isEmpty(paramFriends)) {
        return paramFriends;
      }
    }
    return "手机";
  }
  
  public static int getSendBatteryStatus(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {}
    for (int i = paramInt1 | 0x80;; i = paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper ret:", Integer.valueOf(i), " batteryCapacity:", Integer.valueOf(paramInt1), " powerConectStatus:", Integer.valueOf(paramInt2) });
      }
      return i;
    }
  }
  
  public boolean M(QQAppInterface paramQQAppInterface, String paramString)
  {
    return false;
  }
  
  public int S(QQAppInterface paramQQAppInterface)
  {
    AppRuntime.Status localStatus = paramQQAppInterface.getOnlineStatus();
    long l = paramQQAppInterface.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1000L)) {
      return 1;
    }
    if ((localStatus == AppRuntime.Status.online) && (l == -1L)) {
      return 2;
    }
    return 0;
  }
  
  public akto a(AppRuntime.Status paramStatus, long paramLong)
  {
    aelg localaelg = (aelg)aeif.a().o(578);
    if (localaelg != null) {
      return localaelg.a(paramStatus, paramLong);
    }
    return new akto(AppRuntime.Status.online);
  }
  
  public akum a()
  {
    return akum.b();
  }
  
  public Drawable a(long paramLong, AppRuntime.Status paramStatus, int paramInt)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      akto localakto = a(AppRuntime.Status.online, paramLong);
      if (localakto != null) {
        return a(localakto, null, paramInt);
      }
    }
    return aktk.a(paramStatus);
  }
  
  public Bundle a(akue paramakue)
  {
    Bundle localBundle = new Bundle();
    BusinessInfo.LocationPoiInfo localLocationPoiInfo = new BusinessInfo.LocationPoiInfo();
    localLocationPoiInfo.latitude.set(paramakue.bo);
    localLocationPoiInfo.longitude.set(paramakue.bp);
    localLocationPoiInfo.poi_name.set(ByteStringMicro.copyFromUtf8(paramakue.bUh));
    long l = NetConnInfoCenter.getServerTime();
    localLocationPoiInfo.update_time.set(l);
    localLocationPoiInfo.flag.set(paramakue.dph);
    localBundle.putByteArray("LocationInfo", localLocationPoiInfo.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper buildSyncLocationData info:", paramakue.toString() });
    }
    return localBundle;
  }
  
  public Bundle a(akue paramakue, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    BusinessInfo.LocationPoiInfo localLocationPoiInfo = new BusinessInfo.LocationPoiInfo();
    if (paramakue != null)
    {
      localLocationPoiInfo.latitude.set(paramakue.bo);
      localLocationPoiInfo.longitude.set(paramakue.bp);
      localLocationPoiInfo.poi_name.set(ByteStringMicro.copyFromUtf8(paramakue.bUh));
      long l = NetConnInfoCenter.getServerTime();
      localLocationPoiInfo.update_time.set(l);
      localLocationPoiInfo.flag.set(paramakue.dph);
    }
    localBundle.putByteArray("LocationInfo", localLocationPoiInfo.toByteArray());
    localBundle.putBoolean("from_register", paramBoolean);
    if (QLog.isColorLevel()) {
      if (paramakue != null) {
        break label145;
      }
    }
    label145:
    for (paramakue = "";; paramakue = paramakue.toString())
    {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper buildSyncLocationData info:", paramakue });
      return localBundle;
    }
  }
  
  public Bundle a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    int i = paramQQAppInterface.getBatteryCapacity();
    int j = paramQQAppInterface.getPowerConnect();
    int k = getSendBatteryStatus(i, j);
    localBundle.putInt("BatteryInfo", k);
    localBundle.putBoolean("from_register", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "buildSetBatteryData batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k), " fromRegister:", Boolean.valueOf(paramBoolean) });
    }
    return localBundle;
  }
  
  public String a(long paramLong, AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online)
    {
      if (paramLong == 1000L) {
        return "我的电量";
      }
      akto localakto = a(AppRuntime.Status.online, paramLong);
      if ((localakto != null) && (!TextUtils.isEmpty(localakto.title))) {
        return localakto.title;
      }
    }
    return aktk.a(paramStatus);
  }
  
  public String a(QQAppInterface paramQQAppInterface, akto paramakto, AppRuntime.Status paramStatus, Friends paramFriends, TextView paramTextView, int paramInt)
  {
    if ((paramStatus == AppRuntime.Status.online) && (paramakto != null))
    {
      if ((paramakto.id == 1000L) && (paramFriends != null))
      {
        if (paramQQAppInterface.getCurrentAccountUin().equals(paramFriends.uin))
        {
          if (paramQQAppInterface.getPowerConnect() == 1) {
            return paramQQAppInterface.getBatteryCapacity() + "% " + b(paramFriends) + "充电中";
          }
          return paramQQAppInterface.getBatteryCapacity() + "% " + b(paramFriends) + "电量";
        }
        if (b(paramFriends) > 0)
        {
          if (paramFriends.isBatteryCharging()) {
            return b(paramFriends) + "% " + b(paramFriends) + "充电中";
          }
          return b(paramFriends) + "% " + b(paramFriends) + "电量";
        }
        return aqgv.d(paramFriends);
      }
      if ((paramakto.id == 1028L) && (paramFriends != null)) {
        return akum.a(paramQQAppInterface, paramFriends, paramTextView);
      }
      if ((paramakto.id == -1L) && (paramFriends != null)) {
        return aktp.a(paramQQAppInterface, paramTextView, paramFriends, paramInt);
      }
      if (!TextUtils.isEmpty(paramakto.title)) {
        return paramakto.title;
      }
    }
    return aktk.a(paramStatus);
  }
  
  public AppRuntime.Status a(akto paramakto)
  {
    if (paramakto != null) {
      return paramakto.f;
    }
    return null;
  }
  
  public void a(Activity paramActivity, Friends paramFriends)
  {
    akue localakue = new akue(paramFriends.latitude, paramFriends.longitude, paramFriends.poiName, paramFriends.poiFlag);
    localakue.mUpdateTime = paramFriends.poiUpdateTime;
    OnlineStatusLocationFragment.a(paramActivity, paramFriends.uin, paramFriends.getFriendNick(), localakue);
  }
  
  public void a(Friends paramFriends, TextView paramTextView, boolean paramBoolean)
  {
    paramTextView.setCompoundDrawablePadding(0);
    paramTextView.setCompoundDrawables(null, null, null, null);
  }
  
  public boolean a(akto paramakto)
  {
    return (paramakto != null) && (paramakto.id == 1000L);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, View paramView)
  {
    if (M(paramQQAppInterface, paramSessionInfo.aTl))
    {
      Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).e(paramSessionInfo.aTl);
      akto localakto = a(AppRuntime.Status.online, localFriends.uExtOnlineStatus);
      if (localakto.id == 1028L) {
        if ((localFriends != null) && (!TextUtils.isEmpty(localFriends.songId))) {
          a().J(paramActivity, localFriends.songId);
        }
      }
      while (localakto.id != -1L) {
        return true;
      }
      if (((paramView instanceof TextView)) && (!((TextView)paramView).getText().toString().contains("我在"))) {
        return false;
      }
      paramSessionInfo = paramSessionInfo.aTl;
      if (paramQQAppInterface.getCurrentUin().equals(paramSessionInfo)) {}
      for (int i = 2;; i = 1)
      {
        anot.a(null, "dc00898", "", "", "0X800AE79", "0X800AE79", i, 0, "", "", "", "");
        a(paramActivity, localFriends);
        break;
      }
    }
    return false;
  }
  
  public int b(Friends paramFriends)
  {
    if (paramFriends == null) {
      return Hc();
    }
    return Math.max(0, Math.min(paramFriends.getBatteryCapacity(), 100));
  }
  
  public Bundle b(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    int i = paramQQAppInterface.getBatteryCapacity();
    int j = paramQQAppInterface.getPowerConnect();
    int k = getSendBatteryStatus(i, j);
    localBundle.putInt("BatteryInfo", k);
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusHelper", 2, new Object[] { "OnlineStatusHelper batteryCapacity:", Integer.valueOf(i), " powerConnect:", Integer.valueOf(j), " sendBattery:", Integer.valueOf(k) });
    }
    return localBundle;
  }
  
  public ArrayList<akto> jdMethod_do()
  {
    aelg localaelg = (aelg)aeif.a().o(578);
    if (localaelg != null) {
      return localaelg.cS();
    }
    return null;
  }
  
  public long k(QQAppInterface paramQQAppInterface)
  {
    long l2 = paramQQAppInterface.getExtOnlineStatus();
    long l1 = l2;
    if (l2 == -1L)
    {
      l2 = BaseApplicationImpl.getContext().getSharedPreferences("acc_info" + paramQQAppInterface.getCurrentAccountUin(), 0).getLong("getOnlineStatusExt", -1L);
      l1 = l2;
      if (l2 != -1L)
      {
        paramQQAppInterface.setExtOnlineStatus(l2);
        l1 = l2;
      }
    }
    return l1;
  }
  
  static final class a
  {
    private static final akti a = new akti(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akti
 * JD-Core Version:    0.7.0.1
 */