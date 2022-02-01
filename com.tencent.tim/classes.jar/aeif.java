import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mfsdk.config.QConfigAPMProcessor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager.1;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class aeif
{
  public static final int[] kR = { 390, 26, 76, 95, 455, 524, 409, 469, 412, 359, 413, 563, 427, 428, 465, 477, 491, 542, 414, 419, 416, 445, 418, 424, 411, 423, 406, 417, 425, 426, 613, 632, 67, 430, 68, 526, 612, 463, 595, 380, 159, 170, 186, 250, 92, 368, 158, 361, 207, 585, 292, 168, 433, 432, 434, 456, 460, 435, 438, 441, 106, 132, 172, 176, 192, 216, 249, 263, 270, 276, 287, 367, 370, 382, 298, 431, 543, 591, 623, 439, 442, 488, 444, 362, 396, 449, 626, 625, 85, 606, 32, 35, 70, 81, 383, 346, 294, 334, 335, 338, 342, 344, 348, 377, 429, 437, 440, 525, 569, 164, 325, 252, 304, 305, 306, 307, 309, 310, 446, 447, 15, 458, 572, 453, 454, 452, 457, 547, 462, 451, 261, 467, 466, 490, 470, 478, 479, 473, 474, 485, 483, 484, 487, 489, 486, 492, 498, 493, 500, 251, 616, 587, 521, 495, 496, 502, 503, 504, 505, 506, 507, 508, 560, 509, 520, 516, 515, 519, 518, 517, 514, 512, 511, 513, 510, 600, 2049, 493, 500, 251, 616, 587, 521, 482, 501, 497, 522, 529, 499, 528, 527, 541, 562, 628, 580, 533, 534, 532, 535, 537, 538, 545, 546, 544, 590, 609, 550, 530, 561, 575, 551, 607, 552, 553, 531, 549, 554, 555, 556, 557, 559, 564, 581, 566, 578, 567, 568, 576, 579, 583, 574, 573, 586, 577, 589, 592, 593, 598, 614, 597, 605, 617, 608, 610, 615, 611, 619, 634, 638, 624, 630, 618, 621, 620, 622, 631, 633, 635, 255, 640, 661, 736 };
  private static final Object[] r = { new Object(), new Object(), new Object(), new Object(), new Object() };
  private final String alm;
  private final Object dq = new Object();
  private final Object dr = new Object();
  private final Object ds = new Object();
  private final Object dt = new Object();
  private final Map<Integer, aehv> jS = new ConcurrentHashMap();
  private final Map<Integer, aeif.a> jT = new ConcurrentHashMap();
  private final Map<Long, SharedPreferences> jU = new HashMap();
  private final Map<Long, SharedPreferences> jV = new HashMap();
  private final Map<Long, SharedPreferences> jW = new HashMap();
  
  public aeif()
  {
    File localFile = BaseApplicationImpl.getApplication().getFilesDir();
    Object localObject = localFile;
    if (localFile == null) {
      localObject = BaseApplicationImpl.getApplication().getCacheDir();
    }
    if (localObject != null) {}
    for (localObject = ((File)localObject).getParent();; localObject = File.separator + "data" + File.separator + "data" + File.separator + BaseApplicationImpl.getContext().getPackageName())
    {
      this.alm = ((String)localObject + File.separator + "qstore");
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "QConfigManager constructor, rootPath=" + this.alm);
      }
      return;
    }
  }
  
  private int a(aehv paramaehv, int paramInt, long paramLong)
  {
    int i = a(paramLong).getInt(String.valueOf(paramInt), -1);
    paramInt = i;
    if (i == -1) {
      paramInt = paramaehv.migrateOldVersion();
    }
    return paramInt;
  }
  
  public static aeif a()
  {
    return aeif.b.a;
  }
  
  private SharedPreferences a(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jV.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.dr)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jV.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_sharepref";
          localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jV.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private <T> T a(aehv<T> paramaehv, int paramInt)
  {
    Object localObject2 = paramaehv.migrateOldOrDefaultContent(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = newInstance(paramaehv.clazz());
    }
    return localObject1;
  }
  
  private Object a(aehv paramaehv, long paramLong, int paramInt)
  {
    Object localObject2 = o(paramaehv.type());
    if (localObject2 != null)
    {
      int i = paramaehv.type();
      int j = a(paramaehv, i, paramLong);
      localObject1 = localObject2;
      if (paramaehv.isNeedStoreLargeFile())
      {
        String str1 = a(i, paramLong, j);
        String str2 = a(i, paramLong, paramInt);
        localObject1 = localObject2;
        if (!TextUtils.equals(str2, str1)) {
          aqhq.c(str1, str2, false);
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = paramaehv.migrateOldOrDefaultContent(0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "loadNewConfigFailBackport, version=" + paramInt + ", type" + paramaehv.type() + ", conf=" + localObject1);
      }
      return localObject1;
    }
  }
  
  private Object a(aehv paramaehv, aeic[] paramArrayOfaeic, int paramInt)
  {
    try
    {
      Object localObject = paramaehv.onParsed(paramArrayOfaeic);
      return localObject;
    }
    catch (Exception localException)
    {
      aeig.a().a(paramaehv, paramArrayOfaeic, paramInt, localException);
    }
    return null;
  }
  
  private String a(int paramInt1, long paramLong, int paramInt2)
  {
    return this.alm + File.separator + paramLong + File.separator + "conf" + File.separator + paramInt1 + File.separator + paramInt2;
  }
  
  private void a(aehv paramaehv, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    int i = paramConfig.msg_content_list.size();
    if (i == 0) {
      paramConfig = paramaehv.migrateOldOrDefaultContent(1);
    }
    label312:
    for (;;)
    {
      if (i == 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(paramaehv, paramConfig, paramInt2, paramLong, bool);
        return;
        ArrayList localArrayList = new ArrayList();
        paramInt1 = 0;
        if (paramInt1 < i)
        {
          ConfigurationService.Content localContent = (ConfigurationService.Content)paramConfig.msg_content_list.get(paramInt1);
          Object localObject1;
          if ((localContent != null) && (localContent.content.has()))
          {
            if (localContent.compress.get() != 1) {
              break label199;
            }
            localObject1 = akrf.inflateConfigString(localContent.content.get().toByteArray());
            if (localObject1 == null) {
              break label193;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = new String((byte[])localObject1, "UTF-8");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                localArrayList.add(new aeic(localContent.task_id.get(), (String)localObject1));
              }
              paramInt1 += 1;
            }
            catch (UnsupportedEncodingException localUnsupportedEncodingException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QConfigManager", 2, "decompile faild.");
              }
            }
            label193:
            localObject2 = null;
            continue;
            label199:
            localObject2 = localContent.content.get().toStringUtf8();
          }
        }
        Object localObject2 = new aeic[localArrayList.size()];
        localArrayList.toArray((Object[])localObject2);
        paramConfig = a(paramaehv, (aeic[])localObject2, paramInt2);
        if (paramConfig != null)
        {
          a(paramaehv, (aeic[])localObject2, paramLong, paramString);
          if (!QLog.isColorLevel()) {
            break label312;
          }
          QLog.d("QConfigManager", 2, "handleNewConfig, parse success, size=" + localObject2.length);
          break;
        }
        paramConfig = a(paramaehv, paramLong, paramInt2);
        break;
      }
    }
  }
  
  private void a(aehv paramaehv, Object paramObject, int paramInt, long paramLong, boolean paramBoolean)
  {
    if (paramObject != null)
    {
      a(paramLong).edit().putInt(String.valueOf(paramaehv.type()), paramInt).putBoolean(paramaehv.type() + "_" + paramInt + "_defualt", paramBoolean).apply();
      this.jT.put(Integer.valueOf(paramaehv.type()), new aeif.a(paramLong, paramInt, paramObject));
      paramaehv.onUpdate(paramObject);
    }
  }
  
  private void a(aehv paramaehv, aeic[] paramArrayOfaeic, long paramLong, String paramString)
  {
    int j = 0;
    int i = 0;
    if (paramaehv.isNeedStoreLargeFile())
    {
      t(new File(paramString));
      while (i < paramArrayOfaeic.length)
      {
        paramaehv = h(paramString, String.valueOf(paramArrayOfaeic[i].taskId));
        if (paramaehv != null) {
          a(paramArrayOfaeic[i].content, paramaehv);
        }
        i += 1;
      }
    }
    paramString = c(paramLong).edit();
    HashSet localHashSet = new HashSet();
    i = j;
    while (i < paramArrayOfaeic.length)
    {
      localHashSet.add(String.valueOf(paramArrayOfaeic[i].taskId));
      paramString.putString(paramaehv.type() + "_" + paramArrayOfaeic[i].taskId, paramArrayOfaeic[i].content);
      i += 1;
    }
    a(paramLong).edit().putStringSet(paramaehv.type() + "_ids", localHashSet).apply();
    paramString.apply();
  }
  
  public static void a(Class paramClass, Object paramObject) {}
  
  /* Error */
  private boolean a(String paramString, File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iload 5
    //   11: istore_3
    //   12: aload_2
    //   13: invokevirtual 424	java/io/File:exists	()Z
    //   16: ifne +11 -> 27
    //   19: aload_2
    //   20: invokevirtual 427	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: iload 5
    //   26: istore_3
    //   27: new 429	java/io/FileOutputStream
    //   30: dup
    //   31: aload_2
    //   32: iconst_0
    //   33: invokespecial 432	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore 6
    //   42: aload 6
    //   44: ifnull +17 -> 61
    //   47: aload 6
    //   49: aload_1
    //   50: invokevirtual 435	java/lang/String:getBytes	()[B
    //   53: invokevirtual 439	java/io/FileOutputStream:write	([B)V
    //   56: aload 6
    //   58: invokevirtual 442	java/io/FileOutputStream:flush	()V
    //   61: aload 6
    //   63: ifnull +128 -> 191
    //   66: aload 6
    //   68: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   71: iload_3
    //   72: ireturn
    //   73: astore 7
    //   75: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +29 -> 107
    //   81: ldc 108
    //   83: iconst_2
    //   84: new 85	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   91: ldc_w 447
    //   94: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: iconst_0
    //   108: istore_3
    //   109: goto -82 -> 27
    //   112: astore 7
    //   114: iconst_0
    //   115: istore_3
    //   116: goto -74 -> 42
    //   119: astore_1
    //   120: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +30 -> 153
    //   126: ldc 108
    //   128: iconst_2
    //   129: new 85	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   136: ldc_w 449
    //   139: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_2
    //   143: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aload_1
    //   150: invokestatic 452	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: iload 4
    //   155: istore_3
    //   156: aload 6
    //   158: ifnull -87 -> 71
    //   161: aload 6
    //   163: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_1
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_1
    //   172: aload 6
    //   174: ifnull +8 -> 182
    //   177: aload 6
    //   179: invokevirtual 445	java/io/FileOutputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: iconst_0
    //   186: ireturn
    //   187: astore_2
    //   188: goto -6 -> 182
    //   191: iload_3
    //   192: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	aeif
    //   0	193	1	paramString	String
    //   0	193	2	paramFile	File
    //   11	181	3	bool1	boolean
    //   1	153	4	bool2	boolean
    //   4	21	5	bool3	boolean
    //   7	171	6	localObject	Object
    //   36	3	7	localFileOutputStream	java.io.FileOutputStream
    //   73	1	7	localIOException	java.io.IOException
    //   112	1	7	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   19	24	73	java/io/IOException
    //   27	38	112	java/io/FileNotFoundException
    //   47	61	119	java/io/IOException
    //   161	166	168	java/io/IOException
    //   47	61	171	finally
    //   120	153	171	finally
    //   66	71	184	java/io/IOException
    //   177	182	187	java/io/IOException
  }
  
  private aeic[] a(int paramInt, long paramLong)
  {
    int i = e(paramInt, paramLong);
    if (c(paramInt) == null) {}
    File[] arrayOfFile;
    do
    {
      return null;
      localObject = new File(a(paramInt, paramLong, i));
      arrayOfFile = ((File)localObject).listFiles();
    } while ((!((File)localObject).exists()) || (arrayOfFile == null) || (arrayOfFile.length == 0));
    Object localObject = new aeic[arrayOfFile.length];
    paramInt = 0;
    while (paramInt < arrayOfFile.length)
    {
      File localFile = arrayOfFile[paramInt];
      localObject[paramInt] = new aeic(d(localFile), n(localFile));
      paramInt += 1;
    }
    return localObject;
  }
  
  private long b(String paramString, boolean paramBoolean)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramBoolean) {}
    try
    {
      l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (Exception localException)
    {
      do
      {
        l1 = l2;
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "Can not parse uin - " + paramString);
    }
    return 0L;
  }
  
  private aehv b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 605: 
      return new aphb();
    case 390: 
      return new aemn();
    case 26: 
      return new aesc();
    case 76: 
      return new aerp();
    case 95: 
      return new aeqw();
    case 189: 
      return new aesg();
    case 409: 
      return new aern();
    case 469: 
      return new aerl();
    case 412: 
      return new aerf();
    case 359: 
      return new aesp();
    case 465: 
      return new aerj();
    case 427: 
      return new aerc();
    case 491: 
      return new aeqx();
    case 413: 
      return new aerw();
    case 563: 
      return new aery();
    case 477: 
      return new aesn();
    case 411: 
      return new spr();
    case 414: 
      return new aeke();
    case 419: 
      return new aeml();
    case 416: 
      return new adxg();
    case 445: 
      return new aibj();
    case 418: 
      return new aeod();
    case 424: 
      return new aevj();
    case 410: 
      return new ygx();
    case 423: 
      return new aesa();
    case 428: 
      return new aerd();
    case 406: 
      return new sqb();
    case 417: 
      return new aejz();
    case 425: 
      return new aekv();
    case 426: 
      return new aelj();
    case 613: 
      return new aell();
    case 632: 
      return new aeln();
    case 67: 
      return new aeis();
    case 430: 
      return new aeiu();
    case 380: 
      return new aeiy.e();
    case 159: 
      return new aeiy.d();
    case 170: 
      return new aeiy.a();
    case 186: 
      return new aeiy.b();
    case 250: 
      return new aeiy.c();
    case 292: 
      return new aenm();
    case 92: 
      return new aenn();
    case 368: 
      return new aeno();
    case 158: 
      return new aeov();
    case 361: 
      return new aeox();
    case 207: 
      return new aeoz();
    case 585: 
      return new aeot();
    case 168: 
      return new aejv();
    case 453: 
      return new aejq();
    case 68: 
      return new aemc();
    case 526: 
      return new anmi();
    case 612: 
      return new anwl();
    case 456: 
      return new aeta();
    case 460: 
      return new aesr();
    case 433: 
      return new aesv();
    case 432: 
      return new aesx();
    case 434: 
      return new aest();
    case 435: 
      return new aeop();
    case 438: 
      return new zau();
    case 441: 
      return new aenc();
    case 631: 
      return new aene();
    case 106: 
    case 132: 
    case 172: 
    case 176: 
    case 192: 
    case 216: 
    case 249: 
    case 263: 
    case 270: 
    case 276: 
    case 287: 
    case 298: 
    case 367: 
    case 370: 
    case 382: 
    case 543: 
    case 591: 
    case 623: 
      return new igl(paramInt);
    case 431: 
      return new igi();
    case 439: 
      return new aemi();
    case 442: 
      return new aeme();
    case 488: 
      return new aemg();
    case 444: 
      return new aerh();
    case 362: 
      return new aenx();
    case 164: 
      return new ahyt();
    case 325: 
      return new anfn();
    case 396: 
      return new aepu();
    case 85: 
      return new aepw();
    case 81: 
      return new kdh();
    case 32: 
      return new kdf();
    case 35: 
      return new kdb();
    case 70: 
      return new kdd();
    case 383: 
      return new aets();
    case 346: 
      return new aeus();
    case 294: 
      return new aeto();
    case 334: 
      return new aetk();
    case 335: 
      return new aeuo();
    case 338: 
      return new aety();
    case 342: 
      return new aetm();
    case 344: 
      return new aeuw();
    case 348: 
      return new aeuq();
    case 377: 
      return new aeuc();
    case 429: 
      return new aetu();
    case 525: 
      return new aeue();
    case 569: 
      return new aetw();
    case 437: 
      return new aeuk();
    case 440: 
      return new aeug();
    case 252: 
      return new aenp();
    case 304: 
      return new aemv();
    case 446: 
      return new aekt();
    case 305: 
      return new aemt();
    case 306: 
      return new aemr();
    case 307: 
      return new aemx();
    case 309: 
      return new aemp();
    case 310: 
      return new aemo();
    case 457: 
      return new aeim();
    case 547: 
      return new apoq();
    case 449: 
      return new aeqi();
    case 626: 
      return new aepq();
    case 625: 
      return new aeps();
    case 447: 
      return new oib();
    case 458: 
      return new aeld();
    case 572: 
      return new aelf();
    case 15: 
      return new aole();
    case 454: 
      return new aiwi();
    case 452: 
      return new aejl();
    case 462: 
      return new aeux();
    case 455: 
      return new aejx();
    case 524: 
      return new aelb();
    case 451: 
      return new aeum();
    case 261: 
      return new aetq();
    case 463: 
      return new spz();
    case 595: 
      return new spx();
    case 467: 
      return new aelt();
    case 466: 
      return new aelr();
    case 490: 
      return new aenr();
    case 470: 
      return new znu();
    case 478: 
      return new ajij();
    case 479: 
      return new aeqr();
    case 473: 
      return new spt();
    case 474: 
      return new spv();
    case 485: 
      return new amir();
    case 483: 
      return new aeua();
    case 484: 
      return new aepd();
    case 487: 
      return new aeui();
    case 489: 
      return new aekx();
    case 486: 
      return new aete();
    case 492: 
      return new aekg();
    case 498: 
      return new aerb();
    case 500: 
      return new aetg();
    case 493: 
      return new aepi();
    case 521: 
      return new aeti();
    case 251: 
      return new aelx();
    case 616: 
      return new aelz();
    case 587: 
      return new aelv();
    case 496: 
      return new akyt.a();
    case 495: 
      return new akyw();
    case 502: 
      return new akyv.a();
    case 503: 
      return new akyv.w();
    case 504: 
      return new akyv.n();
    case 505: 
      return new akyv.i();
    case 506: 
      return new akyv.k();
    case 507: 
      return new akyv.g();
    case 508: 
      return new akyv.j();
    case 560: 
      return new akyv.t();
    case 509: 
      return new akyv.f();
    case 520: 
      return new akyv.l();
    case 516: 
      return new akyv.e();
    case 515: 
      return new akyv.v();
    case 519: 
      return new akyv.b();
    case 518: 
      return new akyv.h();
    case 517: 
      return new akyv.u();
    case 514: 
      return new akyv.c();
    case 512: 
      return new akyv.o();
    case 511: 
      return new akyv.m();
    case 513: 
      return new akyv.s();
    case 510: 
      return new akyv.p();
    case 600: 
      return new akyv.r();
    case 2049: 
      return new akyv.q();
    case 482: 
      return new aeuz();
    case 501: 
      return new aevb();
    case 497: 
      return new aepb();
    case 522: 
      return new ajgq();
    case 529: 
      return new aetc();
    case 527: 
      return new aeqz();
    case 541: 
      return new aequ();
    case 562: 
      return new aese();
    case 628: 
      return new aesm();
    case 580: 
      return new aerr();
    case 534: 
      return new aena();
    case 532: 
      return new afww();
    case 528: 
      return new aejo();
    case 499: 
      return new aeor();
    case 535: 
      return new aeoe();
    case 551: 
      return new aenv();
    case 607: 
      return new aenz();
    case 533: 
      return new aeqc();
    case 542: 
      return new aeqy();
    case 537: 
      return new aeiq();
    case 538: 
      return new aent();
    case 545: 
      return new aenf();
    case 546: 
      return new aenk();
    case 544: 
      return new apmf();
    case 550: 
      return new aeon();
    case 530: 
      return new aema();
    case 561: 
      return new aejt();
    case 552: 
      return new aekl();
    case 553: 
      return new aeoi();
    case 578: 
      return new aelh();
    case 531: 
      return new aejm();
    case 549: 
      return new aeaw();
    case 554: 
      return new aeqg();
    case 555: 
      return new aeqe();
    case 556: 
      return new aepy();
    case 557: 
      return new aeqa();
    case 559: 
      return new aeuu();
    case 564: 
      return new aens();
    case 581: 
      return new aekp();
    case 566: 
      return new aejh();
    case 575: 
      return new aekn();
    case 567: 
      return new aejj();
    case 568: 
      return new aemj();
    case 576: 
      return new aeew();
    case 579: 
      return new aeex();
    case 583: 
      return new aepg();
    case 574: 
      return new aeip();
    case 573: 
      return new aevd();
    case 586: 
      return new aebr();
    case 577: 
      return new anom();
    case 589: 
      return new aesy();
    case 592: 
      return new wsz();
    case 593: 
      return new ken();
    case 617: 
      return new ahtn();
    case 590: 
      return new apow();
    case 609: 
      return new wny();
    case 597: 
      return new aeiv();
    case 598: 
      return new aekk();
    case 614: 
      return new aeki();
    case 606: 
      return new aeqo();
    case 608: 
      return new aekb();
    case 610: 
      return new anvz();
    case 615: 
      return new anwb();
    case 611: 
      return new akyx();
    case 619: 
      return new anwg();
    case 624: 
      return new abdh();
    case 638: 
      return new abde();
    case 634: 
      return new aeio();
    case 630: 
      return new aeni();
    case 618: 
      return new aert();
    case 621: 
      return new aenu();
    case 255: 
      return new QConfigAPMProcessor();
    case 620: 
      return new aejr();
    case 622: 
      return new aejs();
    case 635: 
      return new aeol();
    case 633: 
      return new aeoj();
    case 640: 
      return new aekz();
    case 661: 
      return new aekr();
    }
    return new arnh();
  }
  
  private SharedPreferences b(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jW.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.dt)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jW.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_upgrade_pref";
          localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jW.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private void b(aehv paramaehv, ConfigurationService.Config paramConfig, long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (paramConfig.content_list.isEmpty()) {
      paramString = paramaehv.migrateOldOrDefaultContent(1);
    }
    for (;;)
    {
      a(paramaehv, paramString, paramInt2, paramLong, paramConfig.content_list.isEmpty());
      return;
      int i = paramConfig.content_list.size();
      aeic[] arrayOfaeic = new aeic[i];
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        arrayOfaeic[paramInt1] = new aeic(paramInt1, (String)paramConfig.content_list.get(paramInt1));
        paramInt1 += 1;
      }
      Object localObject = a(paramaehv, arrayOfaeic, paramInt2);
      if (localObject != null)
      {
        a(paramaehv, arrayOfaeic, paramLong, paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("QConfigManager", 2, "handleOldConfig, parse success, size=" + i);
          paramString = localObject;
        }
      }
      else
      {
        paramString = a(paramaehv, paramLong, paramInt2);
        continue;
      }
      paramString = localObject;
    }
  }
  
  private aeic[] b(int paramInt, long paramLong)
  {
    if (a(paramInt) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfigFromSp, type is not support, type=" + paramInt);
      }
      return null;
    }
    Object localObject1 = a(paramLong);
    SharedPreferences localSharedPreferences = c(paramLong);
    Object localObject2 = ((SharedPreferences)localObject1).getStringSet(paramInt + "_ids", null);
    if ((localObject2 == null) || (((Set)localObject2).isEmpty())) {
      return null;
    }
    localObject1 = new aeic[((Set)localObject2).size()];
    localObject2 = ((Set)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject1[i] = new aeic(Integer.valueOf(str).intValue(), localSharedPreferences.getString(paramInt + "_" + str, null));
      i += 1;
    }
    return localObject1;
  }
  
  private aehv c(int paramInt)
  {
    aehv localaehv = a(paramInt);
    if (localaehv == null) {}
    return localaehv;
  }
  
  private SharedPreferences c(long paramLong)
  {
    Object localObject1 = (SharedPreferences)this.jU.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      synchronized (this.ds)
      {
        SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jU.get(Long.valueOf(paramLong));
        localObject1 = localSharedPreferences2;
        if (localSharedPreferences2 == null)
        {
          localObject1 = "conf_" + paramLong + "_content_sharepref";
          localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences((String)localObject1, 4);
          localObject1 = localSharedPreferences2;
          if (localSharedPreferences2 != null)
          {
            this.jU.put(Long.valueOf(paramLong), localSharedPreferences2);
            localObject1 = localSharedPreferences2;
          }
        }
        return localObject1;
      }
    }
    return localSharedPreferences1;
  }
  
  private int d(File paramFile)
  {
    try
    {
      int i = Integer.valueOf(paramFile.getName()).intValue();
      return i;
    }
    catch (NumberFormatException paramFile) {}
    return -1024;
  }
  
  private static void e(Exception paramException)
  {
    try
    {
      throw paramException;
    }
    catch (Exception paramException)
    {
      ThreadManager.getSubThreadHandler().post(new QConfigManager.1(paramException));
    }
  }
  
  private File h(String paramString1, String paramString2)
  {
    if (lE(paramString1)) {
      return new File(paramString1, paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "mkdir dir failed, dir=" + paramString1);
    }
    return null;
  }
  
  private boolean lE(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return true;
    }
    return paramString.mkdirs();
  }
  
  /* Error */
  private String n(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: ifnonnull +29 -> 33
    //   7: aload 8
    //   9: astore 4
    //   11: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +16 -> 30
    //   17: ldc 108
    //   19: iconst_2
    //   20: ldc_w 1289
    //   23: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aload 8
    //   28: astore 4
    //   30: aload 4
    //   32: areturn
    //   33: aload_1
    //   34: invokevirtual 424	java/io/File:exists	()Z
    //   37: ifeq +93 -> 130
    //   40: aload_1
    //   41: invokevirtual 1292	java/io/File:isFile	()Z
    //   44: ifne +41 -> 85
    //   47: aload 8
    //   49: astore 4
    //   51: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq -24 -> 30
    //   57: ldc 108
    //   59: iconst_2
    //   60: new 85	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 1294
    //   70: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aconst_null
    //   84: areturn
    //   85: aload_1
    //   86: invokevirtual 1297	java/io/File:canRead	()Z
    //   89: ifne +79 -> 168
    //   92: aload 8
    //   94: astore 4
    //   96: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq -69 -> 30
    //   102: ldc 108
    //   104: iconst_2
    //   105: new 85	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 1299
    //   115: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aconst_null
    //   129: areturn
    //   130: aload 8
    //   132: astore 4
    //   134: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq -107 -> 30
    //   140: ldc 108
    //   142: iconst_2
    //   143: new 85	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 1301
    //   153: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aconst_null
    //   167: areturn
    //   168: new 1303	java/io/FileInputStream
    //   171: dup
    //   172: aload_1
    //   173: invokespecial 1305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 4
    //   178: new 1307	java/io/InputStreamReader
    //   181: dup
    //   182: aload 4
    //   184: ldc_w 307
    //   187: invokespecial 1310	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   190: astore_3
    //   191: aload_3
    //   192: astore 6
    //   194: aload 4
    //   196: astore 5
    //   198: aload_1
    //   199: invokevirtual 1314	java/io/File:length	()J
    //   202: l2i
    //   203: istore_2
    //   204: iload_2
    //   205: sipush 12288
    //   208: if_icmple +195 -> 403
    //   211: aload_3
    //   212: astore 6
    //   214: aload 4
    //   216: astore 5
    //   218: sipush 4096
    //   221: newarray char
    //   223: astore 7
    //   225: aload_3
    //   226: astore 6
    //   228: aload 4
    //   230: astore 5
    //   232: new 85	java/lang/StringBuilder
    //   235: dup
    //   236: sipush 12288
    //   239: invokespecial 1315	java/lang/StringBuilder:<init>	(I)V
    //   242: astore 9
    //   244: aload_3
    //   245: astore 6
    //   247: aload 4
    //   249: astore 5
    //   251: aload_3
    //   252: aload 7
    //   254: invokevirtual 1319	java/io/InputStreamReader:read	([C)I
    //   257: istore_2
    //   258: iconst_m1
    //   259: iload_2
    //   260: if_icmpeq +100 -> 360
    //   263: aload_3
    //   264: astore 6
    //   266: aload 4
    //   268: astore 5
    //   270: aload 9
    //   272: aload 7
    //   274: iconst_0
    //   275: iload_2
    //   276: invokevirtual 1322	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: goto -36 -> 244
    //   283: astore 7
    //   285: aload_3
    //   286: astore 6
    //   288: aload 4
    //   290: astore 5
    //   292: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +38 -> 333
    //   298: aload_3
    //   299: astore 6
    //   301: aload 4
    //   303: astore 5
    //   305: ldc 108
    //   307: iconst_2
    //   308: new 85	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 1324
    //   318: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: aload 7
    //   330: invokestatic 452	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: aload 4
    //   335: ifnull +8 -> 343
    //   338: aload 4
    //   340: invokevirtual 1327	java/io/InputStream:close	()V
    //   343: aload 8
    //   345: astore 4
    //   347: aload_3
    //   348: ifnull -318 -> 30
    //   351: aload_3
    //   352: invokevirtual 1328	java/io/InputStreamReader:close	()V
    //   355: aconst_null
    //   356: areturn
    //   357: astore_1
    //   358: aconst_null
    //   359: areturn
    //   360: aload_3
    //   361: astore 6
    //   363: aload 4
    //   365: astore 5
    //   367: aload 9
    //   369: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: astore 7
    //   374: aload 7
    //   376: astore_1
    //   377: aload 4
    //   379: ifnull +8 -> 387
    //   382: aload 4
    //   384: invokevirtual 1327	java/io/InputStream:close	()V
    //   387: aload_1
    //   388: astore 4
    //   390: aload_3
    //   391: ifnull -361 -> 30
    //   394: aload_3
    //   395: invokevirtual 1328	java/io/InputStreamReader:close	()V
    //   398: aload_1
    //   399: areturn
    //   400: astore_3
    //   401: aload_1
    //   402: areturn
    //   403: aload_3
    //   404: astore 6
    //   406: aload 4
    //   408: astore 5
    //   410: iload_2
    //   411: newarray char
    //   413: astore 7
    //   415: aload_3
    //   416: astore 6
    //   418: aload 4
    //   420: astore 5
    //   422: new 131	java/lang/String
    //   425: dup
    //   426: aload 7
    //   428: iconst_0
    //   429: aload_3
    //   430: aload 7
    //   432: invokevirtual 1319	java/io/InputStreamReader:read	([C)I
    //   435: invokespecial 1331	java/lang/String:<init>	([CII)V
    //   438: astore 7
    //   440: aload 7
    //   442: astore_1
    //   443: goto -66 -> 377
    //   446: astore_1
    //   447: aconst_null
    //   448: astore 6
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 4
    //   455: ifnull +8 -> 463
    //   458: aload 4
    //   460: invokevirtual 1327	java/io/InputStream:close	()V
    //   463: aload 6
    //   465: ifnull +8 -> 473
    //   468: aload 6
    //   470: invokevirtual 1328	java/io/InputStreamReader:close	()V
    //   473: aload_1
    //   474: athrow
    //   475: astore 4
    //   477: goto -90 -> 387
    //   480: astore_1
    //   481: goto -138 -> 343
    //   484: astore_3
    //   485: goto -22 -> 463
    //   488: astore_3
    //   489: goto -16 -> 473
    //   492: astore_1
    //   493: aconst_null
    //   494: astore 6
    //   496: goto -43 -> 453
    //   499: astore_1
    //   500: aload 5
    //   502: astore 4
    //   504: goto -51 -> 453
    //   507: astore 7
    //   509: aconst_null
    //   510: astore_3
    //   511: aconst_null
    //   512: astore 4
    //   514: goto -229 -> 285
    //   517: astore 7
    //   519: aconst_null
    //   520: astore_3
    //   521: goto -236 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	aeif
    //   0	524	1	paramFile	File
    //   203	208	2	i	int
    //   190	205	3	localInputStreamReader	java.io.InputStreamReader
    //   400	30	3	localException1	Exception
    //   484	1	3	localException2	Exception
    //   488	1	3	localException3	Exception
    //   510	11	3	localObject1	Object
    //   9	450	4	localObject2	Object
    //   475	1	4	localException4	Exception
    //   502	11	4	localObject3	Object
    //   196	305	5	localObject4	Object
    //   192	303	6	localObject5	Object
    //   223	50	7	arrayOfChar	char[]
    //   283	46	7	localException5	Exception
    //   372	69	7	localObject6	Object
    //   507	1	7	localException6	Exception
    //   517	1	7	localException7	Exception
    //   1	343	8	localObject7	Object
    //   242	126	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   198	204	283	java/lang/Exception
    //   218	225	283	java/lang/Exception
    //   232	244	283	java/lang/Exception
    //   251	258	283	java/lang/Exception
    //   270	280	283	java/lang/Exception
    //   367	374	283	java/lang/Exception
    //   410	415	283	java/lang/Exception
    //   422	440	283	java/lang/Exception
    //   351	355	357	java/lang/Exception
    //   394	398	400	java/lang/Exception
    //   168	178	446	finally
    //   382	387	475	java/lang/Exception
    //   338	343	480	java/lang/Exception
    //   458	463	484	java/lang/Exception
    //   468	473	488	java/lang/Exception
    //   178	191	492	finally
    //   198	204	499	finally
    //   218	225	499	finally
    //   232	244	499	finally
    //   251	258	499	finally
    //   270	280	499	finally
    //   292	298	499	finally
    //   305	333	499	finally
    //   367	374	499	finally
    //   410	415	499	finally
    //   422	440	499	finally
    //   168	178	507	java/lang/Exception
    //   178	191	517	java/lang/Exception
  }
  
  public static <T> T newInstance(Class<T> paramClass)
  {
    try
    {
      Object localObject = paramClass.getDeclaredConstructor(new Class[0]);
      ((Constructor)localObject).setAccessible(true);
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      a(paramClass, localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "newInstance failed, class=" + paramClass.getSimpleName(), localException);
      }
    }
    return null;
  }
  
  private void t(File paramFile)
  {
    int j;
    int i;
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      if (paramFile.listFiles().length != 0)
      {
        paramFile = paramFile.listFiles();
        j = paramFile.length;
        i = 0;
      }
    }
    else {
      while (i < j)
      {
        y(paramFile[i]);
        i += 1;
        continue;
        y(paramFile);
      }
    }
  }
  
  private boolean y(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          if (!y(new File(paramFile, arrayOfString[i]))) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public aehv a(int paramInt)
  {
    Object localObject1 = (aehv)this.jS.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      synchronized (this.dq)
      {
        aehv localaehv2 = (aehv)this.jS.get(Integer.valueOf(paramInt));
        localObject1 = localaehv2;
        if (localaehv2 == null)
        {
          localaehv2 = b(paramInt);
          localObject1 = localaehv2;
          if (localaehv2 != null)
          {
            this.jS.put(Integer.valueOf(paramInt), localaehv2);
            localObject1 = localaehv2;
          }
        }
        return localObject1;
      }
    }
    return localaehv1;
  }
  
  public void a(int paramInt1, int paramInt2, ConfigurationService.Config paramConfig, String arg4)
  {
    int i = f(paramInt1, Long.valueOf(???).longValue());
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "[OnReceive] t=" + paramInt1 + " old=" + i + ", new=" + paramInt2);
    }
    if (i == paramInt2) {}
    aehv localaehv;
    do
    {
      do
      {
        return;
        if (!aeid.a().aP(paramInt1, paramInt2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QConfigManager", 2, "conf has been deleted by safemode, type=" + paramInt1 + ", version=" + paramInt2);
      return;
      localaehv = c(paramInt1);
      if (localaehv != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QConfigManager", 2, "Has not define an process," + paramInt1);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QConfigManager", 2, "save config, ov=" + i + " to nv=" + paramInt2 + ", type=" + paramInt1);
    }
    long l = b(???, localaehv.isAccountRelated());
    String str = a(paramInt1, l, paramInt2);
    synchronized (r[(paramInt1 % 5)])
    {
      if ((localaehv.isNeedStoreLargeFile()) && (!lE(str)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QConfigManager", 2, "create conf dir failed, dir=" + str);
        }
        return;
      }
    }
    if (localaehv.isNeedCompressed()) {
      a(localaehv, paramConfig, l, str, i, paramInt2);
    }
    for (;;)
    {
      aeid.a().k(paramInt1, l, localaehv.isNeedStoreLargeFile());
      return;
      b(localaehv, paramConfig, l, str, i, paramInt2);
    }
  }
  
  public void cj(int paramInt, String paramString)
  {
    aehv localaehv = c(paramInt);
    if (localaehv == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "noReceive method has not define an process," + paramInt);
      }
    }
    for (;;)
    {
      return;
      try
      {
        localaehv.onReqNoReceive();
        f(paramInt, Long.valueOf(paramString).longValue());
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QConfigManager", 2, "noReceive config, type=" + paramInt);
        return;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QConfigManager", 2, "Handle noReceive operation exception, type=" + paramInt, paramString);
          }
        }
      }
    }
  }
  
  public int e(int paramInt, long paramLong)
  {
    aehv localaehv = a(paramInt);
    if (localaehv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localaehv, paramInt, paramLong);
  }
  
  public int f(int paramInt, long paramLong)
  {
    int i = a().e(paramInt, paramLong);
    aehv localaehv = a(paramInt);
    if ((localaehv != null) && (localaehv.isNeedUpgradeReset()) && (i == 0)) {
      b(paramLong).edit().putString(String.valueOf(paramInt), AppSetting.getRevision()).apply();
    }
    return i;
  }
  
  public void hJ(int paramInt1, int paramInt2)
  {
    Object localObject = a(paramInt1);
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (((aehv)localObject).isAccountRelated())
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        l1 = l2;
        if (localAppRuntime != null) {
          l1 = b(localAppRuntime.getAccount(), ((aehv)localObject).isAccountRelated());
        }
      }
    }
    localObject = a(l1);
    int i = ((SharedPreferences)localObject).getInt(String.valueOf(paramInt1), -1);
    if ((i != -1) && (i != paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "setConfVersion t=" + paramInt1 + " v=" + paramInt2);
      }
      ((SharedPreferences)localObject).edit().putInt(String.valueOf(paramInt1), paramInt2).apply();
    }
  }
  
  public boolean jf(int paramInt)
  {
    aehv localaehv = a(paramInt);
    if (localaehv == null) {
      return false;
    }
    return localaehv.isNeedCompressed();
  }
  
  public boolean jg(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = kR;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean k(QQAppInterface paramQQAppInterface, int paramInt)
  {
    aehv localaehv = a(paramInt);
    if (localaehv == null) {}
    do
    {
      do
      {
        return false;
      } while (!localaehv.isNeedUpgradeReset());
      paramQQAppInterface = b(paramQQAppInterface.getLongAccountUin()).getString(String.valueOf(paramInt), "");
    } while (TextUtils.equals(AppSetting.getRevision(), paramQQAppInterface));
    return true;
  }
  
  public void n(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!jg(k)) {
        e(new IllegalStateException("QConfigManager has not support the config yet, type=" + k));
      }
      i += 1;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = localAppRuntime.getAccount();
    aevk.mCurUin = str;
    NewIntent localNewIntent = new NewIntent(BaseApplicationImpl.getApplication(), aevk.class);
    localNewIntent.putExtra("k_cmd_type", paramArrayOfInt);
    localNewIntent.putExtra("key_uin", str);
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public <T> T o(int paramInt)
  {
    aehv localaehv = c(paramInt);
    if (localaehv == null) {
      return null;
    }
    Object localObject1;
    if (localaehv.isAccountRelated())
    {
      localObject1 = MobileQQ.sMobileQQ.getFirstSimpleAccount();
      if (localObject1 == null) {}
    }
    int i;
    for (long l = b(((SimpleAccount)localObject1).getUin(), localaehv.isAccountRelated());; l = 0L)
    {
      localObject1 = a(l);
      i = ((SharedPreferences)localObject1).getInt(String.valueOf(paramInt), -1);
      if (i != -1) {
        break;
      }
      return a(localaehv, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "Can not get an runtime.May be in a process of none appRuntime.");
      }
      return a(localaehv, 1);
    }
    ??? = (aeif.a)this.jT.get(Integer.valueOf(paramInt));
    if ((??? != null) && (((aeif.a)???).version == i) && (((aeif.a)???).uin == l) && (((aeif.a)???).du != null)) {
      return ((aeif.a)???).du;
    }
    if (((SharedPreferences)localObject1).getBoolean(localaehv.type() + "_" + i + "_defualt", false)) {
      return a(localaehv, 0);
    }
    Object localObject3;
    for (;;)
    {
      synchronized (r[(paramInt % 5)])
      {
        if (localaehv.isNeedStoreLargeFile())
        {
          localObject1 = a(paramInt, l);
          if (localObject1 != null) {
            break;
          }
          localObject1 = newInstance(localaehv.clazz());
          return localObject1;
        }
      }
      localObject3 = b(paramInt, l);
    }
    try
    {
      Object localObject5 = localaehv.onParsed((aeic[])localObject3);
      this.jT.put(Integer.valueOf(paramInt), new aeif.a(l, i, localObject5));
      return localObject5;
    }
    catch (Exception localException)
    {
      aeig.a().a(localaehv, (aeic[])localObject3, i, localException);
      localObject3 = newInstance(localaehv.clazz());
    }
    return localObject3;
  }
  
  public int q(int paramInt, String paramString)
  {
    aehv localaehv = a(paramInt);
    if (localaehv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QConfigManager", 2, "getConfVersion, process is null, type=" + paramInt);
      }
      return -1;
    }
    return a(localaehv, paramInt, b(paramString, localaehv.isAccountRelated()));
  }
  
  static final class a
  {
    public final Object du;
    public final long uin;
    public final int version;
    
    a(long paramLong, int paramInt, Object paramObject)
    {
      this.uin = paramLong;
      this.version = paramInt;
      this.du = paramObject;
    }
  }
  
  static final class b
  {
    public static final aeif a = new aeif();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeif
 * JD-Core Version:    0.7.0.1
 */