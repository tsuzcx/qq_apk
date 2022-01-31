import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class zjd
  implements Comparator
{
  public zjd(PhoneContactManagerImp paramPhoneContactManagerImp, FriendsManager paramFriendsManager) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramPhoneContact1.unifiedCode, true);
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramPhoneContact2.unifiedCode, true);
    if ((bool1) && (bool2)) {}
    while (paramPhoneContact2.samFriend > paramPhoneContact1.samFriend)
    {
      do
      {
        return 1;
      } while (bool1);
      if (bool2) {
        return -1;
      }
    }
    if (paramPhoneContact2.samFriend < paramPhoneContact1.samFriend) {
      return -1;
    }
    return PhoneContactManagerImp.a(paramPhoneContact1, paramPhoneContact2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjd
 * JD-Core Version:    0.7.0.1
 */