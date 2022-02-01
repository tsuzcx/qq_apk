package com.tencent.qqmail.utilities.imageextention;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.DeviceInfoUtil;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.ReadMailDetailView;
import com.tencent.qqmail.view.TitleBarWebView2;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class WebviewCaptureTask
{
  private static final int SCROLL_INTERVAL = 300;
  private static final int SCROLL_TIMES_NEED_INTERVAL_TO_RENDER = 5;
  private static final String TAG = "WebviewCaptureTask";
  private CallBack callBack;
  private long captureStartTime;
  private ReadMailDetailView detailView;
  private int endPart;
  private Bitmap fakeWebViewImage;
  private String fileName;
  private FrameLayout frameLayout;
  private ImageView imageView;
  private float initialScrollX;
  private float initialScrollY;
  private int screenCount;
  private View title;
  private float titleZoomFactor;
  private TitleBarWebView2 webView;
  private int webViewShownHeight;
  private int webViewTotalHeight;
  private int zoomOutTimes;
  
  private WebviewCaptureTask(TitleBarWebView2 paramTitleBarWebView2, View paramView, ReadMailDetailView paramReadMailDetailView, String paramString, CallBack paramCallBack)
  {
    this.webView = paramTitleBarWebView2;
    this.title = paramView;
    this.detailView = paramReadMailDetailView;
    this.fileName = paramString;
    this.callBack = paramCallBack;
  }
  
  private void afterCaptureByScroll(Bitmap paramBitmap)
  {
    QMLog.log(4, "WebviewCaptureTask", "capture time:" + (System.currentTimeMillis() - this.captureStartTime));
    zoomInAndScrollToInitialPosition();
    handleComplete(paramBitmap);
  }
  
  private float caculateZoomFactor()
  {
    if (isCannotSupportSnapshot()) {
      return 1.0F;
    }
    int i = this.webView.getContentWidth();
    int j = this.title.getWidth();
    return i / j;
  }
  
  private void captureWholeWebViewByScroll(int paramInt)
  {
    prepareFroScroll();
    startCaptureByScroll(paramInt);
  }
  
  private void coverWebviewSnapshot()
  {
    this.frameLayout = ((FrameLayout)this.webView.getParent());
    this.imageView = new ImageView(QMApplicationContext.sharedInstance());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    this.frameLayout.addView(this.imageView, localLayoutParams);
    this.imageView.setImageBitmap(this.fakeWebViewImage);
    this.imageView.setVisibility(0);
    QMLog.log(4, "WebviewCaptureTask", "add fake webview image");
  }
  
  private void drawBitmap(Canvas paramCanvas, Paint paramPaint, int paramInt)
  {
    paramCanvas.save();
    if (paramInt == 0)
    {
      int i = this.webView.getWidth();
      if (this.endPart != 0)
      {
        paramInt = this.endPart;
        paramCanvas.clipRect(0, 0, i, paramInt);
      }
    }
    for (;;)
    {
      this.webView.draw(paramCanvas);
      paramCanvas.restore();
      return;
      paramInt = this.webViewShownHeight;
      break;
      paramInt = getCurrentTop(paramInt);
      paramCanvas.clipRect(0, paramInt, this.webView.getWidth(), this.webViewShownHeight + paramInt);
    }
  }
  
  private static void drawWaterMark(View paramView, Bitmap paramBitmap)
  {
    float f = paramBitmap.getWidth() / paramView.getWidth();
    int k = (int)(QMUIKit.dpToPx(40) * f);
    Canvas localCanvas = new Canvas(paramBitmap);
    Paint localPaint = new Paint(1);
    String str1 = paramView.getResources().getString(2131696760) + " ";
    String str2 = " " + paramView.getResources().getString(2131696759);
    int i = paramBitmap.getHeight() - k;
    localPaint.setColor(-1);
    localCanvas.drawRect(0.0F, i, paramBitmap.getWidth(), paramBitmap.getHeight(), localPaint);
    localPaint.setColor(-3618616);
    localPaint.setStrokeWidth(1.0F);
    localCanvas.drawLine(0.0F, i, paramBitmap.getWidth(), i, localPaint);
    i = (int)(paramView.getHeight() * f);
    localCanvas.drawLine(0.0F, i, paramBitmap.getWidth(), i, localPaint);
    localPaint.setColor(paramView.getResources().getColor(2131167531));
    localPaint.setTextSize(QMUIKit.dpToPx(12) * f);
    paramView = BitmapFactory.decodeResource(paramView.getResources(), 2130840857);
    int j = 0;
    i = 0;
    if (paramView != null)
    {
      j = (int)(paramView.getWidth() * f);
      i = (int)(paramView.getHeight() * f);
    }
    int i1 = QMUIKit.dpToPx(10);
    int m = (int)localPaint.measureText(str1);
    int i2 = (int)localPaint.measureText(str2);
    Paint.FontMetricsInt localFontMetricsInt = localPaint.getFontMetricsInt();
    int n = paramBitmap.getHeight() - (k - (localFontMetricsInt.bottom - localFontMetricsInt.top)) / 2 - localFontMetricsInt.bottom;
    k = paramBitmap.getWidth() - i1 - i2;
    localCanvas.drawText(str2, k, n, localPaint);
    if (paramView != null)
    {
      k = k - 2 - j;
      i1 = localFontMetricsInt.top + n + (localFontMetricsInt.bottom - localFontMetricsInt.top - i) / 2;
      localCanvas.drawBitmap(paramView, new Rect(0, 0, paramView.getWidth(), paramView.getHeight()), new Rect(k, i1, j + k, i + i1), null);
    }
    for (i = k - 2;; i = k)
    {
      localCanvas.drawText(str1, i - m, n, localPaint);
      return;
    }
  }
  
  private int getCurrentTop(int paramInt)
  {
    return this.endPart + (paramInt - 1) * this.webViewShownHeight;
  }
  
  private static float getWidthExceedMaxZoomFactor(int paramInt)
  {
    float f = 1.0F;
    if (paramInt > 750) {
      f = 750.0F / paramInt;
    }
    return f;
  }
  
  private void handleComplete(Bitmap paramBitmap)
  {
    recoverUI();
    if (paramBitmap != null) {
      drawWaterMark(this.title, paramBitmap);
    }
    Threads.runInBackground(new WebviewCaptureTask.2(this, paramBitmap));
  }
  
  private static boolean isCannotSupportSnapshot()
  {
    boolean bool2 = false;
    boolean bool1 = BrandUtil.isColorOSV3();
    boolean bool4 = BrandUtil.isAndroidMarshmallow();
    boolean bool5 = BrandUtil.isVivoX9();
    boolean bool3 = DeviceInfoUtil.isMIUI();
    if (Build.VERSION.SDK_INT >= 23) {}
    for (int i = 1;; i = 0)
    {
      if ((!bool1) && (!bool4) && (!bool5))
      {
        bool1 = bool2;
        if (bool3)
        {
          bool1 = bool2;
          if (i == 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private boolean isNeedIntervalToRender(int paramInt)
  {
    return paramInt >= 5;
  }
  
  private static boolean isSupportZoomBy()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  private void prepareFroScroll()
  {
    this.webView.setDrawingCacheEnabled(true);
    this.fakeWebViewImage = Bitmap.createBitmap(this.webView.getDrawingCache(), 0, 0, this.webView.getWidth(), this.webView.getHeight());
    this.webView.destroyDrawingCache();
    this.webView.setDrawingCacheEnabled(false);
    this.initialScrollX = this.webView.getScrollX();
    this.initialScrollY = this.webView.getScrollY();
    this.titleZoomFactor = (this.webView.getContentWidth() / this.title.getWidth());
    if (isSupportZoomBy())
    {
      this.webView.zoomBy(1.0F / this.titleZoomFactor);
      this.zoomOutTimes = 0;
      return;
    }
    this.zoomOutTimes = zoomOutToSmallest(this.webView);
  }
  
  private void recoverUI()
  {
    this.webView.setVerticalScrollBarEnabled(true);
    this.webView.setHorizontalScrollBarEnabled(true);
    if (this.detailView != null) {
      this.detailView.showDetailButton();
    }
  }
  
  @Nullable
  private String saveCaptureAndCallBack(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      QMLog.log(5, "WebviewCaptureTask", "bitmap is null");
      this.callBack.onError(QMApplicationContext.sharedInstance().getString(2131696755));
      return null;
    }
    String str2 = FileUtil.getWebviewScreenshotDir();
    if (TextUtils.isEmpty(str2))
    {
      QMLog.log(5, "WebviewCaptureTask", "can not get screenshotDir");
      this.callBack.onError(QMApplicationContext.sharedInstance().getString(2131696751));
      return null;
    }
    String str1;
    if (TextUtils.isEmpty(this.fileName))
    {
      str1 = System.currentTimeMillis() + "";
      str1 = str2 + str1 + ".jpg";
      boolean bool = ImageUtil.writeBitmapToLocation(paramBitmap, Bitmap.CompressFormat.JPEG, 70, str1);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
      if (!bool) {
        break label184;
      }
      this.callBack.onSuccess(str1);
    }
    for (;;)
    {
      return str2;
      str1 = FileUtil.getLegalFileName(this.fileName);
      break;
      label184:
      QMLog.log(5, "WebviewCaptureTask", "save screenShot fail");
      this.callBack.onError(QMApplicationContext.sharedInstance().getString(2131696751));
    }
  }
  
  private void scrollByInterval(Bitmap paramBitmap, Canvas paramCanvas, Paint paramPaint)
  {
    Observable.interval(300L, TimeUnit.MILLISECONDS).takeWhile(new WebviewCaptureTask.4(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new WebviewCaptureTask.3(this, paramBitmap, paramCanvas, paramPaint));
  }
  
  private void startCaptureByScroll(int paramInt)
  {
    int i = 0;
    this.webViewTotalHeight = ((int)(this.webView.getScale() * this.webView.getContentHeight()));
    this.webViewShownHeight = this.webView.getHeight();
    this.screenCount = (this.webViewTotalHeight / this.webViewShownHeight + 1);
    this.endPart = (this.webViewTotalHeight % this.webViewShownHeight);
    Log.v("WebviewCaptureTask", "screenCount:" + this.screenCount + ", endPart:" + this.endPart);
    if (isNeedIntervalToRender(this.screenCount - 1)) {
      coverWebviewSnapshot();
    }
    for (;;)
    {
      float f = getWidthExceedMaxZoomFactor(this.webView.getWidth());
      int j = (int)(this.webView.getWidth() * f);
      paramInt = (int)((this.webViewTotalHeight + paramInt) * f);
      Log.v("WebviewCaptureTask", "webViewTotalHeight:" + this.webViewTotalHeight + ", webViewShownHeight:" + this.webViewShownHeight + ", widthExceedMaxZoomFactor:" + f + ", imageWidth:" + j + ", imageHeight:" + paramInt);
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(j, paramInt, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        localCanvas.scale(f, f);
        Paint localPaint = new Paint();
        this.captureStartTime = System.currentTimeMillis();
        this.webView.scrollTo(0, 0);
        paramInt = i;
        if (isNeedIntervalToRender(this.screenCount - 1))
        {
          scrollByInterval(localBitmap, localCanvas, localPaint);
          return;
          if ((this.fakeWebViewImage != null) && (!this.fakeWebViewImage.isRecycled())) {
            this.fakeWebViewImage.recycle();
          }
        }
        else
        {
          while ((this.screenCount > 0) && (paramInt < this.screenCount))
          {
            drawBitmap(localCanvas, localPaint, paramInt);
            i = paramInt + 1;
            paramInt = i;
            if (i < this.screenCount)
            {
              this.webView.scrollTo(0, getCurrentTop(i));
              paramInt = i;
            }
          }
          afterCaptureByScroll(localException);
        }
      }
      catch (Exception localException)
      {
        QMLog.log(6, "WebviewCaptureTask", localException.getMessage(), localException);
        afterCaptureByScroll(null);
        return;
      }
    }
  }
  
  public static void startNewTask(TitleBarWebView2 paramTitleBarWebView2, View paramView, ReadMailDetailView paramReadMailDetailView, String paramString, CallBack paramCallBack)
  {
    if ((paramTitleBarWebView2 == null) || (paramView == null) || (paramCallBack == null)) {
      return;
    }
    new WebviewCaptureTask(paramTitleBarWebView2, paramView, paramReadMailDetailView, paramString, paramCallBack).saveWebviewFullScreenImage();
  }
  
  private void zoomInAndScrollToInitialPosition()
  {
    if (isSupportZoomBy()) {
      this.webView.zoomBy(this.titleZoomFactor);
    }
    for (;;)
    {
      this.webView.scrollTo((int)this.initialScrollX, (int)this.initialScrollY);
      return;
      int i = zoomInByTimes(this.webView, this.zoomOutTimes);
      QMLog.log(4, "WebviewCaptureTask", "zoomOutTimes: " + this.zoomOutTimes + ", zoomInTimes:" + i);
    }
  }
  
  private static int zoomInByTimes(TitleBarWebView2 paramTitleBarWebView2, int paramInt)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((i >= paramInt) || (!paramTitleBarWebView2.zoomIn())) {
        return j;
      }
      j += 1;
      i += 1;
    }
  }
  
  private static int zoomOutToSmallest(TitleBarWebView2 paramTitleBarWebView2)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      if ((i >= 10) || (!paramTitleBarWebView2.zoomOut())) {
        return j;
      }
      j += 1;
      i += 1;
    }
  }
  
  public final void captureWholeWebView()
  {
    this.webView.setVerticalScrollBarEnabled(false);
    this.webView.setHorizontalScrollBarEnabled(false);
    if (this.detailView != null) {
      this.detailView.hideDetailButton();
    }
    int i = (int)(caculateZoomFactor() * QMUIKit.dpToPx(40));
    StringBuilder localStringBuilder;
    try
    {
      if (isCannotSupportSnapshot())
      {
        captureWholeWebViewByScroll(i);
        return;
      }
      captureWholeWebViewBySnapshot(i);
      return;
    }
    catch (Throwable localThrowable)
    {
      handleComplete(null);
      localStringBuilder = new StringBuilder().append("captureWholeWebView error:");
      if (localThrowable == null) {}
    }
    for (String str = localThrowable.toString();; str = "")
    {
      QMLog.log(6, "WebviewCaptureTask", str, localThrowable);
      return;
    }
  }
  
  public void captureWholeWebViewBySnapshot(int paramInt)
  {
    if (!Threads.isOnMainThread()) {}
    int j = (int)(this.webView.getContentHeight() * this.webView.getScale());
    int k = this.webView.getTitleHeightCompat();
    int m = this.webView.getContentWidth();
    float f1 = m / this.title.getWidth();
    float f2 = getWidthExceedMaxZoomFactor(m);
    i = 1;
    localObject1 = null;
    for (;;)
    {
      localObject4 = localObject1;
      float f3;
      Object localObject5;
      if (i < 2)
      {
        f3 = f2 / i;
        if (f1 <= 1.0F) {
          break label309;
        }
        localObject4 = localObject1;
        localObject5 = localObject1;
      }
      for (;;)
      {
        try
        {
          n = (int)(this.title.getHeight() * f1);
          localObject4 = localObject1;
          localObject5 = localObject1;
          localObject1 = Bitmap.createBitmap((int)(m * f3), (int)((n + j + paramInt) * f3), Bitmap.Config.ARGB_8888);
          localObject4 = localObject1;
          localObject5 = localObject1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          int n;
          Canvas localCanvas;
          Object localObject2;
          localObject3 = localObject4;
          continue;
        }
        catch (Exception localException1)
        {
          label309:
          Object localObject3 = localException2;
          continue;
        }
        try
        {
          localCanvas = new Canvas((Bitmap)localObject1);
          localObject4 = localObject1;
          localObject5 = localObject1;
          localCanvas.save();
          localObject4 = localObject1;
          localObject5 = localObject1;
          localCanvas.scale(f3, f3);
          localObject4 = localObject1;
          localObject5 = localObject1;
          localCanvas.save();
          localObject4 = localObject1;
          localObject5 = localObject1;
          localCanvas.translate(0.0F, n - k);
          localObject4 = localObject1;
          localObject5 = localObject1;
          this.webView.draw(localCanvas);
          localObject4 = localObject1;
          localObject5 = localObject1;
          localCanvas.restore();
          localObject4 = localObject1;
          localObject5 = localObject1;
          localCanvas.scale(f1, f1);
          localObject4 = localObject1;
          localObject5 = localObject1;
          this.title.draw(localCanvas);
          if (localObject1 != null)
          {
            localObject4 = localObject1;
            handleComplete(localObject4);
            return;
            n = (int)(m * f3);
            int i1 = (int)((k + j + paramInt) * f3);
            localObject4 = localObject1;
            localObject5 = localObject1;
            localObject1 = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
            localObject4 = localObject1;
            localObject5 = localObject1;
            localCanvas = new Canvas((Bitmap)localObject1);
            localObject4 = localObject1;
            localObject5 = localObject1;
            localCanvas.scale(f3, f3);
            localObject4 = localObject1;
            localObject5 = localObject1;
            this.webView.draw(localCanvas);
          }
          else
          {
            localObject4 = localObject1;
            localObject5 = localObject1;
            QMLog.log(4, "WebviewCaptureTask", "captureWholeWebViewBySnapshot, retBmpmap is null, sample: " + i);
          }
        }
        catch (Exception localException2)
        {
          localObject1 = localObject4;
          localObject4 = localException2;
          if (!localObject4.getLocalizedMessage().contains("bitmap size exceeds 32bits")) {
            continue;
          }
          System.gc();
          continue;
          throw localObject4;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localObject2 = localException2;
          System.gc();
          QMLog.log(6, "WebviewCaptureTask", "captureWholeWebViewBySnapshot, OOE, sample: " + i);
        }
      }
      i += 1;
    }
  }
  
  public void clear()
  {
    this.webView = null;
    this.title = null;
    this.detailView = null;
    this.fileName = null;
    this.callBack = null;
  }
  
  public void saveWebviewFullScreenImage()
  {
    Threads.runOnMainThread(new WebviewCaptureTask.1(this));
  }
  
  public static abstract interface CallBack
  {
    public abstract void onError(String paramString);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.imageextention.WebviewCaptureTask
 * JD-Core Version:    0.7.0.1
 */