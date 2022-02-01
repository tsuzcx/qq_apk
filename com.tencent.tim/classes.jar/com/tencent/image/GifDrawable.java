package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.io.File;
import java.io.IOException;

public class GifDrawable
  extends Drawable
  implements AnimationCallback
{
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private int mGifHeight;
  private GifState mGifState;
  private int mGifWidth;
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage)
  {
    this(paramAbstractGifImage, null);
  }
  
  public GifDrawable(AbstractGifImage paramAbstractGifImage, Resources paramResources)
  {
    this(new GifState(paramAbstractGifImage), paramResources);
    this.mGifState.mTargetDensity = this.mTargetDensity;
  }
  
  public GifDrawable(GifState paramGifState, Resources paramResources)
  {
    this.mGifState = paramGifState;
    paramGifState.mGif.attachDrawable(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramGifState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public GifDrawable(File paramFile, Resources paramResources)
    throws IOException
  {
    this(paramFile, paramResources, false);
  }
  
  public GifDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
    throws IOException
  {
    this(NativeGifFactory.getNativeGifObject(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mGifWidth = this.mGifState.mGif.getScaledWidth(this.mTargetDensity);
    this.mGifHeight = this.mGifState.mGif.getScaledHeight(this.mTargetDensity);
  }
  
  /* Error */
  public static boolean isGifFile(File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: ifnull +10 -> 13
    //   6: aload_0
    //   7: invokevirtual 107	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: iconst_0
    //   14: istore_2
    //   15: iload_2
    //   16: ireturn
    //   17: new 109	java/io/RandomAccessFile
    //   20: dup
    //   21: aload_0
    //   22: ldc 111
    //   24: invokespecial 114	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore_0
    //   28: iconst_3
    //   29: newarray byte
    //   31: astore_3
    //   32: aload_0
    //   33: aload_3
    //   34: invokevirtual 118	java/io/RandomAccessFile:read	([B)I
    //   37: pop
    //   38: aload_3
    //   39: iconst_0
    //   40: baload
    //   41: bipush 71
    //   43: if_icmpne +21 -> 64
    //   46: aload_3
    //   47: iconst_1
    //   48: baload
    //   49: bipush 73
    //   51: if_icmpne +13 -> 64
    //   54: aload_3
    //   55: iconst_2
    //   56: baload
    //   57: istore_1
    //   58: iload_1
    //   59: bipush 70
    //   61: if_icmpeq +13 -> 74
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: aload_0
    //   75: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   78: aload_0
    //   79: ifnull -64 -> 15
    //   82: aload_0
    //   83: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_0
    //   89: iconst_1
    //   90: ireturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 121	java/io/RandomAccessFile:close	()V
    //   115: aload_3
    //   116: athrow
    //   117: astore_0
    //   118: goto -46 -> 72
    //   121: astore_0
    //   122: goto -20 -> 102
    //   125: astore_0
    //   126: goto -11 -> 115
    //   129: astore_3
    //   130: goto -23 -> 107
    //   133: astore_3
    //   134: goto -40 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramFile	File
    //   57	5	1	i	int
    //   1	15	2	bool	boolean
    //   31	24	3	arrayOfByte	byte[]
    //   104	12	3	localObject1	Object
    //   129	1	3	localObject2	Object
    //   133	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   82	86	88	java/io/IOException
    //   17	28	91	java/lang/Exception
    //   17	28	104	finally
    //   68	72	117	java/io/IOException
    //   98	102	121	java/io/IOException
    //   111	115	125	java/io/IOException
    //   28	38	129	finally
    //   74	78	129	finally
    //   28	38	133	java/lang/Exception
    //   74	78	133	java/lang/Exception
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mGifState.mGravity, this.mGifWidth, this.mGifHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    if (((this.mGifState.mGif instanceof NativeGifImage)) && (this.mGifState.stickerPause))
    {
      ((NativeGifImage)this.mGifState.mGif).drawFirstFrame(paramCanvas, this.mDstRect, this.mGifState.mPaint);
      return;
    }
    this.mGifState.mGif.draw(paramCanvas, this.mDstRect, this.mGifState.mPaint, this.mUseAnimation);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mGifState;
  }
  
  public int getGravity()
  {
    return this.mGifState.mGravity;
  }
  
  public AbstractGifImage getImage()
  {
    return this.mGifState.mGif;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mGifHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mGifWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
  }
  
  public Drawable mutate()
  {
    this.mGifState = new GifState(this.mGifState);
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mGifState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mGifState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mGifState.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mGifState.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setGIFPlayOnceListener(OnGIFPlayOnceListener paramOnGIFPlayOnceListener)
  {
    if ((this.mGifState != null) && (this.mGifState.mGif != null)) {
      this.mGifState.mGif.setGIFPlayOnceListener(paramOnGIFPlayOnceListener);
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.mGifState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  static final class GifState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    AbstractGifImage mGif;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    boolean stickerPause = false;
    
    public GifState(AbstractGifImage paramAbstractGifImage)
    {
      this.mGif = paramAbstractGifImage;
    }
    
    public GifState(GifState paramGifState)
    {
      this.mGif = paramGifState.mGif;
      this.mChangingConfigurations = paramGifState.mChangingConfigurations;
      this.mGravity = paramGifState.mGravity;
      this.mTargetDensity = paramGifState.mTargetDensity;
      this.mPaint = new Paint(6);
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new GifDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new GifDrawable(this, paramResources);
    }
    
    public void setStickerPause(boolean paramBoolean)
    {
      this.stickerPause = paramBoolean;
    }
  }
  
  public static abstract interface OnGIFPlayOnceListener
  {
    public abstract void onPlayOnce();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.GifDrawable
 * JD-Core Version:    0.7.0.1
 */