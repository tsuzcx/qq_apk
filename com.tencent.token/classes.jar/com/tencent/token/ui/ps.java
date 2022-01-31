package com.tencent.token.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.core.bean.OnlineDeviceResult;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.core.bean.g;
import com.tencent.token.er;
import com.tencent.token.global.h;
import com.tencent.token.utils.w;
import java.util.ArrayList;

class ps
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
  private er m;
  private OnlineDeviceResult n;
  
  public ps(LoginMsgActivity paramLoginMsgActivity)
  {
    this.h = paramLoginMsgActivity;
    this.i = LayoutInflater.from(paramLoginMsgActivity);
  }
  
  private void a(View paramView, g paramg, int paramInt)
  {
    Object localObject1 = (RelativeLayout)paramView.findViewById(2131558990);
    Object localObject2 = (RelativeLayout)paramView.findViewById(2131558524);
    Object localObject3 = (RelativeLayout)paramView.findViewById(2131558538);
    Object localObject4 = (RelativeLayout)paramView.findViewById(2131558530);
    Object localObject5 = (RelativeLayout)paramView.findViewById(2131558534);
    TextView localTextView = (TextView)paramView.findViewById(2131558989);
    ((RelativeLayout)localObject1).setVisibility(0);
    ((RelativeLayout)localObject2).setVisibility(8);
    ((RelativeLayout)localObject3).setVisibility(8);
    ((RelativeLayout)localObject4).setVisibility(8);
    ((RelativeLayout)localObject5).setVisibility(8);
    if (paramInt == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(2131231277);
      localObject1 = (ImageView)paramView.findViewById(2131558992);
      localObject2 = (TextView)paramView.findViewById(2131558996);
      localObject3 = (TextView)paramView.findViewById(2131558997);
      localObject4 = (Button)paramView.findViewById(2131558994);
      localObject5 = (ProgressBar)paramView.findViewById(2131558995);
      ((Button)localObject4).setOnClickListener(new pu(this, paramg, (ProgressBar)localObject5));
      ((ProgressBar)localObject5).setVisibility(8);
      ((TextView)localObject2).setText(paramg.b);
      ((TextView)localObject3).setText(paramg.c);
      if (paramg.h != 4) {
        break label341;
      }
      ((ImageView)localObject1).setImageResource(2130837753);
      label243:
      paramg = (ImageView)paramView.findViewById(2131558991);
      localObject1 = (ImageView)paramView.findViewById(2131558841);
      paramView = (ImageView)paramView.findViewById(2131558998);
      if (paramInt != 0) {
        break label369;
      }
      paramg.setVisibility(0);
    }
    for (;;)
    {
      if ((this.n.mDevicesList == null) || (paramInt != this.n.mDevicesList.size() - 1)) {
        break label378;
      }
      ((ImageView)localObject1).setVisibility(0);
      paramView.setVisibility(8);
      return;
      localTextView.setVisibility(8);
      break;
      label341:
      if (paramg.h == 3)
      {
        ((ImageView)localObject1).setImageResource(2130837780);
        break label243;
      }
      ((ImageView)localObject1).setImageResource(2130837769);
      break label243;
      label369:
      paramg.setVisibility(8);
    }
    label378:
    ((ImageView)localObject1).setVisibility(8);
    paramView.setVisibility(0);
  }
  
  public void a()
  {
    if (this.m == null) {
      return;
    }
    int i1 = this.m.a(this.c * 15);
    if (i1 <= 0)
    {
      b();
      g();
      e();
    }
    for (;;)
    {
      h.a("query login msg=" + i1);
      notifyDataSetChanged();
      this.h.checkTimeZoneFlag();
      return;
      if (i1 >= this.c * 15)
      {
        d();
        g();
      }
      else
      {
        e();
        f();
      }
    }
  }
  
  public void a(View paramView)
  {
    this.j = paramView;
  }
  
  protected void a(View paramView, SafeMsgItem paramSafeMsgItem, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramInt1 -= paramInt2;
    Object localObject1 = (TextView)paramView.findViewById(2131558989);
    Object localObject2;
    RelativeLayout localRelativeLayout1;
    RelativeLayout localRelativeLayout2;
    RelativeLayout localRelativeLayout3;
    TextView localTextView2;
    TextView localTextView3;
    TextView localTextView4;
    TextView localTextView1;
    ImageView localImageView1;
    ImageView localImageView2;
    ImageView localImageView3;
    ImageView localImageView4;
    ImageView localImageView5;
    if (paramInt1 == 0)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(2131231168);
      localObject2 = (RelativeLayout)paramView.findViewById(2131558990);
      localObject1 = (RelativeLayout)paramView.findViewById(2131558524);
      localRelativeLayout1 = (RelativeLayout)paramView.findViewById(2131558538);
      localRelativeLayout2 = (RelativeLayout)paramView.findViewById(2131558530);
      localRelativeLayout3 = (RelativeLayout)paramView.findViewById(2131558534);
      ((RelativeLayout)localObject2).setVisibility(8);
      localRelativeLayout1.setVisibility(0);
      localTextView2 = (TextView)paramView.findViewById(2131558539);
      localTextView3 = (TextView)paramView.findViewById(2131558540);
      localTextView4 = (TextView)paramView.findViewById(2131558541);
      localObject2 = (TextView)paramView.findViewById(2131558527);
      localTextView1 = (TextView)paramView.findViewById(2131558528);
      localImageView1 = (ImageView)paramView.findViewById(2131558525);
      localImageView2 = (ImageView)paramView.findViewById(2131558526);
      localImageView3 = (ImageView)paramView.findViewById(2131558532);
      localImageView4 = (ImageView)paramView.findViewById(2131558536);
      localImageView5 = (ImageView)paramView.findViewById(2131558533);
      paramView = (ImageView)paramView.findViewById(2131558537);
      if (paramInt1 != 0) {
        break label457;
      }
      ((RelativeLayout)localObject1).setVisibility(0);
      ((ViewGroup.MarginLayoutParams)((RelativeLayout)localObject1).getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
      label249:
      if ((!paramBoolean) && (!paramSafeMsgItem.s())) {
        break label617;
      }
      if ((!paramSafeMsgItem.r()) && (!paramSafeMsgItem.s())) {
        break label536;
      }
      localRelativeLayout1.setBackgroundResource(2130837802);
      localTextView2.setTextAppearance(this.h, 2131362164);
      localTextView3.setTextAppearance(this.h, 2131362163);
      localRelativeLayout2.setVisibility(4);
      localRelativeLayout3.setVisibility(0);
      localImageView4.setBackgroundResource(2130837798);
      if (paramInt1 != getCount() - 1 - paramInt2) {
        break label528;
      }
      paramView.setVisibility(4);
      label341:
      localTextView2.setText(paramSafeMsgItem.c());
      paramInt1 = paramSafeMsgItem.d().indexOf('|');
      if (paramInt1 == -1) {
        break label697;
      }
      localTextView3.setText(paramSafeMsgItem.d().substring(0, paramInt1));
    }
    for (;;)
    {
      localTextView4.setText(w.d(paramSafeMsgItem.e() * 1000L));
      paramView = w.b(paramSafeMsgItem.e() * 1000L);
      if (paramView.length() <= 2) {
        break label709;
      }
      ((TextView)localObject2).setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(paramView);
      localImageView1.setVisibility(4);
      localImageView2.setVisibility(0);
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      label457:
      SafeMsgItem localSafeMsgItem = this.m.b(paramInt1 - 1);
      if ((localSafeMsgItem != null) && (!w.a(localSafeMsgItem.mTime * 1000L, paramSafeMsgItem.mTime * 1000L)))
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((ViewGroup.MarginLayoutParams)((RelativeLayout)localObject1).getLayoutParams()).topMargin = 0;
        break label249;
      }
      ((RelativeLayout)localObject1).setVisibility(8);
      break label249;
      label528:
      paramView.setVisibility(0);
      break label341;
      label536:
      localImageView4.setBackgroundResource(2130837799);
      if (paramInt1 == getCount() - 1 - paramInt2) {
        paramView.setVisibility(4);
      }
      for (;;)
      {
        localRelativeLayout1.setBackgroundResource(2130837801);
        localTextView2.setTextAppearance(this.h, 2131362160);
        localTextView3.setTextAppearance(this.h, 2131362159);
        localRelativeLayout2.setVisibility(4);
        localRelativeLayout3.setVisibility(0);
        break;
        paramView.setVisibility(0);
      }
      label617:
      localRelativeLayout1.setBackgroundResource(2130837802);
      localTextView2.setTextAppearance(this.h, 2131362164);
      localTextView3.setTextAppearance(this.h, 2131362163);
      localRelativeLayout2.setVisibility(0);
      localRelativeLayout3.setVisibility(4);
      localImageView3.setBackgroundResource(2130837797);
      if (paramInt1 == getCount() - 1 - paramInt2)
      {
        localImageView5.setVisibility(4);
        break label341;
      }
      localImageView5.setVisibility(0);
      break label341;
      label697:
      localTextView3.setText(paramSafeMsgItem.d());
    }
    label709:
    localTextView1.setVisibility(8);
    ((TextView)localObject2).setVisibility(0);
    ((TextView)localObject2).setText(paramView);
    localImageView1.setVisibility(0);
    localImageView2.setVisibility(4);
  }
  
  public void a(er paramer, OnlineDeviceResult paramOnlineDeviceResult)
  {
    this.m = paramer;
    this.n = paramOnlineDeviceResult;
  }
  
  public boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public void b()
  {
    TextView localTextView = (TextView)this.j.findViewById(2131559038);
    localTextView.setVisibility(0);
    ImageView localImageView = (ImageView)this.j.findViewById(2131559037);
    if ((this.n != null) && (this.n.mDevicesList != null) && (this.n.mDevicesList.size() > 0))
    {
      localTextView.setVisibility(8);
      localImageView.setVisibility(8);
      return;
    }
    localTextView.setText(2131231270);
    localTextView.setVisibility(0);
    localImageView.setVisibility(0);
  }
  
  public void b(View paramView)
  {
    this.l = paramView;
  }
  
  public void c()
  {
    this.j.findViewById(2131559038).setVisibility(8);
    this.j.findViewById(2131559037).setVisibility(8);
  }
  
  public void c(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new pt(this));
  }
  
  public void d()
  {
    this.k.findViewById(2131559028).setVisibility(0);
  }
  
  public void e()
  {
    this.k.findViewById(2131559028).setVisibility(8);
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
    ArrayList localArrayList = null;
    if (this.n != null) {
      localArrayList = this.n.mDevicesList;
    }
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList.size() + this.m.g();
    }
    if (this.m == null) {
      return 0;
    }
    return this.m.g();
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
    if (paramView == null)
    {
      paramView = this.i.inflate(2130968684, paramViewGroup, false);
      if ((this.n == null) || (this.n.mDevicesList == null)) {
        break label234;
      }
    }
    label213:
    label234:
    for (int i1 = this.n.mDevicesList.size();; i1 = 0)
    {
      if ((this.n != null) && (this.n.mDevicesList != null) && (i1 > paramInt))
      {
        paramView = (g)this.n.mDevicesList.get(paramInt);
        paramViewGroup = this.i.inflate(2130968684, paramViewGroup, false);
        a(paramViewGroup, paramView, paramInt);
      }
      SafeMsgItem localSafeMsgItem;
      do
      {
        return paramViewGroup;
        break;
        if (this.m == null) {
          return null;
        }
        localSafeMsgItem = this.m.b(paramInt - i1);
        paramViewGroup = paramView;
      } while (localSafeMsgItem == null);
      boolean bool;
      if ((localSafeMsgItem.b() & 0x4) == 4)
      {
        bool = true;
        paramView.setOnClickListener(new pv(this, localSafeMsgItem, paramInt - i1));
        if (!bool) {
          break label213;
        }
        paramView.setOnTouchListener(new pw(this, true, localSafeMsgItem.r()));
      }
      for (;;)
      {
        a(paramView, localSafeMsgItem, paramInt, bool, i1);
        return paramView;
        bool = false;
        break;
        paramView.setOnTouchListener(new pw(this, false, localSafeMsgItem.r()));
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ps
 * JD-Core Version:    0.7.0.1
 */