package com.tencent.tbs.one.impl.c;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.n;
import com.tencent.tbs.one.impl.common.e.a;
import com.tencent.tbs.one.impl.common.e.b;
import com.tencent.tbs.one.impl.e.h.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b
  implements com.tencent.tbs.one.impl.a.a.d.a
{
  public final String a;
  public final com.tencent.tbs.one.impl.e.h b;
  final ArrayList<TBSOneCallback<File>> c = new ArrayList();
  public final ArrayList<TBSOneCallback<TBSOneComponent>> d = new ArrayList();
  public boolean e;
  public boolean f;
  public com.tencent.tbs.one.impl.common.d.a g;
  public int h;
  int i;
  String j;
  public File k;
  public a l;
  public WeakReference<com.tencent.tbs.one.impl.a.a> m;
  private com.tencent.tbs.one.impl.common.e n;
  private Map<String, ClassLoader> o;
  private int p;
  
  public b(com.tencent.tbs.one.impl.e.h paramh, String paramString)
  {
    this.a = paramString;
    this.b = paramh;
  }
  
  private File a(String paramString)
  {
    Object localObject = this.b.n;
    if (localObject != null)
    {
      localObject = ((TBSOneDelegate)localObject).shouldOverrideFilePath(this.b.b, this.a, this.g.c, paramString);
      if (localObject != null) {
        paramString = new File((String)localObject);
      }
    }
    do
    {
      return paramString;
      localObject = new File(this.k, paramString);
      paramString = (String)localObject;
    } while (((File)localObject).exists());
    f.b("Failed to find component file %s in installation directory", new Object[] { ((File)localObject).getAbsolutePath() });
    return localObject;
  }
  
  private ClassLoader a(Context paramContext, String paramString)
    throws TBSOneException
  {
    String str1 = this.b.b;
    String str2 = this.a;
    Object localObject1;
    if (this.o != null)
    {
      localObject1 = (ClassLoader)this.o.get(paramString);
      if (localObject1 != null)
      {
        f.a("[%s] {%s} Reusing class loader %s %s", new Object[] { str1, str2, paramString, localObject1 });
        return localObject1;
      }
    }
    File localFile = a(paramString);
    if (!localFile.exists()) {
      throw new TBSOneException(105, "Failed to find dex file " + localFile.getAbsolutePath());
    }
    f.a("[%s] {%s} Creating class loader %s from %s", new Object[] { str1, str2, paramString, localFile.getAbsolutePath() });
    if (this.n == null)
    {
      localObject1 = a("MANIFEST");
      if (((File)localObject1).exists()) {
        f.a("[%s] {%s} Initializing component according to MANIFEST file %s", new Object[] { str1, str2, ((File)localObject1).getAbsolutePath() });
      }
    }
    for (;;)
    {
      String str3;
      Object localObject3;
      try
      {
        this.n = com.tencent.tbs.one.impl.common.e.a((File)localObject1);
        if (this.n == null)
        {
          localObject2 = null;
          localObject1 = this.b;
          str3 = this.a;
          str3 = str3 + "." + "parent_classloader";
          if (!((com.tencent.tbs.one.impl.e.h)localObject1).e.containsKey(str3)) {
            break label513;
          }
          localObject1 = ((com.tencent.tbs.one.impl.e.h)localObject1).e.get(str3);
          if (!(localObject1 instanceof ClassLoader)) {
            break label551;
          }
          localObject1 = (ClassLoader)localObject1;
          str3 = b(localFile.getAbsolutePath());
          boolean bool1 = this.b.a(str2, "disable_sealed_classloader");
          boolean bool2 = this.b.a(str2, "enable_async_dex_optimization");
          long l1 = System.currentTimeMillis();
          localObject3 = this.k.getAbsolutePath();
          if (localObject2 != null) {
            break label679;
          }
          localObject2 = null;
          paramContext = com.tencent.tbs.one.impl.c.a.c.a(paramContext, localFile, (String)localObject3, str3, (ClassLoader)localObject1, bool1, (String[])localObject2, bool2);
          f.a("[%s] {%s} Created dex class loader %s %s cost %dms", new Object[] { str1, str2, paramString, paramContext, Long.valueOf(System.currentTimeMillis() - l1) });
          if (this.o == null) {
            this.o = new HashMap();
          }
          this.o.put(paramString, paramContext);
          paramString = this.b.n;
          if (paramString != null) {
            paramString.onDexLoaded(str1, str2, this.g.c, localFile.getAbsolutePath(), paramContext);
          }
          return paramContext;
        }
      }
      catch (TBSOneException paramContext)
      {
        b(paramContext.getErrorCode(), paramContext.getMessage(), paramContext.getCause());
        return null;
      }
      Object localObject2 = this.n.a(paramString);
      continue;
      label513:
      if (((com.tencent.tbs.one.impl.e.h)localObject1).e.containsKey("parent_classloader"))
      {
        localObject1 = ((com.tencent.tbs.one.impl.e.h)localObject1).e.get("parent_classloader");
      }
      else
      {
        localObject1 = null;
        continue;
        label551:
        if (localObject2 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            str3 = ((e.b)localObject1).a;
            if (TextUtils.isEmpty(str3))
            {
              localObject1 = a(paramContext, ((e.b)localObject1).b);
              break;
              localObject1 = ((e.a)localObject2).d;
              continue;
            }
            localObject3 = this.b.e(str3);
            if (localObject3 == null) {
              throw new TBSOneException(404, "Failed to get loaded dependency " + str3);
            }
            localObject1 = ((b)localObject3).a(paramContext, ((e.b)localObject1).b);
            break;
          }
        }
        localObject1 = this.b.a.getClassLoader();
        continue;
        label679:
        localObject2 = ((e.a)localObject2).c;
      }
    }
  }
  
  private void a(a parama)
  {
    int i1 = 0;
    f.a("[%s] {%s} Finished loading component %s", new Object[] { this.b.b, this.a, parama });
    this.l = parama;
    int i2 = this.h;
    this.h = 100;
    TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
    this.d.clear();
    int i3 = arrayOfTBSOneCallback.length;
    while (i1 < i3)
    {
      TBSOneCallback localTBSOneCallback = arrayOfTBSOneCallback[i1];
      localTBSOneCallback.onProgressChanged(i2, 100);
      localTBSOneCallback.onCompleted(parama);
      i1 += 1;
    }
  }
  
  private String b(String paramString)
  {
    String str2 = TextUtils.join(File.pathSeparator, c());
    f.a("[%s] {%s} Collected librarySearchPath %s", new Object[] { this.b.b, this.a, str2 });
    TBSOneDelegate localTBSOneDelegate = this.b.n;
    String str1 = str2;
    if (localTBSOneDelegate != null)
    {
      paramString = localTBSOneDelegate.shouldOverrideLibrarySearchPath(this.b.b, this.a, this.g.c, paramString, str2);
      str1 = str2;
      if (paramString != null) {
        str1 = paramString;
      }
    }
    return str1;
  }
  
  private Set<String> c()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.k.getAbsolutePath());
    String[] arrayOfString = this.g.f;
    if (arrayOfString != null)
    {
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        localHashSet.addAll(this.b.e(str).c());
        i1 += 1;
      }
    }
    return localHashSet;
  }
  
  public final void a()
  {
    String str = this.a;
    f.a("[%s] {%s} Finished installing component and dependencies", new Object[] { this.b.b, str });
    n.a(new b.5(this, str));
  }
  
  final void a(int paramInt)
  {
    Object localObject = this.b.b;
    localObject = this.a;
    int i1 = this.h;
    if (paramInt - this.h > 2)
    {
      int i2 = this.h;
      this.h = paramInt;
      localObject = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      int i3 = localObject.length;
      i1 = 0;
      while (i1 < i3)
      {
        localObject[i1].onProgressChanged(i2, paramInt);
        i1 += 1;
      }
      i3 = arrayOfTBSOneCallback.length;
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfTBSOneCallback[i1].onProgressChanged(i2, paramInt);
        i1 += 1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    float f1 = paramInt2;
    a((int)(paramInt1 / 100.0F * (paramInt3 - paramInt2) + f1));
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    n.a(new b.4(this, paramInt, paramString, paramThrowable));
  }
  
  public final void a(Bundle paramBundle)
  {
    Object localObject1 = this.b.b;
    Object localObject2 = this.a;
    if (this.e) {
      f.a("[%s] {%s} Have started loading component", new Object[] { localObject1, localObject2 });
    }
    do
    {
      return;
      f.a("[%s] {%s} Loading DEPS", new Object[] { localObject1, localObject2 });
      this.e = true;
      this.f = false;
      if ((paramBundle == null) || (!paramBundle.containsKey("deps"))) {
        break;
      }
      localObject1 = (com.tencent.tbs.one.impl.common.d)paramBundle.getSerializable("deps");
    } while (localObject1 == null);
    a(paramBundle, (com.tencent.tbs.one.impl.common.d)localObject1);
    return;
    localObject1 = this.b;
    localObject2 = new b.1(this, paramBundle);
    String str = ((com.tencent.tbs.one.impl.e.h)localObject1).b;
    f.a("[%s] Loading DEPS", new Object[] { str });
    if (((com.tencent.tbs.one.impl.e.h)localObject1).o != null)
    {
      f.a("[%s] Loaded DEPS#%d", new Object[] { str, Integer.valueOf(((com.tencent.tbs.one.impl.e.h)localObject1).o.a) });
      ((l)localObject2).a(((com.tencent.tbs.one.impl.e.h)localObject1).o);
      return;
    }
    if (((com.tencent.tbs.one.impl.e.h)localObject1).p == null) {
      ((com.tencent.tbs.one.impl.e.h)localObject1).p = new h.1((com.tencent.tbs.one.impl.e.h)localObject1, paramBundle);
    }
    ((com.tencent.tbs.one.impl.e.h)localObject1).p.a((l)localObject2);
  }
  
  public final void a(Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (this.k != null)
    {
      f.a("[%s] {%s} Installed component at %s", new Object[] { this.b.b, this.a, this.k });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(this.k);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, this.h);
      this.c.add(paramTBSOneCallback);
    }
    a(paramBundle);
  }
  
  final void a(Bundle paramBundle, com.tencent.tbs.one.impl.common.d paramd)
  {
    if (this.f)
    {
      b(104, "Aborted", null);
      return;
    }
    a(20);
    String str1 = this.b.b;
    int i1 = paramd.a;
    String str2 = this.a;
    f.a("[%s] {%s} Finished loading DEPS#%d", new Object[] { str1, str2, Integer.valueOf(i1) });
    Object localObject = paramd.b(str2);
    if (localObject == null)
    {
      b(309, "Failed to get info for component " + str2, null);
      return;
    }
    String[] arrayOfString = ((com.tencent.tbs.one.impl.common.d.a)localObject).f;
    int i2;
    float f1;
    if (arrayOfString != null)
    {
      i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str3 = arrayOfString[i1];
        if (paramd.b(str3) == null)
        {
          b(310, "Failed to get info for dependency " + str3, null);
          return;
        }
        i1 += 1;
      }
      f1 = 1.0F / (arrayOfString.length + 1);
      this.g = ((com.tencent.tbs.one.impl.common.d.a)localObject);
      this.p = 0;
      if (arrayOfString != null) {
        break label338;
      }
    }
    label338:
    for (paramd = "";; paramd = TextUtils.join(", ", arrayOfString))
    {
      f.a("[%s] {%s} Installing component and dependencies [%s]", new Object[] { str1, str2, paramd });
      paramd = new com.tencent.tbs.one.impl.a.a.a();
      paramd.b(new b.2(this, paramBundle, (com.tencent.tbs.one.impl.common.d.a)localObject, f1, str1, str2));
      localObject = this.b;
      if (arrayOfString == null) {
        break label350;
      }
      i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramd.b(new b.3(this, (com.tencent.tbs.one.impl.e.h)localObject, paramBundle, arrayOfString[i1], f1, str1, str2));
        i1 += 1;
      }
      f1 = 1.0F;
      break;
    }
    label350:
    paramBundle = new com.tencent.tbs.one.impl.a.a.e(AsyncTask.THREAD_POOL_EXECUTOR);
    paramBundle.a = this;
    paramBundle.a(paramd);
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   4: getfield 62	com/tencent/tbs/one/impl/e/h:b	Ljava/lang/String;
    //   7: astore 11
    //   9: aload_0
    //   10: getfield 51	com/tencent/tbs/one/impl/c/b:a	Ljava/lang/String;
    //   13: astore 12
    //   15: aload_0
    //   16: getfield 64	com/tencent/tbs/one/impl/c/b:g	Lcom/tencent/tbs/one/impl/common/d$a;
    //   19: getfield 68	com/tencent/tbs/one/impl/common/d$a:c	I
    //   22: istore_2
    //   23: ldc_w 483
    //   26: iconst_2
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload 11
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload 12
    //   39: aastore
    //   40: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   46: lstore 4
    //   48: new 485	com/tencent/tbs/one/impl/c/a
    //   51: dup
    //   52: aload 12
    //   54: aload_0
    //   55: getfield 64	com/tencent/tbs/one/impl/c/b:g	Lcom/tencent/tbs/one/impl/common/d$a;
    //   58: getfield 486	com/tencent/tbs/one/impl/common/d$a:b	Ljava/lang/String;
    //   61: iload_2
    //   62: aload_0
    //   63: getfield 81	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   66: invokespecial 489	com/tencent/tbs/one/impl/c/a:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/io/File;)V
    //   69: astore 10
    //   71: aload_0
    //   72: ldc 139
    //   74: invokespecial 118	com/tencent/tbs/one/impl/c/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 88	java/io/File:exists	()Z
    //   84: ifeq +986 -> 1070
    //   87: ldc 141
    //   89: iconst_3
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload 11
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload 12
    //   102: aastore
    //   103: dup
    //   104: iconst_2
    //   105: aload 8
    //   107: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: aload_0
    //   115: aload 8
    //   117: invokestatic 146	com/tencent/tbs/one/impl/common/e:a	(Ljava/io/File;)Lcom/tencent/tbs/one/impl/common/e;
    //   120: putfield 137	com/tencent/tbs/one/impl/c/b:n	Lcom/tencent/tbs/one/impl/common/e;
    //   123: aload_0
    //   124: getfield 137	com/tencent/tbs/one/impl/c/b:n	Lcom/tencent/tbs/one/impl/common/e;
    //   127: getfield 492	com/tencent/tbs/one/impl/common/e:f	[Landroid/util/Pair;
    //   130: astore 13
    //   132: aload 13
    //   134: ifnull +174 -> 308
    //   137: ldc_w 494
    //   140: iconst_3
    //   141: anewarray 4	java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: aload 11
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload 12
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: aload 13
    //   158: aastore
    //   159: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload 13
    //   164: arraylength
    //   165: istore_3
    //   166: iconst_0
    //   167: istore_1
    //   168: iload_1
    //   169: iload_3
    //   170: if_icmpge +158 -> 328
    //   173: aload 13
    //   175: iload_1
    //   176: aaload
    //   177: astore 8
    //   179: aload_0
    //   180: getfield 53	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   183: astore 14
    //   185: new 496	com/tencent/tbs/one/impl/common/g
    //   188: dup
    //   189: aload 12
    //   191: aload 8
    //   193: getfield 502	android/util/Pair:second	Ljava/lang/Object;
    //   196: checkcast 504	java/lang/String
    //   199: aload 8
    //   201: getfield 507	android/util/Pair:first	Ljava/lang/Object;
    //   204: checkcast 504	java/lang/String
    //   207: invokespecial 510	com/tencent/tbs/one/impl/common/g:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   210: astore 15
    //   212: aload 15
    //   214: getfield 512	com/tencent/tbs/one/impl/common/g:c	Ljava/lang/String;
    //   217: astore 16
    //   219: aload 14
    //   221: getfield 514	com/tencent/tbs/one/impl/e/h:g	Ljava/util/Map;
    //   224: aload 16
    //   226: invokeinterface 110 2 0
    //   231: checkcast 516	java/util/List
    //   234: astore 9
    //   236: aload 9
    //   238: astore 8
    //   240: aload 9
    //   242: ifnonnull +27 -> 269
    //   245: new 44	java/util/ArrayList
    //   248: dup
    //   249: invokespecial 45	java/util/ArrayList:<init>	()V
    //   252: astore 8
    //   254: aload 14
    //   256: getfield 514	com/tencent/tbs/one/impl/e/h:g	Ljava/util/Map;
    //   259: aload 16
    //   261: aload 8
    //   263: invokeinterface 193 3 0
    //   268: pop
    //   269: aload 8
    //   271: aload 15
    //   273: invokeinterface 517 2 0
    //   278: pop
    //   279: iload_1
    //   280: iconst_1
    //   281: iadd
    //   282: istore_1
    //   283: goto -115 -> 168
    //   286: astore 8
    //   288: aload_0
    //   289: aload 8
    //   291: invokevirtual 201	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   294: aload 8
    //   296: invokevirtual 204	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   299: aload 8
    //   301: invokevirtual 208	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   304: invokevirtual 211	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   307: return
    //   308: ldc_w 519
    //   311: iconst_2
    //   312: anewarray 4	java/lang/Object
    //   315: dup
    //   316: iconst_0
    //   317: aload 11
    //   319: aastore
    //   320: dup
    //   321: iconst_1
    //   322: aload 12
    //   324: aastore
    //   325: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: aload_0
    //   329: getfield 53	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   332: getfield 239	com/tencent/tbs/one/impl/e/h:a	Landroid/content/Context;
    //   335: astore 9
    //   337: aload_0
    //   338: getfield 137	com/tencent/tbs/one/impl/c/b:n	Lcom/tencent/tbs/one/impl/common/e;
    //   341: getfield 520	com/tencent/tbs/one/impl/common/e:b	Ljava/lang/String;
    //   344: astore 13
    //   346: aconst_null
    //   347: astore 8
    //   349: aload 13
    //   351: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +463 -> 817
    //   357: aload_0
    //   358: aload 13
    //   360: invokespecial 118	com/tencent/tbs/one/impl/c/b:a	(Ljava/lang/String;)Ljava/io/File;
    //   363: astore 8
    //   365: ldc_w 522
    //   368: iconst_4
    //   369: anewarray 4	java/lang/Object
    //   372: dup
    //   373: iconst_0
    //   374: aload 11
    //   376: aastore
    //   377: dup
    //   378: iconst_1
    //   379: aload 12
    //   381: aastore
    //   382: dup
    //   383: iconst_2
    //   384: aload 13
    //   386: aastore
    //   387: dup
    //   388: iconst_3
    //   389: aload 8
    //   391: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: aastore
    //   395: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   398: aload 8
    //   400: invokevirtual 88	java/io/File:exists	()Z
    //   403: ifne +32 -> 435
    //   406: aload_0
    //   407: bipush 105
    //   409: new 120	java/lang/StringBuilder
    //   412: dup
    //   413: ldc_w 524
    //   416: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: aload 8
    //   421: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   424: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aconst_null
    //   431: invokevirtual 211	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   434: return
    //   435: new 526	com/tencent/tbs/one/impl/c/b/b
    //   438: dup
    //   439: aload 9
    //   441: aload 8
    //   443: invokevirtual 94	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   446: invokespecial 529	com/tencent/tbs/one/impl/c/b/b:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   449: astore 8
    //   451: aload 10
    //   453: aload 8
    //   455: putfield 530	com/tencent/tbs/one/impl/c/a:a	Landroid/content/Context;
    //   458: aload_0
    //   459: getfield 137	com/tencent/tbs/one/impl/c/b:n	Lcom/tencent/tbs/one/impl/common/e;
    //   462: getfield 531	com/tencent/tbs/one/impl/common/e:c	Ljava/lang/String;
    //   465: astore 13
    //   467: aload 13
    //   469: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +575 -> 1047
    //   475: aload_0
    //   476: aload 9
    //   478: aload 13
    //   480: invokespecial 226	com/tencent/tbs/one/impl/c/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   483: astore 15
    //   485: aload 10
    //   487: aload 15
    //   489: putfield 534	com/tencent/tbs/one/impl/c/a:b	Ljava/lang/ClassLoader;
    //   492: aload_0
    //   493: getfield 137	com/tencent/tbs/one/impl/c/b:n	Lcom/tencent/tbs/one/impl/common/e;
    //   496: getfield 536	com/tencent/tbs/one/impl/common/e:d	Ljava/lang/String;
    //   499: astore 14
    //   501: aload 14
    //   503: invokestatic 223	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   506: ifne +518 -> 1024
    //   509: ldc_w 538
    //   512: iconst_3
    //   513: anewarray 4	java/lang/Object
    //   516: dup
    //   517: iconst_0
    //   518: aload 11
    //   520: aastore
    //   521: dup
    //   522: iconst_1
    //   523: aload 12
    //   525: aastore
    //   526: dup
    //   527: iconst_2
    //   528: aload 14
    //   530: aastore
    //   531: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   534: new 188	java/util/HashMap
    //   537: dup
    //   538: invokespecial 189	java/util/HashMap:<init>	()V
    //   541: astore 11
    //   543: aload 11
    //   545: ldc_w 540
    //   548: aload 9
    //   550: invokeinterface 193 3 0
    //   555: pop
    //   556: aload 8
    //   558: ifnull +26 -> 584
    //   561: aload 8
    //   563: getfield 543	com/tencent/tbs/one/impl/c/b/b:a	Lcom/tencent/tbs/one/impl/c/b/a;
    //   566: aload 15
    //   568: putfield 547	com/tencent/tbs/one/impl/c/b/a:a	Ljava/lang/ClassLoader;
    //   571: aload 11
    //   573: ldc_w 549
    //   576: aload 8
    //   578: invokeinterface 193 3 0
    //   583: pop
    //   584: aload 11
    //   586: ldc_w 551
    //   589: aload 15
    //   591: invokeinterface 193 3 0
    //   596: pop
    //   597: aload 11
    //   599: ldc_w 553
    //   602: aload_0
    //   603: getfield 81	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   606: invokeinterface 193 3 0
    //   611: pop
    //   612: aload 11
    //   614: ldc_w 555
    //   617: aload_0
    //   618: getfield 81	com/tencent/tbs/one/impl/c/b:k	Ljava/io/File;
    //   621: invokeinterface 193 3 0
    //   626: pop
    //   627: aload 11
    //   629: ldc_w 557
    //   632: aload_0
    //   633: aload 13
    //   635: invokespecial 160	com/tencent/tbs/one/impl/c/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   638: invokeinterface 193 3 0
    //   643: pop
    //   644: aload 11
    //   646: ldc_w 559
    //   649: aload_0
    //   650: getfield 64	com/tencent/tbs/one/impl/c/b:g	Lcom/tencent/tbs/one/impl/common/d$a;
    //   653: getfield 486	com/tencent/tbs/one/impl/common/d$a:b	Ljava/lang/String;
    //   656: invokeinterface 193 3 0
    //   661: pop
    //   662: aload 11
    //   664: ldc_w 561
    //   667: iload_2
    //   668: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   671: invokeinterface 193 3 0
    //   676: pop
    //   677: aload 11
    //   679: ldc_w 563
    //   682: aload_0
    //   683: getfield 53	com/tencent/tbs/one/impl/c/b:b	Lcom/tencent/tbs/one/impl/e/h;
    //   686: getfield 566	com/tencent/tbs/one/impl/e/h:d	Lcom/tencent/tbs/one/impl/e/b;
    //   689: invokeinterface 193 3 0
    //   694: pop
    //   695: aload 10
    //   697: aload 15
    //   699: aload 14
    //   701: invokevirtual 570	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   704: iconst_1
    //   705: anewarray 572	java/lang/Class
    //   708: dup
    //   709: iconst_0
    //   710: ldc 106
    //   712: aastore
    //   713: invokevirtual 576	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   716: iconst_1
    //   717: anewarray 4	java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: aload 11
    //   724: aastore
    //   725: invokevirtual 582	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   728: putfield 584	com/tencent/tbs/one/impl/c/a:c	Ljava/lang/Object;
    //   731: invokestatic 173	java/lang/System:currentTimeMillis	()J
    //   734: lstore 6
    //   736: new 188	java/util/HashMap
    //   739: dup
    //   740: invokespecial 189	java/util/HashMap:<init>	()V
    //   743: astore 8
    //   745: aload 8
    //   747: ldc_w 586
    //   750: aload 10
    //   752: invokevirtual 589	com/tencent/tbs/one/impl/c/a:getName	()Ljava/lang/String;
    //   755: invokeinterface 193 3 0
    //   760: pop
    //   761: aload 8
    //   763: ldc_w 591
    //   766: aload 10
    //   768: invokevirtual 594	com/tencent/tbs/one/impl/c/a:getVersionCode	()I
    //   771: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: invokeinterface 193 3 0
    //   779: pop
    //   780: aload 8
    //   782: ldc_w 596
    //   785: lload 6
    //   787: lload 4
    //   789: lsub
    //   790: invokestatic 599	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   793: invokeinterface 193 3 0
    //   798: pop
    //   799: ldc_w 601
    //   802: sipush 3000
    //   805: aload 8
    //   807: invokestatic 606	com/tencent/tbs/one/impl/common/h:a	(Ljava/lang/String;ILjava/util/Map;)V
    //   810: aload_0
    //   811: aload 10
    //   813: invokespecial 608	com/tencent/tbs/one/impl/c/b:a	(Lcom/tencent/tbs/one/impl/c/a;)V
    //   816: return
    //   817: ldc_w 610
    //   820: iconst_2
    //   821: anewarray 4	java/lang/Object
    //   824: dup
    //   825: iconst_0
    //   826: aload 11
    //   828: aastore
    //   829: dup
    //   830: iconst_1
    //   831: aload 12
    //   833: aastore
    //   834: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   837: goto -379 -> 458
    //   840: astore 8
    //   842: aload_0
    //   843: aload 8
    //   845: invokevirtual 201	com/tencent/tbs/one/TBSOneException:getErrorCode	()I
    //   848: aload 8
    //   850: invokevirtual 204	com/tencent/tbs/one/TBSOneException:getMessage	()Ljava/lang/String;
    //   853: aload 8
    //   855: invokevirtual 208	com/tencent/tbs/one/TBSOneException:getCause	()Ljava/lang/Throwable;
    //   858: invokevirtual 211	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   861: return
    //   862: astore 8
    //   864: aload_0
    //   865: sipush 405
    //   868: new 120	java/lang/StringBuilder
    //   871: dup
    //   872: ldc_w 612
    //   875: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   878: aload 14
    //   880: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: ldc_w 614
    //   886: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload 13
    //   891: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: ldc_w 616
    //   897: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: aload 8
    //   902: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   905: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: aconst_null
    //   912: invokevirtual 211	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   915: return
    //   916: astore 8
    //   918: aload_0
    //   919: sipush 406
    //   922: new 120	java/lang/StringBuilder
    //   925: dup
    //   926: ldc_w 624
    //   929: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   932: aload 14
    //   934: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: ldc_w 626
    //   940: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: aload 13
    //   945: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: ldc_w 616
    //   951: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: aload 8
    //   956: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   959: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: aconst_null
    //   966: invokevirtual 211	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   969: return
    //   970: astore 8
    //   972: aload_0
    //   973: sipush 407
    //   976: new 120	java/lang/StringBuilder
    //   979: dup
    //   980: ldc_w 628
    //   983: invokespecial 123	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   986: aload 14
    //   988: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   991: ldc_w 614
    //   994: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload 13
    //   999: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: ldc_w 616
    //   1005: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: aload 8
    //   1010: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1013: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: aconst_null
    //   1020: invokevirtual 211	com/tencent/tbs/one/impl/c/b:b	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1023: return
    //   1024: ldc_w 630
    //   1027: iconst_2
    //   1028: anewarray 4	java/lang/Object
    //   1031: dup
    //   1032: iconst_0
    //   1033: aload 11
    //   1035: aastore
    //   1036: dup
    //   1037: iconst_1
    //   1038: aload 12
    //   1040: aastore
    //   1041: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1044: goto -313 -> 731
    //   1047: ldc_w 632
    //   1050: iconst_2
    //   1051: anewarray 4	java/lang/Object
    //   1054: dup
    //   1055: iconst_0
    //   1056: aload 11
    //   1058: aastore
    //   1059: dup
    //   1060: iconst_1
    //   1061: aload 12
    //   1063: aastore
    //   1064: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1067: goto -336 -> 731
    //   1070: ldc_w 634
    //   1073: iconst_2
    //   1074: anewarray 4	java/lang/Object
    //   1077: dup
    //   1078: iconst_0
    //   1079: aload 11
    //   1081: aastore
    //   1082: dup
    //   1083: iconst_1
    //   1084: aload 12
    //   1086: aastore
    //   1087: invokestatic 116	com/tencent/tbs/one/impl/a/f:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1090: goto -359 -> 731
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1093	0	this	b
    //   167	116	1	i1	int
    //   22	646	2	i2	int
    //   165	6	3	i3	int
    //   46	742	4	l1	long
    //   734	52	6	l2	long
    //   77	193	8	localObject1	Object
    //   286	14	8	localTBSOneException1	TBSOneException
    //   347	459	8	localObject2	Object
    //   840	14	8	localTBSOneException2	TBSOneException
    //   862	39	8	localClassNotFoundException	java.lang.ClassNotFoundException
    //   916	39	8	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   970	39	8	localException	java.lang.Exception
    //   234	315	9	localObject3	Object
    //   69	743	10	locala	a
    //   7	1073	11	localObject4	Object
    //   13	1072	12	str1	String
    //   130	868	13	localObject5	Object
    //   183	804	14	localObject6	Object
    //   210	488	15	localObject7	Object
    //   217	43	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   114	123	286	com/tencent/tbs/one/TBSOneException
    //   475	485	840	com/tencent/tbs/one/TBSOneException
    //   695	731	862	java/lang/ClassNotFoundException
    //   695	731	916	java/lang/NoSuchMethodException
    //   695	731	970	java/lang/Exception
  }
  
  final void b(int paramInt, String paramString, Throwable paramThrowable)
  {
    int i2 = -1;
    Object localObject = this.a;
    f.b("Failed to install or load component %s, error: [%d] %s", new Object[] { localObject, Integer.valueOf(paramInt), paramString });
    f.c("[%s] {%s} Failed to install or load component, error: [%d] %s", new Object[] { this.b.b, localObject, Integer.valueOf(paramInt), paramString, paramThrowable });
    com.tencent.tbs.one.impl.common.d locald = this.b.o;
    if (locald != null) {}
    for (int i1 = locald.a;; i1 = -1)
    {
      if (this.g != null) {
        i2 = this.g.c;
      }
      com.tencent.tbs.one.impl.common.h.a(i1, (String)localObject, i2, paramInt, paramString, paramThrowable);
      this.b.l = true;
      this.b.m = true;
      this.b.e();
      this.i = paramInt;
      this.j = paramString;
      this.g = null;
      this.n = null;
      this.k = null;
      this.l = null;
      this.h = 0;
      this.e = false;
      paramThrowable = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      this.c.clear();
      localObject = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      this.d.clear();
      i2 = paramThrowable.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramThrowable[i1].onError(paramInt, paramString);
        i1 += 1;
      }
    }
    i2 = localObject.length;
    i1 = 0;
    while (i1 < i2)
    {
      localObject[i1].onError(paramInt, paramString);
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b
 * JD-Core Version:    0.7.0.1
 */