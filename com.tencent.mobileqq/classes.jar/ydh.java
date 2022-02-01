import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
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
public class ydh
  implements vuf
{
  public static final String a;
  public final int a;
  public long a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private LocationListener jdField_a_of_type_AndroidLocationLocationListener = new ydl(this);
  public final Object a;
  public final List<ydg> a;
  public final Queue<ydg> a;
  public final ConcurrentHashMap<String, ydg> a;
  public AtomicBoolean a;
  public volatile AtomicInteger a;
  public ydg a;
  public final Object b;
  public String b;
  protected List<Location> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = vkm.g + "emoji";
    a(jdField_a_of_type_JavaLangString);
  }
  
  public ydh()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangObject = new Object[0];
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_Int = 50;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    BaseApplicationImpl localBaseApplicationImpl = QQStoryContext.a().a();
    if (localBaseApplicationImpl == null) {
      throw new IllegalArgumentException("Context should not be null");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("qqstory_emoji", 4);
  }
  
  private static String a(@NonNull File paramFile)
  {
    return paramFile.getName().substring("emoji_folder_".length());
  }
  
  protected static String a(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_zip_" + paramString;
  }
  
  public static String a(ydh paramydh, String paramString)
  {
    return paramydh.a("emoji_pack_url_" + paramString, "");
  }
  
  private static wgb a()
  {
    int i = 0;
    try
    {
      byte[] arrayOfByte = ypi.b(new File(jdField_a_of_type_JavaLangString + "/" + "list.pb"));
      if (arrayOfByte != null) {
        i = arrayOfByte.length;
      }
      xvv.a("DoodleEmojiManager", "restoreFilterItemListLocked file length = %d", Integer.valueOf(i));
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
          return new wgb((qqstory_service.RspGetEmoticonPackList)localObject, arrayOfByte, l);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          xvv.e("DoodleEmojiManager", "restoreResponseFromFile error : " + localInvalidProtocolBufferMicroException);
          return null;
        }
      }
      return null;
    }
    catch (IOException localIOException)
    {
      xvv.d("DoodleEmojiManager", "restoreResponseFromFile failed FileNotFoundException");
      return null;
      xvv.d("DoodleEmojiManager", "restoreResponseFromFile find illegal file with magic code %d", new Object[] { Integer.valueOf(i) });
      return null;
    }
    catch (Exception localException)
    {
      xvv.c("DoodleEmojiManager", "restoreResponseFromFile failed", localException);
    }
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      xvv.d("DoodleEmojiManager", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      xvv.d("DoodleEmojiManager", "create folder : " + bool);
    }
  }
  
  /* Error */
  public static void a(wgb paramwgb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 31	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   12: getstatic 51	ydh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 169
    //   20: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 171
    //   25: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 273	ypi:d	(Ljava/lang/String;)Z
    //   34: pop
    //   35: getstatic 51	ydh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokestatic 54	ydh:a	(Ljava/lang/String;)V
    //   41: new 275	java/io/ByteArrayOutputStream
    //   44: dup
    //   45: sipush 8192
    //   48: invokespecial 276	java/io/ByteArrayOutputStream:<init>	(I)V
    //   51: astore_1
    //   52: new 278	java/io/ObjectOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 281	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: bipush 18
    //   64: invokevirtual 284	java/io/ObjectOutputStream:writeInt	(I)V
    //   67: aload_2
    //   68: aload_0
    //   69: getfield 286	wgb:jdField_a_of_type_Long	J
    //   72: invokevirtual 290	java/io/ObjectOutputStream:writeLong	(J)V
    //   75: aload_2
    //   76: aload_0
    //   77: getfield 293	wgb:jdField_a_of_type_ArrayOfByte	[B
    //   80: arraylength
    //   81: invokevirtual 284	java/io/ObjectOutputStream:writeInt	(I)V
    //   84: aload_2
    //   85: aload_0
    //   86: getfield 293	wgb:jdField_a_of_type_ArrayOfByte	[B
    //   89: invokevirtual 296	java/io/ObjectOutputStream:write	([B)V
    //   92: aload_2
    //   93: invokevirtual 299	java/io/ObjectOutputStream:flush	()V
    //   96: aload_2
    //   97: invokevirtual 302	java/io/ObjectOutputStream:close	()V
    //   100: new 304	java/io/FileOutputStream
    //   103: dup
    //   104: new 31	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   111: getstatic 51	ydh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 169
    //   119: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 171
    //   124: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokespecial 305	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   133: astore_2
    //   134: aload_1
    //   135: aload_2
    //   136: invokevirtual 308	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   139: aload_1
    //   140: invokevirtual 309	java/io/ByteArrayOutputStream:flush	()V
    //   143: aload_1
    //   144: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   147: aload_2
    //   148: invokevirtual 311	java/io/FileOutputStream:close	()V
    //   151: ldc 179
    //   153: ldc_w 313
    //   156: aload_0
    //   157: getfield 293	wgb:jdField_a_of_type_ArrayOfByte	[B
    //   160: arraylength
    //   161: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   164: invokestatic 192	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 311	java/io/FileOutputStream:close	()V
    //   183: return
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   189: goto -14 -> 175
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_3
    //   202: astore_1
    //   203: ldc 179
    //   205: ldc_w 318
    //   208: aload_2
    //   209: invokestatic 249	xvv:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   220: aload_1
    //   221: ifnull -38 -> 183
    //   224: aload_1
    //   225: invokevirtual 311	java/io/FileOutputStream:close	()V
    //   228: return
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   234: return
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   240: goto -20 -> 220
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_1
    //   246: aload 4
    //   248: astore_2
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 311	java/io/FileOutputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 316	java/io/IOException:printStackTrace	()V
    //   272: goto -15 -> 257
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 316	java/io/IOException:printStackTrace	()V
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
    //   0	334	0	paramwgb	wgb
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
  
  public static void a(ydh paramydh, String paramString1, String paramString2)
  {
    paramydh.a("emoji_pack_md5_" + paramString1, paramString2);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 2;
  }
  
  private static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {}
    do
    {
      return false;
      paramFile = paramFile.listFiles(new ydp());
    } while ((paramFile == null) || (paramFile.length <= 0));
    return true;
  }
  
  protected static String b(@NonNull String paramString)
  {
    return jdField_a_of_type_JavaLangString + File.separator + "emoji_folder_" + paramString;
  }
  
  public static String b(ydh paramydh, String paramString)
  {
    return paramydh.a("emoji_pack_name_" + paramString, "");
  }
  
  private static void b(ydh paramydh, String paramString1, String paramString2)
  {
    paramydh.a("emoji_pack_url_" + paramString1, paramString2);
  }
  
  public static String c(ydh paramydh, String paramString)
  {
    return paramydh.a("emoji_pack_config_" + paramString, "");
  }
  
  private static void c(ydh paramydh, String paramString1, String paramString2)
  {
    paramydh.a("emoji_pack_name_" + paramString1, paramString2);
  }
  
  public static String d(ydh paramydh, String paramString)
  {
    return paramydh.a("emoji_pack_md5_" + paramString, "");
  }
  
  private static void d(ydh paramydh, String paramString1, String paramString2)
  {
    paramydh.a("emoji_pack_config_" + paramString1, paramString2);
  }
  
  private void e()
  {
    long l = 0L;
    xvv.b("DoodleEmojiManager", "fireRequestEmojiPackList, cookie = " + this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
    {
      if (this.jdField_a_of_type_Long != 0L) {
        l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      }
      if (l > 5000L) {
        xvv.d("DoodleEmojiManager", "fireRequestEmojiPackList previous requesting is time out, fire another request, past time = %d", new Object[] { Long.valueOf(l) });
      }
    }
    else
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      vqn.a().a(new wed(this.jdField_b_of_type_JavaLangString, 50), new ydo(this));
      return;
    }
    xvv.d("DoodleEmojiManager", "fireRequestEmojiPackList now is already requesting, just waiting is ok, requesting past time = %d", new Object[] { Long.valueOf(l) });
  }
  
  public String a(@NonNull String paramString1, @NonNull String paramString2)
  {
    paramString2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
    xvv.b("DoodleEmojiManager", "getStringValue, key : %s, value : %s", paramString1, paramString2);
    return paramString2;
  }
  
  public List<ydg> a()
  {
    if (!a()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        xvv.d("DoodleEmojiManager", "current emoji packages is null.");
        List localList2 = Collections.EMPTY_LIST;
        return localList2;
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    xvv.c("DoodleEmojiManager", "current emoji packages's size=" + localArrayList.size());
    return localArrayList;
  }
  
  @NonNull
  public List<ydg> a(boolean paramBoolean)
  {
    if (!a()) {
      return Collections.EMPTY_LIST;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        if (!paramBoolean) {
          break label53;
        }
      }
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangString = "";
      e();
      label53:
      ??? = new ArrayList();
      ((List)???).addAll(this.jdField_a_of_type_JavaUtilList);
      return ???;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, ydu paramydu)
  {
    paramydu = new WeakReference(paramydu);
    vqn.a().a(new wen(paramInt1, paramInt2), new ydn(this, paramydu));
  }
  
  public void a(Context paramContext)
  {
    xvv.b("DoodleEmojiManager", "initLocalPackages, doodle emoji path : " + jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.compareAndSet(0, 1))
    {
      paramContext = (ydh)vux.a(8);
      Object localObject1 = new File(jdField_a_of_type_JavaLangString);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject1 = ((File)localObject1).listFiles(new ydi(this));
        if (localObject1 != null)
        {
          int j = localObject1.length;
          int i = 0;
          if (i < j)
          {
            File localFile = localObject1[i];
            Object localObject2 = localFile.listFiles(new ydj(this));
            if ((localObject2 != null) && (localObject2.length > 0))
            {
              localObject2 = a(localFile);
              Object localObject3 = b(paramContext, (String)localObject2);
              localObject3 = new ydg((String)localObject2, a(paramContext, (String)localObject2), (String)localObject3, null, c(paramContext, (String)localObject2), d(paramContext, (String)localObject2));
              ((ydg)localObject3).a(localFile.getPath());
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject2, localObject3);
              xvv.b("DoodleEmojiManager", "load local emoji pack : " + localObject3);
            }
            for (;;)
            {
              i += 1;
              break;
              try
              {
                ypi.d(localFile.getPath());
                xvv.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete it");
              }
              catch (Exception localException)
              {
                xvv.d("DoodleEmojiManager", "find empty local emoji folder : " + localFile.getName() + ", delete failed : " + localException);
              }
            }
          }
        }
      }
      else
      {
        xvv.d("DoodleEmojiManager", "local emoji folder is empty");
      }
      paramContext = a();
      if ((paramContext != null) && (paramContext.jdField_a_of_type_Long + 43200000L > System.currentTimeMillis()))
      {
        xvv.c("DoodleEmojiManager", "has valid emoji packages cache. startTime=" + paramContext.jdField_a_of_type_Long + " currentTime=" + System.currentTimeMillis());
        a(true, paramContext, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(2);
    }
  }
  
  public void a(@NonNull String paramString1, @NonNull String paramString2)
  {
    xvv.b("DoodleEmojiManager", "saveStringValue, key : %s, value : %s", paramString1, paramString2);
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).apply();
  }
  
  public void a(vwp paramvwp, ydu paramydu)
  {
    xvv.b("DoodleEmojiManager", "requestPoiFaces " + paramydu);
    vwq localvwq = (vwq)vux.a(9);
    vwp localvwp = paramvwp;
    if (paramvwp == null) {
      localvwp = localvwq.b();
    }
    if (localvwp != null)
    {
      a(localvwp.b, localvwp.jdField_a_of_type_Int, paramydu);
      return;
    }
    localvwq.a(new ydm(this, paramydu));
    localvwq.c();
  }
  
  protected void a(boolean paramBoolean1, @NonNull wgb paramwgb, boolean paramBoolean2)
  {
    ydh localydh = (ydh)vux.a(8);
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    if (paramBoolean1)
    {
      localArrayList.clear();
      if (!paramBoolean2) {
        a(paramwgb);
      }
    }
    Iterator localIterator = paramwgb.jdField_a_of_type_JavaUtilList.iterator();
    wgc localwgc;
    ydg localydg;
    if (localIterator.hasNext())
    {
      localwgc = (wgc)localIterator.next();
      if (localwgc.b != 1) {
        break label476;
      }
      localydg = (ydg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localwgc.jdField_a_of_type_JavaLangString);
      if (localydg == null) {
        break label476;
      }
      ??? = localydg.a();
      if (TextUtils.equals(localydg.g, localwgc.f)) {
        break label473;
      }
      xvv.a("DoodleEmojiManager", "EmojiPack md5 has changed. old : %s, new : %s", localydg.g, localwgc.f);
    }
    for (;;)
    {
      try
      {
        ypi.d((String)???);
        ??? = null;
        localydg = new ydg(localwgc);
        localydg.a((String)???);
        b(localydh, localydg.jdField_a_of_type_JavaLangString, localydg.jdField_b_of_type_JavaLangString);
        c(localydh, localydg.jdField_a_of_type_JavaLangString, localydg.d);
        d(localydh, localydg.jdField_a_of_type_JavaLangString, localydg.f);
        a(localydh, localydg.jdField_a_of_type_JavaLangString, localydg.g);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localwgc.jdField_a_of_type_JavaLangString, localydg);
        if (paramBoolean2)
        {
          xvv.a("DoodleEmojiManager", "from local get doodle item : %s", localydg);
          localArrayList.remove(localydg);
          localArrayList.add(localydg);
        }
      }
      catch (Exception localException)
      {
        xvv.d("DoodleEmojiManager", "remove folder : %s failed. error: %s .", new Object[] { ???, localException });
        continue;
        xvv.a("DoodleEmojiManager", "from network get doodle item : %s", localException);
        continue;
      }
      do
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
          vli.a().dispatch(new ydr());
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          if ((!paramBoolean2) && (!paramwgb.jdField_a_of_type_Boolean))
          {
            e();
            return;
          }
        }
      } while (localArrayList.size() <= 0);
      xvv.b("DoodleEmojiManager", "start download the first emoji pack if needed : " + ((ydg)localArrayList.get(0)).jdField_a_of_type_JavaLangString);
      a(((ydg)localArrayList.get(0)).jdField_a_of_type_JavaLangString, false);
      return;
      label473:
      continue;
      label476:
      ??? = null;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    if (!a()) {
      xvv.d("DoodleEmojiManager", "downloadEmojiPack init state = %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get()) });
    }
    if (paramString == null) {
      throw new IllegalArgumentException("pack id should not be null");
    }
    ydg localydg = (ydg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localydg == null)
    {
      xvv.d("DoodleEmojiManager", "can not find pack item by id " + paramString);
      return false;
    }
    ??? = new File(b(localydg.jdField_a_of_type_JavaLangString));
    if ((a((File)???)) && (!paramBoolean))
    {
      xvv.d("DoodleEmojiManager", "already has local emoji folder, notify download success directly");
      localydg.a(((File)???).getPath());
      vli.a().dispatch(new ydq(localydg, 0, true, 0L, 0L));
      return true;
    }
    if (!TextUtils.isEmpty(localydg.a()))
    {
      xvv.d("DoodleEmojiManager", "local emoji folder is missing");
      localydg.a(null);
    }
    if (TextUtils.isEmpty(localydg.e))
    {
      xvv.d("DoodleEmojiManager", "can not start download because of empty download-url is found");
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.contains(localydg))
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localydg);
        xvv.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " enqueue");
        c();
        return true;
      }
      xvv.b("DoodleEmojiManager", "downloadEmojiPack pack " + paramString + " is already in pending list");
    }
  }
  
  public void b() {}
  
  protected void c()
  {
    xvv.b("DoodleEmojiManager", "startDownload");
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Ydg == null)
      {
        this.jdField_a_of_type_Ydg = ((ydg)this.jdField_a_of_type_JavaUtilQueue.poll());
        if (this.jdField_a_of_type_Ydg != null)
        {
          xvv.b("DoodleEmojiManager", "downloader startDownload : " + this.jdField_a_of_type_Ydg);
          Bosses.get().postJob(new ydk(this, this.jdField_a_of_type_Ydg));
        }
        return;
      }
      xvv.b("DoodleEmojiManager", "can not start download because find one is still downloading : " + this.jdField_a_of_type_Ydg);
    }
  }
  
  public void d()
  {
    xvv.b("DoodleEmojiManager", "stopRequestSpeed.");
    ((LocationManager)QQStoryContext.a().a().getSystemService("location")).removeUpdates(this.jdField_a_of_type_AndroidLocationLocationListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ydh
 * JD-Core Version:    0.7.0.1
 */