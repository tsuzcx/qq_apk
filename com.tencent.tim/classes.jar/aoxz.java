import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public abstract class aoxz
  implements BusinessObserver
{
  protected abstract void gh(long paramLong);
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      String str = "success = [" + paramBoolean + "], [" + paramBundle + "]";
      QLog.i("GroupAppsObserver", 2, " onReceive: invoked. " + str);
    }
    if (!paramBoolean) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    gh(paramBundle.getLong("KEY_GROUP_UIN"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoxz
 * JD-Core Version:    0.7.0.1
 */