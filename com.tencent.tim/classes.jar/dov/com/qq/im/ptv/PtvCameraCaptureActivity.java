package dov.com.qq.im.ptv;

import acfp;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anfv;
import axol;
import ayak;
import aybu;
import ayca;
import aycb;
import aycc;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowActivity;

@TargetApi(14)
public class PtvCameraCaptureActivity
  extends FlowActivity
  implements ayca, aycb
{
  aycc a;
  private boolean dxB;
  
  public static Intent a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = new Intent(paramContext, PtvCameraCaptureActivity.class);
    paramContext.putExtras(paramBundle);
    paramContext.putExtra("LIGHT_ARG_FRAGMENT_CLASS", paramString);
    paramContext.putExtra("need_show_banner", false);
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
    if (paramMotionEvent.getY() > i) {}
    return aw(paramMotionEvent);
  }
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramActivity.startActivity(a(paramActivity, paramString, paramBundle));
    paramActivity.overridePendingTransition(2130771999, 0);
  }
  
  public static void b(Activity paramActivity, String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramActivity.startActivityForResult(a(paramActivity, paramString, paramBundle), paramInt);
    paramActivity.overridePendingTransition(2130771999, 0);
  }
  
  public static void e(LWMotionEvent paramLWMotionEvent)
  {
    ayak.a(paramLWMotionEvent);
  }
  
  public static void eQb() {}
  
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
  
  public void finish()
  {
    super.finish();
    this.a.finish();
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
    this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    this.a.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    this.dxB = getIntent().getBooleanExtra("flow_camera_show_panel", false);
    String str = getIntent().getStringExtra("LIGHT_ARG_FRAGMENT_CLASS");
    ayak.j(this, str, getIntent().getBooleanExtra("flow_camera_download_light", false));
    this.a = ayak.a(str, this, this);
    super.onCreate(paramBundle);
    this.a.onCreate(paramBundle);
    if (isInMultiWindow())
    {
      QQToast.a(this, acfp.m(2131710192), 0).show();
      finish();
    }
    do
    {
      return;
      long l1 = System.currentTimeMillis();
      long l2 = getIntent().getLongExtra("ACTIVITY_START_TIME", l1);
      QLog.i("PtvCameraCaptureActivity", 2, "start cost:" + (l1 - l2) + " ms");
      anfv.aS("sv_light_cost_time_ui", l1 - l2);
    } while (!(this.a instanceof aybu));
    ayak.b((aybu)this.a);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.onDestroy();
    if ((this.a instanceof aybu)) {
      ayak.a((aybu)this.a);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.a.a(paramInt, paramKeyEvent, super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    getIntent().putExtras(paramIntent);
    this.a.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.a.onActivityPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.a.onActivityResume();
    if (QLog.isColorLevel()) {
      QLog.i("PtvCameraCaptureActivity", 2, "onResume");
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.a.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.onActivityStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.onActivityStop();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent, av(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ptv.PtvCameraCaptureActivity
 * JD-Core Version:    0.7.0.1
 */