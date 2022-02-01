package com.b.a.a;

import android.os.SystemClock;
import com.b.a.b;
import com.b.a.b.a;
import com.b.a.j;
import com.b.a.u;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class d
  implements b
{
  private final Map<String, a> a = new LinkedHashMap(16, 0.75F, true);
  private long b = 0L;
  private final File c;
  private final int d;
  
  public d(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  private d(File paramFile, int paramInt)
  {
    this.c = paramFile;
    this.d = 5242880;
  }
  
  static int a(InputStream paramInputStream)
    throws IOException
  {
    return c(paramInputStream) | 0x0 | c(paramInputStream) << 8 | c(paramInputStream) << 16 | c(paramInputStream) << 24;
  }
  
  public static b.a a(j paramj)
  {
    long l6 = System.currentTimeMillis();
    Map localMap = paramj.b;
    long l3 = 0L;
    long l2 = 0L;
    long l1 = 0L;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {
      l3 = b((String)localObject1);
    }
    localObject1 = (String)localMap.get("Cache-Control");
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((String)localObject1).split(",");
      j = 0;
      i = 0;
      l1 = 0L;
      l2 = 0L;
      if (j < localObject1.length)
      {
        localObject2 = localObject1[j].trim();
        if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
          return null;
        }
        if (((String)localObject2).startsWith("max-age=")) {}
        for (;;)
        {
          try
          {
            l5 = Long.parseLong(((String)localObject2).substring(8));
            l4 = l1;
          }
          catch (Exception localException2)
          {
            long l4 = l1;
            long l5 = l2;
            continue;
            l1 = 0L;
            l2 = 0L;
            continue;
            l4 = 0L;
            continue;
            l5 = 0L;
            continue;
          }
          j += 1;
          l1 = l4;
          l2 = l5;
          break;
          if (((String)localObject2).startsWith("stale-while-revalidate=")) {}
          try
          {
            l4 = Long.parseLong(((String)localObject2).substring(23));
            l5 = l2;
          }
          catch (Exception localException1)
          {
            l4 = l1;
            l5 = l2;
          }
          if (!((String)localObject2).equals("must-revalidate"))
          {
            l4 = l1;
            l5 = l2;
            if (!((String)localObject2).equals("proxy-revalidate")) {}
          }
          else
          {
            i = 1;
            l4 = l1;
            l5 = l2;
          }
        }
      }
    }
    for (int j = 1;; j = 0)
    {
      localObject1 = (String)localMap.get("Expires");
      if (localObject1 != null)
      {
        l5 = b((String)localObject1);
        localObject1 = (String)localMap.get("Last-Modified");
        if (localObject1 != null)
        {
          l4 = b((String)localObject1);
          localObject1 = (String)localMap.get("ETag");
          if (j != 0)
          {
            l2 = l6 + 1000L * l2;
            if (i != 0) {
              l1 = l2;
            }
          }
          for (;;)
          {
            localObject2 = new b.a();
            ((b.a)localObject2).a = paramj.a;
            ((b.a)localObject2).b = ((String)localObject1);
            ((b.a)localObject2).f = l2;
            ((b.a)localObject2).e = l1;
            ((b.a)localObject2).c = l3;
            ((b.a)localObject2).d = l4;
            ((b.a)localObject2).g = localMap;
            return localObject2;
            l1 = 1000L * l1 + l2;
            continue;
            if ((l3 <= 0L) || (l5 < l3)) {
              break;
            }
            l1 = l5 - l3 + l6;
            l2 = l1;
          }
          break;
        }
      }
      i = 0;
    }
  }
  
  private static InputStream a(File paramFile)
    throws FileNotFoundException
  {
    return new FileInputStream(paramFile);
  }
  
  static String a(long paramLong)
  {
    return b().format(new Date(paramLong));
  }
  
  static String a(b paramb)
    throws IOException
  {
    return new String(a(paramb, b(paramb)), "UTF-8");
  }
  
  public static String a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("Content-Type");
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      int i = 1;
      while (i < paramMap.length)
      {
        String[] arrayOfString = paramMap[i].trim().split("=");
        if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset"))) {
          return arrayOfString[1];
        }
        i += 1;
      }
    }
    return "ISO-8859-1";
  }
  
  static void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >>> 24);
  }
  
  static void a(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)paramLong);
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void a(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    a(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void a(String paramString, a parama)
  {
    if (!this.a.containsKey(paramString)) {}
    a locala;
    long l;
    for (this.b += parama.a;; this.b = (parama.a - locala.a + l))
    {
      this.a.put(paramString, parama);
      return;
      locala = (a)this.a.get(paramString);
      l = this.b;
    }
  }
  
  private static byte[] a(b paramb, long paramLong)
    throws IOException
  {
    long l = paramb.a();
    if ((paramLong < 0L) || (paramLong > l) || ((int)paramLong != paramLong)) {
      throw new IOException("streamToBytes length=" + paramLong + ", maxLength=" + l);
    }
    byte[] arrayOfByte = new byte[(int)paramLong];
    new DataInputStream(paramb).readFully(arrayOfByte);
    return arrayOfByte;
  }
  
  static long b(InputStream paramInputStream)
    throws IOException
  {
    return 0L | c(paramInputStream) & 0xFF | (c(paramInputStream) & 0xFF) << 8 | (c(paramInputStream) & 0xFF) << 16 | (c(paramInputStream) & 0xFF) << 24 | (c(paramInputStream) & 0xFF) << 32 | (c(paramInputStream) & 0xFF) << 40 | (c(paramInputStream) & 0xFF) << 48 | (c(paramInputStream) & 0xFF) << 56;
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = b().parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      u.a(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
    return 0L;
  }
  
  private static SimpleDateFormat b()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
  
  static Map<String, String> b(b paramb)
    throws IOException
  {
    int j = a(paramb);
    if (j == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(j))
    {
      int i = 0;
      while (i < j)
      {
        ((Map)localObject).put(a(paramb).intern(), a(paramb).intern());
        i += 1;
      }
    }
    return localObject;
  }
  
  private static int c(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  private void c(String paramString)
  {
    try
    {
      boolean bool = e(paramString).delete();
      f(paramString);
      if (!bool) {
        u.b("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, d(paramString) });
      }
      return;
    }
    finally {}
  }
  
  private static String d(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  private File e(String paramString)
  {
    return new File(this.c, d(paramString));
  }
  
  private void f(String paramString)
  {
    paramString = (a)this.a.remove(paramString);
    if (paramString != null) {
      this.b -= paramString.a;
    }
  }
  
  /* Error */
  public final b.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	com/b/a/a/d:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 70 2 0
    //   12: checkcast 8	com/b/a/a/d$a
    //   15: astore 5
    //   17: aload 5
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokespecial 325	com/b/a/a/d:e	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore_3
    //   34: new 11	com/b/a/a/d$b
    //   37: dup
    //   38: new 363	java/io/BufferedInputStream
    //   41: dup
    //   42: aload_3
    //   43: invokestatic 365	com/b/a/a/d:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   46: invokespecial 366	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: aload_3
    //   50: invokevirtual 368	java/io/File:length	()J
    //   53: invokespecial 371	com/b/a/a/d$b:<init>	(Ljava/io/InputStream;J)V
    //   56: astore 4
    //   58: aload 4
    //   60: invokestatic 374	com/b/a/a/d$a:a	(Lcom/b/a/a/d$b;)Lcom/b/a/a/d$a;
    //   63: astore_2
    //   64: aload_1
    //   65: aload_2
    //   66: getfield 375	com/b/a/a/d$a:b	Ljava/lang/String;
    //   69: invokestatic 380	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   72: ifne +46 -> 118
    //   75: ldc_w 382
    //   78: iconst_3
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_3
    //   85: invokevirtual 385	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_1
    //   92: aastore
    //   93: dup
    //   94: iconst_2
    //   95: aload_2
    //   96: getfield 375	com/b/a/a/d$a:b	Ljava/lang/String;
    //   99: aastore
    //   100: invokestatic 341	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: aload_1
    //   105: invokespecial 333	com/b/a/a/d:f	(Ljava/lang/String;)V
    //   108: aload 4
    //   110: invokevirtual 388	com/b/a/a/d$b:close	()V
    //   113: aconst_null
    //   114: astore_1
    //   115: goto -91 -> 24
    //   118: aload 4
    //   120: aload 4
    //   122: invokevirtual 224	com/b/a/a/d$b:a	()J
    //   125: invokestatic 176	com/b/a/a/d:a	(Lcom/b/a/a/d$b;J)[B
    //   128: astore 6
    //   130: new 126	com/b/a/b$a
    //   133: dup
    //   134: invokespecial 127	com/b/a/b$a:<init>	()V
    //   137: astore_2
    //   138: aload_2
    //   139: aload 6
    //   141: putfield 131	com/b/a/b$a:a	[B
    //   144: aload_2
    //   145: aload 5
    //   147: getfield 390	com/b/a/a/d$a:c	Ljava/lang/String;
    //   150: putfield 134	com/b/a/b$a:b	Ljava/lang/String;
    //   153: aload_2
    //   154: aload 5
    //   156: getfield 391	com/b/a/a/d$a:d	J
    //   159: putfield 142	com/b/a/b$a:c	J
    //   162: aload_2
    //   163: aload 5
    //   165: getfield 392	com/b/a/a/d$a:e	J
    //   168: putfield 144	com/b/a/b$a:d	J
    //   171: aload_2
    //   172: aload 5
    //   174: getfield 393	com/b/a/a/d$a:f	J
    //   177: putfield 140	com/b/a/b$a:e	J
    //   180: aload_2
    //   181: aload 5
    //   183: getfield 395	com/b/a/a/d$a:g	J
    //   186: putfield 137	com/b/a/b$a:f	J
    //   189: aload_2
    //   190: aload 5
    //   192: getfield 398	com/b/a/a/d$a:h	Ljava/util/Map;
    //   195: putfield 147	com/b/a/b$a:g	Ljava/util/Map;
    //   198: aload 4
    //   200: invokevirtual 388	com/b/a/a/d$b:close	()V
    //   203: aload_2
    //   204: astore_1
    //   205: goto -181 -> 24
    //   208: astore_2
    //   209: aload 4
    //   211: invokevirtual 388	com/b/a/a/d$b:close	()V
    //   214: aload_2
    //   215: athrow
    //   216: astore_2
    //   217: ldc_w 400
    //   220: iconst_2
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_3
    //   227: invokevirtual 385	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   230: aastore
    //   231: dup
    //   232: iconst_1
    //   233: aload_2
    //   234: invokevirtual 401	java/io/IOException:toString	()Ljava/lang/String;
    //   237: aastore
    //   238: invokestatic 341	com/b/a/u:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload_0
    //   242: aload_1
    //   243: invokespecial 403	com/b/a/a/d:c	(Ljava/lang/String;)V
    //   246: aconst_null
    //   247: astore_1
    //   248: goto -224 -> 24
    //   251: astore_1
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_1
    //   255: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	d
    //   0	256	1	paramString	String
    //   63	141	2	localObject1	Object
    //   208	7	2	localObject2	Object
    //   216	18	2	localIOException	IOException
    //   33	194	3	localFile	File
    //   56	154	4	localb	b
    //   15	176	5	locala	a
    //   128	12	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   58	108	208	finally
    //   118	198	208	finally
    //   34	58	216	java/io/IOException
    //   108	113	216	java/io/IOException
    //   198	203	216	java/io/IOException
    //   209	216	216	java/io/IOException
    //   2	17	251	finally
    //   28	34	251	finally
    //   34	58	251	finally
    //   108	113	251	finally
    //   198	203	251	finally
    //   209	216	251	finally
    //   217	246	251	finally
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 41	com/b/a/a/d:c	Ljava/io/File;
    //   6: invokevirtual 406	java/io/File:exists	()Z
    //   9: ifne +36 -> 45
    //   12: aload_0
    //   13: getfield 41	com/b/a/a/d:c	Ljava/io/File;
    //   16: invokevirtual 409	java/io/File:mkdirs	()Z
    //   19: ifne +23 -> 42
    //   22: ldc_w 411
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 41	com/b/a/a/d:c	Ljava/io/File;
    //   35: invokevirtual 385	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: invokestatic 413	com/b/a/u:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 41	com/b/a/a/d:c	Ljava/io/File;
    //   49: invokevirtual 417	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull -14 -> 42
    //   59: aload 5
    //   61: arraylength
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -25 -> 42
    //   70: aload 5
    //   72: iload_1
    //   73: aaload
    //   74: astore 6
    //   76: aload 6
    //   78: invokevirtual 368	java/io/File:length	()J
    //   81: lstore_3
    //   82: new 11	com/b/a/a/d$b
    //   85: dup
    //   86: new 363	java/io/BufferedInputStream
    //   89: dup
    //   90: aload 6
    //   92: invokestatic 365	com/b/a/a/d:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   95: invokespecial 366	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: lload_3
    //   99: invokespecial 371	com/b/a/a/d$b:<init>	(Ljava/io/InputStream;J)V
    //   102: astore 7
    //   104: aload 7
    //   106: invokestatic 374	com/b/a/a/d$a:a	(Lcom/b/a/a/d$b;)Lcom/b/a/a/d$a;
    //   109: astore 8
    //   111: aload 8
    //   113: lload_3
    //   114: putfield 218	com/b/a/a/d$a:a	J
    //   117: aload_0
    //   118: aload 8
    //   120: getfield 375	com/b/a/a/d$a:b	Ljava/lang/String;
    //   123: aload 8
    //   125: invokespecial 419	com/b/a/a/d:a	(Ljava/lang/String;Lcom/b/a/a/d$a;)V
    //   128: aload 7
    //   130: invokevirtual 388	com/b/a/a/d$b:close	()V
    //   133: goto +31 -> 164
    //   136: astore 8
    //   138: aload 7
    //   140: invokevirtual 388	com/b/a/a/d$b:close	()V
    //   143: aload 8
    //   145: athrow
    //   146: astore 7
    //   148: aload 6
    //   150: invokevirtual 331	java/io/File:delete	()Z
    //   153: pop
    //   154: goto +10 -> 164
    //   157: astore 5
    //   159: aload_0
    //   160: monitorexit
    //   161: aload 5
    //   163: athrow
    //   164: iload_1
    //   165: iconst_1
    //   166: iadd
    //   167: istore_1
    //   168: goto -103 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	d
    //   64	104	1	i	int
    //   62	6	2	j	int
    //   81	33	3	l	long
    //   52	19	5	arrayOfFile	File[]
    //   157	5	5	localObject1	Object
    //   74	75	6	localFile	File
    //   102	37	7	localb	b
    //   146	1	7	localIOException	IOException
    //   109	15	8	locala	a
    //   136	8	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   104	128	136	finally
    //   76	104	146	java/io/IOException
    //   128	133	146	java/io/IOException
    //   138	146	146	java/io/IOException
    //   2	42	157	finally
    //   45	54	157	finally
    //   59	63	157	finally
    //   76	104	157	finally
    //   128	133	157	finally
    //   138	146	157	finally
    //   148	154	157	finally
  }
  
  public final void a(String paramString, b.a parama)
  {
    int i = 0;
    long l1;
    long l2;
    Object localObject2;
    int j;
    try
    {
      int k = parama.a.length;
      if (this.b + k < this.d) {
        break label258;
      }
      if (u.a) {
        u.a("Pruning old cache entries.", new Object[0]);
      }
      l1 = this.b;
      l2 = SystemClock.elapsedRealtime();
      localObject1 = this.a.entrySet().iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (e(((a)localObject2).b).delete()) {
          this.b -= ((a)localObject2).a;
        }
        for (;;)
        {
          ((Iterator)localObject1).remove();
          i += 1;
          j = i;
          if ((float)(this.b + k) < this.d * 0.9F) {
            break label209;
          }
          break;
          u.b("Could not delete cache entry for key=%s, filename=%s", new Object[] { ((a)localObject2).b, d(((a)localObject2).b) });
        }
      }
      j = i;
    }
    finally {}
    label209:
    if (u.a) {
      u.a("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(j), Long.valueOf(this.b - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
    }
    label258:
    Object localObject1 = e(paramString);
    a locala;
    try
    {
      localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject1));
      locala = new a(paramString, parama);
      if (!locala.a((OutputStream)localObject2))
      {
        ((BufferedOutputStream)localObject2).close();
        u.b("Failed to write header for %s", new Object[] { ((File)localObject1).getAbsolutePath() });
        throw new IOException();
      }
    }
    catch (IOException paramString)
    {
      if (!((File)localObject1).delete()) {
        u.b("Could not clean up file %s", new Object[] { ((File)localObject1).getAbsolutePath() });
      }
    }
    for (;;)
    {
      return;
      ((BufferedOutputStream)localObject2).write(parama.a);
      ((BufferedOutputStream)localObject2).close();
      a(paramString, locala);
    }
  }
  
  static final class a
  {
    long a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final Map<String, String> h;
    
    a(String paramString, b.a parama)
    {
      this(paramString, parama.b, parama.c, parama.d, parama.e, parama.f, parama.g);
      this.a = parama.a.length;
    }
    
    private a(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Map<String, String> paramMap)
    {
      this.b = paramString1;
      paramString1 = paramString2;
      if ("".equals(paramString2)) {
        paramString1 = null;
      }
      this.c = paramString1;
      this.d = paramLong1;
      this.e = paramLong2;
      this.f = paramLong3;
      this.g = paramLong4;
      this.h = paramMap;
    }
    
    static a a(d.b paramb)
      throws IOException
    {
      if (d.a(paramb) != 538247942) {
        throw new IOException();
      }
      return new a(d.a(paramb), d.a(paramb), d.b(paramb), d.b(paramb), d.b(paramb), d.b(paramb), d.b(paramb));
    }
    
    final boolean a(OutputStream paramOutputStream)
    {
      for (;;)
      {
        try
        {
          d.a(paramOutputStream, 538247942);
          d.a(paramOutputStream, this.b);
          if (this.c == null)
          {
            localObject = "";
            d.a(paramOutputStream, (String)localObject);
            d.a(paramOutputStream, this.d);
            d.a(paramOutputStream, this.e);
            d.a(paramOutputStream, this.f);
            d.a(paramOutputStream, this.g);
            localObject = this.h;
            if (localObject == null) {
              break;
            }
            d.a(paramOutputStream, ((Map)localObject).size());
            localObject = ((Map)localObject).entrySet().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break label172;
            }
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            d.a(paramOutputStream, (String)localEntry.getKey());
            d.a(paramOutputStream, (String)localEntry.getValue());
            continue;
          }
          Object localObject = this.c;
        }
        catch (IOException paramOutputStream)
        {
          u.b("%s", new Object[] { paramOutputStream.toString() });
          return false;
        }
      }
      d.a(paramOutputStream, 0);
      label172:
      paramOutputStream.flush();
      return true;
    }
  }
  
  static final class b
    extends FilterInputStream
  {
    private final long a;
    private long b;
    
    b(InputStream paramInputStream, long paramLong)
    {
      super();
      this.a = paramLong;
    }
    
    final long a()
    {
      return this.a - this.b;
    }
    
    public final int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        this.b += 1L;
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        this.b += paramInt1;
      }
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */