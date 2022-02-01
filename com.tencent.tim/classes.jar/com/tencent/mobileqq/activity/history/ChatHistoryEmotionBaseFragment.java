package com.tencent.mobileqq.activity.history;

import afrq;
import ahao;
import ajlm;
import ajlp;
import ajlu;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import aqiw;
import aqju;
import aurf;
import ausj;
import auss;
import awou;
import awpl;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import unt;
import unt.a;
import xsi;
import xsi.a;
import ymn;
import zer;
import zgb;
import zgd;
import zge;
import zgf;
import zgg;
import zjl;

public class ChatHistoryEmotionBaseFragment
  extends ChatHistoryBaseFragment
  implements Handler.Callback, unt.a, xsi.a
{
  private aqju E;
  unt jdField_a_of_type_Unt;
  private ymn jdField_a_of_type_Ymn;
  private List<afrq> qs;
  protected final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, ChatHistoryFileActivity.b paramb)
  {
    if ((this.E != null) && (this.E.isShowing())) {
      this.E.dismiss();
    }
    aqju localaqju = new aqju(getActivity(), 2131756467);
    localaqju.setContentView(2131559151);
    this.E = localaqju;
    this.E.setTitle(paramString1);
    this.E.setMessage(paramString2);
    paramString1 = paramString4;
    if (TextUtils.isEmpty(paramString4)) {
      paramString1 = getString(2131721058);
    }
    paramString2 = paramString3;
    if (TextUtils.isEmpty(paramString3)) {
      paramString2 = getString(2131691970);
    }
    this.E.setNegativeButton(paramString1, new zgf(this, paramb));
    this.E.setPositiveButton(paramString2, new zgg(this, paramb));
    this.E.setCancelable(true);
    this.E.setCanceledOnTouchOutside(false);
    this.E.show();
  }
  
  void BA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cpn();
      cpj();
      return;
    }
    cpo();
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
          QLog.d("Q.history.BaseFragment", 2, "isOverLimit");
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
  }
  
  public void b(afrq paramafrq)
  {
    if (this.qs == null) {
      return;
    }
    this.qs.remove(paramafrq);
  }
  
  public void bKa()
  {
    if ((this.jdField_a_of_type_Unt != null) && (this.jdField_a_of_type_Unt.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) && (this.jdField_a_of_type_Unt.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "onEmotionLoaded, mEmotionView.mAdapter is null");
      }
      this.jdField_a_of_type_Zer.BB(false);
      return;
    }
    this.jdField_a_of_type_Zer.BB(true);
  }
  
  protected void bpM() {}
  
  protected void bpN() {}
  
  protected void coH()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_Zjl.hk(localArrayList);
  }
  
  protected void coK()
  {
    if (!CheckPermission.isHasStoragePermission(this.mActivity))
    {
      CheckPermission.requestStorePermission(this.mActivity, null);
      return;
    }
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131696348, 1).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((this.qs != null) && (!this.qs.isEmpty())) {
      localObject1 = this.qs.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (afrq)((Iterator)localObject1).next();
      if ((((afrq)localObject2).h instanceof MessageForPic))
      {
        localArrayList.add(ajlp.a((MessageForPic)((afrq)localObject2).h));
        continue;
        ahao.OU(2131693682);
        return;
      }
    }
    Object localObject1 = new ajlm(getActivity());
    Object localObject2 = (ajlu)this.mApp.getManager(324);
    ((ajlu)localObject2).a(new zgb(this, (ajlm)localObject1, (ajlu)localObject2, localArrayList));
    ((ajlu)localObject2).at(localArrayList, true);
    ((ajlu)localObject2).d(localArrayList, 1, 5);
    cpi();
  }
  
  protected void coM()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(getActivity(), 2131696348, 1).show(getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if ((this.qs != null) && (!this.qs.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.qs.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)((afrq)localIterator.next()).h);
      }
      if (this.jdField_a_of_type_Ymn == null)
      {
        this.jdField_a_of_type_Ymn = new ymn(getActivity(), 3);
        this.jdField_a_of_type_Ymn.onCreate();
      }
      this.jdField_a_of_type_Ymn.gG(localArrayList);
      cph();
      return;
    }
    ahao.OU(2131693682);
  }
  
  protected void coN()
  {
    int i = 0;
    if (this.qs != null) {
      i = 0 + this.qs.size();
    }
    if (i == 0)
    {
      ahao.OU(2131693682);
      return;
    }
    ausj localausj = (ausj)auss.a(getActivity(), null);
    localausj.setMainTitle(2131698325);
    localausj.addButton(getActivity().getString(2131693518), 3);
    localausj.addCancelButton(2131721058);
    localausj.a(new zgd(this, localausj));
    localausj.show();
  }
  
  void cpg() {}
  
  void cph() {}
  
  void cpi() {}
  
  void cpj() {}
  
  protected void cpn()
  {
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.bJY();
    }
  }
  
  public void cpo()
  {
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.bJZ();
    }
    if ((this.qs != null) && (!this.qs.isEmpty()))
    {
      Iterator localIterator = this.qs.iterator();
      while (localIterator.hasNext()) {
        ((afrq)localIterator.next()).isSelected = false;
      }
      this.qs.clear();
    }
    coI();
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    xsi.a().b(this);
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.cg();
    }
    if (this.jdField_a_of_type_Ymn != null) {
      this.jdField_a_of_type_Ymn.onDestroy();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    cpo();
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.bJW();
    }
    if ((this.jdField_a_of_type_Unt != null) && (this.jdField_a_of_type_Unt.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter != null) && (this.jdField_a_of_type_Unt.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.getCount() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.history.BaseFragment", 2, "doOnResume, mEmotionView.mAdapter is null");
      }
      if (this.jdField_a_of_type_Zer != null) {
        this.jdField_a_of_type_Zer.BB(false);
      }
    }
    while (this.jdField_a_of_type_Zer == null) {
      return;
    }
    this.jdField_a_of_type_Zer.BB(true);
  }
  
  public void fG(long paramLong)
  {
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.fG(paramLong);
    }
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return true;
      if (this.jdField_a_of_type_Unt != null) {
        this.jdField_a_of_type_Unt.refreshData();
      }
      cpo();
      cpg();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      cpo();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      awpl.b(this.mApp, getActivity(), getTitleBarHeight());
      cpo();
      return true;
      if (this.G != null) {
        this.G.dismiss();
      }
      cpo();
      i = paramMessage.arg1;
    } while (!awou.nP(i));
    if (awou.nS(i))
    {
      getString(2131696684);
      paramMessage = "";
      if (awou.nQ(i))
      {
        getString(2131696684);
        paramMessage = getString(2131693270);
      }
      for (;;)
      {
        zge localzge = new zge(this);
        a(getString(2131700888), paramMessage, null, null, localzge);
        return true;
        if (awou.nR(i))
        {
          getString(2131696684);
          paramMessage = getString(2131693268);
        }
      }
    }
    paramMessage = (String)paramMessage.obj;
    QQToast.a(this.mApp.getApp(), paramMessage, 1).show(getTitleBarHeight());
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    xsi.a().a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Unt == null)
    {
      this.jdField_a_of_type_Unt = new unt();
      this.jdField_a_of_type_Unt.a(this.mActivity.getIntent(), this.mApp, this.mActivity);
      this.jdField_a_of_type_Unt.jdField_a_of_type_Unt$a = this;
    }
    paramLayoutInflater = this.jdField_a_of_type_Unt.aI();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.bJX();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Unt != null) {
      this.jdField_a_of_type_Unt.bJW();
    }
  }
  
  public void pH(boolean paramBoolean)
  {
    super.pH(paramBoolean);
    if ((this.mk) && (this.jdField_a_of_type_Unt != null) && (this.jdField_a_of_type_Unt.Pl())) {
      this.jdField_a_of_type_Unt.expandAll();
    }
  }
  
  protected int yg()
  {
    return 1602;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment
 * JD-Core Version:    0.7.0.1
 */