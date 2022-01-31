import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class wks
  extends QQUIEventReceiver<wkp, uqw>
{
  public wks(@NonNull wkp paramwkp)
  {
    super(paramwkp);
  }
  
  public void a(@NonNull wkp paramwkp, @NonNull uqw paramuqw)
  {
    Iterator localIterator = paramwkp.a.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      Object localObject = (wme)localIterator.next();
      j = i;
      if ((localObject instanceof wkx))
      {
        j = i;
        if (((wkx)localObject).b())
        {
          localObject = ((wkx)localObject).a().iterator();
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            if (((StoryVideoItem)((Iterator)localObject).next()).mVid.equals(paramuqw.a)) {
              i = 1;
            }
          }
        }
      }
    }
    if (i != 0) {
      paramwkp.a.clear();
    }
  }
  
  public Class acceptEventClass()
  {
    return uqw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */