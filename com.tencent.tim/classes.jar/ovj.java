import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.widgets.QCircleInviteBannerView.a;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleDitto.StSinglePicBanner;

class ovj
  implements QCircleInviteBannerView.a
{
  ovj(ovi paramovi) {}
  
  public void bhU()
  {
    QLog.d("QCircleInviteBannerBlock", 1, "clickBanner actionType" + ovi.a(this.a).actionType.get() + "   actionUrl" + ovi.a(this.a).actionUrl.get());
    if ((ovi.a(this.a).actionType.get() == 1) || (ovi.a(this.a).actionType.get() == 2))
    {
      oux.aY(ovi.a(this.a), ovi.a(this.a).actionUrl.get());
      return;
    }
    QLog.d("QCircleInviteBannerBlock", 1, "unDefined banner jump action:" + ovi.a(this.a).actionType.get());
    oux.aY(ovi.b(this.a), ovi.a(this.a).actionUrl.get());
  }
  
  public void bhV()
  {
    oue.a().bhD();
    rwv.a().a(new QCircleCloseBannerEvent());
    this.a.ur(false);
    QLog.d("QCircleInviteBannerBlock", 1, "clickClose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovj
 * JD-Core Version:    0.7.0.1
 */