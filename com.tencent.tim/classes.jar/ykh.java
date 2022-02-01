import android.content.Context;
import android.view.LayoutInflater;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView.d;
import java.util.Calendar;
import java.util.Date;

public class ykh
{
  private long Ke;
  private TimeSelectView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView;
  private ykh.a jdField_a_of_type_Ykh$a;
  ykh.b jdField_a_of_type_Ykh$b = new ykh.b();
  private int bZs;
  private int bZt;
  private int bZu;
  private int bZv;
  private int bZw;
  private int bZx;
  private int bZy;
  private ausj mActionSheet;
  private int startDay;
  private int startYear;
  
  ykh(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView = ((TimeSelectView)LayoutInflater.from(paramContext).inflate(2131561391, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.a(this.jdField_a_of_type_Ykh$b);
    this.mActionSheet = ausj.d(paramContext);
    this.mActionSheet.setCloseAutoRead(true);
    this.mActionSheet.setActionContentView(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView, null);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.setPickListener(new yki(this));
    initTime();
  }
  
  private void fO(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    Calendar localCalendar;
    switch (paramInt1)
    {
    default: 
      localCalendar = Calendar.getInstance();
      localCalendar.set(1, this.bZt);
      localCalendar.set(6, this.bZu);
      localCalendar.set(11, this.bZw);
      localCalendar.set(12, this.bZy);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      if (localCalendar.getTimeInMillis() > System.currentTimeMillis()) {
        bool = true;
      }
      if (bool) {
        this.Ke = localCalendar.getTimeInMillis();
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, "year: " + localCalendar.get(1) + "\nmonth: " + localCalendar.get(2) + "\nday: " + localCalendar.get(5) + "\ntimeValid: " + bool);
      }
      return;
      this.bZt = (this.startYear + paramInt2);
      break;
      this.bZu = (this.startDay + paramInt2);
      break;
      this.bZw = (this.bZv + paramInt2);
      break;
      this.bZy = (this.bZx + paramInt2);
      break;
      resetTime();
    }
  }
  
  private void fP(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView.setSelection(paramInt1, paramInt2);
      return;
      this.bZt = (this.startYear + paramInt2);
      continue;
      this.bZu = (this.startDay + paramInt2);
      continue;
      this.bZw = (this.bZv + paramInt2);
      continue;
      this.bZy = (this.bZx + paramInt2);
    }
  }
  
  private void initTime()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l));
    this.bZt = localCalendar.get(1);
    this.startYear = this.bZt;
    this.bZu = localCalendar.get(6);
    this.startDay = 1;
    this.bZw = localCalendar.get(10);
    this.bZv = 0;
    this.bZy = localCalendar.get(12);
    this.bZx = 0;
  }
  
  private void resetTime()
  {
    long l = System.currentTimeMillis();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date(l + 60000L));
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.Ke = localCalendar.getTimeInMillis();
    int i = localCalendar.get(1);
    int j = localCalendar.get(6);
    int k = localCalendar.get(11);
    int m = localCalendar.get(12);
    int n = this.startYear;
    int i1 = this.startDay;
    int i2 = this.bZv;
    int i3 = this.bZx;
    fP(0, i - n);
    fP(1, j - i1);
    fP(2, k - i2);
    fP(3, m - i3);
  }
  
  public void Ed(int paramInt)
  {
    this.bZs = paramInt;
    resetTime();
    this.mActionSheet.show();
  }
  
  void a(ykh.a parama)
  {
    this.jdField_a_of_type_Ykh$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void ag(long paramLong, boolean paramBoolean);
  }
  
  class b
    implements TimeSelectView.d
  {
    b() {}
    
    public String d(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return "";
      case 0: 
        return "" + (ykh.c(ykh.this) + paramInt2) + "年";
      case 1: 
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.clear();
        localCalendar.setFirstDayOfWeek(1);
        localCalendar.set(1, ykh.b(ykh.this));
        localCalendar.add(5, paramInt2);
        String str = "" + (localCalendar.get(2) + 1);
        str = str + "月";
        str = str + localCalendar.get(5);
        str = str + "日 ";
        str = str + yka.getWeekString(localCalendar.get(7));
        QLog.d("UpComingMsgLogic.UpcomingTimeSelector", 3, str + " day_of_week " + localCalendar.get(7) + "\n" + localCalendar.getTime().toString());
        return str;
      case 2: 
        return "" + (ykh.d(ykh.this) + paramInt2);
      }
      return "" + (ykh.e(ykh.this) + paramInt2);
    }
    
    public int getColumnCount()
    {
      return 4;
    }
    
    public int t(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 1;
      case 0: 
        return 2;
      case 1: 
        return yka.fp(ykh.b(ykh.this));
      case 2: 
        return 24;
      }
      return 60;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykh
 * JD-Core Version:    0.7.0.1
 */