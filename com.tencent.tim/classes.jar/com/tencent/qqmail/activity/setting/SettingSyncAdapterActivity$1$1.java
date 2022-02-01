package com.tencent.qqmail.activity.setting;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;

class SettingSyncAdapterActivity$1$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  SettingSyncAdapterActivity$1$1(SettingSyncAdapterActivity.1 param1, UITableItemView paramUITableItemView) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    long l = Long.valueOf(paramString).longValue();
    this.val$itemView.setDetail(String.valueOf(l));
    SettingSyncAdapterActivity.1.access$000(this.this$1, this.val$itemView, l);
    paramQMBottomDialog.dismiss();
    SettingSyncAdapterActivity.access$100(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingSyncAdapterActivity.1.1
 * JD-Core Version:    0.7.0.1
 */