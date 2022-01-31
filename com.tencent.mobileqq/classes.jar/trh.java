import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleDitto.StSinglePicBanner;

class trh
  implements uec
{
  trh(trg paramtrg) {}
  
  public void a()
  {
    QLog.d("QCircleInviteBannerAdapter", 1, "clickBanner actionType" + trg.a(this.a).actionType.get() + "   actionUrl" + trg.a(this.a).actionUrl.get());
    if (trg.a(this.a).actionType.get() == 1)
    {
      tqs.a(trg.a(this.a), trg.a(this.a).actionUrl.get());
      return;
    }
    QLog.d("QCircleInviteBannerAdapter", 1, "unDefined banner jump action:" + trg.a(this.a).actionType.get());
  }
  
  public void b()
  {
    tpz.a().f();
    yiw.a().a(new QCircleCloseBannerEvent());
    this.a.a(false);
    QLog.d("QCircleInviteBannerAdapter", 1, "clickClose");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trh
 * JD-Core Version:    0.7.0.1
 */