package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqqi.R.styleable;

public class ActionBar$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity = -1;
  
  public ActionBar$LayoutParams(int paramInt)
  {
    this(-2, -1, paramInt);
  }
  
  public ActionBar$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.gravity = 19;
  }
  
  public ActionBar$LayoutParams(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2);
    this.gravity = paramInt3;
  }
  
  public ActionBar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.d);
    this.gravity = paramContext.getInt(0, -1);
    paramContext.recycle();
  }
  
  public ActionBar$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.gravity = paramLayoutParams.gravity;
  }
  
  public ActionBar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBar.LayoutParams
 * JD-Core Version:    0.7.0.1
 */