package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.tencent.token.aap;
import com.tencent.token.ais;
import com.tencent.token.core.bean.QueryCaptchaResult;
import com.tencent.token.rf;
import com.tencent.token.sc;
import com.tencent.token.sc.a;
import com.tencent.token.si;
import com.tencent.token.sj;
import com.tencent.token.th;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.xf;
import com.tencent.token.xh;
import com.tencent.token.xj;
import com.tencent.token.zd;
import com.tencent.token.zd.a;

public class WelcomeActivity
  extends Activity
  implements zd.a
{
  private static final int BTN_HEIGHT = 45;
  private static final int BTN_WIDTH = 200;
  private static final int FLING_MIN_DISTANCE = 0;
  private static final int IMAGE_LEVEL_COUNT = 2;
  private static final int[] mBitmapIds = { 2131099853, 2131099854 };
  private int DOT_OFFSET_X;
  private int DOT_OFFSET_Y;
  private int DOT_SIZE;
  private UserTask<String, String, xh> mActiveTask = null;
  private GestureDetector mDetector = new GestureDetector(new GestureDetector.OnGestureListener()
  {
    public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
    
    public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      try
      {
        if (paramAnonymousMotionEvent1.getX() - paramAnonymousMotionEvent2.getX() > 0.0F)
        {
          if (WelcomeActivity.this.mLevel < WelcomeActivity.IMAGE_LEVEL_COUNT - 1)
          {
            paramAnonymousMotionEvent1 = aap.a(WelcomeActivity.this, WelcomeActivity.mBitmapIds[WelcomeActivity.access$104(WelcomeActivity.this)], WelcomeActivity.this.mLowQuality);
            if (paramAnonymousMotionEvent1 == null)
            {
              WelcomeActivity.this.doOutOfMemory();
              return true;
            }
            WelcomeActivity.this.mPageCurlView.a(paramAnonymousMotionEvent1);
            if ((WelcomeActivity.this.mLevel == WelcomeActivity.IMAGE_LEVEL_COUNT - 1) && (WelcomeActivity.this.mEndBtn != null))
            {
              WelcomeActivity.this.mEndBtn.setVisibility(0);
              return true;
            }
          }
        }
        else if ((paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX() > 0.0F) && (WelcomeActivity.this.mLevel > 0))
        {
          paramAnonymousMotionEvent1 = aap.a(WelcomeActivity.this, WelcomeActivity.mBitmapIds[WelcomeActivity.access$106(WelcomeActivity.this)], WelcomeActivity.this.mLowQuality);
          if (paramAnonymousMotionEvent1 == null)
          {
            WelcomeActivity.this.doOutOfMemory();
            return true;
          }
          WelcomeActivity.this.mPageCurlView.b(paramAnonymousMotionEvent1);
          WelcomeActivity.this.mEndBtn.setVisibility(8);
          return true;
        }
      }
      catch (Exception paramAnonymousMotionEvent1)
      {
        paramAnonymousMotionEvent1.printStackTrace();
        WelcomeActivity.this.doOutOfMemory();
        return true;
      }
      catch (OutOfMemoryError paramAnonymousMotionEvent1)
      {
        paramAnonymousMotionEvent1.printStackTrace();
        WelcomeActivity.this.doOutOfMemory();
      }
      return true;
    }
    
    public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
    
    public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      return false;
    }
    
    public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
    
    public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
    {
      return false;
    }
  });
  private Dialog mDialog;
  private Bitmap mDotEmpty;
  private Bitmap mDotFull;
  private Button mEndBtn;
  private boolean mFirstInstall = false;
  @SuppressLint({"HandlerLeak"})
  private Handler mHandler = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      WelcomeActivity localWelcomeActivity = WelcomeActivity.this;
      if (localWelcomeActivity != null)
      {
        if ((localWelcomeActivity != null) && (localWelcomeActivity.isFinishing())) {
          return;
        }
        int i = paramAnonymousMessage.what;
        if (i != 3025)
        {
          if (i != 3071) {
            return;
          }
          if (paramAnonymousMessage.arg1 == 0) {
            if (!((QueryCaptchaResult)paramAnonymousMessage.obj).mNeedCaptcha) {
              WelcomeActivity.this.sendActiveClient();
            }
          }
        }
        else
        {
          i = paramAnonymousMessage.arg1;
        }
        return;
      }
    }
  };
  private int mHeight;
  private int mLevel = 0;
  private boolean mLowQuality;
  private zd mPageCurlView;
  private ProDialogWithShutDown mProDialog;
  private UserTask<String, String, xh> mSyncInitTask = null;
  private int mWidth;
  
  private void doOutOfMemory()
  {
    Object localObject = this.mDotEmpty;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.mDotEmpty = null;
    localObject = this.mDotFull;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    this.mDotFull = null;
    localObject = this.mPageCurlView;
    if (localObject != null) {
      ((zd)localObject).b();
    }
    this.mPageCurlView = null;
    nextActivity();
  }
  
  private void drawDots(int paramInt, Canvas paramCanvas)
  {
    int j = this.DOT_OFFSET_X;
    int i = 0;
    while (i < IMAGE_LEVEL_COUNT)
    {
      if (i == paramInt) {
        paramCanvas.drawBitmap(this.mDotEmpty, j, this.DOT_OFFSET_Y, null);
      } else {
        paramCanvas.drawBitmap(this.mDotFull, j, this.DOT_OFFSET_Y, null);
      }
      j += this.DOT_SIZE * 2;
      i += 1;
    }
  }
  
  private void getSharedKey()
  {
    this.mSyncInitTask = new UserTask() {};
    this.mSyncInitTask.a(new String[] { "" });
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void init()
  {
    sj.b(xf.h());
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("totalMemory:");
      localStringBuilder.append(Runtime.getRuntime().totalMemory());
      localStringBuilder.append(" freeMemory:");
      localStringBuilder.append(Runtime.getRuntime().freeMemory());
      localStringBuilder.append(" maxMemory:");
      localStringBuilder.append(Runtime.getRuntime().maxMemory());
      xj.b(localStringBuilder.toString());
      aap.b();
      nextActivity();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      doOutOfMemory();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      doOutOfMemory();
    }
  }
  
  private void nextActivity()
  {
    Object localObject = this.mActiveTask;
    if ((localObject != null) && (((UserTask)localObject).e != UserTask.Status.FINISHED)) {
      this.mActiveTask.c();
    }
    if (!rf.a().d())
    {
      if (th.a().k.a() == 0)
      {
        localObject = new Intent(this, IndexActivity.class);
        ((Intent)localObject).putExtra("index_from", 16);
        startActivity((Intent)localObject);
        finish();
        return;
      }
      localObject = new Intent(this, IndexActivity.class);
      if (this.mFirstInstall) {
        if (th.a().k.b() != null) {
          ((Intent)localObject).putExtra("index_from", 17);
        } else {
          ((Intent)localObject).putExtra("index_from", 16);
        }
      }
      startActivity((Intent)localObject);
      finish();
      return;
    }
    localObject = new Intent(this, IndexActivity.class);
    ((Intent)localObject).putExtra("index_from", 16);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void sendActiveClient()
  {
    sc.a.a().a(this.mHandler);
  }
  
  public void dismissDialog()
  {
    if (isFinishing()) {
      return;
    }
    try
    {
      if (this.mDialog != null)
      {
        this.mDialog.cancel();
        this.mDialog = null;
      }
      if (this.mProDialog != null)
      {
        this.mProDialog.dismiss();
        this.mProDialog = null;
      }
      return;
    }
    catch (Exception localException)
    {
      xj.b(localException.toString());
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
      {
        finish();
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("dispatchKeyEvent exception ");
      localStringBuilder.append(this);
      localStringBuilder.append(paramKeyEvent.toString());
      xj.c(localStringBuilder.toString());
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append(this);
    paramBundle.append(",task");
    paramBundle.append(getTaskId());
    xj.b(paramBundle.toString());
    paramBundle = new StringBuilder("width = ");
    paramBundle.append(getWindowManager().getDefaultDisplay().getWidth());
    paramBundle.append(", height = ");
    paramBundle.append(getWindowManager().getDefaultDisplay().getHeight());
    xj.a(paramBundle.toString());
    init();
  }
  
  protected void onDestroy()
  {
    zd localzd = this.mPageCurlView;
    if (localzd != null) {
      localzd.b();
    }
    this.mPageCurlView = null;
    si.a().a(getClass().getName());
    super.onDestroy();
  }
  
  public void onDrawDots(Canvas paramCanvas, boolean paramBoolean)
  {
    int i = this.mLevel;
    if (i != IMAGE_LEVEL_COUNT - 1) {
      drawDots(i, paramCanvas);
    }
  }
  
  public void onDrawDotsBack(Canvas paramCanvas, boolean paramBoolean)
  {
    drawDots(this.mLevel, paramCanvas);
  }
  
  public void onNextPage(boolean paramBoolean) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.mDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      return;
    }
    if (this.mPageCurlView != null)
    {
      Rect localRect = new Rect();
      getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      localRect.bottom -= localRect.top;
      localRect.top = 0;
      this.mWidth = localRect.width();
      this.mHeight = localRect.height();
      this.mPageCurlView.setViewRect(localRect);
    }
  }
  
  public void showUserDialog(int paramInt1, String paramString, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mDialog = new AlertDialog.Builder(this).setTitle(paramInt1).setMessage(paramString).setPositiveButton(paramInt2, paramOnClickListener).create();
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */