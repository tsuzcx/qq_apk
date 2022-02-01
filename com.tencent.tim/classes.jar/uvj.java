import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uvj
  implements View.OnClickListener
{
  public uvj(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    EditActivity localEditActivity = this.this$0;
    boolean bool;
    if (!EditActivity.a(this.this$0))
    {
      bool = true;
      EditActivity.a(localEditActivity, bool);
      if (!EditActivity.a(this.this$0)) {
        break label86;
      }
      this.this$0.gR();
      EditActivity.a(this.this$0).setImageResource(2130838169);
      if (EditActivity.a(this.this$0) != null) {
        EditActivity.a(this.this$0).setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label86:
      if (EditActivity.a(this.this$0) != null) {
        EditActivity.a(this.this$0).setVisibility(4);
      }
      EditActivity.a(this.this$0).setImageResource(2130848765);
      this.this$0.IM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvj
 * JD-Core Version:    0.7.0.1
 */