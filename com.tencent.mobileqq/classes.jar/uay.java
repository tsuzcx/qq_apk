import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class uay
  extends allb
{
  public uay(QCircleFeedWidget paramQCircleFeedWidget) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (paramBoolean)
    {
      String str = paramCard.strNick;
      if (QCircleFeedWidget.a(this.a) != null) {
        QCircleFeedWidget.a(this.a).a(paramCard.strNick, paramCard.uin);
      }
      if (tra.a(paramCard.uin))
      {
        tqg.a().nick.set(str);
        tqg.a(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uay
 * JD-Core Version:    0.7.0.1
 */