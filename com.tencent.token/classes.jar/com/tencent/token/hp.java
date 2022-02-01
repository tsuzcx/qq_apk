package com.tencent.token;

import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class hp
  extends ho
{
  hp(Context paramContext, dn paramdn)
  {
    super(paramContext, paramdn);
  }
  
  final ho.a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  final class a
    extends ho.a
    implements ActionProvider.VisibilityListener
  {
    ei.b e;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super(paramContext, paramActionProvider);
    }
    
    public final View a(MenuItem paramMenuItem)
    {
      return this.c.onCreateActionView(paramMenuItem);
    }
    
    public final void a(ei.b paramb)
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
      ei.b localb = this.e;
      if (localb != null) {
        localb.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hp
 * JD-Core Version:    0.7.0.1
 */