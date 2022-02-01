package com.tencent.mobileqq.filemanager.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import fpy;
import fpz;
import fqb;
import fqh;
import fqi;
import fqj;
import fqk;
import fql;
import fqm;
import fqn;
import fqp;
import java.util.List;

public class FMActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static final int a = 0;
  public static final int b = 1;
  public static String b;
  public static final int c = 2;
  public static final int d = 3;
  public long a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  public View.OnLongClickListener a;
  View jdField_a_of_type_AndroidViewView;
  public RecentFileAdapter a;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public SlideDetectListView a;
  public BubblePopupWindow a;
  List jdField_a_of_type_JavaUtilList = null;
  public View.OnClickListener b;
  View jdField_b_of_type_AndroidViewView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fqb(this);
  public View.OnClickListener c;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean;
  public View.OnClickListener d;
  public volatile boolean d;
  int e = 0;
  
  static
  {
    jdField_b_of_type_JavaLangString = "FMActivity<FileAssistant>";
  }
  
  public FMActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fqi(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new fqm(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new fqn(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new fqp(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new fpz(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.notifyDataSetChanged();
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setGone();
    }
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131232717));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(Integer.valueOf(-1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new fqh(this));
  }
  
  private void k()
  {
    if (g()) {
      setTitle(2131558674);
    }
    if (getIntent().getBooleanExtra("from_aio", false))
    {
      setTitle(2131558674);
      return;
    }
    setTitle(2131558684);
  }
  
  private void l()
  {
    try
    {
      if (getIntent().getBooleanExtra("from_aio", false))
      {
        if ((FileManagerUtil.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (a() == 0))
        {
          View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903534, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
          localView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(localView);
        }
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903488, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
        this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_a_of_type_AndroidViewView);
        this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903499, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_b_of_type_AndroidViewView);
        this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903503, this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView, false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_c_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setText(2131558713);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout = new ViewerMoreRelativeLayout(this);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    this.jdField_d_of_type_Boolean = false;
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
  
  private void n()
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    startActivityForResult(new Intent(getApplicationContext(), FMCloudActivity.class), 101);
    i();
  }
  
  private void o()
  {
    startActivityForResult(new Intent(getApplicationContext(), VerifyPwdActivity.class), 101);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setGone();
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.setVisible();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903487);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter = new RecentFileAdapter(this, this.jdField_a_of_type_JavaUtilList, this, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.jdField_d_of_type_AndroidViewView$OnClickListener);
    j();
    k();
    l();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    if (this.jdField_a_of_type_JavaUtilList.size() < 30) {
      c(true);
    }
    for (;;)
    {
      i();
      this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getViewTreeObserver().addOnGlobalLayoutListener(new fpy(this));
      return true;
      c(false);
    }
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
  }
  
  public void g()
  {
    if (getIntent().getBooleanExtra("from_aio", false))
    {
      int i = this.jdField_a_of_type_AndroidViewView.getHeight();
      int j = this.jdField_b_of_type_AndroidViewView.getHeight();
      int k = this.jdField_c_of_type_AndroidViewView.getHeight();
      int m = this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeight() - (i + 0 + j + k + m));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setLayoutParams(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getWidth(), this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.getHeight() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetViewerMoreRelativeLayout.getHeight());
  }
  
  public void h()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getResources().getStringArray(2131689515)[0], 3);
    localActionSheet.a(new fqj(this, localActionSheet));
    localActionSheet.setOnDismissListener(new fqk(this));
    localActionSheet.setOnCancelListener(new fql(this));
    localActionSheet.d(2131561746);
    localActionSheet.show();
  }
  
  public boolean j()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 4) || (paramInt2 == 5)) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    i();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (!c())
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "click too fast , wait a minute.");
      }
      return;
    }
    d();
    switch (i)
    {
    default: 
      return;
    case 2131232718: 
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.jdField_a_of_type_JavaLangString = "file_choose_aio";
      paramView.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
      m();
      return;
    case 2131232738: 
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      startActivityForResult(new Intent(getApplicationContext(), FMLocalFileActivity.class), 100);
      i();
      paramView = new FileManagerReporter.fileAssistantReportData();
      paramView.jdField_a_of_type_JavaLangString = "file_choose_aio";
      paramView.jdField_a_of_type_Int = 8;
      FileManagerReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView);
      return;
    }
    FileManagerUtil.a(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), c(), FileManagerUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, c(), null, 0));
    FileManagerUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), false);
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    this.jdField_d_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity
 * JD-Core Version:    0.7.0.1
 */