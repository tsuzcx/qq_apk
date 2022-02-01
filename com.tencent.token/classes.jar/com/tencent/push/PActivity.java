package com.tencent.push;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.token.qj;
import com.tencent.token.qj.a;
import com.tencent.token.qk;
import com.tencent.token.ql;
import com.tmsdk.base.utils.SDKUtil;

public class PActivity
  extends Activity
{
  private a mContainerLayout;
  private boolean mMonitorBottom = true;
  private qk mPush;
  private WindowManager.LayoutParams mSavePushLp;
  
  private void shrinkArea()
  {
    Object localObject = getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).x = this.mSavePushLp.x;
    ((WindowManager.LayoutParams)localObject).width = this.mSavePushLp.width;
    ((WindowManager.LayoutParams)localObject).height = this.mSavePushLp.height;
    ((WindowManager)getSystemService("window")).updateViewLayout(getWindow().getDecorView(), (ViewGroup.LayoutParams)localObject);
    localObject = this.mContainerLayout.getChildAt(0);
    if (localObject != null) {
      ((View)localObject).setX(0.0F);
    }
    a.a(this.mContainerLayout, false);
  }
  
  public void finish()
  {
    if (!isFinishing())
    {
      super.finish();
      overridePendingTransition(0, 0);
    }
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    ApplicationInfo localApplicationInfo = super.getApplicationInfo();
    if (SDKUtil.getSDKVersion() == 26) {
      localApplicationInfo.targetSdkVersion = 26;
    }
    return localApplicationInfo;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    this.mPush = qj.a.a().a;
    if (this.mPush == null)
    {
      finish();
      return;
    }
    this.mContainerLayout = new a(this);
    paramBundle = this.mPush.h();
    if (this.mMonitorBottom)
    {
      this.mSavePushLp = new WindowManager.LayoutParams();
      this.mSavePushLp.copyFrom(paramBundle);
    }
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    paramBundle.token = localLayoutParams.token;
    paramBundle.type = localLayoutParams.type;
    if (ql.a) {
      paramBundle.y += ql.a();
    }
    if (this.mMonitorBottom)
    {
      paramBundle.height = (ql.c() - paramBundle.y);
      paramBundle.x = 0;
      paramBundle.width = -1;
      a.a(this.mContainerLayout, true);
    }
    if ((paramBundle.flags & 0x8) != 0) {
      paramBundle.flags &= 0xFFFFFFF7;
    }
    localWindow.setAttributes(paramBundle);
    setContentView(this.mContainerLayout, new ViewGroup.LayoutParams(-1, -1));
    paramBundle = new ViewManager()
    {
      public final void addView(View paramAnonymousView, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        if (PActivity.this.mMonitorBottom) {
          paramAnonymousView.setX(PActivity.this.mSavePushLp.x);
        }
        PActivity.this.mContainerLayout.addView(paramAnonymousView, new ViewGroup.LayoutParams(paramAnonymousLayoutParams.width, paramAnonymousLayoutParams.height));
      }
      
      public final void removeView(View paramAnonymousView)
      {
        PActivity.this.mContainerLayout.removeView(paramAnonymousView);
        PActivity.this.finish();
      }
      
      public final void updateViewLayout(View paramAnonymousView, ViewGroup.LayoutParams paramAnonymousLayoutParams) {}
    };
    this.mPush.a(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    qk localqk = this.mPush;
    if ((localqk != null) && (localqk.z == 4))
    {
      localqk = this.mPush;
      localqk.v = null;
      localqk.a(true);
    }
    finish();
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(2131558784);
  }
  
  final class a
    extends FrameLayout
  {
    private boolean b = false;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((this.b) && (paramMotionEvent.getActionMasked() == 0))
      {
        float f = paramMotionEvent.getRawY();
        if (ql.c() - f <= ql.a(getContext(), 60.0F))
        {
          if ((PActivity.this.mPush != null) && (PActivity.this.mPush.z == 4))
          {
            PActivity.this.mPush.v = null;
            PActivity.this.mPush.a(true);
            return bool;
          }
        }
        else {
          PActivity.this.shrinkArea();
        }
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.push.PActivity
 * JD-Core Version:    0.7.0.1
 */