import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public class msz
{
  public static final String TAG = "Q.readinjoy.video." + msz.class.getSimpleName();
  private static int aUl = -1;
  private static volatile JSONObject ax;
  private static float jJ = -1.0F;
  
  /* Error */
  private static JSONObject H()
  {
    // Byte code:
    //   0: new 49	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 50	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: astore_2
    //   10: aload_1
    //   11: ldc 52
    //   13: invokestatic 57	aqgz:getIMEI	()Ljava/lang/String;
    //   16: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   19: pop
    //   20: aload_1
    //   21: astore_2
    //   22: aload_1
    //   23: ldc 63
    //   25: invokestatic 66	aqgz:getIMSI	()Ljava/lang/String;
    //   28: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_1
    //   33: astore_2
    //   34: aload_1
    //   35: ldc 68
    //   37: invokestatic 72	aqgz:getCpuFrequency	()J
    //   40: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_1
    //   45: astore_2
    //   46: aload_1
    //   47: ldc 77
    //   49: invokestatic 81	aqgz:getCpuNumber	()I
    //   52: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_1
    //   57: astore_2
    //   58: aload_1
    //   59: ldc 86
    //   61: invokestatic 89	aqgz:getOsVersion	()I
    //   64: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload_1
    //   69: astore_2
    //   70: aload_1
    //   71: ldc 91
    //   73: invokestatic 94	aqgz:getDeviceModel	()Ljava/lang/String;
    //   76: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_1
    //   81: astore_2
    //   82: aload_1
    //   83: ldc 96
    //   85: invokestatic 99	aqgz:getDeviceOSVersion	()Ljava/lang/String;
    //   88: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   91: pop
    //   92: aload_1
    //   93: astore_2
    //   94: aload_1
    //   95: ldc 101
    //   97: invokestatic 104	aqgz:BY	()Ljava/lang/String;
    //   100: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload_1
    //   105: astore_2
    //   106: aload_1
    //   107: ldc 106
    //   109: getstatic 111	android/os/Build$VERSION:SDK_INT	I
    //   112: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_1
    //   117: astore_2
    //   118: aload_1
    //   119: ldc 113
    //   121: invokestatic 116	aqgz:getQQVersion	()Ljava/lang/String;
    //   124: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   127: pop
    //   128: aload_1
    //   129: astore_2
    //   130: aload_1
    //   131: ldc 118
    //   133: invokestatic 121	aqgz:getSystemTotalMemory	()J
    //   136: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   139: pop
    //   140: aload_1
    //   141: astore_2
    //   142: aload_1
    //   143: ldc 123
    //   145: invokestatic 126	aqgz:getSystemAvaialbeMemory	()J
    //   148: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_1
    //   153: astore_2
    //   154: invokestatic 130	aqgz:getRomMemroy	()[J
    //   157: astore_3
    //   158: aload_1
    //   159: astore_2
    //   160: aload_1
    //   161: ldc 132
    //   163: aload_3
    //   164: iconst_0
    //   165: laload
    //   166: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload_1
    //   171: astore_2
    //   172: aload_1
    //   173: ldc 134
    //   175: aload_3
    //   176: iconst_1
    //   177: laload
    //   178: invokevirtual 75	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload_1
    //   183: astore_2
    //   184: aload_1
    //   185: ldc 136
    //   187: iconst_1
    //   188: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload_1
    //   193: astore_2
    //   194: invokestatic 139	msz:kt	()Ljava/lang/String;
    //   197: astore_3
    //   198: aload_1
    //   199: astore_2
    //   200: aload_1
    //   201: ldc 141
    //   203: aload_3
    //   204: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_1
    //   209: astore_2
    //   210: aload_1
    //   211: ldc 143
    //   213: aload_3
    //   214: invokestatic 147	msz:eU	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload_1
    //   222: astore_2
    //   223: getstatic 38	msz:aUl	I
    //   226: iconst_m1
    //   227: if_icmpne +32 -> 259
    //   230: iconst_0
    //   231: istore_0
    //   232: aload_1
    //   233: astore_2
    //   234: aload_1
    //   235: ldc 149
    //   237: iload_0
    //   238: invokevirtual 84	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   241: pop
    //   242: aload_1
    //   243: astore_2
    //   244: aload_1
    //   245: ldc 151
    //   247: invokestatic 155	msz:ai	()F
    //   250: invokestatic 161	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   253: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   256: pop
    //   257: aload_1
    //   258: areturn
    //   259: aload_1
    //   260: astore_2
    //   261: getstatic 38	msz:aUl	I
    //   264: istore_0
    //   265: goto -33 -> 232
    //   268: astore_3
    //   269: aconst_null
    //   270: astore_1
    //   271: aload_1
    //   272: astore_2
    //   273: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +46 -> 322
    //   279: aload_1
    //   280: astore_2
    //   281: getstatic 36	msz:TAG	Ljava/lang/String;
    //   284: iconst_2
    //   285: new 16	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   292: ldc 169
    //   294: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_3
    //   298: invokevirtual 172	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   301: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 176	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   310: aload_1
    //   311: areturn
    //   312: astore_1
    //   313: aload_2
    //   314: areturn
    //   315: astore_1
    //   316: aconst_null
    //   317: areturn
    //   318: astore_3
    //   319: goto -48 -> 271
    //   322: aload_1
    //   323: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   231	34	0	i	int
    //   7	304	1	localJSONObject1	JSONObject
    //   312	1	1	localObject1	Object
    //   315	8	1	localJSONObject2	JSONObject
    //   9	305	2	localJSONObject3	JSONObject
    //   157	57	3	localObject2	Object
    //   268	30	3	localThrowable1	Throwable
    //   318	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	8	268	java/lang/Throwable
    //   10	20	312	finally
    //   22	32	312	finally
    //   34	44	312	finally
    //   46	56	312	finally
    //   58	68	312	finally
    //   70	80	312	finally
    //   82	92	312	finally
    //   94	104	312	finally
    //   106	116	312	finally
    //   118	128	312	finally
    //   130	140	312	finally
    //   142	152	312	finally
    //   154	158	312	finally
    //   160	170	312	finally
    //   172	182	312	finally
    //   184	192	312	finally
    //   194	198	312	finally
    //   200	208	312	finally
    //   210	221	312	finally
    //   223	230	312	finally
    //   234	242	312	finally
    //   244	257	312	finally
    //   261	265	312	finally
    //   273	279	312	finally
    //   281	310	312	finally
    //   0	8	315	finally
    //   10	20	318	java/lang/Throwable
    //   22	32	318	java/lang/Throwable
    //   34	44	318	java/lang/Throwable
    //   46	56	318	java/lang/Throwable
    //   58	68	318	java/lang/Throwable
    //   70	80	318	java/lang/Throwable
    //   82	92	318	java/lang/Throwable
    //   94	104	318	java/lang/Throwable
    //   106	116	318	java/lang/Throwable
    //   118	128	318	java/lang/Throwable
    //   130	140	318	java/lang/Throwable
    //   142	152	318	java/lang/Throwable
    //   154	158	318	java/lang/Throwable
    //   160	170	318	java/lang/Throwable
    //   172	182	318	java/lang/Throwable
    //   184	192	318	java/lang/Throwable
    //   194	198	318	java/lang/Throwable
    //   200	208	318	java/lang/Throwable
    //   210	221	318	java/lang/Throwable
    //   223	230	318	java/lang/Throwable
    //   234	242	318	java/lang/Throwable
    //   244	257	318	java/lang/Throwable
    //   261	265	318	java/lang/Throwable
  }
  
  private static void aRQ()
  {
    if (aqvn.a().aFK()) {
      if (aqiw.getNetworkType(BaseApplicationImpl.getApplication()) == 0) {
        aqvn.a().a(new mta(), false);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.w(TAG, 2, "queryKingCardType(), can only query in mobile connection");
      return;
    }
    QLog.e(TAG, 2, "queryKingCardType(), so not ready");
  }
  
  public static float ai()
  {
    if (jJ > 0.0F) {
      return jJ;
    }
    for (;;)
    {
      int j;
      int k;
      int m;
      try
      {
        Object localObject1 = Class.forName("android.media.MediaCodecList");
        Object localObject3 = ((Class)localObject1).getDeclaredMethod("getCodecCount", new Class[0]);
        localObject1 = ((Class)localObject1).getDeclaredMethod("getCodecInfoAt", new Class[] { Integer.TYPE });
        Object localObject2 = Class.forName("android.media.MediaCodecInfo");
        Method localMethod1 = ((Class)localObject2).getDeclaredMethod("getSupportedTypes", new Class[0]);
        ((Class)localObject2).getDeclaredMethod("getName", new Class[0]);
        Method localMethod2 = ((Class)localObject2).getDeclaredMethod("isEncoder", new Class[0]);
        localObject2 = ((Class)localObject2).getDeclaredMethod("getCapabilitiesForType", new Class[] { String.class });
        Field localField1 = Class.forName("android.media.MediaCodecInfo$CodecCapabilities").getDeclaredField("profileLevels");
        Field localField2 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel").getDeclaredField("level");
        int n = ((Integer)((Method)localObject3).invoke(null, new Object[0])).intValue();
        i = -1;
        j = 0;
        if (j < n)
        {
          localObject3 = ((Method)localObject1).invoke(null, new Object[] { Integer.valueOf(j) });
          if (((Boolean)localMethod2.invoke(localObject3, new Object[0])).booleanValue())
          {
            k = i;
          }
          else
          {
            String[] arrayOfString = (String[])localMethod1.invoke(localObject3, new Object[0]);
            int i1 = arrayOfString.length;
            m = 0;
            k = i;
            if (m < i1) {
              if (arrayOfString[m].equalsIgnoreCase("video/hevc"))
              {
                localObject3 = (Object[])localField1.get(((Method)localObject2).invoke(localObject3, new Object[] { "video/hevc" }));
                i1 = localObject3.length;
                k = 0;
                if (k < i1)
                {
                  m = ((Integer)localField2.get(localObject3[k])).intValue();
                  if (m <= i) {
                    break label357;
                  }
                  i = m;
                  break label369;
                }
                jJ = k(i);
                k = i;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        jJ = 0.0F;
      }
      return jJ;
      m += 1;
      continue;
      label357:
      break label369;
      j += 1;
      int i = k;
      continue;
      label369:
      k += 1;
    }
  }
  
  private static String eU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "CPU_OTHER";
    }
    try
    {
      paramString = paramString.toLowerCase();
      if ((!paramString.contains("exynos")) && (!paramString.contains("smdk")) && (!paramString.contains("s5l8900")) && (!paramString.contains("s5pc100")))
      {
        if ((paramString.contains("kirin")) || (paramString.contains("k3v"))) {
          break label142;
        }
        if ((paramString.contains("msm")) || (paramString.contains("apq")) || (paramString.contains("qsd"))) {
          break label146;
        }
        if (paramString.contains("mt6")) {
          return "CPU_MTK";
        }
        return "CPU_OTHER";
      }
    }
    catch (Throwable paramString)
    {
      return "CPU_OTHER";
    }
    return "CPU_SUMSUNG";
    label142:
    return "CPU_HISI";
    label146:
    return "CPU_QUALCOMM";
  }
  
  public static String h(boolean paramBoolean)
  {
    if ((!paramBoolean) && (ax != null)) {
      return ax.toString();
    }
    try
    {
      if (ax == null)
      {
        ax = H();
        if (aUl == -1) {
          aRQ();
        }
      }
      if (!paramBoolean)
      {
        String str = ax.toString();
        return str;
      }
    }
    finally {}
    try
    {
      Object localObject2 = new JSONObject(ax.toString());
      ((JSONObject)localObject2).put("speedsInfo", mtb.j());
      localObject2 = ((JSONObject)localObject2).toString();
      return localObject2;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
  
  private static float k(int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
      int i = ((Integer)localClass.getField("HEVCHighTierLevel1").get(null)).intValue();
      int j = ((Integer)localClass.getField("HEVCHighTierLevel2").get(null)).intValue();
      int k = ((Integer)localClass.getField("HEVCHighTierLevel21").get(null)).intValue();
      int m = ((Integer)localClass.getField("HEVCHighTierLevel3").get(null)).intValue();
      int n = ((Integer)localClass.getField("HEVCHighTierLevel31").get(null)).intValue();
      int i1 = ((Integer)localClass.getField("HEVCHighTierLevel4").get(null)).intValue();
      int i2 = ((Integer)localClass.getField("HEVCHighTierLevel41").get(null)).intValue();
      int i3 = ((Integer)localClass.getField("HEVCHighTierLevel5").get(null)).intValue();
      int i4 = ((Integer)localClass.getField("HEVCHighTierLevel51").get(null)).intValue();
      int i5 = ((Integer)localClass.getField("HEVCHighTierLevel52").get(null)).intValue();
      int i6 = ((Integer)localClass.getField("HEVCHighTierLevel6").get(null)).intValue();
      int i7 = ((Integer)localClass.getField("HEVCHighTierLevel61").get(null)).intValue();
      int i8 = ((Integer)localClass.getField("HEVCHighTierLevel62").get(null)).intValue();
      int i9 = ((Integer)localClass.getField("HEVCMainTierLevel1").get(null)).intValue();
      int i10 = ((Integer)localClass.getField("HEVCMainTierLevel2").get(null)).intValue();
      int i11 = ((Integer)localClass.getField("HEVCMainTierLevel21").get(null)).intValue();
      int i12 = ((Integer)localClass.getField("HEVCMainTierLevel3").get(null)).intValue();
      int i13 = ((Integer)localClass.getField("HEVCMainTierLevel31").get(null)).intValue();
      int i14 = ((Integer)localClass.getField("HEVCMainTierLevel4").get(null)).intValue();
      int i15 = ((Integer)localClass.getField("HEVCMainTierLevel41").get(null)).intValue();
      int i16 = ((Integer)localClass.getField("HEVCMainTierLevel5").get(null)).intValue();
      int i17 = ((Integer)localClass.getField("HEVCMainTierLevel51").get(null)).intValue();
      int i18 = ((Integer)localClass.getField("HEVCMainTierLevel52").get(null)).intValue();
      int i19 = ((Integer)localClass.getField("HEVCMainTierLevel6").get(null)).intValue();
      int i20 = ((Integer)localClass.getField("HEVCMainTierLevel61").get(null)).intValue();
      int i21 = ((Integer)localClass.getField("HEVCMainTierLevel62").get(null)).intValue();
      if ((paramInt == i) || (paramInt == i9)) {
        return 1.0F;
      }
      if ((paramInt == j) || (paramInt == i10)) {
        return 2.0F;
      }
      if ((paramInt == k) || (paramInt == i11)) {
        return 2.1F;
      }
      if ((paramInt == m) || (paramInt == i12)) {
        return 3.0F;
      }
      if ((paramInt == n) || (paramInt == i13)) {
        return 3.1F;
      }
      if ((paramInt == i1) || (paramInt == i14)) {
        return 4.0F;
      }
      if ((paramInt == i2) || (paramInt == i15)) {
        return 4.1F;
      }
      if ((paramInt == i3) || (paramInt == i16)) {
        return 5.0F;
      }
      if ((paramInt == i4) || (paramInt == i17)) {
        return 5.1F;
      }
      if ((paramInt == i5) || (paramInt == i18)) {
        return 5.2F;
      }
      if ((paramInt == i6) || (paramInt == i19)) {
        return 6.0F;
      }
      if ((paramInt >= i7) || (paramInt == i20)) {
        return 6.1F;
      }
      if ((paramInt >= i8) || (paramInt == i21)) {
        return 6.2F;
      }
    }
    catch (Exception localException) {}
    return 0.0F;
  }
  
  /* Error */
  private static String kt()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 437	java/io/InputStreamReader
    //   5: dup
    //   6: new 439	java/io/FileInputStream
    //   9: dup
    //   10: ldc_w 441
    //   13: invokespecial 442	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   16: ldc_w 444
    //   19: invokespecial 447	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: astore 4
    //   24: new 449	java/io/BufferedReader
    //   27: dup
    //   28: aload 4
    //   30: invokespecial 452	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 455	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnonnull +44 -> 86
    //   45: aload_2
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +7 -> 60
    //   56: ldc_w 457
    //   59: astore_2
    //   60: aload 4
    //   62: ifnull +8 -> 70
    //   65: aload 4
    //   67: invokevirtual 460	java/io/InputStreamReader:close	()V
    //   70: aload_2
    //   71: astore_3
    //   72: aload 5
    //   74: ifnull +10 -> 84
    //   77: aload 5
    //   79: invokevirtual 461	java/io/BufferedReader:close	()V
    //   82: aload_2
    //   83: astore_3
    //   84: aload_3
    //   85: areturn
    //   86: aload_3
    //   87: ldc_w 463
    //   90: invokevirtual 466	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   93: ifeq -58 -> 35
    //   96: aload_3
    //   97: bipush 58
    //   99: invokevirtual 469	java/lang/String:indexOf	(I)I
    //   102: istore_0
    //   103: iload_0
    //   104: iconst_1
    //   105: if_icmple -70 -> 35
    //   108: aload_3
    //   109: iload_0
    //   110: iconst_1
    //   111: iadd
    //   112: aload_3
    //   113: invokevirtual 472	java/lang/String:length	()I
    //   116: invokevirtual 476	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: invokevirtual 479	java/lang/String:trim	()Ljava/lang/String;
    //   122: ldc_w 481
    //   125: ldc_w 367
    //   128: invokevirtual 485	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   131: astore_3
    //   132: aload_3
    //   133: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   136: istore_1
    //   137: aload_3
    //   138: astore_2
    //   139: iload_1
    //   140: ifne -105 -> 35
    //   143: goto -96 -> 47
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_2
    //   149: aconst_null
    //   150: astore 4
    //   152: ldc_w 457
    //   155: astore_3
    //   156: aload 4
    //   158: ifnull +8 -> 166
    //   161: aload 4
    //   163: invokevirtual 460	java/io/InputStreamReader:close	()V
    //   166: aload_2
    //   167: ifnull -83 -> 84
    //   170: aload_2
    //   171: invokevirtual 461	java/io/BufferedReader:close	()V
    //   174: ldc_w 457
    //   177: areturn
    //   178: astore_2
    //   179: ldc_w 457
    //   182: areturn
    //   183: astore_2
    //   184: aconst_null
    //   185: astore 4
    //   187: aconst_null
    //   188: astore_3
    //   189: aload 4
    //   191: ifnull +8 -> 199
    //   194: aload 4
    //   196: invokevirtual 460	java/io/InputStreamReader:close	()V
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 461	java/io/BufferedReader:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_3
    //   210: goto -3 -> 207
    //   213: astore_2
    //   214: aconst_null
    //   215: astore_3
    //   216: goto -27 -> 189
    //   219: astore_2
    //   220: aload 5
    //   222: astore_3
    //   223: goto -34 -> 189
    //   226: astore_2
    //   227: aconst_null
    //   228: astore_2
    //   229: goto -77 -> 152
    //   232: astore_2
    //   233: aload 5
    //   235: astore_2
    //   236: goto -84 -> 152
    //   239: astore_3
    //   240: aload_2
    //   241: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   102	10	0	i	int
    //   136	4	1	bool	boolean
    //   1	138	2	localObject1	Object
    //   146	1	2	localThrowable1	Throwable
    //   148	23	2	localObject2	Object
    //   178	1	2	localIOException1	java.io.IOException
    //   183	25	2	localObject3	Object
    //   213	1	2	localObject4	Object
    //   219	1	2	localObject5	Object
    //   226	1	2	localThrowable2	Throwable
    //   228	1	2	localObject6	Object
    //   232	1	2	localThrowable3	Throwable
    //   235	6	2	localObject7	Object
    //   40	164	3	localObject8	Object
    //   209	1	3	localIOException2	java.io.IOException
    //   215	8	3	localBufferedReader1	java.io.BufferedReader
    //   239	1	3	localIOException3	java.io.IOException
    //   22	173	4	localInputStreamReader	java.io.InputStreamReader
    //   33	201	5	localBufferedReader2	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   2	24	146	java/lang/Throwable
    //   161	166	178	java/io/IOException
    //   170	174	178	java/io/IOException
    //   2	24	183	finally
    //   194	199	209	java/io/IOException
    //   203	207	209	java/io/IOException
    //   24	35	213	finally
    //   35	41	219	finally
    //   49	56	219	finally
    //   86	103	219	finally
    //   108	137	219	finally
    //   24	35	226	java/lang/Throwable
    //   35	41	232	java/lang/Throwable
    //   49	56	232	java/lang/Throwable
    //   86	103	232	java/lang/Throwable
    //   108	137	232	java/lang/Throwable
    //   65	70	239	java/io/IOException
    //   77	82	239	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     msz
 * JD-Core Version:    0.7.0.1
 */