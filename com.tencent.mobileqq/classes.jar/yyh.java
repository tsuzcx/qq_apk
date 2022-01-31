import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class yyh
  implements BusinessObserver
{
  protected void a(int paramInt, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (100 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QBossC2SCheckerServlet", 2, "Observer .onReceive Success: " + paramBoolean);
      }
      a(paramBundle.getInt("code"), paramBundle.getString("msg"), paramBundle.getString("adid"));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("QBossC2SCheckerServlet", 2, "ID__C2S_CHECKER NOT MATCH isSuc" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     yyh
 * JD-Core Version:    0.7.0.1
 */