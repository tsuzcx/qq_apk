package com.tencent.mobileqq.search.fragment;

import amjh;
import amjp;
import amjp.a;
import amju;
import amkd;
import amkn;
import amrb;
import amxh;
import amxk;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rpq;

public class SearchEntryFragment
  extends ReportV4Fragment
  implements amjp.a
{
  public static Map<Integer, Boolean> mW = new HashMap();
  private List<amjh> FO = new ArrayList();
  public String caV;
  private LinearLayout hZ;
  public QQAppInterface mApp;
  public int mFrom;
  public int mSource;
  
  private void dNY()
  {
    Iterator localIterator = this.FO.iterator();
    while (localIterator.hasNext())
    {
      amjh localamjh = (amjh)localIterator.next();
      if ((localamjh instanceof amju)) {
        ((amju)localamjh).dNY();
      }
    }
  }
  
  public static int dX(String paramString)
  {
    if ("kSearchMessageTab".equals(paramString)) {}
    do
    {
      return 1;
      if ("kSearchContactTab".equals(paramString)) {
        return 2;
      }
      if ("kSearchDynamicTab".equals(paramString)) {
        return 3;
      }
      if ("kSearchWebTitle".equals(paramString)) {
        return 3;
      }
    } while (!"kSearchReadInJoyTab".equals(paramString));
    return 10;
  }
  
  public static int jf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 21;
    }
    return 25;
  }
  
  public void Uv(int paramInt)
  {
    boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if ((isDetached()) || (getView() == null)) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SearchEntryFragment", 2, "onHistoryCount, isNightMode = " + bool + ", count = " + paramInt + ", mTabType = " + this.caV);
  }
  
  public void aB(List<amrb> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    if (getActivity() == null) {
      QLog.e("SearchEntryFragment", 1, "in refreshDataModels() getActivity() is null.");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "refreshDataModels,  mTabType = " + this.caV + ", result = " + paramList);
      }
      if ((getActivity() != null) && (this.hZ != null) && (!isDetached())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SearchEntryFragment", 2, "refreshDataModels,  fragment is in a invalid state");
    return;
    boolean bool2 = amxk.lp(this.mSource);
    if (bool2) {}
    for (boolean bool1 = amxh.lm(this.mSource);; bool1 = false)
    {
      Object localObject;
      if (paramList != null)
      {
        boolean bool3 = amkd.a(this.mApp, dX(this.caV), paramBoolean);
        if (bool3)
        {
          this.hZ.removeAllViews();
          localObject = this.FO.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((amjh)((Iterator)localObject).next()).onDestroyView();
          }
          this.FO.clear();
          if ((!"kSearchMessageTab".equals(this.caV)) && (!"kSearchContactTab".equals(this.caV)))
          {
            i = j;
            if (!"kSearchDynamicTab".equals(this.caV)) {}
          }
          else
          {
            this.FO.add(new amjp(dX(this.caV), this));
            this.hZ.addView(((amjh)this.FO.get(0)).a(getActivity(), this.mApp, null, null));
            ((amjh)this.FO.get(0)).initData();
            i = j;
          }
          if (i < paramList.size())
          {
            if ((((amrb)paramList.get(i)).dDB == 1) && (bool2) && (!bool1)) {
              if (QLog.isColorLevel()) {
                QLog.d("SearchEntryFragment", 2, "refreshDataModels net, ignore hotWord: " + this.mSource);
              }
            }
            for (;;)
            {
              i += 1;
              break;
              j = ((amrb)paramList.get(i)).dDB;
              if (((!"kSearchMessageTab".equals(this.caV)) && (!"kSearchContactTab".equals(this.caV))) || (j != 3))
              {
                localObject = amjh.a(j, dX(this.caV), paramBoolean);
                if (localObject != null)
                {
                  this.hZ.addView(((amjh)localObject).a(getActivity(), this.mApp, null, null));
                  this.FO.add(localObject);
                  ((amjh)localObject).a((amrb)paramList.get(i));
                }
              }
            }
          }
          if ("kSearchReadInJoyTab".equals(this.caV))
          {
            this.FO.add(new amkn(dX(this.caV)));
            this.hZ.addView(((amjh)this.FO.get(this.FO.size() - 1)).a(getActivity(), this.mApp, null, null));
            ((amjh)this.FO.get(this.FO.size() - 1)).initData();
          }
          paramList = new View(getActivity());
          paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, rpq.dip2px(getActivity(), 80.0F)));
          this.hZ.addView(paramList);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("SearchEntryFragment", 2, "refreshDataModels,  mModelList.size = " + this.caV + this.FO.size() + ", needRefreshModelList = " + bool3);
          return;
          paramList = this.FO.iterator();
          while (paramList.hasNext()) {
            ((amjh)paramList.next()).initData();
          }
        }
      }
      this.hZ.removeAllViews();
      paramList = this.FO.iterator();
      while (paramList.hasNext()) {
        ((amjh)paramList.next()).onDestroyView();
      }
      this.FO.clear();
      if (("kSearchMessageTab".equals(this.caV)) || ("kSearchContactTab".equals(this.caV)) || ("kSearchDynamicTab".equals(this.caV)))
      {
        this.FO.add(new amjp(dX(this.caV), this));
        this.hZ.addView(((amjh)this.FO.get(0)).a(getActivity(), this.mApp, null, null));
        ((amjh)this.FO.get(0)).initData();
      }
      paramList = amkd.a(this.mApp, dX(this.caV), paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryFragment", 2, "refreshDataModels modelIdList = " + paramList);
      }
      if ((paramList != null) && (paramList.length > 0)) {
        if (i < paramList.length)
        {
          if ((paramList[i] == 1) && (bool2) && (!bool1)) {
            if (QLog.isColorLevel()) {
              QLog.d("SearchEntryFragment", 2, "refreshDataModels local, ignore hotWord: " + this.mSource);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            j = paramList[i];
            if (((!"kSearchMessageTab".equals(this.caV)) && (!"kSearchContactTab".equals(this.caV))) || (j != 3))
            {
              localObject = amjh.a(j, dX(this.caV), paramBoolean);
              if (localObject != null)
              {
                this.hZ.addView(((amjh)localObject).a(getActivity(), this.mApp, null, null));
                this.FO.add(localObject);
                ((amjh)localObject).initData();
              }
            }
          }
        }
      }
      if ("kSearchReadInJoyTab".equals(this.caV))
      {
        this.FO.add(new amkn(dX(this.caV)));
        this.hZ.addView(((amjh)this.FO.get(this.FO.size() - 1)).a(getActivity(), this.mApp, null, null));
        ((amjh)this.FO.get(this.FO.size() - 1)).initData();
      }
      paramList = new View(getActivity());
      paramList.setLayoutParams(new LinearLayout.LayoutParams(-1, rpq.dip2px(getActivity(), 80.0F)));
      this.hZ.addView(paramList);
      return;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    dNY();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = getActivity().getAppRuntime();
    if ((paramLayoutInflater instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramLayoutInflater);
    }
    this.hZ = new LinearLayout(getActivity());
    this.hZ.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    this.hZ.setOrientation(1);
    mW.clear();
    aB(null, UniteSearchActivity.bi(this.mSource, this.mFrom));
    paramLayoutInflater = new ScrollView(getActivity());
    paramLayoutInflater.setOverScrollMode(0);
    paramLayoutInflater.setVerticalScrollBarEnabled(false);
    paramLayoutInflater.addView(this.hZ);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    AbstractGifImage.pauseAll();
    dNY();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    Iterator localIterator = this.FO.iterator();
    while (localIterator.hasNext()) {
      ((amjh)localIterator.next()).onDestroyView();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
    dNY();
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
    if (!this.FO.isEmpty())
    {
      int i = 0;
      while (i < this.FO.size())
      {
        if ((this.FO.get(i) instanceof amkn)) {
          refresh();
        }
        i += 1;
      }
    }
  }
  
  public void refresh()
  {
    Iterator localIterator = this.FO.iterator();
    while (localIterator.hasNext()) {
      ((amjh)localIterator.next()).refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.SearchEntryFragment
 * JD-Core Version:    0.7.0.1
 */