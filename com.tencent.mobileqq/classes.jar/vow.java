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

public class vow
  extends voq
  implements vwe
{
  private aakf jdField_a_of_type_Aakf;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private uzx jdField_a_of_type_Uzx;
  private vba jdField_a_of_type_Vba;
  private vwd jdField_a_of_type_Vwd;
  private RecyclerView b;
  private View d;
  
  public vow(int paramInt)
  {
    super(paramInt);
  }
  
  private vba a()
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
          return new vba((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, (FeedCloudMeta.StReply)localList.get(localList.size() - 1));
        }
        QLog.d("QCircleReplyMessagePresenter", 1, "getFeedCommentInfo is comment");
        localObject = new vba((FeedCloudMeta.StFeed)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get(), (FeedCloudMeta.StComment)localObject, null);
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
    } while ((localView == null) || (!(this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.findContainingViewHolder(localView) instanceof aabz)));
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
      i = vvz.a().a();
    } while ((arrayOfInt[1] <= i) || (this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView == null));
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView.scrollBy(0, arrayOfInt[1] - i);
    QLog.i("QCircleReplyMessagePresenter", 1, "scrollItemToVisbleAboveInputLayout  scrollBy: " + (arrayOfInt[1] - i));
    a(arrayOfInt[1] - i);
    ThreadManager.getUIHandler().postDelayed(new QCircleReplyMessagePresenter.6(this, paramView, arrayOfInt, i), 1L);
  }
  
  private void a(FeedCloudMeta.StNotice paramStNotice)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(uzg.a(paramStNotice.createTime.get() * 1000L));
    paramStNotice = new SpannableString(localStringBuilder);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramStNotice);
  }
  
  private void a(vba paramvba, int paramInt)
  {
    String str = "";
    if (paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply != null) {
      str = paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StReply.postUser.id.get();
    }
    for (;;)
    {
      vtq.a(str, 17, paramInt);
      return;
      if (paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment != null) {
        str = paramvba.jdField_a_of_type_FeedcloudFeedCloudMeta$StComment.postUser.id.get();
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
      return uzg.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.comment.id.get(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feedId.get());
    }
    return "";
  }
  
  private void d()
  {
    List localList = vvz.a().a(b());
    if (localList != null)
    {
      QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView" + localList.size());
      this.jdField_a_of_type_Uzx.a(localList);
      this.jdField_a_of_type_Uzx.notifyDataSetChanged();
      return;
    }
    QLog.d("QCircleReplyMessagePresenter", 3, "initFakeReplyView null");
    this.jdField_a_of_type_Uzx.a(new ArrayList());
    this.jdField_a_of_type_Uzx.notifyDataSetChanged();
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aakf = new aakf(this.d);
    this.jdField_a_of_type_Aakf.a(new vpc(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aakf != null)
    {
      this.jdField_a_of_type_Aakf.a();
      this.jdField_a_of_type_Aakf = null;
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    this.jdField_b_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    super.a(paramQCircleReportBean);
    if (this.jdField_a_of_type_Uzx != null) {
      this.jdField_a_of_type_Uzx.a(a());
    }
  }
  
  public void a(List<vba> paramList)
  {
    if (this.jdField_a_of_type_Uzx != null)
    {
      this.jdField_a_of_type_Uzx.a(paramList);
      this.jdField_a_of_type_Uzx.notifyDataSetChanged();
    }
  }
  
  protected View.OnClickListener b()
  {
    return this.c;
  }
  
  public void b()
  {
    e();
  }
  
  public void b(Context paramContext, View paramView)
  {
    super.b(paramContext, paramView);
    this.d = paramView;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376996));
    paramView = new vox(this, this.jdField_a_of_type_AndroidViewView.getContext(), 1, false);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
      this.jdField_a_of_type_Uzx = new uzx();
      this.jdField_a_of_type_Uzx.a(new voy(this, paramContext));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Uzx);
    }
    this.jdField_a_of_type_Vwd = new voz(this);
    this.c = new vpa(this, paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new vpb(this));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    super.b(paramStNotice, paramInt);
    try
    {
      vvz.a().a(b(), this);
      a(paramStNotice);
      this.jdField_a_of_type_Vba = a();
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
 * Qualified Name:     vow
 * JD-Core Version:    0.7.0.1
 */