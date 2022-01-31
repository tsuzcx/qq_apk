import com.tencent.mobileqq.adapter.DiscussionListAdapter2;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;
import java.util.HashMap;

public class exy
  implements Comparator
{
  public exy(DiscussionListAdapter2 paramDiscussionListAdapter2, HashMap paramHashMap) {}
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    long l1 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramEntity1).uin)).longValue();
    long l2 = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(((DiscussionInfo)paramEntity2).uin)).longValue();
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exy
 * JD-Core Version:    0.7.0.1
 */