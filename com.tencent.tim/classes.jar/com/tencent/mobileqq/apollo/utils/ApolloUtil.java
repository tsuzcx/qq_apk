package com.tencent.mobileqq.apollo.utils;

import abhh;
import abhh.d;
import abkh;
import abld;
import abrj;
import abwh;
import abxh;
import abxi;
import abxk;
import abyw;
import abyx;
import acfp;
import afky;
import afqv;
import ahbj;
import ahwa;
import ahwb;
import akyr;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aofk;
import aofk.a;
import aofy;
import aqgz;
import aqhq;
import aqhu;
import aqiz;
import aqmu;
import aqoa;
import aquz;
import aqva;
import arwv;
import aurr;
import avqy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.store.ApolloStoreActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonImageView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STClickInfo;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserClickTrack;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jqp;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloUtil
{
  public static Comparator<File> J = new abyx();
  public static long OW;
  public static long OX = 100L;
  public static b a;
  private static boolean bGs;
  private static boolean bGt;
  private static boolean bGu;
  private static boolean bgw;
  public static final String bkb = abxi.bip + "action_v730.json";
  public static final String bkc = abxi.bim + "/apollo_report_config.json";
  private static int ctI = -2147483648;
  private static int ctJ;
  private static int ctK;
  public static final int[] kc = { 308, 309, 310, 318, 319, 320 };
  
  static
  {
    bgw = true;
  }
  
  public static int Ac()
  {
    if (ctI == -2147483648) {
      ctI = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getInt("MSAA_level", 0);
    }
    return ctI;
  }
  
  public static void Da(String paramString) {}
  
  public static void Db(String paramString)
  {
    ThreadManager.getUIHandler().post(new ApolloUtil.9(paramString));
  }
  
  public static void Dc(String paramString)
  {
    int i = cl(paramString);
    if (i > 0)
    {
      long l = Y(paramString);
      if (i == 17) {
        l = 1L;
      }
      abwh.a(30, paramString, 300, -100, 0L, i, l, new Object[0]);
    }
  }
  
  public static void Dd(String paramString) {}
  
  public static void De(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()))
    {
      QQToast.a(BaseActivity.sTopActivity, acfp.m(2131702682), 1).show();
      return;
    }
    QLog.d("ApolloUtil", 1, new Object[] { "replaceCmshow3dResource, filePath=", paramString });
    Object localObject2;
    Object localObject1;
    int j;
    int i;
    long l1;
    label156:
    Object localObject3;
    try
    {
      localObject2 = abxi.bim + "/tempReplace/";
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        ahbj.deleteFile((File)localObject1);
      }
      jqp.b(new File(paramString), (String)localObject2);
      j = 0;
      i = 0;
      l1 = -1L;
      paramString = ((File)localObject1).listFiles();
      l2 = l1;
      k = j;
      if (paramString == null) {
        break label564;
      }
      l2 = l1;
      k = j;
      if (paramString.length <= 0) {
        break label564;
      }
      j = 0;
      l2 = l1;
      k = i;
      if (j >= paramString.length) {
        break label564;
      }
      localObject2 = paramString[j];
      if ((((File)localObject2).isFile()) && (((File)localObject2).getName().equals("skeleton.bin")))
      {
        k = 1;
        aqhq.copyFile((File)localObject2, new File(abxi.bis + 3100045L + "/skeleton.bin"));
        l2 = l1;
      }
      else if ((((File)localObject2).isDirectory()) && (((File)localObject2).getName().equals("action")))
      {
        localObject2 = new File((File)localObject2, "action.bin");
        localObject3 = new File("/data/data/com.tencent.mobileqq/files/apollo/def/role/0/3D/sayhi/1/action.bin");
        if (((File)localObject3).exists()) {
          ((File)localObject3).delete();
        }
        aqhq.copyFile((File)localObject2, (File)localObject3);
        l2 = l1;
        k = i;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, "replaceCmshow3dResource, error=", paramString);
      QQToast.a(BaseActivity.sTopActivity, acfp.m(2131702685), 0).show();
      return;
    }
    long l2 = l1;
    int k = i;
    int m;
    if (((File)localObject2).isDirectory())
    {
      localObject2 = new File((File)localObject2, "android");
      l2 = l1;
      k = i;
      if (((File)localObject2).exists())
      {
        localObject2 = ((File)localObject2).listFiles();
        l2 = l1;
        k = i;
        if (localObject2 != null)
        {
          l2 = l1;
          k = i;
          if (localObject2.length > 0)
          {
            m = 0;
            label420:
            l2 = l1;
            k = i;
            if (m < localObject2.length)
            {
              localObject3 = localObject2[m];
              l2 = l1;
              if (!((File)localObject3).isFile()) {
                break label1084;
              }
              l2 = l1;
              if (!((File)localObject3).getName().endsWith(".zip")) {
                break label1084;
              }
              if (!((File)localObject3).getName().equals("face.zip")) {
                break label1097;
              }
              jqp.b((File)localObject3, abxi.bis + 3100045L + "/");
              l2 = l1;
              break label1084;
            }
          }
        }
      }
    }
    for (;;)
    {
      jqp.b((File)localObject3, abxi.bir + l1 + "/");
      l2 = l1;
      break label1084;
      label564:
      ahbj.deleteFile((File)localObject1);
      if (k == 0)
      {
        QQToast.a(BaseActivity.sTopActivity, acfp.m(2131702683), 0).show();
        return;
      }
      Object localObject4;
      long l4;
      if (l2 != -1L)
      {
        QLog.d("ApolloUtil", 1, new Object[] { "replaceCmshow3dResource, dressEndId=", Long.valueOf(l2) });
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = (abhh)paramString.getManager(153);
        localObject4 = paramString.getCurrentAccountUin();
        localObject2 = ((abhh)localObject1).b((String)localObject4);
        if (localObject2 == null) {
          break;
        }
        l1 = 0L;
        if (((ApolloBaseInfo)localObject2).mApollo3DDataBuffer == null) {
          break label1065;
        }
        localObject3 = new JSONObject(((ApolloBaseInfo)localObject2).mApollo3DDataBuffer);
        l3 = ((JSONObject)localObject3).optLong("ts");
        localObject3 = ((JSONObject)localObject3).optJSONObject("role");
        l1 = l3;
        if (localObject3 == null) {
          break label1065;
        }
        l4 = ((JSONObject)localObject3).optLong("id");
        l1 = l3;
      }
      label1065:
      for (long l3 = l4;; l3 = 0L)
      {
        if (l3 != 0L)
        {
          aqhq.copyFile(new File(abxi.bis + l3 + "/config.json"), new File(abxi.bis + 3100045L + "/config.json"));
          localObject3 = new JSONObject();
          l3 = System.currentTimeMillis() / 1000L;
          ((JSONObject)localObject3).put("uin", Long.parseLong((String)localObject4));
          ((JSONObject)localObject3).put("ts", l1);
          ((JSONObject)localObject3).put("sex", 0);
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("id", 3100045L);
          ((JSONObject)localObject4).put("ts", l1);
          ((JSONObject)localObject3).put("role", localObject4);
          localObject4 = new JSONArray();
          for (l3 = 3100145L; l3 <= l2; l3 += 1L)
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("id", l3);
            localJSONObject.put("ts", l1);
            ((JSONArray)localObject4).put(localJSONObject);
          }
          QQToast.a(BaseActivity.sTopActivity, acfp.m(2131702679), 0).show();
          return;
        }
        QQToast.a(BaseActivity.sTopActivity, acfp.m(2131702689), 0).show();
        return;
        ((JSONObject)localObject3).put("dresslist", localObject4);
        ((ApolloBaseInfo)localObject2).setApolloDress3D(paramString, (JSONObject)localObject3);
        ((abhh)localObject1).a((ApolloBaseInfo)localObject2);
        QQToast.a(BaseActivity.sTopActivity, acfp.m(2131702697), 0).show();
        return;
      }
      j += 1;
      l1 = l2;
      i = k;
      break label156;
      label1084:
      m += 1;
      l1 = l2;
      break label420;
      label1097:
      if (l1 == -1L) {
        l1 = 3100145L;
      } else {
        l1 += 1L;
      }
    }
  }
  
  public static void En(boolean paramBoolean)
  {
    try
    {
      File localFile = new File(abxi.bim);
      if (!localFile.exists()) {
        return;
      }
      if (!localFile.isDirectory())
      {
        QLog.e("ApolloUtil", 1, "deleteApolloResource .apollo is not directory");
        aqhq.delete(abxi.bim, false);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("ApolloUtil", 1, localException, new Object[0]);
      return;
    }
    if (paramBoolean)
    {
      aqhq.delete(abxi.bim, false);
      return;
    }
    aqhq.delete(abxi.bis, false);
    aqhq.delete(abxi.bir, false);
    aqhq.delete(abxi.bip, false);
    aqhq.delete(abxi.bjI, false);
    abhh.bfU = null;
  }
  
  public static void Is(int paramInt)
  {
    ctI = paramInt;
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit().putInt("MSAA_level", paramInt).commit();
  }
  
  public static void It(int paramInt)
  {
    if (!ij(paramInt)) {
      return;
    }
    if (afqv.kt.containsKey("3.4.4"))
    {
      Object localObject = (List)afqv.kt.get("3.4.4");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        ctK += 1;
        if (ctK >= ((List)localObject).size())
        {
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
          String str = ru();
          if (!bGs)
          {
            if (!TextUtils.isEmpty(str)) {
              ctJ = ((SharedPreferences)localObject).getInt(str, 0);
            }
            bGs = true;
          }
          ctJ += 1;
          if (!TextUtils.isEmpty(str)) {
            ((SharedPreferences)localObject).edit().putInt(str, ctJ).apply();
          }
          ctK = 0;
        }
      }
    }
    VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_view", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public static void Iu(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
    String str = ru();
    if (!TextUtils.isEmpty(str))
    {
      ctJ = 3;
      localSharedPreferences.edit().putInt(str, ctJ).apply();
    }
    ctK = 0;
    VipUtils.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "cmshow", "Apollo", "expresstab_reddot_click", 0, 0, new String[] { String.valueOf(paramInt) });
  }
  
  public static final byte[] P()
  {
    try
    {
      byte[] arrayOfByte = acfp.m(2131702684).getBytes();
      return arrayOfByte;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      QLog.e("ApolloUtil", 1, localUnsupportedCharsetException.getMessage());
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("ApolloUtil", 1, localThrowable.getMessage());
      }
    }
  }
  
  public static long Q(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0L;
  }
  
  public static boolean V(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (1036 != paramMessageRecord.istroop) {
      return false;
    }
    return true;
  }
  
  public static long Y(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    String str = paramString;
    if (paramString.contains("def/role/0/")) {
      str = ja(paramString);
    }
    paramString = new StringBuilder(8);
    int j = 0;
    if (i < str.length())
    {
      char c = str.charAt(i);
      int k;
      if ((c > '/') && (c < ':'))
      {
        paramString.append(c);
        k = 1;
      }
      do
      {
        i += 1;
        j = k;
        break;
        k = j;
      } while (j == 0);
    }
    if (j != 0) {
      return Long.parseLong(paramString.toString());
    }
    return 0L;
  }
  
  public static boolean ZA()
  {
    String str = Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "checkNotFullScreen model:" + str);
    }
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return false;
      if (!TextUtils.isEmpty(abxh.bil)) {
        return abxh.bil.contains(str);
      }
    } while (!str.contains("SM-G8870"));
    return true;
  }
  
  public static boolean ZB()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (afqv.kt.containsKey("3.4.4"))
    {
      List localList = (List)afqv.kt.get("3.4.4");
      bool1 = bool2;
      if (localList != null)
      {
        bool1 = bool2;
        if (localList.size() > 0)
        {
          if (!bGt)
          {
            bGu = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0).getBoolean(rv(), false);
            bGt = true;
          }
          if (bGu) {
            break label87;
          }
        }
      }
    }
    label87:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean Zz()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ApolloUtil", 1, "isApolloProxyEnable isPublicVersion");
    }
    return false;
  }
  
  public static int a(float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {
      return 24;
    }
    int i = a(paramFloat, paramString, 13, 3);
    if (i == 1)
    {
      if (paramInt == 2) {
        return 318;
      }
      return 308;
    }
    if (i == 2)
    {
      if (paramInt == 2) {
        return 319;
      }
      return 309;
    }
    if (paramInt == 2) {
      return 320;
    }
    return 310;
  }
  
  private static int a(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / aqgz.density);
    ((TextView)localObject).setText(paramString);
    localObject = ((TextView)localObject).getPaint();
    paramString = paramString.replaceAll("\r", "").split("\n");
    int n = paramString.length;
    int j = 0;
    int k;
    for (paramInt1 = 0; j < n; paramInt1 = k + 1)
    {
      String str = paramString[j];
      if (((Paint)localObject).measureText(str) > paramFloat)
      {
        float f1 = 0.0F;
        k = 0;
        int i = paramInt1;
        paramInt1 = k;
        for (;;)
        {
          k = i;
          if (paramInt1 == str.length()) {
            break;
          }
          float f2 = f1 + ((Paint)localObject).measureText(String.valueOf(str.charAt(paramInt1)));
          int m = paramInt1;
          f1 = f2;
          k = i;
          if (f2 > paramFloat)
          {
            k = i + 1;
            m = paramInt1 - 1;
            f1 = 0.0F;
          }
          paramInt1 = m + 1;
          i = k;
        }
      }
      k = paramInt1;
      j += 1;
    }
    if (paramInt1 < paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static int a(abxk paramabxk, int paramInt1, int paramInt2)
  {
    if (((paramabxk.dK == null) || (paramabxk.dK.size() == 0)) && (paramInt2 == 1)) {
      return gk(paramInt1);
    }
    return paramabxk.ar(paramInt1, paramInt2);
  }
  
  public static int a(SessionInfo paramSessionInfo, AppInterface paramAppInterface)
  {
    if (paramSessionInfo == null) {
      return 0;
    }
    switch (paramSessionInfo.cZ)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      if (paramAppInterface != null)
      {
        paramAppInterface = (HotChatManager)paramAppInterface.getManager(60);
        if (paramAppInterface != null)
        {
          if (paramAppInterface.kj(paramSessionInfo.troopUin)) {
            return 3;
          }
          return 1;
        }
      }
      break;
    case 3000: 
      return 2;
    case 1036: 
      return 4;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      throw new IllegalArgumentException("getPlayActionId, apolloMsg null");
    }
    int j = paramMessageForApollo.mApolloMessage.id;
    int i = j;
    if (paramMessageForApollo.mApollo3DMessage != null)
    {
      i = j;
      if (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D))
      {
        i = j;
        if (abhh.R(paramQQAppInterface)) {
          i = paramMessageForApollo.mApollo3DMessage.actionID_3D;
        }
      }
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp)
  {
    int j;
    if ((paramMessageForArkApp == null) || (paramQQAppInterface == null))
    {
      j = 0;
      return j;
    }
    paramMessageForArkApp = paramMessageForArkApp.ark_app_message;
    if ((!TextUtils.isEmpty(paramMessageForArkApp.appId)) && (!"101538890".equals(paramMessageForArkApp.appId))) {
      return 0;
    }
    paramMessageForArkApp = paramMessageForArkApp.metaList;
    if (paramMessageForArkApp == null) {
      return 0;
    }
    for (;;)
    {
      try
      {
        paramMessageForArkApp = new JSONObject(paramMessageForArkApp).optJSONObject("data");
        if (paramMessageForArkApp != null)
        {
          i = paramMessageForArkApp.optInt("actionId");
          j = i;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        try
        {
          if (i <= abxi.ctt) {
            break;
          }
          j = i;
          if (abhh.R(paramQQAppInterface)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "getShareMsgActionId 3d not available actionId:", Integer.valueOf(i) });
          }
          return 0;
        }
        catch (Exception paramQQAppInterface)
        {
          continue;
        }
        paramQQAppInterface = paramQQAppInterface;
        i = 0;
        QLog.e("ApolloUtil", 1, paramQQAppInterface, new Object[0]);
        return i;
      }
      int i = 0;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null)) {}
    int i;
    do
    {
      return 0;
      i = abhh.x(paramQQAppInterface);
    } while (i == 0);
    int j = abhh.h(paramQQAppInterface, paramMessageRecord.senderuin);
    if (((j == 2) && (abhh.R(paramQQAppInterface))) || ((j == 0) && (i == 2))) {
      return 2;
    }
    return 1;
  }
  
  public static abhh a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return (abhh)localQQAppInterface.getManager(153);
    }
    return null;
  }
  
  public static Bitmap a(AppInterface paramAppInterface, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (paramAppInterface == null)) {
      return null;
    }
    if (paramStartCheckParam.game != null) {}
    for (Object localObject1 = paramStartCheckParam.game.logoUrl;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = String.format(Locale.getDefault(), "https://i.hudongcdn.com/%1$d/sp_main_1_1.png", new Object[] { Integer.valueOf(paramStartCheckParam.gameId) });
      }
      localObject1 = new File(abxi.biF + paramStartCheckParam.gameId + File.separator + abxi.biI);
      if (!((File)localObject1).exists())
      {
        ((File)localObject1).getParentFile().mkdir();
        localObject2 = new aquz((String)localObject2, (File)localObject1);
        ((aquz)localObject2).cWy = false;
        ((aquz)localObject2).cWw = true;
        ((aquz)localObject2).cxX = "apollo_res";
        ((aquz)localObject2).retryCount = 1;
        ((aquz)localObject2).cWz = true;
        ((aquz)localObject2).cWA = true;
        int i = aqva.a((aquz)localObject2, paramAppInterface);
        QLog.i("ApolloUtil", 1, "getGameIcon onDone gameId:" + paramStartCheckParam.gameId + " result:" + i);
        if (i != 0) {
          break;
        }
        return BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
      }
      if (QLog.isColorLevel()) {
        QLog.i("ApolloUtil", 1, "getGameIcon file exists gameId:" + paramStartCheckParam.gameId);
      }
      return BitmapFactory.decodeFile(((File)localObject1).getAbsolutePath());
    }
  }
  
  public static ApolloCmdChannel a()
  {
    Object localObject = a();
    if (localObject != null) {
      return ApolloCmdChannel.getChannel((QQAppInterface)localObject);
    }
    localObject = b();
    if (localObject != null) {
      return ApolloCmdChannel.getChannelFromOtherProcess((AppRuntime)localObject);
    }
    QLog.e("ApolloUtil", 1, "getCmdChannel app is null");
    return null;
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      a.Pb = Runtime.getRuntime().freeMemory();
      a.OZ = Runtime.getRuntime().maxMemory();
      a.Pa = Runtime.getRuntime().totalMemory();
      b localb = a;
      return localb;
    }
    catch (Exception localException)
    {
      QLog.e("ApolloUtil", 1, "getHardwareInfo e:", localException);
    }
    return null;
  }
  
  public static QQAppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  public static ApolloUserTrace.STUserTrackReq a(String paramString)
  {
    ApolloUserTrace.STUserTrackReq localSTUserTrackReq = new ApolloUserTrace.STUserTrackReq();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localSTUserTrackReq;
      try
      {
        long l1 = System.currentTimeMillis();
        paramString = new JSONObject(paramString);
        localSTUserTrackReq.strFrom.set(paramString.optString("from"));
        localSTUserTrackReq.playts.set(paramString.optInt("playts"));
        localSTUserTrackReq.roomId.set(paramString.optLong("roomId"));
        localSTUserTrackReq.gameId.set(paramString.optInt("gameId"));
        if (paramString.has("userTrack"))
        {
          Object localObject = paramString.getJSONObject("userTrack");
          paramString = new ApolloUserTrace.STUserClickTrack();
          paramString.name.set(((JSONObject)localObject).optString("name"));
          paramString.screenScale.set(((JSONObject)localObject).optInt("screenscale"));
          paramString.screenX.set(((JSONObject)localObject).optInt("screenwidth"));
          paramString.screenY.set(((JSONObject)localObject).optInt("screenheight"));
          paramString.time.set(((JSONObject)localObject).optInt("time"));
          if (((JSONObject)localObject).has("record"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("record");
            if ((localObject == null) || (((JSONArray)localObject).length() == 0)) {
              continue;
            }
            int i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
              ApolloUserTrace.STClickInfo localSTClickInfo = new ApolloUserTrace.STClickInfo();
              localSTClickInfo.posx.set(localJSONObject.optInt("posx"));
              localSTClickInfo.angularvel.set(localJSONObject.optInt("angularvel"));
              localSTClickInfo.btnstate.set(localJSONObject.optInt("btnstate"));
              localSTClickInfo.time.set(localJSONObject.optInt("time"));
              localSTClickInfo.rotx.set(localJSONObject.optInt("rotx"));
              localSTClickInfo.velx.set(localJSONObject.optInt("velx"));
              localSTClickInfo.vely.set(localJSONObject.optInt("vely"));
              localSTClickInfo.roty.set(localJSONObject.optInt("roty"));
              localSTClickInfo.posy.set(localJSONObject.optInt("posy"));
              paramString.list.add(localSTClickInfo);
              i += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ApolloUtil", 2, "trace.len:" + paramString.list.size());
            }
          }
          localSTUserTrackReq.userClick.set(paramString);
        }
        else
        {
          long l2 = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloUtil", 2, "trace parsing cost:" + (l2 - l1));
            return localSTUserTrackReq;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ApolloUtil", 1, "errInfo->" + paramString.getMessage());
      }
    }
    return localSTUserTrackReq;
  }
  
  public static String a(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
      return "";
    }
    String[] arrayOfString = paramString.replaceAll("\r", "").split("\n");
    StringBuilder localStringBuilder = new StringBuilder();
    int n = arrayOfString.length;
    int m = 0;
    int i = 0;
    if (m < n)
    {
      String str = arrayOfString[m];
      if (paramPaint.measureText(str) <= paramFloat) {
        localStringBuilder.append(str);
      }
      float f;
      int k;
      label119:
      do
      {
        localStringBuilder.append("\n");
        m += 1;
        break;
        j = 0;
        f = 0.0F;
        k = 0;
        i = k;
      } while (j == str.length());
      char c = str.charAt(j);
      f += paramPaint.measureText(String.valueOf(c));
      if (f <= paramFloat) {
        localStringBuilder.append(c);
      }
      for (;;)
      {
        j += 1;
        break label119;
        k += 1;
        i = k;
        if (k >= paramInt) {
          break;
        }
        localStringBuilder.append("\n");
        j -= 1;
        f = 0.0F;
      }
    }
    if (!paramString.endsWith("\n")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    int j = localStringBuilder.length();
    paramFloat = paramPaint.measureText(String.valueOf("…"));
    if (i >= paramInt) {
      paramInt = j;
    }
    for (;;)
    {
      if (paramInt >= 1)
      {
        if (paramPaint.measureText(localStringBuilder.substring(paramInt - 1, j)) >= paramFloat) {
          localStringBuilder.replace(paramInt - 1, j, "…");
        }
      }
      else {
        return localStringBuilder.toString();
      }
      paramInt -= 1;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject;
    if (paramMessageForApollo == null) {
      localObject = acfp.m(2131702693);
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        localObject = c(paramQQAppInterface, paramMessageForApollo);
        str1 = acfp.m(2131702694) + (String)localObject;
        str2 = acfp.m(2131702691);
        localObject = str1;
      } while (!ApolloGameUtil.ib(paramMessageForApollo.msgType));
      localObject = str1;
    } while (!a(paramQQAppInterface, paramMessageForApollo));
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      return str2 + paramMessageForApollo.gameName;
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = ((abxk)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.gameId);
      if (paramQQAppInterface != null) {
        return str2 + paramQQAppInterface.name;
      }
      return str2 + acfp.m(2131702687);
    }
    return str2 + acfp.m(2131702675);
  }
  
  public static String a(ApolloActionData paramApolloActionData, int paramInt)
  {
    if (paramApolloActionData == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(abxi.bip).append(paramApolloActionData.actionId).append(File.separator).append("panelView.png");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.png");
      continue;
      localStringBuilder.append(abxi.bip).append(paramApolloActionData.actionId).append(File.separator).append("panelGif.gif");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/preview.gif");
      continue;
      localStringBuilder.append(abxi.bip).append(paramApolloActionData.actionId).append(File.separator).append("actionRes.zip");
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_action_").append(paramApolloActionData.actionId).append("/d.zip");
      continue;
      localStringBuilder.append(abxi.bip).append(paramApolloActionData.actionId).append(File.separator);
      continue;
      localStringBuilder.append(abxi.bip).append(paramApolloActionData.actionId).append(File.separator).append("config.json");
      continue;
      localStringBuilder.append(abxi.biD).append(paramApolloActionData.actionId);
      continue;
      localStringBuilder.append("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_").append(paramApolloActionData.actionId).append("/d.zip");
    }
  }
  
  public static String a(ApolloActionPackage paramApolloActionPackage)
  {
    if (paramApolloActionPackage == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(abxi.biA).append(paramApolloActionPackage.packageId).append(File.separator).append("tab.png");
    return localStringBuilder.toString();
  }
  
  public static ArrayList a(SparseArray paramSparseArray)
  {
    Object localObject;
    if ((paramSparseArray == null) || (paramSparseArray.size() == 0))
    {
      localObject = new ArrayList();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramSparseArray.size();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= j) {
        break;
      }
      localArrayList.add(paramSparseArray.get(paramSparseArray.keyAt(i)));
      i += 1;
    }
  }
  
  private static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null)) {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "eggaction", gi(paramSessionInfo.cZ), 0, new String[] { String.valueOf(paramInt), paramString });
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    a(paramContext, paramIntent, paramString1, paramString2, paramAppInterface, 0);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString1, String paramString2, AppInterface paramAppInterface, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = null;
    Object localObject;
    if (paramAppInterface == null)
    {
      localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        localObject = ((BaseApplicationImpl)localObject).getRuntime();
        if ((localObject != null) && ((localObject instanceof AppInterface))) {
          paramAppInterface = (AppInterface)localObject;
        }
      }
    }
    for (;;)
    {
      localObject = localIntent;
      if (paramAppInterface != null)
      {
        localObject = localIntent;
        if ((paramAppInterface instanceof QQAppInterface)) {
          localObject = (abhh)((QQAppInterface)paramAppInterface).getManager(153);
        }
      }
      if (!abhh.aW(paramContext))
      {
        paramIntent = new Intent(paramContext, QQBrowserActivity.class);
        paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
        VasWebviewUtil.openQQBrowserActivity(paramContext, abxi.bjh, -1L, paramIntent, false, -1);
        return;
        if ((localObject instanceof ToolAppRuntime))
        {
          localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
          if ((localObject instanceof AppInterface)) {
            paramAppInterface = (AppInterface)localObject;
          }
        }
      }
      else
      {
        if ((1 != abhh.a(paramAppInterface)) || ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (!ApolloGameUtil.Z((QQAppInterface)paramAppInterface))))
        {
          paramIntent = new Intent(paramContext, QQBrowserActivity.class);
          paramIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramContext, abxi.bji + "0", -1L, paramIntent, false, -1);
          return;
        }
        localIntent = paramIntent;
        if (paramIntent == null) {
          localIntent = new Intent();
        }
        if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface)) && (abhh.R((QQAppInterface)paramAppInterface))) {}
        for (int i = 1;; i = 0)
        {
          paramIntent = paramString2;
          if (!TextUtils.isEmpty(paramString2))
          {
            paramIntent = paramString2;
            if (paramString2.contains("tab=3d"))
            {
              paramIntent = paramString2;
              if (i == 0) {
                paramIntent = abxi.bjv;
              }
            }
          }
          paramString2 = paramIntent;
          if (!TextUtils.isEmpty(abxi.bjv))
          {
            paramString2 = paramIntent;
            if (abxi.bjv.equals(paramIntent))
            {
              paramString2 = paramIntent;
              if (i != 0) {
                paramString2 = abxi.bjD;
              }
            }
          }
          if (localIntent.getIntExtra("key_box_type", 0) != 3) {
            break;
          }
          paramIntent = abxi.bjq;
          paramString1 = new Intent(paramContext, QQBrowserActivity.class);
          localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(paramContext, paramIntent, -1L, paramString1, false, -1);
          return;
        }
        if (paramAppInterface != null)
        {
          paramIntent = paramAppInterface.getCurrentNickname();
          paramAppInterface.getLongAccountUin();
        }
        for (;;)
        {
          localIntent.putExtra("extra_key_nickname", paramIntent);
          if (!TextUtils.isEmpty(paramString1)) {
            localIntent.putExtra("extra_key_adtag", paramString1);
          }
          localIntent.putExtra("extra_key_click_time", System.currentTimeMillis());
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, "apollo_client, clickTime:" + aqmu.getFormatTime(System.currentTimeMillis(), "dd-MMM-yyyy HH:mm:ss:SSS") + ",url:" + paramString2);
          }
          if (!TextUtils.isEmpty(paramString2))
          {
            paramString1 = paramString2.replace("_bid=2423&", "");
            paramIntent = paramString1;
            if (abld.bDC)
            {
              if (TextUtils.isEmpty(abld.tips))
              {
                paramIntent = aurr.addParameter(paramString1, "wording", abld.content);
                paramIntent = aurr.addParameter(aurr.addParameter(paramIntent, "bubble_id", abld.bubbleId), "tip_url", abld.url);
              }
            }
            else
            {
              if (localObject == null) {
                break label1055;
              }
              if (!((abhh)localObject).bCD) {
                break label822;
              }
              paramString1 = "1";
              label625:
              paramString1 = aurr.addParameter(paramIntent, "is_new_store_user", paramString1);
              if (i == 0) {
                break label829;
              }
              paramIntent = "1";
              label643:
              paramIntent = aurr.addParameter(paramString1, "is_3d_available", paramIntent);
            }
          }
          label909:
          label1043:
          label1050:
          label1055:
          for (;;)
          {
            if (localIntent.getBooleanExtra("extra_key_open_box", false)) {
              if (abhh.Yd()) {
                localIntent.putExtra("extra_key_open_box", false);
              }
            }
            for (paramIntent = aurr.addParameter(paramIntent, "boxReady", "1");; paramIntent = aurr.addParameter(paramIntent, "boxReady", "0"))
            {
              localIntent.putExtra("url", paramIntent);
              localIntent.putExtra("url", paramIntent);
              if ((!paramIntent.contains("webviewCheckType=1")) && (!paramIntent.contains("webviewCheckType=2"))) {
                break label1015;
              }
              localIntent.setClass(paramContext, ApolloStoreActivity.class);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
              }
              label756:
              if (!(paramContext instanceof Activity)) {
                localIntent.addFlags(268435456);
              }
              localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
              if ((!(paramContext instanceof Activity)) || (paramInt <= 0)) {
                break label1043;
              }
              ((Activity)paramContext).startActivityForResult(localIntent, paramInt);
              return;
              paramIntent = aurr.addParameter(paramString1, "wording", abld.tips);
              break;
              label822:
              paramString1 = "0";
              break label625;
              label829:
              paramIntent = "0";
              break label643;
            }
            if (!TextUtils.isEmpty(abxi.bju))
            {
              paramIntent = abxi.bju;
              label863:
              paramString1 = paramIntent.replace("_bid=2423&", "");
              if (localObject == null) {
                break label1050;
              }
              if (!((abhh)localObject).bCD) {
                break label987;
              }
              paramIntent = "1";
              label891:
              paramString1 = aurr.addParameter(paramString1, "is_new_store_user", paramIntent);
              if (i == 0) {
                break label994;
              }
              paramIntent = "1";
            }
            for (paramIntent = aurr.addParameter(paramString1, "is_3d_available", paramIntent);; paramIntent = paramString1)
            {
              if (localIntent.getBooleanExtra("extra_key_open_box", false)) {
                if (abhh.Yd()) {
                  localIntent.putExtra("extra_key_open_box", false);
                }
              }
              for (paramIntent = aurr.addParameter(paramIntent, "boxReady", "1");; paramIntent = aurr.addParameter(paramIntent, "boxReady", "0"))
              {
                localIntent.putExtra("url", paramIntent);
                localIntent.putExtra("url", paramIntent);
                break;
                paramIntent = abxi.bjj;
                break label863;
                label987:
                paramIntent = "0";
                break label891;
                label994:
                paramIntent = "0";
                break label909;
              }
              label1015:
              localIntent.setClass(paramContext, ApolloStoreActivity.class);
              if (!QLog.isColorLevel()) {
                break label756;
              }
              QLog.d("ApolloUtil", 2, "apollo_client, ApolloStoreActivity");
              break label756;
              paramContext.startActivity(localIntent);
              return;
            }
          }
          paramIntent = "";
        }
      }
    }
  }
  
  public static void a(View paramView, QQAppInterface paramQQAppInterface, aqoa paramaqoa) {}
  
  public static void a(View paramView, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface) {}
  
  public static void a(ImageView paramImageView, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramImageView.setImageResource(2130838663);
  }
  
  public static void a(aqoa paramaqoa, String paramString) {}
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, aofk paramaofk, List<Integer> paramList)
  {
    if ((paramQQAppInterface == null) || (paramaofk == null)) {}
    long l1;
    Object localObject;
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while (!abhh.Ye());
      l1 = System.currentTimeMillis();
      paramaofk = paramaofk.trim();
      localObject = (abxk)paramQQAppInterface.getManager(155);
      localHashMap = ((abxk)localObject).C();
    } while ((localHashMap == null) || (localHashMap.size() == 0));
    int i1 = ((abxk)localObject).zY();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      int m;
      if (i < paramaofk.length()) {
        m = i1;
      }
      int n;
      for (;;)
      {
        n = i;
        k = j;
        if (m > 0)
        {
          if (i + m <= paramaofk.length())
          {
            localObject = paramaofk.substring(i, i + m);
            if (localHashMap.containsKey(localObject))
            {
              paramList.add(localHashMap.get(localObject));
              a(((Integer)localHashMap.get(localObject)).intValue(), (String)localObject, paramQQAppInterface, paramSessionInfo);
              n = m - 1 + i;
              k = j + 1;
            }
          }
        }
        else
        {
          if (k != 30) {
            break label264;
          }
          long l2 = System.currentTimeMillis();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloUtil", 2, new Object[] { "getKeywordsActionList costTime:", Long.valueOf(l2 - l1), ", actionList:", paramList, ", actionCount:", Integer.valueOf(paramList.size()) });
          return;
        }
        m -= 1;
      }
      label264:
      i = n + 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramChatMessage == null)) {
      QLog.e("ApolloUtil", 1, "[playShareMsgAction] param null, abort");
    }
    while ((paramSessionInfo.cZ != 0) && (paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000)) {
      return;
    }
    paramSessionInfo = paramChatMessage.getExtInfoFromExtStr("is_share_ark_message_action_checked");
    if ((!TextUtils.isEmpty(paramSessionInfo)) && ("1".equals(paramSessionInfo))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, new Object[] { "[playShareMsgAction] share ark action isChecked:", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramChatMessage.uniseq) });
      }
      if (bool) {
        break;
      }
      paramChatMessage.saveExtInfoToExtStr("is_share_ark_message_action_checked", "1");
      ThreadManager.excute(new ApolloUtil.4(paramChatMessage, paramInt1, paramInt2, paramQQAppInterface), 96, null, false);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, AnimationTextView paramAnimationTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (paramChatMessage == null) || (paramAnimationTextView == null)) {
      QLog.e("ApolloUtil", 1, "[playApolloEmoticonAction] param null, abort");
    }
    while ((paramSessionInfo.cZ != 0) && (paramSessionInfo.cZ != 1) && (paramSessionInfo.cZ != 3000)) {
      return;
    }
    Object localObject3 = null;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = localObject3;
      if (TextUtils.isEmpty(paramChatMessage.extStr)) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramChatMessage.extStr).optString("is_apollo_emoticon_action_checked");
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!"1".equals(localObject1))) {
          break label436;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo emoticon action played=", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramChatMessage.uniseq), ", position=", Integer.valueOf(paramInt1), ", itemCount=", Integer.valueOf(paramInt2), ", isLongMsg=", Boolean.valueOf(paramBoolean) });
        }
        if (bool) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "[playApolloEmoticonAction] set apollo emoticon action play status true");
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_checked", "1");
        ThreadManager.post(new ApolloUtil.2(paramChatMessage), 5, null, false);
        if (paramInt1 != paramInt2 - 1) {
          break;
        }
        if (abhh.ce("whiteFace3D") != 1) {
          break label442;
        }
        paramBoolean = true;
        if ((abhh)paramQQAppInterface.getManager(153) == null) {
          break;
        }
        paramInt1 = a(paramQQAppInterface, paramChatMessage);
        if (paramInt1 == 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] apollo status open, grab action playModel:", Integer.valueOf(paramInt1), ",is3DWhiteFaceOpen:", Boolean.valueOf(paramBoolean) });
        }
        localObject1 = (abxk)paramQQAppInterface.getManager(155);
        paramAnimationTextView = paramAnimationTextView.getText();
        if ((paramAnimationTextView == null) || (!(paramAnimationTextView instanceof aofk))) {
          break;
        }
        paramChatMessage.saveExtInfoToExtStr("is_apollo_emoticon_action_played", "2");
        ThreadManager.post(new ApolloUtil.3(paramInt1, paramBoolean, paramAnimationTextView, (abxk)localObject1, paramQQAppInterface, paramSessionInfo, paramChatMessage), 5, null, false);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloUtil", 1, "[playApolloEmoticonAction] json error, ", localException);
        localObject2 = localObject3;
        continue;
      }
      Object localObject2 = paramChatMessage.getExtInfoFromExtStr("is_apollo_emoticon_action_checked");
      continue;
      label436:
      boolean bool = false;
      continue;
      label442:
      paramBoolean = false;
    }
  }
  
  public static void a(MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramMessageForApollo != null) && (paramQQAppInterface != null)) {
      ThreadManager.getFileThreadHandler().post(new ApolloUtil.1(paramMessageForApollo, paramQQAppInterface, paramString, paramInt));
    }
  }
  
  public static void a(String paramString1, String paramString2, a parama) {}
  
  public static boolean a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    boolean bool = true;
    Object localObject = new StringBuilder(abxi.bip + paramInt1);
    ((StringBuilder)localObject).append(File.separator);
    if (paramBoolean1) {
      ((StringBuilder)localObject).append("action_peer");
    }
    for (;;)
    {
      ((StringBuilder)localObject).append(File.separator).append("action");
      ((StringBuilder)localObject).append(File.separator).append(paramInt2);
      if (paramBoolean2) {
        ((StringBuilder)localObject).append(File.separator).append("android");
      }
      localObject = new File(((StringBuilder)localObject).toString());
      if (((File)localObject).exists()) {
        break;
      }
      QLog.e("ApolloUtil", 1, "dir NOT exist." + ((File)localObject).getPath());
      return false;
      ((StringBuilder)localObject).append("action");
    }
    if ((jN(((File)localObject).getAbsolutePath() + File.separator + "action.json")) && (jN(((File)localObject).getAbsolutePath() + File.separator + "action.atlas")) && (jN(((File)localObject).getAbsolutePath() + File.separator + "action.png"))) {}
    for (paramBoolean1 = bool;; paramBoolean1 = false) {
      return paramBoolean1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramView != null) && (paramView.getVisibility() == 0))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloUtil", 2, "apollo_client view is visible preloadWebProcess apolloOpen:true");
        bool2 = bool1;
      }
      return bool2;
    }
    if (paramQQAppInterface == null) {
      return false;
    }
    if ((abhh.b(paramQQAppInterface, "drawer", null) > 0) && (abhh.a(BaseApplicationImpl.getContext(), Boolean.valueOf(false)))) {}
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloUtil", 2, "apollo_client preloadWebProcess apolloOpen:" + bool1);
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, List<Integer> paramList)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    Object localObject;
    int j;
    if ((paramMessageRecord instanceof MessageForText))
    {
      localObject = paramMessageRecord.msg;
      j = a(paramQQAppInterface, paramMessageRecord);
      if (abhh.ce("whiteFace3D") != 1) {
        break label250;
      }
      i = 1;
      label39:
      if ((j != 2) || (i != 0)) {
        break label293;
      }
    }
    label293:
    for (int i = 0;; i = 1)
    {
      if (j == 0) {
        QLog.w("ApolloUtil", 1, "getActionListFormMessage err user status");
      }
      paramMessageRecord = (abxk)paramQQAppInterface.getManager(155);
      localObject = new aofk((CharSequence)localObject, 2);
      aofk.a[] arrayOfa = (aofk.a[])((aofk)localObject).getSpans(0, ((aofk)localObject).length(), aofk.a.class);
      if ((arrayOfa != null) && (arrayOfa.length > 0) && (i != 0))
      {
        int k = arrayOfa.length;
        i = 0;
        for (;;)
        {
          if (i < k)
          {
            int m = arrayOfa[i].getIndex();
            if (aofy.jq(m))
            {
              m = afky.hl(m);
              if (m >= 0)
              {
                m = a(paramMessageRecord, m, j);
                if (m > 0) {
                  paramList.add(Integer.valueOf(m));
                }
              }
            }
            i += 1;
            continue;
            if (!(paramMessageRecord instanceof MessageForLongMsg)) {
              break;
            }
            localObject = (MessageForLongMsg)paramMessageRecord;
            if (TextUtils.isEmpty(((MessageForLongMsg)localObject).sb2)) {}
            for (localObject = ((MessageForLongMsg)localObject).sb;; localObject = ((MessageForLongMsg)localObject).sb2) {
              break;
            }
            label250:
            i = 0;
            break label39;
          }
        }
      }
      if ((paramList.size() == 0) && (1 == abhh.x(paramQQAppInterface))) {
        a(paramQQAppInterface, paramSessionInfo, (aofk)localObject, paramList);
      }
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject2 = null;
    if ((paramMessageForApollo == null) || (paramQQAppInterface == null)) {
      return false;
    }
    Object localObject1 = (abxk)paramQQAppInterface.getManager(155);
    if (ApolloGameUtil.ib(paramMessageForApollo.msgType)) {}
    for (localObject1 = ((abxk)localObject1).a(paramMessageForApollo.gameId);; localObject1 = null)
    {
      if ((abhh.ce("gameSwitch") != 1) || ((localObject1 != null) && (!abxh.l("3.4.4", ((ApolloGameData)localObject1).minVer, ((ApolloGameData)localObject1).maxVer))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloUtil", 2, "play apollo game msg but switch is 0 or version is incorrect");
        }
        return false;
      }
      if (paramQQAppInterface.getApp() == null) {}
      for (paramQQAppInterface = localObject2; (abhh.aV(paramQQAppInterface)) && (paramMessageForApollo.istroop == 3000) && (abhh.ce("discuss") == 0); paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext()) {
        return false;
      }
      return true;
    }
  }
  
  public static boolean a(ApolloActionData paramApolloActionData)
  {
    if (paramApolloActionData == null) {}
    boolean bool;
    do
    {
      return false;
      bool = true;
      if (!ahbj.isFileExists(a(paramApolloActionData, 0))) {
        bool = false;
      }
    } while (!aF(paramApolloActionData.actionId, paramApolloActionData.personNum));
    return bool;
  }
  
  public static String[] a(float paramFloat1, float paramFloat2, List<abkh> paramList)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "-1";
    arrayOfString[1] = "";
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      abkh localabkh = (abkh)((Iterator)localObject).next();
      if ((localabkh.su > 0.0F) && (localabkh.st > 0.0F) && (paramFloat1 >= localabkh.sr) && (paramFloat1 <= localabkh.sr + localabkh.st) && (paramFloat2 >= localabkh.ss) && (paramFloat2 <= localabkh.ss + localabkh.su))
      {
        arrayOfString[0] = "2";
        if (TextUtils.isEmpty(localabkh.bgL)) {}
        for (paramList = localabkh.name;; paramList = localabkh.bgL)
        {
          arrayOfString[1] = paramList;
          return arrayOfString;
        }
      }
    }
    paramList = paramList.iterator();
    label451:
    do
    {
      if (paramList.hasNext())
      {
        localObject = (abkh)paramList.next();
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSkeletonBounding", 2, "x:" + ((abkh)localObject).x + ",y = " + ((abkh)localObject).y + ",width = " + ((abkh)localObject).width + ",heigth = " + ((abkh)localObject).height);
        }
        if ((paramFloat1 < ((abkh)localObject).x) || (paramFloat1 > ((abkh)localObject).x + ((abkh)localObject).width) || (paramFloat2 < ((abkh)localObject).y) || (paramFloat2 > ((abkh)localObject).y + ((abkh)localObject).height)) {
          continue;
        }
        arrayOfString[0] = "1";
        if (!TextUtils.isEmpty(((abkh)localObject).bgL)) {
          break label451;
        }
      }
      for (paramList = ((abkh)localObject).name;; paramList = ((abkh)localObject).bgL)
      {
        arrayOfString[1] = paramList;
        if ((paramFloat1 >= ((abkh)localObject).sn) && (paramFloat1 <= ((abkh)localObject).sn + ((abkh)localObject).sp) && (paramFloat2 >= ((abkh)localObject).so))
        {
          paramFloat1 = ((abkh)localObject).so;
          if (paramFloat2 <= ((abkh)localObject).sq + paramFloat1) {
            arrayOfString[0] = "1000";
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloSkeletonBounding", 2, "mNode:" + arrayOfString[0] + ",mApolloId = " + arrayOfString[1]);
        }
        return arrayOfString;
      }
    } while ((paramFloat1 < ((abkh)localObject).sn) || (paramFloat1 > ((abkh)localObject).sn + ((abkh)localObject).sp) || (paramFloat2 < ((abkh)localObject).so) || (paramFloat2 > ((abkh)localObject).so + ((abkh)localObject).sq));
    arrayOfString[0] = "1000";
    if (TextUtils.isEmpty(((abkh)localObject).bgL)) {}
    for (paramList = ((abkh)localObject).name;; paramList = ((abkh)localObject).bgL)
    {
      arrayOfString[1] = paramList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloSkeletonBounding", 2, "mNode:" + arrayOfString[0] + ",mApolloId = " + arrayOfString[1]);
      break;
    }
  }
  
  public static void aEf()
  {
    bGs = false;
    ctJ = 0;
    ctK = 0;
    bGt = false;
    bGu = false;
    EmoticonImageView.HS(false);
    bgw = true;
  }
  
  public static boolean aF(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isActionResDone], actionId:" + paramInt1 + ",personNum:" + paramInt2);
    }
    File localFile = new File(abxi.bip + paramInt1);
    if (paramInt1 < 21) {
      localFile = new File(abxi.bio, "/def/basic/action/" + paramInt1);
    }
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
    }
    label359:
    do
    {
      for (;;)
      {
        return false;
        if (paramInt1 >= abxi.ctt)
        {
          if (jN(localFile.getAbsolutePath() + "/action/" + abxi.bje))
          {
            if (paramInt2 == 0) {
              return true;
            }
            if (paramInt2 == 1) {
              return jN(localFile.getAbsolutePath() + "/action_peer/" + abxi.bje);
            }
          }
        }
        else
        {
          if ((jN(localFile.getAbsolutePath() + "/" + abxi.biK)) && (jN(localFile.getAbsolutePath() + "/" + abxi.biL)) && (jN(localFile.getAbsolutePath() + "/" + abxi.biJ))) {}
          for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
          {
            if (paramInt2 != 0) {
              break label359;
            }
            return true;
          }
        }
      }
    } while (paramInt2 != 1);
    if ((jN(localFile.getAbsolutePath() + "/" + abxi.biN)) && (jN(localFile.getAbsolutePath() + "/" + abxi.biO)) && (jN(localFile.getAbsolutePath() + "/" + abxi.biM))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean aG(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return false;
    case 1: 
      return ih(paramInt2);
    }
    return ig(paramInt2);
  }
  
  public static boolean aH(int paramInt1, int paramInt2)
  {
    String str = "";
    int i;
    if (paramInt2 > abxi.ctt)
    {
      i = 1;
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label54;
      }
      return jM(str);
      i = 0;
      break;
      str = dr(paramInt2);
    }
    label54:
    return jL(str);
  }
  
  public static String aI(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("ApolloUtil", 2, paramString1.getMessage());
    }
    return "";
  }
  
  public static boolean aI(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if ((aJ(0, paramInt2)) || (aJ(paramInt1, paramInt2))) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean aJ(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isBubbleRscExist], roleId:" + paramInt1 + ",bubbleId:" + paramInt2);
    }
    if (paramInt1 == 0) {}
    for (File localFile1 = new File(abxi.bio, "/def/role/" + paramInt1);; localFile1 = new File(abxi.bis + paramInt1))
    {
      localFile1 = new File(localFile1, abxi.biS + "/" + paramInt2);
      if (localFile1.exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
      return false;
    }
    File localFile2 = new File(localFile1, abxi.biQ);
    if (!localFile2.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_ATLAS_NAME NOT exist. " + localFile2.getPath());
      }
      return false;
    }
    if (localFile2.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile2.getPath() + ",lenght is 0.");
      }
      localFile2.delete();
      return false;
    }
    localFile2 = new File(localFile1, abxi.biR);
    if (!localFile2.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_ATLAS_NAME NOT exist." + localFile2.getPath());
      }
      return false;
    }
    if (localFile2.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile2.getPath() + ",lenght is 0.");
      }
      localFile2.delete();
      return false;
    }
    localFile1 = new File(localFile1, abxi.biP);
    if (!localFile1.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "BUBBLE_FILE_PNG_NAME NOT exist." + localFile1.getPath());
      }
      return false;
    }
    if (localFile1.length() == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + localFile1.getPath() + ",lenght is 0.");
      }
      localFile1.delete();
      return false;
    }
    return true;
  }
  
  public static void ab(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    try
    {
      paramView.setBackgroundResource(paramInt);
      return;
    }
    catch (Exception paramView) {}catch (OutOfMemoryError paramView) {}
  }
  
  public static Bitmap au()
  {
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130838600);
    if ((localDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)localDrawable).getBitmap();
    }
    return null;
  }
  
  public static int b(float paramFloat, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    do
    {
      return 24;
      int i = b(paramFloat, paramString, 17, 3);
      if (i == 0)
      {
        if (paramInt == 2) {
          return 71;
        }
        return 22;
      }
      if (i == 1)
      {
        if (paramInt == 2) {
          return 72;
        }
        return 23;
      }
    } while (paramInt != 2);
    return 73;
  }
  
  private static int b(float paramFloat, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new TextView(BaseApplicationImpl.getContext());
    ((TextView)localObject).setTextSize(paramInt1 * 3 / aqgz.density);
    ((TextView)localObject).setText(paramString);
    localObject = ((TextView)localObject).getPaint();
    paramString = paramString.replaceAll("\r", "").split("\n");
    int n = paramString.length;
    int k = 0;
    int j = 0;
    if (k < n)
    {
      String str = paramString[k];
      float f1;
      if (((Paint)localObject).measureText(str) > paramFloat)
      {
        paramInt1 = 0;
        f1 = 0.0F;
      }
      for (int i = 0;; i = j)
      {
        j = i;
        if (paramInt1 != str.length())
        {
          float f2 = f1 + ((Paint)localObject).measureText(String.valueOf(str.charAt(paramInt1)));
          m = paramInt1;
          f1 = f2;
          j = i;
          if (f2 <= paramFloat) {
            break label177;
          }
          j = i + 1;
          if (j < paramInt2) {}
        }
        else
        {
          k += 1;
          break;
        }
        int m = paramInt1 - 1;
        f1 = 0.0F;
        label177:
        paramInt1 = m + 1;
      }
    }
    return j;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      throw new IllegalArgumentException("getPlayActionType, apolloMsg null");
    }
    int i = paramMessageForApollo.actionType;
    if ((paramMessageForApollo.mApollo3DMessage != null) && (ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D)))
    {
      if (abhh.R(paramQQAppInterface)) {
        return paramMessageForApollo.mApollo3DMessage.actionType_3D;
      }
      paramQQAppInterface = ((abxk)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.mApolloMessage.id);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.actionType;
      }
    }
    return i;
  }
  
  public static File b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    paramString1 = new File(paramString1);
    if ((paramString1 == null) || (!paramString1.isDirectory())) {
      return null;
    }
    paramString1 = paramString1.listFiles();
    if (paramString1 == null) {
      return null;
    }
    int i = 0;
    while (i < paramString1.length)
    {
      File localFile = paramString1[i];
      if ((localFile.isFile()) && (localFile.getPath().substring(localFile.getPath().length() - paramString2.length()).equals(paramString2))) {
        return localFile;
      }
      i += 1;
    }
    return null;
  }
  
  public static String b(Paint paramPaint, float paramFloat, String paramString, int paramInt)
  {
    int m = 0;
    if ((TextUtils.isEmpty(paramString)) || (paramPaint == null) || (paramFloat <= 0.0F)) {
      return "";
    }
    Object localObject = paramString.replaceAll("\r", "").split("\n");
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = localObject.length;
    int k = 0;
    int i = 0;
    String str;
    if (k < i1)
    {
      str = localObject[k];
      if (paramPaint.measureText(str) <= paramFloat) {
        localStringBuilder.append(str);
      }
    }
    for (;;)
    {
      localStringBuilder.append("\n");
      k += 1;
      i += 1;
      break;
      float f = 0.0F;
      int n = 0;
      int j = i;
      i = n;
      if (i != str.length())
      {
        char c = str.charAt(i);
        f += paramPaint.measureText(String.valueOf(c));
        if (f <= paramFloat) {
          localStringBuilder.append(c);
        }
        for (;;)
        {
          i += 1;
          break;
          j += 1;
          localStringBuilder.append("\n");
          i -= 1;
          f = 0.0F;
        }
        if (!paramString.endsWith("\n")) {
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        if (i <= paramInt) {
          return localStringBuilder.toString();
        }
        paramString = new StringBuilder();
        localObject = localStringBuilder.toString().split("\n");
        i = m;
        while (i < paramInt)
        {
          paramString.append(localObject[i]);
          if (i != paramInt - 1) {
            paramString.append("\n");
          }
          i += 1;
        }
        localObject = localObject[(paramInt - 1)];
        i = paramString.length();
        f = paramPaint.measureText("…");
        if (paramPaint.measureText((String)localObject) < paramFloat) {
          paramString.append("…");
        }
        label414:
        for (;;)
        {
          return paramString.toString();
          paramInt = i;
          for (;;)
          {
            if (paramInt < 1) {
              break label414;
            }
            if (paramPaint.measureText(paramString.substring(paramInt - 1, i)) >= f)
            {
              localStringBuilder.replace(paramInt - 1, i, "…");
              break;
            }
            paramInt -= 1;
          }
        }
      }
      i = j;
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      return paramMessageForApollo.gameName;
    }
    paramQQAppInterface = ((abxk)paramQQAppInterface.getManager(155)).a(paramMessageForApollo.gameId);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.name;
    }
    return "";
  }
  
  public static String b(ApolloActionPackage paramApolloActionPackage)
  {
    return null;
  }
  
  public static String b(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo.mApolloMessage != null) && (paramMessageForApollo.mApolloMessage.name != null) && (paramMessageForApollo.mApolloMessage.name.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder(new String(paramMessageForApollo.mApolloMessage.name));
      if ((paramMessageForApollo.mApolloMessage.text != null) && (paramMessageForApollo.mApolloMessage.text.length > 0))
      {
        localStringBuilder.append("：").append(new String(paramMessageForApollo.mApolloMessage.text));
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append(" ").append(paramMessageForApollo.inputText);
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
          localStringBuilder.append("：").append(paramMessageForApollo.inputText);
        }
      }
    }
    return acfp.m(2131702700);
  }
  
  public static ArrayList<Integer> b(QQAppInterface paramQQAppInterface)
  {
    int i = 0;
    if (paramQQAppInterface == null) {
      paramQQAppInterface = null;
    }
    for (;;)
    {
      return paramQQAppInterface;
      localArrayList = new ArrayList();
      Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).getString("sp_key_apollo_game_life" + paramQQAppInterface.getCurrentUin(), "");
      paramQQAppInterface = localArrayList;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        continue;
      }
      localObject = ((String)localObject).split(",");
      paramQQAppInterface = localArrayList;
      if (localObject == null) {
        continue;
      }
      paramQQAppInterface = localArrayList;
      if (localObject.length <= 0) {
        continue;
      }
      try
      {
        int j = localObject.length;
        for (;;)
        {
          paramQQAppInterface = localArrayList;
          if (i >= j) {
            break;
          }
          localArrayList.add(Integer.valueOf(Integer.parseInt(localObject[i])));
          i += 1;
        }
        return localArrayList;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloUtil", 1, "[getAddedFaceList] exception=", paramQQAppInterface);
      }
    }
  }
  
  public static AppRuntime b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getRuntime();
    }
    return null;
  }
  
  public static void b(Context paramContext, int paramInt, Intent paramIntent)
  {
    a(paramContext, paramIntent, null, abxi.bjz + "&adSrc=" + paramInt, null);
  }
  
  public static void b(aquz paramaquz)
  {
    if ((paramaquz != null) && (paramaquz.GP != null))
    {
      int i = 0;
      if (i < paramaquz.GP.size())
      {
        String str = (String)paramaquz.GP.get(i);
        if (!TextUtils.isEmpty(str))
        {
          if (!str.contains("http://cmshow.qq.com")) {
            break label85;
          }
          paramaquz.GP.set(i, str.replace("http://cmshow.qq.com", "https://cmshow.qq.com"));
        }
        for (;;)
        {
          i += 1;
          break;
          label85:
          if (str.contains("http://cmshow.gtimg.com")) {
            paramaquz.GP.set(i, str.replace("http://cmshow.gtimg.com", "https://cmshow.gtimg.com"));
          }
        }
      }
    }
  }
  
  public static void b(BaseChatPie paramBaseChatPie, int paramInt)
  {
    if (paramBaseChatPie == null) {}
    SessionInfo localSessionInfo;
    String str2;
    String str3;
    label105:
    String str1;
    SharedPreferences localSharedPreferences;
    do
    {
      for (;;)
      {
        return;
        localSessionInfo = paramBaseChatPie.a();
        if (localSessionInfo != null)
        {
          boolean bool = ApolloGameUtil.Z(paramBaseChatPie.getApp());
          if (abhh.ce("gameSwitch") == 1) {}
          for (int i = 1; (!bool) && (i != 0) && (paramBaseChatPie.app != null) && (paramBaseChatPie.mContext != null); i = 0)
          {
            str2 = localSessionInfo.aTl;
            str3 = paramBaseChatPie.app.getCurrentUin();
            if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
              break label105;
            }
            QLog.d("ApolloUtil", 1, " friendUin or currentUin is null");
            return;
          }
        }
      }
      str1 = "apollo_invite_game_gray_tip_" + str3;
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      List localList = paramBaseChatPie.getApp().b().a(localSessionInfo.aTl, localSessionInfo.cZ, null, 1);
      localObject2 = Boolean.valueOf(true);
      localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 0)
        {
          localObject1 = localObject2;
          if (localList.get(0) != null)
          {
            localObject1 = localObject2;
            if ((localList.get(0) instanceof MessageForUniteGrayTip)) {
              localObject1 = Boolean.valueOf(false);
            }
          }
        }
      }
    } while ((!((Boolean)localObject1).booleanValue()) || ((paramInt != 1) && ((paramInt != 0) || (!localSharedPreferences.getBoolean(str1, true)))) || ((abhh)paramBaseChatPie.app.getManager(153) == null));
    long l = anaz.gQ();
    Object localObject2 = acfp.m(2131702678);
    paramInt = ((String)localObject2).indexOf(acfp.m(2131702681));
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("key_action", 1);
    ((Bundle)localObject1).putString("textColor", "#1e6fff");
    ((Bundle)localObject1).putString("key_action_DATA", abxi.bji + "&adTag=gametips");
    localObject2 = new ahwa(str2, str3, (String)localObject2, localSessionInfo.cZ, -5040, 2359298, l);
    ((ahwa)localObject2).addHightlightItem(paramInt, paramInt + 7, (Bundle)localObject1);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramBaseChatPie.app, (ahwa)localObject2);
    ahwb.a(paramBaseChatPie.app, (MessageForUniteGrayTip)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "send apollo gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "intro_show", gi(paramBaseChatPie.sessionInfo.cZ), 0, new String[0]);
  }
  
  public static boolean b(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt1), ",subType:", Integer.valueOf(paramInt2), ",personNum:", Integer.valueOf(paramInt3), ",isGroup:", Boolean.valueOf(paramBoolean) });
    }
    Object localObject1 = new File(abxi.bip + paramInt1 + "/action");
    if (!((File)localObject1).exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + ((File)localObject1).getPath());
      }
    }
    label463:
    do
    {
      for (;;)
      {
        return false;
        localObject1 = ((File)localObject1).getAbsolutePath();
        Object localObject2 = localObject1;
        if (paramBoolean) {
          localObject2 = (String)localObject1 + "/group";
        }
        if (paramInt2 == 1) {
          localObject1 = (String)localObject2 + "/main/";
        }
        for (;;)
        {
          if (paramInt1 >= abxi.ctt)
          {
            if (!jN((String)localObject1 + "action/" + abxi.bje)) {
              break;
            }
            if (paramInt3 == 0)
            {
              return true;
              if (paramInt2 == 0)
              {
                localObject1 = (String)localObject2 + "/pre/";
              }
              else
              {
                localObject1 = localObject2;
                if (paramInt2 == 2) {
                  localObject1 = (String)localObject2 + "/post/";
                }
              }
            }
            else
            {
              if (paramInt3 != 1) {
                break;
              }
              return jN((String)localObject1 + "action_peer/" + abxi.bje);
            }
          }
        }
        if ((jN((String)localObject1 + abxi.biK)) && (jN((String)localObject1 + abxi.biL)) && (jN((String)localObject1 + abxi.biJ))) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
        {
          if (paramInt3 != 0) {
            break label463;
          }
          return true;
        }
      }
    } while (paramInt3 != 1);
    if ((jN((String)localObject1 + abxi.biN)) && (jN((String)localObject1 + abxi.biO)) && (jN((String)localObject1 + abxi.biM))) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public static boolean b(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i;
    if ((paramArrayOfInt1 != null) && (paramArrayOfInt2 != null) && (paramArrayOfInt1.length == paramArrayOfInt2.length))
    {
      i = 0;
      if (i >= paramArrayOfInt1.length) {
        break label62;
      }
      j = 0;
      label25:
      if (j >= paramArrayOfInt2.length) {
        break label64;
      }
      if (paramArrayOfInt1[i] != paramArrayOfInt2[j]) {
        break label48;
      }
    }
    label48:
    label62:
    label64:
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        return false;
        j += 1;
        break label25;
      }
      i += 1;
      break;
      return true;
    }
  }
  
  public static boolean ba(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return aqiz.isAppInstalled(paramContext, rw());
  }
  
  public static void bp(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, paramString, -1L, localIntent, false, -1);
  }
  
  public static int c(float paramFloat, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramFloat <= 0.0F)) {}
    int i;
    do
    {
      return 43;
      i = b(paramFloat, paramString, 8, 6);
      if (i == 0) {
        return 41;
      }
      if (i == 1) {
        return 42;
      }
    } while (i == 2);
    if (i == 3) {
      return 44;
    }
    if (i == 4) {
      return 45;
    }
    return 46;
  }
  
  public static String c(QQAppInterface paramQQAppInterface, MessageForApollo paramMessageForApollo)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramQQAppInterface != null)
    {
      localObject2 = localObject1;
      if (paramMessageForApollo != null)
      {
        if (paramMessageForApollo.mApolloMessage != null) {
          break label28;
        }
        localObject2 = localObject1;
      }
    }
    label28:
    do
    {
      do
      {
        do
        {
          return localObject2;
          localObject1 = localObject3;
          if (paramMessageForApollo.mApolloMessage.name != null) {
            localObject1 = new String(paramMessageForApollo.mApolloMessage.name);
          }
          localObject2 = localObject1;
        } while (paramMessageForApollo.mApollo3DMessage == null);
        localObject2 = localObject1;
      } while (!ApolloActionData.isAction3DModel(paramMessageForApollo.mApollo3DMessage.actionID_3D));
      localObject2 = localObject1;
    } while (!abhh.R(paramQQAppInterface));
    return paramMessageForApollo.mApollo3DMessage.actionName_3D;
  }
  
  public static String c(MessageForApollo paramMessageForApollo)
  {
    if (paramMessageForApollo == null) {}
    while (TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      return null;
    }
    try
    {
      paramMessageForApollo = new JSONObject(paramMessageForApollo.extendJson).optString("robotOpenId");
      return paramMessageForApollo;
    }
    catch (Exception paramMessageForApollo)
    {
      QLog.e("ApolloUtil", 1, paramMessageForApollo, new Object[0]);
    }
    return null;
  }
  
  public static void c(ImageView paramImageView, int paramInt)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setImageResource(2130838704);
  }
  
  public static void c(aquz paramaquz) {}
  
  public static boolean c(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return (ba(paramContext)) || ((abhh.R(paramQQAppInterface)) && (abhh.d.bCU) && (!TextUtils.isEmpty(abhh.d.bgc)));
  }
  
  public static void cGt()
  {
    ThreadManager.post(new ApolloUtil.6(), 5, null, true);
  }
  
  public static void cGu()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
    String str = rv();
    if (!TextUtils.isEmpty(str)) {
      localSharedPreferences.edit().putBoolean(str, true).apply();
    }
    bGu = true;
  }
  
  public static int cj(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return -1;
      }
      if (paramString.length() > 8)
      {
        paramString = paramString.substring(paramString.length() - 8, paramString.length());
        return Color.parseColor("#" + paramString);
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString.getMessage());
    }
    return -1;
  }
  
  public static int ck(String paramString)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static int cl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      if (paramString.contains("vipApollo_role_")) {
        return 11;
      }
      if (paramString.contains("vipApollo_item_")) {
        return 12;
      }
      if (paramString.contains("vipApollo_action_")) {
        return 13;
      }
      if (paramString.contains("apollo_audio_")) {
        return 14;
      }
      if (paramString.contains("vipList_apollo_data")) {
        return 15;
      }
      if (paramString.contains("clientScriptBaseConfig")) {
        return 16;
      }
      if (paramString.contains("terminalCmConfig")) {
        return 17;
      }
    } while (!paramString.contains("vipApollo_drawerAction_"));
    return 18;
  }
  
  public static long d(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0L;
    }
    try
    {
      long l = new JSONObject(paramString1).optLong(paramString2);
      return l;
    }
    catch (Exception paramString1)
    {
      QLog.e("ApolloUtil", 2, paramString1.getMessage());
    }
    return 0L;
  }
  
  public static void d(Activity paramActivity, String paramString1, String paramString2)
  {
    avqy.h(paramActivity, paramString1, paramString2);
  }
  
  public static void d(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    if ((paramString1 == null) || (!new File(paramString1).exists())) {}
    for (;;)
    {
      return;
      String str;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (new File(paramString2).exists()) {}
      }
      else
      {
        str = aqhu.M(paramActivity, paramString1);
      }
      try
      {
        if ((akyr.asY()) && (aqhu.isJPEGImage(paramString1))) {
          akyr.b(paramString1, str, true, "", 0);
        }
        while ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
        {
          localBundle.putBoolean("isFromShare", true);
          localBundle.putString("forward_thumb", str);
          localBundle.putString("forward_filepath", paramString1);
          localBundle.putString("forward_extra", paramString1);
          localBundle.putBoolean("k_favorites", false);
          localBundle.putBoolean("isFromFavorites", true);
          localBundle.putInt("extra_key_from_apollo", paramInt);
          localIntent.putExtras(localBundle);
          paramActivity.startActivityForResult(localIntent, 103);
          return;
          akyr.a(paramString1, str, true, "", 0);
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          QLog.e("ApolloUtil", 2, paramString2.getMessage());
        }
      }
    }
  }
  
  public static void d(QQAppInterface paramQQAppInterface, ArrayList<Integer> paramArrayList)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayList.get(i));
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    BaseApplicationImpl.getContext().getSharedPreferences("apollo_sp", 0).edit().putString("sp_key_apollo_game_life" + paramQQAppInterface.getCurrentUin(), localStringBuilder.toString()).commit();
  }
  
  public static void dF(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, abxi.bjx, -1L, localIntent, false, -1);
  }
  
  public static String dp(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    if ((paramInt == 1) || (paramInt == 2)) {
      localStringBuilder.append(abxi.biF).append(paramInt).append(File.separator).append("main.lua");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(abxi.biF).append(paramInt).append(File.separator).append("main.js");
    }
  }
  
  public static final int dp2px(float paramFloat1, float paramFloat2)
  {
    return (int)(paramFloat1 * paramFloat2 + 0.5F);
  }
  
  public static String dq(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(abxi.biF).append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String dr(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    localStringBuilder.append(abxi.biy).append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String ds(int paramInt)
  {
    if (paramInt == -1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://cmshow.gtimg.cn/qqshow/admindata/comdata/vipApollo_drawerAction_");
    localStringBuilder.append(paramInt).append("/d.zip");
    return localStringBuilder.toString();
  }
  
  public static String dt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return abxi.bim;
    case 1: 
      return abxi.bio;
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "";
  }
  
  public static String du(int paramInt)
  {
    if (2 == paramInt) {
      return "friend";
    }
    return "me";
  }
  
  public static String dv(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(abxi.bip).append(paramInt).append(File.separator).append("action/").append("music.amr");
    String str = localStringBuilder.toString();
    Object localObject = str;
    if (!aqhq.fileExists(str))
    {
      int i = str.length();
      localStringBuilder.delete(str.length() - "music.amr".length(), i);
      localStringBuilder.append("music/");
      localObject = localStringBuilder.toString();
      if (!aqhq.fileExists((String)localObject)) {
        break label284;
      }
      localObject = new File((String)localObject).list(new abyw());
      if (localObject == null) {
        break label268;
      }
      switch (localObject.length)
      {
      default: 
        Arrays.sort((Object[])localObject);
        i = gl(localObject.length);
        if ((i >= 0) && (i < localObject.length))
        {
          localStringBuilder.append(localObject[i]);
          localObject = localStringBuilder.toString();
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "[getAudioPathForAction] " + paramInt + " " + (String)localObject);
      }
      return localObject;
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file dir empty");
      continue;
      localStringBuilder.append(localObject[0]);
      localObject = localStringBuilder.toString();
      continue;
      localObject = "";
      continue;
      label268:
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file not found even one");
      continue;
      label284:
      localObject = "";
      QLog.e("ApolloUtil", 1, "[getAudioPathForAction] file dir not found ");
    }
  }
  
  public static void endTrace(String paramString)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("ApolloUtil", 2, "[endTrace] " + paramString + " cost:" + (l - OW));
      OW = l;
    }
  }
  
  public static String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getCurrentUin();
    }
    return localAppRuntime.getAccount();
  }
  
  public static int gh(int paramInt)
  {
    Object localObject = null;
    if (1 == paramInt) {
      localObject = new File(bkb);
    }
    if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      localObject = aqhq.readFileContent((File)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject);
          if (1 == paramInt)
          {
            if (((JSONObject)localObject).has("timeStamp")) {
              return (int)(((JSONObject)localObject).optLong("timeStamp") / 1000L);
            }
            if (((JSONObject)localObject).has("timestamp"))
            {
              long l = ((JSONObject)localObject).optLong("timestamp") / 1000L;
              return (int)l;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ApolloUtil", 2, "getApolloPanelJsonVer fail", localException);
          }
        }
      }
    }
    return 0;
  }
  
  public static int gi(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static int gj(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 3: 
    default: 
      return paramInt;
    case 1: 
      return 0;
    case 4: 
      return 1;
    }
    return 3000;
  }
  
  private static int gk(int paramInt)
  {
    if (paramInt < 229) {
      return paramInt + 10000;
    }
    return paramInt + 20000;
  }
  
  public static int gl(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 2147483647))
    {
      QLog.e("ApolloUtil", 1, "[getRandomInteger] invalid " + paramInt);
      return 0;
    }
    return new Random().nextInt(paramInt);
  }
  
  public static int gm(int paramInt)
  {
    int i;
    if (paramInt == 1) {
      i = 3;
    }
    do
    {
      return i;
      if (paramInt == 4) {
        return 1;
      }
      i = paramInt;
    } while (paramInt != 5);
    return 2;
  }
  
  public static int gn(int paramInt)
  {
    if (paramInt == 0) {
      return paramInt;
    }
    if (paramInt == -104) {
      return 2001;
    }
    if (paramInt == -103) {
      return 2002;
    }
    if (paramInt == -118) {
      return 2003;
    }
    if (paramInt == -111) {
      return 2004;
    }
    return 2000;
  }
  
  public static int go(int paramInt)
  {
    int j = 1;
    if ((paramInt >= 500) && (paramInt < 600)) {
      return 1;
    }
    if ((paramInt >= 600) && (paramInt < 700)) {
      return 2;
    }
    int i;
    if (paramInt >= 700)
    {
      i = 1;
      if (paramInt >= 800) {
        break label65;
      }
    }
    label65:
    for (paramInt = j;; paramInt = 0)
    {
      if ((paramInt & i) == 0) {
        break label70;
      }
      return 3;
      i = 0;
      break;
    }
    label70:
    return 0;
  }
  
  public static int gp(int paramInt)
  {
    if (paramInt == 2) {
      return 1;
    }
    return 0;
  }
  
  public static void handleApolloNoCatchCrash(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    abwh.Il(20);
    int i;
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(ApolloRender.sNativeVersion)) {
        localStringBuilder.append("SO_VERSION:").append(ApolloRender.sNativeVersion).append(",");
      }
      i = 40;
      if (System.currentTimeMillis() - ApolloTextureView.sReAttachTime < 30000L) {
        i = 41;
      }
    }
    for (;;)
    {
      localStringBuilder.append("crashType=").append(paramString1).append(", crashStack=").append(paramString2);
      abwh.a(20, 1, i, new Object[] { localStringBuilder.toString() });
      return;
      i = 30;
      if (paramString1.contains("NullPointerException")) {
        i = 31;
      }
    }
  }
  
  public static String iV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!Zz()) {
      return paramString;
    }
    QLog.d("ApolloUtil", 2, new Object[] { "checkWrapApolloUrl url:", paramString });
    String str = paramString;
    if (!paramString.contains("open.cmshow.qq.com")) {
      str = paramString.replace("//cmshow.qq.com", "//open.cmshow.qq.com").replace("//cmshow.gtimg.cn", "//open.cmshow.qq.com");
    }
    paramString = str;
    int j;
    if (str.contains("open.cmshow.qq.com"))
    {
      j = str.indexOf("&_bid=");
      if (j >= 0) {
        break label212;
      }
      j = str.indexOf("_bid=");
    }
    label199:
    label206:
    label209:
    label212:
    for (int i = 0;; i = 1)
    {
      paramString = str;
      if (j > 0)
      {
        paramString = str.substring(0, j);
        str = str.substring(j + "_bid=".length());
        if (TextUtils.isEmpty(str)) {
          break label209;
        }
        j = str.indexOf("&");
        if (j < 0) {
          break label206;
        }
        if (i == 0) {
          break label199;
        }
        i = j;
        str = str.substring(i);
        paramString = paramString + str;
      }
      for (;;)
      {
        QLog.d("ApolloUtil", 2, new Object[] { "checkWrapApolloUrl replaceUrl:", paramString });
        return paramString;
        i = j + 1;
        break;
      }
    }
  }
  
  public static String iW(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Uri.encode(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloUtil", 1, paramString.getMessage());
    }
    return "";
  }
  
  /* Error */
  public static String iX(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 87	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: invokevirtual 2237	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   8: aload_0
    //   9: invokevirtual 2243	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnull +37 -> 51
    //   17: aload_0
    //   18: aload_0
    //   19: invokevirtual 2248	java/io/InputStream:available	()I
    //   22: i2l
    //   23: invokestatic 2254	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   26: invokestatic 2260	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_2
    //   32: aload_0
    //   33: ifnull +9 -> 42
    //   36: aload_0
    //   37: invokevirtual 2263	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_2
    //   42: aload_2
    //   43: areturn
    //   44: astore_0
    //   45: aload_0
    //   46: invokevirtual 2266	java/io/IOException:printStackTrace	()V
    //   49: aload_1
    //   50: areturn
    //   51: aload_0
    //   52: ifnull -10 -> 42
    //   55: aload_0
    //   56: invokevirtual 2263	java/io/InputStream:close	()V
    //   59: aconst_null
    //   60: areturn
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 2266	java/io/IOException:printStackTrace	()V
    //   66: aconst_null
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull -30 -> 42
    //   75: aload_0
    //   76: invokevirtual 2263	java/io/InputStream:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual 2266	java/io/IOException:printStackTrace	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 2263	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 2266	java/io/IOException:printStackTrace	()V
    //   106: goto -7 -> 99
    //   109: astore_1
    //   110: goto -19 -> 91
    //   113: astore_1
    //   114: goto -43 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   29	21	1	str	String
    //   88	12	1	localObject1	Object
    //   109	1	1	localObject2	Object
    //   113	1	1	localIOException	java.io.IOException
    //   1	42	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	40	44	java/io/IOException
    //   55	59	61	java/io/IOException
    //   2	13	68	java/io/IOException
    //   75	79	81	java/io/IOException
    //   2	13	88	finally
    //   95	99	101	java/io/IOException
    //   17	30	109	finally
    //   17	30	113	java/io/IOException
  }
  
  public static String iY(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return paramString.substring(0, 4) + "*";
  }
  
  public static String iZ(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 2048);
    return paramString.substring(0, 2048);
  }
  
  public static boolean ie(int paramInt)
  {
    String str = dp(paramInt);
    return (!TextUtils.isEmpty(str)) && (aqhq.fileExists(str));
  }
  
  public static boolean jdMethod_if(int paramInt)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "[isWhiteFaceActionRscDone], actionId:", Integer.valueOf(paramInt) });
    }
    Object localObject = new File(abxi.bip + paramInt + "/action");
    int j;
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + ((File)localObject).getPath());
      }
      j = 0;
    }
    int k;
    do
    {
      do
      {
        return j;
        localObject = ((File)localObject).getAbsolutePath();
        if (paramInt < abxi.ctt) {
          break;
        }
        k = jN((String)localObject + "/main/action/" + abxi.bje);
        j = k;
      } while (k == 0);
      k &= jN((String)localObject + "/pre/action/" + abxi.bje);
      j = k;
    } while (k == 0);
    return k & jN((String)localObject + "/post/action/" + abxi.bje);
    int m;
    if ((jN((String)localObject + "/pre/" + abxi.biK)) && (jN((String)localObject + "/pre/" + abxi.biL)) && (jN((String)localObject + "/pre/" + abxi.biJ)))
    {
      j = 1;
      m = j;
      if (j == 0) {
        return m;
      }
      if ((!jN((String)localObject + "/main/" + abxi.biK)) || (!jN((String)localObject + "/main/" + abxi.biL)) || (!jN((String)localObject + "/main/" + abxi.biJ))) {
        break label565;
      }
      paramInt = 1;
      label445:
      j &= paramInt;
      m = j;
      if (j == 0) {
        return m;
      }
      if ((!jN((String)localObject + "/post/" + abxi.biK)) || (!jN((String)localObject + "/post/" + abxi.biL)) || (!jN((String)localObject + "/post/" + abxi.biJ))) {
        break label570;
      }
    }
    label565:
    label570:
    for (paramInt = i;; paramInt = 0)
    {
      return paramInt & j;
      j = 0;
      break;
      paramInt = 0;
      break label445;
    }
    return m;
  }
  
  public static boolean ig(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkDressRes], dressId:" + paramInt);
    }
    File localFile = new File(abxi.bir + paramInt);
    if (paramInt < 21) {
      localFile = new File(abxi.bio, "/def/basic/dress/" + paramInt);
    }
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile.getPath());
      }
      return false;
    }
    if (paramInt >= abxi.ctt) {
      return jN(localFile.getAbsolutePath() + "/" + abxi.bjd);
    }
    if ((jN(localFile.getAbsolutePath() + "/" + abxi.biQ)) && (jN(localFile.getAbsolutePath() + "/" + abxi.biR)) && (jN(localFile.getAbsolutePath() + "/" + abxi.biP))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean ih(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[checkRoleRes], roleId:" + paramInt);
    }
    File localFile1;
    if (paramInt == 0)
    {
      localFile1 = new File(abxi.bio, "/def/basic/skeleton/" + paramInt);
      if (localFile1.exists()) {
        break label142;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + localFile1.getPath());
      }
    }
    label142:
    File localFile2;
    do
    {
      return false;
      localFile1 = new File(abxi.bis + paramInt);
      break;
      localFile2 = new File(localFile1, abxi.bjb);
      if ((paramInt == 0) || (localFile2.exists())) {
        break label252;
      }
      Dd(localFile2.getPath() + acfp.m(2131702692));
      abrj.j(0, new Object[] { "ROLE_FILE_CONFIG_NAME NOT exist.", localFile2.getPath() });
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ROLE_FILE_CONFIG_NAME NOT exist." + localFile2.getPath());
    return false;
    label252:
    if (paramInt >= abxi.ctt) {
      return jN(localFile1.getAbsolutePath() + "/" + abxi.bjc);
    }
    if ((jN(localFile1.getAbsolutePath() + "/" + abxi.biZ)) && (jN(localFile1.getAbsolutePath() + "/" + abxi.bja)) && (jN(localFile1.getAbsolutePath() + "/" + abxi.biY))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean ii(int paramInt)
  {
    boolean bool = true;
    if (!ij(paramInt)) {
      return false;
    }
    if (!bGs)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 0);
      String str = ru();
      if (!TextUtils.isEmpty(str)) {
        ctJ = localSharedPreferences.getInt(str, 0);
      }
      bGs = true;
    }
    if (ctJ < 3) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean ij(int paramInt)
  {
    if (afqv.kt.containsKey("3.4.4"))
    {
      Object localObject = (List)afqv.kt.get("3.4.4");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramInt == ((Integer)((Iterator)localObject).next()).intValue()) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean ik(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = kc;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void j(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((paramContext instanceof Activity)) {}
  }
  
  public static boolean jL(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[isSpecialActionResDone], actionPath:" + paramString);
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + paramString.getPath());
      }
    }
    for (;;)
    {
      return false;
      if ((jN(paramString.getAbsolutePath() + "/" + abxi.biK)) && (jN(paramString.getAbsolutePath() + "/" + abxi.biL)) && (jN(paramString.getAbsolutePath() + "/" + abxi.biJ))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  public static boolean jM(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "[is3DActionPathRscDone], actionPath:" + paramString);
    }
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "dir NOT exist." + paramString.getPath());
      }
      return false;
    }
    return jN(paramString.getAbsolutePath() + "/action/" + abxi.bje);
  }
  
  public static boolean jN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
      if (localFile.exists()) {
        break;
      }
      Dd(paramString + acfp.m(2131702690));
    } while (!QLog.isColorLevel());
    QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    return false;
    if (localFile.length() == 0L)
    {
      Dd(paramString + acfp.m(2131702686));
      abrj.j(0, new Object[] { "ErrorInfo-> ", paramString, ",lenght is 0." });
      if (QLog.isColorLevel()) {
        QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + ",lenght is 0.");
      }
      localFile.delete();
      return false;
    }
    return true;
  }
  
  public static boolean jO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return true;
      paramString = arwv.toMD5(paramString);
      paramString = new File(abxi.biv + paramString + File.separator + paramString + ".zip");
    } while (paramString.exists());
    Dd(paramString + acfp.m(2131702672));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "ErrorInfo-> " + paramString + " NOT exist.");
    }
    return false;
  }
  
  private static String ja(String paramString)
  {
    Matcher localMatcher = Pattern.compile("/\\d+/").matcher(paramString);
    for (paramString = ""; localMatcher.find(); paramString = localMatcher.group()) {}
    return paramString;
  }
  
  public static void m(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((paramQQAppInterface == null) || (paramSessionInfo == null) || (!bgw)) {}
    String str2;
    String str1;
    SharedPreferences localSharedPreferences;
    do
    {
      return;
      bgw = false;
      localObject = paramSessionInfo.aTl;
      str2 = paramQQAppInterface.getCurrentUin();
      str1 = "apollo_white_face_unsupport_gray_tip" + str2;
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
    } while (!localSharedPreferences.getBoolean(str1, true));
    long l = anaz.gQ();
    paramSessionInfo = new ahwa((String)localObject, str2, acfp.m(2131702680), paramSessionInfo.cZ, -5040, 2359299, l);
    Object localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramSessionInfo);
    ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, "addWhiteFaceUnSupportTips send white face unsupport gray tip");
    }
    localSharedPreferences.edit().putBoolean(str1, false).commit();
    VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "graystripe_3Demotion_view", 0, 0, new String[] { "" });
  }
  
  public static SharedPreferences q()
  {
    int i = 0;
    if (BaseApplicationImpl.sProcessId != 1) {
      i = 4;
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("apollo_game_res", i);
  }
  
  public static String rt()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return String.valueOf(localCalendar.getTimeInMillis());
  }
  
  private static String ru()
  {
    if (afqv.kt.containsKey("3.4.4"))
    {
      Object localObject = (List)afqv.kt.get("3.4.4");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new_icon_show_times_").append(str);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localStringBuilder.append("_").append(i);
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  private static String rv()
  {
    if (afqv.kt.containsKey("3.4.4"))
    {
      Object localObject = (List)afqv.kt.get("3.4.4");
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new_emoticon_popup_").append(str);
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          localStringBuilder.append("_").append(i);
        }
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public static String rw()
  {
    String str2 = abhh.d.WX;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "com.tencent.kapu";
    }
    return str1;
  }
  
  public static void w(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(abxi.bjo).append(paramString1).append("&adtag=").append(paramString2);
    paramString1 = new Intent(paramContext, QQBrowserActivity.class);
    paramString1.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.openQQBrowserActivity(paramContext, localStringBuilder.toString(), -1L, paramString1, false, -1);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloUtil", 2, new Object[] { "openCollectCard:", localStringBuilder.toString() });
    }
  }
  
  public static float y(float paramFloat)
  {
    long l = aqgz.hL();
    if (Float.compare(0.0F, paramFloat) == 0) {
      return (float)(l / 5L) / 368.0F;
    }
    return (float)l * paramFloat / 368.0F;
  }
  
  public static int z(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    try
    {
      int i = new JSONObject(paramString1).optInt(paramString2);
      return i;
    }
    catch (Exception paramString1)
    {
      QLog.e("ApolloUtil", 2, paramString1.getMessage());
    }
    return 0;
  }
  
  public static abstract interface a {}
  
  public static class b
  {
    public static final long OY = aqgz.getCpuFrequency();
    public static final String bke;
    public static final int ctM;
    public static final String sModel = ;
    public static final String sOsVersion = aqgz.getDeviceOSVersion();
    public long OZ;
    public long Pa;
    public long Pb;
    
    static
    {
      bke = aqgz.getCpuType();
      ctM = aqgz.getCpuNumber();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil
 * JD-Core Version:    0.7.0.1
 */