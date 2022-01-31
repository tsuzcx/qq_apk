package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import ca;
import cb;
import cd;
import ce;
import cf;
import cg;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LiteMpFileDownloadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ce(this);
  public View.OnClickListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MpfileTaskListAdapter jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public View.OnClickListener b = new cg(this);
  
  public LiteMpFileDownloadActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new cf(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter.notifyDataSetChanged();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (MpfileTaskInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramAdapterView = FileManagerUtil.a((MpfileTaskInfo)localObject);
    paramView = new ForwardFileInfo();
    paramView.a(10009);
    paramView.c(7);
    paramView.b(paramAdapterView.nSessionId);
    paramView.d(((MpfileTaskInfo)localObject).jdField_d_of_type_JavaLangString);
    paramView.c(((MpfileTaskInfo)localObject).jdField_d_of_type_Long);
    paramView.d(((MpfileTaskInfo)localObject).b);
    paramView.a(((MpfileTaskInfo)localObject).e);
    localObject = new Intent(getApplicationContext(), FileBrowserActivity.class);
    if ((paramAdapterView.nFileType == 0) || (paramAdapterView.nFileType == 1))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(String.valueOf(paramAdapterView.nSessionId));
      ((Intent)localObject).putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
    }
    ((Intent)localObject).putExtra("fileinfo", paramView);
    startActivity((Intent)localObject);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903456);
    setTitle(getResources().getString(2131361921));
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter = new MpfileTaskListAdapter(this, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131296662));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new ca(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.dataline.mpfile.download_progress");
    paramBundle.addAction("com.dataline.mpfile.download_completed");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    ThreadManager.b(new cb(this));
    return false;
  }
  
  protected void doOnDestroy()
  {
    if (this.app.a() != null) {
      this.app.a().e();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new cd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileDownloadActivity
 * JD-Core Version:    0.7.0.1
 */