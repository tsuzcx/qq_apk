import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
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

public abstract class vmh
  implements zxl<QCircleReportBean>
{
  protected int a;
  protected Context a;
  protected View.OnClickListener a;
  protected View a;
  protected TextView a;
  private QCircleReportBean jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  protected QCircleAsyncTextView a;
  protected QCircleAvatarView a;
  private QCircleSpecialFollowImageView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView;
  protected FeedCloudMeta.StNotice a;
  protected QQCircleFeedBase.StNoticeBusiData a;
  protected zxi a;
  protected View b;
  protected TextView b;
  
  public vmh(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
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
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369037));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379783));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView = ((QCircleAsyncTextView)paramView.findViewById(2131379769));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379770));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370100);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView = ((QCircleSpecialFollowImageView)paramView.findViewById(2131369298));
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new vmj(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      c(paramContext, paramView);
      b(paramContext, paramView);
    }
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = QCircleReportBean.setReportBean(a(), paramQCircleReportBean);
  }
  
  protected void a(FeedCloudMeta.StNotice paramStNotice) {}
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.operation.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice = paramStNotice;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, (FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStNotice.operation.opUser.nick.get());
        if (!TextUtils.isEmpty(paramStNotice.message.get())) {
          break label219;
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(uxx.a(paramStNotice.createTime.get() * 1000L));
      a(paramStNotice);
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get() != null) {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData = new QQCircleFeedBase.StNoticeBusiData();
      }
      try
      {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get().toByteArray());
        FeedCloudMeta.StUser localStUser = (FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.opUser.get();
        if ((localStUser != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView != null)) {
          this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleSpecialFollowImageView.setUser(localStUser);
        }
        b(paramStNotice, paramInt);
        a();
        return;
        label219:
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setRichText(paramStNotice.message.get(), new vmi(this));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QCircleBaseMessagePresenter", 1, "getNoticeBusiData error" + localException.getMessage());
        }
      }
    }
  }
  
  public void a(zxi paramzxi)
  {
    this.jdField_a_of_type_Zxi = paramzxi;
  }
  
  abstract void b(Context paramContext, View paramView);
  
  abstract void b(FeedCloudMeta.StNotice paramStNotice, int paramInt);
  
  protected void c(Context paramContext, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */