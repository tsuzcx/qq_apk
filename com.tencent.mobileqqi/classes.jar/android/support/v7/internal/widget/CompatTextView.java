package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqqi.R.styleable;

public class CompatTextView
  extends TextView
{
  public CompatTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CompatTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CompatTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.r, paramInt, 0);
    boolean bool = paramAttributeSet.getBoolean(0, false);
    paramAttributeSet.recycle();
    if (bool) {
      setTransformationMethod(new CompatTextView.AllCapsTransformationMethod(paramContext));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.CompatTextView
 * JD-Core Version:    0.7.0.1
 */