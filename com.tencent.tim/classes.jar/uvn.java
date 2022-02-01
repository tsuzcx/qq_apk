import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uvn
  implements View.OnClickListener
{
  public uvn(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    if ((EditActivity.a(this.this$0) != null) && (EditActivity.a(this.this$0).isShowing()) && (EditActivity.a(this.this$0).getWindow() != null)) {
      EditActivity.a(this.this$0).dismiss();
    }
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvn
 * JD-Core Version:    0.7.0.1
 */