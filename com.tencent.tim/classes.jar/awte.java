import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;

public class awte
{
  private static QQFilterRenderManager d;
  private static QQFilterRenderManager e;
  public static int eCQ = 0;
  public static int eCR = 1;
  public static int eCS = 2;
  private static int eCT;
  
  static
  {
    awtj.init();
    alwy.bi(true);
  }
  
  public static int QE()
  {
    return eCT;
  }
  
  public static QQFilterRenderManager a(int paramInt)
  {
    if (paramInt == eCS) {
      return d;
    }
    return EffectsCameraCaptureView.b();
  }
  
  public static void a(QQFilterRenderManager paramQQFilterRenderManager)
  {
    d = paramQQFilterRenderManager;
  }
  
  public static QQFilterRenderManager c()
  {
    return new QQFilterRenderManager(new int[] { 70, 80, 90, 184 });
  }
  
  public static QQFilterRenderManager d()
  {
    try
    {
      if ((e != null) && (e.isSurfaceDestroyed())) {
        e = null;
      }
      if (e == null) {
        e = c();
      }
      QQFilterRenderManager localQQFilterRenderManager = e;
      return localQQFilterRenderManager;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awte
 * JD-Core Version:    0.7.0.1
 */