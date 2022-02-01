package com.tencent.mobileqq.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import hbb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QQSettingUtil
{
  public static int a = 0;
  public static final String a = "Setting_Quit";
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQi", 0).getInt("setting_quit_" + paramString, 0);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.a().getApplicationContext().getSharedPreferences(paramQQAppInterface.a(), 0).getInt("mywallet_flag", 1);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt)
  {
    if (paramResources == null) {
      return new SpannableString("");
    }
    int k = paramInt / 64;
    paramInt %= 64;
    int m = paramInt / 16;
    int i1 = paramInt % 16;
    int n = i1 / 4;
    String str1 = "";
    int i = 0;
    Object localObject;
    while (i < 4)
    {
      localObject = "";
      switch (i)
      {
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt)
        {
          str1 = str1 + (String)localObject;
          j += 1;
        }
        localObject = "!";
        paramInt = k;
        continue;
        localObject = "@";
        paramInt = m;
        continue;
        localObject = "#";
        paramInt = n;
        continue;
        localObject = "%";
        paramInt = i1 % 4;
      }
      i += 1;
    }
    if ((a > 1) && (str1.length() > a))
    {
      localObject = str1.substring(0, a - 1);
      str1 = (String)localObject + "$";
    }
    for (;;)
    {
      SpannableString localSpannableString = new SpannableString(str1);
      i = (int)paramResources.getDimension(2131427435);
      paramInt = 0;
      if (paramInt < str1.length())
      {
        String str2 = str1.substring(paramInt, paramInt + 1);
        if ("!".equalsIgnoreCase(str2))
        {
          localObject = paramResources.getDrawable(2130839043);
          label287:
          if (localObject != null)
          {
            if (!"&".equalsIgnoreCase(str2)) {
              break label436;
            }
            ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject), paramInt, paramInt + 1, 33);
          paramInt += 1;
          break;
          if ("@".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130839046);
            break label287;
          }
          if ("#".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130839044);
            break label287;
          }
          if ("%".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130839045);
            break label287;
          }
          if ("$".equalsIgnoreCase(str2))
          {
            localObject = paramResources.getDrawable(2130840364);
            break label287;
          }
          localObject = null;
          break label287;
          label436:
          ((Drawable)localObject).setBounds(0, 0, i, i);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("QQSettingRedesign", 4, "parseQQLevel, sLevel = " + str1 + ", span = " + localSpannableString);
      }
      return localSpannableString;
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong == 11L) {
      return BaseApplicationImpl.getContext().getString(2131559313);
    }
    if (paramLong == 41L) {
      return BaseApplicationImpl.getContext().getString(2131559314);
    }
    if (paramLong == 31L) {
      return BaseApplicationImpl.getContext().getString(2131559315);
    }
    return "";
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = false;
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundSettingActivity.f();
    if (paramBoolean) {
      localIntent.putExtra("tab_index", 0);
    }
    for (paramBoolean = bool;; paramBoolean = true)
    {
      paramQQAppInterface.logout(paramBoolean);
      if (BaseApplicationImpl.a != null) {
        BaseApplicationImpl.a.evictAll();
      }
      int i = a(paramActivity, paramQQAppInterface.a());
      a(paramActivity, paramQQAppInterface.a(), i + 1);
      paramActivity.startActivityForResult(localIntent, 1000);
      if (QQPlayerService.a())
      {
        paramQQAppInterface = new Intent();
        paramQQAppInterface.setAction("qqplayer_exit_action");
        paramActivity.sendBroadcast(paramQQAppInterface);
      }
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQi", 0).edit();
    paramContext.putInt("setting_quit_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static void a(ImageView paramImageView, long paramLong)
  {
    if (paramImageView == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQSetting", 2, "online status = " + paramLong);
      }
      if (paramLong == 11L)
      {
        paramImageView.setImageResource(2130840231);
        return;
      }
      if (paramLong == 41L)
      {
        paramImageView.setImageResource(2130840227);
        return;
      }
    } while (paramLong != 31L);
    paramImageView.setImageResource(2130840229);
  }
  
  public static void a(TextView paramTextView, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag != null) && (paramAppInfo.iNewFlag.get() != 0)) {}
    int j;
    int i;
    switch (paramAppInfo.type.get())
    {
    default: 
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if (i == 1)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130839215, 0, 0, 0);
        paramTextView.setVisibility(0);
        return;
        i = 2;
        j = 0;
        continue;
        j = 0;
        i = 1;
        continue;
        if (paramAppInfo.num != null) {}
        for (j = paramAppInfo.num.get();; j = 0)
        {
          if (j <= 0) {
            break label132;
          }
          i = 3;
          break;
        }
      }
      else
      {
        CustomWidgetUtil.a(paramTextView, i, j, 0);
        return;
        label132:
        i = 0;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a(new hbb(paramQQAppInterface));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = paramQQAppInterface.a();
    boolean bool = SettingCloneUtil.readValue((Context)localObject1, null, ((Context)localObject1).getString(2131563451), "qqsetting_auto_receive_pic_key", true);
    Object localObject2;
    if (bool)
    {
      i = 1;
      localHashMap.put("Clk_auto_receive_pic", Integer.valueOf(i));
      localObject2 = (StatusManager)paramQQAppInterface.getManager(13);
      if (localObject2 != null)
      {
        bool = ((StatusManager)localObject2).b();
        if (!bool) {
          break label678;
        }
        i = 1;
        label81:
        localHashMap.put("Clk_signature_qzone", Integer.valueOf(i));
        if (!ConfigHandler.a(paramQQAppInterface, false)) {
          break label683;
        }
        i = 1;
        label105:
        localHashMap.put("Download_new", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject1, null, ((Context)localObject1).getString(2131563455), "qqsetting_notify_icon_key", false)) {
          break label688;
        }
        i = 1;
        label142:
        localHashMap.put("System_icon", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject1, null, paramQQAppInterface.a().getString(2131563454), "qqsetting_enter_sendmsg_key", false)) {
          break label693;
        }
        i = 1;
        label181:
        localHashMap.put("Enter_sendmsg", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue((Context)localObject1, paramQQAppInterface.a(), "login_accounts", "qqsetting_bothonline_key", true)) {
          break label698;
        }
        i = 1;
        label216:
        localHashMap.put("Mobile_pc_online", Integer.valueOf(i));
        if (!paramQQAppInterface.p()) {
          break label703;
        }
        i = 1;
        label239:
        localHashMap.put("Visible_same", Integer.valueOf(i));
        if (!paramQQAppInterface.r()) {
          break label708;
        }
        i = 1;
        label262:
        localHashMap.put("Same_likeme", Integer.valueOf(i));
        if (!paramQQAppInterface.b(true)) {
          break label713;
        }
        i = 1;
        label286:
        localHashMap.put("Search_number", Integer.valueOf(i));
        if (!paramQQAppInterface.o()) {
          break label718;
        }
        i = 1;
        label309:
        localHashMap.put("Visible_nearby", Integer.valueOf(i));
        if (!paramQQAppInterface.q()) {
          break label723;
        }
        i = 1;
        label332:
        localHashMap.put("Nearby_likeme", Integer.valueOf(i));
        if (paramQQAppInterface.f() != 0) {
          break label728;
        }
        i = 0;
        label355:
        if (i == 0) {
          break label733;
        }
        i = 1;
        label361:
        localHashMap.put("Latest_chatlog_syn", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject1, paramQQAppInterface.a()) != 2) {
          break label738;
        }
        i = 1;
        label390:
        if (i == 0) {
          break label743;
        }
        i = 1;
        label396:
        localHashMap.put("Gesture_password", Integer.valueOf(i));
        if (!SettingCloneUtil.readValue(paramQQAppInterface.a(), null, "security_scan_key", "qqsetting_security_scan_key", false)) {
          break label748;
        }
        i = 1;
        label430:
        localHashMap.put("Security_check", Integer.valueOf(i));
        if (GesturePWDUtils.getGesturePWDState((Context)localObject1, paramQQAppInterface.a()) != 2) {
          break label753;
        }
        i = 1;
        label459:
        if (i == 0) {
          break label758;
        }
        i = 1;
        label465:
        localHashMap.put("Setting_Gesture_password", Integer.valueOf(i));
        if (!TroopAssistantManager.a().a()) {
          break label763;
        }
        i = 1;
        label490:
        localHashMap.put("Clk_hide_grp_heper", Integer.valueOf(i));
        if (!TroopAssistantManager.a().b()) {
          break label768;
        }
      }
    }
    label768:
    for (int i = 1;; i = 0)
    {
      for (;;)
      {
        localHashMap.put("Clk_grp_heper_top", Integer.valueOf(i));
        localObject1 = localHashMap.keySet();
        try
        {
          localObject1 = ((Set)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", (String)localObject2, 0, 0, String.valueOf(localHashMap.get(localObject2)), "", "", "");
          }
          if (SettingCloneUtil.readValue(paramQQAppInterface.a(), null, paramQQAppInterface.a().getString(2131563437), "qqsetting_screenshot_key", false)) {}
          for (i = 1;; i = 0)
          {
            ReportController.b(paramQQAppInterface, "CliStatus", "", "", "Setting_tab", "Shake_screenshot_switch", 0, 0, String.valueOf(i), "", "", "");
            return;
          }
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
      }
      i = 0;
      break;
      label678:
      i = 0;
      break label81;
      label683:
      i = 0;
      break label105;
      label688:
      i = 0;
      break label142;
      label693:
      i = 0;
      break label181;
      label698:
      i = 0;
      break label216;
      label703:
      i = 0;
      break label239;
      label708:
      i = 0;
      break label262;
      label713:
      i = 0;
      break label286;
      label718:
      i = 0;
      break label309;
      label723:
      i = 0;
      break label332;
      label728:
      i = 1;
      break label355;
      label733:
      i = 0;
      break label361;
      label738:
      i = 0;
      break label390;
      label743:
      i = 0;
      break label396;
      label748:
      i = 0;
      break label430;
      label753:
      i = 0;
      break label459;
      label758:
      i = 0;
      break label465;
      label763:
      i = 0;
      break label490;
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet").append('|').append(paramQQAppInterface.a()).append('|').append("").append('|').append("wallet").append('|').append("index").append('|').append(0).append('|').append(1).append('|').append(0).append('|').append("").append('|').append("").append('|').append("").append('|').append("").append('|');
      StatisticCollector.a(null).d(paramQQAppInterface, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil
 * JD-Core Version:    0.7.0.1
 */