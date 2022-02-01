package com.tencent.qqmail;

import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.utilities.observer.ICallBack;

class BaseActivityImpl$22
  implements ICallBack
{
  BaseActivityImpl$22(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void callback(Object paramObject)
  {
    QMMailManager.sharedInstance().syncAdRules(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.22
 * JD-Core Version:    0.7.0.1
 */