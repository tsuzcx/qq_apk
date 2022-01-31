import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.DiscVideoThumbDownloader;
import com.tencent.mobileqq.filemanager.core.DiscVideoThumbDownloader.VideoSession;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.qphone.base.util.QLog;

public class dng
  extends FMObserver
{
  public dng(DiscVideoThumbDownloader paramDiscVideoThumbDownloader) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, String paramString5, long paramLong)
  {
    QLog.i("DiscVideoThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] OnGetDiscVideoThumbInfo, bSuccess[" + paramBoolean + " retCode:" + paramInt1 + " downloadIp:" + paramString3 + " downloadDomain:" + paramString4 + " port:" + paramInt2 + " url:" + paramString5);
    DiscVideoThumbDownloader.VideoSession localVideoSession = DiscVideoThumbDownloader.a(this.a, paramLong, false);
    if (localVideoSession == null)
    {
      QLog.e("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetDiscVideoThumbInfo no this session");
      this.a.a(paramLong, false, null, 0, null, null);
      return;
    }
    if (!paramBoolean)
    {
      this.a.a.a().a(false, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null);
      return;
    }
    if ((paramString5 != null) && (paramString5.length() > 0))
    {
      QLog.w("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetDiscVideoThumbInfo url=null");
      this.a.a.a().a(false, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null);
      return;
    }
    paramString5 = null;
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      paramString1 = paramString3;
    }
    while ((paramString1 == null) || (paramString1.length() < 0))
    {
      this.a.a.a().a(false, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null);
      return;
      paramString1 = paramString5;
      if (paramString4 != null)
      {
        paramString1 = paramString5;
        if (paramString4.length() > 0) {
          paramString1 = paramString4;
        }
      }
    }
    if ((paramString2 == null) || (paramString2.length() < 0)) {
      QLog.w("DiscVideoThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo downloadKey invaild");
    }
    paramString2 = "/ftn_video_pic/rkey=" + paramString2 + "&filetype=" + localVideoSession.b + "&size=" + this.a.a(localVideoSession.jdField_a_of_type_Int) + "&";
    this.a.a(paramLong, true, paramString1, paramInt2, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dng
 * JD-Core Version:    0.7.0.1
 */