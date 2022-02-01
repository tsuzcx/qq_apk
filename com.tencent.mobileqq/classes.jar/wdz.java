import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;
import qqcircle.QQCircleFeedBase.StSimulateData;
import qqcircle.QQCircleFeedBase.StVideoBusiData;

public class wdz
  extends wcz
  implements aaam, View.OnClickListener
{
  private RelativeLayout a;
  
  public QCircleLayerBean a()
  {
    if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Var != null))
    {
      QQCircleFeedBase.StFeedListBusiReqData localStFeedListBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
      localStFeedListBusiReqData.tabAttachInfo.set(this.jdField_a_of_type_Var.a());
      Object localObject = this.jdField_a_of_type_Var.a();
      if (localObject != null)
      {
        localStFeedListBusiReqData.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
        localStFeedListBusiReqData.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
      }
      localObject = new QCircleLayerBean();
      ((QCircleLayerBean)localObject).setFeed((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      ((QCircleLayerBean)localObject).setSourceType(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
      ((QCircleLayerBean)localObject).setFeedListBusiReqData(localStFeedListBusiReqData);
      ((QCircleLayerBean)localObject).setFromReportBean(a().clone().setElementIdStr("content"));
      if (this.jdField_a_of_type_Vup != null)
      {
        ((QCircleLayerBean)localObject).setDataPosInList(0);
        ((QCircleLayerBean)localObject).setVideoCurrentPosition(this.jdField_a_of_type_Vup.a());
      }
      return localObject;
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleFeedItemVideoPresenter";
  }
  
  public void a()
  {
    aaak.a().b(this);
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373948));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373940));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373938));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373939));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373941));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView = ((QCirclePaiTongKuanIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373992));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373943));
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131373942));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131373936);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    FeedCloudMeta.StFeed localStFeed;
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      localStFeed = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      int k = localStFeed.video.width.get();
      int m = localStFeed.video.height.get();
      int j = ImmersiveUtils.a();
      int i = ImmersiveUtils.a();
      paramInt = i;
      if (k != 0)
      {
        paramInt = i;
        if (m != 0) {
          paramInt = ((Integer)vwk.a((FeedCloudMeta.StFeed)paramObject, k, m).second).intValue();
        }
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = j;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = paramInt;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width = j;
      this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height = paramInt;
      this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams());
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      if (QzoneConfig.isQQCircleAutoPlay()) {
        break label341;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      try
      {
        paramObject = new QQCircleFeedBase.StVideoBusiData();
        paramObject.mergeFrom(localStFeed.video.busiData.get().toByteArray());
        if ((paramObject.simulate_date.get() != null) && (paramObject.simulate_date.is_show_button.get() == 1))
        {
          paramObject = paramObject.simulate_date.simulate_name.get();
          if (paramObject.equals("")) {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.a();
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setVisibility(0);
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setOnClickListener(this);
            return;
            label341:
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break;
            this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setTongKuanText(paramObject);
          }
        }
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setVisibility(8);
      }
      catch (Exception paramObject)
      {
        QLog.e("QCircleFeedItemVideoPresenter", 1, "exception:", paramObject);
        return;
      }
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedVideoPositionLinkEvent.class);
    return localArrayList;
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
      if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Var != null))
      {
        Object localObject = a();
        vvh.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.width.get(), ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.height.get(), (QCircleLayerBean)localObject);
        uyx.a(paramView.getContext(), (QCircleLayerBean)localObject);
        vtn.a(8, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        aaak.a().a(this);
        continue;
        if ((this.jdField_a_of_type_Vup != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
        {
          this.jdField_a_of_type_Vup.a(this, (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          continue;
          if ((this.jdField_a_of_type_Vup != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
          {
            this.jdField_a_of_type_Vup.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int);
            continue;
            if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
            {
              try
              {
                localObject = new QQCircleFeedBase.StVideoBusiData();
                ((QQCircleFeedBase.StVideoBusiData)localObject).mergeFrom(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).video.busiData.get().toByteArray());
                if ((((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date == null) || (((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.is_show_button.get() != 1) || (Build.VERSION.SDK_INT < 21)) {
                  break label375;
                }
                this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setVisibility(0);
                this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setOnClickListener(new wea(this, (QQCircleFeedBase.StVideoBusiData)localObject));
                vtn.a(86, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
              }
              catch (Exception localException)
              {
                QLog.e("QCircleFeedItemVideoPresenter", 1, "exception:", localException);
              }
              continue;
              label375:
              this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePaiTongKuanIconView.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.jdField_a_of_type_Vup != null)) {
      this.jdField_a_of_type_Vup.a(((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mFeedUrl, ((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdz
 * JD-Core Version:    0.7.0.1
 */