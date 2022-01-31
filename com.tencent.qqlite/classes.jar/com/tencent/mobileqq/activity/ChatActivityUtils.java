package com.tencent.mobileqq.activity;

import abt;
import abv;
import abw;
import abx;
import aby;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.SpannableString;
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
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.photo.CameraPreviewActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.service.message.MessageCache;
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
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
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
import java.util.LinkedHashMap;
import java.util.List;
import mqq.app.AppRuntime;
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
  private static LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
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
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  public static View a(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903082, null);
    View localView = paramContext.findViewById(2131296683);
    ((TextView)paramContext.findViewById(2131296685)).setOnClickListener(paramOnClickListener);
    localView.setOnClickListener(paramOnClickListener);
    localView.setFocusable(true);
    return paramContext;
  }
  
  public static View a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener, UpScrollHideView.onViewHideListener paramonViewHideListener)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = LayoutInflater.from(paramContext).inflate(2130903106, null);
    UpScrollHideView localUpScrollHideView = (UpScrollHideView)paramContext.findViewById(2131296683);
    TextView localTextView = (TextView)localUpScrollHideView.findViewById(2131296685);
    Button localButton = (Button)localUpScrollHideView.findViewById(2131296793);
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
        break label401;
      }
      if (1000 == i)
      {
        paramQQAppInterface = ContactUtils.k(paramQQAppInterface, (String)localObject1);
        localObject1 = String.format(paramContext.getString(2131363921), new Object[] { paramSessionInfo.d, paramQQAppInterface });
      }
    }
    else
    {
      return localObject1;
    }
    if (1020 == i)
    {
      paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).b((String)localObject1);
      if (paramQQAppInterface == null) {
        break label503;
      }
      paramQQAppInterface = paramQQAppInterface.troopName;
    }
    label401:
    label503:
    for (paramQQAppInterface = String.format(paramContext.getString(2131363921), new Object[] { paramSessionInfo.d, paramQQAppInterface });; paramQQAppInterface = null)
    {
      return paramQQAppInterface;
      if (1004 == i)
      {
        paramQQAppInterface = ContactUtils.b(paramQQAppInterface, (String)localObject1, 3000);
        return String.format(paramContext.getString(2131363922), new Object[] { paramSessionInfo.d, paramQQAppInterface });
      }
      if (1001 == i) {
        return String.format(paramContext.getString(2131363923), new Object[] { paramSessionInfo.d });
      }
      if (1006 == i) {
        return String.format(paramContext.getString(2131363924), new Object[] { paramSessionInfo.d });
      }
      if (1009 == i) {
        return String.format(paramContext.getString(2131363926), new Object[] { paramSessionInfo.d });
      }
      if (1005 == i) {
        return String.format(paramContext.getString(2131363927), new Object[] { paramSessionInfo.d });
      }
      if (1022 == i) {
        return String.format(paramContext.getString(2131363928), new Object[] { paramSessionInfo.d });
      }
      if (1023 == i) {
        return String.format(paramContext.getString(2131363929), new Object[] { paramSessionInfo.d });
      }
      localObject1 = localObject2;
      if (1025 != i) {
        break;
      }
      return String.format(paramContext.getString(2131363931), new Object[] { paramSessionInfo.d });
      localObject1 = localObject2;
      if (1006 != i) {
        break;
      }
      paramSessionInfo = String.format(paramContext.getString(2131363925), new Object[] { paramSessionInfo.d });
      paramQQAppInterface = paramContext.getString(2131363930);
      if (jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan == null) {
        jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan = new ChatActivityUtils.AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131427391));
      }
      i = paramSessionInfo.lastIndexOf(paramQQAppInterface);
      paramContext = new SpannableStringBuilder(paramSessionInfo);
      paramContext.setSpan(jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$AddFriendSpan, i, paramQQAppInterface.length() + i, 33);
      return paramContext;
    }
  }
  
  public static Integer a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return (Integer)jdField_a_of_type_JavaUtilLinkedHashMap.get(paramString1 + paramString2);
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
    String str = paramContext.getString(2131363062);
    switch (paramContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      return str;
    case 1: 
      return paramContext.getString(2131363063);
    case 2: 
      return paramContext.getString(2131363064);
    }
    return paramContext.getString(2131363065);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null) {}
    AppRuntime localAppRuntime;
    switch (paramMessageRecord.istroop)
    {
    default: 
      localObject1 = localObject2;
    case 1000: 
    case 1020: 
      do
      {
        do
        {
          return localObject1;
          return paramContext.getString(2131363932);
          localAppRuntime = BaseApplicationImpl.a.a();
          localObject1 = localObject2;
        } while (localAppRuntime == null);
        localObject1 = localObject2;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localObject1 = (QQAppInterface)BaseApplicationImpl.a().a();
      if ((localObject1 == null) || (((FriendManager)((QQAppInterface)localObject1).getManager(8)).b(paramMessageRecord.senderuin) == null)) {
        break;
      }
    }
    for (paramContext = paramContext.getString(2131363932);; paramContext = null)
    {
      return paramContext;
      return paramContext.getString(2131363933);
      return paramContext.getString(2131363934);
      return paramContext.getString(2131363935);
      return paramContext.getString(2131363936);
      return paramContext.getString(2131363937);
      return paramContext.getString(2131363938);
      return paramContext.getString(2131363939);
      localAppRuntime = ((BaseActivity)paramContext).getAppRuntime();
      localObject1 = localObject2;
      if (!(localAppRuntime instanceof QQAppInterface)) {
        break;
      }
      paramMessageRecord = ((QQAppInterface)localAppRuntime).a().a(paramMessageRecord.frienduin);
      localObject1 = paramMessageRecord;
      if (TextUtils.isEmpty(paramMessageRecord)) {
        break;
      }
      return String.format(paramContext.getString(2131363940), new Object[] { paramMessageRecord });
    }
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
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131492887));
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131363378);
        }
        jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      catch (Exception paramActivity) {}finally
      {
        if ((jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    int i = 3008;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      i = 10004;
    case 1005: 
    case 1023: 
      if ((i == 3007) && ((paramActivity instanceof ChatActivity)))
      {
        ChatActivity localChatActivity = (ChatActivity)paramActivity;
        if (!LBSHandler.a(localChatActivity.a(), paramSessionInfo.jdField_a_of_type_JavaLangString)) {
          localChatActivity.a().g(localChatActivity.getString(2131364454));
        }
      }
      break;
    }
    do
    {
      return;
      i = 3007;
      break;
      i = 3013;
      break;
      i = 3006;
      break;
      i = 3004;
      break;
      i = 3005;
      break;
      if (paramSessionInfo.jdField_a_of_type_Int != 1006) {
        break label229;
      }
    } while ((paramSessionInfo.jdField_a_of_type_JavaLangString == null) || (paramSessionInfo.jdField_a_of_type_JavaLangString.length() <= 0));
    paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 2, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, i, 0, paramSessionInfo.d, null, null, paramString));
    return;
    label229:
    if (paramBoolean)
    {
      paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, null, i, 0, paramSessionInfo.d, null, AddContactsActivity.class.getName(), paramString));
      return;
    }
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, i, 0, paramSessionInfo.d, null, null, paramString), 11);
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
      b(paramActivity, 2131363413, 1);
      return;
    }
    b(paramActivity, 2131363412, 1);
  }
  
  public static void a(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131362986));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131427392), paramContext.getResources().getColor(2131427393)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    DialogUtil.a(paramContext, paramContext.getString(2131362985), localSpannableString, 0, 2131363109, null, null, new abx(paramContext)).show();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(paramContext);
    }
    jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt, paramContext.getResources().getDimensionPixelSize(2131492887), 0, 0);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).b(paramContext.getResources().getDimensionPixelSize(2131492887));
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
      paramBundle.b = paramQQAppInterface.c();
      paramBundle.c = paramQQAppInterface.getSid();
      QZoneHelper.a((Activity)paramContext, paramBundle, paramString, "mqqChat", -1);
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
    Dialog localDialog = new Dialog(paramContext, 2131624167);
    Handler localHandler = new Handler();
    View localView = LayoutInflater.from(paramContext).inflate(2130903069, null);
    abt localabt = new abt(localDialog);
    localView.setOnClickListener(new abv(localHandler, localabt));
    TextView localTextView = (TextView)localView.findViewById(2131296580);
    ((LinearLayout.LayoutParams)localTextView.getLayoutParams()).topMargin = paramContext.getResources().getDimensionPixelSize(2131492887);
    localTextView.setText(paramString);
    paramContext = new AlphaAnimation(0.1F, 0.9F);
    paramContext.setDuration(500L);
    paramContext.setAnimationListener(new abw(localHandler, localabt, paramLong));
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
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
      paramIntent.putExtra("uinname", paramSessionInfo.d);
      paramIntent.putExtra("troop_uin", paramSessionInfo.b);
      paramIntent.putExtra("phonenum", paramSessionInfo.e);
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
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
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
        b(paramActivity, 2131363413, 1);
        return;
      }
      b(paramActivity, 2131363412, 1);
      return;
    }
    b(paramActivity, 2131362785, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, ChatHistory.class);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("FriendNick", paramSessionInfo.d);
    paramActivity.startActivityForResult(paramQQAppInterface, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt, Intent paramIntent, String paramString)
  {
    paramQQAppInterface = null;
    paramIntent = null;
    if (paramInt == 1)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      paramQQAppInterface = paramIntent;
      if (!((String)localObject).equalsIgnoreCase(""))
      {
        com.tencent.mobileqq.activity.aio.PlusPanelUtils.jdField_a_of_type_JavaLangString = (String)localObject;
        paramQQAppInterface = Uri.fromFile(new File((String)localObject));
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
          QQToast.a(paramActivity, paramActivity.getString(2131363408), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492887));
          return;
        }
        paramQQAppInterface = paramIntent;
        if (!new File(paramIntent).exists()) {
          QQToast.a(paramActivity, paramActivity.getString(2131363409), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492887));
        }
      }
      else
      {
        QQToast.a(paramActivity, paramActivity.getString(2131363409), 0).b(paramActivity.getResources().getDimensionPixelSize(2131492887));
        return;
      }
    }
    paramIntent = new Intent();
    Object localObject = new ArrayList();
    paramIntent.setClass(paramActivity, CameraPreviewActivity.class);
    ((ArrayList)localObject).add(paramQQAppInterface);
    paramIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject);
    paramIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    paramIntent.putExtra("troop_uin", paramSessionInfo.b);
    if ((paramString != null) && (paramString.equals("callFromFastImage"))) {
      paramIntent.putExtra("callFromFastImage", true);
    }
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
            QQToast.a(paramActivity, 2131362961, 0).b(paramActivity.getResources().getDimensionPixelSize(2131492887));
            paramQQAppInterface.printStackTrace();
            return;
          }
          paramQQAppInterface = paramQQAppInterface;
          paramQQAppInterface.printStackTrace();
        }
      }
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
      for (paramView = ((QQText)paramView.sb).g;; paramView = null)
      {
        if (localChatMessage.msgtype != -2008) {
          break label339;
        }
        if (localChatMessage.isSend())
        {
          paramView = paramChatActivity.getString(2131364079);
          break;
        }
        paramView = paramChatActivity.getString(2131364078);
        break;
        Intent localIntent = new Intent(paramChatActivity, TextPreviewActivity.class);
        localIntent.putExtra("peeruin", localChatMessage.frienduin);
        localIntent.putExtra("uin_type", localChatMessage.istroop);
        localIntent.putExtra("content", paramView);
        localIntent.putExtra("uniseq", localChatMessage.uniseq);
        localIntent.putExtra("bubbleId", localChatMessage.vipBubbleID);
        paramChatActivity.startActivity(localIntent);
        ((Activity)paramChatActivity).overridePendingTransition(2130968594, 0);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "long_msg", "long_msg_double", 0, 0, "", "", "", "");
        return;
      }
      label339:
      continue;
      label341:
      paramView = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Integer paramInteger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.a()))) {}
    do
    {
      do
      {
        return;
      } while ((paramInteger.intValue() != -1) && (paramInteger.intValue() != 0));
      jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString + paramQQAppInterface.a(), paramInteger);
    } while (paramInteger.intValue() != -1);
    paramInteger = (FriendManager)paramQQAppInterface.getManager(8);
    int i;
    if (paramInteger != null)
    {
      paramInteger = paramInteger.a(paramString);
      if (paramInteger != null)
      {
        String str = paramQQAppInterface.a();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramInteger.Administrator))) {
          if ((str.equals(paramInteger.Administrator)) || (paramInteger.Administrator.contains(str))) {
            i = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {}
      for (paramInteger = "0";; paramInteger = "1")
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
        return;
        i = 0;
        break;
      }
      i = 0;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1020) || (paramInt == 1025);
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
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + paramInt);
    }
    ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)paramQQAppInterface.getManager(15);
    boolean bool1;
    if (paramInt == 0)
    {
      if (!((FriendManager)paramQQAppInterface.getManager(8)).g(paramString1)) {
        break label242;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + bool1);
      }
      return bool1;
      if (paramInt == 1001)
      {
        paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString1);
        if (paramQQAppInterface == null)
        {
          bool1 = bool2;
          if (localShieldMsgManger != null) {
            bool1 = localShieldMsgManger.a(paramString1);
          }
        }
        else
        {
          bool1 = bool2;
          if (paramQQAppInterface.groupid == -1002) {
            bool1 = true;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramInt != 1011)
        {
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
              bool1 = localShieldMsgManger.a(str);
              continue;
              label242:
              bool1 = false;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if ((1024 == paramSessionInfo.jdField_a_of_type_Int) && (CrmUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))) {
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
  
  public static byte[] a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      paramString = null;
      return paramString;
    }
    paramString = paramString.toUpperCase();
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static byte[] a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, paramJSONObject.toString() + "");
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("url"))
        {
          localObject1 = paramJSONObject.getString("url");
          if (!paramJSONObject.has("picture")) {
            break label589;
          }
          str1 = paramJSONObject.getString("picture");
          if (!paramJSONObject.has("title")) {
            break label595;
          }
          str2 = paramJSONObject.getString("title");
          if (!paramJSONObject.has("summary")) {
            break label601;
          }
          str3 = paramJSONObject.getString("summary");
          if (!paramJSONObject.has("brief")) {
            break label607;
          }
          localObject2 = paramJSONObject.getString("brief");
          if (!paramJSONObject.has("layout")) {
            break label613;
          }
          i = paramJSONObject.getInt("layout");
          if (!paramJSONObject.has("source")) {
            break label618;
          }
          str4 = paramJSONObject.getString("source");
          if (i == 6)
          {
            if (!paramJSONObject.has("price")) {
              break label624;
            }
            str5 = paramJSONObject.getString("price");
            if (!paramJSONObject.has("prunit")) {
              break label630;
            }
            str6 = paramJSONObject.getString("prunit");
            if (!paramJSONObject.has("icon")) {
              break label636;
            }
            str7 = paramJSONObject.getString("icon");
            if (!paramJSONObject.has("srcaction")) {
              break label642;
            }
            str8 = paramJSONObject.getString("srcaction");
            if (!paramJSONObject.has("action")) {
              break label648;
            }
            str9 = paramJSONObject.getString("action");
            if (!paramJSONObject.has("a_actionData")) {
              break label654;
            }
            str10 = paramJSONObject.getString("a_actionData");
            if (!paramJSONObject.has("i_actionData")) {
              break label660;
            }
            str11 = paramJSONObject.getString("i_actionData");
            if (!paramJSONObject.has("appid")) {
              break label666;
            }
            paramJSONObject = paramJSONObject.getString("appid");
            localObject2 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(41).a((String)localObject2).a(7);
            if (paramJSONObject == "") {
              break label673;
            }
            l = Long.parseLong(paramJSONObject);
            paramJSONObject = ((AbsShareMsg.Builder)localObject2).b(l).a(str9, (String)localObject1, null, null, null).a(str4, str7).b(str8, null, null, str10, str11).d((String)localObject1).a();
            localObject1 = StructMsgElementFactory.a(i);
            ((AbsStructMsgItem)localObject1).a(str1, str2, str3, str5, str6, 0);
            paramJSONObject.addItem((AbsStructMsgElement)localObject1);
            return paramJSONObject.getBytes();
          }
          paramJSONObject = paramJSONObject.getString("puin");
          paramJSONObject = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(1).a((String)localObject2).e((String)localObject1).a(str4, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.qqlite&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
          localObject1 = StructMsgElementFactory.a(2);
          ((AbsStructMsgItem)localObject1).a(str1, str2, str3);
          paramJSONObject.addItem((AbsStructMsgElement)localObject1);
          paramJSONObject = paramJSONObject.getBytes();
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("ChatActivityUtils", 4, "createSecondHandProductInfoStructMsg---JSONException");
        }
        return null;
      }
      Object localObject1 = null;
      continue;
      label589:
      String str1 = null;
      continue;
      label595:
      String str2 = null;
      continue;
      label601:
      String str3 = null;
      continue;
      label607:
      Object localObject2 = null;
      continue;
      label613:
      int i = 2;
      continue;
      label618:
      String str4 = null;
      continue;
      label624:
      String str5 = null;
      continue;
      label630:
      String str6 = null;
      continue;
      label636:
      String str7 = null;
      continue;
      label642:
      String str8 = null;
      continue;
      label648:
      String str9 = null;
      continue;
      label654:
      String str10 = null;
      continue;
      label660:
      String str11 = null;
      continue;
      label666:
      paramJSONObject = "";
      continue;
      label673:
      long l = -1L;
    }
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
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      return;
    }
    jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public static void b(Context paramContext)
  {
    DialogUtil.a(paramContext, 230, paramContext.getString(2131362987), paramContext.getString(2131362988), new aby(), null).show();
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    new QQToastNotifier(paramContext).a(paramInt1, paramContext.getResources().getDimensionPixelSize(2131492887), 0, paramInt2);
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
    int i = paramSessionInfo.jdField_a_of_type_Int;
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 3000) || (i == 1006) || (i == 1025);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */