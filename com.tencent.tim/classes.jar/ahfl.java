import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ahfl
  extends afeu
{
  private boolean cgD;
  
  public ahfl(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.flutter.app.v8.3.6", paramQQAppInterface);
  }
  
  public static String wi()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFlutter.QFlutterAppDownloader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/" + "qq.android.flutter.app.v8.3.6";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("QFlutter.QFlutterAppDownloader", 2, "getLibDir ,path = " + str);
    return str;
  }
  
  public void HL(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("restartDownload userClick: %s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    super.HL(paramBoolean);
    if (!this.cgD) {
      this.cgD = paramBoolean;
    }
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, "download success: " + paramString);
    }
    if (ahfn.a(paramString, (QFlutterAppData)b())) {
      ahfn.bA(1, true);
    }
    for (;;)
    {
      super.HO(paramString);
      return;
      restoreState();
      ahfn.bA(1, false);
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if (paramXmlData != null) {}
    for (long l = paramXmlData.totalSize;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.QFlutterAppDownloader", 2, new Object[] { "download begin, totalLen: %s", Long.valueOf(l) });
      }
      return;
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("onDownloadFinish, result: %s, errCode: %s, filepath: %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramString }));
    }
    if (!paramBoolean) {
      ahfn.bA(1, false);
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aiW()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("isNetValid2Download mHadRequestedByUser: %s", new Object[] { Boolean.valueOf(this.cgD) }));
    }
    if (this.cgD) {
      return true;
    }
    return super.aiW();
  }
  
  public boolean aiY()
  {
    QLog.d("QFlutter.QFlutterAppDownloader", 1, String.format("downloadResource, mHadRequestedByUser = %s", new Object[] { Boolean.valueOf(this.cgD) }));
    if (!this.cgD) {
      return false;
    }
    return super.aiY();
  }
  
  public void aq(long paramLong1, long paramLong2)
  {
    super.aq(paramLong1, paramLong2);
    int i = (int)(100L * paramLong1 / paramLong2);
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, "download progress: " + i);
    }
    ahfn.i(1, paramLong1, paramLong2);
  }
  
  public void cYL()
  {
    String str = wi();
    boolean bool = ahbj.deleteFile(new File(str));
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, String.format("delete unzipFile: %s, ret: %s", new Object[] { str, Boolean.valueOf(bool) }));
    }
  }
  
  public Class<? extends XmlData> g()
  {
    return QFlutterAppData.class;
  }
  
  public int getBusinessId()
  {
    return 10093;
  }
  
  public void restoreState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.QFlutterAppDownloader", 2, "restoreState");
    }
    b().loadState = 0;
    b().Version = 0;
    afel.a(b(), new String[0]);
  }
  
  public String un()
  {
    return QFlutterAppData.class.getSimpleName();
  }
  
  public String uo()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfl
 * JD-Core Version:    0.7.0.1
 */