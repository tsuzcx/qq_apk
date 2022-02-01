package com.tencent.mobileqq.troop.activity;

import abeg.a;
import acfd;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import aosu;
import aosv;
import aqdj;
import aqgv;
import aqhu;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TroopAdminList
  extends IphoneTitleBarActivity
{
  protected List<Map<String, String>> Hi = new ArrayList();
  protected final String TAG = "TroopAdminList";
  protected FriendListHandler a;
  a a;
  public String aKI;
  protected String boa;
  acfd c = new aosu(this);
  protected LinearLayout dl;
  public View.OnClickListener fS = new aosv(this);
  protected String[] hv;
  public String mTroopUin;
  protected XListView n;
  
  protected boolean checkParams()
  {
    this.boa = getIntent().getStringExtra("uin");
    if (TextUtils.isEmpty(this.boa)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = getIntent().getStringArrayListExtra("troop_info_memo");
    } while ((localArrayList == null) || (localArrayList.size() < 1));
    this.hv = new String[localArrayList.size()];
    this.hv[0] = this.boa;
    int k = localArrayList.size();
    int i = 1;
    int j = 0;
    if (i < k)
    {
      if (((String)localArrayList.get(j)).equals(this.boa)) {}
      for (;;)
      {
        j += 1;
        break;
        this.hv[i] = ((String)localArrayList.get(j));
        i += 1;
      }
    }
    this.mTroopUin = getIntent().getStringExtra("troop_uin");
    this.aKI = getIntent().getStringExtra("troop_code");
    return true;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (checkParams())
    {
      initUI();
      initData();
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("TroopAdminList", 2, "onCreate, illegal param, troopuin = ");
      }
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.c);
    super.doOnDestroy();
  }
  
  protected void initData()
  {
    this.Hi = new ArrayList();
    ThreadManager.post(new TroopAdminList.2(this), 8, null, true);
  }
  
  protected void initUI()
  {
    View localView = View.inflate(this, 2131560752, null);
    this.n = ((XListView)localView.findViewById(2131365101));
    this.n.setVerticalScrollBarEnabled(false);
    this.n.setDivider(null);
    this.dl = new LinearLayout(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.dl.setLayoutParams(localLayoutParams);
    this.dl.setOrientation(1);
    setContentView(localView);
    setTitle(getString(2131695658));
  }
  
  public void refreshList()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new TroopAdminList.3(this), 8, null, true);
      return;
    }
    int j = this.Hi.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.Hi.get(i)).get("uin");
      ((Map)this.Hi.get(i)).put("nick", aqgv.A(this.app, str));
      i += 1;
    }
    runOnUiThread(new TroopAdminList.4(this));
  }
  
  public class a
    extends BaseAdapter
  {
    private LayoutInflater mInflater;
    
    public a(Context paramContext)
    {
      this.mInflater = LayoutInflater.from(paramContext);
    }
    
    public int getCount()
    {
      return TroopAdminList.this.Hi.size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        paramView = new TroopAdminList.b();
        localView = this.mInflater.inflate(2131560753, null);
        paramView.pQ = ((ImageView)localView.findViewById(2131369766));
        paramView.fe = ((TextView)localView.findViewById(2131372190));
        paramView.tvTitle = ((TextView)localView.findViewById(2131369154));
        localView.setTag(paramView);
        localView.setOnClickListener(TroopAdminList.this.fS);
        localObject = (Map)TroopAdminList.this.Hi.get(paramInt);
        String str = ((Map)localObject).get("uin").toString();
        paramView.uin = str;
        paramView.pQ.setBackgroundDrawable(aqhu.at());
        aqdj localaqdj = aqdj.a(TroopAdminList.this.app, ((Map)localObject).get("uin").toString(), (byte)1);
        if (localaqdj != null) {
          paramView.pQ.setBackgroundDrawable(localaqdj);
        }
        paramView.fe.setText(((Map)localObject).get("nick").toString());
        if (!TroopAdminList.this.boa.equals(str)) {
          break label249;
        }
        paramView.tvTitle.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (TroopAdminList.b)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label249:
        paramView.tvTitle.setVisibility(4);
      }
    }
  }
  
  public static class b
    extends abeg.a
  {
    public TextView fe;
    public TextView tvTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList
 * JD-Core Version:    0.7.0.1
 */