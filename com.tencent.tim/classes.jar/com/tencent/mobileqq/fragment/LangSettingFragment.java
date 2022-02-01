package com.tencent.mobileqq.fragment;

import acha;
import ahnc;
import ahnd;
import ahne;
import ahnf;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import anot;
import aqcw;
import ausj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.List;

public class LangSettingFragment
  extends IphoneTitleBarFragment
{
  private static final List<Integer> Cb = Arrays.asList(new Integer[] { Integer.valueOf(2052), Integer.valueOf(1033) });
  private Dialog at;
  private ausj mActionSheet;
  private int mSelectedPosition;
  
  private void Pg(int paramInt)
  {
    if (this.mActionSheet == null) {
      this.mActionSheet = ausj.b(getActivity());
    }
    this.mActionSheet.setMainTitle(String.format(getResources().getString(2131695190), new Object[] { l(paramInt, true) }));
    this.mActionSheet.addButton(String.format(getResources().getString(2131695189), new Object[] { l(paramInt, true) }));
    this.mActionSheet.addCancelButton(getResources().getString(2131695188));
    this.mActionSheet.a(new ahnc(this, paramInt));
    this.mActionSheet.show();
  }
  
  private void Ph(int paramInt)
  {
    if ((this.at != null) && (this.at.isShowing()))
    {
      this.at.dismiss();
      this.at = null;
    }
    this.at = aqcw.a(getActivity(), 2131693958, 2131693956, 2131693955, 2131693957, new ahnd(this), new ahne(this, paramInt));
    if ((!getActivity().isFinishing()) && (this.at != null)) {
      this.at.show();
    }
  }
  
  private void Pi(int paramInt)
  {
    ThreadManagerV2.executeOnSubThread(new LangSettingFragment.5(this, paramInt, new LangSettingFragment.4(this)));
  }
  
  private void doN()
  {
    int j = acha.Ax();
    if (j == 0) {
      this.mSelectedPosition = 0;
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < Cb.size())
      {
        if (((Integer)Cb.get(i)).intValue() == j)
        {
          this.mSelectedPosition = i;
          return;
        }
        i += 1;
      }
    }
  }
  
  private String l(int paramInt, boolean paramBoolean)
  {
    int j = ((Integer)Cb.get(0)).intValue();
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < Cb.size()) {
        i = ((Integer)Cb.get(paramInt)).intValue();
      }
    }
    return acha.dz(i);
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    doN();
    setTitle(getResources().getString(2131719595));
    ((ListView)this.mContentView.findViewById(2131370127)).setAdapter(new a());
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramLayoutInflater != null) {
      anot.a(paramLayoutInflater, "dc00898", "", "", "0X800A611", "0X800A5A7", 0, 0, "", "", "", "");
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561676;
  }
  
  public class a
    extends BaseAdapter
  {
    public a() {}
    
    private View.OnClickListener d(int paramInt)
    {
      return new ahnf(this, paramInt);
    }
    
    private boolean jT(int paramInt)
    {
      if ((paramInt >= LangSettingFragment.access$000().size()) || (paramInt < 0)) {
        return false;
      }
      return ((Integer)LangSettingFragment.access$000().get(paramInt)).intValue() == 1033;
    }
    
    public int getCount()
    {
      return LangSettingFragment.access$000().size();
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
      FormSimpleItem localFormSimpleItem = new FormSimpleItem(LangSettingFragment.this.getActivity());
      if (paramInt == LangSettingFragment.a(LangSettingFragment.this)) {
        localFormSimpleItem.setRightIcon(LangSettingFragment.this.getResources().getDrawable(2130845617));
      }
      for (;;)
      {
        if (paramInt < LangSettingFragment.access$000().size()) {
          localFormSimpleItem.setLeftText(LangSettingFragment.a(LangSettingFragment.this, paramInt, false));
        }
        localFormSimpleItem.setTag(Integer.valueOf(paramInt));
        localFormSimpleItem.setOnClickListener(d(paramInt));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localFormSimpleItem;
        localFormSimpleItem.setRightIcon(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment
 * JD-Core Version:    0.7.0.1
 */