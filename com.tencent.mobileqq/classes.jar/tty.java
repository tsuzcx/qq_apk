import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StTagInfo;

public class tty
  extends tvv
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo;
  private ubx jdField_a_of_type_Ubx;
  private ImageView b;
  
  public tty(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (paramStTagInfo == null) {
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = paramStTagInfo;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStTagInfo.tagName.get());
  }
  
  public String a()
  {
    return "QCircleTagPageTitleBarPart";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377958);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379043));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368709));
    this.b = ((ImageView)paramView.findViewById(2131368911));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_Ubx = ((ubx)a(ubx.class));
    this.jdField_a_of_type_Ubx.b.observe(a(), new ttz(this));
    if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
      a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i;
    if ((TextUtils.equals(paramString, "tag_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      i = ((Message)paramObject).what;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, 235, 236, 240));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 0, 0, 0));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (i != 0) {
        break label94;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label94:
    while (i != 255) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(a().getResources().getColor(2131166178));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while ((a().onBackEvent()) || (a() == null));
      a().finish();
      return;
    } while (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null);
    paramView = new trz();
    paramView.jdField_a_of_type_Int = 3;
    FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
    localStFeed.share.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.shareInfo.get());
    paramView.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = localStFeed;
    b("share_action_show_share_sheet", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tty
 * JD-Core Version:    0.7.0.1
 */