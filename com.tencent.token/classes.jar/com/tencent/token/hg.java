package com.tencent.token;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class hg<T>
  extends hh<T>
{
  final Context a;
  Map<dn, MenuItem> b;
  Map<do, SubMenu> c;
  
  hg(Context paramContext, T paramT)
  {
    super(paramT);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof dn))
    {
      dn localdn = (dn)paramMenuItem;
      if (this.b == null) {
        this.b = new du();
      }
      MenuItem localMenuItem = (MenuItem)this.b.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = hu.a(this.a, localdn);
        this.b.put(localdn, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof do))
    {
      do localdo = (do)paramSubMenu;
      if (this.c == null) {
        this.c = new du();
      }
      SubMenu localSubMenu = (SubMenu)this.c.get(localdo);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new hz(this.a, localdo);
        this.c.put(localdo, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hg
 * JD-Core Version:    0.7.0.1
 */