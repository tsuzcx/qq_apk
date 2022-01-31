import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class wob
  implements Comparator
{
  public wob(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(woe paramwoe1, woe paramwoe2)
  {
    paramwoe1 = paramwoe1.a.name;
    paramwoe2 = paramwoe2.a.name;
    if ((paramwoe1 == null) && (paramwoe2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramwoe1 == null) && (paramwoe2 != null)) {
        return -1;
      }
      if ((paramwoe1 != null) && (paramwoe2 == null)) {
        return 1;
      }
      j = paramwoe1.length();
      k = paramwoe2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramwoe1.charAt(i);
        char c2 = paramwoe2.charAt(i);
        if (c1 != c2)
        {
          paramwoe1 = ChnToSpell.a(c1, i);
          paramwoe2 = ChnToSpell.a(c2, i);
          if (paramwoe1.jdField_a_of_type_Int == paramwoe2.jdField_a_of_type_Int) {
            return paramwoe1.jdField_a_of_type_JavaLangString.compareTo(paramwoe2.jdField_a_of_type_JavaLangString);
          }
          return paramwoe1.jdField_a_of_type_Int - paramwoe2.jdField_a_of_type_Int;
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
 * Qualified Name:     wob
 * JD-Core Version:    0.7.0.1
 */