package com.tencent.mobileqq.activity;

import aben;
import acff;
import ahyj;
import amdf;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import aqdj;
import aqft;
import aqgm;
import aqgw;
import aqhs;
import aqhu;
import aqiw;
import aqqj;
import arhz;
import arie;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.URLImageView;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.Gallery;
import ivv;
import java.io.File;
import mqq.os.MqqHandler;
import sxx;
import vat;
import vau;
import vav;
import vaw;
import vax;
import vaz;
import vba;
import vbb;
import vbc;
import vbd;
import vbe;
import vbf;
import vbg;
import vbi;
import vbi.a;
import vbi.b;
import wja;

public class FriendProfileImageActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, Runnable, vbi.a
{
  public boolean Av;
  arhz B;
  private TextView Dt;
  public aben a;
  private aqgw a;
  public Gallery a;
  public vbi a;
  private Rect jdField_aU_of_type_AndroidGraphicsRect;
  FrameLayout jdField_aU_of_type_AndroidWidgetFrameLayout;
  public boolean aWG;
  public boolean aWH;
  public boolean aWI;
  boolean aWJ;
  private boolean aWK;
  public ImageButton af;
  public boolean animated = false;
  private arie b;
  int bHi;
  int bHj;
  private int bgJ = 0;
  View bgView;
  public AsyncTask<Void, Void, Void> c;
  ProfileActivity.AllInOne c;
  private View.OnClickListener dn = new vax(this);
  private ahyj e = new ahyj("profile_image", "com.tencent.mobileqq:tool");
  Runnable fadeTask = new FriendProfileImageActivity.11(this);
  private boolean firstTimeShowPage;
  ImageView fl;
  RelativeLayout gE;
  RelativeLayout gF;
  private long hU = 350L;
  AlphaAnimation hideAnimation = new AlphaAnimation(1.0F, 0.0F);
  public int initIndex;
  public RelativeLayout mRoot;
  long pendantId;
  ImageView qa;
  public ImageView qb;
  public View sG;
  AlphaAnimation showAnimation = new AlphaAnimation(0.0F, 1.0F);
  TextView textView;
  
  private void Qq()
  {
    if (isFinishing()) {}
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_Vbi.a();
    } while ((localObject1 == null) || (((vbi.b)localObject1).state != 6));
    Object localObject2 = (ausj)auss.a(this, null);
    ((ausj)localObject2).bk(2131694752, 1, 0);
    ((ausj)localObject2).bk(2131694762, 1, 2);
    ((ausj)localObject2).bk(2131694180, 1, 3);
    if ((!this.Av) && (this.aWG)) {
      ((ausj)localObject2).bk(2131694749, 3, 4);
    }
    ((ausj)localObject2).addCancelButton(2131721058);
    boolean bool;
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_Vbi.toUin)) && (TextUtils.equals(this.jdField_a_of_type_Vbi.toUin, this.app.getCurrentAccountUin())))
    {
      bool = true;
      ((ausj)localObject2).a(new vbd(this, (vbi.b)localObject1, bool, (ausj)localObject2));
      ((ausj)localObject2).show();
      localObject2 = this.app;
      if (!bool) {
        break label185;
      }
    }
    label185:
    for (Object localObject1 = "1";; localObject1 = "2")
    {
      anot.a((QQAppInterface)localObject2, "dc00898", "", "", "0X800A8C9", "0X800A8C9", 0, 0, (String)localObject1, "", "", "");
      return;
      bool = false;
      break;
    }
  }
  
  private void b(Rect paramRect1, Rect paramRect2)
  {
    this.animated = true;
    View localView = getActivity().findViewById(16908290);
    this.jdField_aU_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    int i2;
    int i3;
    int n;
    int k;
    int m;
    int i;
    int j;
    float f1;
    float f2;
    if ((paramRect2 != null) && (paramRect1 != null))
    {
      this.jdField_aU_of_type_AndroidGraphicsRect = paramRect1;
      i2 = paramRect1.width();
      i3 = paramRect1.height();
      n = paramRect2.width();
      int i1 = paramRect2.height();
      k = localView.getWidth();
      m = localView.getHeight();
      if (n <= k)
      {
        i = i1;
        j = n;
        if (i1 <= m) {}
      }
      else
      {
        f1 = k / n;
        f2 = m / i1;
        if (f1 >= f2) {
          break label471;
        }
        i = Math.round(i1 * f1);
        j = k;
      }
      f2 = sxx.getScale(j, i, k, m);
      k = j;
      if (j == 0) {
        k = 1;
      }
      if (i != 0) {
        break label492;
      }
      i = 1;
    }
    label471:
    label489:
    label492:
    for (;;)
    {
      if ((k != i2) || (i3 != i))
      {
        f1 = i2 / k / f2;
        f2 = i3 / i / f2;
        if (f1 <= f2) {
          break label489;
        }
        f1 = f2;
      }
      for (;;)
      {
        paramRect1 = new ScaleAnimation(f1, 1.0F, f1, 1.0F, 1, 0.5F, 1, 0.5F);
        paramRect1.setDuration(this.hU);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(paramRect1);
        paramRect1 = new Rect(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getHeight() - localView.getPaddingBottom());
        sxx.getViewRect(localView, paramRect1);
        i = paramRect1.centerX();
        j = paramRect1.centerY();
        k = this.jdField_aU_of_type_AndroidGraphicsRect.centerX();
        m = this.jdField_aU_of_type_AndroidGraphicsRect.centerY();
        paramRect1 = new TranslateAnimation(-(i - k), 0.0F, -(j - m), 0.0F);
        paramRect1.setDuration(this.hU);
        paramRect1.setInterpolator(new AccelerateDecelerateInterpolator());
        paramRect1.setAnimationListener(new vav(this));
        this.mRoot.startAnimation(paramRect1);
        if (!this.aWJ) {
          this.jdField_aU_of_type_AndroidWidgetFrameLayout.postDelayed(new FriendProfileImageActivity.13(this), this.hU);
        }
        paramRect1 = new AlphaAnimation(0.0F, 1.0F);
        paramRect1.setInterpolator(new DecelerateInterpolator());
        paramRect1.setDuration(350L);
        paramRect1.setFillAfter(true);
        this.bgView.startAnimation(paramRect1);
        return;
        j = Math.round(n * f2);
        i = m;
        break;
      }
    }
  }
  
  private void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
  }
  
  private void t(TextView paramTextView)
  {
    paramTextView.setVisibility(4);
    this.showAnimation.setDuration(300L);
    this.hideAnimation.setDuration(300L);
    this.showAnimation.setAnimationListener(new vbf(this, paramTextView));
    this.hideAnimation.setAnimationListener(new vau(this, paramTextView));
  }
  
  private void vA(String paramString)
  {
    amdf.a(this, new File(paramString), Utils.Crc64String(paramString + NetConnInfoCenter.getServerTime()));
  }
  
  private void vz(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        requestPermissions(new vbe(this, paramString), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      vA(paramString);
      return;
    }
    vA(paramString);
  }
  
  public void a(AdapterView paramAdapterView, int paramInt)
  {
    if (!this.animated)
    {
      if (paramAdapterView.getCount() <= 1) {
        break label160;
      }
      this.textView.setText(paramInt + 1 + "/" + paramAdapterView.getCount());
      if (this.textView.getVisibility() != 4) {
        break label125;
      }
      this.textView.setVisibility(0);
      this.textView.startAnimation(this.showAnimation);
      if (this.firstTimeShowPage)
      {
        this.textView.postDelayed(this.fadeTask, 3000L);
        this.firstTimeShowPage = false;
      }
    }
    else
    {
      return;
    }
    this.textView.postDelayed(this.fadeTask, 2000L);
    return;
    label125:
    this.textView.removeCallbacks(this.fadeTask);
    this.textView.clearAnimation();
    this.textView.postDelayed(this.fadeTask, 2000L);
    return;
    label160:
    this.textView.setVisibility(4);
  }
  
  public void b(vbi.b paramb)
  {
    d(paramb);
  }
  
  void bPf()
  {
    if (this.B == null)
    {
      this.B = new arhz(this, getTitleBarHeight());
      this.B.setMessage(2131692539);
    }
    this.B.show();
  }
  
  public void bPg()
  {
    this.animated = true;
    this.af.setVisibility(4);
    this.textView.setVisibility(4);
    if (this.gE.getVisibility() == 0) {
      this.gE.setVisibility(8);
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(350L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 2.0F, 1.0F, 2.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setDuration(350L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new vaw(this));
    this.jdField_a_of_type_ComTencentWidgetGallery.startAnimation(localAnimationSet);
    this.bgView.startAnimation(localAlphaAnimation);
  }
  
  public void back()
  {
    if ((!this.animated) && (!this.jdField_a_of_type_ComTencentWidgetGallery.resetScale(false)))
    {
      bPg();
      if (this.sG != null) {
        this.jdField_a_of_type_Aben.gh(this.sG);
      }
    }
  }
  
  public void c(vbi.b paramb)
  {
    if (!aqiw.isNetSupport(this)) {
      QQToast.a(this, getString(2131692513), 0).show();
    }
    Card localCard;
    do
    {
      return;
      localCard = ((acff)this.app.getManager(51)).b(this.jdField_a_of_type_Vbi.toUin);
    } while (localCard == null);
    ((CardHandler)this.app.getBusinessHandler(2)).c(this.jdField_a_of_type_Vbi.toUin, localCard.uFaceTimeStamp, aqhs.hexStr2Bytes(paramb.fileKey));
    bPf();
  }
  
  public void cf(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      this.b = new arie(this);
    }
    this.b.V(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  public void d(vbi.b paramb)
  {
    if ((this.bgJ == 1) || (this.sG == null) || (paramb == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.PhotoWall", 2, "updateCurrentImage uin=" + paramb.toUin + ", state=" + paramb.state);
            }
            localObject = (String)this.sG.getTag();
            if (paramb.state != 6) {
              break;
            }
          } while ((localObject != null) && (((String)localObject).equals(paramb.filePath)));
          this.jdField_a_of_type_Aben.c(paramb, this.sG);
          return;
          if ((paramb.state != 3) && (paramb.state != 4)) {
            break;
          }
          if ((localObject == null) || (!((String)localObject).equals(paramb.thumbnail))) {
            this.jdField_a_of_type_Aben.b(paramb, this.sG);
          }
        } while ((!paramb.showProgress) || (paramb.state != 4));
        Object localObject = (ImageProgressCircle)this.sG.findViewById(2131368926);
        if (localObject != null)
        {
          ((ImageProgressCircle)localObject).setProgress(paramb.progress);
          if (((ImageProgressCircle)localObject).getVisibility() != 0) {
            this.jdField_a_of_type_Aben.b((ImageProgressCircle)localObject);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.PhotoWall", 2, "progressCircle = " + paramb.progress);
      return;
    } while ((paramb.state != 5) && (paramb.state != 2));
    this.jdField_a_of_type_Aben.a(paramb, this.sG);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      bm(paramIntent.getExtras());
    }
  }
  
  public void doOnBackPressed()
  {
    back();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setBackgroundDrawableResource(2131167595);
    super.setContentView(2131559432);
    this.jdField_a_of_type_Aqgw = new aqgw(getMainLooper(), this);
    paramBundle = getIntent().getExtras();
    this.aWH = paramBundle.getBoolean("is_from_face2face_add_friend", false);
    this.aWI = paramBundle.getBoolean("is_hide_actionsheet", false);
    this.aWJ = paramBundle.getBoolean("is_hide_footbar", false);
    this.bgJ = paramBundle.getInt("curType", 0);
    this.jdField_c_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    this.jdField_a_of_type_ComTencentWidgetGallery = ((Gallery)findViewById(2131367833));
    this.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.textView = ((TextView)findViewById(2131379401));
    this.mRoot = ((RelativeLayout)findViewById(2131377546));
    this.bgView = findViewById(2131363236);
    this.bgView.setBackgroundColor(-16777216);
    this.jdField_aU_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131377549));
    Object localObject = ((ViewStub)findViewById(2131378878)).inflate();
    this.gE = ((RelativeLayout)((View)localObject).findViewById(2131365349));
    this.gF = ((RelativeLayout)((View)localObject).findViewById(2131365350));
    this.af = ((ImageButton)findViewById(2131365679));
    this.qb = ((ImageView)findViewById(2131362407));
    this.qb.setVisibility(4);
    this.Dt = ((TextView)((View)localObject).findViewById(2131379521));
    this.af.setVisibility(4);
    this.af.setOnClickListener(this.dn);
    this.qb.setOnClickListener(new vat(this));
    this.jdField_a_of_type_Aben = new aben(this);
    this.jdField_a_of_type_Vbi = new vbg(this.app);
    this.Av = true;
    if (this.bgJ == 1) {
      this.jdField_a_of_type_Aben.Dw(true);
    }
    this.jdField_a_of_type_Vbi.toUin = paramBundle.getString("friendUin");
    this.pendantId = paramBundle.getLong("extra_pendant_id", 0L);
    if (this.pendantId == 0L)
    {
      this.Dt.setText(2131717406);
      this.pendantId = 5L;
    }
    this.bHj = paramBundle.getInt("extra_action_source", 0);
    if (this.jdField_a_of_type_Vbi.toUin != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mRoot.getLayoutParams();
      localLayoutParams.bottomMargin = getResources().getDimensionPixelSize(2131297969);
      this.mRoot.setLayoutParams(localLayoutParams);
      this.gF.setOnClickListener(this);
      this.fl = ((ImageView)((View)localObject).findViewById(2131369011));
      ThreadManager.getSubThreadHandler().post(this);
      this.qa = ((ImageView)((View)localObject).findViewById(2131368987));
      ThreadManager.post(new FriendProfileImageActivity.2(this), 8, null, true);
    }
    if (this.app.getCurrentAccountUin().equals(this.jdField_a_of_type_Vbi.toUin)) {}
    for (this.aWG = true;; this.aWG = false)
    {
      this.initIndex = paramBundle.getInt("index", -1);
      localObject = new vbi.b();
      ((vbi.b)localObject).toUin = this.jdField_a_of_type_Vbi.toUin;
      ((vbi.b)localObject).fileKey = paramBundle.getString("filekey");
      this.jdField_a_of_type_Vbi.a(this, (vbi.b)localObject);
      this.bHi = this.jdField_a_of_type_Vbi.getCurrentIndex();
      this.jdField_a_of_type_Vbi.a(this);
      this.jdField_a_of_type_Vbi.e(this);
      this.jdField_a_of_type_Aben.a(this.jdField_a_of_type_Vbi);
      this.jdField_a_of_type_ComTencentWidgetGallery.setAdapter(this.jdField_a_of_type_Aben);
      this.jdField_a_of_type_ComTencentWidgetGallery.setSelection(this.jdField_a_of_type_Vbi.getCurrentIndex());
      this.jdField_a_of_type_ComTencentWidgetGallery.setSpacing(getResources().getDimensionPixelSize(2131297406));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemClickListener(new vaz(this));
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemSelectedListener(new vba(this));
      t(this.textView);
      this.jdField_a_of_type_ComTencentWidgetGallery.setOnItemLongClickListener(new vbb(this));
      this.jdField_c_of_type_AndroidOsAsyncTask = new vbc(this, (vbi.b)localObject);
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this);
    this.jdField_a_of_type_Aqgw.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Vbi.a(null);
    this.jdField_a_of_type_Vbi.d(this);
    this.jdField_a_of_type_Aben.destroy();
    super.doOnDestroy();
    this.jdField_c_of_type_AndroidOsAsyncTask.cancel(true);
    this.sG = null;
    if (this.showAnimation != null) {
      this.showAnimation.setAnimationListener(null);
    }
    if (this.hideAnimation != null) {
      this.hideAnimation.setAnimationListener(null);
    }
    if (this.jdField_a_of_type_ComTencentWidgetGallery != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = this.jdField_a_of_type_ComTencentWidgetGallery.getChildCount();
        i = 0;
        if (i < j)
        {
          View localView = this.jdField_a_of_type_ComTencentWidgetGallery.getChildAt(i);
          if (localView == null) {
            break label164;
          }
          localView = localView.findViewById(2131368820);
          if (!(localView instanceof URLImageView)) {
            break label164;
          }
          ((URLImageView)localView).setImageDrawable(null);
          ((URLImageView)localView).setBackgroundDrawable(null);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label164:
      i += 1;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (82 == paramKeyEvent.getKeyCode())
    {
      Qq();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    AbstractVideoImage.pauseAll();
    ivv.o(BaseApplicationImpl.getContext(), false);
    this.e.end();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    AbstractVideoImage.resumeAll();
    ivv.o(BaseApplicationImpl.getContext(), true);
    aqgm.a(this.app, this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), this.e);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    float f;
    int i;
    Object localObject;
    Rect localRect3;
    int j;
    if ((paramBoolean) && (!this.aWK))
    {
      f = getResources().getDisplayMetrics().density;
      i = getResources().getDisplayMetrics().densityDpi;
      localObject = this.jdField_a_of_type_Vbi.a();
      this.aWK = true;
      localRect3 = (Rect)getIntent().getExtras().getParcelable("KEY_THUMBNAL_BOUND");
      if (localObject == null) {
        break label170;
      }
      if (((vbi.b)localObject).state != 6) {
        break label154;
      }
      i = aqhu.scaleFromDensity(640, 160, i);
      j = i;
    }
    for (;;)
    {
      Rect localRect1 = new Rect(0, 0, j, i);
      Rect localRect2 = aqhu.a(localRect1, (int)getResources().getDimension(2131297899), f);
      localObject = localRect2;
      if (localRect2 == null) {
        localObject = localRect1;
      }
      b(localRect3, (Rect)localObject);
      return;
      label154:
      i = aqhu.scaleFromDensity(100, 160, i);
      j = i;
      continue;
      label170:
      i = 0;
      j = 0;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      this.fl.setImageDrawable((Drawable)paramMessage.obj);
      return true;
    } while ((this == null) || (isFinishing()));
    cf(2131692513, 1);
    return true;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_Vbi != null)
      {
        if (aqft.cC()) {
          break;
        }
        Toast.makeText(super.getApplicationContext(), getString(2131719242), 0).show();
      }
    }
    if ((this.jdField_a_of_type_Vbi.toUin != null) && (!this.jdField_a_of_type_Vbi.toUin.equals(this.app.getCurrentAccountUin()))) {}
    this.e.dqV();
    String str;
    if (aqgm.cU(this.pendantId))
    {
      str = "FriendToDIYPendant";
      label117:
      str = aqqj.getUrl(str);
      if (TextUtils.isEmpty(str)) {
        break label348;
      }
      str = str.replace("[sharefri]", this.jdField_a_of_type_Vbi.toUin);
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("hide_left_button", false);
      localIntent.putExtra("show_right_close_button", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", str);
      localIntent.putExtra("business", 512L);
      VasWebviewUtil.insertVasWbPluginToIntent(512L, localIntent);
      localIntent.putExtra("isShowAd", false);
      startActivity(localIntent);
      anot.a(this.app, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
      label257:
      if (this.jdField_a_of_type_Vbi.toUin != null)
      {
        if (!this.jdField_a_of_type_Vbi.toUin.equals(this.app.getCurrentAccountUin())) {
          break label361;
        }
        anot.a(this.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoBigheadClick", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      aqgm.e(this, "sp_key_entrance_card_face_preview", this.app.getCurrentAccountUin(), System.currentTimeMillis());
      finish();
      break;
      str = "FriendToPendant";
      break label117;
      label348:
      QLog.e("Q.profilecard.PhotoWall", 1, "click container_pendant_footer ret null url");
      break label257;
      label361:
      anot.a(this.app, "CliOper", "", "", "AvatarClick", "KerenInfoButtonClick", this.bHj, 0, "", "", "", "");
    }
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_Vbi == null) || (this.jdField_a_of_type_Vbi.toUin == null)) {
      return;
    }
    aqdj localaqdj = aqdj.a(this.app, 1, this.jdField_a_of_type_Vbi.toUin);
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = localaqdj;
    this.jdField_a_of_type_Aqgw.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity
 * JD-Core Version:    0.7.0.1
 */