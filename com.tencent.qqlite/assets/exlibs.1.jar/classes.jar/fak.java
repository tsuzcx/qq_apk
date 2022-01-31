import com.tencent.mobileqq.widget.DoodlePicView;

public class fak
  implements Runnable
{
  public fak(DoodlePicView paramDoodlePicView) {}
  
  public void run()
  {
    DoodlePicView.a(this.a, this.a.a);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     fak
 * JD-Core Version:    0.7.0.1
 */