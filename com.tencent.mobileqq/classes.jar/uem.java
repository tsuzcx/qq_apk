import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class uem
  extends QQUIEventReceiver<uec, swv>
{
  public uem(@NonNull uec paramuec)
  {
    super(paramuec);
  }
  
  public void a(@NonNull uec paramuec, @NonNull swv paramswv)
  {
    if (uec.a(paramuec) == null) {
      urk.b(this.TAG, "ignore this feature event. %s.", paramswv.toString());
    }
    srj localsrj;
    do
    {
      return;
      while (!paramswv.hasNext())
      {
        do
        {
          urk.a(this.TAG, "receive feature event. %s.", paramswv.toString());
        } while (paramswv.a == null);
        paramswv = paramswv.a.iterator();
      }
      localsrj = (srj)paramswv.next();
    } while (!localsrj.a.equals(uec.a(paramuec)));
    urk.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(uec.a(paramuec).a.mViewTotalTime), Integer.valueOf(localsrj.c));
    uec.a(paramuec).a.mViewTotalTime = localsrj.c;
    paramuec.a();
  }
  
  public Class acceptEventClass()
  {
    return swv.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uem
 * JD-Core Version:    0.7.0.1
 */