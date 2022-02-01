package com.tencent.mobileqq.medalwall;

import acej;
import ajac;
import ajad;
import ajae;
import ajaf;
import ajag;
import ajah;
import ajai;
import ajak;
import ajal;
import ajam;
import ajri;
import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import aqhq;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import wja;

public class MedalGuideView
  extends FrameLayout
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener
{
  private static java.lang.ref.WeakReference<MedalGuideView> ho;
  private static final int[] lI = { 2130846327, 2130846329, 2130846328 };
  private static final int[] lJ = { 2130846318, 2130846319, 2130846320 };
  private static final int[] lK = { 2131166677, 2131166681, 2131166679 };
  private static final int[] lL = { 2131166683, 2131166685, 2131166684 };
  private static final int[] lM = { 2130846309, 2130846311, 2130846310 };
  private static final int[] lN = { 2130846313, 2130846317, 2130846315 };
  private static final int[] lO = { 2130846324, 2130846325, 2130846326 };
  List<mqq.util.WeakReference<ValueAnimator>> CP;
  String Za;
  public ajak a;
  ajal jdField_a_of_type_Ajal;
  ajam jdField_a_of_type_Ajam;
  public auru a;
  a jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a = null;
  MedalWallMng.a jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a = null;
  boolean afw = true;
  public ImageButton az;
  ajal b;
  String bQl;
  String bQm;
  public URLImageView bn;
  ajal c;
  public boolean cnc = false;
  public boolean cnd = false;
  public boolean cne = false;
  boolean cnf;
  int dhm;
  int dhn;
  int dho;
  Button gD;
  Button gE;
  java.lang.ref.WeakReference<View> hn = null;
  ColorDrawable l;
  java.lang.ref.WeakReference<BaseActivity> mActivityRef = null;
  public ArgbEvaluator mArgbEvaluator = null;
  public int mBgColor;
  public ViewGroup mContentView;
  Drawable mDefaultDrawable;
  int mFrom;
  TextView mNameView;
  TextView mTitleView;
  
  public MedalGuideView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MedalGuideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MedalGuideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Ajak = null;
    initUI();
  }
  
  public static void a(MedalWallMng.a parama, BaseActivity paramBaseActivity, View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "showMedalGuide from: %d, view: %s, activity: %s, medal: %s", new Object[] { Integer.valueOf(paramInt), paramView, paramBaseActivity, parama }));
    }
    dvL();
    MedalGuideView localMedalGuideView = new MedalGuideView(paramBaseActivity);
    a locala = new a(localMedalGuideView, -1, -1, true);
    localMedalGuideView.a(parama, paramBaseActivity, paramView, paramInt, locala);
    locala.setClippingEnabled(false);
    locala.setOutsideTouchable(true);
    locala.setBackgroundDrawable(new ColorDrawable(0));
    locala.showAtLocation(paramView, 0, 0, 0);
    ThreadManager.post(new MedalGuideView.10(paramInt), 5, null, false);
    ho = new java.lang.ref.WeakReference(localMedalGuideView);
  }
  
  private void aT(float paramFloat)
  {
    this.mTitleView.setAlpha(paramFloat);
    this.mNameView.setAlpha(paramFloat);
    this.gD.setAlpha(paramFloat);
    this.gE.setAlpha(paramFloat);
    this.az.setAlpha(paramFloat);
  }
  
  private void close()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "close");
    }
    this.cnc = true;
    this.jdField_a_of_type_Auru.removeMessages(3);
    if (this.jdField_a_of_type_Ajak != null)
    {
      this.jdField_a_of_type_Ajak.destroy();
      this.jdField_a_of_type_Ajak = null;
    }
    if (this.mActivityRef != null)
    {
      this.mActivityRef.clear();
      this.mActivityRef = null;
    }
    if (this.hn != null)
    {
      this.hn.clear();
      this.hn = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a = null;
    if (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a.superDismiss();
      this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a = null;
    }
    Iterator localIterator = this.CP.iterator();
    while (localIterator.hasNext())
    {
      mqq.util.WeakReference localWeakReference = (mqq.util.WeakReference)localIterator.next();
      ValueAnimator localValueAnimator = (ValueAnimator)localWeakReference.get();
      if (localValueAnimator != null)
      {
        localValueAnimator.cancel();
        localValueAnimator.removeAllUpdateListeners();
        localWeakReference.clear();
      }
    }
  }
  
  public static void dvL()
  {
    if (ho != null)
    {
      MedalGuideView localMedalGuideView = (MedalGuideView)ho.get();
      if (localMedalGuideView != null) {
        localMedalGuideView.close();
      }
      ho.clear();
      ho = null;
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCleanMedalGuide guide: %s", new Object[] { localMedalGuideView }));
      }
    }
  }
  
  private void ha(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject;
    String str6;
    int k;
    String str3;
    long l2;
    long l1;
    String str1;
    String str4;
    int j;
    int i;
    String str2;
    if (this.jdField_a_of_type_Ajam == null)
    {
      this.jdField_a_of_type_Ajam = new ajam(paramView.getContext(), localQQAppInterface);
      localObject = ((MedalWallMng)localQQAppInterface.getManager(250)).getShareUrl();
      str6 = ajam.bQt;
      k = wja.dp2px(48.0F, getResources());
      str3 = "";
      paramView = "";
      if ((this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a == null) || (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a == null)) {
        break label714;
      }
      switch (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.iLevel)
      {
      default: 
        l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lObtainTimeLevel1;
        l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lSeqLevel1;
        paramView = String.format("%s %s", new Object[] { this.Za, paramView });
        str1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.bQq;
        str4 = ajri.encode(localQQAppInterface.getCurrentAccountUin());
        j = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.iId;
        i = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.iLevel;
        str3 = localQQAppInterface.getCurrentNickname();
        str2 = ajam.g(new String[] { j + "", i + "", str4, str3 });
      }
    }
    for (;;)
    {
      localObject = new StringBuilder((String)localObject);
      ((StringBuilder)localObject).append("&uincode=").append(str4);
      ((StringBuilder)localObject).append("&id=").append(j);
      ((StringBuilder)localObject).append("&level=").append(i);
      ((StringBuilder)localObject).append("&nick=").append(URLEncoder.encode(str3));
      ((StringBuilder)localObject).append("&en=").append(str2);
      ((StringBuilder)localObject).append("&fromId=").append(1);
      if ((this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a != null) && (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a != null) && (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.iId == 0)) {
        str3 = "0";
      }
      for (;;)
      {
        try
        {
          str2 = ajam.c(Long.valueOf(l2 * 1000L)).substring(0, 4);
          ((StringBuilder)localObject).append("&year=").append(str2);
          ((StringBuilder)localObject).append("&seq=").append(l1);
          if (QLog.isColorLevel()) {
            QLog.i("ShareHelper", 4, "shareUrl:" + ((StringBuilder)localObject).toString());
          }
          this.jdField_a_of_type_Ajam.a(paramView, str6, ((StringBuilder)localObject).toString(), str1, "QQ勋章墙", ajam.e(this.bn.getDrawable(), k, k));
          this.jdField_a_of_type_Ajam.c(new ajac(this));
          ThreadManager.post(new MedalGuideView.3(this, localQQAppInterface), 5, null, false);
          return;
          l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lObtainTimeLevel1;
          l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lSeqLevel1;
          paramView = "I";
          break;
          l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lObtainTimeLevel2;
          l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lSeqLevel2;
          paramView = "II";
          break;
          l2 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lObtainTimeLevel3;
          l1 = this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a.a.lSeqLevel3;
          paramView = "III";
        }
        catch (Exception localException)
        {
          str2 = str3;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("ShareHelper", 2, localException.getMessage(), localException);
          str2 = str3;
          continue;
        }
        ((StringBuilder)localObject).append("&time=").append(l2);
      }
      label714:
      str2 = "";
      paramView = "";
      i = 0;
      str1 = "";
      l2 = 0L;
      l1 = 0L;
      String str5 = "";
      j = 0;
    }
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_Auru = new auru(Looper.getMainLooper(), this);
    this.CP = new ArrayList();
    inflate(getContext(), 2131561427, this);
    this.mContentView = ((ViewGroup)findViewById(2131365360));
    this.mTitleView = ((TextView)findViewById(2131379769));
    this.bn = ((URLImageView)findViewById(2131371205));
    this.mNameView = ((TextView)findViewById(2131371206));
    this.gD = ((Button)findViewById(2131378168));
    this.gD.setOnClickListener(this);
    this.gE = ((Button)findViewById(2131366464));
    this.gE.setOnClickListener(this);
    this.az = ((ImageButton)findViewById(2131364677));
    this.az.setOnClickListener(this);
    this.l = new ColorDrawable(0);
    try
    {
      DisplayMetrics localDisplayMetrics1 = getResources().getDisplayMetrics();
      DisplayMetrics localDisplayMetrics2 = acej.k;
      if (localDisplayMetrics1.density != localDisplayMetrics2.density)
      {
        float f2 = localDisplayMetrics2.density / localDisplayMetrics1.density;
        float f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        f1 = localDisplayMetrics2.density * f1;
        Object localObject = (LinearLayout.LayoutParams)this.bn.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = ((int)(290.0F * f1));
        ((LinearLayout.LayoutParams)localObject).height = ((int)(290.0F * f1));
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(30.0F * f1));
        this.bn.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)this.mNameView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(20.0F * f1));
        this.mNameView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout)findViewById(2131361986);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
        localLayoutParams.topMargin = ((int)(32.0F * f1));
        ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
        localObject = (LinearLayout.LayoutParams)this.az.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).topMargin = ((int)(40.0F * f1));
        this.az.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "dm[%f, %d, %f], system[%f, %d, %f]", new Object[] { Float.valueOf(localDisplayMetrics1.density), Integer.valueOf(localDisplayMetrics1.densityDpi), Float.valueOf(localDisplayMetrics1.scaledDensity), Float.valueOf(localDisplayMetrics2.density), Integer.valueOf(localDisplayMetrics2.densityDpi), Float.valueOf(localDisplayMetrics2.scaledDensity) }));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    this.mArgbEvaluator = new ArgbEvaluator();
    this.mBgColor = getResources().getColor(2131166676);
    this.bn.setAlpha(0.0F);
    this.mContentView.setBackgroundColor(0);
    aT(0.0F);
  }
  
  private void updateUI()
  {
    Resources localResources = getResources();
    this.mTitleView.setText(2131701334);
    this.mTitleView.setCompoundDrawablesWithIntrinsicBounds(lI[this.dho], 0, lI[this.dho], 0);
    this.mTitleView.setTextColor(localResources.getColor(lK[this.dho]));
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    int i = localResources.getDimensionPixelSize(2131298720);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mDefaultDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mDefaultDrawable;
    if (aqhq.fileExists(this.bQm)) {
      localObject = URLDrawable.getDrawable(new File(this.bQm), (URLDrawable.URLDrawableOptions)localObject);
    }
    for (;;)
    {
      this.bn.setImageDrawable((Drawable)localObject);
      this.mNameView.setText(this.Za);
      if (this.cnf) {
        this.mNameView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      for (;;)
      {
        this.mNameView.setTextColor(localResources.getColor(lK[this.dho]));
        this.gD.setBackgroundResource(lM[this.dho]);
        this.gD.setTextColor(localResources.getColorStateList(lL[this.dho]));
        this.gE.setBackgroundResource(lM[this.dho]);
        this.gE.setTextColor(localResources.getColorStateList(lL[this.dho]));
        this.az.setImageResource(lN[this.dho]);
        return;
        if (TextUtils.isEmpty(this.bQl)) {
          break label349;
        }
        localObject = URLDrawable.getDrawable(this.bQl, (URLDrawable.URLDrawableOptions)localObject);
        break;
        localObject = getResources().getDrawable(lJ[this.dho]);
        ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        this.l.setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
        this.mNameView.setCompoundDrawables(this.l, null, (Drawable)localObject, null);
      }
      label349:
      localObject = null;
    }
  }
  
  public void a(MedalWallMng.a parama, BaseActivity paramBaseActivity, View paramView, int paramInt, a parama1)
  {
    this.hn = new java.lang.ref.WeakReference(paramView);
    this.mActivityRef = new java.lang.ref.WeakReference(paramBaseActivity);
    this.mFrom = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalWallMng$a = parama;
    this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a = parama1;
    this.jdField_a_of_type_Ajam = null;
    if (this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqMedalwallMedalGuideView$a.a(new ajai(this));
    }
    if ((parama != null) && (parama.a != null))
    {
      this.dhm = parama.a.iId;
      if ((parama.a.iLevel >= 1) && (parama.a.iLevel <= 3))
      {
        this.dho = (parama.a.iLevel - 1);
        this.cnf = false;
        this.dhn = parama.a.iLevel;
        this.Za = parama.a.strName;
        this.bQm = parama.localPath;
        this.bQl = parama.url;
      }
    }
    for (;;)
    {
      this.mDefaultDrawable = new ColorDrawable(0);
      updateUI();
      return;
      this.dho = 2;
      this.cnf = true;
      break;
      this.dhm = 0;
      this.dho = 2;
      this.Za = "";
      this.bQm = null;
      this.bQl = null;
      this.cnf = false;
      this.dhn = 1;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.afw)
    {
      this.afw = false;
      this.cne = false;
      this.jdField_a_of_type_Auru.sendEmptyMessage(1);
      this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(5, 1600L);
    }
    if (this.jdField_a_of_type_Ajak != null) {
      this.jdField_a_of_type_Ajak.d(paramCanvas, 1);
    }
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Ajak != null) {
      this.jdField_a_of_type_Ajak.d(paramCanvas, 2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_ENTER_ANIM");
      }
      this.cnd = false;
      paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.05714286F, 0.0F), Keyframe.ofFloat(0.2F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) });
      float f1 = this.bn.getY();
      float f2 = this.bn.getHeight();
      float f4 = this.mNameView.getY();
      float f5 = this.mNameView.getHeight();
      float f3 = -this.bn.getY();
      f2 = f4 + f5 - (f1 + f2);
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = this.bn.getHeight() * 0.3F;
      }
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramMessage, PropertyValuesHolder.ofKeyframe("translate", new Keyframe[] { Keyframe.ofFloat(0.0F, f3), Keyframe.ofFloat(0.7714286F, f1), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.CP.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new ajad(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.08571429F, 0.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.CP.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new ajae(this));
      paramMessage.setDuration(700L);
      paramMessage.start();
      continue;
      f5 = 2540.0F - 1940.0F;
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.CP.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new ajaf(this));
      paramMessage.setDuration((f5 * 1.0F));
      paramMessage.start();
      paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("bgColor", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F), Keyframe.ofFloat((2340.0F - 1940.0F) / f5, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.CP.add(new mqq.util.WeakReference(paramMessage));
      paramMessage.addUpdateListener(new ajag(this));
      paramMessage.setDuration((f5 * 1.0F));
      paramMessage.start();
      label603:
      int i;
      Object localObject1;
      Object localObject2;
      int j;
      if (this.hn == null)
      {
        paramMessage = null;
        i = Math.max(this.bn.getWidth(), this.bn.getHeight());
        if (paramMessage == null) {
          break label1367;
        }
        localObject1 = new int[2];
        localObject2 = new int[2];
        paramMessage.getLocationOnScreen((int[])localObject1);
        this.bn.getLocationOnScreen((int[])localObject2);
        j = Math.min(paramMessage.getWidth(), paramMessage.getHeight());
        if ((j != 0) && (i != 0)) {
          break label1356;
        }
        f1 = 0.2F;
        label678:
        localObject1[0] += j / 2;
        localObject1[1] += j / 2;
        localObject2[0] += i / 2;
        localObject2[1] += i / 2;
        f2 = localObject1[0] - localObject2[0];
        f4 = localObject1[1] - localObject2[1];
        if (QLog.isDevelopLevel())
        {
          paramMessage = new int[2];
          this.bn.getLocationInWindow(paramMessage);
          f3 = this.bn.getPivotX();
          float f6 = this.bn.getPivotY();
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim target[%d, %d], cur[%d, %d], size: %d, curSize: %d curWindowLoc[%d,%d] pivot[%f, %f]", new Object[] { Integer.valueOf(localObject1[0]), Integer.valueOf(localObject1[1]), Integer.valueOf(localObject2[0]), Integer.valueOf(localObject2[1]), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramMessage[0]), Integer.valueOf(paramMessage[1]), Float.valueOf(f3), Float.valueOf(f6) }));
        }
        f3 = f1;
        f1 = f4;
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "icon end anim [scale: %f, transX: %f, transY: %f]  [%f, %f]", new Object[] { Float.valueOf(f3), Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(this.bn.getX()), Float.valueOf(this.bn.getY()) }));
        }
        paramMessage = PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat((2460.0F - 1940.0F) / f5, 1.0F), Keyframe.ofFloat(1.0F, 0.0F) });
        localObject1 = PropertyValuesHolder.ofKeyframe("scale", new Keyframe[] { Keyframe.ofFloat(0.0F, 1.0F), Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 1.0F), Keyframe.ofFloat((2480.0F - 1940.0F) / f5, f3), Keyframe.ofFloat(1.0F, f3) });
        localObject2 = Keyframe.ofFloat(0.0F, 0.0F);
        Keyframe localKeyframe1 = Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F);
        localKeyframe1.setInterpolator(new AccelerateDecelerateInterpolator());
        localObject2 = PropertyValuesHolder.ofKeyframe("translationX", new Keyframe[] { localObject2, localKeyframe1, Keyframe.ofFloat((2480.0F - 1940.0F) / f5, f2), Keyframe.ofFloat(1.0F, f2) });
        localKeyframe1 = Keyframe.ofFloat(0.0F, 0.0F);
        Keyframe localKeyframe2 = Keyframe.ofFloat((2100.0F - 1940.0F) / f5, 0.0F);
        localKeyframe2.setInterpolator(new AccelerateDecelerateInterpolator());
        paramMessage = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { paramMessage, localObject1, localObject2, PropertyValuesHolder.ofKeyframe("translationY", new Keyframe[] { localKeyframe1, localKeyframe2, Keyframe.ofFloat((2480.0F - 1940.0F) / f5, f1), Keyframe.ofFloat(1.0F, f1) }) });
        this.CP.add(new mqq.util.WeakReference(paramMessage));
        paramMessage.addUpdateListener(new ajah(this));
        paramMessage.setDuration((f5 * 1.0F));
        paramMessage.start();
        this.jdField_a_of_type_Auru.sendEmptyMessageDelayed(3, (f5 * 1.0F) + 200L);
        break;
        paramMessage = (View)this.hn.get();
        break label603;
        label1356:
        f1 = j / i;
        break label678;
        label1367:
        f2 = -this.bn.getX() - i / 2.0F;
        f1 = -this.bn.getY() - i / 2.0F;
        f3 = 0.2F;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MedalWallMng", 4, "MSG_START_3D_ROTATE");
      }
      f1 = this.bn.getWidth() / 2;
      f2 = this.bn.getHeight() / 2;
      this.jdField_a_of_type_Ajal = new ajal(0.0F, -24.0F * 0.65F, f1, f2, 0.0F, true);
      this.jdField_a_of_type_Ajal.setDuration(260L);
      this.jdField_a_of_type_Ajal.setFillAfter(true);
      this.jdField_a_of_type_Ajal.setAnimationListener(this);
      this.b = new ajal(-24.0F * 0.65F, 15.0F * 0.65F, f1, f2, 0.0F, false);
      this.b.setDuration(260L);
      this.b.setFillAfter(true);
      this.b.setAnimationListener(this);
      this.c = new ajal(15.0F * 0.65F, 0.0F, f1, f2, 0.0F, true);
      this.c.setDuration(300L);
      this.c.setFillAfter(true);
      this.c.setAnimationListener(this);
      this.bn.startAnimation(this.jdField_a_of_type_Ajal);
      this.jdField_a_of_type_Ajak = new ajak(this, 2, 100, lO);
      this.jdField_a_of_type_Ajak.init(getWidth(), getHeight());
      continue;
      close();
      continue;
      this.cne = true;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_Ajal) {
      this.bn.startAnimation(this.b);
    }
    do
    {
      return;
      if (paramAnimation == this.b)
      {
        this.bn.startAnimation(this.c);
        return;
      }
    } while (paramAnimation != this.c);
    this.cne = true;
    this.jdField_a_of_type_Auru.removeMessages(5);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ha(paramView);
      continue;
      if (this.mActivityRef == null) {}
      for (Object localObject = null;; localObject = (BaseActivity)this.mActivityRef.get())
      {
        if (localObject != null)
        {
          String str = ((MedalWallMng)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(250)).b(true, ((BaseActivity)localObject).getCurrentAccountUin(), MedalWallMng.dhs);
          str = String.format(Locale.getDefault(), "%s&openMedalId=%s&openMedalLevel=%s", new Object[] { str, Integer.valueOf(this.dhm), Integer.valueOf(this.dhn) });
          Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
          localIntent.putExtra("url", str);
          ((BaseActivity)localObject).startActivity(localIntent);
          if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "enter medal url: %s", new Object[] { str }));
          }
          ThreadManager.post(new MedalGuideView.1(this), 5, null, false);
        }
        close();
        break;
      }
      if (!this.cne)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, "close when enter animation is not finished yet!");
        }
      }
      else if (!this.jdField_a_of_type_Auru.hasMessages(2)) {
        this.jdField_a_of_type_Auru.sendEmptyMessage(2);
      }
    }
  }
  
  public static class a
    extends PopupWindow
  {
    private PopupWindow.OnDismissListener a;
    
    public a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt1, paramInt2, paramBoolean);
    }
    
    public void a(PopupWindow.OnDismissListener paramOnDismissListener)
    {
      this.a = paramOnDismissListener;
    }
    
    public void dismiss()
    {
      if (this.a != null)
      {
        this.a.onDismiss();
        return;
      }
      super.dismiss();
    }
    
    public void superDismiss()
    {
      super.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalGuideView
 * JD-Core Version:    0.7.0.1
 */