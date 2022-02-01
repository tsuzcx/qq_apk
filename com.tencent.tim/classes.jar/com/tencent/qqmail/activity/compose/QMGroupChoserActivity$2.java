package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class QMGroupChoserActivity$2
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  QMGroupChoserActivity$2(QMGroupChoserActivity paramQMGroupChoserActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog = AccountManager.shareInstance().getAccountList();
    QMGroupChoserActivity.access$402(this.this$0, paramQMBottomDialog.getAccountByEmail(paramString));
    QMGroupChoserActivity.access$500(this.this$0);
    QMGroupChoserActivity.access$600(this.this$0);
    if (QMGroupChoserActivity.access$700(this.this$0) != null) {
      QMGroupChoserActivity.access$700(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMGroupChoserActivity.2
 * JD-Core Version:    0.7.0.1
 */