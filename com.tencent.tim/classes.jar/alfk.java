import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.mobileqq.profile.stickynote.vas.StickyNoteShopLayout;
import com.tencent.qphone.base.util.QLog;

public class alfk
  extends RecyclerView.OnScrollListener
{
  public alfk(StickyNoteShopLayout paramStickyNoteShopLayout) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (paramInt == 0)
    {
      paramRecyclerView = StickyNoteShopLayout.a(this.this$0).getLayoutManager();
      int i = 0;
      if ((paramRecyclerView instanceof StaggeredGridLayoutManager))
      {
        int[] arrayOfInt = new int[((StaggeredGridLayoutManager)paramRecyclerView).getSpanCount()];
        arrayOfInt = ((StaggeredGridLayoutManager)paramRecyclerView).findLastVisibleItemPositions(arrayOfInt);
        i = StickyNoteShopLayout.a(this.this$0, arrayOfInt);
      }
      if ((paramRecyclerView.getChildCount() > 0) && (i >= paramRecyclerView.getItemCount() - 1))
      {
        this.this$0.NI(true);
        QLog.d("StickyNoteShopLayout", 2, " load more shop data newState:" + paramInt + " lastVisiblePosition:" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alfk
 * JD-Core Version:    0.7.0.1
 */