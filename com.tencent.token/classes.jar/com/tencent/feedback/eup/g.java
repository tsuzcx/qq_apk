package com.tencent.feedback.eup;

import android.content.Context;
import com.tencent.feedback.common.PlugInInfo;
import com.tencent.feedback.common.c;
import com.tencent.feedback.proguard.I;
import com.tencent.feedback.proguard.K;
import com.tencent.feedback.proguard.L;
import com.tencent.feedback.proguard.M;
import com.tencent.feedback.proguard.N;
import com.tencent.feedback.proguard.a;
import com.tencent.feedback.proguard.j;
import com.tencent.feedback.proguard.l;
import com.tencent.feedback.proguard.o;
import com.tencent.feedback.upload.AbstractUploadDatas;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
  extends AbstractUploadDatas
{
  private static g d = null;
  private N e = null;
  private List<e> f = null;
  
  private g(Context paramContext)
  {
    super(paramContext, 3, 530);
  }
  
  public static g a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      if (d == null) {
        d = new g(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private static K a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +15 -> 20
    //   8: ldc 36
    //   10: iconst_0
    //   11: anewarray 38	java/lang/Object
    //   14: invokestatic 44	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   17: pop
    //   18: aconst_null
    //   19: areturn
    //   20: ldc 46
    //   22: iconst_1
    //   23: anewarray 38	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: new 51	java/io/File
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_2
    //   43: new 51	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokevirtual 60	android/content/Context:getCacheDir	()Ljava/io/File;
    //   51: aload_0
    //   52: invokespecial 63	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 4
    //   57: aload_2
    //   58: aload 4
    //   60: sipush 5000
    //   63: invokestatic 68	com/tencent/feedback/proguard/a:a	(Ljava/io/File;Ljava/io/File;I)Z
    //   66: ifne +15 -> 81
    //   69: ldc 70
    //   71: iconst_0
    //   72: anewarray 38	java/lang/Object
    //   75: invokestatic 44	com/tencent/feedback/common/e:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: aconst_null
    //   80: areturn
    //   81: new 72	java/io/ByteArrayOutputStream
    //   84: dup
    //   85: invokespecial 74	java/io/ByteArrayOutputStream:<init>	()V
    //   88: astore_2
    //   89: new 76	java/io/FileInputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 79	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore_1
    //   99: aload_1
    //   100: astore_0
    //   101: sipush 1000
    //   104: newarray byte
    //   106: astore 5
    //   108: aload_1
    //   109: astore_0
    //   110: aload_1
    //   111: aload 5
    //   113: invokevirtual 83	java/io/FileInputStream:read	([B)I
    //   116: istore_3
    //   117: iload_3
    //   118: ifle +72 -> 190
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: aload 5
    //   126: iconst_0
    //   127: iload_3
    //   128: invokevirtual 87	java/io/ByteArrayOutputStream:write	([BII)V
    //   131: aload_1
    //   132: astore_0
    //   133: aload_2
    //   134: invokevirtual 90	java/io/ByteArrayOutputStream:flush	()V
    //   137: goto -29 -> 108
    //   140: astore_2
    //   141: aload_1
    //   142: astore_0
    //   143: aload_2
    //   144: invokestatic 93	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   147: ifne +9 -> 156
    //   150: aload_1
    //   151: astore_0
    //   152: aload_2
    //   153: invokevirtual 96	java/lang/Throwable:printStackTrace	()V
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 99	java/io/FileInputStream:close	()V
    //   164: aload 4
    //   166: invokevirtual 103	java/io/File:exists	()Z
    //   169: ifeq -151 -> 18
    //   172: ldc 105
    //   174: iconst_0
    //   175: anewarray 38	java/lang/Object
    //   178: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload 4
    //   184: invokevirtual 108	java/io/File:delete	()Z
    //   187: pop
    //   188: aconst_null
    //   189: areturn
    //   190: aload_1
    //   191: astore_0
    //   192: aload_2
    //   193: invokevirtual 112	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   196: astore_2
    //   197: aload_1
    //   198: astore_0
    //   199: ldc 114
    //   201: iconst_1
    //   202: anewarray 38	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_2
    //   208: arraylength
    //   209: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: aastore
    //   213: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload_1
    //   218: astore_0
    //   219: new 122	com/tencent/feedback/proguard/K
    //   222: dup
    //   223: iconst_2
    //   224: aload 4
    //   226: invokevirtual 126	java/io/File:getName	()Ljava/lang/String;
    //   229: aload_2
    //   230: invokespecial 129	com/tencent/feedback/proguard/K:<init>	(BLjava/lang/String;[B)V
    //   233: astore_2
    //   234: aload_1
    //   235: invokevirtual 99	java/io/FileInputStream:close	()V
    //   238: aload 4
    //   240: invokevirtual 103	java/io/File:exists	()Z
    //   243: ifeq +19 -> 262
    //   246: ldc 105
    //   248: iconst_0
    //   249: anewarray 38	java/lang/Object
    //   252: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   255: pop
    //   256: aload 4
    //   258: invokevirtual 108	java/io/File:delete	()Z
    //   261: pop
    //   262: aload_2
    //   263: areturn
    //   264: astore_0
    //   265: aload_0
    //   266: invokestatic 93	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   269: ifne -31 -> 238
    //   272: aload_0
    //   273: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   276: goto -38 -> 238
    //   279: astore_0
    //   280: aload_0
    //   281: invokestatic 93	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   284: ifne -120 -> 164
    //   287: aload_0
    //   288: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   291: goto -127 -> 164
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_0
    //   297: aload_0
    //   298: ifnull +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 99	java/io/FileInputStream:close	()V
    //   305: aload 4
    //   307: invokevirtual 103	java/io/File:exists	()Z
    //   310: ifeq +19 -> 329
    //   313: ldc 105
    //   315: iconst_0
    //   316: anewarray 38	java/lang/Object
    //   319: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload 4
    //   325: invokevirtual 108	java/io/File:delete	()Z
    //   328: pop
    //   329: aload_1
    //   330: athrow
    //   331: astore_0
    //   332: aload_0
    //   333: invokestatic 93	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   336: ifne -31 -> 305
    //   339: aload_0
    //   340: invokevirtual 130	java/io/IOException:printStackTrace	()V
    //   343: goto -38 -> 305
    //   346: astore_1
    //   347: goto -50 -> 297
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -212 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString1	String
    //   0	356	1	paramContext	Context
    //   0	356	2	paramString2	String
    //   116	12	3	i	int
    //   55	269	4	localFile	java.io.File
    //   106	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   101	108	140	java/lang/Throwable
    //   110	117	140	java/lang/Throwable
    //   123	131	140	java/lang/Throwable
    //   133	137	140	java/lang/Throwable
    //   192	197	140	java/lang/Throwable
    //   199	217	140	java/lang/Throwable
    //   219	234	140	java/lang/Throwable
    //   234	238	264	java/io/IOException
    //   160	164	279	java/io/IOException
    //   89	99	294	finally
    //   301	305	331	java/io/IOException
    //   101	108	346	finally
    //   110	117	346	finally
    //   123	131	346	finally
    //   133	137	346	finally
    //   143	150	346	finally
    //   152	156	346	finally
    //   192	197	346	finally
    //   199	217	346	finally
    //   219	234	346	finally
    //   89	99	350	java/lang/Throwable
  }
  
  private static K a(byte[] paramArrayOfByte, String paramString)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0) || (paramString == null) || (paramString.trim().length() <= 0)) {
      return null;
    }
    try
    {
      K localK = new K();
      localK.a = 1;
      localK.b = paramString;
      localK.c = paramArrayOfByte;
      return localK;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!com.tencent.feedback.common.e.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  private L a(Context paramContext, e parame)
  {
    if (parame == null)
    {
      com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
      return null;
    }
    com.tencent.feedback.common.e.b("rqdp{  pack n:}%s , rqdp{  iM:}%b , rqdp{  tp:}%d", new Object[] { parame.f(), Boolean.valueOf(parame.c()), Byte.valueOf(parame.P()) });
    for (;;)
    {
      Object localObject1;
      L localL;
      int i;
      Object localObject2;
      try
      {
        if (!parame.d()) {
          break label395;
        }
        if (parame.c())
        {
          localObject1 = "201";
          localL = new L();
          localL.a = ((String)localObject1);
          localL.b = parame.i();
          localL.c = parame.e();
          localL.d = parame.f();
          localL.e = parame.g();
          localL.h = parame.C();
          localL.g = parame.h();
          localL.i = parame.v();
          localL.k = parame.k();
          localL.l = parame.D();
          localL.f = parame.r();
          localObject1 = parame.u();
          if (localObject1 != null) {
            break label454;
          }
          i = 0;
          com.tencent.feedback.common.e.b("plugin size :%d", new Object[] { Integer.valueOf(i) });
          if ((localObject1 == null) || (((Map)localObject1).size() <= 0)) {
            break label465;
          }
          localL.n = new ArrayList();
          localObject1 = ((Map)localObject1).entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label465;
          }
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          I localI = new I();
          localI.a = ((PlugInInfo)((Map.Entry)localObject2).getValue()).plugInId;
          localI.c = ((PlugInInfo)((Map.Entry)localObject2).getValue()).plugInUUID;
          localI.d = ((PlugInInfo)((Map.Entry)localObject2).getValue()).plugInVersion;
          localL.n.add(localI);
          continue;
        }
        localObject1 = "101";
      }
      catch (Throwable paramContext)
      {
        if (!com.tencent.feedback.common.e.a(paramContext)) {
          paramContext.printStackTrace();
        }
        return null;
      }
      continue;
      label395:
      if (parame.x())
      {
        if (parame.c()) {
          localObject1 = "203";
        }
      }
      else
      {
        if (parame.b())
        {
          if (!parame.c()) {
            break label2043;
          }
          localObject1 = "200";
          continue;
        }
        if (!parame.c()) {
          break label2051;
        }
        localObject1 = "202";
        continue;
        label454:
        i = ((Map)localObject1).size();
        continue;
        label465:
        if ((parame.c()) && (parame.m() > 1))
        {
          localL.j = parame.m();
          if ((parame.l() != null) && (parame.l().length() > 0))
          {
            if (localL.o == null) {
              localL.o = new ArrayList();
            }
            localL.o.add(new K((byte)1, "alltimes.txt", parame.l().getBytes("utf-8")));
          }
        }
        if (parame.n() != null)
        {
          if (localL.o == null) {
            localL.o = new ArrayList();
          }
          localL.o.add(new K((byte)1, "log.txt", parame.n()));
        }
        if ((parame.s() != null) && (!parame.x()))
        {
          localObject1 = a(parame.s().getBytes("utf8"), "extraMessage.txt");
          if (localObject1 != null)
          {
            if (localL.o == null) {
              localL.o = new ArrayList();
            }
            com.tencent.feedback.common.e.b("rqdp{  attach extra msg}", new Object[0]);
            localL.o.add(localObject1);
          }
        }
        if (parame.t() != null)
        {
          localObject1 = a(parame.t(), "extraDatas.txt");
          if (localObject1 != null)
          {
            com.tencent.feedback.common.e.b("rqdp{  attach extra datas}", new Object[0]);
            if (localL.o == null) {
              localL.o = new ArrayList();
            }
            localL.o.add(localObject1);
          }
        }
        if ((parame.x()) && (parame.p() != null)) {
          if (localL.o == null) {
            localL.o = new ArrayList();
          }
        }
        try
        {
          localL.o.add(new K((byte)1, "anrMessage.txt", parame.s().getBytes("utf8")));
          com.tencent.feedback.common.e.b("attach anr message", new Object[0]);
          localObject1 = a("trace.zip", paramContext, parame.p());
          if (localObject1 != null)
          {
            com.tencent.feedback.common.e.b("attach traces", new Object[0]);
            localL.o.add(localObject1);
          }
          localObject1 = c.a(paramContext);
          localL.p = new HashMap();
          localL.p.put("A9", parame.F());
          localL.p.put("A11", parame.G());
          localL.p.put("A10", parame.H());
          localL.p.put("A23", parame.N());
          localL.p.put("A7", ((c)localObject1).d());
          localL.p.put("A6", ((c)localObject1).w());
          localL.p.put("A5", ((c)localObject1).v());
          localL.p.put("A22", ((c)localObject1).h());
          localL.p.put("A2", parame.J());
          localL.p.put("A1", parame.I());
          localL.p.put("A24", ((c)localObject1).f());
          localL.p.put("A17", parame.K());
          localL.p.put("A3", ((c)localObject1).o());
          localL.p.put("A16", ((c)localObject1).q());
          localL.p.put("A25", ((c)localObject1).r());
          localL.p.put("A14", ((c)localObject1).p());
          localL.p.put("A15", ((c)localObject1).z());
          localL.p.put("A13", ((c)localObject1).C());
          localL.p.put("A34", parame.q());
          localL.p.put("A30", parame.B());
          localObject2 = localL.p;
          if (((c)localObject1).k().trim().length() > 0)
          {
            localObject1 = ((c)localObject1).k();
            ((Map)localObject2).put("productIdentify", localObject1);
            if (parame.d())
            {
              localL.p.put("A27", parame.A());
              localL.p.put("A28", parame.z());
              localL.p.put("A29", parame.E());
            }
            paramContext = b(paramContext);
            if ((paramContext != null) && (paramContext.size() > 0)) {
              localL.m = paramContext;
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            try
            {
              localL.p.put("A26", URLEncoder.encode(parame.y(), "utf-8"));
              if (parame.a >= 0) {
                localL.p.put("C01", parame.a);
              }
              if (parame.b >= 0) {
                localL.p.put("C02", parame.b);
              }
              if ((parame.c == null) || (parame.c.size() <= 0)) {
                break;
              }
              paramContext = parame.c.entrySet().iterator();
              if (!paramContext.hasNext()) {
                break;
              }
              localObject1 = (Map.Entry)paramContext.next();
              localL.p.put("C03_" + (String)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue());
              continue;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              localUnsupportedEncodingException.printStackTrace();
              localL.o = null;
            }
            catch (UnsupportedEncodingException paramContext)
            {
              if (com.tencent.feedback.common.e.a(paramContext)) {
                break label2059;
              }
            }
            str = localUnsupportedEncodingException.l();
          }
        }
        paramContext.printStackTrace();
        break;
        if ((parame.d != null) && (parame.d.size() > 0))
        {
          paramContext = parame.d.entrySet().iterator();
          while (paramContext.hasNext())
          {
            parame = (Map.Entry)paramContext.next();
            localL.p.put("C04_" + (String)parame.getKey(), parame.getValue());
          }
        }
        return localL;
      }
      String str = "103";
      continue;
      label2043:
      str = "100";
      continue;
      label2051:
      str = "102";
    }
    label2059:
    return null;
  }
  
  private M a(Context paramContext, List<e> paramList)
  {
    Object localObject1;
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
      localObject1 = null;
    }
    ArrayList localArrayList;
    Object localObject2;
    do
    {
      return localObject1;
      for (;;)
      {
        e locale;
        try
        {
          localObject1 = new ArrayList();
          localArrayList = new ArrayList();
          localObject2 = paramList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          locale = (e)((Iterator)localObject2).next();
          if (!c.a(paramContext).B().equals(locale.N()))
          {
            com.tencent.feedback.common.e.c("updated drop it", new Object[0]);
            localArrayList.add(locale);
            continue;
          }
          localL = a(paramContext, locale);
        }
        catch (Throwable paramContext)
        {
          if (!com.tencent.feedback.common.e.a(paramContext)) {
            paramContext.printStackTrace();
          }
          return null;
        }
        L localL;
        if (localL != null) {
          ((ArrayList)localObject1).add(localL);
        } else {
          localArrayList.add(locale);
        }
      }
      localObject2 = new M();
      ((M)localObject2).a = ((ArrayList)localObject1);
      localObject1 = localObject2;
    } while (localArrayList.size() <= 0);
    com.tencent.feedback.common.e.c("rqdp{ delete error eup} %d", new Object[] { Integer.valueOf(b.a(paramContext, localArrayList)) });
    paramList.removeAll(localArrayList);
    return localObject2;
  }
  
  private static void a(List<e> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        e locale = (e)paramList.next();
        locale.a(locale.j() + 1);
      }
    }
  }
  
  private static ArrayList<I> b(Context paramContext)
  {
    try
    {
      Object localObject2 = c.a(paramContext).A();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        com.tencent.feedback.common.e.b("no setted solist from db", new Object[0]);
        localObject1 = l.a(paramContext, null, 1, 50);
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramContext = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
      }
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o)((Iterator)localObject1).next();
        I localI = new I();
        localI.b = ((o)localObject2).f();
        localI.a = ((o)localObject2).a();
        localI.c = ((o)localObject2).d();
        paramContext.add(localI);
        com.tencent.feedback.common.e.b("up %s %s %s", new Object[] { localI.b, localI.a, localI.c });
        continue;
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      if (!com.tencent.feedback.common.e.a(paramContext)) {
        paramContext.printStackTrace();
      }
      com.tencent.feedback.common.e.d("rqdp{  Error: lb pack fail!}", new Object[0]);
    }
    return paramContext;
  }
  
  private List<e> b(Context paramContext, int paramInt)
  {
    com.tencent.feedback.common.e.b("rqdp{  get MN:}%d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext == null) || (paramInt <= 0))
    {
      com.tencent.feedback.common.e.c("rqdp{  params!}", new Object[0]);
      return null;
    }
    try
    {
      List localList = b.a(paramContext, paramInt, "desc", 1, null, -1, -1, -1, 3, -1L, -1L, null);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (((List)localObject).size() < paramInt)
      {
        localList = b.a(paramContext, paramInt - ((List)localObject).size(), "desc", 2, null, -1, -1, -1, 3, -1L, -1L, null);
        if ((localList != null) && (localList.size() > 0)) {
          ((List)localObject).addAll(localList);
        }
      }
      a((List)localObject);
      b.b(paramContext, (List)localObject);
      return localObject;
    }
    catch (Throwable paramContext)
    {
      if (!com.tencent.feedback.common.e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public final N a()
  {
    Object localObject5 = null;
    for (;;)
    {
      boolean bool;
      try
      {
        if (this.e != null)
        {
          localObject1 = this.e;
          return localObject1;
        }
        localObject6 = f.l();
        localObject1 = localObject5;
        if (localObject6 == null) {
          continue;
        }
        bool = ((f)localObject6).a();
        localObject1 = localObject5;
        if (!bool) {
          continue;
        }
      }
      finally
      {
        try
        {
          Object localObject1 = f.l().s();
          this.f = null;
          try
          {
            bool = ((CrashStrategyBean)localObject1).isMerged();
            if (!com.tencent.feedback.common.g.a(this.c)) {
              break label260;
            }
            i = ((CrashStrategyBean)localObject1).getMaxUploadNum_Wifi();
            if (bool) {
              break label268;
            }
            com.tencent.feedback.common.e.b("rqdp{  not merge:}", new Object[0]);
            this.f = b(this.c, i);
            if ((this.f != null) && (this.f.size() > 0)) {
              break label295;
            }
            com.tencent.feedback.common.e.c("rqdp{  empty eup!}", new Object[0]);
            localObject1 = localObject5;
          }
          catch (Throwable localThrowable1)
          {
            if (!com.tencent.feedback.common.e.a(localThrowable1)) {
              localThrowable1.printStackTrace();
            }
            localObject2 = localObject5;
          }
          if (this.f == null) {
            continue;
          }
          Object localObject2 = localObject5;
          if (this.f.size() <= 0) {
            continue;
          }
          com.tencent.feedback.common.e.c("rqdp{ eup error remove} %d", new Object[] { Integer.valueOf(b.a(this.c, this.f)) });
          this.f = null;
          localObject2 = localObject5;
        }
        catch (Throwable localThrowable2)
        {
          if (com.tencent.feedback.common.e.a(localThrowable2)) {
            break label236;
          }
          localThrowable2.printStackTrace();
          com.tencent.feedback.common.e.d("rqdp{  imposiable} %s", new Object[] { localThrowable2.toString() });
          localObject4 = localObject5;
        }
        localObject3 = finally;
      }
      label236:
      continue;
      label260:
      int i = ((CrashStrategyBean)localObject4).getMaxUploadNum_GPRS();
      continue;
      label268:
      com.tencent.feedback.common.e.b("rqdp{  in merge:}", new Object[0]);
      this.f = a(this.c, i);
      continue;
      label295:
      com.tencent.feedback.common.e.b("rqdp{  pack n:}%d ,isM:%b", new Object[] { Integer.valueOf(this.f.size()), Boolean.valueOf(bool) });
      Object localObject6 = a(this.c, this.f);
      Object localObject4 = localObject5;
      if (localObject6 != null)
      {
        localObject4 = a.a((j)localObject6);
        if (localObject4 == null)
        {
          com.tencent.feedback.common.e.c("rqdp{  empty edatas!}", new Object[0]);
          localObject4 = localObject5;
        }
        else
        {
          this.e = a(this.c, this.a, (byte[])localObject4);
          localObject4 = this.e;
        }
      }
    }
  }
  
  protected final List<e> a(Context paramContext, int paramInt)
  {
    com.tencent.feedback.common.e.b("rqdp{  getEupInMe}", new Object[0]);
    if ((paramContext == null) || (paramInt <= 0))
    {
      com.tencent.feedback.common.e.d("rqdp{  params!}", new Object[0]);
      return null;
    }
    try
    {
      long l = a.c();
      ArrayList localArrayList = new ArrayList();
      List localList = b.a(paramContext, paramInt, "desc", -1, null, -1, -1, -1, 3, l, -1L, Boolean.valueOf(false));
      if ((localList != null) && (localList.size() > 0))
      {
        com.tencent.feedback.common.e.b("rqdp{  tdeup ge c=1, n:}%d", new Object[] { Integer.valueOf(localList.size()) });
        localArrayList.addAll(localList);
        localList.clear();
      }
      if (localArrayList.size() < paramInt)
      {
        localList = b.a(paramContext, paramInt, "desc", -1, null, 2, -1, -1, 3, -1L, l, null);
        if ((localList != null) && (localList.size() > 0))
        {
          com.tencent.feedback.common.e.b("rqdp{  yeseup c>=2,n:}%d" + localList.size(), new Object[0]);
          localArrayList.addAll(localList);
          localList.clear();
        }
      }
      if (localArrayList.size() < paramInt)
      {
        localList = b.a(paramContext, paramInt, "desc", -1, null, 0, 1, -1, -1, 3L, l, Boolean.valueOf(false));
        if ((localList != null) && (localList.size() > 0))
        {
          com.tencent.feedback.common.e.b("rqdp{  yeseup c>=2,n:}%d" + localList.size(), new Object[0]);
          localArrayList.addAll(localList);
          localList.clear();
        }
      }
      a(localArrayList);
      b.b(paramContext, localArrayList);
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      if (!com.tencent.feedback.common.e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public final void done(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq +148 -> 151
    //   6: ldc_w 699
    //   9: astore 5
    //   11: ldc_w 701
    //   14: iconst_1
    //   15: anewarray 38	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload 5
    //   22: aastore
    //   23: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 25	com/tencent/feedback/eup/g:f	Ljava/util/List;
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull +213 -> 248
    //   38: iload_1
    //   39: ifeq +209 -> 248
    //   42: invokestatic 630	com/tencent/feedback/eup/f:l	()Lcom/tencent/feedback/eup/f;
    //   45: invokevirtual 635	com/tencent/feedback/eup/f:s	()Lcom/tencent/feedback/eup/CrashStrategyBean;
    //   48: invokevirtual 640	com/tencent/feedback/eup/CrashStrategyBean:isMerged	()Z
    //   51: istore_1
    //   52: iload_1
    //   53: ifeq +208 -> 261
    //   56: invokestatic 686	com/tencent/feedback/proguard/a:c	()J
    //   59: lstore_3
    //   60: aload_0
    //   61: getfield 25	com/tencent/feedback/eup/g:f	Ljava/util/List;
    //   64: invokeinterface 548 1 0
    //   69: astore 5
    //   71: new 259	java/util/ArrayList
    //   74: dup
    //   75: invokespecial 260	java/util/ArrayList:<init>	()V
    //   78: astore 6
    //   80: aload 5
    //   82: invokeinterface 279 1 0
    //   87: ifeq +90 -> 177
    //   90: aload 5
    //   92: invokeinterface 283 1 0
    //   97: checkcast 159	com/tencent/feedback/eup/e
    //   100: astore 7
    //   102: aload 7
    //   104: invokevirtual 190	com/tencent/feedback/eup/e:i	()J
    //   107: lload_3
    //   108: lcmp
    //   109: ifle -29 -> 80
    //   112: aload 7
    //   114: iconst_1
    //   115: invokevirtual 703	com/tencent/feedback/eup/e:b	(Z)V
    //   118: aload 7
    //   120: iconst_0
    //   121: invokevirtual 580	com/tencent/feedback/eup/e:a	(I)V
    //   124: aload 6
    //   126: aload 7
    //   128: invokeinterface 704 2 0
    //   133: pop
    //   134: aload 5
    //   136: invokeinterface 707 1 0
    //   141: goto -61 -> 80
    //   144: astore 5
    //   146: aload_0
    //   147: monitorexit
    //   148: aload 5
    //   150: athrow
    //   151: ldc_w 709
    //   154: astore 5
    //   156: goto -145 -> 11
    //   159: astore 5
    //   161: aload 5
    //   163: invokestatic 93	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   166: ifne +135 -> 301
    //   169: aload 5
    //   171: invokevirtual 96	java/lang/Throwable:printStackTrace	()V
    //   174: goto +127 -> 301
    //   177: aload_0
    //   178: getfield 643	com/tencent/feedback/eup/g:c	Landroid/content/Context;
    //   181: aload 6
    //   183: invokestatic 623	com/tencent/feedback/eup/b:b	(Landroid/content/Context;Ljava/util/List;)Z
    //   186: istore_1
    //   187: ldc_w 711
    //   190: iconst_2
    //   191: anewarray 38	java/lang/Object
    //   194: dup
    //   195: iconst_0
    //   196: aload_0
    //   197: getfield 25	com/tencent/feedback/eup/g:f	Ljava/util/List;
    //   200: invokeinterface 547 1 0
    //   205: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aastore
    //   209: dup
    //   210: iconst_1
    //   211: iload_1
    //   212: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   215: aastore
    //   216: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   219: pop
    //   220: ldc_w 713
    //   223: iconst_1
    //   224: anewarray 38	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_0
    //   230: getfield 643	com/tencent/feedback/eup/g:c	Landroid/content/Context;
    //   233: aload_0
    //   234: getfield 25	com/tencent/feedback/eup/g:f	Ljava/util/List;
    //   237: invokestatic 568	com/tencent/feedback/eup/b:a	(Landroid/content/Context;Ljava/util/List;)I
    //   240: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   247: pop
    //   248: aload_0
    //   249: aconst_null
    //   250: putfield 23	com/tencent/feedback/eup/g:e	Lcom/tencent/feedback/proguard/N;
    //   253: aload_0
    //   254: aconst_null
    //   255: putfield 25	com/tencent/feedback/eup/g:f	Ljava/util/List;
    //   258: aload_0
    //   259: monitorexit
    //   260: return
    //   261: aload_0
    //   262: getfield 643	com/tencent/feedback/eup/g:c	Landroid/content/Context;
    //   265: aload_0
    //   266: getfield 25	com/tencent/feedback/eup/g:f	Ljava/util/List;
    //   269: invokestatic 568	com/tencent/feedback/eup/b:a	(Landroid/content/Context;Ljava/util/List;)I
    //   272: istore_2
    //   273: new 195	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 715
    //   280: invokespecial 528	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: iload_2
    //   284: invokevirtual 519	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: iconst_0
    //   291: anewarray 38	java/lang/Object
    //   294: invokestatic 49	com/tencent/feedback/common/e:b	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   297: pop
    //   298: goto -50 -> 248
    //   301: iconst_0
    //   302: istore_1
    //   303: goto -251 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	g
    //   0	306	1	paramBoolean	boolean
    //   272	12	2	i	int
    //   59	49	3	l	long
    //   9	126	5	localObject1	Object
    //   144	5	5	localObject2	Object
    //   154	1	5	str	String
    //   159	11	5	localThrowable	Throwable
    //   78	104	6	localArrayList	ArrayList
    //   100	27	7	locale	e
    // Exception table:
    //   from	to	target	type
    //   11	33	144	finally
    //   42	52	144	finally
    //   56	80	144	finally
    //   80	141	144	finally
    //   161	174	144	finally
    //   177	248	144	finally
    //   248	258	144	finally
    //   261	298	144	finally
    //   42	52	159	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.g
 * JD-Core Version:    0.7.0.1
 */