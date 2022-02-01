import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayug
  implements View.OnClickListener
{
  ayug(ayuf paramayuf) {}
  
  public void onClick(View paramView)
  {
    rar.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!this.b.a().aRc()) {
      ayuf.a(this.b);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.b.a().ZO(false);
      ayuf.a(this.b).setSelected(false);
      this.b.a().afJ(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayug
 * JD-Core Version:    0.7.0.1
 */