import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aeck
  implements View.OnClickListener
{
  aeck(aecj paramaecj) {}
  
  public void onClick(View paramView)
  {
    if ((aecj.a(this.a) != null) && (aecj.a(this.a).getVisibility() == 0) && (aecj.a(this.a).hasFocus())) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aecj.a(this.a);
      Bundle localBundle = new Bundle();
      localBundle.putInt("start_from", 1);
      ColorNoteSettingFragment.a(aecj.a(this.a), ColorNoteSettingFragment.class, localBundle);
      anot.a(null, "dc00898", "", "", "0X800A8AF", "0X800A8AF", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeck
 * JD-Core Version:    0.7.0.1
 */