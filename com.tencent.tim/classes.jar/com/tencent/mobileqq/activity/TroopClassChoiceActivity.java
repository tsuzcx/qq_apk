package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import apyg;
import apyh;
import apyh.a;
import aroi;
import aryg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class TroopClassChoiceActivity
  extends IphoneTitleBarActivity
  implements AdapterView.c
{
  private b a;
  private String aQu;
  apyg b;
  private XListView listView;
  String mId;
  ArrayList<apyg> pF;
  
  private void initData()
  {
    Object localObject = getIntent();
    this.aQu = String.valueOf(((Intent)localObject).getStringExtra("troopGroupClassExt"));
    apyg localapyg = apyh.a(this).a();
    if ((localapyg != null) && (this.aQu.equals(localapyg.id)))
    {
      this.b = localapyg;
      this.mId = ((Intent)localObject).getStringExtra("id");
      if (!TextUtils.isEmpty(this.mId)) {
        break label113;
      }
      this.pF = apyh.a(this).dX();
    }
    for (;;)
    {
      aryg.fR(aroi.a().getContext());
      bLv();
      return;
      this.b = apyh.a(this).a(this, this.aQu);
      break;
      label113:
      this.pF = apyh.a(this).af(this.mId);
      if ((this.pF != null) && (this.pF.size() > 0))
      {
        localObject = (apyg)this.pF.get(0);
        if (((apyg)localObject).c != null) {
          setTitle(((apyg)localObject).c.name);
        }
      }
    }
  }
  
  private void initViews()
  {
    setContentBackgroundResource(2130838900);
    this.listView = ((XListView)findViewById(2131380188));
    this.listView.setOnItemClickListener(this);
    this.a = new b();
    this.listView.setAdapter(this.a);
  }
  
  public void bLv()
  {
    apyh.a(BaseApplicationImpl.getContext()).a(this.aQu, new a());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131563245);
    setTitle(2131721319);
    initData();
    initViews();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (apyg)this.pF.get(paramInt);
    if ((paramAdapterView.list != null) && (paramAdapterView.list.size() > 0) && (!paramAdapterView.id.equals("10015")) && (!paramAdapterView.id.equals("10017")))
    {
      paramView = new Intent(this, TroopClassChoiceActivity.class);
      paramView.putExtra("id", paramAdapterView.id);
      paramView.putExtra("troopGroupClassExt", this.aQu);
      startActivityForResult(paramView, 11);
      return;
    }
    apyh.a(this).b(paramAdapterView);
    paramView = new Intent();
    paramView.putExtra("id", paramAdapterView.id);
    setResult(-1, paramView);
    finish();
  }
  
  public class a
    implements apyh.a
  {
    protected a() {}
    
    public void onResult(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        TroopClassChoiceActivity.this.b = apyh.a(BaseApplicationImpl.getContext()).a(BaseApplicationImpl.getContext(), TroopClassChoiceActivity.a(TroopClassChoiceActivity.this));
        TroopClassChoiceActivity.this.runOnUiThread(new TroopClassChoiceActivity.GetClassChoiceCallBack.1(this));
        return;
      }
      QLog.e("IphoneTitleBarActivity", 1, "getClassChoiceFromServer failed!");
    }
  }
  
  class b
    extends BaseAdapter
  {
    b() {}
    
    public int getCount()
    {
      if (TroopClassChoiceActivity.this.pF != null) {
        return TroopClassChoiceActivity.this.pF.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {}
      for (View localView = TroopClassChoiceActivity.this.getLayoutInflater().inflate(2131563246, null);; localView = paramView)
      {
        TextView localTextView1 = (TextView)localView.findViewById(2131380242);
        TextView localTextView2 = (TextView)localView.findViewById(2131380241);
        ImageView localImageView = (ImageView)localView.findViewById(2131372656);
        apyg localapyg2 = (apyg)TroopClassChoiceActivity.this.pF.get(paramInt);
        int j = 0;
        Object localObject;
        if ((TroopClassChoiceActivity.this.b != null) && (localapyg2.level < TroopClassChoiceActivity.this.b.level))
        {
          localObject = TroopClassChoiceActivity.this.b;
          paramView = ((apyg)localObject).c;
          int i = j;
          if (paramView != null)
          {
            i = j;
            if (paramView.level >= localapyg2.level)
            {
              if (!localapyg2.id.equals(paramView.id)) {
                break label243;
              }
              i = 1;
            }
          }
          if (i != 0)
          {
            localTextView2.setVisibility(0);
            localTextView2.setText(((apyg)localObject).name);
            localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851795, 0);
            label190:
            localTextView1.setText(localapyg2.name);
            if ((localapyg2.list == null) || (localapyg2.list.size() <= 0)) {
              break label333;
            }
            localImageView.setVisibility(0);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
          return localView;
          label243:
          apyg localapyg1 = paramView.c;
          localObject = paramView;
          paramView = localapyg1;
          break;
          localTextView2.setVisibility(4);
          break label190;
          if ((TroopClassChoiceActivity.this.b != null) && (localapyg2.id.equals(TroopClassChoiceActivity.this.b.id)))
          {
            localTextView2.setVisibility(0);
            localTextView2.setText("");
            localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130851795, 0);
            break label190;
          }
          localTextView2.setVisibility(4);
          break label190;
          label333:
          localImageView.setVisibility(4);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopClassChoiceActivity
 * JD-Core Version:    0.7.0.1
 */