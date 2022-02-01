package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleListController;
import com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import com.tencent.qqmail.view.QMListItemView;
import java.util.HashMap;
import moai.fragment.base.BaseFragment;

class BottleListFragment$4
  implements AdapterView.OnItemClickListener
{
  BottleListFragment$4(BottleListFragment paramBottleListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    if (BottleListFragment.access$300(this.this$0)) {
      if (paramLong != 2147483647L) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      Object localObject;
      if (!BottleListFragment.access$400(this.this$0).containsKey(Integer.valueOf((int)paramLong)))
      {
        localObject = BottleListFragment.access$100(this.this$0).getItem((int)paramLong);
        BottleListFragment.access$400(this.this$0).put(Integer.valueOf((int)paramLong), ((BottleList)localObject).getBottleId());
        BottleListFragment.access$200(this.this$0).setItemChecked(paramInt, true);
        bool = true;
      }
      for (;;)
      {
        BottleListFragment.access$600(this.this$0, BottleListFragment.access$500(this.this$0));
        if ((paramView instanceof HorizontalScrollItemView))
        {
          localObject = ((HorizontalScrollItemView)paramView).getContentView();
          if ((localObject instanceof QMListItemView)) {
            ((QMListItemView)localObject).setChecked(bool);
          }
        }
        BottleListFragment.access$700(this.this$0);
        break;
        BottleListFragment.access$400(this.this$0).remove(Integer.valueOf((int)paramLong));
        BottleListFragment.access$200(this.this$0).setItemChecked(paramInt, false);
      }
      if (paramLong == 2147483647L)
      {
        BottleListFragment.access$100(this.this$0).setLoading(true, BottleListFragment.access$200(this.this$0));
        BottleListFragment.access$800(this.this$0).loadMore(BottleListFragment.access$100(this.this$0).getCursor());
      }
      else
      {
        localObject = BottleListFragment.access$100(this.this$0).getItem((int)paramLong);
        if (localObject != null)
        {
          localObject = new BottleConversationFragment((BottleList)localObject);
          this.this$0.startFragmentForResult((BaseFragment)localObject, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.4
 * JD-Core Version:    0.7.0.1
 */