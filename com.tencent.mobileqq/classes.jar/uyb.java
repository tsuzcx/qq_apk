import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleDitto.StSinglePicBanner;

class uyb
  implements vuz
{
  uyb(uya paramuya) {}
  
  public void a()
  {
    QLog.d("QCircleInviteBannerBlock", 1, "clickBanner actionType" + uya.a(this.a).actionType.get() + "   actionUrl" + uya.a(this.a).actionUrl.get());
    if ((uya.a(this.a).actionType.get() == 1) || (uya.a(this.a).actionType.get() == 2))
    {
      uxo.b(uya.a(this.a), uya.a(this.a).actionUrl.get());
      return;
    }
    QLog.d("QCircleInviteBannerBlock", 1, "unDefined banner jump action:" + uya.a(this.a).actionType.get());
    uxo.b(uya.b(this.a), uya.a(this.a).actionUrl.get());
  }
  
  public void b()
  {
    uwz.a().f();
    zwp.a().a(new QCircleCloseBannerEvent());
    this.a.a(false);
    QLog.d("QCircleInviteBannerBlock", 1, "clickClose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyb
 * JD-Core Version:    0.7.0.1
 */