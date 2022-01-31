import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;

public class xcy
  implements Runnable
{
  public xcy(PhotoListActivity paramPhotoListActivity) {}
  
  public void run()
  {
    LpReportInfo_pf00064 localLpReportInfo_pf00064 = new LpReportInfo_pf00064(723, 2, 1);
    LpReportManager.getInstance().reportToPF00064(localLpReportInfo_pf00064, false, false);
    PhotoListActivity.a(this.a, "aio_sync_qzone", "operation_type", "photo_list_expose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcy
 * JD-Core Version:    0.7.0.1
 */