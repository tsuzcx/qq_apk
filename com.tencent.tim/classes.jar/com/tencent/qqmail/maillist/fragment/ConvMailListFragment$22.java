package com.tencent.qqmail.maillist.fragment;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.qqmail.utilities.ui.QMListPopupWindow;
import java.util.List;

class ConvMailListFragment$22
  extends QMListPopupWindow
{
  ConvMailListFragment$22(ConvMailListFragment paramConvMailListFragment, Context paramContext, View paramView, ListAdapter paramListAdapter, List paramList)
  {
    super(paramContext, paramView, paramListAdapter);
  }
  
  public void onListItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (((String)this.val$menu.get(paramInt)).equals(this.this$0.getString(2131695664))) {
      ConvMailListFragment.access$2900(this.this$0);
    }
    do
    {
      return;
      if (((String)this.val$menu.get(paramInt)).equals(this.this$0.getString(2131695671)))
      {
        ConvMailListFragment.access$3500(this.this$0);
        return;
      }
      if (((String)this.val$menu.get(paramInt)).equals(this.this$0.getString(2131695668)))
      {
        ConvMailListFragment.access$3600(this.this$0);
        return;
      }
      if (((String)this.val$menu.get(paramInt)).equals(this.this$0.getString(2131695669)))
      {
        ConvMailListFragment.access$3700(this.this$0);
        return;
      }
      if (((String)this.val$menu.get(paramInt)).equals(this.this$0.getString(2131695672)))
      {
        ConvMailListFragment.access$3800(this.this$0);
        return;
      }
    } while (!((String)this.val$menu.get(paramInt)).equals(this.this$0.getString(2131720744)));
    ConvMailListFragment.access$3900(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.22
 * JD-Core Version:    0.7.0.1
 */