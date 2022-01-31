import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class cvq
  implements Comparator
{
  cvq(cvp paramcvp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return paramPhoneContact1.contactID - paramPhoneContact2.contactID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvq
 * JD-Core Version:    0.7.0.1
 */