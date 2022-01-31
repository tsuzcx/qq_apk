package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.XListView;
import djh;
import dji;
import java.util.ArrayList;
import java.util.List;

public class QfileFileAssistantActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static final int b = 4;
  public static String c;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  FileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new dji(this);
  private volatile boolean d = false;
  
  static
  {
    jdField_c_of_type_JavaLangString = "FileAssistantActivity<FileAssistant>";
  }
  
  public QfileFileAssistantActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new djh(this);
  }
  
  private void n()
  {
    String str1 = getString(2131364061);
    String str2 = getString(2131364062);
    String str3 = getString(2131361943);
    String str4 = getString(2131361941);
    String str5 = getString(2131361947);
    String str6 = getString(2131361940);
    a(2130903412, 2130838715, 2, "", 0, false, 0, "video", 1, false, false);
    a(2130903409, 2130838503, 0, str1, 0, false, 12, "offline", 2, true, false);
    a(2130903426, 2130838715, 1, str6, 0, true, 0, "other", 1, false, false);
    a(2130903410, 2130838520, 0, str5, 0, false, 13, "picture", 2, false, this.app.a().d());
    a(2130903410, 2130838522, 0, str4, 0, false, 15, "other", 3, false, false);
    if ((((RegisterProxySvcPackHandler)this.app.a(9)).a() != 0) && (NetworkUtil.g(this))) {
      a(2130903410, 2130838504, 0, str2, 0, false, 19, "music", 3, false, false);
    }
    a(2130903410, 2130838517, 0, str3, 0, false, 14, "music", 4, false, false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void o()
  {
    this.d = false;
    if (this.app.a().c() == true)
    {
      this.app.a().e();
      return;
    }
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131362916));
  }
  
  private void p()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    startActivityForResult(localIntent, 101);
  }
  
  private void r()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = this.i;
    setTitle(2131361938);
    f();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean1, int paramInt5, String paramString2, int paramInt6, boolean paramBoolean2, boolean paramBoolean3)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.B = paramInt1;
    localFileCategoryEntity.C = paramInt2;
    localFileCategoryEntity.A = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString1;
    localFileCategoryEntity.D = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean1;
    localFileCategoryEntity.E = paramInt5;
    localFileCategoryEntity.jdField_c_of_type_JavaLangString = paramString2;
    localFileCategoryEntity.F = paramInt6;
    localFileCategoryEntity.b = paramBoolean2;
    localFileCategoryEntity.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
    {
      Intent localIntent = new Intent(this, ChatActivity.class);
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      localIntent.addFlags(268435456);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903414);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298004));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    r();
    n();
    paramBundle = new FileManagerReporter.fileAssistantReportData();
    paramBundle.b = "file_asst_in";
    paramBundle.a = 11;
    FileManagerReporter.a(this.app.a(), paramBundle);
    this.app.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.d = true;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void finish()
  {
    super.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.QfileFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */