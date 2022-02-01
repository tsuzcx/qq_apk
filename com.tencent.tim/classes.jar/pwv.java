import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;

public class pwv
{
  private static String TAG = pwv.class.getSimpleName();
  
  public static prp c(ViewGroup paramViewGroup, int paramInt)
  {
    ram.b(TAG, "create type=%d", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e(TAG, 2, "发现一个野生的类型: " + paramInt);
      }
      return new prp(paramViewGroup, 2131561903);
    case 6: 
      return new pwm(paramViewGroup);
    case 5: 
      return new pwu(paramViewGroup);
    case 7: 
      return new pwl(paramViewGroup);
    case 8: 
      return new pxb(paramViewGroup, 2131561903);
    case 9: 
      return new pwt(paramViewGroup);
    case 3: 
      return new pwn(paramViewGroup);
    case 4: 
      return new pwr(paramViewGroup, 4);
    case 2: 
      return new pwz(paramViewGroup, 2131561905);
    case 10: 
    case 11: 
      return new pws(paramViewGroup);
    case 12: 
      return new pww(paramViewGroup);
    }
    return new pwo(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pwv
 * JD-Core Version:    0.7.0.1
 */