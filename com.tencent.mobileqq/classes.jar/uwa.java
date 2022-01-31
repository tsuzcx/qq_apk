import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class uwa
  extends QQUIEventReceiver<uvx, tce>
{
  public uwa(@NonNull uvx paramuvx)
  {
    super(paramuvx);
  }
  
  public void a(@NonNull uvx paramuvx, @NonNull tce paramtce)
  {
    Iterator localIterator = paramuvx.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (uxm)localIterator.next();
      j = i;
      if ((localObject instanceof uwf))
      {
        j = i;
        if (((uwf)localObject).b())
        {
          localObject = ((uwf)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramtce.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramuvx.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return tce.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwa
 * JD-Core Version:    0.7.0.1
 */