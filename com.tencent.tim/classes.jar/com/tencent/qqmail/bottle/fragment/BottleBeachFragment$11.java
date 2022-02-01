package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.bottle.fragment.adapter.BottleBeachWithAdvertiseAdapter;
import com.tencent.qqmail.bottle.model.BottleBeach;

class BottleBeachFragment$11
  implements AdapterView.OnItemLongClickListener
{
  BottleBeachFragment$11(BottleBeachFragment paramBottleBeachFragment) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = BottleBeachFragment.access$800(this.this$0).getItem((int)paramLong);
    if (paramAdapterView != null)
    {
      if (paramAdapterView.getType() == 32) {
        BottleBeachFragment.access$900(this.this$0, paramAdapterView);
      }
      for (;;)
      {
        return true;
        BottleBeachFragment.access$1000(this.this$0, paramAdapterView);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleBeachFragment.11
 * JD-Core Version:    0.7.0.1
 */