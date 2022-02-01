package com.tencent.qqmail.view.imageview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class QMGestureImageView
  extends ImageView
{
  public static final String GLOBAL_NS = "http://schemas.android.com/apk/res/android";
  public static final String LOCAL_NS = "http://schemas.polites.com/android";
  private int alpha = 255;
  private Animator animator;
  private float centerX;
  private float centerY;
  private ColorFilter colorFilter;
  private View.OnTouchListener customOnTouchListener;
  private int deviceOrientation = -1;
  private int displayHeight;
  private int displayWidth;
  private final Semaphore drawLock = new Semaphore(0);
  private Drawable drawable;
  private float factorHeight;
  private float factorWidth;
  private float fitScaleHorizontal = 1.0F;
  private float fitScaleVertical = 1.0F;
  private GestureImageViewListener gestureImageViewListener;
  private GestureImageViewTouchListener gestureImageViewTouchListener;
  private int hHeight;
  private int hWidth;
  private int imageOrientation;
  private boolean isImageSmall = false;
  public boolean isSmall = false;
  private boolean layout = false;
  private float maxScale = 5.0F;
  private float minScale = 0.75F;
  private boolean moveable = false;
  private View.OnClickListener onClickListener;
  private View.OnLongClickListener onLongClickListener;
  private float realH;
  private float realW;
  private boolean recycle = false;
  private int resId = -1;
  private int rotateAngel = 0;
  private float rotation = 0.0F;
  private float scale = 1.0F;
  private float scaleAdjust = 1.0F;
  private Float startX;
  private Float startY;
  public float startingScale = -1.0F;
  private boolean strict = false;
  private float x = 0.0F;
  private float y = 0.0F;
  
  public QMGestureImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMGestureImageView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.rotateAngel = paramInt;
    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    initImage();
  }
  
  public QMGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleType");
    if ((paramContext == null) || (paramContext.trim().length() == 0)) {
      setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
    paramContext = paramAttributeSet.getAttributeValue("http://schemas.polites.com/android", "start-x");
    String str = paramAttributeSet.getAttributeValue("http://schemas.polites.com/android", "start-y");
    if ((paramContext != null) && (paramContext.trim().length() > 0)) {
      this.startX = Float.valueOf(Float.parseFloat(paramContext));
    }
    if ((str != null) && (str.trim().length() > 0)) {
      this.startY = Float.valueOf(Float.parseFloat(str));
    }
    setStartingScale(paramAttributeSet.getAttributeFloatValue("http://schemas.polites.com/android", "start-scale", this.startingScale));
    setMinScale(paramAttributeSet.getAttributeFloatValue("http://schemas.polites.com/android", "min-scale", this.minScale));
    setMaxScale(paramAttributeSet.getAttributeFloatValue("http://schemas.polites.com/android", "max-scale", this.maxScale));
    setStrict(paramAttributeSet.getAttributeBooleanValue("http://schemas.polites.com/android", "strict", this.strict));
    setRecycle(paramAttributeSet.getAttributeBooleanValue("http://schemas.polites.com/android", "recycle", this.recycle));
    initImage();
  }
  
  public QMGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  public void animationStart(Animation paramAnimation)
  {
    if (this.animator != null) {
      this.animator.play(paramAnimation);
    }
  }
  
  public void animationStop()
  {
    if (this.animator != null) {
      this.animator.cancel();
    }
  }
  
  protected void computeCropScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.fitScaleHorizontal = (paramInt3 / paramInt1);
    this.fitScaleVertical = (paramInt4 / paramInt2);
  }
  
  protected void computeStartingScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    switch (QMGestureImageView.2.$SwitchMap$android$widget$ImageView$ScaleType[getScaleType().ordinal()])
    {
    default: 
      return;
    case 1: 
      this.startingScale = 2.0F;
      this.fitScaleHorizontal = 1.5F;
      this.fitScaleVertical = 1.5F;
      this.minScale = 0.5F;
      this.maxScale = 15.0F;
      this.isImageSmall = true;
      setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      return;
    case 2: 
      this.startingScale = Math.max(paramInt4 / paramInt2, paramInt3 / paramInt1);
      return;
    }
    if (isLandscape())
    {
      this.startingScale = this.fitScaleHorizontal;
      return;
    }
    this.startingScale = this.fitScaleVertical;
  }
  
  public float getCenterX()
  {
    return this.centerX;
  }
  
  public float getCenterY()
  {
    return this.centerY;
  }
  
  public int getDeviceOrientation()
  {
    return this.deviceOrientation;
  }
  
  public Drawable getDrawable()
  {
    return this.drawable;
  }
  
  public float getFactorHeight()
  {
    return this.factorHeight;
  }
  
  public float getFactorWidth()
  {
    return this.factorWidth;
  }
  
  public GestureImageViewListener getGestureImageViewListener()
  {
    return this.gestureImageViewListener;
  }
  
  public int getImageHeight()
  {
    if (this.drawable != null) {
      return this.drawable.getIntrinsicHeight();
    }
    return 0;
  }
  
  public Matrix getImageMatrix()
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
    return super.getImageMatrix();
  }
  
  public int getImageWidth()
  {
    if (this.drawable != null) {
      return this.drawable.getIntrinsicWidth();
    }
    return 0;
  }
  
  public float getImageX()
  {
    return this.x;
  }
  
  public float getImageY()
  {
    return this.y;
  }
  
  public boolean getMoveable()
  {
    return this.moveable;
  }
  
  public float getRealH()
  {
    return this.realH;
  }
  
  public float getRealW()
  {
    return this.realW;
  }
  
  public float getScale()
  {
    return this.scaleAdjust;
  }
  
  public int getScaledHeight()
  {
    return Math.round(getImageHeight() * getScale());
  }
  
  public int getScaledWidth()
  {
    return Math.round(getImageWidth() * getScale());
  }
  
  protected void initImage()
  {
    if (this.drawable != null)
    {
      this.drawable.setAlpha(this.alpha);
      this.drawable.setFilterBitmap(true);
      if (this.colorFilter != null) {
        this.drawable.setColorFilter(this.colorFilter);
      }
      this.layout = false;
      this.startingScale = -1.0F;
    }
    if (!this.layout)
    {
      requestLayout();
      reset();
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isImageSmall()
  {
    return this.isImageSmall;
  }
  
  public boolean isLandscape()
  {
    if (isImageSmall()) {
      if ((getImageWidth() > getImageHeight()) || (getImageWidth() * this.fitScaleVertical * this.factorWidth <= this.displayWidth)) {
        break label74;
      }
    }
    label74:
    while (getImageWidth() >= getImageHeight()) {
      do
      {
        return true;
      } while ((getImageWidth() <= getImageHeight()) && (getImageWidth() * this.fitScaleVertical > this.displayWidth));
    }
    return false;
  }
  
  public boolean isOrientationAligned()
  {
    boolean bool = true;
    if (this.deviceOrientation == 2) {
      bool = isLandscape();
    }
    while (this.deviceOrientation != 1) {
      return bool;
    }
    return isPortrait();
  }
  
  public boolean isPortrait()
  {
    return getImageWidth() <= getImageHeight();
  }
  
  public boolean isRecycle()
  {
    return this.recycle;
  }
  
  protected boolean isRecycled()
  {
    if ((this.drawable != null) && ((this.drawable instanceof BitmapDrawable)))
    {
      Bitmap localBitmap = ((BitmapDrawable)this.drawable).getBitmap();
      if (localBitmap != null) {
        return localBitmap.isRecycled();
      }
    }
    return false;
  }
  
  public boolean isStrict()
  {
    return this.strict;
  }
  
  public void moveBy(float paramFloat1, float paramFloat2)
  {
    this.x += paramFloat1;
    this.y += paramFloat2;
  }
  
  protected void onAttachedToWindow()
  {
    this.animator = new Animator(this, "GestureImageViewAnimator");
    this.animator.start();
    if ((this.resId >= 0) && (this.drawable == null)) {
      setImageResource(this.resId);
    }
    super.onAttachedToWindow();
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
    return super.onCreateDrawableState(paramInt);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.animator != null) {
      this.animator.finish();
    }
    if ((this.recycle) && (this.drawable != null) && (!isRecycled()))
    {
      recycle();
      this.drawable = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.layout) {
      if ((this.drawable != null) && (!isRecycled()))
      {
        paramCanvas.save();
        if ((this.realH != 0.0F) && (this.realW < this.displayWidth) && (this.realH < this.displayHeight) && (this.realW < 240.0F) && (this.realH < 320.0F)) {
          if (!isLandscape()) {
            break label195;
          }
        }
      }
    }
    label195:
    for (this.scale = (this.realW / getImageWidth() / this.fitScaleHorizontal);; this.scale = (this.realH / getImageHeight() / this.fitScaleVertical))
    {
      this.isSmall = true;
      float f = this.scale * this.scaleAdjust;
      paramCanvas.translate(this.x, this.y);
      if (this.rotation != 0.0F) {
        paramCanvas.rotate(this.rotation);
      }
      if (f != 1.0F) {
        paramCanvas.scale(f, f);
      }
      this.drawable.draw(paramCanvas);
      paramCanvas.restore();
      if (this.drawLock.availablePermits() <= 0) {
        this.drawLock.release();
      }
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) || (!this.layout)) {
      setupCanvas(this.displayWidth, this.displayHeight, getResources().getConfiguration().orientation);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.drawable != null) {
      if (getResources().getConfiguration().orientation == 2)
      {
        this.displayHeight = View.MeasureSpec.getSize(paramInt2);
        if (getLayoutParams().width == -2) {
          this.displayWidth = Math.round(getImageWidth() / getImageHeight() * this.displayHeight);
        }
      }
    }
    while (this.rotateAngel % 180 == 0)
    {
      setMeasuredDimension(this.displayWidth, this.displayHeight);
      return;
      this.displayWidth = View.MeasureSpec.getSize(paramInt1);
      continue;
      this.displayWidth = View.MeasureSpec.getSize(paramInt1);
      if (getLayoutParams().height == -2)
      {
        this.displayHeight = Math.round(getImageHeight() / getImageWidth() * this.displayWidth);
      }
      else
      {
        this.displayHeight = View.MeasureSpec.getSize(paramInt2);
        continue;
        this.displayHeight = View.MeasureSpec.getSize(paramInt2);
        this.displayWidth = View.MeasureSpec.getSize(paramInt1);
      }
    }
    setMeasuredDimension(this.displayHeight, this.displayWidth);
  }
  
  protected void recycle()
  {
    if ((this.recycle) && (this.drawable != null) && ((this.drawable instanceof BitmapDrawable)))
    {
      Bitmap localBitmap = ((BitmapDrawable)this.drawable).getBitmap();
      if (localBitmap != null) {
        localBitmap.recycle();
      }
    }
  }
  
  public void redraw()
  {
    postInvalidate();
  }
  
  public void reset()
  {
    this.x = this.centerX;
    this.y = this.centerY;
    this.scaleAdjust = this.startingScale;
    redraw();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
    super.setAdjustViewBounds(paramBoolean);
  }
  
  public void setAlpha(int paramInt)
  {
    this.alpha = paramInt;
    if (this.drawable != null) {
      this.drawable.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.colorFilter = paramColorFilter;
    if (this.drawable != null) {
      this.drawable.setColorFilter(paramColorFilter);
    }
  }
  
  public void setFactorHeight(float paramFloat)
  {
    this.factorHeight = paramFloat;
  }
  
  public void setFactorWidth(float paramFloat)
  {
    this.factorWidth = paramFloat;
  }
  
  public void setGestureImageViewListener(GestureImageViewListener paramGestureImageViewListener)
  {
    this.gestureImageViewListener = paramGestureImageViewListener;
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.drawable = new BitmapDrawable(getResources(), paramBitmap);
    initImage();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.drawable = paramDrawable;
    initImage();
  }
  
  public void setImageLevel(int paramInt)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
    super.setImageLevel(paramInt);
  }
  
  public void setImageMatrix(Matrix paramMatrix)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (this.drawable != null) {
      recycle();
    }
    if (paramInt >= 0)
    {
      this.resId = paramInt;
      setImageDrawable(getContext().getResources().getDrawable(paramInt));
    }
  }
  
  public void setImageState(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
  }
  
  /* Error */
  public void setImageURI(android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 519
    //   3: aload_1
    //   4: invokevirtual 524	android/net/Uri:getScheme	()Ljava/lang/String;
    //   7: invokevirtual 528	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10: ifeq +216 -> 226
    //   13: iconst_1
    //   14: anewarray 149	java/lang/String
    //   17: astore_2
    //   18: aload_2
    //   19: iconst_0
    //   20: ldc_w 529
    //   23: aastore
    //   24: aload_0
    //   25: invokevirtual 503	com/tencent/qqmail/view/imageview/QMGestureImageView:getContext	()Landroid/content/Context;
    //   28: invokevirtual 533	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_1
    //   32: aload_2
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: invokestatic 539	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +31 -> 72
    //   44: aload_3
    //   45: invokeinterface 544 1 0
    //   50: ifeq +22 -> 72
    //   53: aload_0
    //   54: aload_3
    //   55: aload_3
    //   56: aload_2
    //   57: iconst_0
    //   58: aaload
    //   59: invokeinterface 548 2 0
    //   64: invokeinterface 551 2 0
    //   69: putfield 553	com/tencent/qqmail/view/imageview/QMGestureImageView:imageOrientation	I
    //   72: aload_0
    //   73: invokevirtual 503	com/tencent/qqmail/view/imageview/QMGestureImageView:getContext	()Landroid/content/Context;
    //   76: invokevirtual 533	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   79: aload_1
    //   80: invokevirtual 559	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 565	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 553	com/tencent/qqmail/view/imageview/QMGestureImageView:imageOrientation	I
    //   93: ifeq +89 -> 182
    //   96: new 567	android/graphics/Matrix
    //   99: dup
    //   100: invokespecial 569	android/graphics/Matrix:<init>	()V
    //   103: astore 4
    //   105: aload 4
    //   107: aload_0
    //   108: getfield 553	com/tencent/qqmail/view/imageview/QMGestureImageView:imageOrientation	I
    //   111: i2f
    //   112: invokevirtual 573	android/graphics/Matrix:postRotate	(F)Z
    //   115: pop
    //   116: aload_1
    //   117: iconst_0
    //   118: iconst_0
    //   119: aload_1
    //   120: invokevirtual 576	android/graphics/Bitmap:getWidth	()I
    //   123: aload_1
    //   124: invokevirtual 579	android/graphics/Bitmap:getHeight	()I
    //   127: aload 4
    //   129: iconst_1
    //   130: invokestatic 583	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   133: astore 4
    //   135: aload_1
    //   136: invokevirtual 475	android/graphics/Bitmap:recycle	()V
    //   139: aload_0
    //   140: new 359	android/graphics/drawable/BitmapDrawable
    //   143: dup
    //   144: aload_0
    //   145: invokevirtual 436	com/tencent/qqmail/view/imageview/QMGestureImageView:getResources	()Landroid/content/res/Resources;
    //   148: aload 4
    //   150: invokespecial 493	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   153: invokevirtual 511	com/tencent/qqmail/view/imageview/QMGestureImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 588	java/io/InputStream:close	()V
    //   164: aload_3
    //   165: ifnull +9 -> 174
    //   168: aload_3
    //   169: invokeinterface 589 1 0
    //   174: aload_0
    //   175: getfield 272	com/tencent/qqmail/view/imageview/QMGestureImageView:drawable	Landroid/graphics/drawable/Drawable;
    //   178: ifnonnull +3 -> 181
    //   181: return
    //   182: aload_0
    //   183: new 359	android/graphics/drawable/BitmapDrawable
    //   186: dup
    //   187: aload_0
    //   188: invokevirtual 436	com/tencent/qqmail/view/imageview/QMGestureImageView:getResources	()Landroid/content/res/Resources;
    //   191: aload_1
    //   192: invokespecial 493	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   195: invokevirtual 511	com/tencent/qqmail/view/imageview/QMGestureImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   198: goto -42 -> 156
    //   201: astore_1
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 588	java/io/InputStream:close	()V
    //   210: aload_3
    //   211: ifnull +9 -> 220
    //   214: aload_3
    //   215: invokeinterface 589 1 0
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: goto -49 -> 174
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 592	android/net/Uri:toString	()Ljava/lang/String;
    //   231: invokestatic 596	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   234: invokevirtual 511	com/tencent/qqmail/view/imageview/QMGestureImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   237: goto -63 -> 174
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_2
    //   243: goto -41 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	QMGestureImageView
    //   0	246	1	paramUri	android.net.Uri
    //   17	226	2	localObject1	java.lang.Object
    //   39	176	3	localCursor	android.database.Cursor
    //   103	46	4	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   84	156	201	finally
    //   182	198	201	finally
    //   13	18	222	java/lang/Exception
    //   24	40	222	java/lang/Exception
    //   44	72	222	java/lang/Exception
    //   160	164	222	java/lang/Exception
    //   168	174	222	java/lang/Exception
    //   206	210	222	java/lang/Exception
    //   214	220	222	java/lang/Exception
    //   220	222	222	java/lang/Exception
    //   72	84	240	finally
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.maxScale = paramFloat;
    if (this.gestureImageViewTouchListener != null) {
      this.gestureImageViewTouchListener.setMaxScale(this.startingScale * paramFloat);
    }
  }
  
  public void setMinScale(float paramFloat)
  {
    this.minScale = paramFloat;
    if (this.gestureImageViewTouchListener != null) {
      this.gestureImageViewTouchListener.setMinScale(this.fitScaleHorizontal * paramFloat);
    }
  }
  
  public void setMoveable(boolean paramBoolean)
  {
    this.moveable = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
    if (this.gestureImageViewTouchListener != null) {
      this.gestureImageViewTouchListener.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.onLongClickListener = paramOnLongClickListener;
    if (this.gestureImageViewTouchListener != null) {
      this.gestureImageViewTouchListener.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.customOnTouchListener = paramOnTouchListener;
  }
  
  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public void setRealH(float paramFloat)
  {
    this.realH = paramFloat;
  }
  
  public void setRealW(float paramFloat)
  {
    this.realW = paramFloat;
  }
  
  public void setRecycle(boolean paramBoolean)
  {
    this.recycle = paramBoolean;
  }
  
  public void setRotation(float paramFloat)
  {
    this.rotation = paramFloat;
  }
  
  public void setScale(float paramFloat)
  {
    this.scaleAdjust = paramFloat;
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.CENTER) || (paramScaleType == ImageView.ScaleType.CENTER_CROP) || (paramScaleType == ImageView.ScaleType.CENTER_INSIDE)) {
      super.setScaleType(paramScaleType);
    }
    while (!this.strict) {
      return;
    }
    throw new UnsupportedOperationException("Not supported");
  }
  
  public void setSelected(boolean paramBoolean)
  {
    if (this.strict) {
      throw new UnsupportedOperationException("Not supported");
    }
    super.setSelected(paramBoolean);
  }
  
  public void setStartingPosition(float paramFloat1, float paramFloat2)
  {
    this.startX = Float.valueOf(paramFloat1);
    this.startY = Float.valueOf(paramFloat2);
  }
  
  public void setStartingScale(float paramFloat)
  {
    this.startingScale = paramFloat;
  }
  
  public void setStrict(boolean paramBoolean)
  {
    this.strict = paramBoolean;
  }
  
  protected void setupCanvas(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.deviceOrientation != paramInt3)
    {
      this.layout = false;
      this.deviceOrientation = paramInt3;
    }
    if ((this.drawable != null) && (!this.layout))
    {
      paramInt3 = getImageWidth();
      int i = getImageHeight();
      this.hWidth = Math.round(paramInt3 / 2.0F);
      this.hHeight = Math.round(i / 2.0F);
      paramInt1 -= getPaddingLeft() + getPaddingRight();
      paramInt2 -= getPaddingTop() + getPaddingBottom();
      computeCropScale(paramInt3, i, paramInt1, paramInt2);
      if (this.startingScale <= 0.0F) {
        computeStartingScale(paramInt3, i, paramInt1, paramInt2);
      }
      this.scaleAdjust = this.startingScale;
      this.centerX = (paramInt1 / 2.0F);
      this.centerY = (paramInt2 / 2.0F);
      if (this.startX != null) {
        break label327;
      }
      this.x = this.centerX;
      if (this.startY != null) {
        break label341;
      }
      this.y = this.centerY;
      label171:
      this.gestureImageViewTouchListener = new GestureImageViewTouchListener(this, paramInt1, paramInt2);
      if (!isLandscape()) {
        break label355;
      }
      this.gestureImageViewTouchListener.setMinScale(this.minScale * this.fitScaleHorizontal);
    }
    for (;;)
    {
      this.gestureImageViewTouchListener.setMaxScale(this.maxScale * this.startingScale);
      this.gestureImageViewTouchListener.setFitScaleHorizontal(this.fitScaleHorizontal);
      this.gestureImageViewTouchListener.setFitScaleVertical(this.fitScaleVertical);
      this.gestureImageViewTouchListener.setCanvasWidth(paramInt1);
      this.gestureImageViewTouchListener.setCanvasHeight(paramInt2);
      this.gestureImageViewTouchListener.setOnClickListener(this.onClickListener);
      this.gestureImageViewTouchListener.setOnLongClickListener(this.onLongClickListener);
      this.drawable.setBounds(-this.hWidth, -this.hHeight, this.hWidth, this.hHeight);
      super.setOnTouchListener(new QMGestureImageView.1(this));
      this.layout = true;
      return;
      label327:
      this.x = this.startX.floatValue();
      break;
      label341:
      this.y = this.startY.floatValue();
      break label171;
      label355:
      this.gestureImageViewTouchListener.setMinScale(this.minScale * this.fitScaleVertical);
    }
  }
  
  public boolean waitForDraw(long paramLong)
    throws InterruptedException
  {
    return this.drawLock.tryAcquire(paramLong, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.imageview.QMGestureImageView
 * JD-Core Version:    0.7.0.1
 */