import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.tim.filemanager.settings.FMSettings.5;
import java.lang.reflect.Field;

public class audp
  implements DialogInterface.OnClickListener
{
  public audp(FMSettings.5 param5, TextView paramTextView, ProgressBar paramProgressBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.this$0.d().em(this.a.val$activity);
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
      this.Tc.setText("默认存储路径更换中，请稍等。");
      paramDialogInterface = this.a.val$activity.getResources().getColorStateList(2131167340);
      this.a.this$0.ap.getBtnight().setEnabled(false);
      this.a.this$0.ap.getBtnight().setTextColor(paramDialogInterface);
      this.a.this$0.ap.getBtnLeft().setTextColor(paramDialogInterface);
      this.a.this$0.ap.getBtnLeft().setEnabled(false);
      audn.a(this.a.this$0, this.a.BM, new audq(this));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audp
 * JD-Core Version:    0.7.0.1
 */