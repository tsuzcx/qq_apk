import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

public class aeya
{
  public static aeye a(View paramView)
  {
    if ((paramView instanceof SurfaceView)) {
      return new aeyf((SurfaceView)paramView);
    }
    if ((paramView instanceof TextureView)) {
      return new aeyg((TextureView)paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeya
 * JD-Core Version:    0.7.0.1
 */