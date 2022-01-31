import com.tencent.biz.qqcircle.events.QCirclePraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCirclePraiseImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

public class ubz
  implements yvn<FeedCloudWrite.StDoLikeRsp>
{
  public ubz(QCirclePraiseImageView paramQCirclePraiseImageView, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    int i = 1;
    QCirclePraiseImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseImageView, true);
    if ((paramBoolean) && (paramLong == 0L))
    {
      QCirclePraiseImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseImageView).likeInfo.status.set(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseImageView.a(this.jdField_a_of_type_Int);
      int j = QCirclePraiseImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseImageView).likeInfo.count.get();
      if (this.jdField_a_of_type_Int == 1) {}
      for (;;)
      {
        i += j;
        QCirclePraiseImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseImageView).likeInfo.count.set(i);
        yej.a().a(new QCirclePraiseUpdateEvent(QCirclePraiseImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePraiseImageView).id.get(), this.jdField_a_of_type_Int, i));
        return;
        i = -1;
      }
    }
    QLog.d("QCircleFeedItemBottomPresenter", 4, "zan failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubz
 * JD-Core Version:    0.7.0.1
 */