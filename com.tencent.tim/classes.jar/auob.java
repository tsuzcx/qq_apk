import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.todo.TodoNewActivity;

class auob
  implements View.OnClickListener
{
  auob(aunz paramaunz) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aunz.a(this.this$0), TodoNewActivity.class);
    localIntent.putExtra("param_mode", 0);
    aunz.a(this.this$0).startActivity(localIntent);
    aupe.L(aunz.a(this.this$0), "0X80091BB", 1);
    anpc.report("tim_mine_tab_remain_click_add_remain_click");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auob
 * JD-Core Version:    0.7.0.1
 */