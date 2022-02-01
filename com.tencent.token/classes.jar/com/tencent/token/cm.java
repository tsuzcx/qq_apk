package com.tencent.token;

import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.c;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public final class cm
  extends cv
  implements ct.g
{
  final ct a;
  public ArrayList<a> b = new ArrayList();
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public boolean i;
  boolean j = true;
  public String k;
  boolean l;
  public int m = -1;
  public int n;
  public CharSequence o;
  public int p;
  public CharSequence q;
  public ArrayList<String> r;
  public ArrayList<String> s;
  public boolean t = false;
  ArrayList<Runnable> u;
  
  public cm(ct paramct)
  {
    this.a = paramct;
  }
  
  private void b(int paramInt, Fragment paramFragment, String paramString)
  {
    Object localObject = paramFragment.getClass();
    int i1 = ((Class)localObject).getModifiers();
    if ((!((Class)localObject).isAnonymousClass()) && (Modifier.isPublic(i1)) && ((!((Class)localObject).isMemberClass()) || (Modifier.isStatic(i1))))
    {
      paramFragment.s = this.a;
      if (paramString != null)
      {
        if ((paramFragment.A != null) && (!paramString.equals(paramFragment.A)))
        {
          localObject = new StringBuilder("Can't change tag of fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(": was ");
          ((StringBuilder)localObject).append(paramFragment.A);
          ((StringBuilder)localObject).append(" now ");
          ((StringBuilder)localObject).append(paramString);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
        paramFragment.A = paramString;
      }
      if (paramInt != 0) {
        if (paramInt != -1)
        {
          if ((paramFragment.y != 0) && (paramFragment.y != paramInt))
          {
            paramString = new StringBuilder("Can't change container ID of fragment ");
            paramString.append(paramFragment);
            paramString.append(": was ");
            paramString.append(paramFragment.y);
            paramString.append(" now ");
            paramString.append(paramInt);
            throw new IllegalStateException(paramString.toString());
          }
          paramFragment.y = paramInt;
          paramFragment.z = paramInt;
        }
        else
        {
          localObject = new StringBuilder("Can't add fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(" with tag ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" to container view with no id");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      a(new a(1, paramFragment));
      return;
    }
    paramFragment = new StringBuilder("Fragment ");
    paramFragment.append(((Class)localObject).getCanonicalName());
    paramFragment.append(" must be a public static class to be  properly recreated from instance state.");
    throw new IllegalStateException(paramFragment.toString());
  }
  
  static boolean b(a parama)
  {
    parama = parama.b;
    return (parama != null) && (parama.l) && (parama.J != null) && (!parama.C) && (!parama.B) && (parama.E());
  }
  
  final Fragment a(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i2 = 0;
    for (Fragment localFragment1 = paramFragment; i2 < this.b.size(); localFragment1 = paramFragment)
    {
      a locala = (a)this.b.get(i2);
      int i1;
      switch (locala.a)
      {
      case 4: 
      case 5: 
      default: 
        paramFragment = localFragment1;
        i1 = i2;
        break;
      case 8: 
        this.b.add(i2, new a(9, localFragment1));
        i1 = i2 + 1;
        paramFragment = locala.b;
        break;
      case 3: 
      case 6: 
        paramArrayList.remove(locala.b);
        paramFragment = localFragment1;
        i1 = i2;
        if (locala.b == localFragment1)
        {
          this.b.add(i2, new a(9, locala.b));
          i1 = i2 + 1;
          paramFragment = null;
        }
        break;
      case 2: 
        Fragment localFragment2 = locala.b;
        int i6 = localFragment2.z;
        int i4 = paramArrayList.size() - 1;
        paramFragment = localFragment1;
        i1 = i2;
        int i3 = 0;
        i2 = i4;
        while (i2 >= 0)
        {
          Fragment localFragment3 = (Fragment)paramArrayList.get(i2);
          i4 = i1;
          localFragment1 = paramFragment;
          int i5 = i3;
          if (localFragment3.z == i6) {
            if (localFragment3 == localFragment2)
            {
              i5 = 1;
              i4 = i1;
              localFragment1 = paramFragment;
            }
            else
            {
              i4 = i1;
              localFragment1 = paramFragment;
              if (localFragment3 == paramFragment)
              {
                this.b.add(i1, new a(9, localFragment3));
                i4 = i1 + 1;
                localFragment1 = null;
              }
              paramFragment = new a(3, localFragment3);
              paramFragment.c = locala.c;
              paramFragment.e = locala.e;
              paramFragment.d = locala.d;
              paramFragment.f = locala.f;
              this.b.add(i4, paramFragment);
              paramArrayList.remove(localFragment3);
              i4 += 1;
              i5 = i3;
            }
          }
          i2 -= 1;
          i1 = i4;
          paramFragment = localFragment1;
          i3 = i5;
        }
        if (i3 != 0)
        {
          this.b.remove(i1);
          i1 -= 1;
        }
        else
        {
          locala.a = 1;
          paramArrayList.add(localFragment2);
        }
        break;
      case 1: 
      case 7: 
        paramArrayList.add(locala.b);
        i1 = i2;
        paramFragment = localFragment1;
      }
      i2 = i1 + 1;
    }
    return localFragment1;
  }
  
  public final cv a(int paramInt, Fragment paramFragment, String paramString)
  {
    b(paramInt, paramFragment, paramString);
    return this;
  }
  
  public final cv a(Fragment paramFragment)
  {
    a(new a(6, paramFragment));
    return this;
  }
  
  public final cv a(Fragment paramFragment, String paramString)
  {
    b(0, paramFragment, paramString);
    return this;
  }
  
  public final void a()
  {
    ArrayList localArrayList = this.u;
    if (localArrayList != null)
    {
      int i1 = 0;
      int i2 = localArrayList.size();
      while (i1 < i2)
      {
        ((Runnable)this.u.get(i1)).run();
        i1 += 1;
      }
      this.u = null;
    }
  }
  
  public final void a(int paramInt)
  {
    if (!this.i) {
      return;
    }
    Object localObject1;
    if (ct.a)
    {
      localObject1 = new StringBuilder("Bump nesting in ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(" by ");
      ((StringBuilder)localObject1).append(paramInt);
    }
    int i2 = this.b.size();
    int i1 = 0;
    while (i1 < i2)
    {
      localObject1 = (a)this.b.get(i1);
      if (((a)localObject1).b != null)
      {
        Object localObject2 = ((a)localObject1).b;
        ((Fragment)localObject2).r += paramInt;
        if (ct.a)
        {
          localObject2 = new StringBuilder("Bump nesting of ");
          ((StringBuilder)localObject2).append(((a)localObject1).b);
          ((StringBuilder)localObject2).append(" to ");
          ((StringBuilder)localObject2).append(((a)localObject1).b.r);
        }
      }
      i1 += 1;
    }
  }
  
  final void a(Fragment.c paramc)
  {
    int i1 = 0;
    while (i1 < this.b.size())
    {
      a locala = (a)this.b.get(i1);
      if (b(locala)) {
        locala.b.a(paramc);
      }
      i1 += 1;
    }
  }
  
  public final void a(a parama)
  {
    this.b.add(parama);
    parama.c = this.c;
    parama.d = this.d;
    parama.e = this.e;
    parama.f = this.f;
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.k);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.m);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.l);
      if (this.g != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.g));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.h));
      }
      if ((this.c != 0) || (this.d != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.c));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.d));
      }
      if ((this.e != 0) || (this.f != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.e));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.f));
      }
      if ((this.n != 0) || (this.o != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.n));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.o);
      }
      if ((this.p != 0) || (this.q != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.p));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.q);
      }
    }
    if (!this.b.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("    ");
      int i2 = this.b.size();
      int i1 = 0;
      while (i1 < i2)
      {
        a locala = (a)this.b.get(i1);
        switch (locala.a)
        {
        default: 
          localObject = new StringBuilder("cmd=");
          ((StringBuilder)localObject).append(locala.a);
          localObject = ((StringBuilder)localObject).toString();
          break;
        case 9: 
          localObject = "UNSET_PRIMARY_NAV";
          break;
        case 8: 
          localObject = "SET_PRIMARY_NAV";
          break;
        case 7: 
          localObject = "ATTACH";
          break;
        case 6: 
          localObject = "DETACH";
          break;
        case 5: 
          localObject = "SHOW";
          break;
        case 4: 
          localObject = "HIDE";
          break;
        case 3: 
          localObject = "REMOVE";
          break;
        case 2: 
          localObject = "REPLACE";
          break;
        case 1: 
          localObject = "ADD";
          break;
        case 0: 
          localObject = "NULL";
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(i1);
        paramPrintWriter.print(": ");
        paramPrintWriter.print((String)localObject);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(locala.b);
        if (paramBoolean)
        {
          if ((locala.c != 0) || (locala.d != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(locala.c));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(locala.d));
          }
          if ((locala.e != 0) || (locala.f != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(locala.e));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(locala.f));
          }
        }
        i1 += 1;
      }
    }
  }
  
  final void a(boolean paramBoolean)
  {
    int i1 = this.b.size() - 1;
    Object localObject1;
    while (i1 >= 0)
    {
      localObject1 = (a)this.b.get(i1);
      Object localObject2 = ((a)localObject1).b;
      if (localObject2 != null) {
        ((Fragment)localObject2).a(ct.b(this.g), this.h);
      }
      int i2 = ((a)localObject1).a;
      if (i2 != 1)
      {
        switch (i2)
        {
        default: 
          localObject2 = new StringBuilder("Unknown cmd: ");
          ((StringBuilder)localObject2).append(((a)localObject1).a);
          throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
        case 9: 
          this.a.h((Fragment)localObject2);
          break;
        case 8: 
          this.a.h(null);
          break;
        case 7: 
          ((Fragment)localObject2).a(((a)localObject1).f);
          this.a.f((Fragment)localObject2);
          break;
        case 6: 
          ((Fragment)localObject2).a(((a)localObject1).e);
          this.a.g((Fragment)localObject2);
          break;
        case 5: 
          ((Fragment)localObject2).a(((a)localObject1).f);
          ct.d((Fragment)localObject2);
          break;
        case 4: 
          ((Fragment)localObject2).a(((a)localObject1).e);
          ct.e((Fragment)localObject2);
          break;
        case 3: 
          ((Fragment)localObject2).a(((a)localObject1).e);
          this.a.a((Fragment)localObject2, false);
          break;
        }
      }
      else
      {
        ((Fragment)localObject2).a(((a)localObject1).f);
        this.a.c((Fragment)localObject2);
      }
      if ((!this.t) && (((a)localObject1).a != 3) && (localObject2 != null)) {
        this.a.a((Fragment)localObject2);
      }
      i1 -= 1;
    }
    if ((!this.t) && (paramBoolean))
    {
      localObject1 = this.a;
      ((ct)localObject1).a(((ct)localObject1).l, true);
    }
  }
  
  final boolean a(ArrayList<cm> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i6 = this.b.size();
    int i2 = 0;
    int i4;
    for (int i3 = -1; i2 < i6; i3 = i4)
    {
      Object localObject = (a)this.b.get(i2);
      int i1;
      if (((a)localObject).b != null) {
        i1 = ((a)localObject).b.z;
      } else {
        i1 = 0;
      }
      i4 = i3;
      if (i1 != 0)
      {
        i4 = i3;
        if (i1 != i3)
        {
          i3 = paramInt1;
          while (i3 < paramInt2)
          {
            localObject = (cm)paramArrayList.get(i3);
            int i7 = ((cm)localObject).b.size();
            i4 = 0;
            while (i4 < i7)
            {
              a locala = (a)((cm)localObject).b.get(i4);
              int i5;
              if (locala.b != null) {
                i5 = locala.b.z;
              } else {
                i5 = 0;
              }
              if (i5 == i1) {
                return true;
              }
              i4 += 1;
            }
            i3 += 1;
          }
          i4 = i1;
        }
      }
      i2 += 1;
    }
    return false;
  }
  
  public final boolean a(ArrayList<cm> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (ct.a) {
      new StringBuilder("Run: ").append(this);
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.FALSE);
    if (this.i)
    {
      paramArrayList = this.a;
      if (paramArrayList.g == null) {
        paramArrayList.g = new ArrayList();
      }
      paramArrayList.g.add(this);
    }
    return true;
  }
  
  public final int b()
  {
    if (!this.l)
    {
      if (ct.a)
      {
        new StringBuilder("Commit: ").append(this);
        localObject1 = new PrintWriter(new eq("FragmentManager"));
        a("  ", (PrintWriter)localObject1);
        ((PrintWriter)localObject1).close();
      }
      this.l = true;
      if (this.i) {
        this.m = this.a.a(this);
      } else {
        this.m = -1;
      }
      Object localObject1 = this.a;
      ((ct)localObject1).f();
      try
      {
        if ((!((ct)localObject1).u) && (((ct)localObject1).m != null))
        {
          if (((ct)localObject1).b == null) {
            ((ct)localObject1).b = new ArrayList();
          }
          ((ct)localObject1).b.add(this);
          ((ct)localObject1).g();
          return this.m;
        }
        throw new IllegalStateException("Activity has been destroyed");
      }
      finally {}
    }
    throw new IllegalStateException("commit already called");
  }
  
  final Fragment b(ArrayList<Fragment> paramArrayList, Fragment paramFragment)
  {
    int i1 = 0;
    while (i1 < this.b.size())
    {
      a locala = (a)this.b.get(i1);
      int i2 = locala.a;
      if (i2 != 1)
      {
        if (i2 != 3) {}
        switch (i2)
        {
        default: 
          break;
        case 9: 
          paramFragment = locala.b;
          break;
        case 8: 
          paramFragment = null;
          break;
        case 6: 
          paramArrayList.add(locala.b);
          break;
        }
      }
      else
      {
        paramArrayList.remove(locala.b);
      }
      i1 += 1;
    }
    return paramFragment;
  }
  
  public final cv b(Fragment paramFragment)
  {
    a(new a(7, paramFragment));
    return this;
  }
  
  final boolean b(int paramInt)
  {
    int i3 = this.b.size();
    int i1 = 0;
    while (i1 < i3)
    {
      a locala = (a)this.b.get(i1);
      int i2;
      if (locala.b != null) {
        i2 = locala.b.z;
      } else {
        i2 = 0;
      }
      if ((i2 != 0) && (i2 == paramInt)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  final void c()
  {
    int i2 = this.b.size();
    int i1 = 0;
    Object localObject1;
    while (i1 < i2)
    {
      localObject1 = (a)this.b.get(i1);
      Object localObject2 = ((a)localObject1).b;
      if (localObject2 != null) {
        ((Fragment)localObject2).a(this.g, this.h);
      }
      int i3 = ((a)localObject1).a;
      if (i3 != 1)
      {
        switch (i3)
        {
        default: 
          localObject2 = new StringBuilder("Unknown cmd: ");
          ((StringBuilder)localObject2).append(((a)localObject1).a);
          throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
        case 9: 
          this.a.h(null);
          break;
        case 8: 
          this.a.h((Fragment)localObject2);
          break;
        case 7: 
          ((Fragment)localObject2).a(((a)localObject1).c);
          this.a.g((Fragment)localObject2);
          break;
        case 6: 
          ((Fragment)localObject2).a(((a)localObject1).d);
          this.a.f((Fragment)localObject2);
          break;
        case 5: 
          ((Fragment)localObject2).a(((a)localObject1).c);
          ct.e((Fragment)localObject2);
          break;
        case 4: 
          ((Fragment)localObject2).a(((a)localObject1).d);
          ct.d((Fragment)localObject2);
          break;
        case 3: 
          ((Fragment)localObject2).a(((a)localObject1).d);
          this.a.c((Fragment)localObject2);
          break;
        }
      }
      else
      {
        ((Fragment)localObject2).a(((a)localObject1).c);
        this.a.a((Fragment)localObject2, false);
      }
      if ((!this.t) && (((a)localObject1).a != 1) && (localObject2 != null)) {
        this.a.a((Fragment)localObject2);
      }
      i1 += 1;
    }
    if (!this.t)
    {
      localObject1 = this.a;
      ((ct)localObject1).a(((ct)localObject1).l, true);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.m >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.m);
    }
    if (this.k != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.k);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    public int a;
    public Fragment b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    public a() {}
    
    a(int paramInt, Fragment paramFragment)
    {
      this.a = paramInt;
      this.b = paramFragment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cm
 * JD-Core Version:    0.7.0.1
 */