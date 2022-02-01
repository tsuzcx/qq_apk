package com.tencent.qqmail.model.mail;

import java.util.concurrent.Callable;

final class QMSettingManager$1
  implements Callable<Void>
{
  public Void call()
  {
    QMSettingManager.access$000().initData();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMSettingManager.1
 * JD-Core Version:    0.7.0.1
 */