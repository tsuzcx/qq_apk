import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class acko
  implements BusinessObserver
{
  acko(ackn paramackn, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.this$0.cj.append(2, Boolean.valueOf(false));
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "getRecommendTroopFromServer onReceive :" + paramBoolean);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label79;
      }
      ackn.a(this.this$0, 2, this.QP, paramBundle);
    }
    label79:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RecommendTroopManagerImp", 2, "getRecommendTroopFromServer success data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acko
 * JD-Core Version:    0.7.0.1
 */