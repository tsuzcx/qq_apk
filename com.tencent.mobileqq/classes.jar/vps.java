import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;

public class vps
  implements DialogInterface.OnClickListener
{
  public vps(QCirclePolyLikePayView paramQCirclePolyLikePayView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCirclePolyLikePayView.a(this.a).cancel();
    vrg.a(95, 2, this.a.a(), this.a.a().getPageId());
    vrc.a(String.valueOf(uxx.a()), 95, 2, QCirclePolyLikePayView.a(this.a), this.a.a(), null, this.a.a().getPageId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vps
 * JD-Core Version:    0.7.0.1
 */