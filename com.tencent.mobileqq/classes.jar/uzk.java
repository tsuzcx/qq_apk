import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleDitto.StSinglePicBanner;

class uzk
  implements vyc
{
  uzk(uzj paramuzj) {}
  
  public void a()
  {
    QLog.d("QCircleInviteBannerBlock", 1, "clickBanner actionType" + uzj.a(this.a).actionType.get() + "   actionUrl" + uzj.a(this.a).actionUrl.get());
    if ((uzj.a(this.a).actionType.get() == 1) || (uzj.a(this.a).actionType.get() == 2))
    {
      uyx.a(uzj.a(this.a), uzj.a(this.a).actionUrl.get());
      return;
    }
    QLog.d("QCircleInviteBannerBlock", 1, "unDefined banner jump action:" + uzj.a(this.a).actionType.get());
    uyx.a(uzj.b(this.a), uzj.a(this.a).actionUrl.get());
  }
  
  public void b()
  {
    uyk.a().f();
    aaak.a().a(new QCircleCloseBannerEvent());
    this.a.a(false);
    QLog.d("QCircleInviteBannerBlock", 1, "clickClose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzk
 * JD-Core Version:    0.7.0.1
 */