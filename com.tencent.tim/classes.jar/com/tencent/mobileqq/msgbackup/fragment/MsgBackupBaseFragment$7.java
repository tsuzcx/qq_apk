package com.tencent.mobileqq.msgbackup.fragment;

import android.widget.TextView;

class MsgBackupBaseFragment$7
  implements Runnable
{
  MsgBackupBaseFragment$7(MsgBackupBaseFragment paramMsgBackupBaseFragment, TextView paramTextView, String paramString) {}
  
  public void run()
  {
    if (this.val$textView != null)
    {
      this.val$textView.setText(this.val$text);
      this.val$textView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupBaseFragment.7
 * JD-Core Version:    0.7.0.1
 */