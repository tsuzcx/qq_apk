import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqtw
{
  public static float AL;
  static String Model;
  static final Uri O = Uri.parse("content://com.miui.providers.steps/item");
  public static volatile long atM;
  static boolean cWd;
  public static boolean cWe;
  static String cwU;
  static String cwV;
  public static String cxf = "";
  public static final String cxg = BaseApplicationImpl.getApplication().getFilesDir() + File.separator + "step.info";
  static final String cxh = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "stepSign.info";
  public static volatile int ecO;
  public static volatile int ecP;
  public static volatile int ecQ;
  private static String[] hZ;
  private static String[] ia;
  static final String[] ib = { "_id", "_begin_time", "_end_time", "_mode", "_steps" };
  static long lastCallTime;
  
  /* Error */
  public static String Cy()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: getstatic 113	aqtw:cWe	Z
    //   5: ifeq +79 -> 84
    //   8: new 115	com/tencent/qphone/base/util/Cryptor
    //   11: dup
    //   12: invokespecial 116	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   15: astore_3
    //   16: new 118	java/io/RandomAccessFile
    //   19: dup
    //   20: getstatic 70	aqtw:cxg	Ljava/lang/String;
    //   23: ldc 120
    //   25: invokespecial 123	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokevirtual 127	java/io/RandomAccessFile:length	()J
    //   35: l2i
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: aload 4
    //   45: invokevirtual 131	java/io/RandomAccessFile:read	([B)I
    //   48: pop
    //   49: aload_2
    //   50: astore_1
    //   51: new 83	java/lang/String
    //   54: dup
    //   55: aload_3
    //   56: aload 4
    //   58: ldc 133
    //   60: invokevirtual 137	java/lang/String:getBytes	()[B
    //   63: invokevirtual 141	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   66: invokespecial 144	java/lang/String:<init>	([B)V
    //   69: astore_3
    //   70: aload_3
    //   71: astore_1
    //   72: aload_2
    //   73: ifnull +9 -> 82
    //   76: aload_2
    //   77: invokevirtual 147	java/io/RandomAccessFile:close	()V
    //   80: aload_3
    //   81: astore_1
    //   82: aload_1
    //   83: areturn
    //   84: new 56	java/io/File
    //   87: dup
    //   88: getstatic 81	aqtw:cxh	Ljava/lang/String;
    //   91: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   94: astore_3
    //   95: new 56	java/io/File
    //   98: dup
    //   99: getstatic 70	aqtw:cxg	Ljava/lang/String;
    //   102: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_2
    //   106: aload_3
    //   107: invokevirtual 154	java/io/File:exists	()Z
    //   110: ifeq +12 -> 122
    //   113: aload_2
    //   114: invokevirtual 154	java/io/File:exists	()Z
    //   117: istore_0
    //   118: iload_0
    //   119: ifne +17 -> 136
    //   122: iconst_0
    //   123: ifeq +11 -> 134
    //   126: new 156	java/lang/NullPointerException
    //   129: dup
    //   130: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   133: athrow
    //   134: aconst_null
    //   135: areturn
    //   136: aload_3
    //   137: invokestatic 163	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   140: astore_3
    //   141: aload_2
    //   142: invokestatic 163	com/tencent/mobileqq/msf/sdk/utils/SignUtils:readFile	(Ljava/io/File;)Ljava/lang/String;
    //   145: astore_2
    //   146: aload_2
    //   147: ifnull +32 -> 179
    //   150: aload_2
    //   151: aload_3
    //   152: ldc 165
    //   154: invokestatic 169	com/tencent/mobileqq/msf/sdk/utils/SignUtils:verifyData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   157: istore_0
    //   158: iload_0
    //   159: ifeq +20 -> 179
    //   162: aload_2
    //   163: astore_1
    //   164: iconst_0
    //   165: ifeq -83 -> 82
    //   168: new 156	java/lang/NullPointerException
    //   171: dup
    //   172: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   175: athrow
    //   176: astore_1
    //   177: aload_2
    //   178: areturn
    //   179: iconst_0
    //   180: ifeq +11 -> 191
    //   183: new 156	java/lang/NullPointerException
    //   186: dup
    //   187: invokespecial 157	java/lang/NullPointerException:<init>	()V
    //   190: athrow
    //   191: aconst_null
    //   192: areturn
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: ldc 171
    //   200: iconst_1
    //   201: new 37	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   208: ldc 173
    //   210: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: getstatic 113	aqtw:cWe	Z
    //   216: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   219: ldc 178
    //   221: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: aload_3
    //   228: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_2
    //   232: ifnull -41 -> 191
    //   235: aload_2
    //   236: invokevirtual 147	java/io/RandomAccessFile:close	()V
    //   239: goto -48 -> 191
    //   242: astore_1
    //   243: goto -52 -> 191
    //   246: astore_3
    //   247: aload_1
    //   248: astore_2
    //   249: aload_3
    //   250: astore_1
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 147	java/io/RandomAccessFile:close	()V
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_3
    //   263: areturn
    //   264: astore_1
    //   265: goto -131 -> 134
    //   268: astore_1
    //   269: goto -78 -> 191
    //   272: astore_2
    //   273: goto -14 -> 259
    //   276: astore_3
    //   277: aload_1
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: goto -30 -> 251
    //   284: astore_3
    //   285: goto -89 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   117	42	0	bool	boolean
    //   1	163	1	localObject1	Object
    //   176	1	1	localIOException1	java.io.IOException
    //   197	1	1	localObject2	Object
    //   242	6	1	localIOException2	java.io.IOException
    //   250	10	1	localObject3	Object
    //   261	1	1	localIOException3	java.io.IOException
    //   264	1	1	localIOException4	java.io.IOException
    //   268	10	1	localIOException5	java.io.IOException
    //   280	1	1	localObject4	Object
    //   28	228	2	localObject5	Object
    //   272	1	2	localIOException6	java.io.IOException
    //   278	1	2	localIOException7	java.io.IOException
    //   15	137	3	localObject6	Object
    //   193	35	3	localException1	Exception
    //   246	17	3	str	String
    //   276	4	3	localObject7	Object
    //   284	1	3	localException2	Exception
    //   38	19	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   168	176	176	java/io/IOException
    //   2	29	193	java/lang/Exception
    //   84	118	193	java/lang/Exception
    //   136	146	193	java/lang/Exception
    //   150	158	193	java/lang/Exception
    //   235	239	242	java/io/IOException
    //   2	29	246	finally
    //   84	118	246	finally
    //   136	146	246	finally
    //   150	158	246	finally
    //   76	80	261	java/io/IOException
    //   126	134	264	java/io/IOException
    //   183	191	268	java/io/IOException
    //   255	259	272	java/io/IOException
    //   31	40	276	finally
    //   42	49	276	finally
    //   51	70	276	finally
    //   198	231	276	finally
    //   31	40	284	java/lang/Exception
    //   42	49	284	java/lang/Exception
    //   51	70	284	java/lang/Exception
  }
  
  public static void VH(String paramString)
  {
    if (System.currentTimeMillis() - lastCallTime < 1000L) {}
    Object localObject1;
    long l2;
    do
    {
      do
      {
        return;
        lastCallTime = System.currentTimeMillis();
      } while ((NetConnInfoCenter.getServerTimeMillis() - atM < 60000L) || (TextUtils.isEmpty(paramString)));
      cWd = false;
      try
      {
        paramString = new JSONObject(paramString);
        if (!paramString.getBoolean("isStepCounterEnable"))
        {
          aqtz.cWf = false;
          QLog.i("SSOHttpUtils", 1, "step counter off.");
          dZ(-2, "step counter off");
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("SSOHttpUtils", 1, "report step count Exception:" + paramString);
        return;
      }
      aqtz.cWf = true;
      localObject1 = new HashMap();
      l2 = hU();
      localObject2 = String.valueOf(l2);
    } while ((!paramString.has((String)localObject2 + "_total")) || (!paramString.has((String)localObject2 + "_init")));
    ecO = paramString.getInt((String)localObject2 + "_total");
    ecP = paramString.getInt((String)localObject2 + "_init");
    ecQ = paramString.getInt((String)localObject2 + "_offset");
    int i = ecO;
    int j = ecP;
    int k = ecQ + (i - j);
    Object localObject2 = ah();
    int m = 0;
    i = m;
    j = k;
    if (localObject2[1] != -1)
    {
      i = m;
      j = k;
      if (localObject2[1] > k)
      {
        QLog.e("SSOHttpUtils", 1, "use device step :" + localObject2[1] + " instead of sensor:" + k + ", yesterday: " + localObject2[0]);
        k = localObject2[1];
        m = 1;
        i = m;
        j = k;
        if (!cWd)
        {
          i = m;
          j = k;
          if (localObject2[0] > 0)
          {
            ((Map)localObject1).put(Long.valueOf(hW() + 86399000L), Integer.valueOf(localObject2[0]));
            cWd = true;
            j = k;
            i = m;
          }
        }
      }
    }
    QLog.i("SSOHttpUtils", 1, "file contains cur_init:" + ecP + ",cur_total:" + ecO + ",cur_offset:" + ecQ);
    if (j > 0) {
      ((Map)localObject1).put(Long.valueOf(NetConnInfoCenter.getServerTime() * 1000L), Integer.valueOf(j));
    }
    long l1;
    if (paramString.has("last_report_time"))
    {
      l1 = paramString.getLong("last_report_time");
      localObject2 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
      ((Calendar)localObject2).setTimeInMillis(l1);
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      l1 = ((Calendar)localObject2).getTimeInMillis();
      if (l2 - l1 <= 604800000L) {
        break label1195;
      }
      ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
      ((Calendar)localObject2).set(11, 0);
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      ((Calendar)localObject2).set(14, 0);
      ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) - 6);
      l1 = ((Calendar)localObject2).getTimeInMillis();
    }
    label1195:
    for (;;)
    {
      Object localObject3;
      if (l1 < l2)
      {
        localObject3 = String.valueOf(l1);
        if ((!paramString.has((String)localObject3 + "_init")) || (!paramString.has((String)localObject3 + "_total")))
        {
          ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) + 1);
          l1 = ((Calendar)localObject2).getTimeInMillis();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("SSOHttpUtils", 2, "report yesterday~");
          }
          m = paramString.getInt((String)localObject3 + "_total") - paramString.getInt((String)localObject3 + "_init");
          localObject3 = (String)localObject3 + "_offset";
          k = m;
          if (paramString.has((String)localObject3))
          {
            cWd = true;
            k = m + paramString.getInt((String)localObject3);
          }
          if ((k > 0) && (!((Map)localObject1).containsKey(Long.valueOf(86399000L + l1)))) {
            ((Map)localObject1).put(Long.valueOf(l1 + 86399000L), Integer.valueOf(k));
          }
          ((Calendar)localObject2).set(5, ((Calendar)localObject2).get(5) + 1);
          l1 = ((Calendar)localObject2).getTimeInMillis();
        }
      }
      else
      {
        if (paramString.has("last_record_time")) {}
        for (l1 = paramString.getLong("last_record_time");; l1 = 0L)
        {
          if (((Map)localObject1).isEmpty())
          {
            dZ(-3, "parameter is Empty.");
            return;
          }
          if ((j == AL) && (j > 0) && (((Map)localObject1).size() == 1))
          {
            localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(cxf)))
            {
              QLog.i("SSOHttpUtils", 1, "steps duplicate , return.");
              return;
            }
          }
          localObject2 = new JSONArray();
          localObject1 = ((Map)localObject1).entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject1).next();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("type", 1);
            localJSONObject.put("time", ((Long)((Map.Entry)localObject3).getKey()).longValue() / 1000L);
            localJSONObject.put("steps", ((Integer)((Map.Entry)localObject3).getValue()).longValue());
            ((JSONArray)localObject2).put(localJSONObject);
          }
          a((JSONArray)localObject2, paramString.optBoolean("isRestart", false), i, l1);
          return;
        }
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, boolean paramBoolean, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(BaseApplicationImpl.getApplication().getRuntime().getAccount())) || (paramJSONArray == null)) {
      return;
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("oauth_consumer_key", 1002);
        ((JSONObject)localObject).put("data", paramJSONArray);
        ((JSONObject)localObject).put("version", "3.4.4");
        ((JSONObject)localObject).put("lastRecordTime", paramLong / 1000L);
        if (TextUtils.isEmpty(Model)) {
          Model = URLEncoder.encode(Build.MODEL, "utf-8");
        }
        ((JSONObject)localObject).put("model", Model);
        if (TextUtils.isEmpty(cwV))
        {
          paramJSONArray = TimeZone.getDefault();
          cwV = paramJSONArray.getDisplayName(false, 0) + " " + paramJSONArray.getID();
        }
        ((JSONObject)localObject).put("zone", String.valueOf(cwV));
        if (TextUtils.isEmpty(cwU)) {
          cwU = alla.a((TelephonyManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("phone"));
        }
        ((JSONObject)localObject).put("imei", String.valueOf(cwU));
        ((JSONObject)localObject).put("adcode", aczc.getCityCode());
        if ((paramInt == 0) && (paramBoolean))
        {
          QLog.i("SSOHttpUtils", 1, "report with exception_0");
          ((JSONObject)localObject).put("exception_0", 1);
        }
        if (!cWe) {
          continue;
        }
        i = 0;
        ((JSONObject)localObject).put("mode", i);
        ((JSONObject)localObject).put("stepSource", paramInt);
      }
      catch (Exception paramJSONArray)
      {
        int i;
        WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("SSOHttpUtils", 2, "Exception:" + paramJSONArray.toString());
        continue;
      }
      localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("3.4.4");
      paramJSONArray = new WebSSOAgent.UniSsoServerReq();
      paramJSONArray.comm.set(localUniSsoServerReqComm);
      paramJSONArray.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "parameter:" + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), ailu.class);
      ((NewIntent)localObject).putExtra("extra_cmd", "yundong_report.steps");
      ((NewIntent)localObject).putExtra("extra_data", paramJSONArray.toByteArray());
      ((NewIntent)localObject).setObserver(new aqtx());
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject);
      return;
      i = 1;
    }
  }
  
  /* Error */
  public static int[] ah()
  {
    // Byte code:
    //   0: iconst_2
    //   1: newarray int
    //   3: astore 10
    //   5: aload 10
    //   7: dup
    //   8: iconst_0
    //   9: iconst_0
    //   10: iastore
    //   11: dup
    //   12: iconst_1
    //   13: iconst_0
    //   14: iastore
    //   15: pop
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 9
    //   22: aload 9
    //   24: astore 7
    //   26: invokestatic 620	aqfo:isMIUI	()Z
    //   29: ifeq +335 -> 364
    //   32: ldc_w 622
    //   35: invokestatic 628	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   38: astore 11
    //   40: aload 11
    //   42: invokevirtual 631	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   45: astore 7
    //   47: aload 11
    //   49: ldc_w 632
    //   52: iconst_2
    //   53: anewarray 624	java/lang/Class
    //   56: dup
    //   57: iconst_0
    //   58: ldc 83
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: getstatic 638	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   66: aastore
    //   67: invokevirtual 642	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore 11
    //   72: aload 11
    //   74: iconst_1
    //   75: invokevirtual 648	java/lang/reflect/Method:setAccessible	(Z)V
    //   78: aload 11
    //   80: aload 7
    //   82: iconst_2
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: ldc_w 650
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokestatic 653	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: invokevirtual 657	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   102: astore 11
    //   104: aload 9
    //   106: astore 7
    //   108: aload 11
    //   110: instanceof 634
    //   113: ifeq +251 -> 364
    //   116: aload 9
    //   118: astore 7
    //   120: aload 11
    //   122: checkcast 634	java/lang/Boolean
    //   125: invokevirtual 660	java/lang/Boolean:booleanValue	()Z
    //   128: ifeq +236 -> 364
    //   131: invokestatic 46	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   134: invokevirtual 664	com/tencent/common/app/BaseApplicationImpl:getContentResolver	()Landroid/content/ContentResolver;
    //   137: astore 11
    //   139: aload 9
    //   141: astore 7
    //   143: aload 11
    //   145: ifnull +219 -> 364
    //   148: invokestatic 286	aqtw:hW	()J
    //   151: lstore_0
    //   152: invokestatic 667	aqtw:hV	()J
    //   155: lstore_2
    //   156: invokestatic 247	aqtw:hU	()J
    //   159: lstore 4
    //   161: aload 11
    //   163: getstatic 105	aqtw:O	Landroid/net/Uri;
    //   166: getstatic 95	aqtw:ib	[Ljava/lang/String;
    //   169: ldc_w 669
    //   172: iconst_2
    //   173: anewarray 83	java/lang/String
    //   176: dup
    //   177: iconst_0
    //   178: lload_0
    //   179: invokestatic 251	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: lload_2
    //   186: invokestatic 251	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   189: aastore
    //   190: ldc_w 671
    //   193: invokestatic 677	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   196: astore 7
    //   198: aload 7
    //   200: ifnull +164 -> 364
    //   203: aload 7
    //   205: astore 8
    //   207: aload 7
    //   209: invokeinterface 682 1 0
    //   214: ifeq +150 -> 364
    //   217: aload 7
    //   219: astore 8
    //   221: aload 7
    //   223: iconst_2
    //   224: invokeinterface 685 2 0
    //   229: lload 4
    //   231: lcmp
    //   232: ifge +57 -> 289
    //   235: aload 7
    //   237: astore 8
    //   239: aload 10
    //   241: iconst_0
    //   242: aload 10
    //   244: iconst_0
    //   245: iaload
    //   246: aload 7
    //   248: iconst_4
    //   249: invokeinterface 687 2 0
    //   254: iadd
    //   255: iastore
    //   256: aload 7
    //   258: astore 8
    //   260: aload 7
    //   262: invokeinterface 690 1 0
    //   267: istore 6
    //   269: iload 6
    //   271: ifne -54 -> 217
    //   274: aload 7
    //   276: ifnull +10 -> 286
    //   279: aload 7
    //   281: invokeinterface 691 1 0
    //   286: aload 10
    //   288: areturn
    //   289: aload 7
    //   291: astore 8
    //   293: aload 10
    //   295: iconst_1
    //   296: aload 10
    //   298: iconst_1
    //   299: iaload
    //   300: aload 7
    //   302: iconst_4
    //   303: invokeinterface 687 2 0
    //   308: iadd
    //   309: iastore
    //   310: goto -54 -> 256
    //   313: astore 9
    //   315: aload 7
    //   317: astore 8
    //   319: invokestatic 353	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +18 -> 340
    //   325: aload 7
    //   327: astore 8
    //   329: ldc 171
    //   331: iconst_2
    //   332: ldc_w 693
    //   335: aload 9
    //   337: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   340: aload 7
    //   342: ifnull +10 -> 352
    //   345: aload 7
    //   347: invokeinterface 691 1 0
    //   352: iconst_2
    //   353: newarray int
    //   355: dup
    //   356: iconst_0
    //   357: iconst_m1
    //   358: iastore
    //   359: dup
    //   360: iconst_1
    //   361: iconst_m1
    //   362: iastore
    //   363: areturn
    //   364: aload 7
    //   366: ifnull -14 -> 352
    //   369: aload 7
    //   371: invokeinterface 691 1 0
    //   376: goto -24 -> 352
    //   379: astore 7
    //   381: aload 8
    //   383: ifnull +10 -> 393
    //   386: aload 8
    //   388: invokeinterface 691 1 0
    //   393: aload 7
    //   395: athrow
    //   396: astore 7
    //   398: goto -17 -> 381
    //   401: astore 9
    //   403: aconst_null
    //   404: astore 7
    //   406: goto -91 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   151	28	0	l1	long
    //   155	31	2	l2	long
    //   159	71	4	l3	long
    //   267	3	6	bool	boolean
    //   24	346	7	localObject1	Object
    //   379	15	7	localObject2	Object
    //   396	1	7	localObject3	Object
    //   404	1	7	localObject4	Object
    //   17	370	8	localObject5	Object
    //   20	120	9	localObject6	Object
    //   313	23	9	localException1	Exception
    //   401	1	9	localException2	Exception
    //   3	294	10	arrayOfInt	int[]
    //   38	124	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   207	217	313	java/lang/Exception
    //   221	235	313	java/lang/Exception
    //   239	256	313	java/lang/Exception
    //   260	269	313	java/lang/Exception
    //   293	310	313	java/lang/Exception
    //   26	104	379	finally
    //   108	116	379	finally
    //   120	139	379	finally
    //   148	198	379	finally
    //   207	217	396	finally
    //   221	235	396	finally
    //   239	256	396	finally
    //   260	269	396	finally
    //   293	310	396	finally
    //   319	325	396	finally
    //   329	340	396	finally
    //   26	104	401	java/lang/Exception
    //   108	116	401	java/lang/Exception
    //   120	139	401	java/lang/Exception
    //   148	198	401	java/lang/Exception
  }
  
  public static void dZ(int paramInt, String paramString)
  {
    if (paramString == null) {}
    for (String str = "";; str = paramString)
    {
      int i = jqi.getNetworkType(BaseApplicationImpl.getApplication());
      paramString = "";
      switch (i)
      {
      }
      for (;;)
      {
        anot.b(null, "P_CliOper", "HealthStepReport", "", "ReportResult", paramString, paramInt, 1, ecQ, String.valueOf(ecP), String.valueOf(ecO), str, Build.MODEL);
        return;
        paramString = "no_network";
        continue;
        paramString = "wifi";
        continue;
        paramString = "2g";
        continue;
        paramString = "3g";
        continue;
        paramString = "4g";
        continue;
        paramString = "unknown";
      }
    }
  }
  
  public static void efC()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = new Date();
      String str = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject2);
      localObject2 = str + "-RedPack";
      str = str + "-RedPack-TimeLimit";
      localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences(((QQAppInterface)localObject1).getCurrentAccountUin() + ".qqsport", 4);
      if (((SharedPreferences)localObject1).getInt("STEP_RED_PACK_STATUS", 0) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SSOHttpUtils", 2, "redPackStatus:" + bool);
        }
        if (!bool) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("SSOHttpUtils", 2, "sp.getBoolean(sortRedPackKey, true):" + ((SharedPreferences)localObject1).getBoolean((String)localObject2, true));
        }
        if (!((SharedPreferences)localObject1).getBoolean((String)localObject2, true)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("SSOHttpUtils", 2, "sortRedPackTimeLimit:" + ((SharedPreferences)localObject1).getLong(str, 0L));
        }
        if ((((SharedPreferences)localObject1).getLong(str, 0L) != 0L) && (((SharedPreferences)localObject1).getLong(str, 0L) - System.currentTimeMillis() <= 3600000L)) {
          break;
        }
        efD();
        ((SharedPreferences)localObject1).edit().putLong(str, System.currentTimeMillis()).commit();
        return;
      }
    }
  }
  
  public static void efD()
  {
    QLog.i("SSOHttpUtils", 1, "requestRedPack");
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {
        return;
      }
      Object localObject4 = new JSONObject();
      try
      {
        ((JSONObject)localObject4).put("reqtype", 1);
        localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((TicketManager)localObject2).getSkey(((QQAppInterface)localObject1).getCurrentAccountUin());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm;
          continue;
          Object localObject3 = null;
        }
      }
      ((JSONObject)localObject4).put("skey", localObject2);
      ((JSONObject)localObject4).put("platform", 2);
      ((JSONObject)localObject4).put("version", "3.4.4");
      localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("3.4.4");
      localObject2 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject2).comm.set(localUniSsoServerReqComm);
      ((WebSSOAgent.UniSsoServerReq)localObject2).reqdata.set(((JSONObject)localObject4).toString());
      if (QLog.isColorLevel()) {
        QLog.i("SSOHttpUtils", 2, "parameter:" + ((JSONObject)localObject4).toString());
      }
      localObject4 = new NewIntent(BaseApplicationImpl.getApplication().getApplicationContext(), ailu.class);
      ((NewIntent)localObject4).putExtra("extra_cmd", "SportsAioTips.RedpkgTips");
      ((NewIntent)localObject4).putExtra("extra_data", ((WebSSOAgent.UniSsoServerReq)localObject2).toByteArray());
      ((NewIntent)localObject4).setObserver(new aqty((QQAppInterface)localObject1));
      BaseApplicationImpl.getApplication().getRuntime().startServlet((NewIntent)localObject4);
      return;
    }
  }
  
  public static long hU()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static long hV()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(11, 23);
    localCalendar.set(12, 59);
    localCalendar.set(13, 59);
    return localCalendar.getTimeInMillis();
  }
  
  public static long hW()
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    localCalendar.set(5, localCalendar.get(5) - 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static boolean mG(int paramInt)
  {
    Object localObject1;
    if ((hZ == null) || (ia == null))
    {
      localObject1 = new File(BaseApplicationImpl.getContext().getFilesDir(), aqpi.e.cuN);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = aqhq.readFileContent((File)localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      }
    }
    try
    {
      Object localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("login_report");
      localObject2 = ((JSONObject)localObject2).optString("timmer_report");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        hZ = ((String)localObject1).split(",");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ia = ((String)localObject2).split(",");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("SSOHttpUtils", 2, "parse json failed:" + localException.toString());
          continue;
          paramInt += 1;
        }
      }
      if ((paramInt != 2) || (ia == null) || (ia.length == 0)) {
        break label341;
      }
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (TextUtils.isEmpty(str)) {
        break label341;
      }
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= ia.length) {
          break label341;
        }
        if (str.endsWith(ia[paramInt]))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("SSOHttpUtils", 2, "timmer report found current uin banned!");
          return false;
        }
        paramInt += 1;
      }
    }
    if (hZ == null) {
      hZ = new String[0];
    }
    if (ia == null) {
      ia = new String[0];
    }
    if (paramInt == 1)
    {
      if ((hZ == null) || (hZ.length == 0)) {
        break label341;
      }
      localObject1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label341;
      }
      paramInt = 0;
      if (paramInt >= hZ.length) {
        break label341;
      }
      if (((String)localObject1).endsWith(hZ[paramInt]))
      {
        if (QLog.isColorLevel()) {
          QLog.i("SSOHttpUtils", 2, "login report found current uin banned!");
        }
        return false;
      }
    }
    label341:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqtw
 * JD-Core Version:    0.7.0.1
 */