import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudMeta.StVideo;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class udu
  extends ucz
  implements View.OnClickListener
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
      if ((this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373145) instanceof String)) {
        localObject = (String)this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373145);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131373145, paramStFeed);
      if (!((String)localObject).equals(paramStFeed)) {
        tql.a(paramStFeed, this.jdField_a_of_type_ComTencentImageURLImageView, null, bdcs.c(paramStFeed));
      }
      return;
    }
  }
  
  public void a(ViewStub paramViewStub)
  {
    if (paramViewStub != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramViewStub.inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373152));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373146));
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131373144));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373145));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373147));
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
            break label261;
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
      if (!bdee.c(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext())) {
        break label302;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
      label261:
      if ((f > this.jdField_b_of_type_Float) && (f <= this.jdField_a_of_type_Float))
      {
        paramInt = (int)(j / f);
        break;
      }
      paramInt = (int)(j / this.jdField_b_of_type_Float);
      break;
      label302:
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
        } while ((!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)) || (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo == null) || (c()) || (this.jdField_a_of_type_Trr == null));
        paramView = new QQCircleFeedBase.StFeedListBusiReqData();
        paramView.tabAttachInfo.set(this.jdField_a_of_type_Trr.a());
        Object localObject = this.jdField_a_of_type_Trr.a();
        if (localObject != null)
        {
          paramView.tagId.set(((QCircleInitBean)localObject).getTagInfo().tagId.get());
          paramView.tagName.set(((QCircleInitBean)localObject).getTagInfo().tagName.get());
        }
        localObject = new tqo();
        ((tqo)localObject).a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
        ((tqo)localObject).a(this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.pageType);
        ((tqo)localObject).a(paramView);
        paramView = ((tqo)localObject).a();
        if (this.jdField_a_of_type_Tqc != null)
        {
          paramView.mDataPosInList = this.jdField_a_of_type_Tqc.a();
          paramView.mVideoCurrentPosition = this.jdField_a_of_type_Tqc.a();
        }
        tqs.a(paramView, null);
        tyg.a(8, 2, this.jdField_a_of_type_ComTencentBizQqcircleReportReportExtraTypeInfo);
        return;
      } while ((this.jdField_a_of_type_Tqc == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)));
      this.jdField_a_of_type_Tqc.a(this, (FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject);
      return;
    } while ((this.jdField_a_of_type_Tqc == null) || (!(this.jdField_a_of_type_JavaLangObject instanceof FeedCloudMeta.StFeed)));
    this.jdField_a_of_type_Tqc.a((FeedCloudMeta.StFeed)this.jdField_a_of_type_JavaLangObject, this.jdField_b_of_type_AndroidWidgetImageView, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     udu
 * JD-Core Version:    0.7.0.1
 */