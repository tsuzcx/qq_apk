package com.tencent.mobileqq.permissionsDialog;

import android.app.Activity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import gdn;
import gdo;
import gdp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermissionsDialog
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private PermissionDialogCallback jdField_a_of_type_ComTencentMobileqqPermissionsDialogPermissionDialogCallback;
  
  private String a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      Object localObject1 = new ArrayList();
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = paramArrayOfString[i];
        if (this.jdField_a_of_type_AndroidAppActivity.checkSelfPermission((String)localObject2) != 0) {
          ((List)localObject1).add(localObject2);
        }
        i += 1;
      }
      if ((((List)localObject1).size() == 1) && (localObject1.toString().equals("android.permission.WRITE_EXTERNAL_STORAGE")))
      {
        localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131563375);
        return localObject1;
      }
      paramArrayOfString = this.jdField_a_of_type_AndroidAppActivity.getString(2131563374);
      Object localObject2 = ((List)localObject1).iterator();
      for (;;)
      {
        localObject1 = paramArrayOfString;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        String str = (String)((Iterator)localObject2).next();
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.CAMERA")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131563380);
        }
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131563376);
        }
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.RECORD_AUDIO")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131563379);
        }
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131563378);
        }
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.WRITE_CALENDAR")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131563382);
        }
        paramArrayOfString = (String[])localObject1;
        if (str.equals("android.permission.WRITE_CONTACTS")) {
          paramArrayOfString = (String)localObject1 + this.jdField_a_of_type_AndroidAppActivity.getString(2131563381);
        }
        localObject1 = paramArrayOfString;
        if (str.equals("android.permission.READ_PHONE_STATE")) {
          localObject1 = paramArrayOfString + this.jdField_a_of_type_AndroidAppActivity.getString(2131563377);
        }
        paramArrayOfString = (String)localObject1 + " ";
      }
    }
    return null;
  }
  
  public void a(Activity paramActivity, int paramInt, String[] paramArrayOfString, PermissionDialogCallback paramPermissionDialogCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqPermissionsDialogPermissionDialogCallback = paramPermissionDialogCallback;
    if (paramArrayOfString.length > 0)
    {
      paramPermissionDialogCallback = paramArrayOfString[0];
      paramPermissionDialogCallback = new gdn(this);
      paramActivity = DialogUtil.a(paramActivity, 230);
      paramActivity.setTitle(2131563365);
      paramActivity.setMessage(a(paramArrayOfString));
      paramActivity.setNegativeButton(2131563371, paramPermissionDialogCallback);
      paramActivity.setPositiveButton(2131563370, paramPermissionDialogCallback);
      paramActivity.setOnDismissListener(null);
      paramActivity.show();
    }
  }
  
  public void a(Activity paramActivity, PermissionDialogShowMessageCallback paramPermissionDialogShowMessageCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramPermissionDialogShowMessageCallback = new gdo(this, paramPermissionDialogShowMessageCallback);
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setContentView(2130903166);
    paramActivity.setTitle(2131563372);
    paramActivity.setMessage(2131563373);
    paramActivity.setNegativeButton(2131563369, paramPermissionDialogShowMessageCallback);
    paramActivity.setOnDismissListener(null);
    paramActivity.setCanceledOnTouchOutside(false);
    paramActivity.setCancelable(true);
    paramActivity.show();
  }
  
  public void a(Activity paramActivity, String[] paramArrayOfString, PermissionDialogCallback paramPermissionDialogCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqPermissionsDialogPermissionDialogCallback = paramPermissionDialogCallback;
    paramPermissionDialogCallback = new gdp(this);
    paramActivity = DialogUtil.a(paramActivity, 230);
    paramActivity.setTitle(2131563366);
    paramActivity.setMessage(a(paramArrayOfString));
    paramActivity.setNegativeButton(2131563368, paramPermissionDialogCallback);
    paramActivity.setPositiveButton(2131563367, paramPermissionDialogCallback);
    paramActivity.setOnDismissListener(null);
    paramActivity.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.permissionsDialog.PermissionsDialog
 * JD-Core Version:    0.7.0.1
 */