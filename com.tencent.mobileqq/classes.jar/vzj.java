import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;

public abstract class vzj
  extends vzg
{
  public FrameLayout a;
  public ImageView a;
  public URLImageView a;
  public vsc a;
  public ImageView b;
  public ImageView c;
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = uxc.a(paramStFeed.id.get());
    paramStFeed = paramStFeed.cover.picUrl.get();
    if (localObject != null) {
      paramStFeed = ((FeedCloudMeta.StFeed)localObject).cover.picUrl.get();
    }
    for (;;)
    {
      localObject = "";
      if ((this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373811) instanceof String)) {
        localObject = (String)this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373811);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131373811, paramStFeed);
      if (!((String)localObject).equals(paramStFeed))
      {
        paramStFeed = new vou().a(paramStFeed).a(this.jdField_a_of_type_ComTencentImageURLImageView).b(false).a(true).c(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width).b(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height);
        QCircleFeedPicLoader.a().a(paramStFeed, new vzk(this));
      }
      return;
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof RecyclerView.ViewHolder)) && ((paramObject2 instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Vsc != null)) {
      this.jdField_a_of_type_Vsc.a((RecyclerView.ViewHolder)paramObject1, (FeedCloudMeta.StFeed)paramObject2);
    }
  }
  
  public void a(vsc paramvsc)
  {
    this.jdField_a_of_type_Vsc = paramvsc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzj
 * JD-Core Version:    0.7.0.1
 */