import android.app.ProgressDialog;
import com.tencent.util.DumpMemInfoHandler;
import java.util.TimerTask;

class dxd
  extends TimerTask
{
  dxd(dxc paramdxc, ProgressDialog paramProgressDialog) {}
  
  public void run()
  {
    DumpMemInfoHandler.a(this.jdField_a_of_type_Dxc.a.a);
    this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxd
 * JD-Core Version:    0.7.0.1
 */