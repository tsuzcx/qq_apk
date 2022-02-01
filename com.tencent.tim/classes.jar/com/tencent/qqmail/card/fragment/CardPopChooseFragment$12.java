package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;

class CardPopChooseFragment$12
  implements Runnable
{
  CardPopChooseFragment$12(CardPopChooseFragment paramCardPopChooseFragment, QMTaskManager paramQMTaskManager, QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    this.val$sendMailMgr.addToMainLoop(this.val$cardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.12
 * JD-Core Version:    0.7.0.1
 */