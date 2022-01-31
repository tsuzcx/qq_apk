import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.Comparator;

public class zpf
  implements Comparator
{
  public zpf(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean1, boolean paramBoolean2) {}
  
  int a(PhoneContact paramPhoneContact)
  {
    int j = ContactUtils.a(paramPhoneContact.detalStatusFlag, paramPhoneContact.iTermType);
    if ((j != 6) && (j != 0)) {}
    for (int i = 65536;; i = 131072) {
      switch (j)
      {
      case 5: 
      case 6: 
      default: 
        return i | (int)this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a(paramPhoneContact.unifiedCode);
      }
    }
    return i | 0x1;
    return i | 0x2;
    return i | 0x3;
  }
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      boolean bool1 = paramPhoneContact1.isNewRecommend;
      boolean bool2 = paramPhoneContact2.isNewRecommend;
      if (((bool1) || (bool2)) && ((!bool1) || (!bool2))) {
        if (bool2) {
          i = 1;
        }
      }
    }
    int j;
    do
    {
      return i;
      return -1;
      if (!this.b) {
        break;
      }
      j = b(paramPhoneContact1, paramPhoneContact2);
      i = j;
    } while (j != 0);
    return PhoneContactManagerImp.a(paramPhoneContact1, paramPhoneContact2);
  }
  
  int b(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return a(paramPhoneContact1) - a(paramPhoneContact2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zpf
 * JD-Core Version:    0.7.0.1
 */