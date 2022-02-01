import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.VipProxyRreLoadReaderProcess;
import java.util.Calendar;
import mqq.manager.Manager;

public class avmd
  implements Manager
{
  public avcn.b a;
  public avcn.c a;
  public avmd.a a;
  public avmd.b a;
  public long azG;
  public boolean dnt;
  public boolean dnu;
  public boolean dnv;
  protected QQAppInterface mApp;
  
  public avmd(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.azG = (aqgz.getSystemTotalMemory() / 1048576L);
    eAJ();
  }
  
  private void a(avcm.a parama, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRProcessManager", 2, "run startQQReaderProcess");
    }
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), VipProxyRreLoadReaderProcess.class);
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", false);
    localIntent.putExtra("params_remote_connect_at_launch", true);
    localIntent.putExtra("params_uin_for_reader", this.mApp.getCurrentAccountUin());
    localIntent.putExtra("is_preload_reader_plugin", true);
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqreaderplugin.apk";
    locald.mPluginName = "qqreader";
    locald.mUin = this.mApp.getCurrentAccountUin();
    locald.cKu = "com.qqreader.ReaderPreloadReaderProcess";
    locald.mIntent = localIntent;
    if (parama != null)
    {
      locald.a = parama.a;
      parama.ad(2, paramString, paramInt);
    }
    avfw.b(BaseApplicationImpl.getContext(), locald);
  }
  
  private boolean aKK()
  {
    if (!this.dnt)
    {
      eAJ();
      if (QLog.isColorLevel()) {
        QLog.d("QRProcessManager", 2, "pluginType:1  preload:fail:dpc");
      }
    }
    return this.dnt;
  }
  
  private void eAJ()
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.qr_process_config.name(), "0|24");
    if (localObject != null)
    {
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 1) {
        this.dnt = "1".equals(localObject[0]);
      }
    }
  }
  
  private void eAK()
  {
    try
    {
      if (this.dnu) {
        return;
      }
      this.jdField_a_of_type_Avcn$c = new avcn.c(769, this.mApp.getCurrentAccountUin());
      if (this.jdField_a_of_type_Avcn$c.cNR != -1) {
        this.dnu = true;
      }
      this.dnv = this.jdField_a_of_type_Avcn$c.aqY;
      this.jdField_a_of_type_Avcn$b = avcn.b.a(this.jdField_a_of_type_Avcn$c.mExt1);
      if (this.jdField_a_of_type_Avcn$b == null) {
        this.jdField_a_of_type_Avcn$b = new avcn.b();
      }
      return;
    }
    finally {}
  }
  
  public void abM(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {
        avco.a((avcn)localObject, 500L);
      }
      return;
      if (this.jdField_a_of_type_Avmd$b == null) {
        this.jdField_a_of_type_Avmd$b = new avmd.b(6);
      }
      localObject = this.jdField_a_of_type_Avmd$b;
      continue;
      if (this.jdField_a_of_type_Avmd$a == null) {
        this.jdField_a_of_type_Avmd$a = new avmd.a(9999, "qqreader_qqbrowser_preload");
      }
      localObject = this.jdField_a_of_type_Avmd$a;
    }
  }
  
  public void bE(String paramString, long paramLong)
  {
    BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", aqmc.dw()).edit().putLong(paramString, paramLong).commit();
  }
  
  public long bp(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", aqmc.dw()).getLong(paramString, -1L);
  }
  
  public void eAL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRProcessManager", 2, "firstTimeLoadApk");
    }
    a(null, "", 0);
  }
  
  public void eAM()
  {
    String str = this.mApp.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", aqmc.dw());
    int i = fW(str);
    localSharedPreferences.edit().putInt("usedTimes" + str, i + 1).commit();
    i = Calendar.getInstance().get(11);
    int j = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + str, 0);
    localSharedPreferences.edit().putInt("usedTimesInHour" + i + ":" + str, j + 1).commit();
  }
  
  public int fW(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", aqmc.dw()).getInt("usedTimes" + paramString, 0);
  }
  
  public void onDestroy() {}
  
  public int[] s(String paramString)
  {
    int[] arrayOfInt = new int[24];
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qr_process_preload_profile", aqmc.dw());
    int i = 0;
    while (i < 24)
    {
      arrayOfInt[i] = localSharedPreferences.getInt("usedTimesInHour" + i + ":" + paramString, 0);
      i += 1;
    }
    return arrayOfInt;
  }
  
  public class a
    extends avcn
  {
    public final avcm.a a;
    private String cJh = "noreason";
    
    public a(int paramInt, String paramString)
    {
      this.mProcessName = "com.tencent.mobileqq:tool";
      this.dmf = false;
      this.mPluginID = "qqreaderplugin.apk";
      this.cdu = 1;
      this.cJf = "qqreaderplugin.apk";
      this.dmg = true;
      this.ewp = paramInt;
      this.jdField_a_of_type_Avcm$a = new avcm.a(this.cdu, this.ewp);
      this.jdField_a_of_type_Avcm$a.a = new ahyh(paramString, "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
    }
    
    protected boolean a(avco.a parama)
    {
      boolean bool = avmd.a(this.jdField_a_of_type_Avmd);
      if (bool) {}
      for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
      {
        this.cJh = str;
        if (parama != null)
        {
          parama.ewq = 2;
          parama.cJg = this.cJh;
        }
        return bool;
      }
    }
    
    protected void aBp()
    {
      this.cJh = "preload:ok:common";
      avmd.a(this.jdField_a_of_type_Avmd, this.jdField_a_of_type_Avcm$a, this.cJh, this.mStrategyId);
    }
    
    protected boolean b(avco.a parama)
    {
      return true;
    }
  }
  
  public class b
    extends avcn
  {
    public final avcm.a a;
    private String cJh = "noreason";
    
    public b(int paramInt)
    {
      this.mProcessName = "com.tencent.mobileqq:tool";
      this.dmf = false;
      this.mPluginID = "qqreaderplugin.apk";
      this.cdu = 1;
      this.cJf = "qqreaderplugin.apk";
      this.dmg = true;
      this.ewp = paramInt;
      this.jdField_a_of_type_Avcm$a = new avcm.a(this.cdu, this.ewp);
      this.jdField_a_of_type_Avcm$a.a = new ahyh("qqreader_leba_preload", "com.tencent.mobileqq:tool", "qqreaderplugin.apk");
    }
    
    public void a(avco.a parama)
    {
      if (parama == null) {
        return;
      }
      this.cJh = parama.cJg;
    }
    
    protected boolean a(avco.a parama)
    {
      boolean bool = avmd.a(this.jdField_a_of_type_Avmd);
      if (parama != null)
      {
        parama.ewq = 2;
        if (!bool) {
          break label66;
        }
      }
      label66:
      for (String str = "preload:ok:dpc";; str = "preload:fail:dpc")
      {
        parama.cJg = str;
        avmd.a(this.jdField_a_of_type_Avmd);
        if (this.jdField_a_of_type_Avmd.jdField_a_of_type_Avcn$c.cNR != -1) {
          this.ewr = this.jdField_a_of_type_Avmd.jdField_a_of_type_Avcn$c.ewC;
        }
        return bool;
      }
    }
    
    protected void aBp()
    {
      avmd.a(this.jdField_a_of_type_Avmd, this.jdField_a_of_type_Avcm$a, this.cJh, this.mStrategyId);
    }
    
    protected boolean b(avco.a parama)
    {
      boolean bool1;
      if (!this.jdField_a_of_type_Avmd.dnv)
      {
        if (parama != null) {
          parama.cJg = "preload:fail:serverswitch";
        }
        if (QLog.isColorLevel()) {
          QLog.d("QRProcessManager", 2, "pluginType:" + this.cdu + "  preload:fail:serverswitch");
        }
        bool1 = false;
      }
      boolean bool2;
      do
      {
        return bool1;
        String str = this.jdField_a_of_type_Avmd.mApp.getCurrentAccountUin();
        bool2 = a(this.jdField_a_of_type_Avmd.jdField_a_of_type_Avcn$b, String.valueOf(769), this.jdField_a_of_type_Avmd.mApp, "com.read.android", this.jdField_a_of_type_Avmd.fW(str), this.jdField_a_of_type_Avmd.bp(str), this.jdField_a_of_type_Avmd.s(str), parama);
        this.cJh = parama.cJg;
        bool1 = bool2;
      } while (this.jdField_a_of_type_Avmd.jdField_a_of_type_Avcn$b == null);
      this.mStrategyId = this.jdField_a_of_type_Avmd.jdField_a_of_type_Avcn$b.ewt;
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avmd
 * JD-Core Version:    0.7.0.1
 */