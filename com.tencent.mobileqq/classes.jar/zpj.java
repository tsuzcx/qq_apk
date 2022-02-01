import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;

public class zpj
  extends LinearLayoutManager
{
  public zpj(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      super.onLayoutChildren(paramRecycler, paramState);
      return;
    }
    catch (Exception paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
      return paramInt;
    }
    catch (IndexOutOfBoundsException paramRecycler)
    {
      paramRecycler.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpj
 * JD-Core Version:    0.7.0.1
 */