package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import acdu;
import acei;
import acff;
import acfp;
import acgr;
import acle;
import afck;
import afwh;
import aicu;
import aids;
import aizg;
import ajdo;
import ajqp;
import akwj;
import alkm;
import alkt;
import anbb;
import anbk;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import anpc;
import anqu;
import anqv;
import anrd;
import aofk;
import apsb;
import apsb.a;
import aqfx;
import aqgb;
import aqgv;
import aqha;
import aqhq;
import aqhs;
import aqhu;
import aqiw;
import aqiz;
import aqji;
import aqjl;
import aqju;
import aqmu;
import aqpr;
import aqux;
import aqwu;
import aqxf;
import arhz;
import arie;
import asgx;
import atdc;
import atde;
import avpw;
import avpw.d;
import com.etrump.mixlayout.ETTextView;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.av.gaudio.AVPhoneUserInfo;
import com.tencent.av.gaudio.AVPhoneUserInfo.TelInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVLoadingDialogActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.av.utils.InviteBaseData;
import com.tencent.av.utils.PopupDialog;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.qcall.PstnCardInfo;
import com.tencent.tim.call.qcall.PstnSessionInfo;
import imh;
import imm;
import ixa;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import jgj;
import jjk;
import jjw;
import jjy;
import jkm;
import jlc;
import jlk;
import jll;
import jlq;
import jlr;
import jof;
import jpa;
import jqs;
import ku;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import top;
import tzc;
import ujx;
import ujy;
import ujz;
import uka;
import ukb;
import ukc;
import ukd;
import uke;
import ukf;
import ukg;
import ukh;
import uki;
import ukj;
import ukk;
import ukl;
import ukm;
import ukn;
import uko;
import ukp;
import ukq;
import ukr;
import uks;
import ukt;
import uku;
import ukv;
import ukw;
import ukx;
import uky;
import ukz;
import ula;
import ulb;
import ulc;
import uld;
import ule;
import ulf;
import ulg;
import ulh;
import uli;
import ulj;
import ulk;
import ull;
import ulm;
import uln;
import ulo;
import ulp;
import ulq;
import ulr;
import uls;
import ult;
import ulu;
import ulv;
import ulw;
import ulx;
import uly;
import ulz;
import uma;
import umb;
import umc;
import umd;
import ume;
import umf;
import umg;
import umh;
import umi;
import umj;
import wja;
import wmj;
import xmb;
import xva;
import ydz;
import yhv;

public class ChatActivityUtils
{
  static aqju C;
  public static Queue<String> C;
  private static AddFriendSpan a;
  private static ConcurrentHashMap<String, Integer> cT;
  public static final String[] cj = { "http://m.qzone.com", "https://m.qzone.com", "http://mobile.qzone.qq.com", "https://mobile.qzone.qq.com" };
  private static final char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static arhz progressDialog;
  
  static
  {
    jdField_C_of_type_JavaUtilQueue = new LinkedList();
  }
  
  public static String Q(String paramString, int paramInt)
    throws Exception
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
    if (paramInt == 16) {
      return bytesToHex(localMessageDigest.digest(paramString.getBytes("utf-8"))).substring(8, 24);
    }
    return bytesToHex(localMessageDigest.digest(paramString.getBytes("utf-8")));
  }
  
  public static void Z(Context paramContext, int paramInt)
  {
    new arie(paramContext).V(paramInt, paramContext.getResources().getDimensionPixelSize(2131299627), 0, 0);
  }
  
  private static long a(ChatMessage paramChatMessage, Activity paramActivity)
  {
    long l1 = paramChatMessage.uniseq;
    if ((paramActivity != null) && (paramActivity.getIntent() != null) && (paramActivity.getIntent().hasExtra("origin_merge_structing_msg_uniseq")))
    {
      long l2 = paramActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
      if (l2 > 0L) {
        return l2;
      }
    }
    return l1;
  }
  
  /* Error */
  public static View a(Context paramContext, String paramString, android.view.View.OnClickListener paramOnClickListener1, android.view.View.OnClickListener paramOnClickListener2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokestatic 163	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   13: ldc 164
    //   15: aconst_null
    //   16: invokevirtual 168	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   19: astore_0
    //   20: aload_0
    //   21: ldc 169
    //   23: invokevirtual 175	android/view/View:findViewById	(I)Landroid/view/View;
    //   26: astore 4
    //   28: aload_0
    //   29: ldc 176
    //   31: invokevirtual 175	android/view/View:findViewById	(I)Landroid/view/View;
    //   34: checkcast 178	android/widget/TextView
    //   37: astore 5
    //   39: aload_0
    //   40: ldc 179
    //   42: invokevirtual 175	android/view/View:findViewById	(I)Landroid/view/View;
    //   45: checkcast 181	android/widget/ImageView
    //   48: astore 6
    //   50: aload_1
    //   51: ifnull +9 -> 60
    //   54: aload 5
    //   56: aload_1
    //   57: invokevirtual 185	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   60: aload 6
    //   62: aload_3
    //   63: invokevirtual 189	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   66: aload 4
    //   68: aload_2
    //   69: invokevirtual 190	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   72: aload_0
    //   73: areturn
    //   74: astore_0
    //   75: aload 4
    //   77: astore_0
    //   78: ldc 192
    //   80: iconst_1
    //   81: ldc 194
    //   83: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: aload_0
    //   87: areturn
    //   88: astore_1
    //   89: goto -11 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramContext	Context
    //   0	92	1	paramString	String
    //   0	92	2	paramOnClickListener1	android.view.View.OnClickListener
    //   0	92	3	paramOnClickListener2	android.view.View.OnClickListener
    //   1	75	4	localView	View
    //   37	18	5	localTextView	TextView
    //   48	13	6	localImageView	android.widget.ImageView
    // Exception table:
    //   from	to	target	type
    //   9	20	74	java/lang/RuntimeException
    //   20	50	88	java/lang/RuntimeException
    //   54	60	88	java/lang/RuntimeException
    //   60	72	88	java/lang/RuntimeException
  }
  
  @SuppressLint({"InflateParams"})
  public static Toast a(Context paramContext, String paramString)
  {
    Toast localToast = new Toast(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2131558694, null);
    localToast.setView(localView);
    localToast.setGravity(55, 0, paramContext.getResources().getDimensionPixelSize(2131299627));
    localToast.setDuration(1);
    ((TextView)localView.findViewById(2131362520)).setText(paramString);
    localView.setOnClickListener(new ulb(localToast));
    return localToast;
  }
  
  public static aqju a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if ((paramContext instanceof Activity)) {}
    for (paramQQAppInterface = paramContext;; paramQQAppInterface = com.tencent.mobileqq.app.BaseActivity.sTopActivity)
    {
      paramQQAppInterface = (Activity)paramQQAppInterface;
      if ((paramQQAppInterface != null) && (!aqux.a(paramQQAppInterface, 4, new ulf(paramOnClickListener1, paramOnClickListener2), "qav"))) {
        break;
      }
      return PopupDialog.b(paramContext, 230, paramString1, paramString2, paramInt2, paramInt3, paramOnClickListener1, paramOnClickListener2);
    }
    return null;
  }
  
  public static com.tencent.mobileqq.app.BaseActivity a(long paramLong, Context paramContext)
  {
    Object localObject2;
    if ((paramContext instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localObject2 = (com.tencent.mobileqq.app.BaseActivity)paramContext;
      localObject1 = localObject2;
      if (!((com.tencent.mobileqq.app.BaseActivity)localObject2).isFinishing()) {}
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
        QLog.w("ChatActivityUtils", 1, "getBaseActivity, Context[" + paramContext + "], baseActivity[" + localObject2 + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
      }
      return localObject2;
    }
  }
  
  private static MessageRecord a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    int i = paramMessageRecord.msgtype;
    MessageRecord localMessageRecord;
    if ((i == -1003) || (i == -1031) || (i == -1032) || (i == -3001) || (top.eD(paramMessageRecord.istroop) == 1032)) {
      localMessageRecord = null;
    }
    do
    {
      return localMessageRecord;
      localMessageRecord = paramMessageRecord;
    } while (!((acff)paramQQAppInterface.getManager(51)).isFriend(paramMessageRecord.frienduin));
    return null;
  }
  
  public static MessageRecord a(List<ChatMessage> paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!fY(paramSessionInfo.cZ)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.cZ == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int j = paramList.size();
    int i;
    if (paramSessionInfo.cZ != 10008)
    {
      i = 1;
      label72:
      j -= 1;
      label78:
      if (j < 0) {
        break label140;
      }
      paramSessionInfo = (MessageRecord)paramList.get(j);
      if (((i != 0) && (paramSessionInfo.isSend())) || (top.fz(paramSessionInfo.msgtype))) {
        break label131;
      }
    }
    label131:
    label140:
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i = 0;
      break label72;
      j -= 1;
      break label78;
    }
  }
  
  public static CharSequence a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, long paramLong)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject1;
    int i;
    if (paramMessageRecord != null)
    {
      localObject2 = paramMessageRecord.senderuin;
      String str = paramMessageRecord.frienduin;
      i = paramMessageRecord.istroop;
      if ((paramMessageRecord.isSend()) || (anbk.ls(paramMessageRecord.msgtype))) {
        break label506;
      }
      if (1000 != i) {
        break label112;
      }
      a(paramSessionInfo, paramMessageRecord, paramLong);
      localObject1 = localObject3;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("ChatActivityUtils", 2, "generateMsgSource, isTroop = " + i);
        localObject2 = localObject1;
      }
    }
    label109:
    return localObject2;
    label112:
    if (1020 == i)
    {
      paramQQAppInterface = ((HotChatManager)paramQQAppInterface.getManager(60)).c(paramMessageRecord.senderuin);
      if (paramQQAppInterface == null) {
        break label611;
      }
      paramQQAppInterface = paramQQAppInterface.name;
    }
    label611:
    for (paramQQAppInterface = String.format(paramContext.getString(2131694044), new Object[] { paramSessionInfo.aTn, paramQQAppInterface });; paramQQAppInterface = null)
    {
      localObject1 = paramQQAppInterface;
      break;
      if (1004 == i)
      {
        paramQQAppInterface = aqgv.e(paramQQAppInterface, (String)localObject2, 3000);
        localObject1 = String.format(paramContext.getString(2131694041), new Object[] { paramSessionInfo.aTn, paramQQAppInterface });
        a(paramSessionInfo, paramMessageRecord, paramLong);
        break;
      }
      localObject1 = localObject3;
      if (1001 == i) {
        break;
      }
      localObject1 = localObject3;
      if (10002 == i) {
        break;
      }
      if (10004 == i)
      {
        localObject1 = String.format(paramContext.getString(2131694046), new Object[] { paramSessionInfo.aTn });
        break;
      }
      localObject1 = localObject3;
      if (1006 == i) {
        break;
      }
      if (1009 == i)
      {
        localObject1 = String.format(paramContext.getString(2131694048), new Object[] { paramSessionInfo.aTn });
        break;
      }
      localObject1 = localObject3;
      if (1005 == i) {
        break;
      }
      if (1021 == i)
      {
        localObject1 = String.format(paramContext.getString(2131694035), new Object[] { paramSessionInfo.aTn });
        break;
      }
      if (1022 == i)
      {
        localObject1 = String.format(paramContext.getString(2131694042), new Object[] { paramSessionInfo.aTn });
        break;
      }
      if (1023 == i)
      {
        localObject1 = String.format(paramContext.getString(2131694047), new Object[] { paramSessionInfo.aTn });
        break;
      }
      if (1010 == i)
      {
        localObject1 = paramQQAppInterface.a().mp(paramSessionInfo.aTn);
        break;
      }
      localObject1 = localObject3;
      if (i != 10008) {
        break;
      }
      localObject1 = paramContext.getString(2131700714);
      a(paramSessionInfo, paramMessageRecord, paramLong);
      break;
      label506:
      localObject2 = localObject1;
      if (1006 != i) {
        break label109;
      }
      paramSessionInfo = String.format(paramContext.getString(2131694038), new Object[] { paramSessionInfo.aTn });
      paramQQAppInterface = paramContext.getString(2131694037);
      if (a == null) {
        a = new AddFriendSpan(paramQQAppInterface, paramContext.getResources().getColor(2131166596));
      }
      i = paramSessionInfo.lastIndexOf(paramQQAppInterface);
      paramContext = new SpannableStringBuilder(paramSessionInfo);
      paramContext.setSpan(a, i, paramQQAppInterface.length() + i, 33);
      return paramContext;
    }
  }
  
  public static Integer a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (cT == null)) {
      return null;
    }
    return (Integer)cT.get(paramString1 + paramString2);
  }
  
  public static String a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).b(paramString);
      if (paramQQAppInterface == null) {
        return paramContext.getString(2131700716);
      }
      if (TextUtils.isEmpty(paramQQAppInterface.getTroopName())) {
        return paramContext.getString(2131700716);
      }
      paramQQAppInterface = String.format(paramContext.getString(2131700717), new Object[] { paramQQAppInterface.getTroopName() });
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return paramContext.getString(2131700716);
  }
  
  public static String a(Context paramContext, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null) {}
    switch (paramMessageRecord.istroop)
    {
    default: 
      localObject1 = localObject2;
    case 1000: 
    case 1020: 
      AppRuntime localAppRuntime;
      do
      {
        do
        {
          do
          {
            return localObject1;
            try
            {
              paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
              paramMessageRecord = paramQQAppInterface.b(paramQQAppInterface.jq(paramMessageRecord.senderuin));
              if (paramMessageRecord == null)
              {
                paramMessageRecord = paramContext.getString(2131700716);
                paramContext = paramMessageRecord;
              }
              else if (TextUtils.isEmpty(paramMessageRecord.getTroopName()))
              {
                paramMessageRecord = paramContext.getString(2131700716);
                paramContext = paramMessageRecord;
              }
              else
              {
                paramMessageRecord = String.format(paramContext.getString(2131700717), new Object[] { paramMessageRecord.getTroopName() });
                paramContext = paramMessageRecord;
              }
            }
            catch (Exception paramMessageRecord)
            {
              paramMessageRecord.printStackTrace();
              paramContext = paramContext.getString(2131700716);
              localObject1 = paramContext;
            }
          } while (!QLog.isColorLevel());
          QLog.d("ChatActivityUtils", 2, "UIN_TYPE_OPEN_TROOP_MEMBER_STRANGER or UIN_TYPE_GROUP_MEMBER_STRANGER error");
          return paramContext;
          localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
          localObject1 = localObject2;
        } while (localAppRuntime == null);
        localObject1 = localObject2;
      } while (!(localAppRuntime instanceof QQAppInterface));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramQQAppInterface != null)
      {
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(60);
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (TextUtils.isEmpty(((HotChatManager)localObject1).jk(paramMessageRecord.senderuin))) {
          break;
        }
      }
      break;
    }
    for (paramContext = paramContext.getString(2131700708);; paramContext = null)
    {
      return paramContext;
      return paramContext.getString(2131700706);
      return paramContext.getString(2131700709);
      return paramContext.getString(2131696065);
      return paramContext.getString(2131700710);
      return paramContext.getString(2131700705);
      return paramContext.getString(2131700703);
      return paramContext.getString(2131700715);
      return paramContext.getString(2131700718);
      return paramContext.getString(2131700702);
      return paramContext.getString(2131700707);
      return paramContext.getString(2131700711);
      return paramContext.getString(2131700714);
    }
    return paramContext;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    paramQQAppInterface = (asgx)paramQQAppInterface.getManager(165);
    if (paramQQAppInterface.Q(paramString, false)) {
      return paramQQAppInterface.as(paramContext, paramString);
    }
    return null;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, View paramView, boolean paramBoolean)
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo;
    if ((paramChatMessage instanceof MessageForReplyText)) {
      localSourceMsgInfo = ((MessageForReplyText)paramChatMessage).mSourceMsgInfo;
    }
    for (;;)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1;
      if (localSourceMsgInfo != null)
      {
        String str2 = aqmu.a(paramContext, 3, localSourceMsgInfo.mSourceMsgTime * 1000L).toString();
        str1 = "";
        if (!TextUtils.isEmpty(localSourceMsgInfo.mAnonymousNickName))
        {
          paramContext = localSourceMsgInfo.mAnonymousNickName;
          label83:
          localStringBuilder2.append("“").append(str2).append(" ").append(paramContext).append("\r\n");
          localStringBuilder1.append("     ").append("\r\n");
          if (paramChatMessage.istroop != 0) {
            break label455;
          }
          paramQQAppInterface = paramQQAppInterface.b().d(paramChatMessage.frienduin, 0, localSourceMsgInfo.mSourceMsgTime, localSourceMsgInfo.origUid);
          label159:
          if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
            break label477;
          }
          paramQQAppInterface = (MessageRecord)paramQQAppInterface.get(0);
          label183:
          if (!(paramQQAppInterface instanceof MessageForLongTextMsg)) {
            break label482;
          }
          localStringBuilder2.append(paramQQAppInterface.msg).append("\r\n");
          localStringBuilder1.append(new aofk(paramQQAppInterface.msg, 13, 32));
          label227:
          MessageForReplyText.reportReplyMsg(null, "replyMsg_bubble", "doubleClk", paramChatMessage.frienduin, paramChatMessage);
        }
      }
      else
      {
        if (paramBoolean) {
          break label619;
        }
      }
      label455:
      label477:
      label482:
      label619:
      for (paramQQAppInterface = "";; paramQQAppInterface = paramChatMessage.getSummaryMsg())
      {
        localStringBuilder2.append(paramQQAppInterface);
        paramQQAppInterface = localStringBuilder2.toString();
        if ((paramView.getId() != 2131371989) || (!(paramView instanceof ETTextView))) {
          break label627;
        }
        return localStringBuilder1.toString();
        if (!(paramChatMessage instanceof MessageForLongMsg)) {
          break label658;
        }
        localSourceMsgInfo = ((MessageForLongMsg)paramChatMessage).mSourceMsgInfo;
        break;
        if (localSourceMsgInfo.mSourceMsgSenderUin == 50000000L)
        {
          Object localObject = xmb.a(paramQQAppInterface, paramChatMessage.frienduin, paramChatMessage.istroop, localSourceMsgInfo.mSourceMsgSeq);
          paramContext = str1;
          if (localObject == null) {
            break label83;
          }
          localObject = apsb.a((MessageRecord)localObject);
          paramContext = str1;
          if (localObject == null) {
            break label83;
          }
          localSourceMsgInfo.mAnonymousNickName = ((apsb.a)localObject).nickname;
          paramContext = str1;
          break label83;
        }
        if (paramChatMessage.istroop == 0)
        {
          paramContext = aqgv.D(paramQQAppInterface, localSourceMsgInfo.mSourceMsgSenderUin + "");
          break label83;
        }
        paramContext = aqgv.a(paramQQAppInterface, paramChatMessage.istroop, paramChatMessage.frienduin, localSourceMsgInfo.mSourceMsgSenderUin + "");
        break label83;
        paramQQAppInterface = paramQQAppInterface.b().c(paramChatMessage.frienduin, 1, localSourceMsgInfo.mSourceMsgSeq, 0L);
        break label159;
        paramQQAppInterface = null;
        break label183;
        if (localSourceMsgInfo.mSourceSummaryFlag == 1)
        {
          localStringBuilder2.append(localSourceMsgInfo.mSourceMsgText).append("\r\n");
          localStringBuilder1.append(new aofk(localSourceMsgInfo.mSourceMsgText, 13, 32));
          break label227;
        }
        if (paramQQAppInterface != null)
        {
          localStringBuilder2.append(paramQQAppInterface.msg).append("\r\n");
          localStringBuilder1.append(new aofk(paramQQAppInterface.msg, 13, 32));
          break label227;
        }
        localStringBuilder2.append(localSourceMsgInfo.mSourceMsgText).append("\r\n");
        localStringBuilder1.append(new aofk(localSourceMsgInfo.mSourceMsgText, 13, 32));
        break label227;
      }
      label627:
      if ((paramView.getId() == 2131364531) && ((ETTextView)paramView.findViewById(2131371989) != null)) {
        return localStringBuilder1.toString();
      }
      return paramQQAppInterface;
      label658:
      localSourceMsgInfo = null;
    }
  }
  
  private static void a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    long l = paramQQAppInterface.a().bG();
    int i = paramQQAppInterface.a().lg();
    int j = paramQQAppInterface.a().z(l);
    QLog.w("ChatActivityUtils", 1, "sendExitBroadcast, finalType[" + paramInt1 + "], finalAvType[" + paramInt2 + "], chattingType[" + i + "], seq[" + paramLong + "]");
    if ((paramInt1 == 1) || (i == 1))
    {
      if ((j != 2) || (paramInt2 == 2)) {
        break label133;
      }
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
    label133:
    while ((j == 2) || (paramInt2 != 2)) {
      return;
    }
    paramQQAppInterface = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
    jlc.a(paramQQAppInterface, paramLong);
    paramContext.sendBroadcast(paramQQAppInterface);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean)
  {
    a(paramActivity, paramSessionInfo, paramString, paramBoolean, false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 3999;
    int j = 0;
    FragmentActivity localFragmentActivity;
    if (paramBoolean2)
    {
      i = 3071;
      j = 11;
      if ((i != 3007) || ((!(paramActivity instanceof SplashActivity)) && (!(paramActivity instanceof ChatActivity)))) {
        break label352;
      }
      localFragmentActivity = (FragmentActivity)paramActivity;
      if (acgr.y(localFragmentActivity.getChatFragment().getApp(), paramSessionInfo.aTl)) {
        break label418;
      }
      localFragmentActivity.getChatFragment().a().vh(localFragmentActivity.getString(2131696214));
    }
    label352:
    do
    {
      return;
      switch (paramSessionInfo.cZ)
      {
      default: 
        break;
      case 1000: 
        i = 3004;
        j = 3;
        break;
      case 1001: 
        i = 3007;
        j = 2;
        break;
      case 1005: 
        i = 3008;
        j = 12;
        break;
      case 1009: 
        i = 3013;
        break;
      case 1006: 
        i = 3006;
        j = 12;
        break;
      case 10004: 
        i = 3043;
        j = 2;
        break;
      case 1004: 
        i = 3005;
        j = 2;
        break;
      case 1021: 
        i = 3003;
        j = 2;
        break;
      case 1023: 
        i = 3008;
        j = 11;
        break;
      case 1010: 
        i = 3019;
        break;
      case 1022: 
        i = 3041;
        j = 11;
        break;
      case 1024: 
        i = 3072;
        j = 1;
        break;
      case 10008: 
        i = 3080;
        j = 3;
        break;
        if ((i == 3019) && (((paramActivity instanceof SplashActivity)) || ((paramActivity instanceof ChatActivity))))
        {
          localFragmentActivity = (FragmentActivity)paramActivity;
          if (!afck.F(localFragmentActivity.getChatFragment().getApp(), paramSessionInfo.aTl))
          {
            localFragmentActivity.getChatFragment().a().vh(localFragmentActivity.getString(2131696214));
            return;
          }
        }
        if (paramSessionInfo.cZ != 1006) {
          break label475;
        }
      }
    } while ((paramSessionInfo.aTl == null) || (paramSessionInfo.aTl.length() <= 0));
    label418:
    paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 2, paramSessionInfo.aTl, paramSessionInfo.troopUin, i, j, paramSessionInfo.aTn, null, null, paramString, null));
    return;
    label475:
    if (paramBoolean1)
    {
      paramActivity.startActivity(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.aTl, paramSessionInfo.troopUin, i, j, paramSessionInfo.aTn, null, AddContactsActivity.class.getName(), paramString, null));
      return;
    }
    paramActivity.startActivityForResult(AddFriendLogicActivity.a(paramActivity, 1, paramSessionInfo.aTl, paramSessionInfo.troopUin, i, j, paramSessionInfo.aTn, null, null, paramString, null), 11);
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramQQAppInterface, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    int m = 0;
    int j = 1;
    Object localObject1;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label49;
      }
    }
    label49:
    for (Object localObject2 = (mqq.app.BaseActivity)paramActivity;; localObject2 = null)
    {
      if ((localObject1 != null) || (localObject2 != null)) {
        break label55;
      }
      return;
      localObject1 = null;
      break;
    }
    label55:
    int i;
    if (localObject1 != null) {
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.CAMERA") != 0)
      {
        i = 1;
        if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
          break label145;
        }
      }
    }
    for (;;)
    {
      label84:
      if (paramBoolean) {
        i = m;
      }
      for (;;)
      {
        if ((i != 0) && (j != 0)) {
          localObject1 = acfp.m(2131703588);
        }
        for (;;)
        {
          localObject2 = new ulg(paramActivity, paramOnClickListener);
          aqha.a(paramActivity, null, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2, new ulh(paramOnClickListener));
          return;
          i = 0;
          break;
          label145:
          j = 0;
          break label84;
          if (localObject2 == null) {
            break label228;
          }
          if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.CAMERA") != 0) {}
          for (int k = 1;; k = 0)
          {
            i = k;
            if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
              break;
            }
            j = 0;
            i = k;
            break;
          }
          if (i != 0) {
            localObject1 = acfp.m(2131703566);
          } else {
            localObject1 = acfp.m(2131703573);
          }
        }
      }
      label228:
      i = 1;
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = paramQQAppInterface.a().a(aqgb.bM(paramLong));
    if ((localObject2 != null) && (QLog.isColorLevel())) {
      QLog.d("gameShareOnClick", 2, "<--gameShareOnClick appShareID.bundleid" + ((AppShareID)localObject2).bundleid);
    }
    if ((localObject2 != null) && (((AppShareID)localObject2).bundleid != null) && (aqiz.isAppInstalled(paramContext, ((AppShareID)localObject2).bundleid)))
    {
      long l = aqgb.X(paramLong);
      Object localObject1 = paramQQAppInterface.a().a(String.valueOf(l));
      localObject2 = ((AppShareID)localObject2).bundleid;
      if (localObject1 == null)
      {
        localObject1 = null;
        aqiz.r(paramContext, (String)localObject2, (String)localObject1);
        if ((paramInt != -3005) && (paramInt != -3004) && ((paramString == null) || (!paramString.startsWith("https://gamecenter.qq.com")))) {
          break label206;
        }
      }
      label206:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Launch_game", 0, 1, null, String.valueOf(aqgb.X(paramLong)), null, null, null);
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
    String str = paramString.trim();
    if ((paramInt == -3005) || (paramInt == -3004) || (str.startsWith("https://gamecenter.qq.com")))
    {
      paramInt = 1;
      if (55901189L != paramLong) {
        break label181;
      }
      paramString = avpw.d.a();
      paramString.cMP = paramQQAppInterface.getCurrentAccountUin();
      paramString.nickname = paramQQAppInterface.getCurrentNickname();
      avpw.a((Activity)paramContext, paramString, str, "mqqChat", -1);
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label333;
      }
      anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(aqgb.X(paramLong)), null, null, null);
      return;
      paramInt = 0;
      break;
      label181:
      hc(str);
      Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      paramString = jpa.r(str, "from=androidqq");
      if (paramInt != 0)
      {
        localIntent.putExtra("param_force_internal_browser", true);
        paramString = jpa.r(str, "platformId=qq_m");
      }
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("url", paramString.trim());
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", paramLong);
      paramString = paramString.toString();
      if (paramString.startsWith("http://browserApp.p.qq.com/"))
      {
        localIntent.putExtra("url", paramString);
        localIntent.setClass(paramContext, PublicAccountBrowser.class);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
      }
      paramContext.startActivity(localIntent);
    }
    label333:
    anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, "sha_click", 1, "", "", String.valueOf(aqgb.X(paramLong)));
  }
  
  public static void a(SessionInfo paramSessionInfo, Intent paramIntent)
  {
    if ((paramSessionInfo != null) && (paramIntent != null))
    {
      paramIntent.putExtra("uin", paramSessionInfo.aTl);
      paramIntent.putExtra("uintype", paramSessionInfo.cZ);
      paramIntent.putExtra("uinname", paramSessionInfo.aTn);
      paramIntent.putExtra("troop_uin", paramSessionInfo.troopUin);
      paramIntent.putExtra("phonenum", paramSessionInfo.phoneNum);
    }
  }
  
  private static void a(SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, long paramLong)
  {
    if ((paramSessionInfo == null) || (paramMessageRecord == null)) {}
    do
    {
      return;
      if ((paramLong == -1L) || (paramMessageRecord.shmsgseq == paramLong))
      {
        QLog.d("ChatActivityUtils", 2, "preMrShMsgSeq = " + paramLong);
        return;
      }
    } while (paramSessionInfo.cZ == paramMessageRecord.istroop);
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "updateSession, type from " + paramSessionInfo.cZ + ", to " + paramMessageRecord.istroop);
    }
    paramSessionInfo.cZ = paramMessageRecord.istroop;
    paramSessionInfo.troopUin = paramMessageRecord.senderuin;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramQQAppInterface, paramActivity, paramInt, paramString1, paramString2, paramBoolean, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (aqiw.isNetSupport(BaseApplication.getContext())) {
      if (paramInt == 0)
      {
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
        if (paramQQAppInterface == null) {}
      }
    }
    label336:
    label348:
    while ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      long l;
      do
      {
        try
        {
          l = Long.parseLong(paramString1);
          if (l > 0L)
          {
            if (!paramBoolean1)
            {
              paramBoolean1 = bool;
              paramQQAppInterface.ai(l, paramBoolean1);
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
            paramBoolean1 = false;
          }
        }
      } while (paramInt == 25);
      aizg localaizg = (aizg)paramQQAppInterface.getManager(16);
      String str = paramString1;
      if (localaizg != null)
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
          str = aqgv.x(paramQQAppInterface, paramString2);
          paramString1 = str;
          l = Long.parseLong(str);
          paramString1 = str;
          paramString2 = new ArrayList();
          paramString1 = str;
          paramString2.add(Long.valueOf(l));
          if (paramBoolean1)
          {
            paramString1 = str;
            localaizg.U(paramInt, paramString2);
            i = 1;
            if ((paramInt == 1001) || (paramInt == 10002))
            {
              if ((str != null) && (str.length() > 0))
              {
                if (!paramBoolean1) {
                  break label336;
                }
                paramQQAppInterface.a().Ek(str);
              }
              i = 1;
            }
            if ((paramActivity == null) || (paramActivity.isFinishing())) {
              break;
            }
            if (i == 0) {
              break label348;
            }
            bs(paramActivity);
            return;
          }
          if (paramBoolean2)
          {
            paramString1 = str;
            if (jdField_C_of_type_JavaUtilQueue.size() > 5)
            {
              paramString1 = str;
              jdField_C_of_type_JavaUtilQueue.poll();
            }
            paramString1 = str;
            jdField_C_of_type_JavaUtilQueue.offer(str);
          }
          paramString1 = str;
          localaizg.T(paramInt, paramString2);
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
        paramQQAppInterface.a().Ej(str);
      }
      if (paramBoolean1)
      {
        i(paramActivity, 2131720205, 1);
        return;
      }
      i(paramActivity, 2131720207, 1);
      return;
    }
    i(paramActivity, 2131696206, 1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2)
  {
    a(paramQQAppInterface, paramActivity, paramSessionInfo, paramInt1, paramIntent, paramInt2, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, int paramInt1, Intent paramIntent, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    String str = null;
    if (paramInt1 == 1)
    {
      str = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      if (!str.equalsIgnoreCase("")) {
        if (paramInt2 == 1)
        {
          localObject = BaseApplication.getContext();
          if (Build.VERSION.SDK_INT <= 10) {
            break label133;
          }
        }
      }
      label133:
      for (paramInt1 = 4;; paramInt1 = 0)
      {
        ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", paramInt1).edit().putString("shot_photo_path", str).commit();
        localObject = Uri.fromFile(new File(str));
        PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().remove("camera_photo_path").commit();
        if (localObject != null) {
          break;
        }
        return;
      }
      str = aqhu.getRealPathFromContentURI(paramActivity, (Uri)localObject);
      if (str == null) {
        break label836;
      }
      aqhu.cn(paramActivity, str);
      if (!aqhq.rr(str))
      {
        QQToast.a(paramActivity, paramActivity.getString(2131693663), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      if (!new File(str).exists())
      {
        QQToast.a(paramActivity, paramActivity.getString(2131696981), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
    }
    Intent localIntent = new Intent();
    if (paramQQAppInterface != null)
    {
      localObject = paramQQAppInterface.getAccount();
      Friends localFriends = ((acff)paramQQAppInterface.getManager(51)).e((String)localObject);
      localIntent.putExtra("PhotoConst.MY_UIN", (String)localObject);
      if (localFriends != null) {
        localIntent.putExtra("PhotoConst.MY_NICK", localFriends.name);
      }
      localObject = (HotChatManager)paramQQAppInterface.getManager(60);
      if (localObject != null) {
        localIntent.putExtra("showFlashPic", acei.a(paramSessionInfo.cZ, (HotChatManager)localObject, paramSessionInfo.troopUin));
      }
    }
    localIntent.putExtra("uin", paramSessionInfo.aTl);
    localIntent.putExtra("uintype", paramSessionInfo.cZ);
    localIntent.putExtra("troop_uin", paramSessionInfo.troopUin);
    localIntent.putExtra("uinname", paramSessionInfo.aTn);
    localIntent.putExtra("entrance", paramSessionInfo.entrance);
    localIntent.putExtra("key_confess_topicid", paramSessionInfo.topicId);
    localIntent.putExtra("is_anonymous", jof.a().dd(paramSessionInfo.aTl));
    int j = 0;
    int k = -1;
    int i = k;
    paramInt1 = j;
    if (paramIntent != null)
    {
      int m = paramIntent.getIntExtra("camera_type", 1);
      paramInt1 = paramIntent.getIntExtra("camera_front_back", 0);
      i = paramIntent.getIntExtra("camera_filter_id", -1);
      int n = paramIntent.getIntExtra("camera_capture_method", -1);
      localIntent.putExtra("camera_type", m);
      localIntent.putExtra("camera_front_back", paramInt1);
      localIntent.putExtra("camera_filter_id", i);
      localIntent.putExtra("camera_capture_method", n);
      i = k;
      paramInt1 = j;
      if (m == 103)
      {
        paramInt1 = 1;
        i = 100012;
      }
    }
    if ((!SplashActivity.class.isInstance(paramActivity)) && (!ChatActivity.class.isInstance(paramActivity)))
    {
      localIntent.putExtras(paramActivity.getIntent());
      localObject = localIntent;
      ((Intent)localObject).putExtra("enter_from", 50);
      if (paramInt2 != -1)
      {
        if (paramInt2 != 8) {
          break label1071;
        }
        if (paramQQAppInterface != null) {
          wmj.a((Intent)localObject, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject).putExtra("callFromFastImage", true);
        ((Intent)localObject).putExtra("FROM_WHERE", "FromFastImage");
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1037);
        ((Intent)localObject).putExtra("key_activity_code", d(paramActivity));
      }
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        boolean bool = paramIntent.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
        paramInt2 = paramIntent.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", -1);
        ((Intent)localObject).putExtra("PhotoConst.IS_SINGLE_MODE", bool);
        if (paramInt2 == 1039) {
          ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1039);
        }
        if (paramInt2 == 1040) {
          ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1040);
        }
        PhotoUtils.a(paramIntent, (Intent)localObject);
      }
      paramQQAppInterface = new ArrayList();
      paramQQAppInterface.add(str);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramQQAppInterface);
      ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      ((Intent)localObject).putExtra("PhotoConst.ALLOW_LOCK", paramBoolean);
      ((Intent)localObject).setClass(paramActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject).addFlags(603979776);
      if (paramInt1 == 0) {
        break label1115;
      }
      paramActivity.startActivityForResult((Intent)localObject, i);
      return;
      label836:
      QQToast.a(paramActivity, paramActivity.getString(2131696981), 0).show(paramActivity.getResources().getDimensionPixelSize(2131299627));
      return;
      if ((paramActivity instanceof SplashActivity))
      {
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = wja.a(localIntent, null);
        label892:
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        if (paramSessionInfo.cZ != 9501) {
          break label1031;
        }
        if (!(paramActivity instanceof SplashActivity)) {
          break label1013;
        }
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
        localObject = wja.a((Intent)localObject, null);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 82);
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        break;
        localObject = localIntent;
        if (!(paramActivity instanceof ChatActivity)) {
          break label892;
        }
        localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
        localObject = localIntent;
        break label892;
        label1013:
        ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      }
      label1031:
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      break;
      label1071:
      if (paramInt2 == 1)
      {
        if (paramQQAppInterface != null) {
          wmj.a((Intent)localObject, paramSessionInfo, paramQQAppInterface);
        }
        ((Intent)localObject).putExtra("FROM_WHERE", "FromCamera");
        ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1008);
      }
    }
    label1115:
    paramActivity.startActivity((Intent)localObject);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    DiscussionInfo localDiscussionInfo;
    int i;
    if (paramInt == 3000)
    {
      localDiscussionInfo = ((acdu)paramQQAppInterface.getManager(53)).a(paramString);
      if (localDiscussionInfo != null) {
        if (localDiscussionInfo.isPSTNConf())
        {
          AudioHelper.rw("发起音视频_获取会议id");
          a.a("ChatActivityUtils", localDiscussionInfo.uin, new uky(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        b(paramQQAppInterface, paramContext, paramInt, paramString, paramBundle);
      }
      return;
      if ((localDiscussionInfo.isDiscussHrMeeting()) && ((paramBundle == null) || (!paramBundle.containsKey("MeetingStasks"))))
      {
        AudioHelper.rw("发起音视频_获取hr信息");
        aqjl.a(paramQQAppInterface, paramString, paramQQAppInterface.getCurrentAccountUin(), new ukz(paramBundle, paramQQAppInterface, paramContext, paramInt, paramString));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, String paramString5, Map<String, String> paramMap, boolean paramBoolean2)
  {
    int n = tzc.a().a(0, 1, 1, 0, 3000, 101, 4L, Process.myTid(), "bootVideo");
    Object localObject1 = paramString1;
    Object localObject2;
    if (paramInt == 1011)
    {
      if (!jjy.cK("random_talk_bg_2.png")) {
        jjy.y(paramQQAppInterface);
      }
      localObject1 = paramString1;
      if (paramMap != null)
      {
        localObject1 = (String)paramMap.get("chat_type");
        localObject1 = paramString1;
        if (paramMap != null)
        {
          localObject2 = (String)paramMap.get("encodeuin");
          localObject1 = paramString1;
          if (localObject2 != null)
          {
            localObject1 = paramString1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = f(paramQQAppInterface, (String)localObject2);
              if (localObject1 == null) {
                break label366;
              }
            }
          }
        }
      }
    }
    QLog.w("ChatActivityUtils", 1, "avideo enterVideo called, uinType[" + paramInt + "], peerUin[" + (String)localObject1 + "], name[" + paramString2 + "], phoneNum[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], extraUin[" + paramString4 + "], from[" + paramString5 + "]");
    if ((paramQQAppInterface.bF()) && (paramQQAppInterface.a().lk() != 1) && (paramQQAppInterface.a().lk() != 3000) && (paramQQAppInterface.a().up()) && (paramQQAppInterface.a().uo()) && (paramQQAppInterface.a().lk() != 1011) && (paramQQAppInterface.a().lk() != 21))
    {
      paramQQAppInterface = new Intent(paramContext, VideoInviteActivity.class);
      paramQQAppInterface.addFlags(268435456);
      paramQQAppInterface.putExtra("uinType", paramInt);
      paramQQAppInterface.putExtra("peerUin", (String)localObject1);
      paramQQAppInterface.putExtra("extraUin", paramString4);
      paramQQAppInterface.putExtra("isAudioMode", paramBoolean1);
      paramContext.startActivity(paramQQAppInterface);
    }
    for (;;)
    {
      return;
      label366:
      QLog.e("ChatActivityUtils", 1, "enterVideo Chat AnyOne decode peeruin Err!");
      return;
      try
      {
        paramString1 = MediaPlayerManager.a(paramQQAppInterface);
        if (paramString1 != null) {
          paramString1.stop(true);
        }
        if (paramInt == 0)
        {
          paramString1 = ((acff)paramQQAppInterface.getManager(51)).e((String)localObject1);
          if (paramString1 != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatActivityUtils", 2, "enterVideo terminal: " + aqgv.d(paramString1) + ", abilityBits: " + paramString1.abilityBits + ", _eSupportVoice: " + 1);
            }
            if (paramString1.getNetWorkType() != 2)
            {
              bool1 = true;
              if ((paramInt == 1006) || (paramInt == 24) || (paramInt == 25)) {
                if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty(paramString3)))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("ChatActivityUtils", 2, "enterVideo uinType: " + paramInt + ", peerUin: " + (String)localObject1 + ", name: " + paramString2 + ", phoneNum: " + paramString3 + ", onlyAudio: " + paramBoolean1 + ", extraUin: " + paramString4);
                  return;
                }
              }
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
          continue;
          Object localObject5 = ((ajdo)paramQQAppInterface.getManager(11)).a();
          Object localObject3;
          if (localObject5 != null)
          {
            paramString1 = ((RespondQueryQQBindingStat)localObject5).nationCode;
            localObject3 = ((RespondQueryQQBindingStat)localObject5).mobileNo;
          }
          for (;;)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = paramString3;
              localObject4 = paramString3;
            }
            while (((paramInt == 24) || (paramInt == 25)) && ((localObject5 == null) || (((RespondQueryQQBindingStat)localObject5).nationCode.equals("")) || (((RespondQueryQQBindingStat)localObject5).mobileNo.equals(""))))
            {
              QQToast.a(paramContext, 2131697933, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
              return;
              localObject2 = localObject1;
              localObject4 = paramString3;
              if (TextUtils.isEmpty(paramString3))
              {
                localObject4 = localObject1;
                localObject2 = localObject1;
              }
            }
            localObject1 = localObject3;
            localObject3 = paramString1;
            paramString3 = (String)localObject4;
            paramString1 = (String)localObject2;
            localObject2 = localObject3;
            for (;;)
            {
              if (paramInt != 1000) {
                break label2749;
              }
              localObject3 = (TroopManager)paramQQAppInterface.getManager(52);
              if (localObject3 == null) {
                break label2742;
              }
              localObject3 = ((TroopManager)localObject3).jp(paramString4);
              label807:
              if (localObject3 != null) {
                break label910;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.e("ChatActivityUtils", 2, "enterVideo can't find troop info!");
              return;
              if (TextUtils.isEmpty(paramString3))
              {
                paramString1 = ((ajdo)paramQQAppInterface.getManager(11)).a((String)localObject1);
                if (paramString1 != null)
                {
                  paramString3 = paramString1.mobileNo;
                  localObject3 = null;
                  localObject2 = null;
                  paramString1 = (String)localObject1;
                  localObject1 = localObject3;
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.w("ChatActivityUtils", 2, "enterVideo cannot get phone number");
                }
              }
              localObject3 = null;
              localObject2 = null;
              paramString1 = (String)localObject1;
              localObject1 = localObject3;
            }
            label910:
            label1062:
            label1334:
            label2749:
            for (Object localObject4 = localObject3;; localObject4 = paramString4)
            {
              localObject3 = paramString4;
              if (paramInt == 9500)
              {
                if (paramMap == null) {
                  break label1062;
                }
                localObject3 = (String)paramMap.get("devSubCode");
              }
              int i;
              for (;;)
              {
                if (paramInt == 1011) {
                  label1128:
                  try
                  {
                    paramString4 = (String)paramMap.get("sig");
                    if (QLog.isColorLevel()) {
                      QLog.e("ChatActivityUtils", 2, "sig string=" + paramString4);
                    }
                    localObject5 = paramString4.replace("+", "").split(",");
                    paramString4 = new byte[localObject5.length];
                    i = 0;
                    while (i < localObject5.length)
                    {
                      paramString4[i] = Byte.parseByte(localObject5[i].trim());
                      i += 1;
                      continue;
                      localObject3 = "";
                    }
                  }
                  catch (Exception paramQQAppInterface) {}
                }
              }
              try
              {
                localObject5 = new String(p(paramString2), "UTF-8");
                paramString2 = (String)localObject5;
              }
              catch (Exception localException2)
              {
                AppRuntime.Status localStatus;
                boolean bool2;
                int i1;
                int i2;
                int i3;
                break label1128;
              }
              try
              {
                if (QLog.isColorLevel())
                {
                  QLog.e("ChatActivityUtils", 2, "UTF-8 == " + (String)localObject5);
                  paramString2 = (String)localObject5;
                }
              }
              catch (Exception paramString2)
              {
                paramString2 = localException2;
                break label1128;
                paramString2 = paramString4;
                break label2016;
                paramString2 = paramString4;
                break label2134;
                break label1334;
                m = 0;
                k = -1;
                break label1311;
              }
              int j = 1;
              label1131:
              if (((paramInt == 1025) || (paramInt == 1024)) && (paramString4 != null) && (paramString4.length == 3))
              {
                if (paramBoolean1)
                {
                  paramQQAppInterface = paramContext.getString(2131700365);
                  if (!(paramContext instanceof Activity)) {
                    break label1248;
                  }
                }
                for (;;)
                {
                  aqha.a(paramContext, 230, null, paramQQAppInterface, null, paramContext.getString(2131721079), new ukh(), null).show();
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
                  return;
                  paramString4 = VideoMsgTools.a(paramQQAppInterface, paramInt, paramString1);
                  j = 0;
                  break label1131;
                  paramQQAppInterface = paramContext.getString(2131700366);
                  break label1170;
                  paramContext = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
                }
              }
              label1248:
              localStatus = paramQQAppInterface.getOnlineStatus();
              bool2 = q(paramQQAppInterface, paramString1);
              localObject5 = ((acff)paramQQAppInterface.getManager(51)).b(paramString1);
              int k;
              int m;
              if (localObject5 != null)
              {
                k = aqgv.a((Friends)localObject5, paramQQAppInterface);
                m = aqgv.aU(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
                i = ((acle)paramQQAppInterface.getBusinessHandler(13)).AX();
                if (i == 2)
                {
                  i = 0;
                  i1 = aqwu.a(paramQQAppInterface, paramString1, 3, true, null);
                  if ((i1 != 0) && ((paramInt == 0) || (paramInt == 1004) || (paramInt == 1000) || (paramInt == 1003)))
                  {
                    localObject5 = (aqpr)paramQQAppInterface.getManager(45);
                    if ((!new File(aqpr.p(i1, 3)).exists()) && (aqwu.aFN())) {
                      ((aqpr)localObject5).a(i1, 3, false, 0, "colorring");
                    }
                  }
                  i2 = jgj.a(paramQQAppInterface, paramString1, true, true);
                  if (i2 != 0)
                  {
                    i3 = aqwu.getResourceType();
                    localObject5 = aqwu.a(paramQQAppInterface, i2, i3, null);
                    if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!new File((String)localObject5).exists()) && (aqwu.aFN())) {
                      ((aqwu)paramQQAppInterface.getManager(84)).c(i2, i3, false, 0);
                    }
                  }
                }
                for (;;)
                {
                  try
                  {
                    for (;;)
                    {
                      localObject5 = (aqxf)paramQQAppInterface.getBusinessHandler(46);
                      Bundle localBundle = new Bundle();
                      localBundle.putLong("uin", Long.parseLong(paramString1));
                      localBundle.putString("phone", "");
                      ((aqxf)localObject5).J(2, localBundle);
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
                      ((Intent)localObject5).putExtra("isAudioMode", paramBoolean1);
                      ((Intent)localObject5).putExtra("istatus", localStatus.getValue());
                      ((Intent)localObject5).putExtra("remoteStatus", m);
                      ((Intent)localObject5).putExtra("extraUin", (String)localObject4);
                      ((Intent)localObject5).putExtra("extraCode", (String)localObject3);
                      ((Intent)localObject5).putExtra("isPeerNetworkWell", bool1);
                      ((Intent)localObject5).putExtra("isFriend", bool2);
                      ((Intent)localObject5).putExtra("senderStartTime", SystemClock.elapsedRealtime());
                      ((Intent)localObject5).putExtra("isSender", true);
                      ((Intent)localObject5).putExtra("colorRingId", i1);
                      ((Intent)localObject5).putExtra("vipType", i);
                      if (!paramBoolean1) {
                        break label2639;
                      }
                      i = 1;
                      ((Intent)localObject5).putExtra("sessionType", i);
                      ((Intent)localObject5).putExtra("hc_code", n);
                      ((Intent)localObject5).putExtra("main_timestamp", System.currentTimeMillis());
                      if (paramMap == null) {
                        break label2723;
                      }
                      paramString2 = (String)paramMap.get("dstClient");
                      localObject1 = (String)paramMap.get("bindId");
                      localObject2 = (String)paramMap.get("bindType");
                      localObject3 = (String)paramMap.get("extraType");
                      if (paramString2 == null) {
                        break label2716;
                      }
                      ((Intent)localObject5).putExtra("dstClient", paramString2);
                      ((Intent)localObject5).putExtra("bindId", (String)localObject1);
                      ((Intent)localObject5).putExtra("bindType", Integer.valueOf((String)localObject2).intValue());
                      ((Intent)localObject5).putExtra("extraType", Integer.valueOf((String)localObject3).intValue());
                      paramString2 = (String)paramMap.get("sig");
                      if (QLog.isColorLevel()) {
                        QLog.e("ChatActivityUtils", 2, "sig string=" + paramString2);
                      }
                      if (paramString2 == null) {
                        break label2716;
                      }
                      label2639:
                      try
                      {
                        paramString2 = aqhs.hexStr2Bytes(paramString2);
                        aqhs.printHexString("ChatActivityUtils", paramString2);
                        label2016:
                        paramString4 = (String)paramMap.get("actid");
                        ((Intent)localObject5).putExtra("actId", paramString4);
                        if (QLog.isColorLevel()) {
                          QLog.e("ChatActivityUtils", 2, "entervideo actid = " + paramString4);
                        }
                        paramString4 = (String)paramMap.get("mp_ext_params");
                        if (QLog.isColorLevel()) {
                          QLog.e("ChatActivityUtils", 2, "entervideo mp_ext_params = " + paramString4);
                        }
                        ((Intent)localObject5).putExtra("mp_ext_params", paramString4);
                        label2134:
                        ((Intent)localObject5).putExtra("sig", paramString2);
                        if (paramInt == 1011)
                        {
                          paramString2 = (String)paramMap.get("sex");
                          paramString4 = (String)paramMap.get("headUrl");
                          ((Intent)localObject5).putExtra("headUrl", paramString4 + paramString2 + ".jpg");
                        }
                        if (paramQQAppInterface.a().cz(paramString1))
                        {
                          if (paramQQAppInterface.a().aq(paramString1) != 1) {
                            break label2662;
                          }
                          ((Intent)localObject5).putExtra("isAudioMode", true);
                          if (!paramBoolean1) {
                            break label2675;
                          }
                          bool1 = false;
                          ((Intent)localObject5).putExtra("startfromVideoEntry", bool1);
                          ((Intent)localObject5).putExtra("sessionType", paramQQAppInterface.a().aq(paramString1));
                        }
                        ((Intent)localObject5).putExtra("from", paramString5);
                        ((Intent)localObject5).putExtra("Fromwhere", paramString5);
                        ((Intent)localObject5).putExtra("friendTerminal", k);
                        ((Intent)localObject5).putExtra("isOtherTerminalOnChating", paramQQAppInterface.a().cz(paramString1));
                        ((Intent)localObject5).putExtra("otherTerminalChatingRoomId", paramQQAppInterface.a().y(paramString1));
                        ((Intent)localObject5).putExtra("triggerBeauty", paramBoolean2);
                        ((Intent)localObject5).putExtra("isMakingAcall", true);
                        if ((paramString1 != null) || (paramString3 != null))
                        {
                          paramString2 = paramQQAppInterface.a();
                          paramString4 = paramQQAppInterface.getCurrentUin();
                          if (paramString1 == null) {
                            break label2681;
                          }
                          if (!paramBoolean1) {
                            break label2687;
                          }
                          i = 0;
                          paramString2.b(paramString4, paramString1, i, paramInt);
                        }
                        paramString1 = ((Intent)localObject5).getComponent().getClassName();
                        paramString2 = paramContext.getClass().getName();
                        if ((!paramString1.equals("com.tencent.av.ui.AVActivity")) || ((!paramString2.equals("com.tencent.mobileqq.qcall.QCallDetailActivity")) && (!paramString2.equals("com.tencent.mobileqq.activity.selectmember.SelectMemberActivity")) && (!paramString2.equals("com.tencent.mobileqq.activity.SplashActivity")) && (paramInt != 9500) && (paramInt != 1044))) {
                          break label2693;
                        }
                        paramString1 = new Intent(paramContext, AVLoadingDialogActivity.class);
                        paramString1.putExtra("avactivity_intent", (Parcelable)localObject5);
                        paramString1.addFlags(268435456);
                        paramContext.startActivity(paramString1);
                        if ((paramBoolean2) && ((paramContext instanceof Activity))) {
                          ((Activity)paramContext).overridePendingTransition(2130772194, 2130772195);
                        }
                        if ((!paramQQAppInterface.bF()) || (j != 0) || (paramInt == 9500) || (!(paramContext instanceof Activity))) {
                          break;
                        }
                        ((Activity)paramContext).overridePendingTransition(2130772207, 0);
                        return;
                      }
                      catch (Exception paramQQAppInterface) {}
                    }
                    if (i != 3) {
                      break label2730;
                    }
                    i = 2;
                  }
                  catch (Exception localException1)
                  {
                    QLog.e("ChatActivityUtils", 1, "VipSetFunCallHandler Error:" + localException1.getMessage());
                    continue;
                    i = 2;
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("ChatActivityUtils", 2, "Parse Sig String Exception");
                  return;
                  label2662:
                  localException1.putExtra("isAudioMode", false);
                  continue;
                  label2675:
                  bool1 = true;
                  continue;
                  label2681:
                  paramString1 = paramString3;
                  continue;
                  label2687:
                  i = 1;
                  continue;
                  paramContext.startActivity(localException1);
                }
              }
              localObject3 = paramString4;
              break label807;
            }
            label1170:
            label1311:
            label2723:
            label2730:
            label2742:
            localObject3 = null;
            label2693:
            label2716:
            paramString1 = null;
          }
          boolean bool1 = false;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Map<String, String> paramMap)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("startGroupVideo, uinType[").append(paramInt).append("], uin[").append(paramString).append("], chatSession[").append(paramQQAppInterface.a().a(paramString, false)).append("]");
      QLog.i("ChatActivityUtils", 4, localStringBuilder.toString());
    }
    aids.report("3236166");
    a(paramQQAppInterface, paramContext, paramInt, paramString, true, true, paramMap);
    paramContext = (String)paramMap.get("from");
    new IVPluginDataReporter().opDepartment("group_video").opName("startGroupVideo").opType(paramContext).report();
    try
    {
      long l = Long.valueOf(paramString).longValue();
      paramInt = Integer.valueOf((String)paramMap.get("MultiAVType")).intValue();
      paramString = paramQQAppInterface.a().a(l, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, String.format("startGroupVideo from=%s groupId=%s avType=%s roomInfo=%s", new Object[] { paramContext, Long.valueOf(l), Integer.valueOf(paramInt), paramString }));
      }
      if (paramString.ut())
      {
        if ("tipBar".equals(paramContext))
        {
          anot.a(paramQQAppInterface, "dc00898", "", "", "0X800ABD4", "0X800ABD4", 0, 0, "", "", "", "");
          return;
        }
        if ("itemBuilder".equals(paramContext))
        {
          anot.a(paramQQAppInterface, "dc00898", "", "", "0X800ABD5", "0X800ABD5", 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ChatActivityUtils", 1, "startGroupVideo education report fail.", paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, Map<String, String> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo uinType[" + paramInt + "], uin[" + paramString + "]");
    }
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo Activity isDestroyed!");
      }
    }
    do
    {
      do
      {
        return;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(paramContext, 2131696206, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
          return;
        }
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
        if ((paramQQAppInterface.a().sM()) && (!paramQQAppInterface.bF()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo phone is calling!");
          }
          paramQQAppInterface = paramContext.getString(2131697899);
          aqha.a(paramContext, 230, paramContext.getString(2131697879), paramQQAppInterface, 2131721058, 2131721079, new ukr(), null).show();
          jjk.awV();
          return;
        }
        if (!imm.isNormalSharp())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo old engine!");
          }
          if (paramInt == 1011)
          {
            paramString = paramContext.getString(2131698112);
            aqha.a(paramContext, 230, paramContext.getString(2131697879), paramString, 2131721058, 2131697810, new uks(), null).show();
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
            return;
          }
        }
        if ((DiscussionInfo.isValidDisUin(paramString)) || (paramInt != 3000)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChatActivityUtils", 2, "invalid discussId: " + paramString);
      return;
    } while (paramQQAppInterface.a().y(paramContext, paramString));
    long l1 = alkt.getLong(paramString);
    int m = jll.cL(paramInt);
    int k = 0;
    int j = 0;
    int i = k;
    Object localObject1;
    if (paramMap != null)
    {
      i = k;
      if (m == 1)
      {
        localObject1 = (String)paramMap.get("MultiAVType");
        i = j;
        if (localObject1 != null) {
          i = Integer.valueOf((String)localObject1).intValue();
        }
        localObject1 = (String)paramMap.get("isVideo");
        if ((localObject1 != null) && (((String)localObject1).equals("true"))) {
          paramQQAppInterface.a().v(-1034L, true);
        }
      }
    }
    for (;;)
    {
      if (m == 2) {
        i = 1;
      }
      if ((!paramQQAppInterface.a().i(m, l1)) || (m != 1) || (!paramQQAppInterface.a().uq()) || (paramInt != 1)) {
        break label695;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "check mutex of qq call and group call!");
      }
      long l2 = paramQQAppInterface.a().bG();
      j = paramQQAppInterface.a().z(l2);
      if ((j == i) || (j != 10) || (i != 2)) {
        break label695;
      }
      if (!paramQQAppInterface.a().uk()) {
        break;
      }
      QQToast.a(paramContext, 2131697709, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return;
      paramQQAppInterface.a().v(-1034L, false);
    }
    QQToast.a(paramContext, 2131697711, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
    return;
    label695:
    Object localObject2;
    Object localObject3;
    if (!paramQQAppInterface.a().b(m, l1, i)) {
      if ((paramBoolean1) && (!aqiw.isWifiConnected(BaseApplication.getContext())) && (!aqiw.bX(BaseApplication.getContext())))
      {
        if (VideoController.ag(VideoController.Mp + paramQQAppInterface.getCurrentAccountUin()) > 0)
        {
          a(paramQQAppInterface, paramContext, paramInt, paramString, false, paramBoolean2, paramMap);
          return;
        }
        localObject1 = null;
        localObject2 = null;
        if (aqiw.isMobileNetWork(BaseApplication.getContext()))
        {
          localObject1 = paramContext.getString(2131697879);
          localObject2 = paramContext.getString(2131697874);
        }
        if (!aqiw.is3Gor4G(BaseApplication.getContext())) {
          break label1522;
        }
        localObject1 = paramContext.getString(2131697879);
        if ((paramMap != null) && (TextUtils.equals((CharSequence)paramMap.get("isVideo"), "true")))
        {
          localObject3 = paramContext.getString(2131697875);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ChatActivityUtils", 2, "enterNewGroupVideo title or content is empty");
        return;
        localObject3 = paramContext.getString(2131697876);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
      }
      a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131697614, 2131697626, new uku(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramMap), new ukv());
      return;
      if ((paramBoolean2) && (paramQQAppInterface.bF()))
      {
        j = paramQQAppInterface.a().lh();
        k = paramQQAppInterface.a().li();
        if (((k != 1) && (k != 2)) || (((j >= 1) && (j <= 5)) || (paramQQAppInterface.a().getSessionType() == 1) || (paramQQAppInterface.a().getSessionType() == 2)))
        {
          QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          aqjl.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
          return;
        }
        if (((k != 3) && (k != 4)) || (((j >= 1) && (j <= 5)) || (paramQQAppInterface.a().getSessionType() == 3) || (paramQQAppInterface.a().getSessionType() == 4)))
        {
          if ((paramQQAppInterface.a().bG() == l1) && (m != 1))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("ChatActivityUtils", 2, "enterNewGroupVideo-->chatUin==discussid???Why");
            return;
          }
          if (paramQQAppInterface.a().bG() > 0L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatActivityUtils", 2, "enterNewGroupVideo is multi calling!");
            }
            localObject1 = paramContext.getString(2131697710);
            j = jlk.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString + "");
            PopupDialog.b(paramContext, 230, null, (String)localObject1, 2131697614, 2131697626, new ukw(paramQQAppInterface, paramContext, m, i, paramInt, paramString, paramBoolean1, paramMap), new ukx(paramQQAppInterface, paramString));
            anot.a(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", j + "", "", "");
            return;
          }
        }
      }
      localObject1 = null;
      localObject3 = "0";
      localObject2 = localObject3;
      if (paramMap != null)
      {
        localObject1 = (String)paramMap.get("from");
        if (!TextUtils.equals((CharSequence)localObject1, "Panel")) {
          break label1460;
        }
        if (!TextUtils.equals((String)paramMap.get("publicClass"), "false")) {
          break label1452;
        }
        paramMap = "1";
        localObject1 = "openMiddlePage";
        localObject2 = paramMap;
      }
      for (;;)
      {
        ((aicu)paramQQAppInterface.getManager(236)).e(paramContext, paramQQAppInterface.getCurrentAccountUin(), paramString, (String)localObject2, (String)localObject1);
        paramQQAppInterface.a().k(8, l1, i);
        return;
        label1452:
        paramMap = "3690";
        break;
        label1460:
        if (TextUtils.equals((CharSequence)localObject1, "tipBar"))
        {
          localObject1 = "openRoom";
          localObject2 = "2";
        }
        else if (!paramQQAppInterface.a().at(Long.parseLong(paramString)))
        {
          localObject1 = "openMiddlePage";
          localObject2 = localObject3;
        }
        else
        {
          localObject1 = "openRoom";
          localObject2 = localObject3;
        }
      }
      label1522:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    int m = 5;
    int k = 1;
    atdc localatdc = (atdc)paramQQAppInterface.getManager(746);
    paramQQAppInterface = localatdc.a(paramQQAppInterface.getCurrentAccountUin());
    int i;
    int j;
    if ((paramQQAppInterface != null) && (localatdc.Og() == 1)) {
      if (paramQQAppInterface.pstn_multi_call_time > 0)
      {
        i = 3;
        j = k;
      }
    }
    for (;;)
    {
      paramIntent.putExtra("graySwitch", j);
      paramIntent.putExtra("ltMultiMembership", i);
      paramIntent.putExtra("multiPstnAutoTranTime", localatdc.a().epi);
      paramIntent.putExtra("multiPstnMissDelayTime", localatdc.a().epj);
      paramIntent.putExtra("multiPstnMissShowTime", localatdc.a().epk);
      return;
      i = m;
      j = k;
      if (localatdc.Oi() == 1)
      {
        i = m;
        j = k;
        if (paramQQAppInterface.pstn_multi_try_status == 0)
        {
          i = 4;
          j = k;
          continue;
          j = 0;
          i = m;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Activity paramActivity)
  {
    a(paramQQAppInterface, paramView, paramActivity, -2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, View paramView, Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick().");
    }
    if ((paramActivity != null) && (paramActivity.getCurrentFocus() != null)) {}
    Context localContext;
    ChatMessage localChatMessage;
    do
    {
      ((InputMethodManager)paramActivity.getSystemService("input_method")).hideSoftInputFromWindow(paramActivity.getCurrentFocus().getWindowToken(), 0);
      for (;;)
      {
        localContext = paramView.getContext();
        if (localContext != null) {
          break;
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "chatActivity current focus is null");
        }
      }
      localChatMessage = wja.a(paramView);
    } while ((localChatMessage == null) || (ApolloUtil.V(localChatMessage)));
    Object localObject1 = null;
    boolean bool2 = true;
    boolean bool1;
    if ((localChatMessage instanceof MessageForLongMsg))
    {
      if (!localChatMessage.isShowQIMStyleGroup)
      {
        bool1 = true;
        label124:
        if (localChatMessage.isShowTIMStyleGroup) {
          break label173;
        }
      }
      label173:
      for (bool2 = true;; bool2 = false)
      {
        localObject1 = ((MessageForLongMsg)localChatMessage).msg;
        if (localObject1 != null) {
          break label613;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ChatItemBuilder", 2, "bubble onDoubleClick() CharSequence null.");
        return;
        bool1 = false;
        break label124;
      }
    }
    if ((localChatMessage instanceof MessageForText)) {
      if (!localChatMessage.isShowQIMStyleGroup)
      {
        bool1 = true;
        label198:
        if (localChatMessage.isShowTIMStyleGroup) {
          break label278;
        }
        bool2 = true;
        label209:
        localObject1 = (MessageForText)localChatMessage;
        if (!(((MessageForText)localObject1).sb instanceof aofk)) {
          break label284;
        }
        localObject1 = ((aofk)((MessageForText)localObject1).sb).mSource;
      }
    }
    for (;;)
    {
      label240:
      if (localChatMessage.msgtype == -2008) {
        if (!localChatMessage.isSend()) {
          break label310;
        }
      }
      label278:
      label284:
      label310:
      for (localObject1 = localContext.getString(2131719356);; localObject1 = localContext.getString(2131719355))
      {
        break;
        bool1 = false;
        break label198;
        bool2 = false;
        break label209;
        if (!(((MessageForText)localObject1).sb instanceof Spannable)) {
          break label1163;
        }
        localObject1 = ((MessageForText)localObject1).sb.toString();
        break label240;
      }
      if ((localChatMessage instanceof MessageForQQStoryComment))
      {
        localObject1 = (MessageForQQStoryComment)localChatMessage;
        localObject1 = "“" + ((MessageForQQStoryComment)localObject1).title + "”\n" + ((MessageForQQStoryComment)localObject1).comment;
        bool1 = true;
        break;
      }
      if (((localChatMessage instanceof MessageForReplyText)) || ((localChatMessage instanceof MessageForLongMsg)))
      {
        localObject1 = a(paramQQAppInterface, localChatMessage, localContext, paramView, true);
        bool1 = true;
        break;
      }
      Object localObject2;
      MessageForReplyText localMessageForReplyText;
      if ((localChatMessage instanceof MessageForMixedMsg))
      {
        localObject2 = (MessageForMixedMsg)localChatMessage;
        localMessageForReplyText = ((MessageForMixedMsg)localObject2).getReplyMessage(paramQQAppInterface);
        localObject1 = "";
        if ((paramView.getId() == 2131371989) && ((paramView instanceof ETTextView)))
        {
          if (localMessageForReplyText != null) {
            localObject1 = a(paramQQAppInterface, localMessageForReplyText, localContext, paramView, false);
          }
          label480:
          bool1 = true;
          break;
        }
        if (paramView.getId() == 2131364531) {
          if (((ETTextView)paramView.findViewById(2131371989) == null) || (localMessageForReplyText == null)) {
            break label1155;
          }
        }
      }
      label1155:
      for (localObject1 = a(paramQQAppInterface, localMessageForReplyText, localContext, paramView, false);; localObject1 = "")
      {
        break label480;
        if (localMessageForReplyText != null) {
          localObject1 = a(paramQQAppInterface, localMessageForReplyText, localContext, paramView, false);
        }
        localObject1 = (String)localObject1 + ((MessageForMixedMsg)localObject2).msg;
        break label480;
        if ((localChatMessage instanceof MessageForHiBoom))
        {
          localObject2 = (MessageForHiBoom)localChatMessage;
          if (((MessageForHiBoom)localObject2).mHiBoomMessage != null)
          {
            localObject1 = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
            bool1 = true;
            break;
            label613:
            localObject2 = new Intent(localContext, TextPreviewActivity.class);
            ((Intent)localObject2).putExtra("peeruin", localChatMessage.frienduin);
            ((Intent)localObject2).putExtra("uin_type", localChatMessage.istroop);
            ((Intent)localObject2).putExtra("content", (String)localObject1);
            ((Intent)localObject2).putExtra("uniseq", localChatMessage.uniseq);
            ((Intent)localObject2).putExtra("bubbleId", localChatMessage.vipBubbleID);
            ((Intent)localObject2).putExtra("bubbleDiyId", localChatMessage.vipBubbleDiyTextId);
            ((Intent)localObject2).putExtra("fontId", localChatMessage.getExtInfoFromExtStr("vip_font_id"));
            ((Intent)localObject2).putExtra("troop_at_info", localChatMessage.getExtInfoFromExtStr(anbb.ccR));
            ((Intent)localObject2).putExtra("origin_merge_structing_msg_uniseq", a(localChatMessage, paramActivity));
            ((Intent)localObject2).putExtra("senderUin", localChatMessage.senderuin);
            ((Intent)localObject2).putExtra("sessionType", paramInt);
            ((Intent)localObject2).putExtra("isMultiMsg", localChatMessage.isMultiMsg);
            int i = 0;
            paramActivity = localChatMessage.getExtInfoFromExtStr("vip_font_effect_id");
            paramInt = i;
            if (!TextUtils.isEmpty(paramActivity))
            {
              paramInt = i;
              if (TextUtils.isDigitsOnly(paramActivity)) {
                paramInt = Integer.valueOf(paramActivity).intValue();
              }
            }
            i = paramInt;
            if (paramInt == 0)
            {
              i = paramInt;
              if (ku.a(localChatMessage)) {
                i = 1;
              }
            }
            paramInt = i;
            if (i != 0)
            {
              paramInt = i;
              if (1 == localChatMessage.istroop)
              {
                paramInt = i;
                if (jof.a(localChatMessage)) {
                  paramInt = 0;
                }
              }
            }
            ((Intent)localObject2).putExtra("fontEffectId", paramInt);
            ((Intent)localObject2).putExtra(xva.aWx, bool1);
            ((Intent)localObject2).putExtra(yhv.aWx, bool2);
            if ((localChatMessage instanceof MessageForHiBoom))
            {
              paramActivity = (MessageForHiBoom)localChatMessage;
              if ((paramActivity.mHiBoomMessage != null) && ((paramView instanceof HiBoomTextView)))
              {
                ((Intent)localObject2).putExtra("HiBoomId", paramActivity.mHiBoomMessage.id);
                VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface.getCurrentUin(), "HighFont", "AioDoubleClick", "", 1, 0, 0, "", "" + paramActivity.mHiBoomMessage.id, "");
              }
            }
            if (localChatMessage.isSend()) {
              paramQQAppInterface = localChatMessage.selfuin;
            }
            for (;;)
            {
              ((Intent)localObject2).putExtra("real_msg_sender_uin", paramQQAppInterface);
              ((Activity)localContext).startActivityForResult((Intent)localObject2, 14001);
              ((Activity)localContext).overridePendingTransition(2130772021, 0);
              VasWebviewUtil.reportCommercialDrainage(paramQQAppInterface, "long_msg", "long_msg_double", "", 1, 0, 0, "", String.valueOf(acle.Q(localChatMessage.vipBubbleID)), "");
              return;
              if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004)) {
                paramQQAppInterface = localChatMessage.frienduin;
              } else {
                paramQQAppInterface = localChatMessage.senderuin;
              }
            }
          }
        }
        bool1 = true;
        break;
      }
      label1163:
      localObject1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Integer paramInteger)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils.troop.notification_center.show_red_dot", 2, "setTroopTipStatus, troopUin:" + paramString + ",status:" + paramInteger);
        }
      } while ((paramInteger.intValue() != -1) && (paramInteger.intValue() != 0));
      if (cT == null) {
        cT = new ConcurrentHashMap();
      }
      cT.put(paramString + paramQQAppInterface.getCurrentAccountUin(), paramInteger);
    } while (paramInteger.intValue() != -1);
    paramInteger = (TroopManager)paramQQAppInterface.getManager(52);
    int i;
    if (paramInteger != null)
    {
      paramInteger = paramInteger.b(paramString);
      if (paramInteger != null)
      {
        String str = paramQQAppInterface.getCurrentAccountUin();
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
        anot.a(paramQQAppInterface, "P_CliOper", "Grp_set", "", "AIOchat", "Exp_dataEntry_new", 0, 0, paramString, paramInteger, "", "");
        return;
        i = 0;
        break;
      }
      i = 0;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String str = (String)paramMap.get("business_type");
      if ((str == null) || (!str.equals("1"))) {
        break label110;
      }
    }
    label110:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        l = Long.parseLong((String)paramMap.get("group_id"));
        paramMap = new Intent();
        paramMap.setAction("android.intent.action.gameparty.refresh");
        paramMap.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
        paramMap.putExtra("teamId", l);
        paramQQAppInterface.getApp().sendBroadcast(paramMap);
        return;
      }
      catch (NumberFormatException paramMap)
      {
        for (;;)
        {
          long l = -1L;
        }
      }
    }
  }
  
  static boolean a(long paramLong1, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean, String paramString, int paramInt1, long paramLong2, int paramInt2)
  {
    if ((paramBoolean) && (paramQQAppInterface.bF()))
    {
      i = paramQQAppInterface.a().lh();
      int j = paramQQAppInterface.a().li();
      int k = paramQQAppInterface.a().getSessionType();
      if (((j != 1) && (j != 2)) || (((i >= 1) && (i <= 5)) || (k == 1) || (k == 2)))
      {
        QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        aqjl.a(paramQQAppInterface, Long.valueOf(paramString).longValue(), null);
        return true;
      }
      if (((j != 3) && (j != 4)) || (((i >= 1) && (i <= 5)) || (k == 3) || (k == 4)))
      {
        long l1 = paramQQAppInterface.a().bG();
        if ((l1 == paramLong2) && (paramInt1 != 1) && (paramInt1 != 2))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatActivityUtils", 2, "startGroupAudio-->chatUin==discussid???Why");
          }
          return true;
        }
        long l2 = paramQQAppInterface.a().bG();
        if (l2 > 0L)
        {
          QLog.w("ChatActivityUtils", 1, "checkMutex, chatingRelationId[" + l2 + "], chatUin[" + l1 + "], discussId[" + paramLong2 + "], seq[" + paramLong1 + "]");
          if ((l1 != paramLong2) || ((paramInt1 != 2) && (paramInt1 != 1))) {
            break label296;
          }
        }
      }
    }
    return false;
    label296:
    String str = paramContext.getString(2131697710);
    int i = jlk.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString + "");
    PopupDialog.b(paramContext, 230, null, str, 2131697614, 2131697626, new ukm(paramLong1, paramQQAppInterface, paramContext, paramInt1, paramInt2, paramOnClickListener, paramString, i), new ukn(paramc, paramString, i, paramQQAppInterface));
    anot.a(null, "dc00899", "Grp_video", "", "video_jump", "exp_jump", 0, 0, paramString + "", i + "", "", "");
    return true;
  }
  
  private static boolean a(long paramLong, QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc, d paramd)
  {
    if (AudioHelper.jY(13) == 1)
    {
      QLog.d("ChatActivityUtils", 1, "音视频进程在等待调试器连接(界面会无响应)");
      AudioHelper.UB(acfp.m(2131703597));
    }
    Object localObject1;
    int i;
    int j;
    label633:
    Object localObject2;
    if (!paramQQAppInterface.bF())
    {
      if ((paramContext instanceof com.tencent.mobileqq.app.BaseActivity)) {
        localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramContext;
      }
      for (;;)
      {
        bool = paramd.aTF;
        if (a((Activity)localObject1, bool, new ujx(paramLong, paramQQAppInterface, paramContext, paramc, paramd, (com.tencent.mobileqq.app.BaseActivity)localObject1, bool))) {
          break;
        }
        return false;
        localObject1 = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, Context[" + paramContext + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005757", "0X8005757", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800575B", "0X800575B", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800575F", "0X800575F", 0, 0, "", "", "", "");
      if (paramQQAppInterface.a().sM())
      {
        jjk.S(true, true);
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, isPhoneCalling, seq[" + paramLong + "]");
        localObject1 = paramContext.getString(2131697899);
        PopupDialog.b(paramContext, 230, paramContext.getString(2131697879), (String)localObject1, 2131721058, 2131721079, new uki(paramc, paramd), null);
        jjk.kW(paramd.aTF);
        if (paramd.uinType == 1024) {
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_phone_calling_false", 0, 0, "", "", "", "");
        }
        return false;
      }
      if (((paramd.uinType == 1006) && (!q(paramQQAppInterface, paramd.peerUin))) || (paramd.uinType == 1024) || (paramd.uinType == 1011))
      {
        new imm();
        imm.getCpuInfo();
        i = imm.getCpuArchitecture();
        long l = imm.getMaxCpuFreq();
        j = Build.VERSION.SDK_INT;
        if ((i < 3) || (l / 1000L < 800L) || (j < 9))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatActivityUtils", 2, "startVideo old engine!");
          }
          if (paramd.hh != null)
          {
            localObject1 = (String)paramd.hh.get("chat_type");
            if (paramd.uinType != 1011) {
              break label669;
            }
            paramd = paramContext.getString(2131698112);
            PopupDialog.b(paramContext, 230, paramContext.getString(2131697879), paramd, 2131721058, 2131697810, new ukt(paramc), null);
            if (!((String)localObject1).equals("randomc2c")) {
              break label633;
            }
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X80053B1", "0X80053B1", 0, 0, "", "", "", "");
          }
          for (;;)
          {
            return false;
            localObject1 = "";
            break;
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
          }
          label669:
          QQToast.a(paramContext, 2131697625, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          if (paramd.aTF)
          {
            anot.a(null, "CliOper", "", "", "Two_call", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            if (paramd.uinType == 1024) {
              anot.a(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_tmp_address_false", 0, 0, "", "", "", "");
            }
          }
          return true;
        }
      }
      if ((paramd.aTF) && (!imh.isDAudioEnable(paramContext)))
      {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isDAudioEnable, seq[" + paramLong + "]");
        localObject1 = paramContext.getString(2131697559);
        PopupDialog.b(paramContext, 230, paramContext.getString(2131697879), (String)localObject1, 2131721058, 2131697810, new ule(paramc), null);
        if (paramd.aTF)
        {
          anot.a(null, "CliOper", "", "", "Two_call", "Judge_language_false", 0, 0, "", "", "", "");
          if (paramd.uinType == 1024) {
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_language_false", 0, 0, "", "", "", "");
          }
        }
        return false;
      }
      if ((paramd.uinType == 1010) && (!paramQQAppInterface.a().arw()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatActivityUtils", 2, "startVideo don't allow date session!");
        }
        paramQQAppInterface = PopupDialog.b(paramContext, 230, null, paramContext.getString(2131698077), 2131697614, 2131697627, new ulp(paramQQAppInterface, paramd, paramLong, paramContext, paramc), new uma(paramd, paramc));
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setOnCancelListener(new umh(paramd, paramc));
        }
        return false;
      }
      if ((paramd.uinType == 1044) && (((afwh)paramQQAppInterface.getManager(292)).bl((Context)localObject1))) {
        return false;
      }
      if ((paramd.aTG) && (a(paramQQAppInterface, paramd.uinType, paramd.peerUin, paramd.phoneNum)) && (paramd.uinType != 1024))
      {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, isMsgShielded, seq[" + paramLong + "]");
        if (paramd.aTF) {
          anot.a(null, "CliOper", "", "", "Two_call", "Shield_btn_appear", 0, 0, "", "", "", "");
        }
        localObject1 = paramContext.getString(2131698078);
        paramQQAppInterface = PopupDialog.b(paramContext, 230, paramContext.getString(2131697879), (String)localObject1, 2131697614, 2131697627, new umi(paramQQAppInterface, paramd, paramLong, paramContext, paramc), new umj(paramd, paramc));
        if (paramQQAppInterface != null) {
          paramQQAppInterface.setOnCancelListener(new ujy(paramd, paramc));
        }
        return false;
      }
      if (!aqiw.isNetSupport(paramContext))
      {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isNetSupport, seq[" + paramLong + "]");
        QQToast.a(paramContext, 2131696206, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        if (paramd.aTF)
        {
          anot.a(null, "CliOper", "", "", "Two_call", "Judge_network_false", 0, 0, "1", "", "", "");
          if (paramd.uinType == 1024) {
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X80049DF", "Judge_network_false", 0, 0, "", "", "", "");
          }
        }
        return true;
      }
      boolean bool = aqiw.isWifiConnected(paramContext);
      if ((paramd.uinType == 1024) && (!bool) && (aqiw.getSystemNetwork(paramContext) == 2))
      {
        anot.a(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        QQToast.a(paramContext, 2131697631, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        anot.a(null, "CliOper", "", "", "Two_call", "Clk_2G_tips_btn", 0, 0, "3", "", "", "");
        return false;
      }
      if ((!paramd.aTH) || (bool) || (aqiw.bX(paramContext))) {
        break label3299;
      }
      QLog.w("ChatActivityUtils", 1, "startVideoCheck, !isWifiConnected, seq[" + paramLong + "]");
      localObject1 = VideoController.Mp + paramQQAppInterface.getCurrentAccountUin();
      if (paramd.hh == null) {
        break label3539;
      }
      localObject2 = (String)paramd.hh.get("chat_type");
      if ((localObject2 == null) || ((!((String)localObject2).equals("randomc2c")) && (!((String)localObject2).equals("randomgroup")))) {
        break label3539;
      }
      localObject1 = VideoController.Mq + paramQQAppInterface.getCurrentAccountUin();
    }
    label3524:
    label3539:
    for (;;)
    {
      if (VideoController.ag((String)localObject1) > 0)
      {
        paramd.aTG = false;
        paramd.aTH = false;
        paramd.aTJ = false;
        a(paramLong, paramQQAppInterface, paramContext, paramc, paramd);
        return true;
      }
      localObject1 = null;
      i = aqiw.getSystemNetwork(paramContext);
      Object localObject3;
      if (i == 2)
      {
        localObject1 = paramContext.getString(2131697879);
        localObject2 = paramContext.getString(2131697874);
        if (!paramd.aTF) {
          break label3524;
        }
        anot.a(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "1", "", "", "");
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        QLog.w("ChatActivityUtils", 1, "startVideoCheck, netType[" + i + "], seq[" + paramLong + "]");
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          return true;
          if ((i == 3) || (i == 4))
          {
            localObject1 = paramContext.getString(2131697879);
            if (paramd.aTF)
            {
              localObject2 = paramContext.getString(2131697876);
              anot.a(null, "CliOper", "", "", "Two_call", "Out_of_wifi_tips", 0, 0, "2", "", "", "");
              localObject3 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject3;
              continue;
            }
            localObject3 = paramContext.getString(2131697875);
            localObject2 = localObject1;
            localObject1 = localObject3;
          }
        }
        else
        {
          paramQQAppInterface = a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131697614, 2131697626, new ujz(paramd, i, paramLong, paramQQAppInterface, paramContext, paramc), new uka(paramd, i, paramc));
          if (paramQQAppInterface != null) {
            paramQQAppInterface.setOnCancelListener(new ukb(paramd, i, paramc));
          }
          return false;
          i = paramQQAppInterface.a().getSessionType();
          j = paramQQAppInterface.a().lh();
          int k = paramQQAppInterface.a().li();
          localObject1 = null;
          localObject3 = null;
          localObject2 = localObject3;
          if (paramd.hh != null)
          {
            String str = (String)paramd.hh.get("chat_type");
            localObject1 = str;
            localObject2 = localObject3;
            if (str != null) {
              if (!str.equals("randomgroup"))
              {
                localObject1 = str;
                localObject2 = localObject3;
                if (!str.equals("randomc2c")) {}
              }
              else
              {
                localObject2 = (String)paramd.hh.get("session_name");
                localObject1 = str;
              }
            }
          }
          if (((k == 1) || (k == 2)) && (j >= 1) && (j <= 5))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChatActivityUtils", 2, "startVideo is in Double Random Call!");
            }
            if ((localObject2 == null) || (!((String)localObject1).equals("randomc2c")) || (!((String)localObject2).equals(paramQQAppInterface.a().gX())))
            {
              QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
              a(paramQQAppInterface, paramd.hh);
              return true;
            }
          }
          else
          {
            if ((paramd.aTI) && ((k == 3) || (k == 4)) && (j >= 1) && (j <= 5))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatActivityUtils", 2, "startVideo is Multi Random calling!");
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.equals((CharSequence)localObject2, paramQQAppInterface.a().gX()))) {
                i = 1;
              }
            }
            while (i == 0)
            {
              PopupDialog.b(paramContext, 230, null, paramContext.getString(2131697710), 2131697614, 2131697626, new ukc(paramd, paramLong, paramQQAppInterface, paramContext, paramc), new ukd(paramc));
              a(paramQQAppInterface, paramd.hh);
              return false;
              i = 0;
              continue;
              if (i == 1)
              {
                QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_AUDIO, seq[" + paramLong + "]");
                if ((paramd.aTF) && (((paramd.peerUin != null) && (paramd.peerUin.equals(paramQQAppInterface.a().ay()))) || ((paramd.phoneNum != null) && (paramd.phoneNum.equals(paramQQAppInterface.a().ay()))) || ((paramd.uinType == 1006) && (((paramd.peerUin != null) && (paramd.peerUin.equals(paramQQAppInterface.a().gZ()))) || ((paramd.phoneNum != null) && (paramd.phoneNum.equals(paramQQAppInterface.a().gZ())))))))
                {
                  if (paramc != null) {
                    paramc.aqM();
                  }
                  if (paramQQAppInterface.a().cx(paramQQAppInterface.a().ay()))
                  {
                    paramd = new Intent(paramContext, AVActivity.class);
                    paramd.addFlags(262144);
                    paramd.addFlags(268435456);
                    paramd.putExtra("sessionType", 3);
                    paramd.putExtra("GroupId", paramQQAppInterface.a().ay());
                    paramd.putExtra("isDoubleVideoMeeting", true);
                    paramContext.startActivity(paramd);
                    if (paramc != null) {
                      paramc.aqN();
                    }
                  }
                }
                for (;;)
                {
                  return true;
                  a(paramQQAppInterface, paramContext, paramd.uinType, paramd.peerUin, paramd.name, paramd.phoneNum, paramd.aTF, paramd.MP, paramd.from, paramd.hh, false);
                  break;
                  QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
                  a(paramQQAppInterface, paramd.hh);
                }
              }
              if (i == 2)
              {
                QLog.w("ChatActivityUtils", 1, "startVideoCheck, TYPE_SESSION_VIDEO, seq[" + paramLong + "]");
                if ((!paramd.aTF) && (((paramd.peerUin != null) && (paramd.peerUin.equals(paramQQAppInterface.a().ay()))) || ((paramd.phoneNum != null) && (paramd.phoneNum.equals(paramQQAppInterface.a().ay()))) || ((paramd.uinType == 1006) && (((paramd.peerUin != null) && (paramd.peerUin.equals(paramQQAppInterface.a().gZ()))) || ((paramd.phoneNum != null) && (paramd.phoneNum.equals(paramQQAppInterface.a().gZ())))))))
                {
                  if (paramc != null) {
                    paramc.aqM();
                  }
                  if (paramQQAppInterface.a().cx(paramQQAppInterface.a().ay()))
                  {
                    paramd = new Intent(paramContext, AVActivity.class);
                    paramd.addFlags(262144);
                    paramd.addFlags(268435456);
                    paramd.putExtra("sessionType", 3);
                    paramd.putExtra("GroupId", paramQQAppInterface.a().ay());
                    paramd.putExtra("isDoubleVideoMeeting", true);
                    paramContext.startActivity(paramd);
                    if (paramc != null) {
                      paramc.aqN();
                    }
                  }
                }
                for (;;)
                {
                  return true;
                  a(paramQQAppInterface, paramContext, paramd.uinType, paramd.peerUin, paramd.name, paramd.phoneNum, paramd.aTF, paramd.MP, paramd.from, paramd.hh, false);
                  break;
                  QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
                  a(paramQQAppInterface, paramd.hh);
                }
              }
              if ((paramd.aTI) && ((i == 3) || (i == 4)) && (paramQQAppInterface.a().bG() > 0L))
              {
                QLog.w("ChatActivityUtils", 1, "startVideoCheck, 存在多人通话, RelationId[" + paramQQAppInterface.a().bG() + "], sessionType[" + i + "], seq[" + paramLong + "]");
                PopupDialog.b(paramContext, 230, null, paramContext.getString(2131697710), 2131697614, 2131697626, new uke(paramd, paramLong, paramQQAppInterface, paramContext, paramc), new ukf(paramc));
                a(paramQQAppInterface, paramd.hh);
                return false;
              }
            }
          }
          label3299:
          localObject1 = (acff)paramQQAppInterface.getManager(51);
          if ((paramd.uinType == 0) && (!((acff)localObject1).isFriend(paramd.peerUin)))
          {
            if (AudioHelper.jY(16) == 1) {
              AudioHelper.UA(acfp.m(2131703572));
            }
          }
          else
          {
            anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005766", "0X8005766", 0, 0, "", "", "", "");
            if (paramc != null) {
              paramc.aqM();
            }
            a(paramQQAppInterface, paramContext, paramd.uinType, paramd.peerUin, paramd.name, paramd.phoneNum, paramd.aTF, paramd.MP, paramd.from, paramd.hh, paramd.aTJ);
            if (paramc != null) {
              paramc.aqN();
            }
            return true;
          }
          if (paramd.aTF) {}
          for (i = 2131697607;; i = 2131697608)
          {
            paramQQAppInterface = paramContext.getString(i);
            PopupDialog.b(paramContext, 230, paramContext.getString(2131697879), paramQQAppInterface, 2131721058, 2131697758, new ukg(), null);
            return false;
          }
        }
        localObject2 = null;
        continue;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  private static boolean a(ajdo paramajdo, String paramString, List<InviteBaseData> paramList)
  {
    if ((paramList == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    paramajdo = paramajdo.b(paramString);
    if ((paramajdo != null) && (!TextUtils.isEmpty(paramajdo.uin)) && (!paramajdo.uin.equals("0")))
    {
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (InviteBaseData)paramString.next();
        if ((paramList.uin != null) && (paramList.uin.equals(paramajdo.uin))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    int i = 0;
    com.tencent.mobileqq.app.BaseActivity localBaseActivity;
    mqq.app.BaseActivity localBaseActivity1;
    boolean bool3;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localBaseActivity = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      i = 1;
      bool1 = localBaseActivity.isFinishing();
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label67;
      }
      localBaseActivity1 = (mqq.app.BaseActivity)paramActivity;
      bool3 = localBaseActivity1.isFinishing();
      i = 2;
    }
    for (;;)
    {
      if ((localBaseActivity != null) || (localBaseActivity1 != null)) {
        break label77;
      }
      return true;
      bool1 = true;
      localBaseActivity = null;
      break;
      label67:
      localBaseActivity1 = null;
      bool3 = bool1;
    }
    label77:
    boolean bool2 = true;
    boolean bool1 = true;
    if (localBaseActivity != null) {
      if (localBaseActivity.checkSelfPermission("android.permission.CAMERA") == 0)
      {
        bool2 = true;
        if (localBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
          break label254;
        }
        bool1 = true;
      }
    }
    boolean bool4;
    for (;;)
    {
      bool4 = VideoController.isScreenLocked(paramActivity);
      if ((QLog.isDevelopLevel()) || (!bool2) || (!bool1) || (bool4)) {
        QLog.w("ChatActivityUtils", 1, "checkQAVPermission, Camera[" + bool2 + "], audio[" + bool1 + "], onlyAudio[" + paramBoolean + "], activityType[" + i + "], isScreenLocked[" + bool4 + "], isFinishing[" + bool3 + "]");
      }
      if (paramBoolean) {
        bool2 = true;
      }
      if ((!bool2) || (!bool1)) {
        break label308;
      }
      return true;
      bool2 = false;
      break;
      label254:
      bool1 = false;
      continue;
      if (localBaseActivity1 != null)
      {
        if (localBaseActivity1.checkSelfPermission("android.permission.CAMERA") == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          if (localBaseActivity1.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label302;
          }
          bool1 = true;
          break;
        }
        label302:
        bool1 = false;
      }
    }
    label308:
    if (bool4)
    {
      paramOnClickListener.onClick(null, -1);
      return false;
    }
    paramActivity = new uli(paramOnClickListener);
    if ((!bool2) && (!bool1)) {
      if (localBaseActivity != null) {
        localBaseActivity.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
      }
    }
    for (;;)
    {
      return false;
      if (localBaseActivity1 != null)
      {
        localBaseActivity1.requestPermissions(paramActivity, 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO" });
        continue;
        if (!bool2)
        {
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 2, new String[] { "android.permission.CAMERA" });
          }
        }
        else if (!bool1) {
          if (localBaseActivity != null) {
            localBaseActivity.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
          } else if (localBaseActivity1 != null) {
            localBaseActivity1.requestPermissions(paramActivity, 3, new String[] { "android.permission.RECORD_AUDIO" });
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "");
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      return false;
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "single friend list: " + paramContext + " curType:" + paramSessionInfo.cZ + " curFriendUin:" + paramSessionInfo.aTl);
      }
      try
      {
        paramContext = new JSONArray(paramContext);
        int i = 0;
        while (i < paramContext.length())
        {
          paramString = paramContext.getJSONObject(i);
          if ((paramString.has("type")) && (paramString.has("uin")))
          {
            int j = paramString.getInt("type");
            paramString = paramString.getString("uin");
            if ((j == paramSessionInfo.cZ) && (paramString.equals(top.gY(paramSessionInfo.aTl))))
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore true");
              }
              return true;
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
  
  public static boolean a(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString2, "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ChatActivityUtils", 4, "single friend list: " + (String)localObject + " curType:" + paramInt + " uin:" + paramString1);
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
            break label235;
          }
          int j = localJSONObject.getInt("type");
          String str = localJSONObject.getString("uin");
          if ((j == paramInt) && (str.equals(top.gY(paramString1)))) {
            break label235;
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
      paramContext.putString(paramString2, ((JSONArray)localObject).toString());
      boolean bool = paramContext.commit();
      return bool;
      label235:
      i += 1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== uinType = " + paramInt);
    }
    aizg localaizg = (aizg)paramQQAppInterface.getManager(16);
    boolean bool1;
    if (paramInt == 0)
    {
      if (!((acff)paramQQAppInterface.getManager(51)).ke(paramString1)) {
        break label254;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityUtils", 2, "isMsgShielded() ==== isMsgShield = " + bool1);
      }
      return bool1;
      if ((paramInt == 1001) || (paramInt == 10002))
      {
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (localaizg == null) {
          break label248;
        }
      }
      label248:
      for (bool1 = localaizg.nf(paramString1);; bool1 = false)
      {
        if (!bool1)
        {
          paramQQAppInterface = paramQQAppInterface.e(paramString1);
          if ((paramQQAppInterface != null) && (paramQQAppInterface.groupid == -1002)) {
            bool1 = bool2;
          }
        }
        for (;;)
        {
          break;
          bool1 = bool3;
          if (paramInt == 1011) {
            break;
          }
          bool1 = bool3;
          if (localaizg == null) {
            break;
          }
          String str = paramString1;
          if (paramInt == 1006)
          {
            str = paramString1;
            if (paramString1 == null) {
              str = aqgv.x(paramQQAppInterface, paramString2);
            }
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          bool1 = localaizg.nf(str);
          break;
        }
      }
      label254:
      bool1 = false;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, ArrayList<String> paramArrayList)
  {
    paramArrayList = (ajdo)paramQQAppInterface.getManager(11);
    if (paramInt == 3000)
    {
      paramString = ((acdu)paramQQAppInterface.getManager(53)).z(paramString);
      if (paramString != null)
      {
        int i = paramString.size();
        paramInt = 0;
        while (paramInt < i)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramString.get(paramInt);
          if ((localDiscussionMemberInfo != null) && (!paramQQAppInterface.getAccount().equals(localDiscussionMemberInfo.memberUin)) && (paramArrayList.a(localDiscussionMemberInfo.memberUin) != null)) {
            return true;
          }
          paramInt += 1;
        }
      }
    }
    return false;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt1 == 1) && (paramQQAppInterface.a().i(paramInt1, paramLong)) && (paramQQAppInterface.a().uq()) && (paramInt2 == 1))
    {
      paramLong = AudioHelper.hG();
      if (QLog.isColorLevel()) {
        QLog.w("ChatActivityUtils", 1, "checkGroupInAnotherChating, seq[" + paramLong + "]");
      }
      long l = paramQQAppInterface.a().bG();
      paramInt1 = paramQQAppInterface.a().z(l);
      if (paramInt1 != paramInt3)
      {
        if ((paramInt1 == 10) && (paramInt3 == 2))
        {
          if (paramQQAppInterface.a().uk()) {
            QQToast.a(paramContext, 2131697709, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          }
          for (;;)
          {
            return true;
            QQToast.a(paramContext, 2131697711, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          }
        }
        if ((paramInt1 == 2) && (paramInt3 == 10))
        {
          if (paramQQAppInterface.a().uk()) {
            QQToast.a(paramContext, 2131697712, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          }
          for (;;)
          {
            return true;
            QQToast.a(paramContext, 2131697708, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          }
        }
      }
      if (paramInt3 != 2) {
        break label270;
      }
      paramQQAppInterface = new Intent("com.tencent.av.EXIT_VIDEO_PROCESS");
      jlc.a(paramQQAppInterface, paramLong);
      paramContext.sendBroadcast(paramQQAppInterface);
    }
    for (;;)
    {
      return false;
      label270:
      paramContext.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, String paramString5)
  {
    return a(paramQQAppInterface, paramContext, paramInt, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramc, paramString5, null);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, String paramString5, Map<String, String> paramMap)
  {
    if (QLog.isDevelopLevel()) {}
    for (Object localObject = new Throwable("打印调用栈");; localObject = null)
    {
      long l = AudioHelper.hG();
      QLog.w("ChatActivityUtils", 1, "startVideo, uinType[" + paramInt + "], peerUin[" + paramString1 + "], name[" + paramString2 + "], phoneNum[" + paramString3 + "], onlyAudio[" + paramBoolean1 + "], extraUin[" + paramString4 + "], checkShieldMsg[" + paramBoolean2 + "], checkWifi[" + paramBoolean3 + "], from[" + paramString5 + "], seq[" + l + "]", (Throwable)localObject);
      localObject = new d(null);
      ((d)localObject).uinType = paramInt;
      ((d)localObject).peerUin = paramString1;
      ((d)localObject).name = paramString2;
      ((d)localObject).phoneNum = paramString3;
      ((d)localObject).aTF = paramBoolean1;
      ((d)localObject).MP = paramString4;
      ((d)localObject).aTG = paramBoolean2;
      ((d)localObject).aTH = paramBoolean3;
      ((d)localObject).from = paramString5;
      ((d)localObject).hh = paramMap;
      ((d)localObject).aTI = true;
      ((d)localObject).aTJ = false;
      return a(l, paramQQAppInterface, paramContext, paramc, (d)localObject);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, Map<String, String> paramMap, int paramInt2, boolean paramBoolean4)
  {
    if (!aqiw.isNetworkAvailable(paramContext))
    {
      QQToast.a(paramContext, 0, 2131696270, 0).show();
      return false;
    }
    Object localObject2 = (ajdo)paramQQAppInterface.getManager(11);
    Object localObject1 = ((ajdo)localObject2).a();
    String str;
    if (localObject1 != null)
    {
      localObject3 = ((RespondQueryQQBindingStat)localObject1).mobileNo;
      str = ((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo;
      if (((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(paramString3))) || ((!TextUtils.isEmpty(str)) && (str.equals(paramString3))))
      {
        QQToast.a(paramContext, 2131697908, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        return false;
      }
    }
    atdc localatdc = (atdc)paramQQAppInterface.getManager(746);
    Object localObject3 = localatdc.a(paramQQAppInterface.getCurrentAccountUin());
    int i;
    if ((localObject3 != null) && (((PstnCardInfo)localObject3).pstn_c2c_call_time > 0))
    {
      i = 1;
      if ((!paramBoolean4) || (paramInt1 != 0) || (localatdc.aJb()) || (!jkm.a(paramQQAppInterface, 1)) || (!c(paramQQAppInterface, paramInt1, paramString1)) || (i == 0)) {
        break label372;
      }
      localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131697904);
      localObject2 = paramQQAppInterface.getApplication().getResources().getString(2131697902);
      str = localatdc.ro("pstn_c2c_trans_wording");
      localObject3 = localatdc.ro("pstn_c2c_trans_check_wording");
      if (!TextUtils.isEmpty(str)) {
        break label358;
      }
      label277:
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break label365;
      }
    }
    for (;;)
    {
      aqha.a(paramContext, 230, "确认呼叫方式", (String)localObject1, (String)localObject2, "取消", "呼叫", null, new uly(localatdc, paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramc, paramMap, paramInt2), new ulz(paramc, paramQQAppInterface)).show();
      return false;
      i = 0;
      break;
      label358:
      localObject1 = str;
      break label277;
      label365:
      localObject2 = localObject3;
    }
    label372:
    if ((paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 1006) || (paramInt1 == 56938) || ((paramInt1 == 0) && (c(paramQQAppInterface, paramInt1, paramString1))))
    {
      paramString4 = new PstnSessionInfo();
      paramString4.mUinType = paramInt1;
      paramString4.mPeerUin = paramString1;
      if (TextUtils.isEmpty(paramString3))
      {
        paramString1 = ((ajdo)localObject2).a(paramString1);
        if (paramString1 == null) {}
      }
      for (paramString4.cGF = paramString1.unifiedCode;; paramString4.cGF = paramString3)
      {
        paramString4.mNickName = paramString2;
        if (localObject1 != null) {
          paramString4.cGG = (((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo);
        }
        return a(paramQQAppInterface, paramContext, paramString4, paramInt2, paramc, true);
      }
    }
    if (paramInt1 == 0) {
      return a(paramQQAppInterface, paramContext, paramInt1, paramString1, paramString2, paramString3, paramBoolean1, paramString4, paramBoolean2, paramBoolean3, paramc, "from_internal", paramMap);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivityUtils", 2, "startC2CCall| type is wrong.");
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.c paramc, Bundle paramBundle)
  {
    long l1 = AudioHelper.hG();
    Object localObject = new StringBuilder().append("startGroupAudioEx, uinType[").append(paramInt).append("], uin[").append(paramString).append("], checkWifi[").append(paramBoolean1).append("], checkMutex[").append(paramBoolean2).append("], StartVideoListener[");
    boolean bool1;
    label93:
    StringBuilder localStringBuilder;
    if (paramc != null)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append("], extroBundle[");
      if (paramBundle == null) {
        break label180;
      }
      bool1 = true;
      localStringBuilder = ((StringBuilder)localObject).append(bool1).append("], fromWhere[");
      if (paramBundle != null) {
        break label186;
      }
    }
    label180:
    label186:
    for (localObject = "null";; localObject = paramBundle.getString("Fromwhere"))
    {
      QLog.w("ChatActivityUtils", 1, (String)localObject + "], seq[" + l1 + "]");
      AudioHelper.b("ChatActivityUtils.startGroupAudioEx", paramBundle, true);
      if (a(paramQQAppInterface, paramContext, paramc, paramInt, paramString)) {
        break label199;
      }
      return true;
      bool1 = false;
      break;
      bool1 = false;
      break label93;
    }
    label199:
    long l2 = Long.valueOf(paramString).longValue();
    int j = jll.cL(paramInt);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    for (;;)
    {
      jlc.a(paramBundle, l1);
      boolean bool2 = paramBundle.getBoolean("isVideo", false);
      localObject = a(l1, paramContext);
      if (!bool2) {}
      for (bool1 = true; !a((Activity)localObject, bool1, new uko(l1, paramContext, paramQQAppInterface, paramInt, paramString, paramBoolean2, paramc, paramBundle, bool2)); bool1 = false) {
        return true;
      }
      int i = paramBundle.getInt("MultiAVType", 0);
      if (i == 10) {
        aqji.c("startGroupAudioEx", paramQQAppInterface, paramString);
      }
      if (j == 2) {
        i = 1;
      }
      if (j == 1) {
        paramQQAppInterface.a().v(l1, bool2);
      }
      if (a(paramQQAppInterface, paramContext, j, paramInt, l2, i)) {
        return true;
      }
      if (!paramQQAppInterface.a().b(j, l2, i))
      {
        if (!a(paramQQAppInterface, paramContext, paramc, new ukp(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean2, paramc, paramBundle), paramBoolean1, bool2)) {
          return true;
        }
        if (a(l1, paramQQAppInterface, paramContext, paramc, new ukq(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramc, paramBundle), paramBoolean2, paramString, j, l2, i)) {
          return true;
        }
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005776", "0X8005776", 0, 0, "", "", "", "");
      if (paramc != null) {
        paramc.aqM();
      }
      a(paramQQAppInterface, paramContext, paramInt, paramString, paramBundle);
      if (paramc != null) {
        paramc.aqN();
      }
      paramQQAppInterface.a().k(7, l2, i);
      return true;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, ChatActivityUtils.c paramc, Map<String, String> paramMap)
  {
    int i;
    if ((paramMap != null) && ("true".equals(paramMap.get("isVideo"))))
    {
      i = 4;
      if (i != 4) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.a().a(paramContext, paramInt, paramString, bool))) {
        break label75;
      }
      return false;
      i = paramQQAppInterface.a().getSessionType();
      break;
    }
    label75:
    return a(paramQQAppInterface, paramContext, paramInt, paramString, paramBoolean1, paramBoolean2, paramc, b(paramMap));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, ArrayList<String> paramArrayList, int paramInt2, int paramInt3)
  {
    return a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramc, paramArrayList, paramInt2, paramInt3, true, true);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ChatActivityUtils.c paramc, ArrayList<String> paramArrayList, int paramInt2, int paramInt3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (!aqiw.isNetworkAvailable(paramContext))
    {
      QQToast.a(paramContext, 0, 2131696270, 0).show();
      return false;
    }
    Object localObject2 = jkm.a(paramQQAppInterface, 2);
    String str1 = jkm.b(paramQQAppInterface, 2);
    String str2 = jkm.c(paramQQAppInterface, 2);
    Object localObject3 = (atdc)paramQQAppInterface.getManager(746);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("PstnLevel", "LEVEL2");
    ((Map)localObject1).put("PLACE", "CALL_CREATE");
    long l2 = 0L;
    long l1;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      if (paramQQAppInterface.a().r().containsKey(Long.valueOf(l1)))
      {
        String str3 = (String)paramQQAppInterface.a().r().get(Long.valueOf(l1));
        paramQQAppInterface.a().r().remove(Long.valueOf(l1));
        ((Map)localObject1).put("CREATE_PLACE", str3);
      }
      if ((((atdc)localObject3).Og() == 0) || (paramInt2 == 0))
      {
        ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
        return a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, (Map)localObject1);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ChatActivityUtils", 2, "NumberFormatException uin = " + paramString);
          l1 = l2;
        }
      }
    }
    if (paramInt2 == 1)
    {
      ((Map)localObject1).put("ipPstnEnterType", String.valueOf(paramInt2));
      localObject3 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (paramArrayList != null) {
        ((ArrayList)localObject3).addAll(paramArrayList);
      }
      if (jkm.a(paramQQAppInterface, 2)) {
        if (!jkm.a(paramQQAppInterface, paramContext))
        {
          paramArrayList = new ArrayList();
          paramBoolean3 = true;
          if (paramInt3 == 2) {
            paramBoolean3 = false;
          }
          if (a(paramQQAppInterface, paramBoolean3, paramInt1, paramString, (ArrayList)localObject3, paramArrayList, localArrayList)) {
            break label481;
          }
          if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0)) {
            ((Map)localObject1).put("PhoneNumberList", jkm.i((ArrayList)localObject3));
          }
          if ((jkm.b(paramQQAppInterface, 2)) && (paramBoolean5))
          {
            aqha.a(paramContext, 230, "时长不足", jkm.d(paramQQAppInterface, 2), "购买时长", "继续拨打", new ulj(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, (Map)localObject1), new ulk(paramQQAppInterface, paramContext)).show();
            return false;
          }
          a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, (Map)localObject1);
        }
      }
    }
    for (;;)
    {
      return false;
      label481:
      return true;
      if ((paramInt3 == 6) || (paramInt3 == 3)) {
        aqha.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131721690), str2, new ull(paramQQAppInterface, paramContext, paramc, paramInt3), new ulm(paramQQAppInterface, paramInt3)).show();
      }
      for (;;)
      {
        return false;
        jkm.a(paramQQAppInterface, paramContext, 2, 12);
      }
      if (jkm.a(paramQQAppInterface, 2))
      {
        localObject2 = (PhoneContactManagerImp)paramQQAppInterface.getManager(11);
        if ((localObject2 != null) && (((PhoneContactManagerImp)localObject2).xy() >= 9))
        {
          localObject2 = ((atdc)localObject3).a(paramQQAppInterface.getCurrentAccountUin());
          int i;
          if ((localObject2 != null) && (((PstnCardInfo)localObject2).pstn_multi_call_time > 0))
          {
            i = 1;
            int j = jll.cL(paramInt1);
            l1 = Long.valueOf(paramString).longValue();
            if ((paramQQAppInterface.a().i(j, l1)) || (((atdc)localObject3).Oj() != 1) || (((atdc)localObject3).aJc()) || ((!a(paramQQAppInterface, paramInt1, paramString, paramArrayList)) && (aqiw.getNetworkType(paramContext) != 2)) || (i == 0) || (6 == paramInt3) || (!paramBoolean4)) {
              break label849;
            }
            localObject1 = paramQQAppInterface.getApplication().getResources().getString(2131697913);
            localObject2 = paramQQAppInterface.getApplication().getResources().getString(2131697911);
            str2 = ((atdc)localObject3).ro("pstn_multi_trans_wording");
            str1 = ((atdc)localObject3).ro("pstn_multi_trans_check_wording");
            if (!TextUtils.isEmpty(str2)) {
              break label835;
            }
            label756:
            if (!TextUtils.isEmpty(str1)) {
              break label842;
            }
          }
          for (;;)
          {
            aqha.a(paramContext, 230, "确认呼叫方式", (String)localObject1, (String)localObject2, "取消", "呼叫", null, new uln((atdc)localObject3, paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramc, paramArrayList, paramInt2, paramInt3, paramBoolean5), new ulo(paramc, paramQQAppInterface)).show();
            return false;
            i = 0;
            break;
            label835:
            localObject1 = str2;
            break label756;
            label842:
            localObject2 = str1;
          }
          label849:
          if ((jkm.b(paramQQAppInterface, 2)) && (paramBoolean5))
          {
            aqha.a(paramContext, 230, "时长不足", jkm.d(paramQQAppInterface, 2), "购买时长", "继续拨打", new ulq(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramBoolean3, paramc, paramArrayList, paramInt2, paramInt3, paramBoolean4), new ulr(paramQQAppInterface, paramContext)).show();
            return false;
          }
          if (paramInt2 == 4) {
            ((Map)localObject1).put("ipPstnEnterType", String.valueOf(4));
          }
          for (;;)
          {
            if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
              ((Map)localObject1).put("PhoneNumberList", jkm.i(paramArrayList));
            }
            a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, (Map)localObject1);
            break;
            ((Map)localObject1).put("ipPstnEnterType", String.valueOf(2));
          }
        }
        if ((paramInt2 == 3) && ((paramArrayList == null) || (paramArrayList.size() == 0)))
        {
          ((Map)localObject1).put("PstnLevel", "LEVEL2");
          ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
          a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, (Map)localObject1);
        }
        else
        {
          jkm.a(paramQQAppInterface, paramContext);
        }
      }
      else if ((paramInt3 == 3) || (paramInt3 == 6))
      {
        localObject3 = ((acdu)paramQQAppInterface.getManager(53)).z(paramString);
        if ((localObject3 != null) && (((List)localObject3).size() == 1) && (((DiscussionMemberInfo)((List)localObject3).get(0)).memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
        {
          aqha.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131721690), str2, new uls(paramQQAppInterface, paramContext, paramc, paramInt3), new ult(paramQQAppInterface, paramInt3)).show();
        }
        else if ((paramArrayList != null) && (paramArrayList.size() > 0))
        {
          aqha.a(paramContext, (String)localObject2, str1, str2, new ulu(paramQQAppInterface, paramContext, paramc, paramInt3), paramContext.getString(2131697378), new ulv((Map)localObject1, paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, paramInt3)).show();
        }
        else
        {
          ((Map)localObject1).put("PstnLevel", "LEVEL2");
          ((Map)localObject1).put("ipPstnEnterType", String.valueOf(0));
          a(paramQQAppInterface, paramContext, paramInt1, paramString, paramBoolean1, paramBoolean2, paramc, (Map)localObject1);
        }
      }
      else
      {
        aqha.a(paramContext, 230, (String)localObject2, str1, paramContext.getString(2131721690), str2, new ulw(paramQQAppInterface, paramContext, paramc), new ulx()).show();
      }
    }
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc, int paramInt, String paramString)
  {
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, Activity isDestroyed!");
      return false;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 当前网络不可用");
      QQToast.a(paramContext, 2131696206, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005767", "0X8005767", 0, 0, "", "", "", "");
      return false;
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005768", "0X8005768", 0, 0, "", "", "", "");
    if (!imm.isSupportSharpAudio())
    {
      QQToast.a(paramContext, 2131697698, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005769", "0X8005769", 0, 0, "", "", "", "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800576B", "0X800576B", 0, 0, "", "", imm.getCpuReport(), "");
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X800576C", "0X800576C", 0, 0, "", "", imm.getModelReport(), "");
      return false;
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800576A", "0X800576A", 0, 0, "", "", "", "");
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X800576E", "0X800576E", 0, 0, "", "", "", "");
    if ((paramQQAppInterface.a().sM()) && (!paramQQAppInterface.bF()))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, 有系统电话");
      jjk.S(true, true);
      paramQQAppInterface = paramContext.getString(2131697899);
      paramString = paramContext.getString(2131697879);
      if ((paramContext instanceof Activity)) {}
      for (;;)
      {
        aqha.a(paramContext, 230, paramString, paramQQAppInterface, 2131721058, 2131721079, new ukj(paramc), null).show();
        jjk.awV();
        return false;
        paramContext = com.tencent.mobileqq.app.BaseActivity.sTopActivity;
      }
    }
    if (!imm.isNormalSharp())
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, old engine");
      if (paramInt == 1011)
      {
        paramString = paramContext.getString(2131698112);
        aqha.a(paramContext, 230, paramContext.getString(2131697879), paramString, 2131721058, 2131697810, new ukk(paramc), null).show();
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80053BD", "0X80053BD", 0, 0, "", "", "", "");
        return false;
      }
    }
    if ((!DiscussionInfo.isValidDisUin(paramString)) && (paramInt == 3000))
    {
      QLog.d("ChatActivityUtils", 1, "startGroupAudio, invalid discussId: " + paramString);
      return false;
    }
    return true;
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, ChatActivityUtils.c paramc, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramBoolean1) && (!aqiw.isWifiConnected(BaseApplication.getContext())) && (!aqiw.bX(BaseApplication.getContext())) && (VideoController.ag(VideoController.Mp + paramQQAppInterface.getCurrentAccountUin()) <= 0))
    {
      if (!aqiw.isMobileNetWork(BaseApplication.getContext())) {
        break label206;
      }
      localObject1 = paramContext.getString(2131697879);
      localObject2 = paramContext.getString(2131697874);
    }
    for (;;)
    {
      if (aqiw.is3Gor4G(BaseApplication.getContext()))
      {
        localObject2 = paramContext.getString(2131697879);
        if (paramBoolean2) {
          localObject1 = paramContext.getString(2131697875);
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ChatActivityUtils", 2, "startGAudio title or content is empty");
          }
          return false;
          localObject1 = paramContext.getString(2131697876);
        }
        else
        {
          a(paramQQAppInterface, paramContext, 230, (String)localObject2, (String)localObject1, 2131697614, 2131697626, paramOnClickListener, new ukl(paramc));
          return false;
          return true;
          Object localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      label206:
      localObject1 = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt)
  {
    return a(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt, null, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, PstnSessionInfo paramPstnSessionInfo, int paramInt, ChatActivityUtils.c paramc, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      if ("startPstnC2CCall|pstnSession=" + paramPstnSessionInfo != null) {
        break label64;
      }
    }
    label64:
    for (String str1 = "null";; str1 = paramPstnSessionInfo.toString() + ", from=" + paramInt)
    {
      QLog.d("ChatActivityUtils", 2, str1);
      if (aqiw.isNetworkAvailable(paramContext)) {
        break;
      }
      QQToast.a(paramContext, 0, 2131696270, 0).show();
      return false;
    }
    if (paramQQAppInterface.bF())
    {
      i = 1;
      if (paramQQAppInterface.a().a().epd != -1)
      {
        str1 = paramQQAppInterface.a().a().mPeerUin;
        if ((TextUtils.isEmpty(paramPstnSessionInfo.mPeerUin)) || (TextUtils.isEmpty(str1)) || (!str1.equals(paramPstnSessionInfo.mPeerUin))) {
          break label721;
        }
      }
    }
    label712:
    label721:
    for (int i = 0;; i = 1)
    {
      String str2;
      if (i != 0)
      {
        str1 = (String)akwj.R(paramPstnSessionInfo.cGF).get(1);
        str2 = (String)akwj.R(paramQQAppInterface.a().a().cGF).get(1);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str1.equals(str2))) {
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          return false;
        }
        if ((!TextUtils.isEmpty(paramPstnSessionInfo.cGG)) && (!TextUtils.isEmpty(paramPstnSessionInfo.cGF)) && ((paramPstnSessionInfo.cGG.equals(paramPstnSessionInfo.cGF)) || (paramPstnSessionInfo.cGG.contains(paramPstnSessionInfo.cGF))))
        {
          QQToast.a(paramContext, 2131697908, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
          return false;
        }
        str1 = jkm.a(paramQQAppInterface, 1);
        str2 = jkm.b(paramQQAppInterface, 1);
        String str3 = jkm.c(paramQQAppInterface, 1);
        if (jkm.a(paramQQAppInterface, 1))
        {
          if ((jkm.b(paramQQAppInterface, 1)) && (paramBoolean))
          {
            aqha.a(paramContext, 230, "时长不足", jkm.d(paramQQAppInterface, 1), "购买时长", "继续拨打", new umb(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt, paramc), new umc(paramQQAppInterface, paramContext, paramc)).show();
            return false;
          }
          if ((paramContext instanceof com.tencent.mobileqq.app.BaseActivity)) {
            if ((paramInt != 4) && (paramInt != 5))
            {
              paramBoolean = true;
              if (!jkm.a(paramQQAppInterface, (com.tencent.mobileqq.app.BaseActivity)paramContext, 2002, paramBoolean))
              {
                paramQQAppInterface = new Intent();
                if (paramInt == 7) {
                  paramQQAppInterface.addFlags(268435456);
                }
                paramQQAppInterface.putExtra("pstn_session_info", paramPstnSessionInfo);
                paramContext.startActivity(paramQQAppInterface);
              }
            }
          }
          for (;;)
          {
            if (paramc != null) {
              paramc.aqN();
            }
            return true;
            paramBoolean = false;
            break;
            if (!jkm.a(paramQQAppInterface, paramContext))
            {
              paramQQAppInterface = new Intent();
              if (paramInt == 7) {
                paramQQAppInterface.addFlags(268435456);
              }
              paramQQAppInterface.putExtra("pstn_session_info", paramPstnSessionInfo);
              paramContext.startActivity(paramQQAppInterface);
            }
          }
        }
        if ((paramInt == 3) || (paramInt == 5)) {
          if ((paramPstnSessionInfo.mUinType != 0) || (((ajdo)paramQQAppInterface.getManager(11)).a(paramPstnSessionInfo.mPeerUin) == null)) {
            break label712;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            aqha.a(paramContext, str1, str2, str3, new umd(paramQQAppInterface, paramContext, paramInt), paramContext.getString(2131697377), new ume(paramQQAppInterface, paramContext, paramPstnSessionInfo, paramInt)).show();
          }
          for (;;)
          {
            return false;
            aqha.a(paramContext, 230, str1, str2, paramContext.getString(2131721690), str3, new umf(paramQQAppInterface, paramContext, paramInt), new umg(paramQQAppInterface, paramInt)).show();
            continue;
            jkm.a(paramQQAppInterface, paramContext, 1, 8);
          }
        }
      }
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt, String paramString, ArrayList<String> paramArrayList1, ArrayList<InviteBaseData> paramArrayList, ArrayList<String> paramArrayList2)
  {
    boolean bool = false;
    Object localObject2 = "";
    ajdo localajdo;
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (paramInt == 3000)
    {
      localajdo = (ajdo)paramQQAppInterface.getManager(11);
      localObject3 = (acdu)paramQQAppInterface.getManager(53);
      localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localObject3 = ((acdu)localObject3).z(paramString);
      if (localObject3 != null)
      {
        int j = ((ArrayList)localObject3).size();
        i = 0;
        if (i < j)
        {
          localObject4 = (DiscussionMemberInfo)((ArrayList)localObject3).get(i);
          if (localObject4 != null) {
            if (((String)localObject1).equals(((DiscussionMemberInfo)localObject4).memberUin))
            {
              if (localajdo.a() != null) {
                break label769;
              }
              bool = true;
            }
          }
        }
      }
    }
    label769:
    for (;;)
    {
      i += 1;
      break;
      paramArrayList.add(new InviteBaseData((DiscussionMemberInfo)localObject4));
      localObject4 = localajdo.a(((DiscussionMemberInfo)localObject4).memberUin);
      if (localObject4 != null)
      {
        paramArrayList1.add(((PhoneContact)localObject4).unifiedCode);
        paramArrayList2.add(((PhoneContact)localObject4).mobileNo);
      }
      for (;;)
      {
        break;
        bool = true;
      }
      bool = true;
      continue;
      localObject1 = localObject2;
      if (!paramBoolean)
      {
        localObject3 = jkm.a(paramQQAppInterface, paramString, 3000);
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = jkm.p((String)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject2 = ((ArrayList)localObject3).iterator();
            localObject1 = "";
            label254:
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (AVPhoneUserInfo)((Iterator)localObject2).next();
              if (!a(localajdo, ((AVPhoneUserInfo)localObject3).telInfo.mobile, paramArrayList))
              {
                paramArrayList.add(new InviteBaseData((AVPhoneUserInfo)localObject3, paramQQAppInterface));
                paramArrayList1.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
                paramArrayList2.add(((AVPhoneUserInfo)localObject3).telInfo.mobile);
              }
              if (!QLog.isDevelopLevel()) {
                break label766;
              }
              localObject1 = (String)localObject1 + String.format("\n\rAVPhoneUserInfo: %s", new Object[] { localObject3 });
            }
          }
        }
      }
      label766:
      for (;;)
      {
        break label254;
        bool = true;
        break;
        while (QLog.isDevelopLevel())
        {
          paramQQAppInterface = (String)localObject1 + String.format("\n\rphoneList[%s]", new Object[] { Integer.valueOf(paramArrayList1.size()) });
          paramArrayList1 = paramArrayList1.iterator();
          for (;;)
          {
            if (paramArrayList1.hasNext())
            {
              localObject1 = (String)paramArrayList1.next();
              paramQQAppInterface = paramQQAppInterface + String.format("\n\rphone: %s", new Object[] { localObject1 });
              continue;
              bool = true;
              localObject1 = localObject2;
              break;
            }
          }
          paramQQAppInterface = paramQQAppInterface + String.format("\n\rselectedList[%s]", new Object[] { Integer.valueOf(paramArrayList2.size()) });
          paramArrayList1 = paramArrayList2.iterator();
          while (paramArrayList1.hasNext())
          {
            paramArrayList2 = (String)paramArrayList1.next();
            paramQQAppInterface = paramQQAppInterface + String.format("\n\rselected: %s", new Object[] { paramArrayList2 });
          }
          paramQQAppInterface = paramQQAppInterface + String.format("\n\rinviteList[%s]", new Object[] { Integer.valueOf(paramArrayList.size()) });
          paramArrayList1 = paramArrayList.iterator();
          while (paramArrayList1.hasNext())
          {
            paramArrayList = (InviteBaseData)paramArrayList1.next();
            paramQQAppInterface = paramQQAppInterface + String.format("\n\rinvite: %s", new Object[] { paramArrayList });
          }
          QLog.d("ChatActivityUtils", 4, String.format("checkDiscussMemberNoPhone, onlyMembers[%s], uinType[%s], uin[%s], hasNoPhone[%s], %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString, Boolean.valueOf(bool), paramQQAppInterface }));
        }
        return bool;
      }
    }
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
  
  public static String av(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString2 = paramString2.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString2.length];
      int i = 0;
      while (i < paramString2.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString2[i].trim());
        i += 1;
      }
      paramString2 = h(arrayOfByte, Q(paramString1 + "MasPlay", 32).getBytes("UTF-8"));
      paramString1 = localObject;
      if (paramString2 != null) {
        paramString1 = new String(paramString2, "UTF-8").replace("$", "");
      }
      return paramString1;
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public static String aw(String paramString1, String paramString2)
  {
    int j = 1;
    int k = 0;
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = paramString2.length();
        if (m >= 16) {
          break label202;
        }
        i = 0;
        str = paramString2;
        if (i < 16 - m)
        {
          paramString2 = paramString2 + "$";
          i += 1;
          continue;
        }
        paramString1 = Q(paramString1 + "MasPlay", 32).getBytes("UTF-8");
        paramString2 = new byte[16];
        i = k;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      paramString1 = new SecretKeySpec(paramString2, "AES");
      paramString2 = Cipher.getInstance("AES/CBC/NoPadding");
      paramString2.init(1, paramString1);
      paramString1 = paramString2.doFinal(str.getBytes("utf-8"));
      paramString2 = new StringBuffer();
      if (paramString1.length > 0)
      {
        paramString2.append(paramString1[0]);
        i = j;
        if (i < paramString1.length)
        {
          paramString2.append(",");
          paramString2.append(paramString1[i]);
          i += 1;
          continue;
        }
      }
      paramString1 = paramString2.toString();
      return paramString1;
      label202:
      String str = paramString2;
      if (m > 16)
      {
        return null;
        while (i < 16)
        {
          paramString2[i] = paramString1[i];
          i += 1;
        }
      }
    }
  }
  
  private static byte b(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  static Bundle b(Map<String, String> paramMap)
  {
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (paramMap != null)
    {
      if (paramMap.containsKey("actid")) {
        localBundle.putString("actId", (String)paramMap.get("actid"));
      }
      if (paramMap.containsKey("mp_ext_params")) {
        localBundle.putString("mp_ext_params", (String)paramMap.get("mp_ext_params"));
      }
      localObject1 = (String)paramMap.get("MultiAVType");
      if (localObject1 != null) {
        localBundle.putInt("MultiAVType", Integer.valueOf((String)localObject1).intValue());
      }
      if (!TextUtils.equals((String)paramMap.get("isVideo"), "true")) {
        break label438;
      }
    }
    label438:
    for (boolean bool = true;; bool = false)
    {
      localBundle.putBoolean("isVideo", bool);
      localObject1 = (String)paramMap.get("Fromwhere");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("Fromwhere", (String)localObject1);
      }
      if (paramMap.containsKey("ConfAppID")) {
        localBundle.putInt("ConfAppID", Integer.valueOf((String)paramMap.get("ConfAppID")).intValue());
      }
      if (paramMap.containsKey("MeetingConfID")) {
        localBundle.putInt("MeetingConfID", Integer.valueOf((String)paramMap.get("MeetingConfID")).intValue());
      }
      localBundle.putString("jump_from", (String)paramMap.get("jump_from"));
      localBundle.putString("enterType", (String)paramMap.get("enterType"));
      if (paramMap != null)
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        Object localObject2;
        for (paramMap = "";; paramMap = paramMap + "  [" + (String)((Map.Entry)localObject1).getKey() + "]=[" + localObject2 + "], [" + localObject2.getClass().getName() + "]\n")
        {
          localObject1 = paramMap;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (Map.Entry)localIterator.next();
          localObject2 = ((Map.Entry)localObject1).getValue();
        }
      }
      localObject1 = "null";
      QLog.w("ChatActivityUtils", 1, "strExtroInfo[extroInfo2Bundle]:\n" + (String)localObject1);
      AudioHelper.b("ChatActivityUtils_extroInfo2Bundle", localBundle, true);
      return localBundle;
    }
  }
  
  public static MessageRecord b(List<ChatMessage> paramList, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    if ((!fY(paramSessionInfo.cZ)) || (paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (paramSessionInfo.cZ == 1006)
    {
      paramSessionInfo = (MessageRecord)paramList.get(0);
      return a(paramSessionInfo, paramQQAppInterface);
    }
    int i = paramList.size() - 1;
    label61:
    if (i >= 0)
    {
      paramSessionInfo = (MessageRecord)paramList.get(i);
      if (top.fz(paramSessionInfo.msgtype)) {}
    }
    for (paramList = paramSessionInfo;; paramList = null)
    {
      paramSessionInfo = paramList;
      if (paramList != null) {
        break;
      }
      return null;
      i -= 1;
      break label61;
    }
  }
  
  public static void b(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    
    if (paramBoolean1) {
      return;
    }
    if (paramBoolean2)
    {
      i(paramActivity, 2131720205, 1);
      return;
    }
    i(paramActivity, 2131720207, 1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString, Bundle paramBundle)
  {
    long l1 = jlc.b(paramBundle);
    QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, uinType[" + paramInt + "], uin[" + paramString + "], seq[" + l1 + "]");
    AudioHelper.b("ChatActivityUtils", paramBundle, true);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (paramString == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.addFlags(262144);
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    l1 = Long.parseLong(paramString);
    int i = jll.cL(paramInt);
    int j = localBundle.getInt("MultiAVType", 0);
    String str2 = localBundle.getString("Fromwhere");
    if (i == 2) {
      j = 1;
    }
    for (;;)
    {
      paramBundle = localBundle.getString("jump_from");
      localIntent.putExtras(localBundle);
      if ((("gvideo".equals(paramBundle)) || ("gvideo_h5".equals(paramBundle))) && (paramInt == 1))
      {
        i = 1;
        if (paramInt == 1)
        {
          paramBundle = (TroopManager)paramQQAppInterface.getManager(52);
          if ((paramBundle == null) || (paramBundle.b(paramString) != null)) {
            break label896;
          }
        }
      }
      label896:
      for (boolean bool = false;; bool = true)
      {
        localIntent.putExtra("troopmember", bool);
        localIntent.putExtra("sessionType", 3);
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uinType", paramInt);
        localIntent.putExtra("Type", i);
        localIntent.putExtra("GroupId", paramString);
        localIntent.putExtra("MultiAVType", j);
        localIntent.putExtra("Fromwhere", str2);
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityUtils", 2, "createOrEnterGroupAudio, from[" + str2 + "]");
        }
        int k = localBundle.getInt("MeetingStasks", -1);
        if (k >= 0) {
          paramQQAppInterface.a().lg(k);
        }
        if (j != 2) {
          localIntent.setClass(paramContext, AVActivity.class);
        }
        jjw.a(paramContext, paramString, j, new ula(i, paramInt, paramQQAppInterface, (alkm)paramQQAppInterface.getManager(38), l1, localIntent, l1, "start_group_audio_time" + paramQQAppInterface.getCurrentAccountUin()));
        return;
        long l2 = paramQQAppInterface.a().d(i, l1);
        paramBundle = "memberNum[" + l2;
        String str1;
        if (l2 > 0L)
        {
          k = paramQQAppInterface.a().z(l1);
          str1 = paramBundle + "], srcAVType[" + k;
          if ((j != k) && (paramInt == 1))
          {
            paramBundle = paramQQAppInterface.a().a(l1, j);
            str1 = str1 + "], VideoRoomInfo[" + paramBundle;
            if ((paramBundle != null) && (paramBundle.aqy == j) && (paramBundle.memberNum > 0))
            {
              i = 1;
              paramBundle = str1 + "], 1.TYPE_GAUDIO_STATUS_ENTER";
            }
          }
        }
        for (;;)
        {
          QLog.w("ChatActivityUtils", 1, "createOrEnterGroupAudio, " + paramBundle);
          break;
          i = 0;
          paramBundle = str1 + "], 2.TYPE_GAUDIO_STATUS_CREATE";
          continue;
          if (paramQQAppInterface.a().i(i, l1))
          {
            i = 2;
            paramBundle = str1 + "], 3.TYPE_GAUDIO_STATUS_CHATING";
          }
          else
          {
            i = 1;
            paramBundle = str1 + "], 4.TYPE_GAUDIO_STATUS_ENTER";
            continue;
            k = 0;
            str1 = paramBundle + "], 5.TYPE_GAUDIO_STATUS_CREATE";
            paramBundle = str1;
            i = k;
            if (j == 2)
            {
              AVNotifyCenter.h localh = paramQQAppInterface.a().a(l1, 2);
              paramBundle = str1;
              i = k;
              if (localh != null)
              {
                paramBundle = str1;
                i = k;
                if (localh.memberNum > 0)
                {
                  i = 1;
                  paramBundle = str1 + "], 6.TYPE_GAUDIO_STATUS_CREATE";
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean b(Context paramContext, SessionInfo paramSessionInfo, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramSessionInfo.cZ);
      localJSONObject.put("uin", top.gY(paramSessionInfo.aTl));
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "isSingleWayFriendTipsBefore curFriendUin:" + paramSessionInfo.aTl + "  curType" + paramSessionInfo.cZ);
      }
      paramSessionInfo = PreferenceManager.getDefaultSharedPreferences(paramContext).getString(paramString, "");
      if (!TextUtils.isEmpty(paramSessionInfo)) {}
      for (paramSessionInfo = new JSONArray(paramSessionInfo);; paramSessionInfo = new JSONArray())
      {
        paramSessionInfo.put(localJSONObject);
        paramSessionInfo = paramSessionInfo.toString();
        paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
        paramContext.putString(paramString, paramSessionInfo);
        return paramContext.commit();
      }
      return false;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((1024 == paramInt) && (jqs.a(paramQQAppInterface, paramString))) {
      return false;
    }
    paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
    if ((paramInt == 0) && (!paramQQAppInterface.isFriend(paramString)))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatActivityUtils", 4, "isSingleWayFriend  true");
      }
      return true;
    }
    return false;
  }
  
  public static byte[] b(JSONObject paramJSONObject)
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
            break label590;
          }
          str1 = paramJSONObject.getString("picture");
          if (!paramJSONObject.has("title")) {
            break label596;
          }
          str2 = paramJSONObject.getString("title");
          if (!paramJSONObject.has("summary")) {
            break label602;
          }
          str3 = paramJSONObject.getString("summary");
          if (!paramJSONObject.has("brief")) {
            break label608;
          }
          localObject2 = paramJSONObject.getString("brief");
          if (!paramJSONObject.has("layout")) {
            break label614;
          }
          i = paramJSONObject.getInt("layout");
          if (!paramJSONObject.has("source")) {
            break label619;
          }
          str4 = paramJSONObject.getString("source");
          if (i == 6)
          {
            if (!paramJSONObject.has("price")) {
              break label625;
            }
            str5 = paramJSONObject.getString("price");
            if (!paramJSONObject.has("prunit")) {
              break label631;
            }
            str6 = paramJSONObject.getString("prunit");
            if (!paramJSONObject.has("icon")) {
              break label637;
            }
            str7 = paramJSONObject.getString("icon");
            if (!paramJSONObject.has("srcaction")) {
              break label643;
            }
            str8 = paramJSONObject.getString("srcaction");
            if (!paramJSONObject.has("action")) {
              break label649;
            }
            str9 = paramJSONObject.getString("action");
            if (!paramJSONObject.has("a_actionData")) {
              break label655;
            }
            str10 = paramJSONObject.getString("a_actionData");
            if (!paramJSONObject.has("i_actionData")) {
              break label661;
            }
            str11 = paramJSONObject.getString("i_actionData");
            if (!paramJSONObject.has("appid")) {
              break label667;
            }
            paramJSONObject = paramJSONObject.getString("appid");
            localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(41).a((String)localObject2).a(7);
            if (TextUtils.isEmpty(paramJSONObject)) {
              break label674;
            }
            l = Long.parseLong(paramJSONObject);
            paramJSONObject = ((AbsShareMsg.a)localObject2).a(l).a(str9, (String)localObject1, null, null, null).a(str4, str7).b(str8, null, null, str10, str11).d((String)localObject1).a();
            localObject1 = anrd.a(i);
            ((anqv)localObject1).b(str1, str2, str3, str5, str6, 0);
            paramJSONObject.addItem((anqu)localObject1);
            return paramJSONObject.getBytes();
          }
          paramJSONObject = paramJSONObject.getString("puin");
          paramJSONObject = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(21).a((String)localObject2).e((String)localObject1).a(str4, null).b("plugin", null, null, "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=" + paramJSONObject, "mqqapi://card/show_pslcard?src_type=app&card_type=public_account&version=1&uin=" + paramJSONObject).a();
          localObject1 = anrd.a(2);
          ((anqv)localObject1).aU(str1, str2, str3);
          paramJSONObject.addItem((anqu)localObject1);
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
      label590:
      String str1 = null;
      continue;
      label596:
      String str2 = null;
      continue;
      label602:
      String str3 = null;
      continue;
      label608:
      Object localObject2 = null;
      continue;
      label614:
      int i = 2;
      continue;
      label619:
      String str4 = null;
      continue;
      label625:
      String str5 = null;
      continue;
      label631:
      String str6 = null;
      continue;
      label637:
      String str7 = null;
      continue;
      label643:
      String str8 = null;
      continue;
      label649:
      String str9 = null;
      continue;
      label655:
      String str10 = null;
      continue;
      label661:
      String str11 = null;
      continue;
      label667:
      paramJSONObject = "";
      continue;
      label674:
      long l = -1L;
    }
  }
  
  public static void bJr()
  {
    if ((jdField_C_of_type_Aqju != null) && (jdField_C_of_type_Aqju.isShowing())) {
      jdField_C_of_type_Aqju.dismiss();
    }
    jdField_C_of_type_Aqju = null;
  }
  
  public static void bJs()
  {
    if ((progressDialog != null) && (progressDialog.isShowing())) {}
    try
    {
      progressDialog.cancel();
      progressDialog = null;
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
  
  public static void bJt()
  {
    if (cT != null)
    {
      cT.clear();
      return;
    }
    cT = new ConcurrentHashMap();
  }
  
  public static void bs(Activity paramActivity)
  {
    if ((paramActivity == null) || (paramActivity.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        if (progressDialog == null)
        {
          progressDialog = new arhz(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299627));
          progressDialog.setMessage(2131719519);
        }
        progressDialog.show();
        return;
      }
      catch (Exception paramActivity) {}finally
      {
        if ((progressDialog != null) && (!progressDialog.isShowing())) {
          progressDialog = null;
        }
      }
    }
  }
  
  private static String bytesToHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 16)
    {
      int k = paramArrayOfByte[i];
      int j = k;
      if (k < 0) {
        j = k + 256;
      }
      localStringBuffer.append(hexDigits[(j >>> 4)]);
      localStringBuffer.append(hexDigits[(j % 16)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String c(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      paramArrayOfByte = h(paramArrayOfByte, Q(paramString + "MasPlay", 32).getBytes("UTF-8"));
      paramString = localObject;
      if (paramArrayOfByte != null) {
        paramString = new String(paramArrayOfByte, "UTF-8").replace("$", "");
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt != 0) {
      return false;
    }
    if (((ajdo)paramQQAppInterface.getManager(11)).a(paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String cr(int paramInt)
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
  
  public static String cs(int paramInt)
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
  
  public static final String d(Activity paramActivity)
  {
    return paramActivity.getClass().getName() + "_" + paramActivity.hashCode();
  }
  
  public static void db(Context paramContext)
  {
    SpannableString localSpannableString = new SpannableString(paramContext.getString(2131700600));
    localSpannableString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramContext.getResources().getColor(2131165750), paramContext.getResources().getColor(2131165758)), localSpannableString.length() - 7, localSpannableString.length() - 1, 33);
    aqha.a(paramContext, paramContext.getString(2131700599), localSpannableString, 0, 2131691042, null, null, new ulc(paramContext)).show();
  }
  
  public static void dc(Context paramContext)
  {
    aqha.a(paramContext, 230, paramContext.getString(2131700589), paramContext.getString(2131700590), new uld(), null).show();
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    return b(paramQQAppInterface, paramSessionInfo.cZ, paramSessionInfo.aTl);
  }
  
  static String f(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = null;
    try
    {
      paramString = paramString.replace("+", "").split(",");
      byte[] arrayOfByte = new byte[paramString.length];
      int i = 0;
      while (i < paramString.length)
      {
        arrayOfByte[i] = Byte.parseByte(paramString[i].trim());
        i += 1;
      }
      paramString = h(arrayOfByte, Q(paramQQAppInterface.getCurrentAccountUin() + "MasPlay", 32).getBytes("UTF-8"));
      paramQQAppInterface = localObject;
      if (paramString != null) {
        paramQQAppInterface = new String(paramString, "UTF-8").replace("$", "");
      }
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface) {}
    return null;
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool2 = false;
    int i = paramSessionInfo.cZ;
    boolean bool1 = bool2;
    if (ixa.a().cD(paramQQAppInterface.getCurrentAccountUin())) {
      if ((i != 0) && (i != 1000) && (i != 1004) && (i != 3000) && (i != 1006) && (i != 1021) && (i != 1010))
      {
        bool1 = bool2;
        if (i != 1025) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean fY(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002) || (paramInt == 10004) || (paramInt == 1005) || (paramInt == 1009) || (paramInt == 1006) || (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1021) || (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1020) || (paramInt == 1025) || (paramInt == 1010) || (paramInt == 10008);
  }
  
  public static void h(Context paramContext, int paramInt1, int paramInt2)
  {
    QQToast.a(paramContext, paramInt1, paramInt2).show(paramContext.getResources().getDimensionPixelSize(2131299627));
  }
  
  public static byte[] h(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    try
    {
      localObject = new byte[16];
      i = 0;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    paramArrayOfByte2 = new SecretKeySpec((byte[])localObject, "AES");
    Object localObject = Cipher.getInstance("AES/CBC/NoPadding");
    ((Cipher)localObject).init(2, paramArrayOfByte2);
    paramArrayOfByte1 = ((Cipher)localObject).doFinal(paramArrayOfByte1);
    return paramArrayOfByte1;
    while (i < 16)
    {
      localObject[i] = paramArrayOfByte2[i];
      i += 1;
    }
  }
  
  public static boolean hc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < cj.length)
      {
        if (paramString.startsWith(cj[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static void i(Context paramContext, int paramInt1, int paramInt2)
  {
    new arie(paramContext).V(paramInt1, paramContext.getResources().getDimensionPixelSize(2131299627), 0, paramInt2);
  }
  
  public static boolean i(String paramString1, String paramString2, String paramString3)
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
  
  public static boolean isValidUin(String paramString)
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
  
  public static byte[] p(String paramString)
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
      int m = b(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(b(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
  
  public static boolean q(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((acff)paramQQAppInterface.getManager(51)).isFriend(paramString);
  }
  
  static class AddFriendSpan
    extends URLSpan
  {
    int mLinkColor = -16776961;
    
    public AddFriendSpan(String paramString, int paramInt)
    {
      super();
      this.mLinkColor = paramInt;
    }
    
    public void onClick(View paramView)
    {
      paramView = paramView.getContext();
      if (((paramView instanceof SplashActivity)) || ((paramView instanceof ChatActivity)))
      {
        paramView = (FragmentActivity)paramView;
        if ((paramView.getChatFragment().a() instanceof ydz)) {
          ((ydz)paramView.getChatFragment().a()).chp();
        }
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(this.mLinkColor);
    }
  }
  
  public static class a
    extends jlq
  {
    final String TAG;
    ChatActivityUtils.b a;
    
    a(String paramString, ChatActivityUtils.b paramb)
    {
      this.TAG = paramString;
      this.a = paramb;
    }
    
    public static void a(String paramString1, String paramString2, ChatActivityUtils.b paramb)
    {
      String str = "https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_confid_by_discid?discid=" + paramString2;
      QLog.w(paramString1, 1, "getConfId, uin[" + paramString2 + "]");
      paramString1 = new a(paramString1, paramb);
      paramString2 = new ArrayList();
      paramb = new jlr();
      paramb.mUrl = str;
      paramb.aBo = 1000;
      paramb.aBp = 1000;
      paramb.QV = 0;
      paramString2.add(paramb);
      paramString1.execute(new ArrayList[] { paramString2 });
    }
    
    /* Error */
    @android.annotation.TargetApi(9)
    public void a(jlr paramjlr)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: bipush 156
      //   5: istore_2
      //   6: aload_1
      //   7: getfield 84	jlr:a	Ljls;
      //   10: getfield 90	jls:mIsSucc	Z
      //   13: ifeq +472 -> 485
      //   16: new 92	java/lang/String
      //   19: dup
      //   20: aload_1
      //   21: getfield 84	jlr:a	Ljls;
      //   24: getfield 96	jls:mBytes	[B
      //   27: ldc 98
      //   29: invokespecial 101	java/lang/String:<init>	([BLjava/lang/String;)V
      //   32: astore_1
      //   33: aload_1
      //   34: ifnull +443 -> 477
      //   37: new 103	org/json/JSONObject
      //   40: dup
      //   41: aload_1
      //   42: invokespecial 106	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   45: astore 6
      //   47: aload 6
      //   49: ldc 108
      //   51: invokevirtual 112	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   54: istore_2
      //   55: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   58: ifeq +30 -> 88
      //   61: aload_0
      //   62: getfield 17	com/tencent/mobileqq/activity/ChatActivityUtils$a:TAG	Ljava/lang/String;
      //   65: iconst_2
      //   66: new 23	java/lang/StringBuilder
      //   69: dup
      //   70: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   73: ldc 118
      //   75: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: iload_2
      //   79: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   82: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   85: invokestatic 124	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   88: iload_2
      //   89: ifne +380 -> 469
      //   92: aload 6
      //   94: ldc 126
      //   96: invokevirtual 130	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   99: astore 7
      //   101: aload 7
      //   103: ifnull +366 -> 469
      //   106: aload 7
      //   108: ldc 132
      //   110: invokevirtual 136	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   113: astore 6
      //   115: aload 6
      //   117: ldc 138
      //   119: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   122: ifeq +347 -> 469
      //   125: aload 7
      //   127: ldc 143
      //   129: invokevirtual 136	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   132: astore 8
      //   134: aload 7
      //   136: ldc 145
      //   138: invokevirtual 136	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   141: astore 7
      //   143: aload 8
      //   145: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   148: ifne +164 -> 312
      //   151: aload 8
      //   153: ldc 153
      //   155: invokevirtual 156	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
      //   158: ifeq +154 -> 312
      //   161: aload 8
      //   163: invokestatic 162	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   166: invokevirtual 166	java/lang/Integer:intValue	()I
      //   169: istore 4
      //   171: aload 7
      //   173: invokestatic 162	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
      //   176: invokevirtual 166	java/lang/Integer:intValue	()I
      //   179: istore_3
      //   180: iload 5
      //   182: istore_2
      //   183: aload_0
      //   184: getfield 17	com/tencent/mobileqq/activity/ChatActivityUtils$a:TAG	Ljava/lang/String;
      //   187: iconst_1
      //   188: new 23	java/lang/StringBuilder
      //   191: dup
      //   192: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   195: ldc 168
      //   197: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: iload_2
      //   201: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   204: ldc 170
      //   206: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   209: iload_3
      //   210: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   213: ldc 172
      //   215: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   218: iload 4
      //   220: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   223: ldc 174
      //   225: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: aload_1
      //   229: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: ldc 38
      //   234: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   240: invokestatic 44	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
      //   243: aload_0
      //   244: getfield 19	com/tencent/mobileqq/activity/ChatActivityUtils$a:a	Lcom/tencent/mobileqq/activity/ChatActivityUtils$b;
      //   247: ifnull +20 -> 267
      //   250: aload_0
      //   251: getfield 19	com/tencent/mobileqq/activity/ChatActivityUtils$a:a	Lcom/tencent/mobileqq/activity/ChatActivityUtils$b;
      //   254: iload_3
      //   255: iload 4
      //   257: invokeinterface 180 3 0
      //   262: aload_0
      //   263: aconst_null
      //   264: putfield 19	com/tencent/mobileqq/activity/ChatActivityUtils$a:a	Lcom/tencent/mobileqq/activity/ChatActivityUtils$b;
      //   267: return
      //   268: astore_1
      //   269: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   272: ifeq +33 -> 305
      //   275: aload_0
      //   276: getfield 17	com/tencent/mobileqq/activity/ChatActivityUtils$a:TAG	Ljava/lang/String;
      //   279: iconst_2
      //   280: new 23	java/lang/StringBuilder
      //   283: dup
      //   284: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   287: ldc 182
      //   289: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   292: aload_1
      //   293: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
      //   296: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   299: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   302: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   305: aconst_null
      //   306: astore_1
      //   307: iconst_m1
      //   308: istore_2
      //   309: goto -276 -> 33
      //   312: iconst_0
      //   313: istore 4
      //   315: bipush 254
      //   317: istore_2
      //   318: iconst_0
      //   319: istore_3
      //   320: goto -137 -> 183
      //   323: astore 6
      //   325: aconst_null
      //   326: astore 6
      //   328: iconst_0
      //   329: istore 4
      //   331: bipush 253
      //   333: istore_2
      //   334: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   337: ifeq +41 -> 378
      //   340: aload_0
      //   341: getfield 17	com/tencent/mobileqq/activity/ChatActivityUtils$a:TAG	Ljava/lang/String;
      //   344: iconst_2
      //   345: new 23	java/lang/StringBuilder
      //   348: dup
      //   349: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   352: ldc 188
      //   354: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   357: aload 6
      //   359: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   362: ldc 190
      //   364: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   367: bipush 253
      //   369: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   372: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   375: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   378: iconst_0
      //   379: istore_3
      //   380: goto -197 -> 183
      //   383: astore 6
      //   385: aconst_null
      //   386: astore 6
      //   388: iconst_0
      //   389: istore 4
      //   391: bipush 252
      //   393: istore_2
      //   394: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   397: ifeq +41 -> 438
      //   400: aload_0
      //   401: getfield 17	com/tencent/mobileqq/activity/ChatActivityUtils$a:TAG	Ljava/lang/String;
      //   404: iconst_2
      //   405: new 23	java/lang/StringBuilder
      //   408: dup
      //   409: invokespecial 24	java/lang/StringBuilder:<init>	()V
      //   412: ldc 188
      //   414: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   417: aload 6
      //   419: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   422: ldc 190
      //   424: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   427: bipush 252
      //   429: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   432: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   435: invokestatic 186	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
      //   438: iconst_0
      //   439: istore_3
      //   440: goto -257 -> 183
      //   443: astore 7
      //   445: iconst_0
      //   446: istore 4
      //   448: goto -57 -> 391
      //   451: astore 7
      //   453: goto -62 -> 391
      //   456: astore 7
      //   458: iconst_0
      //   459: istore 4
      //   461: goto -130 -> 331
      //   464: astore 7
      //   466: goto -135 -> 331
      //   469: iconst_0
      //   470: istore 4
      //   472: iconst_0
      //   473: istore_3
      //   474: goto -291 -> 183
      //   477: iconst_0
      //   478: istore_3
      //   479: iconst_0
      //   480: istore 4
      //   482: goto -299 -> 183
      //   485: iconst_0
      //   486: istore_3
      //   487: iconst_0
      //   488: istore 4
      //   490: aconst_null
      //   491: astore_1
      //   492: goto -309 -> 183
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	495	0	this	a
      //   0	495	1	paramjlr	jlr
      //   5	389	2	i	int
      //   179	308	3	j	int
      //   169	320	4	k	int
      //   1	180	5	m	int
      //   45	71	6	localObject1	Object
      //   323	1	6	localJSONException1	JSONException
      //   326	32	6	str1	String
      //   383	1	6	localException1	Exception
      //   386	32	6	str2	String
      //   99	73	7	localObject2	Object
      //   443	1	7	localException2	Exception
      //   451	1	7	localException3	Exception
      //   456	1	7	localJSONException2	JSONException
      //   464	1	7	localJSONException3	JSONException
      //   132	30	8	str3	String
      // Exception table:
      //   from	to	target	type
      //   16	33	268	java/lang/Exception
      //   37	88	323	org/json/JSONException
      //   92	101	323	org/json/JSONException
      //   106	115	323	org/json/JSONException
      //   37	88	383	java/lang/Exception
      //   92	101	383	java/lang/Exception
      //   106	115	383	java/lang/Exception
      //   115	171	443	java/lang/Exception
      //   171	180	451	java/lang/Exception
      //   115	171	456	org/json/JSONException
      //   171	180	464	org/json/JSONException
    }
  }
  
  public static abstract interface b
  {
    public abstract void bD(int paramInt1, int paramInt2);
  }
  
  public static class d
  {
    public String MP;
    public boolean aTF;
    public boolean aTG;
    public boolean aTH;
    public boolean aTI;
    public boolean aTJ;
    public String from;
    public Map<String, String> hh;
    public String name;
    public String peerUin;
    public String phoneNum;
    public int uinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils
 * JD-Core Version:    0.7.0.1
 */