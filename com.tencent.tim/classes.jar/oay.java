import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class oay
  extends obs
{
  final int playTime = 3;
  
  public oay(BaseApplicationImpl paramBaseApplicationImpl)
  {
    super(paramBaseApplicationImpl);
  }
  
  public static URL d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL("pubaccountimage_gifplaytime", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        QLog.e("PubAccountHttpDownloader", 2, "getPubURL urlString", paramString);
        paramString = null;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if (GifDrawable.isGifFile(paramFile)) {
      if (!(paramDownloadParams.mExtraInfo instanceof JSONObject)) {
        break label52;
      }
    }
    label52:
    for (int i = ((JSONObject)paramDownloadParams.mExtraInfo).optInt("gifPlayCount", 3);; i = 3)
    {
      return new oay.a(paramFile, true, i);
      return super.decodeFile(paramFile, paramDownloadParams, paramURLDrawableHandler);
    }
  }
  
  public static class a
    extends NativeGifImage
  {
    private oay.b a;
    private int bdP = 3;
    
    public a(File paramFile, boolean paramBoolean, int paramInt)
      throws IOException
    {
      super(paramBoolean, false, 0, 0, 0.0F);
      this.bdP = paramInt;
    }
    
    public void a(oay.b paramb)
    {
      this.a = paramb;
    }
    
    public void destroy()
    {
      this.a = null;
    }
    
    public void executeNewTask()
    {
      if (this.mCurrentLoop == this.bdP)
      {
        if (this.a != null) {
          this.a.onPlayFinish();
        }
        return;
      }
      super.executeNewTask();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onPlayFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oay
 * JD-Core Version:    0.7.0.1
 */