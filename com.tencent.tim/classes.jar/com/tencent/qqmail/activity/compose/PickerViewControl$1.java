package com.tencent.qqmail.activity.compose;

import android.view.View;
import com.tencent.qqmail.model.alias.AliasItem;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;
import java.util.List;

class PickerViewControl$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  PickerViewControl$1(PickerViewControl paramPickerViewControl) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    PickerViewControl.access$002(this.this$0, paramInt);
    paramView = (AliasItem)PickerViewControl.access$100(this.this$0).get(paramInt);
    PickerViewControl.access$202(this.this$0, paramView.getAlias());
    PickerViewControl.access$302(this.this$0, paramView.getAccountId());
    if (PickerViewControl.access$400(this.this$0) != null)
    {
      PickerViewControl.access$502(this.this$0, false);
      PickerViewControl.access$400(this.this$0).didSelectRow(this.this$0, paramInt);
    }
    paramQMBottomDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.PickerViewControl.1
 * JD-Core Version:    0.7.0.1
 */