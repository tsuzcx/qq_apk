package com.tencent.token.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.JLRoleInfo;
import com.tencent.token.core.bean.JLZone;
import com.tencent.token.core.bean.JLZone.JLZoneServer;
import java.util.ArrayList;

final class ahs
  extends BaseAdapter
{
  public ArrayList a;
  public ArrayList b;
  public int c;
  private LayoutInflater d;
  private int e;
  
  public ahs(Context paramContext, int paramInt1, int paramInt2)
  {
    this.d = LayoutInflater.from(paramContext);
    this.e = paramInt1;
    this.c = paramInt2;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.c = paramInt2;
  }
  
  public final int getCount()
  {
    if (this.e == 0)
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    if (this.e == 1)
    {
      if (((JLZone)this.a.get(this.c)).serverList == null) {
        return 0;
      }
      return ((JLZone)this.a.get(this.c)).serverList.size();
    }
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.d.inflate(2130903118, null);
      paramViewGroup = new aht(this);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131296742));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131296743));
      paramView.setTag(paramViewGroup);
    }
    while (this.e == 0)
    {
      paramViewGroup.a.setText(((JLZone)this.a.get(paramInt)).name);
      paramViewGroup.b.setVisibility(0);
      return paramView;
      paramViewGroup = (aht)paramView.getTag();
    }
    if (this.e == 1)
    {
      paramViewGroup.a.setText(((JLZone.JLZoneServer)((JLZone)this.a.get(this.c)).serverList.get(paramInt)).serverName);
      paramViewGroup.b.setVisibility(0);
      return paramView;
    }
    paramViewGroup.a.setText(((JLRoleInfo)this.b.get(paramInt)).name);
    paramViewGroup.b.setVisibility(8);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ahs
 * JD-Core Version:    0.7.0.1
 */