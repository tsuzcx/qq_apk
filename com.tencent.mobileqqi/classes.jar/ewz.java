import com.tencent.mobileqq.activity.specialcare.QvipSpecialCarePersonActivity;
import com.tencent.mobileqq.app.ContactSorter;
import java.util.Comparator;

public class ewz
  implements Comparator
{
  public ewz(QvipSpecialCarePersonActivity paramQvipSpecialCarePersonActivity) {}
  
  private String a(String paramString)
  {
    return QvipSpecialCarePersonActivity.a(this.a, paramString) + paramString;
  }
  
  public int a(String paramString1, String paramString2)
  {
    return ContactSorter.a(a(paramString1), a(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewz
 * JD-Core Version:    0.7.0.1
 */