package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import dkb;
import dkc;
import dkd;
import dke;
import dkf;
import dkg;
import java.util.ArrayList;
import java.util.List;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.RecentLoginDevActivity";
  private Handler jdField_a_of_type_AndroidOsHandler = new dkb(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new dke(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private List jdField_a_of_type_JavaUtilList = null;
  private String b;
  
  public RecentLoginDevActivity()
  {
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131563124);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    paramString1 = getString(2131561489, new Object[] { str });
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131562751), 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131561746);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new dkd(this, paramString2, paramArrayList, paramInt));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int j;
    int i;
    SvcDevLoginInfo localSvcDevLoginInfo;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localSvcDevLoginInfo = (SvcDevLoginInfo)paramList.get(i);
        if (localSvcDevLoginInfo != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    View localView = getLayoutInflater().inflate(2130903271, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131230995);
    ((ImageView)localView.findViewById(2131231016)).setVisibility(0);
    label130:
    Object localObject;
    TextView localTextView;
    if (j == 1)
    {
      localRelativeLayout.setBackgroundResource(2130837875);
      ((TextView)localView.findViewById(2131231898)).setVisibility(8);
      localObject = (TextView)localView.findViewById(2131231000);
      localTextView = (TextView)localView.findViewById(2131231506);
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceName)) {
        break label386;
      }
      ((TextView)localObject).setText(2131563124);
    }
    for (;;)
    {
      localObject = new StringBuffer();
      if (localSvcDevLoginInfo.iLoginTime > 0L) {
        ((StringBuffer)localObject).append(TimeFormatterUtils.a(localSvcDevLoginInfo.iLoginTime * 1000L, "MM-dd  HH:mm"));
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strLoginLocation))
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strLoginLocation);
      }
      if (!TextUtils.isEmpty(localSvcDevLoginInfo.strDeviceTypeInfo))
      {
        ((StringBuffer)localObject).append(" ");
        ((StringBuffer)localObject).append(localSvcDevLoginInfo.strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject).length() > 0) {
        localTextView.setText(((StringBuffer)localObject).toString());
      }
      localRelativeLayout.setClickable(true);
      localRelativeLayout.setTag(localSvcDevLoginInfo);
      localRelativeLayout.setOnClickListener(new dkc(this, localRelativeLayout, i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      break;
      if (i == 0)
      {
        localRelativeLayout.setBackgroundResource(2130837880);
        break label130;
      }
      if (i == j - 1)
      {
        localRelativeLayout.setBackgroundResource(2130837877);
        break label130;
      }
      localRelativeLayout.setBackgroundResource(2130837879);
      break label130;
      label386:
      ((TextView)localObject).setText(localSvcDevLoginInfo.strDeviceName);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dkf(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dkg(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903570);
    setTitle(2131562727);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131232952));
    try
    {
      this.jdField_b_of_type_JavaLangString = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "packName = " + this.jdField_b_of_type_JavaLangString);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
      }
      bool = EquipmentLockImpl.a().b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString, 0L);
      if (bool)
      {
        d();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      boolean bool;
      do
      {
        for (;;)
        {
          paramBundle.printStackTrace();
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate getRecentLoginDevList failed ret=" + bool);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    e();
    b(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */