import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class aqsb
  implements Observer
{
  aqsb(aqsa paramaqsa) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureFontAdapter", 2, "SignatureFontAdapter type = " + paramObject);
    }
    if ((paramObject instanceof Integer))
    {
      switch (((Integer)paramObject).intValue())
      {
      default: 
        return;
      case 1: 
        this.a.a.A().sendEmptyMessage(10003);
        return;
      }
      this.a.a.A().sendEmptyMessage(10002);
      return;
    }
    this.a.a.A().sendEmptyMessage(10003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqsb
 * JD-Core Version:    0.7.0.1
 */