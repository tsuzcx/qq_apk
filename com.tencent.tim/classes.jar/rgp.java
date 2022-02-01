import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.dispatch.Dispatcher;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@TargetApi(9)
public class rgp
  implements psj
{
  public static final String aAy = plr.ate + "emoji";
  public long BY;
  public final int COUNT = 50;
  private LocationListener a;
  public rgo a;
  public volatile AtomicInteger as = new AtomicInteger(0);
  public AtomicBoolean bb = new AtomicBoolean(false);
  public final Object bm = new Object[0];
  public final Object bw = new Object[0];
  public final ConcurrentHashMap<String, rgo> ck = new ConcurrentHashMap();
  public String mCookie = "";
  public final List<rgo> oL = new ArrayList();
  protected List<Location> oM = new ArrayList();
  public final Queue<rgo> t = new LinkedList();
  private SharedPreferences u;
  
  static
  {
    rp(aAy);
  }
  
  public rgp()
  {
    this.jdField_a_of_type_AndroidLocationLocationListener = new rgt(this);
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().getApplication();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.u = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 4);
  }
  
  private boolean Lr()
  {
    return this.as.get() == 2;
  }
  
  public static String a(rgp paramrgp, String paramString)
  {
    return paramrgp.getStringValue("emoji_pack_url_" + paramString, "");
  }
  
  private static qaf a()
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = rox.d(new File(aAy + "/" + "list.pb"));
      if (arrayOfByte != null) {
        i = arrayOfByte.length;
      }
      ram.b("DoodleEmojiManager", "restoreFilterItemListLocked file length = %d", Integer.valueOf(i));
      if (arrayOfByte == null) {
        return null;
      }
      Object localObject = new ObjectInputStream(new ByteArrayInputStream(arrayOfByte));
      i = ((ObjectInputStream)localObject).readInt();
      if (i == 18)
      {
        long l = ((ObjectInputStream)localObject).readLong();
        arrayOfByte = new byte[((ObjectInputStream)localObject).readInt()];
        ((ObjectInputStream)localObject).readFully(arrayOfByte);
        localObject = new qqstory_service.RspGetEmoticonPackList();
        try
        {
          ((qqstory_service.RspGetEmoticonPackList)localObject).mergeFrom(arrayOfByte);
          return new qaf((qqstory_service.RspGetEmoticonPackList)localObject, arrayOfByte, l);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          ram.e("DoodleEmojiManager", "restoreResponseFromFile error : " + localInvalidProtocolBufferMicroException);
          return null;
        }
      }
      return null;
    }
    catch (IOException localIOException)
    {
      ram.w("DoodleEmojiManager", "restoreResponseFromFile failed FileNotFoundException");
      return null;
      ram.w("DoodleEmojiManager", "restoreResponseFromFile find illegal file with magic code %d", new Object[] { Integer.valueOf(i) });
      return null;
    }
    catch (Exception localException)
    {
      ram.e("DoodleEmojiManager", "restoreResponseFromFile failed", localException);
    }
  }
  
  /* Error */
  public static void a(qaf paramqaf)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 57	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   12: getstatic 77	rgp:aAy	Ljava/lang/String;
    //   15: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 180
    //   20: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 182
    //   25: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 263	rox:fA	(Ljava/lang/String;)Z
    //   34: pop
    //   35: getstatic 77	rgp:aAy	Ljava/lang/String;
    //   38: invokestatic 81	rgp:rp	(Ljava/lang/String;)V
    //   41: new 265	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: sipush 8192
    //   48: invokespecial 266	java/io/ByteArrayOutputStream:<init>	(I)V
    //   51: astore_1
    //   52: new 268	java/io/ObjectOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 271	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: bipush 18
    //   64: invokevirtual 274	java/io/ObjectOutputStream:writeInt	(I)V
    //   67: aload_2
    //   68: aload_0
    //   69: getfield 277	qaf:mTimeStamp	J
    //   72: invokevirtual 281	java/io/ObjectOutputStream:writeLong	(J)V
    //   75: aload_2
    //   76: aload_0
    //   77: getfield 285	qaf:bD	[B
    //   80: arraylength
    //   81: invokevirtual 274	java/io/ObjectOutputStream:writeInt	(I)V
    //   84: aload_2
    //   85: aload_0
    //   86: getfield 285	qaf:bD	[B
    //   89: invokevirtual 288	java/io/ObjectOutputStream:write	([B)V
    //   92: aload_2
    //   93: invokevirtual 291	java/io/ObjectOutputStream:flush	()V
    //   96: aload_2
    //   97: invokevirtual 294	java/io/ObjectOutputStream:close	()V
    //   100: new 296	java/io/FileOutputStream
    //   103: dup
    //   104: new 57	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   111: getstatic 77	rgp:aAy	Ljava/lang/String;
    //   114: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 180
    //   119: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 182
    //   124: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 297	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_1
    //   135: aload_2
    //   136: invokevirtual 300	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   139: aload_1
    //   140: invokevirtual 301	java/io/ByteArrayOutputStream:flush	()V
    //   143: aload_1
    //   144: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   147: aload_2
    //   148: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   151: ldc 190
    //   153: ldc_w 305
    //   156: aload_0
    //   157: getfield 285	qaf:bD	[B
    //   160: arraylength
    //   161: invokestatic 198	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: invokestatic 203	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   183: return
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   189: goto -14 -> 175
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_3
    //   202: astore_1
    //   203: ldc 190
    //   205: ldc_w 310
    //   208: aload_2
    //   209: invokestatic 258	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   220: aload_1
    //   221: ifnull -38 -> 183
    //   224: aload_1
    //   225: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   228: return
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   234: return
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   240: goto -20 -> 220
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 4
    //   248: astore_2
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 303	java/io/FileOutputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   272: goto -15 -> 257
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   280: goto -15 -> 265
    //   283: astore_0
    //   284: aload 4
    //   286: astore_2
    //   287: goto -38 -> 249
    //   290: astore_0
    //   291: goto -42 -> 249
    //   294: astore_2
    //   295: aload_0
    //   296: astore_3
    //   297: aload_2
    //   298: astore_0
    //   299: aload_1
    //   300: astore_2
    //   301: aload_3
    //   302: astore_1
    //   303: goto -54 -> 249
    //   306: astore_2
    //   307: aload_1
    //   308: astore_0
    //   309: aload_3
    //   310: astore_1
    //   311: goto -108 -> 203
    //   314: astore 4
    //   316: aload_2
    //   317: astore_0
    //   318: aload_1
    //   319: astore_3
    //   320: aload 4
    //   322: astore_2
    //   323: aload_0
    //   324: astore_1
    //   325: aload_3
    //   326: astore_0
    //   327: goto -124 -> 203
    //   330: astore_1
    //   331: goto -296 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramqaf	qaf
    //   51	203	1	localObject1	Object
    //   267	2	1	localIOException1	IOException
    //   275	25	1	localIOException2	IOException
    //   302	23	1	localObject2	Object
    //   330	1	1	localException	Exception
    //   60	120	2	localObject3	Object
    //   198	11	2	localIOException3	IOException
    //   248	39	2	localObject4	Object
    //   294	4	2	localObject5	Object
    //   300	1	2	localIOException4	IOException
    //   306	11	2	localIOException5	IOException
    //   322	1	2	localIOException6	IOException
    //   4	322	3	localObject6	Object
    //   1	284	4	localObject7	Object
    //   314	7	4	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   171	175	184	java/io/IOException
    //   179	183	192	java/io/IOException
    //   5	35	198	java/io/IOException
    //   35	52	198	java/io/IOException
    //   224	228	229	java/io/IOException
    //   216	220	235	java/io/IOException
    //   5	35	243	finally
    //   35	52	243	finally
    //   253	257	267	java/io/IOException
    //   261	265	275	java/io/IOException
    //   52	134	283	finally
    //   134	167	290	finally
    //   203	212	294	finally
    //   52	134	306	java/io/IOException
    //   134	167	314	java/io/IOException
    //   5	35	330	java/lang/Exception
  }
  
  private static void a(rgp paramrgp, String paramString1, String paramString2)
  {
    paramrgp.setStringValue("emoji_pack_url_" + paramString1, paramString2);
  }
  
  public static String b(rgp paramrgp, String paramString)
  {
    return paramrgp.getStringValue("emoji_pack_name_" + paramString, "");
  }
  
  private static void b(rgp paramrgp, String paramString1, String paramString2)
  {
    paramrgp.setStringValue("emoji_pack_name_" + paramString1, paramString2);
  }
  
  private void bua()
  {
    long l = 0L;
    ram.d("DoodleEmojiManager", "fireRequestEmojiPackList, cookie = " + this.mCookie);
    if (this.bb.getAndSet(true))
    {
      if (this.BY != 0L) {
        l = SystemClock.elapsedRealtime() - this.BY;
      }
      if (l > 5000L) {
        ram.w("DoodleEmojiManager", "fireRequestEmojiPackList previous requesting is time out, fire another request, past time = %d", new Object[] { Long.valueOf(l) });
      }
    }
    else
    {
      this.BY = SystemClock.elapsedRealtime();
      ppv.a().a(new pys(this.mCookie, 50), new rgw(this));
      return;
    }
    ram.w("DoodleEmojiManager", "fireRequestEmojiPackList now is already requesting, just waiting is ok, requesting past time = %d", new Object[] { Long.valueOf(l) });
  }
  
  public static String c(rgp paramrgp, String paramString)
  {
    return paramrgp.getStringValue("emoji_pack_config_" + paramString, "");
  }
  
  private static void c(rgp paramrgp, String paramString1, String paramString2)
  {
    paramrgp.setStringValue("emoji_pack_config_" + paramString1, paramString2);
  }
  
  public static String d(rgp paramrgp, String paramString)
  {
    return paramrgp.getStringValue("emoji_pack_md5_" + paramString, "");
  }
  
  public static void d(rgp paramrgp, String paramString1, String paramString2)
  {
    paramrgp.setStringValue("emoji_pack_md5_" + paramString1, paramString2);
  }
  
  protected static String gf(@NonNull String paramString)
  {
    return aAy + File.separator + "emoji_zip_" + paramString;
  }
  
  protected static String gg(@NonNull String paramString)
  {
    return aAy + File.separator + "emoji_folder_" + paramString;
  }
  
  private static String i(@NonNull File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  private static void rp(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      ram.w("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      ram.w("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  private static boolean u(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new rgx());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  public void a(int paramInt1, int paramInt2, rgp.e parame)
  {
    parame = new WeakReference(parame);
    ppv.a().a(new pyz(paramInt1, paramInt2), new rgv(this, parame));
  }
  
  public void a(pua parampua, rgp.e parame)
  {
    ram.d("DoodleEmojiManager", "requestPoiFaces " + parame);
    pub localpub = (pub)psx.a(9);
    pua localpua = parampua;
    if (parampua == null) {
      localpua = localpub.b();
    }
    if (localpua != null)
    {
      a(localpua.mLongitude, localpua.mLatitude, parame);
      return;
    }
    localpub.a(new rgu(this, parame));
    localpub.aJK();
  }
  
  protected void a(boolean paramBoolean1, @NonNull qaf paramqaf, boolean paramBoolean2)
  {
    rgp localrgp = (rgp)psx.a(8);
    ArrayList localArrayList = new ArrayList(this.oL);
    if (paramBoolean1)
    {
      localArrayList.clear();
      if (!paramBoolean2) {
        a(paramqaf);
      }
    }
    Iterator localIterator = paramqaf.nA.iterator();
    qaf.a locala;
    rgo localrgo;
    if (localIterator.hasNext())
    {
      locala = (qaf.a)localIterator.next();
      if (locala.mType != 1) {
        break label476;
      }
      localrgo = (rgo)this.ck.get(locala.awr);
      if (localrgo == null) {
        break label476;
      }
      ??? = localrgo.getLocalEmojiFolderPath();
      if (TextUtils.equals(localrgo.aww, locala.aww)) {
        break label473;
      }
      ram.b("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", localrgo.aww, locala.aww);
    }
    for (;;)
    {
      try
      {
        rox.fA((String)???);
        ??? = null;
        localrgo = new rgo(locala);
        localrgo.setLocalEmojiFolderPath((String)???);
        a(localrgp, localrgo.awr, localrgo.aws);
        b(localrgp, localrgo.awr, localrgo.awu);
        c(localrgp, localrgo.awr, localrgo.awx);
        d(localrgp, localrgo.awr, localrgo.aww);
        this.ck.put(locala.awr, localrgo);
        if (paramBoolean2)
        {
          ram.b("DoodleEmojiManager", "from local get doodle item : %s", localrgo);
          localArrayList.remove(localrgo);
          localArrayList.add(localrgo);
        }
      }
      catch (Exception localException)
      {
        ram.w("DoodleEmojiManager", "remove folder : %s failed. error: %s .", new Object[] { ???, localException });
        continue;
        ram.b("DoodleEmojiManager", "from network get doodle item : %s", localException);
        continue;
      }
      do
      {
        synchronized (this.oL)
        {
          this.oL.clear();
          this.oL.addAll(localArrayList);
          pmi.a().dispatch(new rgp.b());
          this.bb.set(false);
          if ((!paramBoolean2) && (!paramqaf.mIsEnd))
          {
            bua();
            return;
          }
        }
      } while (localArrayList.size() <= 0);
      ram.d("DoodleEmojiManager", "start download the first emoji pack if needed : " + ((rgo)localArrayList.get(0)).awr);
      s(((rgo)localArrayList.get(0)).awr, false);
      return;
      label473:
      continue;
      label476:
      ??? = null;
    }
  }
  
  public void btZ()
  {
    ram.d("DoodleEmojiManager", "stopRequestSpeed.");
    ((LocationManager)QQStoryContext.a().getApplication().getSystemService("location")).removeUpdates(this.jdField_a_of_type_AndroidLocationLocationListener);
  }
  
  public void cG(Context paramContext)
  {
    ram.d("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + aAy);
    if (this.as.compareAndSet(0, 1))
    {
      paramContext = (rgp)psx.a(8);
      Object localObject1 = new File(aAy);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles(new rgq(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            File localFile = localObject1[i];
            Object localObject2 = localFile.listFiles(new rgr(this));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              localObject2 = i(localFile);
              Object localObject3 = b(paramContext, (String)localObject2);
              localObject3 = new rgo((String)localObject2, a(paramContext, (String)localObject2), (String)localObject3, null, c(paramContext, (String)localObject2), d(paramContext, (String)localObject2));
              ((rgo)localObject3).setLocalEmojiFolderPath(localFile.getPath());
              this.ck.put(localObject2, localObject3);
              ram.d("DoodleEmojiManager", "load local emoji pack : " + localObject3);
            }
            for (;;)
            {
              i += 1;
              break;
              try
              {
                rox.fA(localFile.getPath());
                ram.w("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
              }
              catch (Exception localException)
              {
                ram.w("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
              }
            }
          }
        }
      }
      else
      {
        ram.w("DoodleEmojiManager", "local emoji folder is empty");
      }
      paramContext = a();
      if ((paramContext != null) && (paramContext.mTimeStamp + 43200000L > System.currentTimeMillis()))
      {
        ram.i("DoodleEmojiManager", "has valid emoji packages cache. startTime=" + paramContext.mTimeStamp + " currentTime=" + System.currentTimeMillis());
        a(true, paramContext, true);
      }
      this.as.set(2);
    }
  }
  
  public List<rgo> cd()
  {
    if (!Lr()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.oL)
    {
      if (this.oL.isEmpty())
      {
        ram.w("DoodleEmojiManager", "current emoji packages is null.");
        List localList2 = Collections.EMPTY_LIST;
        return localList2;
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.oL);
    ram.i("DoodleEmojiManager", "current emoji packages's size=" + localArrayList.size());
    return localArrayList;
  }
  
  public String getStringValue(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString2 = this.u.getString(paramString1, paramString2);
    ram.d("DoodleEmojiManager", "getStringValue, key : %s, value : %s", paramString1, paramString2);
    return paramString2;
  }
  
  @NonNull
  public List<rgo> j(boolean paramBoolean)
  {
    if (!Lr()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.oL)
    {
      if (!this.oL.isEmpty()) {
        if (!paramBoolean) {
          break label53;
        }
      }
    }
    synchronized (this.bw)
    {
      this.mCookie = "";
      bua();
      label53:
      ??? = new ArrayList();
      ((List)???).addAll(this.oL);
      return ???;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public boolean s(String paramString, boolean paramBoolean)
  {
    if (!Lr()) {
      ram.w("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.as.get()) });
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    rgo localrgo = (rgo)this.ck.get(paramString);
    if (localrgo == null)
    {
      ram.w("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(gg(localrgo.awr));
    if ((u((File)???)) && (!paramBoolean))
    {
      ram.w("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localrgo.setLocalEmojiFolderPath(((File)???).getPath());
      pmi.a().dispatch(new rgp.a(localrgo, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localrgo.getLocalEmojiFolderPath()))
    {
      ram.w("DoodleEmojiManager", "local emoji folder is missing");
      localrgo.setLocalEmojiFolderPath(null);
    }
    if (TextUtils.isEmpty(localrgo.awv))
    {
      ram.w("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.bm)
    {
      if (!this.t.contains(localrgo))
      {
        this.t.offer(localrgo);
        ram.d("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        startDownload();
        return true;
      }
      ram.d("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void setStringValue(@NonNull String paramString1, @NonNull String paramString2)
  {
    ram.d("DoodleEmojiManager", "saveStringValue, key : %s, value : %s", paramString1, paramString2);
    this.u.edit().putString(paramString1, paramString2).apply();
  }
  
  protected void startDownload()
  {
    ram.d("DoodleEmojiManager", "startDownload");
    synchronized (this.bm)
    {
      if (this.jdField_a_of_type_Rgo == null)
      {
        this.jdField_a_of_type_Rgo = ((rgo)this.t.poll());
        if (this.jdField_a_of_type_Rgo != null)
        {
          ram.d("DoodleEmojiManager", "downloader startDownload : " + this.jdField_a_of_type_Rgo);
          Bosses.get().postJob(new rgs(this, this.jdField_a_of_type_Rgo));
        }
        return;
      }
      ram.d("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.jdField_a_of_type_Rgo);
    }
  }
  
  public static class a
    extends plt
  {
    public final long BZ;
    public final long Ca;
    public final boolean aBq;
    @NonNull
    public final rgo b;
    public final int mErrorCode;
    
    public a(@NonNull rgo paramrgo, int paramInt, boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.b = paramrgo;
      this.mErrorCode = paramInt;
      this.aBq = paramBoolean;
      this.BZ = paramLong1;
      this.Ca = paramLong2;
    }
  }
  
  public static class b
    extends plt
  {}
  
  public static class c
    extends plt
  {
    public final int mErrorCode;
    @NonNull
    public final List<ptr> oN;
    
    public c(int paramInt, @NonNull List<ptr> paramList)
    {
      this.mErrorCode = paramInt;
      this.oN = new ArrayList(paramList);
    }
  }
  
  static class d
    extends SimpleJob<rgo>
    implements pmp
  {
    private long Cb;
    private final pmy jdField_b_of_type_Pmy;
    private final rgo jdField_b_of_type_Rgo;
    protected long startDownloadTime;
    
    public d(rgo paramrgo)
    {
      super();
      if (paramrgo == null) {
        throw new IllegalArgumentException("doodleEmojiItem should not be null");
      }
      this.jdField_b_of_type_Pmy = new pmz();
      this.jdField_b_of_type_Pmy.a(this);
      this.jdField_b_of_type_Rgo = paramrgo;
    }
    
    protected rgo a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
    {
      this.jdField_b_of_type_Pmy.a(this.jdField_b_of_type_Rgo.awv, rgp.gf(this.jdField_b_of_type_Rgo.awr), 0L);
      return this.jdField_b_of_type_Rgo;
    }
    
    public void be(String paramString, int paramInt)
    {
      rgo localrgo1 = this.jdField_b_of_type_Rgo;
      if (paramInt == 0)
      {
        paramString = rgp.gf(localrgo1.awr);
        String str = rgp.gg(localrgo1.awr);
        ram.d("DoodleEmojiManager", "DownloadListener onDownloadFinish zip = " + paramString);
        ram.d("DoodleEmojiManager", "DownloadListener onDownloadFinish folder = " + str);
        for (;;)
        {
          int i;
          try
          {
            rox.fA(str);
            i = jqp.unZipFolder(paramString, str);
            if (i == 0)
            {
              long l1 = SystemClock.uptimeMillis();
              long l2 = this.startDownloadTime;
              rar.b("edit_video", "face_download_timecost", 0, 0, new String[] { localrgo1.awr, l1 - l2 + "" });
              rar.b("edit_video", "face_download_success", 0, 0, new String[] { localrgo1.awr });
              ram.i("DoodleEmojiManager", "DownloadListener onDownloadFinish success, unZip success");
              localrgo1.setLocalEmojiFolderPath(str);
              new File(str).setLastModified(System.currentTimeMillis());
              pmi.a().dispatch(new rgp.a(localrgo1, paramInt, true, 0L, 0L));
              return;
            }
          }
          catch (Exception localException)
          {
            ram.w("DoodleEmojiManager", "DownloadListener remove folderPath : %s ,error : %s ", new Object[] { str, localException });
            continue;
          }
          finally
          {
            new File(paramString).delete();
          }
          ram.w("DoodleEmojiManager", "DownloadListener onDownloadFinish unZip failed, treat it as download failed");
          pmi.a().dispatch(new rgp.a(localrgo2, i, false, 0L, 0L));
          rar.b("edit_video", "face_download_success", 0, i, new String[] { localrgo2.awr });
        }
      }
      ram.e("DoodleEmojiManager", "DownloadListener onDownloadFinish error = " + paramInt + ", url = " + paramString);
      pmi.a().dispatch(new rgp.a(localrgo2, paramInt, true, 0L, 0L));
      rar.b("edit_video", "face_download_success", 0, paramInt, new String[] { localrgo2.awr });
    }
    
    public void ck(String paramString1, String paramString2)
    {
      ram.d("DoodleEmojiManager", "onDownloadStart : url = " + paramString1 + ", path = " + paramString2);
      this.startDownloadTime = SystemClock.uptimeMillis();
    }
    
    public void onProgress(String paramString, long paramLong1, long paramLong2)
    {
      rgo localrgo = this.jdField_b_of_type_Rgo;
      if (!TextUtils.equals(localrgo.awv, paramString))
      {
        ram.w("DoodleEmojiManager", "DownloadListener onProgress error : " + localrgo);
        ram.w("DoodleEmojiManager", "DownloadListener onProgress error : call back url = " + paramString);
      }
      while (paramLong1 <= paramLong2 / 10L + this.Cb) {
        return;
      }
      ram.v("DoodleEmojiManager", "DownloadListener onProgress " + paramLong1 + " / " + paramLong2);
      pmi.a().dispatch(new rgp.a(localrgo, 0, false, paramLong2, paramLong1));
      this.Cb = paramLong1;
    }
  }
  
  public static abstract interface e
  {
    public abstract void D(int paramInt, List<ptr> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgp
 * JD-Core Version:    0.7.0.1
 */