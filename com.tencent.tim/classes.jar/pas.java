import com.tencent.biz.qqcircle.fragments.content.QCircleContentImage;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class pas
  implements pje
{
  public pas(QCircleContentImage paramQCircleContentImage, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onScaleChange(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!QCircleContentImage.a(this.b))
    {
      QCircleContentImage.a(this.b, true);
      if (this.c != null)
      {
        pcp.a(67, 2, this.c, 2, QCircleContentImage.a(this.b));
        QLog.d("QCircleContentImage", 4, "onScaleChange report success. pos: " + QCircleContentImage.a(this.b));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pas
 * JD-Core Version:    0.7.0.1
 */