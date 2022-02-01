package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import arin;
import atau.a;
import com.tencent.qphone.base.util.QLog;

public class RoundedImageView
  extends ImageView
{
  public static final Shader.TileMode a;
  private static final ImageView.ScaleType[] a;
  private boolean crh;
  private final float[] dL = { 0.0F, 0.0F, 0.0F, 0.0F };
  private boolean dbv;
  private boolean dbw;
  private int dlZ;
  private Drawable mBackgroundDrawable;
  private int mBackgroundResource;
  private ColorStateList mBorderColor = ColorStateList.valueOf(-16777216);
  private float mBorderWidth = 0.0F;
  private ColorFilter mColorFilter;
  private Drawable mDrawable;
  private boolean mHasColorFilter;
  private ImageView.ScaleType mScaleType;
  private Shader.TileMode mTileModeX = jdField_a_of_type_AndroidGraphicsShader$TileMode;
  private Shader.TileMode mTileModeY = jdField_a_of_type_AndroidGraphicsShader$TileMode;
  
  static
  {
    if (!RoundedImageView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      jdField_a_of_type_AndroidGraphicsShader$TileMode = Shader.TileMode.CLAMP;
      jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType = new ImageView.ScaleType[] { ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE };
      return;
    }
  }
  
  public RoundedImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rU, paramInt, 0);
    paramInt = paramContext.getInt(0, -1);
    float f;
    int i;
    if (paramInt >= 0)
    {
      setScaleType(jdField_a_of_type_ArrayOfAndroidWidgetImageView$ScaleType[paramInt]);
      f = paramContext.getDimensionPixelSize(3, -1);
      this.dL[0] = paramContext.getDimensionPixelSize(6, -1);
      this.dL[1] = paramContext.getDimensionPixelSize(7, -1);
      this.dL[2] = paramContext.getDimensionPixelSize(5, -1);
      this.dL[3] = paramContext.getDimensionPixelSize(4, -1);
      int j = this.dL.length;
      paramInt = 0;
      i = 0;
      label164:
      if (paramInt >= j) {
        break label211;
      }
      if (this.dL[paramInt] >= 0.0F) {
        break label205;
      }
      this.dL[paramInt] = 0.0F;
    }
    for (;;)
    {
      paramInt += 1;
      break label164;
      setScaleType(ImageView.ScaleType.FIT_CENTER);
      break;
      label205:
      i = 1;
    }
    label211:
    if (i == 0)
    {
      if (f >= 0.0F) {
        break label434;
      }
      f = 0.0F;
    }
    label434:
    for (;;)
    {
      i = this.dL.length;
      paramInt = 0;
      while (paramInt < i)
      {
        this.dL[paramInt] = f;
        paramInt += 1;
      }
      this.mBorderWidth = paramContext.getDimensionPixelSize(2, -1);
      if (this.mBorderWidth < 0.0F) {
        this.mBorderWidth = 0.0F;
      }
      this.mBorderColor = paramContext.getColorStateList(1);
      if (this.mBorderColor == null) {
        this.mBorderColor = ColorStateList.valueOf(-16777216);
      }
      this.dbw = paramContext.getBoolean(8, false);
      this.dbv = paramContext.getBoolean(9, false);
      paramInt = paramContext.getInt(10, -2);
      if (paramInt != -2)
      {
        setTileModeX(parseTileMode(paramInt));
        setTileModeY(parseTileMode(paramInt));
      }
      paramInt = paramContext.getInt(11, -2);
      if (paramInt != -2) {
        setTileModeX(parseTileMode(paramInt));
      }
      paramInt = paramContext.getInt(12, -2);
      if (paramInt != -2) {
        setTileModeY(parseTileMode(paramInt));
      }
      eiO();
      TP(true);
      if (this.dbw) {
        super.setBackgroundDrawable(this.mBackgroundDrawable);
      }
      paramContext.recycle();
      return;
    }
  }
  
  private void TP(boolean paramBoolean)
  {
    if (this.dbw)
    {
      if (paramBoolean) {
        this.mBackgroundDrawable = arin.E(this.mBackgroundDrawable);
      }
      a(this.mBackgroundDrawable, ImageView.ScaleType.FIT_XY);
    }
  }
  
  private void a(Drawable paramDrawable, ImageView.ScaleType paramScaleType)
  {
    if (paramDrawable == null) {}
    for (;;)
    {
      return;
      if ((paramDrawable instanceof arin))
      {
        ((arin)paramDrawable).a(paramScaleType).a(this.mBorderWidth).a(this.mBorderColor).a(this.dbv).a(this.mTileModeX).b(this.mTileModeY);
        if (this.dL != null) {
          ((arin)paramDrawable).a(this.dL[0], this.dL[1], this.dL[2], this.dL[3]);
        }
        dAu();
        return;
      }
      if ((paramDrawable instanceof LayerDrawable))
      {
        paramDrawable = (LayerDrawable)paramDrawable;
        int j = paramDrawable.getNumberOfLayers();
        int i = 0;
        while (i < j)
        {
          a(paramDrawable.getDrawable(i), paramScaleType);
          i += 1;
        }
      }
    }
  }
  
  private Drawable bc()
  {
    Object localObject3 = null;
    Resources localResources = getResources();
    if (localResources == null) {
      return null;
    }
    Object localObject1 = localObject3;
    if (this.dlZ != 0) {}
    try
    {
      localObject1 = localResources.getDrawable(this.dlZ);
      return arin.E((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("RoundedImageView", 1, "Unable to find resource: " + this.dlZ, localException);
        this.dlZ = 0;
        Object localObject2 = localObject3;
      }
    }
  }
  
  private Drawable bd()
  {
    Object localObject3 = null;
    Resources localResources = getResources();
    if (localResources == null) {
      return null;
    }
    Object localObject1 = localObject3;
    if (this.mBackgroundResource != 0) {}
    try
    {
      localObject1 = localResources.getDrawable(this.mBackgroundResource);
      return arin.E((Drawable)localObject1);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("RoundedImageView", 1, "Unable to find resource: " + this.mBackgroundResource, localException);
        this.mBackgroundResource = 0;
        Object localObject2 = localObject3;
      }
    }
  }
  
  private void dAu()
  {
    if ((this.mDrawable != null) && (this.crh))
    {
      this.mDrawable = this.mDrawable.mutate();
      if (this.mHasColorFilter) {
        this.mDrawable.setColorFilter(this.mColorFilter);
      }
    }
  }
  
  private void eiO()
  {
    a(this.mDrawable, this.mScaleType);
  }
  
  private static Shader.TileMode parseTileMode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return Shader.TileMode.CLAMP;
    case 1: 
      return Shader.TileMode.REPEAT;
    }
    return Shader.TileMode.MIRROR;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundDrawable = new ColorDrawable(paramInt);
    setBackgroundDrawable(this.mBackgroundDrawable);
  }
  
  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackgroundDrawable = paramDrawable;
    TP(true);
    super.setBackgroundDrawable(this.mBackgroundDrawable);
  }
  
  public void setBackgroundResource(@DrawableRes int paramInt)
  {
    if (this.mBackgroundResource != paramInt)
    {
      this.mBackgroundResource = paramInt;
      this.mBackgroundDrawable = bd();
      setBackgroundDrawable(this.mBackgroundDrawable);
    }
  }
  
  public void setBorderColor(@ColorInt int paramInt)
  {
    setBorderColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setBorderColor(ColorStateList paramColorStateList)
  {
    if (this.mBorderColor.equals(paramColorStateList)) {
      return;
    }
    if (paramColorStateList != null) {}
    for (;;)
    {
      this.mBorderColor = paramColorStateList;
      eiO();
      TP(false);
      if (this.mBorderWidth <= 0.0F) {
        break;
      }
      invalidate();
      return;
      paramColorStateList = ColorStateList.valueOf(-16777216);
    }
  }
  
  public void setBorderWidth(float paramFloat)
  {
    if (this.mBorderWidth == paramFloat) {
      return;
    }
    this.mBorderWidth = paramFloat;
    eiO();
    TP(false);
    invalidate();
  }
  
  public void setBorderWidth(int paramInt)
  {
    setBorderWidth(getResources().getDimension(paramInt));
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mColorFilter != paramColorFilter)
    {
      this.mColorFilter = paramColorFilter;
      this.mHasColorFilter = true;
      this.crh = true;
      dAu();
      invalidate();
    }
  }
  
  public void setCornerRadius(float paramFloat)
  {
    setCornerRadius(paramFloat, paramFloat, paramFloat, paramFloat);
  }
  
  public void setCornerRadius(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.dL[0] == paramFloat1) && (this.dL[1] == paramFloat2) && (this.dL[2] == paramFloat4) && (this.dL[3] == paramFloat3)) {
      return;
    }
    this.dL[0] = paramFloat1;
    this.dL[1] = paramFloat2;
    this.dL[3] = paramFloat3;
    this.dL[2] = paramFloat4;
    eiO();
    TP(false);
    invalidate();
  }
  
  public void setCornerRadius(int paramInt, float paramFloat)
  {
    if (this.dL[paramInt] == paramFloat) {
      return;
    }
    this.dL[paramInt] = paramFloat;
    eiO();
    TP(false);
    invalidate();
  }
  
  public void setCornerRadiusDimen(int paramInt)
  {
    float f = getResources().getDimension(paramInt);
    setCornerRadius(f, f, f, f);
  }
  
  public void setCornerRadiusDimen(int paramInt1, int paramInt2)
  {
    setCornerRadius(paramInt1, getResources().getDimensionPixelSize(paramInt2));
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.dlZ = 0;
    this.mDrawable = arin.a(paramBitmap);
    eiO();
    super.setImageDrawable(this.mDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.dlZ = 0;
    this.mDrawable = arin.E(paramDrawable);
    eiO();
    super.setImageDrawable(this.mDrawable);
  }
  
  public void setImageResource(@DrawableRes int paramInt)
  {
    if (this.dlZ != paramInt)
    {
      this.dlZ = paramInt;
      this.mDrawable = bc();
      eiO();
      super.setImageDrawable(this.mDrawable);
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    setImageDrawable(getDrawable());
  }
  
  public void setOval(boolean paramBoolean)
  {
    this.dbv = paramBoolean;
    eiO();
    TP(false);
    invalidate();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    assert (paramScaleType != null);
    if (this.mScaleType != paramScaleType)
    {
      this.mScaleType = paramScaleType;
      switch (arip.$SwitchMap$android$widget$ImageView$ScaleType[paramScaleType.ordinal()])
      {
      default: 
        super.setScaleType(paramScaleType);
      }
    }
    for (;;)
    {
      eiO();
      TP(false);
      invalidate();
      return;
      super.setScaleType(ImageView.ScaleType.FIT_XY);
    }
  }
  
  public void setTileModeX(Shader.TileMode paramTileMode)
  {
    if (this.mTileModeX == paramTileMode) {
      return;
    }
    this.mTileModeX = paramTileMode;
    eiO();
    TP(false);
    invalidate();
  }
  
  public void setTileModeY(Shader.TileMode paramTileMode)
  {
    if (this.mTileModeY == paramTileMode) {
      return;
    }
    this.mTileModeY = paramTileMode;
    eiO();
    TP(false);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedImageView
 * JD-Core Version:    0.7.0.1
 */