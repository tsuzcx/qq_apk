import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class yiv
{
  public static int a(RecyclerView paramRecyclerView)
  {
    int i;
    if (paramRecyclerView != null) {
      try
      {
        if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
          return ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        }
        if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
        {
          i = paramRecyclerView.getLayoutManager().getColumnCountForAccessibility(null, null);
          int[] arrayOfInt = new int[i];
          ((StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager()).findLastCompletelyVisibleItemPositions(arrayOfInt);
          i = arrayOfInt[(i - 1)];
          if (arrayOfInt.length != 2) {
            return i;
          }
          if (arrayOfInt[1] >= arrayOfInt[0]) {
            return arrayOfInt[1];
          }
          i = arrayOfInt[0];
          return i;
        }
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    } else {
      i = -1;
    }
    return i;
  }
  
  public static int b(RecyclerView paramRecyclerView)
  {
    int i;
    if (paramRecyclerView != null) {
      try
      {
        if ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
          return ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        }
        if ((paramRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager))
        {
          i = paramRecyclerView.getLayoutManager().getColumnCountForAccessibility(null, null);
          int[] arrayOfInt = new int[i];
          ((StaggeredGridLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(arrayOfInt);
          i = arrayOfInt[(i - 1)];
          if (arrayOfInt.length != 2) {
            return i;
          }
          if (arrayOfInt[1] >= arrayOfInt[0]) {
            return arrayOfInt[0];
          }
          i = arrayOfInt[1];
          return i;
        }
      }
      catch (Exception paramRecyclerView)
      {
        paramRecyclerView.printStackTrace();
      }
    } else {
      i = -1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yiv
 * JD-Core Version:    0.7.0.1
 */