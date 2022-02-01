import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;

public class vsc
  implements DialogInterface.OnClickListener
{
  public vsc(QCirclePolyLikePayView paramQCirclePolyLikePayView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCirclePolyLikePayView.a(this.a).cancel();
    uyx.a(this.a.getContext(), "https://h5.qzone.qq.com/v2/wezone/pay?_wv=17301507&_proxy=1&_wwv=1", null, -1);
    vtr.a(95, 3, this.a.a(), this.a.a().getPageId());
    vtn.a(String.valueOf(uzg.a()), 95, 3, QCirclePolyLikePayView.b(this.a), this.a.a(), null, this.a.a().getPageId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsc
 * JD-Core Version:    0.7.0.1
 */