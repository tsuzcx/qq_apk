package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import aczy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqha;
import avpw;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.event.SubscribePublishFeedsEvent;
import com.tencent.biz.subscribe.event.UserStateUpdateEvent;
import com.tencent.biz.subscribe.widget.StatusView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import rwv;
import rwx;
import rxn.b;
import rxt;
import ryh;
import ryo;
import rzd;
import rze;
import san;
import sbp;
import set;
import seu;
import sev;
import shg;
import sox;
import sqn;

public class SubscribePersonalDetailFragment
  extends SubscribeBaseFragment
  implements View.OnClickListener, rwx
{
  private long CN;
  private long CO;
  private CertifiedAccountRead.StGetMainPageRsp jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
  private BlockContainer jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer;
  private a jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$a;
  private RelativePersonalDetailHeadItemView jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView;
  private ryh jdField_a_of_type_Ryh;
  private sbp jdField_a_of_type_Sbp;
  private LinearLayout fj;
  private String mUserId;
  private ImageView nV;
  private ImageView nW;
  private ImageView nX;
  private TextView zK;
  
  private boolean MF()
  {
    return fi(4);
  }
  
  private void a(rxt paramrxt)
  {
    if (paramrxt == null) {}
    do
    {
      return;
      if (paramrxt.Mg())
      {
        ux(true);
        return;
      }
    } while (!paramrxt.Mh());
    ux(false);
  }
  
  private void aRa()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setBackgroundColor(getResources().getColor(2131167654));
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
    }
  }
  
  private void bcy()
  {
    boolean bool2 = true;
    SubscribeBaseBottomPersonalFragment.a locala;
    if ((MF()) && (isOwner()) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() > 0))
    {
      this.nV.setVisibility(0);
      sqn.b(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_exp", 0, 0, new String[] { "", "" });
      if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
      {
        locala = new SubscribeBaseBottomPersonalFragment.a();
        locala.lb = a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.isFinish.get() != 1) {
          break label284;
        }
        bool1 = true;
        label134:
        locala.isFinish = bool1;
        locala.extInfo = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.extInfo;
        locala.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
        locala.e = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get());
        locala.key = "share_key_subscribe_opus";
        if ((isAdded()) && (getActivity().app != null)) {
          if ((!shg.a().fV(getActivity().app.getAccount())) || (!isOwner())) {
            break label289;
          }
        }
      }
    }
    label284:
    label289:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.aLa = bool1;
      locala.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp;
      locala.aDM = this.mUserId;
      if (this.jdField_a_of_type_Sbp != null) {
        this.jdField_a_of_type_Sbp.setShareData("share_key_subscribe_opus", new rxn.b(locala));
      }
      return;
      this.nV.setVisibility(8);
      break;
      bool1 = false;
      break label134;
    }
  }
  
  private void byg()
  {
    if (this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer != null)
    {
      this.jdField_a_of_type_Ryh = new set(this, null);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Ryh);
      this.jdField_a_of_type_Sbp = new sbp(null);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a(this.jdField_a_of_type_Sbp);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableRefresh(true);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setEnableLoadMore(false);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.setExtraTypeInfo(this.mExtraTypeInfo);
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.start();
    }
  }
  
  private boolean fi(int paramInt)
  {
    int j = 48;
    int i = j;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      i = j;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user != null)
      {
        String str = Long.toBinaryString(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get());
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          i = j;
          if (str.length() > paramInt) {
            i = str.charAt(str.length() - 1 - paramInt);
          }
        }
      }
    }
    return i == 49;
  }
  
  private void initView()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView = new RelativePersonalDetailHeadItemView(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setExtraTypeInfo(this.mExtraTypeInfo);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setHostActivity(getActivity());
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setPostUserData(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster);
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer = ((BlockContainer)this.mContentView.findViewById(2131377248));
    this.nV = ((ImageView)this.mContentView.findViewById(2131373810));
    this.nV.setOnClickListener(this);
    this.nW = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369903));
    this.nX = ((ImageView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369811));
    this.fj = ((LinearLayout)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131370660));
    this.zK = ((TextView)this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369810));
    byg();
    this.nW.setOnClickListener(this);
    this.nX.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.findViewById(2131369671).setOnClickListener(this);
    if (getActivity() != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$a = new a(null);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_reload_get_main_page");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$a, localIntentFilter);
    }
    rwv.a().a(this);
  }
  
  private boolean isOwner()
  {
    return fi(1);
  }
  
  private void ta(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.P(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp);
      if (!VSNetworkHelper.fQ(paramString)) {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativePersonalDetailHeadItemView.setCardReport(true);
      }
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null)
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.type.get() == 1)
      {
        this.nX.setVisibility(0);
        this.nW.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.nX.setVisibility(8);
    if (rze.bj(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.attr.get()))
    {
      this.nW.setVisibility(0);
      sqn.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "exp_shoplist", 0, 0, new String[0]);
      return;
    }
    this.nW.setVisibility(8);
  }
  
  private void ux(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null)) {
      this.mUserId = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get();
    }
    this.CN = System.currentTimeMillis();
    SubscribePersonalDetailRequest localSubscribePersonalDetailRequest = new SubscribePersonalDetailRequest(this.mUserId, null);
    seu localseu = new seu(this);
    if ((ryo.exists("1001" + this.mUserId)) && (paramBoolean))
    {
      ryo.a("1001" + this.mUserId, new sev(this, localseu));
      return;
    }
    localSubscribePersonalDetailRequest.setEnableCache(paramBoolean);
    VSNetworkHelper.a().a(localSubscribePersonalDetailRequest, localseu);
  }
  
  private void uy(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().hideLoadingView();
    if ((!paramBoolean) && (isAdded())) {
      this.jdField_a_of_type_ComTencentBizRichframeworkPartBlockBlockContainer.a().qH(getResources().getString(2131703530));
    }
  }
  
  protected TextView D()
  {
    return this.zK;
  }
  
  protected List<CertifiedAccountMeta.StFeed> a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return ((CertifiedAccountRead.StGetMainPageRsp)paramObject).vecFeed.get();
  }
  
  protected View aE()
  {
    if ((this.fj != null) && (this.fj.getChildCount() > 0))
    {
      int i = this.fj.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = this.fj.getChildAt(i);
        if (localView.getVisibility() == 0) {
          return localView;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  protected void dC(View paramView)
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.status.set(2);
    }
    aRa();
    hideTitleBar();
    initView();
    avpw.eBx();
  }
  
  public int getContentLayoutId()
  {
    return 2131558851;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribePublishFeedsEvent.class);
    return localArrayList;
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    switch (paramView.getId())
    {
    default: 
    case 2131373810: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (sox.i("subscribe_publish_feed_button", 2000L));
      if (Build.VERSION.SDK_INT < 23) {
        break;
      }
    }
    for (boolean bool1 = aczy.bd(getActivity());; bool1 = true)
    {
      if (!bool1)
      {
        aqha.b(getActivity());
        break;
      }
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("postUin", this.mUserId);
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.size() > 0)) {
        if (((CertifiedAccountMeta.StYouZanShop)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.youZhan.get(0)).type.get() <= 1) {
          break label246;
        }
      }
      label246:
      for (bool1 = true;; bool1 = false)
      {
        ((Intent)localObject).putExtra("has_shop", bool1);
        avpw.i(getActivity(), (Intent)localObject, 0);
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
          break;
        }
        sqn.b(((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.get()).id.get(), "auth_person", "post_clk", 0, 0, new String[] { "", "" });
        break;
      }
      onBackEvent();
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      rzd.sW(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.yzOrderPage.get());
      sqn.c(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.user.id.get(), "auth_person", "clk_shoplist", 0, 0, new String[0]);
      break;
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp == null) {
        break;
      }
      localObject = new san();
      if (!isOwner())
      {
        bool1 = true;
        label337:
        ((san)localObject).ayK = bool1;
        ((san)localObject).shareFromType = 1;
        if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$StGetMainPageRsp.vecFeed.get().size() <= 0) || (!isOwner())) {
          break label396;
        }
      }
      label396:
      for (bool1 = bool2;; bool1 = false)
      {
        ((san)localObject).aKJ = bool1;
        a((san)localObject);
        break;
        bool1 = false;
        break label337;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$a != null)) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizSubscribeFragmentsSubscribePersonalDetailFragment$a);
    }
    rwv.a().b(this);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.CO;
      sqn.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_person", "exp", 0, 0, new String[] { "", l1 - l2 + "" });
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof SubscribePublishFeedsEvent)) && (((SubscribePublishFeedsEvent)paramSimpleBaseEvent).mState == 1))
    {
      paramSimpleBaseEvent = ((SubscribePublishFeedsEvent)paramSimpleBaseEvent).mFeed;
      if (paramSimpleBaseEvent != null) {
        getMainHandler().post(new SubscribePersonalDetailFragment.4(this, paramSimpleBaseEvent));
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.CO = System.currentTimeMillis();
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((paramIntent != null) && (TextUtils.equals(paramIntent.getAction(), "action_reload_get_main_page")))
      {
        SubscribePersonalDetailFragment.b(SubscribePersonalDetailFragment.this, false);
        rwv.a().a(new UserStateUpdateEvent());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment
 * JD-Core Version:    0.7.0.1
 */