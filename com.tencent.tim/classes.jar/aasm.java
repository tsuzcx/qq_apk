import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class aasm
  implements DialogInterface.OnClickListener
{
  public aasm(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LpReportInfo_pf00064.allReport(680, 1, 2);
    QzoneSlideShowPreparingFragment.a(this.this$0).dismiss();
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aasm
 * JD-Core Version:    0.7.0.1
 */