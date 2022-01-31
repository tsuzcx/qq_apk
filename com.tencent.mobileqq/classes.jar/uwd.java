import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class uwd
  extends QQUIEventReceiver<uwa, tch>
{
  public uwd(@NonNull uwa paramuwa)
  {
    super(paramuwa);
  }
  
  public void a(@NonNull uwa paramuwa, @NonNull tch paramtch)
  {
    Iterator localIterator = paramuwa.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (uxp)localIterator.next();
      j = i;
      if ((localObject instanceof uwi))
      {
        j = i;
        if (((uwi)localObject).b())
        {
          localObject = ((uwi)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramtch.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramuwa.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return tch.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uwd
 * JD-Core Version:    0.7.0.1
 */