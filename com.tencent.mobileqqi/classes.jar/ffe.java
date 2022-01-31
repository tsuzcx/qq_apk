import com.tencent.mobileqq.app.ContactSorter;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;

public final class ffe
  implements Comparator
{
  public int a(Entity paramEntity1, Entity paramEntity2)
  {
    int i = 0;
    if ((paramEntity1 instanceof Groups)) {
      return ContactSorter.a((Groups)paramEntity1, (Groups)paramEntity2);
    }
    Object localObject = "-";
    String str = "-";
    int j;
    if (((paramEntity1 instanceof TroopInfo)) && ((paramEntity2 instanceof TroopInfo)))
    {
      paramEntity1 = (TroopInfo)paramEntity1;
      localObject = (TroopInfo)paramEntity2;
      j = paramEntity1.mComparePartInt;
      i = ((TroopInfo)localObject).mComparePartInt;
      paramEntity2 = paramEntity1.mCompareSpell;
      paramEntity1 = ((TroopInfo)localObject).mCompareSpell;
    }
    for (;;)
    {
      return ContactSorter.a(j, paramEntity2, i, paramEntity1);
      if (((paramEntity1 instanceof DiscussionInfo)) && ((paramEntity2 instanceof DiscussionInfo)))
      {
        paramEntity1 = (DiscussionInfo)paramEntity1;
        localObject = (DiscussionInfo)paramEntity2;
        j = paramEntity1.mComparePartInt;
        i = ((DiscussionInfo)localObject).mComparePartInt;
        paramEntity2 = paramEntity1.mCompareSpell;
        paramEntity1 = ((DiscussionInfo)localObject).mCompareSpell;
      }
      else if (((paramEntity1 instanceof PublicAccountInfo)) && ((paramEntity2 instanceof PublicAccountInfo)))
      {
        paramEntity1 = (PublicAccountInfo)paramEntity1;
        localObject = (PublicAccountInfo)paramEntity2;
        j = paramEntity1.mComparePartInt;
        i = ((PublicAccountInfo)localObject).mComparePartInt;
        paramEntity2 = paramEntity1.mCompareSpell;
        paramEntity1 = ((PublicAccountInfo)localObject).mCompareSpell;
      }
      else
      {
        j = 0;
        paramEntity1 = str;
        paramEntity2 = (Entity)localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ffe
 * JD-Core Version:    0.7.0.1
 */