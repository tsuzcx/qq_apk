import com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter;
import com.tencent.mobileqq.activity.contacts.fragment.TroopFragment;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.qphone.base.util.QLog;

public class wle
  extends AutomatorObserver
{
  public wle(TroopFragment paramTroopFragment) {}
  
  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.TroopFragment", 2, "onCacheInited " + paramInt);
      }
    } while (this.a.a == null);
    this.a.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wle
 * JD-Core Version:    0.7.0.1
 */