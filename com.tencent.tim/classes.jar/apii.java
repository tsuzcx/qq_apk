import android.content.Context;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.d;
import java.util.Calendar;
import java.util.Date;

public class apii
  implements IphonePickerView.d
{
  private final int akv = this.e.getMaximum(1);
  private final int akw = this.e.getMinimum(1);
  private final int akx;
  private Calendar e = Calendar.getInstance();
  private long kr;
  
  public apii()
  {
    this.e.add(5, 1);
    this.e.set(11, 8);
    this.e.set(12, 0);
    this.e.set(13, 0);
    this.e.set(14, 0);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.akw);
    localCalendar.set(5, 0);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    this.kr = localCalendar.getTimeInMillis();
    this.akx = ((int)((this.e.getTimeInMillis() - this.kr) / 86400000L));
  }
  
  public static int a(apij paramapij, int paramInt)
  {
    return paramInt;
  }
  
  public static long a(apij paramapij, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramapij != null) && ((paramapij.a() instanceof apii)))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(a(paramapij, paramInt1));
      localCalendar.set(11, a(paramapij, paramInt2));
      localCalendar.set(12, b(paramapij, paramInt3));
      return localCalendar.getTimeInMillis();
    }
    return 0L;
  }
  
  public static apij a(Context paramContext)
  {
    apii localapii = new apii();
    paramContext = new apij(paramContext, localapii);
    a(paramContext, localapii);
    return paramContext;
  }
  
  public static Date a(apij paramapij, int paramInt)
  {
    if ((paramapij != null) && ((paramapij.a() instanceof apii)))
    {
      paramapij = (apii)paramapij.a();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramapij.kr + 86400000L * paramInt);
      return localCalendar.getTime();
    }
    return null;
  }
  
  public static void a(apij paramapij, apii paramapii)
  {
    if ((paramapij != null) && (paramapii != null))
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.add(5, 1);
      localCalendar.set(11, 8);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      paramapij.setSelection(0, paramapii.akx);
      paramapij.setSelection(1, localCalendar.get(11));
      paramapij.setSelection(2, localCalendar.get(12));
    }
  }
  
  public static int b(apij paramapij, int paramInt)
  {
    return paramInt;
  }
  
  public static long hu()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(5, 1);
    localCalendar.set(11, 8);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis() / 1000L;
  }
  
  public String d(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return localStringBuilder.toString();
      this.e.setTimeInMillis(this.kr + 86400000L * paramInt2);
      paramInt1 = this.e.get(1);
      paramInt2 = this.e.get(2);
      int i = this.e.get(5);
      localStringBuilder.append(paramInt1).append("年").append(String.valueOf(paramInt2 + 1)).append("月").append(i).append("日");
      continue;
      localStringBuilder.append(paramInt2);
      this.e.set(11, paramInt2);
      continue;
      localStringBuilder.append(paramInt2);
      this.e.set(12, paramInt2);
    }
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
      return this.akv - this.akw + 1;
    case 1: 
      return 24;
    }
    return 60;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apii
 * JD-Core Version:    0.7.0.1
 */