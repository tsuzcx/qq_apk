package com.tencent.mobileqq.msgbackup.fragment;

import android.graphics.Bitmap;

class MsgBackupQRFragment$4
  implements Runnable
{
  MsgBackupQRFragment$4(MsgBackupQRFragment paramMsgBackupQRFragment, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.a(null);
    MsgBackupQRFragment.a(this.this$0, localBitmap);
    if (this.coi)
    {
      MsgBackupQRFragment.a(this.this$0);
      return;
    }
    MsgBackupQRFragment.a(this.this$0, this.coj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment.4
 * JD-Core Version:    0.7.0.1
 */