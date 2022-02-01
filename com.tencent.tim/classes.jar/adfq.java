import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;
import com.tencent.qphone.base.util.QLog;

class adfq
  implements ServiceConnection
{
  adfq(adfp paramadfp) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.c.jdField_b_of_type_Adgj = adgj.a.a(paramIBinder);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_RemoteArConfigManager", 2, "onServiceConnected configManager=" + this.c.jdField_b_of_type_Adgj);
    }
    if (this.c.jdField_b_of_type_Adgj != null) {}
    try
    {
      this.c.jdField_b_of_type_Adgj.a(this.c.jdField_a_of_type_Adgn);
      this.c.jdField_b_of_type_Adgj.a(this.c.jdField_a_of_type_Adgk);
      this.c.jdField_b_of_type_Adgj.a(adfp.a(this.c));
      this.c.jdField_b_of_type_Adgj.a(this.c.jdField_a_of_type_Adgm);
      if (adfp.a(this.c) != -1) {
        this.c.jdField_b_of_type_Adgj.yd(adfp.a(this.c));
      }
      if (adfp.a(this.c) != null) {
        adfp.a(this.c).sendEmptyMessage(0);
      }
      if (this.c.bMF)
      {
        this.c.c = this.c.b();
        if ((this.c.c != null) && (adfp.a(this.c) != null))
        {
          paramComponentName = Message.obtain();
          paramComponentName.what = 1;
          paramComponentName.obj = this.c.c;
          adfp.a(this.c).sendMessage(paramComponentName);
        }
      }
      this.c.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig = this.c.b();
      if (this.c.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig == null) {
        this.c.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig = new ArEffectConfig();
      }
      if ((this.c.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig != null) && (adfp.a(this.c) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 2;
        paramComponentName.obj = this.c.jdField_b_of_type_ComTencentMobileqqArAidlArEffectConfig;
        adfp.a(this.c).sendMessage(paramComponentName);
      }
      this.c.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo = this.c.b();
      if ((this.c.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo != null) && (adfp.a(this.c) != null))
      {
        paramComponentName = Message.obtain();
        paramComponentName.what = 9;
        paramComponentName.obj = this.c.jdField_b_of_type_ComTencentMobileqqArAidlARCommonConfigInfo;
        adfp.a(this.c).sendMessage(paramComponentName);
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "registerArCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (this.c.jdField_b_of_type_Adgj != null) {}
    try
    {
      this.c.jdField_b_of_type_Adgj.b(this.c.jdField_a_of_type_Adgn);
      this.c.jdField_b_of_type_Adgj.b(this.c.jdField_a_of_type_Adgk);
      this.c.jdField_b_of_type_Adgj.b(adfp.a(this.c));
      this.c.jdField_b_of_type_Adgj.b(this.c.jdField_a_of_type_Adgm);
      this.c.jdField_b_of_type_Adgj = null;
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_RemoteArConfigManager", 2, "unregisterCallback: " + paramComponentName.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfq
 * JD-Core Version:    0.7.0.1
 */