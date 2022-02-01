import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListContainerFragment;
import com.tencent.mobileqq.receipt.ReceiptMessageReadMemberListFragment.MemberInfo;
import java.util.Comparator;

public class alsx
  implements Comparator<ReceiptMessageReadMemberListFragment.MemberInfo>
{
  public alsx(ReceiptMessageReadMemberListContainerFragment paramReceiptMessageReadMemberListContainerFragment) {}
  
  public int a(ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo1, ReceiptMessageReadMemberListFragment.MemberInfo paramMemberInfo2)
  {
    if (paramMemberInfo1.readTime == paramMemberInfo2.readTime) {
      return 0;
    }
    if (paramMemberInfo1.readTime < paramMemberInfo2.readTime) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alsx
 * JD-Core Version:    0.7.0.1
 */