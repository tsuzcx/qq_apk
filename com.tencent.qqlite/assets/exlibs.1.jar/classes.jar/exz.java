import com.tencent.mobileqq.widget.DoodlePicView;

public class exz
  implements Runnable
{
  public exz(DoodlePicView paramDoodlePicView) {}
  
  public void run()
  {
    DoodlePicView.a(this.a, this.a.a);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     exz
 * JD-Core Version:    0.7.0.1
 */