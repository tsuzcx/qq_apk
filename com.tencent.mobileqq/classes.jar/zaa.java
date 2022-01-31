import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class zaa
  implements View.OnTouchListener
{
  private static final int jdField_a_of_type_Int = bbkx.b(3.0F);
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private int b;
  private int c;
  
  public zaa(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.b = j;
      this.c = i;
      return true;
      j = Math.abs(j - this.b);
      i = Math.abs(i - this.c);
      if ((j < jdField_a_of_type_Int) && (i < jdField_a_of_type_Int) && (this.jdField_a_of_type_JavaLangRunnable != null)) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zaa
 * JD-Core Version:    0.7.0.1
 */