import com.tencent.mobileqq.adapter.AllBuddyListAdapter;
import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class exi
  implements Comparator
{
  public exi(AllBuddyListAdapter paramAllBuddyListAdapter) {}
  
  private String a(Entity paramEntity)
  {
    paramEntity = (Friends)paramEntity;
    return ContactUtils.a(paramEntity) + paramEntity.uin;
  }
  
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    return ContactSorter.a(a(paramEntity1), a(paramEntity2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exi
 * JD-Core Version:    0.7.0.1
 */