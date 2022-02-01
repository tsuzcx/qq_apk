import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

public class aizs
{
  public static ProgressDialog a(Context paramContext, String paramString)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130850582);
    paramContext = new ReportProgressDialog(paramContext, 2131756467);
    paramContext.show();
    paramContext.getWindow().setContentView(2131558460);
    paramContext.setContentView(2131558460);
    ((TextView)paramContext.findViewById(2131365863)).setText(paramString);
    ((ProgressBar)paramContext.findViewById(2131367453)).setIndeterminateDrawable(localDrawable);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aizs
 * JD-Core Version:    0.7.0.1
 */