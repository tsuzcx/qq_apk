import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class adbr
{
  adgj jdField_a_of_type_Adgj = null;
  private adgo jdField_a_of_type_Adgo;
  AppInterface mApp;
  ServiceConnection mServiceConnection = null;
  
  void cPR()
  {
    if (this.jdField_a_of_type_Adgj != null) {
      try
      {
        this.jdField_a_of_type_Adgj.cQW();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(adca.TAG, 2, "downloadArSo Exception", localException);
        return;
      }
    }
    this.jdField_a_of_type_Adgo = new adbs(this);
    this.mServiceConnection = new adbt(this);
    Intent localIntent = new Intent(this.mApp.getApp(), ArConfigService.class);
    boolean bool = this.mApp.getApp().bindService(localIntent, this.mServiceConnection, 1);
    QLog.w(adca.TAG, 1, "bindServer, ret[" + bool + "]");
  }
  
  void clean()
  {
    try
    {
      if (this.jdField_a_of_type_Adgj != null)
      {
        if (this.jdField_a_of_type_Adgo != null)
        {
          this.jdField_a_of_type_Adgj.b(this.jdField_a_of_type_Adgo);
          this.jdField_a_of_type_Adgo = null;
        }
        if (this.mServiceConnection != null)
        {
          this.mApp.getApp().unbindService(this.mServiceConnection);
          this.mServiceConnection = null;
        }
        this.jdField_a_of_type_Adgj = null;
      }
      this.mApp = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(adca.TAG, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void k(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    if (!ArConfigService.h(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(adca.TAG, 1, "tryDownload, so未准备");
      }
      cPR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbr
 * JD-Core Version:    0.7.0.1
 */