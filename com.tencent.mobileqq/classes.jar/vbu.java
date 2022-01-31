import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class vbu
{
  private static String a = vbu.class.getSimpleName();
  
  public static uuh a(ViewGroup paramViewGroup, int paramInt)
  {
    wxe.a(a, "create type=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e(a, 2, "发现一个野生的类型: " + paramInt);
      }
      return new uuh(paramViewGroup, 2131561510);
    case 6: 
      return new vbl(paramViewGroup);
    case 5: 
      return new vbt(paramViewGroup);
    case 7: 
      return new vbk(paramViewGroup);
    case 8: 
      return new vca(paramViewGroup, 2131561510);
    case 9: 
      return new vbs(paramViewGroup);
    case 3: 
      return new vbm(paramViewGroup);
    case 4: 
      return new vbq(paramViewGroup, 4);
    case 2: 
      return new vby(paramViewGroup, 2131561512);
    case 10: 
    case 11: 
      return new vbr(paramViewGroup);
    case 12: 
      return new vbv(paramViewGroup);
    }
    return new vbn(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vbu
 * JD-Core Version:    0.7.0.1
 */