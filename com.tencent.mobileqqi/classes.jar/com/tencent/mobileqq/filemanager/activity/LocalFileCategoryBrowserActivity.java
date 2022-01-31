package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.LocalFileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.LocalFileCategoryAdapter.LocalFileItemHolder;
import com.tencent.mobileqq.filemanager.data.LocalImageFileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.LocalImageFileCategoryAdapter.LocalImageHolder;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import fsh;
import fsi;
import fsj;
import fsk;
import fsl;
import java.util.ArrayList;

public class LocalFileCategoryBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String b;
  private static final int c = 4;
  private static final int d = 6;
  int jdField_a_of_type_Int = 50;
  public View.OnClickListener a;
  LocalFileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileCategoryAdapter = null;
  LocalImageFileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalImageFileCategoryAdapter = null;
  public NoFileRelativeLayout a;
  GridListView jdField_a_of_type_ComTencentMobileqqWidgetGridListView;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ArrayList a;
  public int b;
  public BaseActivity b;
  
  static
  {
    jdField_b_of_type_JavaLangString = "LocalFileCategoryBrowserActivity<FileAssistant>";
  }
  
  public LocalFileCategoryBrowserActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fsl(this);
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt + 1) * 6)) / paramInt;
  }
  
  private void a(View paramView)
  {
    FileInfo localFileInfo;
    if (this.jdField_b_of_type_Int == 10)
    {
      localFileInfo = ((LocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
      if (!g()) {
        break label121;
      }
      if (!FMDataCache.a(localFileInfo)) {
        break label97;
      }
      FMDataCache.b(localFileInfo);
      label38:
      f();
      if (this.jdField_b_of_type_Int != 10) {
        break label264;
      }
      paramView = (LocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag();
      if (!FMDataCache.a(localFileInfo)) {
        break label104;
      }
      paramView.b.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label97:
    label104:
    label121:
    do
    {
      return;
      localFileInfo = ((LocalFileCategoryAdapter.LocalFileItemHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
      break;
      FMDataCache.a(localFileInfo);
      break label38;
      paramView.b.setVisibility(4);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
      if (c()) {
        break label144;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    label144:
    d();
    paramView = FileManagerUtil.a(localFileInfo);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(paramView.nSessionId);
    localForwardFileInfo.c(3);
    localForwardFileInfo.a(10000);
    localForwardFileInfo.a(localFileInfo.c());
    localForwardFileInfo.d(localFileInfo.d());
    localForwardFileInfo.d(localFileInfo.a());
    Intent localIntent = new Intent(getApplicationContext(), QfileFileViewerActivity.class);
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    if (paramView.nFileType == 0)
    {
      FMDataCache.a(this.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra("clicked_file_hashcode", localFileInfo.hashCode());
    }
    startActivityForResult(localIntent, 102);
    return;
    label264:
    i();
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(4);
    this.jdField_a_of_type_Int = a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(this.jdField_a_of_type_Int);
    int i = (int)(6.0F * this.c);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing(i, i);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileCategoryAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileCategoryAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalImageFileCategoryAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalImageFileCategoryAdapter.notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    new fsk(this).execute(new Void[0]);
  }
  
  private void k()
  {
    setTitle(FileCategoryEntity.a(this.jdField_b_of_type_Int));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903498);
    this.jdField_b_of_type_Int = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_b_of_type_ComTencentMobileqqAppBaseActivity = this;
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232568));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131230904));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131558714);
    if (this.jdField_b_of_type_Int == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalImageFileCategoryAdapter = new LocalImageFileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalImageFileCategoryAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
      h();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalImageFileCategoryAdapter.a(this.jdField_a_of_type_Int);
      if (this.jdField_b_of_type_Int != 10) {
        break label282;
      }
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setVisibility(0);
    }
    for (;;)
    {
      k();
      j();
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(new fsh(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnScrollListener(new fsi(this));
      this.jdField_a_of_type_ComTencentWidgetXListView.getViewTreeObserver().addOnGlobalLayoutListener(new fsj(this));
      return true;
      this.jdField_a_of_type_ComTencentWidgetXListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileCategoryAdapter = new LocalFileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataLocalFileCategoryAdapter);
      break;
      label282:
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setVisibility(4);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentWidgetXListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetXListView.getHeight());
  }
  
  protected void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.LocalFileCategoryBrowserActivity
 * JD-Core Version:    0.7.0.1
 */