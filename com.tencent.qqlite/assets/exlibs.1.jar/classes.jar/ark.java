import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.theme.NightModeLogic.NightModeCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class ark
  extends NightModeLogic.NightModeCallback
{
  public ark(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void a(Bundle paramBundle)
  {
    this.a.b();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1)
    {
      IndividuationSetActivity.a(this.a).setClickable(false);
      this.a.a.setText("");
    }
    do
    {
      return;
      if (i == 2)
      {
        this.a.b();
        return;
      }
    } while (i != 3);
    IndividuationSetActivity.a(this.a).setClickable(false);
    i = paramBundle.getInt("percent");
    paramBundle = this.a.getString(2131364526);
    paramBundle = paramBundle + "  " + String.valueOf(i) + "%";
    if (QLog.isDevelopLevel()) {
      QLog.d("spooner", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
    }
    this.a.a.setText(paramBundle);
    this.a.a.setContentDescription(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ark
 * JD-Core Version:    0.7.0.1
 */