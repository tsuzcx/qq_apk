import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class xtw
  implements DialogInterface.OnClickListener
{
  public xtw(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QzDynamicVideoPreviewActivity.a(this.a).dismiss();
    LpReportInfo_pf00064.allReport(680, 1, 4, true);
    QzDynamicVideoPreviewActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtw
 * JD-Core Version:    0.7.0.1
 */