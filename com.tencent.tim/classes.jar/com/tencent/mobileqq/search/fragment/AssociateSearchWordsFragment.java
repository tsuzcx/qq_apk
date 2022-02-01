package com.tencent.mobileqq.search.fragment;

import amkf;
import ammo;
import ammp;
import ammq;
import ammr;
import amxk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;

public class AssociateSearchWordsFragment
  extends ReportV4Fragment
{
  private List<AssociateItem> FK;
  XListView T;
  private a a;
  protected boolean cDw;
  public View.OnTouchListener f = new ammp(this);
  View.OnClickListener fK = new ammo(this);
  boolean isViewCreated = false;
  public String wz;
  
  public void PP(String paramString)
  {
    this.wz = paramString;
  }
  
  public void Pr(boolean paramBoolean)
  {
    this.cDw = paramBoolean;
  }
  
  public void md(List<AssociateItem> paramList)
  {
    if (!this.isViewCreated)
    {
      this.FK = paramList;
      return;
    }
    me(paramList);
  }
  
  public void me(List<AssociateItem> paramList)
  {
    if (this.T.getAdapter() == null)
    {
      b localb = new b(paramList);
      this.T.setAdapter(localb);
      localb.updateList(paramList);
    }
    for (;;)
    {
      paramList = getActivity();
      if ((paramList instanceof amkf)) {
        amxk.b("sub_result", "exp_auto", new String[] { ((amkf)paramList).vo(), "", "", "" });
      }
      return;
      ((b)this.T.getAdapter()).updateList(paramList);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559999, null);
    this.T = ((XListView)paramLayoutInflater.findViewById(2131377836));
    this.T.setDivider(null);
    this.T.setOnTouchListener(this.f);
    this.isViewCreated = true;
    if (this.FK != null)
    {
      me(this.FK);
      this.FK = null;
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.isViewCreated = false;
  }
  
  public static class AssociateItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AssociateItem> CREATOR = new ammq();
    public int businessType;
    public int dCS;
    public int index;
    public String jumpUrl;
    public String picUrl;
    public String subTitle;
    public String summary;
    public String title;
    public int type;
    
    public AssociateItem() {}
    
    public AssociateItem(Parcel paramParcel)
    {
      this.businessType = paramParcel.readInt();
      this.title = paramParcel.readString();
      this.subTitle = paramParcel.readString();
      this.jumpUrl = paramParcel.readString();
      this.picUrl = paramParcel.readString();
      this.type = paramParcel.readInt();
      this.dCS = paramParcel.readInt();
      this.summary = paramParcel.readString();
      this.index = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.businessType);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.subTitle);
      paramParcel.writeString(this.jumpUrl);
      paramParcel.writeString(this.picUrl);
      paramParcel.writeInt(this.type);
      paramParcel.writeInt(this.dCS);
      paramParcel.writeString(this.summary);
      paramParcel.writeInt(this.index);
    }
  }
  
  public static abstract interface a
  {
    public abstract void PM(String paramString);
    
    public abstract void fM(String paramString, int paramInt);
  }
  
  public class b
    extends BaseAdapter
  {
    private List<AssociateSearchWordsFragment.AssociateItem> FL = new ArrayList();
    
    public b()
    {
      Object localObject;
      this.FL = localObject;
    }
    
    public int getCount()
    {
      if (this.FL == null) {
        return 0;
      }
      return this.FL.size();
    }
    
    public Object getItem(int paramInt)
    {
      if (this.FL == null) {
        return null;
      }
      return (AssociateSearchWordsFragment.AssociateItem)this.FL.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      switch (((AssociateSearchWordsFragment.AssociateItem)this.FL.get(paramInt)).businessType)
      {
      default: 
        return 0;
      case 2: 
      case 4: 
      case 5: 
        return 3;
      case 3: 
        return 2;
      case 6: 
        return 5;
      case 0: 
        return 1;
      }
      return 4;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AssociateSearchWordsFragment.AssociateItem localAssociateItem = (AssociateSearchWordsFragment.AssociateItem)this.FL.get(paramInt);
      Object localObject2 = AssociateSearchWordsFragment.this.getActivity();
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      Object localObject1 = paramView;
      Object localObject3;
      if (paramView == null)
      {
        localObject3 = new AssociateSearchWordsFragment.c(AssociateSearchWordsFragment.this);
        localObject1 = new LinearLayout((Context)localObject2);
        ((LinearLayout)localObject1).setPadding(aqcx.dip2px((Context)localObject2, 12.0F), 0, aqcx.dip2px((Context)localObject2, 12.0F), 0);
        ((LinearLayout)localObject1).setOrientation(1);
      }
      switch (getItemViewType(paramInt))
      {
      default: 
        paramView.setTag(localObject3);
        paramView.setBackgroundResource(2130843180);
        localObject1 = paramView;
        paramView = (AssociateSearchWordsFragment.c)((View)localObject1).getTag();
        switch (getItemViewType(paramInt))
        {
        default: 
          label200:
          if (bool) {
            ((View)localObject1).setBackgroundResource(2130839634);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        ((View)localObject1).setTag(2131381961, Integer.valueOf(paramInt));
        ((View)localObject1).setTag(2131381960, localAssociateItem);
        paramView = (View)localObject1;
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localObject1;
          paramView = new TextView((Context)localObject2);
          paramView.setBackgroundColor(Color.parseColor("#F7F7F9"));
          paramView.setHeight(aqcx.dip2px((Context)localObject2, 10.0F));
          Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
          ((AssociateSearchWordsFragment.c)localObject3).YK = paramView;
          ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
          paramView = new TextView((Context)localObject2);
          paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167379));
          paramView.setTextSize(1, 15.0F);
          paramView.setGravity(16);
          paramView.setIncludeFontPadding(false);
          paramView.setHeight(((Context)localObject2).getResources().getDimensionPixelSize(2131298908));
          paramView.setPadding(aqcx.dip2px((Context)localObject2, 12.0F), 0, aqcx.dip2px((Context)localObject2, 12.0F), 0);
          ((LinearLayout)localObject1).addView(paramView, new LinearLayout.LayoutParams(-1, -2));
          ((LinearLayout)localObject1).setClickable(false);
          ((LinearLayout)localObject1).setFocusable(false);
          ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
          ((AssociateSearchWordsFragment.c)localObject3).titleView = paramView;
          paramView = (View)localObject1;
          break;
          paramView = new TextView((Context)localObject2);
          paramView.setGravity(19);
          paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167304));
          label479:
          Object localObject5;
          if (getItemViewType(paramInt) == 5)
          {
            paramView.setTextSize(1, 16.0F);
            paramView.setSingleLine();
            paramView.setEllipsize(TextUtils.TruncateAt.END);
            paramView.setIncludeFontPadding(false);
            if (getItemViewType(paramInt) != 5) {
              break label787;
            }
            localObject4 = new LinearLayout((Context)localObject2);
            ((LinearLayout)localObject4).setOrientation(0);
            ((LinearLayout)localObject1).addView((View)localObject4, new LinearLayout.LayoutParams(-1, aqcx.dip2px((Context)localObject2, 52.0F)));
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
              break label756;
            }
            localObject5 = ((Context)localObject2).getResources().getDrawable(2130851340);
            ((Drawable)localObject5).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131167220), PorterDuff.Mode.SRC_ATOP);
            paramView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject5, null, null, null);
            label598:
            paramView.setCompoundDrawablePadding(aqcx.dip2px((Context)localObject2, 8.0F));
            localObject5 = new LinearLayout.LayoutParams(-1, -1);
            ((LinearLayout.LayoutParams)localObject5).weight = 1.0F;
            ((LinearLayout)localObject4).addView(paramView, (ViewGroup.LayoutParams)localObject5);
            localObject5 = new ImageView((Context)localObject2);
            if (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, "")) {
              break label776;
            }
            ((ImageView)localObject5).setImageResource(2130851345);
            ((ImageView)localObject5).setColorFilter(BaseApplicationImpl.sApplication.getResources().getColor(2131167220));
            label685:
            ((LinearLayout)localObject4).addView((View)localObject5, new LinearLayout.LayoutParams(-2, -1));
            ((ImageView)localObject5).setOnClickListener(new ammr(this, localAssociateItem.title, paramInt));
          }
          for (;;)
          {
            ((AssociateSearchWordsFragment.c)localObject3).titleView = paramView;
            ((View)localObject1).setOnClickListener(AssociateSearchWordsFragment.this.fK);
            paramView = (View)localObject1;
            break;
            paramView.setTextSize(1, 18.0F);
            break label479;
            label756:
            paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject2).getResources().getDrawable(2130851340), null, null, null);
            break label598;
            label776:
            ((ImageView)localObject5).setImageResource(2130851345);
            break label685;
            label787:
            paramView.setCompoundDrawablesWithIntrinsicBounds(((Context)localObject2).getResources().getDrawable(2130851339), null, null, null);
            paramView.setCompoundDrawablePadding(aqcx.dip2px((Context)localObject2, 4.0F));
            localObject4 = new LinearLayout.LayoutParams(-1, -2);
            ((LinearLayout.LayoutParams)localObject4).setMargins(0, aqcx.dip2px((Context)localObject2, 16.0F), 0, aqcx.dip2px((Context)localObject2, 16.0F));
            ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
          }
          paramView = new TextView((Context)localObject2);
          paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167304));
          paramView.setTextSize(1, 18.0F);
          paramView.setIncludeFontPadding(false);
          ((LinearLayout)localObject1).addView(paramView);
          ((AssociateSearchWordsFragment.c)localObject3).titleView = paramView;
          paramView = new TextView((Context)localObject2);
          paramView.setTextColor(((Context)localObject2).getResources().getColor(2131167379));
          paramView.setTextSize(1, 14.0F);
          paramView.setIncludeFontPadding(false);
          ((LinearLayout)localObject1).addView(paramView);
          ((AssociateSearchWordsFragment.c)localObject3).YJ = paramView;
          ((View)localObject1).setOnClickListener(AssociateSearchWordsFragment.this.fK);
          paramView = (View)localObject1;
          break;
          paramView = new TextView((Context)localObject2);
          paramView.setHeight(1);
          ((LinearLayout)localObject1).addView(paramView);
          ((LinearLayout)localObject1).setPadding(aqcx.dip2px((Context)localObject2, 12.0F), 0, 0, 0);
          ((AssociateSearchWordsFragment.c)localObject3).YK = paramView;
          ((LinearLayout)localObject1).setClickable(false);
          ((LinearLayout)localObject1).setFocusable(false);
          paramView = (View)localObject1;
          break;
          if (QLog.isColorLevel()) {
            QLog.e("Q.uniteSearch.AssociateSearchWordsFragment", 2, "SearchAssociatedWordAdapter.getView() itemType not support. value=" + getItemViewType(paramInt));
          }
          localObject1 = null;
        }
        if (paramInt == 0) {
          paramView.YK.setVisibility(8);
        }
        for (;;)
        {
          paramView.titleView.setText(localAssociateItem.title);
          break;
          paramView.YK.setVisibility(0);
          if (bool) {
            paramView.YK.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167233));
          } else {
            paramView.YK.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167232));
          }
        }
        if (AssociateSearchWordsFragment.this.cDw)
        {
          if (getItemViewType(paramInt) == 2)
          {
            localObject2 = amxk.a(paramView.titleView, 2.147484E+009F, 1, localAssociateItem.title, AssociateSearchWordsFragment.this.wz, false, false, true);
            paramView.titleView.setText((CharSequence)localObject2);
            break label200;
          }
          localObject2 = amxk.a(localAssociateItem.title, AssociateSearchWordsFragment.this.wz, false);
          paramView.titleView.setText((CharSequence)localObject2);
          break label200;
        }
        paramView.titleView.setText(localAssociateItem.title);
        break label200;
        paramView.titleView.setText(localAssociateItem.title);
        paramView.YJ.setText(localAssociateItem.summary);
        if (TextUtils.isEmpty(localAssociateItem.title))
        {
          paramView.titleView.setVisibility(8);
          ((LinearLayout.LayoutParams)paramView.YJ.getLayoutParams()).setMargins(0, aqcx.dip2px((Context)localObject2, 16.0F), 0, aqcx.dip2px((Context)localObject2, 16.0F));
          break label200;
        }
        paramView.titleView.setVisibility(0);
        localObject3 = (LinearLayout.LayoutParams)paramView.titleView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, aqcx.dip2px((Context)localObject2, 12.0F), 0, 0);
        paramView.titleView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = (LinearLayout.LayoutParams)paramView.YJ.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).setMargins(0, aqcx.dip2px((Context)localObject2, 5.0F), 0, aqcx.dip2px((Context)localObject2, 12.0F));
        paramView.YJ.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break label200;
        if (bool)
        {
          paramView.YK.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167233));
          break label200;
        }
        paramView.YK.setBackgroundColor(((Context)localObject2).getResources().getColor(2131167232));
        break label200;
        ((View)localObject1).setBackgroundResource(2130839633);
      }
    }
    
    public int getViewTypeCount()
    {
      return 6;
    }
    
    public void updateList(List<AssociateSearchWordsFragment.AssociateItem> paramList)
    {
      this.FL = paramList;
      super.notifyDataSetChanged();
    }
  }
  
  public class c
  {
    TextView YJ;
    TextView YK;
    TextView titleView;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment
 * JD-Core Version:    0.7.0.1
 */