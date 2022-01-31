import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class cvr
  implements Comparator
{
  cvr(cvp paramcvp) {}
  
  public int a(PhoneContact paramPhoneContact1, PhoneContact paramPhoneContact2)
  {
    int i = paramPhoneContact1.sortWeight - paramPhoneContact2.sortWeight;
    if (i == 0)
    {
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
      ((String)localObject1).compareTo((String)localObject2);
      if (i == 0) {
        return paramPhoneContact1.pinyinAll.compareTo(paramPhoneContact2.pinyinAll);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cvr
 * JD-Core Version:    0.7.0.1
 */