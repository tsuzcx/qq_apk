import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.mpfile.LiteMpFileDownloadActivity;
import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class dh
  implements View.OnClickListener
{
  public dh(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LiteMpFileDownloadActivity.class);
    this.a.startActivity(paramView);
    ReportController.b(this.a.b, "CliOper", "", "", "0X800421B", "0X800421B", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.7.0.1
 */