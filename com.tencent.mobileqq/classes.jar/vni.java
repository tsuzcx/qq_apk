import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.MotionEvent;

class vni
  implements RecyclerView.OnItemTouchListener
{
  private int jdField_a_of_type_Int;
  private int b;
  
  vni(vnh paramvnh) {}
  
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
    } while (vnh.a(this.jdField_a_of_type_Vnh, paramMotionEvent));
    if ((Math.abs(j) > vnh.a(this.jdField_a_of_type_Vnh)) && (Math.abs(j) >= Math.abs(i))) {}
    for (int i = 1; i != 0; i = 0)
    {
      vnh.a(this.jdField_a_of_type_Vnh, j, k);
      return false;
    }
    vnh.b(this.jdField_a_of_type_Vnh, j, k);
    return false;
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vni
 * JD-Core Version:    0.7.0.1
 */