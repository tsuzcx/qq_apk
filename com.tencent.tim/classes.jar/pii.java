import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
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

public abstract class pii
{
  protected FeedCloudMeta.StNotice a;
  protected QQCircleFeedBase.StNoticeBusiData a;
  protected View.OnClickListener cG;
  protected QCircleAvatarView f;
  protected View mContainer;
  protected Context mContext;
  protected int mViewType;
  protected View nV;
  protected TextView wT;
  protected TextView wU;
  protected TextView wt;
  
  public pii(int paramInt)
  {
    this.mViewType = paramInt;
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if ((paramStNotice != null) && (paramStNotice.operation.get() != null))
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice = paramStNotice;
      if ((this.mContext instanceof BaseActivity))
      {
        this.f.setUser(((BaseActivity)this.mContext).app, (FeedCloudMeta.StUser)paramStNotice.operation.opUser.get());
        this.wt.setText(paramStNotice.operation.opUser.nick.get());
        this.wT.setText(paramStNotice.message.get());
        this.wU.setText(ovd.aC(paramStNotice.createTime.get() * 1000L));
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get() != null) {
        this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData = new QQCircleFeedBase.StNoticeBusiData();
      }
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StNoticeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.busiData.get().toByteArray());
      b(paramStNotice, paramInt);
      kJ();
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
  
  abstract void b(FeedCloudMeta.StNotice paramStNotice, int paramInt);
  
  public void g(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    if (paramView != null)
    {
      this.mContainer = paramView;
      this.f = ((QCircleAvatarView)paramView.findViewById(2131369668));
      this.wt = ((TextView)paramView.findViewById(2131380818));
      this.wT = ((TextView)paramView.findViewById(2131380805));
      this.wU = ((TextView)paramView.findViewById(2131380806));
      this.nV = paramView.findViewById(2131370692);
      this.cG = new pij(this);
      this.f.setOnClickListener(this.cG);
      this.wt.setOnClickListener(this.cG);
      h(paramContext, paramView);
    }
  }
  
  abstract void h(Context paramContext, View paramView);
  
  abstract void kJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pii
 * JD-Core Version:    0.7.0.1
 */