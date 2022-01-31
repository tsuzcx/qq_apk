import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;

public class txz
  extends yfn
{
  private QCircleInitBean a;
  
  public txz(QCircleInitBean paramQCircleInitBean)
  {
    this.a = paramQCircleInitBean;
  }
  
  public void a() {}
  
  public void a(yft paramyft)
  {
    if ((this.a != null) && (this.a.getTagInfo() != null) && ((!TextUtils.isEmpty(this.a.getTagInfo().tagId.get())) || (!TextUtils.isEmpty(this.a.getTagInfo().tagName.get()))))
    {
      QCircleGetFeedListRequest localQCircleGetFeedListRequest = new QCircleGetFeedListRequest(this.a.getTagInfo().tagId.get(), this.a.getTagInfo().tagName.get(), null);
      paramyft = new tya(this, paramyft);
      localQCircleGetFeedListRequest.setEnableCache(true);
      VSNetworkHelper.a().a(localQCircleGetFeedListRequest, paramyft);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txz
 * JD-Core Version:    0.7.0.1
 */