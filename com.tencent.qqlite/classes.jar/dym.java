import android.app.ProgressDialog;
import com.tencent.util.DumpMemInfoHandler;
import java.util.TimerTask;

class dym
  extends TimerTask
{
  dym(dyl paramdyl, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    DumpMemInfoHandler.a(this.jdField_a_of_type_Dyl.a.a);
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dym
 * JD-Core Version:    0.7.0.1
 */