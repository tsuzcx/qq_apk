import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import feedcloud.FeedCloudMeta.StFeed;

class vam
  extends RecyclerView.ViewHolder
  implements zzj
{
  private FeedCloudMeta.StFeed jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = new FeedCloudMeta.StFeed();
  private vaq jdField_a_of_type_Vaq = new vaq(this);
  
  public vam(BaseWidgetView paramBaseWidgetView)
  {
    super(paramBaseWidgetView);
  }
  
  public ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder paramViewHolder)
  {
    return this.jdField_a_of_type_Vaq.a(paramViewHolder);
  }
  
  public ViewPropertyAnimatorCompat a(zzs paramzzs, long paramLong, boolean paramBoolean)
  {
    return this.jdField_a_of_type_Vaq.a(paramzzs, paramLong, paramBoolean);
  }
  
  public ViewPropertyAnimatorCompat a(zzt paramzzt, long paramLong)
  {
    return this.jdField_a_of_type_Vaq.a(paramzzt, paramLong);
  }
  
  public void a(Object paramObject, int paramInt, ExtraTypeInfo paramExtraTypeInfo, var paramvar)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      this.itemView.setTag(this);
      ((BaseWidgetView)this.itemView).setInteractor(paramvar);
      ((BaseWidgetView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
      ((BaseWidgetView)this.itemView).setData(paramObject, paramInt);
    }
  }
  
  public boolean a(zzs paramzzs)
  {
    return this.jdField_a_of_type_Vaq.a(paramzzs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vam
 * JD-Core Version:    0.7.0.1
 */