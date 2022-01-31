import android.graphics.drawable.Animatable;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class fbd
  implements Runnable
{
  public fbd(QQProgressDialog paramQQProgressDialog) {}
  
  public void run()
  {
    QQProgressDialog.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fbd
 * JD-Core Version:    0.7.0.1
 */