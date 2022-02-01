package com.tencent.qqmail.model.mail;

class QMSettingManager$3
  implements Runnable
{
  QMSettingManager$3(QMSettingManager paramQMSettingManager, int paramInt) {}
  
  public void run()
  {
    QMMailManager.sharedInstance().sync(this.val$newAccountId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingManager.3
 * JD-Core Version:    0.7.0.1
 */