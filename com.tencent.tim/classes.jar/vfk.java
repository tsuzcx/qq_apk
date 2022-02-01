import android.os.Bundle;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Leba.34.1;
import com.tencent.qphone.base.util.QLog;

public class vfk
  extends ajpo
{
  public vfk(Leba paramLeba) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("nearby.redpoint", 2, "NearbyEnterUpdateObserver onReceive");
    }
    if (Leba.a(this.this$0) == null) {
      return;
    }
    this.this$0.e.post(new Leba.34.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfk
 * JD-Core Version:    0.7.0.1
 */