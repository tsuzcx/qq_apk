package com.tencent.mobileqq.activity.chathistory;

import afrq;
import ahao;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aqiw;
import ausj;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import unt;
import unt.a;
import xsi;
import xsi.a;
import ymn;
import ymq;

public class TroopAIOEmotionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, unt.a, xsi.a
{
  private unt jdField_a_of_type_Unt;
  private ymn jdField_a_of_type_Ymn;
  private boolean aTX;
  private ImageView ff;
  private RelativeLayout ii;
  private ImageView mForwardView;
  private List<afrq> qs;
  private View xR;
  
  private void cjL()
  {
    this.aTX = false;
    this.xR.setVisibility(8);
    setRightButton(2131690235, this);
    this.jdField_a_of_type_Unt.bJZ();
    if ((this.qs != null) && (!this.qs.isEmpty()))
    {
      Iterator localIterator = this.qs.iterator();
      while (localIterator.hasNext()) {
        ((afrq)localIterator.next()).isSelected = false;
      }
      this.qs.clear();
    }
  }
  
  public boolean Pm()
  {
    boolean bool = false;
    if (this.qs != null) {}
    for (int i = this.qs.size() + 0;; i = 0)
    {
      if (i >= 20) {
        bool = true;
      }
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarFragment", 2, "isOverLimit");
        }
        ahao.OS(2131693685);
      }
      return bool;
    }
  }
  
  public void a(afrq paramafrq)
  {
    if (this.qs == null) {
      this.qs = new ArrayList();
    }
    this.qs.add(paramafrq);
    if (this.qs.size() == 1)
    {
      this.mForwardView.setEnabled(true);
      this.ff.setEnabled(true);
    }
  }
  
  public void b(afrq paramafrq)
  {
    if (this.qs == null) {}
    do
    {
      return;
      this.qs.remove(paramafrq);
    } while (!this.qs.isEmpty());
    this.mForwardView.setImageResource(2130839616);
    this.ff.setImageResource(2130839586);
  }
  
  public void bKa() {}
  
  public void cjK()
  {
    ThreadManager.excute(new TroopAIOEmotionFragment.2(this), 32, null, true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    setTitle(this.mContentView.getContext().getResources().getString(2131693118));
    setRightButton(2131690235, this);
    this.ii = ((RelativeLayout)this.mContentView.findViewById(2131371085));
    this.mForwardView = ((ImageView)this.mContentView.findViewById(2131367525));
    this.ff = ((ImageView)this.mContentView.findViewById(2131365679));
    this.xR = this.mContentView.findViewById(2131368542);
    this.mForwardView.setOnClickListener(this);
    this.ff.setOnClickListener(this);
    paramLayoutInflater = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Unt = new unt();
    this.jdField_a_of_type_Unt.a(getActivity().getIntent(), paramLayoutInflater, getActivity());
    this.jdField_a_of_type_Unt.a = this;
    paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    this.ii.addView(this.jdField_a_of_type_Unt.aI(), 0, paramLayoutInflater);
    this.jdField_a_of_type_Ymn = new ymn(getActivity(), 1);
    this.jdField_a_of_type_Ymn.onCreate();
    xsi.a().a(this);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (this.aTX))
    {
      cjL();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void fG(long paramLong)
  {
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.fG(paramLong);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558889;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1)) {
      this.jdField_a_of_type_Ymn.cy(paramIntent);
    }
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
      if (!this.aTX)
      {
        this.aTX = true;
        this.mForwardView.setEnabled(false);
        this.ff.setEnabled(false);
        this.xR.setVisibility(0);
        setRightButton(2131721058, this);
        this.jdField_a_of_type_Unt.bJY();
      }
      else
      {
        cjL();
        continue;
        if ((this.qs == null) || (this.qs.isEmpty()))
        {
          ahao.OU(2131693682);
        }
        else if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(getActivity(), 2131696348, 1).show(getResources().getDimensionPixelSize(2131299627));
        }
        else
        {
          Object localObject = new ArrayList();
          Iterator localIterator = this.qs.iterator();
          while (localIterator.hasNext()) {
            ((List)localObject).add((ChatMessage)((afrq)localIterator.next()).h);
          }
          this.jdField_a_of_type_Ymn.gG((List)localObject);
          cjL();
          continue;
          if ((this.qs == null) || (this.qs.isEmpty()))
          {
            ahao.OU(2131693682);
          }
          else
          {
            localObject = (ausj)auss.a(getActivity(), null);
            ((ausj)localObject).setMainTitle(2131698325);
            ((ausj)localObject).addButton(getActivity().getString(2131693518), 3);
            ((ausj)localObject).addCancelButton(2131721058);
            ((ausj)localObject).a(new ymq(this, (ausj)localObject));
            ((ausj)localObject).show();
          }
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Unt.cg();
    this.jdField_a_of_type_Ymn.onDestroy();
    xsi.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Unt.bJX();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Unt.bJW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */