package com.tencent.mobileqq.activity;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import daa;
import dab;
import dac;
import dad;
import dae;
import daf;
import dag;
import dai;
import java.util.ArrayList;
import java.util.List;

public class ProfileCardMoreActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  private static final int h = 7;
  private static final int i = 1;
  private static final int j = 2;
  long jdField_a_of_type_Long;
  private DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new daa(this);
  public Intent a;
  public ProfileActivity.AllInOne a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new dai(this);
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dag(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dae(this);
  private ShieldListObserver jdField_a_of_type_ComTencentMobileqqAppShieldListObserver = new daf(this);
  private QQCustomDialogWtihInput jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public QQProgressDialog a;
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private DialogInterface.OnClickListener jdField_b_of_type_AndroidContentDialogInterface$OnClickListener = new dab(this);
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_b_of_type_JavaLangString;
  public FormSimpleItem c;
  private String c;
  FormSimpleItem jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private String jdField_d_of_type_JavaLangString;
  private int k;
  
  public ProfileCardMoreActivity()
  {
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void a(int paramInt1, FormSimpleItem paramFormSimpleItem, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.jdField_a_of_type_ArrayOfInt.length) || (paramFormSimpleItem == null)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfInt[paramInt1] == 1)
    {
      paramFormSimpleItem.setVisibility(0);
      paramFormSimpleItem.setOnClickListener(this);
      if ((paramInt1 == paramInt2) && (paramInt1 == paramInt3))
      {
        paramFormSimpleItem.setBgType(0);
        return;
      }
      if (paramInt1 == paramInt2)
      {
        paramFormSimpleItem.setBgType(1);
        return;
      }
      if (paramInt1 == paramInt3)
      {
        paramFormSimpleItem.setBgType(3);
        return;
      }
      paramFormSimpleItem.setBgType(2);
      return;
    }
    paramFormSimpleItem.setVisibility(8);
  }
  
  private String c()
  {
    Object localObject = null;
    try
    {
      String str = ContactUtils.d(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.FrdProfileCard", 2, localException.toString());
    }
    return localObject;
    return null;
  }
  
  private boolean c()
  {
    ShieldMsgManger localShieldMsgManger = null;
    Object localObject = null;
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
    {
    default: 
      localShieldMsgManger = (ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localShieldMsgManger == null) {
        break label152;
      }
      if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      }
      break;
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      return localShieldMsgManger.a((String)localObject);
      localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject == null) {}
      for (localObject = localShieldMsgManger; (localObject != null) && (((Friends)localObject).groupid == -1002); localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) {
        return true;
      }
      return false;
      if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        localObject = c();
      }
    }
    label152:
    return false;
  }
  
  protected ProfileActivity.CardContactInfo a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
          localObject1 = (ProfileActivity.CardContactInfo)this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList.get(0);
        }
      }
    }
    return localObject1;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramInt1, d(), 0, paramInt2);
  }
  
  void a(String paramString)
  {
    DialogUtil.a(this, 230).setTitle(getString(2131561924)).setMessage(getString(2131561974)).setPositiveButton(2131562750, new dad(this, paramString)).setNegativeButton(2131561751, new dac(this)).show();
  }
  
  void a(boolean paramBoolean)
  {
    boolean bool = true;
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      if (localShieldMsgManger != null) {}
      for (;;)
      {
        int m;
        try
        {
          Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if (ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            localObject = c();
          }
          long l = Long.parseLong((String)localObject);
          localObject = new ArrayList();
          ((List)localObject).add(Long.valueOf(l));
          m = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          if (paramBoolean)
          {
            localShieldMsgManger.b(m, (List)localObject);
            m = 1;
          }
          switch (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
          {
          default: 
            n = m;
            if (n == 0) {
              break label301;
            }
            if (paramBoolean) {
              break label296;
            }
            paramBoolean = bool;
            this.jdField_a_of_type_Boolean = paramBoolean;
            this.jdField_k_of_type_Int |= 0x2;
            g();
            return;
            localShieldMsgManger.a(m, (List)localObject);
            continue;
            m = 0;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.profilecard.FrdProfileCard", 2, "shieldMsg() " + localNumberFormatException.toString());
          }
        }
        continue;
        int n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString != null)
        {
          n = m;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.length() > 0)
          {
            if (paramBoolean) {
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              n = 1;
              break;
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            }
            label296:
            paramBoolean = false;
          }
        }
      }
      label301:
      if (paramBoolean) {
        a(2131561761, 1);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
        return;
        a(2131562919, 1);
      }
    }
    a(2131562452, 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    h();
    if ((this.jdField_k_of_type_Int & 0x2) == 2)
    {
      if (!paramBoolean1) {
        break label72;
      }
      if (!paramBoolean2) {
        break label61;
      }
      a(2131563118, 2);
    }
    for (;;)
    {
      this.jdField_k_of_type_Int &= 0xFFFFFFFD;
      this.jdField_a_of_type_Boolean = c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
      return;
      label61:
      a(2131561718, 2);
      continue;
      label72:
      if (paramBoolean2) {
        a(2131561761, 1);
      } else {
        a(2131562919, 1);
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    FormSimpleItem localFormSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {}
    for (paramString = "";; paramString = this.jdField_c_of_type_JavaLangString)
    {
      localFormSimpleItem.setRightText(paramString);
      if (this.jdField_a_of_type_AndroidContentIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("remark", this.jdField_c_of_type_JavaLangString);
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
  }
  
  void c()
  {
    c(2130903606);
    setTitle(2131562408);
    this.jdField_k_of_type_AndroidWidgetTextView.setText(2131561692);
    this.m.setVisibility(8);
    Object localObject1 = findViewById(2131231305);
    label97:
    int m;
    int n;
    int i1;
    if (this.jdField_a_of_type_ArrayOfInt[5] == 1)
    {
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      localObject1 = findViewById(2131231314);
      if (this.jdField_a_of_type_ArrayOfInt[6] != 1) {
        break label148;
      }
      ((View)localObject1).setVisibility(0);
      ((View)localObject1).setOnClickListener(this);
      m = 0;
      n = -1;
      i1 = -1;
      label103:
      if (m > 2) {
        break label158;
      }
      if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
        break label702;
      }
      if (i1 >= 0) {
        break label699;
      }
      i1 = m;
      label124:
      if (n >= m) {
        break label696;
      }
      n = m;
    }
    label148:
    label158:
    label678:
    label687:
    label690:
    label693:
    label696:
    label699:
    label702:
    for (;;)
    {
      m += 1;
      break label103;
      ((View)localObject1).setVisibility(8);
      break;
      ((View)localObject1).setVisibility(8);
      break label97;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233047));
      a(0, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233048));
      a(1, this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233049));
      a(2, this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
      m = 3;
      n = -1;
      i1 = -1;
      if (m <= 4)
      {
        if (this.jdField_a_of_type_ArrayOfInt[m] != 1) {
          break label693;
        }
        if (i1 >= 0) {
          break label690;
        }
        i1 = m;
        if (n >= m) {
          break label687;
        }
        n = m;
      }
      for (;;)
      {
        m += 1;
        break;
        this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131233050));
        a(3, this.jdField_d_of_type_ComTencentMobileqqWidgetFormSimpleItem, i1, n);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131231303));
        label366:
        Object localObject2;
        if (this.jdField_a_of_type_ArrayOfInt[4] == 1) {
          if ((4 == i1) && (4 == n))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(0);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
            if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              localObject2 = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              if (localObject2 != null) {
                break label650;
              }
              localObject1 = null;
              if (localObject1 != null)
              {
                this.jdField_c_of_type_JavaLangString = ((Friends)localObject1).remark;
                localObject1 = ((FriendManager)localObject2).a(String.valueOf(((Friends)localObject1).groupid));
                if ((localObject1 != null) && (!Utils.a(this.jdField_d_of_type_JavaLangString, ((Groups)localObject1).group_name))) {
                  this.jdField_d_of_type_JavaLangString = ((Groups)localObject1).group_name;
                }
              }
              if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
              {
                localObject2 = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
                if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
                  break label669;
                }
                localObject1 = "";
                label489:
                ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
              }
              if (this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)
              {
                if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.equals("我的好友"))) {
                  this.jdField_d_of_type_JavaLangString = getString(2131559856);
                }
                localObject2 = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
                if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
                  break label678;
                }
              }
            }
          }
        }
        for (localObject1 = "";; localObject1 = this.jdField_d_of_type_JavaLangString)
        {
          ((FormSimpleItem)localObject2).setRightText((CharSequence)localObject1);
          if (this.jdField_a_of_type_ArrayOfInt[4] == 1)
          {
            this.jdField_a_of_type_Boolean = c();
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_Boolean);
          }
          return;
          if (4 == i1)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(1);
            break;
          }
          if (4 == n)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(3);
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setBgType(2);
          break;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
          break label366;
          localObject1 = ((FriendManager)localObject2).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          break label398;
          localObject1 = this.jdField_c_of_type_JavaLangString;
          break label489;
        }
        continue;
        break label269;
      }
      continue;
      break label124;
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[7];
    int m = 0;
    while (m < 7)
    {
      this.jdField_a_of_type_ArrayOfInt[m] = 0;
      m += 1;
    }
    if (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_a_of_type_ArrayOfInt[0] = 1;
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ArrayOfInt[2] = 1;
      this.jdField_a_of_type_ArrayOfInt[3] = 1;
      this.jdField_a_of_type_ArrayOfInt[5] = 1;
      this.jdField_a_of_type_ArrayOfInt[6] = 1;
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 58) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 22) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 47) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 3) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 74))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 56) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 57))
      {
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 32) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 31) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 50) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 51) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 34))
      {
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 71) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 72) || (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 27))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 1;
        this.jdField_a_of_type_ArrayOfInt[4] = 1;
        this.jdField_a_of_type_ArrayOfInt[6] = 1;
        return;
      }
    } while (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne));
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    this.jdField_a_of_type_ArrayOfInt[6] = 1;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onActivityResult, resultCode : " + paramInt1 + ", resultCode : " + paramInt2 + ", data : " + paramIntent);
    }
    Object localObject;
    if (paramInt2 == -1) {
      localObject = null;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (paramIntent != null) {
      localObject = paramIntent.getStringExtra("result");
    }
    if (localObject == null) {}
    for (paramIntent = "";; paramIntent = (Intent)localObject)
    {
      if (NetworkUtil.e(BaseApplication.getContext()))
      {
        if (!paramIntent.equals(this.jdField_c_of_type_JavaLangString))
        {
          localObject = (FriendListHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          if (localObject != null)
          {
            ((FriendListHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramIntent);
            this.jdField_k_of_type_Int |= 0x1;
            b(paramIntent);
            return;
          }
          a(2131562435, 1);
          return;
        }
        a(2131562516, 0);
        return;
      }
      a(2131562445, 1);
      return;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)getIntent().getParcelableExtra("AllInOne"));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    d();
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    h();
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  void e()
  {
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null)
    {
      localObject = null;
      if ((localObject != null) && (((Card)localObject).strReMark != null) && (((Card)localObject).strReMark.length() > 0)) {
        this.jdField_a_of_type_JavaLangString = ((Card)localObject).strReMark;
      }
      if ((localObject != null) && (((Card)localObject).strReMark.equals(""))) {
        this.jdField_a_of_type_JavaLangString = ((Card)localObject).strReMark;
      }
      if (((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() <= 0)) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 30))
      {
        localObject = a();
        if (localObject == null) {
          break label163;
        }
      }
    }
    label163:
    for (localObject = ((ProfileActivity.CardContactInfo)localObject).jdField_a_of_type_JavaLangString;; localObject = null)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialogWtihInput = DialogUtil.a(this, 2131562433, null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener, this.jdField_b_of_type_AndroidContentDialogInterface$OnClickListener);
      return;
      localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
    }
  }
  
  void f()
  {
    Object localObject = (FriendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((FriendManager)localObject).c(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
    {
      if (localObject != null) {
        startActivityForResult(new Intent(a(), MoveToGroupActivity.class).putExtra("friendUin", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).putExtra("mgid", (byte)((Friends)localObject).groupid), 0);
      }
      return;
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(2131562875);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    int m;
    if (paramView == null)
    {
      m = 0;
      switch (m)
      {
      }
    }
    do
    {
      long l;
      do
      {
        return;
        m = paramView.getId();
        break;
        l = System.currentTimeMillis();
      } while (!ProfileActivity.a(this.jdField_a_of_type_Long, l));
      this.jdField_a_of_type_Long = l;
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_more_more", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      e();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_more_edit_name", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      f();
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_more_move", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) {}
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;; paramView = null)
      {
        a(paramView);
        return;
      }
      ProfileCardUtil.a(this, Long.toString(ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_more_report", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      return;
      try
      {
        paramView = QZoneHelper.UserInfo.a();
        paramView.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        paramView.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e();
        QZoneHelper.a(this, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString).longValue(), -1);
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.f), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      }
      catch (Exception paramView) {}
    } while (!QLog.isColorLevel());
    QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileCardMoreActivity
 * JD-Core Version:    0.7.0.1
 */