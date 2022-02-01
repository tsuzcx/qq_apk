import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView;
import com.tencent.mobileqq.widget.compactcalendarview.CompactCalendarView.a;
import java.util.Date;

public class arjz
  implements CompactCalendarView.a
{
  public arjz(CompactCalendarView paramCompactCalendarView) {}
  
  public void f(Date paramDate)
  {
    if (CompactCalendarView.a(this.b) != null) {
      CompactCalendarView.a(this.b).f(paramDate);
    }
  }
  
  public void g(Date paramDate)
  {
    int i = CompactCalendarView.b(this.b);
    CompactCalendarView.b(this.b, this.b.MQ());
    if (i != CompactCalendarView.b(this.b)) {
      CompactCalendarView.a(this.b, i, CompactCalendarView.b(this.b), null);
    }
    if (CompactCalendarView.a(this.b) != null) {
      CompactCalendarView.a(this.b).g(paramDate);
    }
  }
  
  public void h(Date paramDate)
  {
    if (CompactCalendarView.a(this.b) != null) {
      CompactCalendarView.a(this.b).h(paramDate);
    }
  }
  
  public void onModeChange(int paramInt1, int paramInt2)
  {
    if (CompactCalendarView.a(this.b) != null) {
      CompactCalendarView.a(this.b).onModeChange(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arjz
 * JD-Core Version:    0.7.0.1
 */