package com.tencent.tim.cloudfile.anima;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import atjj;
import atjk;
import atjl;
import atjq;
import atjx;
import atwj;
import auio;
import auip;
import aulm;
import ault;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;

public class CloudTeamWorkAnimActivity
  extends BaseActivity
  implements auio
{
  public static int eqa;
  public static int eqb;
  public static int eqc;
  public static int eqd;
  private ImageView GX;
  private TranslateAnimation J;
  private View Ku;
  private atjq jdField_a_of_type_Atjq = new atjk(this);
  private atjx jdField_a_of_type_Atjx;
  private aulm jdField_a_of_type_Aulm = new atjl(this);
  private int bFU;
  private String cGR = "";
  private String cGS = "";
  private AnimationSet jdField_d_of_type_AndroidViewAnimationAnimationSet;
  private ScaleAnimation jdField_d_of_type_AndroidViewAnimationScaleAnimation;
  private boolean dhT;
  private boolean dhU;
  private int eqe;
  private int eqf;
  private int eqg;
  private int eqh;
  private int eqi = -1;
  private Bitmap gT;
  private RelativeLayout gv;
  private View mRootView;
  
  private void al(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    while ((this.eqi == -1) || (TextUtils.isEmpty(this.cGS)) || (TextUtils.isEmpty(this.cGR))) {
      return;
    }
    ThreadManager.postImmediately(new CloudTeamWorkAnimActivity.5(this, paramBitmap), null, false);
  }
  
  private void ee(Intent paramIntent)
  {
    atwj localatwj = new atwj(this.app.getCurrentUin());
    localatwj.a(this.jdField_a_of_type_Atjq);
    paramIntent.putExtra("file_manager_provider", new BinderWarpper(localatwj.asBinder()));
    paramIntent.putExtra("create_teamwork_from_cloud_tab", true);
  }
  
  private void etR()
  {
    Bundle localBundle = new Bundle();
    Object localObject = null;
    switch (this.eqe)
    {
    }
    while ((localObject == null) || (BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("CreateDocFromTemplate", true)))
    {
      ault.a(this.app, this, this.eqe);
      return;
      localObject = "0X800877F";
      continue;
      localObject = "0X8008784";
      continue;
      localObject = "0X80099D7";
    }
    localObject = (auip)this.jdField_a_of_type_Atjx.a(this.eqe);
    ((auip)localObject).b(this);
    ((auip)localObject).setBundle(localBundle);
    ((auip)localObject).show();
  }
  
  private Bitmap g(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {}
    while ((this.eqi == -1) || (TextUtils.isEmpty(this.cGS)) || (TextUtils.isEmpty(this.cGR))) {
      return null;
    }
    return ThumbnailUtils.extractThumbnail(paramBitmap, 146, 124);
  }
  
  private void initAnimation()
  {
    WindowManager localWindowManager = (WindowManager)getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    int k = eqc - eqa;
    int m = eqd - eqb;
    if ((k == 0) || (m == 0) || (i == 0) || (j == 0)) {}
    do
    {
      return;
      float f1 = k * 1.0F / i;
      float f2 = m * 1.0F / j;
      if (this.jdField_d_of_type_AndroidViewAnimationScaleAnimation == null)
      {
        this.jdField_d_of_type_AndroidViewAnimationScaleAnimation = new ScaleAnimation(1.0F, f1, 1.0F, f2, 1, 0.0F, 1, 0.0F);
        this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setDuration(400L);
        this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
        this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setAnimationListener(new atjj(this));
      }
      if (this.J == null)
      {
        this.J = new TranslateAnimation(0.0F, eqa, 0.0F, eqb);
        this.J.setDuration(400L);
        this.jdField_d_of_type_AndroidViewAnimationScaleAnimation.setFillAfter(true);
      }
    } while (this.jdField_d_of_type_AndroidViewAnimationAnimationSet != null);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(false);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_d_of_type_AndroidViewAnimationScaleAnimation);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.J);
    this.jdField_d_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    new Handler().postDelayed(new CloudTeamWorkAnimActivity.1(this), 500L);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    boolean bool = super.doOnCreate(paramBundle);
    setContentView(2131558981);
    this.mRootView = findViewById(2131377546);
    this.GX = ((ImageView)findViewById(2131362718));
    this.eqe = getIntent().getIntExtra("create_type", 2);
    this.eqf = getIntent().getIntExtra("anim_location_x", 100);
    this.eqg = getIntent().getIntExtra("anim_location_y", 100);
    if (this.jdField_a_of_type_Atjx == null) {
      this.jdField_a_of_type_Atjx = new atjx(this.app, this, null);
    }
    for (;;)
    {
      this.Ku = findViewById(2131379866);
      this.gv = ((RelativeLayout)findViewById(2131378734));
      this.bFU = getResources().getDimensionPixelSize(2131299627);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mNeedStatusTrans))
      {
        paramBundle = findViewById(16908310);
        if (paramBundle != null)
        {
          paramBundle = (View)paramBundle.getParent();
          if (paramBundle != null) {
            paramBundle.setVisibility(8);
          }
        }
        this.eqh = ImmersiveUtils.getStatusBarHeight(this);
        int i = this.eqh;
        int j = this.bFU;
        this.gv.getLayoutParams().height = (i + j);
        this.Ku.getLayoutParams().height = this.eqh;
      }
      if (this.jdField_a_of_type_Aulm != null) {
        this.app.addObserver(this.jdField_a_of_type_Aulm);
      }
      etR();
      return bool;
      this.jdField_a_of_type_Atjx.onAccountChanged(this.app);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Atjx != null) {
      this.jdField_a_of_type_Atjx.onDestroy();
    }
    if ((this.gT != null) && (!this.gT.isRecycled())) {
      this.gT.recycle();
    }
    this.gT = null;
    if (this.jdField_a_of_type_Aulm != null) {
      this.app.removeObserver(this.jdField_a_of_type_Aulm);
    }
  }
  
  public void etS()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CloudTeamWorkAnimActivity", 1, "create team work file dialog is dismiss, anim activity will be close.");
    }
    finish();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    ee(paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    new Handler().postDelayed(new CloudTeamWorkAnimActivity.2(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity
 * JD-Core Version:    0.7.0.1
 */