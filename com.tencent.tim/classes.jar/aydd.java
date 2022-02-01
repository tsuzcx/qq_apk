import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aydd
  implements View.OnClickListener
{
  aydd(aydc paramaydc) {}
  
  public void onClick(View paramView)
  {
    if (aydc.a(this.a))
    {
      aydc.a(this.a, false);
      aydc.a(this.a).setChecked(false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aydc.a(this.a, true);
      aydc.a(this.a).setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydd
 * JD-Core Version:    0.7.0.1
 */