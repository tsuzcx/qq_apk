package com.tencent.token;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class hy<T>
  extends hz<T>
{
  final Context a;
  Map<ef, MenuItem> b;
  Map<eg, SubMenu> c;
  
  hy(Context paramContext, T paramT)
  {
    super(paramT);
    this.a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof ef))
    {
      ef localef = (ef)paramMenuItem;
      if (this.b == null) {
        this.b = new em();
      }
      MenuItem localMenuItem = (MenuItem)this.b.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = im.a(this.a, localef);
        this.b.put(localef, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof eg))
    {
      eg localeg = (eg)paramSubMenu;
      if (this.c == null) {
        this.c = new em();
      }
      SubMenu localSubMenu = (SubMenu)this.c.get(localeg);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new ir(this.a, localeg);
        this.c.put(localeg, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hy
 * JD-Core Version:    0.7.0.1
 */