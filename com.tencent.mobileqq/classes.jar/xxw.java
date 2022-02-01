import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xxw
  extends QQUIEventReceiver<xxi, wkc>
{
  public xxw(@NonNull xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull wkc paramwkc)
  {
    if (xxi.a(paramxxi) == null)
    {
      ykq.b(this.TAG, "ignore this troop nick name change event. %s.", paramwkc.toString());
      return;
    }
    ykq.a(this.TAG, "receive troop nick name change event. %s.", paramwkc.toString());
    xxi.a(paramxxi).c();
  }
  
  public Class acceptEventClass()
  {
    return wkc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxw
 * JD-Core Version:    0.7.0.1
 */