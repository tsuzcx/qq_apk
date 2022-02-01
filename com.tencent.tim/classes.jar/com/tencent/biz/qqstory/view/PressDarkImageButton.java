package com.tencent.biz.qqstory.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import aqcu;
import com.tencent.common.app.BaseApplicationImpl;

@TargetApi(14)
public class PressDarkImageButton
  extends ImageButton
{
  public static final int[] ATTRS = { 16843210, 16843211, 2131034556 };
  private boolean aJs;
  private boolean aJt = true;
  private Paint bg;
  private Bitmap cQ;
  private boolean mChecked;
  public int mHeight;
  public int mWidth;
  public float nR = 1.0F;
  public float nS = 0.5F;
  
  public PressDarkImageButton(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressDarkImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject1 = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.nR = ((TypedArray)localObject1).getFloat(0, this.nR);
    this.nS = ((TypedArray)localObject1).getFloat(1, this.nS);
    this.aJs = ((TypedArray)localObject1).getBoolean(2, false);
    ((TypedArray)localObject1).recycle();
    Object localObject2;
    if (this.aJs)
    {
      localObject2 = null;
      localObject1 = null;
    }
    try
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842996, 16842997 });
      localObject1 = paramContext;
      localObject2 = paramContext;
      this.mWidth = paramContext.getDimensionPixelSize(0, 0);
      localObject1 = paramContext;
      localObject2 = paramContext;
      this.mHeight = paramContext.getDimensionPixelSize(1, 0);
      localObject1 = paramContext;
      localObject2 = paramContext;
      if (this.cQ == null)
      {
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (BaseApplicationImpl.sImageCache != null)
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          this.cQ = ((Bitmap)BaseApplicationImpl.sImageCache.get("IMAGE_CACHE_KEY"));
        }
        localObject1 = paramContext;
        localObject2 = paramContext;
        if (this.cQ == null)
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          this.cQ = aqcu.f(BaseApplicationImpl.getApplication().getResources(), 2130847360);
          localObject1 = paramContext;
          localObject2 = paramContext;
          if (this.cQ != null)
          {
            localObject1 = paramContext;
            localObject2 = paramContext;
            if (BaseApplicationImpl.sImageCache != null)
            {
              localObject1 = paramContext;
              localObject2 = paramContext;
              BaseApplicationImpl.sImageCache.put("IMAGE_CACHE_KEY", this.cQ);
            }
          }
        }
      }
      if (paramContext != null) {
        paramContext.recycle();
      }
      return;
    }
    catch (Exception paramContext)
    {
      localObject2 = localObject1;
      paramContext.printStackTrace();
      return;
    }
    finally
    {
      if (localObject2 != null) {
        ((TypedArray)localObject2).recycle();
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Matrix localMatrix;
    if ((this.aJs) && (this.mChecked) && (this.mWidth != 0) && (this.mHeight != 0) && (this.cQ != null))
    {
      if (this.bg == null) {
        this.bg = new Paint();
      }
      float f = getResources().getDisplayMetrics().density / 2.0F;
      localMatrix = new Matrix();
      localMatrix.setScale(f, f);
      localMatrix.setTranslate(this.mWidth * 0.625F, this.mHeight * 0.2564103F);
      if (!isPressed()) {
        break label141;
      }
      this.bg.setAlpha((int)(this.nS * 255.0F));
    }
    for (;;)
    {
      paramCanvas.drawBitmap(this.cQ, localMatrix, this.bg);
      return;
      label141:
      this.bg.setAlpha((int)(this.nR * 255.0F));
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (!this.aJt) {
      return;
    }
    if (isPressed())
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        super.setImageAlpha((int)(this.nS * 255.0F));
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        super.setAlpha(this.nS);
        return;
      }
      super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.nR * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.nR);
      return;
    }
    super.clearColorFilter();
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.mChecked != paramBoolean)
    {
      this.mChecked = paramBoolean;
      invalidate();
    }
  }
  
  public void setEnableDark(boolean paramBoolean)
  {
    this.aJt = paramBoolean;
    if (!paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        super.setImageAlpha((int)(this.nR * 255.0F));
      }
    }
    else {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.nR);
      return;
    }
    super.clearColorFilter();
  }
  
  public void setInvalid()
  {
    this.aJt = false;
    super.setEnabled(false);
    super.setClickable(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.setImageAlpha((int)(this.nS * 255.0F));
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setAlpha(this.nS);
      return;
    }
    super.setColorFilter(-3355444, PorterDuff.Mode.MULTIPLY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PressDarkImageButton
 * JD-Core Version:    0.7.0.1
 */