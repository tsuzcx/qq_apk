package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;
import ous;
import ovn;
import ovo;
import ovv;
import ows;
import oww;
import oxd;
import oxh;
import oxx;
import oyu;
import pag;
import pah;
import pai;
import paj;
import pco;
import pcr;
import pec;
import rpq;
import rwv;
import rxj;
import rxk;
import rxq;
import ryo;

public class QCirclePersonalDetailFragment
  extends QCircleBaseFragment
{
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private a jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDetailFragment$a;
  private ovn jdField_a_of_type_Ovn;
  public ovo a;
  private ows jdField_a_of_type_Ows;
  public oxh a;
  private oyu jdField_a_of_type_Oyu;
  private pec jdField_a_of_type_Pec;
  protected rxj a;
  private oww b;
  private FeedCloudMeta.StUser c;
  private int mDistance;
  private int mMaxDistance;
  private String mUin;
  
  private ovv a()
  {
    return new paj(this);
  }
  
  private void biW()
  {
    if ((this.c != null) && (this.jdField_a_of_type_Ovo != null)) {
      this.jdField_a_of_type_Ovo.setDatas(new ArrayList(Arrays.asList(new FeedCloudMeta.StUser[] { this.c })));
    }
    if ((ryo.exists("2001" + this.mUin)) && (this.jdField_a_of_type_Pec != null))
    {
      this.jdField_a_of_type_Pec.sO("2001" + this.mUin);
      return;
    }
    refresh(true);
  }
  
  private void biu()
  {
    this.mDistance = 0;
    vg(0);
  }
  
  private List<rxq> by()
  {
    ArrayList localArrayList = new ArrayList();
    ovv localovv = a();
    this.jdField_a_of_type_Ovo = new ovo(new Bundle());
    this.jdField_a_of_type_Ovo.setInteractor(localovv);
    this.jdField_a_of_type_Ovo.setOnLoadDataDelegate(new pai(this));
    this.jdField_a_of_type_Ovn = new ovn(null);
    this.jdField_a_of_type_Ovn.setInteractor(localovv);
    localArrayList.add(this.jdField_a_of_type_Ovo);
    localArrayList.add(this.jdField_a_of_type_Ovn);
    return localArrayList;
  }
  
  private void initReceiver()
  {
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDetailFragment$a = new a(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDetailFragment$a, localIntentFilter);
    }
  }
  
  private void refresh(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pec != null) {
      this.jdField_a_of_type_Pec.at(this.mUin, paramBoolean);
    }
  }
  
  private void rm(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pec != null) {
      this.jdField_a_of_type_Pec.au(this.mUin, paramBoolean);
    }
  }
  
  private void vg(int paramInt)
  {
    int i = 255;
    this.mDistance += paramInt;
    float f = this.mDistance * 1.0F / this.mMaxDistance;
    QLog.d("QCirclePersonalDetailFragment", 1, "computeShowTitleBarAnimation  dy:" + paramInt + "  mDistance:" + this.mDistance + "  percent:" + f);
    paramInt = (int)(f * 255.0F);
    if (paramInt > 255) {
      paramInt = i;
    }
    for (;;)
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      this.jdField_a_of_type_Ows.l("personal_page_action_title_bar_animation", localMessage);
      return;
      if (paramInt < 0) {
        paramInt = 0;
      }
    }
  }
  
  protected void Ie()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("key_bundle_common_init_bean")))
    {
      this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = ((QCircleInitBean)localIntent.getSerializableExtra("key_bundle_common_init_bean"));
      if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get())))
      {
        this.mUin = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser().id.get();
        this.c = this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getUser();
        pco.b(this.mUin, 11, 1L, 0L);
      }
    }
  }
  
  protected void Rt()
  {
    this.jdField_a_of_type_Pec = ((pec)getViewModel(pec.class));
    this.jdField_a_of_type_Pec.o().observe(this, new pag(this));
  }
  
  public rxj a()
  {
    return this.jdField_a_of_type_Rxj;
  }
  
  protected void biU()
  {
    this.mMaxDistance = rpq.dip2px(getActivity(), 200.0F);
    this.jdField_a_of_type_Rxj.a().setEnableRefresh(true);
    this.jdField_a_of_type_Rxj.a().setEnableLoadMore(false);
    this.jdField_a_of_type_Rxj.a().setParentFragment(this);
    this.jdField_a_of_type_Rxj.a().a().setBackgroundColor(getResources().getColor(2131166508));
    this.jdField_a_of_type_Rxj.a().a().addOnScrollListener(new pah(this));
  }
  
  public List<rxk> bw()
  {
    Ie();
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_Rxj = new rxj(2131365507, by(), 3, 1);
    this.jdField_a_of_type_Ows = new ows(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean);
    this.jdField_a_of_type_Oxh = new oxh();
    Object localObject = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject).id.set(this.mUin);
    localArrayList.add(this.jdField_a_of_type_Rxj);
    localArrayList.add(this.jdField_a_of_type_Ows);
    localArrayList.add(this.jdField_a_of_type_Oxh);
    localObject = new oxd((FeedCloudMeta.StUser)localObject);
    localArrayList.add(localObject);
    localArrayList.add(new oxx());
    ((oxd)localObject).nA(4);
    this.b = new oww();
    localArrayList.add(this.b);
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    Rt();
    biU();
    biW();
    rm(true);
    initReceiver();
  }
  
  public int getContentLayoutId()
  {
    return 2131560929;
  }
  
  public String getLogTag()
  {
    return "QCirclePersonalDetailFragment";
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    getActivity().getWindow().setSoftInputMode(32);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (pcr.a().ey(32)) {
      pcr.a().aX(getActivity().getIntent());
    }
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_a_of_type_Oyu != null) && (this.jdField_a_of_type_Oyu.onBackPress())) {
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDetailFragment$a != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizQqcircleFragmentsQCirclePersonalDetailFragment$a);
    }
    ous.clearMemoryCache();
  }
  
  public void onDetach()
  {
    super.onDetach();
    pcr.a().vq(32);
  }
  
  static class a
    extends BroadcastReceiver
  {
    private WeakReference<QCirclePersonalDetailFragment> F;
    
    public a(QCirclePersonalDetailFragment paramQCirclePersonalDetailFragment)
    {
      this.F = new WeakReference(paramQCirclePersonalDetailFragment);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = (QCirclePersonalDetailFragment)this.F.get();
      if ((paramContext != null) && (paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")) && (paramIntent.hasExtra("uin")) && (paramIntent.getStringExtra("uin").equals(QCirclePersonalDetailFragment.a(paramContext))))
      {
        QCirclePersonalDetailFragment.a(paramContext, false);
        QCirclePersonalDetailFragment.b(paramContext, false);
        rwv.a().a(new UserStateUpdateEvent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCirclePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */