import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class amct
  extends BrowserBaseModel
{
  public Drawable a(AIOVideoData paramAIOVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOVideoData, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    if ((localFile != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOVideoData, 0)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOVideoData, 0), localURLDrawableOptions);
    }
    while (localFile == null) {
      return localURLDrawable;
    }
    paramAIOVideoData = URLDrawable.getDrawable(a(paramAIOVideoData, 0), localURLDrawableOptions);
    paramAIOVideoData.downloadImediatly();
    return paramAIOVideoData;
  }
  
  public File a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramAIOVideoData = null;
    }
    while ((paramAIOVideoData != null) && (!paramAIOVideoData.equals("I:N")))
    {
      paramAIOVideoData = new File(paramAIOVideoData);
      if (!paramAIOVideoData.exists()) {
        break;
      }
      return paramAIOVideoData;
      paramAIOVideoData = paramAIOVideoData.aWo;
      continue;
      paramAIOVideoData = paramAIOVideoData.aWp;
    }
  }
  
  public String a(AIOVideoData paramAIOVideoData, int paramInt)
  {
    if (paramAIOVideoData == null) {
      return null;
    }
    switch (paramInt)
    {
    default: 
      paramAIOVideoData = null;
    }
    while ((paramAIOVideoData != null) && (!paramAIOVideoData.equals("I:N")))
    {
      if (paramAIOVideoData.startsWith("/")) {
        break label88;
      }
      return "file:/" + paramAIOVideoData;
      paramAIOVideoData = paramAIOVideoData.aWo;
      continue;
      paramAIOVideoData = paramAIOVideoData.aWp;
    }
    label88:
    if (paramAIOVideoData.startsWith("//")) {
      return "file:" + paramAIOVideoData;
    }
    return "file:" + paramAIOVideoData;
  }
  
  public void a(AIOVideoData paramAIOVideoData, int paramInt, String paramString)
  {
    if ("I:E".equals(paramString))
    {
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        paramAIOVideoData.bio = true;
        return;
      }
      paramAIOVideoData.bjB = true;
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      paramAIOVideoData.aWo = paramString;
      return;
    }
    paramAIOVideoData.aWp = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amct
 * JD-Core Version:    0.7.0.1
 */