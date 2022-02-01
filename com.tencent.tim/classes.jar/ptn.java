import android.annotation.TargetApi;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.filter.FilterItem;
import com.tencent.biz.qqstory.model.filter.FilterItem.FilterItemIllegalException;
import com.tencent.biz.qqstory.model.filter.FilterItem.a;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetFilterList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFilterList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FilterListPack;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(11)
public class ptn
  implements psj
{
  public static final String auY = plr.ate + "filter";
  public static final String auZ = auY + "list_cache";
  @GuardedBy("filterItemList")
  private long At;
  @GuardedBy("filterItemList")
  private FilterItem jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem;
  private final pmy jdField_a_of_type_Pmy = new pmz();
  private AtomicBoolean aL = new AtomicBoolean(false);
  @GuardedBy("get list process")
  protected String ava = "";
  @GuardedBy("filterItemList")
  private int bkk;
  protected Map<String, ptm> fM = new HashMap();
  @GuardedBy("get list process")
  protected final List<FilterItem> my = new ArrayList();
  @GuardedBy("filterItemList")
  protected final List<FilterItem> mz = new ArrayList();
  @GuardedBy("filterItemList")
  private Queue<FilterItem> p = new LinkedList();
  
  /* Error */
  @GuardedBy("filterItemList")
  private boolean IU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 47	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   13: getstatic 71	ptn:auZ	Ljava/lang/String;
    //   16: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 114
    //   21: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 116
    //   26: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 122	rox:fA	(Ljava/lang/String;)Z
    //   35: pop
    //   36: new 124	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: sipush 4096
    //   43: invokespecial 127	java/io/ByteArrayOutputStream:<init>	(I)V
    //   46: astore_2
    //   47: new 129	java/io/ObjectOutputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 132	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   55: astore_3
    //   56: aload_3
    //   57: aload_0
    //   58: getfield 134	ptn:At	J
    //   61: invokevirtual 138	java/io/ObjectOutputStream:writeLong	(J)V
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 140	ptn:bkk	I
    //   69: invokevirtual 143	java/io/ObjectOutputStream:writeInt	(I)V
    //   72: aload_3
    //   73: aload_0
    //   74: getfield 91	ptn:mz	Ljava/util/List;
    //   77: invokevirtual 147	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   80: aload_3
    //   81: invokevirtual 150	java/io/ObjectOutputStream:flush	()V
    //   84: aload_3
    //   85: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   88: new 155	java/io/FileOutputStream
    //   91: dup
    //   92: new 47	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   99: getstatic 71	ptn:auZ	Ljava/lang/String;
    //   102: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 114
    //   107: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 116
    //   112: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   121: astore_1
    //   122: aload_2
    //   123: aload_1
    //   124: invokevirtual 161	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   127: aload_2
    //   128: invokevirtual 162	java/io/ByteArrayOutputStream:flush	()V
    //   131: aload_2
    //   132: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   135: aload_1
    //   136: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   139: ldc 166
    //   141: ldc 168
    //   143: aload_0
    //   144: getfield 91	ptn:mz	Ljava/util/List;
    //   147: invokeinterface 174 1 0
    //   152: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: invokestatic 185	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   174: aload_1
    //   175: ifnull +7 -> 182
    //   178: aload_1
    //   179: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   182: iconst_1
    //   183: ireturn
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   189: goto -23 -> 166
    //   192: astore_2
    //   193: aload_2
    //   194: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   197: goto -23 -> 174
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_1
    //   210: aconst_null
    //   211: astore_2
    //   212: ldc 166
    //   214: ldc 190
    //   216: aload_3
    //   217: invokestatic 194	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   246: iconst_0
    //   247: ireturn
    //   248: astore_2
    //   249: aload_2
    //   250: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   253: goto -25 -> 228
    //   256: astore_1
    //   257: aload_1
    //   258: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   261: goto -25 -> 236
    //   264: astore_1
    //   265: aload_1
    //   266: invokevirtual 188	java/io/IOException:printStackTrace	()V
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
    //   286: invokevirtual 163	java/io/ByteArrayOutputStream:close	()V
    //   289: aload_3
    //   290: ifnull +7 -> 297
    //   293: aload_3
    //   294: invokevirtual 153	java/io/ObjectOutputStream:close	()V
    //   297: aload 4
    //   299: ifnull +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   307: aload_1
    //   308: athrow
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   314: goto -25 -> 289
    //   317: astore_2
    //   318: aload_2
    //   319: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   322: goto -25 -> 297
    //   325: astore_2
    //   326: aload_2
    //   327: invokevirtual 188	java/io/IOException:printStackTrace	()V
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
    //   0	409	0	this	ptn
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
  
  /* Error */
  @GuardedBy("filterItemList")
  private boolean IV()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 198	java/io/ByteArrayInputStream
    //   6: dup
    //   7: new 200	java/io/File
    //   10: dup
    //   11: new 47	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   18: getstatic 71	ptn:auZ	Ljava/lang/String;
    //   21: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 114
    //   26: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 116
    //   31: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokespecial 201	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: invokestatic 205	rox:d	(Ljava/io/File;)[B
    //   43: invokespecial 208	java/io/ByteArrayInputStream:<init>	([B)V
    //   46: astore_2
    //   47: new 210	java/io/ObjectInputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 213	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_3
    //   56: aload_3
    //   57: astore 4
    //   59: aload_2
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 91	ptn:mz	Ljava/util/List;
    //   66: invokeinterface 216 1 0
    //   71: aload_3
    //   72: astore 4
    //   74: aload_2
    //   75: astore 5
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 220	java/io/ObjectInputStream:readLong	()J
    //   82: putfield 134	ptn:At	J
    //   85: aload_3
    //   86: astore 4
    //   88: aload_2
    //   89: astore 5
    //   91: aload_0
    //   92: aload_3
    //   93: invokevirtual 223	java/io/ObjectInputStream:readInt	()I
    //   96: putfield 140	ptn:bkk	I
    //   99: aload_3
    //   100: astore 4
    //   102: aload_2
    //   103: astore 5
    //   105: aload_3
    //   106: invokevirtual 227	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   109: checkcast 170	java/util/List
    //   112: astore 6
    //   114: aload 6
    //   116: ifnull +21 -> 137
    //   119: aload_3
    //   120: astore 4
    //   122: aload_2
    //   123: astore 5
    //   125: aload_0
    //   126: getfield 91	ptn:mz	Ljava/util/List;
    //   129: aload 6
    //   131: invokeinterface 231 2 0
    //   136: pop
    //   137: aload 6
    //   139: ifnull +52 -> 191
    //   142: aload_3
    //   143: astore 4
    //   145: aload_2
    //   146: astore 5
    //   148: aload 6
    //   150: invokeinterface 174 1 0
    //   155: istore_1
    //   156: aload_3
    //   157: astore 4
    //   159: aload_2
    //   160: astore 5
    //   162: ldc 166
    //   164: ldc 233
    //   166: iload_1
    //   167: invokestatic 180	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokestatic 185	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 234	java/io/ByteArrayInputStream:close	()V
    //   181: aload_3
    //   182: ifnull +7 -> 189
    //   185: aload_3
    //   186: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   189: iconst_1
    //   190: ireturn
    //   191: iconst_0
    //   192: istore_1
    //   193: goto -37 -> 156
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_2
    //   199: aload 4
    //   201: astore_3
    //   202: ldc 166
    //   204: ldc 237
    //   206: invokestatic 241	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_2
    //   210: ifnull +7 -> 217
    //   213: aload_2
    //   214: invokevirtual 234	java/io/ByteArrayInputStream:close	()V
    //   217: aload_3
    //   218: ifnull +7 -> 225
    //   221: aload_3
    //   222: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   225: iconst_0
    //   226: ireturn
    //   227: astore 6
    //   229: aconst_null
    //   230: astore_2
    //   231: aconst_null
    //   232: astore_3
    //   233: aload_3
    //   234: astore 4
    //   236: aload_2
    //   237: astore 5
    //   239: ldc 166
    //   241: ldc 243
    //   243: aload 6
    //   245: invokestatic 194	ram:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload_2
    //   249: ifnull +7 -> 256
    //   252: aload_2
    //   253: invokevirtual 234	java/io/ByteArrayInputStream:close	()V
    //   256: aload_3
    //   257: ifnull -32 -> 225
    //   260: aload_3
    //   261: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   264: goto -39 -> 225
    //   267: astore_2
    //   268: goto -43 -> 225
    //   271: astore_3
    //   272: aconst_null
    //   273: astore 4
    //   275: aconst_null
    //   276: astore_2
    //   277: aload_2
    //   278: ifnull +7 -> 285
    //   281: aload_2
    //   282: invokevirtual 234	java/io/ByteArrayInputStream:close	()V
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 235	java/io/ObjectInputStream:close	()V
    //   295: aload_3
    //   296: athrow
    //   297: astore_2
    //   298: goto -117 -> 181
    //   301: astore_2
    //   302: iconst_1
    //   303: ireturn
    //   304: astore_2
    //   305: goto -88 -> 217
    //   308: astore_2
    //   309: goto -84 -> 225
    //   312: astore_2
    //   313: goto -57 -> 256
    //   316: astore_2
    //   317: goto -32 -> 285
    //   320: astore_2
    //   321: goto -26 -> 295
    //   324: astore_3
    //   325: aconst_null
    //   326: astore 4
    //   328: goto -51 -> 277
    //   331: astore_3
    //   332: aload 5
    //   334: astore_2
    //   335: goto -58 -> 277
    //   338: astore 5
    //   340: aload_3
    //   341: astore 4
    //   343: aload 5
    //   345: astore_3
    //   346: goto -69 -> 277
    //   349: astore 6
    //   351: aconst_null
    //   352: astore_3
    //   353: goto -120 -> 233
    //   356: astore 6
    //   358: goto -125 -> 233
    //   361: astore_3
    //   362: aload 4
    //   364: astore_3
    //   365: goto -163 -> 202
    //   368: astore 4
    //   370: goto -168 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	ptn
    //   155	38	1	i	int
    //   46	132	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   196	1	2	localIOException1	java.io.IOException
    //   198	55	2	localObject1	Object
    //   267	1	2	localIOException2	java.io.IOException
    //   276	6	2	localObject2	Object
    //   297	1	2	localIOException3	java.io.IOException
    //   301	1	2	localIOException4	java.io.IOException
    //   304	1	2	localIOException5	java.io.IOException
    //   308	1	2	localIOException6	java.io.IOException
    //   312	1	2	localIOException7	java.io.IOException
    //   316	1	2	localIOException8	java.io.IOException
    //   320	1	2	localIOException9	java.io.IOException
    //   334	1	2	localObject3	Object
    //   55	206	3	localObject4	Object
    //   271	25	3	localObject5	Object
    //   324	1	3	localObject6	Object
    //   331	10	3	localObject7	Object
    //   345	8	3	localObject8	Object
    //   361	1	3	localIOException10	java.io.IOException
    //   364	1	3	localObject9	Object
    //   1	362	4	localObject10	Object
    //   368	1	4	localIOException11	java.io.IOException
    //   60	273	5	localObject11	Object
    //   338	6	5	localObject12	Object
    //   112	37	6	localList	List
    //   227	17	6	localException1	Exception
    //   349	1	6	localException2	Exception
    //   356	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   3	47	196	java/io/IOException
    //   3	47	227	java/lang/Exception
    //   260	264	267	java/io/IOException
    //   3	47	271	finally
    //   177	181	297	java/io/IOException
    //   185	189	301	java/io/IOException
    //   213	217	304	java/io/IOException
    //   221	225	308	java/io/IOException
    //   252	256	312	java/io/IOException
    //   281	285	316	java/io/IOException
    //   290	295	320	java/io/IOException
    //   47	56	324	finally
    //   62	71	331	finally
    //   77	85	331	finally
    //   91	99	331	finally
    //   105	114	331	finally
    //   125	137	331	finally
    //   148	156	331	finally
    //   162	173	331	finally
    //   239	248	331	finally
    //   202	209	338	finally
    //   47	56	349	java/lang/Exception
    //   62	71	356	java/lang/Exception
    //   77	85	356	java/lang/Exception
    //   91	99	356	java/lang/Exception
    //   105	114	356	java/lang/Exception
    //   125	137	356	java/lang/Exception
    //   148	156	356	java/lang/Exception
    //   162	173	356	java/lang/Exception
    //   47	56	361	java/io/IOException
    //   62	71	368	java/io/IOException
    //   77	85	368	java/io/IOException
    //   91	99	368	java/io/IOException
    //   105	114	368	java/io/IOException
    //   125	137	368	java/io/IOException
    //   148	156	368	java/io/IOException
    //   162	173	368	java/io/IOException
  }
  
  public static String a(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.filterConfigMd5))) {
      return auY + "/" + paramFilterItem.filterConfigMd5;
    }
    return null;
  }
  
  public static boolean a(FilterItem paramFilterItem)
  {
    return r(a(paramFilterItem), false);
  }
  
  private static String b(FilterItem paramFilterItem)
  {
    if ((paramFilterItem != null) && (!TextUtils.isEmpty(paramFilterItem.filterConfigMd5))) {
      return auY + "/" + paramFilterItem.filterConfigMd5 + ".zip";
    }
    return null;
  }
  
  public static boolean r(String paramString, boolean paramBoolean)
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
          ram.w("VideoFilterManager", "remove illegal filter folder : %s", new Object[] { paramString });
        }
      }
    }
    try
    {
      rox.fA(paramString);
      label83:
      return false;
    }
    catch (Exception paramString)
    {
      break label83;
    }
  }
  
  private static void rp(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.isFile()) {
      ram.w("VideoFilterManager", "delete file : %s", new Object[] { Boolean.valueOf(paramString.delete()) });
    }
    if (!paramString.exists()) {
      ram.w("VideoFilterManager", "create folder : %s", new Object[] { Boolean.valueOf(paramString.mkdirs()) });
    }
  }
  
  public boolean V(boolean paramBoolean)
  {
    if ((Math.abs(System.currentTimeMillis() - this.At) > this.bkk * 1000) || (paramBoolean))
    {
      if (!this.aL.getAndSet(true))
      {
        ram.w("VideoFilterManager", "fireGetFilterList full list");
        this.ava = "";
        this.my.clear();
        bmL();
        return true;
      }
      ram.w("VideoFilterManager", "fireGetFilterList ignore because we are requesting ..");
    }
    for (;;)
    {
      return false;
      ram.w("VideoFilterManager", "fireGetFilterList ignore because you request too frequently, frequency = %d s", new Object[] { Integer.valueOf(this.bkk) });
    }
  }
  
  @Nullable
  public ptm a(FilterItem paramFilterItem)
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
        localObject = (ptm)this.fM.get(str);
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
          ram.w("VideoFilterManager", "getFilterItemConfig, parse config file failed", paramFilterItem);
        }
      }
      paramFilterItem = (FilterItem)localObject;
    } while (localObject == null);
    this.fM.put(str, localObject);
    return localObject;
  }
  
  protected ptm a(File paramFile)
    throws UnsupportedEncodingException, JSONException, JsonORM.JsonParseException
  {
    if ((!paramFile.exists()) || (!paramFile.isFile()) || (!paramFile.canRead()))
    {
      ram.w("VideoFilterManager", "parseFilterConfigFile failed, file is illegal %s", new Object[] { paramFile });
      return null;
    }
    long l = SystemClock.uptimeMillis();
    paramFile = (ptm)JsonORM.parseFrom(new JSONObject(new String(rox.b(paramFile), "UTF-8")), ptm.class);
    ram.b("VideoFilterManager", "parseFilterConfigFile success, cost = %d ms", Long.valueOf(SystemClock.uptimeMillis() - l));
    return paramFile;
  }
  
  @GuardedBy("get list process")
  protected void ab(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      synchronized (this.mz)
      {
        ram.b("VideoFilterManager", "fireGetFilterListFinish, filter count %d -> %d", Integer.valueOf(this.mz.size()), Integer.valueOf(this.my.size()));
        this.mz.clear();
        this.mz.addAll(this.my);
        this.At = System.currentTimeMillis();
        this.bkk = paramInt;
        IU();
        this.p.clear();
        Iterator localIterator = this.mz.iterator();
        while (localIterator.hasNext())
        {
          FilterItem localFilterItem = (FilterItem)localIterator.next();
          if ((!localFilterItem.isLocalType()) && (!a(localFilterItem))) {
            this.p.offer(localFilterItem);
          }
        }
      }
      ram.b("VideoFilterManager", "fireGetFilterListFinish, download pending list size = %d", Integer.valueOf(this.p.size()));
      bmM();
    }
    this.my.clear();
    this.aL.set(false);
  }
  
  @NonNull
  public List<FilterItem> bM()
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      FilterItem localFilterItem;
      synchronized (this.mz)
      {
        Iterator localIterator = this.mz.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localFilterItem = (FilterItem)localIterator.next();
        if ((localFilterItem.isLocalType()) || (a(localFilterItem)))
        {
          localArrayList.add(localFilterItem);
          ram.b("VideoFilterManager", "add to display : %s", localFilterItem);
        }
      }
      ram.b("VideoFilterManager", "ignore display : %s", localFilterItem);
    }
    V(this.mz.isEmpty());
    return localList1;
  }
  
  public void bmH()
  {
    synchronized (this.mz)
    {
      ram.b("VideoFilterManager", "trimMemory, download pending list %d", Integer.valueOf(this.p.size()));
      this.p.clear();
      ram.b("VideoFilterManager", "trimMemory, filter list %d", Integer.valueOf(this.mz.size()));
      this.mz.clear();
      ram.b("VideoFilterManager", "trimMemory, picture config cache %d", Integer.valueOf(this.fM.size()));
      this.fM.clear();
      return;
    }
  }
  
  @GuardedBy("get list process")
  protected void bmL()
  {
    ram.b("VideoFilterManager", "fireGetFilterListInner %s", this.ava);
    ppv.a().a(new ptn.b(this.ava), new ptn.a(null));
  }
  
  protected void bmM()
  {
    FilterItem localFilterItem = null;
    synchronized (this.mz)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem == null)
      {
        localFilterItem = (FilterItem)this.p.poll();
        this.jdField_a_of_type_ComTencentBizQqstoryModelFilterFilterItem = localFilterItem;
      }
      if (localFilterItem != null)
      {
        ram.w("VideoFilterManager", "start to download filter resource : %s", new Object[] { localFilterItem });
        new pto(this, this.jdField_a_of_type_Pmy).executeOnExecutor(Bosses.get().getExecutor(16), new pue.a[] { new pue.a(localFilterItem.filterConfigUrl, b(localFilterItem), localFilterItem.filterConfigMd5) });
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    ram.w("VideoFilterManager", "onDestroy");
    bmH();
  }
  
  public void onInit()
  {
    ram.w("VideoFilterManager", "onInit");
    rp(auY);
    rp(auZ);
    synchronized (this.mz)
    {
      IV();
      return;
    }
  }
  
  class a
    implements ppv.b<ptn.b, ptn.c>
  {
    private a() {}
    
    public void a(@NonNull ptn.b paramb, @Nullable ptn.c paramc, @NonNull ErrorMessage paramErrorMessage)
    {
      if ((paramc != null) && (paramc.errorCode == 0) && (paramErrorMessage.isSuccess()))
      {
        ptn.this.my.addAll(paramc.mz);
        ram.w("VideoFilterManager", "new filter count %d, current total count %d, isEnd=%s, cookie=%s", new Object[] { Integer.valueOf(paramc.mz.size()), Integer.valueOf(ptn.this.my.size()), Boolean.valueOf(paramc.isEnd), paramc.nextCookie });
        if ((paramc.isEnd) || (paramc.mz.isEmpty()))
        {
          ram.w("VideoFilterManager", "get filter full list finish, frequency = %d s", new Object[] { Integer.valueOf(paramc.frequency) });
          ptn.this.ab(true, paramc.frequency);
          return;
        }
        ptn.this.ava = paramc.nextCookie;
        ptn.this.bmL();
        return;
      }
      ram.e("VideoFilterManager", "get filter failed %s", paramErrorMessage);
      ptn.this.ab(false, 0);
    }
  }
  
  public static class b
    extends ppw<ptn.c>
  {
    @NonNull
    public final String cookie;
    public final int count;
    
    public b(@NonNull String paramString)
    {
      this(paramString, 20);
    }
    
    public b(@NonNull String paramString, int paramInt)
    {
      this.cookie = paramString;
      this.count = paramInt;
    }
    
    public ppu a(byte[] paramArrayOfByte)
    {
      return new ptn.c(paramArrayOfByte);
    }
    
    protected byte[] encode()
    {
      qqstory_service.ReqGetFilterList localReqGetFilterList = new qqstory_service.ReqGetFilterList();
      localReqGetFilterList.count.set(this.count);
      localReqGetFilterList.start_cookie.set(ByteStringMicro.copyFromUtf8(this.cookie));
      return localReqGetFilterList.toByteArray();
    }
    
    public String mg()
    {
      return ppf.fQ("StorySvc.video_filter_list");
    }
  }
  
  public static class c
    extends ppu
  {
    public final int frequency;
    public final boolean isEnd;
    @NonNull
    public final List<FilterItem> mz;
    @NonNull
    public final String nextCookie;
    
    public c(byte[] paramArrayOfByte)
    {
      Object localObject1 = new qqstory_service.RspGetFilterList();
      for (;;)
      {
        try
        {
          ((qqstory_service.RspGetFilterList)localObject1).mergeFrom(paramArrayOfByte);
          this.errorCode = ((qqstory_service.RspGetFilterList)localObject1).result.error_code.get();
          this.errorMsg = ((qqstory_service.RspGetFilterList)localObject1).result.error_desc.get().toStringUtf8();
          if (((qqstory_service.RspGetFilterList)localObject1).is_end.get() != 0)
          {
            this.isEnd = bool;
            this.nextCookie = ((qqstory_service.RspGetFilterList)localObject1).next_cookie.get().toStringUtf8();
            this.frequency = ((qqstory_service.RspGetFilterList)localObject1).frequency.get();
            paramArrayOfByte = new ArrayList();
            localObject1 = ((qqstory_service.RspGetFilterList)localObject1).filter_list.get().iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            Object localObject2 = (qqstory_struct.FilterListPack)((Iterator)localObject1).next();
            FilterItem.a locala = new FilterItem.a();
            locala.filterId = ((qqstory_struct.FilterListPack)localObject2).filter_id.get();
            locala.filterName = ((qqstory_struct.FilterListPack)localObject2).filter_name.get().toStringUtf8();
            locala.filterType = ((qqstory_struct.FilterListPack)localObject2).filter_type.get();
            locala.filterConfigUrl = ((qqstory_struct.FilterListPack)localObject2).filter_config_file.get().toStringUtf8();
            locala.filterConfigMd5 = ((qqstory_struct.FilterListPack)localObject2).filter_config_md5.get().toStringUtf8();
            try
            {
              localObject2 = locala.a();
              paramArrayOfByte.add(localObject2);
              ram.w("VideoFilterManager", "GET Filter : id=%d, name=%s, type=%d, url=%s, md5=%s", new Object[] { Long.valueOf(((FilterItem)localObject2).filterId), ((FilterItem)localObject2).filterName, Integer.valueOf(((FilterItem)localObject2).filterType), ((FilterItem)localObject2).filterConfigUrl, ((FilterItem)localObject2).filterConfigMd5 });
            }
            catch (FilterItem.FilterItemIllegalException localFilterItemIllegalException)
            {
              ram.e("VideoFilterManager", "GET Filter error : ", localFilterItemIllegalException);
            }
            continue;
          }
          bool = false;
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          ram.e("VideoFilterManager", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
          this.errorCode = -1;
          this.errorMsg = acfp.m(2131716388);
          this.isEnd = false;
          this.mz = Collections.EMPTY_LIST;
          this.nextCookie = "";
          this.frequency = 0;
          return;
        }
      }
      this.mz = Collections.unmodifiableList(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ptn
 * JD-Core Version:    0.7.0.1
 */