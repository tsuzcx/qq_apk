import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class wfx
  extends QQUIEventReceiver<wfn, uyg>
{
  public wfx(@NonNull wfn paramwfn)
  {
    super(paramwfn);
  }
  
  public void a(@NonNull wfn paramwfn, @NonNull uyg paramuyg)
  {
    if (wfn.a(paramwfn) == null) {
      wsv.b(this.TAG, "ignore this feature event. %s.", paramuyg.toString());
    }
    usu localusu;
    do
    {
      return;
      while (!paramuyg.hasNext())
      {
        do
        {
          wsv.a(this.TAG, "receive feature event. %s.", paramuyg.toString());
        } while (paramuyg.a == null);
        paramuyg = paramuyg.a.iterator();
      }
      localusu = (usu)paramuyg.next();
    } while (!localusu.a.equals(wfn.a(paramwfn)));
    wsv.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(wfn.a(paramwfn).a.mViewTotalTime), Integer.valueOf(localusu.c));
    wfn.a(paramwfn).a.mViewTotalTime = localusu.c;
    paramwfn.a();
  }
  
  public Class acceptEventClass()
  {
    return uyg.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wfx
 * JD-Core Version:    0.7.0.1
 */