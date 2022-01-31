package com.tencent.feedback.eup.jni;

import android.content.Context;
import com.tencent.feedback.common.d;
import com.tencent.feedback.common.e;
import com.tencent.feedback.proguard.l;
import com.tencent.feedback.proguard.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements Runnable
{
  private Context a;
  private String b;
  private List c;
  
  public a(Context paramContext, String paramString, List paramList)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = paramList;
  }
  
  public final void run()
  {
    Object localObject3 = new ArrayList();
    if ((this.c != null) && (this.c.size() > 0)) {
      ((List)localObject3).addAll(this.c);
    }
    Object localObject1 = new File(this.b);
    int i;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles(new a.1(this));
      if (localObject1 != null)
      {
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (!((List)localObject3).contains(localObject2)) {
            ((List)localObject3).add(localObject2);
          }
          i += 1;
        }
      }
    }
    localObject1 = l.a(this.a, null, 1, -1);
    Object localObject2 = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    label595:
    label598:
    for (;;)
    {
      File localFile;
      Object localObject4;
      o localo;
      if (((Iterator)localObject3).hasNext())
      {
        localFile = (File)((Iterator)localObject3).next();
        if (localObject1 == null) {
          break label595;
        }
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localo = (o)((Iterator)localObject4).next();
          if ((localFile.getAbsolutePath().equals(localo.a())) && (localFile.lastModified() == localo.b()) && (localFile.length() == localo.c()) && (localo.d() != null))
          {
            ((Iterator)localObject4).remove();
            ((List)localObject2).add(localo);
            e.b("rqdp{  BufFB existed n:}%s ,ar:%s, md:%s ,ut:%d", new Object[] { localo.a(), localo.f(), localo.d(), Long.valueOf(localFile.lastModified()) });
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label598;
        }
        long l = System.currentTimeMillis();
        localObject4 = com.tencent.feedback.proguard.a.b(localFile.getAbsolutePath());
        l = System.currentTimeMillis() - l;
        if (localObject4 != null)
        {
          localo = new o();
          localo.a(1);
          localo.a(localFile.getAbsolutePath());
          StringBuilder localStringBuilder = new StringBuilder();
          d.a(this.a);
          localo.c(d.d());
          localo.c(localFile.length());
          localo.b(localFile.lastModified());
          localo.b((String)localObject4);
          e.b("rqdp{  BufFB new }n:%s , ar:%s , md:%s , cs:%d", new Object[] { localo.a(), localo.f(), localo.d(), Long.valueOf(l) });
          ((List)localObject2).add(localo);
          break;
        }
        e.b("rqdp{  Error BufFB md fail! pth:}%s , rqdp{  cs:}%d", new Object[] { localFile.getAbsolutePath(), Long.valueOf(l) });
        break;
        e.b("rqdp{  LBFTask del n: }%d", new Object[] { Integer.valueOf(l.a(this.a, 1)) });
        if (((List)localObject2).size() > 0) {
          e.b("rqdp{  LBFTask ins n: }%d", new Object[] { Integer.valueOf(l.c(this.a, (List)localObject2)) });
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.jni.a
 * JD-Core Version:    0.7.0.1
 */