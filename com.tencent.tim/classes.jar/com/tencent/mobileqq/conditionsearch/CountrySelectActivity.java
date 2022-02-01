package com.tencent.mobileqq.conditionsearch;

import accv;
import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.data.BaseAddress;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class CountrySelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.a
{
  static final boolean bTE = AppSetting.enableTalkBack;
  private static final String[] ck = { "#", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
  LinkedHashMap<String, Integer> N;
  a a;
  boolean bTF = true;
  String bwI;
  IndexView jdField_c_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  List<Object> jl;
  
  public void O(String paramString)
  {
    Integer localInteger = (Integer)this.N.get(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("CountrySelectActivity", 2, "onIndexChanged | c = " + paramString + " | i = " + localInteger);
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(localInteger.intValue());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559744);
    this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131365476));
    this.jdField_c_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131369141));
    setTitle(acfp.m(2131704512));
    Object localObject1 = ((accv)this.app.getManager(59)).dP();
    this.N = new LinkedHashMap();
    this.jl = new ArrayList(((List)localObject1).size() + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
    this.bwI = getIntent().getStringExtra("key_country_code");
    if (TextUtils.isEmpty(this.bwI)) {
      this.bwI = "0";
    }
    this.bTF = getIntent().getBooleanExtra("key_no_limit_allow", false);
    Object localObject2;
    Object localObject3;
    int i;
    if (this.bTF)
    {
      paramBundle = getLayoutInflater().inflate(2131559746, null);
      localObject2 = new c(null);
      ((TextView)paramBundle.findViewById(2131365475)).setText("不限");
      localObject3 = paramBundle.findViewById(2131364583);
      if (this.bwI.equals("0"))
      {
        i = 0;
        ((View)localObject3).setVisibility(i);
        paramBundle.findViewById(2131365474).setVisibility(8);
        ((c)localObject2).code = "0";
        paramBundle.setTag(localObject2);
        paramBundle.setOnClickListener(this);
        if (bTE) {
          paramBundle.setContentDescription("不限");
        }
        this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(paramBundle);
      }
    }
    else
    {
      paramBundle = getLayoutInflater().inflate(2131559746, null);
      localObject2 = new c(null);
      ((TextView)paramBundle.findViewById(2131365475)).setText("中国");
      localObject3 = paramBundle.findViewById(2131364583);
      if (!this.bwI.equals("1")) {
        break label551;
      }
      i = 0;
      label327:
      ((View)localObject3).setVisibility(i);
      paramBundle.findViewById(2131365474).setVisibility(8);
      ((c)localObject2).code = "1";
      paramBundle.setTag(localObject2);
      paramBundle.setOnClickListener(this);
      if (bTE) {
        paramBundle.setContentDescription("中国");
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(paramBundle);
      this.N.put("#", Integer.valueOf(0));
      paramBundle = "#";
      localObject2 = ((List)localObject1).iterator();
      i = 0;
    }
    int j;
    for (;;)
    {
      j = i;
      if (!((Iterator)localObject2).hasNext()) {
        break label635;
      }
      localObject3 = (BaseAddress)((Iterator)localObject2).next();
      if ((!((BaseAddress)localObject3).code.equals("0")) && (!((BaseAddress)localObject3).code.equals("1")))
      {
        j = i;
        localObject1 = paramBundle;
        if (!((BaseAddress)localObject3).pinyinFirst.equals(paramBundle))
        {
          localObject1 = ((BaseAddress)localObject3).pinyinFirst;
          j = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf((String)localObject1);
          for (;;)
          {
            if (i <= j)
            {
              this.N.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(i, i + 1), Integer.valueOf(this.jl.size() + this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
              i += 1;
              continue;
              i = 8;
              break;
              label551:
              i = 8;
              break label327;
            }
          }
          this.N.put(localObject1, Integer.valueOf(this.jl.size() + this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
          paramBundle = new b(null);
          paramBundle.bwJ = ((String)localObject1);
          this.jl.add(paramBundle);
          j = i;
        }
        this.jl.add(localObject3);
        i = j;
        paramBundle = (Bundle)localObject1;
      }
    }
    label635:
    while (j < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())
    {
      this.N.put("ABCDEFGHIJKLMNOPQRSTUVWXYZ".substring(j, j + 1), Integer.valueOf(this.jl.size() + this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()));
      j += 1;
    }
    this.a = new a(null);
    this.jdField_c_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.a);
    this.jdField_c_of_type_ComTencentMobileqqWidgetIndexView.setIndex(ck, false);
    this.jdField_c_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof c))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_country_code", ((c)localObject).code);
      setResult(-1, localIntent);
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  class a
    extends PinnedDividerListView.a
  {
    private a() {}
    
    public int ag()
    {
      return 2131559745;
    }
    
    public void b(View paramView, int paramInt)
    {
      paramView = (TextView)paramView;
      Object localObject = getItem(paramInt);
      if ((localObject instanceof CountrySelectActivity.b)) {
        paramView.setText(((CountrySelectActivity.b)localObject).bwJ);
      }
      while (!(localObject instanceof BaseAddress)) {
        return;
      }
      paramView.setText(((BaseAddress)localObject).pinyinFirst);
    }
    
    public int getCount()
    {
      return CountrySelectActivity.this.jl.size();
    }
    
    public Object getItem(int paramInt)
    {
      return CountrySelectActivity.this.jl.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if ((CountrySelectActivity.this.jl.get(paramInt) instanceof CountrySelectActivity.b)) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (getItemViewType(paramInt) == 0)
      {
        if (paramView != null) {
          break label308;
        }
        paramView = CountrySelectActivity.this.getLayoutInflater().inflate(ag(), null);
      }
      label292:
      label302:
      label308:
      for (;;)
      {
        ((TextView)paramView).setText(((CountrySelectActivity.b)getItem(paramInt)).bwJ);
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          View localView = paramView;
          if (paramView == null)
          {
            localView = CountrySelectActivity.this.getLayoutInflater().inflate(2131559746, null);
            paramView = new CountrySelectActivity.c(null);
            paramView.nameTv = ((TextView)localView.findViewById(2131365475));
            paramView.vz = ((ImageView)localView.findViewById(2131364583));
            localView.findViewById(2131365474).setVisibility(8);
            localView.setTag(paramView);
            localView.setOnClickListener(CountrySelectActivity.this);
          }
          paramView = (CountrySelectActivity.c)localView.getTag();
          BaseAddress localBaseAddress = (BaseAddress)getItem(paramInt);
          paramView.nameTv.setText(localBaseAddress.name);
          if ((!TextUtils.isEmpty(CountrySelectActivity.this.bwI)) && (CountrySelectActivity.this.bwI.equals(localBaseAddress.code))) {
            paramView.vz.setVisibility(0);
          }
          for (;;)
          {
            paramView.code = localBaseAddress.code;
            if (!CountrySelectActivity.bTE) {
              break label302;
            }
            if (paramView.vz.getVisibility() != 0) {
              break label292;
            }
            localView.setContentDescription(localBaseAddress.name + acfp.m(2131704511));
            paramView = localView;
            break;
            paramView.vz.setVisibility(8);
          }
          localView.setContentDescription(localBaseAddress.name);
          paramView = localView;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean t(int paramInt)
    {
      return getItemViewType(paramInt) == 0;
    }
  }
  
  static class b
  {
    public String bwJ;
  }
  
  static class c
  {
    public String code;
    public TextView nameTv;
    public ImageView vz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.CountrySelectActivity
 * JD-Core Version:    0.7.0.1
 */