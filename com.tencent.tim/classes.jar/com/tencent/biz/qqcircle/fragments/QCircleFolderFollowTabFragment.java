package com.tencent.biz.qqcircle.fragments;

import altq;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.events.QCircleCloseBannerEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import ovd;
import ovg;
import ovi;
import ovk;
import oxz;
import paa;
import pab;
import pac;
import pad;
import pco;
import pcr;
import pdy;
import pea;
import rwv;
import rwx;
import rxj;
import rxk;
import rxn;
import rxq;

public class QCircleFolderFollowTabFragment
  extends QCircleBaseTabFragment
  implements rwx
{
  public static String TAG = "QCircleFolderFollowTabFragment";
  private oxz jdField_a_of_type_Oxz;
  private pea jdField_a_of_type_Pea;
  private ovi jdField_b_of_type_Ovi;
  private ovk jdField_b_of_type_Ovk;
  
  private void biR()
  {
    altq localaltq = (altq)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localaltq.getAppInfoByPath("140000");
    if (localAppInfo != null)
    {
      localAppInfo.buffer.clear();
      QLog.i(TAG, 1, "reportRedPoint clear buffer");
    }
    localaltq.OS("140000");
  }
  
  @NotNull
  private View f(@Nullable ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560915, null);
    paramViewGroup.setOnClickListener(new pab(this));
    return paramViewGroup;
  }
  
  private void preload()
  {
    ovd.bhN();
    ovd.bhO();
    ovd.cu(getActivity());
    if (this.jdField_a_of_type_Ovg != null) {
      this.jdField_a_of_type_Ovg.bhS();
    }
  }
  
  public void bhT()
  {
    super.bhT();
  }
  
  protected void biN()
  {
    super.biN();
    this.jdField_a_of_type_Pea = ((pea)getViewModel(pea.class));
    this.jdField_a_of_type_Pea.n().observe(this, new pac(this));
    this.jdField_b_of_type_Pdy.m().observe(this, new pad(this));
  }
  
  protected void biO()
  {
    this.jdField_a_of_type_Pea.cw(getActivity());
  }
  
  protected List<rxq> bx()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_b_of_type_Ovi = new ovi(new Bundle());
    this.jdField_b_of_type_Ovi.ur(false);
    this.jdField_b_of_type_Ovk = new ovk(new Bundle());
    this.jdField_b_of_type_Ovk.ur(false);
    localArrayList.add(this.jdField_b_of_type_Ovi);
    localArrayList.add(this.jdField_b_of_type_Ovk);
    return localArrayList;
  }
  
  protected void dE(List<rxk> paramList)
  {
    super.dE(paramList);
    this.jdField_a_of_type_Oxz = new oxz();
    paramList.add(this.jdField_a_of_type_Oxz);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Rxj.a().getBlockMerger().dY(f(paramViewGroup));
    this.jdField_a_of_type_Rxj.a().a().addOnScrollListener(new paa(this));
    rwv.a().a(this);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCircleCloseBannerEvent.class);
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return TAG;
  }
  
  protected void initViewData()
  {
    super.initViewData();
    preload();
    biR();
  }
  
  public String lZ()
  {
    return arP;
  }
  
  public void onDestroy()
  {
    ovd.bhP();
    ovd.cv(getActivity());
    super.onDestroy();
    rwv.a().b(this);
    oug.ayA = false;
  }
  
  public void onDetach()
  {
    QLog.d(TAG, 1, "QCircleFolderFollowTabFragment->onDetach");
    super.onDetach();
    pcr.a().vq(1);
  }
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof QCircleFeedEvent)) && (((QCircleFeedEvent)paramSimpleBaseEvent).mState == 3)) {
      if (this.jdField_b_of_type_Pdy != null) {
        this.jdField_b_of_type_Pdy.qD(((QCircleFeedEvent)paramSimpleBaseEvent).mTargetId);
      }
    }
    do
    {
      do
      {
        return;
        if (!(paramSimpleBaseEvent instanceof QCircleCloseBannerEvent)) {
          break;
        }
      } while (this.jdField_b_of_type_Pdy == null);
      this.jdField_b_of_type_Pdy.m().removeObservers(this);
      this.jdField_b_of_type_Pdy.m().postValue(null);
      return;
    } while (!(paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent));
    biL();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    QLog.d(TAG, 1, "QCircleFolderFollowTabFragment->setUserVisibleHint:" + paramBoolean);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (pcr.a().ey(1)) {
        pcr.a().aX(getActivity().getIntent());
      }
      pco.h("", 22, 1L);
      return;
    }
    pcr.a().vq(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleFolderFollowTabFragment
 * JD-Core Version:    0.7.0.1
 */