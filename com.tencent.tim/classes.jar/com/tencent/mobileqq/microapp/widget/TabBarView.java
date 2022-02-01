package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.R.id;
import com.tencent.mobileqq.microapp.apkg.t;
import com.tencent.mobileqq.microapp.apkg.t.a;
import com.tencent.mobileqq.microapp.util.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TabBarView
  extends LinearLayout
{
  public LinkedList a = new LinkedList();
  private t b;
  private b c;
  
  public TabBarView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void a(List paramList)
  {
    removeAllViews();
    this.a.clear();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        View localView = a((t.a)paramList.get(i), i);
        if (localView != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
          localLayoutParams.weight = 1.0F;
          addView(localView, localLayoutParams);
        }
        i += 1;
      }
    }
  }
  
  private void b()
  {
    setOrientation(0);
    setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    Object localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.bo);
    localRelativeLayout.addView((View)localObject1, new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F)));
    localObject1 = new ImageView(getContext());
    ((ImageView)localObject1).setId(R.id.ac);
    Object localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 30.0F), DisplayUtil.dip2px(getContext(), 30.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.bo);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(getContext(), 2.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(R.id.i);
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    ((TextView)localObject1).setPadding(DisplayUtil.dip2px(getContext(), 1.0F), 0, DisplayUtil.dip2px(getContext(), 1.0F), 0);
    ((TextView)localObject1).setBackgroundResource(R.drawable.y);
    ((TextView)localObject1).setVisibility(4);
    ((TextView)localObject1).setGravity(17);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.dip2px(getContext(), -10.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.ac);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, R.id.ac);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.az);
    ((View)localObject1).setBackgroundResource(R.drawable.x);
    ((View)localObject1).setVisibility(4);
    localObject2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 10.0F), DisplayUtil.dip2px(getContext(), 10.0F));
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = DisplayUtil.dip2px(getContext(), -4.0F);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, R.id.ac);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, R.id.ac);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(getContext());
    ((TextView)localObject1).setId(R.id.bi);
    ((TextView)localObject1).setTextSize(1, 12.0F);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.ac);
    ((RelativeLayout.LayoutParams)localObject2).bottomMargin = DisplayUtil.dip2px(getContext(), 5.0F);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    localObject2 = new RelativeLayout.LayoutParams(-1, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.bi);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new View(getContext());
    ((View)localObject1).setId(R.id.j);
    localObject2 = new RelativeLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 0.5F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, R.id.bi);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(getContext());
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(8, R.id.j);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    ((View)localObject2).setId(R.id.k);
    ((View)localObject2).setVisibility(8);
    localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 3.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new View(getContext());
    localLayoutParams = new LinearLayout.LayoutParams(0, DisplayUtil.dip2px(getContext(), 2.0F));
    localLayoutParams.weight = 1.0F;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    return localRelativeLayout;
  }
  
  public View a(t.a parama, int paramInt)
  {
    if ((parama == null) || (TextUtils.isEmpty(parama.b))) {
      return null;
    }
    View localView = a();
    a locala = a.a(localView, parama, this.b);
    locala.a();
    this.a.add(locala);
    localView.setOnClickListener(new f(this, paramInt, parama));
    return localView;
  }
  
  public void a(t paramt)
  {
    this.b = paramt;
    if (this.b != null)
    {
      this.b = paramt.a();
      a(this.b.f);
      if (this.a.size() > 0) {
        ((a)this.a.getFirst()).a(true);
      }
    }
  }
  
  public void a(a parama)
  {
    if (parama != null)
    {
      parama.a(true);
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != parama) {
          locala.a(false);
        }
      }
    }
  }
  
  public void a(b paramb)
  {
    this.c = paramb;
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.i.a.equals(paramString)) {
          a(locala);
        }
      }
    }
  }
  
  public static final class a
  {
    public TextView a;
    public ImageView b;
    public View c;
    public View d;
    public View e;
    public View f;
    public Drawable g;
    public Drawable h;
    public t.a i;
    public t j;
    
    public static a a(View paramView, t.a parama, t paramt)
    {
      a locala = new a();
      locala.a = ((TextView)paramView.findViewById(R.id.bi));
      locala.b = ((ImageView)paramView.findViewById(R.id.ac));
      locala.c = paramView.findViewById(R.id.bo);
      locala.d = paramView.findViewById(R.id.j);
      locala.e = paramView.findViewById(R.id.k);
      paramView.findViewById(R.id.az);
      paramView.findViewById(R.id.i);
      locala.f = paramView;
      locala.j = paramt;
      locala.i = parama;
      return locala;
    }
    
    public void a()
    {
      RelativeLayout.LayoutParams localLayoutParams;
      if ("top".equals(this.j.e))
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.f.getContext(), 15.0F);
        localLayoutParams.topMargin = DisplayUtil.dip2px(this.f.getContext(), 15.0F);
        this.a.setLayoutParams(localLayoutParams);
        this.a.setTextSize(1, 15.0F);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        this.a.setText(this.i.b);
        if (!"top".equals(this.j.e)) {
          break label225;
        }
      }
      for (;;)
      {
        a(false);
        return;
        localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
        localLayoutParams.bottomMargin = DisplayUtil.dip2px(this.f.getContext(), 5.0F);
        localLayoutParams.topMargin = DisplayUtil.dip2px(this.f.getContext(), 0.0F);
        this.a.setLayoutParams(localLayoutParams);
        this.a.setTextSize(1, 12.0F);
        this.d.setVisibility(8);
        this.c.setVisibility(0);
        this.b.setVisibility(0);
        break;
        label225:
        this.g = new BitmapDrawable(this.f.getContext().getResources(), this.i.e);
        this.h = new BitmapDrawable(this.f.getContext().getResources(), this.i.f);
      }
    }
    
    public void a(boolean paramBoolean)
    {
      int k = 855638016;
      this.f.setBackgroundColor(this.j.c);
      if (!paramBoolean)
      {
        this.a.setTextColor(this.j.a);
        if ("top".equals(this.j.e))
        {
          this.e.setVisibility(8);
          if (!"top".equals(this.j.e)) {
            break label188;
          }
          localView = this.d;
          if (!"black".equals(this.j.d)) {
            break label182;
          }
        }
      }
      for (;;)
      {
        localView.setBackgroundColor(k);
        this.e.setBackgroundColor(this.j.b);
        return;
        this.b.setImageDrawable(this.g);
        break;
        this.a.setTextColor(this.j.b);
        if ("top".equals(this.j.e))
        {
          this.e.setVisibility(0);
          break;
        }
        this.b.setImageDrawable(this.h);
        break;
        label182:
        k = 872415231;
      }
      label188:
      View localView = this.c;
      if ("black".equals(this.j.d)) {}
      for (;;)
      {
        localView.setBackgroundColor(k);
        return;
        k = 872415231;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onTabItemClick(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.TabBarView
 * JD-Core Version:    0.7.0.1
 */