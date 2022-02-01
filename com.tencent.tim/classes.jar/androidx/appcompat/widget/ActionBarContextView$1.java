package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.view.ActionMode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ActionBarContextView$1
  implements View.OnClickListener
{
  ActionBarContextView$1(ActionBarContextView paramActionBarContextView, ActionMode paramActionMode) {}
  
  public void onClick(View paramView)
  {
    this.val$mode.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarContextView.1
 * JD-Core Version:    0.7.0.1
 */