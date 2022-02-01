package com.tencent.qqmail.activity.readmail;

import android.view.View;
import android.widget.Toast;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import moai.oss.KvHelper;

class ReadMailFragment$82
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  ReadMailFragment$82(ReadMailFragment paramReadMailFragment) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    int i = 1;
    SharedPreferenceUtil.setCreditCardBillRemindDate(ReadMailFragment.access$000(this.this$0).getInformation().getRemoteId(), paramInt);
    paramQMBottomDialog.dismiss();
    if (!this.this$0.isAttachedToActivity())
    {
      QMLog.log(5, "ReadMailFragment", "showMarkMailPopup onListItemClick fragment not attach.");
      return;
    }
    ReadMailFragment.access$11302(this.this$0, -1);
    if (paramString.equals(this.this$0.getString(2131718748)))
    {
      KvHelper.creditCardBillRemingdNone(new double[0]);
      i = 0;
      paramInt = 0;
    }
    for (;;)
    {
      if (QMNetworkUtils.isNetworkConnected()) {
        break label267;
      }
      Toast.makeText(this.this$0.getActivity(), 2131695956, 0).show();
      return;
      if (paramString.equals(this.this$0.getString(2131718747)))
      {
        KvHelper.creditCardBillRemingdTheDay(new double[0]);
        paramInt = 0;
      }
      else if (paramString.equals(this.this$0.getString(2131718743)))
      {
        KvHelper.creditCardBillRemingdOneDay(new double[0]);
        paramInt = 1;
      }
      else if (paramString.equals(this.this$0.getString(2131718745)))
      {
        paramInt = 2;
        KvHelper.creditCardBillRemingdTwoDay(new double[0]);
      }
      else if (paramString.equals(this.this$0.getString(2131718744)))
      {
        paramInt = 3;
        KvHelper.creditCardBillRemingdThreeDay(new double[0]);
      }
      else if (paramString.equals(this.this$0.getString(2131718742)))
      {
        paramInt = 7;
        KvHelper.creditCardBillRemingdOneWeek(new double[0]);
      }
      else
      {
        if (!paramString.equals(this.this$0.getString(2131718746))) {
          break;
        }
        paramInt = 14;
      }
    }
    label267:
    QMMailManager.sharedInstance().setMailReminder(ReadMailFragment.access$000(this.this$0), "credit", paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.82
 * JD-Core Version:    0.7.0.1
 */