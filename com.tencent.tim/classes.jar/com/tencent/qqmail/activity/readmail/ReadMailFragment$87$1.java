package com.tencent.qqmail.activity.readmail;

import android.content.res.Resources;
import com.tencent.qqmail.utilities.ui.QMBottomDialog;
import com.tencent.qqmail.utilities.ui.QMShareFileDialogHelper;
import com.tencent.qqmail.utilities.ui.QMTips;
import moai.fragment.app.FragmentActivity;

class ReadMailFragment$87$1
  implements Runnable
{
  ReadMailFragment$87$1(ReadMailFragment.87 param87, String paramString) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = this.this$1.this$0.getActivity();
    this.this$1.val$tips.dismissTipsManually();
    if (localFragmentActivity == null) {
      return;
    }
    new QMShareFileDialogHelper(localFragmentActivity, this.this$1.this$0.getResources().getString(2131696757), this.val$filePath, QMShareFileDialogHelper.SHARE_TYPE_IMG, QMShareFileDialogHelper.FROM_SHARE_MAIL_OR_NOTE_CONTENT).createDialog().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.87.1
 * JD-Core Version:    0.7.0.1
 */