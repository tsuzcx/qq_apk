package com.tencent.qqmail.view.fingerprint;

class FingerPrintDialog$2
  implements Runnable
{
  FingerPrintDialog$2(FingerPrintDialog paramFingerPrintDialog) {}
  
  public void run()
  {
    FingerPrintDialog.access$000(this.this$0).onAuthenticated();
    this.this$0.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.FingerPrintDialog.2
 * JD-Core Version:    0.7.0.1
 */