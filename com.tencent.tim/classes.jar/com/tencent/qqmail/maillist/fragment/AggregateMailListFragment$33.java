package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import com.tencent.qqmail.animation.ListViewRemoveItemAnimator;
import com.tencent.qqmail.maillist.adapter.AggregateMailListAdapter;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.ui.ItemScrollListView.OnRightViewClickListener;
import java.util.Arrays;
import java.util.HashMap;

class AggregateMailListFragment$33
  implements ItemScrollListView.OnRightViewClickListener
{
  AggregateMailListFragment$33(AggregateMailListFragment paramAggregateMailListFragment) {}
  
  public void onRightViewClick(View paramView, int paramInt)
  {
    int i;
    if (paramView.getId() == 2131377335)
    {
      i = AggregateMailListFragment.access$200(this.this$0).getPopularizedCount();
      if (i <= paramInt) {
        break label59;
      }
      ListViewRemoveItemAnimator.animateRemoval(AggregateMailListFragment.access$1700(this.this$0), Arrays.asList(new Integer[] { Integer.valueOf(paramInt) }), new AggregateMailListFragment.33.1(this, paramInt));
    }
    label59:
    do
    {
      return;
      paramView = AggregateMailListFragment.access$500(this.this$0).getItem(paramInt - i);
    } while ((paramView == null) || (paramView.getInformation() == null));
    this.this$0.hasScollDeleteMail = true;
    AggregateMailListFragment.access$1600(this.this$0).put(Integer.valueOf(paramInt - i), Long.valueOf(paramView.getInformation().getId()));
    AggregateMailListFragment.access$5000(this.this$0, new AggregateMailListFragment.33.2(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.AggregateMailListFragment.33
 * JD-Core Version:    0.7.0.1
 */