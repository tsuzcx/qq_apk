package com.tencent.mobileqq.nearby.profilecard.moment;

import acfp;
import akih;
import akii;
import akij;
import akik;
import akil;
import akim;
import akin;
import akio;
import akio.c;
import akjb;
import akjg;
import akjj;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aoop;
import aqgz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rpq;

public class NearbyMomentFragment
  extends ReportV4Fragment
  implements View.OnClickListener
{
  private List<akjj> DR = new ArrayList();
  private List<akjj> DS = new ArrayList();
  private TextView Wg;
  private akio.c jdField_a_of_type_Akio$c = new akii(this);
  private akjb jdField_a_of_type_Akjb;
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private a jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$a;
  private ListView b;
  private URLImageView by;
  private boolean csp;
  private boolean csq;
  public boolean csr;
  private int dmT;
  private int dmU;
  private TextView ht;
  private QQAppInterface mApp;
  private boolean mIsEnd = true;
  private Map<String, akjj> mi = new ConcurrentHashMap();
  private boolean xv;
  
  private akjj a(String paramString)
  {
    return (akjj)this.mi.get(paramString);
  }
  
  private void a(b paramb)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.mApp != null))
    {
      if (this.jdField_a_of_type_Akjb.getData().size() != 0) {
        break label93;
      }
      RR(0);
    }
    for (;;)
    {
      this.mi.clear();
      ((akio)this.mApp.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, 0, 20, new akij(this, paramb));
      return;
      label93:
      RR(3);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, List<akjj> paramList, b paramb)
  {
    if (paramBoolean1)
    {
      this.mIsEnd = paramBoolean2;
      if (this.mIsEnd)
      {
        this.ht.setVisibility(0);
        this.ht.setText(acfp.m(2131708768));
      }
      this.dmT = paramInt;
      this.jdField_a_of_type_Akjb.setData(paramList);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$a.onResult(paramList.size());
      }
      if (paramb != null) {
        paramb.U(true, paramList);
      }
      if ((paramList == null) || (paramList.size() == 0)) {
        RR(1);
      }
    }
    do
    {
      return;
      RR(3);
      return;
      RR(2);
    } while (paramb == null);
    paramb.U(false, null);
  }
  
  private akjj b(String paramString)
  {
    return (akjj)this.mi.remove(paramString);
  }
  
  private List<akjj> bm(List<akjj> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        akjj localakjj = (akjj)paramList.next();
        if (a(localakjj.feedId) == null) {
          localArrayList.add(localakjj);
        }
      }
    }
    return localArrayList;
  }
  
  private void lD(List<akjj> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (akjj)paramList.next();
        this.mi.put(((akjj)localObject).feedId, localObject);
        if ((localObject instanceof akjg))
        {
          localObject = (akjg)localObject;
          this.mi.put(((akjg)localObject).bTv, localObject);
        }
      }
    }
  }
  
  private void loadMore()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.mApp != null))
    {
      if ((this.csp) || (this.mIsEnd)) {
        return;
      }
      this.csp = true;
      this.ht.setVisibility(0);
      this.ht.setText(acfp.m(2131708760));
      ((akio)this.mApp.getManager(263)).a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowId, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nowUserType, this.dmT, 20, new akik(this));
      return;
    }
    QLog.i("NearbyMomentFragment", 1, "loadMore, mCard == null");
  }
  
  public void RR(int paramInt)
  {
    this.dmU = paramInt;
    switch (paramInt)
    {
    default: 
      this.by.setVisibility(8);
      this.Wg.setVisibility(8);
      this.b.setVisibility(0);
      return;
    case 0: 
      this.Wg.setVisibility(0);
      this.Wg.setOnClickListener(null);
      this.b.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)aqgz.getWidth());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.by.setVisibility(0);
        this.by.setImageDrawable((Drawable)localObject);
      }
      for (;;)
      {
        this.Wg.setText(acfp.m(2131708763));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new akil(this));
        ThreadManager.post(new NearbyMomentFragment.5(this, (URLDrawable)localObject), 8, null, false);
      }
    case 1: 
      this.Wg.setVisibility(0);
      this.Wg.setOnClickListener(null);
      this.b.setVisibility(8);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)aqgz.getWidth());
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
      localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/fa8cc1bd068f40d08c3554d019ed445d.png", (URLDrawable.URLDrawableOptions)localObject);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        this.by.setVisibility(0);
        this.by.setImageDrawable((Drawable)localObject);
      }
      while (this.xv)
      {
        this.Wg.setText(acfp.m(2131708767));
        return;
        ((URLDrawable)localObject).setURLDrawableListener(new akim(this));
        ThreadManager.post(new NearbyMomentFragment.7(this, (URLDrawable)localObject), 8, null, false);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender == 1))
      {
        this.Wg.setText(acfp.m(2131708769));
        return;
      }
      this.Wg.setText(acfp.m(2131708761));
      return;
    }
    this.Wg.setVisibility(0);
    this.Wg.setOnClickListener(this);
    this.b.setVisibility(8);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)aqgz.getWidth());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = (((URLDrawable.URLDrawableOptions)localObject).mRequestWidth / 2);
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20171226/0920780d51ba4d7aad487bb9bb8b18e6.png", (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      this.by.setImageDrawable((Drawable)localObject);
      this.by.setVisibility(0);
    }
    for (;;)
    {
      this.Wg.setText(acfp.m(2131708764));
      return;
      ((URLDrawable)localObject).setURLDrawableListener(new akin(this));
      ThreadManager.post(new NearbyMomentFragment.9(this, (URLDrawable)localObject), 8, null, false);
    }
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardMomentNearbyMomentFragment$a = parama;
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (this.csq)
    {
      this.jdField_a_of_type_Akjb.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      a(null);
    }
  }
  
  public View e()
  {
    return this.b;
  }
  
  public void onActivityResume()
  {
    if (this.csr)
    {
      a(null);
      this.csr = false;
    }
    if (this.mApp != null)
    {
      akio localakio = (akio)this.mApp.getManager(263);
      if (localakio != null) {
        localakio.dBt();
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mApp = ((FragmentActivity)paramActivity).app;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(null);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramViewGroup == null) || (this.mApp == null) || (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard == null)) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = paramLayoutInflater.inflate(2131559693, null);
      this.b = ((ListView)paramLayoutInflater.findViewById(2131371882));
      this.Wg = ((TextView)paramLayoutInflater.findViewById(2131380679));
      this.by = ((URLImageView)paramLayoutInflater.findViewById(2131381225));
      this.jdField_a_of_type_Akjb = new akjb(paramViewGroup.getContext(), this.mApp);
      this.jdField_a_of_type_Akjb.setNearbyPeopleCard(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard);
      paramBundle = (LinearLayout.LayoutParams)this.by.getLayoutParams();
      paramBundle.width = ((int)aqgz.getWidth());
      paramBundle.height = (paramBundle.width / 2);
      this.ht = new TextView(paramViewGroup.getContext());
      paramBundle = new AbsListView.LayoutParams(-1, -2);
      this.ht.setLayoutParams(paramBundle);
      this.ht.setTextColor(-16777216);
      this.ht.setBackgroundColor(-1);
      this.ht.setGravity(17);
      this.ht.setPadding(0, rpq.dip2px(paramViewGroup.getContext(), 10.0F), 0, rpq.dip2px(paramViewGroup.getContext(), 10.0F));
      this.ht.setTextSize(14.0F);
      this.xv = TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.uin, this.mApp.getCurrentAccountUin());
      if (!this.xv)
      {
        paramViewGroup = (FrameLayout.LayoutParams)this.b.getLayoutParams();
        paramViewGroup.bottomMargin = rpq.dip2px(BaseApplicationImpl.getContext(), 68.0F);
        this.b.setLayoutParams(paramViewGroup);
      }
      this.b.addFooterView(this.ht);
      this.ht.setVisibility(8);
      this.b.setAdapter(this.jdField_a_of_type_Akjb);
      this.b.setOnScrollListener(new akih(this));
      this.csq = true;
      a(null);
      ((akio)this.mApp.getManager(263)).a(this.jdField_a_of_type_Akio$c);
    }
  }
  
  public void onDestroyView()
  {
    if (this.mApp != null) {
      ((akio)this.mApp.getManager(263)).b(this.jdField_a_of_type_Akio$c);
    }
    this.mi.clear();
    super.onDestroyView();
  }
  
  public static abstract interface a
  {
    public abstract void onResult(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void U(boolean paramBoolean, List<akjj> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment
 * JD-Core Version:    0.7.0.1
 */