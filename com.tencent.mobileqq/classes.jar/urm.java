import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class urm
  extends QQUIEventReceiver<uqy, tdm>
{
  public urm(@NonNull uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull tdm paramtdm)
  {
    if (uqy.a(paramuqy) == null)
    {
      veg.b(this.TAG, "ignore this troop nick name change event. %s.", paramtdm.toString());
      return;
    }
    veg.a(this.TAG, "receive troop nick name change event. %s.", paramtdm.toString());
    uqy.a(paramuqy).c();
  }
  
  public Class acceptEventClass()
  {
    return tdm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urm
 * JD-Core Version:    0.7.0.1
 */