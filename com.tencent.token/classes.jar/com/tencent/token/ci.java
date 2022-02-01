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

final class ci
{
  private static final int[] a = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  private static final ck b;
  private static final ck c = a();
  
  static
  {
    cj localcj;
    if (Build.VERSION.SDK_INT >= 21) {
      localcj = new cj();
    } else {
      localcj = null;
    }
    b = localcj;
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
  
  private static ck a()
  {
    try
    {
      ck localck = (ck)Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localck;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  private static ck a(Fragment paramFragment1, Fragment paramFragment2)
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
  
  private static dy<String, String> a(int paramInt1, ArrayList<by> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    dy localdy = new dy();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (by)paramArrayList.get(paramInt3);
      if (((by)localObject).b(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((by)localObject).r != null)
        {
          int j = ((by)localObject).r.size();
          ArrayList localArrayList2;
          ArrayList localArrayList1;
          if (bool)
          {
            localArrayList2 = ((by)localObject).r;
            localArrayList1 = ((by)localObject).s;
          }
          else
          {
            localArrayList1 = ((by)localObject).r;
            localArrayList2 = ((by)localObject).s;
          }
          int i = 0;
          while (i < j)
          {
            localObject = (String)localArrayList1.get(i);
            String str1 = (String)localArrayList2.get(i);
            String str2 = (String)localdy.remove(str1);
            if (str2 != null) {
              localdy.put(localObject, str2);
            } else {
              localdy.put(localObject, str1);
            }
            i += 1;
          }
        }
      }
      paramInt3 -= 1;
    }
    return localdy;
  }
  
  private static Object a(ck paramck, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (paramBoolean) {
        paramFragment1 = paramFragment2.m();
      } else {
        paramFragment1 = paramFragment1.l();
      }
      return paramck.c(paramck.b(paramFragment1));
    }
    return null;
  }
  
  private static Object a(ck paramck, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.k();
    } else {
      paramFragment = paramFragment.h();
    }
    return paramck.b(paramFragment);
  }
  
  private static Object a(ck paramck, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
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
      return paramck.a(paramObject2, paramObject1, paramObject3);
    }
    return paramck.b(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(dy<String, String> paramdy, String paramString)
  {
    int j = paramdy.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramdy.c(i))) {
        return (String)paramdy.b(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static void a(by paramby, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    int j = paramby.b.size();
    int i = 0;
    while (i < j)
    {
      a(paramby, (by.a)paramby.b.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static void a(by paramby, by.a parama, SparseArray<a> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
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
      parama.c = paramby;
    }
    if ((!paramBoolean2) && (k != 0))
    {
      if ((parama != null) && (parama.d == localFragment)) {
        parama.d = null;
      }
      localObject = paramby.a;
      if ((localFragment.b <= 0) && (((cf)localObject).l > 0) && (!paramby.t))
      {
        ((cf)localObject).b(localFragment);
        ((cf)localObject).a(localFragment, 1, 0, 0, false);
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
        ((a)localObject).f = paramby;
      }
    }
    if ((!paramBoolean2) && (j != 0) && (localObject != null) && (((a)localObject).a == localFragment)) {
      ((a)localObject).a = null;
    }
  }
  
  static void a(cf paramcf, ArrayList<by> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = paramcf;
    final boolean bool1 = paramBoolean;
    if (((cf)localObject1).l <= 0) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = paramInt1;
    Object localObject2;
    while (i < paramInt2)
    {
      localObject2 = (by)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        b((by)localObject2, localSparseArray, bool1);
      } else {
        a((by)localObject2, localSparseArray, bool1);
      }
      i += 1;
    }
    if (localSparseArray.size() != 0)
    {
      final View localView = new View(((cf)localObject1).m.c);
      i = localSparseArray.size();
      int j = 0;
      for (;;)
      {
        localObject1 = paramcf;
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
          if (((cf)localObject1).n.a()) {
            localObject2 = (ViewGroup)((cf)localObject1).n.a(k);
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
              localObject11 = a((ck)localObject9, (Fragment)localObject7, bool1);
              localObject12 = b((ck)localObject9, (Fragment)localObject13, bool2);
              localFragment1 = locala.a;
              localFragment2 = locala.d;
              if (localFragment1 != null) {
                localFragment1.J.setVisibility(0);
              }
              if ((localFragment1 != null) && (localFragment2 != null))
              {
                bool2 = locala.b;
                if (((dy)localObject4).isEmpty()) {
                  localObject1 = null;
                } else {
                  localObject1 = a((ck)localObject9, localFragment1, localFragment2, bool2);
                }
                localObject3 = b((ck)localObject9, (dy)localObject4, localObject1, locala);
                localObject14 = c((ck)localObject9, (dy)localObject4, localObject1, locala);
                if (((dy)localObject4).isEmpty())
                {
                  if (localObject3 != null) {
                    ((dy)localObject3).clear();
                  }
                  if (localObject14 != null) {
                    ((dy)localObject14).clear();
                  }
                  localObject1 = null;
                }
                else
                {
                  a((ArrayList)localObject10, (dy)localObject3, ((dy)localObject4).keySet());
                  a((ArrayList)localObject8, (dy)localObject14, ((dy)localObject4).values());
                }
                if ((localObject11 == null) && (localObject12 == null) && (localObject1 == null))
                {
                  localObject1 = null;
                }
                else
                {
                  b(localFragment1, localFragment2, bool2, (dy)localObject3);
                  if (localObject1 != null)
                  {
                    ((ArrayList)localObject8).add(localView);
                    ((ck)localObject9).a(localObject1, localView, (ArrayList)localObject10);
                    a((ck)localObject9, localObject1, localObject12, (dy)localObject3, locala.e, locala.f);
                    localObject3 = new Rect();
                    localObject5 = b((dy)localObject14, locala, localObject11, bool2);
                    if (localObject5 != null) {
                      ((ck)localObject9).a(localObject11, (Rect)localObject3);
                    }
                    localObject6 = localObject3;
                  }
                  else
                  {
                    localObject3 = null;
                    localObject6 = localObject3;
                    localObject5 = localObject3;
                  }
                  cq.a((View)localObject2, new Runnable()
                  {
                    public final void run()
                    {
                      ci.a(this.a, localFragment2, bool2, this.d);
                      View localView = this.e;
                      if (localView != null) {
                        ck.a(localView, this.g);
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
              localObject3 = b((ck)localObject9, localObject12, (Fragment)localObject13, (ArrayList)localObject10, localView);
              localObject5 = b((ck)localObject9, localObject11, (Fragment)localObject7, (ArrayList)localObject8, localView);
              a((ArrayList)localObject5, 4);
              localObject6 = a((ck)localObject9, localObject11, localObject12, localObject1, (Fragment)localObject7, bool1);
              if (localObject6 != null)
              {
                if ((localObject13 != null) && (localObject12 != null) && (((Fragment)localObject13).l) && (((Fragment)localObject13).B) && (((Fragment)localObject13).Q))
                {
                  ((Fragment)localObject13).c(true);
                  ((ck)localObject9).b(localObject12, ((Fragment)localObject13).J, (ArrayList)localObject3);
                  cq.a(((Fragment)localObject13).I, new Runnable()
                  {
                    public final void run()
                    {
                      ci.a(this.a);
                    }
                  });
                }
                localObject7 = ck.a((ArrayList)localObject8);
                ((ck)localObject9).a(localObject6, localObject11, (ArrayList)localObject5, localObject12, (ArrayList)localObject3, localObject1, (ArrayList)localObject8);
                ((ck)localObject9).a((ViewGroup)localObject2, localObject6);
                ((ck)localObject9).a((View)localObject2, (ArrayList)localObject10, (ArrayList)localObject8, (ArrayList)localObject7, (Map)localObject4);
                a((ArrayList)localObject5, 0);
                ((ck)localObject9).a(localObject1, (ArrayList)localObject10, (ArrayList)localObject8);
              }
            }
            else {}
          }
        }
        else
        {
          label846:
          localObject3 = localObject4;
          if (((cf)localObject1).n.a()) {
            localObject5 = (ViewGroup)((cf)localObject1).n.a(k);
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
              localObject11 = a((ck)localObject13, (Fragment)localObject12, bool1);
              localObject10 = b((ck)localObject13, localFragment1, bool2);
              localObject1 = new ArrayList();
              localObject2 = new ArrayList();
              localFragment2 = locala.a;
              localObject14 = locala.d;
              if ((localFragment2 != null) && (localObject14 != null))
              {
                bool1 = locala.b;
                if (((dy)localObject3).isEmpty()) {
                  localObject3 = null;
                } else {
                  localObject3 = a((ck)localObject13, localFragment2, (Fragment)localObject14, bool1);
                }
                localObject7 = b((ck)localObject13, (dy)localObject4, localObject3, locala);
                if (((dy)localObject4).isEmpty()) {
                  localObject3 = null;
                } else {
                  ((ArrayList)localObject1).addAll(((dy)localObject7).values());
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
                  b(localFragment2, (Fragment)localObject14, bool1, (dy)localObject7);
                  if (localObject3 != null)
                  {
                    localObject6 = new Rect();
                    ((ck)localObject13).a(localObject3, localView, (ArrayList)localObject1);
                    a((ck)localObject13, localObject3, localObject10, (dy)localObject7, locala.e, locala.f);
                    localObject7 = localObject6;
                    if (localObject11 != null)
                    {
                      ((ck)localObject13).a(localObject11, (Rect)localObject6);
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
                  cq.a((View)localObject5, new Runnable()
                  {
                    public final void run()
                    {
                      Object localObject1 = ci.a(this.a, this.b, localObject3, locala);
                      if (localObject1 != null)
                      {
                        this.e.addAll(((dy)localObject1).values());
                        this.e.add(localView);
                      }
                      ci.a(localFragment2, this.h, bool1, (dy)localObject1);
                      Object localObject2 = localObject3;
                      if (localObject2 != null)
                      {
                        this.a.a(localObject2, this.j, this.e);
                        localObject1 = ci.a((dy)localObject1, locala, localObject11, bool1);
                        if (localObject1 != null) {
                          ck.a((View)localObject1, this.l);
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
                localObject4 = b((ck)localObject13, localObject6, localFragment1, (ArrayList)localObject4, localView);
                if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
                  localObject6 = null;
                }
                ((ck)localObject13).b(localObject11, localView);
                localObject7 = a((ck)localObject13, localObject11, localObject6, localObject1, (Fragment)localObject12, locala.b);
                i = m;
                j = k;
                if (localObject7 != null)
                {
                  localObject8 = new ArrayList();
                  ((ck)localObject13).a(localObject7, localObject11, (ArrayList)localObject8, localObject6, (ArrayList)localObject4, localObject1, (ArrayList)localObject2);
                  cq.a((View)localObject5, new Runnable()
                  {
                    public final void run()
                    {
                      Object localObject = this.a;
                      if (localObject != null)
                      {
                        this.b.c(localObject, localView);
                        localObject = ci.a(this.b, this.a, this.d, this.e, localView);
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
                  cq.a((View)localObject5, new ck.2((ck)localObject13, (ArrayList)localObject2, (Map)localObject3));
                  ((ck)localObject13).a((ViewGroup)localObject5, localObject7);
                  cq.a((View)localObject5, new ck.3((ck)localObject13, (ArrayList)localObject2, (Map)localObject3));
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
  
  private static void a(ck paramck, Object paramObject1, Object paramObject2, dy<String, View> paramdy, boolean paramBoolean, by paramby)
  {
    if ((paramby.r != null) && (!paramby.r.isEmpty()))
    {
      if (paramBoolean) {
        paramby = (String)paramby.s.get(0);
      } else {
        paramby = (String)paramby.r.get(0);
      }
      paramdy = (View)paramdy.get(paramby);
      paramck.a(paramObject1, paramdy);
      if (paramObject2 != null) {
        paramck.a(paramObject2, paramdy);
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
  
  private static void a(ArrayList<View> paramArrayList, dy<String, View> paramdy, Collection<String> paramCollection)
  {
    int i = paramdy.size() - 1;
    while (i >= 0)
    {
      View localView = (View)paramdy.c(i);
      if (paramCollection.contains(fa.h(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static boolean a(ck paramck, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramck.a(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static View b(dy<String, View> paramdy, a parama, Object paramObject, boolean paramBoolean)
  {
    parama = parama.c;
    if ((paramObject != null) && (paramdy != null) && (parama.r != null) && (!parama.r.isEmpty()))
    {
      if (paramBoolean) {
        parama = (String)parama.r.get(0);
      } else {
        parama = (String)parama.s.get(0);
      }
      return (View)paramdy.get(parama);
    }
    return null;
  }
  
  private static dy<String, View> b(ck paramck, dy<String, String> paramdy, Object paramObject, a parama)
  {
    if ((!paramdy.isEmpty()) && (paramObject != null))
    {
      paramObject = parama.d;
      dy localdy = new dy();
      paramck.a(localdy, paramObject.J);
      paramck = parama.f;
      if (parama.e)
      {
        paramObject = paramObject.z();
        paramck = paramck.s;
      }
      else
      {
        paramObject = paramObject.A();
        paramck = paramck.r;
      }
      ef.a(localdy, paramck);
      if (paramObject != null)
      {
        int i = paramck.size() - 1;
        while (i >= 0)
        {
          parama = (String)paramck.get(i);
          paramObject = (View)localdy.get(parama);
          if (paramObject == null)
          {
            paramdy.remove(parama);
          }
          else if (!parama.equals(fa.h(paramObject)))
          {
            parama = (String)paramdy.remove(parama);
            paramdy.put(fa.h(paramObject), parama);
          }
          i -= 1;
        }
      }
      ef.a(paramdy, localdy.keySet());
      return localdy;
    }
    paramdy.clear();
    return null;
  }
  
  private static Object b(ck paramck, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.i();
    } else {
      paramFragment = paramFragment.j();
    }
    return paramck.b(paramFragment);
  }
  
  private static ArrayList<View> b(ck paramck, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.J;
      if (paramFragment != null) {
        paramck.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      paramFragment = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramck.a(paramObject, localArrayList);
        return localArrayList;
      }
    }
    else
    {
      paramFragment = null;
    }
    return paramFragment;
  }
  
  private static void b(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, dy<String, View> paramdy)
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
      if (paramdy == null) {
        i = 0;
      } else {
        i = paramdy.size();
      }
      while (j < i)
      {
        paramFragment2.add(paramdy.b(j));
        paramFragment1.add(paramdy.c(j));
        j += 1;
      }
    }
  }
  
  private static void b(by paramby, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    if (!paramby.a.n.a()) {
      return;
    }
    int i = paramby.b.size() - 1;
    while (i >= 0)
    {
      a(paramby, (by.a)paramby.b.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
  }
  
  private static dy<String, View> c(ck paramck, dy<String, String> paramdy, Object paramObject, a parama)
  {
    Fragment localFragment = parama.a;
    View localView = localFragment.J;
    if ((!paramdy.isEmpty()) && (paramObject != null) && (localView != null))
    {
      dy localdy = new dy();
      paramck.a(localdy, localView);
      paramck = parama.c;
      if (parama.b)
      {
        paramObject = localFragment.A();
        paramck = paramck.r;
      }
      else
      {
        paramObject = localFragment.z();
        paramck = paramck.s;
      }
      if (paramck != null)
      {
        ef.a(localdy, paramck);
        ef.a(localdy, paramdy.values());
      }
      if (paramObject != null)
      {
        i = paramck.size() - 1;
        while (i >= 0)
        {
          parama = (String)paramck.get(i);
          paramObject = (View)localdy.get(parama);
          if (paramObject == null)
          {
            paramObject = a(paramdy, parama);
            if (paramObject != null) {
              paramdy.remove(paramObject);
            }
          }
          else if (!parama.equals(fa.h(paramObject)))
          {
            parama = a(paramdy, parama);
            if (parama != null) {
              paramdy.put(parama, fa.h(paramObject));
            }
          }
          i -= 1;
        }
      }
      int i = paramdy.size() - 1;
      while (i >= 0)
      {
        if (!localdy.containsKey((String)paramdy.c(i))) {
          paramdy.d(i);
        }
        i -= 1;
      }
      return localdy;
    }
    paramdy.clear();
    return null;
  }
  
  static final class a
  {
    public Fragment a;
    public boolean b;
    public by c;
    public Fragment d;
    public boolean e;
    public by f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ci
 * JD-Core Version:    0.7.0.1
 */