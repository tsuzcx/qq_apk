import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class ugu
  extends uga
  implements View.OnClickListener, yiy
{
  private float jdField_a_of_type_Float = 1.777778F;
  public FrameLayout a;
  public ImageView a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public URLImageView a;
  private tqc jdField_a_of_type_Tqc;
  private float jdField_b_of_type_Float = 0.75F;
  private int jdField_b_of_type_Int = ImmersiveUtils.a();
  public ImageView b;
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = tqg.a(paramStFeed.id.get());
    paramStFeed = paramStFeed.cover.picUrl.get();
    if (localObject != null) {
      paramStFeed = ((FeedCloudMeta.StFeed)localObject).cover.picUrl.get();
    }
    for (;;)
    {
      localObject = "";
      if ((this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373174) instanceof String)) {
        localObject = (String)this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373174);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131373174, paramStFeed);
      if (!((String)localObject).equals(paramStFeed)) {
        tql.a(paramStFeed, this.jdField_a_of_type_ComTencentImageURLImageView, null, bdhb.c(paramStFeed));
      }
      return;
    }
  }
  
  public void a()
  {
    yiw.a().b(this);
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373181));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373175));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373173));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373174));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373176));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    int j;
    float f;
    if ((this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mDataPosition = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo.mPlayScene = 1;
      paramObject = (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject;
      int k = paramObject.video.width.get();
      int m = paramObject.video.height.get();
      j = this.jdField_b_of_type_Int;
      int i = this.jdField_b_of_type_Int;
      paramInt = i;
      if (k != 0)
      {
        paramInt = i;
        if (m != 0)
        {
          f = k / m;
          if (f < this.jdField_a_of_type_Float) {
            break label254;
          }
          paramInt = (int)(j / this.jdField_a_of_type_Float);
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
        break label295;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
      label254:
      if ((f > this.jdField_b_of_type_Float) && (f <= this.jdField_a_of_type_Float))
      {
        paramInt = (int)(j / f);
        break;
      }
      paramInt = (int)(j / this.jdField_b_of_type_Float);
      break;
      label295:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof RecyclerView.ViewHolder)) && ((paramObject2 instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Tqc != null)) {
      this.jdField_a_of_type_Tqc.a((RecyclerView.ViewHolder)paramObject1, (FeedCloudMeta.StFeed)paramObject2);
    }
  }
  
  public void a(tqc paramtqc)
  {
    this.jdField_a_of_type_Tqc = paramtqc;
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
    do
    {
      do
      {
        do
        {
          return;
        } while ((!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (c()) || (this.jdField_a_of_type_Trw == null));
        Object localObject1 = new QQCircleFeedBase.StFeedListBusiReqData();
        ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tabAttachInfo.set(this.jdField_a_of_type_Trw.a());
        Object localObject2 = this.jdField_a_of_type_Trw.a();
        if (localObject2 != null)
        {
          ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagId.set(((QCircleInitBean)localObject2).getTagInfo().tagId.get());
          ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagName.set(((QCircleInitBean)localObject2).getTagInfo().tagName.get());
        }
        localObject2 = new tqo();
        ((tqo)localObject2).a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
        ((tqo)localObject2).a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
        ((tqo)localObject2).a((QQCircleFeedBase.StFeedListBusiReqData)localObject1);
        localObject1 = ((tqo)localObject2).a();
        if (this.jdField_a_of_type_Tqc != null)
        {
          ((QCircleInitBean)localObject1).mDataPosInList = this.jdField_a_of_type_Tqc.a();
          ((QCircleInitBean)localObject1).mVideoCurrentPosition = this.jdField_a_of_type_Tqc.a();
        }
        tqs.a(paramView.getContext(), (QCircleInitBean)localObject1, uaj.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.width.get(), ((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject).cover.height.get()));
        tzs.a(8, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
        yiw.a().a(this);
        return;
      } while ((this.jdField_a_of_type_Tqc == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)));
      this.jdField_a_of_type_Tqc.a(this, (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
    } while ((this.jdField_a_of_type_Tqc == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)));
    this.jdField_a_of_type_Tqc.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.jdField_a_of_type_Tqc != null)) {
      this.jdField_a_of_type_Tqc.a(((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mFeedUrl, ((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ugu
 * JD-Core Version:    0.7.0.1
 */