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

public class hs
  extends hk<dr>
  implements MenuItem
{
  public Method e;
  
  hs(Context paramContext, dr paramdr)
  {
    super(paramContext, paramdr);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((dr)this.d).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((dr)this.d).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    em localem = ((dr)this.d).a();
    if ((localem instanceof a)) {
      return ((a)localem).c;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView = ((dr)this.d).getActionView();
    if ((localView instanceof b)) {
      return (View)((b)localView).a;
    }
    return localView;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((dr)this.d).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((dr)this.d).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((dr)this.d).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((dr)this.d).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((dr)this.d).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((dr)this.d).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((dr)this.d).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((dr)this.d).getIntent();
  }
  
  public int getItemId()
  {
    return ((dr)this.d).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((dr)this.d).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((dr)this.d).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((dr)this.d).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((dr)this.d).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((dr)this.d).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((dr)this.d).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((dr)this.d).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((dr)this.d).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((dr)this.d).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((dr)this.d).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((dr)this.d).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((dr)this.d).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((dr)this.d).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((dr)this.d).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    dr localdr = (dr)this.d;
    if (paramActionProvider != null) {
      paramActionProvider = a(paramActionProvider);
    } else {
      paramActionProvider = null;
    }
    localdr.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((dr)this.d).setActionView(paramInt);
    View localView = ((dr)this.d).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((dr)this.d).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((dr)this.d).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((dr)this.d).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((dr)this.d).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((dr)this.d).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((dr)this.d).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((dr)this.d).a(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((dr)this.d).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((dr)this.d).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((dr)this.d).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((dr)this.d).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((dr)this.d).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((dr)this.d).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((dr)this.d).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((dr)this.d).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    dr localdr = (dr)this.d;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new c(paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localdr.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    dr localdr = (dr)this.d;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localdr.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((dr)this.d).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((dr)this.d).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((dr)this.d).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((dr)this.d).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((dr)this.d).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((dr)this.d).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((dr)this.d).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((dr)this.d).b(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((dr)this.d).setVisible(paramBoolean);
  }
  
  class a
    extends em
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
      this.c.onPrepareSubMenu(hs.this.a(paramSubMenu));
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
    implements hb
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
    extends hl<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionCollapse(hs.this.a(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionExpand(hs.this.a(paramMenuItem));
    }
  }
  
  final class d
    extends hl<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)this.d).onMenuItemClick(hs.this.a(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hs
 * JD-Core Version:    0.7.0.1
 */