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
import com.tencent.token.cw;
import com.tencent.token.cx;
import com.tencent.token.do;
import com.tencent.token.global.c;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.ProDialogWithShutDown;
import com.tencent.token.ui.base.by;
import com.tencent.token.ui.base.bz;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;
import com.tencent.token.utils.x;

public class WelcomeActivity
  extends Activity
  implements bz
{
  private static final int BTN_HEIGHT = 45;
  private static final int BTN_WIDTH = 200;
  private static final int FLING_MIN_DISTANCE = 0;
  private static final int IMAGE_LEVEL_COUNT = mBitmapIds.length;
  private static final int[] mBitmapIds = { 2130837706, 2130837707 };
  private int DOT_OFFSET_X;
  private int DOT_OFFSET_Y;
  private int DOT_SIZE;
  private UserTask mActiveTask = null;
  private GestureDetector mDetector = new GestureDetector(new afp(this));
  private Dialog mDialog;
  private Bitmap mDotEmpty;
  private Bitmap mDotFull;
  private Button mEndBtn;
  private boolean mFirstInstall = false;
  private Handler mHandler = new afo(this);
  private int mHeight;
  private int mLevel = 0;
  private boolean mLowQuality;
  private by mPageCurlView;
  private ProDialogWithShutDown mProDialog;
  private UserTask mSyncInitTask = null;
  private int mWidth;
  
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
      this.mPageCurlView.c();
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
    this.mSyncInitTask = new afq(this);
    this.mSyncInitTask.c(new String[] { "" });
  }
  
  private void init()
  {
    cx.b(c.h());
    try
    {
      h.b("totalMemory:" + Runtime.getRuntime().totalMemory() + " freeMemory:" + Runtime.getRuntime().freeMemory() + " maxMemory:" + Runtime.getRuntime().maxMemory());
      if (x.b()) {}
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
    Object localObject = cx.c();
    if ((this.mActiveTask != null) && (this.mActiveTask.b() != UserTask.Status.FINISHED)) {
      this.mActiveTask.a(true);
    }
    if (!((cx)localObject).g())
    {
      if (do.a().d() == 0)
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
        if (do.a().e() == null) {
          break label125;
        }
        ((Intent)localObject).putExtra("index_from", 17);
      }
      for (;;)
      {
        startActivity((Intent)localObject);
        finish();
        return;
        label125:
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
    cw.a().d(this.mHandler);
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
        h.b(localException.toString());
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
        h.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
      finish();
      return true;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.b(this + ",task" + getTaskId());
    h.a("width = " + getWindowManager().getDefaultDisplay().getWidth() + ", height = " + getWindowManager().getDefaultDisplay().getHeight());
    init();
  }
  
  protected void onDestroy()
  {
    if (this.mPageCurlView != null) {
      this.mPageCurlView.c();
    }
    this.mPageCurlView = null;
    cw.a().a(getClass().getName());
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
    this.mPageCurlView.setViewRect(localRect);
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