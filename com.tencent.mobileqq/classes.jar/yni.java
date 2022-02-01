import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class yni
  extends wjm<ymx, wtm>
{
  public yni(ymx paramymx)
  {
    super(paramymx);
  }
  
  public void a(@NonNull ymx paramymx, @NonNull wtm paramwtm)
  {
    Object localObject = ymx.a(paramymx);
    paramwtm = paramwtm.a;
    wtk localwtk = (wtk)wth.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ynt localynt = (ynt)((Iterator)localObject).next();
      if ((localynt instanceof ynv))
      {
        xcs localxcs = (xcs)paramwtm.get(localynt.a().feedId);
        if (localxcs == null) {
          break label129;
        }
        ((ynv)localynt).d = localwtk.a(((ynv)localynt).a(), localxcs.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        ymx.a(paramymx).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wtm.class;
  }
  
  public void b(@NonNull ymx paramymx, @NonNull wtm paramwtm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yni
 * JD-Core Version:    0.7.0.1
 */