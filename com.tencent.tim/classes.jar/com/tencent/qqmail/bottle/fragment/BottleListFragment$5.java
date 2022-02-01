package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.HashMap;

class BottleListFragment$5
  implements AdapterView.OnItemLongClickListener
{
  BottleListFragment$5(BottleListFragment paramBottleListFragment, boolean[] paramArrayOfBoolean) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (BottleListFragment.access$100(this.this$0) == null)
    {
      QMLog.log(6, "BottleListFragment", "mAdapter is null");
      return false;
    }
    this.val$hasLongClick[0] = true;
    BottleListFragment.access$900(this.this$0);
    paramAdapterView = BottleListFragment.access$100(this.this$0).getItem((int)paramLong);
    if (paramAdapterView == null) {}
    paramView = BottleListFragment.access$400(this.this$0);
    int i = (int)paramLong;
    if (paramAdapterView != null) {}
    for (paramAdapterView = paramAdapterView.getBottleId();; paramAdapterView = "")
    {
      paramView.put(Integer.valueOf(i), paramAdapterView);
      BottleListFragment.access$200(this.this$0).setItemChecked(paramInt, true);
      BottleListFragment.access$700(this.this$0);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.5
 * JD-Core Version:    0.7.0.1
 */