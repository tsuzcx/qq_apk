package cooperation.qqpim;

import android.os.Bundle;
import avli;
import avlj;
import avlk;
import avll;
import avlm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQPimGetTipsInfoIPC
{
  private static QQPimGetTipsInfoIPC jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC;
  private static int ewP = -1;
  private QIPCModule jdField_a_of_type_ComTencentMobileqqQipcQIPCModule = new avlk(this, avli.cLJ);
  QQPimPluginLoadRunnable.a jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a = new avlj(this);
  private QQPimPluginLoadRunnable jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable;
  public QQPimTipsInfo a;
  private long azD;
  private a b;
  private boolean dnm;
  private String hC;
  private String mAccount;
  
  public static QQPimGetTipsInfoIPC a()
  {
    if (jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC == null) {
        jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC = new QQPimGetTipsInfoIPC();
      }
      return jdField_a_of_type_CooperationQqpimQQPimGetTipsInfoIPC;
    }
    finally {}
  }
  
  private QQAppInterface getAppInterface()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, a parama, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.getContactTipsIpc()" + parama.hashCode());
    }
    ewP = 0;
    this.b = parama;
    this.mAccount = paramString1;
    this.hC = paramString2;
    try
    {
      if (!this.dnm)
      {
        QIPCServerHelper.getInstance().register(this.jdField_a_of_type_ComTencentMobileqqQipcQIPCModule);
        this.dnm = true;
      }
      cgp();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public void cgp()
  {
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null) {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.stop();
    }
    this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = new QQPimPluginLoadRunnable(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable$a);
    ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable, null, true);
  }
  
  public void clear()
  {
    this.b = null;
    if (this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable != null)
    {
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable.stop();
      this.jdField_a_of_type_CooperationQqpimQQPimPluginLoadRunnable = null;
    }
  }
  
  public void eAD()
  {
    if (QLog.isColorLevel()) {
      QLog.i(avli.TAG, 2, "QQPimGetTipsInfoIPC.noticeClickTipsIPC()");
    }
    ewP = 1;
    QQPimPluginProxyService.eQ(getAppInterface());
  }
  
  public class GetContactTipsRunnable
    implements Runnable
  {
    private String account;
    private String hK;
    
    public GetContactTipsRunnable(String paramString1, String paramString2)
    {
      this.account = paramString1;
      this.hK = paramString2;
    }
    
    public void run()
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putString(avli.cLR, this.account);
        localBundle.putString(avli.cLS, this.hK);
        QIPCServerHelper.getInstance().callClient(avli.PROCESS_NAME, avli.cLJ, avli.cLK, localBundle, new avll(this));
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public class NoticeClickTipsRunnable
    implements Runnable
  {
    private NoticeClickTipsRunnable() {}
    
    public void run()
    {
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt(avli.cLX, 3);
        QIPCServerHelper.getInstance().callClient(avli.PROCESS_NAME, avli.cLJ, avli.cLL, localBundle, new avlm(this));
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(QQPimTipsInfo paramQQPimTipsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqpim.QQPimGetTipsInfoIPC
 * JD-Core Version:    0.7.0.1
 */