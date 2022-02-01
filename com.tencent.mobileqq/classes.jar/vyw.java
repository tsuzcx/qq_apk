import com.tencent.biz.qqcircle.events.QCircleCommentPraiseUpdateEvent;
import com.tencent.biz.qqcircle.widgets.QCircleCommentPraiseLayout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudWrite.StDoLikeRsp;

public class vyw
  implements aaav<FeedCloudWrite.StDoLikeRsp>
{
  public vyw(QCircleCommentPraiseLayout paramQCircleCommentPraiseLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    if ((paramBoolean) && (paramLong == 0L)) {
      if (QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout) != null)
      {
        paramString = QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).id.get();
        if (QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout) == null) {
          break label183;
        }
        paramStDoLikeRsp = QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).id.get();
        label60:
        if ((QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout) != 1) || (QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout) == null)) {
          break label190;
        }
        QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).likeInfo.status.set(this.jdField_a_of_type_Int);
        QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).likeInfo.count.set(this.b);
        label121:
        aaak.a().a(new QCircleCommentPraiseUpdateEvent(QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout), this.jdField_a_of_type_Int, QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).id.get(), paramString, paramStDoLikeRsp, this.b));
      }
    }
    for (;;)
    {
      QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout, true);
      return;
      paramString = "";
      break;
      label183:
      paramStDoLikeRsp = "";
      break label60;
      label190:
      if ((QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout) != 2) || (QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout) == null)) {
        break label121;
      }
      QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).likeInfo.status.set(this.jdField_a_of_type_Int);
      QCircleCommentPraiseLayout.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout).likeInfo.count.set(this.b);
      break label121;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.a(this.c, this.d);
      vws.a(paramLong, this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleCommentPraiseLayout.getContext(), paramString, 0);
      QLog.d("QCircleCommentPraiseLay", 4, "zan failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyw
 * JD-Core Version:    0.7.0.1
 */