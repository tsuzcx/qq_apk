import android.graphics.Rect;

class fgp
  implements Runnable
{
  fgp(fgo paramfgo) {}
  
  public void run()
  {
    if (!this.a.a.a.jdField_a_of_type_Boolean) {
      this.a.a.a.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.a.a.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fgp
 * JD-Core Version:    0.7.0.1
 */