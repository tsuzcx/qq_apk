import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import qqcircle.QQCircleFeedBase.StLikeBusiData;
import qqcircle.QQCircleFeedBase.StPolyLike;

public class voq
  extends von
{
  private ViewStub a;
  protected SquareImageView a;
  protected View.OnClickListener b;
  protected ImageView b;
  protected View.OnClickListener c;
  protected View c;
  protected View.OnClickListener d;
  
  public voq(int paramInt)
  {
    super(paramInt);
  }
  
  private QCircleLayerBean a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get() != null)
      {
        QCircleLayerBean localQCircleLayerBean = new QCircleLayerBean();
        vwl.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed, 3);
        localQCircleLayerBean.setFeed(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed);
        ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
        localExtraTypeInfo.sourceType = 1002;
        localQCircleLayerBean.setExtraTypeInfo(localExtraTypeInfo);
        a(localQCircleLayerBean, paramBoolean);
        localQCircleLayerBean.setSingleFeed(true);
        return localQCircleLayerBean;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleDefaultMessagePresenter", 1, "jumpDetailPageError:" + localException.getMessage());
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(FeedCloudMeta.StNotice paramStNotice)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramStNotice.feed.cover.picUrl.get()))
    {
      if ((this.jdField_c_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null)) {
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369213));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369214));
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(bhtq.b(4.0F));
        localObject = "";
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getTag(2131373990) instanceof String)) {
          localObject = (String)this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getTag(2131373990);
        }
        String str = paramStNotice.feed.cover.picUrl.get();
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setTag(2131373990, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new vrd().a(str).a(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView).b(false).a(true).c(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getWidth()).b(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getHeight());
          QCircleFeedPicLoader.a().a((vrd)localObject, new vor(this));
        }
        localObject = this.jdField_b_of_type_AndroidWidgetImageView;
        if (!uzg.b(paramStNotice.feed)) {
          break label267;
        }
      }
    }
    label267:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(c());
      return;
    }
  }
  
  protected View.OnClickListener a()
  {
    if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_b_of_type_AndroidViewView$OnClickListener = new vos(this);
    }
    return this.jdField_b_of_type_AndroidViewView$OnClickListener;
  }
  
  protected String a()
  {
    return "QCircleDefaultMessagePresenter";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(a());
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(a());
    }
    if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(b());
    }
    if (this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) {
      this.jdField_b_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(d());
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(d());
    }
    if (this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) {
      this.jdField_c_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(a());
    }
  }
  
  protected void a(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    QQCircleFeedBase.StLikeBusiData localStLikeBusiData;
    if ((this.jdField_a_of_type_Int == 13) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation != null) && (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.like != null)) {
      localStLikeBusiData = new QQCircleFeedBase.StLikeBusiData();
    }
    try
    {
      localStLikeBusiData.mergeFrom(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.operation.like.busiData.get().toByteArray());
      paramQCircleInitBean.setPolyLike((QQCircleFeedBase.StPolyLike)localStLikeBusiData.curPolyLikeInfo.get());
      QLog.d("QCircleDefaultMessagePresenter", 1, "fullscreen url" + localStLikeBusiData.curPolyLikeInfo.fullScreenURLAND.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  protected View.OnClickListener b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      return d();
    }
    return a();
  }
  
  public void b(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131374084));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    a(paramStNotice);
  }
  
  protected View.OnClickListener c()
  {
    return a();
  }
  
  protected View.OnClickListener d()
  {
    if (this.d == null) {
      this.d = new vot(this);
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voq
 * JD-Core Version:    0.7.0.1
 */