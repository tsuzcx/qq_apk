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
    return b.gF;
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
    //   7: getfield 91	android/net/wifi/WifiConfiguration:status	I
    //   10: iconst_1
    //   11: if_icmpne -7 -> 4
    //   14: getstatic 25	wf7/bw:gv	Z
    //   17: ifne +73 -> 90
    //   20: iconst_1
    //   21: putstatic 25	wf7/bw:gv	Z
    //   24: ldc 48
    //   26: ldc 93
    //   28: invokevirtual 99	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   31: putstatic 101	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   34: getstatic 101	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   37: iconst_1
    //   38: invokevirtual 107	java/lang/reflect/Field:setAccessible	(Z)V
    //   41: getstatic 101	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   44: ifnonnull +46 -> 90
    //   47: ldc 48
    //   49: ldc 109
    //   51: invokevirtual 99	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   54: putstatic 111	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   57: getstatic 111	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   60: iconst_1
    //   61: invokevirtual 107	java/lang/reflect/Field:setAccessible	(Z)V
    //   64: ldc 113
    //   66: invokestatic 117	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   69: putstatic 86	wf7/bw:gy	Ljava/lang/Class;
    //   72: getstatic 86	wf7/bw:gy	Ljava/lang/Class;
    //   75: ldc 119
    //   77: invokevirtual 99	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   80: putstatic 121	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   83: getstatic 121	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   86: iconst_1
    //   87: invokevirtual 107	java/lang/reflect/Field:setAccessible	(Z)V
    //   90: getstatic 101	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   93: ifnull +35 -> 128
    //   96: getstatic 101	wf7/bw:gw	Ljava/lang/reflect/Field;
    //   99: aload_0
    //   100: invokevirtual 125	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 127	java/lang/Integer
    //   106: invokevirtual 131	java/lang/Integer:intValue	()I
    //   109: istore_1
    //   110: iload_1
    //   111: ireturn
    //   112: astore_3
    //   113: aload_3
    //   114: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   117: goto -76 -> 41
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
    //   125: goto -35 -> 90
    //   128: getstatic 111	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   131: ifnull -127 -> 4
    //   134: getstatic 86	wf7/bw:gy	Ljava/lang/Class;
    //   137: ifnull -133 -> 4
    //   140: getstatic 121	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   143: ifnull -139 -> 4
    //   146: getstatic 111	wf7/bw:gx	Ljava/lang/reflect/Field;
    //   149: aload_0
    //   150: invokevirtual 125	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore_0
    //   154: getstatic 121	wf7/bw:gz	Ljava/lang/reflect/Field;
    //   157: aload_0
    //   158: invokevirtual 125	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   161: checkcast 127	java/lang/Integer
    //   164: invokevirtual 131	java/lang/Integer:intValue	()I
    //   167: istore_2
    //   168: ldc 136
    //   170: invokestatic 139	wf7/bw$c:i	(Ljava/lang/String;)I
    //   173: bipush 13
    //   175: if_icmpge +17 -> 192
    //   178: iload_2
    //   179: ldc 141
    //   181: invokestatic 139	wf7/bw$c:i	(Ljava/lang/String;)I
    //   184: if_icmpne +70 -> 254
    //   187: iconst_1
    //   188: istore_1
    //   189: goto +59 -> 248
    //   192: iload_2
    //   193: ldc 143
    //   195: invokestatic 139	wf7/bw$c:i	(Ljava/lang/String;)I
    //   198: if_icmpne +61 -> 259
    //   201: iconst_1
    //   202: istore_1
    //   203: goto +45 -> 248
    //   206: iload_2
    //   207: ldc 145
    //   209: invokestatic 139	wf7/bw$c:i	(Ljava/lang/String;)I
    //   212: if_icmpne +5 -> 217
    //   215: iconst_1
    //   216: ireturn
    //   217: iload_2
    //   218: ldc 147
    //   220: invokestatic 139	wf7/bw$c:i	(Ljava/lang/String;)I
    //   223: if_icmpne +5 -> 228
    //   226: iconst_2
    //   227: ireturn
    //   228: ldc 149
    //   230: invokestatic 139	wf7/bw$c:i	(Ljava/lang/String;)I
    //   233: istore_1
    //   234: iload_2
    //   235: iload_1
    //   236: if_icmpne -232 -> 4
    //   239: iconst_4
    //   240: ireturn
    //   241: astore_0
    //   242: aload_0
    //   243: invokevirtual 134	java/lang/Throwable:printStackTrace	()V
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
    //   112	2	3	localThrowable1	Throwable
    //   120	2	3	localThrowable2	Throwable
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
  
  public static a c(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration == null) {
      return a.gA;
    }
    if (paramWifiConfiguration.status == 1)
    {
      int i = b(paramWifiConfiguration);
      if (i == 0) {
        return a.gA;
      }
      if (i == 3) {
        return a.gB;
      }
      return a.gC;
    }
    return a.gC;
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
  
  public static enum a
  {
    private static final String[] gD = { "", "UNKNOWN", "WRONG_PWD", "NOT_WRONG_PWD" };
    int dD;
    
    private a(int paramInt)
    {
      this.dD = paramInt;
    }
    
    public String toString()
    {
      return gD[this.dD];
    }
  }
  
  static abstract interface b
  {
    public static final bw gF = new bw();
  }
  
  public static class c
  {
    private static final String[] gG = { "NETWORK_SELECTION_ENABLED", "NETWORK_SELECTION_TEMPORARY_DISABLED", "NETWORK_SELECTION_PERMANENTLY_DISABLED" };
    public static final String[] gH = { "NETWORK_SELECTION_ENABLE", "NETWORK_SELECTION_DISABLED_BAD_LINK", "NETWORK_SELECTION_DISABLED_ASSOCIATION_REJECTION ", "NETWORK_SELECTION_DISABLED_AUTHENTICATION_FAILURE", "NETWORK_SELECTION_DISABLED_DHCP_FAILURE", "NETWORK_SELECTION_DISABLED_DNS_FAILURE", "NETWORK_SELECTION_DISABLED_WPS_START", "NETWORK_SELECTION_DISABLED_TLS_VERSION", "NETWORK_SELECTION_DISABLED_AUTHENTICATION_NO_CREDENTIALS", "NETWORK_SELECTION_DISABLED_NO_INTERNET", "NETWORK_SELECTION_DISABLED_BY_WIFI_MANAGER", "NETWORK_SELECTION_DISABLED_BY_USER_SWITCH", "NETWORK_SELECTION_DISABLED_BY_WRONG_PASSWORD" };
    
    public static int i(String paramString)
    {
      try
      {
        if (bw.au() == null) {
          bw.c(Class.forName("android.net.wifi.WifiConfiguration$NetworkSelectionStatus"));
        }
        paramString = bw.au().getDeclaredField(paramString);
        paramString.setAccessible(true);
        int i = ((Integer)paramString.get(null)).intValue();
        return i;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.bw
 * JD-Core Version:    0.7.0.1
 */