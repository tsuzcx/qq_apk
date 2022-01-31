package android.support.v4.view;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@RequiresApi(19)
class ViewParentCompat$ViewParentCompatApi19Impl
  extends ViewParentCompat.ViewParentCompatBaseImpl
{
  public void notifySubtreeAccessibilityStateChanged(ViewParent paramViewParent, View paramView1, View paramView2, int paramInt)
  {
    paramViewParent.notifySubtreeAccessibilityStateChanged(paramView1, paramView2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewParentCompat.ViewParentCompatApi19Impl
 * JD-Core Version:    0.7.0.1
 */