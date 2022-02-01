import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;

public class vmk
  extends vmh
{
  private ViewStub a;
  protected ImageView a;
  protected SquareImageView a;
  protected View.OnClickListener b;
  protected View.OnClickListener c;
  protected View c;
  protected View.OnClickListener d;
  
  public vmk(int paramInt)
  {
    super(paramInt);
  }
  
  private QCircleInitBean a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get() != null)
      {
        Object localObject = new uxk();
        vtm.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed, 3);
        ((uxk)localObject).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed);
        ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
        localExtraTypeInfo.sourceType = 1002;
        ((uxk)localObject).a(localExtraTypeInfo);
        a((uxk)localObject, paramBoolean);
        localObject = ((uxk)localObject).a();
        ((QCircleInitBean)localObject).isSingleFeed = true;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleDefaultMessagePresenter", 1, "jumpDetailPageError:" + localException.getMessage());
      localException.printStackTrace();
    }
    return null;
  }
  
  private void b(FeedCloudMeta.StNotice paramStNotice)
  {
    Object localObject;
    if (!TextUtils.isEmpty(paramStNotice.feed.cover.picUrl.get()))
    {
      if ((this.jdField_c_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidViewViewStub != null)) {
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369123));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369124));
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(20);
        localObject = "";
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getTag(2131373857) instanceof String)) {
          localObject = (String)this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getTag(2131373857);
        }
        String str = paramStNotice.feed.cover.picUrl.get();
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setTag(2131373857, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new vou().a(str).a(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView).b(false).a(true).c(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getWidth()).b(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getHeight());
          QCircleFeedPicLoader.a().a((vou)localObject, new vml(this));
        }
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!uxx.b(paramStNotice.feed)) {
          break label264;
        }
      }
    }
    label264:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(c());
      return;
    }
  }
  
  protected View.OnClickListener a()
  {
    if (this.jdField_c_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_c_of_type_AndroidViewView$OnClickListener = new vmm(this);
    }
    return this.jdField_c_of_type_AndroidViewView$OnClickListener;
  }
  
  protected String a()
  {
    return "QCircleDefaultMessagePresenter";
  }
  
  public void a()
  {
    if (a() != null)
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(a());
      }
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAsyncTextView.setOnClickListener(b());
      }
    }
  }
  
  protected void a(uxk paramuxk, boolean paramBoolean) {}
  
  protected View.OnClickListener b()
  {
    return a();
  }
  
  public void b(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373945));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    b(paramStNotice);
  }
  
  protected View.OnClickListener c()
  {
    if (this.b == null) {
      this.b = new vmn(this);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmk
 * JD-Core Version:    0.7.0.1
 */