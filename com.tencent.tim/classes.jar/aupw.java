import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.widget.EmptyScheduleView;
import com.tencent.tim.todo.widget.EmptyScheduleView.a;
import com.tencent.tim.todo.widget.EmptyScheduleView.a.a;
import com.tencent.tim.todo.widget.EmptyScheduleView.b;
import com.tencent.tim.todo.widget.EmptyScheduleView.c;

public class aupw
  implements View.OnClickListener
{
  public aupw(EmptyScheduleView.a parama) {}
  
  public void onClick(View paramView)
  {
    EmptyScheduleView.b localb = ((EmptyScheduleView.a.a)paramView.getTag()).a;
    if ((EmptyScheduleView.a(this.b.b) != null) && (EmptyScheduleView.a.a(this.b) == localb.position)) {
      EmptyScheduleView.a(this.b.b).a(localb, paramView);
    }
    this.b.xC(localb.position);
    this.b.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupw
 * JD-Core Version:    0.7.0.1
 */