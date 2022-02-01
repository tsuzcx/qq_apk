import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import feedcloud.FeedCloudMeta.StFeed;

class uyz
  extends RecyclerView.ViewHolder
  implements zvo
{
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
  private uza jdField_a_of_type_Uza = new uza(this);
  
  public uyz(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder paramViewHolder)
  {
    return this.jdField_a_of_type_Uza.a(paramViewHolder);
  }
  
  public ViewPropertyAnimatorCompat a(zvx paramzvx, long paramLong, boolean paramBoolean)
  {
    return this.jdField_a_of_type_Uza.a(paramzvx, paramLong, paramBoolean);
  }
  
  public ViewPropertyAnimatorCompat a(zvy paramzvy, long paramLong)
  {
    return this.jdField_a_of_type_Uza.a(paramzvy, paramLong);
  }
  
  public void a(Object paramObject, int paramInt, ExtraTypeInfo paramExtraTypeInfo, uzb paramuzb)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setInteractor(paramuzb);
      ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
    }
  }
  
  public boolean a(zvx paramzvx)
  {
    return this.jdField_a_of_type_Uza.a(paramzvx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uyz
 * JD-Core Version:    0.7.0.1
 */