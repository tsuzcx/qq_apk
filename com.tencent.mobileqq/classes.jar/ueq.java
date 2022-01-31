import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ueq
  extends QQUIEventReceiver<uec, sqq>
{
  public ueq(@NonNull uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull sqq paramsqq)
  {
    if (uec.a(paramuec) == null)
    {
      urk.b(this.TAG, "ignore this troop nick name change event. %s.", paramsqq.toString());
      return;
    }
    urk.a(this.TAG, "receive troop nick name change event. %s.", paramsqq.toString());
    uec.a(paramuec).c();
  }
  
  public Class acceptEventClass()
  {
    return sqq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ueq
 * JD-Core Version:    0.7.0.1
 */