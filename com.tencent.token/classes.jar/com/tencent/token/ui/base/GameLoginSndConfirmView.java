package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.cj;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cz;
import com.tencent.token.do;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.h;
import com.tencent.token.utils.k;
import com.tencent.token.utils.w;
import com.tencent.token.utils.x;
import gameloginsdk.CallbackPushStruct;

public class GameLoginSndConfirmView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private Button d;
  private Button e;
  private ImageView f;
  private Activity g;
  private LayoutInflater h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private Bitmap n;
  private Bitmap o;
  private int p;
  private int q;
  private az r;
  private AlarmManager s = null;
  private PendingIntent t = null;
  private int u;
  private final String v = "com.tencent.token.update_btn_interval_time_action";
  private BroadcastReceiver w = new ao(this);
  private Handler x = new ar(this);
  
  public GameLoginSndConfirmView(Activity paramActivity)
  {
    super(paramActivity);
    this.g = paramActivity;
  }
  
  public GameLoginSndConfirmView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((Activity)paramContext);
  }
  
  public GameLoginSndConfirmView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((Activity)paramContext);
  }
  
  private void f()
  {
    if (this.s != null) {
      return;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.token.update_btn_interval_time_action");
    this.g.registerReceiver(this.w, (IntentFilter)localObject);
    localObject = new Intent("com.tencent.token.update_btn_interval_time_action");
    this.s = ((AlarmManager)this.g.getSystemService("alarm"));
    this.t = PendingIntent.getBroadcast(this.g, 0, (Intent)localObject, 0);
  }
  
  public void a()
  {
    this.x.post(new as(this, this.j, this.k, this.l, this.m));
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      c();
      return;
    }
    b();
  }
  
  public void a(CallbackPushStruct paramCallbackPushStruct)
  {
    if (paramCallbackPushStruct == null) {
      return;
    }
    f();
    this.u = (paramCallbackPushStruct.expirtTime + 1 - cj.a(RqdApplication.l()).c());
    this.a.setText(2131231089);
    if (paramCallbackPushStruct.player.length() > 10)
    {
      localObject = new StringBuffer(paramCallbackPushStruct.player.substring(0, 10) + "...");
      if (((StringBuffer)localObject).length() == 0) {
        break label440;
      }
    }
    label427:
    label440:
    for (Object localObject = "(<font color=#df642c>" + localObject + "</font>)";; localObject = "")
    {
      localObject = new StringBuffer(w.a(paramCallbackPushStruct.uin) + (String)localObject + this.g.getResources().getString(2131231077) + "<font color=#df642c>" + paramCallbackPushStruct.gameName + "-" + paramCallbackPushStruct.world + "</font>" + this.g.getResources().getString(2131231078));
      if (paramCallbackPushStruct.schemeFlag == 2)
      {
        ((StringBuffer)localObject).append("。");
        label224:
        this.b.setText(Html.fromHtml(((StringBuffer)localObject).toString()));
        this.d.setText(getResources().getString(2131231075) + "(" + this.u + ")");
        this.e.setText(getResources().getString(2131231086));
        paramCallbackPushStruct = do.a().d(Long.parseLong(paramCallbackPushStruct.uin));
        if (paramCallbackPushStruct == null) {
          break label427;
        }
        this.f.setImageDrawable(k.a(paramCallbackPushStruct.b() + "", paramCallbackPushStruct.mUin + ""));
        this.c.setText(paramCallbackPushStruct.mNickName);
      }
      for (;;)
      {
        e();
        return;
        localObject = new StringBuffer(paramCallbackPushStruct.player);
        break;
        ((StringBuffer)localObject).append(this.g.getString(2131231079));
        break label224;
        this.c.setText("");
      }
    }
  }
  
  public boolean a(Context paramContext)
  {
    if ((this.g == null) || ((this.g != null) && (this.g.isFinishing()))) {
      return false;
    }
    this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.i = this.h.inflate(2130968640, null);
    this.i.setVisibility(4);
    this.j = this.i.findViewById(2131558822);
    this.k = this.i.findViewById(2131558808);
    this.l = this.i.findViewById(2131558803);
    this.m = this.i.findViewById(2131558805);
    this.n = x.a(this.g.getResources(), 2130837681);
    this.o = x.a(this.g.getResources(), 2130837680);
    if (this.n != null) {
      ((LinearLayout)this.i.findViewById(2131558809)).setBackgroundDrawable(new BitmapDrawable(this.n));
    }
    if (this.o != null)
    {
      ((LinearLayout)this.i.findViewById(2131558810)).setBackgroundDrawable(new BitmapDrawable(this.o));
      ((LinearLayout)this.i.findViewById(2131558811)).setBackgroundDrawable(new BitmapDrawable(this.o));
    }
    this.a = ((TextView)this.i.findViewById(2131558815));
    this.b = ((TextView)this.i.findViewById(2131558816));
    this.f = ((ImageView)this.i.findViewById(2131558824));
    this.d = ((Button)this.i.findViewById(2131558820));
    this.e = ((Button)this.i.findViewById(2131558821));
    this.c = ((TextView)this.i.findViewById(2131558813));
    this.d.setOnClickListener(new ap(this));
    this.e.setOnClickListener(new aq(this));
    addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
    return true;
  }
  
  public void b()
  {
    this.x.post(new au(this, this.j, this.k, this.l, this.m));
    cz.a(RqdApplication.l()).a();
  }
  
  public void c()
  {
    this.x.post(new aw(this, this));
  }
  
  public void d()
  {
    h.a("game login unregister interval timer");
    if (this.s != null)
    {
      this.s.cancel(this.t);
      this.g.unregisterReceiver(this.w);
      this.s = null;
    }
  }
  
  public void e()
  {
    this.u -= 1;
    if (this.u <= 0)
    {
      d();
      this.r.b();
    }
    long l1;
    do
    {
      return;
      this.d.setText(getResources().getString(2131231075) + "(" + this.u + ")");
      l1 = System.currentTimeMillis();
    } while (this.s == null);
    this.s.set(1, l1 + 1000L, this.t);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = this.j.getMeasuredHeight();
    this.q = this.k.getMeasuredHeight();
  }
  
  public void setListener(az paramaz)
  {
    this.r = paramaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GameLoginSndConfirmView
 * JD-Core Version:    0.7.0.1
 */