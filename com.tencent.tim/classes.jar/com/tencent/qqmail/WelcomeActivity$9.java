package com.tencent.qqmail;

import com.tencent.qqmail.utilities.log.QMLog;
import rx.functions.Action1;

class WelcomeActivity$9
  implements Action1<Throwable>
{
  WelcomeActivity$9(WelcomeActivity paramWelcomeActivity) {}
  
  public void call(Throwable paramThrowable)
  {
    QMLog.log(4, "WelcomeActivity", "RxPermissions error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity.9
 * JD-Core Version:    0.7.0.1
 */