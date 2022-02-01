import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xix
  extends QQUIEventReceiver<xin, wbm>
{
  public xix(@NonNull xin paramxin)
  {
    super(paramxin);
  }
  
  public void a(@NonNull xin paramxin, @NonNull wbm paramwbm)
  {
    if (xin.a(paramxin) == null) {
      xvv.b(this.TAG, "ignore this feature event. %s.", paramwbm.toString());
    }
    vwa localvwa;
    do
    {
      return;
      while (!paramwbm.hasNext())
      {
        do
        {
          xvv.a(this.TAG, "receive feature event. %s.", paramwbm.toString());
        } while (paramwbm.a == null);
        paramwbm = paramwbm.a.iterator();
      }
      localvwa = (vwa)paramwbm.next();
    } while (!localvwa.a.equals(xin.a(paramxin)));
    xvv.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(xin.a(paramxin).a.mViewTotalTime), Integer.valueOf(localvwa.c));
    xin.a(paramxin).a.mViewTotalTime = localvwa.c;
    paramxin.a();
  }
  
  public Class acceptEventClass()
  {
    return wbm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xix
 * JD-Core Version:    0.7.0.1
 */