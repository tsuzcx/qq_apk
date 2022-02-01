import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class alsy
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  public alsy(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    return ChnToSpell.aJ(paramMemberInfo1.name, 1).compareTo(ChnToSpell.aJ(paramMemberInfo2.name, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsy
 * JD-Core Version:    0.7.0.1
 */