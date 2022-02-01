import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soload.config.SoConfig;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class anmf
{
  private static volatile anmf jdField_a_of_type_Anmf;
  SoConfig jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig;
  
  private anmf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.SoConfigManager", 2, "SoConfigManager init");
    }
    if (ays()) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig = SoConfig.readConfig();
    }
  }
  
  public static anmf a()
  {
    if (jdField_a_of_type_Anmf == null) {}
    try
    {
      if (jdField_a_of_type_Anmf == null) {
        jdField_a_of_type_Anmf = new anmf();
      }
      return jdField_a_of_type_Anmf;
    }
    finally {}
  }
  
  private SoConfig.SoInfo a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos != null)) {
      return (SoConfig.SoInfo)this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.mSoInfos.get(paramString);
    }
    return null;
  }
  
  private boolean ays()
  {
    return BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface;
  }
  
  public SoConfig.SoInfo a(String paramString, anmf.a parama, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoConfigManager", 2, "getSoInfo, name=" + paramString + ",isSync=" + paramBoolean + ", SoConfig=" + this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.isValid(paramString))
    {
      if (paramBoolean) {
        return null;
      }
      ((anmi)aeif.a().a(526)).a(new anmg(this, parama, paramString));
      return null;
    }
    if (paramBoolean) {
      return a(paramString);
    }
    if (parama != null) {
      parama.a(0, a(paramString));
    }
    return null;
  }
  
  public void update(anmh paramanmh)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig.update(paramanmh);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, SoConfig.SoInfo paramSoInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmf
 * JD-Core Version:    0.7.0.1
 */