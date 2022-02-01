package com.tencent.tim.todo.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aupv;
import aupw;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;

public class EmptyScheduleView
  extends RelativeLayout
{
  private a a;
  private c b;
  private AdapterView.c jdField_k_of_type_ComTencentWidgetAdapterView$c = new aupv(this);
  private SwipListView jdField_k_of_type_ComTencentWidgetSwipListView;
  private Context mContext;
  private ArrayList<b> mData = new ArrayList();
  
  public EmptyScheduleView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EmptyScheduleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmptyScheduleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131562993, this, true);
    this.jdField_k_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131378236));
    this.a = new a();
    this.jdField_k_of_type_ComTencentWidgetSwipListView.setOnItemClickListener(this.jdField_k_of_type_ComTencentWidgetAdapterView$c);
    this.jdField_k_of_type_ComTencentWidgetSwipListView.setAdapter(this.a);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setDataSource(ArrayList<b> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.mData = ((ArrayList)paramArrayList.clone());
      this.a.xC(1);
      this.a.notifyDataSetChanged();
    }
  }
  
  public void setOnItemClickListener(c paramc)
  {
    this.b = paramc;
  }
  
  public class a
    extends BaseAdapter
  {
    private final View.OnClickListener h = new aupw(this);
    private int pS = -1;
    
    a() {}
    
    public EmptyScheduleView.b a(int paramInt)
    {
      if (EmptyScheduleView.a(EmptyScheduleView.this) != null) {
        return (EmptyScheduleView.b)EmptyScheduleView.a(EmptyScheduleView.this).get(paramInt);
      }
      return null;
    }
    
    public int getCount()
    {
      if (EmptyScheduleView.a(EmptyScheduleView.this) != null) {
        return EmptyScheduleView.a(EmptyScheduleView.this).size();
      }
      return 0;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      return ((EmptyScheduleView.b)EmptyScheduleView.a(EmptyScheduleView.this).get(paramInt)).type;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      EmptyScheduleView.b localb = a(paramInt);
      Object localObject;
      if (getItemViewType(paramInt) == 0) {
        if (paramView == null)
        {
          paramView = LayoutInflater.from(EmptyScheduleView.a(EmptyScheduleView.this)).inflate(2131562995, paramViewGroup, false);
          localObject = new a(paramView);
          ((a)localObject).viewType = 0;
          ((a)localObject).a = localb;
          paramView.setTag(localObject);
          if (((a)localObject).MM != null)
          {
            if (localb != null) {
              ((a)localObject).MM.setText(localb.cIL);
            }
            if (paramInt != this.pS - 1) {
              break label158;
            }
            ((a)localObject).MM.setTextColor(EmptyScheduleView.a(EmptyScheduleView.this).getResources().getColor(2131165781));
          }
          label126:
          localObject = paramView;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (a)paramView.getTag();
        break;
        label158:
        ((a)localObject).MM.setTextColor(EmptyScheduleView.a(EmptyScheduleView.this).getResources().getColor(2131167379));
        break label126;
        if (localb != null) {
          break label201;
        }
        localb = null;
        localObject = paramView;
        paramView = localb;
      }
      label201:
      if (paramView == null)
      {
        paramView = LayoutInflater.from(EmptyScheduleView.a(EmptyScheduleView.this)).inflate(2131562994, paramViewGroup, false);
        localObject = new a(paramView);
        ((a)localObject).viewType = 1;
        ((a)localObject).a = localb;
        paramView.setTag(localObject);
        label253:
        if (this.pS != paramInt) {
          break label317;
        }
        ((a)localObject).layout.setBackgroundResource(2131165906);
        ((a)localObject).icon.setImageResource(2130840122);
        ((a)localObject).afE.setText(2131719098);
      }
      for (;;)
      {
        paramView.setOnClickListener(this.h);
        localObject = paramView;
        break;
        localObject = (a)paramView.getTag();
        break label253;
        label317:
        ((a)localObject).layout.setBackgroundResource(2130851372);
        ((a)localObject).icon.setImageResource(2130840121);
        ((a)localObject).afE.setText("");
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public void xC(int paramInt)
    {
      this.pS = paramInt;
    }
    
    public class a
    {
      public TextView MM;
      public EmptyScheduleView.b a;
      public TextView afE;
      public ImageView icon;
      public RelativeLayout layout;
      public int viewType;
      
      public a(View paramView)
      {
        this.layout = ((RelativeLayout)paramView);
        this.MM = ((TextView)paramView.findViewById(2131365614));
        this.afE = ((TextView)paramView.findViewById(2131366435));
        this.icon = ((ImageView)paramView.findViewById(2131366405));
      }
    }
  }
  
  public static class b
  {
    public String cIL;
    public int erS;
    public int position;
    public int type;
  }
  
  public static abstract interface c
  {
    public abstract void a(EmptyScheduleView.b paramb, View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.todo.widget.EmptyScheduleView
 * JD-Core Version:    0.7.0.1
 */