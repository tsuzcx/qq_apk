package com.tencent.mobileqq.apollo.store.openbox;

import abtn;
import abtn.a;
import abud;
import abud.a;
import abud.b;
import abue;
import abuf;
import abug;
import abug.a;
import abuh;
import abui;
import abxi;
import acej;
import acfp;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqgz;
import aqhu;
import aqiw;
import aquy;
import aquz;
import aqva;
import aqvc;
import arwv;
import auru;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(11)
public class ApolloCardWindow
  extends RelativeLayout
  implements abug.a, abuh, Handler.Callback, View.OnClickListener, MultilScreenlLayout.a
{
  private static boolean bFF;
  private static final String bhR = acfp.m(2131702459);
  private static final String bhS = acfp.m(2131702448);
  public static Map<String, Drawable> jc = new HashMap();
  static float sM;
  static float sN;
  private TextView Qc;
  private TextView Qd;
  private TextView Qe;
  private TextView Qf;
  private TextView Qg;
  private TextView Qh;
  private TextView Qi;
  private TextView Qj;
  private TextView Qk;
  private abud jdField_a_of_type_Abud;
  private abug jdField_a_of_type_Abug;
  private a jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$a;
  private ApolloOpenBoxView jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView;
  private OpeningCardGroup jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup;
  private RoundRectLinearLayout jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout;
  private int aur;
  private RoundRectLinearLayout b;
  private boolean bFG;
  private boolean bFH;
  private boolean bFI;
  private boolean bFJ;
  private String bhD;
  private String bhT;
  aqvc c;
  private int csq;
  private int csr;
  private int css;
  private int cst;
  private int csu;
  private int csv;
  private int csw;
  private auru e;
  Runnable fE = new ApolloCardWindow.3(this);
  private LinearLayout ij;
  private LinearLayout ik;
  private float jM;
  private float jN;
  aquy m = new abuf(this);
  private WeakReference<AppInterface> mAppRef;
  private int mCardHeight;
  private int mCardWidth;
  private Context mContext;
  private String mCurrentUin;
  private String mFrom;
  private ImageView mLoadingView;
  private int mTouchSlop;
  ScaleAnimation o;
  ScaleAnimation p;
  AnimationSet v;
  private List<ApolloCardLayout> wz = new ArrayList();
  private AlphaAnimation x;
  private ImageView xI;
  private ImageView xJ;
  private ImageView xK;
  private ImageView xL;
  private ImageView xM;
  private ImageView xN;
  private ImageView xO;
  private ImageView xP;
  private AlphaAnimation y;
  private long zl;
  
  public ApolloCardWindow(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
    this.c = new aqva(BaseApplicationImpl.getApplication().getRuntime()).a(3);
    ThreadManager.post(this.fE, 10, null, true);
  }
  
  private void cFe()
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation1.setInterpolator(new AccelerateDecelerateInterpolator());
    localScaleAnimation1.setDuration(100L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 0.6666667F, 1.0F, 0.6666667F, 1, 0.5F, 1, 1.0F);
    localScaleAnimation2.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation2.setDuration(100L);
    localScaleAnimation2.setStartOffset(100L);
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    this.xK.startAnimation(localAnimationSet);
  }
  
  public static void cFt()
  {
    sM = acej.aV() / 16.0F;
    if (sM == 0.0F) {
      sM = 1.0F;
    }
    sN = aqgz.getDesity() / sM;
    if (sN == 0.0F) {
      sN = aqgz.getDesity();
    }
  }
  
  private void cFu()
  {
    if ((this.jdField_a_of_type_Abud == null) || (this.jdField_a_of_type_Abud.mItems == null) || (this.jdField_a_of_type_Abud.mItems.isEmpty())) {
      return;
    }
    Object localObject1;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Abud.bhK))
    {
      localObject1 = "";
      label50:
      if ((TextUtils.isEmpty(this.mCurrentUin)) || (!this.mCurrentUin.equals(this.jdField_a_of_type_Abud.bhD))) {
        break label1753;
      }
      localObject1 = acfp.m(2131702455);
    }
    label300:
    label455:
    label587:
    label600:
    label1753:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      label224:
      label376:
      int i;
      if (this.jdField_a_of_type_Abud.wx.size() == 3)
      {
        this.xO.setVisibility(0);
        this.Qk.setVisibility(0);
        this.xM.setVisibility(0);
        this.Qj.setVisibility(0);
        this.xI.setVisibility(0);
        this.Qe.setVisibility(0);
        localObject2 = (abud.b)this.jdField_a_of_type_Abud.wx.get(2);
        if (localObject2 != null)
        {
          if (!TextUtils.isEmpty(((abud.b)localObject2).mIconUrl))
          {
            localObject3 = abtn.a(Utils.Crc64String(((abud.b)localObject2).mIconUrl), null, ((abud.b)localObject2).mIconUrl);
            this.xO.setImageDrawable((Drawable)localObject3);
          }
          if (((abud.b)localObject2).cso == 7) {
            this.Qk.setTextColor(-31676);
          }
        }
        else
        {
          localObject2 = (abud.b)this.jdField_a_of_type_Abud.wx.get(1);
          if (localObject2 != null)
          {
            if (!TextUtils.isEmpty(((abud.b)localObject2).mIconUrl))
            {
              localObject3 = abtn.a(Utils.Crc64String(((abud.b)localObject2).mIconUrl), null, ((abud.b)localObject2).mIconUrl);
              this.xM.setImageDrawable((Drawable)localObject3);
            }
            if (((abud.b)localObject2).cso != 7) {
              break label587;
            }
            this.Qj.setTextColor(-31676);
          }
          localObject2 = (abud.b)this.jdField_a_of_type_Abud.wx.get(0);
          if (localObject2 != null)
          {
            if (!TextUtils.isEmpty(((abud.b)localObject2).mIconUrl))
            {
              localObject3 = abtn.a(Utils.Crc64String(((abud.b)localObject2).mIconUrl), null, ((abud.b)localObject2).mIconUrl);
              this.xI.setImageDrawable((Drawable)localObject3);
            }
            if (((abud.b)localObject2).cso != 7) {
              break label600;
            }
            this.Qe.setTextColor(-31676);
          }
          if (this.jdField_a_of_type_Abud.csg != -1) {
            super.setBackgroundColor(this.jdField_a_of_type_Abud.csg);
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.removeAllViews();
          if ((this.jdField_a_of_type_Abud.Ow == 0L) && (this.jdField_a_of_type_Abud.zl != -501031L) && (this.jdField_a_of_type_Abud.zl != -501027L)) {
            break label1243;
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
          i = 0;
          if (i >= this.jdField_a_of_type_Abud.mItems.size()) {
            break label1020;
          }
          if (this.wz.size() <= i) {
            break label1748;
          }
          localObject1 = (ApolloCardLayout)this.wz.get(i);
          ((ApolloCardLayout)localObject1).clearAnimation();
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new ApolloCardLayout(this.mContext);
          this.wz.add(localObject2);
        }
        localObject1 = new FrameLayout.LayoutParams(this.mCardWidth, this.mCardHeight);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        i += 1;
        break label455;
        localObject1 = this.jdField_a_of_type_Abud.bhK;
        break label50;
        this.Qk.setTextColor(-16777216);
        break label224;
        this.Qj.setTextColor(-16777216);
        break label300;
        this.Qe.setTextColor(-16777216);
        break label376;
        if (this.jdField_a_of_type_Abud.wx.size() == 2)
        {
          this.xO.setVisibility(8);
          this.Qk.setVisibility(8);
          this.xM.setVisibility(0);
          this.Qj.setVisibility(0);
          this.xI.setVisibility(0);
          this.Qe.setVisibility(0);
          localObject2 = (abud.b)this.jdField_a_of_type_Abud.wx.get(1);
          if (localObject2 != null)
          {
            if (!TextUtils.isEmpty(((abud.b)localObject2).mIconUrl))
            {
              localObject3 = abtn.a(Utils.Crc64String(((abud.b)localObject2).mIconUrl), null, ((abud.b)localObject2).mIconUrl);
              this.xM.setImageDrawable((Drawable)localObject3);
            }
            if (((abud.b)localObject2).cso != 7) {
              break label834;
            }
            this.Qj.setTextColor(-31676);
          }
          for (;;)
          {
            localObject2 = (abud.b)this.jdField_a_of_type_Abud.wx.get(0);
            if (localObject2 == null) {
              break;
            }
            if (!TextUtils.isEmpty(((abud.b)localObject2).mIconUrl))
            {
              localObject3 = abtn.a(Utils.Crc64String(((abud.b)localObject2).mIconUrl), null, ((abud.b)localObject2).mIconUrl);
              this.xI.setImageDrawable((Drawable)localObject3);
            }
            if (((abud.b)localObject2).cso != 7) {
              break label847;
            }
            this.Qe.setTextColor(-31676);
            break;
            this.Qj.setTextColor(-16777216);
          }
          this.Qe.setTextColor(-16777216);
          break label376;
        }
        if (this.jdField_a_of_type_Abud.wx.size() != 1) {
          break label376;
        }
        this.xO.setVisibility(8);
        this.Qk.setVisibility(8);
        this.xM.setVisibility(8);
        this.Qj.setVisibility(8);
        this.xI.setVisibility(0);
        this.Qe.setVisibility(0);
        localObject2 = (abud.b)this.jdField_a_of_type_Abud.wx.get(0);
        if (localObject2 == null) {
          break label376;
        }
        if (!TextUtils.isEmpty(((abud.b)localObject2).mIconUrl))
        {
          localObject3 = abtn.a(Utils.Crc64String(((abud.b)localObject2).mIconUrl), null, ((abud.b)localObject2).mIconUrl);
          this.xI.setImageDrawable((Drawable)localObject3);
        }
        if (((abud.b)localObject2).cso == 7)
        {
          this.Qe.setTextColor(-31676);
          break label376;
        }
        this.Qe.setTextColor(-16777216);
        break label376;
        label1020:
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.mCardWidth, this.mCardHeight, this.jdField_a_of_type_Abud);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setCurrentFrame(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.requestLayout();
        this.ij.setVisibility(0);
        this.b.setVisibility(0);
        this.bFH = true;
        if (this.jdField_a_of_type_Abud.wx.size() > 0) {
          this.Qe.setText(abud.dl(((abud.b)this.jdField_a_of_type_Abud.wx.get(0)).csp));
        }
        if (this.jdField_a_of_type_Abud.wx.size() > 1) {
          this.Qj.setText(abud.dk(((abud.b)this.jdField_a_of_type_Abud.wx.get(1)).csp));
        }
        if (this.jdField_a_of_type_Abud.wx.size() > 2) {
          this.Qk.setText(abud.dj(((abud.b)this.jdField_a_of_type_Abud.wx.get(2)).csp));
        }
        if ((this.jdField_a_of_type_Abud.Ow != -501027L) && (this.zl != -501027L)) {
          break;
        }
        this.Qi.setVisibility(0);
        return;
        label1243:
        AbstractGifImage.pauseAll();
        this.Qg.setText(acfp.m(2131702452) + (String)localObject1 + acfp.m(2131702453));
        this.Qg.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(0);
        if (this.jdField_a_of_type_Abud.wx.size() > 0) {
          this.Qe.setText(abud.dl(((abud.b)this.jdField_a_of_type_Abud.wx.get(0)).csp - ((abud.b)this.jdField_a_of_type_Abud.wx.get(0)).csh));
        }
        if (this.jdField_a_of_type_Abud.wx.size() > 1) {
          this.Qj.setText(abud.dk(((abud.b)this.jdField_a_of_type_Abud.wx.get(1)).csp - ((abud.b)this.jdField_a_of_type_Abud.wx.get(1)).csh));
        }
        if (this.jdField_a_of_type_Abud.wx.size() > 2) {
          this.Qk.setText(abud.dj(((abud.b)this.jdField_a_of_type_Abud.wx.get(2)).csp - ((abud.b)this.jdField_a_of_type_Abud.wx.get(2)).csh));
        }
        if ((this.jdField_a_of_type_Abud.Ow == -501027L) || (this.zl == -501027L)) {
          this.Qi.setVisibility(0);
        }
        localObject3 = new ArrayList();
        i = 0;
        if (i < this.jdField_a_of_type_Abud.mItems.size())
        {
          if (this.wz.size() <= i) {
            break label1743;
          }
          localObject1 = (ApolloCardLayout)this.wz.get(i);
          ((ApolloCardLayout)localObject1).clearAnimation();
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ApolloCardLayout(this.mContext);
            this.wz.add(localObject2);
          }
          ((List)localObject3).add(localObject2);
          localObject1 = (abud.a)this.jdField_a_of_type_Abud.mItems.get(i);
          if ((localObject1 != null) && (((abud.a)localObject1).O == 15)) {
            VipUtils.a(null, "cmshow", "Apollo", "0X80065C002", this.csq, 0, new String[0]);
          }
          i += 1;
          break;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.jdField_a_of_type_Abud.mItems, (List)localObject3, this.csv, this.csw - this.csu, super.getWidth(), super.getHeight());
          this.e.sendEmptyMessageDelayed(256, 600);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.cFx();
          return;
          localObject1 = null;
        }
        localObject1 = null;
      }
    }
  }
  
  public static void cFv()
  {
    int j = 0;
    if (bFF) {}
    do
    {
      return;
      bFF = true;
      int i = 0;
      String str;
      while (i <= 9)
      {
        str = "apollo_card_gold_" + i + ".png";
        if (!new File(abxi.biw + "boxcard/" + str).exists()) {
          abtn.a(str, null, abtn.iG(str)).startDownload();
        }
        i += 1;
      }
      if (!new File(abxi.biw + "boxcard/" + "apollo_card_gold_add.png").exists()) {
        abtn.a("apollo_card_gold_add.png", null, abtn.iG("apollo_card_gold_add.png")).startDownload();
      }
      i = j;
      if (!new File(abxi.biw + "boxcard/" + "apollo_card_gold_icon.png").exists())
      {
        abtn.a("apollo_card_gold_icon.png", null, abtn.iG("apollo_card_gold_icon.png")).startDownload();
        i = j;
      }
      while (i <= 9)
      {
        str = "apollo_card_crystal_" + i + ".png";
        if (!new File(abxi.biw + "boxcard/" + str).exists()) {
          abtn.a(str, null, abtn.iG(str)).startDownload();
        }
        i += 1;
      }
      if (!new File(abxi.biw + "boxcard/" + "apollo_card_crystal_add.png").exists()) {
        abtn.a("apollo_card_crystal_add.png", null, abtn.iG("apollo_card_crystal_add.png")).startDownload();
      }
    } while (new File(abxi.biw + "boxcard/" + "apollo_card_crystal_image.png").exists());
    abtn.a("apollo_card_crystal_image.png", null, abtn.iG("apollo_card_crystal_image.png")).startDownload();
  }
  
  private void init()
  {
    setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()), 0, 0);
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.bFI = true;
    this.jdField_a_of_type_Abug = new abug(this);
    this.e = new auru(Looper.getMainLooper(), this);
    cFt();
    int j = (int)aqgz.hK();
    int i = (int)aqgz.hL() - ImmersiveUtils.getStatusBarHeight(this.mContext);
    Object localObject2 = this.mContext.getResources();
    super.setBackgroundColor(-671088640);
    this.mCardWidth = ((int)(j * 0.706F));
    this.css = ((int)(j * 0.04F));
    this.cst = ((j - this.mCardWidth - this.css * 2) / 2);
    this.mCardHeight = (this.mCardWidth * 760 / 530);
    this.csu = ((int)(i * 0.23F));
    this.csv = (j >> 1);
    this.csw = ((int)(i * 0.461F));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = new RelativeLayout(getContext());
    super.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup = new OpeningCardGroup(this.mContext, this);
    localObject3 = new RelativeLayout.LayoutParams(-1, this.mCardHeight);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = this.csu;
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setFrameWidth(this.mCardWidth, this.mCardHeight, 0, this.css, this.cst, this.cst);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setClickLayoutListener(this);
    this.Qc = new TextView(this.mContext);
    this.Qc.setBackgroundResource(2130851767);
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(j * 0.032D));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(i * 0.017D));
    this.Qc.setGravity(17);
    this.Qc.setTextSize(17.0F / sM);
    this.Qc.setTextColor(-1);
    this.Qc.setText(2131721059);
    this.Qc.setOnClickListener(this);
    super.addView(this.Qc, (ViewGroup.LayoutParams)localObject3);
    this.b = new RoundRectLinearLayout(this.mContext);
    this.b.setOrientation(0);
    this.b.setGravity(17);
    this.b.setClickable(true);
    this.b.setRoundRect(ApolloUtil.dp2px(15.0F, sN), -1, true);
    localObject3 = new RelativeLayout.LayoutParams(-2, ApolloUtil.dp2px(30.0F, sN));
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(i * 0.018F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).addRule(9);
    this.b.setPadding(0, 0, ApolloUtil.dp2px(12.0F, sN), 0);
    super.addView(this.b, (ViewGroup.LayoutParams)localObject3);
    this.xI = new ImageView(this.mContext);
    localObject3 = new LinearLayout.LayoutParams(ApolloUtil.dp2px(15.0F, sN), ApolloUtil.dp2px(17.0F, sN));
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.dp2px(12.0F, sN);
    this.b.addView(this.xI, (ViewGroup.LayoutParams)localObject3);
    this.xI.setOnClickListener(this);
    this.xI.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.Qe = new TextView(this.mContext);
    this.Qe.setGravity(17);
    this.Qe.setTextSize(12.0F / sM);
    this.Qe.setTextColor(-16777216);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.dp2px(3.0F, sN);
    this.b.addView(this.Qe, (ViewGroup.LayoutParams)localObject3);
    this.Qe.setOnClickListener(this);
    this.xM = new ImageView(this.mContext);
    this.xM.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject3 = new LinearLayout.LayoutParams(ApolloUtil.dp2px(15.0F, sN), ApolloUtil.dp2px(17.0F, sN));
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.dp2px(15.0F, sN);
    this.b.addView(this.xM, (ViewGroup.LayoutParams)localObject3);
    this.xM.setOnClickListener(this);
    this.Qj = new TextView(this.mContext);
    this.Qj.setGravity(17);
    this.Qj.setTextSize(12.0F / sM);
    this.Qj.setTextColor(-16777216);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.dp2px(3.0F, sN);
    this.b.addView(this.Qj, (ViewGroup.LayoutParams)localObject3);
    this.Qj.setOnClickListener(this);
    this.xO = new ImageView(this.mContext);
    this.xO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localObject3 = new LinearLayout.LayoutParams(ApolloUtil.dp2px(15.0F, sN), ApolloUtil.dp2px(17.0F, sN));
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.dp2px(15.0F, sN);
    this.b.addView(this.xO, (ViewGroup.LayoutParams)localObject3);
    this.xO.setOnClickListener(this);
    this.Qk = new TextView(this.mContext);
    this.Qk.setGravity(17);
    this.Qk.setTextSize(12.0F / sM);
    this.Qk.setTextColor(-16777216);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).leftMargin = ApolloUtil.dp2px(3.0F, sN);
    this.b.addView(this.Qk, (ViewGroup.LayoutParams)localObject3);
    this.Qk.setOnClickListener(this);
    this.Qi = new TextView(this.mContext);
    this.Qi.setTextSize(14.0F / sM);
    this.Qi.setTextColor(-34816);
    this.Qi.setText(acfp.m(2131702458));
    localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).leftMargin = ((int)(j * 0.029F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14);
    ((RelativeLayout.LayoutParams)localObject3).addRule(10);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ((int)(i * 0.17F));
    super.addView(this.Qi, (ViewGroup.LayoutParams)localObject3);
    this.ik = new LinearLayout(this.mContext);
    this.ik.setOrientation(1);
    this.ik.setGravity(17);
    this.Qd = new TextView(this.mContext);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    this.Qd.setGravity(17);
    this.Qd.setTextSize(17.0F / sM);
    this.Qd.setTextColor(-1);
    this.bhT = bhR;
    this.Qd.setText(this.bhT);
    this.Qd.setClickable(true);
    ((LinearLayout.LayoutParams)localObject3).bottomMargin = ApolloUtil.dp2px(25.0F, sN);
    this.ik.addView(this.Qd, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new LinearLayout.LayoutParams(-1, ApolloUtil.dp2px(250.0F, sN) * 3 / 4);
    URLImageView localURLImageView = new URLImageView(this.mContext);
    URLDrawable localURLDrawable = abtn.a("apollo_error.png", null, abtn.iG("apollo_error.png"));
    localURLDrawable.setTargetDensity(((Resources)localObject2).getDisplayMetrics().densityDpi / 2);
    localURLImageView.setScaleType(ImageView.ScaleType.CENTER);
    localURLImageView.setImageDrawable(localURLDrawable);
    localURLImageView.setClickable(true);
    this.ik.addView(localURLImageView, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtil.dp2px(66.0F, sN);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ApolloUtil.dp2px(129.0F, sN);
    super.addView(this.ik, (ViewGroup.LayoutParams)localObject2);
    this.mLoadingView = new ImageView(this.mContext);
    this.mLoadingView.setImageResource(2130839655);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
    super.addView(this.mLoadingView, (ViewGroup.LayoutParams)localObject2);
    this.aur = ((int)(i * 0.061F));
    this.ij = new LinearLayout(this.mContext);
    this.ij.setOrientation(0);
    this.ij.setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams((int)(j * 0.936F), this.aur);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(j * 0.027F));
    super.addView(this.ij, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout = new RoundRectLinearLayout(this.mContext);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setGravity(17);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setRoundRect((int)(j * 0.008F), -7707920, false);
    this.xK = new ImageView(this.mContext);
    this.xK.setBackgroundResource(2130838551);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.xK, (ViewGroup.LayoutParams)localObject2);
    this.Qf = new TextView(this.mContext);
    this.Qf.setGravity(17);
    this.Qf.setTextSize(18.0F / sM);
    this.Qf.setTextColor(-1);
    this.Qf.setText("送花给TA");
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).leftMargin = ApolloUtil.dp2px(8.0F, sN);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.addView(this.Qf, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setOnClickListener(this);
    localObject2 = new LinearLayout.LayoutParams(0, -1);
    ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
    this.ij.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout, (ViewGroup.LayoutParams)localObject2);
    this.Qg = new TextView(this.mContext);
    this.Qg.setGravity(17);
    this.Qg.setTextSize(18.0F);
    this.Qg.setTextColor(-1);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(i * 0.2F));
    super.addView(this.Qg, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView = new ApolloOpenBoxView(this.mContext, this);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView, (ViewGroup.LayoutParams)localObject2);
    this.Qh = new TextView(this.mContext);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = 0;
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ApolloUtil.dp2px(217.0F, sN);
    this.Qh.setGravity(17);
    this.Qh.setTextSize(30.0F / sM);
    this.Qh.setTextColor(-1);
    ((RelativeLayout)localObject1).addView(this.Qh, (ViewGroup.LayoutParams)localObject2);
    i = 0;
    while (i < 4)
    {
      this.wz.add(new ApolloCardLayout(this.mContext));
      i += 1;
    }
    this.xL = new ImageView(this.mContext);
    this.xL.setBackgroundResource(2130838550);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = (j / 4);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)(j * 0.04F));
    this.xL.setVisibility(4);
    super.addView(this.xL, (ViewGroup.LayoutParams)localObject1);
    super.setOnClickListener(this);
  }
  
  public void Ej(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$a != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$a.CR(this.bhD);
    }
    super.setVisibility(8);
    this.e.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.Ej(paramBoolean);
    if (this.Qh != null) {
      this.Qh.clearAnimation();
    }
    if (this.Qe != null) {
      this.Qe.clearAnimation();
    }
    if (this.xI != null) {
      this.xI.clearAnimation();
    }
    if (this.Qj != null) {
      this.Qj.clearAnimation();
    }
    if (this.xM != null) {
      this.xM.clearAnimation();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.onDestroy();
      this.wz.clear();
      this.jdField_a_of_type_Abug.onDestroy();
    }
  }
  
  void Ii(int paramInt)
  {
    this.v = new AnimationSet(false);
    if (this.x == null)
    {
      this.x = new AlphaAnimation(0.0F, 1.0F);
      this.x.setDuration(150L);
    }
    if (this.o == null)
    {
      this.o = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.0F);
      this.o.setDuration(150L);
      this.o.setInterpolator(new AccelerateDecelerateInterpolator());
    }
    this.v.addAnimation(this.x);
    this.v.addAnimation(this.o);
    abui localabui = new abui(0, 0, 0, -ApolloUtil.dp2px(144.0F, sN), -(ApolloUtil.dp2px(195.0F, sN) - paramInt), -ApolloUtil.dp2px(164.0F, sN));
    localabui.setDuration(500L);
    localabui.setStartOffset(250L);
    localabui.setInterpolator(new AccelerateDecelerateInterpolator());
    if (this.p == null)
    {
      this.p = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F);
      this.p.setDuration(500L);
      this.p.setStartOffset(250L);
    }
    this.v.addAnimation(this.p);
    this.v.addAnimation(localabui);
    if (this.y == null)
    {
      this.y = new AlphaAnimation(1.0F, 0.0F);
      this.y.setDuration(500L);
      this.y.setStartOffset(250L);
    }
    this.v.addAnimation(this.y);
    this.v.setFillAfter(true);
    if (this.Qh != null) {
      this.Qh.startAnimation(this.v);
    }
  }
  
  public void N(float paramFloat1, float paramFloat2)
  {
    Ej(false);
  }
  
  public void a(View paramView, String paramString1, String paramString2, AppInterface paramAppInterface, a parama)
  {
    if ((paramView == null) || (paramAppInterface == null) || (paramString1 == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow$a = parama;
    super.setVisibility(4);
    this.mAppRef = new WeakReference(paramAppInterface);
    this.ij.setVisibility(4);
    this.mFrom = paramString2;
    this.bhD = paramString1;
    this.mCurrentUin = paramAppInterface.getCurrentAccountUin();
    this.bFG = false;
    this.b.setVisibility(8);
    this.Qi.setVisibility(8);
    this.b.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(4);
    this.Qh.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(4);
    this.bFH = false;
    this.e.removeCallbacksAndMessages(null);
    if (this.bFI)
    {
      this.e.sendEmptyMessage(258);
      this.e.removeMessages(264);
      this.e.sendEmptyMessageDelayed(264, 1000L);
    }
    for (;;)
    {
      this.bFI = false;
      return;
      this.e.removeMessages(264);
      this.e.sendEmptyMessage(264);
      this.e.sendEmptyMessageDelayed(258, 500L);
    }
  }
  
  void a(ImageView paramImageView1, ImageView paramImageView2, int paramInt)
  {
    Object localObject = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    ((ScaleAnimation)localObject).setStartOffset(paramInt);
    if (paramImageView1 != null) {
      paramImageView1.startAnimation((Animation)localObject);
    }
    paramImageView1 = new AnimationSet(false);
    localObject = new ScaleAnimation(1.0F, 4.0F, 1.0F, 4.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    new AlphaAnimation(0.0F, 1.0F).setDuration(75L);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(150L);
    paramImageView1.addAnimation((Animation)localObject);
    paramImageView1.setStartOffset(paramInt);
    paramImageView1.setFillAfter(true);
    if (paramImageView2 != null) {
      paramImageView2.startAnimation(paramImageView1);
    }
  }
  
  void a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 <= paramInt1) {
      return;
    }
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setObjectValues(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    localValueAnimator.setDuration(paramInt3);
    localValueAnimator.addUpdateListener(new abue(this, paramTextView));
    localValueAnimator.setStartDelay(paramInt4);
    localValueAnimator.start();
  }
  
  public void a(String paramString1, boolean paramBoolean, long paramLong, Object paramObject, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloCardWindow", 2, "cmd:" + paramString1 + " isSuccess:" + paramBoolean + " uin:" + paramString2 + " retCode:" + paramLong + " data:" + paramObject);
    }
    if (super.getVisibility() == 8) {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloCardWindow", 2, "onResult + super.getVisibility() not VISIBLE");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((TextUtils.isEmpty(this.bhD)) || (this.bhD.equals(paramString2))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ApolloCardWindow", 2, "mBoxUin:" + this.bhD + "notEqual uin:" + paramString2 + " return!");
        return;
        if (!"apollo_core.get_user_info".equals(paramString1)) {
          break;
        }
      } while ((TextUtils.isEmpty(this.bhD)) || (!this.bhD.equals(paramString2)));
      paramString1 = this.e.obtainMessage(257);
      paramString1.obj = paramObject;
      paramString1.sendToTarget();
      return;
      if ("apollo_interact.thank_zan".equals(paramString1))
      {
        if ((paramLong != 0L) || (!paramBoolean))
        {
          this.bFG = false;
          this.e.obtainMessage(261).sendToTarget();
          return;
        }
        this.e.obtainMessage(262).sendToTarget();
        return;
      }
    } while (!"apollo_interact.take_chips".equals(paramString1));
    this.e.removeMessages(258);
    if ((paramObject instanceof abud)) {
      this.jdField_a_of_type_Abud = ((abud)paramObject);
    }
    this.zl = paramLong;
    if ((this.jdField_a_of_type_Abud != null) && ((this.zl == -501030L) || (this.jdField_a_of_type_Abud.Ow == -501030L)))
    {
      if (this.jdField_a_of_type_Abud.mItems == null) {
        this.jdField_a_of_type_Abud.mItems = new ArrayList();
      }
      paramString1 = new abud.a();
      paramString1.csm = 1;
      this.jdField_a_of_type_Abud.mItems.add(0, paramString1);
    }
    if (paramBoolean)
    {
      if ((this.zl == 0L) || (this.zl == -501030L) || (this.zl == -501027L) || (this.zl == -501040L) || (this.zl == -501031L))
      {
        this.e.obtainMessage(260).sendToTarget();
        return;
      }
      if (this.zl == -501028L)
      {
        this.bhT = bhS;
        this.e.obtainMessage(259).sendToTarget();
        return;
      }
      this.bhT = bhR;
      this.e.obtainMessage(259).sendToTarget();
      return;
    }
    this.bhT = bhR;
    this.e.obtainMessage(259).sendToTarget();
  }
  
  public void aC(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloCardWindow", 2, "onOpenStep drawStep:" + paramInt1);
    }
    if (super.getVisibility() != 0) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_Abud == null);
        if (4 != paramInt1) {
          break;
        }
        this.Qg.setVisibility(8);
        this.b.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
        this.ij.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.cFy();
      } while ((this.jdField_a_of_type_Abud.Ow != -501027L) && (this.zl != -501027L));
      this.Qi.setVisibility(0);
      return;
    } while (10 != paramInt1);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.getVisibility() != 0)
    {
      this.Qg.setVisibility(8);
      this.b.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(0);
      if ((this.jdField_a_of_type_Abud.Ow == -501027L) || (this.zl == -501027L)) {
        this.Qi.setVisibility(0);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.a(this.mCardWidth, this.mCardHeight, this.jdField_a_of_type_Abud);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setCurrentFrame(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setVisibility(4);
    this.bFH = true;
    AbstractGifImage.resumeAll();
  }
  
  void cFw()
  {
    Object localObject1;
    Object localObject3;
    File localFile1;
    File localFile2;
    if ((this.jdField_a_of_type_Abud != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Abud.bhM)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Abud.bhL)))
    {
      localObject1 = arwv.toMD5(this.jdField_a_of_type_Abud.bhL);
      localObject3 = arwv.toMD5(this.jdField_a_of_type_Abud.bhM);
      localFile1 = new File(abxi.biw + (String)localObject1 + ".cache");
      localFile2 = new File(abxi.biw + (String)localObject3 + ".cache");
      if ((!localFile1.exists()) || (!localFile2.exists())) {}
    }
    synchronized (jc)
    {
      if (jc.containsKey(localObject1)) {}
      for (localObject1 = (Drawable)jc.get(localObject1); jc.containsKey(localObject3); localObject1 = null)
      {
        localObject3 = (Drawable)jc.get(localObject3);
        if ((localObject1 != null) && (localObject3 != null)) {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloOpenBoxView.setDrawables((Drawable)localObject1, (Drawable)localObject3, null);
        }
        if (!localFile1.exists()) {
          f(localFile1, this.jdField_a_of_type_Abud.bhL);
        }
        if (!localFile2.exists()) {
          f(localFile2, this.jdField_a_of_type_Abud.bhM);
        }
        return;
      }
      localObject3 = null;
    }
  }
  
  void f(File paramFile, String paramString)
  {
    if (this.c == null) {
      return;
    }
    aquz localaquz = new aquz(paramString, paramFile);
    localaquz.cWy = true;
    localaquz.cWs = false;
    localaquz.cWw = true;
    localaquz.cWB = false;
    localaquz.cWz = true;
    localaquz.cWA = true;
    localaquz.cWl = true;
    localaquz.cxX = "apollo_res";
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramFile.getPath());
    localBundle.putString("url", paramString);
    this.c.a(localaquz, this.m, null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    Object localObject;
    float f;
    label629:
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            switch (paramMessage.what)
            {
            default: 
              return false;
            }
          } while (this.jdField_a_of_type_Abud == null);
          if (this.jdField_a_of_type_Abud.wx.size() > 0)
          {
            paramMessage = (abud.b)this.jdField_a_of_type_Abud.wx.get(0);
            if ((paramMessage != null) && (paramMessage.csh > 0))
            {
              this.Qh.setVisibility(0);
              this.Qh.setText("+" + paramMessage.csh);
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130838546);
              localObject = abtn.a("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject, paramMessage.mIconUrl);
              i = ApolloUtil.dp2px(25.0F / sM, sN);
              ((URLDrawable)localObject).setBounds(0, 0, (int)(i * 0.8F), i);
              this.Qh.setCompoundDrawables((Drawable)localObject, null, null, null);
              Ii(0);
              this.Qe.setText(abud.dl(paramMessage.csp - paramMessage.csh));
              a(this.Qe, paramMessage.csp - paramMessage.csh, paramMessage.csp, 200, 650);
              if (this.xJ == null)
              {
                this.xJ = new ImageView(this.mContext);
                this.xJ.setId(2131366182);
                this.xJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
                paramMessage = new RelativeLayout.LayoutParams(ApolloUtil.dp2px(15.0F, sN), ApolloUtil.dp2px(15.0F, sN));
                paramMessage.leftMargin = ApolloUtil.dp2px(12.0F, sN);
                paramMessage.topMargin = (((RelativeLayout.LayoutParams)this.b.getLayoutParams()).topMargin + ApolloUtil.dp2px(7.5F, sN));
                super.addView(this.xJ, paramMessage);
              }
              this.xJ.setImageDrawable(null);
              a(this.xI, this.xJ, 650);
              this.e.sendEmptyMessageDelayed(266, 650L);
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("ApolloCardWindow", 2, "MSG_CODE_ADD_CARD:");
        return false;
        this.jdField_a_of_type_Abug.a(this.mContext, this.bhD, this.mFrom, (AppInterface)this.mAppRef.get());
        return false;
      } while (this.jdField_a_of_type_Abud == null);
      return false;
      super.setVisibility(0);
      this.ij.setVisibility(4);
      this.Qd.setText(this.bhT);
      this.ik.setVisibility(0);
      this.mLoadingView.setVisibility(8);
      this.Qg.setVisibility(8);
      return false;
      super.setVisibility(0);
      this.ik.setVisibility(8);
      this.mLoadingView.setVisibility(0);
      this.Qg.setVisibility(8);
      return false;
      if (this.jdField_a_of_type_Abud != null)
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramMessage = this.xK;
          if (!this.jdField_a_of_type_Abud.bFC) {
            break label686;
          }
          f = 1.0F;
          paramMessage.setAlpha(f);
        }
        paramMessage = this.Qf;
        if (!this.jdField_a_of_type_Abud.bFC) {
          break label692;
        }
      }
      for (i = -1;; i = -2130706433)
      {
        paramMessage.setTextColor(i);
        if (this.ij.getVisibility() != 0) {
          break;
        }
        QQToast.a(this.mContext, acfp.m(2131702454), 0).show();
        return false;
        f = 0.5F;
        break label629;
      }
      if (Build.VERSION.SDK_INT >= 11) {
        this.xK.setAlpha(0.5F);
      }
      this.Qf.setTextColor(-2130706433);
    } while (this.ij.getVisibility() != 0);
    label686:
    label692:
    QQToast.a(this.mContext, acfp.m(2131702449), 0).show();
    return false;
    super.setVisibility(0);
    cFw();
    if (this.jdField_a_of_type_Abud == null)
    {
      this.Qd.setText(this.bhT);
      this.ik.setVisibility(0);
      this.mLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.setVisibility(4);
      return false;
    }
    this.Qg.setVisibility(8);
    if ((!TextUtils.isEmpty(this.mCurrentUin)) && (this.mCurrentUin.equals(this.bhD)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
      this.ik.setVisibility(8);
      this.mLoadingView.setVisibility(8);
      if (!"drawer".equals(this.mFrom)) {
        break label1098;
      }
      this.csq = 0;
      label888:
      if ((this.jdField_a_of_type_Abud.Ow == 0L) && (this.jdField_a_of_type_Abud.zl != -501031L)) {
        break label1165;
      }
      if (this.jdField_a_of_type_Abud.csh <= 0) {
        break label1135;
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Abud.mCurrentUin)) || (!this.jdField_a_of_type_Abud.mCurrentUin.equals(this.jdField_a_of_type_Abud.bhD))) {
        break label1127;
      }
      this.csr = 1;
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "openfloatagain", this.csq, 0, new String[] { String.valueOf(this.csr) });
      label994:
      cFu();
      return false;
      if (this.jdField_a_of_type_Abud.csh > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramMessage = this.xK;
          if (this.jdField_a_of_type_Abud.bFC)
          {
            f = 1.0F;
            label1043:
            paramMessage.setAlpha(f);
          }
        }
        else
        {
          paramMessage = this.Qf;
          if (!this.jdField_a_of_type_Abud.bFC) {
            break label1079;
          }
        }
        label1079:
        for (i = -1;; i = -2130706433)
        {
          paramMessage.setTextColor(i);
          break;
          f = 0.5F;
          break label1043;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout.setVisibility(8);
      break;
      label1098:
      if ("friendcard".equals(this.mFrom))
      {
        this.csq = 1;
        break label888;
      }
      this.csq = 2;
      break label888;
      label1127:
      this.csr = 2;
      continue;
      label1135:
      if (this.jdField_a_of_type_Abud.Ow == -501030L) {
        this.csr = 3;
      } else {
        this.csr = 4;
      }
    }
    label1165:
    if (this.jdField_a_of_type_Abud.csh > 0) {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Abud.mCurrentUin)) && (this.jdField_a_of_type_Abud.mCurrentUin.equals(this.jdField_a_of_type_Abud.bhD)))
      {
        this.csr = 1;
        paramMessage = (abud.b)this.jdField_a_of_type_Abud.iA.get(Integer.valueOf(3));
        if ((paramMessage != null) && (paramMessage.csh > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C2", this.csq, 0, new String[] { "", String.valueOf(paramMessage.csh), "" });
        }
        paramMessage = (abud.b)this.jdField_a_of_type_Abud.iA.get(Integer.valueOf(7));
        if ((paramMessage != null) && (paramMessage.csh > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C04", this.csq, 0, new String[] { "", String.valueOf(paramMessage.csh), "" });
        }
        paramMessage = (abud.b)this.jdField_a_of_type_Abud.iA.get(Integer.valueOf(15));
        if ((paramMessage != null) && (paramMessage.csh > 0)) {
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C06", this.csq, 0, new String[] { "", String.valueOf(paramMessage.csh), "" });
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C1", this.csq, 0, new String[] { String.valueOf(i), String.valueOf(this.jdField_a_of_type_Abud.csh) });
      break label994;
      this.csr = 2;
      if ((this.jdField_a_of_type_Abud.wy != null) && (!this.jdField_a_of_type_Abud.wy.isEmpty()))
      {
        paramMessage = this.jdField_a_of_type_Abud.wy.iterator();
        for (;;)
        {
          if (paramMessage.hasNext())
          {
            localObject = (abud.a)paramMessage.next();
            abud.b localb = (abud.b)this.jdField_a_of_type_Abud.iA.get(Integer.valueOf(3));
            if ((localb != null) && (localb.csh > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.csq, 0, new String[] { String.valueOf(((abud.a)localObject).mId), String.valueOf(0), String.valueOf(((abud.a)localObject).O) });
            }
            localObject = (abud.b)this.jdField_a_of_type_Abud.iA.get(Integer.valueOf(7));
            if ((localObject != null) && (((abud.b)localObject).csh > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.csq, 0, new String[] { "0", String.valueOf(0), "4" });
            }
            localObject = (abud.b)this.jdField_a_of_type_Abud.iA.get(Integer.valueOf(15));
            if ((localObject != null) && (((abud.b)localObject).csh > 0))
            {
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C3", this.csq, 0, new String[] { "0", String.valueOf(0), "5" });
              continue;
              if (this.jdField_a_of_type_Abud.zl == -501030L)
              {
                this.csr = 3;
                VipUtils.a(null, "cmshow", "Apollo", "0X80065C4", this.csq, 0, new String[] { "0", "0", "1" });
                break label994;
              }
              this.csr = 4;
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C5", this.csq, 0, new String[0]);
              break label994;
              if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)) || (TextUtils.isEmpty((String)paramMessage.obj))) {
                break;
              }
              paramMessage = URLDrawable.URLDrawableOptions.obtain();
              paramMessage.mLoadingDrawable = aqhu.at();
              paramMessage.mFailedDrawable = paramMessage.mLoadingDrawable;
              localObject = new abtn.a();
              ((abtn.a)localObject).crD = abtn.crA;
              paramMessage.mExtraInfo = localObject;
              return false;
              if ((this.jdField_a_of_type_Abud == null) || (this.jdField_a_of_type_Abud.mItems == null)) {
                break;
              }
              i = this.mCardWidth / 2;
              int j = this.css;
              int k = this.cst;
              int n = this.mCardHeight / 2;
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxOpeningCardGroup.aD(i + j + k, this.mCardWidth + this.css, n);
              if (QLog.isColorLevel()) {
                QLog.d("ApolloCardWindow", 2, "MSG_CODE_CARD_TO_NORMAL");
              }
              if (this.jdField_a_of_type_Abud == null) {
                break;
              }
              if (this.jdField_a_of_type_Abud.wx.size() > 0)
              {
                paramMessage = (abud.b)this.jdField_a_of_type_Abud.wx.get(0);
                if ((paramMessage != null) && (paramMessage.mIsShow) && (paramMessage.csh > 0))
                {
                  this.e.sendEmptyMessageDelayed(255, 500L);
                  j = 650;
                  i = 650;
                }
              }
              for (;;)
              {
                k = i;
                if (this.jdField_a_of_type_Abud.wx.size() > 1)
                {
                  paramMessage = (abud.b)this.jdField_a_of_type_Abud.wx.get(1);
                  k = i;
                  if (paramMessage != null)
                  {
                    k = i;
                    if (paramMessage.mIsShow)
                    {
                      k = i;
                      if (paramMessage.csh > 0)
                      {
                        this.e.sendEmptyMessageDelayed(265, j + 500);
                        k = i + 150 + 500;
                      }
                    }
                  }
                }
                if (this.jdField_a_of_type_Abud.wx.size() <= 2) {
                  break;
                }
                paramMessage = (abud.b)this.jdField_a_of_type_Abud.wx.get(2);
                if ((paramMessage == null) || (!paramMessage.mIsShow) || (paramMessage.csh <= 0)) {
                  break;
                }
                this.e.sendEmptyMessageDelayed(268, k + 500);
                return false;
                if (this.jdField_a_of_type_Abud == null) {
                  break;
                }
                if (this.jdField_a_of_type_Abud.wx.size() > 1)
                {
                  paramMessage = (abud.b)this.jdField_a_of_type_Abud.wx.get(1);
                  if ((paramMessage != null) && (paramMessage.csh > 0))
                  {
                    this.Qh.setText("+" + paramMessage.csh);
                    localObject = URLDrawable.URLDrawableOptions.obtain();
                    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = super.getResources().getDrawable(2130838547);
                    localObject = abtn.a("apollo_card_first_image.png", (URLDrawable.URLDrawableOptions)localObject, paramMessage.mIconUrl);
                    i = ApolloUtil.dp2px(25.0F / sM, sN);
                    ((URLDrawable)localObject).setBounds(0, 0, i, i);
                    this.Qh.setCompoundDrawables((Drawable)localObject, null, null, null);
                    Ii(this.Qe.getWidth() + this.xM.getWidth() + ApolloUtil.dp2px(28.0F, sN));
                    this.Qj.setText(abud.dk(paramMessage.csp - paramMessage.csh));
                    a(this.Qj, paramMessage.csp - paramMessage.csh, paramMessage.csp, 200, 650);
                    if (this.xN == null)
                    {
                      this.xN = new ImageView(this.mContext);
                      this.xN.setId(2131375406);
                      this.xN.setScaleType(ImageView.ScaleType.CENTER_CROP);
                      paramMessage = new RelativeLayout.LayoutParams(ApolloUtil.dp2px(15.0F, sN), ApolloUtil.dp2px(15.0F, sN));
                      paramMessage.leftMargin = (ApolloUtil.dp2px(47.0F, sN) + this.Qe.getWidth());
                      paramMessage.topMargin = (((RelativeLayout.LayoutParams)this.b.getLayoutParams()).topMargin + ApolloUtil.dp2px(7.5F, sN));
                      super.addView(this.xN, paramMessage);
                    }
                    this.xN.setImageDrawable(null);
                    a(this.xM, this.xN, 650);
                    this.e.sendEmptyMessageDelayed(267, 650L);
                  }
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
                return false;
                if (this.jdField_a_of_type_Abud == null) {
                  break;
                }
                if (this.jdField_a_of_type_Abud.wx.size() > 2)
                {
                  paramMessage = (abud.b)this.jdField_a_of_type_Abud.wx.get(2);
                  if ((paramMessage != null) && (paramMessage.csh > 0))
                  {
                    this.Qh.setText("+" + paramMessage.csh);
                    localObject = abtn.a("apollo_card_props_image.png", null, paramMessage.mIconUrl);
                    i = ApolloUtil.dp2px(25.0F / sM, sN);
                    ((URLDrawable)localObject).setBounds(0, 0, i, i);
                    this.Qh.setCompoundDrawables((Drawable)localObject, null, null, null);
                    Ii(ApolloUtil.dp2px(125.0F, sN) + this.Qe.getWidth() + this.Qj.getWidth());
                    this.Qk.setText(abud.dj(paramMessage.csp - paramMessage.csh));
                    a(this.Qk, paramMessage.csp - paramMessage.csh, paramMessage.csp, 200, 650);
                    if (this.xP == null)
                    {
                      this.xP = new ImageView(this.mContext);
                      this.xP.setId(2131375406);
                      this.xP.setScaleType(ImageView.ScaleType.CENTER_CROP);
                      paramMessage = new RelativeLayout.LayoutParams(ApolloUtil.dp2px(15.0F, sN), ApolloUtil.dp2px(15.0F, sN));
                      paramMessage.leftMargin = (ApolloUtil.dp2px(82.0F, sN) + this.Qe.getWidth() + this.Qj.getWidth());
                      paramMessage.topMargin = (((RelativeLayout.LayoutParams)this.b.getLayoutParams()).topMargin + ApolloUtil.dp2px(7.5F, sN));
                      super.addView(this.xP, paramMessage);
                    }
                    a(this.xO, this.xP, 650);
                    this.e.sendEmptyMessageDelayed(269, 650L);
                  }
                }
                this.xP.setImageDrawable(null);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("ApolloCardWindow", 2, "MSG_CODE_ADD_GOLD:");
                return false;
                if (this.xJ == null) {
                  break;
                }
                this.xJ.setImageResource(2130838549);
                return false;
                if (this.xN == null) {
                  break;
                }
                this.xN.setImageResource(2130838549);
                return false;
                if (this.xP == null) {
                  break;
                }
                this.xP.setImageResource(2130838549);
                return false;
                i = 0;
                j = 0;
              }
            }
          }
        }
      }
    }
  }
  
  public Drawable k(String paramString)
  {
    paramString = BitmapFactory.decodeFile(paramString);
    paramString.setDensity(getContext().getResources().getDisplayMetrics().densityDpi);
    return new BitmapDrawable(getContext().getResources(), paramString);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.Qc)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065C8", this.csq, 0, new String[0]);
      Ej(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject3;
      Object localObject2;
      Object localObject1;
      if ((paramView == this.Qe) || (paramView == this.xI))
      {
        if ((this.bFH) && (this.jdField_a_of_type_Abud != null))
        {
          localObject3 = new Intent(this.mContext, QQBrowserActivity.class);
          localObject2 = abxi.bjn + "&adtag=floatlayer";
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Abud.wx.size() > 0)
          {
            abud.b localb = (abud.b)this.jdField_a_of_type_Abud.wx.get(0);
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localb.bhQ)) {
              localObject1 = localb.bhQ;
            }
          }
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(this.mContext, (String)localObject1, -1L, (Intent)localObject3, false, -1);
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C01", this.csq, 0, new String[0]);
          Ej(false);
        }
      }
      else if ((paramView == this.xM) || (paramView == this.Qj))
      {
        if (this.jdField_a_of_type_Abud != null)
        {
          localObject2 = abxi.bjm + "&adtag=floatlayer";
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Abud.wx.size() > 1)
          {
            localObject3 = (abud.b)this.jdField_a_of_type_Abud.wx.get(1);
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(((abud.b)localObject3).bhQ)) {
              localObject1 = ((abud.b)localObject3).bhQ;
            }
          }
          localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.openQQBrowserActivity(this.mContext, (String)localObject1, -1L, (Intent)localObject2, false, -1);
          VipUtils.a(null, "cmshow", "Apollo", "0X80065C03", this.csq, 0, new String[0]);
          Ej(false);
        }
      }
      else if ((paramView == this.xO) || (paramView == this.Qk))
      {
        if (this.jdField_a_of_type_Abud != null)
        {
          if (this.jdField_a_of_type_Abud.wx.size() > 2)
          {
            localObject1 = (abud.b)this.jdField_a_of_type_Abud.wx.get(2);
            if (!TextUtils.isEmpty(((abud.b)localObject1).bhQ))
            {
              localObject2 = new Intent(this.mContext, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_zf_lmx");
              VasWebviewUtil.openQQBrowserActivity(this.mContext, ((abud.b)localObject1).bhQ, -1L, (Intent)localObject2, false, -1);
              VipUtils.a(null, "cmshow", "Apollo", "0X80065C001", this.csq, 0, new String[0]);
            }
          }
          Ej(false);
        }
      }
      else if (paramView == this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxRoundRectLinearLayout)
      {
        if ((this.jdField_a_of_type_Abud != null) && (this.bFH))
        {
          if ((this.jdField_a_of_type_Abud.bFC) && (!this.bFG)) {
            if (aqiw.isNetworkAvailable(this.mContext))
            {
              if (Build.VERSION.SDK_INT >= 11) {
                this.xK.setAlpha(0.5F);
              }
              this.Qf.setTextColor(-2130706433);
              this.bFG = true;
              this.jdField_a_of_type_Abug.a(this.mContext, this.jdField_a_of_type_Abud.Ox, (AppInterface)this.mAppRef.get(), this.mFrom, this.bhD);
              cFe();
            }
          }
          label666:
          for (int i = 1;; i = 2)
          {
            if ((this.jdField_a_of_type_Abud.wx.size() > 2) && (((abud.b)this.jdField_a_of_type_Abud.wx.get(2)).csh > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", i, 0, new String[] { "3" });
            }
            if ((this.jdField_a_of_type_Abud.wx.size() > 1) && (((abud.b)this.jdField_a_of_type_Abud.wx.get(1)).csh > 0)) {
              VipUtils.a(null, "cmshow", "Apollo", "sendflower", i, 0, new String[] { "2" });
            }
            if ((this.jdField_a_of_type_Abud.wx.size() <= 0) || (((abud.b)this.jdField_a_of_type_Abud.wx.get(0)).csh <= 0)) {
              break;
            }
            VipUtils.a(null, "cmshow", "Apollo", "sendflower", i, 0, new String[] { "1" });
            break;
            QQToast.a(this.mContext, acfp.m(2131702457), 0).show();
            break label666;
            QQToast.a(this.mContext, acfp.m(2131702447), 0).show();
          }
        }
      }
      else if ((this == paramView) && (this.bFH) && (!this.bFJ))
      {
        VipUtils.a(null, "cmshow", "Apollo", "clickblackfloat", this.csq, 0, new String[0]);
        Ej(false);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.jN = f1;
      this.jM = f2;
      this.bFJ = false;
      continue;
      if (Math.hypot(Math.abs(this.jN - f1), Math.abs(this.jM - f2)) > this.mTouchSlop)
      {
        this.bFJ = true;
        continue;
        if (Math.hypot(Math.abs(this.jN - f1), Math.abs(this.jM - f2)) > this.mTouchSlop) {
          this.bFJ = true;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void CR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow
 * JD-Core Version:    0.7.0.1
 */