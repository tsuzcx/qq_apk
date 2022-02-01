import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;
import java.util.HashMap;

class abed
  implements Comparator<Entity>
{
  abed(abec paramabec, HashMap paramHashMap) {}
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    long l1 = ((Long)this.id.get(((DiscussionInfo)paramEntity1).uin)).longValue();
    long l2 = ((Long)this.id.get(((DiscussionInfo)paramEntity2).uin)).longValue();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abed
 * JD-Core Version:    0.7.0.1
 */