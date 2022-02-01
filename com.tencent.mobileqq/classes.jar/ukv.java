import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

public abstract class ukv
{
  public void a(TVK_NetVideoInfo paramTVK_NetVideoInfo, ulc paramulc)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate onTencentVideoDefnInfo:" + paramTVK_NetVideoInfo);
    }
  }
  
  public void a(ulc paramulc)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onCompletion videoPlayer:" + paramulc);
    }
  }
  
  public void a(ulc paramulc, long paramLong)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onAccessVideoBitRate videoBitRate:" + paramLong);
    }
  }
  
  public abstract void a(ulc paramulc, Object paramObject);
  
  public void a(ulc paramulc, String paramString)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "OnDownloadCallback state:" + paramString + ", videoPlayer:" + paramulc);
    }
  }
  
  public void a(ulc paramulc, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onCaptureImage result:" + paramBoolean + ", errCode:" + paramInt1 + ", id:" + paramInt2 + ", bitmap:" + paramBitmap + ", videoPlayer:" + paramulc);
    }
  }
  
  public boolean a(ulc paramulc, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onError model:" + paramInt1 + ", what:" + paramInt2 + ", extra:" + paramInt3 + ", detailInfo:" + paramString + ", info:" + paramObject);
    }
    return false;
  }
  
  public boolean a(ulc paramulc, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onInfo what:" + paramInt + ", extra:" + paramObject + ", videoPlayer:" + paramulc);
    }
    return false;
  }
  
  public void b(ulc paramulc)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onSeekComplete videoPlayer:" + paramulc);
    }
  }
  
  public void b(ulc paramulc, String paramString)
  {
    if (QLog.isColorLevel()) {
      uqf.d("WSPlayerListenerAdapter", 2, "onConnectQualityCallback json:" + paramString);
    }
  }
  
  public void c(ulc paramulc)
  {
    if (QLog.isColorLevel()) {
      uqf.b("WSPlayerListenerAdapter", 2, "onDownloadFinish videoPlayer:" + paramulc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukv
 * JD-Core Version:    0.7.0.1
 */