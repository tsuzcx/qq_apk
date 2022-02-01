package com.tencent.token;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
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
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.bean.OnlineDeviceResult.a;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.LoginMsgActivity;
import com.tencent.token.ui.OpMsgDisplayActivity;
import com.tmsdk.TMSDKContext;
import java.util.ArrayList;
import oicq.wlogin_sdk.request.WtloginHelper;

public final class yr
  extends BaseAdapter
{
  public final int a = 15;
  View.OnClickListener b = null;
  public View c;
  public View d;
  public View e;
  public int f = 1;
  private final int g = 1;
  private final int h = 2;
  private final int i = 3;
  private final int j = 4;
  private LoginMsgActivity k = null;
  private LayoutInflater l = null;
  private aay m;
  private OnlineDeviceResult n;
  
  public yr(LoginMsgActivity paramLoginMsgActivity)
  {
    this.k = paramLoginMsgActivity;
    this.l = LayoutInflater.from(paramLoginMsgActivity);
  }
  
  public final void a()
  {
    aay localaay = this.m;
    if (localaay == null) {
      return;
    }
    int i1 = localaay.a(this.f * 15);
    if (i1 <= 0)
    {
      b();
      f();
      d();
    }
    else if (i1 >= this.f * 15)
    {
      c();
      f();
    }
    else
    {
      d();
      e();
    }
    xj.a("query login msg=".concat(String.valueOf(i1)));
    notifyDataSetChanged();
    this.k.checkTimeZoneFlag();
  }
  
  public final void a(aay paramaay, OnlineDeviceResult paramOnlineDeviceResult)
  {
    this.m = paramaay;
    this.n = paramOnlineDeviceResult;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public final void b()
  {
    TextView localTextView = (TextView)this.c.findViewById(2131166096);
    localTextView.setVisibility(0);
    ImageView localImageView = (ImageView)this.c.findViewById(2131165599);
    OnlineDeviceResult localOnlineDeviceResult = this.n;
    if ((localOnlineDeviceResult != null) && (localOnlineDeviceResult.mDevicesList != null) && (this.n.mDevicesList.size() > 0))
    {
      localTextView.setVisibility(8);
      localImageView.setVisibility(8);
      return;
    }
    localTextView.setText(2131493413);
    localTextView.setVisibility(0);
    localImageView.setVisibility(0);
  }
  
  public final void c()
  {
    this.d.findViewById(2131165751).setVisibility(0);
  }
  
  public final void d()
  {
    this.d.findViewById(2131165751).setVisibility(8);
  }
  
  public final void e()
  {
    this.e.setVisibility(0);
  }
  
  public final void f()
  {
    this.e.setVisibility(8);
  }
  
  public final int getCount()
  {
    Object localObject = this.n;
    if (localObject != null) {
      localObject = ((OnlineDeviceResult)localObject).mDevicesList;
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return ((ArrayList)localObject).size() + this.m.e();
    }
    localObject = this.m;
    if (localObject == null) {
      return 0;
    }
    return ((aay)localObject).e();
  }
  
  public final Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
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
    if (paramView == null) {
      paramView = this.l.inflate(2131296366, paramViewGroup, false);
    }
    Object localObject1 = this.n;
    int i1;
    if ((localObject1 != null) && (((OnlineDeviceResult)localObject1).mDevicesList != null)) {
      i1 = this.n.mDevicesList.size();
    } else {
      i1 = 0;
    }
    localObject1 = this.n;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    TextView localTextView1;
    if ((localObject1 != null) && (((OnlineDeviceResult)localObject1).mDevicesList != null) && (i1 > paramInt))
    {
      localObject1 = (OnlineDeviceResult.a)this.n.mDevicesList.get(paramInt);
      paramView = this.l.inflate(2131296366, paramViewGroup, false);
      paramViewGroup = (RelativeLayout)paramView.findViewById(2131165789);
      localObject2 = (RelativeLayout)paramView.findViewById(2131165699);
      localObject3 = (RelativeLayout)paramView.findViewById(2131165700);
      localObject4 = (RelativeLayout)paramView.findViewById(2131165697);
      localObject5 = (RelativeLayout)paramView.findViewById(2131165698);
      localTextView1 = (TextView)paramView.findViewById(2131165788);
      paramViewGroup.setVisibility(0);
      ((RelativeLayout)localObject2).setVisibility(8);
      ((RelativeLayout)localObject3).setVisibility(8);
      ((RelativeLayout)localObject4).setVisibility(8);
      ((RelativeLayout)localObject5).setVisibility(8);
      if (paramInt == 0)
      {
        localTextView1.setVisibility(0);
        localTextView1.setText(2131493420);
      }
      else
      {
        localTextView1.setVisibility(8);
      }
      paramViewGroup = (ImageView)paramView.findViewById(2131165790);
      localObject2 = (TextView)paramView.findViewById(2131165787);
      localObject3 = (TextView)paramView.findViewById(2131165786);
      localObject4 = (Button)paramView.findViewById(2131165352);
      localObject5 = (ProgressBar)paramView.findViewById(2131165791);
      ((Button)localObject4).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = si.a();
          Object localObject = this.a.a;
          String str1 = this.a.d;
          int i = this.a.e;
          int j = this.a.f;
          String str2 = this.a.g;
          String str3 = aao.a(sg.a(RqdApplication.p()).a.GetGuid());
          yr.a(yr.this);
          String str4 = LoginMsgActivity.mSkey;
          Handler localHandler = yr.a(yr.this).mHandler;
          QQUser localQQUser = th.a().k.b();
          if (localQQUser == null)
          {
            paramAnonymousView = localHandler.obtainMessage(3056);
            localObject = new xh();
            ((xh)localObject).a(110, null, null);
            paramAnonymousView.arg1 = ((xh)localObject).a;
            paramAnonymousView.obj = localObject;
            paramAnonymousView.sendToTarget();
          }
          else
          {
            long l = localQQUser.mUin;
            rf.a().a(l, (String)localObject, str1, i, str2, str3, "com.tencent.token", str4, new si.31(paramAnonymousView, l, i, j, str2, (String)localObject, localHandler));
          }
          this.b.setVisibility(0);
          TMSDKContext.saveActionData(1150063);
        }
      });
      ((ProgressBar)localObject5).setVisibility(8);
      ((TextView)localObject2).setText(((OnlineDeviceResult.a)localObject1).b);
      ((TextView)localObject3).setText(((OnlineDeviceResult.a)localObject1).c);
      if (((OnlineDeviceResult.a)localObject1).h == 4) {
        paramViewGroup.setImageResource(2131099900);
      } else if (((OnlineDeviceResult.a)localObject1).h == 3) {
        paramViewGroup.setImageResource(2131099927);
      } else {
        paramViewGroup.setImageResource(2131099916);
      }
      paramViewGroup = (ImageView)paramView.findViewById(2131165448);
      localObject1 = (ImageView)paramView.findViewById(2131165449);
      localObject2 = (ImageView)paramView.findViewById(2131165450);
      if (paramInt == 0) {
        paramViewGroup.setVisibility(0);
      } else {
        paramViewGroup.setVisibility(8);
      }
      if ((this.n.mDevicesList != null) && (paramInt == this.n.mDevicesList.size() - 1))
      {
        ((ImageView)localObject1).setVisibility(0);
        ((ImageView)localObject2).setVisibility(8);
        return paramView;
      }
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      return paramView;
    }
    paramViewGroup = this.m;
    if (paramViewGroup == null) {
      return null;
    }
    int i2 = paramInt - i1;
    Object localObject2 = paramViewGroup.b(i2);
    if (localObject2 != null)
    {
      if ((((SafeMsgItem)localObject2).mFlag & 0x4) == 4) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      paramView.setOnClickListener(new a((SafeMsgItem)localObject2, i2));
      if (paramInt != 0) {
        paramView.setOnTouchListener(new b(true, ((SafeMsgItem)localObject2).c()));
      } else {
        paramView.setOnTouchListener(new b(false, ((SafeMsgItem)localObject2).c()));
      }
      paramViewGroup = (TextView)paramView.findViewById(2131165788);
      if (i2 == 0)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setText(2131493311);
      }
      else
      {
        paramViewGroup.setVisibility(8);
      }
      paramViewGroup = (RelativeLayout)paramView.findViewById(2131165789);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131165699);
      localObject3 = (RelativeLayout)paramView.findViewById(2131165700);
      localObject4 = (RelativeLayout)paramView.findViewById(2131165697);
      localObject5 = (RelativeLayout)paramView.findViewById(2131165698);
      paramViewGroup.setVisibility(8);
      ((RelativeLayout)localObject3).setVisibility(0);
      TextView localTextView3 = (TextView)paramView.findViewById(2131166078);
      TextView localTextView4 = (TextView)paramView.findViewById(2131166077);
      TextView localTextView5 = (TextView)paramView.findViewById(2131165759);
      localTextView1 = (TextView)paramView.findViewById(2131165693);
      TextView localTextView2 = (TextView)paramView.findViewById(2131165694);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131165695);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131165696);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131165703);
      localObject1 = (ImageView)paramView.findViewById(2131165704);
      ImageView localImageView4 = (ImageView)paramView.findViewById(2131165705);
      paramViewGroup = (ImageView)paramView.findViewById(2131165706);
      if (i2 == 0)
      {
        localRelativeLayout.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)localRelativeLayout.getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
      }
      else
      {
        SafeMsgItem localSafeMsgItem = this.m.b(i2 - 1);
        if ((localSafeMsgItem != null) && (!aao.a(localSafeMsgItem.mTime * 1000L, ((SafeMsgItem)localObject2).mTime * 1000L)))
        {
          localRelativeLayout.setVisibility(0);
          ((ViewGroup.MarginLayoutParams)localRelativeLayout.getLayoutParams()).topMargin = 0;
        }
        else
        {
          localRelativeLayout.setVisibility(8);
        }
      }
      if ((paramInt == 0) && (!((SafeMsgItem)localObject2).d()))
      {
        ((RelativeLayout)localObject3).setBackgroundResource(2131099949);
        localTextView3.setTextAppearance(this.k, 2131558772);
        localTextView4.setTextAppearance(this.k, 2131558771);
        ((RelativeLayout)localObject4).setVisibility(0);
        ((RelativeLayout)localObject5).setVisibility(4);
        localImageView3.setBackgroundResource(2131099944);
        if (i2 == getCount() - 1 - i1) {
          localImageView4.setVisibility(4);
        } else {
          localImageView4.setVisibility(0);
        }
      }
      else if ((!((SafeMsgItem)localObject2).c()) && (!((SafeMsgItem)localObject2).d()))
      {
        ((ImageView)localObject1).setBackgroundResource(2131099946);
        if (i2 == getCount() - 1 - i1) {
          paramViewGroup.setVisibility(4);
        } else {
          paramViewGroup.setVisibility(0);
        }
        ((RelativeLayout)localObject3).setBackgroundResource(2131099948);
        localTextView3.setTextAppearance(this.k, 2131558768);
        localTextView4.setTextAppearance(this.k, 2131558767);
        ((RelativeLayout)localObject4).setVisibility(4);
        ((RelativeLayout)localObject5).setVisibility(0);
      }
      else
      {
        ((RelativeLayout)localObject3).setBackgroundResource(2131099949);
        localTextView3.setTextAppearance(this.k, 2131558772);
        localTextView4.setTextAppearance(this.k, 2131558771);
        ((RelativeLayout)localObject4).setVisibility(4);
        ((RelativeLayout)localObject5).setVisibility(0);
        ((ImageView)localObject1).setBackgroundResource(2131099945);
        if (i2 == getCount() - 1 - i1) {
          paramViewGroup.setVisibility(4);
        } else {
          paramViewGroup.setVisibility(0);
        }
      }
      localTextView3.setText(((SafeMsgItem)localObject2).mTitle);
      paramInt = ((SafeMsgItem)localObject2).mContent.indexOf('|');
      if (paramInt != -1) {
        localTextView4.setText(((SafeMsgItem)localObject2).mContent.substring(0, paramInt));
      } else {
        localTextView4.setText(((SafeMsgItem)localObject2).mContent);
      }
      localTextView5.setText(aao.d(((SafeMsgItem)localObject2).mTime * 1000L));
      paramViewGroup = aao.b(((SafeMsgItem)localObject2).mTime * 1000L);
      if (paramViewGroup.length() > 2)
      {
        localTextView1.setVisibility(8);
        localTextView2.setVisibility(0);
        localTextView2.setText(paramViewGroup);
        localImageView1.setVisibility(4);
        localImageView2.setVisibility(0);
      }
      else
      {
        localTextView2.setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(paramViewGroup);
        localImageView1.setVisibility(0);
        localImageView2.setVisibility(4);
      }
    }
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  final class a
    implements View.OnClickListener
  {
    int a;
    SafeMsgItem b;
    
    public a(SafeMsgItem paramSafeMsgItem, int paramInt)
    {
      this.a = paramInt;
      this.b = paramSafeMsgItem;
    }
    
    public final void onClick(View paramView)
    {
      paramView = new Intent(yr.a(yr.this), OpMsgDisplayActivity.class);
      paramView.putExtra("position", this.a);
      paramView.putExtra("type", 1);
      paramView.putExtra("ipcmsg", this.b.b());
      StringBuilder localStringBuilder = new StringBuilder("ipsmsg = ");
      localStringBuilder.append(this.b.b());
      xj.c(localStringBuilder.toString());
      yr.a(yr.this).startActivity(paramView);
      TMSDKContext.SaveStringData(1150064, "");
    }
  }
  
  final class b
    implements View.OnTouchListener
  {
    private boolean b;
    private boolean c;
    
    public b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      TextView localTextView1 = (TextView)paramView.findViewById(2131166078);
      TextView localTextView2 = (TextView)paramView.findViewById(2131166077);
      TextView localTextView3 = (TextView)paramView.findViewById(2131165759);
      RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131165700);
      int i = yr.a(yr.this).getResources().getColor(2130968665);
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
          localRelativeLayout.setBackgroundResource(2131099950);
        }
        break;
      case 1: 
      case 3: 
        if ((this.b) && (!this.c))
        {
          localRelativeLayout.setBackgroundResource(2131099948);
          localTextView1.setTextAppearance(yr.a(yr.this), 2131558768);
          localTextView2.setTextAppearance(yr.a(yr.this), 2131558767);
        }
        else
        {
          localRelativeLayout.setBackgroundResource(2131099949);
          localTextView1.setTextAppearance(yr.a(yr.this), 2131558772);
          localTextView2.setTextAppearance(yr.a(yr.this), 2131558771);
        }
        localTextView3.setTextAppearance(yr.a(yr.this), 2131558783);
        break;
      }
      localTextView1.setTextColor(i);
      localTextView2.setTextColor(i);
      localTextView3.setTextColor(i);
      localRelativeLayout.setBackgroundResource(2131099950);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.yr
 * JD-Core Version:    0.7.0.1
 */