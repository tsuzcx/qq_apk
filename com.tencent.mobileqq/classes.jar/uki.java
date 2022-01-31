import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class uki
  extends sgl<ujx, sql>
{
  public uki(ujx paramujx)
  {
    super(paramujx);
  }
  
  public void a(@NonNull ujx paramujx, @NonNull sql paramsql)
  {
    Object localObject = ujx.a(paramujx);
    paramsql = paramsql.a;
    sqj localsqj = (sqj)sqg.a(27);
    localObject = ((ArrayList)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      ukt localukt = (ukt)((Iterator)localObject).next();
      if ((localukt instanceof ukv))
      {
        szr localszr = (szr)paramsql.get(localukt.a().feedId);
        if (localszr == null) {
          break label129;
        }
        ((ukv)localukt).d = localsqj.a(((ukv)localukt).a(), localszr.a);
        i = 1;
      }
    }
    label129:
    for (;;)
    {
      break;
      if (i != 0) {
        ujx.a(paramujx).f();
      }
      return;
    }
  }
  
  public Class acceptEventClass()
  {
    return sql.class;
  }
  
  public void b(@NonNull ujx paramujx, @NonNull sql paramsql) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uki
 * JD-Core Version:    0.7.0.1
 */