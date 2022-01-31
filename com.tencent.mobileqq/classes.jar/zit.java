import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class zit
  implements BusinessObserver
{
  public zit(RecommendTroopManagerImp paramRecommendTroopManagerImp, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.a.append(2, Boolean.valueOf(false));
    if (QLog.isColorLevel()) {
      QLog.d("RecommendTroopManagerImp", 2, "getRecommendTroopFromServer onReceive :" + paramBoolean);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label79;
      }
      RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp, 2, this.jdField_a_of_type_Long, paramBundle);
    }
    label79:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RecommendTroopManagerImp", 2, "getRecommendTroopFromServer success data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zit
 * JD-Core Version:    0.7.0.1
 */