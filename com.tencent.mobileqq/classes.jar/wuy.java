import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchFeedFeature;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wuy
  extends wfh
{
  public List<wkv> a = new ArrayList();
  
  public wuy(qqstory_service.RspGetBatchFeedFeature paramRspGetBatchFeedFeature)
  {
    if ((paramRspGetBatchFeedFeature.feed_feature_list.has()) && (!paramRspGetBatchFeedFeature.feed_feature_list.isEmpty()))
    {
      paramRspGetBatchFeedFeature = paramRspGetBatchFeedFeature.feed_feature_list.get().iterator();
      while (paramRspGetBatchFeedFeature.hasNext())
      {
        qqstory_struct.FeedFeature localFeedFeature = (qqstory_struct.FeedFeature)paramRspGetBatchFeedFeature.next();
        wkv localwkv = new wkv();
        localwkv.a(localFeedFeature);
        this.a.add(localwkv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wuy
 * JD-Core Version:    0.7.0.1
 */