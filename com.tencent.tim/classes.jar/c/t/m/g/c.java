package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class c
  extends x
{
  private static final String q = h.a() + ai.c(c.class.getName(), "SHA-256").substring(0, 8);
  private volatile List<ScanResult> A;
  private volatile Location B;
  private BroadcastReceiver C = new c.1(this);
  public long a = 102400L;
  public long b = 3600000L;
  public int c = 1;
  public int d = 25600;
  public long e = 104857600L;
  public long f = 10485760L;
  public long g = 259200000L;
  public long h = 2592000000L;
  public boolean i = true;
  public boolean j = false;
  public boolean k = false;
  public f l;
  public e m;
  public d n;
  private Context r = null;
  private final File s;
  private boolean t;
  private volatile Handler u;
  private int v = 0;
  private long w = 60000L;
  private long x = 3000L;
  private long y = 0L;
  private volatile List<b> z;
  
  private c(Context paramContext, File paramFile)
  {
    this.r = paramContext;
    this.s = paramFile;
    this.t = false;
  }
  
  public c(Context paramContext, String paramString)
  {
    this(paramContext, new File(paramString + "/f_c"));
  }
  
  public static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return Math.max(paramLong2, Math.min(paramLong1, paramLong3));
  }
  
  public final int a(Looper paramLooper)
  {
    int i2 = 1;
    this.z = null;
    this.A = null;
    this.B = null;
    this.y = 0L;
    boolean bool;
    if ((this.s != null) && ((this.s.exists()) || (this.s.mkdirs()))) {
      bool = true;
    }
    for (;;)
    {
      this.t = bool;
      if (ai.a()) {
        ai.a(3, "DC_Pro", "startup! prepared:" + this.t, null);
      }
      if (this.t)
      {
        this.u = new a(paramLooper);
        this.y = (System.currentTimeMillis() - 40000L);
        ai.a(this.u, 107, 300000L);
      }
      try
      {
        IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        this.r.registerReceiver(this.C, localIntentFilter);
        if ((this.t) && (this.i))
        {
          this.l = new f(this.s);
          this.l.a(paramLooper);
        }
        if (this.j)
        {
          this.m = new e(this.s);
          this.m.a(paramLooper);
        }
        if (this.k)
        {
          this.n = new d();
          this.n.a(paramLooper);
        }
        ai.b("FC", "systemInfo," + an.d());
        paramLooper = new StringBuilder("start,");
        if (this.i)
        {
          i1 = 1;
          paramLooper = paramLooper.append(i1).append(",");
          if (!this.j) {
            break label392;
          }
          i1 = 1;
          paramLooper = paramLooper.append(i1).append(",");
          if (!this.k) {
            break label397;
          }
          i1 = i2;
          ai.b("FC", i1);
          return 0;
          bool = false;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          int i1;
          if (ai.a())
          {
            ai.a("DC_Pro", "listenNetworkState: failed", localThrowable);
            continue;
            i1 = 0;
            continue;
            label392:
            i1 = 0;
            continue;
            label397:
            i1 = 0;
          }
        }
      }
    }
  }
  
  public final void a()
  {
    try
    {
      this.r.unregisterReceiver(this.C);
      label11:
      if (this.l != null)
      {
        this.l.a(100L);
        this.l = null;
      }
      if (this.m != null)
      {
        this.m.a(100L);
        this.m = null;
      }
      if (this.n != null)
      {
        this.n.d();
        this.n = null;
      }
      if (this.t)
      {
        ai.a(this.u, 104, 0L);
        ai.a(this.u, 106, 0L);
        this.y = 0L;
        ai.a(this.u, 107, 0L);
        ai.a(this.u, 105, 200L);
        this.u = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label11;
    }
  }
  
  public final void a(Location paramLocation, List<ScanResult> paramList, List<b> paramList1)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramLocation != null)
        {
          long l2 = paramLocation.getTime();
          if (l1 - l2 <= 10000L) {}
        }
        else
        {
          return;
        }
        this.B = paramLocation;
        this.A = paramList;
        this.z = paramList1;
        if (!this.t) {
          continue;
        }
        if (paramList == null)
        {
          if (ai.a(paramList1)) {
            continue;
          }
          ai.a(this.u, 102, 0L);
          continue;
        }
        if (ai.a(paramList)) {
          continue;
        }
      }
      finally {}
      ai.a(this.u, 101, 0L);
    }
  }
  
  public final String b()
  {
    return "DC_Pro";
  }
  
  final class a
    extends Handler
  {
    private File a;
    private BufferedOutputStream b;
    private StringBuffer c;
    private String d = "";
    private long e = 0L;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    private long a()
    {
      if (h.f) {}
      for (long l = 51200L; c.c(c.this) > l; l = 512000L) {
        return l;
      }
      return c.c(c.this);
    }
    
    private static void a(int paramInt, File paramFile)
    {
      try
      {
        if (!paramFile.isFile()) {
          return;
        }
        long l = System.currentTimeMillis();
        localFile = new File(paramFile.getAbsolutePath() + "." + l + ".enc");
        if (paramInt != 4) {
          break label201;
        }
        byte[] arrayOfByte = ai.a(paramFile);
        if (!ai.b(arrayOfByte))
        {
          arrayOfByte = ai.a(arrayOfByte);
          if (!ai.b(arrayOfByte))
          {
            FileOutputStream localFileOutputStream = new FileOutputStream(localFile, true);
            localFileOutputStream.write(arrayOfByte);
            localFileOutputStream.close();
            paramFile.delete();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        File localFile;
        while (ai.a())
        {
          ai.a("DC_Pro", "rename:" + paramFile.getName() + " error.", localThrowable);
          return;
          label201:
          paramFile.renameTo(localThrowable);
        }
      }
      if (ai.a())
      {
        ai.a(3, "DC_Pro", "rename:" + paramFile.getName() + " to " + localFile.getName(), null);
        return;
      }
    }
    
    private void a(long paramLong1, long paramLong2)
    {
      File[] arrayOfFile;
      if (c.e(c.this) == null)
      {
        arrayOfFile = null;
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label40;
        }
      }
      label40:
      long l2;
      Object localObject1;
      label227:
      do
      {
        return;
        arrayOfFile = c.e(c.this).listFiles();
        break;
        long l3 = System.currentTimeMillis();
        l2 = 0L;
        int j = arrayOfFile.length;
        int i = 0;
        localObject1 = null;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          Object localObject2 = localObject1;
          long l1 = l2;
          if (localFile.exists())
          {
            localObject2 = localObject1;
            l1 = l2;
            if (localFile.isFile())
            {
              localObject2 = localObject1;
              l1 = l2;
              if (!c.c().equals(localFile.getName()))
              {
                if ((l3 - localFile.lastModified() <= paramLong1) && (localFile.length() != 0L)) {
                  break label227;
                }
                if (ai.a()) {
                  ai.a(3, "DC_Pro", "delete expired file:" + localFile.getName() + ",len:" + localFile.length(), null);
                }
                localFile.delete();
                l1 = l2;
                localObject2 = localObject1;
              }
            }
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            l2 = l1;
            break;
            localObject2 = localFile.getName();
            if ((l3 - localFile.lastModified() > 172800000L) && (!((String)localObject2).endsWith(".enc")) && (((String)localObject2).startsWith(h.a())))
            {
              a(h.a((String)localObject2), localFile);
              localObject2 = localObject1;
              l1 = l2;
            }
            else
            {
              l2 += localFile.length();
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                l1 = l2;
                if (localObject1.lastModified() <= localFile.lastModified()) {}
              }
              else
              {
                localObject2 = localFile;
                l1 = l2;
              }
            }
          }
        }
      } while ((l2 < paramLong2) || (localObject1 == null));
      if (ai.a()) {
        ai.a(3, "DC_Pro", "too big folder size:" + l2 + ", delete " + localObject1.getName() + ",size:" + localObject1.length(), null);
      }
      localObject1.delete();
    }
    
    private boolean a(long paramLong)
    {
      try
      {
        Object localObject = am.a("LocationSDK");
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
        String str = ((SharedPreferences)localObject).getString("log_up_fc_date", "");
        long l = ((SharedPreferences)localObject).getLong("log_up_fc_size", 0L);
        localObject = ae.a("yyyyMMdd").format(new Date());
        if (((String)localObject).equals(str))
        {
          if (l > c.o(c.this)) {
            return false;
          }
          localEditor.putLong("log_up_fc_size", paramLong + l);
        }
        for (;;)
        {
          localEditor.apply();
          break;
          localEditor.putString("log_up_fc_date", (String)localObject);
          localEditor.putLong("log_up_fc_size", paramLong);
        }
        return true;
      }
      catch (Throwable localThrowable) {}
    }
    
    private boolean a(String paramString)
    {
      Object localObject;
      if (TextUtils.isEmpty(paramString))
      {
        localObject = null;
        if ((localObject != null) && (((File)localObject).exists()) && (((File)localObject).isDirectory())) {
          break label80;
        }
      }
      label80:
      for (File[] arrayOfFile = null;; arrayOfFile = ((File)localObject).listFiles())
      {
        if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
          break label90;
        }
        if ((arrayOfFile != null) && (paramString.endsWith("d_c"))) {
          ((File)localObject).delete();
        }
        return false;
        localObject = new File(paramString);
        break;
      }
      label90:
      long l = System.currentTimeMillis();
      int m = c.j(c.this);
      int k = 0;
      label270:
      label529:
      if ((k < arrayOfFile.length) && (m > 0))
      {
        File localFile = arrayOfFile[k];
        if ((localFile == null) || (!localFile.exists()) || (!localFile.isFile())) {}
        int j;
        for (localObject = "";; localObject = localFile.getName())
        {
          if (!((String)localObject).startsWith("dc"))
          {
            j = m;
            if (!((String)localObject).startsWith("fc")) {}
          }
          else
          {
            if ((!paramString.endsWith("d_c")) || ((localFile.length() != 0L) && (l - localFile.lastModified() <= c.f(c.this)))) {
              break label246;
            }
            localFile.delete();
            j = m;
          }
          k += 1;
          m = j;
          break;
        }
        label246:
        if ((((String)localObject).startsWith("fc2")) || (((String)localObject).startsWith("fc3")))
        {
          i = 1;
          if (((!((String)localObject).startsWith(h.a())) || (!((String)localObject).endsWith(".enc"))) && (i == 0)) {
            break label524;
          }
          j = 1;
          i = j;
          if (j == 0)
          {
            if (ai.a()) {
              ai.a(3, "DC_Pro", paramString + ",has no " + h.a() + "***.enc files!!!", null);
            }
            if ((!((String)localObject).startsWith("dc")) || (System.currentTimeMillis() - localFile.lastModified() <= 172800000L)) {
              break label529;
            }
          }
        }
        label297:
        for (int i = 1;; i = 0)
        {
          j = m;
          if (i == 0) {
            break;
          }
          j = m;
          if (!a(localFile.length())) {
            break;
          }
          if (ai.a()) {
            ai.a(3, "DC_Pro", "upload:" + localFile.getName() + ",len=" + localFile.length(), null);
          }
          i = h.a((String)localObject);
          j = m;
          if (i <= 0) {
            break;
          }
          String str = h.a(i);
          j = m;
          if (TextUtils.isEmpty(str)) {
            break;
          }
          localObject = str;
          if (!h.e) {
            localObject = str.replace("https:", "http:");
          }
          c.a(c.this, localFile, (String)localObject);
          j = m - 1;
          break;
          i = 0;
          break label270;
          j = 0;
          break label297;
        }
      }
      label524:
      return m != c.j(c.this);
    }
    
    private void b()
    {
      if ((this.c == null) || (this.c.length() == 0) || (this.b == null)) {
        return;
      }
      byte[] arrayOfByte = j.a(this.c.toString());
      StringBuilder localStringBuilder;
      if (ai.a())
      {
        localStringBuilder = new StringBuilder("write buf to file:buf:").append(this.c.length()).append(",enc:");
        if (arrayOfByte != null) {
          break label118;
        }
      }
      label118:
      for (int i = 0;; i = arrayOfByte.length)
      {
        ai.a(3, "DC_Pro", i, null);
        this.c.setLength(0);
        if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {
          break;
        }
        ai.a(3, "DC_Pro", "enc result is null or len = 0", null);
        return;
      }
      try
      {
        this.b.write(arrayOfByte);
        this.b.write(36);
        this.b.flush();
        return;
      }
      catch (Throwable localThrowable)
      {
        ai.a("DC_Pro", "write file failed.", localThrowable);
        this.a = null;
        aj.a(this.b);
      }
    }
    
    private void c()
    {
      try
      {
        if (this.b != null) {
          this.b.flush();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        this.a = null;
        aj.a(this.b);
      }
    }
    
    private void d()
    {
      if ((this.a == null) || (!this.a.exists()) || (this.b == null) || (!c.c().equals(this.a.getName()))) {
        this.a = e();
      }
      try
      {
        boolean bool = this.a.exists();
        this.b = new BufferedOutputStream(new FileOutputStream(this.a, true), 1024);
        if (!bool) {
          am.a("LocationSDK", "log_fc_create", Long.valueOf(System.currentTimeMillis()));
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        ai.a("DC_Pro", "open file error", localThrowable);
      }
    }
    
    private File e()
    {
      File localFile = c.e(c.this);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return new File(localFile, c.c());
    }
    
    /* Error */
    public final void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: invokestatic 113	c/t/m/g/ai:a	()Z
      //   3: ifeq +30 -> 33
      //   6: iconst_3
      //   7: ldc 115
      //   9: new 61	java/lang/StringBuilder
      //   12: dup
      //   13: ldc_w 369
      //   16: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   19: aload_1
      //   20: getfield 375	android/os/Message:what	I
      //   23: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   26: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   29: aconst_null
      //   30: invokestatic 126	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   33: aload_1
      //   34: getfield 375	android/os/Message:what	I
      //   37: istore_2
      //   38: iload_2
      //   39: tableswitch	default:+41 -> 80, 101:+42->81, 102:+42->81, 103:+442->481, 104:+496->535, 105:+501->540, 106:+623->662, 107:+908->947
      //   81: aload_1
      //   82: getfield 375	android/os/Message:what	I
      //   85: istore_2
      //   86: aload_0
      //   87: invokespecial 377	c/t/m/g/c$a:d	()V
      //   90: aload_0
      //   91: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   94: invokestatic 381	c/t/m/g/c:k	(Lc/t/m/g/c;)Ljava/util/List;
      //   97: invokestatic 384	c/t/m/g/ai:a	(Ljava/util/Collection;)Z
      //   100: ifeq +283 -> 383
      //   103: iconst_1
      //   104: istore_3
      //   105: ldc 27
      //   107: astore 8
      //   109: iload_2
      //   110: bipush 102
      //   112: if_icmpne +313 -> 425
      //   115: getstatic 388	c/t/m/g/h:i	Lc/t/m/g/aj;
      //   118: aload_0
      //   119: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   122: invokestatic 392	c/t/m/g/c:l	(Lc/t/m/g/c;)Landroid/location/Location;
      //   125: aconst_null
      //   126: aload_0
      //   127: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   130: invokestatic 381	c/t/m/g/c:k	(Lc/t/m/g/c;)Ljava/util/List;
      //   133: iload_3
      //   134: invokestatic 397	c/t/m/g/i:a	(Lc/t/m/g/aj;Landroid/location/Location;Ljava/util/List;Ljava/util/List;Z)Ljava/lang/String;
      //   137: astore_1
      //   138: aload_0
      //   139: getfield 304	c/t/m/g/c$a:b	Ljava/io/BufferedOutputStream;
      //   142: ifnull -62 -> 80
      //   145: aload_1
      //   146: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   149: ifne -69 -> 80
      //   152: aload_1
      //   153: invokevirtual 398	java/lang/String:length	()I
      //   156: bipush 25
      //   158: if_icmplt -78 -> 80
      //   161: aload_1
      //   162: bipush 22
      //   164: invokevirtual 401	java/lang/String:substring	(I)Ljava/lang/String;
      //   167: invokevirtual 405	java/lang/String:getBytes	()[B
      //   170: ldc_w 407
      //   173: invokestatic 410	c/t/m/g/ai:a	([BLjava/lang/String;)Ljava/lang/String;
      //   176: astore 8
      //   178: aload_0
      //   179: getfield 29	c/t/m/g/c$a:d	Ljava/lang/String;
      //   182: aload 8
      //   184: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   187: ifne -107 -> 80
      //   190: aload_0
      //   191: aload 8
      //   193: putfield 29	c/t/m/g/c$a:d	Ljava/lang/String;
      //   196: aload_0
      //   197: getfield 297	c/t/m/g/c$a:c	Ljava/lang/StringBuffer;
      //   200: ifnonnull +21 -> 221
      //   203: aload_0
      //   204: new 299	java/lang/StringBuffer
      //   207: dup
      //   208: aload_0
      //   209: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   212: invokestatic 413	c/t/m/g/c:n	(Lc/t/m/g/c;)I
      //   215: invokespecial 415	java/lang/StringBuffer:<init>	(I)V
      //   218: putfield 297	c/t/m/g/c$a:c	Ljava/lang/StringBuffer;
      //   221: aload_0
      //   222: getfield 297	c/t/m/g/c$a:c	Ljava/lang/StringBuffer;
      //   225: aload_1
      //   226: invokevirtual 418	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   229: ldc_w 420
      //   232: invokevirtual 418	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   235: pop
      //   236: aload_0
      //   237: getfield 297	c/t/m/g/c$a:c	Ljava/lang/StringBuffer;
      //   240: invokevirtual 302	java/lang/StringBuffer:length	()I
      //   243: aload_0
      //   244: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   247: invokestatic 413	c/t/m/g/c:n	(Lc/t/m/g/c;)I
      //   250: if_icmpgt +22 -> 272
      //   253: aload_0
      //   254: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   257: ifnull +48 -> 305
      //   260: aload_0
      //   261: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   264: invokevirtual 160	java/io/File:length	()J
      //   267: lconst_0
      //   268: lcmp
      //   269: ifne +36 -> 305
      //   272: aload_0
      //   273: invokespecial 422	c/t/m/g/c$a:b	()V
      //   276: aload_0
      //   277: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   280: invokevirtual 160	java/io/File:length	()J
      //   283: aload_0
      //   284: invokespecial 424	c/t/m/g/c$a:a	()J
      //   287: lcmp
      //   288: ifle +17 -> 305
      //   291: aload_0
      //   292: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   295: invokestatic 427	c/t/m/g/c:a	(Lc/t/m/g/c;)Landroid/os/Handler;
      //   298: bipush 106
      //   300: lconst_0
      //   301: invokestatic 430	c/t/m/g/ai:a	(Landroid/os/Handler;IJ)Z
      //   304: pop
      //   305: invokestatic 113	c/t/m/g/ai:a	()Z
      //   308: ifeq -228 -> 80
      //   311: iconst_3
      //   312: ldc 115
      //   314: new 61	java/lang/StringBuilder
      //   317: dup
      //   318: ldc_w 432
      //   321: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   324: aload_1
      //   325: iconst_0
      //   326: bipush 60
      //   328: invokevirtual 435	java/lang/String:substring	(II)Ljava/lang/String;
      //   331: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   334: ldc_w 437
      //   337: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   340: aload_1
      //   341: invokevirtual 398	java/lang/String:length	()I
      //   344: invokevirtual 315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   347: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   350: aconst_null
      //   351: invokestatic 126	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   354: return
      //   355: astore_1
      //   356: ldc 115
      //   358: ldc_w 439
      //   361: aload_1
      //   362: invokestatic 131	c/t/m/g/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   365: return
      //   366: astore_1
      //   367: invokestatic 113	c/t/m/g/ai:a	()Z
      //   370: ifeq -290 -> 80
      //   373: ldc 115
      //   375: ldc_w 441
      //   378: aload_1
      //   379: invokestatic 131	c/t/m/g/ai:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   382: return
      //   383: aload_0
      //   384: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   387: invokestatic 381	c/t/m/g/c:k	(Lc/t/m/g/c;)Ljava/util/List;
      //   390: iconst_0
      //   391: invokeinterface 447 2 0
      //   396: checkcast 449	c/t/m/g/b
      //   399: getfield 450	c/t/m/g/b:e	J
      //   402: lstore 4
      //   404: aload_0
      //   405: getfield 31	c/t/m/g/c$a:e	J
      //   408: lload 4
      //   410: lcmp
      //   411: ifeq +577 -> 988
      //   414: iconst_1
      //   415: istore_3
      //   416: aload_0
      //   417: lload 4
      //   419: putfield 31	c/t/m/g/c$a:e	J
      //   422: goto -317 -> 105
      //   425: aload 8
      //   427: astore_1
      //   428: iload_2
      //   429: bipush 101
      //   431: if_icmpne -293 -> 138
      //   434: aload_0
      //   435: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   438: invokestatic 453	c/t/m/g/c:m	(Lc/t/m/g/c;)Ljava/util/List;
      //   441: astore 9
      //   443: aload 8
      //   445: astore_1
      //   446: aload 9
      //   448: invokestatic 384	c/t/m/g/ai:a	(Ljava/util/Collection;)Z
      //   451: ifne -313 -> 138
      //   454: getstatic 388	c/t/m/g/h:i	Lc/t/m/g/aj;
      //   457: aload_0
      //   458: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   461: invokestatic 392	c/t/m/g/c:l	(Lc/t/m/g/c;)Landroid/location/Location;
      //   464: aload 9
      //   466: aload_0
      //   467: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   470: invokestatic 381	c/t/m/g/c:k	(Lc/t/m/g/c;)Ljava/util/List;
      //   473: iload_3
      //   474: invokestatic 397	c/t/m/g/i:a	(Lc/t/m/g/aj;Landroid/location/Location;Ljava/util/List;Ljava/util/List;Z)Ljava/lang/String;
      //   477: astore_1
      //   478: goto -340 -> 138
      //   481: iconst_3
      //   482: ldc 115
      //   484: ldc_w 455
      //   487: aconst_null
      //   488: invokestatic 126	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   491: aload_0
      //   492: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   495: invokestatic 458	c/t/m/g/c:d	(Lc/t/m/g/c;)Z
      //   498: ifeq -418 -> 80
      //   501: aload_0
      //   502: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   505: invokestatic 139	c/t/m/g/c:e	(Lc/t/m/g/c;)Ljava/io/File;
      //   508: invokevirtual 68	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   511: astore_1
      //   512: aload_0
      //   513: aload_1
      //   514: invokespecial 460	c/t/m/g/c$a:a	(Ljava/lang/String;)Z
      //   517: ifne -437 -> 80
      //   520: aload_0
      //   521: aload_1
      //   522: ldc_w 462
      //   525: ldc 255
      //   527: invokevirtual 465	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   530: invokespecial 460	c/t/m/g/c$a:a	(Ljava/lang/String;)Z
      //   533: pop
      //   534: return
      //   535: aload_0
      //   536: invokespecial 467	c/t/m/g/c$a:c	()V
      //   539: return
      //   540: aload_0
      //   541: invokespecial 422	c/t/m/g/c$a:b	()V
      //   544: aload_0
      //   545: getfield 297	c/t/m/g/c$a:c	Ljava/lang/StringBuffer;
      //   548: ifnull +11 -> 559
      //   551: aload_0
      //   552: getfield 297	c/t/m/g/c$a:c	Ljava/lang/StringBuffer;
      //   555: iconst_0
      //   556: invokevirtual 321	java/lang/StringBuffer:setLength	(I)V
      //   559: aload_0
      //   560: aconst_null
      //   561: putfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   564: aload_0
      //   565: getfield 304	c/t/m/g/c$a:b	Ljava/io/BufferedOutputStream;
      //   568: invokestatic 340	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
      //   571: aload_0
      //   572: aload_0
      //   573: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   576: invokestatic 265	c/t/m/g/c:f	(Lc/t/m/g/c;)J
      //   579: aload_0
      //   580: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   583: invokestatic 470	c/t/m/g/c:g	(Lc/t/m/g/c;)J
      //   586: invokespecial 472	c/t/m/g/c$a:a	(JJ)V
      //   589: aload_0
      //   590: aconst_null
      //   591: invokevirtual 476	c/t/m/g/c$a:removeCallbacksAndMessages	(Ljava/lang/Object;)V
      //   594: return
      //   595: astore_1
      //   596: aload_0
      //   597: aconst_null
      //   598: putfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   601: aload_0
      //   602: getfield 304	c/t/m/g/c$a:b	Ljava/io/BufferedOutputStream;
      //   605: invokestatic 340	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
      //   608: aload_0
      //   609: aload_0
      //   610: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   613: invokestatic 265	c/t/m/g/c:f	(Lc/t/m/g/c;)J
      //   616: aload_0
      //   617: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   620: invokestatic 470	c/t/m/g/c:g	(Lc/t/m/g/c;)J
      //   623: invokespecial 472	c/t/m/g/c$a:a	(JJ)V
      //   626: goto -37 -> 589
      //   629: astore_1
      //   630: aload_0
      //   631: aconst_null
      //   632: putfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   635: aload_0
      //   636: getfield 304	c/t/m/g/c$a:b	Ljava/io/BufferedOutputStream;
      //   639: invokestatic 340	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
      //   642: aload_0
      //   643: aload_0
      //   644: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   647: invokestatic 265	c/t/m/g/c:f	(Lc/t/m/g/c;)J
      //   650: aload_0
      //   651: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   654: invokestatic 470	c/t/m/g/c:g	(Lc/t/m/g/c;)J
      //   657: invokespecial 472	c/t/m/g/c$a:a	(JJ)V
      //   660: aload_1
      //   661: athrow
      //   662: aload_0
      //   663: invokespecial 377	c/t/m/g/c$a:d	()V
      //   666: aload_0
      //   667: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   670: invokestatic 139	c/t/m/g/c:e	(Lc/t/m/g/c;)Ljava/io/File;
      //   673: ifnull -593 -> 80
      //   676: aload_0
      //   677: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   680: ifnull -600 -> 80
      //   683: aload_0
      //   684: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   687: invokevirtual 146	java/io/File:exists	()Z
      //   690: ifeq -610 -> 80
      //   693: aload_0
      //   694: invokespecial 422	c/t/m/g/c$a:b	()V
      //   697: ldc 189
      //   699: ldc_w 348
      //   702: lconst_0
      //   703: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   706: invokestatic 479	c/t/m/g/am:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
      //   709: checkcast 350	java/lang/Long
      //   712: invokevirtual 482	java/lang/Long:longValue	()J
      //   715: lstore 4
      //   717: invokestatic 59	java/lang/System:currentTimeMillis	()J
      //   720: lstore 6
      //   722: invokestatic 113	c/t/m/g/ai:a	()Z
      //   725: ifeq +84 -> 809
      //   728: iconst_3
      //   729: ldc 115
      //   731: new 61	java/lang/StringBuilder
      //   734: dup
      //   735: ldc_w 484
      //   738: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   741: aload_0
      //   742: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   745: invokevirtual 160	java/io/File:length	()J
      //   748: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   751: ldc_w 486
      //   754: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   757: aload_0
      //   758: invokespecial 424	c/t/m/g/c$a:a	()J
      //   761: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   764: ldc_w 488
      //   767: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   770: lload 6
      //   772: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   775: ldc_w 490
      //   778: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   781: lload 4
      //   783: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   786: ldc_w 492
      //   789: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   792: aload_0
      //   793: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   796: invokestatic 495	c/t/m/g/c:h	(Lc/t/m/g/c;)J
      //   799: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   802: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   805: aconst_null
      //   806: invokestatic 126	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   809: aload_0
      //   810: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   813: invokevirtual 160	java/io/File:length	()J
      //   816: aload_0
      //   817: invokespecial 424	c/t/m/g/c$a:a	()J
      //   820: lcmp
      //   821: ifgt +19 -> 840
      //   824: lload 6
      //   826: lload 4
      //   828: lsub
      //   829: aload_0
      //   830: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   833: invokestatic 495	c/t/m/g/c:h	(Lc/t/m/g/c;)J
      //   836: lcmp
      //   837: ifle -757 -> 80
      //   840: iconst_3
      //   841: ldc 115
      //   843: ldc_w 497
      //   846: aconst_null
      //   847: invokestatic 126	c/t/m/g/ai:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   850: aload_0
      //   851: invokespecial 467	c/t/m/g/c$a:c	()V
      //   854: aload_0
      //   855: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   858: ifnull +17 -> 875
      //   861: aload_0
      //   862: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   865: invokevirtual 160	java/io/File:length	()J
      //   868: ldc2_w 498
      //   871: lcmp
      //   872: ifge +35 -> 907
      //   875: aload_0
      //   876: aload_0
      //   877: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   880: invokestatic 265	c/t/m/g/c:f	(Lc/t/m/g/c;)J
      //   883: aload_0
      //   884: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   887: invokestatic 470	c/t/m/g/c:g	(Lc/t/m/g/c;)J
      //   890: invokespecial 472	c/t/m/g/c$a:a	(JJ)V
      //   893: getstatic 38	c/t/m/g/h:f	Z
      //   896: ifeq -816 -> 80
      //   899: aload_0
      //   900: bipush 107
      //   902: invokevirtual 503	c/t/m/g/c$a:sendEmptyMessage	(I)Z
      //   905: pop
      //   906: return
      //   907: aload_0
      //   908: getfield 304	c/t/m/g/c$a:b	Ljava/io/BufferedOutputStream;
      //   911: invokestatic 340	c/t/m/g/aj:a	(Ljava/io/Closeable;)V
      //   914: aload_0
      //   915: aconst_null
      //   916: putfield 304	c/t/m/g/c$a:b	Ljava/io/BufferedOutputStream;
      //   919: iconst_4
      //   920: aload_0
      //   921: getfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   924: invokestatic 180	c/t/m/g/c$a:a	(ILjava/io/File;)V
      //   927: aload_0
      //   928: aconst_null
      //   929: putfield 335	c/t/m/g/c$a:a	Ljava/io/File;
      //   932: ldc 189
      //   934: ldc_w 348
      //   937: lconst_0
      //   938: invokestatic 354	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   941: invokestatic 357	c/t/m/g/am:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
      //   944: goto -69 -> 875
      //   947: aload_0
      //   948: bipush 107
      //   950: invokevirtual 506	c/t/m/g/c$a:removeMessages	(I)V
      //   953: aload_0
      //   954: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   957: aload_0
      //   958: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   961: invokestatic 427	c/t/m/g/c:a	(Lc/t/m/g/c;)Landroid/os/Handler;
      //   964: invokestatic 509	c/t/m/g/c:a	(Lc/t/m/g/c;Landroid/os/Handler;)V
      //   967: aload_0
      //   968: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   971: invokestatic 427	c/t/m/g/c:a	(Lc/t/m/g/c;)Landroid/os/Handler;
      //   974: bipush 107
      //   976: aload_0
      //   977: getfield 22	c/t/m/g/c$a:f	Lc/t/m/g/c;
      //   980: invokestatic 511	c/t/m/g/c:i	(Lc/t/m/g/c;)J
      //   983: invokestatic 430	c/t/m/g/ai:a	(Landroid/os/Handler;IJ)Z
      //   986: pop
      //   987: return
      //   988: iconst_0
      //   989: istore_3
      //   990: goto -574 -> 416
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	993	0	this	a
      //   0	993	1	paramMessage	android.os.Message
      //   37	395	2	i	int
      //   104	886	3	bool	boolean
      //   402	425	4	l1	long
      //   720	105	6	l2	long
      //   107	337	8	str	String
      //   441	24	9	localList	List
      // Exception table:
      //   from	to	target	type
      //   81	103	355	java/lang/Throwable
      //   115	138	355	java/lang/Throwable
      //   138	221	355	java/lang/Throwable
      //   221	272	355	java/lang/Throwable
      //   272	305	355	java/lang/Throwable
      //   305	354	355	java/lang/Throwable
      //   383	414	355	java/lang/Throwable
      //   416	422	355	java/lang/Throwable
      //   434	443	355	java/lang/Throwable
      //   446	478	355	java/lang/Throwable
      //   0	33	366	java/lang/Throwable
      //   33	38	366	java/lang/Throwable
      //   356	365	366	java/lang/Throwable
      //   481	534	366	java/lang/Throwable
      //   535	539	366	java/lang/Throwable
      //   559	589	366	java/lang/Throwable
      //   589	594	366	java/lang/Throwable
      //   596	626	366	java/lang/Throwable
      //   630	662	366	java/lang/Throwable
      //   662	809	366	java/lang/Throwable
      //   809	840	366	java/lang/Throwable
      //   840	875	366	java/lang/Throwable
      //   875	906	366	java/lang/Throwable
      //   907	944	366	java/lang/Throwable
      //   947	987	366	java/lang/Throwable
      //   540	559	595	java/lang/Throwable
      //   540	559	629	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.c
 * JD-Core Version:    0.7.0.1
 */