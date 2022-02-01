import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class yim
  extends QQUIEventReceiver<yij, wor>
{
  public yim(@NonNull yij paramyij)
  {
    super(paramyij);
  }
  
  public void a(@NonNull yij paramyij, @NonNull wor paramwor)
  {
    Iterator localIterator = paramyij.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (yjy)localIterator.next();
      j = i;
      if ((localObject instanceof yir))
      {
        j = i;
        if (((yir)localObject).b())
        {
          localObject = ((yir)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramwor.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramyij.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return wor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yim
 * JD-Core Version:    0.7.0.1
 */