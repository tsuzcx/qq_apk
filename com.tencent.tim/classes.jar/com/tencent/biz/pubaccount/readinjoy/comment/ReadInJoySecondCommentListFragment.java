package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ayxa;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import kbp;
import kgi;
import kgi.b;
import kpn;
import krx;
import ksm.a;
import ksx;
import ksz;
import ksz.b;
import ksz.g;
import ktb;
import ktc;
import ktd;
import ktr;
import kxm;
import kxy;
import muj;

public class ReadInJoySecondCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, kgi.b
{
  private int ZY;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private ksm.a jdField_a_of_type_Ksm$a;
  private ksz.g jdField_a_of_type_Ksz$g;
  private ktb jdField_a_of_type_Ktb;
  private kxy jdField_a_of_type_Kxy = new kxy();
  private int aLx = 0;
  private String abZ;
  private String aca;
  private boolean aeI;
  private boolean ahH;
  private boolean ahp;
  private boolean ahv;
  private CommonCommentData jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ksz.b jdField_b_of_type_Ksz$b;
  private ReadInJoyCommentListView d;
  private RelativeLayout eU;
  private View jZ;
  private int mContentSrc;
  private View mRootView;
  private TextView oS;
  
  private void aGI()
  {
    if (this.d == null) {
      return;
    }
    this.d.smoothScrollBy(0, 0);
    this.d.setSelection(0);
  }
  
  private void aHd()
  {
    if (this.mRootView == null) {}
    do
    {
      return;
      if ((this.ZY == 0) && (this.ahv)) {
        this.ZY = nH();
      }
    } while (!(this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mRootView.getLayoutParams();
    localLayoutParams.setMargins(0, this.ZY, 0, 0);
    this.mRootView.setLayoutParams(localLayoutParams);
  }
  
  private void aHe()
  {
    ktr localktr = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localktr == null) {}
    while ((localktr.getContentSrc() != 1) || (localktr.a() != null)) {
      return;
    }
    ((ImageView)this.mRootView.findViewById(2131364677)).setImageResource(2130843616);
  }
  
  private void aN(Intent paramIntent)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData != null)
    {
      paramIntent.putExtra("arg_common_comment_info", this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      QLog.d("ReadInJoySecondCommentListFragment", 2, "read to BiuActivity second   commonCommentData :" + this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.toString());
    }
  }
  
  private void initData()
  {
    this.jdField_a_of_type_Ktb = new ktb(getActivity(), this.d, this, this.aLx);
    this.jdField_a_of_type_Ktb.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
    this.d.initFooterView();
    this.d.aGQ();
    this.d.setAdapter(this.jdField_a_of_type_Ktb);
    if (this.jdField_b_of_type_Ksz$b != null) {
      this.jdField_a_of_type_Ktb.a(this.jdField_a_of_type_Ksm$a);
    }
    this.jdField_a_of_type_Ktb.a(new ktd(this));
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.abZ, this.aca, this.mContentSrc);
    }
  }
  
  private void mK(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setVisibility(8);
      this.jZ.setVisibility(0);
      return;
    }
    this.jZ.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  private void mL(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    do
    {
      return;
      localObject1 = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    } while (localObject1 == null);
    Object localObject1 = (CommentData)((ktr)localObject1).a(this.abZ);
    int k = 4;
    int m = 19;
    int i;
    int j;
    if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG == 5)) || (kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
    {
      i = 2;
      j = 20;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag() == -1)) {
        break label362;
      }
      i = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
      j = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData.getAdTag();
    }
    label362:
    for (;;)
    {
      Object localObject2 = ((CommentData)localObject1).commentContent;
      String str = ((CommentData)localObject1).uin;
      localObject2 = kxm.a(new Intent(getActivity(), ReadInJoyDeliverBiuActivity.class), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, i, (String)localObject2, Long.valueOf(str).longValue(), ((CommentData)localObject1).nickName, 0, j);
      ((Intent)localObject2).putExtra("fast_biu_type", paramBoolean);
      aN((Intent)localObject2);
      getActivity().startActivity((Intent)localObject2);
      getActivity().overridePendingTransition(0, 0);
      localObject1 = new krx(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (BaseCommentData)localObject1).a().a(this.abZ).build();
      kbp.a(null, ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800901A", "0X800901A", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject1, false);
      return;
      j = m;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
        break;
      }
      j = m;
      i = k;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a == null) {
        break;
      }
      j = m;
      i = k;
      if (!ReadInJoyDeliverBiuActivity.dj(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.aTa)) {
        break;
      }
      i = 9;
      j = 20;
      break;
    }
  }
  
  private int nH()
  {
    int i = 0;
    if (ayxa.isLiuHaiUseValid()) {
      i = ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    i = muj.l(getActivity()) - i;
    QLog.d("ReadInJoySecondCommentListFragment", 2, "onCreateView | marginTop is " + i);
    return i;
  }
  
  public ksz.g a()
  {
    return this.jdField_a_of_type_Ksz$g;
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString1, String paramString2, int paramInt)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.mContentSrc = paramInt;
    this.abZ = paramString1;
    this.aca = paramString2;
    if (!this.ahp) {
      return;
    }
    if (this.jdField_a_of_type_Ktb != null)
    {
      this.jdField_a_of_type_Ktb.a(paramString1, paramString2, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt);
      paramString2 = this.jdField_a_of_type_Ktb.a();
      if (paramString2 != null) {
        paramString1 = paramString2.a(paramString1);
      }
    }
    for (;;)
    {
      mK(false);
      aHe();
      this.d.resetState();
      paramString1 = new krx(paramArticleInfo, paramString1).a().build();
      kbp.a(null, ksz.a(paramArticleInfo), "0X800901F", "0X800901F", 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, paramString1, false);
      return;
      paramString1 = null;
      continue;
      paramString1 = null;
    }
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(ksz.b paramb, Bundle paramBundle, ksz.g paramg)
  {
    this.jdField_b_of_type_Ksz$b = paramb;
    this.jdField_a_of_type_Ksz$g = paramg;
    setArguments(paramBundle);
  }
  
  public void aHf()
  {
    if (this.ahH) {
      this.jdField_a_of_type_Kxy.wakeUp();
    }
  }
  
  public void aHg()
  {
    if (this.ahH) {
      this.jdField_a_of_type_Kxy.aIc();
    }
  }
  
  public void aHh()
  {
    if (this.jdField_b_of_type_Ksz$b != null) {
      this.jdField_b_of_type_Ksz$b.g(false, null, null);
    }
  }
  
  public void aHi()
  {
    ktr localktr = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localktr != null) {
      localktr.aHp();
    }
  }
  
  public ReadInJoyCommentListView b()
  {
    return this.d;
  }
  
  public void b(CommonCommentData paramCommonCommentData)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void b(ksm.a parama)
  {
    this.jdField_a_of_type_Ksm$a = parama;
  }
  
  public long cl()
  {
    return this.jdField_a_of_type_Kxy.cq();
  }
  
  public void mJ(boolean paramBoolean)
  {
    this.ahv = paramBoolean;
  }
  
  public void mc(String paramString)
  {
    if (this.oS == null) {
      return;
    }
    this.oS.setText(paramString);
    this.oS.setVisibility(0);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    if (this.aeI)
    {
      aHh();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        Object localObject = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        if (localObject != null)
        {
          if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG == 5)) || (kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {}
          for (;;)
          {
            localObject = (CommentData)((ktr)localObject).a(this.abZ);
            if (localObject == null) {
              break;
            }
            localObject = new krx(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (BaseCommentData)localObject).a().a(this.abZ).build();
            kbp.a(null, ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009019", "0X8009019", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
            break;
            if ((!ReadInJoyDeliverBiuActivity.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a == null) || (!ReadInJoyDeliverBiuActivity.dj(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.aTa))) {}
          }
          if (kpn.nx() == 1) {
            bool = true;
          }
          mL(bool);
          continue;
          aGI();
          continue;
          yD();
          if (this.jdField_b_of_type_Ksz$b != null) {
            this.jdField_b_of_type_Ksz$b.g(false, null, null);
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131560457, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131560457, paramViewGroup, false))
    {
      this.eU = ((RelativeLayout)paramLayoutInflater.findViewById(2131379823));
      this.eU.setVisibility(0);
      paramLayoutInflater.findViewById(2131364686).setOnClickListener(this);
      paramLayoutInflater.findViewById(2131369276).setOnClickListener(this);
      paramLayoutInflater.findViewById(2131379769).setOnClickListener(this);
      if (ThemeUtil.isInNightMode(kxm.getAppRuntime())) {
        ((ViewStub)paramLayoutInflater.findViewById(2131376764)).inflate();
      }
      this.d = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131365028));
      this.d.setOnScrollListener(new ktc(this));
      this.jZ = paramLayoutInflater.findViewById(2131365007);
      this.ahp = true;
      this.oS = ((TextView)paramLayoutInflater.findViewById(2131366995));
      initData();
      this.mRootView = paramLayoutInflater;
      aHd();
      kgi.a().a(6666, this);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    if (getActivity() != null) {
      super.onDestroy();
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    if (this.jdField_a_of_type_Ktb != null)
    {
      this.jdField_a_of_type_Ktb.onDestroy();
      this.jdField_a_of_type_Ktb = null;
    }
    this.jdField_b_of_type_Ksz$b = null;
    kgi.a().b(6666, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    try
    {
      Field localField = Fragment.class.getDeclaredField("mChildFragmentManager");
      localField.setAccessible(true);
      localField.set(this, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      throw new RuntimeException(localNoSuchFieldException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_Kxy.aIc();
      if (this.ahH)
      {
        if ((this.jdField_a_of_type_Ktb != null) && (this.jdField_a_of_type_Ktb.a() != null))
        {
          this.jdField_a_of_type_Ktb.a().en(cl());
          this.jdField_a_of_type_Kxy.reset();
        }
        this.ahH = false;
      }
      return;
    }
    this.jdField_a_of_type_Kxy.wakeUp();
    this.ahH = true;
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool = true;
    switch (paramView.getId())
    {
    default: 
      return false;
    }
    if (kpn.ny() == 1) {}
    for (;;)
    {
      mL(bool);
      return false;
      bool = false;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.aeI = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.aeI = false;
  }
  
  public void pB(int paramInt)
  {
    this.aLx = paramInt;
  }
  
  public void setMarginTop(int paramInt)
  {
    this.ZY = paramInt;
  }
  
  public void yD()
  {
    if ((this.mRootView != null) && (this.mRootView.findViewById(2131373497) != null))
    {
      QLog.d("ReadInJoySecondCommentListFragment", 2, "hideMaskView");
      this.mRootView.findViewById(2131373497).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment
 * JD-Core Version:    0.7.0.1
 */