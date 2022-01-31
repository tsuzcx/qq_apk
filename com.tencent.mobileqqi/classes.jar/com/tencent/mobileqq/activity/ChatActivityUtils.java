package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import cga;
import cgb;
import cgc;
import cgd;
import cge;
import cgf;
import cgg;
import cgi;
import cgj;
import cgk;
import cgl;
import cgm;
import cgn;
import cgo;
import cgp;
import cgq;
import cgr;
import cgs;
import com.tencent.av.VideoController;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.GAudioNotifyCenter;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.game.LauchGameAppListHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.UpScrollHideView;
import com.tencent.mobileqq.widget.UpScrollHideView.onViewHideListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatActivityUtils
{
  public static final long a = 55901189L;
  private static ChatActivityUtils.AddFriendSpan jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan;
  private static QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public static QQToastNotifier a;
  public static final String a = "ChatActivityUtils";
  public static final long b = 2274034950L;
  public static final String b = "http://m.qzone.com";
  public static final long c = 2223703302L;
  public static final String c = "http://mobile.qzone.qq.com";
  public static final long d = 274201605L;
  public static final String d = "http://gamecenter.qq.com";
  public static final long e = 440495416L;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
  }
  
  public static View a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener, UpScrollHideView.onViewHideListener paramonViewHideListener)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903127, null);
    UpScrollHideView localUpScrollHideView = (UpScrollHideView)paramContext.findViewById(2131231323);
    TextView localTextView = (TextView)localUpScrollHideView.findViewById(2131231324);
    Button localButton = (Button)localUpScrollHideView.findViewById(2131231325);
    if (paramString1 != null) {
      localTextView.setText(paramString1);
    }
    if (paramString2 != null) {
      localButton.setText(paramString2);
    }
    localButton.setOnClickListener(paramOnClickListener);
    localUpScrollHideView.setOnViewHideListener(paramonViewHideListener);
    localUpScrollHideView.setFocusable(true);
    return paramContext;
  }
  
  public static MessageRecord a(List paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!a(paramSessionInfo.jdField_a_of_type_Int)) || (paramList == null) || (paramList.isEmpty()))
    {
      paramSessionInfo = null;
      return paramSessionInfo;
    }
    label48:
    int i;
    if (paramSessionInfo.jdField_a_of_type_Int == 1006)
    {
      paramList = (MessageRecord)paramList.get(0);
      i = paramList.msgtype;
      if ((i == -1003) || (i == -1031) || (i == -1032) || (i == -3001)) {
        return null;
      }
    }
    else
    {
      i = paramList.size() - 1;
      label92:
      if (i < 0) {
        break label167;
      }
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if ((paramSessionInfo.isSend()) || (MsgProxyUtils.d(paramSessionInfo.msgtype))) {}
    }
    label167:
    for (paramList = paramSessionInfo;; paramList = null)
    {
      if (paramList == null)
      {
        return null;
        i -= 1;
        break label92;
        paramSessionInfo = paramList;
        if (!((FriendManager)paramQQAppInterface.getManager(8)).b(paramList.frienduin)) {
          break;
        }
        return null;
      }
      break label48;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramMessageRecord != null)
    {
      localObject1 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      i = paramMessageRecord.istroop;
      if ((paramMessageRecord.isSend()) || (MessageUtils.a(paramMessageRecord.msgtype))) {
        break label390;
      }
      if (1000 != i) {
        break label90;
      }
      paramQQAppInterface = ContactUtils.j(paramQQAppInterface, (String)localObject1);
      localObject1 = String.format(paramContext.getString(2131561499), new Object[] { paramSessionInfo.d, paramQQAppInterface });
    }
    label90:
    do
    {
      do
      {
        return localObject1;
        if (1020 == i)
        {
          paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).h((String)localObject1);
          return String.format(paramContext.getString(2131561499), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        }
        if (1004 == i)
        {
          paramQQAppInterface = ContactUtils.b(paramQQAppInterface, (String)localObject1, 3000);
          return String.format(paramContext.getString(2131561501), new Object[] { paramSessionInfo.d, paramQQAppInterface });
        }
        if (1001 == i) {
          return String.format(paramContext.getString(2131561505), new Object[] { paramSessionInfo.d });
        }
        if (1006 == i) {
          return String.format(paramContext.getString(2131561510), new Object[] { paramSessionInfo.d });
        }
        if (1009 == i) {
          return String.format(paramContext.getString(2131561509), new Object[] { paramSessionInfo.d });
        }
        if (1005 == i) {
          return String.format(paramContext.getString(2131561508), new Object[] { paramSessionInfo.d });
        }
        if (1021 == i) {
          return String.format(paramContext.getString(2131561506), new Object[] { paramSessionInfo.d });
        }
        if (1022 == i) {
          return String.format(paramContext.getString(2131561507), new Object[] { paramSessionInfo.d });
        }
        localObject1 = localObject2;
      } while (1023 != i);
      return String.format(paramContext.getString(2131563048), new Object[] { paramSessionInfo.d });
      localObject1 = localObject2;
    } while (1006 != i);
    label390:
    paramQQAppInterface = String.format(paramContext.getString(2131561502), new Object[] { paramSessionInfo.d });
    paramSessionInfo = paramContext.getString(2131561608);
    if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
      jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramSessionInfo, paramContext.getResources().getColor(2131361868));
    }
    paramQQAppInterface.lastIndexOf(paramSessionInfo);
    return new SpannableStringBuilder(paramQQAppInterface);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "999";
    case 0: 
      return "0";
    case 1004: 
      return "1";
    case 1000: 
      return "2";
    }
    return "3";
  }
  
  public static String a(Context paramContext)
  {
    String str = paramContext.getString(2131562936);
    switch (paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      return str;
    case 1: 
      return paramContext.getString(2131562373);
    case 2: 
      return paramContext.getString(2131562274);
    }
    return paramContext.getString(2131562169);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null) {}
    switch (paramMessageRecord.istroop)
    {
    case 1002: 
    case 1003: 
    case 1007: 
    case 1008: 
    case 1010: 
    case 1011: 
    case 1012: 
    case 1013: 
    case 1014: 
    case 1015: 
    case 1016: 
    case 1017: 
    case 1018: 
    case 1019: 
    default: 
      return null;
    case 1000: 
    case 1020: 
      return paramContext.getString(2131562143);
    case 1004: 
      return paramContext.getString(2131562142);
    case 1001: 
      return paramContext.getString(2131562145);
    case 1006: 
      return paramContext.getString(2131562141);
    case 1009: 
      return paramContext.getString(2131562144);
    case 1005: 
      return paramContext.getString(2131562146);
    case 1021: 
      return paramContext.getString(2131562140);
    case 1022: 
      return paramContext.getString(2131562148);
    }
    return paramContext.getString(2131562147);
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      return;
    }
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131427376));
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562875);
      }
      jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    int i = 3008;
    Intent localIntent = new Intent(paramActivity, AddFriendLogicActivity.class);
    localIntent.putExtra("type", 0);
    localIntent.putExtra("nick_name", paramSessionInfo.d);
    localIntent.putExtra("troop_uin", paramSessionInfo.b);
    localIntent.putExtra("param_last_activity_name", paramString);
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      i = 10004;
    }
    for (;;)
    {
      localIntent.putExtra("source_id", i);
      if (paramSessionInfo.jdField_a_of_type_Int != 1006) {
        break;
      }
      localIntent.putExtra("uin", "");
      if ((paramSessionInfo.jdField_a_of_type_JavaLangString != null) && (paramSessionInfo.jdField_a_of_type_JavaLangString.length() > 0))
      {
        localIntent.putExtra("friend_mobile_number", paramSessionInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("friend_mobile_name", paramSessionInfo.d);
        paramActivity.startActivity(localIntent);
      }
      return;
      i = 3007;
      continue;
      i = 3013;
      continue;
      i = 3006;
      localIntent.putExtra("type", -1);
      continue;
      i = 3004;
      continue;
      i = 3005;
      continue;
      i = 3003;
      localIntent.putExtra("sub_source_id", 2);
    }
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("nick_name", paramSessionInfo.d);
    if (paramBoolean)
    {
      localIntent.putExtra("param_return_addr", AddContactsActivity.class.getName());
      paramActivity.startActivity(localIntent);
      return;
    }
    paramActivity.startActivityForResult(localIntent, 11);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      b(paramActivity, 2131561761, 1);
      return;
    }
    b(paramActivity, 2131562919, 1);
  }
  
  public static void a(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131562372), paramContext.getString(2131562125), new cgk(), null).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(paramContext);
    }
    jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt, paramContext.getResources().getDimensionPixelSize(2131427376), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131427376));
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, ChatBackgroundSettingActivity.class);
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = paramQQAppInterface.a().a(AppShareIDUtil.a(paramLong));
    if ((localObject2 != null) && (QLog.isColorLevel())) {
      QLog.d("gameShareOnClick", 2, "<--gameShareOnClick appShareID.bundleid" + ((AppShareID)localObject2).bundleid);
    }
    if ((localObject2 != null) && (((AppShareID)localObject2).bundleid != null) && (PackageUtil.a(paramContext, ((AppShareID)localObject2).bundleid)))
    {
      long l = AppShareIDUtil.b(paramLong);
      Object localObject1 = paramQQAppInterface.a().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject2).bundleid;
      if (localObject1 == null)
      {
        localObject1 = null;
        PackageUtil.a(paramContext, (String)localObject2, (String)localObject1);
        if ((paramInt != -3005) && (paramInt != -3004) && ((paramString == null) || (!paramString.startsWith("http://gamecenter.qq.com")))) {
          break label205;
        }
      }
      label205:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
        }
        return;
        localObject1 = ((OpenID)localObject1).openID;
        break;
      }
    }
    a(paramContext, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Bundle paramBundle)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "appShareOnClick action:" + paramString + ",appShareId:" + paramLong + "mixType:" + paramInt);
    }
    paramString = paramString.trim();
    if ((paramInt == -3005) || (paramInt == -3004) || (paramString.startsWith("http://gamecenter.qq.com"))) {}
    for (paramInt = 1; 55901189L == paramLong; paramInt = 0)
    {
      paramBundle = QZoneHelper.UserInfo.a();
      paramBundle.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      paramBundle.b = paramQQAppInterface.e();
      paramBundle.c = paramQQAppInterface.getSid();
      QZoneHelper.b((Activity)paramContext, paramBundle, paramString, "mqqChat", -1);
      if (paramInt == 0) {
        break label466;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(AppShareIDUtil.b(paramLong)), null, null, null);
      return;
    }
    int i;
    label211:
    label224:
    Intent localIntent;
    StringBuilder localStringBuilder1;
    label261:
    StringBuilder localStringBuilder2;
    if ((paramString.startsWith("http://m.qzone.com")) || (paramString.startsWith("http://mobile.qzone.qq.com")))
    {
      i = 1;
      if ((paramInt == 0) && (i == 0)) {
        break label446;
      }
      i = 1;
      localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      localStringBuilder1 = new StringBuilder(paramString);
      if (paramString.indexOf("?") <= 0) {
        break label452;
      }
      paramString = "";
      localStringBuilder2 = localStringBuilder1.append(paramString).append("&from=androidqq");
      if (i == 0) {
        break label459;
      }
    }
    label446:
    label452:
    label459:
    for (paramString = "&sid=" + paramQQAppInterface.getSid();; paramString = "")
    {
      localStringBuilder2.append(paramString);
      if (paramInt != 0)
      {
        localIntent.putExtra("param_force_internal_browser", true);
        localStringBuilder1.append("&platformId=qq_m");
      }
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("url", localStringBuilder1.toString().trim());
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", paramLong);
      paramString = localStringBuilder1.toString();
      if (paramString.startsWith("http://browserApp.p.qq.com/"))
      {
        localIntent.putExtra("url", paramString);
        localIntent.setClass(paramContext, PublicAccountBrowser.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
      }
      paramContext.startActivity(localIntent);
      break;
      i = 0;
      break label211;
      i = 0;
      break label224;
      paramString = "?";
      break label261;
    }
    label466:
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(AppShareIDUtil.b(paramLong)));
  }
  
  public static void a(Context paramContext, String paramString, long paramLong)
  {
    Dialog localDialog = new Dialog(paramContext, 2131624452);
    Handler localHandler = new Handler();
    View localView = LayoutInflater.from(paramContext).inflate(2130903092, null);
    cgg localcgg = new cgg(localDialog);
    localView.setOnClickListener(new cgi(localHandler, localcgg));
    TextView localTextView = (TextView)localView.findViewById(2131231132);
    ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).topMargin = paramContext.getResources().getDimensionPixelSize(2131427376);
    localTextView.setText(paramString);
    paramContext = new AlphaAnimation(0.1F, 0.9F);
    paramContext.setDuration(500L);
    paramContext.setAnimationListener(new cgj(localHandler, localcgg, paramLong));
    localTextView.startAnimation(paramContext);
    localDialog.setContentView(localView, new ViewGroup.LayoutParams(-1, -1));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void a(Intent paramIntent, SessionInfo paramSessionInfo)
  {
    if ((paramIntent != null) && (paramSessionInfo != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("troop_uin", paramSessionInfo.b);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.a(1);
        if (paramQQAppInterface == null) {}
      }
    }
    label277:
    label289:
    while ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      long l;
      try
      {
        l = Long.parseLong(paramString1);
        if (l > 0L)
        {
          if (!paramBoolean)
          {
            paramBoolean = bool;
            paramQQAppInterface.a(l, paramBoolean);
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramActivity)
      {
        for (;;)
        {
          l = 0L;
          continue;
          paramBoolean = false;
        }
      }
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(14);
      String str = paramString1;
      if (localShieldMsgManger != null)
      {
        str = paramString1;
        if (paramInt == 1006)
        {
          str = paramString1;
          if (paramString1 != null) {}
        }
      }
      for (;;)
      {
        try
        {
          str = ContactUtils.d(paramQQAppInterface, paramString2);
          paramString1 = str;
          l = Long.parseLong(str);
          paramString1 = str;
          paramString2 = new ArrayList();
          paramString1 = str;
          paramString2.add(Long.valueOf(l));
          if (paramBoolean)
          {
            paramString1 = str;
            localShieldMsgManger.b(paramInt, paramString2);
            i = 1;
            if (paramInt == 1001)
            {
              if ((str != null) && (str.length() > 0))
              {
                if (!paramBoolean) {
                  break label277;
                }
                paramQQAppInterface.a().b(str);
              }
              i = 1;
            }
            if ((paramActivity == null) || (paramActivity.isFinishing())) {
              break;
            }
            if (i == 0) {
              break label289;
            }
            a(paramActivity);
            return;
          }
          paramString1 = str;
          localShieldMsgManger.a(paramInt, paramString2);
          continue;
          int i = 0;
        }
        catch (NumberFormatException paramString2)
        {
          str = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.e("ChatActivityUtils", 2, "shieldMsg", paramString2);
            str = paramString1;
          }
        }
        continue;
        paramQQAppInterface.a().a(str);
      }
      if (paramBoolean)
      {
        b(paramActivity, 2131561761, 1);
        return;
      }
      b(paramActivity, 2131562919, 1);
      return;
    }
    b(paramActivity, 2131562452, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    LauchGameAppListHelper.a(paramQQAppInterface, paramActivity, paramSessionInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, Intent paramIntent, String paramString)
  {
    paramQQAppInterface = null;
    paramIntent = null;
    if (paramInt == 1)
    {
      paramString = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      paramQQAppInterface = paramIntent;
      if (!paramString.equalsIgnoreCase("")) {
        paramQQAppInterface = Uri.fromFile(new File(paramString));
      }
      PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().remove("camera_photo_path").commit();
      if (paramQQAppInterface == null) {
        return;
      }
      paramIntent = ImageUtil.c(paramActivity, paramQQAppInterface);
      ImageUtil.a(paramActivity, paramIntent);
      if (paramIntent != null)
      {
        if (!FileUtils.e(paramIntent))
        {
          QQToast.a(paramActivity, paramActivity.getString(2131562639), 0).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
          return;
        }
        paramQQAppInterface = paramIntent;
        if (!new File(paramIntent).exists()) {
          QQToast.a(paramActivity, paramActivity.getString(2131561473), 0).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
        }
      }
      else
      {
        QQToast.a(paramActivity, paramActivity.getString(2131561473), 0).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
        return;
      }
    }
    paramIntent = new Intent();
    paramString = new ArrayList();
    paramIntent.setClass(paramActivity, CameraPreviewActivity.class);
    paramString.add(paramQQAppInterface);
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    paramIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramString);
    paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramIntent.putExtra("troop_uin", paramSessionInfo.b);
    paramActivity.startActivity(paramIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent, int paramInt)
  {
    Uri localUri = paramIntent.getData();
    if (paramIntent.getExtras() != null) {}
    for (boolean bool = paramIntent.getExtras().getBoolean("normal");; bool = false)
    {
      if ((!bool) && (localUri != null) && ("http".equals(localUri.getScheme())))
      {
        paramSessionInfo = new StringBuilder();
        paramSessionInfo.append("http://fwd.3g.qq.com:8080/forward.jsp?bid=681&srctype=42");
        paramSessionInfo.append("&uin=" + paramQQAppInterface.a());
        paramSessionInfo.append("&sid=" + paramQQAppInterface.getSid());
      }
      try
      {
        paramSessionInfo.append("&jumpurl=" + URLEncoder.encode(localUri.toString(), "utf-8"));
        paramIntent.setData(Uri.parse(paramSessionInfo.toString()));
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        for (;;)
        {
          try
          {
            paramActivity.startActivityForResult(paramIntent, paramInt);
            return;
          }
          catch (ActivityNotFoundException paramQQAppInterface)
          {
            if (paramInt != 2001) {
              continue;
            }
            QQToast.a(paramActivity, 2131563112, 0).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
            paramQQAppInterface.printStackTrace();
            return;
          }
          paramQQAppInterface = paramQQAppInterface;
          paramQQAppInterface.printStackTrace();
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    Object localObject;
    Intent localIntent;
    long l;
    int i;
    if (paramString != null)
    {
      localObject = (FriendManager)paramQQAppInterface.getManager(8);
      localIntent = new Intent(paramActivity, AVActivity.class);
      localIntent.addFlags(262144);
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      l = Long.parseLong(paramString);
      if (paramQQAppInterface.a().a(l) > 0L) {
        if (paramQQAppInterface.a().a(l)) {
          i = 2;
        }
      }
      for (;;)
      {
        ArrayList localArrayList = ((FriendManager)localObject).a(paramString);
        if (localArrayList == null) {
          break label324;
        }
        int k = localArrayList.size();
        localObject = new long[k];
        int j = 0;
        while (j < k)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)localArrayList.get(j);
          if (localDiscussionMemberInfo != null) {
            localObject[j] = Long.valueOf(localDiscussionMemberInfo.memberUin).longValue();
          }
          j += 1;
        }
        i = 1;
        continue;
        i = 0;
      }
    }
    for (;;)
    {
      localIntent.putExtra("DiscussUinList", (long[])localObject);
      localIntent.putExtra("sessionType", 3);
      localIntent.putExtra("uin", paramString);
      localIntent.putExtra("uinType", 3000);
      localIntent.putExtra("Type", i);
      localIntent.putExtra("GroupId", paramString);
      if (i == 0) {
        ((QCallFacade)paramQQAppInterface.getManager(36)).a(1, l);
      }
      paramActivity.startActivity(localIntent);
      if (i == 2) {
        paramActivity.overridePendingTransition(2130968633, 0);
      }
      if (i == 0)
      {
        paramQQAppInterface = "start_group_audio_time" + paramQQAppInterface.a();
        ThreadManager.a().post(new cgf(paramQQAppInterface));
      }
      return;
      label324:
      localObject = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, ChatActivity paramChatActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "bubble onDoubleClick().");
    }
    if ((paramChatActivity != null) && (paramChatActivity.getCurrentFocus() != null)) {}
    ChatMessage localChatMessage;
    do
    {
      ((InputMethodManager)paramChatActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramChatActivity.getCurrentFocus().getWindowToken(), 0);
      for (;;)
      {
        paramChatActivity = paramView.getContext();
        if (paramChatActivity != null) {
          break;
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "chatActivity current focus is null");
        }
      }
      localChatMessage = AIOUtils.a(paramView);
    } while (localChatMessage == null);
    if ((localChatMessage instanceof MessageForLongMsg)) {
      paramView = ((MessageForLongMsg)localChatMessage).msg;
    }
    for (;;)
    {
      if ((localChatMessage instanceof MessageForMixedMsg)) {
        paramView = ((MessageForMixedMsg)localChatMessage).msg;
      }
      if (paramView == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(ChatItemBuilder.jdField_a_of_type_JavaLangString, 2, "bubble onDoubleClick() CharSequence null.");
        return;
        if (!(localChatMessage instanceof MessageForText)) {
          break label341;
        }
        paramView = (MessageForText)localChatMessage;
        if (!(paramView.sb instanceof QQText)) {
          break label336;
        }
      }
      label336:
      for (paramView = ((QQText)paramView.sb).f;; paramView = null)
      {
        if (localChatMessage.msgtype != -2008) {
          break label339;
        }
        if (localChatMessage.isSend())
        {
          paramView = paramChatActivity.getString(2131561557);
          break;
        }
        paramView = paramChatActivity.getString(2131561556);
        break;
        Intent localIntent = new Intent(paramChatActivity, TextPreviewActivity.class);
        localIntent.putExtra("peeruin", localChatMessage.frienduin);
        localIntent.putExtra("uin_type", localChatMessage.istroop);
        localIntent.putExtra("content", paramView);
        localIntent.putExtra("uniseq", localChatMessage.uniseq);
        localIntent.putExtra("bubbleId", localChatMessage.vipBubbleID);
        paramChatActivity.startActivity(localIntent);
        ((Activity)paramChatActivity).overridePendingTransition(2130968600, 0);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "long_msg", "long_msg_double", 0, 0, "", "", "", "");
        return;
      }
      label339:
      continue;
      label341:
      paramView = null;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023);
  }
  
  public static boolean a(Context paramContext, SessionInfo paramSessionInfo)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return false;
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "single friend list: " + paramContext);
      }
      try
      {
        paramContext = new JSONArray(paramContext);
        int i = 0;
        while (i < paramContext.length())
        {
          Object localObject = paramContext.getJSONObject(i);
          if ((((JSONObject)localObject).has("type")) && (((JSONObject)localObject).has("uin")))
          {
            int j = ((JSONObject)localObject).getInt("type");
            localObject = ((JSONObject)localObject).getString("uin");
            if (j == paramSessionInfo.jdField_a_of_type_Int)
            {
              boolean bool = ((String)localObject).equals(MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_JavaLangString));
              if (bool) {
                return true;
              }
            }
          }
          i += 1;
        }
        return true;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, "single friend list: " + (String)localObject);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray((String)localObject);
        localObject = new JSONArray();
        i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          if ((!localJSONObject.has("type")) || (!localJSONObject.has("uin"))) {
            break label216;
          }
          int j = localJSONObject.getInt("type");
          String str = localJSONObject.getString("uin");
          if ((j == paramInt) && (str.equals(MsgProxyUtils.a(paramString)))) {
            break label216;
          }
          ((JSONArray)localObject).put(localJSONObject);
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.putString("single_way_friend_list", ((JSONArray)localObject).toString());
      boolean bool = paramContext.commit();
      return bool;
      label216:
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramInt == 0)
    {
      if (!((FriendManager)paramQQAppInterface.getManager(8)).g(paramString1)) {
        break label144;
      }
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (paramInt == 1001)
      {
        paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString1);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.groupid == -1002)) {}
        for (;;)
        {
          return bool1;
          bool1 = false;
        }
      }
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(14);
      bool1 = bool2;
      if (localShieldMsgManger != null)
      {
        String str = paramString1;
        if (paramInt == 1006)
        {
          str = paramString1;
          if (paramString1 == null) {
            str = ContactUtils.d(paramQQAppInterface, paramString2);
          }
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(str))
        {
          return localShieldMsgManger.a(str);
          label144:
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, boolean paramBoolean1, boolean paramBoolean2, Handler.Callback paramCallback)
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(paramActivity, 2131562452, 0).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
      return true;
    }
    if ((Build.VERSION.SDK_INT < 9) || (!VcSystemInfo.b()))
    {
      QQToast.a(paramActivity, 2131560207, 1).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
      return true;
    }
    if (paramQQAppInterface.a().a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startGroupAudio phone is calling!");
      }
      paramQQAppInterface = paramActivity.getString(2131560227);
      DialogUtil.a(paramActivity, 230, paramActivity.getString(2131560225), paramQQAppInterface, 2131561746, 2131562539, new cgc(paramCallback), null).show();
      return false;
    }
    long l = Long.valueOf(paramString).longValue();
    Object localObject1;
    Object localObject2;
    if (!paramQQAppInterface.a().a(l)) {
      if ((paramBoolean1) && (!NetworkUtil.g(BaseApplication.getContext())))
      {
        if (VideoController.d(VideoController.f) > 0)
        {
          a(paramQQAppInterface, paramActivity, paramString, false, paramBoolean2, paramCallback);
          return true;
        }
        localObject1 = null;
        localObject2 = null;
        if (NetworkUtil.c(BaseApplication.getContext()))
        {
          localObject1 = paramActivity.getString(2131560225);
          localObject2 = paramActivity.getString(2131560221);
        }
        if (!NetworkUtil.d(BaseApplication.getContext())) {
          break label404;
        }
        localObject2 = paramActivity.getString(2131560225);
        localObject1 = paramActivity.getString(2131560222);
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityUtils", 2, "startGAudio title or content is empty");
        }
        return true;
      }
      DialogUtil.a(paramActivity, 230, (String)localObject2, (String)localObject1, 2131560229, 2131560230, new cgd(paramQQAppInterface, paramActivity, paramString, paramBoolean2, paramCallback), new cge(paramCallback)).show();
      return false;
      if ((paramBoolean2) && (paramQQAppInterface.c()) && (paramQQAppInterface.a().a() != 3))
      {
        QQToast.a(paramActivity, 2131560199, 1).b(paramActivity.getResources().getDimensionPixelSize(2131427376));
        return true;
      }
      a(paramQQAppInterface, paramActivity, paramString);
      if (paramCallback != null) {
        paramCallback.handleMessage(null);
      }
      return true;
      label404:
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, Handler.Callback paramCallback, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "startVideo uinType: " + paramInt + ", peerUin: " + paramString1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean1 + ", extraUin: " + paramString4 + ", checkShieldMsg: " + paramBoolean2 + ", checkWifi: " + paramBoolean3 + ", from: " + paramString5);
    }
    Object localObject;
    int i;
    String str1;
    if (!paramQQAppInterface.c())
    {
      if (VideoController.b() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo device not support!");
        }
        QQToast.a(paramContext, 2131560118, 1).b(paramContext.getResources().getDimensionPixelSize(2131427376));
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_hardware_false", 0, 0, "", "", "", "");
        }
        return true;
      }
      if (Build.VERSION.SDK_INT < 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo sdk not support!");
        }
        QQToast.a(paramContext, 2131560119, 1).b(paramContext.getResources().getDimensionPixelSize(2131427376));
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_OS_false", 0, 0, "", "", "", "");
        }
        return true;
      }
      if (paramQQAppInterface.a().a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo phone is calling!");
        }
        paramQQAppInterface = paramContext.getString(2131560227);
        DialogUtil.a(paramContext, 230, paramContext.getString(2131560225), paramQQAppInterface, 2131561746, 2131562539, new cga(paramCallback), null).show();
        return false;
      }
      if ((paramInt == 1006) && (!a(paramQQAppInterface, paramString1)))
      {
        localObject = new VcSystemInfo();
        ((VcSystemInfo)localObject).a();
        i = ((VcSystemInfo)localObject).d();
        long l = ((VcSystemInfo)localObject).c();
        int j = Build.VERSION.SDK_INT;
        if ((i < 3) || (l / 1000L < 800L) || (j < 9))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
          }
          QQToast.a(paramContext, 2131560247, 1).b(paramContext.getResources().getDimensionPixelSize(2131427376));
          if (paramBoolean1) {
            ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
          }
          return true;
        }
      }
      if ((paramBoolean1) && (!ConfigSystemImpl.a(paramContext)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo audio disabled!");
        }
        paramQQAppInterface = paramContext.getString(2131560228);
        DialogUtil.a(paramContext, 230, paramContext.getString(2131560225), paramQQAppInterface, 2131561746, 2131560231, new cgl(paramCallback), null).show();
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
        }
        return false;
      }
      if ((paramBoolean2) && (a(paramQQAppInterface, paramInt, paramString1, paramString3)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo check shiled msg!");
        }
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
        }
        localObject = paramContext.getString(2131560226);
        paramQQAppInterface = DialogUtil.a(paramContext, 230, paramContext.getString(2131560225), (String)localObject, 2131560229, 2131560232, new cgm(paramQQAppInterface, paramInt, paramString1, paramString3, paramBoolean1, paramContext, paramString2, paramString4, paramCallback, paramString5), new cgn(paramBoolean1, paramCallback));
        paramQQAppInterface.setOnCancelListener(new cgo(paramBoolean1, paramCallback));
        paramQQAppInterface.show();
        return false;
      }
      if (!NetworkUtil.e(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo network not support!");
        }
        QQToast.a(paramContext, 2131562452, 0).b(paramContext.getResources().getDimensionPixelSize(2131427376));
        if (paramBoolean1) {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
        }
        return true;
      }
      if ((!paramBoolean3) || (NetworkUtil.g(paramContext))) {
        break label1566;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "startVideo check wifi!");
      }
      localObject = VideoController.d;
      if (paramBoolean1) {
        localObject = VideoController.e;
      }
      if (VideoController.d((String)localObject) > 0)
      {
        a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, false, false, paramCallback, paramString5);
        return true;
      }
      i = NetworkUtil.a(paramContext);
      if (i == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo is 2G!");
        }
        String str2 = paramContext.getString(2131560225);
        String str3 = paramContext.getString(2131560221);
        localObject = str3;
        str1 = str2;
        if (paramBoolean1)
        {
          ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
          str1 = str2;
          localObject = str3;
        }
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ChatActivityUtils", 2, "startVideo title or content is empty");
        }
        return true;
        if ((i == 3) || (i == 4))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo is 3G or 4G!");
          }
          str1 = paramContext.getString(2131560225);
          if (paramBoolean1)
          {
            localObject = paramContext.getString(2131560223);
            ReportController.b(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
            continue;
          }
          localObject = paramContext.getString(2131560222);
        }
      }
      else
      {
        paramQQAppInterface = DialogUtil.a(paramContext, 230, str1, (String)localObject, 2131560229, 2131560230, new cgp(paramBoolean1, i, paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramString4, paramCallback, paramString5), new cgq(paramBoolean1, i, paramCallback));
        paramQQAppInterface.setOnCancelListener(new cgr(paramBoolean1, i, paramCallback));
        paramQQAppInterface.show();
        return false;
        i = paramQQAppInterface.a().a();
        if (i == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo is calling!");
          }
          if ((paramBoolean1) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().a()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().a()))))) {
            b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5);
          }
          for (;;)
          {
            return true;
            QQToast.a(paramContext, 2131560199, 1).b(paramContext.getResources().getDimensionPixelSize(2131427376));
          }
        }
        if (i == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo is calling!");
          }
          if ((!paramBoolean1) && (((paramString1 != null) && (paramString1.equals(paramQQAppInterface.a().a()))) || ((paramString3 != null) && (paramString3.equals(paramQQAppInterface.a().a()))))) {
            b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5);
          }
          for (;;)
          {
            return true;
            QQToast.a(paramContext, 2131560199, 1).b(paramContext.getResources().getDimensionPixelSize(2131427376));
          }
        }
        if (((i == 3) || (i == 4)) && (paramQQAppInterface.a().a() > 0L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo is multi calling!");
          }
          DialogUtil.a(paramContext, 230, null, paramContext.getString(2131560198), 2131560229, 2131560230, new cgs(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5, paramCallback), new cgb(paramCallback)).show();
          return false;
        }
        label1566:
        b(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramString5);
        if (paramCallback != null) {
          paramCallback.handleMessage(null);
        }
        return true;
      }
      localObject = null;
      str1 = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
    return (paramSessionInfo.jdField_a_of_type_Int == 0) && (!paramQQAppInterface.b(paramSessionInfo.jdField_a_of_type_JavaLangString));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((FriendManager)paramQQAppInterface.getManager(8)).b(paramString);
  }
  
  public static boolean a(TroopMemberInfo paramTroopMemberInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramTroopMemberInfo.alias == null) || (paramTroopMemberInfo.alias.length() <= 0))
    {
      bool1 = bool2;
      if (paramTroopMemberInfo.memberuin != null)
      {
        bool1 = bool2;
        if (paramTroopMemberInfo.memberuin.trim().length() > 0)
        {
          bool1 = bool2;
          if (paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase(String.valueOf(0))) {}
        }
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.trim().length() > 0)
      {
        bool1 = bool2;
        if (!paramString.trim().equals(String.valueOf(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    Object localObject;
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = BaseApplication.getContext();
        } while (localObject == null);
        localSharedPreferences = ((Context)localObject).getSharedPreferences("secondHandSharePre", 0);
      } while (localSharedPreferences == null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1).append(paramString2).append(paramString3);
    } while (localSharedPreferences.contains(((StringBuilder)localObject).toString()));
    paramString1 = localSharedPreferences.edit();
    paramString1.putInt(((StringBuilder)localObject).toString(), 0);
    paramString1.commit();
    return true;
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, paramJSONObject.toString() + "");
    }
    try
    {
      Object localObject = paramJSONObject.getString("url");
      String str1 = paramJSONObject.getString("picture");
      String str2 = paramJSONObject.getString("title");
      String str3 = paramJSONObject.getString("summary");
      String str4 = paramJSONObject.getString("brief");
      String str5 = paramJSONObject.getString("source");
      paramJSONObject = paramJSONObject.getString("puin");
      paramJSONObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(1).a(str4).c((String)localObject).a(str5, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
      localObject = StructMsgElementFactory.a(2);
      ((AbsStructMsgItem)localObject).a(str1, str2, str3);
      paramJSONObject.addItem((AbsStructMsgElement)localObject);
      paramJSONObject = paramJSONObject.getBytes();
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("ChatActivityUtils", 4, "createSecondHandProductInfoStructMsg---JSONException");
      }
    }
    return null;
  }
  
  public static String b(int paramInt)
  {
    int i = 999;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return String.valueOf(paramInt);
      paramInt = 0;
      continue;
      paramInt = 1;
      continue;
      paramInt = 3;
      continue;
      paramInt = 2;
      continue;
      paramInt = 4;
    }
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new QQToastNotifier(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131427376), 0, paramInt2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, ChatHistory.class);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("FriendNick", paramSessionInfo.d);
    paramActivity.startActivityForResult(paramQQAppInterface, 0);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "enterVideo uinType: " + paramInt + ", peerUin: " + paramString1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean + ", extraUin: " + paramString4 + ", from: " + paramString5);
    }
    Object localObject1 = MediaPlayerManager.a(paramQQAppInterface);
    if (localObject1 != null) {
      ((MediaPlayerManager)localObject1).a(true);
    }
    if (paramInt == 0)
    {
      localObject1 = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString1);
      if ((localObject1 == null) || ((((Friends)localObject1).abilityBits & 1L) == 0L) || (NetworkUtil.a(paramContext) == 2)) {}
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject2;
      if (paramInt == 1006)
      {
        if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatActivityUtils", 2, "enterVideo uinType: " + paramInt + ", peerUin: " + paramString1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean + ", extraUin: " + paramString4);
          }
          return;
        }
        if (TextUtils.isEmpty(paramString1))
        {
          localObject1 = paramString3;
          localObject2 = paramString3;
          label287:
          paramString3 = ((PhoneContactManager)paramQQAppInterface.getManager(10)).a();
          if (paramString3 == null) {
            break label873;
          }
          paramString1 = paramString3.nationCode;
          paramString3 = paramString3.mobileNo;
        }
      }
      for (;;)
      {
        Object localObject3 = paramString3;
        Object localObject4 = paramString1;
        paramString3 = (String)localObject2;
        paramString1 = (String)localObject1;
        localObject2 = localObject4;
        localObject1 = localObject3;
        label343:
        if (paramInt == 1000)
        {
          localObject4 = paramQQAppInterface.a().createEntityManager();
          localObject3 = (TroopInfo)((EntityManager)localObject4).a(TroopInfo.class, "troopcode=?", new String[] { paramString4 });
          if (localObject3 != null)
          {
            localObject3 = ((TroopInfo)localObject3).troopuin;
            ((EntityManager)localObject4).a();
          }
        }
        for (;;)
        {
          localObject4 = VideoMsgTools.a(paramQQAppInterface, paramInt, paramString1);
          int j = (int)paramQQAppInterface.a();
          boolean bool2 = a(paramQQAppInterface, paramString1);
          Object localObject5 = ((FriendsManagerImp)paramQQAppInterface.getManager(8)).c(paramString1);
          if (localObject5 != null) {}
          for (int i = ContactUtils.a((Friends)localObject5, paramQQAppInterface);; i = -1)
          {
            localObject5 = new Intent(paramContext, AVActivity.class);
            ((Intent)localObject5).addFlags(262144);
            ((Intent)localObject5).addFlags(268435456);
            ((Intent)localObject5).putExtra("uinType", paramInt);
            ((Intent)localObject5).putExtra("uin", paramString1);
            ((Intent)localObject5).putExtra("name", paramString2);
            ((Intent)localObject5).putExtra("selfNation", (String)localObject2);
            ((Intent)localObject5).putExtra("selfMobile", (String)localObject1);
            ((Intent)localObject5).putExtra("toMobile", paramString3);
            ((Intent)localObject5).putExtra("receive", false);
            ((Intent)localObject5).putExtra("isAudioMode", paramBoolean);
            ((Intent)localObject5).putExtra("istatus", j);
            ((Intent)localObject5).putExtra("extraUin", (String)localObject3);
            ((Intent)localObject5).putExtra("extraCode", paramString4);
            ((Intent)localObject5).putExtra("sig", (byte[])localObject4);
            ((Intent)localObject5).putExtra("isNetworkWell", bool1);
            ((Intent)localObject5).putExtra("isFriend", bool2);
            ((Intent)localObject5).putExtra("senderStartTime", SystemClock.elapsedRealtime());
            ((Intent)localObject5).putExtra("isSender", true);
            if (paramBoolean) {}
            for (paramInt = 1;; paramInt = 2)
            {
              ((Intent)localObject5).putExtra("sessionType", paramInt);
              ((Intent)localObject5).putExtra("from", paramString5);
              ((Intent)localObject5).putExtra("friendTerminal", i);
              paramContext.startActivity((Intent)localObject5);
              if (!paramQQAppInterface.c()) {
                break;
              }
              ((Activity)paramContext).overridePendingTransition(2130968633, 0);
              return;
              localObject1 = paramString1;
              localObject2 = paramString3;
              if (!TextUtils.isEmpty(paramString3)) {
                break label287;
              }
              localObject2 = paramString1;
              localObject1 = paramString1;
              break label287;
              if (TextUtils.isEmpty(paramString3))
              {
                localObject1 = ((PhoneContactManager)paramQQAppInterface.getManager(10)).d(paramString1);
                if (localObject1 != null)
                {
                  paramString3 = ((PhoneContact)localObject1).nationCode + ((PhoneContact)localObject1).mobileCode;
                  localObject1 = null;
                  localObject2 = null;
                  break label343;
                }
                if (QLog.isColorLevel()) {
                  QLog.w("ChatActivityUtils", 2, "enterVideo cannot get phone number");
                }
              }
              localObject1 = null;
              localObject2 = null;
              break label343;
              if (QLog.isColorLevel()) {
                QLog.e("ChatActivityUtils", 2, "enterVideo can't find troop info!");
              }
              ((EntityManager)localObject4).a();
              return;
            }
          }
          localObject3 = paramString4;
        }
        label873:
        paramString3 = null;
        paramString1 = null;
      }
    }
  }
  
  public static boolean b(Context paramContext, SessionInfo paramSessionInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramSessionInfo.jdField_a_of_type_Int);
      localJSONObject.put("uin", MsgProxyUtils.a(paramSessionInfo.jdField_a_of_type_JavaLangString));
      paramSessionInfo = PreferenceManager.getDefaultSharedPreferences(paramContext).getString("single_way_friend_list", "");
      if (!TextUtils.isEmpty(paramSessionInfo)) {}
      for (paramSessionInfo = new JSONArray(paramSessionInfo);; paramSessionInfo = new JSONArray())
      {
        paramSessionInfo.put(localJSONObject);
        paramSessionInfo = paramSessionInfo.toString();
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        paramContext.putString("single_way_friend_list", paramSessionInfo);
        return paramContext.commit();
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((CrmUtils.b(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)) || (paramSessionInfo.jdField_a_of_type_Int == 1024)) {}
    int i;
    do
    {
      return false;
      i = paramSessionInfo.jdField_a_of_type_Int;
    } while ((i != 0) && (i != 1000) && (i != 1004) && (i != 3000) && (i != 1006) && (i != 1021));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */