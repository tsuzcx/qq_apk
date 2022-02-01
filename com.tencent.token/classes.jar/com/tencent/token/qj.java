package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class qj
{
  ReentrantLock a = new ReentrantLock();
  HashSet<String> b = new HashSet();
  HashSet<String> c = new HashSet();
  
  public static Intent a(e parame)
  {
    Intent localIntent;
    Iterator localIterator;
    if ((parame != null) && (parame.a != null))
    {
      localIntent = new Intent();
      if (!TextUtils.isEmpty(parame.a.a)) {
        localIntent.setAction(parame.a.a);
      }
      if (!TextUtils.isEmpty(parame.a.b)) {
        localIntent.setData(Uri.parse(parame.a.b));
      }
      if (!TextUtils.isEmpty(parame.a.c)) {
        localIntent.setType(parame.a.c);
      }
      if (!TextUtils.isEmpty(parame.a.d))
      {
        localIntent.setPackage(parame.a.d);
        if (!TextUtils.isEmpty(parame.a.e)) {
          localIntent.setClassName(parame.a.d, parame.a.e);
        }
      }
      localIntent.setFlags(parame.a.f);
      if (parame.a.g != null)
      {
        localIterator = parame.a.g.keySet().iterator();
        while (localIterator.hasNext()) {
          localIntent.addCategory((String)localIterator.next());
        }
      }
      if (parame.a.h != null) {
        localIterator = parame.a.h.iterator();
      }
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        try
        {
          switch (locala.c)
          {
          case 6: 
            localIntent.putExtra(locala.a, Short.parseShort(locala.b));
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.getMessage();
          aoc.a();
        }
        localIntent.putExtra(locala.a, Boolean.parseBoolean(locala.b));
        continue;
        localIntent.putExtra(locala.a, locala.b);
        continue;
        localIntent.putExtra(locala.a, Long.parseLong(locala.b));
        continue;
        localIntent.putExtra(locala.a, Integer.parseInt(locala.b));
      }
      else
      {
        if (!TextUtils.isEmpty(parame.a.i)) {
          localIntent.putExtra(parame.a.i, Process.myUid());
        }
        return localIntent;
        return null;
      }
    }
  }
  
  private static Pair<Boolean, Integer> a(Context paramContext, e parame, int paramInt)
  {
    if (((parame.h & 0x1) != 0) && (TextUtils.isEmpty(parame.a.a)))
    {
      "invalid solution, intent action is empty, adapterID:".concat(String.valueOf(paramInt));
      aoc.d();
      qf.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.FALSE, Integer.valueOf(0));
    }
    if (((parame.h & 0x2) != 0) && (TextUtils.isEmpty(parame.a.b)))
    {
      "invalid solution, intent uri is empty, adapterID:".concat(String.valueOf(paramInt));
      aoc.d();
      qf.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.FALSE, Integer.valueOf(0));
    }
    if (((parame.h & 0x4) != 0) && (TextUtils.isEmpty(parame.a.c)))
    {
      "invalid solution, intent type is empty, adapterID:".concat(String.valueOf(paramInt));
      aoc.d();
      qf.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.FALSE, Integer.valueOf(0));
    }
    if ((parame.h & 0x8) != 0) {
      return b(paramContext, parame, paramInt);
    }
    return new Pair(Boolean.TRUE, Integer.valueOf(0));
  }
  
  public static e a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    int i = anv.b(paramInt);
    Object localObject1 = qt.a(paramContext).a(i);
    if ((localObject1 != null) && (((k)localObject1).e != null)) {
      localObject1 = (e)any.a(((k)localObject1).e, new e());
    } else {
      localObject1 = qh.a(paramContext, i);
    }
    if (localObject1 != null)
    {
      if (((e)localObject1).a == null) {
        return null;
      }
      Object localObject2 = a(paramContext, (e)localObject1, i);
      if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
        return null;
      }
      int j = ((Integer)((Pair)localObject2).second).intValue();
      if (((e)localObject1).e == 5)
      {
        if ((((e)localObject1).p != null) && (!TextUtils.isEmpty(((e)localObject1).p.a)) && (((e)localObject1).p.b != null))
        {
          if (((e)localObject1).p.b.isEmpty()) {
            return null;
          }
          localObject2 = b(paramContext, (e)localObject1, i, j);
          if (localObject2 != null)
          {
            if (((ArrayList)localObject2).isEmpty()) {
              return null;
            }
            paramInt = 0;
            while (paramInt < ((e)localObject1).p.b.size())
            {
              ((b)((e)localObject1).p.b.get(paramInt)).a.clear();
              ((b)((e)localObject1).p.b.get(paramInt)).a.addAll((Collection)((ArrayList)localObject2).get(paramInt));
              paramInt += 1;
            }
          }
        }
        return null;
      }
      if ((((e)localObject1).f != null) && (!((e)localObject1).f.isEmpty()))
      {
        localObject2 = a(paramContext, (e)localObject1, i, j);
        if (localObject2 != null)
        {
          if (((ArrayList)localObject2).isEmpty()) {
            return null;
          }
          ((e)localObject1).f = ((ArrayList)localObject2);
        }
        else
        {
          return null;
        }
      }
      qf.a(paramContext, i, 0, j);
      return localObject1;
    }
    return null;
  }
  
  private static ArrayList<String> a(Context paramContext, e parame, int paramInt1, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getFilesDir());
    ((StringBuilder)localObject1).append("/mguide_solution");
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str2);
    if (((File)localObject1).exists())
    {
      if ((!((File)localObject1).isDirectory()) && ((!((File)localObject1).delete()) || (!((File)localObject1).mkdir()))) {
        return null;
      }
    }
    else if (!((File)localObject1).mkdir()) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = parame.f.iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      try
      {
        if (str1.contains("/")) {
          localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
        }
      }
      catch (Throwable localThrowable)
      {
        label191:
        Object localObject2;
        break label191;
      }
      localObject1 = str1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        qf.a(paramContext, paramInt1, 1, paramInt2);
        return null;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject2).exists())
      {
        localArrayList2.add(localObject2);
        localArrayList3.add(localObject1);
        localArrayList4.add(str1);
        i = 0;
      }
      else
      {
        localArrayList1.add(localObject2);
      }
    }
    if (i == 0)
    {
      if (!parame.g)
      {
        paramInt1 = 0;
        while (paramInt1 < localArrayList4.size())
        {
          a.a().a(paramContext, (String)localArrayList4.get(paramInt1), (String)localArrayList2.get(paramInt1), str2, true, false);
          paramInt1 += 1;
        }
      }
      paramInt1 = 0;
      while (paramInt1 < localArrayList2.size())
      {
        a.a().a(paramContext, (String)localArrayList3.get(paramInt1), (String)localArrayList2.get(paramInt1), str2, false);
        paramInt1 += 1;
      }
      return null;
    }
    return localArrayList1;
  }
  
  private void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    paramContext = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   4: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   14: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   17: aload_0
        //   18: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   21: invokevirtual 58	java/util/HashSet:contains	(Ljava/lang/Object;)Z
        //   24: ifne +70 -> 94
        //   27: new 60	java/io/File
        //   30: dup
        //   31: aload_0
        //   32: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   35: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
        //   38: astore 5
        //   40: aload 5
        //   42: astore 6
        //   44: aload 5
        //   46: invokevirtual 67	java/io/File:exists	()Z
        //   49: ifne +48 -> 97
        //   52: aload_0
        //   53: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   56: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   59: aload_0
        //   60: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   63: invokevirtual 70	java/util/HashSet:add	(Ljava/lang/Object;)Z
        //   66: pop
        //   67: iconst_1
        //   68: istore_2
        //   69: iconst_1
        //   70: istore_1
        //   71: new 72	java/lang/StringBuilder
        //   74: dup
        //   75: ldc 74
        //   77: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   80: aload_0
        //   81: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   84: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   87: pop
        //   88: invokestatic 83	com/tencent/token/aoc:b	()V
        //   91: goto +12 -> 103
        //   94: aconst_null
        //   95: astore 6
        //   97: iconst_0
        //   98: istore_1
        //   99: aload 6
        //   101: astore 5
        //   103: aload_0
        //   104: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   107: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   110: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   113: goto +33 -> 146
        //   116: astore 5
        //   118: aload_0
        //   119: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   122: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   125: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   128: aload 5
        //   130: athrow
        //   131: aconst_null
        //   132: astore 5
        //   134: iconst_0
        //   135: istore_1
        //   136: aload_0
        //   137: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   140: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   143: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   146: iload_1
        //   147: ifeq +444 -> 591
        //   150: new 72	java/lang/StringBuilder
        //   153: dup
        //   154: ldc 88
        //   156: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   159: aload_0
        //   160: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   163: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: pop
        //   167: invokestatic 90	com/tencent/token/aoc:c	()V
        //   170: invokestatic 96	java/lang/System:currentTimeMillis	()J
        //   173: lstore_3
        //   174: new 72	java/lang/StringBuilder
        //   177: dup
        //   178: invokespecial 97	java/lang/StringBuilder:<init>	()V
        //   181: astore 6
        //   183: aload 6
        //   185: aload_0
        //   186: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   189: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   192: pop
        //   193: aload 6
        //   195: ldc 99
        //   197: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   200: pop
        //   201: new 60	java/io/File
        //   204: dup
        //   205: aload 6
        //   207: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   210: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
        //   213: astore 6
        //   215: aload 6
        //   217: invokevirtual 67	java/io/File:exists	()Z
        //   220: ifeq +9 -> 229
        //   223: aload 6
        //   225: invokevirtual 106	java/io/File:delete	()Z
        //   228: pop
        //   229: aload 6
        //   231: invokevirtual 109	java/io/File:createNewFile	()Z
        //   234: pop
        //   235: aload_0
        //   236: getfield 28	com/tencent/token/qj$1:b	Landroid/content/Context;
        //   239: invokevirtual 115	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
        //   242: aload_0
        //   243: getfield 30	com/tencent/token/qj$1:c	Ljava/lang/String;
        //   246: invokevirtual 121	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   249: astore 7
        //   251: new 123	java/io/FileOutputStream
        //   254: dup
        //   255: aload 6
        //   257: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   260: astore 8
        //   262: sipush 1024
        //   265: newarray byte
        //   267: astore 9
        //   269: aload 7
        //   271: aload 9
        //   273: invokevirtual 132	java/io/InputStream:read	([B)I
        //   276: istore_1
        //   277: iload_1
        //   278: iconst_m1
        //   279: if_icmpeq +15 -> 294
        //   282: aload 8
        //   284: aload 9
        //   286: iconst_0
        //   287: iload_1
        //   288: invokevirtual 138	java/io/OutputStream:write	([BII)V
        //   291: goto -22 -> 269
        //   294: aload 8
        //   296: invokevirtual 141	java/io/OutputStream:flush	()V
        //   299: aload 7
        //   301: invokevirtual 144	java/io/InputStream:close	()V
        //   304: aload 8
        //   306: invokevirtual 145	java/io/OutputStream:close	()V
        //   309: aload 6
        //   311: aload 5
        //   313: invokevirtual 149	java/io/File:renameTo	(Ljava/io/File;)Z
        //   316: pop
        //   317: new 72	java/lang/StringBuilder
        //   320: dup
        //   321: ldc 151
        //   323: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   326: astore 5
        //   328: aload 5
        //   330: aload_0
        //   331: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   334: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   337: pop
        //   338: aload 5
        //   340: ldc 153
        //   342: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   345: pop
        //   346: aload 5
        //   348: invokestatic 96	java/lang/System:currentTimeMillis	()J
        //   351: lload_3
        //   352: lsub
        //   353: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   356: pop
        //   357: invokestatic 83	com/tencent/token/aoc:b	()V
        //   360: aload_0
        //   361: getfield 32	com/tencent/token/qj$1:d	Z
        //   364: ifne +227 -> 591
        //   367: aload_0
        //   368: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   371: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   374: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   377: aload_0
        //   378: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   381: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   384: aload_0
        //   385: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   388: invokevirtual 159	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   391: pop
        //   392: aload_0
        //   393: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   396: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   399: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   402: goto +189 -> 591
        //   405: astore 5
        //   407: aload_0
        //   408: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   411: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   414: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   417: aload 5
        //   419: athrow
        //   420: aload_0
        //   421: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   424: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   427: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   430: goto +161 -> 591
        //   433: astore 6
        //   435: aload 8
        //   437: astore 5
        //   439: goto +20 -> 459
        //   442: astore 6
        //   444: aconst_null
        //   445: astore 5
        //   447: goto +12 -> 459
        //   450: astore 6
        //   452: aconst_null
        //   453: astore 7
        //   455: aload 7
        //   457: astore 5
        //   459: new 72	java/lang/StringBuilder
        //   462: dup
        //   463: ldc 161
        //   465: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   468: astore 8
        //   470: aload 8
        //   472: aload_0
        //   473: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   476: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   479: pop
        //   480: aload 8
        //   482: ldc 163
        //   484: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   487: pop
        //   488: aload 8
        //   490: aload 6
        //   492: invokevirtual 166	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   495: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   498: pop
        //   499: invokestatic 83	com/tencent/token/aoc:b	()V
        //   502: aload_0
        //   503: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   506: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   509: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   512: aload_0
        //   513: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   516: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   519: aload_0
        //   520: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   523: invokevirtual 159	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   526: pop
        //   527: aload_0
        //   528: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   531: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   534: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   537: goto +28 -> 565
        //   540: astore 5
        //   542: aload_0
        //   543: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   546: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   549: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   552: aload 5
        //   554: athrow
        //   555: aload_0
        //   556: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   559: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   562: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   565: aload 7
        //   567: ifnull +11 -> 578
        //   570: aload 7
        //   572: invokevirtual 144	java/io/InputStream:close	()V
        //   575: goto +3 -> 578
        //   578: aload 5
        //   580: ifnull +11 -> 591
        //   583: aload 5
        //   585: invokevirtual 145	java/io/OutputStream:close	()V
        //   588: goto +3 -> 591
        //   591: aload_0
        //   592: getfield 32	com/tencent/token/qj$1:d	Z
        //   595: ifeq +301 -> 896
        //   598: invokestatic 96	java/lang/System:currentTimeMillis	()J
        //   601: lstore_3
        //   602: aload_0
        //   603: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   606: aload_0
        //   607: getfield 34	com/tencent/token/qj$1:e	Ljava/lang/String;
        //   610: invokestatic 171	com/tencent/token/aod:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   613: new 72	java/lang/StringBuilder
        //   616: dup
        //   617: ldc 173
        //   619: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   622: astore 5
        //   624: aload 5
        //   626: aload_0
        //   627: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   630: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   633: pop
        //   634: aload 5
        //   636: ldc 153
        //   638: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   641: pop
        //   642: aload 5
        //   644: invokestatic 96	java/lang/System:currentTimeMillis	()J
        //   647: lload_3
        //   648: lsub
        //   649: invokevirtual 156	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   652: pop
        //   653: invokestatic 83	com/tencent/token/aoc:b	()V
        //   656: aload_0
        //   657: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   660: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   663: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   666: aload_0
        //   667: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   670: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   673: aload_0
        //   674: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   677: invokevirtual 159	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   680: pop
        //   681: aload_0
        //   682: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   685: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   688: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   691: return
        //   692: astore 5
        //   694: aload_0
        //   695: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   698: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   701: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   704: aload 5
        //   706: athrow
        //   707: aload_0
        //   708: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   711: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   714: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   717: return
        //   718: astore 5
        //   720: goto +110 -> 830
        //   723: astore 5
        //   725: new 72	java/lang/StringBuilder
        //   728: dup
        //   729: ldc 175
        //   731: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   734: astore 6
        //   736: aload 6
        //   738: aload_0
        //   739: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   742: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   745: pop
        //   746: aload 6
        //   748: ldc 163
        //   750: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   753: pop
        //   754: aload 6
        //   756: aload 5
        //   758: invokevirtual 166	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   761: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   764: pop
        //   765: invokestatic 83	com/tencent/token/aoc:b	()V
        //   768: aload_0
        //   769: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   772: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   775: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   778: aload_0
        //   779: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   782: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   785: aload_0
        //   786: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   789: invokevirtual 159	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   792: pop
        //   793: aload_0
        //   794: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   797: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   800: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   803: return
        //   804: astore 5
        //   806: aload_0
        //   807: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   810: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   813: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   816: aload 5
        //   818: athrow
        //   819: aload_0
        //   820: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   823: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   826: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   829: return
        //   830: aload_0
        //   831: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   834: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   837: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   840: aload_0
        //   841: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   844: getfield 52	com/tencent/token/qj:c	Ljava/util/HashSet;
        //   847: aload_0
        //   848: getfield 26	com/tencent/token/qj$1:a	Ljava/lang/String;
        //   851: invokevirtual 159	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   854: pop
        //   855: aload_0
        //   856: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   859: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   862: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   865: goto +28 -> 893
        //   868: astore 5
        //   870: aload_0
        //   871: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   874: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   877: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   880: aload 5
        //   882: athrow
        //   883: aload_0
        //   884: getfield 24	com/tencent/token/qj$1:f	Lcom/tencent/token/qj;
        //   887: getfield 44	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   890: invokevirtual 86	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   893: aload 5
        //   895: athrow
        //   896: return
        //   897: astore 5
        //   899: goto -768 -> 131
        //   902: astore 6
        //   904: goto -770 -> 134
        //   907: astore 6
        //   909: iload_2
        //   910: istore_1
        //   911: goto -775 -> 136
        //   914: astore 5
        //   916: goto -496 -> 420
        //   919: astore 6
        //   921: goto -366 -> 555
        //   924: astore 6
        //   926: goto -348 -> 578
        //   929: astore 5
        //   931: goto -340 -> 591
        //   934: astore 5
        //   936: goto -229 -> 707
        //   939: astore 5
        //   941: goto -122 -> 819
        //   944: astore 6
        //   946: goto -63 -> 883
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	949	0	this	1
        //   70	841	1	i	int
        //   68	842	2	j	int
        //   173	475	3	l	long
        //   38	64	5	localObject1	Object
        //   116	13	5	localObject2	Object
        //   132	215	5	localObject3	Object
        //   405	13	5	localObject4	Object
        //   437	21	5	localObject5	Object
        //   540	44	5	localObject6	Object
        //   622	21	5	localStringBuilder1	StringBuilder
        //   692	13	5	localObject7	Object
        //   718	1	5	localObject8	Object
        //   723	34	5	localThrowable1	Throwable
        //   804	13	5	localObject9	Object
        //   868	26	5	localObject10	Object
        //   897	1	5	localThrowable2	Throwable
        //   914	1	5	localThrowable3	Throwable
        //   929	1	5	localThrowable4	Throwable
        //   934	1	5	localThrowable5	Throwable
        //   939	1	5	localThrowable6	Throwable
        //   42	268	6	localObject11	Object
        //   433	1	6	localThrowable7	Throwable
        //   442	1	6	localThrowable8	Throwable
        //   450	41	6	localThrowable9	Throwable
        //   734	21	6	localStringBuilder2	StringBuilder
        //   902	1	6	localThrowable10	Throwable
        //   907	1	6	localThrowable11	Throwable
        //   919	1	6	localThrowable12	Throwable
        //   924	1	6	localThrowable13	Throwable
        //   944	1	6	localThrowable14	Throwable
        //   249	322	7	localInputStream	java.io.InputStream
        //   260	229	8	localObject12	Object
        //   267	18	9	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   10	40	116	finally
        //   44	67	116	finally
        //   71	91	116	finally
        //   377	392	405	finally
        //   262	269	433	java/lang/Throwable
        //   269	277	433	java/lang/Throwable
        //   282	291	433	java/lang/Throwable
        //   294	377	433	java/lang/Throwable
        //   392	402	433	java/lang/Throwable
        //   407	420	433	java/lang/Throwable
        //   420	430	433	java/lang/Throwable
        //   251	262	442	java/lang/Throwable
        //   170	229	450	java/lang/Throwable
        //   229	251	450	java/lang/Throwable
        //   512	527	540	finally
        //   666	681	692	finally
        //   598	656	718	finally
        //   725	768	718	finally
        //   598	656	723	java/lang/Throwable
        //   778	793	804	finally
        //   840	855	868	finally
        //   10	40	897	java/lang/Throwable
        //   44	67	902	java/lang/Throwable
        //   71	91	907	java/lang/Throwable
        //   377	392	914	java/lang/Throwable
        //   512	527	919	java/lang/Throwable
        //   570	575	924	java/lang/Throwable
        //   583	588	929	java/lang/Throwable
        //   666	681	934	java/lang/Throwable
        //   778	793	939	java/lang/Throwable
        //   840	855	944	java/lang/Throwable
      }
    };
    qp.a.a().a().a(paramContext, "Move");
  }
  
  private static Pair<Boolean, Integer> b(Context paramContext, e parame, int paramInt)
  {
    Object localObject2;
    PackageManager localPackageManager;
    Object localObject1;
    if ((!TextUtils.isEmpty(parame.a.d)) && (!TextUtils.isEmpty(parame.a.e)))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setClassName(parame.a.d, parame.a.e);
      localPackageManager = paramContext.getPackageManager();
      localObject1 = null;
    }
    try
    {
      localPackageInfo = paramContext.getPackageManager().getPackageInfo(parame.a.d, 0);
    }
    catch (Throwable localThrowable1)
    {
      PackageInfo localPackageInfo;
      label87:
      int i;
      break label87;
    }
    localPackageInfo = null;
    if (localPackageInfo != null) {
      i = localPackageInfo.versionCode;
    } else {
      i = 0;
    }
    try
    {
      localObject2 = localPackageManager.resolveActivity((Intent)localObject2, 0);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable2)
    {
      label120:
      int j;
      break label120;
    }
    if ((localObject1 != null) && (localObject1.activityInfo != null))
    {
      if ((!paramContext.getPackageName().equals(parame.a.d)) && (!localObject1.activityInfo.exported))
      {
        "invalid solution, intent activityInfo package is not exported, adapterID:".concat(String.valueOf(paramInt));
        aoc.d();
        qf.a(paramContext, paramInt, 1, i);
        return new Pair(Boolean.FALSE, Integer.valueOf(i));
      }
      if ((!TextUtils.isEmpty(localObject1.activityInfo.permission)) && (localPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) == -1))
      {
        "invalid solution, intent activityInfo permission is denied, adapterID:".concat(String.valueOf(paramInt));
        aoc.d();
        qf.a(paramContext, paramInt, 1, i);
        return new Pair(Boolean.FALSE, Integer.valueOf(i));
      }
      j = localPackageManager.getApplicationEnabledSetting(parame.a.d);
      if ((j != 2) && (j != 3) && (j != 4))
      {
        if ((parame.d != null) && (!parame.d.isEmpty()))
        {
          if (localPackageInfo == null)
          {
            "invalid solution, intent pkgInfo is null, adapterID:".concat(String.valueOf(paramInt));
            aoc.d();
            qf.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.FALSE, Integer.valueOf(i));
          }
          if (parame.d.containsKey(Integer.valueOf(i)))
          {
            paramContext = (String)parame.d.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(paramContext)) {
              parame.b = paramContext;
            }
          }
          else
          {
            "invalid solution, intent pkgVerCode is wrong, adapterID:".concat(String.valueOf(paramInt));
            aoc.d();
            qf.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.FALSE, Integer.valueOf(i));
          }
        }
        return new Pair(Boolean.TRUE, Integer.valueOf(i));
      }
      "invalid solution, intent package state is disabled, adapterID:".concat(String.valueOf(paramInt));
      aoc.d();
      qf.a(paramContext, paramInt, 1, i);
      return new Pair(Boolean.FALSE, Integer.valueOf(i));
    }
    "invalid solution, intent resolveActivity intentInfo or activityInfo is null, adapterID:".concat(String.valueOf(paramInt));
    aoc.d();
    qf.a(paramContext, paramInt, 1, i);
    return new Pair(Boolean.FALSE, Integer.valueOf(i));
    "invalid solution, intent package or class is empty, adapterID:".concat(String.valueOf(paramInt));
    aoc.d();
    return new Pair(Boolean.FALSE, Integer.valueOf(0));
  }
  
  private static ArrayList<ArrayList<String>> b(Context paramContext, e parame, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getFilesDir());
    ((StringBuilder)localObject1).append("/mguide_solution");
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str2);
    if (((File)localObject1).exists())
    {
      if ((!((File)localObject1).isDirectory()) && ((!((File)localObject1).delete()) || (!((File)localObject1).mkdir()))) {
        return null;
      }
    }
    else if (!((File)localObject1).mkdir()) {
      return null;
    }
    String str1 = parame.p.a;
    try
    {
      if (str1.contains("/")) {
        localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
      }
    }
    catch (Throwable localThrowable1)
    {
      label139:
      Object localObject2;
      Object localObject3;
      String str3;
      int j;
      int i;
      int k;
      ArrayList localArrayList2;
      Object localObject4;
      break label139;
    }
    localObject1 = str1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      qf.a(paramContext, paramInt1, 1, paramInt2);
      return null;
    }
    if (((String)localObject1).contains(".")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("."));
    } else {
      localObject2 = localObject1;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(str2);
    ((StringBuilder)localObject3).append("/");
    ((StringBuilder)localObject3).append((String)localObject1);
    str3 = ((StringBuilder)localObject3).toString();
    j = parame.p.b.size();
    i = 0;
    if (i < j)
    {
      localObject3 = ((b)parame.p.b.get(i)).a;
      k = ((b)parame.p.b.get(i)).b;
      if (((k != 1) && (k != 2)) || ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty())))
      {
        localArrayList2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        label341:
        if (((Iterator)localObject3).hasNext()) {
          localObject4 = (String)((Iterator)localObject3).next();
        }
      }
    }
    try
    {
      if (((String)localObject4).contains("/")) {
        k = ((String)localObject4).lastIndexOf("/");
      }
    }
    catch (Throwable localThrowable2)
    {
      Object localObject5;
      label402:
      label537:
      break label402;
    }
    try
    {
      localObject5 = ((String)localObject4).substring(k + 1);
      localObject4 = localObject5;
    }
    catch (Throwable localThrowable3)
    {
      break label402;
    }
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      qf.a(paramContext, paramInt1, 1, paramInt2);
    }
    for (;;)
    {
      return null;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(str2);
      ((StringBuilder)localObject5).append("/");
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append("/");
      ((StringBuilder)localObject5).append((String)localObject4);
      localObject4 = ((StringBuilder)localObject5).toString();
      if (!new File((String)localObject4).exists())
      {
        paramInt1 = 0;
        break label537;
      }
      localArrayList2.add(localObject4);
      break label341;
      localArrayList1.add(localArrayList2);
      i += 1;
      break;
      qf.a(paramContext, paramInt1, 1, paramInt2);
    }
    paramInt1 = 1;
    if (paramInt1 == 0)
    {
      if (!parame.g)
      {
        a.a().a(paramContext, str1, str3, str2, true, true);
        return null;
      }
      a.a().a(paramContext, (String)localObject1, str3, str2, true);
      return null;
    }
    return localArrayList1;
  }
  
  final void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    paramContext = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   4: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aconst_null
        //   11: astore 4
        //   13: aload_0
        //   14: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   17: getfield 55	com/tencent/token/qj:b	Ljava/util/HashSet;
        //   20: aload_0
        //   21: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   24: invokevirtual 61	java/util/HashSet:contains	(Ljava/lang/Object;)Z
        //   27: ifne +44 -> 71
        //   30: new 63	java/io/File
        //   33: dup
        //   34: aload_0
        //   35: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   38: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
        //   41: astore_2
        //   42: aload_2
        //   43: astore_3
        //   44: aload_2
        //   45: invokevirtual 70	java/io/File:exists	()Z
        //   48: ifne +25 -> 73
        //   51: aload_0
        //   52: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   55: getfield 55	com/tencent/token/qj:b	Ljava/util/HashSet;
        //   58: aload_0
        //   59: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   62: invokevirtual 73	java/util/HashSet:add	(Ljava/lang/Object;)Z
        //   65: pop
        //   66: iconst_1
        //   67: istore_1
        //   68: goto +9 -> 77
        //   71: aconst_null
        //   72: astore_3
        //   73: iconst_0
        //   74: istore_1
        //   75: aload_3
        //   76: astore_2
        //   77: aload_0
        //   78: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   81: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   84: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   87: goto +30 -> 117
        //   90: astore_2
        //   91: aload_0
        //   92: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   95: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   98: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   101: aload_2
        //   102: athrow
        //   103: aconst_null
        //   104: astore_2
        //   105: aload_0
        //   106: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   109: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   112: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   115: iconst_0
        //   116: istore_1
        //   117: iload_1
        //   118: ifeq +437 -> 555
        //   121: new 78	java/lang/StringBuilder
        //   124: dup
        //   125: ldc 80
        //   127: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   130: aload_0
        //   131: getfield 29	com/tencent/token/qj$2:b	Ljava/lang/String;
        //   134: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   137: pop
        //   138: invokestatic 89	com/tencent/token/aoc:c	()V
        //   141: new 91	java/net/URL
        //   144: dup
        //   145: aload_0
        //   146: getfield 29	com/tencent/token/qj$2:b	Ljava/lang/String;
        //   149: invokespecial 92	java/net/URL:<init>	(Ljava/lang/String;)V
        //   152: invokevirtual 96	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   155: checkcast 98	java/net/HttpURLConnection
        //   158: astore_3
        //   159: new 78	java/lang/StringBuilder
        //   162: dup
        //   163: invokespecial 99	java/lang/StringBuilder:<init>	()V
        //   166: astore 5
        //   168: aload 5
        //   170: aload_0
        //   171: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   174: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: pop
        //   178: aload 5
        //   180: ldc 101
        //   182: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: pop
        //   186: new 63	java/io/File
        //   189: dup
        //   190: aload 5
        //   192: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   195: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
        //   198: astore 6
        //   200: aload 6
        //   202: invokevirtual 70	java/io/File:exists	()Z
        //   205: ifeq +9 -> 214
        //   208: aload 6
        //   210: invokevirtual 108	java/io/File:delete	()Z
        //   213: pop
        //   214: aload 6
        //   216: invokevirtual 111	java/io/File:createNewFile	()Z
        //   219: pop
        //   220: aload_3
        //   221: invokevirtual 115	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   224: astore_3
        //   225: new 117	java/io/FileOutputStream
        //   228: dup
        //   229: aload 6
        //   231: invokespecial 120	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   234: astore 5
        //   236: sipush 4096
        //   239: newarray byte
        //   241: astore 4
        //   243: aload_3
        //   244: aload 4
        //   246: invokevirtual 126	java/io/InputStream:read	([B)I
        //   249: istore_1
        //   250: iload_1
        //   251: iconst_m1
        //   252: if_icmpeq +15 -> 267
        //   255: aload 5
        //   257: aload 4
        //   259: iconst_0
        //   260: iload_1
        //   261: invokevirtual 130	java/io/FileOutputStream:write	([BII)V
        //   264: goto -21 -> 243
        //   267: aload 5
        //   269: invokevirtual 133	java/io/FileOutputStream:flush	()V
        //   272: aload_3
        //   273: invokevirtual 136	java/io/InputStream:close	()V
        //   276: aload 5
        //   278: invokevirtual 137	java/io/FileOutputStream:close	()V
        //   281: aload 6
        //   283: aload_2
        //   284: invokevirtual 141	java/io/File:renameTo	(Ljava/io/File;)Z
        //   287: pop
        //   288: new 78	java/lang/StringBuilder
        //   291: dup
        //   292: ldc 143
        //   294: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   297: aload_0
        //   298: getfield 29	com/tencent/token/qj$2:b	Ljava/lang/String;
        //   301: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   304: pop
        //   305: invokestatic 89	com/tencent/token/aoc:c	()V
        //   308: aload_0
        //   309: getfield 31	com/tencent/token/qj$2:c	Z
        //   312: ifeq +54 -> 366
        //   315: new 78	java/lang/StringBuilder
        //   318: dup
        //   319: ldc 145
        //   321: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   324: aload_0
        //   325: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   328: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   331: pop
        //   332: invokestatic 89	com/tencent/token/aoc:c	()V
        //   335: aload_0
        //   336: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   339: aload_0
        //   340: getfield 33	com/tencent/token/qj$2:d	Ljava/lang/String;
        //   343: invokestatic 150	com/tencent/token/aod:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   346: new 78	java/lang/StringBuilder
        //   349: dup
        //   350: ldc 152
        //   352: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   355: aload_0
        //   356: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   359: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   362: pop
        //   363: invokestatic 89	com/tencent/token/aoc:c	()V
        //   366: aload_0
        //   367: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   370: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   373: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   376: aload_0
        //   377: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   380: getfield 55	com/tencent/token/qj:b	Ljava/util/HashSet;
        //   383: aload_0
        //   384: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   387: invokevirtual 155	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   390: pop
        //   391: aload_0
        //   392: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   395: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   398: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   401: return
        //   402: astore_2
        //   403: aload_0
        //   404: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   407: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   410: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   413: aload_2
        //   414: athrow
        //   415: aload_0
        //   416: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   419: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   422: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   425: return
        //   426: aload 5
        //   428: astore_2
        //   429: goto +8 -> 437
        //   432: aconst_null
        //   433: astore_3
        //   434: aload 4
        //   436: astore_2
        //   437: aload_0
        //   438: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   441: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   444: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   447: aload_0
        //   448: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   451: getfield 55	com/tencent/token/qj:b	Ljava/util/HashSet;
        //   454: aload_0
        //   455: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   458: invokevirtual 155	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   461: pop
        //   462: aload_0
        //   463: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   466: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   469: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   472: goto +26 -> 498
        //   475: astore_2
        //   476: aload_0
        //   477: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   480: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   483: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   486: aload_2
        //   487: athrow
        //   488: aload_0
        //   489: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   492: getfield 47	com/tencent/token/qj:a	Ljava/util/concurrent/locks/ReentrantLock;
        //   495: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   498: aload_3
        //   499: ifnull +10 -> 509
        //   502: aload_3
        //   503: invokevirtual 136	java/io/InputStream:close	()V
        //   506: goto +3 -> 509
        //   509: aload_2
        //   510: ifnull +10 -> 520
        //   513: aload_2
        //   514: invokevirtual 137	java/io/FileOutputStream:close	()V
        //   517: goto +3 -> 520
        //   520: aload_0
        //   521: getfield 35	com/tencent/token/qj$2:e	Z
        //   524: ifeq +31 -> 555
        //   527: aload_0
        //   528: getfield 25	com/tencent/token/qj$2:g	Lcom/tencent/token/qj;
        //   531: aload_0
        //   532: getfield 37	com/tencent/token/qj$2:f	Landroid/content/Context;
        //   535: aload_0
        //   536: getfield 29	com/tencent/token/qj$2:b	Ljava/lang/String;
        //   539: aload_0
        //   540: getfield 27	com/tencent/token/qj$2:a	Ljava/lang/String;
        //   543: aload_0
        //   544: getfield 33	com/tencent/token/qj$2:d	Ljava/lang/String;
        //   547: iconst_0
        //   548: aload_0
        //   549: getfield 31	com/tencent/token/qj$2:c	Z
        //   552: invokevirtual 156	com/tencent/token/qj:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
        //   555: return
        //   556: astore_2
        //   557: goto -454 -> 103
        //   560: astore_3
        //   561: goto -456 -> 105
        //   564: astore_2
        //   565: goto -133 -> 432
        //   568: astore_2
        //   569: aload 4
        //   571: astore_2
        //   572: goto -135 -> 437
        //   575: astore_2
        //   576: goto -150 -> 426
        //   579: astore_2
        //   580: goto -165 -> 415
        //   583: astore 4
        //   585: goto -97 -> 488
        //   588: astore_3
        //   589: goto -80 -> 509
        //   592: astore_2
        //   593: goto -73 -> 520
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	596	0	this	2
        //   67	194	1	i	int
        //   41	36	2	localObject1	Object
        //   90	12	2	localObject2	Object
        //   104	180	2	localFile1	File
        //   402	12	2	localObject3	Object
        //   428	9	2	localObject4	Object
        //   475	39	2	localObject5	Object
        //   556	1	2	localThrowable1	Throwable
        //   564	1	2	localThrowable2	Throwable
        //   568	1	2	localThrowable3	Throwable
        //   571	1	2	arrayOfByte1	byte[]
        //   575	1	2	localThrowable4	Throwable
        //   579	1	2	localThrowable5	Throwable
        //   592	1	2	localThrowable6	Throwable
        //   43	460	3	localObject6	Object
        //   560	1	3	localThrowable7	Throwable
        //   588	1	3	localThrowable8	Throwable
        //   11	559	4	arrayOfByte2	byte[]
        //   583	1	4	localThrowable9	Throwable
        //   166	261	5	localObject7	Object
        //   198	84	6	localFile2	File
        // Exception table:
        //   from	to	target	type
        //   13	42	90	finally
        //   44	66	90	finally
        //   376	391	402	finally
        //   447	462	475	finally
        //   13	42	556	java/lang/Throwable
        //   44	66	560	java/lang/Throwable
        //   141	214	564	java/lang/Throwable
        //   214	225	564	java/lang/Throwable
        //   225	236	568	java/lang/Throwable
        //   236	243	575	java/lang/Throwable
        //   243	250	575	java/lang/Throwable
        //   255	264	575	java/lang/Throwable
        //   267	366	575	java/lang/Throwable
        //   366	376	575	java/lang/Throwable
        //   391	401	575	java/lang/Throwable
        //   403	415	575	java/lang/Throwable
        //   415	425	575	java/lang/Throwable
        //   376	391	579	java/lang/Throwable
        //   447	462	583	java/lang/Throwable
        //   502	506	588	java/lang/Throwable
        //   513	517	592	java/lang/Throwable
      }
    };
    qp.a.a().a().a(paramContext, "Download");
  }
  
  static final class a
  {
    private static qj a = new qj((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qj
 * JD-Core Version:    0.7.0.1
 */