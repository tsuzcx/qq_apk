import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.launchbean.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.RoundCorneredRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleDitto.StItemInfo;

public class wch
  extends vaf
  implements View.OnClickListener
{
  public static final int d = bdep.a(110.0F);
  public static final int e = bdep.a(220.0F);
  public static final int f = bdep.a(110.0F);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private URLImageView c;
  
  public wch(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373284));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373286));
    this.jdField_c_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373285));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373279));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373287));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373288));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373280));
    RoundCorneredRelativeLayout localRoundCorneredRelativeLayout = (RoundCorneredRelativeLayout)paramView.findViewById(2131373282);
    if (localRoundCorneredRelativeLayout != null)
    {
      int i = bhtq.a(10.0F);
      localRoundCorneredRelativeLayout.setRadius(i, i, i, i);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramView.setOnClickListener(new wci(this));
  }
  
  private void a()
  {
    int j = 0;
    Object localObject;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed != null)
    {
      localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.opMask2.get();
      if ((localObject == null) || (!((List)localObject).contains(Integer.valueOf(11))) || (uzg.a((FeedCloudMeta.StUser)this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.get()))) {}
    }
    for (int i = 1;; i = 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (i != 0) {}
      for (i = j;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        return;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      if (!TextUtils.isEmpty(localStItemInfo.id.get()))
      {
        Object localObject = new ArrayList();
        ((List)localObject).add(vtt.a("ext1", localStItemInfo.name.get()));
        ((List)localObject).add(vtt.a("ext3", (String)localStItemInfo.des.get().get(0)));
        vtn.a(localStItemInfo.id.get(), 3, 3, 96, 2, this.jdField_b_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, (List)localObject, this.jdField_c_of_type_Int, -1);
        localObject = new QCirclePolymerizationBean();
        ((QCirclePolymerizationBean)localObject).setTagInfo((FeedCloudMeta.StTagInfo)localStItemInfo.tag.get());
        ((QCirclePolymerizationBean)localObject).setPolymerizationType(7);
        ((QCirclePolymerizationBean)localObject).setExt1From(4);
        ((QCirclePolymerizationBean)localObject).setFromReportBean(a().clone().setElementIdStr("card"));
        uyx.a(paramContext, (QCirclePolymerizationBean)localObject);
        vud.a().a(new vuf().a("card").b("click").a(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed).a(a()).a(this.jdField_b_of_type_Int));
      }
    }
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
    if ((this.jdField_a_of_type_Vae != null) && ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo)))
    {
      this.jdField_a_of_type_Vae.a(this.jdField_a_of_type_JavaLangObject, 6);
      if (this.jdField_a_of_type_Vae.getItemCount() <= 0) {
        aaak.a().a(new QCircleFeedEvent(((FeedCloudMeta.StFeed)localObject).id.get(), 3));
      }
      localObject = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(vtt.a("ext1", ((QQCircleDitto.StItemInfo)localObject).name.get()));
      localArrayList.add(vtt.a("ext4", ((QQCircleDitto.StItemInfo)localObject).id.get()));
      vtn.a(((QQCircleDitto.StItemInfo)localObject).id.get(), 3, 3, 65, 1, this.jdField_b_of_type_Int, this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.id.get(), "", this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed.poster.id.get(), a(), this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed, localArrayList, this.jdField_c_of_type_Int, -1);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_JavaLangObject instanceof QQCircleDitto.StItemInfo))
    {
      paramObject = (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramObject.name.get());
      if ((paramObject.des.get() == null) || (paramObject.des.get().size() <= 0)) {
        break label249;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)paramObject.des.get().get(0));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((paramObject.images.get() == null) || (paramObject.images.get().size() < 3) || (this.jdField_a_of_type_ComTencentImageURLImageView == null) || (this.jdField_b_of_type_ComTencentImageURLImageView == null) || (this.jdField_c_of_type_ComTencentImageURLImageView == null)) {
        break label260;
      }
      a(((FeedCloudMeta.StImage)paramObject.images.get().get(0)).picUrl.get(), 2130844107, this.jdField_a_of_type_ComTencentImageURLImageView);
      a(((FeedCloudMeta.StImage)paramObject.images.get().get(1)).picUrl.get(), 2130844106, this.jdField_b_of_type_ComTencentImageURLImageView);
      a(((FeedCloudMeta.StImage)paramObject.images.get().get(2)).picUrl.get(), 2130844106, this.jdField_c_of_type_ComTencentImageURLImageView);
    }
    for (;;)
    {
      a();
      return;
      label249:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      break;
      label260:
      QLog.e("QCircleTagPageRecommendWidget", 4, "load error");
    }
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
      b();
      continue;
      a(paramView.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wch
 * JD-Core Version:    0.7.0.1
 */