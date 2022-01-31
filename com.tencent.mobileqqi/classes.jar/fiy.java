import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class fiy
  implements Comparator
{
  public fiy(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    Object localObject2 = paramPhoneContact1.pinyinFirst;
    String str = paramPhoneContact2.pinyinFirst;
    int i;
    if ((localObject2 == null) || (str == null)) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      Object localObject1 = localObject2;
      if (((String)localObject2).endsWith("#")) {
        localObject1 = "Za";
      }
      localObject2 = str;
      if (str.endsWith("#")) {
        localObject2 = "Za";
      }
      j = ((String)localObject1).compareTo((String)localObject2);
      i = j;
    } while (j != 0);
    return paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fiy
 * JD-Core Version:    0.7.0.1
 */