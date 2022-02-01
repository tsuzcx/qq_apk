import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.GIFCreator.1;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class axfn
{
  private static String TAG = axfn.class.getSimpleName();
  private List<String> Mz;
  private axfn.a jdField_a_of_type_Axfn$a;
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private String cUc;
  private String cUd;
  private String cacheDir = awtn.c.a.cSV;
  private String gifPath;
  private Handler handler;
  
  public axfn(String paramString)
  {
    this.cUd = paramString;
    this.Mz = br(paramString);
    this.gifPath = (this.cacheDir + System.currentTimeMillis() + ".gif");
    this.cUc = (this.cacheDir + System.currentTimeMillis() + "_compressed.gif");
    try
    {
      paramString = new File(this.cacheDir);
      if (!paramString.isDirectory())
      {
        QLog.d(TAG, 4, this.cacheDir + " is not a directory");
        boolean bool = paramString.mkdirs();
        QLog.d(TAG, 4, "mkdirs return " + bool);
      }
      paramString = new HandlerThread("GIFCreatorHT" + System.currentTimeMillis());
      paramString.start();
      this.handler = new Handler(paramString.getLooper());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.d(TAG, 4, "check dir exception, msg = " + paramString.getMessage());
      }
    }
  }
  
  private List<String> br(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new File(paramString);
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list(new axfo(this));
      if (localObject != null)
      {
        Arrays.sort((Object[])localObject);
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          localArrayList.add(paramString + File.separator + str);
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public void a(axfn.a parama)
  {
    this.jdField_a_of_type_Axfn$a = parama;
    QLog.d(TAG, 4, new Object[] { "start create gif, gif path = ", this.gifPath });
    this.handler.post(new GIFCreator.1(this, parama));
  }
  
  public void eJm()
  {
    aqhq.cn(this.cUd);
  }
  
  public static abstract interface a
  {
    public abstract void HS(String paramString);
    
    public abstract void cZr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfn
 * JD-Core Version:    0.7.0.1
 */