import com.tencent.mobileqq.widget.DoodlePicView;

public class hgk
  implements Runnable
{
  public hgk(DoodlePicView paramDoodlePicView) {}
  
  public void run()
  {
    DoodlePicView.a(this.a, this.a.a);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgk
 * JD-Core Version:    0.7.0.1
 */