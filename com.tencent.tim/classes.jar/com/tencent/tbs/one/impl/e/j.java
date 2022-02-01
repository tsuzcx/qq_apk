package com.tencent.tbs.one.impl.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.impl.a.a;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.common.d.a;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class j
  extends a<Void>
{
  i b;
  boolean c;
  Map<String, a> d = new ConcurrentHashMap();
  Bundle e;
  
  public j(i parami, Bundle paramBundle)
  {
    this.b = parami;
    this.e = paramBundle;
  }
  
  private void a(Bundle paramBundle, com.tencent.tbs.one.impl.common.d paramd)
  {
    String str1 = this.b.b;
    this.d.remove("DEPS");
    if (paramd.a <= this.b.q.getInt("in_use_deps_version", -1))
    {
      a(506, "Failed to request more recent DEPS", null);
      return;
    }
    String[] arrayOfString = this.b.m();
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      a(507, "No in-use components", null);
      return;
    }
    int i = 0;
    int k = arrayOfString.length;
    int j = 0;
    Object localObject;
    d.a locala;
    label136:
    String str2;
    int m;
    while (j < k)
    {
      localObject = arrayOfString[j];
      locala = paramd.b((String)localObject);
      if (locala == null)
      {
        com.tencent.tbs.one.impl.a.f.b("The component %s is no longer valid", new Object[] { localObject });
        j += 1;
      }
      else
      {
        str2 = locala.a;
        m = locala.c;
        com.tencent.tbs.one.impl.a.f.a("[%s] Updating component %s#%d", new Object[] { str1, str2, Integer.valueOf(m) });
        if (paramBundle != null) {
          break label269;
        }
        paramBundle = new Bundle();
      }
    }
    label269:
    for (;;)
    {
      paramBundle.putInt("info_from", 1);
      localObject = this.b.a(paramBundle, locala, new j.2(this, str1, str2, (String)localObject, m));
      this.d.put(str2, localObject);
      i += 1;
      break label136;
      if (i > 0) {
        break;
      }
      a(508, "No valid components", null);
      return;
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
    this.d.clear();
  }
  
  public final void a()
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Requesting the latest DEPS", new Object[] { this.b.b });
    Object localObject1 = this.b;
    Object localObject2 = ((h)localObject1).b;
    Object localObject3 = com.tencent.tbs.one.impl.common.f.c(((h)localObject1).c);
    if (!((File)localObject3).exists()) {
      com.tencent.tbs.one.impl.a.f.a("[%s] latest file %s is not exist,request DEPS from server", new Object[] { this.b.b, ((File)localObject3).getAbsolutePath() });
    }
    label144:
    label409:
    for (;;)
    {
      int i = 1;
      long l1;
      long l2;
      String str1;
      String str2;
      if (i != 0)
      {
        if (((File)localObject3).exists()) {
          c.c((File)localObject3);
        }
        localObject3 = ((i)localObject1).a(TBSOneManager.Policy.AUTO, -1, (File)localObject3, this.e);
        ((a)localObject3).a(new j.1(this, (String)localObject2, (i)localObject1));
        this.d.put("DEPS", localObject3);
        return;
        l1 = this.b.q.getLong("last_update_time", 0L);
        l2 = System.currentTimeMillis();
        i locali = this.b;
        str1 = locali.q.getString("last_version_name", "");
        str2 = com.tencent.tbs.one.impl.a.d.c(locali.a);
        locali.q.edit().putString("last_version_name", str2).apply();
        if (TextUtils.isEmpty(str1)) {
          i = 0;
        }
      }
      for (;;)
      {
        if ((l2 - l1 >= this.b.j) || (i != 0)) {
          break label409;
        }
        com.tencent.tbs.one.impl.a.f.a("[%s] the interval is not reached, last update time: %s,is new version: %s", new Object[] { this.b.b, com.tencent.tbs.one.impl.a.d.a(l1), "false" });
        i = 0;
        break;
        if (!str1.equals(str2))
        {
          i = 1;
          continue;
          localObject1 = null;
          if (!((File)localObject3).exists())
          {
            com.tencent.tbs.one.impl.a.f.a("[%s] last File %s is not exist,no need download component", new Object[] { localObject2, ((File)localObject3).getAbsolutePath() });
            return;
          }
          try
          {
            localObject2 = com.tencent.tbs.one.impl.common.d.a((File)localObject3);
            localObject1 = localObject2;
          }
          catch (TBSOneException localTBSOneException)
          {
            for (;;)
            {
              a(321, "parse file " + ((File)localObject3).getAbsolutePath() + " failed", localTBSOneException);
            }
          }
          if (localObject1 == null) {
            break label144;
          }
          a(this.e, (com.tencent.tbs.one.impl.common.d)localObject1);
          return;
        }
        i = 0;
      }
    }
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    com.tencent.tbs.one.impl.a.f.b("Failed to update, error: [%d] %s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.c = true;
    c();
    File localFile = com.tencent.tbs.one.impl.common.f.c(this.b.c);
    if (localFile.exists()) {
      c.c(localFile);
    }
    super.a(paramInt, paramString, paramThrowable);
  }
  
  public final void b()
  {
    super.b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.j
 * JD-Core Version:    0.7.0.1
 */