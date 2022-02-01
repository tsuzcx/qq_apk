package com.tencent.mobileqq.troop.activity;

import acbn;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aosj;
import aosk;
import aosl;
import aosm;
import aosn;
import aoso;
import aosp;
import aosq;
import aosr;
import apuz;
import aqha;
import aqju;
import ausj;
import auss;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Gallery;
import ivv;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import wja;

public class MediaPreviewActivity
  extends BaseActivity
{
  static boolean mIsOpen;
  static Object sLock = new Object();
  protected ArrayList<MediaPreviewInfo> Bx;
  public apuz a;
  protected Gallery b;
  protected FrameLayout bY;
  public boolean cOx;
  public int dRE;
  protected View fP;
  protected Runnable hH;
  public int mSelectedIndex;
  public TextView mTextView;
  
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
    ausj localausj = (ausj)auss.a(this, null);
    localausj.addButton(2131694752, 1);
    localausj.addButton(2131694762, 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new aoso(this, localausj, (URLDrawable)localObject));
    localausj.show();
  }
  
  public void bPg()
  {
    this.mTextView.setVisibility(4);
    this.cOx = true;
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.5F, 1.0F, 1.5F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(500L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.addAnimation(localScaleAnimation);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new aosk(this));
    if (this.hH == null) {
      this.hH = new MediaPreviewActivity.11(this);
    }
    this.b.postDelayed(this.hH, 500L);
    this.b.startAnimation(localAnimationSet);
    this.fP.startAnimation(localAlphaAnimation);
  }
  
  protected void bm(Bundle paramBundle)
  {
    Intent localIntent = wja.a(new Intent(this, SplashActivity.class), null);
    localIntent.putExtras(new Bundle(paramBundle));
    startActivity(localIntent);
    finish();
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
    ??? = getIntent().getExtras();
    this.mSelectedIndex = ???.getInt("index", -1);
    this.Bx = ???.getParcelableArrayList("mediaInfoList");
    if (this.Bx != null) {
      this.dRE = this.Bx.size();
    }
    this.bY = ((FrameLayout)findViewById(2131377549));
    this.bY.setVisibility(0);
    this.b = ((Gallery)findViewById(2131367833));
    this.b.setVisibility(0);
    this.mTextView = ((TextView)findViewById(2131379401));
    this.mTextView.setVisibility(0);
    this.fP = findViewById(2131363236);
    this.fP.setBackgroundColor(-16777216);
    this.a = new apuz(this, this.b);
    this.a.mV(this.Bx);
    this.b.setAdapter(this.a);
    this.b.setSpacing(getResources().getDimensionPixelSize(2131297406));
    this.b.setSelection(this.mSelectedIndex);
    this.b.setOnItemClickListener(new aosj(this));
    this.b.setOnItemSelectedListener(new aosl(this));
    this.b.setOnItemLongClickListener(new aosm(this));
    ThreadManager.post(new MediaPreviewActivity.4(this), 8, null, true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((this.b != null) && (this.hH != null)) {
      this.b.removeCallbacks(this.hH);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.finish();
  }
  
  public void e(URLDrawable paramURLDrawable, String paramString)
  {
    new aosn(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public void f(URLDrawable paramURLDrawable, String paramString)
  {
    new aosr(this, paramURLDrawable, paramString).execute(new Void[0]);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 21)) {
      bm(paramIntent.getExtras());
    }
  }
  
  public void onBackPressed()
  {
    if ((!this.cOx) && (!this.b.resetScale(false))) {
      bPg();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.doOnDestory();
    }
    synchronized (sLock)
    {
      mIsOpen = false;
      return;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ivv.o(this, false);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ivv.o(this, true);
    AbstractGifImage.resumeAll();
    ApngImage.resumeAll();
  }
  
  public void u(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable.getStatus() != 1) {}
    String str;
    for (;;)
    {
      return;
      new File(acbn.oM).mkdirs();
      str = acbn.oM + Utils.Crc64String(paramURLDrawable.getURL().toString());
      File localFile = new File(str);
      if (!localFile.exists()) {
        try
        {
          if (localFile.createNewFile())
          {
            f(paramURLDrawable, localFile.getPath());
            return;
          }
        }
        catch (IOException paramURLDrawable)
        {
          QQToast.a(this, getString(2131696986), 0).show();
          return;
        }
      }
    }
    aqha.a(this, 230).setTitle(getString(2131718959)).setMessage(getString(2131696979)).setPositiveButton(getString(2131718798), new aosq(this, paramURLDrawable, str)).setNegativeButton(getString(2131696322), new aosp(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity
 * JD-Core Version:    0.7.0.1
 */