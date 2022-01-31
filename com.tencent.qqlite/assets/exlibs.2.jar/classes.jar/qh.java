import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class qh
  implements Comparator
{
  public qh(QRDisplayActivity paramQRDisplayActivity) {}
  
  public int a(String paramString1, String paramString2)
  {
    int i = 1;
    if ((paramString1 != null) && (paramString2 != null)) {
      i = ChnToSpell.a(paramString1, 1).compareTo(ChnToSpell.a(paramString2, 1));
    }
    while (paramString1 != null) {
      return i;
    }
    if (paramString2 != null) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     qh
 * JD-Core Version:    0.7.0.1
 */