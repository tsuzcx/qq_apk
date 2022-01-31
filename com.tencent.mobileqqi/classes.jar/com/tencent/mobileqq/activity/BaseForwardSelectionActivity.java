package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;

public class BaseForwardSelectionActivity
  extends BaseActivity
{
  public ForwardOperations a;
  public boolean a;
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 20001))
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (getIntent() != null)
    {
      this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("call_by_forward", false);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations = new ForwardOperations(this, this.b, getIntent());
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardOperations.a();
    }
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2130968593, 2130968594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseForwardSelectionActivity
 * JD-Core Version:    0.7.0.1
 */