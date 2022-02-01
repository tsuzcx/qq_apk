import android.os.RemoteException;
import com.tencent.mobileqq.theme.ThemeSwitcher.a;
import com.tencent.qphone.base.util.QLog;

class aogw
  extends ThemeSwitcher.a
{
  aogw(aogv paramaogv, aogi paramaogi) {}
  
  public boolean a(aogy paramaogy)
  {
    try
    {
      this.a.doSwitch(paramaogy.getThemeId(), paramaogy.AH());
      return true;
    }
    catch (RemoteException paramaogy)
    {
      QLog.e("ThemeIPCModule", 1, "beforeSwitch: ", paramaogy);
    }
    return true;
  }
  
  public void beginSwitch()
  {
    try
    {
      this.a.beginSwitch();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      QLog.e("ThemeIPCModule", 1, "beginSwitch: ", localRemoteException);
    }
  }
  
  public boolean bu(int paramInt)
  {
    try
    {
      this.a.postSwitch(paramInt);
      return super.bu(paramInt);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ThemeIPCModule", 1, "postSwitch: ", localRemoteException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogw
 * JD-Core Version:    0.7.0.1
 */