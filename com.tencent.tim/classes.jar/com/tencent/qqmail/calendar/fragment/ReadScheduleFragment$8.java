package com.tencent.qqmail.calendar.fragment;

import android.view.View;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import moai.oss.KvHelper;

class ReadScheduleFragment$8
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadScheduleFragment$8(ReadScheduleFragment paramReadScheduleFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    if (paramInt == 0)
    {
      ReadScheduleFragment.access$1000(this.this$0);
      KvHelper.creditCardBillRemingdCancelOnce(new double[0]);
      return;
    }
    paramQMBottomDialog = QMMailManager.sharedInstance().getMailInfoByRemoteId(ReadScheduleFragment.access$100(this.this$0).getRelateAccountId(), ReadScheduleFragment.access$100(this.this$0).getRelatedId());
    QMMailManager.sharedInstance().setMailReminder(paramQMBottomDialog, "credit", 2, 0);
    ReadScheduleFragment.access$1100(this.this$0, ReadScheduleFragment.access$100(this.this$0), 0, ReadScheduleFragment.access$000(this.this$0));
    this.this$0.finish();
    KvHelper.creditCardBillRemingdCancelFromNowOn(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.ReadScheduleFragment.8
 * JD-Core Version:    0.7.0.1
 */