import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.PngsTextDrawer.1;
import dov.com.qq.im.ae.gif.video.PngsTextDrawer.2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class axfu
{
  private static String TAG = axfn.class.getSimpleName();
  private axdm jdField_a_of_type_Axdm;
  private axfu.a jdField_a_of_type_Axfu$a;
  private String cUh;
  private String cacheDir = awtn.c.a.cSV;
  private int eEN;
  private int eEO;
  private int gifHeight = 320;
  private int gifWidth = 320;
  private Handler handler;
  
  public axfu(String paramString)
  {
    this.cUh = paramString;
    paramString = new HandlerThread("PngsTextDrawerHT" + System.currentTimeMillis());
    paramString.start();
    this.handler = new Handler(paramString.getLooper());
  }
  
  private List<String> br(String paramString)
  {
    String[] arrayOfString = new File(paramString).list();
    Arrays.sort(arrayOfString);
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      localArrayList.add(paramString + File.separator + str);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(axfu.a parama)
  {
    this.jdField_a_of_type_Axfu$a = parama;
    QLog.d(TAG, 4, "start add text to png");
    this.handler.post(new PngsTextDrawer.2(this, parama));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.handler.post(new PngsTextDrawer.1(this, paramFloat3, paramFloat4, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramFloat1, paramFloat2));
  }
  
  public static abstract interface a
  {
    public abstract void acv(String paramString);
    
    public abstract void cZr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfu
 * JD-Core Version:    0.7.0.1
 */