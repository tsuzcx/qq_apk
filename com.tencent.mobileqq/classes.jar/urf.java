import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class urf
  extends QQUIEventReceiver<uqv, tjo>
{
  public urf(@NonNull uqv paramuqv)
  {
    super(paramuqv);
  }
  
  public void a(@NonNull uqv paramuqv, @NonNull tjo paramtjo)
  {
    if (uqv.a(paramuqv) == null) {
      ved.b(this.TAG, "ignore this feature event. %s.", paramtjo.toString());
    }
    tec localtec;
    do
    {
      return;
      while (!paramtjo.hasNext())
      {
        do
        {
          ved.a(this.TAG, "receive feature event. %s.", paramtjo.toString());
        } while (paramtjo.a == null);
        paramtjo = paramtjo.a.iterator();
      }
      localtec = (tec)paramtjo.next();
    } while (!localtec.a.equals(uqv.a(paramuqv)));
    ved.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(uqv.a(paramuqv).a.mViewTotalTime), Integer.valueOf(localtec.c));
    uqv.a(paramuqv).a.mViewTotalTime = localtec.c;
    paramuqv.a();
  }
  
  public Class acceptEventClass()
  {
    return tjo.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urf
 * JD-Core Version:    0.7.0.1
 */