import com.tencent.mobileqq.data.Stranger;
import java.util.Comparator;

public final class dks
  implements Comparator
{
  public int a(Stranger paramStranger1, Stranger paramStranger2)
  {
    if (paramStranger1.loginId > paramStranger2.loginId) {
      return 1;
    }
    if (paramStranger1.loginId < paramStranger2.loginId) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dks
 * JD-Core Version:    0.7.0.1
 */