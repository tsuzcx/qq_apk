package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.bugly.crashreport.common.info.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class n
{
  private static n a = null;
  private Context b;
  private String c;
  private SharedPreferences d;
  
  static
  {
    System.currentTimeMillis();
  }
  
  private n(Context paramContext)
  {
    this.b = paramContext;
    new HashMap();
    this.c = a.b().d;
    this.d = paramContext.getSharedPreferences("crashrecord", 0);
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new n(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private <T extends List<?>> void a(int paramInt, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: new 62	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: getfield 29	com/tencent/bugly/proguard/n:b	Landroid/content/Context;
    //   17: ldc 43
    //   19: iconst_0
    //   20: invokevirtual 66	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   23: new 68	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   30: iload_1
    //   31: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_3
    //   41: new 82	java/io/ObjectOutputStream
    //   44: dup
    //   45: new 84	java/io/FileOutputStream
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 87	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 90	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore 4
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: aload_2
    //   64: invokevirtual 94	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   67: aload 4
    //   69: invokevirtual 97	java/io/ObjectOutputStream:close	()V
    //   72: goto -66 -> 6
    //   75: astore_2
    //   76: ldc 99
    //   78: iconst_0
    //   79: anewarray 4	java/lang/Object
    //   82: invokestatic 105	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   85: pop
    //   86: goto -80 -> 6
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: astore 5
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_2
    //   99: astore_3
    //   100: aload 5
    //   102: invokevirtual 108	java/io/IOException:printStackTrace	()V
    //   105: aload_2
    //   106: astore_3
    //   107: ldc 110
    //   109: iconst_0
    //   110: anewarray 4	java/lang/Object
    //   113: invokestatic 112	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   116: pop
    //   117: aload_2
    //   118: ifnull -112 -> 6
    //   121: aload_2
    //   122: invokevirtual 97	java/io/ObjectOutputStream:close	()V
    //   125: goto -119 -> 6
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 97	java/io/ObjectOutputStream:close	()V
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: goto -11 -> 128
    //   142: astore 5
    //   144: aload 4
    //   146: astore_2
    //   147: goto -49 -> 98
    //   150: astore_2
    //   151: aconst_null
    //   152: astore_3
    //   153: goto -25 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	n
    //   0	156	1	paramInt	int
    //   0	156	2	paramT	T
    //   40	113	3	localObject	Object
    //   56	89	4	localObjectOutputStream	java.io.ObjectOutputStream
    //   94	7	5	localIOException1	java.io.IOException
    //   142	1	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   9	41	75	java/lang/Exception
    //   67	72	75	java/lang/Exception
    //   121	125	75	java/lang/Exception
    //   132	136	75	java/lang/Exception
    //   136	138	75	java/lang/Exception
    //   9	41	89	finally
    //   67	72	89	finally
    //   76	86	89	finally
    //   121	125	89	finally
    //   132	136	89	finally
    //   136	138	89	finally
    //   41	58	94	java/io/IOException
    //   61	67	138	finally
    //   100	105	138	finally
    //   107	117	138	finally
    //   61	67	142	java/io/IOException
    //   41	58	150	finally
  }
  
  private boolean b(int paramInt)
  {
    for (;;)
    {
      boolean bool;
      try
      {
        localList = c(paramInt);
        if (localList != null) {
          continue;
        }
        bool = false;
      }
      catch (Exception localException)
      {
        List localList;
        long l;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        Iterator localIterator;
        m localm;
        x.e("isFrequentCrash failed", new Object[0]);
        bool = false;
        continue;
        Collections.sort(localArrayList1);
        if (localArrayList1.size() < 2) {
          continue;
        }
        if (localArrayList1.size() <= 0) {
          break label210;
        }
        localArrayList1.get(localArrayList1.size() - 1);
        if (86400000L >= l) {
          break label210;
        }
        localException.clear();
        a(paramInt, localException);
        bool = false;
        continue;
        localException.removeAll(localArrayList2);
        a(paramInt, localException);
        bool = false;
        continue;
      }
      finally {}
      return bool;
      l = System.currentTimeMillis();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localIterator = localList.iterator();
      if (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (86400000L < l) {
          localArrayList2.add(localm);
        }
      }
      else
      {
        label210:
        bool = true;
      }
    }
  }
  
  /* Error */
  private <T extends List<?>> T c(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 62	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 29	com/tencent/bugly/proguard/n:b	Landroid/content/Context;
    //   10: ldc 43
    //   12: iconst_0
    //   13: invokevirtual 66	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   16: new 68	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   23: iload_1
    //   24: invokevirtual 73	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 80	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: invokevirtual 179	java/io/File:exists	()Z
    //   38: istore_2
    //   39: iload_2
    //   40: ifne +9 -> 49
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: new 181	java/io/ObjectInputStream
    //   52: dup
    //   53: new 183	java/io/FileInputStream
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 187	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: invokevirtual 190	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   74: checkcast 127	java/util/List
    //   77: astore 5
    //   79: aload 4
    //   81: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   84: aload 5
    //   86: astore_3
    //   87: goto -42 -> 45
    //   90: astore_3
    //   91: ldc 193
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 105	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   100: pop
    //   101: aconst_null
    //   102: astore_3
    //   103: goto -58 -> 45
    //   106: astore_3
    //   107: aconst_null
    //   108: astore_3
    //   109: ldc 110
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 112	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   118: pop
    //   119: aload_3
    //   120: ifnull -19 -> 101
    //   123: aload_3
    //   124: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   127: goto -26 -> 101
    //   130: astore_3
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: aconst_null
    //   137: astore 4
    //   139: aload 4
    //   141: astore_3
    //   142: ldc 195
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 112	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   151: pop
    //   152: aload 4
    //   154: ifnull -53 -> 101
    //   157: aload 4
    //   159: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   162: goto -61 -> 101
    //   165: aload_3
    //   166: ifnull +7 -> 173
    //   169: aload_3
    //   170: invokevirtual 191	java/io/ObjectInputStream:close	()V
    //   173: aload 4
    //   175: athrow
    //   176: astore 4
    //   178: goto -13 -> 165
    //   181: astore 4
    //   183: goto -18 -> 165
    //   186: astore_3
    //   187: goto -48 -> 139
    //   190: astore_3
    //   191: aload 4
    //   193: astore_3
    //   194: goto -85 -> 109
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_3
    //   201: goto -36 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	n
    //   0	204	1	paramInt	int
    //   38	2	2	bool	boolean
    //   33	54	3	localObject1	Object
    //   90	1	3	localException	Exception
    //   102	1	3	localObject2	Object
    //   106	1	3	localIOException1	java.io.IOException
    //   108	16	3	localObject3	Object
    //   130	4	3	localObject4	Object
    //   135	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   141	29	3	localObject5	Object
    //   186	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   190	1	3	localIOException2	java.io.IOException
    //   193	8	3	localObject6	Object
    //   64	110	4	localObjectInputStream	java.io.ObjectInputStream
    //   176	1	4	localObject7	Object
    //   181	11	4	localObject8	Object
    //   197	1	4	localObject9	Object
    //   77	8	5	localList	List
    // Exception table:
    //   from	to	target	type
    //   2	39	90	java/lang/Exception
    //   79	84	90	java/lang/Exception
    //   123	127	90	java/lang/Exception
    //   157	162	90	java/lang/Exception
    //   169	173	90	java/lang/Exception
    //   173	176	90	java/lang/Exception
    //   49	66	106	java/io/IOException
    //   2	39	130	finally
    //   79	84	130	finally
    //   91	101	130	finally
    //   123	127	130	finally
    //   157	162	130	finally
    //   169	173	130	finally
    //   173	176	130	finally
    //   49	66	135	java/lang/ClassNotFoundException
    //   69	79	176	finally
    //   142	152	176	finally
    //   109	119	181	finally
    //   69	79	186	java/lang/ClassNotFoundException
    //   69	79	190	java/io/IOException
    //   49	66	197	finally
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = this.d.getBoolean(paramInt + "_" + this.c, true);
      bool1 = bool2;
      w.a().a(new n.1(this, paramInt));
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        x.e("canInit error", new Object[0]);
      }
    }
    finally {}
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.n
 * JD-Core Version:    0.7.0.1
 */