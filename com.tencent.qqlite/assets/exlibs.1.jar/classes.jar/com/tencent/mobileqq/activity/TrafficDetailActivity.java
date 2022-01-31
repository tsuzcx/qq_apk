package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.servlet.ReportServlet;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class TrafficDetailActivity
  extends IphoneTitleBarActivity
  implements BusinessObserver
{
  ListView jdField_a_of_type_AndroidWidgetListView;
  SimpleAdapter jdField_a_of_type_AndroidWidgetSimpleAdapter;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  String[] b = { "param_Flow", "param_WIFIFlow", "param_WIFIChatFlow", "param_WIFIPicFlow", "param_WIFIVoiceFlow", "param_WIFIVideoFlow", "param_WIFIFileFlow", "param_WIFIQZoneFlow", "param_WIFIOtherFlow", "param_XGFlow", "param_XGChatFlow", "param_XGPicFlow", "param_XGVoiceFlow", "param_XGVideoFlow", "param_XGFileFlow", "param_XGQZoneFlow", "param_XGOtherFlow", "param_WIFIMSFFlow", "param_XGMSFFlow", "param_XGC2CPicUploadFlow", "param_XGC2CPicDownloadFlow", "param_XGGroupPicUploadFlow", "param_XGGroupPicDownloadFlow", "param_WIFIC2CPicUploadFlow", "param_WIFIC2CPicDownloadFlow", "param_WIFIGroupPicUploadFlow", "param_WIFIGroupPicDownloadFlow", "param_XGCardPicUploadFlow", "param_XGCardPicDownloadFlow", "param_XGNearbyPicUploadFlow", "param_XGNearbyPicDownloadFlow", "param_XGAvatarPicDownloadFlow", "param_WIFICardPicUploadFlow", "param_WIFICardPicDownloadFlow", "param_WIFINearbyPicUploadFlow", "param_WIFINearbyPicDownloadFlow", "param_WIFIAvatarPicDownloadFlow", "param_XGThemeDownloadFlow", "param_WIFIThemeDownloadFlow", "param_XGEmojiStoreDownloadFlow", "param_WIFIEmojiStoreDownloadFlow" };
  
  public void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong2 == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(TrafficDetailActivity.class.getSimpleName(), 2, "null 1");
      }
    }
    do
    {
      return;
      if ((paramArrayOfLong1.length == paramArrayOfLong2.length) && (this.jdField_a_of_type_ArrayOfJavaLangString.length == paramArrayOfLong1.length)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(TrafficDetailActivity.class.getSimpleName(), 2, "not equal");
    return;
    this.jdField_a_of_type_JavaUtilList.clear();
    HashMap localHashMap = new HashMap();
    localHashMap.put("name", "流量名称");
    localHashMap.put("dayTraffic", "日流量");
    localHashMap.put("monthTraffic", "月流量");
    this.jdField_a_of_type_JavaUtilList.add(localHashMap);
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      if ((paramArrayOfLong1[i] == 0L) && (paramArrayOfLong2[i] == 0L)) {}
      for (;;)
      {
        i += 1;
        break;
        localHashMap = new HashMap();
        localHashMap.put("name", this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localHashMap.put("dayTraffic", FileUtils.a(0, paramArrayOfLong1[i]));
        localHashMap.put("monthTraffic", FileUtils.a(1, paramArrayOfLong2[i]));
        this.jdField_a_of_type_JavaUtilList.add(localHashMap);
      }
    }
    this.jdField_a_of_type_AndroidWidgetSimpleAdapter.notifyDataSetChanged();
  }
  
  public void c()
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApplication(), ReportServlet.class);
    localNewIntent.putExtra("sendType", 3);
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[this.b.length * 2];
      int i = 0;
      while (i < this.b.length)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString[(i * 2)] = this.b[i];
        this.jdField_a_of_type_ArrayOfJavaLangString[(i * 2 + 1)] = (this.b[i] + "_bg");
        i += 1;
      }
    }
    localNewIntent.putExtra("tags", this.jdField_a_of_type_ArrayOfJavaLangString);
    this.app.startServlet(localNewIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903169);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131297000));
    setTitle(2131363048);
    c();
    this.app.registObserver(this);
    this.jdField_a_of_type_AndroidWidgetSimpleAdapter = new SimpleAdapter(this, this.jdField_a_of_type_JavaUtilList, 2130903676, new String[] { "name", "dayTraffic", "monthTraffic" }, new int[] { 2131298892, 2131298893, 2131298894 });
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_AndroidWidgetSimpleAdapter);
  }
  
  protected void onDestroy()
  {
    this.app.unRegistObserver(this);
    super.onDestroy();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (3 == paramInt)
    {
      if (paramBoolean) {
        a(paramBundle.getLongArray("__base_tag_curentDay"), paramBundle.getLongArray("__base_tag_curentMonth"));
      }
    }
    else {
      return;
    }
    Toast.makeText(this, getString(2131363383), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TrafficDetailActivity
 * JD-Core Version:    0.7.0.1
 */