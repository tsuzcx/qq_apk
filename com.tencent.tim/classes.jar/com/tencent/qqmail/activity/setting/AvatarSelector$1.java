package com.tencent.qqmail.activity.setting;

import android.app.Activity;
import android.view.View;
import com.tencent.qqmail.BaseActivityImpl;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener;

class AvatarSelector$1
  implements QMBottomDialog.BottomListSheetBuilder.OnSheetItemClickListener
{
  AvatarSelector$1(AvatarSelector paramAvatarSelector) {}
  
  public void onClick(QMBottomDialog paramQMBottomDialog, View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(this.this$0.baseActivityImpl.getActivity().getString(2131691239)))
    {
      paramQMBottomDialog.dismiss();
      AvatarSelector.access$000(this.this$0);
    }
    do
    {
      return;
      if (paramString.equals(this.this$0.baseActivityImpl.getActivity().getString(2131690265)))
      {
        paramQMBottomDialog.dismiss();
        AvatarSelector.access$100(this.this$0);
        return;
      }
      if (paramString.equals(this.this$0.baseActivityImpl.getActivity().getString(2131719938)))
      {
        paramQMBottomDialog.dismiss();
        AvatarSelector.access$200(this.this$0);
        return;
      }
    } while (!paramString.equals(this.this$0.baseActivityImpl.getActivity().getString(2131690614)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.AvatarSelector.1
 * JD-Core Version:    0.7.0.1
 */