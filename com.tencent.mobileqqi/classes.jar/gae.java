import android.app.ProgressDialog;
import com.tencent.util.DumpMemInfoHandler;
import java.util.TimerTask;

class gae
  extends TimerTask
{
  gae(gad paramgad, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    DumpMemInfoHandler.a(this.jdField_a_of_type_Gad.a.a);
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gae
 * JD-Core Version:    0.7.0.1
 */