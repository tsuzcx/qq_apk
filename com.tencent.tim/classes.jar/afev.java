import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.FaceModelsData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class afev
  extends afeu
{
  private boolean bXL;
  private int bwG;
  
  public afev(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ar.face.models_v8.2.0", paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "FaceModelsDownloadHandler construct,STR_RES_NAME = qq.android.ar.face.models_v8.2.0");
    }
  }
  
  public void HL(boolean paramBoolean)
  {
    if (!this.bXL) {
      this.bXL = paramBoolean;
    }
    super.HL(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "download restart userClick = " + paramBoolean);
    }
  }
  
  public void HO(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "download success: " + paramString);
    }
    if (adfb.e(paramString) != 0)
    {
      restoreState();
      adfa.br(0, false);
    }
    for (;;)
    {
      super.HO(paramString);
      return;
      adfa.br(0, true);
      anot.a(this.app, "dc00898", "", "", "0X8008358", "0X8008358", 0, 0, "", "", "model", "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("res_type", "model");
      anpc.a(this.app.getApp()).collectPerformance(this.app.getCurrentAccountUin(), "FaceResDownloadSuccess", true, 0L, 0L, localHashMap, "", true);
    }
  }
  
  public void a(XmlData paramXmlData)
  {
    super.a(paramXmlData);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "download begin");
    }
  }
  
  public void a(XmlData paramXmlData, boolean paramBoolean, int paramInt, String paramString)
  {
    if (!paramBoolean) {
      adfa.br(0, false);
    }
    super.a(paramXmlData, paramBoolean, paramInt, paramString);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "download finish: " + paramBoolean);
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
        QLog.d("FaceModelsDownloadHandler", 2, "isNetValid2Download by user ");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "isNetValid2Download by startup ");
    }
    return super.aiW();
  }
  
  public boolean aiY()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "downloadResource,isDownloadReqedByUser = " + this.bXL);
    }
    if (!this.bXL)
    {
      if (!adfa.am(this.app))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceModelsDownloadHandler", 2, "pre download config disable ");
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
        QLog.d("FaceModelsDownloadHandler", 2, "downloadResource later " + bool);
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
    adfa.hj(0, this.bwG);
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "download progress: " + this.bwG);
    }
  }
  
  public Class<? extends XmlData> g()
  {
    return FaceModelsData.class;
  }
  
  public int getBusinessId()
  {
    return 10061;
  }
  
  public void restoreState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceModelsDownloadHandler", 2, "restoreState");
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
 * Qualified Name:     afev
 * JD-Core Version:    0.7.0.1
 */