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
import com.tencent.token.bd;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.fo;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;

final class tj
  extends BaseAdapter
{
  View.OnClickListener a = null;
  fo b;
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
  private View.OnTouchListener m = new tk(this);
  
  public tj(OpreateMsgActivity paramOpreateMsgActivity)
  {
    this.h = paramOpreateMsgActivity;
    this.i = LayoutInflater.from(paramOpreateMsgActivity);
    this.b = bd.a().f;
    this.c = this.h.getResources().getColor(2131165207);
    this.d = this.h.getResources().getColor(2131165207);
    this.e = this.h.getResources().getColor(2131165194);
    this.f = this.h.getResources().getColor(2131165197);
    this.g = this.h.getResources().getColor(2131165225);
  }
  
  public final void a()
  {
    this.k.findViewById(2131296830).setVisibility(8);
  }
  
  public final void a(View paramView)
  {
    this.j = paramView;
  }
  
  public final void a(String paramString)
  {
    TextView localTextView = (TextView)this.j.findViewById(2131296735);
    if ((paramString != null) && (paramString.length() > 0)) {
      localTextView.setText(paramString);
    }
    for (;;)
    {
      localTextView.setVisibility(0);
      this.j.findViewById(2131296734).setVisibility(0);
      return;
      localTextView.setText(2131362013);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1 = this.b.a(this.l * 15);
    int n = i1;
    if (i1 <= 0) {
      n = this.b.a(this.l * 15);
    }
    if (n <= 0)
    {
      a(null);
      this.k.findViewById(2131296830).setVisibility(8);
    }
    for (;;)
    {
      this.h.finishRefresh(paramBoolean);
      notifyDataSetChanged();
      this.h.checkTimeZoneFlag();
      return;
      this.j.findViewById(2131296735).setVisibility(8);
      this.j.findViewById(2131296734).setVisibility(8);
      if (n < this.l * 15) {
        break;
      }
      this.k.findViewById(2131296830).setVisibility(0);
    }
  }
  
  public final boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public final void b(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new tl(this));
  }
  
  public final int getCount()
  {
    if (this.b.g() >= this.l * 15) {
      return this.l * 15;
    }
    return this.b.g();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.b.b(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.i.inflate(2130903141, paramViewGroup, false);
    }
    paramView = (SafeMsgItem)getItem(paramInt);
    TextView localTextView1;
    TextView localTextView2;
    CheckBox localCheckBox;
    ImageView localImageView1;
    ImageView localImageView2;
    boolean bool;
    if (paramView != null)
    {
      localView.setOnClickListener(new to(this, paramView, paramInt));
      localView.setOnTouchListener(this.m);
      paramViewGroup = (TextView)localView.findViewById(2131296280);
      localTextView1 = (TextView)localView.findViewById(2131296281);
      localTextView2 = (TextView)localView.findViewById(2131296282);
      localCheckBox = (CheckBox)localView.findViewById(2131296836);
      localCheckBox.setOnCheckedChangeListener(new tm(this, paramView));
      localImageView1 = (ImageView)localView.findViewById(2131296730);
      localImageView2 = (ImageView)localView.findViewById(2131296835);
      localView.setTag(paramView);
      if (!paramView.mIsRead) {
        break label428;
      }
      localTextView2.setTextColor(this.f);
      paramViewGroup.setTextColor(this.f);
      localTextView1.setTextColor(this.f);
      localView.setBackgroundResource(2130837710);
      localImageView2.setVisibility(4);
      if ((paramView.mFlag & 0x80) != 128) {
        break label455;
      }
      bool = true;
      label211:
      if (!bool) {
        break label461;
      }
      localImageView2.setImageResource(2130837663);
      localView.setBackgroundResource(2130837755);
      paramViewGroup.setTextColor(this.g);
      label238:
      e.c("opreate msg exp: " + bool + ", flag=" + paramView.mFlag);
      if (!this.h.isListEdit()) {
        break label488;
      }
      localCheckBox.setVisibility(0);
      localImageView1.setVisibility(8);
      localTextView2.setVisibility(8);
    }
    for (;;)
    {
      localCheckBox.setChecked(paramView.mIsChecked);
      if (paramView.mTitle != null) {
        paramViewGroup.setText(Html.fromHtml(paramView.mTitle));
      }
      if (paramView.mContent != null) {
        localTextView1.setText(Html.fromHtml(paramView.mContent));
      }
      long l1 = paramView.mTime * 1000L;
      localTextView2.setText(s.b(l1).replace("-", this.h.getString(2131362032)) + this.h.getString(2131362033) + " " + s.d(l1));
      return localView;
      label428:
      localTextView2.setTextColor(this.c);
      localTextView1.setTextColor(this.d);
      localImageView2.setVisibility(0);
      break;
      label455:
      bool = false;
      break label211;
      label461:
      localImageView2.setImageResource(2130837666);
      localView.setBackgroundResource(2130837754);
      paramViewGroup.setTextColor(this.c);
      break label238;
      label488:
      paramView.mIsChecked = false;
      localCheckBox.setVisibility(8);
      localImageView1.setVisibility(0);
      localTextView2.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tj
 * JD-Core Version:    0.7.0.1
 */