package com.tencent.mobileqq.troop.homework.entry.ui;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import aphd;
import aphe;
import aphf;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class HomeWorkTroopSelectorFragment
  extends IphoneTitleBarFragment
  implements Runnable
{
  private List<String> HO;
  private a a;
  private ListView b;
  private TroopInfo l;
  private QQAppInterface mApp;
  private boolean mRunning;
  private String mTroopUin = "";
  
  public static void a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:my_troop_uin", paramString);
    }
    if (paramArrayList != null) {
      localIntent.putExtra("HomeWorkTroopSelectorFragment:select_troop_uin", paramArrayList);
    }
    PublicFragmentActivity.startForResult(paramActivity, localIntent, HomeWorkTroopSelectorFragment.class, 263);
  }
  
  private void mO(List<TroopInfo> paramList)
  {
    if (this.b != null)
    {
      this.a = new a(getActivity(), paramList, this.l, this.HO);
      this.b.setAdapter(this.a);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = ((ListView)this.mContentView.findViewById(2131368590));
    this.b.setDivider(null);
    this.b.setDividerHeight(0);
    if (getActivity() == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = (QQAppInterface)getActivity().getAppInterface())
    {
      this.mApp = paramLayoutInflater;
      if (this.mApp != null) {
        break;
      }
      getActivity().finish();
      return;
    }
    this.mRunning = true;
    setRightButton(2131699663, new aphd(this));
    setTitle(acfp.m(2131707166));
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.mTroopUin = paramLayoutInflater.getString("HomeWorkTroopSelectorFragment:my_troop_uin");
      if (this.mTroopUin == null) {
        this.mTroopUin = "";
      }
      this.HO = paramLayoutInflater.getStringArrayList("HomeWorkTroopSelectorFragment:select_troop_uin");
      if (this.HO == null) {
        this.HO = new ArrayList();
      }
    }
    ThreadManager.postImmediately(this, null, true);
  }
  
  public int getContentLayoutId()
  {
    return 2131560824;
  }
  
  public boolean onBackEvent()
  {
    this.mRunning = false;
    return super.onBackEvent();
  }
  
  public void run()
  {
    if (this.mApp == null) {}
    TroopManager localTroopManager;
    Object localObject1;
    do
    {
      do
      {
        do
        {
          return;
          localTroopManager = (TroopManager)this.mApp.getManager(52);
        } while (localTroopManager == null);
        localObject1 = this.mApp.a(-2);
      } while (localObject1 == null);
      localObject1 = (String[])((HashMap)localObject1).get(Integer.valueOf(-2));
      if (this.mTroopUin == null) {
        this.mTroopUin = "";
      }
      if (!TextUtils.isEmpty(this.mTroopUin)) {
        this.l = localTroopManager.b(this.mTroopUin);
      }
    } while (localObject1 == null);
    LinkedList localLinkedList = new LinkedList();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!this.mTroopUin.equals(localObject2)))
      {
        localObject2 = localTroopManager.b((String)localObject2);
        if ((localObject2 != null) && (((((TroopInfo)localObject2).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject2).dwCmdUinUinFlag & 1L) == 1L))) {
          localLinkedList.add(localObject2);
        }
      }
      i += 1;
    }
    ThreadManager.getUIHandler().post(new HomeWorkTroopSelectorFragment.2(this, localLinkedList));
  }
  
  public static class a
    extends BaseAdapter
  {
    List<HomeWorkTroopSelectorFragment.b<TroopInfo, Boolean>> HQ;
    private String cpr;
    private Activity mActivity;
    
    a(Activity paramActivity, List<TroopInfo> paramList, TroopInfo paramTroopInfo, List<String> paramList1)
    {
      this.mActivity = paramActivity;
      this.HQ = new ArrayList();
      if (paramTroopInfo != null)
      {
        this.HQ.add(new HomeWorkTroopSelectorFragment.b(paramTroopInfo, Boolean.valueOf(true)));
        this.cpr = paramTroopInfo.troopuin;
        if (this.cpr == null) {
          this.cpr = "";
        }
      }
      if (paramList != null)
      {
        paramActivity = paramList.iterator();
        while (paramActivity.hasNext())
        {
          paramList = (TroopInfo)paramActivity.next();
          if (paramList != null)
          {
            if ((paramList1 != null) && (paramList1.contains(paramList.troopuin))) {}
            for (boolean bool = true;; bool = false)
            {
              this.HQ.add(new HomeWorkTroopSelectorFragment.b(paramList, Boolean.valueOf(bool)));
              break;
            }
          }
        }
      }
    }
    
    public int getCount()
    {
      return this.HQ.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.HQ.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      HomeWorkTroopSelectorFragment.b localb = (HomeWorkTroopSelectorFragment.b)getItem(paramInt);
      a locala;
      Object localObject1;
      if (paramView != null)
      {
        locala = (a)paramView.getTag();
        paramView.setOnClickListener(null);
        locala.checkBox.setOnCheckedChangeListener(null);
        locala.checkBox.setChecked(((Boolean)localb.second).booleanValue());
        localObject1 = locala.checkBox;
        if (((TroopInfo)localb.first).troopuin.equals(this.cpr)) {
          break label485;
        }
      }
      label485:
      for (boolean bool = true;; bool = false)
      {
        ((CheckBox)localObject1).setEnabled(bool);
        locala.checkBox.setOnCheckedChangeListener(new aphe(this, localb));
        paramView.setOnClickListener(new aphf(this, locala.checkBox));
        locala.textView.setText(((TroopInfo)localb.first).troopname);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        locala = new a();
        paramView = new LinearLayout(this.mActivity);
        paramView.setMinimumHeight(ankt.dip2px(48.0F));
        paramView.setOrientation(0);
        paramView.setGravity(16);
        locala.checkBox = new CheckBox(this.mActivity);
        locala.checkBox.setButtonDrawable(2130839257);
        localObject1 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject1).setMargins(ankt.dip2px(12.0F), 0, 0, 0);
        locala.checkBox.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = new LinearLayout(this.mActivity);
        Object localObject2 = new LinearLayout.LayoutParams(-1, -1);
        ((LinearLayout.LayoutParams)localObject2).setMargins(ankt.dip2px(12.0F), 0, ankt.dip2px(12.0F), 0);
        ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((LinearLayout)localObject1).setOrientation(1);
        locala.textView = new TextView(this.mActivity);
        locala.textView.setTextColor(-16777216);
        locala.textView.setTextSize(1, 16.0F);
        locala.textView.setGravity(16);
        localObject2 = new LinearLayout.LayoutParams(-1, 0);
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        locala.textView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = new View(this.mActivity);
        ((View)localObject2).setBackgroundDrawable(new ColorDrawable(Color.parseColor("#dedfe0")));
        ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
        ((LinearLayout)localObject1).addView(locala.textView);
        ((LinearLayout)localObject1).addView((View)localObject2);
        paramView.addView(locala.checkBox);
        paramView.addView((View)localObject1);
        paramView.setClickable(true);
        paramView.setTag(locala);
        break;
      }
    }
    
    static class a
    {
      CheckBox checkBox;
      TextView textView;
    }
  }
  
  public static class b<F, S>
  {
    public F first;
    public S second;
    
    b(F paramF, S paramS)
    {
      this.first = paramF;
      this.second = paramS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment
 * JD-Core Version:    0.7.0.1
 */