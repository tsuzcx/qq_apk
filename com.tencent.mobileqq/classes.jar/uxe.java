import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class uxe
  extends sth<uwt, tdh>
{
  public uxe(uwt paramuwt)
  {
    super(paramuwt);
  }
  
  public void a(@NonNull uwt paramuwt, @NonNull tdh paramtdh)
  {
    Object localObject = uwt.a(paramuwt);
    paramtdh = paramtdh.a;
    tdf localtdf = (tdf)tdc.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      uxp localuxp = (uxp)((Iterator)localObject).next();
      if ((localuxp instanceof uxr))
      {
        tmn localtmn = (tmn)paramtdh.get(localuxp.a().feedId);
        if (localtmn == null) {
          break label129;
        }
        ((uxr)localuxp).d = localtdf.a(((uxr)localuxp).a(), localtmn.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        uwt.a(paramuwt).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return tdh.class;
  }
  
  public void b(@NonNull uwt paramuwt, @NonNull tdh paramtdh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxe
 * JD-Core Version:    0.7.0.1
 */