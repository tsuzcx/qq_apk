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
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bgi;
import bgj;
import bgk;
import bgl;
import bgm;
import bgn;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;

public class RecentLoginDevActivity
  extends IphoneTitleBarActivity
{
  private static final String jdField_a_of_type_JavaLangString = "Q.devlock.RecentLoginDevActivity";
  private Handler jdField_a_of_type_AndroidOsHandler = new bgi(this);
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new bgl(this);
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private List jdField_a_of_type_JavaUtilList = null;
  private String b = "";
  
  private void a(String paramString1, ArrayList paramArrayList, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = getResources().getString(2131364174);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null, 2131624119));
    paramString1 = getString(2131364172, new Object[] { str });
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramString1);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(getResources().getString(2131364173), 3, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d(2131362790);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new bgk(this, paramString2, paramArrayList, paramInt));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int j;
    int i;
    Object localObject1;
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      j = paramList.size();
      i = 0;
      while (i < j)
      {
        localObject1 = (SvcDevLoginInfo)paramList.get(i);
        if (localObject1 != null) {
          break label76;
        }
        i += 1;
      }
    }
    label76:
    Object localObject2 = getLayoutInflater().inflate(2130903229, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    RelativeLayout localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131296449);
    ((ImageView)((View)localObject2).findViewById(2131296961)).setVisibility(0);
    ((TextView)((View)localObject2).findViewById(2131297278)).setVisibility(8);
    Object localObject3 = (TextView)((View)localObject2).findViewById(2131296455);
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131296957);
    if (TextUtils.isEmpty(((SvcDevLoginInfo)localObject1).strDeviceName)) {
      ((TextView)localObject3).setText(2131364174);
    }
    for (;;)
    {
      localObject3 = new StringBuffer();
      if (((SvcDevLoginInfo)localObject1).iLoginTime > 0L) {
        ((StringBuffer)localObject3).append(TimeFormatterUtils.a(((SvcDevLoginInfo)localObject1).iLoginTime * 1000L, "MM-dd  HH:mm"));
      }
      if (!TextUtils.isEmpty(((SvcDevLoginInfo)localObject1).strLoginLocation))
      {
        ((StringBuffer)localObject3).append(" ");
        ((StringBuffer)localObject3).append(((SvcDevLoginInfo)localObject1).strLoginLocation);
      }
      if (!TextUtils.isEmpty(((SvcDevLoginInfo)localObject1).strDeviceTypeInfo))
      {
        ((StringBuffer)localObject3).append(" ");
        ((StringBuffer)localObject3).append(((SvcDevLoginInfo)localObject1).strDeviceTypeInfo);
      }
      if (((StringBuffer)localObject3).length() > 0) {
        localTextView.setText(((StringBuffer)localObject3).toString());
      }
      localRelativeLayout.setClickable(true);
      localRelativeLayout.setTag(localObject1);
      localRelativeLayout.setOnClickListener(new bgj(this, localRelativeLayout, i));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      if (i == j - 1) {
        break;
      }
      localObject1 = new ImageView(this);
      ((ImageView)localObject1).setBackgroundResource(2130837995);
      localObject2 = new LinearLayout.LayoutParams(-1, 1);
      ((LinearLayout.LayoutParams)localObject2).setMargins((int)this.c * 14, 0, (int)this.c * 14, 0);
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      break;
      ((TextView)localObject3).setText(((SvcDevLoginInfo)localObject1).strDeviceName);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new bgm(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new bgn(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903492);
    setTitle(2131364177);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298224));
    try
    {
      this.b = getPackageManager().getPackageInfo(getPackageName(), 0).packageName;
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "packName = " + this.b);
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onCreate begin to getRecentLoginDevList");
      }
      bool = EquipmentLockImpl.a().b(this.app, this.b, 0L);
      if (bool)
      {
        c();
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
    d();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity
 * JD-Core Version:    0.7.0.1
 */