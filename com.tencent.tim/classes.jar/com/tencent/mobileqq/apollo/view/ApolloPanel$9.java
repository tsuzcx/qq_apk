package com.tencent.mobileqq.apollo.view;

import acbg;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class ApolloPanel$9
  implements Runnable
{
  ApolloPanel$9(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.this$0.wW != null) && (this.this$0.a != null) && (this.this$0.b != null))
    {
      this.this$0.wW.clear();
      this.this$0.wW.addAll(this.xc);
      int i = ApolloPanel.cuh;
      this.this$0.a.notifyDataSetChanged();
      if ((ApolloPanel.cuh != i) && (ApolloPanel.b(this.this$0))) {
        ApolloPanel.cuh = i;
      }
      this.this$0.wX.clear();
      i = 0;
      int k;
      for (int j = 0; i < this.this$0.wW.size(); j = k)
      {
        k = j;
        if (this.this$0.wX != null)
        {
          k = j + ((acbg)this.this$0.wW.get(i)).Ad();
          this.this$0.wX.add(Integer.valueOf(k - 1));
        }
        i += 1;
      }
      this.this$0.b.setCurrentItem(ApolloPanel.cuh, false);
      this.this$0.Iw(ApolloPanel.cuh);
      if (this.this$0.r != null) {
        this.this$0.r.postDelayed(new ApolloPanel.9.1(this), 500L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.9
 * JD-Core Version:    0.7.0.1
 */