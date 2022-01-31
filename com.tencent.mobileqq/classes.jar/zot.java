import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GreetWording;

public class zot
  implements Runnable
{
  public zot(NearbyGrayTipsManager.GreetWording paramGreetWording1, NearbyGrayTipsManager.GreetWording paramGreetWording2) {}
  
  public void run()
  {
    String str = NearbyGrayTipsManager.GreetWording.getPath(this.a.id);
    NearbyGrayTipsManager.a(this.a, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zot
 * JD-Core Version:    0.7.0.1
 */