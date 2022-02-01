import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailFragment;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xxu
  extends QQUIEventReceiver<xxi, wrd>
{
  public xxu(@NonNull xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull wrd paramwrd)
  {
    if (xxi.a(paramxxi) == null)
    {
      ykq.b(this.TAG, "ignore this user info event. %s.", paramwrd.toString());
      return;
    }
    ykq.a(this.TAG, "receive user info event. %s.", paramwrd.toString());
    xxi.a(paramxxi).c();
  }
  
  public Class acceptEventClass()
  {
    return wrd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxu
 * JD-Core Version:    0.7.0.1
 */