import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class tmi
  implements Comparator
{
  public tmi(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(tmr paramtmr1, tmr paramtmr2)
  {
    paramtmr1 = paramtmr1.a.name;
    paramtmr2 = paramtmr2.a.name;
    if ((paramtmr1 == null) && (paramtmr2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramtmr1 == null) && (paramtmr2 != null)) {
        return -1;
      }
      if ((paramtmr1 != null) && (paramtmr2 == null)) {
        return 1;
      }
      j = paramtmr1.length();
      k = paramtmr2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramtmr1.charAt(i);
        char c2 = paramtmr2.charAt(i);
        if (c1 != c2)
        {
          paramtmr1 = ChnToSpell.a(c1, i);
          paramtmr2 = ChnToSpell.a(c2, i);
          if (paramtmr1.jdField_a_of_type_Int == paramtmr2.jdField_a_of_type_Int) {
            return paramtmr1.jdField_a_of_type_JavaLangString.compareTo(paramtmr2.jdField_a_of_type_JavaLangString);
          }
          return paramtmr1.jdField_a_of_type_Int - paramtmr2.jdField_a_of_type_Int;
        }
        i += 1;
      }
      if (j < k) {
        return -1;
      }
    } while (j <= k);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmi
 * JD-Core Version:    0.7.0.1
 */