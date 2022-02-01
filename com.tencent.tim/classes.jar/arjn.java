import android.content.Context;
import android.graphics.Color;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class arjn
  extends ReportDialog
{
  private TextView fb;
  
  public arjn(Context paramContext)
  {
    super(paramContext, 2131755357);
    getWindow().setFlags(16, 16);
    getWindow().setFlags(8, 8);
    getWindow().setGravity(17);
    setContentView(2131561732);
    this.fb = ((TextView)findViewById(2131379951));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      this.fb.setTextColor(Color.parseColor("#FF737373"));
    }
    setCancelable(false);
  }
  
  public void setTips(String paramString)
  {
    this.fb.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjn
 * JD-Core Version:    0.7.0.1
 */