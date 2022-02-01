package com.tencent.mobileqq.avatar.dynamicavatar;

import acfp;
import advr;
import adwc;
import adwd;
import adwe;
import adwf;
import ajrb;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoko;
import aomd;
import aooi;
import aook;
import aqep;
import aqhq;
import aqiw;
import arib;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.DrawableSeekbar.a;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler.a;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import mqq.util.WeakReference;
import zsq;

public class SelectCoverActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnTouchListener, DrawableSeekbar.a, VideoDrawableHandler.a
{
  View Bi;
  View Bj;
  View Bk;
  advr jdField_a_of_type_Advr;
  adwf jdField_a_of_type_Adwf;
  a jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity$a;
  DrawableSeekbar jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar;
  VideoDrawableHandler jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler;
  CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  String aEu;
  volatile boolean aNl = false;
  int awN;
  adwf jdField_b_of_type_Adwf;
  arib jdField_b_of_type_Arib;
  Rect bJ = null;
  Rect bK = null;
  private boolean bRq;
  boolean bRt;
  int bYf;
  private String bvM;
  String bvN;
  String bvO;
  adwf c;
  int cKs;
  int cKt;
  Drawable eA;
  public Animator h = null;
  LinearLayout it;
  String mFilePath;
  View mHeadView;
  int mSource;
  float mStartScale = 0.0F;
  Handler mSubHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  int mVideoDuration;
  View uc;
  
  private void A(int paramInt1, String paramString, int paramInt2)
  {
    this.mUiHandler.obtainMessage(7, paramInt1, paramInt2, paramString).sendToTarget();
  }
  
  private void L(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Adwf = new adwf(paramBitmap, getResources());
    this.jdField_b_of_type_Adwf = new adwf(paramBitmap, getResources());
    this.c = new adwf(paramBitmap, getResources());
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(this.jdField_a_of_type_Adwf);
    this.mHeadView.setBackgroundDrawable(this.c);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_Adwf);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_b_of_type_Adwf);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.c);
    this.c.GL(true);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setOnProgressChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumb(C(this.jdField_b_of_type_Adwf));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setMax((int)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.getDuration());
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumbSize(this.bYf, this.bYf);
  }
  
  private void aRw()
  {
    String str = adwc.af(this.mFilePath, 200);
    adwc.a(this.mFilePath, str, 200, this);
    this.jdField_a_of_type_Advr.bvJ = str;
    str = adwc.af(this.mFilePath, 100);
    adwc.a(this.mFilePath, str, 100, this);
    this.jdField_a_of_type_Advr.bvK = str;
    if ((this.jdField_b_of_type_Arib != null) && (this.jdField_b_of_type_Arib.isShowing())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if ((TextUtils.isEmpty(this.jdField_a_of_type_Advr.bvJ)) || (!new File(this.jdField_a_of_type_Advr.bvJ).exists()) || (TextUtils.isEmpty(this.jdField_a_of_type_Advr.bvK)) || (!new File(this.jdField_a_of_type_Advr.bvK).exists())) {
          break;
        }
        cUP();
      }
      return;
    }
    this.jdField_b_of_type_Arib.dismiss();
    A(2, acfp.m(2131714195), 0);
  }
  
  private boolean afH()
  {
    boolean bool = false;
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    if (str.equalsIgnoreCase("Xiaomi-MI NOTE Pro")) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "isxiaomi:" + bool + " deviceinfo:" + str);
    }
    return bool;
  }
  
  private void cUP()
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity$a.addFilter(new Class[] { aomd.class });
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity$a);
    this.awN = ((int)(System.currentTimeMillis() / 1000L));
    adwc.a(this.app, this.mFilePath, 36, this.awN, 640);
    aqep.Us(this.mFilePath);
  }
  
  private void initTitle()
  {
    setRightButton(2131721066, this);
    if (this.mSource == 3) {
      setTitle("设置QQ动态头像");
    }
    for (;;)
    {
      if (ThemeUtil.isNowThemeIsSimple(this.app, false, null))
      {
        this.leftView.setBackgroundResource(2130851760);
        this.rightViewText.setTextColor(getResources().getColorStateList(2131166626));
        this.centerView.setTextColor(getResources().getColorStateList(2131166626));
      }
      int i = Color.parseColor("#1a1a1a");
      getTitleBarView().setBackgroundDrawable(null);
      getTitleBarView().setBackgroundColor(i);
      if (this.mSystemBarComp != null)
      {
        this.mSystemBarComp.setStatusDrawable(null);
        this.mSystemBarComp.setStatusBarDrawable(null);
        this.mSystemBarComp.setStatusColor(i);
        this.mSystemBarComp.setStatusBarColor(i);
      }
      return;
      setTitle(acfp.m(2131714193));
    }
  }
  
  @TargetApi(11)
  private void initViews()
  {
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)findViewById(2131373566));
    this.mHeadView = findViewById(2131368375);
    this.Bj = findViewById(2131365322);
    this.Bi = findViewById(2131368382);
    this.uc = findViewById(2131368407);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar = ((DrawableSeekbar)findViewById(2131377920));
    this.it = ((LinearLayout)findViewById(2131370751));
    this.Bk = findViewById(2131380747);
    int k = ImmersiveUtils.getScreenWidth();
    int j = ImmersiveUtils.getScreenHeight();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = k;
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    int m = (int)(0.125D * j);
    int i = (int)(0.125F * k);
    j = (int)(j - (getTitleBarHeight() + m + this.mDensity * 100.0F + ImmersiveUtils.getStatusBarHeight(this)));
    int n = k - i * 2;
    float f = j / n;
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "remainHeight:" + j + " remainWidth:" + n + " scale:" + f);
    }
    if (f < 1.229437F)
    {
      j = (int)(0.5F * (k - j / 1.229437F));
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("SelectCoverActivity", 2, "recalc margin margin:" + j);
        i = j;
      }
    }
    localObject = (RelativeLayout.LayoutParams)this.uc.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
    this.uc.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (Build.VERSION.SDK_INT <= 9)
    {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setVisibility(8);
      findViewById(2131379630).setVisibility(8);
      this.Bk.setVisibility(8);
    }
    for (;;)
    {
      localObject = (RelativeLayout.LayoutParams)this.mHeadView.getLayoutParams();
      if (afH())
      {
        ((RelativeLayout.LayoutParams)localObject).rightMargin += 10;
        ((RelativeLayout.LayoutParams)localObject).topMargin += 50;
        ((RelativeLayout.LayoutParams)localObject).height = 154;
        ((RelativeLayout.LayoutParams)localObject).width = 154;
        this.mHeadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      this.cKt = ((int)getResources().getDimension(2131299611));
      this.bYf = ((int)getResources().getDimension(2131299615));
      localObject = (RelativeLayout.LayoutParams)this.Bk.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = m;
      this.Bk.setLayoutParams((ViewGroup.LayoutParams)localObject);
      i = (int)getResources().getDimension(2131299610);
      this.cKs = ((k - i * 2) / this.cKt);
      if ((k - i * 2) % this.cKt != 0) {
        this.cKs += 1;
      }
      localObject = new LinearLayout.LayoutParams(this.cKt, this.cKt);
      if (this.eA == null) {
        this.eA = new ColorDrawable(-2147483648);
      }
      i = 0;
      while (i < this.cKs)
      {
        CustomImgView localCustomImgView = new CustomImgView(this);
        localCustomImgView.Hi.setScaleType(ImageView.ScaleType.FIT_XY);
        localCustomImgView.setBackgroundDrawable(this.eA);
        this.it.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject);
        i += 1;
      }
    }
  }
  
  private void k(View paramView1, View paramView2)
  {
    this.bJ = new Rect();
    this.bK = new Rect();
    Point localPoint = new Point();
    paramView1.getGlobalVisibleRect(this.bJ);
    this.Bj.getGlobalVisibleRect(this.bK, localPoint);
    paramView2.getGlobalVisibleRect(this.bK);
    this.bJ.offset(-localPoint.x, -localPoint.y);
    this.bK.offset(-localPoint.x, -localPoint.y);
    if (this.bK.width() / this.bK.height() > this.bJ.width() / this.bJ.height())
    {
      this.mStartScale = (this.bJ.height() / this.bK.height());
      f = (this.mStartScale * this.bK.width() - this.bJ.width()) / 2.0F;
      paramView1 = this.bJ;
      paramView1.left = ((int)(paramView1.left - f));
      paramView1 = this.bJ;
      paramView1.right = ((int)(f + paramView1.right));
      return;
    }
    this.mStartScale = (this.bJ.width() / this.bK.width());
    float f = (this.mStartScale * this.bK.height() - this.bJ.height()) / 2.0F;
    paramView1 = this.bJ;
    paramView1.top = ((int)(paramView1.top - f));
    paramView1 = this.bJ;
    paramView1.bottom = ((int)(f + paramView1.bottom));
  }
  
  private int vu()
  {
    int i = 1;
    if (this.mSource == 1) {
      i = 0;
    }
    return i;
  }
  
  private void zoomIn()
  {
    if (VersionUtils.isIceScreamSandwich())
    {
      j(this.mHeadView, this.jdField_a_of_type_ComTencentWidgetCustomImgView);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
    this.mHeadView.setVisibility(8);
    this.Bi.setVisibility(8);
    this.Bk.setVisibility(8);
  }
  
  private void zoomOut()
  {
    if (VersionUtils.isIceScreamSandwich())
    {
      l(this.mHeadView, this.jdField_a_of_type_ComTencentWidgetCustomImgView);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setVisibility(8);
    this.mHeadView.setVisibility(0);
    this.Bi.setVisibility(0);
    this.Bk.setVisibility(0);
  }
  
  Drawable C(Drawable paramDrawable)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { paramDrawable, (GradientDrawable)getResources().getDrawable(2130846774) });
    int i = (int)(1.0F * ImmersiveUtils.getDensity());
    paramDrawable.setLayerInset(0, i, i, i, i);
    return paramDrawable;
  }
  
  public void Ce(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.onProgressUpdate(paramInt);
  }
  
  boolean afG()
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler = new VideoDrawableHandler(this.app, this);
    if (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.init(this.mFilePath))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "doOnCreate return file error");
      }
      finish();
      return false;
    }
    return true;
  }
  
  public void bZJ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekStart");
    }
    adwc.b(this.app, "0X800710B", vu());
    if (this.mUiHandler.hasMessages(8)) {
      this.mUiHandler.removeMessages(8);
    }
    zoomIn();
    this.bRt = true;
  }
  
  /* Error */
  String c(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 231	java/io/File
    //   3: dup
    //   4: getstatic 699	acbn:bna	Ljava/lang/String;
    //   7: invokestatic 705	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 708	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 231	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: new 253	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 710
    //   34: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokestatic 327	java/lang/System:currentTimeMillis	()J
    //   40: invokevirtual 713	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 716	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 6
    //   51: aload 6
    //   53: invokevirtual 237	java/io/File:exists	()Z
    //   56: ifeq +9 -> 65
    //   59: aload 6
    //   61: invokevirtual 719	java/io/File:delete	()Z
    //   64: pop
    //   65: new 721	java/io/FileOutputStream
    //   68: dup
    //   69: aload 6
    //   71: invokespecial 724	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   74: astore_2
    //   75: new 726	java/io/BufferedOutputStream
    //   78: dup
    //   79: aload_2
    //   80: sipush 4096
    //   83: invokespecial 729	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   86: astore 5
    //   88: aload 5
    //   90: astore 4
    //   92: aload_2
    //   93: astore_3
    //   94: aload_1
    //   95: getstatic 735	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload 5
    //   102: invokevirtual 741	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   105: pop
    //   106: aload 5
    //   108: astore 4
    //   110: aload_2
    //   111: astore_3
    //   112: aload 5
    //   114: invokevirtual 744	java/io/BufferedOutputStream:flush	()V
    //   117: aload 5
    //   119: astore 4
    //   121: aload_2
    //   122: astore_3
    //   123: aload 6
    //   125: invokevirtual 747	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: astore 6
    //   130: aload 6
    //   132: astore_3
    //   133: aload_2
    //   134: ifnull +7 -> 141
    //   137: aload_2
    //   138: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   141: aload_3
    //   142: astore_2
    //   143: aload 5
    //   145: ifnull +10 -> 155
    //   148: aload 5
    //   150: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   153: aload_3
    //   154: astore_2
    //   155: aload_0
    //   156: getfield 194	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:bRq	Z
    //   159: ifeq +148 -> 307
    //   162: new 231	java/io/File
    //   165: dup
    //   166: getstatic 754	acbn:bnE	Ljava/lang/String;
    //   169: invokespecial 234	java/io/File:<init>	(Ljava/lang/String;)V
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 237	java/io/File:exists	()Z
    //   177: ifne +8 -> 185
    //   180: aload_3
    //   181: invokevirtual 708	java/io/File:mkdirs	()Z
    //   184: pop
    //   185: new 231	java/io/File
    //   188: dup
    //   189: aload_3
    //   190: ldc_w 756
    //   193: invokespecial 716	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   196: astore 6
    //   198: aload 6
    //   200: invokevirtual 237	java/io/File:exists	()Z
    //   203: ifeq +9 -> 212
    //   206: aload 6
    //   208: invokevirtual 719	java/io/File:delete	()Z
    //   211: pop
    //   212: new 721	java/io/FileOutputStream
    //   215: dup
    //   216: aload 6
    //   218: invokespecial 724	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   221: astore_3
    //   222: new 726	java/io/BufferedOutputStream
    //   225: dup
    //   226: aload_3
    //   227: invokespecial 759	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   230: astore 7
    //   232: aload 7
    //   234: astore 5
    //   236: aload_3
    //   237: astore 4
    //   239: aload_1
    //   240: sipush 200
    //   243: sipush 200
    //   246: iconst_1
    //   247: invokestatic 763	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   250: getstatic 735	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   253: bipush 100
    //   255: aload 7
    //   257: invokevirtual 741	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   260: pop
    //   261: aload 7
    //   263: astore 5
    //   265: aload_3
    //   266: astore 4
    //   268: aload 7
    //   270: invokevirtual 744	java/io/BufferedOutputStream:flush	()V
    //   273: aload 7
    //   275: astore 5
    //   277: aload_3
    //   278: astore 4
    //   280: aload_0
    //   281: aload 6
    //   283: invokevirtual 747	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   286: putfield 184	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:bvM	Ljava/lang/String;
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   297: aload 7
    //   299: ifnull +8 -> 307
    //   302: aload 7
    //   304: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   307: invokestatic 285	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +30 -> 340
    //   313: ldc_w 287
    //   316: iconst_2
    //   317: new 253	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 765
    //   327: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_2
    //   331: invokevirtual 263	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 298	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_2
    //   341: areturn
    //   342: astore_2
    //   343: aload_2
    //   344: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   347: goto -206 -> 141
    //   350: astore_2
    //   351: aload_2
    //   352: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   355: aload_3
    //   356: astore_2
    //   357: goto -202 -> 155
    //   360: astore 6
    //   362: aconst_null
    //   363: astore 5
    //   365: aconst_null
    //   366: astore_2
    //   367: aload 5
    //   369: astore 4
    //   371: aload_2
    //   372: astore_3
    //   373: aload 6
    //   375: invokevirtual 769	java/io/FileNotFoundException:printStackTrace	()V
    //   378: aload_2
    //   379: ifnull +7 -> 386
    //   382: aload_2
    //   383: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   386: aload 5
    //   388: ifnull +304 -> 692
    //   391: aload 5
    //   393: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   396: aconst_null
    //   397: astore_2
    //   398: goto -243 -> 155
    //   401: astore_2
    //   402: aload_2
    //   403: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   406: goto -20 -> 386
    //   409: astore_2
    //   410: aload_2
    //   411: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   414: aconst_null
    //   415: astore_2
    //   416: goto -261 -> 155
    //   419: astore 6
    //   421: aconst_null
    //   422: astore 5
    //   424: aconst_null
    //   425: astore_2
    //   426: aload 5
    //   428: astore 4
    //   430: aload_2
    //   431: astore_3
    //   432: aload 6
    //   434: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   437: aload_2
    //   438: ifnull +7 -> 445
    //   441: aload_2
    //   442: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   445: aload 5
    //   447: ifnull +245 -> 692
    //   450: aload 5
    //   452: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   455: aconst_null
    //   456: astore_2
    //   457: goto -302 -> 155
    //   460: astore_2
    //   461: aload_2
    //   462: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   465: goto -20 -> 445
    //   468: astore_2
    //   469: aload_2
    //   470: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   473: aconst_null
    //   474: astore_2
    //   475: goto -320 -> 155
    //   478: astore_1
    //   479: aconst_null
    //   480: astore 4
    //   482: aconst_null
    //   483: astore_2
    //   484: aload_2
    //   485: ifnull +7 -> 492
    //   488: aload_2
    //   489: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   492: aload 4
    //   494: ifnull +8 -> 502
    //   497: aload 4
    //   499: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   502: aload_1
    //   503: athrow
    //   504: astore_2
    //   505: aload_2
    //   506: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   509: goto -17 -> 492
    //   512: astore_2
    //   513: aload_2
    //   514: invokevirtual 768	java/io/IOException:printStackTrace	()V
    //   517: goto -15 -> 502
    //   520: astore 6
    //   522: aconst_null
    //   523: astore_3
    //   524: aconst_null
    //   525: astore_1
    //   526: aload_1
    //   527: astore 5
    //   529: aload_3
    //   530: astore 4
    //   532: ldc_w 287
    //   535: iconst_1
    //   536: ldc_w 771
    //   539: aload 6
    //   541: invokestatic 775	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   544: aload_1
    //   545: astore 5
    //   547: aload_3
    //   548: astore 4
    //   550: aload_0
    //   551: aconst_null
    //   552: putfield 184	com/tencent/mobileqq/avatar/dynamicavatar/SelectCoverActivity:bvM	Ljava/lang/String;
    //   555: aload_3
    //   556: ifnull +7 -> 563
    //   559: aload_3
    //   560: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   563: aload_1
    //   564: ifnull -257 -> 307
    //   567: aload_1
    //   568: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   571: goto -264 -> 307
    //   574: astore_1
    //   575: goto -268 -> 307
    //   578: astore_1
    //   579: aconst_null
    //   580: astore 5
    //   582: aconst_null
    //   583: astore_3
    //   584: aload_3
    //   585: ifnull +7 -> 592
    //   588: aload_3
    //   589: invokevirtual 750	java/io/FileOutputStream:close	()V
    //   592: aload 5
    //   594: ifnull +8 -> 602
    //   597: aload 5
    //   599: invokevirtual 751	java/io/BufferedOutputStream:close	()V
    //   602: aload_1
    //   603: athrow
    //   604: astore_1
    //   605: goto -308 -> 297
    //   608: astore_1
    //   609: goto -302 -> 307
    //   612: astore_3
    //   613: goto -50 -> 563
    //   616: astore_2
    //   617: goto -25 -> 592
    //   620: astore_2
    //   621: goto -19 -> 602
    //   624: astore_1
    //   625: aconst_null
    //   626: astore 5
    //   628: goto -44 -> 584
    //   631: astore_1
    //   632: aload 4
    //   634: astore_3
    //   635: goto -51 -> 584
    //   638: astore 6
    //   640: aconst_null
    //   641: astore_1
    //   642: goto -116 -> 526
    //   645: astore 6
    //   647: aload 7
    //   649: astore_1
    //   650: goto -124 -> 526
    //   653: astore_1
    //   654: aconst_null
    //   655: astore 4
    //   657: goto -173 -> 484
    //   660: astore_1
    //   661: aload_3
    //   662: astore_2
    //   663: goto -179 -> 484
    //   666: astore 6
    //   668: aconst_null
    //   669: astore 5
    //   671: goto -245 -> 426
    //   674: astore 6
    //   676: goto -250 -> 426
    //   679: astore 6
    //   681: aconst_null
    //   682: astore 5
    //   684: goto -317 -> 367
    //   687: astore 6
    //   689: goto -322 -> 367
    //   692: aconst_null
    //   693: astore_2
    //   694: goto -539 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	SelectCoverActivity
    //   0	697	1	paramBitmap	Bitmap
    //   13	328	2	localObject1	Object
    //   342	2	2	localIOException1	java.io.IOException
    //   350	2	2	localIOException2	java.io.IOException
    //   356	42	2	localObject2	Object
    //   401	2	2	localIOException3	java.io.IOException
    //   409	2	2	localIOException4	java.io.IOException
    //   415	42	2	localObject3	Object
    //   460	2	2	localIOException5	java.io.IOException
    //   468	2	2	localIOException6	java.io.IOException
    //   474	15	2	localObject4	Object
    //   504	2	2	localIOException7	java.io.IOException
    //   512	2	2	localIOException8	java.io.IOException
    //   616	1	2	localException1	Exception
    //   620	1	2	localException2	Exception
    //   662	32	2	localObject5	Object
    //   93	496	3	localObject6	Object
    //   612	1	3	localException3	Exception
    //   634	28	3	localObject7	Object
    //   90	566	4	localObject8	Object
    //   86	597	5	localObject9	Object
    //   49	233	6	localObject10	Object
    //   360	14	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   419	14	6	localIOException9	java.io.IOException
    //   520	20	6	localException4	Exception
    //   638	1	6	localException5	Exception
    //   645	1	6	localException6	Exception
    //   666	1	6	localIOException10	java.io.IOException
    //   674	1	6	localIOException11	java.io.IOException
    //   679	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   687	1	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   230	418	7	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   137	141	342	java/io/IOException
    //   148	153	350	java/io/IOException
    //   65	75	360	java/io/FileNotFoundException
    //   382	386	401	java/io/IOException
    //   391	396	409	java/io/IOException
    //   65	75	419	java/io/IOException
    //   441	445	460	java/io/IOException
    //   450	455	468	java/io/IOException
    //   65	75	478	finally
    //   488	492	504	java/io/IOException
    //   497	502	512	java/io/IOException
    //   212	222	520	java/lang/Exception
    //   567	571	574	java/lang/Exception
    //   212	222	578	finally
    //   293	297	604	java/lang/Exception
    //   302	307	608	java/lang/Exception
    //   559	563	612	java/lang/Exception
    //   588	592	616	java/lang/Exception
    //   597	602	620	java/lang/Exception
    //   222	232	624	finally
    //   239	261	631	finally
    //   268	273	631	finally
    //   280	289	631	finally
    //   532	544	631	finally
    //   550	555	631	finally
    //   222	232	638	java/lang/Exception
    //   239	261	645	java/lang/Exception
    //   268	273	645	java/lang/Exception
    //   280	289	645	java/lang/Exception
    //   75	88	653	finally
    //   94	106	660	finally
    //   112	117	660	finally
    //   123	130	660	finally
    //   373	378	660	finally
    //   432	437	660	finally
    //   75	88	666	java/io/IOException
    //   94	106	674	java/io/IOException
    //   112	117	674	java/io/IOException
    //   123	130	674	java/io/IOException
    //   75	88	679	java/io/FileNotFoundException
    //   94	106	687	java/io/FileNotFoundException
    //   112	117	687	java/io/FileNotFoundException
    //   123	130	687	java/io/FileNotFoundException
  }
  
  public void cUO()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onSeekEnd");
    }
    if (this.mUiHandler.hasMessages(8)) {
      this.mUiHandler.removeMessages(8);
    }
    this.mUiHandler.sendEmptyMessageDelayed(8, 400L);
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.mSource = getIntent().getIntExtra("param_source", 0);
    this.bRq = getIntent().getBooleanExtra("param_from_newer_guide", false);
    if (this.mSource == 0) {
      throw new IllegalArgumentException("source must not be null");
    }
    this.mVideoDuration = getIntent().getIntExtra("key_video_duration", 0);
    this.bvN = getIntent().getStringExtra("key_video_has_voice");
    this.bvO = getIntent().getStringExtra("key_camera_id");
    this.jdField_a_of_type_Advr = ((advr)this.app.getManager(180));
    this.jdField_a_of_type_Advr.bvJ = null;
    this.jdField_a_of_type_Advr.bvK = null;
    setContentView(getLayoutInflater().inflate(2131561613, null));
    initTitle();
    getWindow().setBackgroundDrawable(null);
    initViews();
    this.mFilePath = getIntent().getStringExtra("key_video_file_path");
    if (!aqhq.fileExists(this.mFilePath))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "doOnCreate return filepath:" + this.mFilePath);
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity$a = new a(this.app, this);
    if (Build.VERSION.SDK_INT <= 9) {
      ThreadManager.postImmediately(new SelectCoverActivity.1(this), null, true);
    }
    for (;;)
    {
      if (this.mSource == 3) {
        zsq.B(this, this.mFilePath);
      }
      return true;
      ThreadManager.postImmediately(new SelectCoverActivity.2(this), null, true);
    }
  }
  
  @TargetApi(11)
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.aNl = true;
    this.mSubHandler.removeCallbacksAndMessages(null);
    this.mUiHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.destroy();
    }
    if (this.h != null) {
      this.h.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity$a != null) {
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarSelectCoverActivity$a);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    initTitle();
  }
  
  public void hD(int paramInt1, int paramInt2)
  {
    if (this.mUiHandler.hasMessages(5)) {
      this.mUiHandler.removeMessages(5);
    }
    Message localMessage = this.mUiHandler.obtainMessage(5, paramInt1, paramInt2);
    this.mUiHandler.sendMessageDelayed(localMessage, 300L);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
      int i;
      int j;
      do
      {
        do
        {
          Object localObject;
          CustomImgView localCustomImgView;
          do
          {
            return true;
            i = paramMessage.arg1;
            j = paramMessage.arg2;
            localObject = (Object[])paramMessage.obj;
            paramMessage = (Bitmap)localObject[0];
            localObject = (Animation)localObject[1];
            localCustomImgView = (CustomImgView)this.it.getChildAt(i);
            localCustomImgView.setImageBitmap(paramMessage);
            localCustomImgView.setTag(Integer.valueOf(j));
            localCustomImgView.setOnTouchListener(this);
          } while (localObject == null);
          localCustomImgView.startAnimation((Animation)localObject);
          return true;
          L((Bitmap)paramMessage.obj);
          Ce(0);
          return true;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.clearTask();
          Ce(paramMessage.arg1);
          return true;
          this.c = new adwf((Bitmap)paramMessage.obj, getResources());
          this.c.GL(true);
          this.mHeadView.setBackgroundDrawable(this.c);
          this.mHeadView.setVisibility(0);
          return true;
          i = paramMessage.arg1;
        } while (paramMessage.arg2 == 0);
        float f = i / 1000.0F;
        QQToast.a(this, String.format(acfp.m(2131714188), new Object[] { Float.valueOf(f) }), 0).show();
        return true;
        QQToast.a(this, acfp.m(2131714199), 0).show();
        return true;
        i = paramMessage.arg1;
        j = paramMessage.arg2;
        paramMessage = (String)paramMessage.obj;
      } while ((this.aNl) || (this.jdField_b_of_type_Arib == null));
      this.jdField_b_of_type_Arib.aa(i, paramMessage, j);
      return true;
    }
    zoomOut();
    return true;
  }
  
  boolean iR(int paramInt)
  {
    if (paramInt > this.cKs - 1) {
      return true;
    }
    int i = (int)(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.getDuration() / (this.cKs - 1));
    if (paramInt == this.cKs - 1) {
      i = (int)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.getDuration();
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.k(i);
        if (localObject1 == null) {
          continue;
        }
        localBitmap = adwc.j((Bitmap)localObject1, this.cKt, this.cKt);
        if ((localObject1 == null) || (localObject1 == localBitmap) || (((Bitmap)localObject1).isRecycled())) {
          continue;
        }
        ((Bitmap)localObject1).recycle();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject1;
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          break label280;
        }
        QLog.i("SelectCoverActivity", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label280;
        }
        localException.printStackTrace();
        break label280;
        continue;
      }
      if (paramInt == 0) {
        this.mUiHandler.obtainMessage(1, localBitmap).sendToTarget();
      }
      localObject1 = null;
      try
      {
        localObject2 = AnimationUtils.loadAnimation(this, 2130772303);
        localObject1 = localObject2;
        ((Animation)localObject2).setInterpolator(new DecelerateInterpolator(2.0F));
        localObject1 = localObject2;
        ((Animation)localObject2).setFillAfter(false);
        localObject1 = localObject2;
        ((Animation)localObject2).setDuration(50L);
      }
      catch (Throwable localThrowable)
      {
        Object localObject2 = localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("SelectCoverActivity", 2, localThrowable.getMessage(), localThrowable);
        localObject2 = localObject1;
        continue;
      }
      this.mUiHandler.obtainMessage(0, paramInt, i, new Object[] { localBitmap, localObject2 }).sendToTarget();
      break label280;
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.av();
      continue;
      label280:
      return false;
      i *= paramInt;
    }
  }
  
  @TargetApi(14)
  public void j(View paramView1, View paramView2)
  {
    if (this.h != null) {
      this.h.cancel();
    }
    if ((this.bJ == null) || (this.bK == null) || (this.mStartScale <= 0.0F)) {
      k(paramView1, paramView2);
    }
    paramView2.setVisibility(0);
    paramView1.setAlpha(0.0F);
    paramView2.setPivotX(0.0F);
    paramView2.setPivotY(0.0F);
    this.Bi.setVisibility(8);
    this.Bk.setVisibility(8);
    paramView1 = new AnimatorSet();
    paramView1.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.bJ.left, this.bK.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.bJ.top, this.bK.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.mStartScale, 1.0F })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.mStartScale, 1.0F }));
    paramView1.setDuration(250L);
    paramView1.setInterpolator(new DecelerateInterpolator());
    paramView1.addListener(new adwd(this));
    paramView1.start();
    this.h = paramView1;
  }
  
  @TargetApi(14)
  public void l(View paramView1, View paramView2)
  {
    if (this.h != null) {
      this.h.cancel();
    }
    if ((this.bJ == null) || (this.bK == null) || (this.mStartScale <= 0.0F)) {
      return;
    }
    this.Bi.setVisibility(0);
    this.Bk.setVisibility(0);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(paramView2, View.X, new float[] { this.bJ.left })).with(ObjectAnimator.ofFloat(paramView2, View.Y, new float[] { this.bJ.top })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_X, new float[] { this.mStartScale })).with(ObjectAnimator.ofFloat(paramView2, View.SCALE_Y, new float[] { this.mStartScale }));
    localAnimatorSet.setDuration(250L);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.addListener(new adwe(this, paramView1, paramView2));
    localAnimatorSet.start();
    this.h = localAnimatorSet;
  }
  
  public boolean onBackEvent()
  {
    adwc.b(this.app, "0X800710C", vu());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      adwc.b(this.app, "0X800710D", vu());
      if (!aqep.aBY()) {
        break label48;
      }
      A(2, acfp.m(2131714197), 0);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      if (aqiw.isNetworkAvailable(this)) {
        break;
      }
      QQToast.a(this, 1, getString(2131696272), 0).show(getTitleBarHeight());
    }
    Object localObject = this.mHeadView.getBackground();
    if ((localObject != null) && ((localObject instanceof BitmapDrawable))) {
      localObject = ((BitmapDrawable)localObject).getBitmap();
    }
    for (;;)
    {
      if (localObject == null)
      {
        QQToast.a(this, acfp.m(2131714194), 0).show();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("SelectCoverActivity", 2, "android version:" + Build.VERSION.SDK_INT);
        break;
        if ((localObject == null) || (!(localObject instanceof adwf))) {
          break label233;
        }
        localObject = ((adwf)localObject).getBitmap();
        continue;
      }
      if (this.jdField_b_of_type_Arib == null) {
        this.jdField_b_of_type_Arib = new arib(this);
      }
      A(0, acfp.m(2131714190), 0);
      ThreadManager.postImmediately(new SelectCoverActivity.3(this, (Bitmap)localObject), null, true);
      break;
      label233:
      localObject = null;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!(paramView instanceof CustomImgView)) {}
    do
    {
      return false;
      paramView = (CustomImgView)paramView;
    } while (!this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.isEnable());
    int i = ((Integer)paramView.getTag()).intValue();
    this.mSubHandler.obtainMessage(2, i, 0).sendToTarget();
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableDrawableSeekbar.setThumbOffset(paramView.getLeft());
    adwc.b(this.app, "0X800710A", vu());
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "onTouchDown");
    }
    zoomIn();
    if (this.mUiHandler.hasMessages(8)) {
      this.mUiHandler.removeMessages(8);
    }
    this.mUiHandler.sendEmptyMessageDelayed(8, 400L);
    this.bRt = true;
    return false;
  }
  
  static class a
    extends aook
  {
    WeakReference<QQAppInterface> ap;
    WeakReference<SelectCoverActivity> aq;
    
    a(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity)
    {
      this.ap = new WeakReference(paramQQAppInterface);
      this.aq = new WeakReference(paramSelectCoverActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.ap.get();
      SelectCoverActivity localSelectCoverActivity = (SelectCoverActivity)this.aq.get();
      if ((localQQAppInterface == null) || (localSelectCoverActivity == null)) {}
      Object localObject;
      label298:
      do
      {
        return;
        localObject = (aoko)paramMessage.obj;
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1003: 
          if (((aoko)localObject).fileType == 48)
          {
            paramMessage = ((aomd)((aoko)localObject).a).clS;
            if (QLog.isColorLevel()) {
              QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + paramMessage);
            }
            paramMessage = (CardHandler)localQQAppInterface.getBusinessHandler(2);
            if (paramMessage != null) {
              paramMessage.p(true, localQQAppInterface.getCurrentAccountUin(), 0);
            }
            aqep.Us(null);
            if (((Integer)ajrb.c(localQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
              ajrb.c(localQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
            }
            if (localSelectCoverActivity.mSource != 3)
            {
              int i = localSelectCoverActivity.mVideoDuration;
              localObject = localSelectCoverActivity.bvN;
              String str = localSelectCoverActivity.bvO;
              if (localSelectCoverActivity.bRt)
              {
                paramMessage = "1";
                anot.a(localQQAppInterface, "dc00898", "", "", "0X800711D", "0X800711D", 0, 0, String.valueOf(i), (String)localObject, str, paramMessage);
              }
            }
            else
            {
              if (!SelectCoverActivity.a(localSelectCoverActivity)) {
                break label298;
              }
              paramMessage = new Intent();
              paramMessage.putExtra("key_photo_file_path", SelectCoverActivity.a(localSelectCoverActivity));
              localSelectCoverActivity.setResult(-1, paramMessage);
            }
            for (;;)
            {
              localSelectCoverActivity.finish();
              return;
              paramMessage = "0";
              break;
              if (localSelectCoverActivity.mSource == 3)
              {
                paramMessage = new Intent(localSelectCoverActivity, AvatarPendantActivity.class);
                localObject = localSelectCoverActivity.getIntent();
                paramMessage.putExtra("fromThirdApp", true);
                paramMessage.putExtra("pkg_name", ((Intent)localObject).getStringExtra("pkg_name"));
                paramMessage.putExtra("app_name", ((Intent)localObject).getStringExtra("app_name"));
                localObject = ((Intent)localObject).getStringExtra("share_id");
                paramMessage.putExtra("share_id", (String)localObject);
                anot.a(localQQAppInterface, "dc00898", "", "", "0X8009DFA", "0X8009DFA", 0, 0, (String)localObject, "", "", "");
                paramMessage.putExtra("AllInOne", new ProfileActivity.AllInOne(localQQAppInterface.getCurrentAccountUin(), 0));
                localSelectCoverActivity.startActivity(paramMessage);
              }
              else
              {
                localSelectCoverActivity.setResult(-1);
              }
            }
          }
          if (((aoko)localObject).fileType == 36)
          {
            paramMessage = ((aomd)((aoko)localObject).a).yc;
            if (QLog.isColorLevel()) {
              QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + paramMessage);
            }
            ThreadManager.post(new SelectCoverActivity.CoverTransProcessorHandler.1(this, localSelectCoverActivity, localQQAppInterface), 8, null, true);
            return;
          }
          if (((aoko)localObject).fileType == 37)
          {
            paramMessage = ((aomd)((aoko)localObject).a).yc;
            if (QLog.isColorLevel()) {
              QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), medium video upload success. videoId = " + paramMessage);
            }
            ThreadManager.post(new SelectCoverActivity.CoverTransProcessorHandler.2(this, localSelectCoverActivity, localQQAppInterface), 8, null, true);
            return;
          }
          break;
        }
      } while (((aoko)localObject).fileType != 38);
      paramMessage = ((aomd)((aoko)localObject).a).yc;
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), small video upload success. videoId = " + paramMessage);
      }
      adwc.U(localQQAppInterface, localSelectCoverActivity.aEu);
      aqep.Us(localSelectCoverActivity.aEu);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
      }
      SelectCoverActivity.a(localSelectCoverActivity, 2, acfp.m(2131714192), 0);
      aqep.Us(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity
 * JD-Core Version:    0.7.0.1
 */