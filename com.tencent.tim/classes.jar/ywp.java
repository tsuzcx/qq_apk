import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ywp
  implements BusinessObserver
{
  ywp(ywo paramywo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecommendTroopAdapter", 4, "delRecommendTroop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywp
 * JD-Core Version:    0.7.0.1
 */