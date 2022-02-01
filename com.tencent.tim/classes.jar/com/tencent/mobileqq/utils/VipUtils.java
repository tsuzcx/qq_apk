package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import aajv.a;
import abxe;
import acej;
import acff;
import acfp;
import aeif;
import aerc;
import aeri;
import afab;
import afua;
import ahwa;
import ahwb;
import ajoe;
import ajoh;
import ajol;
import ajol.a;
import altq;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import anlm;
import anot;
import apol.a;
import aqgv;
import aqha;
import aqho;
import aqiw;
import aqju;
import aqnn;
import aqno;
import aqnp;
import aqnq;
import aqnr;
import aqqj;
import aqqx;
import aqsx;
import aqsx.a;
import aqsz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.a;
import com.tencent.mobileqq.activity.TroopMemberListActivity.h;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.h;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.theme.ThemeCleaner;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x120.SubMsgType0x120.MsgBody;
import wja;

public class VipUtils
{
  static HashMap<String, Integer> oX;
  
  public static String K(QQAppInterface paramQQAppInterface)
  {
    if (cd(paramQQAppInterface)) {
      return "bvip";
    }
    if (ce(paramQQAppInterface)) {
      return "svip";
    }
    if (cf(paramQQAppInterface)) {
      return "vip";
    }
    return "normal";
  }
  
  private static String N(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return "";
            if ("C2C_click".equals(paramString)) {
              return "0X800A9C6";
            }
          } while (!"C2C_show".equals(paramString));
          return "0X800A9C4";
          if ("C2C_click".equals(paramString)) {
            return "0X800A75D";
          }
        } while (!"C2C_show".equals(paramString));
        return "0X800A75B";
        if ("C2C_click".equals(paramString)) {
          return "0X800A9CC";
        }
      } while (!"C2C_show".equals(paramString));
      return "0X800A9CA";
      if ("C2C_click".equals(paramString)) {
        return "0X800A9C9";
      }
    } while (!"C2C_show".equals(paramString));
    return "0X800A9C7";
  }
  
  public static void O(Context paramContext, boolean paramBoolean)
  {
    String str = acfp.m(2131716830);
    if (paramBoolean) {}
    for (int i = 16;; i = 9)
    {
      paramContext = aqha.a(paramContext, 0, str, a(0, i).toString(), acfp.m(2131716836), null, null, new aqno());
      if (!paramContext.isShowing()) {
        paramContext.show();
      }
      return;
    }
  }
  
  public static int a(afua paramafua)
  {
    int k = 0;
    int i;
    int j;
    if ((paramafua.mVipType & 0x2) != 0)
    {
      i = 1;
      j = k;
      if (!paramafua.mVipHide)
      {
        if ((paramafua.mBigVipHide) || (paramafua.mBigVipLevel <= 0)) {
          break label49;
        }
        j = i + 768;
      }
    }
    label49:
    do
    {
      return j;
      i = 0;
      break;
      if (((paramafua.mVipType & 0x100) != 0) && (paramafua.mVipLevel > 0)) {
        return i + 512;
      }
      j = k;
    } while (paramafua.mVipType == 0);
    return 0;
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString)
  {
    int j = 0;
    int m = 0;
    int i = j;
    label76:
    int k;
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (acff)paramAppRuntime.getManager(51);
      if (paramAppRuntime == null) {
        break label151;
      }
      paramAppRuntime = paramAppRuntime.e(str);
      if (paramAppRuntime == null) {
        break label133;
      }
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        break label117;
      }
      i = 1;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        break label122;
      }
      j = 2;
      if (!paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label127;
      }
      k = 4;
      label89:
      if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
        m = 8;
      }
      i = m | k | 0x0 | i | j;
    }
    label117:
    label122:
    label127:
    do
    {
      do
      {
        return i;
        i = 0;
        break;
        j = 0;
        break label76;
        k = 0;
        break label89;
        i = j;
      } while (!QLog.isColorLevel());
      QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
      return 0;
      i = j;
    } while (!QLog.isColorLevel());
    label133:
    label151:
    QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
    return 0;
  }
  
  public static Drawable a(int paramInt, Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    int i;
    int j;
    do
    {
      return paramDrawable;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i == 0) || (j == 0));
    paramDrawable.setBounds(0, 0, i * paramInt / j, paramInt);
    return paramDrawable;
  }
  
  public static SpannableString a(int paramInt1, int paramInt2)
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = aW(i, paramInt1);
    Object localObject = "";
    if (j >= 0)
    {
      if (j != 0) {
        break label126;
      }
      localObject = acfp.m(2131716822);
    }
    String str;
    for (;;)
    {
      str = acfp.m(2131716814);
      switch (paramInt2)
      {
      default: 
        return null;
        label126:
        if (j == 1) {
          localObject = acfp.m(2131716806);
        } else if (j == 2) {
          localObject = acfp.m(2131716831);
        } else {
          localObject = j + acfp.m(2131716825);
        }
        break;
      }
    }
    localObject = new SpannableString(acfp.m(2131716804) + (String)localObject + acfp.m(2131716819) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(acfp.m(2131716838) + (String)localObject + acfp.m(2131716802) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(acfp.m(2131716811) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(acfp.m(2131716826) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    return new SpannableString(acfp.m(2131716817) + (String)localObject + acfp.m(2131716835));
    return new SpannableString(acfp.m(2131716812) + (String)localObject + acfp.m(2131716805));
    return new SpannableString(acfp.m(2131716808));
    return new SpannableString(acfp.m(2131716824));
    return new SpannableString(acfp.m(2131716827));
    return new SpannableString(acfp.m(2131716820));
    localObject = new SpannableString(acfp.m(2131716832) + (String)localObject + acfp.m(2131716801) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    localObject = new SpannableString(acfp.m(2131716833) + str);
    paramInt1 = ((SpannableString)localObject).length() - str.length();
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
    return localObject;
    paramInt1 = aW(i, paramInt1) + 30;
    if (paramInt1 >= 0) {
      if (paramInt1 == 0) {
        localObject = acfp.m(2131716810);
      }
    }
    for (;;)
    {
      localObject = new SpannableString(acfp.m(2131716828) + (String)localObject + acfp.m(2131716818) + str);
      paramInt1 = ((SpannableString)localObject).length() - str.length();
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(Color.parseColor("#0000ff")), paramInt1, str.length() + paramInt1, 34);
      return localObject;
      if (paramInt1 == 1)
      {
        localObject = acfp.m(2131716837);
      }
      else if (paramInt1 == 2)
      {
        localObject = acfp.m(2131716816);
      }
      else
      {
        localObject = paramInt1 + acfp.m(2131716813);
        continue;
        localObject = acfp.m(2131716803);
      }
    }
    return new SpannableString(acfp.m(2131716815));
    return new SpannableString(acfp.m(2131716823));
    return new SpannableString(acfp.m(2131716829));
    return new SpannableString(acfp.m(2131716807));
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime, paramString, true);
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString, EVIPSPEC paramEVIPSPEC)
  {
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (acff)paramAppRuntime.getManager(51);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(str);
        if (paramAppRuntime != null)
        {
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB))) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_BIGCLUB) | 0x300);
          }
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) | 0x200);
          }
          if ((paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP) && (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP))) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) | 0x100);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
        }
      }
      for (;;)
      {
        return 0;
        if (QLog.isColorLevel()) {
          QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
        }
      }
    }
    return 0;
  }
  
  public static short a(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    if (paramAppRuntime != null)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramAppRuntime.getAccount();
      }
      paramAppRuntime = (acff)paramAppRuntime.getManager(51);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(str);
        if (paramAppRuntime != null)
        {
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_BIGCLUB) | 0x300);
          }
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_SUPERVIP) | 0x200);
          }
          if (paramAppRuntime.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            return (short)(paramAppRuntime.getServiceType(EVIPSPEC.E_SP_QQVIP) | 0x100);
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("VipUtils", 2, "getPrivilegeFlags Friends is null");
        }
      }
      for (;;)
      {
        return 0;
        if (QLog.isColorLevel()) {
          QLog.e("VipUtils", 2, "getPrivilegeFlags FriendsManagerImp is null");
        }
      }
    }
    return 0;
  }
  
  public static void a(afua paramafua, ImageView paramImageView)
  {
    int k = 1;
    int j = 0;
    Resources localResources = paramImageView.getResources();
    int i;
    String str;
    int m;
    if ((paramafua.mVipType & 0x2) != 0)
    {
      i = 1;
      str = b.b(paramafua);
      if (!aFg()) {
        break label182;
      }
      m = a(paramafua);
      if (TextUtils.isEmpty(str)) {
        break label182;
      }
      if (m >> 8 != 3) {
        break label119;
      }
      if (i == 0) {
        break label97;
      }
      b(localResources, paramImageView, str, localResources.getDrawable(2130847938));
      i = k;
    }
    for (;;)
    {
      label80:
      if (i != 0) {}
      for (i = j;; i = 8)
      {
        paramImageView.setVisibility(i);
        return;
        i = 0;
        break;
        label97:
        b(localResources, paramImageView, str, localResources.getDrawable(2130847936));
        i = k;
        break label80;
        label119:
        if (m >> 8 != 2) {
          break label182;
        }
        if (i != 0)
        {
          b(localResources, paramImageView, str, localResources.getDrawable(2130847938));
          i = k;
          break label80;
        }
        b(localResources, paramImageView, str, localResources.getDrawable(2130847936));
        i = k;
        break label80;
      }
      label182:
      i = 0;
    }
  }
  
  public static void a(Activity paramActivity, a parama)
  {
    if ((parama == null) || (paramActivity == null) || (TextUtils.isEmpty(parama.uin)) || (TextUtils.isEmpty(parama.aid)) || (TextUtils.isEmpty(parama.cuo)) || (TextUtils.isEmpty(parama.serviceCode)) || (TextUtils.isEmpty(parama.serviceName)) || (parama.eae < 1)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("serviceCode", parama.serviceCode);
        ((JSONObject)localObject).put("aid", parama.aid);
        ((JSONObject)localObject).put("openMonth", String.valueOf(parama.eae));
        ((JSONObject)localObject).put("offerId", parama.cuo);
        ((JSONObject)localObject).put("serviceName", parama.serviceName);
        ((JSONObject)localObject).put("userId", parama.uin);
        if (!parama.isCanChange) {
          ((JSONObject)localObject).put("isCanChange", false);
        }
        localObject = ((JSONObject)localObject).toString();
        if (parama.np == null) {
          break label233;
        }
        parama = parama.np;
        PayBridgeActivity.tenpay(paramActivity, (String)localObject, 4, parama);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("VipUtils", 2, "openRechargeDialog exception : " + paramActivity.getMessage());
      return;
      label233:
      parama = "";
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramOnClickListener, paramString4, paramInt, false);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener, String paramString4, int paramInt, boolean paramBoolean)
  {
    paramContext = aqha.a(paramContext, 0, acfp.m(2131716821), paramString2, paramString3, acfp.m(2131716800), new aqnn(paramBoolean, paramContext, paramString1, paramString4, paramInt), paramOnClickListener);
    if (!paramContext.isShowing()) {
      paramContext.show();
    }
  }
  
  public static void a(View paramView, int paramInt, String paramString)
  {
    paramView = paramView.getContext();
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramInt >> 8 == 3)
    {
      n((QQAppInterface)localObject, paramView, "dhykl");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(aqqj.getUrl("NameplateClickSvip"));
    ((StringBuilder)localObject).append("&source=kl&qq=");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new Intent(paramView, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("fragmentStyle", 3);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("isTransparentTitle", true);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    paramView.startActivity((Intent)localObject);
  }
  
  public static void a(View paramView, afua paramafua)
  {
    int i = a(paramafua);
    Context localContext = paramView.getContext();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null) {
      if (paramafua.mIsMyFeed) {
        if (i >> 8 == 3) {
          n(localQQAppInterface, localContext, "dhykl");
        }
      }
    }
    for (;;)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009F0C", "0X8009F0C", 0, 0, "", "", "", "");
      return;
      fC(localContext);
      continue;
      a(paramView, i, paramafua.mUin);
      continue;
      QLog.e("VipUtils", 1, "klClickVipIcon: app is null");
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        anot.a(localQQAppInterface, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        abxe.a(paramAppInterface, paramString1, paramString2, paramString3, "", paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        return;
      }
    }
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        paramAppInterface.reportClickEvent("P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        break;
      }
    }
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
    {
      anot.a(null, "P_CliOper", paramVarArgs, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      break;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    if (paramString4 == null) {
      paramString4 = "";
    }
    for (;;)
    {
      if ((paramAppInterface instanceof QQAppInterface))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)paramAppInterface;
        if (TextUtils.isEmpty(paramString1)) {}
        for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
        {
          anot.a(localQQAppInterface, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          abxe.a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          return;
        }
      }
      if (paramAppInterface != null)
      {
        if (TextUtils.isEmpty(paramString1)) {}
        for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
        {
          paramAppInterface.reportClickEvent("P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
          break;
        }
      }
      if (TextUtils.isEmpty(paramString1)) {}
      for (paramVarArgs = "UNKNOWN";; paramVarArgs = paramString1)
      {
        anot.a(null, "P_CliOper", paramVarArgs, paramString4, paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
        break;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString)
  {
    a locala;
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      locala = new a();
      locala.uin = paramBaseActivity.app.getCurrentAccountUin();
      locala.aid = paramString;
      locala.eae = paramInt;
      locala.isCanChange = paramBoolean2;
      if (!paramBoolean1) {
        break label102;
      }
      locala.cuo = "1450000516";
      locala.serviceCode = "CJCLUBT";
      locala.serviceName = paramBaseActivity.getString(2131720669);
    }
    for (locala.np = "svip";; locala.np = "vip")
    {
      a(paramBaseActivity, locala);
      return;
      label102:
      locala.cuo = "1450000515";
      locala.serviceCode = "LTMCLUB";
      locala.serviceName = paramBaseActivity.getString(2131697263);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, long paramLong, String paramString)
  {
    String str = afab.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramInt, paramLong);
    if (QLog.isColorLevel()) {
      QLog.i("VipUtils", 2, "NamePlate clickFriendVipIcon jumpUrl = " + str + " aid = " + paramString + " vipType = " + paramInt + " namePlateId = " + paramLong);
    }
    if (paramLong > 0L) {
      afab.k(paramQQAppInterface, paramLong);
    }
    if (TextUtils.isEmpty(str))
    {
      n(paramQQAppInterface, paramContext, paramString);
      return;
    }
    paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", str);
    paramContext.startActivity(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, apol.a parama, ChatHistoryTroopMemberFragment.a parama1)
  {
    if (anlm.ayn())
    {
      parama.fe.setTextColor(paramResources.getColor(2131167304));
      return;
    }
    if (kk(parama1.bLY) != 0)
    {
      parama.fe.setTextColor(paramResources.getColor(2131167441));
      return;
    }
    switch (kj(parama1.mVipType))
    {
    default: 
      parama.fe.setTextColor(paramResources.getColor(2131167304));
      return;
    case 1: 
    case 3: 
      parama.fe.setTextColor(paramResources.getColor(2131167441));
      return;
    case 2: 
      parama.fe.setTextColor(paramResources.getColor(2131167441));
      return;
    }
    parama.fe.setTextColor(paramResources.getColor(2131167441));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, TroopMemberListActivity.h paramh, TroopMemberListActivity.a parama)
  {
    if (!anlm.ayn()) {}
    paramh.fe.setTextColor(paramResources.getColor(2131167304));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Resources paramResources, ChatHistoryTroopMemberFragment.h paramh, ChatHistoryTroopMemberFragment.a parama)
  {
    if (anlm.ayn())
    {
      paramh.fe.setTextColor(paramResources.getColor(2131167304));
      return;
    }
    if (kk(parama.bLY) != 0)
    {
      paramh.fe.setTextColor(paramResources.getColor(2131167441));
      return;
    }
    switch (kj(parama.mVipType))
    {
    default: 
      paramh.fe.setTextColor(paramResources.getColor(2131167304));
      return;
    case 1: 
    case 3: 
      paramh.fe.setTextColor(paramResources.getColor(2131167441));
      return;
    case 2: 
      paramh.fe.setTextColor(paramResources.getColor(2131167441));
      return;
    }
    paramh.fe.setTextColor(paramResources.getColor(2131167441));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    if (ar(String.valueOf(paramMsgBody.uint64_frd_uin.get()), paramMsgBody.uint32_notice_time.get())) {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "handle0x210_0x120push duplicate push, ignore.");
      }
    }
    do
    {
      return;
      if ((paramMsgBody.uint32_src_app_id.get() == 1) && (paramMsgBody.uint32_notice_type.get() == 14))
      {
        aqsz.a(paramQQAppInterface).efr();
        return;
      }
      if ((paramMsgBody.uint32_src_app_id.get() == 3) && (paramMsgBody.uint32_notice_type.get() == 15)) {
        ThemeCleaner.j(paramQQAppInterface, String.valueOf(paramMsgBody.uint32_clear_themeid.get()));
      }
      if (ajoe.a().arg()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("VipUtils", 2, "handle0x210_0x120push not authorized user, ignore.");
    return;
    b(paramQQAppInterface, paramMsgBody);
  }
  
  public static void a(SingleLineTextView paramSingleLineTextView, Context paramContext, String paramString, int paramInt)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    Object localObject = paramSingleLineTextView.bg();
    if ((localObject != null) && ((localObject instanceof URLDrawable)))
    {
      localObject = (URLDrawable)localObject;
      if (((URLDrawable)localObject).getCurrDrawable() != null)
      {
        localObject = ((URLDrawable)localObject).getCurrDrawable();
        paramString = aqqx.a(paramString, aqqx.pe, (Drawable)localObject, null, new aqnp(bool, paramSingleLineTextView, paramContext));
        if (!bool) {
          break label158;
        }
        if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
          paramString.getCurrDrawable().setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        }
      }
    }
    for (;;)
    {
      paramSingleLineTextView.setCompoundDrawablePadding((int)aqho.convertDpToPixel(paramContext, 5.0F));
      paramSingleLineTextView.setCompoundDrawables(null, a(wja.dp2px(15.0F, paramContext.getResources()), paramString));
      return;
      localObject = paramContext.getResources().getDrawable(paramInt);
      break;
      localObject = paramContext.getResources().getDrawable(paramInt);
      break;
      label158:
      if ((paramString != null) && (paramString.getCurrDrawable() != null)) {
        paramString.getCurrDrawable().setColorFilter(null);
      }
    }
  }
  
  public static void a(String paramString1, ajoh paramajoh, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (paramajoh == null) {}
    do
    {
      do
      {
        do
        {
          return;
          switch ((int)paramajoh.type)
          {
          default: 
            return;
          case 5: 
            if (paramajoh.ada == 1L)
            {
              i = d(paramQQAppInterface, paramString1, 0);
              VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", paramString2, "", 0, 0, 0, "", "" + (i + 1), "", "" + 1, "" + 1, "", "", 0, 0, 0, 0);
              return;
            }
            break;
          }
        } while (paramajoh.ada != 2L);
        i = d(paramQQAppInterface, paramString1, 0);
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 1, "" + 2, "", "", 0, 0, 0, 0);
        return;
        if (paramajoh.ada == 1L)
        {
          i = d(paramQQAppInterface, paramString1, 1);
          VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 2, "" + 1, "", "", 0, 0, 0, 0);
          return;
        }
      } while (paramajoh.ada != 2L);
      int i = d(paramQQAppInterface, paramString1, 1);
      VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "C2C_show", "", 0, 0, 0, "", "" + (i + 1), "", "" + 2, "" + 2, "", "", 0, 0, 0, 0);
      return;
      paramString1 = N(d(paramQQAppInterface, paramString1, 5), paramString2);
    } while (TextUtils.isEmpty(paramString1));
    anot.a(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
  }
  
  public static boolean aFg()
  {
    aeri localaeri = (aeri)aeif.a().o(465);
    if (localaeri == null) {
      return false;
    }
    return localaeri.bVX;
  }
  
  public static int aW(int paramInt1, int paramInt2)
  {
    Date localDate1 = new Date(paramInt1 * 1000L);
    Date localDate2 = new Date(paramInt2 * 1000L);
    localDate1.setHours(0);
    localDate1.setMinutes(0);
    localDate1.setSeconds(0);
    localDate2.setHours(0);
    localDate2.setMinutes(0);
    localDate2.setSeconds(0);
    return (int)((localDate2.getTime() - localDate1.getTime()) / 86400000L);
  }
  
  /* Error */
  public static boolean ar(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 799	com/tencent/mobileqq/utils/VipUtils:oX	Ljava/util/HashMap;
    //   6: ifnonnull +13 -> 19
    //   9: new 801	java/util/HashMap
    //   12: dup
    //   13: invokespecial 802	java/util/HashMap:<init>	()V
    //   16: putstatic 799	com/tencent/mobileqq/utils/VipUtils:oX	Ljava/util/HashMap;
    //   19: getstatic 799	com/tencent/mobileqq/utils/VipUtils:oX	Ljava/util/HashMap;
    //   22: aload_0
    //   23: invokevirtual 805	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 807	java/lang/Integer
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +21 -> 54
    //   36: aload 4
    //   38: invokevirtual 810	java/lang/Integer:intValue	()I
    //   41: istore_2
    //   42: iload_2
    //   43: iload_1
    //   44: if_icmpne +10 -> 54
    //   47: iconst_1
    //   48: istore_3
    //   49: ldc 2
    //   51: monitorexit
    //   52: iload_3
    //   53: ireturn
    //   54: getstatic 799	com/tencent/mobileqq/utils/VipUtils:oX	Ljava/util/HashMap;
    //   57: aload_0
    //   58: iload_1
    //   59: invokestatic 813	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokevirtual 816	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   65: pop
    //   66: iconst_0
    //   67: istore_3
    //   68: goto -19 -> 49
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramString	String
    //   0	77	1	paramInt	int
    //   41	4	2	i	int
    //   48	20	3	bool	boolean
    //   29	8	4	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   3	19	71	finally
    //   19	31	71	finally
    //   36	42	71	finally
    //   54	66	71	finally
  }
  
  public static void b(Resources paramResources, ImageView paramImageView, String paramString, Drawable paramDrawable)
  {
    paramString = aqqx.a(paramString, aqqx.pe, paramDrawable, null, new aqnq(paramResources, paramString, paramImageView, paramDrawable));
    if (paramString != null)
    {
      int i = wja.dp2px(15.0F, paramResources);
      int j = paramString.getIntrinsicWidth() * i / paramString.getIntrinsicHeight();
      paramResources = paramImageView.getLayoutParams();
      paramResources.height = i;
      paramResources.width = j;
      paramImageView.setImageDrawable(paramString);
      paramImageView.setLayoutParams(paramResources);
      if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
        paramImageView.setColorFilter(1996488704);
      }
    }
    else
    {
      return;
    }
    paramImageView.setColorFilter(0);
  }
  
  public static void b(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      a locala = new a();
      locala.uin = paramBaseActivity.app.getCurrentAccountUin();
      locala.aid = paramString;
      locala.cuo = "1450000515";
      locala.serviceCode = "LTMCLUB";
      locala.serviceName = paramBaseActivity.getString(2131697263);
      locala.eae = paramInt;
      locala.np = "vip";
      a(paramBaseActivity, locala);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SubMsgType0x120.MsgBody paramMsgBody)
  {
    String str1 = paramMsgBody.uint32_notice_type.get() + "";
    Object localObject2 = ajoe.mm(str1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("VipUtils", 2, "addFriendGrayTips grayStr is empty, ignore.");
      }
      return;
    }
    Object localObject3 = (acff)paramQQAppInterface.getManager(51);
    Object localObject1 = String.valueOf(paramMsgBody.uint64_frd_uin.get());
    Object localObject4 = aqgv.D(paramQQAppInterface, (String)localObject1);
    long l1 = paramMsgBody.uint32_notice_time.get();
    long l2 = paramMsgBody.uint32_notice_type.get();
    localObject4 = ajol.a(paramQQAppInterface, (String)localObject2, (String)localObject4, (acff)localObject3);
    Object localObject5 = ajol.a(paramQQAppInterface, (String)((List)localObject4).get(0), (String)localObject1);
    localObject3 = ajol.d(paramQQAppInterface.getApp(), (String)((List)localObject5).get(0));
    paramMsgBody = ((ajol.a)((List)localObject3).get(0)).name;
    ((List)localObject4).remove(0);
    ((List)localObject5).remove(0);
    ((List)localObject3).remove(0);
    localObject2 = new ahwa((String)localObject1, (String)localObject1, paramMsgBody, 0, -5020, 2097153, anaz.gQ());
    int i;
    Bundle localBundle;
    String str2;
    int j;
    if ((localObject5 != null) && (((List)localObject5).size() > 0))
    {
      i = 0;
      while (i < ((List)localObject5).size())
      {
        localBundle = new Bundle();
        str2 = (String)((List)localObject5).get(i);
        if (!TextUtils.isEmpty(str2))
        {
          localBundle.putString("image_resource", str2);
          j = paramMsgBody.lastIndexOf(str2);
          if (j >= 0) {
            ((ahwa)localObject2).addHightlightItem(j, str2.length() + j, localBundle);
          }
          if (QLog.isColorLevel()) {
            QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramMsgBody + "iconPos=" + j + "icon=" + str2 + "grayStr=" + paramMsgBody);
          }
        }
        i += 1;
      }
    }
    label429:
    label492:
    int m;
    if ((localObject4 != null) && (((List)localObject4).size() > 0))
    {
      Collections.sort((List)localObject4, new aqnr());
      localObject5 = new ArrayList();
      j = 0;
      if (j < ((List)localObject4).size())
      {
        localBundle = new Bundle();
        str2 = (String)((List)localObject4).get(j);
        if (!TextUtils.isEmpty(str2))
        {
          localBundle.putInt("key_action", 11);
          localBundle.putString("key_action_DATA", str2);
          i = 0;
          m = paramMsgBody.indexOf(str2, i);
          if (m >= 0) {
            break label518;
          }
        }
      }
    }
    label518:
    label1071:
    for (;;)
    {
      label506:
      int n;
      if (m < 0)
      {
        j += 1;
        break label429;
        n = str2.length();
        i = m + n;
        Iterator localIterator = ((ArrayList)localObject5).iterator();
        Pair localPair;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localPair = (Pair)localIterator.next();
        } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
      }
      for (int k = 1;; k = 0)
      {
        if (k != 0) {
          break label1071;
        }
        ((ArrayList)localObject5).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
        if (m >= 0)
        {
          ((ahwa)localObject2).addHightlightItem(m, i, localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("VipUtils", 2, "spanPos=" + m + " fromIndex=" + i);
          }
        }
        break label506;
        break label492;
        i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject4 = (ajol.a)((List)localObject3).get(i);
          localObject5 = new Bundle();
          ((Bundle)localObject5).putInt("key_action", 1);
          ((Bundle)localObject5).putString("key_action_DATA", ((ajol.a)localObject4).url.replace("{uin}", (CharSequence)localObject1));
          j = ((ajol.a)localObject4).djY;
          if (j >= 0) {
            ((ahwa)localObject2).addHightlightItem(j, ((ajol.a)localObject4).name.length() + j, (Bundle)localObject5);
          }
          i += 1;
        }
        localObject3 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject3).hasRead = 0;
        ((MessageForUniteGrayTip)localObject3).initGrayTipMsg(paramQQAppInterface, (ahwa)localObject2);
        localObject2 = new StringBuilder(21);
        ((StringBuilder)localObject2).append(l1).append("_").append(l2);
        ((MessageForUniteGrayTip)localObject3).saveExtInfoToExtStr("friendIconType", str1);
        ((MessageForUniteGrayTip)localObject3).tipParam.bLT = ((StringBuilder)localObject2).toString();
        localObject1 = paramQQAppInterface.b().k((String)localObject1, 0);
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          localObject1 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
          if (((localObject1 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject1).tipParam != null) && (((MessageForUniteGrayTip)localObject1).subType == ((MessageForUniteGrayTip)localObject3).subType) && (((MessageForUniteGrayTip)localObject1).tipParam.wording.equals(((MessageForUniteGrayTip)localObject3).tipParam.wording)) && (((MessageForUniteGrayTip)localObject3).tipParam.time - ((MessageForUniteGrayTip)localObject1).tipParam.time <= 1L))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
            return;
          }
        }
        VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentAccountUin(), "friendspark", "aio_show", "", 0, 0, 0, "", str1, "", "", "", "", "", 0, 0, 0, 0);
        if (TextUtils.isEmpty(paramMsgBody)) {
          break;
        }
        ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject3);
        return;
      }
    }
  }
  
  public static boolean bu(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    Date localDate1;
    Date localDate2;
    do
    {
      return false;
      localDate1 = new Date(paramInt1 * 1000L);
      localDate2 = new Date(paramInt2 * 1000L);
    } while ((localDate1.getYear() != localDate2.getYear()) || (localDate1.getMonth() != localDate2.getMonth()) || (localDate1.getDay() != localDate2.getDay()));
    return true;
  }
  
  public static void c(BaseActivity paramBaseActivity, int paramInt, String paramString)
  {
    if ((paramBaseActivity != null) && (!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      a locala = new a();
      locala.uin = paramBaseActivity.app.getCurrentAccountUin();
      locala.aid = paramString;
      locala.cuo = "1450000516";
      locala.serviceCode = "CJCLUBT";
      locala.serviceName = paramBaseActivity.getString(2131720669);
      locala.eae = paramInt;
      locala.np = "svip";
      a(paramBaseActivity, locala);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    acff localacff = (acff)paramQQAppInterface.getManager(51);
    if (localacff != null)
    {
      paramString1 = localacff.e(paramString1);
      if (paramString1 != null) {}
      for (int i = paramString1.bigClubTemplateId;; i = 0)
      {
        a(paramQQAppInterface, paramContext, paramInt >> 8 | (paramInt & 0xF) << 8, i, paramString2);
        return;
      }
    }
    n(paramQQAppInterface, paramContext, paramString2);
  }
  
  public static boolean cd(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x8) != 0;
  }
  
  public static boolean ce(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x4) != 0;
  }
  
  public static boolean cf(QQAppInterface paramQQAppInterface)
  {
    return (a(paramQQAppInterface, null) & 0x2) != 0;
  }
  
  public static int d(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 0;
      } while ((paramQQAppInterface == null) || (!ajoe.a().arg()));
      return paramQQAppInterface.relationIconFlag >> paramInt * 2 & 0x3;
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.relationIconFlag >> paramInt * 2 & 0x7;
  }
  
  public static String d(AppInterface paramAppInterface, String paramString)
  {
    int i = a(paramAppInterface, paramString);
    if ((i & 0x4) != 0) {
      return "2";
    }
    if ((i & 0x2) != 0) {
      return "1";
    }
    return "0";
  }
  
  public static void fC(Context paramContext)
  {
    String str = aqqj.getUrl("kuoliePersonalCardMaster");
    Object localObject = new StringBuilder(str);
    if (str.contains("?")) {
      ((StringBuilder)localObject).append("&platform=1");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("&qq=" + "0");
      ((StringBuilder)localObject).append("&adtag=" + "qita");
      ((StringBuilder)localObject).append("&aid=" + "mvip.pingtai.mobileqq.androidziliaoka.fromqita");
      str = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + str);
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("uin", ((QQAppInterface)localObject).getCurrentAccountUin());
      localIntent.putExtra("url", str);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity(localIntent);
      return;
      ((StringBuilder)localObject).append("?platform=1");
    }
  }
  
  public static String formatAid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString.replace("-", "_");
      paramString = str;
    } while (str.contains("_"));
    return "jhan_" + str;
  }
  
  public static int g(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    int j = -1;
    int i = j;
    String str;
    if (paramQQAppInterface != null)
    {
      str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQQAppInterface.getCurrentAccountUin();
      }
      paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
      if (paramQQAppInterface == null) {
        break label121;
      }
      if (!paramBoolean) {
        break label77;
      }
      paramQQAppInterface = paramQQAppInterface.e(str);
      if (paramQQAppInterface == null) {
        break label101;
      }
      paramBoolean = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (!paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label87;
      }
      i = 3;
    }
    label77:
    label87:
    label101:
    label121:
    do
    {
      for (;;)
      {
        return i;
        paramQQAppInterface = paramQQAppInterface.c(str);
        break;
        if (paramBoolean)
        {
          i = 2;
        }
        else
        {
          i = 1;
          continue;
          if (QLog.isColorLevel()) {
            QLog.e("VipUtils", 2, "getUserStatus Friends is null");
          }
          i = -1;
        }
      }
      i = j;
    } while (!QLog.isColorLevel());
    QLog.e("VipUtils", 2, "getUserStatus FriendsManagerImp is null");
    return -1;
  }
  
  public static int getIntValue(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramInt;
      if (TextUtils.isDigitsOnly(paramString)) {
        i = Integer.valueOf(paramString).intValue();
      }
    }
    return i;
  }
  
  public static void it(View paramView)
  {
    VipUtils.UpdateRecentEfficientVipIconTask.a.iu(paramView);
  }
  
  public static int kj(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -100)) {
      return 0;
    }
    if ((paramInt & 0x2) != 0)
    {
      if ((paramInt & 0x100) != 0) {
        return 4;
      }
      return 3;
    }
    if ((paramInt & 0x100) != 0) {
      return 2;
    }
    return 1;
  }
  
  public static int kk(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == -100)) {
      return 0;
    }
    if ((paramInt & 0x2) != 0) {
      return 2;
    }
    return 1;
  }
  
  public static int kl(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return 1;
      int i = 1;
      while (i < 32)
      {
        if (paramInt >> i == 0) {
          return 1 + i;
        }
        i += 1;
      }
    }
  }
  
  public static int km(int paramInt)
  {
    float f = 130.0F;
    int i;
    Resources localResources;
    if (acej.aV() > 17.0F)
    {
      i = 1;
      localResources = BaseApplicationImpl.getApplication().getResources();
    }
    switch (paramInt)
    {
    default: 
      if (i != 0) {}
      for (f = 160.0F;; f = 180.0F)
      {
        return wja.dp2px(f, localResources);
        i = 0;
        break;
      }
    case 1: 
      if (i != 0) {}
      for (f = 130.0F;; f = 150.0F) {
        return wja.dp2px(f, localResources);
      }
    case 2: 
      if (i != 0) {}
      for (;;)
      {
        return wja.dp2px(f, localResources);
        f = 150.0F;
      }
    }
    if (i != 0) {}
    for (f = 50.0F;; f = 100.0F) {
      return wja.dp2px(f, localResources);
    }
  }
  
  public static void n(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramString = String.format("https://h5.qzone.qq.com/bigVip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source=%s&_proxy=1", new Object[] { paramString });
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("uin", paramQQAppInterface);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramString, 256L, localIntent, false, -1);
  }
  
  public static void o(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    String str2 = paramContext.getSharedPreferences(str1, 4).getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = aqiw.getSystemNetwork(paramQQAppInterface.getApp().getApplicationContext());
    if (!str2.contains("?"))
    {
      localStringBuilder.append(str2 + "?platform=1&type=20001&networkInfo=" + i + "&aid=" + paramString);
      str2 = localStringBuilder.toString();
      paramString = ((altq)paramQQAppInterface.getManager(36)).getAppInfoByPath(String.valueOf(100400));
      paramQQAppInterface = ((altq)paramQQAppInterface.getManager(36)).b(str2, paramString);
      if ((paramString == null) || (paramString.iNewFlag.get() == 0) || (paramString.type.get() != 0)) {
        break label326;
      }
    }
    label326:
    for (boolean bool = true;; bool = false)
    {
      long l = System.currentTimeMillis();
      paramString = new Intent(paramContext, QQBrowserActivity.class);
      paramString.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      paramString.putExtra("startOpenPageTime", l);
      paramString.putExtra("portraitOnly", true);
      paramString.putExtra("uin", str1);
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("has_red_dot", bool);
      paramString.putExtra("leftBtnText", paramContext.getResources().getString(2131689606));
      VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramQQAppInterface, 256L, paramString, false, -1);
      return;
      localStringBuilder.append(str2 + "&platform=1&type=20001&networkInfo=" + i + "&aid=" + paramString);
      break;
    }
  }
  
  public static int s(QQAppInterface paramQQAppInterface, String paramString)
  {
    return g(paramQQAppInterface, paramString, true);
  }
  
  static class UpdateRecentEfficientVipIconTask
    implements Runnable
  {
    private WeakReference<View> be;
    private WeakReference<Context> bf;
    private WeakReference<aajv.a> bg;
    private boolean isValid;
    private String uin;
    
    private View S()
    {
      return (View)this.be.get();
    }
    
    static void a(Context paramContext, String paramString, aajv.a parama)
    {
      QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
      Object localObject = (acff)localQQAppInterface.getManager(51);
      boolean bool = ((acff)localObject).bHB;
      localObject = ((acff)localObject).e(paramString);
      int i;
      label111:
      int j;
      if ((localObject != null) && (VipUtils.b.my(((Friends)localObject).nameplateVipType)))
      {
        i = 1;
        if (i != 0)
        {
          if (VipUtils.b.mz(((Friends)localObject).grayNameplateFlag)) {
            break label221;
          }
          String str = VipUtils.b.a(localQQAppInterface, ((Friends)localObject).uin, VipUtils.b.a.a(((Friends)localObject).nameplateVipType), false);
          VipUtils.a(parama.g, paramContext, str, VipUtils.b.a(VipUtils.b.a.a(((Friends)localObject).nameplateVipType)));
        }
        j = VipUtils.a(localQQAppInterface, paramString);
        if (QLog.isColorLevel()) {
          QLog.d("VipUtils", 2, "bindView: vip=" + j);
        }
        if (j >> 8 != 3) {
          break label308;
        }
        paramString = VipUtils.b.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_BIGCLUB);
        if ((j & 0xF) != 1) {
          break label252;
        }
        if (!bool) {
          break label233;
        }
        parama.g.setTextColor(paramContext.getResources().getColor(2131167441));
        label200:
        if (i == 0) {
          VipUtils.a(parama.g, paramContext, paramString, 2130847938);
        }
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        label221:
        parama.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        break label111;
        label233:
        parama.g.setTextColor(paramContext.getResources().getColor(2131167311));
        break label200;
        label252:
        if (bool) {
          parama.g.setTextColor(paramContext.getResources().getColor(2131167441));
        }
        while (i == 0)
        {
          VipUtils.a(parama.g, paramContext, paramString, 2130847936);
          return;
          parama.g.setTextColor(paramContext.getResources().getColor(2131167311));
        }
        continue;
        label308:
        if (j >> 8 == 1)
        {
          if (bool) {
            parama.g.setTextColor(paramContext.getResources().getColor(2131167441));
          }
          for (;;)
          {
            paramString = VipUtils.b.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_QQVIP);
            if (i != 0) {
              break;
            }
            VipUtils.a(parama.g, paramContext, paramString, 2130847937);
            return;
            parama.g.setTextColor(paramContext.getResources().getColor(2131167311));
          }
        }
        if (j >> 8 != 2) {
          break label523;
        }
        paramString = VipUtils.b.a(localQQAppInterface, paramString, EVIPSPEC.E_SP_SUPERVIP);
        if ((j & 0xF) == 1)
        {
          if (bool) {
            parama.g.setTextColor(paramContext.getResources().getColor(2131167441));
          }
          while (i == 0)
          {
            VipUtils.a(parama.g, paramContext, paramString, 2130847938);
            return;
            parama.g.setTextColor(paramContext.getResources().getColor(2131167311));
          }
        }
        else
        {
          if (bool) {
            parama.g.setTextColor(paramContext.getResources().getColor(2131167441));
          }
          while (i == 0)
          {
            VipUtils.a(parama.g, paramContext, paramString, 2130847936);
            return;
            parama.g.setTextColor(paramContext.getResources().getColor(2131167311));
          }
        }
      }
      label523:
      parama.g.setTextColor(paramContext.getResources().getColor(2131167311));
      parama.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
    }
    
    public void run()
    {
      a.a(this);
      if (!this.isValid) {
        if (QLog.isColorLevel()) {
          QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - not Valid");
        }
      }
      do
      {
        return;
        Context localContext = (Context)this.bf.get();
        aajv.a locala = (aajv.a)this.bg.get();
        if ((localContext != null) && (locala != null)) {
          a(localContext, this.uin, locala);
        }
      } while (!QLog.isColorLevel());
      QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - sucess : " + this.uin);
    }
    
    static class a
    {
      private static ArrayList<VipUtils.UpdateRecentEfficientVipIconTask> CP = new ArrayList();
      
      static void a(VipUtils.UpdateRecentEfficientVipIconTask paramUpdateRecentEfficientVipIconTask)
      {
        CP.remove(paramUpdateRecentEfficientVipIconTask);
      }
      
      static void iu(View paramView)
      {
        Iterator localIterator = CP.iterator();
        VipUtils.UpdateRecentEfficientVipIconTask localUpdateRecentEfficientVipIconTask2;
        View localView;
        do
        {
          if (!localIterator.hasNext()) {
            break label80;
          }
          localUpdateRecentEfficientVipIconTask2 = (VipUtils.UpdateRecentEfficientVipIconTask)localIterator.next();
          localView = VipUtils.UpdateRecentEfficientVipIconTask.a(localUpdateRecentEfficientVipIconTask2);
          localUpdateRecentEfficientVipIconTask1 = localUpdateRecentEfficientVipIconTask2;
          if (localView == paramView) {
            break;
          }
        } while (localView != null);
        label80:
        for (VipUtils.UpdateRecentEfficientVipIconTask localUpdateRecentEfficientVipIconTask1 = localUpdateRecentEfficientVipIconTask2;; localUpdateRecentEfficientVipIconTask1 = null)
        {
          if (localUpdateRecentEfficientVipIconTask1 != null)
          {
            CP.remove(localUpdateRecentEfficientVipIconTask1);
            VipUtils.UpdateRecentEfficientVipIconTask.a(localUpdateRecentEfficientVipIconTask1, false);
            if (QLog.isColorLevel()) {
              QLog.w("VipUtils", 1, "updateRecentEfficientVipIcon async - diable");
            }
          }
          return;
        }
      }
    }
  }
  
  static class a
  {
    public String aid;
    public String cuo;
    public int eae = 1;
    public boolean isCanChange = true;
    public String np;
    public String serviceCode;
    public String serviceName;
    public String uin;
  }
  
  public static class b
  {
    private static long[] aL = { 0L, 0L };
    
    private static void A(String paramString, int paramInt, boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 9;; i = 0)
      {
        anot.b(null, "dc00898", "", "", "qq_vip", paramString, i, 1, paramInt, "", "", "", "");
        return;
      }
    }
    
    public static int a(a parama)
    {
      if ((parama == a.b) || (parama == a.c)) {}
      do
      {
        return 2130847937;
        if (parama == a.d) {
          return 2130847936;
        }
        if (parama == a.e) {
          return 2130847938;
        }
      } while ((parama != a.f) && (parama != a.g));
      return 2130847935;
    }
    
    public static String a(int paramInt1, int paramInt2, long paramLong)
    {
      return a(paramInt1, paramInt2, paramLong, false);
    }
    
    private static String a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
    {
      if (!paramBoolean) {}
      for (String str = aerc.c().mAPngIconUrl;; str = aerc.c().mAPngIconUrlNew_Gray)
      {
        if (paramBoolean) {
          paramLong = 0L;
        }
        return String.format(str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      }
    }
    
    public static String a(AppRuntime paramAppRuntime, String paramString, EVIPSPEC paramEVIPSPEC)
    {
      Object localObject = (acff)paramAppRuntime.getManager(51);
      if (localObject != null)
      {
        localObject = ((acff)localObject).e(paramString);
        if (localObject != null)
        {
          int i;
          if (paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB)
          {
            i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_BIGCLUB);
            return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), ((Friends)localObject).bigClubTemplateId, false);
          }
          if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP)
          {
            i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_SUPERVIP);
            return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), ((Friends)localObject).superVipTemplateId, false);
          }
          if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP)
          {
            i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_QQVIP);
            return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), 0L, false);
          }
        }
      }
      return a(0, 0, 0L, false);
    }
    
    public static String a(AppRuntime paramAppRuntime, String paramString, a parama, boolean paramBoolean)
    {
      paramAppRuntime = (acff)paramAppRuntime.getManager(51);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(paramString);
        if (paramAppRuntime != null)
        {
          int i;
          if ((parama == a.f) || (parama == a.g))
          {
            i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_BIGCLUB);
            return a(parama.value, i, paramAppRuntime.bigClubTemplateId, paramBoolean);
          }
          if ((parama == a.d) || (parama == a.e))
          {
            i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
            return a(parama.value, i, paramAppRuntime.superVipTemplateId, paramBoolean);
          }
          if ((parama == a.b) || (parama == a.c))
          {
            i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
            return a(parama.value, i, 0L, paramBoolean);
          }
        }
      }
      return a(0, 0, 0L, false);
    }
    
    public static int[] a(AppRuntime paramAppRuntime, String paramString)
    {
      paramAppRuntime = (acff)paramAppRuntime.getManager(51);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.e(paramString);
        if (paramAppRuntime != null) {
          return new int[] { paramAppRuntime.nameplateVipType, paramAppRuntime.grayNameplateFlag };
        }
      }
      return new int[] { 0, 0 };
    }
    
    public static String b(afua paramafua)
    {
      int i = VipUtils.a(paramafua);
      i = (i & 0xF) << 8 | i >> 8;
      if ((i & 0xFF) == 3) {
        return String.format(aerc.c().mAPngIconUrl, new Object[] { Integer.valueOf(i), Integer.valueOf(paramafua.mBigVipLevel), Integer.valueOf(paramafua.mTemplateId) });
      }
      if ((i & 0xFF) == 2) {
        return String.format(aerc.c().mAPngIconUrl, new Object[] { Integer.valueOf(i), Integer.valueOf(paramafua.mVipLevel), Integer.valueOf(paramafua.mTemplateId) });
      }
      return null;
    }
    
    public static boolean my(int paramInt)
    {
      return paramInt > 0;
    }
    
    public static boolean mz(int paramInt)
    {
      return paramInt == 1;
    }
    
    private static void y(String paramString, int paramInt, boolean paramBoolean)
    {
      long l;
      if ("VIA_SETTINGME".equals(paramString))
      {
        l = System.currentTimeMillis();
        if (Math.abs(l - aL[0]) >= 3000L) {}
      }
      do
      {
        do
        {
          return;
          aL[0] = l;
          A("0X800AA99", paramInt, paramBoolean);
          return;
          if (!"VIA_PROFILECARD".equals(paramString)) {
            break;
          }
          l = System.currentTimeMillis();
        } while (Math.abs(l - aL[1]) < 3000L);
        aL[1] = l;
        A("0X800AA9A", paramInt, paramBoolean);
        return;
        if ("VIA_AIO_TITLE".equals(paramString))
        {
          A("0X800AA9B", paramInt, paramBoolean);
          return;
        }
      } while (!"VIA_AIO_CHATSETTINGS".equals(paramString));
      A("0X800AA9C", paramInt, paramBoolean);
    }
    
    private static void z(String paramString, int paramInt, boolean paramBoolean)
    {
      if ("VIA_SETTINGME".equals(paramString)) {
        A("0X800AA9D", paramInt, paramBoolean);
      }
      do
      {
        return;
        if ("VIA_PROFILECARD".equals(paramString))
        {
          A("0X800AA9E", paramInt, paramBoolean);
          return;
        }
        if ("VIA_AIO_TITLE".equals(paramString))
        {
          A("0X800AA9F", paramInt, paramBoolean);
          return;
        }
      } while (!"VIA_AIO_CHATSETTINGS".equals(paramString));
      A("0X800AAA0", paramInt, paramBoolean);
    }
    
    public static class a
    {
      static final a a = new a(0);
      static final a b = new a(1);
      static final a c = new a(257);
      static final a d = new a(2);
      static final a e = new a(258);
      static final a f = new a(3);
      static final a g = new a(259);
      final int value;
      
      public a(int paramInt)
      {
        this.value = paramInt;
      }
      
      public static a a(int paramInt)
      {
        switch (paramInt)
        {
        default: 
          return a;
        case 1: 
          return b;
        case 2: 
          return d;
        case 3: 
          return f;
        case 257: 
          return c;
        case 258: 
          return e;
        }
        return g;
      }
      
      public boolean aFh()
      {
        return (this.value & 0xF) == 3;
      }
      
      public boolean aFi()
      {
        return this.value > 15;
      }
    }
    
    public static class b
      implements View.OnTouchListener
    {
      private final QQAppInterface app;
      private boolean cUI;
      private int eaf;
      private int itemId;
      private final String uin;
      private final String via;
      private int vipType;
      
      private b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
      {
        this.app = paramQQAppInterface;
        this.uin = paramString1;
        this.via = paramString2;
        Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).e(paramString1);
        int i;
        if (localFriends != null)
        {
          if (!VipUtils.b.my(localFriends.nameplateVipType)) {
            break label166;
          }
          paramQQAppInterface = VipUtils.b.a.a(localFriends.nameplateVipType);
          if (!VipUtils.b.mz(localFriends.grayNameplateFlag)) {
            break label116;
          }
          i = 1;
          this.eaf = i;
          this.vipType = paramQQAppInterface.value;
          if ((paramQQAppInterface != VipUtils.b.a.f) && (paramQQAppInterface != VipUtils.b.a.g)) {
            break label122;
          }
          this.itemId = localFriends.bigClubTemplateId;
          this.cUI = true;
        }
        label116:
        label122:
        do
        {
          do
          {
            return;
            i = 0;
            break;
            if ((paramQQAppInterface == VipUtils.b.a.d) || (paramQQAppInterface == VipUtils.b.a.e))
            {
              this.itemId = localFriends.superVipTemplateId;
              return;
            }
          } while ((paramQQAppInterface != VipUtils.b.a.b) && (paramQQAppInterface != VipUtils.b.a.c));
          this.itemId = 0;
          return;
          i = VipUtils.a(paramQQAppInterface, paramString1);
          paramString2 = null;
          if (i >> 8 == 3) {
            paramString2 = EVIPSPEC.E_SP_BIGCLUB;
          }
          while (paramString2 == EVIPSPEC.E_SP_BIGCLUB)
          {
            this.vipType = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_BIGCLUB);
            this.vipType = (this.vipType >> 8 | (this.vipType & 0xF) << 8);
            this.itemId = localFriends.bigClubTemplateId;
            this.cUI = true;
            return;
            if (i >> 8 == 1) {
              paramString2 = EVIPSPEC.E_SP_QQVIP;
            } else if (i >> 8 == 2) {
              paramString2 = EVIPSPEC.E_SP_SUPERVIP;
            }
          }
          if (paramString2 == EVIPSPEC.E_SP_SUPERVIP)
          {
            this.vipType = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_SUPERVIP);
            this.vipType = (this.vipType >> 8 | (this.vipType & 0xF) << 8);
            this.itemId = localFriends.superVipTemplateId;
            return;
          }
        } while (paramString2 != EVIPSPEC.E_SP_QQVIP);
        label166:
        this.vipType = VipUtils.a(paramQQAppInterface, paramString1, EVIPSPEC.E_SP_QQVIP);
        this.vipType = (this.vipType >> 8 | (this.vipType & 0xF) << 8);
        this.itemId = 0;
      }
      
      public static b a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
      {
        return new b(paramQQAppInterface, paramString1, paramString2);
      }
      
      public void KR()
      {
        String str = this.via;
        int i = this.itemId;
        if (this.eaf != 0) {}
        for (boolean bool = true;; bool = false)
        {
          VipUtils.b.B(str, i, bool);
          return;
        }
      }
      
      public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
      {
        if (!aqsx.a.ad((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "namePlate_UrlConfig")) {
          aqsx.a.download(null, "namePlate_UrlConfig", null, false);
        }
        Object localObject1;
        int i;
        boolean bool;
        if ((paramMotionEvent == null) || (paramMotionEvent.getAction() == 1))
        {
          paramMotionEvent = aqsx.a.a(this.vipType, this.itemId, this.eaf);
          localObject1 = this.via;
          i = this.itemId;
          if (this.eaf == 0) {
            break label234;
          }
          bool = true;
          VipUtils.b.C((String)localObject1, i, bool);
          localObject1 = this.app.getCurrentAccountUin();
          bool = this.uin.equals(localObject1);
          if ((paramMotionEvent == null) || (TextUtils.isEmpty(this.uin))) {
            break label339;
          }
          if (!"VIA_SETTINGME".equals(this.via)) {
            break label240;
          }
          paramMotionEvent = paramMotionEvent.cwJ;
        }
        for (;;)
        {
          label142:
          if (!TextUtils.isEmpty(paramMotionEvent))
          {
            if (bool) {
              break label760;
            }
            paramMotionEvent = paramMotionEvent.replace("{uin}", this.uin);
          }
          label234:
          label240:
          label760:
          for (;;)
          {
            Object localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("portraitOnly", true);
            ((Intent)localObject2).putExtra("uin", (String)localObject1);
            ((Intent)localObject2).putExtra("hide_operation_bar", true);
            ((Intent)localObject2).putExtra("hide_more_button", true);
            VasWebviewUtil.openQQBrowserWithoutAD(paramView.getContext(), paramMotionEvent, 256L, (Intent)localObject2, false, -1);
            return true;
            bool = false;
            break;
            if ("VIA_PROFILECARD".equals(this.via))
            {
              if (bool)
              {
                paramMotionEvent = paramMotionEvent.cwK;
                break label142;
              }
              paramMotionEvent = paramMotionEvent.cwM;
              break label142;
            }
            if ("VIA_AIO_TITLE".equals(this.via))
            {
              if (bool)
              {
                paramMotionEvent = paramMotionEvent.cwL;
                break label142;
              }
              paramMotionEvent = paramMotionEvent.cwN;
              break label142;
            }
            if (!"VIA_AIO_CHATSETTINGS".equals(this.via)) {
              break label763;
            }
            if (bool)
            {
              paramMotionEvent = paramMotionEvent.cwO;
              break label142;
            }
            paramMotionEvent = paramMotionEvent.cwP;
            break label142;
            if ("VIA_SETTINGME".equals(this.via))
            {
              if (this.cUI)
              {
                VipUtils.c(this.app, paramView.getContext(), this.vipType, this.uin, "cty");
                return true;
              }
              VipUtils.o(this.app, paramView.getContext(), "cty");
              return true;
            }
            if ("VIA_PROFILECARD".equals(this.via))
            {
              if (this.cUI)
              {
                paramMotionEvent = this.app;
                localObject1 = paramView.getContext();
                i = this.vipType;
                localObject2 = this.uin;
                if (bool) {}
                for (paramView = "zlk";; paramView = "zlkkr")
                {
                  VipUtils.c(paramMotionEvent, (Context)localObject1, i, (String)localObject2, paramView);
                  return true;
                }
              }
              paramMotionEvent = this.app;
              localObject1 = paramView.getContext();
              if (bool) {}
              for (paramView = "zlk";; paramView = "zlkkr")
              {
                VipUtils.o(paramMotionEvent, (Context)localObject1, paramView);
                return true;
              }
            }
            if ("VIA_AIO_TITLE".equals(this.via))
            {
              if (this.cUI)
              {
                paramMotionEvent = this.app;
                localObject1 = paramView.getContext();
                i = this.vipType;
                localObject2 = this.uin;
                if (bool) {}
                for (paramView = "ctoc";; paramView = "ctockr")
                {
                  VipUtils.c(paramMotionEvent, (Context)localObject1, i, (String)localObject2, paramView);
                  return true;
                }
              }
              paramMotionEvent = this.app;
              localObject1 = paramView.getContext();
              if (bool) {}
              for (paramView = "ctoc";; paramView = "ctockr")
              {
                VipUtils.o(paramMotionEvent, (Context)localObject1, paramView);
                return true;
              }
            }
            if ("VIA_AIO_CHATSETTINGS".equals(this.via))
            {
              if (this.cUI)
              {
                paramMotionEvent = this.app;
                localObject1 = paramView.getContext();
                i = this.vipType;
                localObject2 = this.uin;
                if (bool) {}
                for (paramView = "ctocset";; paramView = "ctocsetkr")
                {
                  VipUtils.c(paramMotionEvent, (Context)localObject1, i, (String)localObject2, paramView);
                  return true;
                }
              }
              paramMotionEvent = this.app;
              localObject1 = paramView.getContext();
              if (bool) {}
              for (paramView = "ctocset";; paramView = "ctocsetkr")
              {
                VipUtils.o(paramMotionEvent, (Context)localObject1, paramView);
                return true;
              }
            }
            if (this.cUI)
            {
              VipUtils.c(this.app, paramView.getContext(), this.vipType, this.uin, "unknow");
              return true;
            }
            VipUtils.o(this.app, paramView.getContext(), "unknow");
            return true;
          }
          label339:
          label763:
          paramMotionEvent = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils
 * JD-Core Version:    0.7.0.1
 */