import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atug
  extends atsn
{
  atug(atuf paramatuf) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong)
  {
    QLog.i("FMObserver<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo, bSuccess[" + paramBoolean + " retCode:" + paramInt1 + " downloadIp:" + paramString4 + " downloadDomain:" + paramString5 + " port:" + paramInt2 + " url:" + paramString6);
    atuf.a locala = atuf.a(this.b, paramLong, false);
    if (locala == null)
    {
      QLog.e("FMObserver<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo no this session");
      this.b.a(paramLong, false, null, 0, null, null, paramString2);
      return;
    }
    if (!paramBoolean)
    {
      this.b.app.a().b(false, 50, new Object[] { locala.h });
      this.b.jn(paramLong);
      this.b.a(paramLong, false, null, 0, null, null, paramString2);
      return;
    }
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.w("FMObserver<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo url=null");
      this.b.app.a().b(false, 50, new Object[] { locala.h });
      this.b.jn(paramLong);
      this.b.a(paramLong, false, null, 0, null, null, paramString2);
      return;
    }
    paramString6 = null;
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      paramString1 = paramString4;
    }
    while ((paramString1 == null) || (paramString1.length() < 0))
    {
      this.b.app.a().b(false, 50, new Object[] { locala.h });
      this.b.jn(paramLong);
      this.b.a(paramLong, false, null, 0, null, null, paramString2);
      return;
      paramString1 = paramString6;
      if (paramString5 != null)
      {
        paramString1 = paramString6;
        if (paramString5.length() > 0) {
          paramString1 = paramString5;
        }
      }
    }
    if ((paramString3 == null) || (paramString3.length() < 0)) {
      QLog.w("FMObserver<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo downloadKey invaild");
    }
    paramString3 = "/ftn_video_pic/rkey=" + paramString3 + "&filetype=" + locala.videoType + "&size=" + this.b.eg(locala.videoSize) + "&";
    this.b.a(paramLong, true, paramString1, paramInt2, paramString3, null, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atug
 * JD-Core Version:    0.7.0.1
 */