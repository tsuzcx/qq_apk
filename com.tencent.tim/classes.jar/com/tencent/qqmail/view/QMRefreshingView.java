package com.tencent.qqmail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView.LayoutParams;
import androidx.core.content.ContextCompat;
import com.tencent.qqmail.advertise.AdvertiseImageDecoder;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class QMRefreshingView
  extends View
{
  public static final int POPULATE_BMP_HEIGHT = 300;
  public static final int POPULATE_BMP_WIDTH = 700;
  public static final String TAG = "QMRefreshingView";
  public static final String TEST_WORDS = "下拉拯救大海雀";
  public static final String TEST_WORDS_2 = "松手拯救大海雀";
  private static final int dividerX_footer_img_to_footer_tx = 20;
  private static final int dividerY_body_to_footer = 10;
  private AdvertiseImageDecoder advertiseGifDecoder;
  public boolean advertiseMode = false;
  private float bmp_dst_height;
  private float bmp_dst_width;
  private int bodyBmpHeight = getContext().getResources().getDimensionPixelOffset(2131299307);
  private String[] bodyFramePathlist = new String[0];
  private Rect body_bmp_dst_rect = new Rect();
  private Rect body_bmp_src_rect = new Rect();
  private final int cicleRadius = (int)(5.5F * QMUIKit.DENSITY + 0.5F);
  private final List<Cicle> cicles;
  private int currentBodyFrame = 0;
  private int currentFooterFrame = 0;
  private int dropDownHeight;
  private Rect foot_bmp_dst_rect = new Rect();
  private Rect foot_bmp_src_rect = new Rect();
  private ValueAnimator footerAnimation;
  private Bitmap footerBmp;
  public Integer[] footerFramePrepareResList = { Integer.valueOf(2130842656), Integer.valueOf(2130842657), Integer.valueOf(2130842658), Integer.valueOf(2130842659), Integer.valueOf(2130842660), Integer.valueOf(2130842661), Integer.valueOf(2130842662), Integer.valueOf(2130842663), Integer.valueOf(2130842664), Integer.valueOf(2130842665), Integer.valueOf(2130842666), Integer.valueOf(2130842667), Integer.valueOf(2130842668), Integer.valueOf(2130842669), Integer.valueOf(2130842670), Integer.valueOf(2130842671), Integer.valueOf(2130842672), Integer.valueOf(2130842673), Integer.valueOf(2130842674) };
  public Integer[] footerFrameResList = { Integer.valueOf(2130842645), Integer.valueOf(2130842646), Integer.valueOf(2130842647), Integer.valueOf(2130842648), Integer.valueOf(2130842649), Integer.valueOf(2130842650), Integer.valueOf(2130842651), Integer.valueOf(2130842652), Integer.valueOf(2130842653), Integer.valueOf(2130842654), Integer.valueOf(2130842655) };
  private int footerImageSize = 60;
  private String hintPullDown;
  private String hintRefresh;
  private String hintWords = "下拉拯救大海雀";
  private boolean interruptFootAnim = false;
  private final int layoutHeight;
  private boolean pngOrGifMode = true;
  private Bitmap popularizeBmp;
  private int popularizeBmpHeight = 120;
  private int popularizeBmpWidth = 120;
  private float position = 0.0F;
  private final float ratio = 0.95F;
  private int refreshBarHeight = getContext().getResources().getDimensionPixelSize(2131299306);
  private final Animation rotateAnimation;
  private float rotateDegrees = 0.0F;
  private final int rotateRadius = QMUIKit.dpToPx(27);
  private boolean rotating = false;
  private Paint textPaint = new Paint();
  private float translateYVal = 0.0F;
  
  public QMRefreshingView(Context paramContext)
  {
    super(paramContext);
    setDrawingCacheEnabled(false);
    initStyle();
    this.layoutHeight = getResources().getDimensionPixelSize(2131299306);
    this.cicles = new ArrayList();
    int i = 0;
    while (i < 3)
    {
      this.cicles.add(new Cicle(new int[] { -846331, -6103265, -11776 }[(i % 3)], new float[] { 0.7F, 0.7F, 0.8F }[(i % 3)]));
      i += 1;
    }
    i = 0;
    while (i < 3)
    {
      this.cicles.add(this.cicles.get(i));
      i += 1;
    }
    this.rotateAnimation = new QMRefreshingView.1(this);
    this.rotateAnimation.setDuration(2000L);
    this.rotateAnimation.setInterpolator(new LinearInterpolator());
    this.rotateAnimation.setRepeatCount(-1);
    this.advertiseGifDecoder = AdvertiseImageDecoder.getInstance();
    this.body_bmp_dst_rect = new Rect();
    this.body_bmp_src_rect = new Rect();
    updateCurrentFooterPrepareBmp(0);
    this.textPaint.setColor(ContextCompat.getColor(getContext(), 2131167181));
    this.textPaint.setTextSize(QMUIKit.sp2px(getContext(), 13.0F));
    Log.i("QMRefreshingView", "refreshBarHeight = " + this.refreshBarHeight);
  }
  
  private void initStyle()
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, 0));
  }
  
  private void invalidateView()
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      invalidate();
      return;
    }
    postInvalidate();
  }
  
  public int getAdvertiseBmpHeight()
  {
    int i = 0;
    if (this.advertiseMode) {
      i = this.dropDownHeight - this.refreshBarHeight;
    }
    return i;
  }
  
  public boolean getAdvertiseMode()
  {
    return this.advertiseMode;
  }
  
  public void initFooterAnim()
  {
    this.footerAnimation = ValueAnimator.ofInt(new int[] { 0, this.footerFrameResList.length - 1 });
    this.footerAnimation.setDuration(800L);
    this.footerAnimation.addUpdateListener(new QMRefreshingView.2(this));
    this.footerAnimation.addListener(new QMRefreshingView.3(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    this.translateYVal = (this.layoutHeight / 2 + this.cicleRadius / 2 + getResources().getDimensionPixelSize(2131297032) * 1 / 5);
    float f1;
    label77:
    Cicle localCicle;
    float f2;
    float f3;
    if (this.position == 1.0F)
    {
      paramCanvas.translate(i / 2, this.translateYVal);
      localObject = this.cicles.iterator();
      f1 = this.rotateDegrees;
      if (!((Iterator)localObject).hasNext()) {
        break label381;
      }
      localCicle = (Cicle)((Iterator)localObject).next();
      localCicle.zIndex = (((float)Math.cos(f1) - 1.0F) / 2.0F);
      if (localCicle.zIndex > -0.46D)
      {
        localCicle.offset = ((float)Math.sin(f1) * this.rotateRadius);
        paramCanvas.save();
        paramCanvas.translate(localCicle.offset * (1.0F + 0.95F * localCicle.zIndex) * this.position, 0.0F);
        f2 = this.cicleRadius;
        f3 = localCicle.zIndex;
        i = localCicle.paint.getAlpha();
        if (localCicle.zIndex >= -0.4D) {
          break label350;
        }
        localCicle.paint.setAlpha(Math.max(0, (int)(i * (1.0D + 0.95F * localCicle.zIndex * 2.3D) * this.position)));
      }
    }
    for (;;)
    {
      paramCanvas.drawCircle(0.0F, 0.0F, f2 * (1.0F + 0.95F * f3), localCicle.paint);
      localCicle.paint.setAlpha(i);
      paramCanvas.restore();
      f1 = (float)(f1 + 6.283185307179586D / this.cicles.size());
      break label77;
      f2 = this.translateYVal * this.position;
      f1 = f2;
      if (f2 < this.cicleRadius) {
        f1 = f2 - (this.cicleRadius - f2);
      }
      paramCanvas.translate(i / 2, f1);
      break;
      label350:
      localCicle.paint.setAlpha((int)(i * (1.0F + 0.95F * localCicle.zIndex) * this.position));
    }
    label381:
    if (this.advertiseMode)
    {
      paramCanvas.translate(0.0F, -this.translateYVal);
      if ((this.popularizeBmp != null) && (this.footerBmp != null)) {}
    }
    else
    {
      return;
    }
    this.popularizeBmpWidth = this.popularizeBmp.getWidth();
    this.popularizeBmpHeight = this.popularizeBmp.getHeight();
    this.bmp_dst_height = this.bodyBmpHeight;
    this.bmp_dst_width = (this.popularizeBmpWidth / this.popularizeBmpHeight * this.bmp_dst_height);
    this.body_bmp_dst_rect.set((int)-this.bmp_dst_width / 2, this.refreshBarHeight + 2, (int)this.bmp_dst_width / 2, (int)(this.refreshBarHeight + this.bmp_dst_height));
    this.body_bmp_src_rect.set(0, 0, this.popularizeBmpWidth, this.popularizeBmpHeight);
    if (getHeight() >= this.refreshBarHeight) {
      paramCanvas.drawBitmap(this.popularizeBmp, this.body_bmp_src_rect, this.body_bmp_dst_rect, null);
    }
    paramCanvas.translate(0.0F, this.refreshBarHeight + this.bmp_dst_height + 10.0F);
    Object localObject = new Rect();
    this.textPaint.getTextBounds(this.hintWords, 0, this.hintWords.length(), (Rect)localObject);
    this.foot_bmp_src_rect.set(0, 0, this.footerBmp.getWidth(), this.footerBmp.getHeight());
    this.footerImageSize = ((int)(((Rect)localObject).height() * 1.5D));
    i = this.footerImageSize;
    i = -(((Rect)localObject).width() + i + 20) / 2;
    this.foot_bmp_dst_rect.set(i, 0, this.footerImageSize + i, this.footerImageSize);
    int j = (int)(this.refreshBarHeight + this.bmp_dst_height + 10.0F + 10.0F);
    int k = this.footerImageSize + j + 13;
    this.dropDownHeight = k;
    if ((getHeight() >= j) && (getHeight() < k))
    {
      updateCurrentFooterPrepareBmp((int)((getHeight() - j) / (k - j) * this.footerFramePrepareResList.length) - 1);
      updateHintWords(true);
      this.interruptFootAnim = true;
    }
    for (;;)
    {
      paramCanvas.drawText(this.hintWords, i + 20 + this.footerImageSize, this.footerImageSize / 2 - (this.textPaint.descent() + this.textPaint.ascent()) / 2.0F, this.textPaint);
      paramCanvas.drawBitmap(this.footerBmp, this.foot_bmp_src_rect, this.foot_bmp_dst_rect, null);
      return;
      if (getHeight() < j)
      {
        updateCurrentFooterPrepareBmp(0);
        this.interruptFootAnim = true;
      }
    }
  }
  
  public void playArrow()
  {
    this.interruptFootAnim = false;
    this.footerAnimation.start();
    updateHintWords(false);
  }
  
  public int pngOrGifMode()
  {
    Popularize localPopularize = AdvertiseManager.getInstance().getPullDownPopularize();
    if (localPopularize != null)
    {
      this.hintPullDown = localPopularize.getSubject();
      this.hintRefresh = localPopularize.getAbstracts();
      return localPopularize.getResourceType();
    }
    return -1;
  }
  
  public void rotate(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!this.rotating)
      {
        setVisibility(0);
        this.position = 1.0F;
        startAnimation(this.rotateAnimation);
        this.rotating = true;
      }
      return;
    }
    this.rotating = false;
    setVisibility(4);
    clearAnimation();
  }
  
  public void setAdvertiseMode(boolean paramBoolean)
  {
    QMLog.log(4, "QMRefreshingView", "setAdvertiseMode " + paramBoolean);
    this.advertiseMode = paramBoolean;
    this.currentBodyFrame = 0;
    if (!paramBoolean) {
      return;
    }
    if (pngOrGifMode() == 0) {}
    for (this.pngOrGifMode = true;; this.pngOrGifMode = false)
    {
      initFooterAnim();
      this.bodyFramePathlist = this.advertiseGifDecoder.getAllFrames();
      if ((this.bodyFramePathlist != null) && (this.bodyFramePathlist.length > 0)) {
        break label140;
      }
      QMLog.log(5, "QMRefreshingView", "setAdvertiseMode bodyFramePathlist.length = 0 or null" + this.bodyFramePathlist);
      this.advertiseMode = false;
      return;
      if (pngOrGifMode() != 1) {
        break;
      }
    }
    this.advertiseMode = false;
    return;
    label140:
    QMLog.log(5, "QMRefreshingView", "bodyFramePathlist " + Arrays.asList(this.bodyFramePathlist));
    try
    {
      updateCurrentBodyBmp(0);
      updateCurrentFooterPrepareBmp(0);
      this.popularizeBmpWidth = this.popularizeBmp.getWidth();
      this.popularizeBmpHeight = this.popularizeBmp.getHeight();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.advertiseMode = false;
    }
  }
  
  public void updateCurrentBodyBmp(int paramInt)
  {
    if ((this.bodyFramePathlist == null) || (paramInt < 0) || (paramInt >= this.bodyFramePathlist.length)) {}
    for (;;)
    {
      return;
      String str = FileUtil.getAdvertiseImgDir() + this.bodyFramePathlist[paramInt];
      QMLog.log(4, "QMRefreshingView", "updateCurrentBodyBmp position " + paramInt);
      try
      {
        this.popularizeBmp = ImageUtil.decodeSampledBitmapFromDisk(str, 700, 300);
        if (this.popularizeBmp == null)
        {
          QMLog.log(4, "QMRefreshingView", "updateCurrentBodyBmp fail, so use default bmp");
          this.popularizeBmp = ImageUtil.decodeSampledBitmapFromResource(getResources(), 2130840067, 700, 300);
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(4, "QMRefreshingView", "updateCurrentBodyBmp fail, so use default bmp");
        this.popularizeBmp = ImageUtil.decodeSampledBitmapFromResource(getResources(), 2130840067, 700, 300);
      }
    }
  }
  
  public void updateCurrentFooterBmp(int paramInt)
  {
    if ((this.footerFrameResList == null) || (paramInt < 0) || (paramInt >= this.footerFrameResList.length)) {}
    while (paramInt == this.currentFooterFrame) {
      return;
    }
    this.footerBmp = ImageUtil.decodeSampledBitmapFromResource(getResources(), this.footerFrameResList[paramInt].intValue(), this.footerImageSize, this.footerImageSize);
    this.currentFooterFrame = paramInt;
  }
  
  public void updateCurrentFooterPrepareBmp(int paramInt)
  {
    if ((this.footerFramePrepareResList == null) || (paramInt < 0) || (paramInt >= this.footerFramePrepareResList.length)) {}
    while ((paramInt == this.currentFooterFrame) && (this.footerBmp != null)) {
      return;
    }
    this.footerBmp = ImageUtil.decodeSampledBitmapFromResource(getResources(), this.footerFramePrepareResList[paramInt].intValue(), this.footerImageSize, this.footerImageSize);
    this.currentFooterFrame = paramInt;
  }
  
  public void updateHintWords(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      if (TextUtils.isEmpty(this.hintPullDown)) {
        str = "下拉拯救大海雀";
      }
    }
    for (;;)
    {
      this.hintWords = str;
      invalidateView();
      return;
      str = this.hintPullDown;
      continue;
      if (TextUtils.isEmpty(this.hintRefresh)) {
        str = "松手拯救大海雀";
      } else {
        str = this.hintRefresh;
      }
    }
  }
  
  public void updatePosition(float paramFloat)
  {
    this.position = Math.min(1.0F, paramFloat);
    this.rotateDegrees = 0.0F;
    invalidate();
  }
  
  class Cicle
  {
    public float offset;
    public Paint paint = new Paint();
    public float zIndex;
    
    public Cicle(int paramInt, float paramFloat)
    {
      this.paint.setAntiAlias(true);
      this.paint.setColor(paramInt);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setAlpha((int)(255.0F * paramFloat));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMRefreshingView
 * JD-Core Version:    0.7.0.1
 */