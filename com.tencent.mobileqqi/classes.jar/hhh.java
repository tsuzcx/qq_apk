import android.content.Context;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

public class hhh
  extends Toast
{
  public hhh(Context paramContext)
  {
    super(paramContext);
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQToast", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhh
 * JD-Core Version:    0.7.0.1
 */