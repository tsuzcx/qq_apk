package com.tencent.mobileqq.activity.aio;

import abrb;
import accc;
import acff;
import acfp;
import acle;
import acms;
import adxk;
import adxm;
import adxp;
import adxp.a;
import adxq;
import adyd;
import aego;
import aegs;
import aegu;
import aehj;
import aekc;
import aeoj;
import afpu;
import afqh;
import afqr;
import ahtc;
import ahtd;
import aine;
import ajdg;
import ajlc;
import ajlg;
import ajri;
import aldj;
import alvj;
import ambj;
import anaz;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import anov;
import ansy;
import aofe;
import aofy;
import apdg;
import apdg.a;
import apmb;
import apmc;
import aprg;
import apri;
import apri.a;
import apri.b;
import apsa;
import apsb;
import apsb.a;
import apsw;
import apsw.e;
import aptl;
import aptl.a;
import aptw;
import apuh;
import aqbn;
import aqcx;
import aqdf;
import aqdj;
import aqfl;
import aqfl.a;
import aqft;
import aqgm;
import aqgv;
import aqhq;
import aqhu;
import aqik;
import aqis;
import aqmq;
import aqmu;
import aqoa;
import aqpm;
import aqsg;
import ardq;
import aree;
import asgx;
import asih;
import aurh;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.b;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.b;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import ifo;
import ifr;
import ifs;
import ifw;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jof;
import jof.a;
import jqs;
import ku;
import obt;
import ocp;
import rar;
import stj;
import syw;
import top;
import ujt;
import wja;
import wje;
import wkc;
import wkd;
import wke;
import wkf;
import wkj;
import wko;
import wko.a;
import wla;
import wla.a;
import wlz;
import wuc;
import xkl;
import xmb;
import xov;
import xpc;
import xva;
import xzk;
import ydz;
import yju;

public abstract class BaseBubbleBuilder
  extends wko
  implements View.OnClickListener, ChatItemAnimLayout.a
{
  public static int alpha = 255;
  public static boolean bdm;
  protected static final ConcurrentHashMap<Long, String> cV;
  public static ColorFilter d;
  public static final Handler sHandler = new Handler(Looper.getMainLooper());
  protected HashSet<Long> aA = new HashSet();
  @Deprecated
  public BaseAdapter adapter;
  public QQAppInterface app;
  private AIOAnimationConatiner b;
  private int bNO;
  private boolean bdl;
  public boolean bdn;
  public boolean bdo;
  protected boolean bdp;
  public aqdf d;
  View.OnLongClickListener e = new wke(this);
  long end = 0L;
  public Context mContext;
  protected float mDensity;
  protected ViewGroup mParentView;
  public SessionInfo sessionInfo;
  long start = 0L;
  
  static
  {
    if (("MNC".equals(Build.VERSION.CODENAME)) || (Build.VERSION.SDK_INT >= 23)) {}
    for (boolean bool = true;; bool = false)
    {
      bdm = bool;
      jdField_d_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
      cV = new ConcurrentHashMap(100);
      return;
    }
  }
  
  public BaseBubbleBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.app = paramQQAppInterface;
    this.adapter = paramBaseAdapter;
    this.mContext = paramContext;
    this.sessionInfo = paramSessionInfo;
    this.b = paramAIOAnimationConatiner;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private boolean A(MessageRecord paramMessageRecord)
  {
    return (paramMessageRecord.istroop != 1000) && (paramMessageRecord.istroop != 1020) && (paramMessageRecord.istroop != 1004);
  }
  
  private boolean B(MessageRecord paramMessageRecord)
  {
    return ((paramMessageRecord instanceof MessageForStructing)) && (apsa.B(paramMessageRecord));
  }
  
  private boolean C(MessageRecord paramMessageRecord)
  {
    if ((aqft.rj(paramMessageRecord.senderuin)) && (aqft.bK(this.mContext))) {
      return true;
    }
    if (aprg.V(this.app, paramMessageRecord.senderuin))
    {
      if (this.sessionInfo.cZ == 1) {
        aprg.H(this.mContext, paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "openRobotProfileCard, robotuin:" + paramMessageRecord.senderuin + " frienduin:" + paramMessageRecord.frienduin);
        }
        return true;
        aprg.H(this.mContext, null, paramMessageRecord.senderuin);
      }
    }
    if ((this.sessionInfo.cZ == 1) && (((TroopManager)this.app.getManager(52)).kB(this.sessionInfo.troopUin))) {
      return true;
    }
    if ("10000".equals(paramMessageRecord.senderuin)) {
      return true;
    }
    if ((paramMessageRecord.istroop == 3000) && (aqgv.aa(this.app, paramMessageRecord.frienduin))) {
      return true;
    }
    return (paramMessageRecord instanceof MessageForTroopConfess);
  }
  
  private boolean D(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = (HotChatManager)this.app.getManager(60);
    if (localObject != null) {}
    for (localObject = ((HotChatManager)localObject).a(this.sessionInfo.aTl);; localObject = null)
    {
      if (localObject != null)
      {
        if (!((HotChatInfo)localObject).isGameRoom) {
          break;
        }
        bool = true;
      }
      return bool;
    }
    if (c(paramMessageRecord, ((HotChatInfo)localObject).isRobotHotChat)) {
      return true;
    }
    localObject = paramMessageRecord.senderuin;
    paramMessageRecord = ajri.encode((String)localObject);
    if (!this.app.getCurrentAccountUin().equals(localObject)) {}
    for (paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramMessageRecord;; paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.app.getCurrentAccountUin().equals(localObject)) {}
      for (localObject = "2";; localObject = "1")
      {
        anot.a(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject, "", "", "");
        localObject = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramMessageRecord);
        this.mContext.startActivity((Intent)localObject);
        return true;
      }
    }
  }
  
  private boolean E(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = apsb.a(paramMessageRecord);
    if (localObject != null)
    {
      apsb.a(this.app, this.mContext, (apsb.a)localObject);
      localObject = ((apsb.a)localObject).nickname;
      anot.a(this.app, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, paramMessageRecord.frienduin, "", (String)localObject, "");
      if (paramMessageRecord.msgtype != -2051) {}
    }
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = aqik.c(this.app, this.mContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.app, this.sessionInfo.cZ, "clk_name", paramMessageRecord, false);
      bool = true;
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
        }
      }
    }
  }
  
  private void F(String paramString1, int paramInt, String paramString2)
  {
    if ((this.mContext instanceof BaseActivity)) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.mContext).getAppRuntime();; localQQAppInterface = null)
    {
      if (localQQAppInterface != null) {
        anot.a(localQQAppInterface, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), VipUtils.d(localQQAppInterface, localQQAppInterface.getCurrentAccountUin()), paramString2, null);
      }
      return;
    }
  }
  
  private boolean F(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      paramMessageRecord = (TroopManager)this.app.getManager(52);
      TroopInfo localTroopInfo = paramMessageRecord.b(this.sessionInfo.aTl);
      if ((localTroopInfo != null) && (localTroopInfo.isQidianPrivateTroop())) {
        return true;
      }
      if (paramMessageRecord.kB(this.sessionInfo.aTl)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean H(MessageRecord paramMessageRecord)
  {
    int i = paramMessageRecord.istroop;
    return (i == 0) || (i == 1) || (i == 3000) || (i == 1000) || (i == 1004);
  }
  
  public static boolean L(View paramView)
  {
    Object localObject = wja.a(paramView);
    if (localObject == null) {}
    while (!(localObject instanceof e)) {
      return false;
    }
    paramView = (e)wja.a(paramView);
    if ((paramView.b == null) || (paramView.b.bubbleId <= 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int a(TroopInfo paramTroopInfo)
  {
    int j = 0;
    String str = this.app.getCurrentAccountUin();
    int i = j;
    if (paramTroopInfo != null)
    {
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        if ((paramTroopInfo.Administrator == null) || (!paramTroopInfo.Administrator.contains(str))) {
          break label50;
        }
        i = 3;
      }
    }
    return i;
    label50:
    if (str.equals(paramTroopInfo.troopowneruin)) {
      return 2;
    }
    return 1;
  }
  
  private String a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    aptl localaptl = aptl.a();
    if (paramInt == 2) {}
    for (Object localObject = "troop_unique_title";; localObject = "troop_rank")
    {
      localObject = localaptl.getUrl((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      ((StringBuilder)localObject).append("gc=").append(paramMessageRecord.frienduin).append("&");
      ((StringBuilder)localObject).append("uin=").append(paramMessageRecord.senderuin).append("&");
      ((StringBuilder)localObject).append("nick=").append(paramString).append("&");
      ((StringBuilder)localObject).append("type=").append(paramInt).append("&");
      ((StringBuilder)localObject).append("from=").append("aio").append("&");
      return ((StringBuilder)localObject).toString();
    }
    aptl.a locala = new aptl.a();
    locala.crf = paramMessageRecord.frienduin;
    locala.uin = paramMessageRecord.senderuin;
    locala.nick = paramString;
    locala.type = ("" + paramInt);
    locala.from = "aio";
    return localaptl.a((String)localObject, locala);
  }
  
  private void a(Context paramContext, View paramView, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, e parame)
  {
    int i;
    List localList;
    RelativeLayout.LayoutParams localLayoutParams6;
    if ((paramBaseChatItemLayout.HO != null) && (paramBaseChatItemLayout.HO.getVisibility() == 0))
    {
      i = 1;
      if ((paramView == null) || (paramView.getId() != 2131364503) || (i != 0) || (!EmojiStickerManager.au(paramChatMessage)) || (paramChatMessage.fakeSenderType != 0)) {
        break label1453;
      }
      localList = EmojiStickerManager.a().c(paramChatMessage);
      localLayoutParams6 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (paramBaseChatItemLayout.a == null) {
        break label1570;
      }
    }
    label640:
    label662:
    label922:
    label1570:
    for (RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.a.getLayoutParams();; localLayoutParams1 = null)
    {
      if ((paramBaseChatItemLayout.am != null) && (paramBaseChatItemLayout.am.getVisibility() == 0)) {}
      for (RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.am.getLayoutParams();; localLayoutParams2 = null)
      {
        if ((paramBaseChatItemLayout.gT != null) && (paramBaseChatItemLayout.gT.getVisibility() == 0)) {}
        for (RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.gT.getLayoutParams();; localLayoutParams3 = null)
        {
          if ((paramBaseChatItemLayout.HQ != null) && (paramBaseChatItemLayout.HQ.getVisibility() == 0)) {}
          for (RelativeLayout.LayoutParams localLayoutParams4 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.HQ.getLayoutParams();; localLayoutParams4 = null)
          {
            if ((paramBaseChatItemLayout.nf != null) && (paramBaseChatItemLayout.nf.getVisibility() == 0)) {}
            for (RelativeLayout.LayoutParams localLayoutParams5 = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.nf.getLayoutParams();; localLayoutParams5 = null)
            {
              int j = paramContext.getResources().getDisplayMetrics().widthPixels;
              float f2 = paramContext.getResources().getDisplayMetrics().density;
              int i1;
              int n;
              boolean bool1;
              if (localLayoutParams5 != null)
              {
                i1 = localLayoutParams5.topMargin;
                n = localLayoutParams5.bottomMargin;
                bool1 = true;
              }
              for (;;)
              {
                int i3;
                int i2;
                if (localLayoutParams6 != null)
                {
                  i3 = localLayoutParams6.topMargin;
                  i2 = localLayoutParams6.bottomMargin;
                }
                for (;;)
                {
                  int i5;
                  int i4;
                  boolean bool2;
                  if (localLayoutParams3 != null)
                  {
                    i5 = localLayoutParams3.topMargin;
                    i4 = localLayoutParams3.bottomMargin;
                    bool2 = true;
                  }
                  for (;;)
                  {
                    int i7;
                    int i6;
                    if (localLayoutParams1 != null)
                    {
                      i7 = localLayoutParams1.topMargin;
                      i6 = localLayoutParams1.bottomMargin;
                    }
                    for (;;)
                    {
                      int i9;
                      int i8;
                      boolean bool3;
                      if (localLayoutParams2 != null)
                      {
                        i9 = localLayoutParams2.topMargin;
                        i8 = localLayoutParams2.bottomMargin;
                        bool3 = true;
                      }
                      for (;;)
                      {
                        int i11;
                        int i10;
                        boolean bool4;
                        if (localLayoutParams4 != null)
                        {
                          i11 = localLayoutParams4.topMargin;
                          i10 = localLayoutParams4.bottomMargin;
                          bool4 = true;
                        }
                        for (;;)
                        {
                          ajdg localajdg;
                          int k;
                          int i12;
                          if ((localList != null) && (localList.size() > 0) && (EmojiStickerManager.as(paramChatMessage)))
                          {
                            localajdg = (ajdg)this.app.getManager(14);
                            localList = this.app.b().b(this.sessionInfo.aTl, this.sessionInfo.cZ, localList);
                            k = 0;
                            i = 0;
                            i12 = localList.size() - 1;
                            label453:
                            if (i12 >= 0)
                            {
                              paramChatMessage = (MessageRecord)localList.get(i12);
                              if (paramChatMessage.extraflag == 32768) {
                                i += 1;
                              }
                            }
                          }
                          for (;;)
                          {
                            i12 -= 1;
                            break label453;
                            i = 0;
                            break;
                            EmojiStickerManager.StickerInfo localStickerInfo = EmojiStickerManager.a(paramChatMessage);
                            if ((localStickerInfo != null) && (EmojiStickerManager.at(paramChatMessage)))
                            {
                              int i13 = k + 1;
                              if (i13 > EmojiStickerManager.cRB)
                              {
                                paramChatMessage.msgtype = -2006;
                                i += 1;
                                k = i13;
                              }
                              else
                              {
                                if ((paramChatMessage instanceof MessageForMarketFace)) {
                                  paramView = localajdg.a(((MessageForMarketFace)paramChatMessage).mMarkFaceMessage);
                                }
                                for (;;)
                                {
                                  label574:
                                  int i14;
                                  label596:
                                  label618:
                                  int i15;
                                  int i16;
                                  int i17;
                                  int m;
                                  int i18;
                                  if (localStickerInfo.x <= 1.0F)
                                  {
                                    i14 = (int)(localStickerInfo.x * j);
                                    if (localStickerInfo.y > 1.0F) {
                                      break label1058;
                                    }
                                    k = (int)(localStickerInfo.y * j);
                                    if (localStickerInfo.width > 1.0F) {
                                      break label1065;
                                    }
                                    i15 = (int)(localStickerInfo.width * j);
                                    if (localStickerInfo.height > 1.0F) {
                                      break label1072;
                                    }
                                    i16 = (int)(localStickerInfo.height * j);
                                    i17 = localStickerInfo.rotate;
                                    m = k + localLayoutParams6.topMargin;
                                    k = m;
                                    if (localLayoutParams5 != null) {
                                      k = m + (wja.dp2px(14.0F, this.app.getApp().getResources()) + (localLayoutParams5.topMargin + localLayoutParams5.bottomMargin));
                                    }
                                    m = k;
                                    if (localLayoutParams3 != null) {
                                      m = k + (wja.dp2px(14.0F, this.app.getApp().getResources()) + (localLayoutParams3.topMargin + localLayoutParams3.bottomMargin));
                                    }
                                    k = m;
                                    if (m < 0)
                                    {
                                      i18 = -m;
                                      if (localLayoutParams1 != null) {
                                        localLayoutParams1.topMargin += i18;
                                      }
                                      if (localLayoutParams3 == null) {
                                        break label1079;
                                      }
                                      localLayoutParams3.topMargin += i18;
                                      label813:
                                      if (localLayoutParams4 != null) {
                                        localLayoutParams4.topMargin += i18;
                                      }
                                      if (localLayoutParams2 != null) {
                                        localLayoutParams2.topMargin += i18;
                                      }
                                      m = 0;
                                      k = m;
                                      if (i12 != localList.size() - 1)
                                      {
                                        parame.a.Cj(i18);
                                        k = m;
                                      }
                                    }
                                    if (!(paramView instanceof afpu)) {
                                      break label1112;
                                    }
                                    paramChatMessage = (afpu)paramView;
                                    if (paramChatMessage.e == null) {
                                      break label1463;
                                    }
                                    if ((EmojiStickerManager.bYF) || (aqhq.getAvailableInnernalMemorySize() <= 1.048576E+008F)) {
                                      break label1095;
                                    }
                                    m = 1;
                                    if (m == 0) {
                                      break label1101;
                                    }
                                    paramView = paramChatMessage.a("fromAIO", true, false, null, i15, i15);
                                    label942:
                                    paramChatMessage = paramChatMessage.e.epId;
                                  }
                                  for (;;)
                                  {
                                    label950:
                                    BaseChatItemLayout localBaseChatItemLayout;
                                    double d1;
                                    boolean bool5;
                                    if (paramView != null)
                                    {
                                      localBaseChatItemLayout = parame.a;
                                      d1 = i17;
                                      bool5 = localStickerInfo.isShown;
                                      if (!localStickerInfo.isShown) {
                                        break label1200;
                                      }
                                    }
                                    label1058:
                                    label1065:
                                    label1072:
                                    label1200:
                                    for (float f1 = 1.0F;; f1 = 1.1F)
                                    {
                                      localBaseChatItemLayout.a(paramView, i14, k, i15, i16, d1, paramChatMessage, bool5, f1, localStickerInfo);
                                      k = i13;
                                      break;
                                      if (!(paramChatMessage instanceof MessageForText)) {
                                        break label1472;
                                      }
                                      paramView = (MessageForText)paramChatMessage;
                                      if (TextUtils.isEmpty(paramView.msg)) {
                                        break label1472;
                                      }
                                      paramView = EmojiStickerManager.a().a(paramView.msg);
                                      break label574;
                                      i14 = j;
                                      break label596;
                                      k = j;
                                      break label618;
                                      i15 = j;
                                      break label640;
                                      i16 = j;
                                      break label662;
                                      label1079:
                                      localLayoutParams6.topMargin += i18;
                                      break label813;
                                      label1095:
                                      m = 0;
                                      break label922;
                                      label1101:
                                      paramView = paramChatMessage.b(paramContext, f2);
                                      break label942;
                                      label1112:
                                      if ((paramView instanceof afqr))
                                      {
                                        paramView = ((afqr)paramView).c(paramContext, f2);
                                        paramChatMessage = "";
                                        break label950;
                                      }
                                      if ((paramView instanceof afqh))
                                      {
                                        paramView = ((afqh)paramView).c(paramContext, f2);
                                        paramChatMessage = "";
                                        break label950;
                                      }
                                      if (!(paramChatMessage instanceof MessageForPic)) {
                                        break label1454;
                                      }
                                      paramView = xkl.b(paramContext, (MessageForPic)paramChatMessage);
                                      ThreadManager.post(new BaseBubbleBuilder.1(this, paramChatMessage), 5, null, true);
                                      paramChatMessage = "";
                                      break label950;
                                    }
                                    if (i != localList.size())
                                    {
                                      paramView = new Bundle();
                                      paramView.putBoolean("haveTimeStamp", bool1);
                                      paramView.putBoolean("haveNickName", bool2);
                                      paramView.putBoolean("havePendant", bool3);
                                      paramView.putBoolean("haveTroopMemberLevel", bool4);
                                      if (localLayoutParams5 != null)
                                      {
                                        paramView.putInt("timeStampTop", i1);
                                        paramView.putInt("timeStampBottom", n);
                                      }
                                      if (localLayoutParams6 != null)
                                      {
                                        paramView.putInt("textViewTop", i3);
                                        paramView.putInt("textViewBottom", i2);
                                      }
                                      if (localLayoutParams3 != null)
                                      {
                                        paramView.putInt("nickNameViewTop", i5);
                                        paramView.putInt("nickNameViewBottom", i4);
                                      }
                                      if (localLayoutParams1 != null)
                                      {
                                        paramView.putInt("headViewTop", i7);
                                        paramView.putInt("headViewBottom", i6);
                                      }
                                      if (localLayoutParams2 != null)
                                      {
                                        paramView.putInt("pendantViewTop", i9);
                                        paramView.putInt("pendantViewBottom", i8);
                                      }
                                      if (localLayoutParams4 != null)
                                      {
                                        paramView.putInt("troopMemberLevelTop", i11);
                                        paramView.putInt("troopMemberLevelBottom", i10);
                                      }
                                      paramBaseChatItemLayout.setTag(2131374809, paramView);
                                    }
                                    if (paramBaseChatItemLayout.sb != null)
                                    {
                                      paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.sb.getLayoutParams();
                                      paramView.addRule(6, 2131364512);
                                      paramView.topMargin = (-wja.dp2px(1.0F, paramContext.getResources()));
                                    }
                                    label1453:
                                    return;
                                    label1454:
                                    paramChatMessage = "";
                                    paramView = null;
                                    continue;
                                    label1463:
                                    paramChatMessage = "";
                                    paramView = null;
                                  }
                                  label1472:
                                  paramView = null;
                                }
                              }
                            }
                          }
                          bool4 = false;
                          i10 = 0;
                          i11 = 0;
                        }
                        bool3 = false;
                        i8 = 0;
                        i9 = 0;
                      }
                      i6 = 0;
                      i7 = 0;
                    }
                    bool2 = false;
                    i4 = 0;
                    i5 = 0;
                  }
                  i2 = 0;
                  i3 = 0;
                }
                bool1 = false;
                n = 0;
                i1 = 0;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(View paramView, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((paramView != null) && (paramView.getId() == 2131364503))
    {
      Object localObject = paramBaseChatItemLayout.getTag(2131374809);
      if ((localObject instanceof Bundle))
      {
        localObject = (Bundle)localObject;
        boolean bool1 = ((Bundle)localObject).getBoolean("haveTimeStamp");
        boolean bool2 = ((Bundle)localObject).getBoolean("haveNickName");
        boolean bool3 = ((Bundle)localObject).getBoolean("havePendant");
        boolean bool4 = ((Bundle)localObject).getBoolean("haveTroopMemberLevel");
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "restoreLayoutParams params = " + ((Bundle)localObject).toString());
        }
        paramView = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.a.getLayoutParams();
        paramView.topMargin = ((Bundle)localObject).getInt("textViewTop", 0);
        paramView.bottomMargin = ((Bundle)localObject).getInt("textViewBotttom", 0);
        localLayoutParams.topMargin = ((Bundle)localObject).getInt("headViewTop", 0);
        localLayoutParams.bottomMargin = ((Bundle)localObject).getInt("headViewBottom", 0);
        if ((paramBaseChatItemLayout.am != null) && (paramBaseChatItemLayout.am.getVisibility() == 0) && (bool3))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.am.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("pendantViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("pendantViewBottom", 0);
        }
        if ((paramBaseChatItemLayout.gT != null) && (paramBaseChatItemLayout.gT.getVisibility() == 0) && (bool2))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.gT.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("nickNameViewTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("nickNameViewBottom", 0);
        }
        if ((paramBaseChatItemLayout.HQ != null) && (paramBaseChatItemLayout.HQ.getVisibility() == 0) && (bool4))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.HQ.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("troopMemberLevelTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("troopMemberLevelBottom", 0);
        }
        if ((paramBaseChatItemLayout.nf != null) && (paramBaseChatItemLayout.nf.getVisibility() == 0) && (bool1))
        {
          paramView = (RelativeLayout.LayoutParams)paramBaseChatItemLayout.nf.getLayoutParams();
          paramView.topMargin = ((Bundle)localObject).getInt("timeStampTop", 0);
          paramView.bottomMargin = ((Bundle)localObject).getInt("timeStampBottom", 0);
        }
        paramBaseChatItemLayout.setTag(2131374809, null);
      }
    }
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, acff paramacff, boolean paramBoolean1, boolean paramBoolean2, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
    {
      paramView = new Intent(this.mContext, NearbyPeopleProfileActivity.class);
      if (paramMessageRecord.istroop == 1001)
      {
        paramAllInOne.bJa = 10;
        paramView.putExtra("frome_where", 21);
        paramAllInOne.ae = stj.a(this.sessionInfo);
        paramView.putExtra("AllInOne", paramAllInOne);
        if (!aqft.equalsWithNullCheck(this.app.getCurrentAccountUin(), paramString)) {
          break label189;
        }
        paramView.putExtra("param_mode", 2);
      }
      for (;;)
      {
        if (!(this.mContext instanceof Activity)) {
          break label201;
        }
        ((Activity)this.mContext).startActivityForResult(paramView, 9009);
        return;
        if (paramMessageRecord.istroop == 1010)
        {
          paramAllInOne.bJa = 11;
          break;
        }
        if (paramMessageRecord.istroop != 10002) {
          break;
        }
        paramView.putExtra("frome_where", 22);
        break;
        label189:
        paramView.putExtra("param_mode", 3);
      }
      label201:
      this.mContext.startActivity(paramView);
      return;
    }
    if ((!paramBoolean2) && (!paramacff.isFriend(this.sessionInfo.aTl)))
    {
      paramacff = ydz.a(this.mContext, this.sessionInfo.cZ, paramBoolean1, paramBoolean2);
      if (paramacff == null) {
        break label305;
      }
      paramAllInOne.data.putSerializable("param_wzry_data", paramacff);
    }
    while (aine.kg(this.sessionInfo.cZ))
    {
      if (this.sessionInfo.entrance == 20) {
        i = 1;
      }
      ProfileActivity.a(paramView.getContext(), paramAllInOne, i, 2);
      return;
      label305:
      if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key")))
      {
        paramMessageRecord = paramMessageRecord.senderuin;
        paramMessageRecord = KplRoleInfo.WZRYUIinfo.createInfo(paramMessageRecord, KplRoleInfo.WZRYUIinfo.buildNickName(this.sessionInfo.aTn, KplRoleInfo.getGameNickByUin(this.app, paramMessageRecord)), KplRoleInfo.getKplVerifyMsg(this.app), 0, 0);
        paramAllInOne.data.putSerializable("param_wzry_data", paramMessageRecord);
      }
    }
    ProfileActivity.b(paramView.getContext(), paramAllInOne);
  }
  
  private void a(View paramView, MessageRecord paramMessageRecord, jof.a parama, int paramInt)
  {
    Object localObject1 = parama.B();
    if ((localObject1 != null) && (parama.flags != 2))
    {
      localObject1 = URLEncoder.encode(Base64.encodeToString((byte[])localObject1, 2));
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localStringBuilder = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&id=").append((String)localObject1).append("&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(jof.aV(parama.aCv)).append("&nick=");
      if (TextUtils.isEmpty(parama.TG))
      {
        parama = "";
        ((Intent)localObject2).putExtra("url", parama + "&role=" + String.valueOf(paramInt) + "&self=0");
        ((Activity)paramView.getContext()).startActivity((Intent)localObject2);
        if (paramMessageRecord.msgData != null)
        {
          jof.a().a(paramMessageRecord.frienduin, (String)localObject1, paramMessageRecord);
          if (QLog.isDevelopLevel()) {
            QLog.i("ChatItemBuilder", 4, "report:" + paramMessageRecord.msgData.toString());
          }
        }
      }
    }
    while (parama.flags != 2) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        parama = URLEncoder.encode(parama.TG);
      }
    }
    localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    Object localObject2 = new StringBuilder().append("https://qqweb.qq.com/m/business/anonymoustalk/index.html?_wv=5123&_bid=227&gcode=").append(paramMessageRecord.frienduin).append("&avatar=").append(jof.aV(parama.aCv)).append("&nick=");
    if (TextUtils.isEmpty(parama.TG)) {}
    for (paramMessageRecord = "";; paramMessageRecord = URLEncoder.encode(parama.TG))
    {
      ((Intent)localObject1).putExtra("url", paramMessageRecord + "&role=" + String.valueOf(paramInt) + "&self=1");
      ((Activity)paramView.getContext()).startActivity((Intent)localObject1);
      return;
    }
  }
  
  public static void a(aqoa paramaqoa, Context paramContext)
  {
    paramaqoa.Z(2131365686, paramContext.getString(2131691404), 2130839081);
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    String str = paramSessionInfo.aTn;
    if (paramChatMessage.isSend()) {
      str = this.app.getCurrentNickname();
    }
    if (!TextUtils.isEmpty(str)) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.a(bool, str, paramSessionInfo.a.k, paramChatMessage.isSend(), false, false, false, "", null, "");
      return;
    }
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, e parame, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if ((paramChatMessage.vipBubbleID == 100000L) && (paramChatMessage.msgtype == -1000) && (!aegu.ag(paramChatMessage)) && (paramChatMessage.fakeSenderType != 1))
    {
      localObject = ifw.Q(this.mContext.getApplicationContext());
      paramContext = null;
      ifo localifo = ifs.b(this.mContext.getApplicationContext());
      if (localifo != null) {
        paramContext = localifo.a(paramChatMessage.msg, paramChatMessage.uniseq, (String)localObject);
      }
      if ((paramContext != null) && (paramContext.e().booleanValue()) && (!paramChatMessage.isSend()))
      {
        parame.b = adyd.a(100001, this.app, this.mContext.getResources(), this.adapter, paramBoolean);
        if (parame.b != null) {
          parame.b.m(parame.jdField_E_of_type_AndroidViewView, null);
        }
        if (parame.jdField_E_of_type_AndroidViewView != null)
        {
          parame.jdField_E_of_type_AndroidViewView.setMinimumWidth(wja.dp2px(65.0F, this.mContext.getResources()));
          parame.jdField_E_of_type_AndroidViewView.setMinimumHeight(wja.dp2px(57.0F, this.mContext.getResources()));
        }
        if (parame.b != null)
        {
          int j = paramChatMessage.vipBubbleDiyTextId;
          i = j;
          if (j <= 0) {
            i = acle.R(paramChatMessage.vipBubbleID);
          }
          if (paramChatMessage.fakeSenderType != 1) {
            break label529;
          }
          paramContext = parame.b;
          localObject = this.app;
          bool1 = paramChatMessage.isSend();
          bool2 = paramChatMessage.needVipBubble();
          if (paramInt3 != 2) {
            break label523;
          }
        }
      }
    }
    label523:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramContext.a((QQAppInterface)localObject, bool1, bool2, paramBoolean, parame.jdField_E_of_type_AndroidViewView, this.app.getCurrentUin(), i);
      if (parame.jdField_E_of_type_AndroidViewView != null)
      {
        paramContext = parame.jdField_E_of_type_AndroidViewView.getBackground();
        if (paramContext != null) {
          paramContext.setAlpha(alpha);
        }
      }
      a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
      a(parame, paramChatMessage);
      b(parame, paramChatMessage);
      if ((paramInt1 == paramInt2 - 1) && (paramChatMessage.mAnimFlag)) {
        sHandler.post(new BaseBubbleBuilder.5(this, parame, paramChatMessage));
      }
      paramChatMessage.mAnimFlag = false;
      return;
      parame.b = adyd.a(100000, this.app, this.mContext.getResources(), this.adapter, paramBoolean);
      break;
      if ((paramInt3 == 3) || (!paramChatMessage.needVipBubble()) || (aegu.ag(paramChatMessage))) {
        i = 0;
      }
      for (;;)
      {
        parame.b = adyd.a(i, this.app, paramContext.getResources(), this.adapter, paramBoolean);
        break;
        localObject = (acle)this.app.getBusinessHandler(13);
        if (paramChatMessage.fakeSenderType == 1) {
          i = ((acle)localObject).AS();
        } else {
          i = ((acle)localObject).j(paramChatMessage);
        }
      }
    }
    label529:
    paramContext = parame.b;
    Object localObject = this.app;
    boolean bool1 = paramChatMessage.isSend();
    boolean bool2 = paramChatMessage.needVipBubble();
    if (paramInt3 == 2) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramContext.a((QQAppInterface)localObject, bool1, bool2, paramBoolean, parame.jdField_E_of_type_AndroidViewView, ku.a(paramChatMessage), i);
      break;
    }
  }
  
  @TargetApi(14)
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, e parame)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramChatMessage.istroop == 3000) {
      if (aqgv.aa(this.app, paramChatMessage.frienduin))
      {
        localObject1 = aqgv.a(this.app, paramChatMessage.frienduin, paramChatMessage.senderuin, paramChatMessage);
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() != 0) {}
        }
        else
        {
          localObject2 = paramChatMessage.senderuin;
        }
        if (((acff)this.app.getManager(51)).co(paramChatMessage.senderuin) != 1) {
          break label271;
        }
        i = 1;
        label97:
        localObject1 = ((FlashChatManager)this.app.getManager(217)).a;
        if (i == 0) {
          break label277;
        }
        localObject1 = ((FlashChatManager.b)localObject1).icon;
        label127:
        if (localObject2 == null) {
          break label283;
        }
        label132:
        paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.sessionInfo.a.k, paramChatMessage.isSend(), false, false, false, "", null, (String)localObject1);
        localObject1 = localObject2;
        if (paramBaseChatItemLayout.HS != null)
        {
          paramBaseChatItemLayout.HS.setOnClickListener(this);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if ((paramBaseChatItemLayout.vU != null) && (AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 14)) {
        paramBaseChatItemLayout.vU.setAccessibilityDelegate(new wkc(this));
      }
      a((String)localObject1, paramChatMessage, paramBaseChatItemLayout, parame);
      return;
      if (paramChatMessage.isSend()) {}
      for (localObject1 = this.app.getCurrentNickname();; localObject1 = aqgv.m(this.app, paramChatMessage.frienduin, paramChatMessage.senderuin)) {
        break;
      }
      label271:
      i = 0;
      break label97;
      label277:
      localObject1 = null;
      break label127;
      label283:
      bool1 = false;
      break label132;
      if (paramChatMessage.istroop == 9501)
      {
        if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.issend == 0))
        {
          localObject1 = aqgv.b(this.app, paramChatMessage.senderuin, true);
          if (paramChatMessage.senderuin.equals(paramChatMessage.frienduin)) {
            localObject1 = this.sessionInfo.aTn;
          }
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() != 0) {}
          }
          else
          {
            localObject2 = paramChatMessage.senderuin;
          }
          paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.sessionInfo.a.k, false, false, false, false, "", null, null);
        }
        for (;;)
        {
          localObject1 = null;
          break;
          paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
        }
      }
      if (asgx.ag(this.app, paramChatMessage.senderuin))
      {
        localObject2 = asih.b(this.app, paramChatMessage);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
        for (bool1 = bool2;; bool1 = false)
        {
          paramBaseChatItemLayout.a(bool1, (CharSequence)localObject2, this.sessionInfo.a.k, paramChatMessage.isSend(), false, false, false, "", null, "");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          localObject1 = this.sessionInfo.aTn;
          break;
        }
      }
      if (this.sessionInfo.beB)
      {
        a(paramBaseChatItemLayout, this.sessionInfo, paramChatMessage);
        localObject1 = null;
      }
      else
      {
        localObject1 = this.sessionInfo.aTn;
        paramBaseChatItemLayout.a(false, null, null, false, false, false, false, "", null, null);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, apsb.a parama)
  {
    apsb.a(this.app, this.mContext, parama);
    anot.a(this.app, "P_CliOper", "Grp_AIO", "", "five_m", "clk_head", 0, 0, paramMessageRecord.frienduin, "", parama.nickname, "");
    if (paramMessageRecord.msgtype == -2051) {}
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = aqik.c(this.app, this.mContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.app, this.sessionInfo.cZ, "clk_head", paramMessageRecord, false);
      return;
    }
    catch (Exception paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramString.equals(paramAllInOne.nickname)) {
      paramAllInOne.nickname = null;
    }
    paramAllInOne.ae = stj.a(this.sessionInfo);
    paramAllInOne.aOF = this.sessionInfo.aTl;
    paramAllInOne.bIX = this.sessionInfo.cZ;
    if ((paramMessageRecord.istroop == 1000) || (paramMessageRecord.istroop == 1020)) {
      paramAllInOne.troopUin = paramMessageRecord.senderuin;
    }
    for (;;)
    {
      paramAllInOne.bIZ = 2;
      if (paramMessageRecord.istroop != 0) {
        break;
      }
      paramAllInOne.bJa = 1;
      return;
      if (paramMessageRecord.istroop == 1)
      {
        paramAllInOne.troopUin = this.sessionInfo.troopUin;
        paramAllInOne.troopcode = paramMessageRecord.frienduin;
      }
      else if (3000 == paramMessageRecord.istroop)
      {
        paramAllInOne.discussUin = this.sessionInfo.aTl;
      }
    }
    if (paramMessageRecord.istroop == 3000)
    {
      paramAllInOne.bJa = 107;
      return;
    }
    if (paramMessageRecord.istroop == 1)
    {
      paramAllInOne.bJa = 108;
      return;
    }
    paramAllInOne.bJa = 106;
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, e parame)
  {
    int i;
    int j;
    label30:
    int k;
    label65:
    int m;
    label92:
    String str;
    if (AppSetting.enableTalkBack)
    {
      if (paramChatMessage.istroop != 1) {
        break label185;
      }
      i = 1;
      if (paramChatMessage.istroop != 3000) {
        break label191;
      }
      j = 1;
      if ((paramChatMessage.fakeSenderType != 2) && (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg))) {
        break label197;
      }
      k = 1;
      if ((!TextUtils.equals(this.app.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
        break label203;
      }
      m = 1;
      if ((i != 0) || (j != 0) || (k != 0))
      {
        if (i == 0) {
          break label306;
        }
        if (m == 0) {
          break label209;
        }
        str = acfp.m(2131703056);
      }
    }
    label306:
    label439:
    for (;;)
    {
      paramBaseChatItemLayout.a.setContentDescription(str);
      if ((AppSetting.enableTalkBack) && (parame.jdField_E_of_type_JavaLangStringBuilder != null))
      {
        if ((TextUtils.equals(this.app.getCurrentUin(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          parame.jdField_E_of_type_JavaLangStringBuilder.append("我");
        }
      }
      else
      {
        return;
        label185:
        i = 0;
        break;
        label191:
        j = 0;
        break label30;
        label197:
        k = 0;
        break label65;
        label203:
        m = 0;
        break label92;
        label209:
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          if (paramChatMessage.msgtype == -3006)
          {
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131699890), new Object[] { obt.a(this.app, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = acfp.m(2131703057);
          continue;
        }
        str = paramString + acfp.m(2131703049);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = acfp.m(2131703060);
            continue;
          }
          str = paramString + acfp.m(2131703050);
          continue;
        }
        if (m != 0) {}
        for (str = acfp.m(2131703060);; str = paramString + acfp.m(2131703050))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label439;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131699890), new Object[] { obt.a(this.app, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (jof.a(paramChatMessage)) {
      paramString = this.mContext.getResources().getString(2131690313) + paramBaseChatItemLayout;
    }
    parame.jdField_E_of_type_JavaLangStringBuilder.insert(0, paramString);
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord)
  {
    if (C(paramMessageRecord)) {}
    while ((c(paramView, paramMessageRecord)) || (b(paramView, paramMessageRecord))) {
      return true;
    }
    return false;
  }
  
  private boolean a(View paramView, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    aptw localaptw;
    if (!paramBoolean)
    {
      bool1 = bool2;
      if (paramMessageRecord.istroop == 1) {
        localaptw = (aptw)this.app.getManager(203);
      }
    }
    try
    {
      long l = Long.parseLong(paramMessageRecord.senderuin);
      paramBoolean = localaptw.c(this.mContext, paramMessageRecord.frienduin, l);
      if (paramBoolean)
      {
        bool1 = true;
        return bool1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("ChatItemBuilder", 2, "parseLong error: messageRecord.senderuin = " + paramMessageRecord.senderuin);
      }
      aldj.a(this.app, (Activity)paramView.getContext(), paramMessageRecord.frienduin, paramMessageRecord.senderuin, 0, 2000);
    }
    return true;
  }
  
  private boolean a(ChatMessage paramChatMessage, e parame, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!anlm.ayn()) {}
    boolean bool = paramChatMessage.isSend();
    Object localObject = this.app.getApp().getResources();
    Drawable localDrawable;
    if (bool)
    {
      i = 2130851001;
      localDrawable = ((Resources)localObject).getDrawable(i);
      if (!bool) {
        break label157;
      }
    }
    label157:
    for (int i = 2130851000;; i = 2130850823)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable);
      localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject);
      parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
      parame.b = new adxp(0);
      a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
      a(parame, paramChatMessage);
      b(parame, paramChatMessage);
      return true;
      i = 2130850824;
      break;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    String str = null;
    if (paramHotChatInfo != null)
    {
      str = paramHotChatInfo.troopCode;
      if (paramHotChatInfo.isGameRoom)
      {
        localObject = (ardq)this.app.getBusinessHandler(107);
        if ((((ardq)localObject).cAf != null) && (((ardq)localObject).cAf.equals(paramMessageRecord.senderuin))) {
          return true;
        }
      }
    }
    aurh.ews();
    Object localObject = paramMessageRecord.senderuin;
    label130:
    boolean bool;
    if ((paramHotChatInfo != null) && (paramHotChatInfo.isBuLuoHotChat()))
    {
      i = 86;
      localObject = new ProfileActivity.AllInOne((String)localObject, i);
      ((ProfileActivity.AllInOne)localObject).troopcode = str;
      ((ProfileActivity.AllInOne)localObject).troopUin = paramMessageRecord.frienduin;
      if ((paramHotChatInfo == null) || (!paramHotChatInfo.isGameRoom)) {
        break label265;
      }
      ((ProfileActivity.AllInOne)localObject).bJa = 113;
      ((ProfileActivity.AllInOne)localObject).ae = stj.a(this.sessionInfo);
      ((TroopManager)this.app.getManager(52)).b(paramMessageRecord.frienduin, paramMessageRecord.senderuin);
      HotChatManager.bHJ = false;
      paramMessageRecord = new Intent(this.mContext, NearbyPeopleProfileActivity.class);
      paramMessageRecord.putExtra("AllInOne", (Parcelable)localObject);
      if (paramHotChatInfo == null) {
        break label275;
      }
      bool = paramHotChatInfo.isGameRoom;
      label205:
      paramMessageRecord.putExtra("is_from_werewolves", bool);
      if (!paramBoolean) {
        break label281;
      }
    }
    label265:
    label275:
    label281:
    for (int i = 2;; i = 3)
    {
      paramMessageRecord.putExtra("param_mode", i);
      if ((!paramBoolean) || (paramHotChatInfo == null) || (!paramHotChatInfo.isGameRoom)) {
        break label287;
      }
      ProfileActivity.b(this.mContext, (ProfileActivity.AllInOne)localObject);
      return true;
      i = 42;
      break;
      ((ProfileActivity.AllInOne)localObject).bJa = 31;
      break label130;
      bool = false;
      break label205;
    }
    label287:
    this.mContext.startActivity(paramMessageRecord);
    return true;
  }
  
  private void b(aqoa paramaqoa, MessageRecord paramMessageRecord)
  {
    paramaqoa.Z(2131372030, this.mContext.getString(2131696085), 2130839092);
    this.bdp = true;
    anov localanov;
    String str;
    if (apuh.a(this.app, paramMessageRecord, this.app.getCurrentAccountUin()))
    {
      localanov = new anov(this.app).a("dc00899").b("Grp_manage").c("recall_msg").d("exp_recallMsg");
      str = paramMessageRecord.frienduin;
      if (!apuh.f(this.app, paramMessageRecord.frienduin, this.app.getCurrentAccountUin())) {
        break label131;
      }
    }
    label131:
    for (paramaqoa = "1";; paramaqoa = "2")
    {
      localanov.a(new String[] { str, paramaqoa }).report();
      return;
    }
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.app.getManager(60)).a(this.sessionInfo.aTl);
    if ((localHotChatInfo == null) || (localHotChatInfo.isGameRoom)) {
      return;
    }
    int i;
    if (!this.app.getCurrentAccountUin().equals(paramChatMessage.senderuin)) {
      if (paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin))
      {
        paramChatMessage = acfp.m(2131703051);
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.cw(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = acfp.m(2131703053);
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((aptw)this.app.getManager(203)).gM(paramChatMessage.senderuin)))
      {
        paramChatMessage = acfp.m(2131703059);
        i = 0;
      }
      else
      {
        i = 0;
        paramChatMessage = null;
      }
    }
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, e parame)
  {
    Object localObject1 = null;
    if (jof.a(paramChatMessage)) {
      localObject1 = jof.a(paramChatMessage).TG;
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      Object localObject2 = this.sessionInfo.a.k;
      if ((!this.bdo) && (!this.bdn) && (!paramChatMessage.isMultiMsg) && (this.sessionInfo.cZ == 1) && (jof.a().dd(this.sessionInfo.aTl))) {
        localObject2 = ColorStateList.valueOf(jof.aCt);
      }
      for (;;)
      {
        boolean bool3 = false;
        boolean bool1 = bool3;
        if (paramChatMessage.istroop == 1)
        {
          bool1 = bool3;
          if (((HotChatManager)this.app.getManager(60)).a(paramChatMessage.frienduin) != null) {
            bool1 = HotChatManager.Y(paramChatMessage);
          }
        }
        Object localObject3 = localObject1;
        if (paramChatMessage.msgtype == -3006) {
          localObject3 = obt.a(this.app, BaseApplicationImpl.getContext());
        }
        localObject1 = localObject3;
        if ((paramChatMessage instanceof MessageForStructing))
        {
          localObject1 = localObject3;
          if (apsa.B(paramChatMessage)) {
            localObject1 = obt.a(this.app, BaseApplicationImpl.getContext());
          }
        }
        Object localObject5 = apsb.a(paramChatMessage);
        localObject3 = localObject2;
        Object localObject4;
        if (localObject5 != null)
        {
          localObject4 = ((apsb.a)localObject5).nickname;
          localObject1 = localObject4;
          localObject3 = localObject2;
          if (ThemeUtil.isNowThemeIsDefault(this.app, false, null))
          {
            localObject1 = localObject4;
            localObject3 = localObject2;
            if (!aehj.ai(paramChatMessage))
            {
              localObject3 = ColorStateList.valueOf(((apsb.a)localObject5).dVB);
              localObject1 = localObject4;
            }
          }
        }
        int i;
        if ((paramChatMessage.istroop == 1) && (!jof.a(paramChatMessage)))
        {
          localObject2 = (HotChatManager)this.app.getManager(60);
          bool3 = ((HotChatManager)localObject2).kj(paramChatMessage.frienduin);
          if (bool3)
          {
            localObject2 = ((HotChatManager)localObject2).a(paramChatMessage.frienduin);
            if ((!bool3) || (localObject2 == null) || (!((HotChatInfo)localObject2).isGameRoom)) {
              break label859;
            }
            i = 1;
            label345:
            if (i == 0) {
              break label1026;
            }
            localObject2 = ColorStateList.valueOf(-1);
            if (paramChatMessage.isSend()) {
              localObject1 = this.app.getCurrentNickname();
            }
          }
        }
        label1026:
        for (;;)
        {
          if (((acff)this.app.getManager(51)).co(paramChatMessage.senderuin) == 1)
          {
            i = 1;
            label398:
            localObject3 = ((FlashChatManager)this.app.getManager(217)).a;
            if (i == 0) {
              break label871;
            }
            localObject3 = ((FlashChatManager.b)localObject3).icon;
            label428:
            if ((!paramChatMessage.isMultiMsg) || (jof.a(paramChatMessage))) {
              break label1023;
            }
            localObject4 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
            localObject1 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject1 = ajlc.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.app);
            }
            if (localObject1 != null)
            {
              localObject4 = localObject1;
              if (TextUtils.getTrimmedLength((CharSequence)localObject1) != 0) {}
            }
            else
            {
              localObject4 = ajlg.me(paramChatMessage.senderuin);
            }
            localObject1 = new aofe((CharSequence)localObject4, 13).k();
          }
          label560:
          label582:
          label859:
          label871:
          label883:
          label1012:
          label1023:
          for (;;)
          {
            boolean bool4;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              if (paramChatMessage.istroop == 1)
              {
                localObject1 = paramChatMessage.senderuin;
                if ((localObject1 != null) || (bool2))
                {
                  bool3 = true;
                  if (((!bool2) || (!jof.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                    break label883;
                  }
                  bool4 = true;
                  paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool4, bool1, false, false, "", null, (String)localObject3);
                  localObject5 = (TroopManager)this.app.getManager(52);
                  localObject4 = (b)paramBaseChatItemLayout.getTag(2131364521);
                  localObject1 = localObject4;
                  if (localObject4 == null)
                  {
                    localObject1 = new b(null);
                    paramBaseChatItemLayout.setTag(2131364521, localObject1);
                  }
                  ((b)localObject1).bdq = bool2;
                  ((b)localObject1).k = ((ColorStateList)localObject2);
                  ((b)localObject1).bdr = bool1;
                  ((b)localObject1).bds = false;
                  ((b)localObject1).H = "";
                  ((b)localObject1).l = null;
                  ((b)localObject1).bdt = false;
                  ((b)localObject1).aBX = ((String)localObject3);
                  ((b)localObject1).jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
                  ((b)localObject1).f = paramChatMessage;
                  ((b)localObject1).jdField_b_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e = parame;
                  ((TroopManager)localObject5).a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.b)localObject1);
                }
              }
              else
              {
                bool1 = aprg.V(this.app, paramChatMessage.senderuin);
                paramBaseChatItemLayout.a(this.app, bool1, paramChatMessage.isSend());
                if (paramBaseChatItemLayout.HS != null) {
                  paramBaseChatItemLayout.HS.setOnClickListener(this);
                }
                if (paramBaseChatItemLayout.vU != null)
                {
                  if (jof.a(paramChatMessage)) {
                    break label1012;
                  }
                  paramBaseChatItemLayout.vU.setOnClickListener(this);
                  paramBaseChatItemLayout.vU.setTag(Integer.valueOf(2131364520));
                }
              }
            }
            for (;;)
            {
              if ((AppSetting.enableTalkBack) && (Build.VERSION.SDK_INT >= 14)) {
                paramBaseChatItemLayout.vU.setAccessibilityDelegate(new wkd(this));
              }
              return;
              localObject2 = null;
              break;
              i = 0;
              break label345;
              i = 0;
              break label398;
              localObject3 = null;
              break label428;
              bool3 = false;
              break label560;
              bool4 = false;
              break label582;
              if ((localObject1 != null) || (bool2))
              {
                bool3 = true;
                if (((!bool2) || (!jof.b(paramChatMessage))) && (!aehj.ak(paramChatMessage)) && (!paramChatMessage.isSend())) {
                  break label1006;
                }
              }
              for (bool2 = true;; bool2 = false)
              {
                paramBaseChatItemLayout.a(bool3, (CharSequence)localObject1, (ColorStateList)localObject2, bool2, bool1, false, false, "", null, (String)localObject3);
                a(((CharSequence)localObject1).toString(), paramChatMessage, paramBaseChatItemLayout, parame);
                if ((!paramChatMessage.isMultiMsg) || (jof.a(paramChatMessage))) {
                  break;
                }
                aqpm.a(this.app, paramBaseChatItemLayout.vU, (Spannable)localObject1);
                break;
                bool3 = false;
                break label902;
              }
              paramBaseChatItemLayout.vU.setOnClickListener(null);
            }
          }
          label902:
          label1006:
          localObject2 = localObject3;
        }
      }
    }
  }
  
  private boolean b(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = (acff)this.app.getManager(51);
    HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
    if ((localHotChatManager != null) && (localHotChatManager.kj(paramMessageRecord.frienduin))) {}
    for (boolean bool = true; a(paramView, paramMessageRecord, bool); bool = false) {
      return true;
    }
    if (bool)
    {
      paramView = localHotChatManager.a(paramMessageRecord.frienduin);
      if ((paramView != null) && (paramView.isRobotHotChat))
      {
        bool = true;
        label96:
        if (c(paramMessageRecord, bool)) {
          break label153;
        }
        bool = paramMessageRecord.isSelf();
        if ((!bool) && ((localObject == null) || (((acff)localObject).isFriend(paramMessageRecord.senderuin)))) {
          break label155;
        }
      }
      label153:
      label155:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label160;
        }
        return a(paramMessageRecord, bool, paramView);
        bool = false;
        break label96;
        break;
      }
      label160:
      if ((paramView != null) && (paramView.isGameRoom))
      {
        localObject = new ProfileActivity.AllInOne(paramMessageRecord.senderuin, 42);
        ((ProfileActivity.AllInOne)localObject).troopcode = paramView.troopCode;
        ((ProfileActivity.AllInOne)localObject).troopUin = paramMessageRecord.frienduin;
        ((ProfileActivity.AllInOne)localObject).bJa = 113;
        ((ProfileActivity.AllInOne)localObject).ae = stj.a(this.sessionInfo);
        ProfileActivity.b(this.mContext, (ProfileActivity.AllInOne)localObject);
        HotChatManager.bHJ = false;
        return true;
      }
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage, e parame, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (aegu.ag(paramChatMessage))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130851001;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label156;
        }
      }
      label156:
      for (int i = 2130851000;; i = 2130850823)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        parame.b = new adxp(0);
        a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
        a(parame, paramChatMessage);
        b(parame, paramChatMessage);
        return true;
        i = 2130850824;
        break;
      }
    }
    return false;
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    boolean bool;
    int j;
    int k;
    jof.a locala;
    int i;
    if ((this.sessionInfo.cZ == 1) && (jof.a().dd(this.sessionInfo.aTl)))
    {
      bool = true;
      j = -1;
      if (bool) {
        j = jof.aCu;
      }
      if (!jof.a(paramChatMessage)) {
        break label153;
      }
      k = apdg.a().dTy;
      locala = jof.a(paramChatMessage);
      i = k;
    }
    label153:
    TroopInfo localTroopInfo;
    do
    {
      do
      {
        do
        {
          try
          {
            if (!TextUtils.isEmpty(locala.TH)) {
              i = Color.parseColor(locala.TH);
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.app, true, this.mContext.getResources().getString(2131690306), jof.b(paramChatMessage), i, j);
            paramBaseChatItemLayout.HQ.setOnClickListener(null);
            return;
            bool = false;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              i = k;
            }
          }
          if ("1000000".equals(paramChatMessage.senderuin))
          {
            this.bdl = false;
            paramBaseChatItemLayout.setTroopMemberLevel(this.app, false, null, false, -1, j);
            return;
          }
          if ((paramChatMessage instanceof MessageForTroopConfess))
          {
            paramBaseChatItemLayout.setTroopMemberLevel(this.app, false, null, false, -1, j);
            return;
          }
          localObject = apsb.a(paramChatMessage);
          if (localObject != null)
          {
            j = ((apsb.a)localObject).dVC;
            i = ((apsb.a)localObject).dVD;
            if (bool)
            {
              j = jof.aCu;
              i = apdg.a().dTy;
            }
            paramBaseChatItemLayout.setTroopMemberLevel(this.app, true, ((apsb.a)localObject).cqY, false, i, j);
            paramBaseChatItemLayout.HQ.setOnClickListener(this);
            paramBaseChatItemLayout.HQ.setTag(Integer.valueOf(2131364541));
            return;
          }
        } while (paramChatMessage.istroop != 1);
        paramBaseChatItemLayout.setTroopMemberLevel(this.app, false, null, false, -1, j);
        this.bdl = false;
      } while (localTroopManager == null);
      localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
      localObject = (aptw)this.app.getManager(203);
    } while ((localTroopInfo == null) || ((localTroopInfo.cGroupRankSysFlag != 1) && (!((aptw)localObject).gM(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop())));
    a locala1 = (a)paramBaseChatItemLayout.getTag(2131364541);
    Object localObject = locala1;
    if (locala1 == null)
    {
      localObject = new a(null);
      paramBaseChatItemLayout.setTag(2131364541, localObject);
    }
    ((a)localObject).jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    ((a)localObject).isAnonymous = bool;
    ((a)localObject).textColor = j;
    ((a)localObject).f = localTroopInfo;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.b)localObject);
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, e parame)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("self_nickname");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ajlc.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.app);
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() != 0) {}
    }
    else
    {
      localObject2 = ajlg.me(paramChatMessage.senderuin);
    }
    paramBaseChatItemLayout.a(true, (CharSequence)localObject2, this.sessionInfo.a.k, paramChatMessage.isSend(), false, false, false, "", null, "");
    a((String)localObject2, paramChatMessage, paramBaseChatItemLayout, parame);
  }
  
  private boolean c(View paramView, MessageRecord paramMessageRecord)
  {
    Object localObject = apsb.a(paramMessageRecord);
    if (localObject != null)
    {
      a(paramMessageRecord, (apsb.a)localObject);
      return true;
    }
    if (B(paramMessageRecord))
    {
      eS(paramView);
      return true;
    }
    if (jof.a(paramMessageRecord))
    {
      localObject = jof.a(paramMessageRecord);
      if ((paramView == null) || ((((jof.a)localObject).TF == null) && (((jof.a)localObject).flags != 2))) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ChatItemBuilder", 2, "onHeadIconClick : an_id is null");
        }
        return true;
      }
      TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).c(paramMessageRecord.frienduin);
      acms localacms = (acms)this.app.getBusinessHandler(20);
      if (localTroopInfo != null)
      {
        localacms.Fa(localTroopInfo.troopuin);
        localacms.a(1, accc.Z(localTroopInfo.troopuin), 0L, 2, 0, 0, true);
      }
      a(paramView, paramMessageRecord, (jof.a)localObject, a(localTroopInfo));
      anot.a(this.app, "P_CliOper", "Grp_anon", "", "aio", "Clk_head", 0, 0, paramMessageRecord.frienduin, "", "", "");
      return true;
    }
    if ("1000000".equals(paramMessageRecord.senderuin))
    {
      apuh.a(this.app, (Activity)paramView.getContext(), this.sessionInfo.aTl, "1");
      return true;
    }
    return false;
  }
  
  private boolean c(ChatMessage paramChatMessage, e parame, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((!ThemeUtil.isInNightMode(this.app)) && (paramChatMessage.istroop == 10007))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130851001;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label169;
        }
      }
      label169:
      for (int i = 2130851000;; i = 2130850823)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        parame.b = new adxp(0);
        a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
        a(parame, paramChatMessage);
        b(parame, paramChatMessage);
        return true;
        i = 2130850824;
        break;
      }
    }
    return false;
  }
  
  private boolean c(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((aptw)this.app.getManager(203)).c(this.mContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
  }
  
  private boolean d(ChatMessage paramChatMessage, e parame, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (aine.f(this.sessionInfo))
    {
      boolean bool = paramChatMessage.isSend();
      Object localObject1 = SkinEngine.getInstances();
      Object localObject2;
      if (bool)
      {
        i = 2130851001;
        localObject1 = ((SkinEngine)localObject1).getDefaultThemeDrawable(i);
        localObject2 = SkinEngine.getInstances();
        if (!bool) {
          break label159;
        }
      }
      label159:
      for (int i = 2130851000;; i = 2130850823)
      {
        localObject2 = ((SkinEngine)localObject2).getDefaultThemeDrawable(i);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
        localStateListDrawable.addState(new int[] { 16842910 }, (Drawable)localObject2);
        parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
        parame.b = new adxp(0);
        a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
        a(parame, paramChatMessage);
        b(parame, paramChatMessage);
        return true;
        i = 2130850824;
        break;
      }
    }
    return false;
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.app.getManager(60)).a(paramChatMessage.frienduin);
    if (localObject != null)
    {
      bool = ((HotChatInfo)localObject).isGameRoom;
      if (!bool) {
        break label105;
      }
      localObject = ((ardq)this.app.getBusinessHandler(107)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((aree)localObject).qn(paramChatMessage.senderuin);
        if (TextUtils.isEmpty(paramChatMessage)) {
          break label94;
        }
        paramBaseChatItemLayout.a(this.app, true, paramChatMessage);
      }
    }
    label94:
    label105:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramBaseChatItemLayout.a(this.app, false, paramChatMessage);
        return;
        localObject = (TroopManager)this.app.getManager(52);
      } while (localObject == null);
      paramChatMessage = ((TroopManager)localObject).b(paramChatMessage.frienduin, paramChatMessage.senderuin);
    } while (paramChatMessage == null);
    localObject = this.app;
    if (paramChatMessage.hotChatGlamourLevel >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.a((QQAppInterface)localObject, bool, paramChatMessage.hotChatGlamourLevel, false);
      if (paramBaseChatItemLayout.HR == null) {
        break;
      }
      paramBaseChatItemLayout.HR.setOnClickListener(this);
      paramBaseChatItemLayout.HR.setTag(Integer.valueOf(2131364539));
      return;
    }
  }
  
  private boolean e(ChatMessage paramChatMessage, e parame, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject;
    if (((paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 1)) && (paramChatMessage.isShowQIMStyleGroup))
    {
      if (paramChatMessage.istroop == 1) {
        anot.a(this.app, "CliOper", "", "", "0X80085A6", "0X80085A6", 2, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject = parame.jdField_E_of_type_AndroidViewView.getResources().getDrawable(2130838319);
        parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
        parame.b = new adxp(0);
        a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
        a(parame, paramChatMessage);
        b(parame, paramChatMessage);
        return true;
        if (paramChatMessage.istroop == 3000) {
          anot.a(this.app, "CliOper", "", "", "0X80085A5", "0X80085A5", 2, 0, "", "", "", "");
        }
      }
    }
    if (this.sessionInfo.cZ == 0)
    {
      paramChatMessage.isShowQIMStyleGroup = xva.a().a(this, this.sessionInfo);
      if (paramChatMessage.isShowQIMStyleGroup)
      {
        anot.a(this.app, "CliOper", "", "", "0X80085A4", "0X80085A4", 3, 0, "", "", "", "");
        boolean bool;
        int i;
        Drawable localDrawable1;
        label324:
        Drawable localDrawable2;
        if ((!(this instanceof xov)) || ((this instanceof xpc)))
        {
          bool = paramChatMessage.isSend();
          if (this.sessionInfo.isNightMode)
          {
            localObject = parame.jdField_E_of_type_AndroidViewView.getResources();
            if (bool)
            {
              i = 2130851001;
              localDrawable1 = ((Resources)localObject).getDrawable(i);
              localObject = parame.jdField_E_of_type_AndroidViewView.getResources();
              if (!bool) {
                break label428;
              }
              i = 2130851000;
              localDrawable2 = ((Resources)localObject).getDrawable(i);
              localObject = new StateListDrawable();
              ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
              ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            }
          }
        }
        for (;;)
        {
          parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          parame.b = new adxp(0);
          a(parame, paramBaseChatItemLayout, paramChatMessage, parame.b);
          a(parame, paramChatMessage);
          b(parame, paramChatMessage);
          return true;
          i = 2130850824;
          break;
          label428:
          i = 2130850823;
          break label324;
          localObject = SkinEngine.getInstances();
          if (bool)
          {
            i = 2130851001;
            label451:
            localDrawable1 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = SkinEngine.getInstances();
            if (!bool) {
              break label536;
            }
          }
          label536:
          for (i = 2130851000;; i = 2130850823)
          {
            localDrawable2 = ((SkinEngine)localObject).getDefaultThemeDrawable(i);
            localObject = new StateListDrawable();
            ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localDrawable1);
            ((StateListDrawable)localObject).addState(new int[] { 16842910 }, localDrawable2);
            break;
            i = 2130850824;
            break label451;
          }
          if (!paramChatMessage.isSend()) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label583;
            }
            localObject = parame.jdField_E_of_type_AndroidViewView.getResources().getDrawable(2130838318);
            break;
          }
          label583:
          localObject = parame.jdField_E_of_type_AndroidViewView.getResources().getDrawable(2130838319);
        }
      }
    }
    return false;
  }
  
  private void eS(View paramView)
  {
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
    if ((localTroopInfo != null) && (localTroopInfo.associatePubAccount != 0L))
    {
      Intent localIntent = new Intent(paramView.getContext(), AccountDetailActivity.class);
      localIntent.putExtra("uin", localTroopInfo.associatePubAccount + "");
      paramView.getContext().startActivity(localIntent);
    }
  }
  
  private final boolean h(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPoke)) {}
    while ((paramChatMessage instanceof MessageForPokeEmo)) {
      return true;
    }
    return false;
  }
  
  public boolean G(MessageRecord paramMessageRecord)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = apuh.c(this.app, paramMessageRecord, this.app.getCurrentAccountUin());
    if (((l - paramMessageRecord.time * 1000L < 120000L) && (!bool)) || ((bool) && (paramMessageRecord.isSend())) || (paramMessageRecord.msgtype == -2005) || (apuh.a(this.app, paramMessageRecord, this.app.getCurrentAccountUin()))) {}
    for (this.bdp = true;; this.bdp = false) {
      return this.bdp;
    }
  }
  
  public boolean Rk()
  {
    return BaseChatItemLayout.bdx;
  }
  
  protected boolean Rl()
  {
    if ((this.sessionInfo.cZ == 0) || (this.sessionInfo.cZ == 1) || (this.sessionInfo.cZ == 3000) || (this.sessionInfo.cZ == 1008))
    {
      if (this.sessionInfo.cZ == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
        if ((localHotChatManager != null) && (localHotChatManager.kj(this.sessionInfo.aTl))) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  protected boolean Rm()
  {
    if ((this.sessionInfo.cZ == 1) && (((apsw)this.app.getManager(48)).a(this.sessionInfo.aTl, true).cSk))
    {
      QQToast.a(this.app.getApp(), 2131699615, 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return true;
    }
    return false;
  }
  
  public abstract int a(ChatMessage paramChatMessage);
  
  protected Drawable a(BaseChatItemLayout paramBaseChatItemLayout, int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Aqdf == null) {
      return null;
    }
    e locale = (e)paramBaseChatItemLayout.getTag();
    if (locale != null)
    {
      locale.uin = paramString;
      locale.aRY = paramInt;
      paramBaseChatItemLayout.setTag(locale);
    }
    paramBaseChatItemLayout = this.jdField_d_of_type_Aqdf.b(paramInt, paramString, 6);
    if (paramBaseChatItemLayout == null)
    {
      if (!this.jdField_d_of_type_Aqdf.isPausing()) {
        this.jdField_d_of_type_Aqdf.i(paramString, paramInt, true);
      }
      return aqhu.at();
    }
    return new BitmapDrawable(this.mContext.getResources(), paramBaseChatItemLayout);
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleView", 2, " getView position = " + paramInt1 + ", msgseq = " + paramChatMessage.msgseq + ", shmsgseq = " + paramChatMessage.shmsgseq);
    }
    this.mParentView = paramViewGroup;
    Context localContext = paramViewGroup.getContext();
    try
    {
      paramView = (BaseChatItemLayout)paramView;
      bool = AppSetting.enableTalkBack;
      if (paramView == null)
      {
        paramView = new BaseChatItemLayout(localContext);
        paramView.setId(2131363321);
        paramView.setFocusableInTouchMode(true);
        localObject1 = a();
        paramView.setTag(localObject1);
        ((e)localObject1).a = paramView;
        if (!bool) {
          break label1330;
        }
        ((e)localObject1).jdField_E_of_type_JavaLangStringBuilder = new StringBuilder();
        paramView.setPadding(BaseChatItemLayout.paddingLeft, BaseChatItemLayout.paddingTop, BaseChatItemLayout.paddingRight, BaseChatItemLayout.paddingBottom);
        if ((bool) && (((e)localObject1).jdField_E_of_type_JavaLangStringBuilder == null)) {
          ((e)localObject1).jdField_E_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        ((e)localObject1).pos = paramInt1;
        ((e)localObject1).count = paramInt2;
        localObject2 = null;
        localObject3 = localObject2;
        if (bool)
        {
          paramView.setContentDescription(null);
          if (!TextUtils.isEmpty(((e)localObject1).jdField_E_of_type_JavaLangStringBuilder)) {
            ((e)localObject1).jdField_E_of_type_JavaLangStringBuilder.replace(0, ((e)localObject1).jdField_E_of_type_JavaLangStringBuilder.length(), "");
          }
          localObject3 = localObject2;
          if (paramChatMessage.mNeedTimeStamp)
          {
            localObject3 = localObject2;
            if (paramChatMessage.time <= 0L) {}
          }
        }
      }
    }
    catch (Exception paramView)
    {
      label1330:
      for (;;)
      {
        try
        {
          boolean bool;
          Object localObject2 = aqmu.a(localContext, 3, paramChatMessage.time * 1000L);
          ((e)localObject1).jdField_E_of_type_JavaLangStringBuilder.append(" ").append((CharSequence)localObject2).append(" ");
          Object localObject3 = localObject2;
          ((e)localObject1).mMessage = paramChatMessage;
          if (paramChatMessage.isSend())
          {
            i = 1;
            paramView.setHearIconPosition(i);
            if (this.sessionInfo.a != null)
            {
              ColorStateList localColorStateList = this.sessionInfo.a.k;
              localObject2 = localColorStateList;
              if (!this.bdo)
              {
                localObject2 = localColorStateList;
                if (!this.bdn)
                {
                  localObject2 = localColorStateList;
                  if (this.sessionInfo.cZ == 1)
                  {
                    localObject2 = localColorStateList;
                    if (jof.a().dd(this.sessionInfo.aTl)) {
                      localObject2 = ColorStateList.valueOf(jof.aCt);
                    }
                  }
                }
              }
              if (this.sessionInfo.cZ == 1033) {
                localObject2 = ColorStateList.valueOf(jof.aCt);
              }
              paramView.setTimeStamp(paramChatMessage.mNeedTimeStamp, paramChatMessage, (ColorStateList)localObject2, localObject3);
            }
            if (!apsa.B(paramChatMessage)) {
              continue;
            }
            paramView.setGrayTipsText(true, paramChatMessage, localContext.getString(2131698662), this.mContext.getResources().getColorStateList(2131165571), 0);
            a(paramInt1, paramChatMessage, paramView, paramViewGroup);
            a(paramChatMessage, paramView);
            paramView.a(this, this.app, paramChatMessage);
            a(paramChatMessage, paramView, paramInt1, paramInt2);
            if (paramChatMessage.fakeSenderType != 1) {
              continue;
            }
            paramView.a(false, null, null, false, false, false, false, "", null, null);
            if (paramView.an != null) {
              paramView.an.setOnClickListener(this);
            }
            if (!b(paramChatMessage, paramView)) {
              continue;
            }
            paramView.setProgressVisable(false);
            paramView.setNetIconVisible(false);
            ((e)localObject1).a.setMiniAioShieldItemTouchListener(null);
            paramViewGroup = a(paramChatMessage, (e)localObject1, ((e)localObject1).jdField_E_of_type_AndroidViewView, paramView, paramwlz);
            ((e)localObject1).jdField_E_of_type_AndroidViewView = paramViewGroup;
            a(paramViewGroup, paramView);
            a(paramChatMessage, localContext, paramView, (e)localObject1, paramInt1, paramInt2);
            if (bool)
            {
              ((e)localObject1).jdField_E_of_type_JavaLangStringBuilder.append(b(paramChatMessage));
              paramwlz = Spannable.Factory.getInstance().newSpannable(((e)localObject1).jdField_E_of_type_JavaLangStringBuilder.toString());
              if (!Linkify.addLinks(paramwlz, 15)) {
                continue;
              }
              paramView.setContentDescription(paramwlz);
              paramView.setFocusable(true);
            }
            ((e)localObject1).a.removeAllStickers();
            aqmq.track(null, "AIO_Handle_Sticker_Cost");
            long l = System.currentTimeMillis();
            a(localContext, paramViewGroup, paramChatMessage, paramView, (e)localObject1);
            aqmq.track("AIO_Handle_Sticker_Cost", null);
            if (QLog.isColorLevel()) {
              QLog.d("ChatItemBuilder", 2, "handleStickers time cost : " + (System.currentTimeMillis() - l) + " ms");
            }
            if ((!paramChatMessage.mMsgAnimFlag) || (paramView.a == null) || (h(paramChatMessage))) {
              continue;
            }
            paramChatMessage.mMsgAnimFlag = false;
            paramInt2 = wja.dp2px(30.0F, this.mContext.getResources());
            paramInt1 = paramInt2;
            if (!paramChatMessage.isSend()) {
              paramInt1 = paramInt2 * -1;
            }
            paramView.a(paramChatMessage, paramInt1, 0.0F, 0.0F, 1.0F, this);
            paramView.a(localContext, this.adapter);
            paramView.requestLayout();
            return paramView;
            paramView = paramView;
            localObject1 = "";
            paramView = (View)localObject1;
            if (localContext != null)
            {
              paramView = (View)localObject1;
              if ((localContext instanceof Activity)) {
                paramView = localContext.getClass().getName();
              }
            }
            QLog.e("BaseBubbleBuilder", 1, paramView + " baseBubbleBuilderCatchedException " + paramChatMessage.msgtype);
            paramView = null;
            continue;
            localObject2 = (e)paramView.getTag();
            localObject1 = localObject2;
            if (!a((e)localObject2))
            {
              QLog.e("BubbleView", 1, "getView checkHolderTypeOk failed holder :" + localObject2 + "  this:" + this);
              localObject2 = a();
              paramView.setTag(localObject2);
              ((e)localObject2).a = paramView;
              localObject1 = localObject2;
              if (bool)
              {
                ((e)localObject2).jdField_E_of_type_JavaLangStringBuilder = new StringBuilder();
                localObject1 = localObject2;
              }
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          String str = "";
          continue;
          int i = 0;
          continue;
          paramView.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.mContext.getResources().getColorStateList(2131165571), 235);
          continue;
          if (paramChatMessage.fakeSenderType == 2)
          {
            if (jof.a(paramChatMessage)) {
              b(paramChatMessage, paramView, (e)localObject1);
            } else {
              c(paramChatMessage, paramView, (e)localObject1);
            }
          }
          else if (((paramChatMessage.istroop == 0) || (paramChatMessage.istroop == 3000)) && (paramChatMessage.isMultiMsg))
          {
            c(paramChatMessage, paramView, (e)localObject1);
          }
          else if (paramChatMessage.istroop == 1)
          {
            paramViewGroup = (HotChatManager)this.app.getManager(60);
            if ((paramViewGroup != null) && (paramViewGroup.kj(this.sessionInfo.aTl)))
            {
              b(paramChatMessage, paramView);
              e(paramChatMessage, paramView);
              b(paramChatMessage, paramView, (e)localObject1);
              d(paramChatMessage, paramView);
            }
            else
            {
              c(paramChatMessage, paramView);
            }
          }
          else
          {
            a(paramChatMessage, paramView, (e)localObject1);
            continue;
            f(paramChatMessage, paramView);
            continue;
            paramView.setContentDescription(((e)localObject1).jdField_E_of_type_JavaLangStringBuilder.toString());
            continue;
            paramView.r(paramChatMessage);
          }
        }
      }
    }
  }
  
  protected abstract View a(ChatMessage paramChatMessage, e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz);
  
  public d a(View paramView)
  {
    return null;
  }
  
  protected abstract e a();
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2131377133: 
      k(paramChatMessage);
      return;
    case 2131362505: 
      i(paramChatMessage);
      return;
    case 2131377153: 
      l(paramChatMessage);
      return;
    }
    n(paramChatMessage);
  }
  
  protected void a(int paramInt, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, ViewGroup paramViewGroup)
  {
    if (!ajlg.aJ(paramChatMessage)) {}
    for (int i = 1;; i = 0)
    {
      AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
      int j = i;
      if (localAIOLongShotHelper != null)
      {
        j = i;
        if (localAIOLongShotHelper.RS()) {
          j = 1;
        }
      }
      if (j != 0) {
        paramBaseChatItemLayout.setCheckBox(paramInt, paramChatMessage, paramBaseChatItemLayout, this.app, this.sessionInfo, paramViewGroup);
      }
      return;
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    int j = BaseChatItemLayout.bNV;
    int i = j;
    if (ansy.U(paramChatMessage)) {
      i = j - wja.dp2px(10.0F, paramView.getResources());
    }
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.bNY, i, BaseChatItemLayout.bNX, BaseChatItemLayout.bNW);
      return;
    }
    paramView.setPadding(BaseChatItemLayout.bNX, i, BaseChatItemLayout.bNY, BaseChatItemLayout.bNW);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    f(paramChatMessage, (BaseChatItemLayout)paramView);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    if ((this.b == null) || (paramadxp == null)) {
      return;
    }
    int k = 0;
    int m = 0;
    int n = 0;
    Object localObject3 = null;
    adxm localadxm = null;
    Pair localPair = null;
    BubbleManager localBubbleManager = (BubbleManager)this.app.getManager(44);
    Object localObject2;
    label63:
    Object localObject1;
    if (aofy.Z(paramChatMessage.msg))
    {
      localObject2 = aofy.iF(paramChatMessage.msg);
      if ((localBubbleManager == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label881;
      }
      localObject1 = localBubbleManager.a(paramadxp.bubbleId, false);
      if ((localObject1 == null) || (((adxm)localObject1).jO == null) || (!((adxm)localObject1).ll((String)localObject2))) {
        break label881;
      }
    }
    label384:
    label851:
    label857:
    label863:
    label870:
    label881:
    for (int i = 1;; i = 0)
    {
      localObject1 = localadxm;
      int j = k;
      Object localObject4;
      if ((paramChatMessage instanceof MessageForText))
      {
        localObject4 = paramadxp.ka((String)localObject2);
        localObject1 = localadxm;
        localObject3 = localObject4;
        j = k;
        if (localObject4 != null)
        {
          localObject1 = paramadxp.a(this.app, 1);
          if ((localObject1 == null) || (((Pair)localObject1).first == null)) {
            break label870;
          }
          j = 1;
          localObject3 = localObject4;
        }
      }
      for (;;)
      {
        k = m;
        if ((paramChatMessage instanceof MessageForText))
        {
          localPair = paramadxp.a(this.app, 6);
          if ((localPair == null) || (localPair.first == null)) {
            break label863;
          }
        }
        for (k = 1;; k = m)
        {
          m = n;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            m = n;
            if ((paramChatMessage instanceof MessageForText))
            {
              m = n;
              if (VersionUtils.isHoneycomb())
              {
                localObject2 = paramadxp.a(this.app, 3);
                m = n;
                if (localObject2 != null)
                {
                  m = n;
                  if (((Pair)localObject2).first != null)
                  {
                    m = n;
                    if (paramView.getWidth() > ((adxp.a)((Pair)localObject2).first).g.cKH) {
                      m = 1;
                    }
                  }
                }
              }
            }
          }
          if ((localBubbleManager != null) && ((paramChatMessage instanceof MessageForText)))
          {
            localadxm = localBubbleManager.a(paramadxp.bubbleId, false);
            if ((localadxm != null) && (localadxm.f != null) && (localadxm.f.cKI != 0) && (VersionUtils.isHoneycomb())) {
              if (paramChatMessage.isSend())
              {
                localObject2 = paramChatMessage.selfuin;
                localObject4 = (acff)this.app.getManager(51);
                if (localObject4 == null) {
                  break label857;
                }
                localObject2 = ((acff)localObject4).a((String)localObject2);
                if ((localObject2 == null) || ((localadxm.f.cKI != -1) && (((ExtensionInfo)localObject2).pendantId != localadxm.f.cKI))) {
                  break label857;
                }
              }
            }
          }
          for (n = 1;; n = 0)
          {
            if (i != 0)
            {
              long l = adxq.a(this.app, paramChatMessage, this.sessionInfo, this.b);
              if (l != -1L) {
                this.b.a(5, 150, new Object[] { Integer.valueOf(8), Long.valueOf(paramChatMessage.uniseq), Long.valueOf(l) });
              }
            }
            if ((j != 0) || (m != 0) || (n != 0) || (k != 0)) {
              this.b.stop(0);
            }
            if (j != 0)
            {
              F("keyword_trigger", paramadxp.bubbleId, localObject3);
              this.b.a(0, 100, new Object[] { Integer.valueOf(1), Long.valueOf(paramChatMessage.uniseq), localObject1 });
            }
            if (k != 0) {
              this.b.a(0, 100, new Object[] { Integer.valueOf(6), Long.valueOf(paramChatMessage.uniseq), localPair });
            }
            if ((m != 0) || (n != 0)) {
              if (m == 0) {
                break label851;
              }
            }
            for (i = 3;; i = 5)
            {
              this.b.a(0, 100, new Object[] { Integer.valueOf(i), Long.valueOf(paramChatMessage.uniseq), Integer.valueOf(paramadxp.bubbleId), this.app });
              if (!paramadxp.iT(paramView.getHeight())) {
                break;
              }
              paramView = paramadxp.a(this.app, 2);
              if ((paramView == null) || (paramView.first == null)) {
                break;
              }
              F("wordnum_trigger", paramadxp.bubbleId, null);
              this.b.a(0, 100, new Object[] { Integer.valueOf(2), Long.valueOf(paramChatMessage.uniseq), paramView });
              return;
              localObject2 = paramChatMessage.msg;
              break label63;
              if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
              {
                localObject2 = paramChatMessage.frienduin;
                break label384;
              }
              localObject2 = paramChatMessage.senderuin;
              break label384;
            }
          }
        }
        localObject3 = localObject4;
        j = k;
      }
    }
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage, adxp paramadxp, int paramInt)
  {
    if (this.b == null) {}
    do
    {
      return;
      paramView = paramadxp.a(this.app, 0);
    } while ((paramView == null) || (paramView.first == null));
    gt();
    this.b.a(0, 100, new Object[] { Integer.valueOf(0), Long.valueOf(paramChatMessage.uniseq), paramView });
  }
  
  public void a(View paramView, wlz paramwlz)
  {
    if (aqfl.bx(false))
    {
      aqfl.a locala = new aqfl.a();
      aqfl.a(this.mContext, locala, paramwlz);
      paramView.setOnTouchListener(locala);
      paramView.setOnLongClickListener(locala);
      return;
    }
    paramView.setOnTouchListener(paramwlz);
    paramView.setOnLongClickListener(paramwlz);
  }
  
  protected void a(TextView paramTextView, MessageRecord paramMessageRecord)
  {
    if (!apri.i(this.app, this.sessionInfo)) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      paramMessageRecord = ((apri)this.app.getManager(262)).a(this.sessionInfo, paramMessageRecord);
      if ((paramMessageRecord != null) && (paramMessageRecord.action != -1))
      {
        ((Spannable)paramTextView.getText()).setSpan(new apri.b(this.app, this.mContext, paramMessageRecord), paramMessageRecord.ahi, paramMessageRecord.adh, 17);
        paramTextView.setTag(2131367211, "school_troop_span");
      }
    } while (!QLog.isColorLevel());
    QLog.i("school_troop.BaseBubbleBuilder", 2, " updateSchoolTroopHighlight time cost: " + (System.currentTimeMillis() - l));
  }
  
  public void a(aqdf paramaqdf)
  {
    this.jdField_d_of_type_Aqdf = paramaqdf;
  }
  
  protected void a(aqoa paramaqoa, int paramInt, MessageRecord paramMessageRecord)
  {
    if (!G(paramMessageRecord)) {}
    do
    {
      return;
      if ((!paramMessageRecord.isSend()) && (!apuh.a(this.app, paramMessageRecord, this.app.getCurrentAccountUin())))
      {
        this.bdp = false;
        return;
      }
      if ((jof.a(paramMessageRecord)) && (!aeoj.a().bUz))
      {
        this.bdp = false;
        return;
      }
      if (top.eD(this.sessionInfo.cZ) == 1032)
      {
        this.bdp = false;
        return;
      }
      Object localObject = (acff)this.app.getManager(51);
      if ((this.sessionInfo.cZ == 0) && (!((acff)localObject).isFriend(this.sessionInfo.aTl)))
      {
        this.bdp = false;
        return;
      }
      if (paramInt == 1)
      {
        localObject = (HotChatManager)this.app.getManager(60);
        if ((localObject != null) && (((HotChatManager)localObject).kj(paramMessageRecord.frienduin)))
        {
          this.bdp = false;
          return;
        }
      }
      if ((paramMessageRecord.msgtype == -5008) && ((paramMessageRecord instanceof MessageForArkApp)))
      {
        localObject = (MessageForArkApp)paramMessageRecord;
        if ((((MessageForArkApp)localObject).ark_app_message != null) && (((MessageForArkApp)localObject).ark_app_message.appName.equals("com.tencent.mannounce")))
        {
          this.bdp = false;
          return;
        }
      }
    } while (!H(paramMessageRecord));
    b(paramaqoa, paramMessageRecord);
  }
  
  protected void a(aqoa paramaqoa, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(aqoa paramaqoa, Context paramContext, ChatMessage paramChatMessage, boolean paramBoolean) {}
  
  public void a(aqoa paramaqoa, MessageRecord paramMessageRecord)
  {
    if ((!this.bdp) || ((paramMessageRecord != null) && (!paramMessageRecord.isSend()))) {
      ujt.a(paramaqoa, this.mContext, this.sessionInfo.cZ);
    }
    this.bdp = false;
  }
  
  protected void a(e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp) {}
  
  protected void a(e parame, ChatMessage paramChatMessage) {}
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, e parame, int paramInt1, int paramInt2)
  {
    if ((this.sessionInfo.beB) || ((paramContext instanceof MultiForwardActivity))) {}
    for (boolean bool = false;; bool = true) {
      try
      {
        i = a(paramChatMessage);
        parame.bvc = i;
        if (i != 0) {
          if (a(paramChatMessage, parame, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setSimpleUIMsgBubble " + paramChatMessage.getLogColorContent());
            }
            if (parame.jdField_E_of_type_AndroidViewView != null)
            {
              paramBaseChatItemLayout.setBubbleView(parame.jdField_E_of_type_AndroidViewView);
              a(parame.jdField_E_of_type_AndroidViewView, paramChatMessage);
              parame.jdField_E_of_type_AndroidViewView.setTag(2131364051, parame.b);
              parame.jdField_E_of_type_AndroidViewView.setTag(2131364546, paramChatMessage);
            }
            return;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("ChatItemBuilder", 1, "getBubbleType error : " + localException);
          int i = 0;
          continue;
          if (b(paramChatMessage, parame, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setConfessMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (e(paramChatMessage, parame, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setQimMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (d(paramChatMessage, parame, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setLimitChatMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else if (c(paramChatMessage, parame, paramBaseChatItemLayout))
          {
            if (QLog.isColorLevel()) {
              QLog.e("ChatItemBuilder", 2, "setGameMsgBubble " + paramChatMessage.getLogColorContent());
            }
          }
          else
          {
            a(paramChatMessage, paramContext, paramBaseChatItemLayout, parame, paramInt1, paramInt2, bool, i);
            continue;
            if (parame.jdField_E_of_type_AndroidViewView == null)
            {
              QLog.e("ChatItemBuilder", 1, "handleBubbleBg mContent is null type = " + paramChatMessage.istroop);
              return;
            }
            parame.jdField_E_of_type_AndroidViewView.setBackgroundDrawable(null);
          }
        }
      }
    }
  }
  
  protected void a(ChatMessage paramChatMessage, aqoa paramaqoa)
  {
    if ((paramChatMessage == null) || (paramChatMessage.shmsgseq == 0L)) {}
    do
    {
      do
      {
        return;
      } while ((paramChatMessage.istroop != 1) && (paramChatMessage.istroop != 3000) && (this.sessionInfo.cZ != 0));
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.app.getCurrentUin())) && (paramChatMessage.isSupportReply()))
      {
        paramaqoa.Z(2131377133, this.mContext.getString(2131699906), 2130839090);
        MessageForReplyText.reportReplyMsg(this.app, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (!paramChatMessage.isSupportReply()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768) || (paramChatMessage.istroop == 3000));
    paramaqoa.Z(2131377133, this.mContext.getString(2131699906), 2130839090);
    MessageForReplyText.reportReplyMsg(this.app, "Msg_menu", "exp_replyMsg", paramChatMessage.frienduin, paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if ((aegu.ag(paramChatMessage)) && (QLog.isColorLevel())) {
      QLog.d("ChatItemBuilder", 2, "confessType =  " + paramChatMessage.istroop + " isSend = " + paramChatMessage.isSend());
    }
    Object localObject1;
    if (paramChatMessage.fakeSenderType == 1)
    {
      localObject1 = this.app.getCurrentAccountUin();
      paramBaseChatItemLayout.setHeaderIcon(aqdj.a(this.app, 1, (String)localObject1));
      paramBaseChatItemLayout.a.setTag(paramChatMessage);
      paramBaseChatItemLayout.a.setOnClickListener(null);
      paramBaseChatItemLayout.a.setOnLongClickListener(null);
      return;
    }
    int i;
    if (aegu.H(paramChatMessage))
    {
      if (((aegs)this.app.getManager(269)).a().a(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.getConfessTopicId()).confessorSex == 1) {}
      for (i = 2130845875;; i = 2130845874)
      {
        paramBaseChatItemLayout.setHeaderIcon(this.mContext.getResources().getDrawable(i));
        paramBaseChatItemLayout.a.setTag(paramChatMessage);
        paramBaseChatItemLayout.a.setOnClickListener(null);
        paramBaseChatItemLayout.a.setOnLongClickListener(null);
        return;
      }
    }
    if (paramChatMessage.istroop == 10007) {
      if (paramChatMessage.isSend())
      {
        localObject1 = ahtd.r(paramChatMessage);
        label230:
        localObject1 = ahtc.a(this.mContext, this.app, (String)localObject1);
        if (localObject1 != null) {
          break label365;
        }
        paramBaseChatItemLayout.setHeaderIcon(this.mContext.getResources().getDrawable(2130840645));
        label267:
        if (!(this.mContext instanceof FragmentActivity)) {
          break label1870;
        }
        localObject1 = ((FragmentActivity)this.mContext).getChatFragment();
        if (localObject1 == null) {
          break label1870;
        }
        localObject1 = ((ChatFragment)localObject1).a();
        if (!(localObject1 instanceof xzk)) {
          break label1870;
        }
        localObject1 = (xzk)localObject1;
        if (!paramChatMessage.isSend()) {
          break label374;
        }
        localObject1 = ((xzk)localObject1).a();
      }
    }
    for (;;)
    {
      for (;;)
      {
        paramBaseChatItemLayout.a.setOnClickListener((View.OnClickListener)localObject1);
        paramBaseChatItemLayout.a.setOnLongClickListener(null);
        paramBaseChatItemLayout.a.setTag(paramChatMessage);
        return;
        localObject1 = ahtd.s(paramChatMessage);
        break label230;
        label365:
        paramBaseChatItemLayout.setHeaderIcon(localObject1);
        break label267;
        label374:
        localObject1 = ((xzk)localObject1).b();
        continue;
        Object localObject4;
        if (jof.a(paramChatMessage))
        {
          localObject1 = this.mContext.getResources().getDrawable(2130844459);
          localObject4 = jof.a(paramChatMessage);
          paramChatMessage = URLDrawable.getDrawable(jof.aV(((jof.a)localObject4).aCv), (Drawable)localObject1, (Drawable)localObject1);
          localObject1 = ((jof.a)localObject4).TH;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
        try
        {
          i = aqcx.dip2px(this.mContext, 1.0F);
          paramChatMessage.setTag(new int[] { Color.parseColor((String)localObject1), i });
          paramChatMessage.setDecodeHandler(aqbn.q);
          paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
          paramBaseChatItemLayout.a.setOnClickListener(this);
          paramBaseChatItemLayout.a.setOnLongClickListener(null);
          return;
          if (((paramChatMessage instanceof MessageForStructing)) && (apsa.B(paramChatMessage)))
          {
            paramBaseChatItemLayout.setHeaderIcon(this.mContext.getResources().getDrawable(2130841033));
            paramBaseChatItemLayout.a.setOnClickListener(this);
            paramBaseChatItemLayout.a.setOnLongClickListener(null);
            return;
          }
          localObject1 = apsb.a(paramChatMessage);
          if (localObject1 != null)
          {
            localObject4 = this.mContext.getResources().getDrawable(2130840645);
            paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
            paramChatMessage.mFailedDrawable = ((Drawable)localObject4);
            paramChatMessage.mLoadingDrawable = ((Drawable)localObject4);
            for (;;)
            {
              try
              {
                paramChatMessage = URLDrawable.getDrawable(new URL(((apsb.a)localObject1).headUrl), paramChatMessage);
                localMalformedURLException1.printStackTrace();
              }
              catch (MalformedURLException localMalformedURLException1)
              {
                try
                {
                  paramChatMessage.setTag(aqbn.d(100, 100, 6));
                  paramChatMessage.setDecodeHandler(aqbn.b);
                  paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
                  if (paramChatMessage == null) {
                    break label670;
                  }
                  paramBaseChatItemLayout.setHeaderIcon(paramChatMessage);
                  paramBaseChatItemLayout.a.setOnClickListener(this);
                  paramBaseChatItemLayout.a.setOnLongClickListener(null);
                  return;
                }
                catch (MalformedURLException localMalformedURLException2)
                {
                  int k;
                  String str;
                  Object localObject2;
                  int j;
                  break label662;
                }
                localMalformedURLException1 = localMalformedURLException1;
                paramChatMessage = null;
              }
              label662:
              continue;
              label670:
              paramBaseChatItemLayout.setHeaderIcon(localObject4);
            }
          }
          k = paramChatMessage.istroop;
          if (paramChatMessage.isSend())
          {
            str = paramChatMessage.selfuin;
            localObject2 = this.app.a(str, false);
            if ((localObject2 != null) && (((ExtensionInfo)localObject2).faceIdUpdateTime < paramChatMessage.time))
            {
              localObject4 = paramChatMessage.getExtInfoFromExtStr("vip_face_id");
              if (QLog.isColorLevel()) {
                QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id = " + (String)localObject4);
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (Long.parseLong((String)localObject4) != ((ExtensionInfo)localObject2).faceId))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ChatItemBuilder", 2, "handleHeadIcon: message id not equals local");
                }
                aqgm.UC(str);
                aqgm.ez(this.app);
              }
            }
            localObject2 = (acff)this.app.getManager(51);
            localObject4 = (HotChatManager)this.app.getManager(60);
            if ((localObject4 == null) || (!((HotChatManager)localObject4).kj(paramChatMessage.frienduin))) {
              break label1574;
            }
            i = 1;
            label867:
            if ((localObject2 == null) || (!((acff)localObject2).isFriend(str))) {
              break label1579;
            }
            j = 1;
            label885:
            if (((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!str.equals(this.app.getCurrentAccountUin())))) && ((k != 1022) || ((this.sessionInfo.bPt != 3007) && (this.sessionInfo.bPt != 2007) && (this.sessionInfo.bPt != 4007) && (this.sessionInfo.bPt != 3019) && (this.sessionInfo.bPt != 2019)))) || (localObject2 == null) || (((acff)localObject2).isFriend(this.sessionInfo.aTl))) {
              break label1621;
            }
            localObject4 = ((HotChatManager)localObject4).a(paramChatMessage.frienduin);
            if ((localObject4 == null) || (!((HotChatInfo)localObject4).isGameRoom)) {
              break label1603;
            }
            if ((!((acff)localObject2).isFriend(str)) && (!str.equals(this.app.getCurrentAccountUin()))) {
              break label1585;
            }
            localObject4 = aqdj.a(this.app, 1, str);
            label1087:
            localObject2 = localObject4;
            if (QLog.isColorLevel())
            {
              QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + str);
              localObject2 = localObject4;
            }
            label1129:
            paramBaseChatItemLayout.setHeaderIcon(localObject2);
            if (((paramChatMessage.isSendFromLocal()) || ((k != 1) && (k != 3000) && (k != 0) && (k != 1005) && (k != 1001) && (k != 1006) && (k != 1000) && (k != 10004) && (k != 1004) && (k != 1008) && (k != 1009) && (k != 1010) && (k != 1011) && (k != 1020) && (k != 1021) && (k != 1023) && (k != 1024) && (k != 1036) && (k != 1025) && (k != 10002) && (k != 1022))) && (k != 10008)) {
              break label1810;
            }
            if (!this.app.getCurrentAccountUin().equals(paramChatMessage.senderuin))
            {
              localObject2 = paramChatMessage.frienduin;
              localObject4 = paramChatMessage.senderuin;
              ThreadManager.executeOnSubThread(new ProcessMemberNickTask(this.app, this.mContext, paramBaseChatItemLayout, (String)localObject2, (String)localObject4, k, this.e));
            }
            label1371:
            paramBaseChatItemLayout.a.setOnClickListener(this);
            paramBaseChatItemLayout.a.setTag(paramChatMessage);
            if (QLog.isColorLevel()) {
              QLog.d("BaseBubbleBuilder", 2, "AppSetting.enableTalkBack = " + AppSetting.enableTalkBack);
            }
            if (!AppSetting.enableTalkBack) {
              break;
            }
            localObject4 = "";
            localObject2 = localObject4;
            if (paramChatMessage.istroop != 1)
            {
              localObject2 = localObject4;
              if (paramChatMessage.istroop != 3000) {
                if (!paramChatMessage.isSend()) {
                  break label1821;
                }
              }
            }
          }
          label1810:
          label1821:
          for (localObject2 = acfp.m(2131703055);; localObject2 = this.sessionInfo.aTn + acfp.m(2131703058))
          {
            if (paramChatMessage.msgtype == -3006) {
              localObject2 = String.format(paramBaseChatItemLayout.getResources().getString(2131699890), new Object[] { obt.a(this.app, BaseApplicationImpl.getContext()) });
            }
            paramBaseChatItemLayout.a.setContentDescription((CharSequence)localObject2);
            return;
            if ((paramChatMessage.istroop == 1000) || (paramChatMessage.istroop == 1020) || (paramChatMessage.istroop == 1004))
            {
              str = paramChatMessage.frienduin;
              break;
            }
            str = paramChatMessage.senderuin;
            break;
            label1574:
            i = 0;
            break label867;
            label1579:
            j = 0;
            break label885;
            label1585:
            localObject4 = aqdj.a(this.app, 200, str, true);
            break label1087;
            label1603:
            localObject4 = aqdj.a(this.app, 200, str, true);
            break label1087;
            label1621:
            if ((k == 9501) && (!paramChatMessage.isSend()))
            {
              localObject2 = ((syw)this.app.getBusinessHandler(51)).a(Long.parseLong(str));
              if ((localObject2 != null) && (str.equals(String.valueOf(((DeviceInfo)localObject2).din))))
              {
                localObject2 = new BitmapDrawable(BaseApplication.getContext().getResources(), DeviceHeadMgr.getInstance().getDeviceHeadByDin(str));
                break label1129;
              }
              localObject2 = a(paramBaseChatItemLayout, 1, str);
              break label1129;
            }
            if (k != 1006) {
              break label1865;
            }
            i = 11;
            localObject2 = a(paramBaseChatItemLayout, i, str);
            localObject4 = new aqsg(str, -1, "small", paramChatMessage.uniseq);
            ((aqsg)localObject4).dQ = ((Drawable)localObject2);
            localObject2 = localObject4;
            if (!QLog.isColorLevel()) {
              break label1129;
            }
            QLog.d("BaseBubbleBuilder", 2, "QQ head, uin = " + str);
            localObject2 = localObject4;
            break label1129;
            paramBaseChatItemLayout.a.setOnLongClickListener(null);
            break label1371;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            continue;
            label1865:
            i = 1;
          }
        }
      }
      label1870:
      Object localObject3 = null;
    }
  }
  
  protected void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, int paramInt1, int paramInt2) {}
  
  public void a(MessageRecord paramMessageRecord, View paramView, wla.a parama)
  {
    ambj localambj = (ambj)this.app.getManager(326);
    if ((paramMessageRecord.extraflag != 32772) || (!localambj.a(this.sessionInfo.aTl, paramMessageRecord.uniseq, paramView, parama)))
    {
      paramMessageRecord = wla.a(this.app);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, parama);
      }
    }
  }
  
  public boolean a(e parame)
  {
    return true;
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected void b(aqoa paramaqoa, Context paramContext)
  {
    paramaqoa.Z(2131372134, acfp.m(2131703054), 2130839094);
  }
  
  protected void b(e parame, ChatMessage paramChatMessage) {}
  
  protected void b(ChatMessage paramChatMessage, aqoa paramaqoa)
  {
    boolean bool = true;
    if (this.sessionInfo.cZ == 1)
    {
      if ((!aprg.V(this.app, paramChatMessage.senderuin)) && (!jof.a(paramChatMessage)) && (!aegu.ag(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (paramChatMessage.isSupportReply())) {
        break label151;
      }
      if (QLog.isColorLevel())
      {
        paramaqoa = new StringBuilder("addReplyOnlyMenu isRobot=").append(aprg.V(this.app, paramChatMessage.senderuin)).append(" isAnonymousMsg=").append(jof.a(paramChatMessage)).append(" isConfessMsg=").append(aegu.ag(paramChatMessage)).append(" isNotSupport=");
        if (paramChatMessage.isSupportReply()) {
          break label146;
        }
        QLog.d("ChatItemBuilder", 2, bool);
      }
    }
    label146:
    label151:
    do
    {
      return;
      bool = false;
      break;
      if ((paramChatMessage.senderuin != null) && (!paramChatMessage.senderuin.equals(this.app.getCurrentUin())))
      {
        paramaqoa.Z(2131377153, this.mContext.getString(2131699912), 2130839090);
        return;
      }
    } while ((!paramChatMessage.isSend()) || (paramChatMessage.extraflag == 32772) || (paramChatMessage.extraflag == 32768));
    paramaqoa.Z(2131377153, this.mContext.getString(2131699912), 2130839090);
  }
  
  protected boolean b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (a(paramChatMessage, paramBaseChatItemLayout))
    {
      paramBaseChatItemLayout.setFailedIconVisable(true, this);
      return true;
    }
    paramBaseChatItemLayout.setFailedIconVisable(false, null);
    return false;
  }
  
  public void bYO() {}
  
  protected void c(aqoa paramaqoa, Context paramContext)
  {
    if ((Rl()) && (ajlc.a().aqX())) {
      paramaqoa.Z(2131372073, paramContext.getString(2131696127), 2130839094);
    }
  }
  
  protected void d(aqoa paramaqoa, Context paramContext)
  {
    paramaqoa.Z(2131366733, paramContext.getString(2131693407), 2130839085);
  }
  
  public void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (!apmc.i(this.app, paramChatMessage)) {
      paramBaseChatItemLayout.b.setHonorList(null);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if (!apmc.T(this.app, paramChatMessage.frienduin))
        {
          paramBaseChatItemLayout.b.setHonorList(null);
          return;
        }
      } while (paramChatMessage.istroop != 1);
      paramBaseChatItemLayout.b.setHonorList(null);
      localTroopManager = (TroopManager)this.app.getManager(52);
    } while (!((apmb)this.app.getManager(346)).qD(paramChatMessage.frienduin));
    c localc2 = (c)paramBaseChatItemLayout.getTag(2131364540);
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c(null);
      paramBaseChatItemLayout.setTag(2131364540, localc1);
    }
    localc1.jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    localc1.memberUin = paramChatMessage.senderuin;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, localc1);
  }
  
  public void destroy()
  {
    cV.clear();
    sHandler.removeCallbacksAndMessages(null);
    aqis.a().edT();
  }
  
  protected void e(aqoa paramaqoa, Context paramContext)
  {
    paramaqoa.Z(2131362505, paramContext.getString(2131690234), 2130839094);
  }
  
  protected void eT(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    if (F(localChatMessage)) {}
    while ((E(localChatMessage)) || (localChatMessage == null) || (localChatMessage.istroop != 1) || (!aqft.rl(localChatMessage.senderuin)) || (D(localChatMessage)) || (((aptw)this.app.getManager(203)).c(this.mContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))) {
      return;
    }
    Object localObject2 = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
    int i;
    Object localObject1;
    label153:
    Object localObject3;
    if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
    {
      i = paramView.getId();
      if (i == 2131364541)
      {
        localObject1 = "clk_title";
        anot.a(this.app, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
        localObject3 = aqgv.a(this.app, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
        if (i != 2131364541) {
          break label446;
        }
        i = 2;
        localObject1 = "Clk_label";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = Base64.encodeToString(((String)localObject3).getBytes("UTF-8"), 0);
        localObject2 = a(localChatMessage, i, (String)localObject2);
        paramView = paramView.getContext();
        localObject3 = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("selfSet_leftViewText", acfp.m(2131703052));
        paramView.startActivity((Intent)localObject3);
        localObject3 = this.app;
        String str = localChatMessage.frienduin;
        if (localChatMessage.isSend())
        {
          paramView = "1";
          anot.a((QQAppInterface)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, str, paramView, "", "");
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
          }
          if (this.bNO < 2) {
            break;
          }
          anot.a(this.app, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.sessionInfo.aTl, String.valueOf(this.bNO), "", "");
          return;
          localObject1 = "clk_nickname";
          break label153;
          label446:
          i = 1;
          localObject1 = "Clk_name";
          continue;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:", localException);
        localObject2 = localObject3;
        continue;
        paramView = "0";
        continue;
      }
      if (this.bdl)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick, openLevelPKPage");
        }
        localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        paramView.getContext().startActivity((Intent)localObject1);
        anot.a(this.app, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
      }
    }
  }
  
  protected void ei(View paramView) {}
  
  protected void ej(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    if (localChatMessage == null) {
      break label11;
    }
    label11:
    while (a(paramView, localChatMessage)) {
      return;
    }
    acff localacff = (acff)this.app.getManager(51);
    boolean bool2 = localChatMessage.isSelf();
    boolean bool1;
    String str;
    if (A(localChatMessage))
    {
      bool1 = localacff.isFriend(localChatMessage.senderuin);
      str = localChatMessage.senderuin;
      label69:
      if (str == null) {
        break label155;
      }
      if (!localacff.isFriend(str)) {
        break label486;
      }
      bool1 = true;
    }
    label155:
    label486:
    for (;;)
    {
      Object localObject;
      if (bool2)
      {
        localObject = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
        ((ProfileActivity.AllInOne)localObject).nickname = this.app.getCurrentNickname();
      }
      for (;;)
      {
        a(localChatMessage, str, (ProfileActivity.AllInOne)localObject);
        a(paramView, localChatMessage, localacff, bool1, bool2, str, (ProfileActivity.AllInOne)localObject);
        return;
        str = localChatMessage.frienduin;
        bool1 = false;
        break label69;
        break label11;
        if (localChatMessage.istroop == 1008)
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("need_finish", true);
          ((Intent)localObject).putExtra("uin", this.sessionInfo.aTl);
          ((Intent)localObject).putExtra("uinname", this.sessionInfo.aTn);
          ((Intent)localObject).putExtra("uintype", this.sessionInfo.cZ);
          ocp.a((Intent)localObject, this.app, (Activity)paramView.getContext(), this.sessionInfo.aTl, -1, 2000, 2, ocp.awm);
          return;
        }
        if (localChatMessage.istroop == 1024)
        {
          jqs.a(paramView.getContext(), null, this.sessionInfo.aTl, true, -1, true, 2000);
          return;
        }
        if (bool1)
        {
          localObject = wje.a(this.app, localChatMessage, str);
        }
        else
        {
          if (localChatMessage.istroop == 1025)
          {
            if (this.mContext == null) {
              break;
            }
            paramView = new Intent(this.mContext, ChatSettingActivity.class);
            paramView.putExtra("uin", this.sessionInfo.aTl);
            paramView.putExtra("uinname", this.sessionInfo.aTn);
            paramView.putExtra("uintype", this.sessionInfo.cZ);
            this.mContext.startActivity(paramView);
            return;
          }
          if ((localChatMessage.istroop == 1037) || (top.eD(localChatMessage.istroop) == 1044))
          {
            localObject = new ProfileActivity.AllInOne(this.sessionInfo.aTl, 96);
            ((ProfileActivity.AllInOne)localObject).nickname = this.sessionInfo.aTn;
          }
          else
          {
            localObject = wje.a(this.app, str, this.sessionInfo, localChatMessage);
          }
        }
      }
    }
  }
  
  protected void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = this.app.a().aS(paramChatMessage);
    paramBaseChatItemLayout.setProgressVisable(bool);
    if (!bool) {
      g(paramChatMessage, paramBaseChatItemLayout);
    }
  }
  
  protected void g(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    paramBaseChatItemLayout.setNetIconVisible(paramChatMessage.isSentByXG());
  }
  
  public boolean g(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.senderuin != null) && (paramChatMessage.senderuin.equals(paramChatMessage.selfuin));
  }
  
  protected void gt()
  {
    if (this.b != null) {
      this.b.stop(0);
    }
  }
  
  protected void i(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.mContext;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickScreenShot Error:");
      if (localFragmentActivity != null) {}
      for (paramChatMessage = localFragmentActivity.toString();; paramChatMessage = "ca is null ")
      {
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
        return;
      }
    }
    Object localObject = localFragmentActivity.getChatFragment().a();
    ((AIOLongShotHelper)((BaseChatPie)localObject).a(15)).t(paramChatMessage);
    ((BaseChatPie)localObject).wc(true);
    abrb.b(((BaseChatPie)localObject).app, "select_more_msg", true);
    localObject = "0";
    if (paramChatMessage.istroop == 1) {
      localObject = "2";
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X8009DE5", "0X8009DE5", 1, 0, (String)localObject, "", "", "");
      return;
      if (paramChatMessage.istroop == 0) {
        localObject = "1";
      }
    }
  }
  
  protected void j(ChatMessage paramChatMessage)
  {
    int j;
    int i;
    if ((this.mContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.mContext).getChatFragment();
      BaseChatPie localBaseChatPie = null;
      if (localChatFragment != null) {
        localBaseChatPie = localChatFragment.a();
      }
      if (localBaseChatPie != null) {
        ((wuc)localBaseChatPie.a(46)).u(paramChatMessage);
      }
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label182;
      }
      j = 6;
      i = 4;
    }
    for (;;)
    {
      if (jof.a(paramChatMessage)) {
        anot.a(this.app, "dc00898", "", "", "0X800ADF4", "0X800ADF4", 0, 1, "" + i, "", "", "");
      }
      anot.a(this.app, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "" + j, "", "", "");
      return;
      label182:
      if ((paramChatMessage instanceof MessageForText))
      {
        j = 1;
        i = 1;
      }
      else if ((paramChatMessage instanceof MessageForPic))
      {
        j = 3;
        i = 2;
      }
      else if ((paramChatMessage instanceof MessageForMarketFace))
      {
        j = 4;
        i = 5;
      }
      else if ((paramChatMessage instanceof MessageForApollo))
      {
        j = 5;
        i = 5;
      }
      else if ((paramChatMessage instanceof MessageForVideo))
      {
        j = 0;
        i = 4;
      }
      else
      {
        j = 0;
        i = 5;
      }
    }
  }
  
  protected void k(ChatMessage paramChatMessage)
  {
    if (!Rm())
    {
      Object localObject;
      if ((this.mContext instanceof FragmentActivity))
      {
        localObject = ((FragmentActivity)this.mContext).getChatFragment();
        if (localObject != null) {
          ((ChatFragment)localObject).a().d(paramChatMessage);
        }
      }
      if ((paramChatMessage instanceof MessageForStructing))
      {
        localObject = (MessageForStructing)paramChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mMsgServiceID == 81) && (this.app != null)) {
          rar.a(this.app, this.mContext, (MessageForStructing)localObject, "reply");
        }
      }
      xmb.a(this.app, paramChatMessage, "0X800A368");
    }
  }
  
  protected void l(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "chatMessage is null");
      }
      return;
    }
    ((alvj)this.app.getManager(340)).Y(paramChatMessage);
    Intent localIntent = wja.a(new Intent(this.mContext, SplashActivity.class), new int[] { 1 });
    localIntent.putExtra("uin", paramChatMessage.senderuin);
    Object localObject = new Bundle();
    ((Bundle)localObject).putLong("key_reply_only_uniseq", paramChatMessage.uniseq);
    localIntent.putExtras((Bundle)localObject);
    localObject = ((acff)this.app.getManager(51)).a(paramChatMessage.senderuin);
    localIntent.putExtra("troop_code", this.sessionInfo.aTl);
    int i;
    if ((localObject != null) && (((Friends)localObject).isFriend()))
    {
      localIntent.putExtra("uintype", 0);
      this.mContext.startActivity(localIntent);
      i = 1;
      if (!this.app.getCurrentUin().equals(paramChatMessage.senderuin)) {
        break label317;
      }
      i = 3;
    }
    label317:
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X800A4F5", "0X800A4F5", i, 0, "", "", "", "");
      return;
      localIntent.putExtra("uintype", 1000);
      localIntent.putExtra("uinname", aqgv.p(this.app, this.sessionInfo.aTl, paramChatMessage.senderuin));
      localIntent = new Intent(localIntent);
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        ((TroopManager)localObject).a(this.sessionInfo.aTl, new wkf(this, localIntent));
      }
      i = 2;
      break;
    }
  }
  
  protected void m(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.mContext;
    Object localObject;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      localObject = new StringBuilder().append("onClickSelectMore Error:");
      if (localFragmentActivity != null)
      {
        paramChatMessage = localFragmentActivity.toString();
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
      }
    }
    do
    {
      return;
      paramChatMessage = "ca is null ";
      break;
      localObject = AIOLongShotHelper.a();
      if (localObject != null) {
        ((AIOLongShotHelper)localObject).cbS();
      }
      localObject = localFragmentActivity.getChatFragment().a();
      ((BaseChatPie)localObject).c(paramChatMessage);
      ((BaseChatPie)localObject).wc(true);
      abrb.b(((BaseChatPie)localObject).app, "select_more_msg", true);
    } while (paramChatMessage == null);
    int j;
    int i;
    if (paramChatMessage.istroop == 0)
    {
      j = 1;
      if (!(paramChatMessage instanceof MessageForFile)) {
        break label284;
      }
      i = 6;
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X80059B5", "0X80059B5", 0, 0, "" + i, "", "", "");
      anot.a(this.app, "CliOper", "", "", "0X800465F", "0X800465F", 0, 0, "" + j, "", "", "");
      return;
      if (paramChatMessage.istroop == 3000)
      {
        j = 2;
        break;
      }
      if (paramChatMessage.istroop == 1)
      {
        j = 3;
        break;
      }
      j = 4;
      break;
      label284:
      if ((paramChatMessage instanceof MessageForText)) {
        i = 1;
      } else if ((paramChatMessage instanceof MessageForPic)) {
        i = 3;
      } else if ((paramChatMessage instanceof MessageForMarketFace)) {
        i = 4;
      } else {
        i = 0;
      }
    }
  }
  
  protected void n(ChatMessage paramChatMessage)
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.mContext;
    if ((localFragmentActivity == null) || (localFragmentActivity.getChatFragment() == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onClickScreenShot Error:");
      if (localFragmentActivity != null) {}
      for (paramChatMessage = localFragmentActivity.toString();; paramChatMessage = "ca is null ")
      {
        QLog.e("BaseBubbleBuilder", 1, paramChatMessage);
        return;
      }
    }
    ((yju)localFragmentActivity.getChatFragment().a().a(59)).M(paramChatMessage);
  }
  
  public void notifyDataSetChanged()
  {
    this.adapter.notifyDataSetChanged();
  }
  
  public void o(ChatMessage paramChatMessage) {}
  
  public void onClick(View paramView)
  {
    if (Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.sessionInfo.beB) || (!(this.mContext instanceof MultiForwardActivity)))
      {
        wja.bcO = true;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131364494: 
        case 2131364539: 
        case 2131364512: 
        case 2131364510: 
        case 2131364520: 
          do
          {
            eT(paramView);
            break;
            ej(paramView);
            break;
            ei(paramView);
            break;
          } while (this.sessionInfo.cZ != 1);
          ej(paramView);
          break;
        case 2131364525: 
          ((FlashChatManager)this.app.getManager(217)).a(paramView.getContext(), null);
          break;
        case 2131364540: 
        case 2131364541: 
          Object localObject = (wko.a)wja.a(paramView);
          String str = ((wko.a)localObject).mMessage.frienduin;
          localObject = ((wko.a)localObject).mMessage.senderuin;
          if (((apmb)this.app.getManager(346)).qD(str))
          {
            str = aptl.a().bQ(str, (String)localObject);
            localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
            ((Intent)localObject).putExtra("url", str);
            paramView.getContext().startActivity((Intent)localObject);
            if (paramView.getId() == 2131364540) {
              anot.a(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
            }
          }
          else if (paramView.getId() == 2131364541)
          {
            eT(paramView);
          }
          break;
        }
      }
    }
  }
  
  static class ProcessMemberNickTask
    implements Runnable
  {
    BaseChatItemLayout a;
    String aSC;
    String aSD;
    View.OnLongClickListener b;
    QQAppInterface mApp;
    Context mContext;
    int mCurType;
    
    public ProcessMemberNickTask(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, String paramString1, String paramString2, int paramInt, View.OnLongClickListener paramOnLongClickListener)
    {
      this.mApp = paramQQAppInterface;
      this.mContext = paramContext;
      this.a = paramBaseChatItemLayout;
      this.aSC = paramString1;
      this.aSD = paramString2;
      this.mCurType = paramInt;
      this.b = paramOnLongClickListener;
    }
    
    public void run()
    {
      String str1 = null;
      if ((this.mApp == null) || (this.mContext == null) || (this.a == null) || (this.b == null)) {}
      for (;;)
      {
        return;
        label55:
        Object localObject;
        if (this.mCurType == 1)
        {
          str1 = aqgv.h(this.mApp, this.aSC, this.aSD);
          localObject = str1;
          if (str1 != null)
          {
            localObject = str1;
            if (str1.getBytes().length > 3)
            {
              byte[] arrayOfByte = str1.getBytes();
              localObject = str1;
              if (arrayOfByte[0] == -17)
              {
                localObject = str1;
                if (arrayOfByte[1] == -69)
                {
                  localObject = str1;
                  if (arrayOfByte[2] == -65)
                  {
                    localObject = new byte[arrayOfByte.length - 3];
                    System.arraycopy(arrayOfByte, 3, localObject, 0, localObject.length);
                  }
                }
              }
            }
          }
        }
        try
        {
          localObject = new String((byte[])localObject, "UTF-8");
          if (!(this.mContext instanceof Activity)) {
            continue;
          }
          ((Activity)this.mContext).runOnUiThread(new BaseBubbleBuilder.ProcessMemberNickTask.1(this, (String)localObject));
          return;
          if (this.mCurType != 3000) {
            break label55;
          }
          str1 = aqgv.m(this.mApp, this.aSC, this.aSD);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
            String str2 = str1;
          }
        }
      }
    }
  }
  
  class a
    implements TroopManager.b
  {
    public BaseChatItemLayout b;
    public TroopInfo f;
    public boolean isAnonymous;
    public int textColor;
    
    private a() {}
    
    public void b(TroopMemberInfo paramTroopMemberInfo)
    {
      Object localObject1 = (BaseBubbleBuilder.e)this.b.getTag();
      int j;
      boolean bool;
      Object localObject2;
      int i;
      if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.e)localObject1).mMessage.senderuin, paramTroopMemberInfo.memberuin)))
      {
        if (((this.f != null) && (this.f.isQidianPrivateTroop())) && ((this.f == null) || (!this.f.isHomeworkTroop()))) {
          break label316;
        }
        j = 1;
        anlm.ayn();
        if (this.f == null) {
          break label332;
        }
        bool = this.f.isTroopOwner(paramTroopMemberInfo.memberuin);
        if ((this.f.Administrator != null) && (this.f.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
        localObject2 = apdg.a().a(paramTroopMemberInfo, this.f);
        if ((localObject2 == null) || (!bool)) {
          break label324;
        }
        localObject1 = ((apdg.a)localObject2).title;
        i = ((apdg.a)localObject2).bgColor;
        label157:
        if (!this.isAnonymous) {
          break label321;
        }
        i = apdg.a().dTy;
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (this.f != null)
        {
          localObject2 = localObject1;
          if (j == 0)
          {
            bool = this.f.isTroopOwner(paramTroopMemberInfo.memberuin);
            if ((this.f.Administrator != null) && (this.f.Administrator.contains(paramTroopMemberInfo.memberuin))) {}
            localObject2 = "";
            if (bool) {
              localObject2 = acfp.m(2131721461);
            }
          }
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.b.setTroopMemberLevel(BaseBubbleBuilder.this.app, true, (String)localObject2, false, i, this.textColor);
          BaseBubbleBuilder.a(BaseBubbleBuilder.this, true);
          this.b.HQ.setOnClickListener(BaseBubbleBuilder.this);
          this.b.HQ.setTag(Integer.valueOf(2131364541));
        }
        return;
        label316:
        j = 0;
        break;
        label321:
        continue;
        label324:
        localObject1 = null;
        i = 0;
        break label157;
        label332:
        i = 0;
        localObject1 = null;
      }
    }
  }
  
  class b
    implements TroopManager.b
  {
    public CharSequence H;
    public String aBX;
    public BaseBubbleBuilder.e b;
    public BaseChatItemLayout b;
    public boolean bdq;
    public boolean bdr;
    public boolean bds;
    public boolean bdt;
    public ChatMessage f;
    public int fromType = 1;
    public ColorStateList k;
    public ColorStateList l;
    
    private b() {}
    
    public void b(TroopMemberInfo paramTroopMemberInfo)
    {
      Object localObject1 = (TroopManager)BaseBubbleBuilder.this.app.getManager(52);
      localObject1 = (BaseBubbleBuilder.e)this.jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTag();
      Object localObject2;
      Object localObject3;
      int i;
      int j;
      int m;
      int n;
      int i1;
      boolean bool1;
      if ((paramTroopMemberInfo != null) && (TextUtils.equals(((BaseBubbleBuilder.e)localObject1).mMessage.senderuin, paramTroopMemberInfo.memberuin)))
      {
        ((HotChatManager)BaseBubbleBuilder.this.app.getManager(60)).kj(this.f.frienduin);
        localObject1 = new aofe(aqgv.c(BaseBubbleBuilder.this.app, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin, true), 13).k();
        localObject2 = this.f.getExtInfoFromExtStr("vip_type");
        localObject3 = this.f.getExtInfoFromExtStr("vip_level");
        String str1 = this.f.getExtInfoFromExtStr("bigClub_type");
        String str2 = this.f.getExtInfoFromExtStr("bigClub_level");
        String str3 = this.f.getExtInfoFromExtStr("vip_card_id");
        i = VipUtils.getIntValue((String)localObject2, 0);
        j = VipUtils.getIntValue((String)localObject3, 0);
        m = VipUtils.getIntValue(str1, 0);
        n = VipUtils.getIntValue(str2, 0);
        i1 = VipUtils.getIntValue(str3, 0);
        localObject2 = this.jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
        if ((localObject1 == null) && (!this.bdq)) {
          break label376;
        }
        bool1 = true;
        localObject3 = this.k;
        if (((!this.bdq) || (!jof.b(this.f))) && (!aehj.ak(this.f)) && (!this.f.isSend())) {
          break label382;
        }
      }
      label376:
      label382:
      for (boolean bool2 = true;; bool2 = false)
      {
        ((BaseChatItemLayout)localObject2).a(bool1, (CharSequence)localObject1, (ColorStateList)localObject3, bool2, this.bdr, this.bdt, this.bds, this.H, this.l, this.aBX, i, j, m, n, i1, paramTroopMemberInfo.mIsHideBigClub);
        if (this.fromType == 1) {
          BaseBubbleBuilder.a(BaseBubbleBuilder.this, ((CharSequence)localObject1).toString(), this.f, this.jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_b_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e);
        }
        aqpm.a(BaseBubbleBuilder.this.app, this.jdField_b_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.vU, (Spannable)localObject1);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  class c
    implements TroopManager.b
  {
    public BaseChatItemLayout b;
    public String memberUin;
    
    private c() {}
    
    public void b(TroopMemberInfo paramTroopMemberInfo)
    {
      if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.memberUin)) && (this.memberUin.equals(paramTroopMemberInfo.memberuin)))
      {
        paramTroopMemberInfo = ((apmb)BaseBubbleBuilder.this.app.getManager(346)).aX(paramTroopMemberInfo.honorList);
        if ((this.b != null) && (this.b.b != null))
        {
          this.b.b.setHonorList(paramTroopMemberInfo);
          if ((paramTroopMemberInfo == null) || (paramTroopMemberInfo.size() <= 0)) {
            break label108;
          }
          this.b.b.setOnClickListener(BaseBubbleBuilder.this);
        }
      }
      return;
      label108:
      this.b.b.setOnClickListener(null);
    }
  }
  
  public static abstract interface d
  {
    public abstract void e(View paramView, MotionEvent paramMotionEvent);
    
    public abstract void v(View paramView, boolean paramBoolean);
  }
  
  public static abstract class e
    extends wko.a
  {
    public View E;
    public BaseChatItemLayout a;
    public int aRY;
    public adxp b;
    public int bvc;
    public int count;
    public View mask;
    public int pos;
    public String uin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder
 * JD-Core Version:    0.7.0.1
 */