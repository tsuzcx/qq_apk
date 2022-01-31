import android.app.ProgressDialog;
import com.tencent.util.DumpMemInfoHandler;
import java.util.TimerTask;

class dxj
  extends TimerTask
{
  dxj(dxi paramdxi, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    DumpMemInfoHandler.a(this.jdField_a_of_type_Dxi.a.a);
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxj
 * JD-Core Version:    0.7.0.1
 */