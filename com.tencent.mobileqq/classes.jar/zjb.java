import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

public class zjb
  implements Comparator
{
  public zjb(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    return b(paramPhoneContact1, paramPhoneContact2);
  }
  
  int b(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    boolean bool1 = paramPhoneContact1.isNewRecommend;
    boolean bool2 = paramPhoneContact2.isNewRecommend;
    int i;
    if (((bool1) || (bool2)) && ((!bool1) || (!bool2))) {
      if (bool2) {
        i = 1;
      }
    }
    int j;
    do
    {
      return i;
      return -1;
      Object localObject2 = paramPhoneContact1.pinyinFirst;
      String str = paramPhoneContact2.pinyinFirst;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjb
 * JD-Core Version:    0.7.0.1
 */