import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.ArrayList;

public class uzq
  implements aaav<FeedCloudRead.StGetFeedDetailRsp>
{
  public uzq(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      int i = QCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter, this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent.mTargetId);
      if (i != -1)
      {
        uyn.a(paramStGetFeedDetailRsp.feed.id.get(), (FeedCloudMeta.StFeed)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList().get(i));
        QCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter, this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent.mTargetId);
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList().remove(i);
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.getDataList().add(i, paramStGetFeedDetailRsp.feed);
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.notifyDataSetChanged();
        QLog.d("QCircleFakeAdapter", 1, "success replace feed");
      }
    }
    for (;;)
    {
      QLog.d("QCircleFakeAdapter", 1, "fetch real feed success:" + paramBoolean + "  retCode code:" + paramLong + "fromRetry" + this.jdField_a_of_type_Boolean);
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent);
      QLog.d("QCircleFakeAdapter", 1, "start retry");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzq
 * JD-Core Version:    0.7.0.1
 */