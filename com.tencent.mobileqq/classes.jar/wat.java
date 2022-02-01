import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.feed.QCircleGridFeedItemView;
import com.tencent.biz.qqcircle.widgets.feed.QCircleTimeLineFeedItemView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;

public class wat
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed;
  private Object jdField_a_of_type_JavaLangObject;
  
  public wat(QCircleTimeLineFeedItemView paramQCircleTimeLineFeedItemView, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131369125));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369116));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379644));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void a(Object paramObject, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = paramInt;
    wav localwav;
    Object localObject;
    if (((this.jdField_a_of_type_JavaLangObject instanceof wav)) && (this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView != null))
    {
      localwav = (wav)this.jdField_a_of_type_JavaLangObject;
      paramObject = localwav.jdField_a_of_type_FeedcloudFeedCloudMeta$StImage;
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.getLayoutParams();
      if (localwav.jdField_a_of_type_Int != 1002) {
        break label314;
      }
      ((ViewGroup.LayoutParams)localObject).width = (QCircleTimeLineFeedItemView.jdField_a_of_type_Int * 2);
      ((ViewGroup.LayoutParams)localObject).height = (QCircleTimeLineFeedItemView.jdField_a_of_type_Int * 2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = paramObject.picUrl.get();
      paramObject = URLDrawable.URLDrawableOptions.obtain();
      paramObject.mLoadingDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843922);
      paramObject.mFailedDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130844002);
      paramObject = "";
      if ((this.itemView.getTag(2131373857) instanceof String)) {
        paramObject = (String)this.itemView.getTag(2131373857);
      }
      this.itemView.setTag(2131373857, localObject);
      if (!paramObject.equals(localObject))
      {
        paramObject = new vou().a((String)localObject).a(this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView).b(false).a(true).c(QCircleGridFeedItemView.b).b(QCircleGridFeedItemView.b);
        QCircleFeedPicLoader.a().a(paramObject, new wau(this));
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        paramObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localwav.b <= 0) {
          break label344;
        }
        paramInt = 0;
        label265:
        paramObject.setVisibility(paramInt);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(localwav.b));
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        paramObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localwav.c != 3) {
          break label350;
        }
      }
    }
    label314:
    label344:
    label350:
    for (paramInt = i;; paramInt = 8)
    {
      paramObject.setVisibility(paramInt);
      return;
      if (localwav.jdField_a_of_type_Int != 1001) {
        break;
      }
      ((ViewGroup.LayoutParams)localObject).width = QCircleTimeLineFeedItemView.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject).height = QCircleTimeLineFeedItemView.jdField_a_of_type_Int;
      break;
      paramInt = 8;
      break label265;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    String str2 = uxx.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFeedQCircleTimeLineFeedItemView.getContext());
    if (uxx.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFeedQCircleTimeLineFeedItemView.getContext())) {}
    for (String str1 = "1";; str1 = "2")
    {
      vrf.a(str2, 11, 19, 3, str1, "", "", "", "");
      QCircleTimeLineFeedItemView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsFeedQCircleTimeLineFeedItemView, this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView, getLayoutPosition());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wat
 * JD-Core Version:    0.7.0.1
 */