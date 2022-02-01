import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

public class cro
  extends QZoneObserver
{
  public cro(Leba paramLeba) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "on Get QZone Count:" + paramBoolean1 + ",HasNew:" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.a.a.notifyDataSetChanged();
      Leba.a(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.leba", 2, "onGetQZoneFeedCountFin. notifyData.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cro
 * JD-Core Version:    0.7.0.1
 */