import com.tribe.async.dispatch.Dispatcher.Event;

public class yry
  implements Dispatcher.Event
{
  public float a;
  public float b;
  public float c;
  public float d;
  
  public yry(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.d = paramFloat4;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.a = paramFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yry
 * JD-Core Version:    0.7.0.1
 */