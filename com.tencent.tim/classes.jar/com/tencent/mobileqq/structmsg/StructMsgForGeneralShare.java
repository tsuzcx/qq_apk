package com.tencent.mobileqq.structmsg;

import abdi;
import abdy.a;
import abhh;
import acfp;
import acie;
import adyp;
import aehj;
import afgc;
import aifl;
import ajcw;
import ajdg;
import ajpd;
import ajri;
import alte;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import ankt;
import anot;
import anpc;
import anqu;
import anqv;
import anqw;
import anra;
import anrd;
import anrh;
import anri;
import anrj;
import anrk;
import anrl;
import anrm;
import anro;
import anrp;
import anrq;
import ansf;
import ansl;
import ansr;
import anst;
import ansy;
import ansy.a;
import antb;
import antc;
import antd;
import ante;
import antl;
import antm;
import antn;
import antp;
import antr;
import anty;
import antz;
import anua;
import anub;
import anuc;
import anue;
import anuf;
import anug;
import anuh;
import anuj;
import anul;
import anum;
import anuv;
import anux;
import anve;
import anvf;
import aobw;
import aofk;
import aprg;
import apuh;
import aqfr;
import aqft;
import aqgb;
import aqgo;
import aqgv;
import aqhv;
import aqik;
import aurr;
import avpw;
import avpw.d;
import awix;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.TroopInviteStatusFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.a;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.businessCard.data.CardOCRInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.NearbyTransitActivity;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.receipt.ReceiptMessageDetailFragment;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.BaseBusinessAlbumInfo;
import eipc.EIPCServer;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jpa;
import jqc;
import kaw;
import kbp;
import kdv;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import ntp;
import obo;
import ocp;
import org.json.JSONException;
import org.json.JSONObject;
import rpq;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import wgv;
import wis;
import wja;
import wki;
import wlz;
import ycd;
import zfr.b;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  public static final String KEY_PAY_STAT = "order_pay_state_";
  public static final String LOGO_URL_POSTFIX = ".png";
  private static String TAG = "structmsg.StructMsgForGeneralShare";
  public static int clickedItemIndex;
  private static int dMl = -3;
  public static String eventId = "";
  public static String eventType;
  private static View.OnClickListener fM = new anrl();
  public static QIPCModule receiptServer;
  public static String remindBrief = "";
  public static String tips;
  public String animResId;
  public String atMembers;
  public boolean havaPayInfoInit;
  boolean isMultiVideoItem = false;
  public int mClickpositionX;
  public int mClickpositionY;
  WeakReference<Context> mContext = new WeakReference(null);
  WeakReference<LinearLayout> mExpandView = new WeakReference(null);
  public List<String> mHadPaidList = new ArrayList();
  public boolean mIsPAVideoStructMsg;
  public String mPARedPacket = "";
  public String mVipDonateStr = "";
  public String mWarningTips = "";
  public boolean needSendLongMsgWhenFailed;
  public int pobingTemplateId = 2000;
  
  static
  {
    eventType = "";
    tips = "";
  }
  
  public StructMsgForGeneralShare()
  {
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
  }
  
  public StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mNeedRound = paramBundle.getString("icon_need_round");
    Object localObject;
    int i;
    label204:
    String str1;
    String str3;
    boolean bool;
    if (this.mSourceName != null)
    {
      if (this.mSourceName.equalsIgnoreCase(acfp.m(2131715015))) {
        this.mMsgServiceID = 54;
      }
    }
    else
    {
      localObject = paramBundle.getString("new_share_service_id");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject))) {
        i = Integer.parseInt((String)localObject);
      }
      switch (i)
      {
      default: 
        this.mCreateTime = paramBundle.getString("req_create_time");
        str1 = paramBundle.getString("source_puin");
        localObject = str1;
        if (TextUtils.isEmpty(str1)) {
          localObject = "";
        }
        this.source_puin = ((String)localObject);
        this.mSourceUrl = paramBundle.getString("source_url");
        this.rijAlbumActionData = paramBundle.getString("readinjoy_gallery");
        if (TextUtils.isEmpty(this.mSourceUrl)) {
          this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
        }
        str1 = paramBundle.getString("detail_url");
        String str2 = paramBundle.getString("category");
        str3 = paramBundle.getString("video_url");
        bool = paramBundle.getBoolean("video_url_load", false);
        i = paramBundle.getInt("layout_item", 2);
        if (!TextUtils.isEmpty(str3)) {
          i = 5;
        }
        if (("web".equals(this.mMsgAction)) && ("micro_app".equals(this.mMsg_A_ActionData)))
        {
          localObject = new anuh();
          label367:
          if (TextUtils.isEmpty(str2)) {
            break label531;
          }
          anqv localanqv = anrd.a(0);
          localanqv.Vs(1);
          localanqv.Rn(str2);
          addItem(localanqv);
          if (!TextUtils.isEmpty(str3)) {
            break label498;
          }
          ((anqv)localObject).t(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
        }
        break;
      }
    }
    for (;;)
    {
      this.needSendLongMsgWhenFailed = paramBundle.getBoolean("need_send_long_msg_when_failed", false);
      addItem((anqu)localObject);
      if (this.mMsgAction == null) {
        this.mMsgAction = "web";
      }
      return;
      if (!this.mSourceName.equalsIgnoreCase(acfp.m(2131695158))) {
        break;
      }
      this.mMsgServiceID = 53;
      break;
      this.mMsgServiceID = i;
      break label204;
      localObject = anrd.a(i);
      break label367;
      label498:
      a((anqv)localObject, bool, str1, this.mContentCover, str3, this.mContentTitle, this.mContentSummary, paramBundle);
      ((anqv)localObject).dMi = 1;
      continue;
      label531:
      if ((this.mMsgServiceID == 118) && (this.mSourceName != null) && (this.mSourceName.equalsIgnoreCase(acfp.m(2131715013))))
      {
        ((anqv)localObject).f(this.mContentCover, this.mContentTitle, 0, this.mNeedRound);
      }
      else if (TextUtils.isEmpty(str3))
      {
        ((anqv)localObject).b(this.mContentCover, this.mContentTitle, this.mContentSummary, 0, this.mNeedRound);
      }
      else
      {
        a((anqv)localObject, bool, str1, this.mContentCover, str3, this.mContentTitle, this.mContentSummary, paramBundle);
        ((anqv)localObject).dMi = 0;
      }
    }
  }
  
  public StructMsgForGeneralShare(ansf paramansf)
  {
    super(paramansf);
    this.mWarningTips = paramansf.getAttribute("warningTipsContent");
    this.mPARedPacket = paramansf.getAttribute("paRedPacket");
    this.mVipDonateStr = paramansf.getAttribute("vipDonate");
    eventId = paramansf.getAttribute("eventId");
    remindBrief = paramansf.getAttribute("remindBrief");
    eventType = paramansf.getAttribute("eventType");
    this.animResId = paramansf.getAttribute("resid");
    tips = paramansf.getAttribute("tips");
    this.atMembers = paramansf.getAttribute("atmembers");
  }
  
  public static boolean HandleMiniAppJump(Context paramContext, String paramString)
  {
    if (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(paramString))
    {
      QLog.d(TAG, 2, " jump to miniApp: " + paramString);
      return com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(paramContext, paramString, 1043, null);
    }
    if ((paramString.startsWith("http://q.url.cn/url/Jump")) || (paramString.startsWith("https://q.url.cn/url/Jump"))) {
      try
      {
        paramString = aurr.getArguments(paramString.substring(paramString.indexOf("?") + 1));
        HashMap localHashMap = new HashMap();
        localHashMap.putAll(paramString);
        if (localHashMap.containsKey("url"))
        {
          paramString = (String)localHashMap.get("url");
          if (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(paramString))
          {
            QLog.d(TAG, 2, " jump to miniApp: " + paramString);
            boolean bool = com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(paramContext, paramString, 1043, null);
            return bool;
          }
        }
      }
      catch (Exception paramContext)
      {
        QLog.e(TAG, 2, "parse url failed, ", paramContext);
        return false;
      }
    }
    return false;
  }
  
  private static long a(AbsStructMsg paramAbsStructMsg, FragmentActivity paramFragmentActivity)
  {
    long l1 = paramAbsStructMsg.uniseq;
    if ((paramFragmentActivity.getIntent() != null) && (paramFragmentActivity.getIntent().hasExtra("origin_merge_structing_msg_uniseq")))
    {
      long l2 = paramFragmentActivity.getIntent().getLongExtra("origin_merge_structing_msg_uniseq", -1L);
      if (l2 > 0L) {
        return l2;
      }
    }
    return l1;
  }
  
  private void a(Context paramContext, int paramInt, View paramView)
  {
    if (paramView == null) {}
    anqu localanqu;
    do
    {
      do
      {
        return;
        if ((paramInt <= 2) && (paramInt - 1 >= 0))
        {
          i = wja.dp2px(12.0F, paramContext.getResources());
          j = paramView.getPaddingBottom();
          int k = paramView.getPaddingLeft();
          int m = paramView.getPaddingRight();
          localanqu = getItemByIndex(paramInt - 1);
          if (((localanqu instanceof anug)) && (((anug)localanqu).rz.size() == 1) && ((((anug)localanqu).rz.get(0) instanceof anst)) && (paramInt - 2 >= 0) && ((getItemByIndex(paramInt - 2) instanceof antz)) && (anua.a((anqv)getItemByIndex(paramInt - 2), paramInt - 2)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
          if (((localanqu instanceof antz)) && ((anua.a((anqv)localanqu, paramInt - 1)) || (this.isMultiVideoItem)))
          {
            paramView.setPadding(k, i, m, j);
            return;
          }
        }
      } while (paramInt != getItemCount() - 1);
      localanqu = getItemByIndex(0);
    } while ((!(localanqu instanceof antz)) || ((!anua.a((anqv)localanqu, 0)) && (!this.isMultiVideoItem)));
    paramInt = wja.dp2px(12.0F, paramContext.getResources());
    int i = paramView.getPaddingLeft();
    int j = paramView.getPaddingRight();
    paramView.setPadding(i, paramView.getPaddingTop(), j, paramInt);
  }
  
  private void a(View paramView, Resources paramResources, Bundle paramBundle)
  {
    if ((paramView == null) || (paramResources == null)) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    int i;
    if (localObject == null)
    {
      localObject = new LinearLayout.LayoutParams(BaseChatItemLayout.bOj, -2);
      if (hasFlag(4))
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        if (paramBundle.getInt("accostType") != AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
          break label129;
        }
        i = 1;
        label64:
        if ((i == 0) || (!hasFlag(4))) {
          paramView.setBackgroundResource(2130838395);
        }
      }
      if (this.mMsgServiceID != 76) {
        break label135;
      }
      ((ViewGroup.LayoutParams)localObject).width = -1;
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.bOj;
      ((ViewGroup.LayoutParams)localObject).height = -2;
      break;
      label129:
      i = 0;
      break label64;
      label135:
      if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156))
      {
        ((ViewGroup.LayoutParams)localObject).width = (BaseChatItemLayout.bOj + wja.dp2px(10.0F, paramResources));
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += wja.dp2px(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID == 114) || (this.mMsgServiceID == 116))
      {
        ((ViewGroup.LayoutParams)localObject).width = BaseChatItemLayout.bOj;
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          ((ViewGroup.LayoutParams)localObject).width += wja.dp2px(18.0F, paramResources);
        }
        paramView.setBackgroundDrawable(null);
        if (this.mMsgServiceID == 116)
        {
          paramResources = paramView.findViewById(2131365477);
          if (paramResources != null)
          {
            i = paramResources.getHeight();
            int j = ((ViewGroup.LayoutParams)localObject).width;
            if (j > 2.1312D * i)
            {
              i = (int)(j / 1.776D);
              paramBundle = paramResources.getLayoutParams();
              paramBundle.height = i;
              paramResources.setLayoutParams(paramBundle);
            }
          }
        }
        else if (this.mMsgServiceID == 114)
        {
          paramResources = paramView.findViewById(2131365477);
          if (paramResources != null)
          {
            paramBundle = paramResources.getLayoutParams();
            if (ankt.SCREEN_WIDTH > 1280) {}
            for (paramBundle.height = wja.dp2px(144.0F, paramResources.getResources());; paramBundle.height = wja.dp2px(112.0F, paramResources.getResources()))
            {
              paramResources.setLayoutParams(paramBundle);
              break;
            }
          }
        }
      }
      else if (this.mMsgServiceID == 98)
      {
        ((ViewGroup.LayoutParams)localObject).width = Math.min(BaseChatItemLayout.bOj + wja.dp2px(10.0F, paramResources), wja.dp2px(206.0F, paramResources));
        paramView.setBackgroundDrawable(null);
      }
      else if (this.mMsgServiceID == 91)
      {
        ((ViewGroup.LayoutParams)localObject).width = -1;
        paramView.setBackgroundResource(2130838395);
      }
      else if (this.mMsgServiceID == 97)
      {
        ((ViewGroup.LayoutParams)localObject).width = -2;
        paramView.setBackgroundDrawable(null);
      }
      else if ((this.mMsgServiceID == 106) || (this.mMsgServiceID == 107))
      {
        ((ViewGroup.LayoutParams)localObject).width = -2;
        paramView.setBackgroundDrawable(null);
      }
    }
  }
  
  private void a(anqv paramanqv, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("VINFO");
    String str2 = paramBundle.getString("TINFO");
    int i = paramBundle.getInt("PREVIEW_VIDEO_TIME", 0);
    int j = paramBundle.getInt("PREVIEW_START_POSI", 0);
    int k = paramBundle.getInt("PREVIEW_VIDEO_WIDTH", 0);
    int m = paramBundle.getInt("PREVIEW_VIDEO_HEIGHT", 0);
    int n = paramBundle.getInt("FULL_VIDEO_TIME", 0);
    String str3 = paramBundle.getString("ACCOUNT_UIN");
    String str4 = paramBundle.getString("ACCOUNT_NAME");
    String str5 = paramBundle.getString("ARTICLE_ID");
    int i1 = paramBundle.getInt("TYPE", 0);
    int i2 = paramBundle.getInt("VIDEO_FEED_TYPE", 0);
    long l = paramBundle.getLong("VIDEO_FEED_ID", 0L);
    if (obo.ek(i1)) {}
    for (paramString2 = new anvf(paramString2, i1, str1, str2, paramString5, i, j, k, m, n, str3, str4, str5, i2, l);; paramString2 = new anvf(paramString2, paramString3, paramBoolean))
    {
      paramString2.e = this;
      paramString2.e.mMsgUrl = paramString1;
      paramanqv.a(paramString2);
      paramanqv.a(new StructMsgItemTitle(paramString4));
      return;
    }
  }
  
  public static void dealMsgBeforeClick(StructMsgForGeneralShare paramStructMsgForGeneralShare, ChatMessage paramChatMessage)
  {
    if ((paramStructMsgForGeneralShare == null) || (paramChatMessage == null)) {}
    do
    {
      return;
      if ((paramStructMsgForGeneralShare.mMsgServiceID == 14) && (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsg_A_ActionData)) && (!paramStructMsgForGeneralShare.mMsg_A_ActionData.contains("&referee="))) {
        paramStructMsgForGeneralShare.mMsg_A_ActionData = String.format("%s&referee=%s", new Object[] { paramStructMsgForGeneralShare.mMsg_A_ActionData, paramChatMessage.senderuin });
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, String.format("dealMsgBeforeClick service_id:%s, data:%s, frd_uin:%s, sender_uin:%s", new Object[] { Integer.valueOf(paramStructMsgForGeneralShare.mMsgServiceID), paramStructMsgForGeneralShare.mMsg_A_ActionData, paramChatMessage.frienduin, paramChatMessage.senderuin }));
  }
  
  public static String getCoverForChatHistory(anqu paramanqu)
  {
    if ((paramanqu instanceof ansr)) {
      return ((ansr)paramanqu).aNt;
    }
    return null;
  }
  
  static String getResponseRedirectLocation(String paramString)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setInstanceFollowRedirects(false);
      paramString.setRequestMethod("GET");
      paramString.setConnectTimeout(3000);
      paramString.connect();
      paramString = paramString.getHeaderField("location");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "getResponseRedirectLocation  location = " + paramString);
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getResponseRedirectLocation  MalformedURLException ", paramString);
        }
        paramString = null;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getResponseRedirectLocation  IOException ", paramString);
        }
        paramString = null;
      }
    }
  }
  
  public static String getSummary(anqu paramanqu)
  {
    if ((paramanqu instanceof anux)) {
      return ((anux)paramanqu).text;
    }
    return null;
  }
  
  public static String getTitleForChatHistory(anqu paramanqu)
  {
    if ((paramanqu instanceof anqw)) {
      return ((anqw)paramanqu).text;
    }
    return null;
  }
  
  static boolean handleNearbyPublicAccountMsg(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare)
  {
    bool2 = false;
    bool1 = bool2;
    String str1;
    String str2;
    if (paramStructMsgForGeneralShare.mMsgBrief.contains(acfp.m(2131715011)))
    {
      str1 = getResponseRedirectLocation(paramStructMsgForGeneralShare.mMsgUrl);
      bool1 = bool2;
      if (str1 != null)
      {
        bool1 = bool2;
        if (str1.contains("find_school_mate_guide"))
        {
          int i = str1.indexOf("find_school_mate_guide");
          bool1 = bool2;
          if (i > 0) {
            str2 = str1.substring(i + "find_school_mate_guide".length() + 1);
          }
        }
      }
    }
    try
    {
      str2 = URLDecoder.decode(str2, "UTF-8");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "handleNearbyPublicAccountMsg find shoolmate msg clicked, url =  " + str1 + ",schema = " + str2);
      }
      paramQQAppInterface = aqik.c(paramQQAppInterface, paramContext, str2);
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.ace();
        bool1 = true;
      }
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "handleNearbyPublicAccountMsg  result = " + bool1 + ",msg.mMsgBrief = " + paramStructMsgForGeneralShare.mMsgBrief);
    }
    return bool1;
  }
  
  public static void onClickEvent(QQAppInterface paramQQAppInterface, Context paramContext, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView, a parama)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof StructingMsgItemBuilder.a))) {
      localObject1 = ((StructingMsgItemBuilder.a)localObject1).mMessage;
    }
    for (;;)
    {
      paramStructMsgForGeneralShare.uniseq = ((ChatMessage)localObject1).uniseq;
      paramStructMsgForGeneralShare.uin = ((ChatMessage)localObject1).frienduin;
      paramStructMsgForGeneralShare.uinType = ((ChatMessage)localObject1).istroop;
      paramStructMsgForGeneralShare.currentAccountUin = ((ChatMessage)localObject1).selfuin;
      paramStructMsgForGeneralShare.messageVersion = ((ChatMessage)localObject1).versionCode;
      if (!"web".equals(paramStructMsgForGeneralShare.mMsgAction)) {
        break label2310;
      }
      if (!abdi.ji(paramStructMsgForGeneralShare.mMsgUrl)) {
        break;
      }
      abdi.a(paramContext, paramQQAppInterface, 4);
      do
      {
        return;
        if ((localObject1 != null) && ((localObject1 instanceof abdy.a)))
        {
          localObject1 = (ChatMessage)((abdy.a)localObject1).entity;
          break;
        }
        if ((localObject1 != null) && ((localObject1 instanceof zfr.b)))
        {
          localObject1 = (ChatMessage)((zfr.b)localObject1).entity;
          break;
        }
      } while (!(localObject1 instanceof MessageForStructing));
      localObject1 = (MessageForStructing)localObject1;
    }
    Object localObject3;
    if (TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData))
    {
      paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData;
      localObject3 = paramStructMsgForGeneralShare.rijAlbumActionData;
      if ((TextUtils.isEmpty(paramView)) || ((paramStructMsgForGeneralShare.mMsgServiceID != 151) && (paramStructMsgForGeneralShare.mMsgServiceID != 156))) {
        break label463;
      }
      paramContext = aqik.c(paramQQAppInterface, paramContext, paramView);
      if (paramContext == null) {
        break label4012;
      }
      paramContext.ace();
      bool1 = true;
    }
    for (;;)
    {
      int i;
      label266:
      label302:
      label463:
      int k;
      label1051:
      Object localObject4;
      Bundle localBundle;
      String[] arrayOfString2;
      if (bool1)
      {
        i = 1;
        if (paramStructMsgForGeneralShare.mMsgServiceID == 91)
        {
          anot.a(paramQQAppInterface, "dc00898", "", "", "0X8007758", "0X8007758", 0, 0, "", "", "", "");
          anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
          paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(anqu.nH(paramStructMsgForGeneralShare.mMsgUrl));
          anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
          return;
          paramView = paramStructMsgForGeneralShare.mMsgActionData;
          break;
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).startsWith("mqqapi://readinjoy/openatlas")))
          {
            paramContext = aqik.c(paramQQAppInterface, paramContext, (String)localObject3);
            if (paramContext != null) {
              paramContext.ace();
            }
            for (bool1 = true;; bool1 = false)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handle readinjoy gallery jump rijAlbumActionData = " + (String)localObject3);
              }
              break;
              parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("mqqapi://dating/")))
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "handle dating jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl);
            }
            paramView = new Intent(paramContext, QQBrowserActivity.class);
            paramView.putExtra("url", paramStructMsgForGeneralShare.mMsgUrl);
            paramContext.startActivity(paramView);
            bool1 = true;
            continue;
          }
          if ((!TextUtils.isEmpty(paramView)) && ((paramStructMsgForGeneralShare.mMsgServiceID == 65) || (paramStructMsgForGeneralShare.mMsgServiceID == 69)))
          {
            parama = new Intent(paramContext, NearbyTransitActivity.class);
            parama.putExtra("action", 1);
            parama.putExtra("hotnamecode", paramView);
            parama.putExtra("enter_time", System.currentTimeMillis());
            paramContext.startActivity(parama);
            bool1 = true;
            continue;
          }
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("story:")))
          {
            paramContext = aqik.c(paramQQAppInterface, paramContext, paramView.substring("story:".length()));
            if (paramContext != null) {
              paramContext.ace();
            }
            for (bool2 = true;; bool2 = false)
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(TAG + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump actionData = " + paramView);
              bool1 = bool2;
              break;
              parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
          if (paramStructMsgForGeneralShare.mMsgServiceID == 60)
          {
            parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            bool1 = false;
            continue;
          }
          if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://jq.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://jq.qq.com"))))
          {
            parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            bool1 = false;
            continue;
          }
          if ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) && ((paramStructMsgForGeneralShare.mMsgUrl.startsWith("http://now.qq.com")) || (paramStructMsgForGeneralShare.mMsgUrl.startsWith("https://now.qq.com"))))
          {
            if ((paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/huayang/jiaoyou/share.html")) || (paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/huayang/jiaoyou/share.html")))
            {
              k = 1;
              if ((!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/index.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("http://now.qq.com/h5/story.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/index.html")) && (!paramStructMsgForGeneralShare.mMsgUrl.contains("https://now.qq.com/h5/story.html")) && (k == 0)) {
                break label1172;
              }
              bool3 = true;
            }
            for (;;)
            {
              if (bool3)
              {
                localObject4 = paramStructMsgForGeneralShare.mMsgUrl.substring(paramStructMsgForGeneralShare.mMsgUrl.indexOf("?") + 1);
                String[] arrayOfString1 = ((String)localObject4).split("&");
                localBundle = new Bundle();
                localBundle.putString("url", paramStructMsgForGeneralShare.mMsgUrl);
                localObject1 = "";
                i = 0;
                localObject3 = "0";
                int m = 0;
                for (;;)
                {
                  if (m < arrayOfString1.length)
                  {
                    arrayOfString2 = arrayOfString1[m].split("=");
                    if (arrayOfString2.length != 2)
                    {
                      paramView = (View)localObject3;
                      label1154:
                      m += 1;
                      localObject3 = paramView;
                      continue;
                      k = 0;
                      break;
                      label1172:
                      bool3 = false;
                      break label1051;
                    }
                    paramView = (View)localObject3;
                  }
                }
              }
            }
          }
        }
      }
      label2310:
      label4006:
      label4009:
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              for (;;)
              {
                if ("roomid".equals(arrayOfString2[0])) {
                  paramView = arrayOfString2[1];
                }
                localObject3 = paramView;
                if (!"first".equals(arrayOfString2[0])) {
                  break label4006;
                }
                localObject3 = paramView;
                int j = Integer.parseInt(arrayOfString2[1]);
                i = j;
                localObject3 = localObject1;
                try
                {
                  if ("sharefrom".equals(arrayOfString2[0]))
                  {
                    localObject3 = arrayOfString2[1];
                    localObject1 = localObject3;
                    localBundle.putString("from", (String)localObject3);
                  }
                }
                catch (NumberFormatException localNumberFormatException2) {}
                try
                {
                  if (TextUtils.isEmpty((CharSequence)localObject3)) {
                    break label4009;
                  }
                  j = aifl.dm((String)localObject3);
                  i = j;
                  j = i;
                  if (i == 0) {
                    j = 2;
                  }
                  i = j;
                  localObject1 = localObject3;
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  localObject2 = localNumberFormatException2;
                }
              }
              try
              {
                paramView = new StringBuilder((String)localObject4);
                if (!((String)localObject4).contains("first=")) {
                  paramView.append("&first=").append(i);
                }
                paramView.append("&fromid=share_msg_").append((String)localObject1);
                paramView.append("&startsrc=share_msg_").append((String)localObject1);
                if (k != 0) {
                  paramView.append("&msgurl=").append(aqgo.encodeToString(paramStructMsgForGeneralShare.mMsgUrl.getBytes(), 0));
                }
                if (0L != Long.parseLong((String)localObject3)) {
                  continue;
                }
                bool1 = parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
                bool2 = bool1;
              }
              catch (NumberFormatException paramContext)
              {
                parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
                continue;
              }
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(TAG + "Q.qqstory.TAG_NOW_ENTRANCE_ACTION_CONFIG", 2, "handle now jump .msg.mMsgUrl = " + paramStructMsgForGeneralShare.mMsgUrl + "|isUrlInWhileList:" + bool3);
              bool1 = bool2;
            }
            catch (NumberFormatException paramView)
            {
              paramView = localNumberFormatException2;
            }
            paramView = "nowmqqapi://now/openroom?" + paramView.toString();
            localObject1 = new Intent(paramContext, JumpActivity.class);
            ((Intent)localObject1).setData(Uri.parse(paramView));
            ((Intent)localObject1).putExtra("big_brother_source_key", "biz_src_jc_aio");
            paramContext.startActivity((Intent)localObject1);
            continue;
            bool2 = parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            continue;
            if ((TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgUrl)) || (!paramStructMsgForGeneralShare.mMsgUrl.startsWith("mqqapi://qsubscribe"))) {
              continue;
            }
            try
            {
              paramView = new Intent(paramContext, JumpActivity.class);
              paramView.setData(Uri.parse(paramStructMsgForGeneralShare.mMsgUrl));
              paramView.putExtra("from", "from_aio");
              paramContext.startActivity(paramView);
              bool1 = bool3;
            }
            catch (Throwable paramContext)
            {
              QLog.e(TAG, 2, "jump by msg.mMsgUrl error, url =  " + QLog.getStackTraceString(paramContext));
              bool1 = bool3;
            }
          }
          break;
          if ((!TextUtils.isEmpty(paramView)) && (paramView.startsWith("apollo:")))
          {
            paramView = paramStructMsgForGeneralShare.mMsgUrl.split("\\?");
            if ((paramView.length == 2) && (abhh.aV(paramContext)))
            {
              paramView = paramView[1];
              paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mqqapi://cmshow/apollo_action?" + paramView)));
              bool1 = true;
              break;
            }
            bool1 = false;
            continue;
          }
          if (((ChatMessage)localObject1).istroop == 1)
          {
            bool1 = parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            break;
          }
          if (paramStructMsgForGeneralShare.hasFlag(16))
          {
            paramView = paramStructMsgForGeneralShare.mMsgUrl;
            paramContext = paramView;
            if (paramView != null)
            {
              localObject3 = new StringBuilder().append(paramView);
              if (paramView.indexOf('?') != -1)
              {
                paramContext = "&";
                paramContext = ((StringBuilder)localObject3).append(paramContext).append("f_hbType=");
                if (((ChatMessage)localObject1).istroop != 1) {
                  continue;
                }
                i = 1;
                paramContext = i + "&f_hbUin=" + ((ChatMessage)localObject1).frienduin;
              }
            }
            else
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("PortalManager", 4, paramContext);
              }
              bool1 = parama.clickWebMsg(paramContext);
              break;
            }
            paramContext = "?";
            continue;
            i = 2;
            continue;
          }
          if ((paramStructMsgForGeneralShare.mMsgServiceID == 53) || (paramStructMsgForGeneralShare.mMsgServiceID == 54)) {
            try
            {
              if (!parama.clickPluginMsg("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=cooperation.readinjoy.ReadInJoyProxyActivity&url=" + URLEncoder.encode(paramStructMsgForGeneralShare.mMsgUrl) + "&from=" + paramStructMsgForGeneralShare.mMsgServiceID, null))
              {
                bool1 = parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
                break;
              }
              bool1 = true;
            }
            catch (Exception paramContext)
            {
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "ReadInJoyShareMsg click error, url =  " + paramStructMsgForGeneralShare.mMsgUrl);
              }
              paramContext.printStackTrace();
              bool1 = parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
            }
          }
        }
        if ((paramStructMsgForGeneralShare.mMsgServiceID == 15) && ((!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsgActionData)) || (!TextUtils.isEmpty(paramStructMsgForGeneralShare.mMsg_I_ActionData))))
        {
          parama = paramStructMsgForGeneralShare.mMsgActionData;
          paramView = parama;
          if (TextUtils.isEmpty(parama)) {
            paramView = paramStructMsgForGeneralShare.mMsg_I_ActionData;
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(paramView)) {
            break;
          }
          paramView = paramView.split(":");
          bool1 = bool3;
          if (paramView.length != 2) {
            break;
          }
          bool1 = bool3;
          if (!"group".equals(paramView[0])) {
            break;
          }
          bool1 = bool3;
          if (TextUtils.isEmpty(paramView[1])) {
            break;
          }
          apuh.a(paramContext, TroopInfoActivity.c(paramView[1], 14), 2);
          bool1 = true;
          break;
        }
        bool2 = bool1;
        if (paramStructMsgForGeneralShare.uin.equals("3242766078")) {
          bool2 = handleNearbyPublicAccountMsg(paramQQAppInterface, paramContext, paramStructMsgForGeneralShare);
        }
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = parama.clickWebMsg(paramStructMsgForGeneralShare.mMsgUrl);
        break;
        if (paramStructMsgForGeneralShare.mMsgServiceID != 97) {
          break label302;
        }
        anot.a(paramQQAppInterface, "dc00898", "", "", "0X8007ADA", "0X8007ADA", 0, 0, "", "", "", "");
        break label302;
        if ("plugin".equals(paramStructMsgForGeneralShare.mMsgAction))
        {
          if (paramStructMsgForGeneralShare.mMsgServiceID == 14) {
            dealMsgBeforeClick(paramStructMsgForGeneralShare, (ChatMessage)localObject1);
          }
          if (paramQQAppInterface != null)
          {
            bool1 = parama.clickPluginMsg(paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
            i = 0;
            if (bool1) {
              i = 1;
            }
            anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
            paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(anqu.nH(paramStructMsgForGeneralShare.mMsgUrl));
            anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
            return;
          }
          bool1 = false;
          continue;
        }
        if ("viewMultiMsg".equals(paramStructMsgForGeneralShare.mMsgAction))
        {
          localObject1 = (FragmentActivity)paramContext;
          if (((FragmentActivity)localObject1).getChatFragment() != null)
          {
            i = ((FragmentActivity)localObject1).getChatFragment().a().getCurType();
            localObject3 = ((FragmentActivity)localObject1).getChatFragment().a().oL();
            localObject4 = ((FragmentActivity)localObject1).getChatFragment().a().oN();
            parama = new Intent(paramContext, MultiForwardActivity.class);
            parama.putExtra("chat_subType", 3);
            parama.putExtra("uin", (String)localObject3);
            parama.putExtra("uintype", i);
            parama.putExtra("troop_code", (String)localObject4);
            parama.putExtra("multi_url", paramStructMsgForGeneralShare.mResid);
            parama.putExtra("multimsg_uniseq", paramStructMsgForGeneralShare.uniseq);
            parama.putExtra("origin_merge_structing_msg_uniseq", a(paramStructMsgForGeneralShare, (FragmentActivity)localObject1));
            paramView = (ViewGroup)paramView;
            if (paramView.getChildCount() > 0)
            {
              localObject1 = paramView.getChildAt(0);
              if (ViewGroup.class.isInstance(localObject1))
              {
                paramView = (ViewGroup)localObject1;
                continue;
              }
              if (!TextView.class.isInstance(localObject1)) {
                continue;
              }
              parama.putExtra("multi_title", ((TextView)localObject1).getText().toString());
            }
            paramContext.startActivity(parama);
          }
          bool1 = true;
          i = 0;
          if (bool1) {
            i = 1;
          }
          anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForGeneralShare.msgId, paramStructMsgForGeneralShare.templateIDForPortal, "", paramStructMsgForGeneralShare.mMsgUrl);
          paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForGeneralShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForGeneralShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(anqu.nH(paramStructMsgForGeneralShare.mMsgUrl));
          anot.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForGeneralShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
          return;
        }
        if ("viewFlower".equals(paramStructMsgForGeneralShare.mMsgAction))
        {
          parama.b(paramView, paramStructMsgForGeneralShare.uin);
          bool1 = bool4;
        }
        else
        {
          if ("shareBusinessCard".equals(paramStructMsgForGeneralShare.mMsgAction))
          {
            if (paramStructMsgForGeneralShare.mMsg_A_ActionData != null)
            {
              paramView = paramStructMsgForGeneralShare.mMsg_A_ActionData.split(";");
              if ((paramView != null) && (paramView.length == 3))
              {
                localObject1 = paramView[0].substring("url=".length());
                parama = paramView[1].substring("name=".length());
                paramView = paramView[2].substring("phone=".length());
                bool1 = bool4;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  continue;
                }
                localObject3 = (adyp)paramQQAppInterface.getManager(112);
                bool1 = bool4;
                if (localObject3 == null) {
                  continue;
                }
                localObject4 = ((adyp)localObject3).c((String)localObject1);
                localObject3 = new Intent(paramContext, BusinessCardEditActivity.class);
                ((Intent)localObject3).putExtra("source_activity", 2);
                if (localObject4 != null)
                {
                  ((Intent)localObject3).putExtra("cur_card_id", ((BusinessCard)localObject4).cardId);
                  if (((BusinessCard)localObject4).cardType == 1)
                  {
                    ((Intent)localObject3).putExtra("mode_type", 3);
                    ((Intent)localObject3).putExtra("is_edit_mode", false);
                    paramContext.startActivity((Intent)localObject3);
                    bool1 = bool4;
                    continue;
                  }
                  ((Intent)localObject3).putExtra("mode_type", 0);
                  continue;
                }
                localObject4 = new CardOCRInfo();
                ((CardOCRInfo)localObject4).picUrl = ((String)localObject1);
                ((CardOCRInfo)localObject4).name = parama;
                ((CardOCRInfo)localObject4).mobilesNum.add(paramView);
                ((Intent)localObject3).putExtra("mode_type", 0);
                ((Intent)localObject3).putExtra("finish_immedia", true);
                ((Intent)localObject3).putExtra("is_edit_mode", false);
                ((Intent)localObject3).putExtra("cur_ocr_info", (Parcelable)localObject4);
                continue;
              }
            }
          }
          else
          {
            if ("viewReceiptMessage".equals(paramStructMsgForGeneralShare.mMsgAction))
            {
              paramView = (FragmentActivity)paramContext;
              if (paramView.getChatFragment() != null)
              {
                parama = new Intent();
                parama.putExtra("ReceiptMessageDetailFragment.extra_msg_uni_seq", ((ChatMessage)localObject1).uniseq);
                parama.putExtra("ReceiptMessageDetailFragment.extra_res_id", paramStructMsgForGeneralShare.mResid);
                parama.putExtra("ReceiptMessageDetailFragment.extra_msg_session_info", paramView.getChatFragment().a().sessionInfo);
                parama.putExtra("ReceiptMessageDetailFragment.extra_shmsgseq", ((ChatMessage)localObject1).shmsgseq);
                parama.putExtra("ReceiptMessageDetailFragment.extra_sender_uin", ((ChatMessage)localObject1).senderuin);
                parama.putExtra("ReceiptMessageDetailFragment.extra_msg_seq", ((ChatMessage)localObject1).msgseq);
                parama.putExtra("ReceiptMessageDetailFragment.extra_msg_uid", ((ChatMessage)localObject1).msgUid);
                parama.putExtra("ReceiptMessageDetailFragment.extra_msg_time", ((ChatMessage)localObject1).time);
                parama.putExtra("ReceiptMessageDetailFragment.EXTRA_SESSION_TYPE_FROM_MESSAGE", ((ChatMessage)localObject1).istroop);
                parama.putExtra("ReceiptMessageDetailFragment.EXTRA_IS_READ", "1".equals(alte.u((MessageRecord)localObject1)));
                paramView.getChatFragment().a().bIS();
                PublicFragmentActivity.start(paramContext, parama, ReceiptMessageDetailFragment.class);
                i = paramView.getChatFragment().a().sessionInfo.cZ;
                if (i == 0)
                {
                  j = 1;
                  i = -1;
                  paramContext = "";
                  paramView = paramContext;
                  k = i;
                  if (paramStructMsgForGeneralShare.getStructMsgItemLists() == null) {
                    continue;
                  }
                  paramView = paramContext;
                  k = i;
                  if (paramStructMsgForGeneralShare.getStructMsgItemLists().size() <= 0) {
                    continue;
                  }
                  parama = (anqu)paramStructMsgForGeneralShare.getStructMsgItemLists().get(0);
                  paramView = paramContext;
                  k = i;
                  if (!(parama instanceof antp)) {
                    continue;
                  }
                  parama = ((antp)parama).rz.iterator();
                  paramView = paramContext;
                  k = i;
                  if (!parama.hasNext()) {
                    continue;
                  }
                  paramView = (anqu)parama.next();
                  k = i;
                  if ("type".equals(paramView.mTypeName))
                  {
                    k = i;
                    if ((paramView instanceof anve)) {
                      i = ((anve)paramView).type;
                    }
                  }
                }
                switch (i)
                {
                default: 
                  k = i;
                  i = k;
                  continue;
                  if (i == 3000)
                  {
                    j = 2;
                    continue;
                  }
                  j = 3;
                  break;
                case 2: 
                  paramContext = "pic";
                  break;
                case 1: 
                  paramContext = "msg";
                  break;
                case 3: 
                  paramContext = "ptt";
                  break;
                }
                if (k > -1)
                {
                  parama = ((ChatMessage)localObject1).senderuin;
                  if (!((ChatMessage)localObject1).isSend()) {
                    continue;
                  }
                  paramContext = "1";
                  anot.a(paramQQAppInterface, "CliOper", "", parama, "0x80083E9", "0x80083E9", j, 0, paramContext, "", paramView, "");
                }
              }
              bool1 = true;
              continue;
              paramContext = "2";
              continue;
            }
            if (("native".equals(paramStructMsgForGeneralShare.mMsgAction)) && (paramStructMsgForGeneralShare.mMsgServiceID == 128) && (paramStructMsgForGeneralShare.message != null) && (paramStructMsgForGeneralShare.mDatas != null))
            {
              parama = paramStructMsgForGeneralShare.mDatas.optString("groupcode");
              localObject1 = paramStructMsgForGeneralShare.mDatas.optString("groupname");
              if (paramStructMsgForGeneralShare.message.isSend())
              {
                paramView = paramStructMsgForGeneralShare.message.frienduin;
                TroopInviteStatusFragment.a(paramQQAppInterface, paramContext, parama, (String)localObject1, paramView, Long.valueOf(paramStructMsgForGeneralShare.mDatas.optString("msgseq")).longValue(), paramStructMsgForGeneralShare.message.senderuin, aqgv.d(paramQQAppInterface, paramStructMsgForGeneralShare.message.senderuin, 0));
                aqfr.b("Grp_AIO", "invite", "send_clk", 0, 0, new String[0]);
                bool1 = true;
                continue;
              }
              paramView = paramStructMsgForGeneralShare.message.selfuin;
              continue;
            }
            bool1 = parama.i(paramStructMsgForGeneralShare.mMsgAction, paramStructMsgForGeneralShare.mMsgUrl, paramStructMsgForGeneralShare.mMsgActionData, paramStructMsgForGeneralShare.mMsg_A_ActionData);
            continue;
            break label1154;
            break label1154;
            break label1154;
          }
          Object localObject2 = "";
          parama = "";
          paramView = "";
          continue;
          i = 0;
          break label266;
        }
      }
      label4012:
      bool1 = false;
    }
  }
  
  public static void unRegisterQIPC()
  {
    if (receiptServer != null)
    {
      QIPCServerHelper.getInstance().getServer().unRegisterModule(receiptServer);
      receiptServer = null;
    }
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (StructMsgForGeneralShare)paramObject;
    return getLayoutStr().equals(paramObject.getLayoutStr());
  }
  
  public View getAdSourceView(Context paramContext, View paramView)
  {
    if (!this.mHasAdSource) {
      localObject1 = null;
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = paramView;
      } while (paramView != null);
      paramView = new TextView(paramContext);
      localObject1 = paramView;
    } while (new kdv().a(paramContext, this.message, paramView, this.mAdSourceMenu));
    Object localObject1 = paramContext.getResources();
    paramView.setText(this.mAdSourceName);
    paramView.setSingleLine(true);
    paramView.setGravity(17);
    paramView.setEllipsize(TextUtils.TruncateAt.END);
    paramView.setTextColor(Color.rgb(187, 187, 187));
    paramView.setTextSize(2, 12.0F);
    paramView.setBackgroundResource(2130847974);
    if (!TextUtils.isEmpty(this.mSourceIcon)) {}
    Object localObject2 = paramContext.getResources().getDrawable(2130847977);
    ((Drawable)localObject2).setBounds(0, 0, 24, 16);
    paramView.setCompoundDrawables(null, null, (Drawable)localObject2, null);
    int i = rpq.dip2px(paramContext, 6.0F);
    paramView.setPadding(i, 0, i, 0);
    paramView.setCompoundDrawablePadding(rpq.dip2px(paramContext, 2.0F));
    localObject2 = LayoutInflater.from(paramContext).inflate(2131559776, null);
    PopupWindow localPopupWindow = new PopupWindow((View)localObject2, -1, -2, true);
    localPopupWindow.setTouchable(true);
    localPopupWindow.setOutsideTouchable(true);
    paramView.setOnClickListener(new anrm(this, paramContext, (Resources)localObject1, localPopupWindow));
    ((View)localObject2).findViewById(2131365702).setOnClickListener(new anro(this, localPopupWindow, paramContext));
    ((View)localObject2).findViewById(2131367083).setOnClickListener(new anrp(this, paramContext, localPopupWindow));
    return paramView;
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156)) {
      localStringBuffer.append("StructMsgItemLayoutNew2");
    }
    for (;;)
    {
      localStringBuffer.append(this.mFlag & 0x4);
      return localStringBuffer.toString();
      if (this.mStructMsgItemLists != null)
      {
        Iterator localIterator = this.mStructMsgItemLists.iterator();
        while (localIterator.hasNext()) {
          localStringBuffer.append(((anqu)localIterator.next()).getLayoutStr());
        }
      }
    }
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return fM;
  }
  
  public int getProgress()
  {
    anqu localanqu = findXmlNode("progress");
    if ((localanqu != null) && ((localanqu instanceof anuv))) {
      return ((anuv)localanqu).getProgress();
    }
    return -1;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    return super.getSourceView(paramContext, paramView);
  }
  
  @TargetApi(16)
  public View getView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView.getTag(2131378853) != null) || (paramView.getTag(2131375493) != null))) {}
    for (Object localObject1 = null;; localObject1 = paramView)
    {
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject2 = TAG;
        localObject3 = new StringBuilder().append("getView convertView=").append(localObject1).append(",mMsg_A_ActionData=").append(this.mMsg_A_ActionData).append(",tag=");
        if (localObject1 == null) {
          break label292;
        }
      }
      int i;
      label292:
      for (paramView = ((View)localObject1).getTag(2131379178);; paramView = null)
      {
        QLog.d((String)localObject2, 2, paramView);
        this.mContext = new WeakReference(paramContext);
        localObject2 = paramBundle;
        if (paramBundle == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("hasHeadIcon", hasFlag(4));
        ((Bundle)localObject2).putInt("serviceID", this.mMsgServiceID);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "getView(): convertView=" + localObject1 + ", args = " + ((Bundle)localObject2).toString());
        }
        i = ((Bundle)localObject2).getInt("longMsgHolderType", -1);
        if ((i != 1) && (i != 2) && (i != 3)) {
          break label304;
        }
        paramView = anul.getView(paramContext, (View)localObject1, paramwlz, (Bundle)localObject2);
        paramView.setId(2131378856);
        paramView.setTag(2131378856, this);
        if ((((Bundle)localObject2).getBoolean("isSubscript", false)) || (!hasFlag(4))) {
          break;
        }
        paramView.setBackgroundResource(2130838395);
        return paramView;
      }
      paramView.setBackgroundDrawable(null);
      return paramView;
      label304:
      if (((Bundle)localObject2).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
      for (int j = 1; this.mMsgException; j = 0)
      {
        QLog.d(TAG, 1, "struct msg has version exception! uin : " + this.uin + " msgVersion : " + this.messageVersion + " version : " + this.mVersion + " msgUniseq" + this.uniseq);
        paramContext = getVersionExceptionView(paramContext, (View)localObject1, paramwlz, (Bundle)localObject2);
        paramContext.setId(2131378856);
        paramContext.setTag(2131378856, this);
        return paramContext;
      }
      if (localObject1 == null)
      {
        paramView = super.getView(paramContext, null, paramwlz, (Bundle)localObject2);
        if (paramView == null) {
          return null;
        }
        paramBundle = null;
        if ((paramView instanceof ViewGroup)) {
          paramBundle = (ViewGroup)paramView;
        }
        if (paramBundle == null) {
          return null;
        }
        if (this.mStructMsgItemLists == null) {
          break label3333;
        }
      }
      label3333:
      for (int k = getItemCount();; k = 0)
      {
        int m;
        if (k > 0)
        {
          m = 0;
          i = 1;
          if (m < k)
          {
            localObject3 = getItemByIndex(m);
            ((anqu)localObject3).hU = new WeakReference(paramwlz);
            symbol2CharactorForSmallEmoji((anqu)localObject3);
            if ((this.uin != null) && (!this.uin.equalsIgnoreCase(((anqu)localObject3).uin))) {
              ((anqu)localObject3).uin = this.uin;
            }
            if (((anqu)localObject3).getStyle() == 0)
            {
              if (m == 0) {
                ((anqu)localObject3).Vr(1);
              }
              if (m == k - 1) {
                ((anqu)localObject3).Vr(2);
              }
            }
            if ((localObject3 instanceof anue))
            {
              paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
              label615:
              if ((m + 2 < k) && (paramView != null))
              {
                localObject1 = getItemByIndex(m + 2);
                if ((((anqv)localObject1).rz.size() != 0) && (paramView != null) && ((((localObject1 instanceof anug)) && ((((anug)localObject1).rz.get(0) instanceof anum))) || (((localObject1 instanceof antr)) && ((((antr)localObject1).rz.get(0) instanceof ansl)))))
                {
                  localObject1 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
                  if (localObject1 != null)
                  {
                    if (!(localObject3 instanceof anug)) {
                      break label1773;
                    }
                    if (j == 0) {
                      break label1755;
                    }
                    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = wja.dp2px(11.0F, paramContext.getResources());
                    label750:
                    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  }
                }
              }
              if ((m + 1 < k) && (paramView != null) && (j != 0) && (((anqv)localObject3).rz.size() == 1) && ((((anqv)localObject3).rz.get(0) instanceof anst)))
              {
                localObject1 = getItemByIndex(m + 1);
                if ((((anqv)localObject1).rz.size() != 0) && ((localObject1 instanceof antr)) && ((((antr)localObject1).rz.get(0) instanceof ansl)))
                {
                  paramView.setPadding(2, paramView.getPaddingTop(), 2, paramView.getPaddingBottom());
                  if ((paramView instanceof LinearLayout))
                  {
                    localObject1 = (LinearLayout.LayoutParams)((LinearLayout)paramView).getChildAt(0).getLayoutParams();
                    if (localObject1 != null)
                    {
                      ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
                      ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
                    }
                  }
                }
              }
              if (paramView == null) {
                break label1812;
              }
              if ((!TextUtils.isEmpty(((anqu)localObject3).cgX)) || ((localObject3 instanceof antn)))
              {
                paramView.setTag(localObject3);
                paramView.setClickable(true);
                paramView.setOnClickListener((View.OnClickListener)localObject3);
                paramView.setOnLongClickListener(new anrh(this, paramwlz));
                paramView.setOnTouchListener(new anri(this, paramwlz));
                clickedItemIndex = 0;
              }
              if (paramView.getParent() != null)
              {
                ((ViewGroup)paramView.getParent()).removeView(paramView);
                if (QLog.isColorLevel()) {
                  QLog.e(TAG, 2, "getView itemView.getParent != null .itemName = ." + localObject3.getClass().getName());
                }
              }
              paramBundle.addView(paramView);
            }
            for (;;)
            {
              m += 1;
              break;
              if ((localObject3 instanceof anuf))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof ansy))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof antz))
              {
                if (m + 1 < k) {
                  ((antz)localObject3).cJX = true;
                }
                for (this.isMultiVideoItem = true;; this.isMultiVideoItem = false)
                {
                  if (j == 0) {
                    break label1178;
                  }
                  paramView = new anua((anqv)localObject3, paramContext, m).a(paramContext, null, (Bundle)localObject2);
                  break;
                  ((antz)localObject3).cJX = false;
                }
                label1178:
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof anub))
              {
                if (j != 0)
                {
                  paramView = new anuc((anqv)localObject3, paramContext, m).a(paramContext, null, (Bundle)localObject2);
                  break label615;
                }
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof anty))
              {
                localObject1 = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                paramView = (View)localObject1;
                if (j == 0) {
                  break label3324;
                }
                a(paramContext, m, (View)localObject1);
                paramView = (View)localObject1;
                break label615;
              }
              if ((localObject3 instanceof antb))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof antc))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof antd))
              {
                if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156))
                {
                  paramView = new anuj();
                  paramView.e = this;
                  paramView.hU = new WeakReference(paramwlz);
                  paramView = paramView.a(paramContext, null, (Bundle)localObject2);
                  i = 0;
                  break label615;
                }
                if ((this.mDatas == null) || ((this.message != null) && (!TextUtils.isEmpty(this.message.senderuin)))) {}
                for (;;)
                {
                  try
                  {
                    this.mDatas.put("senderuin", this.message.senderuin);
                    localObject1 = this.mDatas;
                    if (!this.message.isSend()) {
                      continue;
                    }
                    paramView = this.message.frienduin;
                    ((JSONObject)localObject1).put("invitedUin", paramView);
                  }
                  catch (JSONException paramView)
                  {
                    continue;
                    continue;
                    i = 1;
                    continue;
                  }
                  ((Bundle)localObject2).putString("extend-data-json", this.mDatas.toString());
                  localObject1 = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                  paramView = (View)localObject1;
                  if (localObject1 == null) {
                    break label3324;
                  }
                  ((View)localObject1).setTag(dMl, localObject3);
                  paramView = (View)localObject1;
                  break;
                  paramView = this.message.selfuin;
                }
              }
              if ((localObject3 instanceof ante))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                break label615;
              }
              if ((localObject3 instanceof antl))
              {
                ((Bundle)localObject2).putString("extraData", this.mExtraData);
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof antm))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof antn))
              {
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof antp))
              {
                ((anqu)localObject3).e = this;
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              if ((localObject3 instanceof anuh))
              {
                ((anqu)localObject3).e = this;
                paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
                i = 0;
                break label615;
              }
              paramView = ((anqu)localObject3).a(paramContext, null, (Bundle)localObject2);
              break label615;
              label1755:
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = wja.dp2px(16.0F, paramContext.getResources());
              break label750;
              label1773:
              if ((!(localObject3 instanceof anub)) || (anuc.a((anqv)localObject3, m))) {
                break label750;
              }
              ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = wja.dp2px(7.5F, paramContext.getResources());
              break label750;
              label1812:
              if (QLog.isDevelopLevel()) {
                QLog.e(TAG, 4, "Create item view failure by #StructMsgItemViewFactory");
              }
            }
          }
        }
        for (;;)
        {
          if (((j != 0) && (hasFlag(4))) || (this.mMsgServiceID == 91))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
            }
            paramBundle.setBackgroundResource(2130838401);
          }
          a(paramBundle, paramContext.getResources(), (Bundle)localObject2);
          for (paramContext = paramBundle;; paramContext = (Context)localObject1)
          {
            if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("v_crap_ctn", false))) {
              paramContext.getLayoutParams().width = -2;
            }
            if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("is_public_account_video_msg", false)))
            {
              this.mIsPAVideoStructMsg = true;
              if (!this.isMultiVideoItem) {
                paramContext.setBackgroundDrawable(null);
              }
              if (!hasFlag(4)) {
                paramContext.getLayoutParams().width = -2;
              }
            }
            paramContext.setId(2131378856);
            paramContext.setTag(2131378856, this);
            paramView = paramContext;
            if (i != 0) {
              break;
            }
            paramContext.setBackgroundDrawable(null);
            return paramContext;
            m = getItemCount();
            if (m <= 0) {
              break label3318;
            }
            localObject3 = (ViewGroup)localObject1;
            k = 0;
            i = 1;
            if (k < m)
            {
              anqu localanqu = getItemByIndex(k);
              localanqu.hU = new WeakReference(paramwlz);
              if ((this.uin != null) && (!this.uin.equalsIgnoreCase(localanqu.uin))) {
                localanqu.uin = this.uin;
              }
              if (localanqu.getStyle() == 0)
              {
                if (k == 0) {
                  localanqu.Vr(1);
                }
                if (k == m - 1) {
                  localanqu.Vr(2);
                }
              }
              paramBundle = ((ViewGroup)localObject3).getChildAt(k);
              if ((localanqu instanceof anue))
              {
                paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                label2143:
                if (k + 2 < m)
                {
                  paramBundle = getItemByIndex(k + 2);
                  if ((((anqv)paramBundle).rz.size() != 0) && (paramView != null) && ((((paramBundle instanceof anug)) && ((((anug)paramBundle).rz.get(0) instanceof anum))) || (((paramBundle instanceof antr)) && ((((antr)paramBundle).rz.get(0) instanceof ansl)))))
                  {
                    paramBundle = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
                    if (paramBundle != null)
                    {
                      if (!(localanqu instanceof anug)) {
                        break label3194;
                      }
                      if (j == 0) {
                        break label3176;
                      }
                      paramBundle.bottomMargin = wja.dp2px(11.0F, paramContext.getResources());
                      label2274:
                      paramView.setLayoutParams(paramBundle);
                    }
                  }
                }
                if ((k + 1 < m) && (paramView != null) && (((anqv)localanqu).rz.size() == 1) && ((((anqv)localanqu).rz.get(0) instanceof anst)))
                {
                  paramBundle = getItemByIndex(k + 1);
                  if ((((anqv)paramBundle).rz.size() != 0) && ((paramBundle instanceof antr)) && ((((antr)paramBundle).rz.get(0) instanceof ansl))) {
                    paramView.setPadding(2, paramView.getPaddingTop(), 2, paramView.getPaddingBottom());
                  }
                }
                if (paramView == null) {
                  break label3233;
                }
                if ((!TextUtils.isEmpty(localanqu.cgX)) || ((localanqu instanceof antn)))
                {
                  paramView.setTag(localanqu);
                  paramView.setClickable(true);
                  paramView.setOnClickListener(localanqu);
                  paramView.setOnLongClickListener(new anrj(this, paramwlz));
                  paramView.setOnTouchListener(new anrk(this, paramwlz));
                  clickedItemIndex = 0;
                }
              }
              for (;;)
              {
                k += 1;
                break;
                if ((localanqu instanceof anuf))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localanqu instanceof ansy))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof antz))
                {
                  if (k + 1 < m) {
                    ((antz)localanqu).cJX = true;
                  }
                  for (this.isMultiVideoItem = true;; this.isMultiVideoItem = false)
                  {
                    if (j == 0) {
                      break label2596;
                    }
                    paramView = new anua((anqv)localanqu, paramContext, k).a(paramContext, paramBundle, (Bundle)localObject2);
                    break;
                    ((antz)localanqu).cJX = false;
                  }
                  label2596:
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localanqu instanceof anub))
                {
                  if (j != 0)
                  {
                    paramView = new anuc((anqv)localanqu, paramContext, k).a(paramContext, paramBundle, (Bundle)localObject2);
                    break label2143;
                  }
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localanqu instanceof anty))
                {
                  paramBundle = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  paramView = paramBundle;
                  if (j == 0) {
                    break label3315;
                  }
                  a(paramContext, k, paramBundle);
                  paramView = paramBundle;
                  break label2143;
                }
                if ((localanqu instanceof antb))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof antc))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof antd))
                {
                  if ((this.mMsgServiceID == 83) || (this.mMsgServiceID == 108) || (this.mMsgServiceID == 114) || (this.mMsgServiceID == 116) || (this.mMsgServiceID == 151) || (this.mMsgServiceID == 156))
                  {
                    paramView = new anuj();
                    paramView.e = this;
                    paramView.hU = new WeakReference(paramwlz);
                    paramView = paramView.a(paramContext, paramBundle, (Bundle)localObject2);
                    i = 0;
                    break label2143;
                  }
                  if ((this.mDatas == null) || ((this.message != null) && (!TextUtils.isEmpty(this.message.senderuin)))) {}
                  for (;;)
                  {
                    try
                    {
                      this.mDatas.put("senderuin", this.message.senderuin);
                      JSONObject localJSONObject = this.mDatas;
                      if (!this.message.isSend()) {
                        continue;
                      }
                      paramView = this.message.frienduin;
                      localJSONObject.put("invitedUin", paramView);
                    }
                    catch (JSONException paramView)
                    {
                      continue;
                    }
                    ((Bundle)localObject2).putString("extend-data-json", this.mDatas.toString());
                    paramBundle = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                    paramView = paramBundle;
                    if (paramBundle == null) {
                      break label3315;
                    }
                    paramBundle.setTag(dMl, localanqu);
                    paramView = paramBundle;
                    break;
                    paramView = this.message.selfuin;
                  }
                }
                if ((localanqu instanceof ante))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  break label2143;
                }
                if ((localanqu instanceof antl))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof antm))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof antn))
                {
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof antp))
                {
                  localanqu.e = this;
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                if ((localanqu instanceof anuh))
                {
                  localanqu.e = this;
                  paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                  i = 0;
                  break label2143;
                }
                paramView = localanqu.a(paramContext, paramBundle, (Bundle)localObject2);
                break label2143;
                label3176:
                paramBundle.bottomMargin = wja.dp2px(16.0F, paramContext.getResources());
                break label2274;
                label3194:
                if ((!(localanqu instanceof anub)) || (anuc.a((anqv)localanqu, k))) {
                  break label2274;
                }
                paramBundle.bottomMargin = wja.dp2px(7.5F, paramContext.getResources());
                break label2274;
                label3233:
                if (QLog.isDevelopLevel()) {
                  QLog.e(TAG, 4, "Create item view failure by #StructMsgItemViewFactory");
                }
              }
            }
            if ((j != 0) && (hasFlag(4)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.subscript", 2, "StructMsgForGeneralShare use subscript structmsg bg");
              }
              ((View)localObject1).setBackgroundResource(2130838401);
            }
            a((View)localObject1, paramContext.getResources(), (Bundle)localObject2);
          }
          label3315:
          label3318:
          label3324:
          break label615;
          i = 1;
        }
      }
    }
  }
  
  public void initPay(Context paramContext, MessageRecord paramMessageRecord)
  {
    this.havaPayInfoInit = true;
    if ((paramContext == null) || (this.mStructMsgItemLists == null)) {
      label16:
      return;
    } else {
      paramContext = this.mStructMsgItemLists.iterator();
    }
    for (;;)
    {
      if (!paramContext.hasNext()) {
        break label16;
      }
      Object localObject1 = (anqu)paramContext.next();
      if (!(localObject1 instanceof antr)) {
        break;
      }
      localObject1 = (antr)localObject1;
      if (((antr)localObject1).rz == null) {
        break;
      }
      localObject1 = ((antr)localObject1).rz.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (anqu)((Iterator)localObject1).next();
        if ((localObject2 instanceof ansl))
        {
          localObject2 = (ansl)localObject2;
          if (((ansl)localObject2).ayZ()) {
            ((ansl)localObject2).a(paramMessageRecord.getExtInfoFromExtStr("order_pay_state_" + ((ansl)localObject2).cif), paramMessageRecord, this);
          }
        }
      }
    }
  }
  
  public boolean isPayMessage()
  {
    if (this.mStructMsgItemLists != null)
    {
      anqu localanqu;
      do
      {
        Iterator localIterator = this.mStructMsgItemLists.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (anqu)localIterator.next();
          } while (!(localObject instanceof antr));
          localObject = ((antr)localObject).rz.iterator();
        }
        localanqu = (anqu)((Iterator)localObject).next();
      } while ((!(localanqu instanceof ansl)) || (!((ansl)localanqu).ayZ()));
      return true;
    }
    return false;
  }
  
  protected boolean parseContentNode(ansf paramansf)
  {
    if (paramansf == null) {
      return true;
    }
    Object localObject;
    if ("item".equals(paramansf.name)) {
      localObject = paramansf.getAttribute("layout");
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          i = Integer.parseInt((String)localObject);
        }
      }
      catch (NumberFormatException paramansf)
      {
        int k;
        int j;
        i = 0;
      }
      try
      {
        k = this.mMsgServiceID;
        j = i;
        if (k == 91)
        {
          j = i;
          if (i == 21) {
            j = 25;
          }
        }
        localObject = anrd.a(j);
        if (localObject != null) {
          break;
        }
        return true;
      }
      catch (NumberFormatException paramansf)
      {
        break label89;
      }
      int i = 0;
      continue;
      label89:
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "Item layout value is " + i);
      }
      return false;
      localObject = anrd.a(paramansf.name);
    }
    ((anqu)localObject).e = this;
    if (((anqu)localObject).a(paramansf))
    {
      addItem((anqu)localObject);
      return true;
    }
    return false;
  }
  
  protected void parseMsgAttrubutes(ansf paramansf)
  {
    super.parseMsgAttrubutes(paramansf);
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    label401:
    int j;
    try
    {
      n = paramObjectInput.readInt();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "version: " + n);
      }
      this.mVersion = n;
      if (n != 1) {
        break label401;
      }
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      this.mContentLayout = paramObjectInput.readInt();
      this.mContentCover = paramObjectInput.readUTF();
      this.mContentTitle = paramObjectInput.readUTF();
      this.mContentSummary = paramObjectInput.readUTF();
      localObject1 = anrd.a(this.mContentLayout);
      ((anqv)localObject1).a(new ansr(this.mContentCover));
      ((anqv)localObject1).a(new StructMsgItemTitle(this.mContentTitle));
      ((anqv)localObject1).a(new anux(this.mContentSummary));
      addItem((anqu)localObject1);
      this.mSourceAppid = paramObjectInput.readLong();
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.mSourceAction = paramObjectInput.readUTF();
      this.mSourceActionData = paramObjectInput.readUTF();
      this.mSource_A_ActionData = paramObjectInput.readUTF();
      this.mSource_I_ActionData = paramObjectInput.readUTF();
      this.fwFlag = paramObjectInput.readInt();
    }
    catch (IOException paramObjectInput)
    {
      int n;
      Object localObject1;
      int i1;
      int i;
      while ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error")))
      {
        this.mMsgException = true;
        return;
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        this.mFlag = paramObjectInput.readInt();
        this.mResid = paramObjectInput.readUTF();
        this.mFileName = paramObjectInput.readUTF();
        this.mFileSize = paramObjectInput.readLong();
        this.mCommentText = paramObjectInput.readUTF();
        if (n >= 3)
        {
          this.mCompatibleText = paramObjectInput.readUTF();
          this.msgId = paramObjectInput.readLong();
          this.mPromotionType = paramObjectInput.readInt();
          this.mPromotionMsg = paramObjectInput.readUTF();
          this.mPromotionMenus = paramObjectInput.readUTF();
          this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
          i = 0;
          while (i < this.mStructMsgItemLists.size())
          {
            localObject1 = (anqu)this.mStructMsgItemLists.get(i);
            ((anqu)localObject1).msgId = this.msgId;
            ((anqu)localObject1).mPromotionType = this.mPromotionType;
            i += 1;
          }
          if (n >= 4)
          {
            this.dynamicMsgMergeKey = paramObjectInput.readUTF();
            this.dynamicMsgMergeIndex = paramObjectInput.readInt();
            if (n >= 5)
            {
              this.source_puin = paramObjectInput.readUTF();
              if (n >= 6)
              {
                this.mSType = paramObjectInput.readUTF();
                if (n >= 7)
                {
                  this.adverSign = paramObjectInput.readInt();
                  this.adverKey = paramObjectInput.readUTF();
                  this.index = paramObjectInput.readUTF();
                  this.index_name = paramObjectInput.readUTF();
                  this.index_type = paramObjectInput.readUTF();
                  this.rijAlbumActionData = paramObjectInput.readUTF();
                  if (n >= 8)
                  {
                    this.mArticleIds = paramObjectInput.readUTF();
                    this.mOrangeWord = paramObjectInput.readUTF();
                    this.mAlgorithmIds = paramObjectInput.readUTF();
                    this.mStrategyIds = paramObjectInput.readUTF();
                    if (n >= 9)
                    {
                      this.mExtraData = paramObjectInput.readUTF();
                      this.mCreateTime = paramObjectInput.readUTF();
                      this.mTagName = paramObjectInput.readUTF();
                      if (n >= 10)
                      {
                        eventId = paramObjectInput.readUTF();
                        remindBrief = paramObjectInput.readUTF();
                        eventType = paramObjectInput.readUTF();
                        if (n >= 11)
                        {
                          tips = paramObjectInput.readUTF();
                          if (n >= 12)
                          {
                            this.mInnerUniqIds = paramObjectInput.readUTF();
                            if (n >= 13)
                            {
                              this.mSourceThirdName = paramObjectInput.readUTF();
                              this.mQQStoryExtra = paramObjectInput.readUTF();
                              this.mNeedRound = paramObjectInput.readUTF();
                              if (n >= 14)
                              {
                                this.mQidianBulkTaskId = paramObjectInput.readUTF();
                                this.reportEventFolderStatusValue = paramObjectInput.readUTF();
                                if (n >= 15)
                                {
                                  this.forwardType = paramObjectInput.readInt();
                                  this.shareData.readExternal(paramObjectInput);
                                  if ((n >= 16) && (n >= 17))
                                  {
                                    this.mAdSourceName = paramObjectInput.readUTF();
                                    this.mCommonData = paramObjectInput.readUTF();
                                    if (n >= 18)
                                    {
                                      this.animResId = paramObjectInput.readUTF();
                                      this.atMembers = paramObjectInput.readUTF();
                                      if (n >= 19)
                                      {
                                        this.mMergeSeq = paramObjectInput.readUTF();
                                        this.mSortKey = paramObjectInput.readLong();
                                        if (n >= 21)
                                        {
                                          this.mTribeShortVideoExtra = paramObjectInput.readUTF();
                                          if (n >= 22)
                                          {
                                            this.needSendLongMsgWhenFailed = paramObjectInput.readBoolean();
                                            if (n >= 23)
                                            {
                                              this.mTSum = paramObjectInput.readInt();
                                              if (n >= 24)
                                              {
                                                localObject1 = paramObjectInput.readUTF();
                                                bool = TextUtils.isEmpty((CharSequence)localObject1);
                                                if (!bool) {}
                                                for (;;)
                                                {
                                                  try
                                                  {
                                                    this.mDatas = new JSONObject((String)localObject1);
                                                    if (n < 25) {
                                                      break;
                                                    }
                                                    this.mAdSourceMenu = paramObjectInput.readUTF();
                                                    if (n < 27) {
                                                      break;
                                                    }
                                                    this.pobingTemplateId = paramObjectInput.readInt();
                                                    if (n < 28) {
                                                      break;
                                                    }
                                                    this.mQzoneExtraMsg = paramObjectInput.readUTF();
                                                  }
                                                  catch (JSONException localJSONException)
                                                  {
                                                    this.mDatas = null;
                                                    continue;
                                                  }
                                                  this.mDatas = null;
                                                }
                                                this.mMsgException = true;
                                                continue;
                                                if (!this.mSourceName.equalsIgnoreCase(acfp.m(2131695158))) {
                                                  break;
                                                }
                                                this.mMsgServiceID = 53;
                                                return;
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
      this.mHasSource = true;
    }
    if ((!this.mHasAdSource) && (!TextUtils.isEmpty(this.mAdSourceName))) {
      this.mHasAdSource = true;
    }
    if (this.mSourceName != null) {
      if (this.mSourceName.equalsIgnoreCase(acfp.m(2131715019)))
      {
        this.mMsgServiceID = 54;
        return;
        if (n >= 2)
        {
          this.mMsgTemplateID = paramObjectInput.readInt();
          this.mMsgAction = paramObjectInput.readUTF();
          this.mMsgActionData = paramObjectInput.readUTF();
          this.mMsg_A_ActionData = paramObjectInput.readUTF();
          this.mMsg_I_ActionData = paramObjectInput.readUTF();
          this.mMsgUrl = paramObjectInput.readUTF();
          this.mMsgBrief = paramObjectInput.readUTF();
          i1 = paramObjectInput.readInt();
          j = 0;
          i = 1;
        }
      }
    }
    for (;;)
    {
      int m;
      if (j < i1)
      {
        localObject1 = paramObjectInput.readUTF();
        if ("item".equals(localObject1))
        {
          m = paramObjectInput.readInt();
          if ((m == 2) && ("micro_app".equals(this.mMsg_A_ActionData)))
          {
            localObject1 = new anuh();
            break label1676;
          }
        }
      }
      label1676:
      for (;;)
      {
        if (localObject1 != null)
        {
          ((anqu)localObject1).uin = this.uin;
          ((anqu)localObject1).e = this;
          ((anqu)localObject1).readExternal(paramObjectInput);
          Object localObject2 = (anqv)localObject1;
          if ((((anqv)localObject2).rz.size() != 1) || (!((anqu)((anqv)localObject2).rz.get(0)).mTypeName.equals("hr")))
          {
            ((anqu)localObject1).chH = String.valueOf(i);
            i += 1;
            addItem((anqu)localObject1);
            ((anqu)localObject1).b(this);
            break;
            int k = m;
            if (m == 1)
            {
              k = m;
              if ("viewMultiMsg".equalsIgnoreCase(this.mMsgAction)) {
                k = 30;
              }
            }
            localObject1 = anrd.a(k);
            break label1676;
            localObject2 = anrd.a((String)localObject1);
            localObject1 = localObject2;
            if (localObject2 == null) {
              continue;
            }
            localObject1 = localObject2;
            if (!anqv.class.isInstance(localObject2)) {
              continue;
            }
            paramObjectInput.readInt();
            localObject1 = localObject2;
            continue;
          }
        }
        boolean bool;
        return;
      }
      j += 1;
    }
  }
  
  public void report(Object paramObject)
  {
    anot.a(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, 0, "1", ForwardUtils.cy(this.uinType), this.mContentTitle, "");
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "图文曝光=0X800A62F, type=", "1", ", title=", this.mContentTitle, ", uinType=", ForwardUtils.cy(this.uinType) });
    }
    if (("2711679534".equals(this.uin)) && (this.message != null)) {
      anot.a(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "public.message.show", 0, 0, this.message.time + "", "", "", this.mMsgBrief);
    }
  }
  
  public void savePayInfo(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((this.message != null) && (localAppRuntime != null))
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        this.message.saveExtInfoToExtStr("order_pay_state_" + paramString, "" + paramInt);
        if ((paramContext instanceof FragmentActivity)) {
          ((FragmentActivity)paramContext).getChatFragment().a().a.notifyDataSetChanged();
        }
        ThreadManager.post(new StructMsgForGeneralShare.6(this, localAppRuntime), 5, null, false);
        return;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d(TAG, 4, "savePayInfo error " + paramContext.getMessage());
      }
    }
  }
  
  @Deprecated
  public void setProgress(int paramInt)
  {
    anqu localanqu = findXmlNode("progress");
    if ((localanqu != null) && ((localanqu instanceof anuv))) {
      ((anuv)localanqu).setProgress(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    anqu localanqu = findXmlNode("summary");
    if ((localanqu != null) && ((localanqu instanceof anux))) {
      ((anux)localanqu).setText(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    anqu localanqu = findXmlNode("title");
    if ((localanqu != null) && ((localanqu instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localanqu).setText(paramString);
    }
  }
  
  public void symbol2CharactorForSmallEmoji(anqu paramanqu)
  {
    if ((paramanqu == null) || (!(paramanqu instanceof antd))) {}
    label39:
    label183:
    label464:
    label470:
    label474:
    label476:
    label477:
    for (;;)
    {
      return;
      paramanqu = ((antd)paramanqu).rz;
      if ((paramanqu != null) && (paramanqu.size() != 0))
      {
        Object localObject1 = paramanqu.iterator();
        paramanqu = null;
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (anqu)((Iterator)localObject1).next();
          if (!(localObject2 instanceof anux)) {
            break label476;
          }
          paramanqu = (anux)localObject2;
        }
        for (;;)
        {
          break label39;
          if (paramanqu == null) {
            break label477;
          }
          localObject2 = paramanqu.getText();
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (this.mContext == null) || (this.mContext.get() == null) || (!(this.mContext.get() instanceof BaseActivity))) {
            break;
          }
          localObject1 = ((FragmentActivity)this.mContext.get()).getChatFragment();
          if (localObject1 != null) {
            localObject1 = ((ChatFragment)localObject1).getApp();
          }
          for (;;)
          {
            if (localObject1 == null) {
              break label474;
            }
            ajdg localajdg = (ajdg)((QQAppInterface)localObject1).getManager(14);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject2);
            int i = 0;
            int j;
            if (i < localStringBuilder.length())
            {
              j = i;
              if ('ÿ' == localStringBuilder.charAt(i))
              {
                j = i;
                if (i + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(i + 3);
                  localObject1[1] = localStringBuilder.charAt(i + 2);
                  localObject1[2] = localStringBuilder.charAt(i + 1);
                  localObject1[3] = localStringBuilder.charAt(i);
                  j = 0;
                  if (j < 4)
                  {
                    if (localObject1[j] == 'ú') {
                      localObject1[j] = 10;
                    }
                    for (;;)
                    {
                      j += 1;
                      break label272;
                      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
                      if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface))) {
                        break label470;
                      }
                      localObject1 = (QQAppInterface)localObject1;
                      break;
                      if (localObject1[j] == 'þ') {
                        localObject1[j] = 13;
                      } else if (localObject1[j] == 'ý') {
                        localObject1[j] = 20;
                      }
                    }
                  }
                  localObject1 = afgc.a((char[])localObject1);
                  localObject2 = aofk.ckA;
                  if (localajdg == null) {
                    break label464;
                  }
                }
              }
            }
            for (localObject1 = localajdg.a(Integer.toString(localObject1[0]), Integer.toString(localObject1[1]));; localObject1 = null)
            {
              if (localObject1 != null) {
                localObject2 = ((Emoticon)localObject1).character;
              }
              localStringBuilder.replace(i, i + 3, (String)localObject2);
              j = i + ((String)localObject2).length();
              i = j + 1;
              break label183;
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramanqu.setText(localStringBuilder.toString());
              return;
            }
            localObject1 = null;
          }
          break;
        }
      }
    }
  }
  
  protected void toContentXml(AbsStructMsg.a parama)
    throws IOException
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((anqu)localIterator.next()).a(parama);
    }
    if ((this.mMsgServiceID == 128) && (this.mDatas != null))
    {
      parama.startTag(null, "data");
      parama.attribute(null, "groupcode", this.mDatas.optString("groupcode"));
      parama.attribute(null, "groupname", this.mDatas.optString("groupname"));
      parama.attribute(null, "msgseq", this.mDatas.optString("msgseq"));
      parama.attribute(null, "msgtype", this.mDatas.optString("msgtype"));
      parama.endTag(null, "data");
    }
  }
  
  public void unInitPay()
  {
    this.havaPayInfoInit = false;
    this.mHadPaidList = new ArrayList();
  }
  
  public void updateCover(String paramString)
  {
    super.updateCover(paramString);
    Iterator localIterator = this.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (anqu)localIterator.next();
      if ((localObject instanceof anqv))
      {
        localObject = ((anqv)localObject).rz.iterator();
        while (((Iterator)localObject).hasNext())
        {
          anqu localanqu = (anqu)((Iterator)localObject).next();
          if ((localanqu instanceof ansr)) {
            ((ansr)localanqu).aNt = paramString;
          }
        }
      }
    }
  }
  
  public void updateTitleSummaryAndCover(String paramString1, String paramString2, String paramString3)
  {
    super.updateTitleSummaryAndCover(paramString1, paramString2, paramString3);
    Iterator localIterator = this.mStructMsgItemLists.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (anqu)localIterator.next();
      if ((localObject instanceof anqv))
      {
        localObject = ((anqv)localObject).rz.iterator();
        while (((Iterator)localObject).hasNext())
        {
          anqu localanqu = (anqu)((Iterator)localObject).next();
          if ((localanqu instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localanqu).text = paramString1;
          } else if ((localanqu instanceof anux)) {
            ((anux)localanqu).text = paramString2;
          } else if ((localanqu instanceof ansr)) {
            ((ansr)localanqu).aNt = paramString3;
          }
        }
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label180;
      }
      localObject = "";
      label57:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label188;
      }
      localObject = "";
      label74:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label196;
      }
      localObject = "";
      label91:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label204;
      }
      localObject = "";
      label108:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label212;
      }
    }
    label180:
    label188:
    label196:
    label204:
    label212:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((anqu)((Iterator)localObject).next()).writeExternal(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label57;
      localObject = this.mMsg_A_ActionData;
      break label74;
      localObject = this.mMsg_I_ActionData;
      break label91;
      localObject = this.mMsgUrl;
      break label108;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label1172;
      }
      localObject = "";
      label257:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label1180;
      }
      localObject = "";
      label274:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label1188;
      }
      localObject = "";
      label291:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label1196;
      }
      localObject = "";
      label308:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label1204;
      }
      localObject = "";
      label325:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label1212;
      }
      localObject = "";
      label342:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      if (this.mResid != null) {
        break label1220;
      }
      localObject = "";
      label379:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mFileName != null) {
        break label1228;
      }
      localObject = "";
      label396:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mFileSize);
      if (this.mCommentText != null) {
        break label1236;
      }
      localObject = "";
      label423:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label1244;
      }
      localObject = "";
      label440:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label1252;
      }
      localObject = "";
      label477:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mPromotionMenus != null) {
        break label1260;
      }
      localObject = "";
      label494:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.dynamicMsgMergeKey != null) {
        break label1268;
      }
      localObject = "";
      label521:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.dynamicMsgMergeIndex);
      if (this.source_puin != null) {
        break label1276;
      }
      localObject = "";
      label548:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSType != null) {
        break label1284;
      }
      localObject = "";
      label565:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label1292;
      }
      localObject = "";
      label592:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index != null) {
        break label1300;
      }
      localObject = "";
      label609:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_name != null) {
        break label1308;
      }
      localObject = "";
      label626:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.index_type != null) {
        break label1316;
      }
      localObject = "";
      label643:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.rijAlbumActionData != null) {
        break label1324;
      }
      localObject = "";
      label660:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mArticleIds != null) {
        break label1332;
      }
      localObject = "";
      label677:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mOrangeWord != null) {
        break label1340;
      }
      localObject = "";
      label694:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mAlgorithmIds != null) {
        break label1348;
      }
      localObject = "";
      label711:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mStrategyIds != null) {
        break label1356;
      }
      localObject = "";
      label728:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mExtraData != null) {
        break label1364;
      }
      localObject = "";
      label745:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCreateTime != null) {
        break label1372;
      }
      localObject = "";
      label762:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mTagName != null) {
        break label1380;
      }
      localObject = "";
      label779:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventId != null) {
        break label1388;
      }
      localObject = "";
      label795:
      paramObjectOutput.writeUTF((String)localObject);
      if (remindBrief != null) {
        break label1395;
      }
      localObject = "";
      label811:
      paramObjectOutput.writeUTF((String)localObject);
      if (eventType != null) {
        break label1402;
      }
      localObject = "";
      label827:
      paramObjectOutput.writeUTF((String)localObject);
      if (tips != null) {
        break label1409;
      }
      localObject = "";
      label843:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mInnerUniqIds != null) {
        break label1416;
      }
      localObject = "";
      label860:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceThirdName != null) {
        break label1424;
      }
      localObject = "";
      label877:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQQStoryExtra != null) {
        break label1432;
      }
      localObject = "";
      label894:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mNeedRound != null) {
        break label1440;
      }
      localObject = "";
      label911:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mQidianBulkTaskId != null) {
        break label1448;
      }
      localObject = "";
      label928:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.reportEventFolderStatusValue != null) {
        break label1456;
      }
      localObject = "";
      label945:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.forwardType);
      this.shareData.writeExternal(paramObjectOutput);
      if (this.mAdSourceName != null) {
        break label1464;
      }
      localObject = "";
      label980:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCommonData != null) {
        break label1472;
      }
      localObject = "";
      label997:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.animResId != null) {
        break label1480;
      }
      localObject = "";
      label1014:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.atMembers != null) {
        break label1488;
      }
      localObject = "";
      label1031:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMergeSeq != null) {
        break label1496;
      }
      localObject = "";
      label1048:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeLong(this.mSortKey);
      if (this.mTribeShortVideoExtra != null) {
        break label1504;
      }
      localObject = "";
      label1075:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeBoolean(this.needSendLongMsgWhenFailed);
      paramObjectOutput.writeInt(this.mTSum);
      if (this.mDatas != null) {
        break label1512;
      }
      localObject = "";
      label1112:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mAdSourceMenu != null) {
        break label1523;
      }
      localObject = "";
      label1129:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.pobingTemplateId);
      if (this.mQzoneExtraMsg != null) {
        break label1531;
      }
    }
    label1172:
    label1180:
    label1188:
    label1196:
    label1204:
    label1212:
    label1220:
    label1228:
    label1236:
    label1244:
    label1252:
    label1260:
    label1268:
    label1402:
    label1531:
    for (localObject = "";; localObject = this.mQzoneExtraMsg)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label257;
      localObject = this.mSourceUrl;
      break label274;
      localObject = this.mSourceAction;
      break label291;
      localObject = this.mSourceActionData;
      break label308;
      localObject = this.mSource_A_ActionData;
      break label325;
      localObject = this.mSource_I_ActionData;
      break label342;
      localObject = this.mResid;
      break label379;
      localObject = this.mFileName;
      break label396;
      localObject = this.mCommentText;
      break label423;
      localObject = this.mCompatibleText;
      break label440;
      localObject = this.mPromotionMsg;
      break label477;
      localObject = this.mPromotionMenus;
      break label494;
      localObject = this.dynamicMsgMergeKey;
      break label521;
      label1276:
      localObject = this.source_puin;
      break label548;
      localObject = this.mSType;
      break label565;
      localObject = this.adverKey;
      break label592;
      localObject = this.index;
      break label609;
      localObject = this.index_name;
      break label626;
      localObject = this.index_type;
      break label643;
      localObject = this.rijAlbumActionData;
      break label660;
      localObject = this.mArticleIds;
      break label677;
      localObject = this.mOrangeWord;
      break label694;
      localObject = this.mAlgorithmIds;
      break label711;
      localObject = this.mStrategyIds;
      break label728;
      localObject = this.mExtraData;
      break label745;
      localObject = this.mCreateTime;
      break label762;
      localObject = this.mTagName;
      break label779;
      localObject = eventId;
      break label795;
      localObject = remindBrief;
      break label811;
      localObject = eventType;
      break label827;
      localObject = tips;
      break label843;
      localObject = this.mInnerUniqIds;
      break label860;
      localObject = this.mSourceThirdName;
      break label877;
      localObject = this.mQQStoryExtra;
      break label894;
      localObject = this.mNeedRound;
      break label911;
      localObject = this.mQidianBulkTaskId;
      break label928;
      localObject = this.reportEventFolderStatusValue;
      break label945;
      localObject = this.mAdSourceName;
      break label980;
      localObject = this.mCommonData;
      break label997;
      localObject = this.animResId;
      break label1014;
      localObject = this.atMembers;
      break label1031;
      localObject = this.mMergeSeq;
      break label1048;
      localObject = this.mTribeShortVideoExtra;
      break label1075;
      localObject = this.mDatas.toString();
      break label1112;
      localObject = this.mAdSourceMenu;
      break label1129;
    }
  }
  
  public static class a
    extends anra
  {
    private String albumId;
    StructMsgForGeneralShare b;
    private String chX;
    private String chY;
    ChatMessage i;
    SessionInfo sessionInfo;
    
    public a(QQAppInterface paramQQAppInterface, View paramView, StructMsgForGeneralShare paramStructMsgForGeneralShare)
    {
      super(paramView);
      this.b = paramStructMsgForGeneralShare;
      paramQQAppInterface = paramView.getTag();
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof StructingMsgItemBuilder.a)))
      {
        paramQQAppInterface = (StructingMsgItemBuilder.a)paramQQAppInterface;
        this.i = paramQQAppInterface.mMessage;
        this.sessionInfo = paramQQAppInterface.sessionInfo;
      }
      do
      {
        return;
        if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof abdy.a)))
        {
          paramQQAppInterface = (abdy.a)paramQQAppInterface;
          this.i = ((ChatMessage)paramQQAppInterface.entity);
          this.sessionInfo = new SessionInfo();
          this.sessionInfo.aTl = this.i.frienduin;
          this.sessionInfo.cZ = this.i.istroop;
          this.sessionInfo.aTn = paramQQAppInterface.AI;
          return;
        }
      } while (!(paramQQAppInterface instanceof MessageForStructing));
      this.i = ((MessageForStructing)paramQQAppInterface);
      this.sessionInfo = new SessionInfo();
      this.sessionInfo.aTl = this.i.frienduin;
      this.sessionInfo.cZ = this.i.istroop;
    }
    
    private void dn(Bundle paramBundle)
    {
      ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.1(this, paramBundle), 5, null, false);
    }
    
    private boolean pH(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d(StructMsgForGeneralShare.access$000(), 2, "the share url is" + paramString);
        }
        if (!paramString.contains("ciphertext"))
        {
          this.albumId = null;
          this.chX = null;
          if ((paramString.startsWith("http://mobile.qzone.qq.com")) || (paramString.startsWith("https://mobile.qzone.qq.com"))) {
            try
            {
              paramString = Uri.parse(paramString);
              String str = paramString.getQueryParameter("a");
              if ("311".equals(str)) {
                return true;
              }
              if ("2".equals(str)) {
                return true;
              }
              if ("4".equals(str))
              {
                this.albumId = paramString.getQueryParameter("albumid");
                this.chX = paramString.getQueryParameter("res_uin");
                return true;
              }
            }
            catch (Exception paramString)
            {
              QLog.e(StructMsgForGeneralShare.access$000(), 1, "isNotPermissionUGC catch an exception", paramString);
            }
          }
        }
      }
      return false;
    }
    
    private boolean pI(String paramString)
    {
      this.chY = null;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("is_famous_space=1")) && (paramString.contains("qzone"))) {
        try
        {
          this.chY = Uri.parse(paramString).getQueryParameter("hostuin");
          return true;
        }
        catch (Exception paramString)
        {
          QLog.e(StructMsgForGeneralShare.access$000(), 1, "isForwardToNativeUserHome catch an exception", paramString);
          return false;
        }
      }
      return false;
    }
    
    public boolean b(View paramView, String paramString)
    {
      if ((this.b == null) || (TextUtils.isEmpty(paramString))) {}
      label44:
      Object localObject;
      label111:
      label113:
      do
      {
        return false;
        paramView = paramView.findViewById(2131372234);
        if (paramView == null)
        {
          int j;
          if (this.b.mStructMsgItemLists.size() > 0)
          {
            j = 1;
            if (!QLog.isColorLevel()) {
              break label111;
            }
            paramString = StructMsgForGeneralShare.access$000();
            localObject = new StringBuilder().append("clickViewFlower error item:");
            if (j == 0) {
              break label113;
            }
          }
          for (paramView = ((anqu)this.b.mStructMsgItemLists.get(0)).chc;; paramView = "")
          {
            QLog.i(paramString, 2, paramView);
            return false;
            j = 0;
            break label44;
            break;
          }
        }
        paramView = (ansy.a)paramView.getTag();
      } while (paramView == null);
      paramView = paramView.bundle;
      boolean bool2;
      if ((paramView != null) && (paramView.size() > 0))
      {
        localObject = paramView.getString("groupCode");
        boolean bool1 = paramView.getBoolean("isSend");
        bool2 = paramView.getBoolean("isReceive");
        if ((!bool1) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(paramString)) && (!bool2))
        {
          paramView = (HotChatManager)this.mApp.getManager(60);
          if (paramView != null) {}
          for (paramView = paramView.a(paramString);; paramView = null)
          {
            if (paramView != null) {
              ajpd.a(paramView, this.mApp, (Activity)this.mContext, 1);
            }
            return true;
          }
        }
        if (!bool1) {
          break label286;
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label273;
        }
        acie.O(this.mApp, "0X8006390");
      }
      for (;;)
      {
        return true;
        label273:
        acie.O(this.mApp, "0X80060B3");
        continue;
        label286:
        if (bool2) {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            acie.O(this.mApp, "0X8006391");
          } else {
            acie.O(this.mApp, "0X80060B4");
          }
        }
      }
    }
    
    public boolean clickPluginMsg(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickPluginMsg actionData = " + paramString1 + ", actionDataA = " + paramString2);
      }
      QQAppInterface localQQAppInterface = this.mApp;
      if (TextUtils.isEmpty(paramString2)) {}
      for (;;)
      {
        paramString1 = aqik.c(localQQAppInterface, this.mContext, paramString1);
        if (paramString1 == null) {
          break;
        }
        if ((this.b != null) && (this.b.message != null) && (aqft.rj(this.b.message.senderuin))) {
          paramString1.fj("msg_uniseq", this.b.message.senderuin);
        }
        paramString1.ace();
        if ((this.b != null) && (this.b.message != null) && (this.b.message.istroop == 1008)) {
          kaw.f(this.mApp, this.b.uin);
        }
        return true;
        paramString1 = paramString2;
      }
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralShareMsg _ACTION_PLUGIN_ mContentOnClickListener: JumpAction is null.");
      }
      return false;
    }
    
    public boolean clickWebMsg(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg url = " + paramString);
      }
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      QQAppInterface localQQAppInterface = this.mApp;
      localContext = this.mContext;
      localStructMsgForGeneralShare = this.b;
      for (;;)
      {
        try
        {
          localObject3 = localStructMsgForGeneralShare.uin;
          if (localStructMsgForGeneralShare.uinType != 1) {
            continue;
          }
          j = 2;
          str1 = Long.toString(localStructMsgForGeneralShare.mSourceAppid);
          localObject4 = Integer.toString(localStructMsgForGeneralShare.mMsgServiceID);
          if ((paramString == null) || (paramString.length() <= 150)) {
            continue;
          }
          localObject1 = paramString.substring(0, 150);
        }
        catch (Exception localException1)
        {
          String str1;
          Object localObject1;
          boolean bool;
          localException1.printStackTrace();
          continue;
          Object localObject3 = new BaseBusinessAlbumInfo();
          ((BaseBusinessAlbumInfo)localObject3).mAlbumId = this.albumId;
          try
          {
            if (TextUtils.isEmpty(this.chX)) {
              continue;
            }
            l = Long.parseLong(this.chX);
            ((BaseBusinessAlbumInfo)localObject3).mUin = l;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(StructMsgForGeneralShare.access$000(), 2, "Parsing the albumOwnUin catch a NumberFormatException : " + localNumberFormatException.getMessage());
            continue;
          }
          ((BaseBusinessAlbumInfo)localObject3).mAlbumType = 0;
          ((BaseBusinessAlbumInfo)localObject3).doR = true;
          avpw.a((Activity)localContext, localException1, (BaseBusinessAlbumInfo)localObject3, -1, paramString);
          continue;
          long l = 0L;
          continue;
          if ((!pI(paramString)) || (TextUtils.isEmpty(this.chY))) {
            continue;
          }
          paramString = avpw.d.a();
          paramString.cMP = str1;
          paramString.nickname = localNumberFormatException.getCurrentNickname();
          avpw.a((Activity)localContext, paramString, this.chY, 0, 0, 0);
          continue;
          if (!avpw.b((Activity)localContext, localException1, "biz_src_jc_aio")) {
            continue;
          }
          return true;
          if (!com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.isMiniAppScheme(paramString)) {
            continue;
          }
          com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScheme(localContext, paramString, 1210);
          return true;
          if ((!aobw.pN(paramString)) && (localStructMsgForGeneralShare.mSourceAppid != aobw.aoS)) {
            continue;
          }
          Object localObject2 = new Bundle();
          ((Bundle)localObject2).putString("url", paramString);
          ((Bundle)localObject2).putBoolean("doc_from_aio", true);
          ((Bundle)localObject2).putString("tdsourcetag", "s_qq_aiomsg");
          TeamWorkDocEditBrowserActivity.a(localContext, (Bundle)localObject2, false);
          return true;
          if ((!(localContext instanceof BaseActivity)) || (!ajcw.a((BaseActivity)localContext, (String)localObject2, localStructMsgForGeneralShare.message))) {
            continue;
          }
          return true;
          if (!StructMsgForGeneralShare.HandleMiniAppJump(localContext, (String)localObject2)) {
            continue;
          }
          return true;
          Object localObject4 = new Intent(localContext, QQBrowserDelegationActivity.class);
          ((Intent)localObject4).putExtra("param_force_internal_browser", true);
          if (!bool) {
            continue;
          }
          paramString = jpa.r(paramString, "platformId=qq_m");
          String str2 = paramString.trim();
          ((Intent)localObject4).putExtra("injectrecommend", false);
          ((Intent)localObject4).putExtra("key_isReadModeEnabled", true);
          ((Intent)localObject4).putExtra("url", str2);
          ((Intent)localObject4).putExtra("friendUin", localStructMsgForGeneralShare.uin);
          ((Intent)localObject4).putExtra("isAppShare", true);
          ((Intent)localObject4).putExtra("appShareID", l);
          ((Intent)localObject4).putExtra("uin_type", localStructMsgForGeneralShare.uinType);
          ((Intent)localObject4).putExtra("msg_id", Long.toString(localStructMsgForGeneralShare.msgId));
          ((Intent)localObject4).putExtra("puin", localStructMsgForGeneralShare.uin);
          ((Intent)localObject4).putExtra("self_uin", str1);
          if (localStructMsgForGeneralShare.message == null) {
            continue;
          }
          ((Intent)localObject4).putExtra("friend_uin", localStructMsgForGeneralShare.message.frienduin);
          ((Intent)localObject4).putExtra("fromOneCLickCLose", true);
          if ((localStructMsgForGeneralShare.message != null) && (localStructMsgForGeneralShare.message.istroop == 1008)) {
            continue;
          }
          ((Intent)localObject4).putExtra("big_brother_source_key", "biz_src_jc_aio");
          if ((TextUtils.isEmpty(str2)) || (!aqft.rj(localStructMsgForGeneralShare.uin))) {
            continue;
          }
          paramString = str2.split("&");
          if (paramString == null) {
            continue;
          }
          int j = 0;
          if (j >= paramString.length) {
            continue;
          }
          if (!paramString[j].contains("from_type")) {
            continue;
          }
          localObject3 = paramString[j].split("=");
          if ((localObject3 == null) || (localObject3.length != 2)) {
            continue;
          }
          localObject3 = localObject3[1];
          Object localObject5 = localStructMsgForGeneralShare.mMsg_I_ActionData.split(":");
          if ((localObject5 == null) || (localObject5.length != 2)) {
            continue;
          }
          localObject5 = localObject5[1];
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject5))) {
            continue;
          }
          paramString = new Bundle();
          paramString.putString("src_type", "internal");
          paramString.putString("version", "1");
          paramString.putString("callback_type", "scheme");
          paramString.putString("callback_name", "open_card");
          paramString.putString("uin", (String)localObject5);
          paramString.putString("card_type", "group");
          paramString.putString("authKey", null);
          paramString.putString("from", "qrcode");
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            continue;
          }
          paramString.putString("from_type", (String)localObject3);
          paramString.putString("jump_from", "QRJumpActivity");
          paramString = aqik.c(localNumberFormatException, localContext, Uri.parse("mqqapi://card/show_pslcard?" + jqc.b(paramString)).toString());
          if (paramString == null) {
            continue;
          }
          paramString.ace();
          return true;
          j += 1;
          continue;
          if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_layer_style", 0) != 1) {
            continue;
          }
          QLog.d(StructMsgForGeneralShare.access$000(), 1, "enable_floating_layer_style = 1");
          if (!awix.be(this.mContext, str2)) {
            continue;
          }
          return true;
          if ((TextUtils.isEmpty(str2)) || (!ocp.ez(str2)) || (!ntp.ek(str2))) {
            continue;
          }
          ntp.b(localContext, null, ntp.fd(str2), null);
          return true;
          if ((this.i == null) || (this.i.isSend()) || (this.i.istroop != 0) || (!aqft.rj(this.i.frienduin)) || (TextUtils.isEmpty(this.i.getExtInfoFromExtStr("guide_msg_cookie")))) {
            continue;
          }
          paramString = aqft.p(this.i.getExtInfoFromExtStr("guide_msg_cookie"));
          if (paramString == null) {
            continue;
          }
          localObject3 = new babyq_cookie.BabyQCookie();
          try
          {
            ((babyq_cookie.BabyQCookie)localObject3).mergeFrom(paramString);
            if (((babyq_cookie.BabyQCookie)localObject3).uint32_type.get() == 206) {
              this.mApp.b().uz("babyq_game_tribe");
            }
            ((Intent)localObject4).putExtra("source_puin", localStructMsgForGeneralShare.source_puin);
            if (localStructMsgForGeneralShare.uinType == 0)
            {
              ((Intent)localObject4).putExtra("articalChannelId", 2);
              wis.a((Intent)localObject4, localNumberFormatException, localStructMsgForGeneralShare.message);
              if ((ocp.d(localNumberFormatException, localStructMsgForGeneralShare.uin) != -1) || (str2.startsWith("http://browserApp.p.qq.com/")))
              {
                ((Intent)localObject4).setClass(localContext, PublicAccountBrowser.class);
                paramString = new Bundle();
                paramString.putString("uin", localStructMsgForGeneralShare.uin);
                if (this.sessionInfo != null)
                {
                  paramString.putInt("uin_type", this.sessionInfo.cZ);
                  paramString.putString("uin_name", this.sessionInfo.aTn);
                }
                paramString.putBoolean("switch_msg_btn", ocp.GB());
                ((Intent)localObject4).putExtras(paramString);
              }
              if (localStructMsgForGeneralShare.mMsgServiceID != 123) {
                continue;
              }
              if (localStructMsgForGeneralShare.uinType != 1) {
                continue;
              }
              bool = aehj.E(localNumberFormatException, localStructMsgForGeneralShare.uin);
              paramString = ((Intent)localObject4).getStringExtra("url");
              if ((bool) && (!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(localStructMsgForGeneralShare.uin)))
              {
                paramString = "https://ti.qq.com/honest-say/group.html?_bid=3104&_qStyle=1&_wv=9191&_nav_alpha=0&_nav_txtclr=FFFFFF&_nav_titleclr=FFFFFF&_nav_anim=true&_wwv=128&gc=$GCODE$&src_type=share&from=appstore_aio&adtag=qq_to_qq".replace("$GCODE$", ajri.encode(localStructMsgForGeneralShare.uin));
                ((Intent)localObject4).removeExtra("url");
                ((Intent)localObject4).putExtra("url", paramString);
                if (QLog.isColorLevel()) {
                  QLog.i(StructMsgForGeneralShare.access$000(), 2, "GeneralClickHandler clickWebMsg confess groupUin:" + localStructMsgForGeneralShare.uin + ",paramUrl=" + paramString);
                }
                if ((localContext instanceof FragmentActivity))
                {
                  localObject2 = ((FragmentActivity)localContext).getChatFragment();
                  if (localObject2 != null)
                  {
                    localObject3 = ((ChatFragment)localObject2).getActivity().getIntent();
                    ((Intent)localObject3).putExtra("url", paramString);
                    ((Intent)localObject3).putExtra("confess_half_screen_web", true);
                    paramString = ((ChatFragment)localObject2).a();
                    if ((paramString != null) && ((paramString instanceof TroopChatPie))) {
                      aehj.d((TroopChatPie)paramString);
                    }
                  }
                }
              }
              if (bool) {
                continue;
              }
              QQToast.a(BaseApplicationImpl.getContext(), aehj.bxu, 0).show();
              return false;
            }
          }
          catch (InvalidProtocolBufferMicroException paramString)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(StructMsgForGeneralShare.access$000(), 2, "babbyq -> sendSpecialMessage:" + paramString.getStackTrace());
            continue;
            if (localStructMsgForGeneralShare.uinType == 1)
            {
              ((Intent)localObject4).putExtra("articalChannelId", 3);
              continue;
            }
            if (localStructMsgForGeneralShare.uinType == 3000)
            {
              ((Intent)localObject4).putExtra("articalChannelId", 4);
              continue;
            }
            if (localStructMsgForGeneralShare.uinType != 1008) {
              continue;
            }
            ((Intent)localObject4).putExtra("articalChannelId", 1);
            ((Intent)localObject4).putExtra("FORCE_BLANK_SCREEN_REPORTE", true);
            ((Intent)localObject4).putExtra("big_brother_source_key", ocp.fq(localStructMsgForGeneralShare.source_puin));
            continue;
            ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.3(this, localNumberFormatException), 5, null, true);
            return true;
          }
          ThreadManager.post(new StructMsgForGeneralShare.GeneralClickHandler.4(this, localNumberFormatException), 5, null, true);
          if ((localStructMsgForGeneralShare.mMsgServiceID != 14) || (this.sessionInfo == null) || (this.sessionInfo.cZ != 1)) {
            continue;
          }
          paramString = aprg.a(localStructMsgForGeneralShare, this.sessionInfo.aTl);
          if (TextUtils.isEmpty(paramString)) {
            continue;
          }
          ((Intent)localObject4).removeExtra("url");
          ((Intent)localObject4).putExtra("url", paramString);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i(StructMsgForGeneralShare.access$000(), 2, "robot card, use new url:" + localStructMsgForGeneralShare.uin + ",paramUrl=" + paramString);
          ThreadManager.excute(new StructMsgForGeneralShare.GeneralClickHandler.5(this, paramString, localNumberFormatException), 16, null, true);
          if ((localStructMsgForGeneralShare.mMsgServiceID != 83) && (localStructMsgForGeneralShare.mMsgServiceID != 108) && (localStructMsgForGeneralShare.mMsgServiceID != 114) && (localStructMsgForGeneralShare.mMsgServiceID != 116)) {
            continue;
          }
          paramString = "";
          localObject3 = Uri.parse((String)localObject2);
          try
          {
            localObject3 = ((Uri)localObject3).getQueryParameter("article_id");
            paramString = (String)localObject3;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            continue;
            anpc.a(BaseApplication.getContext()).a(localNumberFormatException, "sha_click", 1, "", "", String.valueOf(localStructMsgForGeneralShare.mSourceAppid));
          }
          if (TextUtils.isEmpty(localStructMsgForGeneralShare.mMsgActionData)) {
            continue;
          }
          j = 1;
          kbp.a(null, "", "0X8007555", "0X8007555", 0, 0, paramString, "", "" + j, "");
          kbp.d("0X8007555", "", paramString, "", "" + j, "");
          if (localStructMsgForGeneralShare.mSourceAppid != 1101244924L) {
            continue;
          }
          ((Intent)localObject4).putExtra("BUDNLE_KEY_IS_MY_PROFILE", str2.contains("gene/index.html?uin=" + localStructMsgForGeneralShare.currentAccountUin));
          ((Intent)localObject4).setClass(localContext, MusicGeneQQBrowserActivity.class);
          ocp.a(localStructMsgForGeneralShare.message, (Intent)localObject4, str2);
          if ((TextUtils.isEmpty(localStructMsgForGeneralShare.mContentTitle)) || (TextUtils.isEmpty((CharSequence)localObject2)) || (((String)localObject2).startsWith("https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128"))) {
            continue;
          }
          ((Intent)localObject4).putExtra("title", localStructMsgForGeneralShare.mContentTitle);
          wgv.c(localContext, (Intent)localObject4, str2);
          anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str2, "", "", "");
          if (!bool) {
            continue;
          }
          anpc.a(BaseApplication.getContext()).a(localNumberFormatException, str1, "Game_center", "Clk_game_in", 0, 1, null, String.valueOf(localStructMsgForGeneralShare.mSourceAppid), null, null, null);
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i(StructMsgForGeneralShare.access$000(), 2, "robot card, use old url:" + localStructMsgForGeneralShare.uin + ",paramUrl=" + ((Intent)localObject4).getStringExtra("url"));
          continue;
          if (this.i == null) {
            continue;
          }
          paramString = this.i.senderuin;
          if (52 != localStructMsgForGeneralShare.mMsgServiceID) {
            continue;
          }
          if (!paramString.equals(str1)) {
            continue;
          }
          anot.a(localNumberFormatException, "CliOper", "", "", "0X80052BB", "0X80052BB", 0, 0, "", "", "", "");
          continue;
          anot.a(localNumberFormatException, "CliOper", "", "", "0X80052BC", "0X80052BC", 0, 0, "", "", "", "");
          continue;
          j = 2;
          continue;
          continue;
          localObject2 = paramString;
          continue;
        }
        str2 = new URL(paramString).getHost();
        anot.a(null, "CliOper", "", (String)localObject3, "0X80061B0", "0X80061B0", j, 0, str1, (String)localObject4, (String)localObject1, str2);
        if (QLog.isDebugVersion()) {
          QLog.d(StructMsgForGeneralShare.access$000(), 4, String.format("the report params:%s,%s,%s,%s", new Object[] { str1, localObject4, localObject1, str2 }));
        }
        localObject1 = paramString;
        if (this.b.mMsgServiceID == 107)
        {
          paramString = paramString + "&msgSeq=" + this.b.uniseq + "&resId=" + this.b.mResid + "&uin=" + this.b.uin + "&sessionType=" + this.b.uinType;
          localObject1 = paramString;
          if (StructMsgForGeneralShare.receiptServer == null)
          {
            StructMsgForGeneralShare.receiptServer = new anrq(this, "receipt_msg");
            QIPCServerHelper.getInstance().register(StructMsgForGeneralShare.receiptServer);
            localObject1 = paramString;
          }
        }
        paramString = ((String)localObject1).trim();
        bool = paramString.startsWith("https://gamecenter.qq.com");
        l = aqgb.W(localStructMsgForGeneralShare.mSourceAppid);
        str1 = localQQAppInterface.getCurrentAccountUin();
        if ((localContext instanceof FragmentActivity))
        {
          localObject3 = ((FragmentActivity)localContext).getChatFragment();
          if (localObject3 != null)
          {
            localObject3 = ((ChatFragment)localObject3).a();
            if ((localObject3 instanceof ycd))
            {
              localObject4 = (ycd)localObject3;
              ((ycd)localObject4).bYz += 1;
              localObject3 = (ycd)localObject3;
              ((ycd)localObject3).bYx += 1;
            }
          }
        }
        if (!pH(paramString)) {
          continue;
        }
        localObject1 = avpw.d.a();
        ((avpw.d)localObject1).cMP = str1;
        ((avpw.d)localObject1).nickname = localQQAppInterface.getCurrentNickname();
        if (!TextUtils.isEmpty(this.albumId)) {
          continue;
        }
        avpw.a((Activity)localContext, (avpw.d)localObject1, paramString, "mqqChat", -1);
        if ((this.b.message != null) && (this.b.message.istroop == 1008)) {
          kaw.f(this.mApp, this.b.uin);
        }
        return false;
        j = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare
 * JD-Core Version:    0.7.0.1
 */