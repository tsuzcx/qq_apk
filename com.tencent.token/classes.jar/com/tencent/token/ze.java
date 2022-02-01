package com.tencent.token;

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
import com.tencent.token.ui.OpMsgDisplayActivity;
import com.tencent.token.ui.OpreateMsgActivity;
import java.util.Iterator;
import java.util.List;

public final class ze
  extends BaseAdapter
{
  View.OnClickListener a = null;
  abi b;
  int c;
  int d;
  int e;
  int f;
  int g;
  public View h = null;
  public View i;
  private OpreateMsgActivity j = null;
  private LayoutInflater k = null;
  private int l = 1;
  private View.OnTouchListener m = new View.OnTouchListener()
  {
    public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      TextView localTextView1 = (TextView)paramAnonymousView.findViewById(2131166118);
      TextView localTextView2 = (TextView)paramAnonymousView.findViewById(2131166117);
      TextView localTextView3 = (TextView)paramAnonymousView.findViewById(2131165776);
      SafeMsgItem localSafeMsgItem = (SafeMsgItem)paramAnonymousView.getTag();
      int i;
      if ((localSafeMsgItem.mFlag & 0x80) == 128) {
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
          localTextView1.setTextColor(ze.this.e);
          localTextView2.setTextColor(ze.this.e);
          localTextView3.setTextColor(ze.this.e);
          return false;
        }
      case 1: 
      case 3: 
        if ((localSafeMsgItem != null) && (!localSafeMsgItem.mIsRead))
        {
          if (i != 0) {
            localTextView1.setTextColor(ze.this.g);
          } else {
            localTextView1.setTextColor(ze.this.c);
          }
          localTextView3.setTextColor(ze.this.c);
          localTextView2.setTextColor(ze.this.d);
          return false;
        }
        localTextView1.setTextColor(ze.this.f);
        localTextView3.setTextColor(ze.this.f);
        localTextView2.setTextColor(ze.this.f);
        return false;
      }
      localTextView1.setTextColor(ze.this.e);
      localTextView2.setTextColor(ze.this.e);
      localTextView3.setTextColor(ze.this.e);
      return false;
    }
  };
  
  public ze(OpreateMsgActivity paramOpreateMsgActivity)
  {
    this.j = paramOpreateMsgActivity;
    this.k = LayoutInflater.from(paramOpreateMsgActivity);
    this.b = tx.a().f;
    this.c = this.j.getResources().getColor(2130968804);
    this.d = this.j.getResources().getColor(2130968804);
    this.e = this.j.getResources().getColor(2130968666);
    this.f = this.j.getResources().getColor(2130968663);
    this.g = this.j.getResources().getColor(2130968786);
  }
  
  public final void a()
  {
    this.i.findViewById(2131165768).setVisibility(8);
  }
  
  public final void a(String paramString)
  {
    TextView localTextView = (TextView)this.h.findViewById(2131166136);
    if ((paramString != null) && (paramString.length() > 0)) {
      localTextView.setText(paramString);
    } else {
      localTextView.setText(2131493418);
    }
    localTextView.setVisibility(0);
    this.h.findViewById(2131165616).setVisibility(0);
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
    }
    else
    {
      this.h.findViewById(2131166136).setVisibility(8);
      this.h.findViewById(2131165616).setVisibility(8);
      if (n >= this.l * 15)
      {
        this.i.findViewById(2131165768).setVisibility(0);
        break label107;
      }
    }
    a();
    label107:
    this.j.finishRefresh(paramBoolean);
    notifyDataSetChanged();
    this.j.checkTimeZoneFlag();
  }
  
  public final boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public final int getCount()
  {
    int n = this.b.e();
    int i1 = this.l;
    if (n >= i1 * 15) {
      return i1 * 15;
    }
    return this.b.e();
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
      localView = this.k.inflate(2131296387, paramViewGroup, false);
    }
    paramViewGroup = (SafeMsgItem)getItem(paramInt);
    if (paramViewGroup != null)
    {
      localView.setOnClickListener(new c(paramViewGroup, paramInt));
      localView.setOnTouchListener(this.m);
      TextView localTextView1 = (TextView)localView.findViewById(2131166118);
      TextView localTextView2 = (TextView)localView.findViewById(2131166117);
      paramView = (TextView)localView.findViewById(2131165776);
      CheckBox localCheckBox = (CheckBox)localView.findViewById(2131165373);
      localCheckBox.setOnCheckedChangeListener(new a(paramViewGroup));
      ImageView localImageView = (ImageView)localView.findViewById(2131165291);
      Object localObject = (ImageView)localView.findViewById(2131165772);
      localView.setTag(paramViewGroup);
      if (paramViewGroup.mIsRead)
      {
        paramView.setTextColor(this.f);
        localTextView1.setTextColor(this.f);
        localTextView2.setTextColor(this.f);
        localView.setBackgroundResource(2131099940);
        ((ImageView)localObject).setVisibility(4);
      }
      else
      {
        paramView.setTextColor(this.c);
        localTextView2.setTextColor(this.d);
        ((ImageView)localObject).setVisibility(0);
      }
      boolean bool;
      if ((paramViewGroup.mFlag & 0x80) == 128) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool)
      {
        ((ImageView)localObject).setImageResource(2131099889);
        localView.setBackgroundResource(2131099984);
        localTextView1.setTextColor(this.g);
      }
      else
      {
        ((ImageView)localObject).setImageResource(2131099892);
        localView.setBackgroundResource(2131099983);
        localTextView1.setTextColor(this.c);
      }
      localObject = new StringBuilder("opreate msg exp: ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", flag=");
      ((StringBuilder)localObject).append(paramViewGroup.mFlag);
      xv.c(((StringBuilder)localObject).toString());
      if (this.j.isListEdit())
      {
        localCheckBox.setVisibility(0);
        localImageView.setVisibility(8);
        paramView.setVisibility(8);
      }
      else
      {
        paramViewGroup.mIsChecked = false;
        localCheckBox.setVisibility(8);
        localImageView.setVisibility(0);
        paramView.setVisibility(0);
      }
      localCheckBox.setChecked(paramViewGroup.mIsChecked);
      if (paramViewGroup.mTitle != null) {
        localTextView1.setText(Html.fromHtml(paramViewGroup.mTitle));
      }
      if (paramViewGroup.mContent != null) {
        localTextView2.setText(Html.fromHtml(paramViewGroup.mContent));
      }
      long l1 = paramViewGroup.mTime * 1000L;
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(aay.a(l1).replace("-", this.j.getString(2131493394)));
      paramViewGroup.append(this.j.getString(2131493393));
      paramViewGroup.append(" ");
      paramViewGroup.append(aay.d(l1));
      paramView.setText(paramViewGroup.toString());
    }
    return localView;
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    SafeMsgItem a;
    
    public a(SafeMsgItem paramSafeMsgItem)
    {
      this.a = paramSafeMsgItem;
    }
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      int i = 0;
      if (paramBoolean)
      {
        this.a.mIsChecked = true;
        paramCompoundButton = ze.this.b.b.iterator();
        while (paramCompoundButton.hasNext()) {
          if (!((SafeMsgItem)paramCompoundButton.next()).mIsChecked) {
            break label59;
          }
        }
        i = 1;
        label59:
        if (i != 0) {
          ze.b(ze.this).setSelectState(true);
        }
      }
      else
      {
        this.a.mIsChecked = false;
        ze.b(ze.this).setSelectState(false);
      }
    }
  }
  
  final class b
    implements Runnable
  {
    SafeMsgItem a = null;
    
    public b(SafeMsgItem paramSafeMsgItem)
    {
      this.a = paramSafeMsgItem;
    }
    
    public final void run()
    {
      abi localabi = ze.this.b;
      SafeMsgItem localSafeMsgItem = this.a;
      localSafeMsgItem.mIsRead = true;
      localabi.a.d(localSafeMsgItem.mId);
    }
  }
  
  final class c
    implements View.OnClickListener
  {
    SafeMsgItem a = null;
    int b;
    
    public c(SafeMsgItem paramSafeMsgItem, int paramInt)
    {
      this.a = paramSafeMsgItem;
      this.b = paramInt;
    }
    
    public final void onClick(View paramView)
    {
      if (ze.b(ze.this).isListEdit()) {
        return;
      }
      Intent localIntent = new Intent(ze.b(ze.this), OpMsgDisplayActivity.class);
      localIntent.putExtra("position", this.b);
      localIntent.putExtra("type", 2);
      localIntent.putExtra("abnormmsg", this.a.a());
      ze.b(ze.this).startActivity(localIntent);
      if (!this.a.mIsRead) {
        paramView.postDelayed(new ze.b(ze.this, this.a), 5L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ze
 * JD-Core Version:    0.7.0.1
 */