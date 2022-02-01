import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;

public abstract class wcz
  extends wcw
{
  public FrameLayout a;
  public ImageView a;
  public SeekBar a;
  public TextView a;
  public QCirclePaiTongKuanIconView a;
  public URLImageView a;
  public vup a;
  public View b;
  public ImageView b;
  
  protected void a(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject = uyn.a(paramStFeed.id.get());
    paramStFeed = paramStFeed.cover.picUrl.get();
    if (localObject != null) {
      paramStFeed = ((FeedCloudMeta.StFeed)localObject).cover.picUrl.get();
    }
    for (;;)
    {
      localObject = "";
      if ((this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373939) instanceof String)) {
        localObject = (String)this.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131373939);
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131373939, paramStFeed);
      if (!((String)localObject).equals(paramStFeed))
      {
        paramStFeed = new vrd().a(paramStFeed).a(this.jdField_a_of_type_ComTencentImageURLImageView).b(false).a(true).c(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().width).b(this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams().height);
        QCircleFeedPicLoader.a().a(paramStFeed, new wda(this));
      }
      return;
    }
  }
  
  public void a(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof RecyclerView.ViewHolder)) && ((paramObject2 instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_Vup != null)) {
      this.jdField_a_of_type_Vup.a((RecyclerView.ViewHolder)paramObject1, (FeedCloudMeta.StFeed)paramObject2);
    }
  }
  
  public void a(vup paramvup)
  {
    this.jdField_a_of_type_Vup = paramvup;
  }
  
  public void a(boolean paramBoolean)
  {
    float f2 = 0.8F;
    Object localObject;
    if (this.b != null)
    {
      localObject = this.b;
      if (paramBoolean)
      {
        f1 = 0.8F;
        ((ImageView)localObject).setAlpha(f1);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (float f1 = f2;; f1 = 1.0F)
    {
      ((TextView)localObject).setAlpha(f1);
      return;
      f1 = 1.0F;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcz
 * JD-Core Version:    0.7.0.1
 */