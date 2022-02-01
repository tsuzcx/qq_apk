import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ycn
  extends QQUIEventReceiver<yck, wix>
{
  public ycn(@NonNull yck paramyck)
  {
    super(paramyck);
  }
  
  public void a(@NonNull yck paramyck, @NonNull wix paramwix)
  {
    Iterator localIterator = paramyck.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (ydz)localIterator.next();
      j = i;
      if ((localObject instanceof ycs))
      {
        j = i;
        if (((ycs)localObject).b())
        {
          localObject = ((ycs)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramwix.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramyck.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return wix.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ycn
 * JD-Core Version:    0.7.0.1
 */