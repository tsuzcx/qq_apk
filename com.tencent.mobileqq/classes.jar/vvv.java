import android.annotation.TargetApi;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@TargetApi(11)
public class vvv
  implements vuf
{
  public static final String a;
  public static final String b;
  @GuardedBy("filterItemList")
  private int jdField_a_of_type_Int;
  @GuardedBy("filterItemList")
  private long jdField_a_of_type_Long;
  @GuardedBy("filterItemList")
  private FilterItem jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem;
  @GuardedBy("get list process")
  protected final List<FilterItem> a;
  protected Map<String, vvs> a;
  @GuardedBy("filterItemList")
  private Queue<FilterItem> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private final vmd jdField_a_of_type_Vmd = new vme();
  @GuardedBy("filterItemList")
  protected final List<FilterItem> b;
  @GuardedBy("get list process")
  protected String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = vkm.g + "filter";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "list_cache";
  }
  
  public vvv()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.filterConfigMd5))) {
      return jdField_a_of_type_JavaLangString + "/" + paramFilterItem.filterConfigMd5;
    }
    return null;
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isFile()) {
      xvv.d("VideoFilterManager", "delete file : %s", new Object[] { Boolean.valueOf(paramString.delete()) });
    }
    if (!paramString.exists()) {
      xvv.d("VideoFilterManager", "create folder : %s", new Object[] { Boolean.valueOf(paramString.mkdirs()) });
    }
  }
  
  /* Error */
  @GuardedBy("filterItemList")
  private boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 31	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 55	vvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 107
    //   21: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 149
    //   26: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 154	ypi:d	(Ljava/lang/String;)Z
    //   35: pop
    //   36: new 156	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: sipush 4096
    //   43: invokespecial 159	java/io/ByteArrayOutputStream:<init>	(I)V
    //   46: astore_2
    //   47: new 161	java/io/ObjectOutputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 164	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_3
    //   56: aload_3
    //   57: aload_0
    //   58: getfield 166	vvv:jdField_a_of_type_Long	J
    //   61: invokevirtual 170	java/io/ObjectOutputStream:writeLong	(J)V
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 172	vvv:jdField_a_of_type_Int	I
    //   69: invokevirtual 175	java/io/ObjectOutputStream:writeInt	(I)V
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 75	vvv:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   77: invokevirtual 179	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload_3
    //   81: invokevirtual 182	java/io/ObjectOutputStream:flush	()V
    //   84: aload_3
    //   85: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   88: new 187	java/io/FileOutputStream
    //   91: dup
    //   92: new 31	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   99: getstatic 55	vvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   102: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 107
    //   107: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 149
    //   112: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_2
    //   123: aload_1
    //   124: invokevirtual 191	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   127: aload_2
    //   128: invokevirtual 192	java/io/ByteArrayOutputStream:flush	()V
    //   131: aload_2
    //   132: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_1
    //   136: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   139: ldc 118
    //   141: ldc 196
    //   143: aload_0
    //   144: getfield 75	vvv:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   147: invokeinterface 202 1 0
    //   152: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: invokestatic 210	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   189: goto -23 -> 166
    //   192: astore_2
    //   193: aload_2
    //   194: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   197: goto -23 -> 174
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: ldc 118
    //   214: ldc 215
    //   216: aload_3
    //   217: invokestatic 218	xvv:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   253: goto -25 -> 228
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   261: goto -25 -> 236
    //   264: astore_1
    //   265: aload_1
    //   266: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   269: goto -23 -> 246
    //   272: astore_1
    //   273: aconst_null
    //   274: astore_3
    //   275: aconst_null
    //   276: astore_2
    //   277: aload 5
    //   279: astore 4
    //   281: aload_2
    //   282: ifnull +7 -> 289
    //   285: aload_2
    //   286: invokevirtual 193	java/io/ByteArrayOutputStream:close	()V
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 185	java/io/ObjectOutputStream:close	()V
    //   297: aload 4
    //   299: ifnull +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 194	java/io/FileOutputStream:close	()V
    //   307: aload_1
    //   308: athrow
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   314: goto -25 -> 289
    //   317: astore_2
    //   318: aload_2
    //   319: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   322: goto -25 -> 297
    //   325: astore_2
    //   326: aload_2
    //   327: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   330: goto -23 -> 307
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_3
    //   336: aload 5
    //   338: astore 4
    //   340: goto -59 -> 281
    //   343: astore_1
    //   344: aload 5
    //   346: astore 4
    //   348: goto -67 -> 281
    //   351: astore 5
    //   353: aload_1
    //   354: astore 4
    //   356: aload 5
    //   358: astore_1
    //   359: goto -78 -> 281
    //   362: astore 5
    //   364: aload_1
    //   365: astore_3
    //   366: aload 5
    //   368: astore_1
    //   369: goto -88 -> 281
    //   372: astore_3
    //   373: aconst_null
    //   374: astore_1
    //   375: goto -163 -> 212
    //   378: astore 5
    //   380: aload_3
    //   381: astore_1
    //   382: aload 5
    //   384: astore_3
    //   385: goto -173 -> 212
    //   388: astore 4
    //   390: aload_3
    //   391: astore 5
    //   393: aload 4
    //   395: astore_3
    //   396: aload_1
    //   397: astore 4
    //   399: aload 5
    //   401: astore_1
    //   402: goto -190 -> 212
    //   405: astore_1
    //   406: goto -370 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	this	vvv
    //   121	58	1	localFileOutputStream	java.io.FileOutputStream
    //   200	2	1	localIOException1	java.io.IOException
    //   209	24	1	localObject1	Object
    //   256	2	1	localIOException2	java.io.IOException
    //   264	2	1	localIOException3	java.io.IOException
    //   272	36	1	localObject2	Object
    //   333	1	1	localObject3	Object
    //   343	11	1	localObject4	Object
    //   358	44	1	localObject5	Object
    //   405	1	1	localException	Exception
    //   46	117	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   184	2	2	localIOException4	java.io.IOException
    //   192	2	2	localIOException5	java.io.IOException
    //   211	14	2	localObject6	Object
    //   248	2	2	localIOException6	java.io.IOException
    //   276	10	2	localObject7	Object
    //   309	2	2	localIOException7	java.io.IOException
    //   317	2	2	localIOException8	java.io.IOException
    //   325	2	2	localIOException9	java.io.IOException
    //   55	116	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   207	10	3	localIOException10	java.io.IOException
    //   274	92	3	localObject8	Object
    //   372	9	3	localIOException11	java.io.IOException
    //   384	12	3	localIOException12	java.io.IOException
    //   4	351	4	localObject9	Object
    //   388	6	4	localIOException13	java.io.IOException
    //   397	1	4	localObject10	Object
    //   1	344	5	localObject11	Object
    //   351	6	5	localObject12	Object
    //   362	5	5	localObject13	Object
    //   378	5	5	localIOException14	java.io.IOException
    //   391	9	5	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   162	166	184	java/io/IOException
    //   170	174	192	java/io/IOException
    //   178	182	200	java/io/IOException
    //   6	36	207	java/io/IOException
    //   36	47	207	java/io/IOException
    //   224	228	248	java/io/IOException
    //   232	236	256	java/io/IOException
    //   241	246	264	java/io/IOException
    //   6	36	272	finally
    //   36	47	272	finally
    //   285	289	309	java/io/IOException
    //   293	297	317	java/io/IOException
    //   302	307	325	java/io/IOException
    //   47	56	333	finally
    //   56	122	343	finally
    //   122	158	351	finally
    //   212	220	362	finally
    //   47	56	372	java/io/IOException
    //   56	122	378	java/io/IOException
    //   122	158	388	java/io/IOException
    //   6	36	405	java/lang/Exception
  }
  
  public static boolean a(FilterItem paramFilterItem)
  {
    return a(a(paramFilterItem), false);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(paramString);
      if ((localFile.exists()) && (localFile.isDirectory()))
      {
        localFile = new File(paramString, "config.json");
        if ((localFile.exists()) && (localFile.isFile())) {
          return true;
        }
        if (paramBoolean) {
          xvv.d("VideoFilterManager", "remove illegal filter folder : %s", new Object[] { paramString });
        }
      }
    }
    try
    {
      ypi.d(paramString);
      label81:
      return false;
    }
    catch (Exception paramString)
    {
      break label81;
    }
  }
  
  private static String b(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.filterConfigMd5))) {
      return jdField_a_of_type_JavaLangString + "/" + paramFilterItem.filterConfigMd5 + ".zip";
    }
    return null;
  }
  
  /* Error */
  @GuardedBy("filterItemList")
  private boolean b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 239	java/io/ByteArrayInputStream
    //   6: dup
    //   7: new 110	java/io/File
    //   10: dup
    //   11: new 31	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   18: getstatic 55	vvv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   21: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 107
    //   26: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 149
    //   31: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokestatic 242	ypi:b	(Ljava/io/File;)[B
    //   43: invokespecial 245	java/io/ByteArrayInputStream:<init>	([B)V
    //   46: astore_2
    //   47: new 247	java/io/ObjectInputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 250	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_3
    //   56: aload_3
    //   57: astore 4
    //   59: aload_2
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 75	vvv:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   66: invokeinterface 253 1 0
    //   71: aload_3
    //   72: astore 4
    //   74: aload_2
    //   75: astore 5
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 257	java/io/ObjectInputStream:readLong	()J
    //   82: putfield 166	vvv:jdField_a_of_type_Long	J
    //   85: aload_3
    //   86: astore 4
    //   88: aload_2
    //   89: astore 5
    //   91: aload_0
    //   92: aload_3
    //   93: invokevirtual 260	java/io/ObjectInputStream:readInt	()I
    //   96: putfield 172	vvv:jdField_a_of_type_Int	I
    //   99: aload_3
    //   100: astore 4
    //   102: aload_2
    //   103: astore 5
    //   105: aload_3
    //   106: invokevirtual 264	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   109: checkcast 198	java/util/List
    //   112: astore 6
    //   114: aload 6
    //   116: ifnull +21 -> 137
    //   119: aload_3
    //   120: astore 4
    //   122: aload_2
    //   123: astore 5
    //   125: aload_0
    //   126: getfield 75	vvv:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   129: aload 6
    //   131: invokeinterface 268 2 0
    //   136: pop
    //   137: aload 6
    //   139: ifnull +53 -> 192
    //   142: aload_3
    //   143: astore 4
    //   145: aload_2
    //   146: astore 5
    //   148: aload 6
    //   150: invokeinterface 202 1 0
    //   155: istore_1
    //   156: aload_3
    //   157: astore 4
    //   159: aload_2
    //   160: astore 5
    //   162: ldc 118
    //   164: ldc_w 270
    //   167: iload_1
    //   168: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   171: invokestatic 210	xvv:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   190: iconst_1
    //   191: ireturn
    //   192: iconst_0
    //   193: istore_1
    //   194: goto -38 -> 156
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_2
    //   200: aload 4
    //   202: astore_3
    //   203: ldc 118
    //   205: ldc_w 274
    //   208: invokestatic 276	xvv:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_2
    //   212: ifnull +7 -> 219
    //   215: aload_2
    //   216: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   219: aload_3
    //   220: ifnull +7 -> 227
    //   223: aload_3
    //   224: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: astore 6
    //   231: aconst_null
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: aload_3
    //   236: astore 4
    //   238: aload_2
    //   239: astore 5
    //   241: ldc 118
    //   243: ldc_w 278
    //   246: aload 6
    //   248: invokestatic 218	xvv:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   259: aload_3
    //   260: ifnull -33 -> 227
    //   263: aload_3
    //   264: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   267: goto -40 -> 227
    //   270: astore_2
    //   271: goto -44 -> 227
    //   274: astore_3
    //   275: aconst_null
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_2
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 271	java/io/ByteArrayInputStream:close	()V
    //   288: aload 4
    //   290: ifnull +8 -> 298
    //   293: aload 4
    //   295: invokevirtual 272	java/io/ObjectInputStream:close	()V
    //   298: aload_3
    //   299: athrow
    //   300: astore_2
    //   301: goto -119 -> 182
    //   304: astore_2
    //   305: iconst_1
    //   306: ireturn
    //   307: astore_2
    //   308: goto -89 -> 219
    //   311: astore_2
    //   312: goto -85 -> 227
    //   315: astore_2
    //   316: goto -57 -> 259
    //   319: astore_2
    //   320: goto -32 -> 288
    //   323: astore_2
    //   324: goto -26 -> 298
    //   327: astore_3
    //   328: aconst_null
    //   329: astore 4
    //   331: goto -51 -> 280
    //   334: astore_3
    //   335: aload 5
    //   337: astore_2
    //   338: goto -58 -> 280
    //   341: astore 5
    //   343: aload_3
    //   344: astore 4
    //   346: aload 5
    //   348: astore_3
    //   349: goto -69 -> 280
    //   352: astore 6
    //   354: aconst_null
    //   355: astore_3
    //   356: goto -121 -> 235
    //   359: astore 6
    //   361: goto -126 -> 235
    //   364: astore_3
    //   365: aload 4
    //   367: astore_3
    //   368: goto -165 -> 203
    //   371: astore 4
    //   373: goto -170 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	vvv
    //   155	39	1	i	int
    //   46	133	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   197	1	2	localIOException1	java.io.IOException
    //   199	57	2	localObject1	Object
    //   270	1	2	localIOException2	java.io.IOException
    //   279	6	2	localObject2	Object
    //   300	1	2	localIOException3	java.io.IOException
    //   304	1	2	localIOException4	java.io.IOException
    //   307	1	2	localIOException5	java.io.IOException
    //   311	1	2	localIOException6	java.io.IOException
    //   315	1	2	localIOException7	java.io.IOException
    //   319	1	2	localIOException8	java.io.IOException
    //   323	1	2	localIOException9	java.io.IOException
    //   337	1	2	localObject3	Object
    //   55	209	3	localObject4	Object
    //   274	25	3	localObject5	Object
    //   327	1	3	localObject6	Object
    //   334	10	3	localObject7	Object
    //   348	8	3	localObject8	Object
    //   364	1	3	localIOException10	java.io.IOException
    //   367	1	3	localObject9	Object
    //   1	365	4	localObject10	Object
    //   371	1	4	localIOException11	java.io.IOException
    //   60	276	5	localObject11	Object
    //   341	6	5	localObject12	Object
    //   112	37	6	localList	List
    //   229	18	6	localException1	Exception
    //   352	1	6	localException2	Exception
    //   359	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   3	47	197	java/io/IOException
    //   3	47	229	java/lang/Exception
    //   263	267	270	java/io/IOException
    //   3	47	274	finally
    //   178	182	300	java/io/IOException
    //   186	190	304	java/io/IOException
    //   215	219	307	java/io/IOException
    //   223	227	311	java/io/IOException
    //   255	259	315	java/io/IOException
    //   284	288	319	java/io/IOException
    //   293	298	323	java/io/IOException
    //   47	56	327	finally
    //   62	71	334	finally
    //   77	85	334	finally
    //   91	99	334	finally
    //   105	114	334	finally
    //   125	137	334	finally
    //   148	156	334	finally
    //   162	174	334	finally
    //   241	251	334	finally
    //   203	211	341	finally
    //   47	56	352	java/lang/Exception
    //   62	71	359	java/lang/Exception
    //   77	85	359	java/lang/Exception
    //   91	99	359	java/lang/Exception
    //   105	114	359	java/lang/Exception
    //   125	137	359	java/lang/Exception
    //   148	156	359	java/lang/Exception
    //   162	174	359	java/lang/Exception
    //   47	56	364	java/io/IOException
    //   62	71	371	java/io/IOException
    //   77	85	371	java/io/IOException
    //   91	99	371	java/io/IOException
    //   105	114	371	java/io/IOException
    //   125	137	371	java/io/IOException
    //   148	156	371	java/io/IOException
    //   162	174	371	java/io/IOException
  }
  
  @NonNull
  public List<FilterItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      FilterItem localFilterItem;
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localFilterItem = (FilterItem)localIterator.next();
        if ((localFilterItem.isLocalType()) || (a(localFilterItem)))
        {
          localArrayList.add(localFilterItem);
          xvv.a("VideoFilterManager", "add to display : %s", localFilterItem);
        }
      }
      xvv.a("VideoFilterManager", "ignore display : %s", localFilterItem);
    }
    a(this.jdField_b_of_type_JavaUtilList.isEmpty());
    return localList1;
  }
  
  @Nullable
  public vvs a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem == null) || (paramFilterItem.isLocalType()) || (!a(paramFilterItem))) {
      paramFilterItem = null;
    }
    String str;
    Object localObject;
    do
    {
      do
      {
        return paramFilterItem;
        str = a(paramFilterItem);
        localObject = (vvs)this.jdField_a_of_type_JavaUtilMap.get(str);
        paramFilterItem = (FilterItem)localObject;
      } while (localObject != null);
      try
      {
        paramFilterItem = a(new File(str, "config.json"));
        localObject = paramFilterItem;
      }
      catch (Exception paramFilterItem)
      {
        for (;;)
        {
          xvv.b("VideoFilterManager", "getFilterItemConfig, parse config file failed", paramFilterItem);
        }
      }
      paramFilterItem = (FilterItem)localObject;
    } while (localObject == null);
    this.jdField_a_of_type_JavaUtilMap.put(str, localObject);
    return localObject;
  }
  
  protected vvs a(File paramFile)
  {
    if ((!paramFile.exists()) || (!paramFile.isFile()) || (!paramFile.canRead()))
    {
      xvv.d("VideoFilterManager", "parseFilterConfigFile failed, file is illegal %s", new Object[] { paramFile });
      return null;
    }
    long l = SystemClock.uptimeMillis();
    paramFile = (vvs)JsonORM.a(new JSONObject(new String(ypi.a(paramFile), "UTF-8")), vvs.class);
    xvv.a("VideoFilterManager", "parseFilterConfigFile success, cost = %d ms", Long.valueOf(SystemClock.uptimeMillis() - l));
    return paramFile;
  }
  
  public void a()
  {
    xvv.d("VideoFilterManager", "onInit");
    a(jdField_a_of_type_JavaLangString);
    a(jdField_b_of_type_JavaLangString);
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      b();
      return;
    }
  }
  
  @GuardedBy("get list process")
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      synchronized (this.jdField_b_of_type_JavaUtilList)
      {
        xvv.a("VideoFilterManager", "fireGetFilterListFinish, filter count %d -> %d", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
        this.jdField_b_of_type_JavaUtilList.clear();
        this.jdField_b_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Int = paramInt;
        a();
        this.jdField_a_of_type_JavaUtilQueue.clear();
        Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          FilterItem localFilterItem = (FilterItem)localIterator.next();
          if ((!localFilterItem.isLocalType()) && (!a(localFilterItem))) {
            this.jdField_a_of_type_JavaUtilQueue.offer(localFilterItem);
          }
        }
      }
      xvv.a("VideoFilterManager", "fireGetFilterListFinish, download pending list size = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilQueue.size()));
      d();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) > this.jdField_a_of_type_Int * 1000) || (paramBoolean))
    {
      if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(true))
      {
        xvv.d("VideoFilterManager", "fireGetFilterList full list");
        this.c = "";
        this.jdField_a_of_type_JavaUtilList.clear();
        c();
        return true;
      }
      xvv.d("VideoFilterManager", "fireGetFilterList ignore because we are requesting ..");
    }
    for (;;)
    {
      return false;
      xvv.d("VideoFilterManager", "fireGetFilterList ignore because you request too frequently, frequency = %d s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public void b()
  {
    xvv.d("VideoFilterManager", "onDestroy");
    e();
  }
  
  @GuardedBy("get list process")
  protected void c()
  {
    xvv.a("VideoFilterManager", "fireGetFilterListInner %s", this.c);
    vqn.a().a(new vvy(this.c), new vvx(this, null));
  }
  
  protected void d()
  {
    FilterItem localFilterItem = null;
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem == null)
      {
        localFilterItem = (FilterItem)this.jdField_a_of_type_JavaUtilQueue.poll();
        this.jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem = localFilterItem;
      }
      if (localFilterItem != null)
      {
        xvv.d("VideoFilterManager", "start to download filter resource : %s", new Object[] { localFilterItem });
        new vvw(this, this.jdField_a_of_type_Vmd).executeOnExecutor(Bosses.get().getExecutor(16), new vwz[] { new vwz(localFilterItem.filterConfigUrl, b(localFilterItem), localFilterItem.filterConfigMd5) });
      }
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      xvv.a("VideoFilterManager", "trimMemory, download pending list %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilQueue.size()));
      this.jdField_a_of_type_JavaUtilQueue.clear();
      xvv.a("VideoFilterManager", "trimMemory, filter list %d", Integer.valueOf(this.jdField_b_of_type_JavaUtilList.size()));
      this.jdField_b_of_type_JavaUtilList.clear();
      xvv.a("VideoFilterManager", "trimMemory, picture config cache %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()));
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvv
 * JD-Core Version:    0.7.0.1
 */