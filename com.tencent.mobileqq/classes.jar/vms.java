import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.6;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.app.ThreadManager;
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
import mqq.os.MqqHandler;

public class vms
  extends vmk
  implements vti
{
  private aage jdField_a_of_type_Aage;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private uyn jdField_a_of_type_Uyn;
  private uzk jdField_a_of_type_Uzk;
  private vth jdField_a_of_type_Vth;
  private RecyclerView b;
  private View d;
  
  public vms(int paramInt)
  {
    super(paramInt);
  }
  
  private uzk a()
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
          return new uzk((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, (FeedCloudMeta.StReply)localList.get(localList.size() - 1));
        }
        QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is comment");
        localObject = new uzk((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, null);
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
  
  private void a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView == null) || (this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() <= 0)) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount() - 1);
    } while ((localView == null) || (!(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.findContainingViewHolder(localView) instanceof zyd)));
    localView.setPadding(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getPaddingRight(), paramInt);
    QLog.i("QCircleReplyMessagePresenter", 1, "changeMarginToFooterHolder   paddingTop: " + paramInt);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    int[] arrayOfInt;
    int i;
    do
    {
      return;
      arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      arrayOfInt[1] += paramView.getHeight();
      i = vtd.a().a();
    } while ((arrayOfInt[1] <= i) || (this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView == null));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, arrayOfInt[1] - i);
    QLog.i("QCircleReplyMessagePresenter", 1, "scrollItemToVisbleAboveInputLayout  scrollBy: " + (arrayOfInt[1] - i));
    a(arrayOfInt[1] - i);
    ThreadManager.getUIHandler().postDelayed(new QCircleReplyMessagePresenter.6(this, paramView, arrayOfInt, i), 1L);
  }
  
  private void a(uzk paramuzk, int paramInt)
  {
    String str = "";
    if (paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) {
      str = paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get();
    }
    for (;;)
    {
      vrf.a(str, 17, paramInt);
      return;
      if (paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) {
        str = paramuzk.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
      }
    }
  }
  
  private boolean a()
  {
    return QCircleReportBean.isContentDetailPage(a());
  }
  
  private String b()
  {
    if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get() != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.get() != null)) {
      return uxx.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feedId.get());
    }
    return "";
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(uxx.a(paramStNotice.createTime.get() * 1000L));
    paramStNotice = new SpannableString(localStringBuilder);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramStNotice);
  }
  
  private void d()
  {
    List localList = vtd.a().a(b());
    if (localList != null)
    {
      QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView" + localList.size());
      this.jdField_a_of_type_Uyn.a(localList);
      this.jdField_a_of_type_Uyn.notifyDataSetChanged();
      return;
    }
    QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView null");
    this.jdField_a_of_type_Uyn.a(new ArrayList());
    this.jdField_a_of_type_Uyn.notifyDataSetChanged();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aage = new aage(this.jdField_d_of_type_AndroidViewView);
    this.jdField_a_of_type_Aage.a(new vmy(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aage != null)
    {
      this.jdField_a_of_type_Aage.a();
      this.jdField_a_of_type_Aage = null;
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    super.a(paramQCircleReportBean);
    if (this.jdField_a_of_type_Uyn != null) {
      this.jdField_a_of_type_Uyn.a(a());
    }
  }
  
  public void a(List<uzk> paramList)
  {
    if (this.jdField_a_of_type_Uyn != null)
    {
      this.jdField_a_of_type_Uyn.a(paramList);
      this.jdField_a_of_type_Uyn.notifyDataSetChanged();
    }
  }
  
  protected View.OnClickListener b()
  {
    return this.jdField_d_of_type_AndroidViewView$OnClickListener;
  }
  
  public void b()
  {
    e();
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.jdField_d_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376857));
    paramView = new vmt(this, this.jdField_a_of_type_AndroidViewView.getContext(), 1, false);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
      this.jdField_a_of_type_Uyn = new uyn();
      this.jdField_a_of_type_Uyn.a(new vmu(this, paramContext));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uyn);
    }
    this.jdField_a_of_type_Vth = new vmv(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new vmw(this, paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new vmx(this));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
    try
    {
      vtd.a().a(b(), this);
      b(paramStNotice);
      this.jdField_a_of_type_Uzk = a();
      d();
      return;
    }
    catch (Exception paramStNotice)
    {
      QLog.i("QCircleReplyMessagePresenter", 1, "bindCustomData" + paramStNotice.getMessage());
      paramStNotice.printStackTrace();
    }
  }
  
  public void c()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vms
 * JD-Core Version:    0.7.0.1
 */