package com.tencent.biz.qqstory.playvideo;

import acfp;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import qem;
import qfj;
import qfk;
import qfl;

public class MyVideoVisibleTroopPageView
  extends RelativeLayout
{
  public int Hy = -1;
  TroopManager b;
  Context mContext;
  public Dialog mDialog;
  public GestureDetector mGestureDetector = new GestureDetector(this.mContext, new qfl(this));
  
  public MyVideoVisibleTroopPageView(Dialog paramDialog, Context paramContext, List<TroopInfo> paramList, TroopManager paramTroopManager)
  {
    super(paramContext);
    this.mDialog = paramDialog;
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131562039, this, true);
    paramDialog = new qfj(this);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      XListView localXListView = (XListView)findViewById(2131370527);
      paramContext = new a(paramContext);
      this.b = paramTroopManager;
      paramContext.eo(paramList);
      localXListView.setAdapter(paramContext);
      localXListView.setVisibility(0);
      localXListView.setOnScrollListener(new qfk(this));
      localXListView.setOnTouchListener(paramDialog);
      return;
    }
    paramContext = (TextView)findViewById(2131382306);
    paramList = findViewById(2131377524);
    paramContext.setText(acfp.m(2131708627));
    paramContext.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(2130847282), null, null);
    paramList.setVisibility(0);
    paramList.setOnTouchListener(paramDialog);
  }
  
  public String mK()
  {
    return acfp.m(2131708626);
  }
  
  public class a
    extends BaseAdapter
  {
    List<TroopInfo> itemList = new ArrayList();
    Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public void eo(List<TroopInfo> paramList)
    {
      if (paramList != null)
      {
        this.itemList.clear();
        this.itemList.addAll(paramList);
        notifyDataSetChanged();
      }
    }
    
    public int getCount()
    {
      return this.itemList.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.itemList.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      TroopInfo localTroopInfo = (TroopInfo)this.itemList.get(paramInt);
      View localView;
      if (paramView == null)
      {
        paramView = new a();
        localView = LayoutInflater.from(this.mContext).inflate(2131562038, null);
        paramView.mD = ((ImageView)localView.findViewById(2131368427));
        paramView.nickname = ((TextView)localView.findViewById(2131372384));
        localView.setTag(paramView);
      }
      for (;;)
      {
        paramView.nickname.setText(localTroopInfo.getTroopName());
        Object localObject = qem.getQQAppInterface().l(localTroopInfo.troopuin);
        paramView.mD.setImageDrawable((Drawable)localObject);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
      }
    }
    
    class a
    {
      public ImageView mD;
      public TextView nickname;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisibleTroopPageView
 * JD-Core Version:    0.7.0.1
 */