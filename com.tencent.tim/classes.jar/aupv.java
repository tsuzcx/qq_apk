import android.util.Log;
import android.view.View;
import com.tencent.tim.todo.widget.EmptyScheduleView;
import com.tencent.tim.todo.widget.EmptyScheduleView.a;
import com.tencent.tim.todo.widget.EmptyScheduleView.b;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

public class aupv
  implements AdapterView.c
{
  public aupv(EmptyScheduleView paramEmptyScheduleView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Log.i("EmptyScheduleView", "position = " + paramInt + ", view = " + paramView + ", parent = " + paramAdapterView);
    if ((EmptyScheduleView.a(this.b) != null) && (((EmptyScheduleView.b)EmptyScheduleView.a(this.b).get(paramInt)).type == 1))
    {
      EmptyScheduleView.a(this.b).xC(paramInt);
      EmptyScheduleView.a(this.b).notifyDataSetChanged();
      EmptyScheduleView.a(this.b).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupv
 * JD-Core Version:    0.7.0.1
 */