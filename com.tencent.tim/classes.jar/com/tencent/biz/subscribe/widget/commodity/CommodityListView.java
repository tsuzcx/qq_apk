package com.tencent.biz.subscribe.widget.commodity;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop;
import acfp;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import auqt;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import rxs;
import rxs.a;
import rze;
import siu;
import sjc;
import sjd;
import sqn;

public class CommodityListView
  extends BaseWidgetView<ArrayList>
{
  private TextView Aa;
  private a jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a;
  private b jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$b;
  private boolean aLI;
  private View mDivider;
  private CertifiedAccountMeta.StFeed mFeed;
  private LinearLayoutManager mLinearLayoutManager;
  private TextView mTitle;
  private RecyclerView q;
  
  public CommodityListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommodityListView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void aU(ArrayList paramArrayList) {}
  
  public void clearData()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a.clearData();
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a.notifyDataSetChanged();
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.q = ((RecyclerView)paramView.findViewById(2131377612));
    this.mTitle = ((TextView)paramView.findViewById(2131380976));
    this.Aa = ((TextView)paramView.findViewById(2131380902));
    this.mDivider = paramView.findViewById(2131381451);
    this.mLinearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.q.setLayoutManager(this.mLinearLayoutManager);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a = new a();
    this.q.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a);
  }
  
  public int getLayoutId()
  {
    return 2131558835;
  }
  
  public String nB()
  {
    if (getData() == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < ((ArrayList)getData()).size())
    {
      Object localObject = ((ArrayList)getData()).get(i);
      if ((localObject instanceof CommodityBean))
      {
        long l = ((CommodityBean)localObject).mItemID;
        if (l > 0L) {
          localObject = String.valueOf(l);
        }
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        if (i != ((ArrayList)getData()).size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
        break;
        localObject = ((CommodityBean)localObject).mAlias;
        continue;
        if (((CertifiedAccountMeta.StYouZanGood)localObject).itemID.get() > 0L) {
          localObject = String.valueOf(((CertifiedAccountMeta.StYouZanGood)localObject).itemID.get());
        } else {
          localObject = ((CertifiedAccountMeta.StYouZanGood)localObject).alias.get();
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public void setData(ArrayList paramArrayList)
  {
    super.setData(paramArrayList);
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$a.setDatas(paramArrayList);
    }
  }
  
  public void setOnDataChangeListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetCommodityCommodityListView$b = paramb;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mLinearLayoutManager != null) {
      this.mLinearLayoutManager.setOrientation(paramInt);
    }
  }
  
  public void setPublishUI(boolean paramBoolean)
  {
    int j = 8;
    Object localObject;
    if (this.mTitle != null)
    {
      localObject = this.mTitle;
      if (paramBoolean)
      {
        i = 8;
        ((TextView)localObject).setVisibility(i);
      }
    }
    else
    {
      if (this.Aa != null)
      {
        localObject = this.Aa;
        if (!paramBoolean) {
          break label122;
        }
        i = 8;
        label49:
        ((TextView)localObject).setVisibility(i);
      }
      if (this.mDivider != null)
      {
        localObject = this.mDivider;
        if (!paramBoolean) {
          break label127;
        }
      }
    }
    label122:
    label127:
    for (int i = j;; i = 0)
    {
      ((View)localObject).setVisibility(i);
      setOrientation(1);
      this.aLI = paramBoolean;
      if (this.q != null)
      {
        this.q.getLayoutParams().height = ImmersiveUtils.dpToPx(250.0F);
        requestLayout();
      }
      return;
      i = 0;
      break;
      i = 0;
      break label49;
    }
  }
  
  public void setShopData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    CertifiedAccountMeta.StUser localStUser = paramStFeed.poster;
    this.mFeed = paramStFeed;
    TextView localTextView;
    String str;
    if ((this.Aa != null) && (localStUser.youZhan.size() > 0) && (((CertifiedAccountMeta.StYouZanShop)localStUser.youZhan.get(0)).goodNum.get() > 0))
    {
      sqn.b(localStUser.id.get(), "auth_" + siu.b(getExtraTypeInfo()), "exp_shop", 0, 0, new String[0]);
      this.Aa.setVisibility(0);
      localTextView = this.Aa;
      str = acfp.m(2131720623);
      if (!rze.bg(localStUser.attr.get())) {
        break label166;
      }
    }
    label166:
    for (paramStFeed = acfp.m(2131704216);; paramStFeed = localStUser.nick.get())
    {
      localTextView.setText(String.format(str, new Object[] { paramStFeed }));
      this.Aa.setOnClickListener(new sjc(this, localStUser));
      return;
    }
  }
  
  public class a
    extends rxs
  {
    public a() {}
    
    public rxs.a a(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = new CommodityItemView(CommodityListView.this.getContext());
      paramViewGroup.setIsPublishUI(CommodityListView.a(CommodityListView.this));
      paramViewGroup.setCurrentFeed(CommodityListView.a(CommodityListView.this));
      return new rxs.a(this, paramViewGroup);
    }
    
    public int getItemCount()
    {
      return this.mDataList.size();
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (!auqt.b(paramInt, this.mDataList))
      {
        ((CommodityItemView)paramViewHolder.itemView).setData(this.mDataList.get(paramInt));
        ((CommodityItemView)paramViewHolder.itemView).aH().setOnClickListener(new sjd(this, paramInt));
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
    }
  }
  
  public static abstract interface b
  {
    public abstract void yy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.commodity.CommodityListView
 * JD-Core Version:    0.7.0.1
 */