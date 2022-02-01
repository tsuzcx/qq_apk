package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import atau.a;

public class FitXImageView
  extends View
{
  private static final Matrix.ScaleToFit[] sS2FArray = { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
  private boolean bzJ;
  private boolean crh;
  private boolean cri;
  private boolean crj;
  private boolean crk;
  private int dlZ;
  private int dma = 256;
  private int[] lW;
  private boolean mAdjustViewBounds;
  private int mAlpha = 255;
  private Context mContext;
  private Matrix mDrawMatrix;
  private Drawable mDrawable;
  private int mDrawableHeight;
  private int mDrawableWidth;
  private int mLevel;
  private Matrix mMatrix;
  private int mMaxHeight = 2147483647;
  private int mMaxWidth = 2147483647;
  private final RectF mTempDst = new RectF();
  private final RectF mTempSrc = new RectF();
  private Uri mUri;
  
  public FitXImageView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    initImageView();
  }
  
  public FitXImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.mContext = paramContext;
    initImageView();
    getAttrs(paramContext, paramAttributeSet);
  }
  
  public FitXImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    initImageView();
    getAttrs(paramContext, paramAttributeSet);
  }
  
  private void configureBounds()
  {
    float f2 = 0.0F;
    if ((this.mDrawable == null) || (!this.bzJ)) {
      return;
    }
    int j = this.mDrawableWidth;
    int k = this.mDrawableHeight;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.mDrawMatrix = null;
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (i != 0)
    {
      this.mDrawMatrix = null;
      return;
    }
    this.mDrawMatrix = this.mMatrix;
    if (m * k / j < n)
    {
      this.mTempSrc.set(0.0F, 0.0F, j, k);
      this.mTempDst.set(0.0F, 0.0F, m, n);
      this.mDrawMatrix = this.mMatrix;
      this.mDrawMatrix.setRectToRect(this.mTempSrc, this.mTempDst, Matrix.ScaleToFit.CENTER);
      return;
    }
    this.mDrawMatrix = this.mMatrix;
    float f1;
    float f3;
    if (j * n > m * k)
    {
      f1 = n / k;
      f3 = (m - j * f1) * 0.5F;
    }
    for (;;)
    {
      this.mDrawMatrix.setScale(f1, f1);
      if (this.crk) {
        break;
      }
      this.mDrawMatrix.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
      return;
      f1 = m / j;
      f2 = n;
      float f4 = k;
      f3 = 0.0F;
      f2 = (f2 - f4 * f1) * 0.5F;
    }
  }
  
  private void dAu()
  {
    if ((this.mDrawable != null) && (this.crh))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setAlpha(this.mAlpha * this.dma >> 8);
    }
  }
  
  private void getAttrs(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sT);
    this.crk = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  private void initImageView()
  {
    this.mMatrix = new Matrix();
  }
  
  private int m(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    switch (i)
    {
    default: 
      return paramInt1;
    case 0: 
      return Math.min(paramInt1, paramInt2);
    case -2147483648: 
      return Math.min(Math.min(paramInt1, paramInt3), paramInt2);
    }
    return paramInt3;
  }
  
  private void resizeFromDrawable()
  {
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.mDrawableWidth;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.mDrawableHeight;
      }
      if ((i != this.mDrawableWidth) || (j != this.mDrawableHeight))
      {
        this.mDrawableWidth = i;
        this.mDrawableHeight = j;
        requestLayout();
      }
    }
  }
  
  /* Error */
  private void resolveUri()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 93	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mDrawable	Landroid/graphics/drawable/Drawable;
    //   6: ifnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: invokevirtual 217	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:getResources	()Landroid/content/res/Resources;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull -7 -> 9
    //   19: aload_0
    //   20: getfield 219	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:dlZ	I
    //   23: ifeq +58 -> 81
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 219	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:dlZ	I
    //   31: invokevirtual 225	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: aload_1
    //   39: invokespecial 229	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:updateDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   42: return
    //   43: astore_2
    //   44: ldc 231
    //   46: new 233	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   53: ldc 236
    //   55: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 219	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:dlZ	I
    //   62: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   65: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: aload_2
    //   69: invokestatic 253	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   72: pop
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   78: goto -41 -> 37
    //   81: aload_0
    //   82: getfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   85: ifnull -76 -> 9
    //   88: aload_0
    //   89: getfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   92: invokevirtual 260	android/net/Uri:getScheme	()Ljava/lang/String;
    //   95: astore_1
    //   96: ldc_w 262
    //   99: aload_1
    //   100: invokevirtual 268	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   103: ifne +13 -> 116
    //   106: ldc_w 270
    //   109: aload_1
    //   110: invokevirtual 268	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +168 -> 281
    //   116: aload_0
    //   117: getfield 79	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mContext	Landroid/content/Context;
    //   120: invokevirtual 274	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   123: aload_0
    //   124: getfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   127: invokevirtual 280	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   130: astore_2
    //   131: aload_2
    //   132: astore_1
    //   133: aload_2
    //   134: aconst_null
    //   135: invokestatic 284	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   138: astore_3
    //   139: aload_3
    //   140: astore_1
    //   141: aload_2
    //   142: ifnull +9 -> 151
    //   145: aload_2
    //   146: invokevirtual 289	java/io/InputStream:close	()V
    //   149: aload_3
    //   150: astore_1
    //   151: aload_1
    //   152: ifnonnull +37 -> 189
    //   155: getstatic 295	java/lang/System:out	Ljava/io/PrintStream;
    //   158: new 233	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 297
    //   168: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   175: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 306	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   189: goto -152 -> 37
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   197: aload_3
    //   198: astore_1
    //   199: goto -48 -> 151
    //   202: astore_3
    //   203: aconst_null
    //   204: astore_2
    //   205: aload_2
    //   206: astore_1
    //   207: ldc 231
    //   209: new 233	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 311
    //   219: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: getfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   226: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: aload_3
    //   233: invokestatic 253	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   236: pop
    //   237: aload_2
    //   238: ifnull +65 -> 303
    //   241: aload_2
    //   242: invokevirtual 289	java/io/InputStream:close	()V
    //   245: aconst_null
    //   246: astore_1
    //   247: goto -96 -> 151
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   255: aconst_null
    //   256: astore_1
    //   257: goto -106 -> 151
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_1
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 289	java/io/InputStream:close	()V
    //   271: aload_2
    //   272: athrow
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   278: goto -7 -> 271
    //   281: aload_0
    //   282: getfield 255	com/tencent/mobileqq/nearby/now/view/widget/FitXImageView:mUri	Landroid/net/Uri;
    //   285: invokevirtual 312	android/net/Uri:toString	()Ljava/lang/String;
    //   288: invokestatic 316	android/graphics/drawable/Drawable:createFromPath	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   291: astore_1
    //   292: goto -141 -> 151
    //   295: astore_2
    //   296: goto -33 -> 263
    //   299: astore_3
    //   300: goto -95 -> 205
    //   303: aconst_null
    //   304: astore_1
    //   305: goto -154 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	FitXImageView
    //   1	151	1	localObject1	java.lang.Object
    //   192	2	1	localIOException1	java.io.IOException
    //   198	49	1	localObject2	java.lang.Object
    //   250	2	1	localIOException2	java.io.IOException
    //   256	12	1	localObject3	java.lang.Object
    //   273	2	1	localIOException3	java.io.IOException
    //   291	14	1	localDrawable1	Drawable
    //   14	22	2	localObject4	java.lang.Object
    //   43	26	2	localException1	Exception
    //   130	112	2	localInputStream	java.io.InputStream
    //   260	12	2	localObject5	java.lang.Object
    //   295	1	2	localObject6	java.lang.Object
    //   138	60	3	localDrawable2	Drawable
    //   202	31	3	localException2	Exception
    //   299	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   26	35	43	java/lang/Exception
    //   145	149	192	java/io/IOException
    //   116	131	202	java/lang/Exception
    //   241	245	250	java/io/IOException
    //   116	131	260	finally
    //   267	271	273	java/io/IOException
    //   133	139	295	finally
    //   207	237	295	finally
    //   133	139	299	java/lang/Exception
  }
  
  private void updateDrawable(Drawable paramDrawable)
  {
    if (this.mDrawable != null)
    {
      this.mDrawable.setCallback(null);
      unscheduleDrawable(this.mDrawable);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      paramDrawable.setLevel(this.mLevel);
      this.mDrawableWidth = paramDrawable.getIntrinsicWidth();
      this.mDrawableHeight = paramDrawable.getIntrinsicHeight();
      dAu();
      configureBounds();
      return;
    }
    this.mDrawableHeight = -1;
    this.mDrawableWidth = -1;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDrawable)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.mDrawable != null) {
      this.mDrawable.jumpToCurrentState();
    }
  }
  
  public void layout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bzJ = true;
    configureBounds();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Drawable localDrawable;
    if (this.mDrawable != null)
    {
      localDrawable = this.mDrawable;
      if (getVisibility() != 0) {
        break label33;
      }
    }
    label33:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      return;
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    if (this.lW == null) {
      return super.onCreateDrawableState(paramInt);
    }
    if (!this.cri) {
      return this.lW;
    }
    return mergeDrawableStates(super.onCreateDrawableState(this.lW.length + paramInt), this.lW);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mDrawable != null) {
      this.mDrawable.setVisible(false, false);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.mDrawable == null) {}
    while ((this.mDrawableWidth == 0) || (this.mDrawableHeight == 0)) {
      return;
    }
    try
    {
      if ((this.mDrawMatrix == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
      {
        this.mDrawable.draw(paramCanvas);
        return;
      }
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.crj)
    {
      int j = getScrollX();
      int k = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
    }
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.mDrawMatrix != null) {
      paramCanvas.concat(this.mDrawMatrix);
    }
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    resolveUri();
    float f = 0.0F;
    int m = 0;
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int k;
    int i;
    int j;
    if (this.mDrawable == null)
    {
      this.mDrawableWidth = -1;
      this.mDrawableHeight = -1;
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      int i2 = getPaddingLeft();
      int i3 = getPaddingRight();
      n = getPaddingTop();
      i1 = getPaddingBottom();
      if ((m != 0) || (i != 0))
      {
        paramInt1 = m(k + i2 + i3, this.mMaxWidth, paramInt1);
        paramInt2 = m(j + n + i1, this.mMaxHeight, paramInt2);
        if ((f == 0.0F) || (Math.abs((paramInt1 - i2 - i3) / (paramInt2 - n - i1) - f) <= 1.0E-007D)) {
          break label414;
        }
        if (m == 0) {
          break label408;
        }
        j = (int)((paramInt2 - n - i1) * f) + i2 + i3;
        if (j > paramInt1) {
          break label408;
        }
        k = 1;
        paramInt1 = j;
        j = k;
        label193:
        if ((j != 0) || (i == 0)) {
          break label397;
        }
        i = (int)((paramInt1 - i2 - i3) / f) + n + i1;
        if (i > paramInt2) {
          break label397;
        }
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        return;
        j = this.mDrawableWidth;
        k = this.mDrawableHeight;
        i = j;
        if (j <= 0) {
          i = 1;
        }
        j = k;
        if (k <= 0) {
          j = 1;
        }
        if (!this.mAdjustViewBounds) {
          break label425;
        }
        if (i1 != 1073741824)
        {
          m = 1;
          label294:
          if (n == 1073741824) {
            break label334;
          }
        }
        label334:
        for (k = 1;; k = 0)
        {
          f = i / j;
          n = k;
          k = i;
          i = n;
          break;
          m = 0;
          break label294;
        }
        i = Math.max(k + (i2 + i3), getSuggestedMinimumWidth());
        j = Math.max(j + (n + i1), getSuggestedMinimumHeight());
        i = resolveSizeAndState(i, paramInt1, 0);
        paramInt1 = resolveSizeAndState(j, paramInt2, 0);
        paramInt2 = i;
        continue;
        label397:
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        continue;
        label408:
        j = 0;
        break label193;
        label414:
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
      label425:
      n = 0;
      k = i;
      i = n;
    }
  }
  
  public void setAlpha(int paramInt)
  {
    paramInt &= 0xFF;
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      this.crh = true;
      dAu();
      invalidate();
    }
  }
  
  public void setCropToPadding(boolean paramBoolean)
  {
    if (this.crj != paramBoolean)
    {
      this.crj = paramBoolean;
      requestLayout();
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((this.mDrawable != paramDrawable) || (this.mDrawableWidth != paramDrawable.getIntrinsicWidth()) || (this.mDrawableHeight != paramDrawable.getIntrinsicHeight()))
    {
      this.dlZ = 0;
      this.mUri = null;
      int i = this.mDrawableWidth;
      int j = this.mDrawableHeight;
      updateDrawable(paramDrawable);
      if ((i != this.mDrawableWidth) || (j != this.mDrawableHeight)) {
        requestLayout();
      }
      invalidate();
    }
  }
  
  public void setImageLevel(int paramInt)
  {
    this.mLevel = paramInt;
    if (this.mDrawable != null)
    {
      this.mDrawable.setLevel(paramInt);
      resizeFromDrawable();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if ((this.mUri != null) || (this.dlZ != paramInt))
    {
      updateDrawable(null);
      this.dlZ = paramInt;
      this.mUri = null;
      resolveUri();
      requestLayout();
      invalidate();
    }
  }
  
  public void setImageState(int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.lW = paramArrayOfInt;
    this.cri = paramBoolean;
    if (this.mDrawable != null)
    {
      refreshDrawableState();
      resizeFromDrawable();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    if ((this.dlZ != 0) || ((this.mUri != paramUri) && ((paramUri == null) || (this.mUri == null) || (!paramUri.equals(this.mUri)))))
    {
      updateDrawable(null);
      this.dlZ = 0;
      this.mUri = paramUri;
      resolveUri();
      requestLayout();
      invalidate();
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.mMaxHeight = paramInt;
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    resizeFromDrawable();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Drawable localDrawable;
    if (this.mDrawable != null)
    {
      localDrawable = this.mDrawable;
      if (paramInt != 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.mDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.FitXImageView
 * JD-Core Version:    0.7.0.1
 */