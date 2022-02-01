import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Comparator;

class amww
  implements Comparator<ampt>
{
  amww(amwv paramamwv) {}
  
  public int c(ampt paramampt1, ampt paramampt2)
  {
    int i = -1;
    paramampt1 = (amre)paramampt1;
    paramampt2 = (amre)paramampt2;
    acff localacff = (acff)this.a.app.getManager(51);
    boolean bool1 = localacff.isFriend((String)paramampt1.S());
    boolean bool2 = localacff.isFriend((String)paramampt2.S());
    if ((!bool1) && (!bool2))
    {
      bool1 = localacff.kd((String)paramampt1.S());
      bool2 = localacff.kd((String)paramampt2.S());
      if ((!bool1) && (!bool2)) {
        return paramampt2.Ja() - paramampt1.Ja();
      }
      if (bool1 != bool2)
      {
        if (bool2) {
          return -1;
        }
        return 1;
      }
      return paramampt2.Ja() - paramampt1.Ja();
    }
    if (bool1 != bool2)
    {
      if (bool2) {}
      for (;;)
      {
        return i;
        i = 1;
      }
    }
    return paramampt2.Ja() - paramampt1.Ja();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amww
 * JD-Core Version:    0.7.0.1
 */