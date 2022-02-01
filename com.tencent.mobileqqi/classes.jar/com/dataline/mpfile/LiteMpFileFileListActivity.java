package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.HttpUpload;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import dh;
import di;
import dj;
import dk;
import dl;
import dn;
import do;
import dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiteMpFileFileListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, AdapterView.OnItemClickListener, Observer
{
  public static int a = 0;
  public static ArrayList a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  public static final int j = 8;
  public static final int k = 101;
  private long jdField_a_of_type_Long = 0L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dk(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MpfileFileListAdapter jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter;
  public HttpUpload a;
  public String a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private long jdField_b_of_type_Long = 0L;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "http://%s:%d/qqmpfile/?action=fileList&offset=%d&limit=%d&fileId=%s";
  private long jdField_c_of_type_Long = 0L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private int l = 0;
  private int m;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LiteMpFileFileListActivity()
  {
    this.jdField_m_of_type_Int = 40;
    this.jdField_a_of_type_ComDatalineUtilHttpUpload = new HttpUpload();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int += 1;
    MpfileFileListDownloader.a(jdField_a_of_type_Int, paramString, new dl(this));
  }
  
  private void b(String paramString)
  {
    int n;
    Object localObject;
    int i1;
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("result"))
      {
        n = paramString.getInt("result");
        if (n != 0) {
          break label436;
        }
        if (!paramString.has("items")) {
          break label423;
        }
        localObject = (JSONArray)paramString.get("items");
        if (localObject == null) {
          break label298;
        }
        i1 = ((JSONArray)localObject).length();
        n = 0;
        if (n < i1)
        {
          JSONObject localJSONObject = (JSONObject)((JSONArray)localObject).get(n);
          MpfileItemInfo localMpfileItemInfo = new MpfileItemInfo();
          localMpfileItemInfo.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
          localMpfileItemInfo.jdField_b_of_type_JavaLangString = localJSONObject.getString("fileid");
          if (localJSONObject.has("size")) {}
          for (localMpfileItemInfo.jdField_a_of_type_Long = localJSONObject.getLong("size");; localMpfileItemInfo.jdField_a_of_type_Long = 0L)
          {
            localMpfileItemInfo.g = localJSONObject.getInt("type");
            localMpfileItemInfo.h = localJSONObject.getInt("group");
            localMpfileItemInfo.c = localJSONObject.getString("time");
            this.jdField_a_of_type_JavaUtilList.add(localMpfileItemInfo);
            n += 1;
            break;
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      runOnUiThread(new dp(this));
    }
    label298:
    label436:
    do
    {
      localObject = new MpfileDataReportInfo();
      ((MpfileDataReportInfo)localObject).jdField_b_of_type_Int = 0;
      ((MpfileDataReportInfo)localObject).jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.fileList.ordinal();
      ((MpfileDataReportInfo)localObject).jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
      ((MpfileDataReportInfo)localObject).jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
      ((MpfileDataReportInfo)localObject).d = MpfileDataCenter.E;
      ((MpfileDataReportInfo)localObject).jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      ((MpfileDataReportInfo)localObject).jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      ((MpfileDataReportInfo)localObject).jdField_c_of_type_Int = i1;
      MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MpfileDataReportInfo)localObject);
      if ((paramString.has("offset")) && (paramString.has("currentcount")) && (paramString.has("totalcount")))
      {
        n = paramString.getInt("offset");
        i1 = paramString.getInt("currentcount");
        int i2 = paramString.getInt("totalcount");
        if ((i1 > 0) && (n + i1 < i2))
        {
          this.l = (n + i1);
          a(String.format(this.jdField_b_of_type_JavaLangString, new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), Integer.valueOf(this.l), Integer.valueOf(this.jdField_m_of_type_Int), this.jdField_a_of_type_JavaLangString }));
        }
      }
      runOnUiThread(new dn(this));
      return;
      if (n == 2)
      {
        runOnUiThread(new do(this));
        return;
      }
    } while (n != 7);
    label423:
    paramString = new MpfileDataReportInfo();
    paramString.jdField_b_of_type_Int = 7;
    paramString.jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.fileList.ordinal();
    paramString.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    paramString.jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
    paramString.d = MpfileDataCenter.E;
    paramString.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    paramString.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
    MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    a(7);
  }
  
  public void a()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131558591));
    if (paramInt == MpfileDataCenter.q) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558584));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
      return;
      if (paramInt == MpfileDataCenter.r)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558586));
      }
      else if (paramInt == MpfileDataCenter.t)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558584));
      }
      else if (paramInt == MpfileDataCenter.s)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558582));
      }
      else if (paramInt == MpfileDataCenter.u)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558587));
      }
      else if (paramInt == MpfileDataCenter.v)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558588));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      else if (paramInt == MpfileDataCenter.w)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558598));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131558597));
      }
      else if (paramInt == 7)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558607));
      }
    }
  }
  
  public void b()
  {
    a();
    if (this.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter.a(new ArrayList(this.jdField_a_of_type_JavaUtilList));
      this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter.notifyDataSetChanged();
      return;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903519);
    paramBundle = getIntent().getExtras().getString("fileId");
    Object localObject = getIntent().getExtras().getString("name");
    h(2131558590);
    this.jdField_a_of_type_JavaLangString = paramBundle;
    if ((localObject == null) || (((String)localObject).length() != 0)) {
      setTitle((CharSequence)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232798));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232796));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232799));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232792));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231293));
      this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter = new MpfileFileListAdapter(this);
      this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131231198));
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction(MpFileConstant.d);
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      if ((paramBundle != null) && (paramBundle.length() != 0))
      {
        paramBundle = String.format(this.jdField_b_of_type_JavaLangString, new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), Integer.valueOf(this.l), Integer.valueOf(this.jdField_m_of_type_Int), this.jdField_a_of_type_JavaLangString });
        f_();
        a(paramBundle);
      }
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      this.p.setVisibility(0);
      this.p.setImageResource(2130838634);
      this.p.setContentDescription(getString(2131558594));
      this.p.setOnClickListener(new dh(this));
      b();
      f_();
      return false;
      setTitle(getResources().getString(2131558592));
    }
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void f_()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800421A", "0X800421A", 0, 0, "", "", "", "");
      f_();
      this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new dj(this), 3000L);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = new MpfileDataReportInfo();
    paramView.jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.fileList.ordinal();
    paramView.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    paramView.jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
    paramView.d = MpfileDataCenter.E;
    if (!NetworkUtil.e(this))
    {
      paramView.jdField_b_of_type_Int = MpfileDataCenter.z;
      MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      FMToastUtil.a(2131562488);
      return;
    }
    if (((RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a() == 0)
    {
      paramView.jdField_b_of_type_Int = MpfileDataCenter.s;
      MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
      FMToastUtil.a(2131558582);
      return;
    }
    paramAdapterView = (MpfileItemInfo)this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter.getItem(paramInt);
    if (paramAdapterView != null)
    {
      if ((paramAdapterView.jdField_b_of_type_JavaLangString == null) || (paramAdapterView.jdField_b_of_type_JavaLangString.equalsIgnoreCase("")))
      {
        paramView.jdField_b_of_type_Int = 253;
        MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        Toast.makeText(this, "fileId为空", 0).show();
        return;
      }
      if (paramAdapterView.g == 0)
      {
        paramView = new Bundle();
        paramView.putString("fileId", paramAdapterView.jdField_b_of_type_JavaLangString);
        paramView.putString("name", paramAdapterView.jdField_a_of_type_JavaLangString);
        paramAdapterView = new Intent(this, LiteMpFileFileListActivity.class);
        paramAdapterView.putExtras(paramView);
        startActivity(paramAdapterView);
        return;
      }
      paramView = new Bundle();
      paramView.putString("fileId", paramAdapterView.jdField_b_of_type_JavaLangString);
      paramView.putString("name", paramAdapterView.jdField_a_of_type_JavaLangString);
      paramView.putLong("size", paramAdapterView.jdField_a_of_type_Long);
      paramAdapterView = new Intent(this, LiteMpFileFileDetailActivity.class);
      paramAdapterView.putExtras(paramView);
      startActivity(paramAdapterView);
      return;
    }
    paramView.jdField_b_of_type_Int = 253;
    MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new di(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileFileListActivity
 * JD-Core Version:    0.7.0.1
 */