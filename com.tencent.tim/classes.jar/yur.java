import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.a;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class yur
  implements Comparator<PhoneContact>
{
  public yur(PhoneContactManagerImp.a parama) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return paramPhoneContact1.contactID - paramPhoneContact2.contactID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yur
 * JD-Core Version:    0.7.0.1
 */