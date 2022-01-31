package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import yw;

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
  
  private View a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " parameter is Wrong!");
      }
      return null;
    }
    View localView = getLayoutInflater().inflate(2130903493, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    if ((localView == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, " view initialization failed!");
      }
      return null;
    }
    localView.setOnClickListener(new yw(this));
    ImageView localImageView = (ImageView)localView.findViewById(2131296457);
    TextView localTextView1 = (TextView)localView.findViewById(2131296455);
    TextView localTextView2 = (TextView)localView.findViewById(2131298210);
    TextView localTextView3 = (TextView)localView.findViewById(2131296957);
    if ((localImageView == null) || (localTextView1 == null) || (localTextView2 == null) || (localTextView3 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "some controls are invalide!");
      }
      return null;
    }
    localImageView.setVisibility(0);
    localTextView1.setText(paramString1);
    localTextView2.setText(getString(2131364255));
    localTextView3.setText(paramString2);
    return localView;
  }
  
  private void c()
  {
    setContentView(2130903488);
    setTitle(2131364204);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298214));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298213));
    if ((this.jdField_a_of_type_AndroidWidgetButton == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "one or more controls is null in AuthDevEnableCompleteActivity! ");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_JavaUtilArrayList = EquipmentLockImpl.a().a();
    int i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i2 = 0;
    int i1 = 0;
    Object localObject2;
    boolean bool1;
    label148:
    boolean bool2;
    for (;;)
    {
      if (i2 < i3)
      {
        localObject2 = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
        if (localObject2 == null)
        {
          i2 += 1;
        }
        else if ((((DeviceLockItemInfo)localObject2).c == 1) || (((DeviceLockItemInfo)localObject2).c == 2))
        {
          bool1 = true;
          if (((((DeviceLockItemInfo)localObject2).jdField_a_of_type_ArrayOfByte == null) || (!((DeviceLockItemInfo)localObject2).jdField_a_of_type_ArrayOfByte.equals(NetConnInfoCenter.GUID))) && (((DeviceLockItemInfo)localObject2).c != 1)) {
            break label373;
          }
          ((DeviceLockItemInfo)localObject2).jdField_a_of_type_Boolean = true;
          bool2 = false;
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        Object localObject1 = a(((DeviceLockItemInfo)localObject2).jdField_a_of_type_JavaLangString, ((DeviceLockItemInfo)localObject2).b, bool1, bool2, ((DeviceLockItemInfo)localObject2).jdField_a_of_type_Boolean);
        if (localObject1 != null)
        {
          ((DeviceLockItemInfo)localObject2).d = i1;
          i1 += 1;
          localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131296449);
          if (i3 == 1) {
            ((RelativeLayout)localObject2).setBackgroundResource(2130837928);
          }
          for (;;)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
            break;
            bool1 = false;
            break label148;
            if (i1 == 1) {
              ((RelativeLayout)localObject2).setBackgroundResource(2130837931);
            } else if (i2 == i3 - 1) {
              ((RelativeLayout)localObject2).setBackgroundResource(2130837930);
            } else {
              ((RelativeLayout)localObject2).setBackgroundResource(2130837931);
            }
          }
        }
        label373:
        try
        {
          localObject2 = this.app.a();
          if (EquipmentLockImpl.a().c()) {}
          for (localObject1 = "Push";; localObject1 = "Manually")
          {
            ReportController.b(null, "P_CliOper", "Safe_DeviceLock", (String)localObject2, "UserBehavior", (String)localObject1, 0, 10, "", "", "", "");
            return;
          }
        }
        catch (Exception localException) {}
      }
      bool2 = true;
    }
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  protected boolean a()
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
    case 2131298214: 
      if (QLog.isColorLevel()) {
        QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "click confirm mobile phone button! ");
      }
      break;
    }
    try
    {
      localObject = this.app.a();
      if (!EquipmentLockImpl.a().c()) {
        break label166;
      }
      paramView = "Push";
      ReportController.b(null, "P_CliOper", "Safe_DeviceLock", (String)localObject, "UserBehavior", paramView, 0, 11, "", "", "", "");
    }
    catch (Exception paramView)
    {
      Object localObject;
      label92:
      int i3;
      int i1;
      label117:
      int i2;
      label166:
      label172:
      label214:
      break label92;
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null))
    {
      i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i1 = 0;
      if (i1 < i3)
      {
        paramView = (DeviceLockItemInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        i2 = paramView.d;
        if (i2 >= 0)
        {
          localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i2);
          if (localObject != null) {
            break label172;
          }
        }
        for (;;)
        {
          i1 += 1;
          break label117;
          paramView = "Manually";
          break;
          if (((ImageView)((View)localObject).findViewById(2131296457)).getVisibility() == 0) {}
          for (i2 = 1;; i2 = 0)
          {
            if (i2 == 0) {
              break label214;
            }
            if (paramView.c != 0) {
              break;
            }
            paramView.c = 3;
            break;
          }
          paramView.c = 0;
        }
      }
    }
    EquipmentLockImpl.a().a(this.app, this.jdField_a_of_type_JavaUtilArrayList);
    paramView = new Intent(this, AuthDevActivity.class);
    paramView.putExtra("auth_dev_open", true);
    if (this.n != null)
    {
      paramView.putExtra("country_code", this.jdField_a_of_type_Int);
      paramView.putExtra("phone_num", this.n);
    }
    startActivity(paramView);
    overridePendingTransition(0, 2130968593);
    EquipmentLockImpl.a().d();
    finish();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("devlock.AuthDevEnableCompleteActivity", 2, "onClick right cancel button! ");
    }
    finish();
    overridePendingTransition(0, 2130968593);
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
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevEnableCompleteActivity
 * JD-Core Version:    0.7.0.1
 */