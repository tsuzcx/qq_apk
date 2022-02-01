package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.popularize.view.PopularizeMailListItemView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.HashMap;

class AggregateMailListFragment$30
  implements AdapterView.OnItemClickListener
{
  AggregateMailListFragment$30(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = AggregateMailListFragment.access$1700(this.this$0).getHeaderViewsCount();
    paramInt -= i;
    int j = AggregateMailListFragment.access$200(this.this$0).getItemViewType(paramInt);
    if ((j == 2) && ((paramView instanceof HorizontalScrollItemView))) {
      AggregateMailListFragment.access$4100(this.this$0, (PopularizeMailListItemView)((HorizontalScrollItemView)paramView).getContentView(), paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if ((j != 3) && (paramInt >= 0) && (AggregateMailListFragment.access$500(this.this$0) != null))
      {
        if (AggregateMailListFragment.access$2400(this.this$0))
        {
          if (((paramView instanceof MailListItemView)) || ((paramView instanceof HorizontalScrollItemView)))
          {
            if (AggregateMailListFragment.access$1600(this.this$0).containsKey(Integer.valueOf(paramInt - AggregateMailListFragment.access$200(this.this$0).getPopularizedCount()))) {
              break label248;
            }
            long l = AggregateMailListFragment.access$200(this.this$0).getItem(paramInt).getInformation().getId();
            AggregateMailListFragment.access$1600(this.this$0).put(Integer.valueOf(paramInt - AggregateMailListFragment.access$200(this.this$0).getPopularizedCount()), Long.valueOf(l));
            AggregateMailListFragment.access$1700(this.this$0).setItemChecked(i + paramInt, true);
          }
          for (;;)
          {
            AggregateMailListFragment.access$4200(this.this$0);
            AggregateMailListFragment.access$4300(this.this$0);
            AggregateMailListFragment.access$4400(this.this$0);
            AggregateMailListFragment.access$4500(this.this$0, AggregateMailListFragment.access$2500(this.this$0));
            break;
            label248:
            AggregateMailListFragment.access$1600(this.this$0).remove(Integer.valueOf(paramInt - AggregateMailListFragment.access$200(this.this$0).getPopularizedCount()));
            AggregateMailListFragment.access$1700(this.this$0).setItemChecked(i + paramInt, false);
          }
        }
        if (AggregateMailListFragment.access$4600(this.this$0, paramView)) {
          DataCollector.logEvent("Event_Click_Effect_Admail");
        }
        if (Mail.isAdConv(AggregateMailListFragment.access$2200(this.this$0))) {
          DataCollector.logEvent("Event_Click_AD_Mail");
        }
        QMLog.log(4, "AdMailListFragment", "DATACOLLECTION_Event_CLICK_AD_MAIL");
        Mail localMail = AggregateMailListFragment.access$200(this.this$0).getItem(paramInt);
        AggregateMailListFragment.access$4700(this.this$0, localMail);
        paramView.setSelected(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.30
 * JD-Core Version:    0.7.0.1
 */