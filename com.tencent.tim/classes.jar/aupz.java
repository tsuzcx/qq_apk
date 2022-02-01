import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoNewActivity;
import com.tencent.tim.todo.widget.TodoCardView;

public class aupz
  implements View.OnClickListener
{
  public aupz(TodoCardView paramTodoCardView) {}
  
  public void onClick(View paramView)
  {
    if (TodoCardView.a(this.c))
    {
      this.c.performClick();
      aupe.L((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "0X80091B2", 1);
    }
    Intent localIntent = new Intent(this.c.getContext(), TodoNewActivity.class);
    localIntent.putExtra("param_mode", 0);
    this.c.getContext().startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupz
 * JD-Core Version:    0.7.0.1
 */