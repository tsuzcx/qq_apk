package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.widget.ActionMenuView.a;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.tencent.token.go.j;
import com.tencent.token.hl;
import com.tencent.token.hl.b;
import com.tencent.token.hn;
import com.tencent.token.ht.a;
import com.tencent.token.hw;
import com.tencent.token.it;
import com.tencent.token.jg;

public class ActionMenuItemView
  extends AppCompatTextView
  implements ActionMenuView.a, View.OnClickListener, ht.a
{
  hn b;
  hl.b c;
  b d;
  private CharSequence e;
  private Drawable f;
  private it g;
  private boolean h;
  private boolean i;
  private int j;
  private int k;
  private int l;
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.h = e();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, go.j.ActionMenuItemView, paramInt, 0);
    this.j = paramContext.getDimensionPixelSize(go.j.ActionMenuItemView_android_minWidth, 0);
    paramContext.recycle();
    this.l = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.k = -1;
    setSaveEnabled(false);
  }
  
  private boolean e()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int m = localConfiguration.screenWidthDp;
    int n = localConfiguration.screenHeightDp;
    return (m >= 480) || ((m >= 640) && (n >= 480)) || (localConfiguration.orientation == 2);
  }
  
  private void f()
  {
    boolean bool = TextUtils.isEmpty(this.e);
    int n = 1;
    int m = n;
    if (this.f != null)
    {
      if (this.b.i())
      {
        m = n;
        if (this.h) {
          break label52;
        }
        if (this.i)
        {
          m = n;
          break label52;
        }
      }
      m = 0;
    }
    label52:
    m = (bool ^ true) & m;
    Object localObject2 = null;
    if (m != 0) {
      localObject1 = this.e;
    } else {
      localObject1 = null;
    }
    setText((CharSequence)localObject1);
    Object localObject1 = this.b.getContentDescription();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (m != 0) {
        localObject1 = null;
      } else {
        localObject1 = this.b.getTitle();
      }
      setContentDescription((CharSequence)localObject1);
    }
    else
    {
      setContentDescription((CharSequence)localObject1);
    }
    localObject1 = this.b.getTooltipText();
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (m != 0) {
        localObject1 = localObject2;
      } else {
        localObject1 = this.b.getTitle();
      }
      jg.a(this, (CharSequence)localObject1);
      return;
    }
    jg.a(this, (CharSequence)localObject1);
  }
  
  public final void a(hn paramhn)
  {
    this.b = paramhn;
    setIcon(paramhn.getIcon());
    setTitle(paramhn.a(this));
    setId(paramhn.getItemId());
    int m;
    if (paramhn.isVisible()) {
      m = 0;
    } else {
      m = 8;
    }
    setVisibility(m);
    setEnabled(paramhn.isEnabled());
    if ((paramhn.hasSubMenu()) && (this.g == null)) {
      this.g = new a();
    }
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean b()
  {
    return !TextUtils.isEmpty(getText());
  }
  
  public final boolean c()
  {
    return (b()) && (this.b.getIcon() == null);
  }
  
  public final boolean d()
  {
    return b();
  }
  
  public hn getItemData()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.c;
    if (paramView != null) {
      paramView.a(this.b);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.h = e();
    f();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = b();
    if (bool)
    {
      m = this.k;
      if (m >= 0) {
        super.setPadding(m, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = getMeasuredWidth();
    if (m == -2147483648) {
      paramInt1 = Math.min(paramInt1, this.j);
    } else {
      paramInt1 = this.j;
    }
    if ((m != 1073741824) && (this.j > 0) && (n < paramInt1)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
    }
    if ((!bool) && (this.f != null)) {
      super.setPadding((getMeasuredWidth() - this.f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b.hasSubMenu())
    {
      it localit = this.g;
      if ((localit != null) && (localit.onTouch(this, paramMotionEvent))) {
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.i != paramBoolean)
    {
      this.i = paramBoolean;
      hn localhn = this.b;
      if (localhn != null) {
        localhn.b.g();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    if (paramDrawable != null)
    {
      int i2 = paramDrawable.getIntrinsicWidth();
      int i3 = paramDrawable.getIntrinsicHeight();
      int i1 = this.l;
      int n = i2;
      int m = i3;
      float f1;
      if (i2 > i1)
      {
        f1 = i1 / i2;
        m = (int)(i3 * f1);
        n = i1;
      }
      i3 = this.l;
      i2 = n;
      i1 = m;
      if (m > i3)
      {
        f1 = i3 / m;
        i2 = (int)(n * f1);
        i1 = i3;
      }
      paramDrawable.setBounds(0, 0, i2, i1);
    }
    setCompoundDrawables(paramDrawable, null, null, null);
    f();
  }
  
  public void setItemInvoker(hl.b paramb)
  {
    this.c = paramb;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(b paramb)
  {
    this.d = paramb;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    f();
  }
  
  final class a
    extends it
  {
    public a()
    {
      super();
    }
    
    public final hw a()
    {
      if (ActionMenuItemView.this.d != null) {
        return ActionMenuItemView.this.d.a();
      }
      return null;
    }
    
    public final boolean b()
    {
      if ((ActionMenuItemView.this.c != null) && (ActionMenuItemView.this.c.a(ActionMenuItemView.this.b)))
      {
        hw localhw = a();
        return (localhw != null) && (localhw.d());
      }
      return false;
    }
  }
  
  public static abstract class b
  {
    public abstract hw a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.view.menu.ActionMenuItemView
 * JD-Core Version:    0.7.0.1
 */