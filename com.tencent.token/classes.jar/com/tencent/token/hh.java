package com.tencent.token;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class hh<T>
  extends hi<T>
{
  final Context a;
  Map<do, MenuItem> b;
  Map<dp, SubMenu> c;
  
  hh(Context paramContext, T paramT)
  {
    super(paramT);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof do))
    {
      do localdo = (do)paramMenuItem;
      if (this.b == null) {
        this.b = new dv();
      }
      MenuItem localMenuItem = (MenuItem)this.b.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = hv.a(this.a, localdo);
        this.b.put(localdo, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof dp))
    {
      dp localdp = (dp)paramSubMenu;
      if (this.c == null) {
        this.c = new dv();
      }
      SubMenu localSubMenu = (SubMenu)this.c.get(localdp);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new ia(this.a, localdp);
        this.c.put(localdp, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hh
 * JD-Core Version:    0.7.0.1
 */