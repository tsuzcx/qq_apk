import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean.QCircleActionBean;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class vpf
  extends voq
{
  public vpf(int paramInt)
  {
    super(paramInt);
  }
  
  public void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      Object localObject = (FeedCloudMeta.StComment)this.a.operation.comment.get();
      if (localObject != null)
      {
        localStBusiInfoCommentListData.comment.set((MessageMicro)localObject);
        localObject = ((FeedCloudMeta.StComment)localObject).vecReply.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          int i = ((List)localObject).size();
          localStBusiInfoCommentListData.reply.set((MessageMicro)((List)localObject).get(i - 1));
        }
        localObject = new QCircleInitBean.QCircleActionBean();
        ((QCircleInitBean.QCircleActionBean)localObject).mShowInputKeyboard = false;
        paramQCircleInitBean.setBusiInfoData(localStBusiInfoCommentListData.toByteArray());
        paramQCircleInitBean.setActionBean((QCircleInitBean.QCircleActionBean)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpf
 * JD-Core Version:    0.7.0.1
 */