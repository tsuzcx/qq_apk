import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.MiniScanDecodeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class afez
  extends afeu
{
  private boolean bXL;
  private int bwG;
  
  public afez(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.minidecode.so_v8.2.0", paramQQAppInterface);
  }
  
  public void HL(boolean paramBoolean)
  {
    Object localObject = b();
    if ((paramBoolean) && ((localObject instanceof MiniScanDecodeSoData)))
    {
      localObject = (MiniScanDecodeSoData)localObject;
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, String.format("restartDownload block_user_download=%b", new Object[] { Boolean.valueOf(((MiniScanDecodeSoData)localObject).block_user_download) }));
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
    QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restartDownload userClick=" + paramBoolean);
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download success: " + paramString);
    }
    int i = adjs.e(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download success: " + paramString + ",ret = " + i);
    }
    if (i != 0)
    {
      restoreState();
      cYN();
      adjr.br(0, false);
    }
    for (;;)
    {
      super.HO(paramString);
      return;
      adjr.br(0, true);
    }
  }
  
  public void HP(boolean paramBoolean)
  {
    int i = 0;
    long l1 = adjv.h("report_tag_so_cover", 0L);
    long l2 = System.currentTimeMillis();
    String str;
    if (l2 - l1 > 86400000L)
    {
      str = "";
      XmlData localXmlData = b();
      if ((localXmlData == null) || (!(localXmlData instanceof MiniScanDecodeSoData))) {
        break label107;
      }
      i = ((MiniScanDecodeSoData)localXmlData).Version;
      str = adjs.jP("minicode");
      if ((localXmlData.loadState != 1) || (i <= 0) || (TextUtils.isEmpty(str))) {
        break label102;
      }
      paramBoolean = true;
    }
    for (;;)
    {
      adjv.k(paramBoolean, i, str);
      adjv.af("report_tag_so_cover", l2);
      return;
      label102:
      paramBoolean = false;
      continue;
      label107:
      paramBoolean = false;
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean)
    {
      restoreState();
      cYN();
      adjr.br(0, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download finish: " + paramBoolean);
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
        QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "isNetValid2Download by startup ");
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
          QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "downloadResource later " + bool);
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
    adjr.hj(0, this.bwG);
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "download progress: " + this.bwG);
    }
  }
  
  public void cYL()
  {
    boolean bool = ahbj.deleteFile(new File(adjs.sD()));
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "deleteUnZipFile ret: " + bool);
    }
  }
  
  public void cYN()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("mini_scan_sp", 4).edit().putInt("minidecode_so_version", getVersion()).apply();
  }
  
  public Class<? extends XmlData> g()
  {
    return MiniScanDecodeSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10083;
  }
  
  public void restoreState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniRecog.MiniScanDecodeSoDownloadHandler", 2, "restoreState");
    }
    b().loadState = 0;
    b().Version = 0;
    afel.a(b(), new String[0]);
  }
  
  public String un()
  {
    return "MiniScanDecodeSoData";
  }
  
  public String uo()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afez
 * JD-Core Version:    0.7.0.1
 */