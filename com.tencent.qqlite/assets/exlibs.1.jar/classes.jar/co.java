import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.LiteMpFileMainActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class co
  implements View.OnClickListener
{
  public co(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LiteMpFileDownloadActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.app, "CliOper", "", "", "0X800421B", "0X800421B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     co
 * JD-Core Version:    0.7.0.1
 */