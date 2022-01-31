import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.qphone.base.util.QLog;

public class crq
  extends FMObserver
{
  public crq(Leba paramLeba) {}
  
  protected void b()
  {
    this.a.a.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onSomethingchaned. notifyData.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     crq
 * JD-Core Version:    0.7.0.1
 */