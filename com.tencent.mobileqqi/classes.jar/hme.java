import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import java.util.HashMap;

public class hme
  implements hmd
{
  public hme(DbCacheService paramDbCacheService) {}
  
  public void a(DbCacheManager paramDbCacheManager)
  {
    synchronized (this.a.a)
    {
      this.a.a.remove(paramDbCacheManager.a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hme
 * JD-Core Version:    0.7.0.1
 */