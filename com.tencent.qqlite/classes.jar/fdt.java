import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import java.util.HashMap;

public class fdt
  implements fds
{
  public fdt(DbCacheService paramDbCacheService) {}
  
  public void a(DbCacheManager paramDbCacheManager)
  {
    synchronized (this.a.a)
    {
      this.a.a.remove(paramDbCacheManager.a());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fdt
 * JD-Core Version:    0.7.0.1
 */