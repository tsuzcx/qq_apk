package com.dataline.mpfile;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
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
import co;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.HttpUpload;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import cp;
import cq;
import cr;
import cs;
import cu;
import cv;
import cw;
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new cr(this);
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
  private int m = 40;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LiteMpFileMainActivity()
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload = new HttpUpload();
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void a(String paramString)
  {
    if (paramString.equalsIgnoreCase(getResources().getString(2131361924)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004212", "0X8004212", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131361925)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004211", "0X8004211", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131361926)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004213", "0X8004213", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131361927)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004214", "0X8004214", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131361928)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004215", "0X8004215", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131361929)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004216", "0X8004216", 0, 0, "", "", "", "");
      return;
    }
    if (paramString.equalsIgnoreCase(getResources().getString(2131361930)))
    {
      ReportController.b(this.app, "CliOper", "", "", "0X8004217", "0X8004217", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X8004218", "0X8004218", 0, 0, "", "", "", "");
  }
  
  private void b(String paramString)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int += 1;
    MpfileFileListDownloader.a(jdField_a_of_type_Int, paramString, new cs(this));
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
          paramString.jdField_a_of_type_Int = 1;
          paramString.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
          paramString.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
          paramString.d = MpfileDataCenter.E;
          paramString.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
          paramString.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
          if (i2 != 0) {
            break label439;
          }
          if (((JSONObject)localObject1).has("items"))
          {
            localObject1 = (JSONArray)((JSONObject)localObject1).get("items");
            if (localObject1 != null)
            {
              i3 = ((JSONArray)localObject1).length();
              int i1 = 0;
              if (i1 >= i3) {
                break label406;
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
                    ((MpfileItemInfo)localObject2).jdField_a_of_type_JavaLangString = getResources().getString(2131361905);
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
                  break label501;
                }
                n = 1;
                continue;
              }
              if (localMpfileItemInfo.h != MpfileItemInfo.jdField_c_of_type_Int) {
                break label388;
              }
              ((MpfileItemInfo)localObject2).jdField_a_of_type_JavaLangString = getResources().getString(2131361906);
              continue;
            }
          }
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        runOnUiThread(new cw(this));
      }
      label388:
      ((MpfileItemInfo)localObject2).jdField_a_of_type_JavaLangString = getResources().getString(2131361907);
      continue;
      label406:
      runOnUiThread(new cu(this));
      paramString.jdField_b_of_type_Int = i2;
      paramString.jdField_c_of_type_Int = i3;
      MpFileDataReportCenter.a(this.app, paramString);
      return;
      label439:
      if (i2 == 2)
      {
        runOnUiThread(new cv(this));
        return;
      }
      if (i2 == 7)
      {
        paramString.jdField_b_of_type_Int = 7;
        MpFileDataReportCenter.a(this.app, paramString);
        a(7);
        return;
      }
      paramString.jdField_b_of_type_Int = i2;
      MpFileDataReportCenter.a(this.app, paramString);
      return;
      label501:
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
    this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131361917));
    if (paramInt == MpfileDataCenter.q) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361911));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
      return;
      if (paramInt == MpfileDataCenter.r)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361912));
      }
      else if (paramInt == MpfileDataCenter.t)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361910));
      }
      else if (paramInt == MpfileDataCenter.s)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361908));
      }
      else if (paramInt == MpfileDataCenter.u)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361913));
      }
      else if (paramInt == MpfileDataCenter.v)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361914));
      }
      else if (paramInt == MpfileDataCenter.w)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361923));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131361922));
      }
      else if (paramInt == 7)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361932));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b();
    DataLineHandler localDataLineHandler = (DataLineHandler)this.app.a(8);
    this.app.a().a();
    RegisterProxySvcPackHandler localRegisterProxySvcPackHandler = (RegisterProxySvcPackHandler)this.app.a(9);
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
    setContentView(2130903450);
    this.m = 40;
    this.l = 0;
    setTitle(2131361918);
    setLeftViewName(2131361916);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298084));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296760));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298085));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298082));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter = new MpfileMenuListAdapter(this);
    this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131296662));
    this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction(MpFileConstant.jdField_d_of_type_JavaLangString);
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.j.setVisibility(8);
    this.p.setVisibility(0);
    this.p.setImageResource(2130838581);
    this.p.setContentDescription(getString(2131361920));
    this.p.setOnClickListener(new co(this));
    a(true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.app.a() != null) {
      this.app.a().e();
    }
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
      if (!this.jdField_a_of_type_AndroidWidgetButton.getText().toString().equalsIgnoreCase(getResources().getString(2131361922))) {
        break label96;
      }
      ReportController.b(this.app, "CliOper", "", "", "0X8004219", "0X8004219", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      b();
      this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cq(this), 3000L);
      return;
      label96:
      ReportController.b(this.app, "CliOper", "", "", "0X800421A", "0X800421A", 0, 0, "", "", "", "");
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!NetworkUtil.e(this)) {
      FMToastUtil.a(2131363450);
    }
    do
    {
      return;
      if (((RegisterProxySvcPackHandler)this.app.a(9)).a() == 0)
      {
        FMToastUtil.a(2131361908);
        return;
      }
      paramView = (MpfileItemInfo)this.jdField_a_of_type_ComDatalineMpfileMpfileMenuListAdapter.getItem(paramInt);
    } while (paramView == null);
    if ((paramView.jdField_b_of_type_JavaLangString == null) || (paramView.jdField_b_of_type_JavaLangString.equalsIgnoreCase("")))
    {
      Toast.makeText(this, "fileId为空", 0).show();
      return;
    }
    Object localObject;
    if (paramView.g == 0)
    {
      paramAdapterView = new Bundle();
      paramAdapterView.putString("fileId", paramView.jdField_b_of_type_JavaLangString);
      paramAdapterView.putString("name", paramView.jdField_a_of_type_JavaLangString);
      localObject = new Intent(this, LiteMpFileFileListActivity.class);
      ((Intent)localObject).putExtras(paramAdapterView);
      startActivity((Intent)localObject);
      a(paramView.jdField_a_of_type_JavaLangString);
      return;
    }
    paramAdapterView = ((DataLineHandler)this.app.a(8)).a().a(paramView.jdField_b_of_type_JavaLangString);
    if (paramAdapterView == null)
    {
      paramAdapterView = new MpfileTaskInfo();
      paramAdapterView.jdField_d_of_type_JavaLangString = paramView.jdField_a_of_type_JavaLangString;
      paramAdapterView.jdField_b_of_type_Long = paramView.jdField_a_of_type_Long;
      paramAdapterView.e = String.format("%s/%s", new Object[] { MpfileDataCenter.a(), paramView.jdField_a_of_type_JavaLangString });
      paramAdapterView.c = paramView.jdField_b_of_type_JavaLangString;
      paramAdapterView.g = MpfileTaskInfo.jdField_a_of_type_Int;
    }
    for (;;)
    {
      paramView = FileManagerUtil.a(paramAdapterView);
      localObject = new ForwardFileInfo();
      ((ForwardFileInfo)localObject).a(10009);
      ((ForwardFileInfo)localObject).c(7);
      ((ForwardFileInfo)localObject).b(paramView.nSessionId);
      ((ForwardFileInfo)localObject).d(paramAdapterView.jdField_d_of_type_JavaLangString);
      ((ForwardFileInfo)localObject).c(paramAdapterView.jdField_d_of_type_Long);
      ((ForwardFileInfo)localObject).d(paramAdapterView.jdField_b_of_type_Long);
      ((ForwardFileInfo)localObject).a(paramAdapterView.e);
      paramAdapterView = new Intent(getApplicationContext(), FileBrowserActivity.class);
      if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(paramView.nSessionId));
        paramAdapterView.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      paramAdapterView.putExtra("fileinfo", (Parcelable)localObject);
      startActivity(paramAdapterView);
      return;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new cp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileMainActivity
 * JD-Core Version:    0.7.0.1
 */