package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.popularize.view.PopularizeMailListItemView;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.HashMap;

class AggregateMailListFragment$31
  implements AdapterView.OnItemLongClickListener
{
  AggregateMailListFragment$31(AggregateMailListFragment paramAggregateMailListFragment, boolean[] paramArrayOfBoolean) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = false;
    this.val$hasLongClick[0] = true;
    int i = AggregateMailListFragment.access$1700(this.this$0).getHeaderViewsCount();
    paramInt -= i;
    boolean bool1;
    if (paramInt < AggregateMailListFragment.access$200(this.this$0).getPopularizedCount())
    {
      AggregateMailListFragment.access$4800(this.this$0, (PopularizeMailListItemView)((HorizontalScrollItemView)paramView).getContentView(), paramInt);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (AggregateMailListFragment.access$2400(this.this$0));
      if ((paramView instanceof MailListItemView)) {
        break;
      }
      bool1 = bool2;
    } while (!(paramView instanceof HorizontalScrollItemView));
    AggregateMailListFragment.access$4900(this.this$0);
    paramLong = AggregateMailListFragment.access$200(this.this$0).getItem(paramInt).getInformation().getId();
    AggregateMailListFragment.access$1600(this.this$0).put(Integer.valueOf(paramInt - AggregateMailListFragment.access$200(this.this$0).getPopularizedCount()), Long.valueOf(paramLong));
    AggregateMailListFragment.access$1700(this.this$0).setItemChecked(i + paramInt, true);
    AggregateMailListFragment.access$4200(this.this$0);
    AggregateMailListFragment.access$4300(this.this$0);
    AggregateMailListFragment.access$4400(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.31
 * JD-Core Version:    0.7.0.1
 */