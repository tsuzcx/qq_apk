package me.ele.uetool;

import android.view.View;
import android.view.ViewGroup;
import me.ele.uetool.view.HierarchyView;
import me.ele.uetool.view.HierarchyView.IRemoveView;

class TransparentActivity$4
  implements HierarchyView.IRemoveView
{
  TransparentActivity$4(TransparentActivity paramTransparentActivity) {}
  
  public void removeView(View paramView)
  {
    TransparentActivity.access$000(this.this$0).removeView(paramView);
    TransparentActivity.access$102(this.this$0, false);
    TransparentActivity.access$200(this.this$0).clearTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.TransparentActivity.4
 * JD-Core Version:    0.7.0.1
 */