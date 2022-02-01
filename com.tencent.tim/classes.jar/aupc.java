import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.TodoNewActivity.a;

public class aupc
  implements View.OnClickListener
{
  public aupc(TodoNewActivity paramTodoNewActivity, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    long l = TodoNewActivity.a(this.this$0).w();
    TodoNewActivity.a(this.this$0).setCompoundDrawablesWithIntrinsicBounds(2130851748, 0, 0, 0);
    TodoNewActivity.a(this.this$0).setText(aupe.cm(l));
    TodoNewActivity.a(this.this$0, false);
    TodoNewActivity.a(this.this$0, l);
    TodoNewActivity.d(this.this$0);
    if (TodoNewActivity.a(this.this$0) != 0L) {
      this.hL.setText("删除提醒");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupc
 * JD-Core Version:    0.7.0.1
 */