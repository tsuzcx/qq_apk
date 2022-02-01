package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import wsm;
import wso;

public abstract class RDBaseListLayout<TItemData, TItemViewHolder>
  extends RelativeLayout
{
  private RDBaseListLayout<TItemData, TItemViewHolder>.a a;
  private int boe = 0;
  private int mCurIndex = -1;
  private ArrayList<TItemData> mDataList = new ArrayList();
  private View wv;
  
  public RDBaseListLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public RDBaseListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RDBaseListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void CM(int paramInt)
  {
    if (paramInt == 1)
    {
      this.wv = new HorizontalListView(getContext());
      ((HorizontalListView)this.wv).setOverScrollMode(2);
      this.wv.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((HorizontalListView)this.wv).setAdapter(this.a);
      addView(this.wv);
      return;
    }
    ScrollView localScrollView = new ScrollView(getContext());
    localScrollView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    addView(localScrollView);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localScrollView.addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    this.wv = new ListView(getContext());
    this.wv.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    ((ListView)this.wv).setAdapter(this.a);
    localLinearLayout.addView(this.wv);
  }
  
  private RDBaseListLayout<TItemData, TItemViewHolder>.b a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (Object localObject = paramView;; localObject = (View)localObject)
    {
      localObject = ((View)localObject).getTag();
      if ((localObject != null) && ((localObject instanceof b))) {
        return (b)localObject;
      }
      localObject = paramView.getParent();
      if (!(localObject instanceof View)) {
        break;
      }
    }
    return null;
  }
  
  public void Q(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= this.mDataList.size())) {
      return;
    }
    if ((!paramBoolean) && (this.mCurIndex >= 0))
    {
      ((wsm)this.mDataList.get(this.mCurIndex)).setSelected(false);
      this.mCurIndex = -1;
    }
    Object localObject = this.mDataList.get(paramInt);
    ((wsm)localObject).setSelected(true);
    ((wsm)localObject).setSelected(true);
    if ((this.wv instanceof ListView)) {
      ((ListView)this.wv).setSelection(paramInt);
    }
    for (;;)
    {
      u(paramInt, localObject);
      this.mCurIndex = paramInt;
      update();
      return;
      if ((this.wv instanceof HorizontalListView))
      {
        ((HorizontalListView)this.wv).setSelection(paramInt);
        ((HorizontalListView)this.wv).smoothScrollToPosition(paramInt, 0, 1);
      }
    }
  }
  
  public abstract boolean RI();
  
  public void Y(List<TItemData> paramList, boolean paramBoolean)
  {
    this.mDataList.addAll(paramList);
    if (paramBoolean) {
      update();
    }
  }
  
  public abstract void a(int paramInt, @NonNull TItemData paramTItemData, @NonNull TItemViewHolder paramTItemViewHolder);
  
  public abstract TItemViewHolder b(int paramInt, TItemData paramTItemData);
  
  public void c(TItemData paramTItemData, boolean paramBoolean)
  {
    this.mDataList.add(paramTItemData);
    if (paramBoolean) {
      update();
    }
  }
  
  public abstract void cbt();
  
  public boolean cn(int paramInt)
  {
    this.boe = paramInt;
    this.a = new a(null);
    this.a.init();
    CM(this.boe);
    boolean bool = RI();
    if (bool) {
      this.a.notifyDataSetChanged();
    }
    return bool;
  }
  
  public void d(TItemData paramTItemData, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      if (i < this.mDataList.size())
      {
        localObject = this.mDataList.get(i);
        if (!paramTItemData.equals(localObject)) {
          break label150;
        }
        if ((!paramBoolean) && (this.mCurIndex >= 0))
        {
          ((wsm)this.mDataList.get(this.mCurIndex)).setSelected(false);
          this.mCurIndex = -1;
        }
        ((wsm)localObject).setSelected(true);
        if (!(this.wv instanceof ListView)) {
          break label113;
        }
        ((ListView)this.wv).setSelection(i);
      }
      for (;;)
      {
        u(i, localObject);
        this.mCurIndex = i;
        update();
        return;
        label113:
        if ((this.wv instanceof HorizontalListView))
        {
          ((HorizontalListView)this.wv).setSelection(i);
          ((HorizontalListView)this.wv).smoothScrollToPosition(i, 0, 1);
        }
      }
      label150:
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return this.mDataList.size();
  }
  
  public TItemData i(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mDataList.size())) {
      return null;
    }
    return this.mDataList.get(paramInt);
  }
  
  public int o(View paramView)
  {
    paramView = a(paramView);
    if (paramView != null) {
      return paramView.mPosition;
    }
    return -1;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (this.wv != null) {
      this.wv.setOverScrollMode(paramInt);
    }
  }
  
  public abstract void u(int paramInt, TItemData paramTItemData);
  
  public void unInit()
  {
    cbt();
    if (this.a != null) {
      this.a.unInit();
    }
  }
  
  public void update()
  {
    if (this.a != null) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public int wd()
  {
    return this.mCurIndex;
  }
  
  public void yW(boolean paramBoolean)
  {
    if (this.mDataList != null) {
      this.mDataList.clear();
    }
    if (paramBoolean) {
      update();
    }
  }
  
  class a
    extends BaseAdapter
  {
    private a() {}
    
    public int getCount()
    {
      return RDBaseListLayout.a(RDBaseListLayout.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return RDBaseListLayout.a(RDBaseListLayout.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2 = RDBaseListLayout.a(RDBaseListLayout.this).get(paramInt);
      Object localObject1;
      if (paramView == null) {
        localObject1 = RDBaseListLayout.this.b(paramInt, localObject2);
      }
      for (;;)
      {
        if (localObject1 == null)
        {
          localObject2 = null;
          localObject1 = paramView;
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
          return localObject2;
          localObject1 = (RDBaseListLayout.b)paramView.getTag();
          if (localObject1 == null) {
            break label141;
          }
          localObject1 = ((RDBaseListLayout.b)localObject1).bO;
          break;
          RDBaseListLayout.this.a(paramInt, localObject2, localObject1);
          localObject2 = ((wso)localObject1).y();
          if (localObject2 != null) {
            ((View)localObject2).setTag(new RDBaseListLayout.b(RDBaseListLayout.this, paramInt, localObject1));
          }
          paramView = (View)localObject2;
          localObject1 = localObject2;
          localObject2 = paramView;
        }
        label141:
        localObject1 = null;
      }
    }
    
    public void init() {}
    
    public void unInit() {}
  }
  
  class b
  {
    TItemViewHolder bO;
    int mPosition;
    
    public b(TItemViewHolder paramTItemViewHolder)
    {
      this.mPosition = paramTItemViewHolder;
      Object localObject;
      this.bO = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
 * JD-Core Version:    0.7.0.1
 */