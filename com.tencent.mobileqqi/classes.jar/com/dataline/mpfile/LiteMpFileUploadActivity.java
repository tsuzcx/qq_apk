package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import dr;
import ds;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LiteMpFileUploadActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  public static int a;
  public static String a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dr(this);
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MpfileTaskListAdapter jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  private void d() {}
  
  public void finish()
  {
    super.finish();
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903523);
    this.jdField_a_of_type_ComDatalineMpfileMpfileTaskListAdapter = new MpfileTaskListAdapter(this, null, null);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  protected void onStart()
  {
    super.onStart();
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new ds(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileUploadActivity
 * JD-Core Version:    0.7.0.1
 */