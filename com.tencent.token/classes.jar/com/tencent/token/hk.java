package com.tencent.token;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class hk<T>
  extends hl<T>
{
  final Context a;
  Map<dr, MenuItem> b;
  Map<ds, SubMenu> c;
  
  hk(Context paramContext, T paramT)
  {
    super(paramT);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof dr))
    {
      dr localdr = (dr)paramMenuItem;
      if (this.b == null) {
        this.b = new dy();
      }
      MenuItem localMenuItem = (MenuItem)this.b.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = hy.a(this.a, localdr);
        this.b.put(localdr, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof ds))
    {
      ds localds = (ds)paramSubMenu;
      if (this.c == null) {
        this.c = new dy();
      }
      SubMenu localSubMenu = (SubMenu)this.c.get(localds);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new id(this.a, localds);
        this.c.put(localds, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hk
 * JD-Core Version:    0.7.0.1
 */