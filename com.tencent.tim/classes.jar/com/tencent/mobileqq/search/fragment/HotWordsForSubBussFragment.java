package com.tencent.mobileqq.search.fragment;

import acnk;
import acnl;
import acnm;
import acnn;
import amjm;
import amnb;
import amnc;
import amnd;
import amxk;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.model.BusinessGroupWord.a;
import com.tencent.mobileqq.search.model.BusinessGroupWord.b;
import com.tencent.mobileqq.search.model.BusinessGroupWord.c;
import com.tencent.mobileqq.search.view.HotWordForSubTipsContainer;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HotWordsForSubBussFragment
  extends ReportV4Fragment
{
  public static final String TAG = "unify_search" + HotWordsForSubBussFragment.class.getSimpleName();
  public static int expireTime = -1;
  protected View Hd;
  protected TextView YO;
  protected acnk a;
  protected acnl a;
  protected acnn a;
  protected HotWordForSubTipsContainer a;
  public long[] as;
  protected acnm b;
  ReadInJoySearchTipsContainer.a c = new amnd(this);
  protected QQAppInterface d;
  private int fromType;
  private boolean isNightMode;
  
  public HotWordsForSubBussFragment()
  {
    this.jdField_a_of_type_Acnl = new amnb(this);
    this.jdField_a_of_type_Acnn = new amnc(this);
  }
  
  private void biW()
  {
    boolean bool = false;
    long l2;
    long l1;
    if (this.b != null)
    {
      String str1 = BaseApplication.getContext().getSharedPreferences(acnm.bpQ, 0).getString(acnm.bpR, "");
      l2 = -1L;
      l1 = l2;
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        l1 = Long.parseLong(str1);
        l2 = System.currentTimeMillis();
        if ((expireTime == -1) || (l2 - l1 > expireTime * 1000)) {
          bool = true;
        }
        if (bool)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "requestData, send netWork request");
          }
          this.b.cNc();
        }
        ThreadManager.post(new HotWordsForSubBussFragment.1(this, bool), 5, null, true);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, "reqTimeStr number format error");
            l1 = l2;
          }
        }
      }
    }
    if (this.jdField_a_of_type_Acnk != null)
    {
      String str2 = BaseApplication.getContext().getSharedPreferences(acnk.bpQ, 0).getString(acnk.bpR, "");
      l2 = -1L;
      l1 = l2;
      if (!TextUtils.isEmpty(str2)) {}
      try
      {
        l1 = Long.parseLong(str2);
        l2 = System.currentTimeMillis();
        if ((expireTime == -1) || (l2 - l1 > expireTime * 1000))
        {
          bool = true;
          if (bool)
          {
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "UnifySearchHandler requestData, send netWork request");
            }
            this.jdField_a_of_type_Acnk.cNc();
          }
          ThreadManager.post(new HotWordsForSubBussFragment.2(this, bool), 5, null, true);
          return;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.i(TAG, 2, "UnifySearchHandler reqTimeStr number format error");
            l1 = l2;
            continue;
            bool = false;
          }
        }
      }
    }
    QLog.e(TAG, 2, "requestData HANDLE is null");
  }
  
  private void ml(List<BusinessGroupWord.c> paramList)
  {
    if (this.as == null) {
      return;
    }
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "update BusiHotWords results is null");
      }
      this.YO.setVisibility(8);
      return;
    }
    this.YO.setVisibility(0);
    if (this.isNightMode)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.c(paramList, 2130840693, getResources().getColor(2131167237), getResources().getColor(2131167236));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.c(paramList, 2130840690, getResources().getColor(2131165381), getResources().getColor(2131167235));
  }
  
  private void mm(List<BusinessGroupWord> paramList)
  {
    if (this.as == null) {}
    for (;;)
    {
      return;
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "updateBusiHotWords results is null");
        }
      }
      else
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (BusinessGroupWord)paramList.next();
          Object localObject2 = amxk.c(((BusinessGroupWord)localObject1).groupID.FS);
          if ((localObject2 != null) && (Arrays.equals((long[])localObject2, this.as)))
          {
            localObject2 = ((BusinessGroupWord)localObject1).clueWordItem;
            FragmentActivity localFragmentActivity = getActivity();
            if ((localFragmentActivity instanceof ActiveEntitySearchActivity)) {
              ((ActiveEntitySearchActivity)localFragmentActivity).PN(((BusinessGroupWord.a)localObject2).word);
            }
            localObject1 = ((BusinessGroupWord)localObject1).hotWordItemList;
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              this.YO.setVisibility(0);
              if (this.isNightMode) {
                this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.c((List)localObject1, 2130840693, getResources().getColor(2131167237), getResources().getColor(2131167236));
              } else {
                this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.c((List)localObject1, 2130840690, getResources().getColor(2131165381), getResources().getColor(2131167235));
              }
            }
          }
        }
      }
    }
  }
  
  protected void dOg()
  {
    if (this.fromType == 10)
    {
      this.b = ((acnm)this.d.getBusinessHandler(111));
      this.jdField_a_of_type_Acnk = null;
      this.d.addObserver(this.jdField_a_of_type_Acnn);
      return;
    }
    this.jdField_a_of_type_Acnk = ((acnk)this.d.getBusinessHandler(152));
    this.b = null;
    this.d.addObserver(this.jdField_a_of_type_Acnl);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.as = ((Bundle)localObject).getLongArray("group_masks");
      this.fromType = ((Bundle)localObject).getInt("fromType", -1);
    }
    localObject = getActivity();
    if ((localObject instanceof BaseActivity))
    {
      this.d = ((BaseActivity)localObject).app;
      dOg();
      biW();
      super.onCreate(paramBundle);
      return;
    }
    throw new IllegalStateException("Activity must be instance of BaseActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.Hd = paramLayoutInflater.inflate(2131561795, null);
    this.YO = ((TextView)this.Hd.findViewById(2131380758));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer = ((HotWordForSubTipsContainer)this.Hd.findViewById(2131379724));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewHotWordForSubTipsContainer.setOnTipsClickListener(this.c);
    this.isNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
    if (this.isNightMode)
    {
      this.YO.setTextColor(Color.parseColor("#44608A"));
      this.Hd.setBackgroundResource(2130839634);
    }
    for (;;)
    {
      ml((List)amjm.mQ.get(amjm.a(this.as)));
      paramLayoutInflater = this.Hd;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.YO.setTextColor(Color.parseColor("#999999"));
      this.Hd.setBackgroundResource(2130839633);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    removeObserver();
  }
  
  protected void removeObserver()
  {
    if (this.fromType == 10)
    {
      this.d.removeObserver(this.jdField_a_of_type_Acnn);
      return;
    }
    this.d.removeObserver(this.jdField_a_of_type_Acnl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment
 * JD-Core Version:    0.7.0.1
 */