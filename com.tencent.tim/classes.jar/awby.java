import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;

public class awby
{
  private static awby a;
  public static File bg = BaseApplicationImpl.getContext().getDir("qzonealbum", 0);
  public static String cOG = "libandroidndkgif.so";
  public static String cOH = "libdehaze.so";
  public static String cOI = "libopencv_java3.so";
  public static String cOJ = "libqzone_vision.so";
  public static String cOK = "libc++_shared.so";
  public boolean[] C = { 0, 0, 0 };
  private long aAL = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength", 38400L);
  private long aAM = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoLength64", 38672);
  private long aAN = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoLength", 587284);
  private long aAO = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateOpenSoLength", 9161452);
  private long aAP = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength", 657000);
  private long aAQ = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoLength64", 1058904);
  private long aAR = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength", 2422908);
  private long aAS = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoLength64", 3755056);
  private avrq c;
  private String cOL = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo", "https://d3g.qq.com/sngapp/app/update/20181219175050_4961/libandroidndkgif.so");
  private String cOM = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD5", "16dd3ecb57fac1a97a60a9cf3891accb");
  private String cON = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSo64", "https://d3g.qq.com/sngapp/app/update/20200214225316_4688/libandroidndkgif.so");
  private String cOO = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateGifSoMD564", "01468c39f609eef93fcd9224dbe686d3");
  private String cOP = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySo", "https://d3g.qq.com/sngapp/app/update/20180518104407_5319/libandroidndkbeauty.so");
  private String cOQ = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "f428bc70e52b7eb3fba4327e123a779b");
  private String cOR = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideQzoneVisionSoMD5", "b186c1e0ee3995717d84fb682afcd7b5");
  private String cOS = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD5", "f507c0f741a32f7a30fa162faa894ebc");
  private String cOT = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideLibCShareSoMD564", "a86a585f5560b0bff890a100fe32792b");
  private String cOU = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoGuideCreateBeautySoMD5", "C6787CBD4DBC4331E8C443A27EFEA03B");
  private final String cOV = bg.getPath() + "/photoqulatity";
  private int ezQ;
  private int ezR = 2;
  
  private boolean M(String paramString, long paramLong)
  {
    if (getSoLength(paramString) == 0L) {}
    while (getSoLength(paramString) == paramLong) {
      return true;
    }
    return false;
  }
  
  public static awby a()
  {
    try
    {
      if (a == null) {
        a = new awby();
      }
      awby localawby = a;
      return localawby;
    }
    finally {}
  }
  
  private static void k(File paramFile1, File paramFile2)
    throws IOException
  {
    awcf.copyFile(paramFile1, paramFile2);
  }
  
  public boolean T(String paramString, boolean paramBoolean)
  {
    File localFile = new File(rX(paramString));
    if (!localFile.exists())
    {
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file not exists. libName=" + paramString });
      return false;
    }
    if (localFile.length() == getSoLength(paramString)) {
      if (paramBoolean)
      {
        String str1 = arwv.encodeFileHexStr(rX(paramString));
        String str2 = rW(paramString);
        if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (str2.equalsIgnoreCase(str1)))
        {
          LocalMultiProcConfig.putBool(paramString, false);
          return true;
        }
        QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file md5 check failed. libName=" + paramString + " downloadMD5=" + str1 + " originalMD5=" + str2 });
      }
    }
    for (;;)
    {
      localFile.delete();
      return false;
      return true;
      QZLog.e("AlbumLibDownloaderUtil", 1, new Object[] { "vertifySoIsOK. file length check failed. libName=" + paramString + " file.length()=" + localFile.length() + " expect length=" + getSoLength(paramString) });
    }
  }
  
  public void a(Downloader.DownloadListener paramDownloadListener)
  {
    if (this.C[this.ezQ] == 0)
    {
      this.C[this.ezQ] = true;
      download(this.cOL, cOG, paramDownloadListener);
    }
    while (paramDownloadListener == null) {
      return;
    }
    paramDownloadListener.onDownloadCanceled("lib is downloading");
  }
  
  public void agA()
  {
    QzoneModuleManager.getInstance().downloadModule("pictureMarkerSo.zip", new awca(this));
  }
  
  public void b(Downloader.DownloadListener paramDownloadListener)
  {
    download(this.cOL, cOG, paramDownloadListener);
  }
  
  public void download(String paramString1, String paramString2, Downloader.DownloadListener paramDownloadListener)
  {
    if (this.c == null) {
      this.c = avrq.a();
    }
    boolean bool = LocalMultiProcConfig.getBool(paramString1, false);
    File localFile = new File(bg.getAbsolutePath() + "/" + paramString2);
    if ((bool) && (localFile.exists()) && (M(paramString2, localFile.length())))
    {
      if (paramDownloadListener != null) {
        paramDownloadListener.onDownloadSucceed(null, null);
      }
      if (cOG.equals(paramString2)) {
        this.C[this.ezQ] = false;
      }
      return;
    }
    paramDownloadListener = new awbz(this, paramString2, paramDownloadListener, paramString1);
    paramString2 = bg.getAbsolutePath() + "/tmp" + paramString2;
    this.c.download(paramString1, paramString2, paramDownloadListener);
  }
  
  public void eDe()
  {
    a(null);
  }
  
  public void eDf()
  {
    QzoneModuleManager.getInstance().downloadModule("libandroidndkbeauty.so", new awcb(this));
  }
  
  public long getSoLength(String paramString)
  {
    if (cOG.equals(paramString)) {
      return this.aAL;
    }
    if (cOJ.equals(paramString)) {
      return this.aAR;
    }
    if (cOK.equals(paramString)) {
      return this.aAP;
    }
    if (cOH.equals(paramString)) {
      return this.aAN;
    }
    if (cOI.equals(paramString)) {
      return this.aAO;
    }
    return 0L;
  }
  
  public String rW(String paramString)
  {
    if (cOJ.equals(paramString)) {
      return this.cOQ;
    }
    if (cOK.equals(paramString)) {
      return this.cOS;
    }
    if (cOG.equals(paramString)) {
      return this.cOM;
    }
    if (cOH.equals(paramString)) {
      return this.cOU;
    }
    return "";
  }
  
  public String rX(String paramString)
  {
    return bg.getAbsolutePath() + "/" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awby
 * JD-Core Version:    0.7.0.1
 */