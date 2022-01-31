import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public final class dxh
  implements Runnable
{
  public dxh(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      if ("V 3.4.0.607".contains("CheckIn"))
      {
        AlertDialog localAlertDialog = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).create();
        localAlertDialog.show();
        Object localObject = localAlertDialog.getWindow();
        ((Window)localObject).setContentView(2130903248);
        ((TextView)((Window)localObject).findViewById(2131297358)).setText("Dump内存信息!");
        ((TextView)((Window)localObject).findViewById(2131297361)).setText("是否dump内存信息？");
        Button localButton = (Button)((Window)localObject).findViewById(2131297364);
        localObject = (Button)((Window)localObject).findViewById(2131297363);
        if (localButton != null)
        {
          localButton.setText(2131362795);
          ((Button)localObject).setText(2131362794);
          localButton.setOnClickListener(new dxi(this, localAlertDialog));
          ((Button)localObject).setOnClickListener(new dxk(this, localAlertDialog));
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        QLog.e("ReportLog", 2, "showDumpDialog exception.", localThrowable);
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dxh
 * JD-Core Version:    0.7.0.1
 */