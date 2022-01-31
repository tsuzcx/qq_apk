import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class urh
  extends QQUIEventReceiver<uqv, tkk>
{
  public urh(@NonNull uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull tkk paramtkk)
  {
    if (uqv.a(paramuqv) == null)
    {
      ved.b(this.TAG, "ignore this user info event. %s.", paramtkk.toString());
      return;
    }
    ved.a(this.TAG, "receive user info event. %s.", paramtkk.toString());
    uqv.a(paramuqv).c();
  }
  
  public Class acceptEventClass()
  {
    return tkk.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urh
 * JD-Core Version:    0.7.0.1
 */