package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.cw;
import com.tencent.token.dl;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;

class q
  extends BaseAdapter
{
  View.OnClickListener a = null;
  dl b;
  int c;
  int d;
  int e;
  int f;
  int g;
  private OpreateMsgActivity h = null;
  private LayoutInflater i = null;
  private View j = null;
  private View k;
  private int l = 1;
  private View.OnTouchListener m = new View.OnTouchListener()
  {
    public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      TextView localTextView1 = (TextView)paramAnonymousView.findViewById(2131166070);
      TextView localTextView2 = (TextView)paramAnonymousView.findViewById(2131166069);
      TextView localTextView3 = (TextView)paramAnonymousView.findViewById(2131165754);
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)paramAnonymousView.getTag();
      int i;
      if ((localSafeMsgItem.b() & 0x80) == 128) {
        i = 1;
      } else {
        i = 0;
      }
      switch (paramAnonymousMotionEvent.getAction())
      {
      default: 
        return false;
      case 2: 
        if (paramAnonymousView.isPressed())
        {
          localTextView1.setTextColor(q.this.e);
          localTextView2.setTextColor(q.this.e);
          localTextView3.setTextColor(q.this.e);
          return false;
        }
      case 1: 
      case 3: 
        if ((localSafeMsgItem != null) && (!localSafeMsgItem.mIsRead))
        {
          if (i != 0) {
            localTextView1.setTextColor(q.this.g);
          } else {
            localTextView1.setTextColor(q.this.c);
          }
          localTextView3.setTextColor(q.this.c);
          localTextView2.setTextColor(q.this.d);
          return false;
        }
        localTextView1.setTextColor(q.this.f);
        localTextView3.setTextColor(q.this.f);
        localTextView2.setTextColor(q.this.f);
        return false;
      }
      localTextView1.setTextColor(q.this.e);
      localTextView2.setTextColor(q.this.e);
      localTextView3.setTextColor(q.this.e);
      return false;
    }
  };
  
  public q(OpreateMsgActivity paramOpreateMsgActivity)
  {
    this.h = paramOpreateMsgActivity;
    this.i = LayoutInflater.from(paramOpreateMsgActivity);
    this.b = cw.a().f;
    this.c = this.h.getResources().getColor(2130968803);
    this.d = this.h.getResources().getColor(2130968803);
    this.e = this.h.getResources().getColor(2130968665);
    this.f = this.h.getResources().getColor(2130968662);
    this.g = this.h.getResources().getColor(2130968785);
  }
  
  private String a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l.a(paramLong).replace("-", this.h.getString(2131493391)));
    localStringBuilder.append(this.h.getString(2131493390));
    localStringBuilder.append(" ");
    localStringBuilder.append(l.d(paramLong));
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.j.findViewById(2131166088).setVisibility(8);
    this.j.findViewById(2131165597).setVisibility(8);
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  protected void a(View paramView, SafeMsgItem paramSafeMsgItem)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131166070);
    TextView localTextView2 = (TextView)paramView.findViewById(2131166069);
    TextView localTextView3 = (TextView)paramView.findViewById(2131165754);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131165363);
    localCheckBox.setOnCheckedChangeListener(new a(paramSafeMsgItem));
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131165285);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131165750);
    paramView.setTag(paramSafeMsgItem);
    if (paramSafeMsgItem.mIsRead)
    {
      localTextView3.setTextColor(this.f);
      localTextView1.setTextColor(this.f);
      localTextView2.setTextColor(this.f);
      paramView.setBackgroundResource(2131099934);
      localImageView2.setVisibility(4);
    }
    else
    {
      localTextView3.setTextColor(this.c);
      localTextView2.setTextColor(this.d);
      localImageView2.setVisibility(0);
    }
    boolean bool;
    if ((paramSafeMsgItem.b() & 0x80) == 128) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      localImageView2.setImageResource(2131099888);
      paramView.setBackgroundResource(2131099977);
      localTextView1.setTextColor(this.g);
    }
    else
    {
      localImageView2.setImageResource(2131099891);
      paramView.setBackgroundResource(2131099976);
      localTextView1.setTextColor(this.c);
    }
    paramView = new StringBuilder();
    paramView.append("opreate msg exp: ");
    paramView.append(bool);
    paramView.append(", flag=");
    paramView.append(paramSafeMsgItem.b());
    g.c(paramView.toString());
    if (this.h.isListEdit())
    {
      localCheckBox.setVisibility(0);
      localImageView1.setVisibility(8);
      localTextView3.setVisibility(8);
    }
    else
    {
      paramSafeMsgItem.mIsChecked = false;
      localCheckBox.setVisibility(8);
      localImageView1.setVisibility(0);
      localTextView3.setVisibility(0);
    }
    localCheckBox.setChecked(paramSafeMsgItem.mIsChecked);
    if (paramSafeMsgItem.c() != null) {
      localTextView1.setText(Html.fromHtml(paramSafeMsgItem.c()));
    }
    if (paramSafeMsgItem.d() != null) {
      localTextView2.setText(Html.fromHtml(paramSafeMsgItem.d()));
    }
    localTextView3.setText(a(paramSafeMsgItem.e() * 1000L));
  }
  
  public void a(String paramString)
  {
    TextView localTextView = (TextView)this.j.findViewById(2131166088);
    if ((paramString != null) && (paramString.length() > 0)) {
      localTextView.setText(paramString);
    } else {
      localTextView.setText(2131493415);
    }
    localTextView.setVisibility(0);
    this.j.findViewById(2131165597).setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = this.b.a(this.l * 15);
    int n = i1;
    if (i1 <= 0) {
      n = this.b.a(this.l * 15);
    }
    if (n <= 0)
    {
      a(null);
      c();
    }
    else
    {
      a();
      if (n >= this.l * 15) {
        b();
      } else {
        c();
      }
    }
    this.h.finishRefresh(paramBoolean);
    notifyDataSetChanged();
    this.h.checkTimeZoneFlag();
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public void b()
  {
    this.k.findViewById(2131165746).setVisibility(0);
  }
  
  public void b(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        q.a(q.this);
        q.this.a(false);
      }
    });
  }
  
  public void c()
  {
    this.k.findViewById(2131165746).setVisibility(8);
  }
  
  public int getCount()
  {
    int n = this.b.g();
    int i1 = this.l;
    if (n >= i1 * 15) {
      return i1 * 15;
    }
    return this.b.g();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.b(paramInt);
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
      localView = this.i.inflate(2131296378, paramViewGroup, false);
    }
    paramView = (SafeMsgItem)getItem(paramInt);
    if (paramView != null)
    {
      localView.setOnClickListener(new c(paramView, paramInt));
      localView.setOnTouchListener(this.m);
      a(localView, paramView);
    }
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  private class a
    implements CompoundButton.OnCheckedChangeListener
  {
    SafeMsgItem a;
    
    public a(SafeMsgItem paramSafeMsgItem)
    {
      this.a = paramSafeMsgItem;
    }
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.a.mIsChecked = true;
        if (q.this.b.d()) {
          q.b(q.this).setSelectState(true);
        }
      }
      else
      {
        this.a.mIsChecked = false;
        q.b(q.this).setSelectState(false);
      }
    }
  }
  
  private class b
    implements Runnable
  {
    SafeMsgItem a = null;
    
    public b(SafeMsgItem paramSafeMsgItem)
    {
      this.a = paramSafeMsgItem;
    }
    
    public void run()
    {
      q.this.b.a(this.a);
    }
  }
  
  private class c
    implements View.OnClickListener
  {
    SafeMsgItem a = null;
    int b;
    
    public c(SafeMsgItem paramSafeMsgItem, int paramInt)
    {
      this.a = paramSafeMsgItem;
      this.b = paramInt;
    }
    
    public void onClick(View paramView)
    {
      if (q.b(q.this).isListEdit()) {
        return;
      }
      Intent localIntent = new Intent(q.b(q.this), OpMsgDisplayActivity.class);
      localIntent.putExtra("position", this.b);
      localIntent.putExtra("type", 2);
      localIntent.putExtra("abnormmsg", this.a.p());
      q.b(q.this).startActivity(localIntent);
      if (!this.a.mIsRead) {
        paramView.postDelayed(new q.b(q.this, this.a), 5L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.q
 * JD-Core Version:    0.7.0.1
 */