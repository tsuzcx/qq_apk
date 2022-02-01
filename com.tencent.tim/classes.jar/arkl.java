import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView;
import com.tencent.mobileqq.widget.datepicker.SimpleMonthView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class arkl
  extends RecyclerView.Adapter<arkl.a>
  implements SimpleMonthView.a
{
  private final TypedArray jdField_b_of_type_AndroidContentResTypedArray;
  private final arkk jdField_b_of_type_Arkk;
  private CalendarDay g;
  private final Context mContext;
  private HashMap<String, ArrayList<MessageRecord>> pK = new HashMap();
  
  public arkl(Context paramContext, arkk paramarkk, TypedArray paramTypedArray)
  {
    this.mContext = paramContext;
    this.jdField_b_of_type_Arkk = paramarkk;
    this.jdField_b_of_type_AndroidContentResTypedArray = paramTypedArray;
    if (this.jdField_b_of_type_AndroidContentResTypedArray.getBoolean(8, false)) {
      a(new CalendarDay(System.currentTimeMillis()));
    }
  }
  
  public arkl.a a(ViewGroup paramViewGroup, int paramInt)
  {
    return new arkl.a(new SimpleMonthView(this.mContext, this.jdField_b_of_type_AndroidContentResTypedArray), this);
  }
  
  public void a(arkl.a parama, int paramInt)
  {
    SimpleMonthView localSimpleMonthView = parama.a;
    HashMap localHashMap = new HashMap();
    CalendarDay localCalendarDay1 = this.jdField_b_of_type_Arkk.a();
    CalendarDay localCalendarDay2 = new CalendarDay(System.currentTimeMillis());
    CalendarDay localCalendarDay3 = new CalendarDay(localCalendarDay2.year, localCalendarDay2.month, 1);
    if (localCalendarDay1.getTimeInMillis() > localCalendarDay3.getTimeInMillis()) {
      localCalendarDay1 = new CalendarDay(localCalendarDay2.year, localCalendarDay2.month - 1, 1);
    }
    for (;;)
    {
      int i = (localCalendarDay1.month + paramInt) % 12;
      int j = localCalendarDay1.year;
      j = (localCalendarDay1.month + paramInt) / 12 + j;
      if (this.g != null)
      {
        localHashMap.put("selected_begin_year", Integer.valueOf(this.g.year));
        localHashMap.put("selected_begin_month", Integer.valueOf(this.g.month));
        localHashMap.put("selected_begin_day", Integer.valueOf(this.g.day));
      }
      localSimpleMonthView.ejB();
      localHashMap.put("year", Integer.valueOf(j));
      localHashMap.put("month", Integer.valueOf(i));
      localHashMap.put("week_start", Integer.valueOf(Calendar.getInstance().getFirstDayOfWeek()));
      localSimpleMonthView.setMonthParams(localHashMap);
      localSimpleMonthView.setMessageRecords((ArrayList)this.pK.get(j + "-" + i));
      localSimpleMonthView.setStartAndEndDate(localCalendarDay1, localCalendarDay2);
      localSimpleMonthView.invalidate();
      this.jdField_b_of_type_Arkk.a(localSimpleMonthView, j, i);
      EventCollector.getInstance().onRecyclerBindViewHolder(parama, paramInt, getItemId(paramInt));
      return;
    }
  }
  
  protected void a(CalendarDay paramCalendarDay)
  {
    this.g = paramCalendarDay;
    notifyDataSetChanged();
  }
  
  public void a(SimpleMonthView paramSimpleMonthView, CalendarDay paramCalendarDay, Object paramObject)
  {
    if ((paramCalendarDay != null) && (paramObject != null) && ((paramObject instanceof MessageRecord)))
    {
      a(paramCalendarDay);
      this.jdField_b_of_type_Arkk.a(paramCalendarDay, (MessageRecord)paramObject);
    }
  }
  
  public void b(int paramInt1, int paramInt2, ArrayList<MessageRecord> paramArrayList)
  {
    this.pK.put(paramInt1 + "-" + paramInt2, paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    int i = this.jdField_b_of_type_Arkk.a().year * 12 + this.jdField_b_of_type_Arkk.a().month;
    int j = this.jdField_b_of_type_Arkk.b().year * 12 + this.jdField_b_of_type_Arkk.b().month;
    if (i == j) {
      return 2;
    }
    return j - i + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public static class a
    extends RecyclerView.ViewHolder
  {
    final SimpleMonthView a;
    
    public a(View paramView, SimpleMonthView.a parama)
    {
      super();
      this.a = ((SimpleMonthView)paramView);
      this.a.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.a.setClickable(true);
      this.a.setOnDayClickListener(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arkl
 * JD-Core Version:    0.7.0.1
 */