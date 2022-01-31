import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

public final class gep
  implements Runnable
{
  public gep(Activity paramActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      if ("V 6.0.1.6600".contains("CheckIn"))
      {
        AlertDialog localAlertDialog = new AlertDialog.Builder(this.jdField_a_of_type_AndroidAppActivity).create();
        localAlertDialog.show();
        Object localObject = localAlertDialog.getWindow();
        ((Window)localObject).setContentView(2130903292);
        ((TextView)((Window)localObject).findViewById(2131231985)).setText("Dump内存信息!");
        ((TextView)((Window)localObject).findViewById(2131231988)).setText("是否dump内存信息？");
        Button localButton = (Button)((Window)localObject).findViewById(2131231991);
        localObject = (Button)((Window)localObject).findViewById(2131231990);
        if (localButton != null)
        {
          localButton.setText(2131562539);
          ((Button)localObject).setText(2131561746);
          localButton.setOnClickListener(new geq(this, localAlertDialog));
          ((Button)localObject).setOnClickListener(new ges(this, localAlertDialog));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gep
 * JD-Core Version:    0.7.0.1
 */