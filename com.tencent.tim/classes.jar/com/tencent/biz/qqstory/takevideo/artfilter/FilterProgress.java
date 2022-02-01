package com.tencent.biz.qqstory.takevideo.artfilter;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProgressPieView;
import com.tencent.widget.ProgressPieView.c;

public class FilterProgress
  extends RelativeLayout
  implements ProgressPieView.c
{
  public ProgressPieView a;
  public Handler br;
  public Context context;
  
  public FilterProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public void btH()
  {
    if (this.a != null)
    {
      removeView(this.a);
      this.br.removeMessages(38);
      this.a = null;
      setVisibility(8);
    }
  }
  
  public void btJ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.record.FilterProgress", 2, "onProgressCompleted");
    }
    btH();
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2) {}
  
  public void setHandler(Handler paramHandler)
  {
    this.br = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.FilterProgress
 * JD-Core Version:    0.7.0.1
 */