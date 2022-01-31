import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.ArrayList;

public class trc
  implements yvn<FeedCloudRead.StGetFeedDetailRsp>
{
  public trc(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      int i = QCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter, this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent.mTargetId);
      if (i != -1)
      {
        tqg.a(paramStGetFeedDetailRsp.feed.id.get(), (FeedCloudMeta.StFeed)this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.b().get(i));
        QCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter, this.jdField_a_of_type_ComTencentBizQqcircleEventsQCircleFeedEvent.mTargetId);
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.b().remove(i);
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.b().add(i, paramStGetFeedDetailRsp.feed);
        this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter.notifyDataSetChanged();
        if (QCircleFakeAdapter.a(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter) != null) {
          QQToast.a(QCircleFakeAdapter.b(this.jdField_a_of_type_ComTencentBizQqcircleAdapterQCircleFakeAdapter), 0, 2131695782, 0).a();
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trc
 * JD-Core Version:    0.7.0.1
 */