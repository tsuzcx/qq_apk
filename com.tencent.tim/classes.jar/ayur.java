import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayur
  implements View.OnClickListener
{
  ayur(ayup paramayup) {}
  
  public void onClick(View paramView)
  {
    rar.a("video_edit_new", "clk_cutdown", 0, 0, new String[0]);
    if (!ayup.a(this.a).dAP) {
      ayup.b(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ayup.a(this.a).dAP = false;
      ayup.b(this.a).setSelected(false);
      ayup.a(this.a).afI(3003);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayur
 * JD-Core Version:    0.7.0.1
 */