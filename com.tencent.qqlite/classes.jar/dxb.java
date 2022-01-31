import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public final class dxb
  implements Runnable
{
  public dxb(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      if ("V 3.3.0.544".contains("CheckIn"))
      {
        AlertDialog localAlertDialog = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).create();
        localAlertDialog.show();
        Object localObject = localAlertDialog.getWindow();
        ((Window)localObject).setContentView(2130903248);
        ((TextView)((Window)localObject).findViewById(2131297362)).setText("Dump内存信息!");
        ((TextView)((Window)localObject).findViewById(2131297365)).setText("是否dump内存信息？");
        Button localButton = (Button)((Window)localObject).findViewById(2131297368);
        localObject = (Button)((Window)localObject).findViewById(2131297367);
        if (localButton != null)
        {
          localButton.setText(2131362791);
          ((Button)localObject).setText(2131362790);
          localButton.setOnClickListener(new dxc(this, localAlertDialog));
          ((Button)localObject).setOnClickListener(new dxe(this, localAlertDialog));
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
 * Qualified Name:     dxb
 * JD-Core Version:    0.7.0.1
 */