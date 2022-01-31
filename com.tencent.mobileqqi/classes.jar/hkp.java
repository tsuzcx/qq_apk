import com.tencent.mobileqq.widget.DoodlePicView;

public class hkp
  implements Runnable
{
  public hkp(DoodlePicView paramDoodlePicView) {}
  
  public void run()
  {
    DoodlePicView.a(this.a, this.a.a);
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hkp
 * JD-Core Version:    0.7.0.1
 */