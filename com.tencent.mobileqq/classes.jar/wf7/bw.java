package wf7;

import android.net.wifi.WifiConfiguration;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bw
{
  private static boolean gv = false;
  private static Field gw;
  private static Field gx;
  private static Class gy;
  private static Field gz;
  
  public static WifiConfiguration a(int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if (localWifiConfiguration.networkId == paramInt) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((cb.j(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (cb.d(localWifiConfiguration) == paramInt)) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static final bw as()
  {
    return bw.b.gF;
  }
  
  /* Error */
  public static int b(WifiConfiguration paramWifiConfiguration)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: getfield 86	android/net/wifi/WifiConfiguration:status	I
    //   10: iconst_1
    //   11: if_icmpne -7 -> 4
    //   14: getstatic 16	wf7/bw:gv	Z
    //   17: ifne +73 -> 90
    //   20: iconst_1
    //   21: putstatic 16	wf7/bw:gv	Z
    //   24: ldc 40
    //   26: ldc 88
    //   28: invokevirtual 94	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   31: putstatic 96	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   34: getstatic 96	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   37: iconst_1
    //   38: invokevirtual 102	java/lang/reflect/Field:setAccessible	(Z)V
    //   41: getstatic 96	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   44: ifnonnull +46 -> 90
    //   47: ldc 40
    //   49: ldc 104
    //   51: invokevirtual 94	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   54: putstatic 106	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   57: getstatic 106	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   60: iconst_1
    //   61: invokevirtual 102	java/lang/reflect/Field:setAccessible	(Z)V
    //   64: ldc 108
    //   66: invokestatic 112	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   69: putstatic 80	wf7/bw:gy	Ljava/lang/Class;
    //   72: getstatic 80	wf7/bw:gy	Ljava/lang/Class;
    //   75: ldc 114
    //   77: invokevirtual 94	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   80: putstatic 116	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   83: getstatic 116	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   86: iconst_1
    //   87: invokevirtual 102	java/lang/reflect/Field:setAccessible	(Z)V
    //   90: getstatic 96	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   93: ifnull +35 -> 128
    //   96: getstatic 96	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   99: aload_0
    //   100: invokevirtual 120	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 122	java/lang/Integer
    //   106: invokevirtual 126	java/lang/Integer:intValue	()I
    //   109: istore_1
    //   110: iload_1
    //   111: ireturn
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 129	java/lang/Throwable:printStackTrace	()V
    //   117: goto -76 -> 41
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 129	java/lang/Throwable:printStackTrace	()V
    //   125: goto -35 -> 90
    //   128: getstatic 106	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   131: ifnull -127 -> 4
    //   134: getstatic 80	wf7/bw:gy	Ljava/lang/Class;
    //   137: ifnull -133 -> 4
    //   140: getstatic 116	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   143: ifnull -139 -> 4
    //   146: getstatic 106	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   149: aload_0
    //   150: invokevirtual 120	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore_0
    //   154: getstatic 116	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   157: aload_0
    //   158: invokevirtual 120	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 122	java/lang/Integer
    //   164: invokevirtual 126	java/lang/Integer:intValue	()I
    //   167: istore_2
    //   168: ldc 131
    //   170: invokestatic 136	wf7/bw$c:i	(Ljava/lang/String;)I
    //   173: bipush 13
    //   175: if_icmpge +17 -> 192
    //   178: iload_2
    //   179: ldc 138
    //   181: invokestatic 136	wf7/bw$c:i	(Ljava/lang/String;)I
    //   184: if_icmpne +70 -> 254
    //   187: iconst_1
    //   188: istore_1
    //   189: goto +59 -> 248
    //   192: iload_2
    //   193: ldc 140
    //   195: invokestatic 136	wf7/bw$c:i	(Ljava/lang/String;)I
    //   198: if_icmpne +61 -> 259
    //   201: iconst_1
    //   202: istore_1
    //   203: goto +45 -> 248
    //   206: iload_2
    //   207: ldc 142
    //   209: invokestatic 136	wf7/bw$c:i	(Ljava/lang/String;)I
    //   212: if_icmpne +5 -> 217
    //   215: iconst_1
    //   216: ireturn
    //   217: iload_2
    //   218: ldc 144
    //   220: invokestatic 136	wf7/bw$c:i	(Ljava/lang/String;)I
    //   223: if_icmpne +5 -> 228
    //   226: iconst_2
    //   227: ireturn
    //   228: ldc 146
    //   230: invokestatic 136	wf7/bw$c:i	(Ljava/lang/String;)I
    //   233: istore_1
    //   234: iload_2
    //   235: iload_1
    //   236: if_icmpne -232 -> 4
    //   239: iconst_4
    //   240: ireturn
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 129	java/lang/Throwable:printStackTrace	()V
    //   246: iconst_0
    //   247: ireturn
    //   248: iload_1
    //   249: ifeq -43 -> 206
    //   252: iconst_3
    //   253: ireturn
    //   254: iconst_0
    //   255: istore_1
    //   256: goto -8 -> 248
    //   259: iconst_0
    //   260: istore_1
    //   261: goto -13 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramWifiConfiguration	WifiConfiguration
    //   109	152	1	i	int
    //   167	70	2	j	int
    //   112	2	3	localThrowable1	java.lang.Throwable
    //   120	2	3	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   24	41	112	java/lang/Throwable
    //   47	90	120	java/lang/Throwable
    //   90	110	241	java/lang/Throwable
    //   128	187	241	java/lang/Throwable
    //   192	201	241	java/lang/Throwable
    //   206	215	241	java/lang/Throwable
    //   217	226	241	java/lang/Throwable
    //   228	234	241	java/lang/Throwable
  }
  
  public static bw.a c(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration == null) {
      return bw.a.gA;
    }
    if (paramWifiConfiguration.status == 1)
    {
      int i = b(paramWifiConfiguration);
      if (i == 0) {
        return bw.a.gA;
      }
      if (i == 3) {
        return bw.a.gB;
      }
      return bw.a.gC;
    }
    return bw.a.gC;
  }
  
  public boolean C(int paramInt)
  {
    boolean bool = false;
    if (ca.removeNetwork(paramInt))
    {
      bool = true;
      ca.saveConfiguration();
    }
    return bool;
  }
  
  public List<WifiConfiguration> at()
  {
    return ca.getConfiguredNetworks();
  }
  
  public List<WifiConfiguration> b(String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject3 = at();
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject3).next();
        if ((cb.j(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (cb.d(localWifiConfiguration) == paramInt))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localWifiConfiguration);
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  public boolean c(String paramString, int paramInt)
  {
    paramString = b(paramString, paramInt);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = paramString.iterator();
      for (boolean bool1 = false;; bool1 = C(((WifiConfiguration)paramString.next()).networkId) | bool1)
      {
        bool2 = bool1;
        if (!paramString.hasNext()) {
          break;
        }
      }
    }
    boolean bool2 = true;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.bw
 * JD-Core Version:    0.7.0.1
 */