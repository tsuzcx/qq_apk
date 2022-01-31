import android.graphics.Rect;

class cwc
  implements Runnable
{
  cwc(cwb paramcwb) {}
  
  public void run()
  {
    if (!this.a.a.a.jdField_a_of_type_Boolean) {
      this.a.a.a.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.a.a.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cwc
 * JD-Core Version:    0.7.0.1
 */