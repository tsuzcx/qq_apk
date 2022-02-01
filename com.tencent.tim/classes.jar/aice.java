import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

public class aice
{
  private static aice jdField_a_of_type_Aice = new aice();
  private PluginProcessKiller jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller;
  private DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private String bMQ;
  
  public static aice a()
  {
    return jdField_a_of_type_Aice;
  }
  
  private void a(String paramString, DynamicPluginManager paramDynamicPluginManager, PluginProcessKiller paramPluginProcessKiller)
  {
    int j = 1;
    int i;
    if ((paramString != null) && (paramString.equals("Now")))
    {
      i = 1;
      if ((this.bMQ == null) || (!this.bMQ.equals("Now"))) {
        break label55;
      }
    }
    for (;;)
    {
      if ((i == 0) && (j == 0)) {
        break label61;
      }
      return;
      i = 0;
      break;
      label55:
      j = 0;
    }
    label61:
    if ((paramString != null) && (!paramString.equals(this.bMQ)))
    {
      if (this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager != null)
      {
        PluginProcessKiller localPluginProcessKiller = (PluginProcessKiller)this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager.getManagerImpl();
        if (localPluginProcessKiller != null) {
          localPluginProcessKiller.onKillPluginProcess();
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller != null) {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller.onKillPluginProcess();
      }
    }
    this.bMQ = paramString;
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoShadowPluginProcessKiller = paramPluginProcessKiller;
  }
  
  public void a(String paramString, PluginProcessKiller paramPluginProcessKiller)
  {
    a(paramString, null, paramPluginProcessKiller);
  }
  
  public void a(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    a(paramString, paramDynamicPluginManager, null);
  }
  
  public String wN()
  {
    return this.bMQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aice
 * JD-Core Version:    0.7.0.1
 */