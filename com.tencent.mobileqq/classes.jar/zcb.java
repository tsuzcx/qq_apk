import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.ProtocolDownloader;
import com.tencent.image.URLDrawableParams;
import java.io.File;

public class zcb
  extends URLDrawableParams
{
  Context a;
  
  public zcb(Context paramContext, File paramFile)
  {
    super(paramContext);
    this.a = paramContext;
    aywm.a = paramFile;
    com.tencent.mobileqq.startup.step.InitUrlDrawable.a = new ayqe(paramFile);
  }
  
  public ProtocolDownloader doGetDownloader(String paramString, Object paramObject)
  {
    boolean bool = true;
    if (("http".equals(paramString)) || ("https".equals(paramString)))
    {
      if (BaseApplicationImpl.sProcessId == 1) {}
      for (;;)
      {
        return new ayrp(bool, paramObject);
        bool = false;
      }
    }
    return null;
  }
  
  public String doGetLocalFilePath(String paramString)
  {
    return null;
  }
  
  public ApngSoLoader getApngSoLoader()
  {
    return bbqx.a();
  }
  
  public Drawable getDefaultLoadingDrawable()
  {
    return this.a.getResources().getDrawable(2130846926);
  }
  
  public Drawable getDefualtFailedDrawable()
  {
    return this.a.getResources().getDrawable(2130846926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zcb
 * JD-Core Version:    0.7.0.1
 */