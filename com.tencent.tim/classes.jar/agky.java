import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloaderImpl.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerDownloader.Listener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import mqq.os.MqqHandler;

public class agky
  implements agkw.a, aglf, ISPlayerDownloader.Listener
{
  private agld jdField_a_of_type_Agld;
  private agle jdField_a_of_type_Agle;
  private ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  private agsw b;
  private String bHU;
  private boolean cdU;
  private boolean cdV;
  private String mFileId;
  private int mTaskId = -1;
  private SuperPlayerVideoInfo mVideoInfo;
  
  public agky(agsw paramagsw)
  {
    this.mFileId = paramagsw.ve();
    this.b = paramagsw;
  }
  
  private void fI(String paramString1, String paramString2)
  {
    String str = Md5Utils.getMD5(this.mFileId);
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "----build Videoinfo---- fileid:" + str);
    this.bHU = this.b.vL();
    this.mVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(paramString1, 104, str, this.bHU);
    if (paramString2 != null)
    {
      paramString1 = new ArrayList();
      paramString1.add(paramString2);
      this.mVideoInfo.setCookies(paramString1);
    }
    this.mVideoInfo.setFormat(104);
  }
  
  public boolean ZE()
  {
    if (this.mVideoInfo != null)
    {
      if (this.jdField_a_of_type_Agld != null) {
        this.jdField_a_of_type_Agld.a(this.mVideoInfo);
      }
      if (this.mTaskId > 0) {
        return true;
      }
    }
    this.mTaskId = 0;
    long l = this.b.getFileSize();
    String str = this.b.vL();
    if (l != ahav.getFileSizes(str)) {
      aqhq.deleteFile(str);
    }
    this.b.a(this);
    return true;
  }
  
  public void a(agld paramagld)
  {
    this.jdField_a_of_type_Agld = paramagld;
  }
  
  public void a(agle paramagle)
  {
    this.jdField_a_of_type_Agle = paramagle;
  }
  
  public void dhA()
  {
    vf();
  }
  
  public void dhB()
  {
    stop();
    onDownloadFinish(0);
  }
  
  public void fH(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader != null) && (this.mTaskId > 0)) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "downloader exsited:" + this.mTaskId);
    }
    do
    {
      return;
      fI(paramString1, paramString2);
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 109);
      this.mTaskId = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload(this.mVideoInfo, this);
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "start download task:" + this.mTaskId);
    } while (this.jdField_a_of_type_Agld == null);
    this.jdField_a_of_type_Agld.a(this.mVideoInfo);
  }
  
  public boolean isDownloading()
  {
    return this.mTaskId != -1;
  }
  
  public void onDownloadCdnUrlExpired(int paramInt, Map<String, String> paramMap) {}
  
  public void onDownloadCdnUrlInfoUpdate(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void onDownloadCdnUrlUpdate(int paramInt, String paramString) {}
  
  public void onDownloadError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadError(" + paramInt2 + "," + paramInt3 + "," + paramString + ")");
    this.b.JB(false);
    if (this.jdField_a_of_type_Agle == null) {
      return;
    }
    this.jdField_a_of_type_Agle.onDownloadError(paramInt2, paramInt3, paramString);
  }
  
  public void onDownloadFinish(int paramInt)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "---------->   onDownloadFinish:" + this.mFileId);
    this.cdV = true;
    String str = vf();
    if (this.jdField_a_of_type_Agle == null) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileVideoDownloaderImpl.1(this, str));
  }
  
  public void onDownloadProgressUpdate(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString)
  {
    if (this.cdV) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, String.format("%s is downloaded!", new Object[] { this.b.ve() }));
      }
    }
    do
    {
      return;
      this.b.jL(paramLong1);
    } while (this.jdField_a_of_type_Agle == null);
    if (QLog.isDebugVersion()) {
      QLog.d("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProgressUpdate(playableDurationMS:" + paramInt2 + ", downloadSpeedKBs:" + paramInt3 + ", currentDownloadSizeByte: " + paramLong1 + ", totalFileSizeByte: " + paramLong2 + ",)");
    }
    this.jdField_a_of_type_Agle.e(paramInt2, paramInt3, paramLong1, paramLong2);
  }
  
  public void onDownloadProtocolUpdate(int paramInt, String paramString1, String paramString2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadProtocolUpdate(" + paramString1 + "," + paramString2 + ",)");
  }
  
  public void onDownloadStatusUpdate(int paramInt1, int paramInt2)
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "onDownloadStatusUpdate(" + paramInt2 + ",)");
  }
  
  public void onError(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Agld != null) {
      this.jdField_a_of_type_Agld.bp(paramInt, paramString);
    }
  }
  
  public void setPlaying(boolean paramBoolean)
  {
    this.cdU = paramBoolean;
    if (!this.cdU)
    {
      vf();
      this.jdField_a_of_type_Agld = null;
    }
  }
  
  public void stop()
  {
    if (this.mTaskId > 0)
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXOSILAS_ID", 1, "stop download:" + this.mTaskId);
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(this.mTaskId);
    }
    this.mVideoInfo = null;
    this.mTaskId = -1;
  }
  
  public String ve()
  {
    return this.b.ve();
  }
  
  public String vf()
  {
    QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "isPlaying[" + this.cdU + "], downloadSucc[" + this.cdV + "]");
    if ((this.cdU) || (!this.cdV)) {
      return null;
    }
    String str = ahav.kW(ahaf.a().vZ() + this.b.getFileName());
    if (!ahbj.fileExistsAndNotEmpty(this.bHU))
    {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 1, "[" + this.b.ve() + "],File rename faild mybe renamed");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.b.ve() + "],File download over rename[" + str + "],src[" + this.bHU + "]");
    }
    if (!aqhq.renameFile(new File(this.bHU), new File(str)))
    {
      this.b.JB(false);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileVideoDownloaderImpl<FileAssistant>XOXO", 4, "[" + this.b.ve() + "],File download over. rename success!");
    }
    this.b.Jk(str);
    agkw.IO(this.b.ve());
    agkw.dhz();
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agky
 * JD-Core Version:    0.7.0.1
 */