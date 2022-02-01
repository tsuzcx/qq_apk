import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public abstract class urq
{
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, urw paramurw)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate onTencentVideoDefnInfo:" + paramTVK_NetVideoInfo);
    }
  }
  
  public void a(urw paramurw)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onCompletion videoPlayer:" + paramurw);
    }
  }
  
  public void a(urw paramurw, long paramLong)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate videoBitRate:" + paramLong);
    }
  }
  
  public abstract void a(urw paramurw, Object paramObject);
  
  public void a(urw paramurw, String paramString)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "OnDownloadCallback state:" + paramString + ", videoPlayer:" + paramurw);
    }
  }
  
  public void a(urw paramurw, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onCaptureImage result:" + paramBoolean + ", errCode:" + paramInt1 + ", id:" + paramInt2 + ", bitmap:" + paramBitmap + ", videoPlayer:" + paramurw);
    }
  }
  
  public boolean a(urw paramurw, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onError model:" + paramInt1 + ", what:" + paramInt2 + ", extra:" + paramInt3 + ", detailInfo:" + paramString + ", info:" + paramObject);
    }
    return false;
  }
  
  public boolean a(urw paramurw, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onInfo what:" + paramInt + ", extra:" + paramObject + ", videoPlayer:" + paramurw);
    }
    return false;
  }
  
  public void b(urw paramurw)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onSeekComplete videoPlayer:" + paramurw);
    }
  }
  
  public void b(urw paramurw, String paramString)
  {
    if (QLog.isColorLevel()) {
      uya.d("WSPlayerListenerAdapter", 2, "onConnectQualityCallback json:" + paramString);
    }
  }
  
  public void c(urw paramurw)
  {
    if (QLog.isColorLevel()) {
      uya.b("WSPlayerListenerAdapter", 2, "onDownloadFinish videoPlayer:" + paramurw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urq
 * JD-Core Version:    0.7.0.1
 */