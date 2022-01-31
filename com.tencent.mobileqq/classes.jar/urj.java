import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class urj
  extends QQUIEventReceiver<uqv, tdj>
{
  public urj(@NonNull uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull tdj paramtdj)
  {
    if (uqv.a(paramuqv) == null)
    {
      ved.b(this.TAG, "ignore this troop nick name change event. %s.", paramtdj.toString());
      return;
    }
    ved.a(this.TAG, "receive troop nick name change event. %s.", paramtdj.toString());
    uqv.a(paramuqv).c();
  }
  
  public Class acceptEventClass()
  {
    return tdj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urj
 * JD-Core Version:    0.7.0.1
 */