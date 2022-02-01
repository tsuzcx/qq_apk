import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ydo
  extends wag<ydd, wjx>
{
  public ydo(ydd paramydd)
  {
    super(paramydd);
  }
  
  public void a(@NonNull ydd paramydd, @NonNull wjx paramwjx)
  {
    Object localObject = ydd.a(paramydd);
    paramwjx = paramwjx.a;
    wjv localwjv = (wjv)wjs.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ydz localydz = (ydz)((Iterator)localObject).next();
      if ((localydz instanceof yeb))
      {
        wtd localwtd = (wtd)paramwjx.get(localydz.a().feedId);
        if (localwtd == null) {
          break label129;
        }
        ((yeb)localydz).d = localwjv.a(((yeb)localydz).a(), localwtd.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        ydd.a(paramydd).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return wjx.class;
  }
  
  public void b(@NonNull ydd paramydd, @NonNull wjx paramwjx) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydo
 * JD-Core Version:    0.7.0.1
 */