package cooperation.troop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import ankq;
import anot;
import avfw;
import avfw.d;
import awjj;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import java.lang.reflect.Constructor;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class NearbyVideoChatProxyActivity
  extends TroopBaseProxyActivity
{
  protected static void a(Activity paramActivity, Intent paramIntent, Dialog paramDialog, String paramString1, AppInterface paramAppInterface, String paramString2, oidb_0x8dd.SelfInfo paramSelfInfo, int paramInt)
  {
    ankq.axX();
    Object localObject = SosoInterface.c();
    long l2 = 0L;
    long l1 = 0L;
    if (localObject != null)
    {
      l2 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.ce * 1000000.0D).longValue();
      l1 = Double.valueOf(((SosoInterface.SosoLbsInfo)localObject).a.cd * 1000000.0D).longValue();
    }
    localObject = new avfw.d(1);
    ((avfw.d)localObject).mPluginID = "nearby_video_chat_plugin.apk";
    ((avfw.d)localObject).mPluginName = PluginInfo.cKJ;
    ((avfw.d)localObject).mUin = paramAppInterface.getCurrentAccountUin();
    ((avfw.d)localObject).cKu = paramString1;
    ((avfw.d)localObject).K = NearbyVideoChatProxyActivity.class;
    paramString1 = paramIntent;
    if (paramIntent == null) {
      paramString1 = new Intent();
    }
    ((avfw.d)localObject).mIntent = paramString1;
    ((avfw.d)localObject).mDialog = paramDialog;
    ((avfw.d)localObject).mIntent.putExtra("userQqResources", 2);
    ((avfw.d)localObject).mIntent.putExtra("param_plugin_gesturelock", true);
    ((avfw.d)localObject).mIntent.putExtra("sessionType", 2);
    ((avfw.d)localObject).mIntent.putExtra("uinType", 10003);
    ((avfw.d)localObject).mIntent.putExtra("MultiAVType", 0);
    ((avfw.d)localObject).mIntent.putExtra("lon", l2);
    ((avfw.d)localObject).mIntent.putExtra("lat", l1);
    if (!TextUtils.isEmpty(paramString2)) {
      ((avfw.d)localObject).mIntent.putExtra("nearbyVideoConfig", paramString2);
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      paramIntent = (QQAppInterface)paramAppInterface;
      if ((paramIntent.bF()) && (paramIntent.a().sB()))
      {
        QLog.e("NearbyVideoChatProxyActivity", 2, "Fromwhere is SmallScreen");
        ((avfw.d)localObject).mIntent.putExtra("Fromwhere", "SmallScreen");
      }
    }
    paramIntent = ((avfw.d)localObject).mIntent;
    boolean bool;
    int i;
    int j;
    int k;
    if (paramSelfInfo != null)
    {
      bool = true;
      paramIntent.putExtra("hasSelfInfo", bool);
      if (paramSelfInfo == null) {
        break label549;
      }
      ((avfw.d)localObject).mIntent.putExtra("selfInfoLevel", paramSelfInfo.uint32_charm_level.get());
      ((avfw.d)localObject).mIntent.putExtra("selfInfoAge", paramSelfInfo.uint32_age.get());
      ((avfw.d)localObject).mIntent.putExtra("selfInfoGender", paramSelfInfo.uint32_gender.get() + 1);
      i = paramSelfInfo.uint32_charm_level.get();
      j = paramSelfInfo.uint32_gender.get();
      k = paramSelfInfo.uint32_age.get();
      j += 1;
    }
    for (;;)
    {
      ((avfw.d)localObject).mRequestCode = paramInt;
      ((avfw.d)localObject).mTimeOut = 10000;
      ((avfw.d)localObject).cKv = null;
      paramIntent = null;
      if (paramInt == 123987) {
        paramIntent = new awjj(paramActivity);
      }
      avfw.a(paramActivity, (avfw.d)localObject, paramIntent);
      anot.a(null, "dc00899", "grp_lbs", "", "video_chat", "num_entry", 0, 0, i + "", j + "", k + "", "");
      return;
      bool = false;
      break;
      label549:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent, String paramString, oidb_0x8dd.SelfInfo paramSelfInfo, int paramInt)
  {
    a(paramActivity, paramIntent, a(paramActivity), "com.tencent.mobileqq.nearbyvideochat.ui.AVActivity", paramAppInterface, paramString, paramSelfInfo, paramInt);
  }
  
  public static AppRuntime c(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoAppInterface", 2, "createAppInterface");
    }
    try
    {
      paramString = Class.forName("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "nearby_video_chat_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.mobileqq.nearbyvideochat.com.tencent.av.app.NearbyVideoAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label96;
      }
      QLog.d("NearbyVideoAppInterface", 2, "createAppInterface exp:", paramBaseApplicationImpl);
      label96:
      if (!QLog.isColorLevel()) {
        break label111;
      }
      QLog.d("NearbyVideoAppInterface", 2, "createAppInterface return null");
      label111:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyVideoAppInterface", 2, "createNearbyVideoAppInterface load class fail, return null");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  public String getPluginID()
  {
    return "nearby_video_chat_plugin.apk";
  }
  
  public Class<? extends PluginProxyActivity> getProxyActivity(String paramString)
  {
    return NearbyVideoChatProxyActivity.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.NearbyVideoChatProxyActivity
 * JD-Core Version:    0.7.0.1
 */