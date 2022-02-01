import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.FaceScanNativeSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class afew
  extends afeu
{
  private boolean bXL;
  private int bwG;
  
  public afew(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.face.so_v8.3.6_32", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "FaceScanNativeSoDownloadHandler construct,STR_RES_NAME = qq.android.ar.face.so_v8.3.6_32,AppSetting.IS_CPU_64_BIT = false");
    }
  }
  
  public void HL(boolean paramBoolean)
  {
    if (!this.bXL) {
      this.bXL = paramBoolean;
    }
    super.HL(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download restart userClick" + paramBoolean);
    }
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + paramString);
    }
    int i = adfc.e(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download success: " + paramString + ",ret = " + i);
    }
    if (i != 0)
    {
      restoreState();
      cYN();
      adfa.br(1, false);
    }
    for (;;)
    {
      super.HO(paramString);
      return;
      adfa.br(1, true);
      anot.a(this.app, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", "so", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("res_type", "so");
      anpc.a(this.app.getApp()).collectPerformance(this.app.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download begin");
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      adfa.br(1, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download finish: " + paramBoolean);
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
        QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.aiW();
  }
  
  public boolean aiY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource,isDownloadReqedByUser = " + this.bXL);
    }
    if (!this.bXL)
    {
      if (!adfa.am(this.app))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoDownloadHandler", 2, "pre download config disable ");
        }
        return false;
      }
      if (BaseActivity.sTopActivity == null) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoDownloadHandler", 2, "downloadResource later " + bool);
      }
      if (bool) {
        break;
      }
      return super.aiY();
    }
  }
  
  public void aq(long paramLong1, long paramLong2)
  {
    super.aq(paramLong1, paramLong2);
    this.bwG = ((int)(100L * paramLong1 / paramLong2));
    adfa.hj(1, this.bwG);
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "download progress: " + this.bwG);
    }
  }
  
  public void cYL()
  {
    boolean bool = ahbj.deleteFile(new File(adfc.sr()));
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "deleteUnZipFile ret: " + bool);
    }
  }
  
  public void cYN()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("face_scan_sp", 4).edit().putInt("face_scan_native_so_version", getVersion()).apply();
  }
  
  public Class<? extends XmlData> g()
  {
    return FaceScanNativeSoData.class;
  }
  
  public int getBusinessId()
  {
    return 10061;
  }
  
  public void restoreState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoDownloadHandler", 2, "restoreState");
    }
    b().loadState = 0;
    b().Version = 0;
    afel.a(b(), new String[0]);
  }
  
  public String un()
  {
    return null;
  }
  
  public String uo()
  {
    return "prd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afew
 * JD-Core Version:    0.7.0.1
 */