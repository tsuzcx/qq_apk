package com.tencent.qapmsdk.common.util;

import alkz;
import alla;
import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/PhoneUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class PhoneUtil
{
  public static final Companion Companion = new Companion(null);
  private static final String ETH_MAC_ADDRESS = "/sys/class/net/eth1/address";
  private static final String WLAN_MAC_ADDRESS = "/sys/class/net/wlan0/address";
  private static String deviceId = "";
  
  @JvmStatic
  @NotNull
  public static final String generateDeviceId(@Nullable Application paramApplication)
  {
    return Companion.generateDeviceId(paramApplication);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/PhoneUtil$Companion;", "", "()V", "ETH_MAC_ADDRESS", "", "WLAN_MAC_ADDRESS", "deviceId", "generateDeviceId", "app", "Landroid/app/Application;", "getMacAddress", "context", "Landroid/content/Context;", "getMacAddressFromNetworkInterface", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final String getMacAddress(Context paramContext)
    {
      Object localObject2 = null;
      Object localObject1 = paramContext.getSystemService("wifi");
      paramContext = (Context)localObject1;
      if (!(localObject1 instanceof WifiManager)) {
        paramContext = null;
      }
      localObject1 = (WifiManager)paramContext;
      paramContext = localObject2;
      if (localObject1 != null) {}
      try
      {
        localObject1 = alkz.a((WifiManager)localObject1);
        paramContext = localObject2;
        if (localObject1 != null)
        {
          if (alkz.c((WifiInfo)localObject1) != null)
          {
            paramContext = (Iterable)CollectionsKt.listOf(new String[] { "", "02:00:00:00:00:00" });
            if ((!(paramContext instanceof Collection)) || (!((Collection)paramContext).isEmpty())) {
              break label172;
            }
            i = 0;
            if (i == 0) {
              break label230;
            }
          }
          paramContext = FileUtil.Companion.readOutputFromFile("/sys/class/net/wlan0/address");
          if (((CharSequence)paramContext).length() != 0) {
            break label217;
          }
          i = 1;
          if (i != 0)
          {
            paramContext = FileUtil.Companion.readOutputFromFile("/sys/class/net/eth1/address");
            if (((CharSequence)paramContext).length() != 0) {
              break label222;
            }
            i = 1;
            if (i != 0)
            {
              paramContext = ((Companion)this).getMacAddressFromNetworkInterface();
              if (paramContext == null) {
                break label227;
              }
            }
          }
        }
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          localObject1 = null;
          continue;
          label172:
          paramContext = paramContext.iterator();
          for (;;)
          {
            if (paramContext.hasNext()) {
              if (Intrinsics.areEqual((String)paramContext.next(), alkz.c((WifiInfo)localObject1)))
              {
                i = 1;
                break;
              }
            }
          }
          int i = 0;
          continue;
          label217:
          i = 0;
          continue;
          label222:
          i = 0;
        }
      }
      label227:
      return "02:00:00:00:00:00";
      label230:
      return alkz.c((WifiInfo)localObject1);
    }
    
    /* Error */
    private final String getMacAddressFromNetworkInterface()
    {
      // Byte code:
      //   0: invokestatic 129	alkz:getNetworkInterfaces	()Ljava/util/Enumeration;
      //   3: astore 4
      //   5: aload 4
      //   7: ifnull +145 -> 152
      //   10: aload 4
      //   12: invokeinterface 134 1 0
      //   17: ifeq +202 -> 219
      //   20: aload 4
      //   22: invokeinterface 137 1 0
      //   27: checkcast 139	java/net/NetworkInterface
      //   30: astore 5
      //   32: aload 5
      //   34: ldc 141
      //   36: invokestatic 145	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   39: aload 5
      //   41: invokestatic 148	alkz:a	(Ljava/net/NetworkInterface;)[B
      //   44: astore 6
      //   46: aload 6
      //   48: ifnull -38 -> 10
      //   51: aload 6
      //   53: arraylength
      //   54: ifne +104 -> 158
      //   57: iconst_1
      //   58: istore_2
      //   59: iload_2
      //   60: ifne -50 -> 10
      //   63: new 150	java/lang/StringBuilder
      //   66: dup
      //   67: invokespecial 151	java/lang/StringBuilder:<init>	()V
      //   70: astore 7
      //   72: aload 6
      //   74: arraylength
      //   75: istore_3
      //   76: iconst_0
      //   77: istore_2
      //   78: iload_2
      //   79: iload_3
      //   80: if_icmpge +83 -> 163
      //   83: aload 6
      //   85: iload_2
      //   86: baload
      //   87: istore_1
      //   88: getstatic 157	kotlin/jvm/internal/StringCompanionObject:INSTANCE	Lkotlin/jvm/internal/StringCompanionObject;
      //   91: astore 8
      //   93: iconst_1
      //   94: anewarray 4	java/lang/Object
      //   97: astore 8
      //   99: aload 8
      //   101: iconst_0
      //   102: iload_1
      //   103: invokestatic 163	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
      //   106: aastore
      //   107: ldc 165
      //   109: aload 8
      //   111: aload 8
      //   113: arraylength
      //   114: invokestatic 171	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
      //   117: invokestatic 175	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   120: astore 8
      //   122: aload 8
      //   124: ldc 177
      //   126: invokestatic 145	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   129: aload 7
      //   131: aload 8
      //   133: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   136: pop
      //   137: iload_2
      //   138: iconst_1
      //   139: iadd
      //   140: istore_2
      //   141: goto -63 -> 78
      //   144: astore 4
      //   146: aconst_null
      //   147: astore 4
      //   149: goto -144 -> 5
      //   152: aconst_null
      //   153: areturn
      //   154: astore 4
      //   156: aconst_null
      //   157: areturn
      //   158: iconst_0
      //   159: istore_2
      //   160: goto -101 -> 59
      //   163: aload 7
      //   165: checkcast 95	java/lang/CharSequence
      //   168: invokeinterface 99 1 0
      //   173: ifle +41 -> 214
      //   176: iconst_1
      //   177: istore_2
      //   178: iload_2
      //   179: ifeq +16 -> 195
      //   182: aload 7
      //   184: aload 7
      //   186: invokevirtual 182	java/lang/StringBuilder:length	()I
      //   189: iconst_1
      //   190: isub
      //   191: invokevirtual 186	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
      //   194: pop
      //   195: aload 5
      //   197: invokevirtual 189	java/net/NetworkInterface:getName	()Ljava/lang/String;
      //   200: ldc 191
      //   202: invokestatic 123	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   205: ifeq -195 -> 10
      //   208: aload 7
      //   210: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: areturn
      //   214: iconst_0
      //   215: istore_2
      //   216: goto -38 -> 178
      //   219: aconst_null
      //   220: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	221	0	this	Companion
      //   87	16	1	b	byte
      //   58	158	2	i	int
      //   75	6	3	j	int
      //   3	18	4	localEnumeration	java.util.Enumeration
      //   144	1	4	localSocketException1	java.net.SocketException
      //   147	1	4	localObject1	Object
      //   154	1	4	localSocketException2	java.net.SocketException
      //   30	166	5	localNetworkInterface	java.net.NetworkInterface
      //   44	40	6	arrayOfByte	byte[]
      //   70	139	7	localStringBuilder	java.lang.StringBuilder
      //   91	41	8	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   0	5	144	java/net/SocketException
      //   32	46	154	java/net/SocketException
    }
    
    @JvmStatic
    @NotNull
    public final String generateDeviceId(@Nullable Application paramApplication)
    {
      if ((!TextUtils.isEmpty((CharSequence)PhoneUtil.access$getDeviceId$cp())) || (paramApplication == null)) {
        return PhoneUtil.access$getDeviceId$cp();
      }
      Object localObject1 = (Companion)this;
      Object localObject2 = paramApplication.getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.applicationContext");
      localObject1 = ((Companion)localObject1).getMacAddress((Context)localObject2);
      if (localObject1 != null) {}
      try
      {
        for (;;)
        {
          localObject2 = paramApplication.getApplicationContext();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.applicationContext");
          localObject2 = alla.getString(((Context)localObject2).getContentResolver(), "android_id");
          try
          {
            Object localObject3 = paramApplication.getApplicationContext().getSystemService("phone");
            paramApplication = localObject3;
            if (!(localObject3 instanceof TelephonyManager)) {
              paramApplication = null;
            }
            paramApplication = (TelephonyManager)paramApplication;
            if (paramApplication == null) {
              break;
            }
            paramApplication = alla.a(paramApplication);
            if (paramApplication == null) {
              break;
            }
          }
          catch (SecurityException paramApplication)
          {
            for (;;)
            {
              String str;
              paramApplication = "0";
            }
          }
          catch (Throwable paramApplication)
          {
            for (;;)
            {
              paramApplication = "0";
            }
          }
          PhoneUtil.access$setDeviceId$cp(StringUtil.Companion.getMD5(Build.BRAND + Build.MODEL + (String)localObject2 + (String)localObject1 + paramApplication));
          return PhoneUtil.access$getDeviceId$cp();
          localObject1 = "";
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          str = "";
          continue;
          paramApplication = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.PhoneUtil
 * JD-Core Version:    0.7.0.1
 */