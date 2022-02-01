import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import cooperation.qqcircle.QCircleConfig;
import java.util.Hashtable;

public class zpz
{
  private static final Hashtable<String, Typeface> a = new Hashtable();
  
  public static Typeface a(Context paramContext, String paramString)
  {
    int i;
    for (;;)
    {
      synchronized (a)
      {
        boolean bool = a.containsKey(paramString);
        if (!bool)
        {
          i = 0;
          if (i >= 3) {}
        }
      }
      try
      {
        Typeface localTypeface = Typeface.createFromAsset(paramContext.getAssets(), String.format("fonts/%s.ttf", new Object[] { paramString }));
        a.put(paramString, localTypeface);
        return localTypeface;
      }
      catch (Throwable localThrowable)
      {
        i += 1;
      }
      paramContext = (Typeface)a.get(paramString);
      return paramContext;
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    synchronized (a)
    {
      if (!a.containsKey(paramString))
      {
        RFWDownloaderFactory.getDownloader(QCircleConfig.getDownloadStrategy()).getZipFile(paramString, new zqa(paramString, paramTextView));
        return;
      }
      paramTextView.setTypeface((Typeface)a.get(paramString));
    }
  }
  
  public static void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramTextView, "https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
      return;
    }
    a(paramTextView, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpz
 * JD-Core Version:    0.7.0.1
 */