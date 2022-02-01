package com.tencent.qqmail.model;

import android.util.Log;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback.ISuccessCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;

class NoteManager$13
  implements QMCallback.ISuccessCallback
{
  NoteManager$13(NoteManager paramNoteManager) {}
  
  public void run(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    this.this$0.parseAndSaveNewSeq(paramQMNetworkResponse);
    Log.e("alger", "succ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.NoteManager.13
 * JD-Core Version:    0.7.0.1
 */