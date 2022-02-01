package com.tencent.qqmail.card.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;

class CardBirthdayChooseFragment$11
  implements AdapterView.OnItemClickListener
{
  CardBirthdayChooseFragment$11(CardBirthdayChooseFragment paramCardBirthdayChooseFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - CardBirthdayChooseFragment.access$1900(this.this$0).getHeaderViewsCount();
    if ((i >= 0) && (i < CardBirthdayChooseFragment.access$2000(this.this$0).getCount()) && (CardBirthdayChooseFragment.access$2000(this.this$0).getItem(i) != null)) {
      CardBirthdayChooseFragment.access$2000(this.this$0).togglerChecked(paramView, i);
    }
    if (CardBirthdayChooseFragment.access$2000(this.this$0).getSelectFriend().size() > 0) {
      CardBirthdayChooseFragment.access$2100(this.this$0).getButtonRight().setEnabled(true);
    }
    for (;;)
    {
      CardBirthdayChooseFragment.access$2200(this.this$0).setText(String.format(this.this$0.getString(2131691272), new Object[] { Integer.valueOf(CardBirthdayChooseFragment.access$2000(this.this$0).getSelectFriend().size()) }));
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      CardBirthdayChooseFragment.access$2100(this.this$0).getButtonRight().setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.11
 * JD-Core Version:    0.7.0.1
 */