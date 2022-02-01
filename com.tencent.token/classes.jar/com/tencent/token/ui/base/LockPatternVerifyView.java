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
import com.tencent.token.bu;
import com.tencent.token.cd;
import com.tencent.token.ce;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.m;
import java.util.List;

public class LockPatternVerifyView
  extends RelativeLayout
  implements LockPatternView.b
{
  protected Runnable a = new Runnable()
  {
    public void run()
    {
      LockPatternVerifyView.b(LockPatternVerifyView.this).a();
      LockPatternVerifyView.b(LockPatternVerifyView.this).c();
    }
  };
  protected Runnable b = new Runnable()
  {
    public void run()
    {
      if (LockPatternVerifyView.c(LockPatternVerifyView.this) != null) {
        LockPatternVerifyView.d(LockPatternVerifyView.this).setImageBitmap(LockPatternVerifyView.c(LockPatternVerifyView.this));
      }
    }
  };
  private View c;
  private View d;
  private View e;
  private TextView f;
  private TextView g;
  private LayoutInflater h;
  private View i;
  private Context j;
  private LockPatternView k;
  private int l;
  private int m;
  private int n;
  private b o;
  private Bitmap p;
  private Bitmap q;
  private Bitmap r;
  private Bitmap s;
  private Bitmap t;
  private ImageView u;
  private int v = 0;
  private TranslateAnimation w;
  private TranslateAnimation x;
  private RotateAnimation y;
  private Handler z = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage) {}
  };
  
  public LockPatternVerifyView(Context paramContext)
  {
    super(paramContext);
    this.j = paramContext;
    a(paramContext);
  }
  
  public LockPatternVerifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramContext;
    a(paramContext);
  }
  
  public LockPatternVerifyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramContext;
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.setTextColor(this.j.getResources().getColor(2130968778));
    } else {
      this.f.setTextColor(getResources().getColor(2130968777));
    }
    this.f.setText(paramInt);
  }
  
  private void a(String paramString)
  {
    this.f.setTextColor(this.j.getResources().getColor(2130968778));
    this.f.setText(paramString);
  }
  
  private void b(Context paramContext)
  {
    this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.i = this.h.inflate(2131296451, null);
    this.i.setVisibility(0);
    this.c = this.i.findViewById(2131166258);
    this.d = this.i.findViewById(2131166245);
    this.e = this.i.findViewById(2131166243);
    this.f = ((TextView)this.i.findViewById(2131166250));
    this.g = ((TextView)this.i.findViewById(2131166242));
    this.k = ((LockPatternView)this.i.findViewById(2131166249));
    this.k.setOnPatternListener(this);
    this.e.setVisibility(4);
    this.p = m.a(paramContext.getResources(), 2131100131);
    this.q = m.a(paramContext.getResources(), 2131100133);
    this.r = m.a(paramContext.getResources(), 2131100134);
    this.s = m.a(paramContext.getResources(), 2131100124);
    this.t = m.a(paramContext.getResources(), 2131100125);
    if (this.s != null) {
      ((LinearLayout)this.i.findViewById(2131166239)).setBackgroundDrawable(new BitmapDrawable(this.s));
    }
    if (this.t != null)
    {
      ((LinearLayout)this.i.findViewById(2131166240)).setBackgroundDrawable(new BitmapDrawable(this.t));
      ((LinearLayout)this.i.findViewById(2131166241)).setBackgroundDrawable(new BitmapDrawable(this.t));
    }
    if (this.p != null)
    {
      this.u = ((ImageView)this.i.findViewById(2131166244));
      this.u.setImageBitmap(this.p);
    }
    if (!RqdApplication.g()) {
      a(2131493245, false);
    }
    this.i.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        bu.a().a(System.currentTimeMillis(), 26);
        if (LockPatternVerifyView.a(LockPatternVerifyView.this) != null) {
          LockPatternVerifyView.a(LockPatternVerifyView.this).b();
        }
      }
    });
  }
  
  private void c(Context paramContext)
  {
    this.n = cd.a().b(paramContext);
  }
  
  public void a()
  {
    this.k.removeCallbacks(this.a);
  }
  
  public void a(Context paramContext)
  {
    removeAllViews();
    b(paramContext);
    c(paramContext);
  }
  
  public void a(List<LockPatternView.a> paramList) {}
  
  public void b() {}
  
  public void b(List<LockPatternView.a> paramList)
  {
    paramList = this.k.getPatternString();
    if (cd.a().a(paramList))
    {
      RqdApplication.i();
      RqdApplication.d();
      a(2131493252, false);
      this.k.b();
      d();
      cd.a().a(this.j, 0);
      return;
    }
    paramList = this.r;
    if (paramList != null) {
      this.u.setImageBitmap(paramList);
    }
    this.u.postDelayed(this.b, 500L);
    int i1 = this.n;
    if (i1 >= 4)
    {
      cd.a().a(this.j, this.n + 1);
      this.k.a();
      this.o.a(false);
      return;
    }
    this.n = (i1 + 1);
    this.k.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    paramList = new StringBuilder();
    paramList.append(this.j.getString(2131493254));
    paramList.append(5 - this.n);
    paramList.append("次！");
    a(paramList.toString());
    this.k.b();
    cd.a().a(this.j, this.n);
    this.k.postDelayed(this.a, 500L);
  }
  
  public void c()
  {
    this.k.d();
    Bitmap localBitmap = this.s;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    localBitmap = this.t;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    localBitmap = this.p;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    localBitmap = this.q;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    localBitmap = this.r;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public void d()
  {
    Object localObject = this.q;
    if (localObject != null) {
      this.u.setImageBitmap((Bitmap)localObject);
    }
    int i1 = this.v;
    if (i1 == 0)
    {
      this.e.setVisibility(0);
      this.z.post(new a(this.c, this.d, this.e));
      return;
    }
    if (i1 == 1)
    {
      localObject = AnimationUtils.loadAnimation(this.j, 2130771990);
      ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          LockPatternVerifyView.this.setVisibility(8);
          if (LockPatternVerifyView.a(LockPatternVerifyView.this) != null) {
            LockPatternVerifyView.a(LockPatternVerifyView.this).a();
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.i.startAnimation((Animation)localObject);
      return;
    }
    if (i1 == 2) {
      this.o.a();
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
    this.l = this.c.getMeasuredHeight();
    this.m = this.d.getMeasuredHeight();
  }
  
  public void setAnimType(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setPatternViewInStealthMode(boolean paramBoolean)
  {
    LockPatternView localLockPatternView = this.k;
    if (localLockPatternView != null) {
      localLockPatternView.setInStealthMode(paramBoolean);
    }
  }
  
  public void setVerifyListener(b paramb)
  {
    this.o = paramb;
    if (this.n >= 5) {
      this.o.a(true);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
  
  private class a
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
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          LockPatternVerifyView.a.a(LockPatternVerifyView.a.this).setVisibility(4);
          LockPatternVerifyView.a.b(LockPatternVerifyView.a.this).startAnimation(LockPatternVerifyView.g(LockPatternVerifyView.this));
          LockPatternVerifyView.a.c(LockPatternVerifyView.a.this).startAnimation(LockPatternVerifyView.i(LockPatternVerifyView.this));
          ce.a(RqdApplication.l()).a();
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      LockPatternVerifyView.i(LockPatternVerifyView.this).setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          LockPatternVerifyView.this.setVisibility(8);
          if (LockPatternVerifyView.a(LockPatternVerifyView.this) != null) {
            LockPatternVerifyView.a(LockPatternVerifyView.this).a();
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
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