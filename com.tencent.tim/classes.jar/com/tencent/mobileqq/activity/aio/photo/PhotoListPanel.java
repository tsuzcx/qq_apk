package com.tencent.mobileqq.activity.aio.photo;

import aarz;
import acbn;
import acbs;
import acei;
import acfp;
import acms;
import afei;
import ajcy;
import akxc;
import akxe;
import akya;
import alte;
import altg;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anfr;
import anol;
import anot;
import aopb;
import appb;
import aqft;
import aqfx;
import aqfy;
import aqgv;
import aqha;
import aqhq;
import aqiw;
import aqmd;
import armm;
import avpw;
import avpw.d;
import avzp;
import com.dataline.activities.LiteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.DynamicImageMediaFileFilter;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.b;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.hiboom.SquareRelativeLayout;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.util.Pair;
import com.tencent.widget.RoundRectImageView;
import com.tencent.widget.XEditTextEx;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import jof;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import sxx;
import syw;
import ujt.d;
import wja;
import wmj;
import xun;
import xuo;
import xup;
import xuq;
import xur;
import xus;
import xut;
import xuu;
import xuv;
import xuw;
import xux;
import xuy;
import xuz;
import yfp;
import zsh;

public class PhotoListPanel
  extends RelativeLayout
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static int bXh = 20;
  public static int bXi;
  private static int bXj = -1;
  CheckBox B;
  public LinkedList<String> C = new LinkedList();
  public int Cv;
  public long JB;
  long JC;
  TextView Ks;
  TextView Kt;
  Intent O;
  Button X;
  private aqmd jdField_a_of_type_Aqmd;
  d jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$d;
  public e a;
  f jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$f;
  h jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h;
  MediaFileFilter jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
  String aWf;
  String aWq;
  String aWr;
  private String aWs;
  private String aWt = acfp.m(2131709568);
  Boolean ac;
  QQAppInterface app;
  afei jdField_b_of_type_Afei;
  a jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a;
  c jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c;
  int bXk;
  int bXl;
  int bXm;
  int bXn;
  int bXo = 278921216;
  int bXp = -16777216;
  public volatile boolean bjC;
  boolean bjD;
  boolean bjE;
  boolean bjF;
  boolean bjG;
  boolean bjH;
  boolean bjI;
  boolean bjJ;
  boolean bjK = false;
  boolean bjL = false;
  boolean bjM = false;
  boolean bjN = false;
  boolean bjO = false;
  boolean bjP;
  boolean bjQ;
  View bottomBar;
  afei c;
  Button ed;
  Button ee;
  HashMap<LocalMediaInfo, LocalMediaInfo> gW = new HashMap();
  public Map<String, LocalMediaInfo> hT;
  boolean isSingleMode = false;
  Activity mActivity;
  int mBusiType;
  MediaFileFilter mFilter;
  private int mLastRequestCode = -1;
  RecyclerView.LayoutManager mLayoutManager;
  RecyclerView mRecyclerView;
  public int mScrollState = 0;
  SessionInfo mSessionInfo;
  int mSizeLimit = wC();
  Handler mUiHandler = new Handler(Looper.getMainLooper());
  SharedPreferences pref;
  ArrayList<Integer> qN = new ArrayList();
  ArrayList<String> qO;
  View xe;
  View xf;
  View xg;
  
  public PhotoListPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean SM()
  {
    return false;
  }
  
  private void a(BaseChatPie paramBaseChatPie, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    boolean bool2;
    if ((paramBaseChatPie.mSourceMsgInfo != null) && (TextUtils.isEmpty(paramBaseChatPie.mSourceMsgInfo.mAnonymousNickName)))
    {
      paramBaseChatPie.a(new ujt.d());
      if (((HotChatManager)this.app.getManager(60)).a(this.mSessionInfo.aTl) == null) {
        break label420;
      }
      bool1 = true;
      localObject1 = aqgv.a(this.app, this.mSessionInfo.cZ, this.mSessionInfo.aTl, paramBaseChatPie.mSourceMsgInfo.mSourceMsgSenderUin + "");
      localObject2 = this.app;
      localObject3 = paramBaseChatPie.mContext;
      localObject4 = this.mSessionInfo.aTl;
      str = paramBaseChatPie.mSourceMsgInfo.mSourceMsgSenderUin + "";
      localObject5 = paramBaseChatPie.a;
      if (this.mSessionInfo.cZ != 1) {
        break label426;
      }
      bool2 = true;
      label177:
      localObject1 = appb.a((QQAppInterface)localObject2, (Context)localObject3, (String)localObject4, str, (String)localObject1, bool1, (EditText)localObject5, bool2, true);
      if ((localObject1 != null) && (((SpannableString)localObject1).length() != 0)) {
        paramBaseChatPie.a.getEditableText().insert(0, (CharSequence)localObject1);
      }
      localObject1 = yfp.c(this.app, this.mSessionInfo, paramBaseChatPie.mSourceMsgInfo);
      paramBaseChatPie.mSourceMsgInfo.mType = 0;
      if (((localObject1 instanceof MessageForPic)) || ((localObject1 instanceof MessageForMixedMsg))) {
        paramBaseChatPie.mSourceMsgInfo.oriMsgType = 1;
      }
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = appb.a(paramBaseChatPie.a.getEditableText(), (ArrayList)localObject1);
    Object localObject3 = (ajcy)this.app.getManager(174);
    Object localObject4 = this.app;
    String str = this.mSessionInfo.aTl;
    int i = this.mSessionInfo.cZ;
    Object localObject5 = (ArrayList)paramPair.first;
    if (this.Cv == 2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((ajcy)localObject3).a((QQAppInterface)localObject4, str, i, (ArrayList)localObject5, bool1, (String)localObject2, (ArrayList)localObject1, paramBaseChatPie.mSourceMsgInfo);
      paramBaseChatPie.bIN();
      if (!((ArrayList)paramPair.second).isEmpty()) {
        d(new ArrayList(), (ArrayList)paramPair.second, this.bjE);
      }
      return;
      label420:
      bool1 = false;
      break;
      label426:
      bool2 = false;
      break label177;
    }
  }
  
  @TargetApi(9)
  private void ceW()
  {
    boolean bool = SM();
    if (hr()) {}
    for (String str = "qzone_will_upload_to_personal_album"; Build.VERSION.SDK_INT >= 9; str = "qzone_will_upload_to_qun_album" + this.mSessionInfo.aTl)
    {
      this.pref.edit().putBoolean(str, bool).apply();
      return;
    }
    ThreadManager.postImmediately(new PhotoListPanel.3(this, str, bool), null, false);
  }
  
  private void r(String paramString1, String paramString2, String paramString3)
  {
    Properties localProperties = new Properties();
    localProperties.put(paramString2, paramString3);
    anol.a(BaseApplicationImpl.getContext()).reportKVEvent(paramString1, localProperties);
  }
  
  public static void setShowModeToSp(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      bXj = paramInt;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_PHOTO_LIST_PANEL", 0).edit();
      localEditor.putInt("SP_KEY_SHOW_MODE", paramInt);
      localEditor.commit();
    }
  }
  
  public void Dz(int paramInt)
  {
    if (this.bjD) {}
    while (!this.bjE) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "cancelAllPresendPic, type = " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_presend_cancel_type", paramInt);
    RichmediaService.dl(localBundle);
  }
  
  protected boolean Q(Intent paramIntent)
  {
    return RichmediaService.Q(paramIntent);
  }
  
  protected boolean SN()
  {
    return this.O.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
  }
  
  protected boolean SO()
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label80;
      }
      QQToast.a(this.mActivity, 1, 2131719242, 0).show(getResources().getDimensionPixelSize(2131299627));
      return false;
      i = 0;
      break;
    }
    label80:
    if (aqft.hE() <= 512000L)
    {
      ShortVideoPreviewActivity.ag(this.mActivity, 2131720275);
      return false;
    }
    return true;
  }
  
  public boolean SP()
  {
    return (!SN()) && (!jof.a().dd(this.mSessionInfo.aTl));
  }
  
  public b a()
  {
    return new b();
  }
  
  void a(int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItemViewType(paramInt);
    a(paramArrayList, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, i, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItem(paramInt));
    boolean bool2 = SN();
    Object localObject = new Pair(new ArrayList(), new ArrayList());
    boolean bool1;
    if (this.jdField_a_of_type_Aqmd != null)
    {
      localObject = this.jdField_a_of_type_Aqmd;
      if (this.Cv == 2)
      {
        bool1 = true;
        localObject = ((aqmd)localObject).a(paramArrayList, bool1, this.hT, null);
        label102:
        if (i != 0) {
          break label188;
        }
        if (a(paramArrayList, bool2, this.Cv)) {
          break label144;
        }
      }
    }
    label144:
    label188:
    while (i != 1)
    {
      return;
      bool1 = false;
      break;
      ((ArrayList)((Pair)localObject).first).addAll(paramArrayList);
      break label102;
      if (bool2)
      {
        s((ArrayList)((Pair)localObject).first, this.Cv);
        return;
      }
      a((Pair)localObject, paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, paramBoolean3, this.Cv);
      return;
    }
    if (((ArrayList)((Pair)localObject).first).isEmpty()) {}
    for (paramArrayList = (String)((ArrayList)((Pair)localObject).second).get(0);; paramArrayList = (String)((ArrayList)((Pair)localObject).first).get(0))
    {
      long l = getFileLength(paramArrayList);
      if (!b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.c(paramArrayList))) {
        break;
      }
      a(paramBoolean2, paramString1, paramString2, paramString3, l, (Pair)localObject);
      return;
    }
  }
  
  protected void a(SendVideoActivity.b paramb)
  {
    paramb.uH();
    if ((paramb.mVideoPath != null) && (!paramb.mVideoPath.equals(""))) {
      paramb.cAr();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    bXj = 0;
    this.app = paramQQAppInterface;
    this.O = paramIntent;
    if (this.O == null) {
      this.O = new Intent();
    }
    if (this.O.hasExtra("showFlashPic")) {
      this.ac = Boolean.valueOf(this.O.getBooleanExtra("showFlashPic", false));
    }
    this.bjD = this.O.getBooleanExtra("key_disable_presend", false);
    this.bjG = this.O.getBooleanExtra("key_disable_quality_cb", false);
    this.bjH = this.O.getBooleanExtra("key_disable_edit_btn", false);
    this.bjI = this.O.getBooleanExtra("key_disable_send_btn", false);
    this.bjF = this.O.getBooleanExtra("key_new_lbs_client", false);
    this.bjJ = this.O.getBooleanExtra("key_allow_mix_select", true);
    this.aWf = this.O.getStringExtra("key_my_uin");
    this.aWq = this.O.getStringExtra("key_my_nick");
    this.aWr = this.O.getStringExtra("key_my_head_dir");
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "init, mDisablePresend = " + this.bjD);
    }
    this.mSessionInfo = paramSessionInfo;
    this.mActivity = paramActivity;
    paramQQAppInterface = this.mActivity.getIntent();
    this.bXm = this.O.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    if (this.mSessionInfo.cZ == 9501)
    {
      this.bXm = 5;
      this.O.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 5);
    }
    this.bXn = this.O.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM_VIDEO", 1);
    this.JC = this.O.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_SIZE", 1048576000L);
    this.mFilter = MediaFileFilter.getFilter(this.O.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 0));
    this.bjN = this.O.getBooleanExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", false);
    this.isSingleMode = this.O.getBooleanExtra("PhotoConst.IS_SINGLE_MODE", false);
    this.mBusiType = this.O.getIntExtra("PhotoConst.SEND_BUSINESS_TYPE", 1052);
    if (this.bjN) {
      this.mFilter = new DynamicImageMediaFileFilter(MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE);
    }
    this.mFilter.setSupportWebp(true);
    this.bXk = ((int)getResources().getDimension(2131297339));
    this.bXl = ((int)getResources().getDimension(2131297340));
    this.c = new afei(this.bXo, this.bXl, this.bXl);
    this.jdField_b_of_type_Afei = new afei(this.bXp, this.bXl, this.bXl);
    if (paramQQAppInterface.hasExtra("PhotoConst.SELECTED_PATHS"))
    {
      paramActivity = paramQQAppInterface.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramActivity != null) {
        this.C.addAll(paramActivity);
      }
      paramActivity = paramQQAppInterface.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramActivity != null) {
        this.qN.addAll(paramActivity);
      }
      paramQQAppInterface.removeExtra("PhotoConst.SELECTED_PATHS");
      paramQQAppInterface.removeExtra("PhotoConst.SELECTED_INDEXS");
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c.bF(t());
      }
      this.jdField_a_of_type_Aqmd = new aqmd().a(this.mSizeLimit).a(SP());
      this.bottomBar = findViewById(2131379990);
      this.ed = ((Button)findViewById(2131362576));
      this.ee = ((Button)findViewById(2131371047));
      this.xf = findViewById(2131372839);
      this.B = ((CheckBox)findViewById(2131375366));
      this.Ks = ((TextView)findViewById(2131375372));
      this.Kt = ((TextView)findViewById(2131375367));
      this.xe = findViewById(2131372431);
      this.X = ((Button)findViewById(2131377990));
      this.ed.setOnClickListener(this);
      this.ee.setOnClickListener(this);
      if (!this.bjG) {
        break label1001;
      }
      this.B.setVisibility(4);
      this.Ks.setVisibility(4);
      this.Kt.setVisibility(4);
      label774:
      if (this.bjH) {
        this.ee.setVisibility(4);
      }
      if (this.bjI) {
        this.X.setVisibility(4);
      }
      this.X.setOnClickListener(this);
      this.mRecyclerView = ((RecyclerView)findViewById(2131367340));
      switch (bXj)
      {
      default: 
        this.mLayoutManager = new StaggeredGridLayoutManager(1, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e = new e(this);
      this.mRecyclerView.setLayoutManager(this.mLayoutManager);
      this.mRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e);
      this.mRecyclerView.addOnScrollListener(new xuo(this));
      this.pref = BaseApplication.getContext().getSharedPreferences("share", 4);
      updateButton();
      ceU();
      bOK();
      return;
      if (!this.O.hasExtra("PhotoConst.SELECTED_PATHS")) {
        break;
      }
      paramQQAppInterface = this.O.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      if (paramQQAppInterface != null) {
        this.C.addAll(paramQQAppInterface);
      }
      paramQQAppInterface = this.O.getIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS");
      if (paramQQAppInterface == null) {
        break;
      }
      this.qN.addAll(paramQQAppInterface);
      break;
      label1001:
      this.B.setOnCheckedChangeListener(this);
      this.B.setContentDescription(acfp.m(2131709602));
      this.Ks.setOnClickListener(this);
      this.Ks.setContentDescription(acfp.m(2131709577));
      this.Kt.setOnClickListener(this);
      break label774;
      this.mLayoutManager = new GridLayoutManager(getContext(), 2);
      ((GridLayoutManager)this.mLayoutManager).setOrientation(0);
    }
  }
  
  void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean)
  {
    if (((ArrayList)paramPair.first).isEmpty()) {}
    LocalMediaInfo localLocalMediaInfo;
    for (String str = (String)((ArrayList)paramPair.second).get(0);; str = (String)((ArrayList)paramPair.first).get(0))
    {
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.c(str);
      if (localLocalMediaInfo != null) {
        break;
      }
      return;
    }
    akxe.a("TAG", "sendVideo", "info = " + localLocalMediaInfo + ",sendInBackground = " + paramBoolean);
    Intent localIntent = new Intent(this.mActivity, SendVideoActivity.class);
    localIntent.putExtra("send_in_background", paramBoolean);
    if (!((ArrayList)paramPair.second).isEmpty())
    {
      paramPair = new ArrayList(1);
      paramPair.add(str);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", paramPair);
    }
    for (;;)
    {
      localIntent.putExtra("uin", this.mSessionInfo.aTl);
      localIntent.putExtra("uintype", this.mSessionInfo.cZ);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", this.Cv);
      localIntent.putExtra("file_source", "album_flow");
      paramPair = this.mActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str = this.mActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramPair);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", str);
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        anot.a(null, "CliOper", "", "", "0X8006130", "0X8006130", 0, 0, "", "", "", "");
      }
      if (this.Cv == 2) {
        aqfy.ki(0, 1);
      }
      localIntent.putExtra("start_init_activity_after_sended", false);
      if (!paramBoolean) {
        break;
      }
      cp(localIntent);
      return;
      localIntent.putExtra("file_send_path", str);
      localIntent.putExtra("file_send_size", localLocalMediaInfo.fileSize);
      localIntent.putExtra("file_send_duration", localLocalMediaInfo.mDuration);
    }
    this.mActivity.startActivity(localIntent);
  }
  
  protected void a(Pair<ArrayList<String>, ArrayList<String>> paramPair, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, boolean paramBoolean3, int paramInt)
  {
    if (paramBoolean2)
    {
      localIntent = new Intent();
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.mBusiType);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)paramPair.first);
      if ((paramPair.second != null) && (!((ArrayList)paramPair.second).isEmpty())) {
        localIntent.putExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (Serializable)paramPair.second);
      }
      localIntent.putExtra("uin", this.mSessionInfo.aTl);
      localIntent.putExtra("uintype", this.mSessionInfo.cZ);
      localIntent.putExtra("troop_uin", this.mSessionInfo.troopUin);
      localIntent.putExtra("key_confess_topicid", this.mSessionInfo.topicId);
      localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
      localIntent.putExtra("send_in_background", true);
      localIntent.putExtra("entrance", this.mSessionInfo.entrance);
      if (((ArrayList)paramPair.first).size() == 1) {
        localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)paramPair.first);
      }
      cq(localIntent);
      anot.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
      return;
    }
    Intent localIntent = new Intent(this.mActivity, SendPhotoActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.mBusiType);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)paramPair.first);
    if ((paramPair.second != null) && (!((ArrayList)paramPair.second).isEmpty())) {
      localIntent.putExtra("PhotoConst.PHOTO_PATHS_BY_FILE", (Serializable)paramPair.second);
    }
    localIntent.putExtra("PhotoConst.PHOTO_COUNT", ((ArrayList)paramPair.first).size());
    localIntent.putExtra("uin", this.mSessionInfo.aTl);
    localIntent.putExtra("uintype", this.mSessionInfo.cZ);
    localIntent.putExtra("troop_uin", this.mSessionInfo.troopUin);
    localIntent.putExtra("key_confess_topicid", this.mSessionInfo.topicId);
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("entrance", this.mSessionInfo.entrance);
    if (((ArrayList)paramPair.first).size() == 1) {
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)paramPair.first);
    }
    if (paramBoolean3)
    {
      localIntent.putExtra("key_is_sync_qzone", 1);
      if (this.aWs == null) {
        break label547;
      }
    }
    label547:
    for (paramPair = this.aWs;; paramPair = "")
    {
      localIntent.putExtra("key_qzone_album_id", paramPair);
      localIntent.putExtra("key_qzone_batch_id", PhotoUtils.eG());
      a(paramBoolean1, paramInt, localIntent);
      break;
    }
  }
  
  protected void a(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    this.qN.remove(paramLocalMediaInfo.position);
    this.C.remove(paramLocalMediaInfo.path);
    ceV();
    if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c != null) {
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c.bF(t());
    }
    updateButton();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, type = " + paramInt + ", paths.size() = " + paramArrayList.size() + " mediaInfo:" + paramLocalMediaInfo + ",allowPresend = " + paramBoolean1 + ",sendInBackground = " + paramBoolean2 + ",reportActionName = " + paramString1 + ",reverse2 = " + paramString2 + ",reverse3 = " + paramString3);
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (paramInt == 2)
      {
        Object localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {}
        for (paramInt = 4;; paramInt = 0)
        {
          localObject = ((BaseApplication)localObject).getSharedPreferences("presend_config_sp", paramInt);
          ((SharedPreferences)localObject).edit().putBoolean("key_presend_off_flag", true).commit();
          ((SharedPreferences)localObject).edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
          Dz(1020);
          this.mActivity.startActivityForResult(paramIntent, 100005);
          return;
        }
      }
      if (Q(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent OK");
        }
        this.mActivity.startActivityForResult(paramIntent, 100005);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent failed");
      }
      this.mActivity.startActivity(paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
    }
    this.mActivity.startActivity(paramIntent);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, long paramLong, Pair<ArrayList<String>, ArrayList<String>> paramPair)
  {
    if ((anfr.akV != 0L) && (System.currentTimeMillis() - anfr.akV < 300000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + anfr.akV);
      }
      if (!m(paramLong, bool)) {
        break;
      }
      String str = ShortVideoUtils.g(this.mActivity, paramLong);
      str = String.format(getResources().getString(2131720250), new Object[] { str });
      paramString1 = new PhotoListPanel.4(this, paramPair, paramBoolean, paramString1, paramString2, paramString3);
      if (armm.a(this.mActivity, 4, new xur(this, paramString1))) {
        aqha.a(this.mActivity, 232, null, str, new xus(this, paramString1), new xut(this)).show();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
      }
      return;
    }
    if ((!((ArrayList)paramPair.first).isEmpty()) || (!((ArrayList)paramPair.second).isEmpty())) {
      a(paramPair, paramBoolean);
    }
    anot.a(null, "CliOper", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  public boolean a(BaseChatPie paramBaseChatPie, List<String> paramList, boolean paramBoolean)
  {
    Object localObject = new Pair(new ArrayList(), new ArrayList());
    boolean bool;
    if (this.jdField_a_of_type_Aqmd != null)
    {
      localObject = this.jdField_a_of_type_Aqmd;
      if (this.Cv == 2)
      {
        bool = true;
        localObject = ((aqmd)localObject).a(paramList, bool, this.hT, null);
        label62:
        if ((wz() <= 0) || (!paramBoolean) || (paramBaseChatPie == null) || (((ArrayList)((Pair)localObject).first).isEmpty())) {
          break label185;
        }
        paramBoolean = true;
        label93:
        if (!paramBoolean) {
          break label226;
        }
        a(paramBaseChatPie, (Pair)localObject);
        i = 0;
        if (this.mSessionInfo.cZ != 0) {
          break label190;
        }
        i = 1;
      }
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8009BEB", "0X8009BEB", i, 0, "", "", "", "");
      resetStatus();
      return paramBoolean;
      bool = false;
      break;
      ((ArrayList)((Pair)localObject).first).addAll(paramList);
      break label62;
      label185:
      paramBoolean = false;
      break label93;
      label190:
      if (this.mSessionInfo.cZ == 1) {
        i = 2;
      } else if (this.mSessionInfo.cZ == 3000) {
        i = 3;
      }
    }
    label226:
    aarz.hJ(paramList);
    if ((SM()) && (hr())) {}
    for (int i = 1;; i = 0)
    {
      d((ArrayList)((Pair)localObject).first, (ArrayList)((Pair)localObject).second, this.bjE);
      if (i == 0) {
        break;
      }
      paramBaseChatPie = new LpReportInfo_pf00064(723, 1, 5);
      LpReportManager.getInstance().reportToPF00064(paramBaseChatPie, false, false);
      avzp.report(8);
      r("aio_sync_qzone", "operation_type", "panel_upload");
      break;
    }
  }
  
  protected boolean a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt)
  {
    if (!z(paramArrayList))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
      }
      QQToast.a(this.mActivity, 2131696981, 0).show();
      ceT();
      this.C.clear();
      this.qN.clear();
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c.bF(null);
      }
      updateButton();
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean, BaseChatPie paramBaseChatPie)
  {
    return a(paramBaseChatPie, this.C, paramBoolean);
  }
  
  protected boolean b(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = Environment.getExternalStorageDirectory();
    if ((paramLocalMediaInfo.exists()) && (paramLocalMediaInfo.canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label80;
      }
      QQToast.a(this.mActivity, 1, 2131719242, 0).show(getResources().getDimensionPixelSize(2131299627));
      return false;
      i = 0;
      break;
    }
    label80:
    if (aqft.hE() <= 512000L)
    {
      ShortVideoPreviewActivity.ag(this.mActivity, 2131720275);
      return false;
    }
    return true;
  }
  
  public void bOK()
  {
    if (ThemeUtil.isNowThemeIsNight(this.app, false, null))
    {
      this.mRecyclerView.setBackgroundColor(-16777216);
      this.X.setTextColor(-1509949441);
    }
  }
  
  void cE(String paramString, int paramInt)
  {
    if (this.bjD) {}
    while (!this.bjE) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "presendPic, path = " + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_presend_path", paramString);
    localBundle.putInt("entrance", this.mSessionInfo.entrance);
    RichmediaService.dj(localBundle);
  }
  
  public void ceT()
  {
    TextView localTextView = (TextView)this.xe.findViewById(2131372564);
    int i = getResources().getDisplayMetrics().densityDpi;
    if (i < 320) {
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    if (bXi == 0)
    {
      this.xe.setVisibility(0);
      this.mRecyclerView.setVisibility(8);
    }
    this.JB = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "densityDpi = " + i + "qurey time=" + this.JB);
    }
    ThreadManager.post(new QueryMediaTask(), 8, null, true);
  }
  
  public void ceU()
  {
    if (this.bjD) {}
    do
    {
      return;
      this.bjE = wmj.a(this.mSessionInfo, this.bjF);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "initPresend! mAllowPresend = " + this.bjE);
      }
    } while (!this.bjE);
    BinderWarpper localBinderWarpper = new BinderWarpper(new akya(this.mSessionInfo.cZ, this.mSessionInfo.aTl, this.mSessionInfo.troopUin, this.aWf, this.mSessionInfo.topicId).asBinder());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("binder_presendService", localBinderWarpper);
    RichmediaService.di(localBundle);
  }
  
  public void ceV()
  {
    Object localObject1;
    Object localObject2;
    switch (bXj)
    {
    default: 
      localObject1 = ((StaggeredGridLayoutManager)this.mLayoutManager).findFirstVisibleItemPositions(null);
      localObject2 = ((StaggeredGridLayoutManager)this.mLayoutManager).findLastVisibleItemPositions(null);
      if (localObject1.length <= 0) {
        break;
      }
    }
    for (int j = localObject1[0];; j = 0)
    {
      int i;
      if (localObject2.length > 0) {
        i = localObject2[0];
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("check", 2, "updateCheckView first=" + j + "lastvisible=" + i);
        }
        label111:
        if (j <= i)
        {
          localObject1 = (PhotoListPanel.e.a)this.mRecyclerView.findViewHolderForAdapterPosition(j);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItem(j);
          if (localObject2 != null)
          {
            int k = this.C.indexOf(((LocalMediaInfo)localObject2).path);
            if (QLog.isColorLevel()) {
              QLog.d("check", 2, "updateCheckView mIndex=" + k);
            }
            if ((k < 0) || (localObject1 == null)) {
              break label251;
            }
            ((PhotoListPanel.e.a)localObject1).mCheckBox.setCheckedNumber(k + 1);
            ((PhotoListPanel.e.a)localObject1).tR.setVisibility(0);
          }
          for (;;)
          {
            j += 1;
            break label111;
            j = ((GridLayoutManager)this.mLayoutManager).findFirstVisibleItemPosition();
            i = ((GridLayoutManager)this.mLayoutManager).findLastVisibleItemPosition();
            break;
            label251:
            if (localObject1 == null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("check", 2, "updateCheckView view is null?????=");
              }
            }
            else
            {
              ((PhotoListPanel.e.a)localObject1).mCheckBox.setChecked(false);
              ((PhotoListPanel.e.a)localObject1).tR.setVisibility(4);
            }
          }
        }
        return;
        i = 0;
      }
    }
  }
  
  public void ceX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onEditBtnClicked");
    }
    if (this.C.size() > 0)
    {
      Intent localIntent = EditPicActivity.a(this.mActivity, (String)this.C.get(0), true, true, true, true, true, 2, 99, 5);
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.Cv);
      localIntent.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", SN());
      localIntent.putExtra("key_enable_edit_title_bar", true);
      this.mActivity.startActivity(localIntent);
      if ((this.mActivity instanceof SplashActivity)) {
        anot.a(null, "dc00898", "", "", "0X800A06B", "0X800A06B", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void ceY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked");
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a.a(this))) {
      return;
    }
    if (this.mSessionInfo.cZ == 1) {}
    try
    {
      ((acms)((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.aWf)).getBusinessHandler(20)).bM(this.mSessionInfo.aTl, true);
      if (!this.C.isEmpty())
      {
        ArrayList localArrayList = new ArrayList(this.C);
        if (this.isSingleMode) {
          this.O.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        }
        this.O.putExtra("fromPhotoListPanel", true);
        this.O.putExtra("peakconstant.request_code", 100006);
        this.O.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.Cv);
        this.O.putExtra("PhotoConst.is_troop_send_mixed_msg", this.bjO);
        this.O.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.bjK);
        this.O.putExtra("PhotoConst.UPLOAD_CHECKBOX_IS_CHECKED", SM());
        this.O.putExtra("PhotoConst.AIO_TO_PHOTO_LIST_NEED_SHOW_UPLOAD_BAR", hr());
        if ((this.gW != null) && (!this.gW.isEmpty())) {
          this.O.putExtra("PhotoConst.SEND_NO_PRESEND", true);
        }
        wmj.a(this.app, this.mActivity, this.mSessionInfo, localArrayList, this.O, this.gW);
        resetStatus();
        anot.a(null, "CliOper", "", "", "0X8005E05", "0X8005E05", 0, 0, "", "", "", "");
        cfb();
        return;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PhotoListPanel", 2, "onAlbumBtnClicked() getAppRuntime ERROR");
          continue;
          Object localObject = null;
        }
      }
    }
  }
  
  protected void ceZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onSendBtnClicked");
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a.b(this))) {
      return;
    }
    a(false, null);
  }
  
  void cfa()
  {
    if (this.bjG) {
      return;
    }
    switch (this.Cv)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.B.setChecked(false);
      return;
    }
    aqfy.a(this.Kt, this.C, this.hT, true, this.mActivity, null, null);
    this.B.setChecked(true);
  }
  
  void cfb()
  {
    if ((this.xg != null) && (this.xg.getVisibility() == 0))
    {
      acbs.go(this.xg);
      this.xg = null;
      this.bjM = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.notifyDataSetChanged();
      acbs.k(this.mActivity, this.xf);
    }
  }
  
  protected void cp(Intent paramIntent)
  {
    ThreadManager.executeOnSubThread(new PhotoListPanel.2(this, new SendVideoActivity.b((BaseActivity)this.mActivity, paramIntent)));
  }
  
  protected void cq(Intent paramIntent)
  {
    ThreadManager.post(new SendPhotoTask((BaseActivity)this.mActivity, paramIntent, null), 8, null, false);
  }
  
  public void d(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias, paths.size() = " + paramArrayList1.size() + ",allowPresend = " + paramBoolean);
    }
    boolean bool2 = z(paramArrayList1);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = z(paramArrayList2);
    }
    if (!bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListPanel", 2, "PhotoListPanel sendMedias,pics not exits, just return.");
      }
      if ((SP()) || (!paramArrayList1.isEmpty()) || (!paramArrayList2.isEmpty())) {
        QQToast.a(this.mActivity, 2131696985, 0).show();
      }
      ceT();
      this.C.clear();
      this.qN.clear();
      updateButton();
    }
    do
    {
      do
      {
        return;
      } while (!SO());
      if (!d(paramArrayList1, paramArrayList2)) {
        break;
      }
      String str = getResources().getString(2131719478);
      paramArrayList1 = new PhotoListPanel.8(this, paramArrayList1, paramArrayList2, paramBoolean);
      if (armm.a(this.mActivity, 4, new xuu(this, paramArrayList1))) {
        aqha.a(this.mActivity, 232, null, str, new xup(this, paramArrayList1), new xuq(this)).show();
      }
    } while (!QLog.isColorLevel());
    QLog.i("PhotoListPanel", 2, "show shortvideo_mobile_send_confirm dialog");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$d != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$d.bJh();
    }
    e(paramArrayList1, paramArrayList2, paramBoolean);
  }
  
  protected boolean d(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      int j = 0;
      int k = i;
      if (j < paramArrayList1.size())
      {
        paramArrayList2 = (String)paramArrayList1.get(j);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getFileType(paramArrayList2) == 1) {
          k = 1;
        }
      }
      else
      {
        if ((anfr.akV == 0L) || (System.currentTimeMillis() - anfr.akV >= 300000L)) {
          break label155;
        }
      }
      label155:
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "upload video isConfirmed=" + bool + " allowUploadInXGTime=" + anfr.akV);
        }
        if ((!aqiw.isMobileNetWork(this.mActivity)) || (bool) || (k == 0)) {
          break label161;
        }
        return true;
        j += 1;
        break;
      }
      label161:
      return false;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.onTouch(this, paramMotionEvent);
      super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.lastX = paramMotionEvent.getX();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.lastY = paramMotionEvent.getY();
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  void e(@NonNull ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, boolean paramBoolean)
  {
    boolean bool = SN();
    int i1 = this.Cv;
    HashMap localHashMap = new HashMap();
    int j = 0;
    int k = 0;
    int i = 0;
    if (j < paramArrayList1.size())
    {
      localObject = (String)paramArrayList1.get(j);
      int m;
      int n;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getFileType((String)localObject) == 1)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.c((String)localObject);
        m = k;
        n = i;
        if (localObject != null)
        {
          SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
          localSendVideoInfo.fileSize = ((LocalMediaInfo)localObject).fileSize;
          localSendVideoInfo.duration = ((LocalMediaInfo)localObject).mDuration;
          localHashMap.put(Integer.valueOf(j), localSendVideoInfo);
          n = i + 1;
          m = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = m;
        i = n;
        break;
        m = k + 1;
        n = i;
      }
    }
    if ((bool) && (k > 0) && (i == 0))
    {
      s(paramArrayList1, i1);
      return;
    }
    Object localObject = new Intent(this.mActivity, SendPhotoActivity.class);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS_BY_FILE", paramArrayList2);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.mBusiType);
    ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList1);
    if (!localHashMap.isEmpty()) {
      ((Intent)localObject).putExtra("PhotoConst.VIDEO_INFOS", localHashMap);
    }
    ((Intent)localObject).putExtra("PhotoConst.PHOTO_COUNT", paramArrayList1.size());
    ((Intent)localObject).putExtra("uin", this.mSessionInfo.aTl);
    ((Intent)localObject).putExtra("uintype", this.mSessionInfo.cZ);
    ((Intent)localObject).putExtra("troop_uin", this.mSessionInfo.troopUin);
    ((Intent)localObject).putExtra("key_confess_topicid", this.mSessionInfo.topicId);
    ((Intent)localObject).putExtra("PhotoConst.SEND_SIZE_SPEC", i1);
    ((Intent)localObject).putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    ((Intent)localObject).putExtra("entrance", this.mSessionInfo.entrance);
    if (paramArrayList1.size() == 1) {
      ((Intent)localObject).putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramArrayList1);
    }
    a(paramBoolean, i1, (Intent)localObject);
    anot.a(null, "CliOper", "", "", "0X8009AAF", "0X8009AAF", PhotoUtils.c(this.mSessionInfo), 0, String.valueOf(k), String.valueOf(i), "", "");
  }
  
  protected long getFileLength(String paramString)
  {
    return new File(paramString).length();
  }
  
  public void h(BaseChatPie paramBaseChatPie)
  {
    if (this.mLastRequestCode != 100006) {
      return;
    }
    this.mLastRequestCode = -1;
    Intent localIntent = this.mActivity.getIntent();
    if (localIntent.hasExtra("PhotoConst.send_photo_activity_result")) {
      localIntent.removeExtra("PhotoConst.send_photo_activity_result");
    }
    for (;;)
    {
      resetStatus();
      paramBaseChatPie.hidePanel();
      return;
      Dz(1019);
    }
  }
  
  public boolean hT(String paramString)
  {
    int i = wz();
    int j = wA();
    return (!TextUtils.isEmpty(paramString)) && (i > 0) && (j == 0);
  }
  
  protected boolean hr()
  {
    if (wy() == 0) {}
    while ((this.bjP) || (this.mSessionInfo == null) || ((this.mSessionInfo.cZ != 0) && (this.mSessionInfo.cZ != 1000) && (this.mSessionInfo.cZ != 1004))) {
      return false;
    }
    return true;
  }
  
  protected boolean m(long paramLong, boolean paramBoolean)
  {
    return (aqiw.isMobileNetWork(this.mActivity)) && (!paramBoolean) && (paramLong >= 1048576L);
  }
  
  public void o(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onActivityResult, requestCode = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 100004: 
    case 100006: 
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOPREVIEW_RETURE");
      }
      zsh.a(getContext(), paramIntent, true, this.gW);
      Object localObject1 = this.C.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.c((String)localObject2);
        if (localObject2 != null) {
          ((LocalMediaInfo)localObject2).mChecked = false;
        }
      }
      this.Cv = paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.SELECTED_PATHS");
      this.C.clear();
      this.qN.clear();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.C.add(localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.c((String)localObject1);
        if (localObject1 != null)
        {
          if (!((LocalMediaInfo)localObject1).mChecked) {
            ((LocalMediaInfo)localObject1).mChecked = true;
          }
          this.qN.add(((LocalMediaInfo)localObject1).position);
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c.bF(t());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.notifyDataSetChanged();
      updateButton();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "onActivityResult, PeakConstants.REQUEST_PHOTOLIST_PANEL_SEND_RETURN");
    }
    ceU();
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_Aqmd != null) {
          this.jdField_a_of_type_Aqmd.a(getContext(), this.C, paramBoolean, this.hT, null);
        }
        this.B.setChecked(true);
        this.Cv = 2;
        aqfy.a(this.Kt, this.C, this.hT, true, this.mActivity, null, null);
        this.Ks.setContentDescription(acfp.m(2131709600));
        anot.a(null, "CliOper", "", "", "0X8005E07", "0X8005E07", 0, 0, "", "", "", "");
      }
      else
      {
        this.Cv = 0;
        this.B.setChecked(false);
        this.Kt.setVisibility(4);
        this.Ks.setContentDescription(acfp.m(2131709554));
        continue;
        this.bjQ = paramBoolean;
        updateButton();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      acbs.go(this.xf);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ceY();
      continue;
      ceX();
      continue;
      label559:
      if (!this.B.isChecked())
      {
        this.B.setChecked(true);
      }
      else
      {
        this.B.setChecked(false);
        continue;
        Object localObject = this.qN.iterator();
        while (((Iterator)localObject).hasNext()) {
          anot.a(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", ((Integer)((Iterator)localObject).next()).intValue() + 1, 0, "2", "", "", "");
        }
        int i = PhotoUtils.d(this.mSessionInfo);
        anot.a(null, "dc00898", "", "", "0X800A912", "0X800A912", this.qN.size(), 0, "" + i, "", "", "");
        ceZ();
        continue;
        if (this.mSessionInfo.cZ == 1) {}
        boolean bool;
        for (i = 1;; i = 0)
        {
          bool = hr();
          localObject = avpw.d.a();
          ((avpw.d)localObject).cMP = this.aWf;
          ((avpw.d)localObject).nickname = this.aWq;
          if (i == 0) {
            break label368;
          }
          avpw.c(this.mActivity, (avpw.d)localObject, this.mSessionInfo.aTl, this.mSessionInfo.aTn, 100008);
          break;
        }
        label368:
        if (bool)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_personal_album_enter_model", 0);
          localBundle.putBoolean("key_personal_album_is_select_video", false);
          if (!TextUtils.isEmpty(this.aWs))
          {
            localBundle.putString("key_default_album_id", this.aWs);
            localBundle.putBoolean("key_from_upload", true);
          }
          avpw.a(this.mActivity, (avpw.d)localObject, localBundle, 100009);
          localObject = new LpReportInfo_pf00064(723, 1, 4);
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
          r("aio_sync_qzone", "operation_type", "panel_select_album");
          continue;
          ceW();
          bool = SM();
          if (hr())
          {
            if (bool)
            {
              i = 2;
              label506:
              localObject = new LpReportInfo_pf00064(723, 1, i);
              LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
              if (!bool) {
                break label559;
              }
            }
            for (localObject = "panel_check";; localObject = "panel_cancel")
            {
              r("aio_sync_qzone", "operation_type", (String)localObject);
              break;
              i = 3;
              break label506;
            }
          }
          if (bool)
          {
            localObject = new QZoneClickReport.a();
            ((QZoneClickReport.a)localObject).toUin = Long.valueOf(this.aWf).longValue();
            ((QZoneClickReport.a)localObject).actionType = "459";
            ((QZoneClickReport.a)localObject).cMI = "3";
            QZoneClickReport.report(this.aWf, (QZoneClickReport.a)localObject, true);
          }
          else
          {
            localObject = new QZoneClickReport.a();
            ((QZoneClickReport.a)localObject).toUin = Long.valueOf(this.aWf).longValue();
            ((QZoneClickReport.a)localObject).actionType = "459";
            ((QZoneClickReport.a)localObject).cMI = "2";
            QZoneClickReport.report(this.aWf, (QZoneClickReport.a)localObject, true);
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h != null)
    {
      if ((PhotoListPanel.e.a)this.mRecyclerView.findViewHolderForAdapterPosition(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.bXr) == null) {
        return false;
      }
      if ((bXj == 1) && (SystemClock.elapsedRealtime() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.JD > h.bXq) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.bJ.get())) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
      float f1 = Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.lastX - paramMotionEvent.getX());
      float f2 = Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.lastY - paramMotionEvent.getY());
      if ((bXj == 0) && (paramMotionEvent.getAction() != 0) && (f1 < f2) && (f2 > this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.mTouchSlop)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e == null) {
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800A913", "0X800A913", PhotoUtils.d(this.mSessionInfo), 0, "", "", "", "");
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItemViewType(paramInt);
    if (this.isSingleMode)
    {
      yf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItem(paramInt).path);
      return;
    }
    ArrayList localArrayList = new ArrayList(this.C);
    Object localObject;
    if ((i == 0) || (i == 1))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItem(paramInt).path;
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!aqhq.fileExistsAndNotEmpty((String)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoListPanel", 2, "PhotoListPanel onItemClick,clickPath not exits, just return.");
        }
        QQToast.a(this.mActivity, 2131696981, 0).show();
        ceT();
        this.C.clear();
        this.qN.clear();
        updateButton();
        return;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("ALBUM_ID", "$RecentAlbumId");
      ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.mBusiType);
      ((Intent)localObject).putExtra("uin", this.mSessionInfo.aTl);
      ((Intent)localObject).putExtra("PhotoConst.MY_UIN", this.aWf);
      ((Intent)localObject).putExtra("uintype", this.mSessionInfo.cZ);
      ((Intent)localObject).putExtra("troop_uin", this.mSessionInfo.troopUin);
      ((Intent)localObject).putExtra("uinname", this.mSessionInfo.aTn);
      ((Intent)localObject).putExtra("entrance", this.mSessionInfo.entrance);
      ((Intent)localObject).putExtra("PhotoConst.is_troop_send_mixed_msg", this.bjO);
      ((Intent)localObject).putExtra("PhotoConst.SHOW_ALBUM", true);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.qO);
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_SELECTED_INDEX", this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getItem(paramInt).position);
      ((Intent)localObject).putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      ((Intent)localObject).putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.qN);
      ((Intent)localObject).putExtra("PhotoConst.ALL_MEDIA_PATHS", (Serializable)this.hT);
      ((Intent)localObject).putExtra("PhotoConst.editPathMap", zsh.e(this.gW));
      ((Intent)localObject).putExtra("KEY_IS_ANONYMOUS", jof.a().dd(this.mSessionInfo.aTl));
      if (this.O != null)
      {
        ((Intent)localObject).putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", SN());
        ((Intent)localObject).putExtra("session_info", this.mSessionInfo);
      }
      if (!(this.mActivity instanceof SplashActivity)) {
        break label1006;
      }
      ((Intent)localObject).putExtra("key_pic_to_edit_from", 1);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = wja.a((Intent)localObject, null);
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", this.mActivity.getPackageName());
      ((Intent)localObject).putExtra("key_activity_code", ChatActivityUtils.d(this.mActivity));
      if (this.mSessionInfo.cZ != 9501) {
        break label1070;
      }
      if (!(this.mActivity instanceof SplashActivity)) {
        break label1052;
      }
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localObject = wja.a((Intent)localObject, null);
      label599:
      ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 80);
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", this.mActivity.getPackageName());
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      label636:
      ((Intent)localObject).putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.Cv);
      ((Intent)localObject).putExtra("keep_selected_status_after_finish", true);
      ((Intent)localObject).putExtra("PhotoConst.IS_OVERLOAD", false);
      ((Intent)localObject).putExtra("PhotoConst.MAXUM_SELECTED_NUM", this.bXm);
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_report", true);
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_reportActionName", "0X8005E0A");
      ((Intent)localObject).putExtra("custom_photopreview_sendbtn_reportReverse2", "0");
      ((Intent)localObject).putExtra("custom_photopreview_editbtn_reportActionName", "0X8005E0B");
      ((Intent)localObject).putExtra("custom_photopreview_rawcheckbox_reportActionName", "0X8005E0C");
      ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", sxx.getViewRect(paramView.findViewById(2131369461)));
      ((Intent)localObject).putExtra("session_info", this.mSessionInfo);
      paramView = (HotChatManager)this.app.getManager(60);
      if ((this.O == null) || (!this.O.hasExtra("showFlashPic"))) {
        ((Intent)localObject).putExtra("showFlashPic", acei.a(this.mSessionInfo.cZ, paramView, this.mSessionInfo.troopUin));
      }
      ((Intent)localObject).putExtra("PhotoConst.IS_JUMPTO_TROOP_ALBUM", SM());
      ((Intent)localObject).setClass(this.mActivity, NewPhotoPreviewActivity.class);
      ((Intent)localObject).putExtra("enter_from", 1);
      ((Intent)localObject).addFlags(603979776);
      this.mActivity.startActivityForResult((Intent)localObject, 100004);
      acbs.go(this.xf);
      if ((this.mActivity instanceof SplashActivity)) {
        anot.a(null, "dc00898", "", "", "0X800A06C", "0X800A06C", 1, 0, this.C.size() + "", "", "", "");
      }
    }
    paramView = "";
    if (i == 0) {
      paramView = "0";
    }
    for (;;)
    {
      anot.a(null, "CliOper", "", "", "0X8005E09", "0X8005E09", 0, 0, paramView, "", "", "");
      return;
      label1006:
      if ((this.mActivity instanceof LiteActivity))
      {
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", LiteActivity.class.getName());
        break;
      }
      ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label1052:
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label599;
      label1070:
      if ((this.mSessionInfo.cZ == 6000) || (this.mSessionInfo.cZ == 6003))
      {
        ((Intent)localObject).putExtra(aqfx.REQUEST_CODE, 55);
        ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
        ((Intent)localObject).putExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", true);
        break label636;
      }
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      ((Intent)localObject).putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", this.mActivity.getPackageName());
      ((Intent)localObject).putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      ((Intent)localObject).putExtra("key_confess_topicid", this.mSessionInfo.topicId);
      break label636;
      if (i == 1) {
        paramView = "1";
      }
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h.cfe();
    }
  }
  
  public void resetStatus()
  {
    zC(true);
  }
  
  protected void s(ArrayList<String> paramArrayList, int paramInt)
  {
    alte.a().a(this.app, this.mSessionInfo, paramArrayList, paramInt);
  }
  
  public void setCustomOnClickListener(a parama)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$a = parama;
  }
  
  public void setImageCountChangedListener(c paramc)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c = paramc;
  }
  
  public void setImageOnly(boolean paramBoolean)
  {
    if ((this.ac == null) && (!paramBoolean))
    {
      this.O.removeExtra("showFlashPic");
      if (this.mFilter != null) {
        break label67;
      }
    }
    label67:
    do
    {
      return;
      Intent localIntent = this.O;
      if ((!paramBoolean) && (this.ac.booleanValue())) {}
      for (boolean bool = true;; bool = false)
      {
        localIntent.putExtra("showFlashPic", bool);
        break;
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = this.mFilter;
        this.mFilter = MediaFileFilter.getFilter(1);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter == null);
    this.mFilter = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter = null;
  }
  
  public void setImageSentListener(d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$d = paramd;
  }
  
  public void setLastRequestCode(int paramInt)
  {
    this.mLastRequestCode = paramInt;
  }
  
  public void setMixedMsgMode(boolean paramBoolean)
  {
    this.bjO = paramBoolean;
  }
  
  public void setOnSwipeUpAndDragListener(h paramh)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h = paramh;
  }
  
  public void setReceiptMode(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.O.putExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", paramBoolean);
    int i;
    if (this.bjK != paramBoolean)
    {
      i = 1;
      setImageOnly(paramBoolean);
      this.bjK = paramBoolean;
      if (!paramBoolean) {
        break label73;
      }
      this.bXm = Math.min(altg.Z(paramQQAppInterface), this.bXm);
      this.mRecyclerView.setOnTouchListener(null);
    }
    for (;;)
    {
      if (i != 0) {
        resetStatus();
      }
      return;
      i = 0;
      break;
      label73:
      this.mRecyclerView.setOnTouchListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h);
      this.bXm = this.O.getIntExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
      if (this.mSessionInfo.cZ == 9501) {
        this.bXm = 5;
      }
    }
  }
  
  public void setSelectLimitListener(f paramf)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$f = paramf;
  }
  
  public Intent t()
  {
    int j = 0;
    Object localObject = new ArrayList(this.C);
    Intent localIntent = new Intent();
    localIntent.putExtra("PhotoConst.SHOW_ALBUM", true);
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", (ArrayList)localObject);
    localIntent.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.qN);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("getSelectedPhotosIntent SELECTED_PATHS size=");
      if (localObject != null) {
        break label123;
      }
      i = 0;
      localObject = localStringBuilder.append(i).append(",SELECTED_INDEXS size=");
      if (this.qN != null) {
        break label132;
      }
    }
    label132:
    for (int i = j;; i = this.qN.size())
    {
      QLog.d("PhotoListPanel", 2, i);
      return localIntent;
      label123:
      i = ((ArrayList)localObject).size();
      break;
    }
  }
  
  public void updateButton()
  {
    Object localObject1 = getResources().getString(2131696942);
    if (SM()) {
      localObject1 = getResources().getString(2131696945);
    }
    if (this.C.size() > 0)
    {
      bool = true;
      Object localObject2 = localObject1;
      if (bool)
      {
        this.X.setContentDescription((String)localObject1 + this.C.size() + acfp.m(2131709582));
        localObject2 = (String)localObject1 + "(" + this.C.size() + ")";
      }
      this.X.setText((CharSequence)localObject2);
      this.X.setEnabled(bool);
      if (bool) {
        break label215;
      }
      this.ee.setEnabled(false);
      this.B.setEnabled(true);
      this.Ks.setEnabled(true);
      this.Kt.setEnabled(true);
      this.ed.setEnabled(true);
      cfa();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c.fX(wB());
      }
      return;
      bool = false;
      break;
      label215:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getFileType((String)this.C.peek()) != 1) {
        break label266;
      }
      this.ee.setEnabled(false);
      if (!this.bjJ) {
        this.ed.setEnabled(false);
      }
      cfa();
    }
    label266:
    this.B.setEnabled(true);
    this.Ks.setEnabled(true);
    this.Kt.setEnabled(true);
    localObject1 = this.ee;
    if ((this.C.size() == 1) && (!SM())) {}
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject1).setEnabled(bool);
      break;
    }
  }
  
  public int wA()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.C.size(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getFileType((String)this.C.get(i)) == 1) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public int wB()
  {
    int i = 0;
    if (this.C != null) {
      i = this.C.size();
    }
    return i;
  }
  
  protected int wC()
  {
    return (int)aopb.hm();
  }
  
  protected int wy()
  {
    return QzoneConfig.getInstance().getConfig("PhotoUpload", "C2CAioEnableSyncImageToQzone", 1);
  }
  
  public int wz()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.C.size(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.getFileType((String)this.C.get(i)) == 0) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  void ye(String paramString)
  {
    if (this.bjD) {}
    while (!this.bjE) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "cancelPresendPic, path = " + paramString);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("key_presend_path", paramString);
    localBundle.putInt("key_presend_cancel_type", 1018);
    RichmediaService.dk(localBundle);
  }
  
  void yf(String paramString)
  {
    Intent localIntent = new Intent();
    if (this.O != null) {
      localIntent.putExtras(this.O);
    }
    localIntent.putExtra("ALBUM_ID", "$RecentAlbumId");
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.mBusiType);
    localIntent.putExtra("uin", this.mSessionInfo.aTl);
    localIntent.putExtra("uintype", this.mSessionInfo.cZ);
    localIntent.putExtra("troop_uin", this.mSessionInfo.troopUin);
    localIntent.putExtra("uinname", this.mSessionInfo.aTn);
    HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
    if ((this.O == null) || (!this.O.hasExtra("showFlashPic"))) {
      localIntent.putExtra("showFlashPic", acei.a(this.mSessionInfo.cZ, localHotChatManager, this.mSessionInfo.troopUin));
    }
    if ((this.mActivity instanceof SplashActivity))
    {
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = wja.a(localIntent, null);
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("key_activity_code", ChatActivityUtils.d(this.mActivity));
      if (this.mSessionInfo.cZ != 9501) {
        break label461;
      }
      if (!(this.mActivity instanceof SplashActivity)) {
        break label444;
      }
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SplashActivity.class.getName());
      localIntent = wja.a(localIntent, null);
      label265:
      localIntent.putExtra(aqfx.REQUEST_CODE, 80);
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
    }
    for (;;)
    {
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_CLASS_NAME", SendVideoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_VIDEO_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.Cv);
      localIntent.putExtra("PhotoConst.IS_OVERLOAD", false);
      localIntent.addFlags(603979776);
      localIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
      localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", this.mBusiType);
      localIntent.putExtra("PhotoConst.ALLOW_LOCK", false);
      localIntent.setClass(this.mActivity, NewPhotoPreviewActivity.class);
      localIntent.putExtra("enter_from", 1);
      localIntent.addFlags(603979776);
      this.mActivity.startActivityForResult(localIntent, 2);
      return;
      localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break;
      label444:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
      break label265;
      label461:
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
      localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
      localIntent.putExtra("key_confess_topicid", this.mSessionInfo.topicId);
    }
  }
  
  public HashMap<String, String> z()
  {
    return zsh.d(this.gW);
  }
  
  protected boolean z(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
    } while (!aqhq.fileExistsAndNotEmpty((String)paramArrayList.next()));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zC(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.C.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.cfc();
      }
      this.C.clear();
      this.qN.clear();
      if (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$c.bF(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e.notifyDataSetChanged();
      this.B.setChecked(false);
      this.gW.clear();
      Intent localIntent = this.mActivity.getIntent();
      if (localIntent != null)
      {
        localIntent.removeExtra("PhotoConst.SELECTED_PATHS");
        localIntent.removeExtra("PhotoConst.SELECTED_INDEXS");
        localIntent.removeExtra("PhotoConst.editPathMap");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "resetStatus selectSize:" + this.C.size() + ", clear:" + paramBoolean);
    }
    updateButton();
    setMixedMsgMode(false);
  }
  
  class QueryMediaTask
    implements Runnable
  {
    QueryMediaTask() {}
    
    private void gq(List<LocalMediaInfo> paramList)
    {
      int j = paramList.size();
      PhotoListPanel.this.qO = new ArrayList(paramList.size());
      PhotoListPanel.this.hT = new HashMap(paramList.size());
      PhotoListPanel.bXi = j;
      int i = 0;
      for (;;)
      {
        if (i < j) {}
        for (;;)
        {
          int k;
          try
          {
            LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)paramList.get(i);
            if (localLocalMediaInfo.path == null) {
              break label431;
            }
            localLocalMediaInfo.mMediaType = -1;
            k = aqfy.getMediaType(localLocalMediaInfo);
            if (k != 0) {
              break label357;
            }
            localLocalMediaInfo.mMediaType = 0;
            PhotoListPanel.this.hT.put(localLocalMediaInfo.path, localLocalMediaInfo);
            if (PhotoListPanel.this.qO != null) {
              PhotoListPanel.this.qO.add(localLocalMediaInfo.path);
            }
            localLocalMediaInfo.position = Integer.valueOf(i);
            if ((localLocalMediaInfo.orientation != 90) && (localLocalMediaInfo.orientation != 270)) {
              break;
            }
            localLocalMediaInfo.thumbWidth = (PhotoListPanel.this.bXl / 2);
            localLocalMediaInfo.thumbHeight = (PhotoListPanel.this.bXl / 2);
            if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0)) {
              break label431;
            }
            FlowThumbDecoder.determineThumbSize(localLocalMediaInfo, localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight);
            k = localLocalMediaInfo.thumbWidth;
            localLocalMediaInfo.thumbWidth = localLocalMediaInfo.thumbHeight;
            localLocalMediaInfo.thumbHeight = k;
          }
          catch (Exception localException)
          {
            if ((QLog.isColorLevel()) && (PhotoListPanel.this.qO != null)) {
              QLog.d("PhotoListPanel", 2, localException + "get album medias size : " + paramList.size() + "mPhotos size" + PhotoListPanel.this.qO.size());
            }
          }
          zsh.a(paramList, PhotoListPanel.this.qO, PhotoListPanel.this.gW);
          return;
          label357:
          if (k == 1) {
            localException.mMediaType = 1;
          }
        }
        localException.thumbWidth = (PhotoListPanel.this.bXl / 2);
        localException.thumbHeight = (PhotoListPanel.this.bXl / 2);
        if ((localException.mediaWidth > 0) && (localException.mediaHeight > 0)) {
          FlowThumbDecoder.determineThumbSize(localException, localException.mediaWidth, localException.mediaHeight);
        }
        label431:
        i += 1;
      }
    }
    
    public void run()
    {
      long l1 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "QueryMediaTask start" + l1 + "to qurey time=" + (PhotoListPanel.this.JB - l1));
      }
      Object localObject1 = xun.a(PhotoListPanel.this.app);
      int i = ((xun)localObject1).bXf;
      int j = ((xun)localObject1).bXg;
      localObject1 = ((xun)localObject1).bs;
      Object localObject3;
      if ((localObject1 != null) && (((Set)localObject1).size() > 0))
      {
        localObject2 = new ArrayList(((Set)localObject1).size());
        localObject3 = ((Set)localObject1).iterator();
        for (;;)
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (String)((Iterator)localObject3).next();
          ((ArrayList)localObject2).add(acbn.SDCARD_ROOT + (String)localObject1);
        }
      }
      localObject1 = null;
      Object localObject2 = aqfy.getAlbumMedias(PhotoListPanel.this.mActivity, "$RecentAlbumId", null, 100, PhotoListPanel.this.mFilter, i, j, true, (ArrayList)localObject1, false, -1L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder("get album medias cost: ").append(l2 - l1);
        ((StringBuilder)localObject3).append(" limitSize:").append(i).append(" limitWidth:").append(j).append(" blackLists:").append(localObject1);
        QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject3).toString());
      }
      if ((localObject2 == null) || (((List)localObject2).size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "QueryMediaTask getAlbumMedias is null");
        }
        PhotoListPanel.bXi = 0;
        PhotoListPanel.this.mUiHandler.post(new PhotoListPanel.QueryMediaTask.1(this));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "get album medias size : " + ((List)localObject2).size());
      }
      gq((List)localObject2);
      PhotoListPanel.this.mUiHandler.post(new PhotoListPanel.QueryMediaTask.2(this, (List)localObject2));
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "QueryMediaTask,mediaList.size :" + ((List)localObject2).size());
      }
      PhotoListPanel.this.a.gp((List)localObject2);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(PhotoListPanel paramPhotoListPanel);
    
    public abstract boolean b(PhotoListPanel paramPhotoListPanel);
  }
  
  class b
    implements View.OnClickListener
  {
    CheckBox mCheckBox;
    int mPosition;
    
    public b() {}
    
    public void onClick(View paramView)
    {
      if (PhotoListPanel.this.a == null) {}
      LocalMediaInfo localLocalMediaInfo;
      int j;
      int i;
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        Object localObject;
        long l1;
        if (PhotoListPanel.this.a.getItemCount() > 0)
        {
          localLocalMediaInfo = PhotoListPanel.this.a.getItem(this.mPosition);
          j = PhotoListPanel.this.a.getItemViewType(this.mPosition);
          if ((!localLocalMediaInfo.mChecked) && (aqfy.a(PhotoListPanel.this.C, PhotoListPanel.this.mActivity, PhotoListPanel.bXh)))
          {
            this.mCheckBox.setChecked(localLocalMediaInfo.mChecked);
          }
          else
          {
            if ((PhotoListPanel.this.mSessionInfo.cZ != 9501) || (localLocalMediaInfo.mChecked)) {
              break label316;
            }
            localObject = PhotoListPanel.this.C.iterator();
            String str;
            for (i = 0; ((Iterator)localObject).hasNext(); i = (int)(i + aqhq.getFileSizes(str))) {
              str = (String)((Iterator)localObject).next();
            }
            if (i + aqhq.getFileSizes(localLocalMediaInfo.path) <= 52428800L) {
              break label316;
            }
            localObject = (syw)PhotoListPanel.this.app.getBusinessHandler(51);
            if ((localObject == null) || (!((syw)localObject).Nz())) {
              break label316;
            }
            l1 = 0L;
          }
        }
        try
        {
          long l2 = Long.parseLong(PhotoListPanel.this.mSessionInfo.aTl);
          l1 = l2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!((syw)localObject).i(l1, 1)) {
          break label316;
        }
        QQToast.a(PhotoListPanel.this.mActivity, "选择图片总大小不能超过50M", 0).show(PhotoListPanel.this.getResources().getDimensionPixelSize(2131299627));
        this.mCheckBox.setChecked(localLocalMediaInfo.mChecked);
      }
      label316:
      boolean bool;
      if (!localLocalMediaInfo.mChecked)
      {
        bool = true;
        label327:
        localLocalMediaInfo.mChecked = bool;
        this.mCheckBox.setChecked(localLocalMediaInfo.mChecked);
        if (!localLocalMediaInfo.mChecked) {
          break label569;
        }
        if (j == 0) {
          PhotoListPanel.this.cE(localLocalMediaInfo.path, PhotoListPanel.this.mSessionInfo.entrance);
        }
        PhotoListPanel.this.C.add(localLocalMediaInfo.path);
        PhotoListPanel.this.qN.add(localLocalMediaInfo.position);
        if (PhotoListPanel.this.b != null) {
          PhotoListPanel.this.b.bF(PhotoListPanel.this.t());
        }
        i = PhotoListPanel.this.C.size();
        ((NumberCheckBox)this.mCheckBox).setCheckedNumber(i);
        anot.a(null, "CliOper", "", "", "0X8005E08", "0X8005E08", 0, 0, "", "", "", "");
        if (PhotoListPanel.a(PhotoListPanel.this) != null) {
          PhotoListPanel.a(PhotoListPanel.this).a(PhotoListPanel.this.getContext(), localLocalMediaInfo.path, PhotoListPanel.this.B.isChecked(), PhotoListPanel.this.hT, null, true);
        }
      }
      for (;;)
      {
        PhotoListPanel.this.ceV();
        PhotoListPanel.this.updateButton();
        PhotoListPanel.this.cfb();
        break;
        bool = false;
        break label327;
        label569:
        if (j == 0) {
          PhotoListPanel.this.ye(localLocalMediaInfo.path);
        }
        PhotoListPanel.this.C.remove(localLocalMediaInfo.path);
        PhotoListPanel.this.qN.remove(localLocalMediaInfo.position);
        if (PhotoListPanel.this.b != null) {
          PhotoListPanel.this.b.bF(PhotoListPanel.this.t());
        }
      }
    }
    
    public void setCheckBox(CheckBox paramCheckBox)
    {
      this.mCheckBox = paramCheckBox;
    }
    
    public void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
  }
  
  public static abstract interface c
  {
    public abstract void bF(Intent paramIntent);
    
    public abstract boolean fX(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bJh();
  }
  
  public static class e
    extends RecyclerView.Adapter<a>
  {
    public WeakReference<PhotoListPanel> ag;
    boolean bjU;
    public ArrayList<LocalMediaInfo> qQ = new ArrayList();
    
    public e(PhotoListPanel paramPhotoListPanel)
    {
      this.ag = new WeakReference(paramPhotoListPanel);
      this.bjU = ThemeUtil.isNowThemeIsNight(((PhotoListPanel)this.ag.get()).app, false, null);
    }
    
    public a a(ViewGroup paramViewGroup, int paramInt)
    {
      return new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561542, paramViewGroup, false));
    }
    
    public void a(a parama, int paramInt)
    {
      parama.itemView.setOnClickListener(new xuv(this, paramInt));
      parama.a.setPosition(paramInt);
      parama.a.setCheckBox(parama.mCheckBox);
      Object localObject1 = getItem(paramInt);
      Object localObject2 = parama.av;
      Object localObject4 = new afei(((PhotoListPanel)this.ag.get()).bXo, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
      afei localafei = new afei(((PhotoListPanel)this.ag.get()).bXp, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
      Object localObject3 = aqfy.generateAlbumThumbURL((LocalMediaInfo)localObject1, "FLOW_THUMB");
      Object localObject5 = parama.mURLDrawable;
      int i;
      if ((localObject3 != null) && ((localObject5 == null) || (!((URLDrawable)localObject5).getURL().equals(localObject3))))
      {
        localObject5 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject5).mRequestWidth = ((LocalMediaInfo)localObject1).thumbWidth;
        ((URLDrawable.URLDrawableOptions)localObject5).mRequestHeight = ((LocalMediaInfo)localObject1).thumbHeight;
        if ((((LocalMediaInfo)localObject1).thumbWidth > 0) && (((LocalMediaInfo)localObject1).thumbHeight > 0))
        {
          ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((Drawable)localObject4);
          ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = localafei;
          localObject4 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject5);
          if (QLog.isColorLevel()) {
            QLog.d("PhotoListPanel", 2, "PhotoListPanel,adapter getView(), url :" + ((URL)localObject3).toString());
          }
          ((URLDrawable)localObject4).setTag(localObject1);
          ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
          parama.mURLDrawable = ((URLDrawable)localObject4);
        }
      }
      else
      {
        localObject2 = parama.mCheckBox;
        localObject3 = parama.tR;
        ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
        if (!((LocalMediaInfo)localObject1).mChecked) {
          break label621;
        }
        i = ((PhotoListPanel)this.ag.get()).C.indexOf(((LocalMediaInfo)localObject1).path);
        if (i >= 0) {
          ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
        }
        ((ImageView)localObject3).setVisibility(0);
        label338:
        if (this.bjU) {
          ((NumberCheckBox)localObject2).setTextColor(-1509949441);
        }
        localObject3 = parama.tQ;
        i = getItemViewType(paramInt);
        if (i != 0) {
          break label636;
        }
        ((ImageView)localObject3).setVisibility(4);
        parama.mVideoDuration.setVisibility(4);
        label383:
        if ((!aqft.rj(((PhotoListPanel)this.ag.get()).mSessionInfo.aTl)) || (paramInt != 0)) {
          break label703;
        }
        localObject3 = (acbs)((PhotoListPanel)this.ag.get()).app.getBusinessHandler(53);
        if (((acbs)localObject3).io(1))
        {
          ((acbs)localObject3).cGZ();
          ((PhotoListPanel)this.ag.get()).xg = parama.xf;
          ((PhotoListPanel)this.ag.get()).bjM = true;
        }
        if (!((PhotoListPanel)this.ag.get()).bjM) {
          break label692;
        }
        parama.xf.setVisibility(0);
        acbs.k(((PhotoListPanel)this.ag.get()).mActivity, parama.xf);
      }
      for (;;)
      {
        if (AppSetting.enableTalkBack)
        {
          localObject3 = PhotoUtils.createContentDescription(i, (LocalMediaInfo)localObject1, paramInt);
          parama.itemView.setContentDescription((CharSequence)localObject3);
          localObject1 = PhotoUtils.createContentDescriptionWithCheckBox(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
          parama.mCheckBox.setContentDescription((CharSequence)localObject1);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
        return;
        ((URLDrawable.URLDrawableOptions)localObject5).mLoadingDrawable = ((PhotoListPanel)this.ag.get()).c;
        ((URLDrawable.URLDrawableOptions)localObject5).mFailedDrawable = ((PhotoListPanel)this.ag.get()).b;
        break;
        label621:
        ((NumberCheckBox)localObject2).setChecked(false);
        ((ImageView)localObject3).setVisibility(4);
        break label338;
        label636:
        if (i == 1)
        {
          ((ImageView)localObject3).setVisibility(0);
          localObject3 = parama.mVideoDuration;
          ((TextView)localObject3).setVisibility(0);
          ((TextView)localObject3).setText(NewPhotoListActivity.formatTimeToString(((LocalMediaInfo)localObject1).mDuration));
          break label383;
        }
        ((ImageView)localObject3).setVisibility(4);
        parama.mVideoDuration.setVisibility(4);
        break label383;
        label692:
        parama.xf.setVisibility(4);
        continue;
        label703:
        parama.xf.setVisibility(4);
      }
    }
    
    public LocalMediaInfo c(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Iterator localIterator = this.qQ.iterator();
      LocalMediaInfo localLocalMediaInfo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localLocalMediaInfo = (LocalMediaInfo)localIterator.next();
      } while (!localLocalMediaInfo.path.equals(paramString));
      for (paramString = localLocalMediaInfo;; paramString = null) {
        return paramString;
      }
    }
    
    public void cfc()
    {
      Iterator localIterator = this.qQ.iterator();
      while (localIterator.hasNext()) {
        ((LocalMediaInfo)localIterator.next()).mChecked = false;
      }
    }
    
    public int getFileType(String paramString)
    {
      paramString = c(paramString);
      if (paramString == null) {
        return -1;
      }
      return aqfy.getMediaType(paramString);
    }
    
    public LocalMediaInfo getItem(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.qQ != null)
      {
        localObject1 = localObject2;
        if (this.qQ.size() > paramInt) {
          localObject1 = (LocalMediaInfo)this.qQ.get(paramInt);
        }
      }
      return localObject1;
    }
    
    public int getItemCount()
    {
      return this.qQ.size();
    }
    
    public int getItemViewType(int paramInt)
    {
      return aqfy.getMediaType(getItem(paramInt));
    }
    
    void gp(List<LocalMediaInfo> paramList)
    {
      if (Looper.myLooper() == Looper.getMainLooper())
      {
        setPhotoList(paramList);
        return;
      }
      ((PhotoListPanel)this.ag.get()).mUiHandler.post(new PhotoListPanel.PhotoPanelAdapter.2(this, paramList));
    }
    
    public void setPhotoList(List<LocalMediaInfo> paramList)
    {
      this.qQ.clear();
      if ((paramList == null) || (paramList.size() == 0))
      {
        PhotoListPanel.bXi = 0;
        ((PhotoListPanel)this.ag.get()).xe.setVisibility(0);
        ((PhotoListPanel)this.ag.get()).mRecyclerView.setVisibility(8);
        return;
      }
      ((PhotoListPanel)this.ag.get()).xe.setVisibility(8);
      ((PhotoListPanel)this.ag.get()).mRecyclerView.setVisibility(0);
      this.qQ.addAll(paramList);
      notifyDataSetChanged();
      ((PhotoListPanel)this.ag.get()).updateButton();
      if (!((PhotoListPanel)this.ag.get()).C.isEmpty())
      {
        String.format(((PhotoListPanel)this.ag.get()).getResources().getString(2131718873), new Object[] { Integer.valueOf(((PhotoListPanel)this.ag.get()).C.size()) });
        return;
      }
      ((PhotoListPanel)this.ag.get()).getResources().getString(2131718868);
    }
    
    public class a
      extends RecyclerView.ViewHolder
    {
      PhotoListPanel.b a;
      public SquareRelativeLayout a;
      public URLImageView av;
      public FrameLayout bf;
      public NumberCheckBox mCheckBox;
      public URLDrawable mURLDrawable;
      public TextView mVideoDuration;
      public ImageView tQ;
      public ImageView tR;
      public View xf;
      
      public a(View paramView)
      {
        super();
        this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout = ((SquareRelativeLayout)paramView.findViewById(2131367341));
        if (PhotoListPanel.bXj == 0) {
          this.jdField_a_of_type_ComTencentMobileqqHiboomSquareRelativeLayout.setCloseSquare(true);
        }
        this.av = ((URLImageView)paramView.findViewById(2131369461));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$b = ((PhotoListPanel)PhotoListPanel.e.this.ag.get()).a();
        this.mCheckBox = ((NumberCheckBox)paramView.findViewById(2131369420));
        this.xf = paramView.findViewById(2131373133);
        this.bf = ((FrameLayout)paramView.findViewById(2131369421));
        if (this.bf != null) {
          this.bf.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$b);
        }
        if ((((PhotoListPanel)PhotoListPanel.e.this.ag.get()).isSingleMode) && (this.bf != null)) {
          this.bf.setVisibility(8);
        }
        this.tQ = ((ImageView)paramView.findViewById(2131369544));
        this.tR = ((ImageView)paramView.findViewById(2131369462));
        this.mVideoDuration = ((TextView)paramView.findViewById(2131369543));
      }
    }
  }
  
  public static abstract interface f {}
  
  public static abstract interface g
  {
    public abstract void aY(String paramString, boolean paramBoolean);
  }
  
  public static class h
    implements View.OnTouchListener
  {
    private static int SWIPE_THRESHOLD = 60;
    private static int bXq = 300;
    long JD;
    PhotoListPanel.g jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$g;
    c jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c;
    c b;
    AtomicBoolean bI = new AtomicBoolean(false);
    AtomicBoolean bJ = new AtomicBoolean(false);
    int bXr;
    boolean bjV;
    c c;
    PhotoListPanel d;
    int[] iB;
    float lastX;
    float lastY;
    int mActivePointerId;
    float mDensity;
    int mTitleHeight;
    int mTouchSlop;
    VelocityTracker mVelocityTracker;
    float qE = 0.7F;
    float qF;
    float startX;
    public float startY;
    
    public h(Context paramContext, ViewGroup paramViewGroup, int[] paramArrayOfInt, int paramInt, PhotoListPanel.g paramg, PhotoListPanel paramPhotoListPanel)
    {
      this.iB = paramArrayOfInt;
      this.mTitleHeight = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$g = paramg;
      this.d = paramPhotoListPanel;
      this.mDensity = paramContext.getResources().getDisplayMetrics().density;
      this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      akxe.a("PhotoListPanel", "detectGesture", "SwipeUpAndDragListener.mTouchSlop = " + this.mTouchSlop);
      SWIPE_THRESHOLD = (int)(30.0F * this.mDensity);
      switch (PhotoListPanel.bXj)
      {
      }
      for (this.b = new b(paramContext, paramViewGroup);; this.b = new c(paramContext, paramViewGroup))
      {
        this.c = new a(paramContext, paramViewGroup);
        return;
      }
    }
    
    private boolean U(MotionEvent paramMotionEvent)
    {
      this.startX = paramMotionEvent.getX();
      this.startY = paramMotionEvent.getY();
      akxe.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + this.startX + ",y = " + this.startY);
      if (!this.d.bjC) {
        T(paramMotionEvent);
      }
      return false;
    }
    
    private boolean V(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      akxe.a("PhotoListPanel", "onTouch", " ACTION_MOVE,x = " + f1 + ",y = " + f2 + ",mGestureHandler = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c);
      if ((this.lastX == f1) && (this.lastY == f2)) {
        return false;
      }
      float f3 = this.startX;
      float f4 = this.startY;
      if (PhotoListPanel.bXj == 1)
      {
        if ((SystemClock.elapsedRealtime() - this.JD < bXq) && ((Math.abs(this.lastX - paramMotionEvent.getX()) > this.mTouchSlop) || (Math.abs(this.lastY - paramMotionEvent.getY()) > this.mTouchSlop))) {
          this.bJ.set(false);
        }
        if (!this.bJ.get()) {
          return false;
        }
      }
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      PhotoListPanel.e.a locala = (PhotoListPanel.e.a)this.d.mRecyclerView.findViewHolderForAdapterPosition(this.bXr);
      if (locala == null) {
        return false;
      }
      if (!this.bjV)
      {
        if (PhotoListPanel.bXj == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c = a(paramMotionEvent, f1 - f3, f2 - f4);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c != null) {
            return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c.a(locala, this.bXr);
          }
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c.Y(paramMotionEvent);
      }
      return false;
    }
    
    private boolean W(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      akxe.a("PhotoListPanel", "onTouch", " ACTION_UP,x = " + f1 + ",y = " + f2);
      if (PhotoListPanel.bXj == 1) {
        this.bJ.set(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c.Z(paramMotionEvent);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c = null;
        if (this.mVelocityTracker != null)
        {
          this.mVelocityTracker.recycle();
          this.mVelocityTracker = null;
        }
        return bool;
      }
      long l = SystemClock.elapsedRealtime() - this.JD;
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      if (((this.d.mScrollState == 1) || (this.d.mScrollState == 0)) && (Math.abs(f2 - this.startY) > Math.abs(f1 - this.startX)) && ((l > 200L) || (Math.abs(f2 - this.startY) > this.mTouchSlop) || (Math.abs(f1 - this.startX) > this.mTouchSlop)))
      {
        akxe.a("PhotoListPanel", "onTouch", " ACTION_UP,eat up event.dx = " + Math.abs(f1 - this.startX) + ",dy = " + Math.abs(f2 - this.startY) + ",duration = " + l);
        return true;
      }
      return false;
    }
    
    private boolean X(MotionEvent paramMotionEvent)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      akxe.a("PhotoListPanel", "onTouch", " ACTION_CANCEL,x = " + f1 + ",y = " + f2);
      if (PhotoListPanel.bXj == 1) {
        this.bJ.set(false);
      }
      ThreadManagerV2.getUIHandlerV2().post(new PhotoListPanel.SwipeUpAndDragListener.1(this));
      return false;
    }
    
    public void T(MotionEvent paramMotionEvent)
    {
      boolean bool = true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.JD = SystemClock.elapsedRealtime();
      View localView = this.d.mRecyclerView.findChildViewUnder(f1, f2);
      this.bXr = this.d.mRecyclerView.getChildAdapterPosition(localView);
      if (this.mVelocityTracker == null)
      {
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        akxe.a("PhotoListPanel", "onTouch", " touchFirstActtion,mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c = null;
        this.bjV = false;
        this.bI.set(false);
        ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.2(this), 100L);
        if (PhotoListPanel.bXj == 1)
        {
          ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.3(this), bXq);
          paramMotionEvent = this.bJ;
          if (this.d.mScrollState != 0) {
            break label218;
          }
        }
      }
      for (;;)
      {
        paramMotionEvent.set(bool);
        return;
        this.mVelocityTracker.clear();
        break;
        label218:
        bool = false;
      }
    }
    
    c a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
    {
      boolean bool5 = false;
      boolean bool4 = false;
      boolean bool1;
      boolean bool2;
      if (this.bI.get())
      {
        this.bjV = true;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        f = this.mVelocityTracker.getYVelocity(i);
        if (-f > 1500.0F)
        {
          bool1 = true;
          if (paramFloat2 >= 0.0F) {
            break label396;
          }
          bool2 = true;
          label82:
          if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
            break label402;
          }
        }
        label396:
        label402:
        for (bool3 = true;; bool3 = false)
        {
          if ((this.d.mScrollState == 1) || (this.d.mScrollState == 0)) {
            bool4 = true;
          }
          akxe.a("PhotoListPanel", "detectGesture", "Xvelocity=" + this.mVelocityTracker.getXVelocity(i) + "Yvelocity=" + f + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.mVelocityTracker.getXVelocity(i) / f))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4 + ",mGestureHandler = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c);
          akxe.a("PhotoListPanel", "detectGesture", "mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c != null) || (!bool2) || (!bool3) || (!bool4)) {
            break label797;
          }
          akxe.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
          return this.c;
          bool1 = false;
          break;
          bool2 = false;
          break label82;
        }
      }
      int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
      this.mVelocityTracker.addMovement(paramMotionEvent);
      this.mVelocityTracker.computeCurrentVelocity(1000);
      float f = this.mVelocityTracker.getYVelocity(i);
      if (-f > 3000.0F)
      {
        bool1 = true;
        if (paramFloat2 >= 0.0F) {
          break label785;
        }
        bool2 = true;
        label469:
        if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
          break label791;
        }
      }
      label785:
      label791:
      for (boolean bool3 = true;; bool3 = false)
      {
        if (this.d.mScrollState != 1)
        {
          bool4 = bool5;
          if (this.d.mScrollState != 0) {}
        }
        else
        {
          bool4 = true;
        }
        akxe.a("PhotoListPanel", "detectGesture", "2 Xvelocity=" + this.mVelocityTracker.getXVelocity(i) + "Yvelocity=" + f + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.mVelocityTracker.getXVelocity(i) / f))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4);
        akxe.a("PhotoListPanel", "detectGesture", "2 mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c != null) || (!bool2) || (!bool3) || (!bool4) || (!bool1)) {
          break label797;
        }
        this.bjV = true;
        akxe.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
        return this.b;
        bool1 = false;
        break;
        bool2 = false;
        break label469;
      }
      label797:
      return null;
    }
    
    float b(int paramInt1, int paramInt2, int paramInt3)
    {
      LocalMediaInfo localLocalMediaInfo = this.d.a.getItem(paramInt1);
      int i = this.d.a.getItemViewType(paramInt1);
      float f;
      if (i == 1) {
        f = 160.0F * this.mDensity / Math.max(paramInt2, paramInt3);
      }
      for (;;)
      {
        akxe.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight);
        return f;
        if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100)) {
          f = 135.0F * this.mDensity / Math.max(paramInt2, paramInt3);
        } else {
          f = Math.max(localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight) * this.mDensity / Math.max(paramInt2, paramInt3);
        }
      }
    }
    
    void cfd()
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$h$c = null;
      }
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
    }
    
    void cfe()
    {
      if ((this.c != null) && (this.c.SQ())) {
        this.c.clear();
      }
      while ((this.b == null) || (!this.b.SQ())) {
        return;
      }
      this.b.clear();
    }
    
    float f(int paramInt1, int paramInt2)
    {
      LocalMediaInfo localLocalMediaInfo = this.d.a.getItem(paramInt1);
      int i = this.d.a.getItemViewType(paramInt1);
      float f;
      if (i == 1) {
        f = 1168.0F / (paramInt2 * this.mDensity);
      }
      for (;;)
      {
        akxe.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight + ",sideLength = " + paramInt2);
        return f;
        f = localLocalMediaInfo.mediaHeight * 1.0F / localLocalMediaInfo.mediaWidth;
        if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100))
        {
          if (localLocalMediaInfo.mediaHeight > localLocalMediaInfo.mediaWidth) {
            f = 1168.0F / (f * paramInt2 * this.mDensity);
          } else {
            f = f * 1168.0F / (paramInt2 * this.mDensity);
          }
        }
        else if (localLocalMediaInfo.mediaHeight > localLocalMediaInfo.mediaWidth) {
          f = paramInt2 * 2336.0F / (f * this.mDensity);
        } else {
          f = f * 2336.0F / (paramInt2 * this.mDensity);
        }
      }
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = paramMotionEvent.getAction();
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      akxe.a("PhotoListPanel", "onTouch", "x = " + f1 + ",y = " + f2 + ",event = " + paramMotionEvent + ", mPanel.mDisableGuestrueSend = " + this.d.bjC);
      if (this.d.bjC) {
        return true;
      }
      switch (i)
      {
      default: 
        return false;
      case 0: 
        return U(paramMotionEvent);
      case 2: 
        return V(paramMotionEvent);
      case 1: 
        return W(paramMotionEvent);
      }
      return X(paramMotionEvent);
    }
    
    public class a
      extends PhotoListPanel.h.c
    {
      int bXs;
      int[] iC;
      public TextView tv;
      RelativeLayout.LayoutParams w;
      RelativeLayout.LayoutParams x;
      
      public a(Context paramContext, ViewGroup paramViewGroup)
      {
        super(paramContext, paramViewGroup);
        this.hT = new RelativeLayout(paramContext);
        this.w = new RelativeLayout.LayoutParams(-2, -2);
        this.tv = new TextView(paramContext);
        this.tv.setText(acfp.m(2131709610));
        if (Build.VERSION.SDK_INT >= 21)
        {
          this.tv.setElevation(10.0F);
          this.hT.setElevation(50.0F);
        }
        this.tv.setTextSize(10.0F);
        this.tv.setTextColor(-1);
        this.tv.setBackgroundResource(2130838305);
        this.tv.setTypeface(Typeface.defaultFromStyle(1));
        this.x = new RelativeLayout.LayoutParams(-2, -2);
        this.x.topMargin = ((int)(6.0F * PhotoListPanel.h.this.mDensity));
        this.x.addRule(14);
        this.iC = new int[2];
      }
      
      boolean Y(MotionEvent paramMotionEvent)
      {
        paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        float f2 = PhotoListPanel.h.this.lastY;
        paramMotionEvent = (RelativeLayout.LayoutParams)this.hT.getLayoutParams();
        paramMotionEvent.topMargin = ((int)(f1 - f2 + paramMotionEvent.topMargin));
        this.bXs = (this.iD[1] + PhotoListPanel.h.this.mTitleHeight + paramMotionEvent.topMargin);
        this.hT.setLayoutParams(paramMotionEvent);
        akxe.a("PhotoListPanel", "DragHandler", "drag hanldeMove, contentParent = " + this.hT.getParent());
        PhotoListPanel.h.this.lastY = f1;
        if (-(int)(f1 - PhotoListPanel.h.this.startY) > (int)PhotoListPanel.h.this.qF) {
          this.tv.setVisibility(0);
        }
        for (;;)
        {
          this.hT.invalidate();
          return true;
          this.tv.setVisibility(4);
        }
      }
      
      boolean Z(MotionEvent paramMotionEvent)
      {
        akxe.a("PhotoListPanel", "handleUp", "handler = " + this);
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if (this.tv.getVisibility() == 4)
        {
          if ((SystemClock.elapsedRealtime() - PhotoListPanel.h.this.JD < 200L) && (Math.abs(f2 - PhotoListPanel.h.this.startY) < PhotoListPanel.h.this.mTouchSlop) && (Math.abs(f1 - PhotoListPanel.h.this.startX) < PhotoListPanel.h.this.mTouchSlop))
          {
            clear();
            return false;
          }
          this.hT.getLocationInWindow(this.iC);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getLocationInWindow(this.iE);
          paramMotionEvent = new TranslateAnimation(0.0F, 0.0F, 0.0F, (int)(2.0F * PhotoListPanel.h.this.mDensity + 0.5F) + this.iE[1] - this.iC[1]);
          paramMotionEvent.setFillAfter(true);
          paramMotionEvent.setDuration(200L);
          PhotoListPanel.h.this.d.bjC = true;
          this.hT.startAnimation(paramMotionEvent);
          paramMotionEvent.setAnimationListener(this.t);
        }
        while (this.tv.getVisibility() != 0) {
          return true;
        }
        akxe.a("PhotoListPanel", "DragHandler", "@#handleUp, createFlyAnimation ");
        paramMotionEvent = i();
        PhotoListPanel.h.this.d.bjC = true;
        akxe.a("PhotoListPanel", "DragHandler", "@#handleUp, startFlyAnimation ");
        this.hT.startAnimation(paramMotionEvent);
        this.tv.setVisibility(4);
        int i = PhotoListPanel.h.this.d.a.getItemViewType(this.bXt);
        Object localObject = new ArrayList();
        ((ArrayList)localObject).add(PhotoListPanel.h.this.d.a.getItem(this.bXt).path);
        anot.a(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.bXt + 1, 0, "1", "", "", "");
        anot.a(null, "dc00898", "", "", "0X800A914", "0X800A914", PhotoUtils.d(PhotoListPanel.h.this.d.mSessionInfo), 0, "" + (this.bXt + 1), "", "", "");
        boolean bool;
        if (PhotoListPanel.h.this.a != null)
        {
          localObject = PhotoListPanel.h.this.a;
          String str = PhotoListPanel.h.this.d.a.getItem(this.bXt).path;
          if (PhotoListPanel.h.this.d.Cv == 2)
          {
            bool = true;
            label503:
            ((PhotoListPanel.g)localObject).aY(str, bool);
          }
        }
        for (;;)
        {
          paramMotionEvent.setAnimationListener(new xuw(this, f2));
          break;
          bool = false;
          break label503;
          PhotoListPanel.h.this.d.a(this.bXt, (ArrayList)localObject, false, true, "0X8005E0D", "0", i + "", false);
        }
      }
      
      boolean a(PhotoListPanel.e.a parama, int paramInt)
      {
        super.a(parama, paramInt);
        paramInt = parama.itemView.getWidth() - (int)(PhotoListPanel.h.this.mDensity * 2.0F + 0.5F);
        int i = parama.itemView.getHeight() - (int)(PhotoListPanel.h.this.mDensity * 2.0F + 0.5F) * 2;
        this.w.leftMargin = (this.iE[0] + (int)(PhotoListPanel.h.this.mDensity * 2.0F + 0.5F));
        this.w.topMargin = (this.iE[1] - this.iD[1] - PhotoListPanel.h.this.mTitleHeight + (int)(PhotoListPanel.h.this.mDensity * 2.0F + 0.5F));
        PhotoListPanel.h.this.qF = (i * 3 / 5);
        ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.getParent();
        if (localViewGroup != null)
        {
          this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.clearAnimation();
          localViewGroup.removeView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
        }
        this.hT.addView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView, new RelativeLayout.LayoutParams(paramInt, i));
        this.z = new RelativeLayout.LayoutParams(paramInt, i);
        this.z.leftMargin = this.w.leftMargin;
        this.z.topMargin = this.w.topMargin;
        if (PhotoListPanel.bXj == 1)
        {
          float f2 = parama.itemView.getWidth() - PhotoListPanel.h.this.startY;
          float f1 = f2;
          if (PhotoListPanel.h.this.startY > parama.itemView.getWidth()) {
            f1 = f2 + parama.itemView.getWidth();
          }
          f2 = parama.itemView.getWidth() * 0.4F / 2.0F;
          parama = this.w;
          parama.topMargin = ((int)(parama.topMargin - (f1 + f2)));
        }
        if (PhotoListPanel.bXj == 1) {
          this.hT.setBackgroundResource(2130842317);
        }
        if (this.tv.getParent() != null) {
          return false;
        }
        this.hT.addView(this.tv, this.x);
        this.tv.setVisibility(4);
        this.dw.addView(this.hR, this.y);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.startAnimation(this.s);
        this.hR.addView(this.hS, this.z);
        this.hR.addView(this.hT, this.w);
        this.hT.invalidate();
        this.hT.post(new PhotoListPanel.SwipeUpAndDragListener.DragHandler.1(this));
        akxe.a("PhotoListPanel", "DragHandler", "drag prepare, contentParent = " + this.hT.getParent());
        return true;
      }
      
      void cff()
      {
        if (PhotoListPanel.bXj == 1)
        {
          ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.4F, 1.0F, 1.4F, 1, 0.5F, 1, 0.5F);
          localScaleAnimation.setFillAfter(true);
          this.hT.startAnimation(localScaleAnimation);
          ((Vibrator)this.ctx.getSystemService("vibrator")).vibrate(100L);
        }
      }
      
      AnimationSet i()
      {
        float f1;
        int k;
        int m;
        int i;
        int j;
        switch (PhotoListPanel.bXj)
        {
        default: 
          f1 = PhotoListPanel.h.this.b(this.bXt, this.hT.getWidth(), this.hT.getHeight());
          akxe.a("PhotoListPanel", "createDragReleaseSendAnim", "d scale = " + f1);
          this.hT.getLocationInWindow(this.iC);
          k = PhotoListPanel.h.this.iB[0] - (int)(65.0F * PhotoListPanel.h.this.mDensity + 0.5F + this.hT.getWidth() * f1 + 0.5F) - this.iC[0];
          m = this.dw.getHeight() + PhotoListPanel.h.this.iB[1] - PhotoListPanel.h.this.d.getHeight() - (int)(13.0F * PhotoListPanel.h.this.mDensity + 0.5F + this.hT.getHeight() * f1 + 0.5F) - this.bXs;
          if (PhotoListPanel.h.this.d.a.getItemViewType(this.bXt) == 1)
          {
            i = m - (int)(70.0F * PhotoListPanel.h.this.mDensity + 0.5F);
            j = k;
          }
          break;
        }
        for (;;)
        {
          akxe.a("PhotoListPanel", "createDragReleaseSendAnim", " deltY = " + i + ", flyStartLocation[1] = " + this.iC[1] + ",inputBarRightTopCorner[1] = " + PhotoListPanel.h.this.iB[1] + ",top = " + this.hT.getTop());
          Object localObject1 = new AnimationSet(false);
          Object localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1);
          ((ScaleAnimation)localObject2).setStartOffset(0L);
          ((ScaleAnimation)localObject2).setDuration(500L);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          localObject2 = new AnimationSet(false);
          ((AnimationSet)localObject2).setStartOffset(0L);
          ((AnimationSet)localObject2).setDuration(500L);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, j, 0.0F, 0.0F);
          localTranslateAnimation.setInterpolator(new LinearInterpolator());
          ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
          localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
          localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
          ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setStartOffset(500L - 200L / 2L);
          ((AlphaAnimation)localObject2).setDuration(200L);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject1).setFillAfter(false);
          return localObject1;
          f1 = PhotoListPanel.h.this.f(this.bXt, this.hT.getHeight());
          break;
          i = m;
          j = k;
          if (PhotoListPanel.bXj == 1)
          {
            localObject1 = PhotoListPanel.h.this.d.a.getItem(PhotoListPanel.h.this.bXr);
            float f2 = ((LocalMediaInfo)localObject1).mediaHeight * 1.0F / ((LocalMediaInfo)localObject1).mediaWidth;
            if (((LocalMediaInfo)localObject1).mediaHeight > ((LocalMediaInfo)localObject1).mediaWidth)
            {
              i = m - (int)(this.hT.getHeight() * 0.5F * (f2 - 1.0F) * f1);
              j = k;
            }
            else
            {
              j = k - (int)(this.hT.getHeight() * 0.5F * (1.0F / f2 - 1.0F) * f1);
              i = m;
            }
          }
        }
      }
    }
    
    public class b
      extends PhotoListPanel.h.c
    {
      public b(Context paramContext, ViewGroup paramViewGroup)
      {
        super(paramContext, paramViewGroup);
      }
      
      private boolean gG(int paramInt)
      {
        Object localObject1 = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getWidth() - (int)(2.0F * PhotoListPanel.h.this.mDensity + 0.5F), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getHeight() - (int)(2.0F * PhotoListPanel.h.this.mDensity + 0.5F) * 2);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (this.iE[0] + (int)(2.0F * PhotoListPanel.h.this.mDensity + 0.5F));
        this.dw.getLocationInWindow(this.iD);
        ((RelativeLayout.LayoutParams)localObject1).topMargin = (this.iE[1] - this.iD[1] - PhotoListPanel.h.this.mTitleHeight + (int)(2.0F * PhotoListPanel.h.this.mDensity + 0.5F));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.startAnimation(this.s);
        if (this.hR.getParent() != null) {
          return false;
        }
        this.dw.addView(this.hR, this.y);
        this.hR.addView(this.hS, (ViewGroup.LayoutParams)localObject1);
        this.hR.addView(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView, (ViewGroup.LayoutParams)localObject1);
        float f1;
        int j;
        int i;
        int k;
        int m;
        float f2;
        switch (PhotoListPanel.bXj)
        {
        default: 
          f1 = PhotoListPanel.h.this.b(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getWidth() - (int)(4.0F * PhotoListPanel.h.this.mDensity), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getHeight() - (int)(4.0F * PhotoListPanel.h.this.mDensity));
          akxe.a("PhotoListPanel", "startFlingAnim", "f scale = " + f1);
          j = PhotoListPanel.h.this.iB[0] - (int)(65.0F * PhotoListPanel.h.this.mDensity + 0.5F + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getWidth() * f1 + 0.5F) - this.iE[0];
          paramInt = this.dw.getHeight();
          i = PhotoListPanel.h.this.iB[1];
          k = PhotoListPanel.h.this.d.getHeight();
          int n = (int)(13.0F * PhotoListPanel.h.this.mDensity + 0.5F + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getHeight() * f1 + 0.5F);
          int i1 = this.iE[1];
          m = ((RelativeLayout.LayoutParams)localObject1).topMargin - (int)(30.0F * PhotoListPanel.h.this.mDensity);
          k = paramInt + i - k - n - i1 + m;
          localObject1 = PhotoListPanel.h.this.d.a.getItem(PhotoListPanel.h.this.bXr);
          f2 = ((LocalMediaInfo)localObject1).mediaHeight * 1.0F / ((LocalMediaInfo)localObject1).mediaWidth;
          if (PhotoListPanel.h.this.d.a.getItemViewType(this.bXt) == 1)
          {
            paramInt = k - (int)(70.0F * PhotoListPanel.h.this.mDensity + 0.5F);
            i = j;
          }
          break;
        }
        for (;;)
        {
          localObject1 = new AnimationSet(false);
          Object localObject2 = new ScaleAnimation(1.0F, f1, 1.0F, f1);
          ((ScaleAnimation)localObject2).setStartOffset(200L);
          ((ScaleAnimation)localObject2).setDuration(300L);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -m);
          ((TranslateAnimation)localObject2).setStartOffset(0L);
          ((TranslateAnimation)localObject2).setDuration(200L);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          localObject2 = new AnimationSet(false);
          ((AnimationSet)localObject2).setStartOffset(200L);
          ((AnimationSet)localObject2).setDuration(300L);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, i, 0.0F, 0.0F);
          localTranslateAnimation.setInterpolator(new LinearInterpolator());
          ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
          localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt);
          localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
          ((AnimationSet)localObject2).addAnimation(localTranslateAnimation);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setStartOffset(200L + 300L - 200L / 2L);
          ((AlphaAnimation)localObject2).setDuration(200L);
          ((AnimationSet)localObject1).addAnimation((Animation)localObject2);
          this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.startAnimation((Animation)localObject1);
          ((AnimationSet)localObject1).setAnimationListener(new xux(this));
          return true;
          f1 = PhotoListPanel.h.this.f(paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getHeight() - (int)(4.0F * PhotoListPanel.h.this.mDensity));
          break;
          paramInt = k;
          i = j;
          if (PhotoListPanel.bXj == 1) {
            if (((LocalMediaInfo)localObject1).mediaHeight > ((LocalMediaInfo)localObject1).mediaWidth)
            {
              paramInt = k - (int)((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getHeight() - (int)(4.0F * PhotoListPanel.h.this.mDensity)) * 0.5F * (f2 - 1.0F) * f1);
              i = j;
            }
            else
            {
              i = j - (int)((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.getHeight() - (int)(4.0F * PhotoListPanel.h.this.mDensity)) * 0.5F * (1.0F / f2 - 1.0F) * f1);
              paramInt = k;
            }
          }
        }
      }
      
      boolean Y(MotionEvent paramMotionEvent)
      {
        PhotoListPanel.h.this.mVelocityTracker.addMovement(paramMotionEvent);
        return true;
      }
      
      boolean Z(MotionEvent paramMotionEvent)
      {
        akxe.a("PhotoListPanel", "handleUp", "handler = " + this);
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = f2 - PhotoListPanel.h.this.startY;
        float f4 = PhotoListPanel.h.this.startX;
        int i = paramMotionEvent.getPointerId(0);
        PhotoListPanel.h.this.mVelocityTracker.computeCurrentVelocity(1000);
        float f5 = PhotoListPanel.h.this.mVelocityTracker.getYVelocity(i);
        akxe.a("PhotoListPanel", "FlingHandler", "@@handleUp,x = " + f1 + ",y = " + f2 + ",delY = " + f3 + ",velocityY = " + f5 + ",SWIPE_THRESHOLD = " + PhotoListPanel.h.SWIPE_THRESHOLD);
        if ((-f3 > PhotoListPanel.h.SWIPE_THRESHOLD) && (Math.abs(f5) > 100.0F) && (SystemClock.elapsedRealtime() - PhotoListPanel.h.this.JD < 500L) && ((PhotoListPanel.h.this.d.mScrollState == 1) || (PhotoListPanel.h.this.d.mScrollState == 0)) && (Math.abs(f3) > Math.abs(f1 - f4)))
        {
          if (PhotoListPanel.h.this.d.a.qQ.size() == 0)
          {
            akxe.a("PhotoListPanel", "handleUp", "handler = " + this + "mInfos is null!!!!!! targetPosition=" + this.bXt);
            return false;
          }
          PhotoListPanel.h.this.d.bjC = true;
          if (!gG(this.bXt))
          {
            akxe.a("PhotoListPanel", "handleUp", "handler  animLayout already hasparent= ");
            return false;
          }
          i = PhotoListPanel.h.this.d.a.getItemViewType(this.bXt);
          paramMotionEvent = new ArrayList();
          paramMotionEvent.add(PhotoListPanel.h.this.d.a.getItem(this.bXt).path);
          anot.a(null, "dc00898", "", "", "0X800A7B0", "0X800A7B0", this.bXt + 1, 0, "1", "", "", "");
          anot.a(null, "dc00898", "", "", "0X800A914", "0X800A914", PhotoUtils.d(PhotoListPanel.h.this.d.mSessionInfo), 0, "" + (this.bXt + 1), "", "", "");
          boolean bool;
          if (PhotoListPanel.h.this.a != null)
          {
            paramMotionEvent = PhotoListPanel.h.this.a;
            String str = PhotoListPanel.h.this.d.a.getItem(this.bXt).path;
            if (PhotoListPanel.h.this.d.Cv == 2)
            {
              bool = true;
              paramMotionEvent.aY(str, bool);
            }
          }
          for (;;)
          {
            return true;
            bool = false;
            break;
            PhotoListPanel.h.this.d.a(this.bXt, paramMotionEvent, false, true, "0X8005E0D", "1", i + "", false);
          }
        }
        akxe.a("PhotoListPanel", "FlingHandler", "@handleUp,return false. velocityY = " + f5 + ",dely = " + (f2 - PhotoListPanel.h.this.startY));
        return (SystemClock.elapsedRealtime() - PhotoListPanel.h.this.JD >= 200L) || (Math.abs(f2 - PhotoListPanel.h.this.startY) >= PhotoListPanel.h.this.mTouchSlop) || (Math.abs(f1 - PhotoListPanel.h.this.startX) >= PhotoListPanel.h.this.mTouchSlop);
      }
    }
    
    public class c
    {
      PhotoListPanel.e.a a;
      public RoundRectImageView a;
      int bXt;
      Context ctx;
      ViewGroup dw;
      Runnable ew;
      Runnable ex;
      public RelativeLayout hR;
      RelativeLayout hS;
      public RelativeLayout hT;
      int[] iD;
      int[] iE;
      AlphaAnimation s;
      public AlphaAnimation t;
      public Animation.AnimationListener t;
      RelativeLayout.LayoutParams y;
      public RelativeLayout.LayoutParams z;
      
      public c(Context paramContext, ViewGroup paramViewGroup)
      {
        this.ctx = paramContext;
        this.dw = paramViewGroup;
        this.iD = new int[2];
        this.iE = new int[2];
        paramViewGroup.getLocationInWindow(this.iD);
        this.hR = new RelativeLayout(paramContext);
        this.hR.setBackgroundResource(17170445);
        this.hR.setOnTouchListener(new xuy(this, PhotoListPanel.h.this));
        this.y = new RelativeLayout.LayoutParams(-1, -1);
        this.y.topMargin = PhotoListPanel.h.this.mTitleHeight;
        this.hS = new RelativeLayout(paramContext);
        this.hS.setBackgroundColor(637534208);
        this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = new RoundRectImageView(paramContext);
        if (PhotoListPanel.bXj == 1) {
          this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode(12, 1);
        }
        this.s = new AlphaAnimation(1.0F, 0.0F);
        this.s.setFillAfter(true);
        this.jdField_t_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        this.jdField_t_of_type_AndroidViewAnimationAnimation$AnimationListener = new xuz(this, PhotoListPanel.h.this);
        this.ew = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler.3(this, PhotoListPanel.h.this);
        this.ex = new PhotoListPanel.SwipeUpAndDragListener.GestureHandler.4(this, PhotoListPanel.h.this);
      }
      
      boolean SQ()
      {
        return (this.hR != null) && (this.dw.indexOfChild(this.hR) != -1);
      }
      
      boolean Y(MotionEvent paramMotionEvent)
      {
        return true;
      }
      
      boolean Z(MotionEvent paramMotionEvent)
      {
        return false;
      }
      
      boolean a(PhotoListPanel.e.a parama, int paramInt)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a = parama;
        this.bXt = paramInt;
        parama.itemView.getLocationInWindow(this.iE);
        parama = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.av.getDrawable();
        this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setImageDrawable(parama);
        this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return true;
      }
      
      public void clear()
      {
        QLog.d("PhotoListPanel", 1, new Object[] { "clear", "handler = " + this });
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$e$a.itemView.clearAnimation();
          this.hR.removeAllViews();
          this.dw.removeView(this.hR);
          if (this.hT != null)
          {
            ThreadManager.getUIHandler().postDelayed(this.ew, 50L);
            return;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            localNullPointerException.printStackTrace();
          }
          ThreadManager.getUIHandler().postDelayed(this.ex, 100L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel
 * JD-Core Version:    0.7.0.1
 */