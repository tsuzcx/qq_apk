package com.tencent.mobileqq.troop.activity;

import acbn;
import acfp;
import ahbj;
import alcb;
import alse;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aoiz;
import aomc;
import aotr;
import aots;
import aott;
import aotu;
import aotv;
import aotw;
import aotx;
import aoty;
import aotz;
import aoud;
import aoue;
import aoug;
import aouh;
import aoui;
import aouj;
import aouk;
import aoul;
import aoum;
import aoun;
import aouo;
import apqw;
import apvn;
import aqha;
import aqhu;
import aqju;
import arhz;
import ausj;
import auss;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.widget.ImageAnimationView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.Gallery;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import ivv;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kbp;
import kxm;
import lbz;
import lhu;
import nnw;
import odv;
import org.json.JSONObject;
import rvx;
import sxx;
import vdz;
import wja;
import zri;

public class TroopAvatarWallPreviewActivity
  extends BaseActivity
{
  static boolean mIsOpen;
  static Object sLock = new Object();
  public ArrayList<String> BA;
  public ArrayList<String> BB;
  protected ArrayList<Rect> BC;
  protected ArrayList<String> BD;
  protected ArrayList<String> BE;
  protected ArrayList<String> Bz;
  protected View HR;
  protected View HS;
  public List<String> Hj;
  protected List<String> Hk;
  public alcb a;
  public apvn a;
  arhz jdField_a_of_type_Arhz;
  private PublicAccountShowPictureReport jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport = new PublicAccountShowPictureReport();
  private a jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$a;
  public ImageAnimationView a;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  protected ImageButton aH;
  public String aWb;
  public TextView aab;
  protected TextView aac;
  protected TextView aad;
  public boolean animated = false;
  protected long aqA = 300L;
  public Gallery b;
  protected FrameLayout bY;
  public boolean cOF;
  public boolean cOG;
  public boolean cOH;
  public boolean cOI;
  public boolean cOJ;
  protected boolean cOK;
  protected boolean cOL;
  public boolean cOM;
  protected boolean cON = true;
  public boolean cOO;
  protected String cmY;
  protected String cmZ;
  public boolean cvT;
  public int dRK;
  protected View.OnClickListener dn = new aoue(this);
  private TranslateAnimation f;
  protected View fP;
  private View.OnClickListener fV = new aoum(this);
  private TranslateAnimation g;
  Runnable hI = null;
  private Bundle mExtras;
  public int mIndex;
  private boolean mIsBottomBarUp = true;
  protected ImageView mLikeBtn;
  private BroadcastReceiver mReceiver = new aoud(this);
  protected RelativeLayout mRoot;
  public TextView mTextView;
  public String mTroopUin;
  protected RelativeLayout mf;
  protected ImageView mv;
  public ImageView sf;
  protected boolean[] w;
  public View xR;
  
  public TroopAvatarWallPreviewActivity()
  {
    this.jdField_a_of_type_Alcb = new aoui(this);
  }
  
  private void N(int paramInt, Bundle paramBundle)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_Apvn.getCount() - 1) || (this.BA == null) || (paramInt > this.BA.size() - 1)) {
      return;
    }
    anot.a(this.app, "dc00898", "", "", "0X8007FD5", "0X8007FD5", 0, 0, "0", "0", "", "");
    aqha.a(this, 230).setTitle(getString(2131701512)).setPositiveButton(getString(2131721079), new aouh(this, paramBundle, paramInt)).setNegativeButton(getString(2131721058), new aoug(this)).show();
  }
  
  private void Qq()
  {
    if (this.b == null)
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    Object localObject = this.b.getSelectedView();
    if (localObject == null)
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    localObject = ((ImageView)((View)localObject).findViewById(2131368820)).getDrawable();
    if ((localObject == null) || (!(localObject instanceof URLDrawable)))
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    localObject = (URLDrawable)localObject;
    if (((URLDrawable)localObject).getStatus() != 1)
    {
      QQToast.a(this, getString(2131694552), 0).show();
      return;
    }
    if ("5".equals(this.cmY))
    {
      w((URLDrawable)localObject);
      return;
    }
    ausj localausj = (ausj)auss.a(this, null);
    if (this.cOI)
    {
      localausj.addButton(2131694752, 1);
      localausj.addButton(2131694762, 1);
      if (!getIntent().getBooleanExtra("from_photo_wall", false)) {
        ThreadManagerV2.excute(new TroopAvatarWallPreviewActivity.8(this, (URLDrawable)localObject, localausj), 128, null, false);
      }
    }
    if ((this.cOF) && (lT(this.mIndex))) {
      localausj.addButton(2131694749, 1);
    }
    if (this.cvT)
    {
      localausj.addButton(2131699972, 5);
      localausj.addButton(2131694749, 3);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new aouo(this, localausj, (URLDrawable)localObject));
    try
    {
      localausj.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void Wj(int paramInt)
  {
    int i;
    if ((this.Bz != null) && (paramInt < this.Bz.size()))
    {
      localObject = (String)this.Bz.get(paramInt);
      this.aab.setText(alse.e((String)localObject, this.app));
      TextView localTextView = this.aab;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        i = 8;
        localTextView.setVisibility(i);
      }
    }
    for (;;)
    {
      if ((this.w != null) && (this.w.length > paramInt)) {
        break label101;
      }
      return;
      i = 0;
      break;
      this.aab.setVisibility(8);
    }
    label101:
    Object localObject = this.mLikeBtn;
    if (this.w[paramInt] != 0) {}
    for (paramInt = 2130849469;; paramInt = 2130849472)
    {
      ((ImageView)localObject).setImageResource(paramInt);
      this.mIsBottomBarUp = LocalMultiProcConfig.getBool("BasePictureViewController#mIsBottomBarUp", true);
      if (!this.mIsBottomBarUp) {
        break;
      }
      if (!TextUtils.isEmpty(this.aab.getText())) {
        this.aab.setVisibility(0);
      }
      this.xR.setVisibility(0);
      ((ImageView)this.HR).setImageResource(2130849464);
      return;
    }
    this.aab.setVisibility(8);
    this.xR.setVisibility(8);
    ((ImageView)this.HR).setImageResource(2130849463);
  }
  
  private void Wk(int paramInt)
  {
    if ((this.BD != null) && (paramInt < this.BD.size()) && (!TextUtils.isEmpty((CharSequence)this.BD.get(paramInt))) && (aoiz.getFile((String)this.BD.get(paramInt)) == null))
    {
      if ((this.BE != null) && (!TextUtils.isEmpty((CharSequence)this.BE.get(paramInt)))) {}
      for (;;)
      {
        try
        {
          paramInt = Integer.parseInt((String)this.BE.get(paramInt));
          l = paramInt;
          if (l <= 0L) {
            break label173;
          }
          this.aad.setText(String.format(Locale.CHINA, getResources().getString(2131697154), new Object[] { ahbj.g(l) }));
          this.aad.setVisibility(0);
          LpReportInfo_pf00064.allReport(301, 34, 1);
          return;
        }
        catch (Exception localException)
        {
          QLog.e("TroopAvatarWallPreviewActivity", 2, "setOriginButton exception", localException);
        }
        long l = -1L;
        continue;
        label173:
        this.aad.setText(2131697151);
      }
    }
    this.aad.setVisibility(8);
  }
  
  private Bitmap a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, Drawable paramDrawable, boolean paramBoolean)
  {
    Rect localRect;
    if (this.BC != null)
    {
      localRect = (Rect)this.BC.get(this.mIndex);
      localObject = w(paramBoolean);
      if ((localObject == null) || (localRect == null)) {
        return null;
      }
    }
    else
    {
      return null;
    }
    String str = x(paramBoolean);
    if (((String)localObject).equals(zri.baD)) {}
    for (Object localObject = paramDrawable; localObject == null; localObject = a(paramBoolean, (String)localObject)) {
      return null;
    }
    if ((paramDrawable == null) && ((!paramBoolean) || (localObject == null))) {
      return null;
    }
    int n;
    int i1;
    int i;
    label186:
    int j;
    label197:
    int m;
    label261:
    int k;
    if (paramDrawable == null)
    {
      if ((TextUtils.isEmpty(str)) || (str.equals(zri.baD))) {
        return null;
      }
      paramDrawable = a(paramBoolean, str);
      if (paramDrawable == null) {
        return null;
      }
      ((URLDrawable)paramDrawable).setAutoDownload(true);
      n = this.b.getWidth();
      i1 = this.b.getHeight();
      if (((Drawable)localObject).getIntrinsicWidth() != 0) {
        break label430;
      }
      i = 1;
      if (((Drawable)localObject).getIntrinsicHeight() != 0) {
        break label440;
      }
      j = 1;
      localObject = sxx.getViewRect(this.b);
      if (localObject != null) {
        localRect.offset(((Rect)localObject).left, -((Rect)localObject).top);
      }
      paramRect3.set(localRect);
      if ((!paramBoolean) || (((URLDrawable)paramDrawable).getStatus() != 1)) {
        break label470;
      }
      if (paramDrawable.getIntrinsicWidth() != 0) {
        break label450;
      }
      m = 1;
      if (paramDrawable.getIntrinsicHeight() != 0) {
        break label460;
      }
      k = 1;
    }
    for (;;)
    {
      float f1 = vdz.e(m, k);
      paramRect1.set(vdz.a(i, j, m, k));
      paramRect2.set(vdz.b(m, k, n, i1));
      paramRect4.set(vdz.c(m, k, n, i1));
      vdz.a(paramRect1, f1);
      vdz.a(paramRect2, f1);
      i = (int)(m * f1);
      j = (int)(k * f1);
      try
      {
        paramRect3 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        paramRect4 = new Canvas(paramRect3);
        localObject = new Rect(0, 0, m, k);
        vdz.a((Rect)localObject, f1);
        paramDrawable.setBounds((Rect)localObject);
        paramRect4.clipRect(vdz.a(paramRect1, paramRect2));
        paramDrawable.draw(paramRect4);
        return paramRect3;
      }
      catch (Throwable paramRect1)
      {
        if (!QLog.isColorLevel()) {
          break label518;
        }
        QLog.e("ImagePreveiew", 2, "makeAnimationRect " + paramRect1.getMessage());
      }
      break;
      label430:
      i = ((Drawable)localObject).getIntrinsicWidth();
      break label186;
      label440:
      j = ((Drawable)localObject).getIntrinsicHeight();
      break label197;
      label450:
      m = paramDrawable.getIntrinsicWidth();
      break label261;
      label460:
      k = paramDrawable.getIntrinsicHeight();
      continue;
      label470:
      k = j;
      m = i;
    }
    label518:
    return null;
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    kxm.a(this, paramArticleInfo);
  }
  
  private boolean aAA()
  {
    Object localObject1 = this.b.getSelectedView();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((ImageView)((View)localObject1).findViewById(2131368820)).getDrawable();
    if ((localObject2 != null) && ((localObject2 instanceof URLDrawable)))
    {
      if (((URLDrawable)localObject2).getStatus() != 1) {
        return false;
      }
    }
    else if (localObject2 == null) {
      return false;
    }
    this.bY.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setVisibility(0);
    localObject1 = new Rect();
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    localObject2 = a(localRect2, localRect3, (Rect)localObject1, localRect1, (Drawable)localObject2, localObject2 instanceof URLDrawable);
    if (localObject2 == null) {
      return false;
    }
    this.animated = true;
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.a((Bitmap)localObject2, localRect3, localRect2, localRect1, (Rect)localObject1, this.aqA);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.setAnimationListener(new aoty(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView.startAnimation();
    this.bY.postDelayed(new TroopAvatarWallPreviewActivity.18(this), this.aqA);
    localObject1 = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
    ((AlphaAnimation)localObject1).setDuration(500L);
    ((AlphaAnimation)localObject1).setFillAfter(true);
    this.fP.startAnimation((Animation)localObject1);
    return true;
  }
  
  private boolean aAB()
  {
    return ("2".equals(this.cmY)) || ("4".equals(this.cmY));
  }
  
  private void aqz()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing()) && (!isFinishing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  private void bfg()
  {
    if ((this.w == null) || (this.w.length <= this.mIndex)) {
      return;
    }
    Object localObject;
    int i;
    if (this.w[this.mIndex] == 0)
    {
      this.mLikeBtn.setImageResource(2130849469);
      localObject = AnimationUtils.loadAnimation(this, 2130772363);
      this.mLikeBtn.startAnimation((Animation)localObject);
      localObject = this.w;
      i = this.mIndex;
      if (this.w[this.mIndex] != 0) {
        break label153;
      }
    }
    label153:
    for (int j = 1;; j = 0)
    {
      localObject[i] = j;
      localObject = new Intent("android.intent.action.WEBJSCALL");
      ((Intent)localObject).putExtra("callback", "{op:2,index:" + this.mIndex + "}");
      sendBroadcast((Intent)localObject);
      return;
      this.mLikeBtn.setImageResource(2130849472);
      break;
    }
  }
  
  private void bgD()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:1,index:" + this.mIndex + "}");
    sendBroadcast(localIntent);
  }
  
  private void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) || ("2".equals(this.cmY)) || ("6".equals(this.cmY)) || ("4".equals(this.cmY))) {
      ForwardUtils.a(this.app, this, this, localIntent, null);
    }
    for (;;)
    {
      finish();
      return;
      startActivity(localIntent);
    }
  }
  
  private void d(URLDrawable paramURLDrawable, String paramString)
  {
    new aotv(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  private void dN(String paramString)
  {
    if (isFinishing()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Arhz == null) {
        this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Arhz.setMessage(paramString);
    } while (isFinishing());
    this.jdField_a_of_type_Arhz.show();
  }
  
  private void dWS()
  {
    if (this.xR.getVisibility() == 0)
    {
      ((ImageView)this.HR).setImageResource(2130849463);
      if (this.g == null) {
        dZ(true);
      }
      this.xR.startAnimation(this.g);
      this.mIsBottomBarUp = false;
      return;
    }
    ((ImageView)this.HR).setImageResource(2130849464);
    if (this.f == null) {
      dZ(false);
    }
    this.xR.startAnimation(this.f);
    this.mIsBottomBarUp = true;
  }
  
  private void dWT()
  {
    Intent localIntent = new Intent("android.intent.action.WEBJSCALL");
    localIntent.putExtra("callback", "{op:3,index:" + this.mIndex + "}");
    sendBroadcast(localIntent);
  }
  
  private void dWU()
  {
    if ((this.BD != null) && (this.mIndex < this.BD.size()) && (!TextUtils.isEmpty((CharSequence)this.BD.get(this.mIndex))))
    {
      this.jdField_a_of_type_Apvn.Sq(true);
      this.jdField_a_of_type_Apvn.R(this.aad);
      this.jdField_a_of_type_Apvn.notifyDataSetChanged();
      LpReportInfo_pf00064.allReport(301, 34, 2);
    }
  }
  
  private void dWV()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null)) {}
    do
    {
      return;
      localObject = getIntent().getExtras();
    } while (!this.cOM);
    String str1 = ((Bundle)localObject).getString("article_id", "");
    String str2 = ((Bundle)localObject).getString("to_uin", "");
    String str3 = ((Bundle)localObject).getString("feeds_id", "");
    String str4 = ((Bundle)localObject).getString("scroll_image_r5", "");
    String str5 = ((Bundle)localObject).getString("strategy_id", "");
    if (odv.aT(((Bundle)localObject).getLong("channel_id", 0L))) {}
    for (Object localObject = "0X8009364";; localObject = "0X800888B")
    {
      kbp.a(null, "CliOper", "", str2, (String)localObject, (String)localObject, 0, 0, str3, str1, str5, str4, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "scroll Image report(in TroopAvatarWallPreviewActivity) toUin: ", str2, ", r2(feedsId): ", str3, ", r3(articleId): ", str1, " r4(imagePos): ", Integer.valueOf(this.mIndex + 1), ", r5: ", str4 });
      return;
    }
  }
  
  private void dWW()
  {
    if ((getIntent() == null) || (getIntent().getExtras() == null)) {}
    do
    {
      return;
      localObject = getIntent().getExtras();
    } while (!this.cOM);
    String str1 = ((Bundle)localObject).getString("to_uin", "");
    String str2 = ((Bundle)localObject).getString("feeds_id", "");
    String str3 = ((Bundle)localObject).getString("article_id", "");
    String str4 = ((Bundle)localObject).getString("read_article_r5", "");
    String str5 = ((Bundle)localObject).getString("strategy_id", "");
    if (odv.aT(((Bundle)localObject).getLong("channel_id", 0L))) {}
    for (Object localObject = "0X8009365";; localObject = "0X80088A8")
    {
      kbp.a(null, "CliOper", "", str1, (String)localObject, (String)localObject, 0, 0, str2, str3, str5, str4, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAvatarWallPreviewActivity", 2, new Object[] { "readArticle click report(in TroopAvatarWallPreviewActivity) toUin: ", str1, ", r2(feedsId): ", str2, ", r3(articleId): ", str3, " r4(imagePos): ", Integer.valueOf(this.mIndex + 1), ", r5: ", str4 });
      return;
    }
  }
  
  private void dZ(boolean paramBoolean)
  {
    if (this.xR != null)
    {
      if (paramBoolean)
      {
        this.g = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.xR.getHeight());
        this.g.setDuration(300L);
        this.g.setAnimationListener(new aouk(this));
      }
    }
    else {
      return;
    }
    this.f = new TranslateAnimation(0.0F, 0.0F, this.xR.getHeight(), 0.0F);
    this.f.setDuration(300L);
    this.f.setAnimationListener(new aoul(this));
  }
  
  private void dr(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, "ReadInJoy Grid Images isShowContentUrl: true");
    }
    String str2 = paramBundle.getString("article_title", "");
    String str1 = paramBundle.getString("article_url", "");
    int i = paramBundle.getInt("channel_id", 0);
    long l = paramBundle.getLong("articleSeq", 0L);
    ArticleInfo localArticleInfo = lbz.a().a(i, l);
    Object localObject;
    if ((this.mTextView != null) && ((this.mTextView.getParent() instanceof RelativeLayout)))
    {
      localObject = (RelativeLayout.LayoutParams)this.mTextView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
      ((RelativeLayout.LayoutParams)localObject).setMargins(0, wja.dp2px(20.0F, getResources()), 0, 0);
      this.mTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramBundle = paramBundle.getString("btntext", "");
    if (!TextUtils.isEmpty(str1))
    {
      this.HS = ((ViewStub)findViewById(2131378884)).inflate();
      this.HS.setVisibility(0);
      if ((this.HS != null) && ((this.HS instanceof LinearLayout)))
      {
        localObject = (TextView)this.HS.findViewById(2131379769);
        if (!TextUtils.isEmpty(str2)) {
          ((TextView)localObject).setText(str2);
        }
        localObject = (Button)this.HS.findViewById(2131376648);
        if (!TextUtils.isEmpty(paramBundle)) {
          ((Button)localObject).setText(paramBundle);
        }
        QLog.d("TroopAvatarWallPreviewActivity", 1, "init,btnText:" + paramBundle + " articleTitle:" + str2 + " articleUrl:" + str1);
        paramBundle = new GradientDrawable();
        paramBundle.setStroke(wja.dp2px(1.0F, getResources()), -1996488705);
        ((Button)localObject).setBackgroundDrawable(paramBundle);
        ((Button)localObject).setOnClickListener(new aouj(this, localArticleInfo, str1));
      }
    }
  }
  
  private void f(ArticleInfo paramArticleInfo, String paramString)
  {
    nnw.K("fast_web_show_light_house_1");
    lbz.a().a().a(paramString, String.valueOf(paramArticleInfo.innerUniqueID), paramArticleInfo.mSubscribeID, 1, null);
    a(paramArticleInfo, null);
  }
  
  private void hP(String paramString1, String paramString2)
  {
    if (getIntent().getBooleanExtra("from_photo_wall", false))
    {
      if (getIntent().getBooleanExtra("delete_ability", false)) {
        anot.a(this.app, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      }
    }
    else {
      return;
    }
    anot.a(this.app, "CliOper", "", "", paramString2, paramString2, 0, 0, "", "", "", "");
  }
  
  private void init()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.parse(localBundle.getString("PublicAccountShowPictureReport"));
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport) {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showStart();
    }
    this.b = ((Gallery)findViewById(2131367833));
    this.b.setVisibility(0);
    this.mTextView = ((TextView)findViewById(2131379401));
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.mf = ((RelativeLayout)findViewById(2131363635));
    this.fP = findViewById(2131363236);
    this.bY = ((FrameLayout)findViewById(2131377549));
    this.aH = ((ImageButton)findViewById(2131365679));
    this.fP.setBackgroundColor(-16777216);
    this.jdField_a_of_type_ComTencentMobileqqWidgetImageAnimationView = ((ImageAnimationView)findViewById(2131362725));
    this.sf = ((ImageView)findViewById(2131362407));
    this.HR = findViewById(2131372724);
    this.aad = ((TextView)findViewById(2131372735));
    this.aad.setOnClickListener(this.dn);
    this.aab = ((TextView)findViewById(2131373262));
    this.bY.setVisibility(0);
    this.cvT = localBundle.getBoolean("IS_EDIT");
    label280:
    label327:
    Object localObject;
    if (this.cvT)
    {
      this.aH.setVisibility(0);
      this.aH.setOnClickListener(this.dn);
      this.cOJ = localBundle.getBoolean("SHOW_MENU");
      if (!this.cOJ) {
        break label1000;
      }
      this.sf.setImageResource(2130838125);
      this.sf.setOnClickListener(this.dn);
      this.sf.setVisibility(0);
      this.HR.setOnClickListener(this.fV);
      this.BC = localBundle.getParcelableArrayList("KEY_THUMBNAL_BOUND");
      this.cOI = localBundle.getBoolean("is_show_action", true);
      this.cON = localBundle.getBoolean("is_need_to_aio", true);
      this.cOO = localBundle.getBoolean("is_from_plugin", false);
      this.cOG = localBundle.getBoolean("needBottomBar");
      if (!this.cOG) {
        break label1011;
      }
      localObject = ((ViewStub)findViewById(2131378887)).inflate();
      this.xR = ((View)localObject).findViewById(2131372704);
      this.mLikeBtn = ((ImageView)((View)localObject).findViewById(2131372705));
      this.mv = ((ImageView)((View)localObject).findViewById(2131372702));
      this.aac = ((TextView)((View)localObject).findViewById(2131372703));
      this.xR.setBackgroundResource(2130842383);
      this.mLikeBtn.setOnClickListener(this.fV);
      this.mv.setOnClickListener(this.fV);
      this.aac.setOnClickListener(this.fV);
      this.xR.setVisibility(0);
      this.HR.setVisibility(0);
      ((ImageView)this.HR).setImageResource(2130849463);
      localObject = new IntentFilter("cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete");
      registerReceiver(this.mReceiver, (IntentFilter)localObject);
      label563:
      this.w = localBundle.getBooleanArray("likes");
      this.jdField_a_of_type_Apvn = new apvn(this, this.app);
      this.mTroopUin = localBundle.getString("troop_uin");
      this.cOH = localBundle.getBoolean("troop_info_is_member");
      this.Hj = localBundle.getStringArrayList("seqNum");
      if ((QLog.isColorLevel()) && (!this.Hj.isEmpty())) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "Clicl Big Data: first img url:" + (String)this.Hj.get(0));
      }
      this.Bz = localBundle.getStringArrayList("descs");
      this.BA = localBundle.getStringArrayList("photoIds");
      this.BB = localBundle.getStringArrayList("photoTimes");
      this.cOF = localBundle.getBoolean("delete_ability");
      this.cOK = localBundle.getBoolean("is_not_show_index", true);
      this.cmY = localBundle.getString("src_id");
      this.mExtras = localBundle.getBundle("bundle_data_extra");
      this.cmZ = localBundle.getString("str_data_extra", "");
      this.BD = localBundle.getStringArrayList("origin_list");
      this.BE = localBundle.getStringArrayList("origin_size_list");
      if (this.BD == null) {
        this.aad.setVisibility(0);
      }
      if (this.cmY != null) {
        anot.a(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer", "open", 0, 0, this.cmY, "", "", "");
      }
      if (this.Hj != null) {
        this.dRK = this.Hj.size();
      }
      if (!this.cOK) {
        break label1023;
      }
      this.mTextView.setVisibility(4);
    }
    for (;;)
    {
      this.cOL = localBundle.getBoolean("is_show_content_url", false);
      this.cOM = localBundle.getBoolean("is_grid_image_report", false);
      if (this.cOL) {
        dr(localBundle);
      }
      ThreadManager.post(new TroopAvatarWallPreviewActivity.2(this, localBundle), 8, null, true);
      if (!aAB()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$a = new a(new Handler());
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$a.registerObserver();
      if (Settings.System.getInt(getContentResolver(), "accelerometer_rotation", -1) != 1) {
        break;
      }
      setRequestedOrientation(4);
      return;
      this.aH.setVisibility(4);
      break label280;
      label1000:
      this.sf.setVisibility(4);
      break label327;
      label1011:
      this.HR.setVisibility(8);
      break label563;
      label1023:
      this.mTextView.setVisibility(0);
      if ((localBundle.getBoolean("is_index_show_bottom", false)) && (this.mTextView != null) && ((this.mTextView.getParent() instanceof RelativeLayout)))
      {
        localObject = (RelativeLayout.LayoutParams)this.mTextView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(10);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, 0);
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, wja.dp2px(20.0F, getResources()), 0, 0);
        this.mTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void l(URLDrawable paramURLDrawable)
  {
    m(paramURLDrawable);
  }
  
  private void m(URLDrawable paramURLDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new aots(this, paramURLDrawable), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      n(paramURLDrawable);
      return;
    }
    n(paramURLDrawable);
  }
  
  private void showToast(String paramString)
  {
    QQToast.a(BaseApplication.getContext(), paramString, 0).show(getTitleBarHeight());
  }
  
  public void Wl(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_Apvn.getCount() - 1)) {}
    while ((this.BA == null) || (this.BB == null) || (paramInt > this.BA.size() - 1) || (paramInt > this.BB.size() - 1)) {
      return;
    }
    aqha.a(this, 230).setTitle(getString(2131697329)).setPositiveButton(getString(2131721079), new aotx(this, paramInt)).setNegativeButton(getString(2131721058), new aotw(this)).show();
    hP("0X8006A83", "");
  }
  
  Drawable a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      paramString = URLDrawable.getDrawable(aomc.l(paramString));
      return paramString;
    }
    catch (MalformedURLException paramString) {}
    BitmapFactory.Options localOptions = aqhu.a(paramString, 100);
    try
    {
      paramString = BitmapFactory.decodeFile(paramString, localOptions);
      return new BitmapDrawable(paramString);
    }
    catch (OutOfMemoryError paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "getDrawable out off memory");
      }
      System.gc();
      return null;
    }
    return null;
  }
  
  public void bPg()
  {
    this.mTextView.setVisibility(4);
    this.aH.setVisibility(4);
    this.sf.setVisibility(4);
    this.animated = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    if (!"5".equals(this.cmY)) {
      localAnimationSet.addAnimation(localScaleAnimation);
    }
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new aotz(this));
    if (this.hI == null) {
      this.hI = new TroopAvatarWallPreviewActivity.20(this);
    }
    this.b.postDelayed(this.hI, 500L);
    this.b.startAnimation(localAnimationSet);
    this.fP.startAnimation(localAlphaAnimation);
    if ((this.cOL) && (this.HS != null)) {
      this.HS.setVisibility(4);
    }
  }
  
  public void back()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.leave_mode = 1;
    if ((!this.animated) && (this.b != null) && (!this.b.resetScale(false)))
    {
      if ((this.BC == null) || (this.b.getSelectedItemId() != this.mIndex)) {
        break label68;
      }
      if (!aAA()) {
        bPg();
      }
    }
    return;
    label68:
    bPg();
  }
  
  public void c(URLDrawable paramURLDrawable, String paramString)
  {
    if (this.cmY != null) {
      anot.a(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_share", 0, 0, this.cmY, "", "", "");
    }
    new aoun(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public boolean doOnCreate(Bundle arg1)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(???);
    synchronized (sLock)
    {
      if (mIsOpen)
      {
        super.finish();
        return false;
      }
      mIsOpen = true;
      if ((this.app == null) || (TextUtils.isEmpty(this.app.getAccount())))
      {
        finish();
        return false;
      }
    }
    setContentView(2131559432);
    ThreadManager.post(new TroopAvatarWallPreviewActivity.1(this), 8, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.cOG)
    {
      LocalMultiProcConfig.putBool("BasePictureViewController#mIsBottomBarUp", this.mIsBottomBarUp);
      unregisterReceiver(this.mReceiver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.isReport)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.showEnd();
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountShowPictureReport.report(this.app);
    }
    if ((this.b != null) && (this.hI != null)) {
      this.b.removeCallbacks(this.hI);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity$a.unregisterObserver();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void hO(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString1);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString1);
    localIntent.putExtra("report_params", rvx.a(null, paramString2, null, null, null, 7));
    startActivity(localIntent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean lT(int paramInt)
  {
    if ((this.BA != null) && (paramInt <= this.BA.size() - 1) && (this.mExtras != null) && (this.mExtras.getBoolean("from_personality_label", false))) {
      return true;
    }
    if ((this.BA == null) || (this.BB == null) || (paramInt > this.BA.size() - 1) || (paramInt > this.BB.size() - 1)) {
      return false;
    }
    return !TextUtils.isEmpty((String)this.BA.get(paramInt));
  }
  
  public void n(URLDrawable paramURLDrawable)
  {
    if (this.cmY != null) {
      anot.a(this.app, "P_CliOper", "Grp_picViewer", "", "picViewer_actionSheet", "Clk_save", 0, 0, this.cmY, "", "", "");
    }
    if (paramURLDrawable.getStatus() != 1) {
      return;
    }
    new File(acbn.oM).mkdirs();
    String str = acbn.oM + this.mTroopUin + Utils.Crc64String(paramURLDrawable.getURL().toString());
    File localFile = new File(str);
    if (!localFile.exists()) {}
    for (;;)
    {
      try
      {
        if (localFile.createNewFile()) {
          d(paramURLDrawable, localFile.getPath());
        }
        hP("0X8006A82", "0X8006A96");
        return;
      }
      catch (IOException paramURLDrawable)
      {
        QQToast.a(this, getString(2131696986), 0).show();
        continue;
      }
      aqha.a(this, 230).setTitle(getString(2131718959)).setMessage(getString(2131696979)).setPositiveButton(getString(2131718798), new aotu(this, paramURLDrawable, str)).setNegativeButton(getString(2131696322), new aott(this)).show();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21) && (this.cON)) {
      bm(paramIntent.getExtras());
    }
    if ((paramInt1 == 10922) && (paramInt2 == -10069))
    {
      paramIntent = getIntent().getExtras().getString("article_url", "");
      kxm.aJ(getActivity(), paramIntent);
      if (this.cOM) {
        dWW();
      }
    }
  }
  
  public void onBackPressed()
  {
    back();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    synchronized (sLock)
    {
      mIsOpen = false;
      removeObserver(this.jdField_a_of_type_Alcb);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((82 == paramKeyEvent.getKeyCode()) && (this.cOJ))
    {
      Qq();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    ivv.o(BaseApplicationImpl.getContext(), false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ivv.o(BaseApplicationImpl.getContext(), true);
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
  }
  
  public void rT(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_Apvn.getCount() - 1)) {
      return;
    }
    if ((this.jdField_a_of_type_Apvn.getCount() == 2) && (this.jdField_a_of_type_Apvn.getItem(0) != null) && (this.jdField_a_of_type_Apvn.getItem(0).equals(zri.baD)))
    {
      back();
      return;
    }
    if (this.jdField_a_of_type_Apvn.getCount() > 1)
    {
      if (this.Hk == null) {
        this.Hk = new ArrayList();
      }
      this.Hk.add("" + paramInt);
      if (this.Hk != null)
      {
        getIntent().putStringArrayListExtra("del_list", (ArrayList)this.Hk);
        setResult(-1, getIntent());
      }
      finish();
      return;
    }
    QQToast.a(this, getString(2131698304), 1).show(getTitleBarHeight());
  }
  
  public void setDefaultAvatar(int paramInt)
  {
    if ((paramInt < 0) && (paramInt > this.jdField_a_of_type_Apvn.getCount() - 1)) {
      return;
    }
    getIntent().putExtra("default_avator_index", paramInt);
    setResult(-1, getIntent());
    finish();
  }
  
  public String w(boolean paramBoolean)
  {
    Object localObject;
    if (this.mIndex >= this.Hj.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "picIndex" + this.mIndex + ",mSeqNumList.size()" + this.Hj.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.Hj.get(this.mIndex);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals(zri.baD))) {
      return zri.baD;
    }
    return apqw.oK(apqw.p(str, this.mTroopUin, 1));
  }
  
  protected void w(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarWallPreviewActivity", 2, "showNearbyActionSheet: extra=" + this.cmZ);
    }
    if (TextUtils.isEmpty(this.cmZ)) {}
    do
    {
      return;
      try
      {
        Object localObject = new JSONObject(this.cmZ);
        ((JSONObject)localObject).optString("feedId");
        String str = ((JSONObject)localObject).optString("tinyId");
        ((JSONObject)localObject).optString("reason");
        localObject = ((JSONObject)localObject).optString("uin");
        ausj localausj = (ausj)auss.a(this, null);
        localausj.addButton(2131694762, 1);
        if (!this.app.getCurrentAccountUin().equals(localObject)) {
          localausj.addButton(acfp.m(2131715567), 0);
        }
        localausj.addCancelButton(2131721058);
        localausj.a(new aotr(this, localausj, paramURLDrawable, str, (String)localObject));
        localausj.show();
        return;
      }
      catch (Exception paramURLDrawable) {}
    } while (!QLog.isColorLevel());
    QLog.w("TroopAvatarWallPreviewActivity", 2, "showNearbyActionSheet err:", paramURLDrawable);
  }
  
  public String x(boolean paramBoolean)
  {
    Object localObject;
    if (this.mIndex >= this.Hj.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAvatarWallPreviewActivity", 2, "picIndex" + this.mIndex + ",mSeqNumList.size()" + this.Hj.size());
      }
      localObject = null;
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.Hj.get(this.mIndex);
      localObject = str;
    } while (!paramBoolean);
    if ((str != null) && (str.equals(zri.baD))) {
      return zri.baD;
    }
    return apqw.oL(apqw.p(str, this.mTroopUin, 1));
  }
  
  class a
    extends ContentObserver
  {
    private ContentResolver mResolver = TroopAvatarWallPreviewActivity.this.getContentResolver();
    
    public a(Handler paramHandler)
    {
      super();
    }
    
    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      if (Settings.System.getInt(TroopAvatarWallPreviewActivity.this.getContentResolver(), "accelerometer_rotation", -1) == 1)
      {
        TroopAvatarWallPreviewActivity.this.setRequestedOrientation(4);
        return;
      }
      TroopAvatarWallPreviewActivity.this.setRequestedOrientation(1);
    }
    
    public void registerObserver()
    {
      this.mResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }
    
    public void unregisterObserver()
    {
      this.mResolver.unregisterContentObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity
 * JD-Core Version:    0.7.0.1
 */