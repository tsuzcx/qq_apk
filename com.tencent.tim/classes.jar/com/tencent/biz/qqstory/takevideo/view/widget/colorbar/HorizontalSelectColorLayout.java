package com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import rnc;
import rnd;
import rne;
import rnh;
import rni;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  private long Cc;
  a jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a;
  public b a;
  c jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c;
  public boolean aIU;
  int ayA;
  HorizontalListView h;
  ArrayList<rni> nH = new ArrayList();
  ImageView nu;
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public HorizontalSelectColorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131561871, this);
    this.h = ((HorizontalListView)super.findViewById(2131364879));
    this.h.setStayDisplayOffsetZero(true);
    this.h.setOverScrollMode(2);
    this.h.setOnItemClickListener(new rnc(this));
    this.h.setOnItemSelectedListener(new rnd(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c = new c(getContext());
    this.h.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c);
    this.nu = ((ImageView)super.findViewById(2131381238));
    this.nu.setOnClickListener(new rne(this));
    this.aIU = false;
    this.nu.setEnabled(false);
    this.nu.setContentDescription(getContext().getString(2131692923));
  }
  
  private void xO(int paramInt)
  {
    if (this.Cc > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c.xP(paramInt);
      this.ayA = paramInt;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a.a(a());
  }
  
  public rni a()
  {
    return (rni)this.nH.get(this.ayA);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.Cc = paramLong;
  }
  
  public void setOnStrokeSelectedListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a = parama;
  }
  
  public void setOnUndoViewClickListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$b = paramb;
  }
  
  public void setSelectedStrokeWithColor(int paramInt)
  {
    int i;
    if (!this.nH.isEmpty()) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.nH.size())
      {
        rni localrni = (rni)this.nH.get(i);
        if ((localrni.type == 0) && (localrni.subType == paramInt)) {
          xO(i);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void setStrokeStrategy(rnh paramrnh, boolean paramBoolean, int paramInt)
  {
    Object localObject = this.nu;
    int i;
    label35:
    View localView;
    if (paramBoolean)
    {
      i = 0;
      ((ImageView)localObject).setVisibility(i);
      localObject = super.findViewById(2131381239);
      if (!paramBoolean) {
        break label135;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131380021);
      localView = super.findViewById(2131363675);
      if (paramInt != 0) {
        break label142;
      }
      ((View)localObject).setVisibility(0);
      label68:
      if (paramrnh == null) {
        break label176;
      }
      this.nH.clear();
      paramrnh.b(this.nH, getContext());
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c.ct(this.nH);
      }
    }
    for (;;)
    {
      super.setBackgroundColor(super.getContext().getResources().getColor(2131166737));
      return;
      i = 8;
      break;
      label135:
      i = 8;
      break label35;
      label142:
      if (paramInt == 1)
      {
        localView.setVisibility(0);
        break label68;
      }
      if (paramInt != 2) {
        break label68;
      }
      ((View)localObject).setVisibility(0);
      localView.setVisibility(0);
      break label68;
      label176:
      setVisibility(8);
    }
  }
  
  public void setUndoViewEnable(boolean paramBoolean)
  {
    if (this.aIU != paramBoolean)
    {
      this.aIU = paramBoolean;
      this.nu.setEnabled(paramBoolean);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(@NonNull rni paramrni);
  }
  
  public static abstract interface b
  {
    public abstract void bum();
  }
  
  class c
    extends BaseAdapter
  {
    int ayA = -1;
    Context mContext;
    ArrayList<rni> nI = new ArrayList();
    
    public c(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public void ct(ArrayList<rni> paramArrayList)
    {
      this.nI = paramArrayList;
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.nI.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this.nI.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      rni localrni = (rni)getItem(paramInt);
      View localView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.mContext).inflate(2131561827, paramViewGroup, false);
        paramView = new a();
        paramView.nv = ((ImageView)localView.findViewById(2131369417));
        paramView.nw = ((ImageView)localView.findViewById(2131369524));
        localView.setTag(paramView);
        paramView.nv.setImageDrawable(localrni.mDrawable);
        if (paramInt != this.ayA) {
          break label137;
        }
        paramView.nw.setVisibility(0);
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        a locala = (a)paramView.getTag();
        localView = paramView;
        paramView = locala;
        break;
        label137:
        paramView.nw.setVisibility(8);
      }
    }
    
    public void xP(int paramInt)
    {
      this.ayA = paramInt;
      notifyDataSetChanged();
    }
    
    class a
    {
      ImageView nv;
      ImageView nw;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */