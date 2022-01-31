import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.LBSObserver;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;

public class fqk
  extends LBSObserver
{
  public fqk(LocationSelectActivity paramLocationSelectActivity) {}
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (Math.abs(System.currentTimeMillis() - this.a.jdField_a_of_type_Long) > 1200L)
    {
      this.a.a(paramBoolean, paramArrayOfString);
      return;
    }
    Message localMessage = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(1000);
    localMessage.obj = new Object[] { Boolean.valueOf(paramBoolean), paramArrayOfString };
    this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 1200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fqk
 * JD-Core Version:    0.7.0.1
 */