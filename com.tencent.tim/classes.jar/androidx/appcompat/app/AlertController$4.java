package androidx.appcompat.app;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlertController$4
  implements AbsListView.OnScrollListener
{
  AlertController$4(AlertController paramAlertController, View paramView1, View paramView2) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AlertController.manageScrollIndicators(paramAbsListView, this.val$top, this.val$bottom);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.4
 * JD-Core Version:    0.7.0.1
 */