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
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cq;
import com.tencent.token.cs;
import com.tencent.token.eq;
import com.tencent.token.global.c;
import com.tencent.token.global.g;
import java.util.ArrayList;
import java.util.List;

public class EnvirChangeListviewActivity
  extends BaseActivity
{
  List<com.tencent.token.core.bean.b> envirDataList = new ArrayList();
  String[] envirHosts = { "http://test.aq.qq.com", "https://w.aq.qq.com", "http://exp.aq.qq.com", "http://gray.aq.qq.com" };
  String[] envirNames = { "测试环境", "正式环境", "201体验环境", "157灰度环境" };
  final long[] mHits = new long[2];
  private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      EnvirChangeListviewActivity.this.maAdapter.a(paramAnonymousInt);
      paramAnonymousAdapterView = (com.tencent.token.core.bean.b)EnvirChangeListviewActivity.this.envirDataList.get(paramAnonymousInt);
      Toast.makeText(EnvirChangeListviewActivity.this.getApplicationContext(), paramAnonymousAdapterView.b(), 0).show();
      c.a(paramAnonymousInt);
      paramAnonymousAdapterView = cb.c();
      paramAnonymousAdapterView.e();
      paramAnonymousAdapterView.d();
      eq.b();
      cb.c();
      paramAnonymousAdapterView = cq.a();
      bz.a().c();
      paramAnonymousAdapterView.b();
      paramAnonymousInt = c.a();
      paramAnonymousAdapterView = cq.a();
      if (paramAnonymousInt == 0) {
        cq.c = cq.d;
      }
      for (;;)
      {
        g.c("sessionId : " + cq.c);
        g.c("UserAgent.isInit():---" + paramAnonymousAdapterView.p());
        cc.b();
        com.tencent.token.core.push.b.b();
        AccountPageActivity.mNeedRefreshEval = true;
        cs.b();
        EnvirChangeListviewActivity.this.finish();
        return;
        if (1 == paramAnonymousInt) {
          cq.c = cq.e;
        } else if (2 == paramAnonymousInt) {
          cq.c = cq.f;
        } else if (3 == paramAnonymousInt) {
          cq.c = cq.g;
        }
      }
    }
  };
  private a maAdapter;
  
  private void initData()
  {
    int i = 0;
    if (i < this.envirNames.length)
    {
      com.tencent.token.core.bean.b localb = new com.tencent.token.core.bean.b();
      localb.a(this.envirNames[i]);
      localb.b(this.envirHosts[i]);
      if (this.envirHosts[i] == c.e()) {
        localb.a(true);
      }
      for (;;)
      {
        this.envirDataList.add(localb);
        i += 1;
        break;
        localb.a(false);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968642);
    paramBundle = (ListView)findViewById(2131558831);
    initData();
    this.maAdapter = new a(this, this.envirDataList);
    paramBundle.setAdapter(this.maAdapter);
    paramBundle.setOnItemClickListener(this.mItemClickListener);
  }
  
  class a
    extends BaseAdapter
  {
    private List<com.tencent.token.core.bean.b> b;
    private EnvirChangeListviewActivity c;
    private LayoutInflater d;
    
    public a(List<com.tencent.token.core.bean.b> paramList)
    {
      this.d = LayoutInflater.from(paramList);
      this.c = paramList;
      Object localObject;
      this.b = localObject;
    }
    
    public void a(int paramInt)
    {
      if (!((com.tencent.token.core.bean.b)this.b.get(paramInt)).c())
      {
        ((com.tencent.token.core.bean.b)this.b.get(paramInt)).a(true);
        int i = 0;
        while (i < this.b.size())
        {
          if (i != paramInt) {
            ((com.tencent.token.core.bean.b)this.b.get(i)).a(false);
          }
          i += 1;
        }
      }
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      if (this.b == null) {
        return 0;
      }
      return this.b.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.b.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = this.d.inflate(2130968641, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131558828);
      paramViewGroup = (TextView)localView.findViewById(2131558829);
      RadioButton localRadioButton = (RadioButton)localView.findViewById(2131558830);
      com.tencent.token.core.bean.b localb = (com.tencent.token.core.bean.b)getItem(paramInt);
      paramView.setText(localb.a());
      paramViewGroup.setText(localb.b());
      localRadioButton.setChecked(localb.c());
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EnvirChangeListviewActivity
 * JD-Core Version:    0.7.0.1
 */