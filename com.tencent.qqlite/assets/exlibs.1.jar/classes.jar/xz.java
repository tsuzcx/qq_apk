import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import java.util.Calendar;

public class xz
  implements IphonePickerView.PickerViewAdapter
{
  private xz(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return this.a.a - 1895 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.a.f + 1895);
    localCalendar.set(2, this.a.g);
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1895 + "年";
    case 1: 
      return paramInt2 + 1 + "月";
    }
    return paramInt2 + 1 + "日";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xz
 * JD-Core Version:    0.7.0.1
 */