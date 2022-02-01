import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.TodoNewActivity.a;
import com.tencent.tim.widget.IphonePickerView;

public class aupa
  implements View.OnClickListener
{
  public aupa(TodoNewActivity paramTodoNewActivity) {}
  
  public void onClick(View paramView)
  {
    if (TodoNewActivity.a(this.this$0) == 0L) {
      TodoNewActivity.a(this.this$0).nw(NetConnInfoCenter.getServerTimeMillis() + 1800000L);
    }
    TodoNewActivity localTodoNewActivity = this.this$0;
    boolean bool;
    if (TodoNewActivity.a(this.this$0).getVisibility() != 0)
    {
      bool = true;
      TodoNewActivity.a(localTodoNewActivity, bool);
      if (TodoNewActivity.a(this.this$0) != 4) {
        break label91;
      }
      aupe.L(this.this$0.app, "0X80091B6", 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label91:
      if (TodoNewActivity.a(this.this$0) == 0) {
        aupe.L(this.this$0.app, "0X80091BD", 1);
      } else if (TodoNewActivity.a(this.this$0) == 1) {
        aupe.L(this.this$0.app, "0X80091C9", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupa
 * JD-Core Version:    0.7.0.1
 */