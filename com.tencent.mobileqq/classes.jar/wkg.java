import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class wkg
  extends QQUIEventReceiver<wjw, vcp>
{
  public wkg(@NonNull wjw paramwjw)
  {
    super(paramwjw);
  }
  
  public void a(@NonNull wjw paramwjw, @NonNull vcp paramvcp)
  {
    if (wjw.a(paramwjw) == null) {
      wxe.b(this.TAG, "ignore this feature event. %s.", paramvcp.toString());
    }
    uxd localuxd;
    do
    {
      return;
      while (!paramvcp.hasNext())
      {
        do
        {
          wxe.a(this.TAG, "receive feature event. %s.", paramvcp.toString());
        } while (paramvcp.a == null);
        paramvcp = paramvcp.a.iterator();
      }
      localuxd = (uxd)paramvcp.next();
    } while (!localuxd.a.equals(wjw.a(paramwjw)));
    wxe.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(wjw.a(paramwjw).a.mViewTotalTime), Integer.valueOf(localuxd.c));
    wjw.a(paramwjw).a.mViewTotalTime = localuxd.c;
    paramwjw.a();
  }
  
  public Class acceptEventClass()
  {
    return vcp.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkg
 * JD-Core Version:    0.7.0.1
 */