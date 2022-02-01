import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class yjn
  extends wfr<yjc, wpr>
{
  public yjn(yjc paramyjc)
  {
    super(paramyjc);
  }
  
  public void a(@NonNull yjc paramyjc, @NonNull wpr paramwpr)
  {
    Object localObject = yjc.a(paramyjc);
    paramwpr = paramwpr.a;
    wpp localwpp = (wpp)wpm.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      yjy localyjy = (yjy)((Iterator)localObject).next();
      if ((localyjy instanceof yka))
      {
        wyx localwyx = (wyx)paramwpr.get(localyjy.a().feedId);
        if (localwyx == null) {
          break label129;
        }
        ((yka)localyjy).d = localwpp.a(((yka)localyjy).a(), localwyx.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        yjc.a(paramyjc).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wpr.class;
  }
  
  public void b(@NonNull yjc paramyjc, @NonNull wpr paramwpr) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjn
 * JD-Core Version:    0.7.0.1
 */