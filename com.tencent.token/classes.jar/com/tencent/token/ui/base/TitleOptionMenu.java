package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class TitleOptionMenu
  extends RelativeLayout
{
  public boolean a = false;
  private Context b;
  private View c;
  private View d;
  private int e = 2;
  private a f;
  private View.OnClickListener g = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (TitleOptionMenu.a(TitleOptionMenu.this) != null) {
        TitleOptionMenu.a(TitleOptionMenu.this).a(((Integer)paramAnonymousView.getTag()).intValue());
      }
      TitleOptionMenu.this.b();
    }
  };
  private View.OnTouchListener h = new View.OnTouchListener()
  {
    public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
    {
      if ((paramAnonymousMotionEvent.getAction() == 0) && (TitleOptionMenu.b(TitleOptionMenu.this).findFocus() == null))
      {
        TitleOptionMenu.this.b();
        return true;
      }
      return false;
    }
  };
  
  public TitleOptionMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
  }
  
  public TitleOptionMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
  }
  
  public final void a()
  {
    Object localObject = getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    setVisibility(0);
  }
  
  public final void b()
  {
    Object localObject = getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    setVisibility(8);
    AnimationUtils.loadAnimation(this.b, 2130771983).setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        TitleOptionMenu.this.setVisibility(4);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
  }
  
  public void setDisplayMode(int paramInt)
  {
    this.e = paramInt;
    this.a = true;
    Object localObject = (LayoutInflater)this.b.getSystemService("layout_inflater");
    paramInt = this.e;
    if (paramInt == 2)
    {
      this.c = ((LayoutInflater)localObject).inflate(2131296461, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = findViewById(2131166121);
      localObject = findViewById(2131165735);
      ((View)localObject).setTag(Integer.valueOf(0));
      ((View)localObject).setOnClickListener(this.g);
      localObject = findViewById(2131165736);
      ((View)localObject).setTag(Integer.valueOf(1));
      ((View)localObject).setOnClickListener(this.g);
    }
    else if (paramInt == 3)
    {
      this.c = ((LayoutInflater)localObject).inflate(2131296460, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = findViewById(2131166121);
      localObject = findViewById(2131165734);
      ((View)localObject).setTag(Integer.valueOf(0));
      ((View)localObject).setOnClickListener(this.g);
      localObject = findViewById(2131165736);
      ((View)localObject).setTag(Integer.valueOf(1));
      ((View)localObject).setOnClickListener(this.g);
    }
    else if (paramInt == 4)
    {
      this.c = ((LayoutInflater)localObject).inflate(2131296459, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = findViewById(2131166121);
      localObject = findViewById(2131165734);
      ((View)localObject).setTag(Integer.valueOf(0));
      ((View)localObject).setOnClickListener(this.g);
      localObject = findViewById(2131165736);
      ((View)localObject).setTag(Integer.valueOf(1));
      ((View)localObject).setOnClickListener(this.g);
    }
    else if (paramInt == 5)
    {
      this.c = ((LayoutInflater)localObject).inflate(2131296458, null);
      addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
      this.d = findViewById(2131166121);
      localObject = findViewById(2131165734);
      ((View)localObject).setTag(Integer.valueOf(0));
      ((View)localObject).setOnClickListener(this.g);
      localObject = findViewById(2131165736);
      ((View)localObject).setTag(Integer.valueOf(1));
      ((View)localObject).setOnClickListener(this.g);
    }
    this.c.setOnTouchListener(this.h);
    ((ViewGroup)((Activity)this.b).getWindow().getDecorView()).setOnTouchListener(this.h);
  }
  
  public void setOnItemClickedListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.TitleOptionMenu
 * JD-Core Version:    0.7.0.1
 */