package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class CoordinatorLayout$HierarchyChangeListener
  implements ViewGroup.OnHierarchyChangeListener
{
  CoordinatorLayout$HierarchyChangeListener(CoordinatorLayout paramCoordinatorLayout) {}
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    if (this.this$0.mOnHierarchyChangeListener != null) {
      this.this$0.mOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.this$0.onChildViewsChanged(2);
    if (this.this$0.mOnHierarchyChangeListener != null) {
      this.this$0.mOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.HierarchyChangeListener
 * JD-Core Version:    0.7.0.1
 */