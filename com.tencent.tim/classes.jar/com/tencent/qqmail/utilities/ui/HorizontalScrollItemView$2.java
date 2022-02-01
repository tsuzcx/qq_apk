package com.tencent.qqmail.utilities.ui;

import android.view.View;
import android.widget.TextView;

class HorizontalScrollItemView$2
  implements HorizontalScrollItemView.OnItemScrollListener
{
  HorizontalScrollItemView$2(HorizontalScrollItemView paramHorizontalScrollItemView, TextView[] paramArrayOfTextView) {}
  
  public void onExpandBegin(int paramInt)
  {
    HorizontalScrollItemView.access$300(this.this$0).onExpandBegin(paramInt);
  }
  
  public void onExpandEnd(int paramInt)
  {
    TextView[] arrayOfTextView = this.val$rightViews;
    int j = arrayOfTextView.length;
    int i = 0;
    while (i < j)
    {
      arrayOfTextView[i].setClickable(true);
      i += 1;
    }
    HorizontalScrollItemView.access$300(this.this$0).onExpandEnd(paramInt);
  }
  
  public void onFoldBegin(int paramInt)
  {
    HorizontalScrollItemView.access$300(this.this$0).onFoldBegin(paramInt);
  }
  
  public void onFoldEnd(int paramInt)
  {
    HorizontalScrollItemView.access$300(this.this$0).onFoldEnd(paramInt);
  }
  
  public void onScrollBegin(int paramInt)
  {
    TextView[] arrayOfTextView = this.val$rightViews;
    int j = arrayOfTextView.length;
    int i = 0;
    while (i < j)
    {
      arrayOfTextView[i].setClickable(false);
      i += 1;
    }
    HorizontalScrollItemView.access$300(this.this$0).onScrollBegin(paramInt);
  }
  
  public void onScrollEnd(int paramInt)
  {
    HorizontalScrollItemView.access$300(this.this$0).onScrollEnd(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.HorizontalScrollItemView.2
 * JD-Core Version:    0.7.0.1
 */