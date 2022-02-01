package com.tencent.mobileqq.friends.intimate;

import ahpi;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdj;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class CommonTroopListActivity
  extends IphoneTitleBarFragment
{
  private a a;
  private ListView b;
  private int bvC = -1;
  private View.OnClickListener fl = new ahpi(this);
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private ArrayList<IntimateInfo.CommonTroopInfo> wX;
  
  public static void c(Activity paramActivity, ArrayList<IntimateInfo.CommonTroopInfo> paramArrayList, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("common_troop_list", paramArrayList);
    localIntent.putExtra("report_friend_type", paramInt);
    PublicFragmentActivity.start(paramActivity, localIntent, CommonTroopListActivity.class);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = ((ListView)this.mContentView.findViewById(2131365097));
    if (this.mActivity != null)
    {
      setTitle(this.mActivity.getString(2131695049));
      this.bvC = this.mActivity.getIntent().getIntExtra("report_friend_type", -1);
      this.wX = this.mActivity.getIntent().getParcelableArrayListExtra("common_troop_list");
      this.a = new a(null);
      this.a.setData(this.wX);
      this.b.setAdapter(this.a);
      this.mApp = this.mActivity.app;
    }
    anot.a(null, "dc00898", "", "", "0X8009F53", "0X8009F53", this.bvC, 0, "", "", "", "");
  }
  
  public int getContentLayoutId()
  {
    return 2131559443;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = getActivity();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.mActivity = null;
  }
  
  class a
    extends BaseAdapter
  {
    private List<IntimateInfo.CommonTroopInfo> commonTroopInfoList;
    
    private a() {}
    
    public IntimateInfo.CommonTroopInfo a(int paramInt)
    {
      return (IntimateInfo.CommonTroopInfo)this.commonTroopInfoList.get(paramInt);
    }
    
    public int getCount()
    {
      if (this.commonTroopInfoList == null) {
        return 0;
      }
      return this.commonTroopInfoList.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        paramView = LayoutInflater.from(CommonTroopListActivity.a(CommonTroopListActivity.this)).inflate(2131559442, null);
      }
      for (;;)
      {
        IntimateInfo.CommonTroopInfo localCommonTroopInfo = a(paramInt);
        ImageView localImageView = (ImageView)paramView.findViewById(2131365095);
        TextView localTextView = (TextView)paramView.findViewById(2131365098);
        localImageView.setImageDrawable(aqdj.a(CommonTroopListActivity.a(CommonTroopListActivity.this), 4, localCommonTroopInfo.troopCode));
        localTextView.setText(localCommonTroopInfo.troopName);
        paramView.setTag(localCommonTroopInfo);
        paramView.setOnClickListener(CommonTroopListActivity.a(CommonTroopListActivity.this));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
    
    public void setData(List<IntimateInfo.CommonTroopInfo> paramList)
    {
      this.commonTroopInfoList = paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.CommonTroopListActivity
 * JD-Core Version:    0.7.0.1
 */