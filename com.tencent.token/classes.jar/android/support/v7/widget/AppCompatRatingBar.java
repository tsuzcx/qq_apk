package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.appcompat.R.attr;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

public class AppCompatRatingBar
  extends RatingBar
{
  private final AppCompatProgressBarHelper mAppCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
  
  public AppCompatRatingBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.ratingBarStyle);
  }
  
  public AppCompatRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mAppCompatProgressBarHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = this.mAppCompatProgressBarHelper.getSampleTime();
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatRatingBar
 * JD-Core Version:    0.7.0.1
 */