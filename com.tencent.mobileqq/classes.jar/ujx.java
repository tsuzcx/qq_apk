import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public abstract class ujx
{
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, uke paramuke)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate onTencentVideoDefnInfo:" + paramTVK_NetVideoInfo);
    }
  }
  
  public void a(uke paramuke)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onCompletion videoPlayer:" + paramuke);
    }
  }
  
  public void a(uke paramuke, long paramLong)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate videoBitRate:" + paramLong);
    }
  }
  
  public abstract void a(uke paramuke, Object paramObject);
  
  public void a(uke paramuke, String paramString)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "OnDownloadCallback state:" + paramString + ", videoPlayer:" + paramuke);
    }
  }
  
  public void a(uke paramuke, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onCaptureImage result:" + paramBoolean + ", errCode:" + paramInt1 + ", id:" + paramInt2 + ", bitmap:" + paramBitmap + ", videoPlayer:" + paramuke);
    }
  }
  
  public boolean a(uke paramuke, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onError model:" + paramInt1 + ", what:" + paramInt2 + ", extra:" + paramInt3 + ", detailInfo:" + paramString + ", info:" + paramObject);
    }
    return false;
  }
  
  public boolean a(uke paramuke, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onInfo what:" + paramInt + ", extra:" + paramObject + ", videoPlayer:" + paramuke);
    }
    return false;
  }
  
  public void b(uke paramuke)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onSeekComplete videoPlayer:" + paramuke);
    }
  }
  
  public void b(uke paramuke, String paramString)
  {
    if (QLog.isColorLevel()) {
      upe.d("WSPlayerListenerAdapter", 2, "onConnectQualityCallback json:" + paramString);
    }
  }
  
  public void c(uke paramuke)
  {
    if (QLog.isColorLevel()) {
      upe.b("WSPlayerListenerAdapter", 2, "onDownloadFinish videoPlayer:" + paramuke);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujx
 * JD-Core Version:    0.7.0.1
 */