package com.tencent.token;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class hq
  extends hp
{
  hq(Context paramContext, do paramdo)
  {
    super(paramContext, paramdo);
  }
  
  final hp.a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  final class a
    extends hp.a
    implements ActionProvider.VisibilityListener
  {
    ej.b e;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final View a(MenuItem paramMenuItem)
    {
      return this.c.onCreateActionView(paramMenuItem);
    }
    
    public final void a(ej.b paramb)
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
      ej.b localb = this.e;
      if (localb != null) {
        localb.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hq
 * JD-Core Version:    0.7.0.1
 */