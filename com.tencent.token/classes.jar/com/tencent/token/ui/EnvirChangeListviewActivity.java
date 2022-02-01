package com.tencent.token.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.ahi;
import com.tencent.token.sa;
import com.tencent.token.sd;
import com.tencent.token.sg;
import com.tencent.token.ta;
import com.tencent.token.tc;
import com.tencent.token.wo;
import com.tencent.token.wx;
import com.tencent.token.xb;
import java.util.ArrayList;
import java.util.List;

public class EnvirChangeListviewActivity
  extends BaseActivity
{
  List<sg> envirDataList = new ArrayList();
  String[] envirHosts = { "http://test.aq.qq.com", "https://w.aq.qq.com", "http://exp.aq.qq.com", "http://gray.aq.qq.com" };
  String[] envirNames = { "测试环境", "正式环境", "201体验环境", "157灰度环境" };
  final long[] mHits = new long[2];
  private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = EnvirChangeListviewActivity.this.maAdapter;
      if (!((sg)paramAnonymousAdapterView.a.get(paramAnonymousInt)).c)
      {
        ((sg)paramAnonymousAdapterView.a.get(paramAnonymousInt)).c = true;
        int i = 0;
        while (i < paramAnonymousAdapterView.a.size())
        {
          if (i != paramAnonymousInt) {
            ((sg)paramAnonymousAdapterView.a.get(i)).c = false;
          }
          i += 1;
        }
      }
      paramAnonymousAdapterView.notifyDataSetChanged();
      paramAnonymousAdapterView = (sg)EnvirChangeListviewActivity.this.envirDataList.get(paramAnonymousInt);
      Toast.makeText(EnvirChangeListviewActivity.this.getApplicationContext(), paramAnonymousAdapterView.b, 0).show();
      wx.a(paramAnonymousInt);
      ahi.b();
      ta.a();
      sa.a();
      ta.a().g();
      ta.b();
      wx.a();
      ta.a();
      Toast.makeText(EnvirChangeListviewActivity.this, "该功能已失效", 0).show();
      xb.c("UserAgent.isInit():---true");
      sd.b();
      wo.b();
      AccountPageActivity.mNeedRefreshEval = true;
      tc.b();
      EnvirChangeListviewActivity.this.finish();
    }
  };
  private a maAdapter;
  
  private void initData()
  {
    int i = 0;
    while (i < this.envirNames.length)
    {
      sg localsg = new sg();
      localsg.a = this.envirNames[i];
      String[] arrayOfString = this.envirHosts;
      localsg.b = arrayOfString[i];
      if (arrayOfString[i] == wx.e()) {
        localsg.c = true;
      } else {
        localsg.c = false;
      }
      this.envirDataList.add(localsg);
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296323);
    paramBundle = (ListView)findViewById(2131165461);
    initData();
    this.maAdapter = new a(this, this.envirDataList);
    paramBundle.setAdapter(this.maAdapter);
    paramBundle.setOnItemClickListener(this.mItemClickListener);
  }
  
  final class a
    extends BaseAdapter
  {
    List<sg> a;
    private EnvirChangeListviewActivity c;
    private LayoutInflater d;
    
    public a(List<sg> paramList)
    {
      this.d = LayoutInflater.from(paramList);
      this.c = paramList;
      Object localObject;
      this.a = localObject;
    }
    
    public final int getCount()
    {
      List localList = this.a;
      if (localList == null) {
        return 0;
      }
      return localList.size();
    }
    
    public final Object getItem(int paramInt)
    {
      return this.a.get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = this.d.inflate(2131296322, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131165463);
      paramViewGroup = (TextView)localView.findViewById(2131165462);
      RadioButton localRadioButton = (RadioButton)localView.findViewById(2131165972);
      sg localsg = (sg)getItem(paramInt);
      paramView.setText(localsg.a);
      paramViewGroup.setText(localsg.b);
      localRadioButton.setChecked(localsg.c);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EnvirChangeListviewActivity
 * JD-Core Version:    0.7.0.1
 */