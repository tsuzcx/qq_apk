import com.tencent.mobileqq.activity.contacts.fragment.PublicAccountFragment;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.CharSpelling;
import java.util.Comparator;

public class wtm
  implements Comparator
{
  public wtm(PublicAccountFragment paramPublicAccountFragment) {}
  
  public int a(wtp paramwtp1, wtp paramwtp2)
  {
    paramwtp1 = paramwtp1.a.name;
    paramwtp2 = paramwtp2.a.name;
    if ((paramwtp1 == null) && (paramwtp2 == null)) {}
    int j;
    int k;
    do
    {
      return 0;
      if ((paramwtp1 == null) && (paramwtp2 != null)) {
        return -1;
      }
      if ((paramwtp1 != null) && (paramwtp2 == null)) {
        return 1;
      }
      j = paramwtp1.length();
      k = paramwtp2.length();
      int m = Math.min(j, k);
      int i = 0;
      while (i < m)
      {
        char c1 = paramwtp1.charAt(i);
        char c2 = paramwtp2.charAt(i);
        if (c1 != c2)
        {
          paramwtp1 = ChnToSpell.a(c1, i);
          paramwtp2 = ChnToSpell.a(c2, i);
          if (paramwtp1.jdField_a_of_type_Int == paramwtp2.jdField_a_of_type_Int) {
            return paramwtp1.jdField_a_of_type_JavaLangString.compareTo(paramwtp2.jdField_a_of_type_JavaLangString);
          }
          return paramwtp1.jdField_a_of_type_Int - paramwtp2.jdField_a_of_type_Int;
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
 * Qualified Name:     wtm
 * JD-Core Version:    0.7.0.1
 */