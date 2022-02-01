import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StShare;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.io.File;
import qqcircle.QQCircleFeedBase.StFashionCopyPageData;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase.StGpsPageData;
import qqcircle.QQCircleFeedBase.StTagPageData;

public class vel
  extends vbk
  implements View.OnClickListener
{
  private static aaaf jdField_a_of_type_Aaaf = new aaaf();
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCirclePolymerizationBean jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean;
  private FeedCloudMeta.StShare jdField_a_of_type_FeedcloudFeedCloudMeta$StShare;
  private QQCircleFeedBase.StFeedListBusiRspData jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData;
  private vxh jdField_a_of_type_Vxh;
  private ImageView b;
  private ImageView c;
  
  static
  {
    jdField_a_of_type_Aaaf.a(new aaai("https://downv6.qq.com/video_story/qcircle/pic/background/img_worldbg.png", uyk.a()));
    jdField_a_of_type_Aaaf.a(new aaai("https://downv6.qq.com/video_story/qcircle/pic/background/img_lbsbg.png", uyk.a()));
    jdField_a_of_type_Aaaf.a(new aaai("https://downv6.qq.com/video_story/qcircle/pic/background/img_fliterbg.png", uyk.a()));
    jdField_a_of_type_Aaaf.a();
  }
  
  public vel(QCirclePolymerizationBean paramQCirclePolymerizationBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean = paramQCirclePolymerizationBean;
  }
  
  private String a(String paramString)
  {
    return aaae.a(uyk.a()).a(paramString);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean == null) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType())
    {
    default: 
      return;
    case 7: 
      this.jdField_a_of_type_Int = 4;
      a("https://downv6.qq.com/video_story/qcircle/pic/background/img_worldbg.png");
      return;
    case 16: 
      this.jdField_a_of_type_Int = 5;
      a("https://downv6.qq.com/video_story/qcircle/pic/background/img_lbsbg.png");
      return;
    }
    this.jdField_a_of_type_Int = 6;
    a("https://downv6.qq.com/video_story/qcircle/pic/background/img_fliterbg.png");
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView != null)
    {
      paramImageView.setVisibility(0);
      Object localObject = paramImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ImmersiveUtils.a();
      ((ViewGroup.LayoutParams)localObject).height = ((int)(((ViewGroup.LayoutParams)localObject).width * 0.47D));
      paramImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ColorDrawable localColorDrawable = new ColorDrawable(a().getResources().getColor(2131167247));
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramImageView.getMeasuredWidth();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramImageView.getMeasuredHeight();
      QLog.d("QCirclePolymerizationClipPart", 1, "options.mRequestWidth =" + ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth + "options.mRequestHeight =" + ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight);
      paramImageView.setImageDrawable(URLDrawable.getFileDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject));
    }
  }
  
  private void a(QQCircleFeedBase.StFeedListBusiRspData paramStFeedListBusiRspData)
  {
    if (paramStFeedListBusiRspData == null) {}
    do
    {
      return;
      this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData = paramStFeedListBusiRspData;
    } while (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean == null);
    switch (this.jdField_a_of_type_ComTencentBizQqcircleLaunchbeanQCirclePolymerizationBean.getPolymerizationType())
    {
    default: 
      return;
    case 7: 
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StShare = ((FeedCloudMeta.StShare)this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.shareInfo.get());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData.tagPageData.tagInfo.tagName.get());
      return;
    case 16: 
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StShare = ((FeedCloudMeta.StShare)this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData.gpsPageData.shareInfo.get());
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData.gpsPageData.poiName.get());
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StShare = ((FeedCloudMeta.StShare)this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData.fashionCopyPageData.shareInfo.get());
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_QqcircleQQCircleFeedBase$StFeedListBusiRspData.fashionCopyPageData.pageDesc.get());
    a("https://downv6.qq.com/video_story/qcircle/pic/background/img_fliterbg.png");
  }
  
  public String a()
  {
    return "QCirclePolymerizationClipPart";
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380141));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369134));
    this.b = ((ImageView)paramView.findViewById(2131369375));
    this.c = ((ImageView)paramView.findViewById(2131369236));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381051);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131376873));
    int i = ImmersiveUtils.getStatusBarHeight(paramView.getContext());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    int j = zps.a(paramView.getContext(), 52.0F) + i;
    paramView = localLayoutParams;
    if (localLayoutParams == null) {
      paramView = new ViewGroup.LayoutParams(-1, j);
    }
    paramView.height = j;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setPadding(0, i, 0, 0);
    this.jdField_a_of_type_Vxh = ((vxh)a(vxh.class));
    this.jdField_a_of_type_Vxh.b.observe(a(), new vem(this));
    a();
  }
  
  protected void a(String paramString)
  {
    if ((this.c == null) || (TextUtils.isEmpty(paramString))) {}
    String str;
    do
    {
      return;
      str = a(paramString);
    } while (aaae.a(uyk.a()).b(paramString));
    if (new File(str).exists())
    {
      a(this.c, str);
      return;
    }
    aaae.a(uyk.a()).a(paramString, new ven(this));
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i;
    if ((TextUtils.equals(paramString, "polymerization_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      i = ((Message)paramObject).what;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.argb(i, 250, 250, 251));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, 250, 250, 251));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 0, 0, 0));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (i != 0) {
        break label123;
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label123:
    while (i != 255) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(a().getResources().getColor(2131166234));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(a().getResources().getColor(2131166234));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((!a().onBackEvent()) && (a() != null))
      {
        a().finish();
        continue;
        if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StShare != null)
        {
          vbd localvbd = new vbd();
          localvbd.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          FeedCloudMeta.StFeed localStFeed = new FeedCloudMeta.StFeed();
          localStFeed.share.set(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StShare);
          localvbd.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = localStFeed;
          b("share_action_show_share_sheet", localvbd);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vel
 * JD-Core Version:    0.7.0.1
 */