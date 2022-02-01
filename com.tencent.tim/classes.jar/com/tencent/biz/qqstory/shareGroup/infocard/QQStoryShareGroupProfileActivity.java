package com.tencent.biz.qqstory.shareGroup.infocard;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ausj;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqLoadMoreVideoList;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView;
import com.tencent.biz.qqstory.shareGroup.infocard.view.ShareGroupsListView.b;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView.d;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jnm;
import mqq.os.MqqHandler;
import plr;
import pml;
import pnx.d;
import ppf;
import pqs;
import psg;
import psi;
import psn;
import psx;
import pxg.b;
import pxl;
import pxl.c;
import pxm;
import pxm.a;
import pxp;
import pxp.a;
import pxs.b;
import pxw.a;
import pye.a;
import pyg.a;
import qbc;
import qcf;
import qem;
import qgg;
import qha.b;
import qiy;
import qox;
import qpp;
import qpq;
import qpr;
import qps;
import qpt;
import qqa;
import qqa.a;
import qqd;
import qqe;
import quf.b;
import qvd;
import qwq;
import rar;
import roq;
import rpo;
import rpq;
import wja;

public class QQStoryShareGroupProfileActivity
  extends QQStoryBaseActivity
{
  ShareGroupsListView jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView;
  public ShareGroupItem a;
  LoadMoreLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout;
  public qbc a;
  qpp jdField_a_of_type_Qpp;
  qpt jdField_a_of_type_Qpt;
  qqa jdField_a_of_type_Qqa;
  rpo jdField_a_of_type_Rpo;
  boolean aED = false;
  boolean aEE = false;
  boolean aEF = false;
  boolean aEG = false;
  boolean aEH = false;
  boolean aEI = false;
  private boolean aEJ;
  ImageButton aa;
  boolean acL = false;
  String avL;
  String axY;
  public String axZ;
  String aya;
  pxl b;
  TextView bI;
  int bnA = 0;
  int bny;
  int bnz;
  RelativeLayout dR;
  ImmersiveTitleBar2 e;
  TextView kK;
  View mEmptyView;
  public int mFrom;
  ImageView mO;
  ImageView mRightImageView;
  TextView xs;
  TextView xt;
  
  private boolean Kf()
  {
    return this.bnz == 1;
  }
  
  public static Intent a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext = new Intent(paramContext, QQStoryShareGroupProfileActivity.class);
    paramContext.putExtra("extra_share_group_id", paramString1);
    paramContext.putExtra("extra_share_group_type", paramInt1);
    paramContext.putExtra("extra_share_group_from", paramInt2);
    paramContext.putExtra("extra_share_group_play_from", paramInt3);
    paramContext.putExtra("extra_user_group_uin", paramString2);
    return paramContext;
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramContext.startActivity(a(paramContext, paramInt1, paramString1, paramString2, paramInt2, paramInt3));
  }
  
  private void a(pxg.b paramb)
  {
    List localList = c(paramb.mL, paramb.isFirstPage);
    if (paramb.isFirstPage)
    {
      if ((paramb.b.isSuccess()) && (paramb.isUpdated))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.setData(localList, paramb.isEnd);
        if (!paramb.aCu) {
          this.aED = true;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramb.isEnd);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.an(paramb.b.isSuccess(), paramb.isEnd);
      if (!paramb.aCu) {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.isEmpty())
        {
          this.mEmptyView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
          this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(0);
        }
      }
      while (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.isEmpty()) {
        for (;;)
        {
          return;
          this.mEmptyView.setVisibility(8);
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(true);
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(0);
      return;
    }
    if ((paramb.b.isSuccess()) && (paramb.isUpdated)) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.E(localList, paramb.isEnd);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(paramb.b.isSuccess(), paramb.isEnd);
  }
  
  private void a(pxl.c paramc)
  {
    if (paramc.isError) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(0);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, paramc.isEnd);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.an(paramc.b.isSuccess(), paramc.isEnd);
      return;
      if ((paramc.list != null) && (paramc.list.size() > 0))
      {
        if (paramc.aCA) {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.H(paramc.list, paramc.isEnd);
        } else {
          this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.G(paramc.list, paramc.isEnd);
        }
      }
      else if (!paramc.aCA)
      {
        this.mEmptyView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setEnabled(false);
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.bpC();
      }
    }
  }
  
  private void b(pxm.a parama)
  {
    QQToast.a(this, 1, acfp.m(2131712443), 1).show();
  }
  
  private void bpy()
  {
    this.jdField_a_of_type_Qqa = ((qqa)ppf.a(qqa.class, new Object[] { this, Boolean.valueOf(this.aEI) }));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setListAdapter(this.jdField_a_of_type_Qqa);
    k localk = new k(this);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setUIEventListener(localk);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollChangeListener(localk);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setOnScrollListener(localk);
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setLoadMoreState(true, true);
    this.xt.setOnClickListener(localk);
    this.mRightImageView.setOnClickListener(localk);
    this.aa.setOnClickListener(localk);
  }
  
  private void bpz()
  {
    ausj localausj = ausj.b(this);
    if (this.bnz == 1) {
      localausj.addButton(acfp.m(2131712416), 5);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new qpq(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  private void bt(String paramString, int paramInt)
  {
    int k = 0;
    int i;
    int j;
    label24:
    qox localqox;
    if (this.bnz == 1)
    {
      i = 3;
      if (this.bnz != 1) {
        break label123;
      }
      j = 2;
      rar.a("share_story", "clk_add_entry", i, j, new String[] { paramString });
      localqox = new qox(this.app);
      if (!"2".equals(paramString)) {
        break label129;
      }
      i = 2;
    }
    for (;;)
    {
      localqox.a(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.type, this.axY, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.groupUin, paramInt, i);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic())
      {
        i = 2;
        break;
      }
      i = 1;
      break;
      label123:
      j = 1;
      break label24;
      label129:
      i = k;
      if ("5".equals(paramString)) {
        i = 5;
      }
    }
  }
  
  private List<VideoCollectionItem> c(List<VideoCollectionItem> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localVideoCollectionItem1 = (VideoCollectionItem)paramList.next();
      if (localVideoCollectionItem1.collectionCount > 0)
      {
        localVideoCollectionItem2 = new VideoCollectionItem();
        localVideoCollectionItem2.copy(localVideoCollectionItem1);
        localArrayList.add(localVideoCollectionItem2);
      }
    }
    if (!paramBoolean) {
      return localArrayList;
    }
    if (localArrayList.size() < 2) {
      return localArrayList;
    }
    paramList = (VideoCollectionItem)localArrayList.get(0);
    VideoCollectionItem localVideoCollectionItem1 = (VideoCollectionItem)localArrayList.get(1);
    VideoCollectionItem localVideoCollectionItem2 = VideoCollectionItem.getCurrentYearFakeItem(this.axY);
    VideoCollectionItem localVideoCollectionItem3 = VideoCollectionItem.getTodayFakeItem(this.axY);
    if (paramList.collectionType != 0)
    {
      localArrayList.add(0, localVideoCollectionItem2);
      if (!roq.isToday(paramList.collectionTime)) {
        localArrayList.add(1, localVideoCollectionItem3);
      }
      for (;;)
      {
        return localArrayList;
        paramList.collectionVideoUIItemList.add(0, new quf.b());
      }
    }
    if (roq.aZ(paramList.collectionTime)) {
      if (roq.isToday(localVideoCollectionItem1.collectionTime)) {
        localVideoCollectionItem1.collectionVideoUIItemList.add(0, new quf.b());
      }
    }
    for (;;)
    {
      return localArrayList;
      localArrayList.add(1, localVideoCollectionItem3);
      continue;
      localArrayList.add(0, localVideoCollectionItem2);
      localArrayList.add(1, localVideoCollectionItem3);
    }
  }
  
  private void c(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem == null) {}
    label148:
    label286:
    label291:
    label339:
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(0);
      if ((paramShareGroupItem.isInvalid()) || (paramShareGroupItem.type == 2))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mEmptyView.getLayoutParams();
        localLayoutParams.topMargin = 0;
        this.mEmptyView.setLayoutParams(localLayoutParams);
        this.bI.setText(2131701944);
        this.mEmptyView.setVisibility(0);
        this.xs.setText(paramShareGroupItem.name);
        this.jdField_a_of_type_Rpo.aw(true, false);
        return;
      }
      int i;
      boolean bool;
      if ((paramShareGroupItem.type == 2) && (!paramShareGroupItem.isPublic()) && (!paramShareGroupItem.isSubscribe()))
      {
        i = 1;
        if (!this.aEH)
        {
          if ((paramShareGroupItem.type != 2) || (!paramShareGroupItem.isPublic())) {
            break label286;
          }
          bool = true;
          this.aEI = bool;
        }
        if (i == 0) {
          break label291;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(8);
        this.mEmptyView.setVisibility(8);
        this.mRightImageView.setVisibility(8);
        this.xs.setText(plr.asY);
        this.jdField_a_of_type_Rpo.aw(true, false);
        this.aa.setVisibility(8);
      }
      for (;;)
      {
        if (this.acL) {
          break label339;
        }
        this.acL = true;
        rar.a("share_story", "exp_data", paramShareGroupItem.getReportGroupProp(), ppf.getInteger(2131427369), new String[] { paramShareGroupItem.getReportUserType(), this.mFrom + "" });
        return;
        i = 0;
        break;
        bool = false;
        break label148;
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setVisibility(0);
        this.aa.setVisibility(0);
        this.jdField_a_of_type_Rpo.aw(false, false);
        if (!this.aEH)
        {
          this.aEH = true;
          ta(true);
        }
        d(paramShareGroupItem);
      }
    }
  }
  
  private void d(ShareGroupItem paramShareGroupItem)
  {
    if (paramShareGroupItem != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = paramShareGroupItem;
      this.xs.setText(paramShareGroupItem.name);
      if ((paramShareGroupItem.videoCount != 0) && (this.mFrom != 8)) {
        break label54;
      }
      this.mRightImageView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qqa.e(paramShareGroupItem);
      return;
      label54:
      this.mRightImageView.setVisibility(0);
    }
  }
  
  private void h(Intent paramIntent, String paramString)
  {
    int j;
    int k;
    label22:
    int m;
    boolean bool1;
    boolean bool2;
    int i;
    if (this.bnz == 1)
    {
      j = 3;
      if (this.bnz != 1) {
        break label211;
      }
      k = 2;
      m = paramIntent.getIntExtra("totalPublishVideoCount", 1);
      bool1 = paramIntent.getBooleanExtra("isLocalPublish", false);
      bool2 = paramIntent.getBooleanExtra("isTakePhoto", false);
      if (!paramIntent.getBooleanExtra("isAddFromExist", false)) {
        break label217;
      }
      i = 5;
    }
    for (;;)
    {
      rar.a("share_story", "clk_add_suc", j, k, new String[] { paramString, String.valueOf(m), String.valueOf(i) });
      if ((this.mFrom != 8) || (this.bnA != 0)) {
        break label252;
      }
      paramIntent = wja.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      paramIntent.putExtra("uin", this.axZ);
      paramIntent.putExtra("uintype", 1);
      paramIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name);
      paramIntent.addFlags(71303168);
      super.startActivity(paramIntent);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isPublic())
      {
        j = 2;
        break;
      }
      j = 1;
      break;
      label211:
      k = 1;
      break label22;
      label217:
      if (bool1)
      {
        if (bool2) {
          i = 2;
        } else {
          i = 1;
        }
      }
      else if (bool2) {
        i = 4;
      } else {
        i = 3;
      }
    }
    label252:
    if ((this.mFrom == 9) || (this.bnA == 9))
    {
      paramIntent = new Intent(this, TroopStoryMainActivity.class);
      paramIntent.addFlags(71303168);
      startActivity(paramIntent);
      return;
    }
    paramIntent = StoryTransitionActivity.a(this);
    paramIntent.addFlags(71303168);
    super.startActivity(paramIntent);
  }
  
  private void initView()
  {
    View localView = LayoutInflater.from(this).inflate(2131561962, null, false);
    super.setContentViewNoTitle(localView);
    this.jdField_a_of_type_Rpo.u(localView);
    this.jdField_a_of_type_Rpo.aw(false, false);
    this.dR = ((RelativeLayout)super.findViewById(2131379823));
    this.xs = ((TextView)super.findViewById(2131369627));
    this.xt = ((TextView)super.findViewById(2131369579));
    this.mRightImageView = ((ImageView)super.findViewById(2131369594));
    this.kK = ((TextView)super.findViewById(2131369612));
    this.e = ((ImmersiveTitleBar2)super.findViewById(2131379866));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout = ((LoadMoreLayout)super.findViewById(2131370227));
    this.mEmptyView = super.findViewById(2131366438);
    this.mEmptyView.setVisibility(8);
    this.mEmptyView.setBackgroundResource(2130839637);
    this.mO = ((ImageView)super.findViewById(2131366414));
    this.bI = ((TextView)super.findViewById(2131366429));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView = ((ShareGroupsListView)super.findViewById(2131378228));
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setContentBackground(2130839637);
    this.aa = ((ImageButton)super.findViewById(2131375211));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(1);
    this.jdField_a_of_type_Qpp.i(this, this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getRootView());
    bpy();
  }
  
  private void sX(boolean paramBoolean)
  {
    ShareGroupItem localShareGroupItem = ((qqe)psx.a(7)).a(this.axY);
    if ((localShareGroupItem != null) && (!paramBoolean)) {
      c(localShareGroupItem);
    }
    if (this.bnz == 1)
    {
      new pxm(this.axY, this.avL).sendRequest();
      return;
    }
    localShareGroupItem = new ShareGroupItem();
    localShareGroupItem.type = 2;
    c(localShareGroupItem);
  }
  
  private void sY(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qpt == null) {
      this.jdField_a_of_type_Qpt = new qpt(this.axY, this.bnz, this.avL);
    }
    this.jdField_a_of_type_Qpt.onStart();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.isEmpty()) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(1);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Qpt.bqE();
      return;
    }
    this.jdField_a_of_type_Qpt.bqF();
  }
  
  private void ws(int paramInt)
  {
    if (this.aEJ) {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setSelection(paramInt);
    }
    while ((paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getFirstVisiblePosition()) && (paramInt <= this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getLastVisiblePosition())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setSelection(paramInt);
    this.aEJ = true;
  }
  
  public void O(@NonNull Map<Subscriber, String> paramMap)
  {
    super.O(paramMap);
    paramMap.put(new c(this), "");
    paramMap.put(new e(this), "");
    paramMap.put(new d(this), "");
    paramMap.put(new l(this), "");
    paramMap.put(new f(this), "");
    paramMap.put(new a(this), "");
    paramMap.put(new m(this), "");
    paramMap.put(new g(this), "");
    paramMap.put(new i(this), "");
    paramMap.put(new j(this), "");
    paramMap.put(new n(this), "");
    paramMap.put(new b(this), "");
    paramMap.put(new h(this), "");
  }
  
  public boolean a(VideoCollectionItem paramVideoCollectionItem)
  {
    int i = 2;
    if (paramVideoCollectionItem.collectionCount <= paramVideoCollectionItem.collectionVideoUIItemList.size()) {
      return false;
    }
    qqstory_service.ReqLoadMoreVideoList localReqLoadMoreVideoList = new qqstory_service.ReqLoadMoreVideoList();
    localReqLoadMoreVideoList.feed_id.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.feedId));
    Object localObject = localReqLoadMoreVideoList.from;
    if (this.bnz == 2) {}
    for (;;)
    {
      ((PBUInt32Field)localObject).set(i);
      localReqLoadMoreVideoList.start_cookie.set(ByteStringMicro.copyFromUtf8(paramVideoCollectionItem.nextCookie));
      localReqLoadMoreVideoList.video_count.set(10);
      localObject = new Bundle();
      ((Bundle)localObject).putString("extra_feedid", paramVideoCollectionItem.feedId);
      jnm.a(this.app, new qpr(this), localReqLoadMoreVideoList.toByteArray(), ppf.fQ("StoryGroupSvc.datacard_load_more_video"), (Bundle)localObject);
      return true;
      i = 1;
    }
  }
  
  public void bpA()
  {
    if (this.b == null) {
      this.b = new pxl(this.axY);
    }
    this.b.bnz();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      if (this.jdField_a_of_type_Qbc != null) {
        this.jdField_a_of_type_Qbc.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
    case 1003: 
      h(paramIntent, "2");
      return;
    }
    h(paramIntent, "5");
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Rpo = new rpo(this, 20);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.axY = paramBundle.getStringExtra("extra_share_group_id");
    this.bnz = paramBundle.getIntExtra("extra_share_group_type", 1);
    this.axZ = paramBundle.getStringExtra("extra_user_group_uin");
    this.mFrom = paramBundle.getIntExtra("extra_share_group_from", 0);
    this.aya = paramBundle.getStringExtra("extra_share_from_user_uid");
    this.bny = paramBundle.getIntExtra("extra_share_group_play_from", 0);
    this.bnA = paramBundle.getIntExtra("extra_last_open_from", 0);
    this.avL = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Qpp = ((qpp)ppf.a(qpp.class, new Object[0]));
    initView();
    if ((this.bnz == 1) && (TextUtils.isEmpty(this.axY)))
    {
      if (TextUtils.isEmpty(this.axZ))
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_user_group_uin must not be empty!");
        }
        super.finish();
        return false;
      }
      new pxp(this.axZ).sendRequest();
      if (this.mFrom == 5) {
        new Handler(Looper.getMainLooper()).postDelayed(new QQStoryShareGroupProfileActivity.1(this), 200L);
      }
      return true;
    }
    if (TextUtils.isEmpty(this.axY))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "extra_share_group_id must not be empty!");
      }
      super.finish();
      return false;
    }
    if (!Kf()) {}
    for (boolean bool = true;; bool = false)
    {
      sX(bool);
      break;
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.aEF)
    {
      this.aEF = false;
      sX(true);
    }
    if (this.aEE)
    {
      this.aEE = false;
      ta(false);
    }
    while (!this.aEG) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.notifyDataSetChanged();
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  @NonNull
  public String mF()
  {
    return String.valueOf(hashCode());
  }
  
  public void rN(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.bt().iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        if (paramString.equals(((VideoCollectionItem)localIterator.next()).feedId)) {
          ws(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public int sN()
  {
    if (this.bny > 0) {
      return this.bny;
    }
    if (this.bnz == 1) {
      return 88;
    }
    return 87;
  }
  
  public void sZ(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.ob.size() <= 0) {
        break label95;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.G(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.ob, false);
    }
    for (;;)
    {
      if (this.b == null) {
        this.b = new pxl(this.axY);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.isEmpty()) {
        this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLoadMoreLayout.eW(1);
      }
      this.b.bny();
      return;
      label95:
      List localList = ((psi)psx.a(25)).M(this.axY);
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.jdField_a_of_type_Qqa.G(localList, false);
    }
  }
  
  public void ta(boolean paramBoolean)
  {
    if (this.aEI)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), rpq.dip2px(this, 76.0F));
      sZ(paramBoolean);
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.setPadding(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingLeft(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingTop(), this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.getListPaddingRight(), rpq.dip2px(this, 89.0F));
    sY(paramBoolean);
  }
  
  static class a
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, psg>
  {
    public a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull psg parampsg)
    {
      if (!paramQQStoryShareGroupProfileActivity.axY.equals(parampsg.groupId)) {}
      while ((!parampsg.b.isSuccess()) || (TextUtils.isEmpty(parampsg.feedId)) || (!((psn)psx.a(19)).N(parampsg.feedId).contains(parampsg.vid))) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "get delete event. groupId=" + paramQQStoryShareGroupProfileActivity.axY + ", feedId=" + parampsg.feedId);
      }
      ShareGroupItem localShareGroupItem;
      if (paramQQStoryShareGroupProfileActivity.a != null)
      {
        localShareGroupItem = paramQQStoryShareGroupProfileActivity.a;
        int i = localShareGroupItem.videoCount - 1;
        localShareGroupItem.videoCount = i;
        if (i == 0)
        {
          ThreadManager.getUIHandler().postDelayed(new QQStoryShareGroupProfileActivity.DeleteStoryVideoEventReceiver.1(this, paramQQStoryShareGroupProfileActivity), 400L);
          return;
        }
      }
      if (paramQQStoryShareGroupProfileActivity.isResume())
      {
        if (parampsg.aBv)
        {
          localShareGroupItem = ((qqe)psx.a(7)).a(paramQQStoryShareGroupProfileActivity.axY);
          if ((localShareGroupItem != null) && (localShareGroupItem.headerUnionIdList.contains(parampsg.uid))) {
            QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, true);
          }
        }
        paramQQStoryShareGroupProfileActivity.ta(false);
        return;
      }
      if (parampsg.aBv)
      {
        paramQQStoryShareGroupProfileActivity.aEE = true;
        paramQQStoryShareGroupProfileActivity.aEF = true;
        return;
      }
      paramQQStoryShareGroupProfileActivity.aEE = true;
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
  }
  
  public static class b
    extends pml<QQStoryShareGroupProfileActivity, pqs>
  {
    public b(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pqs parampqs)
    {
      if ((parampqs.what != 3) || (parampqs.c == null)) {}
      ArrayList localArrayList;
      label68:
      do
      {
        return;
        int i;
        qqa localqqa;
        HotSortVideoEntry localHotSortVideoEntry;
        if (parampqs.c.mHadLike == 1)
        {
          i = 1;
          localqqa = paramQQStoryShareGroupProfileActivity.a.a;
          Object localObject = paramQQStoryShareGroupProfileActivity.a.a.ob;
          localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localHotSortVideoEntry = (HotSortVideoEntry)((Iterator)localObject).next();
          } while (!localHotSortVideoEntry.feedId.equals(parampqs.feedId));
          if (i == 0) {
            break label164;
          }
        }
        for (int j = localHotSortVideoEntry.likeCount + 1;; j = localHotSortVideoEntry.likeCount - 1)
        {
          localHotSortVideoEntry.likeCount = j;
          if (localHotSortVideoEntry.likeCount < 0) {
            localHotSortVideoEntry.likeCount = 0;
          }
          localqqa.b(localHotSortVideoEntry);
          localArrayList.add(localHotSortVideoEntry);
          break label68;
          i = 0;
          break;
        }
      } while (localArrayList.size() <= 0);
      label164:
      ((psi)psx.a(25)).updateList(localArrayList);
      paramQQStoryShareGroupProfileActivity.aEG = true;
    }
    
    public Class acceptEventClass()
    {
      return pqs.class;
    }
    
    public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pqs parampqs) {}
  }
  
  static class c
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pxg.b>
  {
    public c(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public Class acceptEventClass()
    {
      return pxg.b.class;
    }
    
    public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pxg.b paramb)
    {
      if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.avL, paramb.context)) {}
      while ((paramb.aCu) && (paramQQStoryShareGroupProfileActivity.aED)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onGetShareGroupVideos: 是否来自缓存=" + paramb.aCu + " groupId=" + paramQQStoryShareGroupProfileActivity.axY + ", event=" + paramb.toString());
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramb);
    }
  }
  
  static class d
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pxm.a>
  {
    public d(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public Class acceptEventClass()
    {
      return pxm.a.class;
    }
    
    public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pxm.a parama)
    {
      if (!TextUtils.equals(paramQQStoryShareGroupProfileActivity.avL, parama.avL)) {
        return;
      }
      if ((parama.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "update sharegroup info: " + parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.toString());
        }
        QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, parama.jdField_b_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
        return;
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, parama);
    }
  }
  
  static class e
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pye.a>
  {
    public e(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pye.a parama)
    {
      if (parama.b.isSuccess()) {
        paramQQStoryShareGroupProfileActivity.a.a(parama);
      }
    }
    
    public Class acceptEventClass()
    {
      return pye.a.class;
    }
  }
  
  static class f
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pxp.a>
  {
    public f(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pxp.a parama)
    {
      if ((TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.axY)) && (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.axZ)) && (parama.b.isSuccess()) && (!parama.mU.isEmpty()))
      {
        parama = parama.mU.iterator();
        while (parama.hasNext())
        {
          qqd localqqd = (qqd)parama.next();
          if (paramQQStoryShareGroupProfileActivity.axZ.equals(localqqd.QD))
          {
            paramQQStoryShareGroupProfileActivity.axY = localqqd.ayb;
            if (QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity)) {
              break label111;
            }
          }
        }
      }
      label111:
      for (boolean bool = true;; bool = false)
      {
        QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, bool);
        return;
      }
    }
    
    public Class acceptEventClass()
    {
      return pxp.a.class;
    }
  }
  
  public static class g
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pxl.c>
  {
    public g(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public Class acceptEventClass()
    {
      return pxl.c.class;
    }
    
    public void b(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pxl.c paramc)
    {
      if (!paramQQStoryShareGroupProfileActivity.aEI) {
        return;
      }
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramc);
    }
  }
  
  public static class h
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, qiy>
  {
    public h(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull qiy paramqiy)
    {
      if ((paramQQStoryShareGroupProfileActivity.mF().equals(paramqiy.axu)) && ((paramqiy.a instanceof qha.b)))
      {
        paramqiy = ((qha.b)paramqiy.a).a;
        if (paramqiy != null) {
          paramQQStoryShareGroupProfileActivity.rN(paramqiy.mFeedId);
        }
      }
    }
    
    public Class acceptEventClass()
    {
      return qiy.class;
    }
  }
  
  public static class i
    extends QQUIEventReceiver<IEventReceiver, pxw.a>
  {
    public i(@NonNull IEventReceiver paramIEventReceiver)
    {
      super();
    }
    
    public void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull pxw.a parama)
    {
      if (parama.b.isSuccess())
      {
        QQToast.a(qem.getApplicationContext(), 2, acfp.m(2131712435), 0).show();
        rar.a("play_video", "report_suc", 0, 0, new String[] { String.valueOf(parama.blk), "5" });
        return;
      }
      QQToast.a(qem.getApplicationContext(), 1, acfp.m(2131712430), 0).show();
      rar.a("play_video", "report_fail", 0, 0, new String[] { "", "5" });
    }
    
    public Class acceptEventClass()
    {
      return pxw.a.class;
    }
  }
  
  public static class j
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pnx.d>
  {
    public j(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pnx.d paramd)
    {
      paramd = paramd.b;
      if (paramd == null) {}
      while (qwq.dY(paramd.mUploadStatus) != 3) {
        return;
      }
      paramQQStoryShareGroupProfileActivity.aEE = true;
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
  }
  
  public static class k
    implements View.OnClickListener, ShareGroupsListView.b, AbsListView.e, ListView.d
  {
    private final long Bh = 500L;
    private long Bi;
    private final QQStoryShareGroupProfileActivity b;
    
    public k(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      this.b = paramQQStoryShareGroupProfileActivity;
    }
    
    private void j(View paramView, String paramString)
    {
      Object localObject = this.b.axY;
      localObject = this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.ob;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      int j = 0;
      while (i < ((List)localObject).size())
      {
        HotSortVideoEntry localHotSortVideoEntry = (HotSortVideoEntry)((List)localObject).get(i);
        localArrayList1.add(localHotSortVideoEntry.feedId);
        localArrayList2.add(localHotSortVideoEntry.storyId);
        if (paramString.equals(localHotSortVideoEntry.storyId)) {
          j = i;
        }
        i += 1;
      }
      if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
      {
        localObject = new OpenPlayerBuilder(new VidListPlayInfo(localArrayList1, localArrayList2, (String)localArrayList1.get(j), (String)localArrayList2.get(j)), 88);
        qgg.a(this.b, ((OpenPlayerBuilder)localObject).b(), paramView);
      }
      rar.a("share_story", "clk_video_card", 0, 0, new String[] { this.b.axY, paramString });
    }
    
    public void a(String paramString1, int paramInt, View paramView, String paramString2)
    {
      if (System.currentTimeMillis() - this.Bi < 500L) {}
      for (;;)
      {
        return;
        if (this.b.aEI)
        {
          j(paramView, paramString2);
          return;
        }
        String str = this.b.axY;
        psn localpsn = (psn)psx.a(19);
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = localpsn.a(str, localArrayList1);
        if ((localArrayList2 != null) && (localArrayList2.size() != 0))
        {
          paramInt = localArrayList2.indexOf(paramString1);
          paramString1 = localpsn.a(str);
          if ((paramString1 != null) && (paramString1.isEnd == 1)) {}
          for (boolean bool = true; this.b.bnz == 1; bool = false)
          {
            paramString1 = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(str, (String)localArrayList1.get(paramInt), paramString2, String.valueOf(this.b.jdField_a_of_type_Qpt.hashCode()), localArrayList2, bool, this.b.bnz), this.b.sN());
            paramString1.a(this.b.mF());
            qgg.a(this.b, paramString1.b(), paramView);
            return;
          }
        }
      }
    }
    
    public void a(String paramString1, long paramLong, StoryVideoItem paramStoryVideoItem, int paramInt, String paramString2, List<String> paramList)
    {
      if (rpq.isFastDoubleClick()) {
        return;
      }
      if (this.b.jdField_a_of_type_Qbc == null) {
        this.b.jdField_a_of_type_Qbc = qbc.a(this.b);
      }
      this.b.jdField_a_of_type_Qbc.a(acfp.m(2131712441) + plr.asY + acfp.m(2131712413)).a(qcf.a(this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem, paramStoryVideoItem, paramString1, paramLong, paramInt)).a(new qps(this)).b();
      rar.a("share_story", "share_day", 0, 0, new String[] { this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.getReportUserType() });
    }
    
    public void aSa()
    {
      if (this.b.aEI) {
        this.b.bpA();
      }
      while (this.b.jdField_a_of_type_Qpt == null) {
        return;
      }
      this.b.jdField_a_of_type_Qpt.c(this.b.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.a());
    }
    
    public void bpB()
    {
      QQStoryShareGroupProfileActivity.a(this.b, "2", 1003);
    }
    
    public void dL(View paramView) {}
    
    public void dM(View paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "QQStoryShareGroupProfileActivity onHeaderItemClick!");
      }
    }
    
    public boolean fm(String paramString)
    {
      VideoCollectionItem localVideoCollectionItem = ((psn)psx.a(19)).a(paramString);
      if (localVideoCollectionItem != null) {
        return this.b.a(localVideoCollectionItem);
      }
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.shareGroup.QQStoryShareGroupProfileActivity", 2, "onLoadMore: videoCollectionItem is null, collectionId:" + paramString);
      }
      return false;
    }
    
    public void j(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        QQStoryShareGroupProfileActivity.a(this.b, "5", 1004);
        continue;
        this.b.finish();
        continue;
        QQStoryShareGroupProfileActivity.a(this.b);
      }
    }
    
    public void onPullRefresh()
    {
      QQStoryShareGroupProfileActivity.a(this.b, true);
      this.b.ta(false);
    }
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      this.b.jdField_a_of_type_Rpo.onListViewScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
    
    public void rO(String paramString)
    {
      if (this.b.jdField_a_of_type_Qpt != null) {
        this.b.jdField_a_of_type_Qpt.rZ(paramString);
      }
    }
  }
  
  static class l
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pxs.b>
  {
    public l(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pxs.b paramb)
    {
      if ((paramb.b.isSuccess()) && (paramb.mX != null) && (!paramb.mX.isEmpty()) && (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null))
      {
        if (!paramQQStoryShareGroupProfileActivity.aEI) {
          break label54;
        }
        paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewShareGroupsListView.a.notifyDataSetChanged();
      }
      label54:
      int j;
      do
      {
        return;
        j = 0;
        int i = j;
        Object localObject;
        if (paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList != null)
        {
          i = j;
          if (!paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.isEmpty())
          {
            localObject = paramb.mX.iterator();
            QQUserUIItem localQQUserUIItem;
            do
            {
              i = j;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              localQQUserUIItem = (QQUserUIItem)((Iterator)localObject).next();
            } while (!paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.contains(localQQUserUIItem.uid));
            i = 1;
          }
        }
        j = i;
        if (!TextUtils.isEmpty(paramQQStoryShareGroupProfileActivity.aya))
        {
          paramb = paramb.mX.iterator();
          do
          {
            j = i;
            if (!paramb.hasNext()) {
              break;
            }
            localObject = (QQUserUIItem)paramb.next();
          } while (!paramQQStoryShareGroupProfileActivity.aya.equals(((QQUserUIItem)localObject).uid));
          j = 1;
        }
      } while (j == 0);
      QQStoryShareGroupProfileActivity.a(paramQQStoryShareGroupProfileActivity, paramQQStoryShareGroupProfileActivity.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem);
    }
    
    public Class acceptEventClass()
    {
      return pxs.b.class;
    }
  }
  
  public static class m
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, qqa.a>
  {
    public m(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull qqa.a parama)
    {
      if (parama.sortType == 1)
      {
        paramQQStoryShareGroupProfileActivity.aEI = true;
        paramQQStoryShareGroupProfileActivity.a.bpC();
        paramQQStoryShareGroupProfileActivity.ta(true);
        parama = paramQQStoryShareGroupProfileActivity.axY;
        if (!paramQQStoryShareGroupProfileActivity.aEI) {
          break label82;
        }
      }
      label82:
      for (paramQQStoryShareGroupProfileActivity = "1";; paramQQStoryShareGroupProfileActivity = "2")
      {
        rar.a("share_story", "clk_rank", 0, 0, new String[] { parama, paramQQStoryShareGroupProfileActivity });
        return;
        if (parama.sortType != 0) {
          break;
        }
        paramQQStoryShareGroupProfileActivity.aEI = false;
        paramQQStoryShareGroupProfileActivity.aED = false;
        break;
      }
    }
    
    public Class acceptEventClass()
    {
      return qqa.a.class;
    }
  }
  
  public static class n
    extends QQUIEventReceiver<QQStoryShareGroupProfileActivity, pyg.a>
  {
    public n(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity)
    {
      super();
    }
    
    public void a(@NonNull QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity, @NonNull pyg.a parama)
    {
      if (!paramQQStoryShareGroupProfileActivity.aEI) {}
      qqa localqqa;
      Object localObject1;
      do
      {
        return;
        Object localObject2 = null;
        localqqa = paramQQStoryShareGroupProfileActivity.a.a;
        Iterator localIterator = paramQQStoryShareGroupProfileActivity.a.a.ob.iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (HotSortVideoEntry)localIterator.next();
        } while (!((HotSortVideoEntry)localObject1).storyId.equals(parama.vid));
      } while (localObject1 == null);
      ((HotSortVideoEntry)localObject1).viewCount += 1;
      ((psi)psx.a(25)).a((HotSortVideoEntry)localObject1);
      localqqa.b((HotSortVideoEntry)localObject1);
      paramQQStoryShareGroupProfileActivity.aEG = true;
    }
    
    public Class acceptEventClass()
    {
      return pyg.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity
 * JD-Core Version:    0.7.0.1
 */