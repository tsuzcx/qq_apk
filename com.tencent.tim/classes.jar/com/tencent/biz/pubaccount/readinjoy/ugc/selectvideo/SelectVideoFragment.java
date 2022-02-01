package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import aqfo;
import com.tencent.biz.pubaccount.readinjoy.view.AlbumPermissionView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import lcc;
import mir.a;
import mlj;
import mlj.b;
import mlx;
import mmq;
import mpu;
import mpw;
import mpx;
import mpy;
import mqh;
import mqq.app.QQPermissionCallback;

public class SelectVideoFragment
  extends PublicBaseFragment
  implements View.OnClickListener, mlj.b, mpu, QQPermissionCallback
{
  private AlbumPermissionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView;
  private mlj jdField_a_of_type_Mlj;
  private mmq jdField_a_of_type_Mmq = new mpw(this);
  private mpy jdField_a_of_type_Mpy;
  private Activity activity;
  private boolean anx = true;
  private ViewGroup bc;
  private ViewGroup bd;
  private ImmersiveTitleBar2 c;
  private View lt;
  private View lu;
  private RecyclerView recyclerView;
  private TextView rh;
  
  public static SelectVideoFragment a(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("PARAMS_IS_SHOW_TITLEBAR", paramBoolean);
    SelectVideoFragment localSelectVideoFragment = new SelectVideoFragment();
    localSelectVideoFragment.setArguments(localBundle);
    return localSelectVideoFragment;
  }
  
  private void aQs()
  {
    if ((VersionUtils.isM()) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.c.setBackgroundColor(-1);
    }
  }
  
  private void aRc()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.Fk())
    {
      this.jdField_a_of_type_Mpy.aPh();
      return;
    }
    this.recyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(0);
  }
  
  private void aRd()
  {
    this.anx = getArguments().getBoolean("PARAMS_IS_SHOW_TITLEBAR", true);
  }
  
  private void aRe()
  {
    if (this.anx)
    {
      this.bd.setVisibility(0);
      this.c.setVisibility(0);
      aQs();
      return;
    }
    this.bd.setVisibility(8);
    this.c.setVisibility(8);
  }
  
  public mir.a a(int paramInt)
  {
    return (mir.a)this.jdField_a_of_type_Mlj.getItem(paramInt);
  }
  
  public void a(mir.a parama)
  {
    this.jdField_a_of_type_Mpy.d(parama);
  }
  
  public boolean a(int paramInt, mir.a parama)
  {
    return this.jdField_a_of_type_Mpy.a(parama);
  }
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public int getDataCount()
  {
    return this.jdField_a_of_type_Mlj.getItemCount();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 10000)
    {
      this.recyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setVisibility(8);
      this.jdField_a_of_type_Mpy.aPh();
    }
  }
  
  public boolean needImmersive()
  {
    return !this.anx;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.activity = paramActivity;
    this.jdField_a_of_type_Mpy = new mpy(getActivity(), this);
    lcc.a().b(this.jdField_a_of_type_Mmq);
    mlx.aQb();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.rh.getId()) {
      this.jdField_a_of_type_Mpy.aRf();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == this.lt.getId()) {
        this.activity.finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    aRd();
    paramLayoutInflater = View.inflate(this.activity, 2131560183, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Mpy.a().onDestroy();
    lcc.a().c(this.jdField_a_of_type_Mmq);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Mpy.a().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Mpy.a().onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.recyclerView = ((RecyclerView)paramView.findViewById(2131381732));
    this.rh = ((TextView)paramView.findViewById(2131380817));
    this.bc = ((ViewGroup)paramView.findViewById(2131381789));
    this.bd = ((ViewGroup)paramView.findViewById(2131379798));
    this.c = ((ImmersiveTitleBar2)paramView.findViewById(2131379866));
    this.lt = paramView.findViewById(2131364690);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView = ((AlbumPermissionView)paramView.findViewById(2131362631));
    this.lu = paramView.findViewById(2131366417);
    aRe();
    this.lt.setOnClickListener(this);
    this.rh.setOnClickListener(this);
    this.jdField_a_of_type_Mlj = new mlj(this.activity);
    this.jdField_a_of_type_Mlj.a(this);
    this.recyclerView.setLayoutManager(new GridLayoutManager(this.activity, 3, 1, false));
    this.recyclerView.setAdapter(this.jdField_a_of_type_Mlj);
    this.recyclerView.addItemDecoration(new mpx(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setContextStyleBlack(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAlbumPermissionView.setCallback(this);
    this.jdField_a_of_type_Mpy.a().r(this.bc);
    aRc();
  }
  
  public void q(List<mir.a> paramList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Mlj.E(paramList);
    if (this.jdField_a_of_type_Mlj.isEmpty())
    {
      this.lu.setVisibility(0);
      return;
    }
    this.lu.setVisibility(8);
  }
  
  public void rP(int paramInt)
  {
    this.jdField_a_of_type_Mpy.rP(paramInt);
  }
  
  public void rW(int paramInt)
  {
    this.jdField_a_of_type_Mlj.rW(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment
 * JD-Core Version:    0.7.0.1
 */