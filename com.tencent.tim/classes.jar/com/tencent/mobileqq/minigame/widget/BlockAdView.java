package com.tencent.mobileqq.minigame.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class BlockAdView
  extends RelativeLayout
{
  public static final int safeGap = 32;
  public final int horizontalHeight = aqnm.dpToPx(65.0F);
  public final int horizontalSingleBlockWidth = aqnm.dpToPx(65.0F);
  protected ImageView mAdIcon;
  protected BlockAdapter mAdapter;
  private Context mContext;
  private boolean mIsHorizontal;
  private int mRealAdNum;
  private View.OnTouchListener onTouchListener = new BlockAdView.1(this);
  public final int sideGapHeightHorizontal = aqnm.dpToPx(6.0F);
  public final int sideGapHeightVertical = aqnm.dpToPx(4.0F);
  public final int sideGapWidthHorizontal = aqnm.dpToPx(8.0F);
  public final int sideGapWidthVertical = 0;
  public final int verticalSingleBlockHeight = aqnm.dpToPx(73.0F);
  public final int verticalWidth = aqnm.dpToPx(65.0F);
  
  public BlockAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramBoolean);
  }
  
  public BlockAdView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, 0, paramBoolean);
  }
  
  public BlockAdView(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, 0, paramBoolean);
  }
  
  private BlockAdInfo calculateAndAdjustBlockAdInfo(BlockAdInfo paramBlockAdInfo)
  {
    if (paramBlockAdInfo == null) {
      return null;
    }
    int n = aqnm.getScreenWidth() - 64;
    int i1 = aqnm.getScreenHeight() - 64;
    int i2 = paramBlockAdInfo.getLeft();
    int i3 = paramBlockAdInfo.getTop();
    int i = paramBlockAdInfo.getSize();
    if ((i2 < 32) || (i3 < 32)) {
      return null;
    }
    int k;
    int m;
    int j;
    if (this.mIsHorizontal)
    {
      k = this.horizontalHeight;
      if (i3 + k > i1) {
        return null;
      }
      if (this.horizontalSingleBlockWidth + i2 > n) {
        return null;
      }
      m = this.horizontalSingleBlockWidth * i + this.sideGapWidthHorizontal * 2;
      i = m;
      j = k;
      if (i2 + m > n)
      {
        i = (n - i2 - this.sideGapWidthHorizontal * 2) / this.horizontalSingleBlockWidth;
        paramBlockAdInfo.adjustGdtAdInfoList(i);
        i = i * this.horizontalSingleBlockWidth + this.sideGapWidthHorizontal * 2;
        j = k;
      }
    }
    for (;;)
    {
      paramBlockAdInfo.setRealWidth(i);
      paramBlockAdInfo.setRealHeight(j);
      return paramBlockAdInfo;
      k = this.verticalWidth;
      if (i2 + k > n) {
        return null;
      }
      if (this.verticalSingleBlockHeight + i3 > i1) {
        return null;
      }
      m = this.verticalSingleBlockHeight * i;
      i = k;
      j = m;
      if (i3 + m > i1)
      {
        i = (i1 - i3 + 0) / this.verticalSingleBlockHeight;
        paramBlockAdInfo.adjustGdtAdInfoList(i);
        j = i * this.verticalSingleBlockHeight;
        i = k;
      }
    }
  }
  
  private void init(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mAdapter = new BlockAdapter();
    this.mIsHorizontal = paramBoolean;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localObject = new HorizontalListView(paramContext);
      ((HorizontalListView)localObject).setAdapter(this.mAdapter);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(this.sideGapWidthHorizontal, this.sideGapHeightHorizontal, this.sideGapWidthHorizontal, this.sideGapHeightHorizontal);
      ((HorizontalListView)localObject).setLayoutParams(localLayoutParams);
      ((HorizontalListView)localObject).setOnTouchListener(this.onTouchListener);
      addView((View)localObject);
    }
    for (;;)
    {
      this.mAdIcon = new ImageView(paramContext);
      this.mAdIcon.setImageDrawable(getResources().getDrawable(2130841839));
      paramContext = new RelativeLayout.LayoutParams(aqnm.dpToPx(19.299999F), aqnm.dpToPx(11.3F));
      paramContext.addRule(9);
      paramContext.addRule(10);
      this.mAdIcon.setLayoutParams(paramContext);
      this.mAdIcon.setVisibility(8);
      addView(this.mAdIcon);
      setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
      return;
      localObject = new ListView(paramContext);
      ((ListView)localObject).setAdapter(this.mAdapter);
      localLayoutParams = new RelativeLayout.LayoutParams(this.verticalWidth, -2);
      localLayoutParams.setMargins(0, this.sideGapHeightVertical, 0, this.sideGapHeightVertical);
      ((ListView)localObject).setLayoutParams(localLayoutParams);
      ((ListView)localObject).setDivider(null);
      ((ListView)localObject).setOnTouchListener(this.onTouchListener);
      ((ListView)localObject).setFastScrollEnabled(false);
      ((ListView)localObject).setFastScrollAlwaysVisible(false);
      addView((View)localObject);
    }
  }
  
  private void updateAdIcon(boolean paramBoolean)
  {
    if (this.mAdIcon == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mAdIcon.setVisibility(0);
      return;
    }
    this.mAdIcon.setVisibility(8);
  }
  
  private void updateBackground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundDrawable(getResources().getDrawable(2130841841));
      return;
    }
    setBackgroundColor(getResources().getColor(2131166897));
  }
  
  public int getRealAdNum()
  {
    return this.mRealAdNum;
  }
  
  public int getRealHeight()
  {
    if (this.mIsHorizontal) {
      return this.horizontalHeight + this.sideGapHeightHorizontal * 2;
    }
    return this.mRealAdNum * this.verticalSingleBlockHeight + this.sideGapHeightVertical * 2;
  }
  
  public int getRealWidth()
  {
    if (this.mIsHorizontal) {
      return this.mRealAdNum * this.horizontalSingleBlockWidth + this.sideGapWidthHorizontal * 2;
    }
    return this.verticalWidth + 0;
  }
  
  public void setData(BlockAdInfo paramBlockAdInfo)
  {
    boolean bool2 = true;
    paramBlockAdInfo = calculateAndAdjustBlockAdInfo(paramBlockAdInfo);
    if ((this.mAdapter != null) && (paramBlockAdInfo != null))
    {
      this.mRealAdNum = paramBlockAdInfo.getBlockAdInfo().size();
      this.mAdapter.setData(paramBlockAdInfo);
      if (this.mAdapter.getCount() <= 1) {
        break label82;
      }
      bool1 = true;
      updateBackground(bool1);
      if (this.mAdapter.getCount() <= 2) {
        break label87;
      }
    }
    label82:
    label87:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      updateAdIcon(bool1);
      this.mAdapter.notifyDataSetChanged();
      return;
      bool1 = false;
      break;
    }
  }
  
  class BlockAdapter
    extends BaseAdapter
  {
    private List<GdtAd> mGdtAdList;
    private ArrayList<MiniAppInfo> miniAppInfoItems;
    
    BlockAdapter() {}
    
    public int getCount()
    {
      if (this.miniAppInfoItems != null) {
        return this.miniAppInfoItems.size();
      }
      return 0;
    }
    
    public Object getItem(int paramInt)
    {
      if (this.miniAppInfoItems != null) {
        return (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool = true;
      if ((this.miniAppInfoItems == null) || (this.miniAppInfoItems.size() < 1))
      {
        localObject1 = paramView;
        localObject2 = paramView;
        paramView = (View)localObject1;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject2;
      }
      Object localObject1 = (GdtAd)this.mGdtAdList.get(paramInt);
      Object localObject2 = (MiniAppInfo)this.miniAppInfoItems.get(paramInt);
      if (paramView == null)
      {
        paramView = BlockAdView.this;
        Context localContext = BlockAdView.this.mContext;
        if (getCount() < 3) {
          label101:
          paramView = new BlockAdView.SingleBlockAdView(paramView, localContext, bool);
        }
      }
      for (;;)
      {
        ((BlockAdView.SingleBlockAdView)paramView).setData((MiniAppInfo)localObject2, (GdtAd)localObject1, this.miniAppInfoItems.size());
        localObject1 = paramView;
        localObject2 = localObject1;
        break;
        bool = false;
        break label101;
      }
    }
    
    public void setData(BlockAdInfo paramBlockAdInfo)
    {
      this.mGdtAdList = paramBlockAdInfo.getGdtAdInfoList();
      this.miniAppInfoItems = paramBlockAdInfo.getBlockAdInfo();
    }
  }
  
  class SingleBlockAdView
    extends RelativeLayout
  {
    private ImageView mAdIconView;
    private String mAppid;
    private Context mContext;
    private ImageView mIconView;
    private LayoutInflater mLayoutInflater;
    private TextView mNameView;
    private boolean mShowAdIcon;
    
    public SingleBlockAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
    {
      super(paramAttributeSet, paramInt);
      initUI(paramContext);
      this.mShowAdIcon = paramBoolean;
    }
    
    public SingleBlockAdView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
    {
      this(paramContext, paramAttributeSet, 0, paramBoolean);
    }
    
    public SingleBlockAdView(Context paramContext, boolean paramBoolean)
    {
      this(paramContext, null, 0, paramBoolean);
    }
    
    private void initUI(Context paramContext)
    {
      this.mContext = paramContext;
      this.mLayoutInflater = LayoutInflater.from(paramContext);
      this.mLayoutInflater.inflate(2131559614, this, true);
      this.mIconView = ((ImageView)findViewById(2131371730));
      this.mNameView = ((TextView)findViewById(2131371731));
      this.mAdIconView = ((ImageView)findViewById(2131371729));
    }
    
    public void setData(MiniAppInfo paramMiniAppInfo, GdtAd paramGdtAd, int paramInt)
    {
      int i = 0;
      if ((paramMiniAppInfo == null) || (TextUtils.isEmpty(paramMiniAppInfo.iconUrl)) || (TextUtils.isEmpty(paramMiniAppInfo.name))) {
        return;
      }
      boolean bool;
      if (paramInt < 3)
      {
        bool = true;
        this.mShowAdIcon = bool;
        if (this.mIconView != null) {
          this.mIconView.setImageDrawable(MiniAppUtils.getIcon(this.mContext, paramMiniAppInfo.iconUrl, true, 6));
        }
        if (this.mNameView != null) {
          this.mNameView.setText(paramMiniAppInfo.name);
        }
        if (this.mAdIconView != null)
        {
          paramMiniAppInfo = this.mAdIconView;
          if (!this.mShowAdIcon) {
            break label135;
          }
        }
      }
      label135:
      for (paramInt = i;; paramInt = 8)
      {
        paramMiniAppInfo.setVisibility(paramInt);
        setOnClickListener(new BlockAdView.SingleBlockAdView.1(this, paramGdtAd));
        return;
        bool = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.widget.BlockAdView
 * JD-Core Version:    0.7.0.1
 */