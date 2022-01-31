import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class wkw
  implements Comparator
{
  public wkw(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(wkz paramwkz1, wkz paramwkz2)
  {
    paramwkz1 = paramwkz1.a.name;
    paramwkz2 = paramwkz2.a.name;
    if ((paramwkz1 == null) && (paramwkz2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramwkz1 == null) && (paramwkz2 != null)) {
        return -1;
      }
      if ((paramwkz1 != null) && (paramwkz2 == null)) {
        return 1;
      }
      j = paramwkz1.length();
      k = paramwkz2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramwkz1.charAt(i);
        char c2 = paramwkz2.charAt(i);
        if (c1 != c2)
        {
          paramwkz1 = ChnToSpell.a(c1, i);
          paramwkz2 = ChnToSpell.a(c2, i);
          if (paramwkz1.jdField_a_of_type_Int == paramwkz2.jdField_a_of_type_Int) {
            return paramwkz1.jdField_a_of_type_JavaLangString.compareTo(paramwkz2.jdField_a_of_type_JavaLangString);
          }
          return paramwkz1.jdField_a_of_type_Int - paramwkz2.jdField_a_of_type_Int;
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
 * Qualified Name:     wkw
 * JD-Core Version:    0.7.0.1
 */