import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public class cwx
  implements Comparator
{
  public cwx(BaseCache paramBaseCache) {}
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    return (int)(paramEntity1.getId() - paramEntity2.getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwx
 * JD-Core Version:    0.7.0.1
 */