import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class ydr
  extends QQUIEventReceiver<ydh, wwb>
{
  public ydr(@NonNull ydh paramydh)
  {
    super(paramydh);
  }
  
  public void a(@NonNull ydh paramydh, @NonNull wwb paramwwb)
  {
    if (ydh.a(paramydh) == null) {
      yqp.b(this.TAG, "ignore this feature event. %s.", paramwwb.toString());
    }
    wqp localwqp;
    do
    {
      return;
      while (!paramwwb.hasNext())
      {
        do
        {
          yqp.a(this.TAG, "receive feature event. %s.", paramwwb.toString());
        } while (paramwwb.a == null);
        paramwwb = paramwwb.a.iterator();
      }
      localwqp = (wqp)paramwwb.next();
    } while (!localwqp.a.equals(ydh.a(paramydh)));
    yqp.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(ydh.a(paramydh).a.mViewTotalTime), Integer.valueOf(localwqp.c));
    ydh.a(paramydh).a.mViewTotalTime = localwqp.c;
    paramydh.a();
  }
  
  public Class acceptEventClass()
  {
    return wwb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydr
 * JD-Core Version:    0.7.0.1
 */