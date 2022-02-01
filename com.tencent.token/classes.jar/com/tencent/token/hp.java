package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class hp
  extends hh<do>
  implements MenuItem
{
  public Method e;
  
  hp(Context paramContext, do paramdo)
  {
    super(paramContext, paramdo);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((do)this.d).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((do)this.d).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    ej localej = ((do)this.d).a();
    if ((localej instanceof a)) {
      return ((a)localej).c;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView = ((do)this.d).getActionView();
    if ((localView instanceof b)) {
      return (View)((b)localView).a;
    }
    return localView;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((do)this.d).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((do)this.d).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((do)this.d).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((do)this.d).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((do)this.d).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((do)this.d).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((do)this.d).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((do)this.d).getIntent();
  }
  
  public int getItemId()
  {
    return ((do)this.d).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((do)this.d).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((do)this.d).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((do)this.d).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((do)this.d).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((do)this.d).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((do)this.d).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((do)this.d).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((do)this.d).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((do)this.d).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((do)this.d).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((do)this.d).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((do)this.d).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((do)this.d).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((do)this.d).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    do localdo = (do)this.d;
    if (paramActionProvider != null) {
      paramActionProvider = a(paramActionProvider);
    } else {
      paramActionProvider = null;
    }
    localdo.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((do)this.d).setActionView(paramInt);
    View localView = ((do)this.d).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((do)this.d).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((do)this.d).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((do)this.d).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((do)this.d).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((do)this.d).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((do)this.d).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((do)this.d).a(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((do)this.d).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((do)this.d).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((do)this.d).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((do)this.d).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((do)this.d).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((do)this.d).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((do)this.d).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((do)this.d).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    do localdo = (do)this.d;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new c(paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localdo.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    do localdo = (do)this.d;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localdo.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((do)this.d).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((do)this.d).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((do)this.d).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((do)this.d).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((do)this.d).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((do)this.d).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((do)this.d).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((do)this.d).b(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((do)this.d).setVisible(paramBoolean);
  }
  
  class a
    extends ej
  {
    final ActionProvider c;
    
    public a(Context paramContext, ActionProvider paramActionProvider)
    {
      super();
      this.c = paramActionProvider;
    }
    
    public final View a()
    {
      return this.c.onCreateActionView();
    }
    
    public final void a(SubMenu paramSubMenu)
    {
      this.c.onPrepareSubMenu(hp.this.a(paramSubMenu));
    }
    
    public final boolean d()
    {
      return this.c.onPerformDefaultAction();
    }
    
    public final boolean e()
    {
      return this.c.hasSubMenu();
    }
  }
  
  static final class b
    extends FrameLayout
    implements gy
  {
    final CollapsibleActionView a;
    
    b(View paramView)
    {
      super();
      this.a = ((CollapsibleActionView)paramView);
      addView(paramView);
    }
    
    public final void a()
    {
      this.a.onActionViewExpanded();
    }
    
    public final void b()
    {
      this.a.onActionViewCollapsed();
    }
  }
  
  final class c
    extends hi<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionCollapse(hp.this.a(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionExpand(hp.this.a(paramMenuItem));
    }
  }
  
  final class d
    extends hi<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)this.d).onMenuItemClick(hp.this.a(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hp
 * JD-Core Version:    0.7.0.1
 */