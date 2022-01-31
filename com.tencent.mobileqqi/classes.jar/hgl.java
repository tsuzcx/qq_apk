import com.tencent.mobileqq.widget.DoodlePicView;

public class hgl
  implements Runnable
{
  public hgl(DoodlePicView paramDoodlePicView) {}
  
  public void run()
  {
    DoodlePicView.a(this.a, this.a.a);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hgl
 * JD-Core Version:    0.7.0.1
 */