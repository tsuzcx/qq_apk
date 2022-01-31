package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileCategoryBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.IReport_Ver51;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.widget.XListView;
import dfx;
import dfy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String c = "FileAssistantActivity<FileAssistant>";
  public View.OnClickListener a;
  public FileCategoryAdapter a;
  XListView a;
  public List a;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dfy(this);
  }
  
  private void b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt)
    {
    default: 
      localObject1 = localObject2;
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
      if (paramInt == 7) {
        if (g()) {
          a().aj();
        }
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label263;
      }
      return;
      localObject1 = new Intent(getApplicationContext(), QfileLocalFileCategoryBrowserActivity.class);
      break;
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        localObject1 = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
        break;
      }
      FMToastUtil.a(2131362004);
      localObject1 = localObject2;
      break;
      a().ah();
      finish();
      overridePendingTransition(2130968597, 2130968598);
      return;
      a().al();
      continue;
      if ((paramInt == 8) || (paramInt == 8)) {
        if (g()) {
          a().ak();
        } else {
          a().am();
        }
      }
    }
    try
    {
      label263:
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("category", paramInt);
      ((Intent)localObject1).putExtra("bundle", (Bundle)localObject2);
      localObject2 = getIntent();
      boolean bool = ((Intent)localObject2).getBooleanExtra("STRING_SingleSelect", false);
      ((Intent)localObject1).putExtra("localSdCardfile", ((Intent)localObject2).getIntExtra("localSdCardfile", -1));
      if (bool) {
        ((Intent)localObject1).putExtra("STRING_SingleSelect", bool);
      }
      localObject2 = ((Intent)localObject2).getStringArrayExtra("STRING_Show_Within_Suffixs");
      if (localObject2 != null) {
        ((Intent)localObject1).putExtra("STRING_Show_Within_Suffixs", (String[])localObject2);
      }
      startActivityForResult((Intent)localObject1, 100);
      overridePendingTransition(2130968597, 2130968598);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    this.b = getString(2131361938);
    setTitle(this.b);
  }
  
  private void p()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    String str1 = getString(2131361961);
    String str2 = getString(2131361953);
    String str3 = getString(2131361954);
    String str4 = getString(2131361955);
    String str5 = getString(2131361948);
    String str6 = getString(2131361958);
    String str7 = getString(2131361959);
    String str8 = getString(2131361960);
    String str9 = getString(2131361941);
    Intent localIntent = getIntent();
    boolean bool8;
    boolean bool7;
    boolean bool6;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    boolean bool1;
    boolean bool5;
    if (localIntent != null)
    {
      bool8 = localIntent.getBooleanExtra("STRING_Show_Music_Category", true);
      bool7 = localIntent.getBooleanExtra("STRING_Show_Video_Category", true);
      bool6 = localIntent.getBooleanExtra("STRING_Show_Apk_Category", true);
      bool2 = localIntent.getBooleanExtra("STRING_Show_Pic_Category", true);
      bool3 = localIntent.getBooleanExtra("STRING_Show_Download_Category", true);
      bool4 = localIntent.getBooleanExtra("STRING_Show_Driver_Category", true);
      bool1 = localIntent.getBooleanExtra("STRING_Show_MyFile_Category", false);
      boolean bool9 = localIntent.getBooleanExtra("STRING_Show_First_Space", true);
      bool5 = bool3;
      bool3 = bool1;
      bool1 = bool9;
    }
    for (;;)
    {
      if (bool4) {
        a(2130903422, 2130838740, 2, null, 0, false, 0, 1);
      }
      if (bool2) {
        a(2130903420, 2130838546, 0, str1, FileCategoryUtil.a(this), true, 10, 2);
      }
      if (bool8) {
        a(2130903420, 2130838544, 0, str2, FileCategoryUtil.b(this), true, 1, 3);
      }
      if (bool7) {
        a(2130903420, 2130838549, 0, str3, FileCategoryUtil.c(this), true, 2, 3);
      }
      if (bool6) {
        a(2130903420, 2130838539, 0, str4, 0, true, 4, 4);
      }
      if (bool3) {
        a(2130903420, 2130838542, 0, str9, 0, false, 20, 2);
      }
      if (bool1) {
        a(2130903414, 2130838740, 1, null, 0, false, 0, 1);
      }
      if (bool5) {
        a(2130903420, 2130838541, 0, str5, 0, false, 6, 2);
      }
      a(2130903420, 2130838547, 0, str6, 0, false, 7, 3);
      if (FileManagerUtil.a(this).containsKey("externalSdCard"))
      {
        a(2130903420, 2130838548, 0, str7, 0, false, 8, 3);
        a(2130903420, 2130838548, 0, str8, 0, false, 11, 4);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter == null)
      {
        return;
        a(2130903420, 2130838548, 0, str7, 0, false, 8, 4);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      n();
      return;
      bool1 = true;
      bool3 = false;
      bool5 = true;
      bool2 = true;
      bool6 = true;
      bool7 = true;
      bool8 = true;
      bool4 = true;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.B = paramInt1;
    localFileCategoryEntity.C = paramInt2;
    localFileCategoryEntity.A = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString;
    localFileCategoryEntity.D = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean;
    localFileCategoryEntity.E = paramInt5;
    localFileCategoryEntity.F = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      if (paramInt2 == 5) {
        a().ai();
      }
      return;
    }
    p();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903424);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131298041));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    o();
    p();
    Intent localIntent;
    switch (getIntent().getIntExtra("localSdCardfile", -1))
    {
    default: 
      localIntent = getIntent();
      String str = localIntent.getStringExtra("targetUin");
      if ((paramBundle == null) || (!AppConstants.T.equals(str))) {
        break;
      }
    }
    for (;;)
    {
      m();
      return true;
      f();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131361938);
      return true;
      this.h.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setEditBtnVisible(false);
      setTitle(2131361938);
      break;
      b(localIntent.getIntExtra("category", 0));
    }
  }
  
  public void n()
  {
    new dfx(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */