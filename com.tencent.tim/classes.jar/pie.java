import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.QCircleInitBean.a;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoPositionLinkEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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

public class pie
  extends phl
  implements View.OnClickListener, rwx
{
  public URLImageView W;
  private pdd a;
  public FrameLayout aD;
  private RelativeLayout fM;
  public ImageView ms;
  public ImageView mt;
  
  private void r(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = oum.a(paramStFeed.id.get());
    paramStFeed = paramStFeed.cover.picUrl.get();
    if (localObject != null) {
      paramStFeed = ((FeedCloudMeta.StFeed)localObject).cover.picUrl.get();
    }
    for (;;)
    {
      localObject = "";
      if ((this.W.getTag(2131374526) instanceof String)) {
        localObject = (String)this.W.getTag(2131374526);
      }
      this.W.setTag(2131374526, paramStFeed);
      if (!((String)localObject).equals(paramStFeed))
      {
        paramStFeed = new QCircleFeedPicLoader.b().a(paramStFeed).a(this.W).b(false).a(true).b(this.W.getLayoutParams().width).a(this.W.getLayoutParams().height);
        QCircleFeedPicLoader.a().a(paramStFeed, null);
      }
      return;
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.mContainer = paramViewStub.inflate();
      this.fM = ((RelativeLayout)this.mContainer.findViewById(2131374533));
      this.ms = ((ImageView)this.mContainer.findViewById(2131374527));
      this.aD = ((FrameLayout)this.mContainer.findViewById(2131374525));
      this.aD.setOnClickListener(this);
      this.W = ((URLImageView)this.mContainer.findViewById(2131374526));
      this.ms.setVisibility(0);
      this.ms.setOnClickListener(this);
      this.mt = ((ImageView)this.mContainer.findViewById(2131374528));
      this.mt.setOnClickListener(this);
    }
  }
  
  public void b(pdd parampdd)
  {
    this.jdField_a_of_type_Pdd = parampdd;
  }
  
  public void bindData(Object paramObject, int paramInt)
  {
    this.mData = paramObject;
    this.mPos = paramInt;
    if ((this.mData instanceof FeedCloudMeta.StFeed))
    {
      this.b.mDataPosition = this.mPos;
      this.b.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.b.mPlayScene = 1;
      FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.mData;
      int k = localStFeed.video.width.get();
      int m = localStFeed.video.height.get();
      int j = ImmersiveUtils.getScreenWidth();
      int i = ImmersiveUtils.getScreenWidth();
      paramInt = i;
      if (k != 0)
      {
        paramInt = i;
        if (m != 0) {
          paramInt = ((Integer)ovd.a((FeedCloudMeta.StFeed)paramObject, k, m).second).intValue();
        }
      }
      this.fM.getLayoutParams().width = j;
      this.fM.getLayoutParams().height = paramInt;
      this.fM.setLayoutParams(this.fM.getLayoutParams());
      this.W.getLayoutParams().width = j;
      this.W.getLayoutParams().height = paramInt;
      this.W.setLayoutParams(this.W.getLayoutParams());
      this.W.setVisibility(0);
      if (QzoneConfig.isQQCircleAutoPlay()) {
        break label246;
      }
      this.ms.setVisibility(0);
    }
    for (;;)
    {
      this.mt.setVisibility(8);
      r((FeedCloudMeta.StFeed)this.mData);
      return;
      label246:
      this.ms.setVisibility(8);
    }
  }
  
  public void e(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof RecyclerView.ViewHolder)) && ((paramObject2 instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Pdd != null)) {
      this.jdField_a_of_type_Pdd.a((RecyclerView.ViewHolder)paramObject1, (FeedCloudMeta.StFeed)paramObject2);
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
      if (((this.mData instanceof FeedCloudMeta.StFeed)) && (this.mExtraTypeInfo != null) && (!HW()) && (this.jdField_a_of_type_Ovv != null))
      {
        Object localObject1 = new QQCircleFeedBase.StFeedListBusiReqData();
        ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tabAttachInfo.set(this.jdField_a_of_type_Ovv.lT());
        Object localObject2 = this.jdField_a_of_type_Ovv.b();
        if (localObject2 != null)
        {
          ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagId.set(((QCircleInitBean)localObject2).getTagInfo().tagId.get());
          ((QQCircleFeedBase.StFeedListBusiReqData)localObject1).tagName.set(((QCircleInitBean)localObject2).getTagInfo().tagName.get());
        }
        localObject2 = new QCircleInitBean.a();
        ((QCircleInitBean.a)localObject2).a((FeedCloudMeta.StFeed)this.mData);
        ((QCircleInitBean.a)localObject2).a(this.mExtraTypeInfo.pageType);
        ((QCircleInitBean.a)localObject2).a((QQCircleFeedBase.StFeedListBusiReqData)localObject1);
        localObject1 = ((QCircleInitBean.a)localObject2).a();
        if (this.jdField_a_of_type_Pdd != null)
        {
          ((QCircleInitBean)localObject1).mDataPosInList = this.jdField_a_of_type_Pdd.sd();
          ((QCircleInitBean)localObject1).mVideoCurrentPosition = this.jdField_a_of_type_Pdd.dw();
        }
        oux.a(paramView.getContext(), (QCircleInitBean)localObject1, pdk.a(this.W, ((FeedCloudMeta.StFeed)this.mData).cover.width.get(), ((FeedCloudMeta.StFeed)this.mData).cover.height.get()));
        pcl.a(8, 2, this.b);
        rwv.a().a(this);
        continue;
        if ((this.jdField_a_of_type_Pdd != null) && ((this.mData instanceof FeedCloudMeta.StFeed)))
        {
          this.jdField_a_of_type_Pdd.a(this, (FeedCloudMeta.StFeed)this.mData);
          continue;
          if ((this.jdField_a_of_type_Pdd != null) && ((this.mData instanceof FeedCloudMeta.StFeed))) {
            this.jdField_a_of_type_Pdd.a((FeedCloudMeta.StFeed)this.mData, this.mt, this.mPos);
          }
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedVideoPositionLinkEvent)) && (this.jdField_a_of_type_Pdd != null)) {
      this.jdField_a_of_type_Pdd.I(((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mFeedUrl, ((QCircleFeedVideoPositionLinkEvent)paramSimpleBaseEvent).mCurrentPlayPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pie
 * JD-Core Version:    0.7.0.1
 */