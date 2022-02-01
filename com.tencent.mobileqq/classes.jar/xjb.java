import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xjb
  extends QQUIEventReceiver<xin, vvh>
{
  public xjb(@NonNull xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull vvh paramvvh)
  {
    if (xin.a(paramxin) == null)
    {
      xvv.b(this.TAG, "ignore this troop nick name change event. %s.", paramvvh.toString());
      return;
    }
    xvv.a(this.TAG, "receive troop nick name change event. %s.", paramvvh.toString());
    xin.a(paramxin).c();
  }
  
  public Class acceptEventClass()
  {
    return vvh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjb
 * JD-Core Version:    0.7.0.1
 */