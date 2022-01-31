package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ListView;

public final class ListViewCompat
{
  public static boolean canScrollList(@NonNull ListView paramListView, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 19) {
      bool1 = paramListView.canScrollList(paramInt);
    }
    label83:
    do
    {
      int i;
      do
      {
        int j;
        do
        {
          return bool1;
          j = paramListView.getChildCount();
          bool1 = bool2;
        } while (j == 0);
        i = paramListView.getFirstVisiblePosition();
        if (paramInt <= 0) {
          break label83;
        }
        paramInt = paramListView.getChildAt(j - 1).getBottom();
        if (j + i < paramListView.getCount()) {
          break;
        }
        bool1 = bool2;
      } while (paramInt <= paramListView.getHeight() - paramListView.getListPaddingBottom());
      return true;
      paramInt = paramListView.getChildAt(0).getTop();
      if (i > 0) {
        break;
      }
      bool1 = bool2;
    } while (paramInt >= paramListView.getListPaddingTop());
    return true;
  }
  
  public static void scrollListBy(@NonNull ListView paramListView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramListView.scrollListBy(paramInt);
    }
    int i;
    View localView;
    do
    {
      do
      {
        return;
        i = paramListView.getFirstVisiblePosition();
      } while (i == -1);
      localView = paramListView.getChildAt(0);
    } while (localView == null);
    paramListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ListViewCompat
 * JD-Core Version:    0.7.0.1
 */