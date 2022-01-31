package com.tencent.mobileqq.filemanager.activity.localfile;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalFileCategoryAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageFileCategoryAdapter;
import com.tencent.mobileqq.filemanager.activity.adapter.QfileLocalImageFileCategoryAdapter.LocalImageHolder;
import com.tencent.mobileqq.filemanager.activity.base.QfileFileItemHolder;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.qphone.base.util.QLog;
import dkn;
import dko;
import dkp;
import dkq;
import dkr;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QfileLocalFileCategoryBrowserActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String c;
  private static final int d = 4;
  private static final int e = 6;
  public View.OnClickListener a;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  QfileLocalFileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalFileCategoryAdapter = null;
  QfileLocalImageFileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageFileCategoryAdapter = null;
  public NoFileRelativeLayout a;
  QfilePinnedHeaderExpandableListView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView;
  GridListView jdField_a_of_type_ComTencentMobileqqWidgetGridListView;
  public ArrayList a;
  public LinkedHashMap a;
  int b = 50;
  public int c;
  
  static
  {
    jdField_c_of_type_JavaLangString = "QfileLocalFileCategoryBrowserActivity<FileAssistant>";
  }
  
  public QfileLocalFileCategoryBrowserActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new dkr(this);
  }
  
  private int a(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    return (int)(localDisplayMetrics.widthPixels - localDisplayMetrics.density * ((paramInt + 1) * 6)) / paramInt;
  }
  
  private void a(View paramView)
  {
    FileInfo localFileInfo;
    if (this.jdField_c_of_type_Int == 10)
    {
      localFileInfo = ((QfileLocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag()).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
      if (!j()) {
        break label124;
      }
      if (!FMDataCache.a(localFileInfo)) {
        break label100;
      }
      FMDataCache.b(localFileInfo);
      label38:
      m();
      if (this.jdField_c_of_type_Int != 10) {
        break label267;
      }
      paramView = (QfileLocalImageFileCategoryAdapter.LocalImageHolder)paramView.getTag();
      if (!FMDataCache.a(localFileInfo)) {
        break label107;
      }
      paramView.b.setVisibility(0);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    label100:
    label107:
    label124:
    do
    {
      return;
      localFileInfo = (FileInfo)((QfileFileItemHolder)paramView.getTag()).a;
      break;
      FMDataCache.a(localFileInfo);
      break label38;
      paramView.b.setVisibility(4);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
      if (c()) {
        break label147;
      }
    } while (!QLog.isColorLevel());
    QLog.i(jdField_c_of_type_JavaLangString, 2, "click too fast , wait a minute.");
    return;
    label147:
    g();
    paramView = FileManagerUtil.a(localFileInfo);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(paramView.nSessionId);
    localForwardFileInfo.c(3);
    localForwardFileInfo.a(10000);
    localForwardFileInfo.a(localFileInfo.d());
    localForwardFileInfo.d(localFileInfo.e());
    localForwardFileInfo.d(localFileInfo.a());
    Intent localIntent = new Intent(getApplicationContext(), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    if (paramView.nFileType == 0)
    {
      FMDataCache.a(this.jdField_a_of_type_JavaUtilArrayList);
      localIntent.putExtra("clicked_file_hashcode", localFileInfo.hashCode());
    }
    startActivityForResult(localIntent, 102);
    return;
    label267:
    p();
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setNumColumns(4);
    this.b = a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSize(this.b);
    int i = (int)(6.0F * this.jdField_c_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setGridSpacing(i, i);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalFileCategoryAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalFileCategoryAdapter.notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageFileCategoryAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageFileCategoryAdapter.notifyDataSetChanged();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    new dkq(this).execute(new Void[0]);
  }
  
  private void r()
  {
    setTitle(FileCategoryEntity.a(this.jdField_c_of_type_Int));
  }
  
  public void d()
  {
    p();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903417);
    this.jdField_c_of_type_Int = getIntent().getBundleExtra("bundle").getInt("category");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = this;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView = ((QfilePinnedHeaderExpandableListView)findViewById(2131298013));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView = ((GridListView)findViewById(2131296990));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131361976);
    if (this.jdField_c_of_type_Int == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageFileCategoryAdapter = new QfileLocalImageFileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageFileCategoryAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setMode(1);
      o();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalImageFileCategoryAdapter.a(this.b);
      if (this.jdField_c_of_type_Int != 10) {
        break label337;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setVisibility(0);
    }
    for (;;)
    {
      r();
      q();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setSelector(2131427345);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setGroupIndicator(getActivity().getResources().getDrawable(2130837934));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnItemClickListener(new dkn(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setOnScrollListener(new dko(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getViewTreeObserver().addOnGlobalLayoutListener(new dkp(this));
      return true;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put("本地文件分组", this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalFileCategoryAdapter = new QfileLocalFileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilLinkedHashMap, this.jdField_a_of_type_AndroidViewView$OnClickListener, null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityAdapterQfileLocalFileCategoryAdapter);
      break;
      label337:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.setVisibility(4);
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfilePinnedHeaderExpandableListView.getHeight());
  }
  
  protected void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileCategoryBrowserActivity
 * JD-Core Version:    0.7.0.1
 */