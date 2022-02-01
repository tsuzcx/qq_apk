package com.tencent.mobileqq.microapp.out.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.color;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.R.layout;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends BaseAdapter
{
  protected LayoutInflater a;
  protected List b = new ArrayList();
  protected int c;
  protected int d;
  protected int e;
  public int f = -1;
  public int g;
  public boolean h = true;
  
  public f(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
    this.c = Color.rgb(0, 121, 255);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.d = paramContext.getResources().getColor(R.color.d);
      this.e = paramContext.getResources().getColor(R.color.b);
      return;
    }
    this.d = paramContext.getResources().getColor(R.color.e);
    this.e = paramContext.getResources().getColor(R.color.c);
  }
  
  public LBSShare.POI a(int paramInt)
  {
    if (this.b == null) {}
    int i;
    do
    {
      return null;
      i = this.b.size();
    } while ((i <= 0) || (paramInt <= -1) || (paramInt >= i));
    return (LBSShare.POI)this.b.get(paramInt);
  }
  
  public void a()
  {
    this.g = 0;
    this.f = -1;
    this.h = true;
    this.b.clear();
    notifyDataSetChanged();
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.h = paramBoolean;
      this.g += 1;
      this.b.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= this.b.size()) {}
    while (paramInt == this.f) {
      return;
    }
    this.f = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new a();
      paramView = this.a.inflate(R.layout.i, null);
      ((a)localObject).a = ((TextView)paramView.findViewById(R.id.al));
      ((a)localObject).b = ((TextView)paramView.findViewById(R.id.a));
      ((a)localObject).c = paramView.findViewById(R.id.be);
      ((a)localObject).c.setVisibility(4);
      paramView.setTag(localObject);
    }
    LBSShare.POI localPOI;
    for (;;)
    {
      localPOI = a(paramInt);
      if (localPOI != null) {
        break;
      }
      localObject = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
      localObject = (a)paramView.getTag();
    }
    ((a)localObject).a.setText(localPOI.name.get());
    ((a)localObject).b.setText(localPOI.addr.get());
    if (paramInt == this.f)
    {
      ((a)localObject).a.setTextColor(this.c);
      ((a)localObject).b.setTextColor(this.c);
      ((a)localObject).c.setVisibility(0);
    }
    for (;;)
    {
      localObject = paramView;
      break;
      ((a)localObject).a.setTextColor(this.e);
      ((a)localObject).b.setTextColor(this.d);
      ((a)localObject).c.setVisibility(4);
    }
  }
  
  public static final class a
  {
    public TextView a;
    public TextView b;
    public View c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.f
 * JD-Core Version:    0.7.0.1
 */