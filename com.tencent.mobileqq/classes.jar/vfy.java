import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public abstract class vfy
{
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, vgh paramvgh)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate onTencentVideoDefnInfo:" + paramTVK_NetVideoInfo);
    }
  }
  
  public void a(vgh paramvgh)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onCompletion videoPlayer:" + paramvgh);
    }
  }
  
  public void a(vgh paramvgh, long paramLong)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate videoBitRate:" + paramLong);
    }
  }
  
  public abstract void a(vgh paramvgh, Object paramObject);
  
  public void a(vgh paramvgh, String paramString)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "OnDownloadCallback state:" + paramString + ", videoPlayer:" + paramvgh);
    }
  }
  
  public void a(vgh paramvgh, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onCaptureImage result:" + paramBoolean + ", errCode:" + paramInt1 + ", id:" + paramInt2 + ", bitmap:" + paramBitmap + ", videoPlayer:" + paramvgh);
    }
  }
  
  public boolean a(vgh paramvgh, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onError model:" + paramInt1 + ", what:" + paramInt2 + ", extra:" + paramInt3 + ", detailInfo:" + paramString + ", info:" + paramObject);
    }
    return false;
  }
  
  public boolean a(vgh paramvgh, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onInfo what:" + paramInt + ", extra:" + paramObject + ", videoPlayer:" + paramvgh);
    }
    return false;
  }
  
  public void b(vgh paramvgh)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onSeekComplete videoPlayer:" + paramvgh);
    }
  }
  
  public void b(vgh paramvgh, String paramString)
  {
    if (QLog.isColorLevel()) {
      vmp.d("WSPlayerListenerAdapter", 2, "onConnectQualityCallback json:" + paramString);
    }
  }
  
  public void c(vgh paramvgh)
  {
    if (QLog.isColorLevel()) {
      vmp.b("WSPlayerListenerAdapter", 2, "onDownloadFinish videoPlayer:" + paramvgh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfy
 * JD-Core Version:    0.7.0.1
 */