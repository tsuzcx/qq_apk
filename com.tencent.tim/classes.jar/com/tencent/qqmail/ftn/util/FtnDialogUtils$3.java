package com.tencent.qqmail.ftn.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

final class FtnDialogUtils$3
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  FtnDialogUtils$3(String paramString1, View.OnClickListener paramOnClickListener1, String paramString2, View.OnClickListener paramOnClickListener2, String paramString3, View.OnClickListener paramOnClickListener3, String paramString4, View.OnClickListener paramOnClickListener4, String paramString5, View.OnClickListener paramOnClickListener5) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.val$lowTitle)) {
      this.val$lowTVListener.onClick(paramView);
    }
    do
    {
      return;
      if (paramString.equals(this.val$middleTitle))
      {
        this.val$middleTVListener.onClick(paramView);
        return;
      }
      if (paramString.equals(this.val$highTitle))
      {
        this.val$highTVListener.onClick(paramView);
        return;
      }
      if (paramString.equals(this.val$realTitle))
      {
        this.val$originTVListener.onClick(paramView);
        return;
      }
    } while (!paramString.equals(this.val$cancelTitle));
    this.val$cancelTVListener.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.util.FtnDialogUtils.3
 * JD-Core Version:    0.7.0.1
 */