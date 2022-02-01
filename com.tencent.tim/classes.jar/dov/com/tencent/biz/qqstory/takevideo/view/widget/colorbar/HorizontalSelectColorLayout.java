package dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import aytf;
import aytg;
import ayth;
import aytk;
import aytl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

public class HorizontalSelectColorLayout
  extends RelativeLayout
{
  private long Cc;
  a jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a;
  public b a;
  c jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c;
  boolean aIU;
  int ayA;
  boolean dAE = false;
  HorizontalListView h;
  ArrayList<aytl> nH = new ArrayList();
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
    this.h.setOnItemClickListener(new aytf(this));
    this.h.setOnItemSelectedListener(new aytg(this));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c = new c(getContext());
    this.h.setAdapter(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c);
    this.nu = ((ImageView)super.findViewById(2131381238));
    this.nu.setOnClickListener(new ayth(this));
    this.aIU = false;
    this.nu.setEnabled(false);
  }
  
  private void xO(int paramInt)
  {
    if (this.Cc > System.currentTimeMillis()) {}
    do
    {
      return;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c.xP(paramInt);
      this.ayA = paramInt;
    } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a == null);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a.a(a());
  }
  
  public aytl a()
  {
    return (aytl)this.nH.get(this.ayA);
  }
  
  public void setAnimationEndTime(long paramLong)
  {
    this.Cc = paramLong;
  }
  
  public void setEditDialogMode(boolean paramBoolean)
  {
    this.dAE = paramBoolean;
  }
  
  public void setOnStrokeSelectedListener(a parama)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$a = parama;
  }
  
  public void setOnUndoViewClickListener(b paramb)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$b = paramb;
  }
  
  public void setSelectedStroke(int paramInt1, int paramInt2)
  {
    int i;
    if (!this.nH.isEmpty()) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.nH.size())
      {
        aytl localaytl = (aytl)this.nH.get(i);
        if ((localaytl.type != paramInt1) || (localaytl.subType != paramInt2)) {
          break label73;
        }
        xO(i);
        if (i > 5) {
          this.h.smoothScrollToPosition(i);
        }
      }
      return;
      label73:
      i += 1;
    }
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
        aytl localaytl = (aytl)this.nH.get(i);
        if ((localaytl.type == 0) && (localaytl.subType == paramInt)) {
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
  
  public void setStrokeStrategy(aytk paramaytk, boolean paramBoolean, int paramInt)
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
        break label120;
      }
      i = 0;
      ((View)localObject).setVisibility(i);
      localObject = super.findViewById(2131380021);
      localView = super.findViewById(2131363675);
      if (paramInt != 1) {
        break label127;
      }
      ((View)localObject).setVisibility(0);
    }
    for (;;)
    {
      if (paramaytk == null) {
        break label161;
      }
      this.nH.clear();
      paramaytk.b(this.nH, getContext());
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$c.setData(this.nH);
      }
      return;
      i = 8;
      break;
      label120:
      i = 8;
      break label35;
      label127:
      if (paramInt == 2)
      {
        localView.setVisibility(0);
      }
      else if (paramInt == 3)
      {
        ((View)localObject).setVisibility(0);
        localView.setVisibility(0);
      }
    }
    label161:
    setVisibility(8);
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
    public abstract void a(@NonNull aytl paramaytl);
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
    ArrayList<aytl> nI = new ArrayList();
    
    public c(Context paramContext)
    {
      this.mContext = paramContext;
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
      aytl localaytl = (aytl)getItem(paramInt);
      a locala;
      if (paramView == null)
      {
        locala = new a();
        if (HorizontalSelectColorLayout.this.dAE)
        {
          paramView = LayoutInflater.from(this.mContext).inflate(2131559259, paramViewGroup, false);
          locala.nw = ((ImageView)paramView.findViewById(2131369524));
          locala.nv = ((ImageView)paramView.findViewById(2131369417));
          locala.fq = ((ViewGroup)paramView.findViewById(2131369416));
          paramView.setTag(locala);
          label97:
          if (Build.VERSION.SDK_INT < 21) {
            locala.nv.setImageDrawable(null);
          }
          locala.nv.setImageDrawable(localaytl.mDrawable);
          if (paramInt != this.ayA) {
            break label240;
          }
          if (!HorizontalSelectColorLayout.this.dAE) {
            break label217;
          }
          locala.nw.setVisibility(0);
        }
      }
      for (;;)
      {
        if (localaytl.contentDescription != null) {
          paramView.setContentDescription(localaytl.contentDescription);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        paramView = LayoutInflater.from(this.mContext).inflate(2131559258, paramViewGroup, false);
        break;
        locala = (a)paramView.getTag();
        break label97;
        label217:
        locala.fq.setBackgroundDrawable(HorizontalSelectColorLayout.this.getResources().getDrawable(2130845984));
        continue;
        label240:
        if (HorizontalSelectColorLayout.this.dAE) {
          locala.nw.setVisibility(4);
        } else {
          locala.fq.setBackgroundDrawable(null);
        }
      }
    }
    
    public void setData(ArrayList<aytl> paramArrayList)
    {
      this.nI = paramArrayList;
      notifyDataSetChanged();
    }
    
    public void xP(int paramInt)
    {
      this.ayA = paramInt;
      notifyDataSetChanged();
    }
    
    class a
    {
      ViewGroup fq;
      ImageView nv;
      ImageView nw;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout
 * JD-Core Version:    0.7.0.1
 */