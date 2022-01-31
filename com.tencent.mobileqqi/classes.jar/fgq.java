import android.graphics.Rect;

class fgq
  implements Runnable
{
  fgq(fgp paramfgp) {}
  
  public void run()
  {
    if (!this.a.a.a.jdField_a_of_type_Boolean) {
      this.a.a.a.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.a.a.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgq
 * JD-Core Version:    0.7.0.1
 */