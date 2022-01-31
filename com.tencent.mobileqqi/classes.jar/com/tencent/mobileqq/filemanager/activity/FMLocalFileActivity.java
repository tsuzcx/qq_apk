package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.XListView;
import fvf;
import fvg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FMLocalFileActivity
  extends BaseFileAssistantActivity
{
  public static String b = "FileAssistantActivity<FileAssistant>";
  public View.OnClickListener a;
  public FileCategoryAdapter a;
  XListView a;
  public List a;
  
  public FMLocalFileActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fvg(this);
  }
  
  private void a(int paramInt)
  {
    Intent localIntent = null;
    switch (paramInt)
    {
    }
    while (localIntent == null)
    {
      return;
      localIntent = new Intent(getApplicationContext(), LocalFileCategoryBrowserActivity.class);
      continue;
      if (Environment.getExternalStorageState().equals("mounted")) {
        localIntent = new Intent(getApplicationContext(), LocalFileBrowserActivity.class);
      } else {
        FMToastUtil.a(2131558741);
      }
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("category", paramInt);
      localIntent.putExtra("bundle", localBundle);
      startActivityForResult(localIntent, 100);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void h()
  {
    setTitle(2131558677);
  }
  
  private void i()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    String str1 = getString(2131558700);
    String str2 = getString(2131558691);
    String str3 = getString(2131558692);
    String str4 = getString(2131558693);
    String str5 = getString(2131558699);
    String str6 = getString(2131558696);
    String str7 = getString(2131558697);
    String str8 = getString(2131558698);
    a(2130903490, 2130838960, 2, null, 0, false, 0, 1);
    a(2130903489, 2130838608, 0, str1, FileCategoryUtil.a(this), true, 10, 2);
    a(2130903489, 2130838605, 0, str2, FileCategoryUtil.b(this), true, 1, 3);
    a(2130903489, 2130838611, 0, str3, FileCategoryUtil.c(this), true, 2, 3);
    a(2130903489, 2130838600, 0, str4, 0, true, 4, 4);
    a(2130903487, 2130838960, 1, null, 0, false, 0, 1);
    a(2130903489, 2130838602, 0, str5, 0, false, 6, 2);
    a(2130903489, 2130838609, 0, str6, 0, false, 7, 3);
    if (FileManagerUtil.a().containsKey("externalSdCard"))
    {
      a(2130903489, 2130838610, 0, str7, 0, false, 8, 3);
      a(2130903489, 2130838610, 0, str8, 0, false, 11, 4);
    }
    while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter == null)
    {
      return;
      a(2130903489, 2130838610, 0, str7, 0, false, 8, 4);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
    g();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.D = paramInt1;
    localFileCategoryEntity.E = paramInt2;
    localFileCategoryEntity.C = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString;
    localFileCategoryEntity.F = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean;
    localFileCategoryEntity.G = paramInt5;
    localFileCategoryEntity.H = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5)) {
      return;
    }
    i();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903493);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232727));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    h();
    i();
    Intent localIntent = getIntent();
    if ((paramBundle != null) && (AppConstants.P.equals(localIntent.getStringExtra("targetUin")))) {}
    for (;;)
    {
      return true;
      a(localIntent.getIntExtra("category", 0));
    }
  }
  
  public void g()
  {
    new fvf(this).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity
 * JD-Core Version:    0.7.0.1
 */