package com.tencent.tim.cloudfile.wps;

import agmx;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqju;
import aqzl;
import araz;
import arbt;
import arcd;
import atmw;
import atmx;
import atmy;
import atmz;
import atna;
import atnb;
import atwl;
import atwl.a;
import atwm;
import audx;
import aueh;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.BinderWarpper;
import org.json.JSONException;
import org.json.JSONObject;

public class WpsFilePreviewFragment
  extends WebViewFragment
{
  public static final String TAG = WpsFilePreviewFragment.class.getSimpleName();
  private View KA;
  private View KB;
  private View KC;
  private TextView Sl;
  private atwl jdField_a_of_type_Atwl;
  private atwm jdField_a_of_type_Atwm;
  public BinderWarpper a;
  private TextView afc;
  private Handler ar;
  long ayu = 133146133336L;
  private long ayv;
  private AlphaAnimation c;
  private String cHA;
  private String cHB;
  private String cHC;
  private String cHx;
  private String cHy;
  private String cHz;
  private AlphaAnimation d;
  boolean dik = false;
  private WebViewPlugin e;
  Runnable is;
  private boolean isFullScreen;
  int mDownX;
  int mDownY;
  private String mFileId;
  private String mFileName;
  private long mFileSize;
  private ProgressBar mProgressBar;
  private String mSha;
  private int mTitleHeight;
  
  public WpsFilePreviewFragment()
  {
    this.jdField_a_of_type_ComTencentUtilBinderWarpper = null;
  }
  
  private void aax(int paramInt)
  {
    if (this.KC != null)
    {
      float f1 = (float)this.mFileSize;
      float f2 = paramInt / 100.0F;
      this.mProgressBar.setProgress(paramInt);
      String str = this.KC.getContext().getString(2131694118) + "(" + aueh.g((f1 * f2)) + "/" + aueh.g(this.mFileSize) + ")";
      this.Sl.setText(str);
    }
  }
  
  private void dfh()
  {
    if (this.jdField_a_of_type_Atwm != null) {
      return;
    }
    this.jdField_a_of_type_Atwm = new atmw(this);
  }
  
  public void VC(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.isFullScreen)) {
      return;
    }
    if ((paramBoolean) && (!this.isFullScreen))
    {
      if (this.d != null) {
        this.d.cancel();
      }
      if (this.KB != null)
      {
        this.d = new AlphaAnimation(1.0F, 0.0F);
        this.d.setAnimationListener(new atmx(this));
        this.d.setDuration(500L);
        this.d.setFillAfter(true);
        this.KB.startAnimation(this.d);
      }
      this.jdField_a_of_type_Aqzl.aK.setVisibility(8);
      localView = this.jdField_a_of_type_Arcd.mRootView.findViewById(2131382187);
      localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = this.jdField_a_of_type_Arcd.mRootView.getHeight();
      localLayoutParams.topMargin = 50;
      localView.setLayoutParams(localLayoutParams);
      this.isFullScreen = true;
      return;
    }
    if (this.c != null) {
      this.c.cancel();
    }
    if (this.KB != null)
    {
      this.c = new AlphaAnimation(0.0F, 1.0F);
      this.c.setAnimationListener(new atmy(this));
      this.c.setDuration(500L);
      this.c.setFillAfter(true);
      this.KB.startAnimation(this.c);
    }
    this.jdField_a_of_type_Aqzl.aK.setVisibility(0);
    View localView = this.jdField_a_of_type_Arcd.mRootView.findViewById(2131382187);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.height = (this.jdField_a_of_type_Arcd.mRootView.getHeight() - this.mTitleHeight);
    localView.setLayoutParams(localLayoutParams);
    this.isFullScreen = false;
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    this.e = this.mPluginEngine.b("wps");
    return i;
  }
  
  public araz a()
  {
    return new araz(this, 127, new atnb(this));
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    this.jdField_a_of_type_Aqzl.rightViewImg.setVisibility(8);
    this.jdField_a_of_type_Aqzl.centerView.setText(this.mFileName);
    this.jdField_a_of_type_Aqzl.rightViewImg.setImageDrawable(getResources().getDrawable(2130840663));
    this.jdField_a_of_type_Aqzl.rightViewImg.setOnClickListener(this);
    this.jdField_a_of_type_Aqzl.leftView.setOnClickListener(this);
    this.mTitleHeight = this.jdField_a_of_type_Aqzl.aK.getHeight();
    return i;
  }
  
  public void cg(String paramString1, String paramString2)
  {
    this.mSha = paramString2;
    this.cHx = paramString1;
    this.jdField_a_of_type_Atwl.c(paramString1, this.cHy, this.mFileId, paramString2, this.mFileSize, this.mFileName);
    this.KA.setVisibility(8);
    this.KC.setVisibility(0);
    this.mProgressBar.setProgress(0);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    mg(this.ayu);
    paramBundle = getIntent();
    this.mFileName = paramBundle.getStringExtra("_file_name_");
    this.mFileSize = paramBundle.getLongExtra("_file_size_", 0L);
    this.mSha = paramBundle.getStringExtra("_file_sha_");
    this.mFileId = paramBundle.getStringExtra("_file_id_");
    this.cHy = paramBundle.getStringExtra("_file_url_");
    this.jdField_a_of_type_ComTencentUtilBinderWarpper = ((BinderWarpper)paramBundle.getParcelableExtra("file_manager_provider"));
    dfh();
    this.jdField_a_of_type_Atwl = atwl.a.a(this.jdField_a_of_type_ComTencentUtilBinderWarpper.binder);
    this.jdField_a_of_type_Atwl.a(this.jdField_a_of_type_Atwm);
    this.jdField_a_of_type_Atwl.a(this.mFileName, this.mFileId, this.cHy, this.mSha, this.mFileSize);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      super.onClick(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.KB != null) {
        this.KB.setVisibility(8);
      }
      Qq();
      continue;
      if (TextUtils.isEmpty(this.cHx))
      {
        if ((audx.amK()) && (this.mFileSize > agmx.fJ()))
        {
          try
          {
            Activity localActivity = getHostActivity();
            aqha.a(localActivity, 230, localActivity.getString(2131693826), localActivity.getString(2131693828), "取消", "继续", new atmz(this), new atna(this)).show();
          }
          catch (Throwable localThrowable) {}
        }
        else
        {
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("sha", this.mSha);
            localJSONObject.put("auto", false);
            this.e.dispatchJsEvent("downloadFile", localJSONObject, null);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QLog.e(TAG, 1, localJSONException.toString());
            }
          }
        }
      }
      else
      {
        cg(this.cHx, this.mSha);
        continue;
        getHostActivity().finish();
        continue;
        this.jdField_a_of_type_Atwl.pauseDownload(this.cHx);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atwl != null) {
      this.jdField_a_of_type_Atwl.unregisterCallback();
    }
    super.onDestroy();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    boolean bool2 = super.onTouch(paramView, paramMotionEvent);
    if (this.ar == null) {
      return bool2;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return bool2;
      this.mDownX = ((int)paramMotionEvent.getX());
      this.mDownY = ((int)paramMotionEvent.getY());
      this.dik = true;
      this.ar.postDelayed(this.is, 250L);
      continue;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      float f1;
      float f2;
      if ((Math.abs(i - this.mDownX) > 100) || (Math.abs(j - this.mDownY) > 100))
      {
        this.dik = false;
        this.ar.removeCallbacks(this.is);
        f1 = Math.abs(i - this.mDownX);
        f2 = Math.abs(j - this.mDownY);
        if (f2 > f1)
        {
          if (f1 < 0.01F)
          {
            VC(true);
            return bool2;
          }
          if (f2 / f1 > 1.73205F)
          {
            VC(true);
            return bool2;
          }
        }
      }
      else
      {
        this.dik = false;
        this.ar.removeCallbacks(this.is);
        if (!this.isFullScreen) {}
        for (;;)
        {
          VC(bool1);
          return bool2;
          bool1 = false;
        }
        i = (int)paramMotionEvent.getX();
        j = (int)paramMotionEvent.getY();
        if ((Math.abs(i - this.mDownX) > 100) || (Math.abs(j - this.mDownY) > 100))
        {
          this.dik = false;
          this.ar.removeCallbacks(this.is);
          f1 = Math.abs(i - this.mDownX);
          f2 = Math.abs(j - this.mDownY);
          if (f2 > f1)
          {
            if (f1 < 0.01F)
            {
              VC(true);
              return bool2;
            }
            if (f2 / f1 > 1.73205F)
            {
              VC(true);
              return bool2;
              this.dik = false;
              this.ar.removeCallbacks(this.is);
            }
          }
        }
      }
    }
  }
  
  public class a
    extends arbt
  {
    public a() {}
    
    public void c(int paramInt, String paramString, Bundle paramBundle)
    {
      if (2 == paramInt)
      {
        WpsFilePreviewFragment.a(WpsFilePreviewFragment.this).an(1, WpsFilePreviewFragment.e(WpsFilePreviewFragment.this), WpsFilePreviewFragment.f(WpsFilePreviewFragment.this));
        return;
      }
      if (141 == paramInt)
      {
        WpsFilePreviewFragment.a(WpsFilePreviewFragment.this).an(2, WpsFilePreviewFragment.e(WpsFilePreviewFragment.this), WpsFilePreviewFragment.f(WpsFilePreviewFragment.this));
        return;
      }
      if (142 == paramInt)
      {
        WpsFilePreviewFragment.a(WpsFilePreviewFragment.this).an(3, WpsFilePreviewFragment.e(WpsFilePreviewFragment.this), WpsFilePreviewFragment.f(WpsFilePreviewFragment.this));
        return;
      }
      if (143 == paramInt)
      {
        WpsFilePreviewFragment.a(WpsFilePreviewFragment.this).an(4, WpsFilePreviewFragment.e(WpsFilePreviewFragment.this), WpsFilePreviewFragment.f(WpsFilePreviewFragment.this));
        return;
      }
      if (144 == paramInt)
      {
        WpsFilePreviewFragment.a(WpsFilePreviewFragment.this).an(5, WpsFilePreviewFragment.e(WpsFilePreviewFragment.this), WpsFilePreviewFragment.f(WpsFilePreviewFragment.this));
        return;
      }
      super.c(paramInt, paramString, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.wps.WpsFilePreviewFragment
 * JD-Core Version:    0.7.0.1
 */