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
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import dq;
import dr;
import ds;
import dt;
import du;
import dw;
import dx;
import dy;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LiteMpFileMainActivity
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dt(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MpfileMenuListAdapter jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter;
  public HttpUpload a;
  private String jdField_a_of_type_JavaLangString = "http://%s:%d/qqmpfile/?action=fileList&offset=%d&limit=%d";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private long jdField_b_of_type_Long = 0L;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private long c;
  private int l = 0;
  private int m;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LiteMpFileMainActivity()
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload = new HttpUpload();
    this.jdField_c_of_type_Long = 0L;
    this.jdField_m_of_type_Int = 40;
  }
  
  private void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(getResources().getString(2131558599)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004212", "0X8004212", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131558600)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004211", "0X8004211", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131558601)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004213", "0X8004213", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131558602)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004214", "0X8004214", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131558603)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004215", "0X8004215", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131558604)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004216", "0X8004216", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131558605)))
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004217", "0X8004217", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004218", "0X8004218", 0, 0, "", "", "", "");
  }
  
  private void b(String paramString)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int += 1;
    MpfileFileListDownloader.a(jdField_a_of_type_Int, paramString, new du(this));
  }
  
  private void c(String paramString)
  {
    for (;;)
    {
      int i2;
      int i3;
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        if (((JSONObject)localObject1).has("result"))
        {
          i2 = ((JSONObject)localObject1).getInt("result");
          paramString = new MpfileDataReportInfo();
          paramString.jdField_a_of_type_Int = MpFileDataReportCenter.MPFWorkType.connection.ordinal();
          paramString.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
          paramString.jdField_b_of_type_JavaLangString = DBNetworkUtil.a();
          paramString.d = MpfileDataCenter.E;
          paramString.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
          paramString.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
          if (i2 != 0) {
            break label444;
          }
          if (((JSONObject)localObject1).has("items"))
          {
            localObject1 = (JSONArray)((JSONObject)localObject1).get("items");
            if (localObject1 != null)
            {
              i3 = ((JSONArray)localObject1).length();
              int i1 = 0;
              if (i1 >= i3) {
                break label411;
              }
              localObject2 = (JSONObject)((JSONArray)localObject1).get(i1);
              MpfileItemInfo localMpfileItemInfo = new MpfileItemInfo();
              localMpfileItemInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("name");
              localMpfileItemInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject2).getString("fileid");
              localMpfileItemInfo.g = ((JSONObject)localObject2).getInt("type");
              localMpfileItemInfo.h = ((JSONObject)localObject2).getInt("group");
              if (this.jdField_a_of_type_JavaUtilList.size() == 0)
              {
                n = 1;
                if (n != 0)
                {
                  localObject2 = new MpfileItemInfo();
                  if (localMpfileItemInfo.h == MpfileItemInfo.jdField_b_of_type_Int)
                  {
                    ((MpfileItemInfo)localObject2).jdField_a_of_type_JavaLangString = getResources().getString(2131558579);
                    ((MpfileItemInfo)localObject2).h = MpfileItemInfo.jdField_a_of_type_Int;
                    this.jdField_a_of_type_JavaUtilList.add(localObject2);
                  }
                }
                else
                {
                  this.jdField_a_of_type_JavaUtilList.add(localMpfileItemInfo);
                  i1 += 1;
                }
              }
              else
              {
                n = this.jdField_a_of_type_JavaUtilList.size();
                localObject2 = (MpfileItemInfo)this.jdField_a_of_type_JavaUtilList.get(n - 1);
                if ((((MpfileItemInfo)localObject2).h == localMpfileItemInfo.h) || (((MpfileItemInfo)localObject2).h == MpfileItemInfo.jdField_a_of_type_Int)) {
                  break label506;
                }
                n = 1;
                continue;
              }
              if (localMpfileItemInfo.h != MpfileItemInfo.jdField_c_of_type_Int) {
                break label393;
              }
              ((MpfileItemInfo)localObject2).jdField_a_of_type_JavaLangString = getResources().getString(2131558580);
              continue;
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        runOnUiThread(new dy(this));
      }
      label393:
      ((MpfileItemInfo)localObject2).jdField_a_of_type_JavaLangString = getResources().getString(2131558581);
      continue;
      label411:
      runOnUiThread(new dw(this));
      paramString.jdField_b_of_type_Int = i2;
      paramString.jdField_c_of_type_Int = i3;
      MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      return;
      label444:
      if (i2 == 2)
      {
        runOnUiThread(new dx(this));
        return;
      }
      if (i2 == 7)
      {
        paramString.jdField_b_of_type_Int = 7;
        MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        a(7);
        return;
      }
      paramString.jdField_b_of_type_Int = i2;
      MpFileDataReportCenter.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      return;
      label506:
      int n = 0;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131558591));
    if (paramInt == MpfileDataCenter.q) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131558585));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
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
  
  public void a(boolean paramBoolean)
  {
    b();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    this.jdField_a_of_type_Long = localDataLineHandler.a().a(paramBoolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903523);
    this.jdField_m_of_type_Int = 40;
    this.l = 0;
    setTitle(2131558592);
    h(2131558590);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232799));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231294));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232793));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232797));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter = new MpfileMenuListAdapter(this);
    this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131231199));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction(MpFileConstant.d);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
    this.p.setVisibility(0);
    this.p.setImageResource(2130838634);
    this.p.setContentDescription(getString(2131558594));
    this.p.setOnClickListener(new dq(this));
    a(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131558597))) {
        break label98;
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004219", "0X8004219", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      b();
      this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new ds(this), 3000L);
      return;
      label98:
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800421A", "0X800421A", 0, 0, "", "", "", "");
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!NetworkUtil.e(this)) {
      FMToastUtil.a(2131562488);
    }
    do
    {
      return;
      if (((RegisterProxySvcPackHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a() == 0)
      {
        FMToastUtil.a(2131558582);
        return;
      }
      paramAdapterView = (MpfileItemInfo)this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter.getItem(paramInt);
    } while (paramAdapterView == null);
    if ((paramAdapterView.jdField_b_of_type_JavaLangString == null) || (paramAdapterView.jdField_b_of_type_JavaLangString.equalsIgnoreCase("")))
    {
      Toast.makeText(this, "fileId为空", 0).show();
      return;
    }
    if (paramAdapterView.g == 0)
    {
      paramView = new Bundle();
      paramView.putString("fileId", paramAdapterView.jdField_b_of_type_JavaLangString);
      paramView.putString("name", paramAdapterView.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent(this, LiteMpFileFileListActivity.class);
      localIntent.putExtras(paramView);
      startActivity(localIntent);
      a(paramAdapterView.jdField_a_of_type_JavaLangString);
      return;
    }
    paramView = new Bundle();
    paramView.putString("fileId", paramAdapterView.jdField_b_of_type_JavaLangString);
    paramView.putString("name", paramAdapterView.jdField_a_of_type_JavaLangString);
    paramView.putLong("size", paramAdapterView.jdField_a_of_type_Long);
    paramAdapterView = new Intent(this, LiteMpFileFileDetailActivity.class);
    paramAdapterView.putExtras(paramView);
    startActivity(paramAdapterView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new dr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileMainActivity
 * JD-Core Version:    0.7.0.1
 */