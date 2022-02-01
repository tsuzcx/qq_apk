import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

public class wmy
{
  public static TextureView a(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        TextureView localTextureView = a(paramView.getChildAt(i));
        if (localTextureView != null) {
          return localTextureView;
        }
        i += 1;
      }
    }
    if ((paramView instanceof TextureView)) {
      return (TextureView)paramView;
    }
    return null;
  }
  
  public static boolean a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap.getConfig() != Bitmap.Config.ARGB_8888)
    {
      yos.a(false, "bitmap is not ARGB_8888");
      return false;
    }
    int j = paramBitmap.getWidth();
    int k = paramBitmap.getHeight();
    int m = j / paramInt1;
    int n = k / paramInt1;
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 >= j) {
        break label118;
      }
      int i = 0;
      for (;;)
      {
        if (i >= k) {
          break label110;
        }
        int i1 = paramBitmap.getPixel(paramInt1, i);
        if (((i1 & 0xFF) > paramInt2) || ((i1 >> 8 & 0xFF) > paramInt2) || ((i1 >> 16 & 0xFF) > paramInt2)) {
          break;
        }
        i += n;
      }
      label110:
      paramInt1 += m;
    }
    label118:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmy
 * JD-Core Version:    0.7.0.1
 */