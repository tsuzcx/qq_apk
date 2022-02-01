import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.fragments.message.presenter.QCircleBaseMessagePresenter.3;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleSpecialFollowImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;

public abstract class von
  implements aabg<QCircleReportBean>
{
  protected int a;
  protected aabd a;
  protected Context a;
  protected View.OnClickListener a;
  public View a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  protected QCircleAsyncTextView a;
  public QCircleAvatarView a;
  private QCircleSpecialFollowImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView;
  protected FeedCloudMeta.StNotice a;
  protected QQCircleFeedBase.StNoticeBusiData a;
  protected View b;
  protected TextView b;
  protected QCircleAsyncTextView b;
  protected QCircleAsyncTextView c;
  
  public von(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(FeedCloudMeta.StNotice paramStNotice)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStNotice.operation.opUser.nick.get());
    FeedCloudMeta.StUser localStUser = (FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.opUser.get();
    if ((localStUser != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView.setUser(localStUser);
    }
    if (TextUtils.isEmpty(paramStNotice.message.get()))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(8);
      if (!TextUtils.isEmpty(paramStNotice.subMessage.get())) {
        break label177;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      label100:
      if (!TextUtils.isEmpty(paramStNotice.summary.get())) {
        break label205;
      }
      this.c.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(uzg.a(paramStNotice.createTime.get() * 1000L));
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(paramStNotice.message.get(), new voo(this));
      break;
      label177:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setText(paramStNotice.subMessage.get().trim());
      break label100;
      label205:
      this.c.setVisibility(0);
      this.c.setText(paramStNotice.summary.get());
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.post(new QCircleBaseMessagePresenter.3(this));
  }
  
  protected int a()
  {
    return QCircleReportBean.getPageId(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  public QCircleReportBean a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean == null) {
      return new QCircleReportBean();
    }
    return QCircleReportBean.getReportBean(a(), this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean);
  }
  
  protected abstract String a();
  
  abstract void a();
  
  public void a(aabd paramaabd)
  {
    this.jdField_a_of_type_Aabd = paramaabd;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369131));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379962));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131379947));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379949));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370198);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView = ((QCircleSpecialFollowImageView)paramView.findViewById(2131369388));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378155));
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131380102));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369117));
      this.c = ((QCircleAsyncTextView)paramView.findViewById(2131379948));
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new vop(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      b();
      b(paramContext, paramView);
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.operation.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice = paramStNotice;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, (FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get() != null) {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData = new QQCircleFeedBase.StNoticeBusiData();
      }
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get().toByteArray());
      a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice);
      b(paramStNotice, paramInt);
      a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("QCircleBaseMessagePresenter", 1, "getNoticeBusiData error" + localException.getMessage());
      }
    }
  }
  
  abstract void b(Context paramContext, View paramView);
  
  abstract void b(FeedCloudMeta.StNotice paramStNotice, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     von
 * JD-Core Version:    0.7.0.1
 */