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
import com.tencent.token.ajs;
import com.tencent.token.st;
import com.tencent.token.sw;
import com.tencent.token.sz;
import com.tencent.token.tt;
import com.tencent.token.tv;
import com.tencent.token.xh;
import com.tencent.token.xr;
import com.tencent.token.xv;
import java.util.ArrayList;
import java.util.List;

public class EnvirChangeListviewActivity
  extends BaseActivity
{
  List<sz> envirDataList = new ArrayList();
  String[] envirHosts = { "http://test.aq.qq.com", "https://w.aq.qq.com", "http://exp.aq.qq.com", "http://gray.aq.qq.com" };
  String[] envirNames = { "测试环境", "正式环境", "201体验环境", "157灰度环境" };
  final long[] mHits = new long[2];
  private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = EnvirChangeListviewActivity.this.maAdapter;
      if (!((sz)paramAnonymousAdapterView.a.get(paramAnonymousInt)).c)
      {
        ((sz)paramAnonymousAdapterView.a.get(paramAnonymousInt)).c = true;
        int i = 0;
        while (i < paramAnonymousAdapterView.a.size())
        {
          if (i != paramAnonymousInt) {
            ((sz)paramAnonymousAdapterView.a.get(i)).c = false;
          }
          i += 1;
        }
      }
      paramAnonymousAdapterView.notifyDataSetChanged();
      paramAnonymousAdapterView = (sz)EnvirChangeListviewActivity.this.envirDataList.get(paramAnonymousInt);
      Toast.makeText(EnvirChangeListviewActivity.this.getApplicationContext(), paramAnonymousAdapterView.b, 0).show();
      xr.a(paramAnonymousInt);
      ajs.a();
      tt.a();
      st.a();
      tt.a().g();
      tt.b();
      xr.a();
      tt.a();
      Toast.makeText(EnvirChangeListviewActivity.this, "该功能已失效", 0).show();
      xv.c("UserAgent.isInit():---true");
      sw.b();
      xh.b();
      AccountPageActivity.mNeedRefreshEval = true;
      tv.b();
      EnvirChangeListviewActivity.this.finish();
    }
  };
  private a maAdapter;
  
  private void initData()
  {
    int i = 0;
    while (i < this.envirNames.length)
    {
      sz localsz = new sz();
      localsz.a = this.envirNames[i];
      String[] arrayOfString = this.envirHosts;
      localsz.b = arrayOfString[i];
      if (arrayOfString[i] == xr.e()) {
        localsz.c = true;
      } else {
        localsz.c = false;
      }
      this.envirDataList.add(localsz);
      i += 1;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296328);
    paramBundle = (ListView)findViewById(2131165476);
    initData();
    this.maAdapter = new a(this, this.envirDataList);
    paramBundle.setAdapter(this.maAdapter);
    paramBundle.setOnItemClickListener(this.mItemClickListener);
  }
  
  final class a
    extends BaseAdapter
  {
    List<sz> a;
    private EnvirChangeListviewActivity c;
    private LayoutInflater d;
    
    public a(List<sz> paramList)
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
        localView = this.d.inflate(2131296327, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131165478);
      paramViewGroup = (TextView)localView.findViewById(2131165477);
      RadioButton localRadioButton = (RadioButton)localView.findViewById(2131166009);
      sz localsz = (sz)getItem(paramInt);
      paramView.setText(localsz.a);
      paramViewGroup.setText(localsz.b);
      localRadioButton.setChecked(localsz.c);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EnvirChangeListviewActivity
 * JD-Core Version:    0.7.0.1
 */