import com.tencent.mobileqq.activity.PublicAccountListActivity;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class tho
  implements Comparator
{
  public tho(PublicAccountListActivity paramPublicAccountListActivity) {}
  
  public int a(thx paramthx1, thx paramthx2)
  {
    paramthx1 = paramthx1.a.name;
    paramthx2 = paramthx2.a.name;
    if ((paramthx1 == null) && (paramthx2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramthx1 == null) && (paramthx2 != null)) {
        return -1;
      }
      if ((paramthx1 != null) && (paramthx2 == null)) {
        return 1;
      }
      j = paramthx1.length();
      k = paramthx2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramthx1.charAt(i);
        char c2 = paramthx2.charAt(i);
        if (c1 != c2)
        {
          paramthx1 = ChnToSpell.a(c1, i);
          paramthx2 = ChnToSpell.a(c2, i);
          if (paramthx1.jdField_a_of_type_Int == paramthx2.jdField_a_of_type_Int) {
            return paramthx1.jdField_a_of_type_JavaLangString.compareTo(paramthx2.jdField_a_of_type_JavaLangString);
          }
          return paramthx1.jdField_a_of_type_Int - paramthx2.jdField_a_of_type_Int;
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
 * Qualified Name:     tho
 * JD-Core Version:    0.7.0.1
 */