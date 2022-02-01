package com.tencent.mobileqq.activity.aio.rebuild;

import aboy;
import abrb;
import abzy;
import accc;
import accd;
import acfd;
import acfp;
import achq;
import acle;
import aclh;
import acms;
import acnd;
import acnh;
import aegs;
import aehj;
import aeif;
import aeog;
import aerd;
import ahvn;
import aiqd;
import aiqk;
import aizp;
import alid;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.LruCache;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import anlm;
import anot;
import anov;
import anpc;
import anqo;
import aobo;
import aofy;
import aomq;
import aoxw;
import aoxz;
import aoyb;
import apab.a;
import apag;
import apan;
import apat;
import apdj;
import apdj.a;
import apdr;
import apgi;
import apgj;
import apke;
import apml;
import apmp;
import apmz;
import apot;
import appb;
import apqk;
import apro;
import apsa;
import apsd;
import apsd.b;
import apsd.c;
import apsw.e;
import aptj;
import aptm;
import apto;
import aptr;
import aptw;
import apuh;
import apwh;
import apwk;
import apwy;
import apxr;
import apyl;
import apys;
import apyu;
import aqcx;
import aqfr;
import aqft;
import aqfx;
import aqge;
import aqgv;
import aqha;
import aqju;
import aqmj;
import aqmq;
import aqmr;
import aquv;
import arhz;
import artb;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.i;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatpieHelper;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.confess.ConfessPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable;
import com.tencent.mobileqq.troop.widget.FloatView;
import com.tencent.mobileqq.troop.widget.TroopAIORobotLayout;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jof;
import jof.b;
import jof.d;
import jog;
import jrp;
import jrp.a;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import psu;
import psx;
import ptf;
import rnu;
import rpq;
import slz;
import smw;
import smx;
import tog;
import top;
import ujt;
import wiw;
import wiw.a;
import wja;
import wki;
import wnc;
import wtj;
import wur;
import wvm;
import wwn;
import www;
import wxc;
import wxf;
import wxk;
import xpw;
import xqa;
import xqh;
import xru;
import xwn;
import yeg;
import yeh;
import yei;
import yej;
import yek;
import yel;
import yem;
import yen;
import yeo;
import yep;
import yer;
import yes;
import yet;
import yeu;
import yev;
import yew;
import yex;
import yey;
import yez;
import yfa;
import yfb;
import yfc;
import yfd;
import yfe;
import yff;
import yfg;
import yhy;
import yij;
import yin;
import yip;
import yjh;
import yjl;
import yjm;
import yjp;
import yjt;

public class TroopChatPie
  extends xwn
{
  public volatile long JO;
  private long JP;
  private long JQ;
  protected aqju V;
  public aqju W;
  private final acfd jdField_a_of_type_Acfd = new yeg(this);
  protected achq a;
  aclh jdField_a_of_type_Aclh = new yei(this);
  acnd jdField_a_of_type_Acnd = new yeh(this);
  acnh jdField_a_of_type_Acnh = new yes(this);
  aobo jdField_a_of_type_Aobo = new yfc(this);
  private aoxz jdField_a_of_type_Aoxz;
  protected apdj a;
  private apgj jdField_a_of_type_Apgj;
  apsd.c jdField_a_of_type_Apsd$c;
  protected apwk a;
  protected apxr a;
  public apyl a;
  protected apyu a;
  protected ConfessPanel a;
  TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable;
  FloatView jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView;
  jrp.a jdField_a_of_type_Jrp$a = new yer(this);
  slz jdField_a_of_type_Slz = null;
  wiw.a jdField_a_of_type_Wiw$a = new yfe(this);
  public yhy a;
  public yij a;
  yin jdField_a_of_type_Yin;
  public yip a;
  yjl jdField_a_of_type_Yjl;
  yjm jdField_a_of_type_Yjm;
  yjp jdField_a_of_type_Yjp;
  BroadcastReceiver aO;
  public String aXo;
  String aXp;
  BroadcastReceiver an;
  accd jdField_b_of_type_Accd = new yep(this);
  private Observer jdField_b_of_type_JavaUtilObserver = new yey(this);
  jof.d jdField_b_of_type_Jof$d;
  public jog b;
  jrp jdField_b_of_type_Jrp;
  Handler bW;
  public Handler bX = new yej(this, Looper.getMainLooper());
  protected int bXX = 0;
  protected int bYI;
  public int bYJ = 2;
  public int bYK;
  boolean bez = false;
  int bfi = 0;
  private boolean bkQ;
  boolean blS = false;
  boolean blT;
  boolean blU;
  private boolean blV;
  public boolean blW;
  private boolean blX;
  private boolean blY;
  private boolean blZ;
  public boolean bma = false;
  protected boolean bmb;
  boolean bmc = false;
  boolean bmd = true;
  boolean bme = false;
  boolean bmf = false;
  boolean bmg = false;
  Toast c;
  Runnable eA;
  Runnable eB = new TroopChatPie.2(this);
  private Runnable eC = new TroopChatPie.35(this);
  Runnable eD = new TroopChatPie.36(this);
  private ViewTreeObserver.OnGlobalLayoutListener g;
  public LinearLayout hp;
  public boolean isScrolling;
  public ScrollView j;
  private ArrayList<Long> qT = new ArrayList();
  protected List<b> su = new ArrayList(5);
  public View xC;
  View xD;
  public View xE;
  public View xF;
  
  public TroopChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_c_of_type_AndroidWidgetToast = null;
    this.jdField_a_of_type_Achq = new yex(this);
  }
  
  private void DN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 12006: 
    case 6001: 
      do
      {
        return;
        if (jof.a().dd(this.sessionInfo.aTl)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          anot.a(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_choosecancel", paramInt, 0, this.sessionInfo.aTl, "", "", "");
          return;
        }
      } while (!this.sessionInfo.beA);
      BaseChatpieHelper.a(this.sessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_b_of_type_ComTencentWidgetPatchedButton, false);
      return;
    }
    chr();
  }
  
  private void DP(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "inputing @ in TroopChatPie.");
    }
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
    if (localTroopInfo != null)
    {
      localObject1 = TroopMemberListActivity.c(this.mActivity, localTroopInfo.troopuin, 3);
      ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
      ((Intent)localObject1).setFlags(603979776);
      if (this.aaR)
      {
        ((Intent)localObject1).putExtra("param_chat_mode", 1);
        bool = Tq();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "open TroopMemberListActivity, needfilterrobot:" + bool);
        }
        if (bool) {
          ((Intent)localObject1).putExtra("param_filter_robot", true);
        }
        if (super.vm() == 21) {
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "open TroopMemberListActivity to choose @ user target.");
        }
        this.mActivity.startActivityForResult((Intent)localObject1, 6001);
        if (paramInt != 1) {
          break label209;
        }
      }
    }
    label209:
    while (!QLog.isColorLevel())
    {
      Object localObject1;
      for (;;)
      {
        boolean bool;
        return;
        ((Intent)localObject1).putExtra("param_chat_mode", 0);
      }
      String str1 = "2";
      for (;;)
      {
        String str2;
        try
        {
          str2 = this.app.getCurrentAccountUin();
          if ((localTroopInfo.troopowneruin == null) || (!localTroopInfo.troopowneruin.equals(str2))) {
            break label305;
          }
          localObject1 = "0";
          anot.a(this.app, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, localTroopInfo.troopuin, "2", (String)localObject1, "");
          return;
        }
        catch (Exception localException) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.TAG, 2, "onTextChanged() has an exception.", localException);
        return;
        Object localObject2 = str1;
        if (localTroopInfo.Administrator != null)
        {
          localObject2 = str1;
          if (localTroopInfo.Administrator.contains(str2)) {
            localObject2 = "1";
          }
        }
      }
    }
    label305:
    QLog.d(this.TAG, 2, "onTextChanged(). troopInfo is null. while inputing @.  troopUin is " + this.sessionInfo.aTl);
  }
  
  private void G(int paramInt, Intent paramIntent)
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
            int i;
            do
            {
              do
              {
                return;
                localObject = wja.a(new Intent(this.mActivity, SplashActivity.class), null);
                ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
                this.mActivity.startActivity((Intent)localObject);
                return;
                cu(paramIntent);
                return;
                aptj.a(this.mActivity, paramIntent, this.app);
                return;
                hidePanel();
                paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
              } while (paramInt <= 0);
              i = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().charAt(paramInt - 1);
            } while ((i != 36) && (i != 65509) && (i != 165) && (i != 65284));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().delete(paramInt - 1, paramInt));
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramInt - 1);
            return;
          } while (this.jdField_a_of_type_Smx == null);
          localObject = this.jdField_a_of_type_Smx.a();
        } while (localObject == null);
        ((TroopGiftPanel)localObject).cP(paramIntent.getStringExtra("member_uin"), paramIntent.getStringExtra("member_display_name"));
        return;
        paramIntent = paramIntent.getStringExtra("result");
        localObject = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.aTl);
      } while ((TextUtils.isEmpty(paramIntent)) || (localObject == null) || (paramIntent.equals(((TroopInfo)localObject).troopname)));
      ((accc)this.app.getBusinessHandler(22)).B(this.sessionInfo.aTl, paramIntent, false);
      this.sessionInfo.aTn = paramIntent;
      Object localObject = this.mActivity.getIntent();
      ((Intent)localObject).putExtra("uinname", paramIntent);
      bo((Intent)localObject);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.o(paramInt, paramIntent);
  }
  
  private boolean Tq()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    aptw localaptw = (aptw)this.app.getManager(203);
    Object localObject = null;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    }
    if (localObject == null)
    {
      bool2 = bool1;
      return bool2;
    }
    localObject = (appb[])((Editable)localObject).getSpans(0, localObject.toString().length(), appb.class);
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i < localObject.length)
      {
        if (localaptw.gM(localObject[i].Bw())) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.TAG, 2, "needFilterRobot : " + bool1);
        return bool1;
      }
      i += 1;
    }
  }
  
  private void ba(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool1;
    boolean bool2;
    label191:
    label255:
    do
    {
      return;
      apys localapys = (apys)this.app.getManager(234);
      String str = localapys.oU(paramString);
      bool1 = ((aiqk)a(33)).apu();
      bool2 = ((wxc)a(43)).Sl();
      if ((!this.aaR) && (!bool1) && (!bool2) && (!TextUtils.isEmpty(str)))
      {
        if (this.bXX != 2)
        {
          DO(2);
          if (paramBoolean)
          {
            if (localapys.eY(paramString) != 3) {
              break label191;
            }
            aqfr.b("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { paramString });
          }
        }
        for (;;)
        {
          vU(true);
          this.Cu.setText(str);
          this.pv.setVisibility(0);
          if (this.jdField_a_of_type_Apyl == null) {
            break label255;
          }
          this.jdField_a_of_type_Apyl.yJ(paramString);
          if (!this.jdField_a_of_type_Apyl.isShowing()) {
            break;
          }
          this.jdField_a_of_type_Apyl.update();
          zR(true);
          return;
          new anov(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().aTl }).report();
        }
        zR(false);
        return;
        zR(false);
        return;
      }
    } while ((this.aaR) || (bool1) || (bool2));
    vU(false);
    this.Cu.setText("");
    this.pv.setVisibility(8);
  }
  
  private void cgh()
  {
    ThreadManager.post(new TroopChatPie.6(this), 5, null, true);
  }
  
  private void chA()
  {
    if (ThemeUtil.isDefaultOrDIYTheme(false)) {
      N(this.mActivity.getResources().getDrawable(2130847060));
    }
    for (;;)
    {
      anlm.a(this.mActivity.mSystemBarComp, this.mActivity.getWindow());
      return;
      ay(this.mActivity.getResources().getColor(2131167361), true);
    }
  }
  
  private void chE()
  {
    if ((aqft.rj(this.sessionInfo.aTl)) && (aqft.bK(this.mContext))) {}
    TroopManager localTroopManager;
    Intent localIntent;
    do
    {
      return;
      localTroopManager = (TroopManager)this.app.getManager(52);
      localIntent = new Intent();
      localIntent.putExtra("troop_code", this.sessionInfo.troopUin);
      localIntent.putExtra("troop_uin", this.sessionInfo.aTl);
    } while ((localTroopManager != null) && (localTroopManager.kB(this.sessionInfo.troopUin)));
    apuh.a(this.mActivity, localIntent.getExtras(), 1, 2000);
  }
  
  private void chG()
  {
    if ((this.jdField_a_of_type_Apyl != null) && (this.jdField_a_of_type_Apyl.isShowing()))
    {
      if (this.jdField_a_of_type_Apyl.LN() == 2)
      {
        vU(false);
        DO(0);
      }
    }
    else {
      return;
    }
    zS(false);
  }
  
  private void chI()
  {
    if (isFullScreenMode()) {
      return;
    }
    if (this.jdField_a_of_type_Yin == null) {
      this.jdField_a_of_type_Yin = new yin(this.app, this.mActivity, this.sessionInfo, this.app.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Yin.a(this.jdField_a_of_type_Yjh);
  }
  
  private void chJ()
  {
    if (this.bkQ) {
      return;
    }
    ((aegs)this.app.getManager(269)).Ho(this.sessionInfo.aTl);
    this.bkQ = true;
  }
  
  private void chK()
  {
    ThreadManager.post(new TroopChatPie.37(this), 8, null, true);
  }
  
  private void chL()
  {
    TroopChatPie.38 local38 = new TroopChatPie.38(this);
    ThreadManager.getSubThreadHandler().post(local38);
  }
  
  private void chM()
  {
    boolean bool3 = false;
    if ((!this.bmc) && (this.sessionInfo.cZ == 1)) {}
    for (boolean bool1 = Tp();; bool1 = false)
    {
      if (!bool1) {
        if ((this.jdField_a_of_type_Slz != null) && (this.jdField_a_of_type_Slz.isShowing())) {
          bool1 = true;
        }
      }
      for (;;)
      {
        Object localObject = (apqk)this.app.getManager(223);
        if (localObject != null) {}
        for (boolean bool2 = ((apqk)localObject).qH(this.sessionInfo.aTl);; bool2 = false)
        {
          if ((localObject != null) && (bool2) && (bool1)) {
            ((apqk)localObject).cRY = false;
          }
          if ((!bool1) && (bool2))
          {
            apqk.cRX = true;
            wi(true);
          }
          localObject = aiqk.a(this);
          if (localObject != null)
          {
            if (!bool1)
            {
              bool1 = bool3;
              if (!bool2) {}
            }
            else
            {
              bool1 = true;
            }
            ((aiqk)localObject).Lq(bool1);
          }
          return;
          bool1 = false;
          break;
        }
      }
    }
  }
  
  private void chN()
  {
    if (ChatActivityUtils.a(this.sessionInfo.aTl, this.app.getCurrentAccountUin()) == null) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, isTroopTipStatusNull== true, getAppInfoBriefList");
      }
      this.jdField_b_of_type_Jrp.a(this.sessionInfo.aTl, this.jdField_a_of_type_Jrp$a, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.aio", 2, "onShow_troopType, reqNotifyItems");
    }
    apro.aV(this.app, this.sessionInfo.aTl);
  }
  
  private void chr()
  {
    if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label33;
      }
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(8);
    }
    for (;;)
    {
      aehj.C(this.app, false);
      return;
      label33:
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
    }
  }
  
  private void chs()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
    int i;
    if (localTroopInfo != null)
    {
      if (!localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())) {
        break label101;
      }
      i = 0;
    }
    for (;;)
    {
      anot.a(this.app, "P_CliOper", "Grp_flower", "", "mber", "un", 0, 0, this.sessionInfo.aTl, i + "", "", "");
      return;
      label101:
      if (localTroopInfo.isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  private void chu()
  {
    if ((this.sessionInfo == null) || (TextUtils.isEmpty(this.sessionInfo.aTl))) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(this.TAG, 2, String.format("updateTroopHonorInteractiveIcon, troopUin: %s", new Object[] { this.sessionInfo.aTl }));
  }
  
  private void chx()
  {
    this.jdField_a_of_type_Aoxz = new yet(this);
    this.app.registObserver(this.jdField_a_of_type_Aoxz);
  }
  
  private void cu(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().getString("troop_uin");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equalsIgnoreCase(this.sessionInfo.aTl))) {}
    String str2;
    String str1;
    do
    {
      return;
      str2 = paramIntent.getExtras().getString("member_uin");
      str1 = paramIntent.getExtras().getString("member_display_name");
      if ((!paramIntent.getExtras().getBoolean("isApollo")) || (this.jdField_a_of_type_Abzy == null)) {
        break;
      }
    } while ("0".equals(str2));
    paramIntent = null;
    if (!SV()) {
      paramIntent = aqgv.o(this.app, this.sessionInfo.aTl, str2);
    }
    localObject = paramIntent;
    if (TextUtils.isEmpty(paramIntent)) {
      localObject = str1;
    }
    paramIntent = new StringBuilder("@").append((String)localObject);
    this.jdField_a_of_type_Abzy.c.peerUin = str2;
    this.jdField_a_of_type_Abzy.c.atNickName = paramIntent.toString();
    this.jdField_a_of_type_Abzy.c.inputText = aofy.iF(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
    a(this.jdField_a_of_type_Abzy);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Abzy.c.inputText))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_Abzy.bkj)) {
        break label483;
      }
      if (this.jdField_a_of_type_Abzy.cue == 0) {
        i = 6;
      }
    }
    for (;;)
    {
      localObject = this.app;
      str1 = this.sessionInfo.aTl;
      int k = ApolloUtil.gi(this.sessionInfo.cZ);
      str2 = "" + this.jdField_a_of_type_Abzy.c.actionId;
      if (TextUtils.isEmpty(this.jdField_a_of_type_Abzy.bkj)) {}
      for (paramIntent = "0";; paramIntent = this.jdField_a_of_type_Abzy.bkj)
      {
        VipUtils.a((AppInterface)localObject, "cmshow", "Apollo", "g_action_double_sent", str1, i, k, new String[] { str2, paramIntent, this.jdField_a_of_type_Abzy.c.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
        return;
        if (this.jdField_a_of_type_Abzy.cue != 1) {
          break label483;
        }
        i = 7;
        break;
        if (TextUtils.isEmpty(this.jdField_a_of_type_Abzy.bkj))
        {
          i = 3;
          break;
        }
        if (this.jdField_a_of_type_Abzy.cue == 0)
        {
          i = 4;
          break;
        }
        if (this.jdField_a_of_type_Abzy.cue != 1) {
          break label478;
        }
        i = 5;
        break;
      }
      b(str2, str1, true, 4);
      return;
      label478:
      i = 0;
      continue;
      label483:
      i = 2;
    }
  }
  
  private void cv(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_Yjm != null) && (this.jdField_a_of_type_Yjm.isShowing()) && (aizp.a().K(this.app, this.sessionInfo.aTl))) {
      this.jdField_a_of_type_Yjh.ciA();
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false))) {
      a().getIntent().putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
    }
  }
  
  private void cw(Intent paramIntent)
  {
    this.bkQ = false;
    String str = paramIntent.getStringExtra("uin");
    this.bez = ((aegs)this.app.getManager(269)).b(str, paramIntent);
  }
  
  private void dF(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "clearBAFGrayTipSP troopUin=" + paramString1);
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    paramString1 = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_members", paramString2, paramString1 });
    localSharedPreferences.edit().putLong(paramString1, 0L).apply();
  }
  
  private void yy(String paramString)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eD);
    this.aXp = paramString;
    ThreadManager.getSubThreadHandler().post(this.eD);
  }
  
  private void zR(boolean paramBoolean)
  {
    if ((!this.blX) && (!paramBoolean) && (this.bXX == 2)) {
      zS(false);
    }
  }
  
  private void zT(boolean paramBoolean)
  {
    this.bkf = paramBoolean;
  }
  
  public void Ah(int paramInt)
  {
    if (!this.aaR) {
      super.Ah(paramInt);
    }
  }
  
  public void DO(int paramInt)
  {
    this.bXX = paramInt;
    if ((this.pv == null) || (this.cJ == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.TAG, 2, "changeSubTitleType, not init ui");
      }
      return;
    }
    if (paramInt == 3)
    {
      this.pv.setVisibility(0);
      this.cJ.setOnClickListener(this);
      this.cK.setOnClickListener(this);
      return;
    }
    if (paramInt == 4)
    {
      if (((wxc)a(43)).Sm()) {
        this.pv.setVisibility(8);
      }
      for (;;)
      {
        this.cJ.setOnClickListener(this);
        this.cK.setOnClickListener(this);
        return;
        this.pv.setVisibility(0);
      }
    }
    if (paramInt == 2)
    {
      this.pv.setVisibility(0);
      this.cJ.setOnClickListener(this);
      this.cK.setOnClickListener(this);
      return;
    }
    this.pv.setVisibility(8);
    this.cJ.setOnClickListener(this);
    this.cK.setOnClickListener(null);
  }
  
  void DQ(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOshortcut", "Clk_shortcut", 0, 0, this.sessionInfo.aTl, (String)localObject1, "", "");
      }
      return;
      localObject1 = "1";
      continue;
      localObject1 = "2";
      continue;
      localObject1 = "3";
      continue;
      localObject1 = "4";
      continue;
      localObject1 = "5";
      continue;
      localObject1 = "7";
    }
  }
  
  public void DR(int paramInt)
  {
    if ((this.sessionInfo.cZ == 1) && (this.app.cs(this.sessionInfo.aTl) == 3)) {
      ((acms)this.app.getBusinessHandler(20)).m(this.sessionInfo.aTl, this.app.getCurrentAccountUin(), paramInt, 0);
    }
  }
  
  public void I(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = a();
    } while ((TextUtils.isEmpty(((SessionInfo)localObject1).aTl)) || (paramObject == null));
    for (;;)
    {
      int i;
      try
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        if (Long.parseLong(((SessionInfo)localObject1).aTl) != l) {
          break;
        }
        localObject1 = (TroopMemberCard)paramObject[2];
        i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        int k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
        if (i > k) {
          break label425;
        }
        Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(i);
        if (!(localObject2 instanceof MessageForQQWalletTips)) {
          break label549;
        }
        localObject2 = (MessageForQQWalletTips)localObject2;
        if ((((MessageForQQWalletTips)localObject2).istroop != 1) || (localObject1 == null) || (!((MessageForQQWalletTips)localObject2).memberUin.equals(String.valueOf(((TroopMemberCard)localObject1).memberUin))) || (!((MessageForQQWalletTips)localObject2).frienduin.equals(String.valueOf(l))) || ((TroopManager)this.app.getManager(52) == null)) {
          break label549;
        }
        Object localObject3 = ((TroopMemberCard)localObject1).nick;
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "handGetTroopMemberCard troopUin=" + ((MessageForQQWalletTips)localObject2).frienduin + ", memberUin=" + ((MessageForQQWalletTips)localObject2).memberUin + ",card=" + ((TroopMemberCard)localObject1).card + ",remark=" + ((TroopMemberCard)localObject1).remark + ",nick=" + ((TroopMemberCard)localObject1).nick + ",saveTroopMemberEx succ=" + true);
        }
        localObject3 = wja.a(this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView, i);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "handGetTroopMemberCard ref itemView=" + localObject3 + ",index=" + i);
        }
        if (localObject3 == null) {
          break label549;
        }
        localObject3 = (TextView)((View)localObject3).findViewById(2131368123);
        ((MessageForQQWalletTips)localObject2).buildQQWalletTips(this.app, this.mContext, (TextView)localObject3);
      }
      catch (Throwable paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(this.TAG, 2, "handGetTroopMemberCard e=" + paramObject);
      return;
      label425:
      if ((localObject1 == null) || (!TextUtils.equals(this.app.getCurrentAccountUin(), String.valueOf(((TroopMemberCard)localObject1).memberUin)))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, new Object[] { "handleGetTroopMemberCard. memberUin = ", this.app.getCurrentAccountUin() });
      }
      if ((this.jdField_a_of_type_Apgj != null) && ((this.jdField_a_of_type_Apgj.a instanceof apml)))
      {
        localObject1 = (apml)this.jdField_a_of_type_Apgj.a;
        if (((Boolean)paramObject[3]).booleanValue()) {
          break label544;
        }
      }
      label544:
      for (paramBoolean = true;; paramBoolean = false)
      {
        ((apml)localObject1).a(paramBoolean, null, this);
        chI();
        return;
      }
      label549:
      i += 1;
    }
  }
  
  public void Ib()
  {
    this.TAG = "TroopChatPie";
  }
  
  public boolean SV()
  {
    return false;
  }
  
  boolean Tp()
  {
    if (this.jdField_a_of_type_Apmp == null) {}
    boolean bool = aptr.qX(this.sessionInfo.aTl);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleTroopNotificationMsg. hasNewGuide = " + bool);
    }
    if ((this.sessionInfo.cZ == 1) && (!bool))
    {
      ThreadManager.post(new TroopChatPie.24(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public void V(long paramLong1, long paramLong2)
  {
    TroopManager.a(this.app, this.sessionInfo.aTl, paramLong1, paramLong2, new yfg(this, false));
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 35)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = ((ConfessPanel)View.inflate(this.mContext, 2131558643, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.init(this.app, this.mContext, this);
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel;; localObject = super.a(paramInt))
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setPagerChangedListener(new yez(this));
      }
      return localObject;
    }
  }
  
  public apdj a()
  {
    if (this.jdField_a_of_type_Apdj == null) {
      this.jdField_a_of_type_Apdj = new apdj(this.app, (RelativeLayout)this.mAIORootView.findViewById(2131364469));
    }
    return this.jdField_a_of_type_Apdj;
  }
  
  public apxr a()
  {
    if (this.jdField_a_of_type_Apxr == null)
    {
      this.jdField_a_of_type_Apxr = new apxr();
      this.jdField_a_of_type_Apxr.g(this);
    }
    return this.jdField_a_of_type_Apxr;
  }
  
  public apyu a()
  {
    if (this.jdField_a_of_type_Apyu == null) {
      this.jdField_a_of_type_Apyu = new apyu(this.hp);
    }
    return this.jdField_a_of_type_Apyu;
  }
  
  public PanelIconLinearLayout a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout;
  }
  
  public EntryModel a()
  {
    return apuh.a(((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl), this.sessionInfo.aTl);
  }
  
  String a(TroopMemberInfo paramTroopMemberInfo)
  {
    int i = (int)(paramTroopMemberInfo.mUniqueTitleExpire - NetConnInfoCenter.getServerTime()) / 86400;
    return String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>专属头衔\"%3$s\"将在%4$d天后到期，<{\"text\":\"点击续期\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", new Object[] { paramTroopMemberInfo.friendnick, paramTroopMemberInfo.memberuin, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(i + 1), this.sessionInfo.aTl, paramTroopMemberInfo.mUniqueTitle, Integer.valueOf(paramTroopMemberInfo.mUniqueTitleExpire) });
  }
  
  public yjl a()
  {
    return this.jdField_a_of_type_Yjl;
  }
  
  public void a(apsw.e parame)
  {
    if (parame.cSk) {
      if ((1 != this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm()) && (3 != this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm()) && (8 != this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm()) && ((this.bEl != 1) || (this.fateOfRecorder != 0)))
      {
        bHV();
        if (this.Cx != null)
        {
          QLog.d("troop_gag", 1, "fightgag.updateGagStatus_UI:" + parame.buttonText);
          this.Cx.setText(parame.buttonText);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "updateGagStatus_UI, sendEmptyMessageDelayed-TIMER_ID:" + parame.refreshTime + ", hasDestory=" + this.aSY);
        }
        if (!this.aSY)
        {
          this.bX.removeMessages(1);
          this.bX.sendEmptyMessageDelayed(1, parame.refreshTime * 1000L);
        }
        this.aSk = false;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "updateGagStatus disable fastimage,  mAllowFastImage = " + this.aSk);
        }
      }
    }
    do
    {
      return;
      this.bmb = true;
      break;
      this.bmb = false;
      cft();
      this.aSk = true;
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "updateGagStatus enable fastimage,  mAllowFastImage = " + this.aSk);
  }
  
  public void a(apsw.e parame, boolean paramBoolean)
  {
    if (this.sessionInfo.cZ == 1)
    {
      if (parame == null) {
        ThreadManager.post(new TroopChatPie.15(this, paramBoolean), 8, null, true);
      }
    }
    else {
      return;
    }
    a(parame);
  }
  
  public void a(b paramb)
  {
    this.su.add(paramb);
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i = 1;
      if (paramRecorderParam.mUserData != null) {
        break label130;
      }
    }
    long l2;
    int k;
    String str1;
    Object localObject;
    label130:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      k = this.sessionInfo.cZ;
      str1 = this.sessionInfo.aTl;
      if (i != 0) {
        break label482;
      }
      localObject = ujt.a(this.app, paramString, this.sessionInfo, -2, paramRecorderParam.mAudioType);
      if (localObject != null) {
        break label136;
      }
      return;
      i = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool1;
    if (!aqmr.isEmpty(paramRecorderParam.cuc)) {
      ((MessageForPtt)localObject).sttText = paramRecorderParam.cuc;
    }
    long l1 = ((MessageRecord)localObject).uniseq;
    aomq.iG.put(paramString, Long.valueOf(l2));
    if (!bool1)
    {
      anqo.cU(paramString, false);
      anqo.Rl(paramString);
      label204:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.app;
      if (!aSH) {
        break label567;
      }
    }
    label567:
    for (int i = 1;; i = 2)
    {
      anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i, 0, "", "", "", "3.4.4");
      aSH = true;
      i = eK(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.dZN);
      ArrayList localArrayList = new ArrayList();
      String str2 = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      aptw localaptw = (aptw)this.app.getManager(203);
      boolean bool3 = false;
      boolean bool2 = bool3;
      if (this.bkf)
      {
        Iterator localIterator = localArrayList.iterator();
        do
        {
          bool2 = bool3;
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!localaptw.cR(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
        bool2 = true;
      }
      ujt.a(this.app, k, str1, paramString, l1, false, paramInt2, paramRecorderParam.mAudioType, bool1, paramInt3, i, paramBoolean, paramRecorderParam.dZM, (Bundle)localObject, localArrayList, str2, bool2, paramInt4);
      eS(paramInt1, paramInt2);
      d(0, paramString, l1);
      return;
      label482:
      localObject = this.app.b().a(str1, 0, paramLong);
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.d(paramInt2);
      l1 = paramLong;
      if (aqmr.isEmpty(paramRecorderParam.cuc)) {
        break;
      }
      ((MessageForPtt)localObject).sttText = paramRecorderParam.cuc;
      l1 = paramLong;
      break;
      alid.nZ(paramString);
      break label204;
    }
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    apuh.a(this.app, this.sessionInfo.aTl, paramList);
    super.a(paramList, paramCharSequence, paramInt);
    if ((0xFFFF & paramInt) == 4)
    {
      ((apan)this.app.getManager(225)).mJ(paramList);
      if (this.jdField_a_of_type_Apat != null) {
        this.jdField_a_of_type_Apat.a().dYk();
      }
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    ((TroopManager)this.app.getManager(52)).Fy(this.sessionInfo.aTl);
    return super.a(paramInt, paramView, paramListView);
  }
  
  public boolean aA(boolean paramBoolean)
  {
    boolean bool = false;
    if (this.bmb)
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      if (paramBoolean) {
        QQToast.a(this.app.getApp(), 2131699615, 0).show(this.mActivity.getTitleBarHeight());
      }
      bHV();
      bool = true;
    }
    return bool;
  }
  
  public void af(long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog:" + this.sessionInfo.aTl + "," + paramLong + "," + paramBoolean);
    }
    if ((this.V != null) && (this.V.isShowing())) {
      if ((paramLong == 1L) || (paramLong == 2L)) {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "showLowCreditLevelDialog, CreditLevelTipDialog isShowing:" + this.sessionInfo.aTl + "," + paramLong + "," + paramBoolean);
        }
      }
    }
    do
    {
      return;
      this.V.dismiss();
      if (paramLong == 1L)
      {
        this.V = aqha.a(this.mContext, 230).setTitle(this.mActivity.getString(2131721103)).setMessage(2131699776);
        this.V.setPositiveButton(this.mActivity.getString(2131692239), new yek(this));
        this.V.setNegativeButton(acfp.m(2131715629), new yel(this));
        this.V.setPositiveButtonContentDescription(this.mActivity.getString(2131692239));
        this.V.setNegativeButtonContentDescription(acfp.m(2131715627));
        this.V.setCancelable(false);
        this.V.show();
        new anov(this.app).a("dc00899").b("Grp_banned").c("Grp_AIO").d("exp_msgbox").a(new String[] { this.sessionInfo.aTl }).report();
        return;
      }
      if ((paramLong == 2L) && (!paramBoolean))
      {
        this.V = aqha.a(this.mContext, 230).setTitle(this.mActivity.getString(2131721103)).setMessage(2131699775);
        this.V.setPositiveButton(2131699773, new yem(this));
        this.V.setNegativeButton("", null);
        this.V.setCancelable(false);
        this.V.show();
        return;
      }
    } while ((paramLong != 2L) || (!paramBoolean));
    this.V = aqha.a(this.mContext, 230).setTitle(this.mActivity.getString(2131721103)).setMessage(2131699774);
    this.V.setNegativeButton(2131699773, new yen(this));
    this.V.setPositiveButton(2131699772, new yeo(this));
    this.V.setCancelable(false);
    this.V.show();
  }
  
  public boolean af(boolean paramBoolean)
  {
    if (this.mAIORootView == null)
    {
      QLog.e(this.TAG, 2, "mAIORootView == null");
      localObject = this.mActivity.getChatFragment();
      if (localObject != null) {
        this.mAIORootView = ((ChatFragment)localObject).b;
      }
    }
    super.af(paramBoolean);
    DR(1);
    apot.a().A(this);
    this.jdField_a_of_type_Apwk = new apwk(this.app, this.sessionInfo.aTl, "Grp_time", "Grp_AIO", "visit_time");
    artb.d(this.mActivity, this.mActivity.getIntent(), true);
    Object localObject = (wur)this.jdField_a_of_type_Wvm.a(52);
    if (localObject != null) {
      ((wur)localObject).initData();
    }
    return true;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    paramEditable = (wwn)a(27);
    if (paramEditable != null) {
      paramEditable.ccF();
    }
  }
  
  public void aqz()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()) && (!a().isFinishing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public void b(String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    aptw localaptw = (aptw)this.app.getManager(203);
    if ((localaptw.qY(this.sessionInfo.aTl)) && (localaptw.gM(paramString1)))
    {
      if (Tq()) {
        return;
      }
      this.aWO = paramString1;
      localaptw.crs = paramString1;
      this.aWP = paramString2;
    }
    super.b(paramString1, paramString2, paramBoolean, paramInt);
  }
  
  public void bGJ()
  {
    super.bGJ();
    this.jdField_b_of_type_Jrp = new jrp(this.app);
    if (this.mActivity.getIntent().getBooleanExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", false)) {
      ujt.a(this.app, this.sessionInfo, this.mActivity.getIntent());
    }
    this.blS = true;
    ((TroopManager)this.app.getManager(52)).Fz(this.sessionInfo.aTl);
    Object localObject = this.mActivity.getIntent().getStringExtra("uin");
    aizp.a().am(this.app, (String)localObject);
    if (this.jdField_a_of_type_Wiw != null) {
      this.jdField_a_of_type_Wiw.a(this.jdField_a_of_type_Wiw$a);
    }
    ThreadManager.post(new CheckGlamourPicturesRunnable(this.mActivity), 2, null, true);
    int i;
    if (TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.aTl))
    {
      localObject = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
      if (localObject != null)
      {
        if (!((TroopInfo)localObject).isTroopOwner(this.app.getCurrentAccountUin())) {
          break label326;
        }
        i = 1;
      }
    }
    for (;;)
    {
      new anov(this.app).a("dc00899").b("Grp_private").c("Grp_AIO").d("exp").a(new String[] { this.sessionInfo.aTl, String.valueOf(i) }).report();
      if (this.g == null)
      {
        this.g = new a(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().addOnGlobalLayoutListener(this.g);
      }
      this.blV = false;
      ((wxk)a(23)).xO(this.sessionInfo.aTl);
      chO();
      return;
      label326:
      if (((TroopInfo)localObject).isTroopAdmin(this.app.getCurrentAccountUin())) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  public void bGK()
  {
    super.bGK();
    if ((this.jdField_a_of_type_Apat.aAN()) && ((this.jdField_a_of_type_Apat.Lf() == 17) || (this.jdField_a_of_type_Apat.Lf() == 100) || (this.jdField_a_of_type_Apat.Lf() == 11))) {
      return;
    }
    this.jdField_a_of_type_Yjm = new yjm(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo, this.jdField_a_of_type_Apat, this.jdField_c_of_type_AndroidWidgetToast);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yjm);
    this.jdField_a_of_type_Yij = new yij(this.app, this.jdField_a_of_type_Yjh, this.mActivity, this.sessionInfo);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yij);
    this.jdField_a_of_type_Yjl = new yjl(this.app, this.sessionInfo, this.jdField_a_of_type_Yjh, this.mActivity);
    this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yjl);
  }
  
  public void bGT()
  {
    bIL();
    ((wxc)a(43)).ccX();
  }
  
  public void bGW()
  {
    bIY();
  }
  
  public void bGY()
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.pr != null) && (this.pr.getVisibility() == 0))
    {
      localObject1 = (TroopManager)this.app.getManager(52);
      if (localObject1 == null) {
        break label195;
      }
      localObject1 = ((TroopManager)localObject1).b(this.sessionInfo.aTl);
      if (localObject1 == null) {
        break label195;
      }
      localObject2 = this.app.getCurrentAccountUin();
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty(((TroopInfo)localObject1).Administrator))) {
        break label195;
      }
      if ((!((String)localObject2).equals(((TroopInfo)localObject1).Administrator)) && (!((TroopInfo)localObject1).Administrator.contains((CharSequence)localObject2))) {
        break label183;
      }
      i = 1;
    }
    for (;;)
    {
      localObject2 = this.app;
      String str = this.sessionInfo.aTl;
      if (i != 0) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        anot.a((QQAppInterface)localObject2, "P_CliOper", "Grp_set", "", "AIOchat", "Clk_dataEntry_new", 0, 0, str, (String)localObject1, "", "");
        VasWebviewUtil.reportCommercialDrainage("", "style", "0X8008E61", "", 1, 0, 0, "", "", "");
        chE();
        return;
        label183:
        i = 0;
        break;
      }
      label195:
      i = 0;
    }
  }
  
  public void bGZ()
  {
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    if ((localTroopManager != null) && (localTroopManager.kB(this.sessionInfo.aTl)))
    {
      this.pp.setVisibility(8);
      return;
    }
    if ((this.aaR) || (this.bke)) {
      this.pp.setImageResource(2130844468);
    }
    for (;;)
    {
      this.pp.setVisibility(0);
      return;
      a(this.pp, 2130851146, 2130851146);
    }
  }
  
  public void bHA()
  {
    if (((this.mActivity instanceof SplashActivity)) && (this.jdField_a_of_type_Apwy != null)) {
      this.jdField_a_of_type_Apwy.onPause();
    }
    super.bHA();
  }
  
  public void bHZ()
  {
    super.bHZ();
    this.app.addDefaultObservers(this.jdField_a_of_type_Achq);
    this.app.addObserver(this.jdField_a_of_type_Acnd);
    this.app.addObserver(this.jdField_a_of_type_Acfd);
    this.app.addObserver(this.jdField_b_of_type_Accd);
    this.app.addObserver(this.jdField_a_of_type_Aclh);
    this.app.addObserver(this.jdField_a_of_type_Acnh);
    this.app.addObserver(this.jdField_a_of_type_Aobo);
    if (this.app.a() != null) {
      this.app.a().addProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    chx();
    ((ahvn)this.app.getManager(156)).a().addObserver(this.jdField_b_of_type_JavaUtilObserver);
  }
  
  public void bHg()
  {
    super.bHg();
    chI();
  }
  
  public void bHt()
  {
    super.bHt();
    if (this.aaR)
    {
      this.cL.setBackgroundResource(2130844446);
      jof.a().a(this.jdField_b_of_type_Jof$d);
      ay(-16777216, false);
    }
    chv();
  }
  
  public void bHy()
  {
    super.bHy();
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent == null) {
      return;
    }
    String str = localIntent.getStringExtra("uin");
    int i = localIntent.getIntExtra("uintype", -1);
    if ((this.sessionInfo.aTl != null) && ((!this.sessionInfo.aTl.equals(str)) || (this.sessionInfo.cZ != i))) {}
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (this.jdField_a_of_type_Apmp != null))
      {
        this.jdField_a_of_type_Apmp.destory();
        this.jdField_a_of_type_Apmp = null;
      }
      if ((i != 0) && (this.jdField_a_of_type_Apgj != null) && (this.jdField_a_of_type_Apgj.a != null))
      {
        this.jdField_a_of_type_Apgj.a.destroy();
        this.jdField_a_of_type_Apgj.a = null;
      }
      if (this.jdField_a_of_type_Apsd$c != null)
      {
        apsd.b(this.app, this.jdField_a_of_type_Apsd$c);
        this.jdField_a_of_type_Apsd$c = null;
      }
      chO();
      this.aSk = true;
      return;
    }
  }
  
  public void bIL()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.ejD();
  }
  
  public void bIQ()
  {
    super.bIQ();
    chG();
  }
  
  public void bIa()
  {
    super.bIa();
    this.app.removeObserver(this.jdField_a_of_type_Achq);
    this.app.removeObserver(this.jdField_a_of_type_Acnd);
    this.app.removeObserver(this.jdField_a_of_type_Acfd);
    this.app.removeObserver(this.jdField_b_of_type_Accd);
    this.app.removeObserver(this.jdField_a_of_type_Aclh);
    this.app.removeObserver(this.jdField_a_of_type_Acnh);
    this.app.removeObserver(this.jdField_a_of_type_Aobo);
    this.app.unRegistObserver(this.jdField_a_of_type_Aoxz);
    if (this.app.a() != null) {
      this.app.a().removeProxyObserver(this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyObserver);
    }
    ((ahvn)this.app.getManager(156)).a().deleteObserver(this.jdField_b_of_type_JavaUtilObserver);
  }
  
  public void bIb()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "clickSendTextButton. isSending:" + this.aCV);
    }
    if (!this.aCV) {
      this.aCV = true;
    }
    for (int i = 1;; i = 0)
    {
      super.bIb();
      if (i == 0) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "clickSendTextButton process talking state");
      }
      aptw localaptw = (aptw)this.app.getManager(203);
      boolean bool2 = localaptw.aBy();
      Object localObject = localaptw.crp;
      String str1 = localaptw.crq;
      ArrayList localArrayList = new ArrayList();
      String str2 = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      i = 0;
      label261:
      boolean bool3;
      if (i < localArrayList.size())
      {
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(i);
        if (localaptw.cR(localAtTroopMemberInfo.uin))
        {
          localObject = "" + localAtTroopMemberInfo.uin;
          str1 = aqgv.h(this.app, this.sessionInfo.aTl, (String)localObject);
          if ((bool2) || (localaptw.x(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.aTl)))
          {
            bool1 = true;
            bool3 = localaptw.y(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.aTl);
            bool2 = bool1;
          }
        }
      }
      for (boolean bool1 = bool3;; bool1 = false)
      {
        if ((bool2) && (!bool1))
        {
          localObject = appb.a(this.app, this.mContext, this.sessionInfo.aTl, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          b(localaptw.crp, localaptw.crq, true, 0);
        }
        for (;;)
        {
          this.aCV = false;
          return;
          bool1 = false;
          break label261;
          i += 1;
          break;
          xqh.a(this.app, str2, localArrayList, this.sessionInfo.aTl);
          if ((str2 == null) || (str2.length() <= 3478)) {
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          }
          if (this.bkf)
          {
            zT(false);
            localObject = (wxk)a(23);
            if (localObject != null) {
              ((wxk)localObject).l(false);
            }
          }
          this.bkg = false;
          localaptw.ebO();
        }
      }
    }
  }
  
  public void bJf()
  {
    super.bJf();
    this.jdField_a_of_type_Wvm.a(this);
  }
  
  public void bZR()
  {
    super.bZR();
    if ((this.jdField_a_of_type_Apat != null) && (!isDestroy())) {
      this.jdField_a_of_type_Apat.a().dYj();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((wtj)a(34)).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public void bn(Intent paramIntent)
  {
    DO(0);
    if ((this.aaR) && (!jof.a().dd(this.sessionInfo.aTl)))
    {
      zh(false);
      this.xC.setVisibility(8);
      this.xD.setVisibility(8);
    }
    String str1;
    String str2;
    int i;
    for (;;)
    {
      if ((this.aaR) && (jof.a().dd(this.sessionInfo.aTl))) {
        this.Cu.setText(this.mActivity.getResources().getString(2131690308) + jof.a().a(this.sessionInfo.aTl).nickName);
      }
      super.bn(paramIntent);
      str1 = paramIntent.getStringExtra("greetingsTitle");
      str2 = paramIntent.getStringExtra("greetingsContent");
      i = paramIntent.getIntExtra("types", 0);
      if (i == 1)
      {
        Object localObject1 = paramIntent.getStringExtra("greetingsMembers");
        if (localObject1 != null) {
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            i = 0;
            for (;;)
            {
              if (i < ((JSONArray)localObject1).length())
              {
                Object localObject3 = ((JSONArray)localObject1).getString(i);
                String str3 = aqgv.o(this.app, this.sessionInfo.aTl, (String)localObject3);
                localObject3 = appb.a(this.app, this.mContext, this.sessionInfo.aTl, (String)localObject3, str3, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                i += 1;
                continue;
                if (!jof.a().dd(this.sessionInfo.aTl)) {
                  break;
                }
                zh(true);
                this.cL.setBackgroundResource(2130844446);
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundResource(2130844452);
                this.xC.setVisibility(0);
              }
            }
          }
          catch (JSONException localJSONException)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "TroopChatPie send greetings.get members failed.");
            }
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      if (!TextUtils.isEmpty(str1))
      {
        localObject2 = (wwn)a(27);
        if (localObject2 != null) {
          ((wwn)localObject2).ai("0", str2, str1);
        }
      }
      if (paramIntent.getBooleanExtra("sendGift", false)) {
        aj(true, TroopGiftPanel.byo);
      }
      if ((this.sessionInfo.cZ == 1) && (TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.aTl)) && (this.jdField_a_of_type_Wnc != null)) {
        this.jdField_a_of_type_Wnc.bZM();
      }
      this.ps.setVisibility(8);
      ((wxc)a(43)).ccX();
      return;
      if (i == 2)
      {
        localObject2 = paramIntent.getStringExtra("greetingsName");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, "@" + (String)localObject2 + " ");
      }
    }
  }
  
  public void bo()
  {
    super.bo();
    aehj.C(this.app, false);
  }
  
  public void bo(Intent paramIntent)
  {
    super.bo(paramIntent);
    chu();
  }
  
  public void br(int paramInt, String paramString)
  {
    if (this.jdField_b_of_type_Jog == null) {
      this.jdField_b_of_type_Jog = new jog(this.mActivity);
    }
    this.jdField_b_of_type_Jog.al(paramInt, paramString);
    this.jdField_b_of_type_Jog.show();
    TroopChatPie.29 local29;
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramString = this.uiHandler;
      local29 = new TroopChatPie.29(this);
      if (!AppSetting.enableTalkBack) {
        break label82;
      }
    }
    label82:
    for (long l = 3000L;; l = 1000L)
    {
      paramString.postDelayed(local29, l);
      return;
    }
  }
  
  public void bs(Intent paramIntent)
  {
    super.bs(paramIntent);
    aqmq.track(null, "AIO_updateSession_business");
    if ((this.sessionInfo.troopUin == null) || (this.sessionInfo.troopUin.length() == 0))
    {
      paramIntent = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
      if (paramIntent != null) {
        this.sessionInfo.troopUin = paramIntent.troopcode;
      }
    }
    this.bYJ = 2;
    aqmq.track("AIO_updateSession_business", null);
  }
  
  public void bt(Intent paramIntent)
  {
    super.bt(paramIntent);
    if (this.aaR) {
      if (this.Cr.getVisibility() == 0)
      {
        this.Cr.setBackgroundResource(2130844472);
        this.Cr.setTextColor(jof.aCs);
        this.tU.setTextColor(jof.aCs);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.pq.getVisibility() != 0);
      this.pq.setBackgroundResource(2130851759);
      this.Cs.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130838049));
      return;
      if (this.Cr.getVisibility() == 0)
      {
        this.Cr.setBackgroundResource(2130851758);
        this.Cr.setTextColor(this.mActivity.getResources().getColor(2131167298));
        this.tU.setTextColor(this.mActivity.getResources().getColor(2131167298));
        return;
      }
    } while (this.pq.getVisibility() != 0);
    this.pq.setBackgroundResource(2130851759);
    this.pq.setPadding(0, 0, 0, 0);
    this.Cs.setTextColor(this.mActivity.getResources().getColor(2131167298));
    this.Cs.setBackgroundDrawable(a().getDrawable(2130838072));
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    super.c(paramChatMessage);
    bIL();
    this.aQ.setVisibility(0);
  }
  
  public void ccU()
  {
    if ((this.pv == null) || (this.Cu == null) || (this.cK == null) || (this.mTitleText == null)) {
      return;
    }
    Object localObject = (aiqk)a(33);
    boolean bool1 = ((aiqk)localObject).apu();
    boolean bool2 = ((aiqk)localObject).Si();
    wxc localwxc = (wxc)a(43);
    boolean bool3 = localwxc.Sl();
    int i;
    if (bool1)
    {
      DO(3);
      vU(true);
      this.Cu.setText(((aiqk)localObject).u(bool2));
      this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
      zS(bool2);
      i = wja.dp2px(8.0F, this.Cu.getResources());
      aiqd.i(this.cK, 0, i, 0, 0);
    }
    label147:
    while ((QLog.isColorLevel()) && (QLog.isColorLevel()))
    {
      QLog.d("BaseListenTogetherPanel_Troop", 2, "togetherTime=" + bool1 + ",hasPannelShow" + bool2);
      return;
      if (bool3)
      {
        bool3 = localwxc.Si();
        DO(4);
        vU(true);
        this.Cu.setText(localwxc.pr());
        this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
        zS(bool3);
        i = wja.dp2px(8.0F, this.Cu.getResources());
        aiqd.i(this.cK, 0, i, 0, 0);
      }
      else
      {
        localObject = ((apys)this.app.getManager(234)).oU(a().aTl);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label380;
        }
        DO(2);
        vU(true);
        this.Cu.setText((CharSequence)localObject);
        this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
        this.pv.setVisibility(0);
        zR(false);
      }
    }
    for (;;)
    {
      aiqd.gX(this.cK);
      break label147;
      break;
      label380:
      this.Cu.setText("");
      DO(0);
    }
  }
  
  public void cfu()
  {
    boolean bool = false;
    super.cfu();
    if (this.jdField_a_of_type_Apsd$c == null)
    {
      c localc = new c(this.sessionInfo.aTl);
      this.jdField_a_of_type_Apsd$c = new apsd.c(this.mActivity, localc, this.app);
    }
    apsd.a(this.app, this.jdField_a_of_type_Apsd$c);
    aA(false);
    if (this.aaR != jof.a().dd(this.sessionInfo.aTl))
    {
      if (!this.aaR) {
        bool = true;
      }
      this.aaR = bool;
      zh(this.aaR);
    }
    ((apsa)this.app.getManager(132)).TP(this.sessionInfo.aTl);
  }
  
  public void cfv()
  {
    super.cfv();
    this.bfi = this.app.a().A(this.sessionInfo.aTl, this.sessionInfo.cZ);
    chK();
    chw();
    chL();
    Object localObject = this.mActivity.getIntent();
    if (localObject != null)
    {
      String str1 = ((Intent)localObject).getStringExtra("at_member_name");
      String str2 = ((Intent)localObject).getStringExtra("at_member_uin");
      int i = ((Intent)localObject).getIntExtra("at_member_source", 0);
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
        b(str2, str1, false, i);
      }
    }
    chM();
    this.bmd = false;
    if (!this.bmc) {
      chN();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eC);
    ThreadManager.getSubThreadHandler().postDelayed(this.eC, 500L);
    chH();
    this.bmc = true;
    if ((this.blW) && (this.jdField_a_of_type_Apgj != null))
    {
      this.jdField_a_of_type_Apgj.RH(true);
      this.blW = false;
    }
    localObject = (apdr)this.app.getManager(231);
    if ((((apdr)localObject).dTG != 0) && (!jof.a().dd(this.sessionInfo.aTl)) && (!anlm.ayn()))
    {
      ((apdr)localObject).d(new apdj.a(((apdr)localObject).effectId, this.app.getCurrentAccountUin(), this.sessionInfo.aTl, ((apdr)localObject).dTE, ((apdr)localObject).dTF, ((apdr)localObject).dTH, ((apdr)localObject).dTG));
      localObject = a();
      ((apdj)localObject).yJ(this.sessionInfo.aTl);
      ((apdj)localObject).dYL();
    }
  }
  
  public void chB()
  {
    if (this.jdField_a_of_type_Yjh != null)
    {
      aboy localaboy = aboy.c();
      if (localaboy != null) {
        localaboy.cDO();
      }
    }
  }
  
  public void chC()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new yev(this));
    if ((this.xF != null) && (this.xE != null))
    {
      this.xF.startAnimation(localAlphaAnimation);
      this.xE.startAnimation(localAlphaAnimation);
    }
  }
  
  public void chD()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(200L);
    localAlphaAnimation.setAnimationListener(new yew(this));
    this.xF.startAnimation(localAlphaAnimation);
    this.xE.startAnimation(localAlphaAnimation);
  }
  
  protected void chF()
  {
    Object localObject1 = (aptw)this.app.getManager(203);
    Object localObject2;
    String str1;
    int i;
    boolean bool;
    if (((aptw)localObject1).qY(this.sessionInfo.aTl)) {
      if (!this.aCV)
      {
        localObject2 = (appb[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString().length(), appb.class);
        str1 = this.sessionInfo.aTl;
        i = 0;
        if (i >= localObject2.length) {
          break label439;
        }
        if (!((aptw)localObject1).gM(localObject2[i].Bw())) {
          break label247;
        }
        String str2 = localObject2[i].Bw();
        this.aWO = str2;
        ((aptw)localObject1).crs = str2;
        this.aWP = localObject2[i].Bx();
        if (!this.aWP.startsWith("@")) {
          break label434;
        }
        this.aWP = this.aWP.substring(1);
        bool = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.BC() != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.BC().equals(this.aWO))) {
        bool = false;
      }
      for (;;)
      {
        ((www)a(29)).zi(bool);
        if (this.bkg == bool) {
          if (bool)
          {
            localObject1 = (wxk)a(23);
            if (localObject1 != null) {
              ((wxk)localObject1).CX(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount());
            }
          }
        }
        label247:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                i += 1;
                break;
                this.bkg = bool;
                if (bool) {
                  break label364;
                }
                zT(false);
                localObject2 = (wxk)a(23);
                if (localObject2 != null) {
                  ((wxk)localObject2).l(false);
                }
              } while (!((aptw)localObject1).aBy());
              ((aptw)localObject1).ebO();
              aptw.report("panel", "talk_out", this.sessionInfo.aTl, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.BC(), "2", "");
              ((aptw)localObject1).b(Long.parseLong(this.sessionInfo.aTl), Long.parseLong(this.aWO), "off", new yfa(this));
              return;
            } while (this.bkf);
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopAIORobotLayout.a(str1, this.aWO, this.aWP, this, new yfb(this));
            return;
          } while (!this.bkf);
          zT(false);
          localObject1 = (wxk)a(23);
        } while (localObject1 == null);
        label364:
        ((wxk)localObject1).l(false);
        return;
      }
      label434:
      bool = true;
      continue;
      label439:
      bool = false;
    }
  }
  
  public void chH()
  {
    if (this.Ct == null) {
      this.Ct = ((TextView)this.cJ.findViewById(2131365958));
    }
    Object localObject = ((TroopManager)this.app.getManager(52)).c(this.sessionInfo.aTl);
    if ((localObject == null) || (((TroopInfo)localObject).wMemberNumClient <= 0))
    {
      this.Ct.setVisibility(8);
      if (QLog.isColorLevel())
      {
        if (localObject != null) {
          QLog.d(this.TAG, 2, "showNewTroopMemberCount count smaller than 0" + ((TroopInfo)localObject).wMemberNumClient);
        }
      }
      else {
        return;
      }
      QLog.d(this.TAG, 2, "showNewTroopMemberCount info is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "showNewTroopMemberCount wMemberNumClient:" + ((TroopInfo)localObject).wMemberNumClient + "  wMemberNum:" + ((TroopInfo)localObject).wMemberNum + " troopUin:" + ((TroopInfo)localObject).troopuin);
    }
    this.Ct.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject).wMemberNumClient) }));
    if (this.Ct.getVisibility() != 0)
    {
      this.Ct.setVisibility(0);
      this.Ct.setGravity(16);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.du) {
          break label284;
        }
      }
    }
    label284:
    for (boolean bool = true;; bool = false)
    {
      ((NavBarAIO)localObject).bN(bool, this.sessionInfo.cZ);
      ba(this.sessionInfo.aTl, false);
      return;
    }
  }
  
  public void chO()
  {
    this.blY = false;
    this.blZ = false;
    this.qT.clear();
    this.JQ = 0L;
    this.JP = 0L;
  }
  
  protected void chq()
  {
    vY(true);
    TroopChatPie.1 local1 = new TroopChatPie.1(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, local1, 9);
  }
  
  public void cht()
  {
    if (((TroopManager)this.app.getManager(52)).ab(this.sessionInfo.aTl) - NetConnInfoCenter.getServerTime() < 259200L) {
      ThreadManager.post(this.eB, 8, null, true);
    }
  }
  
  protected void chv()
  {
    boolean bool3 = false;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    Object localObject = null;
    if (localTroopManager != null) {
      localObject = localTroopManager.b(this.sessionInfo.aTl);
    }
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, troopInfo==null:" + this.sessionInfo.aTl);
      }
    }
    long l;
    do
    {
      return;
      l = ((TroopInfo)localObject).troopCreditLevel;
      if ((l == 1L) || (l == 2L)) {
        break;
      }
      if ((this.V != null) && (this.V.isShowing())) {
        this.V.dismiss();
      }
    } while (!QLog.isColorLevel());
    QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, normal:" + this.sessionInfo.aTl + "," + l);
    return;
    boolean bool1;
    if ((((TroopInfo)localObject).dwAdditionalFlag & 1L) == 1L)
    {
      bool1 = true;
      if ((((TroopInfo)localObject).dwCmdUinUinFlag & 1L) != 1L) {
        break label362;
      }
    }
    label362:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((bool1) || (bool2)) {
        bool3 = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.act", 2, "checkTroopCreditLevel:" + this.sessionInfo.aTl + "," + bool1 + ", " + bool2);
      }
      localObject = (acms)this.app.getBusinessHandler(20);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.act", 2, "checkTroopCreditLevel, getTroopCreditInfo:" + this.sessionInfo.aTl);
        }
        ((acms)localObject).bL(this.sessionInfo.aTl, true);
      }
      af(l, bool3);
      return;
      bool1 = false;
      break;
    }
  }
  
  void chw()
  {
    Object localObject;
    if (this.sessionInfo.cZ == 1)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject != null) {
        break label29;
      }
    }
    label29:
    do
    {
      for (;;)
      {
        return;
        localObject = ((TroopManager)localObject).b(this.sessionInfo.aTl);
        if ((localObject != null) && ((((TroopInfo)localObject).wMemberNum == 0) || (TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)))) {
          try
          {
            long l = Long.parseLong(this.sessionInfo.aTl);
            localObject = new ArrayList();
            ((ArrayList)localObject).add(Long.valueOf(l));
            ((acms)this.app.getBusinessHandler(20)).dL((ArrayList)localObject);
            if (QLog.isColorLevel())
            {
              QLog.d(this.TAG, 2, "getTroopInfoIfNeed, sessionInfo.curFriendUin = " + this.sessionInfo.aTl);
              return;
            }
          }
          catch (Exception localException) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.TAG, 2, "getTroopInfoIfNeed failed");
  }
  
  public void chy()
  {
    acms localacms = (acms)this.app.getBusinessHandler(20);
    if (localacms != null) {}
    try
    {
      localacms.a(Long.parseLong(this.sessionInfo.aTl), 0L, 2, 0, 0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(this.TAG, 2, localException.toString());
    }
  }
  
  void chz()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground() != null) {
      aG();
    }
    chA();
    this.pz.setVisibility(8);
    this.mTitleText.setTextColor(this.mActivity.getResources().getColor(2131167301));
    this.Ct.setTextColor(this.mActivity.getResources().getColor(2131167301));
    Object localObject;
    if (this.Cr.getVisibility() == 0)
    {
      this.Cr.setBackgroundResource(2130851758);
      this.Cr.setTextColor(this.mActivity.getResources().getColor(2131167298));
      this.tU.setTextColor(this.mActivity.getResources().getColor(2131167298));
      wja.S(this.pp, 2130851767);
      if ((this.Cu.getVisibility() == 0) && (this.Cu.getText() != null) && (this.Cu.getText().toString().startsWith(this.mActivity.getResources().getString(2131690308))))
      {
        this.Cu.setText("");
        this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
        vU(false);
      }
      localObject = (apys)this.app.getManager(234);
      String str = ((apys)localObject).oU(a().aTl);
      if (TextUtils.isEmpty(str)) {
        break label633;
      }
      DO(2);
      if (((apys)localObject).eY(a().aTl) != 3) {
        break label575;
      }
      aqfr.b("Grp_idol", "Grp_AIO", "exp_renshu", 0, 0, new String[] { a().aTl });
      label304:
      vU(true);
      this.Cu.setText(str);
      this.Cu.setTextColor(this.mActivity.getResources().getColor(2131167301));
      this.pv.setVisibility(0);
      zR(false);
    }
    for (;;)
    {
      localObject = (PlusPanel)this.jdField_a_of_type_Xru.B(8);
      if (localObject != null)
      {
        ((PlusPanel)localObject).b.isAnonymous = false;
        ((PlusPanel)localObject).reload();
      }
      if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
        this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.HW(false);
      }
      this.xC.setVisibility(8);
      this.xD.setVisibility(8);
      jof.a().ayF();
      chD();
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(1.0F, 0.0F, 1.0F, this.mActivity.getResources().getColor(2131165545));
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint("");
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        wja.S(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130850892);
      }
      chB();
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.abp(1);
      ((wxc)a(43)).ccW();
      return;
      if (this.pq.getVisibility() != 0) {
        break;
      }
      this.pq.setBackgroundResource(2130851759);
      this.pq.setPadding(0, 0, 0, 0);
      this.Cs.setTextColor(this.mActivity.getResources().getColor(2131167298));
      this.Cs.setBackgroundDrawable(a().getDrawable(2130838072));
      break;
      label575:
      new anov(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("exp_onlineEntry").a(new String[] { a().aTl }).report();
      break label304;
      label633:
      DO(0);
    }
  }
  
  public void dN(String paramString)
  {
    if (a().isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Arhz == null) {
        this.jdField_a_of_type_Arhz = new arhz(a(), a().getTitleBarHeight());
      }
      this.jdField_a_of_type_Arhz.setMessage(paramString);
    } while ((a().isFinishing()) || (this.jdField_a_of_type_Arhz.isShowing()));
    this.jdField_a_of_type_Arhz.show();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2000) {
      cv(paramIntent);
    }
    if ((paramInt1 != 5) && (paramInt1 != 2000) && (aA(true))) {
      return;
    }
    if (paramInt2 == -1) {
      G(paramInt1, paramIntent);
    }
    for (;;)
    {
      super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == 8001)
      {
        if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer != null) {
          this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
        }
      }
      else if (paramInt1 == 12005) {
        chs();
      } else if (paramInt2 == 0) {
        DN(paramInt1);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.stop(true);
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eC);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eD);
    this.blU = false;
    this.blT = false;
    if (this.jdField_a_of_type_Apdj != null) {
      this.jdField_a_of_type_Apdj.onDestroy();
    }
    if (this.aSY) {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "hasDestory = true return");
      }
    }
    for (;;)
    {
      return;
      if (this.bez) {
        chJ();
      }
      ((wtj)a(34)).onDestroy();
      if (this.bW != null) {
        this.bW.removeCallbacks(this.eA);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.destroy();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView = null;
      }
      if (this.jdField_b_of_type_Jog != null)
      {
        this.jdField_b_of_type_Jog.dismiss();
        this.jdField_b_of_type_Jog = null;
      }
      if (this.jdField_b_of_type_Jrp != null) {
        this.jdField_b_of_type_Jrp.destroy();
      }
      jof.a().ayF();
      if (this.aaR) {
        ay(this.mActivity.getResources().getColor(2131167361), true);
      }
      xqa.aV(this.app);
      if (this.jdField_a_of_type_Slz != null)
      {
        this.jdField_a_of_type_Slz.dismiss();
        this.jdField_a_of_type_Slz = null;
      }
      if (this.jdField_a_of_type_Smx != null) {
        this.jdField_a_of_type_Smx = null;
      }
      Object localObject = (apsa)this.app.getManager(132);
      ((apsa)localObject).TP("");
      if (((apsa)localObject).qQ(this.sessionInfo.aTl)) {
        ((apsa)localObject).TM(this.sessionInfo.aTl);
      }
      DR(0);
      this.bYJ = 0;
      this.bmc = false;
      this.bme = false;
      this.bmg = false;
      this.bmf = false;
      localObject = (aptw)this.app.getManager(203);
      ((aptw)localObject).bd(this.sessionInfo.aTl, this.aWO, "off");
      ((aptw)localObject).a(null);
      ((psu)psx.a(5)).bmH();
      ((ptf)psx.a(2)).bmH();
      ((rnu)this.app.getManager(208)).bmH();
      if (!TextUtils.isEmpty(this.sessionInfo.aTl)) {
        top.b(this.app, this.sessionInfo.aTl, this.sessionInfo.cZ, -4021);
      }
      if (this.jdField_a_of_type_Apyl != null)
      {
        this.jdField_a_of_type_Apyl.destroy();
        this.jdField_a_of_type_Apyl = null;
      }
      DO(0);
      if (this.jdField_a_of_type_Apwk != null) {
        this.jdField_a_of_type_Apwk.stop();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.unInit();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel = null;
      }
      chO();
      super.doOnDestroy();
      if (this.bX != null)
      {
        this.bX.removeCallbacksAndMessages(null);
        if (QLog.isColorLevel()) {
          QLog.d("troop_gag", 2, "doOnDestroy, timerHandler->removeCallbacksAndMessages");
        }
      }
      apot.a().eaZ();
      if (this.jdField_a_of_type_Apyu != null)
      {
        this.jdField_a_of_type_Apyu.dZt();
        this.jdField_a_of_type_Apyu = null;
      }
      this.su.clear();
      if (this.Ct != null) {
        this.Ct.setVisibility(8);
      }
      if ((this.W != null) && (this.W.isShowing())) {
        this.W.dismiss();
      }
      if (this.jdField_a_of_type_Apgj != null) {
        this.jdField_a_of_type_Apgj.dZt();
      }
      try
      {
        if (this.an != null)
        {
          this.mContext.unregisterReceiver(this.an);
          this.an = null;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            if (this.aO != null)
            {
              this.mContext.unregisterReceiver(this.aO);
              this.aO = null;
            }
            xpw.gQ.clear();
            xpw.j.evictAll();
            aehj.D(this.app, false);
            localObject = new Intent("com.tencent.mobileqq.action.ACTION_CONFESS_FINISH_EVENT");
            BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
            this.blX = false;
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.TX(false);
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.TW(false);
            }
            if (this.jdField_a_of_type_Wiw != null) {
              this.jdField_a_of_type_Wiw.a(null);
            }
            if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (this.g == null)) {
              break;
            }
            if (Build.VERSION.SDK_INT >= 16) {
              break label876;
            }
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeGlobalOnLayoutListener(this.g);
            this.g = null;
            return;
            localException1 = localException1;
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "doOnDestroy unregisterReceiver, e:" + localException1.getMessage());
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.e(this.TAG, 2, "doOnDestroy mConfessReceiver unregisterReceiver, e:" + localException2.getMessage());
              continue;
              label876:
              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver().removeOnGlobalLayoutListener(this.g);
            }
          }
        }
      }
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Apyu != null) {
      this.jdField_a_of_type_Apyu.ecF();
    }
    if (this.jdField_a_of_type_Apdj != null) {
      this.jdField_a_of_type_Apdj.onPause();
    }
    if (this.jdField_c_of_type_AndroidWidgetToast != null) {
      this.jdField_c_of_type_AndroidWidgetToast.cancel();
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.eC);
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Slz == null) || (!this.jdField_a_of_type_Slz.isShowing()))
    {
      localObject = (apqk)this.app.getManager(223);
      if (localObject != null) {
        ((apqk)localObject).ebn();
      }
    }
    if (apot.a().isPlaying()) {
      apot.a().stop();
    }
    Object localObject = (apdr)this.app.getManager(231);
    ((apdr)localObject).dTG = 0;
    ((apdr)localObject).dTE = 0;
    ((apdr)localObject).dTF = 0;
    ((apdr)localObject).dTH = 0;
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "doOnPause, isTroopOwner =" + this.bma);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.app.cs(this.sessionInfo.aTl) == 2)
    {
      this.bkd = this.app.b().C(this.sessionInfo.aTl, this.sessionInfo.cZ);
      if (this.bkd) {
        chq();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetFloatView.setVisibility(0);
    }
    this.jdField_a_of_type_Apdj = a();
    this.jdField_a_of_type_Apdj.onResume();
    this.jdField_a_of_type_Apdj.yJ(this.sessionInfo.aTl);
    aehj.D(this.app, true);
    ba(this.sessionInfo.aTl, true);
    this.jdField_a_of_type_Apwk.start();
  }
  
  public void doOnStop()
  {
    if (this.aaR) {
      chA();
    }
    if (this.jdField_a_of_type_Apsd$c != null)
    {
      apsd.b(this.app, this.jdField_a_of_type_Apsd$c);
      this.jdField_a_of_type_Apsd$c = null;
    }
    if ((this.jdField_a_of_type_Slz == null) || (!this.jdField_a_of_type_Slz.isShowing()))
    {
      apqk localapqk = (apqk)this.app.getManager(223);
      if (localapqk != null) {
        localapqk.ebn();
      }
    }
    if (this.jdField_c_of_type_AndroidWidgetToast != null) {
      this.jdField_c_of_type_AndroidWidgetToast.cancel();
    }
    if (this.jdField_a_of_type_Apxr != null) {
      this.jdField_a_of_type_Apxr.ecD();
    }
    if (apot.a().isPlaying()) {
      apot.a().stop();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.stop(true);
    }
    super.doOnStop();
  }
  
  public void ex(View paramView)
  {
    if (paramView.getId() == 2131378923)
    {
      if (this.bXX == 2)
      {
        if (this.jdField_a_of_type_Apyl == null) {
          this.jdField_a_of_type_Apyl = new apyl(this.app, this.mContext, this.fs, this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO, this.jdField_a_of_type_Apat);
        }
        this.jdField_a_of_type_Apyl.yJ(a().aTl);
        if (!this.jdField_a_of_type_Apyl.aBH()) {}
      }
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Apyl.isShowing()) {
            break;
          }
          chG();
        } while (this.jdField_a_of_type_Apyl.dSG == 2);
        new anov(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryClose").a(new String[] { a().aTl }).report();
        return;
        this.jdField_a_of_type_Apyl.show(1);
        paramView = (acms)this.app.getBusinessHandler(20);
        if (paramView != null) {
          paramView.Fk(a().aTl);
        }
        zS(true);
        if (this.jdField_a_of_type_Apyl.dSG == 2)
        {
          aqfr.b("Grp_idol", "Grp_AIO", "clk_renshu", 0, 0, new String[] { a().aTl });
          return;
        }
        new anov(this.app).a("dc00899").b("Grp_online").c("Grp_AIO").d("clk_EntryOpen").a(new String[] { a().aTl }).report();
        return;
        if (this.bXX == 3)
        {
          ((aiqk)a(33)).dtG();
          return;
        }
      } while (this.bXX != 4);
      ((wxc)a(43)).xM(this.sessionInfo.aTl);
      return;
    }
    chE();
  }
  
  public void g(Intent paramIntent, int paramInt)
  {
    int i = paramIntent.getIntExtra(aqfx.REQUEST_CODE, -1);
    if (((i == 2) || (i == 1)) && (aA(true))) {
      return;
    }
    super.g(paramIntent, paramInt);
  }
  
  public boolean hV(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!this.isScrolling)
    {
      int i = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int m = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int k = this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (i > k) {}
      for (;;)
      {
        bool2 = bool1;
        if (i < k) {
          break label197;
        }
        bool2 = bool1;
        if (i > m) {
          break label197;
        }
        try
        {
          Object localObject = (ChatMessage)this.jdField_b_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(i);
          if ((localObject == null) || (((ChatMessage)localObject).msgtype != -1012)) {
            break;
          }
          localObject = ((ChatMessage)localObject).getExtInfoFromExtStr("troop_new_member_uin");
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "isNewMemberGrayTipVisible newMemberUin = " + (String)localObject + ",detect memberUin = " + paramString);
          }
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          bool2 = ((String)localObject).equals(paramString);
          if (!bool2) {
            break;
          }
          bool1 = true;
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          for (;;)
          {
            localIndexOutOfBoundsException.printStackTrace();
          }
        }
        i += 1;
        continue;
        i = k;
      }
    }
    label197:
    return bool2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject;
    int i;
    long l1;
    long l2;
    long l3;
    while ((paramMessage.what == 60) && (this.aaR))
    {
      this.cL.setBackgroundResource(2130844446);
      return true;
      if ((this.jdField_a_of_type_Slz != null) && (this.jdField_a_of_type_Slz.isShowing())) {
        this.jdField_a_of_type_Slz.dismiss();
      }
      this.jdField_a_of_type_Slz = new slz(this.app, this.mActivity, this.jdField_a_of_type_Apmp, this.sessionInfo.aTl);
      localObject = new int[2];
      this.cJ.getLocationOnScreen((int[])localObject);
      i = getTitleBarHeight();
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLocationInWindow(arrayOfInt);
      int k = arrayOfInt[1];
      int m = localObject[1];
      this.jdField_a_of_type_Slz.eF(i, k - m);
      this.jdField_a_of_type_Slz.show(paramMessage.arg1);
      continue;
      if ((this.jdField_a_of_type_Apat != null) && (this.jdField_a_of_type_Apat.aAM()))
      {
        localObject = this.jdField_a_of_type_Apat.a();
        if (((apmz)localObject).ee.get())
        {
          ((apmz)localObject).ee.set(false);
          continue;
          i = paramMessage.arg1;
          localObject = this.px;
          if (i == 0) {}
          for (i = 8;; i = 0)
          {
            ((ImageView)localObject).setVisibility(i);
            break;
          }
          localObject = (List)paramMessage.obj;
          if (localObject != null)
          {
            l1 = ((Long)((List)localObject).get(0)).longValue();
            l2 = ((Long)((List)localObject).get(1)).longValue();
            l3 = ((Long)((List)localObject).get(2)).longValue();
          }
        }
      }
    }
    for (;;)
    {
      long l4;
      long l5;
      try
      {
        l4 = Long.parseLong(this.sessionInfo.aTl);
        l5 = Long.parseLong(this.app.getCurrentUin());
        if (l4 != l1) {
          break label481;
        }
        if (l2 == l5) {
          break label621;
        }
        if (l3 != l5) {
          break label481;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.e(".troop.chat_pie_msg", 1, "MSG_TROOP_ADMIN_OPERATION_NOTIFY: groupUin error", localNumberFormatException);
      }
      if (i != 0)
      {
        localObject = (PlusPanel)this.jdField_a_of_type_Xru.B(8);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: will reload plusPanel, groupUin:", Long.valueOf(l1) });
          }
          ((PlusPanel)localObject).reload();
          break;
          break;
          label481:
          i = 0;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition match: should reload plusPanel, but mPlusPanel == null, groupUin:", Long.valueOf(l1) });
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.chat_pie_msg", 2, new Object[] { "MSG_TROOP_ADMIN_OPERATION_NOTIFY: condition not match: group:", Long.valueOf(l1), "/", Long.valueOf(l4), " uin1/uin2/current: ", Long.valueOf(l2), "/", Long.valueOf(l3), "/", Long.valueOf(l5) });
      break;
      return super.handleMessage(paramMessage);
      label621:
      i = 1;
    }
  }
  
  public Boolean i()
  {
    if (this.aaR) {
      return new Boolean(false);
    }
    return null;
  }
  
  public RelativeLayout j()
  {
    return this.gn;
  }
  
  public void k(Object paramObject)
  {
    wja.bcO = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int k = ((Integer)paramObject).intValue();
    if (k == this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm())
    {
      this.jdField_b_of_type_ComTencentWidgetXPanelContainer.aJS();
      return;
    }
    switch (k)
    {
    case 6: 
    case 7: 
    default: 
    case 3: 
    case 2: 
    case 4: 
    case 5: 
      for (;;)
      {
        DQ(k);
        super.k(paramObject);
        return;
        if (this.aaR)
        {
          anot.a(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_face", 0, 0, this.sessionInfo.aTl, "", "", "");
          continue;
          if (this.aaR) {
            anot.a(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_PTT", 0, 0, this.sessionInfo.aTl, "", "", "");
          }
          if (this.bkf)
          {
            new anov(this.app).a("dc00899").b("Grp_robot").c("send_msg").d("voice_icon_clk").a(0).a(new String[] { this.sessionInfo.aTl, this.aWO }).report();
            continue;
            if (this.aaR)
            {
              anot.a(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_pic", 0, 0, this.sessionInfo.aTl, "", "", "");
              continue;
              if (this.aaR) {
                anot.a(this.app, "P_CliOper", "Grp_anon", "", "anon_aio", "Clk_shoot", 0, 0, this.sessionInfo.aTl, "", "", "");
              }
            }
          }
        }
      }
    }
    if (!SV()) {
      anot.a(this.app, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_plusentry", 0, 0, this.sessionInfo.aTl, "", "", "");
    }
    if (this.jdField_a_of_type_Smx == null) {
      this.jdField_a_of_type_Smx = new smx(this);
    }
    smx localsmx = this.jdField_a_of_type_Smx;
    int m = TroopGiftPanel.byn;
    if (jof.a().dd(this.sessionInfo.aTl)) {}
    for (int i = 4;; i = 1)
    {
      localsmx.eG(m, i);
      aoxw.a(this.app).lJ(aoyb.aP(oN()));
      break;
    }
  }
  
  public List<ChatMessage> n(boolean paramBoolean)
  {
    List localList1 = super.n(paramBoolean);
    boolean bool = yjt.TK();
    int k = yjt.wO();
    int m = yjt.wP();
    paramBoolean = false;
    if (!this.blZ)
    {
      if (localList1.size() > 0)
      {
        this.JP = ((ChatMessage)localList1.get(localList1.size() - 1)).shmsgseq;
        this.JQ = ((ChatMessage)localList1.get(0)).shmsgseq;
      }
      paramBoolean = true;
      this.blZ = true;
    }
    if ((this.JQ == 0L) && (this.JP == 0L)) {}
    Object localObject1;
    Object localObject3;
    for (int i = 1;; i = 0)
    {
      if ((!bool) || (this.aSN) || (i != 0) || (k <= 1) || (localList1.size() < k)) {
        break label481;
      }
      localObject1 = null;
      int n = this.qT.size();
      localObject3 = localObject1;
      if (!this.blY) {
        break;
      }
      localObject3 = localObject1;
      if (n <= 0) {
        break;
      }
      localObject1 = new long[n];
      i = 0;
      for (;;)
      {
        localObject3 = localObject1;
        if (i >= n) {
          break;
        }
        localObject1[i] = ((Long)this.qT.get(i)).longValue();
        i += 1;
      }
    }
    for (;;)
    {
      List localList2;
      try
      {
        localList2 = yjt.a(this.app, localList1, k, this.JQ, this.JP, localObject3, paramBoolean);
        if ((!paramBoolean) || (m <= 15) || (localList2.size() <= 1)) {
          break label507;
        }
        localObject1 = null;
        i = 1;
        if (i < localList2.size())
        {
          localObject1 = (ChatMessage)localList2.get(i);
          if (yjt.A((ChatMessage)localObject1)) {
            continue;
          }
        }
        if ((!yjt.z((ChatMessage)localObject1)) || (localList2.size() >= 15)) {
          break label507;
        }
        yjt.log("find first msg is fold msg,then get more msg ", new Object[0]);
        localObject1 = this.app.b().a(this.sessionInfo.aTl, this.sessionInfo.cZ, this.JP - m - 1L);
        if (((List)localObject1).size() > 0)
        {
          this.JQ = ((ChatMessage)((List)localObject1).get(0)).shmsgseq;
          this.JP = ((ChatMessage)((List)localObject1).get(((List)localObject1).size() - 1)).shmsgseq;
        }
        localObject1 = yjt.a(this.app, (List)localObject1, k, this.JQ, this.JP, localObject3, false);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(this.TAG, 1, localThrowable, new Object[0]);
        localObject2 = localList1;
        continue;
      }
      return localObject1;
      i += 1;
      continue;
      label481:
      Object localObject2 = localList1;
      if (localList1.size() == 0)
      {
        chO();
        this.blZ = true;
        return localList1;
        label507:
        localObject2 = localList2;
      }
    }
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, new Object[] { "onPanelChanged updateAIOPanelTip. oldPanel=", Integer.valueOf(paramInt1), ", newPanel=", Integer.valueOf(paramInt2) });
    }
    aA(false);
    if ((paramInt1 == 0) && (paramInt2 != 0)) {
      chG();
    }
    if (this.jdField_a_of_type_Apgj != null) {
      this.jdField_a_of_type_Apgj.dZs();
    }
    if (paramInt1 == 35) {
      if (paramInt2 != 1) {
        break label117;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.yQ(bool);
      if (paramInt2 == 35) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioConfessConfessPanel.onShow();
      }
      super.n(paramInt1, paramInt2);
      return;
      label117:
      bool = false;
    }
  }
  
  public void o(int paramInt1, int paramInt2)
  {
    super.o(paramInt1, paramInt2);
    if (paramInt2 == 8) {
      if (!this.aaR) {}
    }
    for (;;)
    {
      if ((paramInt2 == 2) && (this.aaR)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.Cr(0);
      }
      return;
      if (!this.aaR) {}
    }
  }
  
  public boolean onBackEvent()
  {
    if (((wtj)a(34)).onBackEvent()) {
      return true;
    }
    if (((wxc)a(43)).onBackEvent()) {
      return true;
    }
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.uninit();
    }
    if (apot.a().isPlaying()) {
      apot.a().stop();
    }
    if (this.jdField_a_of_type_Yjm != null) {
      this.jdField_a_of_type_Yjm.caS();
    }
    if (this.jdField_a_of_type_Apgj != null) {
      this.jdField_a_of_type_Apgj.dZr();
    }
    if (this.bez) {
      chJ();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367817) && (aA(true))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      super.onClick(paramView);
      if (paramView.getId() == 2131372043)
      {
        if ((this.jdField_a_of_type_Yjm != null) && (this.jdField_a_of_type_Yjm.isShowing())) {
          this.jdField_a_of_type_Yjh.ciA();
        }
      }
      else if (paramView.getId() == 2131372041) {
        chG();
      } else if ((paramView.getId() == 2131369594) && (this.px != null) && (this.px.getVisibility() == 0)) {
        apwh.a(this.px).p(this.app, this.sessionInfo);
      }
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    ((wxc)a(43)).ccX();
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_Apat != null) {
      this.jdField_a_of_type_Apat.a().at(paramInt, 500L);
    }
    if (paramInt == 2) {
      chG();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "scrollState = " + paramInt);
    }
    if (paramInt != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.isScrolling = bool;
      paramAbsListView = this.su.iterator();
      while (paramAbsListView.hasNext()) {
        ((b)paramAbsListView.next()).zv(this.isScrolling);
      }
    }
    if ((paramInt == 0) && (this.aXo != null))
    {
      paramAbsListView = ((acms)this.app.getBusinessHandler(20)).a();
      this.aXo = null;
      paramAbsListView.TG(this.sessionInfo.aTl);
    }
  }
  
  public void onShow()
  {
    cfv();
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    TroopInfo localTroopInfo = localTroopManager.b(this.sessionInfo.aTl);
    if ((localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())))
    {
      if (localTroopManager.ab(this.sessionInfo.aTl) - NetConnInfoCenter.getServerTime() < 259200L) {
        V(0L, 0L);
      }
      if (aerd.c().mIsEnable)
      {
        localObject = (acle)this.app.getBusinessHandler(13);
        if (!localTroopManager.kC(this.sessionInfo.aTl)) {
          break label527;
        }
        ((acle)localObject).hN(Long.parseLong(this.sessionInfo.aTl));
        QLog.e("vip_pretty.", 1, "get the troop expired info from server");
      }
    }
    if ((localTroopInfo != null) && (QLog.isColorLevel())) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "aio onShow:" + localTroopInfo.troopuin + ", sysFlag=" + localTroopInfo.cGroupRankSysFlag + ", userFlag=" + localTroopInfo.cGroupRankUserFlag);
    }
    super.onShow();
    if (this.blS == true)
    {
      ThreadManager.post(new TroopChatPie.7(this), 1, null, true);
      this.blS = false;
    }
    Object localObject = this.mActivity.getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).containsKey("forward_type")) && (this.sessionInfo.aTl != null) && (this.sessionInfo.aTl.equals(((Bundle)localObject).getString("uin")))) {}
    for (boolean bool = true;; bool = false)
    {
      ThreadManager.post(new TroopChatPie.8(this, bool), 8, null, true);
      if ((!this.bmg) && (localTroopManager.a.aMd) && (localTroopInfo != null) && (localTroopInfo.isTroopOwner(this.app.getCurrentAccountUin())))
      {
        int i = localTroopManager.cu(this.sessionInfo.aTl);
        if ((i < 3) && (localTroopInfo.wMemberMax < 2000) && (localTroopInfo.wMemberNum >= 500))
        {
          if (this.jdField_a_of_type_Yjp == null)
          {
            this.jdField_a_of_type_Yjp = new yjp(this.app, this.mActivity, this.jdField_a_of_type_Yjh);
            this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yjp);
          }
          this.jdField_a_of_type_Yjp.yJ(this.sessionInfo.aTl);
          if (this.jdField_a_of_type_Yjh.a(this.jdField_a_of_type_Yjp, new Object[0]))
          {
            this.bmg = true;
            localTroopManager.dM(this.sessionInfo.aTl, i + 1);
            anot.a(this.app, "dc00899", "Grp_up", "", "Grp_AIO", "exp", 0, 0, this.sessionInfo.aTl, "", "", "");
          }
        }
      }
      return;
      label527:
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.", 1, "get the troop expired info from local");
      }
      TroopManager.a(localTroopManager.a(this.sessionInfo.aTl), this.app, this.sessionInfo.aTl, this.mContext, this, this.jdField_a_of_type_Yjh);
      break;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (BaseChatpieHelper.a(this.jdField_b_of_type_ComTencentWidgetPatchedButton, paramCharSequence, this.sessionInfo.cZ))
    {
      this.sessionInfo.beA = true;
      DP(1);
    }
    label292:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, " onTextChanged:  start=" + paramInt1 + " before=" + paramInt2 + " count=" + paramInt3);
          }
        } while ((this.sessionInfo.cZ != 1) || (this.sessionInfo.aTl == null) || (this.sessionInfo.aTl.length() == 0));
        if ((paramInt3 != 1) || ((paramCharSequence.charAt(paramInt1) != '$') && (paramCharSequence.charAt(paramInt1) != 65509) && (paramCharSequence.charAt(paramInt1) != '¥') && (paramCharSequence.charAt(paramInt1) != 65284)) || (this.aSr) || (((wwn)a(27)).bgi)) {
          break;
        }
      } while (TroopInfo.isQidianPrivateTroop(this.app, this.sessionInfo.aTl));
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= paramCharSequence.length()) {
          break label292;
        }
        if ((paramInt2 != paramInt1) && ((paramCharSequence.charAt(paramInt2) == '$') || (paramCharSequence.charAt(paramInt2) == 65509) || (paramCharSequence.charAt(paramInt2) == '¥') || (paramCharSequence.charAt(paramInt2) == 65284))) {
          break;
        }
        paramInt2 += 1;
      }
      paramCharSequence = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
    } while ((paramCharSequence == null) || (!TroopInfo.hasPayPrivilege(paramCharSequence.troopPrivilegeFlag, 32)));
    if (paramCharSequence.isTroopOwner(this.app.getCurrentAccountUin())) {
      paramInt1 = 0;
    }
    for (;;)
    {
      anot.a(this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "sign", 0, 0, paramCharSequence.troopuin + "", paramInt1 + "", "", "");
      aptj.a(this.mActivity, paramCharSequence.troopuin, "input", this.app);
      return;
      if (paramCharSequence.isAdmin()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
    }
    if ((!this.aSr) && (!((wwn)a(27)).bgi)) {
      ((wtj)a(34)).onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    chF();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Smx != null) && (this.jdField_a_of_type_Smx.isShow()))
    {
      this.jdField_a_of_type_Smx.bzx();
      abrb.b(this.app, "troop_gift_panel", false);
    }
    if ((paramView.getId() == 2131370537) && (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.stop();
    }
    return super.onTouch(paramView, paramMotionEvent);
  }
  
  public ImageView r()
  {
    return this.ps;
  }
  
  public void send()
  {
    if (aA(true)) {
      return;
    }
    aptw localaptw = (aptw)this.app.getManager(203);
    boolean bool2 = localaptw.aBy();
    Object localObject = localaptw.crp;
    String str1 = localaptw.crq;
    this.aCV = true;
    ArrayList localArrayList = new ArrayList();
    String str2 = appb.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    int i = 0;
    label198:
    boolean bool3;
    if (i < localArrayList.size())
    {
      MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = (MessageForText.AtTroopMemberInfo)localArrayList.get(i);
      if (localaptw.cR(localAtTroopMemberInfo.uin))
      {
        localObject = "" + localAtTroopMemberInfo.uin;
        str1 = aqgv.h(this.app, this.sessionInfo.aTl, (String)localObject);
        if ((bool2) || (localaptw.x(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.aTl)))
        {
          bool1 = true;
          bool3 = localaptw.y(str2, "" + localAtTroopMemberInfo.uin, this.sessionInfo.aTl);
          bool2 = bool1;
        }
      }
    }
    for (boolean bool1 = bool3;; bool1 = false)
    {
      super.send();
      if ((bool2) && (!bool1))
      {
        localObject = appb.a(this.app, this.mContext, this.sessionInfo.aTl, (String)localObject, str1, false, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, true);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
        b(localaptw.crp, localaptw.crq, true, 0);
      }
      for (;;)
      {
        this.aCV = false;
        anpc.report("tim_msg_tab_group_aio_send_msg");
        return;
        bool1 = false;
        break label198;
        i += 1;
        break;
        xqh.a(this.app, str2, localArrayList, this.sessionInfo.aTl);
        if ((str2 == null) || (str2.length() <= 3478)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.bkf)
        {
          zT(false);
          localObject = (wxk)a(23);
          if (localObject != null) {
            ((wxk)localObject).l(false);
          }
        }
        this.bkg = false;
        localaptw.ebO();
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    super.update(paramObservable, paramObject);
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "update");
    }
    if (paramObject == null) {}
    label197:
    label469:
    for (;;)
    {
      return;
      if ((paramObject instanceof apto))
      {
        paramObservable = (apto)paramObject;
        if (paramObservable.action == 1)
        {
          this.blY = paramObservable.cSm;
          this.qT.add(Long.valueOf(paramObservable.asb));
          fF(paramObservable.asb);
          refresh(131088);
          return;
        }
      }
      if ((paramObject instanceof MessageRecord)) {
        if ((paramObject instanceof ChatMessage))
        {
          paramObservable = (MessageRecord)paramObject;
          this.JO = paramObservable.shmsgseq;
          if (paramObservable.isSendFromLocal()) {
            break label289;
          }
          if ((this.sessionInfo.aTl.equals(paramObservable.frienduin)) && ((this.sessionInfo.cZ == paramObservable.istroop) || ((top.fv(this.sessionInfo.cZ)) && (top.fv(paramObservable.istroop)))) && (this.mActivity.isResume()) && ((paramObject instanceof MessageForTroopEffectPic))) {
            wi(false);
          }
          wxf localwxf = (wxf)a(28);
          if (localwxf != null) {
            localwxf.K(paramObservable);
          }
        }
      }
      for (;;)
      {
        if (!(paramObject instanceof MessageForText)) {
          break label469;
        }
        paramObservable = (MessageForText)paramObject;
        if (!paramObservable.frienduin.equals(this.sessionInfo.aTl)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AioVipKeywordHelper", 4, "detectKeyword in TroopChatPie.update()");
        }
        aquv.a().a(this.app, this.sessionInfo, paramObservable, paramObservable.msg, this.mContext, paramObservable.isSend());
        return;
        if ((!((acms)this.app.getBusinessHandler(20)).a().qL("highFreqInteract")) || (this.blU)) {
          break label197;
        }
        this.blU = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable == null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable = new TroopBatchAddFriendMgr.CheckHighFreqInteractionRunnable(this, this.app);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable.stop(false);
        ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr$CheckHighFreqInteractionRunnable);
        break label197;
        if ((paramObject instanceof apab.a)) {
          aD(paramObject);
        } else if ((paramObject instanceof Integer)) {
          switch (((Integer)paramObject).intValue())
          {
          case 123321: 
          default: 
            break;
          case 123322: 
            if ((this.jdField_a_of_type_Apmp != null) && (this.jdField_a_of_type_Apmp.aBl())) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.kA(1, this.jdField_a_of_type_Apmp.Lx() / 2);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.YM(1);
            }
            break;
          }
        }
      }
    }
  }
  
  public void vW(boolean paramBoolean)
  {
    if (apot.a().isPlaying()) {
      apot.a().stop();
    }
    if (this.bez) {
      chJ();
    }
    super.vW(paramBoolean);
  }
  
  public void wh(boolean paramBoolean)
  {
    if (aqmj.aB(this.mContext, this.app.getCurrentAccountUin()))
    {
      aj(paramBoolean, TroopGiftPanel.byo);
      aqmj.s(this.mContext, this.app.getCurrentAccountUin(), false);
      return;
    }
    aj(paramBoolean, TroopGiftPanel.byn);
  }
  
  public void zS(boolean paramBoolean)
  {
    Object localObject = (LinearLayout.LayoutParams)this.pv.getLayoutParams();
    this.pv.setScaleType(ImageView.ScaleType.CENTER);
    ((LinearLayout.LayoutParams)localObject).width = rpq.dip2px(this.mContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).height = rpq.dip2px(this.mContext, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = 0;
    try
    {
      localObject = this.mContext.getResources();
      int i;
      if (paramBoolean)
      {
        i = 2130844679;
        localObject = ((Resources)localObject).getDrawable(i);
        if ((!anlm.ayn()) && (!"2105".equals(ThemeUtil.curThemeId))) {
          break label185;
        }
        ((Drawable)localObject).setColorFilter(this.mActivity.getResources().getColor(2131167301), PorterDuff.Mode.MULTIPLY);
        label114:
        if (!paramBoolean) {
          break label217;
        }
        Drawable localDrawable = this.pv.getDrawable();
        if ((localDrawable instanceof AnimationDrawable)) {
          ((AnimationDrawable)localDrawable).stop();
        }
        ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.mContext, 10.0F), rpq.dip2px(this.mContext, 10.0F));
        this.pv.setImageDrawable((Drawable)localObject);
      }
      label185:
      label217:
      do
      {
        return;
        i = 2130844686;
        break;
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, null))
        {
          ((Drawable)localObject).clearColorFilter();
          break label114;
        }
        ((Drawable)localObject).setColorFilter(-9136456, PorterDuff.Mode.MULTIPLY);
        break label114;
        if ((Build.VERSION.SDK_INT < 21) || (this.blX))
        {
          ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.mContext, 10.0F), rpq.dip2px(this.mContext, 10.0F));
          this.pv.setImageDrawable((Drawable)localObject);
          return;
        }
        if (this.bXX == 2)
        {
          localObject = (AnimationDrawable)this.mContext.getResources().getDrawable(2130844685);
          ((AnimationDrawable)localObject).setOneShot(true);
          ((AnimationDrawable)localObject).setBounds(0, 0, rpq.dip2px(this.mContext, 10.0F), rpq.dip2px(this.mContext, 10.0F));
          this.pv.setImageDrawable((Drawable)localObject);
          ((AnimationDrawable)localObject).start();
          this.blX = true;
          return;
        }
        if (this.bXX == 3)
        {
          localObject = this.mContext.getResources().getDrawable(2130844686);
          ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.mContext, 10.0F), rpq.dip2px(this.mContext, 10.0F));
          this.pv.setImageDrawable((Drawable)localObject);
          return;
        }
      } while (this.bXX != 4);
      localObject = this.mContext.getResources().getDrawable(2130844686);
      ((Drawable)localObject).setBounds(0, 0, rpq.dip2px(this.mContext, 10.0F), rpq.dip2px(this.mContext, 10.0F));
      paramBoolean = ((wxc)a(43)).Sm();
      this.pv.setImageDrawable((Drawable)localObject);
      if (paramBoolean)
      {
        this.pv.setVisibility(8);
        return;
      }
      this.pv.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void zV(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.isStop()) && (!this.uiHandler.hasMessages(16711686)))
    {
      this.uiHandler.removeMessages(16711688);
      this.uiHandler.removeMessages(16711686);
      this.uiHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.fateOfRecorder = paramInt;
      if (!this.bmb) {
        break label135;
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder.stop();
      aqge.m(this.mActivity.getApplicationContext(), false);
      aA(true);
    }
    label135:
    while (this.jdField_b_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      return;
    }
    Message localMessage = this.uiHandler.obtainMessage(16711686);
    this.uiHandler.sendMessageDelayed(localMessage, 200L);
  }
  
  public void zZ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "troopUin : " + this.sessionInfo.aTl);
    }
    Object localObject3 = null;
    try
    {
      localObject1 = this.app.a().a(Long.valueOf(this.sessionInfo.aTl).longValue(), 1);
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "avType : " + ((AVNotifyCenter.i)localObject1).aqB);
        }
        if (((AVNotifyCenter.i)localObject1).aqB != 2) {
          break label881;
        }
        if (((AVNotifyCenter.i)localObject1).isOffLine)
        {
          anot.a(null, "CliOper", "", "", "0X80066C2", "0X80066C2", 0, 0, "", "", "", "");
          this.app.a().x(Long.valueOf(this.sessionInfo.aTl).longValue(), 1);
        }
      }
      else
      {
        cgh();
        if (this.hp != null) {
          break label993;
        }
        this.hp = new LinearLayout(this.mContext);
        this.j = new TroopChatPie.3(this, this.mContext);
        this.j.setVerticalFadingEdgeEnabled(false);
        this.j.setScrollbarFadingEnabled(false);
        this.j.setVerticalScrollBarEnabled(false);
        this.bYK = (this.fs.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        localObject1 = new RelativeLayout.LayoutParams(-1, this.bYK);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = aqcx.dip2px(this.mContext, 50.0F);
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
        this.fs.addView(this.j, 0, (ViewGroup.LayoutParams)localObject1);
        this.j.addView(this.hp, -1, this.bYK);
        localObject1 = (apdr)this.app.getManager(231);
        this.jdField_a_of_type_Apdj = a();
        ((apdr)localObject1).dTG = 0;
        ((apdr)localObject1).dTE = 0;
        ((apdr)localObject1).dTF = 0;
        ((apdr)localObject1).dTH = 0;
        if (!anlm.ayn()) {}
        localObject1 = ((TroopManager)this.app.getManager(52)).b(this.sessionInfo.aTl);
        if (this.jdField_a_of_type_Apgj == null) {
          this.jdField_a_of_type_Apgj = ((apgj)this.app.getManager(289));
        }
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Apgj.a(((TroopInfo)localObject1).dwGroupClassExt, true, this, this.sessionInfo.aTl);
          this.bma = this.app.getCurrentAccountUin().equalsIgnoreCase(((TroopInfo)localObject1).troopowneruin);
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "doOnPause, isTroopOwner =" + this.bma + ",troopInfo = " + localObject1);
        }
        if ((aehj.E(this.app, this.sessionInfo.aTl)) && (this.aO == null)) {
          this.aO = new yfd(this);
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        localObject1 = new IntentFilter();
        ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_CONFESS_START_EVENT");
        this.mContext.registerReceiver(this.aO, (IntentFilter)localObject1);
        if (TroopInfo.isHomeworkTroop(this.app, this.sessionInfo.aTl))
        {
          new apke(this.mContext, "3171", "libWXVoice.so", "WXVoice").execute();
          if (this.an == null) {
            this.an = new yff(this);
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            Object localObject1 = new IntentFilter();
            ((IntentFilter)localObject1).addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            this.mContext.registerReceiver(this.an, (IntentFilter)localObject1, "com.tencent.tim.msg.permission.pushnotify", null);
            apml.aT(this.app, this.sessionInfo.aTl);
            localObject1 = (aeog)aeif.a().o(553);
            if ((localObject1 != null) && (!((aeog)localObject1).bVm))
            {
              this.ps.setVisibility(8);
              this.ps.setOnClickListener(null);
            }
            chI();
            localObject1 = this.mActivity.getIntent();
            this.bez = ((Intent)localObject1).getBooleanExtra("open_chat_from_group_rec_confess", false);
            if (this.bez)
            {
              cw((Intent)localObject1);
              yy(this.sessionInfo.aTl);
            }
            this.sessionInfo.bez = this.bez;
            zR(false);
            super.zZ(paramInt);
            return;
            localException1 = localException1;
            Object localObject2 = localObject3;
            label993:
            if (QLog.isColorLevel())
            {
              QLog.d(this.TAG, 2, "onShowFirst : invalid uin!");
              localObject2 = localObject3;
              continue;
              anot.a(null, "CliOper", "", "", "0X80066BF", "0X80066BF", 0, 0, "", "", "", "");
              continue;
              label881:
              if (((AVNotifyCenter.i)localObject2).aqB == 10)
              {
                if (((AVNotifyCenter.i)localObject2).isOffLine) {
                  anot.a(null, "CliOper", "", "", "0X80066C1", "0X80066C1", 0, 0, "", "", "", "");
                }
                for (;;)
                {
                  this.app.a().x(Long.valueOf(this.sessionInfo.aTl).longValue(), 1);
                  break;
                  anot.a(null, "CliOper", "", "", "0X80066BE", "0X80066BE", 0, 0, "", "", "", "");
                }
                this.bYK = (this.fs.getHeight() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
                localObject2 = (RelativeLayout.LayoutParams)this.j.getLayoutParams();
                ((RelativeLayout.LayoutParams)localObject2).height = this.bYK;
                ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() + this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight());
                this.j.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                this.j.removeAllViews();
                this.j.addView(this.hp, -1, this.bYK);
              }
            }
          }
          localException2 = localException2;
          QLog.e(this.TAG, 1, "register mConfessReceiver receiver exception.");
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            QLog.e(this.TAG, 1, "register homework receiver exception.");
          }
        }
      }
    }
  }
  
  public void zh(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.app, paramBoolean, this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.TV(paramBoolean);
    }
    ((www)a(29)).zh(paramBoolean);
    this.aaR = paramBoolean;
    jof.a().l(paramBoolean, this.sessionInfo.aTl);
    if ((paramBoolean) || (abrb.S(this.app))) {
      abrb.b(this.app, "troop_anonyous", paramBoolean);
    }
    Object localObject;
    if (this.xC == null)
    {
      this.xC = new View(this.mActivity);
      this.xC.setBackgroundColor(Color.rgb(19, 19, 21));
      this.xC.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.xC, (ViewGroup.LayoutParams)localObject);
    }
    if (this.xF == null)
    {
      this.xF = new View(this.mActivity);
      this.xF.setBackgroundResource(2130844452);
      this.xF.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.xF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.addView(this.xF, 0);
    }
    if (this.xE == null)
    {
      this.xE = new View(this.mActivity);
      this.xE.setBackgroundResource(2130844452);
      this.xE.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.xE.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.fs.addView(this.xE, 0);
    }
    if (this.xD == null)
    {
      this.xD = new View(this.mActivity);
      this.xD.setBackgroundColor(Color.rgb(19, 19, 21));
      this.xD.setVisibility(8);
      localObject = new RelativeLayout.LayoutParams(-1, 1);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369277);
      this.fs.addView(this.xD, (ViewGroup.LayoutParams)localObject);
    }
    if (this.jdField_a_of_type_Apmp != null) {
      this.jdField_a_of_type_Apmp.RU(paramBoolean);
    }
    if (paramBoolean)
    {
      paramBoolean = ((aiqk)a(33)).apu();
      localObject = (wxc)a(43);
      boolean bool = ((wxc)localObject).Sl();
      if ((!paramBoolean) && (!bool)) {
        DO(1);
      }
      this.pz.setVisibility(8);
      if ((ImmersiveUtils.isSupporImmersive() != 0) && (ImmersiveUtils.aJW()))
      {
        ImmersiveUtils.setStatusTextColor(false, this.mActivity.getWindow());
        ay(-16777216, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground().setVisible(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378466).setVisibility(8);
        wja.S(this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, 2130844452);
        this.mTitleText.setTextColor(jof.aCs);
        this.Ct.setTextColor(jof.aCs);
        if (this.Cr.getVisibility() != 0) {
          break label895;
        }
        this.Cr.setBackgroundResource(2130844472);
        this.Cr.setTextColor(jof.aCs);
        this.tU.setTextColor(jof.aCs);
        label586:
        if (this.Cu.getVisibility() == 0) {
          this.E = this.Cu.getText();
        }
        chG();
        this.cJ.setOnClickListener(null);
        this.cK.setOnClickListener(null);
        this.Cu.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.Cu.setText(this.mActivity.getResources().getString(2131690308) + jof.a().a(this.sessionInfo.aTl).nickName);
        this.Cu.setTextColor(jof.aCs);
        wja.a(this.pp, null);
        vU(true);
        PlusPanel localPlusPanel = (PlusPanel)this.jdField_a_of_type_Xru.B(8);
        if (localPlusPanel != null)
        {
          localPlusPanel.b.isAnonymous = true;
          localPlusPanel.reload();
        }
        if (this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.HW(true);
        }
        this.xD.setVisibility(0);
        this.jdField_b_of_type_Jof$d = new yeu(this);
        jof.a().a(this.jdField_b_of_type_Jof$d);
        this.jdField_a_of_type_Yjh.ciA();
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setHint(2131698284);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
        {
          wja.S(this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, 2130844452);
          if (this.jdField_b_of_type_ComTencentWidgetXPanelContainer.vm() == 8) {
            this.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          }
        }
        ((wxc)localObject).ccW();
      }
    }
    for (;;)
    {
      bGZ();
      bGT();
      this.jdField_a_of_type_Wki.notifyDataSetChanged();
      return;
      ay(-16777216, false);
      break;
      label895:
      if (this.pq.getVisibility() != 0) {
        break label586;
      }
      this.pq.setBackgroundResource(2130844472);
      this.pq.setPadding(0, 0, 0, 0);
      this.Cs.setTextColor(jof.aCs);
      this.Cs.setBackgroundDrawable(this.mActivity.getResources().getDrawable(2130838049));
      break label586;
      chz();
    }
  }
  
  public static class CheckGlamourPicturesRunnable
    implements Runnable
  {
    WeakReference<Context> ah;
    
    public CheckGlamourPicturesRunnable(Context paramContext)
    {
      this.ah = new WeakReference(paramContext);
    }
    
    public void run()
    {
      Context localContext = (Context)this.ah.get();
      if (localContext == null) {
        return;
      }
      aptm.bF(localContext);
    }
  }
  
  class a
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    private a() {}
    
    public void onGlobalLayout()
    {
      if (Build.VERSION.SDK_INT < 16) {
        TroopChatPie.this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
      }
      for (;;)
      {
        if (!TroopChatPie.this.blT)
        {
          TroopChatPie.this.blT = true;
          ThreadManager.getSubThreadHandler().postDelayed(new TroopChatPie.InputOnGlobalLayoutListener.1(this), 1500L);
        }
        return;
        TroopChatPie.this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void zv(boolean paramBoolean);
  }
  
  static class c
    implements apsd.b
  {
    public String aXq;
    
    public c(String paramString)
    {
      this.aXq = paramString;
    }
    
    public long er()
    {
      try
      {
        long l = Long.parseLong(this.aXq);
        return l;
      }
      catch (Exception localException) {}
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie
 * JD-Core Version:    0.7.0.1
 */