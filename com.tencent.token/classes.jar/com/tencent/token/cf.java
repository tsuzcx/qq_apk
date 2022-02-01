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

final class cf
{
  private static final int[] a = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  private static final ch b;
  private static final ch c = a();
  
  static
  {
    cg localcg;
    if (Build.VERSION.SDK_INT >= 21) {
      localcg = new cg();
    } else {
      localcg = null;
    }
    b = localcg;
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
  
  private static ch a()
  {
    try
    {
      ch localch = (ch)Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localch;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  private static ch a(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.f();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.e();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.i();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.d();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.g();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.h();
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
  
  private static dv<String, String> a(int paramInt1, ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt2, int paramInt3)
  {
    dv localdv = new dv();
    paramInt3 -= 1;
    while (paramInt3 >= paramInt2)
    {
      Object localObject = (bv)paramArrayList.get(paramInt3);
      if (((bv)localObject).b(paramInt1))
      {
        boolean bool = ((Boolean)paramArrayList1.get(paramInt3)).booleanValue();
        if (((bv)localObject).r != null)
        {
          int j = ((bv)localObject).r.size();
          ArrayList localArrayList2;
          ArrayList localArrayList1;
          if (bool)
          {
            localArrayList2 = ((bv)localObject).r;
            localArrayList1 = ((bv)localObject).s;
          }
          else
          {
            localArrayList1 = ((bv)localObject).r;
            localArrayList2 = ((bv)localObject).s;
          }
          int i = 0;
          while (i < j)
          {
            localObject = (String)localArrayList1.get(i);
            String str1 = (String)localArrayList2.get(i);
            String str2 = (String)localdv.remove(str1);
            if (str2 != null) {
              localdv.put(localObject, str2);
            } else {
              localdv.put(localObject, str1);
            }
            i += 1;
          }
        }
      }
      paramInt3 -= 1;
    }
    return localdv;
  }
  
  private static Object a(ch paramch, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (paramBoolean) {
        paramFragment1 = paramFragment2.i();
      } else {
        paramFragment1 = paramFragment1.h();
      }
      return paramch.c(paramch.b(paramFragment1));
    }
    return null;
  }
  
  private static Object a(ch paramch, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.g();
    } else {
      paramFragment = paramFragment.d();
    }
    return paramch.b(paramFragment);
  }
  
  private static Object a(ch paramch, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramFragment != null))
    {
      if (paramBoolean) {
        paramBoolean = paramFragment.k();
      } else {
        paramBoolean = paramFragment.j();
      }
    }
    else {
      paramBoolean = true;
    }
    if (paramBoolean) {
      return paramch.a(paramObject2, paramObject1, paramObject3);
    }
    return paramch.b(paramObject2, paramObject1, paramObject3);
  }
  
  private static String a(dv<String, String> paramdv, String paramString)
  {
    int j = paramdv.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramdv.c(i))) {
        return (String)paramdv.b(i);
      }
      i += 1;
    }
    return null;
  }
  
  private static void a(bv parambv, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    int j = parambv.b.size();
    int i = 0;
    while (i < j)
    {
      a(parambv, (bv.a)parambv.b.get(i), paramSparseArray, false, paramBoolean);
      i += 1;
    }
  }
  
  private static void a(bv parambv, bv.a parama, SparseArray<a> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
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
      parama.c = parambv;
    }
    if ((!paramBoolean2) && (k != 0))
    {
      if ((parama != null) && (parama.d == localFragment)) {
        parama.d = null;
      }
      localObject = parambv.a;
      if ((localFragment.b <= 0) && (((cc)localObject).l > 0) && (!parambv.t))
      {
        ((cc)localObject).b(localFragment);
        ((cc)localObject).a(localFragment, 1, 0, 0, false);
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
        ((a)localObject).f = parambv;
      }
    }
    if ((!paramBoolean2) && (j != 0) && (localObject != null) && (((a)localObject).a == localFragment)) {
      ((a)localObject).a = null;
    }
  }
  
  static void a(cc paramcc, ArrayList<bv> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject1 = paramcc;
    final boolean bool1 = paramBoolean;
    if (((cc)localObject1).l <= 0) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    int i = paramInt1;
    Object localObject2;
    while (i < paramInt2)
    {
      localObject2 = (bv)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue()) {
        b((bv)localObject2, localSparseArray, bool1);
      } else {
        a((bv)localObject2, localSparseArray, bool1);
      }
      i += 1;
    }
    if (localSparseArray.size() != 0)
    {
      final View localView = new View(((cc)localObject1).m.c);
      i = localSparseArray.size();
      int j = 0;
      for (;;)
      {
        localObject1 = paramcc;
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
          if (((cc)localObject1).n.a()) {
            localObject2 = (ViewGroup)((cc)localObject1).n.a(k);
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
              localObject11 = a((ch)localObject9, (Fragment)localObject7, bool1);
              localObject12 = b((ch)localObject9, (Fragment)localObject13, bool2);
              localFragment1 = locala.a;
              localFragment2 = locala.d;
              if (localFragment1 != null) {
                localFragment1.J.setVisibility(0);
              }
              if ((localFragment1 != null) && (localFragment2 != null))
              {
                bool2 = locala.b;
                if (((dv)localObject4).isEmpty()) {
                  localObject1 = null;
                } else {
                  localObject1 = a((ch)localObject9, localFragment1, localFragment2, bool2);
                }
                localObject3 = b((ch)localObject9, (dv)localObject4, localObject1, locala);
                localObject14 = c((ch)localObject9, (dv)localObject4, localObject1, locala);
                if (((dv)localObject4).isEmpty())
                {
                  if (localObject3 != null) {
                    ((dv)localObject3).clear();
                  }
                  if (localObject14 != null) {
                    ((dv)localObject14).clear();
                  }
                  localObject1 = null;
                }
                else
                {
                  a((ArrayList)localObject10, (dv)localObject3, ((dv)localObject4).keySet());
                  a((ArrayList)localObject8, (dv)localObject14, ((dv)localObject4).values());
                }
                if ((localObject11 == null) && (localObject12 == null) && (localObject1 == null))
                {
                  localObject1 = null;
                }
                else
                {
                  b(localFragment1, localFragment2, bool2, (dv)localObject3);
                  if (localObject1 != null)
                  {
                    ((ArrayList)localObject8).add(localView);
                    ((ch)localObject9).a(localObject1, localView, (ArrayList)localObject10);
                    a((ch)localObject9, localObject1, localObject12, (dv)localObject3, locala.e, locala.f);
                    localObject3 = new Rect();
                    localObject5 = b((dv)localObject14, locala, localObject11, bool2);
                    if (localObject5 != null) {
                      ((ch)localObject9).a(localObject11, (Rect)localObject3);
                    }
                    localObject6 = localObject3;
                  }
                  else
                  {
                    localObject3 = null;
                    localObject6 = localObject3;
                    localObject5 = localObject3;
                  }
                  cn.a((View)localObject2, new Runnable()
                  {
                    public final void run()
                    {
                      cf.a(this.a, localFragment2, bool2, this.d);
                      View localView = this.e;
                      if (localView != null) {
                        ch.a(localView, this.g);
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
              localObject3 = b((ch)localObject9, localObject12, (Fragment)localObject13, (ArrayList)localObject10, localView);
              localObject5 = b((ch)localObject9, localObject11, (Fragment)localObject7, (ArrayList)localObject8, localView);
              a((ArrayList)localObject5, 4);
              localObject6 = a((ch)localObject9, localObject11, localObject12, localObject1, (Fragment)localObject7, bool1);
              if (localObject6 != null)
              {
                if ((localObject13 != null) && (localObject12 != null) && (((Fragment)localObject13).l) && (((Fragment)localObject13).B) && (((Fragment)localObject13).Q))
                {
                  ((Fragment)localObject13).c(true);
                  ((ch)localObject9).b(localObject12, ((Fragment)localObject13).J, (ArrayList)localObject3);
                  cn.a(((Fragment)localObject13).I, new Runnable()
                  {
                    public final void run()
                    {
                      cf.a(this.a);
                    }
                  });
                }
                localObject7 = ch.a((ArrayList)localObject8);
                ((ch)localObject9).a(localObject6, localObject11, (ArrayList)localObject5, localObject12, (ArrayList)localObject3, localObject1, (ArrayList)localObject8);
                ((ch)localObject9).a((ViewGroup)localObject2, localObject6);
                ((ch)localObject9).a((View)localObject2, (ArrayList)localObject10, (ArrayList)localObject8, (ArrayList)localObject7, (Map)localObject4);
                a((ArrayList)localObject5, 0);
                ((ch)localObject9).a(localObject1, (ArrayList)localObject10, (ArrayList)localObject8);
              }
            }
            else {}
          }
        }
        else
        {
          label846:
          localObject3 = localObject4;
          if (((cc)localObject1).n.a()) {
            localObject5 = (ViewGroup)((cc)localObject1).n.a(k);
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
              localObject11 = a((ch)localObject13, (Fragment)localObject12, bool1);
              localObject10 = b((ch)localObject13, localFragment1, bool2);
              localObject1 = new ArrayList();
              localObject2 = new ArrayList();
              localFragment2 = locala.a;
              localObject14 = locala.d;
              if ((localFragment2 != null) && (localObject14 != null))
              {
                bool1 = locala.b;
                if (((dv)localObject3).isEmpty()) {
                  localObject3 = null;
                } else {
                  localObject3 = a((ch)localObject13, localFragment2, (Fragment)localObject14, bool1);
                }
                localObject7 = b((ch)localObject13, (dv)localObject4, localObject3, locala);
                if (((dv)localObject4).isEmpty()) {
                  localObject3 = null;
                } else {
                  ((ArrayList)localObject1).addAll(((dv)localObject7).values());
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
                  b(localFragment2, (Fragment)localObject14, bool1, (dv)localObject7);
                  if (localObject3 != null)
                  {
                    localObject6 = new Rect();
                    ((ch)localObject13).a(localObject3, localView, (ArrayList)localObject1);
                    a((ch)localObject13, localObject3, localObject10, (dv)localObject7, locala.e, locala.f);
                    localObject7 = localObject6;
                    if (localObject11 != null)
                    {
                      ((ch)localObject13).a(localObject11, (Rect)localObject6);
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
                  cn.a((View)localObject5, new Runnable()
                  {
                    public final void run()
                    {
                      Object localObject1 = cf.a(this.a, this.b, localObject3, locala);
                      if (localObject1 != null)
                      {
                        this.e.addAll(((dv)localObject1).values());
                        this.e.add(localView);
                      }
                      cf.a(localFragment2, this.h, bool1, (dv)localObject1);
                      Object localObject2 = localObject3;
                      if (localObject2 != null)
                      {
                        this.a.a(localObject2, this.j, this.e);
                        localObject1 = cf.a((dv)localObject1, locala, localObject11, bool1);
                        if (localObject1 != null) {
                          ch.a((View)localObject1, this.l);
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
                localObject4 = b((ch)localObject13, localObject6, localFragment1, (ArrayList)localObject4, localView);
                if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
                  localObject6 = null;
                }
                ((ch)localObject13).b(localObject11, localView);
                localObject7 = a((ch)localObject13, localObject11, localObject6, localObject1, (Fragment)localObject12, locala.b);
                i = m;
                j = k;
                if (localObject7 != null)
                {
                  localObject8 = new ArrayList();
                  ((ch)localObject13).a(localObject7, localObject11, (ArrayList)localObject8, localObject6, (ArrayList)localObject4, localObject1, (ArrayList)localObject2);
                  cn.a((View)localObject5, new Runnable()
                  {
                    public final void run()
                    {
                      Object localObject = this.a;
                      if (localObject != null)
                      {
                        this.b.c(localObject, localView);
                        localObject = cf.a(this.b, this.a, this.d, this.e, localView);
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
                  cn.a((View)localObject5, new ch.2((ch)localObject13, (ArrayList)localObject2, (Map)localObject3));
                  ((ch)localObject13).a((ViewGroup)localObject5, localObject7);
                  cn.a((View)localObject5, new ch.3((ch)localObject13, (ArrayList)localObject2, (Map)localObject3));
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
  
  private static void a(ch paramch, Object paramObject1, Object paramObject2, dv<String, View> paramdv, boolean paramBoolean, bv parambv)
  {
    if ((parambv.r != null) && (!parambv.r.isEmpty()))
    {
      if (paramBoolean) {
        parambv = (String)parambv.s.get(0);
      } else {
        parambv = (String)parambv.r.get(0);
      }
      paramdv = (View)paramdv.get(parambv);
      paramch.a(paramObject1, paramdv);
      if (paramObject2 != null) {
        paramch.a(paramObject2, paramdv);
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
  
  private static void a(ArrayList<View> paramArrayList, dv<String, View> paramdv, Collection<String> paramCollection)
  {
    int i = paramdv.size() - 1;
    while (i >= 0)
    {
      View localView = (View)paramdv.c(i);
      if (paramCollection.contains(ex.h(localView))) {
        paramArrayList.add(localView);
      }
      i -= 1;
    }
  }
  
  private static boolean a(ch paramch, List<Object> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      if (!paramch.a(paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static View b(dv<String, View> paramdv, a parama, Object paramObject, boolean paramBoolean)
  {
    parama = parama.c;
    if ((paramObject != null) && (paramdv != null) && (parama.r != null) && (!parama.r.isEmpty()))
    {
      if (paramBoolean) {
        parama = (String)parama.r.get(0);
      } else {
        parama = (String)parama.s.get(0);
      }
      return (View)paramdv.get(parama);
    }
    return null;
  }
  
  private static dv<String, View> b(ch paramch, dv<String, String> paramdv, Object paramObject, a parama)
  {
    if ((!paramdv.isEmpty()) && (paramObject != null))
    {
      paramObject = parama.d;
      dv localdv = new dv();
      paramch.a(localdv, paramObject.J);
      paramch = parama.f;
      if (parama.e)
      {
        paramObject = paramObject.v();
        paramch = paramch.s;
      }
      else
      {
        paramObject = paramObject.w();
        paramch = paramch.r;
      }
      ec.a(localdv, paramch);
      if (paramObject != null)
      {
        int i = paramch.size() - 1;
        while (i >= 0)
        {
          parama = (String)paramch.get(i);
          paramObject = (View)localdv.get(parama);
          if (paramObject == null)
          {
            paramdv.remove(parama);
          }
          else if (!parama.equals(ex.h(paramObject)))
          {
            parama = (String)paramdv.remove(parama);
            paramdv.put(ex.h(paramObject), parama);
          }
          i -= 1;
        }
      }
      ec.a(paramdv, localdv.keySet());
      return localdv;
    }
    paramdv.clear();
    return null;
  }
  
  private static Object b(ch paramch, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.e();
    } else {
      paramFragment = paramFragment.f();
    }
    return paramch.b(paramFragment);
  }
  
  private static ArrayList<View> b(ch paramch, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.J;
      if (paramFragment != null) {
        paramch.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      paramFragment = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramch.a(paramObject, localArrayList);
        return localArrayList;
      }
    }
    else
    {
      paramFragment = null;
    }
    return paramFragment;
  }
  
  private static void b(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, dv<String, View> paramdv)
  {
    if (paramBoolean) {
      paramFragment1 = paramFragment2.v();
    } else {
      paramFragment1 = paramFragment1.v();
    }
    if (paramFragment1 != null)
    {
      paramFragment1 = new ArrayList();
      paramFragment2 = new ArrayList();
      int j = 0;
      int i;
      if (paramdv == null) {
        i = 0;
      } else {
        i = paramdv.size();
      }
      while (j < i)
      {
        paramFragment2.add(paramdv.b(j));
        paramFragment1.add(paramdv.c(j));
        j += 1;
      }
    }
  }
  
  private static void b(bv parambv, SparseArray<a> paramSparseArray, boolean paramBoolean)
  {
    if (!parambv.a.n.a()) {
      return;
    }
    int i = parambv.b.size() - 1;
    while (i >= 0)
    {
      a(parambv, (bv.a)parambv.b.get(i), paramSparseArray, true, paramBoolean);
      i -= 1;
    }
  }
  
  private static dv<String, View> c(ch paramch, dv<String, String> paramdv, Object paramObject, a parama)
  {
    Fragment localFragment = parama.a;
    View localView = localFragment.J;
    if ((!paramdv.isEmpty()) && (paramObject != null) && (localView != null))
    {
      dv localdv = new dv();
      paramch.a(localdv, localView);
      paramch = parama.c;
      if (parama.b)
      {
        paramObject = localFragment.w();
        paramch = paramch.r;
      }
      else
      {
        paramObject = localFragment.v();
        paramch = paramch.s;
      }
      if (paramch != null)
      {
        ec.a(localdv, paramch);
        ec.a(localdv, paramdv.values());
      }
      if (paramObject != null)
      {
        i = paramch.size() - 1;
        while (i >= 0)
        {
          parama = (String)paramch.get(i);
          paramObject = (View)localdv.get(parama);
          if (paramObject == null)
          {
            paramObject = a(paramdv, parama);
            if (paramObject != null) {
              paramdv.remove(paramObject);
            }
          }
          else if (!parama.equals(ex.h(paramObject)))
          {
            parama = a(paramdv, parama);
            if (parama != null) {
              paramdv.put(parama, ex.h(paramObject));
            }
          }
          i -= 1;
        }
      }
      int i = paramdv.size() - 1;
      while (i >= 0)
      {
        if (!localdv.containsKey((String)paramdv.c(i))) {
          paramdv.d(i);
        }
        i -= 1;
      }
      return localdv;
    }
    paramdv.clear();
    return null;
  }
  
  static final class a
  {
    public Fragment a;
    public boolean b;
    public bv c;
    public Fragment d;
    public boolean e;
    public bv f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cf
 * JD-Core Version:    0.7.0.1
 */