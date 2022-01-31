import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class wqc
  extends umf<wpr, uwf>
{
  public wqc(wpr paramwpr)
  {
    super(paramwpr);
  }
  
  public void a(@NonNull wpr paramwpr, @NonNull uwf paramuwf)
  {
    Object localObject = wpr.a(paramwpr);
    paramuwf = paramuwf.a;
    uwd localuwd = (uwd)uwa.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      wqn localwqn = (wqn)((Iterator)localObject).next();
      if ((localwqn instanceof wqp))
      {
        vfl localvfl = (vfl)paramuwf.get(localwqn.a().feedId);
        if (localvfl == null) {
          break label129;
        }
        ((wqp)localwqn).d = localuwd.a(((wqp)localwqn).a(), localvfl.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        wpr.a(paramwpr).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return uwf.class;
  }
  
  public void b(@NonNull wpr paramwpr, @NonNull uwf paramuwf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wqc
 * JD-Core Version:    0.7.0.1
 */