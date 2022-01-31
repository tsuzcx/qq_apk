import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class txm
  implements RecyclerView.OnItemTouchListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  txm(txk paramtxk) {}
  
  private boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int j;
    do
    {
      return false;
      this.b = ((int)(paramMotionEvent.getX() + 0.5F));
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
      return false;
      j = (int)(paramMotionEvent.getX() + 0.5F);
      int i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.b;
      i = (int)((i - this.jdField_a_of_type_Int) * 0.6F);
    } while ((Math.abs(j) <= txk.a(this.jdField_a_of_type_Txk) * 2) || (j <= 0));
    ((Activity)paramRecyclerView.getContext()).finish();
    return false;
  }
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)) && (((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() != 0)) {
      return false;
    }
    return a(paramRecyclerView, paramMotionEvent);
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txm
 * JD-Core Version:    0.7.0.1
 */