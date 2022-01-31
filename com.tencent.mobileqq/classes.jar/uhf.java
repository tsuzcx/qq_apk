import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.QCircleInitBean.QCircleActionBean;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class uhf
  extends uhb
  implements ubc
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private trk jdField_a_of_type_Trk;
  private trx jdField_a_of_type_Trx;
  private ubb jdField_a_of_type_Ubb;
  
  public uhf(int paramInt)
  {
    super(paramInt);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get() != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get() != null)) {
      return tra.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feedId.get());
    }
    return "";
  }
  
  private trx a()
  {
    try
    {
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get() != null))
      {
        Object localObject = (FeedCloudMeta.StComment)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get();
        List localList = ((FeedCloudMeta.StComment)localObject).vecReply.get();
        if ((localList != null) && (localList.size() > 0))
        {
          QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is Reply");
          return new trx((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, (FeedCloudMeta.StReply)localList.get(localList.size() - 1));
        }
        QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is comment");
        localObject = new trx((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, null);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo error" + localException.getMessage());
      localException.printStackTrace();
      QLog.e("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo return null");
    }
    return null;
  }
  
  private void a()
  {
    List localList = uax.a().a(a());
    if (localList != null)
    {
      QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView" + localList.size());
      this.jdField_a_of_type_Trk.a(localList);
      this.jdField_a_of_type_Trk.notifyDataSetChanged();
      return;
    }
    QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView null");
    this.jdField_a_of_type_Trk.a(new ArrayList());
    this.jdField_a_of_type_Trk.notifyDataSetChanged();
  }
  
  private void a(FeedCloudMeta.StNotice paramStNotice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(tra.a(paramStNotice.createTime.get() * 1000L));
    paramStNotice = new SpannableString(localStringBuilder);
    this.c.setText(paramStNotice);
  }
  
  private void a(trx paramtrx, int paramInt)
  {
    String str = "";
    if (paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) {
      str = paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get();
    }
    for (;;)
    {
      tzv.a(str, 17, paramInt);
      return;
      if (paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) {
        str = paramtrx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      }
    }
  }
  
  public void a(List<trx> paramList)
  {
    if (this.jdField_a_of_type_Trk != null)
    {
      this.jdField_a_of_type_Trk.a(paramList);
      this.jdField_a_of_type_Trk.notifyDataSetChanged();
    }
  }
  
  public void a(tqo paramtqo)
  {
    QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
    Object localObject = (FeedCloudMeta.StComment)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get();
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
      ((QCircleInitBean.QCircleActionBean)localObject).mShowInputKeyboard = true;
      paramtqo.a(localStBusiInfoCommentListData.toByteArray());
      paramtqo.a((QCircleInitBean.QCircleActionBean)localObject);
    }
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376100));
    paramView = new uhg(this, this.jdField_a_of_type_AndroidViewView.getContext(), 1, false);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
      this.jdField_a_of_type_Trk = new trk();
      this.jdField_a_of_type_Trk.a(new uhh(this, paramContext));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Trk);
    }
    this.jdField_a_of_type_Ubb = new uhi(this);
    paramContext = new uhj(this, paramContext);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(paramContext);
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramContext);
    }
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
    try
    {
      uax.a().a(a(), this);
      a(paramStNotice);
      this.jdField_a_of_type_Trx = a();
      a();
      return;
    }
    catch (Exception paramStNotice)
    {
      QLog.i("QCircleReplyMessagePresenter", 1, "bindCustomData" + paramStNotice.getMessage());
      paramStNotice.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */