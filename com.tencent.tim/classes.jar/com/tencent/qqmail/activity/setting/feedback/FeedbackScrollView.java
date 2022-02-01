package com.tencent.qqmail.activity.setting.feedback;

import android.content.Context;
import android.widget.ScrollView;
import com.tencent.qqmail.utilities.ui.OnScrollCallback;

public class FeedbackScrollView
  extends ScrollView
{
  private OnScrollCallback onScrollCallback;
  
  public FeedbackScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.onScrollCallback != null) {
      this.onScrollCallback.onScroll(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnScrollCallback(OnScrollCallback paramOnScrollCallback)
  {
    this.onScrollCallback = paramOnScrollCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.FeedbackScrollView
 * JD-Core Version:    0.7.0.1
 */