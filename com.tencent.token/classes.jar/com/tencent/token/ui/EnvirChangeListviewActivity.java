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
import com.tencent.token.ahh;
import com.tencent.token.rz;
import com.tencent.token.sc;
import com.tencent.token.sf;
import com.tencent.token.sz;
import com.tencent.token.tb;
import com.tencent.token.wn;
import com.tencent.token.ww;
import com.tencent.token.xa;
import java.util.ArrayList;
import java.util.List;

public class EnvirChangeListviewActivity
  extends BaseActivity
{
  List<sf> envirDataList = new ArrayList();
  String[] envirHosts = { "http://test.aq.qq.com", "https://w.aq.qq.com", "http://exp.aq.qq.com", "http://gray.aq.qq.com" };
  String[] envirNames = { "测试环境", "正式环境", "201体验环境", "157灰度环境" };
  final long[] mHits = new long[2];
  private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = EnvirChangeListviewActivity.this.maAdapter;
      if (!((sf)paramAnonymousAdapterView.a.get(paramAnonymousInt)).c)
      {
        ((sf)paramAnonymousAdapterView.a.get(paramAnonymousInt)).c = true;
        int i = 0;
        while (i < paramAnonymousAdapterView.a.size())
        {
          if (i != paramAnonymousInt) {
            ((sf)paramAnonymousAdapterView.a.get(i)).c = false;
          }
          i += 1;
        }
      }
      paramAnonymousAdapterView.notifyDataSetChanged();
      paramAnonymousAdapterView = (sf)EnvirChangeListviewActivity.this.envirDataList.get(paramAnonymousInt);
      Toast.makeText(EnvirChangeListviewActivity.this.getApplicationContext(), paramAnonymousAdapterView.b, 0).show();
      ww.a(paramAnonymousInt);
      ahh.b();
      sz.a();
      rz.a();
      sz.a().g();
      sz.b();
      ww.a();
      sz.a();
      Toast.makeText(EnvirChangeListviewActivity.this, "该功能已失效", 0).show();
      xa.c("UserAgent.isInit():---true");
      sc.b();
      wn.b();
      AccountPageActivity.mNeedRefreshEval = true;
      tb.b();
      EnvirChangeListviewActivity.this.finish();
    }
  };
  private a maAdapter;
  
  private void initData()
  {
    int i = 0;
    while (i < this.envirNames.length)
    {
      sf localsf = new sf();
      localsf.a = this.envirNames[i];
      String[] arrayOfString = this.envirHosts;
      localsf.b = arrayOfString[i];
      if (arrayOfString[i] == ww.e()) {
        localsf.c = true;
      } else {
        localsf.c = false;
      }
      this.envirDataList.add(localsf);
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
    List<sf> a;
    private EnvirChangeListviewActivity c;
    private LayoutInflater d;
    
    public a(List<sf> paramList)
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
      sf localsf = (sf)getItem(paramInt);
      paramView.setText(localsf.a);
      paramViewGroup.setText(localsf.b);
      localRadioButton.setChecked(localsf.c);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EnvirChangeListviewActivity
 * JD-Core Version:    0.7.0.1
 */