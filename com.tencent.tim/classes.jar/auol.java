import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoNewActivity;

public class auol
  implements View.OnClickListener
{
  public auol(TodoNewActivity paramTodoNewActivity, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    TodoNewActivity.a(this.this$0, false);
    if (TodoNewActivity.a(this.this$0) != 0L)
    {
      TodoNewActivity.a(this.this$0, 0L);
      this.hL.setText("取消");
      TodoNewActivity.a(this.this$0).setText(this.this$0.getResources().getString(2131721206));
      TodoNewActivity.d(this.this$0);
      if (TodoNewActivity.a(this.this$0) != 4) {
        break label99;
      }
      aupe.L(this.this$0.app, "0X80091B8", 1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label99:
      if (TodoNewActivity.a(this.this$0) == 0) {
        aupe.L(this.this$0.app, "0X80091BF", 1);
      } else if (TodoNewActivity.a(this.this$0) == 1) {
        aupe.L(this.this$0.app, "0X80091CB", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auol
 * JD-Core Version:    0.7.0.1
 */