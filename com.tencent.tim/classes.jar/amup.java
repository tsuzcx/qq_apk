import android.content.Context;
import com.tencent.image.AbstractGifImage;

public class amup
  extends amuo
{
  protected amum a(Context paramContext)
  {
    return new amyx(this, paramContext);
  }
  
  public void aT(String paramString1, String paramString2, String paramString3)
  {
    super.aT(paramString1, paramString2, paramString3);
    paramString1 = a();
    if (paramString1 != null) {
      paramString1.update();
    }
  }
  
  public void pause()
  {
    super.pause();
    AbstractGifImage.pauseAll();
  }
  
  public void resume()
  {
    super.resume();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amup
 * JD-Core Version:    0.7.0.1
 */