import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public abstract class thh
{
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, tho paramtho)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate onTencentVideoDefnInfo:" + paramTVK_NetVideoInfo);
    }
  }
  
  public void a(tho paramtho)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onCompletion videoPlayer:" + paramtho);
    }
  }
  
  public void a(tho paramtho, long paramLong)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate videoBitRate:" + paramLong);
    }
  }
  
  public abstract void a(tho paramtho, Object paramObject);
  
  public void a(tho paramtho, String paramString)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "OnDownloadCallback state:" + paramString + ", videoPlayer:" + paramtho);
    }
  }
  
  public void a(tho paramtho, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onCaptureImage result:" + paramBoolean + ", errCode:" + paramInt1 + ", id:" + paramInt2 + ", bitmap:" + paramBitmap + ", videoPlayer:" + paramtho);
    }
  }
  
  public boolean a(tho paramtho, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onError model:" + paramInt1 + ", what:" + paramInt2 + ", extra:" + paramInt3 + ", detailInfo:" + paramString + ", info:" + paramObject);
    }
    return false;
  }
  
  public boolean a(tho paramtho, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onInfo what:" + paramInt + ", extra:" + paramObject + ", videoPlayer:" + paramtho);
    }
    return false;
  }
  
  public void b(tho paramtho)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onSeekComplete videoPlayer:" + paramtho);
    }
  }
  
  public void b(tho paramtho, String paramString)
  {
    if (QLog.isColorLevel()) {
      tlo.d("WSPlayerListenerAdapter", 2, "onConnectQualityCallback json:" + paramString);
    }
  }
  
  public void c(tho paramtho)
  {
    if (QLog.isColorLevel()) {
      tlo.b("WSPlayerListenerAdapter", 2, "onDownloadFinish videoPlayer:" + paramtho);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thh
 * JD-Core Version:    0.7.0.1
 */