package com.tencent.token.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.global.h;
import java.util.List;

class qv
  extends BaseAdapter
{
  private Context b;
  private List c;
  private ImageView d;
  private TextView e;
  private ImageView f;
  
  public qv(NetActiveVryOtherListActivity paramNetActiveVryOtherListActivity, Context paramContext, List paramList)
  {
    this.b = paramContext;
    this.c = paramList;
  }
  
  public int getCount()
  {
    return this.c.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == getCount() - 1)
    {
      paramView = LayoutInflater.from(this.b).inflate(2130968818, null);
      ((TextView)paramView.findViewById(2131559460)).setOnClickListener(new qw(this));
      paramView.findViewById(2131559457).setOnClickListener(new qx(this));
      if (NetActiveVryOtherListActivity.access$200(this.a).a())
      {
        paramView.findViewById(2131559459).setVisibility(0);
        if (NetActiveVryOtherListActivity.access$200(this.a).h())
        {
          paramView.findViewById(2131559457).setVisibility(8);
          paramView.findViewById(2131559458).setVisibility(8);
        }
        this.f = ((ImageView)paramView.findViewById(2131559454));
        if (!NetActiveVryOtherListActivity.access$300(this.a)) {
          break label166;
        }
        this.f.setVisibility(0);
      }
      for (;;)
      {
        return paramView;
        paramView.findViewById(2131559459).setVisibility(8);
        break;
        label166:
        this.f.setVisibility(4);
      }
    }
    paramView = LayoutInflater.from(this.b).inflate(2130968817, null);
    this.d = ((ImageView)paramView.findViewById(2131559452));
    this.e = ((TextView)paramView.findViewById(2131559453));
    this.f = ((ImageView)paramView.findViewById(2131559454));
    if (paramInt + 2 == getCount()) {
      paramView.findViewById(2131559455).setVisibility(0);
    }
    paramViewGroup = (DeterminVerifyFactorsResult.VerifyTypeItem)this.c.get(paramInt);
    this.e.setText(paramViewGroup.b());
    if (paramViewGroup.c().size() > 1)
    {
      this.d.setBackgroundResource(2130838032);
      if ((NetActiveVryOtherListActivity.access$300(this.a)) || (NetActiveVryOtherListActivity.access$400(this.a).a() != paramViewGroup.a())) {
        break label512;
      }
      this.f.setVisibility(0);
    }
    for (;;)
    {
      h.a("verify info:id1=" + NetActiveVryOtherListActivity.access$400(this.a).a() + ",id2=" + paramViewGroup.a());
      paramView.setOnClickListener(new qy(this, paramViewGroup));
      return paramView;
      switch (((Integer)paramViewGroup.c().get(0)).intValue())
      {
      default: 
        this.d.setBackgroundResource(2130837818);
        break;
      case 4: 
        this.d.setBackgroundResource(2130837819);
        break;
      case 5: 
        this.d.setBackgroundResource(2130837817);
        break;
      case 7: 
        this.d.setBackgroundResource(2130838033);
        break;
      case 3: 
        this.d.setBackgroundResource(2130838034);
        break;
      case 6: 
        this.d.setBackgroundResource(2130838032);
        break;
        label512:
        this.f.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qv
 * JD-Core Version:    0.7.0.1
 */