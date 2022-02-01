import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tribe.async.dispatch.Dispatcher;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class pta
  implements ppv.b<pyv, pyv.b>
{
  pta(psz parampsz) {}
  
  public void a(@NonNull pyv parampyv, @Nullable pyv.b paramb, @NonNull ErrorMessage paramErrorMessage)
  {
    parampyv = parampyv.np.iterator();
    while (parampyv.hasNext())
    {
      localObject = (String)parampyv.next();
      psz.a(this.a).remove(localObject);
    }
    parampyv = new psz.a();
    parampyv.b = paramErrorMessage;
    if ((paramErrorMessage.isFail()) || (paramb == null))
    {
      ram.w("Q.qqstory:TagManager", "request fail for get tag request");
      pmi.a().dispatch(parampyv);
      return;
    }
    paramErrorMessage = parampyv.fJ;
    Object localObject = (psz)psx.a(27);
    paramb = paramb.nr.iterator();
    while (paramb.hasNext())
    {
      pyv.a locala = (pyv.a)paramb.next();
      ((psz)localObject).j(locala.feedId, locala.nq);
      paramErrorMessage.put(locala.feedId, locala);
      ram.b("Q.qqstory:TagManager", "save feedId :%s , %s", locala.feedId, locala.nq);
    }
    pmi.a().dispatch(parampyv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pta
 * JD-Core Version:    0.7.0.1
 */