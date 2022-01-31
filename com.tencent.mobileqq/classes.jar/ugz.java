import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
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

public abstract class ugz
{
  protected int a;
  protected Context a;
  protected View a;
  protected TextView a;
  protected QCircleAvatarView a;
  protected FeedCloudMeta.StNotice a;
  protected QQCircleFeedBase.StNoticeBusiData a;
  protected View b;
  protected TextView b;
  protected TextView c;
  
  public ugz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131368706));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378900));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378887));
      this.c = ((TextView)paramView.findViewById(2131378888));
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369677);
      uha localuha = new uha(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(localuha);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(localuha);
      b(paramContext, paramView);
    }
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.operation.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice = paramStNotice;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity))
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setUser(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, (FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStNotice.operation.opUser.nick.get());
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramStNotice.message.get());
        this.c.setText(tra.a(paramStNotice.createTime.get() * 1000L));
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get() != null) {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData = new QQCircleFeedBase.StNoticeBusiData();
      }
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get().toByteArray());
      b(paramStNotice, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugz
 * JD-Core Version:    0.7.0.1
 */