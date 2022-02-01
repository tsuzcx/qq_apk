package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BottleListFragment$8
  implements View.OnClickListener
{
  BottleListFragment$8(BottleListFragment paramBottleListFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool1 = true;
    boolean bool2 = BottleListFragment.access$500(this.this$0);
    BottleListFragment localBottleListFragment;
    if (bool2)
    {
      BottleListFragment.access$1100(this.this$0, false);
      BottleListFragment.access$700(this.this$0);
      localBottleListFragment = this.this$0;
      if (bool2) {
        break label64;
      }
    }
    for (;;)
    {
      BottleListFragment.access$600(localBottleListFragment, bool1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      BottleListFragment.access$1100(this.this$0, true);
      break;
      label64:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.8
 * JD-Core Version:    0.7.0.1
 */