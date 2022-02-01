package com.tencent.qqmail.activity.setting;

import android.util.SparseArray;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import moai.oss.KvHelper;

class MailContentCreditCardServiceActivity$1
  implements UITableView.ClickListener
{
  MailContentCreditCardServiceActivity$1(MailContentCreditCardServiceActivity paramMailContentCreditCardServiceActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    if (MailContentCreditCardServiceActivity.access$000(this.this$0).indexOfValue(paramUITableItemView) >= 0)
    {
      j = MailContentCreditCardServiceActivity.access$000(this.this$0).keyAt(MailContentCreditCardServiceActivity.access$000(this.this$0).indexOfValue(paramUITableItemView));
      if (!paramUITableItemView.isChecked())
      {
        bool1 = true;
        paramUITableItemView.setChecked(bool1);
        SharedPreferenceUtil.setCreditCardDialogAccept(j, paramUITableItemView.isChecked());
        bool1 = SharedPreferenceUtil.getCreditCardDialogShown(j);
        bool2 = paramUITableItemView.isChecked();
        localQMMailManager = QMMailManager.sharedInstance();
        if (!bool1) {
          break label125;
        }
        paramInt = 1;
        if (!bool2) {
          break label130;
        }
        i = 1;
        localQMMailManager.setMailReminderRequestState(true, j, paramInt, i);
        if (!paramUITableItemView.isChecked()) {
          break label135;
        }
        KvHelper.creditCardBillRemingdSettingOpen(new double[0]);
      }
    }
    label125:
    while (paramUITableItemView != MailContentCreditCardServiceActivity.access$100(this.this$0))
    {
      for (;;)
      {
        int j;
        boolean bool2;
        QMMailManager localQMMailManager;
        return;
        boolean bool1 = false;
        continue;
        paramInt = 0;
        continue;
        int i = 0;
      }
      KvHelper.creditCardBillRemingdSettingClose(new double[0]);
      return;
    }
    label130:
    label135:
    MailContentCreditCardServiceActivity.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.MailContentCreditCardServiceActivity.1
 * JD-Core Version:    0.7.0.1
 */