import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uvk
  implements View.OnClickListener
{
  public uvk(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity.a(this.this$0).setVisibility(4);
    EditActivity.a(this.this$0).setImageResource(2130848765);
    EditActivity.a(this.this$0, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvk
 * JD-Core Version:    0.7.0.1
 */