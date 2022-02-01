package com.tencent.mobileqq.activity.pendant;

import abdq;
import abdq.a.a;
import abdq.b.a;
import abdq.c;
import acfd;
import acff;
import acfp;
import acle;
import aclh;
import acnj;
import acnj.a;
import aklk;
import altq;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anlm;
import anot;
import aqbn;
import aqcx;
import aqdj;
import aqep;
import aqfo;
import aqgm;
import aqha;
import aqhq;
import aqhu;
import aqiw;
import aqju;
import aqmj;
import aqpf;
import aqpg;
import aqph;
import aqqj;
import aqrb;
import aqrd;
import aqrf;
import aquy;
import aquz;
import aqva;
import aqvc;
import ausj;
import auss;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zou;
import zov;
import zow;
import zoz;
import zpa;
import zpb;
import zpc;
import zpd;
import zpe;
import zpf;
import zpg;
import zph;
import zpi;
import zpj;
import zpk;
import zpl;
import zpm;
import zpn;

public class AvatarPendantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnLayoutChangeListener, AdapterView.c
{
  public static int cea;
  public static int ceb = 1;
  public static int cec = 2;
  public static int ced = 3;
  RedTouch D;
  XListView G;
  public long Ll = -1L;
  long Lm = -1L;
  long Ln = -1L;
  public long Lo = 0L;
  TextView MW;
  TextView MX;
  SparseIntArray O = new SparseIntArray();
  public abdq a;
  private acfd jdField_a_of_type_Acfd = new zph(this);
  acle jdField_a_of_type_Acle;
  private aclh jdField_a_of_type_Aclh = new zpe(this);
  acnj.a jdField_a_of_type_Acnj$a = new zpn(this);
  acnj jdField_a_of_type_Acnj;
  aqpf jdField_a_of_type_Aqpf;
  public aqpg a;
  public aqph a;
  aquy jdField_a_of_type_Aquy = new zoz(this);
  public Handler aY;
  public DynamicAvatarView b;
  AvatarLayout b;
  double bH;
  double bI;
  AtomicBoolean bQ = new AtomicBoolean(false);
  AtomicBoolean bR = new AtomicBoolean(false);
  String baq;
  String bar;
  String bas;
  String bat;
  boolean bsa;
  boolean bsb;
  boolean bsc;
  private boolean bsd = true;
  public boolean bse = false;
  public volatile boolean bsf = false;
  public ProfileActivity.AllInOne c;
  public int cee;
  int cef;
  int ceg;
  int ceh;
  int cei;
  int cej;
  int cek;
  int cel;
  int cem;
  int cen;
  int ceo;
  public int cep = 0;
  public int ceq = -1;
  public int cer = -1;
  aqrd jdField_d_of_type_Aqrd = new zpa(this);
  TipsBar jdField_d_of_type_ComTencentMobileqqWidgetTipsBar;
  private aklk jdField_e_of_type_Aklk = new zpj(this);
  VasQuickUpdateManager.CallBacker jdField_e_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new zpg(this);
  public Button eF;
  Button eG;
  int frameHeight;
  public LinearLayout hQ;
  SharedPreferences.Editor mEditor;
  int mScrollState;
  int mScrollY;
  BusinessInfoCheckUpdate.AppInfo r;
  public List<aqpf> uC;
  ImageView vs;
  public ImageView vt;
  ImageView vu;
  public Uri x;
  View xR;
  View yL;
  View yM;
  View yN;
  
  private void Ad()
  {
    this.yL = super.findViewById(2131379823);
    this.xR = super.findViewById(2131363629);
    this.yM = super.findViewById(2131381212);
    View localView = super.findViewById(2131374954);
    this.vs = ((ImageView)super.findViewById(2131381213));
    this.G = ((XListView)super.findViewById(2131372970));
    this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131381211));
    this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)super.findViewById(2131363324));
    this.vt = ((ImageView)super.findViewById(2131381217));
    this.yN = super.findViewById(2131381216);
    this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)super.findViewById(2131379725));
    this.hQ = ((LinearLayout)super.findViewById(2131377631));
    this.eF = ((Button)super.findViewById(2131377632));
    this.MW = ((TextView)super.findViewById(2131372985));
    this.MX = ((TextView)findViewById(2131366678));
    this.vu = ((ImageView)super.findViewById(2131363325));
    this.eG = ((Button)super.findViewById(2131377627));
    this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.c(0, this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.yM.addOnLayoutChangeListener(this);
    this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
    this.eF.setOnClickListener(this);
    this.eG.setOnClickListener(this);
    findViewById(2131369587).setOnClickListener(this);
    Object localObject1 = (TextView)findViewById(2131366677);
    ((TextView)localObject1).setOnClickListener(this);
    this.D = new RedTouch(this, (View)localObject1).a(53).a();
    cqI();
    localObject1 = (TextView)super.findViewById(2131369579);
    ((TextView)localObject1).setText("");
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131369627);
    ((TextView)localObject1).setText(" ");
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(" ");
    localObject1 = (RelativeLayout)super.findViewById(2131379823);
    localObject1 = getWindowManager().getDefaultDisplay();
    int i = ((Display)localObject1).getHeight();
    int j = ((Display)localObject1).getWidth();
    double d3 = i / j;
    if ((Build.VERSION.SDK_INT >= 24) && (!isInMultiWindowMode()) && (!isInPictureInPictureMode()) && (d3 < 1.5D)) {
      d3 = 1.5D;
    }
    for (;;)
    {
      double d1 = d3 - 1.78D;
      this.frameHeight = (i - yo());
      this.cee = cea;
      double d2 = 0.58D * (d3 - 2.0D * d1) / 1.8D;
      d1 = (1.85D - d1 * 2.0D) * 0.38D / d3;
      Object localObject2;
      RelativeLayout.LayoutParams localLayoutParams;
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        d1 = d3 - 1.67D;
        yo();
        j = super.getResources().getDimensionPixelSize(2131299627);
        localObject2 = (RelativeLayout)super.findViewById(2131381200);
        localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
        localLayoutParams.topMargin = (j / 2 + 14 - (int)(Math.abs(d1) * 24.0D));
        ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
        d2 = 0.58D * (1.8D + 2.0D * d1) / d3;
        d1 = 0.38D * (d1 * 2.0D + 1.95D) / d3;
      }
      for (;;)
      {
        if (d3 < 1.2D)
        {
          this.frameHeight = i;
          d2 = 1.0D;
          d1 = 1.0D;
        }
        for (;;)
        {
          this.cef = ((int)(this.frameHeight * d2));
          this.ceg = ((int)(this.frameHeight * d1));
          if (!this.bsb)
          {
            super.findViewById(2131381204).setVisibility(8);
            this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
            this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText("没有SD卡无法使用头像挂件");
            this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.showArrow(false);
            this.cef = ((int)((d2 + 0.06D) * this.frameHeight));
            this.ceg = ((int)(d1 * this.frameHeight));
            this.bsa = true;
            this.ceh = ((int)(this.cef * 0.383D));
            this.cej = ((int)(186.05F * this.ceh / 150.0F));
            this.cel = ((int)(222.05F * this.cej / 186.0F));
            this.cen = ((this.cej - this.ceh) / 2);
            this.bH = ((this.ceg + 0.05F) / this.cef);
            this.bH -= 0.24D;
            this.cei = ((int)(this.ceh * this.bH));
            this.cek = ((int)(this.cej * this.bH));
            this.cem = ((int)(this.cel * this.bH));
            this.ceo = ((int)(this.cen * this.bH));
            this.bI = ((this.ceh - this.cei + 0.05F) / (this.cef - this.ceg));
            localObject1 = (FrameLayout.LayoutParams)this.G.getLayoutParams();
            localObject2 = (FrameLayout.LayoutParams)this.yM.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject1).topMargin = this.ceg;
            ((FrameLayout.LayoutParams)localObject2).height = this.cef;
            this.G.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.yM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
            localObject2 = (RelativeLayout.LayoutParams)this.vt.getLayoutParams();
            localLayoutParams = (RelativeLayout.LayoutParams)this.yN.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = this.ceh;
            ((RelativeLayout.LayoutParams)localObject1).height = this.ceh;
            ((RelativeLayout.LayoutParams)localObject2).width = this.cej;
            ((RelativeLayout.LayoutParams)localObject2).height = this.cel;
            localLayoutParams.height = this.cen;
            this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.yN.setLayoutParams(localLayoutParams);
            this.vt.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ThreadManager.excute(new AvatarPendantActivity.3(this), 32, null, false);
            Ce();
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label1309;
            }
            if (localView != null) {
              localView.setVisibility(0);
            }
          }
          label1309:
          while (localView == null)
          {
            return;
            if (this.bsc)
            {
              super.findViewById(2131381204).setVisibility(8);
              this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
              this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(acfp.m(2131703002));
              this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.showArrow(false);
              this.cef = ((int)((d2 + 0.06D) * this.frameHeight));
              this.ceg = ((int)(d1 * this.frameHeight));
              this.bsa = true;
              break;
            }
            this.jdField_d_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
            this.jdField_a_of_type_Abdq = new abdq(this, this, this, ((Display)localObject1).getWidth(), this.app, this.c.uin, this.cef - this.ceg);
            this.G.setAdapter(this.jdField_a_of_type_Abdq);
            break;
          }
          localView.setVisibility(8);
          return;
        }
      }
    }
  }
  
  private void BQ(boolean paramBoolean)
  {
    int i = 0;
    ExtensionInfo localExtensionInfo = this.app.a(this.app.getCurrentAccountUin(), false);
    if (paramBoolean) {}
    for (;;)
    {
      if ((localExtensionInfo != null) && (this.uC != null) && (this.uC.size() > 0) && (i != this.ceq))
      {
        this.ceq = i;
        this.cer = this.ceq;
        this.mEditor.putInt("ChooseFaceId", -1);
        this.mEditor.putInt("mSelectFaceId", this.ceq);
        this.mEditor.apply();
      }
      return;
      if (localExtensionInfo != null) {
        i = localExtensionInfo.faceId;
      }
    }
  }
  
  private void Ce()
  {
    Object localObject = new File(aqgm.csV + "/widget_display_bg.jpg");
    if (((File)localObject).exists())
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-16741938);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.yM.getWidth();
      localURLDrawableOptions.mRequestHeight = this.yM.getHeight();
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
      this.vs.setImageDrawable((Drawable)localObject);
    }
    this.vs.setOnClickListener(this);
  }
  
  private boolean VC()
  {
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    boolean bool = ((SharedPreferences)localObject).getBoolean("had_show_pendant_tips", false);
    if (!bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("had_show_pendant_tips", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return bool;
  }
  
  private boolean VD()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("had_entered_store_face", false);
  }
  
  private boolean VG()
  {
    int i = 0;
    boolean bool;
    if (TextUtils.isEmpty(this.bas)) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantActivity", 2, "isNeedShowHDHead, result=" + bool + ", hdHeadUrl=" + this.bas + ",openflag=" + i);
      }
      this.bR.set(bool);
      return bool;
      String[] arrayOfString = DeviceProfileManager.b().aJ(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0").split("\\|");
      if (arrayOfString.length > 3)
      {
        i = Integer.parseInt(arrayOfString[3]);
        if (i == 0) {
          bool = false;
        }
      }
      else
      {
        bool = false;
        continue;
      }
      bool = true;
    }
  }
  
  private void cqF()
  {
    this.uC = ((AvatarPendantManager)this.app.getManager(46)).gJ();
    if (this.uC == null)
    {
      VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
      localVasQuickUpdateManager.addCallBacker(this.jdField_e_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      localVasQuickUpdateManager.downloadItem(23L, "avatarInPendant_json", "pendant_market");
      cqP();
    }
  }
  
  private void cqG()
  {
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
    localVasQuickUpdateManager.addCallBacker(this.jdField_e_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    Object localObject = ((aqva)this.app.getManager(47)).a(1);
    File localFile1 = new File(aqgm.csU);
    if (!localFile1.exists()) {
      localFile1.mkdir();
    }
    File localFile2 = new File(aqgm.csU + "/icon.zip");
    if ((localFile1.exists()) && (!localFile2.exists()) && (localObject != null)) {
      ThreadManager.getSubThreadHandler().post(new IconRunnable(this.jdField_a_of_type_Aquy, this.app));
    }
    localObject = ((AvatarPendantManager)this.app.getManager(46)).gI();
    this.app.getApp().getSharedPreferences("clubContentPendantMarketJsonUpdate", 0);
    if (((List)localObject).size() > 0)
    {
      this.jdField_a_of_type_Abdq.C((List)localObject, this.uC);
      return;
    }
    if (new File(this.baq).exists())
    {
      ((List)localObject).clear();
      cqO();
      return;
    }
    localVasQuickUpdateManager.downloadItem(1000L, "pendant_market_json.android.v2", "pendant_market");
  }
  
  private void cqH()
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("had_entered_store_face", true);
    localEditor.commit();
  }
  
  private void cqI()
  {
    ThreadManager.post(new AvatarPendantActivity.5(this), 5, null, true);
  }
  
  private void cqK()
  {
    if ((this.cee == cea) || (this.cee == ced)) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.yM.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.vt.getLayoutParams();
    Object localObject = (RelativeLayout.LayoutParams)this.yN.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.cen;
    this.yN.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new a();
    a locala1 = new a();
    a locala2 = new a();
    new a();
    ((a)localObject).ceu = localLayoutParams.height;
    ((a)localObject).cev = this.cef;
    int i = localLayoutParams.topMargin;
    ((a)localObject).cet = i;
    ((a)localObject).ahj = i;
    ((a)localObject).playTime = ((int)(Math.abs(this.cef - localLayoutParams.height) * 1.0D / this.cef * ((a)localObject).playTime));
    i = localLayoutParams1.topMargin;
    locala1.cet = i;
    locala1.ahj = i;
    locala1.cew = localLayoutParams1.width;
    locala1.cex = this.ceh;
    locala1.ceu = localLayoutParams1.height;
    locala1.cev = this.ceh;
    locala1.playTime = ((a)localObject).playTime;
    i = localLayoutParams2.topMargin;
    locala2.cet = i;
    locala2.ahj = i;
    locala2.cew = localLayoutParams2.width;
    locala2.cex = this.cej;
    locala2.ceu = localLayoutParams2.height;
    locala2.cev = this.cel;
    locala2.playTime = ((a)localObject).playTime;
    localArrayList2.add(this.yM);
    localArrayList2.add(this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
    localArrayList2.add(this.vt);
    localArrayList1.add(localObject);
    localArrayList1.add(locala1);
    localArrayList1.add(locala2);
    if (((a)localObject).playTime <= 0)
    {
      QLog.e("AvatarPendantActivity", 2, "heigth: " + this.cef + " palytime: " + ((a)localObject).playTime);
      return;
    }
    e(localArrayList2, localArrayList1, ((a)localObject).playTime);
  }
  
  private void cqL()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.10(this));
  }
  
  private void cqM()
  {
    if (!ProfileActivity.AllInOne.g(this.c))
    {
      this.vt.setVisibility(4);
      return;
    }
    Object localObject = ((acff)this.app.getManager(51)).a(this.c.uin);
    long l1;
    long l2;
    if (localObject != null)
    {
      l1 = ((ExtensionInfo)localObject).pendantId;
      if (localObject == null) {
        break label181;
      }
      l2 = ((ExtensionInfo)localObject).pendantDiyId;
      label67:
      if ((this.Ll == -1L) || (this.Lm != l1) || (this.Ln != l2)) {
        break label214;
      }
      localObject = (AvatarPendantManager)this.app.getManager(46);
      this.vt.setVisibility(0);
      if (!aqgm.cT(this.Ll)) {
        break label190;
      }
      ((AvatarPendantManager)localObject).a(this.Ll).d(this.vt, 2, PendantInfo.ebS);
      label150:
      localObject = this.MW;
      if (!VC()) {
        break label463;
      }
    }
    label181:
    label190:
    label463:
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      l1 = this.Lm;
      break;
      l2 = this.Ln;
      break label67;
      ((AvatarPendantManager)localObject).a(this.Ll).d(this.vt, 5, PendantInfo.ebS);
      break label150;
      label214:
      if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
      {
        this.Lm = ((ExtensionInfo)localObject).pendantId;
        this.Ln = ((ExtensionInfo)localObject).pendantDiyId;
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(46);
        this.vt.setVisibility(0);
        if (aqgm.cT(((ExtensionInfo)localObject).pendantId)) {
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.vt, 2, PendantInfo.ebS, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
        for (;;)
        {
          this.eF.setEnabled(false);
          this.eF.setText(2131719633);
          anot.a(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
          break;
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.vt, 5, PendantInfo.ebS, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
      }
      this.vt.setVisibility(4);
      this.hQ.setVisibility(8);
      anot.a(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
      break label150;
    }
  }
  
  private void cqR()
  {
    if ((this.cer != -1) && (this.ceq != -1))
    {
      if (this.cer == this.ceq)
      {
        this.eG.setText(acfp.m(2131702992));
        this.eG.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.eG.setText(acfp.m(2131702991));
    this.eG.setEnabled(true);
  }
  
  private void cqS()
  {
    Intent localIntent = new Intent();
    int i = aqep.w(this);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("fromWhereClick", 11);
    PhotoUtils.a(localIntent, this, AvatarPendantActivity.class.getName(), i, i, 1080, 1080, aqep.BR());
    anot.a(this.app, "CliOper", "", "", "0X8004177", "0X8004177", this.c.bJa, 0, "", "", "", "");
  }
  
  private void cqT()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        requestPermissions(new zpi(this), 0, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      cqS();
      return;
    }
    cqS();
  }
  
  @TargetApi(14)
  private void e(List<View> paramList, List<a> paramList1, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new zpl(this, paramList, paramList1));
    localValueAnimator.addListener(new zpm(this));
    localValueAnimator.setDuration(paramInt).start();
  }
  
  private void zC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "initHDHeadUrl: uin=" + paramString);
    }
    Setting localSetting = this.app.b(paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      String str = QQHeadDownloadHandler.a(localSetting.url, localSetting.bFaceFlags);
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", str);
      }
      this.Lo = localSetting.headImgTimestamp;
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.23(this, paramString));
      return;
    }
    this.app.EH(paramString);
  }
  
  private void zD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: url=" + paramString);
    }
    this.bas = paramString;
    if (VG())
    {
      paramString = aqdj.a(this.app, 1, this.c.uin);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localURLDrawableOptions.mFailedDrawable = paramString;
      localURLDrawableOptions.mLoadingDrawable = paramString;
      if (this.bQ.get())
      {
        if ((this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable() instanceof BitmapDrawable)) {
          localURLDrawableOptions.mLoadingDrawable = this.jdField_b_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable();
        }
        this.bQ.set(false);
      }
      this.bas = (this.bas + "?" + this.Lo);
      URLDrawable.removeMemoryCacheByUrl(this.bas, localURLDrawableOptions);
      paramString = URLDrawable.getDrawable(this.bas, localURLDrawableOptions);
      if (anlm.ayn())
      {
        paramString.setDecodeHandler(aqbn.a);
        paramString.setTag(new int[] { 640, 640, (int)(640.0F * aqhu.AE) });
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: newDisplayHDHead");
        }
        this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, paramString, 1, 200, this.c.uin, 640, true, null, false, true, false, true, 7);
        return;
        paramString.setDecodeHandler(aqbn.b);
        paramString.setTag(new int[] { 640, 640 });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: oldDisplayHead");
    }
    this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.c.uin, 640, true, true, true, false, 7);
  }
  
  public void Qq()
  {
    int i = aqmj.aO(this, this.app.getCurrentAccountUin());
    boolean bool;
    Object localObject;
    String[] arrayOfString;
    if ((i == 2) || (i == -1))
    {
      bool = true;
      localObject = (ausj)auss.a(this, null);
      arrayOfString = super.getResources().getStringArray(2130968638);
      if (!bool) {
        break label214;
      }
      ((ausj)localObject).addButton(arrayOfString[27]);
    }
    for (;;)
    {
      ((ausj)localObject).addButton(arrayOfString[22]);
      ((ausj)localObject).addButton(arrayOfString[24]);
      ((ausj)localObject).addButton(arrayOfString[13]);
      ((ausj)localObject).addCancelButton(arrayOfString[16]);
      ((ausj)localObject).a(new zow(this, bool, (ausj)localObject));
      try
      {
        if (!isFinishing())
        {
          ((ausj)localObject).show();
          localObject = ((ausj)localObject).findViewById(0);
          if (localObject != null) {
            ((View)localObject).setContentDescription(acfp.m(2131702995));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label214:
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "showActionSheet, historyHeadNumFlag=" + i);
      }
      anot.a(this.app, "dc00898", "", "", "0X800A8C8", "0X800A8C8", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      ((ausj)localObject).addButton(arrayOfString[23]);
    }
  }
  
  public boolean VE()
  {
    if ((this.app != null) && (this.c != null))
    {
      ExtensionInfo localExtensionInfo = ((acff)this.app.getManager(51)).a(this.c.uin);
      if ((localExtensionInfo != null) && (localExtensionInfo.pendantId == this.Ll)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean VF()
  {
    if ((this.app != null) && (this.c != null))
    {
      ExtensionInfo localExtensionInfo = ((acff)this.app.getManager(51)).a(this.c.uin);
      if ((localExtensionInfo != null) && (localExtensionInfo.faceId == this.ceq)) {
        return true;
      }
    }
    return false;
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int j = getWindowManager().getDefaultDisplay().getWidth();
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(k, m);
    int i = paramTextView.getMeasuredWidth();
    paramView.measure(k, m);
    k = paramView.getMeasuredWidth();
    float f = super.getResources().getDisplayMetrics().density;
    j = j - k - (int)(55 * f + 0.5F);
    if (i > j)
    {
      paramTextView.setMaxWidth(j - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "verifyAuth, tipsInfo = " + paramPendantTipsInfo + "result = " + paramInt);
    }
    int i = paramPendantTipsInfo.type;
    boolean bool = aqiw.isNetSupport(this);
    if (bool) {}
    for (Object localObject = "4";; localObject = "3") {
      switch (i)
      {
      default: 
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        if (paramLong == 0L) {
          break label491;
        }
        anot.a(this.app, "CliOper", "", "", "0X8005FD7", "0X8005FD7", 0, 0, paramPendantTipsInfo, "", "", "");
        return;
      }
    }
    if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
    {
      QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = PAYMENT");
      QQToast.a(this, 1, acfp.m(2131702993), 0).show(getTitleBarHeight());
      return;
    }
    if (paramPendantTipsInfo.vipType.equals("LTMCLUB")) {
      localObject = "0";
    }
    for (;;)
    {
      if (!isFinishing()) {
        aqha.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new zpc(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new zpb(this)).show();
      }
      anot.a(this.app, "CliOper", "", "", "0X8005FD8", "0X8005FD8", 0, 0, "", "", "", "");
      paramPendantTipsInfo = (PendantTipsInfo)localObject;
      break;
      if (paramPendantTipsInfo.equals("CJCLUBT"))
      {
        localObject = "1";
        continue;
        if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
        {
          QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = JUMP_URL");
          QQToast.a(this, 1, acfp.m(2131702988), 0).show(getTitleBarHeight());
          return;
        }
        paramPendantTipsInfo = aqha.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new zpf(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new zpd(this));
        localObject = paramPendantTipsInfo.getMessageTextView();
        ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
        localLayoutParams.width = -1;
        ((TextView)localObject).setLayoutParams(localLayoutParams);
        ((TextView)localObject).setGravity(17);
        paramPendantTipsInfo.setMessageCount(null);
        paramPendantTipsInfo.show();
        paramPendantTipsInfo = "2";
        break;
        a(paramPendantTipsInfo, false, paramInt);
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        break;
        label491:
        localObject = this.app;
        if (bool) {}
        for (paramPendantTipsInfo = "2";; paramPendantTipsInfo = "1")
        {
          anot.a((QQAppInterface)localObject, "CliOper", "", "", "0X8006896", "0X8006896", 0, 0, paramPendantTipsInfo, "", "", "");
          return;
        }
      }
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "openVIP, tipsInfo = " + paramPendantTipsInfo);
    }
    String str1;
    String str2;
    Object localObject;
    if (paramPendantTipsInfo.type == 1)
    {
      if (paramBoolean)
      {
        str1 = "mvip.gxh.android.faceaddon_nati_dft";
        str2 = paramPendantTipsInfo.vipType;
        if (!str2.equals("LTMCLUB")) {
          break label155;
        }
        localObject = getString(2131697263);
      }
      for (;;)
      {
        if ((paramPendantTipsInfo.vipMonth < 1) || (paramPendantTipsInfo.vipMonth > 12))
        {
          QLog.e("AvatarPendantActivity", 1, "openVIP, vipMonth invalid = " + paramPendantTipsInfo.vipMonth);
          return;
          str1 = "mvip.gxh.android.faceaddon_nati_" + this.Ll;
          break;
          label155:
          if (str2.equals("CJCLUBT"))
          {
            localObject = getString(2131720669);
          }
          else if (str2.equals("SVHHZLH"))
          {
            localObject = getString(2131690842);
          }
          else
          {
            QLog.e("AvatarPendantActivity", 2, "openVIP, unknown vipType = " + paramPendantTipsInfo.vipType);
            return;
          }
        }
      }
      if (((paramInt != 9002) && (paramInt != 9003)) || (paramPendantTipsInfo.vipMonth != 12)) {
        break label408;
      }
      if (paramInt != 9003) {
        break label403;
      }
      bool = true;
      paramBoolean = true;
    }
    for (;;)
    {
      aqrf.a(null, this, str1, paramPendantTipsInfo.vipMonth, "1450000515", str2, (String)localObject, "", paramBoolean, bool);
      return;
      if ((paramPendantTipsInfo.type == 2) || (paramPendantTipsInfo.type == 3))
      {
        if (!TextUtils.isEmpty(paramPendantTipsInfo.url))
        {
          localObject = new Intent(this, QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserWithoutAD(this, paramPendantTipsInfo.url, -1L, (Intent)localObject, true, -1);
          return;
        }
        QLog.e("AvatarPendantActivity", 1, "openVIP, type = jump_url, but url == nul. tipsInfo = " + paramPendantTipsInfo);
        return;
      }
      QLog.e("AvatarPendantActivity", 1, "openVIP, action type is incorrect! tipsInfo = " + paramPendantTipsInfo);
      return;
      label403:
      paramBoolean = true;
      continue;
      label408:
      paramBoolean = false;
    }
  }
  
  public void cqJ()
  {
    int i = getScrollY();
    int j = i - this.mScrollY;
    this.mScrollY = i;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.yM.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.vt.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.yN.getLayoutParams();
    if ((j >= 0) || ((j <= 0) && (this.mScrollY <= this.cef - this.ceg))) {
      localLayoutParams.height -= j;
    }
    if (localLayoutParams.height <= this.ceg)
    {
      localLayoutParams.height = this.ceg;
      i = this.cei;
      localLayoutParams1.height = i;
      localLayoutParams1.width = i;
      localLayoutParams2.width = this.cek;
      localLayoutParams2.height = this.cem;
      localLayoutParams3.height = this.ceo;
      this.cee = ceb;
      if ((this.cee == cec) && ((j >= 0) || ((j <= 0) && (this.mScrollY <= this.cef - this.ceg))))
      {
        i = j;
        if (j != 0)
        {
          i = j;
          if (j != 1) {
            if (j != -1) {
              break label423;
            }
          }
        }
      }
    }
    label423:
    for (i = j;; i = (int)(j * this.bI))
    {
      localLayoutParams1.width -= i;
      localLayoutParams1.height = localLayoutParams1.width;
      localLayoutParams2.width -= (int)(i * 186.05F / 150.0F);
      localLayoutParams2.height = ((int)(222.05F * localLayoutParams2.width / 186.0F));
      localLayoutParams3.height = ((localLayoutParams2.width - localLayoutParams1.width) / 2);
      this.yM.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams(localLayoutParams1);
      this.vt.setLayoutParams(localLayoutParams2);
      this.yN.setLayoutParams(localLayoutParams3);
      return;
      if (localLayoutParams.height >= this.cef)
      {
        localLayoutParams.height = this.cef;
        i = this.ceh;
        localLayoutParams1.height = i;
        localLayoutParams1.width = i;
        localLayoutParams2.width = this.cej;
        localLayoutParams2.height = this.cel;
        localLayoutParams3.height = this.cen;
        this.cee = cea;
        break;
      }
      this.cee = cec;
      break;
    }
  }
  
  public void cqN()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131381205);
    TextView localTextView = (TextView)super.findViewById(2131381206);
    Button localButton = (Button)super.findViewById(2131381203);
    String str2 = this.app.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("uniPaySp_" + str2, 0);
    String str3 = localSharedPreferences.getString("sUin", "");
    int i = localSharedPreferences.getInt("isShowOpen", 0);
    int j = localSharedPreferences.getInt("iUinpPayType", 0);
    Object localObject3 = "LTMCLUB";
    String str1 = "QQ会员";
    String str4 = super.getString(2131717407);
    Object localObject2 = str1;
    Object localObject1 = localObject3;
    if (str3 != null)
    {
      localObject2 = str1;
      localObject1 = localObject3;
      if (str2 != null)
      {
        localObject2 = str1;
        localObject1 = localObject3;
        if (str3.equals(str2))
        {
          if (1 == i)
          {
            localImageView.setVisibility(0);
            localTextView.setVisibility(0);
            localButton.setVisibility(0);
          }
          switch (j)
          {
          default: 
            localObject1 = "QQ会员";
            localObject2 = "LTMCLUB";
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "UniPayUpdateListener back showTitleBtn isShowOpen:" + i);
      }
      a(localTextView, localButton);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localButton.setOnClickListener(new zou(this, Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue(), (String)localObject1, (String)localObject2));
      return;
      localButton.setText(2131694796);
      localTextView.setText(super.getString(2131690817, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843437));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131694798);
      localTextView.setText(super.getString(2131690818, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844729));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131694796);
      localTextView.setText(super.getString(2131690814, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843437));
      localObject2 = "CJCLUBT";
      localObject1 = acfp.m(2131703000);
      continue;
      localButton.setText(2131694798);
      localTextView.setText(super.getString(2131690815, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844116));
      localObject2 = "CJCLUBT";
      localObject1 = acfp.m(2131702987);
      continue;
      localButton.setText(2131694798);
      localTextView.setText(super.getString(2131690819, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844730));
      localObject2 = "CJCLUBT";
      localObject1 = acfp.m(2131703005);
      continue;
      localButton.setText(2131694799);
      localTextView.setText(super.getString(2131690820, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844730));
      localObject2 = "CJCLUBT";
      localObject1 = acfp.m(2131702997);
      continue;
      localButton.setText(2131694799);
      localTextView.setText(super.getString(2131690816, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844116));
      localObject2 = "CJCLUBT";
      localObject1 = acfp.m(2131702985);
      continue;
      localButton.setText(2131694798);
      localTextView.setText(super.getString(2131690821, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844731));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
      continue;
      localButton.setText(2131694799);
      localTextView.setText(super.getString(2131690822, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130844731));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
    }
  }
  
  public void cqO()
  {
    ThreadManager.getFileThreadHandler().post(new ConfigParser(this.baq, this));
  }
  
  public void cqP()
  {
    ThreadManager.getFileThreadHandler().post(new ConfacefigParser(this.bar, this));
  }
  
  public void cqQ()
  {
    if (this.Ll != 0L) {
      ((AvatarPendantManager)this.app.getManager(46)).a(this.Ll).eeY();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 4) {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("callbackSn");
        if ((str != null) && (str.startsWith("pendantNativeVip"))) {
          break label35;
        }
      }
    }
    label35:
    label212:
    label226:
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("result");
        paramInt2 = -1;
        int j = -1;
        for (;;)
        {
          try
          {
            paramIntent = new JSONObject(paramIntent);
            paramInt1 = j;
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              i = Integer.parseInt(paramIntent.getString("resultCode"));
              paramInt1 = j;
              paramInt2 = i;
              j = Integer.parseInt(paramIntent.getString("payState"));
              paramInt1 = j;
              paramInt2 = i;
              int k = Integer.parseInt(paramIntent.getString("provideState"));
              paramInt1 = k;
              paramInt2 = i;
              i = paramInt1;
              if ((paramIntent == null) || (paramInt2 != 0) || (j != 0) || (i != 0)) {
                break;
              }
              if (this.jdField_a_of_type_Acnj != null) {
                this.jdField_a_of_type_Acnj.FH("");
              }
              if (!str.equals("pendantNativeVipDefault")) {
                break label226;
              }
              anot.a(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, "", "", "", "");
              this.bse = true;
              return;
            }
            catch (JSONException localJSONException2)
            {
              int i;
              Intent localIntent;
              break label212;
            }
            localJSONException1 = localJSONException1;
            paramIntent = null;
            paramInt1 = j;
          }
          localJSONException1.printStackTrace();
          i = -1;
          j = paramInt1;
          continue;
          anot.a(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, str.substring(16, str.length()), "", "", "");
        }
        if (paramInt1 != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatar", 2, "record dynamic avatar! resultCode:" + paramInt2);
        }
      } while (paramInt2 != -1);
      cqL();
      return;
    } while (paramInt2 != -1);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = aqhu.getRealPathFromContentURI(this, this.x);
    paramInt1 = aqep.w(this);
    localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
    PhotoUtils.a(localIntent, this, AvatarPendantActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, aqep.BR());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2131562074);
    getWindow().setBackgroundDrawable(null);
    this.aY = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.jdField_a_of_type_Acle = ((acle)this.app.getBusinessHandler(13));
    paramBundle = super.getIntent();
    boolean bool2;
    boolean bool1;
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.c = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      cqN();
      this.jdField_a_of_type_Acnj = ((acnj)this.app.getBusinessHandler(44));
      this.jdField_a_of_type_Acnj.a(this.jdField_a_of_type_Acnj$a);
      super.addObserver(this.jdField_d_of_type_Aqrd);
      this.jdField_a_of_type_Acnj.FH("");
      if ((!aqiw.isNetSupport(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.bsb = aqfo.isExistSDCard();
      if (aqfo.getSDCardAvailableSize() >= 1024L) {
        break label449;
      }
      bool1 = true;
      this.bsc = bool1;
      this.baq = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "pendant_market.json");
      this.bar = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "avatarInPendant.json");
      Ad();
      cqF();
      if ((!this.bsb) || (this.bsc)) {
        break label454;
      }
      initAnimation();
      cqG();
    }
    for (;;)
    {
      if (bool2) {
        Qq();
      }
      this.mEditor = getSharedPreferences("facechoosedata", 0).edit();
      this.mEditor.putInt("ChooseFaceId", 0);
      this.mEditor.apply();
      this.app.addObserver(this.jdField_a_of_type_Acfd);
      this.app.registObserver(this.jdField_e_of_type_Aklk);
      this.app.addObserver(this.jdField_a_of_type_Aclh);
      this.bat = aqqj.getUrl("vasClassProfileStoryUrl");
      if (paramBundle.getBooleanExtra("fromThirdApp", false)) {
        ThreadManager.getUIHandler().postDelayed(new AvatarPendantActivity.1(this), 500L);
      }
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "AllinOne info is null");
      }
      finish();
      return true;
      label449:
      bool1 = false;
      break;
      label454:
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "sdcard exist:" + this.bsb + " sdcard full:" + this.bsc);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Acnj != null) {
      this.jdField_a_of_type_Acnj.b(this.jdField_a_of_type_Acnj$a);
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_e_of_type_Aklk);
    }
    super.removeObserver(this.jdField_d_of_type_Aqrd);
    if (this.jdField_a_of_type_Aqph != null) {
      this.jdField_a_of_type_Aqph.pS = -1;
    }
    if ((this.app != null) && (this.Ll != 0L)) {
      ((AvatarPendantManager)this.app.getManager(46)).a(this.Ll).eeY();
    }
    if (this.jdField_a_of_type_Abdq != null)
    {
      this.jdField_a_of_type_Abdq.clearCache();
      URLDrawable.resume();
    }
    if (this.app != null)
    {
      ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_e_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.app.removeObserver(this.jdField_a_of_type_Acfd);
      this.app.removeObserver(this.jdField_a_of_type_Aclh);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (!aqep.a(this.app, str, paramIntent)) {
        break label159;
      }
      cqR();
      this.bsd = true;
      cqL();
      BQ(true);
      switch (paramIntent.getIntExtra("fromWhereClick", -1))
      {
      }
    }
    for (;;)
    {
      cqM();
      return;
      anot.a(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
      continue;
      anot.a(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
      continue;
      label159:
      QQToast.a(this, 1, 2131719573, 0).show(getTitleBarHeight());
    }
  }
  
  public void doOnPause()
  {
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    ((AvatarPendantManager)this.app.getManager(46)).clear();
  }
  
  public void doOnResume()
  {
    int i = 0;
    super.doOnResume();
    ApngImage.playByTag(10);
    AbstractVideoImage.resumeAll();
    if ((this.mSystemBarComp == null) && (this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      this.mSystemBarComp = new SystemBarCompact(this, true, Color.parseColor("#0089ce"));
      this.mSystemBarComp.init();
    }
    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_show", "", 1, 0, 0, "", "", "");
    Object localObject = (AvatarPendantManager)this.app.getManager(46);
    if (localObject != null)
    {
      List localList = ((AvatarPendantManager)localObject).gI();
      this.uC = ((AvatarPendantManager)localObject).gJ();
      if ((this.jdField_a_of_type_Abdq != null) && (localList != null) && (localList.size() > 0)) {
        this.jdField_a_of_type_Abdq.C(localList, this.uC);
      }
    }
    localObject = this.MX;
    if (VD()) {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    cqM();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public int getScrollY()
  {
    int i = 0;
    View localView = this.G.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = -localView.getTop();
    this.O.put(this.G.getFirstVisiblePosition(), localView.getHeight());
    if (i < this.G.getFirstVisiblePosition())
    {
      if (this.O.get(i) == 0) {
        this.bsa = true;
      }
      for (;;)
      {
        i += 1;
        break;
        j += this.O.get(i);
      }
    }
    return j;
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    DynamicAvatarRecordActivity.c(this, 1, 1);
    anot.a(this.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    while (paramMessage.what != 1000) {
      return true;
    }
    runOnUiThread(new AvatarPendantActivity.14(this, ((AvatarPendantManager)this.app.getManager(46)).gI()));
    return true;
  }
  
  public void initAnimation()
  {
    this.G.setOnScrollListener(new zpk(this));
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      int i;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131366653: 
      case 2131366654: 
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.bat);
        startActivity((Intent)localObject);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_more", "", 1, 0, 0, "", "", "");
        break;
      case 2131369579: 
        finish();
        break;
      case 2131366677: 
        ((altq)this.app.getManager(36)).OS("100100.100125.100127");
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("individuation_url_type", 40100);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("hide_left_button", false);
        ((Intent)localObject).putExtra("show_right_close_button", false);
        ((Intent)localObject).putExtra("url", aqqj.o(this, "faceEntryUrl", ""));
        ((Intent)localObject).putExtra("business", 512L);
        ((Intent)localObject).putExtra("isShowAd", false);
        startActivity((Intent)localObject);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "face", "0X80088EC", "", 1, 0, 0, null, "", "");
        cqH();
        break;
      case 2131369587: 
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("individuation_url_type", 40100);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("hide_left_button", false);
        ((Intent)localObject).putExtra("show_right_close_button", false);
        ((Intent)localObject).putExtra("url", aqqj.o(this, "myPendantUrl", ""));
        ((Intent)localObject).putExtra("business", 512L);
        ((Intent)localObject).putExtra("isShowAd", false);
        startActivity((Intent)localObject);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X8008A05", "", 1, 0, 0, null, "", "");
        break;
      case 2131377632: 
        if (!aqiw.isNetSupport(this)) {
          QQToast.a(this, 2131718857, 0).show(getTitleBarHeight());
        } else if (this.jdField_a_of_type_Aqph != null) {
          if (anlm.ayn())
          {
            localObject = aqha.a(this, 0, null, acfp.m(2131703004), null, acfp.m(2131702989), new zov(this), null);
            if (!((aqju)localObject).isShowing()) {
              ((aqju)localObject).show();
            }
          }
          else
          {
            if (!VE()) {
              ((aqrb)this.app.getBusinessHandler(71)).R(this.Ll, this.jdField_a_of_type_Aqph.ebe, -1);
            }
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
            anot.a(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.Ll), "", "", "");
          }
        }
        break;
      case 2131377627: 
        if (!aqiw.isNetSupport(this))
        {
          QQToast.a(this, 2131718857, 0).show(getTitleBarHeight());
        }
        else if (!VF())
        {
          this.bsd = false;
          this.jdField_a_of_type_Acle.JS(this.ceq);
          VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_setresult", "", 1, this.cep, 0, "", this.ceq + "", "");
          this.cer = this.ceq;
          this.eG.setText(acfp.m(2131702998));
          this.eG.setEnabled(false);
          this.mEditor.putInt("mSelectFaceId", this.ceq);
          this.mEditor.apply();
          localObject = ((AvatarPendantManager)this.app.getManager(46)).gI();
          this.jdField_a_of_type_Abdq.C((List)localObject, this.uC);
        }
        break;
      case 2131381211: 
        if (aqep.aBY()) {
          QQToast.a(this, 1, 2131721613, 0).show(getTitleBarHeight());
        }
        for (;;)
        {
          anot.a(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.c.bJa, 0, "", "", "", "");
          break;
          Qq();
        }
      case 2131372973: 
      case 2131372974: 
        if (paramView.getTag() != null)
        {
          long l = ((Integer)paramView.getTag()).intValue();
          localObject = ((AvatarPendantManager)this.app.getManager(46)).gI();
          i = 0;
          if (i < ((List)localObject).size())
          {
            aqph localaqph = (aqph)((List)localObject).get(i);
            if ((localaqph != null) && (localaqph.ebe == l)) {
              if (localaqph.cVy) {
                break label1046;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              localaqph.cVy = bool;
              i += 1;
              break;
            }
          }
          this.jdField_a_of_type_Abdq.C((List)localObject, this.uC);
        }
        break;
      case 2131381213: 
        label1046:
        i = ((FrameLayout.LayoutParams)this.yM.getLayoutParams()).height;
        if ((this.jdField_a_of_type_Abdq != null) && (i != this.cef)) {
          cqK();
        }
        break;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    int i;
    label245:
    int j;
    label439:
    int k;
    label645:
    label657:
    label681:
    int m;
    int n;
    if (paramAdapterView.getId() == 2131372969)
    {
      if (((paramAdapterView instanceof GridView)) && (paramAdapterView.getTag() != null) && (paramView != null) && (paramView.getTag() != null))
      {
        this.vt.setVisibility(0);
        this.MW.setVisibility(8);
        this.hQ.setVisibility(0);
        this.eG.setVisibility(8);
        this.eF.setVisibility(0);
        this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.c.uin, 640, true, true, true, false, 7);
        cqQ();
        this.jdField_a_of_type_Aqpg = ((aqpg)((abdq.b.a)paramView.getTag()).jc.getTag());
        this.Ll = this.jdField_a_of_type_Aqpg.ebe;
        localObject = (AvatarPendantManager)this.app.getManager(46);
        List localList = ((AvatarPendantManager)localObject).gI();
        aqph localaqph1 = this.jdField_a_of_type_Aqph;
        aqph localaqph2 = (aqph)paramAdapterView.getTag();
        i = 0;
        if (i < localList.size())
        {
          aqph localaqph3 = (aqph)localList.get(i);
          if (localaqph3 != null)
          {
            if (localaqph3.ebe != localaqph2.ebe) {
              break label245;
            }
            localaqph3.pS = paramInt;
            this.jdField_a_of_type_Aqph = localaqph2;
          }
          for (;;)
          {
            i += 1;
            break;
            if ((localaqph1 != null) && (localaqph3.ebe == localaqph1.ebe)) {
              localaqph3.pS = -1;
            }
          }
        }
        this.jdField_a_of_type_Abdq.C(localList, this.uC);
        i = 3;
        if (!VE()) {
          break label439;
        }
        this.eF.setText(2131719633);
        this.eF.setEnabled(false);
        i = 4;
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088ED", "", 1, 0, 0, null, String.valueOf(i), String.valueOf(this.Ll));
        anot.a(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.jdField_a_of_type_Aqph.ebe), String.valueOf(this.Ll), "", "");
        if (this.jdField_a_of_type_Aqpg.type != 1) {
          break label657;
        }
        ((AvatarPendantManager)localObject).a(this.Ll).d(this.vt, 2, PendantInfo.ebS);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label681;
        }
        return;
        j = 0;
        int i1;
        switch (this.jdField_a_of_type_Aqpg.feeType)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          i1 = 1;
        }
        for (;;)
        {
          this.eF.setEnabled(true);
          if (i1 == 0) {
            break label645;
          }
          this.eF.setText(2131718801);
          i = 3;
          break;
          boolean bool = VipUtils.cf(this.app);
          i1 = bool;
          if (!bool)
          {
            j = 2131721801;
            i = 0;
            i1 = bool;
            continue;
            bool = VipUtils.ce(this.app);
            i1 = bool;
            if (!bool)
            {
              j = 2131720673;
              i = 1;
              i1 = bool;
              continue;
              i1 = 0;
              j = 2131689687;
              i = 2;
              continue;
              bool = VipUtils.cd(this.app);
              i1 = bool;
              if (!bool)
              {
                j = 2131690855;
                i = 5;
                i1 = bool;
              }
            }
          }
        }
        this.eF.setText(j);
        break;
        ((AvatarPendantManager)localObject).a(this.Ll).d(this.vt, 5, PendantInfo.ebS);
      }
      if ((this.cee == ceb) || (this.cee == cec))
      {
        paramAdapterView = (ViewGroup)paramAdapterView.getParent();
        localObject = (ViewGroup)paramAdapterView.getParent();
        i = paramAdapterView.getHeight();
        j = paramView.getHeight();
        k = aqcx.dip2px(this, 7.0F);
        if (!this.jdField_a_of_type_Aqph.cVy) {
          break label1241;
        }
        m = (this.jdField_a_of_type_Aqph.vN.size() - 1) / 4;
        if (paramInt != 0) {
          break label879;
        }
        paramInt = 0;
        n = aqcx.dip2px(this, 4.0F);
      }
    }
    label1241:
    for (paramInt = i - (m + 1 - paramInt) * (j + n) + n - k;; paramInt = i - j - k)
    {
      j = this.cef - this.ceg;
      i = ((ViewGroup)localObject).getTop();
      if (((ViewGroup)localObject).getTag() != null)
      {
        k = ((abdq.c)((ViewGroup)localObject).getTag()).position;
        if (i >= 0) {
          break label886;
        }
        i = paramInt;
        if (paramInt < 0) {
          i = 0 - paramInt;
        }
        this.G.setSelectionFromTop(k, j - i);
      }
      for (;;)
      {
        cqK();
        return;
        label879:
        paramInt /= 4;
        break;
        label886:
        if (paramInt + i < j) {
          this.G.setSelectionFromTop(k, j - paramInt);
        }
      }
      if (paramAdapterView.getId() != 2131375411) {
        break;
      }
      this.Ll = -1L;
      cqM();
      this.jdField_a_of_type_Aqpf = ((aqpf)((abdq.a.a)paramView.getTag()).jb.getTag());
      this.ceq = this.jdField_a_of_type_Aqpf.ebe;
      this.eG.setVisibility(0);
      this.MW.setVisibility(8);
      this.hQ.setVisibility(0);
      this.eF.setVisibility(8);
      cqR();
      this.jdField_b_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(this.ceq, 7, "large", ImageView.ScaleType.FIT_XY);
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentUin(), "widget", "head_click", "", 1, 0, 0, "", this.jdField_a_of_type_Aqpf.ebe + "", "");
      this.mEditor.putInt("ChooseFaceId", this.jdField_a_of_type_Aqpf.ebe);
      this.mEditor.apply();
      paramView = ((AvatarPendantManager)this.app.getManager(46)).gI();
      if (paramView.size() > 0) {
        this.jdField_a_of_type_Abdq.C(paramView, this.uC);
      }
      paramAdapterView = (ViewGroup)((ViewGroup)paramAdapterView.getParent()).getParent();
      if ((paramAdapterView.getTag() == null) || (!(paramAdapterView.getTag() instanceof abdq.c))) {
        break;
      }
      paramAdapterView = (abdq.c)paramAdapterView.getTag();
      paramInt = aqcx.dip2px(this, 100.0F);
      i = aqcx.dip2px(this, 20.0F);
      j = paramAdapterView.position;
      if (this.jdField_a_of_type_Aqpf.aFu()) {
        this.G.setSelectionFromTop(j, paramInt);
      }
      for (;;)
      {
        cqK();
        return;
        this.G.setSelectionFromTop(j, i);
      }
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    boolean bool3 = false;
    if (this.MW.getVisibility() == 0)
    {
      paramView = findViewById(2131381200);
      View localView = findViewById(2131379739);
      if (this.MW.getRight() > this.D.getLeft())
      {
        paramInt1 = 1;
        paramInt2 = paramView.getTop();
        paramInt3 = this.vt.getBottom();
        paramInt4 = this.xR.getTop();
        if (paramInt2 + paramInt3 <= localView.getTop() + paramInt4) {
          break label227;
        }
        paramInt2 = 1;
        label89:
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label232;
        }
      }
    }
    label227:
    label232:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (this.MX.getVisibility() == 0)
      {
        bool2 = bool3;
        if (this.yL.getBottom() > this.yM.getTop() + this.xR.getTop()) {
          bool2 = true;
        }
      }
      if ((bool1) || (bool2)) {
        ThreadManager.getUIHandler().post(new RemoveTips(bool1, bool2));
      }
      paramView = (RelativeLayout.LayoutParams)this.vu.getLayoutParams();
      paramInt1 = (int)(this.vt.getLayoutParams().width * 0.18D);
      paramView.width = paramInt1;
      paramView.height = paramInt1;
      this.vu.setLayoutParams(paramView);
      return;
      paramInt1 = 0;
      break;
      paramInt2 = 0;
      break label89;
    }
  }
  
  public int yo()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    int i = j;
    if (j == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i = super.getResources().getDimensionPixelSize(i);
      return i;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return j;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return j;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return j;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return j;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return j;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    return j;
  }
  
  public void zA(String paramString)
  {
    int j = 0;
    SystemClock.uptimeMillis();
    paramString = new File(paramString);
    aqgm.edF();
    if (paramString.exists()) {}
    for (;;)
    {
      int k;
      try
      {
        Object localObject1 = aqhq.readFileToString(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = new ArrayList();
        }
        JSONArray localJSONArray;
        int i;
        aqpf localaqpf;
        Object localObject2;
        String str;
        Object localObject3;
        i += 1;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          localJSONArray = ((JSONObject)localObject1).optJSONArray("avatarInPendantTable");
          i = 0;
          if (i < localJSONArray.length())
          {
            localaqpf = new aqpf();
            localObject2 = localJSONArray.optJSONObject(i);
            k = ((JSONObject)localObject2).optInt("id");
            str = ((JSONObject)localObject2).optString("type");
            localObject3 = ((JSONObject)localObject2).optJSONArray("baseInfo").optJSONObject(0);
            localObject2 = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).optJSONObject("smallImg").optString("src");
            localaqpf.setId(k);
            localaqpf.setName((String)localObject2);
            localaqpf.setType(str);
            localaqpf.setUrl((String)localObject3);
            k = j;
            if (j < 8)
            {
              paramString.add(localaqpf);
              k = j + 1;
            }
            if (i >= 4) {
              break label353;
            }
            localaqpf.cVu = true;
            break label353;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("avatarInPendantCount");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
            AvatarPendantManager.ebf = ((JSONArray)localObject1).optJSONObject(0).optInt("count");
          }
          localObject1 = (AvatarPendantManager)this.app.getManager(46);
          if (localObject1 != null)
          {
            ((AvatarPendantManager)localObject1).na(paramString);
            this.uC = paramString;
            this.aY.sendEmptyMessage(1000);
          }
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("AvatarPendantActivity", 2, "parse facedata shop config fail", paramString);
          return;
        }
        paramString = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AvatarPendantActivity", 2, "read config fail", paramString);
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label353:
      while (k != 8)
      {
        j = k;
        break;
      }
    }
  }
  
  /* Error */
  public void zB(String paramString)
  {
    // Byte code:
    //   0: invokestatic 2243	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: new 604	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 624	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: invokestatic 2246	aqgm:edF	()V
    //   17: aload_1
    //   18: invokevirtual 627	java/io/File:exists	()Z
    //   21: ifeq +247 -> 268
    //   24: aload_1
    //   25: invokestatic 2252	aqhq:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   28: astore 12
    //   30: aload 12
    //   32: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +233 -> 268
    //   38: aload_0
    //   39: getfield 532	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: bipush 46
    //   44: invokevirtual 786	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   47: checkcast 788	com/tencent/mobileqq/vas/AvatarPendantManager
    //   50: invokevirtual 841	com/tencent/mobileqq/vas/AvatarPendantManager:gI	()Ljava/util/List;
    //   53: astore 11
    //   55: new 1569	org/json/JSONObject
    //   58: dup
    //   59: aload 12
    //   61: invokespecial 1570	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   64: astore 12
    //   66: aload 12
    //   68: ldc_w 2327
    //   71: invokevirtual 2330	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   74: ifeq +155 -> 229
    //   77: aload 12
    //   79: ldc_w 2327
    //   82: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   85: iconst_1
    //   86: if_icmpne +137 -> 223
    //   89: iconst_1
    //   90: istore 10
    //   92: iload 10
    //   94: putstatic 2335	com/tencent/mobileqq/vas/AvatarPendantManager:cVx	Z
    //   97: aload 12
    //   99: ldc_w 2337
    //   102: invokevirtual 2340	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   105: astore 15
    //   107: new 2342	java/util/HashSet
    //   110: dup
    //   111: invokespecial 2343	java/util/HashSet:<init>	()V
    //   114: astore 13
    //   116: aload 15
    //   118: ldc_w 2345
    //   121: invokevirtual 2330	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   124: ifeq +200 -> 324
    //   127: aload 15
    //   129: ldc_w 2345
    //   132: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 14
    //   137: aload 14
    //   139: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +182 -> 324
    //   145: aload 14
    //   147: ldc_w 2347
    //   150: invokevirtual 760	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore 14
    //   155: aload 14
    //   157: arraylength
    //   158: istore_3
    //   159: iconst_0
    //   160: istore_2
    //   161: iload_2
    //   162: iload_3
    //   163: if_icmpge +161 -> 324
    //   166: aload 14
    //   168: iload_2
    //   169: aaload
    //   170: astore 16
    //   172: aload 16
    //   174: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +14 -> 191
    //   180: aload 13
    //   182: aload 16
    //   184: invokestatic 1502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   187: invokevirtual 2348	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: iload_2
    //   192: iconst_1
    //   193: iadd
    //   194: istore_2
    //   195: goto -34 -> 161
    //   198: astore_1
    //   199: invokestatic 711	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +14 -> 216
    //   205: ldc_w 713
    //   208: iconst_2
    //   209: ldc_w 2318
    //   212: aload_1
    //   213: invokestatic 2321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: return
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 2322	java/io/IOException:printStackTrace	()V
    //   222: return
    //   223: iconst_0
    //   224: istore 10
    //   226: goto -134 -> 92
    //   229: iconst_0
    //   230: putstatic 2335	com/tencent/mobileqq/vas/AvatarPendantManager:cVx	Z
    //   233: goto -136 -> 97
    //   236: astore 12
    //   238: aload 11
    //   240: invokeinterface 852 1 0
    //   245: aload_1
    //   246: invokevirtual 2351	java/io/File:delete	()Z
    //   249: pop
    //   250: invokestatic 711	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +15 -> 268
    //   256: ldc_w 713
    //   259: iconst_2
    //   260: ldc_w 2353
    //   263: aload 12
    //   265: invokestatic 2321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: invokestatic 2243	android/os/SystemClock:uptimeMillis	()J
    //   271: lstore 8
    //   273: invokestatic 711	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq -60 -> 216
    //   279: ldc_w 713
    //   282: iconst_2
    //   283: new 606	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 607	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 2355
    //   293: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: lload 8
    //   298: lload 6
    //   300: lsub
    //   301: invokevirtual 1146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: ldc_w 2357
    //   307: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 2359	java/io/File:length	()J
    //   314: invokevirtual 1146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: invokevirtual 621	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 1085	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: return
    //   324: new 2342	java/util/HashSet
    //   327: dup
    //   328: invokespecial 2343	java/util/HashSet:<init>	()V
    //   331: astore 14
    //   333: aload 15
    //   335: ldc_w 2361
    //   338: invokevirtual 2330	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   341: ifeq +70 -> 411
    //   344: aload 15
    //   346: ldc_w 2361
    //   349: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 16
    //   354: aload 16
    //   356: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifne +52 -> 411
    //   362: aload 16
    //   364: ldc_w 2347
    //   367: invokevirtual 760	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   370: astore 16
    //   372: aload 16
    //   374: arraylength
    //   375: istore_3
    //   376: iconst_0
    //   377: istore_2
    //   378: iload_2
    //   379: iload_3
    //   380: if_icmpge +31 -> 411
    //   383: aload 16
    //   385: iload_2
    //   386: aaload
    //   387: astore 17
    //   389: aload 17
    //   391: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifne +933 -> 1327
    //   397: aload 14
    //   399: aload 17
    //   401: invokestatic 1502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   404: invokevirtual 2348	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   407: pop
    //   408: goto +919 -> 1327
    //   411: new 2342	java/util/HashSet
    //   414: dup
    //   415: invokespecial 2343	java/util/HashSet:<init>	()V
    //   418: astore 16
    //   420: aload 15
    //   422: ldc_w 2363
    //   425: invokevirtual 2330	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   428: ifeq +70 -> 498
    //   431: aload 15
    //   433: ldc_w 2363
    //   436: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: astore 15
    //   441: aload 15
    //   443: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   446: ifne +52 -> 498
    //   449: aload 15
    //   451: ldc_w 2347
    //   454: invokevirtual 760	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   457: astore 15
    //   459: aload 15
    //   461: arraylength
    //   462: istore_3
    //   463: iconst_0
    //   464: istore_2
    //   465: iload_2
    //   466: iload_3
    //   467: if_icmpge +31 -> 498
    //   470: aload 15
    //   472: iload_2
    //   473: aaload
    //   474: astore 17
    //   476: aload 17
    //   478: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +853 -> 1334
    //   484: aload 16
    //   486: aload 17
    //   488: invokestatic 1502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   491: invokevirtual 2348	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   494: pop
    //   495: goto +839 -> 1334
    //   498: new 2365	android/util/SparseArray
    //   501: dup
    //   502: invokespecial 2366	android/util/SparseArray:<init>	()V
    //   505: astore 15
    //   507: aload 12
    //   509: ldc_w 2368
    //   512: invokevirtual 2340	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   515: astore 17
    //   517: aload 17
    //   519: invokevirtual 2372	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   522: astore 18
    //   524: aload 18
    //   526: invokeinterface 2377 1 0
    //   531: ifeq +378 -> 909
    //   534: aload 18
    //   536: invokeinterface 2380 1 0
    //   541: invokevirtual 2226	java/lang/Object:toString	()Ljava/lang/String;
    //   544: astore 19
    //   546: aload 19
    //   548: ifnull -24 -> 524
    //   551: aload 17
    //   553: aload 19
    //   555: invokevirtual 2340	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   558: astore 20
    //   560: aload 20
    //   562: ldc_w 2382
    //   565: invokevirtual 2340	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   568: astore 21
    //   570: aload 21
    //   572: ldc_w 2384
    //   575: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   578: ifeq -54 -> 524
    //   581: aload 21
    //   583: ldc_w 2386
    //   586: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokestatic 2391	com/tencent/common/config/AppSetting:bs	(Ljava/lang/String;)I
    //   592: iflt -68 -> 524
    //   595: new 2067	aqpg
    //   598: dup
    //   599: invokespecial 2392	aqpg:<init>	()V
    //   602: astore 19
    //   604: aload 19
    //   606: aload 21
    //   608: ldc_w 2393
    //   611: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   614: putfield 2080	aqpg:feeType	I
    //   617: aload 19
    //   619: aload 21
    //   621: ldc_w 2395
    //   624: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   627: putfield 2397	aqpg:limitFree	I
    //   630: aload 19
    //   632: aload 21
    //   634: ldc_w 2399
    //   637: invokevirtual 2403	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   640: putfield 2406	aqpg:aty	J
    //   643: aload 19
    //   645: aload 21
    //   647: ldc_w 2408
    //   650: invokevirtual 2403	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   653: putfield 2411	aqpg:atz	J
    //   656: aload 20
    //   658: ldc_w 2277
    //   661: invokevirtual 2340	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   664: astore 20
    //   666: aload 19
    //   668: aload 20
    //   670: ldc_w 2272
    //   673: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   676: putfield 2077	aqpg:type	I
    //   679: aload 19
    //   681: aload 20
    //   683: ldc_w 2278
    //   686: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   689: putfield 2413	aqpg:name	Ljava/lang/String;
    //   692: aload 19
    //   694: aload 20
    //   696: ldc_w 2415
    //   699: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   702: putfield 2418	aqpg:cuE	Ljava/lang/String;
    //   705: aload 19
    //   707: aload 20
    //   709: ldc_w 2268
    //   712: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   715: invokestatic 1502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   718: invokevirtual 1505	java/lang/Integer:intValue	()I
    //   721: putfield 2070	aqpg:ebe	I
    //   724: aload 20
    //   726: ldc_w 2420
    //   729: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   732: iconst_1
    //   733: if_icmpne +608 -> 1341
    //   736: iconst_1
    //   737: istore 10
    //   739: aload 19
    //   741: iload 10
    //   743: putfield 2422	aqpg:isLink	Z
    //   746: aload 19
    //   748: aload 20
    //   750: ldc_w 2424
    //   753: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: putfield 2427	aqpg:cuD	Ljava/lang/String;
    //   759: aload 13
    //   761: aload 19
    //   763: getfield 2070	aqpg:ebe	I
    //   766: invokestatic 2430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   769: invokevirtual 2433	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   772: ifeq +91 -> 863
    //   775: aload 19
    //   777: bipush 7
    //   779: putfield 2436	aqpg:ebg	I
    //   782: invokestatic 2441	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   785: lstore 8
    //   787: aload 19
    //   789: getfield 2080	aqpg:feeType	I
    //   792: iconst_1
    //   793: if_icmpne +96 -> 889
    //   796: aload 19
    //   798: getfield 2406	aqpg:aty	J
    //   801: lload 8
    //   803: lcmp
    //   804: ifgt +85 -> 889
    //   807: lload 8
    //   809: aload 19
    //   811: getfield 2411	aqpg:atz	J
    //   814: lcmp
    //   815: ifgt +74 -> 889
    //   818: aload 19
    //   820: bipush 10
    //   822: putfield 2444	aqpg:ebh	I
    //   825: aload 16
    //   827: aload 19
    //   829: getfield 2070	aqpg:ebe	I
    //   832: invokestatic 2430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   835: invokevirtual 2433	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   838: ifeq +10 -> 848
    //   841: aload 19
    //   843: bipush 9
    //   845: putfield 2444	aqpg:ebh	I
    //   848: aload 15
    //   850: aload 19
    //   852: getfield 2070	aqpg:ebe	I
    //   855: aload 19
    //   857: invokevirtual 2447	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   860: goto -336 -> 524
    //   863: aload 14
    //   865: aload 19
    //   867: getfield 2070	aqpg:ebe	I
    //   870: invokestatic 2430	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   873: invokevirtual 2433	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   876: ifeq -94 -> 782
    //   879: aload 19
    //   881: bipush 8
    //   883: putfield 2436	aqpg:ebg	I
    //   886: goto -104 -> 782
    //   889: aload 19
    //   891: getfield 2080	aqpg:feeType	I
    //   894: bipush 6
    //   896: if_icmpne -71 -> 825
    //   899: aload 19
    //   901: bipush 6
    //   903: putfield 2444	aqpg:ebh	I
    //   906: goto -81 -> 825
    //   909: aload 11
    //   911: invokeinterface 852 1 0
    //   916: aload 12
    //   918: ldc_w 2449
    //   921: invokevirtual 2452	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   924: astore 13
    //   926: aload 13
    //   928: invokevirtual 2261	org/json/JSONArray:length	()I
    //   931: istore 4
    //   933: iconst_0
    //   934: istore_2
    //   935: iload_2
    //   936: iload 4
    //   938: if_icmpge +336 -> 1274
    //   941: aload 13
    //   943: iload_2
    //   944: invokevirtual 2453	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   947: checkcast 1569	org/json/JSONObject
    //   950: astore 14
    //   952: aload 14
    //   954: ldc_w 2384
    //   957: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   960: ifne +6 -> 966
    //   963: goto +384 -> 1347
    //   966: aload 14
    //   968: ldc_w 2455
    //   971: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   974: astore 17
    //   976: aload 17
    //   978: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   981: ifne +366 -> 1347
    //   984: aload 14
    //   986: ldc_w 2457
    //   989: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   992: bipush 100
    //   994: if_icmpge +353 -> 1347
    //   997: new 1781	aqph
    //   1000: dup
    //   1001: invokespecial 2458	aqph:<init>	()V
    //   1004: astore 16
    //   1006: aload 16
    //   1008: new 868	java/util/ArrayList
    //   1011: dup
    //   1012: invokespecial 869	java/util/ArrayList:<init>	()V
    //   1015: putfield 2115	aqph:vN	Ljava/util/List;
    //   1018: aload 17
    //   1020: ldc_w 2347
    //   1023: invokevirtual 760	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1026: astore 17
    //   1028: aload 17
    //   1030: arraylength
    //   1031: istore 5
    //   1033: iconst_0
    //   1034: istore_3
    //   1035: iload_3
    //   1036: iload 5
    //   1038: if_icmpge +56 -> 1094
    //   1041: aload 17
    //   1043: iload_3
    //   1044: aaload
    //   1045: astore 18
    //   1047: aload 18
    //   1049: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1052: ifne +302 -> 1354
    //   1055: aload 15
    //   1057: aload 18
    //   1059: invokestatic 1502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1062: invokevirtual 1505	java/lang/Integer:intValue	()I
    //   1065: invokevirtual 2459	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1068: checkcast 2067	aqpg
    //   1071: astore 18
    //   1073: aload 18
    //   1075: ifnull +279 -> 1354
    //   1078: aload 16
    //   1080: getfield 2115	aqph:vN	Ljava/util/List;
    //   1083: aload 18
    //   1085: invokeinterface 897 2 0
    //   1090: pop
    //   1091: goto +263 -> 1354
    //   1094: aload 16
    //   1096: getfield 2115	aqph:vN	Ljava/util/List;
    //   1099: invokeinterface 582 1 0
    //   1104: ifle +243 -> 1347
    //   1107: aload 16
    //   1109: aload 14
    //   1111: ldc_w 2457
    //   1114: invokevirtual 2332	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1117: putfield 2011	aqph:ebe	I
    //   1120: aload 16
    //   1122: aload 14
    //   1124: ldc_w 2461
    //   1127: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1130: putfield 2464	aqph:cuF	Ljava/lang/String;
    //   1133: aload 14
    //   1135: ldc_w 2466
    //   1138: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1141: invokestatic 706	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1144: ifne +121 -> 1265
    //   1147: aload 16
    //   1149: aload 14
    //   1151: ldc_w 2466
    //   1154: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1157: invokestatic 1502	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1160: invokevirtual 1505	java/lang/Integer:intValue	()I
    //   1163: putfield 2468	aqph:tag	I
    //   1166: aload 16
    //   1168: aload 14
    //   1170: ldc_w 2424
    //   1173: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1176: putfield 2469	aqph:cuD	Ljava/lang/String;
    //   1179: aload 16
    //   1181: aload 14
    //   1183: ldc_w 2471
    //   1186: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1189: putfield 2474	aqph:cuG	Ljava/lang/String;
    //   1192: aload 16
    //   1194: aload 14
    //   1196: ldc_w 2476
    //   1199: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1202: putfield 2478	aqph:subtitle	Ljava/lang/String;
    //   1205: aload 16
    //   1207: aload 14
    //   1209: ldc_w 2278
    //   1212: invokevirtual 1574	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1215: putfield 2479	aqph:name	Ljava/lang/String;
    //   1218: aload 16
    //   1220: iconst_m1
    //   1221: putfield 1784	aqph:pS	I
    //   1224: aload 16
    //   1226: getfield 2474	aqph:cuG	Ljava/lang/String;
    //   1229: ifnull +23 -> 1252
    //   1232: aload 16
    //   1234: getfield 2474	aqph:cuG	Ljava/lang/String;
    //   1237: ldc_w 321
    //   1240: invokevirtual 1338	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1243: ifne +9 -> 1252
    //   1246: aload 16
    //   1248: iconst_1
    //   1249: putfield 2046	aqph:cVy	Z
    //   1252: aload 11
    //   1254: aload 16
    //   1256: invokeinterface 897 2 0
    //   1261: pop
    //   1262: goto +85 -> 1347
    //   1265: aload 16
    //   1267: iconst_0
    //   1268: putfield 2468	aqph:tag	I
    //   1271: goto -105 -> 1166
    //   1274: aload 12
    //   1276: invokestatic 2485	zpo:parseConfig	(Lorg/json/JSONObject;)V
    //   1279: aload_0
    //   1280: getfield 1648	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:aY	Landroid/os/Handler;
    //   1283: sipush 1000
    //   1286: invokevirtual 2316	android/os/Handler:sendEmptyMessage	(I)Z
    //   1289: pop
    //   1290: aload_0
    //   1291: getfield 532	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1294: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1297: ldc_w 843
    //   1300: iconst_0
    //   1301: invokevirtual 675	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1304: invokeinterface 687 1 0
    //   1309: ldc_w 843
    //   1312: iconst_0
    //   1313: invokeinterface 691 3 0
    //   1318: invokeinterface 694 1 0
    //   1323: pop
    //   1324: goto -1056 -> 268
    //   1327: iload_2
    //   1328: iconst_1
    //   1329: iadd
    //   1330: istore_2
    //   1331: goto -953 -> 378
    //   1334: iload_2
    //   1335: iconst_1
    //   1336: iadd
    //   1337: istore_2
    //   1338: goto -873 -> 465
    //   1341: iconst_0
    //   1342: istore 10
    //   1344: goto -605 -> 739
    //   1347: iload_2
    //   1348: iconst_1
    //   1349: iadd
    //   1350: istore_2
    //   1351: goto -416 -> 935
    //   1354: iload_3
    //   1355: iconst_1
    //   1356: iadd
    //   1357: istore_3
    //   1358: goto -323 -> 1035
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1361	0	this	AvatarPendantActivity
    //   0	1361	1	paramString	String
    //   160	1191	2	i	int
    //   158	1200	3	j	int
    //   931	8	4	k	int
    //   1031	8	5	m	int
    //   3	296	6	l1	long
    //   271	537	8	l2	long
    //   90	1253	10	bool	boolean
    //   53	1200	11	localList	List
    //   28	70	12	localObject1	Object
    //   236	1039	12	localException	Exception
    //   114	828	13	localObject2	Object
    //   135	1073	14	localObject3	Object
    //   105	951	15	localObject4	Object
    //   170	1096	16	localObject5	Object
    //   387	655	17	localObject6	Object
    //   522	562	18	localObject7	Object
    //   544	356	19	localObject8	Object
    //   558	191	20	localJSONObject1	JSONObject
    //   568	78	21	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	30	198	java/lang/OutOfMemoryError
    //   24	30	217	java/io/IOException
    //   55	89	236	java/lang/Exception
    //   92	97	236	java/lang/Exception
    //   97	159	236	java/lang/Exception
    //   172	191	236	java/lang/Exception
    //   229	233	236	java/lang/Exception
    //   324	376	236	java/lang/Exception
    //   389	408	236	java/lang/Exception
    //   411	463	236	java/lang/Exception
    //   476	495	236	java/lang/Exception
    //   498	524	236	java/lang/Exception
    //   524	546	236	java/lang/Exception
    //   551	736	236	java/lang/Exception
    //   739	782	236	java/lang/Exception
    //   782	825	236	java/lang/Exception
    //   825	848	236	java/lang/Exception
    //   848	860	236	java/lang/Exception
    //   863	886	236	java/lang/Exception
    //   889	906	236	java/lang/Exception
    //   909	933	236	java/lang/Exception
    //   941	963	236	java/lang/Exception
    //   966	1033	236	java/lang/Exception
    //   1047	1073	236	java/lang/Exception
    //   1078	1091	236	java/lang/Exception
    //   1094	1166	236	java/lang/Exception
    //   1166	1252	236	java/lang/Exception
    //   1252	1262	236	java/lang/Exception
    //   1265	1271	236	java/lang/Exception
    //   1274	1324	236	java/lang/Exception
  }
  
  public static class ConfacefigParser
    implements Runnable
  {
    private String bax;
    private WeakReference<AvatarPendantActivity> co;
    
    public ConfacefigParser(String paramString, AvatarPendantActivity paramAvatarPendantActivity)
    {
      this.bax = paramString;
      this.co = new WeakReference(paramAvatarPendantActivity);
    }
    
    public void run()
    {
      AvatarPendantActivity localAvatarPendantActivity = (AvatarPendantActivity)this.co.get();
      if (localAvatarPendantActivity != null) {
        localAvatarPendantActivity.zA(this.bax);
      }
    }
  }
  
  public static class ConfigParser
    implements Runnable
  {
    private String bax;
    private WeakReference<AvatarPendantActivity> co;
    
    public ConfigParser(String paramString, AvatarPendantActivity paramAvatarPendantActivity)
    {
      this.bax = paramString;
      this.co = new WeakReference(paramAvatarPendantActivity);
    }
    
    public void run()
    {
      AvatarPendantActivity localAvatarPendantActivity = (AvatarPendantActivity)this.co.get();
      if (localAvatarPendantActivity != null) {
        localAvatarPendantActivity.zB(this.bax);
      }
    }
  }
  
  class IconRunnable
    implements Runnable
  {
    WeakReference<aquy> eF;
    WeakReference<QQAppInterface> eG;
    
    IconRunnable(aquy paramaquy, QQAppInterface paramQQAppInterface)
    {
      this.eF = new WeakReference(paramaquy);
      this.eG = new WeakReference(paramQQAppInterface);
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
      }
      if ((this.eG.get() != null) && (this.eF.get() != null))
      {
        aqvc localaqvc = ((aqva)((QQAppInterface)this.eG.get()).getManager(47)).a(1);
        if (localaqvc.a(aqgm.csT) == null)
        {
          Object localObject = new File(aqgm.csU + "/icon.zip");
          localObject = new aquz(aqgm.csT, (File)localObject);
          ((aquz)localObject).cWy = false;
          Bundle localBundle = new Bundle();
          localaqvc.a((aquz)localObject, (aquy)this.eF.get(), localBundle);
        }
      }
    }
  }
  
  class RemoveTips
    implements Runnable
  {
    private boolean bsh;
    private boolean bsi;
    
    public RemoveTips(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.bsh = paramBoolean1;
      this.bsi = paramBoolean2;
    }
    
    public void run()
    {
      if (this.bsi) {
        AvatarPendantActivity.this.MX.setVisibility(8);
      }
      if (this.bsh) {
        AvatarPendantActivity.this.MW.setVisibility(8);
      }
    }
  }
  
  public static class a
  {
    public int ahj;
    public int cet;
    public int ceu;
    public int cev;
    public int cew;
    public int cex;
    public int playTime = 600;
  }
  
  public class b
    implements AbsListView.e
  {
    public b() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (paramInt == 0) {
        ((AvatarPendantManager)AvatarPendantActivity.this.app.getManager(46)).a(AvatarPendantActivity.this.Ll).setPause(false);
      }
      for (;;)
      {
        AvatarPendantActivity.this.mScrollState = paramInt;
        if (paramInt != 0) {
          break label127;
        }
        if (!AvatarPendantActivity.this.a.scrolling) {
          break;
        }
        AvatarPendantActivity.this.G.postDelayed(new AvatarPendantActivity.AnimationScrollListener.1(this), 80L);
        return;
        ((AvatarPendantManager)AvatarPendantActivity.this.app.getManager(46)).a(AvatarPendantActivity.this.Ll).setPause(true);
      }
      URLDrawable.resume();
      AvatarPendantActivity.this.a.notifyDataSetChanged();
      return;
      label127:
      URLDrawable.pause();
      AvatarPendantActivity.this.a.scrolling = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity
 * JD-Core Version:    0.7.0.1
 */