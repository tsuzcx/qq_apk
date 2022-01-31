import com.tencent.mobileqq.app.fms.FullMessageSearchTask;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public class zyi
  implements Comparator
{
  public zyi(FullMessageSearchTask paramFullMessageSearchTask) {}
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    int j = -1;
    paramEntity1 = (RecentUser)paramEntity1;
    paramEntity2 = (RecentUser)paramEntity2;
    long l1 = Math.max(paramEntity1.lastmsgtime, paramEntity1.lastmsgdrafttime);
    long l2 = Math.max(paramEntity2.lastmsgtime, paramEntity2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramEntity1.type != paramEntity2.type) {
        break label80;
      }
    }
    label80:
    do
    {
      do
      {
        return i;
        if (l1 == l2)
        {
          i = 0;
          break;
        }
        i = -1;
        break;
        i = j;
      } while (paramEntity1.type == 0);
      if (paramEntity2.type == 0) {
        return 1;
      }
      i = j;
    } while (paramEntity1.type - paramEntity2.type > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zyi
 * JD-Core Version:    0.7.0.1
 */