package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.n;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class i
  extends h
{
  public SharedPreferences q;
  g r;
  private final Object s = new Object();
  private final Object t = new Object();
  private Set<String> u;
  private boolean v = false;
  private final Runnable w = new i.1(this);
  private com.tencent.tbs.one.impl.b.b x;
  
  public i(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.q = paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString }), 4);
    if (!this.q.contains("last_update_time")) {
      l();
    }
    this.u = this.q.getStringSet("disabled_component_names", new HashSet());
    com.tencent.tbs.one.impl.a.f.a("[%s] Disabled components {%s} from preferences", new Object[] { paramString, TextUtils.join(", ", this.u) });
    k();
  }
  
  private com.tencent.tbs.one.impl.a.a<e<File>> a(TBSOneManager.Policy paramPolicy, d.a parama, File paramFile, Bundle paramBundle)
  {
    Context localContext = this.a;
    String str = this.b;
    switch (i.6.a[paramPolicy.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new com.tencent.tbs.one.impl.e.b.a(localContext, str, parama, paramFile, paramBundle, n());
    case 2: 
      return new i.5(this, localContext, n(), parama.d, paramFile, parama.c);
    case 3: 
      return new com.tencent.tbs.one.impl.e.d.a(localContext, str, parama, paramFile, paramBundle);
    }
    return new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { new com.tencent.tbs.one.impl.e.c.b(this.a, this.b, parama, paramFile, paramBundle), new com.tencent.tbs.one.impl.e.e.b(this.a, this.b, parama, paramFile, paramBundle), new com.tencent.tbs.one.impl.e.c.a(this.a, this.b, parama, paramFile, paramBundle), new com.tencent.tbs.one.impl.e.e.a(this.a, this.b, parama, paramFile, paramBundle), com.tencent.tbs.one.impl.a.a(this, parama, paramFile, paramBundle) });
  }
  
  private boolean a(String paramString, TBSOneCallback paramTBSOneCallback)
  {
    if (this.u.contains(paramString))
    {
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onError(501, "The component has disabled");
      }
      return false;
    }
    return true;
  }
  
  private void h(String paramString)
  {
    Object localObject = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.a.getDir("tbs", 0), Process.myPid()), this.b);
    com.tencent.tbs.one.impl.a.c.d(((File)localObject).getParentFile());
    if (!((File)localObject).exists()) {
      com.tencent.tbs.one.impl.a.c.b((File)localObject);
    }
    localObject = new HashSet(Arrays.asList(m()));
    ((Set)localObject).add(paramString);
    paramString = this.q.edit();
    paramString.putStringSet("in_use_component_names", (Set)localObject);
    paramString.apply();
  }
  
  private String n()
  {
    Object localObject = g("local_repository_path");
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    return "/android_asset/";
  }
  
  public final TBSOneManager.Policy a()
  {
    Object localObject = g("overridden_policy");
    if ((localObject instanceof TBSOneManager.Policy)) {
      return (TBSOneManager.Policy)localObject;
    }
    if ((localObject instanceof String)) {
      return TBSOneManager.Policy.valueOf(localObject.toString());
    }
    return super.a();
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<com.tencent.tbs.one.impl.common.d>> a(Bundle paramBundle, l<e<com.tencent.tbs.one.impl.common.d>> paraml)
  {
    boolean bool = false;
    Object localObject1 = a();
    if (localObject1 == TBSOneManager.Policy.BUILTIN_ONLY) {
      return super.a(paramBundle, paraml);
    }
    String str = this.b;
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS, policy: %s", new Object[] { str, localObject1 });
    File localFile = com.tencent.tbs.one.impl.common.f.b(this.c);
    Object localObject2;
    j localj;
    if (i())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] Applying the last update", new Object[] { str });
      Context localContext = this.a;
      f.a(localContext);
      localObject2 = j();
      if (localObject2 == null) {
        break label340;
      }
      localj = j.a(com.tencent.tbs.one.impl.common.f.e(localFile, ".lock"));
      if (localj == null) {
        break label316;
      }
      if (!i()) {
        break label292;
      }
      if (f.b(localContext, str)) {
        break label268;
      }
    }
    for (;;)
    {
      try
      {
        com.tencent.tbs.one.impl.a.c.c(com.tencent.tbs.one.impl.common.f.c(this.c), localFile);
        localj.a();
        ((j)localObject2).a();
        localObject2 = this.e.get("permanent_version");
        if (!(localObject2 instanceof Integer)) {
          break label364;
        }
        i = ((Integer)localObject2).intValue();
        if (localObject1 != TBSOneManager.Policy.AUTO) {
          break label369;
        }
        paramBundle = a(TBSOneManager.Policy.AUTO, i, localFile, paramBundle);
        paramBundle = new d(bool, paramBundle, localFile);
        paramBundle.a(new i.3(this));
        paramBundle.a(paraml);
        return paramBundle;
      }
      catch (IOException localIOException)
      {
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to apply the last update", new Object[] { str, localIOException });
        continue;
      }
      label268:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the category is being used by other processes", new Object[] { str, "Early out for applying the last update," });
      continue;
      label292:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the last update has applied by another process", new Object[] { str, "Early out for applying the last update," });
      continue;
      label316:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", new Object[] { str, "Early out for applying the last update," });
      continue;
      label340:
      com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", new Object[] { str, "Early out for applying the last update," });
      continue;
      label364:
      int i = -1;
      continue;
      label369:
      if (localObject1 == TBSOneManager.Policy.LOCAL_ONLY)
      {
        paramBundle = a(TBSOneManager.Policy.LOCAL_ONLY, i, localFile, paramBundle);
      }
      else if (localObject1 == TBSOneManager.Policy.ONLINE)
      {
        paramBundle = a(TBSOneManager.Policy.ONLINE, i, localFile, paramBundle);
      }
      else
      {
        if (localObject1 == TBSOneManager.Policy.BUILTIN_FIRST)
        {
          if (localFile.exists()) {}
          for (;;)
          {
            try
            {
              localObject1 = com.tencent.tbs.one.impl.common.d.a(localFile);
              localObject2 = com.tencent.tbs.one.impl.common.d.a(com.tencent.tbs.one.impl.common.f.c(com.tencent.tbs.one.impl.common.f.a(this.a), str));
              if (((com.tencent.tbs.one.impl.common.d)localObject1).a < ((com.tencent.tbs.one.impl.common.d)localObject2).a)
              {
                com.tencent.tbs.one.impl.a.f.a("[%s] Ignoring existing DEPS, builtin DEPS version has changed %d => %d", new Object[] { str, Integer.valueOf(((com.tencent.tbs.one.impl.common.d)localObject1).a), Integer.valueOf(((com.tencent.tbs.one.impl.common.d)localObject2).a) });
                bool = true;
                paramBundle = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.BUILTIN_ONLY, i, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, i, localFile, paramBundle) });
              }
            }
            catch (TBSOneException localTBSOneException) {}
            bool = false;
          }
        }
        if (localObject1 == TBSOneManager.Policy.LOCAL_FIRST) {
          paramBundle = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.LOCAL_ONLY, i, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, i, localFile, paramBundle) });
        } else {
          paramBundle = null;
        }
      }
    }
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<File>> a(Bundle paramBundle, d.a parama, l<e<File>> paraml)
  {
    int i = 10000;
    TBSOneManager.Policy localPolicy = a();
    if (localPolicy == TBSOneManager.Policy.BUILTIN_ONLY) {
      return super.a(paramBundle, parama, paraml);
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d, policy: %s", new Object[] { this.b, parama.a, Integer.valueOf(parama.c), localPolicy });
    File localFile = a(parama.a, parama.c);
    com.tencent.tbs.one.impl.a.c.d(localFile.getParentFile());
    Object localObject = null;
    if (localPolicy == TBSOneManager.Policy.AUTO) {
      localObject = a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle);
    }
    for (;;)
    {
      if (paramBundle != null) {
        i = paramBundle.getInt("time_out", 10000);
      }
      paramBundle = new c(this.a, parama, (com.tencent.tbs.one.impl.a.a)localObject, localFile, i);
      paramBundle.a(paraml);
      return paramBundle;
      if (localPolicy == TBSOneManager.Policy.LOCAL_ONLY) {
        localObject = a(TBSOneManager.Policy.LOCAL_ONLY, parama, localFile, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.ONLINE) {
        localObject = a(TBSOneManager.Policy.ONLINE, parama, localFile, paramBundle);
      } else if (localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) {
        localObject = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.BUILTIN_ONLY, parama, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle) });
      } else if (localPolicy == TBSOneManager.Policy.LOCAL_FIRST) {
        localObject = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.LOCAL_ONLY, parama, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle) });
      }
    }
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<com.tencent.tbs.one.impl.common.d>> a(TBSOneManager.Policy paramPolicy, int paramInt, File paramFile, Bundle paramBundle)
  {
    Context localContext = this.a;
    String str = this.b;
    switch (i.6.a[paramPolicy.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return new com.tencent.tbs.one.impl.e.b.b(localContext, str, paramFile);
    case 2: 
      return new i.4(this, localContext, n(), paramFile);
    case 3: 
      return new com.tencent.tbs.one.impl.e.d.b(localContext, str, g(), paramFile);
    }
    return com.tencent.tbs.one.impl.a.a(this, paramInt, paramFile, paramBundle);
  }
  
  public final void a(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (a(paramString, paramTBSOneCallback)) {
      super.a(paramBundle, paramString, paramTBSOneCallback);
    }
  }
  
  protected final void a(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    super.a(parame);
    SharedPreferences.Editor localEditor = this.q.edit();
    localEditor.putInt("in_use_deps_version", ((com.tencent.tbs.one.impl.common.d)parame.b).a);
    localEditor.apply();
  }
  
  public final void a(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    h(paramString);
    if (a(paramString, paramTBSOneCallback)) {
      super.a(paramString, paramBundle, paramTBSOneCallback);
    }
  }
  
  public final void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (paramString.equals("permanent_version")) {
      a(false);
    }
    if (paramString.equals("guid"))
    {
      if (paramObject == null)
      {
        str = "";
        com.tencent.tbs.one.impl.a.d.a(str);
      }
    }
    else if (paramString.equals("ppvn")) {
      if (paramObject != null) {
        break label220;
      }
    }
    label220:
    for (String str = "";; str = paramObject.toString())
    {
      com.tencent.tbs.one.impl.a.d.b(str);
      if (paramString.equals("disable_query_running_processes")) {
        com.tencent.tbs.one.impl.a.d.a(com.tencent.tbs.one.impl.a.d.a(paramObject));
      }
      if (paramString.equals("enable_console_logging")) {
        com.tencent.tbs.one.impl.a.f.a(com.tencent.tbs.one.impl.a.d.a(paramObject));
      }
      if ((paramString.equals("is_need_update_at_upgrade")) && ((paramObject instanceof Boolean))) {
        this.k = ((Boolean)paramObject).booleanValue();
      }
      if ((paramString.equals("update_interval")) && ((paramObject instanceof Long))) {
        this.j = ((Long)paramObject).longValue();
      }
      if ((paramString.equals("is_ignore_update_flow_control")) && ((paramObject instanceof Boolean))) {
        this.l = ((Boolean)paramObject).booleanValue();
      }
      if ((paramString.equals("is_ignore_update_wifi_network")) && ((paramObject instanceof Boolean))) {
        this.m = ((Boolean)paramObject).booleanValue();
      }
      return;
      str = paramObject.toString();
      break;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      k();
    }
  }
  
  public final void b(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    if (parame.a != e.a.d) {
      return;
    }
    HashSet localHashSet = new HashSet();
    if ((parame.c instanceof JSONObject))
    {
      String str = this.b;
      parame = (JSONObject)parame.c;
      JSONObject localJSONObject = parame.optJSONObject("SWITCH");
      Iterator localIterator;
      Object localObject;
      if (localJSONObject != null)
      {
        localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject.optInt((String)localObject, 0) == 1) {
            localHashSet.add(localObject);
          }
        }
      }
      localJSONObject = parame.optJSONObject("RESET");
      if (localJSONObject != null)
      {
        localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject.optInt((String)localObject, 0) == 1)
          {
            localObject = a((String)localObject, f.c(a((String)localObject)));
            if (((File)localObject).exists())
            {
              f.e((File)localObject);
              com.tencent.tbs.one.impl.a.f.a("[%s] Reset component %s", new Object[] { str, ((File)localObject).getAbsolutePath() });
            }
            else
            {
              com.tencent.tbs.one.impl.a.f.c("[%s] Failed to reset component, %s does not exist", new Object[] { str, ((File)localObject).getAbsolutePath() });
            }
          }
        }
      }
      if (parame.optInt("ULOG") == 1) {
        StatisticReport.reportLog();
      }
    }
    this.u = localHashSet;
    com.tencent.tbs.one.impl.a.f.a("[%s] Disabled components {%s} from server", new Object[] { this.b, TextUtils.join(", ", this.u) });
    parame = this.q.edit();
    parame.putStringSet("disabled_component_names", localHashSet);
    parame.apply();
  }
  
  public final void b(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    h(paramString);
    if (a(paramString, paramTBSOneCallback)) {
      super.b(paramString, paramBundle, paramTBSOneCallback);
    }
  }
  
  public final boolean b(String paramString)
  {
    Object localObject = a(paramString);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return false;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        File localFile = com.tencent.tbs.one.impl.common.f.b(this.c);
        if (localFile.exists())
        {
          int j;
          try
          {
            com.tencent.tbs.one.impl.common.d locald = com.tencent.tbs.one.impl.common.d.a(localFile);
            paramString = locald.b(paramString);
            if (paramString == null) {
              continue;
            }
            paramString = paramString.f;
            if (paramString != null)
            {
              j = paramString.length;
              i = 0;
              for (;;)
              {
                if (i >= j) {
                  break label132;
                }
                if (!b(paramString[i])) {
                  break;
                }
                i += 1;
              }
            }
            j = localObject.length;
          }
          catch (TBSOneException paramString)
          {
            com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse DEPS file %s", new Object[] { this.b, localFile.getAbsolutePath(), paramString });
            return false;
          }
          label132:
          int i = 0;
          while (i < j)
          {
            paramString = localObject[i];
            if ((paramString.isDirectory()) && (f.g(paramString))) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  public final TBSOneOnlineService c()
  {
    if (!b()) {
      return null;
    }
    synchronized (this.s)
    {
      if (this.r == null) {
        this.r = new g(this);
      }
      g localg = this.r;
      return localg;
    }
  }
  
  public final int[] c(String paramString)
  {
    paramString = a(paramString);
    int[] arrayOfInt;
    int j;
    int i;
    File localFile;
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        arrayOfInt = new int[paramString.length];
        int m = paramString.length;
        j = 0;
        i = 0;
        if (j < m)
        {
          localFile = paramString[j];
          if ((!localFile.isDirectory()) || (!f.g(localFile))) {
            break label136;
          }
        }
      }
    }
    label136:
    for (;;)
    {
      try
      {
        int n = Integer.parseInt(localFile.getName());
        int k = i + 1;
        arrayOfInt[i] = n;
        i = k;
      }
      catch (Exception localException)
      {
        com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse installed version from path %s", new Object[] { this.b, localFile.getAbsolutePath() });
        continue;
      }
      j += 1;
      break;
      return Arrays.copyOfRange(arrayOfInt, 0, i);
      return new int[0];
    }
  }
  
  public final TBSOneDebugger d()
  {
    synchronized (this.t)
    {
      if (this.x == null) {
        this.x = new com.tencent.tbs.one.impl.b.b(this.b);
      }
      com.tencent.tbs.one.impl.b.b localb = this.x;
      return localb;
    }
  }
  
  public final void e()
  {
    if (this.v) {}
    TBSOneOnlineService localTBSOneOnlineService;
    do
    {
      return;
      this.v = true;
      localTBSOneOnlineService = c();
    } while (localTBSOneOnlineService == null);
    Bundle localBundle = new Bundle();
    if (this.l) {
      localBundle.putBoolean("is_ignore_flow_control_suggestion", true);
    }
    if (this.m) {
      localBundle.putBoolean("is_ignore_wifi_state", true);
    }
    localTBSOneOnlineService.update(localBundle, new i.2(this));
  }
  
  public final String[] f()
  {
    Object localObject = g("sharable_application_packages");
    if ((localObject instanceof String)) {
      return ((String)localObject).split(File.pathSeparator);
    }
    return com.tencent.tbs.one.impl.common.b.a;
  }
  
  public final String g()
  {
    Object localObject = g("online_service_url");
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    return "https://tbsone.imtt.qq.com";
  }
  
  final File h()
  {
    return new File(this.c, "incomplete-update");
  }
  
  public final boolean i()
  {
    boolean bool2 = com.tencent.tbs.one.impl.common.f.c(this.c).exists();
    if (!h().exists()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] Checking update availability, exists: %b, complete: %b", new Object[] { this.b, Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public final j j()
  {
    return j.a(com.tencent.tbs.one.impl.common.f.e(com.tencent.tbs.one.impl.common.f.c(this.c), ".lock"));
  }
  
  final void k()
  {
    Handler localHandler = n.a();
    localHandler.removeCallbacks(this.w);
    localHandler.postDelayed(this.w, 10000L);
  }
  
  final void l()
  {
    SharedPreferences.Editor localEditor = this.q.edit();
    localEditor.putLong("last_update_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public final String[] m()
  {
    return (String[])this.q.getStringSet("in_use_component_names", new HashSet()).toArray(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i
 * JD-Core Version:    0.7.0.1
 */