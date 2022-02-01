package com.tencent.biz.lebasearch;

import aalb;
import acbn;
import acci;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqha;
import aqho;
import aqju;
import avhc;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.qwallet.QrcodeHbGuiderActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicJumpActivity;
import cooperation.qqreader.QRBridgeActivity;
import ilp;
import java.util.HashMap;
import jsl;
import jsm;
import jsn;
import kdm;
import opn;
import org.json.JSONObject;
import skj;

public class Utils
{
  public static final int BUSINNESS_ID_ALBUM = 5;
  public static final int BUSINNESS_ID_ANIME = 18;
  public static final int BUSINNESS_ID_CITY_SERVICE = 22;
  public static final int BUSINNESS_ID_CM_SHOW = 11;
  public static final int BUSINNESS_ID_CONFESS = 59;
  public static final int BUSINNESS_ID_EAT_AND_DRINK = 21;
  public static final int BUSINNESS_ID_FACE_TO_FACE_SEND = 30;
  public static final int BUSINNESS_ID_FACE_TO_FACE_WALLET = 33;
  public static final int BUSINNESS_ID_GAMES = 13;
  public static final int BUSINNESS_ID_INTERESTED_TRIBES = 12;
  public static final int BUSINNESS_ID_JINGDONG = 16;
  public static final int BUSINNESS_ID_MUSIC = 19;
  public static final int BUSINNESS_ID_MY_COMPUTER = 28;
  public static final int BUSINNESS_ID_MY_FAVORITES = 4;
  public static final int BUSINNESS_ID_MY_FILE = 6;
  public static final int BUSINNESS_ID_MY_OTHER_ACCOUNT = 40;
  public static final int BUSINNESS_ID_NEARBY = 10;
  public static final int BUSINNESS_ID_NEW_FRIEND = 41;
  public static final int BUSINNESS_ID_NOW_LIVE = 20;
  public static final int BUSINNESS_ID_ONE_GREETING = 44;
  public static final int BUSINNESS_ID_PAY = 32;
  public static final int BUSINNESS_ID_PENGUIN_COUNSELING = 26;
  public static final int BUSINNESS_ID_PERSONALITY_DRESS_UP = 3;
  public static final int BUSINNESS_ID_PHONE_CONTACTS = 8;
  public static final int BUSINNESS_ID_PUBLIC_ACCOUNT = 27;
  public static final int BUSINNESS_ID_QQ_DAREN = 7;
  public static final int BUSINNESS_ID_QQ_KANDIAN = 15;
  public static final int BUSINNESS_ID_QQ_MEMBER = 1;
  public static final int BUSINNESS_ID_QQ_PHONE = 29;
  public static final int BUSINNESS_ID_QQ_RED_ENVELOPES = 39;
  public static final int BUSINNESS_ID_QQ_STORY = 14;
  public static final int BUSINNESS_ID_QQ_WALLET = 2;
  public static final int BUSINNESS_ID_QQ_ZONE = 9;
  public static final int BUSINNESS_ID_READ = 17;
  public static final int BUSINNESS_ID_SAY_HELLO = 42;
  public static final int BUSINNESS_ID_SCAN = 31;
  public static final int BUSINNESS_ID_SERVER_ACCOUNT = 43;
  public static final int BUSINNESS_ID_SHOOT = 34;
  public static final int BUSINNESS_ID_SHOPPING_ACCOUNT = 36;
  public static final int BUSINNESS_ID_SPORTS = 24;
  public static final int BUSINNESS_ID_TENCENT_CLASSROOM = 25;
  public static final int BUSINNESS_ID_TENCENT_NEWS = 23;
  public static final int BUSINNESS_ID_TROOP_ASSITANT = 35;
  public static final int BUSINNESS_ID_TROOP_NOTIFACATION = 37;
  public static final int BUSINNESS_ID_YINGYONGBAO = 38;
  public static final String KEY_BUSINESS_ID = "fid";
  public static final String KEY_BUSINESS_URL = "funurl";
  public static final String KEY_ICON = "icurl";
  public static final String KEY_NEW_TASK = "newtask";
  public static final String TAG = "lebasearch.Utils";
  public static final int TYPE_SET_CLOSE = 2;
  public static final int TYPE_SET_OPEN = 1;
  
  public static aqju createPluginSetDialogForMain(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, long paramLong, String paramString1, String paramString2, Handler paramHandler)
  {
    jsm localjsm = new jsm(paramInt, paramQQAppInterface, paramLong, paramHandler);
    paramHandler = new jsn(paramHandler);
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramInt != 1) {
        break label116;
      }
      i = 2131698208;
      label42:
      if (paramInt != 1) {
        break label123;
      }
    }
    label116:
    label123:
    for (paramInt = 2131698213;; paramInt = 2131698211)
    {
      return aqha.a((BaseActivity)paramContext, paramString2, i, paramInt, localjsm, paramHandler);
      if (paramInt == 1) {}
      for (paramQQAppInterface = paramContext.getResources().getString(2131698216, new Object[] { paramString1 });; paramQQAppInterface = paramContext.getString(2131698212, new Object[] { paramString1 }))
      {
        paramString2 = paramQQAppInterface;
        break;
      }
      i = 2131698210;
      break label42;
    }
  }
  
  public static aqju createPluginSetDialogForWeb(Context paramContext, skj paramskj, acci paramacci, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    aqju localaqju = aqha.a(paramContext, 230);
    paramacci = new jsl(paramInt, paramacci, paramContext, paramskj, paramLong);
    paramskj = new TextView(paramContext);
    paramskj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramskj.setTextSize(14.0F);
    paramskj.setTextColor(paramContext.getResources().getColor(2131165625));
    paramskj.setGravity(1);
    paramskj.setPadding((int)aqho.convertDpToPixel(paramContext, 15.0F), (int)aqho.convertDpToPixel(paramContext, 30.0F), (int)aqho.convertDpToPixel(paramContext, 15.0F), (int)aqho.convertDpToPixel(paramContext, 15.0F));
    if (paramInt == 1)
    {
      localaqju.setPositiveButton(2131698208, paramacci);
      localaqju.setNegativeButton(2131698213, paramacci);
      if (paramString2 != null) {}
      for (;;)
      {
        paramskj.setText(paramString2);
        localaqju.addView(paramskj);
        return localaqju;
        paramString2 = paramContext.getResources().getString(2131698216, new Object[] { paramString1 });
      }
    }
    if (paramString2 != null) {}
    for (;;)
    {
      localaqju.setNegativeButton(2131698211, paramacci);
      localaqju.setPositiveButton(2131698210, paramacci);
      break;
      paramString2 = paramContext.getString(2131698212, new Object[] { paramString1 });
    }
  }
  
  public static boolean gotoF2fRedPacket(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "gotoF2fredpack", "click", null, 0, null);
    paramHashMap = new Intent(paramContext, QrcodeHbGuiderActivity.class);
    paramHashMap.putExtra("appInfo", "");
    paramHashMap.putExtra("vacreport_key_seq", l);
    paramHashMap.setFlags(276824064);
    paramContext.startActivity(paramHashMap);
    paramContext = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramContext != null) && ((paramContext instanceof QQAppInterface))) {}
    for (paramContext = (QQAppInterface)paramContext;; paramContext = null)
    {
      anot.a(paramContext, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "jiahao.hongbao.click", 0, 0, "", "", "", "");
      return true;
    }
  }
  
  public static boolean gotoFaceToFaceSend(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    avhc.c(paramContext, 14, null);
    return true;
  }
  
  public static boolean gotoFunctionActivity(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    Object localObject;
    int i;
    boolean bool;
    if (paramHashMap != null)
    {
      if ((paramHashMap.get("className") instanceof String)) {
        localObject = (String)paramHashMap.get("className");
      }
      if ((paramHashMap.get("fid") instanceof Integer))
      {
        i = ((Integer)paramHashMap.get("fid")).intValue();
        if ((paramHashMap.get("newtask") instanceof Boolean)) {
          bool = ((Boolean)paramHashMap.get("newtask")).booleanValue();
        }
      }
    }
    for (;;)
    {
      paramHashMap = new Intent();
      switch (i)
      {
      case 3: 
      case 7: 
      case 11: 
      case 12: 
      case 13: 
      case 16: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 29: 
      case 30: 
      case 34: 
      default: 
      case 2: 
      case 4: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 14: 
      case 15: 
      case 27: 
      case 17: 
      case 18: 
      case 28: 
      case 35: 
      case 36: 
      case 37: 
      case 38: 
        for (;;)
        {
          if (bool) {
            paramHashMap.setFlags(276824064);
          }
          paramContext.startActivity(paramHashMap);
          return true;
          paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
          paramHashMap.putExtra("key_business", 2);
          continue;
          paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
          paramHashMap.putExtra("key_business", 4);
          continue;
          paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
          paramHashMap.putExtra("key_business", 5);
          continue;
          paramHashMap.setClass(paramContext, FileAssistantActivity.class);
          paramHashMap.putExtra("from", "FileAssistant");
          continue;
          paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
          paramHashMap.putExtra("key_business", 7);
          continue;
          paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
          paramHashMap.putExtra("key_business", 3);
          continue;
          paramHashMap.setClass(paramContext, NearbyActivity.class);
          continue;
          opn.a(paramContext, null, 0, null, null, 6);
          return true;
          paramHashMap = new Intent(paramContext, LebaSearchTransparentJumpActivity.class);
          if (i == 27) {
            paramHashMap.putExtra("tab_tab_index", 0);
          }
          paramHashMap.putExtra("key_business", 6);
          continue;
          paramHashMap.setClass(paramContext, QRBridgeActivity.class);
          continue;
          localObject = new JSONObject();
          try
          {
            ((JSONObject)localObject).put("newInstance", true);
            paramHashMap.putExtra("options", ((JSONObject)localObject).toString());
            paramHashMap.setClass(paramContext, VipComicJumpActivity.class);
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("lebasearch.Utils", 2, "BUSINESS_ID_ANIME put newInstance is error");
              }
            }
          }
          paramHashMap.setClass(paramContext, LiteActivity.class);
          paramHashMap.putExtra("targetUin", acbn.bkw);
          aalb.bwg = true;
          aalb.cT(paramHashMap);
          continue;
          paramHashMap.setClass(paramContext, TroopAssistantActivity.class);
          continue;
          paramHashMap.setClass(paramContext, EcshopWebActivity.class);
          paramHashMap.putExtra("from_search", true);
          paramHashMap.setFlags(67108864);
          localObject = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject != null) && ((localObject instanceof QQAppInterface)))
          {
            localObject = (kdm)((QQAppInterface)localObject).getManager(88);
            if (localObject != null) {
              ((kdm)localObject).a(paramHashMap, paramContext, -1);
            }
          }
          localObject = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappecshopurl", "");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            MiniAppLauncher.startMiniApp(paramContext, (String)localObject, 4003, null);
            MiniAppBusiReport.report("shopping_folder", "click", "search", "");
            return true;
            paramHashMap.setClass(paramContext, TroopActivity.class);
            paramHashMap.putExtra("_key_mode", 1);
            paramHashMap.putExtra("key_tab_mode", 2);
            paramHashMap.putExtra("key_from", 1);
            continue;
            paramHashMap.setClass(paramContext, QZoneAppListActivity.class);
          }
        }
      case 31: 
        gotoScan(paramContext, null);
        return true;
      case 32: 
        gotoPay(paramContext, null);
        return true;
      }
      gotoF2fRedPacket(paramContext, null);
      return true;
      bool = true;
      continue;
      i = 0;
      break;
      bool = true;
      i = 0;
    }
  }
  
  public static boolean gotoPay(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    long l = VACDReportUtil.a(null, "qqwallet", "payCode", "click", "2", 0, null);
    paramHashMap = new Intent(paramContext, JumpActivity.class);
    paramHashMap.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1&view=8&entry=2&seq=" + l));
    paramHashMap.setFlags(276824064);
    paramContext.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean gotoScan(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    if (ilp.checkAVCameraUsed(BaseApplicationImpl.getContext()))
    {
      QLog.e("lebasearch.Utils", 2, "gotoScan method. QavCameraUsage.checkAVCameraUsed false.");
      return false;
    }
    paramHashMap = new Intent(paramContext, ScannerActivity.class);
    paramHashMap.putExtra("from", "Conversation");
    paramHashMap.putExtra("leftViewText", paramContext.getString(2131691039));
    paramHashMap.putExtra("selfSet_leftViewText", paramContext.getString(2131691039));
    paramHashMap.setFlags(67108864);
    paramHashMap.setFlags(276824064);
    paramContext.startActivity(paramHashMap);
    return true;
  }
  
  public static boolean gotoStoryBigVipPage(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramHashMap != null)
    {
      l1 = l2;
      if (!(paramHashMap.get("uin") instanceof Long)) {}
    }
    try
    {
      l1 = Long.valueOf(((Long)paramHashMap.get("uin")).longValue()).longValue();
      paramHashMap = QQStoryMemoriesActivity.a(paramContext, 24, l1);
      paramHashMap.addFlags(268435456);
      paramContext.startActivity(paramHashMap);
      return true;
    }
    catch (NumberFormatException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean gotoWebView(Context paramContext, HashMap<String, Object> paramHashMap)
  {
    Object localObject3 = null;
    Object localObject1;
    Object localObject2;
    if (paramHashMap != null) {
      if ((paramHashMap.get("url") instanceof String))
      {
        localObject1 = (String)paramHashMap.get("url");
        if ((paramHashMap.get("url_model") instanceof String))
        {
          paramHashMap = (String)paramHashMap.get("url_model");
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      if (TextUtils.isEmpty(localObject2)) {
        return false;
      }
      if (TextUtils.isEmpty(paramHashMap)) {
        localObject1 = new Intent(paramContext, QQBrowserActivity.class);
      }
      while (localObject1 == null)
      {
        return false;
        localObject1 = localObject3;
        if (paramHashMap.equals("gameCenter"))
        {
          localObject1 = new Intent(paramContext, GameCenterActivity.class);
          ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_zf_games");
        }
      }
      ((Intent)localObject1).putExtra("url", localObject2);
      ((Intent)localObject1).setFlags(276824064);
      paramContext.startActivity((Intent)localObject1);
      return true;
      paramHashMap = null;
      localObject2 = localObject1;
      continue;
      localObject1 = null;
      break;
      paramHashMap = null;
      localObject2 = null;
    }
  }
  
  public static void sendPluginSetMessage(Context paramContext, skj paramskj, acci paramacci, long paramLong, boolean paramBoolean)
  {
    paramContext = new Handler(paramContext.getMainLooper());
    Bundle localBundle = new Bundle();
    localBundle.putLong("uiResId", paramLong);
    localBundle.putBoolean("isChecked", paramBoolean);
    paramContext.post(new Utils.2(paramskj, localBundle, paramacci));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils
 * JD-Core Version:    0.7.0.1
 */