package com.tencent.qqmail.activity.vipcontacts;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;

class VIPContactsIndexFragment$5
  implements AdapterView.OnItemLongClickListener
{
  VIPContactsIndexFragment$5(VIPContactsIndexFragment paramVIPContactsIndexFragment) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramInt -= VIPContactsIndexFragment.access$700(this.this$0).getHeaderViewsCount();
    if ((paramInt >= 0) && (paramInt < VIPContactsIndexFragment.access$600(this.this$0).getCount() - 2))
    {
      paramAdapterView = VIPContactsIndexFragment.access$600(this.this$0).getItem(paramInt);
      paramView = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
      paramView.setTitle(paramAdapterView.getNick());
      paramView.addItem(this.this$0.getString(2131695180));
      paramView.setOnSheetItemClickListener(new VIPContactsIndexFragment.5.1(this, paramAdapterView));
      paramView.build().show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsIndexFragment.5
 * JD-Core Version:    0.7.0.1
 */