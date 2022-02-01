import com.tencent.biz.qqcircle.widgets.QCircleFeedWidget;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StUser;

public class pfq
  extends accn
{
  public pfq(QCircleFeedWidget paramQCircleFeedWidget) {}
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (paramBoolean)
    {
      String str = paramCard.strNick;
      if (QCircleFeedWidget.a(this.b) != null) {
        QCircleFeedWidget.a(this.b).cj(paramCard.strNick, paramCard.uin);
      }
      if (ovd.eL(paramCard.uin))
      {
        oum.a().nick.set(str);
        oum.qd(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pfq
 * JD-Core Version:    0.7.0.1
 */