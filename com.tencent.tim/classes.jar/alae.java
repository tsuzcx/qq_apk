import android.content.res.Resources;
import android.graphics.Bitmap;
import java.util.HashMap;

public class alae
{
  static HashMap<Integer, Bitmap> ml = new HashMap();
  public double angle;
  public Bitmap bitmap;
  public float[] cT;
  public int height;
  public float qB;
  public float qC;
  public float rotation;
  float speed;
  public int width;
  
  public static alae a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, Resources paramResources)
  {
    alae localalae = new alae();
    float f = paramBitmap.getHeight() / paramBitmap.getWidth();
    localalae.width = ((int)(wja.dp2px(8.0F, paramResources) + (float)Math.random() * wja.dp2px(3.0F, paramResources)));
    localalae.height = ((int)(f * localalae.width));
    localalae.cT = new float[2];
    localalae.cT[0] = paramFloat1;
    localalae.cT[1] = paramFloat2;
    localalae.rotation = ((float)Math.random() * wja.dp2px(90.0F, paramResources) - wja.dp2px(45.0F, paramResources));
    localalae.angle = (2.0D * Math.random() * 3.141592653589793D - 3.141592653589793D);
    if (localalae.angle >= 0.0D) {}
    for (localalae.speed = (wja.dp2px(10.0F, paramResources) + (float)Math.random() * wja.dp2px(200.0F, paramResources));; localalae.speed = (-wja.dp2px(10.0F, paramResources) - (float)Math.random() * wja.dp2px(200.0F, paramResources)))
    {
      localalae.qB = ((float)(localalae.speed * Math.cos(localalae.angle)));
      localalae.qC = ((float)(localalae.speed * Math.sin(localalae.angle)));
      localalae.bitmap = ((Bitmap)ml.get(Integer.valueOf(localalae.width)));
      if (localalae.bitmap == null)
      {
        localalae.bitmap = Bitmap.createScaledBitmap(paramBitmap, localalae.width, localalae.height, true);
        ml.put(Integer.valueOf(localalae.width), localalae.bitmap);
      }
      return localalae;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alae
 * JD-Core Version:    0.7.0.1
 */