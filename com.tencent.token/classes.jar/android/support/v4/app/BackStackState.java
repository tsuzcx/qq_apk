package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.token.bv;
import com.tencent.token.bv.a;
import com.tencent.token.cc;
import java.util.ArrayList;

public final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator() {};
  final int[] a;
  final int b;
  final int c;
  final String d;
  final int e;
  final int f;
  final CharSequence g;
  final int h;
  final CharSequence i;
  final ArrayList<String> j;
  final ArrayList<String> k;
  final boolean l;
  
  public BackStackState(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.h = paramParcel.readInt();
    this.i = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.j = paramParcel.createStringArrayList();
    this.k = paramParcel.createStringArrayList();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.l = bool;
  }
  
  public BackStackState(bv parambv)
  {
    int i1 = parambv.b.size();
    this.a = new int[i1 * 6];
    if (parambv.i)
    {
      int m = 0;
      int n = 0;
      while (m < i1)
      {
        bv.a locala = (bv.a)parambv.b.get(m);
        int[] arrayOfInt = this.a;
        int i2 = n + 1;
        arrayOfInt[n] = locala.a;
        arrayOfInt = this.a;
        int i3 = i2 + 1;
        if (locala.b != null) {
          n = locala.b.f;
        } else {
          n = -1;
        }
        arrayOfInt[i2] = n;
        arrayOfInt = this.a;
        n = i3 + 1;
        arrayOfInt[i3] = locala.c;
        arrayOfInt = this.a;
        i2 = n + 1;
        arrayOfInt[n] = locala.d;
        arrayOfInt = this.a;
        n = i2 + 1;
        arrayOfInt[i2] = locala.e;
        this.a[n] = locala.f;
        m += 1;
        n += 1;
      }
      this.b = parambv.g;
      this.c = parambv.h;
      this.d = parambv.k;
      this.e = parambv.m;
      this.f = parambv.n;
      this.g = parambv.o;
      this.h = parambv.p;
      this.i = parambv.q;
      this.j = parambv.r;
      this.k = parambv.s;
      this.l = parambv.t;
      return;
    }
    throw new IllegalStateException("Not on back stack");
  }
  
  public final bv a(cc paramcc)
  {
    bv localbv = new bv(paramcc);
    int n = 0;
    int m = 0;
    while (n < this.a.length)
    {
      bv.a locala = new bv.a();
      Object localObject = this.a;
      int i1 = n + 1;
      locala.a = localObject[n];
      if (cc.a)
      {
        localObject = new StringBuilder("Instantiate ");
        ((StringBuilder)localObject).append(localbv);
        ((StringBuilder)localObject).append(" op #");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" base fragment #");
        ((StringBuilder)localObject).append(this.a[i1]);
      }
      localObject = this.a;
      n = i1 + 1;
      i1 = localObject[i1];
      if (i1 >= 0) {
        locala.b = ((Fragment)paramcc.f.get(i1));
      } else {
        locala.b = null;
      }
      localObject = this.a;
      i1 = n + 1;
      locala.c = localObject[n];
      n = i1 + 1;
      locala.d = localObject[i1];
      i1 = n + 1;
      locala.e = localObject[n];
      locala.f = localObject[i1];
      localbv.c = locala.c;
      localbv.d = locala.d;
      localbv.e = locala.e;
      localbv.f = locala.f;
      localbv.a(locala);
      m += 1;
      n = i1 + 1;
    }
    localbv.g = this.b;
    localbv.h = this.c;
    localbv.k = this.d;
    localbv.m = this.e;
    localbv.i = true;
    localbv.n = this.f;
    localbv.o = this.g;
    localbv.p = this.h;
    localbv.q = this.i;
    localbv.r = this.j;
    localbv.s = this.k;
    localbv.t = this.l;
    localbv.a(1);
    return localbv;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.BackStackState
 * JD-Core Version:    0.7.0.1
 */