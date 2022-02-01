package dov.com.qq.im.ptv;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import axol;
import ayan;
import aybp;
import aybp.a;
import ayca;
import aycb;
import aycc;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowActivity;

@TargetApi(14)
public class PtvSoDownloadActivity
  extends FlowActivity
  implements aybp.a, ayca, aycb
{
  aycc a;
  private Bundle args;
  private String cWB;
  private boolean dxB;
  private boolean dxC;
  private int eJd;
  private boolean hasRequest;
  
  public static Intent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, PtvSoDownloadActivity.class);
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("PTV_SO_ARG_FRAGMENT_CLASS", paramString);
    return paramContext;
  }
  
  private boolean av(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return aw(paramMotionEvent);
    }
    View localView = bJ();
    if (localView == null) {
      return aw(paramMotionEvent);
    }
    int i = localView.getTop();
    if (paramMotionEvent.getY() > i) {
      eET();
    }
    return aw(paramMotionEvent);
  }
  
  public void K(ViewGroup paramViewGroup)
  {
    if (this.dxB) {}
    for (int i = this.cik;; i = 0)
    {
      Object localObject1 = paramViewGroup.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = i;
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, paramViewGroup.getId());
      localObject1 = new RelativeLayout(this);
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(this.a.onCreateView());
      localObject2 = (ViewGroup)$(2131367326);
      if (this.dxB)
      {
        ImageView localImageView = new ImageView(this);
        localImageView.setImageResource(2130845451);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        localLayoutParams.addRule(2, paramViewGroup.getId());
        localImageView.setLayoutParams(localLayoutParams);
        ((ViewGroup)localObject2).addView(localImageView, 0);
      }
      ((ViewGroup)localObject2).addView((View)localObject1);
      return;
    }
  }
  
  public void acX(int paramInt)
  {
    finish();
  }
  
  public void eET()
  {
    super.onBackPressed();
  }
  
  public void ePw()
  {
    if (TextUtils.isEmpty(this.cWB)) {
      this.cWB = ayan.class.getName();
    }
    if (this.args != null) {
      if (this.hasRequest)
      {
        this.args.putBoolean("flow_camera_download_light", true);
        PtvCameraCaptureActivity.b(this, this.cWB, this.args, this.eJd);
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      PtvCameraCaptureActivity.b(this, this.cWB, this.args);
      finish();
      return;
    }
    QLog.i("PtvSoDownloadActivity", 2, "fragmentName:" + this.cWB + " hasRequest:" + this.hasRequest + "pendingIntentRequest" + this.eJd + " mIsMultiWindowMode: " + this.dxC + " args=null error.");
  }
  
  public void finish()
  {
    super.finish();
    if (this.a != null) {
      this.a.finish();
    }
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public AppInterface getAppInterface()
  {
    return axol.getAppInterface();
  }
  
  public void initData(Bundle paramBundle)
  {
    super.initData(paramBundle);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.a != null) {
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (this.hasRequest)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
  }
  
  public void onBackPressed()
  {
    if (this.a != null) {
      this.a.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.dxB = getIntent().getBooleanExtra("flow_camera_show_panel", false);
    if (!this.dxB) {
      getWindow().setBackgroundDrawableResource(2130845451);
    }
    this.dxC = isInMultiWindow();
    this.a = new aybp(this, this);
    super.onCreate(paramBundle);
    this.a.onCreate(paramBundle);
    if (this.dxC)
    {
      QQToast.a(this, acfp.m(2131710194), 0).show();
      finish();
    }
    do
    {
      return;
      this.cWB = getIntent().getStringExtra("PTV_SO_ARG_FRAGMENT_CLASS");
      this.hasRequest = getIntent().hasExtra("PTV_pendingIntentRequest");
      if (this.hasRequest) {
        this.eJd = getIntent().getIntExtra("PTV_pendingIntentRequest", 0);
      }
      this.args = getIntent().getExtras();
    } while (!QLog.isColorLevel());
    QLog.i("PtvSoDownloadActivity", 2, "fragmentName:" + this.cWB + " hasRequest:" + this.hasRequest + "pendingIntentRequest" + this.eJd);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.onDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a != null) {
      return this.a.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    if (this.a != null) {
      this.a.onNewIntent(paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.onActivityPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.onActivityResume();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.a != null) {
      this.a.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.a != null) {
      this.a.onActivityStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.a != null) {
      this.a.onActivityStop();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      return this.a.onTouchEvent(paramMotionEvent, av(paramMotionEvent));
    }
    return av(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.PtvSoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */