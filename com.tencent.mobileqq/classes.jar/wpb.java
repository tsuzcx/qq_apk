import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class wpb
  extends QQUIEventReceiver<woy, uvf>
{
  public wpb(@NonNull woy paramwoy)
  {
    super(paramwoy);
  }
  
  public void a(@NonNull woy paramwoy, @NonNull uvf paramuvf)
  {
    Iterator localIterator = paramwoy.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (wqn)localIterator.next();
      j = i;
      if ((localObject instanceof wpg))
      {
        j = i;
        if (((wpg)localObject).b())
        {
          localObject = ((wpg)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramuvf.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramwoy.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return uvf.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wpb
 * JD-Core Version:    0.7.0.1
 */