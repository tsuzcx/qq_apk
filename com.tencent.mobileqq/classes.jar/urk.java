import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class urk
  extends QQUIEventReceiver<uqy, tkn>
{
  public urk(@NonNull uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull tkn paramtkn)
  {
    if (uqy.a(paramuqy) == null)
    {
      veg.b(this.TAG, "ignore this user info event. %s.", paramtkn.toString());
      return;
    }
    veg.a(this.TAG, "receive user info event. %s.", paramtkn.toString());
    uqy.a(paramuqy).c();
  }
  
  public Class acceptEventClass()
  {
    return tkn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urk
 * JD-Core Version:    0.7.0.1
 */