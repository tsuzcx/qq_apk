import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import java.util.Calendar;

class akgq
  implements IphonePickerView.d
{
  akgq(akgm paramakgm) {}
  
  public String d(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1896 + acfp.m(2131708852);
    case 1: 
      return paramInt2 + 1 + acfp.m(2131708844);
    }
    return paramInt2 + 1 + acfp.m(2131708832);
  }
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int t(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.this$0.mCurrentYear - 1896 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.this$0.yG + 1896);
    localCalendar.set(2, this.this$0.yH);
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgq
 * JD-Core Version:    0.7.0.1
 */