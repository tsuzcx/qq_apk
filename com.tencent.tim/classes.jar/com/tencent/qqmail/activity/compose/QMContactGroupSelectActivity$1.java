package com.tencent.qqmail.activity.compose;

import android.widget.TextView;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import java.util.List;

class QMContactGroupSelectActivity$1
  implements UITableView.ClickListener
{
  QMContactGroupSelectActivity$1(QMContactGroupSelectActivity paramQMContactGroupSelectActivity) {}
  
  public void onClick(int paramInt, UITableItemView paramUITableItemView)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if (!paramUITableItemView.isChecked())
    {
      bool = true;
      paramUITableItemView.setChecked(bool);
      localStringBuilder = new StringBuilder();
      if (!paramUITableItemView.isChecked()) {
        break label137;
      }
    }
    label137:
    for (String str = this.this$0.getString(2131720855);; str = "")
    {
      paramUITableItemView.setContentDescription(str + paramUITableItemView.getTitleView().getText());
      paramInt = QMContactGroupSelectActivity.access$000(this.this$0).get(paramInt - 1).getId();
      if (!QMContactGroupSelectActivity.access$100(this.this$0).contains(Integer.valueOf(paramInt))) {
        break label144;
      }
      QMContactGroupSelectActivity.access$100(this.this$0).remove(QMContactGroupSelectActivity.access$100(this.this$0).indexOf(Integer.valueOf(paramInt)));
      return;
      bool = false;
      break;
    }
    label144:
    QMContactGroupSelectActivity.access$100(this.this$0).add(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.QMContactGroupSelectActivity.1
 * JD-Core Version:    0.7.0.1
 */