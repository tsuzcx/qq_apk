import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;

public class uhb
  extends ugz
{
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private View c;
  
  public uhb(int paramInt)
  {
    super(paramInt);
  }
  
  private QCircleInitBean a()
  {
    try
    {
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed.get() != null)
      {
        Object localObject = new tqo();
        ubd.a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed, 3);
        ((tqo)localObject).a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StNotice.feed);
        ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
        localExtraTypeInfo.sourceType = 1002;
        ((tqo)localObject).a(localExtraTypeInfo);
        a((tqo)localObject);
        localObject = ((tqo)localObject).a();
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
  
  private void a(FeedCloudMeta.StNotice paramStNotice)
  {
    ImageView localImageView;
    if (!TextUtils.isEmpty(paramStNotice.feed.cover.picUrl.get()))
    {
      if ((this.c == null) && (this.jdField_a_of_type_AndroidViewViewStub != null)) {
        this.c = this.jdField_a_of_type_AndroidViewViewStub.inflate();
      }
      if (this.c != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)this.c.findViewById(2131368778));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.c.findViewById(2131368782));
        this.c.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setRoundRect(20);
        tql.a(paramStNotice.feed.cover.picUrl.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (!tra.b(paramStNotice.feed)) {
          break label158;
        }
      }
    }
    label158:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      this.c.setOnClickListener(new uhc(this));
      return;
    }
  }
  
  protected void a(tqo paramtqo) {}
  
  public void b(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView.findViewById(2131373250));
  }
  
  public void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    a(paramStNotice);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhb
 * JD-Core Version:    0.7.0.1
 */