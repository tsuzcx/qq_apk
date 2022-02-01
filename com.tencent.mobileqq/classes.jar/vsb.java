import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;

public class vsb
  implements DialogInterface.OnClickListener
{
  public vsb(QCirclePolyLikePayView paramQCirclePolyLikePayView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCirclePolyLikePayView.a(this.a).cancel();
    vtr.a(95, 2, this.a.a(), this.a.a().getPageId());
    vtn.a(String.valueOf(uzg.a()), 95, 2, QCirclePolyLikePayView.a(this.a), this.a.a(), null, this.a.a().getPageId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsb
 * JD-Core Version:    0.7.0.1
 */