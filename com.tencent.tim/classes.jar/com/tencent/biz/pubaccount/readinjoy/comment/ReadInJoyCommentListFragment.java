package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRequestData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.LayoutInflateProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.e;
import kbp;
import kgi;
import kgi.b;
import kqd;
import kqx;
import ksj.a;
import ksk.a;
import ksm;
import ksn;
import kso;
import ksp;
import ksq;
import ksr;
import kss;
import kst;
import ksx;
import ksz;
import ksz.b;
import ksz.c;
import ksz.d;
import ksz.e;
import ktr;
import kuy;
import kva;
import kva.a;
import kxm;
import kxy;
import kyq;
import lcc;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentListFragment
  extends PublicBaseFragment
  implements View.OnClickListener, ReadInJoyCommentTopGestureLayout.a, kgi.b, ksz.b
{
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b;
  private ReadInJoyCommentListView.a jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$a;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private LayoutInflateProcessor jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor;
  private kqd jdField_a_of_type_Kqd;
  private ksj.a jdField_a_of_type_Ksj$a;
  private ksm jdField_a_of_type_Ksm;
  private ksz.d jdField_a_of_type_Ksz$d;
  private ksz.e jdField_a_of_type_Ksz$e;
  private kva jdField_a_of_type_Kva;
  private kxy jdField_a_of_type_Kxy = new kxy();
  public int aLB = 2131377881;
  private int aLC = 1;
  private int aLD = 5;
  private int aLx = 0;
  private ViewGroup aT;
  private String abY = "";
  private FrameLayout af;
  private boolean ahm;
  private boolean ahp;
  private boolean ahq;
  private boolean ahr;
  private boolean ahs;
  private boolean aht;
  private boolean ahu;
  private boolean ahv;
  private boolean ahw;
  private boolean ahx = true;
  private ReadInJoyCommentListView jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private CommonCommentData jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData;
  private ArticleInfo jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private String[] bj = { "huawei_vog-al00", "huawei_vog-al10", "huawei_ele-al00", "samsung_sm-g9750" };
  private LinearLayout dA;
  private RelativeLayout eU;
  private AbsListView.e i = new ksn(this);
  private View jQ;
  private View jR;
  private View jS;
  private View jT;
  private View jU;
  private View jV;
  private View jW;
  private View jX;
  private int mContentSrc;
  private View mLoadingView;
  private View mRootView;
  private TextView oR;
  private TextView oS;
  
  private FragmentTransaction a()
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.ahw)
    {
      localObject1 = localObject2;
      if (getChildFragmentManager() != null) {
        localObject1 = getChildFragmentManager().beginTransaction();
      }
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (getActivity() == null);
      localObject1 = localObject2;
    } while (getActivity().getSupportFragmentManager() == null);
    return getActivity().getSupportFragmentManager().beginTransaction();
  }
  
  public static void a(Intent paramIntent, kqd paramkqd, int paramInt1, boolean paramBoolean, ArticleInfo paramArticleInfo, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    QLog.d("ReadInJoyCommentListFragment", 1, "contentSrc = " + paramInt1 + " isBiu = " + paramBoolean);
    String str = paramIntent.getStringExtra("arg_result_json");
    paramIntent = "";
    Object localObject4 = "";
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject5 = new JSONObject(str);
        str = ((JSONObject)localObject5).optString("comment");
        Object localObject1;
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          bool1 = ((JSONObject)localObject5).optBoolean("select_to_friend");
          bool2 = bool3;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            Object localObject2;
            bool1 = false;
          }
        }
        try
        {
          localObject1 = ((JSONObject)localObject5).optString("commentId");
          bool2 = bool3;
          paramIntent = (Intent)localObject1;
          bool3 = ((JSONObject)localObject5).optBoolean("isSecondReply");
          bool2 = bool3;
          paramIntent = (Intent)localObject1;
          localObject5 = ((JSONObject)localObject5).optString("replyUin");
          localObject4 = localObject5;
          paramIntent = (Intent)localObject1;
          bool2 = bool3;
          localObject1 = localObject4;
          if (!TextUtils.isEmpty(str))
          {
            localObject4 = new RIJBiuAndCommentRequestData();
            ((RIJBiuAndCommentRequestData)localObject4).setBiu(paramBoolean);
            ((RIJBiuAndCommentRequestData)localObject4).setContentSrc(paramInt1);
            ((RIJBiuAndCommentRequestData)localObject4).setContentString(str);
            ((RIJBiuAndCommentRequestData)localObject4).setDiffuseToFriends(bool1);
            if (paramArticleInfo != null) {
              break label278;
            }
            str = "";
            ((RIJBiuAndCommentRequestData)localObject4).setRowKey(str);
            ((RIJBiuAndCommentRequestData)localObject4).setListShowType(paramInt2);
            ((RIJBiuAndCommentRequestData)localObject4).setCommentType(paramInt3);
            ((RIJBiuAndCommentRequestData)localObject4).setReplyCommentId(paramIntent);
            ((RIJBiuAndCommentRequestData)localObject4).setIsSecondReply(bool2);
            ((RIJBiuAndCommentRequestData)localObject4).setReplyUin((String)localObject1);
            paramkqd.a(paramArticleInfo, (RIJBiuAndCommentRequestData)localObject4);
          }
          return;
        }
        catch (JSONException localJSONException3)
        {
          break label266;
        }
        localJSONException1 = localJSONException1;
        str = "";
        bool1 = false;
      }
      label266:
      localObject2 = localObject4;
      continue;
      label278:
      str = paramArticleInfo.innerUniqueID;
      continue;
      str = "";
      bool3 = false;
      Object localObject3 = localObject4;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  private void a(AnchorData paramAnchorData)
  {
    if ((paramAnchorData != null) && (!TextUtils.isEmpty(paramAnchorData.acb)))
    {
      QLog.d("ReadInJoyCommentListFragment", 1, "initAnchor " + paramAnchorData.acb);
      if ((!TextUtils.isEmpty(paramAnchorData.acd)) && (!paramAnchorData.ahJ))
      {
        this.mRootView.setAlpha(0.0F);
        FragmentTransaction localFragmentTransaction = a();
        if (localFragmentTransaction != null)
        {
          localFragmentTransaction.setCustomAnimations(2130772416, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramAnchorData.acb, paramAnchorData.acd, this.mContentSrc);
          localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
          localFragmentTransaction.commitAllowingStateLoss();
        }
        this.aLC = 2;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jR, false);
        ThreadManager.getUIHandler().postDelayed(new ReadInJoyCommentListFragment.2(this), 1000L);
      }
      this.jdField_a_of_type_Ksm.a(new kso(this));
    }
  }
  
  private boolean a(boolean paramBoolean, kva.a parama)
  {
    if (this.jdField_a_of_type_Kva == null) {
      this.jdField_a_of_type_Kva = new kva(getActivity(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if ((!paramBoolean) || ((!this.jdField_a_of_type_Kva.dw(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)) && (kyq.Bj())))
    {
      this.jdField_a_of_type_Kva.a(new kss(this, parama));
      this.jdField_a_of_type_Ksm.aGt();
      this.jdField_a_of_type_Kva.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_Kva.aO(getActivity().getWindow().getDecorView());
      return true;
    }
    return false;
  }
  
  private void aGB()
  {
    if ((this.jQ != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLE > 0))
    {
      this.jQ.setPadding(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLE, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLF);
      QLog.d("ReadInJoyCommentListFragment", 0, "setPaddingTop : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLE);
    }
  }
  
  private void aGC()
  {
    if ((this.ahv) && (this.eU != null)) {
      this.eU.setVisibility(8);
    }
  }
  
  private void aGD()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.pB(this.aLx);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.mJ(this.ahv);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.setMarginTop(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLG);
      QLog.d("ReadInJoyCommentListFragment", 0, "initSubCommentFragment | setMarginTop " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLG);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new ksp(this));
    localObject = a();
    if (localObject != null)
    {
      ((FragmentTransaction)localObject).add(this.aLB, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  private void aGE()
  {
    boolean bool2 = true;
    Bundle localBundle = getArguments();
    if (localBundle == null) {}
    do
    {
      return;
      this.ahw = localBundle.getBoolean("arg_comment_is_fragment_container", false);
      this.ahs = localBundle.getBoolean("arg_comment_list_comment_btn", false);
      this.aht = localBundle.getBoolean("arg_comment_list_biu_btn", false);
      this.ahu = localBundle.getBoolean("arg_comment_list_share_btn", false);
      this.ahr = localBundle.getBoolean("readinjoy_open_comment_with_edit_panel", false);
      this.ahx = getActivity().getIntent().getBooleanExtra(kqx.READINJOY_IS_INDEPENDENT_COMPONENTS, true);
      this.ahv = localBundle.getBoolean("fromViola");
    } while (!this.ahv);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b = new b();
    }
    this.ahx = false;
    this.aLD = localBundle.getInt("serviceType");
    b localb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b;
    if (!localBundle.getBoolean("isHiddenFirstPageEditorBar", false))
    {
      bool1 = true;
      localb.ahz = bool1;
      localb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b;
      if (localBundle.getBoolean("isHiddenHeaderRow", false)) {
        break label344;
      }
      bool1 = true;
      label186:
      localb.ahA = bool1;
      localb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b;
      if (localBundle.getBoolean("isHiddenSecPageEditorBar", false)) {
        break label349;
      }
      bool1 = true;
      label211:
      localb.ahB = bool1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLE = localBundle.getInt("padding_top");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLF = localBundle.getInt("margin_bottom");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLG = localBundle.getInt("secPageOffsetY");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLH = localBundle.getInt("secPageShowDirection", 2);
      localb = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b;
      if (localBundle.getInt("isHiddenSecPageMaskView", 0) != 0) {
        break label354;
      }
    }
    label344:
    label349:
    label354:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localb.ahC = bool1;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.getParcelable("articleInfo"));
      this.mContentSrc = localBundle.getInt("source");
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = ((CommonCommentData)localBundle.getSerializable("commonCommentData"));
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label186;
      bool1 = false;
      break label211;
    }
  }
  
  private void aGF()
  {
    LinearLayout localLinearLayout;
    if (this.dA != null)
    {
      localLinearLayout = this.dA;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.ahz)) {
        break label37;
      }
    }
    label37:
    for (int j = 0;; j = 8)
    {
      localLinearLayout.setVisibility(j);
      return;
    }
  }
  
  private void aGI()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.smoothScrollBy(0, 0);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelection(0);
  }
  
  private void aGJ()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      String str = new ksz.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).b(this.aLx).e(1).build();
      kbp.a(null, ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
    }
  }
  
  private void aGL()
  {
    if (this.jdField_a_of_type_Kqd != null) {
      this.jdField_a_of_type_Kqd.clear();
    }
    this.jdField_a_of_type_Kqd = new kqd();
    this.jdField_a_of_type_Kqd.a(new kst(this));
  }
  
  private void aGz()
  {
    this.jU = LayoutInflater.from(getActivity()).inflate(2131562912, null, false);
    this.jV = this.jU.findViewById(2131372412);
    this.jX = this.jU.findViewById(2131372429);
    this.jW = this.jU.findViewById(2131370805);
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) && (this.ahv)) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.addHeaderView(this.jU);
    }
  }
  
  private boolean c(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    int k = paramArrayOfString.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (paramArrayOfString[j].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  private void ch(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.jT = paramView.findViewById(2131372412);
    this.jT.setOnClickListener(this);
    this.jS = paramView.findViewById(2131372429);
    this.jS.setOnClickListener(this);
    this.mLoadingView = paramView.findViewById(2131374329);
    this.mLoadingView.setOnClickListener(null);
  }
  
  private void ci(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$a = new ReadInJoyCommentListView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$a.c(this.i);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView$a);
    paramView.findViewById(2131364686).setOnClickListener(this);
    paramView.findViewById(2131369276).setOnClickListener(this);
    paramView.findViewById(2131379769).setOnClickListener(this);
    paramView.findViewById(2131372413).setOnClickListener(this);
    if (this.jdField_a_of_type_Ksz$e != null) {
      this.jdField_a_of_type_Ksz$e.cl(paramView);
    }
    kgi.a().a(6666, this);
  }
  
  private void cj(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)paramView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, this.ahx);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jQ, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    if (this.ahx) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setBackgroundResource(2130842536);
    }
  }
  
  private void ck(View paramView)
  {
    View localView;
    if (this.ahs)
    {
      localView = paramView.findViewById(2131364997);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.ahu)
    {
      localView = paramView.findViewById(2131378178);
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    if (this.aht)
    {
      paramView = paramView.findViewById(2131363543);
      paramView.setVisibility(0);
      paramView.setOnClickListener(this);
    }
  }
  
  private void initAdapter()
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.initFooterView();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGQ();
    this.jdField_a_of_type_Ksm = new ksm(getActivity(), this, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.mContentSrc);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Ksm);
  }
  
  private void mG(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ksj$a != null) {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (paramBoolean) {}
        for (String str = "1";; str = "2")
        {
          localJSONObject.put("replyViewStatus", str);
          this.jdField_a_of_type_Ksj$a.onViewState(paramBoolean, localJSONObject.toString());
          QLog.d("ReadInJoyCommentListFragment", 0, "notifySecondCommentViewStateChanged | visible " + paramBoolean + "; jsonStr " + localJSONObject.toString());
          return;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.d("ReadInJoyCommentListFragment", 0, "notifySecondCommentViewStateChanged " + localJSONException.getMessage());
      }
    }
  }
  
  private int nF()
  {
    ktr localktr = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    if (localktr != null) {
      return (int)localktr.cm();
    }
    return -1;
  }
  
  public boolean Aw()
  {
    return this.ahv;
  }
  
  public boolean Ax()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.ahA;
    }
    return true;
  }
  
  public ReadInJoyCommentListView a()
  {
    return this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  }
  
  public ksz.d a()
  {
    return this.jdField_a_of_type_Ksz$d;
  }
  
  public void a(Bundle paramBundle, ksz.d paramd, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Ksz$d = paramd;
    this.aT = paramViewGroup;
    setArguments(paramBundle);
  }
  
  public void a(a parama)
  {
    if (parama != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$a = parama;
    }
  }
  
  public void a(CommonCommentData paramCommonCommentData)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData = paramCommonCommentData;
  }
  
  public void a(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt)
  {
    b(paramArticleInfo, paramAnchorData, paramBoolean, 5, paramInt);
  }
  
  public void a(LayoutInflateProcessor paramLayoutInflateProcessor)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor = paramLayoutInflateProcessor;
  }
  
  public void a(ksj.a parama)
  {
    this.jdField_a_of_type_Ksj$a = parama;
  }
  
  public void a(ksk.a parama)
  {
    if (this.jdField_a_of_type_Ksm != null) {
      this.jdField_a_of_type_Ksm.a(parama);
    }
  }
  
  public void aGA()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      if (this.aLD == 0) {
        break label74;
      }
    }
    label74:
    for (int j = this.aLD;; j = 5)
    {
      QLog.d("ReadInJoyCommentListFragment", 0, "fetchCommentDataByViola by viola feedstype " + j + "contentSrc " + this.mContentSrc);
      b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, true, j, this.mContentSrc);
      return;
    }
  }
  
  public void aGG()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {}
    while (a(true, new ksq(this))) {
      return;
    }
    int j = 4;
    if (((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType == 1) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.aSG == 5)) || (kxm.j(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo))) {
      j = 2;
    }
    for (;;)
    {
      ksz.a(getActivity(), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null, j, "", this.abY, false, this.jdField_a_of_type_Ksz$d, -1, this.ahm);
      return;
      if ((ReadInJoyDeliverBiuActivity.d(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a != null))
      {
        if (ReadInJoyDeliverBiuActivity.dj(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.aTa)) {
          j = 9;
        }
      }
      else if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mIsGallery != 0) {
        j = 17;
      }
    }
  }
  
  public void aGH()
  {
    if ((this.jdField_a_of_type_Ksm != null) && (this.jdField_a_of_type_Ksm.a() != null))
    {
      this.jdField_a_of_type_Ksm.a().X(ck(), 2);
      this.jdField_a_of_type_Ksm.a().resetData();
    }
  }
  
  public void aGK()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) && (this.jdField_a_of_type_Ksm != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.ahK) {
        this.jdField_a_of_type_Ksm.aGw();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ksm.aGv();
  }
  
  public void aGt()
  {
    if (this.af != null) {
      this.af.setVisibility(0);
    }
  }
  
  public void aGu()
  {
    this.mRootView.findViewById(2131373497).setVisibility(8);
  }
  
  public void b(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    b(paramArticleInfo, paramAnchorData, true, 5, paramInt);
  }
  
  public void b(ArticleInfo paramArticleInfo, AnchorData paramAnchorData, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.ahm = paramBoolean;
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      ktr localktr = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (localktr != null) {
        localktr.a().a(false, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      }
      ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt1);
    }
    this.jdField_a_of_type_Kxy.wakeUp();
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = paramAnchorData;
    if (!this.ahp) {
      return;
    }
    this.ahq = true;
    if (!aqiw.isNetworkAvailable(getActivity())) {
      pC(3);
    }
    for (;;)
    {
      a(paramAnchorData);
      this.jdField_a_of_type_Ksm.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentDataCommonCommentData);
      this.jdField_a_of_type_Ksm.a(paramArticleInfo, paramAnchorData, paramBoolean, paramInt1, paramInt2);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.resetState();
      aGJ();
      aGL();
      return;
      pC(1);
    }
  }
  
  public long ck()
  {
    long l = 0L;
    if (this.jdField_a_of_type_Kxy != null)
    {
      l = this.jdField_a_of_type_Kxy.cq();
      this.jdField_a_of_type_Kxy.reset();
    }
    return l;
  }
  
  public void cw(int paramInt1, int paramInt2)
  {
    QQAppInterface localQQAppInterface;
    String str2;
    if (paramInt1 == 2)
    {
      g(false, null, null);
      localQQAppInterface = (QQAppInterface)getActivity().getAppInterface();
      str2 = ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (this.mContentSrc != 2) {
        break label100;
      }
    }
    label100:
    for (String str1 = "1";; str1 = "2")
    {
      kbp.a(localQQAppInterface, str2, "0X800920E", "0X800920E", 0, 0, str1, String.valueOf(paramInt1), "", "", false);
      return;
      if (paramInt1 != 1) {
        break;
      }
      aGH();
      if (this.jdField_a_of_type_Ksz$d == null) {
        break;
      }
      this.jdField_a_of_type_Ksz$d.mI(false);
      break;
    }
  }
  
  public void g(boolean paramBoolean, String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyCommentListFragment", 0, "setSubCommentFragmentVisible | visible " + paramBoolean);
    mG(paramBoolean);
    if (!paramBoolean)
    {
      paramString1 = a();
      if (paramString1 != null)
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLH == 2))
        {
          paramString1.setCustomAnimations(2130772415, 0);
          paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.aHi();
          paramString1.commitAllowingStateLoss();
        }
      }
      else
      {
        this.aLC = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jQ, true);
        this.jdField_a_of_type_Ksm.notifyDataSetChanged();
        this.jdField_a_of_type_Kxy.wakeUp();
        if (this.ahv) {
          this.af.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      paramString1.setCustomAnimations(2130771993, 2130772028);
      break;
      this.jdField_a_of_type_Kxy.aIc();
    } while (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
    FragmentTransaction localFragmentTransaction = a();
    if (localFragmentTransaction != null)
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b.aLH != 2)) {
        break label298;
      }
      localFragmentTransaction.setCustomAnimations(2130772415, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, this.mContentSrc);
      localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.aLC = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.b());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jR, false);
      if (!this.ahv) {
        break;
      }
      this.af.setVisibility(0);
      return;
      label298:
      localFragmentTransaction.setCustomAnimations(2130771993, 2130772028);
    }
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
    int j = 2;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
    {
      str = paramIntent.getStringExtra("arg_result_json");
      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
      paramInt2 = paramIntent.getIntExtra("comment_cmd", 0);
      paramIntent = ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      if (paramIntent != null) {}
    }
    while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699))
    {
      String str;
      do
      {
        do
        {
          return;
          if (paramInt2 == 1)
          {
            a(false, new ksr(this));
            return;
          }
        } while (this.jdField_a_of_type_Ksm == null);
        if (paramInt1 == 2)
        {
          paramIntent.aB(str, this.jdField_a_of_type_Ksm.nI());
          return;
        }
      } while (paramInt1 != 3);
      paramIntent.aA(str, this.jdField_a_of_type_Ksm.nI());
      return;
    }
    paramInt1 = j;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      paramInt1 = 1;
    }
    a(paramIntent, this.jdField_a_of_type_Kqd, this.mContentSrc, true, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ksm.nI(), paramInt1);
  }
  
  public boolean onBackEvent()
  {
    return onBackPress();
  }
  
  public boolean onBackPress()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.aLC == 2)
    {
      g(false, null, null);
      bool1 = true;
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return bool1;
          if (this.jdField_a_of_type_Ksz$d != null)
          {
            this.jdField_a_of_type_Ksz$d.pM(nF());
            this.jdField_a_of_type_Ksm.aLy = 0;
          }
          localObject = getActivity();
          bool1 = bool2;
        } while (localObject == null);
        localObject = ((Activity)localObject).getIntent().getBundleExtra("bundle");
        bool1 = bool2;
      } while (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null);
      bool1 = bool2;
    } while (localObject == null);
    lcc.a().i(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "onPanelClose", ((Bundle)localObject).getInt("seq"));
    return false;
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
      if (this.jdField_a_of_type_Ksz$d != null)
      {
        this.jdField_a_of_type_Ksz$d.onClick(paramView);
        this.jdField_a_of_type_Ksz$d.pM(nF());
        this.jdField_a_of_type_Ksm.aLy = 0;
        this.jdField_a_of_type_Kxy.aIc();
        continue;
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
        {
          aGG();
          if (paramView.getId() == 2131369276)
          {
            String str = new ksz.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).b(this.aLx).build();
            kbp.a((QQAppInterface)getActivity().getAppInterface(), ksz.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X800900C", "0X800900C", 0, 0, String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, str, false);
            continue;
            if (this.jdField_a_of_type_Ksm != null)
            {
              pC(1);
              this.jdField_a_of_type_Ksm.aGs();
              continue;
              aGI();
              continue;
              g(false, null, null);
            }
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor != null) {}
    for (paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLayoutInflateProcessor.a(2131560287, true, new ViewGroup.LayoutParams(-1, -1));; paramLayoutInflater = paramLayoutInflater.inflate(2131560287, paramViewGroup, false))
    {
      this.mRootView = paramLayoutInflater;
      this.jQ = paramLayoutInflater;
      this.jR = paramLayoutInflater.findViewById(this.aLB);
      this.oR = ((TextView)paramLayoutInflater.findViewById(2131380622));
      this.dA = ((LinearLayout)paramLayoutInflater.findViewById(2131363629));
      if (this.oR.getPaint() != null) {
        this.oR.getPaint().setFakeBoldText(true);
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)paramLayoutInflater.findViewById(2131365028));
      this.oS = ((TextView)paramLayoutInflater.findViewById(2131366995));
      this.af = ((FrameLayout)this.mRootView.findViewById(2131373497));
      this.af.setOnClickListener(this);
      this.eU = ((RelativeLayout)this.mRootView.findViewById(2131370755));
      aGE();
      if (this.ahx)
      {
        paramLayoutInflater.setFitsSystemWindows(false);
        this.jQ = this.aT;
      }
      pC(1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$b != null)
      {
        aGC();
        aGF();
        aGB();
      }
      ck(paramLayoutInflater);
      initAdapter();
      aGD();
      cj(paramLayoutInflater);
      ci(paramLayoutInflater);
      if (this.ahr) {
        aGG();
      }
      if (ThemeUtil.isInNightMode(getActivity().app))
      {
        paramViewGroup = new View(getActivity());
        paramViewGroup.setBackgroundColor(1996488704);
        getActivity().addContentView(paramViewGroup, new ViewGroup.LayoutParams(-1, -1));
      }
      this.ahp = true;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$a.onViewCreated(this.ahp);
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!this.ahv))
      {
        b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, this.ahm, 5, this.mContentSrc);
        QLog.d("ReadInJoyCommentListFragment", 0, "onCreateView | fetchCommentDataByViola");
      }
      ch(paramLayoutInflater);
      aGz();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Ksm != null)
    {
      this.jdField_a_of_type_Ksm.onDestroy();
      this.jdField_a_of_type_Ksm = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = null;
    }
    this.jdField_a_of_type_Ksz$d = null;
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment$a = null;
    Bundle localBundle = getActivity().getIntent().getBundleExtra("bundle");
    if (localBundle != null) {
      lcc.a().qz(localBundle.getInt("seq"));
    }
    if (this.jdField_a_of_type_Kqd != null) {
      this.jdField_a_of_type_Kqd.clear();
    }
    kgi.a().b(6666, this);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Kxy.aIc();
      return;
    }
    this.jdField_a_of_type_Kxy.wakeUp();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    if ((this.aLC == 1) && (this.ahp) && (this.ahq)) {
      this.jdField_a_of_type_Kxy.wakeUp();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.aHf();
    }
    QLog.d("ReadInJoyCommentListFragment", 0, "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      this.jdField_a_of_type_Kxy.aIc();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.aHg();
    }
    if ((getActivity() != null) && (getActivity().isFinishing()) && (this.jdField_a_of_type_Ksm != null))
    {
      ktr.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ksm.nI());
      QLog.d("ReadInJoyCommentListFragment", 1, "onStop | removeCommentDataManager feedsType " + this.jdField_a_of_type_Ksm.nI());
    }
  }
  
  public void pB(int paramInt)
  {
    this.mContentSrc = paramInt;
    this.aLx = paramInt;
  }
  
  public void pC(int paramInt)
  {
    if (this.jQ == null) {}
    while ((this.jdField_a_of_type_Ksm == null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView == null)) {
      return;
    }
    if (this.jT != null) {
      this.jT.setVisibility(8);
    }
    if (this.jS != null) {
      this.jS.setVisibility(8);
    }
    if (this.mLoadingView != null) {
      this.mLoadingView.setVisibility(8);
    }
    if (this.jU != null)
    {
      if (this.jX != null) {
        this.jX.setVisibility(8);
      }
      if (this.jV != null) {
        this.jV.setVisibility(8);
      }
      if (this.jW != null) {
        this.jW.setVisibility(8);
      }
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeaderViewsCount() > 0)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        if (this.jW != null) {
          this.jW.setVisibility(0);
        }
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader loadingView");
        return;
      case 3: 
        if (this.jX != null) {
          this.jX.setVisibility(0);
        }
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noNetworkView");
        return;
      case 2: 
        if (this.jV != null) {
          this.jV.setVisibility(0);
        }
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null) {
          this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mH(false);
        }
        QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | hasHeader noCommentView");
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
        return;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.mLoadingView);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader loadingView");
      return;
    case 3: 
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jS);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noNetworkView");
      return;
    case 2: 
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jT);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.aGS();
      QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(this.jT);
    QLog.d("ReadInJoyCommentListFragment", 0, "updateCommentListState | noHeader noContentView");
  }
  
  public void pD(int paramInt)
  {
    this.aLB = paramInt;
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    String str;
    long l;
    Object localObject1;
    if ((this.mContentSrc == 2) && (getView() != null))
    {
      str = (Build.MANUFACTURER + "_" + Build.MODEL).toLowerCase();
      l = Aladdin.getConfig(259).getIntegerFromString("comment_setFitsSystemWindows_switch", 1);
      localObject1 = Aladdin.getConfig(259).getString("comment_setFitsSystemWindows_phone_list", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label156;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ((String)localObject1).split("\\|");
        Object localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = this.bj;
        }
        if ((l == 1L) && (!c(str, (String[])localObject3))) {
          getView().setFitsSystemWindows(paramBoolean);
        }
        getView().setPadding(0, 0, 0, 0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      label156:
      Object localObject2 = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onViewCreated(boolean paramBoolean);
  }
  
  public static class b
  {
    public int aLE;
    public int aLF;
    public int aLG;
    public int aLH = 1;
    public boolean ahA = true;
    public boolean ahB = true;
    public boolean ahC = true;
    public boolean ahz = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment
 * JD-Core Version:    0.7.0.1
 */