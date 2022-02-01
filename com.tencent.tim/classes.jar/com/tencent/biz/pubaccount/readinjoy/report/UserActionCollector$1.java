package com.tencent.biz.pubaccount.readinjoy.report;

import android.content.res.Resources;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import meu;
import wja;

public class UserActionCollector$1
  implements Runnable
{
  public UserActionCollector$1(meu parammeu, int paramInt, AbsListView paramAbsListView) {}
  
  public void run()
  {
    for (int i = this.this$0.aQU;; i = j)
    {
      try
      {
        if (this.aQV != 0) {
          break label75;
        }
        j = this.b.getHeight();
        int k = ImmersiveUtils.getStatusBarHeight(this.b.getContext());
        int m = this.b.getResources().getDimensionPixelOffset(2131299219);
        i = j - k - m;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          label75:
          wja.a("UserActionCollector", "calculte height error !", localException);
        }
      }
      if (i > 0) {
        this.this$0.aQU = i;
      }
      this.this$0.aOU();
      return;
      j = this.b.getHeight();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.report.UserActionCollector.1
 * JD-Core Version:    0.7.0.1
 */