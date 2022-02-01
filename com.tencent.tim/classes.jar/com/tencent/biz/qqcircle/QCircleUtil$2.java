package com.tencent.biz.qqcircle;

import avpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public final class QCircleUtil$2
  implements Runnable
{
  public void run()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {}
    while (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    avpw.s((QQAppInterface)localAppRuntime, "QCircle", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleUtil.2
 * JD-Core Version:    0.7.0.1
 */