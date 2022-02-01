import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import java.util.Comparator;
import java.util.Set;

public class amwq
  extends amvg
{
  public final amwq.a a;
  
  public amwq(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    super(paramQQAppInterface, paramInt1, paramInt2, paramString, paramSet);
    this.a = new amwq.a(paramQQAppInterface);
  }
  
  public Comparator<ampt> f()
  {
    return this.a;
  }
  
  static final class a
    implements Comparator<ampt>
  {
    private final ajdo c;
    private final acff m;
    
    a(QQAppInterface paramQQAppInterface)
    {
      this.c = ((ajdo)paramQQAppInterface.getManager(11));
      this.m = ((acff)paramQQAppInterface.getManager(51));
    }
    
    public int c(ampt paramampt1, ampt paramampt2)
    {
      int i = -1;
      paramampt1 = this.c.c(((amop)paramampt1).zd());
      paramampt2 = this.c.c(((amop)paramampt2).zd());
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
          do
          {
            do
            {
              return i;
            } while (paramampt2 == null);
            return 1;
            if ((paramampt1.uin.equals("0")) && (paramampt2.uin.equals("0"))) {
              break;
            }
            if ((!paramampt1.uin.equals("0")) && (!paramampt2.uin.equals("0"))) {
              return 0;
            }
          } while (!paramampt2.uin.equals("0"));
          return 1;
          bool1 = this.m.w(paramampt1.unifiedCode, true);
          bool2 = this.m.w(paramampt2.unifiedCode, true);
          if ((!bool1) && (!bool2)) {
            break;
          }
          if ((bool1) && (bool2)) {
            return 0;
          }
        } while (bool2);
        return 1;
        boolean bool1 = TextUtils.isEmpty(paramampt1.pinyinFirst);
        bool2 = TextUtils.isEmpty(paramampt2.pinyinFirst);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      return paramampt1.pinyinFirst.toLowerCase().charAt(0) - paramampt2.pinyinFirst.toLowerCase().charAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amwq
 * JD-Core Version:    0.7.0.1
 */