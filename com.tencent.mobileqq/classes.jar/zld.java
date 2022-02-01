import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.Comparator;

public class zld
  implements Comparator<String>
{
  public zld(QRDisplayActivity paramQRDisplayActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zld
 * JD-Core Version:    0.7.0.1
 */