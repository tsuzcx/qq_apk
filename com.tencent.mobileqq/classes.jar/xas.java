import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xas
  extends wla
{
  public List<wqp> a = new ArrayList();
  
  public xas(qqstory_service.RspGetBatchFeedFeature paramRspGetBatchFeedFeature)
  {
    if ((paramRspGetBatchFeedFeature.feed_feature_list.has()) && (!paramRspGetBatchFeedFeature.feed_feature_list.isEmpty()))
    {
      paramRspGetBatchFeedFeature = paramRspGetBatchFeedFeature.feed_feature_list.get().iterator();
      while (paramRspGetBatchFeedFeature.hasNext())
      {
        qqstory_struct.FeedFeature localFeedFeature = (qqstory_struct.FeedFeature)paramRspGetBatchFeedFeature.next();
        wqp localwqp = new wqp();
        localwqp.a(localFeedFeature);
        this.a.add(localwqp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xas
 * JD-Core Version:    0.7.0.1
 */