package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.LebaConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import cooperation.plugin.IPluginManager;
import fhx;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  protected int a()
  {
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a().a((PluginConfigProxy)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
    ((IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(24)).a();
    localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(4);
    ((ConfigHandler)localObject).a(new GetResourceReqInfo[] { ((ConfigHandler)localObject).c(), ((ConfigHandler)localObject).d(), ((ConfigHandler)localObject).f(), ((ConfigHandler)localObject).b(), ((ConfigHandler)localObject).e() });
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new fhx(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.b(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */