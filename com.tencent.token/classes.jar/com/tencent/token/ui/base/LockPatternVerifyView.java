package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.aaz;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.so;
import com.tencent.token.sw;
import com.tencent.token.sx;
import java.util.List;

public class LockPatternVerifyView
  extends RelativeLayout
  implements LockPatternView.b
{
  public LockPatternView a;
  public Bitmap b;
  public Bitmap c;
  public Bitmap d;
  public Bitmap e;
  public Bitmap f;
  protected Runnable g = new Runnable()
  {
    public final void run()
    {
      LockPatternVerifyView.b(LockPatternVerifyView.this).a();
      LockPatternVerifyView.b(LockPatternVerifyView.this).c = true;
    }
  };
  protected Runnable h = new Runnable()
  {
    public final void run()
    {
      if (LockPatternVerifyView.c(LockPatternVerifyView.this) != null) {
        LockPatternVerifyView.d(LockPatternVerifyView.this).setImageBitmap(LockPatternVerifyView.c(LockPatternVerifyView.this));
      }
    }
  };
  private View i;
  private View j;
  private View k;
  private TextView l;
  private TextView m;
  private LayoutInflater n;
  private View o;
  private Context p;
  private int q;
  private int r;
  private int s;
  private b t;
  private ImageView u;
  private int v = 0;
  private TranslateAnimation w;
  private TranslateAnimation x;
  private RotateAnimation y;
  private Handler z = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage) {}
  };
  
  public LockPatternVerifyView(Context paramContext)
  {
    super(paramContext);
    this.p = paramContext;
    a(paramContext);
  }
  
  public LockPatternVerifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.p = paramContext;
    a(paramContext);
  }
  
  public LockPatternVerifyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.p = paramContext;
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    this.l.setTextColor(getResources().getColor(2130968778));
    this.l.setText(paramInt);
  }
  
  private void a(Context paramContext)
  {
    removeAllViews();
    b(paramContext);
    e();
  }
  
  private void b(Context paramContext)
  {
    this.n = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.o = this.n.inflate(2131296465, null);
    this.o.setVisibility(0);
    this.i = this.o.findViewById(2131166315);
    this.j = this.o.findViewById(2131166302);
    this.k = this.o.findViewById(2131166300);
    this.l = ((TextView)this.o.findViewById(2131166307));
    this.m = ((TextView)this.o.findViewById(2131166299));
    this.a = ((LockPatternView)this.o.findViewById(2131166306));
    this.a.setOnPatternListener(this);
    this.k.setVisibility(4);
    this.b = aaz.a(paramContext.getResources(), 2131100140);
    this.c = aaz.a(paramContext.getResources(), 2131100142);
    this.d = aaz.a(paramContext.getResources(), 2131100143);
    this.e = aaz.a(paramContext.getResources(), 2131100133);
    this.f = aaz.a(paramContext.getResources(), 2131100134);
    if (this.e != null) {
      ((LinearLayout)this.o.findViewById(2131166296)).setBackgroundDrawable(new BitmapDrawable(this.e));
    }
    if (this.f != null)
    {
      ((LinearLayout)this.o.findViewById(2131166297)).setBackgroundDrawable(new BitmapDrawable(this.f));
      ((LinearLayout)this.o.findViewById(2131166298)).setBackgroundDrawable(new BitmapDrawable(this.f));
    }
    if (this.b != null)
    {
      this.u = ((ImageView)this.o.findViewById(2131166301));
      this.u.setImageBitmap(this.b);
    }
    if (!RqdApplication.j()) {
      a(2131493248);
    }
    this.o.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
    this.m.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        so.a().a(System.currentTimeMillis(), 26);
        if (LockPatternVerifyView.a(LockPatternVerifyView.this) != null) {
          LockPatternVerifyView.a(LockPatternVerifyView.this).b();
        }
      }
    });
  }
  
  private void e()
  {
    sw.a();
    this.s = sw.f();
  }
  
  public final void a()
  {
    this.a.removeCallbacks(this.g);
  }
  
  public final void a(List<LockPatternView.a> paramList)
  {
    paramList = this.a.getPatternString();
    if ((this.s < 5) && (sw.a().a(paramList)))
    {
      RqdApplication.l();
      RqdApplication.g();
      a(2131493255);
      this.a.c = false;
      d();
      sw.a();
      sw.a(0);
      return;
    }
    paramList = this.d;
    if (paramList != null) {
      this.u.setImageBitmap(paramList);
    }
    this.u.postDelayed(this.h, 500L);
    int i1;
    if (this.s >= 4) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      sw.a();
      sw.a(this.s + 1);
      this.a.a();
      this.t.a(false);
      return;
    }
    this.s += 1;
    this.a.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    paramList = new StringBuilder();
    paramList.append(this.p.getString(2131493257));
    paramList.append(5 - this.s);
    paramList.append("次！");
    paramList = paramList.toString();
    this.l.setTextColor(this.p.getResources().getColor(2130968779));
    this.l.setText(paramList);
    this.a.c = false;
    sw.a();
    sw.a(this.s);
    this.a.postDelayed(this.g, 500L);
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d()
  {
    Object localObject = this.c;
    if (localObject != null) {
      this.u.setImageBitmap((Bitmap)localObject);
    }
    int i1 = this.v;
    if (i1 == 0)
    {
      this.k.setVisibility(0);
      this.z.post(new a(this.i, this.j, this.k));
      return;
    }
    if (i1 == 1)
    {
      localObject = AnimationUtils.loadAnimation(this.p, 2130771990);
      ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          LockPatternVerifyView.this.setVisibility(8);
          if (LockPatternVerifyView.a(LockPatternVerifyView.this) != null) {
            LockPatternVerifyView.a(LockPatternVerifyView.this).a();
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.o.startAnimation((Animation)localObject);
      return;
    }
    if (i1 == 2) {
      this.t.a();
    }
  }
  
  protected int getScreenHeight()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  protected int getScreenWidth()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.q = this.i.getMeasuredHeight();
    this.r = this.j.getMeasuredHeight();
  }
  
  public void setAnimType(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setPatternViewInStealthMode(boolean paramBoolean)
  {
    LockPatternView localLockPatternView = this.a;
    if (localLockPatternView != null) {
      localLockPatternView.setInStealthMode(paramBoolean);
    }
  }
  
  public void setVerifyListener(b paramb)
  {
    this.t = paramb;
    if (this.s >= 5) {
      this.t.a(true);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  final class a
    implements Runnable
  {
    private View b;
    private View c;
    private View d;
    
    public a(View paramView1, View paramView2, View paramView3)
    {
      this.b = paramView1;
      this.c = paramView2;
      this.d = paramView3;
      LockPatternVerifyView.a(LockPatternVerifyView.this, new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F));
      LockPatternVerifyView.e(LockPatternVerifyView.this).setDuration(250L);
      LockPatternVerifyView.a(LockPatternVerifyView.this, new TranslateAnimation(0.0F, 0.0F, 0.0F, -LockPatternVerifyView.f(LockPatternVerifyView.this)));
      LockPatternVerifyView.g(LockPatternVerifyView.this).setDuration(500L);
      LockPatternVerifyView.b(LockPatternVerifyView.this, new TranslateAnimation(0.0F, 0.0F, 0.0F, LockPatternVerifyView.h(LockPatternVerifyView.this)));
      LockPatternVerifyView.i(LockPatternVerifyView.this).setDuration(500L);
      LockPatternVerifyView.e(LockPatternVerifyView.this).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          LockPatternVerifyView.a.a(LockPatternVerifyView.a.this).setVisibility(4);
          LockPatternVerifyView.a.b(LockPatternVerifyView.a.this).startAnimation(LockPatternVerifyView.g(LockPatternVerifyView.this));
          LockPatternVerifyView.a.c(LockPatternVerifyView.a.this).startAnimation(LockPatternVerifyView.i(LockPatternVerifyView.this));
          sx.a(RqdApplication.n()).a();
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      LockPatternVerifyView.i(LockPatternVerifyView.this).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          LockPatternVerifyView.this.setVisibility(8);
          if (LockPatternVerifyView.a(LockPatternVerifyView.this) != null) {
            LockPatternVerifyView.a(LockPatternVerifyView.this).a();
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      this.d.startAnimation(LockPatternVerifyView.e(LockPatternVerifyView.this));
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LockPatternVerifyView
 * JD-Core Version:    0.7.0.1
 */