package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AuthDevEnableCompleteActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public static final String a = "from_login";
  public static final String b = "phone_num";
  public static final String c = "country_code";
  public static final String d = "auth_dev_open";
  public static final String e = "allow_set";
  public static final String f = "user_guide";
  public static final String g = "user_uin";
  public static final String h = "seq";
  public static final String i = "DevlockInfo";
  private static final String j = "devlock.AuthDevEnableCompleteActivity";
  private static final String k = "UserBehavior";
  private static final String l = "Manually";
  private static final String m = "Push";
  private int jdField_a_of_type_Int = 0;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = null;
  private String n = null;
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
      }
      return false;
    }
    View localView1 = View.inflate(this, 2130903573, null);
    if ((localView1 == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return false;
    }
    CheckBox localCheckBox = (CheckBox)localView1.findViewById(2131231475);
    View localView2 = localView1.findViewById(2131232956);
    TextView localTextView1 = (TextView)localView1.findViewById(2131232957);
    TextView localTextView2 = (TextView)localView1.findViewById(2131232958);
    if ((localCheckBox == null) || (localView2 == null) || (localTextView1 == null) || (localTextView2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
      }
      return false;
    }
    localCheckBox.setChecked(paramBoolean1);
    localCheckBox.setClickable(paramBoolean2);
    if (paramBoolean3) {
      localView2.setVisibility(8);
    }
    localTextView1.setText(paramString1);
    localTextView2.setText(paramString2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView1);
    return true;
  }
  
  private void d()
  {
    setContentView(2130903568);
    setTitle(2131561941);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232945));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232944));
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
      }
      return;
    }
    Object localObject = (TextView)findViewById(2131231456);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList = EquipmentLockImpl.a().a();
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    if (i1 < i3)
    {
      localObject = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localObject == null) {}
      while (((((DeviceLockItemInfo)localObject).jdField_a_of_type_ArrayOfByte == null) || (!((DeviceLockItemInfo)localObject).jdField_a_of_type_ArrayOfByte.equals(NetConnInfoCenter.GUID))) && (((DeviceLockItemInfo)localObject).c != 1))
      {
        i1 += 1;
        break;
      }
      ((DeviceLockItemInfo)localObject).jdField_a_of_type_Boolean = true;
      if (a(((DeviceLockItemInfo)localObject).jdField_a_of_type_JavaLangString + getString(2131561535), ((DeviceLockItemInfo)localObject).b, true, false, true)) {
        ((DeviceLockItemInfo)localObject).d = 0;
      }
    }
    for (i1 = 1;; i1 = 0)
    {
      int i2 = 0;
      if (i2 < i3)
      {
        localObject = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (localObject == null) {
          break label391;
        }
        if (!((DeviceLockItemInfo)localObject).jdField_a_of_type_Boolean) {}
      }
      for (;;)
      {
        i2 += 1;
        break;
        if ((((DeviceLockItemInfo)localObject).c == 1) || (((DeviceLockItemInfo)localObject).c == 2)) {}
        for (boolean bool = true;; bool = false)
        {
          if (!a(((DeviceLockItemInfo)localObject).jdField_a_of_type_JavaLangString, ((DeviceLockItemInfo)localObject).b, bool, true, false)) {
            break label391;
          }
          ((DeviceLockItemInfo)localObject).d = i1;
          i1 += 1;
          break;
        }
        label391:
        try
        {
          String str = this.b.a();
          if (EquipmentLockImpl.a().c()) {}
          for (localObject = "Push";; localObject = "Manually")
          {
            ReportController.b(null, "P_CliOper", "Safe_DeviceLock", str, "UserBehavior", (String)localObject, 0, 10, "", "", "", "");
            return;
          }
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131232945: 
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
      }
      break;
    }
    try
    {
      localObject = this.b.a();
      if (!EquipmentLockImpl.a().c()) {
        break label167;
      }
      paramView = "Push";
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", (String)localObject, "UserBehavior", paramView, 0, 11, "", "", "", "");
    }
    catch (Exception paramView)
    {
      Object localObject;
      label92:
      int i2;
      int i1;
      label116:
      int i3;
      label167:
      label173:
      break label92;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i1 = 0;
      if (i1 < i2)
      {
        paramView = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        i3 = paramView.d;
        if (i3 >= 0)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i3);
          if (localObject != null) {
            break label173;
          }
        }
        for (;;)
        {
          i1 += 1;
          break label116;
          paramView = "Manually";
          break;
          if (((CheckBox)((View)localObject).findViewById(2131231475)).isChecked())
          {
            if (paramView.c == 0) {
              paramView.c = 3;
            }
          }
          else {
            paramView.c = 0;
          }
        }
      }
    }
    EquipmentLockImpl.a().a(this.b, this.jdField_a_of_type_JavaUtilArrayList);
    paramView = new Intent(this, AuthDevActivity.class);
    paramView.putExtra("auth_dev_open", true);
    if (this.n != null)
    {
      paramView.putExtra("country_code", this.jdField_a_of_type_Int);
      paramView.putExtra("phone_num", this.n);
    }
    startActivity(paramView);
    overridePendingTransition(0, 2130968599);
    EquipmentLockImpl.a().d();
    finish();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
    }
    finish();
    overridePendingTransition(0, 2130968599);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject = getIntent();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    localObject = ((Intent)localObject).getExtras();
    if (localObject == null)
    {
      super.onCreate(paramBundle);
      finish();
      return;
    }
    this.n = ((Bundle)localObject).getString("phone_num");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("country_code");
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "on Create AuthDevEnableCompleteActivity！");
    }
    super.onCreate(paramBundle);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity
 * JD-Core Version:    0.7.0.1
 */