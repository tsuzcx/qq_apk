import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class txl
  implements RecyclerView.OnItemTouchListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  txl(txk paramtxk) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (txk.a(this.jdField_a_of_type_Txk)) {}
    int j;
    int i;
    do
    {
      return false;
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        return false;
      case 0: 
        this.b = ((int)(paramMotionEvent.getX() + 0.5F));
        this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
        return false;
      }
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.b;
      i = (int)((i - this.jdField_a_of_type_Int) * 0.6F);
    } while ((Math.abs(j) <= txk.a(this.jdField_a_of_type_Txk)) || (Math.abs(j) < Math.abs(i)) || (txk.a(this.jdField_a_of_type_Txk) == null));
    txk.a(this.jdField_a_of_type_Txk).requestDisallowInterceptTouchEvent(true);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txl
 * JD-Core Version:    0.7.0.1
 */