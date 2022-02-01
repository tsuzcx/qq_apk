package com.tencent.qqmail.inquirymail.fragment;

import android.view.View;
import com.tencent.qqmail.inquirymail.model.InquiryMail;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class InquiryMailListFragment$8$2
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  InquiryMailListFragment$8$2(InquiryMailListFragment.8 param8, InquiryMail paramInquiryMail) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    paramQMBottomDialog.setOnDismissListener(new InquiryMailListFragment.8.2.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.inquirymail.fragment.InquiryMailListFragment.8.2
 * JD-Core Version:    0.7.0.1
 */