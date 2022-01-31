package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cz;
import da;
import dc;
import dd;
import de;
import df;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LiteMpFileDownloadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dd(this);
  public View.OnClickListener a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MpfileTaskListAdapter jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter;
  ScrollerRunnable jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
  private SlideDetectListView jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  public View.OnClickListener b = new df(this);
  
  public LiteMpFileDownloadActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new de(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter.notifyDataSetChanged();
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (MpfileTaskInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramAdapterView = new Bundle();
    paramAdapterView.putString("fileId", paramView.c);
    paramAdapterView.putString("name", paramView.d);
    paramAdapterView.putLong("size", paramView.b);
    paramView = new Intent(this, LiteMpFileFileDetailActivity.class);
    paramView.putExtras(paramAdapterView);
    startActivity(paramView);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903518);
    setTitle(getResources().getString(2131558594));
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter = new MpfileTaskListAdapter(this, this.jdField_a_of_type_AndroidViewView$OnClickListener, this.b);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView = ((SlideDetectListView)findViewById(2131231199));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setAdapter(this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setOnSlideListener(new cz(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setTranscriptMode(0);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.dataline.mpfile.download_progress");
    paramBundle.addAction("com.dataline.mpfile.download_completed");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    ThreadManager.b(new da(this));
    return false;
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new dc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileDownloadActivity
 * JD-Core Version:    0.7.0.1
 */