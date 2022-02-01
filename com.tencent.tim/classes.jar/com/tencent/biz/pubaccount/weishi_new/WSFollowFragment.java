package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stFeed;
import UserGrowth.stSimpleMetaFeed;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import auwm;
import com.tencent.biz.pubaccount.weishi_new.event.FollowEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSAddCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSVideoPlayEvent;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import oey;
import oez;
import ofa;
import ofb;
import ofc;
import ogr;
import ohl;
import oie;
import oiv;
import oix;
import oiy;
import ojg;
import ojm;
import okd;
import ole;
import olh;
import oli;
import olu;
import omg;
import ond;
import onf;
import ong;
import onk;
import oor;
import ooz;
import opn;
import osv;

public class WSFollowFragment
  extends WSBaseHomeFragment<omg, olu, List<stFeed>>
  implements oix, omg
{
  public static boolean awK;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private oey jdField_a_of_type_Oey;
  public ohl a;
  private boolean awL;
  private boolean awM;
  private boolean awN;
  private boolean awO;
  private boolean en;
  private LinearLayout eu;
  private LinearLayoutManager mLayoutManager;
  private long yH;
  
  private ojm a(int paramInt, boolean paramBoolean)
  {
    int i;
    if (this.jdField_a_of_type_Oey != null)
    {
      i = paramInt;
      if (paramInt >= 0) {}
    }
    else
    {
      return null;
    }
    ojm localojm;
    do
    {
      i += 1;
      if (i >= this.jdField_a_of_type_Oey.be().size()) {
        break;
      }
      localojm = c(i, paramBoolean);
    } while (localojm == null);
    return localojm;
    return null;
  }
  
  private void a(ojm paramojm)
  {
    this.jdField_a_of_type_Oey.a(paramojm);
    this.awL = false;
  }
  
  private boolean a(ojm paramojm)
  {
    if (paramojm == null) {}
    while (oor.h(paramojm.p()) < 50) {
      return false;
    }
    return true;
  }
  
  private ojm b(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (paramInt < 0) {
      return null;
    }
    ojm localojm;
    do
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      localojm = c(i, paramBoolean);
    } while (localojm == null);
    return localojm;
  }
  
  private void bdZ()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = new WSPlayerManager(opn.getQQAppInterface());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.oE(true);
    this.jdField_a_of_type_Oey.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager);
  }
  
  private void bea()
  {
    if (!this.en)
    {
      oni.bfu = 2;
      return;
    }
    if ((!this.awN) && (!this.awO))
    {
      oni.bfu = 3;
      return;
    }
    oni.bfu = 1;
  }
  
  private void beb()
  {
    int i = this.mLayoutManager.findFirstVisibleItemPosition();
    int j = this.mLayoutManager.findLastVisibleItemPosition();
    if ((i < 0) || (j >= this.jdField_a_of_type_Oey.be().size())) {
      return;
    }
    label37:
    RecyclerView.ViewHolder localViewHolder;
    if (i <= j)
    {
      localViewHolder = this.b.a().findViewHolderForAdapterPosition(i);
      if (!(localViewHolder instanceof oiy)) {
        break label75;
      }
      ((oiy)localViewHolder).aCG();
    }
    for (;;)
    {
      i += 1;
      break label37;
      break;
      label75:
      if ((localViewHolder instanceof ojg)) {
        ((ojg)localViewHolder).aCG();
      }
    }
  }
  
  private ojm c(int paramInt, boolean paramBoolean)
  {
    Object localObject = (stFeed)this.jdField_a_of_type_Oey.be().get(paramInt);
    if ((((stFeed)localObject).feed_type == 2) && (((stFeed)localObject).feed != null))
    {
      localObject = this.b.a().findViewHolderForLayoutPosition(paramInt);
      if ((localObject instanceof ojm))
      {
        localObject = (ojm)localObject;
        if ((a((ojm)localObject)) || (paramBoolean)) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  private void initEvent()
  {
    oiv.a().a(this);
  }
  
  private void showErrorView()
  {
    ooz.d("WSFollowFragment", "showErrorView");
    this.eu.setVisibility(0);
    ond.a(135, 1, null);
    ong.qT(false);
    this.eu.setOnClickListener(new ofb(this));
  }
  
  protected RecyclerView.LayoutManager a()
  {
    this.mLayoutManager = new ofc(this.mContext, 1, false);
    return this.mLayoutManager;
  }
  
  protected auwm a()
  {
    this.jdField_a_of_type_Oey = new oey(this);
    return this.jdField_a_of_type_Oey;
  }
  
  public XRecyclerView a()
  {
    return this.b;
  }
  
  public oey a()
  {
    return this.jdField_a_of_type_Oey;
  }
  
  public ojm a(ojm paramojm, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramojm != null)
    {
      int i = paramojm.getLayoutPosition();
      if (paramBoolean1) {
        return a(i + 1, paramBoolean2);
      }
      return b(i - 1, paramBoolean2);
    }
    return null;
  }
  
  @NonNull
  public olu a()
  {
    return new olu();
  }
  
  public void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    RecyclerView.ViewHolder localViewHolder = this.b.a().findViewHolderForAdapterPosition(paramInt);
    if ((localViewHolder instanceof oiy)) {
      ((oiy)localViewHolder).c(paramstSimpleMetaFeed);
    }
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    ((olu)this.jdField_a_of_type_Oeu).a(paramWSSimpleBaseEvent);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt)
  {
    ((olu)b()).ai(false, false);
  }
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean)
  {
    if (!this.awN) {
      this.awN = true;
    }
    ((olu)b()).ai(false, true);
  }
  
  public void a(ojm paramojm, String paramString1, String paramString2)
  {
    ole localole = oie.a().a();
    if (localole == null) {}
    while ((paramojm == null) || (localole.c == null) || (localole.mVideoView == null) || (paramojm.b == null) || (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager == null)) {
      return;
    }
    paramojm.b.c = localole.c;
    paramojm.b.mVideoView = localole.mVideoView;
    paramojm.b.jdField_a_of_type_Oll = localole.jdField_a_of_type_Oll;
    paramojm.b.c.setLoopback(true);
    this.jdField_a_of_type_Oey.a = paramojm;
    osv.a(paramString1, paramString2, paramojm.b, false);
    onf.o(paramojm.b);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(paramojm.b, true);
    ooz.i("WSFollowContinuePlayLog", "WSFollowFragment handleOnActivityResultFromVertical()2, title: " + paramojm.b.jdField_a_of_type_Oli.mTitle + ", playingHolder: " + paramojm);
  }
  
  protected void aCB()
  {
    this.awL = true;
  }
  
  protected void aS(Bundle paramBundle) {}
  
  public void ag(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_Oey != null) && (this.jdField_a_of_type_Oey.be().size() == 0)) {
      showErrorView();
    }
  }
  
  public void ah(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_a_of_type_Oey.addFooterView(View.inflate(getActivity(), 2131560580, null));
    }
    this.b.ad(paramBoolean1, paramBoolean2);
  }
  
  protected void bdX()
  {
    super.bdX();
    if (this.isVisible) {
      opn.pQ("focus");
    }
  }
  
  public void c(ojm paramojm)
  {
    if ((this.awL) && (a(paramojm)))
    {
      paramojm.b.mVideoView = null;
      ooz.w("WSFollowContinuePlayLog", "[WSFollowFragment.java][onPlayFirstVideo] playVideo title:" + paramojm.jdField_a_of_type_Oli.mTitle + ", mPlayingHolder:" + paramojm);
      a(paramojm);
      paramojm = a(paramojm, true, true);
      ooz.i("WS_VIDEO_PRE_PLAY", "[WSFollowFragment.java][onPlayFirstVideo] setPrePlayingHolder prePlayHolder:" + paramojm);
      this.jdField_a_of_type_Oey.b(paramojm);
    }
  }
  
  protected void dr(View paramView)
  {
    ogr.a().b(new oez(this));
    bdZ();
    initEvent();
    paramView = (FrameLayout)this.mView.findViewById(2131369433);
    this.eu = ((LinearLayout)this.mView.findViewById(2131370766));
    if (this.jdField_a_of_type_Ohl == null)
    {
      this.jdField_a_of_type_Ohl = new ohl(this, 0);
      ViewStub localViewStub = new ViewStub(getActivity());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 80;
      localViewStub.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_Ohl.b(localViewStub);
      paramView.addView(localViewStub);
    }
    this.b.a().addOnScrollListener(new ofa(this));
  }
  
  public void dw(List<stFeed> paramList)
  {
    hideLoading();
    if (this.eu.isShown()) {
      this.eu.setVisibility(8);
    }
    if (this.jdField_a_of_type_Oey != null) {
      this.jdField_a_of_type_Oey.D(paramList);
    }
    oie.a().init(paramList);
    if (this.b != null) {
      this.b.ad(true, true);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(LikeRspEvent.class);
    localArrayList.add(WSVideoPlayEvent.class);
    localArrayList.add(WSItemExposeEvent.class);
    localArrayList.add(FollowEvent.class);
    localArrayList.add(WSAddCommentEvent.class);
    return localArrayList;
  }
  
  public void ie()
  {
    ((olu)b()).ai(true, false);
  }
  
  public void of(int paramInt)
  {
    super.of(paramInt);
    StringBuilder localStringBuilder = new StringBuilder().append("onTabSelected: ");
    if (paramInt == 0) {}
    for (String str = "follow";; str = "recommend")
    {
      ooz.d("WSFollowFragment", str);
      if (paramInt == 0) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.isPlaying()) {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.stop();
      }
      return;
    }
    this.awL = true;
    c(a(this.mLayoutManager.findFirstVisibleItemPosition(), false));
    beb();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 4097) && (paramInt2 == 8193))
    {
      this.awM = true;
      paramInt1 = paramIntent.getIntExtra("key_feed_position", 0);
      String str = paramIntent.getStringExtra("key_from");
      paramIntent = paramIntent.getStringExtra("key_play_scene");
      ooz.bY("WSFollowContinuePlayLog", "[WSFollowFragment.java][onActivityResult] from vertical position:" + paramInt1);
      ThreadManager.getUIHandler().postDelayed(new WSFollowFragment.3(this, str, paramIntent), 100L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.yH = System.currentTimeMillis();
    ooz.i("weishi-beacon", "进入瀑布流的时间：" + this.yH);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    bea();
    ogr.a().dz(this.jdField_a_of_type_Oey.be());
    oiv.a().b(this);
    okd.a().release();
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.qR(true);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = null;
    }
    this.b.a().clearOnScrollListeners();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.isVisible) {
      WSPublicAccReport.getInstance().reportPageVisitExit("focus");
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) && (!awK)) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.doOnPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.isVisible) {
      WSPublicAccReport.getInstance().reportPageVisitEnter("focus");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.doOnResume();
    }
    if (this.yH > 0L)
    {
      long l = System.currentTimeMillis() - this.yH;
      this.yH = 0L;
      ooz.i("weishi-beacon", "关注页初始化耗时：" + l);
      onk.a().a(true, l, "focus", "focus");
    }
  }
  
  public void qy(boolean paramBoolean)
  {
    this.b.pn(paramBoolean);
  }
  
  public void r(List<stFeed> paramList, boolean paramBoolean)
  {
    if (this.eu.isShown()) {
      this.eu.setVisibility(8);
    }
    this.jdField_a_of_type_Oey.E(paramList);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ah(true, paramBoolean);
      return;
    }
  }
  
  public void setData(List<stFeed> paramList)
  {
    this.en = true;
    if (this.eu.isShown()) {
      this.eu.setVisibility(8);
    }
    this.jdField_a_of_type_Oey.D(paramList);
    ah(true, true);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    ooz.d("WSFollowFragment", "setUserVisibleHint entered! visible: " + paramBoolean + ", isResumed: " + isResumed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment
 * JD-Core Version:    0.7.0.1
 */