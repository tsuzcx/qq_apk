package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class NumberIndicator
  extends TextView
{
  private int currentIndex;
  private int totalCount;
  
  public NumberIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public NumberIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NumberIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void updateText()
  {
    setText(this.currentIndex + " / " + this.totalCount);
  }
  
  public void setCurrentIndex(int paramInt)
  {
    if ((paramInt <= 0) || (paramInt > this.totalCount)) {
      throw new IllegalArgumentException("currentIndex not valid, out of range");
    }
    this.currentIndex = paramInt;
    updateText();
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt < this.currentIndex) {
      throw new IllegalArgumentException("totalCount not valid, totalCount < currentIndex");
    }
    this.totalCount = paramInt;
    updateText();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.NumberIndicator
 * JD-Core Version:    0.7.0.1
 */