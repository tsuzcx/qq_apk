package com.tencent.mobileqq.startup.step;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import com.tencent.mobileqq.startup.director.StartupDirector;
import gkc;
import mqq.app.AppActivity;
import mqq.app.permission.PermissionManager;

@TargetApi(23)
public class SetPermission
  extends Step
{
  private static final String jdField_b_of_type_JavaLangString = "sp_permission";
  private static final String c = "permission_first_show";
  private AppActivity jdField_a_of_type_MqqAppAppActivity;
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  
  private void a()
  {
    this.jdField_a_of_type_MqqAppAppActivity.permissionManager.request(new gkc(this));
  }
  
  protected boolean a()
  {
    this.jdField_a_of_type_MqqAppAppActivity = this.jdField_a_of_type_ComTencentMobileqqStartupDirectorStartupDirector.jdField_a_of_type_MqqAppAppActivity;
    this.b = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqAppAppActivity.getSharedPreferences("sp_permission", 0).getBoolean("permission_first_show", true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetPermission
 * JD-Core Version:    0.7.0.1
 */