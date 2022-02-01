package com.tencent.token;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class cw
{
  private static final int[] a = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  private static final cy b;
  private static final cy c = a();
  
  static
  {
    cx localcx;
    if (Build.VERSION.SDK_INT >= 21) {
      localcx = new cx();
    } else {
      localcx = null;
    }
    b = localcx;
  }
  
  private static a a(a parama, SparseArray<a> paramSparseArray, int paramInt)
  {
    a locala = parama;
    if (parama == null)
    {
      locala = new a();
      paramSparseArray.put(paramInt, locala);
    }
    return locala;
  }
  
  private static cy a()
  {
    try
    {
      cy localcy = (cy)Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localcy;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  private static cy a(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.j();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.i();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.m();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.h();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.k();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.l();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramFragment1 = b;
    if ((paramFragment1 != null) && (a(paramFragment1, localArrayList))) {
      return b;
    }
    paramFragment1 = c;
    if ((paramFragment1 != null) && (a(paramFragment1, localArrayList))) {
      return c;
    }
    if ((b == null) && (c == null)) {
      return null;
    }
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  private static em<String, String> a(int paramInt1, ArrayList<cm> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    em localem = new em();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (cm)paramArrayList.get(paramInt3);
      if (((cm)localObject).b(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((cm)localObject).r != null)
        {
          int j = ((cm)localObject).r.size();
          ArrayList localArrayList2;
          ArrayList localArrayList1;
          if (bool)
          {
            localArrayList2 = ((cm)localObject).r;
            localArrayList1 = ((cm)localObject).s;
          }
          else
          {
            localArrayList1 = ((cm)localObject).r;
            localArrayList2 = ((cm)localObject).s;
          }
          int i = 0;
          while (i < j)
          {
            localObject = (String)localArrayList1.get(i);
            String str1 = (String)localArrayList2.get(i);
            String str2 = (String)localem.remove(str1);
            if (str2 != null) {
              localem.put(localObject, str2);
            } else {
              localem.put(localObject, str1);
            }
            i += 1;
          }
        }
      }
      paramInt3 -= 1;
    }
    return localem;
  }
  
  private static Object a(cy paramcy, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (paramBoolean) {
        paramFragment1 = paramFragment2.m();
      } else {
        paramFragment1 = paramFragment1.l();
      }
      return paramcy.c(paramcy.b(paramFragment1));
    }
    return null;
  }
  
  private static Object a(cy paramcy, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.k();
    } else {
      paramFragment = paramFragment.h();
    }
    return paramcy.b(paramFragment);
  }
  
  private static Object a(cy paramcy, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramFragment != null))
    {
      if (paramBoolean) {
        paramBoolean = paramFragment.o();
      } else {
        paramBoolean = paramFragment.n();
      }
    }
    else {
      paramBoolean = true;
    }
    if (paramBoolean) {
      return paramcy.a(paramObject2, paramObject1, paramObject3);
    }
    return paramcy.b(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(em<String, String> paramem, String paramString)
  {
    int j = paramem.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramem.c(i))) {
        return (String)paramem.b(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static void a(cm paramcm, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    int j = paramcm.b.size();
    int i = 0;
    while (i < j)
    {
      a(paramcm, (cm.a)paramcm.b.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static void a(cm paramcm, cm.a parama, SparseArray<a> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = parama.b;
    if (localFragment == null) {
      return;
    }
    int m = localFragment.z;
    if (m == 0) {
      return;
    }
    int i;
    if (paramBoolean1) {
      i = a[parama.a];
    } else {
      i = parama.a;
    }
    boolean bool = false;
    int k = 1;
    int j;
    if (i != 1)
    {
      switch (i)
      {
      default: 
        j = 0;
        k = 0;
        i = 0;
        break;
      case 5: 
        if (paramBoolean2)
        {
          if ((localFragment.Q) && (!localFragment.B) && (localFragment.l)) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else {
          bool = localFragment.B;
        }
        j = 0;
        i = 0;
        break;
      case 4: 
        if (paramBoolean2)
        {
          if ((localFragment.Q) && (localFragment.l) && (localFragment.B)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else if ((localFragment.l) && (!localFragment.B)) {
          i = 1;
        } else {
          i = 0;
        }
        j = 1;
        k = 0;
        break;
      case 3: 
      case 6: 
        if (paramBoolean2)
        {
          if ((!localFragment.l) && (localFragment.J != null) && (localFragment.J.getVisibility() == 0) && (localFragment.R >= 0.0F)) {
            i = 1;
          } else {
            i = 0;
          }
        }
        else if ((localFragment.l) && (!localFragment.B)) {
          i = 1;
        } else {
          i = 0;
        }
        j = 1;
        k = 0;
        break;
      }
    }
    else
    {
      if (paramBoolean2) {
        bool = localFragment.P;
      } else if ((!localFragment.l) && (!localFragment.B)) {
        bool = true;
      } else {
        bool = false;
      }
      j = 0;
      i = 0;
    }
    parama = (a)paramSparseArray.get(m);
    if (bool)
    {
      parama = a(parama, paramSparseArray, m);
      parama.a = localFragment;
      parama.b = paramBoolean1;
      parama.c = paramcm;
    }
    if ((!paramBoolean2) && (k != 0))
    {
      if ((parama != null) && (parama.d == localFragment)) {
        parama.d = null;
      }
      localObject = paramcm.a;
      if ((localFragment.b <= 0) && (((ct)localObject).l > 0) && (!paramcm.t))
      {
        ((ct)localObject).b(localFragment);
        ((ct)localObject).a(localFragment, 1, 0, 0, false);
      }
    }
    Object localObject = parama;
    if (i != 0) {
      if (parama != null)
      {
        localObject = parama;
        if (parama.d != null) {}
      }
      else
      {
        localObject = a(parama, paramSparseArray, m);
        ((a)localObject).d = localFragment;
        ((a)localObject).e = paramBoolean1;
        ((a)localObject).f = paramcm;
      }
    }
    if ((!paramBoolean2) && (j != 0) && (localObject != null) && (((a)localObject).a == localFragment)) {
      ((a)localObject).a = null;
    }
  }
  
  static void a(ct paramct, ArrayList<cm> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = paramct;
    final boolean bool1 = paramBoolean;
    if (((ct)localObject1).l <= 0) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = paramInt1;
    Object localObject2;
    while (i < paramInt2)
    {
      localObject2 = (cm)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        b((cm)localObject2, localSparseArray, bool1);
      } else {
        a((cm)localObject2, localSparseArray, bool1);
      }
      i += 1;
    }
    if (localSparseArray.size() != 0)
    {
      final View localView = new View(((ct)localObject1).m.c);
      i = localSparseArray.size();
      int j = 0;
      for (;;)
      {
        localObject1 = paramct;
        if (j >= i) {
          break;
        }
        int k = localSparseArray.keyAt(j);
        Object localObject4 = a(k, paramArrayList, paramArrayList1, paramInt1, paramInt2);
        final a locala = (a)localSparseArray.valueAt(j);
        Object localObject7;
        Object localObject13;
        Object localObject9;
        final boolean bool2;
        Object localObject8;
        Object localObject10;
        final Object localObject11;
        Object localObject12;
        Fragment localFragment1;
        final Fragment localFragment2;
        final Object localObject3;
        Object localObject14;
        Object localObject5;
        final Object localObject6;
        if (paramBoolean)
        {
          if (((ct)localObject1).n.a()) {
            localObject2 = (ViewGroup)((ct)localObject1).n.a(k);
          } else {
            localObject2 = null;
          }
          if (localObject2 != null)
          {
            localObject7 = locala.a;
            localObject13 = locala.d;
            localObject9 = a((Fragment)localObject13, (Fragment)localObject7);
            if (localObject9 != null)
            {
              bool1 = locala.b;
              bool2 = locala.e;
              localObject8 = new ArrayList();
              localObject10 = new ArrayList();
              localObject11 = a((cy)localObject9, (Fragment)localObject7, bool1);
              localObject12 = b((cy)localObject9, (Fragment)localObject13, bool2);
              localFragment1 = locala.a;
              localFragment2 = locala.d;
              if (localFragment1 != null) {
                localFragment1.J.setVisibility(0);
              }
              if ((localFragment1 != null) && (localFragment2 != null))
              {
                bool2 = locala.b;
                if (((em)localObject4).isEmpty()) {
                  localObject1 = null;
                } else {
                  localObject1 = a((cy)localObject9, localFragment1, localFragment2, bool2);
                }
                localObject3 = b((cy)localObject9, (em)localObject4, localObject1, locala);
                localObject14 = c((cy)localObject9, (em)localObject4, localObject1, locala);
                if (((em)localObject4).isEmpty())
                {
                  if (localObject3 != null) {
                    ((em)localObject3).clear();
                  }
                  if (localObject14 != null) {
                    ((em)localObject14).clear();
                  }
                  localObject1 = null;
                }
                else
                {
                  a((ArrayList)localObject10, (em)localObject3, ((em)localObject4).keySet());
                  a((ArrayList)localObject8, (em)localObject14, ((em)localObject4).values());
                }
                if ((localObject11 == null) && (localObject12 == null) && (localObject1 == null))
                {
                  localObject1 = null;
                }
                else
                {
                  b(localFragment1, localFragment2, bool2, (em)localObject3);
                  if (localObject1 != null)
                  {
                    ((ArrayList)localObject8).add(localView);
                    ((cy)localObject9).a(localObject1, localView, (ArrayList)localObject10);
                    a((cy)localObject9, localObject1, localObject12, (em)localObject3, locala.e, locala.f);
                    localObject3 = new Rect();
                    localObject5 = b((em)localObject14, locala, localObject11, bool2);
                    if (localObject5 != null) {
                      ((cy)localObject9).a(localObject11, (Rect)localObject3);
                    }
                    localObject6 = localObject3;
                  }
                  else
                  {
                    localObject3 = null;
                    localObject6 = localObject3;
                    localObject5 = localObject3;
                  }
                  de.a((View)localObject2, new Runnable()
                  {
                    public final void run()
                    {
                      cw.a(this.a, localFragment2, bool2, this.d);
                      View localView = this.e;
                      if (localView != null) {
                        cy.a(localView, this.g);
                      }
                    }
                  });
                }
              }
              else
              {
                localObject1 = null;
              }
              if ((localObject11 == null) && (localObject1 == null) && (localObject12 == null)) {
                break label846;
              }
              localObject3 = b((cy)localObject9, localObject12, (Fragment)localObject13, (ArrayList)localObject10, localView);
              localObject5 = b((cy)localObject9, localObject11, (Fragment)localObject7, (ArrayList)localObject8, localView);
              a((ArrayList)localObject5, 4);
              localObject6 = a((cy)localObject9, localObject11, localObject12, localObject1, (Fragment)localObject7, bool1);
              if (localObject6 != null)
              {
                if ((localObject13 != null) && (localObject12 != null) && (((Fragment)localObject13).l) && (((Fragment)localObject13).B) && (((Fragment)localObject13).Q))
                {
                  ((Fragment)localObject13).c(true);
                  ((cy)localObject9).b(localObject12, ((Fragment)localObject13).J, (ArrayList)localObject3);
                  de.a(((Fragment)localObject13).I, new Runnable()
                  {
                    public final void run()
                    {
                      cw.a(this.a);
                    }
                  });
                }
                localObject7 = cy.a((ArrayList)localObject8);
                ((cy)localObject9).a(localObject6, localObject11, (ArrayList)localObject5, localObject12, (ArrayList)localObject3, localObject1, (ArrayList)localObject8);
                ((cy)localObject9).a((ViewGroup)localObject2, localObject6);
                ((cy)localObject9).a((View)localObject2, (ArrayList)localObject10, (ArrayList)localObject8, (ArrayList)localObject7, (Map)localObject4);
                a((ArrayList)localObject5, 0);
                ((cy)localObject9).a(localObject1, (ArrayList)localObject10, (ArrayList)localObject8);
              }
            }
            else {}
          }
        }
        else
        {
          label846:
          localObject3 = localObject4;
          if (((ct)localObject1).n.a()) {
            localObject5 = (ViewGroup)((ct)localObject1).n.a(k);
          } else {
            localObject5 = null;
          }
          if (localObject5 != null)
          {
            localObject12 = locala.a;
            localFragment1 = locala.d;
            localObject13 = a(localFragment1, (Fragment)localObject12);
            if (localObject13 != null)
            {
              bool1 = locala.b;
              bool2 = locala.e;
              localObject11 = a((cy)localObject13, (Fragment)localObject12, bool1);
              localObject10 = b((cy)localObject13, localFragment1, bool2);
              localObject1 = new ArrayList();
              localObject2 = new ArrayList();
              localFragment2 = locala.a;
              localObject14 = locala.d;
              if ((localFragment2 != null) && (localObject14 != null))
              {
                bool1 = locala.b;
                if (((em)localObject3).isEmpty()) {
                  localObject3 = null;
                } else {
                  localObject3 = a((cy)localObject13, localFragment2, (Fragment)localObject14, bool1);
                }
                localObject7 = b((cy)localObject13, (em)localObject4, localObject3, locala);
                if (((em)localObject4).isEmpty()) {
                  localObject3 = null;
                } else {
                  ((ArrayList)localObject1).addAll(((em)localObject7).values());
                }
                if ((localObject11 == null) && (localObject10 == null) && (localObject3 == null))
                {
                  localObject3 = localObject4;
                  localObject6 = null;
                  localObject4 = localObject1;
                  localObject1 = localObject6;
                }
                else
                {
                  b(localFragment2, (Fragment)localObject14, bool1, (em)localObject7);
                  if (localObject3 != null)
                  {
                    localObject6 = new Rect();
                    ((cy)localObject13).a(localObject3, localView, (ArrayList)localObject1);
                    a((cy)localObject13, localObject3, localObject10, (em)localObject7, locala.e, locala.f);
                    localObject7 = localObject6;
                    if (localObject11 != null)
                    {
                      ((cy)localObject13).a(localObject11, (Rect)localObject6);
                      localObject7 = localObject6;
                    }
                  }
                  else
                  {
                    localObject7 = null;
                  }
                  localObject8 = localObject4;
                  localObject9 = localObject2;
                  localObject6 = localObject8;
                  localObject2 = localObject9;
                  localObject4 = localObject1;
                  de.a((View)localObject5, new Runnable()
                  {
                    public final void run()
                    {
                      Object localObject1 = cw.a(this.a, this.b, localObject3, locala);
                      if (localObject1 != null)
                      {
                        this.e.addAll(((em)localObject1).values());
                        this.e.add(localView);
                      }
                      cw.a(localFragment2, this.h, bool1, (em)localObject1);
                      Object localObject2 = localObject3;
                      if (localObject2 != null)
                      {
                        this.a.a(localObject2, this.j, this.e);
                        localObject1 = cw.a((em)localObject1, locala, localObject11, bool1);
                        if (localObject1 != null) {
                          cy.a((View)localObject1, this.l);
                        }
                      }
                    }
                  });
                  localObject1 = localObject3;
                  localObject3 = localObject6;
                }
              }
              else
              {
                localObject6 = null;
                localObject4 = localObject1;
                localObject1 = localObject6;
              }
              k = j;
              int m = i;
              localObject6 = localObject10;
              if ((localObject11 == null) && (localObject1 == null))
              {
                i = m;
                j = k;
                if (localObject6 == null) {}
              }
              else
              {
                localObject4 = b((cy)localObject13, localObject6, localFragment1, (ArrayList)localObject4, localView);
                if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
                  localObject6 = null;
                }
                ((cy)localObject13).b(localObject11, localView);
                localObject7 = a((cy)localObject13, localObject11, localObject6, localObject1, (Fragment)localObject12, locala.b);
                i = m;
                j = k;
                if (localObject7 != null)
                {
                  localObject8 = new ArrayList();
                  ((cy)localObject13).a(localObject7, localObject11, (ArrayList)localObject8, localObject6, (ArrayList)localObject4, localObject1, (ArrayList)localObject2);
                  de.a((View)localObject5, new Runnable()
                  {
                    public final void run()
                    {
                      Object localObject = this.a;
                      if (localObject != null)
                      {
                        this.b.c(localObject, localView);
                        localObject = cw.a(this.b, this.a, this.d, this.e, localView);
                        this.f.addAll((Collection)localObject);
                      }
                      if (this.g != null)
                      {
                        if (localObject6 != null)
                        {
                          localObject = new ArrayList();
                          ((ArrayList)localObject).add(localView);
                          this.b.b(localObject6, this.g, (ArrayList)localObject);
                        }
                        this.g.clear();
                        this.g.add(localView);
                      }
                    }
                  });
                  de.a((View)localObject5, new cy.2((cy)localObject13, (ArrayList)localObject2, (Map)localObject3));
                  ((cy)localObject13).a((ViewGroup)localObject5, localObject7);
                  de.a((View)localObject5, new cy.3((cy)localObject13, (ArrayList)localObject2, (Map)localObject3));
                  i = m;
                  j = k;
                }
              }
            }
            else {}
          }
        }
        j += 1;
      }
    }
  }
  
  private static void a(cy paramcy, Object paramObject1, Object paramObject2, em<String, View> paramem, boolean paramBoolean, cm paramcm)
  {
    if ((paramcm.r != null) && (!paramcm.r.isEmpty()))
    {
      if (paramBoolean) {
        paramcm = (String)paramcm.s.get(0);
      } else {
        paramcm = (String)paramcm.r.get(0);
      }
      paramem = (View)paramem.get(paramcm);
      paramcy.a(paramObject1, paramem);
      if (paramObject2 != null) {
        paramcy.a(paramObject2, paramem);
      }
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    int i = paramArrayList.size() - 1;
    while (i >= 0)
    {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
      i -= 1;
    }
  }
  
  private static void a(ArrayList<View> paramArrayList, em<String, View> paramem, Collection<String> paramCollection)
  {
    int i = paramem.size() - 1;
    while (i >= 0)
    {
      View localView = (View)paramem.c(i);
      if (paramCollection.contains(fo.h(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static boolean a(cy paramcy, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramcy.a(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static View b(em<String, View> paramem, a parama, Object paramObject, boolean paramBoolean)
  {
    parama = parama.c;
    if ((paramObject != null) && (paramem != null) && (parama.r != null) && (!parama.r.isEmpty()))
    {
      if (paramBoolean) {
        parama = (String)parama.r.get(0);
      } else {
        parama = (String)parama.s.get(0);
      }
      return (View)paramem.get(parama);
    }
    return null;
  }
  
  private static em<String, View> b(cy paramcy, em<String, String> paramem, Object paramObject, a parama)
  {
    if ((!paramem.isEmpty()) && (paramObject != null))
    {
      paramObject = parama.d;
      em localem = new em();
      paramcy.a(localem, paramObject.J);
      paramcy = parama.f;
      if (parama.e)
      {
        paramObject = paramObject.z();
        paramcy = paramcy.s;
      }
      else
      {
        paramObject = paramObject.A();
        paramcy = paramcy.r;
      }
      et.a(localem, paramcy);
      if (paramObject != null)
      {
        int i = paramcy.size() - 1;
        while (i >= 0)
        {
          parama = (String)paramcy.get(i);
          paramObject = (View)localem.get(parama);
          if (paramObject == null)
          {
            paramem.remove(parama);
          }
          else if (!parama.equals(fo.h(paramObject)))
          {
            parama = (String)paramem.remove(parama);
            paramem.put(fo.h(paramObject), parama);
          }
          i -= 1;
        }
      }
      et.a(paramem, localem.keySet());
      return localem;
    }
    paramem.clear();
    return null;
  }
  
  private static Object b(cy paramcy, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.i();
    } else {
      paramFragment = paramFragment.j();
    }
    return paramcy.b(paramFragment);
  }
  
  private static ArrayList<View> b(cy paramcy, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.J;
      if (paramFragment != null) {
        paramcy.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      paramFragment = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramcy.a(paramObject, localArrayList);
        return localArrayList;
      }
    }
    else
    {
      paramFragment = null;
    }
    return paramFragment;
  }
  
  private static void b(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, em<String, View> paramem)
  {
    if (paramBoolean) {
      paramFragment1 = paramFragment2.z();
    } else {
      paramFragment1 = paramFragment1.z();
    }
    if (paramFragment1 != null)
    {
      paramFragment1 = new ArrayList();
      paramFragment2 = new ArrayList();
      int j = 0;
      int i;
      if (paramem == null) {
        i = 0;
      } else {
        i = paramem.size();
      }
      while (j < i)
      {
        paramFragment2.add(paramem.b(j));
        paramFragment1.add(paramem.c(j));
        j += 1;
      }
    }
  }
  
  private static void b(cm paramcm, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    if (!paramcm.a.n.a()) {
      return;
    }
    int i = paramcm.b.size() - 1;
    while (i >= 0)
    {
      a(paramcm, (cm.a)paramcm.b.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
  }
  
  private static em<String, View> c(cy paramcy, em<String, String> paramem, Object paramObject, a parama)
  {
    Fragment localFragment = parama.a;
    View localView = localFragment.J;
    if ((!paramem.isEmpty()) && (paramObject != null) && (localView != null))
    {
      em localem = new em();
      paramcy.a(localem, localView);
      paramcy = parama.c;
      if (parama.b)
      {
        paramObject = localFragment.A();
        paramcy = paramcy.r;
      }
      else
      {
        paramObject = localFragment.z();
        paramcy = paramcy.s;
      }
      if (paramcy != null)
      {
        et.a(localem, paramcy);
        et.a(localem, paramem.values());
      }
      if (paramObject != null)
      {
        i = paramcy.size() - 1;
        while (i >= 0)
        {
          parama = (String)paramcy.get(i);
          paramObject = (View)localem.get(parama);
          if (paramObject == null)
          {
            paramObject = a(paramem, parama);
            if (paramObject != null) {
              paramem.remove(paramObject);
            }
          }
          else if (!parama.equals(fo.h(paramObject)))
          {
            parama = a(paramem, parama);
            if (parama != null) {
              paramem.put(parama, fo.h(paramObject));
            }
          }
          i -= 1;
        }
      }
      int i = paramem.size() - 1;
      while (i >= 0)
      {
        if (!localem.containsKey((String)paramem.c(i))) {
          paramem.d(i);
        }
        i -= 1;
      }
      return localem;
    }
    paramem.clear();
    return null;
  }
  
  static final class a
  {
    public Fragment a;
    public boolean b;
    public cm c;
    public Fragment d;
    public boolean e;
    public cm f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cw
 * JD-Core Version:    0.7.0.1
 */