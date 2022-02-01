import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class yhm
  extends QQUIEventReceiver<yhc, wzw>
{
  public yhm(@NonNull yhc paramyhc)
  {
    super(paramyhc);
  }
  
  public void a(@NonNull yhc paramyhc, @NonNull wzw paramwzw)
  {
    if (yhc.a(paramyhc) == null) {
      yuk.b(this.TAG, "ignore this feature event. %s.", paramwzw.toString());
    }
    wuk localwuk;
    do
    {
      return;
      while (!paramwzw.hasNext())
      {
        do
        {
          yuk.a(this.TAG, "receive feature event. %s.", paramwzw.toString());
        } while (paramwzw.a == null);
        paramwzw = paramwzw.a.iterator();
      }
      localwuk = (wuk)paramwzw.next();
    } while (!localwuk.a.equals(yhc.a(paramyhc)));
    yuk.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(yhc.a(paramyhc).a.mViewTotalTime), Integer.valueOf(localwuk.c));
    yhc.a(paramyhc).a.mViewTotalTime = localwuk.c;
    paramyhc.a();
  }
  
  public Class acceptEventClass()
  {
    return wzw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yhm
 * JD-Core Version:    0.7.0.1
 */