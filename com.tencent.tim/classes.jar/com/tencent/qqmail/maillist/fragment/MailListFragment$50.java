package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.mail.QMMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.HashMap;

class MailListFragment$50
  implements AdapterView.OnItemLongClickListener
{
  MailListFragment$50(MailListFragment paramMailListFragment, boolean[] paramArrayOfBoolean) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.val$hasLongClick[0] = true;
    if ((MailListFragment.access$300(this.this$0)) || (MailListFragment.access$2100(this.this$0)) || ((!(paramView instanceof MailListItemView)) && (!(paramView instanceof HorizontalScrollItemView))))
    {
      if ((OneStepUtils.isOneStepShowing()) && (MailListFragment.access$300(this.this$0)) && (!MailListFragment.access$2100(this.this$0)) && (((paramView instanceof MailListItemView)) || ((paramView instanceof HorizontalScrollItemView))))
      {
        i = MailListFragment.access$000(this.this$0).getHeaderViewsCount();
        OneStepUtils.dragMailByOneStep(paramView, MailListFragment.access$200(this.this$0).getItem(paramInt - i));
      }
      return true;
    }
    int i = paramInt - MailListFragment.access$000(this.this$0).getHeaderViewsCount();
    paramAdapterView = MailListFragment.access$200(this.this$0).getItem(i);
    paramLong = MailListFragment.access$200(this.this$0).getItemId(i);
    MailListFragment.access$8300(this.this$0);
    MailListFragment.access$400(this.this$0).put(Integer.valueOf(i), Long.valueOf(paramLong));
    MailListFragment.access$000(this.this$0).setItemChecked(paramInt, true);
    MailListFragment.access$900(this.this$0, paramAdapterView.getStatus());
    MailListFragment.access$1800(this.this$0);
    MailListFragment.access$500(this.this$0, paramAdapterView);
    MailListFragment.access$600(this.this$0, paramAdapterView);
    MailListFragment.access$800(this.this$0, paramAdapterView);
    MailListFragment.access$700(this.this$0, paramAdapterView);
    MailListFragment.access$1600(this.this$0);
    MailListFragment.access$1700(this.this$0);
    MailListFragment.access$1500(this.this$0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.MailListFragment.50
 * JD-Core Version:    0.7.0.1
 */