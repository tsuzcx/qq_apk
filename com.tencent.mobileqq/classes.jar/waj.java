import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
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

public class waj
  extends vzj
  implements View.OnClickListener, zwr
{
  private RelativeLayout a;
  
  public QCircleInitBean a()
  {
    if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Uzb != null))
    {
      Object localObject1 = new QQCircleFeedBase.StFeedListBusiReqData();
      ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tabAttachInfo.set(this.jdField_a_of_type_Uzb.a());
      Object localObject2 = this.jdField_a_of_type_Uzb.a();
      if (localObject2 != null)
      {
        ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagId.set(((QCircleInitBean)localObject2).getTagInfo().tagId.get());
        ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagName.set(((QCircleInitBean)localObject2).getTagInfo().tagName.get());
      }
      localObject2 = new uxk();
      ((uxk)localObject2).a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      ((uxk)localObject2).a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
      ((uxk)localObject2).a((QQCircleFeedBase.StFeedListBusiReqData)localObject1);
      ((uxk)localObject2).a(a().clone().setElementIdStr("content"));
      localObject1 = ((uxk)localObject2).a();
      if (this.jdField_a_of_type_Vsc != null)
      {
        ((QCircleInitBean)localObject1).mDataPosInList = 0;
        ((QCircleInitBean)localObject1).mVideoCurrentPosition = this.jdField_a_of_type_Vsc.a();
      }
      return localObject1;
    }
    return null;
  }
  
  protected String a()
  {
    return "QCircleFeedItemVideoPresenter";
  }
  
  public void a()
  {
    zwp.a().b(this);
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373818));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373812));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373810));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373811));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.b = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373813));
      this.b.setOnClickListener(this);
      this.c = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373859));
      this.c.setOnClickListener(this);
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
          paramInt = ((Integer)uxx.a((FeedCloudMeta.StFeed)paramObject, k, m).second).intValue();
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
        break label302;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.b.setVisibility(8);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      try
      {
        paramObject = new QQCircleFeedBase.StVideoBusiData();
        paramObject.mergeFrom(localStFeed.video.busiData.get().toByteArray());
        if ((paramObject.simulate_date != null) && (paramObject.simulate_date.is_show_button.get() == 1))
        {
          this.c.setVisibility(0);
          return;
          label302:
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        else
        {
          this.c.setVisibility(8);
          return;
        }
      }
      catch (Exception paramObject)
      {
        QLog.e("QCircleFeedItemVideoPresenter", 1, "exception:", paramObject);
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
      if (((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (!c()) && (this.jdField_a_of_type_Uzb != null))
      {
        Object localObject = a();
        uxo.a(paramView.getContext(), (QCircleInitBean)localObject, vsn.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.width.get(), ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.height.get()));
        vrc.a(8, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
        zwp.a().a(this);
        continue;
        if ((this.jdField_a_of_type_Vsc != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
        {
          this.jdField_a_of_type_Vsc.a(this, (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
          continue;
          if ((this.jdField_a_of_type_Vsc != null) && ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)))
          {
            this.jdField_a_of_type_Vsc.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject, this.b, this.jdField_a_of_type_Int);
            continue;
            if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
            {
              try
              {
                localObject = new QQCircleFeedBase.StVideoBusiData();
                ((QQCircleFeedBase.StVideoBusiData)localObject).mergeFrom(((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).video.busiData.get().toByteArray());
                if ((((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date == null) || (((QQCircleFeedBase.StVideoBusiData)localObject).simulate_date.is_show_button.get() != 1) || (Build.VERSION.SDK_INT < 21)) {
                  break label374;
                }
                this.c.setVisibility(0);
                this.c.setOnClickListener(new wak(this, (QQCircleFeedBase.StVideoBusiData)localObject));
                vrc.a(86, 1, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo, b());
              }
              catch (Exception localException)
              {
                QLog.e("QCircleFeedItemVideoPresenter", 1, "exception:", localException);
              }
              continue;
              label374:
              this.c.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.jdField_a_of_type_Vsc != null)) {
      this.jdField_a_of_type_Vsc.a(((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mFeedUrl, ((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     waj
 * JD-Core Version:    0.7.0.1
 */