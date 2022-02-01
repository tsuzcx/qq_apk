import com.tencent.biz.qqcircle.widgets.feed.QCircleInsFeedItemView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class weg
  extends anuw
{
  public weg(QCircleInsFeedItemView paramQCircleInsFeedItemView) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (paramBoolean)
    {
      String str = paramCard.strNick;
      if (QCircleInsFeedItemView.a(this.a) != null) {
        QCircleInsFeedItemView.a(this.a).a(paramCard.strNick, paramCard.uin);
      }
      if (uzg.a(paramCard.uin))
      {
        uyn.a().nick.set(str);
        uyn.a(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     weg
 * JD-Core Version:    0.7.0.1
 */