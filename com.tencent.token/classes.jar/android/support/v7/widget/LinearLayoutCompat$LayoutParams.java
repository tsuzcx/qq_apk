package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class LinearLayoutCompat$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity = -1;
  public float weight;
  
  public LinearLayoutCompat$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.weight = 0.0F;
  }
  
  public LinearLayoutCompat$LayoutParams(int paramInt1, int paramInt2, float paramFloat)
  {
    super(paramInt1, paramInt2);
    this.weight = paramFloat;
  }
  
  public LinearLayoutCompat$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
    this.weight = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
    this.gravity = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
    paramContext.recycle();
  }
  
  public LinearLayoutCompat$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.weight = paramLayoutParams.weight;
    this.gravity = paramLayoutParams.gravity;
  }
  
  public LinearLayoutCompat$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public LinearLayoutCompat$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat.LayoutParams
 * JD-Core Version:    0.7.0.1
 */