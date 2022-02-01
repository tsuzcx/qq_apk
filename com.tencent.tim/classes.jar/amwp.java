import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;

class amwp
  implements Comparator<ampt>
{
  amwp(amwo paramamwo) {}
  
  public int c(ampt paramampt1, ampt paramampt2)
  {
    int i = -1;
    Object localObject = (ajdo)this.a.app.getManager(11);
    paramampt1 = ((ajdo)localObject).c(((amop)paramampt1).zd());
    paramampt2 = ((ajdo)localObject).c(((amop)paramampt2).zd());
    if ((paramampt1 == null) || (paramampt2 == null)) {
      if ((paramampt1 == null) && (paramampt2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        return i;
        if (paramampt2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramampt1.uin.equals("0")) && (paramampt2.uin.equals("0"))) {
          break;
        }
        if ((!paramampt1.uin.equals("0")) && (!paramampt2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramampt2.uin.equals("0"));
      return 1;
      if (!paramampt1.uin.equals("0")) {
        break;
      }
      localObject = (acff)this.a.app.getManager(51);
      boolean bool1 = ((acff)localObject).w(paramampt1.unifiedCode, true);
      bool2 = ((acff)localObject).w(paramampt2.unifiedCode, true);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwp
 * JD-Core Version:    0.7.0.1
 */