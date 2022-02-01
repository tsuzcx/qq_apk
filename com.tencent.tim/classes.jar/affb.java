import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.MiniScanDecodeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.MiniScanDetectSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class affb
  extends afeu
{
  private boolean bXL;
  private int bwG;
  
  public affb(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.minidetect.so_v8.2.0", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    Object localObject = b();
    if ((paramBoolean) && ((localObject instanceof MiniScanDecodeSoData)))
    {
      localObject = (MiniScanDecodeSoData)localObject;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDetectSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
      }
      if (!((MiniScanDecodeSoData)localObject).block_user_download) {}
    }
    do
    {
      return;
      if (!this.bXL) {
        this.bXL = paramBoolean;
      }
      super.HL(paramBoolean);
    } while (!QLog.isColorLevel());
    QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "restartDownload userClick=" + paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download success: " + paramString);
    }
    int i = adju.e(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download success: " + paramString + ",ret = " + i);
    }
    if (i != 0)
    {
      restoreState();
      cYN();
      adjr.br(1, false);
    }
    for (;;)
    {
      super.HO(paramString);
      return;
      adjr.br(1, true);
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download begin");
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      restoreState();
      cYN();
      adjr.br(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download finish: " + paramBoolean);
    }
  }
  
  public boolean aiV()
  {
    return true;
  }
  
  public boolean aiW()
  {
    if (this.bXL)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.aiW();
  }
  
  public boolean aiY()
  {
    if (!this.bXL)
    {
      if (BaseActivity.mAppForground) {}
      for (boolean bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "downloadResource later " + bool);
        }
        if (!bool) {
          break;
        }
        return false;
      }
    }
    return super.aiY();
  }
  
  public void aq(long paramLong1, long paramLong2)
  {
    super.aq(paramLong1, paramLong2);
    this.bwG = ((int)(100L * paramLong1 / paramLong2));
    adjr.hj(1, this.bwG);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "download progress: " + this.bwG);
    }
  }
  
  public void cYL()
  {
    boolean bool = ahbj.deleteFile(new File(adju.sD()));
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "deleteUnZipFile ret: " + bool);
    }
  }
  
  public void cYN()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidetect_so_version", getVersion()).apply();
  }
  
  public Class<? extends XmlData> g()
  {
    return MiniScanDetectSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10083;
  }
  
  public void restoreState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDetectSoDownloadHandler", 2, "restoreState");
    }
    b().loadState = 0;
    b().Version = 0;
    afel.a(b(), new String[0]);
  }
  
  public String un()
  {
    return "MiniScanDetectSoData";
  }
  
  public String uo()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     affb
 * JD-Core Version:    0.7.0.1
 */