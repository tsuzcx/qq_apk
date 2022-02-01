import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aedf
  implements View.OnClickListener
{
  public aedf(ColorNoteSettingFragment paramColorNoteSettingFragment, aedn paramaedn, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.onHeaderClick(paramView, this.val$type);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedf
 * JD-Core Version:    0.7.0.1
 */