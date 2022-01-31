import android.app.ProgressDialog;
import com.tencent.util.DumpMemInfoHandler;
import java.util.TimerTask;

class gaf
  extends TimerTask
{
  gaf(gae paramgae, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    DumpMemInfoHandler.a(this.jdField_a_of_type_Gae.a.a);
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gaf
 * JD-Core Version:    0.7.0.1
 */