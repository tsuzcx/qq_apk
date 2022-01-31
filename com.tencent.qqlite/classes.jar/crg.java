import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public final class crg
  implements Comparator
{
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    paramEntity1 = (Friends)paramEntity1;
    paramEntity2 = (Friends)paramEntity2;
    return ContactSorter.a(paramEntity1.mComparePartInt, paramEntity1.mCompareSpell, paramEntity2.mComparePartInt, paramEntity2.mCompareSpell);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     crg
 * JD-Core Version:    0.7.0.1
 */