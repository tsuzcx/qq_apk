package com.tencent.qqmail.model;

import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISendDataCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;

class NoteManager$5
  implements QMCallback.ISendDataCallback
{
  NoteManager$5(NoteManager paramNoteManager, MailManagerDelegate paramMailManagerDelegate) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, Long paramLong1, Long paramLong2)
  {
    if (this.val$fn != null) {
      this.val$fn.handleSendData(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.5
 * JD-Core Version:    0.7.0.1
 */