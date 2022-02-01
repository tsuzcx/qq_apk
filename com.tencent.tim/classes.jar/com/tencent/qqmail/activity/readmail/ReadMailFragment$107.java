package com.tencent.qqmail.activity.readmail;

import android.view.View;
import com.tencent.qqmail.model.qmdomain.MailGroupContact;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder;
import com.tencent.qqmail.view.ReadMailDetailInformationView.MailGroupContactClickListener;

class ReadMailFragment$107
  implements ReadMailDetailInformationView.MailGroupContactClickListener
{
  ReadMailFragment$107(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(View paramView, MailGroupContact paramMailGroupContact)
  {
    QMBottomDialog.BottomListSheetBuilder localBottomListSheetBuilder = new QMBottomDialog.BottomListSheetBuilder(this.this$0.getActivity());
    localBottomListSheetBuilder.setTitle(paramMailGroupContact.getName());
    localBottomListSheetBuilder.addItem(this.this$0.getString(2131691899));
    localBottomListSheetBuilder.setOnSheetItemClickListener(new ReadMailFragment.107.1(this, paramMailGroupContact));
    localBottomListSheetBuilder.setOnBottomDialogDismissListener(new ReadMailFragment.107.2(this, paramView));
    localBottomListSheetBuilder.build().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.107
 * JD-Core Version:    0.7.0.1
 */