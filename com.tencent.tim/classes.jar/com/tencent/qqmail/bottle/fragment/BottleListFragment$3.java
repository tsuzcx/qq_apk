package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.bottle.controller.BottleListCursor;
import com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter;
import com.tencent.qqmail.bottle.model.BottleList;
import com.tencent.qqmail.maillist.ListViewHelper;
import java.util.ArrayList;
import java.util.List;

class BottleListFragment$3
  implements View.OnClickListener
{
  BottleListFragment$3(BottleListFragment paramBottleListFragment) {}
  
  public void onClick(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    BottleList localBottleList = new BottleList();
    if (BottleListFragment.access$100(this.this$0) != null)
    {
      BottleListCursor localBottleListCursor = BottleListFragment.access$100(this.this$0).getCursor();
      if (localBottleListCursor != null)
      {
        int i = 0;
        while (i < localBottleListCursor.getCount())
        {
          localBottleListCursor.getItem(i, localBottleList);
          if (localBottleList.getUnreadCnt() > 0) {
            localArrayList.add(Integer.valueOf(i));
          }
          i += 1;
        }
      }
    }
    ListViewHelper.getNextUnread(BottleListFragment.access$200(this.this$0), localArrayList, new BottleListFragment.3.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.3
 * JD-Core Version:    0.7.0.1
 */