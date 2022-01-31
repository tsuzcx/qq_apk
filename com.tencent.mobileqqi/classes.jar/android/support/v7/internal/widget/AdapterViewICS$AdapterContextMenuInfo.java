package android.support.v7.internal.widget;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;

public class AdapterViewICS$AdapterContextMenuInfo
  implements ContextMenu.ContextMenuInfo
{
  public long id;
  public int position;
  public View targetView;
  
  public AdapterViewICS$AdapterContextMenuInfo(View paramView, int paramInt, long paramLong)
  {
    this.targetView = paramView;
    this.position = paramInt;
    this.id = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewICS.AdapterContextMenuInfo
 * JD-Core Version:    0.7.0.1
 */