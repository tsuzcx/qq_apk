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

public class ig
  extends hy<ef>
  implements MenuItem
{
  public Method e;
  
  ig(Context paramContext, ef paramef)
  {
    super(paramContext, paramef);
  }
  
  a a(ActionProvider paramActionProvider)
  {
    return new a(this.a, paramActionProvider);
  }
  
  public boolean collapseActionView()
  {
    return ((ef)this.d).collapseActionView();
  }
  
  public boolean expandActionView()
  {
    return ((ef)this.d).expandActionView();
  }
  
  public ActionProvider getActionProvider()
  {
    fa localfa = ((ef)this.d).a();
    if ((localfa instanceof a)) {
      return ((a)localfa).c;
    }
    return null;
  }
  
  public View getActionView()
  {
    View localView = ((ef)this.d).getActionView();
    if ((localView instanceof b)) {
      return (View)((b)localView).a;
    }
    return localView;
  }
  
  public int getAlphabeticModifiers()
  {
    return ((ef)this.d).getAlphabeticModifiers();
  }
  
  public char getAlphabeticShortcut()
  {
    return ((ef)this.d).getAlphabeticShortcut();
  }
  
  public CharSequence getContentDescription()
  {
    return ((ef)this.d).getContentDescription();
  }
  
  public int getGroupId()
  {
    return ((ef)this.d).getGroupId();
  }
  
  public Drawable getIcon()
  {
    return ((ef)this.d).getIcon();
  }
  
  public ColorStateList getIconTintList()
  {
    return ((ef)this.d).getIconTintList();
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return ((ef)this.d).getIconTintMode();
  }
  
  public Intent getIntent()
  {
    return ((ef)this.d).getIntent();
  }
  
  public int getItemId()
  {
    return ((ef)this.d).getItemId();
  }
  
  public ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return ((ef)this.d).getMenuInfo();
  }
  
  public int getNumericModifiers()
  {
    return ((ef)this.d).getNumericModifiers();
  }
  
  public char getNumericShortcut()
  {
    return ((ef)this.d).getNumericShortcut();
  }
  
  public int getOrder()
  {
    return ((ef)this.d).getOrder();
  }
  
  public SubMenu getSubMenu()
  {
    return a(((ef)this.d).getSubMenu());
  }
  
  public CharSequence getTitle()
  {
    return ((ef)this.d).getTitle();
  }
  
  public CharSequence getTitleCondensed()
  {
    return ((ef)this.d).getTitleCondensed();
  }
  
  public CharSequence getTooltipText()
  {
    return ((ef)this.d).getTooltipText();
  }
  
  public boolean hasSubMenu()
  {
    return ((ef)this.d).hasSubMenu();
  }
  
  public boolean isActionViewExpanded()
  {
    return ((ef)this.d).isActionViewExpanded();
  }
  
  public boolean isCheckable()
  {
    return ((ef)this.d).isCheckable();
  }
  
  public boolean isChecked()
  {
    return ((ef)this.d).isChecked();
  }
  
  public boolean isEnabled()
  {
    return ((ef)this.d).isEnabled();
  }
  
  public boolean isVisible()
  {
    return ((ef)this.d).isVisible();
  }
  
  public MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    ef localef = (ef)this.d;
    if (paramActionProvider != null) {
      paramActionProvider = a(paramActionProvider);
    } else {
      paramActionProvider = null;
    }
    localef.a(paramActionProvider);
    return this;
  }
  
  public MenuItem setActionView(int paramInt)
  {
    ((ef)this.d).setActionView(paramInt);
    View localView = ((ef)this.d).getActionView();
    if ((localView instanceof CollapsibleActionView)) {
      ((ef)this.d).setActionView(new b(localView));
    }
    return this;
  }
  
  public MenuItem setActionView(View paramView)
  {
    Object localObject = paramView;
    if ((paramView instanceof CollapsibleActionView)) {
      localObject = new b(paramView);
    }
    ((ef)this.d).setActionView((View)localObject);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar)
  {
    ((ef)this.d).setAlphabeticShortcut(paramChar);
    return this;
  }
  
  public MenuItem setAlphabeticShortcut(char paramChar, int paramInt)
  {
    ((ef)this.d).setAlphabeticShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setCheckable(boolean paramBoolean)
  {
    ((ef)this.d).setCheckable(paramBoolean);
    return this;
  }
  
  public MenuItem setChecked(boolean paramBoolean)
  {
    ((ef)this.d).setChecked(paramBoolean);
    return this;
  }
  
  public MenuItem setContentDescription(CharSequence paramCharSequence)
  {
    ((ef)this.d).a(paramCharSequence);
    return this;
  }
  
  public MenuItem setEnabled(boolean paramBoolean)
  {
    ((ef)this.d).setEnabled(paramBoolean);
    return this;
  }
  
  public MenuItem setIcon(int paramInt)
  {
    ((ef)this.d).setIcon(paramInt);
    return this;
  }
  
  public MenuItem setIcon(Drawable paramDrawable)
  {
    ((ef)this.d).setIcon(paramDrawable);
    return this;
  }
  
  public MenuItem setIconTintList(ColorStateList paramColorStateList)
  {
    ((ef)this.d).setIconTintList(paramColorStateList);
    return this;
  }
  
  public MenuItem setIconTintMode(PorterDuff.Mode paramMode)
  {
    ((ef)this.d).setIconTintMode(paramMode);
    return this;
  }
  
  public MenuItem setIntent(Intent paramIntent)
  {
    ((ef)this.d).setIntent(paramIntent);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar)
  {
    ((ef)this.d).setNumericShortcut(paramChar);
    return this;
  }
  
  public MenuItem setNumericShortcut(char paramChar, int paramInt)
  {
    ((ef)this.d).setNumericShortcut(paramChar, paramInt);
    return this;
  }
  
  public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    ef localef = (ef)this.d;
    if (paramOnActionExpandListener != null) {
      paramOnActionExpandListener = new c(paramOnActionExpandListener);
    } else {
      paramOnActionExpandListener = null;
    }
    localef.setOnActionExpandListener(paramOnActionExpandListener);
    return this;
  }
  
  public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    ef localef = (ef)this.d;
    if (paramOnMenuItemClickListener != null) {
      paramOnMenuItemClickListener = new d(paramOnMenuItemClickListener);
    } else {
      paramOnMenuItemClickListener = null;
    }
    localef.setOnMenuItemClickListener(paramOnMenuItemClickListener);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    ((ef)this.d).setShortcut(paramChar1, paramChar2);
    return this;
  }
  
  public MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2)
  {
    ((ef)this.d).setShortcut(paramChar1, paramChar2, paramInt1, paramInt2);
    return this;
  }
  
  public void setShowAsAction(int paramInt)
  {
    ((ef)this.d).setShowAsAction(paramInt);
  }
  
  public MenuItem setShowAsActionFlags(int paramInt)
  {
    ((ef)this.d).setShowAsActionFlags(paramInt);
    return this;
  }
  
  public MenuItem setTitle(int paramInt)
  {
    ((ef)this.d).setTitle(paramInt);
    return this;
  }
  
  public MenuItem setTitle(CharSequence paramCharSequence)
  {
    ((ef)this.d).setTitle(paramCharSequence);
    return this;
  }
  
  public MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    ((ef)this.d).setTitleCondensed(paramCharSequence);
    return this;
  }
  
  public MenuItem setTooltipText(CharSequence paramCharSequence)
  {
    ((ef)this.d).b(paramCharSequence);
    return this;
  }
  
  public MenuItem setVisible(boolean paramBoolean)
  {
    return ((ef)this.d).setVisible(paramBoolean);
  }
  
  class a
    extends fa
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
      this.c.onPrepareSubMenu(ig.this.a(paramSubMenu));
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
    implements hp
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
    extends hz<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener
  {
    c(MenuItem.OnActionExpandListener paramOnActionExpandListener)
    {
      super();
    }
    
    public final boolean onMenuItemActionCollapse(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionCollapse(ig.this.a(paramMenuItem));
    }
    
    public final boolean onMenuItemActionExpand(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnActionExpandListener)this.d).onMenuItemActionExpand(ig.this.a(paramMenuItem));
    }
  }
  
  final class d
    extends hz<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener
  {
    d(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
    {
      super();
    }
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      return ((MenuItem.OnMenuItemClickListener)this.d).onMenuItemClick(ig.this.a(paramMenuItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ig
 * JD-Core Version:    0.7.0.1
 */