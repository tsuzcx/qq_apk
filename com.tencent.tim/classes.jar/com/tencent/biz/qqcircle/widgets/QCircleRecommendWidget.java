package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ankt;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oux;
import ovd;
import pbu;
import pci;
import pcl;
import pgw;
import pgx;
import pgy;
import pgz;
import pha;
import qqcircle.QQCircleDitto.StButton;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;
import rwv;
import rwx;
import rxx;

public class QCircleRecommendWidget
  extends BaseWidgetView
{
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a;
  private QQCircleDitto.StItemContainer jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer;
  private ReportExtraTypeInfo b = new ReportExtraTypeInfo();
  private RecyclerView l;
  private RecyclerView.LayoutManager mLayoutManager;
  private ImageView ml;
  private TextView wF;
  
  public QCircleRecommendWidget(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
  }
  
  @Deprecated
  public void P(Object paramObject) {}
  
  public void bindData(Object paramObject, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed;
    FeedCloudMeta.StDittoFeed localStDittoFeed;
    if (((paramObject instanceof FeedCloudMeta.StFeed)) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a != null))
    {
      localStFeed = (FeedCloudMeta.StFeed)paramObject;
      localStDittoFeed = ((FeedCloudMeta.StFeed)localStFeed.get()).dittoFeed;
      this.b.mFeed = ((FeedCloudMeta.StFeed)paramObject);
      this.b.mPlayScene = 1;
      this.b.mDataPosition = paramInt;
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer = new QQCircleDitto.StItemContainer();
    }
    try
    {
      this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.mergeFrom(localStDittoFeed.dittoData.get().toByteArray());
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a.a(localStFeed, paramInt, this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.get());
      }
      QLog.d("QCircleRecommendWidget", 1, new Object[] { "bind dittoFeed pos:", Integer.valueOf(paramInt), ",item size:", Integer.valueOf(this.jdField_a_of_type_QqcircleQQCircleDitto$StItemContainer.items.size()) });
      return;
    }
    catch (Exception paramObject)
    {
      QLog.e("QCircleRecommendWidget", 1, new Object[] { "bindData Exception:", paramObject.toString() });
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    if (paramView != null)
    {
      this.ml = ((ImageView)paramView.findViewById(2131373901));
      pgw localpgw = new pgw(this);
      this.ml.setOnClickListener(localpgw);
      this.wF = ((TextView)paramView.findViewById(2131373886));
      this.wF.setOnClickListener(localpgw);
      this.l = ((RecyclerView)paramView.findViewById(2131373899));
      this.mLayoutManager = new rxx(paramContext, 0, false);
      this.l.setLayoutManager(this.mLayoutManager);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a = new a();
      this.l.setAdapter(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a.setRecycleView(this.l);
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a.a(this);
      this.l.addOnScrollListener(new pgx(this));
    }
  }
  
  public int getLayoutId()
  {
    return 2131560904;
  }
  
  public class a
    extends RecyclerView.Adapter<QCircleRecommendWidget.b>
    implements rwx
  {
    pci jdField_a_of_type_Pci;
    private QCircleRecommendWidget b;
    private int bgA;
    private FeedCloudMeta.StFeed f;
    private List<QQCircleDitto.StItemInfo> mDatas = new ArrayList();
    private RecyclerView mRecycleView;
    
    public a() {}
    
    private List<QQCircleDitto.StItemInfo> ag(List<QQCircleDitto.StItemInfo> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)paramList.next();
          if ((localStItemInfo != null) && (localStItemInfo.buttonInfo.buttonValue.get() == 0) && (!pbu.a().getUinFollowed(localStItemInfo.id.get()))) {
            localArrayList.add(localStItemInfo);
          }
        }
      }
      return localArrayList;
    }
    
    private void bim()
    {
      if (this.mRecycleView != null)
      {
        if (this.mRecycleView.isComputingLayout()) {
          this.mRecycleView.postDelayed(new QCircleRecommendWidget.QCircleRecommendAdapter.1(this), 500L);
        }
      }
      else {
        return;
      }
      notifyDataSetChanged();
    }
    
    private void bkS()
    {
      if (this.f != null)
      {
        FeedCloudMeta.StDittoFeed localStDittoFeed = new FeedCloudMeta.StDittoFeed();
        localStDittoFeed.dittoId.set(1);
        QCircleRecommendWidget.a(QCircleRecommendWidget.this).items.set(this.mDatas);
        localStDittoFeed.dittoData.set(ByteStringMicro.copyFrom(ovd.a(QCircleRecommendWidget.a(QCircleRecommendWidget.this)).toByteArray()));
        this.f.dittoFeed.set(localStDittoFeed);
      }
    }
    
    public QCircleRecommendWidget.b a(ViewGroup paramViewGroup, int paramInt)
    {
      return new QCircleRecommendWidget.b(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560948, paramViewGroup, false));
    }
    
    public void a(QCircleRecommendWidget.b paramb)
    {
      super.onViewAttachedToWindow(paramb);
      if (this.jdField_a_of_type_Pci != null) {
        this.jdField_a_of_type_Pci.a(paramb);
      }
      rwv.a().a(this);
    }
    
    public void a(QCircleRecommendWidget.b paramb, int paramInt)
    {
      if (this.mDatas.size() > paramInt)
      {
        paramb.a(this);
        paramb.k(this.f);
        paramb.setData(this.mDatas.get(paramInt), paramInt);
        paramb.vA(this.bgA);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramb.itemView.getLayoutParams();
        if ((paramInt > 0) && (paramInt <= this.mDatas.size() - 1)) {
          localLayoutParams.setMargins(ankt.dip2px(-10.0F), 0, 0, 0);
        }
        paramb.itemView.setLayoutParams(localLayoutParams);
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramb, paramInt, getItemId(paramInt));
    }
    
    public void a(QCircleRecommendWidget paramQCircleRecommendWidget)
    {
      this.b = paramQCircleRecommendWidget;
    }
    
    public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt, List<QQCircleDitto.StItemInfo> paramList)
    {
      this.f = paramStFeed;
      this.bgA = paramInt;
      if (this.jdField_a_of_type_Pci != null) {
        this.jdField_a_of_type_Pci.a(this.f, this.bgA);
      }
      if (this.mDatas != null)
      {
        this.mDatas.clear();
        this.mDatas.addAll(ag(paramList));
        paramStFeed = this.b;
        if (!this.mDatas.isEmpty()) {
          break label93;
        }
      }
      label93:
      for (paramInt = 8;; paramInt = 0)
      {
        paramStFeed.setVisibility(paramInt);
        bim();
        return;
      }
    }
    
    public void af(Object paramObject)
    {
      int i;
      if ((paramObject instanceof QQCircleDitto.StItemInfo))
      {
        paramObject = ((QQCircleDitto.StItemInfo)paramObject).id.get();
        i = 0;
        if (i >= this.mDatas.size()) {
          break label148;
        }
        Object localObject = this.mDatas.get(i);
        if ((!(localObject instanceof QQCircleDitto.StItemInfo)) || (!((QQCircleDitto.StItemInfo)localObject).id.get().equals(paramObject))) {
          break label141;
        }
      }
      for (;;)
      {
        if (i >= 0)
        {
          QLog.d("QCircleRecommendWidget", 4, "remove index: " + i);
          this.mDatas.remove(i);
          notifyItemRemoved(i);
          bkS();
          if (this.mDatas.size() <= 0) {
            this.b.setVisibility(8);
          }
        }
        return;
        label141:
        i += 1;
        break;
        label148:
        i = -1;
      }
    }
    
    public ArrayList<Class> getEventClass()
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(QCircleFollowUpdateEvent.class);
      return localArrayList;
    }
    
    public int getItemCount()
    {
      return this.mDatas.size();
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
    {
      super.onAttachedToRecyclerView(paramRecyclerView);
      this.jdField_a_of_type_Pci = new pci();
      paramRecyclerView.addOnScrollListener(this.jdField_a_of_type_Pci);
      rwv.a().b(this);
    }
    
    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
    {
      super.onDetachedFromRecyclerView(paramRecyclerView);
      if (this.jdField_a_of_type_Pci != null)
      {
        paramRecyclerView.removeOnScrollListener(this.jdField_a_of_type_Pci);
        this.jdField_a_of_type_Pci.onDestory();
      }
    }
    
    public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
    {
      if ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent))
      {
        paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
        if (paramSimpleBaseEvent.mFollowStatus == 1)
        {
          QLog.d("QCircleRecommendWidget", 4, "remove from recevive: ");
          paramSimpleBaseEvent = paramSimpleBaseEvent.mUserId;
          QQCircleDitto.StItemInfo localStItemInfo = new QQCircleDitto.StItemInfo();
          localStItemInfo.id.set(paramSimpleBaseEvent);
          af(localStItemInfo);
        }
      }
    }
    
    public void setRecycleView(RecyclerView paramRecyclerView)
    {
      this.mRecycleView = paramRecyclerView;
    }
  }
  
  public static class b
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private QCircleAvatarView jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView;
    private QCircleRecommendWidget.a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a;
    private int bgA;
    private QCircleFollowView e;
    private FeedCloudMeta.StFeed f;
    private ImageView mCloseButton;
    private Object mData;
    private TextView mNickName;
    private int mPos;
    private TextView wG;
    
    public b(View paramView)
    {
      super();
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131374586));
      this.mNickName = ((TextView)paramView.findViewById(2131374591));
      this.wG = ((TextView)paramView.findViewById(2131374589));
      this.e = ((QCircleFollowView)paramView.findViewById(2131374590));
      this.mCloseButton = ((ImageView)paramView.findViewById(2131374587));
      this.e.setFollowedShowToast(true);
      this.e.setItemReportListener(new pgy(this));
      this.mCloseButton.setOnClickListener(new pgz(this));
      paramView.setOnClickListener(new pha(this));
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
      this.mNickName.setOnClickListener(this);
    }
    
    private void D(boolean paramBoolean, String paramString)
    {
      FeedCloudMeta.StUser localStUser = new FeedCloudMeta.StUser();
      this.e.setFollowedDismiss(false);
      localStUser.id.set(paramString);
      localStUser.followState.set(ovd.o(paramBoolean));
      this.e.setUserData(localStUser);
    }
    
    private boolean a(QQCircleDitto.StItemInfo paramStItemInfo)
    {
      if ((paramStItemInfo != null) && (paramStItemInfo.busiInfo.get() != null)) {
        return ovd.d(paramStItemInfo.busiInfo.get(), "IsVerified").equals("1");
      }
      return false;
    }
    
    private void bkT()
    {
      if ((this.mData instanceof QQCircleDitto.StItemInfo))
      {
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)this.mData;
        if (!TextUtils.isEmpty(localStItemInfo.id.get()))
        {
          pcl.a(localStItemInfo.id.get(), 3, 1, 3, 2, this.bgA, this.f.poster.id.get(), "", this.f.id.get(), this.mPos, this.f, null);
          oux.qm(localStItemInfo.id.get());
        }
      }
    }
    
    public QQCircleDitto.StItemInfo a()
    {
      return (QQCircleDitto.StItemInfo)this.mData;
    }
    
    public void a(QCircleRecommendWidget.a parama)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleRecommendWidget$a = parama;
    }
    
    public int getPos()
    {
      return this.mPos;
    }
    
    void k(FeedCloudMeta.StFeed paramStFeed)
    {
      this.f = paramStFeed;
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
        bkT();
      }
    }
    
    public void setData(Object paramObject, int paramInt)
    {
      int j = 1;
      int i = 0;
      this.mData = paramObject;
      this.mPos = paramInt;
      boolean bool;
      if ((this.mData instanceof QQCircleDitto.StItemInfo))
      {
        paramObject = (QQCircleDitto.StItemInfo)this.mData;
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(((BaseActivity)this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.getContext()).app, paramObject.id.get());
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setIsAuth(a(paramObject));
        this.mNickName.setText(paramObject.name.get());
        if ((paramObject.des.get() != null) && (paramObject.des.size() > 0))
        {
          this.wG.setText((CharSequence)paramObject.des.get().get(0));
          this.wG.setVisibility(0);
          if (paramObject.buttonInfo.buttonValue.get() != 1) {
            break label253;
          }
          bool = true;
          label154:
          D(bool, paramObject.id.get());
        }
      }
      else
      {
        if (this.f == null) {
          break label265;
        }
        paramObject = this.f.opMask2.get();
        if ((paramObject == null) || (!paramObject.contains(Integer.valueOf(6))) || (ovd.a((FeedCloudMeta.StUser)this.f.poster.get()))) {
          break label265;
        }
      }
      label265:
      for (paramInt = j;; paramInt = 0)
      {
        paramObject = this.mCloseButton;
        if (paramInt != 0) {}
        for (paramInt = i;; paramInt = 8)
        {
          paramObject.setVisibility(paramInt);
          return;
          this.wG.setVisibility(4);
          break;
          label253:
          bool = false;
          break label154;
        }
      }
    }
    
    void vA(int paramInt)
    {
      this.bgA = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendWidget
 * JD-Core Version:    0.7.0.1
 */