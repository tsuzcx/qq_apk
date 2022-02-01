package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCardTaf.SSummaryCardRsp;
import accn;
import acfd;
import acff;
import acfp;
import acgr;
import acha;
import acle;
import aclh;
import acms;
import acnd;
import adyp;
import adzx;
import aeqy;
import aerv;
import aerw;
import aesd;
import aese;
import afcy;
import afsg;
import afsi;
import afsr;
import afxv;
import afxx;
import afyk;
import aher;
import ahes;
import ahmm;
import ahxs;
import ahyh;
import ahyj;
import aizg;
import ajdo;
import ajqh;
import ajqp;
import akka;
import aklk;
import akwl;
import albb;
import albg;
import albz;
import alcb;
import alcn;
import alco;
import alcs;
import alhr;
import alkd;
import alkm;
import alkt;
import alkw;
import altq;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LightingColorFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import anlm;
import anot;
import anpc;
import anpf;
import anwa;
import aqae;
import aqaf;
import aqag;
import aqcu;
import aqep;
import aqfp;
import aqft;
import aqgv;
import aqha;
import aqhq;
import aqhu;
import aqiw;
import aqju;
import aqlt;
import aqmp;
import aqmr;
import aqmv;
import aqnl.a;
import aqqj;
import aqrc;
import aqrg;
import aqrg.a;
import aqrw;
import aqrw.a;
import aqsj;
import aquz;
import aqva;
import aqvl;
import argj;
import arho;
import arho.a;
import arhz;
import asgx;
import aurh;
import aurr;
import auru;
import ausj;
import auss;
import auvv;
import avpw;
import avpw.d;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.medalwall.MedalGuideView;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelBoard.a;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.profile.view.ProfilePhotoView;
import com.tencent.mobileqq.profile.view.ProfileQVipDiyView;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.mobileqq.profile.view.ShakeImageView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.mobileqq.webprocess.WebProcessManager.a;
import com.tencent.mobileqq.widget.PerfRelativeLayout;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qapmsdk.QAPM;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView.d;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.XListView.b;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.model.CoverCacheData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import jqs;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import pmi;
import srn;
import swe;
import txf;
import uym;
import uyp;
import uys;
import uyt;
import uyu;
import uyv;
import uyw;
import uyx;
import uyy;
import uyz;
import uza;
import uzb;
import uzc;
import uzd;
import uze;
import uzf;
import uzg;
import uzh;
import uzi;
import uzm;
import uzn;
import uzu;
import uzv;
import uzx;
import uzy;
import uzz;
import vaa;
import vab;
import vac;
import vad;
import vae;
import vaf;
import vag;
import vah;
import vai;
import vaj;
import vak;
import val;
import vam;
import van;
import vao;
import vap;
import vaq;
import var;
import vas;
import vbv;
import vbv.a;
import wja;
import zsi;

public class FriendProfileCardActivity
  extends ProfileActivity
  implements TopGestureLayout.OnGestureListener, PersonalityLabelBoard.a, XListView.b, IEventReceiver, Observer, vbv.a
{
  static long Ge;
  public static long Gf = 2000L;
  public static String aNi;
  public static String aNj;
  public static AtomicInteger az;
  private static final Object bM = new Object();
  public static long lQQMasterLogindays;
  Dialog C;
  public Intent C;
  public TextView Dq;
  private TextView Dr;
  protected Intent E = new Intent();
  long FW = 0L;
  public long FX;
  public long FY;
  public long FZ;
  public arhz G;
  private long Ga = -1L;
  long Gb;
  long Gc;
  long Gd;
  long Gg;
  private arhz H;
  private Dialog O;
  private Dialog P;
  public int WAIT_TIME = 30000;
  ahmm jdField_a_of_type_Ahmm = new val(this);
  ahyh jdField_a_of_type_Ahyh = new ahyh("qzone_friendprofile", "com.tencent.mobileqq:qzone", QzonePluginProxyActivity.Gg());
  akwl jdField_a_of_type_Akwl = new uyt(this);
  albg jdField_a_of_type_Albg;
  alcb jdField_a_of_type_Alcb = new uym(this);
  public alcn a;
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new vae(this);
  public aqmv a;
  private aqrw.a jdField_a_of_type_Aqrw$a = new uzu(this);
  public argj a;
  private arho.a jdField_a_of_type_Arho$a = new vaq(this);
  public arho a;
  public ColorScreenLoader a;
  private b jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$b;
  public ProfileActivity.CardContactInfo a;
  private FriendCardApolloViewController jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController;
  public ProfileShoppingPhotoInfo a;
  public DiyTextView a;
  public ProfileHeaderView a;
  public ShakeImageView a;
  public SingleTouchLayout a;
  public ProfileCardMoreInfoView a;
  public BusinessInfoCheckUpdate.AppInfo a;
  ListView.d jdField_a_of_type_ComTencentWidgetListView$d = new vam(this);
  public PullToZoomHeaderListView a;
  private srn jdField_a_of_type_Srn;
  public vbv a;
  protected zsi a;
  BroadcastReceiver aB = new uzf(this);
  protected boolean aEN;
  public String aNc = "";
  private String aNd;
  public String aNe;
  public String aNf;
  public String aNg;
  public String aNh = "is_binding_shop";
  protected String aNk = "";
  String aNl = null;
  boolean aRf = false;
  private Rect aT;
  public FrameLayout aT;
  private boolean aWA;
  public boolean aWB = false;
  public boolean aWC;
  boolean aWm = false;
  public boolean aWn;
  public boolean aWo = true;
  public boolean aWp;
  private boolean aWq;
  protected boolean aWr;
  boolean aWs = false;
  boolean aWt;
  private boolean aWu;
  private boolean aWv;
  private boolean aWw;
  public boolean aWx;
  public boolean aWy;
  public boolean aWz;
  private AtomicInteger ay = new AtomicInteger(0);
  accn jdField_b_of_type_Accn = new uys(this);
  protected acnd b;
  afsr jdField_b_of_type_Afsr = new uyy(this);
  View.OnLongClickListener jdField_b_of_type_AndroidViewView$OnLongClickListener = new uzi(this);
  public auru b;
  public ShakeImageView b;
  VasQuickUpdateManager.CallBacker jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new vad(this);
  public swe b;
  public int bFB;
  private int bGU;
  private int bGV;
  private int bGW;
  public int bGX;
  public int bGY = 0;
  public int bGZ;
  public int bHa = -1;
  int bHb = 0;
  private Handler bL;
  byte bReqMedalWallInfo;
  public int bdV;
  public ArrayList<Integer> bgtype;
  public AtomicBoolean bv = new AtomicBoolean(false);
  private AtomicBoolean bw = new AtomicBoolean(true);
  private AtomicBoolean bx = new AtomicBoolean(false);
  acfd jdField_c_of_type_Acfd = new uyu(this);
  private aclh jdField_c_of_type_Aclh = new uzv(this);
  private afsr jdField_c_of_type_Afsr;
  aklk jdField_c_of_type_Aklk = new uyv(this);
  public ArrayDeque<Message> c;
  public ViewGroup cT;
  accn cardObserver = new uyp(this);
  public TextView centerView;
  public String[] cm;
  Handler.Callback d;
  public DiniFlyAnimationView d;
  private Drawable dB;
  Runnable dQ = new FriendProfileCardActivity.9(this);
  public Bitmap dl;
  public Bitmap dm;
  Bitmap dn;
  public ahyj e = new ahyj("profile_card", "com.tencent.mobileqq:tool");
  public TextView er;
  public auru f;
  public int[] fp;
  public ImmersiveTitleBar2 g;
  RelativeLayout gD = null;
  public LinearLayout ga;
  AbsListView.e h = new van(this);
  private AlphaAnimation l;
  public TextView leftView;
  private AlphaAnimation m;
  public RedTouch m;
  public ausj mActionSheet;
  public View mContentView;
  public Runnable mDismissRunnable = new FriendProfileCardActivity.48(this);
  public int mFollowType;
  protected List<Subscriber> mG;
  View.OnClickListener mOnClickListener = new uzn(this);
  public int mScrollState = 0;
  private View mTitleBar;
  public View mask;
  public RedTouch n;
  private Vector<Drawable> o = new Vector();
  public ImageView pX;
  public ImageView pY;
  public ImageView pZ;
  Animation.AnimationListener q = new vah(this);
  public boolean qC = false;
  protected boolean rF;
  public View root;
  View sD;
  public View sE;
  View sF;
  private volatile long uA = -1L;
  public DialogInterface.OnClickListener v = new vaj(this);
  public DialogInterface.OnClickListener w = new vak(this);
  public Uri x;
  protected aqju z;
  
  static
  {
    aNi = "https://office.qq.com";
    aNj = "https://www.qq.com";
    az = new AtomicInteger(0);
  }
  
  public FriendProfileCardActivity()
  {
    this.jdField_a_of_type_Alcn = new alcn();
    this.jdField_c_of_type_JavaUtilArrayDeque = new ArrayDeque();
    this.jdField_b_of_type_Acnd = new uzm(this);
    this.jdField_d_of_type_AndroidOsHandler$Callback = new vaf(this);
    this.jdField_b_of_type_Swe = null;
  }
  
  private void AR(int paramInt)
  {
    if ((paramInt != 0) || (this.jdField_a_of_type_Alcn.e.pa == 33) || (this.centerView == null)) {}
    while (PG()) {
      return;
    }
    if (this.jdField_aT_of_type_AndroidGraphicsRect == null) {
      this.jdField_aT_of_type_AndroidGraphicsRect = new Rect();
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.getChildAt(0);
    if (localObject1 != null) {
      ((View)localObject1).getLocalVisibleRect(this.jdField_aT_of_type_AndroidGraphicsRect);
    }
    paramInt = this.jdField_aT_of_type_AndroidGraphicsRect.top;
    int i = this.centerView.getVisibility();
    Object localObject2 = null;
    if ((paramInt >= 0) && (paramInt > this.bGW) && (paramInt >= this.bGV) && (i == 4)) {
      localObject1 = this.l;
    }
    for (;;)
    {
      if ((localObject1 != null) && (localObject1 != this.centerView.getAnimation()))
      {
        ((Animation)localObject1).reset();
        this.centerView.startAnimation((Animation)localObject1);
        this.g.startAnimation((Animation)localObject1);
      }
      this.bGW = paramInt;
      return;
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.bGW)
        {
          localObject1 = localObject2;
          if (paramInt <= this.bGV)
          {
            localObject1 = localObject2;
            if (i == 0) {
              localObject1 = this.jdField_m_of_type_AndroidViewAnimationAlphaAnimation;
            }
          }
        }
      }
    }
  }
  
  private boolean PD()
  {
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      Object localObject = (TextView)this.root.findViewById(2131373631);
      if (localObject != null)
      {
        ((PerfRelativeLayout)this.root).removeView((View)localObject);
        localObject = "loginwelcome_" + this.app.getCurrentUin();
        localObject = getApplication().getSharedPreferences((String)localObject, 0).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", 3);
        ((SharedPreferences.Editor)localObject).commit();
        return true;
      }
    }
    return false;
  }
  
  private boolean PF()
  {
    switch (this.jdField_a_of_type_Alcn.e.pa)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (acff)this.app.getManager(51);
      if (localObject == null) {}
      for (localObject = null; (localObject != null) && (((Friends)localObject).gathtertype == 1); localObject = ((acff)localObject).a(this.jdField_a_of_type_Alcn.e.uin)) {
        return true;
      }
    }
  }
  
  private boolean Py()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo begin");
    }
    if ((this.aWA) || (this.jdField_c_of_type_Afsr != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, has requeseted : " + this.aWA);
      }
      return false;
    }
    this.jdField_c_of_type_Afsr = new uzx(this);
    this.H = new arhz(this, getTitleBarHeight());
    if (this.H != null)
    {
      this.H.setBackAndSearchFilter(true);
      this.H.show();
    }
    this.app.addObserver(this.jdField_c_of_type_Afsr);
    ((afsg)this.app.getBusinessHandler(127)).k(this.app.getCurrentAccountUin(), false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, send request");
    }
    if (this.bL == null) {
      this.bL = new Handler(getMainLooper());
    }
    if (this.bL != null) {
      this.bL.postDelayed(new FriendProfileCardActivity.34(this), 10000L);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo end");
    }
    return true;
  }
  
  private boolean Pz()
  {
    boolean bool = true;
    if (this.aWy) {}
    Card localCard;
    do
    {
      return false;
      localCard = ((acff)this.app.getManager(51)).b(this.app.getCurrentUin());
    } while (localCard == null);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "showExtendFriendProfileGuide: delaration:" + localCard.declaration + " isshowcard:" + localCard.isShowCard);
    }
    if ((TextUtils.isEmpty(localCard.declaration)) && (Py())) {
      return true;
    }
    if ((TextUtils.isEmpty(localCard.declaration)) || (!localCard.isShowCard)) {
      if (!TextUtils.isEmpty(localCard.declaration)) {
        break label281;
      }
    }
    label279:
    label281:
    for (int i = 1;; i = 2)
    {
      this.O = afyk.a(this, i, new uzy(this, localCard));
      try
      {
        if (this.O != null) {
          this.O.show();
        }
        try
        {
          if (TextUtils.isEmpty(localCard.declaration)) {
            anot.a(this.app, "dc00898", "", "", "0X80092EA", "0X80092EA", 0, 0, "", "", "", "");
          } else {
            anot.a(this.app, "dc00898", "", "", "0X80092E7", "0X80092E7", 0, 0, "", "", "", "");
          }
        }
        catch (Exception localException1)
        {
          bool = true;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          bool = false;
        }
      }
      QLog.e("FriendProfileCardActivity", 1, "showProfileGuide fail.");
      break label279;
      bool = false;
      return bool;
    }
  }
  
  @NotNull
  private View a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramView.getContext());
    ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
    localFrameLayout.setLayoutParams(paramView.getLayoutParams());
    localFrameLayout.setPadding(wja.dp2px(paramInt1, getResources()), wja.dp2px(paramInt2, getResources()), wja.dp2px(paramInt3, getResources()), wja.dp2px(paramInt4, getResources()));
    paramInt1 = localViewGroup.indexOfChild(paramView);
    localViewGroup.removeView(paramView);
    localFrameLayout.addView(paramView, new FrameLayout.LayoutParams(-1, -1));
    localViewGroup.addView(localFrameLayout, paramInt1);
    return localFrameLayout;
  }
  
  public static ProfileActivity.CardContactInfo a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAllInOne != null)
    {
      localObject1 = localObject2;
      if (paramAllInOne.pr != null)
      {
        localObject1 = localObject2;
        if (paramAllInOne.pr.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)paramAllInOne.pr.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public static String a(alcn paramalcn, QQAppInterface paramQQAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = aqep.b(paramalcn.e);
    if (i == 0)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty(null)) {
        paramQQAppInterface = paramalcn.gh[4];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramalcn.e.remark;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        paramQQAppInterface = paramalcn.gh[0];
      }
      localObject1 = paramQQAppInterface;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        localObject1 = paramalcn.e.nickname;
      }
      return localObject1;
      if ((i == 1000) || (i == 1020))
      {
        paramQQAppInterface = paramalcn.gh[1];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramalcn.e.aOI;
        }
      }
      else if (i == 1021)
      {
        paramQQAppInterface = paramalcn.gh[2];
        localObject1 = paramQQAppInterface;
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          localObject1 = paramalcn.e.aOJ;
        }
      }
      else if (i == 1004)
      {
        localObject1 = localObject2;
        if (paramalcn.e.troopUin != null) {
          localObject1 = aqgv.m(paramQQAppInterface, paramalcn.e.troopUin, paramalcn.e.uin);
        }
      }
      else
      {
        localObject1 = localObject2;
        if (ProfileActivity.AllInOne.i(paramalcn.e)) {
          localObject1 = paramalcn.gh[3];
        }
      }
    }
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    Object localObject1 = a(paramAllInOne);
    if (localObject1 != null) {}
    for (localObject1 = ((ProfileActivity.CardContactInfo)localObject1).aOM + ((ProfileActivity.CardContactInfo)localObject1).phoneNumber;; localObject1 = "")
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramAllInOne.uin;
      }
      return localObject2;
    }
  }
  
  public static void a(Activity paramActivity, alcn paramalcn, String paramString1, int paramInt, String paramString2)
  {
    Intent localIntent = wja.a(new Intent(paramActivity, SplashActivity.class), null);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", paramalcn.e.uin);
    if ((paramActivity.getIntent() != null) && (paramActivity.getIntent().getExtras() != null)) {
      localIntent.putExtra("cSpecialFlag", paramActivity.getIntent().getExtras().getInt("cSpecialFlag"));
    }
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("aio_msg_source", 3);
    if (paramalcn.e.bJc != 0) {
      localIntent.putExtra("entrance", paramalcn.e.bJc);
    }
    localIntent.putExtra("uinname", paramString2);
    paramActivity.startActivity(localIntent);
  }
  
  /* Error */
  public static void a(QQAppInterface arg0, alcn paramalcn)
  {
    // Byte code:
    //   0: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 1002
    //   9: iconst_2
    //   10: ldc_w 1004
    //   13: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   20: getfield 899	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:nickname	Ljava/lang/String;
    //   23: astore 6
    //   25: aload_1
    //   26: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   29: getfield 896	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:remark	Ljava/lang/String;
    //   32: astore_3
    //   33: aload_1
    //   34: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   37: getfield 902	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:aOI	Ljava/lang/String;
    //   40: astore 5
    //   42: aload_1
    //   43: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   46: getfield 1007	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:aOH	Ljava/lang/String;
    //   49: astore 12
    //   51: aload_1
    //   52: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   55: getfield 1010	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:contactName	Ljava/lang/String;
    //   58: astore 10
    //   60: aload_1
    //   61: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   64: getfield 1013	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:alias	Ljava/lang/String;
    //   67: astore 14
    //   69: aload_1
    //   70: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   73: getfield 905	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:aOJ	Ljava/lang/String;
    //   76: astore 13
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: astore 8
    //   86: aload_1
    //   87: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   90: invokestatic 1015	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:b	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   93: ifeq +564 -> 657
    //   96: aload 6
    //   98: astore 7
    //   100: aload 6
    //   102: astore 8
    //   104: aload_0
    //   105: bipush 51
    //   107: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   110: checkcast 640	acff
    //   113: astore 4
    //   115: aload 4
    //   117: ifnonnull +515 -> 632
    //   120: aconst_null
    //   121: astore 11
    //   123: aload 6
    //   125: astore 9
    //   127: aload 11
    //   129: ifnull +866 -> 995
    //   132: aload 6
    //   134: astore 4
    //   136: aload 6
    //   138: astore 7
    //   140: aload 6
    //   142: astore 8
    //   144: aload 11
    //   146: getfield 1018	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   149: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +18 -> 170
    //   155: aload 6
    //   157: astore 7
    //   159: aload 6
    //   161: astore 8
    //   163: aload 11
    //   165: getfield 1018	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   168: astore 4
    //   170: aload 4
    //   172: astore 7
    //   174: aload 4
    //   176: astore 8
    //   178: aload 4
    //   180: astore 9
    //   182: aload 11
    //   184: getfield 1019	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   187: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifne +805 -> 995
    //   193: aload 4
    //   195: astore 7
    //   197: aload 4
    //   199: astore 8
    //   201: aload 11
    //   203: getfield 1019	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   206: astore 6
    //   208: aload 4
    //   210: astore_3
    //   211: aload 6
    //   213: astore 4
    //   215: aload_0
    //   216: bipush 52
    //   218: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   221: checkcast 1021	com/tencent/mobileqq/app/TroopManager
    //   224: astore 8
    //   226: aload_1
    //   227: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   230: astore 7
    //   232: aload 7
    //   234: astore 6
    //   236: aload 7
    //   238: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   241: ifeq +34 -> 275
    //   244: aload 7
    //   246: astore 6
    //   248: aload_1
    //   249: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   252: getfield 908	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopUin	Ljava/lang/String;
    //   255: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +17 -> 275
    //   261: aload 8
    //   263: aload_1
    //   264: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   267: getfield 908	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopUin	Ljava/lang/String;
    //   270: invokevirtual 1026	com/tencent/mobileqq/app/TroopManager:jq	(Ljava/lang/String;)Ljava/lang/String;
    //   273: astore 6
    //   275: aload 6
    //   277: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   280: ifne +696 -> 976
    //   283: aload 8
    //   285: ifnull +691 -> 976
    //   288: aload_0
    //   289: aload 6
    //   291: aload_1
    //   292: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   295: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   298: invokestatic 1029	aqgv:s	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   301: astore_0
    //   302: aload 10
    //   304: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   307: ifeq +662 -> 969
    //   310: aload_1
    //   311: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   314: invokestatic 920	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Lcom/tencent/mobileqq/activity/ProfileActivity$CardContactInfo;
    //   317: astore 5
    //   319: aload 5
    //   321: ifnull +648 -> 969
    //   324: aload 5
    //   326: getfield 1032	com/tencent/mobileqq/activity/ProfileActivity$CardContactInfo:aOL	Ljava/lang/String;
    //   329: astore 5
    //   331: aload 4
    //   333: astore 6
    //   335: aload 5
    //   337: astore 9
    //   339: aload_3
    //   340: astore 4
    //   342: aload 6
    //   344: astore 5
    //   346: aload_0
    //   347: astore 6
    //   349: aload_1
    //   350: getfield 893	alcn:gh	[Ljava/lang/String;
    //   353: astore_0
    //   354: aload_0
    //   355: monitorenter
    //   356: aload_1
    //   357: getfield 893	alcn:gh	[Ljava/lang/String;
    //   360: iconst_0
    //   361: aaload
    //   362: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   365: ifeq +11 -> 376
    //   368: aload_1
    //   369: getfield 893	alcn:gh	[Ljava/lang/String;
    //   372: iconst_0
    //   373: aload 4
    //   375: aastore
    //   376: aload_1
    //   377: getfield 893	alcn:gh	[Ljava/lang/String;
    //   380: iconst_4
    //   381: aaload
    //   382: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifeq +11 -> 396
    //   388: aload_1
    //   389: getfield 893	alcn:gh	[Ljava/lang/String;
    //   392: iconst_4
    //   393: aload 5
    //   395: aastore
    //   396: aload_1
    //   397: getfield 893	alcn:gh	[Ljava/lang/String;
    //   400: iconst_3
    //   401: aaload
    //   402: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   405: ifeq +11 -> 416
    //   408: aload_1
    //   409: getfield 893	alcn:gh	[Ljava/lang/String;
    //   412: iconst_3
    //   413: aload 9
    //   415: aastore
    //   416: aload_1
    //   417: getfield 893	alcn:gh	[Ljava/lang/String;
    //   420: iconst_5
    //   421: aaload
    //   422: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   425: ifeq +11 -> 436
    //   428: aload_1
    //   429: getfield 893	alcn:gh	[Ljava/lang/String;
    //   432: iconst_5
    //   433: aload 12
    //   435: aastore
    //   436: aload_1
    //   437: getfield 893	alcn:gh	[Ljava/lang/String;
    //   440: iconst_1
    //   441: aaload
    //   442: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   445: ifeq +11 -> 456
    //   448: aload_1
    //   449: getfield 893	alcn:gh	[Ljava/lang/String;
    //   452: iconst_1
    //   453: aload 6
    //   455: aastore
    //   456: aload_1
    //   457: getfield 893	alcn:gh	[Ljava/lang/String;
    //   460: bipush 6
    //   462: aaload
    //   463: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   466: ifeq +12 -> 478
    //   469: aload_1
    //   470: getfield 893	alcn:gh	[Ljava/lang/String;
    //   473: bipush 6
    //   475: aload 14
    //   477: aastore
    //   478: aload_1
    //   479: getfield 893	alcn:gh	[Ljava/lang/String;
    //   482: iconst_2
    //   483: aaload
    //   484: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   487: ifeq +11 -> 498
    //   490: aload_1
    //   491: getfield 893	alcn:gh	[Ljava/lang/String;
    //   494: iconst_2
    //   495: aload 13
    //   497: aastore
    //   498: aload_0
    //   499: monitorexit
    //   500: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq +128 -> 631
    //   506: new 587	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   513: astore_0
    //   514: aload_0
    //   515: ldc_w 1034
    //   518: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: ldc_w 1036
    //   524: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 4
    //   529: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   532: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc_w 1043
    //   538: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload 5
    //   543: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   546: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 1045
    //   552: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 9
    //   557: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   560: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: ldc_w 1047
    //   566: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: aload 12
    //   571: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   574: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 1049
    //   580: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 6
    //   585: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   588: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc_w 1051
    //   594: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 13
    //   599: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   602: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: ldc_w 1053
    //   608: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload 12
    //   613: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   616: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: ldc_w 1002
    //   623: iconst_2
    //   624: aload_0
    //   625: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 1055	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: return
    //   632: aload 6
    //   634: astore 7
    //   636: aload 6
    //   638: astore 8
    //   640: aload 4
    //   642: aload_1
    //   643: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   646: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   649: invokevirtual 651	acff:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   652: astore 11
    //   654: goto -531 -> 123
    //   657: aload 6
    //   659: astore 7
    //   661: aload 6
    //   663: astore 8
    //   665: aload_1
    //   666: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   669: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   672: ifne +33 -> 705
    //   675: aload 6
    //   677: astore 7
    //   679: aload 6
    //   681: astore 8
    //   683: aload_0
    //   684: aload_1
    //   685: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   688: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   691: invokestatic 1058	aqgv:n	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   694: astore 6
    //   696: aload_3
    //   697: astore 4
    //   699: aload 6
    //   701: astore_3
    //   702: goto -487 -> 215
    //   705: aload 6
    //   707: astore 7
    //   709: aload 6
    //   711: astore 8
    //   713: aload 6
    //   715: astore 4
    //   717: aload 6
    //   719: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   722: ifeq +260 -> 982
    //   725: aload 6
    //   727: astore 7
    //   729: aload 6
    //   731: astore 8
    //   733: aload 6
    //   735: astore 4
    //   737: aload_1
    //   738: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   741: invokestatic 1060	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:g	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)Z
    //   744: ifeq +238 -> 982
    //   747: aload 6
    //   749: astore 7
    //   751: aload 6
    //   753: astore 8
    //   755: aload_0
    //   756: aload_1
    //   757: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   760: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   763: iconst_0
    //   764: invokestatic 1063	aqgv:d	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)Ljava/lang/String;
    //   767: astore 4
    //   769: aload 4
    //   771: astore 7
    //   773: aload 4
    //   775: astore 8
    //   777: aload 4
    //   779: aload_1
    //   780: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   783: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   786: invokestatic 1067	aqft:equalsWithNullCheck	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   789: istore_2
    //   790: iload_2
    //   791: ifeq +191 -> 982
    //   794: aconst_null
    //   795: astore 6
    //   797: aload_3
    //   798: astore 4
    //   800: aload 6
    //   802: astore_3
    //   803: goto -588 -> 215
    //   806: astore 8
    //   808: aload 5
    //   810: astore_0
    //   811: aload_0
    //   812: astore 6
    //   814: aload_3
    //   815: astore 5
    //   817: aload 7
    //   819: astore 4
    //   821: aload 10
    //   823: astore 9
    //   825: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   828: ifeq -479 -> 349
    //   831: ldc_w 1002
    //   834: iconst_2
    //   835: aload 8
    //   837: invokevirtual 1068	java/lang/Exception:toString	()Ljava/lang/String;
    //   840: invokestatic 1055	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   843: aload_0
    //   844: astore 6
    //   846: aload_3
    //   847: astore 5
    //   849: aload 7
    //   851: astore 4
    //   853: aload 10
    //   855: astore 9
    //   857: goto -508 -> 349
    //   860: astore 7
    //   862: aload 5
    //   864: astore_0
    //   865: aload_0
    //   866: astore 6
    //   868: aload_3
    //   869: astore 5
    //   871: aload 8
    //   873: astore 4
    //   875: aload 10
    //   877: astore 9
    //   879: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq -533 -> 349
    //   885: ldc_w 1002
    //   888: iconst_2
    //   889: aload 7
    //   891: invokevirtual 1069	java/lang/Error:toString	()Ljava/lang/String;
    //   894: invokestatic 1055	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   897: aload_0
    //   898: astore 6
    //   900: aload_3
    //   901: astore 5
    //   903: aload 8
    //   905: astore 4
    //   907: aload 10
    //   909: astore 9
    //   911: goto -562 -> 349
    //   914: astore_1
    //   915: aload_0
    //   916: monitorexit
    //   917: aload_1
    //   918: athrow
    //   919: astore 7
    //   921: aload_3
    //   922: astore 8
    //   924: aload 5
    //   926: astore_0
    //   927: aload 4
    //   929: astore_3
    //   930: goto -65 -> 865
    //   933: astore 7
    //   935: aload_3
    //   936: astore 8
    //   938: aload 4
    //   940: astore_3
    //   941: goto -76 -> 865
    //   944: astore 8
    //   946: aload_3
    //   947: astore 7
    //   949: aload 5
    //   951: astore_0
    //   952: aload 4
    //   954: astore_3
    //   955: goto -144 -> 811
    //   958: astore 8
    //   960: aload_3
    //   961: astore 7
    //   963: aload 4
    //   965: astore_3
    //   966: goto -155 -> 811
    //   969: aload 10
    //   971: astore 5
    //   973: goto -642 -> 331
    //   976: aload 5
    //   978: astore_0
    //   979: goto -677 -> 302
    //   982: aload 4
    //   984: astore 6
    //   986: aload_3
    //   987: astore 4
    //   989: aload 6
    //   991: astore_3
    //   992: goto -777 -> 215
    //   995: aload_3
    //   996: astore 4
    //   998: aload 9
    //   1000: astore_3
    //   1001: goto -786 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1004	1	paramalcn	alcn
    //   789	2	2	bool	boolean
    //   32	969	3	localObject1	Object
    //   113	884	4	localObject2	Object
    //   40	937	5	localObject3	Object
    //   23	967	6	localObject4	Object
    //   80	770	7	localObject5	Object
    //   860	30	7	localError1	java.lang.Error
    //   919	1	7	localError2	java.lang.Error
    //   933	1	7	localError3	java.lang.Error
    //   947	15	7	localObject6	Object
    //   84	692	8	localObject7	Object
    //   806	98	8	localException1	Exception
    //   922	15	8	localObject8	Object
    //   944	1	8	localException2	Exception
    //   958	1	8	localException3	Exception
    //   125	874	9	localObject9	Object
    //   58	912	10	str1	String
    //   121	532	11	localFriends	Friends
    //   49	563	12	str2	String
    //   76	522	13	str3	String
    //   67	409	14	str4	String
    // Exception table:
    //   from	to	target	type
    //   86	96	806	java/lang/Exception
    //   104	115	806	java/lang/Exception
    //   144	155	806	java/lang/Exception
    //   163	170	806	java/lang/Exception
    //   182	193	806	java/lang/Exception
    //   201	208	806	java/lang/Exception
    //   640	654	806	java/lang/Exception
    //   665	675	806	java/lang/Exception
    //   683	696	806	java/lang/Exception
    //   717	725	806	java/lang/Exception
    //   737	747	806	java/lang/Exception
    //   755	769	806	java/lang/Exception
    //   777	790	806	java/lang/Exception
    //   86	96	860	java/lang/Error
    //   104	115	860	java/lang/Error
    //   144	155	860	java/lang/Error
    //   163	170	860	java/lang/Error
    //   182	193	860	java/lang/Error
    //   201	208	860	java/lang/Error
    //   640	654	860	java/lang/Error
    //   665	675	860	java/lang/Error
    //   683	696	860	java/lang/Error
    //   717	725	860	java/lang/Error
    //   737	747	860	java/lang/Error
    //   755	769	860	java/lang/Error
    //   777	790	860	java/lang/Error
    //   356	376	914	finally
    //   376	396	914	finally
    //   396	416	914	finally
    //   416	436	914	finally
    //   436	456	914	finally
    //   456	478	914	finally
    //   478	498	914	finally
    //   498	500	914	finally
    //   915	917	914	finally
    //   215	232	919	java/lang/Error
    //   236	244	919	java/lang/Error
    //   248	275	919	java/lang/Error
    //   275	283	919	java/lang/Error
    //   288	302	919	java/lang/Error
    //   302	319	933	java/lang/Error
    //   324	331	933	java/lang/Error
    //   215	232	944	java/lang/Exception
    //   236	244	944	java/lang/Exception
    //   248	275	944	java/lang/Exception
    //   275	283	944	java/lang/Exception
    //   288	302	944	java/lang/Exception
    //   302	319	958	java/lang/Exception
    //   324	331	958	java/lang/Exception
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn)
  {
    int j = aqep.b(paramalcn.e);
    String str3 = a(paramalcn, paramQQAppInterface);
    String str2 = null;
    Object localObject;
    String str1;
    if (ProfileActivity.AllInOne.g(paramalcn.e))
    {
      localObject = paramalcn.e.uin;
      str2 = null;
      if (j != 1000) {
        break label379;
      }
      str1 = paramalcn.e.troopUin;
    }
    for (;;)
    {
      label58:
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "Two_call", "Clk_freecall", eP(paramalcn.e.bJa), 0, Integer.toString(a(paramalcn.e)), "", "", "");
      ChatActivityUtils.a(paramQQAppInterface, paramBaseActivity, j, (String)localObject, str3, str2, true, str1, true, true, null, "from_internal");
      switch (paramalcn.e.pa)
      {
      default: 
        paramBaseActivity = "4";
      }
      for (;;)
      {
        anot.a(paramQQAppInterface, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramBaseActivity, "", "", "");
        return;
        str1 = str2;
        int i = j;
        if (paramalcn.e.pa == 53)
        {
          str1 = str2;
          i = j;
          if (paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            str1 = str2;
            i = j;
            if (!TextUtils.isEmpty(paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin))
            {
              str1 = paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
              i = 0;
            }
          }
        }
        str2 = a(paramalcn.e);
        localObject = str1;
        j = i;
        break;
        label379:
        if (j != 1004) {
          break label427;
        }
        str1 = paramalcn.e.discussUin;
        break label58;
        paramBaseActivity = "4";
        continue;
        paramBaseActivity = "5";
        continue;
        paramBaseActivity = "6";
        continue;
        paramBaseActivity = "7";
      }
      label427:
      str1 = null;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn, Dialog paramDialog)
  {
    Object localObject = paramBaseActivity.getIntent().getBundleExtra("profile_extres");
    boolean bool;
    int k;
    int i1;
    int i;
    int j;
    if (localObject != null)
    {
      bool = ((Bundle)localObject).getBoolean("from_babyq", false);
      k = 3999;
      i1 = 0;
      i = i1;
      j = k;
      switch (paramalcn.e.pa)
      {
      default: 
        j = k;
        i = i1;
      }
    }
    for (;;)
    {
      if (j == 3045) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i), "", "", "");
      }
      if (j == 3094) {
        anot.c(paramQQAppInterface, "dc00898", "", paramalcn.e.uin, "0X80092E2", "0X80092E2", 0, 0, String.valueOf(i), afxv.uQ(), afxv.t(paramQQAppInterface), afxv.uS());
      }
      if ((j != 3007) || (acgr.y(paramQQAppInterface, paramalcn.e.uin))) {
        break label1548;
      }
      localObject = paramDialog;
      if (paramDialog == null) {
        localObject = acgr.a(paramBaseActivity, paramBaseActivity.getString(2131696214), new uzz(paramQQAppInterface, paramBaseActivity, paramalcn), new vaa());
      }
      if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!paramBaseActivity.isFinishing())) {
        ((Dialog)localObject).show();
      }
      return;
      bool = false;
      break;
      i = paramalcn.e.subSourceId;
      j = 3004;
      continue;
      i = 3;
      j = 3004;
      continue;
      i = 1;
      j = 3007;
      continue;
      i = 1;
      j = 3001;
      continue;
      i = paramalcn.e.subSourceId;
      j = 3020;
      continue;
      i = 1;
      j = 3017;
      continue;
      i = paramalcn.e.subSourceId;
      j = 3002;
      continue;
      i = 1;
      j = 3005;
      continue;
      i = 2;
      j = 3007;
      continue;
      i = 0;
      j = 3003;
      continue;
      i = 12;
      j = 3008;
      continue;
      i = 11;
      j = 3008;
      continue;
      i = 12;
      j = 3041;
      continue;
      i = 11;
      j = 3041;
      continue;
      i = 0;
      j = 3999;
      continue;
      i = 1;
      j = 3037;
      continue;
      i = 1;
      j = 3095;
      continue;
      i = 1;
      j = 3096;
      continue;
      i = 1;
      j = 3042;
      continue;
      i = 2;
      j = 3037;
      continue;
      i = 0;
      j = 3009;
      continue;
      j = 3006;
      i = 13;
      if (bool)
      {
        i = 1;
        j = 3084;
        continue;
        j = 3068;
        i = 1;
        if (bool)
        {
          i = 1;
          j = 3084;
          continue;
          if ((paramalcn.e.subSourceId == 16) || (paramalcn.e.subSourceId == 17))
          {
            i = paramalcn.e.subSourceId;
            j = 3006;
          }
          else
          {
            i = 1;
            j = 3075;
            continue;
            i = 1;
            j = 3009;
            continue;
            i = 1;
            j = 3006;
            continue;
            i = 0;
            j = 3013;
            continue;
            i = 1;
            j = 3003;
            continue;
            i = 1;
            j = 3014;
            continue;
            i = 2;
            j = 3003;
            continue;
            j = 3022;
            i = 1;
            if (bool)
            {
              i = 1;
              j = 3083;
              continue;
              i = 0;
              j = 3011;
              continue;
              if (paramalcn.e.bJa == 127)
              {
                i = 1;
                j = 3048;
              }
              else
              {
                i = 1;
                j = 3071;
                continue;
                i = 21;
                j = 3045;
                continue;
                i = 23;
                j = 3045;
                continue;
                j = 3045;
                i = 3;
                if (bool)
                {
                  i = 1;
                  j = 3083;
                  continue;
                  if (localObject != null) {}
                  for (i = ((Bundle)localObject).getInt("tabID", 0);; i = 0)
                  {
                    j = 3045;
                    break;
                  }
                  i = 28;
                  j = 3045;
                  continue;
                  i = 4;
                  j = 3045;
                  continue;
                  i = 24;
                  j = 3045;
                  continue;
                  i = 20;
                  j = 3045;
                  continue;
                  i = 25;
                  j = 3045;
                  continue;
                  i = 1;
                  j = 3092;
                  continue;
                  i = paramalcn.e.subSourceId;
                  j = 3094;
                  continue;
                  i = 11;
                  j = 3072;
                  continue;
                  i = 12;
                  j = 3072;
                  continue;
                  i = 1;
                  j = 3018;
                  continue;
                  i = 15;
                  j = 3041;
                  continue;
                  i = 14;
                  j = 3041;
                  continue;
                  if (paramalcn.e.bJa == 118)
                  {
                    i = 3;
                    j = 3022;
                  }
                  else
                  {
                    i = i1;
                    j = k;
                    if (paramalcn.e.bJa == 121)
                    {
                      i = 2;
                      j = 3022;
                      continue;
                      i = 23;
                      j = 3004;
                      continue;
                      i = paramalcn.e.subSourceId;
                      j = 3004;
                      continue;
                      i = 2;
                      j = 3080;
                      continue;
                      i = 4;
                      j = 3076;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1548:
    if (paramalcn.d != null) {}
    for (localObject = aqep.a(paramQQAppInterface.getApp().getApplicationContext(), paramalcn.d.shGender, paramalcn.d.age, paramalcn.d.strCountry, paramalcn.d.strProvince, paramalcn.d.strCity);; localObject = "")
    {
      String str;
      if ((paramalcn.e.pa == 32) || (paramalcn.e.pa == 31) || (paramalcn.e.pa == 51) || (paramalcn.e.pa == 50) || (paramalcn.e.pa == 34) || (paramalcn.e.pa == 36) || (paramalcn.e.pa == 53) || (paramalcn.e.pa == 29))
      {
        ProfileActivity.CardContactInfo localCardContactInfo = a(paramalcn.e);
        if ((localCardContactInfo == null) || (localCardContactInfo.phoneNumber == null) || (localCardContactInfo.phoneNumber.length() <= 0)) {
          break;
        }
        str = localCardContactInfo.aOM + localCardContactInfo.phoneNumber;
        paramDialog = localCardContactInfo.aOL;
        paramQQAppInterface = paramDialog;
        if (TextUtils.isEmpty(localCardContactInfo.aOL))
        {
          if (TextUtils.isEmpty(paramalcn.gh[3])) {
            break label1900;
          }
          paramQQAppInterface = paramalcn.gh[3];
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 2, str, null, j, i, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131691039), null);
          paramQQAppInterface.putExtra("param_return_profilecard_pa", paramalcn.e.pa);
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramalcn);
          bool = paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);
          if (!bool) {
            break;
          }
          paramQQAppInterface.putExtra("from_newer_guide", bool);
          paramQQAppInterface.removeExtra("param_return_addr");
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1024);
          return;
          label1900:
          if (!TextUtils.isEmpty(paramalcn.gh[0]))
          {
            paramQQAppInterface = paramalcn.gh[0];
          }
          else
          {
            paramQQAppInterface = paramDialog;
            if (!TextUtils.isEmpty(paramalcn.jdField_a_of_type_Aqaf.a.value)) {
              paramQQAppInterface = paramalcn.jdField_a_of_type_Aqaf.a.value;
            }
          }
        }
        paramBaseActivity.startActivity(paramQQAppInterface);
        return;
      }
      paramQQAppInterface = null;
      if ((3004 == j) && (!TextUtils.isEmpty(paramalcn.e.troopUin)))
      {
        paramDialog = paramalcn.e.troopUin;
        paramQQAppInterface = null;
        if ((paramalcn.e.pa != 71) && (paramalcn.e.pa != 72)) {
          break label2169;
        }
        paramQQAppInterface = paramalcn.gh[2];
        label2024:
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          break label2410;
        }
        paramQQAppInterface = paramalcn.gh[0];
      }
      label2407:
      label2410:
      for (;;)
      {
        str = paramBaseActivity.getIntent().getStringExtra("param_return_addr");
        if (str != null)
        {
          localObject = AddContactsActivity.class.getName();
          if (!str.equals(QidianProfileCardActivity.class.getName())) {
            break label2407;
          }
          localObject = str;
        }
        for (;;)
        {
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramalcn.e.uin, paramDialog, j, i, paramQQAppInterface, null, (String)localObject, paramBaseActivity.getString(2131691039), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramalcn);
          paramBaseActivity.startActivity(paramQQAppInterface);
          return;
          paramDialog = paramQQAppInterface;
          if (3005 != j) {
            break;
          }
          paramDialog = paramQQAppInterface;
          if (TextUtils.isEmpty(paramalcn.e.discussUin)) {
            break;
          }
          paramDialog = paramalcn.e.discussUin;
          break;
          label2169:
          if ((paramalcn.e.pa != 77) && (paramalcn.e.pa != 82) && (paramalcn.e.pa != 81) && (paramalcn.e.pa != 83) && (paramalcn.e.pa != 84) && (paramalcn.e.pa != 101) && (paramalcn.e.pa != 103) && (paramalcn.e.pa != 102) && (paramalcn.e.pa != 107) && (paramalcn.e.pa != 110)) {
            break label2024;
          }
          paramQQAppInterface = paramalcn.gh[5];
          break label2024;
          paramQQAppInterface = AddFriendLogicActivity.a(paramBaseActivity, 1, paramalcn.e.uin, paramDialog, j, i, paramQQAppInterface, null, FriendProfileCardActivity.class.getName(), paramBaseActivity.getString(2131691039), null);
          paramQQAppInterface.putExtra("from_babyq", bool);
          ProfileActivity.a(paramBaseActivity, paramQQAppInterface, paramalcn);
          if (j == 3094)
          {
            paramQQAppInterface.putExtra("entrance", paramBaseActivity.getIntent().getIntExtra("entrance", 2));
            paramQQAppInterface.removeExtra("param_return_addr");
            paramBaseActivity.startActivity(paramQQAppInterface);
            return;
          }
          paramQQAppInterface.putExtra("key_param_age_area", (String)localObject);
          paramBaseActivity.startActivityForResult(paramQQAppInterface, 1000);
          return;
        }
      }
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn, String paramString, int paramInt)
  {
    if (paramBaseActivity.getIntent() != null) {}
    for (boolean bool = paramBaseActivity.getIntent().getBooleanExtra("key_need_track_back", false) | paramBaseActivity.getIntent().getBooleanExtra("from_newer_guide", false);; bool = false)
    {
      Object localObject;
      Intent localIntent;
      if (bool)
      {
        localObject = new Intent(paramBaseActivity, ChatActivity.class);
        localIntent = wja.a((Intent)localObject, null);
        localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
        localIntent.putExtra("PREVIOUS_UIN", paramalcn.e.uin);
        if (paramBaseActivity.getIntent().getExtras() != null) {
          localIntent.putExtra("cSpecialFlag", paramBaseActivity.getIntent().getExtras().getInt("cSpecialFlag"));
        }
        localIntent.putExtra("uin", paramString);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("aio_msg_source", 3);
        if (paramalcn.e.bJc != 0) {
          localIntent.putExtra("entrance", paramalcn.e.bJc);
        }
        localObject = a(paramalcn, paramQQAppInterface);
        if (localObject != null) {
          break label499;
        }
        paramString = "";
        label193:
        localIntent.putExtra("uinname", paramString);
        if (TextUtils.isEmpty(paramalcn.e.troopUin)) {
          break label505;
        }
        localIntent.putExtra("troop_uin", paramalcn.e.troopUin);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramalcn.e.troopcode)) {
          localIntent.putExtra("troop_code", paramalcn.e.troopcode);
        }
        if (paramInt == 1009) {
          localIntent.putExtra("rich_status_sig", paramalcn.e.cf);
        }
        if (paramInt == 1001) {
          localIntent.putExtra("rich_accost_sig", paramalcn.e.cf);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, String.format(Locale.getDefault(), "enterChar uin: %s name: %s sig: %s", new Object[] { aqft.pl(paramalcn.e.uin), aqft.pl((String)localObject), aqft.bytesToHexString(paramalcn.e.cf) }));
        }
        paramQQAppInterface = (acff)paramQQAppInterface.getManager(51);
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a(paramalcn.e.uin);
          if ((paramQQAppInterface != null) && ((jqs.cU(paramQQAppInterface.cSpecialFlag)) || (asgx.mS(paramQQAppInterface.cSpecialFlag)))) {
            localIntent.putExtra("chat_subType", 1);
          }
        }
        localIntent.putExtra("hidden_aio_msg_source", 2);
        if ((paramalcn.e.pa != 70) || (paramalcn.e.bIZ != 101)) {
          break label537;
        }
        localIntent.putExtra("is_from_manage_stranger", true);
        paramBaseActivity.startActivityForResult(localIntent, 1010);
        return;
        localObject = new Intent(paramBaseActivity, SplashActivity.class);
        break;
        label499:
        paramString = (String)localObject;
        break label193;
        label505:
        if (!TextUtils.isEmpty(paramalcn.e.discussUin)) {
          localIntent.putExtra("troop_uin", paramalcn.e.discussUin);
        }
      }
      label537:
      paramBaseActivity.startActivity(localIntent);
      return;
    }
  }
  
  public static boolean a(alcn paramalcn, int paramInt, String paramString)
  {
    if ((paramalcn == null) || (paramalcn.gh == null) || (paramInt < 0) || (paramInt >= paramalcn.gh.length)) {
      return false;
    }
    paramalcn.gh[paramInt] = paramString;
    return true;
  }
  
  private void ar(Message paramMessage)
  {
    this.jdField_b_of_type_Auru.removeMessages(102);
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
        if (localObject != null) {}
      }
      catch (Exception paramMessage)
      {
        Object localObject;
        int i;
        TextView localTextView;
        MedalWallMng localMedalWallMng;
        bool1 = false;
        bool2 = true;
        paramMessage.printStackTrace();
        boolean bool4 = bool1;
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("MedalWallMng", 2, "checkMedalGuide exception", paramMessage);
        bool4 = bool1;
        bool3 = bool2;
        continue;
      }
      try
      {
        if (QLog.isDevelopLevel())
        {
          QLog.i("MedalWallMng", 4, "checkMedalGuide headerView is null");
          i = 1;
          bool2 = false;
          bool1 = false;
          if (i == 0) {
            continue;
          }
        }
      }
      catch (Exception paramMessage)
      {
        bool1 = false;
        bool2 = false;
        continue;
      }
      try
      {
        if (paramMessage.arg1 >= 2) {
          continue;
        }
        localObject = this.jdField_b_of_type_Auru.obtainMessage();
        ((Message)localObject).what = paramMessage.what;
        ((Message)localObject).arg1 = (paramMessage.arg1 + 1);
        this.jdField_b_of_type_Auru.sendMessageDelayed((Message)localObject, 1000L);
        bool3 = bool1;
        bool4 = bool2;
        if (bool4) {
          bOq();
        }
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalGuide needUpdateAlpha:%s, needUpdateMedal: %s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
        }
        return;
      }
      catch (Exception paramMessage)
      {
        bool3 = bool1;
        bool1 = bool2;
        bool2 = bool3;
        continue;
        bool1 = false;
        continue;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.k("map_key_medal");
      if (localObject == null)
      {
        if (QLog.isDevelopLevel())
        {
          QLog.i("MedalWallMng", 4, "checkMedalGuide medalContainer is null!");
          i = 1;
          bool2 = false;
          bool1 = false;
        }
      }
      else
      {
        localTextView = (TextView)((View)localObject).findViewById(2131371207);
        if ((localTextView != null) && (localTextView.getWidth() > 0) && (localTextView.getHeight() > 0))
        {
          localMedalWallMng = (MedalWallMng)this.app.getManager(250);
          if (this.jdField_a_of_type_Alcn != null)
          {
            localObject = this.jdField_a_of_type_Alcn.d;
            if ((!localMedalWallMng.a(this, localTextView, 2, localObject)) || (this.jdField_a_of_type_Alcn == null)) {
              break label482;
            }
            localObject = this.jdField_a_of_type_Alcn.d;
            if (localObject == null) {
              break label482;
            }
          }
        }
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalGuide [iNewCount: %d, iUpgradeCount: %d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Alcn.d.iNewCount), Integer.valueOf(this.jdField_a_of_type_Alcn.d.iUpgradeCount) }));
        }
        bool1 = true;
        i = 0;
        bool2 = bool1;
        bool1 = true;
      }
      catch (Exception paramMessage)
      {
        bool1 = true;
        bool2 = true;
        continue;
      }
      localObject = null;
      continue;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "checkMedalGuide textView is null or size is 0!");
      }
      i = 1;
      bool2 = false;
      bool1 = false;
      continue;
      bool1 = true;
    }
  }
  
  private Drawable ay()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable == null) {}
    try
    {
      Object localObject2 = BitmapFactory.decodeResource(getResources(), 2130851119);
      Object localObject1 = BitmapFactory.decodeResource(getResources(), 2130851123);
      localObject2 = new NinePatchDrawable(getResources(), (Bitmap)localObject2, ((Bitmap)localObject2).getNinePatchChunk(), new Rect(), null);
      localObject1 = new NinePatchDrawable(getResources(), (Bitmap)localObject1, ((Bitmap)localObject1).getNinePatchChunk(), new Rect(), null);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919 }, (Drawable)localObject1);
      this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], (Drawable)localObject2);
      return this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "getBackDrawable fail.", localException);
      }
    }
  }
  
  public static void b(alcn paramalcn)
  {
    int k = 6;
    int i = 3;
    if (paramalcn.jdField_a_of_type_Aqaf == null) {
      paramalcn.jdField_a_of_type_Aqaf = new aqaf();
    }
    int j;
    switch (paramalcn.e.pa)
    {
    default: 
      i = 1;
      j = 0;
    }
    for (;;)
    {
      aqag.a(j, i, paramalcn.gh, paramalcn.jdField_a_of_type_Aqaf);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "updateProfileName profileName: %s", new Object[] { paramalcn.jdField_a_of_type_Aqaf.toString() }));
      }
      return;
      if (paramalcn.cwc)
      {
        j = 3;
        i = 2;
      }
      else
      {
        i = 2;
        j = 1;
        continue;
        i = 2;
        j = 2;
        continue;
        if (paramalcn.cwc)
        {
          j = 3;
          i = 2;
        }
        else
        {
          i = 2;
          j = 2;
          continue;
          j = 3;
          i = 2;
          continue;
          j = 3;
          i = 1;
          continue;
          j = 4;
          i = 1;
          continue;
          i = 2;
          j = k;
          continue;
          i = 1;
          j = k;
          continue;
          if (paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard != null)
          {
            j = k;
            if (!TextUtils.isEmpty(paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {}
          }
          else
          {
            i = 1;
            j = k;
            continue;
            j = 7;
            i = 2;
            continue;
            j = 7;
            i = 1;
            continue;
            j = 8;
            i = 1;
            continue;
            j = 9;
            i = 1;
            continue;
            j = 11;
            i = 1;
            continue;
            i = 1;
            j = 1;
            continue;
            j = 5;
            i = 1;
          }
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, alcn paramalcn)
  {
    aqfp.Sz(true);
    ProfileActivity.AllInOne localAllInOne = paramalcn.e;
    int i = aqep.b(localAllInOne);
    if ((localAllInOne.aOF != null) && (localAllInOne.aOF.length() > 0) && (localAllInOne.bIX != 3000) && (localAllInOne.bIX != 1) && (localAllInOne.bIX != 2) && (localAllInOne.bIX != 1033) && (localAllInOne.bIX != 1034) && (localAllInOne.bIX != 1044) && (localAllInOne.bIX != 1045) && (localAllInOne.aOF.equals(localAllInOne.uin)))
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.putExtra("finchat", true);
      paramBaseActivity.setResult(0, paramQQAppInterface);
      paramBaseActivity.finish();
      return;
    }
    String str = localAllInOne.uin;
    if (ProfileActivity.AllInOne.i(localAllInOne)) {
      if (localAllInOne.pa == 53) {
        if ((paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard != null) && (!TextUtils.isEmpty(paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)))
        {
          i = 0;
          str = paramalcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin;
        }
      }
    }
    for (;;)
    {
      a(paramQQAppInterface, paramBaseActivity, paramalcn, str, i);
      return;
      i = 1006;
      continue;
      str = a(localAllInOne);
      continue;
      if (localAllInOne.pa == 3) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "WPA", "OpenAIO_scan", 0, 0, "", "", "", "");
      } else if (localAllInOne.bIZ == 102) {
        anot.a(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_RandomConversation", 0, 0, "", "", "", "");
      } else if (localAllInOne.bIZ == 103) {
        anot.a(paramQQAppInterface, "P_CliOper", "Svip", "", "Vip_maproam", "vip_maproam_superConversation", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void bGM()
  {
    if (this.jdField_a_of_type_Alcn.e.pa == 96)
    {
      if (PA()) {
        anot.a(null, "dc00898", "", "", "kuolie", "0X80097DA", 2, 0, "", "", "", "");
      }
      while (Pz()) {
        return;
      }
    }
    a(this.app, this, this.jdField_a_of_type_Alcn, this.jdField_C_of_type_AndroidAppDialog);
  }
  
  private void bO(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)) && (this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
    {
      arrayOfByte = null;
      if ((this.jdField_a_of_type_Alcn.e.pa != 56) && (this.jdField_a_of_type_Alcn.e.pa != 57)) {
        break label281;
      }
    }
    for (byte[] arrayOfByte = this.jdField_a_of_type_Alcn.e.cf;; arrayOfByte = this.jdField_a_of_type_Alcn.e.cf) {
      label281:
      do
      {
        a(this.jdField_a_of_type_Alcn.d.feedPreviewTime, this.jdField_a_of_type_Alcn.d.vSeed, arrayOfByte, true);
        if ((paramIntent != null) && (paramIntent.getBundleExtra("result") != null))
        {
          int i = paramIntent.getBundleExtra("result").getShort("key_personality_label_switch", (short)-1);
          if ((i != -1) && (this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.personalityLabel != null) && (this.jdField_a_of_type_Alcn.d.personalityLabel.isCloseByUser != i))
          {
            if (QLog.isColorLevel()) {
              QLog.i("FriendProfileCardActivity", 2, "back personalitylabel switch changed:" + i);
            }
            this.jdField_a_of_type_Alcn.d.personalityLabel.isCloseByUser = i;
            if (this.jdField_a_of_type_Albg != null) {
              this.jdField_a_of_type_Albg.a(this.jdField_a_of_type_Alcn.d.personalityLabel, false, true);
            }
            bOr();
          }
        }
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_set_cover", false))) {
          ai(paramIntent.getByteArrayExtra("cover_data"));
        }
        return;
      } while ((this.jdField_a_of_type_Alcn.e.pa != 35) && (this.jdField_a_of_type_Alcn.e.pa != 37) && (this.jdField_a_of_type_Alcn.e.pa != 36));
    }
  }
  
  private void bOA()
  {
    String str;
    if (this.jdField_a_of_type_Srn != null) {
      str = this.jdField_a_of_type_Alcn.e.uin;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(str);
        if (this.jdField_a_of_type_Alcn.e.pa == 0) {
          break label110;
        }
        if (!this.app.getCurrentAccountUin().equals(str)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendProfileCardActivity", 2, "requestWeiShiPanelInfo failed getLong, uin = " + str);
        return;
      }
      this.jdField_a_of_type_Srn.J(bool, str);
      this.jdField_a_of_type_Srn.bAg();
      return;
      boolean bool = false;
      continue;
      label110:
      bool = true;
    }
  }
  
  private void bOB()
  {
    if ((this.jdField_a_of_type_Alcn == null) || (!this.jdField_a_of_type_Alcn.cwc) || (!aqiw.isNetworkAvailable(this))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(this.jdField_a_of_type_Alcn.d.uin);
          Object localObject = (TroopManager)this.app.getManager(52);
          acms localacms = (acms)this.app.getBusinessHandler(20);
          localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_Alcn.troopUin);
          c((TroopInfo)localObject);
          if (localObject != null)
          {
            localacms.b(this.jdField_a_of_type_Alcn.troopUin, ((TroopInfo)localObject).troopcode, localArrayList);
            localacms.ac(Long.parseLong(this.jdField_a_of_type_Alcn.troopUin), Long.parseLong(this.jdField_a_of_type_Alcn.d.uin));
            if (!TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Alcn.troopUin))
            {
              localacms.hU(Long.parseLong(this.jdField_a_of_type_Alcn.d.uin));
              return;
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.i("FriendProfileCardActivity", 2, "loadTroopMemberCard:" + localException.toString());
  }
  
  private void bOC()
  {
    Object localObject = adzx.a(this.app, this.jdField_a_of_type_Alcn);
    localObject = aqep.a(new Intent(this, ProfileCardMoreActivity.class), this.jdField_a_of_type_Alcn.e.uin, this.app, this.jdField_a_of_type_Alcn.e, (BusinessCard)localObject);
    if ((this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf != null) && (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC != null) && (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.size() > 0)) {
      ((Intent)localObject).putExtra("SHARE_NICK_NAME", ((aqae)this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.IC.get(0)).value);
    }
    if ((this.jdField_a_of_type_Alcn.d != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.addSrcName))) {
      ((Intent)localObject).putExtra("cur_add_source", this.jdField_a_of_type_Alcn.d.addSrcName);
    }
    if (this.jdField_a_of_type_Alcn.d != null) {
      ((Intent)localObject).putExtra("key_nick_name", this.jdField_a_of_type_Alcn.d.strNick);
    }
    ((Intent)localObject).addFlags(536870912);
    startActivityForResult((Intent)localObject, 1012);
    anot.a(this.app, "CliOper", "", "", "0X8006A8A", "0X8006A8A", 0, 0, "", "", "", "");
  }
  
  private void bOG()
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_Alcn.e.uin);
    localIntent.putExtra("PREVIOUS_WINDOW", FriendProfileCardActivity.class.getName());
    localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_Alcn.e.uin);
    Object localObject = (acff)this.app.getManager(51);
    if ((this.jdField_a_of_type_Alcn.jdField_c_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) || ((localObject != null) && (((acff)localObject).isFriend(this.jdField_a_of_type_Alcn.e.uin))))
    {
      localIntent.putExtra("uintype", 0);
      String str = aqgv.p(this.app, this.jdField_a_of_type_Alcn.troopUin, this.jdField_a_of_type_Alcn.e.uin);
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = this.jdField_a_of_type_Alcn.jdField_c_of_type_ComTencentMobileqqDataTroopMemberCard.nick;
      }
      localIntent.putExtra("uinname", (String)localObject);
      localIntent.putExtra("troop_code", this.jdField_a_of_type_Alcn.troopUin);
      localObject = (TroopManager)this.app.getManager(52);
      if (localObject == null) {
        break label242;
      }
      ((TroopManager)localObject).a(this.jdField_a_of_type_Alcn.troopUin, new vac(this, localIntent));
    }
    label242:
    while (!QLog.isColorLevel())
    {
      return;
      localIntent.putExtra("uintype", 1000);
      break;
    }
    QLog.e("FriendProfileCardActivity", 2, "enterChatByTroopMember, troopManager is null");
  }
  
  private void bOV()
  {
    if (this.Dr != null)
    {
      ((PerfRelativeLayout)this.root).removeView(this.Dr);
      this.Dr = null;
      aqvl.f(this.app, "hide_diy_template_guide", true);
    }
  }
  
  private void bOW()
  {
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      Object localObject = "loginwelcome_" + this.app.getCurrentUin();
      localObject = getApplication().getSharedPreferences((String)localObject, 0);
      boolean bool = ((SharedPreferences)localObject).getBoolean("first_device", false);
      int i = ((SharedPreferences)localObject).getInt("bubble_tips_time", 0);
      if ((bool) && (i < 3))
      {
        TextView localTextView = new TextView(this);
        localTextView.setId(2131373631);
        localTextView.setBackgroundResource(2130845983);
        localTextView.setIncludeFontPadding(false);
        localTextView.setClickable(false);
        localTextView.setText(acfp.m(2131706619));
        localTextView.setTextColor(-1);
        localTextView.setTextSize(1, 16.0F);
        int j = wja.dp2px(7.0F, getResources());
        int k = wja.dp2px(7.0F, getResources());
        localTextView.setPadding(j, wja.dp2px(7.0F, getResources()), k, wja.dp2px(13.0F, getResources()));
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.addRule(11);
        localLayoutParams.addRule(2, 2131373630);
        localLayoutParams.rightMargin = wja.dp2px(15.0F, getResources());
        localLayoutParams.bottomMargin = wja.dp2px(-1.0F, getResources());
        ((PerfRelativeLayout)this.root).addView(localTextView, localLayoutParams);
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putInt("bubble_tips_time", i + 1);
        ((SharedPreferences.Editor)localObject).commit();
        anot.a(this.app, "dc00898", "", "", "0X80081C0", "0X80081C0", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void bOY()
  {
    Object localObject1 = this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf;
    String str2 = this.jdField_a_of_type_Alcn.gh[0];
    Object localObject2 = this.jdField_a_of_type_Alcn.gh[1];
    Object localObject3 = this.jdField_a_of_type_Alcn.gh[4];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("showEditNickActionSheet, nickName: %s, troopNick: %s, remark: %s", new Object[] { str2, localObject2, localObject3 }));
    }
    String str1 = "";
    int i;
    boolean bool;
    if (this.jdField_a_of_type_Alcn.e.pa == 0) {
      if (this.jdField_a_of_type_Alcn.cwc)
      {
        localObject1 = getResources().getString(2131694838);
        anot.a(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
        i = 3;
        bool = true;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = (ausj)auss.a(this, null);
        ((ausj)localObject3).addButton((CharSequence)localObject1, 1);
        ((ausj)localObject3).addCancelButton(2131721058);
        ((ausj)localObject3).a(new vap(this, (String)localObject1, (String)localObject2, i, bool, (ausj)localObject3));
        ((ausj)localObject3).show();
      }
      return;
      localObject1 = getResources().getString(2131694837);
      anot.a(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 1, 0, "", "", "", "");
      localObject2 = str2;
      i = 1;
      bool = false;
      continue;
      if (this.jdField_a_of_type_Alcn.cwc)
      {
        localObject1 = ((TroopManager)this.app.getManager(52)).c(this.jdField_a_of_type_Alcn.troopUin);
        if ((localObject1 != null) && ((((TroopInfo)localObject1).isTroopAdmin(this.app.getCurrentUin())) || (((TroopInfo)localObject1).isTroopOwner(this.app.getCurrentUin())))) {
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
            {
              localObject1 = getResources().getString(2131694841, new Object[] { acfp.m(2131706612) });
              label395:
              anot.a(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 3, 0, "", "", "", "");
              bool = true;
              i = 4;
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = localObject3;
            }
          }
        }
        for (;;)
        {
          localObject3 = localObject1;
          localObject1 = localObject2;
          localObject2 = localObject3;
          break;
          localObject1 = getResources().getString(2131694841, new Object[] { acfp.m(2131706607) });
          break label395;
          if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
          {
            localObject1 = getResources().getString(2131694913, new Object[] { acfp.m(2131706635) });
            break label395;
          }
          localObject1 = getResources().getString(2131694913, new Object[] { acfp.m(2131706590) });
          break label395;
          if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
          {
            ci(getResources().getString(2131694843, new Object[] { acfp.m(2131706633) }), 1);
            localObject1 = "";
            i = 0;
            bool = false;
            localObject2 = str1;
          }
          else
          {
            ci(getResources().getString(2131694843, new Object[] { acfp.m(2131706591) }), 1);
            localObject1 = "";
            i = 0;
            bool = false;
            localObject2 = str1;
          }
        }
      }
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e))
      {
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {}
        for (localObject1 = getResources().getString(2131694833);; localObject1 = getResources().getString(2131694912))
        {
          anot.a(this.app, "dc00898", "", "", "0X800999A", "0X800999A", 2, 0, "", "", "", "");
          localObject2 = localObject3;
          i = 2;
          bool = false;
          break;
        }
      }
      if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.shGender == 1))
      {
        ci(getResources().getString(2131694834, new Object[] { acfp.m(2131706606), acfp.m(2131706606) }), 1);
        localObject2 = "";
        i = 0;
        bool = false;
        localObject1 = "";
      }
      else
      {
        ci(getResources().getString(2131694834, new Object[] { acfp.m(2131706614), acfp.m(2131706614) }), 1);
        localObject2 = "";
        i = 0;
        bool = false;
        localObject1 = "";
      }
    }
  }
  
  private void bOn()
  {
    if (this.jdField_a_of_type_Srn == null) {
      this.jdField_a_of_type_Srn = new srn(this);
    }
  }
  
  private void bOz()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "clearBGCache size = " + this.o.size());
    }
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      Drawable localDrawable = (Drawable)localIterator.next();
      if ((localDrawable instanceof FriendProfileCardBgDrawable)) {
        ((FriendProfileCardBgDrawable)localDrawable).recycle();
      } else if (aqsj.i(localDrawable)) {
        aqsj.a().ab(localDrawable);
      }
    }
    this.o.clear();
  }
  
  private void bQ(Intent paramIntent)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "initAvatarManager failed intent null");
      }
    }
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramIntent.getBundleExtra("profile_extres");
    } while ((localBundle == null) || (!localBundle.getBoolean("key_from_sdk_set_avatar", false)));
    this.jdField_a_of_type_Zsi = new zsi(this);
    this.jdField_a_of_type_Zsi.cA(paramIntent);
    this.jdField_a_of_type_Zsi.start();
  }
  
  protected void AJ(int paramInt)
  {
    if ((this.jdField_a_of_type_Alcn.drN == 1) || (this.jdField_a_of_type_Alcn.drN == 7))
    {
      int i = this.E.getIntExtra("memberOperationFlag", 0);
      this.E.putExtra("memberOperationFlag", i | paramInt);
      this.E.putExtra("memberOperateUin", this.jdField_a_of_type_Alcn.e.uin);
      setResult(-1, this.E);
    }
  }
  
  public void AK(int paramInt)
  {
    anot.a(this.app, "dc00898", "", "", "0X800A88A", "0X800A88A", paramInt, 0, "", "", "", "");
  }
  
  void AL(int paramInt)
  {
    Object localObject;
    int j;
    int i;
    if ((this.jdField_a_of_type_Alcn.cwc) && (TroopInfo.isQidianPrivateTroop(this.app, this.jdField_a_of_type_Alcn.troopUin)))
    {
      localObject = ((TroopManager)this.app.getManager(52)).c(this.jdField_a_of_type_Alcn.troopUin);
      c((TroopInfo)localObject);
      if ((((TroopInfo)localObject).isTroopAdmin(this.jdField_a_of_type_Alcn.e.uin)) || (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_Alcn.e.uin)))
      {
        j = 1;
        i = 1;
      }
    }
    for (;;)
    {
      int i1 = this.ga.getChildCount();
      int k = 0;
      for (;;)
      {
        if (k < i1)
        {
          localObject = this.ga.getChildAt(k);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          k += 1;
          continue;
          j = 0;
          i = 0;
          break;
        }
      }
      switch (paramInt)
      {
      default: 
        i = 0;
        localObject = findViewById(2131373630);
        if (i != 0)
        {
          paramInt = 0;
          ((View)localObject).setVisibility(paramInt);
          localObject = this.ga;
          if (i == 0) {
            break label1132;
          }
          paramInt = 0;
          ((LinearLayout)localObject).setVisibility(paramInt);
        }
        break;
      case 1: 
        label237:
        label255:
        if (this.jdField_a_of_type_Alcn.cwc)
        {
          if (this.jdField_a_of_type_Alcn.e.pa == 0) {
            j(this.ga.getChildAt(0), 23, 2131697233, 1, 2131692218);
          }
          j(this.ga.getChildAt(1), 81, 2131694845, 1, 2131692165);
          localObject = (acff)this.app.getManager(51);
          if (localObject == null) {
            break label1138;
          }
        }
        label327:
        break;
      }
      label1132:
      label1138:
      for (boolean bool = ((acff)localObject).isFriend(this.app.getCurrentUin());; bool = true)
      {
        if ((this.jdField_a_of_type_Alcn.e.pa == 0) && (!bool))
        {
          j(this.ga.getChildAt(2), 7, 2131694811, 2, 2131692152);
          break;
          if (aqlt.bZ(this.app))
          {
            j(this.ga.getChildAt(0), 92, 2131697234, 1, 2131697234);
            j(this.ga.getChildAt(1), 81, 2131694845, 1, 2131692165);
            break label327;
          }
          j(this.ga.getChildAt(0), 23, 2131697233, 1, 2131692218);
          j(this.ga.getChildAt(1), 81, 2131694845, 1, 2131692165);
          break label327;
        }
        j(this.ga.getChildAt(2), 8, 2131719495, 2, 2131692235);
        break;
        j(this.ga.getChildAt(1), 7, 2131694811, 1, 2131692152);
        a(this.ga.getChildAt(2), 20, this.jdField_a_of_type_Arho.CT(), 1, this.jdField_a_of_type_Arho.CT(), 0);
        j(this.ga.getChildAt(4), 8, 2131719495, 2, 2131692235);
        break;
        j(this.ga.getChildAt(1), 7, 2131694811, 1, 2131692152);
        j(this.ga.getChildAt(4), 8, 2131719495, 2, 2131692235);
        break;
        a(this.ga.getChildAt(1), 20, this.jdField_a_of_type_Arho.CT(), 1, this.jdField_a_of_type_Arho.CT(), 0);
        if ((j == 0) && (!anwa.aze()))
        {
          j(this.ga.getChildAt(2), 95, 2131701020, 1, 2131701020);
          anot.a(this.app, "", "", "", "0X800A1C4", "0X800A1C4", 0, 0, "", "", "", "");
        }
        j(this.ga.getChildAt(4), 8, 2131719495, 2, 2131692235);
        break;
        j(this.ga.getChildAt(1), 7, 2131694811, 1, 2131692152);
        a(this.ga.getChildAt(2), 20, this.jdField_a_of_type_Arho.CT(), 1, this.jdField_a_of_type_Arho.CT(), 0);
        break;
        j(this.ga.getChildAt(4), 7, 2131694811, 2, 2131692152);
        break;
        j(this.ga.getChildAt(4), 8, 2131719495, 2, 2131692235);
        break;
        a(this.ga.getChildAt(1), 20, this.jdField_a_of_type_Arho.CT(), 1, this.jdField_a_of_type_Arho.CT(), 0);
        break;
        a(this.ga.getChildAt(1), 20, this.jdField_a_of_type_Arho.CT(), 1, this.jdField_a_of_type_Arho.CT(), 0);
        break;
        j(this.ga.getChildAt(1), 59, 2131694899, 1, 2131694899);
        break;
        j(this.ga.getChildAt(1), 59, 2131694899, 1, 2131694899);
        j(this.ga.getChildAt(4), 7, 2131694811, 2, 2131692152);
        break;
        if (ProfileActivity.AllInOne.d(this.jdField_a_of_type_Alcn.e)) {
          j(this.ga.getChildAt(1), 7, 2131694811, 1, 2131692152);
        }
        for (;;)
        {
          if ((j == 0) && (!anwa.aze())) {
            j(this.ga.getChildAt(2), 77, 2131701020, 1, 2131701020);
          }
          j(this.ga.getChildAt(4), 8, 2131719495, 2, 2131692235);
          break;
          a(this.ga.getChildAt(1), 20, this.jdField_a_of_type_Arho.CT(), 1, this.jdField_a_of_type_Arho.CT(), 0);
        }
        paramInt = 8;
        break label237;
        paramInt = 8;
        break label255;
      }
      j = 0;
      i = 1;
    }
  }
  
  public void AM(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s isFromExtendFriend=%s hasScrollToExtendFriend=%s hasPause=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.aWx), Boolean.valueOf(this.aWw), Boolean.valueOf(this.aWv) }));
    }
    if ((this.aWx) && (!this.aWv) && (!this.aWw) && (!this.aWz))
    {
      this.aWw = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof VipProfileSimpleView))
      {
        ((VipProfileSimpleView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).dFS();
        paramInt = getResources().getDisplayMetrics().heightPixels / 2 + paramInt;
        paramInt -= getTitleBarHeight();
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("scrollToExtendsFriendInfo offset=%s", new Object[] { Integer.valueOf(paramInt) }));
        }
        AN(paramInt);
      }
    }
    while ((!this.aWx) || (this.aWv) || (!this.aWw)) {
      for (;;)
      {
        return;
        paramInt = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getHeight() + paramInt;
      }
    }
    this.Ga = System.currentTimeMillis();
  }
  
  public void AN(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView != null) {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPositionFromTop(0, -paramInt);
    }
  }
  
  public void AO(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "reportBusinessEntryClick serviceType=" + paramInt + ", type=" + i);
      }
      if (i != 0) {
        anot.a(this.app, "dc00898", "", "", "0X80093BF", "0X80093BF", i, 0, "", "", "", "");
      }
      return;
      i = 4;
      continue;
      i = 3;
      continue;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 0;
      continue;
      i = 6;
      continue;
      i = 5;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 10;
      continue;
      i = 11;
      continue;
      i = 0;
      continue;
      i = 9;
    }
  }
  
  public void AP(int paramInt)
  {
    Object localObject2;
    Object localObject1;
    String str1;
    label104:
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Alcn.e.pa == 40) || (this.jdField_a_of_type_Alcn.e.pa == 41) || (this.jdField_a_of_type_Alcn.e.pa == 58))
    {
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromfujinderen";
      localObject1 = "qita";
      String str2 = "0";
      if ((this.jdField_a_of_type_Alcn.e.pa != 0) && (!this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Alcn.e.uin))) {
        break label601;
      }
      str1 = aqqj.getUrl("vipPersonalCardMaster");
      if (!this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Alcn.e.uin)) {
        str2 = this.jdField_a_of_type_Alcn.e.uin;
      }
      localStringBuilder = new StringBuilder(str1);
      if (!str1.contains("?")) {
        break label612;
      }
      localStringBuilder.append("&platform=1");
      label170:
      localStringBuilder.append("&qq=" + str2);
      localStringBuilder.append("&adtag=" + (String)localObject1);
      localStringBuilder.append("&aid=" + (String)localObject2);
      if (paramInt == 1) {
        localStringBuilder.append("&jumplevelset=1");
      }
      localObject1 = localStringBuilder.toString();
      long l1 = System.currentTimeMillis();
      if (ProfileActivity.s(this.Gd, l1))
      {
        this.Gd = l1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "gotoQQVipWeb() url = " + (String)localObject1);
        }
        localObject2 = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("uin", this.app.getCurrentAccountUin());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        startActivity((Intent)localObject2);
        localObject1 = this.app;
        if (this.jdField_a_of_type_Alcn.e.pa != 0) {
          break label624;
        }
      }
    }
    label601:
    label612:
    label624:
    for (paramInt = 23;; paramInt = 24)
    {
      anot.a((QQAppInterface)localObject1, "CliOper", "", "", "vip", "logo_in", paramInt, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_Alcn.e.pa == 1) || (this.jdField_a_of_type_Alcn.e.pa == 0))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
        localObject1 = "geren";
        break;
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 20) || (this.jdField_a_of_type_Alcn.e.pa == 21))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqqqun";
        localObject1 = "qun";
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 46)
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromtaolunzu";
        localObject1 = "taolunzu";
        break;
      }
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_Alcn.e))
      {
        localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromlinshihuihua";
        localObject1 = "qita";
        break;
      }
      localObject2 = "mvip.pingtai.mobileqq.androidziliaoka.fromqita";
      localObject1 = "qita";
      break;
      str1 = aqqj.getUrl("vipPersonalCardCustom");
      break label104;
      localStringBuilder.append("?platform=1");
      break label170;
    }
  }
  
  void AQ(int paramInt)
  {
    if (paramInt == 7)
    {
      this.jdField_b_of_type_Auru.post(new FriendProfileCardActivity.41(this));
      return;
    }
    Object localObject2 = this.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.app.getCurrentNickname();
    }
    localObject2 = avpw.d.a();
    ((avpw.d)localObject2).cMP = this.app.getCurrentAccountUin();
    ((avpw.d)localObject2).nickname = ((String)localObject1);
    localObject1 = this.jdField_a_of_type_Alcn.d.vQzoneCoverInfo;
    if (QLog.isColorLevel()) {
      if (localObject1 != null) {
        break label277;
      }
    }
    label277:
    for (paramInt = 0;; paramInt = localObject1.length)
    {
      QLog.d("FriendProfileCardActivity", 2, String.format("qzGoQzoneUserHomeActivity vQzoneCoverInfo=%s length=%s", new Object[] { localObject1, Integer.valueOf(paramInt) }));
      avpw.a(this, (avpw.d)localObject2, this.jdField_a_of_type_Alcn.e.uin, this.jdField_a_of_type_Alcn.e.bIZ, -1, 5, this.jdField_a_of_type_Ahyh, (byte[])localObject1, false);
      localObject1 = new QZoneClickReport.a();
      ((QZoneClickReport.a)localObject1).actionType = "1";
      ((QZoneClickReport.a)localObject1).cMI = "0";
      ((QZoneClickReport.a)localObject1).tabletype = 4;
      ((QZoneClickReport.a)localObject1).sourceType = "3";
      ((QZoneClickReport.a)localObject1).sourceFrom = "userSummary";
      ((QZoneClickReport.a)localObject1).sourceTo = "homePage";
      QZoneClickReport.startReportImediately(this.app.getAccount(), (QZoneClickReport.a)localObject1);
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("source_type", "3");
      ((HashMap)localObject1).put("source_from", "userSummary");
      ((HashMap)localObject1).put("source_to", "homePage");
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      return;
    }
  }
  
  public void AS(int paramInt)
  {
    int i = 2131167298;
    Object localObject = getResources();
    if (paramInt == 1) {
      if ((alcs.cy(this.jdField_a_of_type_Alcn.gw())) && ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipDiyView)))
      {
        i = ((ProfileQVipDiyView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).Hy();
        paramInt = ((Resources)localObject).getColor(i);
        this.leftView.setTextColor(((Resources)localObject).getColorStateList(i));
        this.er.setTextColor(((Resources)localObject).getColorStateList(i));
        if (this.bGW < this.bGV) {
          break label188;
        }
        this.centerView.setVisibility(0);
        this.g.setVisibility(0);
      }
    }
    for (;;)
    {
      localObject = ay();
      if (localObject != null)
      {
        ((Drawable)localObject).setColorFilter(new LightingColorFilter(0, paramInt));
        this.leftView.setBackgroundDrawable((Drawable)localObject);
      }
      this.pX.setColorFilter(paramInt);
      return;
      if (ThemeUtil.isInNightMode(this.app)) {}
      for (paramInt = i;; paramInt = 2131166970)
      {
        paramInt = ((Resources)localObject).getColor(paramInt);
        this.leftView.setTextColor(paramInt);
        this.er.setTextColor(paramInt);
        break;
      }
      label188:
      this.centerView.setVisibility(4);
      this.g.setVisibility(4);
      ImmersiveUtils.setStatusTextColor(false, getWindow());
      continue;
      if (paramInt == 0)
      {
        paramInt = ((Resources)localObject).getColor(2131167298);
        this.centerView.setVisibility(0);
        this.g.setVisibility(0);
        this.leftView.setTextColor(((Resources)localObject).getColorStateList(2131167298));
        this.er.setTextColor(((Resources)localObject).getColorStateList(2131167298));
        anlm.a(this.g, getActivity().getWindow());
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  public boolean PA()
  {
    boolean bool = false;
    if (afsi.me(this.app.getCurrentAccountUin()))
    {
      if (this.P == null) {
        this.P = afyk.b(this);
      }
      if ((!this.P.isShowing()) && (!isFinishing())) {
        this.P.show();
      }
      anot.a(this.app, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
      bool = true;
    }
    return bool;
  }
  
  public boolean PB()
  {
    if (this.bGZ > 3) {
      return false;
    }
    this.bGZ += 1;
    return true;
  }
  
  public boolean PC()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.Gg != 0L)
    {
      if (Math.abs(this.Gg - NetConnInfoCenter.getServerTime()) < 60L) {
        bool1 = true;
      }
      bool2 = bool1;
      if (!bool1)
      {
        this.Gg = 0L;
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean PE()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool2 = false;
    switch (this.jdField_a_of_type_Alcn.e.pa)
    {
    default: 
      localObject2 = (acff)this.app.getManager(51);
      if ((localObject2 != null) && (((acff)localObject2).isFriend(this.jdField_a_of_type_Alcn.e.uin)))
      {
        bool1 = ((acff)localObject2).ke(this.jdField_a_of_type_Alcn.e.uin);
        return bool1;
      }
      break;
    case 41: 
    case 42: 
    case 86: 
      localObject1 = (acff)this.app.getManager(51);
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((acff)localObject1).a(this.jdField_a_of_type_Alcn.e.uin))
      {
        bool1 = bool2;
        if (localObject1 == null) {
          break;
        }
        bool1 = bool2;
        if (((Friends)localObject1).groupid != -1002) {
          break;
        }
        return true;
      }
    case 1: 
      localObject1 = (acff)this.app.getManager(51);
      if (localObject1 == null) {}
      break;
    }
    for (boolean bool1 = ((acff)localObject1).ke(this.jdField_a_of_type_Alcn.e.uin);; bool1 = false)
    {
      return bool1;
      localObject2 = (aizg)this.app.getManager(16);
      bool1 = bool2;
      if (localObject2 == null) {
        break;
      }
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e)) {
        localObject1 = this.jdField_a_of_type_Alcn.e.uin;
      }
      for (;;)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        return ((aizg)localObject2).nf((String)localObject1);
        if (ProfileActivity.AllInOne.i(this.jdField_a_of_type_Alcn.e)) {
          localObject1 = oP();
        }
      }
    }
  }
  
  public boolean PG()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).PG());
  }
  
  protected boolean Px()
  {
    return true;
  }
  
  public void ZM()
  {
    int i2 = 16;
    int i3 = 1;
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      this.centerView.setText(2131694930);
      if (this.jdField_a_of_type_Alcn.e.bJa != 6) {
        break label314;
      }
      aQ();
    }
    int j;
    int i1;
    int i;
    int k;
    for (;;)
    {
      this.leftView.setOnClickListener(new uzg(this));
      if (this.jdField_a_of_type_Alcn.e.pa != 0) {
        break label400;
      }
      if (!this.jdField_a_of_type_Alcn.cwc) {
        break label327;
      }
      j = 2131697309;
      i1 = 0;
      i = 1;
      k = 16;
      if (!this.jdField_a_of_type_Alcn.cwc) {
        break label1252;
      }
      if ((!this.jdField_a_of_type_Alcn.ats()) || (i == 0)) {
        break label1157;
      }
      i = i3;
      label126:
      if (i == 0) {
        break label1162;
      }
      this.er.setVisibility(0);
      this.er.setTag(new albb(i2, null));
      this.er.setOnClickListener(this.mOnClickListener);
      this.er.setEnabled(this.aWo);
      this.er.setText(j);
      label185:
      if (i1 == 0) {
        break label1200;
      }
      this.pX.setVisibility(0);
      this.pX.setTag(new albb(k, null));
      this.pX.setOnClickListener(this.mOnClickListener);
      this.pX.setEnabled(this.aWo);
      if (this.jdField_a_of_type_Alcn.e.pa != 0) {
        break label1174;
      }
      this.pX.setImageResource(2130840671);
      this.pX.setContentDescription(acfp.m(2131706595));
      label272:
      if (b(this.jdField_a_of_type_Alcn)) {
        break label1212;
      }
      this.pY.setVisibility(8);
      this.pY.setOnClickListener(null);
      return;
      this.centerView.setText(2131694927);
      break;
      label314:
      this.leftView.setText("");
    }
    label327:
    acff localacff = (acff)this.app.getManager(51);
    if (localacff != null) {}
    for (boolean bool = localacff.isFriend(this.app.getCurrentUin());; bool = true)
    {
      if (bool) {
        i = 98;
      }
      for (j = 2131697341;; j = 2131697342)
      {
        i1 = 1;
        int i4 = 1;
        k = 65;
        i2 = i;
        i = i4;
        break;
        i = 99;
      }
      label400:
      if ((this.jdField_a_of_type_Alcn.e.pa == 72) || (this.jdField_a_of_type_Alcn.e.pa == 71))
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 70)
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e))
      {
        if (this.aWq)
        {
          j = 2131697309;
          i1 = 0;
          i = 0;
          k = 16;
          break;
        }
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 21) || (this.jdField_a_of_type_Alcn.e.pa == 58) || (this.jdField_a_of_type_Alcn.e.pa == 22))
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 46) || (this.jdField_a_of_type_Alcn.e.pa == 47))
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 41) || (this.jdField_a_of_type_Alcn.e.pa == 42) || (this.jdField_a_of_type_Alcn.e.pa == 86))
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 56) || (this.jdField_a_of_type_Alcn.e.pa == 57))
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 80)
      {
        j = 2131697309;
        i1 = 0;
        i = 0;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 36)
      {
        j = 2131697309;
        i1 = 0;
        i = 0;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 3)
      {
        if (this.jdField_a_of_type_Alcn.e.bIW != 0) {}
        for (i = 1;; i = 0)
        {
          i1 = 0;
          j = 2131697309;
          k = 16;
          break;
        }
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 2)
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 74)
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 96)
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 95)
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 32) || (this.jdField_a_of_type_Alcn.e.pa == 31) || (this.jdField_a_of_type_Alcn.e.pa == 50) || (this.jdField_a_of_type_Alcn.e.pa == 51) || (this.jdField_a_of_type_Alcn.e.pa == 34))
      {
        i1 = 1;
        i = 0;
        k = 44;
        j = 2131697309;
        break;
      }
      if (this.jdField_a_of_type_Alcn.e.pa == 53)
      {
        if ((this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard == null) || (TextUtils.equals(this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))) {
          break label1255;
        }
        i1 = 1;
        i = 0;
        k = 44;
        j = 2131697309;
        break;
      }
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_Alcn.e))
      {
        j = 2131697309;
        i1 = 0;
        i = 1;
        k = 16;
        break;
      }
      j = 2131697309;
      i1 = 0;
      i = 0;
      k = 16;
      break;
      label1157:
      i = 0;
      break label126;
      label1162:
      this.er.setVisibility(8);
      break label185;
      label1174:
      this.pX.setBackgroundResource(2130840663);
      this.pX.setContentDescription(acfp.m(2131706630));
      break label272;
      label1200:
      this.pX.setVisibility(8);
      break label272;
      label1212:
      this.pY.setVisibility(0);
      this.pY.setTag(new albb(90, null));
      this.pY.setOnClickListener(this.jdField_a_of_type_Alcn.mOnClickListener);
      return;
      label1252:
      break label126;
      label1255:
      j = 2131697309;
      i1 = 0;
      i = 0;
      k = 16;
      break;
    }
  }
  
  Card a(String paramString1, String paramString2)
  {
    acff localacff = (acff)this.app.getManager(51);
    paramString2 = localacff.a(paramString2);
    if (paramString2 != null)
    {
      paramString1 = localacff.c(paramString1);
      paramString1.strContactName = paramString2.strContactName;
      paramString1.strMobile = paramString2.mobileNo;
      paramString1.age = paramString2.bAge;
      paramString1.shAge = ((short)paramString2.bAge);
      paramString1.shGender = ((short)paramString2.bSex);
      paramString1.strProvince = paramString2.strProvince;
      paramString1.strCity = paramString2.strCity;
      paramString1.strCountry = paramString2.strCountry;
      localacff.a(paramString1);
      return paramString1;
    }
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    bF();
    showProgressDialog();
    aqep.a(this.app, paramLong1, paramLong2, null, paramLong3, paramString);
    this.jdField_b_of_type_Auru.postDelayed(this.mDismissRunnable, this.WAIT_TIME);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "requestUpdateCard() mHasTriedCount = " + this.bHb);
    }
    if ((this.bHb > 5) && (!paramBoolean)) {}
    CardHandler localCardHandler;
    do
    {
      return;
      localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
    } while (localCardHandler == null);
    this.bHb += 1;
    byte[] arrayOfByte1;
    if (paramArrayOfByte1 == null)
    {
      arrayOfByte1 = new byte[1];
      arrayOfByte1[0] = 0;
    }
    for (;;)
    {
      byte[] arrayOfByte2;
      if (paramArrayOfByte2 == null)
      {
        arrayOfByte2 = new byte[1];
        arrayOfByte2[0] = 0;
      }
      for (;;)
      {
        int i = 12;
        byte b1 = 0;
        paramArrayOfByte1 = (adyp)this.app.getManager(112);
        if (paramArrayOfByte1 != null) {}
        for (paramBoolean = paramArrayOfByte1.iX(1);; paramBoolean = false)
        {
          long l3 = a(this.jdField_a_of_type_Alcn.e, paramBoolean);
          switch (this.jdField_a_of_type_Alcn.e.pa)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          case 9: 
          case 10: 
          case 11: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          case 17: 
          case 18: 
          case 33: 
          case 38: 
          case 39: 
          case 43: 
          case 44: 
          case 48: 
          case 49: 
          case 54: 
          case 59: 
          case 62: 
          case 63: 
          case 64: 
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 76: 
          case 79: 
          case 85: 
          case 87: 
          case 88: 
          case 89: 
          case 90: 
          case 91: 
          case 92: 
          case 93: 
          case 94: 
          case 99: 
          case 100: 
          case 106: 
          case 109: 
          case 114: 
          case 116: 
          case 117: 
          case 118: 
          case 119: 
          default: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 65535, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3999, arrayOfByte2, (byte)0);
            return;
          case 0: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 0, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.bReqMedalWallInfo);
            return;
          case 60: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 26, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.bReqMedalWallInfo);
            return;
          case 1: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.bReqMedalWallInfo);
            return;
          case 78: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 24, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 3022, arrayOfByte2, (byte)0);
            return;
          case 40: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 1, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.bReqMedalWallInfo);
            return;
          case 41: 
            i = 6;
            paramArrayOfByte1 = "";
            if ((TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.uin)) || (this.jdField_a_of_type_Alcn.e.uin.equals("0")))
            {
              i = 37;
              paramArrayOfByte1 = this.jdField_a_of_type_Alcn.e.encId;
            }
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 42: 
          case 73: 
          case 86: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 8, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
          case 36: 
            localCardHandler.a(this.app.getCurrentAccountUin(), "0", 32, paramLong, (byte)0, 0L, 0L, arrayOfByte1, a(this.jdField_a_of_type_Alcn.e), l3, 3014, arrayOfByte2, (byte)0);
            return;
          case 30: 
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 15, paramLong, (byte)1, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.bReqMedalWallInfo);
            return;
          case 29: 
          case 31: 
          case 32: 
          case 34: 
          case 50: 
          case 51: 
          case 53: 
            i = 16;
            if (this.jdField_a_of_type_Alcn.e.pa == 34) {
              i = 17;
            }
            if (this.jdField_a_of_type_Alcn.e.pa == 53) {
              i = 50;
            }
            break;
          }
          for (;;)
          {
            paramArrayOfByte1 = he(a(this.jdField_a_of_type_Alcn.e));
            localCardHandler.a(this.app.getCurrentAccountUin(), "0", i, paramLong, (byte)0, 0L, 0L, arrayOfByte1, paramArrayOfByte1, l3, 10004, null, (byte)0);
            return;
            ((alkd)this.app.getBusinessHandler(79)).On(this.jdField_a_of_type_Alcn.e.uin);
            return;
            if (this.jdField_a_of_type_Alcn.e.discussUin == null) {
              break;
            }
            long l2 = 0L;
            try
            {
              l1 = Long.valueOf(this.jdField_a_of_type_Alcn.e.discussUin).longValue();
              int j = 0;
              if (this.jdField_a_of_type_Alcn.e.pa == 45)
              {
                i = 13;
                j = 1;
                paramArrayOfByte1 = this.app.getCurrentAccountUin();
                paramArrayOfByte2 = this.jdField_a_of_type_Alcn.e.uin;
                if (j != 1) {
                  break label1442;
                }
                b1 = this.bReqMedalWallInfo;
                localCardHandler.a(paramArrayOfByte1, paramArrayOfByte2, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b1);
              }
            }
            catch (Exception paramArrayOfByte1)
            {
              for (;;)
              {
                l1 = l2;
                if (QLog.isColorLevel())
                {
                  QLog.i("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                  l1 = l2;
                  continue;
                  if (this.jdField_a_of_type_Alcn.e.pa == 46)
                  {
                    i = 4;
                  }
                  else
                  {
                    i = 14;
                    continue;
                    label1442:
                    b1 = 0;
                  }
                }
              }
            }
            long l1 = aqep.a(this.app, this.jdField_a_of_type_Alcn.e);
            if (this.jdField_a_of_type_Alcn.e.pa == 20)
            {
              i = 2;
              b1 = 1;
              paramArrayOfByte1 = this.app.getCurrentAccountUin();
              paramArrayOfByte2 = this.jdField_a_of_type_Alcn.e.uin;
              if (b1 != 1) {
                break label1612;
              }
            }
            label1612:
            for (byte b2 = this.bReqMedalWallInfo;; b2 = 0)
            {
              localCardHandler.a(paramArrayOfByte1, paramArrayOfByte2, i, paramLong, b1, l1, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, b2);
              return;
              if ((this.jdField_a_of_type_Alcn.e.pa == 21) || (this.jdField_a_of_type_Alcn.e.pa == 58))
              {
                i = 5;
                b1 = 0;
                break;
              }
              if (this.jdField_a_of_type_Alcn.e.pa != 22) {
                break;
              }
              i = 7;
              b1 = 0;
              break;
            }
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 21, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 10, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 31, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3001, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 38, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3017, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 27, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 36, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
            return;
            if ((this.jdField_a_of_type_Alcn.e.bJb == 3004) || (this.jdField_a_of_type_Alcn.e.bJb == 2004)) {
              if (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.troopcode)) {}
            }
            label2843:
            label2851:
            for (paramArrayOfByte1 = this.jdField_a_of_type_Alcn.e.troopcode;; paramArrayOfByte1 = "0")
            {
              paramArrayOfByte2 = paramArrayOfByte1;
              if (paramArrayOfByte1 == null) {}
              for (paramArrayOfByte2 = "0";; paramArrayOfByte2 = "0")
              {
                for (;;)
                {
                  l2 = 0L;
                  try
                  {
                    l1 = Long.parseLong(paramArrayOfByte2);
                    i = 11;
                    if (this.jdField_a_of_type_Alcn.e.pa == 27) {
                      i = 35;
                    }
                    localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, i, paramLong, (byte)0, l1, 0L, arrayOfByte1, "", l3, this.jdField_a_of_type_Alcn.e.bJb, arrayOfByte2, (byte)0);
                    return;
                    if (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.troopUin)) {
                      break label2851;
                    }
                    paramArrayOfByte1 = (TroopInfo)this.app.a().createEntityManager().find(TroopInfo.class, "troopcode=?", new String[] { this.jdField_a_of_type_Alcn.e.troopUin });
                    if (paramArrayOfByte1 == null) {
                      break label2851;
                    }
                    paramArrayOfByte1 = paramArrayOfByte1.troopuin;
                    break;
                    if ((this.jdField_a_of_type_Alcn.e.bJb != 3005) && (this.jdField_a_of_type_Alcn.e.bJb != 2005)) {
                      break label2843;
                    }
                    paramArrayOfByte2 = this.jdField_a_of_type_Alcn.e.troopcode;
                  }
                  catch (Exception paramArrayOfByte1)
                  {
                    for (;;)
                    {
                      l1 = l2;
                      if (QLog.isColorLevel())
                      {
                        QLog.e("Q.profilecard.FrdProfileCard", 2, paramArrayOfByte1.toString());
                        l1 = l2;
                      }
                    }
                  }
                }
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 24, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3095, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3096, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 28, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, this.bReqMedalWallInfo);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 29, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 30, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 34, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 33, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 10004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 25, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3045, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 53, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3094, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3004, arrayOfByte2, (byte)0);
                return;
                localCardHandler.a(this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.e.uin, 12, paramLong, (byte)0, 0L, 0L, arrayOfByte1, "", l3, 3080, arrayOfByte2, (byte)0);
                return;
              }
            }
          }
        }
        arrayOfByte2 = paramArrayOfByte2;
      }
      arrayOfByte1 = paramArrayOfByte1;
    }
  }
  
  public void a(SSummaryCardRsp paramSSummaryCardRsp)
  {
    if (!isFinishing())
    {
      if (TextUtils.isEmpty(paramSSummaryCardRsp.strActiveCardUrl)) {
        break label144;
      }
      if (!QLog.isColorLevel()) {
        break label92;
      }
      QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to " + paramSSummaryCardRsp.strActiveCardUrl);
    }
    for (;;)
    {
      aqep.i(this, paramSSummaryCardRsp.bgid, paramSSummaryCardRsp.strActiveCardUrl);
      return;
      label92:
      QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " bgid=" + paramSSummaryCardRsp.bgid + " and jump to url");
    }
    label144:
    bFU();
    String str1 = getString(2131700888);
    String str2 = paramSSummaryCardRsp.emsg;
    int i = paramSSummaryCardRsp.payType;
    String str3 = paramSSummaryCardRsp.aid;
    if ((TextUtils.isEmpty(str3)) || (i <= 0) || (i == 3) || (i > 7))
    {
      QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card failed code=" + paramSSummaryCardRsp.res + " and aid=" + str3 + " pay type=" + i);
      Toast.makeText(getApplicationContext(), 2131697311, 0).show();
      return;
    }
    QLog.e("QVipProfileCard.FriendProfileCardActivity", 1, "set friend profile card show:" + str2 + " and aid=" + str3 + " pay type=" + i);
    this.z = aqha.a(this, 0, str1, str2, 2131697251, 2131697252, new vai(this, str3, i), this.w);
    this.z.show();
  }
  
  public void a(albg paramalbg)
  {
    this.jdField_a_of_type_Albg = paramalbg;
  }
  
  /* Error */
  public void a(alcn paramalcn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   6: ldc_w 2585
    //   9: iconst_1
    //   10: invokevirtual 2590	aqmv:dn	(Ljava/lang/String;Z)V
    //   13: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +30 -> 46
    //   19: ldc_w 659
    //   22: iconst_2
    //   23: ldc_w 2592
    //   26: iconst_1
    //   27: anewarray 244	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 276	com/tencent/mobileqq/activity/FriendProfileCardActivity:qC	Z
    //   36: invokestatic 1398	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: aastore
    //   40: invokestatic 1797	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 276	com/tencent/mobileqq/activity/FriendProfileCardActivity:qC	Z
    //   50: iconst_1
    //   51: if_icmpeq +21 -> 72
    //   54: aload_1
    //   55: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   58: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   61: ldc_w 2048
    //   64: invokevirtual 1285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: istore_3
    //   68: iload_3
    //   69: ifeq +6 -> 75
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: aload_1
    //   76: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   79: astore 6
    //   81: aload 6
    //   83: ifnull +74 -> 157
    //   86: invokestatic 2595	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   89: lstore 4
    //   91: lload 4
    //   93: aload_0
    //   94: getfield 321	com/tencent/mobileqq/activity/FriendProfileCardActivity:uA	J
    //   97: lsub
    //   98: invokestatic 2318	java/lang/Math:abs	(J)J
    //   101: ldc2_w 2596
    //   104: lcmp
    //   105: ifle +234 -> 339
    //   108: aload_0
    //   109: lload 4
    //   111: putfield 321	com/tencent/mobileqq/activity/FriendProfileCardActivity:uA	J
    //   114: aload_0
    //   115: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: iconst_2
    //   119: invokevirtual 700	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   122: checkcast 2447	com/tencent/mobileqq/app/CardHandler
    //   125: astore 6
    //   127: aload 6
    //   129: ifnull +28 -> 157
    //   132: aload_1
    //   133: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   136: getfield 1627	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   139: invokestatic 2601	aqmr:isEmpty	(Ljava/lang/String;)Z
    //   142: ifne +15 -> 157
    //   145: aload 6
    //   147: aload_1
    //   148: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   151: getfield 1627	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   154: invokevirtual 2604	com/tencent/mobileqq/app/CardHandler:Ds	(Ljava/lang/String;)V
    //   157: aload_1
    //   158: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   161: astore 6
    //   163: aload 6
    //   165: ifnull +901 -> 1066
    //   168: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +36 -> 207
    //   174: ldc_w 2606
    //   177: iconst_1
    //   178: new 587	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 2608
    //   188: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_1
    //   192: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   195: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   198: invokevirtual 2525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   201: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: invokestatic 2614	anlm:ayn	()Z
    //   210: ifeq +181 -> 391
    //   213: ldc_w 659
    //   216: iconst_1
    //   217: ldc_w 2616
    //   220: invokestatic 1055	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iconst_0
    //   224: istore_2
    //   225: iload_2
    //   226: ifne +55 -> 281
    //   229: aload_1
    //   230: aconst_null
    //   231: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   234: aload_0
    //   235: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   238: aconst_null
    //   239: putfield 2621	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   242: aload_0
    //   243: new 2337	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   246: dup
    //   247: aload_0
    //   248: aload_1
    //   249: aload_0
    //   250: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   253: aload_0
    //   254: getfield 2623	com/tencent/mobileqq/activity/FriendProfileCardActivity:Dq	Landroid/widget/TextView;
    //   257: aload_0
    //   258: getfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   261: invokespecial 2626	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   264: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   267: aload_0
    //   268: aload_0
    //   269: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   272: lconst_0
    //   273: lconst_0
    //   274: invokevirtual 2629	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJ)V
    //   277: aload_0
    //   278: invokevirtual 2632	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOK	()V
    //   281: aload_0
    //   282: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   285: ifnull +32 -> 317
    //   288: aload_0
    //   289: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   292: getfield 2636	com/tencent/mobileqq/profile/view/ProfileHeaderView:mt	Ljava/util/HashMap;
    //   295: ldc_w 2638
    //   298: aload_0
    //   299: ldc_w 2639
    //   302: invokevirtual 1951	com/tencent/mobileqq/activity/FriendProfileCardActivity:findViewById	(I)Landroid/view/View;
    //   305: invokevirtual 2192	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   308: pop
    //   309: aload_0
    //   310: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   313: aload_1
    //   314: invokevirtual 2641	com/tencent/mobileqq/profile/view/ProfileHeaderView:l	(Lalcn;)V
    //   317: aload_0
    //   318: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   321: ldc_w 2643
    //   324: ldc_w 2585
    //   327: iconst_0
    //   328: invokevirtual 2647	aqmv:X	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   331: goto -259 -> 72
    //   334: astore_1
    //   335: aload_0
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    //   339: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq -185 -> 157
    //   345: ldc_w 659
    //   348: iconst_2
    //   349: ldc_w 2649
    //   352: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -198 -> 157
    //   358: astore 6
    //   360: ldc_w 659
    //   363: iconst_1
    //   364: new 587	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   371: ldc_w 2651
    //   374: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 6
    //   379: invokevirtual 2654	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 791	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: goto -231 -> 157
    //   391: aload_1
    //   392: getfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   395: ifnull +538 -> 933
    //   398: aload_1
    //   399: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   402: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   405: lstore 4
    //   407: aload_0
    //   408: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   411: aload_1
    //   412: getfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   415: putfield 2621	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   418: lload 4
    //   420: getstatic 2657	alcs:agd	J
    //   423: lcmp
    //   424: ifeq +21 -> 445
    //   427: lload 4
    //   429: getstatic 2660	alcs:agf	J
    //   432: lcmp
    //   433: ifeq +12 -> 445
    //   436: lload 4
    //   438: getstatic 2663	alcs:agg	J
    //   441: lcmp
    //   442: ifne +105 -> 547
    //   445: aload_0
    //   446: new 2665	com/tencent/mobileqq/profile/view/ProfileGameView
    //   449: dup
    //   450: aload_0
    //   451: aload_1
    //   452: invokespecial 2668	com/tencent/mobileqq/profile/view/ProfileGameView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;)V
    //   455: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   458: aload_0
    //   459: lload 4
    //   461: putfield 2670	com/tencent/mobileqq/activity/FriendProfileCardActivity:Gb	J
    //   464: aload_0
    //   465: aload_1
    //   466: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   469: invokestatic 2673	alcs:a	(Lcom/tencent/mobileqq/data/Card;)J
    //   472: putfield 2675	com/tencent/mobileqq/activity/FriendProfileCardActivity:Gc	J
    //   475: aload_0
    //   476: aload_1
    //   477: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   480: invokevirtual 2679	com/tencent/mobileqq/data/Card:getBgTypeArray	()Ljava/util/ArrayList;
    //   483: putfield 2681	com/tencent/mobileqq/activity/FriendProfileCardActivity:bgtype	Ljava/util/ArrayList;
    //   486: aload_0
    //   487: aload_0
    //   488: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   491: aload_1
    //   492: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   495: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   498: aload_1
    //   499: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   502: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   505: aload_1
    //   506: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   509: getfield 2687	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   512: aload_1
    //   513: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   516: getfield 2690	com/tencent/mobileqq/data/Card:strExtInfo	Ljava/lang/String;
    //   519: invokevirtual 2693	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJJLjava/lang/String;)V
    //   522: aload_0
    //   523: invokevirtual 2632	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOK	()V
    //   526: aload_0
    //   527: invokevirtual 2694	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   530: ldc_w 2696
    //   533: iconst_0
    //   534: invokevirtual 1247	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   537: ifne +709 -> 1246
    //   540: aload_0
    //   541: invokevirtual 2699	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOL	()V
    //   544: goto +702 -> 1246
    //   547: lload 4
    //   549: getstatic 2702	alcs:agh	J
    //   552: lcmp
    //   553: ifne +68 -> 621
    //   556: aload_0
    //   557: new 2704	com/tencent/mobileqq/profile/view/ProfilePhotoView
    //   560: dup
    //   561: aload_0
    //   562: aload_1
    //   563: invokespecial 2705	com/tencent/mobileqq/profile/view/ProfilePhotoView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;)V
    //   566: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   569: goto -111 -> 458
    //   572: astore 6
    //   574: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +34 -> 611
    //   580: ldc_w 659
    //   583: iconst_2
    //   584: new 587	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   591: ldc_w 2707
    //   594: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 6
    //   599: invokevirtual 1068	java/lang/Exception:toString	()Ljava/lang/String;
    //   602: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   611: aload 6
    //   613: invokevirtual 1435	java/lang/Exception:printStackTrace	()V
    //   616: iconst_0
    //   617: istore_2
    //   618: goto -393 -> 225
    //   621: lload 4
    //   623: getstatic 2710	alcs:agi	J
    //   626: lcmp
    //   627: ifne +19 -> 646
    //   630: aload_0
    //   631: new 2712	com/tencent/mobileqq/profile/view/ProfileTagView
    //   634: dup
    //   635: aload_0
    //   636: aload_1
    //   637: invokespecial 2713	com/tencent/mobileqq/profile/view/ProfileTagView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;)V
    //   640: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   643: goto -185 -> 458
    //   646: aload_1
    //   647: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   650: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   653: getstatic 2716	alcs:agn	J
    //   656: lcmp
    //   657: ifne +31 -> 688
    //   660: aload_0
    //   661: new 2718	com/tencent/mobileqq/profile/view/ProfileQVipV5View
    //   664: dup
    //   665: aload_0
    //   666: aload_1
    //   667: aload_0
    //   668: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   671: aload_0
    //   672: getfield 2623	com/tencent/mobileqq/activity/FriendProfileCardActivity:Dq	Landroid/widget/TextView;
    //   675: aload_0
    //   676: getfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   679: invokespecial 2719	com/tencent/mobileqq/profile/view/ProfileQVipV5View:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   682: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   685: goto -227 -> 458
    //   688: aload_1
    //   689: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   692: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   695: invokestatic 2222	alcs:cy	(J)Z
    //   698: ifeq +48 -> 746
    //   701: aload_0
    //   702: new 2224	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   705: dup
    //   706: aload_0
    //   707: aload_1
    //   708: aload_0
    //   709: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   712: aload_0
    //   713: getfield 575	com/tencent/mobileqq/activity/FriendProfileCardActivity:root	Landroid/view/View;
    //   716: checkcast 581	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   719: aload_0
    //   720: getfield 2721	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_aT_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   723: aload_0
    //   724: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   727: invokespecial 2724	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/view/ViewGroup;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;)V
    //   730: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   733: aload_0
    //   734: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   737: checkcast 2224	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   740: invokevirtual 2727	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:dFK	()V
    //   743: goto -285 -> 458
    //   746: lload 4
    //   748: getstatic 2730	alcs:agj	J
    //   751: lcmp
    //   752: ifne +19 -> 771
    //   755: aload_0
    //   756: new 2005	com/tencent/mobileqq/profile/view/VipProfileSimpleView
    //   759: dup
    //   760: aload_0
    //   761: aload_1
    //   762: invokespecial 2731	com/tencent/mobileqq/profile/view/VipProfileSimpleView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;)V
    //   765: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   768: goto -310 -> 458
    //   771: lload 4
    //   773: getstatic 2734	alcs:agk	J
    //   776: lcmp
    //   777: ifne +81 -> 858
    //   780: aload_0
    //   781: ldc_w 302
    //   784: iconst_0
    //   785: invokevirtual 2735	com/tencent/mobileqq/activity/FriendProfileCardActivity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   788: aload_0
    //   789: getfield 304	com/tencent/mobileqq/activity/FriendProfileCardActivity:aNh	Ljava/lang/String;
    //   792: iconst_1
    //   793: invokeinterface 1736 3 0
    //   798: ifeq +19 -> 817
    //   801: aload_0
    //   802: new 2737	com/tencent/mobileqq/profile/view/ProfileShoppingView
    //   805: dup
    //   806: aload_0
    //   807: aload_1
    //   808: invokespecial 2738	com/tencent/mobileqq/profile/view/ProfileShoppingView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;)V
    //   811: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   814: goto -356 -> 458
    //   817: aload_1
    //   818: aconst_null
    //   819: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   822: aload_0
    //   823: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   826: aconst_null
    //   827: putfield 2621	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   830: aload_0
    //   831: new 2337	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   834: dup
    //   835: aload_0
    //   836: aload_1
    //   837: aload_0
    //   838: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   841: aload_0
    //   842: getfield 2623	com/tencent/mobileqq/activity/FriendProfileCardActivity:Dq	Landroid/widget/TextView;
    //   845: aload_0
    //   846: getfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   849: invokespecial 2626	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   852: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   855: goto -397 -> 458
    //   858: lload 4
    //   860: getstatic 2741	alcs:agm	J
    //   863: lcmp
    //   864: ifeq +12 -> 876
    //   867: lload 4
    //   869: getstatic 2744	alcs:agl	J
    //   872: lcmp
    //   873: ifne +19 -> 892
    //   876: aload_0
    //   877: new 2746	com/tencent/mobileqq/profile/view/VipProfileWZRYView
    //   880: dup
    //   881: aload_0
    //   882: aload_1
    //   883: invokespecial 2747	com/tencent/mobileqq/profile/view/VipProfileWZRYView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;)V
    //   886: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   889: goto -431 -> 458
    //   892: aload_1
    //   893: aconst_null
    //   894: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   897: aload_0
    //   898: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   901: aconst_null
    //   902: putfield 2621	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   905: aload_0
    //   906: new 2337	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   909: dup
    //   910: aload_0
    //   911: aload_1
    //   912: aload_0
    //   913: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   916: aload_0
    //   917: getfield 2623	com/tencent/mobileqq/activity/FriendProfileCardActivity:Dq	Landroid/widget/TextView;
    //   920: aload_0
    //   921: getfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   924: invokespecial 2626	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   927: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   930: goto -472 -> 458
    //   933: aload_1
    //   934: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   937: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   940: invokestatic 2222	alcs:cy	(J)Z
    //   943: ifeq -327 -> 616
    //   946: aload_0
    //   947: new 2224	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   950: dup
    //   951: aload_0
    //   952: aload_1
    //   953: aload_0
    //   954: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   957: aload_0
    //   958: getfield 575	com/tencent/mobileqq/activity/FriendProfileCardActivity:root	Landroid/view/View;
    //   961: checkcast 581	com/tencent/mobileqq/widget/PerfRelativeLayout
    //   964: aload_0
    //   965: getfield 2721	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_aT_of_type_AndroidWidgetFrameLayout	Landroid/widget/FrameLayout;
    //   968: aload_0
    //   969: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   972: invokespecial 2724	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/view/ViewGroup;Landroid/widget/FrameLayout;Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;)V
    //   975: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   978: aload_0
    //   979: aload_1
    //   980: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   983: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   986: putfield 2670	com/tencent/mobileqq/activity/FriendProfileCardActivity:Gb	J
    //   989: aload_0
    //   990: aload_1
    //   991: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   994: invokestatic 2673	alcs:a	(Lcom/tencent/mobileqq/data/Card;)J
    //   997: putfield 2675	com/tencent/mobileqq/activity/FriendProfileCardActivity:Gc	J
    //   1000: aload_0
    //   1001: aload_1
    //   1002: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   1005: invokevirtual 2679	com/tencent/mobileqq/data/Card:getBgTypeArray	()Ljava/util/ArrayList;
    //   1008: putfield 2681	com/tencent/mobileqq/activity/FriendProfileCardActivity:bgtype	Ljava/util/ArrayList;
    //   1011: aload_0
    //   1012: aload_0
    //   1013: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1016: aload_1
    //   1017: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   1020: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1023: aload_1
    //   1024: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   1027: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   1030: aload_1
    //   1031: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   1034: getfield 2687	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   1037: aload_1
    //   1038: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   1041: getfield 2690	com/tencent/mobileqq/data/Card:strExtInfo	Ljava/lang/String;
    //   1044: invokevirtual 2693	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJJLjava/lang/String;)V
    //   1047: aload_0
    //   1048: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1051: checkcast 2224	com/tencent/mobileqq/profile/view/ProfileQVipDiyView
    //   1054: invokevirtual 2727	com/tencent/mobileqq/profile/view/ProfileQVipDiyView:dFK	()V
    //   1057: aload_0
    //   1058: invokevirtual 2632	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOK	()V
    //   1061: iconst_1
    //   1062: istore_2
    //   1063: goto -838 -> 225
    //   1066: aload_1
    //   1067: getfield 1108	alcn:jdField_a_of_type_ComTencentMobileqqDataContactCard	Lcom/tencent/mobileqq/data/ContactCard;
    //   1070: ifnonnull +15 -> 1085
    //   1073: aload_1
    //   1074: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1077: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1080: bipush 33
    //   1082: if_icmpne +74 -> 1156
    //   1085: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1088: ifeq +13 -> 1101
    //   1091: ldc_w 1002
    //   1094: iconst_2
    //   1095: ldc_w 2749
    //   1098: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1101: aload_0
    //   1102: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   1105: aconst_null
    //   1106: putfield 2621	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   1109: aload_1
    //   1110: aconst_null
    //   1111: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1114: aload_0
    //   1115: new 2337	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   1118: dup
    //   1119: aload_0
    //   1120: aload_1
    //   1121: aload_0
    //   1122: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   1125: aload_0
    //   1126: getfield 2623	com/tencent/mobileqq/activity/FriendProfileCardActivity:Dq	Landroid/widget/TextView;
    //   1129: aload_0
    //   1130: getfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   1133: invokespecial 2626	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   1136: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1139: aload_0
    //   1140: aload_0
    //   1141: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1144: lconst_0
    //   1145: lconst_0
    //   1146: invokevirtual 2629	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJ)V
    //   1149: aload_0
    //   1150: invokevirtual 2632	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOK	()V
    //   1153: goto -872 -> 281
    //   1156: aload_1
    //   1157: getfield 2752	alcn:jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo	Lcom/tencent/mobileqq/qcall/QCallCardInfo;
    //   1160: ifnonnull +15 -> 1175
    //   1163: aload_1
    //   1164: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1167: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1170: bipush 80
    //   1172: if_icmpne -891 -> 281
    //   1175: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1178: ifeq +13 -> 1191
    //   1181: ldc_w 1002
    //   1184: iconst_2
    //   1185: ldc_w 2754
    //   1188: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1191: aload_0
    //   1192: getfield 1366	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView	Lcom/tencent/mobileqq/widget/ProfileCardMoreInfoView;
    //   1195: aconst_null
    //   1196: putfield 2621	com/tencent/mobileqq/widget/ProfileCardMoreInfoView:e	Lalcs;
    //   1199: aload_1
    //   1200: aconst_null
    //   1201: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1204: aload_0
    //   1205: new 2337	com/tencent/mobileqq/profile/view/ProfileBaseView
    //   1208: dup
    //   1209: aload_0
    //   1210: aload_1
    //   1211: aload_0
    //   1212: getfield 525	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView	Lcom/tencent/widget/PullToZoomHeaderListView;
    //   1215: aload_0
    //   1216: getfield 2623	com/tencent/mobileqq/activity/FriendProfileCardActivity:Dq	Landroid/widget/TextView;
    //   1219: aload_0
    //   1220: getfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   1223: invokespecial 2626	com/tencent/mobileqq/profile/view/ProfileBaseView:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lalcn;Lcom/tencent/widget/PullToZoomHeaderListView;Landroid/widget/TextView;Z)V
    //   1226: putfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1229: aload_0
    //   1230: aload_0
    //   1231: getfield 1546	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView	Lcom/tencent/mobileqq/profile/view/ProfileHeaderView;
    //   1234: lconst_0
    //   1235: lconst_0
    //   1236: invokevirtual 2629	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Landroid/view/View;JJ)V
    //   1239: aload_0
    //   1240: invokevirtual 2632	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOK	()V
    //   1243: goto -962 -> 281
    //   1246: iconst_1
    //   1247: istore_2
    //   1248: goto -1023 -> 225
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1251	0	this	FriendProfileCardActivity
    //   0	1251	1	paramalcn	alcn
    //   224	1024	2	i	int
    //   67	2	3	bool	boolean
    //   89	779	4	l1	long
    //   79	85	6	localObject	Object
    //   358	20	6	localThrowable	Throwable
    //   572	40	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	46	334	finally
    //   46	68	334	finally
    //   75	81	334	finally
    //   86	127	334	finally
    //   132	157	334	finally
    //   157	163	334	finally
    //   168	207	334	finally
    //   207	223	334	finally
    //   229	281	334	finally
    //   281	317	334	finally
    //   317	331	334	finally
    //   339	355	334	finally
    //   360	388	334	finally
    //   391	445	334	finally
    //   445	458	334	finally
    //   458	544	334	finally
    //   547	569	334	finally
    //   574	611	334	finally
    //   611	616	334	finally
    //   621	643	334	finally
    //   646	685	334	finally
    //   688	743	334	finally
    //   746	768	334	finally
    //   771	814	334	finally
    //   817	855	334	finally
    //   858	876	334	finally
    //   876	889	334	finally
    //   892	930	334	finally
    //   933	1061	334	finally
    //   1066	1085	334	finally
    //   1085	1101	334	finally
    //   1101	1153	334	finally
    //   1156	1175	334	finally
    //   1175	1191	334	finally
    //   1191	1243	334	finally
    //   86	127	358	java/lang/Throwable
    //   132	157	358	java/lang/Throwable
    //   339	355	358	java/lang/Throwable
    //   168	207	572	java/lang/Exception
    //   207	223	572	java/lang/Exception
    //   391	445	572	java/lang/Exception
    //   445	458	572	java/lang/Exception
    //   458	544	572	java/lang/Exception
    //   547	569	572	java/lang/Exception
    //   621	643	572	java/lang/Exception
    //   646	685	572	java/lang/Exception
    //   688	743	572	java/lang/Exception
    //   746	768	572	java/lang/Exception
    //   771	814	572	java/lang/Exception
    //   817	855	572	java/lang/Exception
    //   858	876	572	java/lang/Exception
    //   876	889	572	java/lang/Exception
    //   892	930	572	java/lang/Exception
    //   933	1061	572	java/lang/Exception
  }
  
  public void a(alcn paramalcn, boolean paramBoolean)
  {
    Object localObject = this.cT.getChildAt(0);
    if (((localObject instanceof ProfileHeaderView)) && (!paramalcn.e.uin.equals("0")))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView update");
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView mCurrentHeaderStyle=" + this.Gb);
      }
      long l1 = alcs.a(paramalcn.d);
      if ((paramalcn.d != null) && ((paramalcn.d.lCurrentStyleId != this.Gb) || (l1 > this.Gc)))
      {
        QLog.e("DIYProfileTemplate.FriendProfileCardActivity", 1, "it have change the template form" + this.Gb + " , " + this.Gc + " to " + paramalcn.d.lCurrentStyleId + " , " + l1);
        this.qC = false;
        a(paramalcn);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.requestLayout();
      return;
      ((ProfileHeaderView)localObject).b(paramalcn, paramBoolean);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateHeaderView headerView is loading");
      }
      a(paramalcn);
      if (((localObject instanceof ProfileHeaderView)) && (paramalcn.e.pa == 53))
      {
        localObject = (ProfileHeaderView)localObject;
        ((ProfileHeaderView)localObject).f(paramalcn);
        ((ProfileHeaderView)localObject).a(paramalcn.e);
      }
    }
  }
  
  void a(View paramView, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    int i = 2131167335;
    if (paramView == null) {}
    do
    {
      return;
      albb localalbb = new albb(paramInt1, null);
      paramView.setVisibility(0);
      if (paramInt2 == 0)
      {
        paramView = (ImageButton)paramView.findViewById(2131368962);
        paramView.setTag(localalbb);
        paramView.setOnClickListener(this.mOnClickListener);
        paramView.setImageResource(paramInt3);
        paramView.setContentDescription(paramString2);
        return;
      }
      paramView = (Button)paramView.findViewById(2131381048);
      paramView.setTag(localalbb);
      paramView.setOnClickListener(this.mOnClickListener);
      paramView.setContentDescription(paramString2);
      paramView.setText(paramString1);
      if ((!gc(paramInt1)) || (this.aWo)) {
        break;
      }
      paramView.setTextColor(getResources().getColor(2131167379));
      paramView.setEnabled(this.aWo);
    } while ((7 != paramInt1) || (!QSecFramework.a().c(1001).booleanValue()));
    QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(1), paramView }, null);
    return;
    if (paramInt2 == 2)
    {
      paramInt2 = 2131167335;
      label201:
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label239;
      }
      paramInt2 = i;
    }
    label239:
    for (;;)
    {
      paramView.setTextColor(getResources().getColor(paramInt2));
      break;
      paramInt2 = 2131167337;
      break label201;
    }
  }
  
  public void a(View paramView, long paramLong1, long paramLong2)
  {
    a(paramView, paramLong1, paramLong2, 0L, null);
  }
  
  void a(View paramView, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if ((this.cT != null) && (paramView != null))
    {
      if (this.jdField_b_of_type_Auru != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "changeProfileHeaderView success remove timeout msg");
        }
        this.jdField_b_of_type_Auru.removeMessages(10);
      }
      Object localObject = (ImageView)this.mContentView.findViewById(2131369164);
      if (localObject != null) {}
      try
      {
        localObject = (Animatable)((ImageView)localObject).getDrawable();
        if ((localObject != null) && (((Animatable)localObject).isRunning())) {
          ((Animatable)localObject).stop();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          int i;
          localException.printStackTrace();
        }
        this.cT.removeAllViews();
        this.cT.addView(paramView);
        this.qC = true;
        this.FX = paramLong1;
        this.FY = paramLong2;
        this.aNe = paramString;
        this.FZ = paramLong3;
        if ((paramView == null) || (!(paramView instanceof ProfileBaseView)) || (!QSecFramework.a().c(1001).booleanValue())) {
          break label273;
        }
        paramView = (View)((ProfileBaseView)paramView).mt.get("map_key_like");
        QSecFramework.a().sendCmdToLib(5, 0, 1, new Object[] { Integer.valueOf(24), paramView }, null);
      }
      j = this.cT.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = this.cT.getChildAt(i);
        if ((localObject instanceof ProfileHeaderView)) {
          ((ProfileHeaderView)localObject).onDestroy();
        }
        i += 1;
      }
    }
    label273:
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.eiy();
    if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) && (this.sD != null)) {
      this.sD.setVisibility(8);
    }
    this.jdField_a_of_type_Aqmv.dn("headerViewLoadingEnd", false);
  }
  
  public void a(argj paramargj)
  {
    this.jdField_a_of_type_Argj = paramargj;
  }
  
  public void a(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$b = paramb;
  }
  
  public void a(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    Intent localIntent;
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.phoneNumber;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label149;
      }
      localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + paramCardContactInfo));
    }
    for (;;)
    {
      try
      {
        startActivity(localIntent);
        this.app.a().Oq(paramCardContactInfo);
        anot.a(this.app, "CliOper", "", "", "P_prof", "call", eP(this.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(a(this.jdField_a_of_type_Alcn.e)), "", "", "");
        return;
        paramCardContactInfo = null;
      }
      catch (Exception localException)
      {
        QLog.e("FriendProfileCardActivity", 1, "callContact fail.", localException);
        continue;
      }
      label149:
      cf(2131694849, 1);
    }
  }
  
  public void a(Card paramCard, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onSwitchedToFriend, uin: " + paramString + ", card = " + paramCard);
    }
    long l1;
    if (this.jdField_a_of_type_Alcn.e.pa == 33)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.containsKey("map_key_qzonecover"))) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.fz(paramString, 1);
      }
      e(this.ga);
      this.jdField_a_of_type_Alcn.e.pa = 1;
      this.jdField_a_of_type_Alcn.e.uin = paramString;
      xm(true);
      l1 = 0L;
      if (paramCard == null) {
        break label279;
      }
      l1 = paramCard.feedPreviewTime;
      paramString = paramCard.vSeed;
      this.jdField_a_of_type_Alcn.d = paramCard;
      a(paramCard, false);
      paramCard = paramString;
      label161:
      if ((this.jdField_a_of_type_Alcn.e.pa != 56) && (this.jdField_a_of_type_Alcn.e.pa != 57)) {
        break label288;
      }
    }
    label279:
    label288:
    for (paramString = this.jdField_a_of_type_Alcn.e.cf;; paramString = null)
    {
      a(l1, paramCard, paramString, true);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.containsKey("map_key_qzonecover"))) {
        break;
      }
      ProfileHeaderView localProfileHeaderView = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      String str = this.jdField_a_of_type_Alcn.e.uin;
      if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e)) {
        i = 1;
      }
      localProfileHeaderView.fz(str, i);
      break;
      bOx();
      paramCard = null;
      break label161;
    }
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    int j = 99999;
    this.jdField_a_of_type_Aqmv.dn("initUpdateInfoStart", true);
    Object localObject2;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("updateInfo Card=");
      if (paramCard != null)
      {
        localObject1 = paramCard.getProfileCardDesc();
        QLog.i("Q.profilecard.FrdProfileCard", 2, (String)localObject1 + " isNetRet = " + paramBoolean);
      }
    }
    else
    {
      this.jdField_a_of_type_Alcn.d = paramCard;
      ZM();
      a(this.jdField_a_of_type_Alcn, paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, paramBoolean, new String[0]);
      if ((aeqy.c().mIsNotifyPayment) && (paramBoolean) && (acha.isLocaleCN()))
      {
        localObject1 = (aqrc)this.app.getManager(235);
        i = ((aqrc)localObject1).Ms();
        QLog.e("QQLevelNotice", 1, "getShowQQLevelNoticeValue: " + i + "," + this.jdField_a_of_type_Alcn.e.pa);
        if ((i != 0) && (this.jdField_a_of_type_Alcn.e.pa == 0))
        {
          localObject2 = aqrc.gi(i);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            TextView localTextView = (TextView)this.mContentView.findViewById(2131374916);
            localTextView.setText((CharSequence)localObject2);
            localTextView.setVisibility(0);
            ((aqrc)localObject1).XR(0);
            localTextView.setOnClickListener(new uzh(this, localTextView, i));
          }
        }
      }
      xl(paramBoolean);
      if ((paramBoolean) && (paramCard != null) && ((paramCard.lCurrentStyleId != alcs.agi) || (this.jdField_a_of_type_Alcn.e.bIY == 1))) {
        bOy();
      }
      if ((this.jdField_b_of_type_Swe != null) && (this.jdField_b_of_type_Swe.isShowing()) && (this.jdField_a_of_type_Alcn.d != null))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.strReMark)) {
          break label507;
        }
        this.jdField_b_of_type_Swe.tV(this.jdField_a_of_type_Alcn.d.strReMark + getResources().getString(2131700726));
      }
      label406:
      if (paramCard != null) {
        this.jdField_a_of_type_Alcn.drP = paramCard.extendFriendEntryAddFriend;
      }
      i = j;
      if (paramCard != null)
      {
        if (paramCard.mQQLevelType != 0) {
          break label569;
        }
        i = j;
      }
      label438:
      if (this.jdField_a_of_type_Alcn.e.pa != 0) {
        break label577;
      }
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A777", i, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqmv.X("initUpdateInfoEnd", "initUpdateInfoStart", false);
      return;
      localObject1 = "null";
      break;
      label507:
      if (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.strNick)) {
        break label406;
      }
      this.jdField_b_of_type_Swe.tV(this.jdField_a_of_type_Alcn.d.strNick + getResources().getString(2131700726));
      break label406;
      label569:
      i = paramCard.mQQLevelType;
      break label438;
      label577:
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A776", i, 0, "", "", "", "");
    }
  }
  
  /* Error */
  public void a(Card paramCard, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +772 -> 775
    //   6: iload_3
    //   7: iconst_1
    //   8: if_icmpeq +9 -> 17
    //   11: iload_3
    //   12: bipush 8
    //   14: if_icmpne +171 -> 185
    //   17: aload_1
    //   18: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   21: lconst_0
    //   22: lcmp
    //   23: iflt +162 -> 185
    //   26: aload_0
    //   27: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: ldc_w 1076
    //   33: ldc_w 287
    //   36: ldc_w 287
    //   39: ldc_w 3026
    //   42: ldc_w 3028
    //   45: aload_0
    //   46: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   49: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   52: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   55: invokestatic 1087	com/tencent/mobileqq/activity/FriendProfileCardActivity:eP	(I)I
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   63: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   66: invokestatic 1089	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)I
    //   69: invokestatic 1094	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   72: aload_1
    //   73: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   76: invokestatic 3031	java/lang/Long:toString	(J)Ljava/lang/String;
    //   79: ldc_w 287
    //   82: ldc_w 287
    //   85: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: invokevirtual 603	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   95: ldc_w 3026
    //   98: ldc_w 3033
    //   101: ldc_w 287
    //   104: iconst_1
    //   105: iconst_0
    //   106: iconst_0
    //   107: ldc_w 287
    //   110: aload_0
    //   111: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   114: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   117: invokestatic 1089	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;)I
    //   120: invokestatic 1094	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   123: new 587	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   130: aload_1
    //   131: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   134: invokevirtual 2525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   137: ldc_w 287
    //   140: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: new 587	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   153: aload_1
    //   154: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   157: invokevirtual 2525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: ldc_w 287
    //   163: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: ldc_w 287
    //   172: ldc_w 287
    //   175: ldc_w 287
    //   178: iconst_0
    //   179: iconst_0
    //   180: iconst_0
    //   181: iconst_0
    //   182: invokestatic 3039	com/tencent/mobileqq/vaswebviewplugin/VasWebviewUtil:reportCommercialDrainage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIII)V
    //   185: getstatic 3044	aurh:b	Laurh;
    //   188: astore 19
    //   190: aload 19
    //   192: ifnull +18 -> 210
    //   195: aload 19
    //   197: invokevirtual 3047	aurh:aJB	()Z
    //   200: ifeq +10 -> 210
    //   203: aload 19
    //   205: bipush 7
    //   207: invokevirtual 3050	aurh:aaY	(I)V
    //   210: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +66 -> 279
    //   216: ldc_w 1002
    //   219: iconst_2
    //   220: new 587	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   227: ldc_w 3052
    //   230: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 276	com/tencent/mobileqq/activity/FriendProfileCardActivity:qC	Z
    //   237: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   240: ldc_w 3054
    //   243: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload_2
    //   247: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   250: ldc_w 3056
    //   253: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iload_3
    //   257: invokevirtual 1577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: ldc_w 3058
    //   263: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 2936	com/tencent/mobileqq/data/Card:getProfileCardDesc	()Ljava/lang/String;
    //   270: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: aload_1
    //   281: iload_2
    //   282: invokevirtual 3061	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)Z
    //   285: pop
    //   286: aload_0
    //   287: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   290: invokestatic 3063	com/tencent/mobileqq/activity/FriendProfileCardActivity:b	(Lalcn;)V
    //   293: iconst_0
    //   294: istore 10
    //   296: iconst_0
    //   297: istore 8
    //   299: iconst_0
    //   300: istore 6
    //   302: iconst_0
    //   303: istore 4
    //   305: iload 6
    //   307: istore 5
    //   309: iload 10
    //   311: istore 9
    //   313: iload_3
    //   314: bipush 8
    //   316: if_icmpne +1668 -> 1984
    //   319: iload 6
    //   321: istore 5
    //   323: iload 10
    //   325: istore 9
    //   327: aload_0
    //   328: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   331: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   334: ifnull +1650 -> 1984
    //   337: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +52 -> 392
    //   343: ldc_w 1002
    //   346: iconst_2
    //   347: new 587	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   354: ldc_w 3065
    //   357: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload_0
    //   361: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   364: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   367: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   370: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: ldc_w 3070
    //   376: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload_1
    //   380: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   383: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload_0
    //   393: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   396: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   399: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   402: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   405: ifeq +373 -> 778
    //   408: aload_1
    //   409: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   412: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   415: ifne +22 -> 437
    //   418: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +1573 -> 1994
    //   424: ldc_w 1002
    //   427: iconst_2
    //   428: ldc_w 3072
    //   431: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: goto +1560 -> 1994
    //   437: aload_0
    //   438: getfield 2670	com/tencent/mobileqq/activity/FriendProfileCardActivity:Gb	J
    //   441: aload_1
    //   442: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   445: lcmp
    //   446: ifeq +6 -> 452
    //   449: iconst_1
    //   450: istore 4
    //   452: aload_1
    //   453: invokestatic 2673	alcs:a	(Lcom/tencent/mobileqq/data/Card;)J
    //   456: aload_0
    //   457: getfield 2675	com/tencent/mobileqq/activity/FriendProfileCardActivity:Gc	J
    //   460: lcmp
    //   461: ifle +6 -> 467
    //   464: iconst_1
    //   465: istore 4
    //   467: iload 4
    //   469: istore 5
    //   471: iload 8
    //   473: istore 9
    //   475: aload_0
    //   476: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   479: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   482: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   485: getstatic 2730	alcs:agj	J
    //   488: lcmp
    //   489: ifne +1495 -> 1984
    //   492: iload 4
    //   494: istore 5
    //   496: iload 8
    //   498: istore 9
    //   500: aload_1
    //   501: getfield 3075	com/tencent/mobileqq/data/Card:diyText	Ljava/lang/String;
    //   504: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   507: ifne +1477 -> 1984
    //   510: iconst_1
    //   511: istore 6
    //   513: iload 4
    //   515: istore 5
    //   517: iload 6
    //   519: istore 4
    //   521: iload_3
    //   522: bipush 13
    //   524: if_icmpne +22 -> 546
    //   527: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +1470 -> 2000
    //   533: ldc_w 1002
    //   536: iconst_2
    //   537: ldc_w 3077
    //   540: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: goto +1457 -> 2000
    //   546: aload_1
    //   547: getfield 3080	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   550: ifnull +83 -> 633
    //   553: aload_1
    //   554: getfield 3080	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   557: arraylength
    //   558: ifle +75 -> 633
    //   561: aload_0
    //   562: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   565: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   568: aload_1
    //   569: getfield 3080	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   572: putfield 1306	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:cf	[B
    //   575: invokestatic 1314	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   578: ifeq +55 -> 633
    //   581: ldc_w 659
    //   584: iconst_4
    //   585: invokestatic 1320	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   588: ldc_w 3082
    //   591: iconst_2
    //   592: anewarray 244	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: aload_0
    //   598: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   601: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   604: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   607: invokestatic 1041	aqft:pl	(Ljava/lang/String;)Ljava/lang/String;
    //   610: aastore
    //   611: dup
    //   612: iconst_1
    //   613: aload_0
    //   614: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   617: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   620: getfield 1306	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:cf	[B
    //   623: invokestatic 1326	aqft:bytesToHexString	([B)Ljava/lang/String;
    //   626: aastore
    //   627: invokestatic 1330	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   630: invokestatic 1055	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: aload_0
    //   634: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   637: aload_1
    //   638: putfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   641: aload_0
    //   642: getfield 276	com/tencent/mobileqq/activity/FriendProfileCardActivity:qC	Z
    //   645: ifeq +13 -> 658
    //   648: iload 8
    //   650: ifne +8 -> 658
    //   653: iload 5
    //   655: ifeq +1326 -> 1981
    //   658: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +44 -> 705
    //   664: ldc_w 1002
    //   667: iconst_2
    //   668: new 587	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 3084
    //   678: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_0
    //   682: getfield 276	com/tencent/mobileqq/activity/FriendProfileCardActivity:qC	Z
    //   685: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   688: ldc_w 3086
    //   691: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: iload 8
    //   696: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   699: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: aload_1
    //   706: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   709: lstore 12
    //   711: aload_1
    //   712: getfield 3089	com/tencent/mobileqq/data/Card:templateRet	I
    //   715: istore 6
    //   717: aload_1
    //   718: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   721: astore 18
    //   723: aload_1
    //   724: getfield 2687	com/tencent/mobileqq/data/Card:backgroundColor	J
    //   727: lstore 14
    //   729: aload_1
    //   730: getfield 3092	com/tencent/mobileqq/data/Card:strZipUrl	Ljava/lang/String;
    //   733: astore 20
    //   735: aload_1
    //   736: getfield 3095	com/tencent/mobileqq/data/Card:dynamicCardFlag	I
    //   739: istore 7
    //   741: aload_1
    //   742: getfield 3098	com/tencent/mobileqq/data/Card:strWzryHeroUrl	Ljava/lang/String;
    //   745: astore 21
    //   747: aload_1
    //   748: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   751: lstore 16
    //   753: lload 12
    //   755: lconst_0
    //   756: lcmp
    //   757: ifge +63 -> 820
    //   760: aload_0
    //   761: invokestatic 1625	aqiw:isNetworkAvailable	(Landroid/content/Context;)Z
    //   764: istore 9
    //   766: iload 9
    //   768: ifeq +52 -> 820
    //   771: iload_2
    //   772: ifne +48 -> 820
    //   775: aload_0
    //   776: monitorexit
    //   777: return
    //   778: aload_0
    //   779: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   782: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   785: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   788: aload_1
    //   789: getfield 3068	com/tencent/mobileqq/data/Card:backgroundUrl	Ljava/lang/String;
    //   792: invokevirtual 1285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifne -358 -> 437
    //   798: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq +13 -> 814
    //   804: ldc_w 1002
    //   807: iconst_2
    //   808: ldc_w 3100
    //   811: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: iconst_1
    //   815: istore 8
    //   817: goto -380 -> 437
    //   820: aload_0
    //   821: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   824: ldc_w 3102
    //   827: iconst_1
    //   828: invokevirtual 2590	aqmv:dn	(Ljava/lang/String;Z)V
    //   831: aload_0
    //   832: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   835: lload 12
    //   837: iconst_1
    //   838: invokestatic 3105	aqep:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JZ)Lalcs;
    //   841: astore 22
    //   843: aload_0
    //   844: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   847: ldc_w 3107
    //   850: ldc_w 3102
    //   853: iconst_0
    //   854: invokevirtual 2647	aqmv:X	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   857: lload 12
    //   859: lconst_0
    //   860: lcmp
    //   861: ifle +21 -> 882
    //   864: aload 22
    //   866: ifnull +16 -> 882
    //   869: aload 18
    //   871: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   874: ifne +8 -> 882
    //   877: iload 6
    //   879: ifeq +433 -> 1312
    //   882: aload_0
    //   883: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   886: aconst_null
    //   887: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   890: iload 4
    //   892: ifeq +104 -> 996
    //   895: aload_0
    //   896: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   899: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   902: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   905: getstatic 2730	alcs:agj	J
    //   908: lcmp
    //   909: ifne +87 -> 996
    //   912: aload_0
    //   913: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   916: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   919: getfield 3110	com/tencent/mobileqq/data/Card:diyTextFontId	I
    //   922: invokestatic 3115	com/tencent/mobileqq/activity/VipProfileCardDiyActivity:gn	(I)Z
    //   925: ifne +71 -> 996
    //   928: aload_0
    //   929: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   932: sipush 184
    //   935: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   938: checkcast 3117	com/tencent/mobileqq/vas/VasQuickUpdateManager
    //   941: astore 18
    //   943: aload 18
    //   945: new 3119	uyo
    //   948: dup
    //   949: aload_0
    //   950: invokespecial 3120	uyo:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   953: invokevirtual 3124	com/tencent/mobileqq/vas/VasQuickUpdateManager:addCallBacker	(Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   956: aload 18
    //   958: ldc2_w 3125
    //   961: new 587	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   968: ldc_w 3128
    //   971: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload_0
    //   975: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   978: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   981: getfield 3110	com/tencent/mobileqq/data/Card:diyTextFontId	I
    //   984: invokevirtual 1577	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   987: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: ldc_w 659
    //   993: invokevirtual 3132	com/tencent/mobileqq/vas/VasQuickUpdateManager:downloadItem	(JLjava/lang/String;Ljava/lang/String;)V
    //   996: aload_0
    //   997: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1000: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1003: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1006: ifeq +185 -> 1191
    //   1009: iload_3
    //   1010: bipush 8
    //   1012: if_icmpne +179 -> 1191
    //   1015: aload_0
    //   1016: getfield 3134	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWu	Z
    //   1019: ifne +172 -> 1191
    //   1022: aload_0
    //   1023: iconst_1
    //   1024: putfield 3134	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWu	Z
    //   1027: aload_1
    //   1028: getfield 3137	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   1031: ldc2_w 3138
    //   1034: land
    //   1035: lconst_0
    //   1036: lcmp
    //   1037: ifeq +912 -> 1949
    //   1040: iconst_1
    //   1041: istore 9
    //   1043: aload_0
    //   1044: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1047: bipush 51
    //   1049: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1052: checkcast 640	acff
    //   1055: aload_1
    //   1056: getfield 1627	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1059: invokevirtual 1706	acff:isFriend	(Ljava/lang/String;)Z
    //   1062: istore 10
    //   1064: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1067: ifeq +71 -> 1138
    //   1070: ldc_w 659
    //   1073: iconst_2
    //   1074: new 587	java/lang/StringBuilder
    //   1077: dup
    //   1078: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   1081: ldc_w 3141
    //   1084: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: iload 9
    //   1089: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1092: ldc_w 3143
    //   1095: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1098: iload 10
    //   1100: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1103: ldc_w 3145
    //   1106: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: aload_1
    //   1110: getfield 1627	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1113: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: ldc_w 3147
    //   1119: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: aload_0
    //   1123: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 705	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1129: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1135: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1138: iload 9
    //   1140: iload 10
    //   1142: if_icmpeq +49 -> 1191
    //   1145: ldc_w 659
    //   1148: iconst_1
    //   1149: new 587	java/lang/StringBuilder
    //   1152: dup
    //   1153: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   1156: ldc_w 3149
    //   1159: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: iload 9
    //   1164: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1167: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1170: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1173: aload_0
    //   1174: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1177: iconst_1
    //   1178: invokevirtual 700	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1181: checkcast 3151	com/tencent/mobileqq/app/FriendListHandler
    //   1184: aload_1
    //   1185: getfield 1627	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   1188: invokevirtual 3154	com/tencent/mobileqq/app/FriendListHandler:DF	(Ljava/lang/String;)V
    //   1191: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1194: ifeq +812 -> 2006
    //   1197: ldc_w 659
    //   1200: iconst_2
    //   1201: new 587	java/lang/StringBuilder
    //   1204: dup
    //   1205: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   1208: ldc_w 3156
    //   1211: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: iconst_1
    //   1215: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1218: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1221: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1224: goto +782 -> 2006
    //   1227: aload_0
    //   1228: getfield 1359	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Auru	Lauru;
    //   1231: iconst_5
    //   1232: iload 6
    //   1234: iload_3
    //   1235: aload_1
    //   1236: invokevirtual 3159	auru:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   1239: astore 18
    //   1241: iload 8
    //   1243: ifeq +718 -> 1961
    //   1246: iload 5
    //   1248: ifeq +713 -> 1961
    //   1251: aload 18
    //   1253: bipush 12
    //   1255: putfield 3162	android/os/Message:arg2	I
    //   1258: aload 18
    //   1260: invokevirtual 3165	android/os/Message:sendToTarget	()V
    //   1263: iload 4
    //   1265: ifeq +19 -> 1284
    //   1268: aload_0
    //   1269: getfield 1359	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Auru	Lauru;
    //   1272: iconst_5
    //   1273: iload 6
    //   1275: bipush 17
    //   1277: aload_1
    //   1278: invokevirtual 3159	auru:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   1281: invokevirtual 3165	android/os/Message:sendToTarget	()V
    //   1284: aload 19
    //   1286: ifnull -511 -> 775
    //   1289: aload 19
    //   1291: invokevirtual 3047	aurh:aJB	()Z
    //   1294: ifeq -519 -> 775
    //   1297: aload 19
    //   1299: bipush 7
    //   1301: invokevirtual 3168	aurh:aaZ	(I)V
    //   1304: goto -529 -> 775
    //   1307: astore_1
    //   1308: aload_0
    //   1309: monitorexit
    //   1310: aload_1
    //   1311: athrow
    //   1312: aload_0
    //   1313: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1316: invokestatic 3171	aqep:bY	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   1319: istore 11
    //   1321: lload 16
    //   1323: ldc2_w 3172
    //   1326: lcmp
    //   1327: ifeq +12 -> 1339
    //   1330: lload 16
    //   1332: ldc2_w 3174
    //   1335: lcmp
    //   1336: ifne +378 -> 1714
    //   1339: aload_0
    //   1340: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1343: invokevirtual 1202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1346: aload 18
    //   1348: invokestatic 3179	aqep:aj	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1351: istore 9
    //   1353: aload_0
    //   1354: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1357: invokevirtual 1202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1360: lload 16
    //   1362: ldc_w 3181
    //   1365: invokestatic 3186	alco:b	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1368: istore 10
    //   1370: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1373: ifeq +64 -> 1437
    //   1376: ldc_w 1002
    //   1379: iconst_2
    //   1380: new 587	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 3188
    //   1390: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: lload 16
    //   1395: invokevirtual 2525	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1398: ldc_w 3190
    //   1401: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1404: iload 11
    //   1406: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1409: ldc_w 3192
    //   1412: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: iload 9
    //   1417: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1420: ldc_w 3194
    //   1423: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: iload 10
    //   1428: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1431: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1434: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1437: iload 11
    //   1439: ifeq +479 -> 1918
    //   1442: iload 9
    //   1444: ifeq +474 -> 1918
    //   1447: aload_0
    //   1448: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   1451: ldc_w 3196
    //   1454: iconst_1
    //   1455: invokevirtual 2590	aqmv:dn	(Ljava/lang/String;Z)V
    //   1458: aload 22
    //   1460: aload_0
    //   1461: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1464: lload 14
    //   1466: lload 12
    //   1468: invokevirtual 3199	alcs:c	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)Z
    //   1471: istore 9
    //   1473: aload_0
    //   1474: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   1477: ldc_w 3201
    //   1480: ldc_w 3196
    //   1483: iconst_0
    //   1484: invokevirtual 2647	aqmv:X	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1487: aload_0
    //   1488: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   1491: ldc_w 3203
    //   1494: iconst_1
    //   1495: invokevirtual 2590	aqmv:dn	(Ljava/lang/String;Z)V
    //   1498: aload_0
    //   1499: lload 12
    //   1501: lload 16
    //   1503: aload 18
    //   1505: aload 20
    //   1507: aload 21
    //   1509: invokevirtual 3206	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   1512: istore 11
    //   1514: iload 8
    //   1516: iload 11
    //   1518: ior
    //   1519: istore 8
    //   1521: aload_0
    //   1522: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   1525: ldc_w 3208
    //   1528: ldc_w 3203
    //   1531: iconst_0
    //   1532: invokevirtual 2647	aqmv:X	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1535: iload 9
    //   1537: ifeq +267 -> 1804
    //   1540: aload_0
    //   1541: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1544: aload 22
    //   1546: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1549: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1552: ifeq +42 -> 1594
    //   1555: ldc_w 1002
    //   1558: iconst_2
    //   1559: new 587	java/lang/StringBuilder
    //   1562: dup
    //   1563: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   1566: ldc_w 3210
    //   1569: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: iload 11
    //   1574: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1577: ldc_w 3212
    //   1580: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: iload 9
    //   1585: invokevirtual 673	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1588: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1591: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1594: iload 7
    //   1596: iconst_1
    //   1597: if_icmpne +236 -> 1833
    //   1600: iload 10
    //   1602: ifne +231 -> 1833
    //   1605: aload_0
    //   1606: invokevirtual 3214	com/tencent/mobileqq/activity/FriendProfileCardActivity:PB	()Z
    //   1609: ifeq +29 -> 1638
    //   1612: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1615: ifeq +13 -> 1628
    //   1618: ldc_w 1002
    //   1621: iconst_2
    //   1622: ldc_w 3216
    //   1625: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1628: aload_0
    //   1629: aload 18
    //   1631: lload 16
    //   1633: aload 22
    //   1635: invokevirtual 3219	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLalcs;)V
    //   1638: aload_1
    //   1639: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1642: getstatic 2741	alcs:agm	J
    //   1645: lcmp
    //   1646: ifeq +14 -> 1660
    //   1649: aload_1
    //   1650: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1653: getstatic 2744	alcs:agl	J
    //   1656: lcmp
    //   1657: ifne +54 -> 1711
    //   1660: aload_0
    //   1661: getfield 3221	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWt	Z
    //   1664: ifne +47 -> 1711
    //   1667: aload 22
    //   1669: getfield 3224	alcs:agr	J
    //   1672: invokestatic 3229	aldx:cz	(J)Z
    //   1675: ifeq +36 -> 1711
    //   1678: aload_0
    //   1679: ldc_w 3231
    //   1682: invokestatic 3234	aldx:W	(Landroid/content/Context;Ljava/lang/String;)Z
    //   1685: ifne +26 -> 1711
    //   1688: aload_0
    //   1689: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1692: new 3236	uyn
    //   1695: dup
    //   1696: aload_0
    //   1697: aload 22
    //   1699: aload_1
    //   1700: invokespecial 3239	uyn:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;Lalcs;Lcom/tencent/mobileqq/data/Card;)V
    //   1703: invokestatic 3242	aldx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   1706: aload_0
    //   1707: iconst_1
    //   1708: putfield 3221	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWt	Z
    //   1711: goto -821 -> 890
    //   1714: iload 7
    //   1716: iconst_1
    //   1717: if_icmpne +58 -> 1775
    //   1720: aload_0
    //   1721: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1724: invokevirtual 1202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1727: lload 16
    //   1729: ldc_w 3244
    //   1732: invokestatic 3186	alco:b	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1735: istore 10
    //   1737: iload 10
    //   1739: istore 9
    //   1741: iload 10
    //   1743: ifne -390 -> 1353
    //   1746: new 3246	java/io/File
    //   1749: dup
    //   1750: aload_0
    //   1751: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1754: invokevirtual 1202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1757: lload 12
    //   1759: lload 16
    //   1761: invokestatic 3249	alco:a	(Landroid/content/Context;JJ)Ljava/lang/String;
    //   1764: invokespecial 3250	java/io/File:<init>	(Ljava/lang/String;)V
    //   1767: invokevirtual 3253	java/io/File:exists	()Z
    //   1770: istore 9
    //   1772: goto -419 -> 1353
    //   1775: new 3246	java/io/File
    //   1778: dup
    //   1779: aload_0
    //   1780: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1783: invokevirtual 1202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1786: lload 12
    //   1788: lload 16
    //   1790: invokestatic 3249	alco:a	(Landroid/content/Context;JJ)Ljava/lang/String;
    //   1793: invokespecial 3250	java/io/File:<init>	(Ljava/lang/String;)V
    //   1796: invokevirtual 3253	java/io/File:exists	()Z
    //   1799: istore 9
    //   1801: goto -448 -> 1353
    //   1804: aload_0
    //   1805: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1808: aconst_null
    //   1809: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1812: goto -263 -> 1549
    //   1815: astore 18
    //   1817: aload 18
    //   1819: invokevirtual 1435	java/lang/Exception:printStackTrace	()V
    //   1822: aload_0
    //   1823: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1826: aconst_null
    //   1827: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1830: goto -940 -> 890
    //   1833: aload_1
    //   1834: getfield 2611	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   1837: getstatic 2741	alcs:agm	J
    //   1840: lcmp
    //   1841: ifne -203 -> 1638
    //   1844: aload_0
    //   1845: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1848: invokevirtual 1202	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1851: aload_1
    //   1852: getfield 2684	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   1855: ldc_w 3255
    //   1858: invokestatic 3186	alco:b	(Landroid/content/Context;JLjava/lang/String;)Z
    //   1861: ifne -223 -> 1638
    //   1864: aload_0
    //   1865: invokevirtual 3214	com/tencent/mobileqq/activity/FriendProfileCardActivity:PB	()Z
    //   1868: ifeq -230 -> 1638
    //   1871: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1874: ifeq +13 -> 1887
    //   1877: ldc_w 1002
    //   1880: iconst_2
    //   1881: ldc_w 3257
    //   1884: invokestatic 664	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1887: aload_0
    //   1888: aload 18
    //   1890: lload 16
    //   1892: aload 22
    //   1894: invokevirtual 3219	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLalcs;)V
    //   1897: goto -259 -> 1638
    //   1900: astore 18
    //   1902: aload 18
    //   1904: invokevirtual 3258	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1907: aload_0
    //   1908: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1911: aconst_null
    //   1912: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1915: goto -1025 -> 890
    //   1918: aload_0
    //   1919: invokevirtual 3214	com/tencent/mobileqq/activity/FriendProfileCardActivity:PB	()Z
    //   1922: ifeq +16 -> 1938
    //   1925: aload_0
    //   1926: aload 18
    //   1928: lload 16
    //   1930: aload 22
    //   1932: invokevirtual 3219	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Ljava/lang/String;JLalcs;)V
    //   1935: goto -1160 -> 775
    //   1938: aload_0
    //   1939: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1942: aconst_null
    //   1943: putfield 2619	alcn:jdField_b_of_type_Alcs	Lalcs;
    //   1946: goto -1056 -> 890
    //   1949: iconst_0
    //   1950: istore 9
    //   1952: goto -909 -> 1043
    //   1955: iconst_0
    //   1956: istore 6
    //   1958: goto -731 -> 1227
    //   1961: iload 8
    //   1963: ifeq -705 -> 1258
    //   1966: aload 18
    //   1968: bipush 11
    //   1970: putfield 3162	android/os/Message:arg2	I
    //   1973: goto -715 -> 1258
    //   1976: astore 18
    //   1978: goto -76 -> 1902
    //   1981: goto -1091 -> 890
    //   1984: iconst_0
    //   1985: istore 4
    //   1987: iload 9
    //   1989: istore 8
    //   1991: goto -1470 -> 521
    //   1994: iconst_1
    //   1995: istore 8
    //   1997: goto -1560 -> 437
    //   2000: iconst_1
    //   2001: istore 8
    //   2003: goto -1457 -> 546
    //   2006: iload_2
    //   2007: ifeq -52 -> 1955
    //   2010: iconst_1
    //   2011: istore 6
    //   2013: goto -786 -> 1227
    //   2016: astore 18
    //   2018: goto -201 -> 1817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2021	0	this	FriendProfileCardActivity
    //   0	2021	1	paramCard	Card
    //   0	2021	2	paramBoolean	boolean
    //   0	2021	3	paramInt	int
    //   303	1683	4	i	int
    //   307	940	5	j	int
    //   300	1712	6	k	int
    //   739	979	7	i1	int
    //   297	1705	8	bool1	boolean
    //   311	1677	9	bool2	boolean
    //   294	1448	10	bool3	boolean
    //   1319	254	11	bool4	boolean
    //   709	1078	12	l1	long
    //   727	738	14	l2	long
    //   751	1178	16	l3	long
    //   721	909	18	localObject	Object
    //   1815	74	18	localException1	Exception
    //   1900	67	18	localOutOfMemoryError1	OutOfMemoryError
    //   1976	1	18	localOutOfMemoryError2	OutOfMemoryError
    //   2016	1	18	localException2	Exception
    //   188	1110	19	localaurh	aurh
    //   733	773	20	str1	String
    //   745	763	21	str2	String
    //   841	1090	22	localalcs	alcs
    // Exception table:
    //   from	to	target	type
    //   17	185	1307	finally
    //   185	190	1307	finally
    //   195	210	1307	finally
    //   210	279	1307	finally
    //   279	293	1307	finally
    //   327	392	1307	finally
    //   392	408	1307	finally
    //   408	434	1307	finally
    //   437	449	1307	finally
    //   452	464	1307	finally
    //   475	492	1307	finally
    //   500	510	1307	finally
    //   527	543	1307	finally
    //   546	633	1307	finally
    //   633	648	1307	finally
    //   658	705	1307	finally
    //   705	753	1307	finally
    //   760	766	1307	finally
    //   778	814	1307	finally
    //   820	857	1307	finally
    //   869	877	1307	finally
    //   882	890	1307	finally
    //   895	996	1307	finally
    //   996	1009	1307	finally
    //   1015	1040	1307	finally
    //   1043	1138	1307	finally
    //   1145	1191	1307	finally
    //   1191	1224	1307	finally
    //   1227	1241	1307	finally
    //   1251	1258	1307	finally
    //   1258	1263	1307	finally
    //   1268	1284	1307	finally
    //   1289	1304	1307	finally
    //   1312	1321	1307	finally
    //   1339	1353	1307	finally
    //   1353	1437	1307	finally
    //   1447	1514	1307	finally
    //   1521	1535	1307	finally
    //   1540	1549	1307	finally
    //   1549	1594	1307	finally
    //   1605	1628	1307	finally
    //   1628	1638	1307	finally
    //   1638	1660	1307	finally
    //   1660	1711	1307	finally
    //   1720	1737	1307	finally
    //   1746	1772	1307	finally
    //   1775	1801	1307	finally
    //   1804	1812	1307	finally
    //   1817	1830	1307	finally
    //   1833	1887	1307	finally
    //   1887	1897	1307	finally
    //   1902	1915	1307	finally
    //   1918	1935	1307	finally
    //   1938	1946	1307	finally
    //   1966	1973	1307	finally
    //   1521	1535	1815	java/lang/Exception
    //   1540	1549	1815	java/lang/Exception
    //   1549	1594	1815	java/lang/Exception
    //   1605	1628	1815	java/lang/Exception
    //   1628	1638	1815	java/lang/Exception
    //   1638	1660	1815	java/lang/Exception
    //   1660	1711	1815	java/lang/Exception
    //   1804	1812	1815	java/lang/Exception
    //   1833	1887	1815	java/lang/Exception
    //   1887	1897	1815	java/lang/Exception
    //   1521	1535	1900	java/lang/OutOfMemoryError
    //   1540	1549	1900	java/lang/OutOfMemoryError
    //   1549	1594	1900	java/lang/OutOfMemoryError
    //   1605	1628	1900	java/lang/OutOfMemoryError
    //   1628	1638	1900	java/lang/OutOfMemoryError
    //   1638	1660	1900	java/lang/OutOfMemoryError
    //   1660	1711	1900	java/lang/OutOfMemoryError
    //   1804	1812	1900	java/lang/OutOfMemoryError
    //   1833	1887	1900	java/lang/OutOfMemoryError
    //   1887	1897	1900	java/lang/OutOfMemoryError
    //   705	753	1976	java/lang/OutOfMemoryError
    //   760	766	1976	java/lang/OutOfMemoryError
    //   820	857	1976	java/lang/OutOfMemoryError
    //   869	877	1976	java/lang/OutOfMemoryError
    //   882	890	1976	java/lang/OutOfMemoryError
    //   1312	1321	1976	java/lang/OutOfMemoryError
    //   1339	1353	1976	java/lang/OutOfMemoryError
    //   1353	1437	1976	java/lang/OutOfMemoryError
    //   1447	1514	1976	java/lang/OutOfMemoryError
    //   1720	1737	1976	java/lang/OutOfMemoryError
    //   1746	1772	1976	java/lang/OutOfMemoryError
    //   1775	1801	1976	java/lang/OutOfMemoryError
    //   1918	1935	1976	java/lang/OutOfMemoryError
    //   1938	1946	1976	java/lang/OutOfMemoryError
    //   705	753	2016	java/lang/Exception
    //   760	766	2016	java/lang/Exception
    //   820	857	2016	java/lang/Exception
    //   869	877	2016	java/lang/Exception
    //   882	890	2016	java/lang/Exception
    //   1312	1321	2016	java/lang/Exception
    //   1339	1353	2016	java/lang/Exception
    //   1353	1437	2016	java/lang/Exception
    //   1447	1514	2016	java/lang/Exception
    //   1720	1737	2016	java/lang/Exception
    //   1746	1772	2016	java/lang/Exception
    //   1775	1801	2016	java/lang/Exception
    //   1918	1935	2016	java/lang/Exception
    //   1938	1946	2016	java/lang/Exception
  }
  
  public void a(ContactCard paramContactCard, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo ContactCard card = " + paramContactCard + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    ZM();
    if (a(paramContactCard, paramBoolean)) {
      b(this.jdField_a_of_type_Alcn);
    }
    a(this.jdField_a_of_type_Alcn, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, paramBoolean, new String[0]);
    xl(paramBoolean);
  }
  
  public void a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "updateInfo QCallCardInfo card = " + paramQCallCardInfo + ", isNetRet = " + String.valueOf(paramBoolean));
    }
    if (a(paramQCallCardInfo, paramBoolean)) {
      b(this.jdField_a_of_type_Alcn);
    }
    a(this.jdField_a_of_type_Alcn, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, paramBoolean, new String[0]);
    xl(paramBoolean);
  }
  
  void a(String paramString, long paramLong, alcs paramalcs)
  {
    if ((paramLong != 160L) && (paramLong != 1600L)) {
      ((aqrc)this.app.getManager(235)).b.av(this.app, "card." + paramLong);
    }
    if (!this.bv.get())
    {
      this.bv.set(true);
      ThreadManagerV2.excute(new DownloadTemplateRunnable(this, paramalcs, this.bv, paramString, paramLong), 128, null, true);
    }
  }
  
  public boolean a(long paramLong1, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, long paramLong2)
  {
    acff localacff = (acff)this.app.getManager(51);
    Card localCard = localacff.b(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong1 >= 0L))
    {
      localCard.lCurrentStyleId = paramLong1;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString1;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      localCard.cardId = paramLong2;
      if (TextUtils.isEmpty(localCard.diyComplicatedInfo)) {
        localCard.diyComplicatedInfo = paramString2;
      }
      if (!localacff.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FriendProfileCardActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground url=" + paramString1 + ",thread=" + Thread.currentThread().getName());
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      if ((this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agm))
      {
        return b(paramLong2, paramString1, paramString3);
        paramString1 = aqep.I(this, paramString1);
        Object localObject1;
        label119:
        int i;
        if (TextUtils.isEmpty(paramString2))
        {
          paramString3 = "";
          localObject1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "initProfileCardBackground: fileName=" + (String)localObject1);
          }
          localFile = new File((String)localObject1);
          if ((!localFile.isFile()) || (!localFile.exists())) {
            break label1005;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "background file exists, fileName = " + (String)localObject1);
          }
          paramString1 = (Boolean)alco.mt.get(Long.valueOf(paramLong2));
          if ((paramString1 != null) && (paramString1.booleanValue()))
          {
            paramString1 = "profilecard:" + (String)localObject1;
            BaseApplicationImpl.sImageCache.remove(paramString1);
            alco.mt.remove(Long.valueOf(paramLong2));
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground update card and remove old cache bgid=" + paramLong2);
            }
          }
          localObject2 = null;
          paramString1 = (String)localObject2;
          if (!aese.d().ahv()) {
            break label632;
          }
          i = 0;
          paramString2 = alco.e(this, paramLong2) + "dynamicVideo.mp4";
          if (!new File(paramString2).exists()) {
            break label531;
          }
          i = 1;
        }
        for (;;)
        {
          paramString1 = (String)localObject2;
          if (i == 0) {
            break label632;
          }
          if ((this.dB == null) || (!TextUtils.equals(this.aNd, paramString2)) || (!aqsj.i(this.dB))) {
            break label583;
          }
          if (!QLog.isColorLevel()) {
            break label1125;
          }
          QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: use old video-drawable");
          break label1125;
          paramString1 = alco.a(this, paramLong1, paramLong2);
          break;
          paramString2 = alco.e(this, paramLong2) + "dynamicBottom.jpg";
          if (new File(paramString2).exists()) {
            paramString1 = paramString2;
          }
          paramString3 = alco.e(this, paramLong2) + ".dynamic";
          localObject1 = paramString1;
          break label119;
          label531:
          paramString1 = paramString3 + "/video.mp4";
          paramString2 = paramString1;
          if (new File(paramString1).exists())
          {
            i = 1;
            paramString2 = paramString1;
          }
        }
        label583:
        Object localObject2 = aqsj.a().r(paramString2);
        paramString1 = (String)localObject2;
        if (localObject2 != null)
        {
          aqsj.a().a((Drawable)localObject2, true);
          this.aNd = paramString2;
          QLog.i("Q.profilecard.FrdProfileCard", 2, "use new video-drawable");
          paramString1 = (String)localObject2;
        }
        label632:
        paramString2 = paramString1;
        if (paramString1 == null)
        {
          paramString2 = paramString1;
          if (TextUtils.isEmpty(paramString3))
          {
            paramString2 = paramString1;
            if (aese.d().ahw())
            {
              localObject2 = localFile.getAbsolutePath();
              if ((this.dB != null) && (TextUtils.equals(this.aNd, (CharSequence)localObject2)) && (aqsj.i(this.dB)))
              {
                if (!QLog.isColorLevel()) {
                  break label1127;
                }
                QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: use old etc-drawable");
                break label1127;
              }
              paramString1 = aqsj.a().a(localFile.getAbsolutePath(), new Handler(ThreadManagerV2.getFileThreadLooper()), false);
              paramString2 = paramString1;
              if (paramString1 != null)
              {
                aqsj.a().a(paramString1, true);
                this.aNd = ((String)localObject2);
                QLog.i("Q.profilecard.FrdProfileCard", 2, "use new etc-drawable");
                paramString2 = paramString1;
              }
            }
          }
        }
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          this.aNd = null;
          paramString2 = aqep.a(getResources(), paramString3, (String)localObject1);
          paramString1 = paramString2;
          if (this.dB != null)
          {
            paramString1 = paramString2;
            if ((this.dB instanceof FriendProfileCardBgDrawable))
            {
              paramString3 = ((FriendProfileCardBgDrawable)paramString2).ah();
              localObject1 = ((FriendProfileCardBgDrawable)this.dB).ah();
              paramString1 = paramString2;
              if (localObject1 != null)
              {
                paramString1 = paramString2;
                if (localObject1 == paramString3)
                {
                  if (!QLog.isColorLevel()) {
                    break label1129;
                  }
                  QLog.i("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: newBitmap == currentBitmap");
                  break label1129;
                }
              }
            }
          }
        }
        if (this.dB != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground recycle bg");
          }
          this.o.add(this.dB);
        }
        for (;;)
        {
          this.dB = paramString1;
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: currentBackgroundDrawable is null");
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      File localFile;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground exception and msg=" + paramString1.getMessage());
      }
      paramString1.printStackTrace();
      for (;;)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground: isFile=" + localFile.isFile() + " exists=" + localFile.exists());
        }
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        label1005:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground oom error and msg=" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
        continue;
        if (paramLong2 != 160L) {
          if (paramLong2 != 1600L) {}
        }
      }
    }
    label1125:
    return true;
    label1127:
    return true;
    label1129:
    return true;
  }
  
  boolean a(alcn paramalcn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramalcn.e);
    }
    if (paramalcn.e == null) {}
    while (TextUtils.isEmpty(paramalcn.e.uin)) {
      return false;
    }
    if (ProfileActivity.AllInOne.g(paramalcn.e)) {}
    try
    {
      alkt.getLong(paramalcn.e.uin);
      if ((paramalcn.e.pa == 56) || (paramalcn.e.pa == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramalcn.e.bJd + ", entry = " + paramalcn.e.bJa);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder(300);
          localStringBuilder.append("checkParamValidate, [pa: ").append(paramalcn.e.pa).append(", uin: ").append(aqft.pl(paramalcn.e.uin));
          if (ProfileActivity.gj(paramalcn.e.pa)) {
            localStringBuilder.append(", allinone_discussUin: ").append(paramalcn.e.discussUin);
          }
          if (ProfileActivity.gk(paramalcn.e.pa)) {
            localStringBuilder.append(", allinone_troopUin: ").append(paramalcn.e.troopUin).append(",  allinone_troopcode: ").append(paramalcn.e.troopcode).append(", sub_source_id: ").append(paramalcn.e.subSourceId).append(", troopUin: ").append(paramalcn.troopUin);
          }
          Bundle localBundle = getIntent().getBundleExtra("flc_extra_param");
          if (localBundle != null)
          {
            localStringBuilder.append(", extra_param_troop_code: ").append(localBundle.getString("troop_code"));
            localStringBuilder.append(", extra_param_troop_uin: ").append(localBundle.getString("troop_uin"));
            localStringBuilder.append(", extra_param_notify_type: ").append(localBundle.getInt("flc_notify_type"));
            localStringBuilder.append(", extra_param_recommend_uin: ").append(localBundle.getString("flc_recommend_uin"));
          }
          localStringBuilder.append(", reportExtraParam: ").append(paramalcn.e.ae);
          localStringBuilder.append("]");
          QLog.i("addFriendTag", 2, localStringBuilder.toString());
        }
        return Px();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramalcn.e.uin);
        break;
        paramalcn.e.bJd = 0;
      }
      return false;
    }
    catch (NumberFormatException paramalcn) {}
  }
  
  boolean a(Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[0], paramCard.strNick))
      {
        bool2 = true;
        this.jdField_a_of_type_Alcn.gh[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[4], paramCard.strReMark))) {
          break label496;
        }
        bool1 = true;
        label114:
        this.jdField_a_of_type_Alcn.gh[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[6], paramCard.strAutoRemark))) {
          break label501;
        }
        paramBoolean = true;
        label169:
        this.jdField_a_of_type_Alcn.gh[6] = paramCard.strAutoRemark;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[3], paramCard.strContactName)))
        {
          bool1 = true;
          label220:
          this.jdField_a_of_type_Alcn.gh[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[2], paramCard.strAutoRemark))) {
            break label511;
          }
        }
      }
      label496:
      label501:
      label511:
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.jdField_a_of_type_Alcn.gh[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[0])).append(", strRemark = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[4])).append(", strContactName = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[3])).append(", strCircleName = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[2])).append(", strRecommenName = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[5])).append(", strTroopNickName = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[1])).append(", strAutoRemark = ");
          paramCard.append(aqft.pl(this.jdField_a_of_type_Alcn.gh[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label114;
        paramBoolean = false;
        break label169;
        bool1 = false;
        break label220;
      }
      bool2 = false;
    }
  }
  
  public boolean a(ContactCard paramContactCard, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramContactCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by ContactCard");
      }
      return false;
    }
    if ((paramBoolean) || (!TextUtils.isEmpty(paramContactCard.nickName))) {
      if (!aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[0], paramContactCard.nickName))
      {
        paramBoolean = true;
        this.jdField_a_of_type_Alcn.gh[0] = paramContactCard.nickName;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramContactCard.strContactName))
      {
        if (!paramBoolean)
        {
          paramBoolean = bool2;
          if (aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.gh[3], paramContactCard.strContactName)) {}
        }
        else
        {
          paramBoolean = true;
        }
        this.jdField_a_of_type_Alcn.gh[3] = paramContactCard.strContactName;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Alcn.e.pa == 53) {
          paramBoolean = bool1;
        }
        for (;;)
        {
          return paramBoolean;
          paramBoolean = false;
          break;
        }
      }
      paramBoolean = false;
    }
  }
  
  boolean a(QCallCardInfo paramQCallCardInfo, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramQCallCardInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQCallCardName by QCallCardInfo");
      }
    }
    while ((!paramBoolean) && (TextUtils.isEmpty(paramQCallCardInfo.nickname))) {
      return false;
    }
    paramBoolean = bool;
    if (!aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname, paramQCallCardInfo.nickname)) {
      paramBoolean = true;
    }
    this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo.nickname = paramQCallCardInfo.nickname;
    return paramBoolean;
  }
  
  void aQ()
  {
    QQMessageFacade localQQMessageFacade = this.app.b();
    int i;
    if (localQQMessageFacade != null)
    {
      i = localQQMessageFacade.bl();
      if (i <= 0) {
        break label105;
      }
      if (i > 99) {
        this.leftView.setText(getString(2131720735) + "(99+)");
      }
    }
    else
    {
      return;
    }
    this.leftView.setText(getString(2131720735) + "(" + i + ")");
    return;
    label105:
    getIntent().putExtra("leftViewText", getString(2131720735));
    this.leftView.setText(getString(2131720735));
  }
  
  public void ai(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.jdField_a_of_type_Alcn.d.updateCoverData(paramArrayOfByte);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.b(this.jdField_a_of_type_Alcn, false);
      }
    }
  }
  
  public void aj(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.d != null))
      {
        if (this.jdField_a_of_type_Alcn.d.checkCoverUrl(paramArrayOfByte)) {
          this.jdField_a_of_type_Alcn.d.updateCoverData(paramArrayOfByte);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView)) {
          ((ProfileBaseView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).b(this.jdField_a_of_type_Alcn, false);
        }
        ThreadManager.excute(new FriendProfileCardActivity.61(this), 16, null, false);
      }
    }
    for (;;)
    {
      anot.a(this.app, "dc00898", "", "", "0X8007EC2", "0X8007EC2", 0, 0, "", "", "", "");
      return;
      a(0L, null, null, false);
    }
  }
  
  public void b(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo != null)
    {
      paramCardContactInfo = paramCardContactInfo.phoneNumber;
      if ((paramCardContactInfo == null) || (paramCardContactInfo.length() <= 0)) {
        break label133;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("smsto:" + paramCardContactInfo));
      startActivity(localIntent);
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "P_prof", "send_sms", eP(this.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(a(this.jdField_a_of_type_Alcn.e)), "", "", "");
      return;
      paramCardContactInfo = null;
      break;
      label133:
      cf(2131694849, 1);
    }
  }
  
  public void b(Card paramCard)
  {
    int i;
    if ((this.jdField_a_of_type_Alcn.e.pa == 0) || (this.jdField_a_of_type_Alcn.e.uin.equals(this.app.getCurrentAccountUin())))
    {
      if (paramCard == null)
      {
        i = 0;
        ??? = aerw.a();
        if ((??? == null) || (!((aerv)???).isEnable()) || (TextUtils.isEmpty(((aerv)???).getUrl())) || (!aurr.isValidUrl(((aerv)???).getUrl()))) {
          break label226;
        }
        ??? = ((aerv)???).getUrl();
        if (paramCard == null) {
          break label219;
        }
        paramCard = paramCard.uin;
        label98:
        aqep.I(this, (String)???, paramCard);
        ajqp.dw(this.app);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramCard = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_like");
          if (!(paramCard instanceof VoteView)) {
            break label364;
          }
          paramCard = (VoteView)paramCard;
          paramCard.a(true, false, i, 0, null, false);
          paramCard.TT(false);
        }
      }
      for (;;)
      {
        anot.a(this.app, "CliOper", "", "", "0X800657A", "0X800657A", 1, 0, Integer.toString(a(this.jdField_a_of_type_Alcn.e)), "", "", "");
        return;
        i = (int)paramCard.lVoteCount;
        break;
        label219:
        paramCard = "";
        break label98;
        label226:
        paramCard = new Intent(this, VisitorsActivity.class);
        ??? = new Bundle();
        ((Bundle)???).putLong("toUin", Long.valueOf(this.jdField_a_of_type_Alcn.e.uin).longValue());
        ((Bundle)???).putLong("totalVoters", i);
        ((Bundle)???).putBoolean("isStartedByProfileCard", true);
        ((Bundle)???).putBoolean("votersOnly", true);
        if (i > 0) {}
        for (boolean bool = true;; bool = false)
        {
          ((Bundle)???).putBoolean("hasVoters", bool);
          ((Bundle)???).putBoolean("extra_show_rank", true);
          ((Bundle)???).putInt("extra_from", 1);
          ((Bundle)???).putInt("frome_where", 5);
          paramCard.putExtras((Bundle)???);
          startActivity(paramCard);
          break;
        }
        label364:
        if ((paramCard instanceof VoteViewV2))
        {
          paramCard = (VoteViewV2)paramCard;
          paramCard.a(true, false, i, 0, null, false);
          paramCard.TT(false);
        }
      }
    }
    HashMap localHashMap = new HashMap();
    String str = this.app.getCurrentAccountUin();
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, "card is null,vote failed !");
      }
      cf(2131694933, 1);
      localHashMap.put("param_FailCode", "-210");
      anpc.a(this.app.getApp()).collectPerformance(str, "profileCardSendFavorite", false, 0L, 0L, localHashMap, "", false);
      return;
    }
    ??? = (CardHandler)this.app.getBusinessHandler(2);
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "Click Vote View, card.bAvailVoteCnt = " + paramCard.bAvailVoteCnt + ",card.bHaveVotedCnt = " + paramCard.bHaveVotedCnt + ",card.strVoteLimitedNotice = " + paramCard.strVoteLimitedNotice);
    }
    label564:
    int j;
    if (paramCard.bAvailVoteCnt <= 0)
    {
      i = 1;
      if ((paramCard.bHaveVotedCnt > 0) || (paramCard.bAvailVoteCnt > 0)) {
        break label844;
      }
      j = 1;
      if ((i != 0) || (j != 0)) {
        break label960;
      }
      if ((??? == null) || (!aqiw.isNetSupport(BaseApplication.getContext()))) {
        break label855;
      }
      paramCard.lVoteCount += 1L;
      paramCard.bVoted = 1;
      paramCard.bAvailVoteCnt = ((short)(paramCard.bAvailVoteCnt - 1));
    }
    label960:
    for (;;)
    {
      synchronized (bM)
      {
        this.ay.incrementAndGet();
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("reqFavorite onClick uin=%s voteCount=%s mCacheVoteNum=%s", new Object[] { this.jdField_a_of_type_Alcn.d.uin, Long.valueOf(this.jdField_a_of_type_Alcn.d.lVoteCount), this.ay }));
        }
        this.aWs = true;
        if (!this.f.hasMessages(10))
        {
          ??? = Message.obtain();
          ((Message)???).what = 10;
          this.f.sendMessageDelayed((Message)???, 2000L);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          l1 = paramCard.lVoteCount;
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Alcn, l1, true);
        }
        if (!QSecFramework.a().c(1001).booleanValue()) {
          break;
        }
        QSecFramework.a().sendCmdToLib(5, 0, 2, new Object[] { Integer.valueOf(24), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
        return;
        i = 0;
        break label564;
        label844:
        j = 0;
      }
      label855:
      if (??? != null)
      {
        localHashMap.put("param_FailCode", "-203");
        anpc.a(this.app.getApp()).collectPerformance(str, "profileCardSendFavorite", true, 0L, 0L, localHashMap, "", false);
        cf(2131721956, 1);
      }
      else
      {
        localHashMap.put("param_FailCode", "-204");
        anpc.a(this.app.getApp()).collectPerformance(str, "profileCardSendFavorite", false, 0L, 0L, localHashMap, "", false);
        cf(2131694933, 1);
        continue;
        if (getIntent().hasExtra("troopUin")) {}
        for (??? = "1";; ??? = "0")
        {
          if ((i == 0) || (VipUtils.ce(this.app))) {
            break label1105;
          }
          if (!alhr.bq(this.app)) {
            break label1064;
          }
          paramCard = new aqrw(this);
          paramCard.a(this.jdField_a_of_type_Aqrw$a);
          paramCard.show();
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", (String)???, "");
          break;
        }
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", (String)???, "");
        ci("非SVIP用户每天只能点10个赞哦～", 0);
      }
    }
    label1064:
    label1105:
    long l1 = SystemClock.uptimeMillis() - Ge;
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "toastInterval:" + l1);
    }
    if (paramCard.strVoteLimitedNotice != null)
    {
      if (l1 > Gf)
      {
        ci(paramCard.strVoteLimitedNotice, 0);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", (String)???, "");
        Ge = SystemClock.uptimeMillis();
      }
      if (j != 0) {
        anot.a(this.app, "CliOper", "", "", "0X8006579", "0X8006579", 1, 0, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_Alcn.e.bJa)), "", "", "");
      }
    }
    for (;;)
    {
      anpc.a(this.app.getApp()).collectPerformance(str, "profileCardSendFavorite", false, 0L, 0L, localHashMap, "", false);
      break;
      if (i != 0)
      {
        anot.a(this.app, "CliOper", "", "", "0X8006578", "0X8006578", 1, 0, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_Alcn.e.bJa)), "", "", "");
        continue;
        if (l1 > Gf)
        {
          cf(2131694933, 1);
          Ge = SystemClock.uptimeMillis();
        }
        if (i != 0) {
          localHashMap.put("param_FailCode", "-230");
        } else if (j != 0) {
          localHashMap.put("param_FailCode", "-231");
        } else {
          localHashMap.put("param_FailCode", "-220");
        }
      }
    }
  }
  
  public boolean b(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initWzryCardBackground url=" + paramString1 + ",thread=" + Thread.currentThread().getName());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {}
    try
    {
      paramString1 = alco.e(this, paramLong);
      String str2 = paramString1 + "wzBgImage.png";
      String str1 = paramString1 + "wzMainImage.png";
      Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get(str2);
      paramString2 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      if (localBitmap != null)
      {
        paramString1 = localBitmap;
        if (!localBitmap.isRecycled()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "background file exists, fileName = " + str2);
        }
        paramString1 = aqcu.decodeFile(str2);
      }
      if ((paramString1 != null) && (this.dl != paramString1))
      {
        this.dl = paramString1;
        BaseApplicationImpl.sImageCache.put(str2, paramString1);
      }
      if (paramString2 != null)
      {
        paramString1 = paramString2;
        if (!paramString2.isRecycled()) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "hero file exists, fileName = " + str1);
        }
        paramString1 = aqcu.decodeFile(str1);
      }
      if ((paramString1 != null) && (this.dm != paramString1))
      {
        this.dm = paramString1;
        BaseApplicationImpl.sImageCache.put(str1, paramString1);
      }
      return true;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground exception and msg=" + paramString1.getMessage());
      }
      paramString1.printStackTrace();
      return false;
    }
    catch (OutOfMemoryError paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "initProfileCardBackground oom error and msg=" + paramString1.getMessage());
        }
        paramString1.printStackTrace();
      }
    }
  }
  
  public boolean b(alcn paramalcn)
  {
    if ((paramalcn.d == null) || (paramalcn.d.mNowShowFlag != 1)) {
      return false;
    }
    return this.jdField_a_of_type_Arho.mI(0);
  }
  
  public void bF()
  {
    if ((this.G != null) && (this.G.isShowing())) {}
    try
    {
      this.G.dismiss();
      label24:
      this.G = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void bFU()
  {
    if (this.z != null)
    {
      this.z.dismiss();
      this.z = null;
    }
  }
  
  public void bOD()
  {
    Intent localIntent = new Intent(this, VipProfileCardDiyActivity.class);
    localIntent.putExtra("extra_from", 1);
    localIntent.putExtra("extra_card_id", this.jdField_a_of_type_Alcn.d.lCurrentBgId);
    localIntent.putExtra("extra_card_url", this.jdField_a_of_type_Alcn.d.backgroundUrl);
    localIntent.putExtra("extra_card_default_text", this.jdField_a_of_type_Alcn.d.diyDefaultText);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.diyText)) && (this.jdField_a_of_type_Alcn.d.diyTextFontId > 0))
    {
      localIntent.putExtra("extra_card_text", this.jdField_a_of_type_Alcn.d.diyText);
      localIntent.putExtra("extra_card_font", this.jdField_a_of_type_Alcn.d.diyTextFontId);
      localIntent.putExtra("extra_card_x", this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.d().x);
      localIntent.putExtra("extra_card_y", this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.d().y);
      localIntent.putExtra("extra_card_scale", this.jdField_a_of_type_Alcn.d.diyTextScale);
      localIntent.putExtra("extra_card_rotation", this.jdField_a_of_type_Alcn.d.diyTextDegree);
      localIntent.putExtra("extra_card_transparency", this.jdField_a_of_type_Alcn.d.diyTextTransparency);
    }
    startActivityForResult(localIntent, 600001);
  }
  
  public void bOE()
  {
    Intent localIntent = new Intent(this, QRDisplayActivity.class);
    String str = this.app.getCurrentAccountUin();
    localIntent.putExtra("title", getString(2131717228));
    localIntent.putExtra("nick", aqgv.n(this.app, str));
    localIntent.putExtra("uin", str);
    localIntent.putExtra("type", 1);
    localIntent.putExtra("reportFlag", 1);
    startActivity(localIntent);
  }
  
  public void bOF()
  {
    if (this.jdField_a_of_type_Alcn.cwc)
    {
      bOG();
      return;
    }
    if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Alcn.e))
    {
      afxx.a(this.app).a(this.app, this.jdField_a_of_type_Alcn.e, new vab(this));
      return;
    }
    b(this.app, this, this.jdField_a_of_type_Alcn);
  }
  
  public void bOH()
  {
    avpw.d locald = avpw.d.a();
    locald.cMP = this.app.getCurrentAccountUin();
    String str2 = this.app.getCurrentNickname();
    String str1 = str2;
    if (aqmr.isEmpty(str2)) {
      str1 = this.app.getCurrentNickname();
    }
    locald.nickname = str1;
    avpw.a(this, locald, Long.valueOf(Long.parseLong(this.jdField_a_of_type_Alcn.e.uin)), 1, this.jdField_a_of_type_Alcn.e.bIZ, -1, this.jdField_a_of_type_Ahyh);
  }
  
  public void bOI()
  {
    ThreadManager.post(new FriendProfileCardActivity.40(this), 8, null, true);
  }
  
  void bOJ()
  {
    if ((this.jdField_a_of_type_Alcn.e.bIZ == 100) && (GesturePWDUtils.getJumpLock(getActivity(), this.app.getCurrentAccountUin()))) {
      startUnlockActivity();
    }
  }
  
  public void bOK()
  {
    Object localObject3 = null;
    for (;;)
    {
      FrameLayout localFrameLayout;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "updateTheme: ");
        }
        localFrameLayout = (FrameLayout)findViewById(16908290);
        if (this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs == null) {
          break label711;
        }
        localFrameLayout.setForeground(null);
        this.mContentView.setBackgroundResource(0);
        if (this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs.agr == alcs.agm)
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(0);
          if (this.dl != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setImage(this.dl, (int)(this.root.getWidth() * 1.1D), (int)(this.root.getHeight() * 1.1D), 1.0F);
          }
          this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(0);
          if (this.dm != null) {
            this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setImage(this.dm, (int)(this.root.getWidth() * 1.1D), (int)(this.root.getHeight() * 1.1D), -1.0F);
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "updateTheme: set currentBackgroundDrawable");
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileQVipDiyView))
          {
            localFrameLayout.setBackgroundDrawable(null);
            this.jdField_aT_of_type_AndroidWidgetFrameLayout.setVisibility(0);
            Object localObject1 = localObject3;
            bOz();
            alcs.a(this.mContentView, "background", this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs, "background");
            if (this.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agk) {
              break label615;
            }
            alcs.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs, "shoppingUserInfoBackground");
            if (Build.VERSION.SDK_INT >= 11)
            {
              if ((this.jdField_a_of_type_Alcn.d == null) || ((this.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agi) && (this.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agk)) || (!(this.dB instanceof FriendProfileCardBgDrawable))) {
                break label665;
              }
              ThreadManager.post(new BlurBackgroundJob(this.jdField_b_of_type_Auru, this.dB), 5, null, true);
            }
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label690;
            }
            localObject3 = localObject1;
            if (this.mask == null) {
              break label917;
            }
            this.mask.setVisibility(0);
            if (localObject1 != null) {
              QAPM.setAbFactor("资料卡背景", localObject1, txf.class);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs)) {
              break label922;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "update item style");
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, false, new String[0]);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(8);
          this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView.setVisibility(8);
          continue;
        }
        this.jdField_aT_of_type_AndroidWidgetFrameLayout.removeAllViews();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateTheme exception msg=" + localException.getMessage());
        }
        localException.printStackTrace();
        return;
      }
      this.jdField_aT_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      localFrameLayout.setBackgroundDrawable(this.dB);
      Object localObject2 = localObject3;
      if (this.dB != null) {
        if (aqsj.j(this.dB))
        {
          localObject2 = "card-video";
        }
        else if (aqsj.k(this.dB))
        {
          localObject2 = "card-etc";
        }
        else
        {
          localObject2 = localObject3;
          label917:
          if ((this.dB instanceof FriendProfileCardBgDrawable)) {
            label665:
            label922:
            if (((FriendProfileCardBgDrawable)this.dB).isDynamic)
            {
              localObject2 = "card-dynamic";
              continue;
              label615:
              if (alcs.cy(this.jdField_a_of_type_Alcn.d.lCurrentStyleId))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundDrawable(null);
              }
              else
              {
                alcs.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView, "background", this.jdField_a_of_type_Alcn.jdField_b_of_type_Alcs, "commonMaskBackground");
                continue;
                localObject3 = localFrameLayout.getChildAt(0);
                if ((localObject3 != null) && (((View)localObject3).getBackground() != null))
                {
                  ((View)localObject3).setBackgroundDrawable(null);
                  continue;
                  localObject3 = localObject2;
                  if (this.mask != null)
                  {
                    this.mask.setVisibility(8);
                    continue;
                    if (alcs.cy(this.jdField_a_of_type_Alcn.d.lCurrentStyleId))
                    {
                      localObject3 = "card-diy";
                      localFrameLayout.setForeground(null);
                      this.mContentView.setBackgroundResource(0);
                      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
                      localFrameLayout.setBackgroundDrawable(null);
                      this.jdField_aT_of_type_AndroidWidgetFrameLayout.setVisibility(0);
                      bOz();
                      if (ThemeUtil.isInNightMode(this.app))
                      {
                        if (this.mask != null)
                        {
                          this.mask.setVisibility(0);
                          localObject2 = "card-diy";
                        }
                      }
                      else if (this.mask != null)
                      {
                        this.mask.setVisibility(8);
                        localObject2 = "card-diy";
                      }
                    }
                    else
                    {
                      localObject3 = "card-default";
                      if (QLog.isColorLevel()) {
                        QLog.d("FriendProfileCardActivity", 2, "updateTheme: cardInfo.currentTemplate is null");
                      }
                      localFrameLayout.setForeground(getResources().getDrawable(2130851111));
                      localFrameLayout.setBackgroundResource(2130846670);
                      this.mContentView.setBackgroundResource(0);
                      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setBackgroundResource(0);
                      this.jdField_aT_of_type_AndroidWidgetFrameLayout.removeAllViews();
                      this.jdField_aT_of_type_AndroidWidgetFrameLayout.setVisibility(8);
                      if (this.mask != null) {
                        this.mask.setVisibility(8);
                      }
                      bOZ();
                    }
                  }
                  localObject2 = localObject3;
                }
              }
            }
            else
            {
              label690:
              label711:
              localObject2 = "card-static";
            }
          }
        }
      }
    }
  }
  
  public void bOL()
  {
    int i = -77;
    int j;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.d.diyText)) && (this.jdField_a_of_type_Alcn.d.lCurrentStyleId == alcs.agj))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = new DiyTextView(this);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setOnMeasuredListener(new vag(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setMaxSize(this.root.getWidth() * 2 / 3);
      this.sE.setVisibility(0);
      j = (int)(this.jdField_a_of_type_Alcn.d.diyTextTransparency * 255.0F);
      if (j >= -77) {}
    }
    for (;;)
    {
      Object localObject = this.sE;
      if (i > 0) {}
      for (j = -16777216;; j = -1)
      {
        ((View)localObject).setBackgroundColor(j);
        this.sE.getBackground().setAlpha(Math.abs(i));
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.hy(this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageDegree(this.jdField_a_of_type_Alcn.d.diyTextDegree);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setImageScale(this.jdField_a_of_type_Alcn.d.diyTextScale);
        localObject = getResources().getDisplayMetrics();
        SingleTouchLayout localSingleTouchLayout = this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout;
        float f1 = this.jdField_a_of_type_Alcn.d.diyTextLocX;
        float f2 = ((DisplayMetrics)localObject).widthPixels;
        float f3 = this.jdField_a_of_type_Alcn.d.diyTextLocY;
        localSingleTouchLayout.setCenterPoint(f1 * f2, ((DisplayMetrics)localObject).heightPixels * f3);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setHiBoom(this.jdField_a_of_type_Alcn.d.diyTextFontId, 1, ahxs.c);
        this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView.setText(this.jdField_a_of_type_Alcn.d.diyText);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.atC();
        this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.invalidate();
        return;
        if (j <= 77) {
          break label370;
        }
        i = 77;
        break;
      }
      this.sE.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqProfileDiyDiyTextView = null;
      return;
      label370:
      i = j;
    }
  }
  
  public void bOM()
  {
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_Alcn.d != null) && ((this.dB instanceof FriendProfileCardBgDrawable))) {
      ThreadManager.post(new FriendProfileCardActivity.46(this, ((FriendProfileCardBgDrawable)this.dB).ah()), 5, null, true);
    }
  }
  
  public void bON()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.pZ != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheQuality(524288);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(8);
      this.dn = this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.getDrawingCache();
      this.mContentView.findViewById(2131369189).setVisibility(8);
      if ((this.dn != null) && (!this.dn.isRecycled()))
      {
        this.pZ.setBackgroundDrawable(new BitmapDrawable(getResources(), this.dn));
        this.pZ.setVisibility(0);
      }
    }
  }
  
  public void bOO()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) && (this.pZ != null))
    {
      this.pZ.setBackgroundDrawable(null);
      this.pZ.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.destroyDrawingCache();
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setDrawingCacheEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.dn = null;
      this.mContentView.findViewById(2131369189).setVisibility(0);
    }
  }
  
  public void bOP()
  {
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.smoothScrollToPosition(0);
  }
  
  public void bOQ()
  {
    String str1;
    String str2;
    if (!isFinishing())
    {
      bFU();
      if (this.bGY != 1) {
        break label67;
      }
      str1 = getString(2131697261);
      str2 = acfp.m(2131706628);
    }
    for (;;)
    {
      this.z = aqha.a(this, 0, str1, str2, 2131697251, 2131697252, this.v, this.w);
      this.z.show();
      return;
      label67:
      if (this.bGY == 2)
      {
        str1 = getString(2131697253);
        str2 = acfp.m(2131706634);
      }
      else if (this.bGY == 3)
      {
        str1 = getString(2131700888);
        str2 = acfp.m(2131706605);
      }
      else if (this.bGY == 4)
      {
        str1 = getString(2131721126);
        str2 = "开通QQ大会员即可使用该名片";
      }
      else
      {
        str1 = getString(2131697253);
        str2 = acfp.m(2131706638);
      }
    }
  }
  
  void bOR()
  {
    if ((this.dB != null) && ((this.dB instanceof BitmapDrawable)))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)this.dB;
      Object localObject = aqep.I(this, this.aNc);
      localObject = "profilecard:" + (String)localObject;
      localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
      if ((localObject != null) && (((Pair)localObject).first != null) && (localBitmapDrawable.getConstantState() != ((Pair)localObject).first))
      {
        localBitmapDrawable.getBitmap().recycle();
        this.dB = null;
      }
    }
  }
  
  public void bOS()
  {
    int i = 0;
    CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
    if ((localCardHandler != null) && (this.jdField_a_of_type_Alcn.d != null)) {}
    for (;;)
    {
      boolean bool;
      synchronized (bM)
      {
        int j = this.ay.get();
        this.ay.set(0);
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, String.format("reqFavorite cacheVoteNum=%s", new Object[] { Integer.valueOf(j) }));
        }
        if (j > 0)
        {
          localCardHandler.a(Long.valueOf(this.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.jdField_a_of_type_Alcn.e.uin).longValue(), this.jdField_a_of_type_Alcn.d.vCookies, this.jdField_a_of_type_Alcn.d.favoriteSource, j, 0);
          bool = ((ajqh)this.app.getManager(207)).ct(Long.valueOf(this.jdField_a_of_type_Alcn.d.uin).longValue());
          if (PraiseManager.f(this.app) <= 0) {
            break label272;
          }
          if (bool)
          {
            i = 3;
            anot.b(this.app, "CliOper", "", "", "P_prof", "Prof_good", 1, j, i, Integer.toString(ProfileActivity.eP(this.jdField_a_of_type_Alcn.e.bJa)), String.valueOf(j), this.app.getCurrentAccountUin(), this.jdField_a_of_type_Alcn.d.uin);
          }
        }
        else
        {
          return;
        }
      }
      i = 2;
      continue;
      label272:
      if (bool) {
        i = 1;
      }
    }
  }
  
  public void bOT()
  {
    if (getIntent().getBooleanExtra("from_newer_guide", false))
    {
      if (this.jdField_a_of_type_Alcn.e.pa != 0) {
        break label110;
      }
      if (((PhoneContactManagerImp)this.app.getManager(11)).Uv())
      {
        localIntent = new Intent(this, SplashActivity.class);
        localIntent.putExtra("main_tab_id", 1);
        localIntent.setFlags(603979776);
        startActivity(localIntent);
      }
    }
    else
    {
      return;
    }
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    localIntent.putExtra("kSrouce", 10);
    startActivity(localIntent);
    return;
    label110:
    if (this.jdField_C_of_type_AndroidContentIntent == null)
    {
      this.jdField_C_of_type_AndroidContentIntent = new Intent();
      this.jdField_C_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_Alcn.e.uin);
    }
    setResult(-1, this.jdField_C_of_type_AndroidContentIntent);
  }
  
  void bOU()
  {
    ThreadManager.post(new FriendProfileCardActivity.56(this), 5, null, false);
    if ((this.er.getTag() instanceof albb))
    {
      Object localObject = (albb)this.er.getTag();
      if ((((albb)localObject).nType == 98) || (((albb)localObject).nType == 99))
      {
        localObject = aqep.o();
        this.jdField_b_of_type_Auru.obtainMessage(104, localObject).sendToTarget();
      }
    }
  }
  
  void bOX()
  {
    int i = 3;
    int k = this.jdField_a_of_type_Alcn.e.pa;
    int j = this.jdField_a_of_type_Alcn.e.bJa;
    boolean bool;
    if (k == 0)
    {
      bool = true;
      if (!bool) {
        break label187;
      }
      if (j != 8) {
        break label130;
      }
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, String.format("handleReportEntryStatus isHost=%s fromType=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
      }
      if (!bool) {
        break label291;
      }
      anot.a(this.app, "dc00898", "", "", "0X8007EB3", "0X8007EB3", i, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label130:
      if (j == 1) {
        i = 2;
      } else if (j != 107) {
        if (j == 106)
        {
          i = 5;
        }
        else if (j == 7)
        {
          i = 6;
        }
        else if (j == 98)
        {
          i = 9;
        }
        else
        {
          i = 15;
          continue;
          label187:
          if (j == 61) {
            i = 1;
          } else if (j == 1) {
            i = 2;
          } else if (j != 107) {
            if (j == 106) {
              i = 5;
            } else if (j == 109) {
              i = 6;
            } else if (j == 59) {
              i = 7;
            } else if (j == 98) {
              i = 9;
            } else if (j == 88) {
              i = 10;
            } else if (j == 7) {
              i = 11;
            } else {
              i = 15;
            }
          }
        }
      }
    }
    label291:
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e)) {}
    for (String str1 = "2";; str1 = "1")
    {
      String str3 = this.jdField_a_of_type_Alcn.e.uin;
      String str2 = str3;
      if (str3 == null) {
        str2 = "";
      }
      anot.a(this.app, "dc00898", "", str2, "0X8007EB4", "0X8007EB4", i, 0, "", "", str1, "");
      return;
    }
  }
  
  public void bOZ()
  {
    if ((this.jdField_a_of_type_Alcn.e.pa == 33) || (PG()))
    {
      AS(0);
      return;
    }
    AS(1);
  }
  
  public void bOo()
  {
    Object localObject;
    if (!this.aRf)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "send async message to init card in db");
      }
      localObject = aurh.b;
      if ((localObject != null) && (((aurh)localObject).aJB())) {
        ((aurh)localObject).aaY(4);
      }
      this.aRf = true;
      if (this.f != null)
      {
        localObject = null;
        if (this.jdField_a_of_type_Alcn.e.pa != 33) {
          break label184;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        this.f.sendMessage((Message)localObject);
      }
      if ((this.jdField_a_of_type_Alcn.e.pa == 71) || (this.jdField_a_of_type_Alcn.e.pa == 71)) {
        anot.a(this.app, "CliOper", "", "", "Network_circle", "Network_circle_prof", eP(this.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(a(this.jdField_a_of_type_Alcn.e)), Integer.toString(this.jdField_a_of_type_Alcn.e.bJd), "", "");
      }
      return;
      label184:
      if (this.jdField_a_of_type_Alcn.e.pa == 80)
      {
        localObject = this.f.obtainMessage();
        ((Message)localObject).what = 9;
        ((Message)localObject).obj = this.jdField_a_of_type_Alcn.e.uin;
      }
      else if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e))
      {
        localObject = this.f.obtainMessage();
        ((Message)localObject).what = 1;
        ((Message)localObject).obj = this.jdField_a_of_type_Alcn.e.uin;
      }
      else
      {
        localObject = this.f.obtainMessage();
        ((Message)localObject).what = 2;
        ((Message)localObject).obj = this.jdField_a_of_type_Alcn.e.uin;
      }
    }
  }
  
  protected void bOp()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify");
    localIntentFilter.addAction("com.tencent.mobileqq.view.self.album");
    localIntentFilter.addAction("com.tencent.mobileqq.card.modify_personality_label");
    localIntentFilter.setPriority(2147483647);
    try
    {
      if (!this.aWm)
      {
        registerReceiver(this.aB, localIntentFilter);
        this.aWm = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.FrdProfileCard", 2, localThrowable.toString());
    }
  }
  
  public void bOq()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (this.jdField_a_of_type_Alcn.d != null)) {
      this.jdField_b_of_type_Auru.sendEmptyMessage(103);
    }
  }
  
  public void bOr()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendProfileCardActivity", 2, "savePersonalibyLabel2Card");
    }
    ThreadManager.postImmediately(new FriendProfileCardActivity.17(this, (albz)this.app.getBusinessHandler(112)), null, true);
  }
  
  public void bOs()
  {
    ausj localausj = (ausj)auss.a(this, null);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mCoverUrl)) {
      localArrayList.add(new uyw(this, 2131694829));
    }
    localArrayList.add(new uyx(this, 2131694827));
    localArrayList.add(new uyz(this, 2131694825));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      localausj.addButton(((aqnl.a)localIterator.next()).eac);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new uza(this, localArrayList, localausj));
    try
    {
      if (!isFinishing()) {
        localausj.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bOt()
  {
    boolean bool = false;
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    PhoneContact localPhoneContact = localPhoneContactManagerImp.c(a(this.jdField_a_of_type_Alcn.e));
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(2131694888);
    if (this.jdField_a_of_type_Alcn.e.pa == 53)
    {
      anot.a(this.app, "CliOper", "", "", "0X8007015", "0X8007015", 0, 0, "", "", "", "");
      if (localPhoneContact != null) {
        break label222;
      }
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new uzb(this, localPhoneContactManagerImp, bool, localausj));
      try
      {
        if (!isFinishing()) {
          localausj.show();
        }
        return;
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
      }
      anot.a(this.app, "CliOper", "", "", "0X8007167", "0X8007167", 0, 0, "", "", "", "");
      if ((TextUtils.isEmpty(oP())) || (localPhoneContact == null)) {
        break;
      }
      if (localPhoneContact.isHiden) {}
      for (i = 2131694890;; i = 2131694887)
      {
        localausj.addButton(i);
        break;
      }
      label222:
      bool = localPhoneContact.isHiden;
    }
  }
  
  void bOu()
  {
    if (getIntent().getIntExtra("requestCode", -1) == 1023)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("intent_key_has_ever_vote", this.aWs);
      setResult(-1, localIntent);
    }
  }
  
  void bOv()
  {
    if (this.jdField_m_of_type_ComTencentMobileqqRedtouchRedTouch == null) {
      return;
    }
    altq localaltq = (altq)this.app.getManager(36);
    this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaltq.getAppInfoByPath(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
    this.jdField_m_of_type_ComTencentMobileqqRedtouchRedTouch.e(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    localaltq.i(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
  }
  
  public void bOw()
  {
    if ((this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo != null) && (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() != 0))
    {
      altq localaltq = (altq)this.app.getManager(36);
      if (localaltq != null) {
        localaltq.OS(String.format("%d%s%d", new Object[] { Integer.valueOf(100100), ".", Integer.valueOf(100120) }));
      }
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = null;
    }
  }
  
  @TargetApi(11)
  void bOx()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout");
    }
    this.jdField_a_of_type_Aqmv.dn("initInfoCardCommonLayoutStart", true);
    Object localObject = getResources();
    DisplayMetrics localDisplayMetrics = ((Resources)localObject).getDisplayMetrics();
    int i = ((Resources)localObject).getDimensionPixelSize(2131299627);
    this.bGV = (((Resources)localObject).getDimensionPixelSize(2131297973) - i - (int)(localDisplayMetrics.density * 66.0F));
    this.l = new AlphaAnimation(0.0F, 1.0F);
    this.l.setDuration(300L);
    this.l.setInterpolator(this, 17432581);
    this.l.setAnimationListener(this.q);
    this.jdField_m_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_m_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_m_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_m_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.q);
    this.root = View.inflate(this, 2131561612, null);
    if ((this.root instanceof PerfRelativeLayout)) {
      ((PerfRelativeLayout)this.root).setOnDrawCompleteListener(this.jdField_a_of_type_Ahmm);
    }
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)this.root.findViewById(2131365101));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setMotionEventInterceptor(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollChangeListener(this.jdField_a_of_type_ComTencentWidgetListView$d);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setOnScrollListener(this.h);
    this.sD = this.root.findViewById(2131365494);
    this.mask = this.root.findViewById(2131374954);
    this.mTitleBar = this.root.findViewById(2131373636);
    this.leftView = ((TextView)this.root.findViewById(2131369579));
    this.er = ((TextView)this.root.findViewById(2131369612));
    this.pX = ((ImageView)this.root.findViewById(2131369594));
    this.pY = ((ImageView)this.root.findViewById(2131372559));
    this.centerView = ((TextView)this.root.findViewById(2131369627));
    this.g = ((ImmersiveTitleBar2)this.root.findViewById(2131379866));
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.root.findViewById(2131374953));
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.forbiddenLayer();
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setFitFullScreenXY();
    bOZ();
    this.mContentView = View.inflate(this, 2131561564, null);
    this.cT = ((ViewGroup)this.mContentView.findViewById(2131369172));
    this.cT.setTag(new albb(29, null));
    this.cT.setOnClickListener(this.mOnClickListener);
    localObject = (ImageView)this.mContentView.findViewById(2131369164);
    if (localObject != null) {}
    try
    {
      localObject = (Animatable)((ImageView)localObject).getDrawable();
      if (!((Animatable)localObject).isRunning()) {
        ((Animatable)localObject).start();
      }
      label534:
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = ((ProfileCardMoreInfoView)this.mContentView.findViewById(2131369180));
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.a(this.jdField_a_of_type_Alcn, this.app, this, this.aWq, this.jdField_a_of_type_Arho, this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.daS = this.aWx;
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.daT = this.aWy;
      this.pZ = ((ImageView)this.mContentView.findViewById(2131366701));
      this.Dq = ((TextView)this.root.findViewById(2131380586));
      this.ga = ((LinearLayout)this.root.findViewById(2131364045));
      this.ga.setVisibility(8);
      e(this.ga);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)this.root.findViewById(2131382364));
      this.jdField_b_of_type_ComTencentMobileqqProfileViewShakeImageView = ((ShakeImageView)this.root.findViewById(2131382365));
      this.sE = this.root.findViewById(2131366013);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout = ((SingleTouchLayout)this.root.findViewById(2131366012));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setEditable(false);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewSingleTouchLayout.setMovable(false);
      this.jdField_aT_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.root.findViewById(2131375404));
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.addHeaderView(this.mContentView);
      this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new auvv(null));
      localObject = new ProfileTopGestureLayout(this);
      ((ProfileTopGestureLayout)localObject).setOnFlingGesture(this);
      ((ProfileTopGestureLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((ProfileTopGestureLayout)localObject).addView(this.root);
      setContentView((View)localObject);
      localObject = (FrameLayout)findViewById(16908290);
      if (localObject != null) {
        ((FrameLayout)localObject).setBackgroundResource(2130846670);
      }
      if (this.jdField_b_of_type_Auru != null)
      {
        localObject = this.jdField_b_of_type_Auru.obtainMessage(10);
        this.jdField_b_of_type_Auru.sendMessageDelayed((Message)localObject, 10000L);
      }
      bOW();
      ZM();
      bOn();
      this.jdField_a_of_type_Aqmv.X("initInfoCardCommonLayoutEnd", "initInfoCardCommonLayoutStart", false);
      return;
    }
    catch (Exception localException)
    {
      break label534;
    }
  }
  
  public void bOy()
  {
    if ((this.app == null) || (this.jdField_a_of_type_Alcn.e == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.uin))) {}
    int i;
    do
    {
      return;
      if (!ahes.sEnable)
      {
        QLog.i("ColorScreenManager", 1, "ColorScreenManager.sEnable is false, loadColorScreen fail.");
        return;
      }
      if (anlm.ayn())
      {
        QLog.i("ColorScreenManager", 1, "loadColorScreen, SimpleUIMode is open now");
        return;
      }
      this.aWn = true;
      i = ((acle)this.app.getBusinessHandler(13)).ct(this.jdField_a_of_type_Alcn.e.uin);
      if (QLog.isColorLevel()) {
        QLog.i("ColorScreenManager", 2, "loadColorScreen " + i + " mLastColorScreen " + this.bGX);
      }
      if ((i > 0) && (i != this.bGX)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ColorScreenManager", 2, "loadColorScreen early return");
    return;
    this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.bGX = i;
    if (this.jdField_a_of_type_Alcn.e.uin.equals(this.app.getCurrentAccountUin())) {}
    for (Object localObject = "1";; localObject = "2")
    {
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Bubble", "ShowEffect", (String)localObject, 1, 0, 0, null, Integer.toString(i), null);
      localObject = ((aqrc)this.app.getManager(235)).a;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader = new ColorScreenLoader(i);
      ((ahes)localObject).a(i, aqrg.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$ColorScreenLoader));
      return;
    }
  }
  
  protected void bP(Intent paramIntent)
  {
    try
    {
      Object localObject = paramIntent.getComponent();
      if ((localObject != null) && (TextUtils.equals(((ComponentName)localObject).getClassName(), QQBrowserActivity.class.getName())))
      {
        localObject = paramIntent.getStringExtra("url");
        String str = paramIntent.getStringExtra("big_brother_source_key");
        if (TextUtils.isEmpty(str)) {
          paramIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("dealIntent key: %s, url: %s", new Object[] { str, localObject }));
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void bPa()
  {
    anot.a(this.app, "CliOper", "", "", "0X800A9C2", "0X800A9C2", 0, 0, "", "", "", "");
    int i;
    if (this.jdField_a_of_type_Alcn.e.pa == 0)
    {
      i = 1;
      if (i != 0) {
        break label82;
      }
      AP(0);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "gotoQQVipWeb xman  ");
      }
    }
    label82:
    do
    {
      return;
      i = 0;
      break;
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("url", "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=card");
      localIntent.putExtra("hide_more_button", true);
      startActivity(localIntent);
    } while (!QLog.isColorLevel());
    QLog.d("FriendProfileCardActivity", 2, "QQXMAN_URL_HOST_SETTING  " + "https://ti.qq.com/qqdaren/index?_wv=16777219&_wwv=128&ADTAG=card");
  }
  
  public void baG()
  {
    ThreadManager.post(new FriendProfileCardActivity.59(this), 5, null, false);
  }
  
  public void c(ProfileActivity.CardContactInfo paramCardContactInfo)
  {
    if (paramCardContactInfo == null)
    {
      paramCardContactInfo = null;
      if ((paramCardContactInfo != null) && (paramCardContactInfo.length() > 0))
      {
        if (!aqiw.isNetSupport(BaseApplication.getContext())) {
          break label189;
        }
        if (("".equals(paramCardContactInfo)) || (paramCardContactInfo.equals(this.jdField_a_of_type_Alcn.e.remark))) {
          break label178;
        }
        FriendListHandler localFriendListHandler = (FriendListHandler)this.app.getBusinessHandler(1);
        if (localFriendListHandler == null) {
          break label167;
        }
        localFriendListHandler.C(this.jdField_a_of_type_Alcn.e.uin, paramCardContactInfo, false);
        this.bFB |= 0x1;
        vx(paramCardContactInfo);
      }
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "P_prof", "Edit_name", eP(this.jdField_a_of_type_Alcn.e.bJa), 0, Integer.toString(a(this.jdField_a_of_type_Alcn.e)), "", "", "");
      return;
      paramCardContactInfo = paramCardContactInfo.aOL;
      break;
      label167:
      cf(2131694914, 1);
      continue;
      label178:
      cf(2131694895, 1);
      continue;
      label189:
      cf(2131696346, 1);
    }
  }
  
  public void c(TroopInfo paramTroopInfo)
  {
    ProfileActivity.AllInOne localAllInOne = this.jdField_a_of_type_Alcn.e;
    if ((localAllInOne != null) && (paramTroopInfo != null) && (ProfileActivity.gk(localAllInOne.pa)) && (TextUtils.isEmpty(localAllInOne.troopUin)))
    {
      localAllInOne.troopUin = paramTroopInfo.troopcode;
      localAllInOne.troopcode = paramTroopInfo.troopuin;
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, String.format("checkAndUpdateTroopInfo troop[%s, %s]", new Object[] { paramTroopInfo.troopuin, paramTroopInfo.troopcode }));
      }
    }
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).show(getTitleBarHeight());
  }
  
  public void ci(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).show(getTitleBarHeight());
  }
  
  @SuppressLint({"ServiceCast", "NewApi"})
  public void copyContent(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          ((android.text.ClipboardManager)getSystemService("clipboard")).setText(paramString);
          return;
        }
        android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)getSystemService("clipboard");
        alkw.a(localClipboardManager, paramString);
        localClipboardManager.setText(paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("FriendProfileCardActivity", 2, "copyContent fail!", paramString);
      }
    }
  }
  
  public void d(int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    this.bGU = paramInt;
    if (this.cm == null) {
      this.cm = getResources().getStringArray(2130968638);
    }
    ausj localausj = (ausj)auss.a(this, null);
    paramInt = 0;
    if (paramInt < paramArrayOfInt.length)
    {
      if (paramArrayOfInt[paramInt] == 16) {
        localausj.addCancelButton(this.cm[paramArrayOfInt[paramInt]]);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if ((paramArrayOfInt[paramInt] >= 0) && (paramArrayOfInt[paramInt] < this.cm.length)) {
          localausj.addButton(this.cm[paramArrayOfInt[paramInt]], 1);
        }
      }
    }
    localausj.a(new uzc(this, localausj));
    paramInt = i;
    if (this.bGU == 98)
    {
      localausj.setOnBottomCancelListener(new uzd(this, localausj));
      paramInt = i;
    }
    while (paramInt < this.fp.length)
    {
      if (this.fp[paramInt] == 32) {
        localausj.a(new uze(this, localausj, paramInt));
      }
      paramInt += 1;
    }
    try
    {
      if (!isFinishing()) {
        localausj.show();
      }
      return;
    }
    catch (Exception paramArrayOfInt)
    {
      paramArrayOfInt.printStackTrace();
    }
  }
  
  public boolean d(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.d(paramView, paramMotionEvent);
    }
    return false;
  }
  
  public void de(Context paramContext)
  {
    try
    {
      Object localObject2 = Class.forName("android.util.GeneralUtil");
      Field localField = ((Class)localObject2).getDeclaredField("myInstance");
      localField.setAccessible(true);
      Object localObject1 = localField.get(null);
      if (localObject1 != null)
      {
        localObject2 = ((Class)localObject2).getDeclaredField("ctxt");
        ((Field)localObject2).setAccessible(true);
        localObject2 = ((Field)localObject2).get(localObject1);
        if (localObject2 == paramContext) {
          localField.set(null, null);
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendProfileCardActivity", 2, String.format("fixGeneralUtilLeakContext ctxt:%s", new Object[] { localObject2 }));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendProfileCardActivity", 2, String.format("fixGeneralUtilLeakContext myInstance:%s", new Object[] { localObject1 }));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      paramContext.printStackTrace();
      QLog.i("FriendProfileCardActivity", 2, String.format("fixGeneralUtilLeakContext Exception:%s", new Object[] { paramContext.toString() }));
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1 = null;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = false;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    Object localObject2;
    acff localacff;
    if (paramInt1 == 1037) {
      if ((paramInt2 == -1) && (paramIntent != null) && (this.jdField_a_of_type_Alcn.e.pa == 0))
      {
        localObject2 = paramIntent.getStringArrayListExtra("imageUrl");
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localacff = (acff)this.app.getManager(51);
          if (localacff != null) {
            break label193;
          }
          if (localObject1 != null)
          {
            ((Card)localObject1).addQzonePhotoList((ArrayList)localObject2, paramIntent);
            ((Card)localObject1).hasFakeData = true;
            this.jdField_a_of_type_Alcn.d = ((Card)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, false, new String[] { "map_key_qzone" });
          }
        }
      }
    }
    label193:
    do
    {
      for (;;)
      {
        return;
        localObject1 = localacff.b(this.jdField_a_of_type_Alcn.e.uin);
        break;
        if (paramInt1 == 1019)
        {
          if (this.jdField_a_of_type_Vbv != null) {
            this.jdField_a_of_type_Vbv.D(paramInt2, paramIntent);
          }
        }
        else if (paramInt1 == 1024)
        {
          if (this.jdField_a_of_type_Vbv != null) {
            this.jdField_a_of_type_Vbv.E(paramInt2, paramIntent);
          }
        }
        else
        {
          if (paramInt1 == 1022)
          {
            ((CardHandler)this.app.getBusinessHandler(2)).eD(this.jdField_a_of_type_Alcn.e.uin, "");
            bO(paramIntent);
            return;
          }
          if (paramInt1 == 4)
          {
            if ((paramInt2 == -1) && (paramIntent != null)) {
              if (paramIntent.hasExtra("result"))
              {
                paramIntent = paramIntent.getStringExtra("result");
                if (QLog.isColorLevel()) {
                  QLog.d("FriendProfileCardActivity", 2, "onActivityResult, resultStr : " + paramIntent);
                }
                if (!TextUtils.isEmpty(paramIntent))
                {
                  try
                  {
                    paramIntent = new JSONObject(paramIntent);
                    if (paramIntent == null) {
                      continue;
                    }
                    paramIntent = paramIntent.get("payState");
                    if ((paramIntent == null) || (!"0".equals(String.valueOf(paramIntent)))) {
                      continue;
                    }
                    a(0L, null, null, false);
                    return;
                  }
                  catch (JSONException paramIntent)
                  {
                    paramIntent.printStackTrace();
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.e("FriendProfileCardActivity", 2, "onActivityResult, JSONException : " + paramIntent.getMessage());
                    return;
                  }
                  catch (Exception paramIntent)
                  {
                    paramIntent.printStackTrace();
                  }
                  if (QLog.isColorLevel()) {
                    QLog.e("FriendProfileCardActivity", 2, "onActivityResult, Exception : " + paramIntent.getMessage());
                  }
                }
              }
              else if (QLog.isColorLevel())
              {
                QLog.e("FriendProfileCardActivity", 2, "onActivityResult, data contain no result key.");
              }
            }
          }
          else if (paramInt1 == 1024)
          {
            if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false))) {
              this.jdField_C_of_type_AndroidContentIntent = paramIntent;
            }
          }
          else if (paramInt1 == 1026)
          {
            if ((paramInt2 != 1001) && (this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.e != null) && (this.jdField_a_of_type_Alcn.e.pa != 33))
            {
              this.jdField_a_of_type_Aqmv = new aqmv();
              this.aWp = false;
              this.bGZ = 0;
              if (this.f != null)
              {
                paramIntent = this.f.obtainMessage();
                if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e))
                {
                  paramIntent.what = 1;
                  paramIntent.obj = this.jdField_a_of_type_Alcn.e.uin;
                  this.f.sendMessage(paramIntent);
                }
              }
            }
          }
          else if (paramInt1 == 1010)
          {
            if ((this.jdField_a_of_type_Alcn.e.bIZ == 101) && (paramInt2 == -1)) {
              finish();
            }
          }
          else if (paramInt1 == 1008)
          {
            if ((paramIntent != null) && (paramIntent.getExtras() != null))
            {
              bool1 = paramIntent.getExtras().getBoolean("photowall_updated");
              paramIntent = (CoverCacheData)paramIntent.getExtras().getParcelable("current_cover");
              if (((paramInt2 == -1) || (bool1)) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)) {
                this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(paramIntent);
              }
              if (paramIntent == null) {
                continue;
              }
              localObject1 = Message.obtain();
              ((Message)localObject1).what = 3;
              ((Message)localObject1).obj = paramIntent;
              if (this.f == null) {
                continue;
              }
              this.f.sendMessage((Message)localObject1);
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              continue;
            }
            try
            {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.getCoverCacheData();
              if (localObject1 != null)
              {
                paramIntent = new CoverCacheData();
                paramIntent.cNV = ((CoverCacheData)localObject1).cNV;
                paramIntent.a = ((CoverCacheData)localObject1).a;
                paramIntent.EY = ((CoverCacheData)localObject1).EY;
                paramIntent.type = ((CoverCacheData)localObject1).type;
                paramIntent.uin = ((CoverCacheData)localObject1).uin;
                paramIntent.cy = ((CoverCacheData)localObject1).cy;
                paramIntent.eyG = 0;
                paramIntent.eyG = 0;
                this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.e(paramIntent);
                localObject1 = Message.obtain();
                ((Message)localObject1).what = 3;
                ((Message)localObject1).obj = paramIntent;
                if (this.f != null)
                {
                  this.f.sendMessage((Message)localObject1);
                  return;
                }
              }
            }
            catch (Exception paramIntent)
            {
              paramIntent.printStackTrace();
              return;
            }
          }
        }
      }
      if (paramInt1 != 1007) {
        break label1298;
      }
    } while (this.jdField_a_of_type_Alcn.e.pa != 0);
    localObject1 = (acff)this.app.getManager(51);
    if (localObject1 == null)
    {
      localObject2 = null;
      label1002:
      if ((localObject2 != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null))
      {
        this.jdField_a_of_type_Alcn.d = ((Card)localObject2);
        this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.a.value = ((Card)localObject2).strNick;
        this.jdField_a_of_type_Alcn.gh[0] = ((Card)localObject2).strNick;
        this.jdField_a_of_type_Alcn.gh[4] = "";
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Alcn.e);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.f(this.jdField_a_of_type_Alcn);
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.j(this.jdField_a_of_type_Alcn);
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, true, new String[] { "map_key_sig", "map_key_qzone", "map_key_account_base_info" });
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("param_switches_changed", false)))
        {
          if ((this.jdField_a_of_type_Alcn.e.pa != 56) && (this.jdField_a_of_type_Alcn.e.pa != 57)) {
            break label1238;
          }
          localObject1 = this.jdField_a_of_type_Alcn.e.cf;
        }
      }
    }
    for (;;)
    {
      a(((Card)localObject2).feedPreviewTime, ((Card)localObject2).vSeed, (byte[])localObject1, true);
      setResult(-1, paramIntent);
      return;
      localObject2 = ((acff)localObject1).b(this.jdField_a_of_type_Alcn.e.uin);
      break label1002;
      label1238:
      if ((this.jdField_a_of_type_Alcn.e.pa == 35) || (this.jdField_a_of_type_Alcn.e.pa == 37) || (this.jdField_a_of_type_Alcn.e.pa == 36))
      {
        localObject1 = this.jdField_a_of_type_Alcn.e.cf;
        continue;
        if (paramInt1 == 1029)
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder().append("back from personality label gallery. resultcode==ok ");
            if (paramInt2 != -1) {
              break label1492;
            }
          }
          for (bool1 = bool2;; bool1 = false)
          {
            QLog.i("FriendProfileCardActivity", 2, bool1);
            if ((this.jdField_a_of_type_Alcn.e.pa == 0) && (this.jdField_a_of_type_Alcn.d != null) && (this.jdField_a_of_type_Alcn.d.personalityLabel != null) && (this.jdField_a_of_type_Alcn.d.personalityLabel.unreadCount > 0))
            {
              this.jdField_a_of_type_Alcn.d.personalityLabel.unreadCount = 0;
              if (QLog.isColorLevel()) {
                QLog.i("FriendProfileCardActivity", 2, "back from personality label gallery.clear vote");
              }
              if (this.jdField_a_of_type_Albg != null) {
                this.jdField_a_of_type_Albg.a(this.jdField_a_of_type_Alcn.d.personalityLabel, false, false);
              }
              bOr();
            }
            paramIntent = (albz)this.app.getBusinessHandler(112);
            if (paramInt2 != -1) {
              break;
            }
            paramIntent.fy(getCurrentAccountUin(), 0);
            return;
          }
        }
        if (paramInt1 == 1027)
        {
          bool2 = akka.bg(this.app);
          if (this.jdField_a_of_type_Alcn.e.pa == 0) {}
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendProfileCardActivity", 2, "update from medal, config=" + bool2 + " myProfile=" + bool1);
            }
            if ((!bool2) || (!bool1)) {
              break;
            }
            a(0L, null, null, false);
            return;
            bool1 = false;
          }
        }
        if (paramInt1 == 1035)
        {
          if (this.jdField_a_of_type_Zsi == null) {
            break;
          }
          this.jdField_a_of_type_Zsi.o(paramInt2, paramIntent);
          return;
        }
        if (paramInt2 != -1) {
          break;
        }
      }
      label1298:
      label1492:
      switch (paramInt1)
      {
      default: 
        return;
      case 5: 
        paramIntent = aqhu.getRealPathFromContentURI(this, this.x);
        paramInt1 = aqep.w(this);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Business_Origin", 100);
        PhotoUtils.a((Intent)localObject1, this, FriendProfileCardActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, aqep.BR());
        return;
      case 1012: 
        if (paramIntent == null) {
          break;
        }
        if (paramIntent.getBooleanExtra("finchat", false)) {
          finish();
        }
        for (;;)
        {
          bO(paramIntent);
          return;
          localObject1 = paramIntent.getStringExtra("remark");
          if (!aqft.equalsWithNullCheck(this.jdField_a_of_type_Alcn.e.remark, localObject1)) {
            vx((String)localObject1);
          }
        }
      case 21: 
        paramIntent.putExtra("selfSet_leftViewText", getString(2131720735));
        localObject1 = wja.a(new Intent(this, SplashActivity.class), null);
        ((Intent)localObject1).putExtras(new Bundle(paramIntent.getExtras()));
        paramIntent = ForwardUtils.a((Intent)localObject1);
        ForwardUtils.a(this.app, this, paramIntent, (Intent)localObject1);
        return;
      case 1000: 
        setResult(-1);
        finish();
        return;
      case 800: 
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          cf(2131696348, 1);
          return;
        }
        bool1 = bool3;
        if (paramIntent != null) {
          bool1 = paramIntent.getBooleanExtra("avatar_changed", false);
        }
        if (!bool1) {
          break;
        }
        localObject1 = paramIntent.getStringExtra("avatar_filepath");
        if (aqep.a(this.app, (String)localObject1, paramIntent))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Alcn.e);
          return;
        }
        cf(2131719573, 1);
        return;
      case 1004: 
        paramIntent = ((acff)this.app.getManager(51)).b(this.app.getCurrentAccountUin());
        if ((paramIntent == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
          break;
        }
        this.jdField_a_of_type_Alcn.d = paramIntent;
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, true, new String[] { "map_key_tag" });
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.q(this.jdField_a_of_type_Alcn);
        return;
      case 1018: 
        this.jdField_a_of_type_Alcn.e.bIW = 1;
        return;
      case 600001: 
        paramIntent = new Intent(this, FriendProfileCardActivity.class);
        paramIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(this.app.getCurrentAccountUin(), 0));
        paramIntent.putExtra("diyTextEditResult", true);
        startActivity(paramIntent);
        finish();
        return;
      case 8: 
        bool1 = paramIntent.getBooleanExtra("extra_is_deleted", false);
        bool2 = paramIntent.getBooleanExtra("extra_is_msg_tip_modify", false);
        bool3 = paramIntent.getBooleanExtra("extra_is_admin_modify", false);
        boolean bool4 = paramIntent.getBooleanExtra("isNeedFinish", false);
        boolean bool5 = paramIntent.getBooleanExtra("extra_is_level_modify", false);
        if ((bool2) || (bool5)) {
          AJ(2);
        }
        if (bool3) {
          AJ(4);
        }
        if (bool1) {
          AJ(1);
        }
        if (!bool4) {
          break;
        }
        paramIntent = new Intent();
        if (!bool1)
        {
          paramIntent.putExtra("isNeedFinish", bool4);
          setResult(-1, paramIntent);
        }
        for (;;)
        {
          finish();
          return;
          if (this.jdField_a_of_type_Alcn.drN == 8)
          {
            paramIntent.putExtra("key_troop_fee_notify_js_data_changed", true);
            paramIntent.putExtra("callback", this.aNk);
            setResult(-1, paramIntent);
          }
        }
      case 1034: 
        paramInt1 = paramIntent.getIntExtra("edit_action", 0);
        paramIntent = paramIntent.getStringExtra("nick");
        if ((paramInt1 == 3) || (paramInt1 == 4))
        {
          this.jdField_a_of_type_Alcn.gh[1] = paramIntent;
          return;
        }
        if (paramInt1 == 1)
        {
          this.jdField_a_of_type_Alcn.gh[0] = paramIntent;
          return;
        }
        if (paramInt1 != 2) {
          break;
        }
        this.jdField_a_of_type_Alcn.gh[4] = paramIntent;
        return;
        localObject1 = null;
      }
    }
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: getstatic 264	com/tencent/mobileqq/activity/FriendProfileCardActivity:az	Ljava/util/concurrent/atomic/AtomicInteger;
    //   3: iconst_1
    //   4: invokevirtual 4886	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   7: pop
    //   8: aload_0
    //   9: invokevirtual 2272	com/tencent/mobileqq/activity/FriendProfileCardActivity:getWindow	()Landroid/view/Window;
    //   12: bipush 253
    //   14: invokevirtual 4891	android/view/Window:setFormat	(I)V
    //   17: aload_0
    //   18: invokevirtual 2272	com/tencent/mobileqq/activity/FriendProfileCardActivity:getWindow	()Landroid/view/Window;
    //   21: new 4893	android/graphics/drawable/ColorDrawable
    //   24: dup
    //   25: iconst_m1
    //   26: invokespecial 4894	android/graphics/drawable/ColorDrawable:<init>	(I)V
    //   29: invokevirtual 4895	android/view/Window:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   32: getstatic 3044	aurh:b	Laurh;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnull +29 -> 68
    //   42: aload 4
    //   44: invokevirtual 3047	aurh:aJB	()Z
    //   47: ifeq +21 -> 68
    //   50: aload 4
    //   52: iconst_0
    //   53: invokevirtual 3168	aurh:aaZ	(I)V
    //   56: aload 4
    //   58: iconst_1
    //   59: invokevirtual 3050	aurh:aaY	(I)V
    //   62: aload 4
    //   64: iconst_2
    //   65: invokevirtual 3050	aurh:aaY	(I)V
    //   68: aload_0
    //   69: new 2587	aqmv
    //   72: dup
    //   73: ldc_w 659
    //   76: invokespecial 4896	aqmv:<init>	(Ljava/lang/String;)V
    //   79: putfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   82: aload_0
    //   83: invokevirtual 2694	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   86: astore 4
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 4899	com/tencent/mobileqq/activity/FriendProfileCardActivity:mActNeedImmersive	Z
    //   93: aload_0
    //   94: aload_1
    //   95: invokespecial 4901	com/tencent/mobileqq/activity/ProfileActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   98: pop
    //   99: aload_0
    //   100: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   103: ldc_w 4903
    //   106: iconst_0
    //   107: invokevirtual 2590	aqmv:dn	(Ljava/lang/String;Z)V
    //   110: aload_0
    //   111: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   114: ifnull +21 -> 135
    //   117: aload_0
    //   118: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   121: invokevirtual 2177	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   124: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   127: ifne +8 -> 135
    //   130: aload 4
    //   132: ifnonnull +9 -> 141
    //   135: aload_0
    //   136: invokevirtual 4740	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: aload_0
    //   142: aload 4
    //   144: ldc_w 4905
    //   147: iconst_0
    //   148: invokevirtual 1247	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   151: putfield 1356	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWq	Z
    //   154: aload 4
    //   156: ldc_w 4907
    //   159: invokevirtual 3699	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   162: ifeq +44 -> 206
    //   165: aload 4
    //   167: ldc_w 4907
    //   170: invokevirtual 4911	android/content/Intent:getSerializableExtra	(Ljava/lang/String;)Ljava/io/Serializable;
    //   173: astore_1
    //   174: aload_1
    //   175: ifnull +31 -> 206
    //   178: aload_0
    //   179: invokestatic 4916	com/tencent/mobileqq/activity/KPLProfileCardActivity:c	(Landroid/content/Context;)Landroid/content/Intent;
    //   182: astore 4
    //   184: aload 4
    //   186: ldc_w 4907
    //   189: aload_1
    //   190: invokevirtual 4919	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
    //   193: pop
    //   194: aload_0
    //   195: aload 4
    //   197: invokevirtual 2091	com/tencent/mobileqq/activity/FriendProfileCardActivity:startActivity	(Landroid/content/Intent;)V
    //   200: aload_0
    //   201: invokevirtual 4740	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   204: iconst_0
    //   205: ireturn
    //   206: aload_0
    //   207: aload 4
    //   209: ldc_w 4921
    //   212: iconst_0
    //   213: invokevirtual 1247	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   216: putfield 1997	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWx	Z
    //   219: aload_0
    //   220: aload 4
    //   222: ldc_w 4923
    //   225: iconst_0
    //   226: invokevirtual 1247	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   229: putfield 738	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWy	Z
    //   232: aload_0
    //   233: aload 4
    //   235: ldc_w 4925
    //   238: iconst_0
    //   239: invokevirtual 1247	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   242: putfield 2003	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWz	Z
    //   245: aload_0
    //   246: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   249: aload_0
    //   250: getfield 431	com/tencent/mobileqq/activity/FriendProfileCardActivity:mOnClickListener	Landroid/view/View$OnClickListener;
    //   253: putfield 2401	alcn:mOnClickListener	Landroid/view/View$OnClickListener;
    //   256: aload_0
    //   257: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   260: aload_0
    //   261: getfield 426	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   264: putfield 4926	alcn:jdField_b_of_type_AndroidViewView$OnLongClickListener	Landroid/view/View$OnLongClickListener;
    //   267: aload 4
    //   269: ldc_w 4858
    //   272: invokevirtual 4929	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   275: checkcast 509	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   278: astore_1
    //   279: aload 4
    //   281: ldc_w 3696
    //   284: invokevirtual 3699	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   287: istore_3
    //   288: iload_3
    //   289: ifeq +1776 -> 2065
    //   292: aload_0
    //   293: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   296: aload 4
    //   298: ldc_w 3696
    //   301: invokevirtual 1277	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   304: putfield 1022	alcn:troopUin	Ljava/lang/String;
    //   307: aload_1
    //   308: ifnonnull +1754 -> 2062
    //   311: aload 4
    //   313: ldc_w 4931
    //   316: invokevirtual 1277	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   319: astore_1
    //   320: aload_1
    //   321: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   324: ifeq +1735 -> 2059
    //   327: aload_0
    //   328: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   331: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   334: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   337: astore_1
    //   338: aload_0
    //   339: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   342: bipush 51
    //   344: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   347: checkcast 640	acff
    //   350: aload_1
    //   351: invokevirtual 4933	acff:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   354: astore 5
    //   356: aload 5
    //   358: ifnull +317 -> 675
    //   361: aload 5
    //   363: invokevirtual 4935	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   366: ifeq +309 -> 675
    //   369: new 509	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   372: dup
    //   373: aload_1
    //   374: iconst_1
    //   375: invokespecial 4860	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   378: astore_1
    //   379: aload_1
    //   380: aload 5
    //   382: getfield 1018	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   385: putfield 899	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:nickname	Ljava/lang/String;
    //   388: aload_1
    //   389: aload 5
    //   391: getfield 1019	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   394: putfield 896	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:remark	Ljava/lang/String;
    //   397: aload_0
    //   398: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   401: new 1700	com/tencent/mobileqq/data/TroopMemberCard
    //   404: dup
    //   405: invokespecial 4936	com/tencent/mobileqq/data/TroopMemberCard:<init>	()V
    //   408: putfield 1698	alcn:jdField_c_of_type_ComTencentMobileqqDataTroopMemberCard	Lcom/tencent/mobileqq/data/TroopMemberCard;
    //   411: aload_0
    //   412: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   415: aload 4
    //   417: ldc_w 4938
    //   420: iconst_m1
    //   421: invokevirtual 1288	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   424: putfield 1930	alcn:drN	I
    //   427: aload_0
    //   428: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   431: getfield 1930	alcn:drN	I
    //   434: bipush 8
    //   436: if_icmpne +15 -> 451
    //   439: aload_0
    //   440: aload 4
    //   442: ldc_w 4879
    //   445: invokevirtual 1277	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   448: putfield 315	com/tencent/mobileqq/activity/FriendProfileCardActivity:aNk	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   455: getfield 1930	alcn:drN	I
    //   458: iconst_4
    //   459: if_icmpne +43 -> 502
    //   462: aload_0
    //   463: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   466: ldc_w 1518
    //   469: ldc_w 4940
    //   472: ldc_w 287
    //   475: ldc_w 4942
    //   478: ldc_w 4944
    //   481: iconst_0
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   487: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   490: ldc_w 287
    //   493: ldc_w 287
    //   496: ldc_w 287
    //   499: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   502: aload_1
    //   503: ifnull +37 -> 540
    //   506: aload_0
    //   507: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   510: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   513: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   516: ifne +24 -> 540
    //   519: aload_1
    //   520: getfield 1298	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopcode	Ljava/lang/String;
    //   523: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   526: ifeq +14 -> 540
    //   529: aload_1
    //   530: aload_0
    //   531: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   534: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   537: putfield 1298	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopcode	Ljava/lang/String;
    //   540: aload_1
    //   541: ifnull +46 -> 587
    //   544: aload_1
    //   545: getfield 1298	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopcode	Ljava/lang/String;
    //   548: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   551: ifne +36 -> 587
    //   554: aload_1
    //   555: getfield 908	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopUin	Ljava/lang/String;
    //   558: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   561: ifeq +26 -> 587
    //   564: aload_1
    //   565: aload_0
    //   566: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   569: bipush 52
    //   571: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   574: checkcast 1021	com/tencent/mobileqq/app/TroopManager
    //   577: aload_1
    //   578: getfield 1298	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopcode	Ljava/lang/String;
    //   581: invokevirtual 4947	com/tencent/mobileqq/app/TroopManager:jr	(Ljava/lang/String;)Ljava/lang/String;
    //   584: putfield 908	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:troopUin	Ljava/lang/String;
    //   587: new 4949	anov
    //   590: dup
    //   591: aload_0
    //   592: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   595: invokespecial 4951	anov:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   598: ldc_w 4953
    //   601: invokevirtual 4956	anov:a	(Ljava/lang/String;)Lanov;
    //   604: ldc_w 4958
    //   607: invokevirtual 4960	anov:b	(Ljava/lang/String;)Lanov;
    //   610: ldc_w 4962
    //   613: invokevirtual 4964	anov:c	(Ljava/lang/String;)Lanov;
    //   616: ldc_w 4966
    //   619: invokevirtual 4968	anov:d	(Ljava/lang/String;)Lanov;
    //   622: iconst_1
    //   623: anewarray 1142	java/lang/String
    //   626: dup
    //   627: iconst_0
    //   628: aload_0
    //   629: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   632: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   635: aastore
    //   636: invokevirtual 4971	anov:a	([Ljava/lang/String;)Lanov;
    //   639: invokevirtual 4974	anov:report	()V
    //   642: aload_0
    //   643: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   646: iload_3
    //   647: putfield 1487	alcn:cwc	Z
    //   650: aload_0
    //   651: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   654: aload_1
    //   655: putfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   658: aload_0
    //   659: aload_0
    //   660: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   663: invokevirtual 4976	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lalcn;)Z
    //   666: ifne +29 -> 695
    //   669: aload_0
    //   670: invokevirtual 4740	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   673: iconst_0
    //   674: ireturn
    //   675: new 509	com/tencent/mobileqq/activity/ProfileActivity$AllInOne
    //   678: dup
    //   679: aload_1
    //   680: bipush 21
    //   682: invokespecial 4860	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:<init>	(Ljava/lang/String;I)V
    //   685: astore_1
    //   686: aload_1
    //   687: bipush 11
    //   689: putfield 1190	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:subSourceId	I
    //   692: goto -295 -> 397
    //   695: aload_1
    //   696: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   699: invokestatic 4979	aqft:rj	(Ljava/lang/String;)Z
    //   702: ifeq +25 -> 727
    //   705: aload_0
    //   706: invokevirtual 2551	com/tencent/mobileqq/activity/FriendProfileCardActivity:getApplicationContext	()Landroid/content/Context;
    //   709: invokestatic 4982	aqft:bK	(Landroid/content/Context;)Z
    //   712: ifeq +15 -> 727
    //   715: aload_0
    //   716: iconst_0
    //   717: iconst_0
    //   718: invokevirtual 4985	com/tencent/mobileqq/activity/FriendProfileCardActivity:overridePendingTransition	(II)V
    //   721: aload_0
    //   722: invokevirtual 4740	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   725: iconst_0
    //   726: ireturn
    //   727: aload_0
    //   728: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   731: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   734: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   737: bipush 90
    //   739: if_icmpne +48 -> 787
    //   742: aload_0
    //   743: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   746: bipush 51
    //   748: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   751: checkcast 640	acff
    //   754: astore_1
    //   755: aload_1
    //   756: ifnull +151 -> 907
    //   759: aload_1
    //   760: aload_0
    //   761: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   764: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   767: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   770: invokevirtual 1706	acff:isFriend	(Ljava/lang/String;)Z
    //   773: ifeq +134 -> 907
    //   776: aload_0
    //   777: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   780: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   783: iconst_1
    //   784: putfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   787: aload_0
    //   788: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   791: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   794: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   797: bipush 100
    //   799: if_icmpne +50 -> 849
    //   802: aload_0
    //   803: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   806: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   809: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   812: bipush 34
    //   814: if_icmpne +35 -> 849
    //   817: aload_0
    //   818: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   821: bipush 11
    //   823: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   826: checkcast 4148	ajdo
    //   829: invokeinterface 4151 1 0
    //   834: ifne +15 -> 849
    //   837: aload_0
    //   838: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   841: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   844: bipush 29
    //   846: putfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   849: aload_0
    //   850: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   853: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   856: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   859: invokestatic 4990	jou:df	(Ljava/lang/String;)Z
    //   862: ifeq +60 -> 922
    //   865: iload_3
    //   866: ifne +56 -> 922
    //   869: new 310	android/content/Intent
    //   872: dup
    //   873: aload_0
    //   874: ldc_w 1281
    //   877: invokespecial 933	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   880: astore_1
    //   881: aload_1
    //   882: ldc_w 4858
    //   885: aload_0
    //   886: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   889: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   892: invokevirtual 4863	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   895: pop
    //   896: aload_0
    //   897: aload_1
    //   898: invokespecial 4991	com/tencent/mobileqq/activity/ProfileActivity:startActivity	(Landroid/content/Intent;)V
    //   901: aload_0
    //   902: invokespecial 4992	com/tencent/mobileqq/activity/ProfileActivity:finish	()V
    //   905: iconst_0
    //   906: ireturn
    //   907: aload_0
    //   908: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   911: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   914: bipush 19
    //   916: putfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   919: goto -132 -> 787
    //   922: aload_0
    //   923: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   926: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   929: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   932: bipush 41
    //   934: if_icmpne +43 -> 977
    //   937: aload_0
    //   938: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   941: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   944: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   947: invokestatic 759	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   950: ifne +27 -> 977
    //   953: aload_0
    //   954: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   957: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   960: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   963: ldc_w 2048
    //   966: invokevirtual 1285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   969: ifeq +8 -> 977
    //   972: aload_0
    //   973: iconst_0
    //   974: putfield 298	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWo	Z
    //   977: aload_0
    //   978: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   981: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   984: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   987: bipush 53
    //   989: if_icmpeq +37 -> 1026
    //   992: aload_0
    //   993: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   996: invokevirtual 705	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   999: aload_0
    //   1000: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1003: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1006: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   1009: invokevirtual 1285	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1012: ifeq +14 -> 1026
    //   1015: aload_0
    //   1016: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1019: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1022: iconst_0
    //   1023: putfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1026: aload_0
    //   1027: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1030: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1033: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1036: ifne +8 -> 1044
    //   1039: aload_0
    //   1040: iconst_1
    //   1041: putfield 4994	com/tencent/mobileqq/activity/FriendProfileCardActivity:aWr	Z
    //   1044: aload_0
    //   1045: invokevirtual 4996	com/tencent/mobileqq/activity/FriendProfileCardActivity:baG	()V
    //   1048: aload_0
    //   1049: new 1361	auru
    //   1052: dup
    //   1053: invokestatic 4999	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   1056: aload_0
    //   1057: getfield 457	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_d_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   1060: invokespecial 5002	auru:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   1063: putfield 3679	com/tencent/mobileqq/activity/FriendProfileCardActivity:f	Lauru;
    //   1066: aload_0
    //   1067: new 1361	auru
    //   1070: dup
    //   1071: invokestatic 5005	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   1074: aload_0
    //   1075: getfield 450	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_AndroidOsHandler$Callback	Landroid/os/Handler$Callback;
    //   1078: invokespecial 5002	auru:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   1081: putfield 1359	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Auru	Lauru;
    //   1084: aload_0
    //   1085: aload_0
    //   1086: invokevirtual 610	com/tencent/mobileqq/activity/FriendProfileCardActivity:getApplication	()Landroid/app/Application;
    //   1089: aload_0
    //   1090: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1093: invokevirtual 705	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1096: invokestatic 5011	aqmj:aG	(Landroid/content/Context;Ljava/lang/String;)I
    //   1099: i2b
    //   1100: putfield 2461	com/tencent/mobileqq/activity/FriendProfileCardActivity:bReqMedalWallInfo	B
    //   1103: aload_0
    //   1104: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1107: getfield 1487	alcn:cwc	Z
    //   1110: ifeq +25 -> 1135
    //   1113: aload_0
    //   1114: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: aload_0
    //   1118: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1121: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   1124: invokestatic 1651	com/tencent/mobileqq/data/TroopInfo:isQidianPrivateTroop	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   1127: ifeq +8 -> 1135
    //   1130: aload_0
    //   1131: iconst_0
    //   1132: putfield 2461	com/tencent/mobileqq/activity/FriendProfileCardActivity:bReqMedalWallInfo	B
    //   1135: aload_0
    //   1136: invokevirtual 5013	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOp	()V
    //   1139: aload_0
    //   1140: aload_0
    //   1141: getfield 380	com/tencent/mobileqq/activity/FriendProfileCardActivity:cardObserver	Laccn;
    //   1144: invokevirtual 5014	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lacci;)V
    //   1147: aload_0
    //   1148: aload_0
    //   1149: getfield 397	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Acfd	Lacfd;
    //   1152: invokevirtual 5014	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lacci;)V
    //   1155: aload_0
    //   1156: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1159: aload_0
    //   1160: getfield 390	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Akwl	Lakwl;
    //   1163: invokevirtual 5018	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   1166: aload_0
    //   1167: aload_0
    //   1168: getfield 338	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Acnd	Lacnd;
    //   1171: invokevirtual 5014	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lacci;)V
    //   1174: aload_0
    //   1175: aload_0
    //   1176: getfield 328	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcb	Lalcb;
    //   1179: invokevirtual 5014	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lacci;)V
    //   1182: aload_0
    //   1183: aload_0
    //   1184: getfield 333	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Afsr	Lafsr;
    //   1187: invokevirtual 5014	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lacci;)V
    //   1190: aload_0
    //   1191: aload_0
    //   1192: getfield 445	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Aclh	Laclh;
    //   1195: invokevirtual 5014	com/tencent/mobileqq/activity/FriendProfileCardActivity:addObserver	(Lacci;)V
    //   1198: aload_0
    //   1199: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1202: sipush 184
    //   1205: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1208: checkcast 3117	com/tencent/mobileqq/vas/VasQuickUpdateManager
    //   1211: aload_0
    //   1212: getfield 343	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker	Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;
    //   1215: invokevirtual 3124	com/tencent/mobileqq/vas/VasQuickUpdateManager:addCallBacker	(Lcom/tencent/mobileqq/vas/VasQuickUpdateManager$CallBacker;)V
    //   1218: aload_0
    //   1219: new 1975	arho
    //   1222: dup
    //   1223: aload_0
    //   1224: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1227: aload_0
    //   1228: getfield 503	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Arho$a	Larho$a;
    //   1231: invokespecial 5021	arho:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Larho$a;)V
    //   1234: putfield 1973	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Arho	Larho;
    //   1237: aload_0
    //   1238: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1241: aload_0
    //   1242: getfield 1973	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Arho	Larho;
    //   1245: putfield 5023	alcn:jdField_c_of_type_Arho	Larho;
    //   1248: aload_0
    //   1249: new 4704	vbv
    //   1252: dup
    //   1253: aload_0
    //   1254: aload_0
    //   1255: invokespecial 5026	vbv:<init>	(Lcom/tencent/mobileqq/app/BaseActivity;Lvbv$a;)V
    //   1258: putfield 4702	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Vbv	Lvbv;
    //   1261: aload_0
    //   1262: new 587	java/lang/StringBuilder
    //   1265: dup
    //   1266: invokespecial 588	java/lang/StringBuilder:<init>	()V
    //   1269: aload_0
    //   1270: getfield 304	com/tencent/mobileqq/activity/FriendProfileCardActivity:aNh	Ljava/lang/String;
    //   1273: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: aload_0
    //   1277: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1280: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1283: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   1286: invokevirtual 594	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: invokevirtual 606	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1292: putfield 304	com/tencent/mobileqq/activity/FriendProfileCardActivity:aNh	Ljava/lang/String;
    //   1295: aload_0
    //   1296: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1299: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1302: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   1305: bipush 6
    //   1307: if_icmpne +24 -> 1331
    //   1310: aload_0
    //   1311: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1314: invokevirtual 3518	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1317: ifnull +14 -> 1331
    //   1320: aload_0
    //   1321: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1324: invokevirtual 3518	com/tencent/mobileqq/app/QQAppInterface:b	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   1327: aload_0
    //   1328: invokevirtual 5029	com/tencent/imcore/message/QQMessageFacade:addObserver	(Ljava/util/Observer;)V
    //   1331: aload_0
    //   1332: iconst_0
    //   1333: invokevirtual 2922	com/tencent/mobileqq/activity/FriendProfileCardActivity:xm	(Z)V
    //   1336: getstatic 5034	aqpi:a	Laqpi$a;
    //   1339: ifnonnull +18 -> 1357
    //   1342: new 5036	com/tencent/mobileqq/activity/FriendProfileCardActivity$5
    //   1345: dup
    //   1346: aload_0
    //   1347: invokespecial 5037	com/tencent/mobileqq/activity/FriendProfileCardActivity$5:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1350: bipush 16
    //   1352: aconst_null
    //   1353: iconst_1
    //   1354: invokestatic 3546	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1357: aload_0
    //   1358: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1361: bipush 7
    //   1363: anewarray 1142	java/lang/String
    //   1366: putfield 893	alcn:gh	[Ljava/lang/String;
    //   1369: new 5039	com/tencent/mobileqq/activity/FriendProfileCardActivity$6
    //   1372: dup
    //   1373: aload_0
    //   1374: invokespecial 5040	com/tencent/mobileqq/activity/FriendProfileCardActivity$6:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1377: bipush 16
    //   1379: aconst_null
    //   1380: iconst_1
    //   1381: invokestatic 3546	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1384: aload_0
    //   1385: invokevirtual 2928	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOx	()V
    //   1388: aload_0
    //   1389: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1392: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1395: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1398: bipush 33
    //   1400: if_icmpeq +494 -> 1894
    //   1403: aload_0
    //   1404: invokevirtual 5042	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOo	()V
    //   1407: aload_0
    //   1408: invokevirtual 5044	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOJ	()V
    //   1411: aload_0
    //   1412: new 5046	com/tencent/mobileqq/apollo/FriendCardApolloViewController
    //   1415: dup
    //   1416: aload_0
    //   1417: aload_0
    //   1418: getfield 575	com/tencent/mobileqq/activity/FriendProfileCardActivity:root	Landroid/view/View;
    //   1421: invokespecial 5049	com/tencent/mobileqq/apollo/FriendCardApolloViewController:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;Landroid/view/View;)V
    //   1424: putfield 884	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController	Lcom/tencent/mobileqq/apollo/FriendCardApolloViewController;
    //   1427: aload_0
    //   1428: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1431: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1434: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1437: ifne +30 -> 1467
    //   1440: aload_0
    //   1441: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1444: aload_0
    //   1445: getfield 402	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_c_of_type_Aklk	Laklk;
    //   1448: invokevirtual 5018	com/tencent/mobileqq/app/QQAppInterface:registObserver	(Lmqq/observer/BusinessObserver;)V
    //   1451: aload_0
    //   1452: getfield 1359	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_b_of_type_Auru	Lauru;
    //   1455: new 5051	com/tencent/mobileqq/activity/FriendProfileCardActivity$7
    //   1458: dup
    //   1459: aload_0
    //   1460: invokespecial 5052	com/tencent/mobileqq/activity/FriendProfileCardActivity$7:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1463: invokevirtual 2123	auru:post	(Ljava/lang/Runnable;)Z
    //   1466: pop
    //   1467: new 5054	com/tencent/mobileqq/activity/FriendProfileCardActivity$8
    //   1470: dup
    //   1471: aload_0
    //   1472: invokespecial 5055	com/tencent/mobileqq/activity/FriendProfileCardActivity$8:<init>	(Lcom/tencent/mobileqq/activity/FriendProfileCardActivity;)V
    //   1475: bipush 8
    //   1477: aconst_null
    //   1478: iconst_1
    //   1479: invokestatic 3873	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1482: aload_0
    //   1483: getfield 2232	com/tencent/mobileqq/activity/FriendProfileCardActivity:leftView	Landroid/widget/TextView;
    //   1486: ldc_w 5056
    //   1489: invokestatic 1756	acfp:m	(I)Ljava/lang/String;
    //   1492: invokestatic 5061	aqcl:s	(Landroid/view/View;Ljava/lang/String;)V
    //   1495: aload_0
    //   1496: getfield 2232	com/tencent/mobileqq/activity/FriendProfileCardActivity:leftView	Landroid/widget/TextView;
    //   1499: invokestatic 5064	aqcl:ip	(Landroid/view/View;)V
    //   1502: aload_0
    //   1503: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1506: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1509: getfield 512	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:pa	I
    //   1512: ifne +415 -> 1927
    //   1515: aload_0
    //   1516: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1519: ldc_w 1518
    //   1522: ldc_w 5066
    //   1525: ldc_w 287
    //   1528: ldc_w 5068
    //   1531: ldc_w 5068
    //   1534: iconst_0
    //   1535: iconst_0
    //   1536: ldc_w 287
    //   1539: ldc_w 287
    //   1542: ldc_w 287
    //   1545: ldc_w 287
    //   1548: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1551: aload_0
    //   1552: getfield 2583	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Aqmv	Laqmv;
    //   1555: ldc_w 5069
    //   1558: iconst_0
    //   1559: invokevirtual 2590	aqmv:dn	(Ljava/lang/String;Z)V
    //   1562: aload_0
    //   1563: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1566: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1569: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   1572: invokestatic 4979	aqft:rj	(Ljava/lang/String;)Z
    //   1575: ifeq +58 -> 1633
    //   1578: iconst_0
    //   1579: istore_2
    //   1580: aload_0
    //   1581: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1584: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1587: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   1590: bipush 59
    //   1592: if_icmpne +374 -> 1966
    //   1595: iconst_1
    //   1596: istore_2
    //   1597: aload_0
    //   1598: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1601: ldc_w 778
    //   1604: ldc_w 287
    //   1607: ldc_w 287
    //   1610: ldc_w 5071
    //   1613: ldc_w 5071
    //   1616: iload_2
    //   1617: iconst_0
    //   1618: ldc_w 287
    //   1621: ldc_w 287
    //   1624: ldc_w 287
    //   1627: ldc_w 287
    //   1630: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1633: aload_0
    //   1634: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1637: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1640: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   1643: bipush 118
    //   1645: if_icmpne +360 -> 2005
    //   1648: aconst_null
    //   1649: ldc_w 778
    //   1652: ldc_w 287
    //   1655: ldc_w 287
    //   1658: ldc_w 5073
    //   1661: ldc_w 5073
    //   1664: iconst_0
    //   1665: iconst_0
    //   1666: ldc_w 287
    //   1669: ldc_w 287
    //   1672: ldc_w 287
    //   1675: ldc_w 287
    //   1678: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1681: aload_0
    //   1682: invokevirtual 5075	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOX	()V
    //   1685: aload_0
    //   1686: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1689: bipush 52
    //   1691: invokevirtual 638	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1694: checkcast 1021	com/tencent/mobileqq/app/TroopManager
    //   1697: aload_0
    //   1698: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1701: getfield 1022	alcn:troopUin	Ljava/lang/String;
    //   1704: invokevirtual 1635	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1707: astore_1
    //   1708: aload_0
    //   1709: aload_1
    //   1710: invokevirtual 1638	com/tencent/mobileqq/activity/FriendProfileCardActivity:c	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1713: aload_1
    //   1714: ifnull +35 -> 1749
    //   1717: aload_1
    //   1718: invokevirtual 5078	com/tencent/mobileqq/data/TroopInfo:isGameBind	()Z
    //   1721: ifeq +28 -> 1749
    //   1724: ldc_w 5080
    //   1727: ldc_w 5082
    //   1730: ldc_w 5084
    //   1733: iconst_0
    //   1734: iconst_0
    //   1735: iconst_1
    //   1736: anewarray 1142	java/lang/String
    //   1739: dup
    //   1740: iconst_0
    //   1741: aload_1
    //   1742: getfield 2504	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1745: aastore
    //   1746: invokestatic 5089	aqfr:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   1749: aload_0
    //   1750: iconst_1
    //   1751: putfield 5091	com/tencent/mobileqq/activity/FriendProfileCardActivity:aEN	Z
    //   1754: ldc2_w 316
    //   1757: putstatic 5094	alhr:agz	J
    //   1760: aload_0
    //   1761: aload_0
    //   1762: invokevirtual 2694	com/tencent/mobileqq/activity/FriendProfileCardActivity:getIntent	()Landroid/content/Intent;
    //   1765: invokespecial 5096	com/tencent/mobileqq/activity/FriendProfileCardActivity:bQ	(Landroid/content/Intent;)V
    //   1768: aload_0
    //   1769: invokespecial 5098	com/tencent/mobileqq/activity/FriendProfileCardActivity:bOA	()V
    //   1772: aload_0
    //   1773: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1776: iconst_2
    //   1777: invokevirtual 700	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1780: checkcast 2447	com/tencent/mobileqq/app/CardHandler
    //   1783: astore_1
    //   1784: aload_1
    //   1785: ifnull +47 -> 1832
    //   1788: aload_0
    //   1789: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1792: ifnull +40 -> 1832
    //   1795: aload_0
    //   1796: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1799: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1802: ifnull +30 -> 1832
    //   1805: aload_0
    //   1806: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1809: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1812: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   1815: ifnull +17 -> 1832
    //   1818: aload_1
    //   1819: aload_0
    //   1820: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1823: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1826: getfield 648	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:uin	Ljava/lang/String;
    //   1829: invokevirtual 5101	com/tencent/mobileqq/app/CardHandler:Dw	(Ljava/lang/String;)V
    //   1832: aload_0
    //   1833: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1836: ldc_w 778
    //   1839: ldc_w 287
    //   1842: ldc_w 287
    //   1845: ldc_w 287
    //   1848: ldc_w 5103
    //   1851: iconst_0
    //   1852: iconst_0
    //   1853: ldc_w 287
    //   1856: ldc_w 287
    //   1859: ldc_w 287
    //   1862: ldc_w 287
    //   1865: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1868: iconst_1
    //   1869: ireturn
    //   1870: astore_1
    //   1871: invokestatic 657	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1874: ifeq +14 -> 1888
    //   1877: ldc_w 1002
    //   1880: iconst_2
    //   1881: ldc_w 287
    //   1884: aload_1
    //   1885: invokestatic 1474	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1888: aload_0
    //   1889: invokevirtual 4740	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   1892: iconst_0
    //   1893: ireturn
    //   1894: aload_0
    //   1895: aload_0
    //   1896: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1899: getfield 1198	alcn:d	Lcom/tencent/mobileqq/data/Card;
    //   1902: iconst_0
    //   1903: invokevirtual 2925	com/tencent/mobileqq/activity/FriendProfileCardActivity:a	(Lcom/tencent/mobileqq/data/Card;Z)V
    //   1906: goto -499 -> 1407
    //   1909: astore_1
    //   1910: ldc_w 659
    //   1913: iconst_1
    //   1914: ldc_w 5105
    //   1917: aload_1
    //   1918: invokestatic 1474	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1921: aload_0
    //   1922: invokevirtual 4740	com/tencent/mobileqq/activity/FriendProfileCardActivity:finish	()V
    //   1925: iconst_0
    //   1926: ireturn
    //   1927: aload_0
    //   1928: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1931: ldc_w 1518
    //   1934: ldc_w 5066
    //   1937: ldc_w 287
    //   1940: ldc_w 5107
    //   1943: ldc_w 5107
    //   1946: iconst_0
    //   1947: iconst_0
    //   1948: ldc_w 287
    //   1951: ldc_w 287
    //   1954: ldc_w 287
    //   1957: ldc_w 287
    //   1960: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1963: goto -412 -> 1551
    //   1966: aload_0
    //   1967: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1970: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1973: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   1976: iconst_1
    //   1977: if_icmpne +8 -> 1985
    //   1980: iconst_2
    //   1981: istore_2
    //   1982: goto -385 -> 1597
    //   1985: aload_0
    //   1986: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   1989: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   1992: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   1995: bipush 8
    //   1997: if_icmpne -400 -> 1597
    //   2000: iconst_3
    //   2001: istore_2
    //   2002: goto -405 -> 1597
    //   2005: aload_0
    //   2006: getfield 283	com/tencent/mobileqq/activity/FriendProfileCardActivity:jdField_a_of_type_Alcn	Lalcn;
    //   2009: getfield 507	alcn:e	Lcom/tencent/mobileqq/activity/ProfileActivity$AllInOne;
    //   2012: getfield 1083	com/tencent/mobileqq/activity/ProfileActivity$AllInOne:bJa	I
    //   2015: bipush 121
    //   2017: if_icmpne -336 -> 1681
    //   2020: aload_0
    //   2021: getfield 598	com/tencent/mobileqq/activity/FriendProfileCardActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2024: ldc_w 778
    //   2027: ldc_w 287
    //   2030: ldc_w 287
    //   2033: ldc_w 5109
    //   2036: ldc_w 5109
    //   2039: iconst_0
    //   2040: iconst_0
    //   2041: ldc_w 287
    //   2044: ldc_w 287
    //   2047: ldc_w 287
    //   2050: ldc_w 287
    //   2053: invokestatic 785	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2056: goto -375 -> 1681
    //   2059: goto -1721 -> 338
    //   2062: goto -1665 -> 397
    //   2065: goto -1423 -> 642
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2068	0	this	FriendProfileCardActivity
    //   0	2068	1	paramBundle	Bundle
    //   1579	423	2	i	int
    //   287	579	3	bool	boolean
    //   35	406	4	localObject	Object
    //   354	36	5	localFriends	Friends
    // Exception table:
    //   from	to	target	type
    //   977	1026	1870	java/lang/Exception
    //   1331	1357	1909	java/lang/Exception
    //   1357	1407	1909	java/lang/Exception
    //   1407	1427	1909	java/lang/Exception
    //   1894	1906	1909	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public void doOnDestroy()
  {
    int i = 0;
    this.aEN = false;
    if (this.jdField_a_of_type_Vbv != null)
    {
      this.jdField_a_of_type_Vbv.destroy();
      this.jdField_a_of_type_Vbv = null;
    }
    if (this.jdField_b_of_type_Auru != null)
    {
      this.jdField_b_of_type_Auru.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_Auru.removeMessages(0);
    }
    if (this.f != null)
    {
      this.f.removeCallbacksAndMessages(null);
      this.f.removeMessages(0);
      this.f = null;
    }
    if (this.jdField_c_of_type_Afsr != null)
    {
      this.app.removeObserver(this.jdField_c_of_type_Afsr);
      this.jdField_c_of_type_Afsr = null;
    }
    if (this.H != null)
    {
      this.H.dismiss();
      this.H = null;
    }
    if (this.bL != null)
    {
      this.bL.removeCallbacksAndMessages(null);
      this.bL = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.onDestroy();
    }
    super.doOnDestroy();
    if (this.app != null) {
      this.app.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_Arho != null) {
      this.jdField_a_of_type_Arho.destroy();
    }
    try
    {
      if (this.aWm)
      {
        unregisterReceiver(this.aB);
        this.aWm = false;
      }
      this.jdField_c_of_type_JavaUtilArrayDeque.clear();
      if (this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView != null) {
        this.jdField_d_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
      }
      removeObserver(this.jdField_c_of_type_Acfd);
      removeObserver(this.cardObserver);
      removeObserver(this.jdField_b_of_type_Acnd);
      if (this.app != null)
      {
        this.app.unRegistObserver(this.jdField_a_of_type_Akwl);
        this.app.unRegistObserver(this.jdField_c_of_type_Aklk);
      }
      removeObserver(this.jdField_a_of_type_Alcb);
      removeObserver(this.jdField_c_of_type_Aclh);
      removeObserver(this.jdField_b_of_type_Afsr);
      Object localObject;
      if (this.app != null)
      {
        localObject = (VasQuickUpdateManager)this.app.getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
        }
      }
      if ((this.app != null) && (this.app.b() != null)) {
        this.app.b().deleteObserver(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.onDestroy();
      }
      if (this.cT != null)
      {
        int j = this.cT.getChildCount();
        while (i < j)
        {
          localObject = this.cT.getChildAt(i);
          if ((localObject instanceof ProfileHeaderView)) {
            ((ProfileHeaderView)localObject).onDestroy();
          }
          i += 1;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          localException.printStackTrace();
        }
      }
      if ((this.jdField_C_of_type_AndroidAppDialog != null) && (this.jdField_C_of_type_AndroidAppDialog.isShowing()))
      {
        this.jdField_C_of_type_AndroidAppDialog.dismiss();
        this.jdField_C_of_type_AndroidAppDialog = null;
      }
      if (this.jdField_b_of_type_Swe != null)
      {
        this.jdField_b_of_type_Swe.dismiss();
        this.jdField_b_of_type_Swe = null;
      }
      bOR();
      if (this.jdField_a_of_type_Ahyh != null) {
        this.jdField_a_of_type_Ahyh.end();
      }
      if (this.dB != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "doOnDestroy recycle bg");
        }
        if ((this.dB instanceof FriendProfileCardBgDrawable)) {
          ((FriendProfileCardBgDrawable)this.dB).recycle();
        }
        if (aqsj.i(this.dB)) {
          aqsj.a().ab(this.dB);
        }
      }
      if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.d != null) && (alcs.b(this.jdField_a_of_type_Alcn.d))) {
        QLog.i("FriendProfileCardActivity", 1, "FriendProfileCardActivity.onDestroy()");
      }
      if (az.decrementAndGet() == 0) {
        aqep.edA();
      }
      MedalGuideView.dvL();
      if (this.mG != null)
      {
        Iterator localIterator = this.mG.iterator();
        while (localIterator.hasNext())
        {
          Subscriber localSubscriber = (Subscriber)localIterator.next();
          pmi.a().unRegisterSubscriber(localSubscriber);
        }
        this.mG.clear();
      }
      de(this);
      if (this.jdField_a_of_type_Zsi != null) {
        this.jdField_a_of_type_Zsi.onDestory();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.onDestory();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      if (this.jdField_a_of_type_Vbv != null) {
        this.jdField_a_of_type_Vbv.a(paramIntent, (ArrayList)localObject);
      }
      return;
    }
    if (paramIntent.getBooleanExtra("key_back_from_add_friend", false)) {
      doOnActivityResult(1000, -1, paramIntent);
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        localObject = (ProfileActivity.AllInOne)paramIntent.getParcelableExtra("AllInOne");
        if ((localObject != null) && (((ProfileActivity.AllInOne)localObject).bJa == 115))
        {
          this.jdField_a_of_type_Alcn.e = ((ProfileActivity.AllInOne)localObject);
          a(0L, null, null, false);
        }
      }
      if (this.jdField_a_of_type_Zsi != null) {
        break;
      }
      bQ(paramIntent);
      return;
      localObject = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      if (localObject != null) {
        if (aqep.a(this.app, (String)localObject, paramIntent))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
            this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.jdField_a_of_type_Alcn.e);
          }
        }
        else {
          cf(2131719573, 1);
        }
      }
    }
    this.jdField_a_of_type_Zsi.onNewIntent(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.onPause();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.onPause();
    }
    if (!this.aWp) {
      if (this.jdField_a_of_type_Aqmv != null) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "FriendProfileCardActivity time trace:" + this.jdField_a_of_type_Aqmv.toString());
        }
      }
    }
    try
    {
      anpc.a(this.app.getApp()).collectPerformance(this.app.getCurrentAccountUin(), "profileCardTimeStat", true, 0L, 0L, this.jdField_a_of_type_Aqmv.ab(), "", false);
      this.aWp = true;
      if (this.jdField_b_of_type_Auru != null)
      {
        this.jdField_b_of_type_Auru.removeMessages(102);
        this.jdField_b_of_type_Auru.removeCallbacks(this.dQ);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.onPause();
      }
      QQAppInterface localQQAppInterface = this.app;
      if (localQQAppInterface != null) {
        anpf.a().hB(localQQAppInterface.getCurrentAccountUin(), "actQZLoadHitRateProfile");
      }
      this.e.end();
      this.aWv = true;
      if ((this.aWw) && (this.Ga > 0L) && (this.app != null) && (this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.e != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.uin))) {
        afxv.g(this.app, this.jdField_a_of_type_Alcn.e.uin, this.Ga);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "doOnPause fail.", localException);
      }
    }
  }
  
  public void doOnPostResume()
  {
    super.doOnPostResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.onResume();
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity doOnResume");
    }
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    ApngImage.playByTag(9);
    if (this.aWn) {
      if ((!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileTagView)) || (!((ProfileTagView)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView).mIsFullScreen)) {
        break label311;
      }
    }
    label311:
    for (int i = 0;; i = 1)
    {
      this.bGX = 0;
      if (i != 0) {
        bOy();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.onResume();
      }
      bOv();
      if (this.FW > 0L)
      {
        long l1 = System.currentTimeMillis() - this.FW;
        if ((QLog.isColorLevel()) && (l1 > 500L)) {
          QLog.i("Q.PerfTrace", 2, "FriendProfileCardActivity Ui render used:" + l1);
        }
        this.FW = 0L;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.onResume();
      }
      if (this.jdField_a_of_type_Alcn.e.bJa == 6) {
        aQ();
      }
      addObserver(this.jdField_b_of_type_Accn);
      if (this.app != null)
      {
        WebProcessManager localWebProcessManager = (WebProcessManager)this.app.getManager(13);
        if (localWebProcessManager != null) {
          localWebProcessManager.a(-1, new a(this.jdField_a_of_type_Ahyh));
        }
        avpw.a(this.app, this.jdField_a_of_type_Ahyh);
      }
      bOU();
      if (this.jdField_a_of_type_Albg != null) {
        this.jdField_a_of_type_Albg.onResume();
      }
      if ((this.jdField_a_of_type_Alcn.e.bJa == 115) && (AddFriendLogicActivity.aRh)) {
        vy(getIntent().getStringExtra("src_name"));
      }
      this.aWv = false;
      return;
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    View localView;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_like");
      if (!(localView instanceof VoteView)) {
        break label77;
      }
      ((VoteView)localView).MH(true);
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Auru != null)
      {
        this.jdField_b_of_type_Auru.removeCallbacks(this.dQ);
        this.jdField_b_of_type_Auru.postDelayed(this.dQ, 2000L);
      }
      return;
      label77:
      if ((localView instanceof VoteViewV2)) {
        ((VoteViewV2)localView).MH(true);
      }
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    removeObserver(this.jdField_b_of_type_Accn);
    Object localObject = aurh.b;
    if ((localObject != null) && (((aurh)localObject).bJ(true))) {
      ((aurh)localObject).Zy(this.app.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c != null) {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.c.cYw();
      }
      localObject = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_like");
      if (!(localObject instanceof VoteView)) {
        break label171;
      }
      ((VoteView)localObject).MH(false);
    }
    for (;;)
    {
      bOV();
      if (this.f.hasMessages(10))
      {
        this.f.removeMessages(10);
        bOS();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloFriendCardApolloViewController.onStop();
      }
      if ((this.jdField_b_of_type_Swe != null) && (this.jdField_b_of_type_Swe.isShowing()))
      {
        this.jdField_b_of_type_Swe.dismiss();
        this.jdField_b_of_type_Swe = null;
      }
      return;
      label171:
      if ((localObject instanceof VoteViewV2)) {
        ((VoteViewV2)localObject).MH(false);
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aqmv.dn("doOnWindowFocusChanged", false);
      aurh localaurh = aurh.b;
      if ((localaurh != null) && (localaurh.aJB())) {
        localaurh.aaZ(2);
      }
      if ((!this.rF) || (this.aWC))
      {
        this.jdField_b_of_type_Auru.removeMessages(100);
        this.jdField_b_of_type_Auru.sendEmptyMessageDelayed(100, 100L);
        this.aWC = false;
        this.rF = true;
      }
      if (this.aWr)
      {
        this.jdField_b_of_type_Auru.removeMessages(102);
        this.jdField_b_of_type_Auru.sendEmptyMessageDelayed(102, 100L);
        this.aWr = false;
      }
    }
  }
  
  void e(LinearLayout paramLinearLayout)
  {
    paramLinearLayout.removeAllViews();
    this.sF = null;
    int i = getResources().getDimensionPixelSize(2131296891);
    int j = getResources().getDimensionPixelSize(2131296891);
    if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.e != null) && (this.jdField_a_of_type_Alcn.e.pa != 33))
    {
      LinearLayout.LayoutParams localLayoutParams;
      if ((this.jdField_a_of_type_Alcn.e.pa == 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.e.uin)))
      {
        this.sF = View.inflate(this, 2131562219, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.sF, localLayoutParams);
        this.jdField_m_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, this.sF).c(30).d(30).a();
        if (this.jdField_m_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
          bOv();
        }
        this.sF = View.inflate(this, 2131562219, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i;
        paramLinearLayout.addView(this.sF, localLayoutParams);
        this.sF = View.inflate(this, 2131561551, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = i;
        paramLinearLayout.addView(this.sF, localLayoutParams);
      }
      if (this.jdField_a_of_type_Alcn.e.pa != 0)
      {
        this.sF = View.inflate(this, 2131561562, null);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.sF, localLayoutParams);
        this.sF = View.inflate(this, 2131561626, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.sF, localLayoutParams);
        this.sF = View.inflate(this, 2131561626, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.sF, localLayoutParams);
        this.sF = View.inflate(this, 2131561626, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.sF, localLayoutParams);
        this.sF = View.inflate(this, 2131561551, null);
        localLayoutParams = new LinearLayout.LayoutParams(0, -2);
        localLayoutParams.weight = 1.0F;
        localLayoutParams.rightMargin = j;
        paramLinearLayout.addView(this.sF, localLayoutParams);
      }
    }
  }
  
  public void e(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int j = 1;
    if ((this.app == null) || (this.jdField_b_of_type_Auru == null) || (this.jdField_a_of_type_Alcn == null) || (this.jdField_a_of_type_Alcn.e == null)) {}
    label316:
    label335:
    label360:
    label361:
    for (;;)
    {
      return;
      if ((!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e)) && (this.jdField_a_of_type_Alcn.e.pa != 0) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin())) && (!TextUtils.equals(this.jdField_a_of_type_Alcn.e.uin, this.app.getCurrentAccountUin())))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, String.format("checkAndSwitch2Friend phone: %s, check:%s, uin: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), aqft.pl(paramString) }));
        }
        Message localMessage;
        if (paramBoolean1)
        {
          localObject = a(paramString, a(this.jdField_a_of_type_Alcn.e));
          localMessage = Message.obtain();
          localMessage.what = 3;
          if (localObject == null) {}
          for (;;)
          {
            localMessage.obj = paramString;
            this.jdField_b_of_type_Auru.sendMessage(localMessage);
            return;
            paramString = (String)localObject;
          }
        }
        Object localObject = (acff)this.app.getManager(51);
        int i;
        if (!paramBoolean2)
        {
          i = 1;
          if (i != 0) {
            break label360;
          }
          if (localObject != null) {
            break label316;
          }
          paramString = null;
          label235:
          if ((paramString == null) || (!paramString.isFriend())) {
            break label335;
          }
          i = j;
        }
        for (;;)
        {
          label250:
          if (i == 0) {
            break label361;
          }
          if (localObject == null) {}
          for (paramString = null;; paramString = ((acff)localObject).b(this.jdField_a_of_type_Alcn.e.uin))
          {
            localMessage = Message.obtain();
            localMessage.what = 3;
            localObject = paramString;
            if (paramString == null) {
              localObject = this.jdField_a_of_type_Alcn.e.uin;
            }
            localMessage.obj = localObject;
            this.jdField_b_of_type_Auru.sendMessage(localMessage);
            return;
            i = 0;
            break;
            paramString = ((acff)localObject).e(this.jdField_a_of_type_Alcn.e.uin);
            break label235;
            i = 0;
            break label250;
          }
        }
      }
    }
  }
  
  public void flingLToR()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfilePhotoView))
    {
      View localView = (View)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_qzonecover");
      if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).cwQ)) {
        return;
      }
    }
    onBackPressed();
  }
  
  public void flingRToL() {}
  
  public boolean gc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public int getTitleBarHeight()
  {
    int i = 0;
    if (this.mTitleBar != null) {
      i = this.mTitleBar.getHeight();
    }
    return i;
  }
  
  public String he(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.startsWith("+"))
      {
        localObject = paramString;
        if (paramString.length() == 11)
        {
          localObject = paramString;
          if (!paramString.startsWith("0"))
          {
            localObject = ((ajdo)this.app.getManager(11)).a();
            if ((localObject == null) || (TextUtils.isEmpty(((RespondQueryQQBindingStat)localObject).nationCode))) {
              break label100;
            }
            localObject = ((RespondQueryQQBindingStat)localObject).nationCode + paramString.trim();
          }
        }
      }
    }
    return localObject;
    label100:
    return "+86" + paramString.trim();
  }
  
  public boolean isValidate()
  {
    return (this.aEN) && (!isFinishing());
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, paramInt1, getString(paramInt2), paramInt3, getString(paramInt4), 0);
  }
  
  String oP()
  {
    try
    {
      String str = ((PhoneContactManagerImp)this.app.getManager(11)).c(a(this.jdField_a_of_type_Alcn.e)).uin;
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
      }
    }
    return null;
  }
  
  public String oQ()
  {
    if (!TextUtils.isEmpty(this.aNl)) {
      return this.aNl;
    }
    ThreadManager.post(new FriendProfileCardActivity.52(this), 8, null, true);
    return "-1";
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.aWx = true;
      a(0L, null, null, false);
      setResult(8193);
    }
    while (((paramInt1 != 20121207) && (paramInt1 != 20121208) && (paramInt1 != 201209)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    bOT();
    bOu();
    if (this.jdField_a_of_type_Zsi != null) {
      this.jdField_a_of_type_Zsi.crz();
    }
    return super.onBackEvent();
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.mask != null) {
        this.mask.setVisibility(0);
      }
    }
    while (this.mask == null) {
      return;
    }
    this.mask.setVisibility(8);
  }
  
  protected void onRestart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "friend profile card activity onRestart");
    }
    super.onRestart();
    if ((this.jdField_a_of_type_Alcn != null) && (this.jdField_a_of_type_Alcn.e != null) && (this.jdField_a_of_type_Alcn.e.pa != 33))
    {
      this.jdField_a_of_type_Aqmv = new aqmv();
      this.qC = false;
      this.aWp = false;
      this.bGZ = 0;
      if (this.f != null)
      {
        Message localMessage = this.f.obtainMessage();
        if (ProfileActivity.AllInOne.g(this.jdField_a_of_type_Alcn.e))
        {
          localMessage.what = 1;
          localMessage.obj = this.jdField_a_of_type_Alcn.e.uin;
          this.f.sendMessage(localMessage);
        }
      }
    }
  }
  
  public void showProgressDialog()
  {
    try
    {
      if (!isFinishing())
      {
        this.G = new arhz(this, getTitleBarHeight());
        this.G.setCancelable(false);
        this.G.setMessage(2131697313);
        this.G.show();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    bP(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord)) {
      runOnUiThread(new FriendProfileCardActivity.43(this));
    }
  }
  
  public void vx(String paramString)
  {
    this.jdField_a_of_type_Alcn.e.remark = paramString;
    a(this.jdField_a_of_type_Alcn, 4, paramString);
    if (this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf == null) {
      this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf = new aqaf();
    }
    paramString = (aqaf)this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf.clone();
    b(this.jdField_a_of_type_Alcn);
    switch (paramString.a(this.jdField_a_of_type_Alcn.jdField_a_of_type_Aqaf))
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, true, new String[] { "map_key_qzone", "map_key_account_base_info" });
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.j(this.jdField_a_of_type_Alcn);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
          this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.j(this.jdField_a_of_type_Alcn);
        }
      }
    }
  }
  
  void vy(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    if ((this.jdField_b_of_type_Swe != null) && (!this.jdField_b_of_type_Swe.isShowing()))
    {
      this.jdField_b_of_type_Swe.show();
      return;
    }
    this.jdField_b_of_type_Swe = new swe(this);
    this.jdField_b_of_type_Swe.tV(getResources().getString(2131700726));
    String str2 = getString(2131720024);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramString = new vao(this, this);
    this.jdField_b_of_type_Swe.c(str1, paramString);
    this.jdField_b_of_type_Swe.a(paramString);
    this.jdField_b_of_type_Swe.show();
  }
  
  public void xk(boolean paramBoolean)
  {
    QLog.i("FriendProfileCardActivity", 2, "initOrRefreshWeiShiPanel");
    if (this.jdField_a_of_type_Srn == null) {
      this.jdField_a_of_type_Srn = new srn(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.setMineWeiShiPanelInfo(this.jdField_a_of_type_Srn, paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.jdField_a_of_type_Alcn, true, new String[] { "map_key_mine_weishi" });
    }
  }
  
  public void xl(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update buttons");
    }
    if (this.jdField_a_of_type_Alcn.e.pa == 0) {
      AL(1);
    }
    label288:
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Alcn.e.pa == 80)
      {
        AL(9);
        return;
      }
      if (this.jdField_a_of_type_Alcn.e.pa != 53) {
        break;
      }
      if (this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin)) {
          if (TextUtils.equals(this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.uin, this.app.getCurrentAccountUin()))
          {
            AL(0);
            this.bHa = 0;
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (this.jdField_a_of_type_Alcn.e.bJa != 105)) {
          break label288;
        }
        anot.a(this.app, "CliOper", "", "", "0X800716B", "0X800716B", this.bHa, 0, "", "", "", "");
        return;
        AL(4);
        break;
        if (((ajdo)this.app.getManager(11)).c(this.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo) != null)
        {
          this.bHa = 1;
          if (this.jdField_a_of_type_Alcn.cwc) {}
          for (int i = 12;; i = 2)
          {
            AL(i);
            break;
          }
        }
        this.bHa = 2;
        AL(11);
        continue;
        this.bHa = 3;
        AL(10);
      }
    }
    boolean bool4 = ProfileActivity.AllInOne.d(this.jdField_a_of_type_Alcn.e);
    boolean bool1 = ProfileActivity.AllInOne.e(this.jdField_a_of_type_Alcn.e);
    paramBoolean = ProfileActivity.AllInOne.c(this.jdField_a_of_type_Alcn.e);
    if (this.jdField_a_of_type_Alcn.e.bJa == 113)
    {
      paramBoolean = false;
      bool1 = false;
    }
    boolean bool2 = bool1;
    boolean bool3 = bool4;
    if (aqft.rj(this.jdField_a_of_type_Alcn.e.uin))
    {
      if (!this.aWq) {
        break label570;
      }
      paramBoolean = false;
      bool2 = false;
    }
    for (bool3 = false;; bool3 = bool4)
    {
      bool1 = bool2;
      if (ProfileActivity.AllInOne.k(this.jdField_a_of_type_Alcn.e))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Alcn.e.ch != null)
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Alcn.e.ch.length > 0) {
            bool1 = true;
          }
        }
      }
      if (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e)) {
        paramBoolean = false;
      }
      if ((bool1) && (this.jdField_a_of_type_Alcn.cwc))
      {
        AL(12);
        return;
      }
      if ((bool3) && (bool1) && (paramBoolean))
      {
        AL(2);
        return;
      }
      if ((bool3) && (bool1))
      {
        AL(3);
        return;
      }
      if ((bool1) && (paramBoolean))
      {
        AL(4);
        return;
      }
      if ((bool3) && (paramBoolean))
      {
        AL(5);
        return;
      }
      if (bool3)
      {
        AL(6);
        return;
      }
      if (bool1)
      {
        AL(7);
        return;
      }
      if (paramBoolean)
      {
        AL(5);
        return;
      }
      AL(0);
      return;
      label570:
      paramBoolean = false;
      bool2 = bool1;
    }
  }
  
  void xm(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "initCardContactInfoList");
    }
    Object localObject3;
    if ((ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e)) || (this.jdField_a_of_type_Alcn.e.pa == 33) || (this.jdField_a_of_type_Alcn.e.pa == 32) || (this.jdField_a_of_type_Alcn.e.pa == 31) || (this.jdField_a_of_type_Alcn.e.pa == 34) || (this.jdField_a_of_type_Alcn.e.pa == 51) || (this.jdField_a_of_type_Alcn.e.pa == 50) || (this.jdField_a_of_type_Alcn.e.pa == 36) || (this.jdField_a_of_type_Alcn.e.pa == 29) || (this.jdField_a_of_type_Alcn.e.pa == 53))
    {
      if (this.jdField_a_of_type_Alcn.e.pr == null) {
        this.jdField_a_of_type_Alcn.e.pr = new ArrayList();
      }
      if (this.jdField_a_of_type_Alcn.e.pr.size() == 0)
      {
        localObject3 = (ajdo)this.app.getManager(11);
        if (localObject3 != null) {
          break label230;
        }
      }
    }
    label230:
    label491:
    do
    {
      return;
      Object localObject1;
      Object localObject2;
      if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_Alcn.e))
      {
        localObject1 = ((ajdo)localObject3).a(this.jdField_a_of_type_Alcn.e.uin);
        localObject2 = localObject1;
        if (paramBoolean) {
          break label491;
        }
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(1);
        if ((!((FriendListHandler)localObject2).ZY()) && (!((FriendListHandler)localObject2).ZZ())) {
          ((FriendListHandler)localObject2).bE(this.jdField_a_of_type_Alcn.e.uin, false);
        }
      }
      while (this.jdField_a_of_type_Alcn.e.pa == 53)
      {
        this.jdField_a_of_type_Alcn.e.pr.add(new ProfileActivity.CardContactInfo(this.jdField_a_of_type_Alcn.e.contactName, this.jdField_a_of_type_Alcn.e.uin, ""));
        return;
        localObject2 = ((ajdo)localObject3).c(this.jdField_a_of_type_Alcn.e.uin);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = ((ajdo)localObject3).b(this.jdField_a_of_type_Alcn.e.uin);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((PhoneContact)localObject2).mobileCode))
            {
              this.jdField_a_of_type_Alcn.e.uin = ((PhoneContact)localObject2).mobileCode;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject3 = (FriendListHandler)this.app.getBusinessHandler(1);
          localObject2 = localObject1;
          if (!((FriendListHandler)localObject3).ZZ())
          {
            ((FriendListHandler)localObject3).bE(this.jdField_a_of_type_Alcn.e.uin, true);
            localObject2 = localObject1;
          }
        }
        localObject1 = localObject2;
      }
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Alcn.e.pr.add(new ProfileActivity.CardContactInfo(((PhoneContact)localObject1).name, ((PhoneContact)localObject1).mobileCode, ((PhoneContact)localObject1).nationCode));
        return;
      }
    } while ((this.jdField_a_of_type_Alcn.e.pa != 33) && (this.jdField_a_of_type_Alcn.e.pa != 32) && (this.jdField_a_of_type_Alcn.e.pa != 31) && (this.jdField_a_of_type_Alcn.e.pa != 34) && (this.jdField_a_of_type_Alcn.e.pa != 51) && (this.jdField_a_of_type_Alcn.e.pa != 50) && (this.jdField_a_of_type_Alcn.e.pa != 36) && (this.jdField_a_of_type_Alcn.e.pa != 29));
    this.jdField_a_of_type_Alcn.e.pr.add(new ProfileActivity.CardContactInfo("", this.jdField_a_of_type_Alcn.e.uin, ""));
  }
  
  public void xn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.Gg = NetConnInfoCenter.getServerTime();
      return;
    }
    this.Gg = 0L;
  }
  
  public void xo(boolean paramBoolean)
  {
    try
    {
      Object localObject = adzx.a(this.app, this.jdField_a_of_type_Alcn);
      localObject = aqep.a(new Intent(this, FriendProfileMoreInfoActivity.class), this.jdField_a_of_type_Alcn.e.uin, this.app, this.jdField_a_of_type_Alcn.e, (BusinessCard)localObject);
      ((Intent)localObject).putExtra("profile_entry_type", this.jdField_a_of_type_Alcn.e.bJa);
      ((Intent)localObject).putExtra("troopUin", this.jdField_a_of_type_Alcn.troopUin);
      ((Intent)localObject).putExtra("memberUin", this.jdField_a_of_type_Alcn.e.uin);
      ((Intent)localObject).putExtra("isTroopMemberCard", this.jdField_a_of_type_Alcn.cwc);
      ((Intent)localObject).putExtra("extendFriendEntryAddFriend", this.jdField_a_of_type_Alcn.drP);
      if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        ((Intent)localObject).putExtra("coverUrl", this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mCoverUrl);
        ((Intent)localObject).putExtra("coverTimeStamp", this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.bHA);
      }
      startActivityForResult((Intent)localObject, 1022);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardActivity", 1, "forward2ProfileEdit fail.", localException);
      }
      anot.a(this.app, "CliOper", "", "", "0X8006A76", "0X8006A76", 0, 0, "", "", "", "");
      anot.a(this.app, "dc00898", "", "", "0X8007EB6", "0X8007EB6", 0, 0, "", "", "", "");
    }
    if (paramBoolean)
    {
      anot.a(this.app, "dc00898", "", "", "0X8007EB9", "0X8007EB9", 0, 0, "", "", "", "");
      return;
    }
  }
  
  static class BlurBackgroundJob
    implements Runnable
  {
    Drawable mBackgroundDrawable;
    Handler mUiHandler;
    
    BlurBackgroundJob(Handler paramHandler, Drawable paramDrawable)
    {
      this.mBackgroundDrawable = paramDrawable;
      this.mUiHandler = paramHandler;
    }
    
    public void run()
    {
      Bitmap localBitmap = ((FriendProfileCardBgDrawable)this.mBackgroundDrawable).ah();
      Object localObject = localBitmap;
      if (localBitmap == null) {
        localObject = ((FriendProfileCardBgDrawable)this.mBackgroundDrawable).ai();
      }
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        localObject = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(((Bitmap)localObject).getWidth() * 0.125F), (int)(((Bitmap)localObject).getHeight() * 0.125F), true);
        aqmp.fastblur((Bitmap)localObject, 2);
        localObject = this.mUiHandler.obtainMessage(12, localObject);
        this.mUiHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  public class ColorScreenLoader
    implements aqrg.a<aher>, Runnable
  {
    public aher a;
    public LottieComposition b;
    public int bHg;
    
    public ColorScreenLoader(int paramInt)
    {
      this.bHg = paramInt;
    }
    
    public void a(aher paramaher, Object paramObject)
    {
      if ((paramaher == null) || (!FriendProfileCardActivity.this.isValidate()))
      {
        QLog.e("ColorScreenManager", 1, "early return, config is " + paramaher);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorScreenManager", 2, "onComplete, anim file is " + paramaher.bKj);
      }
      this.a = paramaher;
      try
      {
        paramaher = new FileInputStream(paramaher.bKj);
        paramObject = new Bundle();
        paramObject.putString("key", "lottie_colorscreen_" + String.valueOf(this.bHg) + "unzip");
        paramObject.putString("path", FriendProfileCardActivity.this.getFilesDir().getAbsolutePath() + "/" + "color_screen" + "/" + this.bHg + "/" + "unzip" + "/images/");
        LottieComposition.Factory.fromInputStreamWithCacheBitmap(FriendProfileCardActivity.this, paramaher, FriendProfileCardActivity.this.d.getLottieDrawable(), new var(this), paramObject, BaseApplicationImpl.sImageCache);
        return;
      }
      catch (FileNotFoundException paramaher)
      {
        QLog.e("ColorScreenManager", 1, "colorScreen", paramaher);
      }
    }
    
    public void run()
    {
      if (!FriendProfileCardActivity.this.isValidate()) {
        QLog.e("ColorScreenManager", 1, "early return, invalid before setComposition");
      }
      do
      {
        return;
        if (FriendProfileCardActivity.this.bGX == this.bHg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ColorScreenManager", 2, "play : " + this.bHg);
          }
          FriendProfileCardActivity.this.d.cancelAnimation();
          FriendProfileCardActivity.this.d.setImageAssetDelegate(new vas(this));
          try
          {
            a locala = new a(this.b.getDuration());
            FriendProfileCardActivity.this.d.setComposition(this.b);
            FriendProfileCardActivity.this.d.setProgress(0.0F);
            FriendProfileCardActivity.this.d.setRepeatCount(this.a.repeatCount);
            FriendProfileCardActivity.this.d.addAnimatorListener(locala);
            FriendProfileCardActivity.this.d.addAnimatorUpdateListener(locala);
            FriendProfileCardActivity.this.d.setVisibility(0);
            FriendProfileCardActivity.this.d.playAnimation();
            return;
          }
          catch (Exception localException)
          {
            QLog.e("ColorScreenManager", 1, "", localException);
            return;
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("ColorScreenManager", 2, "won't play old anim: " + this.bHg + " because have new anim: " + FriendProfileCardActivity.this.bGX);
    }
    
    class a
      implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
    {
      private boolean aWF;
      public int bHh;
      public long fm;
      public long mDuration;
      
      public a(long paramLong)
      {
        this.mDuration = paramLong;
        this.fm = ((FriendProfileCardActivity.ColorScreenLoader.this.a.repeatCount + 1) * paramLong);
        if (Build.VERSION.SDK_INT == 15) {}
        for (boolean bool = true;; bool = false)
        {
          this.aWF = bool;
          return;
        }
      }
      
      public void onAnimationCancel(Animator paramAnimator) {}
      
      public void onAnimationEnd(Animator paramAnimator)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorScreenManager", 2, "onAnimationEnd: " + FriendProfileCardActivity.ColorScreenLoader.this.bHg);
        }
        FriendProfileCardActivity.this.d.setVisibility(8);
        FriendProfileCardActivity.this.b.post(new FriendProfileCardActivity.ColorScreenLoader.ColorScreenListener.1(this));
        while (!FriendProfileCardActivity.this.c.isEmpty()) {
          ((Message)FriendProfileCardActivity.this.c.removeFirst()).sendToTarget();
        }
      }
      
      public void onAnimationRepeat(Animator paramAnimator)
      {
        this.bHh += 1;
      }
      
      public void onAnimationStart(Animator paramAnimator)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "onAnimationStart: " + FriendProfileCardActivity.ColorScreenLoader.this.bHg);
        }
      }
      
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        if (!this.aWF) {
          try
          {
            float f = (paramValueAnimator.getAnimatedFraction() + this.bHh) * (float)this.mDuration;
            if (f <= (float)FriendProfileCardActivity.ColorScreenLoader.this.a.aas)
            {
              FriendProfileCardActivity.this.d.setAlpha(f / (float)FriendProfileCardActivity.ColorScreenLoader.this.a.aas);
              return;
            }
            if ((this.fm > 0L) && ((float)this.fm - f <= (float)FriendProfileCardActivity.ColorScreenLoader.this.a.aat))
            {
              FriendProfileCardActivity.this.d.setAlpha(((float)this.fm - f) / (float)FriendProfileCardActivity.ColorScreenLoader.this.a.aat);
              return;
            }
          }
          catch (Exception paramValueAnimator)
          {
            this.aWF = true;
            QLog.e("FriendProfileCardActivity", 1, "onAnimationUpdate: ", paramValueAnimator);
          }
        }
      }
    }
  }
  
  static class DownloadTemplateRunnable
    implements Runnable
  {
    long Gi;
    WeakReference<FriendProfileCardActivity> activityRef;
    String backgroundUrl;
    WeakReference<alcs> dI;
    AtomicBoolean isRunning;
    
    public DownloadTemplateRunnable(FriendProfileCardActivity paramFriendProfileCardActivity, alcs paramalcs, AtomicBoolean paramAtomicBoolean, String paramString, long paramLong)
    {
      this.activityRef = new WeakReference(paramFriendProfileCardActivity);
      this.dI = new WeakReference(paramalcs);
      this.isRunning = paramAtomicBoolean;
      this.backgroundUrl = paramString;
      this.Gi = paramLong;
    }
    
    public void run()
    {
      int j = 1;
      for (;;)
      {
        boolean bool2;
        try
        {
          FriendProfileCardActivity localFriendProfileCardActivity;
          Object localObject1;
          if ((this.activityRef != null) && (this.dI != null))
          {
            localFriendProfileCardActivity = (FriendProfileCardActivity)this.activityRef.get();
            localObject1 = (alcs)this.dI.get();
            if ((localFriendProfileCardActivity != null) && (localObject1 != null))
            {
              localFriendProfileCardActivity.a.dn("downloadTemplateStart", true);
              bool2 = aqep.bY(localFriendProfileCardActivity.app);
              if ((this.Gi != 160L) && (this.Gi != 1600L)) {
                break label819;
              }
              bool1 = aqep.aj(localFriendProfileCardActivity.app.getApplication(), this.backgroundUrl);
              if (bool1) {
                break label812;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.FrdProfileCard", 2, "start download background=" + this.backgroundUrl + ",isExistBgResource=" + bool1);
              }
              localObject1 = new File(aqep.I(localFriendProfileCardActivity.app.getApplication(), this.backgroundUrl));
              localObject1 = new aquz(this.backgroundUrl, (File)localObject1);
              ((aquz)localObject1).cxX = "profileCardDownload";
              ((aquz)localObject1).cxW = "VIP_profilecard";
              i = aqva.a((aquz)localObject1, localFriendProfileCardActivity.app);
              if (i != 0) {
                QLog.e("Q.profilecard.FrdProfileCard", 1, "download BG fail code = " + i + " url = " + this.backgroundUrl);
              }
              if ((i != 0) || (!aqep.aj(localFriendProfileCardActivity.app.getApplication(), this.backgroundUrl))) {
                break label832;
              }
              bool1 = true;
              break label825;
              bool1 = bool2;
              if (!bool2)
              {
                localObject1 = aqep.b(localFriendProfileCardActivity.app, -1L);
                bool1 = bool2;
                if ("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip" != null)
                {
                  bool1 = bool2;
                  if (localObject1 != null)
                  {
                    localFile = new File((String)localObject1);
                    localObject2 = new File((String)localObject1 + File.separator + "config_black.json");
                    if ((!localFile.isDirectory()) || (!((File)localObject2).exists())) {
                      continue;
                    }
                    bool1 = true;
                  }
                }
              }
              localFriendProfileCardActivity.a.X("downloadCommonEnd", "downloadBackgroundEnd", false);
              if (localFriendProfileCardActivity.f != null)
              {
                localObject1 = localFriendProfileCardActivity.f.obtainMessage();
                ((Message)localObject1).what = 7;
                if ((!bool1) || (m == 0)) {
                  break label807;
                }
                i = j;
                ((Message)localObject1).arg1 = i;
                ((Message)localObject1).arg2 = 0;
                localFriendProfileCardActivity.f.sendMessage((Message)localObject1);
              }
            }
          }
          this.isRunning.set(false);
          return;
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.FrdProfileCard", 2, "start downloadCardTemplate path= " + (String)localObject1);
          }
          File localFile = new File((String)localObject1 + ".zip");
          if (localFile.exists()) {
            localFile.delete();
          }
          Object localObject2 = new aquz("https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip", localFile);
          ((aquz)localObject2).cxX = "profileCardDownload";
          ((aquz)localObject2).cxW = "VIP_profilecard";
          int k = aqva.a((aquz)localObject2, localFriendProfileCardActivity.app);
          if (k != 0) {
            break label844;
          }
          i = 1;
          if (i != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard", 2, "common zip download success! size = " + localFile.length());
            }
            try
            {
              aqhq.W(localFile.getAbsolutePath(), (String)localObject1 + File.separator, false);
              aqep.v(localFriendProfileCardActivity.app, "common", "583");
              if (aqep.bY(localFriendProfileCardActivity.app))
              {
                localFile.delete();
                if (!QLog.isColorLevel()) {
                  break label838;
                }
                QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate unzip success");
                break label838;
              }
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.FrdProfileCard", 2, "downloadCardTemplate  success but unzip error");
              }
              bool1 = bool2;
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              bool1 = bool2;
            }
            continue;
          }
          QLog.e("Q.profilecard.FrdProfileCard", 1, "download template fail code = " + k + " url = " + "https://imgcache.gtimg.cn/club/mobile/profile/template/android_common_583.zip");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          this.isRunning.set(false);
          return;
        }
        boolean bool1 = bool2;
        continue;
        label807:
        int i = 0;
        continue;
        label812:
        int m = bool1;
        continue;
        label819:
        bool1 = true;
        continue;
        for (;;)
        {
          label825:
          m = bool1;
          break;
          label832:
          bool1 = false;
        }
        label838:
        bool1 = true;
        continue;
        label844:
        i = 0;
      }
    }
  }
  
  public class ProfileTopGestureLayout
    extends TopGestureLayout
  {
    public ProfileTopGestureLayout(Context paramContext)
    {
      super();
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((FriendProfileCardActivity.this.a instanceof ProfilePhotoView))
      {
        View localView = (View)FriendProfileCardActivity.this.a.mt.get("map_key_qzonecover");
        if (((localView instanceof QzonePhotoView)) && (((QzonePhotoView)localView).cwQ)) {
          return false;
        }
      }
      else if (((FriendProfileCardActivity.this.a instanceof ProfileTagView)) && (((ProfileTagView)FriendProfileCardActivity.this.a).mIsDragging))
      {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
  }
  
  static class a
    implements WebProcessManager.a
  {
    private WeakReference<ahyj> dJ;
    
    a(ahyj paramahyj)
    {
      this.dJ = new WeakReference(paramahyj);
    }
    
    public void onResult(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        ahyj localahyj = (ahyj)this.dJ.get();
        if (localahyj != null) {
          localahyj.begin();
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardActivity", 2, "check friend's profile and preload web-process!");
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void AT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */