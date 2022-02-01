import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.onlinestatus.AccountPanel.16.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class aksc
  implements Observer
{
  aksc(akrv paramakrv) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((akrv.a(this.this$0) == null) || (akrv.a(this.this$0).isFinishing()) || (akrv.a(this.this$0) == null)) {
      QLog.d("AccountPanel", 1, String.format("mObserver update return", new Object[0]));
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("AccountPanel", 2, "update");
        }
      } while (!(paramObject instanceof String[]));
      paramObservable = (String[])paramObject;
    } while ((paramObservable.length != 2) || (!acbn.bku.equals(paramObservable[0])));
    if (QLog.isColorLevel()) {
      QLog.d("AccountPanel", 2, "update() -> before update");
    }
    akrv.a(this.this$0).runOnUiThread(new AccountPanel.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksc
 * JD-Core Version:    0.7.0.1
 */