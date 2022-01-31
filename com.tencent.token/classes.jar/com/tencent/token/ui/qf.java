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
import com.tencent.token.core.bean.f;
import com.tencent.token.fo;
import com.tencent.token.global.e;
import com.tencent.token.utils.s;
import java.util.ArrayList;

final class qf
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
  private fo m;
  private OnlineDeviceResult n;
  
  public qf(LoginMsgActivity paramLoginMsgActivity)
  {
    this.h = paramLoginMsgActivity;
    this.i = LayoutInflater.from(paramLoginMsgActivity);
  }
  
  public final void a()
  {
    if (this.m == null) {
      return;
    }
    int i1 = this.m.a(this.c * 15);
    if (i1 <= 0)
    {
      b();
      this.l.setVisibility(8);
      this.k.findViewById(2131296830).setVisibility(8);
    }
    for (;;)
    {
      e.a("query login msg=" + i1);
      notifyDataSetChanged();
      this.h.checkTimeZoneFlag();
      return;
      if (i1 >= this.c * 15)
      {
        this.k.findViewById(2131296830).setVisibility(0);
        this.l.setVisibility(8);
      }
      else
      {
        this.k.findViewById(2131296830).setVisibility(8);
        this.l.setVisibility(0);
      }
    }
  }
  
  public final void a(View paramView)
  {
    this.j = paramView;
  }
  
  public final void a(fo paramfo, OnlineDeviceResult paramOnlineDeviceResult)
  {
    this.m = paramfo;
    this.n = paramOnlineDeviceResult;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return true;
  }
  
  public final void b()
  {
    TextView localTextView = (TextView)this.j.findViewById(2131296735);
    localTextView.setVisibility(0);
    ImageView localImageView = (ImageView)this.j.findViewById(2131296734);
    if ((this.n != null) && (this.n.mDevicesList != null) && (this.n.mDevicesList.size() > 0))
    {
      localTextView.setVisibility(8);
      localImageView.setVisibility(8);
      return;
    }
    localTextView.setText(2131362014);
    localTextView.setVisibility(0);
    localImageView.setVisibility(0);
  }
  
  public final void b(View paramView)
  {
    this.l = paramView;
  }
  
  public final void c()
  {
    this.j.findViewById(2131296735).setVisibility(8);
    this.j.findViewById(2131296734).setVisibility(8);
  }
  
  public final void c(View paramView)
  {
    this.k = paramView;
    this.k.setOnClickListener(new qg(this));
  }
  
  public final void d()
  {
    this.k.findViewById(2131296830).setVisibility(0);
  }
  
  public final void e()
  {
    this.k.findViewById(2131296830).setVisibility(8);
  }
  
  public final void f()
  {
    this.l.setVisibility(0);
  }
  
  public final void g()
  {
    this.l.setVisibility(8);
  }
  
  public final int getCount()
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
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = this.i.inflate(2130903127, paramViewGroup, false);
    }
    if ((this.n != null) && (this.n.mDevicesList != null)) {}
    for (int i1 = this.n.mDevicesList.size();; i1 = 0)
    {
      Object localObject2;
      Object localObject3;
      Object localObject4;
      Object localObject5;
      TextView localTextView1;
      if ((this.n != null) && (this.n.mDevicesList != null) && (i1 > paramInt))
      {
        localObject1 = (f)this.n.mDevicesList.get(paramInt);
        paramView = this.i.inflate(2130903127, paramViewGroup, false);
        paramViewGroup = (RelativeLayout)paramView.findViewById(2131296787);
        localObject2 = (RelativeLayout)paramView.findViewById(2131296265);
        localObject3 = (RelativeLayout)paramView.findViewById(2131296279);
        localObject4 = (RelativeLayout)paramView.findViewById(2131296271);
        localObject5 = (RelativeLayout)paramView.findViewById(2131296275);
        localTextView1 = (TextView)paramView.findViewById(2131296786);
        paramViewGroup.setVisibility(0);
        ((RelativeLayout)localObject2).setVisibility(8);
        ((RelativeLayout)localObject3).setVisibility(8);
        ((RelativeLayout)localObject4).setVisibility(8);
        ((RelativeLayout)localObject5).setVisibility(8);
        if (paramInt == 0)
        {
          localTextView1.setVisibility(0);
          localTextView1.setText(2131362063);
          paramViewGroup = (ImageView)paramView.findViewById(2131296789);
          localObject2 = (TextView)paramView.findViewById(2131296793);
          localObject3 = (TextView)paramView.findViewById(2131296794);
          localObject4 = (Button)paramView.findViewById(2131296791);
          localObject5 = (ProgressBar)paramView.findViewById(2131296792);
          ((Button)localObject4).setOnClickListener(new qh(this, (f)localObject1, (ProgressBar)localObject5));
          ((ProgressBar)localObject5).setVisibility(8);
          ((TextView)localObject2).setText(((f)localObject1).b);
          ((TextView)localObject3).setText(((f)localObject1).c);
          if (((f)localObject1).h != 4) {
            break label420;
          }
          paramViewGroup.setImageResource(2130837673);
          label328:
          paramViewGroup = (ImageView)paramView.findViewById(2131296788);
          localObject1 = (ImageView)paramView.findViewById(2131296555);
          localObject2 = (ImageView)paramView.findViewById(2131296795);
          if (paramInt != 0) {
            break label447;
          }
          paramViewGroup.setVisibility(0);
          label369:
          if ((this.n.mDevicesList == null) || (paramInt != this.n.mDevicesList.size() - 1)) {
            break label456;
          }
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject2).setVisibility(8);
        }
      }
      label420:
      label447:
      label456:
      do
      {
        return paramView;
        localTextView1.setVisibility(8);
        break;
        if (((f)localObject1).h == 3)
        {
          paramViewGroup.setImageResource(2130837695);
          break label328;
        }
        paramViewGroup.setImageResource(2130837688);
        break label328;
        paramViewGroup.setVisibility(8);
        break label369;
        ((ImageView)localObject1).setVisibility(8);
        ((ImageView)localObject2).setVisibility(0);
        return paramView;
        if (this.m == null) {
          return null;
        }
        paramViewGroup = this.m.b(paramInt - i1);
        paramView = (View)localObject1;
      } while (paramViewGroup == null);
      int i2;
      boolean bool;
      label552:
      int i3;
      label601:
      TextView localTextView2;
      TextView localTextView3;
      TextView localTextView4;
      ImageView localImageView1;
      ImageView localImageView2;
      ImageView localImageView3;
      ImageView localImageView4;
      ImageView localImageView5;
      ImageView localImageView6;
      if ((paramViewGroup.mFlag & 0x4) == 4)
      {
        i2 = 1;
        ((View)localObject1).setOnClickListener(new qi(this, paramViewGroup, paramInt - i1));
        if (i2 == 0) {
          break label1082;
        }
        if ((paramViewGroup.mFlag & 0x100) != 256) {
          break label1076;
        }
        bool = true;
        ((View)localObject1).setOnTouchListener(new qj(this, true, bool));
        i3 = paramInt - i1;
        paramView = (TextView)((View)localObject1).findViewById(2131296786);
        if (i3 != 0) {
          break label1124;
        }
        paramView.setVisibility(0);
        paramView.setText(2131362062);
        localObject5 = (RelativeLayout)((View)localObject1).findViewById(2131296787);
        paramView = (RelativeLayout)((View)localObject1).findViewById(2131296265);
        localObject2 = (RelativeLayout)((View)localObject1).findViewById(2131296279);
        localObject3 = (RelativeLayout)((View)localObject1).findViewById(2131296271);
        localObject4 = (RelativeLayout)((View)localObject1).findViewById(2131296275);
        ((RelativeLayout)localObject5).setVisibility(8);
        ((RelativeLayout)localObject2).setVisibility(0);
        localTextView2 = (TextView)((View)localObject1).findViewById(2131296280);
        localTextView3 = (TextView)((View)localObject1).findViewById(2131296281);
        localTextView4 = (TextView)((View)localObject1).findViewById(2131296282);
        localObject5 = (TextView)((View)localObject1).findViewById(2131296268);
        localTextView1 = (TextView)((View)localObject1).findViewById(2131296269);
        localImageView1 = (ImageView)((View)localObject1).findViewById(2131296266);
        localImageView2 = (ImageView)((View)localObject1).findViewById(2131296267);
        localImageView3 = (ImageView)((View)localObject1).findViewById(2131296273);
        localImageView4 = (ImageView)((View)localObject1).findViewById(2131296277);
        localImageView5 = (ImageView)((View)localObject1).findViewById(2131296274);
        localImageView6 = (ImageView)((View)localObject1).findViewById(2131296278);
        if (i3 != 0) {
          break label1133;
        }
        paramView.setVisibility(0);
        ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = ((int)(10.0F * IndexActivity.S_DENSITY));
        label833:
        if (i2 == 0)
        {
          if ((paramViewGroup.mFlag & 0x1) != 1) {
            break label1202;
          }
          paramInt = 1;
          label850:
          if (paramInt == 0) {
            break label1310;
          }
        }
        if ((paramViewGroup.mFlag & 0x100) != 256) {
          break label1207;
        }
        paramInt = 1;
        label870:
        if (paramInt == 0)
        {
          if ((paramViewGroup.mFlag & 0x1) != 1) {
            break label1212;
          }
          paramInt = 1;
          label886:
          if (paramInt == 0) {
            break label1226;
          }
        }
        ((RelativeLayout)localObject2).setBackgroundResource(2130837727);
        localTextView2.setTextAppearance(this.h, 2131427424);
        localTextView3.setTextAppearance(this.h, 2131427425);
        ((RelativeLayout)localObject3).setVisibility(4);
        ((RelativeLayout)localObject4).setVisibility(0);
        localImageView4.setBackgroundResource(2130837723);
        if (i3 != getCount() - 1 - i1) {
          break label1217;
        }
        localImageView6.setVisibility(4);
        label962:
        localTextView2.setText(paramViewGroup.mTitle);
        paramInt = paramViewGroup.mContent.indexOf('|');
        if (paramInt == -1) {
          break label1394;
        }
        localTextView3.setText(paramViewGroup.mContent.substring(0, paramInt));
      }
      for (;;)
      {
        localTextView4.setText(s.d(paramViewGroup.mTime * 1000L));
        paramView = s.c(paramViewGroup.mTime * 1000L);
        if (paramView.length() <= 2) {
          break label1406;
        }
        ((TextView)localObject5).setVisibility(8);
        localTextView1.setVisibility(0);
        localTextView1.setText(paramView);
        localImageView1.setVisibility(4);
        localImageView2.setVisibility(0);
        return localObject1;
        i2 = 0;
        break;
        label1076:
        bool = false;
        break label552;
        label1082:
        if ((paramViewGroup.mFlag & 0x100) == 256) {}
        for (bool = true;; bool = false)
        {
          ((View)localObject1).setOnTouchListener(new qj(this, false, bool));
          break;
        }
        label1124:
        paramView.setVisibility(8);
        break label601;
        label1133:
        SafeMsgItem localSafeMsgItem = this.m.b(i3 - 1);
        if ((localSafeMsgItem != null) && (!s.a(localSafeMsgItem.mTime * 1000L, paramViewGroup.mTime * 1000L)))
        {
          paramView.setVisibility(0);
          ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = 0;
          break label833;
        }
        paramView.setVisibility(8);
        break label833;
        label1202:
        paramInt = 0;
        break label850;
        label1207:
        paramInt = 0;
        break label870;
        label1212:
        paramInt = 0;
        break label886;
        label1217:
        localImageView6.setVisibility(0);
        break label962;
        label1226:
        localImageView4.setBackgroundResource(2130837724);
        if (i3 == getCount() - 1 - i1) {
          localImageView6.setVisibility(4);
        }
        for (;;)
        {
          ((RelativeLayout)localObject2).setBackgroundResource(2130837726);
          localTextView2.setTextAppearance(this.h, 2131427426);
          localTextView3.setTextAppearance(this.h, 2131427427);
          ((RelativeLayout)localObject3).setVisibility(4);
          ((RelativeLayout)localObject4).setVisibility(0);
          break;
          localImageView6.setVisibility(0);
        }
        label1310:
        ((RelativeLayout)localObject2).setBackgroundResource(2130837727);
        localTextView2.setTextAppearance(this.h, 2131427424);
        localTextView3.setTextAppearance(this.h, 2131427425);
        ((RelativeLayout)localObject3).setVisibility(0);
        ((RelativeLayout)localObject4).setVisibility(4);
        localImageView3.setBackgroundResource(2130837722);
        if (i3 == getCount() - 1 - i1)
        {
          localImageView5.setVisibility(4);
          break label962;
        }
        localImageView5.setVisibility(0);
        break label962;
        label1394:
        localTextView3.setText(paramViewGroup.mContent);
      }
      label1406:
      localTextView1.setVisibility(8);
      ((TextView)localObject5).setVisibility(0);
      ((TextView)localObject5).setText(paramView);
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(4);
      return localObject1;
    }
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qf
 * JD-Core Version:    0.7.0.1
 */