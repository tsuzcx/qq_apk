import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class xns
  extends QQUIEventReceiver<xnp, vuc>
{
  public xns(@NonNull xnp paramxnp)
  {
    super(paramxnp);
  }
  
  public void a(@NonNull xnp paramxnp, @NonNull vuc paramvuc)
  {
    Iterator localIterator = paramxnp.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (xpe)localIterator.next();
      j = i;
      if ((localObject instanceof xnx))
      {
        j = i;
        if (((xnx)localObject).b())
        {
          localObject = ((xnx)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramvuc.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramxnp.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return vuc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xns
 * JD-Core Version:    0.7.0.1
 */