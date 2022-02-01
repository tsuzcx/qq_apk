package com.tencent.token;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class ht
  extends hs
{
  ht(Context paramContext, dr paramdr)
  {
    super(paramContext, paramdr);
  }
  
  final hs.a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  final class a
    extends hs.a
    implements ActionProvider.VisibilityListener
  {
    em.b e;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final View a(MenuItem paramMenuItem)
    {
      return this.c.onCreateActionView(paramMenuItem);
    }
    
    public final void a(em.b paramb)
    {
      this.e = paramb;
      this.c.setVisibilityListener(this);
    }
    
    public final boolean b()
    {
      return this.c.overridesItemVisibility();
    }
    
    public final boolean c()
    {
      return this.c.isVisible();
    }
    
    public final void onActionProviderVisibilityChanged(boolean paramBoolean)
    {
      em.b localb = this.e;
      if (localb != null) {
        localb.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ht
 * JD-Core Version:    0.7.0.1
 */