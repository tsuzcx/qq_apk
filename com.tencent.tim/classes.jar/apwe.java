import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout.c;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout.d;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class apwe
{
  private apwe.a jdField_a_of_type_Apwe$a;
  private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
  private long asg;
  private int dXC = 15;
  private int dXD = 6;
  private int dXE = 22;
  private int dXF = 30;
  private ausj mActionSheet;
  private Calendar z;
  
  public apwe(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    this.dXC = paramInt1;
    this.dXD = paramInt2;
    this.dXE = paramInt3;
    this.dXF = paramInt4;
    this.asg = paramLong;
  }
  
  public void a(Activity paramActivity, apwe.b paramb)
  {
    if (this.mActionSheet == null)
    {
      View localView = paramActivity.getLayoutInflater().inflate(2131560843, null);
      this.mActionSheet = ausj.d(paramActivity);
      this.mActionSheet.setCloseAutoRead(true);
      this.mActionSheet.setActionContentView(localView, null);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = ((WheelPickerLayout)localView.findViewById(2131380195));
      WheelPickerLayout.d locald = new WheelPickerLayout.d();
      paramActivity = paramActivity.getResources();
      locald.mItemHeight = 33;
      locald.mTextSize = 23;
      locald.mTextColor = paramActivity.getColor(2131167392);
      locald.mGravity = 17;
      locald.dXJ = 23;
      locald.dXK = paramActivity.getColor(2131167304);
      this.jdField_a_of_type_Apwe$a = new apwe.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.a(this.jdField_a_of_type_Apwe$a, locald);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setPickListener(new apwf(this));
      paramActivity = localView.findViewById(2131363826);
      if (paramActivity != null) {
        paramActivity.setOnClickListener(new apwg(this, paramb));
      }
    }
    if (!this.mActionSheet.isShowing())
    {
      paramActivity = this.jdField_a_of_type_Apwe$a.c(this.asg);
      int i = 0;
      while (i < paramActivity.length)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.setSelection(i, paramActivity[i]);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.LV(i);
        i += 1;
      }
      this.z = this.jdField_a_of_type_Apwe$a.a(paramActivity);
    }
    try
    {
      this.mActionSheet.show();
      return;
    }
    catch (Exception paramActivity) {}
  }
  
  class a
    implements WheelPickerLayout.c
  {
    private WheelPickerLayout jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout;
    private Date i;
    private final DateFormat j = new SimpleDateFormat("M月d日");
    private boolean mIsToday = true;
    
    public a(WheelPickerLayout paramWheelPickerLayout)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout = paramWheelPickerLayout;
      this.i = new Date();
      paramWheelPickerLayout = Calendar.getInstance();
      paramWheelPickerLayout.setTime(this.i);
      paramWheelPickerLayout.set(13, 0);
      paramWheelPickerLayout.set(14, 0);
      int k = paramWheelPickerLayout.get(11);
      if (k >= apwe.a(apwe.this))
      {
        paramWheelPickerLayout.add(5, 1);
        paramWheelPickerLayout.set(11, apwe.b(apwe.this));
        paramWheelPickerLayout.set(12, 0);
        this.mIsToday = false;
      }
      for (;;)
      {
        this.i = paramWheelPickerLayout.getTime();
        return;
        if (k < apwe.b(apwe.this))
        {
          paramWheelPickerLayout.set(11, apwe.b(apwe.this));
          paramWheelPickerLayout.set(12, 0);
        }
        else
        {
          k = paramWheelPickerLayout.get(12);
          paramWheelPickerLayout.add(12, apwe.c(apwe.this) - k % apwe.c(apwe.this));
        }
      }
    }
    
    private String fU(int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(this.i);
      if (paramInt > 0) {
        localCalendar.add(5, paramInt);
      }
      long l1 = this.i.getTime();
      long l2 = localCalendar.getTimeInMillis();
      int k = (int)((l2 - l1) / 86400000L);
      paramInt = k;
      if (!this.mIsToday) {
        paramInt = k + 1;
      }
      if (paramInt != 0) {
        localStringBuilder.append(this.j.format(Long.valueOf(l2))).append(" ");
      }
      switch (paramInt)
      {
      default: 
        localStringBuilder.append(fV(localCalendar.get(7)));
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("今天");
        continue;
        localStringBuilder.append("明天");
        continue;
        localStringBuilder.append("后天");
      }
    }
    
    private String fV(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "";
      case 1: 
        return acfp.m(2131716054);
      case 2: 
        return acfp.m(2131716067);
      case 3: 
        return acfp.m(2131716058);
      case 4: 
        return acfp.m(2131716052);
      case 5: 
        return acfp.m(2131716050);
      case 6: 
        return acfp.m(2131716066);
      }
      return acfp.m(2131716068);
    }
    
    public int a(Calendar paramCalendar, int paramInt)
    {
      paramInt = a(new int[] { paramInt }).get(11);
      paramInt = paramCalendar.get(11) - paramInt;
      if (paramInt > 0) {
        return paramInt;
      }
      return 0;
    }
    
    public int a(Calendar paramCalendar, int paramInt1, int paramInt2)
    {
      long l = a(new int[] { paramInt1, paramInt2 }).get(12);
      paramInt1 = (int)((paramCalendar.get(12) - l) / apwe.c(apwe.this));
      if (paramInt1 > 0) {
        return paramInt1;
      }
      return 0;
    }
    
    public Calendar a(int... paramVarArgs)
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTime(this.i);
      if (paramVarArgs[0] > 0)
      {
        localCalendar.add(5, paramVarArgs[0]);
        localCalendar.set(11, apwe.b(apwe.this));
        localCalendar.set(12, 0);
      }
      if ((paramVarArgs.length > 1) && (paramVarArgs[1] > 0))
      {
        localCalendar.add(11, paramVarArgs[1]);
        localCalendar.set(12, 0);
      }
      if (paramVarArgs.length > 2) {
        localCalendar.add(12, paramVarArgs[2] * apwe.c(apwe.this));
      }
      return localCalendar;
    }
    
    public int[] c(long paramLong)
    {
      int[] arrayOfInt = new int[3];
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTime(this.i);
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramLong);
      localCalendar2.set(11, 0);
      localCalendar2.set(12, 0);
      localCalendar2.set(13, 0);
      localCalendar2.set(14, 0);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      arrayOfInt[0] = ((int)((localCalendar1.getTimeInMillis() - localCalendar2.getTimeInMillis()) / 86400000L));
      localCalendar2 = a(new int[] { arrayOfInt[0] });
      localCalendar1.setTimeInMillis(paramLong);
      arrayOfInt[1] = (localCalendar1.get(11) - localCalendar2.get(11));
      localCalendar2 = a(new int[] { arrayOfInt[0], arrayOfInt[1] });
      arrayOfInt[2] = ((localCalendar1.get(12) - localCalendar2.get(12)) / apwe.c(apwe.this));
      return arrayOfInt;
    }
    
    public String d(int paramInt1, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return "";
      case 0: 
        return fU(paramInt2);
      case 1: 
        return String.format("%d点", new Object[] { Integer.valueOf(a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.ha(0), paramInt2 }).get(11)) });
      }
      return String.format("%d分", new Object[] { Integer.valueOf(a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.ha(0), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.ha(1), paramInt2 }).get(12)) });
    }
    
    public int t(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 0: 
        return apwe.d(apwe.this);
      case 1: 
        paramInt = a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.ha(0) }).get(11);
        return apwe.a(apwe.this) - paramInt + 1;
      }
      return (60 - a(new int[] { this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.ha(0), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout.ha(1) }).get(12)) / apwe.c(apwe.this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void kc(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwe
 * JD-Core Version:    0.7.0.1
 */