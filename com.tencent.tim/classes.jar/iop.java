import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public final class iop
{
  private static boolean TD;
  private static int arc = -1;
  private static long lB;
  private static Boolean p;
  private static Boolean q;
  
  public static boolean f(VideoAppInterface paramVideoAppInterface)
  {
    int i;
    if (!TD)
    {
      i = angh.ay(BaseApplicationImpl.getContext());
      if (i != 2) {
        break label26;
      }
      TD = false;
    }
    for (;;)
    {
      return TD;
      label26:
      if (i == 1) {
        TD = true;
      } else if (i == 0) {
        TD = true;
      }
    }
  }
  
  public static boolean g(VideoAppInterface paramVideoAppInterface)
  {
    int i;
    if (!TD)
    {
      i = angh.ay(BaseApplicationImpl.getContext());
      if (i != 2) {
        break label123;
      }
      long l1 = System.currentTimeMillis();
      if (l1 <= lB) {
        break label106;
      }
      long l2 = AudioHelper.elapsedRealtimeNanos();
      paramVideoAppInterface.sQ();
      long l3 = AudioHelper.elapsedRealtimeNanos();
      QLog.w("AEKitAbilityInfo", 1, "checkAEKitPagSoReady, getEffectLibPagSoLoadIsOk[" + TD + "], cost[" + (l3 - l2) + "]");
      lB = l1 + 30000L;
      TD = false;
    }
    for (;;)
    {
      return TD;
      label106:
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("AEKitAbilityInfo", 1, "tryDownloadPTULibPagSo, 频繁调用");
      break;
      label123:
      if (i == 1) {
        TD = true;
      } else if (i == 0) {
        TD = true;
      }
    }
  }
  
  public static boolean h(VideoAppInterface paramVideoAppInterface)
  {
    boolean bool = true;
    if (!uR())
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess machine power not support");
      return false;
    }
    if (arc != -1)
    {
      if (arc == 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    if (!g(paramVideoAppInterface))
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess machine so not ready");
      return false;
    }
    long l = AudioHelper.elapsedRealtimeNanos();
    bool = FeatureManager.Features.PAG.init();
    QLog.w("AEKitAbilityInfo", 1, "loadLibPag[" + TD + "], cost[" + (AudioHelper.elapsedRealtimeNanos() - l) + "]");
    if (!bool) {}
    for (arc = 1;; arc = 0)
    {
      QLog.w("AEKitAbilityInfo", 1, "hasLoadSoSuccess result:=" + arc);
      return bool;
    }
  }
  
  /* Error */
  public static boolean uQ()
  {
    // Byte code:
    //   0: ldc 126
    //   2: fstore_0
    //   3: iconst_1
    //   4: istore 8
    //   6: getstatic 128	iop:p	Ljava/lang/Boolean;
    //   9: ifnonnull +135 -> 144
    //   12: invokestatic 134	aqgz:getCpuNumber	()I
    //   15: istore 7
    //   17: ldc 136
    //   19: invokestatic 142	jkn:dB	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: ldc 143
    //   26: fstore_2
    //   27: ldc 144
    //   29: fstore 5
    //   31: aload 9
    //   33: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifne +224 -> 260
    //   39: aload 9
    //   41: ldc 152
    //   43: invokevirtual 158	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   46: astore 9
    //   48: aload 9
    //   50: arraylength
    //   51: iconst_4
    //   52: if_icmplt +208 -> 260
    //   55: aload 9
    //   57: iconst_0
    //   58: aaload
    //   59: invokestatic 164	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   62: fstore_1
    //   63: fload_0
    //   64: fstore_3
    //   65: aload 9
    //   67: iconst_1
    //   68: aaload
    //   69: invokestatic 164	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   72: fstore 4
    //   74: fload_0
    //   75: fstore_3
    //   76: fload 4
    //   78: fstore_2
    //   79: aload 9
    //   81: iconst_2
    //   82: aaload
    //   83: invokestatic 164	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   86: fstore_0
    //   87: fload_0
    //   88: fstore_3
    //   89: fload 4
    //   91: fstore_2
    //   92: aload 9
    //   94: iconst_3
    //   95: aaload
    //   96: invokestatic 164	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   99: fstore 6
    //   101: fload 6
    //   103: fstore_3
    //   104: fload 4
    //   106: fstore_2
    //   107: invokestatic 167	aqgz:getSystemTotalMemory	()J
    //   110: l2f
    //   111: fconst_1
    //   112: fmul
    //   113: ldc 168
    //   115: fdiv
    //   116: fstore 4
    //   118: invokestatic 173	imm:getMaxCpuFreq	()J
    //   121: l2f
    //   122: ldc 174
    //   124: fdiv
    //   125: fstore 5
    //   127: iload 7
    //   129: iconst_4
    //   130: if_icmpge +37 -> 167
    //   133: new 176	java/lang/Boolean
    //   136: dup
    //   137: iconst_0
    //   138: invokespecial 179	java/lang/Boolean:<init>	(Z)V
    //   141: putstatic 128	iop:p	Ljava/lang/Boolean;
    //   144: getstatic 128	iop:p	Ljava/lang/Boolean;
    //   147: invokevirtual 182	java/lang/Boolean:booleanValue	()Z
    //   150: ireturn
    //   151: astore 9
    //   153: ldc 126
    //   155: fstore_1
    //   156: aload 9
    //   158: invokevirtual 185	java/lang/NumberFormatException:printStackTrace	()V
    //   161: fload 5
    //   163: fstore_3
    //   164: goto -57 -> 107
    //   167: iload 7
    //   169: iconst_4
    //   170: if_icmplt +48 -> 218
    //   173: iload 7
    //   175: bipush 8
    //   177: if_icmpge +41 -> 218
    //   180: fload 4
    //   182: fload_1
    //   183: fcmpl
    //   184: iflt +28 -> 212
    //   187: fload 5
    //   189: fload_2
    //   190: fcmpl
    //   191: iflt +21 -> 212
    //   194: iconst_1
    //   195: istore 8
    //   197: new 176	java/lang/Boolean
    //   200: dup
    //   201: iload 8
    //   203: invokespecial 179	java/lang/Boolean:<init>	(Z)V
    //   206: putstatic 128	iop:p	Ljava/lang/Boolean;
    //   209: goto -65 -> 144
    //   212: iconst_0
    //   213: istore 8
    //   215: goto -18 -> 197
    //   218: fload 4
    //   220: fload_0
    //   221: fcmpl
    //   222: iflt +25 -> 247
    //   225: fload 5
    //   227: fload_3
    //   228: fcmpl
    //   229: iflt +18 -> 247
    //   232: new 176	java/lang/Boolean
    //   235: dup
    //   236: iload 8
    //   238: invokespecial 179	java/lang/Boolean:<init>	(Z)V
    //   241: putstatic 128	iop:p	Ljava/lang/Boolean;
    //   244: goto -100 -> 144
    //   247: iconst_0
    //   248: istore 8
    //   250: goto -18 -> 232
    //   253: astore 9
    //   255: fload_3
    //   256: fstore_0
    //   257: goto -101 -> 156
    //   260: ldc 126
    //   262: fstore_1
    //   263: fload 5
    //   265: fstore_3
    //   266: goto -159 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   2	255	0	f1	float
    //   62	201	1	f2	float
    //   26	164	2	f3	float
    //   64	202	3	f4	float
    //   72	147	4	f5	float
    //   29	235	5	f6	float
    //   99	3	6	f7	float
    //   15	163	7	i	int
    //   4	245	8	bool	boolean
    //   22	71	9	localObject	Object
    //   151	6	9	localNumberFormatException1	NumberFormatException
    //   253	1	9	localNumberFormatException2	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   55	63	151	java/lang/NumberFormatException
    //   65	74	253	java/lang/NumberFormatException
    //   79	87	253	java/lang/NumberFormatException
    //   92	101	253	java/lang/NumberFormatException
  }
  
  public static boolean uR()
  {
    Object localObject;
    float f1;
    if (q == null)
    {
      localObject = jkn.dB("ptuAfterTreamentLimit");
      f3 = 3.0F;
      j = 4;
      f4 = 1.1F;
      f2 = f4;
      i = j;
      f1 = f3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(";");
        f2 = f4;
        i = j;
        f1 = f3;
        if (localObject.length >= 3)
        {
          i = j;
          f1 = f3;
        }
      }
    }
    try
    {
      f2 = Float.parseFloat(localObject[0]);
      i = j;
      f1 = f2;
      j = Integer.parseInt(localObject[1]);
      i = j;
      f1 = f2;
      f3 = Float.parseFloat(localObject[2]);
      f1 = f2;
      i = j;
      f2 = f3;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int k;
        localNumberFormatException.printStackTrace();
        f2 = f4;
        continue;
        q = new Boolean(false);
        continue;
        i = 0;
        continue;
        boolean bool = false;
      }
    }
    float f3 = (float)aqgz.getSystemTotalMemory() * 1.0F / 1.073742E+009F;
    int j = aqgz.getCpuNumber();
    f4 = (float)imm.getMaxCpuFreq() / 1048576.0F;
    if ((f1 <= f3) && (i <= j) && (f2 <= f4))
    {
      q = new Boolean(true);
      k = q.booleanValue();
      if (angh.ay(BaseApplicationImpl.getContext()) == 0) {
        break label246;
      }
      i = 1;
      if (((i & k) == 0) || (Build.VERSION.SDK_INT < 21)) {
        break label252;
      }
      bool = true;
      q = Boolean.valueOf(bool);
      return q.booleanValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iop
 * JD-Core Version:    0.7.0.1
 */