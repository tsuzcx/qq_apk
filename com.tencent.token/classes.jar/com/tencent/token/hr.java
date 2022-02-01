package com.tencent.token;

import android.content.Context;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class hr
  extends ho
  implements id.a
{
  private Context a;
  private ActionBarContextView b;
  private ho.a e;
  private WeakReference<View> f;
  private boolean g;
  private boolean h;
  private id i;
  
  public hr(Context paramContext, ActionBarContextView paramActionBarContextView, ho.a parama, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramActionBarContextView;
    this.e = parama;
    paramContext = new id(paramActionBarContextView.getContext());
    paramContext.e = 1;
    this.i = paramContext;
    this.i.a(this);
    this.h = paramBoolean;
  }
  
  public final MenuInflater a()
  {
    return new ht(this.b.getContext());
  }
  
  public final void a(int paramInt)
  {
    b(this.a.getString(paramInt));
  }
  
  public final void a(View paramView)
  {
    this.b.setCustomView(paramView);
    if (paramView != null) {
      paramView = new WeakReference(paramView);
    } else {
      paramView = null;
    }
    this.f = paramView;
  }
  
  public final void a(id paramid)
  {
    d();
    this.b.a();
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.b.setSubtitle(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.b.setTitleOptional(paramBoolean);
  }
  
  public final boolean a(id paramid, MenuItem paramMenuItem)
  {
    return this.e.a(this, paramMenuItem);
  }
  
  public final Menu b()
  {
    return this.i;
  }
  
  public final void b(int paramInt)
  {
    a(this.a.getString(paramInt));
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.b.setTitle(paramCharSequence);
  }
  
  public final void c()
  {
    if (this.g) {
      return;
    }
    this.g = true;
    this.b.sendAccessibilityEvent(32);
    this.e.a(this);
  }
  
  public final void d()
  {
    this.e.b(this, this.i);
  }
  
  public final CharSequence f()
  {
    return this.b.getTitle();
  }
  
  public final CharSequence g()
  {
    return this.b.getSubtitle();
  }
  
  public final boolean h()
  {
    return this.b.g;
  }
  
  public final View i()
  {
    WeakReference localWeakReference = this.f;
    if (localWeakReference != null) {
      return (View)localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hr
 * JD-Core Version:    0.7.0.1
 */