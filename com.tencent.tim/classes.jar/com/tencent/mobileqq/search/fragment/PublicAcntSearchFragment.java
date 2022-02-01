package com.tencent.mobileqq.search.fragment;

import acfp;
import acja;
import acnm;
import acnn;
import amlt;
import ammb;
import amng;
import ampf;
import ampv;
import ampx;
import amqy;
import amwd;
import amwu;
import amxk;
import amxl;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import obt;

public class PublicAcntSearchFragment
  extends BaseSearchFragment
  implements AbsListView.e
{
  private static int fromType = -1;
  protected acnn a;
  private long ajP = -1L;
  public String caF = "";
  public boolean cj;
  public byte[] cookie;
  public boolean isEnd;
  protected int mScrollState;
  
  public PublicAcntSearchFragment()
  {
    this.jdField_a_of_type_Acnn = new amng(this);
  }
  
  public static PublicAcntSearchFragment a(int paramInt)
  {
    fromType = paramInt;
    return new PublicAcntSearchFragment();
  }
  
  protected boolean DS()
  {
    return false;
  }
  
  protected int IT()
  {
    return 50;
  }
  
  protected amlt a()
  {
    return new ammb(this.jdField_a_of_type_ComTencentWidgetListView, this.c, this, 0);
  }
  
  protected amwd a()
  {
    return new PublicAccountSearchEngine(this.d, fromType);
  }
  
  public void a(List paramList, amwu paramamwu)
  {
    if (paramamwu.oI(this.keyword)) {
      s(paramList, paramamwu.status);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PublicAcntSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramamwu.keyword, " keyword2:", this.keyword });
  }
  
  protected void mh(List paramList)
  {
    super.mh(paramList);
    this.YM.setVisibility(0);
    this.Hb.setVisibility(8);
    Jp(false);
    Jn(false);
  }
  
  protected void mn(List paramList)
  {
    this.cj = true;
    if (QLog.isColorLevel()) {
      QLog.i("PublicAcntSearchFragment", 2, "sendNetPublicAcntRequest ,keyword=" + this.keyword);
    }
    ThreadManager.getUIHandler().post(new PublicAcntSearchFragment.1(this));
    Object localObject1 = ((acja)this.d.getManager(56)).cx();
    ArrayList localArrayList = new ArrayList();
    if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("PublicAcntSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      paramList = (acnm)this.d.getBusinessHandler(111);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("isLoadMore", true);
      ((Bundle)localObject1).putInt("fromType", fromType);
      Object localObject2 = new ArrayList();
      ((List)localObject2).add(Long.valueOf(1003L));
      paramList.a(this.keyword, this.caF, 20, (List)localObject2, localArrayList, this.cookie, 0.0D, 0.0D, (Bundle)localObject1);
      return;
      if ((paramList != null) && (paramList.size() > 0))
      {
        int i = 0;
        while (i < paramList.size())
        {
          localObject2 = (ampv)paramList.get(i);
          if ((localObject2 instanceof amqy))
          {
            localObject2 = (amqy)localObject2;
            int j = 0;
            while (j < ((List)localObject1).size())
            {
              PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((List)localObject1).get(j);
              if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(((amqy)localObject2).e.uin))) {
                localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
              }
              j += 1;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d.addObserver(this.jdField_a_of_type_Acnn);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.caF = (System.currentTimeMillis() + "");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_Amwd instanceof PublicAccountSearchEngine)) {
      ((PublicAccountSearchEngine)this.jdField_a_of_type_Amwd).destroy();
    }
    this.cookie = null;
    this.d.removeObserver(this.jdField_a_of_type_Acnn);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Amwd.pause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Amwd.resume();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_Amlt == null) || (this.jdField_a_of_type_Amlt.getCount() == 0) || (this.mScrollState == 0)) {}
    while ((paramInt3 - paramInt1 - paramInt2 >= 10) || (this.cj) || (this.isEnd)) {
      return;
    }
    mn(this.rc);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
  }
  
  public void s(List paramList, int paramInt)
  {
    super.s(paramList, paramInt);
    String str;
    if ((amxk.lo(fromType)) && (!this.isReported))
    {
      this.isReported = true;
      str = "" + this.keyword;
      if (paramList != null) {
        break label146;
      }
    }
    label146:
    for (paramList = "0";; paramList = "" + paramList.size())
    {
      amxk.b("all_result", "exp_public_uin_page", new String[] { str, paramList });
      if ((this.rc == null) || (this.rc.isEmpty())) {
        break label201;
      }
      paramInt = 0;
      while (paramInt < this.rc.size())
      {
        amxl.a((ampx)this.rc.get(paramInt), this.rc.size(), paramInt);
        paramInt += 1;
      }
    }
    this.rc.add(0, new ampf(acfp.m(2131710203), "", ""));
    label201:
    this.cookie = null;
    if (!TextUtils.isEmpty(this.keyword))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PublicAcntSearchFragment", 2, "onFinish, search net result ,keyword = " + this.keyword);
      }
      mn(this.rc);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PublicAcntSearchFragment", 2, "keyword is empty ");
  }
  
  protected String vn()
  {
    if (fromType == 12) {
      return obt.a(this.d, BaseApplicationImpl.getContext());
    }
    return acfp.m(2131710226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.PublicAcntSearchFragment
 * JD-Core Version:    0.7.0.1
 */