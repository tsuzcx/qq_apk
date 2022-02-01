import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikePayView;
import com.tencent.biz.qqcircle.report.QCircleReportBean;

public class vpt
  implements DialogInterface.OnClickListener
{
  public vpt(QCirclePolyLikePayView paramQCirclePolyLikePayView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QCirclePolyLikePayView.a(this.a).cancel();
    uxo.a(this.a.getContext(), "https://h5.qzone.qq.com/v2/wezone/pay?_wv=17301507&_proxy=1&_wwv=1");
    vrg.a(95, 3, this.a.a(), this.a.a().getPageId());
    vrc.a(String.valueOf(uxx.a()), 95, 3, QCirclePolyLikePayView.b(this.a), this.a.a(), null, this.a.a().getPageId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpt
 * JD-Core Version:    0.7.0.1
 */