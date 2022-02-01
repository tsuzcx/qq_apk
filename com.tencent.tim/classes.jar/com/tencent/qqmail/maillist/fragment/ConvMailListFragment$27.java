package com.tencent.qqmail.maillist.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.mail.cursor.IMailListCursor;
import com.tencent.qqmail.utilities.OneStepUtils;
import com.tencent.qqmail.utilities.ui.HorizontalScrollItemView;
import com.tencent.qqmail.utilities.ui.ItemScrollListView;
import java.util.HashMap;

class ConvMailListFragment$27
  implements AdapterView.OnItemLongClickListener
{
  ConvMailListFragment$27(ConvMailListFragment paramConvMailListFragment, boolean[] paramArrayOfBoolean) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool2 = true;
    this.val$hasLongClick[0] = true;
    boolean bool1;
    if ((ConvMailListFragment.access$2200(this.this$0)) || ((!(paramView instanceof MailListItemView)) && (!(paramView instanceof HorizontalScrollItemView)))) {
      bool1 = false;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          ConvMailListFragment.access$4500(this.this$0);
          int i = ConvMailListFragment.access$1600(this.this$0).getHeaderViewsCount();
          paramInt -= i;
          paramLong = ConvMailListFragment.access$500(this.this$0).getItemId(paramInt);
          ConvMailListFragment.access$1700(this.this$0).put(Integer.valueOf(paramInt), Long.valueOf(paramLong));
          ConvMailListFragment.access$1600(this.this$0).setItemChecked(i + paramInt, true);
          ConvMailListFragment.access$4000(this.this$0);
          ConvMailListFragment.access$4100(this.this$0);
          ConvMailListFragment.access$4200(this.this$0);
          bool1 = bool2;
        } while (!OneStepUtils.isOneStepShowing());
        bool1 = bool2;
      } while (paramInt < 0);
      bool1 = bool2;
    } while (ConvMailListFragment.access$500(this.this$0) == null);
    OneStepUtils.dragMailByOneStep(paramView, ConvMailListFragment.access$500(this.this$0).getItem(paramInt));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.fragment.ConvMailListFragment.27
 * JD-Core Version:    0.7.0.1
 */