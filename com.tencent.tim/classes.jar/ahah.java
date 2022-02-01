import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.settings.FMSettings.5;
import java.lang.reflect.Field;

public class ahah
  implements DialogInterface.OnClickListener
{
  public ahah(FMSettings.5 param5, TextView paramTextView, ProgressBar paramProgressBar) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.this$0.d().em(this.a.val$activity);
    try
    {
      Field localField = paramDialogInterface.getClass().getSuperclass().getDeclaredField("mShowing");
      localField.setAccessible(true);
      localField.set(paramDialogInterface, Boolean.valueOf(false));
      this.Tc.setText(acfp.m(2131706375));
      paramDialogInterface = this.a.val$activity.getResources().getColorStateList(2131167340);
      this.a.this$0.ap.getBtnight().setEnabled(false);
      this.a.this$0.ap.getBtnight().setTextColor(paramDialogInterface);
      this.a.this$0.ap.getBtnLeft().setTextColor(paramDialogInterface);
      this.a.this$0.ap.getBtnLeft().setEnabled(false);
      ahaf.a(this.a.this$0, this.a.BM, new ahai(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ahah
 * JD-Core Version:    0.7.0.1
 */