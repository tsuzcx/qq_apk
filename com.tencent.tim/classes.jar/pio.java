import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
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

public class pio
  extends pik
  implements pdp.b
{
  private ovm jdField_a_of_type_Ovm;
  private pdp.a jdField_a_of_type_Pdp$a;
  private ovx b;
  private RecyclerView n;
  
  public pio(int paramInt)
  {
    super(paramInt);
  }
  
  private ovx a()
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
          return new ovx((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, (FeedCloudMeta.StReply)localList.get(localList.size() - 1));
        }
        QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is comment");
        localObject = new ovx((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, null);
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
  
  private void b(ovx paramovx, int paramInt)
  {
    String str = "";
    if (paramovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) {
      str = paramovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get();
    }
    for (;;)
    {
      pco.h(str, 17, paramInt);
      return;
      if (paramovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) {
        str = paramovx.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      }
    }
  }
  
  private void blf()
  {
    List localList = pdp.a().J(md());
    if (localList != null)
    {
      QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView" + localList.size());
      this.jdField_a_of_type_Ovm.bF(localList);
      this.jdField_a_of_type_Ovm.notifyDataSetChanged();
      return;
    }
    QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView null");
    this.jdField_a_of_type_Ovm.bF(new ArrayList());
    this.jdField_a_of_type_Ovm.notifyDataSetChanged();
  }
  
  private void c(FeedCloudMeta.StNotice paramStNotice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ovd.aC(paramStNotice.createTime.get() * 1000L));
    paramStNotice = new SpannableString(localStringBuilder);
    this.wU.setText(paramStNotice);
  }
  
  private String md()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get() != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get() != null)) {
      return ovd.ac(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feedId.get());
    }
    return "";
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
    try
    {
      pdp.a().a(md(), this);
      c(paramStNotice);
      this.b = a();
      blf();
      return;
    }
    catch (Exception paramStNotice)
    {
      QLog.i("QCircleReplyMessagePresenter", 1, "bindCustomData" + paramStNotice.getMessage());
      paramStNotice.printStackTrace();
    }
  }
  
  public void h(Context paramContext, View paramView)
  {
    super.h(paramContext, paramView);
    this.n = ((RecyclerView)paramView.findViewById(2131377615));
    paramView = new pip(this, this.mContainer.getContext(), 1, false);
    if (this.n != null)
    {
      this.n.setLayoutManager(paramView);
      this.jdField_a_of_type_Ovm = new ovm();
      this.jdField_a_of_type_Ovm.a(new piq(this, paramContext));
      this.n.setAdapter(this.jdField_a_of_type_Ovm);
    }
    this.jdField_a_of_type_Pdp$a = new pir(this);
    this.cH = new pis(this, paramContext);
  }
  
  protected View.OnClickListener u()
  {
    return this.cH;
  }
  
  public void updateList(List<ovx> paramList)
  {
    if (this.jdField_a_of_type_Ovm != null)
    {
      this.jdField_a_of_type_Ovm.bF(paramList);
      this.jdField_a_of_type_Ovm.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pio
 * JD-Core Version:    0.7.0.1
 */