package com.tencent.mobileqq.nearby.profilecard;

import akgm;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.BounceScrollView;

public class NearbyProfileEditTribePanel$20
  implements Runnable
{
  public NearbyProfileEditTribePanel$20(akgm paramakgm, View paramView1, View paramView2) {}
  
  public void run()
  {
    int i = this.val$bottom.getMeasuredHeight();
    int j = this.this$0.a.getScrollY();
    if ((this.Fl instanceof ViewGroup)) {}
    for (Object localObject = this.Fl;; localObject = this.Fl.getParent())
    {
      localObject = (View)localObject;
      if (localObject != null)
      {
        int k = ((View)localObject).getBottom();
        int m = this.this$0.a.getMeasuredHeight();
        this.this$0.a.smoothScrollBy(0, k + i - m - j);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.20
 * JD-Core Version:    0.7.0.1
 */