import android.graphics.Rect;

class cwi
  implements Runnable
{
  cwi(cwh paramcwh) {}
  
  public void run()
  {
    if (!this.a.a.a.jdField_a_of_type_Boolean) {
      this.a.a.a.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.a.a.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwi
 * JD-Core Version:    0.7.0.1
 */