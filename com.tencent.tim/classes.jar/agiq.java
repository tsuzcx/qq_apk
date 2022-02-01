import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager.1;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager.2;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class agiq
  implements Manager
{
  private aepj jdField_a_of_type_Aepj;
  private aepk jdField_a_of_type_Aepk;
  private aepl jdField_a_of_type_Aepl;
  private aepm jdField_a_of_type_Aepm;
  private aepn jdField_a_of_type_Aepn;
  private aepp jdField_a_of_type_Aepp;
  private aepr jdField_a_of_type_Aepr;
  private aepo b;
  private boolean bVJ;
  private boolean bVP;
  private boolean bVQ;
  private boolean bVR;
  private boolean bVS;
  private boolean cdu;
  private boolean cdv;
  private boolean cdw;
  private boolean cdx;
  private boolean cdy;
  private boolean cdz;
  private HashMap<String, aepv.a> kI;
  private QQAppInterface mApp;
  private int strategy;
  
  public agiq(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    dgK();
    dgG();
    dgR();
    dgH();
    dgL();
    dgM();
    dgN();
    dgO();
    dgP();
    dgQ();
    dgI();
    dgJ();
  }
  
  private void ID(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadYYBPromoteActionConfig: load download config. " + paramString);
      }
      this.jdField_a_of_type_Aepp = ((aepp)aeij.a(paramString, aepp.class));
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void IE(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadYYBPromoteDialogConfig: load download config. " + paramString);
      }
      this.jdField_a_of_type_Aepr = ((aepr)aeij.a(paramString, aepr.class));
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void IF(String paramString)
  {
    try
    {
      aepv localaepv = (aepv)aeij.a(paramString, aepv.class);
      if (localaepv != null)
      {
        this.kI.clear();
        this.kI.putAll(localaepv.jZ);
      }
      if (TextUtils.isEmpty(paramString)) {
        QLog.i("QFileConfigManager", 1, "loadFileDownloadConfig: load download config. " + paramString);
      }
      return;
    }
    catch (QStorageInstantiateException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void dgG()
  {
    SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("file_config_" + this.mApp.getCurrentUin(), 0);
    this.cdu = localSharedPreferences.getBoolean("troop_video_preivew", false);
    this.cdv = localSharedPreferences.getBoolean("troop_video_preivew_for_svip", false);
    this.cdw = localSharedPreferences.getBoolean("troop_video_preivew_for_yearsvip", false);
    QLog.i("QFileConfigManager", 1, "initTroopFileVideoPreviewConfig: load common config. enableTroopVidePreview[" + this.cdu + "] enableTroopVidePreviewForSVIP[" + this.cdv + "] enableTroopVidePreviewForYearSVIP[" + this.cdw + "]");
  }
  
  private void dgH()
  {
    SharedPreferences localSharedPreferences = this.mApp.getApp().getSharedPreferences("file_config_" + this.mApp.getCurrentUin(), 0);
    this.cdz = localSharedPreferences.getBoolean("ipv6_all_switch", false);
    this.bVP = localSharedPreferences.getBoolean("ipv6_c2c_switch", false);
    this.bVQ = localSharedPreferences.getBoolean("ipv6_group_switch", false);
    this.bVR = localSharedPreferences.getBoolean("ipv6_disc_switch", false);
    this.bVS = localSharedPreferences.getBoolean("ipv6_dataline_switch", false);
    this.strategy = localSharedPreferences.getInt("ipv6_strategy", 0);
    QLog.i("QFileConfigManager", 1, "initFileIPv6Config: load config. enableFileIPv6[" + this.cdz + "] enableC2CIPv6[" + this.bVP + "] enableGroupIPv6[" + this.bVQ + "] enableDiscIPv6[" + this.bVR + "] enableDatalineIPv6[" + this.bVS + "] strategy[" + this.strategy + "]");
  }
  
  private void dgI()
  {
    ID(this.mApp.getApp().getSharedPreferences("file_config_" + this.mApp.getCurrentUin(), 0).getString("yyb_promote_action_key", "{}"));
  }
  
  private void dgJ()
  {
    IE(this.mApp.getApp().getSharedPreferences("file_config_" + this.mApp.getCurrentUin(), 0).getString("yyb_promote_dialog_key", "{}"));
  }
  
  private void dgK()
  {
    this.kI = new HashMap();
    String str = this.mApp.getApp().getSharedPreferences("file_config_" + this.mApp.getCurrentUin(), 0).getString("qfile_file_auto_download", "{}");
    QLog.i("QFileConfigManager", 1, "initFileDownloadConfig: load download config [" + str + "]");
    IF(str);
  }
  
  @Deprecated
  private void dgL()
  {
    String str = this.mApp.getApp().getSharedPreferences("file_exciting_" + this.mApp.getCurrentUin(), 0).getString("qfile_file_exciting", "{}");
    QLog.i("QFileConfigManager", 1, "initExcitingConfig: load download config [" + str + "]");
    aeqb localaeqb = new aeqb();
    localaeqb.lR(str);
    this.jdField_a_of_type_Aepl = localaeqb;
  }
  
  private void dgM()
  {
    String str = this.mApp.getApp().getSharedPreferences("c2cfile_excitingupload_" + this.mApp.getCurrentUin(), 0).getString("qfile_c2cfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Upload Config [" + str + "]");
    aepz localaepz = new aepz();
    localaepz.lR(str);
    this.jdField_a_of_type_Aepk = localaepz;
  }
  
  private void dgN()
  {
    String str = this.mApp.getApp().getSharedPreferences("c2cfile_excitingdownload_" + this.mApp.getCurrentUin(), 0).getString("qfile_c2cfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-C2C-Download Config [" + str + "]");
    aepx localaepx = new aepx();
    localaepx.lR(str);
    this.jdField_a_of_type_Aepj = localaepx;
  }
  
  private void dgO()
  {
    String str = this.mApp.getApp().getSharedPreferences("groupfile_excitingupload_" + this.mApp.getCurrentUin(), 0).getString("qfile_groupfile_excitingupload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Upload Config [" + str + "]");
    aeqf localaeqf = new aeqf();
    localaeqf.lR(str);
    this.jdField_a_of_type_Aepn = localaeqf;
  }
  
  private void dgP()
  {
    String str = this.mApp.getApp().getSharedPreferences("groupfile_excitingdownload_" + this.mApp.getCurrentUin(), 0).getString("qfile_groupfile_excitingdownload", "{}");
    QLog.i("QFileConfigManager", 1, "load Exciting-Group-Download Config [" + str + "]");
    aeqd localaeqd = new aeqd();
    localaeqd.lR(str);
    this.jdField_a_of_type_Aepm = localaeqd;
  }
  
  private void dgQ()
  {
    String str = this.mApp.getApp().getSharedPreferences("qfile_file_assistant_tips" + this.mApp.getCurrentUin(), 0).getString("qfile_file_assistant_tips", "{}");
    QLog.i("QFileConfigManager", 1, "load QFILE_CONFIG_FILE_ASSISTANT_TIPS Config [" + str + "]");
    aeqj localaeqj = new aeqj();
    localaeqj.lR(str);
    this.b = localaeqj;
  }
  
  private void dgR()
  {
    this.bVJ = this.mApp.getApp().getSharedPreferences("file_config_" + this.mApp.getCurrentUin(), 0).getBoolean("enable_file_media_platform", false);
    QLog.i("QFileConfigManager", 1, "initMediaPlatformConfig: load common config. enableFileMediaPlatform[" + this.bVJ + "]");
  }
  
  public void D(HashMap<String, aepv.a> paramHashMap)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.1(this, paramHashMap));
  }
  
  public int Eg()
  {
    return this.strategy;
  }
  
  public aepj a()
  {
    return this.jdField_a_of_type_Aepj;
  }
  
  public aepk a()
  {
    return this.jdField_a_of_type_Aepk;
  }
  
  @Deprecated
  public aepl a()
  {
    return this.jdField_a_of_type_Aepl;
  }
  
  public aepm a()
  {
    return this.jdField_a_of_type_Aepm;
  }
  
  public aepn a()
  {
    return this.jdField_a_of_type_Aepn;
  }
  
  public aepo a()
  {
    return this.b;
  }
  
  public aepp a()
  {
    return this.jdField_a_of_type_Aepp;
  }
  
  public aepr a()
  {
    return this.jdField_a_of_type_Aepr;
  }
  
  public aepv.a a(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.toLowerCase();
    }
    localObject = (aepv.a)this.kI.get(localObject);
    paramString = (String)localObject;
    if (localObject == null) {
      paramString = (aepv.a)this.kI.get("*");
    }
    localObject = paramString;
    if (paramString == null)
    {
      IF("{}");
      localObject = (aepv.a)this.kI.get("*");
    }
    return localObject;
  }
  
  public void a(aepj paramaepj)
  {
    this.jdField_a_of_type_Aepj = paramaepj;
  }
  
  public void a(aepk paramaepk)
  {
    this.jdField_a_of_type_Aepk = paramaepk;
  }
  
  @Deprecated
  public void a(aepl paramaepl)
  {
    this.jdField_a_of_type_Aepl = paramaepl;
  }
  
  public void a(aepm paramaepm)
  {
    this.jdField_a_of_type_Aepm = paramaepm;
  }
  
  public void a(aepn paramaepn)
  {
    this.jdField_a_of_type_Aepn = paramaepn;
  }
  
  public void a(aepo paramaepo)
  {
    this.b = paramaepo;
  }
  
  public boolean ald()
  {
    if (this.cdx) {
      return this.cdy;
    }
    return this.bVJ;
  }
  
  public boolean alh()
  {
    return this.cdu;
  }
  
  public boolean ali()
  {
    return this.cdv;
  }
  
  public boolean alj()
  {
    return this.cdw;
  }
  
  public boolean alk()
  {
    return this.bVP;
  }
  
  public boolean all()
  {
    return this.bVQ;
  }
  
  public boolean alm()
  {
    return this.bVR;
  }
  
  public boolean aln()
  {
    return this.bVS;
  }
  
  public void b(aepp paramaepp)
  {
    if (paramaepp != null) {
      this.jdField_a_of_type_Aepp = paramaepp;
    }
  }
  
  public void b(aepr paramaepr)
  {
    if (paramaepr != null) {
      this.jdField_a_of_type_Aepr = paramaepr;
    }
  }
  
  public void cx(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.2(this, paramBundle));
  }
  
  public void cy(Bundle paramBundle)
  {
    ThreadManager.getUIHandler().post(new QFileConfigManager.3(this, paramBundle));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agiq
 * JD-Core Version:    0.7.0.1
 */