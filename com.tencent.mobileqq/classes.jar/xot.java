import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class xot
  extends vll<xoi, vvc>
{
  public xot(xoi paramxoi)
  {
    super(paramxoi);
  }
  
  public void a(@NonNull xoi paramxoi, @NonNull vvc paramvvc)
  {
    Object localObject = xoi.a(paramxoi);
    paramvvc = paramvvc.a;
    vva localvva = (vva)vux.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      xpe localxpe = (xpe)((Iterator)localObject).next();
      if ((localxpe instanceof xpg))
      {
        wei localwei = (wei)paramvvc.get(localxpe.a().feedId);
        if (localwei == null) {
          break label129;
        }
        ((xpg)localxpe).d = localvva.a(((xpg)localxpe).a(), localwei.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        xoi.a(paramxoi).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return vvc.class;
  }
  
  public void b(@NonNull xoi paramxoi, @NonNull vvc paramvvc) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xot
 * JD-Core Version:    0.7.0.1
 */