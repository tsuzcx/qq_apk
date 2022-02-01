package com.tencent.mobileqq.nearby.gameroom;

import acfp;
import ajrx;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ardq;
import ared;
import aree;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import wja;
import xzp;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public xzp a;
  public aree b;
  public String bSn;
  XListView listView = null;
  public QQAppInterface mApp;
  public SessionInfo sessionInfo;
  public ArrayList<String> xZ;
  
  public GameQuickWordsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, xzp paramxzp)
  {
    this.mApp = paramQQAppInterface;
    this.sessionInfo = paramSessionInfo;
    this.bSn = paramSessionInfo.aTl;
    this.a = paramxzp;
    this.b = ((ardq)paramQQAppInterface.getBusinessHandler(107)).a(this.bSn);
    paramQQAppInterface = this.b.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.ed();
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0)) {
        break label131;
      }
      this.xZ = paramQQAppInterface;
    }
    for (;;)
    {
      this.listView = ((XListView)findViewById(2131367876));
      this.listView.setOnItemClickListener(new ajrx(this));
      paramQQAppInterface = new a();
      this.listView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.xZ = new ArrayList();
      this.xZ.add(acfp.m(2131706752));
      this.xZ.add(acfp.m(2131706753));
      this.xZ.add(acfp.m(2131706756));
      this.xZ.add(acfp.m(2131706755));
      this.xZ.add(acfp.m(2131706754));
    }
  }
  
  public void notifyDataSetChanged()
  {
    ((a)this.listView.getAdapter()).notifyDataSetChanged();
  }
  
  class a
    extends BaseAdapter
  {
    protected int ST = -1;
    
    a() {}
    
    public int getCount()
    {
      return GameQuickWordsPanel.this.xZ.size();
    }
    
    public Object getItem(int paramInt)
    {
      return GameQuickWordsPanel.this.xZ.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(GameQuickWordsPanel.this.getContext()).inflate(2131558658, null);
        localView.setLayoutParams(new AbsListView.LayoutParams(-1, wja.dp2px(46.0F, GameQuickWordsPanel.this.getResources())));
        paramView = new a();
        paramView.UX = ((TextView)localView.findViewById(2131375397));
        localView.setTag(paramView);
      }
      for (;;)
      {
        Object localObject = (String)getItem(paramInt);
        paramView.UX.setText((CharSequence)localObject);
        paramView.UX.setTextColor(this.ST);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
    
    public void notifyDataSetChanged()
    {
      HashMap localHashMap = GameQuickWordsPanel.this.a.A();
      if (localHashMap.containsKey("quickWordColor")) {
        this.ST = ((Integer)localHashMap.get("quickWordColor")).intValue();
      }
      super.notifyDataSetChanged();
    }
    
    class a
    {
      TextView UX;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */