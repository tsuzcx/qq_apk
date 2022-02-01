package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import aqcx;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import java.util.List;
import kxm;
import mla;
import mlb;
import mlc;
import mld;
import mll;

public class CoverSelectTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private static final String[] by = { kxm.getString(2131718384), kxm.getString(2131718383) };
  private GalleryFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment;
  private VideoCaptureFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private int aHV;
  private boolean anm;
  private List<Fragment> jk = new ArrayList();
  private View le;
  private View lf;
  protected Activity mActivity;
  
  private void Qm()
  {
    Object localObject = getArguments();
    if (localObject == null) {
      return;
    }
    String str = ((Bundle)localObject).getString("ARG_VIDEO_URL");
    float f = ((Bundle)localObject).getFloat("ARG_INITIAL_PROGRESS");
    this.aHV = ((Bundle)localObject).getInt("ARG_SELECTED_ITEM");
    int i = ((Bundle)localObject).getInt("ARG_VIDEO_WIDTH");
    int j = ((Bundle)localObject).getInt("ARG_VIDEO_HEIGHT");
    localObject = ((Bundle)localObject).getString("ARG_PLACEHOLDER_URL");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment = VideoCaptureFragment.a(str, f);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment = GalleryFragment.a(i, j, (String)localObject);
    this.jk.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment);
    this.jk.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment.a(new mlb(this));
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString, UgcVideo paramUgcVideo)
  {
    a(paramActivity, paramInt1, paramInt2, paramFloat, paramString, paramUgcVideo.filePath, paramUgcVideo.width, paramUgcVideo.height);
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, float paramFloat, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt2);
    localIntent.putExtra("ARG_VIDEO_URL", paramString2);
    localIntent.putExtra("ARG_INITIAL_PROGRESS", paramFloat);
    localIntent.putExtra("ARG_VIDEO_WIDTH", paramInt3);
    localIntent.putExtra("ARG_VIDEO_HEIGHT", paramInt4);
    localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString1);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, CoverSelectTabFragment.class, paramInt1);
  }
  
  private void a(mll parammll)
  {
    if (this.anm) {
      return;
    }
    this.anm = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem() == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment.a(parammll);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectGalleryFragment.a(parammll);
  }
  
  private void aL(String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ARG_SELECTED_COVER", paramString);
    localIntent.putExtra("ARG_SELECTED_ITEM", paramInt);
    if (paramInt == 0) {
      localIntent.putExtra("ARG_INITIAL_PROGRESS", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcCoverselectVideoCaptureFragment.getProgress());
    }
    for (;;)
    {
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
      return;
      if (paramInt == 1) {
        localIntent.putExtra("ARG_PLACEHOLDER_URL", paramString);
      }
    }
  }
  
  private void aPK()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(new mlc(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(aqcx.dip2px(this.mActivity, 3.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(-1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(aqcx.dip2px(this.mActivity, 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(aqcx.dip2px(this.mActivity, 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(aqcx.dip2px(this.mActivity, 6.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(this.mActivity.getResources().getColor(2131165689), -1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextSize(aqcx.sp2px(this.mActivity, 16.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.le.getId()) {
      a(new mld(this));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == this.lf.getId()) {
        this.mActivity.finish();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(getActivity(), 2131560180, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379866));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131365498));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131365496));
    this.le = paramView.findViewById(2131365497);
    this.lf = paramView.findViewById(2131365495);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.abu(0);
    this.le.setOnClickListener(this);
    this.lf.setOnClickListener(this);
    Qm();
    aPK();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(new mla(this, getActivity().getSupportFragmentManager()));
    if (this.aHV == 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(1);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.CoverSelectTabFragment
 * JD-Core Version:    0.7.0.1
 */