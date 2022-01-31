import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public final class uri
  extends QQUIEventReceiver<uqy, tjr>
{
  public uri(@NonNull uqy paramuqy)
  {
    super(paramuqy);
  }
  
  public void a(@NonNull uqy paramuqy, @NonNull tjr paramtjr)
  {
    if (uqy.a(paramuqy) == null) {
      veg.b(this.TAG, "ignore this feature event. %s.", paramtjr.toString());
    }
    tef localtef;
    do
    {
      return;
      while (!paramtjr.hasNext())
      {
        do
        {
          veg.a(this.TAG, "receive feature event. %s.", paramtjr.toString());
        } while (paramtjr.a == null);
        paramtjr = paramtjr.a.iterator();
      }
      localtef = (tef)paramtjr.next();
    } while (!localtef.a.equals(uqy.a(paramuqy)));
    veg.a(this.TAG, "receive feature data. update visit count from %d to %d.", Long.valueOf(uqy.a(paramuqy).a.mViewTotalTime), Integer.valueOf(localtef.c));
    uqy.a(paramuqy).a.mViewTotalTime = localtef.c;
    paramuqy.a();
  }
  
  public Class acceptEventClass()
  {
    return tjr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uri
 * JD-Core Version:    0.7.0.1
 */