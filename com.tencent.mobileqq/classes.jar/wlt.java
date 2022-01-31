import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class wlt
  extends uhw<wli, urw>
{
  public wlt(wli paramwli)
  {
    super(paramwli);
  }
  
  public void a(@NonNull wli paramwli, @NonNull urw paramurw)
  {
    Object localObject = wli.a(paramwli);
    paramurw = paramurw.a;
    uru localuru = (uru)urr.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      wme localwme = (wme)((Iterator)localObject).next();
      if ((localwme instanceof wmg))
      {
        vbc localvbc = (vbc)paramurw.get(localwme.a().feedId);
        if (localvbc == null) {
          break label129;
        }
        ((wmg)localwme).d = localuru.a(((wmg)localwme).a(), localvbc.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        wli.a(paramwli).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return urw.class;
  }
  
  public void b(@NonNull wli paramwli, @NonNull urw paramurw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wlt
 * JD-Core Version:    0.7.0.1
 */