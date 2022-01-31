import com.tencent.biz.qqcircle.widgets.QCirclePolymorphicLikePopWindow;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoLikeRsp;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class ubv
  implements yvn<FeedCloudWrite.StDoLikeRsp>
{
  public ubv(QCirclePolymorphicLikePopWindow paramQCirclePolymorphicLikePopWindow, FeedCloudMeta.StFeed paramStFeed, int paramInt, QQCircleFeedBase.StPolyLike paramStPolyLike1, QQCircleFeedBase.StPolyLike paramStPolyLike2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    QCirclePolymorphicLikePopWindow.b(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow, true);
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (!QCirclePolymorphicLikePopWindow.c(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow.a(false, true, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, this.jdField_a_of_type_Int, this.jdField_a_of_type_QqcircleQQCircleFeedBase$StPolyLike, this.b);
      }
      QLog.d("QCirclePolylick", 4, " success");
    }
    for (;;)
    {
      QCirclePolymorphicLikePopWindow.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePolymorphicLikePopWindow, true);
      return;
      QLog.d("QCirclePolylick", 4, " failed：" + paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubv
 * JD-Core Version:    0.7.0.1
 */