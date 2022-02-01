import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import java.util.Map;

class angf
  implements ISPlayerDownloader.Listener
{
  angf(angd paramangd, angi paramangi) {}
  
  public void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(int paramInt, String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadError, preLoadId = " + this.c.dFt + " , uniseq = " + this.c.o.uniseq + ", moduleID = " + paramInt2 + ", errorCode = " + paramInt3 + ", extInfo = " + paramString);
    }
    if ((this.c != null) && (this.c.a != null)) {
      this.c.a.onComplete(paramInt3);
    }
  }
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadFinish, preLoadId = " + this.c.dFt + " , uniseq = " + this.c.o.uniseq);
    }
    if ((this.c != null) && (this.c.a != null)) {
      this.c.a.onComplete(0);
    }
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.c.dFt + " , uniseq = " + this.c.o.uniseq + "currentDownloadSizeByte = " + paramLong1 + ", totalFileSizeByte = " + paramLong2);
    }
    if ((this.c.a != null) && (this.c.o != null))
    {
      if (paramLong1 <= this.c.akX) {
        break label238;
      }
      this.c.akX = paramLong1;
    }
    for (;;)
    {
      paramLong2 = this.c.o.videoFileSize;
      if ((paramLong2 > 0L) && (paramLong1 <= paramLong2))
      {
        paramInt1 = (int)(paramLong1 * 1.0D / paramLong2 * 100.0D);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "onDownloadProgressUpdate, preLoadId = " + this.c.dFt + ", pogress = " + paramInt1 + " , uniseq = " + this.c.o.uniseq);
        }
        this.c.a.onProgress(paramInt1);
      }
      return;
      label238:
      paramLong1 = this.c.akX;
    }
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2) {}
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     angf
 * JD-Core Version:    0.7.0.1
 */