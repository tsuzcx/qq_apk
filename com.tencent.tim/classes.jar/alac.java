import android.content.res.Resources;
import android.graphics.Bitmap;

public class alac
{
  public int alpha;
  public double angle;
  public Bitmap bitmap;
  public float[] cT;
  public int height;
  public float qB;
  public float qC;
  public float rotation;
  public float speed;
  public long startTime;
  public int type;
  public int width;
  public float yo;
  
  public static alac a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, int paramInt, Resources paramResources)
  {
    alac localalac = new alac();
    localalac.type = paramInt;
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    if (paramInt == 0) {}
    for (localalac.width = wja.dp2px(30.0F, paramResources);; localalac.width = wja.dp2px(22.0F, paramResources))
    {
      localalac.height = ((int)(f * localalac.width));
      localalac.cT = new float[2];
      localalac.cT[0] = paramFloat1;
      localalac.cT[1] = paramFloat2;
      localalac.rotation = ((float)Math.random() * wja.dp2px(18.0F, paramResources) - wja.dp2px(9.0F, paramResources));
      localalac.angle = (Math.random() * 3.141592653589793D / 6.0D + 1.308996938995747D);
      localalac.speed = (wja.dp2px(150.0F, paramResources) + (float)Math.random() * wja.dp2px(50.0F, paramResources));
      localalac.qB = ((float)(localalac.speed * Math.cos(localalac.angle)));
      localalac.qC = ((float)(localalac.speed * Math.sin(localalac.angle)));
      localalac.alpha = 256;
      localalac.bitmap = paramBitmap;
      return localalac;
    }
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alac
 * JD-Core Version:    0.7.0.1
 */