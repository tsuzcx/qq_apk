package com.tencent.token.ui;

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
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.tencent.token.af;
import com.tencent.token.ag;
import com.tencent.token.ax;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.ui.base.cf;
import com.tencent.token.ui.base.cg;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.utils.t;

public class WelcomeActivity
  extends Activity
  implements cg
{
  private static final int BTN_HEIGHT = 45;
  private static final int BTN_WIDTH = 200;
  private static final int FLING_MIN_DISTANCE = 0;
  private static final int IMAGE_LEVEL_COUNT;
  private static final int[] mBitmapIds;
  private int DOT_OFFSET_X;
  private int DOT_OFFSET_Y;
  private int DOT_SIZE;
  private UserTask mActiveTask = null;
  private GestureDetector mDetector = new GestureDetector(new agz(this));
  private Dialog mDialog;
  private Bitmap mDotEmpty;
  private Bitmap mDotFull;
  private Button mEndBtn;
  private boolean mFirstInstall = false;
  private Handler mHandler = new agy(this);
  private int mHeight;
  private int mLevel = 0;
  private boolean mLowQuality;
  private cf mPageCurlView;
  private ProDialogWithShutDown mProDialog;
  private UserTask mSyncInitTask = null;
  private int mWidth;
  
  static
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = 2130837619;
    arrayOfInt[1] = 2130837620;
    arrayOfInt;
    mBitmapIds = arrayOfInt;
    IMAGE_LEVEL_COUNT = arrayOfInt.length;
  }
  
  private void doOutOfMemory()
  {
    if (this.mDotEmpty != null) {
      this.mDotEmpty.recycle();
    }
    this.mDotEmpty = null;
    if (this.mDotFull != null) {
      this.mDotFull.recycle();
    }
    this.mDotFull = null;
    if (this.mPageCurlView != null) {
      this.mPageCurlView.b();
    }
    this.mPageCurlView = null;
    nextActivity();
  }
  
  private void drawDots(int paramInt, Canvas paramCanvas)
  {
    int j = this.DOT_OFFSET_X;
    int i = 0;
    if (i < IMAGE_LEVEL_COUNT)
    {
      if (i == paramInt) {
        paramCanvas.drawBitmap(this.mDotEmpty, j, this.DOT_OFFSET_Y, null);
      }
      for (;;)
      {
        j += this.DOT_SIZE * 2;
        i += 1;
        break;
        paramCanvas.drawBitmap(this.mDotFull, j, this.DOT_OFFSET_Y, null);
      }
    }
  }
  
  private void getSharedKey()
  {
    this.mSyncInitTask = new aha(this);
    this.mSyncInitTask.a(new String[] { "" });
  }
  
  private void init()
  {
    ag.b(b.g());
    try
    {
      e.b("totalMemory:" + Runtime.getRuntime().totalMemory() + " freeMemory:" + Runtime.getRuntime().freeMemory() + " maxMemory:" + Runtime.getRuntime().maxMemory());
      t.b();
      nextActivity();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      doOutOfMemory();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      doOutOfMemory();
    }
  }
  
  private void nextActivity()
  {
    Object localObject = ag.c();
    if ((this.mActiveTask != null) && (this.mActiveTask.c() != UserTask.Status.FINISHED)) {
      this.mActiveTask.d();
    }
    if (!((ag)localObject).g())
    {
      if (ax.a().d() == 0)
      {
        localObject = new Intent(this, IndexActivity.class);
        ((Intent)localObject).putExtra("index_from", 16);
        startActivity((Intent)localObject);
        finish();
        return;
      }
      localObject = new Intent(this, IndexActivity.class);
      if (this.mFirstInstall)
      {
        if (ax.a().e() == null) {
          break label126;
        }
        ((Intent)localObject).putExtra("index_from", 17);
      }
      for (;;)
      {
        startActivity((Intent)localObject);
        finish();
        return;
        label126:
        ((Intent)localObject).putExtra("index_from", 16);
      }
    }
    localObject = new Intent(this, IndexActivity.class);
    ((Intent)localObject).putExtra("index_from", 16);
    startActivity((Intent)localObject);
    finish();
  }
  
  private void sendActiveClient()
  {
    af.a().d(this.mHandler);
  }
  
  public void dismissDialog()
  {
    if (isFinishing()) {}
    for (;;)
    {
      return;
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
          return;
        }
      }
      catch (Exception localException)
      {
        e.b(localException.toString());
      }
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        e.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      finish();
      return true;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e.b(this + ",task" + getTaskId());
    e.a("width = " + getWindowManager().getDefaultDisplay().getWidth() + ", height = " + getWindowManager().getDefaultDisplay().getHeight());
    init();
  }
  
  protected void onDestroy()
  {
    if (this.mPageCurlView != null) {
      this.mPageCurlView.b();
    }
    this.mPageCurlView = null;
    af.a().a(getClass().getName());
    super.onDestroy();
  }
  
  public void onDrawDots(Canvas paramCanvas, boolean paramBoolean)
  {
    if (this.mLevel != IMAGE_LEVEL_COUNT - 1) {
      drawDots(this.mLevel, paramCanvas);
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
    if (!paramBoolean) {}
    while (this.mPageCurlView == null) {
      return;
    }
    Rect localRect = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    localRect.bottom -= localRect.top;
    localRect.top = 0;
    this.mWidth = localRect.width();
    this.mHeight = localRect.height();
    this.mPageCurlView.a(localRect);
  }
  
  public void showProDialog(Activity paramActivity, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (isFinishing()) {
      return;
    }
    dismissDialog();
    this.mProDialog = new ProDialogWithShutDown(paramActivity, null, paramActivity.getString(2131361844));
    this.mProDialog.show();
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