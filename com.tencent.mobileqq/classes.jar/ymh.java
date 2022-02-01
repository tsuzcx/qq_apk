import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ymh
  extends QQUIEventReceiver<yme, wsm>
{
  public ymh(@NonNull yme paramyme)
  {
    super(paramyme);
  }
  
  public void a(@NonNull yme paramyme, @NonNull wsm paramwsm)
  {
    Iterator localIterator = paramyme.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (ynt)localIterator.next();
      j = i;
      if ((localObject instanceof ymm))
      {
        j = i;
        if (((ymm)localObject).b())
        {
          localObject = ((ymm)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramwsm.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramyme.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return wsm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ymh
 * JD-Core Version:    0.7.0.1
 */