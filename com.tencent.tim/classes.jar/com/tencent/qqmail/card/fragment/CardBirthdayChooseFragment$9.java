package com.tencent.qqmail.card.fragment;

import com.tencent.qqmail.model.task.QMSendMailTask;
import com.tencent.qqmail.model.task.QMTaskManager;

class CardBirthdayChooseFragment$9
  implements Runnable
{
  CardBirthdayChooseFragment$9(CardBirthdayChooseFragment paramCardBirthdayChooseFragment, QMTaskManager paramQMTaskManager, QMSendMailTask paramQMSendMailTask) {}
  
  public void run()
  {
    this.val$sendMailMgr.addToMainLoop(this.val$cardTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseFragment.9
 * JD-Core Version:    0.7.0.1
 */