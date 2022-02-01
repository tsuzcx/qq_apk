import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class afsd
  extends acfd
{
  afsd(afsc paramafsc) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<abgt> paramArrayList)
  {
    if (paramBoolean) {
      afsf.a().ed(paramArrayList);
    }
    for (;;)
    {
      afsc.a(this.b, false);
      afsc.b(this.b, false);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("EquipLockWebImpl", 2, "error, fetch recommend list !");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsd
 * JD-Core Version:    0.7.0.1
 */