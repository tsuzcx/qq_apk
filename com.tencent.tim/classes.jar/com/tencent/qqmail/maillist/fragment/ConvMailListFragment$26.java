package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.maillist.adapter.QMMailListAdapter;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.HashMap;

class ConvMailListFragment$26
  implements AdapterView.OnItemClickListener
{
  ConvMailListFragment$26(ConvMailListFragment paramConvMailListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = ConvMailListFragment.access$1600(this.this$0).getHeaderViewsCount();
    paramInt -= i;
    if ((paramInt < 0) || (ConvMailListFragment.access$500(this.this$0) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (ConvMailListFragment.access$2200(this.this$0))
      {
        if (((paramView instanceof MailListItemView)) || ((paramView instanceof HorizontalScrollItemView)))
        {
          if (ConvMailListFragment.access$1700(this.this$0).containsKey(Integer.valueOf(paramInt))) {
            break label176;
          }
          long l = ConvMailListFragment.access$200(this.this$0).getItem(paramInt).getInformation().getId();
          ConvMailListFragment.access$1700(this.this$0).put(Integer.valueOf(paramInt), Long.valueOf(l));
          ConvMailListFragment.access$1600(this.this$0).setItemChecked(i + paramInt, true);
        }
        for (;;)
        {
          ConvMailListFragment.access$4000(this.this$0);
          ConvMailListFragment.access$4100(this.this$0);
          ConvMailListFragment.access$4200(this.this$0);
          ConvMailListFragment.access$4300(this.this$0, ConvMailListFragment.access$2400(this.this$0));
          break;
          label176:
          ConvMailListFragment.access$1700(this.this$0).remove(Integer.valueOf(paramInt));
          ConvMailListFragment.access$1600(this.this$0).setItemChecked(i + paramInt, false);
        }
      }
      if ((this.this$0.aggregateType & 0x800) > 0L)
      {
        DataCollector.logEvent("Event_Click_AD_Mail");
        QMLog.log(4, "ConvMailListFragment", "DATACOLLECTION_Event_CLICK_AD_MAIL");
      }
      Mail localMail = ConvMailListFragment.access$500(this.this$0).getItem(paramInt);
      ConvMailListFragment.access$4400(this.this$0, localMail);
      paramView.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.26
 * JD-Core Version:    0.7.0.1
 */