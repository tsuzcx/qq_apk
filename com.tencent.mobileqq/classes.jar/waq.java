import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class waq
  extends aniz
{
  public waq(QCircleInsFeedItemView paramQCircleInsFeedItemView) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (paramBoolean)
    {
      String str = paramCard.strNick;
      if (QCircleInsFeedItemView.a(this.a) != null) {
        QCircleInsFeedItemView.a(this.a).a(paramCard.strNick, paramCard.uin);
      }
      if (uxx.a(paramCard.uin))
      {
        uxc.a().nick.set(str);
        uxc.a(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waq
 * JD-Core Version:    0.7.0.1
 */