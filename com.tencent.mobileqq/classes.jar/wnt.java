import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.qcall.QCallFacade;

class wnt
  implements Runnable
{
  wnt(wns paramwns) {}
  
  public void run()
  {
    SplashActivity localSplashActivity = this.a.a.a;
    if ((localSplashActivity == null) || (localSplashActivity.app == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = localSplashActivity.app;
    int i = 0;
    int j = QCallFacade.a(localQQAppInterface);
    QQMessageFacade localQQMessageFacade = localQQAppInterface.a();
    if (localQQMessageFacade != null)
    {
      ServiceAccountFolderManager.a().a(localQQAppInterface);
      i = localQQMessageFacade.b();
    }
    localSplashActivity.runOnUiThread(new wnu(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnt
 * JD-Core Version:    0.7.0.1
 */