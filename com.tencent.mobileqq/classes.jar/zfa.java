import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class zfa
  implements Comparator
{
  public zfa(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i = -1;
    int j = 1;
    if ((!paramPhoneContact1.uin.equals("0")) || (!paramPhoneContact2.uin.equals("0"))) {
      if ((!paramPhoneContact1.uin.equals("0")) && (!paramPhoneContact2.uin.equals("0"))) {
        i = PhoneContactManagerImp.a(paramPhoneContact1, paramPhoneContact2);
      }
    }
    do
    {
      return i;
      if (!paramPhoneContact2.uin.equals("0")) {}
      for (i = -1;; i = 1) {
        return i;
      }
      if (!paramPhoneContact1.uin.equals("0")) {
        break;
      }
      FriendsManager localFriendsManager = (FriendsManager)PhoneContactManagerImp.a(this.a).getManager(50);
      bool1 = localFriendsManager.a(paramPhoneContact1.unifiedCode, true);
      bool2 = localFriendsManager.a(paramPhoneContact2.unifiedCode, true);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return PhoneContactManagerImp.a(paramPhoneContact1, paramPhoneContact2);
      }
    } while (bool2);
    return 1;
    boolean bool1 = paramPhoneContact1.isNewRecommend;
    boolean bool2 = paramPhoneContact2.isNewRecommend;
    if (((bool1) || (bool2)) && ((!bool1) || (!bool2)))
    {
      if (bool2) {}
      for (i = j;; i = -1) {
        return i;
      }
    }
    return PhoneContactManagerImp.a(paramPhoneContact1, paramPhoneContact2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zfa
 * JD-Core Version:    0.7.0.1
 */