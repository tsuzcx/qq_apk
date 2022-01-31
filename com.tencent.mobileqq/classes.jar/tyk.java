import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class tyk
  implements RecyclerView.OnItemTouchListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  tyk(tyj paramtyj) {}
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    int j;
    int k;
    do
    {
      return false;
      this.b = ((int)(paramMotionEvent.getX() + 0.5F));
      this.jdField_a_of_type_Int = ((int)(paramMotionEvent.getY() + 0.5F));
      return false;
      j = (int)(paramMotionEvent.getX() + 0.5F);
      i = (int)(paramMotionEvent.getY() + 0.5F);
      j -= this.b;
      k = i - this.jdField_a_of_type_Int;
      i = (int)((i - this.jdField_a_of_type_Int) * 0.6F);
    } while (tyj.a(this.jdField_a_of_type_Tyj, paramMotionEvent));
    if ((Math.abs(j) > tyj.a(this.jdField_a_of_type_Tyj)) && (Math.abs(j) >= Math.abs(i))) {}
    for (int i = 1; i != 0; i = 0)
    {
      tyj.a(this.jdField_a_of_type_Tyj, j, k);
      return false;
    }
    tyj.b(this.jdField_a_of_type_Tyj, j, k);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyk
 * JD-Core Version:    0.7.0.1
 */