import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.qqcircle.requests.QCircleGetRankingListRequest;
import com.tencent.biz.qqcircle.widgets.QCircleFuelTopView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.event.TagDescPublishEvent;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StRankingItem;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudRead.StGetRankingListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vdq
  extends uzu
  implements View.OnClickListener, zwr
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleFuelTopView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelTopView;
  private List<FeedCloudMeta.StRankingItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private TextView b;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    zwp.a().a(this);
  }
  
  private void a(View paramView, FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    paramView = ((ViewStub)paramView.findViewById(2131381074)).inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369253));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370160));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379935));
    this.b = ((TextView)paramView.findViewById(2131379936));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376725));
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelTopView = new QCircleFuelTopView(a());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelTopView.setReportBean(a());
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelTopView.setParentPart(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStTagInfo.tagName.get());
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    paramStTagInfo = new QCircleGetRankingListRequest(paramStTagInfo.tagName.get());
    VSNetworkHelper.a().a(paramStTagInfo, new vdr(this, paramStTagInfo));
  }
  
  private void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetRankingListRsp paramStGetRankingListRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramStGetRankingListRsp.items.get());
      if (paramStGetRankingListRsp.items.size() >= 3)
      {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelTopView.a(paramStGetRankingListRsp);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      }
    }
  }
  
  private void b()
  {
    vrg.a(89, 1, a(), b());
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FeedCloudMeta.StRankingItem localStRankingItem = (FeedCloudMeta.StRankingItem)localIterator.next();
      vrg.a(89, 8, a(), b(), localStRankingItem.user.id.get());
      if (localStRankingItem.user.followState.get() != 1) {
        vrg.a(89, 9, a(), b(), localStRankingItem.user.id.get());
      }
    }
    g();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
      d();
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(this.b, 0, vtu.a(20.0F));
    e();
  }
  
  private void c()
  {
    h();
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    f();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFuelTopView, -1, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131755894);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 0.0F, 1.0F }).setDuration(250L).start();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetLinearLayout, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
      localObjectAnimator.addListener(new vds(this));
      localObjectAnimator.start();
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, 180.0F }).setDuration(250L).start();
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "rotation", new float[] { 180.0F, 0.0F }).setDuration(200L).start();
    }
  }
  
  public ReportExtraTypeInfo a()
  {
    return (ReportExtraTypeInfo)b("get_report_extra_type_info", "");
  }
  
  public String a()
  {
    return null;
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    FeedCloudMeta.StTagInfo localStTagInfo = ((QCircleInitBean)a().getIntent().getSerializableExtra("key_bundle_common_init_bean")).getTagInfo();
    if (localStTagInfo.has())
    {
      a(paramView, localStTagInfo);
      a();
      a(localStTagInfo);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
    {
      c();
      return true;
    }
    return super.a();
  }
  
  protected String b()
  {
    return "fuellist";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(TagDescPublishEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    zwp.a().b(this);
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    QLog.d("QCircleTagHeaderPart", 1, "onClick , view id: " + i);
    switch (i)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vrg.a(88, 2, a(), b());
      if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing()))
      {
        c();
      }
      else
      {
        b();
        continue;
        if ((this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {
          c();
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof TagDescPublishEvent))
    {
      paramSimpleBaseEvent = (TagDescPublishEvent)paramSimpleBaseEvent;
      if (!TextUtils.isEmpty(paramSimpleBaseEvent.mTagDesc)) {
        this.b.setText(paramSimpleBaseEvent.mTagDesc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdq
 * JD-Core Version:    0.7.0.1
 */