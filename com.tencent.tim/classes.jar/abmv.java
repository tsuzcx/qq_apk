import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class abmv
  implements BusinessObserver
{
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    try
    {
      paramInt = paramBundle.getInt("extra_result_code");
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameUtil", 1, new Object[] { "[reportGameData] retCode=", Integer.valueOf(paramInt) });
      }
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.e("cmgame_process.CmGameUtil", 1, "[reportGameData] onReceive, exception=", paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmv
 * JD-Core Version:    0.7.0.1
 */