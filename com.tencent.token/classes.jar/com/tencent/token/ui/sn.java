package com.tencent.token.ui;

import android.content.res.Resources;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.du;
import com.tencent.token.er;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;

class sn
  extends BaseAdapter
{
  View.OnClickListener a = null;
  er b;
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
  private View.OnTouchListener m = new so(this);
  
  public sn(OpreateMsgActivity paramOpreateMsgActivity)
  {
    this.h = paramOpreateMsgActivity;
    this.i = LayoutInflater.from(paramOpreateMsgActivity);
    this.b = du.a().f;
    this.c = this.h.getResources().getColor(2131493067);
    this.d = this.h.getResources().getColor(2131493067);
    this.e = this.h.getResources().getColor(2131492933);
    this.f = this.h.getResources().getColor(2131492930);
    this.g = this.h.getResources().getColor(2131493049);
  }
  
  private String a(long paramLong)
  {
    return w.a(paramLong).replace("-", this.h.getString(2131231248)) + this.h.getString(2131231247) + " " + w.d(paramLong);
  }
  
  public void a()
  {
    this.j.findViewById(2131559038).setVisibility(8);
    this.j.findViewById(2131559037).setVisibility(8);
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
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131559036);
    localCheckBox.setOnCheckedChangeListener(new sq(this, paramSafeMsgItem));
    ImageView localImageView1 = (ImageView)paramView.findViewById(2131558999);
    ImageView localImageView2 = (ImageView)paramView.findViewById(2131559035);
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
      h.c("opreate msg exp: " + bool + ", flag=" + paramSafeMsgItem.b());
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
    TextView localTextView = (TextView)this.j.findViewById(2131559038);
    if ((paramString != null) && (paramString.length() > 0)) {
      localTextView.setText(paramString);
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      this.j.findViewById(2131559037).setVisibility(0);
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
    this.k.findViewById(2131559028).setVisibility(0);
  }
  
  public void b(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new sp(this));
  }
  
  public void c()
  {
    this.k.findViewById(2131559028).setVisibility(8);
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
      localView.setOnClickListener(new ss(this, paramView, paramInt));
      localView.setOnTouchListener(this.m);
      a(localView, paramView);
    }
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.sn
 * JD-Core Version:    0.7.0.1
 */