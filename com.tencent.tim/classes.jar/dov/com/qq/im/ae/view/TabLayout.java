package dov.com.qq.im.ae.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axiz;
import axjd;
import axje;
import axjf;
import java.util.ArrayList;
import java.util.List;

public class TabLayout
  extends RelativeLayout
{
  private View MH = new View(getContext());
  private List<TabView> MJ = new ArrayList();
  private a a;
  private boolean baw = axiz.aOK();
  private int currentIndex;
  private boolean dvb;
  @DrawableRes
  private int eFH;
  private LinearLayout ms = new LinearLayout(getContext());
  private ViewPager viewPager;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.ms, paramContext);
  }
  
  private void aeb(int paramInt)
  {
    if (this.a != null) {
      this.a.of(paramInt);
    }
    int i = 0;
    if (i < this.MJ.size())
    {
      TabView localTabView = (TabView)this.MJ.get(i);
      if (paramInt == 0)
      {
        if (paramInt == i) {}
        for (bool = true;; bool = false)
        {
          localTabView.cY(bool, false);
          i += 1;
          break;
        }
      }
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localTabView.cY(bool, this.dvb);
        break;
      }
    }
    if (this.currentIndex == 0) {
      i = this.eFH;
    }
    for (;;)
    {
      this.MH.setBackgroundResource(i);
      if (this.viewPager != null) {
        this.viewPager.setCurrentItem(paramInt);
      }
      return;
      if (this.dvb) {
        i = 2130837922;
      } else {
        i = this.eFH;
      }
    }
  }
  
  private void aec(int paramInt)
  {
    float f1 = this.MH.getX();
    float f2 = ((TabView)this.MJ.get(paramInt)).getX();
    float f3 = ((TabView)this.MJ.get(paramInt)).getWidth() / 2.0F;
    float f4 = this.MH.getWidth() / 2.0F;
    ObjectAnimator.ofFloat(this.MH, "x", new float[] { f1, f3 + f2 - f4 }).setDuration(250L).start();
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return 0;
    }
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void eLE()
  {
    this.eFH = 2130837923;
    this.MH.setBackgroundResource(this.eFH);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(dip2px(getContext(), 7.0F), dip2px(getContext(), 7.0F));
    localLayoutParams.addRule(12);
    addView(this.MH, localLayoutParams);
  }
  
  public void Nm(boolean paramBoolean)
  {
    this.dvb = paramBoolean;
    int i = 0;
    if (i < this.MJ.size())
    {
      TabView localTabView = (TabView)this.MJ.get(i);
      if (this.currentIndex == 0)
      {
        if (this.currentIndex == i) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localTabView.cY(paramBoolean, false);
          i += 1;
          break;
        }
      }
      if (this.currentIndex == i) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localTabView.cY(paramBoolean, this.dvb);
        break;
      }
    }
    if (this.currentIndex == 0) {
      i = this.eFH;
    }
    for (;;)
    {
      this.MH.setBackgroundResource(i);
      return;
      if (this.dvb) {
        i = 2130837922;
      } else {
        i = this.eFH;
      }
    }
  }
  
  public void b(ViewPager paramViewPager)
  {
    this.viewPager = paramViewPager;
    paramViewPager.setOnPageChangeListener(new axjf(this));
  }
  
  public void nU(int paramInt)
  {
    if (paramInt >= this.MJ.size()) {}
    while (paramInt == this.currentIndex) {
      return;
    }
    if ((this.a != null) && (!this.a.nX(paramInt)))
    {
      this.a.of(paramInt);
      return;
    }
    this.currentIndex = paramInt;
    aec(paramInt);
    aeb(paramInt);
  }
  
  public void setTabSelectedCallback(a parama)
  {
    this.a = parama;
  }
  
  public void setTabs(List<String> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 1)) {}
    do
    {
      return;
      int j = paramList.size();
      this.ms.setWeightSum(j);
      int i = 0;
      if (i < j)
      {
        TabView localTabView = new TabView(getContext(), this.baw);
        localTabView.getTextView().setText((CharSequence)paramList.get(i));
        if (paramInt == i) {}
        for (boolean bool = true;; bool = false)
        {
          localTabView.cY(bool, this.dvb);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams.weight = 1.0F;
          this.ms.addView(localTabView, localLayoutParams);
          this.MJ.add(localTabView);
          localTabView.setOnClickListener(new axje(this, i));
          i += 1;
          break;
        }
      }
      eLE();
      if (paramList.size() > 1) {
        ((TabView)this.MJ.get(0)).post(new TabLayout.2(this, paramInt));
      }
      this.currentIndex = paramInt;
    } while (this.currentIndex == 0);
    aeb(this.currentIndex);
  }
  
  static class TabView
    extends FrameLayout
  {
    private int eFJ;
    private int eFK;
    private int eFL;
    private int tabSelectedTextColor;
    private TextView textView;
    
    public TabView(Context paramContext, boolean paramBoolean)
    {
      super();
      if (!paramBoolean)
      {
        i = axjd.a.eFE;
        this.eFJ = i;
        if (paramBoolean) {
          break label85;
        }
        i = axjd.a.eFD;
        label32:
        this.tabSelectedTextColor = i;
        if (paramBoolean) {
          break label95;
        }
        i = axjd.b.eFE;
        label48:
        this.eFK = i;
        if (paramBoolean) {
          break label105;
        }
      }
      label85:
      label95:
      label105:
      for (int i = axjd.b.eFD;; i = axjd.d.eFD)
      {
        this.eFL = i;
        init(paramContext);
        return;
        i = axjd.c.eFE;
        break;
        i = axjd.c.eFD;
        break label32;
        i = axjd.d.eFE;
        break label48;
      }
    }
    
    private void init(Context paramContext)
    {
      this.textView = new TextView(paramContext);
      this.textView.setGravity(1);
      this.textView.setTextSize(1, 15.0F);
      addView(this.textView);
    }
    
    public void cY(boolean paramBoolean1, boolean paramBoolean2)
    {
      TextView localTextView;
      int i;
      if (!paramBoolean2)
      {
        localTextView = this.textView;
        if (paramBoolean1)
        {
          i = this.tabSelectedTextColor;
          localTextView.setTextColor(i);
          if (!paramBoolean1) {
            break label101;
          }
          this.textView.setTypeface(this.textView.getTypeface(), 1);
        }
      }
      for (;;)
      {
        if (!paramBoolean2) {
          break label113;
        }
        this.textView.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165397);
        return;
        i = this.eFJ;
        break;
        localTextView = this.textView;
        if (paramBoolean1) {}
        for (i = this.eFL;; i = this.eFK)
        {
          localTextView.setTextColor(i);
          break;
        }
        label101:
        this.textView.setTypeface(null, 0);
      }
      label113:
      this.textView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    
    public TextView getTextView()
    {
      return this.textView;
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean nX(int paramInt);
    
    public abstract void of(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.view.TabLayout
 * JD-Core Version:    0.7.0.1
 */