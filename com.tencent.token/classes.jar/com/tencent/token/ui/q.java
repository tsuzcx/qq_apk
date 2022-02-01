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
import com.tencent.token.cu;
import com.tencent.token.dj;
import com.tencent.token.global.g;
import com.tencent.token.utils.l;

class q
  extends BaseAdapter
{
  View.OnClickListener a = null;
  dj b;
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
      TextView localTextView1 = (TextView)paramAnonymousView.findViewById(2131558539);
      TextView localTextView2 = (TextView)paramAnonymousView.findViewById(2131558540);
      TextView localTextView3 = (TextView)paramAnonymousView.findViewById(2131558541);
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)paramAnonymousView.getTag();
      if ((localSafeMsgItem.b() & 0x80) == 128) {}
      for (int i = 1;; i = 0) {
        switch (paramAnonymousMotionEvent.getAction())
        {
        default: 
          return false;
        }
      }
      localTextView1.setTextColor(q.this.e);
      localTextView2.setTextColor(q.this.e);
      localTextView3.setTextColor(q.this.e);
      return false;
      if (paramAnonymousView.isPressed())
      {
        localTextView1.setTextColor(q.this.e);
        localTextView2.setTextColor(q.this.e);
        localTextView3.setTextColor(q.this.e);
        return false;
      }
      if ((localSafeMsgItem != null) && (!localSafeMsgItem.mIsRead))
      {
        if (i != 0) {
          localTextView1.setTextColor(q.this.g);
        }
        for (;;)
        {
          localTextView3.setTextColor(q.this.c);
          localTextView2.setTextColor(q.this.d);
          return false;
          localTextView1.setTextColor(q.this.c);
        }
      }
      localTextView1.setTextColor(q.this.f);
      localTextView3.setTextColor(q.this.f);
      localTextView2.setTextColor(q.this.f);
      return false;
    }
  };
  
  public q(OpreateMsgActivity paramOpreateMsgActivity)
  {
    this.h = paramOpreateMsgActivity;
    this.i = LayoutInflater.from(paramOpreateMsgActivity);
    this.b = cu.a().f;
    this.c = this.h.getResources().getColor(2131493067);
    this.d = this.h.getResources().getColor(2131493067);
    this.e = this.h.getResources().getColor(2131492933);
    this.f = this.h.getResources().getColor(2131492930);
    this.g = this.h.getResources().getColor(2131493049);
  }
  
  private String a(long paramLong)
  {
    return l.a(paramLong).replace("-", this.h.getString(2131231248)) + this.h.getString(2131231247) + " " + l.d(paramLong);
  }
  
  public void a()
  {
    this.j.findViewById(2131559039).setVisibility(8);
    this.j.findViewById(2131559038).setVisibility(8);
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  protected void a(View paramView, SafeMsgItem paramSafeMsgItem)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131558539);
    TextView localTextView2 = (TextView)paramView.findViewById(2131558540);
    TextView localTextView3 = (TextView)paramView.findViewById(2131558541);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131559037);
    localCheckBox.setOnCheckedChangeListener(new a(paramSafeMsgItem));
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131559000);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131559036);
    paramView.setTag(paramSafeMsgItem);
    boolean bool;
    if (paramSafeMsgItem.mIsRead)
    {
      localTextView3.setTextColor(this.f);
      localTextView1.setTextColor(this.f);
      localTextView2.setTextColor(this.f);
      paramView.setBackgroundResource(2130837788);
      localImageView2.setVisibility(4);
      if ((paramSafeMsgItem.b() & 0x80) != 128) {
        break label329;
      }
      bool = true;
      label147:
      if (!bool) {
        break label334;
      }
      localImageView2.setImageResource(2130837742);
      paramView.setBackgroundResource(2130837831);
      localTextView1.setTextColor(this.g);
      label173:
      g.c("opreate msg exp: " + bool + ", flag=" + paramSafeMsgItem.b());
      if (!this.h.isListEdit()) {
        break label359;
      }
      localCheckBox.setVisibility(0);
      localImageView1.setVisibility(8);
      localTextView3.setVisibility(8);
    }
    for (;;)
    {
      localCheckBox.setChecked(paramSafeMsgItem.mIsChecked);
      if (paramSafeMsgItem.c() != null) {
        localTextView1.setText(Html.fromHtml(paramSafeMsgItem.c()));
      }
      if (paramSafeMsgItem.d() != null) {
        localTextView2.setText(Html.fromHtml(paramSafeMsgItem.d()));
      }
      localTextView3.setText(a(paramSafeMsgItem.e() * 1000L));
      return;
      localTextView3.setTextColor(this.c);
      localTextView2.setTextColor(this.d);
      localImageView2.setVisibility(0);
      break;
      label329:
      bool = false;
      break label147;
      label334:
      localImageView2.setImageResource(2130837745);
      paramView.setBackgroundResource(2130837830);
      localTextView1.setTextColor(this.c);
      break label173;
      label359:
      paramSafeMsgItem.mIsChecked = false;
      localCheckBox.setVisibility(8);
      localImageView1.setVisibility(0);
      localTextView3.setVisibility(0);
    }
  }
  
  public void a(String paramString)
  {
    TextView localTextView = (TextView)this.j.findViewById(2131559039);
    if ((paramString != null) && (paramString.length() > 0)) {
      localTextView.setText(paramString);
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      this.j.findViewById(2131559038).setVisibility(0);
      return;
      localTextView.setText(2131231272);
    }
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
    for (;;)
    {
      this.h.finishRefresh(paramBoolean);
      notifyDataSetChanged();
      this.h.checkTimeZoneFlag();
      return;
      a();
      if (n >= this.l * 15) {
        b();
      } else {
        c();
      }
    }
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public void b()
  {
    this.k.findViewById(2131559029).setVisibility(0);
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
    this.k.findViewById(2131559029).setVisibility(8);
  }
  
  public int getCount()
  {
    if (this.b.g() >= this.l * 15) {
      return this.l * 15;
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
      localView = this.i.inflate(2130968697, paramViewGroup, false);
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
        return;
      }
      this.a.mIsChecked = false;
      q.b(q.this).setSelectState(false);
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
      if (q.b(q.this).isListEdit()) {}
      do
      {
        return;
        Intent localIntent = new Intent(q.b(q.this), OpMsgDisplayActivity.class);
        localIntent.putExtra("position", this.b);
        localIntent.putExtra("type", 2);
        localIntent.putExtra("abnormmsg", this.a.p());
        q.b(q.this).startActivity(localIntent);
      } while (this.a.mIsRead);
      paramView.postDelayed(new q.b(q.this, this.a), 5L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.q
 * JD-Core Version:    0.7.0.1
 */