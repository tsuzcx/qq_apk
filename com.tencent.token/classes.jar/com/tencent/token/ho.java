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

public class ho
  extends hg<dn>
  implements MenuItem
{
  public Method e;
  
  ho(Context paramContext, dn paramdn)
  {
    super(paramContext, paramdn);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((dn)this.d).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((dn)this.d).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    ei localei = ((dn)this.d).a();
    if ((localei instanceof a)) {
      return ((a)localei).c;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView = ((dn)this.d).getActionView();
    if ((localView instanceof b)) {
      return (View)((b)localView).a;
    }
    return localView;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((dn)this.d).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((dn)this.d).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((dn)this.d).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((dn)this.d).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((dn)this.d).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((dn)this.d).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((dn)this.d).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((dn)this.d).getIntent();
  }
  
  public int getItemId()
  {
    return ((dn)this.d).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((dn)this.d).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((dn)this.d).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((dn)this.d).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((dn)this.d).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((dn)this.d).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((dn)this.d).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((dn)this.d).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((dn)this.d).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((dn)this.d).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((dn)this.d).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((dn)this.d).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((dn)this.d).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((dn)this.d).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((dn)this.d).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    dn localdn = (dn)this.d;
    if (paramActionProvider != null) {
      paramActionProvider = a(paramActionProvider);
    } else {
      paramActionProvider = null;
    }
    localdn.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((dn)this.d).setActionView(paramInt);
    View localView = ((dn)this.d).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((dn)this.d).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((dn)this.d).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((dn)this.d).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((dn)this.d).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((dn)this.d).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((dn)this.d).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((dn)this.d).a(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((dn)this.d).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((dn)this.d).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((dn)this.d).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((dn)this.d).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((dn)this.d).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((dn)this.d).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((dn)this.d).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((dn)this.d).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    dn localdn = (dn)this.d;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new c(paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localdn.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    dn localdn = (dn)this.d;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localdn.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((dn)this.d).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((dn)this.d).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((dn)this.d).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((dn)this.d).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((dn)this.d).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((dn)this.d).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((dn)this.d).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((dn)this.d).b(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((dn)this.d).setVisible(paramBoolean);
  }
  
  class a
    extends ei
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
      this.c.onPrepareSubMenu(ho.this.a(paramSubMenu));
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
    implements gx
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
    extends hh<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionCollapse(ho.this.a(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionExpand(ho.this.a(paramMenuItem));
    }
  }
  
  final class d
    extends hh<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)this.d).onMenuItemClick(ho.this.a(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ho
 * JD-Core Version:    0.7.0.1
 */