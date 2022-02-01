package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import aalb;
import aale;
import aamb;
import acbn;
import acfp;
import achq;
import acrl;
import acsu;
import aeam;
import aegu;
import afci;
import afde;
import ahtc;
import ahwb;
import aizb;
import aizc;
import aizd;
import aizf;
import aizy;
import ajdo;
import alib;
import alip;
import alkf;
import alkm;
import anaz;
import anbi;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anop;
import anop.a;
import anot;
import anpc;
import anxr;
import aofe;
import aofk;
import aoko;
import aomq;
import appb;
import aqgv;
import aqlm;
import aqlm.a;
import aqlr;
import aqlz;
import aqmu;
import aqpm;
import arjn;
import aurf;
import aurk;
import auru;
import ausj;
import aute;
import auvp;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.a;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.b;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.activity.recent.data.RecentItemScheduleData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.LSRecordPanel.a;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.MaxHeightRelativelayout;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;
import jof;
import kbp;
import kgw;
import kxm;
import mqq.app.AppActivity;
import mqq.app.Constants.LogoutReason;
import mqq.app.Foreground;
import mqq.os.MqqHandler;
import obt;
import ocp;
import syw;
import tas;
import tat;
import tog;
import ton;
import top;
import ujt;
import vob;
import voc;
import vod;
import voe;
import vof;
import vog;
import voh;
import voi;
import voj;
import vok;
import vol;
import vom;
import wja;
import wla;
import wla.a;
import wvo;
import xkx;
import ysf;
import ysf.a;
import ysq;
import ytq;
import ytv;

public class QQLSActivity
  extends AppActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, aqlm.a, MediaPlayerManager.a, MediaPlayerManager.b, DragFrameLayout.c, LSRecordPanel.a, Observer, wla.a
{
  private static final boolean aTl = AppSetting.enableTalkBack;
  private static CopyOnWriteArraySet<String> e = new CopyOnWriteArraySet();
  public Comparator A = new voj(this);
  private final int DOUBLE_TAP_TIMEOUT = 300;
  private TextView EP;
  private TextView EQ;
  private TextView ER;
  private TextView ES;
  private long GF = -1L;
  private long GG;
  private final int MSG_FINISH_ACTIVITY = 2;
  private final int MSG_START_UNLOCKACTIVITY = 9;
  protected achq a;
  public aizf a;
  KeyguardManager jdField_a_of_type_AndroidAppKeyguardManager;
  aqlm jdField_a_of_type_Aqlm;
  private arjn jdField_a_of_type_Arjn;
  private a jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a;
  c jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$c;
  private d jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d;
  DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private LSRecordPanel jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel;
  private TouchProxyRelativeLayout jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout;
  private MaxHeightRelativelayout jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout;
  private ysf.a jdField_a_of_type_Ysf$a = new vom(this);
  private boolean aZA;
  private boolean aZB = true;
  private boolean aZC;
  private boolean aZu;
  private boolean aZv;
  private boolean aZw;
  private boolean aZx;
  private boolean aZy;
  private boolean aZz = true;
  private Animation ao;
  private QQAppInterface app;
  alkm jdField_b_of_type_Alkm;
  public anxr b;
  PhoneContactManagerImp jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp;
  private RecentBaseData jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
  ysf jdField_b_of_type_Ysf;
  private final int bJA = 5;
  private final int bJB = 6;
  private final int bJC = 7;
  private final int bJD = 8;
  private final int bJE = 10;
  private final int bJF = 11;
  private final int bJG = 12;
  private final int bJH = 13;
  private final int bJI = 14;
  private final int bJJ = 15;
  private final int bJK = 16;
  private final int bJL = 1500;
  private final int bJM = 1000;
  public final int bJN = 0;
  public final int bJO = 1;
  public final int bJP = 2;
  public final int bJQ = 3;
  public final int bJR = 4;
  public final int bJS = 99;
  private int bJv;
  private final int bJw = 1000;
  private final int bJx = 1;
  private final int bJy = 3;
  private final int bJz = 4;
  private int baS;
  public final int ban = 5;
  private XEditTextEx d;
  private Button dq;
  public boolean du = true;
  private achq g;
  public auru g;
  private Handler handler = new vod(this, Looper.getMainLooper());
  private RelativeLayout hc;
  private long lastClickTime;
  private long lastRefreshTime = -1L;
  private RelativeLayout mBackBtn;
  private MotionEvent mCurrentDownEvent;
  float mDensity;
  private MotionEvent mPreviousUpEvent;
  View.OnTouchListener mTouchListener = new voc(this);
  ArrayList<MessageRecord> pu = new ArrayList();
  private XListView s;
  private XListView t;
  private View tS;
  public final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  public Comparator w = new voi(this);
  PowerManager.WakeLock wakeLock = null;
  
  public QQLSActivity()
  {
    this.jdField_g_of_type_Auru = new auru(Looper.getMainLooper(), this);
    this.jdField_g_of_type_Achq = new vol(this);
    this.jdField_a_of_type_Achq = new vob(this);
  }
  
  private void Bp(int paramInt)
  {
    this.EQ.setVisibility(0);
    if (paramInt > 0) {
      this.handler.sendEmptyMessageDelayed(15, paramInt);
    }
  }
  
  private boolean Qs()
  {
    long l1 = System.currentTimeMillis();
    aizf localaizf;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("judge need to wake up, now =").append(l1).append(", firstMsgTime =");
      localaizf = this.jdField_a_of_type_Aizf;
      localObject = ((StringBuilder)localObject).append(aizf.aaO).append(", lastWakeUpTime = ");
      localaizf = this.jdField_a_of_type_Aizf;
      localObject = ((StringBuilder)localObject).append(aizf.acb).append(", wakeUpTimeAfter30Minute =");
      localaizf = this.jdField_a_of_type_Aizf;
      QLog.d("QQLSActivity", 2, aizf.dhe);
    }
    Object localObject = this.jdField_a_of_type_Aizf;
    if (aizf.cmS) {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "troop message don't need bright");
      }
    }
    do
    {
      return false;
      localObject = this.jdField_a_of_type_Aizf;
      if (aizf.aaO == 0L)
      {
        localObject = this.jdField_a_of_type_Aizf;
        aizf.aaO = System.currentTimeMillis();
      }
      localObject = this.jdField_a_of_type_Aizf;
      if (l1 < aizf.aaO + 1800000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "less than 30min ,need bright");
        }
        localObject = this.jdField_a_of_type_Aizf;
        aizf.acb = l1;
        localObject = this.jdField_a_of_type_Aizf;
        aizf.cmQ = false;
        return true;
      }
      localObject = this.jdField_a_of_type_Aizf;
      long l2 = Math.min(6, aizf.dhe + 1) * 10 * 60 * 1000;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("has wakeup");
        localaizf = this.jdField_a_of_type_Aizf;
        QLog.d("QQLSActivity", 2, aizf.dhe + "times");
      }
      localObject = this.jdField_a_of_type_Aizf;
      if (l1 > l2 + aizf.acb)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "over wakeuptime ,need bright");
        }
        localObject = this.jdField_a_of_type_Aizf;
        aizf.cmQ = true;
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQLSActivity", 2, "not bright screen");
    return false;
  }
  
  @TargetApi(16)
  private boolean Qt()
  {
    if ((Build.VERSION.SDK_INT == 20) && (Build.VERSION.RELEASE.equals("L"))) {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isKeyguardLock SDK is androidL !");
      }
    }
    for (;;)
    {
      return true;
      boolean bool;
      if (Build.VERSION.SDK_INT >= 20)
      {
        bool = "1".equals(DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.lock_screen_enterAIO.name(), "1"));
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "=======5.0enterAIO=======" + bool);
        }
        if (!bool) {}
      }
      else if (Build.VERSION.SDK_INT >= 16)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidAppKeyguardManager == null) {
            this.jdField_a_of_type_AndroidAppKeyguardManager = ((KeyguardManager)getSystemService("keyguard"));
          }
          if (QLog.isColorLevel()) {
            QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardSecure());
          }
          if ((this.jdField_a_of_type_AndroidAppKeyguardManager != null) && (this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardLocked()))
          {
            bool = this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardSecure();
            if (!bool) {}
          }
          for (bool = true;; bool = false) {
            return bool;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (SecurityException localSecurityException) {}
      }
    }
    QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localSecurityException);
    return true;
  }
  
  private SessionInfo a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.ng();
    String str = paramRecentBaseData.qx();
    SessionInfo localSessionInfo = new SessionInfo();
    Object localObject;
    if (i == 1)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).b(str + "");
        if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
          localSessionInfo.troopUin = ((TroopInfo)localObject).troopcode;
        }
      }
    }
    for (;;)
    {
      localSessionInfo.aTl = str;
      localSessionInfo.cZ = i;
      localSessionInfo.aTn = paramRecentBaseData.mTitleName;
      return localSessionInfo;
      if (i == 1006)
      {
        localObject = ((ajdo)this.app.getManager(11)).a();
        localSessionInfo.phoneNum = (((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo);
        localSessionInfo.aTo = aqgv.x(this.app, str);
        if ((localSessionInfo.aTo == null) && (QLog.isColorLevel())) {
          QLog.d("QQLSActivity", 2, "contactUin == null");
        }
      }
      else if (((i == 1004) || (i == 1000)) && ((paramRecentBaseData instanceof RecentUserBaseData)))
      {
        localSessionInfo.troopUin = ((RecentUserBaseData)paramRecentBaseData).qz();
      }
    }
  }
  
  private void a(RecentBaseData paramRecentBaseData)
  {
    if (Math.abs(this.GG - System.currentTimeMillis()) < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "enter too offen,please try again later");
      }
      return;
    }
    this.GG = System.currentTimeMillis();
    aizf.acc = System.currentTimeMillis();
    bTb();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "enterAIO");
    }
    if (!isKeyguardLock())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "=======enterAIO  NOT LOCK!!!!!!!!!");
      }
      finish();
      return;
    }
    if (this.handler.hasMessages(13)) {
      this.handler.removeMessages(13);
    }
    if ((paramRecentBaseData instanceof RecentUserBaseData)) {}
    for (Object localObject1 = ((RecentUserBaseData)paramRecentBaseData).a();; localObject1 = null)
    {
      if (paramRecentBaseData != null) {
        paramRecentBaseData.cuQ();
      }
      if (paramRecentBaseData != null) {
        aizb.T(this.jdField_a_of_type_Aizf.du(paramRecentBaseData.qx() + paramRecentBaseData.ng()), paramRecentBaseData.qx(), paramRecentBaseData.ng());
      }
      anot.a(this.app, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
      Object localObject2 = this.jdField_a_of_type_Aizf;
      aizf.cmV = true;
      if (Qt())
      {
        bTb();
        if (this.ao != null) {
          this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.startAnimation(this.ao);
        }
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1012))
        {
          paramRecentBaseData = new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0);
          localObject1 = new Intent(this, NearbyPeopleProfileActivity.class);
          ((Intent)localObject1).putExtra("param_mode", 2);
          ((Intent)localObject1).putExtra("AllInOne", paramRecentBaseData);
          ((Intent)localObject1).putExtra("abp_flag", true);
          ((Intent)localObject1).putExtra("frome_where", -1);
          ((Intent)localObject1).addFlags(67108864);
          startActivity((Intent)localObject1);
        }
        for (;;)
        {
          paramRecentBaseData = this.handler.obtainMessage(16);
          this.handler.sendMessageDelayed(paramRecentBaseData, 1500L);
          return;
          if ((localObject1 != null) && ((((RecentUser)localObject1).getType() == 1030) || (((RecentUser)localObject1).getType() == 1030) || (((RecentUser)localObject1).getType() == 1041) || (((RecentUser)localObject1).getType() == 1042)))
          {
            if ((paramRecentBaseData instanceof RecentItemNoticeData))
            {
              paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
              if (paramRecentBaseData != null) {
                startActivity(paramRecentBaseData);
              }
            }
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 9653))
          {
            localObject1 = (aizc)this.app.getManager(145);
            if ((paramRecentBaseData instanceof RecentItemPullActivePush))
            {
              paramRecentBaseData = ((aizc)localObject1).ae;
              if (paramRecentBaseData != null) {
                startActivity(paramRecentBaseData);
              }
            }
            ((aizc)localObject1).aIH();
            QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1001))
          {
            paramRecentBaseData = this.app.b().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
            startActivity(this.app.a(this, paramRecentBaseData, false));
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1008) && (acbn.blP.equals(((RecentUser)localObject1).uin)))
          {
            kxm.aIa();
            startActivity(ReadInJoyLockScreenJumpDelegate.a(this, 9, ((KandianDailyManager)this.app.getManager(296)).b()));
          }
          else if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7220))
          {
            kbp.a(null, "CliOper", "", "", "0X80098D5", "0X80098D5", 0, 0, "0", "", "", "", false);
            paramRecentBaseData = ((KandianMergeManager)this.app.getManager(162)).c();
            if ((paramRecentBaseData != null) && (kxm.f(paramRecentBaseData.getMessageRecord())))
            {
              kxm.aHY();
              kgw.b(this.app, this, 9, 0);
            }
            else
            {
              paramRecentBaseData = new Intent(this, SplashActivity.class);
              paramRecentBaseData.putExtra("tab_index", MainFragment.bIk);
              paramRecentBaseData.setFlags(67108864);
              startActivity(paramRecentBaseData);
            }
          }
          else if ((paramRecentBaseData != null) && (top.eD(paramRecentBaseData.ng()) == 1044))
          {
            localObject1 = aizy.e(this);
            ((Intent)localObject1).putExtra("key_matchchat_from_notification", true);
            ((Intent)localObject1).putExtra("key_matchchat_from_notification_uin", paramRecentBaseData.qx());
            ((Intent)localObject1).putExtra("key_matchchat_from_notification_type", paramRecentBaseData.ng());
            startActivity((Intent)localObject1);
          }
          else if ((paramRecentBaseData != null) && (paramRecentBaseData.ng() == 10007))
          {
            ahtc.d(this.app, this, paramRecentBaseData.qx());
          }
          else
          {
            paramRecentBaseData = new Intent(this, SplashActivity.class);
            paramRecentBaseData.putExtra("tab_index", MainFragment.bIk);
            paramRecentBaseData.setFlags(67108864);
            startActivity(paramRecentBaseData);
          }
        }
      }
      int i;
      if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7432))
      {
        paramRecentBaseData = new Intent(this, SplashActivity.class);
        paramRecentBaseData.setFlags(67108864);
        paramRecentBaseData.putExtra("tab_index", MainFragment.bIk);
        paramRecentBaseData.putExtra("fragment_id", 1);
        startActivity(paramRecentBaseData);
        i = 0;
        label986:
        aurk.c(this.app, (RecentUser)localObject1);
        paramRecentBaseData = this.handler.obtainMessage(9);
        localObject2 = this.handler;
        if ((!GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && (i == 0)) {
          break label1478;
        }
      }
      label1473:
      label1478:
      for (long l = 500L;; l = 0L)
      {
        ((Handler)localObject2).sendMessageDelayed(paramRecentBaseData, l);
        paramRecentBaseData = this.handler.obtainMessage(16);
        this.handler.sendMessageDelayed(paramRecentBaseData, 1500L);
        if ((localObject1 == null) || (((RecentUser)localObject1).getType() != 1008)) {
          break;
        }
        kbp.a(null, ((RecentUser)localObject1).uin, "0X800756F", "0X800756F", 0, 0, "", "", "", "");
        return;
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 9653))
        {
          localObject2 = (aizc)this.app.getManager(145);
          if ((paramRecentBaseData instanceof RecentItemPullActivePush))
          {
            paramRecentBaseData = ((aizc)localObject2).ae;
            if (paramRecentBaseData != null)
            {
              paramRecentBaseData.setFlags(67108864);
              startActivity(paramRecentBaseData);
            }
          }
          ((aizc)localObject2).aIH();
          QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
          i = 1;
          break label986;
        }
        if ((localObject1 != null) && ((((RecentUser)localObject1).getType() == 1030) || (gl(((RecentUser)localObject1).getType()))))
        {
          if (!(paramRecentBaseData instanceof RecentItemNoticeData)) {
            break label1473;
          }
          paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
          if (paramRecentBaseData != null)
          {
            if ((gl(((RecentUser)localObject1).getType())) && (!Qt())) {
              paramRecentBaseData.putExtra("push_notice_unlock", true);
            }
            startActivity(paramRecentBaseData);
          }
          i = 0;
          break label986;
        }
        if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 1001))
        {
          paramRecentBaseData = this.app.b().a(((RecentUser)localObject1).uin, ((RecentUser)localObject1).getType());
          startActivity(this.app.a(this, paramRecentBaseData, false));
          i = 0;
          break label986;
        }
        if ((paramRecentBaseData != null) && (top.eD(paramRecentBaseData.ng()) == 1044))
        {
          localObject2 = aizy.e(this);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification", true);
          ((Intent)localObject2).putExtra("key_matchchat_from_notification_uin", paramRecentBaseData.qx());
          ((Intent)localObject2).putExtra("key_matchchat_from_notification_type", paramRecentBaseData.ng());
          startActivity((Intent)localObject2);
          i = 0;
          break label986;
        }
        if ((paramRecentBaseData != null) && (paramRecentBaseData.ng() == 10007))
        {
          ahtc.d(this.app, this, paramRecentBaseData.qx());
          i = 0;
          break label986;
        }
        if (paramRecentBaseData != null)
        {
          if ((localObject1 != null) && (((RecentUser)localObject1).getType() == 7220)) {
            kxm.aHY();
          }
          aalb.a(this, this.app, (RecentUser)localObject1, paramRecentBaseData.mTitleName, true, 1, null);
        }
        i = 0;
        break label986;
      }
    }
  }
  
  private void a(MessageForPtt paramMessageForPtt)
  {
    paramMessageForPtt.isReadPtt = true;
    paramMessageForPtt.serial();
    this.app.b().c(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
  }
  
  private void a(ytq paramytq)
  {
    int i;
    if ((paramytq.a != null) && (acbn.bkJ.equals(paramytq.a.frienduin)))
    {
      i = ysq.g(paramytq.a);
      NewFriendActivity.caU = i;
      if (i != 6) {
        break label52;
      }
      NewFriendActivity.h(this.app, "0X800A181");
    }
    label52:
    while ((i != 9) && (i != 10) && (i != 1)) {
      return;
    }
    NewFriendActivity.h(this.app, "0X8009CBA");
  }
  
  private void acquireWakeLock()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new wakeLock");
    }
  }
  
  private void bTa()
  {
    aizf localaizf = this.jdField_a_of_type_Aizf;
    if (aizf.aaO == 0L)
    {
      localaizf = this.jdField_a_of_type_Aizf;
      aizf.aaO = System.currentTimeMillis();
      localaizf = this.jdField_a_of_type_Aizf;
      localaizf = this.jdField_a_of_type_Aizf;
      aizf.acb = aizf.aaO;
      localaizf = this.jdField_a_of_type_Aizf;
      aizf.dhe = 0;
    }
    long l;
    do
    {
      return;
      localaizf = this.jdField_a_of_type_Aizf;
      l = aizf.acb;
      localaizf = this.jdField_a_of_type_Aizf;
    } while (l >= aizf.aaO);
    localaizf = this.jdField_a_of_type_Aizf;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.acb = aizf.aaO;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.dhe = 0;
  }
  
  private void bTb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "clearRemindTime");
    }
    aizf localaizf = this.jdField_a_of_type_Aizf;
    aizf.aaO = 0L;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.acb = 0L;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.dhe = 0;
  }
  
  private void bTd()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "updateUI thread" + Thread.currentThread().getId());
    }
    if (!this.aZB) {
      return;
    }
    Object localObject1 = (InputMethodManager)getSystemService("input_method");
    if (this.hc.getVisibility() == 8) {}
    try
    {
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Aizf.f());
      if (localArrayList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentBaseData size = 0,  finish" + Thread.currentThread().getId());
        }
        finish();
        if ((getIntent().getFlags() & 0x100000) != 0)
        {
          localObject2 = new Intent();
          ((Intent)localObject2).setClass(this, SplashActivity.class);
          ((Intent)localObject2).setFlags(67108864);
          ((Intent)localObject2).putExtra("tab_index", MainFragment.bIk);
          ((Intent)localObject2).putExtra("fragment_id", 1);
          startActivity((Intent)localObject2);
        }
      }
      if (localArrayList.size() == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel;
        this.s.setVisibility(8);
        if (this.hc.getVisibility() == 8)
        {
          MediaPlayerManager.a(this.app).stop(false);
          MediaPlayerManager.a(this.app).c(this.s);
          MediaPlayerManager.a(this.app).a(this.t, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d, this, this, true, false);
        }
        this.hc.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData = ((RecentBaseData)localArrayList.get(0));
        bTe();
        this.lastRefreshTime = SystemClock.uptimeMillis();
        localObject1 = this.handler.obtainMessage(12);
        this.handler.sendMessageDelayed((Message)localObject1, 350L);
        this.aZx = false;
        anot.a(this.app, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, "" + localArrayList.size(), "", "", "");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("QQLSActivity", 1, "updateUI error: " + localThrowable.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = null;
      ((InputMethodManager)localObject1).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
      if (this.hc.getVisibility() == 0)
      {
        MediaPlayerManager.a(this.app).stop(false);
        MediaPlayerManager.a(this.app).c(this.t);
        MediaPlayerManager.a(this.app).a(this.s, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a, this, this, false, false);
      }
      localObject1 = MediaPlayerManager.a(this.app).a();
      if (localObject1 == null) {
        break label637;
      }
    }
    Object localObject2 = localThrowable.iterator();
    Object localObject3;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (RecentBaseData)((Iterator)localObject2).next();
      localObject3 = this.app.b().a(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
    } while ((((MessageRecord)localObject3).uniseq != ((ChatMessage)localObject1).uniseq) || (((MessageRecord)localObject3).istroop != ((ChatMessage)localObject1).istroop));
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        MediaPlayerManager.a(this.app).stop(false);
      }
      label637:
      this.hc.setVisibility(8);
      this.s.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a.setList(localThrowable);
      break;
    }
  }
  
  private void bTe()
  {
    Object localObject2;
    TextView localTextView;
    DragTextView localDragTextView;
    RecentBaseData localRecentBaseData;
    if ((this.hc != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData != null))
    {
      localObject1 = (RelativeLayout)this.hc.findViewById(2131374922);
      localObject2 = (TextView)this.hc.findViewById(2131374920);
      localTextView = (TextView)this.hc.findViewById(2131374925);
      localDragTextView = (DragTextView)this.hc.findViewById(2131374926);
      localDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      localDragTextView.setDragViewType(0);
      localDragTextView.setTag(Integer.valueOf(1000));
      this.hc.setFocusable(true);
      ((RelativeLayout)localObject1).setOnTouchListener(this.mTouchListener);
      ((RelativeLayout)localObject1).requestLayout();
      localRecentBaseData = this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData;
      if ((localRecentBaseData != null) && (localRecentBaseData.ng() == 8) && (localRecentBaseData.mExtraType == 25))
      {
        localObject1 = (ajdo)this.app.getManager(11);
        if (localObject1 == null) {
          break label1584;
        }
      }
    }
    label538:
    label669:
    label1574:
    label1577:
    label1584:
    for (Object localObject1 = ((ajdo)localObject1).c(localRecentBaseData.mPhoneNumber);; localObject1 = null)
    {
      int i;
      String str;
      if (localObject1 != null)
      {
        localRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
        if (localRecentBaseData.mTitleName.equals(localRecentBaseData.qx())) {
          localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "updateSingleUI mTitleName = " + localRecentBaseData.mTitleName);
        }
        ((TextView)localObject2).setText(localRecentBaseData.mTitleName);
        localTextView.setText(localRecentBaseData.mShowTime);
        if ((localRecentBaseData.ng() != 7000) && (localRecentBaseData.ng() != 4000) && (localRecentBaseData.ng() != 1001) && (localRecentBaseData.ng() != 10002) && (localRecentBaseData.ng() != 1010) && (localRecentBaseData.ng() != 1012) && (localRecentBaseData.ng() != 1030) && (localRecentBaseData.ng() != 9002) && (localRecentBaseData.ng() != 9501) && (localRecentBaseData.ng() != 7432) && (localRecentBaseData.ng() != 9653) && (localRecentBaseData.ng() != 7220) && ((localRecentBaseData.ng() != 1008) || (!acbn.blP.equals(localRecentBaseData.qx()))) && ((localRecentBaseData.ng() != 1008) || (!acbn.blw.equals(localRecentBaseData.qx()))) && (localRecentBaseData.ng() != 1032) && (localRecentBaseData.ng() != 1035) && (localRecentBaseData.ng() != 1041) && (localRecentBaseData.ng() != 1042) && (localRecentBaseData.ng() != 10007)) {
          break label882;
        }
        this.hc.findViewById(2131369283).setVisibility(8);
        i = 0;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "updateSingleUI type=" + localRecentBaseData.ng());
        }
        localObject1 = (RelativeLayout.LayoutParams)localDragTextView.getLayoutParams();
        if ((localRecentBaseData.ng() != 1012) && (localRecentBaseData.ng() != 1030) && (localRecentBaseData.ng() != 7432) && (localRecentBaseData.ng() != 9653) && (localRecentBaseData.ng() != 1035)) {
          break label901;
        }
        this.hc.findViewById(2131374922).setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)(18.0F * this.mDensity));
        str = this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.qx();
        if (!(this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData instanceof RecentUserBaseData)) {
          break label1577;
        }
      }
      for (localObject1 = ((RecentUserBaseData)this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData).qz();; localObject1 = str)
      {
        int k = this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.ng();
        if ((k == 1030) && ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData instanceof RecentItemNoticeData)))
        {
          localObject2 = new anop.a();
          ((anop.a)localObject2).Ur = "0X800923E";
          ((anop.a)localObject2).Uq = "Android锁屏弹窗";
          anop.a(((RecentItemNoticeData)this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData).url, (anop.a)localObject2);
          anop.a(this.app, (anop.a)localObject2);
        }
        List localList;
        for (;;)
        {
          localList = p(str, k);
          if ((localList != null) && (localList.size() != 0)) {
            break label995;
          }
          if (QLog.isColorLevel()) {
            QLog.e("QQLSActivity", 2, "LSActivity mSingleAdapter size =0 finish" + Thread.currentThread().getId());
          }
          finish();
          return;
          localObject1 = ((alkf)this.app.getManager(140)).a(localRecentBaseData.qx());
          if (localObject1 == null) {
            break;
          }
          localRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
          break;
          label882:
          this.hc.findViewById(2131369283).setVisibility(0);
          i = 1;
          break label538;
          ((RelativeLayout.LayoutParams)localObject1).topMargin = 0;
          this.hc.findViewById(2131374922).setVisibility(0);
          break label669;
          if ((gl(k)) && ((this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData instanceof RecentItemNoticeData)))
          {
            localObject2 = ((RecentItemNoticeData)this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData).intent;
            aizd.a(this.app, ((Intent)localObject2).getStringExtra("push_notice_service_id"), ((Intent)localObject2).getStringExtra("push_notice_content_id"), ((RecentItemNoticeData)this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData).url, "0X800923E", "Android锁屏弹窗");
          }
        }
        label995:
        localObject2 = localRecentBaseData.mShowTime;
        long l1 = localRecentBaseData.mDisplayTime;
        int j = 0;
        while (j < localList.size())
        {
          long l2 = l1;
          Object localObject3 = localObject2;
          if (((MessageRecord)localList.get(j)).msgtype == -2009)
          {
            l2 = l1;
            localObject3 = localObject2;
            if (((MessageRecord)localList.get(j)).time > l1)
            {
              l2 = ((MessageRecord)localList.get(j)).time;
              localObject3 = aale.a().t(((MessageRecord)localList.get(j)).frienduin, ((MessageRecord)localList.get(j)).time);
            }
          }
          j += 1;
          l1 = l2;
          localObject2 = localObject3;
        }
        localRecentBaseData.mDisplayTime = l1;
        localTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d.fW(localList);
        this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.V(str, k, (String)localObject1);
        this.t.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d.getCount() - 1);
        j = GesturePWDUtils.getGesturePWDState(this, this.app.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "set mGesturePasswordState=" + j);
        }
        if (j == 2)
        {
          this.hc.findViewById(2131369283).setVisibility(8);
          i = 0;
        }
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel;
          if (alib.br(this.app))
          {
            Bp(-1);
            this.aZw = true;
            alib.dH(this.app);
          }
        }
        while (localRecentBaseData.ng() == 4000)
        {
          aute.updateCustomNoteTxt(localDragTextView, 3, localRecentBaseData.mUnreadNum, 0);
          return;
          if (this.aZw)
          {
            bTk();
            continue;
            this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.a = null;
          }
        }
        if ((localRecentBaseData.ng() == 1001) || (localRecentBaseData.ng() == 1010) || (localRecentBaseData.ng() == 10002))
        {
          localObject1 = this.app.b().a(localRecentBaseData.qx(), localRecentBaseData.ng());
          aute.updateCustomNoteTxt(localDragTextView, 3, this.app.a().A(((MessageRecord)localObject1).senderuin, localRecentBaseData.ng()), 0);
          return;
        }
        if (localRecentBaseData.ng() == 7000)
        {
          aute.updateCustomNoteTxt(localDragTextView, 3, this.app.a().A(localRecentBaseData.qx(), localRecentBaseData.ng()), 0);
          return;
        }
        if (localRecentBaseData.ng() == 1032)
        {
          aute.updateCustomNoteTxt(localDragTextView, 3, this.app.a().A(localRecentBaseData.qx(), localRecentBaseData.ng()), 0);
          return;
        }
        i = localList.size();
        localObject1 = localList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          if (!ahwb.aB((MessageRecord)((Iterator)localObject1).next())) {
            break label1574;
          }
          i -= 1;
        }
        for (;;)
        {
          break;
          aute.updateCustomNoteTxt(localDragTextView, 3, i, 0);
          return;
        }
      }
    }
  }
  
  private void bTf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "go to wakeUpScreen==========================");
    }
    if (Qs())
    {
      if (this.jdField_a_of_type_Aqlm == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "wakeUpScreen proximitySensor=null");
        }
        bTg();
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Aqlm == null) || (!this.jdField_a_of_type_Aqlm.hasSensor))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("wakeUpScreen hasSensor=");
        if (this.jdField_a_of_type_Aqlm == null) {
          break label159;
        }
      }
      label159:
      for (boolean bool = this.jdField_a_of_type_Aqlm.hasSensor;; bool = false)
      {
        QLog.d("QQLSActivity", 2, bool);
        anot.a(this.app, "CliOper", "", "", "0X800477A", "0X800477A", 0, 0, "", "", "", "");
        bTg();
        return;
      }
    }
    Object localObject = this.jdField_a_of_type_Aizf;
    if (aizf.cmT)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "some phone need to bright early");
      }
      bTg();
      return;
    }
    if (this.aZz)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose  firstTimeToWakeScreen acquireWakeLock");
      }
      acquireWakeLock();
      anot.a(this.app, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (this.aZy)
    {
      acquireWakeLock();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose acquireWakeLock");
      }
      anot.a(this.app, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "wakeUpScreen acquireBrightWakeLock");
    }
    bTg();
  }
  
  private void bTg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "new brightWakeLock  screen bright!!!");
    }
    aizf localaizf = this.jdField_a_of_type_Aizf;
    if (aizf.cmQ)
    {
      long l = System.currentTimeMillis();
      localaizf = this.jdField_a_of_type_Aizf;
      aizf.acb = l;
      localaizf = this.jdField_a_of_type_Aizf;
      aizf.dhe += 1;
    }
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.14(this));
  }
  
  private void bTh()
  {
    Object localObject = this.jdField_a_of_type_Aizf;
    if (aizf.cmT) {}
    do
    {
      return;
      if ((wja.Rb()) && (Build.VERSION.SDK_INT == 15))
      {
        localObject = this.jdField_a_of_type_Aizf;
        aizf.cmT = true;
        return;
      }
      localObject = AppSetting.aHR;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setPhoneNeedBright devicesInfo=== " + (String)localObject);
      }
      if ((((String)localObject).equalsIgnoreCase("oppo-x907")) || (((String)localObject).equalsIgnoreCase("samsung-sch-i779")) || (((String)localObject).equalsIgnoreCase("xiaomi-hm 1sc")) || (((String)localObject).endsWith("lenovo-lenovo a390t")) || (((String)localObject).endsWith("xiaomi-2013022")) || (((String)localObject).endsWith("bbk-vivo x3t")) || (((String)localObject).endsWith("bbk-vivo y3t")) || (((String)localObject).endsWith("oppo-r813t")) || (((String)localObject).endsWith("huawei-huawei t8833")) || (((String)localObject).equalsIgnoreCase("unknown-K-Touch W619")) || (((String)localObject).equalsIgnoreCase("COOLPAD-Coolpad 8079")) || (((String)localObject).endsWith("K-Touch-K-Touch T780")) || (((String)localObject).endsWith("HTC-HTC T328w")) || (((String)localObject).endsWith("HUAWEI-HUAWEI U9508")))
      {
        localObject = this.jdField_a_of_type_Aizf;
        aizf.cmT = true;
        return;
      }
      localObject = this.jdField_a_of_type_Aizf;
    } while (aizf.apZ());
    localObject = this.jdField_a_of_type_Aizf;
    aizf.cmT = false;
  }
  
  private void bTk()
  {
    this.handler.removeMessages(15);
    this.EQ.setVisibility(4);
  }
  
  private void bTl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "SmoothFinish");
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(450L);
    localAlphaAnimation.setAnimationListener(new vof(this));
    this.uiHandler.sendEmptyMessageDelayed(99, 500L);
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.startAnimation(localAlphaAnimation);
  }
  
  private void bTm()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.21(this));
  }
  
  private void bTn()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.22(this));
  }
  
  private void ce(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("uitype", -1);
      int j = paramIntent.getIntExtra("notifyId", -1);
      paramIntent = paramIntent.getStringExtra("frienduin");
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "lsReportCore uitype: " + i + ", notifyId : " + j + ", frienduin : " + paramIntent);
      }
      aizb.S(j, paramIntent, i);
    }
  }
  
  private void cp(String paramString, int paramInt)
  {
    this.handler.removeMessages(14);
    if (this.EP == null)
    {
      this.EP = new TextView(this.hc.getContext());
      this.EP.setBackgroundColor(getResources().getColor(2131167595));
      this.EP.setVisibility(0);
      this.EP.setGravity(17);
      Object localObject = getResources().getDisplayMetrics();
      int k = (int)(16.0F * ((DisplayMetrics)localObject).density);
      int i = (int)(32.0F * ((DisplayMetrics)localObject).density);
      int j = (int)(((DisplayMetrics)localObject).density * 240.0F);
      this.EP.setTextSize(0, k);
      this.EP.setTextColor(-1711276033);
      localObject = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect((Rect)localObject);
      Rect localRect = new Rect();
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.getGlobalVisibleRect(localRect);
      k = (localRect.top - ((Rect)localObject).top - i) / 2;
      int m = (localRect.right - ((Rect)localObject).left - j) / 2;
      localObject = new RelativeLayout.LayoutParams(j, i);
      ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = m;
      ((RelativeLayout.LayoutParams)localObject).topMargin = k;
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.addView(this.EP, (ViewGroup.LayoutParams)localObject);
    }
    this.EP.setText(paramString);
    this.EP.setVisibility(0);
    if (paramInt > 0) {
      this.handler.sendEmptyMessageDelayed(14, paramInt);
    }
  }
  
  private static boolean gl(int paramInt)
  {
    return (paramInt == 1035) || (paramInt == 1041) || (paramInt == 1042);
  }
  
  private String h(MessageRecord paramMessageRecord)
  {
    String str = null;
    Object localObject;
    if (paramMessageRecord.istroop == 7000)
    {
      if (this.jdField_b_of_type_Anxr != null) {
        str = this.jdField_b_of_type_Anxr.nM(paramMessageRecord.frienduin);
      }
      localObject = str;
      if (str == null) {
        localObject = paramMessageRecord.frienduin;
      }
    }
    while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equals("")))
    {
      return "";
      if ((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 1010) || (paramMessageRecord.istroop == 10002))
      {
        paramMessageRecord = aqgv.G(this.app, paramMessageRecord.senderuin);
        localObject = paramMessageRecord;
        if (paramMessageRecord == null) {
          localObject = "";
        }
      }
      else
      {
        if (top.eD(paramMessageRecord.istroop) == 1032)
        {
          localObject = new ConfessInfo();
          ((ConfessInfo)localObject).parseFromJsonStr(paramMessageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
          if (paramMessageRecord.istroop == 1032) {}
          for (paramMessageRecord = paramMessageRecord.senderuin;; paramMessageRecord = paramMessageRecord.frienduin)
          {
            localObject = aegu.a(this.app, (ConfessInfo)localObject, paramMessageRecord);
            break;
          }
        }
        if (jof.a(paramMessageRecord)) {
          localObject = getResources().getString(2131699453);
        } else {
          localObject = this.app.b().d(this, paramMessageRecord, false);
        }
      }
    }
    return (String)localObject + ":";
  }
  
  @TargetApi(9)
  private void initUI()
  {
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout = ((TouchProxyRelativeLayout)findViewById(2131375054));
    if (this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout == null)
    {
      QLog.e("QQLSActivity", 1, "UI is null finish");
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.setVisibility(0);
    this.hc = ((RelativeLayout)findViewById(2131378453));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout = ((MaxHeightRelativelayout)findViewById(2131376849));
    this.jdField_a_of_type_ComTencentWidgetMaxHeightRelativelayout.setMaxHeight((int)(getResources().getDisplayMetrics().density * 356.0F + 0.5D));
    this.s = ((XListView)findViewById(2131376844));
    this.s.setDivider(getResources().getDrawable(2130846306));
    this.t = ((XListView)findViewById(2131378454));
    this.t.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.t.setOverScrollMode(2);
    }
    this.t.setTranscriptMode(2);
    this.t.setDivider(null);
    this.d = ((XEditTextEx)findViewById(2131369306));
    this.dq = ((Button)findViewById(2131363968));
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel = ((LSRecordPanel)findViewById(2131372843));
    this.mBackBtn = ((RelativeLayout)findViewById(2131363823));
    this.ER = ((TextView)findViewById(2131376861));
    this.ES = ((TextView)findViewById(2131378457));
    this.d.addTextChangedListener(this);
    this.dq.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.a(this.app, this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout, this);
    this.mBackBtn.setContentDescription(getString(2131721059));
    this.EQ = ((TextView)findViewById(2131368275));
    this.mBackBtn.setOnClickListener(this);
    this.s.setEdgeEffectEnabled(false);
    if (Build.VERSION.SDK_INT >= 9) {
      this.s.setOverScrollMode(2);
    }
    this.s.setOnItemClickListener(new vog(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a = new a();
    this.s.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a);
    this.d.setCursorVisible(false);
    this.d.setOnTouchListener(new voh(this));
    tat.b(this, this.d);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d = new d();
    this.t.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d);
    this.t.setOnTouchListener(this.mTouchListener);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "initUI updateUI");
    }
    updateUI();
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent1.getEventTime() > 300L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "isConsideredDoubleTap true");
      }
      return false;
    }
    return true;
  }
  
  @TargetApi(16)
  private boolean isKeyguardLock()
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppKeyguardManager == null) {
          this.jdField_a_of_type_AndroidAppKeyguardManager = ((KeyguardManager)getSystemService("keyguard"));
        }
        bool = this.jdField_a_of_type_AndroidAppKeyguardManager.isKeyguardLocked();
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "isKeyguardLock=" + bool);
        }
        return bool;
      }
      catch (SecurityException localSecurityException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + localSecurityException);
        }
        return true;
      }
      boolean bool = aqlr.isScreenLocked(this);
    }
  }
  
  private List<MessageRecord> p(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    Object localObject1;
    if ((paramString.equals(acbn.blf)) || (paramString.equals(acbn.ble)))
    {
      localObject1 = new MessageRecord();
      ((MessageRecord)localObject1).frienduin = paramString;
      ((MessageRecord)localObject1).senderuin = paramString;
      ((MessageRecord)localObject1).istroop = paramInt;
      paramString = new ArrayList();
      paramString.add(localObject1);
      return paramString;
    }
    Object localObject2 = this.app.b().k(paramString, paramInt);
    Object localObject3 = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "single item msg list size: " + ((List)localObject2).size());
    }
    long l;
    if (top.fv(paramInt))
    {
      localObject1 = this.app.a().h(paramString);
      if (localObject1 != null)
      {
        l = ((Long)((Pair)localObject1).first).longValue();
        localObject2 = ton.b((List)localObject2, l);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject1 = localObject3;
          if (((List)localObject2).size() > 0)
          {
            ((List)localObject3).addAll((Collection)localObject2);
            localObject1 = localObject3;
          }
        }
      }
    }
    MessageRecord localMessageRecord;
    for (;;)
    {
      if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
      {
        if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
          }
          finish();
          return new ArrayList();
          l = 0L;
          break;
          if ((paramInt == 3000) || (paramInt == 1))
          {
            localObject1 = top.d((List)localObject2, false);
            continue;
          }
          if (paramInt == 7000)
          {
            localObject2 = new MessageRecord();
            localObject1 = localObject3;
            if (this.jdField_b_of_type_Anxr == null) {
              continue;
            }
            localObject1 = localObject3;
            if (this.jdField_b_of_type_Anxr.c(paramString) == null) {
              continue;
            }
            ((MessageRecord)localObject2).msg = this.jdField_b_of_type_Anxr.c(paramString).toString();
            ((MessageRecord)localObject2).istroop = paramInt;
            ((MessageRecord)localObject2).frienduin = paramString;
            ((List)localObject3).add(localObject2);
            localObject1 = localObject3;
            continue;
          }
          if (paramInt == 4000)
          {
            localMessageRecord = new MessageRecord();
            if (this.jdField_b_of_type_Ysf != null) {}
            for (localObject2 = this.jdField_b_of_type_Ysf.a();; localObject2 = null)
            {
              localObject1 = localObject3;
              if (localObject2 == null) {
                break;
              }
              localMessageRecord.msg = ((ytv)localObject2).o(this.app);
              localMessageRecord.istroop = paramInt;
              localMessageRecord.frienduin = paramString;
              if ((localObject2 instanceof ytq)) {
                a((ytq)localObject2);
              }
              ((List)localObject3).add(localMessageRecord);
              localObject1 = localObject3;
              break;
            }
          }
          if (paramInt == 9002)
          {
            localObject1 = this.app.b().a(acbn.bla, 9002);
            localObject2 = new MessageRecord();
            MessageRecord.copyMessageRecordBaseField((MessageRecord)localObject2, (MessageRecord)localObject1);
            ((List)localObject3).add(localObject2);
            localObject1 = localObject3;
            continue;
          }
          if (paramInt == 8)
          {
            localObject1 = anbi.d(-2026);
            ((MessageRecord)localObject1).istroop = paramInt;
            ((MessageRecord)localObject1).frienduin = paramString;
            ((MessageRecord)localObject1).msg = "";
            ((MessageRecord)localObject1).isread = true;
            ((List)localObject3).add(localObject1);
            localObject1 = localObject3;
            continue;
          }
          localObject1 = localObject3;
          if (paramInt != 9501) {
            continue;
          }
          localObject1 = localObject3;
          if (localObject2 == null) {
            continue;
          }
          localObject2 = ((List)localObject2).iterator();
          for (;;)
          {
            localObject1 = localObject3;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            ((List)localObject3).add((MessageRecord)((Iterator)localObject2).next());
          }
        }
        return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 1, ((List)localObject1).size()));
      }
    }
    if (paramInt == 1032)
    {
      if ((localObject1 == null) || (((List)localObject1).size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
        }
        finish();
        return new ArrayList();
      }
      localObject2 = (MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1);
      localObject2 = aegu.b(this.app, (MessageRecord)localObject2);
      ((List)localObject1).clear();
      if (localObject2 != null) {
        ((List)localObject1).add(localObject2);
      }
    }
    if (paramString.equals(acbn.blc))
    {
      paramString = (afci)this.app.getManager(71);
      if (paramString != null) {
        ((List)localObject1).add(paramString.a().a(this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData));
      }
      return localObject1;
    }
    if ((paramInt == 1030) && (acbn.blH.equals(paramString)))
    {
      if (this.app.iz(240))
      {
        paramString = ((aeam)this.app.getManager(240)).a();
        if (paramString != null) {
          ((List)localObject1).add(paramString);
        }
      }
      return localObject1;
    }
    if (gl(paramInt))
    {
      if (this.app.iz(284))
      {
        paramString = ((aizd)this.app.getManager(284)).a();
        if (paramString != null) {
          ((List)localObject1).add(paramString);
        }
      }
      return localObject1;
    }
    if (paramString.equals(acbn.blt))
    {
      paramString = (aizc)this.app.getManager(145);
      if (paramString != null) {
        ((List)localObject1).add(paramString.a());
      }
      return localObject1;
    }
    if (((paramString.equals(acbn.blx)) && (paramInt == 7220)) || ((paramString.equals(acbn.blw)) && (paramInt == 1008)))
    {
      paramString = ((KandianMergeManager)this.app.getManager(162)).d();
      ((List)localObject1).clear();
      ((List)localObject1).add(paramString);
      return localObject1;
    }
    if (acbn.blP.equals(paramString))
    {
      paramString = ((KandianDailyManager)this.app.getManager(296)).a();
      ((List)localObject1).clear();
      if (paramString != null) {
        ((List)localObject1).add(paramString);
      }
      return localObject1;
    }
    if ((QLog.isColorLevel()) && (localObject1 != null)) {
      QLog.d("QQLSActivity", 2, "single item continued msg list size: " + ((List)localObject1).size());
    }
    top.a((List)localObject1, this.app);
    top.a(paramString, paramInt, (List)localObject1, this.app);
    localObject2 = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "single item continued msg list size= 0" + Thread.currentThread().getId());
      }
      bTl();
      return new ArrayList();
    }
    localObject3 = ((List)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject3).hasNext())
    {
      localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
      if ((i == 0) || (localMessageRecord.isSend()) || (!ahwb.aB(localMessageRecord))) {
        if ((localMessageRecord.isread) || (localMessageRecord.isSend())) {
          ((List)localObject2).add(localMessageRecord);
        } else {
          i = 1;
        }
      }
    }
    ((List)localObject1).removeAll((Collection)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + this.pu.size() + ", uinType" + paramInt);
    }
    paramString = q(paramString, paramInt);
    if (paramString.size() > 0) {
      d((List)localObject1, paramString, paramInt);
    }
    if (((List)localObject1).size() > 15) {
      return new ArrayList(((List)localObject1).subList(((List)localObject1).size() - 15, ((List)localObject1).size()));
    }
    return localObject1;
  }
  
  private void xQ(boolean paramBoolean)
  {
    this.handler.removeMessages(14);
    QQLSActivity.19 local19 = new QQLSActivity.19(this);
    if (paramBoolean)
    {
      this.handler.post(local19);
      return;
    }
    local19.run();
  }
  
  public int P(String paramString, int paramInt)
  {
    return this.jdField_b_of_type_Alkm.ae(paramString, paramInt);
  }
  
  public boolean Qr()
  {
    if (this.app == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "app null,  finish");
      }
      finish();
      return true;
    }
    if (this.jdField_b_of_type_Alkm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "rcf null,  finish");
      }
      finish();
      return true;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp.Un())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "pcm should block app");
      }
      finish();
      return true;
    }
    return false;
  }
  
  public void a(View paramView, aoko paramaoko, int paramInt1, int paramInt2)
  {
    if ((paramaoko.fileType != 2) || (paramInt1 == 2002) || (paramInt1 == 1002) || (paramInt1 == 2001)) {}
    MessageForPtt localMessageForPtt;
    do
    {
      return;
      paramView = (e)paramView.getTag();
      localMessageForPtt = (MessageForPtt)paramView.mMessage;
    } while ((localMessageForPtt == null) || (localMessageForPtt.uniseq != paramaoko.uniseq));
    if ((paramInt1 == 1003) || (paramInt1 == 2003))
    {
      paramInt2 = paramInt1;
      if (!paramaoko.cMw)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2003)
        {
          notifyDataSetChanged();
          paramInt2 = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + paramInt2 + "|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
      }
      a(paramView, localMessageForPtt, paramInt2, d(localMessageForPtt));
      return;
      if ((paramaoko.status == 1005) || (paramaoko.status == 1004))
      {
        notifyDataSetChanged();
        paramInt2 = paramInt1;
      }
      else if (localMessageForPtt.fileSize == -2L)
      {
        paramInt2 = 999;
      }
      else if (localMessageForPtt.fileSize == -3L)
      {
        paramInt2 = 1001;
      }
      else if (localMessageForPtt.fileSize == -1L)
      {
        paramInt2 = 1005;
      }
      else
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 2005)
        {
          localMessageForPtt.fileSize = -4L;
          paramInt2 = paramInt1;
        }
      }
    }
  }
  
  protected void a(e parame, MessageForPtt paramMessageForPtt, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "fileStatus is:" + paramInt + ",url is:" + paramMessageForPtt.url + ",uniseq is:" + paramMessageForPtt.uniseq + ",stt is:" + paramMessageForPtt.sttAbility + ",long is:" + paramMessageForPtt.longPttVipFlag);
    }
    parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setTailMessage(false, null, null);
    Object localObject = getResources();
    switch (paramInt)
    {
    default: 
      str = "";
      paramInt = 0;
    case 2004: 
    case 2005: 
    case -1: 
    case 999: 
    case 1000: 
    case 2000: 
    case 2001: 
    case 2002: 
      for (;;)
      {
        switch (paramInt)
        {
        case 2: 
        case 3: 
        default: 
          parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(false, null);
          if (parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc != null) {
            parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
          }
          label294:
          if (aTl)
          {
            paramMessageForPtt = this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.getTitleName() + acfp.m(2131711836);
            parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setContentDescription(paramMessageForPtt + str + acfp.m(2131711844));
            if (parame.E != null)
            {
              parame.E.append("发送了语音.").append(str);
              if (0 != 0) {
                parame.E.append(" ").append(null);
              }
            }
          }
          return;
          parame.ET.setText("");
          parame.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.bOb);
          parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
          parame.qM.setImageResource(2130846302);
          str = "";
          paramInt = 1;
          continue;
          parame.qM.setImageDrawable(null);
          parame.qM.setPadding(0, 0, 0, 0);
          parame.ET.setText("");
          parame.ET.setPadding(wja.dp2px(40.0F, (Resources)localObject), BaseChatItemLayout.bOa, wja.dp2px(40.0F, (Resources)localObject), BaseChatItemLayout.bOb);
          parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(true);
          str = "";
          paramInt = 0;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "voiceLength showPttItem builder" + paramMessageForPtt.voiceLength);
    }
    if (paramMessageForPtt.voiceLength <= 1) {
      paramMessageForPtt.voiceLength = QQRecorder.n(paramMessageForPtt);
    }
    if (paramMessageForPtt.voiceLength <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "get a amr file length = 0 return now");
      }
      parame.qM.setImageDrawable(null);
      parame.qM.setPadding(0, 0, 0, 0);
      parame.ET.setText("");
      parame.ET.setPadding(wja.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.bOa, wja.dp2px(10.0F, (Resources)localObject), BaseChatItemLayout.bOb);
      return;
    }
    if ((paramMessageForPtt.voiceLength <= xkx.f(this.app, "Normal_MaxPtt")) || (paramMessageForPtt.voiceLength > xkx.f(this.app, "ConvertText_MaxPtt"))) {
      paramMessageForPtt.sttAbility = 0;
    }
    if ((TextUtils.isEmpty(paramMessageForPtt.timeStr)) || (TextUtils.equals(paramMessageForPtt.timeStr, "0\""))) {
      paramMessageForPtt.timeStr = xkx.az(paramMessageForPtt.voiceLength);
    }
    String str = paramMessageForPtt.timeStr;
    parame.ET.setText(str);
    parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setAnimating(false);
    parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setOnClickListener(this);
    if (paramBoolean)
    {
      AnimationDrawable localAnimationDrawable = (AnimationDrawable)((Resources)localObject).getDrawable(2130772185);
      parame.qM.setImageDrawable(localAnimationDrawable);
      localAnimationDrawable.start();
      parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setBackgroundResource(2130842427);
      parame.ET.setTextColor(getResources().getColor(2131165381));
      if (paramInt == 2003) {
        break label1131;
      }
      if (paramInt != 1003) {
        break label989;
      }
      paramInt = 0;
    }
    for (;;)
    {
      label864:
      int j = wja.dp2px(9.0F, (Resources)localObject);
      if (paramMessageForPtt.voiceLength < 15) {}
      for (int i = paramMessageForPtt.voiceLength;; i = 15)
      {
        i = xkx.a(this, i, null, null, 0);
        parame.qM.setPadding(j, 0, 0, 0);
        parame.ET.setPadding(BaseChatItemLayout.contentPadding, 0, i, 0);
        break;
        parame.ET.setTextColor(getResources().getColor(2131167654));
        if (paramMessageForPtt.isReadPtt) {
          parame.qM.setImageResource(2130842425);
        }
        for (;;)
        {
          parame.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.setBackgroundResource(2130842426);
          break;
          parame.qM.setImageResource(2130846305);
        }
        label989:
        if ((paramInt == 1005) || (paramInt == 1004))
        {
          paramInt = 1;
          break label864;
        }
        paramInt = 4;
        break label864;
      }
      parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconVisable(true, this);
      parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
      if (!aTl) {
        break label294;
      }
      localObject = parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc;
      if (paramMessageForPtt.isSendFromLocal()) {}
      for (paramMessageForPtt = acfp.m(2131711839);; paramMessageForPtt = acfp.m(2131711842))
      {
        ((ImageView)localObject).setContentDescription(paramMessageForPtt);
        break;
      }
      parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setFailedIconResource(2130839657, this);
      parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.setBackgroundDrawable(null);
      ((Animatable)parame.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.sc.getDrawable()).start();
      break label294;
      label1131:
      paramInt = 0;
    }
  }
  
  protected void a(BaseBubbleBuilder.e parame, MessageForPtt paramMessageForPtt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {}
    for (int i = 2;; i = 7)
    {
      ujt.a(this.app, paramMessageForPtt.frienduin, paramMessageForPtt, false, i, 0, paramBoolean2);
      return;
    }
  }
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, long paramLong, float paramFloat) {}
  
  public void a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramXListView = wja.a(paramView);
      if ((paramXListView instanceof e))
      {
        paramXListView = (e)paramXListView;
        paramView = (MessageForPtt)paramChatMessage;
        a(paramXListView, paramView, xkx.a(this.app, paramView), false);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("QQLSActivity", 2, "onChange isDone " + paramBoolean);
      QLog.d("QQLSActivity", 2, "onChange mDragHost.getMode() " + this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode());
    }
    Object localObject;
    label636:
    int i;
    if (paramBoolean)
    {
      paramDragFrameLayout = paramDragFrameLayout.bI();
      if ((paramDragFrameLayout == null) || (paramDragFrameLayout.getTag() == null)) {
        break label1577;
      }
      paramInt = ((Integer)paramDragFrameLayout.getTag()).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "delete onChange position=" + paramInt);
      }
      if (paramInt == 1000)
      {
        paramInt = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d.qY.get(0)).istroop;
        paramDragFrameLayout = ((MessageRecord)this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d.qY.get(0)).frienduin;
        if ((paramInt == 1001) || (paramInt == 1010) || (paramInt == 10002))
        {
          ((MessageHandler)this.app.getBusinessHandler(0)).k(paramDragFrameLayout, paramInt, false);
          aalb.l(this.app, paramDragFrameLayout, paramInt);
          this.app.b().ca(paramDragFrameLayout, paramInt);
          this.jdField_b_of_type_Alkm.fC(paramDragFrameLayout, paramInt);
          this.pu.clear();
          this.pu = this.jdField_b_of_type_Alkm.dq();
          if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "QQLSActivity onChange removeNotification");
          }
          this.app.cLs();
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "single data remove finish");
          }
          bTl();
          if (paramInt != 3000) {
            break label636;
          }
          anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
        }
      }
      while (a.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a).size() <= paramInt)
      {
        do
        {
          for (;;)
          {
            return;
            if (paramInt == 4000)
            {
              this.jdField_b_of_type_Ysf.cls();
            }
            else if (paramInt == 7000)
            {
              ((MessageHandler)this.app.getBusinessHandler(0)).a().fi(paramDragFrameLayout, null);
              localObject = (anxr)this.app.getManager(61);
              if (localObject != null) {
                ((anxr)localObject).Ry(paramDragFrameLayout);
              }
            }
            else if (paramInt == 1012)
            {
              localObject = (afci)this.app.getManager(71);
              if (localObject != null) {
                ((afci)localObject).a().aIH();
              }
            }
            else if (paramInt == 1030)
            {
              if (this.app.iz(240))
              {
                ((aeam)this.app.getManager(240)).a(null);
                if (QLog.isColorLevel()) {
                  QLog.d("notification", 2, "remove campus notice from LSA");
                }
              }
            }
            else if (paramInt == 9653)
            {
              ((aizc)this.app.getManager(145)).aIH();
            }
            else if (top.eD(paramInt) == 1032)
            {
              this.app.a().bEp();
              this.app.b().cb(acbn.blK, 1032);
            }
            else if ((gl(paramInt)) && (this.app.iz(284)))
            {
              ((aizd)this.app.getManager(284)).a(null, paramInt);
              if (QLog.isColorLevel()) {
                QLog.d("notification", 2, "remove push notice from LSA");
              }
            }
          }
          if (paramInt == 1)
          {
            anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
            return;
          }
          if (paramInt == 0)
          {
            anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
            return;
          }
        } while ((paramInt != 1001) && (paramInt != 1010) && (paramInt != 10002));
        anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        return;
      }
      i = ((RecentBaseData)a.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a).get(paramInt)).ng();
      paramDragFrameLayout = ((RecentBaseData)a.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a).get(paramInt)).qx();
      aalb.l(this.app, paramDragFrameLayout, i);
      if ((i != 1001) && (i != 1010) && (i != 10002)) {
        break label1051;
      }
      ((MessageHandler)this.app.getBusinessHandler(0)).k(paramDragFrameLayout, i, false);
      this.app.b().a.Kk(i);
      this.app.b().a.ea(paramDragFrameLayout, i);
      a.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a).remove(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a.notifyDataSetChanged();
      if (i != 3000) {
        break label1425;
      }
      anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
      label974:
      this.jdField_a_of_type_Aizf.eY(paramDragFrameLayout, i);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.getMode() == -1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onChange updateUI" + Thread.currentThread().getId());
        }
        this.aZB = true;
        runOnUiThread(new QQLSActivity.18(this));
        return;
        label1051:
        if (i == 4000)
        {
          this.jdField_b_of_type_Ysf.cls();
          this.app.b().a.ea(acbn.bkJ, 0);
          this.app.b().a.ea(acbn.bkA, 4000);
          break;
        }
        if (i == 7000)
        {
          ((MessageHandler)this.app.getBusinessHandler(0)).a().fi(paramDragFrameLayout, null);
          localObject = (anxr)this.app.getManager(61);
          if (localObject == null) {
            break;
          }
          ((anxr)localObject).Ry(paramDragFrameLayout);
          break;
        }
        if (i == 1012)
        {
          localObject = (afci)this.app.getManager(71);
          if (localObject == null) {
            break;
          }
          ((afci)localObject).a().aIH();
          break;
        }
        if (i == 1030)
        {
          if (!this.app.iz(240)) {
            break;
          }
          ((aeam)this.app.getManager(240)).a(null);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("notification", 2, "remove campus notice from LSA");
          break;
        }
        if (i == 9653)
        {
          ((aizc)this.app.getManager(145)).aIH();
          break;
        }
        if (top.eD(i) == 1032)
        {
          this.app.a().bEp();
          this.app.b().cb(acbn.blK, 1032);
          break;
        }
        if (gl(i))
        {
          if (!this.app.iz(284)) {
            break;
          }
          ((aizd)this.app.getManager(284)).a(null, i);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("notification", 2, "remove push notice from LSA");
          break;
        }
        this.app.b().ca(paramDragFrameLayout, i);
        this.jdField_b_of_type_Alkm.fC(paramDragFrameLayout, i);
        this.pu.clear();
        this.pu = this.jdField_b_of_type_Alkm.dq();
        break;
        label1425:
        if (i == 1)
        {
          anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
          break label974;
        }
        if (i == 0)
        {
          anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
          break label974;
        }
        if ((i != 1001) && (i != 1010) && (i != 10002)) {
          break label974;
        }
        anot.a(this.app, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
        break label974;
        label1577:
        if (QLog.isColorLevel())
        {
          QLog.d("QQLSActivity", 2, "dragView = null");
          return;
        }
      }
    }
    this.aZB = false;
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i = 0;
    paramInt = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "exitRecord been called !!!!");
    }
    if (paramBoolean1)
    {
      bTl();
      this.aZB = true;
    }
    for (;;)
    {
      if (paramInt == 0) {
        xQ(paramBoolean3);
      }
      return;
      if (paramBoolean2)
      {
        this.bJv += 1;
        paramInt = i;
        if (this.bJv >= 3)
        {
          paramInt = i;
          if (alib.bs(this.app))
          {
            Bp(2000);
            alib.dI(this.app);
            this.bJv = 0;
            paramInt = i;
          }
        }
      }
      for (;;)
      {
        this.aZB = true;
        if (this.aZu) {
          break label145;
        }
        updateUI();
        break;
        paramInt = i;
        if (paramString != null)
        {
          cp(paramString, 2000);
          paramInt = 1;
        }
      }
      label145:
      this.aZv = true;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, LSRecordPanel paramLSRecordPanel)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QQLSActivity", 4, "handleRecording been called !!!!");
    }
    this.aZB = false;
    if (this.hc.getVisibility() == 0)
    {
      if (paramBoolean1) {
        cp(acfp.m(2131711845), -1);
      }
      while (!paramBoolean2) {
        return;
      }
      cp(acfp.m(2131711846), -1);
      return;
    }
    xQ(false);
  }
  
  public boolean a(XListView paramXListView, int paramInt, View paramView, ChatMessage paramChatMessage)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    return (!paramXListView.isSend()) && (!paramXListView.isReadPtt) && (paramXListView.isReady());
  }
  
  public boolean a(XListView paramXListView, int paramInt1, View paramView, ChatMessage paramChatMessage, AudioPlayerBase paramAudioPlayerBase, int paramInt2)
  {
    paramXListView = (MessageForPtt)paramChatMessage;
    alip.a(this.app).g(paramXListView);
    if (paramXListView.isReady())
    {
      paramView = wja.a(paramView);
      if ((paramView == null) || (!(paramView instanceof e))) {
        return false;
      }
      paramView = (e)paramView;
      if (paramAudioPlayerBase.play(paramXListView.getLocalFilePath()))
      {
        a(paramXListView);
        if (paramView != null) {
          a(paramView, paramXListView, xkx.a(this.app, paramXListView), true);
        }
        aomq.i(this.app, paramXListView.istroop, paramXListView.issend);
        if (!paramXListView.isSendFromLocal())
        {
          if (paramXListView.istroop != 0) {
            break label144;
          }
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      paramXListView = this.app;
      if (paramChatMessage.getPttStreamFlag() == 10001) {}
      for (boolean bool = true;; bool = false)
      {
        aomq.b(paramXListView, paramInt1, bool, 1);
        return true;
        label144:
        if (paramXListView.istroop == 1)
        {
          paramInt1 = 3;
          break;
        }
        if (paramXListView.istroop != 3000) {
          break label254;
        }
        paramInt1 = 2;
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQLSActivity", 2, "play failed player return false " + paramXListView.getLocalFilePath());
      return false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QQLSActivity", 2, "play failed not ready " + paramXListView.getLocalFilePath());
      return false;
      label254:
      paramInt1 = 4;
    }
  }
  
  public void aZP()
  {
    ThreadManager.executeOnSubThread(new QQLSActivity.15(this), true);
  }
  
  public void aZQ()
  {
    ThreadManager.executeOnSubThread(new QQLSActivity.16(this), true);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.setVisibility(4);
      this.dq.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.setVisibility(0);
    this.dq.setVisibility(4);
  }
  
  public void bTc()
  {
    ThreadManager.getSubThreadHandler().post(new QQLSActivity.2(this));
  }
  
  public void bTi()
  {
    if (this.tS != null) {
      return;
    }
    if (MediaPlayerManager.a(this.app).isPlaying()) {
      MediaPlayerManager.a(this.app).stop(true);
    }
    View localView = new View(this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getContext());
    localView.setBackgroundColor(-16777216);
    localView.setVisibility(0);
    Object localObject = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.getGlobalVisibleRect((Rect)localObject);
    Rect localRect = new Rect();
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.getGlobalVisibleRect(localRect);
    localObject = new RelativeLayout.LayoutParams(localRect.right - ((Rect)localObject).left, localRect.top - ((Rect)localObject).top);
    ((RelativeLayout.LayoutParams)localObject).addRule(9, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
    this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.addView(localView, (ViewGroup.LayoutParams)localObject);
    localObject = new AlphaAnimation(0.0F, 0.6F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    localView.startAnimation((Animation)localObject);
    this.tS = localView;
  }
  
  public void bTj()
  {
    if (this.tS == null) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.6F, 0.0F);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setAnimationListener(new voe(this));
    this.tS.startAnimation(localAlphaAnimation);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void d(List<MessageRecord> paramList1, List<MessageRecord> paramList2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + paramList2.size());
    }
    paramList1.addAll(paramList2);
    Collections.sort(paramList1, this.A);
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (isResume()) {
      BaseChatPie.b(this.app.getApp(), paramBoolean3, paramBoolean1, paramBoolean2);
    }
    this.du = paramBoolean3;
  }
  
  protected boolean d(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = MediaPlayerManager.a(this.app).a();
    return (localChatMessage == paramChatMessage) || (((localChatMessage instanceof MessageForPtt)) && (localChatMessage.frienduin != null) && (localChatMessage.frienduin.equals(paramChatMessage.frienduin)) && (localChatMessage.uniseq == paramChatMessage.uniseq));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.EQ != null) && (this.aZw))
    {
      this.aZw = false;
      bTk();
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IndexOutOfBoundsException paramMotionEvent)
    {
      QLog.e("QQLSActivity", 1, paramMotionEvent, new Object[0]);
      return false;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      QLog.e("QQLSActivity", 1, paramMotionEvent, new Object[0]);
    }
    return false;
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onBackPressed=== ");
    }
    bTb();
    bTl();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = this.jdField_a_of_type_Aizf;
    aizf.cmR = true;
    this.lastRefreshTime = -1L;
    anpc.a(this).eW(this);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "qqls dooncreate");
    }
    super.setContentView(2131561420);
    getWindow().addFlags(524288);
    this.mDensity = getResources().getDisplayMetrics().scaledDensity;
    if (!aizf.cmS) {
      ThreadManager.getSubThreadHandler().post(new QQLSActivity.1(this));
    }
    paramBundle = this.handler.obtainMessage(7);
    this.handler.sendMessageDelayed(paramBundle, 1000L);
    this.app = ((QQAppInterface)getAppRuntime());
    this.jdField_b_of_type_Alkm = ((alkm)this.app.getManager(38));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactPhonecontactPhoneContactManagerImp = ((PhoneContactManagerImp)this.app.getManager(11));
    this.jdField_b_of_type_Anxr = ((anxr)this.app.getManager(61));
    if (Qr())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "doOncreate noNeedStart return");
      }
      return true;
    }
    this.pu = this.jdField_b_of_type_Alkm.dq();
    this.jdField_a_of_type_Aizf = ((aizf)this.app.getManager(72));
    paramBundle = this.jdField_a_of_type_Aizf;
    aizf.cmV = false;
    initUI();
    this.app.addObserver(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_g_of_type_Achq);
    this.jdField_b_of_type_Ysf = ((ysf)this.app.getManager(34));
    if (this.jdField_b_of_type_Ysf != null)
    {
      this.jdField_b_of_type_Ysf.a(this.jdField_a_of_type_Ysf$a);
      this.jdField_b_of_type_Ysf.addObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.b(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$c = new c(null);
    aZP();
    this.app.b().addObserver(this);
    bTa();
    this.aZz = true;
    bTh();
    bTf();
    ocp.s(this.handler);
    ce(getIntent());
    return true;
  }
  
  public void doOnDestroy()
  {
    e.clear();
    this.aZC = true;
    ocp.s(null);
    if ((this.app != null) && (this.app.b() != null))
    {
      this.app.b().deleteObserver(this);
      this.app.removeObserver(this.jdField_a_of_type_Achq);
      this.app.removeObserver(this.jdField_g_of_type_Achq);
    }
    aizf localaizf = this.jdField_a_of_type_Aizf;
    aizf.cmU = false;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.cmR = false;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.cmV = false;
    aizf.needReport = false;
    if (this.jdField_b_of_type_Ysf != null)
    {
      this.jdField_b_of_type_Ysf.b(this.jdField_a_of_type_Ysf$a);
      this.jdField_b_of_type_Ysf.deleteObserver(this);
    }
    if (this.handler != null) {
      this.handler.removeCallbacksAndMessages(null);
    }
    bTc();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$c != null) {
      aZQ();
    }
    super.doOnDestroy();
    xQ(false);
    anpc.a(this).eZ(this);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnNewIntent intent is not null");
    }
    aizf.needReport = false;
    aizf localaizf = this.jdField_a_of_type_Aizf;
    aizf.cmR = true;
    this.lastRefreshTime = -1L;
    if (this.pu != null) {
      this.pu.clear();
    }
    if (this.jdField_b_of_type_Alkm != null) {
      this.pu = this.jdField_b_of_type_Alkm.dq();
    }
    if (!Qr())
    {
      bTa();
      if (this.handler.hasMessages(13)) {
        this.handler.removeMessages(13);
      }
      updateUI();
    }
    ce(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    anpc.a(this).eY(this);
    this.mRuntime.isBackground_Pause = true;
    Object localObject = this.jdField_a_of_type_Aizf;
    aizf.cmU = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onPause,isbackground_pause : true");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttLSRecordPanel.onPause();
    this.aZu = true;
    if (this.handler.hasMessages(8)) {
      this.handler.removeMessages(8);
    }
    localObject = this.handler.obtainMessage(8);
    this.handler.sendMessageDelayed((Message)localObject, 1500L);
    bTn();
    MediaPlayerManager.a(this.app).stop(true);
    if (this.hc.getVisibility() == 0)
    {
      MediaPlayerManager.a(this.app).c(this.t);
      return;
    }
    MediaPlayerManager.a(this.app).c(this.s);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "doOnResume taskId" + getTaskId());
    }
    aizf.needReport = false;
    anpc.a(this).eX(this);
    Object localObject = this.jdField_a_of_type_Aizf;
    aizf.cmU = true;
    this.mRuntime.isBackground_Pause = true;
    if (this.d != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    }
    localObject = this.handler.obtainMessage(11);
    this.handler.sendMessageDelayed((Message)localObject, 500L);
    this.aZu = false;
    if (this.aZv)
    {
      this.aZv = false;
      updateUI();
    }
    if (this.hc.getVisibility() == 0)
    {
      MediaPlayerManager.a(this.app).a(this.t, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d, this, this, true, false);
      return;
    }
    MediaPlayerManager.a(this.app).a(this.s, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a, this, this, false, false);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    aizf localaizf = this.jdField_a_of_type_Aizf;
    aizf.cmR = false;
    localaizf = this.jdField_a_of_type_Aizf;
    aizf.cmU = false;
    if (this.d != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
    }
    if (this.handler.hasMessages(8)) {
      this.handler.removeMessages(8);
    }
    bTc();
  }
  
  public boolean e(ChatMessage paramChatMessage)
  {
    return true;
  }
  
  protected void ei(View paramView)
  {
    MessageForPtt localMessageForPtt = (MessageForPtt)wja.a(paramView);
    paramView = (e)wja.a(paramView);
    if (localMessageForPtt.isSendFromLocal())
    {
      paramView = ausj.b(this);
      paramView.setMainTitle(2131690231);
      paramView.addButton(2131690230);
      paramView.addCancelButton(2131721058);
      paramView.a(new vok(this, localMessageForPtt, paramView));
      paramView.show();
      return;
    }
    if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
    {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        QQToast.a(BaseApplication.getContext(), 2131696376, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131719247, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
      return;
    }
    a(paramView, localMessageForPtt, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + localMessageForPtt.url + "|uniseq " + localMessageForPtt.uniseq);
    }
    a(paramView, localMessageForPtt, 2001, false);
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqPttTouchProxyRelativeLayout.setVisibility(4);
      aizf localaizf = this.jdField_a_of_type_Aizf;
      aizf.cmU = false;
      if (this.jdField_a_of_type_Aizf != null) {
        this.jdField_a_of_type_Aizf.cOx();
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLSActivity", 2, "LSActivity finish");
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          super.finish();
          return;
        }
        catch (Exception localException2)
        {
          QLog.e("QQLSActivity", 2, localException2, new Object[0]);
        }
        localException1 = localException1;
        if (QLog.isColorLevel()) {
          QLog.e("QQLSActivity", 2, localException1, new Object[0]);
        }
      }
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isResume()) {
      BaseChatPie.b(this.app.getApp(), paramBoolean2, false, false);
    }
    this.du = paramBoolean2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Arjn != null) && (this.jdField_a_of_type_Arjn.isShowing()) && (this.jdField_a_of_type_Arjn.getWindow() != null) && (!isFinishing()))
      {
        this.jdField_a_of_type_Arjn.dismiss();
        this.jdField_a_of_type_Arjn = null;
        continue;
        bTm();
        finish();
        continue;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d.notifyDataSetChanged();
      }
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$d.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity$a.notifyDataSetChanged();
    }
  }
  
  public void onClick(View paramView)
  {
    if ((aTl) && (paramView.getId() == 2131363321)) {
      paramView.findViewById(2131374798).performClick();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363823: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onClick btn_close");
        }
        aizf.acc = System.currentTimeMillis();
        bTb();
        anot.a(this.app, "CliOper", "", "", "0X80040DE", "0X80040DE", 0, 0, "", "", "", "");
        bTl();
        break;
      case 2131363968: 
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "onClick btn_reply");
        }
        bTb();
        if ((this.d == null) || (this.d.getText().length() != 0)) {
          if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "onClick mSingleRecentBaseData=null return");
            }
          }
          else
          {
            if (this.d != null) {
              ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
            }
            Toast.makeText(getApplicationContext(), getString(2131701312), 0).show();
            if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.ng() == 3000) {
              anot.a(this.app, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "1", "", "", "");
            }
            for (;;)
            {
              localObject = this.handler.obtainMessage(1);
              this.handler.sendMessageDelayed((Message)localObject, 100L);
              break;
              if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.ng() == 1) {
                anot.a(this.app, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "2", "", "", "");
              } else {
                anot.a(this.app, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "0", "", "", "");
              }
            }
          }
        }
        break;
      case 2131374798: 
        localObject = (e)wja.a(paramView);
        MessageForPtt localMessageForPtt = (MessageForPtt)((e)localObject).mMessage;
        if (d(localMessageForPtt)) {
          MediaPlayerManager.a(this.app).stop(false);
        }
        while (localMessageForPtt.istroop == 1008)
        {
          kbp.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005857", "0X8005857", 0, 0, "", "", localMessageForPtt.timeStr, "", false);
          break;
          if ((localMessageForPtt != MediaPlayerManager.a(this.app).a()) && (localMessageForPtt.isReady()))
          {
            if (!this.app.bF()) {
              break label578;
            }
            QQToast.a(this, 1, 2131697385, 0).show(getResources().getDimensionPixelSize(2131299627));
          }
        }
        if ((localObject instanceof b)) {}
        for (boolean bool = MediaPlayerManager.a(this.app).k(wja.a(paramView)); !bool; bool = MediaPlayerManager.a(this.app).k(wja.a(paramView)))
        {
          QQToast.a(this, 1, 2131697384, 0).show(getResources().getDimensionPixelSize(2131299627));
          break;
        }
      case 2131364510: 
        label578:
        ei(paramView);
      }
    }
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "logout finish");
    }
    bTl();
    super.onLogout(paramLogoutReason);
  }
  
  public void onPlayStart()
  {
    getWindow().addFlags(128);
  }
  
  public void onPlayStop()
  {
    setVolumeControlStream(3);
    getWindow().clearFlags(128);
    this.uiHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  @Deprecated
  public void onStart()
  {
    Foreground.sCountActivity -= 1;
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onStart taskId" + getTaskId());
    }
    if (getTaskId() == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "getTadk = -1 finish LS ,or onresume will get badToken!");
      }
      finish();
    }
    try
    {
      Field localField = Activity.class.getDeclaredField("mFinished");
      localField.setAccessible(true);
      localField.get(this);
      localField.set(this, Boolean.valueOf(true));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Foreground.sCountActivity += 1;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onUserLeaveHint()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "onUserLeaveHint");
    }
    aizf.needReport = false;
    bTb();
    super.onUserLeaveHint();
  }
  
  public List<MessageRecord> q(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.pu == null) || (this.pu.size() == 0)) {
      return localArrayList;
    }
    Iterator localIterator = this.pu.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.frienduin.equals(paramString)) && (localMessageRecord.istroop == paramInt)) {
        localArrayList.add(localMessageRecord);
      }
    }
    Collections.sort(localArrayList, this.A);
    return localArrayList;
  }
  
  public void send()
  {
    new SessionInfo();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData == null) {}
    SessionInfo localSessionInfo;
    do
    {
      return;
      this.app.b().ca(this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.qx(), this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.ng());
      if (QLog.isColorLevel()) {
        QLog.d("notification", 2, "QQLSActivity send removeNotification");
      }
      this.app.cLs();
      localSessionInfo = a(this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, " send start currenttime:" + System.currentTimeMillis());
      }
    } while (this.d.getText().length() <= 0);
    Object localObject = this.d.getText().toString();
    if ((localObject != null) && (((String)localObject).length() > 3478))
    {
      ChatActivityUtils.h(this, 2131719509, 1);
      return;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqActivityRecentRecentBaseData.ng() == 1)
    {
      localObject = new ArrayList();
      String str = appb.a(this.d.getEditableText(), (ArrayList)localObject);
      ujt.a(this.app, this, localSessionInfo, str, (ArrayList)localObject);
    }
    for (;;)
    {
      this.d.getEditableText().clear();
      this.d.setText("");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      return;
      ujt.a(this.app, this, localSessionInfo, (String)localObject, null);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "update" + Thread.currentThread().getId());
    }
    boolean bool = isKeyguardLock();
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "LS update isScreenLocked" + bool);
    }
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "LS update screen is unLock finish!!!");
      }
      paramObservable = this.handler.obtainMessage(2);
      this.handler.sendMessage(paramObservable);
    }
    label308:
    label750:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (!isFinishing()) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.d("QQLSActivity", 2, "LS update screen is finishing not update");
                  return;
                  if ((this.d == null) || (this.d.getVisibility() != 0) || (TextUtils.isEmpty(this.d.getText()))) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("QQLSActivity", 2, "LS update user is sendMsg not update");
                return;
                this.aZA = false;
                if ((paramObject == null) || (!(paramObject instanceof ytv))) {
                  break label308;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("QQLSActivity", 2, "data is NewFriendMessage" + Thread.currentThread().getId());
                }
                if (this.jdField_b_of_type_Ysf.xq() != 0) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("QQLSActivity", 2, "data is NewFriendMessage unread=0 update return");
              return;
              if ((paramObject instanceof ytq)) {
                a((ytq)paramObject);
              }
              this.jdField_a_of_type_Aizf.a(this.app, acbn.bkA, 4000, false, -1, false);
              updateUI();
              return;
              if ((paramObject != null) && ((paramObject instanceof RecentItemVoteData)))
              {
                paramObservable = ((RecentItemVoteData)paramObject).a();
                this.jdField_a_of_type_Aizf.a(this.app, paramObservable.uin, paramObservable.msgType, false, -1, false);
                paramObservable = this.jdField_a_of_type_Aizf;
                aizf.cmS = false;
                updateUI();
              }
              for (;;)
              {
                if ((paramObject != null) && ((paramObject instanceof ChatMessage))) {
                  break label531;
                }
                if ((!QLog.isColorLevel()) || (paramObject == null)) {
                  break;
                }
                QLog.d("QQLSActivity", 2, "update data is not chatMessage return" + paramObject.getClass());
                return;
                if ((paramObject != null) && ((paramObject instanceof RecentItemScheduleData)))
                {
                  paramObservable = ((RecentItemScheduleData)paramObject).a();
                  this.jdField_a_of_type_Aizf.a(this.app, paramObservable.uin, paramObservable.msgType, false, -1, false);
                  paramObservable = this.jdField_a_of_type_Aizf;
                  aizf.cmS = false;
                  updateUI();
                }
                else if ((paramObject != null) && ((paramObject instanceof RecentItemPullActivePush)))
                {
                  paramObservable = ((RecentItemPullActivePush)paramObject).a();
                  this.jdField_a_of_type_Aizf.a(this.app, paramObservable.uin, paramObservable.getType(), false, -1, false);
                  paramObservable = this.jdField_a_of_type_Aizf;
                  aizf.cmS = false;
                  updateUI();
                }
              }
              paramObservable = (ChatMessage)paramObject;
            } while ((paramObservable.isSend()) || (paramObservable.istroop == 6000) || (paramObservable.istroop == 1009) || (paramObservable.istroop == 1036) || (wvo.a(paramObservable.frienduin, paramObservable.istroop, this.app)));
            paramObject = this.jdField_a_of_type_Aizf;
            if (paramObservable.istroop == 1) {}
            for (bool = true;; bool = false)
            {
              aizf.cmS = bool;
              paramObject = this.jdField_a_of_type_Aizf;
              if ((!aizf.cmS) && (this.jdField_a_of_type_Aqlm == null)) {
                ThreadManager.getSubThreadHandler().post(new QQLSActivity.11(this));
              }
              if ((!top.v(paramObservable)) || (top.d(this.app, paramObservable))) {
                break label750;
              }
              if ((1001 != paramObservable.istroop) && (10002 != paramObservable.istroop)) {
                break;
              }
              this.jdField_a_of_type_Aizf.a(this.app, acbn.ble, paramObservable.istroop, false, -1, false);
              updateUI();
              return;
            }
          } while (1010 != paramObservable.istroop);
          this.jdField_a_of_type_Aizf.a(this.app, acbn.blf, paramObservable.istroop, false, -1, false);
          updateUI();
          return;
          if (paramObservable.istroop != 1) {
            break;
          }
        } while (((HotChatManager)this.app.getManager(60)).kj(paramObservable.frienduin));
        paramObject = (aqlz)this.app.getManager(31);
      } while ((paramObject != null) && (paramObject.ar(paramObservable.frienduin, 1) != 1));
    } while ((top.g(this.app, paramObservable.frienduin, paramObservable.istroop)) || ((paramObservable.istroop == 1008) && ((paramObservable.extStr == null) || (((paramObservable.extLong & 0x1) == 0) && (!paramObservable.extStr.contains("lockDisplay"))) || (paramObservable.extStr == null) || (((paramObservable.extLong & 0x1) == 1) && (!paramObservable.getExtInfoFromExtStr("lockDisplay").equals("true"))))) || ((paramObservable.istroop == 7220) && ((paramObservable.extInt == 5) || (paramObservable.extInt == 6))) || ((paramObservable.istroop == 7220) && (paramObservable.extInt == 2) && (TextUtils.equals(paramObservable.senderuin, acbn.blw))));
    label531:
    this.jdField_a_of_type_Aizf.a(this.app, paramObservable.frienduin, paramObservable.istroop, false, -1, false);
    updateUI();
  }
  
  public void updateUI()
  {
    long l;
    Message localMessage;
    if (!this.handler.hasMessages(13))
    {
      l = SystemClock.uptimeMillis();
      localMessage = this.handler.obtainMessage(13);
      if ((l - this.lastRefreshTime > 1000L) || (this.lastRefreshTime == -1L)) {
        this.handler.sendMessage(localMessage);
      }
    }
    else
    {
      return;
    }
    this.handler.sendMessageDelayed(localMessage, 1000L - (l - this.lastRefreshTime));
  }
  
  public void xP(boolean paramBoolean)
  {
    this.aZy = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("QQLSActivity", 2, "sensor has callback sensorIsClose===" + this.aZy);
    }
    if (this.aZy) {
      this.aZz = false;
    }
    do
    {
      this.aZA = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "callback firstTimeToWakeScreen=" + this.aZz);
      }
    } while (!this.aZz);
    if (Qs()) {
      bTg();
    }
    for (;;)
    {
      this.aZz = false;
      break;
      acquireWakeLock();
    }
  }
  
  public void zR(int paramInt)
  {
    setVolumeControlStream(3);
  }
  
  public void zS(int paramInt)
  {
    setVolumeControlStream(paramInt);
  }
  
  public void zT(int paramInt)
  {
    if (isFinishing()) {}
    do
    {
      do
      {
        return;
        if (paramInt != 0) {
          break;
        }
        anot.a(this.app, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
        this.uiHandler.removeMessages(25);
      } while ((this.jdField_a_of_type_Arjn != null) && (this.jdField_a_of_type_Arjn.isShowing()));
      this.jdField_a_of_type_Arjn = new arjn(this);
      this.jdField_a_of_type_Arjn.setTips(getString(2131700646));
      this.jdField_a_of_type_Arjn.show();
      return;
    } while ((paramInt != 1) || (this.jdField_a_of_type_Arjn == null) || (!this.jdField_a_of_type_Arjn.isShowing()) || (this.jdField_a_of_type_Arjn.getWindow() == null));
    this.jdField_a_of_type_Arjn.dismiss();
  }
  
  public static class SyncTroopSummaryTask
    implements Runnable
  {
    WeakReference<QQAppInterface> bV;
    String frienduin;
    auru g;
    String senderuin;
    
    public SyncTroopSummaryTask(QQAppInterface paramQQAppInterface, auru paramauru, String paramString1, String paramString2)
    {
      this.bV = new WeakReference(paramQQAppInterface);
      this.g = paramauru;
      this.senderuin = paramString1;
      this.frienduin = paramString2;
    }
    
    public void run()
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.bV.get();
      String str = this.frienduin.concat(this.senderuin);
      if ((localQQAppInterface != null) && (this.g != null) && (!QQLSActivity.a().contains(str)))
      {
        QQLSActivity.a().add(str);
        aqgv.h(localQQAppInterface, this.frienduin, this.senderuin);
        this.g.sendEmptyMessage(17);
      }
    }
  }
  
  public class a
    extends auvp
  {
    CharSequence content = "";
    private ArrayList<RecentBaseData> pi = new ArrayList();
    
    public a() {}
    
    private View e(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        paramViewGroup = paramView.getTag();
        if (!(paramViewGroup instanceof QQLSActivity.g)) {}
      }
      for (paramViewGroup = (QQLSActivity.g)paramViewGroup;; paramViewGroup = null)
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)this.pi.get(paramInt);
        Object localObject = paramViewGroup;
        if (paramViewGroup == null)
        {
          paramView = QQLSActivity.this.getLayoutInflater().inflate(2131561423, null);
          localObject = new QQLSActivity.g();
          ((QQLSActivity.g)localObject).BM = ((TextView)paramView.findViewById(2131374920));
          ((QQLSActivity.g)localObject).f = ((DragTextView)paramView.findViewById(2131374926));
          ((QQLSActivity.g)localObject).f.setOnModeChangeListener(QQLSActivity.this.a);
          ((QQLSActivity.g)localObject).f.setDragViewType(0);
          paramView.setTag(localObject);
        }
        ((QQLSActivity.g)localObject).f.setTag(Integer.valueOf(paramInt));
        ((QQLSActivity.g)localObject).BM.setText(localRecentBaseData.mTitleName);
        ((QQLSActivity.g)localObject).f.setVisibility(0);
        aute.updateCustomNoteTxt(((QQLSActivity.g)localObject).f, 3, 1, 0);
        return paramView;
      }
    }
    
    public View f(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject3 = (RecentBaseData)this.pi.get(paramInt);
      Object localObject1 = QQLSActivity.a(QQLSActivity.this).b().a(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
      paramViewGroup = QQLSActivity.a(QQLSActivity.this).b().a(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng(), ((MessageRecord)localObject1).uniseq);
      if (((RecentBaseData)localObject3).ng() == 1032) {
        paramViewGroup = aegu.b(QQLSActivity.a(QQLSActivity.this), (MessageRecord)localObject1);
      }
      if (paramView != null)
      {
        localObject1 = paramView;
        if ((paramView.getTag() instanceof QQLSActivity.b)) {}
      }
      else
      {
        localObject1 = QQLSActivity.this.getLayoutInflater().inflate(2131561424, null);
        paramView = new QQLSActivity.b();
        paramView.BM = ((TextView)((View)localObject1).findViewById(2131374920));
        paramView.kG = ((TextView)((View)localObject1).findViewById(2131374925));
        paramView.f = ((DragTextView)((View)localObject1).findViewById(2131374926));
        ((View)localObject1).setTag(paramView);
        paramView.f.setOnModeChangeListener(QQLSActivity.this.a);
        paramView.f.setDragViewType(0);
        paramView.ET = ((TextView)((View)localObject1).findViewById(2131374802));
        paramView.qM = ((ImageView)((View)localObject1).findViewById(2131374797));
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)((View)localObject1).findViewById(2131374798));
      }
      QQLSActivity.b localb = (QQLSActivity.b)((View)localObject1).getTag();
      localb.f.setTag(Integer.valueOf(paramInt));
      int i = 0;
      if ((((RecentBaseData)localObject3).qx().equals(acbn.ble)) || (((RecentBaseData)localObject3).qx().equals(acbn.blf))) {
        i = 1;
      }
      int j;
      if (i != 0)
      {
        i = 0;
        j = 0;
      }
      for (;;)
      {
        label398:
        label464:
        Object localObject2;
        if ((((RecentBaseData)localObject3).ng() == 0) || (((RecentBaseData)localObject3).ng() == 3000) || (((RecentBaseData)localObject3).ng() == 8)) {
          if (j > 0)
          {
            paramView = QQLSActivity.this.q(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
            if ((paramView == null) || (paramView.size() <= 0))
            {
              this.content = ((RecentBaseData)localObject3).mLastMsg;
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
              }
              localb.BM.setText(((RecentBaseData)localObject3).mTitleName);
              localb.kG.setText(((RecentBaseData)localObject3).mShowTime);
              if (((RecentBaseData)localObject3).ng() == 4000) {
                i = QQLSActivity.this.b.xq();
              }
              if (i + j != 0) {
                break label1537;
              }
              localb.f.setVisibility(4);
              if ((((RecentBaseData)localObject3).qx().equals(acbn.blf)) || (((RecentBaseData)localObject3).qx().equals(acbn.ble))) {
                localb.f.setVisibility(8);
              }
              paramView = new BaseChatItemLayout(QQLSActivity.this);
              paramView.setId(2131363321);
              paramView.setFocusableInTouchMode(true);
              paramView.setPadding(BaseChatItemLayout.paddingLeft, BaseChatItemLayout.paddingTop, BaseChatItemLayout.paddingRight, 0);
              localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
              if ((paramViewGroup instanceof MessageForPtt))
              {
                localObject2 = (MessageForPtt)paramViewGroup;
                paramView = QQLSActivity.a(QQLSActivity.this, paramViewGroup);
                ((TextView)((View)localObject1).findViewById(2131374799)).setText(paramView);
                localObject3 = (ViewGroup.MarginLayoutParams)localb.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
                if (paramView.equals("")) {
                  break label1564;
                }
                ((ViewGroup.MarginLayoutParams)localObject3).setMargins(wja.dp2px(5.0F, QQLSActivity.this.getResources()), wja.dp2px(7.0F, QQLSActivity.this.getResources()), 0, 0);
                j = xkx.a(QQLSActivity.a(QQLSActivity.this), (MessageForPtt)localObject2);
                i = j;
                if (j == -1)
                {
                  QQLSActivity.this.a(localb, (MessageForPtt)localObject2, false, true);
                  i = 2001;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + ((MessageForPtt)localObject2).url + " uniseq " + ((MessageForPtt)localObject2).uniseq);
                }
                QQLSActivity.this.a(localb, (MessageForPtt)localObject2, i, QQLSActivity.this.d((ChatMessage)localObject2));
                aomq.a(QQLSActivity.a(QQLSActivity.this), i, paramViewGroup);
                wla.a(QQLSActivity.a(QQLSActivity.this)).a((View)localObject1, QQLSActivity.this);
                if ((QQLSActivity.kC()) && (localb.E == null)) {
                  localb.E = new StringBuilder();
                }
                localb.pos = paramInt;
                localb.count = paramInt;
                if (QQLSActivity.kC())
                {
                  localb.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
                  if (!TextUtils.isEmpty(localb.E)) {
                    localb.E.replace(0, localb.E.length(), "");
                  }
                  if ((!((ChatMessage)paramViewGroup).mNeedTimeStamp) || (paramViewGroup.time <= 0L)) {}
                }
              }
            }
          }
        }
        try
        {
          paramView = aqmu.a(QQLSActivity.this, 3, paramViewGroup.time * 1000L);
          localb.E.append(paramView).append(" ");
          localb.mMessage = ((ChatMessage)paramViewGroup);
          alip.a(QQLSActivity.a(QQLSActivity.this)).f((MessageForPtt)localObject2);
          return localObject1;
          i = QQLSActivity.a(QQLSActivity.this).a().A(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
          j = QQLSActivity.this.P(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
          }
          localObject2 = QQLSActivity.a(QQLSActivity.this).b().a(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
          long l1 = ((RecentBaseData)localObject3).eI();
          long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
          if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject2).msgtype != -2016) && (((MessageRecord)localObject2).msgtype != -2009) && (((MessageRecord)localObject2).msgtype != -2026))
          {
            this.content = ((RecentBaseData)localObject3).mLastMsg;
            break label398;
          }
          this.content = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
          break label398;
          this.content = ((RecentBaseData)localObject3).mLastMsg;
          break label398;
          if ((((RecentBaseData)localObject3).ng() == 1001) || (((RecentBaseData)localObject3).ng() == 1010) || (((RecentBaseData)localObject3).ng() == 10002))
          {
            if (((RecentBaseData)localObject3).qx().equals(acbn.blf))
            {
              ((RecentBaseData)localObject3).mTitleName = BaseApplicationImpl.getApplication().getString(2131692433);
              this.content = BaseApplicationImpl.getApplication().getString(2131692432);
              paramView = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
              if (paramView.length() <= 0) {
                break label398;
              }
              paramView = paramView.split("\\|");
              if (paramView.length < 6) {
                break label398;
              }
              ((RecentBaseData)localObject3).mTitleName = paramView[4];
              this.content = paramView[5];
              break label398;
            }
            if (((RecentBaseData)localObject3).qx().equals(acbn.ble))
            {
              ((RecentBaseData)localObject3).mTitleName = BaseApplicationImpl.getApplication().getString(2131695210);
              this.content = BaseApplicationImpl.getApplication().getString(2131695209);
              paramView = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
              if (paramView.length() <= 0) {
                break label398;
              }
              paramView = paramView.split("\\|");
              if (paramView.length < 6) {
                break label398;
              }
              ((RecentBaseData)localObject3).mTitleName = paramView[4];
              this.content = paramView[5];
              break label398;
            }
            QQMessageFacade.Message localMessage = QQLSActivity.a(QQLSActivity.this).b().a(((RecentBaseData)localObject3).qx(), ((RecentBaseData)localObject3).ng());
            localObject2 = aqgv.G(QQLSActivity.a(QQLSActivity.this), localMessage.senderuin);
            paramView = (View)localObject2;
            if (localObject2 == null) {
              paramView = "";
            }
            this.content = (paramView + ": " + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessage, false));
            break label398;
          }
          this.content = ((RecentBaseData)localObject3).mLastMsg;
          break label398;
          label1537:
          localb.f.setVisibility(0);
          aute.updateCustomNoteTxt(localb.f, 3, j + i, 0);
          break label464;
          label1564:
          ((ViewGroup.MarginLayoutParams)localObject3).setMargins(0, wja.dp2px(7.0F, QQLSActivity.this.getResources()), 0, 0);
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramView = "";
          }
        }
      }
    }
    
    public int getCount()
    {
      return this.pi.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.pi.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.pi.size()))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)this.pi.get(paramInt);
        QQMessageFacade.Message localMessage = QQLSActivity.a(QQLSActivity.this).b().a(localRecentBaseData.qx(), localRecentBaseData.ng());
        if ((localRecentBaseData.ng() == 1012) || (localRecentBaseData.ng() == 7432) || (localRecentBaseData.ng() == 1030) || (localRecentBaseData.ng() == 1035)) {
          return 1;
        }
        if ((localMessage != null) && ((localMessage.msgtype == -2002) || (localMessage.msgtype == -1031))) {
          return 2;
        }
        if ((localMessage != null) && (localMessage.msgtype == -2025)) {
          return 3;
        }
        if (localRecentBaseData.ng() == 9653) {
          return 4;
        }
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      System.currentTimeMillis();
      int m = getItemViewType(paramInt);
      if ((m == 1) || (m == 4)) {}
      for (View localView = e(paramInt, paramView, paramViewGroup);; localView = f(paramInt, paramView, paramViewGroup))
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        if (m != 2) {
          break;
        }
      }
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof QQLSActivity.f)) {}
      }
      else
      {
        localView = QQLSActivity.this.getLayoutInflater().inflate(2131561422, null);
        paramView = new QQLSActivity.f();
        paramView.BM = ((TextView)localView.findViewById(2131374920));
        paramView.EU = ((TextView)localView.findViewById(2131374924));
        paramView.kG = ((TextView)localView.findViewById(2131374925));
        paramView.f = ((DragTextView)localView.findViewById(2131374926));
        paramView.qN = ((ImageView)localView.findViewById(2131374927));
        localView.setTag(paramView);
        paramView.f.setOnModeChangeListener(QQLSActivity.this.a);
        paramView.f.setDragViewType(0);
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)this.pi.get(paramInt);
      QQLSActivity.f localf = (QQLSActivity.f)localView.getTag();
      localf.f.setTag(Integer.valueOf(paramInt));
      int i = 0;
      int k = 0;
      if ((localRecentBaseData.qx().equals(acbn.ble)) || (localRecentBaseData.qx().equals(acbn.blf))) {
        i = 1;
      }
      int j;
      if (i != 0)
      {
        j = 0;
        i = k;
        label292:
        if (m == 3)
        {
          paramView = QQLSActivity.a(QQLSActivity.this).b().a(localRecentBaseData.qx(), localRecentBaseData.ng());
          if (paramView != null) {
            localRecentBaseData.mLastMsg = QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, paramView, false);
          }
        }
        paramView = localRecentBaseData.mTitleName;
        if ((localRecentBaseData.ng() != 0) && (localRecentBaseData.ng() != 3000) && (localRecentBaseData.ng() != 8)) {
          break label1156;
        }
        if (j <= 0) {
          break label1099;
        }
        localf.qN.setVisibility(0);
        localObject1 = QQLSActivity.this.q(localRecentBaseData.qx(), localRecentBaseData.ng());
        if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
          break label879;
        }
        this.content = localRecentBaseData.mLastMsg;
        localf.EU.setTextColor(-4210755);
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
        }
        label467:
        localf.kG.setText(localRecentBaseData.mShowTime);
      }
      for (;;)
      {
        if ((localRecentBaseData.ng() == 8) && (localRecentBaseData.mExtraType == 25))
        {
          localObject1 = (ajdo)QQLSActivity.a(QQLSActivity.this).getManager(11);
          if (localObject1 == null) {
            break label2051;
          }
          localObject1 = ((ajdo)localObject1).c(localRecentBaseData.mPhoneNumber);
          label536:
          if (localObject1 == null) {
            break label1980;
          }
          localRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
          label551:
          if (localRecentBaseData.mTitleName.equals(localRecentBaseData.qx())) {
            localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("QQLSActivity", 4, "getView mTitleName = " + localRecentBaseData.mTitleName);
          }
        }
        localf.BM.setText(paramView);
        localf.EU.setText(new aofk(this.content, 5, 16, localRecentBaseData.ng()));
        localf.kG.setText(localRecentBaseData.mShowTime);
        if (localRecentBaseData.ng() == 4000) {
          i = QQLSActivity.this.b.xq();
        }
        if (((!TextUtils.equals(localRecentBaseData.qx(), acbn.blx)) || (localRecentBaseData.ng() != 7220)) && ((!TextUtils.equals(localRecentBaseData.qx(), acbn.blP)) || (localRecentBaseData.ng() != 1008)))
        {
          k = i;
          if (TextUtils.equals(localRecentBaseData.qx(), acbn.blw))
          {
            k = i;
            if (localRecentBaseData.ng() != 1008) {}
          }
        }
        else
        {
          k = 1;
        }
        if (k + j != 0) {
          break label2024;
        }
        localf.f.setVisibility(4);
        label788:
        if ((localRecentBaseData.qx().equals(acbn.blf)) || (localRecentBaseData.qx().equals(acbn.ble))) {
          localf.f.setVisibility(8);
        }
        paramView = localView;
        break;
        i = QQLSActivity.a(QQLSActivity.this).a().A(localRecentBaseData.qx(), localRecentBaseData.ng());
        j = QQLSActivity.this.P(localRecentBaseData.qx(), localRecentBaseData.ng());
        break label292;
        label879:
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + ((List)localObject1).size());
        }
        Object localObject2 = QQLSActivity.a(QQLSActivity.this).b().a(localRecentBaseData.qx(), localRecentBaseData.ng());
        long l1 = localRecentBaseData.eI();
        long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
        if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject2).msgtype != -2016) && (((MessageRecord)localObject2).msgtype != -2009) && (((MessageRecord)localObject2).msgtype != -2026) && (localRecentBaseData.ng() != 8))
        {
          this.content = localRecentBaseData.mLastMsg;
          localf.EU.setTextColor(-4210755);
          break label467;
        }
        this.content = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
        localf.EU.setTextColor(-570319);
        break label467;
        label1099:
        localf.qN.setVisibility(8);
        this.content = ((String)localRecentBaseData.mMsgExtroInfo + localRecentBaseData.mLastMsg);
        localf.EU.setTextColor(-4210755);
        continue;
        label1156:
        if ((localRecentBaseData.ng() == 1001) || (localRecentBaseData.ng() == 1010) || (localRecentBaseData.ng() == 10002))
        {
          if (localRecentBaseData.qx().equals(acbn.blf))
          {
            localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131692433);
            this.content = BaseApplicationImpl.getApplication().getString(2131692432);
            localObject1 = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            if (((String)localObject1).length() > 0)
            {
              localObject1 = ((String)localObject1).split("\\|");
              if (localObject1.length >= 6)
              {
                localRecentBaseData.mTitleName = localObject1[4];
                this.content = localObject1[5];
              }
            }
          }
          for (;;)
          {
            localf.EU.setTextColor(-4210755);
            localf.qN.setVisibility(8);
            break;
            if (localRecentBaseData.qx().equals(acbn.ble))
            {
              localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131695210);
              this.content = BaseApplicationImpl.getApplication().getString(2131695209);
              localObject1 = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
              if (((String)localObject1).length() > 0)
              {
                localObject1 = ((String)localObject1).split("\\|");
                if (localObject1.length >= 6)
                {
                  localRecentBaseData.mTitleName = localObject1[4];
                  this.content = localObject1[5];
                }
              }
            }
            else
            {
              QQMessageFacade.Message localMessage = QQLSActivity.a(QQLSActivity.this).b().a(localRecentBaseData.qx(), localRecentBaseData.ng());
              if (localMessage.msgtype == -2053)
              {
                localObject1 = (MessageForNearbyLiveTip)anbi.d(-2053);
                ((MessageForNearbyLiveTip)localObject1).msgData = localMessage.msgData;
                ((MessageForNearbyLiveTip)localObject1).parse();
                localObject2 = ((MessageForNearbyLiveTip)localObject1).nickName;
                this.content = (QQLSActivity.this.getString(2131701402) + (String)localObject2 + ((MessageForNearbyLiveTip)localObject1).msg);
              }
              else
              {
                localObject2 = aqgv.G(QQLSActivity.a(QQLSActivity.this), localMessage.senderuin);
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "";
                }
                this.content = ((String)localObject1 + ": " + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessage, false));
              }
            }
          }
        }
        if ((localRecentBaseData.ng() != 1041) && (localRecentBaseData.ng() != 1042)) {
          break label1665;
        }
        paramView = (RecentItemNoticeData)localRecentBaseData;
        this.content = ((RecentItemNoticeData)localRecentBaseData).wording;
        paramView = QQLSActivity.this.getResources().getString(2131696301);
        i = 1;
      }
      label1665:
      if (localRecentBaseData.ng() == 1)
      {
        localObject1 = QQLSActivity.a(QQLSActivity.this).b().a(localRecentBaseData.qx(), localRecentBaseData.ng());
        localObject1 = QQLSActivity.a(QQLSActivity.this).b().b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
        if ((!(localObject1 instanceof MessageForPubAccount)) || (((MessageForPubAccount)localObject1).isTextMsg())) {}
      }
      for (Object localObject1 = obt.a(QQLSActivity.a(QQLSActivity.this), BaseApplicationImpl.getContext()) + ":";; localObject1 = "")
      {
        this.content = ((String)localObject1 + localRecentBaseData.mLastMsg);
        if (10007 == localRecentBaseData.ng()) {
          this.content = ahtc.a(QQLSActivity.a(QQLSActivity.this), localRecentBaseData, (String)localRecentBaseData.mLastMsg);
        }
        if (localRecentBaseData.ng() == 7220)
        {
          localObject1 = ((KandianMergeManager)QQLSActivity.a(QQLSActivity.this).getManager(162)).d();
          if (localObject1 != null) {
            this.content = QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, (MessageRecord)localObject1, false);
          }
        }
        if ((TextUtils.isEmpty(this.content)) && ((localRecentBaseData instanceof RecentItemTroopMsgData)))
        {
          localObject1 = ((RecentItemTroopMsgData)localRecentBaseData).a().msg;
          if ((localObject1 instanceof aamb)) {
            this.content = ((aamb)localObject1).content;
          }
        }
        localf.EU.setTextColor(-4210755);
        localf.qN.setVisibility(8);
        break;
        label1980:
        localObject1 = ((alkf)QQLSActivity.a(QQLSActivity.this).getManager(140)).a(localRecentBaseData.qx());
        if (localObject1 == null) {
          break label551;
        }
        localRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
        break label551;
        label2024:
        localf.f.setVisibility(0);
        aute.updateCustomNoteTxt(localf.f, 3, k + j, 0);
        break label788;
        label2051:
        localObject1 = null;
        break label536;
      }
    }
    
    public int getViewTypeCount()
    {
      return 5;
    }
    
    public void setList(ArrayList<RecentBaseData> paramArrayList)
    {
      if (paramArrayList != null)
      {
        this.pi.clear();
        this.pi.addAll((List)paramArrayList.clone());
        notifyDataSetChanged();
      }
    }
  }
  
  static class b
    extends QQLSActivity.e
  {
    TextView BM;
    DragTextView f;
    TextView kG;
  }
  
  class c
    extends BroadcastReceiver
  {
    private String action;
    
    private c() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (QQLSActivity.f(QQLSActivity.this)) {}
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramIntent != null) {}
            try
            {
              this.action = paramIntent.getAction();
              if ("android.intent.action.SCREEN_ON".equals(this.action))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON");
              }
            }
            catch (Exception paramContext)
            {
              QLog.e("QQLSActivity", 1, paramContext, new Object[0]);
              return;
            }
          }
          if (!"android.intent.action.SCREEN_OFF".equals(this.action)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF");
        return;
      } while (!"android.intent.action.USER_PRESENT".equals(this.action));
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder().append("ScreenBroadcastReceiver ACTION_USER_PRESENTmanager.isEnterAio");
        paramIntent = QQLSActivity.this.a;
        QLog.d("QQLSActivity", 2, aizf.cmV);
      }
      paramContext = QQLSActivity.this.a;
      if (!aizf.cmV) {
        QQLSActivity.g(QQLSActivity.this);
      }
      QQLSActivity.this.finish();
    }
  }
  
  public class d
    extends auvp
  {
    public List<MessageRecord> qY = new ArrayList();
    
    public d() {}
    
    private View e(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView != null)
      {
        paramViewGroup = paramView.getTag();
        if (!(paramViewGroup instanceof QQLSActivity.i)) {}
      }
      for (paramViewGroup = (QQLSActivity.i)paramViewGroup;; paramViewGroup = null)
      {
        if (paramViewGroup == null)
        {
          paramView = QQLSActivity.this.getLayoutInflater().inflate(2131561426, null);
          paramViewGroup = new QQLSActivity.i();
          paramViewGroup.EV = ((TextView)paramView.findViewById(2131374924));
          paramViewGroup.EV.setEllipsize(TextUtils.TruncateAt.END);
          paramViewGroup.EV.setMaxLines(10);
          paramViewGroup.EV.setTextColor(-4210755);
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          Object localObject = (ImageView)paramView.findViewById(2131374918);
          if (localObject != null)
          {
            if (QQLSActivity.a(QQLSActivity.this).ng() != 7432) {
              break label146;
            }
            ((ImageView)localObject).setVisibility(4);
          }
          while (paramInt >= this.qY.size())
          {
            return paramView;
            label146:
            ((ImageView)localObject).setVisibility(0);
          }
          localObject = QQLSActivity.a(QQLSActivity.this).mTitleName;
          paramViewGroup.EV.setText((CharSequence)localObject);
          return paramView;
        }
      }
    }
    
    public void fW(List<MessageRecord> paramList)
    {
      if (paramList != null)
      {
        this.qY.clear();
        this.qY.addAll((List)((ArrayList)paramList).clone());
        notifyDataSetChanged();
      }
    }
    
    public View g(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      MessageRecord localMessageRecord = (MessageRecord)this.qY.get(paramInt);
      Object localObject = new BaseChatItemLayout(QQLSActivity.this);
      ((BaseChatItemLayout)localObject).setId(2131363321);
      ((BaseChatItemLayout)localObject).setFocusableInTouchMode(true);
      ((BaseChatItemLayout)localObject).setPadding(BaseChatItemLayout.paddingLeft, BaseChatItemLayout.paddingTop, BaseChatItemLayout.paddingRight, 0);
      if ((paramView == null) || (!(paramView.getTag() instanceof QQLSActivity.e)))
      {
        paramViewGroup = new QQLSActivity.e();
        paramView = QQLSActivity.this.getLayoutInflater().inflate(2131561421, null);
        paramViewGroup.ET = ((TextView)paramView.findViewById(2131374802));
        paramViewGroup.qM = ((ImageView)paramView.findViewById(2131374797));
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)paramView.findViewById(2131374798));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)localObject);
        MessageForPtt localMessageForPtt;
        ViewGroup.MarginLayoutParams localMarginLayoutParams;
        if ((localMessageRecord instanceof MessageForPtt))
        {
          localMessageForPtt = (MessageForPtt)localMessageRecord;
          localObject = QQLSActivity.a(QQLSActivity.this, localMessageRecord);
          ((TextView)paramView.findViewById(2131374799)).setText(new aofe((CharSequence)localObject, 16).k());
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
          if (((String)localObject).equals("")) {
            break label571;
          }
          localMarginLayoutParams.setMargins(wja.dp2px(5.0F, QQLSActivity.this.getResources()), wja.dp2px(7.0F, QQLSActivity.this.getResources()), 0, 0);
          int j = xkx.a(QQLSActivity.a(QQLSActivity.this), localMessageForPtt);
          int i = j;
          if (j == -1)
          {
            QQLSActivity.this.a(paramViewGroup, localMessageForPtt, false, true);
            i = 2001;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
          }
          QQLSActivity.this.a(paramViewGroup, localMessageForPtt, i, QQLSActivity.this.d(localMessageForPtt));
          aomq.a(QQLSActivity.a(QQLSActivity.this), i, localMessageRecord);
          wla.a(QQLSActivity.a(QQLSActivity.this)).a(paramView, QQLSActivity.this);
          if ((QQLSActivity.kC()) && (paramViewGroup.E == null)) {
            paramViewGroup.E = new StringBuilder();
          }
          paramViewGroup.pos = paramInt;
          paramViewGroup.count = paramInt;
          if (QQLSActivity.kC())
          {
            paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
            if (!TextUtils.isEmpty(paramViewGroup.E)) {
              paramViewGroup.E.replace(0, paramViewGroup.E.length(), "");
            }
            if ((!((ChatMessage)localMessageRecord).mNeedTimeStamp) || (localMessageRecord.time <= 0L)) {}
          }
        }
        try
        {
          localObject = aqmu.a(QQLSActivity.this, 3, localMessageRecord.time * 1000L);
          paramViewGroup.E.append((CharSequence)localObject).append(" ");
          paramViewGroup.mMessage = ((ChatMessage)localMessageRecord);
          alip.a(QQLSActivity.a(QQLSActivity.this)).f(localMessageForPtt);
          return paramView;
          paramViewGroup = (QQLSActivity.e)paramView.getTag();
          continue;
          label571:
          localMarginLayoutParams.setMargins(0, wja.dp2px(7.0F, QQLSActivity.this.getResources()), 0, 0);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str = "";
          }
        }
      }
    }
    
    public int getCount()
    {
      return this.qY.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.qY.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.qY.size()))
      {
        MessageRecord localMessageRecord = (MessageRecord)this.qY.get(paramInt);
        if ((QQLSActivity.a(QQLSActivity.this).ng() == 1012) || (QQLSActivity.a(QQLSActivity.this).ng() == 7432) || (QQLSActivity.a(QQLSActivity.this).ng() == 1030) || (QQLSActivity.a(QQLSActivity.this).ng() == 1035)) {
          return 1;
        }
        if ((localMessageRecord != null) && ((localMessageRecord.msgtype == -2002) || (localMessageRecord.msgtype == -1031))) {
          return 2;
        }
        if (QQLSActivity.a(QQLSActivity.this).ng() == 9653) {
          return 4;
        }
      }
      return 0;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = getItemViewType(paramInt);
      View localView;
      if ((i == 1) || (i == 4)) {
        localView = e(paramInt, paramView, paramViewGroup);
      }
      Object localObject1;
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localView;
        if (i == 2)
        {
          localView = g(paramInt, paramView, paramViewGroup);
        }
        else
        {
          if (paramView != null)
          {
            localView = paramView;
            if ((paramView.getTag() instanceof QQLSActivity.h)) {}
          }
          else
          {
            localView = QQLSActivity.this.getLayoutInflater().inflate(2131561425, null);
            paramView = new QQLSActivity.h();
            localObject1 = (TextView)localView.findViewById(2131374924);
            localObject2 = (ImageView)localView.findViewById(2131374927);
            ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView)localObject1).setMaxLines(10);
            paramView.EV = ((TextView)localObject1);
            paramView.qO = ((ImageView)localObject2);
            localView.setTag(paramView);
          }
          if (paramInt < this.qY.size()) {
            break;
          }
          paramView = localView;
        }
      }
      MessageRecord localMessageRecord = (MessageRecord)this.qY.get(paramInt);
      Object localObject2 = (QQLSActivity.h)localView.getTag();
      if (localMessageRecord.istroop == 7000)
      {
        paramView = null;
        if (QQLSActivity.this.b != null) {
          paramView = QQLSActivity.this.b.nM(localMessageRecord.frienduin);
        }
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = localMessageRecord.frienduin;
        }
        paramView = (String)localObject1 + ": " + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessageRecord, false);
      }
      label1536:
      label1568:
      label1574:
      for (;;)
      {
        localObject1 = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject1 = "";
        }
        paramView = (View)localObject1;
        if (10007 == localMessageRecord.istroop) {
          paramView = ahtc.a(QQLSActivity.a(QQLSActivity.this), localMessageRecord, (String)localObject1);
        }
        if ((QQLSActivity.this.pu.size() > 0) && (paramView.equals("")) && ((localMessageRecord.msgtype == -2016) || (localMessageRecord.msgtype == -2009) || (localMessageRecord.msgtype == -2026)))
        {
          paramView = localMessageRecord.msg;
          ((QQLSActivity.h)localObject2).EV.setTextColor(-570319);
          ((QQLSActivity.h)localObject2).qO.setVisibility(0);
          label428:
          if ((localMessageRecord.istroop != 1) || ((localMessageRecord instanceof MessageForPubAccount))) {
            break label1536;
          }
          localObject1 = aqpm.a(localMessageRecord, QQLSActivity.a(QQLSActivity.this).b().a(QQLSActivity.this, localMessageRecord, false));
          if (localObject1 == null) {
            break label1504;
          }
          ((QQLSActivity.h)localObject2).EV.setText((CharSequence)localObject1);
          label487:
          paramView = localView;
          break;
          if ((localMessageRecord.istroop == 1001) || (localMessageRecord.istroop == 1010) || (localMessageRecord.istroop == 10002))
          {
            if (localMessageRecord.msgtype == -2053)
            {
              paramView = (MessageForNearbyLiveTip)anbi.d(-2053);
              paramView.msgData = localMessageRecord.msgData;
              paramView.parse();
              localObject1 = paramView.nickName;
              paramView = QQLSActivity.this.getString(2131701402) + (String)localObject1 + paramView.msg;
              continue;
            }
            localObject1 = aqgv.G(QQLSActivity.a(QQLSActivity.this), localMessageRecord.senderuin);
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            Object localObject3;
            if (localMessageRecord.frienduin.equals(acbn.blf))
            {
              ((TextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374920)).setText(BaseApplicationImpl.getApplication().getString(2131692433));
              localObject1 = BaseApplicationImpl.getApplication().getString(2131692432);
              ((DragTextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374926)).setVisibility(8);
              localObject3 = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
              paramView = (View)localObject1;
              if (((String)localObject3).length() <= 0) {
                break label1574;
              }
              localObject3 = ((String)localObject3).split("\\|");
              paramView = (View)localObject1;
              if (localObject3.length < 6) {
                break label1574;
              }
              ((TextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374920)).setText(localObject3[4]);
              paramView = localObject3[5];
              continue;
            }
            if (localMessageRecord.frienduin.equals(acbn.ble))
            {
              ((TextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374920)).setText(BaseApplicationImpl.getApplication().getString(2131695210));
              localObject1 = BaseApplicationImpl.getApplication().getString(2131695209);
              ((DragTextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374926)).setVisibility(8);
              localObject3 = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
              paramView = (View)localObject1;
              if (((String)localObject3).length() <= 0) {
                break label1574;
              }
              localObject3 = ((String)localObject3).split("\\|");
              paramView = (View)localObject1;
              if (localObject3.length < 6) {
                break label1574;
              }
              ((TextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374920)).setText(localObject3[4]);
              paramView = localObject3[5];
              continue;
            }
            paramView = paramView + ": " + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessageRecord, false);
            continue;
          }
          if ((localMessageRecord.istroop == 9501) && ("device_groupchat".equals(localMessageRecord.extStr)))
          {
            if ((localMessageRecord.msgtype == -4501) || (localMessageRecord.msgtype == -4508))
            {
              localObject1 = aqgv.b(QQLSActivity.a(QQLSActivity.this), localMessageRecord.senderuin, true);
              paramView = (View)localObject1;
              if (!TextUtils.isEmpty(localMessageRecord.senderuin))
              {
                paramView = (View)localObject1;
                if (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) {
                  paramView = tas.a(((syw)QQLSActivity.a(QQLSActivity.this).getBusinessHandler(51)).a(Long.parseLong(localMessageRecord.senderuin)));
                }
              }
              localObject1 = paramView;
              if (paramView == null) {
                localObject1 = "";
              }
              paramView = (String)localObject1 + ": " + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessageRecord, false);
              continue;
            }
            paramView = QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessageRecord, false);
            continue;
          }
          if (jof.a(localMessageRecord))
          {
            paramView = QQLSActivity.this.getResources().getString(2131699453) + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessageRecord, false);
            continue;
          }
          if ((localMessageRecord.istroop == 1) && ((localMessageRecord instanceof MessageForPubAccount))) {
            if (((MessageForPubAccount)localMessageRecord).isTextMsg()) {
              break label1568;
            }
          }
        }
        for (paramView = obt.a(QQLSActivity.a(QQLSActivity.this), BaseApplicationImpl.getContext()) + ":";; paramView = "")
        {
          paramView = paramView + QQLSActivity.a(QQLSActivity.this).b().b(QQLSActivity.this, localMessageRecord, false);
          break;
          if (top.eD(localMessageRecord.istroop) == 1032)
          {
            paramView = QQLSActivity.a(QQLSActivity.this).b().c(QQLSActivity.this, localMessageRecord, false);
            break;
          }
          if ((localMessageRecord.istroop == 1041) || (localMessageRecord.istroop == 1042))
          {
            ((TextView)QQLSActivity.a(QQLSActivity.this).findViewById(2131374920)).setText(QQLSActivity.this.getResources().getString(2131696301));
            paramView = localMessageRecord.msg;
            break;
          }
          paramView = QQLSActivity.a(QQLSActivity.this).b().a(QQLSActivity.this, localMessageRecord, false);
          break;
          ((QQLSActivity.h)localObject2).EV.setTextColor(-4210755);
          ((QQLSActivity.h)localObject2).qO.setVisibility(8);
          break label428;
          label1504:
          ((QQLSActivity.h)localObject2).EV.setText(new aofk(paramView, 5, 16, QQLSActivity.a(QQLSActivity.this).ng()));
          break label487;
          ((QQLSActivity.h)localObject2).EV.setText(new aofk(paramView, 5, 16, QQLSActivity.a(QQLSActivity.this).ng()));
          break label487;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 5;
    }
  }
  
  public static class e
    extends BaseBubbleBuilder.e
  {
    public StringBuilder E;
    public TextView ET;
    public BreathAnimationLayout a;
    public ImageView qM;
  }
  
  static class f
  {
    TextView BM;
    TextView EU;
    DragTextView f;
    TextView kG;
    ImageView qN;
  }
  
  static class g
  {
    TextView BM;
    DragTextView f;
  }
  
  static class h
  {
    TextView EV;
    ImageView qO;
  }
  
  static class i
  {
    TextView EV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity
 * JD-Core Version:    0.7.0.1
 */