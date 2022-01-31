import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class uxb
  extends ste<uwq, tde>
{
  public uxb(uwq paramuwq)
  {
    super(paramuwq);
  }
  
  public void a(@NonNull uwq paramuwq, @NonNull tde paramtde)
  {
    Object localObject = uwq.a(paramuwq);
    paramtde = paramtde.a;
    tdc localtdc = (tdc)tcz.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      uxm localuxm = (uxm)((Iterator)localObject).next();
      if ((localuxm instanceof uxo))
      {
        tmk localtmk = (tmk)paramtde.get(localuxm.a().feedId);
        if (localtmk == null) {
          break label129;
        }
        ((uxo)localuxm).d = localtdc.a(((uxo)localuxm).a(), localtmk.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        uwq.a(paramuwq).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return tde.class;
  }
  
  public void b(@NonNull uwq paramuwq, @NonNull tde paramtde) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uxb
 * JD-Core Version:    0.7.0.1
 */