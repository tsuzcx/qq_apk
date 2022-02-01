package com.tencent.qqmail.bottle.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter;

class BottleConversationFragment$24
  implements AdapterView.OnItemLongClickListener
{
  BottleConversationFragment$24(BottleConversationFragment paramBottleConversationFragment) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramLong < 0L) {
      return false;
    }
    paramAdapterView = BottleConversationFragment.access$1600(this.this$0).getItem((int)paramLong);
    paramView.setSelected(true);
    if ((BottleConversationFragment.access$2000(this.this$0)) || (BottleConversationFragment.access$1100(this.this$0)))
    {
      BottleConversationFragment.access$2100(this.this$0, paramAdapterView, paramView);
      return true;
    }
    BottleConversationFragment.access$2200(this.this$0, paramAdapterView, paramInt, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.24
 * JD-Core Version:    0.7.0.1
 */