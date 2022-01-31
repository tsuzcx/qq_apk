package com.tencent.mobileqq.filemanager.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import cooperation.qlink.QlinkHelper;
import cooperation.qlink.QlinkPluginProxyActivity;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunRemoteCommand;
import cooperation.weiyun.WeiyunRemoteCommand.OnStateChangeListener;
import fwa;
import fwb;
import fwd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static final int a = 4;
  public static String b;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  private WeiyunRemoteCommand.OnStateChangeListener jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener = new fwd(this);
  private WeiyunRemoteCommand jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private FMObserver b;
  private volatile boolean c = false;
  
  static
  {
    jdField_b_of_type_JavaLangString = "FileAssistantActivity<FileAssistant>";
  }
  
  public FileAssistantActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fwa(this);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fwb(this);
  }
  
  private void g()
  {
    String str1 = getString(2131562423);
    getString(2131561854);
    getString(2131563308);
    String str2 = getString(2131558678);
    String str3 = getString(2131558677);
    String str4 = getString(2131558684);
    String str5 = getString(2131558676);
    a(2130903490, 2130838960, 2, "", 0, false, 0, "video", 1, false);
    a(2130903488, 2130838587, 0, str1, 0, false, 12, "offline", 2, true);
    a(2130903505, 2130838960, 1, str5, 0, true, 0, "other", 1, false);
    a(2130903489, 2130838604, 0, str4, 0, false, 13, "picture", 2, false);
    a(2130903489, 2130838601, 0, str2, 0, false, 14, "music", 3, false);
    a(2130903489, 2130838607, 0, str3, 0, false, 15, "other", 4, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void h()
  {
    Intent localIntent = QlinkHelper.c();
    Bundle localBundle = new Bundle();
    localBundle.putInt("string_from", 2);
    localIntent.putExtra("string_bundle", localBundle);
    QlinkPluginProxyActivity.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), localIntent, -1, null);
  }
  
  private void i()
  {
    this.c = false;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c() == true)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      startActivityForResult(new Intent(getApplicationContext(), VerifyPwdActivity.class), 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131562451));
  }
  
  private void j()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMCloudActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    startActivityForResult(new Intent(getApplicationContext(), VerifyPwdActivity.class), 101);
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = this.l;
    setTitle(2131558673);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand == null) {
      return;
    }
    int i = this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    label26:
    FileCategoryEntity localFileCategoryEntity;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
        if (localFileCategoryEntity.G == 16)
        {
          if (i != 4) {
            break label99;
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_b_of_type_JavaLangString, 2, "AlbumBackup:updateBackupInfo, upload state");
          }
        }
      }
    }
    for (localFileCategoryEntity.jdField_b_of_type_JavaLangString = getResources().getString(2131563306);; localFileCategoryEntity.jdField_b_of_type_JavaLangString = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      break label26;
      break;
      label99:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "AlbumBackup:updateBackupInfo, other state");
      }
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand);
    WeiyunHelper.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString2, int paramInt6, boolean paramBoolean2)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.D = paramInt1;
    localFileCategoryEntity.E = paramInt2;
    localFileCategoryEntity.C = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString1;
    localFileCategoryEntity.F = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean1;
    localFileCategoryEntity.G = paramInt5;
    localFileCategoryEntity.c = paramString2;
    localFileCategoryEntity.H = paramInt6;
    localFileCategoryEntity.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903493);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232727));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    l();
    g();
    paramBundle = new FileManagerReporter.fileAssistantReportData();
    paramBundle.jdField_a_of_type_JavaLangString = "file_asst_in";
    paramBundle.jdField_a_of_type_Int = 11;
    FileManagerReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramBundle);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    n();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    WeiyunHelper.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication());
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.c = true;
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    m();
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand$OnStateChangeListener);
  }
  
  public void finish()
  {
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */