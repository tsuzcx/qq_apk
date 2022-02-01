package com.tencent.token;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class hp
  implements dq
{
  private static final int[] l = { 1, 4, 5, 3, 2, 0 };
  final Context a;
  public a b;
  ArrayList<hr> c;
  public ArrayList<hr> d;
  public int e = 0;
  CharSequence f;
  Drawable g;
  View h;
  public boolean i = false;
  hr j;
  public boolean k;
  private final Resources m;
  private boolean n;
  private boolean o;
  private ArrayList<hr> p;
  private boolean q;
  private ArrayList<hr> r;
  private boolean s;
  private ContextMenu.ContextMenuInfo t;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private ArrayList<hr> y = new ArrayList();
  private CopyOnWriteArrayList<WeakReference<hw>> z = new CopyOnWriteArrayList();
  
  public hp(Context paramContext)
  {
    this.a = paramContext;
    this.m = paramContext.getResources();
    this.c = new ArrayList();
    this.p = new ArrayList();
    boolean bool = true;
    this.q = true;
    this.d = new ArrayList();
    this.r = new ArrayList();
    this.s = true;
    if ((this.m.getConfiguration().keyboard == 1) || (!this.m.getBoolean(gs.b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
      bool = false;
    }
    this.o = bool;
  }
  
  private static int a(ArrayList<hr> paramArrayList, int paramInt)
  {
    int i1 = paramArrayList.size() - 1;
    while (i1 >= 0)
    {
      if (((hr)paramArrayList.get(i1)).a <= paramInt) {
        return i1 + 1;
      }
      i1 -= 1;
    }
    return 0;
  }
  
  private MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    int i1 = (0xFFFF0000 & paramInt3) >> 16;
    if (i1 >= 0)
    {
      Object localObject = l;
      if (i1 < localObject.length)
      {
        i1 = localObject[i1] << 16 | 0xFFFF & paramInt3;
        paramCharSequence = new hr(this, paramInt1, paramInt2, paramInt3, i1, paramCharSequence, this.e);
        localObject = this.t;
        if (localObject != null) {
          paramCharSequence.d = ((ContextMenu.ContextMenuInfo)localObject);
        }
        localObject = this.c;
        ((ArrayList)localObject).add(a((ArrayList)localObject, i1), paramCharSequence);
        b(true);
        return paramCharSequence;
      }
    }
    throw new IllegalArgumentException("order does not contain a valid category.");
  }
  
  private hr a(int paramInt, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = this.y;
    localArrayList.clear();
    a(localArrayList, paramInt, paramKeyEvent);
    if (localArrayList.isEmpty()) {
      return null;
    }
    int i3 = paramKeyEvent.getMetaState();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    paramKeyEvent.getKeyData(localKeyData);
    int i4 = localArrayList.size();
    if (i4 == 1) {
      return (hr)localArrayList.get(0);
    }
    boolean bool = b();
    int i1 = 0;
    while (i1 < i4)
    {
      paramKeyEvent = (hr)localArrayList.get(i1);
      int i2;
      if (bool) {
        i2 = paramKeyEvent.getAlphabeticShortcut();
      } else {
        i2 = paramKeyEvent.getNumericShortcut();
      }
      if (((i2 == localKeyData.meta[0]) && ((i3 & 0x2) == 0)) || ((i2 == localKeyData.meta[2]) && ((i3 & 0x2) != 0)) || ((bool) && (i2 == 8) && (paramInt == 67))) {
        return paramKeyEvent;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.c.size()) {
        return;
      }
      this.c.remove(paramInt);
      if (paramBoolean) {
        b(true);
      }
      return;
    }
  }
  
  private void a(List<hr> paramList, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = b();
    int i4 = paramKeyEvent.getModifiers();
    KeyCharacterMap.KeyData localKeyData = new KeyCharacterMap.KeyData();
    if ((!paramKeyEvent.getKeyData(localKeyData)) && (paramInt != 67)) {
      return;
    }
    int i5 = this.c.size();
    int i1 = 0;
    while (i1 < i5)
    {
      hr localhr = (hr)this.c.get(i1);
      if (localhr.hasSubMenu()) {
        ((hp)localhr.getSubMenu()).a(paramList, paramInt, paramKeyEvent);
      }
      int i2;
      if (bool) {
        i2 = localhr.getAlphabeticShortcut();
      } else {
        i2 = localhr.getNumericShortcut();
      }
      int i3;
      if (bool) {
        i3 = localhr.getAlphabeticModifiers();
      } else {
        i3 = localhr.getNumericModifiers();
      }
      if ((i4 & 0x1100F) == (i3 & 0x1100F)) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if ((i3 != 0) && (i2 != 0) && ((i2 == localKeyData.meta[0]) || (i2 == localKeyData.meta[2]) || ((bool) && (i2 == 8) && (paramInt == 67))) && (localhr.isEnabled())) {
        paramList.add(localhr);
      }
      i1 += 1;
    }
  }
  
  private boolean a(ic paramic, hw paramhw)
  {
    boolean bool2 = this.z.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (paramhw != null) {
      bool1 = paramhw.a(paramic);
    }
    paramhw = this.z.iterator();
    while (paramhw.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)paramhw.next();
      hw localhw = (hw)localWeakReference.get();
      if (localhw == null) {
        this.z.remove(localWeakReference);
      } else if (!bool1) {
        bool1 = localhw.a(paramic);
      }
    }
    return bool1;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.z.isEmpty()) {
      return;
    }
    d();
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      hw localhw = (hw)localWeakReference.get();
      if (localhw == null) {
        this.z.remove(localWeakReference);
      } else {
        localhw.b(paramBoolean);
      }
    }
    e();
  }
  
  protected String a()
  {
    return "android:menu:actionviewstates";
  }
  
  final void a(int paramInt1, CharSequence paramCharSequence, int paramInt2, Drawable paramDrawable, View paramView)
  {
    Resources localResources = this.m;
    if (paramView != null)
    {
      this.h = paramView;
      this.f = null;
      this.g = null;
    }
    else
    {
      if (paramInt1 > 0) {
        this.f = localResources.getText(paramInt1);
      } else if (paramCharSequence != null) {
        this.f = paramCharSequence;
      }
      if (paramInt2 > 0) {
        this.g = cv.a(this.a, paramInt2);
      } else if (paramDrawable != null) {
        this.g = paramDrawable;
      }
      this.h = null;
    }
    b(false);
  }
  
  public final void a(Bundle paramBundle)
  {
    int i2 = size();
    Object localObject1 = null;
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = localMenuItem.getActionView();
      Object localObject3 = localObject1;
      if (localView != null)
      {
        localObject3 = localObject1;
        if (localView.getId() != -1)
        {
          Object localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new SparseArray();
          }
          localView.saveHierarchyState((SparseArray)localObject2);
          localObject3 = localObject2;
          if (localMenuItem.isActionViewExpanded())
          {
            paramBundle.putInt("android:menu:expandedactionview", localMenuItem.getItemId());
            localObject3 = localObject2;
          }
        }
      }
      if (localMenuItem.hasSubMenu()) {
        ((ic)localMenuItem.getSubMenu()).a(paramBundle);
      }
      i1 += 1;
      localObject1 = localObject3;
    }
    if (localObject1 != null) {
      paramBundle.putSparseParcelableArray(a(), localObject1);
    }
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public final void a(hw paramhw)
  {
    a(paramhw, this.a);
  }
  
  public final void a(hw paramhw, Context paramContext)
  {
    this.z.add(new WeakReference(paramhw));
    paramhw.a(paramContext, this);
    this.s = true;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.x) {
      return;
    }
    this.x = true;
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      hw localhw = (hw)localWeakReference.get();
      if (localhw == null) {
        this.z.remove(localWeakReference);
      } else {
        localhw.a(this, paramBoolean);
      }
    }
    this.x = false;
  }
  
  public final boolean a(MenuItem paramMenuItem, hw paramhw, int paramInt)
  {
    Object localObject = (hr)paramMenuItem;
    if (localObject != null)
    {
      if (!((hr)localObject).isEnabled()) {
        return false;
      }
      boolean bool2 = ((hr)localObject).b();
      paramMenuItem = ((hr)localObject).c;
      int i1;
      if ((paramMenuItem != null) && (paramMenuItem.e())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      boolean bool1;
      if (((hr)localObject).j())
      {
        bool2 |= ((hr)localObject).expandActionView();
        bool1 = bool2;
        if (bool2)
        {
          a(true);
          return bool2;
        }
      }
      else if ((!((hr)localObject).hasSubMenu()) && (i1 == 0))
      {
        bool1 = bool2;
        if ((paramInt & 0x1) == 0)
        {
          a(true);
          return bool2;
        }
      }
      else
      {
        if ((paramInt & 0x4) == 0) {
          a(false);
        }
        if (!((hr)localObject).hasSubMenu()) {
          ((hr)localObject).a(new ic(this.a, this, (hr)localObject));
        }
        localObject = (ic)((hr)localObject).getSubMenu();
        if (i1 != 0) {
          paramMenuItem.a((SubMenu)localObject);
        }
        bool2 |= a((ic)localObject, paramhw);
        bool1 = bool2;
        if (!bool2)
        {
          a(true);
          bool1 = bool2;
        }
      }
      return bool1;
    }
    return false;
  }
  
  boolean a(hp paramhp, MenuItem paramMenuItem)
  {
    a locala = this.b;
    return (locala != null) && (locala.a(paramhp, paramMenuItem));
  }
  
  public boolean a(hr paramhr)
  {
    boolean bool2 = this.z.isEmpty();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    d();
    Iterator localIterator = this.z.iterator();
    do
    {
      hw localhw;
      for (;;)
      {
        bool2 = bool1;
        if (!localIterator.hasNext()) {
          break label96;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        localhw = (hw)localWeakReference.get();
        if (localhw != null) {
          break;
        }
        this.z.remove(localWeakReference);
      }
      bool2 = localhw.b(paramhr);
      bool1 = bool2;
    } while (!bool2);
    label96:
    e();
    if (bool2) {
      this.j = paramhr;
    }
    return bool2;
  }
  
  public MenuItem add(int paramInt)
  {
    return a(0, 0, 0, this.m.getString(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, this.m.getString(paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(paramInt1, paramInt2, paramInt3, paramCharSequence);
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return a(0, 0, 0, paramCharSequence);
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    PackageManager localPackageManager = this.a.getPackageManager();
    int i3 = 0;
    List localList = localPackageManager.queryIntentActivityOptions(paramComponentName, paramArrayOfIntent, paramIntent, 0);
    int i1;
    if (localList != null) {
      i1 = localList.size();
    } else {
      i1 = 0;
    }
    int i2 = i3;
    if ((paramInt4 & 0x1) == 0)
    {
      removeGroup(paramInt1);
      i2 = i3;
    }
    while (i2 < i1)
    {
      ResolveInfo localResolveInfo = (ResolveInfo)localList.get(i2);
      if (localResolveInfo.specificIndex < 0) {
        paramComponentName = paramIntent;
      } else {
        paramComponentName = paramArrayOfIntent[localResolveInfo.specificIndex];
      }
      paramComponentName = new Intent(paramComponentName);
      paramComponentName.setComponent(new ComponentName(localResolveInfo.activityInfo.applicationInfo.packageName, localResolveInfo.activityInfo.name));
      paramComponentName = add(paramInt1, paramInt2, paramInt3, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setIntent(paramComponentName);
      if ((paramArrayOfMenuItem != null) && (localResolveInfo.specificIndex >= 0)) {
        paramArrayOfMenuItem[localResolveInfo.specificIndex] = paramComponentName;
      }
      i2 += 1;
    }
    return i1;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return addSubMenu(0, 0, 0, this.m.getString(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return addSubMenu(paramInt1, paramInt2, paramInt3, this.m.getString(paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (hr)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    ic localic = new ic(this.a, this, paramCharSequence);
    paramCharSequence.a(localic);
    return localic;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return addSubMenu(0, 0, 0, paramCharSequence);
  }
  
  public final void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    SparseArray localSparseArray = paramBundle.getSparseParcelableArray(a());
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      MenuItem localMenuItem = getItem(i1);
      View localView = localMenuItem.getActionView();
      if ((localView != null) && (localView.getId() != -1)) {
        localView.restoreHierarchyState(localSparseArray);
      }
      if (localMenuItem.hasSubMenu()) {
        ((ic)localMenuItem.getSubMenu()).b(paramBundle);
      }
      i1 += 1;
    }
    i1 = paramBundle.getInt("android:menu:expandedactionview");
    if (i1 > 0)
    {
      paramBundle = findItem(i1);
      if (paramBundle != null) {
        paramBundle.expandActionView();
      }
    }
  }
  
  public final void b(hw paramhw)
  {
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      hw localhw = (hw)localWeakReference.get();
      if ((localhw == null) || (localhw == paramhw)) {
        this.z.remove(localWeakReference);
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (!this.u)
    {
      if (paramBoolean)
      {
        this.q = true;
        this.s = true;
      }
      c(paramBoolean);
      return;
    }
    this.v = true;
    if (paramBoolean) {
      this.w = true;
    }
  }
  
  boolean b()
  {
    return this.n;
  }
  
  public boolean b(hr paramhr)
  {
    boolean bool2 = this.z.isEmpty();
    boolean bool1 = false;
    if (!bool2)
    {
      if (this.j != paramhr) {
        return false;
      }
      d();
      Iterator localIterator = this.z.iterator();
      do
      {
        hw localhw;
        for (;;)
        {
          bool2 = bool1;
          if (!localIterator.hasNext()) {
            break label104;
          }
          WeakReference localWeakReference = (WeakReference)localIterator.next();
          localhw = (hw)localWeakReference.get();
          if (localhw != null) {
            break;
          }
          this.z.remove(localWeakReference);
        }
        bool2 = localhw.c(paramhr);
        bool1 = bool2;
      } while (!bool2);
      label104:
      e();
      if (bool2) {
        this.j = null;
      }
      return bool2;
    }
    return false;
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public void clear()
  {
    hr localhr = this.j;
    if (localhr != null) {
      b(localhr);
    }
    this.c.clear();
    b(true);
  }
  
  public void clearHeader()
  {
    this.g = null;
    this.f = null;
    this.h = null;
    b(false);
  }
  
  public void close()
  {
    a(true);
  }
  
  public final void d()
  {
    if (!this.u)
    {
      this.u = true;
      this.v = false;
      this.w = false;
    }
  }
  
  public final void e()
  {
    this.u = false;
    if (this.v)
    {
      this.v = false;
      b(this.w);
    }
  }
  
  final void f()
  {
    this.q = true;
    b(true);
  }
  
  public MenuItem findItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = (hr)this.c.get(i1);
      if (((hr)localObject).getItemId() == paramInt) {
        return localObject;
      }
      if (((hr)localObject).hasSubMenu())
      {
        localObject = ((hr)localObject).getSubMenu().findItem(paramInt);
        if (localObject != null) {
          return localObject;
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  public final void g()
  {
    this.s = true;
    b(true);
  }
  
  public MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.c.get(paramInt);
  }
  
  public final ArrayList<hr> h()
  {
    if (!this.q) {
      return this.p;
    }
    this.p.clear();
    int i2 = this.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      hr localhr = (hr)this.c.get(i1);
      if (localhr.isVisible()) {
        this.p.add(localhr);
      }
      i1 += 1;
    }
    this.q = false;
    this.s = true;
    return this.p;
  }
  
  public boolean hasVisibleItems()
  {
    if (this.k) {
      return true;
    }
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((hr)this.c.get(i1)).isVisible()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  public final void i()
  {
    ArrayList localArrayList = h();
    if (!this.s) {
      return;
    }
    Object localObject = this.z.iterator();
    int i1 = 0;
    while (((Iterator)localObject).hasNext())
    {
      WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
      hw localhw = (hw)localWeakReference.get();
      if (localhw == null) {
        this.z.remove(localWeakReference);
      } else {
        i1 |= localhw.a();
      }
    }
    if (i1 != 0)
    {
      this.d.clear();
      this.r.clear();
      int i3 = localArrayList.size();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = (hr)localArrayList.get(i1);
        if (((hr)localObject).f()) {
          this.d.add(localObject);
        } else {
          this.r.add(localObject);
        }
        int i2;
        i1 += 1;
      }
    }
    this.d.clear();
    this.r.clear();
    this.r.addAll(h());
    this.s = false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return a(paramInt, paramKeyEvent) != null;
  }
  
  public final ArrayList<hr> j()
  {
    i();
    return this.r;
  }
  
  public hp k()
  {
    return this;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return a(findItem(paramInt1), null, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    paramKeyEvent = a(paramInt1, paramKeyEvent);
    boolean bool;
    if (paramKeyEvent != null) {
      bool = a(paramKeyEvent, null, paramInt2);
    } else {
      bool = false;
    }
    if ((paramInt2 & 0x2) != 0) {
      a(true);
    }
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((hr)this.c.get(i1)).getGroupId() == paramInt) {
        break label42;
      }
      i1 += 1;
    }
    i1 = -1;
    label42:
    if (i1 >= 0)
    {
      int i3 = this.c.size();
      i2 = 0;
      while ((i2 < i3 - i1) && (((hr)this.c.get(i1)).getGroupId() == paramInt))
      {
        a(i1, false);
        i2 += 1;
      }
      b(true);
    }
  }
  
  public void removeItem(int paramInt)
  {
    int i2 = size();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((hr)this.c.get(i1)).getItemId() == paramInt) {
        break label42;
      }
      i1 += 1;
    }
    i1 = -1;
    label42:
    a(i1, true);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i2 = this.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      hr localhr = (hr)this.c.get(i1);
      if (localhr.getGroupId() == paramInt)
      {
        localhr.a(paramBoolean2);
        localhr.setCheckable(paramBoolean1);
      }
      i1 += 1;
    }
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    int i2 = this.c.size();
    int i1 = 0;
    while (i1 < i2)
    {
      hr localhr = (hr)this.c.get(i1);
      if (localhr.getGroupId() == paramInt) {
        localhr.setEnabled(paramBoolean);
      }
      i1 += 1;
    }
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    int i4 = this.c.size();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      hr localhr = (hr)this.c.get(i1);
      i3 = i2;
      if (localhr.getGroupId() == paramInt)
      {
        i3 = i2;
        if (localhr.b(paramBoolean)) {
          i3 = 1;
        }
      }
      i1 += 1;
    }
    if (i2 != 0) {
      b(true);
    }
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    this.n = paramBoolean;
    b(false);
  }
  
  public int size()
  {
    return this.c.size();
  }
  
  public static abstract interface a
  {
    public abstract void a(hp paramhp);
    
    public abstract boolean a(hp paramhp, MenuItem paramMenuItem);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(hr paramhr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hp
 * JD-Core Version:    0.7.0.1
 */