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
import ch;
import ci;
import cj;
import ck;
import cl;
import cn;
import co;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.HttpUpload;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import cp;
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ck(this);
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
  private String jdField_b_of_type_JavaLangString = "http://%s:%d/qqmpfile/?action=fileList&offset=%d&limit=%d&fileId=%s";
  private long jdField_c_of_type_Long = 0L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private int l = 0;
  private int m = 40;
  
  static
  {
    jdField_a_of_type_Int = 100;
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LiteMpFileFileListActivity()
  {
    this.jdField_a_of_type_ComDatalineUtilHttpUpload = new HttpUpload();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(String paramString)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_Int += 1;
    MpfileFileListDownloader.a(jdField_a_of_type_Int, paramString, new cl(this));
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
          break label431;
        }
        if (!paramString.has("items")) {
          break label418;
        }
        localObject = (JSONArray)paramString.get("items");
        if (localObject == null) {
          break label293;
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
      runOnUiThread(new cp(this));
    }
    label293:
    label431:
    do
    {
      localObject = new MpfileDataReportInfo();
      ((MpfileDataReportInfo)localObject).jdField_b_of_type_Int = 0;
      ((MpfileDataReportInfo)localObject).jdField_a_of_type_Int = 0;
      ((MpfileDataReportInfo)localObject).jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
      ((MpfileDataReportInfo)localObject).jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
      ((MpfileDataReportInfo)localObject).d = MpfileDataCenter.E;
      ((MpfileDataReportInfo)localObject).jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      ((MpfileDataReportInfo)localObject).jdField_c_of_type_Long = this.jdField_c_of_type_Long;
      ((MpfileDataReportInfo)localObject).jdField_c_of_type_Int = i1;
      MpFileDataReportCenter.a(this.app, (MpfileDataReportInfo)localObject);
      if ((paramString.has("offset")) && (paramString.has("currentcount")) && (paramString.has("totalcount")))
      {
        n = paramString.getInt("offset");
        i1 = paramString.getInt("currentcount");
        int i2 = paramString.getInt("totalcount");
        if ((i1 > 0) && (n + i1 < i2))
        {
          this.l = (n + i1);
          a(String.format(this.jdField_b_of_type_JavaLangString, new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), Integer.valueOf(this.l), Integer.valueOf(this.m), this.jdField_a_of_type_JavaLangString }));
        }
      }
      runOnUiThread(new cn(this));
      return;
      if (n == 2)
      {
        runOnUiThread(new co(this));
        return;
      }
    } while (n != 7);
    label418:
    paramString = new MpfileDataReportInfo();
    paramString.jdField_b_of_type_Int = 7;
    paramString.jdField_a_of_type_Int = 0;
    paramString.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    paramString.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
    paramString.d = MpfileDataCenter.E;
    paramString.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
    paramString.jdField_c_of_type_Long = this.jdField_c_of_type_Long;
    MpFileDataReportCenter.a(this.app, paramString);
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
    this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131361918));
    if (paramInt == MpfileDataCenter.q) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361911));
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361913));
      }
      else if (paramInt == MpfileDataCenter.t)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361911));
      }
      else if (paramInt == MpfileDataCenter.s)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361909));
      }
      else if (paramInt == MpfileDataCenter.u)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361914));
      }
      else if (paramInt == MpfileDataCenter.v)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361915));
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      }
      else if (paramInt == MpfileDataCenter.w)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361924));
        this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131361923));
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131361933));
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
  
  public void c()
  {
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetListView.setVisibility(8);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903457);
    paramBundle = getIntent().getExtras().getString("fileId");
    Object localObject = getIntent().getExtras().getString("name");
    setLeftViewName(2131361917);
    this.jdField_a_of_type_JavaLangString = paramBundle;
    if ((localObject == null) || (((String)localObject).length() != 0)) {
      setTitle((CharSequence)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298125));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298123));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131298126));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298119));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296764));
      this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter = new MpfileFileListAdapter(this);
      this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_AndroidWidgetListView = ((ListView)findViewById(2131296662));
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter);
      this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(this);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction(MpFileConstant.jdField_d_of_type_JavaLangString);
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      if ((paramBundle != null) && (paramBundle.length() != 0))
      {
        paramBundle = String.format(this.jdField_b_of_type_JavaLangString, new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), Integer.valueOf(this.l), Integer.valueOf(this.m), this.jdField_a_of_type_JavaLangString });
        c();
        a(paramBundle);
      }
      this.j.setVisibility(8);
      this.p.setVisibility(0);
      this.p.setImageResource(2130838604);
      this.p.setContentDescription(getString(2131361921));
      this.p.setOnClickListener(new ch(this));
      b();
      c();
      return false;
      setTitle(getResources().getString(2131361919));
    }
  }
  
  protected void doOnDestroy()
  {
    if (this.app.a() != null) {
      this.app.a().e();
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      ReportController.b(this.app, "CliOper", "", "", "0X800421A", "0X800421A", 0, 0, "", "", "", "");
      c();
      this.jdField_a_of_type_AndroidWidgetButton.postDelayed(new cj(this), 3000L);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new MpfileDataReportInfo();
    paramAdapterView.jdField_a_of_type_Int = 0;
    paramAdapterView.jdField_a_of_type_JavaLangString = MpfileDataCenter.k;
    paramAdapterView.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
    paramAdapterView.d = MpfileDataCenter.E;
    if (!NetworkUtil.e(this))
    {
      paramAdapterView.jdField_b_of_type_Int = MpfileDataCenter.z;
      MpFileDataReportCenter.a(this.app, paramAdapterView);
      FMToastUtil.a(2131363449);
      return;
    }
    if (((RegisterProxySvcPackHandler)this.app.a(9)).a() == 0)
    {
      paramAdapterView.jdField_b_of_type_Int = MpfileDataCenter.s;
      MpFileDataReportCenter.a(this.app, paramAdapterView);
      FMToastUtil.a(2131361909);
      return;
    }
    paramView = (MpfileItemInfo)this.jdField_a_of_type_ComDatalineMpfileMpfileFileListAdapter.getItem(paramInt);
    if (paramView != null)
    {
      if ((paramView.jdField_b_of_type_JavaLangString == null) || (paramView.jdField_b_of_type_JavaLangString.equalsIgnoreCase("")))
      {
        paramAdapterView.jdField_b_of_type_Int = 253;
        MpFileDataReportCenter.a(this.app, paramAdapterView);
        Toast.makeText(this, "fileId为空", 0).show();
        return;
      }
      if (paramView.g == 0)
      {
        paramAdapterView = new Bundle();
        paramAdapterView.putString("fileId", paramView.jdField_b_of_type_JavaLangString);
        paramAdapterView.putString("name", paramView.jdField_a_of_type_JavaLangString);
        paramView = new Intent(this, LiteMpFileFileListActivity.class);
        paramView.putExtras(paramAdapterView);
        startActivity(paramView);
        return;
      }
      paramAdapterView = ((DataLineHandler)this.app.a(8)).a().a(paramView.jdField_b_of_type_JavaLangString);
      if (paramAdapterView != null) {
        break label485;
      }
      paramAdapterView = new MpfileTaskInfo();
      paramAdapterView.jdField_d_of_type_JavaLangString = paramView.jdField_a_of_type_JavaLangString;
      paramAdapterView.jdField_b_of_type_Long = paramView.jdField_a_of_type_Long;
      paramAdapterView.e = String.format("%s/%s", new Object[] { MpfileDataCenter.a(), paramView.jdField_a_of_type_JavaLangString });
      paramAdapterView.c = paramView.jdField_b_of_type_JavaLangString;
      paramAdapterView.g = MpfileTaskInfo.jdField_a_of_type_Int;
    }
    label485:
    for (;;)
    {
      paramView = FileManagerUtil.a(paramAdapterView);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.a(10009);
      localForwardFileInfo.c(7);
      localForwardFileInfo.b(paramView.nSessionId);
      localForwardFileInfo.d(paramAdapterView.jdField_d_of_type_JavaLangString);
      localForwardFileInfo.c(paramAdapterView.jdField_d_of_type_Long);
      localForwardFileInfo.d(paramAdapterView.jdField_b_of_type_Long);
      localForwardFileInfo.a(paramAdapterView.e);
      paramAdapterView = new Intent(getApplicationContext(), FileBrowserActivity.class);
      if ((paramView.nFileType == 0) || (paramView.nFileType == 1))
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(paramView.nSessionId));
        paramAdapterView.putStringArrayListExtra("Aio_SessionId_ImageList", localArrayList);
      }
      paramAdapterView.putExtra("fileinfo", localForwardFileInfo);
      startActivity(paramAdapterView);
      return;
      paramAdapterView.jdField_b_of_type_Int = 253;
      MpFileDataReportCenter.a(this.app, paramAdapterView);
      return;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    runOnUiThread(new ci(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.LiteMpFileFileListActivity
 * JD-Core Version:    0.7.0.1
 */