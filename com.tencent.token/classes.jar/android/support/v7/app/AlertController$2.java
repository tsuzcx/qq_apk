package android.support.v7.app;

import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.view.View;

class AlertController$2
  implements NestedScrollView.OnScrollChangeListener
{
  AlertController$2(AlertController paramAlertController, View paramView1, View paramView2) {}
  
  public void onScrollChange(NestedScrollView paramNestedScrollView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AlertController.manageScrollIndicators(paramNestedScrollView, this.val$top, this.val$bottom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AlertController.2
 * JD-Core Version:    0.7.0.1
 */