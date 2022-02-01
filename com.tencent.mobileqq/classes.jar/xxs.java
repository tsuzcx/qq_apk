import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class xxs
  extends QQUIEventReceiver<xxi, wqh>
{
  public xxs(@NonNull xxi paramxxi)
  {
    super(paramxxi);
  }
  
  public void a(@NonNull xxi paramxxi, @NonNull wqh paramwqh)
  {
    if (xxi.a(paramxxi) == null) {
      ykq.b(this.TAG, "ignore this feature event. %s.", paramwqh.toString());
    }
    wkv localwkv;
    do
    {
      return;
      while (!paramwqh.hasNext())
      {
        do
        {
          ykq.a(this.TAG, "receive feature event. %s.", paramwqh.toString());
        } while (paramwqh.a == null);
        paramwqh = paramwqh.a.iterator();
      }
      localwkv = (wkv)paramwqh.next();
    } while (!localwkv.a.equals(xxi.a(paramxxi)));
    ykq.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(xxi.a(paramxxi).a.mViewTotalTime), Integer.valueOf(localwkv.c));
    xxi.a(paramxxi).a.mViewTotalTime = localwkv.c;
    paramxxi.a();
  }
  
  public Class acceptEventClass()
  {
    return wqh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxs
 * JD-Core Version:    0.7.0.1
 */