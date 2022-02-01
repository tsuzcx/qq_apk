package me.ele.uetool;

import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import me.ele.uetool.base.Element;
import me.ele.uetool.colorpicker.listener.OnColorChangedListener;
import me.ele.uetool.dialog.AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange;

class UETCore$1$1
  implements OnColorChangedListener
{
  UETCore$1$1(UETCore.1 param1, Element paramElement, Object paramObject) {}
  
  public void onColorChanged(int paramInt)
  {
    Log.i("UETCore", "onSelected: " + paramInt);
    ColorDrawable localColorDrawable = new ColorDrawable(paramInt);
    this.val$element.getView().setBackground(localColorDrawable);
    if ((this.val$valAfterChange instanceof AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange)) {
      ((AttrsDialog.Adapter.SwitchViewHolder.AfterColorChange)this.val$valAfterChange).afterColorChange(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETCore.1.1
 * JD-Core Version:    0.7.0.1
 */