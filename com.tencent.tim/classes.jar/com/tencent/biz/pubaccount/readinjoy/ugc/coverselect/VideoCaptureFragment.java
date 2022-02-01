package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout;
import com.tencent.biz.pubaccount.readinjoy.view.VideoMeasureScaleView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import mlh;
import mli;
import mll;
import mlm;
import mlo;
import mlp;
import mlu;
import riw;

public class VideoCaptureFragment
  extends PublicBaseFragment
  implements mlh
{
  private CaptureOperateTouchLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView;
  private mli jdField_a_of_type_Mli;
  private mlp jdField_a_of_type_Mlp;
  private Activity activity;
  private mlm b;
  private ViewGroup bb;
  private ImageView gd;
  private TextView progressTextView;
  private TextView qQ;
  private RecyclerView recyclerView;
  
  public static VideoCaptureFragment a(String paramString, float paramFloat)
  {
    VideoCaptureFragment localVideoCaptureFragment = new VideoCaptureFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("ARG_VIDEO_URL", paramString);
    localBundle.putFloat("ARG_INITIAL_PROGRESS", paramFloat);
    localVideoCaptureFragment.setArguments(localBundle);
    return localVideoCaptureFragment;
  }
  
  private void aPR()
  {
    int i = py() + this.gd.getPaddingTop() + this.gd.getPaddingBottom();
    ViewGroup.LayoutParams localLayoutParams = this.gd.getLayoutParams();
    localLayoutParams.height = i;
    localLayoutParams.width = i;
    this.gd.setLayoutParams(localLayoutParams);
  }
  
  private void aPS()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setup(this.gd, this.progressTextView, this.qQ, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView, px());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setOnCaptureOperateCallback(new mlo(this));
  }
  
  public void a(mli parammli)
  {
    this.jdField_a_of_type_Mli = parammli;
  }
  
  public void a(mll parammll)
  {
    this.jdField_a_of_type_Mlp.a(parammll);
  }
  
  public void b(float paramFloat, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.b(paramFloat, paramBoolean);
  }
  
  public void cM(List<mlu> paramList)
  {
    this.b = new mlm(this.activity, paramList);
    this.recyclerView.setAdapter(this.b);
  }
  
  public void cN(List<mlu> paramList)
  {
    if (this.b != null)
    {
      this.b.YW();
      this.b.E(paramList);
      this.b.notifyDataSetChanged();
    }
  }
  
  public void eF(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
  }
  
  public void eG(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setDuration(paramLong);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.setEnabled(true);
  }
  
  public float getProgress()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout.ak();
  }
  
  public ViewGroup l()
  {
    return this.bb;
  }
  
  public void l(Bitmap paramBitmap)
  {
    this.gd.setImageBitmap(paramBitmap);
    if (this.jdField_a_of_type_Mli != null) {
      this.jdField_a_of_type_Mli.l(paramBitmap);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.activity = paramActivity;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.activity, 2131560184, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Mlp.release();
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Mlp.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Mlp.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.recyclerView = ((RecyclerView)paramView.findViewById(2131381630));
    this.bb = ((ViewGroup)paramView.findViewById(2131381624));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout = ((CaptureOperateTouchLayout)paramView.findViewById(2131381628));
    this.gd = ((ImageView)paramView.findViewById(2131381625));
    this.progressTextView = ((TextView)paramView.findViewById(2131381629));
    this.qQ = ((TextView)paramView.findViewById(2131381631));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVideoMeasureScaleView = ((VideoMeasureScaleView)paramView.findViewById(2131381627));
    this.jdField_a_of_type_Mlp = new mlp(this.activity, getArguments(), this);
    paramView = new LinearLayoutManager(this.activity, 0, false);
    this.recyclerView.setLayoutManager(paramView);
    this.recyclerView.getLayoutParams().height = py();
    this.recyclerView.setLayoutManager(paramView);
    aPR();
    aPS();
    this.jdField_a_of_type_Mlp.aPU();
  }
  
  public int px()
  {
    return 5;
  }
  
  public int py()
  {
    return (int)((riw.getWindowScreenWidth(BaseApplication.getContext()) - riw.dip2px(this.activity, 5.0F)) / px());
  }
  
  public void rV(int paramInt)
  {
    this.b.notifyItemChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.VideoCaptureFragment
 * JD-Core Version:    0.7.0.1
 */