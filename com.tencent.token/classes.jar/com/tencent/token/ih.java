package com.tencent.token;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class ih
  extends ig
{
  ih(Context paramContext, ef paramef)
  {
    super(paramContext, paramef);
  }
  
  final ig.a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  final class a
    extends ig.a
    implements ActionProvider.VisibilityListener
  {
    fa.b e;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final View a(MenuItem paramMenuItem)
    {
      return this.c.onCreateActionView(paramMenuItem);
    }
    
    public final void a(fa.b paramb)
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
      fa.b localb = this.e;
      if (localb != null) {
        localb.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ih
 * JD-Core Version:    0.7.0.1
 */