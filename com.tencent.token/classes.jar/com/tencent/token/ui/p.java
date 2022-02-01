package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.bz;
import com.tencent.token.cb;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.bean.OnlineDeviceResult.a;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.dk;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;

class p
  extends BaseAdapter
{
  public final int a = 15;
  View.OnClickListener b = null;
  public int c = 1;
  private final int d = 1;
  private final int e = 2;
  private final int f = 3;
  private final int g = 4;
  private LoginMsgActivity h = null;
  private LayoutInflater i = null;
  private View j;
  private View k;
  private View l;
  private dk m;
  private OnlineDeviceResult n;
  
  public p(LoginMsgActivity paramLoginMsgActivity)
  {
    this.h = paramLoginMsgActivity;
    this.i = LayoutInflater.from(paramLoginMsgActivity);
  }
  
  private void a(View paramView, final OnlineDeviceResult.a parama, int paramInt)
  {
    Object localObject1 = (RelativeLayout)paramView.findViewById(2131165782);
    Object localObject2 = (RelativeLayout)paramView.findViewById(2131165693);
    Object localObject3 = (RelativeLayout)paramView.findViewById(2131165694);
    Object localObject4 = (RelativeLayout)paramView.findViewById(2131165691);
    Object localObject5 = (RelativeLayout)paramView.findViewById(2131165692);
    TextView localTextView = (TextView)paramView.findViewById(2131165781);
    ((RelativeLayout)localObject1).setVisibility(0);
    ((RelativeLayout)localObject2).setVisibility(8);
    ((RelativeLayout)localObject3).setVisibility(8);
    ((RelativeLayout)localObject4).setVisibility(8);
    ((RelativeLayout)localObject5).setVisibility(8);
    if (paramInt == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(2131493419);
    }
    else
    {
      localTextView.setVisibility(8);
    }
    localObject1 = (ImageView)paramView.findViewById(2131165783);
    localObject2 = (TextView)paramView.findViewById(2131165780);
    localObject3 = (TextView)paramView.findViewById(2131165779);
    localObject4 = (Button)paramView.findViewById(2131165348);
    localObject5 = (ProgressBar)paramView.findViewById(2131165784);
    ((Button)localObject4).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = cb.a();
        String str1 = parama.a;
        String str2 = parama.d;
        int i = parama.e;
        int j = parama.f;
        String str3 = parama.g;
        String str4 = l.a(bz.a(RqdApplication.l()).b());
        p.a(p.this);
        paramAnonymousView.a(0L, str1, str2, i, j, str3, str4, 523005419, 1, "com.tencent.token", LoginMsgActivity.mSkey, p.a(p.this).mHandler);
        this.b.setVisibility(0);
        TMSDKContext.saveActionData(1150063);
      }
    });
    ((ProgressBar)localObject5).setVisibility(8);
    ((TextView)localObject2).setText(parama.b);
    ((TextView)localObject3).setText(parama.c);
    if (parama.h == 4) {
      ((ImageView)localObject1).setImageResource(2131099899);
    } else if (parama.h == 3) {
      ((ImageView)localObject1).setImageResource(2131099926);
    } else {
      ((ImageView)localObject1).setImageResource(2131099915);
    }
    parama = (ImageView)paramView.findViewById(2131165444);
    localObject1 = (ImageView)paramView.findViewById(2131165445);
    paramView = (ImageView)paramView.findViewById(2131165446);
    if (paramInt == 0) {
      parama.setVisibility(0);
    } else {
      parama.setVisibility(8);
    }
    if ((this.n.mDevicesList != null) && (paramInt == this.n.mDevicesList.size() - 1))
    {
      ((ImageView)localObject1).setVisibility(0);
      paramView.setVisibility(8);
      return;
    }
    ((ImageView)localObject1).setVisibility(8);
    paramView.setVisibility(0);
  }
  
  public void a()
  {
    Object localObject = this.m;
    if (localObject == null) {
      return;
    }
    int i1 = ((dk)localObject).a(this.c * 15);
    if (i1 <= 0)
    {
      b();
      g();
      e();
    }
    else if (i1 >= this.c * 15)
    {
      d();
      g();
    }
    else
    {
      e();
      f();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("query login msg=");
    ((StringBuilder)localObject).append(i1);
    g.a(((StringBuilder)localObject).toString());
    notifyDataSetChanged();
    this.h.checkTimeZoneFlag();
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  protected void a(View paramView, SafeMsgItem paramSafeMsgItem, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramInt1 -= paramInt2;
    Object localObject = (TextView)paramView.findViewById(2131165781);
    if (paramInt1 == 0)
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(2131493310);
    }
    else
    {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = (RelativeLayout)paramView.findViewById(2131165782);
    RelativeLayout localRelativeLayout4 = (RelativeLayout)paramView.findViewById(2131165693);
    RelativeLayout localRelativeLayout1 = (RelativeLayout)paramView.findViewById(2131165694);
    RelativeLayout localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131165691);
    RelativeLayout localRelativeLayout3 = (RelativeLayout)paramView.findViewById(2131165692);
    ((RelativeLayout)localObject).setVisibility(8);
    localRelativeLayout1.setVisibility(0);
    TextView localTextView2 = (TextView)paramView.findViewById(2131166068);
    TextView localTextView3 = (TextView)paramView.findViewById(2131166067);
    TextView localTextView4 = (TextView)paramView.findViewById(2131165752);
    TextView localTextView1 = (TextView)paramView.findViewById(2131165687);
    localObject = (TextView)paramView.findViewById(2131165688);
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131165689);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131165690);
    ImageView localImageView3 = (ImageView)paramView.findViewById(2131165697);
    ImageView localImageView4 = (ImageView)paramView.findViewById(2131165698);
    ImageView localImageView5 = (ImageView)paramView.findViewById(2131165699);
    paramView = (ImageView)paramView.findViewById(2131165700);
    if (paramInt1 == 0)
    {
      localRelativeLayout4.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)localRelativeLayout4.getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
    }
    else
    {
      SafeMsgItem localSafeMsgItem = this.m.b(paramInt1 - 1);
      if ((localSafeMsgItem != null) && (!l.a(localSafeMsgItem.mTime * 1000L, paramSafeMsgItem.mTime * 1000L)))
      {
        localRelativeLayout4.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)localRelativeLayout4.getLayoutParams()).topMargin = 0;
      }
      else
      {
        localRelativeLayout4.setVisibility(8);
      }
    }
    if ((!paramBoolean) && (!paramSafeMsgItem.s()))
    {
      localRelativeLayout1.setBackgroundResource(2131099948);
      localTextView2.setTextAppearance(this.h, 2131558772);
      localTextView3.setTextAppearance(this.h, 2131558771);
      localRelativeLayout2.setVisibility(0);
      localRelativeLayout3.setVisibility(4);
      localImageView3.setBackgroundResource(2131099943);
      if (paramInt1 == getCount() - 1 - paramInt2) {
        localImageView5.setVisibility(4);
      } else {
        localImageView5.setVisibility(0);
      }
    }
    else if ((!paramSafeMsgItem.r()) && (!paramSafeMsgItem.s()))
    {
      localImageView4.setBackgroundResource(2131099945);
      if (paramInt1 == getCount() - 1 - paramInt2) {
        paramView.setVisibility(4);
      } else {
        paramView.setVisibility(0);
      }
      localRelativeLayout1.setBackgroundResource(2131099947);
      localTextView2.setTextAppearance(this.h, 2131558768);
      localTextView3.setTextAppearance(this.h, 2131558767);
      localRelativeLayout2.setVisibility(4);
      localRelativeLayout3.setVisibility(0);
    }
    else
    {
      localRelativeLayout1.setBackgroundResource(2131099948);
      localTextView2.setTextAppearance(this.h, 2131558772);
      localTextView3.setTextAppearance(this.h, 2131558771);
      localRelativeLayout2.setVisibility(4);
      localRelativeLayout3.setVisibility(0);
      localImageView4.setBackgroundResource(2131099944);
      if (paramInt1 == getCount() - 1 - paramInt2) {
        paramView.setVisibility(4);
      } else {
        paramView.setVisibility(0);
      }
    }
    localTextView2.setText(paramSafeMsgItem.c());
    paramInt1 = paramSafeMsgItem.d().indexOf('|');
    if (paramInt1 != -1) {
      localTextView3.setText(paramSafeMsgItem.d().substring(0, paramInt1));
    } else {
      localTextView3.setText(paramSafeMsgItem.d());
    }
    localTextView4.setText(l.d(paramSafeMsgItem.e() * 1000L));
    paramView = l.b(paramSafeMsgItem.e() * 1000L);
    if (paramView.length() > 2)
    {
      localTextView1.setVisibility(8);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(paramView);
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(0);
      return;
    }
    ((TextView)localObject).setVisibility(8);
    localTextView1.setVisibility(0);
    localTextView1.setText(paramView);
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(4);
  }
  
  public void a(dk paramdk, OnlineDeviceResult paramOnlineDeviceResult)
  {
    this.m = paramdk;
    this.n = paramOnlineDeviceResult;
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public void b()
  {
    TextView localTextView = (TextView)this.j.findViewById(2131166086);
    localTextView.setVisibility(0);
    ImageView localImageView = (ImageView)this.j.findViewById(2131165595);
    OnlineDeviceResult localOnlineDeviceResult = this.n;
    if ((localOnlineDeviceResult != null) && (localOnlineDeviceResult.mDevicesList != null) && (this.n.mDevicesList.size() > 0))
    {
      localTextView.setVisibility(8);
      localImageView.setVisibility(8);
      return;
    }
    localTextView.setText(2131493412);
    localTextView.setVisibility(0);
    localImageView.setVisibility(0);
  }
  
  public void b(View paramView)
  {
    this.l = paramView;
  }
  
  public void c()
  {
    this.j.findViewById(2131166086).setVisibility(8);
    this.j.findViewById(2131165595).setVisibility(8);
  }
  
  public void c(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = p.this;
        paramAnonymousView.c += 1;
        p.this.a();
      }
    });
  }
  
  public void d()
  {
    this.k.findViewById(2131165744).setVisibility(0);
  }
  
  public void e()
  {
    this.k.findViewById(2131165744).setVisibility(8);
  }
  
  public void f()
  {
    this.l.setVisibility(0);
  }
  
  public void g()
  {
    this.l.setVisibility(8);
  }
  
  public int getCount()
  {
    Object localObject = this.n;
    if (localObject != null) {
      localObject = ((OnlineDeviceResult)localObject).mDevicesList;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return ((ArrayList)localObject).size() + this.m.g();
    }
    localObject = this.m;
    if (localObject == null) {
      return 0;
    }
    return ((dk)localObject).g();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.i.inflate(2131296365, paramViewGroup, false);
    }
    paramView = this.n;
    int i1;
    if ((paramView != null) && (paramView.mDevicesList != null)) {
      i1 = this.n.mDevicesList.size();
    } else {
      i1 = 0;
    }
    paramView = this.n;
    if ((paramView != null) && (paramView.mDevicesList != null) && (i1 > paramInt))
    {
      paramView = (OnlineDeviceResult.a)this.n.mDevicesList.get(paramInt);
      paramViewGroup = this.i.inflate(2131296365, paramViewGroup, false);
      a(paramViewGroup, paramView, paramInt);
      return paramViewGroup;
    }
    paramView = this.m;
    if (paramView == null) {
      return null;
    }
    int i2 = paramInt - i1;
    paramView = paramView.b(i2);
    if (paramView != null)
    {
      boolean bool;
      if ((paramView.b() & 0x4) == 4) {
        bool = true;
      } else {
        bool = false;
      }
      localView.setOnClickListener(new a(paramView, i2));
      if (bool) {
        localView.setOnTouchListener(new b(true, paramView.r()));
      } else {
        localView.setOnTouchListener(new b(false, paramView.r()));
      }
      a(localView, paramView, paramInt, bool, i1);
    }
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  private class a
    implements View.OnClickListener
  {
    int a;
    SafeMsgItem b;
    
    public a(SafeMsgItem paramSafeMsgItem, int paramInt)
    {
      this.a = paramInt;
      this.b = paramSafeMsgItem;
    }
    
    public void onClick(View paramView)
    {
      paramView = new Intent(p.a(p.this), OpMsgDisplayActivity.class);
      paramView.putExtra("position", this.a);
      paramView.putExtra("type", 1);
      paramView.putExtra("ipcmsg", this.b.q());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ipsmsg = ");
      localStringBuilder.append(this.b.q());
      g.c(localStringBuilder.toString());
      p.a(p.this).startActivity(paramView);
      TMSDKContext.SaveStringData(1150064, "");
    }
  }
  
  private class b
    implements View.OnTouchListener
  {
    private boolean b;
    private boolean c;
    
    public b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131166068);
      TextView localTextView2 = (TextView)paramView.findViewById(2131166067);
      TextView localTextView3 = (TextView)paramView.findViewById(2131165752);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131165694);
      int i = p.a(p.this).getResources().getColor(2130968665);
      switch (paramMotionEvent.getAction())
      {
      default: 
        break;
      case 2: 
        if (paramView.isPressed())
        {
          localTextView1.setTextColor(i);
          localTextView2.setTextColor(i);
          localTextView3.setTextColor(i);
          localRelativeLayout.setBackgroundResource(2131099949);
        }
        break;
      case 1: 
      case 3: 
        if (this.b)
        {
          if (this.c)
          {
            localRelativeLayout.setBackgroundResource(2131099948);
            localTextView1.setTextAppearance(p.a(p.this), 2131558772);
            localTextView2.setTextAppearance(p.a(p.this), 2131558771);
          }
          else
          {
            localRelativeLayout.setBackgroundResource(2131099947);
            localTextView1.setTextAppearance(p.a(p.this), 2131558768);
            localTextView2.setTextAppearance(p.a(p.this), 2131558767);
          }
        }
        else
        {
          localRelativeLayout.setBackgroundResource(2131099948);
          localTextView1.setTextAppearance(p.a(p.this), 2131558772);
          localTextView2.setTextAppearance(p.a(p.this), 2131558771);
        }
        localTextView3.setTextAppearance(p.a(p.this), 2131558783);
        break;
      }
      localTextView1.setTextColor(i);
      localTextView2.setTextColor(i);
      localTextView3.setTextColor(i);
      localRelativeLayout.setBackgroundResource(2131099949);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.p
 * JD-Core Version:    0.7.0.1
 */