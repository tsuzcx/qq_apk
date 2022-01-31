import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ujh
  extends QQUIEventReceiver<uje, spl>
{
  public ujh(@NonNull uje paramuje)
  {
    super(paramuje);
  }
  
  public void a(@NonNull uje paramuje, @NonNull spl paramspl)
  {
    Iterator localIterator = paramuje.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (ukt)localIterator.next();
      j = i;
      if ((localObject instanceof ujm))
      {
        j = i;
        if (((ujm)localObject).b())
        {
          localObject = ((ujm)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramspl.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramuje.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return spl.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujh
 * JD-Core Version:    0.7.0.1
 */