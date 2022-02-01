package com.tencent.tbs.one.impl.e.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.n;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.h;
import com.tencent.tbs.one.impl.e.e;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import org.json.JSONObject;

public final class a
  extends com.tencent.tbs.one.impl.a.a<e<File>>
{
  Context b;
  String c;
  String d;
  String e;
  int f;
  File g;
  File h;
  com.tencent.tbs.one.impl.d.a i;
  int j;
  JSONObject k;
  int l;
  String m;
  long n = -1L;
  d.a o;
  private Bundle p;
  
  public a(Context paramContext, String paramString1, String paramString2, d.a parama, File paramFile, Bundle paramBundle)
  {
    this.b = paramContext;
    this.c = paramString1;
    paramContext = parama.d;
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      this.d = paramString2;
      this.e = parama.a;
      this.f = parama.c;
      this.g = paramFile;
      this.p = paramBundle;
      this.o = parama;
      this.h = com.tencent.tbs.one.impl.common.f.a(this.b, this.b, paramString1, parama.a, parama.c);
      return;
      paramString2 = paramContext;
    }
  }
  
  public final void a()
  {
    Context localContext = this.b;
    String str1 = this.c;
    String str2 = this.e;
    int i1 = this.f;
    File localFile = this.g;
    TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.a(localContext, str1);
    if (localTBSOneRuntimeExtension != null)
    {
      int i2 = localTBSOneRuntimeExtension.shouldOverrideInstallationJob(str1, str2, i1, null, localFile, new a.1(this, str1, str2, localFile));
      if (i2 != 0)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Intercepted component installation job by runtime extension", new Object[] { str1, str2 });
        this.j = i2;
        return;
      }
    }
    if (localFile.exists()) {
      c.a(localFile);
    }
    n.d(new a.2(this, localContext, str1, str2, i1));
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 219)
    {
      if (d()) {
        h.a(1017, this.e);
      }
    }
    else
    {
      if (!d()) {
        break label72;
      }
      h.a(1014, this.e);
    }
    for (;;)
    {
      com.tencent.tbs.one.impl.e.f.a(this.g, System.currentTimeMillis());
      super.a(paramInt, paramString, paramThrowable);
      return;
      h.a(1007, this.e);
      break;
      label72:
      h.a(1004, this.e);
    }
  }
  
  public final void b()
  {
    super.b();
    if (this.i != null) {
      this.i.b();
    }
    if (this.j != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = com.tencent.tbs.one.impl.common.a.a(this.b, this.c);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.j);
      }
    }
  }
  
  final boolean c()
  {
    boolean bool = false;
    if (this.p != null) {
      bool = this.p.getBoolean("is_ignore_wifi_state", false);
    }
    return bool;
  }
  
  final boolean d()
  {
    if (this.p != null) {
      return this.p.getInt("info_from", -1) == 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.a.a
 * JD-Core Version:    0.7.0.1
 */