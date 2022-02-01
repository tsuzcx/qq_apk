import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

class acpv
  implements Comparator<Entity>
{
  acpv(acpu paramacpu) {}
  
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
      if (paramEntity1.getType() != paramEntity2.getType()) {
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
      } while (paramEntity1.getType() == 0);
      if (paramEntity2.getType() == 0) {
        return 1;
      }
      i = j;
    } while (paramEntity1.getType() - paramEntity2.getType() > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acpv
 * JD-Core Version:    0.7.0.1
 */