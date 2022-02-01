package com.tencent.push;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;

public class PActivity
  extends Activity
{
  private a mContainerLayout;
  private boolean mMonitorBottom = true;
  private d mPush;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    this.mPush = c.a().b();
    if (this.mPush == null)
    {
      finish();
      return;
    }
    this.mContainerLayout = new a(this);
    paramBundle = this.mPush.i();
    if (this.mMonitorBottom)
    {
      this.mSavePushLp = new WindowManager.LayoutParams();
      this.mSavePushLp.copyFrom(paramBundle);
    }
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    paramBundle.token = localLayoutParams.token;
    paramBundle.type = localLayoutParams.type;
    if (e.a) {
      paramBundle.y += e.a();
    }
    if (this.mMonitorBottom)
    {
      paramBundle.height = (e.d() - paramBundle.y);
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
      public void addView(View paramAnonymousView, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        if (PActivity.this.mMonitorBottom) {
          paramAnonymousView.setX(PActivity.this.mSavePushLp.x);
        }
        PActivity.this.mContainerLayout.addView(paramAnonymousView, new ViewGroup.LayoutParams(paramAnonymousLayoutParams.width, paramAnonymousLayoutParams.height));
      }
      
      public void removeView(View paramAnonymousView)
      {
        PActivity.this.mContainerLayout.removeView(paramAnonymousView);
        PActivity.this.finish();
      }
      
      public void updateViewLayout(View paramAnonymousView, ViewGroup.LayoutParams paramAnonymousLayoutParams) {}
    };
    this.mPush.a(paramBundle, 3);
  }
  
  protected void onStop()
  {
    super.onStop();
    d locald = this.mPush;
    if ((locald != null) && (locald.j() == 4))
    {
      this.mPush.b(null);
      this.mPush.a(true);
    }
    finish();
  }
  
  public void setTheme(int paramInt)
  {
    super.setTheme(2131558784);
  }
  
  private class a
    extends FrameLayout
  {
    private boolean b = false;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((this.b) && (paramMotionEvent.getActionMasked() == 0))
      {
        float f = paramMotionEvent.getRawY();
        if (e.d() - f <= e.a(getContext(), 60.0F))
        {
          if ((PActivity.this.mPush != null) && (PActivity.this.mPush.j() == 4))
          {
            PActivity.this.mPush.b(null);
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