package com.tencent.mobileqq.activity.main;

import alkm;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import nyn;
import zju;
import zkt;

public class MainAssistObserver$8$1
  implements Runnable
{
  public MainAssistObserver$8$1(zkt paramzkt) {}
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.this$0.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = localSplashActivity.app;
    int i = 0;
    int j = alkm.X(localQQAppInterface);
    QQMessageFacade localQQMessageFacade = localQQAppInterface.b();
    if (localQQMessageFacade != null)
    {
      nyn.a().a(localQQAppInterface);
      i = localQQMessageFacade.bl();
    }
    localSplashActivity.runOnUiThread(new MainAssistObserver.8.1.1(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.8.1
 * JD-Core Version:    0.7.0.1
 */