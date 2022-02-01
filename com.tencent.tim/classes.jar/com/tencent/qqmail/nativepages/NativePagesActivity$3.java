package com.tencent.qqmail.nativepages;

import android.view.View;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class NativePagesActivity$3
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  NativePagesActivity$3(NativePagesActivity paramNativePagesActivity) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    paramQMBottomDialog.dismiss();
    if (paramString.equals(this.this$0.getString(2131696181)))
    {
      NativePagesActivity.access$100(this.this$0);
      return;
    }
    NativePagesActivity.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.nativepages.NativePagesActivity.3
 * JD-Core Version:    0.7.0.1
 */