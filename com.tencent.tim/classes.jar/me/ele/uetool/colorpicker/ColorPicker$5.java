package me.ele.uetool.colorpicker;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorPicker$5
  implements View.OnClickListener
{
  ColorPicker$5(ColorPicker paramColorPicker) {}
  
  public void onClick(View paramView)
  {
    ColorPicker.access$700(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.colorpicker.ColorPicker.5
 * JD-Core Version:    0.7.0.1
 */