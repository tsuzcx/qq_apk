import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import java.io.File;

public class amcp
  extends BrowserBaseModel
{
  private void a(AIOFileVideoData paramAIOFileVideoData, Context paramContext, amdw paramamdw)
  {
    paramAIOFileVideoData = new amcq(this, paramContext, paramAIOFileVideoData, paramamdw);
    ahal.a(paramContext, paramContext.getString(2131693826), paramContext.getString(2131693828), paramAIOFileVideoData);
  }
  
  private boolean b(AIOFileVideoData paramAIOFileVideoData)
  {
    if (a(paramAIOFileVideoData)) {}
    do
    {
      do
      {
        return false;
      } while ((paramAIOFileVideoData == null) || (paramAIOFileVideoData.biv) || (!ahav.amK()));
      if ((!TextUtils.isEmpty(paramAIOFileVideoData.fileName)) && (paramAIOFileVideoData.size > 0L) && (paramAIOFileVideoData.size > paramAIOFileVideoData.Js)) {
        return true;
      }
    } while (paramAIOFileVideoData.size <= 1048576L);
    return true;
  }
  
  public Drawable a(AIOFileVideoData paramAIOFileVideoData)
  {
    URLDrawable localURLDrawable = null;
    File localFile = a(paramAIOFileVideoData);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
    localURLDrawableOptions.mFailedDrawable = aoop.TRANSPARENT;
    if ((localFile != null) && (BaseApplicationImpl.sImageCache.get(a(paramAIOFileVideoData)) != null)) {
      localURLDrawable = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    }
    while (localFile == null) {
      return localURLDrawable;
    }
    paramAIOFileVideoData = URLDrawable.getDrawable(a(paramAIOFileVideoData), localURLDrawableOptions);
    paramAIOFileVideoData.downloadImediatly();
    return paramAIOFileVideoData;
  }
  
  public File a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (!ahbj.fileExistsAndNotEmpty(paramAIOFileVideoData.bN))) {
      return null;
    }
    return new File(paramAIOFileVideoData.bN);
  }
  
  public String a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData == null) || (TextUtils.isEmpty(paramAIOFileVideoData.bN))) {
      return "";
    }
    if (!paramAIOFileVideoData.bN.startsWith("/")) {
      return "file:/" + paramAIOFileVideoData.bN;
    }
    if (paramAIOFileVideoData.bN.startsWith("//")) {
      return "file:" + paramAIOFileVideoData.bN;
    }
    return "file:" + paramAIOFileVideoData.bN;
  }
  
  public ztn a(AIOFileVideoData paramAIOFileVideoData, boolean paramBoolean)
  {
    boolean bool = false;
    ztn localztn = new ztn();
    localztn.cJ = new String[] { paramAIOFileVideoData.downloadUrl };
    localztn.mCookies = paramAIOFileVideoData.zi;
    if (!a(paramAIOFileVideoData)) {
      bool = true;
    }
    localztn.btf = bool;
    if (localztn.btf) {}
    for (String str = "";; str = paramAIOFileVideoData.mFilePath)
    {
      localztn.playUrl = str;
      localztn.progress = paramAIOFileVideoData.progress;
      localztn.btg = true;
      localztn.fileSize = paramAIOFileVideoData.size;
      localztn.id = paramAIOFileVideoData.msgId;
      localztn.subid = paramAIOFileVideoData.subId;
      localztn.isMute = paramBoolean;
      localztn.mBundle = paramAIOFileVideoData.bundle;
      return localztn;
    }
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData)
  {
    if ((paramAIOFileVideoData != null) && (aqhq.fileExistsAndNotEmpty(paramAIOFileVideoData.mFilePath)))
    {
      paramAIOFileVideoData.bis = true;
      return true;
    }
    if ((paramAIOFileVideoData != null) && (paramAIOFileVideoData.downloadUrl == null)) {
      paramAIOFileVideoData.bis = false;
    }
    return false;
  }
  
  public boolean a(AIOFileVideoData paramAIOFileVideoData, amcl paramamcl)
  {
    if ((paramAIOFileVideoData == null) || (a(paramAIOFileVideoData)) || (paramamcl == null)) {}
    while ((!TextUtils.isEmpty(paramAIOFileVideoData.downloadUrl)) && (paramAIOFileVideoData.zi != null)) {
      return false;
    }
    paramamcl.downloadMedia(paramAIOFileVideoData.msgId, paramAIOFileVideoData.subId, 16842753);
    return true;
  }
  
  public void b(AIOFileVideoData paramAIOFileVideoData, Context paramContext, amdw paramamdw)
  {
    if (b(paramAIOFileVideoData))
    {
      if (ahbr.a(paramContext, false, new amcr(this, paramamdw))) {
        a(paramAIOFileVideoData, paramContext, paramamdw);
      }
      return;
    }
    paramamdw.dMT();
  }
  
  public boolean c(AIOFileVideoData paramAIOFileVideoData)
  {
    return !TextUtils.isEmpty(paramAIOFileVideoData.strErr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcp
 * JD-Core Version:    0.7.0.1
 */