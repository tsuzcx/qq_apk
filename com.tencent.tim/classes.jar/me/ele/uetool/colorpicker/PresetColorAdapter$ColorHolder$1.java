package me.ele.uetool.colorpicker;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PresetColorAdapter$ColorHolder$1
  implements View.OnClickListener
{
  PresetColorAdapter$ColorHolder$1(PresetColorAdapter.ColorHolder paramColorHolder, PresetColorAdapter paramPresetColorAdapter) {}
  
  public void onClick(View paramView)
  {
    PresetColorAdapter.ColorHolder localColorHolder = this.this$1;
    boolean bool;
    if (!this.this$1.isChosen)
    {
      bool = true;
      localColorHolder.isChosen = bool;
      this.this$1.roundView.setChosen(this.this$1.isChosen);
      PresetColorAdapter.access$000(this.this$1.this$0).setColor(this.this$1.color);
      if (!this.this$1.isChosen) {
        break label124;
      }
      if (PresetColorAdapter.access$100(this.this$1.this$0) != null) {
        PresetColorAdapter.access$100(this.this$1.this$0).setChosen(false);
      }
      PresetColorAdapter.access$102(this.this$1.this$0, this.this$1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label124:
      if (PresetColorAdapter.access$100(this.this$1.this$0) == this.this$1) {
        PresetColorAdapter.access$102(this.this$1.this$0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.colorpicker.PresetColorAdapter.ColorHolder.1
 * JD-Core Version:    0.7.0.1
 */