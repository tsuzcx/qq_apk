package com.tencent.mobileqq.filemanager.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.RecentFileAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.BubblePopupWindow;
import fvi;
import fvj;
import fvp;
import fvq;
import fvr;
import fvs;
import fvt;
import fvu;
import fvw;
import fvx;
import java.util.List;

public class FMRecentFileActivity
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
  public RecentFileAdapter a;
  NoFileRelativeLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = null;
  public ViewerMoreRelativeLayout a;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  public SlideDetectListView a;
  public BubblePopupWindow a;
  List jdField_a_of_type_JavaUtilList = null;
  public View.OnClickListener b;
  private FMObserver b;
  public View.OnClickListener c;
  boolean c;
  public View.OnClickListener d = new fvx(this);
  int e = 0;
  
  static
  {
    jdField_b_of_type_JavaLangString = "FMActivity<FileAssistant>";
  }
  
  public FMRecentFileActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter = null;
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fvp(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new fvt(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new fvu(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new fvw(this);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fvj(this);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
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
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131232715));
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter.a(Integer.valueOf(-1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new fvi(this));
  }
  
  private void j()
  {
    if (this.k.getText().toString().contains(getString(2131562047)))
    {
      FileManagerReporter.fileAssistantReportData localfileAssistantReportData = new FileManagerReporter.fileAssistantReportData();
      localfileAssistantReportData.jdField_a_of_type_JavaLangString = "file_asst_in";
      localfileAssistantReportData.jdField_a_of_type_Int = 11;
      FileManagerReporter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), localfileAssistantReportData);
    }
    setTitle(2131558684);
  }
  
  private void k()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout = new NoFileRelativeLayout(this);
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
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this, null);
    localActionSheet.a(getResources().getStringArray(2131689515)[0], 3);
    localActionSheet.a(new fvq(this, localActionSheet));
    localActionSheet.setOnDismissListener(new fvr(this));
    localActionSheet.setOnCancelListener(new fvs(this));
    localActionSheet.d(2131561746);
    localActionSheet.show();
  }
  
  public boolean j()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903485);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_JavaUtilList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter = new RecentFileAdapter(this, this.jdField_a_of_type_JavaUtilList, this, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.jdField_c_of_type_AndroidViewView$OnClickListener, this.jdField_a_of_type_AndroidViewView$OnLongClickListener, this.d);
    i();
    j();
    k();
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataRecentFileAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    if (this.jdField_a_of_type_JavaUtilList.size() < 30) {}
    for (boolean bool = true;; bool = false)
    {
      c(bool);
      h();
      return;
    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMRecentFileActivity
 * JD-Core Version:    0.7.0.1
 */