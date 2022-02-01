package com.tencent.mobileqq.statistics;

import abhh;
import abkd;
import abxk;
import acff;
import acgx;
import achs;
import acle;
import ahav;
import aizh;
import ajdg;
import akxp;
import alla;
import alwd;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.opengl.ETC1Util;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import annw;
import anot;
import anpb;
import anpc;
import anpg;
import anpt;
import aqeu;
import aqgm;
import aqgz;
import aqiw;
import aqmj;
import aquy;
import aquz;
import aqva;
import aqvc;
import aqwu;
import aunq;
import auqv;
import auqw;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageReportData;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import ikh;
import irm;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import yhf;
import yuu;
import zjq;

public class DailyReport
  extends AsyncStep
{
  private static int dKo = 50000;
  QQAppInterface app;
  BaseApplicationImpl f;
  aquy t = new annw(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  public static Set<Integer> G()
  {
    List localList = ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).getSensorList(-1);
    HashSet localHashSet = new HashSet();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        Sensor localSensor = (Sensor)localList.get(i);
        if (localSensor != null) {
          localHashSet.add(Integer.valueOf(localSensor.getType()));
        }
        i += 1;
      }
    }
    return localHashSet;
  }
  
  private void QN(String paramString)
  {
    int i = anpb.g(this.f, paramString, "dl_op4dongtai");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Clk_data_wire_in", 8, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_op4buddylist");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Clk_data_wire_in", 21, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_op4recent");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Clk_data_wire_in", 22, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_ckpic");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Upload_pic", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_ckvideo");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Upload_video", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_ckfile");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Upload_file", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_cktxt");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Upload_text", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_cktkphoto");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Upload_photo", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_copy");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Long_press_copy", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_forward");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Long_press_retran", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_delete");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Long_press_delete", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_save2weiyun");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Long_press_weiyun", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_ckadv");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "data_wire_setting", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_ckviewrecvfile");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Chkfiles_data_wire", 0, i, 0);
    }
    i = anpb.g(this.f, paramString, "dl_ckclearmsg");
    if (i > 0) {
      anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Clean_data_wire", 0, i, 0);
    }
    boolean bool = this.app.getPreferences().getBoolean("auto_receive_files", false);
    anpc localanpc = anpc.a(this.f);
    HashMap localHashMap = new HashMap();
    localHashMap.clear();
    if (bool) {}
    for (i = 1;; i = 0)
    {
      localHashMap.put("auto_receive_files", Integer.valueOf(i));
      localanpc.b(this.app, paramString, localHashMap);
      i = anpb.g(this.f, paramString, "dl_forwardin_text");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Retran_text", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "dl_forwardin_image");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Retran_pic", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "dl_forwardin_file");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Retran_file", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "dl_forwardin_link");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Retran_link", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "dl_open_via_qq");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "Open_via_qq", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "dl_share_my_pc");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "share_my_PC", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "dl_share_frd");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "data_wire", "share_frd", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "Clk_disconnect_wp");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "Wifiphoto", "Clk_disconnect_wp", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "Clk_wp_back");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "Wifiphoto", "Clk_wp_back", 0, i, 0);
      }
      i = anpb.g(this.f, paramString, "Open_wp");
      if (i > 0) {
        anpc.a(this.f).a(this.app, paramString, paramString, "Wifiphoto", "Open_wp", 0, i, 0);
      }
      return;
    }
  }
  
  private static void QO(String paramString)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext());
    if (((SharedPreferences)localObject).getBoolean("hasReportDeviceProfile", false)) {
      return;
    }
    ((SharedPreferences)localObject).edit().putBoolean("hasReportDeviceProfile", true);
    localObject = new HashMap();
    int i = (int)Math.min(aqgz.hL(), aqgz.hK());
    int j = aqgz.getCpuNumber() * 100 + dKo;
    if (i <= 240) {
      i = j + 1;
    }
    for (;;)
    {
      ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
      anpc.a(BaseApplication.getContext()).collectPerformance(paramString, "reportDeviceProfile", false, 0L, 0L, (HashMap)localObject, "");
      return;
      if (i <= 320) {
        i = j + 2;
      } else if (i <= 480) {
        i = j + 3;
      } else if (i <= 640) {
        i = j + 4;
      } else if (i <= 720) {
        i = j + 5;
      } else if (i <= 1080) {
        i = j + 6;
      } else {
        i = j + 7;
      }
    }
  }
  
  private void a(anpc paramanpc)
  {
    HashMap localHashMap = new HashMap();
    int i = 89050;
    if (SkinEngine.IS_PROBLEM_MIUI)
    {
      localHashMap.put("param_FailCode", Integer.toString(i));
      if ((!BaseApplicationImpl.IS_SUPPORT_THEME) || (SkinEngine.IS_PROBLEM_MIUI)) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "report_skin_engine_enable", bool, 0L, 0L, localHashMap, "");
      return;
      i = 89051;
      break;
    }
  }
  
  private static String aQ(Context paramContext)
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = (InputMethodManager)paramContext.getSystemService("input_method");
    try
    {
      localObject = ((InputMethodManager)localObject).getInputMethodList();
      int i;
      if (localObject == null) {
        i = 0;
      }
      while (j < i)
      {
        localStringBuffer.append(((InputMethodInfo)((List)localObject).get(j)).loadLabel(paramContext.getPackageManager()));
        localStringBuffer.append(';');
        j += 1;
        continue;
        i = ((List)localObject).size();
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
      paramContext = localStringBuffer.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private void b(anpc paramanpc)
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.sApplication.getSystemService("activity");
    HashMap localHashMap = new HashMap();
    int i = localActivityManager.getMemoryClass();
    localHashMap.put("param_FailCode", Integer.toString(89000 + i));
    paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "report_mem_cache_size", false, i, 0L, localHashMap, "");
  }
  
  private void c(anpc paramanpc)
  {
    if (paramanpc == null) {
      return;
    }
    for (;;)
    {
      try
      {
        boolean bool = ETC1Util.isETC1Supported();
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_manufacture", Build.MANUFACTURER);
        localHashMap.put("param_model", Build.MODEL);
        if (bool)
        {
          String str1 = String.valueOf(1);
          localHashMap.put("param_etc1supported", str1);
          paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "arOpenGLSupport", bool, 0L, 0L, localHashMap, "");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportOpenglSupport", localThrowable);
        }
        paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "arOpenGLSupport", false, 0L, 0L, null, "");
        return;
      }
      String str2 = String.valueOf(0);
    }
  }
  
  private void dSc()
  {
    int j;
    label24:
    int k;
    label45:
    int m;
    label58:
    Object localObject;
    int n;
    if (this.app.AI() != 0)
    {
      i = 1;
      if (this.app.AJ() == 0) {
        break label739;
      }
      j = 1;
      boolean bool1 = this.app.abm();
      if (this.app.AG() != 0) {
        break label744;
      }
      k = 0;
      if (this.app.AH() != 0) {
        break label749;
      }
      m = 0;
      boolean bool2 = SettingCloneUtil.readValue(this.app.getApp(), this.app.getCurrentUin(), null, "new_msg_notification_key", true);
      boolean bool3 = QQNotificationManager.getInstance().groupChannelVibrateOn();
      boolean bool4 = QQNotificationManager.getInstance().c2cChannelVibrateOn();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, new Object[] { "reportMessageNotificationSettings: invoked. ", " groupChannelVibrateOn: ", Boolean.valueOf(bool3), " c2cChannelVibrateOn: ", Boolean.valueOf(bool4) });
      }
      localObject = this.app;
      if (j == 0) {
        break label755;
      }
      n = 1;
      label162:
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800AD3B", "0X800AD3B", n, 0, "", "", "", "");
      localObject = this.app;
      if (m == 0) {
        break label761;
      }
      n = 1;
      label211:
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X800AD3C", "0X800AD3C", n, 0, "", "", "", "");
      QQAppInterface localQQAppInterface = this.app;
      if (i == 0) {
        break label767;
      }
      localObject = "1";
      label261:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A3CF", "0X800A3CF", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (j == 0) {
        break label775;
      }
      localObject = "1";
      label309:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A3D0", "0X800A3D0", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (!bool1) {
        break label783;
      }
      localObject = "1";
      label358:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A3CE", "0X800A3CE", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (m == 0) {
        break label791;
      }
      localObject = "1";
      label407:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A3D1", "0X800A3D1", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (k == 0) {
        break label799;
      }
      localObject = "1";
      label455:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A3D2", "0X800A3D2", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (!bool2) {
        break label807;
      }
      localObject = "1";
      label504:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A512", "0X800A512", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (!auqv.bI(true)) {
        break label815;
      }
      localObject = "1";
      label555:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A6E8", "0X800A6E8", 0, 0, (String)localObject, "", "", "");
      localQQAppInterface = this.app;
      if (!auqv.bI(false)) {
        break label823;
      }
      localObject = "1";
      label606:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A6E9", "0X800A6E9", 0, 0, (String)localObject, "", "", "");
      localObject = this.app;
      if (!bool3) {
        break label831;
      }
      i = 1;
      label652:
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X800AC8B", "0X800AC8B", i, 0, "", "", "", "");
      localObject = this.app;
      if (!bool4) {
        break label836;
      }
    }
    label775:
    label783:
    label791:
    label799:
    label807:
    label815:
    label823:
    label831:
    label836:
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X800AC8C", "0X800AC8C", i, 0, "", "", "", "");
      return;
      i = 0;
      break;
      label739:
      j = 0;
      break label24;
      label744:
      k = 1;
      break label45;
      label749:
      m = 1;
      break label58;
      label755:
      n = 2;
      break label162;
      label761:
      n = 2;
      break label211;
      label767:
      localObject = "2";
      break label261;
      localObject = "2";
      break label309;
      localObject = "2";
      break label358;
      localObject = "2";
      break label407;
      localObject = "2";
      break label455;
      localObject = "2";
      break label504;
      localObject = "2";
      break label555;
      localObject = "2";
      break label606;
      i = 2;
      break label652;
    }
  }
  
  private void dSd()
  {
    Object localObject = yhf.a(this.app);
    QQAppInterface localQQAppInterface;
    if (localObject != null)
    {
      boolean bool = ((yhf)localObject).TC();
      localQQAppInterface = this.app;
      if (!bool) {
        break label62;
      }
    }
    label62:
    for (localObject = "1";; localObject = "2")
    {
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800A224", "0X800A224", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void dSe()
  {
    HashMap localHashMap = new HashMap();
    int i = anpg.D(this.f, this.app.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("Click_grp_asst", Integer.valueOf(i));
    }
    i = anpg.E(this.f, this.app.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_setting_asst", Integer.valueOf(i));
    }
    i = anpg.F(this.f, this.app.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_setting_msg", Integer.valueOf(i));
    }
    i = anpg.G(this.f, this.app.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_equ", Integer.valueOf(i));
    }
    i = anpg.H(this.f, this.app.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_dec", Integer.valueOf(i));
    }
    i = anpg.I(this.f, this.app.getCurrentAccountUin());
    if (i > 0) {
      localHashMap.put("grp_msg_inc", Integer.valueOf(i));
    }
    anpc.a(BaseApplication.getContext()).a(this.app, this.app.getCurrentAccountUin(), localHashMap);
  }
  
  private void dSf()
  {
    String str = this.app.getCurrentAccountUin();
    anpc localanpc = anpc.a(this.f);
    int i = anpb.g(this.f, str, "ep_tab");
    if (i > 0) {
      localanpc.a(this.app, str, "", "ep_mall", "ep_tab", 1, i, 0);
    }
    i = anpb.g(this.f, str, "ep_mall_in2");
    if (i > 0) {
      localanpc.a(this.app, str, "", "ep_mall", "ep_mall_in", 2, i, 0);
    }
    Object localObject = (ajdg)this.app.getManager(14);
    if (localObject != null)
    {
      localObject = ((ajdg)localObject).fz();
      if (localObject == null) {}
    }
    for (i = ((List)localObject).size();; i = 0)
    {
      localObject = new HashMap();
      ((Map)localObject).put("Ep_amount", Integer.valueOf(i));
      localanpc.b(this.app, str, (Map)localObject);
      i = 0;
      while (i < 3)
      {
        int j = anpb.g(this.f, str, "ep_tab2" + i);
        localanpc.a(this.app, str, "", "ep_mall", "ep_tab2", 0, j, 0, i);
        i += 1;
      }
      i = anpb.g(this.f, str, "Ep_manage");
      if (i > 0) {
        localanpc.a(this.app, str, "", "ep_mall", "Ep_manage", 0, i, 0);
      }
      i = anpb.g(this.f, str, "Clk_ep_edit");
      if (i > 0) {
        localanpc.a(this.app, str, "", "ep_mall", "Clk_ep_edit", 0, i, 0);
      }
      i = anpb.g(this.f, str, "Delete_ep");
      if (i > 0) {
        localanpc.a(this.app, str, "", "ep_mall", "Delete_ep", 0, i, 0);
      }
      i = anpb.g(this.f, str, "Ep_order");
      if (i > 0) {
        localanpc.a(this.app, str, "", "ep_mall", "Ep_order", 0, i, 0);
      }
      return;
    }
  }
  
  private void dSg()
  {
    Object localObject1 = this.app.getCurrentAccountUin();
    Object localObject2 = (acff)this.app.getManager(51);
    if (localObject2 != null)
    {
      localObject1 = ((acff)localObject2).a((String)localObject1);
      if ((localObject1 != null) && (((ExtensionInfo)localObject1).isPendantValid())) {}
    }
    else
    {
      return;
    }
    File localFile = new File(aqgm.m(((ExtensionInfo)localObject1).pendantId, 4));
    if (!localFile.exists())
    {
      localObject2 = (aqva)this.app.getManager(47);
      String str = aqgm.n(((ExtensionInfo)localObject1).pendantId, 4);
      Bundle localBundle = new Bundle();
      localBundle.putLong("id", ((ExtensionInfo)localObject1).pendantId);
      localObject1 = new aquz(str, localFile);
      ((aqva)localObject2).a(1).a((aquz)localObject1, this.t, localBundle);
      return;
    }
    localObject2 = aqgm.x(localFile);
    VasWebviewUtil.reportVasStatus("AvatarPendant", "AvatarPendantOn", String.valueOf(((ExtensionInfo)localObject1).pendantId), 0, 0, 0, 0, (String)localObject2, "");
  }
  
  private void dSh()
  {
    List localList = ((ajdg)this.app.getManager(14)).fz();
    String str = "";
    Object localObject = str;
    int i;
    if (localList != null)
    {
      i = 0;
      localObject = str;
      if (i < localList.size())
      {
        localObject = (EmoticonPackage)localList.get(i);
        if ((3 != ((EmoticonPackage)localObject).jobType) && (5 != ((EmoticonPackage)localObject).jobType)) {
          break label145;
        }
        if (str.equals("")) {
          str = ((EmoticonPackage)localObject).epId;
        }
      }
    }
    label145:
    for (;;)
    {
      i += 1;
      break;
      str = str + "|" + ((EmoticonPackage)localObject).epId;
      continue;
      VasWebviewUtil.reportVasStatus("MbBaoyou", "MbBaoyouID", "0", 0, 0, 0, 0, (String)localObject, "");
      return;
    }
  }
  
  private void dSi()
  {
    String str3 = ((ChatBackgroundManager)this.app.getManager(63)).lR(null);
    String str2;
    String str1;
    if (str3.equals("custom"))
    {
      str2 = "0X8004E10";
      str1 = "0X8004E10";
    }
    for (;;)
    {
      VasWebviewUtil.reportVasStatus(str2, str1, str3, 0, 0);
      return;
      str1 = "0X8004E0F";
      str2 = "0X8004E0F";
    }
  }
  
  private void dSj()
  {
    VasWebviewUtil.reportVasStatus("0X800498F", "0X800498F", ThemeUtil.getUserCurrentThemeId(this.app), ((acle)this.app.getBusinessHandler(13)).AX(), 0);
  }
  
  private void dSk()
  {
    acle localacle = (acle)this.app.getBusinessHandler(13);
    VasWebviewUtil.reportVasStatus("0X8004990", "0X8004990", String.valueOf(localacle.AS()), localacle.AX(), 0);
  }
  
  private void dSl()
  {
    boolean bool1 = DeviceProfileManager.a().isFeatureSupported(DeviceProfileManager.DpcNames.chat_font.name());
    boolean bool2 = this.app.getApp().getSharedPreferences("font_open_switch", 0).getBoolean("isUserOpenFontSwitch_" + this.app.getAccount(), false);
    int i;
    if (bool1) {
      i = 2;
    }
    for (;;)
    {
      VasWebviewUtil.reportVasStatus("font_switch", "switch_on", "0", 0, 0, i, 0, "", "");
      return;
      if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private void dSm()
  {
    Object localObject1 = (abhh)this.app.getManager(153);
    if (localObject1 != null)
    {
      localObject1 = ((abhh)localObject1).b(this.app.getCurrentUin());
      int i;
      Object localObject2;
      int j;
      if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 1))
      {
        Object localObject3 = ((ApolloBaseInfo)localObject1).getApolloDress();
        i = 0;
        localObject2 = new StringBuilder();
        if (localObject3 != null)
        {
          int k = ((abkd)localObject3).roleId;
          localObject3 = ((abkd)localObject3).M();
          int m = localObject3.length;
          j = 0;
          for (;;)
          {
            i = k;
            if (j >= m) {
              break;
            }
            ((StringBuilder)localObject2).append(localObject3[j]).append("|");
            j += 1;
          }
        }
        j = abhh.x(this.app);
        anot.a(this.app, "CliStatus", "", "", "ApolloStatus", "dress", 0, 0, i + "", ((ApolloBaseInfo)localObject1).apolloVipFlag + "", ((StringBuilder)localObject2).toString(), String.valueOf(j + 1));
      }
      for (;;)
      {
        if ((abhh.a(this.app) == 1) && (localObject1 != null)) {
          anot.a(this.app, "CliStatus", "", "", "ApolloStatus", "white", 0, 0, ((ApolloBaseInfo)localObject1).apolloStatus + "", "0", "", "");
        }
        localObject1 = (abxk)this.app.getManager(155);
        if (localObject1 == null) {
          break;
        }
        localObject2 = ((abxk)localObject1).dL();
        if (localObject2 != null) {
          anot.a(this.app, "CliStatus", "", "", "ApolloStatus", "action_added", ((List)localObject2).size(), 0, "0", "0", "", "");
        }
        if ((((abxk)localObject1).dE == null) || (((abxk)localObject1).dE.isEmpty())) {
          break;
        }
        localObject1 = ((abxk)localObject1).dE.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          try
          {
            i = (int)Float.parseFloat((String)((Map.Entry)localObject2).getValue());
            j = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
            anot.a(this.app, "CliStatus", "", "", "ApolloStatus", "game_downloaded", 0, 0, String.valueOf(j), String.valueOf(i), "", "");
          }
          catch (Exception localException) {}
        }
        if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloStatus == 2)) {
          anot.a(this.app, "CliStatus", "", "", "ApolloStatus", "close", 0, 0, "0", "0", "", "");
        }
      }
    }
  }
  
  private void dSn()
  {
    Object localObject = (yuu)this.app.getManager(102);
    QQAppInterface localQQAppInterface;
    if (((yuu)localObject).bpe)
    {
      localQQAppInterface = this.app;
      if (!((yuu)localObject).UA()) {
        break label68;
      }
    }
    label68:
    for (localObject = "1";; localObject = "0")
    {
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X8005B8B", "0X8005B8B", 0, 0, (String)localObject, "", "", "");
      return;
    }
  }
  
  private void dSo()
  {
    EntityManager localEntityManager = this.app.a().createEntityManager();
    QQAppInterface localQQAppInterface;
    if (localEntityManager != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.app.getCurrentAccountUin() });
      if (localNearbyPeopleCard != null)
      {
        localQQAppInterface = this.app;
        if (!localNearbyPeopleCard.switchHobby) {
          break label150;
        }
        str = "1";
        anot.a(localQQAppInterface, "CliStatus", "", "", "0X8004A12", "0X8004A12", 0, 0, str, "", "", "");
        localQQAppInterface = this.app;
        if (!localNearbyPeopleCard.switchQzone) {
          break label157;
        }
      }
    }
    label150:
    label157:
    for (String str = "1";; str = "0")
    {
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X8004A13", "0X8004A13", 0, 0, str, "", "", "");
      localEntityManager.close();
      return;
      str = "0";
      break;
    }
  }
  
  /* Error */
  private void dSr()
  {
    // Byte code:
    //   0: new 578	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   7: invokestatic 907	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   10: invokevirtual 910	java/io/File:getPath	()Ljava/lang/String;
    //   13: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc_w 912
    //   19: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 588	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 15
    //   27: new 612	java/io/File
    //   30: dup
    //   31: aload 15
    //   33: invokespecial 624	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 14
    //   38: aconst_null
    //   39: astore 13
    //   41: iconst_0
    //   42: istore 5
    //   44: iconst_0
    //   45: istore 4
    //   47: aload 14
    //   49: invokevirtual 627	java/io/File:exists	()Z
    //   52: ifne +4 -> 56
    //   55: return
    //   56: invokestatic 737	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   59: getstatic 915	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:batteryCfg	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   62: invokevirtual 746	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   65: invokevirtual 918	com/tencent/mobileqq/app/DeviceProfileManager:jf	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 12
    //   70: aload 12
    //   72: invokestatic 923	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   75: ifne +165 -> 240
    //   78: aload 12
    //   80: ldc_w 925
    //   83: invokevirtual 928	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   86: ifeq +154 -> 240
    //   89: aload 12
    //   91: aload 12
    //   93: ldc_w 925
    //   96: invokevirtual 932	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   99: iconst_1
    //   100: iadd
    //   101: aload 12
    //   103: invokevirtual 933	java/lang/String:length	()I
    //   106: invokevirtual 937	java/lang/String:substring	(II)Ljava/lang/String;
    //   109: astore 12
    //   111: aload 12
    //   113: ldc_w 939
    //   116: invokevirtual 943	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   119: iconst_1
    //   120: aaload
    //   121: invokestatic 847	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   124: fstore_1
    //   125: iload 5
    //   127: istore_3
    //   128: invokestatic 947	java/lang/Math:random	()D
    //   131: fload_1
    //   132: f2d
    //   133: dcmpg
    //   134: ifgt +646 -> 780
    //   137: iload 5
    //   139: istore_3
    //   140: aload 14
    //   142: invokevirtual 951	java/io/File:listFiles	()[Ljava/io/File;
    //   145: astore 12
    //   147: iload 5
    //   149: istore_3
    //   150: new 953	java/util/ArrayList
    //   153: dup
    //   154: invokespecial 954	java/util/ArrayList:<init>	()V
    //   157: astore 16
    //   159: aload 12
    //   161: ifnull +112 -> 273
    //   164: iload 5
    //   166: istore_3
    //   167: aload 12
    //   169: arraylength
    //   170: ifle +103 -> 273
    //   173: iload 5
    //   175: istore_3
    //   176: aload 12
    //   178: arraylength
    //   179: istore 6
    //   181: iconst_0
    //   182: istore_2
    //   183: iload_2
    //   184: iload 6
    //   186: if_icmpge +87 -> 273
    //   189: iload 5
    //   191: istore_3
    //   192: aload 12
    //   194: iload_2
    //   195: aaload
    //   196: invokevirtual 957	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   199: astore 17
    //   201: aload 17
    //   203: ifnull +30 -> 233
    //   206: iload 5
    //   208: istore_3
    //   209: aload 17
    //   211: ldc_w 959
    //   214: invokevirtual 962	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   217: ifeq +16 -> 233
    //   220: iload 5
    //   222: istore_3
    //   223: aload 16
    //   225: aload 17
    //   227: invokeinterface 963 2 0
    //   232: pop
    //   233: iload_2
    //   234: iconst_1
    //   235: iadd
    //   236: istore_2
    //   237: goto -54 -> 183
    //   240: ldc_w 965
    //   243: astore 12
    //   245: goto -134 -> 111
    //   248: astore 12
    //   250: invokestatic 395	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +13 -> 266
    //   256: ldc_w 397
    //   259: iconst_2
    //   260: ldc_w 967
    //   263: invokestatic 970	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: ldc_w 971
    //   269: fstore_1
    //   270: goto -145 -> 125
    //   273: aload 13
    //   275: astore 12
    //   277: iload 4
    //   279: istore_2
    //   280: iload 5
    //   282: istore_3
    //   283: aload 16
    //   285: invokeinterface 63 1 0
    //   290: ifle +106 -> 396
    //   293: iload 5
    //   295: istore_3
    //   296: aload 16
    //   298: invokeinterface 63 1 0
    //   303: iconst_5
    //   304: if_icmpge +409 -> 713
    //   307: iload 5
    //   309: istore_3
    //   310: new 578	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   317: aload 15
    //   319: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 973
    //   325: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokestatic 978	java/lang/System:currentTimeMillis	()J
    //   331: invokevirtual 981	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   334: ldc_w 983
    //   337: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 588	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore 12
    //   345: iload 5
    //   347: istore_3
    //   348: aload 16
    //   350: aload 12
    //   352: invokestatic 989	aqhq:zipFiles	(Ljava/util/List;Ljava/lang/String;)Z
    //   355: ifeq +249 -> 604
    //   358: iload 5
    //   360: istore_3
    //   361: new 612	java/io/File
    //   364: dup
    //   365: aload 12
    //   367: invokespecial 624	java/io/File:<init>	(Ljava/lang/String;)V
    //   370: astore 12
    //   372: iload 5
    //   374: istore_3
    //   375: aload 12
    //   377: invokevirtual 627	java/io/File:exists	()Z
    //   380: istore 7
    //   382: iload 4
    //   384: istore_2
    //   385: iload 7
    //   387: ifne +9 -> 396
    //   390: aconst_null
    //   391: astore 12
    //   393: iload 4
    //   395: istore_2
    //   396: aload 12
    //   398: ifnull +379 -> 777
    //   401: new 991	org/json/JSONObject
    //   404: dup
    //   405: invokespecial 992	org/json/JSONObject:<init>	()V
    //   408: astore 13
    //   410: new 991	org/json/JSONObject
    //   413: dup
    //   414: invokespecial 992	org/json/JSONObject:<init>	()V
    //   417: astore 15
    //   419: aload 15
    //   421: ldc_w 994
    //   424: aload 12
    //   426: invokevirtual 957	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   429: invokevirtual 997	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   432: pop
    //   433: new 991	org/json/JSONObject
    //   436: dup
    //   437: invokespecial 992	org/json/JSONObject:<init>	()V
    //   440: astore 12
    //   442: aload 12
    //   444: ldc_w 999
    //   447: invokestatic 1004	com/tencent/mfsdk/MagnifierSDK:getProductId	()Ljava/lang/String;
    //   450: invokevirtual 997	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   453: pop
    //   454: aload 12
    //   456: ldc_w 1006
    //   459: bipush 17
    //   461: invokestatic 273	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   464: invokevirtual 997	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   467: pop
    //   468: aload 13
    //   470: ldc_w 1008
    //   473: aload 15
    //   475: invokevirtual 997	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   478: pop
    //   479: aload 13
    //   481: ldc_w 1010
    //   484: aload 12
    //   486: invokevirtual 997	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   489: pop
    //   490: aload 13
    //   492: ldc_w 1012
    //   495: bipush 104
    //   497: invokevirtual 1015	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   500: pop
    //   501: lconst_0
    //   502: lstore 10
    //   504: aload_0
    //   505: getfield 106	com/tencent/mobileqq/statistics/DailyReport:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   508: invokevirtual 425	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   511: invokestatic 1021	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   514: lstore 8
    //   516: new 1023	com/tencent/mfsdk/collector/ResultObject
    //   519: dup
    //   520: iconst_0
    //   521: ldc_w 1025
    //   524: iconst_1
    //   525: lconst_1
    //   526: lconst_1
    //   527: aload 13
    //   529: iconst_1
    //   530: iconst_1
    //   531: lload 8
    //   533: invokespecial 1028	com/tencent/mfsdk/collector/ResultObject:<init>	(ILjava/lang/String;ZJJLorg/json/JSONObject;ZZJ)V
    //   536: invokestatic 1033	com/tencent/mfsdk/reporter/ReporterMachine:b	(Lcom/tencent/mfsdk/collector/ResultObject;)V
    //   539: iconst_1
    //   540: istore_2
    //   541: iload_2
    //   542: istore_3
    //   543: iload_2
    //   544: ifle +125 -> 669
    //   547: aload 14
    //   549: invokevirtual 951	java/io/File:listFiles	()[Ljava/io/File;
    //   552: astore 12
    //   554: iload_2
    //   555: istore_3
    //   556: aload 12
    //   558: ifnull +111 -> 669
    //   561: iload_2
    //   562: istore_3
    //   563: aload 12
    //   565: arraylength
    //   566: ifle +103 -> 669
    //   569: aload 12
    //   571: arraylength
    //   572: istore 5
    //   574: iconst_0
    //   575: istore 4
    //   577: iload_2
    //   578: istore_3
    //   579: iload 4
    //   581: iload 5
    //   583: if_icmpge +86 -> 669
    //   586: aload 12
    //   588: iload 4
    //   590: aaload
    //   591: invokevirtual 1036	java/io/File:delete	()Z
    //   594: pop
    //   595: iload 4
    //   597: iconst_1
    //   598: iadd
    //   599: istore 4
    //   601: goto -24 -> 577
    //   604: aload 13
    //   606: astore 12
    //   608: iload 4
    //   610: istore_2
    //   611: iload 5
    //   613: istore_3
    //   614: invokestatic 395	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq -221 -> 396
    //   620: iload 5
    //   622: istore_3
    //   623: ldc_w 397
    //   626: iconst_2
    //   627: ldc_w 1038
    //   630: invokestatic 970	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload 13
    //   635: astore 12
    //   637: iload 4
    //   639: istore_2
    //   640: goto -244 -> 396
    //   643: astore 12
    //   645: iload_3
    //   646: istore_2
    //   647: iload_2
    //   648: istore_3
    //   649: invokestatic 395	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq +17 -> 669
    //   655: ldc_w 397
    //   658: iconst_2
    //   659: ldc_w 1040
    //   662: aload 12
    //   664: invokestatic 403	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   667: iload_2
    //   668: istore_3
    //   669: invokestatic 395	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   672: ifeq -617 -> 55
    //   675: ldc_w 397
    //   678: iconst_2
    //   679: new 578	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 1042
    //   689: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: iload_3
    //   693: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: ldc_w 1044
    //   699: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: fload_1
    //   703: invokevirtual 1047	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   706: invokevirtual 588	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 970	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: return
    //   713: iconst_3
    //   714: istore_2
    //   715: aload 13
    //   717: astore 12
    //   719: goto -323 -> 396
    //   722: astore 12
    //   724: lload 10
    //   726: lstore 8
    //   728: invokestatic 395	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq -215 -> 516
    //   734: ldc_w 397
    //   737: iconst_2
    //   738: ldc_w 1049
    //   741: aload 12
    //   743: invokestatic 403	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   746: lload 10
    //   748: lstore 8
    //   750: goto -234 -> 516
    //   753: astore 12
    //   755: iload_2
    //   756: istore_3
    //   757: invokestatic 395	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   760: ifeq +17 -> 777
    //   763: iload_2
    //   764: istore_3
    //   765: ldc_w 397
    //   768: iconst_2
    //   769: ldc_w 1051
    //   772: aload 12
    //   774: invokestatic 403	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   777: goto -236 -> 541
    //   780: iconst_2
    //   781: istore_2
    //   782: goto -241 -> 541
    //   785: astore 12
    //   787: goto -140 -> 647
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	this	DailyReport
    //   124	579	1	f1	float
    //   182	600	2	i	int
    //   127	638	3	j	int
    //   45	593	4	k	int
    //   42	579	5	m	int
    //   179	8	6	n	int
    //   380	6	7	bool	boolean
    //   514	235	8	l1	long
    //   502	245	10	l2	long
    //   68	176	12	localObject1	Object
    //   248	1	12	localException1	Exception
    //   275	361	12	localObject2	Object
    //   643	20	12	localException2	Exception
    //   717	1	12	localJSONObject1	org.json.JSONObject
    //   722	20	12	localException3	Exception
    //   753	20	12	localException4	Exception
    //   785	1	12	localException5	Exception
    //   39	677	13	localJSONObject2	org.json.JSONObject
    //   36	512	14	localFile	File
    //   25	449	15	localObject3	Object
    //   157	192	16	localArrayList	ArrayList
    //   199	27	17	str	String
    // Exception table:
    //   from	to	target	type
    //   56	111	248	java/lang/Exception
    //   111	125	248	java/lang/Exception
    //   128	137	643	java/lang/Exception
    //   140	147	643	java/lang/Exception
    //   150	159	643	java/lang/Exception
    //   167	173	643	java/lang/Exception
    //   176	181	643	java/lang/Exception
    //   192	201	643	java/lang/Exception
    //   209	220	643	java/lang/Exception
    //   223	233	643	java/lang/Exception
    //   283	293	643	java/lang/Exception
    //   296	307	643	java/lang/Exception
    //   310	345	643	java/lang/Exception
    //   348	358	643	java/lang/Exception
    //   361	372	643	java/lang/Exception
    //   375	382	643	java/lang/Exception
    //   614	620	643	java/lang/Exception
    //   623	633	643	java/lang/Exception
    //   757	763	643	java/lang/Exception
    //   765	777	643	java/lang/Exception
    //   504	516	722	java/lang/Exception
    //   401	501	753	java/lang/Exception
    //   516	539	753	java/lang/Exception
    //   728	746	753	java/lang/Exception
    //   547	554	785	java/lang/Exception
    //   563	574	785	java/lang/Exception
    //   586	595	785	java/lang/Exception
  }
  
  private void dSs()
  {
    Map localMap = ((aizh)this.app.getManager(303)).aq();
    QQAppInterface localQQAppInterface = this.app;
    if (((Boolean)localMap.get("temp_msg_setting_troop_")).booleanValue())
    {
      str = "1";
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 1, 1, str, "", "", "");
      localQQAppInterface = this.app;
      if (!((Boolean)localMap.get("temp_msg_setting_nearby_")).booleanValue()) {
        break label375;
      }
      str = "1";
      label102:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 2, 2, str, "", "", "");
      localQQAppInterface = this.app;
      if (!((Boolean)localMap.get("temp_msg_setting_interest_v2")).booleanValue()) {
        break label382;
      }
      str = "1";
      label160:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 3, 3, str, "", "", "");
      localQQAppInterface = this.app;
      if (!((Boolean)localMap.get("temp_msg_setting_contact_")).booleanValue()) {
        break label389;
      }
      str = "1";
      label218:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 4, 4, str, "", "", "");
      localQQAppInterface = this.app;
      if (!((Boolean)localMap.get("temp_msg_setting_consult_")).booleanValue()) {
        break label396;
      }
      str = "1";
      label276:
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 5, 5, str, "", "", "");
      localQQAppInterface = this.app;
      if (!((Boolean)localMap.get("temp_msg_setting_circle_v2")).booleanValue()) {
        break label403;
      }
    }
    label389:
    label396:
    label403:
    for (String str = "1";; str = "0")
    {
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X800997C", "0X800997C", 6, 6, str, "", "", "");
      return;
      str = "0";
      break;
      label375:
      str = "0";
      break label102;
      label382:
      str = "0";
      break label160;
      str = "0";
      break label218;
      str = "0";
      break label276;
    }
  }
  
  private void dSt()
  {
    Object localObject1 = aunq.a().es();
    Object localObject2 = aunq.a().q(this.app);
    long l;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)((Iterator)localObject2).next();
        boolean bool = localAppSetting.setting.get();
        l = localAppSetting.appid.get();
        if ((!bool) && (((ArrayList)localObject1).contains(Long.valueOf(l))))
        {
          ((ArrayList)localObject1).remove(Long.valueOf(l));
          if (QLog.isColorLevel()) {
            QLog.d("DailyReport", 2, "reportMeItemStatus remove:" + l);
          }
        }
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject2 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        l = ((Long)((Iterator)localObject2).next()).longValue();
        localObject1 = "";
        if (l == 21L) {
          localObject1 = "tim_mine_tab_file_on";
        }
        for (;;)
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            anpc.report((String)localObject1);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DailyReport", 2, "reportMeItemStatus id:" + l + ", tag:" + (String)localObject1);
          break;
          if (l == 18L) {
            localObject1 = "tim_mine_tab_favorite_on";
          } else if (l == 17L) {
            localObject1 = "tim_mine_tab_email_on";
          } else if (l == 26L) {
            localObject1 = "tim_mine_tab_remain_on";
          } else if (l == 19L) {
            localObject1 = "tim_mine_tab_agenda_on";
          } else if (l == 22L) {
            localObject1 = "tim_mine_tab_wallet_on";
          } else if (l == 35L) {
            localObject1 = "tim_mine_tab_mini_app_on";
          } else if (l == 24L) {
            localObject1 = "tim_mine_tab_qqspace_open";
          }
        }
      }
    }
  }
  
  private static void dT(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Object localObject = paramQQAppInterface.getApp().getApplicationContext();
    try
    {
      String str = alla.getString(((Context)localObject).getContentResolver(), "default_input_method");
      localObject = aQ((Context)localObject);
      anot.a(paramQQAppInterface, "CliOper", "", paramQQAppInterface.getCurrentAccountUin(), "Type_input", "Type_input", 0, 0, "", "", str, (String)localObject);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MainActivityReportHelper", 1, "reportIMEInfo fail", paramQQAppInterface);
    }
  }
  
  private static void dU(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = UserAction.getQIMEI();
    if (paramQQAppInterface.isLogin()) {}
    for (String str1 = "0";; str1 = "1")
    {
      anot.b(paramQQAppInterface, "0X800AAA1", "0X800AAA1", "0X800AAA1", "", 0, "", str2, str1, "", "", "", "", "", "");
      return;
    }
  }
  
  private void e(anpc paramanpc)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        Set localSet = G();
        localHashMap.put("param_manufacture", Build.MANUFACTURER);
        localHashMap.put("param_model", Build.MODEL);
        if ((localSet.contains(Integer.valueOf(1))) && (localSet.contains(Integer.valueOf(2))) && (localSet.contains(Integer.valueOf(4))))
        {
          String str1 = "1";
          localHashMap.put("param_sensor_all3", str1);
          if (!localSet.contains(Integer.valueOf(1))) {
            break label593;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl", str1);
          if (!localSet.contains(Integer.valueOf(4))) {
            break label600;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro", str1);
          if (!localSet.contains(Integer.valueOf(16))) {
            break label607;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro_uncalibrated", str1);
          if (!localSet.contains(Integer.valueOf(2))) {
            break label614;
          }
          str1 = "1";
          localHashMap.put("param_sensor_magnet", str1);
          if (!localSet.contains(Integer.valueOf(14))) {
            break label621;
          }
          str1 = "1";
          localHashMap.put("param_sensor_magnet_uncalibrated", str1);
          if ((!localSet.contains(Integer.valueOf(1))) || (!localSet.contains(Integer.valueOf(4)))) {
            break label628;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl_gyro", str1);
          if ((!localSet.contains(Integer.valueOf(1))) || (!localSet.contains(Integer.valueOf(2)))) {
            break label635;
          }
          str1 = "1";
          localHashMap.put("param_sensor_accl_magnet", str1);
          if ((!localSet.contains(Integer.valueOf(4))) || (!localSet.contains(Integer.valueOf(2)))) {
            break label642;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gyro_magnet", str1);
          if (!localSet.contains(Integer.valueOf(3))) {
            break label649;
          }
          str1 = "1";
          localHashMap.put("param_sensor_orientation", str1);
          if (!localSet.contains(Integer.valueOf(11))) {
            break label656;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation", str1);
          if (!localSet.contains(Integer.valueOf(15))) {
            break label663;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation_game", str1);
          if (!localSet.contains(Integer.valueOf(20))) {
            break label670;
          }
          str1 = "1";
          localHashMap.put("param_sensor_rotation_geomagnet", str1);
          if (!localSet.contains(Integer.valueOf(9))) {
            break label677;
          }
          str1 = "1";
          localHashMap.put("param_sensor_gravity", str1);
          if (localSet.contains(Integer.valueOf(10)))
          {
            str1 = "1";
            localHashMap.put("param_sensor_linear_accl", str1);
            paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "arSensorSupport", true, 0L, 0L, localHashMap, "");
            return;
          }
          str1 = "0";
          continue;
        }
        str2 = "0";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportSensorSupport", localException);
        }
        paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "arSensorSupport", false, 0L, 0L, null, "");
        return;
      }
      continue;
      label593:
      String str2 = "0";
      continue;
      label600:
      str2 = "0";
      continue;
      label607:
      str2 = "0";
      continue;
      label614:
      str2 = "0";
      continue;
      label621:
      str2 = "0";
      continue;
      label628:
      str2 = "0";
      continue;
      label635:
      str2 = "0";
      continue;
      label642:
      str2 = "0";
      continue;
      label649:
      str2 = "0";
      continue;
      label656:
      str2 = "0";
      continue;
      label663:
      str2 = "0";
      continue;
      label670:
      str2 = "0";
      continue;
      label677:
      str2 = "0";
    }
  }
  
  void d(anpc paramanpc)
  {
    if (paramanpc == null) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        int i = aqiw.getSystemNetwork(BaseApplication.getContext());
        WifiManager localWifiManager = (WifiManager)BaseApplication.getContext().getSystemService("wifi");
        if ((localWifiManager == null) || (!localWifiManager.isWifiEnabled())) {
          break label161;
        }
        bool = true;
        localHashMap.put("param_nettype", String.valueOf(i));
        localHashMap.put("param_wifi_switch_on", String.valueOf(bool));
        if (QLog.isColorLevel()) {
          QLog.d("DailyReport", 2, "reportWifiSwitchStatus nettype = " + i + ",isWiFiSwitchOn = " + bool);
        }
        paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "arMapWifiSwitchStatus", true, 0L, 0L, localHashMap, "");
        return;
      }
      catch (Throwable paramanpc) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramanpc);
      return;
      label161:
      boolean bool = false;
    }
  }
  
  void dSp()
  {
    this.f.getSharedPreferences("mobileQQ", 0);
    anpg.bT(this.f, this.app.getCurrentAccountUin());
    anpb.h(this.app, this.f, this.app.getCurrentAccountUin());
    aqeu.z(this.f, this.app.getCurrentAccountUin(), 0);
    ThemeUtil.resetThemeSwitchTimes(this.app);
    ((ChatBackgroundManager)this.app.getManager(63)).bF(this.f, this.app.getCurrentAccountUin());
  }
  
  public void dSq()
  {
    Object localObject = (acgx)this.app.getManager(186);
    boolean bool1 = ((acgx)localObject).aay();
    QQAppInterface localQQAppInterface = this.app;
    boolean bool2;
    if (bool1)
    {
      str = "1";
      anot.a(localQQAppInterface, "CliStatus", "", "", "0X8007918", "0X8007918", 0, 0, str, "", "", "");
      bool2 = ((acgx)localObject).aax();
      localObject = this.app;
      if (!bool2) {
        break label170;
      }
    }
    label170:
    for (String str = "1";; str = "2")
    {
      anot.a((QQAppInterface)localObject, "CliStatus", "", "", "0X8007919", "0X8007919", 0, 0, str, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportVisitorLikeRankingStatus isRankingSwitch=" + bool1 + "isRankingNotificationSwitch=" + bool2);
      }
      return;
      str = "2";
      break;
    }
  }
  
  void f(anpc paramanpc)
  {
    if (paramanpc == null) {
      return;
    }
    for (;;)
    {
      HashMap localHashMap;
      int[] arrayOfInt;
      long l1;
      try
      {
        localHashMap = new HashMap();
        boolean bool = aqmj.aFb();
        arrayOfInt = aqmj.af();
        long l2 = aqmj.hO();
        if ((!bool) && (arrayOfInt[1] <= 0))
        {
          alwd.a().Ol(false);
          aqmj.eep();
        }
        l1 = -1L;
        if (l2 <= 0L) {
          break label301;
        }
        l1 = (System.currentTimeMillis() - l2) / 1000L;
      }
      catch (Throwable paramanpc) {}
      if (arrayOfInt[0] > arrayOfInt[1]) {
        break;
      }
      BigDecimal localBigDecimal = new BigDecimal(arrayOfInt[0] * 1.0F / arrayOfInt[1]);
      localHashMap.put("filter_download", String.valueOf(arrayOfInt[0]));
      localHashMap.put("filter_total", String.valueOf(arrayOfInt[1]));
      localHashMap.put("filter_ratio", String.valueOf(localBigDecimal.setScale(2, 4).floatValue()));
      localHashMap.put("filter_spacing", String.valueOf(l1));
      if (QLog.isColorLevel()) {
        QLog.d("DailyReport", 2, "reportQQFilterDownloadInfo filter_download = " + arrayOfInt[0] + ",filter_total = " + arrayOfInt[1] + ",filter_spacing" + l1);
      }
      paramanpc.collectPerformance(this.app.getCurrentAccountUin(), "reportQQFilterDownloadInfo", true, 0L, 0L, localHashMap, "");
      anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "acQQFilterDownloadCount", true, 0L, 0L, localHashMap, null);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DailyReport", 2, "reportWifiSwitchStatus", paramanpc);
      return;
      label301:
      if (arrayOfInt[0] <= 0) {
        if (arrayOfInt[1] <= 0) {
          break;
        }
      }
    }
  }
  
  public int od()
  {
    this.app = this.a.app;
    this.f = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = this.f.getSharedPreferences("mobileQQ", 0);
    long l1 = localSharedPreferences.getLong("LastTimeLogin_" + this.app.getCurrentAccountUin(), 0L);
    long l2 = System.currentTimeMillis() - 10L;
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(l1);
    localCalendar2.add(5, 1);
    localCalendar2.clear(10);
    localCalendar2.clear(12);
    localCalendar2.clear(13);
    localCalendar2.clear(14);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).add(5, 1);
    ((Calendar)localObject1).clear(10);
    ((Calendar)localObject1).clear(12);
    ((Calendar)localObject1).clear(13);
    ((Calendar)localObject1).clear(14);
    Object localObject3;
    Object localObject4;
    anpc localanpc;
    if ((((Calendar)localObject1).getTimeInMillis() - l2 - 100L >= 0L) || ((l1 > 0L) && (localCalendar1.after(localCalendar2))))
    {
      dSt();
      QO(this.app.getCurrentUin());
      dT(this.app);
      dU(this.app);
      aqeu.ew(this.app);
      NotifyPushSettingActivity.q(this.app, this.app.getCurrentAccountUin());
      dSo();
      dSe();
      ahav.h(this.app, this.f);
      localObject3 = this.app.getCurrentAccountUin();
      QN((String)localObject3);
      localObject4 = this.f;
      localanpc = anpc.a((Context)localObject4);
    }
    label1456:
    label1757:
    for (;;)
    {
      int j;
      int i;
      Object localObject2;
      try
      {
        dSf();
        dSg();
        dSh();
        dSi();
        dSj();
        dSk();
        dSl();
        dSm();
        dSn();
        irm.w(this.app);
        irm.x(this.app);
        localObject1 = (achs)this.app.getManager(92);
        if ((localObject1 != null) && (((achs)localObject1).aaX()))
        {
          if (((achs)localObject1).getAuthMode() == 1)
          {
            localObject1 = "devlock";
            VipUtils.a(this.app, "chat_history", "ChatHistory", "auth_mode", 1, 0, new String[] { "0", "0", localObject1 });
          }
        }
        else
        {
          Object localObject5 = (acff)this.app.getManager(51);
          localObject1 = null;
          if (localObject5 != null) {
            localObject1 = ((acff)localObject5).a((String)localObject3);
          }
          if (localObject1 != null) {
            VasWebviewUtil.reportVasStatus("FontStatus", "FontOn", String.valueOf(((ExtensionInfo)localObject1).uVipFont), 0, 0);
          }
          if (localObject1 != null)
          {
            j = ((acle)this.app.getBusinessHandler(13)).AX();
            if (j != 2) {
              continue;
            }
            i = 0;
            VasWebviewUtil.reportVasStatus("0X8004A26", "0X8004A26", String.valueOf(((ExtensionInfo)localObject1).colorRingId), i, 0);
          }
          i = ((acle)this.app.getBusinessHandler(13)).AX();
          if (localObject1 != null) {
            VasWebviewUtil.reportVasStatus("0X8005005", "0X8005005", String.valueOf(((ExtensionInfo)localObject1).commingRingId), i, 0);
          }
          j = aqwu.a(this.app, this.app.getAccount(), 6, true, null);
          if (i != 2) {
            break label755;
          }
          i = 0;
          anot.a(this.app, "CliOper", "", this.app.getCurrentAccountUin(), "funcallnew", "setfuncall", 0, 0, String.valueOf(j), String.valueOf(i), String.valueOf(aqiw.getSystemNetwork(null)), "1");
          localObject1 = anpb.n(this.app);
          if (localObject1 == null) {
            break label765;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label765;
          }
          localObject5 = (MessageReportData)((Iterator)localObject1).next();
          if (((MessageReportData)localObject5).msgCount <= 0) {
            continue;
          }
          localanpc.h(this.app, ((MessageReportData)localObject5).getMsgReport());
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("DailyReport", 2, "reportAioEmotionData", localException);
        continue;
        localObject2 = "password";
        continue;
        i = j;
        if (j != 3) {
          continue;
        }
        i = 2;
        continue;
      }
      label755:
      if (i == 3)
      {
        i = 2;
        continue;
        label765:
        i = aqeu.J((Context)localObject4, (String)localObject3);
        if (i > 0) {
          anpc.a(BaseApplication.getContext()).a(this.app, this.app.getCurrentAccountUin(), "Setting_Quit", i);
        }
        i = NotifyPushSettingActivity.d((Context)localObject4, (String)localObject3, "LED_light");
        localObject2 = new HashMap();
        ((HashMap)localObject2).clear();
        ((HashMap)localObject2).put("LED_light", Integer.valueOf(i));
        localanpc.b(this.app, (String)localObject3, (Map)localObject2);
        boolean bool;
        if (auqw.isSupportBadge(this.app.getApplication()))
        {
          bool = SettingCloneUtil.readValue(this.f, null, null, "qqsetting_show_badgeunread_key", true);
          localObject4 = this.app;
          if (bool)
          {
            localObject2 = "1";
            anot.a((QQAppInterface)localObject4, "CliStatus", "", "", "0X8004BE8", "0X8004BE8", 0, 0, (String)localObject2, "", "", "");
          }
        }
        else
        {
          akxp.dDV();
          i = ThemeUtil.getThemeSwitchTimes(this.app);
          if (i > 0) {
            localanpc.a(this.app, (String)localObject3, "", "theme_mall", "theme_replace", 0, i, 0);
          }
          i = ((ChatBackgroundManager)this.app.getManager(63)).B(this.f, this.app.getCurrentAccountUin());
          if (i > 0) {
            localanpc.a(this.app, (String)localObject3, "", "background", "bkground_replace", 0, i, 0);
          }
          bool = SettingCloneUtil.readValue(this.f, this.app.getCurrentAccountUin(), this.f.getString(2131695500), "qqsetting_lock_screen_whenexit_key", true);
          localObject3 = this.app;
          if (!Boolean.valueOf(bool).booleanValue()) {
            break label1707;
          }
        }
        for (localObject2 = "1";; localObject2 = "0")
        {
          anot.a((QQAppInterface)localObject3, "CliStatus", "", "", "0X80040D9", "0X80040D9", 0, 0, (String)localObject2, "", "", "");
          b(localanpc);
          a(localanpc);
          try
          {
            if (Build.VERSION.SDK_INT < 19) {
              break label1456;
            }
            localObject3 = new HashMap();
            i = QQToast.MK();
            ((HashMap)localObject3).put("notifationStat", String.valueOf(i));
            ((HashMap)localObject3).put("uinParam", this.app.getCurrentAccountUin());
            localObject2 = aqgz.getRomInfo();
            if (localObject2 != null) {
              break label1757;
            }
            localObject2 = "";
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              int k;
              int m;
              if (QLog.isColorLevel()) {
                QLog.d("StatisticCollector", 2, "msg Notification report fail err:" + localThrowable.getMessage());
              }
            }
          }
          ((HashMap)localObject3).put("romInfo", localObject2);
          localObject4 = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
          bool = ((SharedPreferences)localObject4).contains(this.app.getCurrentUin() + "_" + "push_open_notify_xml");
          j = ((SharedPreferences)localObject4).getInt("push_msg_notify_count", 0);
          k = ((SharedPreferences)localObject4).getInt("push_msg_notify_open", 0);
          m = ((SharedPreferences)localObject4).getInt("push_msg_notify_cancle", 0);
          ((HashMap)localObject3).put("hasConfigs", String.valueOf(bool));
          ((HashMap)localObject3).put("pushCount", String.valueOf(j));
          ((HashMap)localObject3).put("openCount", String.valueOf(k));
          ((HashMap)localObject3).put("cancleCount", String.valueOf(m));
          anpc.a(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "msgNotificationStatsTag", true, 0L, 0L, (HashMap)localObject3, "");
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, String.format("msg Notification report value, notifationStat: %d, romInfo: %s", new Object[] { Integer.valueOf(i), localObject2 }));
          }
          anot.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "push_value", "", "", "", 1, "", String.valueOf(i), String.valueOf(bool), String.valueOf(j), String.valueOf(k), String.valueOf(m), "", "");
          dSs();
          zjq.a().bs(this.app);
          e(localanpc);
          d(localanpc);
          c(localanpc);
          dSd();
          new anpt().report(this.app);
          dSq();
          f(localanpc);
          ikh.anr();
          dSp();
          dSc();
          dSr();
          if (QLog.isColorLevel()) {
            QLog.d("StatisticCollector", 2, "**************report data below:*****************");
          }
          localSharedPreferences.edit().putLong("LastTimeLogin_" + this.app.getCurrentAccountUin(), l2).commit();
          if (localCalendar1.after(localCalendar2))
          {
            ThemeUiPlugin.reportThemeNumAndCurrThemeName(this.app, this.app.getCurrentAccountUin());
            ((ChatBackgroundManager)this.app.getManager(63)).ap(this.app, this.app.getCurrentAccountUin());
          }
          if (l1 == 0L) {
            localSharedPreferences.edit().putLong("LastTimeLogin_" + this.app.getCurrentAccountUin(), l2).commit();
          }
          return 7;
          localObject2 = "0";
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.DailyReport
 * JD-Core Version:    0.7.0.1
 */